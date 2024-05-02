/**
 * 
 */
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * @author Administrator
 *
 */
public class MatchBackByMonthlyWeeklyTrendSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	/* Column Info */
	private List<QuantityByTypeSizeVO> quantitybytypesizevo = null;

	/* Column Info */
	private List<MBMonthlyWeeklyPeriodVO> mbmonthlyweeklyperiodvo = null;
	
	public MatchBackByMonthlyWeeklyTrendSetVO() {}    
	
	
	/**
	 * @return the quantitybytypesizevo
	 */
	public List<QuantityByTypeSizeVO> getQuantitybytypesizevo() {
		return quantitybytypesizevo;
	}

	/**
	 * @param quantitybytypesizevo the quantitybytypesizevo to set
	 */
	public void setQuantitybytypesizevo(
			List<QuantityByTypeSizeVO> quantitybytypesizevo) {
		this.quantitybytypesizevo = quantitybytypesizevo;
	}

	/**
	 * @return the mbmonthlyweeklyperiodvo
	 */
	public List<MBMonthlyWeeklyPeriodVO> getMbmonthlyweeklyperiodvo() {
		return mbmonthlyweeklyperiodvo;
	}

	/**
	 * @param mbmonthlyweeklyperiodvo the mbmonthlyweeklyperiodvo to set
	 */
	public void setMbmonthlyweeklyperiodvo(
			List<MBMonthlyWeeklyPeriodVO> mbmonthlyweeklyperiodvo) {
		this.mbmonthlyweeklyperiodvo = mbmonthlyweeklyperiodvo;
	}

	/* (non-Javadoc)
	 * @see com.clt.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.clt.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
