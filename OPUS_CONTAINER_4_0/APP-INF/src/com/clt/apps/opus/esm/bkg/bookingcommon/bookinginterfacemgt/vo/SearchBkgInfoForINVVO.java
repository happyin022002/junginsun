/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchBkgInfoForINVVO.java
*@FileTitle : SearchBkgInfoForINVVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.22 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookinginterfacemgt.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBkgInfoForINVVO {

	private List<SearchBkgInfoForINV_HdVO> searchBkgInfoForINV_HdVOs = null;
	private List<SearchBkgInfoForINV_CntrVO> searchBkgInfoForINV_CntrVOs = null;
	private List<SearchBkgInfoForINV_ChargeVO> searchBkgInfoForINV_ChargeVOs = null;
	
    
    public SearchBkgInfoForINVVO(){
        
    }
    
    /**
     * @return the searchBkgInfoForINV_HdVOs
     */
    public List<SearchBkgInfoForINV_HdVO> getSearchBkgInfoForINV_HdVOs() {
        return searchBkgInfoForINV_HdVOs;
    }

    
    /**
     * @param searchBkgInfoForINV_HdVOs the searchBkgInfoForINV_HdVOs to set
     */
    public void setSearchBkgInfoForINV_HdVOs(List<SearchBkgInfoForINV_HdVO> searchBkgInfoForINV_HdVOs) {
        this.searchBkgInfoForINV_HdVOs = searchBkgInfoForINV_HdVOs;
    }
    
    /**
     * @return the searchBkgInfoForINV_CntrVOs
     */
    public List<SearchBkgInfoForINV_CntrVO> getSearchBkgInfoForINV_CntrVOs() {
        return searchBkgInfoForINV_CntrVOs;
    }

    
    /**
     * @param searchBkgInfoForINV_CntrVOs the searchBkgInfoForINV_CntrVOs to set
     */
    public void setSearchBkgInfoForINV_CntrVOs(List<SearchBkgInfoForINV_CntrVO> searchBkgInfoForINV_CntrVOs) {
        this.searchBkgInfoForINV_CntrVOs = searchBkgInfoForINV_CntrVOs;
    }

    /**
     * @return the searchBkgInfoForINV_ChargeVOs
     */
    public List<SearchBkgInfoForINV_ChargeVO> getSearchBkgInfoForINV_ChargeVOs() {
        return searchBkgInfoForINV_ChargeVOs;
    }

    
    /**
     * @param searchBkgInfoForINV_ChargeVOs the searchBkgInfoForINV_ChargeVOs to set
     */
    public void setSearchBkgInfoForINV_ChargeVOs(List<SearchBkgInfoForINV_ChargeVO> searchBkgInfoForINV_ChargeVOs) {
        this.searchBkgInfoForINV_ChargeVOs = searchBkgInfoForINV_ChargeVOs;
    }
    
}
