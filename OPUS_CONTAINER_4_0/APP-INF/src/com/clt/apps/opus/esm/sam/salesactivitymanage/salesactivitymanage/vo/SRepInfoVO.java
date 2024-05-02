/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SRepInfoVO.java
*@FileTitle : SRepInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.06.16 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo;

import java.lang.reflect.Field;
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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SRepInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SRepInfoVO> models = new ArrayList<SRepInfoVO>();
	
	/* Column Info */
	private String boc = null;
	/* Column Info */
	private String relRsn = null;
	/* Column Info */
	private String cun = null;
	/* Column Info */
	private String scr = null;
	/* Column Info */
	private String cunRsn = null;
	/* Column Info */
	private String slsPrmtDesc = null;
	/* Column Info */
	private String rsn = null;
	/* Column Info */
	private String wsiRsn = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nxtPlnClssCd = null;
	/* Column Info */
	private String whShBImp = null;
	/* Column Info */
	private String sgsDesc = null;
	/* Column Info */
	private String clh = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String userName = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String sepRsn = null;
	/* Column Info */
	private String eqsRsn = null;
	/* Column Info */
	private String custSatsfcItmCd = null;
	/* Column Info */
	private String prbClssCd = null;
	/* Column Info */
	private String stfcRsn = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String prbDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String atsRsn = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cahRsn = null;
	/* Column Info */
	private String stfcRepComp = null;
	/* Column Info */
	private String vstPlcCtnt = null;
	/* Column Info */
	private String curRsn = null;
	/* Column Info */
	private String custRecom = null;
	/* Column Info */
	private String ses = null;
	/* Column Info */
	private String dobRsn = null;
	/* Column Info */
	private String usf = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String slsActActDt = null;
	/* Column Info */
	private String clhRsn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scrRsn = null;
	/* Column Info */
	private String qur = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String eqs = null;
	/* Column Info */
	private String wsi = null;
	/* Column Info */
	private String src = null;
	/* Column Info */
	private String sgsClssCd = null;
	/* Column Info */
	private String qurRsn = null;
	/* Column Info */
	private String cah = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bizAreaCd = null;
	/* Column Info */
	private String slsRptClssCd = null;
	/* Column Info */
	private String sesRsn = null;
	/* Column Info */
	private String ats = null;
	/* Column Info */
	private String usfRsn = null;
	/* Column Info */
	private String nxtPlnDesc = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String grd = null;
	/* Column Info */
	private String slsRptSmryDesc = null;
	/* Column Info */
	private String dob = null;
	/* Column Info */
	private String cur = null;
	/* Column Info */
	private String sep = null;
	/* Column Info */
	private String srcRsn = null;
	/* Column Info */
	private String slsActSeq = null;
	/* Column Info */
	private String rel = null;
	/* Column Info */
	private String freeRptCtnt = null;
	/* Column Info */
	private String bocRsn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SRepInfoVO() {}

	public SRepInfoVO(String ibflag, String pagerows, String custCd, String custCntCd, String custSeq, String custLglEngNm, String slsActSeq, String slsActActDt, String srepCd, String srepNm, String cntcPsonNm, String slsRptClssCd, String slsRptSmryDesc, String prbClssCd, String prbDesc, String sgsClssCd, String sgsDesc, String nxtPlnClssCd, String nxtPlnDesc, String vstPlcCtnt, String slsPrmtDesc, String bizAreaCd, String creUsrId, String creDt, String updUsrId, String updDt, String userId, String userName, String freeRptCtnt, String ats, String boc, String cah, String clh, String cun, String dob, String eqs, String qur, String rel, String scr, String sep, String ses, String usf, String sesRsn, String scrRsn, String eqsRsn, String cahRsn, String sepRsn, String relRsn, String usfRsn, String bocRsn, String dobRsn, String atsRsn, String clhRsn, String qurRsn, String cunRsn, String whShBImp, String custRecom, String stfcRepComp, String stfcRsn, String wsiRsn, String curRsn, String srcRsn, String wsi, String cur, String src, String grd, String rsn, String custSatsfcItmCd) {
		this.boc = boc;
		this.relRsn = relRsn;
		this.cun = cun;
		this.scr = scr;
		this.cunRsn = cunRsn;
		this.slsPrmtDesc = slsPrmtDesc;
		this.rsn = rsn;
		this.wsiRsn = wsiRsn;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.nxtPlnClssCd = nxtPlnClssCd;
		this.whShBImp = whShBImp;
		this.sgsDesc = sgsDesc;
		this.clh = clh;
		this.userId = userId;
		this.userName = userName;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.sepRsn = sepRsn;
		this.eqsRsn = eqsRsn;
		this.custSatsfcItmCd = custSatsfcItmCd;
		this.prbClssCd = prbClssCd;
		this.stfcRsn = stfcRsn;
		this.custLglEngNm = custLglEngNm;
		this.prbDesc = prbDesc;
		this.creUsrId = creUsrId;
		this.atsRsn = atsRsn;
		this.custCd = custCd;
		this.cahRsn = cahRsn;
		this.stfcRepComp = stfcRepComp;
		this.vstPlcCtnt = vstPlcCtnt;
		this.curRsn = curRsn;
		this.custRecom = custRecom;
		this.ses = ses;
		this.dobRsn = dobRsn;
		this.usf = usf;
		this.creDt = creDt;
		this.slsActActDt = slsActActDt;
		this.clhRsn = clhRsn;
		this.ibflag = ibflag;
		this.scrRsn = scrRsn;
		this.qur = qur;
		this.srepNm = srepNm;
		this.cntcPsonNm = cntcPsonNm;
		this.eqs = eqs;
		this.wsi = wsi;
		this.src = src;
		this.sgsClssCd = sgsClssCd;
		this.qurRsn = qurRsn;
		this.cah = cah;
		this.updDt = updDt;
		this.bizAreaCd = bizAreaCd;
		this.slsRptClssCd = slsRptClssCd;
		this.sesRsn = sesRsn;
		this.ats = ats;
		this.usfRsn = usfRsn;
		this.nxtPlnDesc = nxtPlnDesc;
		this.custSeq = custSeq;
		this.grd = grd;
		this.slsRptSmryDesc = slsRptSmryDesc;
		this.dob = dob;
		this.cur = cur;
		this.sep = sep;
		this.srcRsn = srcRsn;
		this.slsActSeq = slsActSeq;
		this.rel = rel;
		this.freeRptCtnt = freeRptCtnt;
		this.bocRsn = bocRsn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("boc", getBoc());
		this.hashColumns.put("rel_rsn", getRelRsn());
		this.hashColumns.put("cun", getCun());
		this.hashColumns.put("scr", getScr());
		this.hashColumns.put("cun_rsn", getCunRsn());
		this.hashColumns.put("sls_prmt_desc", getSlsPrmtDesc());
		this.hashColumns.put("rsn", getRsn());
		this.hashColumns.put("wsi_rsn", getWsiRsn());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("nxt_pln_clss_cd", getNxtPlnClssCd());
		this.hashColumns.put("wh_sh_b_imp", getWhShBImp());
		this.hashColumns.put("sgs_desc", getSgsDesc());
		this.hashColumns.put("clh", getClh());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("user_name", getUserName());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("sep_rsn", getSepRsn());
		this.hashColumns.put("eqs_rsn", getEqsRsn());
		this.hashColumns.put("cust_satsfc_itm_cd", getCustSatsfcItmCd());
		this.hashColumns.put("prb_clss_cd", getPrbClssCd());
		this.hashColumns.put("stfc_rsn", getStfcRsn());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("prb_desc", getPrbDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ats_rsn", getAtsRsn());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cah_rsn", getCahRsn());
		this.hashColumns.put("stfc_rep_comp", getStfcRepComp());
		this.hashColumns.put("vst_plc_ctnt", getVstPlcCtnt());
		this.hashColumns.put("cur_rsn", getCurRsn());
		this.hashColumns.put("cust_recom", getCustRecom());
		this.hashColumns.put("ses", getSes());
		this.hashColumns.put("dob_rsn", getDobRsn());
		this.hashColumns.put("usf", getUsf());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sls_act_act_dt", getSlsActActDt());
		this.hashColumns.put("clh_rsn", getClhRsn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scr_rsn", getScrRsn());
		this.hashColumns.put("qur", getQur());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("eqs", getEqs());
		this.hashColumns.put("wsi", getWsi());
		this.hashColumns.put("src", getSrc());
		this.hashColumns.put("sgs_clss_cd", getSgsClssCd());
		this.hashColumns.put("qur_rsn", getQurRsn());
		this.hashColumns.put("cah", getCah());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("biz_area_cd", getBizAreaCd());
		this.hashColumns.put("sls_rpt_clss_cd", getSlsRptClssCd());
		this.hashColumns.put("ses_rsn", getSesRsn());
		this.hashColumns.put("ats", getAts());
		this.hashColumns.put("usf_rsn", getUsfRsn());
		this.hashColumns.put("nxt_pln_desc", getNxtPlnDesc());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("grd", getGrd());
		this.hashColumns.put("sls_rpt_smry_desc", getSlsRptSmryDesc());
		this.hashColumns.put("dob", getDob());
		this.hashColumns.put("cur", getCur());
		this.hashColumns.put("sep", getSep());
		this.hashColumns.put("src_rsn", getSrcRsn());
		this.hashColumns.put("sls_act_seq", getSlsActSeq());
		this.hashColumns.put("rel", getRel());
		this.hashColumns.put("free_rpt_ctnt", getFreeRptCtnt());
		this.hashColumns.put("boc_rsn", getBocRsn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("boc", "boc");
		this.hashFields.put("rel_rsn", "relRsn");
		this.hashFields.put("cun", "cun");
		this.hashFields.put("scr", "scr");
		this.hashFields.put("cun_rsn", "cunRsn");
		this.hashFields.put("sls_prmt_desc", "slsPrmtDesc");
		this.hashFields.put("rsn", "rsn");
		this.hashFields.put("wsi_rsn", "wsiRsn");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nxt_pln_clss_cd", "nxtPlnClssCd");
		this.hashFields.put("wh_sh_b_imp", "whShBImp");
		this.hashFields.put("sgs_desc", "sgsDesc");
		this.hashFields.put("clh", "clh");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("user_name", "userName");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("sep_rsn", "sepRsn");
		this.hashFields.put("eqs_rsn", "eqsRsn");
		this.hashFields.put("cust_satsfc_itm_cd", "custSatsfcItmCd");
		this.hashFields.put("prb_clss_cd", "prbClssCd");
		this.hashFields.put("stfc_rsn", "stfcRsn");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("prb_desc", "prbDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ats_rsn", "atsRsn");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cah_rsn", "cahRsn");
		this.hashFields.put("stfc_rep_comp", "stfcRepComp");
		this.hashFields.put("vst_plc_ctnt", "vstPlcCtnt");
		this.hashFields.put("cur_rsn", "curRsn");
		this.hashFields.put("cust_recom", "custRecom");
		this.hashFields.put("ses", "ses");
		this.hashFields.put("dob_rsn", "dobRsn");
		this.hashFields.put("usf", "usf");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sls_act_act_dt", "slsActActDt");
		this.hashFields.put("clh_rsn", "clhRsn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scr_rsn", "scrRsn");
		this.hashFields.put("qur", "qur");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("eqs", "eqs");
		this.hashFields.put("wsi", "wsi");
		this.hashFields.put("src", "src");
		this.hashFields.put("sgs_clss_cd", "sgsClssCd");
		this.hashFields.put("qur_rsn", "qurRsn");
		this.hashFields.put("cah", "cah");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("biz_area_cd", "bizAreaCd");
		this.hashFields.put("sls_rpt_clss_cd", "slsRptClssCd");
		this.hashFields.put("ses_rsn", "sesRsn");
		this.hashFields.put("ats", "ats");
		this.hashFields.put("usf_rsn", "usfRsn");
		this.hashFields.put("nxt_pln_desc", "nxtPlnDesc");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("grd", "grd");
		this.hashFields.put("sls_rpt_smry_desc", "slsRptSmryDesc");
		this.hashFields.put("dob", "dob");
		this.hashFields.put("cur", "cur");
		this.hashFields.put("sep", "sep");
		this.hashFields.put("src_rsn", "srcRsn");
		this.hashFields.put("sls_act_seq", "slsActSeq");
		this.hashFields.put("rel", "rel");
		this.hashFields.put("free_rpt_ctnt", "freeRptCtnt");
		this.hashFields.put("boc_rsn", "bocRsn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return boc
	 */
	public String getBoc() {
		return this.boc;
	}
	
	/**
	 * Column Info
	 * @return relRsn
	 */
	public String getRelRsn() {
		return this.relRsn;
	}
	
	/**
	 * Column Info
	 * @return cun
	 */
	public String getCun() {
		return this.cun;
	}
	
	/**
	 * Column Info
	 * @return scr
	 */
	public String getScr() {
		return this.scr;
	}
	
	/**
	 * Column Info
	 * @return cunRsn
	 */
	public String getCunRsn() {
		return this.cunRsn;
	}
	
	/**
	 * Column Info
	 * @return slsPrmtDesc
	 */
	public String getSlsPrmtDesc() {
		return this.slsPrmtDesc;
	}
	
	/**
	 * Column Info
	 * @return rsn
	 */
	public String getRsn() {
		return this.rsn;
	}
	
	/**
	 * Column Info
	 * @return wsiRsn
	 */
	public String getWsiRsn() {
		return this.wsiRsn;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return nxtPlnClssCd
	 */
	public String getNxtPlnClssCd() {
		return this.nxtPlnClssCd;
	}
	
	/**
	 * Column Info
	 * @return whShBImp
	 */
	public String getWhShBImp() {
		return this.whShBImp;
	}
	
	/**
	 * Column Info
	 * @return sgsDesc
	 */
	public String getSgsDesc() {
		return this.sgsDesc;
	}
	
	/**
	 * Column Info
	 * @return clh
	 */
	public String getClh() {
		return this.clh;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return userName
	 */
	public String getUserName() {
		return this.userName;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return sepRsn
	 */
	public String getSepRsn() {
		return this.sepRsn;
	}
	
	/**
	 * Column Info
	 * @return eqsRsn
	 */
	public String getEqsRsn() {
		return this.eqsRsn;
	}
	
	/**
	 * Column Info
	 * @return custSatsfcItmCd
	 */
	public String getCustSatsfcItmCd() {
		return this.custSatsfcItmCd;
	}
	
	/**
	 * Column Info
	 * @return prbClssCd
	 */
	public String getPrbClssCd() {
		return this.prbClssCd;
	}
	
	/**
	 * Column Info
	 * @return stfcRsn
	 */
	public String getStfcRsn() {
		return this.stfcRsn;
	}
	
	/**
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return prbDesc
	 */
	public String getPrbDesc() {
		return this.prbDesc;
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
	 * @return atsRsn
	 */
	public String getAtsRsn() {
		return this.atsRsn;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return cahRsn
	 */
	public String getCahRsn() {
		return this.cahRsn;
	}
	
	/**
	 * Column Info
	 * @return stfcRepComp
	 */
	public String getStfcRepComp() {
		return this.stfcRepComp;
	}
	
	/**
	 * Column Info
	 * @return vstPlcCtnt
	 */
	public String getVstPlcCtnt() {
		return this.vstPlcCtnt;
	}
	
	/**
	 * Column Info
	 * @return curRsn
	 */
	public String getCurRsn() {
		return this.curRsn;
	}
	
	/**
	 * Column Info
	 * @return custRecom
	 */
	public String getCustRecom() {
		return this.custRecom;
	}
	
	/**
	 * Column Info
	 * @return ses
	 */
	public String getSes() {
		return this.ses;
	}
	
	/**
	 * Column Info
	 * @return dobRsn
	 */
	public String getDobRsn() {
		return this.dobRsn;
	}
	
	/**
	 * Column Info
	 * @return usf
	 */
	public String getUsf() {
		return this.usf;
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
	 * @return slsActActDt
	 */
	public String getSlsActActDt() {
		return this.slsActActDt;
	}
	
	/**
	 * Column Info
	 * @return clhRsn
	 */
	public String getClhRsn() {
		return this.clhRsn;
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
	 * @return scrRsn
	 */
	public String getScrRsn() {
		return this.scrRsn;
	}
	
	/**
	 * Column Info
	 * @return qur
	 */
	public String getQur() {
		return this.qur;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return eqs
	 */
	public String getEqs() {
		return this.eqs;
	}
	
	/**
	 * Column Info
	 * @return wsi
	 */
	public String getWsi() {
		return this.wsi;
	}
	
	/**
	 * Column Info
	 * @return src
	 */
	public String getSrc() {
		return this.src;
	}
	
	/**
	 * Column Info
	 * @return sgsClssCd
	 */
	public String getSgsClssCd() {
		return this.sgsClssCd;
	}
	
	/**
	 * Column Info
	 * @return qurRsn
	 */
	public String getQurRsn() {
		return this.qurRsn;
	}
	
	/**
	 * Column Info
	 * @return cah
	 */
	public String getCah() {
		return this.cah;
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
	 * @return bizAreaCd
	 */
	public String getBizAreaCd() {
		return this.bizAreaCd;
	}
	
	/**
	 * Column Info
	 * @return slsRptClssCd
	 */
	public String getSlsRptClssCd() {
		return this.slsRptClssCd;
	}
	
	/**
	 * Column Info
	 * @return sesRsn
	 */
	public String getSesRsn() {
		return this.sesRsn;
	}
	
	/**
	 * Column Info
	 * @return ats
	 */
	public String getAts() {
		return this.ats;
	}
	
	/**
	 * Column Info
	 * @return usfRsn
	 */
	public String getUsfRsn() {
		return this.usfRsn;
	}
	
	/**
	 * Column Info
	 * @return nxtPlnDesc
	 */
	public String getNxtPlnDesc() {
		return this.nxtPlnDesc;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return grd
	 */
	public String getGrd() {
		return this.grd;
	}
	
	/**
	 * Column Info
	 * @return slsRptSmryDesc
	 */
	public String getSlsRptSmryDesc() {
		return this.slsRptSmryDesc;
	}
	
	/**
	 * Column Info
	 * @return dob
	 */
	public String getDob() {
		return this.dob;
	}
	
	/**
	 * Column Info
	 * @return cur
	 */
	public String getCur() {
		return this.cur;
	}
	
	/**
	 * Column Info
	 * @return sep
	 */
	public String getSep() {
		return this.sep;
	}
	
	/**
	 * Column Info
	 * @return srcRsn
	 */
	public String getSrcRsn() {
		return this.srcRsn;
	}
	
	/**
	 * Column Info
	 * @return slsActSeq
	 */
	public String getSlsActSeq() {
		return this.slsActSeq;
	}
	
	/**
	 * Column Info
	 * @return rel
	 */
	public String getRel() {
		return this.rel;
	}
	
	/**
	 * Column Info
	 * @return freeRptCtnt
	 */
	public String getFreeRptCtnt() {
		return this.freeRptCtnt;
	}
	
	/**
	 * Column Info
	 * @return bocRsn
	 */
	public String getBocRsn() {
		return this.bocRsn;
	}
	

	/**
	 * Column Info
	 * @param boc
	 */
	public void setBoc(String boc) {
		this.boc = boc;
	}
	
	/**
	 * Column Info
	 * @param relRsn
	 */
	public void setRelRsn(String relRsn) {
		this.relRsn = relRsn;
	}
	
	/**
	 * Column Info
	 * @param cun
	 */
	public void setCun(String cun) {
		this.cun = cun;
	}
	
	/**
	 * Column Info
	 * @param scr
	 */
	public void setScr(String scr) {
		this.scr = scr;
	}
	
	/**
	 * Column Info
	 * @param cunRsn
	 */
	public void setCunRsn(String cunRsn) {
		this.cunRsn = cunRsn;
	}
	
	/**
	 * Column Info
	 * @param slsPrmtDesc
	 */
	public void setSlsPrmtDesc(String slsPrmtDesc) {
		this.slsPrmtDesc = slsPrmtDesc;
	}
	
	/**
	 * Column Info
	 * @param rsn
	 */
	public void setRsn(String rsn) {
		this.rsn = rsn;
	}
	
	/**
	 * Column Info
	 * @param wsiRsn
	 */
	public void setWsiRsn(String wsiRsn) {
		this.wsiRsn = wsiRsn;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param nxtPlnClssCd
	 */
	public void setNxtPlnClssCd(String nxtPlnClssCd) {
		this.nxtPlnClssCd = nxtPlnClssCd;
	}
	
	/**
	 * Column Info
	 * @param whShBImp
	 */
	public void setWhShBImp(String whShBImp) {
		this.whShBImp = whShBImp;
	}
	
	/**
	 * Column Info
	 * @param sgsDesc
	 */
	public void setSgsDesc(String sgsDesc) {
		this.sgsDesc = sgsDesc;
	}
	
	/**
	 * Column Info
	 * @param clh
	 */
	public void setClh(String clh) {
		this.clh = clh;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param sepRsn
	 */
	public void setSepRsn(String sepRsn) {
		this.sepRsn = sepRsn;
	}
	
	/**
	 * Column Info
	 * @param eqsRsn
	 */
	public void setEqsRsn(String eqsRsn) {
		this.eqsRsn = eqsRsn;
	}
	
	/**
	 * Column Info
	 * @param custSatsfcItmCd
	 */
	public void setCustSatsfcItmCd(String custSatsfcItmCd) {
		this.custSatsfcItmCd = custSatsfcItmCd;
	}
	
	/**
	 * Column Info
	 * @param prbClssCd
	 */
	public void setPrbClssCd(String prbClssCd) {
		this.prbClssCd = prbClssCd;
	}
	
	/**
	 * Column Info
	 * @param stfcRsn
	 */
	public void setStfcRsn(String stfcRsn) {
		this.stfcRsn = stfcRsn;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param prbDesc
	 */
	public void setPrbDesc(String prbDesc) {
		this.prbDesc = prbDesc;
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
	 * @param atsRsn
	 */
	public void setAtsRsn(String atsRsn) {
		this.atsRsn = atsRsn;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param cahRsn
	 */
	public void setCahRsn(String cahRsn) {
		this.cahRsn = cahRsn;
	}
	
	/**
	 * Column Info
	 * @param stfcRepComp
	 */
	public void setStfcRepComp(String stfcRepComp) {
		this.stfcRepComp = stfcRepComp;
	}
	
	/**
	 * Column Info
	 * @param vstPlcCtnt
	 */
	public void setVstPlcCtnt(String vstPlcCtnt) {
		this.vstPlcCtnt = vstPlcCtnt;
	}
	
	/**
	 * Column Info
	 * @param curRsn
	 */
	public void setCurRsn(String curRsn) {
		this.curRsn = curRsn;
	}
	
	/**
	 * Column Info
	 * @param custRecom
	 */
	public void setCustRecom(String custRecom) {
		this.custRecom = custRecom;
	}
	
	/**
	 * Column Info
	 * @param ses
	 */
	public void setSes(String ses) {
		this.ses = ses;
	}
	
	/**
	 * Column Info
	 * @param dobRsn
	 */
	public void setDobRsn(String dobRsn) {
		this.dobRsn = dobRsn;
	}
	
	/**
	 * Column Info
	 * @param usf
	 */
	public void setUsf(String usf) {
		this.usf = usf;
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
	 * @param slsActActDt
	 */
	public void setSlsActActDt(String slsActActDt) {
		this.slsActActDt = slsActActDt;
	}
	
	/**
	 * Column Info
	 * @param clhRsn
	 */
	public void setClhRsn(String clhRsn) {
		this.clhRsn = clhRsn;
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
	 * @param scrRsn
	 */
	public void setScrRsn(String scrRsn) {
		this.scrRsn = scrRsn;
	}
	
	/**
	 * Column Info
	 * @param qur
	 */
	public void setQur(String qur) {
		this.qur = qur;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param eqs
	 */
	public void setEqs(String eqs) {
		this.eqs = eqs;
	}
	
	/**
	 * Column Info
	 * @param wsi
	 */
	public void setWsi(String wsi) {
		this.wsi = wsi;
	}
	
	/**
	 * Column Info
	 * @param src
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * Column Info
	 * @param sgsClssCd
	 */
	public void setSgsClssCd(String sgsClssCd) {
		this.sgsClssCd = sgsClssCd;
	}
	
	/**
	 * Column Info
	 * @param qurRsn
	 */
	public void setQurRsn(String qurRsn) {
		this.qurRsn = qurRsn;
	}
	
	/**
	 * Column Info
	 * @param cah
	 */
	public void setCah(String cah) {
		this.cah = cah;
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
	 * @param bizAreaCd
	 */
	public void setBizAreaCd(String bizAreaCd) {
		this.bizAreaCd = bizAreaCd;
	}
	
	/**
	 * Column Info
	 * @param slsRptClssCd
	 */
	public void setSlsRptClssCd(String slsRptClssCd) {
		this.slsRptClssCd = slsRptClssCd;
	}
	
	/**
	 * Column Info
	 * @param sesRsn
	 */
	public void setSesRsn(String sesRsn) {
		this.sesRsn = sesRsn;
	}
	
	/**
	 * Column Info
	 * @param ats
	 */
	public void setAts(String ats) {
		this.ats = ats;
	}
	
	/**
	 * Column Info
	 * @param usfRsn
	 */
	public void setUsfRsn(String usfRsn) {
		this.usfRsn = usfRsn;
	}
	
	/**
	 * Column Info
	 * @param nxtPlnDesc
	 */
	public void setNxtPlnDesc(String nxtPlnDesc) {
		this.nxtPlnDesc = nxtPlnDesc;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param grd
	 */
	public void setGrd(String grd) {
		this.grd = grd;
	}
	
	/**
	 * Column Info
	 * @param slsRptSmryDesc
	 */
	public void setSlsRptSmryDesc(String slsRptSmryDesc) {
		this.slsRptSmryDesc = slsRptSmryDesc;
	}
	
	/**
	 * Column Info
	 * @param dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * Column Info
	 * @param cur
	 */
	public void setCur(String cur) {
		this.cur = cur;
	}
	
	/**
	 * Column Info
	 * @param sep
	 */
	public void setSep(String sep) {
		this.sep = sep;
	}
	
	/**
	 * Column Info
	 * @param srcRsn
	 */
	public void setSrcRsn(String srcRsn) {
		this.srcRsn = srcRsn;
	}
	
	/**
	 * Column Info
	 * @param slsActSeq
	 */
	public void setSlsActSeq(String slsActSeq) {
		this.slsActSeq = slsActSeq;
	}
	
	/**
	 * Column Info
	 * @param rel
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	/**
	 * Column Info
	 * @param freeRptCtnt
	 */
	public void setFreeRptCtnt(String freeRptCtnt) {
		this.freeRptCtnt = freeRptCtnt;
	}
	
	/**
	 * Column Info
	 * @param bocRsn
	 */
	public void setBocRsn(String bocRsn) {
		this.bocRsn = bocRsn;
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
		setBoc(JSPUtil.getParameter(request, prefix + "boc", ""));
		setRelRsn(JSPUtil.getParameter(request, prefix + "rel_rsn", ""));
		setCun(JSPUtil.getParameter(request, prefix + "cun", ""));
		setScr(JSPUtil.getParameter(request, prefix + "scr", ""));
		setCunRsn(JSPUtil.getParameter(request, prefix + "cun_rsn", ""));
		setSlsPrmtDesc(JSPUtil.getParameter(request, prefix + "sls_prmt_desc", ""));
		setRsn(JSPUtil.getParameter(request, prefix + "rsn", ""));
		setWsiRsn(JSPUtil.getParameter(request, prefix + "wsi_rsn", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNxtPlnClssCd(JSPUtil.getParameter(request, prefix + "nxt_pln_clss_cd", ""));
		setWhShBImp(JSPUtil.getParameter(request, prefix + "wh_sh_b_imp", ""));
		setSgsDesc(JSPUtil.getParameter(request, prefix + "sgs_desc", ""));
		setClh(JSPUtil.getParameter(request, prefix + "clh", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setUserName(JSPUtil.getParameter(request, prefix + "user_name", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setSepRsn(JSPUtil.getParameter(request, prefix + "sep_rsn", ""));
		setEqsRsn(JSPUtil.getParameter(request, prefix + "eqs_rsn", ""));
		setCustSatsfcItmCd(JSPUtil.getParameter(request, prefix + "cust_satsfc_itm_cd", ""));
		setPrbClssCd(JSPUtil.getParameter(request, prefix + "prb_clss_cd", ""));
		setStfcRsn(JSPUtil.getParameter(request, prefix + "stfc_rsn", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setPrbDesc(JSPUtil.getParameter(request, prefix + "prb_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAtsRsn(JSPUtil.getParameter(request, prefix + "ats_rsn", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCahRsn(JSPUtil.getParameter(request, prefix + "cah_rsn", ""));
		setStfcRepComp(JSPUtil.getParameter(request, prefix + "stfc_rep_comp", ""));
		setVstPlcCtnt(JSPUtil.getParameter(request, prefix + "vst_plc_ctnt", ""));
		setCurRsn(JSPUtil.getParameter(request, prefix + "cur_rsn", ""));
		setCustRecom(JSPUtil.getParameter(request, prefix + "cust_recom", ""));
		setSes(JSPUtil.getParameter(request, prefix + "ses", ""));
		setDobRsn(JSPUtil.getParameter(request, prefix + "dob_rsn", ""));
		setUsf(JSPUtil.getParameter(request, prefix + "usf", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSlsActActDt(JSPUtil.getParameter(request, prefix + "sls_act_act_dt", ""));
		setClhRsn(JSPUtil.getParameter(request, prefix + "clh_rsn", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScrRsn(JSPUtil.getParameter(request, prefix + "scr_rsn", ""));
		setQur(JSPUtil.getParameter(request, prefix + "qur", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setEqs(JSPUtil.getParameter(request, prefix + "eqs", ""));
		setWsi(JSPUtil.getParameter(request, prefix + "wsi", ""));
		setSrc(JSPUtil.getParameter(request, prefix + "src", ""));
		setSgsClssCd(JSPUtil.getParameter(request, prefix + "sgs_clss_cd", ""));
		setQurRsn(JSPUtil.getParameter(request, prefix + "qur_rsn", ""));
		setCah(JSPUtil.getParameter(request, prefix + "cah", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setBizAreaCd(JSPUtil.getParameter(request, prefix + "biz_area_cd", ""));
		setSlsRptClssCd(JSPUtil.getParameter(request, prefix + "sls_rpt_clss_cd", ""));
		setSesRsn(JSPUtil.getParameter(request, prefix + "ses_rsn", ""));
		setAts(JSPUtil.getParameter(request, prefix + "ats", ""));
		setUsfRsn(JSPUtil.getParameter(request, prefix + "usf_rsn", ""));
		setNxtPlnDesc(JSPUtil.getParameter(request, prefix + "nxt_pln_desc", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setGrd(JSPUtil.getParameter(request, prefix + "grd", ""));
		setSlsRptSmryDesc(JSPUtil.getParameter(request, prefix + "sls_rpt_smry_desc", ""));
		setDob(JSPUtil.getParameter(request, prefix + "dob", ""));
		setCur(JSPUtil.getParameter(request, prefix + "cur", ""));
		setSep(JSPUtil.getParameter(request, prefix + "sep", ""));
		setSrcRsn(JSPUtil.getParameter(request, prefix + "src_rsn", ""));
		setSlsActSeq(JSPUtil.getParameter(request, prefix + "sls_act_seq", ""));
		setRel(JSPUtil.getParameter(request, prefix + "rel", ""));
		setFreeRptCtnt(JSPUtil.getParameter(request, prefix + "free_rpt_ctnt", ""));
		setBocRsn(JSPUtil.getParameter(request, prefix + "boc_rsn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SRepInfoVO[]
	 */
	public SRepInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SRepInfoVO[]
	 */
	public SRepInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SRepInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] boc = (JSPUtil.getParameter(request, prefix	+ "boc", length));
			String[] relRsn = (JSPUtil.getParameter(request, prefix	+ "rel_rsn", length));
			String[] cun = (JSPUtil.getParameter(request, prefix	+ "cun", length));
			String[] scr = (JSPUtil.getParameter(request, prefix	+ "scr", length));
			String[] cunRsn = (JSPUtil.getParameter(request, prefix	+ "cun_rsn", length));
			String[] slsPrmtDesc = (JSPUtil.getParameter(request, prefix	+ "sls_prmt_desc", length));
			String[] rsn = (JSPUtil.getParameter(request, prefix	+ "rsn", length));
			String[] wsiRsn = (JSPUtil.getParameter(request, prefix	+ "wsi_rsn", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nxtPlnClssCd = (JSPUtil.getParameter(request, prefix	+ "nxt_pln_clss_cd", length));
			String[] whShBImp = (JSPUtil.getParameter(request, prefix	+ "wh_sh_b_imp", length));
			String[] sgsDesc = (JSPUtil.getParameter(request, prefix	+ "sgs_desc", length));
			String[] clh = (JSPUtil.getParameter(request, prefix	+ "clh", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] userName = (JSPUtil.getParameter(request, prefix	+ "user_name", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] sepRsn = (JSPUtil.getParameter(request, prefix	+ "sep_rsn", length));
			String[] eqsRsn = (JSPUtil.getParameter(request, prefix	+ "eqs_rsn", length));
			String[] custSatsfcItmCd = (JSPUtil.getParameter(request, prefix	+ "cust_satsfc_itm_cd", length));
			String[] prbClssCd = (JSPUtil.getParameter(request, prefix	+ "prb_clss_cd", length));
			String[] stfcRsn = (JSPUtil.getParameter(request, prefix	+ "stfc_rsn", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] prbDesc = (JSPUtil.getParameter(request, prefix	+ "prb_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] atsRsn = (JSPUtil.getParameter(request, prefix	+ "ats_rsn", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cahRsn = (JSPUtil.getParameter(request, prefix	+ "cah_rsn", length));
			String[] stfcRepComp = (JSPUtil.getParameter(request, prefix	+ "stfc_rep_comp", length));
			String[] vstPlcCtnt = (JSPUtil.getParameter(request, prefix	+ "vst_plc_ctnt", length));
			String[] curRsn = (JSPUtil.getParameter(request, prefix	+ "cur_rsn", length));
			String[] custRecom = (JSPUtil.getParameter(request, prefix	+ "cust_recom", length));
			String[] ses = (JSPUtil.getParameter(request, prefix	+ "ses", length));
			String[] dobRsn = (JSPUtil.getParameter(request, prefix	+ "dob_rsn", length));
			String[] usf = (JSPUtil.getParameter(request, prefix	+ "usf", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] slsActActDt = (JSPUtil.getParameter(request, prefix	+ "sls_act_act_dt", length));
			String[] clhRsn = (JSPUtil.getParameter(request, prefix	+ "clh_rsn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scrRsn = (JSPUtil.getParameter(request, prefix	+ "scr_rsn", length));
			String[] qur = (JSPUtil.getParameter(request, prefix	+ "qur", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] eqs = (JSPUtil.getParameter(request, prefix	+ "eqs", length));
			String[] wsi = (JSPUtil.getParameter(request, prefix	+ "wsi", length));
			String[] src = (JSPUtil.getParameter(request, prefix	+ "src", length));
			String[] sgsClssCd = (JSPUtil.getParameter(request, prefix	+ "sgs_clss_cd", length));
			String[] qurRsn = (JSPUtil.getParameter(request, prefix	+ "qur_rsn", length));
			String[] cah = (JSPUtil.getParameter(request, prefix	+ "cah", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bizAreaCd = (JSPUtil.getParameter(request, prefix	+ "biz_area_cd", length));
			String[] slsRptClssCd = (JSPUtil.getParameter(request, prefix	+ "sls_rpt_clss_cd", length));
			String[] sesRsn = (JSPUtil.getParameter(request, prefix	+ "ses_rsn", length));
			String[] ats = (JSPUtil.getParameter(request, prefix	+ "ats", length));
			String[] usfRsn = (JSPUtil.getParameter(request, prefix	+ "usf_rsn", length));
			String[] nxtPlnDesc = (JSPUtil.getParameter(request, prefix	+ "nxt_pln_desc", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] grd = (JSPUtil.getParameter(request, prefix	+ "grd", length));
			String[] slsRptSmryDesc = (JSPUtil.getParameter(request, prefix	+ "sls_rpt_smry_desc", length));
			String[] dob = (JSPUtil.getParameter(request, prefix	+ "dob", length));
			String[] cur = (JSPUtil.getParameter(request, prefix	+ "cur", length));
			String[] sep = (JSPUtil.getParameter(request, prefix	+ "sep", length));
			String[] srcRsn = (JSPUtil.getParameter(request, prefix	+ "src_rsn", length));
			String[] slsActSeq = (JSPUtil.getParameter(request, prefix	+ "sls_act_seq", length));
			String[] rel = (JSPUtil.getParameter(request, prefix	+ "rel", length));
			String[] freeRptCtnt = (JSPUtil.getParameter(request, prefix	+ "free_rpt_ctnt", length));
			String[] bocRsn = (JSPUtil.getParameter(request, prefix	+ "boc_rsn", length));
			
			for (int i = 0; i < length; i++) {
				model = new SRepInfoVO();
				if (boc[i] != null)
					model.setBoc(boc[i]);
				if (relRsn[i] != null)
					model.setRelRsn(relRsn[i]);
				if (cun[i] != null)
					model.setCun(cun[i]);
				if (scr[i] != null)
					model.setScr(scr[i]);
				if (cunRsn[i] != null)
					model.setCunRsn(cunRsn[i]);
				if (slsPrmtDesc[i] != null)
					model.setSlsPrmtDesc(slsPrmtDesc[i]);
				if (rsn[i] != null)
					model.setRsn(rsn[i]);
				if (wsiRsn[i] != null)
					model.setWsiRsn(wsiRsn[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nxtPlnClssCd[i] != null)
					model.setNxtPlnClssCd(nxtPlnClssCd[i]);
				if (whShBImp[i] != null)
					model.setWhShBImp(whShBImp[i]);
				if (sgsDesc[i] != null)
					model.setSgsDesc(sgsDesc[i]);
				if (clh[i] != null)
					model.setClh(clh[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (userName[i] != null)
					model.setUserName(userName[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (sepRsn[i] != null)
					model.setSepRsn(sepRsn[i]);
				if (eqsRsn[i] != null)
					model.setEqsRsn(eqsRsn[i]);
				if (custSatsfcItmCd[i] != null)
					model.setCustSatsfcItmCd(custSatsfcItmCd[i]);
				if (prbClssCd[i] != null)
					model.setPrbClssCd(prbClssCd[i]);
				if (stfcRsn[i] != null)
					model.setStfcRsn(stfcRsn[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (prbDesc[i] != null)
					model.setPrbDesc(prbDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (atsRsn[i] != null)
					model.setAtsRsn(atsRsn[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cahRsn[i] != null)
					model.setCahRsn(cahRsn[i]);
				if (stfcRepComp[i] != null)
					model.setStfcRepComp(stfcRepComp[i]);
				if (vstPlcCtnt[i] != null)
					model.setVstPlcCtnt(vstPlcCtnt[i]);
				if (curRsn[i] != null)
					model.setCurRsn(curRsn[i]);
				if (custRecom[i] != null)
					model.setCustRecom(custRecom[i]);
				if (ses[i] != null)
					model.setSes(ses[i]);
				if (dobRsn[i] != null)
					model.setDobRsn(dobRsn[i]);
				if (usf[i] != null)
					model.setUsf(usf[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (slsActActDt[i] != null)
					model.setSlsActActDt(slsActActDt[i]);
				if (clhRsn[i] != null)
					model.setClhRsn(clhRsn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scrRsn[i] != null)
					model.setScrRsn(scrRsn[i]);
				if (qur[i] != null)
					model.setQur(qur[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (eqs[i] != null)
					model.setEqs(eqs[i]);
				if (wsi[i] != null)
					model.setWsi(wsi[i]);
				if (src[i] != null)
					model.setSrc(src[i]);
				if (sgsClssCd[i] != null)
					model.setSgsClssCd(sgsClssCd[i]);
				if (qurRsn[i] != null)
					model.setQurRsn(qurRsn[i]);
				if (cah[i] != null)
					model.setCah(cah[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bizAreaCd[i] != null)
					model.setBizAreaCd(bizAreaCd[i]);
				if (slsRptClssCd[i] != null)
					model.setSlsRptClssCd(slsRptClssCd[i]);
				if (sesRsn[i] != null)
					model.setSesRsn(sesRsn[i]);
				if (ats[i] != null)
					model.setAts(ats[i]);
				if (usfRsn[i] != null)
					model.setUsfRsn(usfRsn[i]);
				if (nxtPlnDesc[i] != null)
					model.setNxtPlnDesc(nxtPlnDesc[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (grd[i] != null)
					model.setGrd(grd[i]);
				if (slsRptSmryDesc[i] != null)
					model.setSlsRptSmryDesc(slsRptSmryDesc[i]);
				if (dob[i] != null)
					model.setDob(dob[i]);
				if (cur[i] != null)
					model.setCur(cur[i]);
				if (sep[i] != null)
					model.setSep(sep[i]);
				if (srcRsn[i] != null)
					model.setSrcRsn(srcRsn[i]);
				if (slsActSeq[i] != null)
					model.setSlsActSeq(slsActSeq[i]);
				if (rel[i] != null)
					model.setRel(rel[i]);
				if (freeRptCtnt[i] != null)
					model.setFreeRptCtnt(freeRptCtnt[i]);
				if (bocRsn[i] != null)
					model.setBocRsn(bocRsn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSRepInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SRepInfoVO[]
	 */
	public SRepInfoVO[] getSRepInfoVOs(){
		SRepInfoVO[] vos = (SRepInfoVO[])models.toArray(new SRepInfoVO[models.size()]);
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
		this.boc = this.boc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relRsn = this.relRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cun = this.cun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scr = this.scr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cunRsn = this.cunRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsPrmtDesc = this.slsPrmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsn = this.rsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wsiRsn = this.wsiRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPlnClssCd = this.nxtPlnClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whShBImp = this.whShBImp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgsDesc = this.sgsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clh = this.clh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userName = this.userName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepRsn = this.sepRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqsRsn = this.eqsRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSatsfcItmCd = this.custSatsfcItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prbClssCd = this.prbClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stfcRsn = this.stfcRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prbDesc = this.prbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atsRsn = this.atsRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cahRsn = this.cahRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stfcRepComp = this.stfcRepComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vstPlcCtnt = this.vstPlcCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curRsn = this.curRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRecom = this.custRecom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ses = this.ses .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dobRsn = this.dobRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usf = this.usf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActActDt = this.slsActActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clhRsn = this.clhRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrRsn = this.scrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qur = this.qur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqs = this.eqs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wsi = this.wsi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.src = this.src .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgsClssCd = this.sgsClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qurRsn = this.qurRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cah = this.cah .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizAreaCd = this.bizAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRptClssCd = this.slsRptClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sesRsn = this.sesRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ats = this.ats .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usfRsn = this.usfRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtPlnDesc = this.nxtPlnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grd = this.grd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRptSmryDesc = this.slsRptSmryDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dob = this.dob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cur = this.cur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sep = this.sep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcRsn = this.srcRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActSeq = this.slsActSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rel = this.rel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeRptCtnt = this.freeRptCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bocRsn = this.bocRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
