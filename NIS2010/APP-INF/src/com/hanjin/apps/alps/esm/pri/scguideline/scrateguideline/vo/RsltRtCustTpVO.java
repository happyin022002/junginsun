/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltRateCustTpVO.java
 *@FileTitle : RsltRateCustTpVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.12
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.12 박성수 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo;

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
 * @author 박성수
 * @since J2EE 1.5
 * @see ..
 */

public class RsltRtCustTpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltRtCustTpVO> models = new ArrayList<RsltRtCustTpVO>();

	/* Column Info */
	private String rateCnt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String cd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nm = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltRtCustTpVO() {
	}

	public RsltRtCustTpVO(String ibflag, String pagerows, String cd, String nm, String rateCnt) {
		this.rateCnt = rateCnt;
		this.ibflag = ibflag;
		this.cd = cd;
		this.pagerows = pagerows;
		this.nm = nm;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("rate_cnt", getRateCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cd", getCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nm", getNm());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("rate_cnt", "rateCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cd", "cd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nm", "nm");
		return this.hashFields;
	}

	public String getRateCnt() {
		return this.rateCnt;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getCd() {
		return this.cd;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getNm() {
		return this.nm;
	}

	public void setRateCnt(String rateCnt) {
		this.rateCnt = rateCnt;
		// this.rateCnt=true;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	public void setCd(String cd) {
		this.cd = cd;
		// this.cd=true;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	public void setNm(String nm) {
		this.nm = nm;
		// this.nm=true;
	}

	public void fromRequest(HttpServletRequest request) {
		setRateCnt(JSPUtil.getParameter(request, "rate_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCd(JSPUtil.getParameter(request, "cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNm(JSPUtil.getParameter(request, "nm", ""));
	}

	public RsltRtCustTpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltRtCustTpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtCustTpVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rateCnt = (JSPUtil.getParameter(request, prefix + "rate_cnt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] cd = (JSPUtil.getParameter(request, prefix + "cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
			String[] nm = (JSPUtil.getParameter(request, prefix + "nm".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltRtCustTpVO();
				if (rateCnt[i] != null)
					model.setRateCnt(rateCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cd[i] != null)
					model.setCd(cd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRateCustTpVOs();
	}

	public RsltRtCustTpVO[] getRsltRateCustTpVOs() {
		RsltRtCustTpVO[] vos = (RsltRtCustTpVO[]) models.toArray(new RsltRtCustTpVO[models.size()]);
		return vos;
	}

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
		this.rateCnt = this.rateCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cd = this.cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
