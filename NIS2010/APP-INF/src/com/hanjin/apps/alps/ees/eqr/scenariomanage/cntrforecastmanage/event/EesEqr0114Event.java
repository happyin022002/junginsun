/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0114Event.java
*@FileTitle : Holiday Effect
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.event;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0114ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.SearchEqrHolidayListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrHolEffRtoVO;


/**
 * EES_EQR_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0114HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0114Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrHolEffRtoVO eqrScnrHolEffRtoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrHolEffRtoVO[] eqrScnrHolEffRtoVOs = null;
	
	/** 조건 VO **/
	private EesEqr0114ConditionVO eesEqr0114ConditionVO = null;
	
	/** Return VO **/
	private SearchEqrHolidayListVO searchEqrHolidayListVO = null;

	public EesEqr0114Event(){}
	
	public void setEqrScnrHolEffRtoVO(EqrScnrHolEffRtoVO eqrScnrHolEffRtoVO){
		this. eqrScnrHolEffRtoVO = eqrScnrHolEffRtoVO;
	}

	public void setEqrScnrHolEffRtoVOS(EqrScnrHolEffRtoVO[] eqrScnrHolEffRtoVOs){
		this. eqrScnrHolEffRtoVOs = eqrScnrHolEffRtoVOs;
	}

	public EqrScnrHolEffRtoVO getEqrScnrHolEffRtoVOVO(){
		return eqrScnrHolEffRtoVO;
	}

	public EqrScnrHolEffRtoVO[] getEqrScnrHolEffRtoVOS(){
		return eqrScnrHolEffRtoVOs;
	}

	public EesEqr0114ConditionVO getEesEqr0114ConditionVO() {
		return eesEqr0114ConditionVO;
	}

	public void setEesEqr0114ConditionVO(EesEqr0114ConditionVO eesEqr0114ConditionVO) {
		this.eesEqr0114ConditionVO = eesEqr0114ConditionVO;
	}

	public SearchEqrHolidayListVO getSearchEqrHolidayListVO() {
		return searchEqrHolidayListVO;
	}

	public void setSearchEqrHolidayListVO(
			SearchEqrHolidayListVO searchEqrHolidayListVO) {
		this.searchEqrHolidayListVO = searchEqrHolidayListVO;
	}
	
}