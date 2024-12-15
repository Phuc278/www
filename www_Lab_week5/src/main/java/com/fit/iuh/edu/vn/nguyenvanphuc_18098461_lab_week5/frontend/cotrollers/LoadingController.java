package com.fit.iuh.edu.vn.nguyenvanphuc_18098461_lab_week5.frontend.cotrollers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

// thay controller bằng Controller Advice
//@ControllerAdvice là một annotation trong Spring Framework,
// được sử dụng để xử lý các logic liên quan đến các controller
// của ứng dụng một cách tập trung và toàn cục
// ở đây giống như là sử dụng set biến này cho toàn bộ controller
@ControllerAdvice
public class LoadingController {

    //Đây là ép đường dẫn vào head Component để load ảnh
    //Vấn đề là nếu sử dụng getMapping thì không load ảnh được nếu không sử dụng
    //path của getMapping và thay vào đó là sử dụng @ModelAttribute
    //Vì nó sẽ addAtribute cho tất cả các controller
    //Và nếu controller đó trả về 1 trang html và có sử dụng component head thì nó sẽ nhận diện
    //được đường dẫn ảnh và load ảnh

    //Thay getMapping bằng ModelAttribute
    @ModelAttribute
    public void loadingImgIconPage(Model model){
        model.addAttribute("imgIconPath","/images/logowww.jpg");
    }
}
