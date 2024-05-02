/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DestPriSgRtRoutPntVO.java
 *@FileTitle : DestPriSgRtRoutPntVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.01 박성수 
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 박성수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtRoutPntListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltRtRoutPntListVO> models = new ArrayList<RsltRtRoutPntListVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String routPntLocDefNm = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String glineSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prcTrspModCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String routPntSeq = null;
	/* Column Info */
	private String routPntLocTpCd = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltRtRoutPntListVO() {
	}

	public RsltRtRoutPntListVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String prcCustTpCd,
			String cmdtHdrSeq, String routSeq, String orgDestTpCd, String routPntSeq, String routPntLocTpCd,
			String routPntLocDefCd, String routPntLocDefNm, String prcTrspModCd, String rcvDeTermCd, String creUsrId,
			String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.routPntLocDefNm = routPntLocDefNm;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.orgDestTpCd = orgDestTpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.glineSeq = glineSeq;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.prcTrspModCd = prcTrspModCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.prcCustTpCd = prcCustTpCd;
		this.updUsrId = updUsrId;
		this.routPntSeq = routPntSeq;
		this.routPntLocTpCd = routPntLocTpCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("rout_pnt_loc_def_nm", getRoutPntLocDefNm());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rout_pnt_seq", getRoutPntSeq());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("rout_pnt_loc_def_nm", "routPntLocDefNm");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rout_pnt_seq", "routPntSeq");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		return this.hashFields;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return routPntLocDefNm
	 */
	public String getRoutPntLocDefNm() {
		return this.routPntLocDefNm;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}

	/**
	 * Column Info
	 * 
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return prcTrspModCd
	 */
	public String getPrcTrspModCd() {
		return this.prcTrspModCd;
	}

	/**
	 * Column Info
	 * 
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return routPntSeq
	 */
	public String getRoutPntSeq() {
		return this.routPntSeq;
	}

	/**
	 * Column Info
	 * 
	 * @return routPntLocTpCd
	 */
	public String getRoutPntLocTpCd() {
		return this.routPntLocTpCd;
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
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param routPntLocDefNm
	 */
	public void setRoutPntLocDefNm(String routPntLocDefNm) {
		this.routPntLocDefNm = routPntLocDefNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * Column Info
	 * 
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
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
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param prcTrspModCd
	 */
	public void setPrcTrspModCd(String prcTrspModCd) {
		this.prcTrspModCd = prcTrspModCd;
	}

	/**
	 * Column Info
	 * 
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param routPntSeq
	 */
	public void setRoutPntSeq(String routPntSeq) {
		this.routPntSeq = routPntSeq;
	}

	/**
	 * Column Info
	 * 
	 * @param routPntLocTpCd
	 */
	public void setRoutPntLocTpCd(String routPntLocTpCd) {
		this.routPntLocTpCd = routPntLocTpCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setRoutPntLocDefNm(JSPUtil.getParameter(request, "rout_pnt_loc_def_nm", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, "rout_pnt_loc_def_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request, "prc_trsp_mod_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRoutPntSeq(JSPUtil.getParameter(request, "rout_pnt_seq", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request, "rout_pnt_loc_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return DestPriSgRtRoutPntVO[]
	 */
	public RsltRtRoutPntListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return DestPriSgRtRoutPntVO[]
	 */
	public RsltRtRoutPntListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtRoutPntListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq".trim(), length));
			String[] routPntLocDefNm = (JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_nm".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix + "org_dest_tp_cd".trim(), length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd".trim(), length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix + "rout_seq".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] prcTrspModCd = (JSPUtil.getParameter(request, prefix + "prc_trsp_mod_cd".trim(), length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix + "rcv_de_term_cd".trim(), length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix + "prc_cust_tp_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));
			String[] routPntSeq = (JSPUtil.getParameter(request, prefix + "rout_pnt_seq".trim(), length));
			String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix + "rout_pnt_loc_tp_cd".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltRtRoutPntListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (routPntLocDefNm[i] != null)
					model.setRoutPntLocDefNm(routPntLocDefNm[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prcTrspModCd[i] != null)
					model.setPrcTrspModCd(prcTrspModCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (routPntSeq[i] != null)
					model.setRoutPntSeq(routPntSeq[i]);
				if (routPntLocTpCd[i] != null)
					model.setRoutPntLocTpCd(routPntLocTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDestPriSgRtRoutPntVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return DestPriSgRtRoutPntVO[]
	 */
	public RsltRtRoutPntListVO[] getDestPriSgRtRoutPntVOs() {
		RsltRtRoutPntListVO[] vos = (RsltRtRoutPntListVO[]) models.toArray(new RsltRtRoutPntListVO[models.size()]);
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
	 * 필드에 있는 값을 스트링 배열로 반환.
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
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.routPntLocDefNm = this.routPntLocDefNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.routPntLocDefCd = this.routPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd = this.prcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(
				":", "");
		this.rcvDeTermCd = this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.prcCustTpCd = this.prcCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntSeq = this.routPntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.routPntLocTpCd = this.routPntLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
	}
}
