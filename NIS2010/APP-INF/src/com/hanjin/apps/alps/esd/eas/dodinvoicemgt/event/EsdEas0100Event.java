/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdEas0100Event.java
*@FileTitle : EAS DOD Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier :  김종옥
*@LastVersion : 1.0
* 2013.09.11 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;
    

import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.EasAttentionVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchBKGCntrListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0100 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0100HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see ESD_EAS_0100HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0100Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String inBlNo = "";
	private String inPayerCd = "";
	private String inCustRgstNo = ""; 
	private String sessionOfcCd = "";
	private String trfOfc  = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DODInvoiceMainVO  dodInvoiceMainVO = null;
	private DODInvoiceDetailVO dodInvoiceDetailVO = null;
	private SearchBKGCntrListVO searchBKGCntrListVO = null;
	
	private EasAttentionVO 		easAttentionVO 		= null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchBKGCntrListVO[] searchBKGCntrListVOs = null;
	private DODInvoiceDetailVO[] dodInvoiceDetailVOs = null;
	
	public EsdEas0100Event(){}

    public String getInBlNo() {
        return inBlNo;
    }

    public void setInBlNo(String blNo) {
        inBlNo = blNo;
    }

    public String getInPayerCd() { 
        return inPayerCd;
    }

    public void setInPayerCd(String payerCd) {
    	inPayerCd = payerCd;
    }
    
    public String getInCustRgstNo() { 
        return inCustRgstNo;
    }

    public void setInCustRgstNo(String custRgstno) { 
    	inCustRgstNo = custRgstno;
    }
    
    public String getSessionOfcCd() {
        return sessionOfcCd;
    }

    public void setSessionOfcCd(String sessionOfcCd) {
    	//log.debug("\n ===========[Event] sessionOfcCd:"+sessionOfcCd);
    	this.sessionOfcCd = sessionOfcCd;
    }
    
    public String getTrfOfc() {
        return trfOfc;
    }

    public void setTrfOfc(String trfOfc) {
    	this.trfOfc = trfOfc;
    }
    
	public DODInvoiceMainVO getDodInvoiceMainVO() {
		return dodInvoiceMainVO;
	}

	public void setDodInvoiceMainVO(DODInvoiceMainVO dodInvoiceMainVO) {
		this.dodInvoiceMainVO = dodInvoiceMainVO;
	}


	public DODInvoiceDetailVO getDodInvoiceDetailVO() {
		return dodInvoiceDetailVO;
	}

	public void setDodInvoiceDetailVO(DODInvoiceDetailVO dodInvoiceDetailVO) {
		this.dodInvoiceDetailVO = dodInvoiceDetailVO;
	}
	
	

	public DODInvoiceDetailVO[] getDodInvoiceDetailVOs() {
		DODInvoiceDetailVO[] rtnVOs = null;
		if (this.dodInvoiceDetailVOs != null) {
			rtnVOs = new DODInvoiceDetailVO[dodInvoiceDetailVOs.length];
			System.arraycopy(dodInvoiceDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setDodInvoiceDetailVOs(DODInvoiceDetailVO[] dodInvoiceDetailVOs){
		if(dodInvoiceDetailVOs != null){
			DODInvoiceDetailVO[] tmpVOs = new DODInvoiceDetailVO[dodInvoiceDetailVOs.length];
			System.arraycopy(dodInvoiceDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dodInvoiceDetailVOs = tmpVOs;
		}
	}

	/* SearchBKGCntrListVO - start */
	public void setSearchBKGCntrListVO(SearchBKGCntrListVO searchBKGCntrListVO){
		this. searchBKGCntrListVO = searchBKGCntrListVO;
	}

	public void setSearchBKGCntrListVOs(SearchBKGCntrListVO[] searchBKGCntrListVOs){
		if(searchBKGCntrListVOs != null){
			SearchBKGCntrListVO[] tmpVOs = new SearchBKGCntrListVO[searchBKGCntrListVOs.length];
			System.arraycopy(searchBKGCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchBKGCntrListVOs = tmpVOs;
		}
	}
	

	public SearchBKGCntrListVO getSearchBKGCntrListVO(){
		return searchBKGCntrListVO;
	}

	public SearchBKGCntrListVO[] getSearchBKGCntrListVOS(){
		SearchBKGCntrListVO[] rtnVOs = null;
		if (this.searchBKGCntrListVOs != null) {
			rtnVOs = new SearchBKGCntrListVO[searchBKGCntrListVOs.length];
			System.arraycopy(searchBKGCntrListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	/* SearchBKGCntrListVO - end */

	public EasAttentionVO getEasAttentionVO() {
		return easAttentionVO;
	}

	public void setEasAttentionVO(EasAttentionVO easAttentionVO) {
		this.easAttentionVO = easAttentionVO;
	}	
	

}