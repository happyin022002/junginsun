/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemOfficeVO.java
*@FileTitle : GemOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.05.29 최정미 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GemOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemOfficeVO> models = new ArrayList<GemOfficeVO>();
	
	/* Column Info */
	private String apCtrlOfcCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String ofcHisCnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String rqstAuthFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String genExpnOfcLvl = null;
	/* Column Info */
	private String ticAuthFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String expnSmryOfcCd = null;
	/* Column Info */
	private String ofcCoDivCd = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slsOfcFlg = null;
	/* Column Info */
	private String rgnOfcFlg = null;
	/* Column Info */
	private String rhqAuthFlg = null;
	/* Column Info */
	private String cmitAuthFlg = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String expnSmryYrmon = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String ofcKrnNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemOfficeVO() {}

	public GemOfficeVO(String ibflag, String pagerows, String ofcCd, String ofcEngNm, String ofcKrnNm, String ctrCd, String apCtrlOfcCd, String loclCurrCd, String rqstUtVal, String genExpnOfcLvl, String prntOfcCd, String ofcCoDivCd, String rgnOfcFlg, String slsOfcFlg, String rqstAuthFlg, String rhqAuthFlg, String ticAuthFlg, String cmitAuthFlg, String expnSmryOfcCd, String expnSmryYrmon, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String ofcHisCnt) {
		this.apCtrlOfcCd = apCtrlOfcCd;
		this.deltFlg = deltFlg;
		this.ofcHisCnt = ofcHisCnt;
		this.creDt = creDt;
		this.ofcEngNm = ofcEngNm;
		this.rqstAuthFlg = rqstAuthFlg;
		this.pagerows = pagerows;
		this.genExpnOfcLvl = genExpnOfcLvl;
		this.ticAuthFlg = ticAuthFlg;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.expnSmryOfcCd = expnSmryOfcCd;
		this.ofcCoDivCd = ofcCoDivCd;
		this.rqstUtVal = rqstUtVal;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.slsOfcFlg = slsOfcFlg;
		this.rgnOfcFlg = rgnOfcFlg;
		this.rhqAuthFlg = rhqAuthFlg;
		this.cmitAuthFlg = cmitAuthFlg;
		this.loclCurrCd = loclCurrCd;
		this.expnSmryYrmon = expnSmryYrmon;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.prntOfcCd = prntOfcCd;
		this.ofcKrnNm = ofcKrnNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ap_ctrl_ofc_cd", getApCtrlOfcCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ofc_his_cnt", getOfcHisCnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("rqst_auth_flg", getRqstAuthFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gen_expn_ofc_lvl", getGenExpnOfcLvl());
		this.hashColumns.put("tic_auth_flg", getTicAuthFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("expn_smry_ofc_cd", getExpnSmryOfcCd());
		this.hashColumns.put("ofc_co_div_cd", getOfcCoDivCd());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("sls_ofc_flg", getSlsOfcFlg());
		this.hashColumns.put("rgn_ofc_flg", getRgnOfcFlg());
		this.hashColumns.put("rhq_auth_flg", getRhqAuthFlg());
		this.hashColumns.put("cmit_auth_flg", getCmitAuthFlg());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("expn_smry_yrmon", getExpnSmryYrmon());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("ofc_krn_nm", getOfcKrnNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ap_ctrl_ofc_cd", "apCtrlOfcCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ofc_his_cnt", "ofcHisCnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("rqst_auth_flg", "rqstAuthFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gen_expn_ofc_lvl", "genExpnOfcLvl");
		this.hashFields.put("tic_auth_flg", "ticAuthFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("expn_smry_ofc_cd", "expnSmryOfcCd");
		this.hashFields.put("ofc_co_div_cd", "ofcCoDivCd");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("sls_ofc_flg", "slsOfcFlg");
		this.hashFields.put("rgn_ofc_flg", "rgnOfcFlg");
		this.hashFields.put("rhq_auth_flg", "rhqAuthFlg");
		this.hashFields.put("cmit_auth_flg", "cmitAuthFlg");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("expn_smry_yrmon", "expnSmryYrmon");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("ofc_krn_nm", "ofcKrnNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return apCtrlOfcCd
	 */
	public String getApCtrlOfcCd() {
		return this.apCtrlOfcCd;
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
	 * @return ofcHisCnt
	 */
	public String getOfcHisCnt() {
		return this.ofcHisCnt;
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
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return rqstAuthFlg
	 */
	public String getRqstAuthFlg() {
		return this.rqstAuthFlg;
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
	 * @return genExpnOfcLvl
	 */
	public String getGenExpnOfcLvl() {
		return this.genExpnOfcLvl;
	}
	
	/**
	 * Column Info
	 * @return ticAuthFlg
	 */
	public String getTicAuthFlg() {
		return this.ticAuthFlg;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return expnSmryOfcCd
	 */
	public String getExpnSmryOfcCd() {
		return this.expnSmryOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCoDivCd
	 */
	public String getOfcCoDivCd() {
		return this.ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return slsOfcFlg
	 */
	public String getSlsOfcFlg() {
		return this.slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcFlg
	 */
	public String getRgnOfcFlg() {
		return this.rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @return rhqAuthFlg
	 */
	public String getRhqAuthFlg() {
		return this.rhqAuthFlg;
	}
	
	/**
	 * Column Info
	 * @return cmitAuthFlg
	 */
	public String getCmitAuthFlg() {
		return this.cmitAuthFlg;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return expnSmryYrmon
	 */
	public String getExpnSmryYrmon() {
		return this.expnSmryYrmon;
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
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcKrnNm
	 */
	public String getOfcKrnNm() {
		return this.ofcKrnNm;
	}
	

	/**
	 * Column Info
	 * @param apCtrlOfcCd
	 */
	public void setApCtrlOfcCd(String apCtrlOfcCd) {
		this.apCtrlOfcCd = apCtrlOfcCd;
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
	 * @param ofcHisCnt
	 */
	public void setOfcHisCnt(String ofcHisCnt) {
		this.ofcHisCnt = ofcHisCnt;
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
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param rqstAuthFlg
	 */
	public void setRqstAuthFlg(String rqstAuthFlg) {
		this.rqstAuthFlg = rqstAuthFlg;
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
	 * @param genExpnOfcLvl
	 */
	public void setGenExpnOfcLvl(String genExpnOfcLvl) {
		this.genExpnOfcLvl = genExpnOfcLvl;
	}
	
	/**
	 * Column Info
	 * @param ticAuthFlg
	 */
	public void setTicAuthFlg(String ticAuthFlg) {
		this.ticAuthFlg = ticAuthFlg;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param expnSmryOfcCd
	 */
	public void setExpnSmryOfcCd(String expnSmryOfcCd) {
		this.expnSmryOfcCd = expnSmryOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCoDivCd
	 */
	public void setOfcCoDivCd(String ofcCoDivCd) {
		this.ofcCoDivCd = ofcCoDivCd;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param slsOfcFlg
	 */
	public void setSlsOfcFlg(String slsOfcFlg) {
		this.slsOfcFlg = slsOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcFlg
	 */
	public void setRgnOfcFlg(String rgnOfcFlg) {
		this.rgnOfcFlg = rgnOfcFlg;
	}
	
	/**
	 * Column Info
	 * @param rhqAuthFlg
	 */
	public void setRhqAuthFlg(String rhqAuthFlg) {
		this.rhqAuthFlg = rhqAuthFlg;
	}
	
	/**
	 * Column Info
	 * @param cmitAuthFlg
	 */
	public void setCmitAuthFlg(String cmitAuthFlg) {
		this.cmitAuthFlg = cmitAuthFlg;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param expnSmryYrmon
	 */
	public void setExpnSmryYrmon(String expnSmryYrmon) {
		this.expnSmryYrmon = expnSmryYrmon;
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
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcKrnNm
	 */
	public void setOfcKrnNm(String ofcKrnNm) {
		this.ofcKrnNm = ofcKrnNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setApCtrlOfcCd(JSPUtil.getParameter(request, "ap_ctrl_ofc_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setOfcHisCnt(JSPUtil.getParameter(request, "ofc_his_cnt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOfcEngNm(JSPUtil.getParameter(request, "ofc_eng_nm", ""));
		setRqstAuthFlg(JSPUtil.getParameter(request, "rqst_auth_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGenExpnOfcLvl(JSPUtil.getParameter(request, "gen_expn_ofc_lvl", ""));
		setTicAuthFlg(JSPUtil.getParameter(request, "tic_auth_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setExpnSmryOfcCd(JSPUtil.getParameter(request, "expn_smry_ofc_cd", ""));
		setOfcCoDivCd(JSPUtil.getParameter(request, "ofc_co_div_cd", ""));
		setRqstUtVal(JSPUtil.getParameter(request, "rqst_ut_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSlsOfcFlg(JSPUtil.getParameter(request, "sls_ofc_flg", ""));
		setRgnOfcFlg(JSPUtil.getParameter(request, "rgn_ofc_flg", ""));
		setRhqAuthFlg(JSPUtil.getParameter(request, "rhq_auth_flg", ""));
		setCmitAuthFlg(JSPUtil.getParameter(request, "cmit_auth_flg", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setExpnSmryYrmon(JSPUtil.getParameter(request, "expn_smry_yrmon", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, "prnt_ofc_cd", ""));
		setOfcKrnNm(JSPUtil.getParameter(request, "ofc_krn_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemOfficeVO[]
	 */
	public GemOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemOfficeVO[]
	 */
	public GemOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] apCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctrl_ofc_cd".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] ofcHisCnt = (JSPUtil.getParameter(request, prefix	+ "ofc_his_cnt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm".trim(), length));
			String[] rqstAuthFlg = (JSPUtil.getParameter(request, prefix	+ "rqst_auth_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] genExpnOfcLvl = (JSPUtil.getParameter(request, prefix	+ "gen_expn_ofc_lvl".trim(), length));
			String[] ticAuthFlg = (JSPUtil.getParameter(request, prefix	+ "tic_auth_flg".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd".trim(), length));
			String[] expnSmryOfcCd = (JSPUtil.getParameter(request, prefix	+ "expn_smry_ofc_cd".trim(), length));
			String[] ofcCoDivCd = (JSPUtil.getParameter(request, prefix	+ "ofc_co_div_cd".trim(), length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] slsOfcFlg = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_flg".trim(), length));
			String[] rgnOfcFlg = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_flg".trim(), length));
			String[] rhqAuthFlg = (JSPUtil.getParameter(request, prefix	+ "rhq_auth_flg".trim(), length));
			String[] cmitAuthFlg = (JSPUtil.getParameter(request, prefix	+ "cmit_auth_flg".trim(), length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd".trim(), length));
			String[] expnSmryYrmon = (JSPUtil.getParameter(request, prefix	+ "expn_smry_yrmon".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd".trim(), length));
			String[] ofcKrnNm = (JSPUtil.getParameter(request, prefix	+ "ofc_krn_nm".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new GemOfficeVO();
				if (apCtrlOfcCd[i] != null)
					model.setApCtrlOfcCd(apCtrlOfcCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (ofcHisCnt[i] != null)
					model.setOfcHisCnt(ofcHisCnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (rqstAuthFlg[i] != null)
					model.setRqstAuthFlg(rqstAuthFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (genExpnOfcLvl[i] != null)
					model.setGenExpnOfcLvl(genExpnOfcLvl[i]);
				if (ticAuthFlg[i] != null)
					model.setTicAuthFlg(ticAuthFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (expnSmryOfcCd[i] != null)
					model.setExpnSmryOfcCd(expnSmryOfcCd[i]);
				if (ofcCoDivCd[i] != null)
					model.setOfcCoDivCd(ofcCoDivCd[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (slsOfcFlg[i] != null)
					model.setSlsOfcFlg(slsOfcFlg[i]);
				if (rgnOfcFlg[i] != null)
					model.setRgnOfcFlg(rgnOfcFlg[i]);
				if (rhqAuthFlg[i] != null)
					model.setRhqAuthFlg(rhqAuthFlg[i]);
				if (cmitAuthFlg[i] != null)
					model.setCmitAuthFlg(cmitAuthFlg[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (expnSmryYrmon[i] != null)
					model.setExpnSmryYrmon(expnSmryYrmon[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (ofcKrnNm[i] != null)
					model.setOfcKrnNm(ofcKrnNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemOfficeVO[]
	 */
	public GemOfficeVO[] getGemOfficeVOs(){
		GemOfficeVO[] vos = (GemOfficeVO[])models.toArray(new GemOfficeVO[models.size()]);
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
		this.apCtrlOfcCd = this.apCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcHisCnt = this.ofcHisCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAuthFlg = this.rqstAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnOfcLvl = this.genExpnOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticAuthFlg = this.ticAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnSmryOfcCd = this.expnSmryOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCoDivCd = this.ofcCoDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcFlg = this.slsOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcFlg = this.rgnOfcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqAuthFlg = this.rhqAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmitAuthFlg = this.cmitAuthFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnSmryYrmon = this.expnSmryYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKrnNm = this.ofcKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
