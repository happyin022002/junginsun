/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMdmAccountVO.java
*@FileTitle : SearchMdmAccountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.11 최 선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.common.mdmSync.jms.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModifyMdmAccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModifyMdmAccountVO> models = new ArrayList<ModifyMdmAccountVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acctEngNm = null;
	/* Column Info */
	private String acctKrnNm = null;
	/* Column Info */
	private String budUseFlg = null;
	/* Column Info */
	private String jnlCreFlg = null;
	/* Column Info */
	private String acctgMngTpCd = null;
	/* Column Info */
	private String pndTgtFlg = null;
	/* Column Info */
	private String estmTgtFlg = null;
	/* Column Info */
	private String vvdLvlFlg1 = null;
	/* Column Info */
	private String vvdLvlFlg2 = null;
	/* Column Info */
	private String vvdLvlFlg3 = null;
	/* Column Info */
	private String vvdLvlFlg4 = null;
	/* Column Info */
	private String vvdLvlFlg5 = null;
	/* Column Info */
	private String vvdLvlFlg6 = null;
	/* Column Info */
	private String autoCurrXchRtFlg = null;
	/* Column Info */
	private String entrExpnFlg = null;
	/* Column Info */
	private String budIfFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String eaiIfId = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModifyMdmAccountVO() {}

	public ModifyMdmAccountVO(String ibflag, String pagerows, String acctCd, String acctEngNm, String acctKrnNm, String budUseFlg, String jnlCreFlg, String acctgMngTpCd, String pndTgtFlg, String estmTgtFlg, String vvdLvlFlg1, String vvdLvlFlg2, String vvdLvlFlg3, String vvdLvlFlg4, String vvdLvlFlg5, String vvdLvlFlg6, String autoCurrXchRtFlg, String entrExpnFlg, String budIfFlg, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId) {
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.pagerows = pagerows;
		this.acctEngNm = acctEngNm;
		this.acctKrnNm = acctKrnNm;
		this.budUseFlg = budUseFlg;
		this.jnlCreFlg = jnlCreFlg;
		this.acctgMngTpCd = acctgMngTpCd;
		this.pndTgtFlg = pndTgtFlg;
		this.estmTgtFlg = estmTgtFlg;
		this.vvdLvlFlg1 = vvdLvlFlg1;
		this.vvdLvlFlg2 = vvdLvlFlg2;
		this.vvdLvlFlg3 = vvdLvlFlg3;
		this.vvdLvlFlg4 = vvdLvlFlg4;
		this.vvdLvlFlg5 = vvdLvlFlg5;
		this.vvdLvlFlg6 = vvdLvlFlg6;
		this.autoCurrXchRtFlg = autoCurrXchRtFlg;
		this.entrExpnFlg = entrExpnFlg;
		this.budIfFlg = budIfFlg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.eaiEvntDt = eaiEvntDt;
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("bud_use_flg", getBudUseFlg());
		this.hashColumns.put("acct_krn_nm", getAcctKrnNm());
		this.hashColumns.put("bud_use_flg", getBudUseFlg());
		this.hashColumns.put("jnl_cre_flg", getJnlCreFlg());
		this.hashColumns.put("acctg_mng_tp_cd", getAcctgMngTpCd());
		this.hashColumns.put("pnd_tgt_flg", getPndTgtFlg());
		this.hashColumns.put("estm_tgt_flg", getEstmTgtFlg());
		this.hashColumns.put("vvd_lvl_flg1", getVvdLvlFlg1());
		this.hashColumns.put("vvd_lvl_flg2", getVvdLvlFlg2());
		this.hashColumns.put("vvd_lvl_flg3", getVvdLvlFlg3());
		this.hashColumns.put("vvd_lvl_flg4", getVvdLvlFlg4());
		this.hashColumns.put("vvd_lvl_flg5", getVvdLvlFlg5());
		this.hashColumns.put("vvd_lvl_flg6", getVvdLvlFlg6());
		this.hashColumns.put("auto_curr_xch_rt_flg", getAutoCurrXchRtFlg());
		this.hashColumns.put("entr_expn_flg", getEntrExpnFlg());
		this.hashColumns.put("bud_if_flg", getBudIfFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("acct_krn_nm", "acctKrnNm");
		this.hashFields.put("bud_use_flg", "budUseFlg");
		this.hashFields.put("jnl_cre_flg", "jnlCreFlg");
		this.hashFields.put("acctg_mng_tp_cd", "acctgMngTpCd");
		this.hashFields.put("pnd_tgt_flg", "pndTgtFlg");
		this.hashFields.put("estm_tgt_flg", "estmTgtFlg");
		this.hashFields.put("vvd_lvl_flg1", "vvdLvlFlg1");
		this.hashFields.put("vvd_lvl_flg2", "vvdLvlFlg2");
		this.hashFields.put("vvd_lvl_flg3", "vvdLvlFlg3");
		this.hashFields.put("vvd_lvl_flg4", "vvdLvlFlg4");
		this.hashFields.put("vvd_lvl_flg5", "vvdLvlFlg5");
		this.hashFields.put("vvd_lvl_flg6", "vvdLvlFlg6");
		this.hashFields.put("auto_curr_xch_rt_flg", "autoCurrXchRtFlg");
		this.hashFields.put("entr_expn_flg", "entrExpnFlg");
		this.hashFields.put("bud_if_flg", "budIfFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "UpdUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		return this.hashFields;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @return acctEngNm
	 */
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	
	/**
	 * Column Info
	 * @return acctKrnNm
	 */
	public String getAcctKrnNm() {
		return this.acctKrnNm;
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
	 * @return jnlCreFlg
	 */
	public String getJnlCreFlg() {
		return this.jnlCreFlg;
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
	 * @return pndTgtFlg
	 */
	public String getPndTgtFlg() {
		return this.pndTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return estmTgtFlg
	 */
	public String getEstmTgtFlg() {
		return this.estmTgtFlg;
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
	 * Column Info
	 * @return vvdLvlFlg3
	 */
	public String getVvdLvlFlg3() {
		return this.vvdLvlFlg3;
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
	 * @return vvdLvlFlg5
	 */
	public String getVvdLvlFlg5() {
		return this.vvdLvlFlg5;
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
	 * @return autoCurrXchRtFlg
	 */
	public String getAutoCurrXchRtFlg() {
		return this.autoCurrXchRtFlg;
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
	 * @return budIfFlg
	 */
	public String getBudIfFlg() {
		return this.budIfFlg;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
	 * @param acctEngNm
	 */
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
	}
	
	/**
	 * Column Info
	 * @param acctKrnNm
	 */
	public void setAcctKrnNm(String acctKrnNm) {
		this.acctKrnNm = acctKrnNm;
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
	 * @param jnlCreFlg
	 */
	public void setJnlCreFlg(String jnlCreFlg) {
		this.jnlCreFlg = jnlCreFlg;
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
	 * @param pndTgtFlg
	 */
	public void setPndTgtFlg(String pndTgtFlg) {
		this.pndTgtFlg = pndTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param estmTgtFlg
	 */
	public void setEstmTgtFlg(String estmTgtFlg) {
		this.estmTgtFlg = estmTgtFlg;
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
	 * Column Info
	 * @param vvdLvlFlg3
	 */
	public void setVvdLvlFlg3(String vvdLvlFlg3) {
		this.vvdLvlFlg3 = vvdLvlFlg3;
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
	 * @param vvdLvlFlg5
	 */
	public void setVvdLvlFlg5(String vvdLvlFlg5) {
		this.vvdLvlFlg5 = vvdLvlFlg5;
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
	 * @param autoCurrXchRtFlg
	 */
	public void setAutoCurrXchRtFlg(String autoCurrXchRtFlg) {
		this.autoCurrXchRtFlg = autoCurrXchRtFlg;
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
	 * @param budIfFlg
	 */
	public void setBudIfFlg(String budIfFlg) {
		this.budIfFlg = budIfFlg;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
		setAcctKrnNm(JSPUtil.getParameter(request, "acct_krn_nm", ""));
		setBudUseFlg(JSPUtil.getParameter(request, "bud_use_flg", ""));
		setJnlCreFlg(JSPUtil.getParameter(request, "jnl_cre_flg", ""));
		setAcctgMngTpCd(JSPUtil.getParameter(request, "acctg_mng_tp_cd", ""));
		setPndTgtFlg(JSPUtil.getParameter(request, "pnd_tgt_flg", ""));
		setEstmTgtFlg(JSPUtil.getParameter(request, "estm_tgt_flg", ""));
		setVvdLvlFlg1(JSPUtil.getParameter(request, "vvd_lvl_flg1", ""));
		setVvdLvlFlg2(JSPUtil.getParameter(request, "vvd_lvl_flg2", ""));
		setVvdLvlFlg3(JSPUtil.getParameter(request, "vvd_lvl_flg3", ""));
		setVvdLvlFlg4(JSPUtil.getParameter(request, "vvd_lvl_flg4", ""));
		setVvdLvlFlg5(JSPUtil.getParameter(request, "vvd_lvl_flg5", ""));
		setVvdLvlFlg6(JSPUtil.getParameter(request, "vvd_lvl_flg6", ""));
		setAutoCurrXchRtFlg(JSPUtil.getParameter(request, "auto_curr_xch_rt_flg", ""));
		setEntrExpnFlg(JSPUtil.getParameter(request, "entr_expn_flg", ""));
		setBudIfFlg(JSPUtil.getParameter(request, "bud_if_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, "eai_if_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMdmAccountVO[]
	 */
	public ModifyMdmAccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMdmAccountVO[]
	 */
	public ModifyMdmAccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModifyMdmAccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm", length));
			String[] acctKrnNm = (JSPUtil.getParameter(request, prefix	+ "acct_krn_nm", length));
			String[] budUseFlg = (JSPUtil.getParameter(request, prefix	+ "bud_use_flg", length));
			String[] jnlCreFlg = (JSPUtil.getParameter(request, prefix	+ "jnl_cre_flg", length));
			String[] acctgMngTpCd = (JSPUtil.getParameter(request, prefix	+ "acctg_mng_tp_cd", length));
			String[] pndTgtFlg = (JSPUtil.getParameter(request, prefix	+ "pnd_tgt_flg", length));
			String[] estmTgtFlg = (JSPUtil.getParameter(request, prefix	+ "estm_tgt_flg", length));
			String[] vvdLvlFlg1 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg1", length));
			String[] vvdLvlFlg2 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg2", length));
			String[] vvdLvlFlg3 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg3", length));
			String[] vvdLvlFlg4 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg4", length));
			String[] vvdLvlFlg5 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg5", length));
			String[] vvdLvlFlg6 = (JSPUtil.getParameter(request, prefix	+ "vvd_lvl_flg6", length));
			String[] autoCurrXchRtFlg = (JSPUtil.getParameter(request, prefix	+ "auto_curr_xch_rt_flg", length));
			String[] entrExpnFlg = (JSPUtil.getParameter(request, prefix	+ "entr_expn_flg", length));
			String[] budIfFlg = (JSPUtil.getParameter(request, prefix	+ "bud_if_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));

			for (int i = 0; i < length; i++) {
				model = new ModifyMdmAccountVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (acctKrnNm[i] != null)
					model.setAcctKrnNm(acctKrnNm[i]);
				if (budUseFlg[i] != null)
					model.setBudUseFlg(budUseFlg[i]);
				if (jnlCreFlg[i] != null)
					model.setJnlCreFlg(jnlCreFlg[i]);
				if (acctgMngTpCd[i] != null)
					model.setAcctgMngTpCd(acctgMngTpCd[i]);
				if (pndTgtFlg[i] != null)
					model.setPndTgtFlg(pndTgtFlg[i]);
				if (estmTgtFlg[i] != null)
					model.setEstmTgtFlg(estmTgtFlg[i]);
				if (vvdLvlFlg1[i] != null)
					model.setVvdLvlFlg1(vvdLvlFlg1[i]);
				if (vvdLvlFlg2[i] != null)
					model.setVvdLvlFlg2(vvdLvlFlg2[i]);
				if (vvdLvlFlg3[i] != null)
					model.setVvdLvlFlg3(vvdLvlFlg3[i]);
				if (vvdLvlFlg4[i] != null)
					model.setVvdLvlFlg4(vvdLvlFlg4[i]);
				if (vvdLvlFlg5[i] != null)
					model.setVvdLvlFlg5(vvdLvlFlg5[i]);
				if (vvdLvlFlg6[i] != null)
					model.setVvdLvlFlg6(vvdLvlFlg6[i]);
				if (autoCurrXchRtFlg[i] != null)
					model.setAutoCurrXchRtFlg(autoCurrXchRtFlg[i]);
				if (entrExpnFlg[i] != null)
					model.setEntrExpnFlg(entrExpnFlg[i]);
				if (budIfFlg[i] != null)
					model.setBudIfFlg(budIfFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMdmAccountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMdmAccountVO[]
	 */
	public ModifyMdmAccountVO[] getSearchMdmAccountVOs(){
		ModifyMdmAccountVO[] vos = (ModifyMdmAccountVO[])models.toArray(new ModifyMdmAccountVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctKrnNm = this.acctKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budUseFlg = this.budUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jnlCreFlg = this.jnlCreFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgMngTpCd = this.acctgMngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndTgtFlg = this.pndTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTgtFlg = this.estmTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg1 = this.vvdLvlFlg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg2 = this.vvdLvlFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg3 = this.vvdLvlFlg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg4 = this.vvdLvlFlg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg5 = this.vvdLvlFlg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdLvlFlg6 = this.vvdLvlFlg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoCurrXchRtFlg = this.autoCurrXchRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entrExpnFlg = this.entrExpnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.budIfFlg = this.budIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
