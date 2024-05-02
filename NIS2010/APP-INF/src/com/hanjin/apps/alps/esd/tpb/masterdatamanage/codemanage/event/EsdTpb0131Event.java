/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0101Event.java
*@FileTitle : TPB Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2008.08.29 O Wan-Ki 1.0 Creation
* 2009.07.02 황건하         1.1 ALPS Migration
* 2009.08.11 최 선             1.2 UI-ID 변경 (101->0101)
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.vo.SearchCodeInquiryListVO;

/**
 * ESD_TPB_0131 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0131HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0131HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0131Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCodeInquiryListVO searchCodeInquiryListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCodeInquiryListVO[] searchCodeInquiryListVOs = null;

	public EsdTpb0131Event(){}
	
	public void setSearchCodeInquiryListVO(SearchCodeInquiryListVO searchCodeInquiryListVO){
		this. searchCodeInquiryListVO = searchCodeInquiryListVO;
	}

	public void setSearchCodeInquiryListVOS(SearchCodeInquiryListVO[] searchCodeInquiryListVOs){
		this. searchCodeInquiryListVOs = searchCodeInquiryListVOs;
	}

	public SearchCodeInquiryListVO getSearchCodeInquiryListVO(){
		return searchCodeInquiryListVO;
	}

	public SearchCodeInquiryListVO[] getSearchCodeInquiryListVOS(){
		return searchCodeInquiryListVOs;
	}

}