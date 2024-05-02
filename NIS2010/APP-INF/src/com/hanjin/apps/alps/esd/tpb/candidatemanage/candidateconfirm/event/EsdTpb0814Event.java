/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdTpb0814Event.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2011.11.15 박찬민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.event;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchNonTPBDescVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0814 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0814HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_TPB_0814HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0814Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCandidateListVO searchCandidateListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchNonTPBDescVO searchNonTPBDescVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCandidateListVO[] searchCandidateListVOs = null;
	
	private SearchNonTPBDescVO[] searchNonTPBDescVOs = null;

	public EsdTpb0814Event(){}
	
	public void setSearchNonTPBDescVO(SearchNonTPBDescVO searchNonTPBDescVO){
		this. searchNonTPBDescVO = searchNonTPBDescVO;
	}

	public void setSearchNonTPBDescVOS(SearchNonTPBDescVO[] searchNonTPBDescVOs){
		this. searchNonTPBDescVOs = searchNonTPBDescVOs;
	}

	public SearchNonTPBDescVO getSearchNonTPBDescVO(){
		return searchNonTPBDescVO;
	}

	public SearchNonTPBDescVO[] getSearchNonTPBDescVOS(){
		return searchNonTPBDescVOs;
	}
	
	public void setSearchCandidateListVO(SearchCandidateListVO searchCandidateListVO){
		this. searchCandidateListVO = searchCandidateListVO;
	}

	public void setSearchCandidateListVOS(SearchCandidateListVO[] searchCandidateListVOs){
		this. searchCandidateListVOs = searchCandidateListVOs;
	}

	public SearchCandidateListVO getSearchCandidateListVO(){
		return searchCandidateListVO;
	}

	public SearchCandidateListVO[] getSearchCandidateListVOS(){
		return searchCandidateListVOs;
	}

}