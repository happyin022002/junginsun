/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0111Event.java
*@FileTitle : Load Office Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo.DailyforecastmanageConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcCtrtFcastOfcMapgVO;


/**
 * ESM_SPC_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcCtrtFcastOfcMapgVO spcCtrtFcastOfcMapgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcCtrtFcastOfcMapgVO[] spcCtrtFcastOfcMapgVOs = null;
	
	public EsmSpc0111Event(){}

	public void setSpcCtrtFcastOfcMapgVO(SpcCtrtFcastOfcMapgVO spcCtrtFcastOfcMapgMapgVO){
		this. spcCtrtFcastOfcMapgVO = spcCtrtFcastOfcMapgMapgVO;
	}

	public void setSpcCtrtFcastOfcMapgVOS(SpcCtrtFcastOfcMapgVO[] spcCtrtFcastOfcMapgVOs){
		if (spcCtrtFcastOfcMapgVOs != null) {
			SpcCtrtFcastOfcMapgVO[] tmpVOs = new SpcCtrtFcastOfcMapgVO[spcCtrtFcastOfcMapgVOs.length];
			System.arraycopy(spcCtrtFcastOfcMapgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcCtrtFcastOfcMapgVOs = tmpVOs;
		}
	}
	
	public SpcCtrtFcastOfcMapgVO getSpcCtrtFcastOfcMapgVO(){
		return spcCtrtFcastOfcMapgVO;
	}

	public SpcCtrtFcastOfcMapgVO[] getSpcCtrtFcastOfcMapgVOS(){
		SpcCtrtFcastOfcMapgVO[] rtnVOs = null;
		if (this.spcCtrtFcastOfcMapgVOs != null) {
			rtnVOs = new SpcCtrtFcastOfcMapgVO[spcCtrtFcastOfcMapgVOs.length];
			System.arraycopy(spcCtrtFcastOfcMapgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	private DailyforecastmanageConditionVO dailyforecastmanageConditionVO = null;
	
	public void setDailyforecastmanageConditionVO(DailyforecastmanageConditionVO dailyforecastmanageConditionVO){
		this. dailyforecastmanageConditionVO = dailyforecastmanageConditionVO;
	}
	
	public DailyforecastmanageConditionVO getDailyforecastmanageConditionVO(){
		return dailyforecastmanageConditionVO;
	}

}