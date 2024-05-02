/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltRtCmdtDetailVO.java
 *@FileTitle : RsltRtCmdtDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.13 박성수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scrateguideline.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 박성수
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class RsltRtCmdtDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltRtCmdtDetailVO> models = new ArrayList<RsltRtCmdtDetailVO>();

	/* Column Info */
	private String prcCmdtTpCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String cmdtSeq = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String prcCmdtDefNm = null;
	/* Page Number */
	private String pagerows = null;

	/* Table Column name으로 맴버변수 value 담는다 */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* Table Column name으로 맴버변수 name 담는다 */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltRtCmdtDetailVO() {
	}

	public RsltRtCmdtDetailVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String prcCustTpCd,
			String cmdtHdrSeq, String cmdtSeq, String prcCmdtTpCd, String prcCmdtDefCd, String prcCmdtDefNm,
			String creUsrId, String creDt, String updUsrId, String updDt) {
		this.prcCmdtTpCd = prcCmdtTpCd;
		this.ibflag = ibflag;
		this.cmdtSeq = cmdtSeq;
		this.glineSeq = glineSeq;
		this.svcScpCd = svcScpCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.prcCustTpCd = prcCustTpCd;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.prcCmdtDefNm = prcCmdtDefNm;
		this.pagerows = pagerows;
	}

	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("prc_cmdt_tp_cd", getPrcCmdtTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_seq", getCmdtSeq());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("prc_cmdt_def_nm", getPrcCmdtDefNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("prc_cmdt_tp_cd", "prcCmdtTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_seq", "cmdtSeq");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("prc_cmdt_def_nm", "prcCmdtDefNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return prcCmdtTpCd
	 */
	public String getPrcCmdtTpCd() {
		return this.prcCmdtTpCd;
	}

	/**
	 * Status
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return cmdtSeq
	 */
	public String getCmdtSeq() {
		return this.cmdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return prcCustTpCd
	 */
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}

	/**
	 * Column Info
	 * 
	 * @return prcCmdtDefNm
	 */
	public String getPrcCmdtDefNm() {
		return this.prcCmdtDefNm;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param prcCmdtTpCd
	 */
	public void setPrcCmdtTpCd(String prcCmdtTpCd) {
		this.prcCmdtTpCd = prcCmdtTpCd;
	}

	/**
	 * Status
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param cmdtSeq
	 */
	public void setCmdtSeq(String cmdtSeq) {
		this.cmdtSeq = cmdtSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param prcCustTpCd
	 */
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}

	/**
	 * Column Info
	 * 
	 * @param prcCmdtDefNm
	 */
	public void setPrcCmdtDefNm(String prcCmdtDefNm) {
		this.prcCmdtDefNm = prcCmdtDefNm;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPrcCmdtTpCd(JSPUtil.getParameter(request, "prc_cmdt_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtSeq(JSPUtil.getParameter(request, "cmdt_seq", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, "prc_cmdt_def_cd", ""));
		setPrcCmdtDefNm(JSPUtil.getParameter(request, "prc_cmdt_def_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * 
	 * @param request
	 * @return RsltRtCmdtDetailVO[]
	 */
	public RsltRtCmdtDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return RsltRtCmdtDetailVO[]
	 */
	public RsltRtCmdtDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtCmdtDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] prcCmdtTpCd = (JSPUtil.getParameter(request, prefix + "prc_cmdt_tp_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] cmdtSeq = (JSPUtil.getParameter(request, prefix + "cmdt_seq".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix + "prc_cust_tp_cd".trim(), length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd".trim(), length));
			String[] prcCmdtDefNm = (JSPUtil.getParameter(request, prefix + "prc_cmdt_def_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltRtCmdtDetailVO();
				if (prcCmdtTpCd[i] != null)
					model.setPrcCmdtTpCd(prcCmdtTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtSeq[i] != null)
					model.setCmdtSeq(cmdtSeq[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (prcCmdtDefNm[i] != null)
					model.setPrcCmdtDefNm(prcCmdtDefNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtCmdtDetailVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다
	 * 
	 * @return RsltRtCmdtDetailVO[]
	 */
	public RsltRtCmdtDetailVO[] getRsltRtCmdtDetailVOs() {
		RsltRtCmdtDetailVO[] vos = (RsltRtCmdtDetailVO[]) models.toArray(new RsltRtCmdtDetailVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
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
	public void unDataFormat() {
		this.prcCmdtTpCd = this.prcCmdtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtSeq = this.cmdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.prcCmdtDefCd = this.prcCmdtDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(
				":", "");
		this.prcCmdtDefNm = this.prcCmdtDefNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(
				":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
