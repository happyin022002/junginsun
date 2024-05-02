/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSpe0008Event.java
*@FileTitle : KPI Target
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.05 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.event;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetConditionVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetManageVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpeEvGrpKpiTgtRtoVO;


/**
 * ESD_SPE_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESD_SPE_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGKpiTargetManageVO searchEGKpiTargetManageVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGKpiTargetManageVO[] searchEGKpiTargetManageVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpeEvGrpKpiTgtRtoVO speEvGrpKpiTgtRtoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpeEvGrpKpiTgtRtoVO[] speEvGrpKpiTgtRtoVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGIdAllListVO searchEGIdAllListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchEGIdAllListVO[] searchEGIdAllListVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGKpiTargetConditionVO searchEGKpiTargetConditionVO = null;
	
	
	public EsdSpe0008Event(){}
	
	public void setSearchEGKpiTargetManageVO(SearchEGKpiTargetManageVO searchEGKpiTargetManageVO){
		this. searchEGKpiTargetManageVO = searchEGKpiTargetManageVO;
	}

	public void setSearchEGKpiTargetManageVOS(SearchEGKpiTargetManageVO[] searchEGKpiTargetManageVOs){
		this. searchEGKpiTargetManageVOs = searchEGKpiTargetManageVOs;
	}

	public void setSpeEvGrpKpiTgtRtoVO(SpeEvGrpKpiTgtRtoVO speEvGrpKpiTgtRtoVO){
		this. speEvGrpKpiTgtRtoVO = speEvGrpKpiTgtRtoVO;
	}

	public void setSpeEvGrpKpiTgtRtoVOS(SpeEvGrpKpiTgtRtoVO[] speEvGrpKpiTgtRtoVOs){
		this. speEvGrpKpiTgtRtoVOs = speEvGrpKpiTgtRtoVOs;
	}
	
	public void setSearchEGIdAllListVO(SearchEGIdAllListVO searchEGIdAllListVO) {
		this.searchEGIdAllListVO = searchEGIdAllListVO;
	}

	public void setSearchEGIdAllListVOs(SearchEGIdAllListVO[] searchEGIdAllListVOs) {
		this.searchEGIdAllListVOs = searchEGIdAllListVOs;
	}
	
	public void setSearchEGKpiTargetConditionVO(
			SearchEGKpiTargetConditionVO searchEGKpiTargetConditionVO) {
		this.searchEGKpiTargetConditionVO = searchEGKpiTargetConditionVO;
	}

	
	public SearchEGKpiTargetManageVO getSearchEGKpiTargetManageVO(){
		return searchEGKpiTargetManageVO;
	}

	public SearchEGKpiTargetManageVO[] getSearchEGKpiTargetManageVOS(){
		return searchEGKpiTargetManageVOs;
	}

	public SpeEvGrpKpiTgtRtoVO getSpeEvGrpKpiTgtRtoVO(){
		return speEvGrpKpiTgtRtoVO;
	}

	public SpeEvGrpKpiTgtRtoVO[] getSpeEvGrpKpiTgtRtoVOS(){
		return speEvGrpKpiTgtRtoVOs;
	}
	
	public SearchEGIdAllListVO getSearchEGIdAllListVO() {
		return searchEGIdAllListVO;
	}
	
	public SearchEGIdAllListVO[] getSearchEGIdAllListVOs() {
		return searchEGIdAllListVOs;
	}
	
	public SearchEGKpiTargetConditionVO getSearchEGKpiTargetConditionVO() {
		return searchEGKpiTargetConditionVO;
	}

	
}