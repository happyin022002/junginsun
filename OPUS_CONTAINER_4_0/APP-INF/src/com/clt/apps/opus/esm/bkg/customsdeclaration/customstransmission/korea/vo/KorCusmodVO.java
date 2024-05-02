/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCusmodVO.java
*@FileTitle : KorCusmodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.25 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCusmodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCusmodVO> models = new ArrayList<KorCusmodVO>();

	/* Column Info */
	private String krCstmsDeptCd = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String divdPckQty = null;
	/* Column Info */
	private String preXptLicNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String cgoDesc1 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String preCntrNo = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String cstmsOfcCtyCd = null;
	/* Column Info */
	private String krXptPckId = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String prtLodgFlg = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String divdPckUtCd = null;
	/* Column Info */
	private String prtLodgSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String cntrSealNo1 = null;
	/* Column Info */
	private String cntrSealNo2 = null;
	/* Column Info */
	private String crntCtnt1 = null;
	/* Column Info */
	private String cntrTtlWgt = null;
	/* Column Info */
	private String crntCtnt2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCusmodVO() {}

	public KorCusmodVO(String ibflag, String pagerows, String cstmsOfcCtyCd, String krCstmsDeptCd, String subNo, String krCstmsCorrId, String blNo, String krCstmsBlTpCd, String cstmsDeclTpCd, String podCd, String pckQty, String pckTpCd, String corrRsn, String cgoDesc1, String cntrTtlWgt, String wgtUtCd, String measQty, String cntrCnt, String sCustNm, String sCustAddr, String cCustNm, String cCustAddr, String nCustNm, String nCustAddr, String bdAreaCd, String xptLicNo, String preXptLicNo, String cntrWgt, String prtLodgFlg, String prtLodgSeq, String krXptPckId, String divdPckQty, String divdPckUtCd, String cntrNo, String preCntrNo, String cntrTpszCd, String cntrSealNo, String crntCtnt1, String crntCtnt2, String cntrSealNo1, String cntrSealNo2) {
		this.krCstmsDeptCd = krCstmsDeptCd;
		this.krCstmsCorrId = krCstmsCorrId;
		this.cCustNm = cCustNm;
		this.xptLicNo = xptLicNo;
		this.blNo = blNo;
		this.nCustAddr = nCustAddr;
		this.pagerows = pagerows;
		this.divdPckQty = divdPckQty;
		this.preXptLicNo = preXptLicNo;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.cCustAddr = cCustAddr;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.subNo = subNo;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.cgoDesc1 = cgoDesc1;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.preCntrNo = preCntrNo;
		this.nCustNm = nCustNm;
		this.pckTpCd = pckTpCd;
		this.cstmsOfcCtyCd = cstmsOfcCtyCd;
		this.krXptPckId = krXptPckId;
		this.cntrWgt = cntrWgt;
		this.sCustNm = sCustNm;
		this.prtLodgFlg = prtLodgFlg;
		this.cntrCnt = cntrCnt;
		this.bdAreaCd = bdAreaCd;
		this.podCd = podCd;
		this.divdPckUtCd = divdPckUtCd;
		this.prtLodgSeq = prtLodgSeq;
		this.cntrNo = cntrNo;
		this.sCustAddr = sCustAddr;
		this.cntrSealNo = cntrSealNo;
		this.cntrSealNo1 = cntrSealNo1;
		this.cntrSealNo2 = cntrSealNo2;
		this.crntCtnt1 = crntCtnt1;
		this.cntrTtlWgt = cntrTtlWgt;
		this.crntCtnt2 = crntCtnt2;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("kr_cstms_dept_cd", getKrCstmsDeptCd());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("divd_pck_qty", getDivdPckQty());
		this.hashColumns.put("pre_xpt_lic_no", getPreXptLicNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("cgo_desc1", getCgoDesc1());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pre_cntr_no", getPreCntrNo());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cstms_ofc_cty_cd", getCstmsOfcCtyCd());
		this.hashColumns.put("kr_xpt_pck_id", getKrXptPckId());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("prt_lodg_flg", getPrtLodgFlg());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("divd_pck_ut_cd", getDivdPckUtCd());
		this.hashColumns.put("prt_lodg_seq", getPrtLodgSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("cntr_seal_no1", getCntrSealNo1());
		this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
		this.hashColumns.put("crnt_ctnt1", getCrntCtnt1());
		this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
		this.hashColumns.put("crnt_ctnt2", getCrntCtnt2());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("kr_cstms_dept_cd", "krCstmsDeptCd");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("divd_pck_qty", "divdPckQty");
		this.hashFields.put("pre_xpt_lic_no", "preXptLicNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("cgo_desc1", "cgoDesc1");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pre_cntr_no", "preCntrNo");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cstms_ofc_cty_cd", "cstmsOfcCtyCd");
		this.hashFields.put("kr_xpt_pck_id", "krXptPckId");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("prt_lodg_flg", "prtLodgFlg");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("divd_pck_ut_cd", "divdPckUtCd");
		this.hashFields.put("prt_lodg_seq", "prtLodgSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("cntr_seal_no1", "cntrSealNo1");
		this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
		this.hashFields.put("crnt_ctnt1", "crntCtnt1");
		this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
		this.hashFields.put("crnt_ctnt2", "crntCtnt2");
		return this.hashFields;
	}

	/**
	 * @return the cntrSealNo1
	 */
	public String getCntrSealNo1() {
		return cntrSealNo1;
	}

	/**
	 * @param cntrSealNo1 the cntrSealNo1 to set
	 */
	public void setCntrSealNo1(String cntrSealNo1) {
		this.cntrSealNo1 = cntrSealNo1;
	}

	/**
	 * @return the cntrSealNo2
	 */
	public String getCntrSealNo2() {
		return cntrSealNo2;
	}

	/**
	 * @param cntrSealNo2 the cntrSealNo2 to set
	 */
	public void setCntrSealNo2(String cntrSealNo2) {
		this.cntrSealNo2 = cntrSealNo2;
	}

	/**
	 * Column Info
	 * @return krCstmsDeptCd
	 */
	public String getKrCstmsDeptCd() {
		return this.krCstmsDeptCd;
	}

	/**
	 * Column Info
	 * @return krCstmsCorrId
	 */
	public String getKrCstmsCorrId() {
		return this.krCstmsCorrId;
	}

	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}

	/**
	 * Column Info
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
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
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
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
	 * @return divdPckQty
	 */
	public String getDivdPckQty() {
		return this.divdPckQty;
	}

	/**
	 * Column Info
	 * @return preXptLicNo
	 */
	public String getPreXptLicNo() {
		return this.preXptLicNo;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
	}

	/**
	 * Column Info
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
	}

	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @return subNo
	 */
	public String getSubNo() {
		return this.subNo;
	}

	/**
	 * Column Info
	 * @return krCstmsBlTpCd
	 */
	public String getKrCstmsBlTpCd() {
		return this.krCstmsBlTpCd;
	}

	/**
	 * Column Info
	 * @return cgoDesc1
	 */
	public String getCgoDesc1() {
		return this.cgoDesc1;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * @return preCntrNo
	 */
	public String getPreCntrNo() {
		return this.preCntrNo;
	}

	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
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
	 * @return cstmsOfcCtyCd
	 */
	public String getCstmsOfcCtyCd() {
		return this.cstmsOfcCtyCd;
	}

	/**
	 * Column Info
	 * @return krXptPckId
	 */
	public String getKrXptPckId() {
		return this.krXptPckId;
	}

	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}

	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}

	/**
	 * Column Info
	 * @return prtLodgFlg
	 */
	public String getPrtLodgFlg() {
		return this.prtLodgFlg;
	}

	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}

	/**
	 * Column Info
	 * @return bdAreaCd
	 */
	public String getBdAreaCd() {
		return this.bdAreaCd;
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
	 * @return divdPckUtCd
	 */
	public String getDivdPckUtCd() {
		return this.divdPckUtCd;
	}

	/**
	 * Column Info
	 * @return prtLodgSeq
	 */
	public String getPrtLodgSeq() {
		return this.prtLodgSeq;
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
	 * @return sCustAddr
	 */
	public String getSCustAddr() {
		return this.sCustAddr;
	}

	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}

	/**
	 * Column Info
	 * @return crntCtnt1
	 */
	public String getCrntCtnt1() {
		return this.crntCtnt1;
	}

	/**
	 * Column Info
	 * @return cntrTtlWgt
	 */
	public String getCntrTtlWgt() {
		return this.cntrTtlWgt;
	}

	/**
	 * Column Info
	 * @return crntCtnt2
	 */
	public String getCrntCtnt2() {
		return this.crntCtnt2;
	}


	/**
	 * Column Info
	 * @param krCstmsDeptCd
	 */
	public void setKrCstmsDeptCd(String krCstmsDeptCd) {
		this.krCstmsDeptCd = krCstmsDeptCd;
	}

	/**
	 * Column Info
	 * @param krCstmsCorrId
	 */
	public void setKrCstmsCorrId(String krCstmsCorrId) {
		this.krCstmsCorrId = krCstmsCorrId;
	}

	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}

	/**
	 * Column Info
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
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
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
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
	 * @param divdPckQty
	 */
	public void setDivdPckQty(String divdPckQty) {
		this.divdPckQty = divdPckQty;
	}

	/**
	 * Column Info
	 * @param preXptLicNo
	 */
	public void setPreXptLicNo(String preXptLicNo) {
		this.preXptLicNo = preXptLicNo;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
	}

	/**
	 * Column Info
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
	}

	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @param subNo
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	/**
	 * Column Info
	 * @param krCstmsBlTpCd
	 */
	public void setKrCstmsBlTpCd(String krCstmsBlTpCd) {
		this.krCstmsBlTpCd = krCstmsBlTpCd;
	}

	/**
	 * Column Info
	 * @param cgoDesc1
	 */
	public void setCgoDesc1(String cgoDesc1) {
		this.cgoDesc1 = cgoDesc1;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * @param preCntrNo
	 */
	public void setPreCntrNo(String preCntrNo) {
		this.preCntrNo = preCntrNo;
	}

	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
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
	 * @param cstmsOfcCtyCd
	 */
	public void setCstmsOfcCtyCd(String cstmsOfcCtyCd) {
		this.cstmsOfcCtyCd = cstmsOfcCtyCd;
	}

	/**
	 * Column Info
	 * @param krXptPckId
	 */
	public void setKrXptPckId(String krXptPckId) {
		this.krXptPckId = krXptPckId;
	}

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}

	/**
	 * Column Info
	 * @param prtLodgFlg
	 */
	public void setPrtLodgFlg(String prtLodgFlg) {
		this.prtLodgFlg = prtLodgFlg;
	}

	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}

	/**
	 * Column Info
	 * @param bdAreaCd
	 */
	public void setBdAreaCd(String bdAreaCd) {
		this.bdAreaCd = bdAreaCd;
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
	 * @param divdPckUtCd
	 */
	public void setDivdPckUtCd(String divdPckUtCd) {
		this.divdPckUtCd = divdPckUtCd;
	}

	/**
	 * Column Info
	 * @param prtLodgSeq
	 */
	public void setPrtLodgSeq(String prtLodgSeq) {
		this.prtLodgSeq = prtLodgSeq;
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
	 * @param sCustAddr
	 */
	public void setSCustAddr(String sCustAddr) {
		this.sCustAddr = sCustAddr;
	}

	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}

	/**
	 * Column Info
	 * @param crntCtnt1
	 */
	public void setCrntCtnt1(String crntCtnt1) {
		this.crntCtnt1 = crntCtnt1;
	}

	/**
	 * Column Info
	 * @param cntrTtlWgt
	 */
	public void setCntrTtlWgt(String cntrTtlWgt) {
		this.cntrTtlWgt = cntrTtlWgt;
	}

	/**
	 * Column Info
	 * @param crntCtnt2
	 */
	public void setCrntCtnt2(String crntCtnt2) {
		this.crntCtnt2 = crntCtnt2;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setKrCstmsDeptCd(JSPUtil.getParameter(request, "kr_cstms_dept_cd", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, "kr_cstms_corr_id", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setXptLicNo(JSPUtil.getParameter(request, "xpt_lic_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setNCustAddr(JSPUtil.getParameter(request, "n_cust_addr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDivdPckQty(JSPUtil.getParameter(request, "divd_pck_qty", ""));
		setPreXptLicNo(JSPUtil.getParameter(request, "pre_xpt_lic_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, "corr_rsn", ""));
		setCCustAddr(JSPUtil.getParameter(request, "c_cust_addr", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setSubNo(JSPUtil.getParameter(request, "sub_no", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, "kr_cstms_bl_tp_cd", ""));
		setCgoDesc1(JSPUtil.getParameter(request, "cgo_desc1", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPreCntrNo(JSPUtil.getParameter(request, "pre_cntr_no", ""));
		setNCustNm(JSPUtil.getParameter(request, "n_cust_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setCstmsOfcCtyCd(JSPUtil.getParameter(request, "cstms_ofc_cty_cd", ""));
		setKrXptPckId(JSPUtil.getParameter(request, "kr_xpt_pck_id", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
		setPrtLodgFlg(JSPUtil.getParameter(request, "prt_lodg_flg", ""));
		setCntrCnt(JSPUtil.getParameter(request, "cntr_cnt", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setDivdPckUtCd(JSPUtil.getParameter(request, "divd_pck_ut_cd", ""));
		setPrtLodgSeq(JSPUtil.getParameter(request, "prt_lodg_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSCustAddr(JSPUtil.getParameter(request, "s_cust_addr", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setCntrSealNo1(JSPUtil.getParameter(request, "cntr_seal_no1", ""));
		setCntrSealNo2(JSPUtil.getParameter(request, "cntr_seal_no2", ""));
		setCrntCtnt1(JSPUtil.getParameter(request, "crnt_ctnt1", ""));
		setCntrTtlWgt(JSPUtil.getParameter(request, "cntr_ttl_wgt", ""));
		setCrntCtnt2(JSPUtil.getParameter(request, "crnt_ctnt2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCusmodVO[]
	 */
	public KorCusmodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCusmodVO[]
	 */
	public KorCusmodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCusmodVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] krCstmsDeptCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_dept_cd", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] divdPckQty = (JSPUtil.getParameter(request, prefix	+ "divd_pck_qty", length));
			String[] preXptLicNo = (JSPUtil.getParameter(request, prefix	+ "pre_xpt_lic_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] cgoDesc1 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc1", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] preCntrNo = (JSPUtil.getParameter(request, prefix	+ "pre_cntr_no", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cstmsOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ofc_cty_cd", length));
			String[] krXptPckId = (JSPUtil.getParameter(request, prefix	+ "kr_xpt_pck_id", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] prtLodgFlg = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_flg", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] divdPckUtCd = (JSPUtil.getParameter(request, prefix	+ "divd_pck_ut_cd", length));
			String[] prtLodgSeq = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] cntrSealNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no1", length));
			String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no2", length));
			String[] crntCtnt1 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt1", length));
			String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
			String[] crntCtnt2 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt2", length));

			for (int i = 0; i < length; i++) {
				model = new KorCusmodVO();
				if (krCstmsDeptCd[i] != null)
					model.setKrCstmsDeptCd(krCstmsDeptCd[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (divdPckQty[i] != null)
					model.setDivdPckQty(divdPckQty[i]);
				if (preXptLicNo[i] != null)
					model.setPreXptLicNo(preXptLicNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (cgoDesc1[i] != null)
					model.setCgoDesc1(cgoDesc1[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (preCntrNo[i] != null)
					model.setPreCntrNo(preCntrNo[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (cstmsOfcCtyCd[i] != null)
					model.setCstmsOfcCtyCd(cstmsOfcCtyCd[i]);
				if (krXptPckId[i] != null)
					model.setKrXptPckId(krXptPckId[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (prtLodgFlg[i] != null)
					model.setPrtLodgFlg(prtLodgFlg[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (divdPckUtCd[i] != null)
					model.setDivdPckUtCd(divdPckUtCd[i]);
				if (prtLodgSeq[i] != null)
					model.setPrtLodgSeq(prtLodgSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (cntrSealNo1[i] != null)
					model.setCntrSealNo1(cntrSealNo1[i]);
				if (cntrSealNo2[i] != null)
					model.setCntrSealNo2(cntrSealNo2[i]);
				if (crntCtnt1[i] != null)
					model.setCrntCtnt1(crntCtnt1[i]);
				if (cntrTtlWgt[i] != null)
					model.setCntrTtlWgt(cntrTtlWgt[i]);
				if (crntCtnt2[i] != null)
					model.setCrntCtnt2(crntCtnt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCusmodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCusmodVO[]
	 */
	public KorCusmodVO[] getKorCusmodVOs(){
		KorCusmodVO[] vos = (KorCusmodVO[])models.toArray(new KorCusmodVO[models.size()]);
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
		this.krCstmsDeptCd = this.krCstmsDeptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckQty = this.divdPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preXptLicNo = this.preXptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc1 = this.cgoDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCntrNo = this.preCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsOfcCtyCd = this.cstmsOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krXptPckId = this.krXptPckId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgFlg = this.prtLodgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckUtCd = this.divdPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgSeq = this.prtLodgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo1 = this.cntrSealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo2 = this.cntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt1 = this.crntCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt2 = this.crntCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
