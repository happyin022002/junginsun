/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SeaWayBillPrintVO.java
*@FileTitle : SeaWayBillPrintVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SeaWayBillPrintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SeaWayBillPrintVO> models = new ArrayList<SeaWayBillPrintVO>();
	
	/* Column Info */
	private String authUsrId = null;
	/* Column Info */
	private String antfySeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String frtFwrdCntCd = null;
	/* Column Info */
	private String deltOfcCd = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String antfyCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String authOfcCd = null;
	/* Column Info */
	private String inetBlSndViaCd = null;
	/* Column Info */
	private String loclVerCtnt = null;
	/* Column Info */
	private String deltUsrId = null;
	/* Column Info */
	private String webSvcAdmUsrId = null;
	/* Column Info */
	private String oblInetPrnDt = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String authGdt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prnUsrId = null;
	/* Column Info */
	private String oblSndAdmUsrId = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String infoSeq = null;
	/* Column Info */
	private String prnCustTpCd = null;
	/* Column Info */
	private String mrgFileNm = null;
	/* Column Info */
	private String wblPrnKnt = null;
	/* Column Info */
	private String mrgDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ntfySeq = null;
	/* Column Info */
	private String oblInetPrnGdt = null;
	/* Column Info */
	private String oblKnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String docEcdProcFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n2ndPrnDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String authLginFlg = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String n1stPrnDt = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String frtFwrdSeq = null;
	/* Column Info */
	private String wblPrnDt = null;
	/* Column Info */
	private String wblPrnGdt = null;
	/* Column Info */
	private String authDt = null;
	/* Column Info */
	private String cpyKnt = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String edwUpdDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SeaWayBillPrintVO() {}

	public SeaWayBillPrintVO(String ibflag, String pagerows, String bkgNo, String infoSeq, String authDt, String authGdt, String authOfcCd, String authUsrId, String inetBlSndViaCd, String oblKnt, String cpyKnt, String wblPrnDt, String wblPrnGdt, String wblPrnKnt, String n1stPrnDt, String n2ndPrnDt, String docEcdProcFlg, String prnCustTpCd, String prnUsrId, String mrgFileNm, String mrgDt, String authLginFlg, String oblSndAdmUsrId, String webSvcAdmUsrId, String shprCntCd, String shprSeq, String cneeCntCd, String cneeSeq, String ntfyCntCd, String ntfySeq, String frtFwrdCntCd, String frtFwrdSeq, String antfyCntCd, String antfySeq, String vslCd, String skdVoyNo, String skdDirCd, String blObrdDt, String blNo, String oblInetPrnDt, String oblInetPrnGdt, String bkgCustTpCd, String loclVerCtnt, String deltFlg, String deltUsrId, String deltOfcCd, String deltDt, String creUsrId, String creDt, String updUsrId, String updDt, String edwUpdDt) {
		this.authUsrId = authUsrId;
		this.antfySeq = antfySeq;
		this.blNo = blNo;
		this.bkgNo = bkgNo;
		this.frtFwrdCntCd = frtFwrdCntCd;
		this.deltOfcCd = deltOfcCd;
		this.shprSeq = shprSeq;
		this.shprCntCd = shprCntCd;
		this.antfyCntCd = antfyCntCd;
		this.updUsrId = updUsrId;
		this.authOfcCd = authOfcCd;
		this.inetBlSndViaCd = inetBlSndViaCd;
		this.loclVerCtnt = loclVerCtnt;
		this.deltUsrId = deltUsrId;
		this.webSvcAdmUsrId = webSvcAdmUsrId;
		this.oblInetPrnDt = oblInetPrnDt;
		this.ntfyCntCd = ntfyCntCd;
		this.authGdt = authGdt;
		this.pagerows = pagerows;
		this.prnUsrId = prnUsrId;
		this.oblSndAdmUsrId = oblSndAdmUsrId;
		this.blObrdDt = blObrdDt;
		this.vslCd = vslCd;
		this.infoSeq = infoSeq;
		this.prnCustTpCd = prnCustTpCd;
		this.mrgFileNm = mrgFileNm;
		this.wblPrnKnt = wblPrnKnt;
		this.mrgDt = mrgDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.ntfySeq = ntfySeq;
		this.oblInetPrnGdt = oblInetPrnGdt;
		this.oblKnt = oblKnt;
		this.updDt = updDt;
		this.docEcdProcFlg = docEcdProcFlg;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.n2ndPrnDt = n2ndPrnDt;
		this.skdDirCd = skdDirCd;
		this.authLginFlg = authLginFlg;
		this.cneeCntCd = cneeCntCd;
		this.deltDt = deltDt;
		this.skdVoyNo = skdVoyNo;
		this.n1stPrnDt = n1stPrnDt;
		this.cneeSeq = cneeSeq;
		this.frtFwrdSeq = frtFwrdSeq;
		this.wblPrnDt = wblPrnDt;
		this.wblPrnGdt = wblPrnGdt;
		this.authDt = authDt;
		this.cpyKnt = cpyKnt;
		this.bkgCustTpCd = bkgCustTpCd;
		this.edwUpdDt = edwUpdDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_usr_id", getAuthUsrId());
		this.hashColumns.put("antfy_seq", getAntfySeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());
		this.hashColumns.put("delt_ofc_cd", getDeltOfcCd());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("antfy_cnt_cd", getAntfyCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
		this.hashColumns.put("inet_bl_snd_via_cd", getInetBlSndViaCd());
		this.hashColumns.put("locl_ver_ctnt", getLoclVerCtnt());
		this.hashColumns.put("delt_usr_id", getDeltUsrId());
		this.hashColumns.put("web_svc_adm_usr_id", getWebSvcAdmUsrId());
		this.hashColumns.put("obl_inet_prn_dt", getOblInetPrnDt());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("auth_gdt", getAuthGdt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prn_usr_id", getPrnUsrId());
		this.hashColumns.put("obl_snd_adm_usr_id", getOblSndAdmUsrId());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("info_seq", getInfoSeq());
		this.hashColumns.put("prn_cust_tp_cd", getPrnCustTpCd());
		this.hashColumns.put("mrg_file_nm", getMrgFileNm());
		this.hashColumns.put("wbl_prn_knt", getWblPrnKnt());
		this.hashColumns.put("mrg_dt", getMrgDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ntfy_seq", getNtfySeq());
		this.hashColumns.put("obl_inet_prn_gdt", getOblInetPrnGdt());
		this.hashColumns.put("obl_knt", getOblKnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("doc_ecd_proc_flg", getDocEcdProcFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n2nd_prn_dt", getN2ndPrnDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("auth_lgin_flg", getAuthLginFlg());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("n1st_prn_dt", getN1stPrnDt());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("frt_fwrd_seq", getFrtFwrdSeq());
		this.hashColumns.put("wbl_prn_dt", getWblPrnDt());
		this.hashColumns.put("wbl_prn_gdt", getWblPrnGdt());
		this.hashColumns.put("auth_dt", getAuthDt());
		this.hashColumns.put("cpy_knt", getCpyKnt());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_usr_id", "authUsrId");
		this.hashFields.put("antfy_seq", "antfySeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("delt_ofc_cd", "deltOfcCd");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("antfy_cnt_cd", "antfyCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("auth_ofc_cd", "authOfcCd");
		this.hashFields.put("inet_bl_snd_via_cd", "inetBlSndViaCd");
		this.hashFields.put("locl_ver_ctnt", "loclVerCtnt");
		this.hashFields.put("delt_usr_id", "deltUsrId");
		this.hashFields.put("web_svc_adm_usr_id", "webSvcAdmUsrId");
		this.hashFields.put("obl_inet_prn_dt", "oblInetPrnDt");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("auth_gdt", "authGdt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prn_usr_id", "prnUsrId");
		this.hashFields.put("obl_snd_adm_usr_id", "oblSndAdmUsrId");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("info_seq", "infoSeq");
		this.hashFields.put("prn_cust_tp_cd", "prnCustTpCd");
		this.hashFields.put("mrg_file_nm", "mrgFileNm");
		this.hashFields.put("wbl_prn_knt", "wblPrnKnt");
		this.hashFields.put("mrg_dt", "mrgDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ntfy_seq", "ntfySeq");
		this.hashFields.put("obl_inet_prn_gdt", "oblInetPrnGdt");
		this.hashFields.put("obl_knt", "oblKnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("doc_ecd_proc_flg", "docEcdProcFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n2nd_prn_dt", "n2ndPrnDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("auth_lgin_flg", "authLginFlg");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("n1st_prn_dt", "n1stPrnDt");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("frt_fwrd_seq", "frtFwrdSeq");
		this.hashFields.put("wbl_prn_dt", "wblPrnDt");
		this.hashFields.put("wbl_prn_gdt", "wblPrnGdt");
		this.hashFields.put("auth_dt", "authDt");
		this.hashFields.put("cpy_knt", "cpyKnt");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authUsrId
	 */
	public String getAuthUsrId() {
		return this.authUsrId;
	}
	
	/**
	 * Column Info
	 * @return antfySeq
	 */
	public String getAntfySeq() {
		return this.antfySeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCntCd
	 */
	public String getFrtFwrdCntCd() {
		return this.frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @return deltOfcCd
	 */
	public String getDeltOfcCd() {
		return this.deltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}
	
	/**
	 * Column Info
	 * @return antfyCntCd
	 */
	public String getAntfyCntCd() {
		return this.antfyCntCd;
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
	 * @return authOfcCd
	 */
	public String getAuthOfcCd() {
		return this.authOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inetBlSndViaCd
	 */
	public String getInetBlSndViaCd() {
		return this.inetBlSndViaCd;
	}
	
	/**
	 * Column Info
	 * @return loclVerCtnt
	 */
	public String getLoclVerCtnt() {
		return this.loclVerCtnt;
	}
	
	/**
	 * Column Info
	 * @return deltUsrId
	 */
	public String getDeltUsrId() {
		return this.deltUsrId;
	}
	
	/**
	 * Column Info
	 * @return webSvcAdmUsrId
	 */
	public String getWebSvcAdmUsrId() {
		return this.webSvcAdmUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblInetPrnDt
	 */
	public String getOblInetPrnDt() {
		return this.oblInetPrnDt;
	}
	
	/**
	 * Column Info
	 * @return ntfyCntCd
	 */
	public String getNtfyCntCd() {
		return this.ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @return authGdt
	 */
	public String getAuthGdt() {
		return this.authGdt;
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
	 * @return prnUsrId
	 */
	public String getPrnUsrId() {
		return this.prnUsrId;
	}
	
	/**
	 * Column Info
	 * @return oblSndAdmUsrId
	 */
	public String getOblSndAdmUsrId() {
		return this.oblSndAdmUsrId;
	}
	
	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return infoSeq
	 */
	public String getInfoSeq() {
		return this.infoSeq;
	}
	
	/**
	 * Column Info
	 * @return prnCustTpCd
	 */
	public String getPrnCustTpCd() {
		return this.prnCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return mrgFileNm
	 */
	public String getMrgFileNm() {
		return this.mrgFileNm;
	}
	
	/**
	 * Column Info
	 * @return wblPrnKnt
	 */
	public String getWblPrnKnt() {
		return this.wblPrnKnt;
	}
	
	/**
	 * Column Info
	 * @return mrgDt
	 */
	public String getMrgDt() {
		return this.mrgDt;
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
	 * @return ntfySeq
	 */
	public String getNtfySeq() {
		return this.ntfySeq;
	}
	
	/**
	 * Column Info
	 * @return oblInetPrnGdt
	 */
	public String getOblInetPrnGdt() {
		return this.oblInetPrnGdt;
	}
	
	/**
	 * Column Info
	 * @return oblKnt
	 */
	public String getOblKnt() {
		return this.oblKnt;
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
	 * @return docEcdProcFlg
	 */
	public String getDocEcdProcFlg() {
		return this.docEcdProcFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return n2ndPrnDt
	 */
	public String getN2ndPrnDt() {
		return this.n2ndPrnDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return authLginFlg
	 */
	public String getAuthLginFlg() {
		return this.authLginFlg;
	}
	
	/**
	 * Column Info
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return n1stPrnDt
	 */
	public String getN1stPrnDt() {
		return this.n1stPrnDt;
	}
	
	/**
	 * Column Info
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdSeq
	 */
	public String getFrtFwrdSeq() {
		return this.frtFwrdSeq;
	}
	
	/**
	 * Column Info
	 * @return wblPrnDt
	 */
	public String getWblPrnDt() {
		return this.wblPrnDt;
	}
	
	/**
	 * Column Info
	 * @return wblPrnGdt
	 */
	public String getWblPrnGdt() {
		return this.wblPrnGdt;
	}
	
	/**
	 * Column Info
	 * @return authDt
	 */
	public String getAuthDt() {
		return this.authDt;
	}
	
	/**
	 * Column Info
	 * @return cpyKnt
	 */
	public String getCpyKnt() {
		return this.cpyKnt;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return edwUpdDt
	 */
	public String getEdwUpdDt() {
		return this.edwUpdDt;
	}
	

	/**
	 * Column Info
	 * @param authUsrId
	 */
	public void setAuthUsrId(String authUsrId) {
		this.authUsrId = authUsrId;
	}
	
	/**
	 * Column Info
	 * @param antfySeq
	 */
	public void setAntfySeq(String antfySeq) {
		this.antfySeq = antfySeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCntCd
	 */
	public void setFrtFwrdCntCd(String frtFwrdCntCd) {
		this.frtFwrdCntCd = frtFwrdCntCd;
	}
	
	/**
	 * Column Info
	 * @param deltOfcCd
	 */
	public void setDeltOfcCd(String deltOfcCd) {
		this.deltOfcCd = deltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}
	
	/**
	 * Column Info
	 * @param antfyCntCd
	 */
	public void setAntfyCntCd(String antfyCntCd) {
		this.antfyCntCd = antfyCntCd;
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
	 * @param authOfcCd
	 */
	public void setAuthOfcCd(String authOfcCd) {
		this.authOfcCd = authOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inetBlSndViaCd
	 */
	public void setInetBlSndViaCd(String inetBlSndViaCd) {
		this.inetBlSndViaCd = inetBlSndViaCd;
	}
	
	/**
	 * Column Info
	 * @param loclVerCtnt
	 */
	public void setLoclVerCtnt(String loclVerCtnt) {
		this.loclVerCtnt = loclVerCtnt;
	}
	
	/**
	 * Column Info
	 * @param deltUsrId
	 */
	public void setDeltUsrId(String deltUsrId) {
		this.deltUsrId = deltUsrId;
	}
	
	/**
	 * Column Info
	 * @param webSvcAdmUsrId
	 */
	public void setWebSvcAdmUsrId(String webSvcAdmUsrId) {
		this.webSvcAdmUsrId = webSvcAdmUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblInetPrnDt
	 */
	public void setOblInetPrnDt(String oblInetPrnDt) {
		this.oblInetPrnDt = oblInetPrnDt;
	}
	
	/**
	 * Column Info
	 * @param ntfyCntCd
	 */
	public void setNtfyCntCd(String ntfyCntCd) {
		this.ntfyCntCd = ntfyCntCd;
	}
	
	/**
	 * Column Info
	 * @param authGdt
	 */
	public void setAuthGdt(String authGdt) {
		this.authGdt = authGdt;
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
	 * @param prnUsrId
	 */
	public void setPrnUsrId(String prnUsrId) {
		this.prnUsrId = prnUsrId;
	}
	
	/**
	 * Column Info
	 * @param oblSndAdmUsrId
	 */
	public void setOblSndAdmUsrId(String oblSndAdmUsrId) {
		this.oblSndAdmUsrId = oblSndAdmUsrId;
	}
	
	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param infoSeq
	 */
	public void setInfoSeq(String infoSeq) {
		this.infoSeq = infoSeq;
	}
	
	/**
	 * Column Info
	 * @param prnCustTpCd
	 */
	public void setPrnCustTpCd(String prnCustTpCd) {
		this.prnCustTpCd = prnCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param mrgFileNm
	 */
	public void setMrgFileNm(String mrgFileNm) {
		this.mrgFileNm = mrgFileNm;
	}
	
	/**
	 * Column Info
	 * @param wblPrnKnt
	 */
	public void setWblPrnKnt(String wblPrnKnt) {
		this.wblPrnKnt = wblPrnKnt;
	}
	
	/**
	 * Column Info
	 * @param mrgDt
	 */
	public void setMrgDt(String mrgDt) {
		this.mrgDt = mrgDt;
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
	 * @param ntfySeq
	 */
	public void setNtfySeq(String ntfySeq) {
		this.ntfySeq = ntfySeq;
	}
	
	/**
	 * Column Info
	 * @param oblInetPrnGdt
	 */
	public void setOblInetPrnGdt(String oblInetPrnGdt) {
		this.oblInetPrnGdt = oblInetPrnGdt;
	}
	
	/**
	 * Column Info
	 * @param oblKnt
	 */
	public void setOblKnt(String oblKnt) {
		this.oblKnt = oblKnt;
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
	 * @param docEcdProcFlg
	 */
	public void setDocEcdProcFlg(String docEcdProcFlg) {
		this.docEcdProcFlg = docEcdProcFlg;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param n2ndPrnDt
	 */
	public void setN2ndPrnDt(String n2ndPrnDt) {
		this.n2ndPrnDt = n2ndPrnDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param authLginFlg
	 */
	public void setAuthLginFlg(String authLginFlg) {
		this.authLginFlg = authLginFlg;
	}
	
	/**
	 * Column Info
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
	}
	
	/**
	 * Column Info
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param n1stPrnDt
	 */
	public void setN1stPrnDt(String n1stPrnDt) {
		this.n1stPrnDt = n1stPrnDt;
	}
	
	/**
	 * Column Info
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdSeq
	 */
	public void setFrtFwrdSeq(String frtFwrdSeq) {
		this.frtFwrdSeq = frtFwrdSeq;
	}
	
	/**
	 * Column Info
	 * @param wblPrnDt
	 */
	public void setWblPrnDt(String wblPrnDt) {
		this.wblPrnDt = wblPrnDt;
	}
	
	/**
	 * Column Info
	 * @param wblPrnGdt
	 */
	public void setWblPrnGdt(String wblPrnGdt) {
		this.wblPrnGdt = wblPrnGdt;
	}
	
	/**
	 * Column Info
	 * @param authDt
	 */
	public void setAuthDt(String authDt) {
		this.authDt = authDt;
	}
	
	/**
	 * Column Info
	 * @param cpyKnt
	 */
	public void setCpyKnt(String cpyKnt) {
		this.cpyKnt = cpyKnt;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param edwUpdDt
	 */
	public void setEdwUpdDt(String edwUpdDt) {
		this.edwUpdDt = edwUpdDt;
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
		setAuthUsrId(JSPUtil.getParameter(request, prefix + "auth_usr_id", ""));
		setAntfySeq(JSPUtil.getParameter(request, prefix + "antfy_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request, prefix + "frt_fwrd_cnt_cd", ""));
		setDeltOfcCd(JSPUtil.getParameter(request, prefix + "delt_ofc_cd", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setAntfyCntCd(JSPUtil.getParameter(request, prefix + "antfy_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
		setInetBlSndViaCd(JSPUtil.getParameter(request, prefix + "inet_bl_snd_via_cd", ""));
		setLoclVerCtnt(JSPUtil.getParameter(request, prefix + "locl_ver_ctnt", ""));
		setDeltUsrId(JSPUtil.getParameter(request, prefix + "delt_usr_id", ""));
		setWebSvcAdmUsrId(JSPUtil.getParameter(request, prefix + "web_svc_adm_usr_id", ""));
		setOblInetPrnDt(JSPUtil.getParameter(request, prefix + "obl_inet_prn_dt", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
		setAuthGdt(JSPUtil.getParameter(request, prefix + "auth_gdt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrnUsrId(JSPUtil.getParameter(request, prefix + "prn_usr_id", ""));
		setOblSndAdmUsrId(JSPUtil.getParameter(request, prefix + "obl_snd_adm_usr_id", ""));
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setInfoSeq(JSPUtil.getParameter(request, prefix + "info_seq", ""));
		setPrnCustTpCd(JSPUtil.getParameter(request, prefix + "prn_cust_tp_cd", ""));
		setMrgFileNm(JSPUtil.getParameter(request, prefix + "mrg_file_nm", ""));
		setWblPrnKnt(JSPUtil.getParameter(request, prefix + "wbl_prn_knt", ""));
		setMrgDt(JSPUtil.getParameter(request, prefix + "mrg_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNtfySeq(JSPUtil.getParameter(request, prefix + "ntfy_seq", ""));
		setOblInetPrnGdt(JSPUtil.getParameter(request, prefix + "obl_inet_prn_gdt", ""));
		setOblKnt(JSPUtil.getParameter(request, prefix + "obl_knt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDocEcdProcFlg(JSPUtil.getParameter(request, prefix + "doc_ecd_proc_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN2ndPrnDt(JSPUtil.getParameter(request, prefix + "n2nd_prn_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setAuthLginFlg(JSPUtil.getParameter(request, prefix + "auth_lgin_flg", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setN1stPrnDt(JSPUtil.getParameter(request, prefix + "n1st_prn_dt", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
		setFrtFwrdSeq(JSPUtil.getParameter(request, prefix + "frt_fwrd_seq", ""));
		setWblPrnDt(JSPUtil.getParameter(request, prefix + "wbl_prn_dt", ""));
		setWblPrnGdt(JSPUtil.getParameter(request, prefix + "wbl_prn_gdt", ""));
		setAuthDt(JSPUtil.getParameter(request, prefix + "auth_dt", ""));
		setCpyKnt(JSPUtil.getParameter(request, prefix + "cpy_knt", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SeaWayBillPrintVO[]
	 */
	public SeaWayBillPrintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SeaWayBillPrintVO[]
	 */
	public SeaWayBillPrintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SeaWayBillPrintVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_usr_id", length));
			String[] antfySeq = (JSPUtil.getParameter(request, prefix	+ "antfy_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] frtFwrdCntCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cnt_cd", length));
			String[] deltOfcCd = (JSPUtil.getParameter(request, prefix	+ "delt_ofc_cd", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] antfyCntCd = (JSPUtil.getParameter(request, prefix	+ "antfy_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] authOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_ofc_cd", length));
			String[] inetBlSndViaCd = (JSPUtil.getParameter(request, prefix	+ "inet_bl_snd_via_cd", length));
			String[] loclVerCtnt = (JSPUtil.getParameter(request, prefix	+ "locl_ver_ctnt", length));
			String[] deltUsrId = (JSPUtil.getParameter(request, prefix	+ "delt_usr_id", length));
			String[] webSvcAdmUsrId = (JSPUtil.getParameter(request, prefix	+ "web_svc_adm_usr_id", length));
			String[] oblInetPrnDt = (JSPUtil.getParameter(request, prefix	+ "obl_inet_prn_dt", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] authGdt = (JSPUtil.getParameter(request, prefix	+ "auth_gdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prnUsrId = (JSPUtil.getParameter(request, prefix	+ "prn_usr_id", length));
			String[] oblSndAdmUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_snd_adm_usr_id", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] infoSeq = (JSPUtil.getParameter(request, prefix	+ "info_seq", length));
			String[] prnCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prn_cust_tp_cd", length));
			String[] mrgFileNm = (JSPUtil.getParameter(request, prefix	+ "mrg_file_nm", length));
			String[] wblPrnKnt = (JSPUtil.getParameter(request, prefix	+ "wbl_prn_knt", length));
			String[] mrgDt = (JSPUtil.getParameter(request, prefix	+ "mrg_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ntfySeq = (JSPUtil.getParameter(request, prefix	+ "ntfy_seq", length));
			String[] oblInetPrnGdt = (JSPUtil.getParameter(request, prefix	+ "obl_inet_prn_gdt", length));
			String[] oblKnt = (JSPUtil.getParameter(request, prefix	+ "obl_knt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] docEcdProcFlg = (JSPUtil.getParameter(request, prefix	+ "doc_ecd_proc_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n2ndPrnDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_prn_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] authLginFlg = (JSPUtil.getParameter(request, prefix	+ "auth_lgin_flg", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] n1stPrnDt = (JSPUtil.getParameter(request, prefix	+ "n1st_prn_dt", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] frtFwrdSeq = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_seq", length));
			String[] wblPrnDt = (JSPUtil.getParameter(request, prefix	+ "wbl_prn_dt", length));
			String[] wblPrnGdt = (JSPUtil.getParameter(request, prefix	+ "wbl_prn_gdt", length));
			String[] authDt = (JSPUtil.getParameter(request, prefix	+ "auth_dt", length));
			String[] cpyKnt = (JSPUtil.getParameter(request, prefix	+ "cpy_knt", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] edwUpdDt = (JSPUtil.getParameter(request, prefix	+ "edw_upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SeaWayBillPrintVO();
				if (authUsrId[i] != null)
					model.setAuthUsrId(authUsrId[i]);
				if (antfySeq[i] != null)
					model.setAntfySeq(antfySeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (frtFwrdCntCd[i] != null)
					model.setFrtFwrdCntCd(frtFwrdCntCd[i]);
				if (deltOfcCd[i] != null)
					model.setDeltOfcCd(deltOfcCd[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (antfyCntCd[i] != null)
					model.setAntfyCntCd(antfyCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (authOfcCd[i] != null)
					model.setAuthOfcCd(authOfcCd[i]);
				if (inetBlSndViaCd[i] != null)
					model.setInetBlSndViaCd(inetBlSndViaCd[i]);
				if (loclVerCtnt[i] != null)
					model.setLoclVerCtnt(loclVerCtnt[i]);
				if (deltUsrId[i] != null)
					model.setDeltUsrId(deltUsrId[i]);
				if (webSvcAdmUsrId[i] != null)
					model.setWebSvcAdmUsrId(webSvcAdmUsrId[i]);
				if (oblInetPrnDt[i] != null)
					model.setOblInetPrnDt(oblInetPrnDt[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (authGdt[i] != null)
					model.setAuthGdt(authGdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prnUsrId[i] != null)
					model.setPrnUsrId(prnUsrId[i]);
				if (oblSndAdmUsrId[i] != null)
					model.setOblSndAdmUsrId(oblSndAdmUsrId[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (infoSeq[i] != null)
					model.setInfoSeq(infoSeq[i]);
				if (prnCustTpCd[i] != null)
					model.setPrnCustTpCd(prnCustTpCd[i]);
				if (mrgFileNm[i] != null)
					model.setMrgFileNm(mrgFileNm[i]);
				if (wblPrnKnt[i] != null)
					model.setWblPrnKnt(wblPrnKnt[i]);
				if (mrgDt[i] != null)
					model.setMrgDt(mrgDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ntfySeq[i] != null)
					model.setNtfySeq(ntfySeq[i]);
				if (oblInetPrnGdt[i] != null)
					model.setOblInetPrnGdt(oblInetPrnGdt[i]);
				if (oblKnt[i] != null)
					model.setOblKnt(oblKnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (docEcdProcFlg[i] != null)
					model.setDocEcdProcFlg(docEcdProcFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n2ndPrnDt[i] != null)
					model.setN2ndPrnDt(n2ndPrnDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (authLginFlg[i] != null)
					model.setAuthLginFlg(authLginFlg[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (n1stPrnDt[i] != null)
					model.setN1stPrnDt(n1stPrnDt[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (frtFwrdSeq[i] != null)
					model.setFrtFwrdSeq(frtFwrdSeq[i]);
				if (wblPrnDt[i] != null)
					model.setWblPrnDt(wblPrnDt[i]);
				if (wblPrnGdt[i] != null)
					model.setWblPrnGdt(wblPrnGdt[i]);
				if (authDt[i] != null)
					model.setAuthDt(authDt[i]);
				if (cpyKnt[i] != null)
					model.setCpyKnt(cpyKnt[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (edwUpdDt[i] != null)
					model.setEdwUpdDt(edwUpdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSeaWayBillPrintVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SeaWayBillPrintVO[]
	 */
	public SeaWayBillPrintVO[] getSeaWayBillPrintVOs(){
		SeaWayBillPrintVO[] vos = (SeaWayBillPrintVO[])models.toArray(new SeaWayBillPrintVO[models.size()]);
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
		this.authUsrId = this.authUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfySeq = this.antfySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd = this.frtFwrdCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltOfcCd = this.deltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyCntCd = this.antfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authOfcCd = this.authOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inetBlSndViaCd = this.inetBlSndViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVerCtnt = this.loclVerCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltUsrId = this.deltUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.webSvcAdmUsrId = this.webSvcAdmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblInetPrnDt = this.oblInetPrnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authGdt = this.authGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnUsrId = this.prnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblSndAdmUsrId = this.oblSndAdmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.infoSeq = this.infoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnCustTpCd = this.prnCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrgFileNm = this.mrgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblPrnKnt = this.wblPrnKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrgDt = this.mrgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfySeq = this.ntfySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblInetPrnGdt = this.oblInetPrnGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblKnt = this.oblKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docEcdProcFlg = this.docEcdProcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPrnDt = this.n2ndPrnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authLginFlg = this.authLginFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPrnDt = this.n1stPrnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdSeq = this.frtFwrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblPrnDt = this.wblPrnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblPrnGdt = this.wblPrnGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authDt = this.authDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpyKnt = this.cpyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt = this.edwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
