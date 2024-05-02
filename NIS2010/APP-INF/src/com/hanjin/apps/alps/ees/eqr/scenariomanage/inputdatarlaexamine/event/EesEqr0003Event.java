/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0003Event.java
*@FileTitle : Input Data Red Light Alert 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-26
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-07-26 정은호
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.inputdatarlaexamine.vo.EesEqr0003ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;



/**
 * EES_EQR_0003 에 대한 PDTO(Data Transfer Object including Parameters VO)<br>
 * - EES_EQR_003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private EesEqr0003ConditionVO conditionVO = null;
	public EesEqr0003ConditionVO[] conditionVOS = null;

	private EqrScnrEccVO eqrScnrEccVO = null;
	public EqrScnrEccVO[] eqrScnrEccVOS = null;
	public EesEqr0003Event(){}
	
	public void setTpszQtyFlag(HttpServletRequest request){
		if(conditionVO != null){
			String[] tpszArr = conditionVO.getTpsztype().split(",");
			List<String[]> volTpszArr = new ArrayList<String[]>();
			List<String[]> volFlagTpszArr = new ArrayList<String[]>();
			List<String[]> amtTpszArr = new ArrayList<String[]>();
			List<String[]> amtFlagTpszArr = new ArrayList<String[]>();
			// Sheet1 title 의 tpsz qty, flag 정보
			for(int i=0; i<tpszArr.length; i++) {	
				volTpszArr.add(request.getParameterValues("vol"+tpszArr[i])); // vol
				volFlagTpszArr.add(request.getParameterValues("vol_flag"+tpszArr[i])); // vol, amt flag (수정된 월만 T, 수정안된것은 F)
				amtTpszArr.add(request.getParameterValues("amt"+tpszArr[i])); // amt
				amtFlagTpszArr.add(request.getParameterValues("amt_flag"+tpszArr[i])); // vol, amt flag (수정된 월만 T, 수정안된것은 F)
			}
			conditionVO.setVolTpszArr(volTpszArr);
			conditionVO.setVolFlagTpszArr(volFlagTpszArr);
			conditionVO.setAmtTpszArr(amtTpszArr);
			conditionVO.setAmtFlagTpszArr(amtFlagTpszArr);
		}
	}
	
	public EesEqr0003ConditionVO getConditionVO() {
		return conditionVO;
	}
	public void setConditionVO(EesEqr0003ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	public EesEqr0003ConditionVO[] getConditionVOS() {
		return conditionVOS;
	}
	public void setConditionVOS(EesEqr0003ConditionVO[] conditionVOS) {
		this.conditionVOS = conditionVOS;
	}
	public EqrScnrEccVO getEqrScnrEccVO() {
		return eqrScnrEccVO;
	}
	public void setEqrScnrEccVO(EqrScnrEccVO eqrScnrEccVO) {
		this.eqrScnrEccVO = eqrScnrEccVO;
	}
	public EqrScnrEccVO[] getEqrScnrEccVOS() {
		return eqrScnrEccVOS;
	}
	public void setEqrScnrEccVOS(EqrScnrEccVO[] eqrScnrEccVOS) {
		this.eqrScnrEccVOS = eqrScnrEccVOS;
	}
	
	
}
