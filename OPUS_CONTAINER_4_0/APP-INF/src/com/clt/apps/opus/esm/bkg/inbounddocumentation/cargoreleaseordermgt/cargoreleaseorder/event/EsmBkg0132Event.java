/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0132Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoSearchVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0132 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0132HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0132HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0132Event extends EventSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2261069293441189767L;

    /** Request No */
    private String rqstNo = "";
    /** Edo Type Code */
    private String tpCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EdoRqstsVO edoRqstsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EdoRqstsVO[] edoRqstsVOs = null;
	
	/** 검색조건 */
	private EdoSearchVO edoSearch = null;
	

	public EdoSearchVO getEdoSearchVO() {
		return edoSearch;
	}

	public void setEdoSearchVO(EdoSearchVO edoSearchVO) {
		this.edoSearch = edoSearchVO;
	}

	public EsmBkg0132Event(){}

	/**
	 * @return the edoRqstsVO
	 */
	public EdoRqstsVO getEdoRqstsVO() {
		return edoRqstsVO;
	}

	/**
	 * @param edoRqstsVO the edoRqstsVO to set
	 */
	public void setEdoRqstsVO(EdoRqstsVO edoRqstsVO) {
		this.edoRqstsVO = edoRqstsVO;
	}

	/**
	 * @return the BkgJapDoIssueListVOs
	 */
//	public EdoRqstsVO[] getEdoRqstsVOs() {
//		return edoRqstsVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public EdoRqstsVO[] getEdoRqstsVOs() {
		EdoRqstsVO[] tmpVOs = null;
		if (this.edoRqstsVOs != null) {
			tmpVOs = new EdoRqstsVO[edoRqstsVOs.length];
			System.arraycopy(edoRqstsVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	
	
	/**
	 * @param edoRqstsVOs the edoRqstsVOs to set
	 */
//	public void setEdoRqstsVOs(
//			EdoRqstsVO[] edoRqstsVOs) {
//		this.edoRqstsVOs = edoRqstsVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setEdoRqstsVOs(EdoRqstsVO[] edoRqstsVOs) {
		if (edoRqstsVOs != null) {
			EdoRqstsVO[] tmpVOs = new EdoRqstsVO[edoRqstsVOs.length];
			System.arraycopy(edoRqstsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.edoRqstsVOs = tmpVOs;
		}		
	} 
    
    /**
     * @return the rqstNo
     */
    public String getRqstNo() {
        return rqstNo;
    }

    /**
     * @param rqstNo the rqstNo to set
     */
    public void setRqstNo(String rqstNo) {
        this.rqstNo = rqstNo;
    }

    /**
     * @return the tpCd
     */
    public String getTpCd() {
        return tpCd;
    }

    /**
     * @param bkgNoSplit the bkgNoSplit to set
     */
    public void setTpCd(String tpCd) {
        this.tpCd = tpCd;
    }
	
}