/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchNodeConstraintVO.java
*@FileTitle : SearchNodeConstraintVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.24
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.02.24 박만건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchNodeConstraintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchNodeConstraintVO> models = new ArrayList<SearchNodeConstraintVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String portPntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String nodCnstSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oldNodCnstItmCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String pctlCnstItmNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String nodCnstRmk = null;
	/* Column Info */
	private String svcUseFlg = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String nodCnstItmCd = null;
	
	private String cnstCstExpt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchNodeConstraintVO() {}

	public SearchNodeConstraintVO(String ibflag, String pagerows, String nodCd, String nodCnstItmCd, String pctlCnstItmNm, String nodCnstRmk, String cntrTpCd, String effFmDt, String effToDt, String svcUseFlg, String creDt, String creOfcCd, String creUsrId, String updDt, String updOfcCd, String updUsrId, String nodCnstSeq, String oldNodCnstItmCd, String cmdtCd, String cmdtNm, String portPntCd, String vslSlanCd, String vvd, String cnstCstExpt) {
		this.updDt = updDt;
		this.portPntCd = portPntCd;
		this.creDt = creDt;
		this.vslSlanCd = vslSlanCd;
		this.cmdtNm = cmdtNm;
		this.nodCnstSeq = nodCnstSeq;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.oldNodCnstItmCd = oldNodCnstItmCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrTpCd = cntrTpCd;
		this.cmdtCd = cmdtCd;
		this.pctlCnstItmNm = pctlCnstItmNm;
		this.creOfcCd = creOfcCd;
		this.nodCnstRmk = nodCnstRmk;
		this.svcUseFlg = svcUseFlg;
		this.nodCd = nodCd;
		this.effFmDt = effFmDt;
		this.effToDt = effToDt;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.nodCnstItmCd = nodCnstItmCd;
		this.cnstCstExpt = cnstCstExpt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("port_pnt_cd", getPortPntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("nod_cnst_seq", getNodCnstSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("old_nod_cnst_itm_cd", getOldNodCnstItmCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("pctl_cnst_itm_nm", getPctlCnstItmNm());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("nod_cnst_rmk", getNodCnstRmk());
		this.hashColumns.put("svc_use_flg", getSvcUseFlg());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("eff_to_dt", getEffToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("nod_cnst_itm_cd", getNodCnstItmCd());
		this.hashColumns.put("cnst_cst_expt", getCnstCstExpt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("port_pnt_cd", "portPntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("nod_cnst_seq", "nodCnstSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("old_nod_cnst_itm_cd", "oldNodCnstItmCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("pctl_cnst_itm_nm", "pctlCnstItmNm");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("nod_cnst_rmk", "nodCnstRmk");
		this.hashFields.put("svc_use_flg", "svcUseFlg");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("nod_cnst_itm_cd", "nodCnstItmCd");
		this.hashFields.put("cnst_cst_expt", "cnstCstExpt");
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
	 * @return portPntCd
	 */
	public String getPortPntCd() {
		return this.portPntCd;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return nodCnstSeq
	 */
	public String getNodCnstSeq() {
		return this.nodCnstSeq;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return oldNodCnstItmCd
	 */
	public String getOldNodCnstItmCd() {
		return this.oldNodCnstItmCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
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
	 * @return pctlCnstItmNm
	 */
	public String getPctlCnstItmNm() {
		return this.pctlCnstItmNm;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return nodCnstRmk
	 */
	public String getNodCnstRmk() {
		return this.nodCnstRmk;
	}
	
	/**
	 * Column Info
	 * @return svcUseFlg
	 */
	public String getSvcUseFlg() {
		return this.svcUseFlg;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return nodCnstItmCd
	 */
	public String getNodCnstItmCd() {
		return this.nodCnstItmCd;
	}
	
	public String getCnstCstExpt() {
		return cnstCstExpt;
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
	 * @param portPntCd
	 */
	public void setPortPntCd(String portPntCd) {
		this.portPntCd = portPntCd;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param nodCnstSeq
	 */
	public void setNodCnstSeq(String nodCnstSeq) {
		this.nodCnstSeq = nodCnstSeq;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param oldNodCnstItmCd
	 */
	public void setOldNodCnstItmCd(String oldNodCnstItmCd) {
		this.oldNodCnstItmCd = oldNodCnstItmCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
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
	 * @param pctlCnstItmNm
	 */
	public void setPctlCnstItmNm(String pctlCnstItmNm) {
		this.pctlCnstItmNm = pctlCnstItmNm;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param nodCnstRmk
	 */
	public void setNodCnstRmk(String nodCnstRmk) {
		this.nodCnstRmk = nodCnstRmk;
	}
	
	/**
	 * Column Info
	 * @param svcUseFlg
	 */
	public void setSvcUseFlg(String svcUseFlg) {
		this.svcUseFlg = svcUseFlg;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param nodCnstItmCd
	 */
	public void setNodCnstItmCd(String nodCnstItmCd) {
		this.nodCnstItmCd = nodCnstItmCd;
	}
	
	public void setCnstCstExpt(String cnstCstExpt) {
		this.cnstCstExpt = cnstCstExpt;
	}	
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPortPntCd(JSPUtil.getParameter(request, prefix + "port_pnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setNodCnstSeq(JSPUtil.getParameter(request, prefix + "nod_cnst_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOldNodCnstItmCd(JSPUtil.getParameter(request, prefix + "old_nod_cnst_itm_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setPctlCnstItmNm(JSPUtil.getParameter(request, prefix + "pctl_cnst_itm_nm", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setNodCnstRmk(JSPUtil.getParameter(request, prefix + "nod_cnst_rmk", ""));
		setSvcUseFlg(JSPUtil.getParameter(request, prefix + "svc_use_flg", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setNodCnstItmCd(JSPUtil.getParameter(request, prefix + "nod_cnst_itm_cd", ""));
		setCnstCstExpt(JSPUtil.getParameter(request, prefix + "cnst_cst_expt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchNodeConstraintVO[]
	 */
	public SearchNodeConstraintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchNodeConstraintVO[]
	 */
	public SearchNodeConstraintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchNodeConstraintVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] portPntCd = (JSPUtil.getParameter(request, prefix	+ "port_pnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] nodCnstSeq = (JSPUtil.getParameter(request, prefix	+ "nod_cnst_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oldNodCnstItmCd = (JSPUtil.getParameter(request, prefix	+ "old_nod_cnst_itm_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] pctlCnstItmNm = (JSPUtil.getParameter(request, prefix	+ "pctl_cnst_itm_nm", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] nodCnstRmk = (JSPUtil.getParameter(request, prefix	+ "nod_cnst_rmk", length));
			String[] svcUseFlg = (JSPUtil.getParameter(request, prefix	+ "svc_use_flg", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] nodCnstItmCd = (JSPUtil.getParameter(request, prefix	+ "nod_cnst_itm_cd", length));
			String[] cnstCstExpt = (JSPUtil.getParameter(request, prefix	+ "cnst_cst_expt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchNodeConstraintVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (portPntCd[i] != null)
					model.setPortPntCd(portPntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (nodCnstSeq[i] != null)
					model.setNodCnstSeq(nodCnstSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oldNodCnstItmCd[i] != null)
					model.setOldNodCnstItmCd(oldNodCnstItmCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (pctlCnstItmNm[i] != null)
					model.setPctlCnstItmNm(pctlCnstItmNm[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (nodCnstRmk[i] != null)
					model.setNodCnstRmk(nodCnstRmk[i]);
				if (svcUseFlg[i] != null)
					model.setSvcUseFlg(svcUseFlg[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (nodCnstItmCd[i] != null)
					model.setNodCnstItmCd(nodCnstItmCd[i]);
				if (cnstCstExpt[i] != null)
					model.setCnstCstExpt(cnstCstExpt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchNodeConstraintVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchNodeConstraintVO[]
	 */
	public SearchNodeConstraintVO[] getSearchNodeConstraintVOs(){
		SearchNodeConstraintVO[] vos = (SearchNodeConstraintVO[])models.toArray(new SearchNodeConstraintVO[models.size()]);
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
		this.portPntCd = this.portPntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCnstSeq = this.nodCnstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldNodCnstItmCd = this.oldNodCnstItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlCnstItmNm = this.pctlCnstItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCnstRmk = this.nodCnstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcUseFlg = this.svcUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCnstItmCd = this.nodCnstItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnstCstExpt = this.cnstCstExpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
