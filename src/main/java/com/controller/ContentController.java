package com.controller;

import com.pojo.Content;
import com.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zjzhou
 * @version 1.0
 */


@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    //显示所有内容
    @RequestMapping("/allContent")
    public String list(Model model) {
        List<Content> list = contentService.queryAllContent();
        model.addAttribute("list", list);
        return "allContent";
    }

    //新增内容
    @RequestMapping("toAddContent")
    public String toAddContent() {
        return "addContent";
    }

    @RequestMapping("/addContent")
    public String addContent(Content content) {
        contentService.addContent(content);
        return "redirect:/content/allContent";
    }

    //删除内容
    @RequestMapping("/del/{contentId}")
    public String deleteContent(@PathVariable("contentId") Long id) {
        contentService.deleteContentById(id);
        return "redirect:/content/allContent";
    }

    //更新内容
    @RequestMapping("toUpdateContent")
    public String toUpdateContent(Model model, Long id) {
        System.out.println(contentService.queryById(id).toString());
        model.addAttribute("content", contentService.queryById(id));
        return "updateContent";
    }

    @RequestMapping("/updateContent")
    public String updateContent(Model model, Content content) {
        contentService.updateContent(content);
        content = contentService.queryById(content.getContentId());
        model.addAttribute("content", content);
        return "redirect:/content/allContent";
    }
}
