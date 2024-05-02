/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0132Event.java
*@FileTitle : CodeManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.03 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.vo.SearchOfficeListForInquiryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0132 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0132HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0132HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0132Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOfficeListForInquiryVO[] searchOfficeListForInqiuryVOs = null;

	public EsdTpb0132Event(){}
	
	public void setSearchOfficeListForInqiuryVO(SearchOfficeListForInquiryVO searchOfficeListForInqiuryVO){
		this. searchOfficeListForInqiuryVO = searchOfficeListForInqiuryVO;
	}

	public void setSearchOfficeListForInqiuryVOS(SearchOfficeListForInquiryVO[] searchOfficeListForInqiuryVOs){
		if(searchOfficeListForInqiuryVOs != null){
			SearchOfficeListForInquiryVO[] tmpVOs = Arrays.copyOf(searchOfficeListForInqiuryVOs, searchOfficeListForInqiuryVOs.length);
			this.searchOfficeListForInqiuryVOs = tmpVOs;
		}
	}

	public SearchOfficeListForInquiryVO getSearchOfficeListForInqiuryVO(){
		return searchOfficeListForInqiuryVO;
	}

	public SearchOfficeListForInquiryVO[] getSearchOfficeListForInqiuryVOS(){
		SearchOfficeListForInquiryVO[] rtnVOs = null;
		if (this.searchOfficeListForInqiuryVOs != null) {
			rtnVOs = Arrays.copyOf(searchOfficeListForInqiuryVOs, searchOfficeListForInqiuryVOs.length);
		}
		return rtnVOs;
	}

}