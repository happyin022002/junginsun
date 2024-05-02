/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24BlGeneralInfoVO.java
*@FileTitle : Eur24BlGeneralInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.03.03 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

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

public class Eur24BlGeneralInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlGeneralInfoVO> models = new ArrayList<Eur24BlGeneralInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String drYn = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String arnYn = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String hisAckCd = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String msgFuncHold = null;
	/* Column Info */
	private String searchPrevDocNo = null;
	/* Column Info */
	private String cstmsDeclDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String blMrnYn = null;
	/* Column Info */
	private String ensEdiSvcFlg = null;
	/* Column Info */
	private String localTime = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String exsEdiSvcFlg = null;
	/* Column Info */
	private String trsmBlckFlg = null;
	/* Column Info */
	private String rcvMvmtRefNo = null;
	/* Column Info */
	private String mvmtRefNo1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ackCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String msgFuncId = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String errYn = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String trsmVal = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String mvmtRefNo = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String ktsSendDt = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String ataYn = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String prevDocNos = null;
	/* Column Info */
	private String ktsSendDt2 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String ktsSendDt1 = null;
	/* Column Info */
	private String errYns = null;
	/* Column Info */
	private String trspDocNo = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String msgSndNo = null;
	/* Column Info */
	private String prevDocNo = null;
	/* Column Info */
	private String declLocCd = null;
	/* Column Info */
	private String typeCd = null;
	/* Column Info */
	private String euStfFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlGeneralInfoVO() {}

	public Eur24BlGeneralInfoVO(String ibflag, String pagerows, String porCd, String vslCd, String polNm, String sndDt, String blNo, String polCd, String bkgPodCd, String vslEngNm, String cmdtCd, String msgFuncId, String cstmsDesc, String wgtUtCd, String measQty, String pckQty, String rcvTermCd, String podYdCd, String measUtCd, String mvmtRefNo, String pckTpCd, String cstmsPortCd, String bkgPolCd, String podNm, String delNm, String cstmsDeclDt, String delCd, String skdVoyNo, String skdDirCd, String actWgt, String podCd, String vvd, String deTermCd, String lloydNo, String trspDocNo, String polYdCd, String msgSndNo, String declLocCd, String typeCd, String errYn, String ensEdiSvcFlg, String exsEdiSvcFlg, String drYn, String ktsSendDt, String ataYn, String arnYn, String rcvMvmtRefNo, String blMrnYn, String errYns, String ktsSendDt1, String ktsSendDt2, String mvmtRefNo1, String prevDocNo, String prevDocNos, String searchPrevDocNo, String localTime, String ackCd, String hisAckCd, String msgFuncHold, String trsmBlckFlg, String trsmVal, String euStfFlg) {
		this.vslCd = vslCd;
		this.drYn = drYn;
		this.polNm = polNm;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.bkgPodCd = bkgPodCd;
		this.arnYn = arnYn;
		this.wgtUtCd = wgtUtCd;
		this.hisAckCd = hisAckCd;
		this.cstmsPortCd = cstmsPortCd;
		this.msgFuncHold = msgFuncHold;
		this.searchPrevDocNo = searchPrevDocNo;
		this.cstmsDeclDt = cstmsDeclDt;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.podCd = podCd;
		this.vvd = vvd;
		this.lloydNo = lloydNo;
		this.blMrnYn = blMrnYn;
		this.ensEdiSvcFlg = ensEdiSvcFlg;
		this.localTime = localTime;
		this.porCd = porCd;
		this.exsEdiSvcFlg = exsEdiSvcFlg;
		this.trsmBlckFlg = trsmBlckFlg;
		this.rcvMvmtRefNo = rcvMvmtRefNo;
		this.mvmtRefNo1 = mvmtRefNo1;
		this.ibflag = ibflag;
		this.ackCd = ackCd;
		this.vslEngNm = vslEngNm;
		this.cmdtCd = cmdtCd;
		this.msgFuncId = msgFuncId;
		this.cstmsDesc = cstmsDesc;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.errYn = errYn;
		this.rcvTermCd = rcvTermCd;
		this.trsmVal = trsmVal;
		this.pckTpCd = pckTpCd;
		this.mvmtRefNo = mvmtRefNo;
		this.measUtCd = measUtCd;
		this.podYdCd = podYdCd;
		this.bkgPolCd = bkgPolCd;
		this.ktsSendDt = ktsSendDt;
		this.podNm = podNm;
		this.ataYn = ataYn;
		this.delNm = delNm;
		this.prevDocNos = prevDocNos;
		this.ktsSendDt2 = ktsSendDt2;
		this.skdDirCd = skdDirCd;
		this.actWgt = actWgt;
		this.deTermCd = deTermCd;
		this.ktsSendDt1 = ktsSendDt1;
		this.errYns = errYns;
		this.trspDocNo = trspDocNo;
		this.polYdCd = polYdCd;
		this.msgSndNo = msgSndNo;
		this.prevDocNo = prevDocNo;
		this.declLocCd = declLocCd;
		this.typeCd = typeCd;
		this.euStfFlg = euStfFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dr_yn", getDrYn());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("arn_yn", getArnYn());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("his_ack_cd", getHisAckCd());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("msg_func_hold", getMsgFuncHold());
		this.hashColumns.put("search_prev_doc_no", getSearchPrevDocNo());
		this.hashColumns.put("cstms_decl_dt", getCstmsDeclDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("bl_mrn_yn", getBlMrnYn());
		this.hashColumns.put("ens_edi_svc_flg", getEnsEdiSvcFlg());
		this.hashColumns.put("local_time", getLocalTime());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("exs_edi_svc_flg", getExsEdiSvcFlg());
		this.hashColumns.put("trsm_blck_flg", getTrsmBlckFlg());
		this.hashColumns.put("rcv_mvmt_ref_no", getRcvMvmtRefNo());
		this.hashColumns.put("mvmt_ref_no1", getMvmtRefNo1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ack_cd", getAckCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("msg_func_id", getMsgFuncId());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("err_yn", getErrYn());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("trsm_val", getTrsmVal());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("mvmt_ref_no", getMvmtRefNo());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("kts_send_dt", getKtsSendDt());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("ata_yn", getAtaYn());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("prev_doc_nos", getPrevDocNos());
		this.hashColumns.put("kts_send_dt2", getKtsSendDt2());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("kts_send_dt1", getKtsSendDt1());
		this.hashColumns.put("err_yns", getErrYns());
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		this.hashColumns.put("prev_doc_no", getPrevDocNo());
		this.hashColumns.put("decl_loc_cd", getDeclLocCd());
		this.hashColumns.put("type_cd", getTypeCd());
		this.hashColumns.put("eu_stf_flg", getEuStfFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dr_yn", "drYn");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("arn_yn", "arnYn");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("his_ack_cd", "hisAckCd");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("msg_func_hold", "msgFuncHold");
		this.hashFields.put("search_prev_doc_no", "searchPrevDocNo");
		this.hashFields.put("cstms_decl_dt", "cstmsDeclDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("bl_mrn_yn", "blMrnYn");
		this.hashFields.put("ens_edi_svc_flg", "ensEdiSvcFlg");
		this.hashFields.put("local_time", "localTime");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("exs_edi_svc_flg", "exsEdiSvcFlg");
		this.hashFields.put("trsm_blck_flg", "trsmBlckFlg");
		this.hashFields.put("rcv_mvmt_ref_no", "rcvMvmtRefNo");
		this.hashFields.put("mvmt_ref_no1", "mvmtRefNo1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ack_cd", "ackCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("msg_func_id", "msgFuncId");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("err_yn", "errYn");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("trsm_val", "trsmVal");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("mvmt_ref_no", "mvmtRefNo");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("kts_send_dt", "ktsSendDt");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("ata_yn", "ataYn");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("prev_doc_nos", "prevDocNos");
		this.hashFields.put("kts_send_dt2", "ktsSendDt2");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("kts_send_dt1", "ktsSendDt1");
		this.hashFields.put("err_yns", "errYns");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		this.hashFields.put("prev_doc_no", "prevDocNo");
		this.hashFields.put("decl_loc_cd", "declLocCd");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("eu_stf_flg", "euStfFlg");
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
	 * @return drYn
	 */
	public String getDrYn() {
		return this.drYn;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return arnYn
	 */
	public String getArnYn() {
		return this.arnYn;
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
	 * @return hisAckCd
	 */
	public String getHisAckCd() {
		return this.hisAckCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return msgFuncHold
	 */
	public String getMsgFuncHold() {
		return this.msgFuncHold;
	}
	
	/**
	 * Column Info
	 * @return searchPrevDocNo
	 */
	public String getSearchPrevDocNo() {
		return this.searchPrevDocNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclDt
	 */
	public String getCstmsDeclDt() {
		return this.cstmsDeclDt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return blMrnYn
	 */
	public String getBlMrnYn() {
		return this.blMrnYn;
	}
	
	/**
	 * Column Info
	 * @return ensEdiSvcFlg
	 */
	public String getEnsEdiSvcFlg() {
		return this.ensEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return localTime
	 */
	public String getLocalTime() {
		return this.localTime;
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
	 * @return exsEdiSvcFlg
	 */
	public String getExsEdiSvcFlg() {
		return this.exsEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return trsmBlckFlg
	 */
	public String getTrsmBlckFlg() {
		return this.trsmBlckFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvMvmtRefNo
	 */
	public String getRcvMvmtRefNo() {
		return this.rcvMvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtRefNo1
	 */
	public String getMvmtRefNo1() {
		return this.mvmtRefNo1;
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
	 * @return ackCd
	 */
	public String getAckCd() {
		return this.ackCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return msgFuncId
	 */
	public String getMsgFuncId() {
		return this.msgFuncId;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return errYn
	 */
	public String getErrYn() {
		return this.errYn;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return trsmVal
	 */
	public String getTrsmVal() {
		return this.trsmVal;
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
	 * @return mvmtRefNo
	 */
	public String getMvmtRefNo() {
		return this.mvmtRefNo;
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
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
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
	 * @return ktsSendDt
	 */
	public String getKtsSendDt() {
		return this.ktsSendDt;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return ataYn
	 */
	public String getAtaYn() {
		return this.ataYn;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return prevDocNos
	 */
	public String getPrevDocNos() {
		return this.prevDocNos;
	}
	
	/**
	 * Column Info
	 * @return ktsSendDt2
	 */
	public String getKtsSendDt2() {
		return this.ktsSendDt2;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return ktsSendDt1
	 */
	public String getKtsSendDt1() {
		return this.ktsSendDt1;
	}
	
	/**
	 * Column Info
	 * @return errYns
	 */
	public String getErrYns() {
		return this.errYns;
	}
	
	/**
	 * Column Info
	 * @return trspDocNo
	 */
	public String getTrspDocNo() {
		return this.trspDocNo;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}
	
	/**
	 * Column Info
	 * @return prevDocNo
	 */
	public String getPrevDocNo() {
		return this.prevDocNo;
	}
	
	/**
	 * Column Info
	 * @return declLocCd
	 */
	public String getDeclLocCd() {
		return this.declLocCd;
	}
	
	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
	}
	
	/**
	 * Column Info
	 * @return euStfFlg
	 */
	public String getEuStfFlg() {
		return this.euStfFlg;
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
	 * @param drYn
	 */
	public void setDrYn(String drYn) {
		this.drYn = drYn;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param arnYn
	 */
	public void setArnYn(String arnYn) {
		this.arnYn = arnYn;
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
	 * @param hisAckCd
	 */
	public void setHisAckCd(String hisAckCd) {
		this.hisAckCd = hisAckCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param msgFuncHold
	 */
	public void setMsgFuncHold(String msgFuncHold) {
		this.msgFuncHold = msgFuncHold;
	}
	
	/**
	 * Column Info
	 * @param searchPrevDocNo
	 */
	public void setSearchPrevDocNo(String searchPrevDocNo) {
		this.searchPrevDocNo = searchPrevDocNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclDt
	 */
	public void setCstmsDeclDt(String cstmsDeclDt) {
		this.cstmsDeclDt = cstmsDeclDt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param blMrnYn
	 */
	public void setBlMrnYn(String blMrnYn) {
		this.blMrnYn = blMrnYn;
	}
	
	/**
	 * Column Info
	 * @param ensEdiSvcFlg
	 */
	public void setEnsEdiSvcFlg(String ensEdiSvcFlg) {
		this.ensEdiSvcFlg = ensEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param localTime
	 */
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
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
	 * @param exsEdiSvcFlg
	 */
	public void setExsEdiSvcFlg(String exsEdiSvcFlg) {
		this.exsEdiSvcFlg = exsEdiSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param trsmBlckFlg
	 */
	public void setTrsmBlckFlg(String trsmBlckFlg) {
		this.trsmBlckFlg = trsmBlckFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvMvmtRefNo
	 */
	public void setRcvMvmtRefNo(String rcvMvmtRefNo) {
		this.rcvMvmtRefNo = rcvMvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtRefNo1
	 */
	public void setMvmtRefNo1(String mvmtRefNo1) {
		this.mvmtRefNo1 = mvmtRefNo1;
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
	 * @param ackCd
	 */
	public void setAckCd(String ackCd) {
		this.ackCd = ackCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param msgFuncId
	 */
	public void setMsgFuncId(String msgFuncId) {
		this.msgFuncId = msgFuncId;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param errYn
	 */
	public void setErrYn(String errYn) {
		this.errYn = errYn;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param trsmVal
	 */
	public void setTrsmVal(String trsmVal) {
		this.trsmVal = trsmVal;
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
	 * @param mvmtRefNo
	 */
	public void setMvmtRefNo(String mvmtRefNo) {
		this.mvmtRefNo = mvmtRefNo;
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
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
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
	 * @param ktsSendDt
	 */
	public void setKtsSendDt(String ktsSendDt) {
		this.ktsSendDt = ktsSendDt;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param ataYn
	 */
	public void setAtaYn(String ataYn) {
		this.ataYn = ataYn;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param prevDocNos
	 */
	public void setPrevDocNos(String prevDocNos) {
		this.prevDocNos = prevDocNos;
	}
	
	/**
	 * Column Info
	 * @param ktsSendDt2
	 */
	public void setKtsSendDt2(String ktsSendDt2) {
		this.ktsSendDt2 = ktsSendDt2;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param ktsSendDt1
	 */
	public void setKtsSendDt1(String ktsSendDt1) {
		this.ktsSendDt1 = ktsSendDt1;
	}
	
	/**
	 * Column Info
	 * @param errYns
	 */
	public void setErrYns(String errYns) {
		this.errYns = errYns;
	}
	
	/**
	 * Column Info
	 * @param trspDocNo
	 */
	public void setTrspDocNo(String trspDocNo) {
		this.trspDocNo = trspDocNo;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
	}
	
	/**
	 * Column Info
	 * @param prevDocNo
	 */
	public void setPrevDocNo(String prevDocNo) {
		this.prevDocNo = prevDocNo;
	}
	
	/**
	 * Column Info
	 * @param declLocCd
	 */
	public void setDeclLocCd(String declLocCd) {
		this.declLocCd = declLocCd;
	}
	
	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	
	/**
	 * Column Info
	 * @param euStfFlg
	 */
	public void setEuStfFlg(String euStfFlg) {
		this.euStfFlg = euStfFlg;
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
		setDrYn(JSPUtil.getParameter(request, prefix + "dr_yn", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setArnYn(JSPUtil.getParameter(request, prefix + "arn_yn", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setHisAckCd(JSPUtil.getParameter(request, prefix + "his_ack_cd", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setMsgFuncHold(JSPUtil.getParameter(request, prefix + "msg_func_hold", ""));
		setSearchPrevDocNo(JSPUtil.getParameter(request, prefix + "search_prev_doc_no", ""));
		setCstmsDeclDt(JSPUtil.getParameter(request, prefix + "cstms_decl_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setBlMrnYn(JSPUtil.getParameter(request, prefix + "bl_mrn_yn", ""));
		setEnsEdiSvcFlg(JSPUtil.getParameter(request, prefix + "ens_edi_svc_flg", ""));
		setLocalTime(JSPUtil.getParameter(request, prefix + "local_time", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setExsEdiSvcFlg(JSPUtil.getParameter(request, prefix + "exs_edi_svc_flg", ""));
		setTrsmBlckFlg(JSPUtil.getParameter(request, prefix + "trsm_blck_flg", ""));
		setRcvMvmtRefNo(JSPUtil.getParameter(request, prefix + "rcv_mvmt_ref_no", ""));
		setMvmtRefNo1(JSPUtil.getParameter(request, prefix + "mvmt_ref_no1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAckCd(JSPUtil.getParameter(request, prefix + "ack_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setMsgFuncId(JSPUtil.getParameter(request, prefix + "msg_func_id", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setErrYn(JSPUtil.getParameter(request, prefix + "err_yn", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setTrsmVal(JSPUtil.getParameter(request, prefix + "trsm_val", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMvmtRefNo(JSPUtil.getParameter(request, prefix + "mvmt_ref_no", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setKtsSendDt(JSPUtil.getParameter(request, prefix + "kts_send_dt", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setAtaYn(JSPUtil.getParameter(request, prefix + "ata_yn", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setPrevDocNos(JSPUtil.getParameter(request, prefix + "prev_doc_nos", ""));
		setKtsSendDt2(JSPUtil.getParameter(request, prefix + "kts_send_dt2", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setKtsSendDt1(JSPUtil.getParameter(request, prefix + "kts_send_dt1", ""));
		setErrYns(JSPUtil.getParameter(request, prefix + "err_yns", ""));
		setTrspDocNo(JSPUtil.getParameter(request, prefix + "trsp_doc_no", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
		setPrevDocNo(JSPUtil.getParameter(request, prefix + "prev_doc_no", ""));
		setDeclLocCd(JSPUtil.getParameter(request, prefix + "decl_loc_cd", ""));
		setTypeCd(JSPUtil.getParameter(request, prefix + "type_cd", ""));
		setEuStfFlg(JSPUtil.getParameter(request, prefix + "eu_stf_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlGeneralInfoVO[]
	 */
	public Eur24BlGeneralInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlGeneralInfoVO[]
	 */
	public Eur24BlGeneralInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlGeneralInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] drYn = (JSPUtil.getParameter(request, prefix	+ "dr_yn", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] arnYn = (JSPUtil.getParameter(request, prefix	+ "arn_yn", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] hisAckCd = (JSPUtil.getParameter(request, prefix	+ "his_ack_cd", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] msgFuncHold = (JSPUtil.getParameter(request, prefix	+ "msg_func_hold", length));
			String[] searchPrevDocNo = (JSPUtil.getParameter(request, prefix	+ "search_prev_doc_no", length));
			String[] cstmsDeclDt = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] blMrnYn = (JSPUtil.getParameter(request, prefix	+ "bl_mrn_yn", length));
			String[] ensEdiSvcFlg = (JSPUtil.getParameter(request, prefix	+ "ens_edi_svc_flg", length));
			String[] localTime = (JSPUtil.getParameter(request, prefix	+ "local_time", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] exsEdiSvcFlg = (JSPUtil.getParameter(request, prefix	+ "exs_edi_svc_flg", length));
			String[] trsmBlckFlg = (JSPUtil.getParameter(request, prefix	+ "trsm_blck_flg", length));
			String[] rcvMvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "rcv_mvmt_ref_no", length));
			String[] mvmtRefNo1 = (JSPUtil.getParameter(request, prefix	+ "mvmt_ref_no1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ackCd = (JSPUtil.getParameter(request, prefix	+ "ack_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] msgFuncId = (JSPUtil.getParameter(request, prefix	+ "msg_func_id", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] errYn = (JSPUtil.getParameter(request, prefix	+ "err_yn", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] trsmVal = (JSPUtil.getParameter(request, prefix	+ "trsm_val", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] mvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "mvmt_ref_no", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] ktsSendDt = (JSPUtil.getParameter(request, prefix	+ "kts_send_dt", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] ataYn = (JSPUtil.getParameter(request, prefix	+ "ata_yn", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] prevDocNos = (JSPUtil.getParameter(request, prefix	+ "prev_doc_nos", length));
			String[] ktsSendDt2 = (JSPUtil.getParameter(request, prefix	+ "kts_send_dt2", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ktsSendDt1 = (JSPUtil.getParameter(request, prefix	+ "kts_send_dt1", length));
			String[] errYns = (JSPUtil.getParameter(request, prefix	+ "err_yns", length));
			String[] trspDocNo = (JSPUtil.getParameter(request, prefix	+ "trsp_doc_no", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			String[] prevDocNo = (JSPUtil.getParameter(request, prefix	+ "prev_doc_no", length));
			String[] declLocCd = (JSPUtil.getParameter(request, prefix	+ "decl_loc_cd", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			String[] euStfFlg = (JSPUtil.getParameter(request, prefix	+ "eu_stf_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlGeneralInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (drYn[i] != null)
					model.setDrYn(drYn[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (arnYn[i] != null)
					model.setArnYn(arnYn[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (hisAckCd[i] != null)
					model.setHisAckCd(hisAckCd[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (msgFuncHold[i] != null)
					model.setMsgFuncHold(msgFuncHold[i]);
				if (searchPrevDocNo[i] != null)
					model.setSearchPrevDocNo(searchPrevDocNo[i]);
				if (cstmsDeclDt[i] != null)
					model.setCstmsDeclDt(cstmsDeclDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (blMrnYn[i] != null)
					model.setBlMrnYn(blMrnYn[i]);
				if (ensEdiSvcFlg[i] != null)
					model.setEnsEdiSvcFlg(ensEdiSvcFlg[i]);
				if (localTime[i] != null)
					model.setLocalTime(localTime[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (exsEdiSvcFlg[i] != null)
					model.setExsEdiSvcFlg(exsEdiSvcFlg[i]);
				if (trsmBlckFlg[i] != null)
					model.setTrsmBlckFlg(trsmBlckFlg[i]);
				if (rcvMvmtRefNo[i] != null)
					model.setRcvMvmtRefNo(rcvMvmtRefNo[i]);
				if (mvmtRefNo1[i] != null)
					model.setMvmtRefNo1(mvmtRefNo1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ackCd[i] != null)
					model.setAckCd(ackCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (msgFuncId[i] != null)
					model.setMsgFuncId(msgFuncId[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (errYn[i] != null)
					model.setErrYn(errYn[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (trsmVal[i] != null)
					model.setTrsmVal(trsmVal[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (mvmtRefNo[i] != null)
					model.setMvmtRefNo(mvmtRefNo[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (ktsSendDt[i] != null)
					model.setKtsSendDt(ktsSendDt[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (ataYn[i] != null)
					model.setAtaYn(ataYn[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (prevDocNos[i] != null)
					model.setPrevDocNos(prevDocNos[i]);
				if (ktsSendDt2[i] != null)
					model.setKtsSendDt2(ktsSendDt2[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ktsSendDt1[i] != null)
					model.setKtsSendDt1(ktsSendDt1[i]);
				if (errYns[i] != null)
					model.setErrYns(errYns[i]);
				if (trspDocNo[i] != null)
					model.setTrspDocNo(trspDocNo[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				if (prevDocNo[i] != null)
					model.setPrevDocNo(prevDocNo[i]);
				if (declLocCd[i] != null)
					model.setDeclLocCd(declLocCd[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				if (euStfFlg[i] != null)
					model.setEuStfFlg(euStfFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlGeneralInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlGeneralInfoVO[]
	 */
	public Eur24BlGeneralInfoVO[] getEur24BlGeneralInfoVOs(){
		Eur24BlGeneralInfoVO[] vos = (Eur24BlGeneralInfoVO[])models.toArray(new Eur24BlGeneralInfoVO[models.size()]);
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
		this.drYn = this.drYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arnYn = this.arnYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisAckCd = this.hisAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncHold = this.msgFuncHold .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchPrevDocNo = this.searchPrevDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclDt = this.cstmsDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMrnYn = this.blMrnYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ensEdiSvcFlg = this.ensEdiSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTime = this.localTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exsEdiSvcFlg = this.exsEdiSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmBlckFlg = this.trsmBlckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvMvmtRefNo = this.rcvMvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRefNo1 = this.mvmtRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackCd = this.ackCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncId = this.msgFuncId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errYn = this.errYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmVal = this.trsmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRefNo = this.mvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktsSendDt = this.ktsSendDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataYn = this.ataYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDocNos = this.prevDocNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktsSendDt2 = this.ktsSendDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktsSendDt1 = this.ktsSendDt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errYns = this.errYns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo = this.trspDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDocNo = this.prevDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declLocCd = this.declLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euStfFlg = this.euStfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
