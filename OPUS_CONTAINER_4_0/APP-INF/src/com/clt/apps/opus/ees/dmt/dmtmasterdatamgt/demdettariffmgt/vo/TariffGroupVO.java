/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffGroupVO.java
*@FileTitle : TariffGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.25 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffGroupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffGroupVO> models = new ArrayList<TariffGroupVO>();
	
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String dmdtChgCmncTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dmdtTrfGrpTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cmncHr = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String trfSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffGroupVO() {}

	public TariffGroupVO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String trfSeq, String trfGrpSeq, String dmdtBzcTrfGrpNm, String effDt, String dmdtTrfGrpTpCd, String expDt, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String dmdtChgCmncTpCd, String cmncHr, String currCd, String cfmFlg, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String usrId, String ofcCd) {
		this.xcldSunFlg = xcldSunFlg;
		this.xcldSatFlg = xcldSatFlg;
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
		this.currCd = currCd;
		this.creDt = creDt;
		this.dmdtTrfGrpTpCd = dmdtTrfGrpTpCd;
		this.pagerows = pagerows;
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.svrId = svrId;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.creOfcCd = creOfcCd;
		this.expDt = expDt;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updUsrId = updUsrId;
		this.updOfcCd = updOfcCd;
		this.updDt = updDt;
		this.cmncHr = cmncHr;
		this.cfmFlg = cfmFlg;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.xcldHolFlg = xcldHolFlg;
		this.trfGrpSeq = trfGrpSeq;
		this.trfSeq = trfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("dmdt_chg_cmnc_tp_cd", getDmdtChgCmncTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dmdt_trf_grp_tp_cd", getDmdtTrfGrpTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cmnc_hr", getCmncHr());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("trf_seq", getTrfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("dmdt_chg_cmnc_tp_cd", "dmdtChgCmncTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dmdt_trf_grp_tp_cd", "dmdtTrfGrpTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cmnc_hr", "cmncHr");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("trf_seq", "trfSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgCmncTpCd
	 */
	public String getDmdtChgCmncTpCd() {
		return this.dmdtChgCmncTpCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfGrpTpCd
	 */
	public String getDmdtTrfGrpTpCd() {
		return this.dmdtTrfGrpTpCd;
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
	 * @return dmdtBzcTrfGrpNm
	 */
	public String getDmdtBzcTrfGrpNm() {
		return this.dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return cmncHr
	 */
	public String getCmncHr() {
		return this.cmncHr;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
	}
	

	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgCmncTpCd
	 */
	public void setDmdtChgCmncTpCd(String dmdtChgCmncTpCd) {
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfGrpTpCd
	 */
	public void setDmdtTrfGrpTpCd(String dmdtTrfGrpTpCd) {
		this.dmdtTrfGrpTpCd = dmdtTrfGrpTpCd;
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
	 * @param dmdtBzcTrfGrpNm
	 */
	public void setDmdtBzcTrfGrpNm(String dmdtBzcTrfGrpNm) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param cmncHr
	 */
	public void setCmncHr(String cmncHr) {
		this.cmncHr = cmncHr;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setDmdtChgCmncTpCd(JSPUtil.getParameter(request, "dmdt_chg_cmnc_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDmdtTrfGrpTpCd(JSPUtil.getParameter(request, "dmdt_trf_grp_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, "dmdt_bzc_trf_grp_nm", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCmncHr(JSPUtil.getParameter(request, "cmnc_hr", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffGroupVO[]
	 */
	public TariffGroupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffGroupVO[]
	 */
	public TariffGroupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffGroupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] dmdtChgCmncTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_cmnc_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dmdtTrfGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_grp_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cmncHr = (JSPUtil.getParameter(request, prefix	+ "cmnc_hr", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffGroupVO();
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (dmdtChgCmncTpCd[i] != null)
					model.setDmdtChgCmncTpCd(dmdtChgCmncTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dmdtTrfGrpTpCd[i] != null)
					model.setDmdtTrfGrpTpCd(dmdtTrfGrpTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cmncHr[i] != null)
					model.setCmncHr(cmncHr[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffGroupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffGroupVO[]
	 */
	public TariffGroupVO[] getTariffGroupVOs(){
		TariffGroupVO[] vos = (TariffGroupVO[])models.toArray(new TariffGroupVO[models.size()]);
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
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgCmncTpCd = this.dmdtChgCmncTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfGrpTpCd = this.dmdtTrfGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmncHr = this.cmncHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
