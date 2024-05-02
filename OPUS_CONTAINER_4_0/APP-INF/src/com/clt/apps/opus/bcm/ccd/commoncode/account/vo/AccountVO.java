/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchAccountCodeListVO.java
*@FileTitle : SearchAccountCodeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.bcm.ccd.commoncode.account.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AccountVO> models = new ArrayList<AccountVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String acctEngNm = null;
	/* Column Info */
	private String budUseFlg = null;
	/* Column Info */
	private String vvdLvlFlg1 = null;
	/* Column Info */
	private String vvdLvlFlg2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdLvlFlg4 = null;
	/* Column Info */
	private String vvdLvlFlg3 = null;
	/* Column Info */
	private String estmTgtFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdLvlFlg6 = null;
	/* Column Info */
	private String budIfFlg = null;
	/* Column Info */
	private String vvdLvlFlg5 = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String entrExpnFlg = null;
	/* Column Info */
	private String autoCurrXchRtFlg = null;
	/* Column Info */
	private String acctgMngTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String jnlCreFlg = null;
	/* Column Info */
	private String pndTgtFlg = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String acctLoclNm = null;
	/* Column Info */
	private String modiAcctCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AccountVO() {}

	public AccountVO(String ibflag, String pagerows, String acctCd, String acctEngNm, String acctLoclNm, String budIfFlg, String budUseFlg, String jnlCreFlg, String acctgMngTpCd, String pndTgtFlg, String estmTgtFlg, String vvdLvlFlg1, String vvdLvlFlg2, String vvdLvlFlg3, String vvdLvlFlg4, String vvdLvlFlg5, String vvdLvlFlg6, String autoCurrXchRtFlg, String entrExpnFlg, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId, String modiAcctCd) {
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.acctEngNm = acctEngNm;
		this.budUseFlg = budUseFlg;
		this.vvdLvlFlg1 = vvdLvlFlg1;
		this.vvdLvlFlg2 = vvdLvlFlg2;
		this.pagerows = pagerows;
		this.vvdLvlFlg4 = vvdLvlFlg4;
		this.vvdLvlFlg3 = vvdLvlFlg3;
		this.estmTgtFlg = estmTgtFlg;
		this.ibflag = ibflag;
		this.vvdLvlFlg6 = vvdLvlFlg6;
		this.budIfFlg = budIfFlg;
		this.vvdLvlFlg5 = vvdLvlFlg5;
		this.acctCd = acctCd;
		this.entrExpnFlg = entrExpnFlg;
		this.autoCurrXchRtFlg = autoCurrXchRtFlg;
		this.acctgMngTpCd = acctgMngTpCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.jnlCreFlg = jnlCreFlg;
		this.pndTgtFlg = pndTgtFlg;
		this.eaiEvntDt = eaiEvntDt;
		this.creUsrId = creUsrId;
		this.acctLoclNm = acctLoclNm;
		this.modiAcctCd = modiAcctCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("bud_use_flg", getBudUseFlg());
		this.hashColumns.put("vvd_lvl_flg1", getVvdLvlFlg1());
		this.hashColumns.put("vvd_lvl_flg2", getVvdLvlFlg2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_lvl_flg4", getVvdLvlFlg4());
		this.hashColumns.put("vvd_lvl_flg3", getVvdLvlFlg3());
		this.hashColumns.put("estm_tgt_flg", getEstmTgtFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_lvl_flg6", getVvdLvlFlg6());
		this.hashColumns.put("bud_if_flg", getBudIfFlg());
		this.hashColumns.put("vvd_lvl_flg5", getVvdLvlFlg5());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("entr_expn_flg", getEntrExpnFlg());
		this.hashColumns.put("auto_curr_xch_rt_flg", getAutoCurrXchRtFlg());
		this.hashColumns.put("acctg_mng_tp_cd", getAcctgMngTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jnl_cre_flg", getJnlCreFlg());
		this.hashColumns.put("pnd_tgt_flg", getPndTgtFlg());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("acct_locl_nm", getAcctLoclNm());
		this.hashColumns.put("modi_acct_cd", getModiAcctCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("bud_use_flg", "budUseFlg");
		this.hashFields.put("vvd_lvl_flg1", "vvdLvlFlg1");
		this.hashFields.put("vvd_lvl_flg2", "vvdLvlFlg2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_lvl_flg4", "vvdLvlFlg4");
		this.hashFields.put("vvd_lvl_flg3", "vvdLvlFlg3");
		this.hashFields.put("estm_tgt_flg", "estmTgtFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_lvl_flg6", "vvdLvlFlg6");
		this.hashFields.put("bud_if_flg", "budIfFlg");
		this.hashFields.put("vvd_lvl_flg5", "vvdLvlFlg5");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("entr_expn_flg", "entrExpnFlg");
		this.hashFields.put("auto_curr_xch_rt_flg", "autoCurrXchRtFlg");
		this.hashFields.put("acctg_mng_tp_cd", "acctgMngTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jnl_cre_flg", "jnlCreFlg");
		this.hashFields.put("pnd_tgt_flg", "pndTgtFlg");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("acct_locl_nm", "acctLoclNm");
		this.hashFields.put("modi_acct_cd", "modiAcctCd");
		return this.hashFields;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 * Column Info
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	
	/**
	 * Column Info
	 * @return budUseFlg
	 */
	public String getBudUseFlg() {
		return this.budUseFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdLvlFlg1
	 */
	public String getVvdLvlFlg1() {
		return this.vvdLvlFlg1;
	}
	
	/**
	 * Column Info
	 * @return vvdLvlFlg2
	 */
	public String getVvdLvlFlg2() {
		return this.vvdLvlFlg2;
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
	 * @return vvdLvlFlg4
	 */
	public String getVvdLvlFlg4() {
		return this.vvdLvlFlg4;
	}
	
	/**
	 * Column Info
	 * @return vvdLvlFlg3
	 */
	public String getVvdLvlFlg3() {
		return this.vvdLvlFlg3;
	}
	
	/**
	 * Column Info
	 * @return estmTgtFlg
	 */
	public String getEstmTgtFlg() {
		return this.estmTgtFlg;
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
	 * @return vvdLvlFlg6
	 */
	public String getVvdLvlFlg6() {
		return this.vvdLvlFlg6;
	}
	
	/**
	 * Column Info
	 * @return budIfFlg
	 */
	public String getBudIfFlg() {
		return this.budIfFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdLvlFlg5
	 */
	public String getVvdLvlFlg5() {
		return this.vvdLvlFlg5;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return entrExpnFlg
	 */
	public String getEntrExpnFlg() {
		return this.entrExpnFlg;
	}
	
	/**
	 * Column Info
	 * @return autoCurrXchRtFlg
	 */
	public String getAutoCurrXchRtFlg() {
		return this.autoCurrXchRtFlg;
	}
	
	/**
	 * Column Info
	 * @return acctgMngTpCd
	 */
	public String getAcctgMngTpCd() {
		return this.acctgMngTpCd;
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
	 * @return jnlCreFlg
	 */
	public String getJnlCreFlg() {
		return this.jnlCreFlg;
	}
	
	/**
	 * Column Info
	 * @return pndTgtFlg
	 */
	public String getPndTgtFlg() {
		return this.pndTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
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
	 * @return acctKrnNm
	 */
	public String getAcctLoclNm() {
		return this.acctLoclNm;
	}
	
	/**
	 * Column Info
	 * @return modiAcctCd
	 */
	public String getModiAcctCd() {
		return this.modiAcctCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Column Info
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
	}
	
	/**
	 * Column Info
	 * @param budUseFlg
	 */
	public void setBudUseFlg(String budUseFlg) {
		this.budUseFlg = budUseFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdLvlFlg1
	 */
	public void setVvdLvlFlg1(String vvdLvlFlg1) {
		this.vvdLvlFlg1 = vvdLvlFlg1;
	}
	
	/**
	 * Column Info
	 * @param vvdLvlFlg2
	 */
	public void setVvdLvlFlg2(String vvdLvlFlg2) {
		this.vvdLvlFlg2 = vvdLvlFlg2;
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
	 * @param vvdLvlFlg4
	 */
	public void setVvdLvlFlg4(String vvdLvlFlg4) {
		this.vvdLvlFlg4 = vvdLvlFlg4;
	}
	
	/**
	 * Column Info
	 * @param vvdLvlFlg3
	 */
	public void setVvdLvlFlg3(String vvdLvlFlg3) {
		this.vvdLvlFlg3 = vvdLvlFlg3;
	}
	
	/**
	 * Column Info
	 * @param estmTgtFlg
	 */
	public void setEstmTgtFlg(String estmTgtFlg) {
		this.estmTgtFlg = estmTgtFlg;
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
	 * @param vvdLvlFlg6
	 */
	public void setVvdLvlFlg6(String vvdLvlFlg6) {
		this.vvdLvlFlg6 = vvdLvlFlg6;
	}
	
	/**
	 * Column Info
	 * @param budIfFlg
	 */
	public void setBudIfFlg(String budIfFlg) {
		this.budIfFlg = budIfFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdLvlFlg5
	 */
	public void setVvdLvlFlg5(String vvdLvlFlg5) {
		this.vvdLvlFlg5 = vvdLvlFlg5;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param entrExpnFlg
	 */
	public void setEntrExpnFlg(String entrExpnFlg) {
		this.entrExpnFlg = entrExpnFlg;
	}
	
	/**
	 * Column Info
	 * @param autoCurrXchRtFlg
	 */
	public void setAutoCurrXchRtFlg(String autoCurrXchRtFlg) {
		this.autoCurrXchRtFlg = autoCurrXchRtFlg;
	}
	
	/**
	 * Column Info
	 * @param acctgMngTpCd
	 */
	public void setAcctgMngTpCd(String acctgMngTpCd) {
		this.acctgMngTpCd = acctgMngTpCd;
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
	 * @param jnlCreFlg
	 */
	public void setJnlCreFlg(String jnlCreFlg) {
		this.jnlCreFlg = jnlCreFlg;
	}
	
	/**
	 * Column Info
	 * @param pndTgtFlg
	 */
	public void setPndTgtFlg(String pndTgtFlg) {
		this.pndTgtFlg = pndTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
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
	 * @param acctKrnNm
	 */
	public void setAcctLoclNm(String acctLoclNm) {
		this.acctLoclNm = acctLoclNm;
	}

	/**
	 * Column Info
	 * @param modiAcctCd
	 */
	public void setModiAcctCd(String modiAcctCd) {
		this.modiAcctCd = modiAcctCd;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setAcctEngNm(JSPUtil.getParameter(request, prefix + "acct_eng_nm", ""));
		setBudUseFlg(JSPUtil.getParameter(request, prefix + "bud_use_flg", ""));
		setVvdLvlFlg1(JSPUtil.getParameter(request, prefix + "vvd_lvl_flg1", ""));
		setVvdLvlFlg2(JSPUtil.getParameter(request, prefix + "vvd_lvl_flg2", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvdLvlFlg4(JSPUtil.getParameter(request, prefix + "vvd_lvl_flg4", ""));
		setVvdLvlFlg3(JSPUtil.getParameter(request, prefix + "vvd_lvl_flg3", ""));
		setEstmTgtFlg(JSPUtil.getParameter(request, prefix + "estm_tgt_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdLvlFlg6(JSPUtil.getParameter(request, prefix + "vvd_lvl_flg6", ""));
		setBudIfFlg(JSPUtil.getParameter(request, prefix + "bud_if_flg", ""));
		setVvdLvlFlg5(JSPUtil.getParameter(request, prefix + "vvd_lvl_flg5", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setEntrExpnFlg(JSPUtil.getParameter(request, prefix + "entr_expn_flg", ""));
		setAutoCurrXchRtFlg(JSPUtil.getParameter(request, prefix + "auto_curr_xch_rt_flg", ""));
		setAcctgMngTpCd(JSPUtil.getParameter(request, prefix + "acctg_mng_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setJnlCreFlg(JSPUtil.getParameter(request, prefix + "jnl_cre_flg", ""));
		setPndTgtFlg(JSPUtil.getParameter(request, prefix + "pnd_tgt_flg", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAcctLoclNm(JSPUtil.getParameter(request, prefix + "acct_locl_nm", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "modi_acct_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccountCodeListVO[]
	 */
	public AccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccountCodeListVO[]
	 */
	public AccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			String[] budUseFlg = (JSPUtil.getParameter(request, prefix	+ "bud_use_flg", length));
			String[] vvdLvlFlg1 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg1", length));
			String[] vvdLvlFlg2 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdLvlFlg4 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg4", length));
			String[] vvdLvlFlg3 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg3", length));
			String[] estmTgtFlg = (JSPUtil.getParameter(request, prefix	+ "estm_tgt_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdLvlFlg6 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg6", length));
			String[] budIfFlg = (JSPUtil.getParameter(request, prefix	+ "bud_if_flg", length));
			String[] vvdLvlFlg5 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg5", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] entrExpnFlg = (JSPUtil.getParameter(request, prefix	+ "entr_expn_flg", length));
			String[] autoCurrXchRtFlg = (JSPUtil.getParameter(request, prefix	+ "auto_curr_xch_rt_flg", length));
			String[] acctgMngTpCd = (JSPUtil.getParameter(request, prefix	+ "acctg_mng_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] jnlCreFlg = (JSPUtil.getParameter(request, prefix	+ "jnl_cre_flg", length));
			String[] pndTgtFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_tgt_flg", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] acctLoclNm = (JSPUtil.getParameter(request, prefix	+ "acct_locl_nm", length));
			String[] modiAcctCd = (JSPUtil.getParameter(request, prefix	+ "modi_acct_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AccountVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (budUseFlg[i] != null)
					model.setBudUseFlg(budUseFlg[i]);
				if (vvdLvlFlg1[i] != null)
					model.setVvdLvlFlg1(vvdLvlFlg1[i]);
				if (vvdLvlFlg2[i] != null)
					model.setVvdLvlFlg2(vvdLvlFlg2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdLvlFlg4[i] != null)
					model.setVvdLvlFlg4(vvdLvlFlg4[i]);
				if (vvdLvlFlg3[i] != null)
					model.setVvdLvlFlg3(vvdLvlFlg3[i]);
				if (estmTgtFlg[i] != null)
					model.setEstmTgtFlg(estmTgtFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdLvlFlg6[i] != null)
					model.setVvdLvlFlg6(vvdLvlFlg6[i]);
				if (budIfFlg[i] != null)
					model.setBudIfFlg(budIfFlg[i]);
				if (vvdLvlFlg5[i] != null)
					model.setVvdLvlFlg5(vvdLvlFlg5[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (entrExpnFlg[i] != null)
					model.setEntrExpnFlg(entrExpnFlg[i]);
				if (autoCurrXchRtFlg[i] != null)
					model.setAutoCurrXchRtFlg(autoCurrXchRtFlg[i]);
				if (acctgMngTpCd[i] != null)
					model.setAcctgMngTpCd(acctgMngTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (jnlCreFlg[i] != null)
					model.setJnlCreFlg(jnlCreFlg[i]);
				if (pndTgtFlg[i] != null)
					model.setPndTgtFlg(pndTgtFlg[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (acctLoclNm[i] != null)
					model.setAcctLoclNm(acctLoclNm[i]);
				if (modiAcctCd[i] != null)
					model.setModiAcctCd(modiAcctCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccountCodeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccountCodeListVO[]
	 */
	public AccountVO[] getSearchAccountCodeListVOs(){
		AccountVO[] vos = (AccountVO[])models.toArray(new AccountVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budUseFlg = this.budUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg1 = this.vvdLvlFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg2 = this.vvdLvlFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg4 = this.vvdLvlFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg3 = this.vvdLvlFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTgtFlg = this.estmTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg6 = this.vvdLvlFlg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budIfFlg = this.budIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg5 = this.vvdLvlFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrExpnFlg = this.entrExpnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoCurrXchRtFlg = this.autoCurrXchRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgMngTpCd = this.acctgMngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jnlCreFlg = this.jnlCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndTgtFlg = this.pndTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctLoclNm = this.acctLoclNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiAcctCd = this.modiAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
