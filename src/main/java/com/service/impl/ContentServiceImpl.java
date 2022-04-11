package com.service.impl;

import com.dao.ContentDao;
import com.pojo.Content;
import com.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjzhou
 * @version 1.0
 */


@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentDao contentDao;

    public int addContent(Content content) {
        return contentDao.addContent(content);
    }

    public int deleteContentById(long id) {
        return contentDao.deleteContentById(id);
    }

    public int updateContent(Content content) {
        return contentDao.updateContent(content);
    }

    public Content queryById(long id) {
        return contentDao.queryById(id);
    }

    public List<Content> queryAllContent() {
        return contentDao.queryAllContent();
    }
}
