/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltPriSgGrpLocDtlVO.java
 *@FileTitle : RsltPriSgGrpLocDtlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.21 박성수 
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

public class RsltPriSgGrpLocDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltPriSgGrpLocDtlVO> models = new ArrayList<RsltPriSgGrpLocDtlVO>();

	/* 而щ읆 �ㅻ챸 */
	private String grpLocDtlSeq = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String glineSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String grpLocSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String svcScpCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String scontiCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String scontiNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String updUsrId = null;
	/* 而щ읆 �ㅻ챸 */
	private String updDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String creDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String locNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String locCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String creUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltPriSgGrpLocDtlVO() {
	}

	public RsltPriSgGrpLocDtlVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String grpLocSeq,
			String grpLocDtlSeq, String locCd, String locNm, String scontiCd, String scontiNm, String creUsrId,
			String creDt, String updUsrId, String updDt) {
		this.grpLocDtlSeq = grpLocDtlSeq;
		this.ibflag = ibflag;
		this.glineSeq = glineSeq;
		this.grpLocSeq = grpLocSeq;
		this.svcScpCd = svcScpCd;
		this.scontiCd = scontiCd;
		this.scontiNm = scontiNm;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.creDt = creDt;
		this.locNm = locNm;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("grp_loc_dtl_seq", getGrpLocDtlSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("grp_loc_seq", getGrpLocSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("grp_loc_dtl_seq", "grpLocDtlSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("grp_loc_seq", "grpLocSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getGrpLocDtlSeq() {
		return this.grpLocDtlSeq;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getGlineSeq() {
		return this.glineSeq;
	}

	public String getGrpLocSeq() {
		return this.grpLocSeq;
	}

	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	public String getScontiCd() {
		return this.scontiCd;
	}

	public String getScontiNm() {
		return this.scontiNm;
	}

	public String getUpdUsrId() {
		return this.updUsrId;
	}

	public String getUpdDt() {
		return this.updDt;
	}

	public String getCreDt() {
		return this.creDt;
	}

	public String getLocNm() {
		return this.locNm;
	}

	public String getLocCd() {
		return this.locCd;
	}

	public String getCreUsrId() {
		return this.creUsrId;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public void setGrpLocDtlSeq(String grpLocDtlSeq) {
		this.grpLocDtlSeq = grpLocDtlSeq;
		// this.grpLocDtlSeq=true;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
		// this.glineSeq=true;
	}

	public void setGrpLocSeq(String grpLocSeq) {
		this.grpLocSeq = grpLocSeq;
		// this.grpLocSeq=true;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		// this.svcScpCd=true;
	}

	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
		// this.scontiCd=true;
	}

	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
		// this.scontiNm=true;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		// this.updUsrId=true;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		// this.updDt=true;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
		// this.creDt=true;
	}

	public void setLocNm(String locNm) {
		this.locNm = locNm;
		// this.locNm=true;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
		// this.locCd=true;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		// this.creUsrId=true;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	public void fromRequest(HttpServletRequest request) {
		setGrpLocDtlSeq(JSPUtil.getParameter(request, "grp_loc_dtl_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setGrpLocSeq(JSPUtil.getParameter(request, "grp_loc_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setScontiNm(JSPUtil.getParameter(request, "sconti_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setLocNm(JSPUtil.getParameter(request, "loc_nm", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RsltPriSgGrpLocDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltPriSgGrpLocDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSgGrpLocDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] grpLocDtlSeq = (JSPUtil.getParameter(request, prefix + "grp_loc_dtl_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq".trim(), length));
			String[] grpLocSeq = (JSPUtil.getParameter(request, prefix + "grp_loc_seq".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix + "sconti_cd".trim(), length));
			String[] scontiNm = (JSPUtil.getParameter(request, prefix + "sconti_nm".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
			String[] locNm = (JSPUtil.getParameter(request, prefix + "loc_nm".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltPriSgGrpLocDtlVO();
				if (grpLocDtlSeq[i] != null)
					model.setGrpLocDtlSeq(grpLocDtlSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (grpLocSeq[i] != null)
					model.setGrpLocSeq(grpLocSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
		}
		return getRsltPriSgGrpLocDtlVOs();
	}

	public RsltPriSgGrpLocDtlVO[] getRsltPriSgGrpLocDtlVOs() {
		RsltPriSgGrpLocDtlVO[] vos = (RsltPriSgGrpLocDtlVO[]) models.toArray(new RsltPriSgGrpLocDtlVO[models.size()]);
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
		this.grpLocDtlSeq = this.grpLocDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(
				":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocSeq = this.grpLocSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiNm = this.scontiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
