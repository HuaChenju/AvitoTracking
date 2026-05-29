package org.example.service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.stereotype.Service;
import org.example.command.*;

import java.util.HashMap;
import java.util.List;

@Service
public class GoogleSheetsService {

    private final Sheets sheets;

    private final String spreadsheetId =
            "1EbXxYnzPTU4DHmGnmN0AO1KjF0dwmTQAIdAE124TzAM";

    public GoogleSheetsService(Sheets sheets) {
        this.sheets = sheets;
    }

    public boolean readSpreadsheetId() throws Exception {

        ValueRange response = sheets.spreadsheets()
                .values()
                .get(spreadsheetId, "test!A:C")
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            return false;
        }

        HashMap<String, CommandImpl> map = parseCommand(values);
        for (String key : map.keySet()) {
            map.get(key).commandExecute(key);
        }

        return true;
    }

    private HashMap<String, CommandImpl> parseCommand(List<List<Object>> values) throws Exception {

        HashMap<String, CommandImpl> map = new HashMap<>();
        for (List<Object> row : values) {
            if (row.size() == 2) {
                switch ((String) row.get(1)) {
                    case "add" ->
                            map.put(row.get(0).toString(), new AddCommand());

                    case "delete" ->
                            map.put(row.get(0).toString(), new DeleteCommand());

                    case "name+text+description+photo" ->
                            map.put(row.get(0).toString(), new UpdatePartCommand());

                    case "photo" ->
                            map.put(row.get(0).toString(), new UpdatePhotoCommand());

                    case "update" ->
                            map.put(row.get(0).toString(), new UpdateAllCommand());
                }

            }
        }

        return map;

    }
}