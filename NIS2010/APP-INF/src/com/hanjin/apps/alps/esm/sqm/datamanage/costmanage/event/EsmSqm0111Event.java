/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0111Event.java
*@FileTitle      : Basic CMCB (CM Cost Per Box)_Add Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2016.07.28
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcCostVO;

/**
 * ESM_SQM_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0111Event(){}
	
	private ConditionVO conditionVO = null;
	
	private CommonVO commonVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
		
	
	/**
	 * @return the commonVO
	 */
	public CommonVO getCommonVO() {
		return commonVO;
	}

	/**
	 * @param commonVO the commonVO to set
	 */
	public void setCommonVO(CommonVO commonVO) {
		this.commonVO = commonVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmQtaLaneOfcCostVO sqmQtaLaneOfcCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs = null;
	
	public void setSqmQtaLaneOfcCostVO(SqmQtaLaneOfcCostVO sqmQtaLaneOfcCostVO){
		this. sqmQtaLaneOfcCostVO = sqmQtaLaneOfcCostVO;
	}

	public void setSqmQtaLaneOfcCostVOS(SqmQtaLaneOfcCostVO[] sqmQtaLaneOfcCostVOs){
		if(sqmQtaLaneOfcCostVOs != null){
			this.sqmQtaLaneOfcCostVOs = new SqmQtaLaneOfcCostVO[sqmQtaLaneOfcCostVOs.length];
			for(int i=0; i<sqmQtaLaneOfcCostVOs.length; ++i){
				this.sqmQtaLaneOfcCostVOs[i] = sqmQtaLaneOfcCostVOs[i];
			}
		}
	}

	public SqmQtaLaneOfcCostVO getSqmQtaLaneOfcCostVO(){
		return sqmQtaLaneOfcCostVO;
	}

	public SqmQtaLaneOfcCostVO[] getSqmQtaLaneOfcCostVOS(){
		SqmQtaLaneOfcCostVO[] ret = null;
		if(this.sqmQtaLaneOfcCostVOs != null){
			ret = new SqmQtaLaneOfcCostVO[sqmQtaLaneOfcCostVOs.length];
			for(int i=0; i<sqmQtaLaneOfcCostVOs.length; i++){
				ret[i] = this.sqmQtaLaneOfcCostVOs[i];
			}
		}
		return ret;
	}
}