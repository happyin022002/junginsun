/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchAutoAuditChangeHistoryVO.java
*@FileTitle : SearchAutoAuditChangeHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2016.04.04 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAutoAuditChangeHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAutoAuditChangeHistoryVO> models = new ArrayList<SearchAutoAuditChangeHistoryVO>();
	
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String capoCnt = null;
	/* Column Info */
	private String cocoUsdAmt = null;
	/* Column Info */
	private String totUsdAmt = null;
	/* Column Info */
	private String sInvCfmFmDt = null;
	/* Column Info */
	private String cocaUsdAmt = null;
	/* Column Info */
	private String expnAudRsltCd = null;
	/* Column Info */
	private String pocaCnt = null;
	/* Column Info */
	private String cocaCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cacoUsdAmt = null;
	/* Column Info */
	private String sInvCfmToDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pocaUsdAmt = null;
	/* Column Info */
	private String sBeforeStsCd = null;
	/* Column Info */
	private String sExpnAudRsltCd = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String pocoCnt = null;
	/* Column Info */
	private String cocoCnt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String sMdlCd = null;
	/* Column Info */
	private String totCnt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String sEacIfFlg = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String copoCnt = null;
	/* Column Info */
	private String popoUsdAmt = null;
	/* Column Info */
	private String pocoUsdAmt = null;
	/* Column Info */
	private String cacoCnt = null;
	/* Column Info */
	private String mdlCd = null;
	/* Column Info */
	private String rhqOrd = null;
	/* Column Info */
	private String sMoreThanAmt = null;
	/* Column Info */
	private String cacaCnt = null;
	/* Column Info */
	private String sAfterStsCd = null;
	/* Column Info */
	private String popoCnt = null;
	/* Column Info */
	private String cacaUsdAmt = null;
	/* Column Info */
	private String capoUsdAmt = null;
	/* Column Info */
	private String copoUsdAmt = null;
	/* Column Info */
	private String mdlOrd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAutoAuditChangeHistoryVO() {}

	public SearchAutoAuditChangeHistoryVO(String ibflag, String pagerows, String mdlCd, String rhqCd, String invOfcCd, String tpCd, String expnAudRsltCd, String cacoCnt, String cacoUsdAmt, String capoCnt, String capoUsdAmt, String pocaCnt, String pocaUsdAmt, String pocoCnt, String pocoUsdAmt, String cocaCnt, String cocaUsdAmt, String copoCnt, String copoUsdAmt, String cacaCnt, String cacaUsdAmt, String cocoCnt, String cocoUsdAmt, String popoCnt, String popoUsdAmt, String totCnt, String totUsdAmt, String rhqOrd, String mdlOrd, String sRhqOfcCd, String sOfcCd, String sInvCfmFmDt, String sInvCfmToDt, String sMdlCd, String sBeforeStsCd, String sAfterStsCd, String sEacIfFlg, String sMoreThanAmt, String sExpnAudRsltCd) {
		this.sRhqOfcCd = sRhqOfcCd;
		this.capoCnt = capoCnt;
		this.cocoUsdAmt = cocoUsdAmt;
		this.totUsdAmt = totUsdAmt;
		this.sInvCfmFmDt = sInvCfmFmDt;
		this.cocaUsdAmt = cocaUsdAmt;
		this.expnAudRsltCd = expnAudRsltCd;
		this.pocaCnt = pocaCnt;
		this.cocaCnt = cocaCnt;
		this.pagerows = pagerows;
		this.cacoUsdAmt = cacoUsdAmt;
		this.sInvCfmToDt = sInvCfmToDt;
		this.ibflag = ibflag;
		this.pocaUsdAmt = pocaUsdAmt;
		this.sBeforeStsCd = sBeforeStsCd;
		this.sExpnAudRsltCd = sExpnAudRsltCd;
		this.tpCd = tpCd;
		this.pocoCnt = pocoCnt;
		this.cocoCnt = cocoCnt;
		this.invOfcCd = invOfcCd;
		this.sMdlCd = sMdlCd;
		this.totCnt = totCnt;
		this.rhqCd = rhqCd;
		this.sEacIfFlg = sEacIfFlg;
		this.sOfcCd = sOfcCd;
		this.copoCnt = copoCnt;
		this.popoUsdAmt = popoUsdAmt;
		this.pocoUsdAmt = pocoUsdAmt;
		this.cacoCnt = cacoCnt;
		this.mdlCd = mdlCd;
		this.rhqOrd = rhqOrd;
		this.sMoreThanAmt = sMoreThanAmt;
		this.cacaCnt = cacaCnt;
		this.sAfterStsCd = sAfterStsCd;
		this.popoCnt = popoCnt;
		this.cacaUsdAmt = cacaUsdAmt;
		this.capoUsdAmt = capoUsdAmt;
		this.copoUsdAmt = copoUsdAmt;
		this.mdlOrd = mdlOrd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("capo_cnt", getCapoCnt());
		this.hashColumns.put("coco_usd_amt", getCocoUsdAmt());
		this.hashColumns.put("tot_usd_amt", getTotUsdAmt());
		this.hashColumns.put("s_inv_cfm_fm_dt", getSInvCfmFmDt());
		this.hashColumns.put("coca_usd_amt", getCocaUsdAmt());
		this.hashColumns.put("expn_aud_rslt_cd", getExpnAudRsltCd());
		this.hashColumns.put("poca_cnt", getPocaCnt());
		this.hashColumns.put("coca_cnt", getCocaCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("caco_usd_amt", getCacoUsdAmt());
		this.hashColumns.put("s_inv_cfm_to_dt", getSInvCfmToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("poca_usd_amt", getPocaUsdAmt());
		this.hashColumns.put("s_before_sts_cd", getSBeforeStsCd());
		this.hashColumns.put("s_expn_aud_rslt_cd", getSExpnAudRsltCd());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("poco_cnt", getPocoCnt());
		this.hashColumns.put("coco_cnt", getCocoCnt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("s_mdl_cd", getSMdlCd());
		this.hashColumns.put("tot_cnt", getTotCnt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("s_eac_if_flg", getSEacIfFlg());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("copo_cnt", getCopoCnt());
		this.hashColumns.put("popo_usd_amt", getPopoUsdAmt());
		this.hashColumns.put("poco_usd_amt", getPocoUsdAmt());
		this.hashColumns.put("caco_cnt", getCacoCnt());
		this.hashColumns.put("mdl_cd", getMdlCd());
		this.hashColumns.put("rhq_ord", getRhqOrd());
		this.hashColumns.put("s_more_than_amt", getSMoreThanAmt());
		this.hashColumns.put("caca_cnt", getCacaCnt());
		this.hashColumns.put("s_after_sts_cd", getSAfterStsCd());
		this.hashColumns.put("popo_cnt", getPopoCnt());
		this.hashColumns.put("caca_usd_amt", getCacaUsdAmt());
		this.hashColumns.put("capo_usd_amt", getCapoUsdAmt());
		this.hashColumns.put("copo_usd_amt", getCopoUsdAmt());
		this.hashColumns.put("mdl_ord", getMdlOrd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("capo_cnt", "capoCnt");
		this.hashFields.put("coco_usd_amt", "cocoUsdAmt");
		this.hashFields.put("tot_usd_amt", "totUsdAmt");
		this.hashFields.put("s_inv_cfm_fm_dt", "sInvCfmFmDt");
		this.hashFields.put("coca_usd_amt", "cocaUsdAmt");
		this.hashFields.put("expn_aud_rslt_cd", "expnAudRsltCd");
		this.hashFields.put("poca_cnt", "pocaCnt");
		this.hashFields.put("coca_cnt", "cocaCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("caco_usd_amt", "cacoUsdAmt");
		this.hashFields.put("s_inv_cfm_to_dt", "sInvCfmToDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("poca_usd_amt", "pocaUsdAmt");
		this.hashFields.put("s_before_sts_cd", "sBeforeStsCd");
		this.hashFields.put("s_expn_aud_rslt_cd", "sExpnAudRsltCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("poco_cnt", "pocoCnt");
		this.hashFields.put("coco_cnt", "cocoCnt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("s_mdl_cd", "sMdlCd");
		this.hashFields.put("tot_cnt", "totCnt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("s_eac_if_flg", "sEacIfFlg");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("copo_cnt", "copoCnt");
		this.hashFields.put("popo_usd_amt", "popoUsdAmt");
		this.hashFields.put("poco_usd_amt", "pocoUsdAmt");
		this.hashFields.put("caco_cnt", "cacoCnt");
		this.hashFields.put("mdl_cd", "mdlCd");
		this.hashFields.put("rhq_ord", "rhqOrd");
		this.hashFields.put("s_more_than_amt", "sMoreThanAmt");
		this.hashFields.put("caca_cnt", "cacaCnt");
		this.hashFields.put("s_after_sts_cd", "sAfterStsCd");
		this.hashFields.put("popo_cnt", "popoCnt");
		this.hashFields.put("caca_usd_amt", "cacaUsdAmt");
		this.hashFields.put("capo_usd_amt", "capoUsdAmt");
		this.hashFields.put("copo_usd_amt", "copoUsdAmt");
		this.hashFields.put("mdl_ord", "mdlOrd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return capoCnt
	 */
	public String getCapoCnt() {
		return this.capoCnt;
	}
	
	/**
	 * Column Info
	 * @return cocoUsdAmt
	 */
	public String getCocoUsdAmt() {
		return this.cocoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return totUsdAmt
	 */
	public String getTotUsdAmt() {
		return this.totUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sInvCfmFmDt
	 */
	public String getSInvCfmFmDt() {
		return this.sInvCfmFmDt;
	}
	
	/**
	 * Column Info
	 * @return cocaUsdAmt
	 */
	public String getCocaUsdAmt() {
		return this.cocaUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return expnAudRsltCd
	 */
	public String getExpnAudRsltCd() {
		return this.expnAudRsltCd;
	}
	
	/**
	 * Column Info
	 * @return pocaCnt
	 */
	public String getPocaCnt() {
		return this.pocaCnt;
	}
	
	/**
	 * Column Info
	 * @return cocaCnt
	 */
	public String getCocaCnt() {
		return this.cocaCnt;
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
	 * @return cacoUsdAmt
	 */
	public String getCacoUsdAmt() {
		return this.cacoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sInvCfmToDt
	 */
	public String getSInvCfmToDt() {
		return this.sInvCfmToDt;
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
	 * @return pocaUsdAmt
	 */
	public String getPocaUsdAmt() {
		return this.pocaUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return sBeforeStsCd
	 */
	public String getSBeforeStsCd() {
		return this.sBeforeStsCd;
	}
	
	/**
	 * Column Info
	 * @return sExpnAudRsltCd
	 */
	public String getSExpnAudRsltCd() {
		return this.sExpnAudRsltCd;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return pocoCnt
	 */
	public String getPocoCnt() {
		return this.pocoCnt;
	}
	
	/**
	 * Column Info
	 * @return cocoCnt
	 */
	public String getCocoCnt() {
		return this.cocoCnt;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sMdlCd
	 */
	public String getSMdlCd() {
		return this.sMdlCd;
	}
	
	/**
	 * Column Info
	 * @return totCnt
	 */
	public String getTotCnt() {
		return this.totCnt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return sEacIfFlg
	 */
	public String getSEacIfFlg() {
		return this.sEacIfFlg;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return copoCnt
	 */
	public String getCopoCnt() {
		return this.copoCnt;
	}
	
	/**
	 * Column Info
	 * @return popoUsdAmt
	 */
	public String getPopoUsdAmt() {
		return this.popoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return pocoUsdAmt
	 */
	public String getPocoUsdAmt() {
		return this.pocoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cacoCnt
	 */
	public String getCacoCnt() {
		return this.cacoCnt;
	}
	
	/**
	 * Column Info
	 * @return mdlCd
	 */
	public String getMdlCd() {
		return this.mdlCd;
	}
	
	/**
	 * Column Info
	 * @return rhqOrd
	 */
	public String getRhqOrd() {
		return this.rhqOrd;
	}
	
	/**
	 * Column Info
	 * @return sMoreThanAmt
	 */
	public String getSMoreThanAmt() {
		return this.sMoreThanAmt;
	}
	
	/**
	 * Column Info
	 * @return cacaCnt
	 */
	public String getCacaCnt() {
		return this.cacaCnt;
	}
	
	/**
	 * Column Info
	 * @return sAfterStsCd
	 */
	public String getSAfterStsCd() {
		return this.sAfterStsCd;
	}
	
	/**
	 * Column Info
	 * @return popoCnt
	 */
	public String getPopoCnt() {
		return this.popoCnt;
	}
	
	/**
	 * Column Info
	 * @return cacaUsdAmt
	 */
	public String getCacaUsdAmt() {
		return this.cacaUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return capoUsdAmt
	 */
	public String getCapoUsdAmt() {
		return this.capoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return copoUsdAmt
	 */
	public String getCopoUsdAmt() {
		return this.copoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return mdlOrd
	 */
	public String getMdlOrd() {
		return this.mdlOrd;
	}
	

	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param capoCnt
	 */
	public void setCapoCnt(String capoCnt) {
		this.capoCnt = capoCnt;
	}
	
	/**
	 * Column Info
	 * @param cocoUsdAmt
	 */
	public void setCocoUsdAmt(String cocoUsdAmt) {
		this.cocoUsdAmt = cocoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param totUsdAmt
	 */
	public void setTotUsdAmt(String totUsdAmt) {
		this.totUsdAmt = totUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sInvCfmFmDt
	 */
	public void setSInvCfmFmDt(String sInvCfmFmDt) {
		this.sInvCfmFmDt = sInvCfmFmDt;
	}
	
	/**
	 * Column Info
	 * @param cocaUsdAmt
	 */
	public void setCocaUsdAmt(String cocaUsdAmt) {
		this.cocaUsdAmt = cocaUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param expnAudRsltCd
	 */
	public void setExpnAudRsltCd(String expnAudRsltCd) {
		this.expnAudRsltCd = expnAudRsltCd;
	}
	
	/**
	 * Column Info
	 * @param pocaCnt
	 */
	public void setPocaCnt(String pocaCnt) {
		this.pocaCnt = pocaCnt;
	}
	
	/**
	 * Column Info
	 * @param cocaCnt
	 */
	public void setCocaCnt(String cocaCnt) {
		this.cocaCnt = cocaCnt;
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
	 * @param cacoUsdAmt
	 */
	public void setCacoUsdAmt(String cacoUsdAmt) {
		this.cacoUsdAmt = cacoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sInvCfmToDt
	 */
	public void setSInvCfmToDt(String sInvCfmToDt) {
		this.sInvCfmToDt = sInvCfmToDt;
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
	 * @param pocaUsdAmt
	 */
	public void setPocaUsdAmt(String pocaUsdAmt) {
		this.pocaUsdAmt = pocaUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param sBeforeStsCd
	 */
	public void setSBeforeStsCd(String sBeforeStsCd) {
		this.sBeforeStsCd = sBeforeStsCd;
	}
	
	/**
	 * Column Info
	 * @param sExpnAudRsltCd
	 */
	public void setSExpnAudRsltCd(String sExpnAudRsltCd) {
		this.sExpnAudRsltCd = sExpnAudRsltCd;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param pocoCnt
	 */
	public void setPocoCnt(String pocoCnt) {
		this.pocoCnt = pocoCnt;
	}
	
	/**
	 * Column Info
	 * @param cocoCnt
	 */
	public void setCocoCnt(String cocoCnt) {
		this.cocoCnt = cocoCnt;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sMdlCd
	 */
	public void setSMdlCd(String sMdlCd) {
		this.sMdlCd = sMdlCd;
	}
	
	/**
	 * Column Info
	 * @param totCnt
	 */
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param sEacIfFlg
	 */
	public void setSEacIfFlg(String sEacIfFlg) {
		this.sEacIfFlg = sEacIfFlg;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param copoCnt
	 */
	public void setCopoCnt(String copoCnt) {
		this.copoCnt = copoCnt;
	}
	
	/**
	 * Column Info
	 * @param popoUsdAmt
	 */
	public void setPopoUsdAmt(String popoUsdAmt) {
		this.popoUsdAmt = popoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param pocoUsdAmt
	 */
	public void setPocoUsdAmt(String pocoUsdAmt) {
		this.pocoUsdAmt = pocoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cacoCnt
	 */
	public void setCacoCnt(String cacoCnt) {
		this.cacoCnt = cacoCnt;
	}
	
	/**
	 * Column Info
	 * @param mdlCd
	 */
	public void setMdlCd(String mdlCd) {
		this.mdlCd = mdlCd;
	}
	
	/**
	 * Column Info
	 * @param rhqOrd
	 */
	public void setRhqOrd(String rhqOrd) {
		this.rhqOrd = rhqOrd;
	}
	
	/**
	 * Column Info
	 * @param sMoreThanAmt
	 */
	public void setSMoreThanAmt(String sMoreThanAmt) {
		this.sMoreThanAmt = sMoreThanAmt;
	}
	
	/**
	 * Column Info
	 * @param cacaCnt
	 */
	public void setCacaCnt(String cacaCnt) {
		this.cacaCnt = cacaCnt;
	}
	
	/**
	 * Column Info
	 * @param sAfterStsCd
	 */
	public void setSAfterStsCd(String sAfterStsCd) {
		this.sAfterStsCd = sAfterStsCd;
	}
	
	/**
	 * Column Info
	 * @param popoCnt
	 */
	public void setPopoCnt(String popoCnt) {
		this.popoCnt = popoCnt;
	}
	
	/**
	 * Column Info
	 * @param cacaUsdAmt
	 */
	public void setCacaUsdAmt(String cacaUsdAmt) {
		this.cacaUsdAmt = cacaUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param capoUsdAmt
	 */
	public void setCapoUsdAmt(String capoUsdAmt) {
		this.capoUsdAmt = capoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param copoUsdAmt
	 */
	public void setCopoUsdAmt(String copoUsdAmt) {
		this.copoUsdAmt = copoUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param mdlOrd
	 */
	public void setMdlOrd(String mdlOrd) {
		this.mdlOrd = mdlOrd;
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
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setCapoCnt(JSPUtil.getParameter(request, prefix + "capo_cnt", ""));
		setCocoUsdAmt(JSPUtil.getParameter(request, prefix + "coco_usd_amt", ""));
		setTotUsdAmt(JSPUtil.getParameter(request, prefix + "tot_usd_amt", ""));
		setSInvCfmFmDt(JSPUtil.getParameter(request, prefix + "s_inv_cfm_fm_dt", ""));
		setCocaUsdAmt(JSPUtil.getParameter(request, prefix + "coca_usd_amt", ""));
		setExpnAudRsltCd(JSPUtil.getParameter(request, prefix + "expn_aud_rslt_cd", ""));
		setPocaCnt(JSPUtil.getParameter(request, prefix + "poca_cnt", ""));
		setCocaCnt(JSPUtil.getParameter(request, prefix + "coca_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCacoUsdAmt(JSPUtil.getParameter(request, prefix + "caco_usd_amt", ""));
		setSInvCfmToDt(JSPUtil.getParameter(request, prefix + "s_inv_cfm_to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPocaUsdAmt(JSPUtil.getParameter(request, prefix + "poca_usd_amt", ""));
		setSBeforeStsCd(JSPUtil.getParameter(request, prefix + "s_before_sts_cd", ""));
		setSExpnAudRsltCd(JSPUtil.getParameter(request, prefix + "s_expn_aud_rslt_cd", ""));
		setTpCd(JSPUtil.getParameter(request, prefix + "tp_cd", ""));
		setPocoCnt(JSPUtil.getParameter(request, prefix + "poco_cnt", ""));
		setCocoCnt(JSPUtil.getParameter(request, prefix + "coco_cnt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setSMdlCd(JSPUtil.getParameter(request, prefix + "s_mdl_cd", ""));
		setTotCnt(JSPUtil.getParameter(request, prefix + "tot_cnt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSEacIfFlg(JSPUtil.getParameter(request, prefix + "s_eac_if_flg", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setCopoCnt(JSPUtil.getParameter(request, prefix + "copo_cnt", ""));
		setPopoUsdAmt(JSPUtil.getParameter(request, prefix + "popo_usd_amt", ""));
		setPocoUsdAmt(JSPUtil.getParameter(request, prefix + "poco_usd_amt", ""));
		setCacoCnt(JSPUtil.getParameter(request, prefix + "caco_cnt", ""));
		setMdlCd(JSPUtil.getParameter(request, prefix + "mdl_cd", ""));
		setRhqOrd(JSPUtil.getParameter(request, prefix + "rhq_ord", ""));
		setSMoreThanAmt(JSPUtil.getParameter(request, prefix + "s_more_than_amt", ""));
		setCacaCnt(JSPUtil.getParameter(request, prefix + "caca_cnt", ""));
		setSAfterStsCd(JSPUtil.getParameter(request, prefix + "s_after_sts_cd", ""));
		setPopoCnt(JSPUtil.getParameter(request, prefix + "popo_cnt", ""));
		setCacaUsdAmt(JSPUtil.getParameter(request, prefix + "caca_usd_amt", ""));
		setCapoUsdAmt(JSPUtil.getParameter(request, prefix + "capo_usd_amt", ""));
		setCopoUsdAmt(JSPUtil.getParameter(request, prefix + "copo_usd_amt", ""));
		setMdlOrd(JSPUtil.getParameter(request, prefix + "mdl_ord", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAutoAuditChangeHistoryVO[]
	 */
	public SearchAutoAuditChangeHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAutoAuditChangeHistoryVO[]
	 */
	public SearchAutoAuditChangeHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAutoAuditChangeHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] capoCnt = (JSPUtil.getParameter(request, prefix	+ "capo_cnt", length));
			String[] cocoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "coco_usd_amt", length));
			String[] totUsdAmt = (JSPUtil.getParameter(request, prefix	+ "tot_usd_amt", length));
			String[] sInvCfmFmDt = (JSPUtil.getParameter(request, prefix	+ "s_inv_cfm_fm_dt", length));
			String[] cocaUsdAmt = (JSPUtil.getParameter(request, prefix	+ "coca_usd_amt", length));
			String[] expnAudRsltCd = (JSPUtil.getParameter(request, prefix	+ "expn_aud_rslt_cd", length));
			String[] pocaCnt = (JSPUtil.getParameter(request, prefix	+ "poca_cnt", length));
			String[] cocaCnt = (JSPUtil.getParameter(request, prefix	+ "coca_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cacoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "caco_usd_amt", length));
			String[] sInvCfmToDt = (JSPUtil.getParameter(request, prefix	+ "s_inv_cfm_to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pocaUsdAmt = (JSPUtil.getParameter(request, prefix	+ "poca_usd_amt", length));
			String[] sBeforeStsCd = (JSPUtil.getParameter(request, prefix	+ "s_before_sts_cd", length));
			String[] sExpnAudRsltCd = (JSPUtil.getParameter(request, prefix	+ "s_expn_aud_rslt_cd", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] pocoCnt = (JSPUtil.getParameter(request, prefix	+ "poco_cnt", length));
			String[] cocoCnt = (JSPUtil.getParameter(request, prefix	+ "coco_cnt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] sMdlCd = (JSPUtil.getParameter(request, prefix	+ "s_mdl_cd", length));
			String[] totCnt = (JSPUtil.getParameter(request, prefix	+ "tot_cnt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] sEacIfFlg = (JSPUtil.getParameter(request, prefix	+ "s_eac_if_flg", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] copoCnt = (JSPUtil.getParameter(request, prefix	+ "copo_cnt", length));
			String[] popoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "popo_usd_amt", length));
			String[] pocoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "poco_usd_amt", length));
			String[] cacoCnt = (JSPUtil.getParameter(request, prefix	+ "caco_cnt", length));
			String[] mdlCd = (JSPUtil.getParameter(request, prefix	+ "mdl_cd", length));
			String[] rhqOrd = (JSPUtil.getParameter(request, prefix	+ "rhq_ord", length));
			String[] sMoreThanAmt = (JSPUtil.getParameter(request, prefix	+ "s_more_than_amt", length));
			String[] cacaCnt = (JSPUtil.getParameter(request, prefix	+ "caca_cnt", length));
			String[] sAfterStsCd = (JSPUtil.getParameter(request, prefix	+ "s_after_sts_cd", length));
			String[] popoCnt = (JSPUtil.getParameter(request, prefix	+ "popo_cnt", length));
			String[] cacaUsdAmt = (JSPUtil.getParameter(request, prefix	+ "caca_usd_amt", length));
			String[] capoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "capo_usd_amt", length));
			String[] copoUsdAmt = (JSPUtil.getParameter(request, prefix	+ "copo_usd_amt", length));
			String[] mdlOrd = (JSPUtil.getParameter(request, prefix	+ "mdl_ord", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAutoAuditChangeHistoryVO();
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (capoCnt[i] != null)
					model.setCapoCnt(capoCnt[i]);
				if (cocoUsdAmt[i] != null)
					model.setCocoUsdAmt(cocoUsdAmt[i]);
				if (totUsdAmt[i] != null)
					model.setTotUsdAmt(totUsdAmt[i]);
				if (sInvCfmFmDt[i] != null)
					model.setSInvCfmFmDt(sInvCfmFmDt[i]);
				if (cocaUsdAmt[i] != null)
					model.setCocaUsdAmt(cocaUsdAmt[i]);
				if (expnAudRsltCd[i] != null)
					model.setExpnAudRsltCd(expnAudRsltCd[i]);
				if (pocaCnt[i] != null)
					model.setPocaCnt(pocaCnt[i]);
				if (cocaCnt[i] != null)
					model.setCocaCnt(cocaCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cacoUsdAmt[i] != null)
					model.setCacoUsdAmt(cacoUsdAmt[i]);
				if (sInvCfmToDt[i] != null)
					model.setSInvCfmToDt(sInvCfmToDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pocaUsdAmt[i] != null)
					model.setPocaUsdAmt(pocaUsdAmt[i]);
				if (sBeforeStsCd[i] != null)
					model.setSBeforeStsCd(sBeforeStsCd[i]);
				if (sExpnAudRsltCd[i] != null)
					model.setSExpnAudRsltCd(sExpnAudRsltCd[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (pocoCnt[i] != null)
					model.setPocoCnt(pocoCnt[i]);
				if (cocoCnt[i] != null)
					model.setCocoCnt(cocoCnt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (sMdlCd[i] != null)
					model.setSMdlCd(sMdlCd[i]);
				if (totCnt[i] != null)
					model.setTotCnt(totCnt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (sEacIfFlg[i] != null)
					model.setSEacIfFlg(sEacIfFlg[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (copoCnt[i] != null)
					model.setCopoCnt(copoCnt[i]);
				if (popoUsdAmt[i] != null)
					model.setPopoUsdAmt(popoUsdAmt[i]);
				if (pocoUsdAmt[i] != null)
					model.setPocoUsdAmt(pocoUsdAmt[i]);
				if (cacoCnt[i] != null)
					model.setCacoCnt(cacoCnt[i]);
				if (mdlCd[i] != null)
					model.setMdlCd(mdlCd[i]);
				if (rhqOrd[i] != null)
					model.setRhqOrd(rhqOrd[i]);
				if (sMoreThanAmt[i] != null)
					model.setSMoreThanAmt(sMoreThanAmt[i]);
				if (cacaCnt[i] != null)
					model.setCacaCnt(cacaCnt[i]);
				if (sAfterStsCd[i] != null)
					model.setSAfterStsCd(sAfterStsCd[i]);
				if (popoCnt[i] != null)
					model.setPopoCnt(popoCnt[i]);
				if (cacaUsdAmt[i] != null)
					model.setCacaUsdAmt(cacaUsdAmt[i]);
				if (capoUsdAmt[i] != null)
					model.setCapoUsdAmt(capoUsdAmt[i]);
				if (copoUsdAmt[i] != null)
					model.setCopoUsdAmt(copoUsdAmt[i]);
				if (mdlOrd[i] != null)
					model.setMdlOrd(mdlOrd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAutoAuditChangeHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAutoAuditChangeHistoryVO[]
	 */
	public SearchAutoAuditChangeHistoryVO[] getSearchAutoAuditChangeHistoryVOs(){
		SearchAutoAuditChangeHistoryVO[] vos = (SearchAutoAuditChangeHistoryVO[])models.toArray(new SearchAutoAuditChangeHistoryVO[models.size()]);
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
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capoCnt = this.capoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cocoUsdAmt = this.cocoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totUsdAmt = this.totUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvCfmFmDt = this.sInvCfmFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cocaUsdAmt = this.cocaUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudRsltCd = this.expnAudRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pocaCnt = this.pocaCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cocaCnt = this.cocaCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cacoUsdAmt = this.cacoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvCfmToDt = this.sInvCfmToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pocaUsdAmt = this.pocaUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBeforeStsCd = this.sBeforeStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpnAudRsltCd = this.sExpnAudRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pocoCnt = this.pocoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cocoCnt = this.cocoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMdlCd = this.sMdlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totCnt = this.totCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIfFlg = this.sEacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copoCnt = this.copoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popoUsdAmt = this.popoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pocoUsdAmt = this.pocoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cacoCnt = this.cacoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlCd = this.mdlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOrd = this.rhqOrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMoreThanAmt = this.sMoreThanAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cacaCnt = this.cacaCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAfterStsCd = this.sAfterStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popoCnt = this.popoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cacaUsdAmt = this.cacaUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capoUsdAmt = this.capoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copoUsdAmt = this.copoUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlOrd = this.mdlOrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
