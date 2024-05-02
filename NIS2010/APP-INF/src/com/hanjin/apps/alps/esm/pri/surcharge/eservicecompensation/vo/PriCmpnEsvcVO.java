/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PriCmpnEsvcVO.java
*@FileTitle : PriCmpnEsvcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.02.23 김대호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo;

import java.lang.reflect.Field;
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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriCmpnEsvcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriCmpnEsvcVO> models = new ArrayList<PriCmpnEsvcVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cmpnSeq = null;
	/* Column Info */
	private String fltPctTpCd = null;
	/* Column Info */
	private String prcEsvcTpCdD = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cmpnRmk = null;
	/* Column Info */
	private String prcEsvcTpCdE = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String destRgnCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String orgRgnCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String dcAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prcEsvcTpCdW = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String dcPer = null;
	/* Column Info */
	private String prcCtrtTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriCmpnEsvcVO() {}

	public PriCmpnEsvcVO(String ibflag, String pagerows, String cmpnSeq, String svcScpCd, String orgRgnCd, String destRgnCd, String prcEsvcTpCdW, String prcEsvcTpCdE, String prcEsvcTpCdD, String prcCtrtTpCd, String scNo, String rfaNo, String chgCd, String currCd, String fltPctTpCd, String dcAmt, String dcPer, String effDt, String expDt, String cmpnRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.cmpnSeq = cmpnSeq;
		this.fltPctTpCd = fltPctTpCd;
		this.prcEsvcTpCdD = prcEsvcTpCdD;
		this.currCd = currCd;
		this.cmpnRmk = cmpnRmk;
		this.prcEsvcTpCdE = prcEsvcTpCdE;
		this.svcScpCd = svcScpCd;
		this.destRgnCd = destRgnCd;
		this.creDt = creDt;
		this.orgRgnCd = orgRgnCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.creUsrId = creUsrId;
		this.effDt = effDt;
		this.dcAmt = dcAmt;
		this.ibflag = ibflag;
		this.prcEsvcTpCdW = prcEsvcTpCdW;
		this.scNo = scNo;
		this.expDt = expDt;
		this.dcPer = dcPer;
		this.prcCtrtTpCd = prcCtrtTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cmpn_seq", getCmpnSeq());
		this.hashColumns.put("flt_pct_tp_cd", getFltPctTpCd());
		this.hashColumns.put("prc_esvc_tp_cd_d", getPrcEsvcTpCdD());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cmpn_rmk", getCmpnRmk());
		this.hashColumns.put("prc_esvc_tp_cd_e", getPrcEsvcTpCdE());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dest_rgn_cd", getDestRgnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("org_rgn_cd", getOrgRgnCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("dc_amt", getDcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prc_esvc_tp_cd_w", getPrcEsvcTpCdW());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dc_per", getDcPer());
		this.hashColumns.put("prc_ctrt_tp_cd", getPrcCtrtTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cmpn_seq", "cmpnSeq");
		this.hashFields.put("flt_pct_tp_cd", "fltPctTpCd");
		this.hashFields.put("prc_esvc_tp_cd_d", "prcEsvcTpCdD");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cmpn_rmk", "cmpnRmk");
		this.hashFields.put("prc_esvc_tp_cd_e", "prcEsvcTpCdE");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dest_rgn_cd", "destRgnCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("org_rgn_cd", "orgRgnCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("dc_amt", "dcAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prc_esvc_tp_cd_w", "prcEsvcTpCdW");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dc_per", "dcPer");
		this.hashFields.put("prc_ctrt_tp_cd", "prcCtrtTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return cmpnSeq
	 */
	public String getCmpnSeq() {
		return this.cmpnSeq;
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
	 * @return prcEsvcTpCdD
	 */
	public String getPrcEsvcTpCdD() {
		return this.prcEsvcTpCdD;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return cmpnRmk
	 */
	public String getCmpnRmk() {
		return this.cmpnRmk;
	}
	
	/**
	 * Column Info
	 * @return prcEsvcTpCdE
	 */
	public String getPrcEsvcTpCdE() {
		return this.prcEsvcTpCdE;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return destRgnCd
	 */
	public String getDestRgnCd() {
		return this.destRgnCd;
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
	 * @return orgRgnCd
	 */
	public String getOrgRgnCd() {
		return this.orgRgnCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return dcAmt
	 */
	public String getDcAmt() {
		return this.dcAmt;
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
	 * @return prcEsvcTpCdW
	 */
	public String getPrcEsvcTpCdW() {
		return this.prcEsvcTpCdW;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return dcPer
	 */
	public String getDcPer() {
		return this.dcPer;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtTpCd
	 */
	public String getPrcCtrtTpCd() {
		return this.prcCtrtTpCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cmpnSeq
	 */
	public void setCmpnSeq(String cmpnSeq) {
		this.cmpnSeq = cmpnSeq;
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
	 * @param prcEsvcTpCdD
	 */
	public void setPrcEsvcTpCdD(String prcEsvcTpCdD) {
		this.prcEsvcTpCdD = prcEsvcTpCdD;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param cmpnRmk
	 */
	public void setCmpnRmk(String cmpnRmk) {
		this.cmpnRmk = cmpnRmk;
	}
	
	/**
	 * Column Info
	 * @param prcEsvcTpCdE
	 */
	public void setPrcEsvcTpCdE(String prcEsvcTpCdE) {
		this.prcEsvcTpCdE = prcEsvcTpCdE;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param destRgnCd
	 */
	public void setDestRgnCd(String destRgnCd) {
		this.destRgnCd = destRgnCd;
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
	 * @param orgRgnCd
	 */
	public void setOrgRgnCd(String orgRgnCd) {
		this.orgRgnCd = orgRgnCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param dcAmt
	 */
	public void setDcAmt(String dcAmt) {
		this.dcAmt = dcAmt;
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
	 * @param prcEsvcTpCdW
	 */
	public void setPrcEsvcTpCdW(String prcEsvcTpCdW) {
		this.prcEsvcTpCdW = prcEsvcTpCdW;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param dcPer
	 */
	public void setDcPer(String dcPer) {
		this.dcPer = dcPer;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtTpCd
	 */
	public void setPrcCtrtTpCd(String prcCtrtTpCd) {
		this.prcCtrtTpCd = prcCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setCmpnSeq(JSPUtil.getParameter(request, prefix + "cmpn_seq", ""));
		setFltPctTpCd(JSPUtil.getParameter(request, prefix + "flt_pct_tp_cd", ""));
		setPrcEsvcTpCdD(JSPUtil.getParameter(request, prefix + "prc_esvc_tp_cd_d", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCmpnRmk(JSPUtil.getParameter(request, prefix + "cmpn_rmk", ""));
		setPrcEsvcTpCdE(JSPUtil.getParameter(request, prefix + "prc_esvc_tp_cd_e", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDestRgnCd(JSPUtil.getParameter(request, prefix + "dest_rgn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOrgRgnCd(JSPUtil.getParameter(request, prefix + "org_rgn_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setDcAmt(JSPUtil.getParameter(request, prefix + "dc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrcEsvcTpCdW(JSPUtil.getParameter(request, prefix + "prc_esvc_tp_cd_w", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setDcPer(JSPUtil.getParameter(request, prefix + "dc_per", ""));
		setPrcCtrtTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriCmpnEsvcVO[]
	 */
	public PriCmpnEsvcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriCmpnEsvcVO[]
	 */
	public PriCmpnEsvcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriCmpnEsvcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cmpnSeq = (JSPUtil.getParameter(request, prefix	+ "cmpn_seq", length));
			String[] fltPctTpCd = (JSPUtil.getParameter(request, prefix	+ "flt_pct_tp_cd", length));
			String[] prcEsvcTpCdD = (JSPUtil.getParameter(request, prefix	+ "prc_esvc_tp_cd_d", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cmpnRmk = (JSPUtil.getParameter(request, prefix	+ "cmpn_rmk", length));
			String[] prcEsvcTpCdE = (JSPUtil.getParameter(request, prefix	+ "prc_esvc_tp_cd_e", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] destRgnCd = (JSPUtil.getParameter(request, prefix	+ "dest_rgn_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] orgRgnCd = (JSPUtil.getParameter(request, prefix	+ "org_rgn_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] dcAmt = (JSPUtil.getParameter(request, prefix	+ "dc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prcEsvcTpCdW = (JSPUtil.getParameter(request, prefix	+ "prc_esvc_tp_cd_w", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] dcPer = (JSPUtil.getParameter(request, prefix	+ "dc_per", length));
			String[] prcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriCmpnEsvcVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cmpnSeq[i] != null)
					model.setCmpnSeq(cmpnSeq[i]);
				if (fltPctTpCd[i] != null)
					model.setFltPctTpCd(fltPctTpCd[i]);
				if (prcEsvcTpCdD[i] != null)
					model.setPrcEsvcTpCdD(prcEsvcTpCdD[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cmpnRmk[i] != null)
					model.setCmpnRmk(cmpnRmk[i]);
				if (prcEsvcTpCdE[i] != null)
					model.setPrcEsvcTpCdE(prcEsvcTpCdE[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (destRgnCd[i] != null)
					model.setDestRgnCd(destRgnCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (orgRgnCd[i] != null)
					model.setOrgRgnCd(orgRgnCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (dcAmt[i] != null)
					model.setDcAmt(dcAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prcEsvcTpCdW[i] != null)
					model.setPrcEsvcTpCdW(prcEsvcTpCdW[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (dcPer[i] != null)
					model.setDcPer(dcPer[i]);
				if (prcCtrtTpCd[i] != null)
					model.setPrcCtrtTpCd(prcCtrtTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriCmpnEsvcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriCmpnEsvcVO[]
	 */
	public PriCmpnEsvcVO[] getPriCmpnEsvcVOs(){
		PriCmpnEsvcVO[] vos = (PriCmpnEsvcVO[])models.toArray(new PriCmpnEsvcVO[models.size()]);
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
		this.cmpnSeq = this.cmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltPctTpCd = this.fltPctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcEsvcTpCdD = this.prcEsvcTpCdD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnRmk = this.cmpnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcEsvcTpCdE = this.prcEsvcTpCdE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRgnCd = this.destRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRgnCd = this.orgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcAmt = this.dcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcEsvcTpCdW = this.prcEsvcTpCdW .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcPer = this.dcPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtTpCd = this.prcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
