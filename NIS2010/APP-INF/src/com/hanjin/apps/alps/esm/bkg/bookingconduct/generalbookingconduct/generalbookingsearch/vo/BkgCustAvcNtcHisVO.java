/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgCustAvcNtcHisVO.java
*@FileTitle : BkgCustAvcNtcHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
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

public class BkgCustAvcNtcHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustAvcNtcHisVO> models = new ArrayList<BkgCustAvcNtcHisVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String sntFaxNoEml = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sntRsltCtnt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntcViaCd = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String imptNtcRmk = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sntRsltCd = null;
	/* Column Info */
	private String ntcSndUsrId = null;
	/* Column Info */
	private String ntcSndDt = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ntcSndRsltCd = null;
	/* Column Info */
	private String sntUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String srcDatTpCd = null;
	/* Column Info */
	private String ntcSndRqstDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sntOfcCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ntcSndGdt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ntcSndId = null;
	/* Column Info */
	private String sntRmk = null;
	/* Column Info */
	private String ntcSndOfcCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ntcSndRqstGdt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCustAvcNtcHisVO() {}

	public BkgCustAvcNtcHisVO(String ibflag, String pagerows, String blNo, String bkgNo, String cntrNo, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String polCd, String podCd, String delCd, String ntcViaCd, String custTp, String custNm, String sntFaxNoEml, String sntRmk, String ntcSndRqstDt, String sntOfcCd, String sntUsrId, String sntRsltCd, String sntRsltCtnt, String updDt, String creDt, String creUsrId, String updUsrId, String ntcSndGdt, String imptNtcRmk, String ntcEml, String ntcSndId, String ntcSndOfcCd, String ntcSndUsrId, String ntcSndDt, String bkgCustTpCd, String ntcSndRqstGdt, String ntcSndRsltCd, String faxNo, String srcDatTpCd) {
		this.vslCd = vslCd;
		this.custNm = custNm;
		this.sntFaxNoEml = sntFaxNoEml;
		this.creDt = creDt;
		this.sntRsltCtnt = sntRsltCtnt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ntcViaCd = ntcViaCd;
		this.ntcEml = ntcEml;
		this.imptNtcRmk = imptNtcRmk;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.sntRsltCd = sntRsltCd;
		this.ntcSndUsrId = ntcSndUsrId;
		this.ntcSndDt = ntcSndDt;
		this.bkgCustTpCd = bkgCustTpCd;
		this.updUsrId = updUsrId;
		this.ntcSndRsltCd = ntcSndRsltCd;
		this.sntUsrId = sntUsrId;
		this.updDt = updDt;
		this.srcDatTpCd = srcDatTpCd;
		this.ntcSndRqstDt = ntcSndRqstDt;
		this.delCd = delCd;
		this.sntOfcCd = sntOfcCd;
		this.skdVoyNo = skdVoyNo;
		this.ntcSndGdt = ntcSndGdt;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.custTp = custTp;
		this.creUsrId = creUsrId;
		this.ntcSndId = ntcSndId;
		this.sntRmk = sntRmk;
		this.ntcSndOfcCd = ntcSndOfcCd;
		this.cntrNo = cntrNo;
		this.faxNo = faxNo;
		this.ntcSndRqstGdt = ntcSndRqstGdt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("snt_fax_no_eml", getSntFaxNoEml());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("snt_rslt_ctnt", getSntRsltCtnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntc_via_cd", getNtcViaCd());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("impt_ntc_rmk", getImptNtcRmk());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("snt_rslt_cd", getSntRsltCd());
		this.hashColumns.put("ntc_snd_usr_id", getNtcSndUsrId());
		this.hashColumns.put("ntc_snd_dt", getNtcSndDt());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ntc_snd_rslt_cd", getNtcSndRsltCd());
		this.hashColumns.put("snt_usr_id", getSntUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("src_dat_tp_cd", getSrcDatTpCd());
		this.hashColumns.put("ntc_snd_rqst_dt", getNtcSndRqstDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("snt_ofc_cd", getSntOfcCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ntc_snd_gdt", getNtcSndGdt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ntc_snd_id", getNtcSndId());
		this.hashColumns.put("snt_rmk", getSntRmk());
		this.hashColumns.put("ntc_snd_ofc_cd", getNtcSndOfcCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("ntc_snd_rqst_gdt", getNtcSndRqstGdt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("snt_fax_no_eml", "sntFaxNoEml");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("snt_rslt_ctnt", "sntRsltCtnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_via_cd", "ntcViaCd");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("impt_ntc_rmk", "imptNtcRmk");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("snt_rslt_cd", "sntRsltCd");
		this.hashFields.put("ntc_snd_usr_id", "ntcSndUsrId");
		this.hashFields.put("ntc_snd_dt", "ntcSndDt");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ntc_snd_rslt_cd", "ntcSndRsltCd");
		this.hashFields.put("snt_usr_id", "sntUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("src_dat_tp_cd", "srcDatTpCd");
		this.hashFields.put("ntc_snd_rqst_dt", "ntcSndRqstDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("snt_ofc_cd", "sntOfcCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ntc_snd_gdt", "ntcSndGdt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ntc_snd_id", "ntcSndId");
		this.hashFields.put("snt_rmk", "sntRmk");
		this.hashFields.put("ntc_snd_ofc_cd", "ntcSndOfcCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("ntc_snd_rqst_gdt", "ntcSndRqstGdt");
		return this.hashFields;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return sntFaxNoEml
	 */
	public String getSntFaxNoEml() {
		return this.sntFaxNoEml;
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
	 * @return sntRsltCtnt
	 */
	public String getSntRsltCtnt() {
		return this.sntRsltCtnt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return ntcViaCd
	 */
	public String getNtcViaCd() {
		return this.ntcViaCd;
	}
	
	/**
	 * Column Info
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
	}
	
	/**
	 * Column Info
	 * @return imptNtcRmk
	 */
	public String getImptNtcRmk() {
		return this.imptNtcRmk;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return sntRsltCd
	 */
	public String getSntRsltCd() {
		return this.sntRsltCd;
	}
	
	/**
	 * Column Info
	 * @return ntcSndUsrId
	 */
	public String getNtcSndUsrId() {
		return this.ntcSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return ntcSndDt
	 */
	public String getNtcSndDt() {
		return this.ntcSndDt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ntcSndRsltCd
	 */
	public String getNtcSndRsltCd() {
		return this.ntcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return sntUsrId
	 */
	public String getSntUsrId() {
		return this.sntUsrId;
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
	 * @return srcDatTpCd
	 */
	public String getSrcDatTpCd() {
		return this.srcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcSndRqstDt
	 */
	public String getNtcSndRqstDt() {
		return this.ntcSndRqstDt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return sntOfcCd
	 */
	public String getSntOfcCd() {
		return this.sntOfcCd;
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
	 * @return ntcSndGdt
	 */
	public String getNtcSndGdt() {
		return this.ntcSndGdt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
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
	 * @return ntcSndId
	 */
	public String getNtcSndId() {
		return this.ntcSndId;
	}
	
	/**
	 * Column Info
	 * @return sntRmk
	 */
	public String getSntRmk() {
		return this.sntRmk;
	}
	
	/**
	 * Column Info
	 * @return ntcSndOfcCd
	 */
	public String getNtcSndOfcCd() {
		return this.ntcSndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return ntcSndRqstGdt
	 */
	public String getNtcSndRqstGdt() {
		return this.ntcSndRqstGdt;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param sntFaxNoEml
	 */
	public void setSntFaxNoEml(String sntFaxNoEml) {
		this.sntFaxNoEml = sntFaxNoEml;
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
	 * @param sntRsltCtnt
	 */
	public void setSntRsltCtnt(String sntRsltCtnt) {
		this.sntRsltCtnt = sntRsltCtnt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param ntcViaCd
	 */
	public void setNtcViaCd(String ntcViaCd) {
		this.ntcViaCd = ntcViaCd;
	}
	
	/**
	 * Column Info
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
	}
	
	/**
	 * Column Info
	 * @param imptNtcRmk
	 */
	public void setImptNtcRmk(String imptNtcRmk) {
		this.imptNtcRmk = imptNtcRmk;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param sntRsltCd
	 */
	public void setSntRsltCd(String sntRsltCd) {
		this.sntRsltCd = sntRsltCd;
	}
	
	/**
	 * Column Info
	 * @param ntcSndUsrId
	 */
	public void setNtcSndUsrId(String ntcSndUsrId) {
		this.ntcSndUsrId = ntcSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param ntcSndDt
	 */
	public void setNtcSndDt(String ntcSndDt) {
		this.ntcSndDt = ntcSndDt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ntcSndRsltCd
	 */
	public void setNtcSndRsltCd(String ntcSndRsltCd) {
		this.ntcSndRsltCd = ntcSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param sntUsrId
	 */
	public void setSntUsrId(String sntUsrId) {
		this.sntUsrId = sntUsrId;
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
	 * @param srcDatTpCd
	 */
	public void setSrcDatTpCd(String srcDatTpCd) {
		this.srcDatTpCd = srcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcSndRqstDt
	 */
	public void setNtcSndRqstDt(String ntcSndRqstDt) {
		this.ntcSndRqstDt = ntcSndRqstDt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param sntOfcCd
	 */
	public void setSntOfcCd(String sntOfcCd) {
		this.sntOfcCd = sntOfcCd;
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
	 * @param ntcSndGdt
	 */
	public void setNtcSndGdt(String ntcSndGdt) {
		this.ntcSndGdt = ntcSndGdt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
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
	 * @param ntcSndId
	 */
	public void setNtcSndId(String ntcSndId) {
		this.ntcSndId = ntcSndId;
	}
	
	/**
	 * Column Info
	 * @param sntRmk
	 */
	public void setSntRmk(String sntRmk) {
		this.sntRmk = sntRmk;
	}
	
	/**
	 * Column Info
	 * @param ntcSndOfcCd
	 */
	public void setNtcSndOfcCd(String ntcSndOfcCd) {
		this.ntcSndOfcCd = ntcSndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param ntcSndRqstGdt
	 */
	public void setNtcSndRqstGdt(String ntcSndRqstGdt) {
		this.ntcSndRqstGdt = ntcSndRqstGdt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSntFaxNoEml(JSPUtil.getParameter(request, prefix + "snt_fax_no_eml", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSntRsltCtnt(JSPUtil.getParameter(request, prefix + "snt_rslt_ctnt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtcViaCd(JSPUtil.getParameter(request, prefix + "ntc_via_cd", ""));
		setNtcEml(JSPUtil.getParameter(request, prefix + "ntc_eml", ""));
		setImptNtcRmk(JSPUtil.getParameter(request, prefix + "impt_ntc_rmk", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSntRsltCd(JSPUtil.getParameter(request, prefix + "snt_rslt_cd", ""));
		setNtcSndUsrId(JSPUtil.getParameter(request, prefix + "ntc_snd_usr_id", ""));
		setNtcSndDt(JSPUtil.getParameter(request, prefix + "ntc_snd_dt", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setNtcSndRsltCd(JSPUtil.getParameter(request, prefix + "ntc_snd_rslt_cd", ""));
		setSntUsrId(JSPUtil.getParameter(request, prefix + "snt_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSrcDatTpCd(JSPUtil.getParameter(request, prefix + "src_dat_tp_cd", ""));
		setNtcSndRqstDt(JSPUtil.getParameter(request, prefix + "ntc_snd_rqst_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSntOfcCd(JSPUtil.getParameter(request, prefix + "snt_ofc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setNtcSndGdt(JSPUtil.getParameter(request, prefix + "ntc_snd_gdt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCustTp(JSPUtil.getParameter(request, prefix + "cust_tp", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setNtcSndId(JSPUtil.getParameter(request, prefix + "ntc_snd_id", ""));
		setSntRmk(JSPUtil.getParameter(request, prefix + "snt_rmk", ""));
		setNtcSndOfcCd(JSPUtil.getParameter(request, prefix + "ntc_snd_ofc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setNtcSndRqstGdt(JSPUtil.getParameter(request, prefix + "ntc_snd_rqst_gdt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustAvcNtcHisVO[]
	 */
	public BkgCustAvcNtcHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustAvcNtcHisVO[]
	 */
	public BkgCustAvcNtcHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustAvcNtcHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] sntFaxNoEml = (JSPUtil.getParameter(request, prefix	+ "snt_fax_no_eml", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sntRsltCtnt = (JSPUtil.getParameter(request, prefix	+ "snt_rslt_ctnt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntcViaCd = (JSPUtil.getParameter(request, prefix	+ "ntc_via_cd", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] imptNtcRmk = (JSPUtil.getParameter(request, prefix	+ "impt_ntc_rmk", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sntRsltCd = (JSPUtil.getParameter(request, prefix	+ "snt_rslt_cd", length));
			String[] ntcSndUsrId = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_usr_id", length));
			String[] ntcSndDt = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_dt", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ntcSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_rslt_cd", length));
			String[] sntUsrId = (JSPUtil.getParameter(request, prefix	+ "snt_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] srcDatTpCd = (JSPUtil.getParameter(request, prefix	+ "src_dat_tp_cd", length));
			String[] ntcSndRqstDt = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_rqst_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] sntOfcCd = (JSPUtil.getParameter(request, prefix	+ "snt_ofc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ntcSndGdt = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_gdt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ntcSndId = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_id", length));
			String[] sntRmk = (JSPUtil.getParameter(request, prefix	+ "snt_rmk", length));
			String[] ntcSndOfcCd = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_ofc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ntcSndRqstGdt = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_rqst_gdt", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustAvcNtcHisVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (sntFaxNoEml[i] != null)
					model.setSntFaxNoEml(sntFaxNoEml[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sntRsltCtnt[i] != null)
					model.setSntRsltCtnt(sntRsltCtnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcViaCd[i] != null)
					model.setNtcViaCd(ntcViaCd[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (imptNtcRmk[i] != null)
					model.setImptNtcRmk(imptNtcRmk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sntRsltCd[i] != null)
					model.setSntRsltCd(sntRsltCd[i]);
				if (ntcSndUsrId[i] != null)
					model.setNtcSndUsrId(ntcSndUsrId[i]);
				if (ntcSndDt[i] != null)
					model.setNtcSndDt(ntcSndDt[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ntcSndRsltCd[i] != null)
					model.setNtcSndRsltCd(ntcSndRsltCd[i]);
				if (sntUsrId[i] != null)
					model.setSntUsrId(sntUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (srcDatTpCd[i] != null)
					model.setSrcDatTpCd(srcDatTpCd[i]);
				if (ntcSndRqstDt[i] != null)
					model.setNtcSndRqstDt(ntcSndRqstDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sntOfcCd[i] != null)
					model.setSntOfcCd(sntOfcCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ntcSndGdt[i] != null)
					model.setNtcSndGdt(ntcSndGdt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ntcSndId[i] != null)
					model.setNtcSndId(ntcSndId[i]);
				if (sntRmk[i] != null)
					model.setSntRmk(sntRmk[i]);
				if (ntcSndOfcCd[i] != null)
					model.setNtcSndOfcCd(ntcSndOfcCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ntcSndRqstGdt[i] != null)
					model.setNtcSndRqstGdt(ntcSndRqstGdt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustAvcNtcHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustAvcNtcHisVO[]
	 */
	public BkgCustAvcNtcHisVO[] getBkgCustAvcNtcHisVOs(){
		BkgCustAvcNtcHisVO[] vos = (BkgCustAvcNtcHisVO[])models.toArray(new BkgCustAvcNtcHisVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntFaxNoEml = this.sntFaxNoEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntRsltCtnt = this.sntRsltCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcViaCd = this.ntcViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imptNtcRmk = this.imptNtcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntRsltCd = this.sntRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndUsrId = this.ntcSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndDt = this.ntcSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndRsltCd = this.ntcSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntUsrId = this.sntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcDatTpCd = this.srcDatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndRqstDt = this.ntcSndRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntOfcCd = this.sntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndGdt = this.ntcSndGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndId = this.ntcSndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntRmk = this.sntRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndOfcCd = this.ntcSndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndRqstGdt = this.ntcSndRqstGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
