/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0032Event.java
*@FileTitle      : Office QTA Summary
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.22 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.10.06 김용습 [CHM-201538196] Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmCfmQtaPotnMgmtVO;

/**
 * ESM_SQM_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0032HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0032Event extends EventSupport {

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

	public EsmSqm0032Event(){}
	
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
		if(sqmCfmQtaPotnMgmtVOs != null){
			this.sqmCfmQtaPotnMgmtVOs = new SqmCfmQtaPotnMgmtVO[sqmCfmQtaPotnMgmtVOs.length];
			for(int i=0; i<sqmCfmQtaPotnMgmtVOs.length; ++i){
				this.sqmCfmQtaPotnMgmtVOs[i] = sqmCfmQtaPotnMgmtVOs[i];
			}
		}
	}

	public SqmCfmQtaPotnMgmtVO getSqmCfmQtaPotnMgmtVO(){
		return sqmCfmQtaPotnMgmtVO;
	}

	public SqmCfmQtaPotnMgmtVO[] getSqmCfmQtaPotnMgmtVOS(){
		SqmCfmQtaPotnMgmtVO[] ret = null;
		if(this.sqmCfmQtaPotnMgmtVOs != null){
			ret = new SqmCfmQtaPotnMgmtVO[sqmCfmQtaPotnMgmtVOs.length];
			for(int i=0; i<sqmCfmQtaPotnMgmtVOs.length; i++){
				ret[i] = this.sqmCfmQtaPotnMgmtVOs[i];
			}
		}
		return ret;
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
		if(searchPotnAdjustmentListVOs != null){
			this.searchPotnAdjustmentListVOs = new SearchPotnAdjustmentListVO[searchPotnAdjustmentListVOs.length];
			for(int i=0; i<searchPotnAdjustmentListVOs.length; ++i){
				this.searchPotnAdjustmentListVOs[i] = searchPotnAdjustmentListVOs[i];
			}
		}
	}

	public SearchPotnAdjustmentListVO getSearchPotnAdjustmentListVO(){
		return searchPotnAdjustmentListVO;
	}

	public SearchPotnAdjustmentListVO[] getSearchPotnAdjustmentListVOS(){
		SearchPotnAdjustmentListVO[] ret = null;
		if(this.searchPotnAdjustmentListVOs != null){
			ret = new SearchPotnAdjustmentListVO[searchPotnAdjustmentListVOs.length];
			for(int i=0; i<searchPotnAdjustmentListVOs.length; i++){
				ret[i] = this.searchPotnAdjustmentListVOs[i];
			}
		}
		return ret;
	}
}