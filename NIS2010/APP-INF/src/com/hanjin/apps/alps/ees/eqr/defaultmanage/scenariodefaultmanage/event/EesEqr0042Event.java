/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_042Event.java
*@FileTitle : Holiday Effect 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2009-07-15
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-07-15 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;


import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0042ConditionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrHolEffRtoVO;
import com.hanjin.syscommon.common.table.EqrHolidayVO;



/**
 * EES_EQR_042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author chung eun ho
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr0042Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	
	private EqrHolEffRtoVO eqrHolEffRtoVO = null;
	public EqrHolEffRtoVO[] eqrHolEffRtoVOS = null;

	private EqrHolidayVO eqrHolidayVO = null;
	public EqrHolidayVO[] eqrHolidayVOS = null;
	
	private EesEqr0042ConditionVO conditionVO = null;
	
	/*
	 *  hol_eff_rto 배열 셋팅 hol_eff_yrwk+'_irto' 의  파마메타 명으로 입력받아 설정한다.
	 *  HTML ACTION 에서 ConditionVO 와 eqrHolEffRtoVOS 를 셋팅한 이후 메소드를 호출한다.
	 */
	public void setEqrHolEffRtoVOSHolEffRto(javax.servlet.http.HttpServletRequest req){
		if(this.conditionVO != null && this.eqrHolEffRtoVOS != null){
			EqrHolEffRtoVO[] eqrHolEffRtoVOS_swap = null;
			String hol_eff_yrwk = this.conditionVO.getHol_eff_yrwk();
			String[] prefixS = hol_eff_yrwk.split(",");
			int length = this.eqrHolEffRtoVOS.length; // req.getParameterValues("ibflag").length; 와 동일함
			eqrHolEffRtoVOS_swap = new EqrHolEffRtoVO[ length * prefixS.length ];
			int z = 0;
			for( int j = 0 ; j < prefixS.length ; j++){
				String[] hol_eff_rto   =  (JSPUtil.getParameter(req, prefixS[j] + "_irto".trim(), length));
				for( int i = 0 ; i < length  ; i++){
					this.eqrHolEffRtoVOS[i].setHolEffYrwk(prefixS[j]);					
					this.eqrHolEffRtoVOS[i].setHolEffRto(hol_eff_rto[i]);
					eqrHolEffRtoVOS_swap[z] = this.eqrHolEffRtoVOS[i];
					z++;
				}
			}
			this.eqrHolEffRtoVOS = eqrHolEffRtoVOS_swap;
		}
	}
	
	/**
	 * @return the eqrHolEffRtoVO
	 */
	public EqrHolEffRtoVO getEqrHolEffRtoVO() {
		return eqrHolEffRtoVO;
	}
	/**
	 * @param eqrHolEffRtoVO the eqrHolEffRtoVO to set
	 */
	public void setEqrHolEffRtoVO(EqrHolEffRtoVO eqrHolEffRtoVO) {
		this.eqrHolEffRtoVO = eqrHolEffRtoVO;
	}
	/**
	 * @return the eqrHolEffRtoVOS
	 */
	public EqrHolEffRtoVO[] getEqrHolEffRtoVOS() {
		return eqrHolEffRtoVOS;
	}
	/**
	 * @param eqrHolEffRtoVOS the eqrHolEffRtoVOS to set
	 */
	public void setEqrHolEffRtoVOS(EqrHolEffRtoVO[] eqrHolEffRtoVOS) {
		this.eqrHolEffRtoVOS = eqrHolEffRtoVOS;
	}
	/**
	 * @return the eqrHolidayVO
	 */
	public EqrHolidayVO getEqrHolidayVO() {
		return eqrHolidayVO;
	}
	/**
	 * @param eqrHolidayVO the eqrHolidayVO to set
	 */
	public void setEqrHolidayVO(EqrHolidayVO eqrHolidayVO) {
		this.eqrHolidayVO = eqrHolidayVO;
	}
	/**
	 * @return the eqrHolidayVOS
	 */
	public EqrHolidayVO[] getEqrHolidayVOS() {
		return eqrHolidayVOS;
	}
	/**
	 * @param eqrHolidayVOS the eqrHolidayVOS to set
	 */
	public void setEqrHolidayVOS(EqrHolidayVO[] eqrHolidayVOS) {
		this.eqrHolidayVOS = eqrHolidayVOS;
	}
	/**
	 * @return the conditionVO
	 */
	public EesEqr0042ConditionVO getConditionVO() {
		return conditionVO;
	}
	/**
	 * @param conditionVO the conditionVO to set
	 */
	public void setConditionVO(EesEqr0042ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}

}
