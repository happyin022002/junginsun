/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsKrVvdSmryVO.java
*@FileTitle : BkgCstmsKrVvdSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.30 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsKrVvdSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsKrVvdSmryVO> models = new ArrayList<BkgCstmsKrVvdSmryVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String smpBlKnt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String ttlTsTeuQty = null;
	/* Column Info */
	private String mstBlKnt = null;
	/* Column Info */
	private String ttlMeasUtCd = null;
	/* Column Info */
	private String loclCstmsPrtCd = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String ttlMty45ftQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cnslBlKnt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String vslCallSgnCd = null;
	/* Column Info */
	private String transPreCnt = null;
	/* Column Info */
	private String vvdSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ttlTsFeuQty = null;
	/* Column Info */
	private String joCrrKnt = null;
	/* Column Info */
	private String oldSndChk = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String loclCstmsCd = null;
	/* Column Info */
	private String dchgRptSndDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String fDate = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String ttlMeasQty = null;
	/* Column Info */
	private String ttlLcFeuQty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cstmsDchgCd = null;
	/* Column Info */
	private String ttlTs45ftQty = null;
	/* Column Info */
	private String callYear = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ttlFullKnt = null;
	/* Column Info */
	private String ttlLcTeuQty = null;
	/* Column Info */
	private String ttlLc45ftQty = null;
	/* Column Info */
	private String krVslCallSgnCd = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String ttlPckQty = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String vslCntCd = null;
	/* Column Info */
	private String mfSndUsrId = null;
	/* Column Info */
	private String rspnRcvDt = null;
	/* Column Info */
	private String ttlMtyTeuQty = null;
	/* Column Info */
	private String ttlMtyFeuQty = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ioTmlLocCd = null;
	/* Column Info */
	private String ttlWgtUtCd = null;
	/* Column Info */
	private String shpCoCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String bdAreaCd = null;
	/* Column Info */
	private String mtyBlKnt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ttlMtyKnt = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String ttlPckUtCd = null;
	/* Column Info */
	private String dchgRptSndUsrId = null;
	/* Column Info */
	private String podTml = null;
	/* Column Info */
	private String obDeclTpCd = null;
	/* Column Info */
	private String tDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsKrVvdSmryVO() {}

	public BkgCstmsKrVvdSmryVO(String ibflag, String pagerows, String vvd, String inType, String polCd, String podCd, String mrnChkNo, String mrnNo, String ioBndCd, String vvdSeq, String podTml, String vslCd, String skdVoyNo, String skdDirCd, String obDeclTpCd, String portCd, String vslCntCd, String vslNm, String krVslCallSgnCd, String etaDt, String etdDt, String mstBlKnt, String cnslBlKnt, String mtyBlKnt, String ttlWgt, String ttlMeasQty, String ttlPckQty, String ttlFullKnt, String ttlMtyKnt, String ttlLcTeuQty, String ttlLcFeuQty, String ttlLc45ftQty, String ttlTsTeuQty, String ttlTsFeuQty, String ttlTs45ftQty, String ttlMtyTeuQty, String ttlMtyFeuQty, String ttlMty45ftQty, String joCrrKnt, String creDt, String creUsrId, String updDt, String updUsrId, String mfSndDt, String mfSndUsrId, String rspnRcvDt, String cstmsDchgCd, String dchgRptSndDt, String dchgRptSndUsrId, String callKnt, String dchgMzdCd, String ioTmlLocCd, String fDate, String tDate, String transPreCnt, String bdAreaCd, String smpBlKnt, String shpCoCd, String ttlWgtUtCd, String ttlMeasUtCd, String ttlPckUtCd, String vslCallSgnCd, String loclCstmsCd, String loclCstmsPrtCd, String callYear, String ktPa, String userId, String oldSndChk) {
		this.vslCd = vslCd;
		this.smpBlKnt = smpBlKnt;
		this.etaDt = etaDt;
		this.ttlTsTeuQty = ttlTsTeuQty;
		this.mstBlKnt = mstBlKnt;
		this.ttlMeasUtCd = ttlMeasUtCd;
		this.loclCstmsPrtCd = loclCstmsPrtCd;
		this.mrnNo = mrnNo;
		this.ttlMty45ftQty = ttlMty45ftQty;
		this.pagerows = pagerows;
		this.inType = inType;
		this.polCd = polCd;
		this.cnslBlKnt = cnslBlKnt;
		this.userId = userId;
		this.vslCallSgnCd = vslCallSgnCd;
		this.transPreCnt = transPreCnt;
		this.vvdSeq = vvdSeq;
		this.updUsrId = updUsrId;
		this.ttlTsFeuQty = ttlTsFeuQty;
		this.joCrrKnt = joCrrKnt;
		this.oldSndChk = oldSndChk;
		this.mrnChkNo = mrnChkNo;
		this.loclCstmsCd = loclCstmsCd;
		this.dchgRptSndDt = dchgRptSndDt;
		this.skdVoyNo = skdVoyNo;
		this.fDate = fDate;
		this.dchgMzdCd = dchgMzdCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.ttlWgt = ttlWgt;
		this.ttlMeasQty = ttlMeasQty;
		this.ttlLcFeuQty = ttlLcFeuQty;
		this.creDt = creDt;
		this.cstmsDchgCd = cstmsDchgCd;
		this.ttlTs45ftQty = ttlTs45ftQty;
		this.callYear = callYear;
		this.ibflag = ibflag;
		this.ttlFullKnt = ttlFullKnt;
		this.ttlLcTeuQty = ttlLcTeuQty;
		this.ttlLc45ftQty = ttlLc45ftQty;
		this.krVslCallSgnCd = krVslCallSgnCd;
		this.mfSndDt = mfSndDt;
		this.callKnt = callKnt;
		this.ttlPckQty = ttlPckQty;
		this.portCd = portCd;
		this.vslCntCd = vslCntCd;
		this.mfSndUsrId = mfSndUsrId;
		this.rspnRcvDt = rspnRcvDt;
		this.ttlMtyTeuQty = ttlMtyTeuQty;
		this.ttlMtyFeuQty = ttlMtyFeuQty;
		this.updDt = updDt;
		this.ioTmlLocCd = ioTmlLocCd;
		this.ttlWgtUtCd = ttlWgtUtCd;
		this.shpCoCd = shpCoCd;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.bdAreaCd = bdAreaCd;
		this.mtyBlKnt = mtyBlKnt;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.ttlMtyKnt = ttlMtyKnt;
		this.ktPa = ktPa;
		this.ttlPckUtCd = ttlPckUtCd;
		this.dchgRptSndUsrId = dchgRptSndUsrId;
		this.podTml = podTml;
		this.obDeclTpCd = obDeclTpCd;
		this.tDate = tDate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("smp_bl_knt", getSmpBlKnt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("ttl_ts_teu_qty", getTtlTsTeuQty());
		this.hashColumns.put("mst_bl_knt", getMstBlKnt());
		this.hashColumns.put("ttl_meas_ut_cd", getTtlMeasUtCd());
		this.hashColumns.put("locl_cstms_prt_cd", getLoclCstmsPrtCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("ttl_mty_45ft_qty", getTtlMty45ftQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cnsl_bl_knt", getCnslBlKnt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("vsl_call_sgn_cd", getVslCallSgnCd());
		this.hashColumns.put("trans_pre_cnt", getTransPreCnt());
		this.hashColumns.put("vvd_seq", getVvdSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ttl_ts_feu_qty", getTtlTsFeuQty());
		this.hashColumns.put("jo_crr_knt", getJoCrrKnt());
		this.hashColumns.put("old_snd_chk", getOldSndChk());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("locl_cstms_cd", getLoclCstmsCd());
		this.hashColumns.put("dchg_rpt_snd_dt", getDchgRptSndDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("f_date", getFDate());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("ttl_meas_qty", getTtlMeasQty());
		this.hashColumns.put("ttl_lc_feu_qty", getTtlLcFeuQty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cstms_dchg_cd", getCstmsDchgCd());
		this.hashColumns.put("ttl_ts_45ft_qty", getTtlTs45ftQty());
		this.hashColumns.put("call_year", getCallYear());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ttl_full_knt", getTtlFullKnt());
		this.hashColumns.put("ttl_lc_teu_qty", getTtlLcTeuQty());
		this.hashColumns.put("ttl_lc_45ft_qty", getTtlLc45ftQty());
		this.hashColumns.put("kr_vsl_call_sgn_cd", getKrVslCallSgnCd());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("ttl_pck_qty", getTtlPckQty());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());
		this.hashColumns.put("mf_snd_usr_id", getMfSndUsrId());
		this.hashColumns.put("rspn_rcv_dt", getRspnRcvDt());
		this.hashColumns.put("ttl_mty_teu_qty", getTtlMtyTeuQty());
		this.hashColumns.put("ttl_mty_feu_qty", getTtlMtyFeuQty());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("ttl_wgt_ut_cd", getTtlWgtUtCd());
		this.hashColumns.put("shp_co_cd", getShpCoCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("bd_area_cd", getBdAreaCd());
		this.hashColumns.put("mty_bl_knt", getMtyBlKnt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ttl_mty_knt", getTtlMtyKnt());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("ttl_pck_ut_cd", getTtlPckUtCd());
		this.hashColumns.put("dchg_rpt_snd_usr_id", getDchgRptSndUsrId());
		this.hashColumns.put("pod_tml", getPodTml());
		this.hashColumns.put("ob_decl_tp_cd", getObDeclTpCd());
		this.hashColumns.put("t_date", getTDate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("smp_bl_knt", "smpBlKnt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("ttl_ts_teu_qty", "ttlTsTeuQty");
		this.hashFields.put("mst_bl_knt", "mstBlKnt");
		this.hashFields.put("ttl_meas_ut_cd", "ttlMeasUtCd");
		this.hashFields.put("locl_cstms_prt_cd", "loclCstmsPrtCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("ttl_mty_45ft_qty", "ttlMty45ftQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cnsl_bl_knt", "cnslBlKnt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("vsl_call_sgn_cd", "vslCallSgnCd");
		this.hashFields.put("trans_pre_cnt", "transPreCnt");
		this.hashFields.put("vvd_seq", "vvdSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ttl_ts_feu_qty", "ttlTsFeuQty");
		this.hashFields.put("jo_crr_knt", "joCrrKnt");
		this.hashFields.put("old_snd_chk", "oldSndChk");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("locl_cstms_cd", "loclCstmsCd");
		this.hashFields.put("dchg_rpt_snd_dt", "dchgRptSndDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("f_date", "fDate");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("ttl_meas_qty", "ttlMeasQty");
		this.hashFields.put("ttl_lc_feu_qty", "ttlLcFeuQty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cstms_dchg_cd", "cstmsDchgCd");
		this.hashFields.put("ttl_ts_45ft_qty", "ttlTs45ftQty");
		this.hashFields.put("call_year", "callYear");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_full_knt", "ttlFullKnt");
		this.hashFields.put("ttl_lc_teu_qty", "ttlLcTeuQty");
		this.hashFields.put("ttl_lc_45ft_qty", "ttlLc45ftQty");
		this.hashFields.put("kr_vsl_call_sgn_cd", "krVslCallSgnCd");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("ttl_pck_qty", "ttlPckQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("mf_snd_usr_id", "mfSndUsrId");
		this.hashFields.put("rspn_rcv_dt", "rspnRcvDt");
		this.hashFields.put("ttl_mty_teu_qty", "ttlMtyTeuQty");
		this.hashFields.put("ttl_mty_feu_qty", "ttlMtyFeuQty");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("ttl_wgt_ut_cd", "ttlWgtUtCd");
		this.hashFields.put("shp_co_cd", "shpCoCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("bd_area_cd", "bdAreaCd");
		this.hashFields.put("mty_bl_knt", "mtyBlKnt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ttl_mty_knt", "ttlMtyKnt");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("ttl_pck_ut_cd", "ttlPckUtCd");
		this.hashFields.put("dchg_rpt_snd_usr_id", "dchgRptSndUsrId");
		this.hashFields.put("pod_tml", "podTml");
		this.hashFields.put("ob_decl_tp_cd", "obDeclTpCd");
		this.hashFields.put("t_date", "tDate");
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
	 * @return smpBlKnt
	 */
	public String getSmpBlKnt() {
		return this.smpBlKnt;
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
	 * @return ttlTsTeuQty
	 */
	public String getTtlTsTeuQty() {
		return this.ttlTsTeuQty;
	}
	
	/**
	 * Column Info
	 * @return mstBlKnt
	 */
	public String getMstBlKnt() {
		return this.mstBlKnt;
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
	 * @return loclCstmsPrtCd
	 */
	public String getLoclCstmsPrtCd() {
		return this.loclCstmsPrtCd;
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
	 * @return ttlMty45ftQty
	 */
	public String getTtlMty45ftQty() {
		return this.ttlMty45ftQty;
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
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return cnslBlKnt
	 */
	public String getCnslBlKnt() {
		return this.cnslBlKnt;
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
	 * @return transPreCnt
	 */
	public String getTransPreCnt() {
		return this.transPreCnt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ttlTsFeuQty
	 */
	public String getTtlTsFeuQty() {
		return this.ttlTsFeuQty;
	}
	
	/**
	 * Column Info
	 * @return joCrrKnt
	 */
	public String getJoCrrKnt() {
		return this.joCrrKnt;
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
	 * @return mrnChkNo
	 */
	public String getMrnChkNo() {
		return this.mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @return loclCstmsCd
	 */
	public String getLoclCstmsCd() {
		return this.loclCstmsCd;
	}
	
	/**
	 * Column Info
	 * @return dchgRptSndDt
	 */
	public String getDchgRptSndDt() {
		return this.dchgRptSndDt;
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
	 * @return fDate
	 */
	public String getFDate() {
		return this.fDate;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return ttlLcFeuQty
	 */
	public String getTtlLcFeuQty() {
		return this.ttlLcFeuQty;
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
	 * @return cstmsDchgCd
	 */
	public String getCstmsDchgCd() {
		return this.cstmsDchgCd;
	}
	
	/**
	 * Column Info
	 * @return ttlTs45ftQty
	 */
	public String getTtlTs45ftQty() {
		return this.ttlTs45ftQty;
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
	 * @return ttlFullKnt
	 */
	public String getTtlFullKnt() {
		return this.ttlFullKnt;
	}
	
	/**
	 * Column Info
	 * @return ttlLcTeuQty
	 */
	public String getTtlLcTeuQty() {
		return this.ttlLcTeuQty;
	}
	
	/**
	 * Column Info
	 * @return ttlLc45ftQty
	 */
	public String getTtlLc45ftQty() {
		return this.ttlLc45ftQty;
	}
	
	/**
	 * Column Info
	 * @return krVslCallSgnCd
	 */
	public String getKrVslCallSgnCd() {
		return this.krVslCallSgnCd;
	}
	
	/**
	 * Column Info
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
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
	 * @return ttlPckQty
	 */
	public String getTtlPckQty() {
		return this.ttlPckQty;
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
	 * @return vslCntCd
	 */
	public String getVslCntCd() {
		return this.vslCntCd;
	}
	
	/**
	 * Column Info
	 * @return mfSndUsrId
	 */
	public String getMfSndUsrId() {
		return this.mfSndUsrId;
	}
	
	/**
	 * Column Info
	 * @return rspnRcvDt
	 */
	public String getRspnRcvDt() {
		return this.rspnRcvDt;
	}
	
	/**
	 * Column Info
	 * @return ttlMtyTeuQty
	 */
	public String getTtlMtyTeuQty() {
		return this.ttlMtyTeuQty;
	}
	
	/**
	 * Column Info
	 * @return ttlMtyFeuQty
	 */
	public String getTtlMtyFeuQty() {
		return this.ttlMtyFeuQty;
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
	 * @return ioTmlLocCd
	 */
	public String getIoTmlLocCd() {
		return this.ioTmlLocCd;
	}
	
	/**
	 * Column Info
	 * @return ttlWgtUtCd
	 */
	public String getTtlWgtUtCd() {
		return this.ttlWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return shpCoCd
	 */
	public String getShpCoCd() {
		return this.shpCoCd;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * @return mtyBlKnt
	 */
	public String getMtyBlKnt() {
		return this.mtyBlKnt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return ttlMtyKnt
	 */
	public String getTtlMtyKnt() {
		return this.ttlMtyKnt;
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
	 * @return ttlPckUtCd
	 */
	public String getTtlPckUtCd() {
		return this.ttlPckUtCd;
	}
	
	/**
	 * Column Info
	 * @return dchgRptSndUsrId
	 */
	public String getDchgRptSndUsrId() {
		return this.dchgRptSndUsrId;
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
	 * @return obDeclTpCd
	 */
	public String getObDeclTpCd() {
		return this.obDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return tDate
	 */
	public String getTDate() {
		return this.tDate;
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
	 * @param smpBlKnt
	 */
	public void setSmpBlKnt(String smpBlKnt) {
		this.smpBlKnt = smpBlKnt;
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
	 * @param ttlTsTeuQty
	 */
	public void setTtlTsTeuQty(String ttlTsTeuQty) {
		this.ttlTsTeuQty = ttlTsTeuQty;
	}
	
	/**
	 * Column Info
	 * @param mstBlKnt
	 */
	public void setMstBlKnt(String mstBlKnt) {
		this.mstBlKnt = mstBlKnt;
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
	 * @param loclCstmsPrtCd
	 */
	public void setLoclCstmsPrtCd(String loclCstmsPrtCd) {
		this.loclCstmsPrtCd = loclCstmsPrtCd;
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
	 * @param ttlMty45ftQty
	 */
	public void setTtlMty45ftQty(String ttlMty45ftQty) {
		this.ttlMty45ftQty = ttlMty45ftQty;
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
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param cnslBlKnt
	 */
	public void setCnslBlKnt(String cnslBlKnt) {
		this.cnslBlKnt = cnslBlKnt;
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
	 * @param transPreCnt
	 */
	public void setTransPreCnt(String transPreCnt) {
		this.transPreCnt = transPreCnt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ttlTsFeuQty
	 */
	public void setTtlTsFeuQty(String ttlTsFeuQty) {
		this.ttlTsFeuQty = ttlTsFeuQty;
	}
	
	/**
	 * Column Info
	 * @param joCrrKnt
	 */
	public void setJoCrrKnt(String joCrrKnt) {
		this.joCrrKnt = joCrrKnt;
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
	 * @param mrnChkNo
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @param loclCstmsCd
	 */
	public void setLoclCstmsCd(String loclCstmsCd) {
		this.loclCstmsCd = loclCstmsCd;
	}
	
	/**
	 * Column Info
	 * @param dchgRptSndDt
	 */
	public void setDchgRptSndDt(String dchgRptSndDt) {
		this.dchgRptSndDt = dchgRptSndDt;
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
	 * @param fDate
	 */
	public void setFDate(String fDate) {
		this.fDate = fDate;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param ttlLcFeuQty
	 */
	public void setTtlLcFeuQty(String ttlLcFeuQty) {
		this.ttlLcFeuQty = ttlLcFeuQty;
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
	 * @param cstmsDchgCd
	 */
	public void setCstmsDchgCd(String cstmsDchgCd) {
		this.cstmsDchgCd = cstmsDchgCd;
	}
	
	/**
	 * Column Info
	 * @param ttlTs45ftQty
	 */
	public void setTtlTs45ftQty(String ttlTs45ftQty) {
		this.ttlTs45ftQty = ttlTs45ftQty;
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
	 * @param ttlFullKnt
	 */
	public void setTtlFullKnt(String ttlFullKnt) {
		this.ttlFullKnt = ttlFullKnt;
	}
	
	/**
	 * Column Info
	 * @param ttlLcTeuQty
	 */
	public void setTtlLcTeuQty(String ttlLcTeuQty) {
		this.ttlLcTeuQty = ttlLcTeuQty;
	}
	
	/**
	 * Column Info
	 * @param ttlLc45ftQty
	 */
	public void setTtlLc45ftQty(String ttlLc45ftQty) {
		this.ttlLc45ftQty = ttlLc45ftQty;
	}
	
	/**
	 * Column Info
	 * @param krVslCallSgnCd
	 */
	public void setKrVslCallSgnCd(String krVslCallSgnCd) {
		this.krVslCallSgnCd = krVslCallSgnCd;
	}
	
	/**
	 * Column Info
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
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
	 * @param ttlPckQty
	 */
	public void setTtlPckQty(String ttlPckQty) {
		this.ttlPckQty = ttlPckQty;
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
	 * @param vslCntCd
	 */
	public void setVslCntCd(String vslCntCd) {
		this.vslCntCd = vslCntCd;
	}
	
	/**
	 * Column Info
	 * @param mfSndUsrId
	 */
	public void setMfSndUsrId(String mfSndUsrId) {
		this.mfSndUsrId = mfSndUsrId;
	}
	
	/**
	 * Column Info
	 * @param rspnRcvDt
	 */
	public void setRspnRcvDt(String rspnRcvDt) {
		this.rspnRcvDt = rspnRcvDt;
	}
	
	/**
	 * Column Info
	 * @param ttlMtyTeuQty
	 */
	public void setTtlMtyTeuQty(String ttlMtyTeuQty) {
		this.ttlMtyTeuQty = ttlMtyTeuQty;
	}
	
	/**
	 * Column Info
	 * @param ttlMtyFeuQty
	 */
	public void setTtlMtyFeuQty(String ttlMtyFeuQty) {
		this.ttlMtyFeuQty = ttlMtyFeuQty;
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
	 * @param ioTmlLocCd
	 */
	public void setIoTmlLocCd(String ioTmlLocCd) {
		this.ioTmlLocCd = ioTmlLocCd;
	}
	
	/**
	 * Column Info
	 * @param ttlWgtUtCd
	 */
	public void setTtlWgtUtCd(String ttlWgtUtCd) {
		this.ttlWgtUtCd = ttlWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param shpCoCd
	 */
	public void setShpCoCd(String shpCoCd) {
		this.shpCoCd = shpCoCd;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * @param mtyBlKnt
	 */
	public void setMtyBlKnt(String mtyBlKnt) {
		this.mtyBlKnt = mtyBlKnt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param ttlMtyKnt
	 */
	public void setTtlMtyKnt(String ttlMtyKnt) {
		this.ttlMtyKnt = ttlMtyKnt;
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
	 * @param ttlPckUtCd
	 */
	public void setTtlPckUtCd(String ttlPckUtCd) {
		this.ttlPckUtCd = ttlPckUtCd;
	}
	
	/**
	 * Column Info
	 * @param dchgRptSndUsrId
	 */
	public void setDchgRptSndUsrId(String dchgRptSndUsrId) {
		this.dchgRptSndUsrId = dchgRptSndUsrId;
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
	 * @param obDeclTpCd
	 */
	public void setObDeclTpCd(String obDeclTpCd) {
		this.obDeclTpCd = obDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param tDate
	 */
	public void setTDate(String tDate) {
		this.tDate = tDate;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSmpBlKnt(JSPUtil.getParameter(request, "smp_bl_knt", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setTtlTsTeuQty(JSPUtil.getParameter(request, "ttl_ts_teu_qty", ""));
		setMstBlKnt(JSPUtil.getParameter(request, "mst_bl_knt", ""));
		setTtlMeasUtCd(JSPUtil.getParameter(request, "ttl_meas_ut_cd", ""));
		setLoclCstmsPrtCd(JSPUtil.getParameter(request, "locl_cstms_prt_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setTtlMty45ftQty(JSPUtil.getParameter(request, "ttl_mty_45ft_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInType(JSPUtil.getParameter(request, "in_type", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCnslBlKnt(JSPUtil.getParameter(request, "cnsl_bl_knt", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setVslCallSgnCd(JSPUtil.getParameter(request, "vsl_call_sgn_cd", ""));
		setTransPreCnt(JSPUtil.getParameter(request, "trans_pre_cnt", ""));
		setVvdSeq(JSPUtil.getParameter(request, "vvd_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setTtlTsFeuQty(JSPUtil.getParameter(request, "ttl_ts_feu_qty", ""));
		setJoCrrKnt(JSPUtil.getParameter(request, "jo_crr_knt", ""));
		setOldSndChk(JSPUtil.getParameter(request, "old_snd_chk", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setLoclCstmsCd(JSPUtil.getParameter(request, "locl_cstms_cd", ""));
		setDchgRptSndDt(JSPUtil.getParameter(request, "dchg_rpt_snd_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setFDate(JSPUtil.getParameter(request, "f_date", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, "dchg_mzd_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTtlWgt(JSPUtil.getParameter(request, "ttl_wgt", ""));
		setTtlMeasQty(JSPUtil.getParameter(request, "ttl_meas_qty", ""));
		setTtlLcFeuQty(JSPUtil.getParameter(request, "ttl_lc_feu_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCstmsDchgCd(JSPUtil.getParameter(request, "cstms_dchg_cd", ""));
		setTtlTs45ftQty(JSPUtil.getParameter(request, "ttl_ts_45ft_qty", ""));
		setCallYear(JSPUtil.getParameter(request, "call_year", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTtlFullKnt(JSPUtil.getParameter(request, "ttl_full_knt", ""));
		setTtlLcTeuQty(JSPUtil.getParameter(request, "ttl_lc_teu_qty", ""));
		setTtlLc45ftQty(JSPUtil.getParameter(request, "ttl_lc_45ft_qty", ""));
		setKrVslCallSgnCd(JSPUtil.getParameter(request, "kr_vsl_call_sgn_cd", ""));
		setMfSndDt(JSPUtil.getParameter(request, "mf_snd_dt", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setTtlPckQty(JSPUtil.getParameter(request, "ttl_pck_qty", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setVslCntCd(JSPUtil.getParameter(request, "vsl_cnt_cd", ""));
		setMfSndUsrId(JSPUtil.getParameter(request, "mf_snd_usr_id", ""));
		setRspnRcvDt(JSPUtil.getParameter(request, "rspn_rcv_dt", ""));
		setTtlMtyTeuQty(JSPUtil.getParameter(request, "ttl_mty_teu_qty", ""));
		setTtlMtyFeuQty(JSPUtil.getParameter(request, "ttl_mty_feu_qty", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, "io_tml_loc_cd", ""));
		setTtlWgtUtCd(JSPUtil.getParameter(request, "ttl_wgt_ut_cd", ""));
		setShpCoCd(JSPUtil.getParameter(request, "shp_co_cd", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setBdAreaCd(JSPUtil.getParameter(request, "bd_area_cd", ""));
		setMtyBlKnt(JSPUtil.getParameter(request, "mty_bl_knt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setTtlMtyKnt(JSPUtil.getParameter(request, "ttl_mty_knt", ""));
		setKtPa(JSPUtil.getParameter(request, "kt_pa", ""));
		setTtlPckUtCd(JSPUtil.getParameter(request, "ttl_pck_ut_cd", ""));
		setDchgRptSndUsrId(JSPUtil.getParameter(request, "dchg_rpt_snd_usr_id", ""));
		setPodTml(JSPUtil.getParameter(request, "pod_tml", ""));
		setObDeclTpCd(JSPUtil.getParameter(request, "ob_decl_tp_cd", ""));
		setTDate(JSPUtil.getParameter(request, "t_date", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsKrVvdSmryVO[]
	 */
	public BkgCstmsKrVvdSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsKrVvdSmryVO[]
	 */
	public BkgCstmsKrVvdSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsKrVvdSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] smpBlKnt = (JSPUtil.getParameter(request, prefix	+ "smp_bl_knt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] ttlTsTeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_ts_teu_qty", length));
			String[] mstBlKnt = (JSPUtil.getParameter(request, prefix	+ "mst_bl_knt", length));
			String[] ttlMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_ut_cd", length));
			String[] loclCstmsPrtCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_prt_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] ttlMty45ftQty = (JSPUtil.getParameter(request, prefix	+ "ttl_mty_45ft_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cnslBlKnt = (JSPUtil.getParameter(request, prefix	+ "cnsl_bl_knt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] vslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sgn_cd", length));
			String[] transPreCnt = (JSPUtil.getParameter(request, prefix	+ "trans_pre_cnt", length));
			String[] vvdSeq = (JSPUtil.getParameter(request, prefix	+ "vvd_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ttlTsFeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_ts_feu_qty", length));
			String[] joCrrKnt = (JSPUtil.getParameter(request, prefix	+ "jo_crr_knt", length));
			String[] oldSndChk = (JSPUtil.getParameter(request, prefix	+ "old_snd_chk", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] loclCstmsCd = (JSPUtil.getParameter(request, prefix	+ "locl_cstms_cd", length));
			String[] dchgRptSndDt = (JSPUtil.getParameter(request, prefix	+ "dchg_rpt_snd_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] fDate = (JSPUtil.getParameter(request, prefix	+ "f_date", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] ttlMeasQty = (JSPUtil.getParameter(request, prefix	+ "ttl_meas_qty", length));
			String[] ttlLcFeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_lc_feu_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cstmsDchgCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_cd", length));
			String[] ttlTs45ftQty = (JSPUtil.getParameter(request, prefix	+ "ttl_ts_45ft_qty", length));
			String[] callYear = (JSPUtil.getParameter(request, prefix	+ "call_year", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ttlFullKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_full_knt", length));
			String[] ttlLcTeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_lc_teu_qty", length));
			String[] ttlLc45ftQty = (JSPUtil.getParameter(request, prefix	+ "ttl_lc_45ft_qty", length));
			String[] krVslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "kr_vsl_call_sgn_cd", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] ttlPckQty = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_qty", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] vslCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cnt_cd", length));
			String[] mfSndUsrId = (JSPUtil.getParameter(request, prefix	+ "mf_snd_usr_id", length));
			String[] rspnRcvDt = (JSPUtil.getParameter(request, prefix	+ "rspn_rcv_dt", length));
			String[] ttlMtyTeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_mty_teu_qty", length));
			String[] ttlMtyFeuQty = (JSPUtil.getParameter(request, prefix	+ "ttl_mty_feu_qty", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] ttlWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt_ut_cd", length));
			String[] shpCoCd = (JSPUtil.getParameter(request, prefix	+ "shp_co_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] bdAreaCd = (JSPUtil.getParameter(request, prefix	+ "bd_area_cd", length));
			String[] mtyBlKnt = (JSPUtil.getParameter(request, prefix	+ "mty_bl_knt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ttlMtyKnt = (JSPUtil.getParameter(request, prefix	+ "ttl_mty_knt", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] ttlPckUtCd = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_ut_cd", length));
			String[] dchgRptSndUsrId = (JSPUtil.getParameter(request, prefix	+ "dchg_rpt_snd_usr_id", length));
			String[] podTml = (JSPUtil.getParameter(request, prefix	+ "pod_tml", length));
			String[] obDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "ob_decl_tp_cd", length));
			String[] tDate = (JSPUtil.getParameter(request, prefix	+ "t_date", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsKrVvdSmryVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (smpBlKnt[i] != null)
					model.setSmpBlKnt(smpBlKnt[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (ttlTsTeuQty[i] != null)
					model.setTtlTsTeuQty(ttlTsTeuQty[i]);
				if (mstBlKnt[i] != null)
					model.setMstBlKnt(mstBlKnt[i]);
				if (ttlMeasUtCd[i] != null)
					model.setTtlMeasUtCd(ttlMeasUtCd[i]);
				if (loclCstmsPrtCd[i] != null)
					model.setLoclCstmsPrtCd(loclCstmsPrtCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (ttlMty45ftQty[i] != null)
					model.setTtlMty45ftQty(ttlMty45ftQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cnslBlKnt[i] != null)
					model.setCnslBlKnt(cnslBlKnt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (vslCallSgnCd[i] != null)
					model.setVslCallSgnCd(vslCallSgnCd[i]);
				if (transPreCnt[i] != null)
					model.setTransPreCnt(transPreCnt[i]);
				if (vvdSeq[i] != null)
					model.setVvdSeq(vvdSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ttlTsFeuQty[i] != null)
					model.setTtlTsFeuQty(ttlTsFeuQty[i]);
				if (joCrrKnt[i] != null)
					model.setJoCrrKnt(joCrrKnt[i]);
				if (oldSndChk[i] != null)
					model.setOldSndChk(oldSndChk[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (loclCstmsCd[i] != null)
					model.setLoclCstmsCd(loclCstmsCd[i]);
				if (dchgRptSndDt[i] != null)
					model.setDchgRptSndDt(dchgRptSndDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (fDate[i] != null)
					model.setFDate(fDate[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (ttlMeasQty[i] != null)
					model.setTtlMeasQty(ttlMeasQty[i]);
				if (ttlLcFeuQty[i] != null)
					model.setTtlLcFeuQty(ttlLcFeuQty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cstmsDchgCd[i] != null)
					model.setCstmsDchgCd(cstmsDchgCd[i]);
				if (ttlTs45ftQty[i] != null)
					model.setTtlTs45ftQty(ttlTs45ftQty[i]);
				if (callYear[i] != null)
					model.setCallYear(callYear[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ttlFullKnt[i] != null)
					model.setTtlFullKnt(ttlFullKnt[i]);
				if (ttlLcTeuQty[i] != null)
					model.setTtlLcTeuQty(ttlLcTeuQty[i]);
				if (ttlLc45ftQty[i] != null)
					model.setTtlLc45ftQty(ttlLc45ftQty[i]);
				if (krVslCallSgnCd[i] != null)
					model.setKrVslCallSgnCd(krVslCallSgnCd[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (ttlPckQty[i] != null)
					model.setTtlPckQty(ttlPckQty[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (vslCntCd[i] != null)
					model.setVslCntCd(vslCntCd[i]);
				if (mfSndUsrId[i] != null)
					model.setMfSndUsrId(mfSndUsrId[i]);
				if (rspnRcvDt[i] != null)
					model.setRspnRcvDt(rspnRcvDt[i]);
				if (ttlMtyTeuQty[i] != null)
					model.setTtlMtyTeuQty(ttlMtyTeuQty[i]);
				if (ttlMtyFeuQty[i] != null)
					model.setTtlMtyFeuQty(ttlMtyFeuQty[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (ttlWgtUtCd[i] != null)
					model.setTtlWgtUtCd(ttlWgtUtCd[i]);
				if (shpCoCd[i] != null)
					model.setShpCoCd(shpCoCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (bdAreaCd[i] != null)
					model.setBdAreaCd(bdAreaCd[i]);
				if (mtyBlKnt[i] != null)
					model.setMtyBlKnt(mtyBlKnt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ttlMtyKnt[i] != null)
					model.setTtlMtyKnt(ttlMtyKnt[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (ttlPckUtCd[i] != null)
					model.setTtlPckUtCd(ttlPckUtCd[i]);
				if (dchgRptSndUsrId[i] != null)
					model.setDchgRptSndUsrId(dchgRptSndUsrId[i]);
				if (podTml[i] != null)
					model.setPodTml(podTml[i]);
				if (obDeclTpCd[i] != null)
					model.setObDeclTpCd(obDeclTpCd[i]);
				if (tDate[i] != null)
					model.setTDate(tDate[i]);
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
	public BkgCstmsKrVvdSmryVO[] getBkgCstmsKrVvdSmryVOs(){
		BkgCstmsKrVvdSmryVO[] vos = (BkgCstmsKrVvdSmryVO[])models.toArray(new BkgCstmsKrVvdSmryVO[models.size()]);
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
		this.smpBlKnt = this.smpBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTsTeuQty = this.ttlTsTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlKnt = this.mstBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMeasUtCd = this.ttlMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsPrtCd = this.loclCstmsPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMty45ftQty = this.ttlMty45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnslBlKnt = this.cnslBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSgnCd = this.vslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transPreCnt = this.transPreCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSeq = this.vvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTsFeuQty = this.ttlTsFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrKnt = this.joCrrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldSndChk = this.oldSndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCstmsCd = this.loclCstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgRptSndDt = this.dchgRptSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fDate = this.fDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMeasQty = this.ttlMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLcFeuQty = this.ttlLcFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDchgCd = this.cstmsDchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTs45ftQty = this.ttlTs45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYear = this.callYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlFullKnt = this.ttlFullKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLcTeuQty = this.ttlLcTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLc45ftQty = this.ttlLc45ftQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krVslCallSgnCd = this.krVslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckQty = this.ttlPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd = this.vslCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndUsrId = this.mfSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rspnRcvDt = this.rspnRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMtyTeuQty = this.ttlMtyTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMtyFeuQty = this.ttlMtyFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgtUtCd = this.ttlWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCoCd = this.shpCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdAreaCd = this.bdAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBlKnt = this.mtyBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlMtyKnt = this.ttlMtyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckUtCd = this.ttlPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgRptSndUsrId = this.dchgRptSndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podTml = this.podTml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obDeclTpCd = this.obDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tDate = this.tDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
