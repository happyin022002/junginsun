/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0112Event.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-10-21 O Wan-Ki 			1.0	최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.event;

import com.hanjin.apps.alps.esd.tpb.jocasemanage.jocandidateconfirm.vo.SearchJOCandidateConfirmListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0122HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0122Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchJOCandidateConfirmListVO[] searchJOCandidateConfirmListVOs = null;

	public EsdTpb0122Event(){}
	
	public void setSearchJOCandidateConfirmListVO(SearchJOCandidateConfirmListVO searchJOCandidateConfirmListVO){
		this. searchJOCandidateConfirmListVO = searchJOCandidateConfirmListVO;
	}

	public void setSearchJOCandidateConfirmListVOS(SearchJOCandidateConfirmListVO[] searchJOCandidateConfirmListVOs){
		this. searchJOCandidateConfirmListVOs = searchJOCandidateConfirmListVOs;
	}

	public SearchJOCandidateConfirmListVO getSearchJOCandidateConfirmListVO(){
		return searchJOCandidateConfirmListVO;
	}

	public SearchJOCandidateConfirmListVO[] getSearchJOCandidateConfirmListVOS(){
		return searchJOCandidateConfirmListVOs;
	}

}