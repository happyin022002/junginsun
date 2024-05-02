/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChargeReportVO.java
*@FileTitle : ChargeReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.09  
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeReportVO> models = new ArrayList<ChargeReportVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String chgNm = null;
	/* Column Info */
	private String frtChgTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String aplySvcModFlg = null;
	/* Column Info */
	private String coChgAcctCd = null;
	/* Column Info */
	private String useCoTpCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String chgAplyAreaCd = null;
	/* Column Info */
	private String tklTmlFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cyRdTermFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfsRdTermFlg = null;
	/* Column Info */
	private String dorRdTermFlg = null;
	/* Column Info */
	private String chgAplyTpCd = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String naRdTermFlg = null;
	/* Column Info */
	private String chgRevTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeReportVO() {}

	public ChargeReportVO(String ibflag, String pagerows, String chgCd, String chgNm, String frtChgTpCd, String chgAplyTpCd, String chgAplyAreaCd, String aplySvcModFlg, String coChgAcctCd, String repChgCd, String useCoTpCd, String autoRatFlg, String dpSeq, String cyRdTermFlg, String cfsRdTermFlg, String dorRdTermFlg, String tklTmlFlg, String naRdTermFlg, String deltFlg, String chgRevTpCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.dpSeq = dpSeq;
		this.repChgCd = repChgCd;
		this.chgNm = chgNm;
		this.frtChgTpCd = frtChgTpCd;
		this.deltFlg = deltFlg;
		this.aplySvcModFlg = aplySvcModFlg;
		this.coChgAcctCd = coChgAcctCd;
		this.useCoTpCd = useCoTpCd;
		this.chgCd = chgCd;
		this.chgAplyAreaCd = chgAplyAreaCd;
		this.tklTmlFlg = tklTmlFlg;
		this.pagerows = pagerows;
		this.cyRdTermFlg = cyRdTermFlg;
		this.ibflag = ibflag;
		this.cfsRdTermFlg = cfsRdTermFlg;
		this.dorRdTermFlg = dorRdTermFlg;
		this.chgAplyTpCd = chgAplyTpCd;
		this.autoRatFlg = autoRatFlg;
		this.naRdTermFlg = naRdTermFlg;
		this.chgRevTpCd = chgRevTpCd;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("frt_chg_tp_cd", getFrtChgTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("aply_svc_mod_flg", getAplySvcModFlg());
		this.hashColumns.put("co_chg_acct_cd", getCoChgAcctCd());
		this.hashColumns.put("use_co_tp_cd", getUseCoTpCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("chg_aply_area_cd", getChgAplyAreaCd());
		this.hashColumns.put("tkl_tml_flg", getTklTmlFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cy_rd_term_flg", getCyRdTermFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfs_rd_term_flg", getCfsRdTermFlg());
		this.hashColumns.put("dor_rd_term_flg", getDorRdTermFlg());
		this.hashColumns.put("chg_aply_tp_cd", getChgAplyTpCd());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("na_rd_term_flg", getNaRdTermFlg());
		this.hashColumns.put("chg_rev_tp_cd", getChgRevTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("frt_chg_tp_cd", "frtChgTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("aply_svc_mod_flg", "aplySvcModFlg");
		this.hashFields.put("co_chg_acct_cd", "coChgAcctCd");
		this.hashFields.put("use_co_tp_cd", "useCoTpCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("chg_aply_area_cd", "chgAplyAreaCd");
		this.hashFields.put("tkl_tml_flg", "tklTmlFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cy_rd_term_flg", "cyRdTermFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfs_rd_term_flg", "cfsRdTermFlg");
		this.hashFields.put("dor_rd_term_flg", "dorRdTermFlg");
		this.hashFields.put("chg_aply_tp_cd", "chgAplyTpCd");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("na_rd_term_flg", "naRdTermFlg");
		this.hashFields.put("chg_rev_tp_cd", "chgRevTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
	}
	
	/**
	 * Column Info
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
	}
	
	/**
	 * Column Info
	 * @return frtChgTpCd
	 */
	public String getFrtChgTpCd() {
		return this.frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return aplySvcModFlg
	 */
	public String getAplySvcModFlg() {
		return this.aplySvcModFlg;
	}
	
	/**
	 * Column Info
	 * @return coChgAcctCd
	 */
	public String getCoChgAcctCd() {
		return this.coChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @return useCoTpCd
	 */
	public String getUseCoTpCd() {
		return this.useCoTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return chgAplyAreaCd
	 */
	public String getChgAplyAreaCd() {
		return this.chgAplyAreaCd;
	}
	
	/**
	 * Column Info
	 * @return tklTmlFlg
	 */
	public String getTklTmlFlg() {
		return this.tklTmlFlg;
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
	 * @return cyRdTermFlg
	 */
	public String getCyRdTermFlg() {
		return this.cyRdTermFlg;
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
	 * @return cfsRdTermFlg
	 */
	public String getCfsRdTermFlg() {
		return this.cfsRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @return dorRdTermFlg
	 */
	public String getDorRdTermFlg() {
		return this.dorRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @return chgAplyTpCd
	 */
	public String getChgAplyTpCd() {
		return this.chgAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return autoRatFlg
	 */
	public String getAutoRatFlg() {
		return this.autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @return naRdTermFlg
	 */
	public String getNaRdTermFlg() {
		return this.naRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @return chgRevTpCd
	 */
	public String getChgRevTpCd() {
		return this.chgRevTpCd;
	}

	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
	}
	
	/**
	 * Column Info
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
	}
	
	/**
	 * Column Info
	 * @param frtChgTpCd
	 */
	public void setFrtChgTpCd(String frtChgTpCd) {
		this.frtChgTpCd = frtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param aplySvcModFlg
	 */
	public void setAplySvcModFlg(String aplySvcModFlg) {
		this.aplySvcModFlg = aplySvcModFlg;
	}
	
	/**
	 * Column Info
	 * @param coChgAcctCd
	 */
	public void setCoChgAcctCd(String coChgAcctCd) {
		this.coChgAcctCd = coChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @param useCoTpCd
	 */
	public void setUseCoTpCd(String useCoTpCd) {
		this.useCoTpCd = useCoTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param chgAplyAreaCd
	 */
	public void setChgAplyAreaCd(String chgAplyAreaCd) {
		this.chgAplyAreaCd = chgAplyAreaCd;
	}
	
	/**
	 * Column Info
	 * @param tklTmlFlg
	 */
	public void setTklTmlFlg(String tklTmlFlg) {
		this.tklTmlFlg = tklTmlFlg;
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
	 * @param cyRdTermFlg
	 */
	public void setCyRdTermFlg(String cyRdTermFlg) {
		this.cyRdTermFlg = cyRdTermFlg;
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
	 * @param cfsRdTermFlg
	 */
	public void setCfsRdTermFlg(String cfsRdTermFlg) {
		this.cfsRdTermFlg = cfsRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @param dorRdTermFlg
	 */
	public void setDorRdTermFlg(String dorRdTermFlg) {
		this.dorRdTermFlg = dorRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @param chgAplyTpCd
	 */
	public void setChgAplyTpCd(String chgAplyTpCd) {
		this.chgAplyTpCd = chgAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param autoRatFlg
	 */
	public void setAutoRatFlg(String autoRatFlg) {
		this.autoRatFlg = autoRatFlg;
	}
	
	/**
	 * Column Info
	 * @param naRdTermFlg
	 */
	public void setNaRdTermFlg(String naRdTermFlg) {
		this.naRdTermFlg = naRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @param chgRevTpCd
	 */
	public void setChgRevTpCd(String chgRevTpCd) {
		this.chgRevTpCd = chgRevTpCd;
	}
	
	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setRepChgCd(JSPUtil.getParameter(request, prefix + "rep_chg_cd", ""));
		setChgNm(JSPUtil.getParameter(request, prefix + "chg_nm", ""));
		setFrtChgTpCd(JSPUtil.getParameter(request, prefix + "frt_chg_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAplySvcModFlg(JSPUtil.getParameter(request, prefix + "aply_svc_mod_flg", ""));
		setCoChgAcctCd(JSPUtil.getParameter(request, prefix + "co_chg_acct_cd", ""));
		setUseCoTpCd(JSPUtil.getParameter(request, prefix + "use_co_tp_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setChgAplyAreaCd(JSPUtil.getParameter(request, prefix + "chg_aply_area_cd", ""));
		setTklTmlFlg(JSPUtil.getParameter(request, prefix + "tkl_tml_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCyRdTermFlg(JSPUtil.getParameter(request, prefix + "cy_rd_term_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCfsRdTermFlg(JSPUtil.getParameter(request, prefix + "cfs_rd_term_flg", ""));
		setDorRdTermFlg(JSPUtil.getParameter(request, prefix + "dor_rd_term_flg", ""));
		setChgAplyTpCd(JSPUtil.getParameter(request, prefix + "chg_aply_tp_cd", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setNaRdTermFlg(JSPUtil.getParameter(request, prefix + "na_rd_term_flg", ""));
		setChgRevTpCd(JSPUtil.getParameter(request, prefix + "chg_rev_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeReportVO[]
	 */
	public ChargeReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeReportVO[]
	 */
	public ChargeReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] frtChgTpCd = (JSPUtil.getParameter(request, prefix	+ "frt_chg_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] aplySvcModFlg = (JSPUtil.getParameter(request, prefix	+ "aply_svc_mod_flg", length));
			String[] coChgAcctCd = (JSPUtil.getParameter(request, prefix	+ "co_chg_acct_cd", length));
			String[] useCoTpCd = (JSPUtil.getParameter(request, prefix	+ "use_co_tp_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] chgAplyAreaCd = (JSPUtil.getParameter(request, prefix	+ "chg_aply_area_cd", length));
			String[] tklTmlFlg = (JSPUtil.getParameter(request, prefix	+ "tkl_tml_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cyRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "cy_rd_term_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfsRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "cfs_rd_term_flg", length));
			String[] dorRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "dor_rd_term_flg", length));
			String[] chgAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_aply_tp_cd", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] naRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "na_rd_term_flg", length));
			String[] chgRevTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_rev_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeReportVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (frtChgTpCd[i] != null)
					model.setFrtChgTpCd(frtChgTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (aplySvcModFlg[i] != null)
					model.setAplySvcModFlg(aplySvcModFlg[i]);
				if (coChgAcctCd[i] != null)
					model.setCoChgAcctCd(coChgAcctCd[i]);
				if (useCoTpCd[i] != null)
					model.setUseCoTpCd(useCoTpCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (chgAplyAreaCd[i] != null)
					model.setChgAplyAreaCd(chgAplyAreaCd[i]);
				if (tklTmlFlg[i] != null)
					model.setTklTmlFlg(tklTmlFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cyRdTermFlg[i] != null)
					model.setCyRdTermFlg(cyRdTermFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfsRdTermFlg[i] != null)
					model.setCfsRdTermFlg(cfsRdTermFlg[i]);
				if (dorRdTermFlg[i] != null)
					model.setDorRdTermFlg(dorRdTermFlg[i]);
				if (chgAplyTpCd[i] != null)
					model.setChgAplyTpCd(chgAplyTpCd[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (naRdTermFlg[i] != null)
					model.setNaRdTermFlg(naRdTermFlg[i]);
				if (chgRevTpCd[i] != null)
					model.setChgRevTpCd(chgRevTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeReportVO[]
	 */
	public ChargeReportVO[] getChargeReportVOs(){
		ChargeReportVO[] vos = (ChargeReportVO[])models.toArray(new ChargeReportVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChgTpCd = this.frtChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplySvcModFlg = this.aplySvcModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coChgAcctCd = this.coChgAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useCoTpCd = this.useCoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAplyAreaCd = this.chgAplyAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tklTmlFlg = this.tklTmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyRdTermFlg = this.cyRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsRdTermFlg = this.cfsRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorRdTermFlg = this.dorRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAplyTpCd = this.chgAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naRdTermFlg = this.naRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRevTpCd = this.chgRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
