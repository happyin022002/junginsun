/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsmSqm0213Event.java
*@FileTitle      : QTA Set up for IAS Sector by Head Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.09.22 김용습 [CHM-201537819] [CSR 전환건] QTA Set up by Head Office for IAS Sector 화면 내 Freezing, Add-Freezing 버튼 Validation 추가
* 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmSctrLodRevVO;


/**
 * ESM_SQM_0213 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SQM_0213HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0213HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0213Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmSctrLodRevVO sqmSctrLodRevVO = null;

	/** Table Value Object Multi Data 처리 */
	private SqmSctrLodRevVO[] sqmSctrLodRevVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;

	public EsmSqm0213Event(){}


	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}

	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	public void setSqmSctrLodRevVO(SqmSctrLodRevVO sqmSctrLodRevVO){
		this. sqmSctrLodRevVO = sqmSctrLodRevVO;
	}

	public void setSqmSctrLodRevVOS(SqmSctrLodRevVO[] sqmSctrLodRevVOs){
		if(sqmSctrLodRevVOs != null){
			this.sqmSctrLodRevVOs = new SqmSctrLodRevVO[sqmSctrLodRevVOs.length];
			for(int i=0; i<sqmSctrLodRevVOs.length; ++i){
				this.sqmSctrLodRevVOs[i] = sqmSctrLodRevVOs[i];
			}
		}
	}

	public SqmSctrLodRevVO getSqmSctrLodRevVO(){
		return sqmSctrLodRevVO;
	}

	public SqmSctrLodRevVO[] getSqmSctrLodRevVOS(){
		SqmSctrLodRevVO[] ret = null;
		if(this.sqmSctrLodRevVOs != null){
			ret = new SqmSctrLodRevVO[sqmSctrLodRevVOs.length];
			for(int i=0; i<sqmSctrLodRevVOs.length; i++){
				ret[i] = this.sqmSctrLodRevVOs[i];
			}
		}
		return ret;
	}

}