/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanManifestListCmfDetailVO.java
*@FileTitle : JapanManifestListCmfDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO
 */

public class JapanManifestListCmfDetailVO extends com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListCmfDetailVO> models = new ArrayList<JapanManifestListCmfDetailVO>();
	
	/* Column Info */
	private String custSeq2 = null;
	/* Column Info */
	private String custSeq3 = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String pstRlyPodCd = null;
	/* Column Info */
	private String faxNo3 = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String faxNo2 = null;
	/* Column Info */
	private String jpEdiTrsmStgTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String custCntCd3 = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String jpBlStsCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String blSplitNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custCntCd2 = null;
	/* Column Info */
	private String loclTsFlg = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String bkgPorCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String custAddr3 = null;
	/* Column Info */
	private String custAddr2 = null;
	/* Column Info */
	private String custAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String pstVvdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podSplitCd = null;
	/* Column Info */
	private String sendCount = null;
	/* Column Info */
	private String podBnd = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String phnNo3 = null;
	/* Column Info */
	private String delBnd = null;
	/* Column Info */
	private String custNm3 = null;
	/* Column Info */
	private String phnNo2 = null;
	/* Column Info */
	private String custNm2 = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JapanManifestListCmfDetailVO() {}

	public JapanManifestListCmfDetailVO(String ibflag, String pagerows, String custSeq2, String custSeq3, String custNm, String pstRlyPodCd, String etaDt, String faxNo3, String faxNo2, String jpEdiTrsmStgTpCd, String blNo, String vvdCd, String bkgDelCd, String dcgoFlg, String wgtUtCd, String measQty, String custCntCd3, String pckQty, String jpBlStsCd, String pckTpCd, String measUtCd, String blSplitNo, String custCntCd, String custCntCd2, String loclTsFlg, String bkgPolCd, String bkgPorCd, String phnNo, String custAddr3, String custAddr2, String custAddr, String custSeq, String pstVvdCd, String podSplitCd, String podCd, String fullMtyCd, String faxNo, String phnNo3, String custNm3, String custNm2, String phnNo2, String grsWgt, String sendCount, String aproNo, String delBnd, String podBnd, String deltFlg) {
		this.custSeq2 = custSeq2;
		this.custSeq3 = custSeq3;
		this.custNm = custNm;
		this.deltFlg = deltFlg;
		this.pstRlyPodCd = pstRlyPodCd;
		this.faxNo3 = faxNo3;
		this.etaDt = etaDt;
		this.faxNo2 = faxNo2;
		this.jpEdiTrsmStgTpCd = jpEdiTrsmStgTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.bkgDelCd = bkgDelCd;
		this.dcgoFlg = dcgoFlg;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.custCntCd3 = custCntCd3;
		this.pckQty = pckQty;
		this.jpBlStsCd = jpBlStsCd;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.blSplitNo = blSplitNo;
		this.custCntCd = custCntCd;
		this.custCntCd2 = custCntCd2;
		this.loclTsFlg = loclTsFlg;
		this.phnNo = phnNo;
		this.bkgPorCd = bkgPorCd;
		this.bkgPolCd = bkgPolCd;
		this.aproNo = aproNo;
		this.custAddr3 = custAddr3;
		this.custAddr2 = custAddr2;
		this.custAddr = custAddr;
		this.custSeq = custSeq;
		this.pstVvdCd = pstVvdCd;
		this.podCd = podCd;
		this.podSplitCd = podSplitCd;
		this.sendCount = sendCount;
		this.podBnd = podBnd;
		this.faxNo = faxNo;
		this.fullMtyCd = fullMtyCd;
		this.phnNo3 = phnNo3;
		this.delBnd = delBnd;
		this.custNm3 = custNm3;
		this.phnNo2 = phnNo2;
		this.custNm2 = custNm2;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_seq2", getCustSeq2());
		this.hashColumns.put("cust_seq3", getCustSeq3());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("pst_rly_pod_cd", getPstRlyPodCd());
		this.hashColumns.put("fax_no3", getFaxNo3());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("fax_no2", getFaxNo2());
		this.hashColumns.put("jp_edi_trsm_stg_tp_cd", getJpEdiTrsmStgTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("cust_cnt_cd3", getCustCntCd3());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("jp_bl_sts_cd", getJpBlStsCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("bl_split_no", getBlSplitNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_cnt_cd2", getCustCntCd2());
		this.hashColumns.put("locl_ts_flg", getLoclTsFlg());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("cust_addr3", getCustAddr3());
		this.hashColumns.put("cust_addr2", getCustAddr2());
		this.hashColumns.put("cust_addr", getCustAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("pst_vvd_cd", getPstVvdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_split_cd", getPodSplitCd());
		this.hashColumns.put("send_count", getSendCount());
		this.hashColumns.put("pod_bnd", getPodBnd());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("phn_no3", getPhnNo3());
		this.hashColumns.put("del_bnd", getDelBnd());
		this.hashColumns.put("cust_nm3", getCustNm3());
		this.hashColumns.put("phn_no2", getPhnNo2());
		this.hashColumns.put("cust_nm2", getCustNm2());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_seq2", "custSeq2");
		this.hashFields.put("cust_seq3", "custSeq3");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("pst_rly_pod_cd", "pstRlyPodCd");
		this.hashFields.put("fax_no3", "faxNo3");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("fax_no2", "faxNo2");
		this.hashFields.put("jp_edi_trsm_stg_tp_cd", "jpEdiTrsmStgTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("cust_cnt_cd3", "custCntCd3");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("jp_bl_sts_cd", "jpBlStsCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("bl_split_no", "blSplitNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_cnt_cd2", "custCntCd2");
		this.hashFields.put("locl_ts_flg", "loclTsFlg");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("cust_addr3", "custAddr3");
		this.hashFields.put("cust_addr2", "custAddr2");
		this.hashFields.put("cust_addr", "custAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pst_vvd_cd", "pstVvdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_split_cd", "podSplitCd");
		this.hashFields.put("send_count", "sendCount");
		this.hashFields.put("pod_bnd", "podBnd");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("phn_no3", "phnNo3");
		this.hashFields.put("del_bnd", "delBnd");
		this.hashFields.put("cust_nm3", "custNm3");
		this.hashFields.put("phn_no2", "phnNo2");
		this.hashFields.put("cust_nm2", "custNm2");
		this.hashFields.put("grs_wgt", "grsWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custSeq2
	 */
	public String getCustSeq2() {
		return this.custSeq2;
	}
	
	/**
	 * Column Info
	 * @return custSeq3
	 */
	public String getCustSeq3() {
		return this.custSeq3;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPodCd
	 */
	public String getPstRlyPodCd() {
		return this.pstRlyPodCd;
	}
	
	/**
	 * Column Info
	 * @return faxNo3
	 */
	public String getFaxNo3() {
		return this.faxNo3;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return faxNo2
	 */
	public String getFaxNo2() {
		return this.faxNo2;
	}
	
	/**
	 * Column Info
	 * @return jpEdiTrsmStgTpCd
	 */
	public String getJpEdiTrsmStgTpCd() {
		return this.jpEdiTrsmStgTpCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return custCntCd3
	 */
	public String getCustCntCd3() {
		return this.custCntCd3;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return jpBlStsCd
	 */
	public String getJpBlStsCd() {
		return this.jpBlStsCd;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return blSplitNo
	 */
	public String getBlSplitNo() {
		return this.blSplitNo;
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
	 * @return custCntCd2
	 */
	public String getCustCntCd2() {
		return this.custCntCd2;
	}
	
	/**
	 * Column Info
	 * @return loclTsFlg
	 */
	public String getLoclTsFlg() {
		return this.loclTsFlg;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPolCd
	 */
	public String getBkgPolCd() {
		return this.bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @return aproNo
	 */
	public String getAproNo() {
		return this.aproNo;
	}
	
	/**
	 * Column Info
	 * @return custAddr3
	 */
	public String getCustAddr3() {
		return this.custAddr3;
	}
	
	/**
	 * Column Info
	 * @return custAddr2
	 */
	public String getCustAddr2() {
		return this.custAddr2;
	}
	
	/**
	 * Column Info
	 * @return custAddr
	 */
	public String getCustAddr() {
		return this.custAddr;
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
	 * @return pstVvdCd
	 */
	public String getPstVvdCd() {
		return this.pstVvdCd;
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
	 * @return podSplitCd
	 */
	public String getPodSplitCd() {
		return this.podSplitCd;
	}
	
	/**
	 * Column Info
	 * @return sendCount
	 */
	public String getSendCount() {
		return this.sendCount;
	}
	
	/**
	 * Column Info
	 * @return podBnd
	 */
	public String getPodBnd() {
		return this.podBnd;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return phnNo3
	 */
	public String getPhnNo3() {
		return this.phnNo3;
	}
	
	/**
	 * Column Info
	 * @return delBnd
	 */
	public String getDelBnd() {
		return this.delBnd;
	}
	
	/**
	 * Column Info
	 * @return custNm3
	 */
	public String getCustNm3() {
		return this.custNm3;
	}
	
	/**
	 * Column Info
	 * @return phnNo2
	 */
	public String getPhnNo2() {
		return this.phnNo2;
	}
	
	/**
	 * Column Info
	 * @return custNm2
	 */
	public String getCustNm2() {
		return this.custNm2;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	

	/**
	 * Column Info
	 * @param custSeq2
	 */
	public void setCustSeq2(String custSeq2) {
		this.custSeq2 = custSeq2;
	}
	
	/**
	 * Column Info
	 * @param custSeq3
	 */
	public void setCustSeq3(String custSeq3) {
		this.custSeq3 = custSeq3;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPodCd
	 */
	public void setPstRlyPodCd(String pstRlyPodCd) {
		this.pstRlyPodCd = pstRlyPodCd;
	}
	
	/**
	 * Column Info
	 * @param faxNo3
	 */
	public void setFaxNo3(String faxNo3) {
		this.faxNo3 = faxNo3;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param faxNo2
	 */
	public void setFaxNo2(String faxNo2) {
		this.faxNo2 = faxNo2;
	}
	
	/**
	 * Column Info
	 * @param jpEdiTrsmStgTpCd
	 */
	public void setJpEdiTrsmStgTpCd(String jpEdiTrsmStgTpCd) {
		this.jpEdiTrsmStgTpCd = jpEdiTrsmStgTpCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param custCntCd3
	 */
	public void setCustCntCd3(String custCntCd3) {
		this.custCntCd3 = custCntCd3;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param jpBlStsCd
	 */
	public void setJpBlStsCd(String jpBlStsCd) {
		this.jpBlStsCd = jpBlStsCd;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param blSplitNo
	 */
	public void setBlSplitNo(String blSplitNo) {
		this.blSplitNo = blSplitNo;
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
	 * @param custCntCd2
	 */
	public void setCustCntCd2(String custCntCd2) {
		this.custCntCd2 = custCntCd2;
	}
	
	/**
	 * Column Info
	 * @param loclTsFlg
	 */
	public void setLoclTsFlg(String loclTsFlg) {
		this.loclTsFlg = loclTsFlg;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPolCd
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * Column Info
	 * @param aproNo
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
	}
	
	/**
	 * Column Info
	 * @param custAddr3
	 */
	public void setCustAddr3(String custAddr3) {
		this.custAddr3 = custAddr3;
	}
	
	/**
	 * Column Info
	 * @param custAddr2
	 */
	public void setCustAddr2(String custAddr2) {
		this.custAddr2 = custAddr2;
	}
	
	/**
	 * Column Info
	 * @param custAddr
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
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
	 * @param pstVvdCd
	 */
	public void setPstVvdCd(String pstVvdCd) {
		this.pstVvdCd = pstVvdCd;
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
	 * @param podSplitCd
	 */
	public void setPodSplitCd(String podSplitCd) {
		this.podSplitCd = podSplitCd;
	}
	
	/**
	 * Column Info
	 * @param sendCount
	 */
	public void setSendCount(String sendCount) {
		this.sendCount = sendCount;
	}
	
	/**
	 * Column Info
	 * @param podBnd
	 */
	public void setPodBnd(String podBnd) {
		this.podBnd = podBnd;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param phnNo3
	 */
	public void setPhnNo3(String phnNo3) {
		this.phnNo3 = phnNo3;
	}
	
	/**
	 * Column Info
	 * @param delBnd
	 */
	public void setDelBnd(String delBnd) {
		this.delBnd = delBnd;
	}
	
	/**
	 * Column Info
	 * @param custNm3
	 */
	public void setCustNm3(String custNm3) {
		this.custNm3 = custNm3;
	}
	
	/**
	 * Column Info
	 * @param phnNo2
	 */
	public void setPhnNo2(String phnNo2) {
		this.phnNo2 = phnNo2;
	}
	
	/**
	 * Column Info
	 * @param custNm2
	 */
	public void setCustNm2(String custNm2) {
		this.custNm2 = custNm2;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
		setCustSeq2(JSPUtil.getParameter(request, prefix + "cust_seq2", ""));
		setCustSeq3(JSPUtil.getParameter(request, prefix + "cust_seq3", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setPstRlyPodCd(JSPUtil.getParameter(request, prefix + "pst_rly_pod_cd", ""));
		setFaxNo3(JSPUtil.getParameter(request, prefix + "fax_no3", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setFaxNo2(JSPUtil.getParameter(request, prefix + "fax_no2", ""));
		setJpEdiTrsmStgTpCd(JSPUtil.getParameter(request, prefix + "jp_edi_trsm_stg_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setBkgDelCd(JSPUtil.getParameter(request, prefix + "bkg_del_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setCustCntCd3(JSPUtil.getParameter(request, prefix + "cust_cnt_cd3", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setJpBlStsCd(JSPUtil.getParameter(request, prefix + "jp_bl_sts_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setBlSplitNo(JSPUtil.getParameter(request, prefix + "bl_split_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustCntCd2(JSPUtil.getParameter(request, prefix + "cust_cnt_cd2", ""));
		setLoclTsFlg(JSPUtil.getParameter(request, prefix + "locl_ts_flg", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setBkgPorCd(JSPUtil.getParameter(request, prefix + "bkg_por_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setAproNo(JSPUtil.getParameter(request, prefix + "apro_no", ""));
		setCustAddr3(JSPUtil.getParameter(request, prefix + "cust_addr3", ""));
		setCustAddr2(JSPUtil.getParameter(request, prefix + "cust_addr2", ""));
		setCustAddr(JSPUtil.getParameter(request, prefix + "cust_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setPstVvdCd(JSPUtil.getParameter(request, prefix + "pst_vvd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPodSplitCd(JSPUtil.getParameter(request, prefix + "pod_split_cd", ""));
		setSendCount(JSPUtil.getParameter(request, prefix + "send_count", ""));
		setPodBnd(JSPUtil.getParameter(request, prefix + "pod_bnd", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setPhnNo3(JSPUtil.getParameter(request, prefix + "phn_no3", ""));
		setDelBnd(JSPUtil.getParameter(request, prefix + "del_bnd", ""));
		setCustNm3(JSPUtil.getParameter(request, prefix + "cust_nm3", ""));
		setPhnNo2(JSPUtil.getParameter(request, prefix + "phn_no2", ""));
		setCustNm2(JSPUtil.getParameter(request, prefix + "cust_nm2", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListCmfDetailVO[]
	 */
	public JapanManifestListCmfDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListCmfDetailVO[]
	 */
	public JapanManifestListCmfDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListCmfDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custSeq2 = (JSPUtil.getParameter(request, prefix	+ "cust_seq2", length));
			String[] custSeq3 = (JSPUtil.getParameter(request, prefix	+ "cust_seq3", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] pstRlyPodCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_pod_cd", length));
			String[] faxNo3 = (JSPUtil.getParameter(request, prefix	+ "fax_no3", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] faxNo2 = (JSPUtil.getParameter(request, prefix	+ "fax_no2", length));
			String[] jpEdiTrsmStgTpCd = (JSPUtil.getParameter(request, prefix	+ "jp_edi_trsm_stg_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] custCntCd3 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd3", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] jpBlStsCd = (JSPUtil.getParameter(request, prefix	+ "jp_bl_sts_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] blSplitNo = (JSPUtil.getParameter(request, prefix	+ "bl_split_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custCntCd2 = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd2", length));
			String[] loclTsFlg = (JSPUtil.getParameter(request, prefix	+ "locl_ts_flg", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no", length));
			String[] custAddr3 = (JSPUtil.getParameter(request, prefix	+ "cust_addr3", length));
			String[] custAddr2 = (JSPUtil.getParameter(request, prefix	+ "cust_addr2", length));
			String[] custAddr = (JSPUtil.getParameter(request, prefix	+ "cust_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] pstVvdCd = (JSPUtil.getParameter(request, prefix	+ "pst_vvd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] podSplitCd = (JSPUtil.getParameter(request, prefix	+ "pod_split_cd", length));
			String[] sendCount = (JSPUtil.getParameter(request, prefix	+ "send_count", length));
			String[] podBnd = (JSPUtil.getParameter(request, prefix	+ "pod_bnd", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] phnNo3 = (JSPUtil.getParameter(request, prefix	+ "phn_no3", length));
			String[] delBnd = (JSPUtil.getParameter(request, prefix	+ "del_bnd", length));
			String[] custNm3 = (JSPUtil.getParameter(request, prefix	+ "cust_nm3", length));
			String[] phnNo2 = (JSPUtil.getParameter(request, prefix	+ "phn_no2", length));
			String[] custNm2 = (JSPUtil.getParameter(request, prefix	+ "cust_nm2", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListCmfDetailVO();
				if (custSeq2[i] != null)
					model.setCustSeq2(custSeq2[i]);
				if (custSeq3[i] != null)
					model.setCustSeq3(custSeq3[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (pstRlyPodCd[i] != null)
					model.setPstRlyPodCd(pstRlyPodCd[i]);
				if (faxNo3[i] != null)
					model.setFaxNo3(faxNo3[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (faxNo2[i] != null)
					model.setFaxNo2(faxNo2[i]);
				if (jpEdiTrsmStgTpCd[i] != null)
					model.setJpEdiTrsmStgTpCd(jpEdiTrsmStgTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (custCntCd3[i] != null)
					model.setCustCntCd3(custCntCd3[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (jpBlStsCd[i] != null)
					model.setJpBlStsCd(jpBlStsCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (blSplitNo[i] != null)
					model.setBlSplitNo(blSplitNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custCntCd2[i] != null)
					model.setCustCntCd2(custCntCd2[i]);
				if (loclTsFlg[i] != null)
					model.setLoclTsFlg(loclTsFlg[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (custAddr3[i] != null)
					model.setCustAddr3(custAddr3[i]);
				if (custAddr2[i] != null)
					model.setCustAddr2(custAddr2[i]);
				if (custAddr[i] != null)
					model.setCustAddr(custAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (pstVvdCd[i] != null)
					model.setPstVvdCd(pstVvdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podSplitCd[i] != null)
					model.setPodSplitCd(podSplitCd[i]);
				if (sendCount[i] != null)
					model.setSendCount(sendCount[i]);
				if (podBnd[i] != null)
					model.setPodBnd(podBnd[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (phnNo3[i] != null)
					model.setPhnNo3(phnNo3[i]);
				if (delBnd[i] != null)
					model.setDelBnd(delBnd[i]);
				if (custNm3[i] != null)
					model.setCustNm3(custNm3[i]);
				if (phnNo2[i] != null)
					model.setPhnNo2(phnNo2[i]);
				if (custNm2[i] != null)
					model.setCustNm2(custNm2[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListCmfDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListCmfDetailVO[]
	 */
	public JapanManifestListCmfDetailVO[] getJapanManifestListCmfDetailVOs(){
		JapanManifestListCmfDetailVO[] vos = (JapanManifestListCmfDetailVO[])models.toArray(new JapanManifestListCmfDetailVO[models.size()]);
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
		this.custSeq2 = this.custSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq3 = this.custSeq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPodCd = this.pstRlyPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo3 = this.faxNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo2 = this.faxNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpEdiTrsmStgTpCd = this.jpEdiTrsmStgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd3 = this.custCntCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpBlStsCd = this.jpBlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSplitNo = this.blSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd2 = this.custCntCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsFlg = this.loclTsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr3 = this.custAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr2 = this.custAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAddr = this.custAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstVvdCd = this.pstVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSplitCd = this.podSplitCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendCount = this.sendCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podBnd = this.podBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo3 = this.phnNo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delBnd = this.delBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm3 = this.custNm3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo2 = this.phnNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm2 = this.custNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
