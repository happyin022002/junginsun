/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmCsq0215Event.java
*@FileTitle      : QTA Set up for IAS Sector by Head Office_Add-Freezing
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2014.01.23 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.event;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_CSQ_0215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_CSQ_0215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CSQ USER
 * @see ESM_CSQ_0215HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCsq0215Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** VO Object 조회 조건 및 단건 처리  */
	private SearchQtaLoadRevForSectorAddListVO csqQtaLodRevForSectorAddListVO = null;

	/** VO Object Multi Data 처리 */
	private SearchQtaLoadRevForSectorAddListVO[] csqQtaLodRevForSectorAddListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmCsq0215Event(){}


	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}


	/**
	 * @return the csqQtaLodRevForSectorAddListVO
	 */
	public SearchQtaLoadRevForSectorAddListVO getCsqQtaLodRevForSectorAddListVO() {
		return csqQtaLodRevForSectorAddListVO;
	}


	/**
	 * @param csqQtaLodRevForSectorAddListVO the csqQtaLodRevForSectorAddListVO to set
	 */
	public void setCsqQtaLodRevForSectorAddListVO(
			SearchQtaLoadRevForSectorAddListVO csqQtaLodRevForSectorAddListVO) {
		this.csqQtaLodRevForSectorAddListVO = csqQtaLodRevForSectorAddListVO;
	}


	/**
	 * @return the csqQtaLodRevForSectorAddListVOs
	 */
	public SearchQtaLoadRevForSectorAddListVO[] getCsqQtaLodRevForSectorAddListVOs() {
		return csqQtaLodRevForSectorAddListVOs;
	}


	/**
	 * @param csqQtaLodRevForSectorAddListVOs the csqQtaLodRevForSectorAddListVOs to set
	 */
	public void setCsqQtaLodRevForSectorAddListVOs(
			SearchQtaLoadRevForSectorAddListVO[] csqQtaLodRevForSectorAddListVOs) {
		this.csqQtaLodRevForSectorAddListVOs = csqQtaLodRevForSectorAddListVOs;
	}



}