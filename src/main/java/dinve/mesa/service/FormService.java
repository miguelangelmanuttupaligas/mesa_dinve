package dinve.mesa.service;

import dinve.mesa.converter.Formulario5ADatos;
import dinve.mesa.converter.Formulario5BDatos;
import dinve.mesa.model.Formulario;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface FormService {
    Map<String, Object> getAllForms(String token, Pageable pageable);
    Map<String, Object> getMyForms(String token, Pageable pageable);
    Map<String, Object> getMyUPForms(String token,Pageable pageable);
    String saveForm5A(String token, Formulario5ADatos formulario5ADatos);
    String saveForm5B(String token, Formulario5BDatos formulario5BDatos);
    String updateForm5A(String token, Formulario5ADatos formulario5ADatos);
    String updateForm5B(String token, Formulario5BDatos formulario5BDatos);
    String deleteForm(String token,Long id);
}
