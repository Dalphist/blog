package com.djf.repository.wrapper;

import java.util.List;

import com.djf.vo.TagVO;

/**
 * @author shimh
 * <p>
 * 2018年1月25日
 */
public interface TagWrapper {

    List<TagVO> findAllDetail();

    TagVO getTagDetail(Integer tagId);
}
