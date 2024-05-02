/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltRfaGlineCopyVO.java
*@FileTitle : RsltRfaGlineCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.25 문동규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRfaGlineCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRfaGlineCopyVO> models = new ArrayList<RsltRfaGlineCopyVO>();
	
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aroLocChk = null;
	/* Column Info */
	private String trgtEffDt = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String rtCmdtChk = null;
	/* Column Info */
	private String ardLocChk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trgtExpDt = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String trgtSvcScpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String arbOrgChk = null;
	/* Column Info */
	private String trgtGlineSeq = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String rtLocChk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String locChk = null;
	/* Column Info */
	private String cmdtChk = null;
	/* Column Info */
	private String rateChk = null;
	/* Column Info */
	private String arbDesChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRfaGlineCopyVO() {}

	public RsltRfaGlineCopyVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String effDt, String expDt, String locChk, String cmdtChk, String arbOrgChk, String arbDesChk, String rateChk, String rtCmdtChk, String rtLocChk, String aroLocChk, String ardLocChk, String trgtSvcScpCd, String trgtGlineSeq, String trgtEffDt, String trgtExpDt, String orgDestTpCd, String creUsrId, String creDt, String updUsrId, String updDt, String usrId) {
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.aroLocChk = aroLocChk;
		this.trgtEffDt = trgtEffDt;
		this.glineSeq = glineSeq;
		this.rtCmdtChk = rtCmdtChk;
		this.ardLocChk = ardLocChk;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.trgtExpDt = trgtExpDt;
		this.usrId = usrId;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.trgtSvcScpCd = trgtSvcScpCd;
		this.updDt = updDt;
		this.arbOrgChk = arbOrgChk;
		this.trgtGlineSeq = trgtGlineSeq;
		this.orgDestTpCd = orgDestTpCd;
		this.rtLocChk = rtLocChk;
		this.creUsrId = creUsrId;
		this.locChk = locChk;
		this.cmdtChk = cmdtChk;
		this.rateChk = rateChk;
		this.arbDesChk = arbDesChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("aro_loc_chk", getAroLocChk());
		this.hashColumns.put("trgt_eff_dt", getTrgtEffDt());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("rt_cmdt_chk", getRtCmdtChk());
		this.hashColumns.put("ard_loc_chk", getArdLocChk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trgt_exp_dt", getTrgtExpDt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("trgt_svc_scp_cd", getTrgtSvcScpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("arb_org_chk", getArbOrgChk());
		this.hashColumns.put("trgt_gline_seq", getTrgtGlineSeq());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rt_loc_chk", getRtLocChk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("loc_chk", getLocChk());
		this.hashColumns.put("cmdt_chk", getCmdtChk());
		this.hashColumns.put("rate_chk", getRateChk());
		this.hashColumns.put("arb_des_chk", getArbDesChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("aro_loc_chk", "aroLocChk");
		this.hashFields.put("trgt_eff_dt", "trgtEffDt");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("rt_cmdt_chk", "rtCmdtChk");
		this.hashFields.put("ard_loc_chk", "ardLocChk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trgt_exp_dt", "trgtExpDt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("trgt_svc_scp_cd", "trgtSvcScpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("arb_org_chk", "arbOrgChk");
		this.hashFields.put("trgt_gline_seq", "trgtGlineSeq");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rt_loc_chk", "rtLocChk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("loc_chk", "locChk");
		this.hashFields.put("cmdt_chk", "cmdtChk");
		this.hashFields.put("rate_chk", "rateChk");
		this.hashFields.put("arb_des_chk", "arbDesChk");
		return this.hashFields;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return aroLocChk
	 */
	public String getAroLocChk() {
		return this.aroLocChk;
	}
	
	/**
	 * Column Info
	 * @return trgtEffDt
	 */
	public String getTrgtEffDt() {
		return this.trgtEffDt;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return rtCmdtChk
	 */
	public String getRtCmdtChk() {
		return this.rtCmdtChk;
	}
	
	/**
	 * Column Info
	 * @return ardLocChk
	 */
	public String getArdLocChk() {
		return this.ardLocChk;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return trgtExpDt
	 */
	public String getTrgtExpDt() {
		return this.trgtExpDt;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return trgtSvcScpCd
	 */
	public String getTrgtSvcScpCd() {
		return this.trgtSvcScpCd;
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
	 * @return arbOrgChk
	 */
	public String getArbOrgChk() {
		return this.arbOrgChk;
	}
	
	/**
	 * Column Info
	 * @return trgtGlineSeq
	 */
	public String getTrgtGlineSeq() {
		return this.trgtGlineSeq;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return rtLocChk
	 */
	public String getRtLocChk() {
		return this.rtLocChk;
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
	 * @return locChk
	 */
	public String getLocChk() {
		return this.locChk;
	}
	
	/**
	 * Column Info
	 * @return cmdtChk
	 */
	public String getCmdtChk() {
		return this.cmdtChk;
	}
	
	/**
	 * Column Info
	 * @return rateChk
	 */
	public String getRateChk() {
		return this.rateChk;
	}
	
	/**
	 * Column Info
	 * @return arbDesChk
	 */
	public String getArbDesChk() {
		return this.arbDesChk;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param aroLocChk
	 */
	public void setAroLocChk(String aroLocChk) {
		this.aroLocChk = aroLocChk;
	}
	
	/**
	 * Column Info
	 * @param trgtEffDt
	 */
	public void setTrgtEffDt(String trgtEffDt) {
		this.trgtEffDt = trgtEffDt;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param rtCmdtChk
	 */
	public void setRtCmdtChk(String rtCmdtChk) {
		this.rtCmdtChk = rtCmdtChk;
	}
	
	/**
	 * Column Info
	 * @param ardLocChk
	 */
	public void setArdLocChk(String ardLocChk) {
		this.ardLocChk = ardLocChk;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param trgtExpDt
	 */
	public void setTrgtExpDt(String trgtExpDt) {
		this.trgtExpDt = trgtExpDt;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param trgtSvcScpCd
	 */
	public void setTrgtSvcScpCd(String trgtSvcScpCd) {
		this.trgtSvcScpCd = trgtSvcScpCd;
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
	 * @param arbOrgChk
	 */
	public void setArbOrgChk(String arbOrgChk) {
		this.arbOrgChk = arbOrgChk;
	}
	
	/**
	 * Column Info
	 * @param trgtGlineSeq
	 */
	public void setTrgtGlineSeq(String trgtGlineSeq) {
		this.trgtGlineSeq = trgtGlineSeq;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param rtLocChk
	 */
	public void setRtLocChk(String rtLocChk) {
		this.rtLocChk = rtLocChk;
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
	 * @param locChk
	 */
	public void setLocChk(String locChk) {
		this.locChk = locChk;
	}
	
	/**
	 * Column Info
	 * @param cmdtChk
	 */
	public void setCmdtChk(String cmdtChk) {
		this.cmdtChk = cmdtChk;
	}
	
	/**
	 * Column Info
	 * @param rateChk
	 */
	public void setRateChk(String rateChk) {
		this.rateChk = rateChk;
	}
	
	/**
	 * Column Info
	 * @param arbDesChk
	 */
	public void setArbDesChk(String arbDesChk) {
		this.arbDesChk = arbDesChk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAroLocChk(JSPUtil.getParameter(request, "aro_loc_chk", ""));
		setTrgtEffDt(JSPUtil.getParameter(request, "trgt_eff_dt", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setRtCmdtChk(JSPUtil.getParameter(request, "rt_cmdt_chk", ""));
		setArdLocChk(JSPUtil.getParameter(request, "ard_loc_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrgtExpDt(JSPUtil.getParameter(request, "trgt_exp_dt", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTrgtSvcScpCd(JSPUtil.getParameter(request, "trgt_svc_scp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setArbOrgChk(JSPUtil.getParameter(request, "arb_org_chk", ""));
		setTrgtGlineSeq(JSPUtil.getParameter(request, "trgt_gline_seq", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setRtLocChk(JSPUtil.getParameter(request, "rt_loc_chk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setLocChk(JSPUtil.getParameter(request, "loc_chk", ""));
		setCmdtChk(JSPUtil.getParameter(request, "cmdt_chk", ""));
		setRateChk(JSPUtil.getParameter(request, "rate_chk", ""));
		setArbDesChk(JSPUtil.getParameter(request, "arb_des_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRfaGlineCopyVO[]
	 */
	public RsltRfaGlineCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRfaGlineCopyVO[]
	 */
	public RsltRfaGlineCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRfaGlineCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aroLocChk = (JSPUtil.getParameter(request, prefix	+ "aro_loc_chk", length));
			String[] trgtEffDt = (JSPUtil.getParameter(request, prefix	+ "trgt_eff_dt", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] rtCmdtChk = (JSPUtil.getParameter(request, prefix	+ "rt_cmdt_chk", length));
			String[] ardLocChk = (JSPUtil.getParameter(request, prefix	+ "ard_loc_chk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trgtExpDt = (JSPUtil.getParameter(request, prefix	+ "trgt_exp_dt", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] trgtSvcScpCd = (JSPUtil.getParameter(request, prefix	+ "trgt_svc_scp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] arbOrgChk = (JSPUtil.getParameter(request, prefix	+ "arb_org_chk", length));
			String[] trgtGlineSeq = (JSPUtil.getParameter(request, prefix	+ "trgt_gline_seq", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] rtLocChk = (JSPUtil.getParameter(request, prefix	+ "rt_loc_chk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] locChk = (JSPUtil.getParameter(request, prefix	+ "loc_chk", length));
			String[] cmdtChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_chk", length));
			String[] rateChk = (JSPUtil.getParameter(request, prefix	+ "rate_chk", length));
			String[] arbDesChk = (JSPUtil.getParameter(request, prefix	+ "arb_des_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRfaGlineCopyVO();
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aroLocChk[i] != null)
					model.setAroLocChk(aroLocChk[i]);
				if (trgtEffDt[i] != null)
					model.setTrgtEffDt(trgtEffDt[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (rtCmdtChk[i] != null)
					model.setRtCmdtChk(rtCmdtChk[i]);
				if (ardLocChk[i] != null)
					model.setArdLocChk(ardLocChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trgtExpDt[i] != null)
					model.setTrgtExpDt(trgtExpDt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (trgtSvcScpCd[i] != null)
					model.setTrgtSvcScpCd(trgtSvcScpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (arbOrgChk[i] != null)
					model.setArbOrgChk(arbOrgChk[i]);
				if (trgtGlineSeq[i] != null)
					model.setTrgtGlineSeq(trgtGlineSeq[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (rtLocChk[i] != null)
					model.setRtLocChk(rtLocChk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (locChk[i] != null)
					model.setLocChk(locChk[i]);
				if (cmdtChk[i] != null)
					model.setCmdtChk(cmdtChk[i]);
				if (rateChk[i] != null)
					model.setRateChk(rateChk[i]);
				if (arbDesChk[i] != null)
					model.setArbDesChk(arbDesChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRfaGlineCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRfaGlineCopyVO[]
	 */
	public RsltRfaGlineCopyVO[] getRsltRfaGlineCopyVOs(){
		RsltRfaGlineCopyVO[] vos = (RsltRfaGlineCopyVO[])models.toArray(new RsltRfaGlineCopyVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
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
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aroLocChk = this.aroLocChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trgtEffDt = this.trgtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtCmdtChk = this.rtCmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ardLocChk = this.ardLocChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trgtExpDt = this.trgtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trgtSvcScpCd = this.trgtSvcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbOrgChk = this.arbOrgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trgtGlineSeq = this.trgtGlineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtLocChk = this.rtLocChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locChk = this.locChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtChk = this.cmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateChk = this.rateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbDesChk = this.arbDesChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
