/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsKrVvdSmryVO.java
*@FileTitle : BkgCstmsKrVvdSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.25 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.TransmitCondVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBkgCstmsVvdSmryVO extends TransmitCondVO {

private static final long serialVersionUID = 1L;
	
	private Collection<KorBkgCstmsVvdSmryVO> models = new ArrayList<KorBkgCstmsVvdSmryVO>();
	
	/* Column Info */
	private String inVvd = null;
	/* Column Info */
	private String kvPliMrnPort = null;
	/* Column Info */
	private String inPod = null;
	/* Column Info */
	private String kvTtlMtyTeuQty = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String kvPortCd = null;
	/* Column Info */
	private String kvMrnNo = null;
	/* Column Info */
	private String inPol = null;
	/* Column Info */
	private String svTotLcCntr40 = null;
	/* Column Info */
	private String svTotLcCntr45 = null;
	/* Column Info */
	private String kvTransChkCnt = null;
	/* Column Info */
	private String kvSpace = null;
	/* Column Info */
	private String kvMfSndDt = null;
	/* Column Info */
	private String kvMrnPort = null;
	/* Column Info */
	private String svPkgQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String kvIoBndCdI = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String username = null;
	/* Column Info */
	private String kvTransPreCnt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String kvIoBndCdO = null;
	/* Column Info */
	private String oldMrnChkNo = null;
	/* Column Info */
	private String kvCnslBlKnt = null;
	/* Column Info */
	private String kvIntChkCallKnt = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String kvMfSndDd = null;
	/* Column Info */
	private String inChgPort = null;
	/* Column Info */
	private String kvBondAreaCode = null;
	/* Column Info */
	private String vvdPodTmnlCd = null;
	/* Column Info */
	private String bondAreaCode = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String kvTtlPckQty = null;
	/* Column Info */
	private String jointCnt = null;
	/* Column Info */
	private String kvVvdSeq = null;
	/* Column Info */
	private String vslCallSign = null;
	/* Column Info */
	private String kvDchgMzdCd = null;
	/* Column Info */
	private String svBlCCnt = null;
	/* Column Info */
	private String kvEtaDt = null;
	/* Column Info */
	private String maxSeq = null;
	/* Column Info */
	private String newMrnNo = null;
	/* Column Info */
	private String svTotMtCntr45 = null;
	/* Column Info */
	private String kvMfSndTt = null;
	/* Column Info */
	private String kvSeq = null;
	/* Column Info */
	private String kvTtlTs45ftQty = null;
	/* Column Info */
	private String kvIoTmlLocCd = null;
	/* Column Info */
	private String svTotMtCntr40 = null;
	/* Column Info */
	private String kvMtyBlKnt = null;
	/* Column Info */
	private String oldMrnNo = null;
	/* Column Info */
	private String kvIoBndCd = null;
	/* Column Info */
	private String svTotLcCntr20 = null;
	/* Column Info */
	private String kvVvdCd = null;
	/* Column Info */
	private String kvHjsc = null;
	/* Column Info */
	private String kvTtlMtyFeuQty = null;
	/* Column Info */
	private String kvTtlMty45ftQty = null;
	/* Column Info */
	private String intChk = null;
	/* Column Info */
	private String svBlSCnt = null;
	/* Column Info */
	private String svMeaQty = null;
	/* Column Info */
	private String svCntrECnt = null;
	/* Column Info */
	private String kvFDate = null;
	/* Column Info */
	private String kvCstmsDchgCd = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String kvTtlMeasQty = null;
	/* Column Info */
	private String svBlMCnt = null;
	/* Column Info */
	private String kvVslCallSgn = null;
	/* Column Info */
	private String kvTtlMtyKnt = null;
	/* Column Info */
	private String podTml = null;
	/* Column Info */
	private String newMrnChkNo = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String kvTtlFullKnt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String svBlECnt = null;
	/* Column Info */
	private String kvCallKnt = null;
	/* Column Info */
	private String inBound = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String oldCnt = null;
	/* Column Info */
	private String kvMstBlKnt = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String kvJoCrrKnt = null;
	/* Column Info */
	private String kvTtlTsFeuQty = null;
	/* Column Info */
	private String kvCbm = null;
	/* Column Info */
	private String kvTtlLc45ftQty = null;
	/* Column Info */
	private String transChkCnt = null;
	/* Column Info */
	private String kvPortCdLo = null;
	/* Column Info */
	private String kvVslCntCd = null;
	/* Column Info */
	private String transPreCnt = null;
	/* Column Info */
	private String kvVslNm = null;
	/* Column Info */
	private String svTotTsCntr40 = null;
	/* Column Info */
	private String oldSndChk = null;
	/* Column Info */
	private String kvTDate = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String svTotTsCntr45 = null;
	/* Column Info */
	private String inDelLog = null;
	/* Column Info */
	private String inChgMeth = null;
	/* Column Info */
	private String kvEtdDt = null;
	/* Column Info */
	private String svWgtQty = null;
	/* Column Info */
	private String kvTtlLcTeuQty = null;
	/* Column Info */
	private String obType = null;
	/* Column Info */
	private String kvBg = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String kvSvBlSCnt = null;
	/* Column Info */
	private String mrnPort = null;
	/* Column Info */
	private String mrnType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String createdtype = null;
	/* Column Info */
	private String kvKgs = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String svCntrFCnt = null;
	/* Column Info */
	private String svTotTsCntr20 = null;
	/* Column Info */
	private String inChgComp = null;
	/* Column Info */
	private String svTotMtCntr20 = null;
	/* Column Info */
	private String kvRpliMrnPort = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String kvTtlWgt = null;
	/* Column Info */
	private String kvTtlLcFeuQty = null;
	/* Column Info */
	private String obDeclTpCd = null;
	/* Column Info */
	private String kvTtlTsTeuQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorBkgCstmsVvdSmryVO() {}

	public KorBkgCstmsVvdSmryVO(String ibflag, String pagerows, String bondAreaCode, String kvMfSndDd, String kvMfSndTt, String intChk, String vvdPodTmnlCd, String oldMrnNo, String etaDt, String vslFlag, String oldCnt, String etdDt, String jointCnt, String mrnPort, String username, String vslCallSign, String vvdCd, String vslEngNm, String maxSeq, String newMrnNo, String kvSeq, String oldMrnChkNo, String newMrnChkNo, String bound, String createdtype, String mrnNo, String mrnChkNo, String mrnType, String ioBndCd, String vvdSeq, String obDeclTpCd, String inType, String inBound, String inVvd, String inPol, String inPod, String polLoc, String podLoc, String podTml, String vslCd, String obType, String oldSndChk, String svBlMCnt, String svBlCCnt, String svBlECnt, String svBlSCnt, String svWgtQty, String svMeaQty, String svPkgQty, String svCntrFCnt, String svCntrECnt, String svTotLcCntr20, String svTotLcCntr40, String svTotLcCntr45, String svTotTsCntr20, String svTotTsCntr40, String svTotTsCntr45, String svTotMtCntr20, String svTotMtCntr40, String svTotMtCntr45, String transChkCnt, String transPreCnt, String kvMrnNo, String kvVvdCd, String kvVvdSeq, String kvVslCntCd, String kvIoBndCd, String kvIoBndCdO, String kvIoBndCdI, String kvSpace, String kvEtaDt, String kvEtdDt, String kvFDate, String kvTDate, String kvHjsc, String kvPliMrnPort, String kvRpliMrnPort, String kvJoCrrKnt, String kvTtlWgt, String kvKgs, String kvTtlPckQty, String kvBg, String kvTtlMeasQty, String kvCbm, String kvMstBlKnt, String kvCnslBlKnt, String kvTtlFullKnt, String kvTtlMtyKnt, String kvCstmsDchgCd, String kvVslNm, String kvVslCallSgn, String kvMfSndDt, String kvTtlLcTeuQty, String kvTtlTsTeuQty, String kvTtlMtyTeuQty, String kvTtlLcFeuQty, String kvTtlTsFeuQty, String kvTtlMtyFeuQty, String kvTtlLc45ftQty, String kvTtlTs45ftQty, String kvTtlMty45ftQty, String kvMtyBlKnt, String kvBondAreaCode, String kvIntChkCallKnt, String kvPortCd, String kvSvBlSCnt, String kvTransChkCnt, String kvTransPreCnt, String kvCallKnt, String kvDchgMzdCd, String kvIoTmlLocCd, String kvPortCdLo, String kvMrnPort, String inChgPort, String inChgComp, String inChgMeth, String inDelLog) {
		this.inVvd = inVvd;
		this.kvPliMrnPort = kvPliMrnPort;
		this.inPod = inPod;
		this.kvTtlMtyTeuQty = kvTtlMtyTeuQty;
		this.etaDt = etaDt;
		this.kvPortCd = kvPortCd;
		this.kvMrnNo = kvMrnNo;
		this.inPol = inPol;
		this.svTotLcCntr40 = svTotLcCntr40;
		this.svTotLcCntr45 = svTotLcCntr45;
		this.kvTransChkCnt = kvTransChkCnt;
		this.kvSpace = kvSpace;
		this.kvMfSndDt = kvMfSndDt;
		this.kvMrnPort = kvMrnPort;
		this.svPkgQty = svPkgQty;
		this.pagerows = pagerows;
		this.kvIoBndCdI = kvIoBndCdI;
		this.inType = inType;
		this.username = username;
		this.kvTransPreCnt = kvTransPreCnt;
		this.vvdCd = vvdCd;
		this.kvIoBndCdO = kvIoBndCdO;
		this.oldMrnChkNo = oldMrnChkNo;
		this.kvCnslBlKnt = kvCnslBlKnt;
		this.kvIntChkCallKnt = kvIntChkCallKnt;
		this.vvdSeq = vvdSeq;
		this.kvMfSndDd = kvMfSndDd;
		this.inChgPort = inChgPort;
		this.kvBondAreaCode = kvBondAreaCode;
		this.vvdPodTmnlCd = vvdPodTmnlCd;
		this.bondAreaCode = bondAreaCode;
		this.podLoc = podLoc;
		this.kvTtlPckQty = kvTtlPckQty;
		this.jointCnt = jointCnt;
		this.kvVvdSeq = kvVvdSeq;
		this.vslCallSign = vslCallSign;
		this.kvDchgMzdCd = kvDchgMzdCd;
		this.svBlCCnt = svBlCCnt;
		this.kvEtaDt = kvEtaDt;
		this.maxSeq = maxSeq;
		this.newMrnNo = newMrnNo;
		this.svTotMtCntr45 = svTotMtCntr45;
		this.kvMfSndTt = kvMfSndTt;
		this.kvSeq = kvSeq;
		this.kvTtlTs45ftQty = kvTtlTs45ftQty;
		this.kvIoTmlLocCd = kvIoTmlLocCd;
		this.svTotMtCntr40 = svTotMtCntr40;
		this.kvMtyBlKnt = kvMtyBlKnt;
		this.oldMrnNo = oldMrnNo;
		this.kvIoBndCd = kvIoBndCd;
		this.svTotLcCntr20 = svTotLcCntr20;
		this.kvVvdCd = kvVvdCd;
		this.kvHjsc = kvHjsc;
		this.kvTtlMtyFeuQty = kvTtlMtyFeuQty;
		this.kvTtlMty45ftQty = kvTtlMty45ftQty;
		this.intChk = intChk;
		this.svBlSCnt = svBlSCnt;
		this.svMeaQty = svMeaQty;
		this.svCntrECnt = svCntrECnt;
		this.kvFDate = kvFDate;
		this.kvCstmsDchgCd = kvCstmsDchgCd;
		this.etdDt = etdDt;
		this.kvTtlMeasQty = kvTtlMeasQty;
		this.svBlMCnt = svBlMCnt;
		this.kvVslCallSgn = kvVslCallSgn;
		this.kvTtlMtyKnt = kvTtlMtyKnt;
		this.podTml = podTml;
		this.newMrnChkNo = newMrnChkNo;
		this.bound = bound;
		this.kvTtlFullKnt = kvTtlFullKnt;
		this.vslCd = vslCd;
		this.svBlECnt = svBlECnt;
		this.kvCallKnt = kvCallKnt;
		this.inBound = inBound;
		this.vslFlag = vslFlag;
		this.oldCnt = oldCnt;
		this.kvMstBlKnt = kvMstBlKnt;
		this.mrnNo = mrnNo;
		this.kvJoCrrKnt = kvJoCrrKnt;
		this.kvTtlTsFeuQty = kvTtlTsFeuQty;
		this.kvCbm = kvCbm;
		this.kvTtlLc45ftQty = kvTtlLc45ftQty;
		this.transChkCnt = transChkCnt;
		this.kvPortCdLo = kvPortCdLo;
		this.kvVslCntCd = kvVslCntCd;
		this.transPreCnt = transPreCnt;
		this.kvVslNm = kvVslNm;
		this.svTotTsCntr40 = svTotTsCntr40;
		this.oldSndChk = oldSndChk;
		this.kvTDate = kvTDate;
		this.mrnChkNo = mrnChkNo;
		this.svTotTsCntr45 = svTotTsCntr45;
		this.inDelLog = inDelLog;
		this.inChgMeth = inChgMeth;
		this.kvEtdDt = kvEtdDt;
		this.svWgtQty = svWgtQty;
		this.kvTtlLcTeuQty = kvTtlLcTeuQty;
		this.obType = obType;
		this.kvBg = kvBg;
		this.polLoc = polLoc;
		this.kvSvBlSCnt = kvSvBlSCnt;
		this.mrnPort = mrnPort;
		this.mrnType = mrnType;
		this.ibflag = ibflag;
		this.createdtype = createdtype;
		this.kvKgs = kvKgs;
		this.vslEngNm = vslEngNm;
		this.svCntrFCnt = svCntrFCnt;
		this.svTotTsCntr20 = svTotTsCntr20;
		this.inChgComp = inChgComp;
		this.svTotMtCntr20 = svTotMtCntr20;
		this.kvRpliMrnPort = kvRpliMrnPort;
		this.ioBndCd = ioBndCd;
		this.kvTtlWgt = kvTtlWgt;
		this.kvTtlLcFeuQty = kvTtlLcFeuQty;
		this.obDeclTpCd = obDeclTpCd;
		this.kvTtlTsTeuQty = kvTtlTsTeuQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vvd", getInVvd());
		this.hashColumns.put("kv_pli_mrn_port", getKvPliMrnPort());
		this.hashColumns.put("in_pod", getInPod());
		this.hashColumns.put("kv_ttl_mty_teu_qty", getKvTtlMtyTeuQty());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("kv_port_cd", getKvPortCd());
		this.hashColumns.put("kv_mrn_no", getKvMrnNo());
		this.hashColumns.put("in_pol", getInPol());
		this.hashColumns.put("sv_tot_lc_cntr_40", getSvTotLcCntr40());
		this.hashColumns.put("sv_tot_lc_cntr_45", getSvTotLcCntr45());
		this.hashColumns.put("kv_trans_chk_cnt", getKvTransChkCnt());
		this.hashColumns.put("kv_space", getKvSpace());
		this.hashColumns.put("kv_mf_snd_dt", getKvMfSndDt());
		this.hashColumns.put("kv_mrn_port", getKvMrnPort());
		this.hashColumns.put("sv_pkg_qty", getSvPkgQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kv_io_bnd_cd_i", getKvIoBndCdI());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("kv_trans_pre_cnt", getKvTransPreCnt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("kv_io_bnd_cd_o", getKvIoBndCdO());
		this.hashColumns.put("old_mrn_chk_no", getOldMrnChkNo());
		this.hashColumns.put("kv_cnsl_bl_knt", getKvCnslBlKnt());
		this.hashColumns.put("kv_int_chk_call_knt", getKvIntChkCallKnt());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("kv_mf_snd_dd", getKvMfSndDd());
		this.hashColumns.put("in_chg_port", getInChgPort());
		this.hashColumns.put("kv_bond_area_code", getKvBondAreaCode());
		this.hashColumns.put("vvd_pod_tmnl_cd", getVvdPodTmnlCd());
		this.hashColumns.put("bond_area_code", getBondAreaCode());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("kv_ttl_pck_qty", getKvTtlPckQty());
		this.hashColumns.put("joint_cnt", getJointCnt());
		this.hashColumns.put("kv_vvd_seq", getKvVvdSeq());
		this.hashColumns.put("vsl_call_sign", getVslCallSign());
		this.hashColumns.put("kv_dchg_mzd_cd", getKvDchgMzdCd());
		this.hashColumns.put("sv_bl_c_cnt", getSvBlCCnt());
		this.hashColumns.put("kv_eta_dt", getKvEtaDt());
		this.hashColumns.put("max_seq", getMaxSeq());
		this.hashColumns.put("new_mrn_no", getNewMrnNo());
		this.hashColumns.put("sv_tot_mt_cntr_45", getSvTotMtCntr45());
		this.hashColumns.put("kv_mf_snd_tt", getKvMfSndTt());
		this.hashColumns.put("kv_seq", getKvSeq());
		this.hashColumns.put("kv_ttl_ts_45ft_qty", getKvTtlTs45ftQty());
		this.hashColumns.put("kv_io_tml_loc_cd", getKvIoTmlLocCd());
		this.hashColumns.put("sv_tot_mt_cntr_40", getSvTotMtCntr40());
		this.hashColumns.put("kv_mty_bl_knt", getKvMtyBlKnt());
		this.hashColumns.put("old_mrn_no", getOldMrnNo());
		this.hashColumns.put("kv_io_bnd_cd", getKvIoBndCd());
		this.hashColumns.put("sv_tot_lc_cntr_20", getSvTotLcCntr20());
		this.hashColumns.put("kv_vvd_cd", getKvVvdCd());
		this.hashColumns.put("kv_hjsc", getKvHjsc());
		this.hashColumns.put("kv_ttl_mty_feu_qty", getKvTtlMtyFeuQty());
		this.hashColumns.put("kv_ttl_mty_45ft_qty", getKvTtlMty45ftQty());
		this.hashColumns.put("int_chk", getIntChk());
		this.hashColumns.put("sv_bl_s_cnt", getSvBlSCnt());
		this.hashColumns.put("sv_mea_qty", getSvMeaQty());
		this.hashColumns.put("sv_cntr_e_cnt", getSvCntrECnt());
		this.hashColumns.put("kv_f_date", getKvFDate());
		this.hashColumns.put("kv_cstms_dchg_cd", getKvCstmsDchgCd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("kv_ttl_meas_qty", getKvTtlMeasQty());
		this.hashColumns.put("sv_bl_m_cnt", getSvBlMCnt());
		this.hashColumns.put("kv_vsl_call_sgn", getKvVslCallSgn());
		this.hashColumns.put("kv_ttl_mty_knt", getKvTtlMtyKnt());
		this.hashColumns.put("pod_tml", getPodTml());
		this.hashColumns.put("new_mrn_chk_no", getNewMrnChkNo());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("kv_ttl_full_knt", getKvTtlFullKnt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sv_bl_e_cnt", getSvBlECnt());
		this.hashColumns.put("kv_call_knt", getKvCallKnt());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("old_cnt", getOldCnt());
		this.hashColumns.put("kv_mst_bl_knt", getKvMstBlKnt());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("kv_jo_crr_knt", getKvJoCrrKnt());
		this.hashColumns.put("kv_ttl_ts_feu_qty", getKvTtlTsFeuQty());
		this.hashColumns.put("kv_cbm", getKvCbm());
		this.hashColumns.put("kv_ttl_lc_45ft_qty", getKvTtlLc45ftQty());
		this.hashColumns.put("trans_chk_cnt", getTransChkCnt());
		this.hashColumns.put("kv_port_cd_lo", getKvPortCdLo());
		this.hashColumns.put("kv_vsl_cnt_cd", getKvVslCntCd());
		this.hashColumns.put("trans_pre_cnt", getTransPreCnt());
		this.hashColumns.put("kv_vsl_nm", getKvVslNm());
		this.hashColumns.put("sv_tot_ts_cntr_40", getSvTotTsCntr40());
		this.hashColumns.put("old_snd_chk", getOldSndChk());
		this.hashColumns.put("kv_t_date", getKvTDate());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("sv_tot_ts_cntr_45", getSvTotTsCntr45());
		this.hashColumns.put("in_del_log", getInDelLog());
		this.hashColumns.put("in_chg_meth", getInChgMeth());
		this.hashColumns.put("kv_etd_dt", getKvEtdDt());
		this.hashColumns.put("sv_wgt_qty", getSvWgtQty());
		this.hashColumns.put("kv_ttl_lc_teu_qty", getKvTtlLcTeuQty());
		this.hashColumns.put("ob_type", getObType());
		this.hashColumns.put("kv_bg", getKvBg());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("kv_sv_bl_s_cnt", getKvSvBlSCnt());
		this.hashColumns.put("mrn_port", getMrnPort());
		this.hashColumns.put("mrn_type", getMrnType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("createdtype", getCreatedtype());
		this.hashColumns.put("kv_kgs", getKvKgs());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("sv_cntr_f_cnt", getSvCntrFCnt());
		this.hashColumns.put("sv_tot_ts_cntr_20", getSvTotTsCntr20());
		this.hashColumns.put("in_chg_comp", getInChgComp());
		this.hashColumns.put("sv_tot_mt_cntr_20", getSvTotMtCntr20());
		this.hashColumns.put("kv_rpli_mrn_port", getKvRpliMrnPort());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("kv_ttl_wgt", getKvTtlWgt());
		this.hashColumns.put("kv_ttl_lc_feu_qty", getKvTtlLcFeuQty());
		this.hashColumns.put("ob_decl_tp_cd", getObDeclTpCd());
		this.hashColumns.put("kv_ttl_ts_teu_qty", getKvTtlTsTeuQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vvd", "inVvd");
		this.hashFields.put("kv_pli_mrn_port", "kvPliMrnPort");
		this.hashFields.put("in_pod", "inPod");
		this.hashFields.put("kv_ttl_mty_teu_qty", "kvTtlMtyTeuQty");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("kv_port_cd", "kvPortCd");
		this.hashFields.put("kv_mrn_no", "kvMrnNo");
		this.hashFields.put("in_pol", "inPol");
		this.hashFields.put("sv_tot_lc_cntr_40", "svTotLcCntr40");
		this.hashFields.put("sv_tot_lc_cntr_45", "svTotLcCntr45");
		this.hashFields.put("kv_trans_chk_cnt", "kvTransChkCnt");
		this.hashFields.put("kv_space", "kvSpace");
		this.hashFields.put("kv_mf_snd_dt", "kvMfSndDt");
		this.hashFields.put("kv_mrn_port", "kvMrnPort");
		this.hashFields.put("sv_pkg_qty", "svPkgQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kv_io_bnd_cd_i", "kvIoBndCdI");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("username", "username");
		this.hashFields.put("kv_trans_pre_cnt", "kvTransPreCnt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("kv_io_bnd_cd_o", "kvIoBndCdO");
		this.hashFields.put("old_mrn_chk_no", "oldMrnChkNo");
		this.hashFields.put("kv_cnsl_bl_knt", "kvCnslBlKnt");
		this.hashFields.put("kv_int_chk_call_knt", "kvIntChkCallKnt");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("kv_mf_snd_dd", "kvMfSndDd");
		this.hashFields.put("in_chg_port", "inChgPort");
		this.hashFields.put("kv_bond_area_code", "kvBondAreaCode");
		this.hashFields.put("vvd_pod_tmnl_cd", "vvdPodTmnlCd");
		this.hashFields.put("bond_area_code", "bondAreaCode");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("kv_ttl_pck_qty", "kvTtlPckQty");
		this.hashFields.put("joint_cnt", "jointCnt");
		this.hashFields.put("kv_vvd_seq", "kvVvdSeq");
		this.hashFields.put("vsl_call_sign", "vslCallSign");
		this.hashFields.put("kv_dchg_mzd_cd", "kvDchgMzdCd");
		this.hashFields.put("sv_bl_c_cnt", "svBlCCnt");
		this.hashFields.put("kv_eta_dt", "kvEtaDt");
		this.hashFields.put("max_seq", "maxSeq");
		this.hashFields.put("new_mrn_no", "newMrnNo");
		this.hashFields.put("sv_tot_mt_cntr_45", "svTotMtCntr45");
		this.hashFields.put("kv_mf_snd_tt", "kvMfSndTt");
		this.hashFields.put("kv_seq", "kvSeq");
		this.hashFields.put("kv_ttl_ts_45ft_qty", "kvTtlTs45ftQty");
		this.hashFields.put("kv_io_tml_loc_cd", "kvIoTmlLocCd");
		this.hashFields.put("sv_tot_mt_cntr_40", "svTotMtCntr40");
		this.hashFields.put("kv_mty_bl_knt", "kvMtyBlKnt");
		this.hashFields.put("old_mrn_no", "oldMrnNo");
		this.hashFields.put("kv_io_bnd_cd", "kvIoBndCd");
		this.hashFields.put("sv_tot_lc_cntr_20", "svTotLcCntr20");
		this.hashFields.put("kv_vvd_cd", "kvVvdCd");
		this.hashFields.put("kv_hjsc", "kvHjsc");
		this.hashFields.put("kv_ttl_mty_feu_qty", "kvTtlMtyFeuQty");
		this.hashFields.put("kv_ttl_mty_45ft_qty", "kvTtlMty45ftQty");
		this.hashFields.put("int_chk", "intChk");
		this.hashFields.put("sv_bl_s_cnt", "svBlSCnt");
		this.hashFields.put("sv_mea_qty", "svMeaQty");
		this.hashFields.put("sv_cntr_e_cnt", "svCntrECnt");
		this.hashFields.put("kv_f_date", "kvFDate");
		this.hashFields.put("kv_cstms_dchg_cd", "kvCstmsDchgCd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("kv_ttl_meas_qty", "kvTtlMeasQty");
		this.hashFields.put("sv_bl_m_cnt", "svBlMCnt");
		this.hashFields.put("kv_vsl_call_sgn", "kvVslCallSgn");
		this.hashFields.put("kv_ttl_mty_knt", "kvTtlMtyKnt");
		this.hashFields.put("pod_tml", "podTml");
		this.hashFields.put("new_mrn_chk_no", "newMrnChkNo");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("kv_ttl_full_knt", "kvTtlFullKnt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sv_bl_e_cnt", "svBlECnt");
		this.hashFields.put("kv_call_knt", "kvCallKnt");
		this.hashFields.put("in_bound", "inBound");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("old_cnt", "oldCnt");
		this.hashFields.put("kv_mst_bl_knt", "kvMstBlKnt");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("kv_jo_crr_knt", "kvJoCrrKnt");
		this.hashFields.put("kv_ttl_ts_feu_qty", "kvTtlTsFeuQty");
		this.hashFields.put("kv_cbm", "kvCbm");
		this.hashFields.put("kv_ttl_lc_45ft_qty", "kvTtlLc45ftQty");
		this.hashFields.put("trans_chk_cnt", "transChkCnt");
		this.hashFields.put("kv_port_cd_lo", "kvPortCdLo");
		this.hashFields.put("kv_vsl_cnt_cd", "kvVslCntCd");
		this.hashFields.put("trans_pre_cnt", "transPreCnt");
		this.hashFields.put("kv_vsl_nm", "kvVslNm");
		this.hashFields.put("sv_tot_ts_cntr_40", "svTotTsCntr40");
		this.hashFields.put("old_snd_chk", "oldSndChk");
		this.hashFields.put("kv_t_date", "kvTDate");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("sv_tot_ts_cntr_45", "svTotTsCntr45");
		this.hashFields.put("in_del_log", "inDelLog");
		this.hashFields.put("in_chg_meth", "inChgMeth");
		this.hashFields.put("kv_etd_dt", "kvEtdDt");
		this.hashFields.put("sv_wgt_qty", "svWgtQty");
		this.hashFields.put("kv_ttl_lc_teu_qty", "kvTtlLcTeuQty");
		this.hashFields.put("ob_type", "obType");
		this.hashFields.put("kv_bg", "kvBg");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("kv_sv_bl_s_cnt", "kvSvBlSCnt");
		this.hashFields.put("mrn_port", "mrnPort");
		this.hashFields.put("mrn_type", "mrnType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("createdtype", "createdtype");
		this.hashFields.put("kv_kgs", "kvKgs");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("sv_cntr_f_cnt", "svCntrFCnt");
		this.hashFields.put("sv_tot_ts_cntr_20", "svTotTsCntr20");
		this.hashFields.put("in_chg_comp", "inChgComp");
		this.hashFields.put("sv_tot_mt_cntr_20", "svTotMtCntr20");
		this.hashFields.put("kv_rpli_mrn_port", "kvRpliMrnPort");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("kv_ttl_wgt", "kvTtlWgt");
		this.hashFields.put("kv_ttl_lc_feu_qty", "kvTtlLcFeuQty");
		this.hashFields.put("ob_decl_tp_cd", "obDeclTpCd");
		this.hashFields.put("kv_ttl_ts_teu_qty", "kvTtlTsTeuQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inVvd
	 */
	public String getInVvd() {
		return this.inVvd;
	}
	
	/**
	 * Column Info
	 * @return kvPliMrnPort
	 */
	public String getKvPliMrnPort() {
		return this.kvPliMrnPort;
	}
	
	/**
	 * Column Info
	 * @return inPod
	 */
	public String getInPod() {
		return this.inPod;
	}
	
	/**
	 * Column Info
	 * @return kvTtlMtyTeuQty
	 */
	public String getKvTtlMtyTeuQty() {
		return this.kvTtlMtyTeuQty;
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
	 * @return kvPortCd
	 */
	public String getKvPortCd() {
		return this.kvPortCd;
	}
	
	/**
	 * Column Info
	 * @return kvMrnNo
	 */
	public String getKvMrnNo() {
		return this.kvMrnNo;
	}
	
	/**
	 * Column Info
	 * @return inPol
	 */
	public String getInPol() {
		return this.inPol;
	}
	
	/**
	 * Column Info
	 * @return svTotLcCntr40
	 */
	public String getSvTotLcCntr40() {
		return this.svTotLcCntr40;
	}
	
	/**
	 * Column Info
	 * @return svTotLcCntr45
	 */
	public String getSvTotLcCntr45() {
		return this.svTotLcCntr45;
	}
	
	/**
	 * Column Info
	 * @return kvTransChkCnt
	 */
	public String getKvTransChkCnt() {
		return this.kvTransChkCnt;
	}
	
	/**
	 * Column Info
	 * @return kvSpace
	 */
	public String getKvSpace() {
		return this.kvSpace;
	}
	
	/**
	 * Column Info
	 * @return kvMfSndDt
	 */
	public String getKvMfSndDt() {
		return this.kvMfSndDt;
	}
	
	/**
	 * Column Info
	 * @return kvMrnPort
	 */
	public String getKvMrnPort() {
		return this.kvMrnPort;
	}
	
	/**
	 * Column Info
	 * @return svPkgQty
	 */
	public String getSvPkgQty() {
		return this.svPkgQty;
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
	 * @return kvIoBndCdI
	 */
	public String getKvIoBndCdI() {
		return this.kvIoBndCdI;
	}
	
	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
	}
	
	/**
	 * Column Info
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Column Info
	 * @return kvTransPreCnt
	 */
	public String getKvTransPreCnt() {
		return this.kvTransPreCnt;
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
	 * @return kvIoBndCdO
	 */
	public String getKvIoBndCdO() {
		return this.kvIoBndCdO;
	}
	
	/**
	 * Column Info
	 * @return oldMrnChkNo
	 */
	public String getOldMrnChkNo() {
		return this.oldMrnChkNo;
	}
	
	/**
	 * Column Info
	 * @return kvCnslBlKnt
	 */
	public String getKvCnslBlKnt() {
		return this.kvCnslBlKnt;
	}
	
	/**
	 * Column Info
	 * @return kvIntChkCallKnt
	 */
	public String getKvIntChkCallKnt() {
		return this.kvIntChkCallKnt;
	}
	
	/**
	 * Column Info
	 * @return vvdSeq
	 */
	public String getVvdSeq() {
		return this.vvdSeq;
	}
	
	/**
	 * Column Info
	 * @return kvMfSndDd
	 */
	public String getKvMfSndDd() {
		return this.kvMfSndDd;
	}
	
	/**
	 * Column Info
	 * @return inChgPort
	 */
	public String getInChgPort() {
		return this.inChgPort;
	}
	
	/**
	 * Column Info
	 * @return kvBondAreaCode
	 */
	public String getKvBondAreaCode() {
		return this.kvBondAreaCode;
	}
	
	/**
	 * Column Info
	 * @return vvdPodTmnlCd
	 */
	public String getVvdPodTmnlCd() {
		return this.vvdPodTmnlCd;
	}
	
	/**
	 * Column Info
	 * @return bondAreaCode
	 */
	public String getBondAreaCode() {
		return this.bondAreaCode;
	}
	
	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
	}
	
	/**
	 * Column Info
	 * @return kvTtlPckQty
	 */
	public String getKvTtlPckQty() {
		return this.kvTtlPckQty;
	}
	
	/**
	 * Column Info
	 * @return jointCnt
	 */
	public String getJointCnt() {
		return this.jointCnt;
	}
	
	/**
	 * Column Info
	 * @return kvVvdSeq
	 */
	public String getKvVvdSeq() {
		return this.kvVvdSeq;
	}
	
	/**
	 * Column Info
	 * @return vslCallSign
	 */
	public String getVslCallSign() {
		return this.vslCallSign;
	}
	
	/**
	 * Column Info
	 * @return kvDchgMzdCd
	 */
	public String getKvDchgMzdCd() {
		return this.kvDchgMzdCd;
	}
	
	/**
	 * Column Info
	 * @return svBlCCnt
	 */
	public String getSvBlCCnt() {
		return this.svBlCCnt;
	}
	
	/**
	 * Column Info
	 * @return kvEtaDt
	 */
	public String getKvEtaDt() {
		return this.kvEtaDt;
	}
	
	/**
	 * Column Info
	 * @return maxSeq
	 */
	public String getMaxSeq() {
		return this.maxSeq;
	}
	
	/**
	 * Column Info
	 * @return newMrnNo
	 */
	public String getNewMrnNo() {
		return this.newMrnNo;
	}
	
	/**
	 * Column Info
	 * @return svTotMtCntr45
	 */
	public String getSvTotMtCntr45() {
		return this.svTotMtCntr45;
	}
	
	/**
	 * Column Info
	 * @return kvMfSndTt
	 */
	public String getKvMfSndTt() {
		return this.kvMfSndTt;
	}
	
	/**
	 * Column Info
	 * @return kvSeq
	 */
	public String getKvSeq() {
		return this.kvSeq;
	}
	
	/**
	 * Column Info
	 * @return kvTtlTs45ftQty
	 */
	public String getKvTtlTs45ftQty() {
		return this.kvTtlTs45ftQty;
	}
	
	/**
	 * Column Info
	 * @return kvIoTmlLocCd
	 */
	public String getKvIoTmlLocCd() {
		return this.kvIoTmlLocCd;
	}
	
	/**
	 * Column Info
	 * @return svTotMtCntr40
	 */
	public String getSvTotMtCntr40() {
		return this.svTotMtCntr40;
	}
	
	/**
	 * Column Info
	 * @return kvMtyBlKnt
	 */
	public String getKvMtyBlKnt() {
		return this.kvMtyBlKnt;
	}
	
	/**
	 * Column Info
	 * @return oldMrnNo
	 */
	public String getOldMrnNo() {
		return this.oldMrnNo;
	}
	
	/**
	 * Column Info
	 * @return kvIoBndCd
	 */
	public String getKvIoBndCd() {
		return this.kvIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return svTotLcCntr20
	 */
	public String getSvTotLcCntr20() {
		return this.svTotLcCntr20;
	}
	
	/**
	 * Column Info
	 * @return kvVvdCd
	 */
	public String getKvVvdCd() {
		return this.kvVvdCd;
	}
	
	/**
	 * Column Info
	 * @return kvHjsc
	 */
	public String getKvHjsc() {
		return this.kvHjsc;
	}
	
	/**
	 * Column Info
	 * @return kvTtlMtyFeuQty
	 */
	public String getKvTtlMtyFeuQty() {
		return this.kvTtlMtyFeuQty;
	}
	
	/**
	 * Column Info
	 * @return kvTtlMty45ftQty
	 */
	public String getKvTtlMty45ftQty() {
		return this.kvTtlMty45ftQty;
	}
	
	/**
	 * Column Info
	 * @return intChk
	 */
	public String getIntChk() {
		return this.intChk;
	}
	
	/**
	 * Column Info
	 * @return svBlSCnt
	 */
	public String getSvBlSCnt() {
		return this.svBlSCnt;
	}
	
	/**
	 * Column Info
	 * @return svMeaQty
	 */
	public String getSvMeaQty() {
		return this.svMeaQty;
	}
	
	/**
	 * Column Info
	 * @return svCntrECnt
	 */
	public String getSvCntrECnt() {
		return this.svCntrECnt;
	}
	
	/**
	 * Column Info
	 * @return kvFDate
	 */
	public String getKvFDate() {
		return this.kvFDate;
	}
	
	/**
	 * Column Info
	 * @return kvCstmsDchgCd
	 */
	public String getKvCstmsDchgCd() {
		return this.kvCstmsDchgCd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return kvTtlMeasQty
	 */
	public String getKvTtlMeasQty() {
		return this.kvTtlMeasQty;
	}
	
	/**
	 * Column Info
	 * @return svBlMCnt
	 */
	public String getSvBlMCnt() {
		return this.svBlMCnt;
	}
	
	/**
	 * Column Info
	 * @return kvVslCallSgn
	 */
	public String getKvVslCallSgn() {
		return this.kvVslCallSgn;
	}
	
	/**
	 * Column Info
	 * @return kvTtlMtyKnt
	 */
	public String getKvTtlMtyKnt() {
		return this.kvTtlMtyKnt;
	}
	
	/**
	 * Column Info
	 * @return podTml
	 */
	public String getPodTml() {
		return this.podTml;
	}
	
	/**
	 * Column Info
	 * @return newMrnChkNo
	 */
	public String getNewMrnChkNo() {
		return this.newMrnChkNo;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	
	/**
	 * Column Info
	 * @return kvTtlFullKnt
	 */
	public String getKvTtlFullKnt() {
		return this.kvTtlFullKnt;
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
	 * @return svBlECnt
	 */
	public String getSvBlECnt() {
		return this.svBlECnt;
	}
	
	/**
	 * Column Info
	 * @return kvCallKnt
	 */
	public String getKvCallKnt() {
		return this.kvCallKnt;
	}
	
	/**
	 * Column Info
	 * @return inBound
	 */
	public String getInBound() {
		return this.inBound;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return oldCnt
	 */
	public String getOldCnt() {
		return this.oldCnt;
	}
	
	/**
	 * Column Info
	 * @return kvMstBlKnt
	 */
	public String getKvMstBlKnt() {
		return this.kvMstBlKnt;
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
	 * @return kvJoCrrKnt
	 */
	public String getKvJoCrrKnt() {
		return this.kvJoCrrKnt;
	}
	
	/**
	 * Column Info
	 * @return kvTtlTsFeuQty
	 */
	public String getKvTtlTsFeuQty() {
		return this.kvTtlTsFeuQty;
	}
	
	/**
	 * Column Info
	 * @return kvCbm
	 */
	public String getKvCbm() {
		return this.kvCbm;
	}
	
	/**
	 * Column Info
	 * @return kvTtlLc45ftQty
	 */
	public String getKvTtlLc45ftQty() {
		return this.kvTtlLc45ftQty;
	}
	
	/**
	 * Column Info
	 * @return transChkCnt
	 */
	public String getTransChkCnt() {
		return this.transChkCnt;
	}
	
	/**
	 * Column Info
	 * @return kvPortCdLo
	 */
	public String getKvPortCdLo() {
		return this.kvPortCdLo;
	}
	
	/**
	 * Column Info
	 * @return kvVslCntCd
	 */
	public String getKvVslCntCd() {
		return this.kvVslCntCd;
	}
	
	/**
	 * Column Info
	 * @return transPreCnt
	 */
	public String getTransPreCnt() {
		return this.transPreCnt;
	}
	
	/**
	 * Column Info
	 * @return kvVslNm
	 */
	public String getKvVslNm() {
		return this.kvVslNm;
	}
	
	/**
	 * Column Info
	 * @return svTotTsCntr40
	 */
	public String getSvTotTsCntr40() {
		return this.svTotTsCntr40;
	}
	
	/**
	 * Column Info
	 * @return oldSndChk
	 */
	public String getOldSndChk() {
		return this.oldSndChk;
	}
	
	/**
	 * Column Info
	 * @return kvTDate
	 */
	public String getKvTDate() {
		return this.kvTDate;
	}
	
	/**
	 * Column Info
	 * @return mrnChkNo
	 */
	public String getMrnChkNo() {
		return this.mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @return svTotTsCntr45
	 */
	public String getSvTotTsCntr45() {
		return this.svTotTsCntr45;
	}
	
	/**
	 * Column Info
	 * @return inDelLog
	 */
	public String getInDelLog() {
		return this.inDelLog;
	}
	
	/**
	 * Column Info
	 * @return inChgMeth
	 */
	public String getInChgMeth() {
		return this.inChgMeth;
	}
	
	/**
	 * Column Info
	 * @return kvEtdDt
	 */
	public String getKvEtdDt() {
		return this.kvEtdDt;
	}
	
	/**
	 * Column Info
	 * @return svWgtQty
	 */
	public String getSvWgtQty() {
		return this.svWgtQty;
	}
	
	/**
	 * Column Info
	 * @return kvTtlLcTeuQty
	 */
	public String getKvTtlLcTeuQty() {
		return this.kvTtlLcTeuQty;
	}
	
	/**
	 * Column Info
	 * @return obType
	 */
	public String getObType() {
		return this.obType;
	}
	
	/**
	 * Column Info
	 * @return kvBg
	 */
	public String getKvBg() {
		return this.kvBg;
	}
	
	/**
	 * Column Info
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}
	
	/**
	 * Column Info
	 * @return kvSvBlSCnt
	 */
	public String getKvSvBlSCnt() {
		return this.kvSvBlSCnt;
	}
	
	/**
	 * Column Info
	 * @return mrnPort
	 */
	public String getMrnPort() {
		return this.mrnPort;
	}
	
	/**
	 * Column Info
	 * @return mrnType
	 */
	public String getMrnType() {
		return this.mrnType;
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
	 * @return createdtype
	 */
	public String getCreatedtype() {
		return this.createdtype;
	}
	
	/**
	 * Column Info
	 * @return kvKgs
	 */
	public String getKvKgs() {
		return this.kvKgs;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return svCntrFCnt
	 */
	public String getSvCntrFCnt() {
		return this.svCntrFCnt;
	}
	
	/**
	 * Column Info
	 * @return svTotTsCntr20
	 */
	public String getSvTotTsCntr20() {
		return this.svTotTsCntr20;
	}
	
	/**
	 * Column Info
	 * @return inChgComp
	 */
	public String getInChgComp() {
		return this.inChgComp;
	}
	
	/**
	 * Column Info
	 * @return svTotMtCntr20
	 */
	public String getSvTotMtCntr20() {
		return this.svTotMtCntr20;
	}
	
	/**
	 * Column Info
	 * @return kvRpliMrnPort
	 */
	public String getKvRpliMrnPort() {
		return this.kvRpliMrnPort;
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
	 * @return kvTtlWgt
	 */
	public String getKvTtlWgt() {
		return this.kvTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return kvTtlLcFeuQty
	 */
	public String getKvTtlLcFeuQty() {
		return this.kvTtlLcFeuQty;
	}
	
	/**
	 * Column Info
	 * @return obDeclTpCd
	 */
	public String getObDeclTpCd() {
		return this.obDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return kvTtlTsTeuQty
	 */
	public String getKvTtlTsTeuQty() {
		return this.kvTtlTsTeuQty;
	}
	

	/**
	 * Column Info
	 * @param inVvd
	 */
	public void setInVvd(String inVvd) {
		this.inVvd = inVvd;
	}
	
	/**
	 * Column Info
	 * @param kvPliMrnPort
	 */
	public void setKvPliMrnPort(String kvPliMrnPort) {
		this.kvPliMrnPort = kvPliMrnPort;
	}
	
	/**
	 * Column Info
	 * @param inPod
	 */
	public void setInPod(String inPod) {
		this.inPod = inPod;
	}
	
	/**
	 * Column Info
	 * @param kvTtlMtyTeuQty
	 */
	public void setKvTtlMtyTeuQty(String kvTtlMtyTeuQty) {
		this.kvTtlMtyTeuQty = kvTtlMtyTeuQty;
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
	 * @param kvPortCd
	 */
	public void setKvPortCd(String kvPortCd) {
		this.kvPortCd = kvPortCd;
	}
	
	/**
	 * Column Info
	 * @param kvMrnNo
	 */
	public void setKvMrnNo(String kvMrnNo) {
		this.kvMrnNo = kvMrnNo;
	}
	
	/**
	 * Column Info
	 * @param inPol
	 */
	public void setInPol(String inPol) {
		this.inPol = inPol;
	}
	
	/**
	 * Column Info
	 * @param svTotLcCntr40
	 */
	public void setSvTotLcCntr40(String svTotLcCntr40) {
		this.svTotLcCntr40 = svTotLcCntr40;
	}
	
	/**
	 * Column Info
	 * @param svTotLcCntr45
	 */
	public void setSvTotLcCntr45(String svTotLcCntr45) {
		this.svTotLcCntr45 = svTotLcCntr45;
	}
	
	/**
	 * Column Info
	 * @param kvTransChkCnt
	 */
	public void setKvTransChkCnt(String kvTransChkCnt) {
		this.kvTransChkCnt = kvTransChkCnt;
	}
	
	/**
	 * Column Info
	 * @param kvSpace
	 */
	public void setKvSpace(String kvSpace) {
		this.kvSpace = kvSpace;
	}
	
	/**
	 * Column Info
	 * @param kvMfSndDt
	 */
	public void setKvMfSndDt(String kvMfSndDt) {
		this.kvMfSndDt = kvMfSndDt;
	}
	
	/**
	 * Column Info
	 * @param kvMrnPort
	 */
	public void setKvMrnPort(String kvMrnPort) {
		this.kvMrnPort = kvMrnPort;
	}
	
	/**
	 * Column Info
	 * @param svPkgQty
	 */
	public void setSvPkgQty(String svPkgQty) {
		this.svPkgQty = svPkgQty;
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
	 * @param kvIoBndCdI
	 */
	public void setKvIoBndCdI(String kvIoBndCdI) {
		this.kvIoBndCdI = kvIoBndCdI;
	}
	
	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
	}
	
	/**
	 * Column Info
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Column Info
	 * @param kvTransPreCnt
	 */
	public void setKvTransPreCnt(String kvTransPreCnt) {
		this.kvTransPreCnt = kvTransPreCnt;
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
	 * @param kvIoBndCdO
	 */
	public void setKvIoBndCdO(String kvIoBndCdO) {
		this.kvIoBndCdO = kvIoBndCdO;
	}
	
	/**
	 * Column Info
	 * @param oldMrnChkNo
	 */
	public void setOldMrnChkNo(String oldMrnChkNo) {
		this.oldMrnChkNo = oldMrnChkNo;
	}
	
	/**
	 * Column Info
	 * @param kvCnslBlKnt
	 */
	public void setKvCnslBlKnt(String kvCnslBlKnt) {
		this.kvCnslBlKnt = kvCnslBlKnt;
	}
	
	/**
	 * Column Info
	 * @param kvIntChkCallKnt
	 */
	public void setKvIntChkCallKnt(String kvIntChkCallKnt) {
		this.kvIntChkCallKnt = kvIntChkCallKnt;
	}
	
	/**
	 * Column Info
	 * @param vvdSeq
	 */
	public void setVvdSeq(String vvdSeq) {
		this.vvdSeq = vvdSeq;
	}
	
	/**
	 * Column Info
	 * @param kvMfSndDd
	 */
	public void setKvMfSndDd(String kvMfSndDd) {
		this.kvMfSndDd = kvMfSndDd;
	}
	
	/**
	 * Column Info
	 * @param inChgPort
	 */
	public void setInChgPort(String inChgPort) {
		this.inChgPort = inChgPort;
	}
	
	/**
	 * Column Info
	 * @param kvBondAreaCode
	 */
	public void setKvBondAreaCode(String kvBondAreaCode) {
		this.kvBondAreaCode = kvBondAreaCode;
	}
	
	/**
	 * Column Info
	 * @param vvdPodTmnlCd
	 */
	public void setVvdPodTmnlCd(String vvdPodTmnlCd) {
		this.vvdPodTmnlCd = vvdPodTmnlCd;
	}
	
	/**
	 * Column Info
	 * @param bondAreaCode
	 */
	public void setBondAreaCode(String bondAreaCode) {
		this.bondAreaCode = bondAreaCode;
	}
	
	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}
	
	/**
	 * Column Info
	 * @param kvTtlPckQty
	 */
	public void setKvTtlPckQty(String kvTtlPckQty) {
		this.kvTtlPckQty = kvTtlPckQty;
	}
	
	/**
	 * Column Info
	 * @param jointCnt
	 */
	public void setJointCnt(String jointCnt) {
		this.jointCnt = jointCnt;
	}
	
	/**
	 * Column Info
	 * @param kvVvdSeq
	 */
	public void setKvVvdSeq(String kvVvdSeq) {
		this.kvVvdSeq = kvVvdSeq;
	}
	
	/**
	 * Column Info
	 * @param vslCallSign
	 */
	public void setVslCallSign(String vslCallSign) {
		this.vslCallSign = vslCallSign;
	}
	
	/**
	 * Column Info
	 * @param kvDchgMzdCd
	 */
	public void setKvDchgMzdCd(String kvDchgMzdCd) {
		this.kvDchgMzdCd = kvDchgMzdCd;
	}
	
	/**
	 * Column Info
	 * @param svBlCCnt
	 */
	public void setSvBlCCnt(String svBlCCnt) {
		this.svBlCCnt = svBlCCnt;
	}
	
	/**
	 * Column Info
	 * @param kvEtaDt
	 */
	public void setKvEtaDt(String kvEtaDt) {
		this.kvEtaDt = kvEtaDt;
	}
	
	/**
	 * Column Info
	 * @param maxSeq
	 */
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
	/**
	 * Column Info
	 * @param newMrnNo
	 */
	public void setNewMrnNo(String newMrnNo) {
		this.newMrnNo = newMrnNo;
	}
	
	/**
	 * Column Info
	 * @param svTotMtCntr45
	 */
	public void setSvTotMtCntr45(String svTotMtCntr45) {
		this.svTotMtCntr45 = svTotMtCntr45;
	}
	
	/**
	 * Column Info
	 * @param kvMfSndTt
	 */
	public void setKvMfSndTt(String kvMfSndTt) {
		this.kvMfSndTt = kvMfSndTt;
	}
	
	/**
	 * Column Info
	 * @param kvSeq
	 */
	public void setKvSeq(String kvSeq) {
		this.kvSeq = kvSeq;
	}
	
	/**
	 * Column Info
	 * @param kvTtlTs45ftQty
	 */
	public void setKvTtlTs45ftQty(String kvTtlTs45ftQty) {
		this.kvTtlTs45ftQty = kvTtlTs45ftQty;
	}
	
	/**
	 * Column Info
	 * @param kvIoTmlLocCd
	 */
	public void setKvIoTmlLocCd(String kvIoTmlLocCd) {
		this.kvIoTmlLocCd = kvIoTmlLocCd;
	}
	
	/**
	 * Column Info
	 * @param svTotMtCntr40
	 */
	public void setSvTotMtCntr40(String svTotMtCntr40) {
		this.svTotMtCntr40 = svTotMtCntr40;
	}
	
	/**
	 * Column Info
	 * @param kvMtyBlKnt
	 */
	public void setKvMtyBlKnt(String kvMtyBlKnt) {
		this.kvMtyBlKnt = kvMtyBlKnt;
	}
	
	/**
	 * Column Info
	 * @param oldMrnNo
	 */
	public void setOldMrnNo(String oldMrnNo) {
		this.oldMrnNo = oldMrnNo;
	}
	
	/**
	 * Column Info
	 * @param kvIoBndCd
	 */
	public void setKvIoBndCd(String kvIoBndCd) {
		this.kvIoBndCd = kvIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param svTotLcCntr20
	 */
	public void setSvTotLcCntr20(String svTotLcCntr20) {
		this.svTotLcCntr20 = svTotLcCntr20;
	}
	
	/**
	 * Column Info
	 * @param kvVvdCd
	 */
	public void setKvVvdCd(String kvVvdCd) {
		this.kvVvdCd = kvVvdCd;
	}
	
	/**
	 * Column Info
	 * @param kvHjsc
	 */
	public void setKvHjsc(String kvHjsc) {
		this.kvHjsc = kvHjsc;
	}
	
	/**
	 * Column Info
	 * @param kvTtlMtyFeuQty
	 */
	public void setKvTtlMtyFeuQty(String kvTtlMtyFeuQty) {
		this.kvTtlMtyFeuQty = kvTtlMtyFeuQty;
	}
	
	/**
	 * Column Info
	 * @param kvTtlMty45ftQty
	 */
	public void setKvTtlMty45ftQty(String kvTtlMty45ftQty) {
		this.kvTtlMty45ftQty = kvTtlMty45ftQty;
	}
	
	/**
	 * Column Info
	 * @param intChk
	 */
	public void setIntChk(String intChk) {
		this.intChk = intChk;
	}
	
	/**
	 * Column Info
	 * @param svBlSCnt
	 */
	public void setSvBlSCnt(String svBlSCnt) {
		this.svBlSCnt = svBlSCnt;
	}
	
	/**
	 * Column Info
	 * @param svMeaQty
	 */
	public void setSvMeaQty(String svMeaQty) {
		this.svMeaQty = svMeaQty;
	}
	
	/**
	 * Column Info
	 * @param svCntrECnt
	 */
	public void setSvCntrECnt(String svCntrECnt) {
		this.svCntrECnt = svCntrECnt;
	}
	
	/**
	 * Column Info
	 * @param kvFDate
	 */
	public void setKvFDate(String kvFDate) {
		this.kvFDate = kvFDate;
	}
	
	/**
	 * Column Info
	 * @param kvCstmsDchgCd
	 */
	public void setKvCstmsDchgCd(String kvCstmsDchgCd) {
		this.kvCstmsDchgCd = kvCstmsDchgCd;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param kvTtlMeasQty
	 */
	public void setKvTtlMeasQty(String kvTtlMeasQty) {
		this.kvTtlMeasQty = kvTtlMeasQty;
	}
	
	/**
	 * Column Info
	 * @param svBlMCnt
	 */
	public void setSvBlMCnt(String svBlMCnt) {
		this.svBlMCnt = svBlMCnt;
	}
	
	/**
	 * Column Info
	 * @param kvVslCallSgn
	 */
	public void setKvVslCallSgn(String kvVslCallSgn) {
		this.kvVslCallSgn = kvVslCallSgn;
	}
	
	/**
	 * Column Info
	 * @param kvTtlMtyKnt
	 */
	public void setKvTtlMtyKnt(String kvTtlMtyKnt) {
		this.kvTtlMtyKnt = kvTtlMtyKnt;
	}
	
	/**
	 * Column Info
	 * @param podTml
	 */
	public void setPodTml(String podTml) {
		this.podTml = podTml;
	}
	
	/**
	 * Column Info
	 * @param newMrnChkNo
	 */
	public void setNewMrnChkNo(String newMrnChkNo) {
		this.newMrnChkNo = newMrnChkNo;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Column Info
	 * @param kvTtlFullKnt
	 */
	public void setKvTtlFullKnt(String kvTtlFullKnt) {
		this.kvTtlFullKnt = kvTtlFullKnt;
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
	 * @param svBlECnt
	 */
	public void setSvBlECnt(String svBlECnt) {
		this.svBlECnt = svBlECnt;
	}
	
	/**
	 * Column Info
	 * @param kvCallKnt
	 */
	public void setKvCallKnt(String kvCallKnt) {
		this.kvCallKnt = kvCallKnt;
	}
	
	/**
	 * Column Info
	 * @param inBound
	 */
	public void setInBound(String inBound) {
		this.inBound = inBound;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param oldCnt
	 */
	public void setOldCnt(String oldCnt) {
		this.oldCnt = oldCnt;
	}
	
	/**
	 * Column Info
	 * @param kvMstBlKnt
	 */
	public void setKvMstBlKnt(String kvMstBlKnt) {
		this.kvMstBlKnt = kvMstBlKnt;
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
	 * @param kvJoCrrKnt
	 */
	public void setKvJoCrrKnt(String kvJoCrrKnt) {
		this.kvJoCrrKnt = kvJoCrrKnt;
	}
	
	/**
	 * Column Info
	 * @param kvTtlTsFeuQty
	 */
	public void setKvTtlTsFeuQty(String kvTtlTsFeuQty) {
		this.kvTtlTsFeuQty = kvTtlTsFeuQty;
	}
	
	/**
	 * Column Info
	 * @param kvCbm
	 */
	public void setKvCbm(String kvCbm) {
		this.kvCbm = kvCbm;
	}
	
	/**
	 * Column Info
	 * @param kvTtlLc45ftQty
	 */
	public void setKvTtlLc45ftQty(String kvTtlLc45ftQty) {
		this.kvTtlLc45ftQty = kvTtlLc45ftQty;
	}
	
	/**
	 * Column Info
	 * @param transChkCnt
	 */
	public void setTransChkCnt(String transChkCnt) {
		this.transChkCnt = transChkCnt;
	}
	
	/**
	 * Column Info
	 * @param kvPortCdLo
	 */
	public void setKvPortCdLo(String kvPortCdLo) {
		this.kvPortCdLo = kvPortCdLo;
	}
	
	/**
	 * Column Info
	 * @param kvVslCntCd
	 */
	public void setKvVslCntCd(String kvVslCntCd) {
		this.kvVslCntCd = kvVslCntCd;
	}
	
	/**
	 * Column Info
	 * @param transPreCnt
	 */
	public void setTransPreCnt(String transPreCnt) {
		this.transPreCnt = transPreCnt;
	}
	
	/**
	 * Column Info
	 * @param kvVslNm
	 */
	public void setKvVslNm(String kvVslNm) {
		this.kvVslNm = kvVslNm;
	}
	
	/**
	 * Column Info
	 * @param svTotTsCntr40
	 */
	public void setSvTotTsCntr40(String svTotTsCntr40) {
		this.svTotTsCntr40 = svTotTsCntr40;
	}
	
	/**
	 * Column Info
	 * @param oldSndChk
	 */
	public void setOldSndChk(String oldSndChk) {
		this.oldSndChk = oldSndChk;
	}
	
	/**
	 * Column Info
	 * @param kvTDate
	 */
	public void setKvTDate(String kvTDate) {
		this.kvTDate = kvTDate;
	}
	
	/**
	 * Column Info
	 * @param mrnChkNo
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @param svTotTsCntr45
	 */
	public void setSvTotTsCntr45(String svTotTsCntr45) {
		this.svTotTsCntr45 = svTotTsCntr45;
	}
	
	/**
	 * Column Info
	 * @param inDelLog
	 */
	public void setInDelLog(String inDelLog) {
		this.inDelLog = inDelLog;
	}
	
	/**
	 * Column Info
	 * @param inChgMeth
	 */
	public void setInChgMeth(String inChgMeth) {
		this.inChgMeth = inChgMeth;
	}
	
	/**
	 * Column Info
	 * @param kvEtdDt
	 */
	public void setKvEtdDt(String kvEtdDt) {
		this.kvEtdDt = kvEtdDt;
	}
	
	/**
	 * Column Info
	 * @param svWgtQty
	 */
	public void setSvWgtQty(String svWgtQty) {
		this.svWgtQty = svWgtQty;
	}
	
	/**
	 * Column Info
	 * @param kvTtlLcTeuQty
	 */
	public void setKvTtlLcTeuQty(String kvTtlLcTeuQty) {
		this.kvTtlLcTeuQty = kvTtlLcTeuQty;
	}
	
	/**
	 * Column Info
	 * @param obType
	 */
	public void setObType(String obType) {
		this.obType = obType;
	}
	
	/**
	 * Column Info
	 * @param kvBg
	 */
	public void setKvBg(String kvBg) {
		this.kvBg = kvBg;
	}
	
	/**
	 * Column Info
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}
	
	/**
	 * Column Info
	 * @param kvSvBlSCnt
	 */
	public void setKvSvBlSCnt(String kvSvBlSCnt) {
		this.kvSvBlSCnt = kvSvBlSCnt;
	}
	
	/**
	 * Column Info
	 * @param mrnPort
	 */
	public void setMrnPort(String mrnPort) {
		this.mrnPort = mrnPort;
	}
	
	/**
	 * Column Info
	 * @param mrnType
	 */
	public void setMrnType(String mrnType) {
		this.mrnType = mrnType;
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
	 * @param createdtype
	 */
	public void setCreatedtype(String createdtype) {
		this.createdtype = createdtype;
	}
	
	/**
	 * Column Info
	 * @param kvKgs
	 */
	public void setKvKgs(String kvKgs) {
		this.kvKgs = kvKgs;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param svCntrFCnt
	 */
	public void setSvCntrFCnt(String svCntrFCnt) {
		this.svCntrFCnt = svCntrFCnt;
	}
	
	/**
	 * Column Info
	 * @param svTotTsCntr20
	 */
	public void setSvTotTsCntr20(String svTotTsCntr20) {
		this.svTotTsCntr20 = svTotTsCntr20;
	}
	
	/**
	 * Column Info
	 * @param inChgComp
	 */
	public void setInChgComp(String inChgComp) {
		this.inChgComp = inChgComp;
	}
	
	/**
	 * Column Info
	 * @param svTotMtCntr20
	 */
	public void setSvTotMtCntr20(String svTotMtCntr20) {
		this.svTotMtCntr20 = svTotMtCntr20;
	}
	
	/**
	 * Column Info
	 * @param kvRpliMrnPort
	 */
	public void setKvRpliMrnPort(String kvRpliMrnPort) {
		this.kvRpliMrnPort = kvRpliMrnPort;
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
	 * @param kvTtlWgt
	 */
	public void setKvTtlWgt(String kvTtlWgt) {
		this.kvTtlWgt = kvTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param kvTtlLcFeuQty
	 */
	public void setKvTtlLcFeuQty(String kvTtlLcFeuQty) {
		this.kvTtlLcFeuQty = kvTtlLcFeuQty;
	}
	
	/**
	 * Column Info
	 * @param obDeclTpCd
	 */
	public void setObDeclTpCd(String obDeclTpCd) {
		this.obDeclTpCd = obDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param kvTtlTsTeuQty
	 */
	public void setKvTtlTsTeuQty(String kvTtlTsTeuQty) {
		this.kvTtlTsTeuQty = kvTtlTsTeuQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInVvd(JSPUtil.getParameter(request, "in_vvd", ""));
		setKvPliMrnPort(JSPUtil.getParameter(request, "kv_pli_mrn_port", ""));
		setInPod(JSPUtil.getParameter(request, "in_pod", ""));
		setKvTtlMtyTeuQty(JSPUtil.getParameter(request, "kv_ttl_mty_teu_qty", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setKvPortCd(JSPUtil.getParameter(request, "kv_port_cd", ""));
		setKvMrnNo(JSPUtil.getParameter(request, "kv_mrn_no", ""));
		setInPol(JSPUtil.getParameter(request, "in_pol", ""));
		setSvTotLcCntr40(JSPUtil.getParameter(request, "sv_tot_lc_cntr_40", ""));
		setSvTotLcCntr45(JSPUtil.getParameter(request, "sv_tot_lc_cntr_45", ""));
		setKvTransChkCnt(JSPUtil.getParameter(request, "kv_trans_chk_cnt", ""));
		setKvSpace(JSPUtil.getParameter(request, "kv_space", ""));
		setKvMfSndDt(JSPUtil.getParameter(request, "kv_mf_snd_dt", ""));
		setKvMrnPort(JSPUtil.getParameter(request, "kv_mrn_port", ""));
		setSvPkgQty(JSPUtil.getParameter(request, "sv_pkg_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKvIoBndCdI(JSPUtil.getParameter(request, "kv_io_bnd_cd_i", ""));
		setInType(JSPUtil.getParameter(request, "in_type", ""));
		setUsername(JSPUtil.getParameter(request, "username", ""));
		setKvTransPreCnt(JSPUtil.getParameter(request, "kv_trans_pre_cnt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setKvIoBndCdO(JSPUtil.getParameter(request, "kv_io_bnd_cd_o", ""));
		setOldMrnChkNo(JSPUtil.getParameter(request, "old_mrn_chk_no", ""));
		setKvCnslBlKnt(JSPUtil.getParameter(request, "kv_cnsl_bl_knt", ""));
		setKvIntChkCallKnt(JSPUtil.getParameter(request, "kv_int_chk_call_knt", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setKvMfSndDd(JSPUtil.getParameter(request, "kv_mf_snd_dd", ""));
		setInChgPort(JSPUtil.getParameter(request, "in_chg_port", ""));
		setKvBondAreaCode(JSPUtil.getParameter(request, "kv_bond_area_code", ""));
		setVvdPodTmnlCd(JSPUtil.getParameter(request, "vvd_pod_tmnl_cd", ""));
		setBondAreaCode(JSPUtil.getParameter(request, "bond_area_code", ""));
		setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
		setKvTtlPckQty(JSPUtil.getParameter(request, "kv_ttl_pck_qty", ""));
		setJointCnt(JSPUtil.getParameter(request, "joint_cnt", ""));
		setKvVvdSeq(JSPUtil.getParameter(request, "kv_vvd_seq", ""));
		setVslCallSign(JSPUtil.getParameter(request, "vsl_call_sign", ""));
		setKvDchgMzdCd(JSPUtil.getParameter(request, "kv_dchg_mzd_cd", ""));
		setSvBlCCnt(JSPUtil.getParameter(request, "sv_bl_c_cnt", ""));
		setKvEtaDt(JSPUtil.getParameter(request, "kv_eta_dt", ""));
		setMaxSeq(JSPUtil.getParameter(request, "max_seq", ""));
		setNewMrnNo(JSPUtil.getParameter(request, "new_mrn_no", ""));
		setSvTotMtCntr45(JSPUtil.getParameter(request, "sv_tot_mt_cntr_45", ""));
		setKvMfSndTt(JSPUtil.getParameter(request, "kv_mf_snd_tt", ""));
		setKvSeq(JSPUtil.getParameter(request, "kv_seq", ""));
		setKvTtlTs45ftQty(JSPUtil.getParameter(request, "kv_ttl_ts_45ft_qty", ""));
		setKvIoTmlLocCd(JSPUtil.getParameter(request, "kv_io_tml_loc_cd", ""));
		setSvTotMtCntr40(JSPUtil.getParameter(request, "sv_tot_mt_cntr_40", ""));
		setKvMtyBlKnt(JSPUtil.getParameter(request, "kv_mty_bl_knt", ""));
		setOldMrnNo(JSPUtil.getParameter(request, "old_mrn_no", ""));
		setKvIoBndCd(JSPUtil.getParameter(request, "kv_io_bnd_cd", ""));
		setSvTotLcCntr20(JSPUtil.getParameter(request, "sv_tot_lc_cntr_20", ""));
		setKvVvdCd(JSPUtil.getParameter(request, "kv_vvd_cd", ""));
		setKvHjsc(JSPUtil.getParameter(request, "kv_hjsc", ""));
		setKvTtlMtyFeuQty(JSPUtil.getParameter(request, "kv_ttl_mty_feu_qty", ""));
		setKvTtlMty45ftQty(JSPUtil.getParameter(request, "kv_ttl_mty_45ft_qty", ""));
		setIntChk(JSPUtil.getParameter(request, "int_chk", ""));
		setSvBlSCnt(JSPUtil.getParameter(request, "sv_bl_s_cnt", ""));
		setSvMeaQty(JSPUtil.getParameter(request, "sv_mea_qty", ""));
		setSvCntrECnt(JSPUtil.getParameter(request, "sv_cntr_e_cnt", ""));
		setKvFDate(JSPUtil.getParameter(request, "kv_f_date", ""));
		setKvCstmsDchgCd(JSPUtil.getParameter(request, "kv_cstms_dchg_cd", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setKvTtlMeasQty(JSPUtil.getParameter(request, "kv_ttl_meas_qty", ""));
		setSvBlMCnt(JSPUtil.getParameter(request, "sv_bl_m_cnt", ""));
		setKvVslCallSgn(JSPUtil.getParameter(request, "kv_vsl_call_sgn", ""));
		setKvTtlMtyKnt(JSPUtil.getParameter(request, "kv_ttl_mty_knt", ""));
		setPodTml(JSPUtil.getParameter(request, "pod_tml", ""));
		setNewMrnChkNo(JSPUtil.getParameter(request, "new_mrn_chk_no", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setKvTtlFullKnt(JSPUtil.getParameter(request, "kv_ttl_full_knt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSvBlECnt(JSPUtil.getParameter(request, "sv_bl_e_cnt", ""));
		setKvCallKnt(JSPUtil.getParameter(request, "kv_call_knt", ""));
		setInBound(JSPUtil.getParameter(request, "in_bound", ""));
		setVslFlag(JSPUtil.getParameter(request, "vsl_flag", ""));
		setOldCnt(JSPUtil.getParameter(request, "old_cnt", ""));
		setKvMstBlKnt(JSPUtil.getParameter(request, "kv_mst_bl_knt", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setKvJoCrrKnt(JSPUtil.getParameter(request, "kv_jo_crr_knt", ""));
		setKvTtlTsFeuQty(JSPUtil.getParameter(request, "kv_ttl_ts_feu_qty", ""));
		setKvCbm(JSPUtil.getParameter(request, "kv_cbm", ""));
		setKvTtlLc45ftQty(JSPUtil.getParameter(request, "kv_ttl_lc_45ft_qty", ""));
		setTransChkCnt(JSPUtil.getParameter(request, "trans_chk_cnt", ""));
		setKvPortCdLo(JSPUtil.getParameter(request, "kv_port_cd_lo", ""));
		setKvVslCntCd(JSPUtil.getParameter(request, "kv_vsl_cnt_cd", ""));
		setTransPreCnt(JSPUtil.getParameter(request, "trans_pre_cnt", ""));
		setKvVslNm(JSPUtil.getParameter(request, "kv_vsl_nm", ""));
		setSvTotTsCntr40(JSPUtil.getParameter(request, "sv_tot_ts_cntr_40", ""));
		setOldSndChk(JSPUtil.getParameter(request, "old_snd_chk", ""));
		setKvTDate(JSPUtil.getParameter(request, "kv_t_date", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setSvTotTsCntr45(JSPUtil.getParameter(request, "sv_tot_ts_cntr_45", ""));
		setInDelLog(JSPUtil.getParameter(request, "in_del_log", ""));
		setInChgMeth(JSPUtil.getParameter(request, "in_chg_meth", ""));
		setKvEtdDt(JSPUtil.getParameter(request, "kv_etd_dt", ""));
		setSvWgtQty(JSPUtil.getParameter(request, "sv_wgt_qty", ""));
		setKvTtlLcTeuQty(JSPUtil.getParameter(request, "kv_ttl_lc_teu_qty", ""));
		setObType(JSPUtil.getParameter(request, "ob_type", ""));
		setKvBg(JSPUtil.getParameter(request, "kv_bg", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setKvSvBlSCnt(JSPUtil.getParameter(request, "kv_sv_bl_s_cnt", ""));
		setMrnPort(JSPUtil.getParameter(request, "mrn_port", ""));
		setMrnType(JSPUtil.getParameter(request, "mrn_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreatedtype(JSPUtil.getParameter(request, "createdtype", ""));
		setKvKgs(JSPUtil.getParameter(request, "kv_kgs", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setSvCntrFCnt(JSPUtil.getParameter(request, "sv_cntr_f_cnt", ""));
		setSvTotTsCntr20(JSPUtil.getParameter(request, "sv_tot_ts_cntr_20", ""));
		setInChgComp(JSPUtil.getParameter(request, "in_chg_comp", ""));
		setSvTotMtCntr20(JSPUtil.getParameter(request, "sv_tot_mt_cntr_20", ""));
		setKvRpliMrnPort(JSPUtil.getParameter(request, "kv_rpli_mrn_port", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setKvTtlWgt(JSPUtil.getParameter(request, "kv_ttl_wgt", ""));
		setKvTtlLcFeuQty(JSPUtil.getParameter(request, "kv_ttl_lc_feu_qty", ""));
		setObDeclTpCd(JSPUtil.getParameter(request, "ob_decl_tp_cd", ""));
		setKvTtlTsTeuQty(JSPUtil.getParameter(request, "kv_ttl_ts_teu_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsKrVvdSmryVO[]
	 */
	public KorBkgCstmsVvdSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsKrVvdSmryVO[]
	 */
	public KorBkgCstmsVvdSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBkgCstmsVvdSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inVvd = (JSPUtil.getParameter(request, prefix	+ "in_vvd", length));
			String[] kvPliMrnPort = (JSPUtil.getParameter(request, prefix	+ "kv_pli_mrn_port", length));
			String[] inPod = (JSPUtil.getParameter(request, prefix	+ "in_pod", length));
			String[] kvTtlMtyTeuQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_mty_teu_qty", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] kvPortCd = (JSPUtil.getParameter(request, prefix	+ "kv_port_cd", length));
			String[] kvMrnNo = (JSPUtil.getParameter(request, prefix	+ "kv_mrn_no", length));
			String[] inPol = (JSPUtil.getParameter(request, prefix	+ "in_pol", length));
			String[] svTotLcCntr40 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_lc_cntr_40", length));
			String[] svTotLcCntr45 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_lc_cntr_45", length));
			String[] kvTransChkCnt = (JSPUtil.getParameter(request, prefix	+ "kv_trans_chk_cnt", length));
			String[] kvSpace = (JSPUtil.getParameter(request, prefix	+ "kv_space", length));
			String[] kvMfSndDt = (JSPUtil.getParameter(request, prefix	+ "kv_mf_snd_dt", length));
			String[] kvMrnPort = (JSPUtil.getParameter(request, prefix	+ "kv_mrn_port", length));
			String[] svPkgQty = (JSPUtil.getParameter(request, prefix	+ "sv_pkg_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] kvIoBndCdI = (JSPUtil.getParameter(request, prefix	+ "kv_io_bnd_cd_i", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
			String[] kvTransPreCnt = (JSPUtil.getParameter(request, prefix	+ "kv_trans_pre_cnt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] kvIoBndCdO = (JSPUtil.getParameter(request, prefix	+ "kv_io_bnd_cd_o", length));
			String[] oldMrnChkNo = (JSPUtil.getParameter(request, prefix	+ "old_mrn_chk_no", length));
			String[] kvCnslBlKnt = (JSPUtil.getParameter(request, prefix	+ "kv_cnsl_bl_knt", length));
			String[] kvIntChkCallKnt = (JSPUtil.getParameter(request, prefix	+ "kv_int_chk_call_knt", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] kvMfSndDd = (JSPUtil.getParameter(request, prefix	+ "kv_mf_snd_dd", length));
			String[] inChgPort = (JSPUtil.getParameter(request, prefix	+ "in_chg_port", length));
			String[] kvBondAreaCode = (JSPUtil.getParameter(request, prefix	+ "kv_bond_area_code", length));
			String[] vvdPodTmnlCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_tmnl_cd", length));
			String[] bondAreaCode = (JSPUtil.getParameter(request, prefix	+ "bond_area_code", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] kvTtlPckQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_pck_qty", length));
			String[] jointCnt = (JSPUtil.getParameter(request, prefix	+ "joint_cnt", length));
			String[] kvVvdSeq = (JSPUtil.getParameter(request, prefix	+ "kv_vvd_seq", length));
			String[] vslCallSign = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sign", length));
			String[] kvDchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "kv_dchg_mzd_cd", length));
			String[] svBlCCnt = (JSPUtil.getParameter(request, prefix	+ "sv_bl_c_cnt", length));
			String[] kvEtaDt = (JSPUtil.getParameter(request, prefix	+ "kv_eta_dt", length));
			String[] maxSeq = (JSPUtil.getParameter(request, prefix	+ "max_seq", length));
			String[] newMrnNo = (JSPUtil.getParameter(request, prefix	+ "new_mrn_no", length));
			String[] svTotMtCntr45 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_mt_cntr_45", length));
			String[] kvMfSndTt = (JSPUtil.getParameter(request, prefix	+ "kv_mf_snd_tt", length));
			String[] kvSeq = (JSPUtil.getParameter(request, prefix	+ "kv_seq", length));
			String[] kvTtlTs45ftQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_ts_45ft_qty", length));
			String[] kvIoTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "kv_io_tml_loc_cd", length));
			String[] svTotMtCntr40 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_mt_cntr_40", length));
			String[] kvMtyBlKnt = (JSPUtil.getParameter(request, prefix	+ "kv_mty_bl_knt", length));
			String[] oldMrnNo = (JSPUtil.getParameter(request, prefix	+ "old_mrn_no", length));
			String[] kvIoBndCd = (JSPUtil.getParameter(request, prefix	+ "kv_io_bnd_cd", length));
			String[] svTotLcCntr20 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_lc_cntr_20", length));
			String[] kvVvdCd = (JSPUtil.getParameter(request, prefix	+ "kv_vvd_cd", length));
			String[] kvHjsc = (JSPUtil.getParameter(request, prefix	+ "kv_hjsc", length));
			String[] kvTtlMtyFeuQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_mty_feu_qty", length));
			String[] kvTtlMty45ftQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_mty_45ft_qty", length));
			String[] intChk = (JSPUtil.getParameter(request, prefix	+ "int_chk", length));
			String[] svBlSCnt = (JSPUtil.getParameter(request, prefix	+ "sv_bl_s_cnt", length));
			String[] svMeaQty = (JSPUtil.getParameter(request, prefix	+ "sv_mea_qty", length));
			String[] svCntrECnt = (JSPUtil.getParameter(request, prefix	+ "sv_cntr_e_cnt", length));
			String[] kvFDate = (JSPUtil.getParameter(request, prefix	+ "kv_f_date", length));
			String[] kvCstmsDchgCd = (JSPUtil.getParameter(request, prefix	+ "kv_cstms_dchg_cd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] kvTtlMeasQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_meas_qty", length));
			String[] svBlMCnt = (JSPUtil.getParameter(request, prefix	+ "sv_bl_m_cnt", length));
			String[] kvVslCallSgn = (JSPUtil.getParameter(request, prefix	+ "kv_vsl_call_sgn", length));
			String[] kvTtlMtyKnt = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_mty_knt", length));
			String[] podTml = (JSPUtil.getParameter(request, prefix	+ "pod_tml", length));
			String[] newMrnChkNo = (JSPUtil.getParameter(request, prefix	+ "new_mrn_chk_no", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] kvTtlFullKnt = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_full_knt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] svBlECnt = (JSPUtil.getParameter(request, prefix	+ "sv_bl_e_cnt", length));
			String[] kvCallKnt = (JSPUtil.getParameter(request, prefix	+ "kv_call_knt", length));
			String[] inBound = (JSPUtil.getParameter(request, prefix	+ "in_bound", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] oldCnt = (JSPUtil.getParameter(request, prefix	+ "old_cnt", length));
			String[] kvMstBlKnt = (JSPUtil.getParameter(request, prefix	+ "kv_mst_bl_knt", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] kvJoCrrKnt = (JSPUtil.getParameter(request, prefix	+ "kv_jo_crr_knt", length));
			String[] kvTtlTsFeuQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_ts_feu_qty", length));
			String[] kvCbm = (JSPUtil.getParameter(request, prefix	+ "kv_cbm", length));
			String[] kvTtlLc45ftQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_lc_45ft_qty", length));
			String[] transChkCnt = (JSPUtil.getParameter(request, prefix	+ "trans_chk_cnt", length));
			String[] kvPortCdLo = (JSPUtil.getParameter(request, prefix	+ "kv_port_cd_lo", length));
			String[] kvVslCntCd = (JSPUtil.getParameter(request, prefix	+ "kv_vsl_cnt_cd", length));
			String[] transPreCnt = (JSPUtil.getParameter(request, prefix	+ "trans_pre_cnt", length));
			String[] kvVslNm = (JSPUtil.getParameter(request, prefix	+ "kv_vsl_nm", length));
			String[] svTotTsCntr40 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_ts_cntr_40", length));
			String[] oldSndChk = (JSPUtil.getParameter(request, prefix	+ "old_snd_chk", length));
			String[] kvTDate = (JSPUtil.getParameter(request, prefix	+ "kv_t_date", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] svTotTsCntr45 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_ts_cntr_45", length));
			String[] inDelLog = (JSPUtil.getParameter(request, prefix	+ "in_del_log", length));
			String[] inChgMeth = (JSPUtil.getParameter(request, prefix	+ "in_chg_meth", length));
			String[] kvEtdDt = (JSPUtil.getParameter(request, prefix	+ "kv_etd_dt", length));
			String[] svWgtQty = (JSPUtil.getParameter(request, prefix	+ "sv_wgt_qty", length));
			String[] kvTtlLcTeuQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_lc_teu_qty", length));
			String[] obType = (JSPUtil.getParameter(request, prefix	+ "ob_type", length));
			String[] kvBg = (JSPUtil.getParameter(request, prefix	+ "kv_bg", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] kvSvBlSCnt = (JSPUtil.getParameter(request, prefix	+ "kv_sv_bl_s_cnt", length));
			String[] mrnPort = (JSPUtil.getParameter(request, prefix	+ "mrn_port", length));
			String[] mrnType = (JSPUtil.getParameter(request, prefix	+ "mrn_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] createdtype = (JSPUtil.getParameter(request, prefix	+ "createdtype", length));
			String[] kvKgs = (JSPUtil.getParameter(request, prefix	+ "kv_kgs", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] svCntrFCnt = (JSPUtil.getParameter(request, prefix	+ "sv_cntr_f_cnt", length));
			String[] svTotTsCntr20 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_ts_cntr_20", length));
			String[] inChgComp = (JSPUtil.getParameter(request, prefix	+ "in_chg_comp", length));
			String[] svTotMtCntr20 = (JSPUtil.getParameter(request, prefix	+ "sv_tot_mt_cntr_20", length));
			String[] kvRpliMrnPort = (JSPUtil.getParameter(request, prefix	+ "kv_rpli_mrn_port", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] kvTtlWgt = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_wgt", length));
			String[] kvTtlLcFeuQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_lc_feu_qty", length));
			String[] obDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "ob_decl_tp_cd", length));
			String[] kvTtlTsTeuQty = (JSPUtil.getParameter(request, prefix	+ "kv_ttl_ts_teu_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBkgCstmsVvdSmryVO();
				if (inVvd[i] != null)
					model.setInVvd(inVvd[i]);
				if (kvPliMrnPort[i] != null)
					model.setKvPliMrnPort(kvPliMrnPort[i]);
				if (inPod[i] != null)
					model.setInPod(inPod[i]);
				if (kvTtlMtyTeuQty[i] != null)
					model.setKvTtlMtyTeuQty(kvTtlMtyTeuQty[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (kvPortCd[i] != null)
					model.setKvPortCd(kvPortCd[i]);
				if (kvMrnNo[i] != null)
					model.setKvMrnNo(kvMrnNo[i]);
				if (inPol[i] != null)
					model.setInPol(inPol[i]);
				if (svTotLcCntr40[i] != null)
					model.setSvTotLcCntr40(svTotLcCntr40[i]);
				if (svTotLcCntr45[i] != null)
					model.setSvTotLcCntr45(svTotLcCntr45[i]);
				if (kvTransChkCnt[i] != null)
					model.setKvTransChkCnt(kvTransChkCnt[i]);
				if (kvSpace[i] != null)
					model.setKvSpace(kvSpace[i]);
				if (kvMfSndDt[i] != null)
					model.setKvMfSndDt(kvMfSndDt[i]);
				if (kvMrnPort[i] != null)
					model.setKvMrnPort(kvMrnPort[i]);
				if (svPkgQty[i] != null)
					model.setSvPkgQty(svPkgQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (kvIoBndCdI[i] != null)
					model.setKvIoBndCdI(kvIoBndCdI[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (username[i] != null)
					model.setUsername(username[i]);
				if (kvTransPreCnt[i] != null)
					model.setKvTransPreCnt(kvTransPreCnt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (kvIoBndCdO[i] != null)
					model.setKvIoBndCdO(kvIoBndCdO[i]);
				if (oldMrnChkNo[i] != null)
					model.setOldMrnChkNo(oldMrnChkNo[i]);
				if (kvCnslBlKnt[i] != null)
					model.setKvCnslBlKnt(kvCnslBlKnt[i]);
				if (kvIntChkCallKnt[i] != null)
					model.setKvIntChkCallKnt(kvIntChkCallKnt[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (kvMfSndDd[i] != null)
					model.setKvMfSndDd(kvMfSndDd[i]);
				if (inChgPort[i] != null)
					model.setInChgPort(inChgPort[i]);
				if (kvBondAreaCode[i] != null)
					model.setKvBondAreaCode(kvBondAreaCode[i]);
				if (vvdPodTmnlCd[i] != null)
					model.setVvdPodTmnlCd(vvdPodTmnlCd[i]);
				if (bondAreaCode[i] != null)
					model.setBondAreaCode(bondAreaCode[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (kvTtlPckQty[i] != null)
					model.setKvTtlPckQty(kvTtlPckQty[i]);
				if (jointCnt[i] != null)
					model.setJointCnt(jointCnt[i]);
				if (kvVvdSeq[i] != null)
					model.setKvVvdSeq(kvVvdSeq[i]);
				if (vslCallSign[i] != null)
					model.setVslCallSign(vslCallSign[i]);
				if (kvDchgMzdCd[i] != null)
					model.setKvDchgMzdCd(kvDchgMzdCd[i]);
				if (svBlCCnt[i] != null)
					model.setSvBlCCnt(svBlCCnt[i]);
				if (kvEtaDt[i] != null)
					model.setKvEtaDt(kvEtaDt[i]);
				if (maxSeq[i] != null)
					model.setMaxSeq(maxSeq[i]);
				if (newMrnNo[i] != null)
					model.setNewMrnNo(newMrnNo[i]);
				if (svTotMtCntr45[i] != null)
					model.setSvTotMtCntr45(svTotMtCntr45[i]);
				if (kvMfSndTt[i] != null)
					model.setKvMfSndTt(kvMfSndTt[i]);
				if (kvSeq[i] != null)
					model.setKvSeq(kvSeq[i]);
				if (kvTtlTs45ftQty[i] != null)
					model.setKvTtlTs45ftQty(kvTtlTs45ftQty[i]);
				if (kvIoTmlLocCd[i] != null)
					model.setKvIoTmlLocCd(kvIoTmlLocCd[i]);
				if (svTotMtCntr40[i] != null)
					model.setSvTotMtCntr40(svTotMtCntr40[i]);
				if (kvMtyBlKnt[i] != null)
					model.setKvMtyBlKnt(kvMtyBlKnt[i]);
				if (oldMrnNo[i] != null)
					model.setOldMrnNo(oldMrnNo[i]);
				if (kvIoBndCd[i] != null)
					model.setKvIoBndCd(kvIoBndCd[i]);
				if (svTotLcCntr20[i] != null)
					model.setSvTotLcCntr20(svTotLcCntr20[i]);
				if (kvVvdCd[i] != null)
					model.setKvVvdCd(kvVvdCd[i]);
				if (kvHjsc[i] != null)
					model.setKvHjsc(kvHjsc[i]);
				if (kvTtlMtyFeuQty[i] != null)
					model.setKvTtlMtyFeuQty(kvTtlMtyFeuQty[i]);
				if (kvTtlMty45ftQty[i] != null)
					model.setKvTtlMty45ftQty(kvTtlMty45ftQty[i]);
				if (intChk[i] != null)
					model.setIntChk(intChk[i]);
				if (svBlSCnt[i] != null)
					model.setSvBlSCnt(svBlSCnt[i]);
				if (svMeaQty[i] != null)
					model.setSvMeaQty(svMeaQty[i]);
				if (svCntrECnt[i] != null)
					model.setSvCntrECnt(svCntrECnt[i]);
				if (kvFDate[i] != null)
					model.setKvFDate(kvFDate[i]);
				if (kvCstmsDchgCd[i] != null)
					model.setKvCstmsDchgCd(kvCstmsDchgCd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (kvTtlMeasQty[i] != null)
					model.setKvTtlMeasQty(kvTtlMeasQty[i]);
				if (svBlMCnt[i] != null)
					model.setSvBlMCnt(svBlMCnt[i]);
				if (kvVslCallSgn[i] != null)
					model.setKvVslCallSgn(kvVslCallSgn[i]);
				if (kvTtlMtyKnt[i] != null)
					model.setKvTtlMtyKnt(kvTtlMtyKnt[i]);
				if (podTml[i] != null)
					model.setPodTml(podTml[i]);
				if (newMrnChkNo[i] != null)
					model.setNewMrnChkNo(newMrnChkNo[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (kvTtlFullKnt[i] != null)
					model.setKvTtlFullKnt(kvTtlFullKnt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (svBlECnt[i] != null)
					model.setSvBlECnt(svBlECnt[i]);
				if (kvCallKnt[i] != null)
					model.setKvCallKnt(kvCallKnt[i]);
				if (inBound[i] != null)
					model.setInBound(inBound[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (oldCnt[i] != null)
					model.setOldCnt(oldCnt[i]);
				if (kvMstBlKnt[i] != null)
					model.setKvMstBlKnt(kvMstBlKnt[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (kvJoCrrKnt[i] != null)
					model.setKvJoCrrKnt(kvJoCrrKnt[i]);
				if (kvTtlTsFeuQty[i] != null)
					model.setKvTtlTsFeuQty(kvTtlTsFeuQty[i]);
				if (kvCbm[i] != null)
					model.setKvCbm(kvCbm[i]);
				if (kvTtlLc45ftQty[i] != null)
					model.setKvTtlLc45ftQty(kvTtlLc45ftQty[i]);
				if (transChkCnt[i] != null)
					model.setTransChkCnt(transChkCnt[i]);
				if (kvPortCdLo[i] != null)
					model.setKvPortCdLo(kvPortCdLo[i]);
				if (kvVslCntCd[i] != null)
					model.setKvVslCntCd(kvVslCntCd[i]);
				if (transPreCnt[i] != null)
					model.setTransPreCnt(transPreCnt[i]);
				if (kvVslNm[i] != null)
					model.setKvVslNm(kvVslNm[i]);
				if (svTotTsCntr40[i] != null)
					model.setSvTotTsCntr40(svTotTsCntr40[i]);
				if (oldSndChk[i] != null)
					model.setOldSndChk(oldSndChk[i]);
				if (kvTDate[i] != null)
					model.setKvTDate(kvTDate[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (svTotTsCntr45[i] != null)
					model.setSvTotTsCntr45(svTotTsCntr45[i]);
				if (inDelLog[i] != null)
					model.setInDelLog(inDelLog[i]);
				if (inChgMeth[i] != null)
					model.setInChgMeth(inChgMeth[i]);
				if (kvEtdDt[i] != null)
					model.setKvEtdDt(kvEtdDt[i]);
				if (svWgtQty[i] != null)
					model.setSvWgtQty(svWgtQty[i]);
				if (kvTtlLcTeuQty[i] != null)
					model.setKvTtlLcTeuQty(kvTtlLcTeuQty[i]);
				if (obType[i] != null)
					model.setObType(obType[i]);
				if (kvBg[i] != null)
					model.setKvBg(kvBg[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (kvSvBlSCnt[i] != null)
					model.setKvSvBlSCnt(kvSvBlSCnt[i]);
				if (mrnPort[i] != null)
					model.setMrnPort(mrnPort[i]);
				if (mrnType[i] != null)
					model.setMrnType(mrnType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (createdtype[i] != null)
					model.setCreatedtype(createdtype[i]);
				if (kvKgs[i] != null)
					model.setKvKgs(kvKgs[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (svCntrFCnt[i] != null)
					model.setSvCntrFCnt(svCntrFCnt[i]);
				if (svTotTsCntr20[i] != null)
					model.setSvTotTsCntr20(svTotTsCntr20[i]);
				if (inChgComp[i] != null)
					model.setInChgComp(inChgComp[i]);
				if (svTotMtCntr20[i] != null)
					model.setSvTotMtCntr20(svTotMtCntr20[i]);
				if (kvRpliMrnPort[i] != null)
					model.setKvRpliMrnPort(kvRpliMrnPort[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (kvTtlWgt[i] != null)
					model.setKvTtlWgt(kvTtlWgt[i]);
				if (kvTtlLcFeuQty[i] != null)
					model.setKvTtlLcFeuQty(kvTtlLcFeuQty[i]);
				if (obDeclTpCd[i] != null)
					model.setObDeclTpCd(obDeclTpCd[i]);
				if (kvTtlTsTeuQty[i] != null)
					model.setKvTtlTsTeuQty(kvTtlTsTeuQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsKrVvdSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsKrVvdSmryVO[]
	 */
	public KorBkgCstmsVvdSmryVO[] getBkgCstmsKrVvdSmryVOs(){
		KorBkgCstmsVvdSmryVO[] vos = (KorBkgCstmsVvdSmryVO[])models.toArray(new KorBkgCstmsVvdSmryVO[models.size()]);
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
		this.inVvd = this.inVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvPliMrnPort = this.kvPliMrnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPod = this.inPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlMtyTeuQty = this.kvTtlMtyTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvPortCd = this.kvPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvMrnNo = this.kvMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPol = this.inPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotLcCntr40 = this.svTotLcCntr40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotLcCntr45 = this.svTotLcCntr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTransChkCnt = this.kvTransChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvSpace = this.kvSpace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvMfSndDt = this.kvMfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvMrnPort = this.kvMrnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svPkgQty = this.svPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvIoBndCdI = this.kvIoBndCdI .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTransPreCnt = this.kvTransPreCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvIoBndCdO = this.kvIoBndCdO .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldMrnChkNo = this.oldMrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvCnslBlKnt = this.kvCnslBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvIntChkCallKnt = this.kvIntChkCallKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvMfSndDd = this.kvMfSndDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChgPort = this.inChgPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvBondAreaCode = this.kvBondAreaCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodTmnlCd = this.vvdPodTmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondAreaCode = this.bondAreaCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlPckQty = this.kvTtlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jointCnt = this.jointCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvVvdSeq = this.kvVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSign = this.vslCallSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvDchgMzdCd = this.kvDchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svBlCCnt = this.svBlCCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvEtaDt = this.kvEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSeq = this.maxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newMrnNo = this.newMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotMtCntr45 = this.svTotMtCntr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvMfSndTt = this.kvMfSndTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvSeq = this.kvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlTs45ftQty = this.kvTtlTs45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvIoTmlLocCd = this.kvIoTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotMtCntr40 = this.svTotMtCntr40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvMtyBlKnt = this.kvMtyBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldMrnNo = this.oldMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvIoBndCd = this.kvIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotLcCntr20 = this.svTotLcCntr20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvVvdCd = this.kvVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvHjsc = this.kvHjsc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlMtyFeuQty = this.kvTtlMtyFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlMty45ftQty = this.kvTtlMty45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intChk = this.intChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svBlSCnt = this.svBlSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svMeaQty = this.svMeaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svCntrECnt = this.svCntrECnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvFDate = this.kvFDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvCstmsDchgCd = this.kvCstmsDchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlMeasQty = this.kvTtlMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svBlMCnt = this.svBlMCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvVslCallSgn = this.kvVslCallSgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlMtyKnt = this.kvTtlMtyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTml = this.podTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newMrnChkNo = this.newMrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlFullKnt = this.kvTtlFullKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svBlECnt = this.svBlECnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvCallKnt = this.kvCallKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBound = this.inBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCnt = this.oldCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvMstBlKnt = this.kvMstBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvJoCrrKnt = this.kvJoCrrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlTsFeuQty = this.kvTtlTsFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvCbm = this.kvCbm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlLc45ftQty = this.kvTtlLc45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transChkCnt = this.transChkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvPortCdLo = this.kvPortCdLo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvVslCntCd = this.kvVslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transPreCnt = this.transPreCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvVslNm = this.kvVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotTsCntr40 = this.svTotTsCntr40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSndChk = this.oldSndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTDate = this.kvTDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotTsCntr45 = this.svTotTsCntr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inDelLog = this.inDelLog .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChgMeth = this.inChgMeth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvEtdDt = this.kvEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svWgtQty = this.svWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlLcTeuQty = this.kvTtlLcTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obType = this.obType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvBg = this.kvBg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvSvBlSCnt = this.kvSvBlSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPort = this.mrnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnType = this.mrnType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdtype = this.createdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvKgs = this.kvKgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svCntrFCnt = this.svCntrFCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotTsCntr20 = this.svTotTsCntr20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inChgComp = this.inChgComp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svTotMtCntr20 = this.svTotMtCntr20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvRpliMrnPort = this.kvRpliMrnPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlWgt = this.kvTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlLcFeuQty = this.kvTtlLcFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDeclTpCd = this.obDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvTtlTsTeuQty = this.kvTtlTsTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}