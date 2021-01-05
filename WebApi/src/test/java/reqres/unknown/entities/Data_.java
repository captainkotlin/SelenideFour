package reqres.unknown.entities;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@lombok.Data
@JsonRootName(value = "data")
public class Data_
{
    private String id;
    private String name;
    private String year;
    private String color;
    private String pantone_value;
}
