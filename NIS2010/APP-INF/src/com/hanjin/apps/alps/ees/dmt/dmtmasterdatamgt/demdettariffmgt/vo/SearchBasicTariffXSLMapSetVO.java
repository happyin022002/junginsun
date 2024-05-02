/**
 * 
 */

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * 
 */
public class SearchBasicTariffXSLMapSetVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    /* Column Info */
    private List<SearchBasicTariffXSLVO> searchBasicTariffXSLVO = null;
    
    /* Column Info */
    private List<SearchBasicTariffXSL01VO> searchBasicTariffXSL01VO = null;
    
    /* Column Info */
    private List<SearchBasicTariffXSL02VO> searchBasicTariffXSL02VO = null;
    
    /* Column Info */
    private List<SearchBasicTariffXSLFreeTimeVO> searchBasicTariffXSLFreeTimeVO = null;
    
    /* Column Info */
    private List<SearchBasicTariffXSLRateVO> searchBasicTariffXSLRateVO = null;
    
    /**
    * @return the searchBasicTariffXSLVO
    */
    public List<SearchBasicTariffXSLVO> getSearchBasicTariffXSLVO() {
        return searchBasicTariffXSLVO;
    }

    /**
    * @param searchBasicTariffXSLVO the searchBasicTariffXSLVO to set
    */
    public void setSearchBasicTariffXSLVO(
            List<SearchBasicTariffXSLVO> searchBasicTariffXSLVO) {
        this.searchBasicTariffXSLVO = searchBasicTariffXSLVO;
    }

    /**
    * @return the searchBasicTariffXSL01VO
    */
    public List<SearchBasicTariffXSL01VO> getSearchBasicTariffXSL01VO() {
        return searchBasicTariffXSL01VO;
    }

    /**
    * @param searchBasicTariffXSL01VO the searchBasicTariffXSL01VO to set
    */
    public void setSearchBasicTariffXSL01VO(
            List<SearchBasicTariffXSL01VO> searchBasicTariffXSL01VO) {
        this.searchBasicTariffXSL01VO = searchBasicTariffXSL01VO;
    }

    /**
    * @return the searchBasicTariffXSL02VO
    */
    public List<SearchBasicTariffXSL02VO> getSearchBasicTariffXSL02VO() {
        return searchBasicTariffXSL02VO;
    }

    /**
    * @param searchBasicTariffXSL02VO the searchBasicTariffXSL02VO to set
    */
    public void setSearchBasicTariffXSL02VO(
            List<SearchBasicTariffXSL02VO> searchBasicTariffXSL02VO) {
        this.searchBasicTariffXSL02VO = searchBasicTariffXSL02VO;
    }

    /**
    * @return the searchBasicTariffXSLFreeTimeVO
    */
    public List<SearchBasicTariffXSLFreeTimeVO> getSearchBasicTariffXSLFreeTimeVO() {
        return searchBasicTariffXSLFreeTimeVO;
    }

    /**
    * @param searchBasicTariffXSLFreeTimeVO the searchBasicTariffXSLFreeTimeVO to set
    */
    public void setSearchBasicTariffXSLFreeTimeVO(
            List<SearchBasicTariffXSLFreeTimeVO> searchBasicTariffXSLFreeTimeVO) {
        this.searchBasicTariffXSLFreeTimeVO = searchBasicTariffXSLFreeTimeVO;
    }

    /**
    * @return the searchBasicTariffXSLRateVO
    */
    public List<SearchBasicTariffXSLRateVO> getSearchBasicTariffXSLRateVO() {
        return searchBasicTariffXSLRateVO;
    }

    /**
    * @param searchBasicTariffXSLRateVO the searchBasicTariffXSLRateVO to set
    */
    public void setSearchBasicTariffXSLRateVO(
            List<SearchBasicTariffXSLRateVO> searchBasicTariffXSLRateVO) {
        this.searchBasicTariffXSLRateVO = searchBasicTariffXSLRateVO;
    }

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
