/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchMdmChargeVO.java
*@FileTitle : SearchMdmChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.28 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMdmChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMdmChargeVO> models = new ArrayList<SearchMdmChargeVO>();
	
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String eaiIfId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String naRdTermFlg = null;
	/* Column Info */
	private String hjsChgAcctCd = null;
	/* Column Info */
	private String chgAplyTpCd = null;
	/* Column Info */
	private String tklTmlFlg = null;
	/* Column Info */
	private String idaChgNm = null;
	/* Column Info */
	private String cyRdTermFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chgAplyAreaCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chgStsCd = null;
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String idaSacCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String aplySvcModFlg = null;
	/* Column Info */
	private String idaSacNm = null;
	/* Column Info */
	private String chgNm = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String frtChgTpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String useCoTpCd = null;
	/* Column Info */
	private String senGrpChgCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String senChgAcctCd = null;
	/* Column Info */
	private String chgRevTpCd = null;
	/* Column Info */
	private String chgEdiCd = null;
	/* Column Info */
	private String autoRatFlg = null;
	/* Column Info */
	private String cfsRdTermFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mdtRatFlg = null;
	/* Column Info */
	private String dorRdTermFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMdmChargeVO() {}

	public SearchMdmChargeVO(String ibflag, String pagerows, String chgCd, String chgNm, String frtChgTpCd, String senChgAcctCd, String hjsChgAcctCd, String repChgCd, String chgRevTpCd, String chgAplyTpCd, String chgAplyAreaCd, String cyRdTermFlg, String cfsRdTermFlg, String dorRdTermFlg, String naRdTermFlg, String tklTmlFlg, String aplySvcModFlg, String useCoTpCd, String autoRatFlg, String senGrpChgCd, String chgEdiCd, String dpSeq, String chgStsCd, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg, String eaiEvntDt, String eaiIfId, String mdtRatFlg, String idaChgNm, String idaSacCd, String idaSacNm) {
		this.chgCd = chgCd;
		this.eaiIfId = eaiIfId;
		this.ibflag = ibflag;
		this.dpSeq = dpSeq;
		this.naRdTermFlg = naRdTermFlg;
		this.hjsChgAcctCd = hjsChgAcctCd;
		this.chgAplyTpCd = chgAplyTpCd;
		this.tklTmlFlg = tklTmlFlg;
		this.idaChgNm = idaChgNm;
		this.cyRdTermFlg = cyRdTermFlg;
		this.updUsrId = updUsrId;
		this.chgAplyAreaCd = chgAplyAreaCd;
		this.creUsrId = creUsrId;
		this.chgStsCd = chgStsCd;
		this.repChgCd = repChgCd;
		this.idaSacCd = idaSacCd;
		this.pagerows = pagerows;
		this.aplySvcModFlg = aplySvcModFlg;
		this.idaSacNm = idaSacNm;
		this.chgNm = chgNm;
		this.eaiEvntDt = eaiEvntDt;
		this.frtChgTpCd = frtChgTpCd;
		this.deltFlg = deltFlg;
		this.useCoTpCd = useCoTpCd;
		this.senGrpChgCd = senGrpChgCd;
		this.creDt = creDt;
		this.senChgAcctCd = senChgAcctCd;
		this.chgRevTpCd = chgRevTpCd;
		this.chgEdiCd = chgEdiCd;
		this.autoRatFlg = autoRatFlg;
		this.cfsRdTermFlg = cfsRdTermFlg;
		this.updDt = updDt;
		this.mdtRatFlg = mdtRatFlg;
		this.dorRdTermFlg = dorRdTermFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("na_rd_term_flg", getNaRdTermFlg());
		this.hashColumns.put("hjs_chg_acct_cd", getHjsChgAcctCd());
		this.hashColumns.put("chg_aply_tp_cd", getChgAplyTpCd());
		this.hashColumns.put("tkl_tml_flg", getTklTmlFlg());
		this.hashColumns.put("ida_chg_nm", getIdaChgNm());
		this.hashColumns.put("cy_rd_term_flg", getCyRdTermFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chg_aply_area_cd", getChgAplyAreaCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chg_sts_cd", getChgStsCd());
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("ida_sac_cd", getIdaSacCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("aply_svc_mod_flg", getAplySvcModFlg());
		this.hashColumns.put("ida_sac_nm", getIdaSacNm());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("frt_chg_tp_cd", getFrtChgTpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("use_co_tp_cd", getUseCoTpCd());
		this.hashColumns.put("sen_grp_chg_cd", getSenGrpChgCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sen_chg_acct_cd", getSenChgAcctCd());
		this.hashColumns.put("chg_rev_tp_cd", getChgRevTpCd());
		this.hashColumns.put("chg_edi_cd", getChgEdiCd());
		this.hashColumns.put("auto_rat_flg", getAutoRatFlg());
		this.hashColumns.put("cfs_rd_term_flg", getCfsRdTermFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mdt_rat_flg", getMdtRatFlg());
		this.hashColumns.put("dor_rd_term_flg", getDorRdTermFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("na_rd_term_flg", "naRdTermFlg");
		this.hashFields.put("hjs_chg_acct_cd", "hjsChgAcctCd");
		this.hashFields.put("chg_aply_tp_cd", "chgAplyTpCd");
		this.hashFields.put("tkl_tml_flg", "tklTmlFlg");
		this.hashFields.put("ida_chg_nm", "idaChgNm");
		this.hashFields.put("cy_rd_term_flg", "cyRdTermFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chg_aply_area_cd", "chgAplyAreaCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chg_sts_cd", "chgStsCd");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("ida_sac_cd", "idaSacCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aply_svc_mod_flg", "aplySvcModFlg");
		this.hashFields.put("ida_sac_nm", "idaSacNm");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("frt_chg_tp_cd", "frtChgTpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("use_co_tp_cd", "useCoTpCd");
		this.hashFields.put("sen_grp_chg_cd", "senGrpChgCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sen_chg_acct_cd", "senChgAcctCd");
		this.hashFields.put("chg_rev_tp_cd", "chgRevTpCd");
		this.hashFields.put("chg_edi_cd", "chgEdiCd");
		this.hashFields.put("auto_rat_flg", "autoRatFlg");
		this.hashFields.put("cfs_rd_term_flg", "cfsRdTermFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mdt_rat_flg", "mdtRatFlg");
		this.hashFields.put("dor_rd_term_flg", "dorRdTermFlg");
		return this.hashFields;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
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
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return hjsChgAcctCd
	 */
	public String getHjsChgAcctCd() {
		return this.hjsChgAcctCd;
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
	 * @return tklTmlFlg
	 */
	public String getTklTmlFlg() {
		return this.tklTmlFlg;
	}
	
	/**
	 * Column Info
	 * @return idaChgNm
	 */
	public String getIdaChgNm() {
		return this.idaChgNm;
	}
	
	/**
	 * Column Info
	 * @return cyRdTermFlg
	 */
	public String getCyRdTermFlg() {
		return this.cyRdTermFlg;
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
	 * @return chgAplyAreaCd
	 */
	public String getChgAplyAreaCd() {
		return this.chgAplyAreaCd;
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
	 * @return chgStsCd
	 */
	public String getChgStsCd() {
		return this.chgStsCd;
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
	 * @return idaSacCd
	 */
	public String getIdaSacCd() {
		return this.idaSacCd;
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
	 * @return aplySvcModFlg
	 */
	public String getAplySvcModFlg() {
		return this.aplySvcModFlg;
	}
	
	/**
	 * Column Info
	 * @return idaSacNm
	 */
	public String getIdaSacNm() {
		return this.idaSacNm;
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
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
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
	 * @return useCoTpCd
	 */
	public String getUseCoTpCd() {
		return this.useCoTpCd;
	}
	
	/**
	 * Column Info
	 * @return senGrpChgCd
	 */
	public String getSenGrpChgCd() {
		return this.senGrpChgCd;
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
	 * @return senChgAcctCd
	 */
	public String getSenChgAcctCd() {
		return this.senChgAcctCd;
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
	 * @return chgEdiCd
	 */
	public String getChgEdiCd() {
		return this.chgEdiCd;
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
	 * @return cfsRdTermFlg
	 */
	public String getCfsRdTermFlg() {
		return this.cfsRdTermFlg;
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
	 * @return mdtRatFlg
	 */
	public String getMdtRatFlg() {
		return this.mdtRatFlg;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param hjsChgAcctCd
	 */
	public void setHjsChgAcctCd(String hjsChgAcctCd) {
		this.hjsChgAcctCd = hjsChgAcctCd;
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
	 * @param tklTmlFlg
	 */
	public void setTklTmlFlg(String tklTmlFlg) {
		this.tklTmlFlg = tklTmlFlg;
	}
	
	/**
	 * Column Info
	 * @param idaChgNm
	 */
	public void setIdaChgNm(String idaChgNm) {
		this.idaChgNm = idaChgNm;
	}
	
	/**
	 * Column Info
	 * @param cyRdTermFlg
	 */
	public void setCyRdTermFlg(String cyRdTermFlg) {
		this.cyRdTermFlg = cyRdTermFlg;
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
	 * @param chgAplyAreaCd
	 */
	public void setChgAplyAreaCd(String chgAplyAreaCd) {
		this.chgAplyAreaCd = chgAplyAreaCd;
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
	 * @param chgStsCd
	 */
	public void setChgStsCd(String chgStsCd) {
		this.chgStsCd = chgStsCd;
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
	 * @param idaSacCd
	 */
	public void setIdaSacCd(String idaSacCd) {
		this.idaSacCd = idaSacCd;
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
	 * @param aplySvcModFlg
	 */
	public void setAplySvcModFlg(String aplySvcModFlg) {
		this.aplySvcModFlg = aplySvcModFlg;
	}
	
	/**
	 * Column Info
	 * @param idaSacNm
	 */
	public void setIdaSacNm(String idaSacNm) {
		this.idaSacNm = idaSacNm;
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
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
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
	 * @param useCoTpCd
	 */
	public void setUseCoTpCd(String useCoTpCd) {
		this.useCoTpCd = useCoTpCd;
	}
	
	/**
	 * Column Info
	 * @param senGrpChgCd
	 */
	public void setSenGrpChgCd(String senGrpChgCd) {
		this.senGrpChgCd = senGrpChgCd;
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
	 * @param senChgAcctCd
	 */
	public void setSenChgAcctCd(String senChgAcctCd) {
		this.senChgAcctCd = senChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @param chgRevTpCd
	 */
	public void setChgRevTpCd(String chgRevTpCd) {
		this.chgRevTpCd = chgRevTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgEdiCd
	 */
	public void setChgEdiCd(String chgEdiCd) {
		this.chgEdiCd = chgEdiCd;
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
	 * @param cfsRdTermFlg
	 */
	public void setCfsRdTermFlg(String cfsRdTermFlg) {
		this.cfsRdTermFlg = cfsRdTermFlg;
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
	 * @param mdtRatFlg
	 */
	public void setMdtRatFlg(String mdtRatFlg) {
		this.mdtRatFlg = mdtRatFlg;
	}
	
	/**
	 * Column Info
	 * @param dorRdTermFlg
	 */
	public void setDorRdTermFlg(String dorRdTermFlg) {
		this.dorRdTermFlg = dorRdTermFlg;
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
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setNaRdTermFlg(JSPUtil.getParameter(request, prefix + "na_rd_term_flg", ""));
		setHjsChgAcctCd(JSPUtil.getParameter(request, prefix + "hjs_chg_acct_cd", ""));
		setChgAplyTpCd(JSPUtil.getParameter(request, prefix + "chg_aply_tp_cd", ""));
		setTklTmlFlg(JSPUtil.getParameter(request, prefix + "tkl_tml_flg", ""));
		setIdaChgNm(JSPUtil.getParameter(request, prefix + "ida_chg_nm", ""));
		setCyRdTermFlg(JSPUtil.getParameter(request, prefix + "cy_rd_term_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setChgAplyAreaCd(JSPUtil.getParameter(request, prefix + "chg_aply_area_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChgStsCd(JSPUtil.getParameter(request, prefix + "chg_sts_cd", ""));
		setRepChgCd(JSPUtil.getParameter(request, prefix + "rep_chg_cd", ""));
		setIdaSacCd(JSPUtil.getParameter(request, prefix + "ida_sac_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAplySvcModFlg(JSPUtil.getParameter(request, prefix + "aply_svc_mod_flg", ""));
		setIdaSacNm(JSPUtil.getParameter(request, prefix + "ida_sac_nm", ""));
		setChgNm(JSPUtil.getParameter(request, prefix + "chg_nm", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setFrtChgTpCd(JSPUtil.getParameter(request, prefix + "frt_chg_tp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setUseCoTpCd(JSPUtil.getParameter(request, prefix + "use_co_tp_cd", ""));
		setSenGrpChgCd(JSPUtil.getParameter(request, prefix + "sen_grp_chg_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSenChgAcctCd(JSPUtil.getParameter(request, prefix + "sen_chg_acct_cd", ""));
		setChgRevTpCd(JSPUtil.getParameter(request, prefix + "chg_rev_tp_cd", ""));
		setChgEdiCd(JSPUtil.getParameter(request, prefix + "chg_edi_cd", ""));
		setAutoRatFlg(JSPUtil.getParameter(request, prefix + "auto_rat_flg", ""));
		setCfsRdTermFlg(JSPUtil.getParameter(request, prefix + "cfs_rd_term_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMdtRatFlg(JSPUtil.getParameter(request, prefix + "mdt_rat_flg", ""));
		setDorRdTermFlg(JSPUtil.getParameter(request, prefix + "dor_rd_term_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMdmChargeVO[]
	 */
	public SearchMdmChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMdmChargeVO[]
	 */
	public SearchMdmChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMdmChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] naRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "na_rd_term_flg", length));
			String[] hjsChgAcctCd = (JSPUtil.getParameter(request, prefix	+ "hjs_chg_acct_cd", length));
			String[] chgAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_aply_tp_cd", length));
			String[] tklTmlFlg = (JSPUtil.getParameter(request, prefix	+ "tkl_tml_flg", length));
			String[] idaChgNm = (JSPUtil.getParameter(request, prefix	+ "ida_chg_nm", length));
			String[] cyRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "cy_rd_term_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chgAplyAreaCd = (JSPUtil.getParameter(request, prefix	+ "chg_aply_area_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chgStsCd = (JSPUtil.getParameter(request, prefix	+ "chg_sts_cd", length));
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] idaSacCd = (JSPUtil.getParameter(request, prefix	+ "ida_sac_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] aplySvcModFlg = (JSPUtil.getParameter(request, prefix	+ "aply_svc_mod_flg", length));
			String[] idaSacNm = (JSPUtil.getParameter(request, prefix	+ "ida_sac_nm", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] frtChgTpCd = (JSPUtil.getParameter(request, prefix	+ "frt_chg_tp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] useCoTpCd = (JSPUtil.getParameter(request, prefix	+ "use_co_tp_cd", length));
			String[] senGrpChgCd = (JSPUtil.getParameter(request, prefix	+ "sen_grp_chg_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] senChgAcctCd = (JSPUtil.getParameter(request, prefix	+ "sen_chg_acct_cd", length));
			String[] chgRevTpCd = (JSPUtil.getParameter(request, prefix	+ "chg_rev_tp_cd", length));
			String[] chgEdiCd = (JSPUtil.getParameter(request, prefix	+ "chg_edi_cd", length));
			String[] autoRatFlg = (JSPUtil.getParameter(request, prefix	+ "auto_rat_flg", length));
			String[] cfsRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "cfs_rd_term_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mdtRatFlg = (JSPUtil.getParameter(request, prefix	+ "mdt_rat_flg", length));
			String[] dorRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "dor_rd_term_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMdmChargeVO();
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (naRdTermFlg[i] != null)
					model.setNaRdTermFlg(naRdTermFlg[i]);
				if (hjsChgAcctCd[i] != null)
					model.setHjsChgAcctCd(hjsChgAcctCd[i]);
				if (chgAplyTpCd[i] != null)
					model.setChgAplyTpCd(chgAplyTpCd[i]);
				if (tklTmlFlg[i] != null)
					model.setTklTmlFlg(tklTmlFlg[i]);
				if (idaChgNm[i] != null)
					model.setIdaChgNm(idaChgNm[i]);
				if (cyRdTermFlg[i] != null)
					model.setCyRdTermFlg(cyRdTermFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chgAplyAreaCd[i] != null)
					model.setChgAplyAreaCd(chgAplyAreaCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chgStsCd[i] != null)
					model.setChgStsCd(chgStsCd[i]);
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (idaSacCd[i] != null)
					model.setIdaSacCd(idaSacCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (aplySvcModFlg[i] != null)
					model.setAplySvcModFlg(aplySvcModFlg[i]);
				if (idaSacNm[i] != null)
					model.setIdaSacNm(idaSacNm[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (frtChgTpCd[i] != null)
					model.setFrtChgTpCd(frtChgTpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (useCoTpCd[i] != null)
					model.setUseCoTpCd(useCoTpCd[i]);
				if (senGrpChgCd[i] != null)
					model.setSenGrpChgCd(senGrpChgCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (senChgAcctCd[i] != null)
					model.setSenChgAcctCd(senChgAcctCd[i]);
				if (chgRevTpCd[i] != null)
					model.setChgRevTpCd(chgRevTpCd[i]);
				if (chgEdiCd[i] != null)
					model.setChgEdiCd(chgEdiCd[i]);
				if (autoRatFlg[i] != null)
					model.setAutoRatFlg(autoRatFlg[i]);
				if (cfsRdTermFlg[i] != null)
					model.setCfsRdTermFlg(cfsRdTermFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mdtRatFlg[i] != null)
					model.setMdtRatFlg(mdtRatFlg[i]);
				if (dorRdTermFlg[i] != null)
					model.setDorRdTermFlg(dorRdTermFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMdmChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMdmChargeVO[]
	 */
	public SearchMdmChargeVO[] getSearchMdmChargeVOs(){
		SearchMdmChargeVO[] vos = (SearchMdmChargeVO[])models.toArray(new SearchMdmChargeVO[models.size()]);
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
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.naRdTermFlg = this.naRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsChgAcctCd = this.hjsChgAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAplyTpCd = this.chgAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tklTmlFlg = this.tklTmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaChgNm = this.idaChgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cyRdTermFlg = this.cyRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAplyAreaCd = this.chgAplyAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgStsCd = this.chgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacCd = this.idaSacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplySvcModFlg = this.aplySvcModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacNm = this.idaSacNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChgTpCd = this.frtChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useCoTpCd = this.useCoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senGrpChgCd = this.senGrpChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senChgAcctCd = this.senChgAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRevTpCd = this.chgRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgEdiCd = this.chgEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoRatFlg = this.autoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfsRdTermFlg = this.cfsRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdtRatFlg = this.mdtRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorRdTermFlg = this.dorRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
