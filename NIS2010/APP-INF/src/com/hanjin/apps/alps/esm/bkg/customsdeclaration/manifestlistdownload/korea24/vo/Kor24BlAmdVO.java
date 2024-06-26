/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24BlAmdVO.java
*@FileTitle : Kor24BlAmdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.25 박상훈
* 1.0 Creation
* 2011.03.30 손은주 [CHM-201109081-01]	MANIFEST AMEND PA(항만청) B/L 추가시 문서명 오류 정정 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Kor24BlAmdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24BlAmdVO> models = new ArrayList<Kor24BlAmdVO>();

	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String msnNo = null;
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
	private String krPortAuthCd = null;
	/* Column Info */
	private String cgoDesc2 = null;
	/* Column Info */
	private String krCstmsWhTpCd = null;
	/* Column Info */
	private String cgoDesc1 = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String vslCallSgnCd = null;
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String transChk = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String krMeasUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cstmsFwrdId = null;
	/* Column Info */
	private String cntrTtlWgt = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String krCstmsDeptCd = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Column Info */
	private String krWhCd = null;
	/* Column Info */
	private String callYear = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String oldCstmsDeclTpCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String bizNo = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String cstmsOfcCtyCd = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String krCstmsBndCd = null;
	/* Column Info */
	private String cgoSpec = null;
	/* Column Info */
	private String amdtRcvrFlg = null;
	/* Column Info */
	private String bbCgoMeasQty = null;
	/* Column Info */
	private String ioTmlLocCd = null;
	/* Column Info */
	private String bbCgoWgt = null;
	/* Column Info */
	private String n2ndImdgClssCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String frtFwrdCd = null;
	/* Column Info */
	private String n3rdImdgClssCd = null;
	/* Column Info */
	private String orgBlNo = null;
	/* Column Info */
	private String delFlag = null;
	/* Column Info */
	private String transDmr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24BlAmdVO() {}

	public Kor24BlAmdVO(String ibflag, String pagerows, String bkgNo, String cstmsDeclTpCd, String blNo, String porCd, String polCd, String polLoc, String podCd, String podLoc, String delCd, String msnNo, String krCstmsBlTpCd, String frtFwrdCd, String vvd, String pckQty, String pckTpCd, String cntrTtlWgt, String wgtUtCd, String measQty, String measUtCd, String bdAreaCd, String imdgClssCd, String n2ndImdgClssCd, String n3rdImdgClssCd, String krCstmsWhTpCd, String krWhCd, String userId, String cgoDesc1, String cgoDesc2, String bkgCgoTpCd, String ioBndCd, String cstmsOfcCtyCd, String krCstmsDeptCd, String portCd, String cmdtCd, String krMeasUtCd, String bizNo, String bbCgoWgt, String bbCgoMeasQty, String cgoSpec, String oldCstmsDeclTpCd, String krCstmsBndCd, String krCstmsCorrId, String subNo, String corrRsn, String amdtRcvrFlg, String vslCallSgnCd, String etaDt, String callKnt, String vslNm, String vslCntCd, String ioTmlLocCd, String dchgMzdCd, String cstmsFwrdId, String trnsSeq, String transChk, String krPortAuthCd, String smtAmdNo, String callYear, String mrnNo, String orgBlNo, String delFlag, String transDmr) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.etaDt = etaDt;
		this.msnNo = msnNo;
		this.mrnNo = mrnNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.polLoc = polLoc;
		this.krPortAuthCd = krPortAuthCd;
		this.cgoDesc2 = cgoDesc2;
		this.krCstmsWhTpCd = krCstmsWhTpCd;
		this.cgoDesc1 = cgoDesc1;
		this.wgtUtCd = wgtUtCd;
		this.userId = userId;
		this.vslCallSgnCd = vslCallSgnCd;
		this.smtAmdNo = smtAmdNo;
		this.trnsSeq = trnsSeq;
		this.delCd = delCd;
		this.transChk = transChk;
		this.dchgMzdCd = dchgMzdCd;
		this.podCd = podCd;
		this.setPodLoc(podLoc);
		this.vvd = vvd;
		this.krMeasUtCd = krMeasUtCd;
		this.bkgNo = bkgNo;
		this.cstmsFwrdId = cstmsFwrdId;
		this.cntrTtlWgt = cntrTtlWgt;
		this.imdgClssCd = imdgClssCd;
		this.porCd = porCd;
		this.krCstmsDeptCd = krCstmsDeptCd;
		this.krCstmsCorrId = krCstmsCorrId;
		this.krWhCd = krWhCd;
		this.callYear = callYear;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.subNo = subNo;
		this.cmdtCd = cmdtCd;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.oldCstmsDeclTpCd = oldCstmsDeclTpCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.callKnt = callKnt;
		this.portCd = portCd;
		this.bizNo = bizNo;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.cstmsOfcCtyCd = cstmsOfcCtyCd;
		this.vslCntCd = vslCntCd;
		this.krCstmsBndCd = krCstmsBndCd;
		this.cgoSpec = cgoSpec;
		this.amdtRcvrFlg = amdtRcvrFlg;
		this.bbCgoMeasQty = bbCgoMeasQty;
		this.ioTmlLocCd = ioTmlLocCd;
		this.bbCgoWgt = bbCgoWgt;
		this.n2ndImdgClssCd = n2ndImdgClssCd;
		this.vslNm = vslNm;
		this.bdAreaCd = bdAreaCd;
		this.ioBndCd = ioBndCd;
		this.frtFwrdCd = frtFwrdCd;
		this.n3rdImdgClssCd = n3rdImdgClssCd;
		this.orgBlNo = orgBlNo;
		this.delFlag = delFlag;
		this.transDmr = transDmr;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("kr_port_auth_cd", getKrPortAuthCd());
		this.hashColumns.put("cgo_desc2", getCgoDesc2());
		this.hashColumns.put("kr_cstms_wh_tp_cd", getKrCstmsWhTpCd());
		this.hashColumns.put("cgo_desc1", getCgoDesc1());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("trans_chk", getTransChk());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("kr_meas_ut_cd", getKrMeasUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cstms_fwrd_id", getCstmsFwrdId());
		this.hashColumns.put("cntr_ttl_wgt", getCntrTtlWgt());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("kr_cstms_dept_cd", getKrCstmsDeptCd());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("kr_wh_cd", getKrWhCd());
		this.hashColumns.put("call_year", getCallYear());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("old_cstms_decl_tp_cd", getOldCstmsDeclTpCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("biz_no", getBizNo());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cstms_ofc_cty_cd", getCstmsOfcCtyCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("kr_cstms_bnd_cd", getKrCstmsBndCd());
		this.hashColumns.put("cgo_spec", getCgoSpec());
		this.hashColumns.put("amdt_rcvr_flg", getAmdtRcvrFlg());
		this.hashColumns.put("bb_cgo_meas_qty", getBbCgoMeasQty());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("bb_cgo_wgt", getBbCgoWgt());
		this.hashColumns.put("n2nd_imdg_clss_cd", getN2ndImdgClssCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("frt_fwrd_cd", getFrtFwrdCd());
		this.hashColumns.put("n3rd_imdg_clss_cd", getN3rdImdgClssCd());
		this.hashColumns.put("org_bl_no", getOrgBlNo());
		this.hashColumns.put("del_flag", getDelFlag());
		this.hashColumns.put("trans_dmr", getTransDmr());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("kr_port_auth_cd", "krPortAuthCd");
		this.hashFields.put("cgo_desc2", "cgoDesc2");
		this.hashFields.put("kr_cstms_wh_tp_cd", "krCstmsWhTpCd");
		this.hashFields.put("cgo_desc1", "cgoDesc1");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("trans_chk", "transChk");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("kr_meas_ut_cd", "krMeasUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cstms_fwrd_id", "cstmsFwrdId");
		this.hashFields.put("cntr_ttl_wgt", "cntrTtlWgt");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("kr_cstms_dept_cd", "krCstmsDeptCd");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("kr_wh_cd", "krWhCd");
		this.hashFields.put("call_year", "callYear");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("old_cstms_decl_tp_cd", "oldCstmsDeclTpCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("biz_no", "bizNo");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cstms_ofc_cty_cd", "cstmsOfcCtyCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("kr_cstms_bnd_cd", "krCstmsBndCd");
		this.hashFields.put("cgo_spec", "cgoSpec");
		this.hashFields.put("amdt_rcvr_flg", "amdtRcvrFlg");
		this.hashFields.put("bb_cgo_meas_qty", "bbCgoMeasQty");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("bb_cgo_wgt", "bbCgoWgt");
		this.hashFields.put("n2nd_imdg_clss_cd", "n2ndImdgClssCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("frt_fwrd_cd", "frtFwrdCd");
		this.hashFields.put("n3rd_imdg_clss_cd", "n3rdImdgClssCd");
		this.hashFields.put("org_bl_no", "orgBlNo");
		this.hashFields.put("del_flag", "delFlag");
		this.hashFields.put("trans_dmr", "transDmr");
		return this.hashFields;
	}

	/**
	 * @return the transDmr
	 */
	public String getTransDmr() {
		return transDmr;
	}

	/**
	 * @param transDmr the transDmr to set
	 */
	public void setTransDmr(String transDmr) {
		this.transDmr = transDmr;
	}

	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @return the orgBlNo
	 */
	public String getOrgBlNo() {
		return this.orgBlNo;
	}

	/**
	 * @param orgBlNo the orgBlNo to set
	 */
	public void setOrgBlNo(String orgBlNo) {
		this.orgBlNo = orgBlNo;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
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
	 * @return krPortAuthCd
	 */
	public String getKrPortAuthCd() {
		return this.krPortAuthCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return vslCallSgnCd
	 */
	public String getVslCallSgnCd() {
		return this.vslCallSgnCd;
	}

	/**
	 * Column Info
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}

	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
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
	 * @return transChk
	 */
	public String getTransChk() {
		return this.transChk;
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
	 * @return krMeasUtCd
	 */
	public String getKrMeasUtCd() {
		return this.krMeasUtCd;
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
	 * @return cstmsFwrdId
	 */
	public String getCstmsFwrdId() {
		return this.cstmsFwrdId;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return krWhCd
	 */
	public String getKrWhCd() {
		return this.krWhCd;
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
	 * @return oldCstmsDeclTpCd
	 */
	public String getOldCstmsDeclTpCd() {
		return this.oldCstmsDeclTpCd;
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
	 * @return callKnt
	 */
	public String getCallKnt() {
		return this.callKnt;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}

	/**
	 * Column Info
	 * @return krCstmsBndCd
	 */
	public String getKrCstmsBndCd() {
		return this.krCstmsBndCd;
	}

	/**
	 * Column Info
	 * @return cgoSpec
	 */
	public String getCgoSpec() {
		return this.cgoSpec;
	}

	/**
	 * Column Info
	 * @return amdtRcvrFlg
	 */
	public String getAmdtRcvrFlg() {
		return this.amdtRcvrFlg;
	}

	/**
	 * Column Info
	 * @return bbCgoMeasQty
	 */
	public String getBbCgoMeasQty() {
		return this.bbCgoMeasQty;
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
	 * @return bbCgoWgt
	 */
	public String getBbCgoWgt() {
		return this.bbCgoWgt;
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
	 * @return frtFwrdCd
	 */
	public String getFrtFwrdCd() {
		return this.frtFwrdCd;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
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
	 * @param krPortAuthCd
	 */
	public void setKrPortAuthCd(String krPortAuthCd) {
		this.krPortAuthCd = krPortAuthCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param vslCallSgnCd
	 */
	public void setVslCallSgnCd(String vslCallSgnCd) {
		this.vslCallSgnCd = vslCallSgnCd;
	}

	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}

	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
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
	 * @param transChk
	 */
	public void setTransChk(String transChk) {
		this.transChk = transChk;
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
	 * @param krMeasUtCd
	 */
	public void setKrMeasUtCd(String krMeasUtCd) {
		this.krMeasUtCd = krMeasUtCd;
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
	 * @param cstmsFwrdId
	 */
	public void setCstmsFwrdId(String cstmsFwrdId) {
		this.cstmsFwrdId = cstmsFwrdId;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param krWhCd
	 */
	public void setKrWhCd(String krWhCd) {
		this.krWhCd = krWhCd;
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
	 * @param oldCstmsDeclTpCd
	 */
	public void setOldCstmsDeclTpCd(String oldCstmsDeclTpCd) {
		this.oldCstmsDeclTpCd = oldCstmsDeclTpCd;
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
	 * @param callKnt
	 */
	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}

	/**
	 * Column Info
	 * @param krCstmsBndCd
	 */
	public void setKrCstmsBndCd(String krCstmsBndCd) {
		this.krCstmsBndCd = krCstmsBndCd;
	}

	/**
	 * Column Info
	 * @param cgoSpec
	 */
	public void setCgoSpec(String cgoSpec) {
		this.cgoSpec = cgoSpec;
	}

	/**
	 * Column Info
	 * @param amdtRcvrFlg
	 */
	public void setAmdtRcvrFlg(String amdtRcvrFlg) {
		this.amdtRcvrFlg = amdtRcvrFlg;
	}

	/**
	 * Column Info
	 * @param bbCgoMeasQty
	 */
	public void setBbCgoMeasQty(String bbCgoMeasQty) {
		this.bbCgoMeasQty = bbCgoMeasQty;
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
	 * @param bbCgoWgt
	 */
	public void setBbCgoWgt(String bbCgoWgt) {
		this.bbCgoWgt = bbCgoWgt;
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
	 * @param frtFwrdCd
	 */
	public void setFrtFwrdCd(String frtFwrdCd) {
		this.frtFwrdCd = frtFwrdCd;
	}

	/**
	 * Column Info
	 * @param n3rdImdgClssCd
	 */
	public void setN3rdImdgClssCd(String n3rdImdgClssCd) {
		this.n3rdImdgClssCd = n3rdImdgClssCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setMsnNo(JSPUtil.getParameter(request, "msn_no", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setKrPortAuthCd(JSPUtil.getParameter(request, "kr_port_auth_cd", ""));
		setCgoDesc2(JSPUtil.getParameter(request, "cgo_desc2", ""));
		setKrCstmsWhTpCd(JSPUtil.getParameter(request, "kr_cstms_wh_tp_cd", ""));
		setCgoDesc1(JSPUtil.getParameter(request, "cgo_desc1", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, "vsl_call_sgn_cd", ""));
		setSmtAmdNo(JSPUtil.getParameter(request, "smt_amd_no", ""));
		setTrnsSeq(JSPUtil.getParameter(request, "trns_seq", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setTransChk(JSPUtil.getParameter(request, "trans_chk", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, "dchg_mzd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setKrMeasUtCd(JSPUtil.getParameter(request, "kr_meas_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCstmsFwrdId(JSPUtil.getParameter(request, "cstms_fwrd_id", ""));
		setCntrTtlWgt(JSPUtil.getParameter(request, "cntr_ttl_wgt", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setKrCstmsDeptCd(JSPUtil.getParameter(request, "kr_cstms_dept_cd", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, "kr_cstms_corr_id", ""));
		setKrWhCd(JSPUtil.getParameter(request, "kr_wh_cd", ""));
		setCallYear(JSPUtil.getParameter(request, "call_year", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, "corr_rsn", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setSubNo(JSPUtil.getParameter(request, "sub_no", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, "kr_cstms_bl_tp_cd", ""));
		setOldCstmsDeclTpCd(JSPUtil.getParameter(request, "old_cstms_decl_tp_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setBizNo(JSPUtil.getParameter(request, "biz_no", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setCstmsOfcCtyCd(JSPUtil.getParameter(request, "cstms_ofc_cty_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setKrCstmsBndCd(JSPUtil.getParameter(request, "kr_cstms_bnd_cd", ""));
		setCgoSpec(JSPUtil.getParameter(request, "cgo_spec", ""));
		setAmdtRcvrFlg(JSPUtil.getParameter(request, "amdt_rcvr_flg", ""));
		setBbCgoMeasQty(JSPUtil.getParameter(request, "bb_cgo_meas_qty", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, "io_tml_loc_cd", ""));
		setBbCgoWgt(JSPUtil.getParameter(request, "bb_cgo_wgt", ""));
		setN2ndImdgClssCd(JSPUtil.getParameter(request, "n2nd_imdg_clss_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setFrtFwrdCd(JSPUtil.getParameter(request, "frt_fwrd_cd", ""));
		setN3rdImdgClssCd(JSPUtil.getParameter(request, "n3rd_imdg_clss_cd", ""));
		setOrgBlNo(JSPUtil.getParameter(request, "org_bl_no", ""));
		setDelFlag(JSPUtil.getParameter(request, "del_flag", ""));
		setTransDmr(JSPUtil.getParameter(request, "trans_dmr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24BlAmdVO[]
	 */
	public Kor24BlAmdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24BlAmdVO[]
	 */
	public Kor24BlAmdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24BlAmdVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] krPortAuthCd = (JSPUtil.getParameter(request, prefix	+ "kr_port_auth_cd", length));
			String[] cgoDesc2 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc2", length));
			String[] krCstmsWhTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_wh_tp_cd", length));
			String[] cgoDesc1 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc1", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] transChk = (JSPUtil.getParameter(request, prefix	+ "trans_chk", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] krMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "kr_meas_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cstmsFwrdId = (JSPUtil.getParameter(request, prefix	+ "cstms_fwrd_id", length));
			String[] cntrTtlWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_ttl_wgt", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] krCstmsDeptCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_dept_cd", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] krWhCd = (JSPUtil.getParameter(request, prefix	+ "kr_wh_cd", length));
			String[] callYear = (JSPUtil.getParameter(request, prefix	+ "call_year", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] oldCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "old_cstms_decl_tp_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] bizNo = (JSPUtil.getParameter(request, prefix	+ "biz_no", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cstmsOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ofc_cty_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] krCstmsBndCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bnd_cd", length));
			String[] cgoSpec = (JSPUtil.getParameter(request, prefix	+ "cgo_spec", length));
			String[] amdtRcvrFlg = (JSPUtil.getParameter(request, prefix	+ "amdt_rcvr_flg", length));
			String[] bbCgoMeasQty = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_meas_qty", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] bbCgoWgt = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_wgt", length));
			String[] n2ndImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_imdg_clss_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] frtFwrdCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cd", length));
			String[] n3rdImdgClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_imdg_clss_cd", length));
			String[] orgBlNo = (JSPUtil.getParameter(request, prefix	+ "org_bl_no", length));
			String[] delFlag = (JSPUtil.getParameter(request, prefix	+ "del_flag", length));
			String[] transDmr = (JSPUtil.getParameter(request, prefix	+ "trans_dmr", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24BlAmdVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
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
				if (krPortAuthCd[i] != null)
					model.setKrPortAuthCd(krPortAuthCd[i]);
				if (cgoDesc2[i] != null)
					model.setCgoDesc2(cgoDesc2[i]);
				if (krCstmsWhTpCd[i] != null)
					model.setKrCstmsWhTpCd(krCstmsWhTpCd[i]);
				if (cgoDesc1[i] != null)
					model.setCgoDesc1(cgoDesc1[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (vslCallSgnCd[i] != null)
					model.setVslCallSgnCd(vslCallSgnCd[i]);
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (transChk[i] != null)
					model.setTransChk(transChk[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (krMeasUtCd[i] != null)
					model.setKrMeasUtCd(krMeasUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cstmsFwrdId[i] != null)
					model.setCstmsFwrdId(cstmsFwrdId[i]);
				if (cntrTtlWgt[i] != null)
					model.setCntrTtlWgt(cntrTtlWgt[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (krCstmsDeptCd[i] != null)
					model.setKrCstmsDeptCd(krCstmsDeptCd[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (krWhCd[i] != null)
					model.setKrWhCd(krWhCd[i]);
				if (callYear[i] != null)
					model.setCallYear(callYear[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (oldCstmsDeclTpCd[i] != null)
					model.setOldCstmsDeclTpCd(oldCstmsDeclTpCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (bizNo[i] != null)
					model.setBizNo(bizNo[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (cstmsOfcCtyCd[i] != null)
					model.setCstmsOfcCtyCd(cstmsOfcCtyCd[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (krCstmsBndCd[i] != null)
					model.setKrCstmsBndCd(krCstmsBndCd[i]);
				if (cgoSpec[i] != null)
					model.setCgoSpec(cgoSpec[i]);
				if (amdtRcvrFlg[i] != null)
					model.setAmdtRcvrFlg(amdtRcvrFlg[i]);
				if (bbCgoMeasQty[i] != null)
					model.setBbCgoMeasQty(bbCgoMeasQty[i]);
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (bbCgoWgt[i] != null)
					model.setBbCgoWgt(bbCgoWgt[i]);
				if (n2ndImdgClssCd[i] != null)
					model.setN2ndImdgClssCd(n2ndImdgClssCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (frtFwrdCd[i] != null)
					model.setFrtFwrdCd(frtFwrdCd[i]);
				if (n3rdImdgClssCd[i] != null)
					model.setN3rdImdgClssCd(n3rdImdgClssCd[i]);
				if (orgBlNo[i] != null)
					model.setOrgBlNo(orgBlNo[i]);
				if (delFlag[i] != null)
					model.setDelFlag(delFlag[i]);
				if (transDmr[i] != null)
					model.setTransDmr(transDmr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24BlAmdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24BlAmdVO[]
	 */
	public Kor24BlAmdVO[] getKor24BlAmdVOs(){
		Kor24BlAmdVO[] vos = (Kor24BlAmdVO[])models.toArray(new Kor24BlAmdVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krPortAuthCd = this.krPortAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc2 = this.cgoDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsWhTpCd = this.krCstmsWhTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc1 = this.cgoDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transChk = this.transChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krMeasUtCd = this.krMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsFwrdId = this.cstmsFwrdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTtlWgt = this.cntrTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsDeptCd = this.krCstmsDeptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhCd = this.krWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYear = this.callYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCstmsDeclTpCd = this.oldCstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizNo = this.bizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsOfcCtyCd = this.cstmsOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBndCd = this.krCstmsBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSpec = this.cgoSpec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtRcvrFlg = this.amdtRcvrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoMeasQty = this.bbCgoMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoWgt = this.bbCgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndImdgClssCd = this.n2ndImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCd = this.frtFwrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdImdgClssCd = this.n3rdImdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBlNo = this.orgBlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlag = this.delFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transDmr = this.transDmr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @param polLoc the polLoc to set
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}

	/**
	 * @return the polLoc
	 */
	public String getPolLoc() {
		return polLoc;
	}

	/**
	 * @param podLoc the podLoc to set
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}

	/**
	 * @return the podLoc
	 */
	public String getPodLoc() {
		return podLoc;
	}
}
