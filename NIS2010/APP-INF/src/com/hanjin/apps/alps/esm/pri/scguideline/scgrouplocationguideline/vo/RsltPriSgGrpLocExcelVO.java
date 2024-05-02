/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltPriSgGrpLocExcelVO.java
 *@FileTitle : RsltPriSgGrpLocExcelVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.04 박성수 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo;

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
 */

public class RsltPriSgGrpLocExcelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltPriSgGrpLocExcelVO> models = new ArrayList<RsltPriSgGrpLocExcelVO>();

	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String prcGrpLocCd = null;
	/* Column Info */
	private String grpLocDtlSeq = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String grpLocSeq = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcGrpLocDesc = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltPriSgGrpLocExcelVO() {
	}

	public RsltPriSgGrpLocExcelVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String grpLocSeq,
			String grpLocDtlSeq, String prcGrpLocCd, String prcGrpLocDesc, String locCd, String locNm, String scontiCd,
			String scontiNm) {
		this.scontiNm = scontiNm;
		this.prcGrpLocCd = prcGrpLocCd;
		this.grpLocDtlSeq = grpLocDtlSeq;
		this.ibflag = ibflag;
		this.locNm = locNm;
		this.grpLocSeq = grpLocSeq;
		this.glineSeq = glineSeq;
		this.locCd = locCd;
		this.svcScpCd = svcScpCd;
		this.scontiCd = scontiCd;
		this.pagerows = pagerows;
		this.prcGrpLocDesc = prcGrpLocDesc;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("prc_grp_loc_cd", getPrcGrpLocCd());
		this.hashColumns.put("grp_loc_dtl_seq", getGrpLocDtlSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("grp_loc_seq", getGrpLocSeq());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_grp_loc_desc", getPrcGrpLocDesc());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("prc_grp_loc_cd", "prcGrpLocCd");
		this.hashFields.put("grp_loc_dtl_seq", "grpLocDtlSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("grp_loc_seq", "grpLocSeq");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_grp_loc_desc", "prcGrpLocDesc");
		return this.hashFields;
	}

	public String getScontiNm() {
		return this.scontiNm;
	}

	public String getPrcGrpLocCd() {
		return this.prcGrpLocCd;
	}

	public String getGrpLocDtlSeq() {
		return this.grpLocDtlSeq;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getLocNm() {
		return this.locNm;
	}

	public String getGrpLocSeq() {
		return this.grpLocSeq;
	}

	public String getGlineSeq() {
		return this.glineSeq;
	}

	public String getLocCd() {
		return this.locCd;
	}

	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	public String getScontiCd() {
		return this.scontiCd;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public String getPrcGrpLocDesc() {
		return this.prcGrpLocDesc;
	}

	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
		// this.scontiNm=true;
	}

	public void setPrcGrpLocCd(String prcGrpLocCd) {
		this.prcGrpLocCd = prcGrpLocCd;
		// this.prcGrpLocCd=true;
	}

	public void setGrpLocDtlSeq(String grpLocDtlSeq) {
		this.grpLocDtlSeq = grpLocDtlSeq;
		// this.grpLocDtlSeq=true;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	public void setLocNm(String locNm) {
		this.locNm = locNm;
		// this.locNm=true;
	}

	public void setGrpLocSeq(String grpLocSeq) {
		this.grpLocSeq = grpLocSeq;
		// this.grpLocSeq=true;
	}

	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
		// this.glineSeq=true;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
		// this.locCd=true;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		// this.svcScpCd=true;
	}

	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
		// this.scontiCd=true;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	public void setPrcGrpLocDesc(String prcGrpLocDesc) {
		this.prcGrpLocDesc = prcGrpLocDesc;
		// this.prcGrpLocDesc=true;
	}

	public void fromRequest(HttpServletRequest request) {
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setPrcGrpLocCd(JSPUtil.getParameter(request, "prc_grp_loc_cd", ""));
		setGrpLocDtlSeq(JSPUtil.getParameter(request, "grp_loc_dtl_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setGrpLocSeq(JSPUtil.getParameter(request, "grp_loc_seq", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcGrpLocDesc(JSPUtil.getParameter(request, "prc_grp_loc_desc", ""));
	}

	public RsltPriSgGrpLocExcelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltPriSgGrpLocExcelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSgGrpLocExcelVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] scontiNm = (JSPUtil.getParameter(request, prefix + "sconti_nm".trim(), length));
			String[] prcGrpLocCd = (JSPUtil.getParameter(request, prefix + "prc_grp_loc_cd".trim(), length));
			String[] grpLocDtlSeq = (JSPUtil.getParameter(request, prefix + "grp_loc_dtl_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm".trim(), length));
			String[] grpLocSeq = (JSPUtil.getParameter(request, prefix + "grp_loc_seq".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix + "sconti_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
			String[] prcGrpLocDesc = (JSPUtil.getParameter(request, prefix + "prc_grp_loc_desc".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltPriSgGrpLocExcelVO();
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (prcGrpLocCd[i] != null)
					model.setPrcGrpLocCd(prcGrpLocCd[i]);
				if (grpLocDtlSeq[i] != null)
					model.setGrpLocDtlSeq(grpLocDtlSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (grpLocSeq[i] != null)
					model.setGrpLocSeq(grpLocSeq[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcGrpLocDesc[i] != null)
					model.setPrcGrpLocDesc(prcGrpLocDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
		}
		return getRsltPriSgGrpLocExcelVOs();
	}

	public RsltPriSgGrpLocExcelVO[] getRsltPriSgGrpLocExcelVOs() {
		RsltPriSgGrpLocExcelVO[] vos = (RsltPriSgGrpLocExcelVO[]) models.toArray(new RsltPriSgGrpLocExcelVO[models
				.size()]);
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
		}
		return ret.toString();
	}

	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

	/**
	 * DataFormat 설정
	 */
	public void onDataFormat() {
		this.scontiNm = this.scontiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpLocCd = this.prcGrpLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.grpLocDtlSeq = this.grpLocDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(
				":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocSeq = this.grpLocSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcGrpLocDesc = this.prcGrpLocDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(
				":", "");
	}
}
