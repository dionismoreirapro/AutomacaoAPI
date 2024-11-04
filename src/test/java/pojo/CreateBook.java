package pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class CreateBook {
    private String userId;
    private List<CollectionOfIsbns> collectionOfIsbns ;
}
