/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdSpe0001Event.java
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.07.23 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.event;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SpeEvGrpVO;


/**
 * ESD_SPE_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SPE_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESD_SPE_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdSpe0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpeEvGrpVO speEvGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpeEvGrpVO[] speEvGrpVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGIdListVO searchEGIdListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGIdListVO[] searchEGIdListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEGIdAllListVO searchEGIdAllListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchEGIdAllListVO[] searchEGIdAllListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEgidConditionVO searchEgidConditionVO = null;

	
	public EsdSpe0001Event(){}
	
	public void setSpeEvGrpVO(SpeEvGrpVO speEvGrpVO){
		this. speEvGrpVO = speEvGrpVO;
	}

	public void setSpeEvGrpVOS(SpeEvGrpVO[] speEvGrpVOs){
		this. speEvGrpVOs = speEvGrpVOs;
	}

	public void setSearchEGIdListVO(SearchEGIdListVO searchEGIdListVO){
		this. searchEGIdListVO = searchEGIdListVO;
	}

	public void setSearchEGIdListVOS(SearchEGIdListVO[] searchEGIdListVOs){
		this. searchEGIdListVOs = searchEGIdListVOs;
	}

	public void setSearchEGIdAllListVO(SearchEGIdAllListVO searchEGIdAllListVO) {
		this.searchEGIdAllListVO = searchEGIdAllListVO;
	}

	public void setSearchEGIdAllListVOs(SearchEGIdAllListVO[] searchEGIdAllListVOs) {
		this.searchEGIdAllListVOs = searchEGIdAllListVOs;
	}

	public void setSearchEgidConditionVO(SearchEgidConditionVO searchEgidConditionVO) {
		this.searchEgidConditionVO = searchEgidConditionVO;
	}

	public SpeEvGrpVO getSpeEvGrpVO(){
		return speEvGrpVO;
	}

	public SpeEvGrpVO[] getSpeEvGrpVOS(){
		return speEvGrpVOs;
	}

	public SearchEGIdListVO getSearchEGIdListVO(){
		return searchEGIdListVO;
	}

	public SearchEGIdListVO[] getSearchEGIdListVOS(){
		return searchEGIdListVOs;
	}
	
	public SearchEGIdAllListVO getSearchEGIdAllListVO() {
		return searchEGIdAllListVO;
	}
	
	public SearchEGIdAllListVO[] getSearchEGIdAllListVOs() {
		return searchEGIdAllListVOs;
	}
	
	public SearchEgidConditionVO getSearchEgidConditionVO() {
		return searchEgidConditionVO;
	}
}