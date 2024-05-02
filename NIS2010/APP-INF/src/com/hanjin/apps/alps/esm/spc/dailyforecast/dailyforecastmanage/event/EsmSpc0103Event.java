/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0103Event.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcSlsRepCustMapgVO;


/**
 * ESM_SPC_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0103HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0103Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DailyforecastmanageConditionVO dailyforecastmanageConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DailyforecastmanageConditionVO[] dailyforecastmanageConditionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcSlsRepCustMapgVO spcSlsRepCustMapgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcSlsRepCustMapgVO[] spcSlsRepCustMapgVOs = null;

	public EsmSpc0103Event(){}
	
	public void setDailyforecastmanageConditionVO(DailyforecastmanageConditionVO dailyforecastmanageConditionVO){
		this. dailyforecastmanageConditionVO = dailyforecastmanageConditionVO;
	}

	public void setDailyforecastmanageConditionVOS(DailyforecastmanageConditionVO[] dailyforecastmanageConditionVOs){
		if (dailyforecastmanageConditionVOs != null) {
			DailyforecastmanageConditionVO[] tmpVOs = new DailyforecastmanageConditionVO[dailyforecastmanageConditionVOs.length];
			System.arraycopy(dailyforecastmanageConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.dailyforecastmanageConditionVOs = tmpVOs;
		}
	}

	public void setSpcSlsRepCustMapgVO(SpcSlsRepCustMapgVO spcSlsRepCustMapgVO){
		this. spcSlsRepCustMapgVO = spcSlsRepCustMapgVO;
	}

	public void setSpcSlsRepCustMapgVOS(SpcSlsRepCustMapgVO[] spcSlsRepCustMapgVOs){
		if (spcSlsRepCustMapgVOs != null) {
			SpcSlsRepCustMapgVO[] tmpVOs = new SpcSlsRepCustMapgVO[spcSlsRepCustMapgVOs.length];
			System.arraycopy(spcSlsRepCustMapgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcSlsRepCustMapgVOs = tmpVOs;
		}
	}

	public DailyforecastmanageConditionVO getDailyforecastmanageConditionVO(){
		return dailyforecastmanageConditionVO;
	}

	public DailyforecastmanageConditionVO[] getDailyforecastmanageConditionVOS(){
		DailyforecastmanageConditionVO[] rtnVOs = null;
		if (this.dailyforecastmanageConditionVOs != null) {
			rtnVOs = new DailyforecastmanageConditionVO[dailyforecastmanageConditionVOs.length];
			System.arraycopy(dailyforecastmanageConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	public SpcSlsRepCustMapgVO getSpcSlsRepCustMapgVO(){
		return spcSlsRepCustMapgVO;
	}

	public SpcSlsRepCustMapgVO[] getSpcSlsRepCustMapgVOS(){
		SpcSlsRepCustMapgVO[] rtnVOs = null;
		if (this.spcSlsRepCustMapgVOs != null) {
			rtnVOs = new SpcSlsRepCustMapgVO[spcSlsRepCustMapgVOs.length];
			System.arraycopy(spcSlsRepCustMapgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}