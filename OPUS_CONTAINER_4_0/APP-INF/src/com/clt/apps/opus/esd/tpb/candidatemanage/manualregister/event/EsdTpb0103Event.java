/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb103Event.java
*@FileTitle : manualregister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 황건하
*@LastVersion : 1.0
* 2009.07.17 황건하
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.vo.SearchManualRegisterListVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ESD_TPB_103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchManualRegisterListVO searchManualRegisterListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchManualRegisterListVO[] searchManualRegisterListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CreateTPBCandidateVO createTPBCandidateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CreateTPBCandidateVO[] createTPBCandidateVOs = null;


	public EsdTpb0103Event(){}
	
	public void setSearchManualRegisterListVO(SearchManualRegisterListVO searchManualRegisterListVO){
		this. searchManualRegisterListVO = searchManualRegisterListVO;
	}

	public void setSearchManualRegisterListVOS(SearchManualRegisterListVO[] searchManualRegisterListVOs){
		if(searchManualRegisterListVOs != null){
			SearchManualRegisterListVO[] tmpVOs = Arrays.copyOf(searchManualRegisterListVOs, searchManualRegisterListVOs.length);
			this.searchManualRegisterListVOs = tmpVOs;
		}
	}

	public SearchManualRegisterListVO getSearchManualRegisterListVO(){
		return searchManualRegisterListVO;
	}

	public SearchManualRegisterListVO[] getSearchManualRegisterListVOS(){
		SearchManualRegisterListVO[] rtnVOs = null;
		if (this.searchManualRegisterListVOs != null) {
			rtnVOs = Arrays.copyOf(searchManualRegisterListVOs, searchManualRegisterListVOs.length);
		}
		return rtnVOs;
	}

	public CreateTPBCandidateVO getCreateTPBCandidateVO() {
		return createTPBCandidateVO;
	}

	public void setCreateTPBCandidateVO(CreateTPBCandidateVO createTPBCandidateVO) {
		this.createTPBCandidateVO = createTPBCandidateVO;
	}

	public CreateTPBCandidateVO[] getCreateTPBCandidateVOs() {
		CreateTPBCandidateVO[] rtnVOs = null;
		if (this.createTPBCandidateVOs != null) {
			rtnVOs = Arrays.copyOf(createTPBCandidateVOs, createTPBCandidateVOs.length);
		}
		return rtnVOs;
	}

	public void setCreateTPBCandidateVOs(CreateTPBCandidateVO[] createTPBCandidateVOs){
		if(createTPBCandidateVOs != null){
			CreateTPBCandidateVO[] tmpVOs = Arrays.copyOf(createTPBCandidateVOs, createTPBCandidateVOs.length);
			this.createTPBCandidateVOs = tmpVOs;
		}
	}

}