/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb105Event.java
*@FileTitle : CandidateConfirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.codemanage.codemanage.vo.TesCodeManageCommonVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_105 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_105HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_1050HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0105Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCandidateListVO searchCandidateListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCandidateListVO[] searchCandidateListVOs = null;

	public EsdTpb0105Event(){}
	
	public void setSearchCandidateListVO(SearchCandidateListVO searchCandidateListVO){
		this. searchCandidateListVO = searchCandidateListVO;
	}

	public void setSearchCandidateListVOS(SearchCandidateListVO[] searchCandidateListVOs){
		if(searchCandidateListVOs != null){
			SearchCandidateListVO[] tmpVOs = Arrays.copyOf(searchCandidateListVOs, searchCandidateListVOs.length);
			this.searchCandidateListVOs = tmpVOs;
		}
	}

	public SearchCandidateListVO getSearchCandidateListVO(){
		return searchCandidateListVO;
	}

	public SearchCandidateListVO[] getSearchCandidateListVOS(){
		SearchCandidateListVO[] tempVOs = null;
		
		if (this.searchCandidateListVOs != null) {
			tempVOs = Arrays.copyOf(this.searchCandidateListVOs, this.searchCandidateListVOs.length);
		}
		return tempVOs;		
		
	}


}