/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmSqm0214Event.java
*@FileTitle      : QTA Set up for IAS Sector by Head Office_Add-Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SQM_0214 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0214HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0214HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0214Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** VO Object 조회 조건 및 단건 처리  */
	private SearchQtaLoadRevForSectorAddListVO sqmQtaLodRevForSectorAddListVO = null;

	/** VO Object Multi Data 처리 */
	private SearchQtaLoadRevForSectorAddListVO[] sqmQtaLodRevForSectorAddListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmSqm0214Event(){}


	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}


	/**
	 * @return the sqmQtaLodRevForSectorAddListVO
	 */
	public SearchQtaLoadRevForSectorAddListVO getSqmQtaLodRevForSectorAddListVO() {
		return sqmQtaLodRevForSectorAddListVO;
	}


	/**
	 * @param sqmQtaLodRevForSectorAddListVO the sqmQtaLodRevForSectorAddListVO to set
	 */
	public void setSqmQtaLodRevForSectorAddListVO(
			SearchQtaLoadRevForSectorAddListVO sqmQtaLodRevForSectorAddListVO) {
		this.sqmQtaLodRevForSectorAddListVO = sqmQtaLodRevForSectorAddListVO;
	}


	/**
	 * @return the sqmQtaLodRevForSectorAddListVOs
	 */
	public SearchQtaLoadRevForSectorAddListVO[] getSqmQtaLodRevForSectorAddListVOs() {
		return sqmQtaLodRevForSectorAddListVOs;
	}


	/**
	 * @param sqmQtaLodRevForSectorAddListVOs the sqmQtaLodRevForSectorAddListVOs to set
	 */
	public void setSqmQtaLodRevForSectorAddListVOs(
			SearchQtaLoadRevForSectorAddListVO[] sqmQtaLodRevForSectorAddListVOs) {
		this.sqmQtaLodRevForSectorAddListVOs = sqmQtaLodRevForSectorAddListVOs;
	}



}