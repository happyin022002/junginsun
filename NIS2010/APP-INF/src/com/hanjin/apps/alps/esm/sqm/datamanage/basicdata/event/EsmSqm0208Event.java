/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0208Event.java
*@FileTitle      :Basic Data Creation_Creation for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.07
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.07 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmDatRltVO;

/**
 * ESM_SQM_0208 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0208HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0208HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0208Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0208Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmDatRltVO sqmDatRltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmDatRltVO[] sqmDatRltVOs = null;
	
	public void setSqmDatRltVO(SqmDatRltVO sqmDatRltVO){
		this. sqmDatRltVO = sqmDatRltVO;
	}

	public void setSqmDatRltVOS(SqmDatRltVO[] sqmDatRltVOs){
		if(sqmDatRltVOs != null){
			this.sqmDatRltVOs = new SqmDatRltVO[sqmDatRltVOs.length];
			for(int i=0; i<sqmDatRltVOs.length; ++i){
				this.sqmDatRltVOs[i] = sqmDatRltVOs[i];
			}
		}
	}

	public SqmDatRltVO getSqmDatRltVO(){
		return sqmDatRltVO;
	}

	public SqmDatRltVO[] getSqmDatRltVOS(){
		SqmDatRltVO[] ret = null;
		if(this.sqmDatRltVOs != null){
			ret = new SqmDatRltVO[sqmDatRltVOs.length];
			for(int i=0; i<sqmDatRltVOs.length; i++){
				ret[i] = this.sqmDatRltVOs[i];
			}
		}
		return ret;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}