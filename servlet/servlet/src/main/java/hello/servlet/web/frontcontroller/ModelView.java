package hello.servlet.web.frontcontroller;
import java.util.HashMap;
import java.util.Map;

/**
 * *****V3 Model & View
 * Controller 에서 서블릿에 종속적인 HttpServletRequest 객체를 제거함 --> 서블릿 종속 제거
 * View 이름을 함께 전달함 --> 뷰 이름 중복 제거 (경로. .jsp 형식 이름)
 * 
 */
public class ModelView {
    private String viewName; // 뷰 이름
    private Map<String, Object> model = new HashMap<>(); // model 객체 - 뷰 렌더링 시 필요한 Data -> key, value 형식으로 삽입

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}