/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemExpenseVO.java
*@FileTitle : GemExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.07.30 진윤오 
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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GemExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemExpenseVO> models = new ArrayList<GemExpenseVO>();
	
	/* Column Info */
	private String prntKrnAbbrNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String genExpnAcctExptFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String salyFlg = null;
	/* Column Info */
	private String genExpnSlsDivCd = null;
	/* Column Info */
	private String prntEngAbbrNm = null;
	/* Column Info */
	private String genExpnAgreFlg = null;
	/* Column Info */
	private String prntGenExpnCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String krnAbbrNm = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String engFullNm = null;
	/* Column Info */
	private String engAbbrNm = null;
	/* Column Info */
	private String acctMtxDeltFlg = null;
	/* Column Info */
	private String genExpnGroupCd = null;
	/* Column Info */
	private String acctExptDeltFlg = null;
	/* Column Info */
	private String genExpnGrpLvl = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ticCd = null;
	/* Column Info */
	private String krnFullNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemExpenseVO() {}

	public GemExpenseVO(String ibflag, String pagerows, String genExpnCd, String genExpnAgreFlg, String engAbbrNm, String engFullNm, String krnAbbrNm, String krnFullNm, String genExpnAcctExptFlg, String salyFlg, String genExpnSlsDivCd, String genExpnGrpLvl, String prntGenExpnCd, String ticCd, String deltFlg, String acctMtxDeltFlg, String acctExptDeltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String prntKrnAbbrNm, String prntEngAbbrNm, String genExpnGroupCd) {
		this.prntKrnAbbrNm = prntKrnAbbrNm;
		this.updDt = updDt;
		this.genExpnAcctExptFlg = genExpnAcctExptFlg;
		this.deltFlg = deltFlg;
		this.salyFlg = salyFlg;
		this.genExpnSlsDivCd = genExpnSlsDivCd;
		this.prntEngAbbrNm = prntEngAbbrNm;
		this.genExpnAgreFlg = genExpnAgreFlg;
		this.prntGenExpnCd = prntGenExpnCd;
		this.creDt = creDt;
		this.krnAbbrNm = krnAbbrNm;
		this.genExpnCd = genExpnCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.engFullNm = engFullNm;
		this.engAbbrNm = engAbbrNm;
		this.acctMtxDeltFlg = acctMtxDeltFlg;
		this.genExpnGroupCd = genExpnGroupCd;
		this.acctExptDeltFlg = acctExptDeltFlg;
		this.genExpnGrpLvl = genExpnGrpLvl;
		this.updUsrId = updUsrId;
		this.ticCd = ticCd;
		this.krnFullNm = krnFullNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prnt_krn_abbr_nm", getPrntKrnAbbrNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("gen_expn_acct_expt_flg", getGenExpnAcctExptFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("saly_flg", getSalyFlg());
		this.hashColumns.put("gen_expn_sls_div_cd", getGenExpnSlsDivCd());
		this.hashColumns.put("prnt_eng_abbr_nm", getPrntEngAbbrNm());
		this.hashColumns.put("gen_expn_agre_flg", getGenExpnAgreFlg());
		this.hashColumns.put("prnt_gen_expn_cd", getPrntGenExpnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("krn_abbr_nm", getKrnAbbrNm());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eng_full_nm", getEngFullNm());
		this.hashColumns.put("eng_abbr_nm", getEngAbbrNm());
		this.hashColumns.put("acct_mtx_delt_flg", getAcctMtxDeltFlg());
		this.hashColumns.put("gen_expn_group_cd", getGenExpnGroupCd());
		this.hashColumns.put("acct_expt_delt_flg", getAcctExptDeltFlg());
		this.hashColumns.put("gen_expn_grp_lvl", getGenExpnGrpLvl());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("tic_cd", getTicCd());
		this.hashColumns.put("krn_full_nm", getKrnFullNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("prnt_krn_abbr_nm", "prntKrnAbbrNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("gen_expn_acct_expt_flg", "genExpnAcctExptFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("saly_flg", "salyFlg");
		this.hashFields.put("gen_expn_sls_div_cd", "genExpnSlsDivCd");
		this.hashFields.put("prnt_eng_abbr_nm", "prntEngAbbrNm");
		this.hashFields.put("gen_expn_agre_flg", "genExpnAgreFlg");
		this.hashFields.put("prnt_gen_expn_cd", "prntGenExpnCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("krn_abbr_nm", "krnAbbrNm");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eng_full_nm", "engFullNm");
		this.hashFields.put("eng_abbr_nm", "engAbbrNm");
		this.hashFields.put("acct_mtx_delt_flg", "acctMtxDeltFlg");
		this.hashFields.put("gen_expn_group_cd", "genExpnGroupCd");
		this.hashFields.put("acct_expt_delt_flg", "acctExptDeltFlg");
		this.hashFields.put("gen_expn_grp_lvl", "genExpnGrpLvl");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tic_cd", "ticCd");
		this.hashFields.put("krn_full_nm", "krnFullNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return prntKrnAbbrNm
	 */
	public String getPrntKrnAbbrNm() {
		return this.prntKrnAbbrNm;
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
	 * @return genExpnAcctExptFlg
	 */
	public String getGenExpnAcctExptFlg() {
		return this.genExpnAcctExptFlg;
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
	 * @return salyFlg
	 */
	public String getSalyFlg() {
		return this.salyFlg;
	}
	
	/**
	 * Column Info
	 * @return genExpnSlsDivCd
	 */
	public String getGenExpnSlsDivCd() {
		return this.genExpnSlsDivCd;
	}
	
	/**
	 * Column Info
	 * @return prntEngAbbrNm
	 */
	public String getPrntEngAbbrNm() {
		return this.prntEngAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return genExpnAgreFlg
	 */
	public String getGenExpnAgreFlg() {
		return this.genExpnAgreFlg;
	}
	
	/**
	 * Column Info
	 * @return prntGenExpnCd
	 */
	public String getPrntGenExpnCd() {
		return this.prntGenExpnCd;
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
	 * @return krnAbbrNm
	 */
	public String getKrnAbbrNm() {
		return this.krnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
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
	 * @return engFullNm
	 */
	public String getEngFullNm() {
		return this.engFullNm;
	}
	
	/**
	 * Column Info
	 * @return engAbbrNm
	 */
	public String getEngAbbrNm() {
		return this.engAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return acctMtxDeltFlg
	 */
	public String getAcctMtxDeltFlg() {
		return this.acctMtxDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return genExpnGroupCd
	 */
	public String getGenExpnGroupCd() {
		return this.genExpnGroupCd;
	}
	
	/**
	 * Column Info
	 * @return acctExptDeltFlg
	 */
	public String getAcctExptDeltFlg() {
		return this.acctExptDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return genExpnGrpLvl
	 */
	public String getGenExpnGrpLvl() {
		return this.genExpnGrpLvl;
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
	 * @return ticCd
	 */
	public String getTicCd() {
		return this.ticCd;
	}
	
	/**
	 * Column Info
	 * @return krnFullNm
	 */
	public String getKrnFullNm() {
		return this.krnFullNm;
	}
	

	/**
	 * Column Info
	 * @param prntKrnAbbrNm
	 */
	public void setPrntKrnAbbrNm(String prntKrnAbbrNm) {
		this.prntKrnAbbrNm = prntKrnAbbrNm;
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
	 * @param genExpnAcctExptFlg
	 */
	public void setGenExpnAcctExptFlg(String genExpnAcctExptFlg) {
		this.genExpnAcctExptFlg = genExpnAcctExptFlg;
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
	 * @param salyFlg
	 */
	public void setSalyFlg(String salyFlg) {
		this.salyFlg = salyFlg;
	}
	
	/**
	 * Column Info
	 * @param genExpnSlsDivCd
	 */
	public void setGenExpnSlsDivCd(String genExpnSlsDivCd) {
		this.genExpnSlsDivCd = genExpnSlsDivCd;
	}
	
	/**
	 * Column Info
	 * @param prntEngAbbrNm
	 */
	public void setPrntEngAbbrNm(String prntEngAbbrNm) {
		this.prntEngAbbrNm = prntEngAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param genExpnAgreFlg
	 */
	public void setGenExpnAgreFlg(String genExpnAgreFlg) {
		this.genExpnAgreFlg = genExpnAgreFlg;
	}
	
	/**
	 * Column Info
	 * @param prntGenExpnCd
	 */
	public void setPrntGenExpnCd(String prntGenExpnCd) {
		this.prntGenExpnCd = prntGenExpnCd;
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
	 * @param krnAbbrNm
	 */
	public void setKrnAbbrNm(String krnAbbrNm) {
		this.krnAbbrNm = krnAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
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
	 * @param engFullNm
	 */
	public void setEngFullNm(String engFullNm) {
		this.engFullNm = engFullNm;
	}
	
	/**
	 * Column Info
	 * @param engAbbrNm
	 */
	public void setEngAbbrNm(String engAbbrNm) {
		this.engAbbrNm = engAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param acctMtxDeltFlg
	 */
	public void setAcctMtxDeltFlg(String acctMtxDeltFlg) {
		this.acctMtxDeltFlg = acctMtxDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param genExpnGroupCd
	 */
	public void setGenExpnGroupCd(String genExpnGroupCd) {
		this.genExpnGroupCd = genExpnGroupCd;
	}
	
	/**
	 * Column Info
	 * @param acctExptDeltFlg
	 */
	public void setAcctExptDeltFlg(String acctExptDeltFlg) {
		this.acctExptDeltFlg = acctExptDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param genExpnGrpLvl
	 */
	public void setGenExpnGrpLvl(String genExpnGrpLvl) {
		this.genExpnGrpLvl = genExpnGrpLvl;
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
	 * @param ticCd
	 */
	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
	}
	
	/**
	 * Column Info
	 * @param krnFullNm
	 */
	public void setKrnFullNm(String krnFullNm) {
		this.krnFullNm = krnFullNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPrntKrnAbbrNm(JSPUtil.getParameter(request, "prnt_krn_abbr_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setGenExpnAcctExptFlg(JSPUtil.getParameter(request, "gen_expn_acct_expt_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSalyFlg(JSPUtil.getParameter(request, "saly_flg", ""));
		setGenExpnSlsDivCd(JSPUtil.getParameter(request, "gen_expn_sls_div_cd", ""));
		setPrntEngAbbrNm(JSPUtil.getParameter(request, "prnt_eng_abbr_nm", ""));
		setGenExpnAgreFlg(JSPUtil.getParameter(request, "gen_expn_agre_flg", ""));
		setPrntGenExpnCd(JSPUtil.getParameter(request, "prnt_gen_expn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setKrnAbbrNm(JSPUtil.getParameter(request, "krn_abbr_nm", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEngFullNm(JSPUtil.getParameter(request, "eng_full_nm", ""));
		setEngAbbrNm(JSPUtil.getParameter(request, "eng_abbr_nm", ""));
		setAcctMtxDeltFlg(JSPUtil.getParameter(request, "acct_mtx_delt_flg", ""));
		setGenExpnGroupCd(JSPUtil.getParameter(request, "gen_expn_group_cd", ""));
		setAcctExptDeltFlg(JSPUtil.getParameter(request, "acct_expt_delt_flg", ""));
		setGenExpnGrpLvl(JSPUtil.getParameter(request, "gen_expn_grp_lvl", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
		setKrnFullNm(JSPUtil.getParameter(request, "krn_full_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemExpenseVO[]
	 */
	public GemExpenseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemExpenseVO[]
	 */
	public GemExpenseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemExpenseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] prntKrnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "prnt_krn_abbr_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] genExpnAcctExptFlg = (JSPUtil.getParameter(request, prefix	+ "gen_expn_acct_expt_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] salyFlg = (JSPUtil.getParameter(request, prefix	+ "saly_flg", length));
			String[] genExpnSlsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_sls_div_cd", length));
			String[] prntEngAbbrNm = (JSPUtil.getParameter(request, prefix	+ "prnt_eng_abbr_nm", length));
			String[] genExpnAgreFlg = (JSPUtil.getParameter(request, prefix	+ "gen_expn_agre_flg", length));
			String[] prntGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "prnt_gen_expn_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] krnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "krn_abbr_nm", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] engFullNm = (JSPUtil.getParameter(request, prefix	+ "eng_full_nm", length));
			String[] engAbbrNm = (JSPUtil.getParameter(request, prefix	+ "eng_abbr_nm", length));
			String[] acctMtxDeltFlg = (JSPUtil.getParameter(request, prefix	+ "acct_mtx_delt_flg", length));
			String[] genExpnGroupCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_group_cd", length));
			String[] acctExptDeltFlg = (JSPUtil.getParameter(request, prefix	+ "acct_expt_delt_flg", length));
			String[] genExpnGrpLvl = (JSPUtil.getParameter(request, prefix	+ "gen_expn_grp_lvl", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			String[] krnFullNm = (JSPUtil.getParameter(request, prefix	+ "krn_full_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemExpenseVO();
				if (prntKrnAbbrNm[i] != null)
					model.setPrntKrnAbbrNm(prntKrnAbbrNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (genExpnAcctExptFlg[i] != null)
					model.setGenExpnAcctExptFlg(genExpnAcctExptFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (salyFlg[i] != null)
					model.setSalyFlg(salyFlg[i]);
				if (genExpnSlsDivCd[i] != null)
					model.setGenExpnSlsDivCd(genExpnSlsDivCd[i]);
				if (prntEngAbbrNm[i] != null)
					model.setPrntEngAbbrNm(prntEngAbbrNm[i]);
				if (genExpnAgreFlg[i] != null)
					model.setGenExpnAgreFlg(genExpnAgreFlg[i]);
				if (prntGenExpnCd[i] != null)
					model.setPrntGenExpnCd(prntGenExpnCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (krnAbbrNm[i] != null)
					model.setKrnAbbrNm(krnAbbrNm[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (engFullNm[i] != null)
					model.setEngFullNm(engFullNm[i]);
				if (engAbbrNm[i] != null)
					model.setEngAbbrNm(engAbbrNm[i]);
				if (acctMtxDeltFlg[i] != null)
					model.setAcctMtxDeltFlg(acctMtxDeltFlg[i]);
				if (genExpnGroupCd[i] != null)
					model.setGenExpnGroupCd(genExpnGroupCd[i]);
				if (acctExptDeltFlg[i] != null)
					model.setAcctExptDeltFlg(acctExptDeltFlg[i]);
				if (genExpnGrpLvl[i] != null)
					model.setGenExpnGrpLvl(genExpnGrpLvl[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				if (krnFullNm[i] != null)
					model.setKrnFullNm(krnFullNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemExpenseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemExpenseVO[]
	 */
	public GemExpenseVO[] getGemExpenseVOs(){
		GemExpenseVO[] vos = (GemExpenseVO[])models.toArray(new GemExpenseVO[models.size()]);
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
		this.prntKrnAbbrNm = this.prntKrnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAcctExptFlg = this.genExpnAcctExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salyFlg = this.salyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnSlsDivCd = this.genExpnSlsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntEngAbbrNm = this.prntEngAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAgreFlg = this.genExpnAgreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntGenExpnCd = this.prntGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnAbbrNm = this.krnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engFullNm = this.engFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAbbrNm = this.engAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctMtxDeltFlg = this.acctMtxDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnGroupCd = this.genExpnGroupCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctExptDeltFlg = this.acctExptDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnGrpLvl = this.genExpnGrpLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnFullNm = this.krnFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
