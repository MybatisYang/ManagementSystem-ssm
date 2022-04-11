package com.dao;

import com.pojo.Content;

import java.util.List;

/**
 * @author zjzhou
 * @version 1.0
 */

public interface ContentDao {

    int addContent(Content content);

    int deleteContentById(long id);

    int updateContent(Content content);

    Content queryById(long id);

    List<Content> queryAllContent();
}
