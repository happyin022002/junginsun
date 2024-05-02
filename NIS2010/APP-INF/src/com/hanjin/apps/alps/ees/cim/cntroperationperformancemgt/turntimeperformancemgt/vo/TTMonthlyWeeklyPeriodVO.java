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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
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

public class TTMonthlyWeeklyPeriodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TTMonthlyWeeklyPeriodVO> models = new ArrayList<TTMonthlyWeeklyPeriodVO>();

	/* Column Info */
	private String period = null;
	/* Status */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TTMonthlyWeeklyPeriodVO() {
	}

	/**
	 * 
	 * @param ibflag
	 * @param pagerows
	 * @param period
	 */
	public TTMonthlyWeeklyPeriodVO(String ibflag, String pagerows, String period) {
		this.period = period;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("period", "period");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getPeriod() {
		return this.period;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public void setPeriod(String period) {
		this.period = period;
		// this.period=true;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	/**
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public TTMonthlyWeeklyPeriodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 
	 * @param request
	 * @param prefix
	 * @return
	 */
	public TTMonthlyWeeklyPeriodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TTMonthlyWeeklyPeriodVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] period = (JSPUtil.getParameter(request, prefix + "period".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new TTMonthlyWeeklyPeriodVO();
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTTMonthlyWeeklyPeriodVOs();
	}

	/**
	 * 
	 * @return
	 */
	public TTMonthlyWeeklyPeriodVO[] getTTMonthlyWeeklyPeriodVOs() {
		TTMonthlyWeeklyPeriodVO[] vos = (TTMonthlyWeeklyPeriodVO[]) models.toArray(new TTMonthlyWeeklyPeriodVO[models
				.size()]);
		return vos;
	}

	/**
	 * 
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}

	/**
	 * getField 에서 catch문에 대한 로직
	 * 
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}

	/**
	 * DataFormat 설정
	 */
	public void onDataFormat() {
		this.period = this.period.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
