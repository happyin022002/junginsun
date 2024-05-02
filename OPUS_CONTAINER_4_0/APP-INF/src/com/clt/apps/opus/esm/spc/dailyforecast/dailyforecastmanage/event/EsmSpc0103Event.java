/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0103Event.java
*@FileTitle      : Account Registration
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.21
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.21
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.SpcSlsRepCustMapgNewVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * ESM_SPC_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0103HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSpc0103Event extends EventSupport{
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DailyforecastmanageConditionVO dailyforecastmanageConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DailyforecastmanageConditionVO[] dailyforecastmanageConditionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcSlsRepCustMapgNewVO spcSlsRepCustMapgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcSlsRepCustMapgNewVO[] spcSlsRepCustMapgVOs = null;

	public EsmSpc0103Event(){}
	
	public void setDailyforecastmanageConditionVO(DailyforecastmanageConditionVO dailyforecastmanageConditionVO){
		this.dailyforecastmanageConditionVO = dailyforecastmanageConditionVO;
	}

	public void setDailyforecastmanageConditionVOS(DailyforecastmanageConditionVO[] dailyforecastmanageConditionVOs){
		if(dailyforecastmanageConditionVOs != null){
			DailyforecastmanageConditionVO[] tmpVOs = Arrays.copyOf(dailyforecastmanageConditionVOs, dailyforecastmanageConditionVOs.length);
			this.dailyforecastmanageConditionVOs  = tmpVOs;
		}
	}

	public void setSpcSlsRepCustMapgVO(SpcSlsRepCustMapgNewVO spcSlsRepCustMapgVO){
		this.spcSlsRepCustMapgVO = spcSlsRepCustMapgVO;
	}

	public void setSpcSlsRepCustMapgVOS(SpcSlsRepCustMapgNewVO[] spcSlsRepCustMapgVOs){
		if(spcSlsRepCustMapgVOs != null){
			SpcSlsRepCustMapgNewVO[] tmpVOs = Arrays.copyOf(spcSlsRepCustMapgVOs, spcSlsRepCustMapgVOs.length);
			this.spcSlsRepCustMapgVOs  = tmpVOs;
		}
	}

	public DailyforecastmanageConditionVO getDailyforecastmanageConditionVO(){
		return dailyforecastmanageConditionVO;
	}

	public DailyforecastmanageConditionVO[] getDailyforecastmanageConditionVOS(){ 
		DailyforecastmanageConditionVO[] rtnVOs = null;
		if (this.dailyforecastmanageConditionVOs != null) {
			rtnVOs = Arrays.copyOf(dailyforecastmanageConditionVOs, dailyforecastmanageConditionVOs.length);
		}
		return rtnVOs;
	}

	public SpcSlsRepCustMapgNewVO getSpcSlsRepCustMapgVO(){
		return spcSlsRepCustMapgVO;
	}

	public SpcSlsRepCustMapgNewVO[] getSpcSlsRepCustMapgVOS(){
		SpcSlsRepCustMapgNewVO[] rtnVOs = null;
		if (this.spcSlsRepCustMapgVOs != null) {
			rtnVOs = Arrays.copyOf(spcSlsRepCustMapgVOs, spcSlsRepCustMapgVOs.length);
		}
		return rtnVOs;
	}
}
