/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TTMonthlyWeeklyPeriodVO.java
 *@FileTitle : TTMonthlyWeeklyPeriodVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.13
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.13 박광석 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박광석
 * @since J2EE 1.5
 * @see ..
 */

public class TurnTimeByMonthlyWeeklyTrendSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	/* Column Info */
	private List<TurnTimeByMonthlyWeeklyTrendVO> turntimebymonthlyweeklytrendvo = null;

	/* Column Info */
	private List<TTMonthlyWeeklyPeriodVO> ttmonthlyweeklyperiodvo = null;

	/**
	 * 
	 * @return
	 */
	public List<TurnTimeByMonthlyWeeklyTrendVO> getTurntimebymonthlyweeklytrendvo() {
		return turntimebymonthlyweeklytrendvo;
	}

	/**
	 * 
	 * @param turntimebymonthlyweeklytrendvo
	 */
	public void setTurntimebymonthlyweeklytrendvo(List<TurnTimeByMonthlyWeeklyTrendVO> turntimebymonthlyweeklytrendvo) {
		this.turntimebymonthlyweeklytrendvo = turntimebymonthlyweeklytrendvo;
	}

	/**
	 * 
	 * @return
	 */
	public List<TTMonthlyWeeklyPeriodVO> getTtmonthlyweeklyperiodvo() {
		return ttmonthlyweeklyperiodvo;
	}

	/**
	 * 
	 * @param ttmonthlyweeklyperiodvo
	 */
	public void setTtmonthlyweeklyperiodvo(List<TTMonthlyWeeklyPeriodVO> ttmonthlyweeklyperiodvo) {
		this.ttmonthlyweeklyperiodvo = ttmonthlyweeklyperiodvo;
	}

	public TurnTimeByMonthlyWeeklyTrendSetVO() {
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
