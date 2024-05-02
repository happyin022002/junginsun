/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_EQR_121Event.java
*@FileTitle : 연간 신조 계획 조회/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-28
*@LastModifier : yongchan shin
*@LastVersion : 1.0
* 2006-09-28 yongchan shin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0121ConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrNewVanLongTermVO;


/**
 * EES_EQR_121 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_EQR_121HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yongchan shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesEqr0121Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrNewVanLongTermVO eqrNewVanLongTermVO = null;

	/** Table Value Object Multi Data 처리 */
	public EqrNewVanLongTermVO[] eqrNewVanLongTermVOS = null;
	
	/** search Condition 조건 단건처리 */
	private EesEqr0121ConditionVO conditionVO = null;

	/*
	 * MmonthSaveInfo, FlagmonthSaveInfo  배열 셋팅 'm'+monthArr ,  'flag'+monthArr 의  파마메타 명으로 입력받아 설정한다.
	 * command multi 인 경우 호출됨
	 *  HTML ACTION 에서 ConditionVO  를 셋팅한 이후 메소드를 호출한다.
	 */
	public void setMAndFlagmonthSaveInfo(javax.servlet.http.HttpServletRequest req){
		if(conditionVO != null){
			List<String[]> monthSaveInfo = new ArrayList<String[]>();
			List<String[]> flagmonthSaveInfo = new ArrayList<String[]>();
			String[] monthArr = conditionVO.getMonthArr();
			for(int i = 0 ; i < monthArr.length ; i++){
				monthSaveInfo.add(req.getParameterValues("m"+monthArr[i]));
				flagmonthSaveInfo.add(req.getParameterValues("flag"+monthArr[i]));
			}
			conditionVO.setMmonthSaveInfo(monthSaveInfo);
			conditionVO.setFlagmonthSaveInfo(flagmonthSaveInfo);
		}
	}

	/*
	 * MweekSaveInfo, FlagweekSaveInfo  배열 셋팅 'm'+weekArr ,  'flag1'+weekArr 의  파마메타 명으로 입력받아 설정한다.
	 * command multi 인 경우 호출됨
	 *  HTML ACTION 에서 ConditionVO  를 셋팅한 이후 메소드를 호출한다.
	 */
	public void setMAndFlagweekSaveInfo(javax.servlet.http.HttpServletRequest req){
		if(conditionVO != null){
			List<String[]> weekSaveInfo = new ArrayList<String[]>();
			List<String[]> flagweekSaveInfo = new ArrayList<String[]>();
			String[] weekArr = conditionVO.getWeekArr();
			for(int i = 0 ; i < weekArr.length ; i++){
				weekSaveInfo.add(req.getParameterValues("w"+weekArr[i]));
				flagweekSaveInfo.add(req.getParameterValues("flag1"+weekArr[i]));
			}
			conditionVO.setMweekSaveInfo(weekSaveInfo);
			conditionVO.setFlagweekSaveInfo(flagweekSaveInfo);
		}
	}
	/**
	 * @return the eqrNewVanLongTermVO
	 */
	public EqrNewVanLongTermVO getEqrNewVanLongTermVO() {
		return eqrNewVanLongTermVO;
	}

	/**
	 * @param eqrNewVanLongTermVO the eqrNewVanLongTermVO to set
	 */
	public void setEqrNewVanLongTermVO(EqrNewVanLongTermVO eqrNewVanLongTermVO) {
		this.eqrNewVanLongTermVO = eqrNewVanLongTermVO;
	}

	/**
	 * @return the eqrNewVanLongTermVOS
	 */
	public EqrNewVanLongTermVO[] getEqrNewVanLongTermVOS() {
		return eqrNewVanLongTermVOS;
	}

	/**
	 * @param eqrNewVanLongTermVOS the eqrNewVanLongTermVOS to set
	 */
	public void setEqrNewVanLongTermVOS(EqrNewVanLongTermVO[] eqrNewVanLongTermVOS) {
		this.eqrNewVanLongTermVOS = eqrNewVanLongTermVOS;
	}

	/**
	 * @return the conditionVO
	 */
	public EesEqr0121ConditionVO getConditionVO() {
		return conditionVO;
	}

	/**
	 * @param conditionVO the conditionVO to set
	 */
	public void setConditionVO(EesEqr0121ConditionVO conditionVO) {
		this.conditionVO = conditionVO;
	}
	
	
	
}
