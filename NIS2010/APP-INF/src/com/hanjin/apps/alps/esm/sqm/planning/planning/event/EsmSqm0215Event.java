/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmSqm0215Event.java
*@FileTitle      : QTA Set up for IAS Sector by Head Office_Add-Freezing
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.12.06 [CHM-201539010] Add Freezing Validation 수정
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.vo.SearchQtaLoadRevForSectorAddListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SQM_0215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0215HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0215Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** VO Object 조회 조건 및 단건 처리  */
	private SearchQtaLoadRevForSectorAddListVO sqmQtaLodRevForSectorAddListVO = null;

	/** VO Object Multi Data 처리 */
	private SearchQtaLoadRevForSectorAddListVO[] sqmQtaLodRevForSectorAddListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmSqm0215Event(){}


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
		SearchQtaLoadRevForSectorAddListVO[] ret = null;
		if(this.sqmQtaLodRevForSectorAddListVOs != null){
			ret = new SearchQtaLoadRevForSectorAddListVO[sqmQtaLodRevForSectorAddListVOs.length];
			for(int i=0; i<sqmQtaLodRevForSectorAddListVOs.length; i++){
				ret[i] = this.sqmQtaLodRevForSectorAddListVOs[i];
			}
		}
		return ret;
	}


	/**
	 * @param sqmQtaLodRevForSectorAddListVOs the sqmQtaLodRevForSectorAddListVOs to set
	 */
	public void setSqmQtaLodRevForSectorAddListVOs(
			SearchQtaLoadRevForSectorAddListVO[] sqmQtaLodRevForSectorAddListVOs) {
		if(sqmQtaLodRevForSectorAddListVOs != null){
			this.sqmQtaLodRevForSectorAddListVOs = new SearchQtaLoadRevForSectorAddListVO[sqmQtaLodRevForSectorAddListVOs.length];
			for(int i=0; i<sqmQtaLodRevForSectorAddListVOs.length; ++i){
				this.sqmQtaLodRevForSectorAddListVOs[i] = sqmQtaLodRevForSectorAddListVOs[i];
			}
		}
	}



}