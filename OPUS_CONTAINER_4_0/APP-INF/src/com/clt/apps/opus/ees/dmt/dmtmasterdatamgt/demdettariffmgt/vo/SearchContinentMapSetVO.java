/**
 * 
 */

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * 
 */
public class SearchContinentMapSetVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    /* Column Info */
    private List<SearchContinent02VO> searchContinent02VO = null;
    
    /* Column Info */
    private List<SearchContinent03VO> searchContinent03VO = null;
    
    /* Column Info */
    private List<SearchContinent04VO> searchContinent04VO = null;
    
    /* Column Info */
    private List<SearchContinent05VO> searchContinent05VO = null;
    
    /* Column Info */
    private List<SearchContinent06VO> searchContinent06VO = null;

    /**
    * @return the searchContinent02VO
    */
    public List<SearchContinent02VO> getSearchContinent02VO() {
        return searchContinent02VO;
    }

    /**
    * @param searchContinent02VO the searchContinent02VO to set
    */
    public void setSearchContinent02VO(List<SearchContinent02VO> searchContinent02VO) {
        this.searchContinent02VO = searchContinent02VO;
    }

    /**
    * @return the searchContinent03VO
    */
    public List<SearchContinent03VO> getSearchContinent03VO() {
        return searchContinent03VO;
    }

    /**
    * @param searchContinent03VO the searchContinent03VO to set
    */
    public void setSearchContinent03VO(List<SearchContinent03VO> searchContinent03VO) {
        this.searchContinent03VO = searchContinent03VO;
    }

    /**
    * @return the searchContinent04VO
    */
    public List<SearchContinent04VO> getSearchContinent04VO() {
        return searchContinent04VO;
    }

    /**
    * @param searchContinent04VO the searchContinent04VO to set
    */
    public void setSearchContinent04VO(List<SearchContinent04VO> searchContinent04VO) {
        this.searchContinent04VO = searchContinent04VO;
    }

    /**
    * @return the searchContinent05VO
    */
    public List<SearchContinent05VO> getSearchContinent05VO() {
        return searchContinent05VO;
    }

    /**
    * @param searchContinent05VO the searchContinent05VO to set
    */
    public void setSearchContinent05VO(List<SearchContinent05VO> searchContinent05VO) {
        this.searchContinent05VO = searchContinent05VO;
    }

    /**
    * @return the searchContinent06VO
    */
    public List<SearchContinent06VO> getSearchContinent06VO() {
        return searchContinent06VO;
    }

    /**
    * @param searchContinent06VO the searchContinent06VO to set
    */
    public void setSearchContinent06VO(List<SearchContinent06VO> searchContinent06VO) {
        this.searchContinent06VO = searchContinent06VO;
    }

    public SearchContinentMapSetVO() {}
    
    @Override
    public HashMap<String, String> getColumnValues() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HashMap<String, String> getFieldNames() {
        // TODO Auto-generated method stub
        return null;
    }

}