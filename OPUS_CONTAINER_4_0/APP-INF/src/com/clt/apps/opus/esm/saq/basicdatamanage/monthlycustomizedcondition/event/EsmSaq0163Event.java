/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0163Event.java
*@FileTitle      : Customized Conditions
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.event;


import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AGNCommRequestVO;
import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonDirConvVO;
import com.clt.syscommon.common.table.SaqMonLodTgtOfcVO;


/**
 * ESM_SAQ_0163 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0163HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author taeho, Kim
 * @see ESM_SAQ_0163HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0163Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QuotaConditionVO conditionVO = null;
	
	/** sheet1의 Table Value Object Multi Data 처리 */
	private SaqMonLodTgtOfcVO[] saqMonLodTgtOfcVOs = null;
	/** sheet2의 Value Object Multi Data 처리 */
	private SaqMonDirConvVO[] saqMonDirConvVOs = null;

	public EsmSaq0163Event(){}
	
	//1tab 조회
	public void setMonthlyCustomizedConditionTabLoadTargetVO(QuotaConditionVO conditionVO){
		this.conditionVO = conditionVO;
	}
	
	//2tab 조회 , Confirm, Confirm Cancel
	public void setMonthlyCustomizedConditionTabLaneBoundVO(QuotaConditionVO conditionVO){
		this.conditionVO = conditionVO;
	}

	//1tab 저장
	public void setMonthlyCustomizedConditionTabLoadTargetSaveVOS(SaqMonLodTgtOfcVO[] saqMonLodTgtOfcVOs){
		if(saqMonLodTgtOfcVOs != null){
			SaqMonLodTgtOfcVO[] tmpVOs = Arrays.copyOf(saqMonLodTgtOfcVOs, saqMonLodTgtOfcVOs.length);
			this.saqMonLodTgtOfcVOs  = tmpVOs;
		}
	}
	
	//2tab 저장
	public void setMonthlyCustomizedConditionTabLaneBoundVOS(SaqMonDirConvVO[] saqMonDirConvVOs){
		if(saqMonDirConvVOs != null){
			SaqMonDirConvVO[] tmpVOs = Arrays.copyOf(saqMonDirConvVOs, saqMonDirConvVOs.length);
			this.saqMonDirConvVOs  = tmpVOs;
		}
	}
	
	//2tab get조회,Confirm, Confirm Cancel
	public QuotaConditionVO getMonthlyCustomizedConditionTabLaneBoundVO(){
		return conditionVO;
	}
	
	//1tab get조회,1/2tab Create Initial Data
	public QuotaConditionVO getMonthlyCustomizedConditionTabLoadTargetVO(){
		return conditionVO;
	}

	public SaqMonLodTgtOfcVO[] getMonthlyCustomizedConditionTabLoadTargetVOS(){		
		SaqMonLodTgtOfcVO[] rtnVOs = null;
		if (this.saqMonLodTgtOfcVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonLodTgtOfcVOs, saqMonLodTgtOfcVOs.length);
		}
		return rtnVOs;
	}

	public SaqMonDirConvVO[] getMonthlyCustomizedConditionTabLaneBoundVOS(){
		SaqMonDirConvVO[] rtnVOs = null;
		if (this.saqMonDirConvVOs != null) {
			rtnVOs = Arrays.copyOf(saqMonDirConvVOs, saqMonDirConvVOs.length);
		}
		return rtnVOs;
	}
}