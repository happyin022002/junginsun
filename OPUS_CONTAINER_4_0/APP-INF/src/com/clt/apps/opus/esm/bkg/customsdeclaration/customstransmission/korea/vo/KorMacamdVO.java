/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorMacamdVO.java
*@FileTitle : KorMacamdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.09 박상훈
* 1.0 Creation
* 2011.03.30 손은주 [CHM-201109081-01]	MANIFEST AMEND PA(항만청) B/L 추가시 문서명 오류 정정 요청
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

public class KorMacamdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorMacamdVO> models = new ArrayList<KorMacamdVO>();

	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String ttlMeasUtCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String unPolCd = null;
	/* Column Info */
	private String cgoDesc2 = null;
	/* Column Info */
	private String cgoDesc1 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String preCntrNo = null;
	/* Column Info */
	private String vslCallSgnCd = null;
	/* Column Info */
	private String cntrSealNo1 = null;
	/* Column Info */
	private String cntrSealNo2 = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String krMeasUtCd = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String ttlMeasQty = null;
	/* Column Info */
	private String sCustAddr = null;
	/* Column Info */
	private String cntrTtlWgt = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String nCustAddr = null;
	/* Column Info */
	private String callYear = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String cCustAddr = null;
	/* Column Info */
	private String preCtnt1 = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String preCtnt2 = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String bizNo = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String unPodCd = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String ioTmlLocCd = null;
	/* Column Info */
	private String n2ndImdgClssCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String n3rdImdgClssCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ttlPckUtCd = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String crntCtnt1 = null;
	/* Column Info */
	private String crntCtnt2 = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorMacamdVO() {}

	public KorMacamdVO(String ibflag, String pagerows, String ktPa, String ioBndCd, String callYear, String vslCallSgnCd, String mrnNo, String vvd, String vslNm, String vslCntCd, String blNo, String callKnt, String dchgMzdCd, String unPolCd, String unPodCd, String ioTmlLocCd, String bdAreaCd, String ttlPckUtCd, String ttlWgt, String ttlMeasUtCd, String ttlMeasQty, String msnNo, String krCstmsCorrId, String krCstmsBlTpCd, String bkgCgoTpCd, String polCd, String polLoc, String podCd, String podLoc, String pckTpCd, String cmdtCd, String cgoDesc1, String cgoDesc2, String imdgClssCd, String n2ndImdgClssCd, String n3rdImdgClssCd, String cntrTtlWgt, String measUtCd, String measQty, String sCustNm, String sCustAddr, String cCustNm, String cCustAddr, String nCustNm, String nCustAddr, String bizNo, String cntrWgt, String cntrSealNo, String cntrSealNo1, String cntrSealNo2, String cntrNo, String preCntrNo, String cntrTpszCd, String crntCtnt1, String crntCtnt2, String preCtnt1, String preCtnt2, String corrRsn, String krMeasUtCd, String cstmsDeclTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.msnNo = msnNo;
		this.ttlMeasUtCd = ttlMeasUtCd;
		this.mrnNo = mrnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.polLoc = polLoc;
		this.unPolCd = unPolCd;
		this.cgoDesc2 = cgoDesc2;
		this.cgoDesc1 = cgoDesc1;
		this.cntrTpszCd = cntrTpszCd;
		this.preCntrNo = preCntrNo;
		this.vslCallSgnCd = vslCallSgnCd;
		this.cntrSealNo1 = cntrSealNo1;
		this.cntrSealNo2 = cntrSealNo2;
		this.cntrWgt = cntrWgt;
		this.dchgMzdCd = dchgMzdCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.podLoc = podLoc;
		this.krMeasUtCd = krMeasUtCd;
		this.ttlWgt = ttlWgt;
		this.ttlMeasQty = ttlMeasQty;
		this.sCustAddr = sCustAddr;
		this.cntrTtlWgt = cntrTtlWgt;
		this.imdgClssCd = imdgClssCd;
		this.krCstmsCorrId = krCstmsCorrId;
		this.cCustNm = cCustNm;
		this.nCustAddr = nCustAddr;
		this.callYear = callYear;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.cCustAddr = cCustAddr;
		this.preCtnt1 = preCtnt1;
		this.cmdtCd = cmdtCd;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.measQty = measQty;
		this.callKnt = callKnt;
		this.preCtnt2 = preCtnt2;
		this.nCustNm = nCustNm;
		this.bizNo = bizNo;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.vslCntCd = vslCntCd;
		this.unPodCd = unPodCd;
		this.sCustNm = sCustNm;
		this.ioTmlLocCd = ioTmlLocCd;
		this.n2ndImdgClssCd = n2ndImdgClssCd;
		this.vslNm = vslNm;
		this.bdAreaCd = bdAreaCd;
		this.ioBndCd = ioBndCd;
		this.n3rdImdgClssCd = n3rdImdgClssCd;
		this.cntrNo = cntrNo;
		this.ttlPckUtCd = ttlPckUtCd;
		this.ktPa = ktPa;
		this.cntrSealNo = cntrSealNo;
		this.crntCtnt1 = crntCtnt1;
		this.crntCtnt2 = crntCtnt2;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("ttl_meas_ut_cd", getTtlMeasUtCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("un_pol_cd", getUnPolCd());
		this.hashColumns.put("cgo_desc2", getCgoDesc2());
		this.hashColumns.put("cgo_desc1", getCgoDesc1());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pre_cntr_no", getPreCntrNo());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("cntr_seal_no1", getCntrSealNo1());
		this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("kr_meas_ut_cd", getKrMeasUtCd());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("ttl_meas_qty", getTtlMeasQty());
		this.hashColumns.put("s_cust_addr", getSCustAddr());
		this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("n_cust_addr", getNCustAddr());
		this.hashColumns.put("call_year", getCallYear());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("c_cust_addr", getCCustAddr());
		this.hashColumns.put("pre_ctnt1", getPreCtnt1());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("pre_ctnt2", getPreCtnt2());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("biz_no", getBizNo());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("un_pod_cd", getUnPodCd());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("n2nd_imdg_clss_cd", getN2ndImdgClssCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("n3rd_imdg_clss_cd", getN3rdImdgClssCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ttl_pck_ut_cd", getTtlPckUtCd());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("crnt_ctnt1", getCrntCtnt1());
		this.hashColumns.put("crnt_ctnt2", getCrntCtnt2());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("ttl_meas_ut_cd", "ttlMeasUtCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("un_pol_cd", "unPolCd");
		this.hashFields.put("cgo_desc2", "cgoDesc2");
		this.hashFields.put("cgo_desc1", "cgoDesc1");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pre_cntr_no", "preCntrNo");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("cntr_seal_no1", "cntrSealNo1");
		this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("kr_meas_ut_cd", "krMeasUtCd");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("ttl_meas_qty", "ttlMeasQty");
		this.hashFields.put("s_cust_addr", "sCustAddr");
		this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("n_cust_addr", "nCustAddr");
		this.hashFields.put("call_year", "callYear");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("c_cust_addr", "cCustAddr");
		this.hashFields.put("pre_ctnt1", "preCtnt1");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("pre_ctnt2", "preCtnt2");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("biz_no", "bizNo");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("un_pod_cd", "unPodCd");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("n2nd_imdg_clss_cd", "n2ndImdgClssCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("n3rd_imdg_clss_cd", "n3rdImdgClssCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ttl_pck_ut_cd", "ttlPckUtCd");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("crnt_ctnt1", "crntCtnt1");
		this.hashFields.put("crnt_ctnt2", "crntCtnt2");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		return this.hashFields;
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
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
	}

	/**
	 * Column Info
	 * @return ttlMeasUtCd
	 */
	public String getTtlMeasUtCd() {
		return this.ttlMeasUtCd;
	}

	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return unPolCd
	 */
	public String getUnPolCd() {
		return this.unPolCd;
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
	 * @return preCntrNo
	 */
	public String getPreCntrNo() {
		return this.preCntrNo;
	}

	/**
	 * Column Info
	 * @return vslCallSgnCd
	 */
	public String getVslCallSgnCd() {
		return this.vslCallSgnCd;
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
	 * @return cntrSealNo2
	 */
	public String getCntrSealNo2() {
		return this.cntrSealNo2;
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
	 * @return dchgMzdCd
	 */
	public String getDchgMzdCd() {
		return this.dchgMzdCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return krMeasUtCd
	 */
	public String getKrMeasUtCd() {
		return this.krMeasUtCd;
	}

	/**
	 * Column Info
	 * @return ttlWgt
	 */
	public String getTtlWgt() {
		return this.ttlWgt;
	}

	/**
	 * Column Info
	 * @return ttlMeasQty
	 */
	public String getTtlMeasQty() {
		return this.ttlMeasQty;
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
	 * @return nCustAddr
	 */
	public String getNCustAddr() {
		return this.nCustAddr;
	}

	/**
	 * Column Info
	 * @return callYear
	 */
	public String getCallYear() {
		return this.callYear;
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
	 * @return preCtnt1
	 */
	public String getPreCtnt1() {
		return this.preCtnt1;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}

	/**
	 * Column Info
	 * @return callKnt
	 */
	public String getCallKnt() {
		return this.callKnt;
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
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
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
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}

	/**
	 * Column Info
	 * @return unPodCd
	 */
	public String getUnPodCd() {
		return this.unPodCd;
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
	 * @return ioTmlLocCd
	 */
	public String getIoTmlLocCd() {
		return this.ioTmlLocCd;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return ttlPckUtCd
	 */
	public String getTtlPckUtCd() {
		return this.ttlPckUtCd;
	}

	/**
	 * Column Info
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
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
	 * @return crntCtnt2
	 */
	public String getCrntCtnt2() {
		return this.crntCtnt2;
	}

	/**
	 * @return the polLoc
	 */
	public String getPolLoc() {
		return polLoc;
	}

	/**
	 * @return the podLoc
	 */
	public String getPodLoc() {
		return podLoc;
	}

	/**
	 * @return the cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return cstmsDeclTpCd;
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
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
	}

	/**
	 * Column Info
	 * @param ttlMeasUtCd
	 */
	public void setTtlMeasUtCd(String ttlMeasUtCd) {
		this.ttlMeasUtCd = ttlMeasUtCd;
	}

	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param unPolCd
	 */
	public void setUnPolCd(String unPolCd) {
		this.unPolCd = unPolCd;
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
	 * @param preCntrNo
	 */
	public void setPreCntrNo(String preCntrNo) {
		this.preCntrNo = preCntrNo;
	}

	/**
	 * Column Info
	 * @param vslCallSgnCd
	 */
	public void setVslCallSgnCd(String vslCallSgnCd) {
		this.vslCallSgnCd = vslCallSgnCd;
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
	 * @param cntrSealNo2
	 */
	public void setCntrSealNo2(String cntrSealNo2) {
		this.cntrSealNo2 = cntrSealNo2;
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
	 * @param dchgMzdCd
	 */
	public void setDchgMzdCd(String dchgMzdCd) {
		this.dchgMzdCd = dchgMzdCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param krMeasUtCd
	 */
	public void setKrMeasUtCd(String krMeasUtCd) {
		this.krMeasUtCd = krMeasUtCd;
	}

	/**
	 * Column Info
	 * @param ttlWgt
	 */
	public void setTtlWgt(String ttlWgt) {
		this.ttlWgt = ttlWgt;
	}

	/**
	 * Column Info
	 * @param ttlMeasQty
	 */
	public void setTtlMeasQty(String ttlMeasQty) {
		this.ttlMeasQty = ttlMeasQty;
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
	 * @param nCustAddr
	 */
	public void setNCustAddr(String nCustAddr) {
		this.nCustAddr = nCustAddr;
	}

	/**
	 * Column Info
	 * @param callYear
	 */
	public void setCallYear(String callYear) {
		this.callYear = callYear;
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
	 * @param preCtnt1
	 */
	public void setPreCtnt1(String preCtnt1) {
		this.preCtnt1 = preCtnt1;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}

	/**
	 * Column Info
	 * @param callKnt
	 */
	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
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
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
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
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}

	/**
	 * Column Info
	 * @param unPodCd
	 */
	public void setUnPodCd(String unPodCd) {
		this.unPodCd = unPodCd;
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
	 * @param ioTmlLocCd
	 */
	public void setIoTmlLocCd(String ioTmlLocCd) {
		this.ioTmlLocCd = ioTmlLocCd;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param ttlPckUtCd
	 */
	public void setTtlPckUtCd(String ttlPckUtCd) {
		this.ttlPckUtCd = ttlPckUtCd;
	}

	/**
	 * Column Info
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
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
	 * @param crntCtnt2
	 */
	public void setCrntCtnt2(String crntCtnt2) {
		this.crntCtnt2 = crntCtnt2;
	}

	/**
	 * @param polLoc the polLoc to set
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}

	/**
	 * @param podLoc the podLoc to set
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}

	/**
	 * @param cstmsDeclTpCd the cstmsDeclTpCd to set
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
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
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setMsnNo(JSPUtil.getParameter(request, prefix + "msn_no", ""));
		setTtlMeasUtCd(JSPUtil.getParameter(request, prefix + "ttl_meas_ut_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPolLoc(JSPUtil.getParameter(request, prefix + "pol_loc", ""));
		setUnPolCd(JSPUtil.getParameter(request, prefix + "un_pol_cd", ""));
		setCgoDesc2(JSPUtil.getParameter(request, prefix + "cgo_desc2", ""));
		setCgoDesc1(JSPUtil.getParameter(request, prefix + "cgo_desc1", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPreCntrNo(JSPUtil.getParameter(request, prefix + "pre_cntr_no", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, prefix + "vsl_call_sgn_cd", ""));
		setCntrSealNo1(JSPUtil.getParameter(request, prefix + "cntr_seal_no1", ""));
		setCntrSealNo2(JSPUtil.getParameter(request, prefix + "cntr_seal_no2", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, prefix + "dchg_mzd_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPodLoc(JSPUtil.getParameter(request, prefix + "pod_loc", ""));
		setKrMeasUtCd(JSPUtil.getParameter(request, prefix + "kr_meas_ut_cd", ""));
		setTtlWgt(JSPUtil.getParameter(request, prefix + "ttl_wgt", ""));
		setTtlMeasQty(JSPUtil.getParameter(request, prefix + "ttl_meas_qty", ""));
		setSCustAddr(JSPUtil.getParameter(request, prefix + "s_cust_addr", ""));
		setCntrTtlWgt(JSPUtil.getParameter(request, prefix + "cntr_ttl_wgt", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, prefix + "kr_cstms_corr_id", ""));
		setCCustNm(JSPUtil.getParameter(request, prefix + "c_cust_nm", ""));
		setNCustAddr(JSPUtil.getParameter(request, prefix + "n_cust_addr", ""));
		setCallYear(JSPUtil.getParameter(request, prefix + "call_year", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, prefix + "corr_rsn", ""));
		setCCustAddr(JSPUtil.getParameter(request, prefix + "c_cust_addr", ""));
		setPreCtnt1(JSPUtil.getParameter(request, prefix + "pre_ctnt1", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, prefix + "kr_cstms_bl_tp_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setCallKnt(JSPUtil.getParameter(request, prefix + "call_knt", ""));
		setPreCtnt2(JSPUtil.getParameter(request, prefix + "pre_ctnt2", ""));
		setNCustNm(JSPUtil.getParameter(request, prefix + "n_cust_nm", ""));
		setBizNo(JSPUtil.getParameter(request, prefix + "biz_no", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, prefix + "vsl_cnt_cd", ""));
		setUnPodCd(JSPUtil.getParameter(request, prefix + "un_pod_cd", ""));
		setSCustNm(JSPUtil.getParameter(request, prefix + "s_cust_nm", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, prefix + "io_tml_loc_cd", ""));
		setN2ndImdgClssCd(JSPUtil.getParameter(request, prefix + "n2nd_imdg_clss_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setBdAreaCd(JSPUtil.getParameter(request, prefix + "bd_area_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setN3rdImdgClssCd(JSPUtil.getParameter(request, prefix + "n3rd_imdg_clss_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTtlPckUtCd(JSPUtil.getParameter(request, prefix + "ttl_pck_ut_cd", ""));
		setKtPa(JSPUtil.getParameter(request, prefix + "kt_pa", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCrntCtnt1(JSPUtil.getParameter(request, prefix + "crnt_ctnt1", ""));
		setCrntCtnt2(JSPUtil.getParameter(request, prefix + "crnt_ctnt2", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMacamdVO[]
	 */
	public KorMacamdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorMacamdVO[]
	 */
	public KorMacamdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMacamdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] ttlMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_ut_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] unPolCd = (JSPUtil.getParameter(request, prefix	+ "un_pol_cd", length));
			String[] cgoDesc2 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc2", length));
			String[] cgoDesc1 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc1", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] preCntrNo = (JSPUtil.getParameter(request, prefix	+ "pre_cntr_no", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] cntrSealNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no1", length));
			String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no2", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] krMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "kr_meas_ut_cd", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] ttlMeasQty = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_qty", length));
			String[] sCustAddr = (JSPUtil.getParameter(request, prefix	+ "s_cust_addr", length));
			String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] nCustAddr = (JSPUtil.getParameter(request, prefix	+ "n_cust_addr", length));
			String[] callYear = (JSPUtil.getParameter(request, prefix	+ "call_year", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] cCustAddr = (JSPUtil.getParameter(request, prefix	+ "c_cust_addr", length));
			String[] preCtnt1 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt1", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] preCtnt2 = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt2", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] bizNo = (JSPUtil.getParameter(request, prefix	+ "biz_no", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] unPodCd = (JSPUtil.getParameter(request, prefix	+ "un_pod_cd", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] n2ndImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_clss_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] n3rdImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_clss_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ttlPckUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_ut_cd", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] crntCtnt1 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt1", length));
			String[] crntCtnt2 = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt2", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));

			for (int i = 0; i < length; i++) {
				model = new KorMacamdVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (ttlMeasUtCd[i] != null)
					model.setTtlMeasUtCd(ttlMeasUtCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (unPolCd[i] != null)
					model.setUnPolCd(unPolCd[i]);
				if (cgoDesc2[i] != null)
					model.setCgoDesc2(cgoDesc2[i]);
				if (cgoDesc1[i] != null)
					model.setCgoDesc1(cgoDesc1[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (preCntrNo[i] != null)
					model.setPreCntrNo(preCntrNo[i]);
				if (vslCallSgnCd[i] != null)
					model.setVslCallSgnCd(vslCallSgnCd[i]);
				if (cntrSealNo1[i] != null)
					model.setCntrSealNo1(cntrSealNo1[i]);
				if (cntrSealNo2[i] != null)
					model.setCntrSealNo2(cntrSealNo2[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (krMeasUtCd[i] != null)
					model.setKrMeasUtCd(krMeasUtCd[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (ttlMeasQty[i] != null)
					model.setTtlMeasQty(ttlMeasQty[i]);
				if (sCustAddr[i] != null)
					model.setSCustAddr(sCustAddr[i]);
				if (cntrTtlWgt[i] != null)
					model.setCntrTtlWgt(cntrTtlWgt[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (nCustAddr[i] != null)
					model.setNCustAddr(nCustAddr[i]);
				if (callYear[i] != null)
					model.setCallYear(callYear[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (cCustAddr[i] != null)
					model.setCCustAddr(cCustAddr[i]);
				if (preCtnt1[i] != null)
					model.setPreCtnt1(preCtnt1[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (preCtnt2[i] != null)
					model.setPreCtnt2(preCtnt2[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (bizNo[i] != null)
					model.setBizNo(bizNo[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (unPodCd[i] != null)
					model.setUnPodCd(unPodCd[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (n2ndImdgClssCd[i] != null)
					model.setN2ndImdgClssCd(n2ndImdgClssCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (n3rdImdgClssCd[i] != null)
					model.setN3rdImdgClssCd(n3rdImdgClssCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ttlPckUtCd[i] != null)
					model.setTtlPckUtCd(ttlPckUtCd[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (crntCtnt1[i] != null)
					model.setCrntCtnt1(crntCtnt1[i]);
				if (crntCtnt2[i] != null)
					model.setCrntCtnt2(crntCtnt2[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMacamdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMacamdVO[]
	 */
	public KorMacamdVO[] getKorMacamdVOs(){
		KorMacamdVO[] vos = (KorMacamdVO[])models.toArray(new KorMacamdVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMeasUtCd = this.ttlMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unPolCd = this.unPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc2 = this.cgoDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc1 = this.cgoDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCntrNo = this.preCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo1 = this.cntrSealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo2 = this.cntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krMeasUtCd = this.krMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMeasQty = this.ttlMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustAddr = this.sCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustAddr = this.nCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYear = this.callYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustAddr = this.cCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt1 = this.preCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt2 = this.preCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizNo = this.bizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unPodCd = this.unPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgClssCd = this.n2ndImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgClssCd = this.n3rdImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckUtCd = this.ttlPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt1 = this.crntCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt2 = this.crntCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
