/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0043Event.java
*@FileTitle      : Portion Adjusted Figure Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.10.21
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.10.21 SQM USER
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmCfmQtaPotnMgmtVO;

/**
 * ESM_SQM_0043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0043HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0043Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmCfmQtaPotnMgmtVO sqmCfmQtaPotnMgmtVO = null;

	/** Table Value Object Multi Data 처리 */
	private SqmCfmQtaPotnMgmtVO[] sqmCfmQtaPotnMgmtVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchPotnAdjustmentListVO searchPotnAdjustmentListVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOs = null;


	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	String vvd = null;

	public EsmSqm0043Event(){}

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}

	public void setSqmCfmQtaPotnMgmtVO(SqmCfmQtaPotnMgmtVO sqmCfmQtaPotnMgmtVO){
		this. sqmCfmQtaPotnMgmtVO = sqmCfmQtaPotnMgmtVO;
	}

	public void setSqmCfmQtaPotnMgmtVOS(SqmCfmQtaPotnMgmtVO[] sqmCfmQtaPotnMgmtVOs){
		this. sqmCfmQtaPotnMgmtVOs = sqmCfmQtaPotnMgmtVOs;
	}

	public SqmCfmQtaPotnMgmtVO getSqmCfmQtaPotnMgmtVO(){
		return sqmCfmQtaPotnMgmtVO;
	}

	public SqmCfmQtaPotnMgmtVO[] getSqmCfmQtaPotnMgmtVOS(){
		return sqmCfmQtaPotnMgmtVOs;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}


	public void setSearchPotnAdjustmentListVO(SearchPotnAdjustmentListVO searchPotnAdjustmentListVO){
		this. searchPotnAdjustmentListVO = searchPotnAdjustmentListVO;
	}

	public void setSearchPotnAdjustmentListVOS(SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOs){
		this. searchPotnAdjustmentListVOs = searchPotnAdjustmentListVOs;
	}

	public SearchPotnAdjustmentListVO getSearchPotnAdjustmentListVO(){
		return searchPotnAdjustmentListVO;
	}

	public SearchPotnAdjustmentListVO[] getSearchPotnAdjustmentListVOS(){
		return searchPotnAdjustmentListVOs;
	}
}