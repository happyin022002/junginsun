/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0507Event.java
*@FileTitle      : SKD Adjustment by VVD
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.07.23 SQM USER
* 1.0 Creation
* 2015.09.01 김용습 [CHM-201536638] - Split08-2015년 소스 보안 품질 3단계 중 4차 작업 진행 요청
* 2015.11.09 김용습 [CHM-201538494] [CSR 전환건] SKD Adjustment by VVD 화면 보완 (Trade Direction, Adjusting VVD Select, BSA Flag 칼럼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0507 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0507HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0507HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0507Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0507Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	/** Table Value Object Multi Data 처리 */
	private ManageQtaAdjustmentVO[] manageQtaAdjustmentVOs = null;
	
	public void setManageQtaAdjustmentVOS(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOs){
		if(manageQtaAdjustmentVOs != null){
			this.manageQtaAdjustmentVOs = new ManageQtaAdjustmentVO[manageQtaAdjustmentVOs.length];
			for(int i=0; i<manageQtaAdjustmentVOs.length; ++i){
				this.manageQtaAdjustmentVOs[i] = manageQtaAdjustmentVOs[i];
			}
		}
	}
	
	public ManageQtaAdjustmentVO[] getManageQtaAdjustmentVOS(){
		ManageQtaAdjustmentVO[] ret = null;
		if(this.manageQtaAdjustmentVOs != null){
			ret = new ManageQtaAdjustmentVO[manageQtaAdjustmentVOs.length];
			for(int i=0; i<manageQtaAdjustmentVOs.length; i++){
				ret[i] = this.manageQtaAdjustmentVOs[i];
			}
		}
		return ret;
	}

}