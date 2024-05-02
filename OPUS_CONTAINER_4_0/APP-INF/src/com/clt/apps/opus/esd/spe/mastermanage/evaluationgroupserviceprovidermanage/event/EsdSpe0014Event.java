/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSpe0014Event.java
*@FileTitle : EG VS S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.03 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.event;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.vo.SearchEGSPManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.serviceprovidercategorymanage.vo.SearchVndrSeqVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpeEvGrpSvcProvMtchVO;


/**
 * ESD_SPE_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESD_SPE_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGSPManageVO searchEGSPManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGSPManageVO[] searchEGSPManageVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpeEvGrpSvcProvMtchVO speEvGrpSvcProvMtchVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpeEvGrpSvcProvMtchVO[] speEvGrpSvcProvMtchVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGIdAllListVO searchEGIdAllListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGIdAllListVO[] searchEGIdAllListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEgidConditionVO searchEgidConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVndrSeqVO searchVndrSeqVO = null;

	public EsdSpe0014Event(){}
	
	public void setSearchEGSPManageVO(SearchEGSPManageVO searchEGSPManageVO){
		this. searchEGSPManageVO = searchEGSPManageVO;
	}

	public void setSearchEGSPManageVOS(SearchEGSPManageVO[] searchEGSPManageVOs){
		this. searchEGSPManageVOs = searchEGSPManageVOs;
	}

	public void setSpeEvGrpSvcProvMtchVO(SpeEvGrpSvcProvMtchVO speEvGrpSvcProvMtchVO){
		this. speEvGrpSvcProvMtchVO = speEvGrpSvcProvMtchVO;
	}

	public void setSpeEvGrpSvcProvMtchVOS(SpeEvGrpSvcProvMtchVO[] speEvGrpSvcProvMtchVOs){
		this. speEvGrpSvcProvMtchVOs = speEvGrpSvcProvMtchVOs;
	}
	
	public void setSearchEgidConditionVO(SearchEgidConditionVO searchEgidConditionVO) {
		this.searchEgidConditionVO = searchEgidConditionVO;
	}

	public void setSearchEGIdAllListVO(SearchEGIdAllListVO searchEGIdAllListVO) {
		this.searchEGIdAllListVO = searchEGIdAllListVO;
	}
	
	public void setSearchEGIdAllListVOs(SearchEGIdAllListVO[] searchEGIdAllListVOs) {
		this.searchEGIdAllListVOs = searchEGIdAllListVOs;
	}

	public void setSearchVndrSeqVO(SearchVndrSeqVO searchVndrSeqVO) {
		this.searchVndrSeqVO = searchVndrSeqVO;
	}

	public SearchEGSPManageVO getSearchEGSPManageVO(){
		return searchEGSPManageVO;
	}

	public SearchEGSPManageVO[] getSearchEGSPManageVOS(){
		return searchEGSPManageVOs;
	}

	public SearchEGIdAllListVO getSearchEGIdAllListVO() {
		return searchEGIdAllListVO;
	}

	
	public SearchEGIdAllListVO[] getSearchEGIdAllListVOs() {
		return searchEGIdAllListVOs;
	}
	
	
	public SpeEvGrpSvcProvMtchVO getSpeEvGrpSvcProvMtchVO(){
		return speEvGrpSvcProvMtchVO;
	}

	public SpeEvGrpSvcProvMtchVO[] getSpeEvGrpSvcProvMtchVOS(){
		return speEvGrpSvcProvMtchVOs;
	}

	public SearchEgidConditionVO getSearchEgidConditionVO() {
		return searchEgidConditionVO;
	}
	
	public SearchVndrSeqVO getSearchVndrSeqVO() {
		return searchVndrSeqVO;
	}
}