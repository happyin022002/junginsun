/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltGriCalcGrpListVO.java
*@FileTitle : RsltGriCalcGrpListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.12.10 박성수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class RsltGriCalcGrpListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltGriCalcGrpListVO> models = new ArrayList<RsltGriCalcGrpListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fltPctTpCd = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgRoutViaPortDefNm = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String griGrpSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String orgRoutPntLocDefNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String destRoutPntLocDefNm = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String destRoutViaPortDefNm = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String griApplDivCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String griApplFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltGriCalcGrpListVO() {}

	public RsltGriCalcGrpListVO(String ibflag, String pagerows, String trfPfxCd, String trfNo, String griGrpSeq, String fltPctTpCd, String griApplDivCd, String griApplFlg, String cmdtCd, String cmdtNm, String orgRoutPntLocDefCd, String orgRoutPntLocDefNm, String orgRoutViaPortDefCd, String orgRoutViaPortDefNm, String destRoutViaPortDefCd, String destRoutViaPortDefNm, String destRoutPntLocDefCd, String destRoutPntLocDefNm, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.fltPctTpCd = fltPctTpCd;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.creDt = creDt;
		this.orgRoutViaPortDefNm = orgRoutViaPortDefNm;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.cmdtNm = cmdtNm;
		this.pagerows = pagerows;
		this.griGrpSeq = griGrpSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
		this.cmdtCd = cmdtCd;
		this.trfNo = trfNo;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.destRoutViaPortDefNm = destRoutViaPortDefNm;
		this.trfPfxCd = trfPfxCd;
		this.griApplDivCd = griApplDivCd;
		this.updUsrId = updUsrId;
		this.griApplFlg = griApplFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("flt_pct_tp_cd", getFltPctTpCd());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_rout_via_port_def_nm", getOrgRoutViaPortDefNm());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gri_grp_seq", getGriGrpSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("org_rout_pnt_loc_def_nm", getOrgRoutPntLocDefNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("dest_rout_pnt_loc_def_nm", getDestRoutPntLocDefNm());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("dest_rout_via_port_def_nm", getDestRoutViaPortDefNm());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("gri_appl_div_cd", getGriApplDivCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gri_appl_flg", getGriApplFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("flt_pct_tp_cd", "fltPctTpCd");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_rout_via_port_def_nm", "orgRoutViaPortDefNm");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gri_grp_seq", "griGrpSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_rout_pnt_loc_def_nm", "orgRoutPntLocDefNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("dest_rout_pnt_loc_def_nm", "destRoutPntLocDefNm");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("dest_rout_via_port_def_nm", "destRoutViaPortDefNm");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("gri_appl_div_cd", "griApplDivCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gri_appl_flg", "griApplFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return fltPctTpCd
	 */
	public String getFltPctTpCd() {
		return this.fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefNm
	 */
	public String getOrgRoutViaPortDefNm() {
		return this.orgRoutViaPortDefNm;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return griGrpSeq
	 */
	public String getGriGrpSeq() {
		return this.griGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefNm
	 */
	public String getOrgRoutPntLocDefNm() {
		return this.orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefNm
	 */
	public String getDestRoutPntLocDefNm() {
		return this.destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefNm
	 */
	public String getDestRoutViaPortDefNm() {
		return this.destRoutViaPortDefNm;
	}
	
	/**
	 * Column Info
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @return griApplDivCd
	 */
	public String getGriApplDivCd() {
		return this.griApplDivCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return griApplFlg
	 */
	public String getGriApplFlg() {
		return this.griApplFlg;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param fltPctTpCd
	 */
	public void setFltPctTpCd(String fltPctTpCd) {
		this.fltPctTpCd = fltPctTpCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefNm
	 */
	public void setOrgRoutViaPortDefNm(String orgRoutViaPortDefNm) {
		this.orgRoutViaPortDefNm = orgRoutViaPortDefNm;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param griGrpSeq
	 */
	public void setGriGrpSeq(String griGrpSeq) {
		this.griGrpSeq = griGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefNm
	 */
	public void setOrgRoutPntLocDefNm(String orgRoutPntLocDefNm) {
		this.orgRoutPntLocDefNm = orgRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefNm
	 */
	public void setDestRoutPntLocDefNm(String destRoutPntLocDefNm) {
		this.destRoutPntLocDefNm = destRoutPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefNm
	 */
	public void setDestRoutViaPortDefNm(String destRoutViaPortDefNm) {
		this.destRoutViaPortDefNm = destRoutViaPortDefNm;
	}
	
	/**
	 * Column Info
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @param griApplDivCd
	 */
	public void setGriApplDivCd(String griApplDivCd) {
		this.griApplDivCd = griApplDivCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param griApplFlg
	 */
	public void setGriApplFlg(String griApplFlg) {
		this.griApplFlg = griApplFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFltPctTpCd(JSPUtil.getParameter(request, "flt_pct_tp_cd", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, "dest_rout_via_port_def_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOrgRoutViaPortDefNm(JSPUtil.getParameter(request, "org_rout_via_port_def_nm", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, "org_rout_pnt_loc_def_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGriGrpSeq(JSPUtil.getParameter(request, "gri_grp_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOrgRoutPntLocDefNm(JSPUtil.getParameter(request, "org_rout_pnt_loc_def_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, "dest_rout_pnt_loc_def_cd", ""));
		setDestRoutPntLocDefNm(JSPUtil.getParameter(request, "dest_rout_pnt_loc_def_nm", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, "org_rout_via_port_def_cd", ""));
		setDestRoutViaPortDefNm(JSPUtil.getParameter(request, "dest_rout_via_port_def_nm", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, "trf_pfx_cd", ""));
		setGriApplDivCd(JSPUtil.getParameter(request, "gri_appl_div_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setGriApplFlg(JSPUtil.getParameter(request, "gri_appl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltGriCalcGrpListVO[]
	 */
	public RsltGriCalcGrpListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltGriCalcGrpListVO[]
	 */
	public RsltGriCalcGrpListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltGriCalcGrpListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "flt_pct_tp_cd", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] orgRoutViaPortDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_nm", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] griGrpSeq = (JSPUtil.getParameter(request, prefix	+ "gri_grp_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] orgRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] destRoutPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_nm", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] destRoutViaPortDefNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_nm", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] griApplDivCd = (JSPUtil.getParameter(request, prefix	+ "gri_appl_div_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] griApplFlg = (JSPUtil.getParameter(request, prefix	+ "gri_appl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltGriCalcGrpListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fltPctTpCd[i] != null)
					model.setFltPctTpCd(fltPctTpCd[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgRoutViaPortDefNm[i] != null)
					model.setOrgRoutViaPortDefNm(orgRoutViaPortDefNm[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (griGrpSeq[i] != null)
					model.setGriGrpSeq(griGrpSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (orgRoutPntLocDefNm[i] != null)
					model.setOrgRoutPntLocDefNm(orgRoutPntLocDefNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (destRoutPntLocDefNm[i] != null)
					model.setDestRoutPntLocDefNm(destRoutPntLocDefNm[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (destRoutViaPortDefNm[i] != null)
					model.setDestRoutViaPortDefNm(destRoutViaPortDefNm[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (griApplDivCd[i] != null)
					model.setGriApplDivCd(griApplDivCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (griApplFlg[i] != null)
					model.setGriApplFlg(griApplFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltGriCalcGrpListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltGriCalcGrpListVO[]
	 */
	public RsltGriCalcGrpListVO[] getRsltGriCalcGrpListVOs(){
		RsltGriCalcGrpListVO[] vos = (RsltGriCalcGrpListVO[])models.toArray(new RsltGriCalcGrpListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltPctTpCd = this.fltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefNm = this.orgRoutViaPortDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griGrpSeq = this.griGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefNm = this.orgRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefNm = this.destRoutPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefNm = this.destRoutViaPortDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplDivCd = this.griApplDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplFlg = this.griApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
