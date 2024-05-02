/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvArStupOfcVO.java
*@FileTitle : InvArStupOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.12.03 Do Soon Choi 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Do Soon Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArStupOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArStupOfcVO> models = new ArrayList<InvArStupOfcVO>();
	
	/* Column Info */
	private String invSndTpCd = null;
	/* Column Info */
	private String arOfcObGrpEml = null;
	/* Column Info */
	private String xchRtRvsFlg = null;
	/* Column Info */
	private String invDupFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String dodArInvIssFlg = null;
	/* Column Info */
	private String invEmlSplitFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invMltBlIssFlg = null;
	/* Column Info */
	private String xchRtUsdTpCd = null;
	/* Column Info */
	private String invIssTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrArInvIssFlg = null;
	/* Column Info */
	private String cpyInvKnt = null;
	/* Column Info */
	private String arOfcIbGrpEml = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invVatChgRt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtInvAplyBlFlg = null;
	/* Column Info */
	private String invVatChgCd = null;
	/* Column Info */
	private String xchRtN3rdTpCd = null;
	/* Column Info */
	private String n3ptyBilArInvFlg = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dmdtArInvIssFlg = null;
	/* Column Info */
	private String mriLoclChgAplyFlg = null;
	/* Column Info */
	private String tmlInvIssFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvArStupOfcVO() {}

	public InvArStupOfcVO(String ibflag, String pagerows, String arOfcCd, String invIssTpCd, String invSndTpCd, String dmdtArInvIssFlg, String n3ptyBilArInvFlg, String dmdtInvAplyBlFlg, String cpyInvKnt, String xchRtRvsFlg, String xchRtUsdTpCd, String xchRtN3rdTpCd, String tmlInvIssFlg, String otsSmryCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String invDupFlg, String invMltBlIssFlg, String invVatChgCd, String invVatChgRt, String chgCd, String mnrArInvIssFlg, String invEmlSplitFlg, String arOfcObGrpEml, String arOfcIbGrpEml, String dodArInvIssFlg, String mriLoclChgAplyFlg) {
		this.invSndTpCd = invSndTpCd;
		this.arOfcObGrpEml = arOfcObGrpEml;
		this.xchRtRvsFlg = xchRtRvsFlg;
		this.invDupFlg = invDupFlg;
		this.deltFlg = deltFlg;
		this.otsSmryCd = otsSmryCd;
		this.creDt = creDt;
		this.chgCd = chgCd;
		this.dodArInvIssFlg = dodArInvIssFlg;
		this.invEmlSplitFlg = invEmlSplitFlg;
		this.pagerows = pagerows;
		this.invMltBlIssFlg = invMltBlIssFlg;
		this.xchRtUsdTpCd = xchRtUsdTpCd;
		this.invIssTpCd = invIssTpCd;
		this.ibflag = ibflag;
		this.mnrArInvIssFlg = mnrArInvIssFlg;
		this.cpyInvKnt = cpyInvKnt;
		this.arOfcIbGrpEml = arOfcIbGrpEml;
		this.updUsrId = updUsrId;
		this.invVatChgRt = invVatChgRt;
		this.updDt = updDt;
		this.dmdtInvAplyBlFlg = dmdtInvAplyBlFlg;
		this.invVatChgCd = invVatChgCd;
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
		this.n3ptyBilArInvFlg = n3ptyBilArInvFlg;
		this.arOfcCd = arOfcCd;
		this.creUsrId = creUsrId;
		this.dmdtArInvIssFlg = dmdtArInvIssFlg;
		this.mriLoclChgAplyFlg = mriLoclChgAplyFlg;
		this.tmlInvIssFlg = tmlInvIssFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_snd_tp_cd", getInvSndTpCd());
		this.hashColumns.put("ar_ofc_ob_grp_eml", getArOfcObGrpEml());
		this.hashColumns.put("xch_rt_rvs_flg", getXchRtRvsFlg());
		this.hashColumns.put("inv_dup_flg", getInvDupFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("dod_ar_inv_iss_flg", getDodArInvIssFlg());
		this.hashColumns.put("inv_eml_split_flg", getInvEmlSplitFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_mlt_bl_iss_flg", getInvMltBlIssFlg());
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());
		this.hashColumns.put("inv_iss_tp_cd", getInvIssTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_ar_inv_iss_flg", getMnrArInvIssFlg());
		this.hashColumns.put("cpy_inv_knt", getCpyInvKnt());
		this.hashColumns.put("ar_ofc_ib_grp_eml", getArOfcIbGrpEml());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_vat_chg_rt", getInvVatChgRt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_inv_aply_bl_flg", getDmdtInvAplyBlFlg());
		this.hashColumns.put("inv_vat_chg_cd", getInvVatChgCd());
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());
		this.hashColumns.put("n3pty_bil_ar_inv_flg", getN3ptyBilArInvFlg());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dmdt_ar_inv_iss_flg", getDmdtArInvIssFlg());
		this.hashColumns.put("mri_locl_chg_aply_flg", getMriLoclChgAplyFlg());
		this.hashColumns.put("tml_inv_iss_flg", getTmlInvIssFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_snd_tp_cd", "invSndTpCd");
		this.hashFields.put("ar_ofc_ob_grp_eml", "arOfcObGrpEml");
		this.hashFields.put("xch_rt_rvs_flg", "xchRtRvsFlg");
		this.hashFields.put("inv_dup_flg", "invDupFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("dod_ar_inv_iss_flg", "dodArInvIssFlg");
		this.hashFields.put("inv_eml_split_flg", "invEmlSplitFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_mlt_bl_iss_flg", "invMltBlIssFlg");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("inv_iss_tp_cd", "invIssTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_ar_inv_iss_flg", "mnrArInvIssFlg");
		this.hashFields.put("cpy_inv_knt", "cpyInvKnt");
		this.hashFields.put("ar_ofc_ib_grp_eml", "arOfcIbGrpEml");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_vat_chg_rt", "invVatChgRt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_inv_aply_bl_flg", "dmdtInvAplyBlFlg");
		this.hashFields.put("inv_vat_chg_cd", "invVatChgCd");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("n3pty_bil_ar_inv_flg", "n3ptyBilArInvFlg");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dmdt_ar_inv_iss_flg", "dmdtArInvIssFlg");
		this.hashFields.put("mri_locl_chg_aply_flg", "mriLoclChgAplyFlg");
		this.hashFields.put("tml_inv_iss_flg", "tmlInvIssFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invSndTpCd
	 */
	public String getInvSndTpCd() {
		return this.invSndTpCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcObGrpEml
	 */
	public String getArOfcObGrpEml() {
		return this.arOfcObGrpEml;
	}
	
	/**
	 * Column Info
	 * @return xchRtRvsFlg
	 */
	public String getXchRtRvsFlg() {
		return this.xchRtRvsFlg;
	}
	
	/**
	 * Column Info
	 * @return invDupFlg
	 */
	public String getInvDupFlg() {
		return this.invDupFlg;
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
	 * @return otsSmryCd
	 */
	public String getOtsSmryCd() {
		return this.otsSmryCd;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return dodArInvIssFlg
	 */
	public String getDodArInvIssFlg() {
		return this.dodArInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @return invEmlSplitFlg
	 */
	public String getInvEmlSplitFlg() {
		return this.invEmlSplitFlg;
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
	 * @return invMltBlIssFlg
	 */
	public String getInvMltBlIssFlg() {
		return this.invMltBlIssFlg;
	}
	
	/**
	 * Column Info
	 * @return xchRtUsdTpCd
	 */
	public String getXchRtUsdTpCd() {
		return this.xchRtUsdTpCd;
	}
	
	/**
	 * Column Info
	 * @return invIssTpCd
	 */
	public String getInvIssTpCd() {
		return this.invIssTpCd;
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
	 * @return mnrArInvIssFlg
	 */
	public String getMnrArInvIssFlg() {
		return this.mnrArInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @return cpyInvKnt
	 */
	public String getCpyInvKnt() {
		return this.cpyInvKnt;
	}
	
	/**
	 * Column Info
	 * @return arOfcIbGrpEml
	 */
	public String getArOfcIbGrpEml() {
		return this.arOfcIbGrpEml;
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
	 * @return invVatChgRt
	 */
	public String getInvVatChgRt() {
		return this.invVatChgRt;
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
	 * @return dmdtInvAplyBlFlg
	 */
	public String getDmdtInvAplyBlFlg() {
		return this.dmdtInvAplyBlFlg;
	}
	
	/**
	 * Column Info
	 * @return invVatChgCd
	 */
	public String getInvVatChgCd() {
		return this.invVatChgCd;
	}
	
	/**
	 * Column Info
	 * @return xchRtN3rdTpCd
	 */
	public String getXchRtN3rdTpCd() {
		return this.xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilArInvFlg
	 */
	public String getN3ptyBilArInvFlg() {
		return this.n3ptyBilArInvFlg;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return dmdtArInvIssFlg
	 */
	public String getDmdtArInvIssFlg() {
		return this.dmdtArInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @return mriLoclChgAplyFlg
	 */
	public String getMriLoclChgAplyFlg() {
		return this.mriLoclChgAplyFlg;
	}
	
	/**
	 * Column Info
	 * @return tmlInvIssFlg
	 */
	public String getTmlInvIssFlg() {
		return this.tmlInvIssFlg;
	}
	

	/**
	 * Column Info
	 * @param invSndTpCd
	 */
	public void setInvSndTpCd(String invSndTpCd) {
		this.invSndTpCd = invSndTpCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcObGrpEml
	 */
	public void setArOfcObGrpEml(String arOfcObGrpEml) {
		this.arOfcObGrpEml = arOfcObGrpEml;
	}
	
	/**
	 * Column Info
	 * @param xchRtRvsFlg
	 */
	public void setXchRtRvsFlg(String xchRtRvsFlg) {
		this.xchRtRvsFlg = xchRtRvsFlg;
	}
	
	/**
	 * Column Info
	 * @param invDupFlg
	 */
	public void setInvDupFlg(String invDupFlg) {
		this.invDupFlg = invDupFlg;
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
	 * @param otsSmryCd
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param dodArInvIssFlg
	 */
	public void setDodArInvIssFlg(String dodArInvIssFlg) {
		this.dodArInvIssFlg = dodArInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @param invEmlSplitFlg
	 */
	public void setInvEmlSplitFlg(String invEmlSplitFlg) {
		this.invEmlSplitFlg = invEmlSplitFlg;
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
	 * @param invMltBlIssFlg
	 */
	public void setInvMltBlIssFlg(String invMltBlIssFlg) {
		this.invMltBlIssFlg = invMltBlIssFlg;
	}
	
	/**
	 * Column Info
	 * @param xchRtUsdTpCd
	 */
	public void setXchRtUsdTpCd(String xchRtUsdTpCd) {
		this.xchRtUsdTpCd = xchRtUsdTpCd;
	}
	
	/**
	 * Column Info
	 * @param invIssTpCd
	 */
	public void setInvIssTpCd(String invIssTpCd) {
		this.invIssTpCd = invIssTpCd;
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
	 * @param mnrArInvIssFlg
	 */
	public void setMnrArInvIssFlg(String mnrArInvIssFlg) {
		this.mnrArInvIssFlg = mnrArInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @param cpyInvKnt
	 */
	public void setCpyInvKnt(String cpyInvKnt) {
		this.cpyInvKnt = cpyInvKnt;
	}
	
	/**
	 * Column Info
	 * @param arOfcIbGrpEml
	 */
	public void setArOfcIbGrpEml(String arOfcIbGrpEml) {
		this.arOfcIbGrpEml = arOfcIbGrpEml;
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
	 * @param invVatChgRt
	 */
	public void setInvVatChgRt(String invVatChgRt) {
		this.invVatChgRt = invVatChgRt;
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
	 * @param dmdtInvAplyBlFlg
	 */
	public void setDmdtInvAplyBlFlg(String dmdtInvAplyBlFlg) {
		this.dmdtInvAplyBlFlg = dmdtInvAplyBlFlg;
	}
	
	/**
	 * Column Info
	 * @param invVatChgCd
	 */
	public void setInvVatChgCd(String invVatChgCd) {
		this.invVatChgCd = invVatChgCd;
	}
	
	/**
	 * Column Info
	 * @param xchRtN3rdTpCd
	 */
	public void setXchRtN3rdTpCd(String xchRtN3rdTpCd) {
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilArInvFlg
	 */
	public void setN3ptyBilArInvFlg(String n3ptyBilArInvFlg) {
		this.n3ptyBilArInvFlg = n3ptyBilArInvFlg;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param dmdtArInvIssFlg
	 */
	public void setDmdtArInvIssFlg(String dmdtArInvIssFlg) {
		this.dmdtArInvIssFlg = dmdtArInvIssFlg;
	}
	
	/**
	 * Column Info
	 * @param mriLoclChgAplyFlg
	 */
	public void setMriLoclChgAplyFlg(String mriLoclChgAplyFlg) {
		this.mriLoclChgAplyFlg = mriLoclChgAplyFlg;
	}
	
	/**
	 * Column Info
	 * @param tmlInvIssFlg
	 */
	public void setTmlInvIssFlg(String tmlInvIssFlg) {
		this.tmlInvIssFlg = tmlInvIssFlg;
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
		setInvSndTpCd(JSPUtil.getParameter(request, prefix + "inv_snd_tp_cd", ""));
		setArOfcObGrpEml(JSPUtil.getParameter(request, prefix + "ar_ofc_ob_grp_eml", ""));
		setXchRtRvsFlg(JSPUtil.getParameter(request, prefix + "xch_rt_rvs_flg", ""));
		setInvDupFlg(JSPUtil.getParameter(request, prefix + "inv_dup_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, prefix + "ots_smry_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setDodArInvIssFlg(JSPUtil.getParameter(request, prefix + "dod_ar_inv_iss_flg", ""));
		setInvEmlSplitFlg(JSPUtil.getParameter(request, prefix + "inv_eml_split_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvMltBlIssFlg(JSPUtil.getParameter(request, prefix + "inv_mlt_bl_iss_flg", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_usd_tp_cd", ""));
		setInvIssTpCd(JSPUtil.getParameter(request, prefix + "inv_iss_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMnrArInvIssFlg(JSPUtil.getParameter(request, prefix + "mnr_ar_inv_iss_flg", ""));
		setCpyInvKnt(JSPUtil.getParameter(request, prefix + "cpy_inv_knt", ""));
		setArOfcIbGrpEml(JSPUtil.getParameter(request, prefix + "ar_ofc_ib_grp_eml", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvVatChgRt(JSPUtil.getParameter(request, prefix + "inv_vat_chg_rt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDmdtInvAplyBlFlg(JSPUtil.getParameter(request, prefix + "dmdt_inv_aply_bl_flg", ""));
		setInvVatChgCd(JSPUtil.getParameter(request, prefix + "inv_vat_chg_cd", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_n3rd_tp_cd", ""));
		setN3ptyBilArInvFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_ar_inv_flg", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDmdtArInvIssFlg(JSPUtil.getParameter(request, prefix + "dmdt_ar_inv_iss_flg", ""));
		setMriLoclChgAplyFlg(JSPUtil.getParameter(request, prefix + "mri_locl_chg_aply_flg", ""));
		setTmlInvIssFlg(JSPUtil.getParameter(request, prefix + "tml_inv_iss_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArStupOfcVO[]
	 */
	public InvArStupOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArStupOfcVO[]
	 */
	public InvArStupOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArStupOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invSndTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_snd_tp_cd", length));
			String[] arOfcObGrpEml = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_ob_grp_eml", length));
			String[] xchRtRvsFlg = (JSPUtil.getParameter(request, prefix	+ "xch_rt_rvs_flg", length));
			String[] invDupFlg = (JSPUtil.getParameter(request, prefix	+ "inv_dup_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] dodArInvIssFlg = (JSPUtil.getParameter(request, prefix	+ "dod_ar_inv_iss_flg", length));
			String[] invEmlSplitFlg = (JSPUtil.getParameter(request, prefix	+ "inv_eml_split_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invMltBlIssFlg = (JSPUtil.getParameter(request, prefix	+ "inv_mlt_bl_iss_flg", length));
			String[] xchRtUsdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_usd_tp_cd", length));
			String[] invIssTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrArInvIssFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_ar_inv_iss_flg", length));
			String[] cpyInvKnt = (JSPUtil.getParameter(request, prefix	+ "cpy_inv_knt", length));
			String[] arOfcIbGrpEml = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_ib_grp_eml", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invVatChgRt = (JSPUtil.getParameter(request, prefix	+ "inv_vat_chg_rt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtInvAplyBlFlg = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_aply_bl_flg", length));
			String[] invVatChgCd = (JSPUtil.getParameter(request, prefix	+ "inv_vat_chg_cd", length));
			String[] xchRtN3rdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_n3rd_tp_cd", length));
			String[] n3ptyBilArInvFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_ar_inv_flg", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dmdtArInvIssFlg = (JSPUtil.getParameter(request, prefix	+ "dmdt_ar_inv_iss_flg", length));
			String[] mriLoclChgAplyFlg = (JSPUtil.getParameter(request, prefix	+ "mri_locl_chg_aply_flg", length));
			String[] tmlInvIssFlg = (JSPUtil.getParameter(request, prefix	+ "tml_inv_iss_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArStupOfcVO();
				if (invSndTpCd[i] != null)
					model.setInvSndTpCd(invSndTpCd[i]);
				if (arOfcObGrpEml[i] != null)
					model.setArOfcObGrpEml(arOfcObGrpEml[i]);
				if (xchRtRvsFlg[i] != null)
					model.setXchRtRvsFlg(xchRtRvsFlg[i]);
				if (invDupFlg[i] != null)
					model.setInvDupFlg(invDupFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (dodArInvIssFlg[i] != null)
					model.setDodArInvIssFlg(dodArInvIssFlg[i]);
				if (invEmlSplitFlg[i] != null)
					model.setInvEmlSplitFlg(invEmlSplitFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invMltBlIssFlg[i] != null)
					model.setInvMltBlIssFlg(invMltBlIssFlg[i]);
				if (xchRtUsdTpCd[i] != null)
					model.setXchRtUsdTpCd(xchRtUsdTpCd[i]);
				if (invIssTpCd[i] != null)
					model.setInvIssTpCd(invIssTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrArInvIssFlg[i] != null)
					model.setMnrArInvIssFlg(mnrArInvIssFlg[i]);
				if (cpyInvKnt[i] != null)
					model.setCpyInvKnt(cpyInvKnt[i]);
				if (arOfcIbGrpEml[i] != null)
					model.setArOfcIbGrpEml(arOfcIbGrpEml[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invVatChgRt[i] != null)
					model.setInvVatChgRt(invVatChgRt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtInvAplyBlFlg[i] != null)
					model.setDmdtInvAplyBlFlg(dmdtInvAplyBlFlg[i]);
				if (invVatChgCd[i] != null)
					model.setInvVatChgCd(invVatChgCd[i]);
				if (xchRtN3rdTpCd[i] != null)
					model.setXchRtN3rdTpCd(xchRtN3rdTpCd[i]);
				if (n3ptyBilArInvFlg[i] != null)
					model.setN3ptyBilArInvFlg(n3ptyBilArInvFlg[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dmdtArInvIssFlg[i] != null)
					model.setDmdtArInvIssFlg(dmdtArInvIssFlg[i]);
				if (mriLoclChgAplyFlg[i] != null)
					model.setMriLoclChgAplyFlg(mriLoclChgAplyFlg[i]);
				if (tmlInvIssFlg[i] != null)
					model.setTmlInvIssFlg(tmlInvIssFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArStupOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArStupOfcVO[]
	 */
	public InvArStupOfcVO[] getInvArStupOfcVOs(){
		InvArStupOfcVO[] vos = (InvArStupOfcVO[])models.toArray(new InvArStupOfcVO[models.size()]);
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
		this.invSndTpCd = this.invSndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcObGrpEml = this.arOfcObGrpEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtRvsFlg = this.xchRtRvsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDupFlg = this.invDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dodArInvIssFlg = this.dodArInvIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEmlSplitFlg = this.invEmlSplitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMltBlIssFlg = this.invMltBlIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd = this.xchRtUsdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssTpCd = this.invIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrArInvIssFlg = this.mnrArInvIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpyInvKnt = this.cpyInvKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcIbGrpEml = this.arOfcIbGrpEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatChgRt = this.invVatChgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvAplyBlFlg = this.dmdtInvAplyBlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatChgCd = this.invVatChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd = this.xchRtN3rdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilArInvFlg = this.n3ptyBilArInvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArInvIssFlg = this.dmdtArInvIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mriLoclChgAplyFlg = this.mriLoclChgAplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvIssFlg = this.tmlInvIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
