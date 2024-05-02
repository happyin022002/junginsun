/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0016Event.java
*@FileTitle :  ACBM(Accessorial Cost Budget Management)Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : HYUN SUNG KIL 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchACBMInquiryVO;


/**
 * ESD_LEA_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HYUN SUNG KIL
 * @see ESD_LEA_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchACBMInquiryVO searchACBMInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchACBMInquiryVO[] searchACBMInquiryVOs = null;

	public EsdLea0016Event(){}
	
	public void setSearchACBMInquiryVO(SearchACBMInquiryVO searchACBMInquiryVO){
		this. searchACBMInquiryVO = searchACBMInquiryVO;
	}

	public void setSearchACBMInquiryVOS(SearchACBMInquiryVO[] searchACBMInquiryVOs){
		if(searchACBMInquiryVOs != null){
			SearchACBMInquiryVO[] tmpVOs = new SearchACBMInquiryVO[searchACBMInquiryVOs.length];
			System.arraycopy(searchACBMInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchACBMInquiryVOs = tmpVOs;
		}
	}

	public SearchACBMInquiryVO getSearchACBMInquiryVO(){
		return searchACBMInquiryVO;
	}

	public SearchACBMInquiryVO[] getSearchACBMInquiryVOS(){
		SearchACBMInquiryVO[] rtnVOs = null;
		if (this.searchACBMInquiryVOs != null) {
			rtnVOs = new SearchACBMInquiryVO[searchACBMInquiryVOs.length];
			System.arraycopy(searchACBMInquiryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}