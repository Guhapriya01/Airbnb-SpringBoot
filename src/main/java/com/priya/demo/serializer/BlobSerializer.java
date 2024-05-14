package com.priya.demo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class BlobSerializer extends JsonSerializer<Blob> {

    @Override
    public void serialize(Blob blob, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // Extract relevant information from the Blob and include it in the JSON output
        // For example, you can convert the Blob to a byte array and encode it as Base64
        byte[] data;
        String base64Data = "";
		try {
			data = blob.getBytes(1, (int) blob.length());
			base64Data = Base64.getEncoder().encodeToString(data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        jsonGenerator.writeString(base64Data);
    }
}
