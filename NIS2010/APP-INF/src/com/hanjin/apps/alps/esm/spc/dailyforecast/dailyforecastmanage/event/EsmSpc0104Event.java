/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0104Event.java
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.27 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;


/**
 * ESM_SPC_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0104HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DailyforecastmanageConditionVO dailyforecastmanageConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DailyforecastmanageConditionVO[] dailyforecastmanageConditionVOs = null;

	public EsmSpc0104Event(){}
	
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

}