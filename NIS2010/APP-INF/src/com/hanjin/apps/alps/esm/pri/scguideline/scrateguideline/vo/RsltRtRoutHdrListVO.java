/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltRtRoutHdrListVO.java
 *@FileTitle : RsltRtRoutHdrListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.21 박성수 
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 박성수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtRoutHdrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RsltRtRoutHdrListVO> models = new ArrayList<RsltRtRoutHdrListVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String noteTooltip = null;
	/* Column Info */
	private String dirCallFlg = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String noteClssNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RsltRtRoutHdrListVO() {
	}

	public RsltRtRoutHdrListVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String prcCustTpCd,
			String cmdtHdrSeq, String routSeq, String dirCallFlg, String orgRoutPntLocDefCd,
			String orgRoutViaPortDefCd, String destRoutViaPortDefCd, String destRoutPntLocDefCd, String noteClssNm,
			String noteTooltip, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.noteTooltip = noteTooltip;
		this.dirCallFlg = dirCallFlg;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.glineSeq = glineSeq;
		this.noteClssNm = noteClssNm;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.prcCustTpCd = prcCustTpCd;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("note_tooltip", getNoteTooltip());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("note_clss_nm", getNoteClssNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("note_tooltip", "noteTooltip");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("note_clss_nm", "noteClssNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return noteTooltip
	 */
	public String getNoteTooltip() {
		return this.noteTooltip;
	}

	/**
	 * Column Info
	 * 
	 * @return dirCallFlg
	 */
	public String getDirCallFlg() {
		return this.dirCallFlg;
	}

	/**
	 * Column Info
	 * 
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
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
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
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
	 * @return noteClssNm
	 */
	public String getNoteClssNm() {
		return this.noteClssNm;
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
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * 
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param noteTooltip
	 */
	public void setNoteTooltip(String noteTooltip) {
		this.noteTooltip = noteTooltip;
	}

	/**
	 * Column Info
	 * 
	 * @param dirCallFlg
	 */
	public void setDirCallFlg(String dirCallFlg) {
		this.dirCallFlg = dirCallFlg;
	}

	/**
	 * Column Info
	 * 
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
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
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
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
	 * @param noteClssNm
	 */
	public void setNoteClssNm(String noteClssNm) {
		this.noteClssNm = noteClssNm;
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
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}

	/**
	 * Column Info
	 * 
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setNoteTooltip(JSPUtil.getParameter(request, "note_tooltip", ""));
		setDirCallFlg(JSPUtil.getParameter(request, "dir_call_flg", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, "dest_rout_via_port_def_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, "org_rout_pnt_loc_def_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setNoteClssNm(JSPUtil.getParameter(request, "note_clss_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, "dest_rout_pnt_loc_def_cd", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, "org_rout_via_port_def_cd", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return RsltRtRoutHdrListVO[]
	 */
	public RsltRtRoutHdrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return RsltRtRoutHdrListVO[]
	 */
	public RsltRtRoutHdrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtRoutHdrListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt".trim(), length));
			String[] noteTooltip = (JSPUtil.getParameter(request, prefix + "note_tooltip".trim(), length));
			String[] dirCallFlg = (JSPUtil.getParameter(request, prefix + "dir_call_flg".trim(), length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd".trim(),
					length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt".trim(), length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd".trim(),
					length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix + "gline_seq".trim(), length));
			String[] noteClssNm = (JSPUtil.getParameter(request, prefix + "note_clss_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix + "rout_seq".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd".trim(),
					length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd".trim(),
					length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix + "prc_cust_tp_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new RsltRtRoutHdrListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (noteTooltip[i] != null)
					model.setNoteTooltip(noteTooltip[i]);
				if (dirCallFlg[i] != null)
					model.setDirCallFlg(dirCallFlg[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (noteClssNm[i] != null)
					model.setNoteClssNm(noteClssNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtRoutHdrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return RsltRtRoutHdrListVO[]
	 */
	public RsltRtRoutHdrListVO[] getRsltRtRoutHdrListVOs() {
		RsltRtRoutHdrListVO[] vos = (RsltRtRoutHdrListVO[]) models.toArray(new RsltRtRoutHdrListVO[models.size()]);
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
		this.noteTooltip = this.noteTooltip.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.dirCallFlg = this.dirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/",
				"").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.glineSeq = this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteClssNm = this.noteClssNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "")
				.replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":",
				"");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
