package Interface;

import java.util.Map;

public interface Repository<T> {

     T create(T param);
     T edit(Map<String, String> params, String email);
     T remove();
     T listAll();
     T searchOne();
}
