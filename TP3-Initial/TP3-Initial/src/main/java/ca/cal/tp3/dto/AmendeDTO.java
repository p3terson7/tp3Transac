package ca.cal.tp3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AmendeDTO {
    private long id;
    private long cltId;
    private double cout;
    private boolean paid;
}
