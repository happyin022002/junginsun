/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltGlineScpEffDtListVO.java
 *@FileTitle : RsltGlineScpEffDtListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.17
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.17 박성수 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo;

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

public class RsltGlineScpEffDtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltGlineScpEffDtListVO> models = new ArrayList<RsltGlineScpEffDtListVO>();

	/* 而щ읆 �ㅻ챸 */
	private String effDt = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String glineSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String expDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String svcScpCd = null;
	/* Page Number */
	private String pagerows = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltGlineScpEffDtListVO() {
	}

	public RsltGlineScpEffDtListVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String effDt,
			String expDt) {
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.glineSeq = glineSeq;
		this.expDt = expDt;
		this.svcScpCd = svcScpCd;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getEffDt() {
		return this.effDt;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getGlineSeq() {
		return this.glineSeq;
	}

	public String getExpDt() {
		return this.expDt;
	}

	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
		// this.effDt=true;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
		// this.glineSeq=true;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
		// this.expDt=true;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		// this.svcScpCd=true;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	public void fromRequest(HttpServletRequest request) {
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RsltGlineScpEffDtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltGlineScpEffDtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltGlineScpEffDtListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix + "exp_dt".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltGlineScpEffDtListVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
		}
		return getRsltGlineScpEffDtListVOs();
	}

	public RsltGlineScpEffDtListVO[] getRsltGlineScpEffDtListVOs() {
		RsltGlineScpEffDtListVO[] vos = (RsltGlineScpEffDtListVO[]) models.toArray(new RsltGlineScpEffDtListVO[models
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
		this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
