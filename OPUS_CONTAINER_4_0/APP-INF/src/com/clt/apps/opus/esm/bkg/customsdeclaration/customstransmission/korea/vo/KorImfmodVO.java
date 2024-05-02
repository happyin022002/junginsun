/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorImfmodVO.java
*@FileTitle : KorImfmodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.09 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorImfmodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorImfmodVO> models = new ArrayList<KorImfmodVO>();

	/* Column Info */
	private String newDatCtnt = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String krWhCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String preCtnt1 = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String cgoDesc2 = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String krCstmsWhTpCd = null;
	/* Column Info */
	private String cgoDesc1 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String userName = null;
	/* Column Info */
	private String cntrSealNo1 = null;
	/* Column Info */
	private String preCtnt2 = null;
	/* Column Info */
	private String cntrSealNo2 = null;
	/* Column Info */
	private String bizNo = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String n2ndImdgClssCd = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String frtFwrdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String deptCd = null;
	/* Column Info */
	private String n3rdImdgClssCd = null;
	/* Column Info */
	private String krCstmsCorrId2 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String preDatCtnt = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String crntCtnt1 = null;
	/* Column Info */
	private String cntrTtlWgt = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String crntCtnt2 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorImfmodVO() {}

	public KorImfmodVO(String ibflag, String pagerows, String subNo, String ofcCd, String deptCd, String userName, String krCstmsCorrId, String corrRsn, String msnNo, String blNo, String krCstmsBlTpCd, String frtFwrdCd, String bkgCgoTpCd, String polCd, String podCd, String bdAreaCd, String krCstmsWhTpCd, String krWhCd, String pckQty, String pckTpCd, String cgoDesc1, String cgoDesc2, String imdgClssCd, String n2ndImdgClssCd, String n3rdImdgClssCd, String cntrTtlWgt, String measQty, String sCustNm, String sCustAddr, String cCustNm, String cCustAddr, String nCustNm, String nCustAddr, String bizNo, String cntrNo, String cntrTpszCd, String krCstmsCorrId2, String preDatCtnt, String newDatCtnt, String cntrSealNo, String cntrSealNo1, String cntrSealNo2, String crntCtnt1, String crntCtnt2, String preCtnt1, String preCtnt2, String cstmsDeclTpCd) {
		this.newDatCtnt = newDatCtnt;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.cCustNm = cCustNm;
		this.krCstmsCorrId = krCstmsCorrId;
		this.msnNo = msnNo;
		this.blNo = blNo;
		this.nCustAddr = nCustAddr;
		this.pagerows = pagerows;
		this.krWhCd = krWhCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cCustAddr = cCustAddr;
		this.corrRsn = corrRsn;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.preCtnt1 = preCtnt1;
		this.subNo = subNo;
		this.cgoDesc2 = cgoDesc2;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.krCstmsWhTpCd = krCstmsWhTpCd;
		this.cgoDesc1 = cgoDesc1;
		this.cntrTpszCd = cntrTpszCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.userName = userName;
		this.cntrSealNo1 = cntrSealNo1;
		this.preCtnt2 = preCtnt2;
		this.cntrSealNo2 = cntrSealNo2;
		this.bizNo = bizNo;
		this.nCustNm = nCustNm;
		this.pckTpCd = pckTpCd;
		this.sCustNm = sCustNm;
		this.n2ndImdgClssCd = n2ndImdgClssCd;
		this.bdAreaCd = bdAreaCd;
		this.frtFwrdCd = frtFwrdCd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.deptCd = deptCd;
		this.n3rdImdgClssCd = n3rdImdgClssCd;
		this.krCstmsCorrId2 = krCstmsCorrId2;
		this.cntrNo = cntrNo;
		this.preDatCtnt = preDatCtnt;
		this.sCustAddr = sCustAddr;
		this.cntrSealNo = cntrSealNo;
		this.crntCtnt1 = crntCtnt1;
		this.cntrTtlWgt = cntrTtlWgt;
		this.imdgClssCd = imdgClssCd;
		this.crntCtnt2 = crntCtnt2;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_dat_ctnt", getNewDatCtnt());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kr_wh_cd", getKrWhCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("pre_ctnt1", getPreCtnt1());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("cgo_desc2", getCgoDesc2());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("kr_cstms_wh_tp_cd", getKrCstmsWhTpCd());
		this.hashColumns.put("cgo_desc1", getCgoDesc1());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("user_name", getUserName());
		this.hashColumns.put("cntr_seal_no1", getCntrSealNo1());
		this.hashColumns.put("pre_ctnt2", getPreCtnt2());
		this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
		this.hashColumns.put("biz_no", getBizNo());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("n2nd_imdg_clss_cd", getN2ndImdgClssCd());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("frt_fwrd_cd", getFrtFwrdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("dept_cd", getDeptCd());
		this.hashColumns.put("n3rd_imdg_clss_cd", getN3rdImdgClssCd());
		this.hashColumns.put("kr_cstms_corr_id2", getKrCstmsCorrId2());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pre_dat_ctnt", getPreDatCtnt());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("crnt_ctnt1", getCrntCtnt1());
		this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("crnt_ctnt2", getCrntCtnt2());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_dat_ctnt", "newDatCtnt");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kr_wh_cd", "krWhCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("pre_ctnt1", "preCtnt1");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("cgo_desc2", "cgoDesc2");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("kr_cstms_wh_tp_cd", "krCstmsWhTpCd");
		this.hashFields.put("cgo_desc1", "cgoDesc1");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("user_name", "userName");
		this.hashFields.put("cntr_seal_no1", "cntrSealNo1");
		this.hashFields.put("pre_ctnt2", "preCtnt2");
		this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
		this.hashFields.put("biz_no", "bizNo");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("n2nd_imdg_clss_cd", "n2ndImdgClssCd");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("frt_fwrd_cd", "frtFwrdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("dept_cd", "deptCd");
		this.hashFields.put("n3rd_imdg_clss_cd", "n3rdImdgClssCd");
		this.hashFields.put("kr_cstms_corr_id2", "krCstmsCorrId2");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pre_dat_ctnt", "preDatCtnt");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("crnt_ctnt1", "crntCtnt1");
		this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("crnt_ctnt2", "crntCtnt2");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return newDatCtnt
	 */
	public String getNewDatCtnt() {
		return this.newDatCtnt;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return krCstmsCorrId
	 */
	public String getKrCstmsCorrId() {
		return this.krCstmsCorrId;
	}

	/**
	 * Column Info
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
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
	 * @return krWhCd
	 */
	public String getKrWhCd() {
		return this.krWhCd;
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
	 * @return cCustAddr
	 */
	public String getCCustAddr() {
		return this.cCustAddr;
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
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @return preCtnt1
	 */
	public String getPreCtnt1() {
		return this.preCtnt1;
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
	 * @return cgoDesc2
	 */
	public String getCgoDesc2() {
		return this.cgoDesc2;
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
	 * @return krCstmsWhTpCd
	 */
	public String getKrCstmsWhTpCd() {
		return this.krCstmsWhTpCd;
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
	 * @return userName
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * Column Info
	 * @return cntrSealNo1
	 */
	public String getCntrSealNo1() {
		return this.cntrSealNo1;
	}

	/**
	 * Column Info
	 * @return preCtnt2
	 */
	public String getPreCtnt2() {
		return this.preCtnt2;
	}

	/**
	 * Column Info
	 * @return cntrSealNo2
	 */
	public String getCntrSealNo2() {
		return this.cntrSealNo2;
	}

	/**
	 * Column Info
	 * @return bizNo
	 */
	public String getBizNo() {
		return this.bizNo;
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
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}

	/**
	 * Column Info
	 * @return n2ndImdgClssCd
	 */
	public String getN2ndImdgClssCd() {
		return this.n2ndImdgClssCd;
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
	 * @return frtFwrdCd
	 */
	public String getFrtFwrdCd() {
		return this.frtFwrdCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}

	/**
	 * Column Info
	 * @return deptCd
	 */
	public String getDeptCd() {
		return this.deptCd;
	}

	/**
	 * Column Info
	 * @return n3rdImdgClssCd
	 */
	public String getN3rdImdgClssCd() {
		return this.n3rdImdgClssCd;
	}

	/**
	 * Column Info
	 * @return krCstmsCorrId2
	 */
	public String getKrCstmsCorrId2() {
		return this.krCstmsCorrId2;
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
	 * @return preDatCtnt
	 */
	public String getPreDatCtnt() {
		return this.preDatCtnt;
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
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
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
	 * @param newDatCtnt
	 */
	public void setNewDatCtnt(String newDatCtnt) {
		this.newDatCtnt = newDatCtnt;
	}

	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param krCstmsCorrId
	 */
	public void setKrCstmsCorrId(String krCstmsCorrId) {
		this.krCstmsCorrId = krCstmsCorrId;
	}

	/**
	 * Column Info
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
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
	 * @param krWhCd
	 */
	public void setKrWhCd(String krWhCd) {
		this.krWhCd = krWhCd;
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
	 * @param cCustAddr
	 */
	public void setCCustAddr(String cCustAddr) {
		this.cCustAddr = cCustAddr;
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
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @param preCtnt1
	 */
	public void setPreCtnt1(String preCtnt1) {
		this.preCtnt1 = preCtnt1;
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
	 * @param cgoDesc2
	 */
	public void setCgoDesc2(String cgoDesc2) {
		this.cgoDesc2 = cgoDesc2;
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
	 * @param krCstmsWhTpCd
	 */
	public void setKrCstmsWhTpCd(String krCstmsWhTpCd) {
		this.krCstmsWhTpCd = krCstmsWhTpCd;
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
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Column Info
	 * @param cntrSealNo1
	 */
	public void setCntrSealNo1(String cntrSealNo1) {
		this.cntrSealNo1 = cntrSealNo1;
	}

	/**
	 * Column Info
	 * @param preCtnt2
	 */
	public void setPreCtnt2(String preCtnt2) {
		this.preCtnt2 = preCtnt2;
	}

	/**
	 * Column Info
	 * @param cntrSealNo2
	 */
	public void setCntrSealNo2(String cntrSealNo2) {
		this.cntrSealNo2 = cntrSealNo2;
	}

	/**
	 * Column Info
	 * @param bizNo
	 */
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
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
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}

	/**
	 * Column Info
	 * @param n2ndImdgClssCd
	 */
	public void setN2ndImdgClssCd(String n2ndImdgClssCd) {
		this.n2ndImdgClssCd = n2ndImdgClssCd;
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
	 * @param frtFwrdCd
	 */
	public void setFrtFwrdCd(String frtFwrdCd) {
		this.frtFwrdCd = frtFwrdCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * Column Info
	 * @param deptCd
	 */
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}

	/**
	 * Column Info
	 * @param n3rdImdgClssCd
	 */
	public void setN3rdImdgClssCd(String n3rdImdgClssCd) {
		this.n3rdImdgClssCd = n3rdImdgClssCd;
	}

	/**
	 * Column Info
	 * @param krCstmsCorrId2
	 */
	public void setKrCstmsCorrId2(String krCstmsCorrId2) {
		this.krCstmsCorrId2 = krCstmsCorrId2;
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
	 * @param preDatCtnt
	 */
	public void setPreDatCtnt(String preDatCtnt) {
		this.preDatCtnt = preDatCtnt;
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
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setNewDatCtnt(JSPUtil.getParameter(request, prefix + "new_dat_ctnt", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, prefix + "kr_cstms_corr_id", ""));
		setMsnNo(JSPUtil.getParameter(request, prefix + "msn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setNCustAddr(JSPUtil.getParameter(request, prefix + "n_cust_addr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setKrWhCd(JSPUtil.getParameter(request, prefix + "kr_wh_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCCustAddr(JSPUtil.getParameter(request, prefix + "c_cust_addr", ""));
		setCorrRsn(JSPUtil.getParameter(request, prefix + "corr_rsn", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setPreCtnt1(JSPUtil.getParameter(request, prefix + "pre_ctnt1", ""));
		setSubNo(JSPUtil.getParameter(request, prefix + "sub_no", ""));
		setCgoDesc2(JSPUtil.getParameter(request, prefix + "cgo_desc2", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_bl_tp_cd", ""));
		setKrCstmsWhTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_wh_tp_cd", ""));
		setCgoDesc1(JSPUtil.getParameter(request, prefix + "cgo_desc1", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setUserName(JSPUtil.getParameter(request, prefix + "user_name", ""));
		setCntrSealNo1(JSPUtil.getParameter(request, prefix + "cntr_seal_no1", ""));
		setPreCtnt2(JSPUtil.getParameter(request, prefix + "pre_ctnt2", ""));
		setCntrSealNo2(JSPUtil.getParameter(request, prefix + "cntr_seal_no2", ""));
		setBizNo(JSPUtil.getParameter(request, prefix + "biz_no", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setN2ndImdgClssCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_clss_cd", ""));
		setBdAreaCd(JSPUtil.getParameter(request, prefix + "bd_area_cd", ""));
		setFrtFwrdCd(JSPUtil.getParameter(request, prefix + "frt_fwrd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDeptCd(JSPUtil.getParameter(request, prefix + "dept_cd", ""));
		setN3rdImdgClssCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_clss_cd", ""));
		setKrCstmsCorrId2(JSPUtil.getParameter(request, prefix + "kr_cstms_corr_id2", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPreDatCtnt(JSPUtil.getParameter(request, prefix + "pre_dat_ctnt", ""));
		setSCustAddr(JSPUtil.getParameter(request, prefix + "s_cust_addr", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCrntCtnt1(JSPUtil.getParameter(request, prefix + "crnt_ctnt1", ""));
		setCntrTtlWgt(JSPUtil.getParameter(request, prefix + "cntr_ttl_wgt", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setCrntCtnt2(JSPUtil.getParameter(request, prefix + "crnt_ctnt2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorImfmodVO[]
	 */
	public KorImfmodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorImfmodVO[]
	 */
	public KorImfmodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorImfmodVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] newDatCtnt = (JSPUtil.getParameter(request, prefix	+ "new_dat_ctnt", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] krWhCd = (JSPUtil.getParameter(request, prefix	+ "kr_wh_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] preCtnt1 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt1", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] cgoDesc2 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc2", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] krCstmsWhTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_wh_tp_cd", length));
			String[] cgoDesc1 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc1", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] userName = (JSPUtil.getParameter(request, prefix	+ "user_name", length));
			String[] cntrSealNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no1", length));
			String[] preCtnt2 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt2", length));
			String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no2", length));
			String[] bizNo = (JSPUtil.getParameter(request, prefix	+ "biz_no", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] n2ndImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_clss_cd", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] frtFwrdCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] deptCd = (JSPUtil.getParameter(request, prefix	+ "dept_cd", length));
			String[] n3rdImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_clss_cd", length));
			String[] krCstmsCorrId2 = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id2", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] preDatCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_dat_ctnt", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] crntCtnt1 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt1", length));
			String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] crntCtnt2 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt2", length));

			for (int i = 0; i < length; i++) {
				model = new KorImfmodVO();
				if (newDatCtnt[i] != null)
					model.setNewDatCtnt(newDatCtnt[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (krWhCd[i] != null)
					model.setKrWhCd(krWhCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (preCtnt1[i] != null)
					model.setPreCtnt1(preCtnt1[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (cgoDesc2[i] != null)
					model.setCgoDesc2(cgoDesc2[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (krCstmsWhTpCd[i] != null)
					model.setKrCstmsWhTpCd(krCstmsWhTpCd[i]);
				if (cgoDesc1[i] != null)
					model.setCgoDesc1(cgoDesc1[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (userName[i] != null)
					model.setUserName(userName[i]);
				if (cntrSealNo1[i] != null)
					model.setCntrSealNo1(cntrSealNo1[i]);
				if (preCtnt2[i] != null)
					model.setPreCtnt2(preCtnt2[i]);
				if (cntrSealNo2[i] != null)
					model.setCntrSealNo2(cntrSealNo2[i]);
				if (bizNo[i] != null)
					model.setBizNo(bizNo[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (n2ndImdgClssCd[i] != null)
					model.setN2ndImdgClssCd(n2ndImdgClssCd[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (frtFwrdCd[i] != null)
					model.setFrtFwrdCd(frtFwrdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (deptCd[i] != null)
					model.setDeptCd(deptCd[i]);
				if (n3rdImdgClssCd[i] != null)
					model.setN3rdImdgClssCd(n3rdImdgClssCd[i]);
				if (krCstmsCorrId2[i] != null)
					model.setKrCstmsCorrId2(krCstmsCorrId2[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (preDatCtnt[i] != null)
					model.setPreDatCtnt(preDatCtnt[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (crntCtnt1[i] != null)
					model.setCrntCtnt1(crntCtnt1[i]);
				if (cntrTtlWgt[i] != null)
					model.setCntrTtlWgt(cntrTtlWgt[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (crntCtnt2[i] != null)
					model.setCrntCtnt2(crntCtnt2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorImfmodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorImfmodVO[]
	 */
	public KorImfmodVO[] getKorImfmodVOs(){
		KorImfmodVO[] vos = (KorImfmodVO[])models.toArray(new KorImfmodVO[models.size()]);
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
		this.newDatCtnt = this.newDatCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhCd = this.krWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt1 = this.preCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc2 = this.cgoDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsWhTpCd = this.krCstmsWhTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc1 = this.cgoDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userName = this.userName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo1 = this.cntrSealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt2 = this.preCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo2 = this.cntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizNo = this.bizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgClssCd = this.n2ndImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCd = this.frtFwrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deptCd = this.deptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgClssCd = this.n3rdImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId2 = this.krCstmsCorrId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preDatCtnt = this.preDatCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt1 = this.crntCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt2 = this.crntCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
