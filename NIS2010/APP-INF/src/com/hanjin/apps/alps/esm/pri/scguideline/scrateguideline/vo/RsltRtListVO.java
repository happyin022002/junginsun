/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltRtListVO.java
 *@FileTitle : RsltRtListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.11
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.11 박성수 
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

public class RsltRtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltRtListVO> models = new ArrayList<RsltRtListVO>();

	/* Column Info */
	private String prcCgoTpCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String mqcRngToQty = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String frtRtAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String mqcRngFmQty = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/* hashColumnInpo */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* hashFildInpo */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltRtListVO() {
	}

	public RsltRtListVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String prcCustTpCd,
			String cmdtHdrSeq, String routSeq, String rtSeq, String mqcRngFmQty, String mqcRngToQty, String ratUtCd,
			String prcCgoTpCd, String currCd, String frtRtAmt, String creUsrId, String creDt, String updUsrId,
			String updDt) {
		this.prcCgoTpCd = prcCgoTpCd;
		this.ibflag = ibflag;
		this.mqcRngToQty = mqcRngToQty;
		this.glineSeq = glineSeq;
		this.frtRtAmt = frtRtAmt;
		this.svcScpCd = svcScpCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.mqcRngFmQty = mqcRngFmQty;
		this.routSeq = routSeq;
		this.updUsrId = updUsrId;
		this.ratUtCd = ratUtCd;
		this.updDt = updDt;
		this.rtSeq = rtSeq;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.currCd = currCd;
		this.prcCustTpCd = prcCustTpCd;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mqc_rng_to_qty", getMqcRngToQty());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("mqc_rng_fm_qty", getMqcRngFmQty());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mqc_rng_to_qty", "mqcRngToQty");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("mqc_rng_fm_qty", "mqcRngFmQty");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}

	public String getIbflag() {
		return this.ibflag;
	}

	public String getMqcRngToQty() {
		return this.mqcRngToQty;
	}

	public String getGlineSeq() {
		return this.glineSeq;
	}

	public String getFrtRtAmt() {
		return this.frtRtAmt;
	}

	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}

	public String getMqcRngFmQty() {
		return this.mqcRngFmQty;
	}

	public String getRoutSeq() {
		return this.routSeq;
	}

	public String getUpdUsrId() {
		return this.updUsrId;
	}

	public String getRatUtCd() {
		return this.ratUtCd;
	}

	public String getUpdDt() {
		return this.updDt;
	}

	public String getRtSeq() {
		return this.rtSeq;
	}

	public String getCreDt() {
		return this.creDt;
	}

	public String getCreUsrId() {
		return this.creUsrId;
	}

	public String getCurrCd() {
		return this.currCd;
	}

	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
	}

	public String getPagerows() {
		return this.pagerows;
	}

	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
		// this.prcCgoTpCd=true;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		// this.ibflag=true;
	}

	public void setMqcRngToQty(String mqcRngToQty) {
		this.mqcRngToQty = mqcRngToQty;
		// this.mqcRngToQty=true;
	}

	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
		// this.glineSeq=true;
	}

	public void setFrtRtAmt(String frtRtAmt) {
		this.frtRtAmt = frtRtAmt;
		// this.frtRtAmt=true;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		// this.svcScpCd=true;
	}

	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
		// this.cmdtHdrSeq=true;
	}

	public void setMqcRngFmQty(String mqcRngFmQty) {
		this.mqcRngFmQty = mqcRngFmQty;
		// this.mqcRngFmQty=true;
	}

	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
		// this.routSeq=true;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		// this.updUsrId=true;
	}

	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
		// this.ratUtCd=true;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		// this.updDt=true;
	}

	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
		// this.rtSeq=true;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
		// this.creDt=true;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		// this.creUsrId=true;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
		// this.currCd=true;
	}

	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
		// this.prcCustTpCd=true;
	}

	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		// this.pagerows=true;
	}

	public void fromRequest(HttpServletRequest request) {
		setPrcCgoTpCd(JSPUtil.getParameter(request, "prc_cgo_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMqcRngToQty(JSPUtil.getParameter(request, "mqc_rng_to_qty", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setFrtRtAmt(JSPUtil.getParameter(request, "frt_rt_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setMqcRngFmQty(JSPUtil.getParameter(request, "mqc_rng_fm_qty", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RsltRtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltRtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] mqcRngToQty = (JSPUtil.getParameter(request, prefix + "mqc_rng_to_qty".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq".trim(), length));
			String[] frtRtAmt = (JSPUtil.getParameter(request, prefix + "frt_rt_amt".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq".trim(), length));
			String[] mqcRngFmQty = (JSPUtil.getParameter(request, prefix + "mqc_rng_fm_qty".trim(), length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix + "rout_seq".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix + "rat_ut_cd".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix + "rt_seq".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd".trim(), length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix + "prc_cust_tp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltRtListVO();
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mqcRngToQty[i] != null)
					model.setMqcRngToQty(mqcRngToQty[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (frtRtAmt[i] != null)
					model.setFrtRtAmt(frtRtAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (mqcRngFmQty[i] != null)
					model.setMqcRngFmQty(mqcRngFmQty[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtListVOs();
	}

	public RsltRtListVO[] getRsltRtListVOs() {
		RsltRtListVO[] vos = (RsltRtListVO[]) models.toArray(new RsltRtListVO[models.size()]);
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
		this.prcCgoTpCd = this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqcRngToQty = this.mqcRngToQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt = this.frtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.mqcRngFmQty = this.mqcRngFmQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.routSeq = this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
