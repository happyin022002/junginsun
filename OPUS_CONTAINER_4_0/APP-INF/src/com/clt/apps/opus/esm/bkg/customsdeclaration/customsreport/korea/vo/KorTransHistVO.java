/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorTransHistVO.java
*@FileTitle : KorTransHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.09 손윤석
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReportHistCondVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorTransHistVO extends ReportHistCondVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorTransHistVO> models = new ArrayList<KorTransHistVO>();

	/* Column Info */
	private String aOfcCd = null;
	/* Column Info */
	private String fBlNo = null;
	/* Column Info */
	private String aMfRcvrUsrId = null;
	/* Column Info */
	private String fTrsmUsrId = null;
	/* Column Info */
	private String aCorrCd1 = null;
	/* Column Info */
	private String fSndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inBlNo = null;
	/* Column Info */
	private String aPodCd = null;
	/* Column Info */
	private String fBlKnt = null;
	/* Column Info */
	private String aVvdCd = null;
	/* Column Info */
	private String inOfcCd = null;
	/* Column Info */
	private String fVslCd = null;
	/* Column Info */
	private String fMfRcvrUsrId = null;
	/* Column Info */
	private String fCreUsrId = null;
	/* Column Info */
	private String inPodCd = null;
	/* Column Info */
	private String fUpdDt = null;
	/* Column Info */
	private String inUsrId = null;
	/* Column Info */
	private String fKrCstmsDeclCd = null;
	/* Column Info */
	private String inMsgType = null;
	/* Column Info */
	private String aESvcSendDate = null;
	/* Column Info */
	private String fSkdVoyNo = null;
	/* Column Info */
	private String inKsType = null;
	/* Column Info */
	private String aCTp = null;
	/* Column Info */
	private String aBlNo = null;
	/* Column Info */
	private String aPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fCreDt = null;
	/* Column Info */
	private String fCorrCd1 = null;
	/* Column Info */
	private String aFld40ft = null;
	/* Column Info */
	private String fPodCd = null;
	/* Column Info */
	private String aSndDtDd = null;
	/* Column Info */
	private String aTrsmUsrId = null;
	/* Column Info */
	private String aFld20ft = null;
	/* Column Info */
	private String pSearchOption = null;
	/* Column Info */
	private String aReceiver = null;
	/* Column Info */
	private String inSndDtE = null;
	/* Column Info */
	private String fSkdDirCd = null;
	/* Column Info */
	private String inSndDtS = null;
	/* Column Info */
	private String fMsgLogTpId = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String inSubNo = null;
	/* Column Info */
	private String aKsType = null;
	/* Column Info */
	private String fOfcCd = null;
	/* Column Info */
	private String aBlKnt = null;
	/* Column Info */
	private String aMsgLogTpId = null;
	/* Column Info */
	private String fUpdUsrId = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String fPolCd = null;
	/* Column Info */
	private String aSubmitNo = null;
	/* Column Info */
	private String aSndDtTt = null;
	/* Column Info */
	private String ifSended = null;
	/* Column Info */
	private String mfSndSeq = null;
	/* Column Info */
	private String trsmCxlTpCd = null;
	/* Column Info */
	private String trsmCxlRsnCd = null;
	/* Column Info */
	private String trsmCxlDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorTransHistVO() {}

	public KorTransHistVO(String ibflag, String pagerows, String aMsgLogTpId, String aMfRcvrUsrId, String aReceiver, String aCorrCd1, String aSndDtDd, String aSndDtTt, String aVvdCd, String aPolCd, String aPodCd, String aOfcCd, String aBlNo, String aSubmitNo, String aBlKnt, String aFld40ft, String aFld20ft, String aTrsmUsrId, String aKsType, String aCTp, String aESvcSendDate, String inMsgType, String inVslCd, String inBlNo, String inSubNo, String inKsType, String inPolCd, String inPodCd, String inOfcCd, String inUsrId, String inSndDtS, String inSndDtE, String fMsgLogTpId, String fSndDt, String fOfcCd, String fTrsmUsrId, String fVslCd, String fSkdVoyNo, String fSkdDirCd, String fPolCd, String fPodCd, String fKrCstmsDeclCd, String fBlKnt, String fBlNo, String fCorrCd1, String fMfRcvrUsrId, String fCreUsrId, String fCreDt, String fUpdUsrId, String fUpdDt, String pSearchOption, String ifSended, String mfSndSeq, String trsmCxlTpCd, String trsmCxlRsnCd, String trsmCxlDesc) {
		this.aOfcCd = aOfcCd;
		this.fBlNo = fBlNo;
		this.aMfRcvrUsrId = aMfRcvrUsrId;
		this.fTrsmUsrId = fTrsmUsrId;
		this.aCorrCd1 = aCorrCd1;
		this.fSndDt = fSndDt;
		this.pagerows = pagerows;
		this.inBlNo = inBlNo;
		this.aPodCd = aPodCd;
		this.fBlKnt = fBlKnt;
		this.aVvdCd = aVvdCd;
		this.inOfcCd = inOfcCd;
		this.fVslCd = fVslCd;
		this.fMfRcvrUsrId = fMfRcvrUsrId;
		this.fCreUsrId = fCreUsrId;
		this.inPodCd = inPodCd;
		this.fUpdDt = fUpdDt;
		this.inUsrId = inUsrId;
		this.fKrCstmsDeclCd = fKrCstmsDeclCd;
		this.inMsgType = inMsgType;
		this.aESvcSendDate = aESvcSendDate;
		this.fSkdVoyNo = fSkdVoyNo;
		this.inKsType = inKsType;
		this.aCTp = aCTp;
		this.aBlNo = aBlNo;
		this.aPolCd = aPolCd;
		this.ibflag = ibflag;
		this.fCreDt = fCreDt;
		this.fCorrCd1 = fCorrCd1;
		this.aFld40ft = aFld40ft;
		this.fPodCd = fPodCd;
		this.aSndDtDd = aSndDtDd;
		this.aTrsmUsrId = aTrsmUsrId;
		this.aFld20ft = aFld20ft;
		this.pSearchOption = pSearchOption;
		this.aReceiver = aReceiver;
		this.inSndDtE = inSndDtE;
		this.fSkdDirCd = fSkdDirCd;
		this.inSndDtS = inSndDtS;
		this.fMsgLogTpId = fMsgLogTpId;
		this.inVslCd = inVslCd;
		this.inSubNo = inSubNo;
		this.aKsType = aKsType;
		this.fOfcCd = fOfcCd;
		this.aBlKnt = aBlKnt;
		this.aMsgLogTpId = aMsgLogTpId;
		this.fUpdUsrId = fUpdUsrId;
		this.inPolCd = inPolCd;
		this.fPolCd = fPolCd;
		this.aSubmitNo = aSubmitNo;
		this.aSndDtTt = aSndDtTt;
		this.ifSended = ifSended;
		this.mfSndSeq = mfSndSeq;
		this.trsmCxlTpCd = trsmCxlTpCd;
		this.trsmCxlRsnCd = trsmCxlRsnCd;
		this.trsmCxlDesc = trsmCxlDesc;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("a_ofc_cd", getAOfcCd());
		this.hashColumns.put("f_bl_no", getFBlNo());
		this.hashColumns.put("a_mf_rcvr_usr_id", getAMfRcvrUsrId());
		this.hashColumns.put("f_trsm_usr_id", getFTrsmUsrId());
		this.hashColumns.put("a_corr_cd1", getACorrCd1());
		this.hashColumns.put("f_snd_dt", getFSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_bl_no", getInBlNo());
		this.hashColumns.put("a_pod_cd", getAPodCd());
		this.hashColumns.put("f_bl_knt", getFBlKnt());
		this.hashColumns.put("a_vvd_cd", getAVvdCd());
		this.hashColumns.put("in_ofc_cd", getInOfcCd());
		this.hashColumns.put("f_vsl_cd", getFVslCd());
		this.hashColumns.put("f_mf_rcvr_usr_id", getFMfRcvrUsrId());
		this.hashColumns.put("f_cre_usr_id", getFCreUsrId());
		this.hashColumns.put("in_pod_cd", getInPodCd());
		this.hashColumns.put("f_upd_dt", getFUpdDt());
		this.hashColumns.put("in_usr_id", getInUsrId());
		this.hashColumns.put("f_kr_cstms_decl_cd", getFKrCstmsDeclCd());
		this.hashColumns.put("in_msg_type", getInMsgType());
		this.hashColumns.put("a_e_svc_send_date", getAESvcSendDate());
		this.hashColumns.put("f_skd_voy_no", getFSkdVoyNo());
		this.hashColumns.put("in_ks_type", getInKsType());
		this.hashColumns.put("a_c_tp", getACTp());
		this.hashColumns.put("a_bl_no", getABlNo());
		this.hashColumns.put("a_pol_cd", getAPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("f_cre_dt", getFCreDt());
		this.hashColumns.put("f_corr_cd1", getFCorrCd1());
		this.hashColumns.put("a_fld_40ft", getAFld40ft());
		this.hashColumns.put("f_pod_cd", getFPodCd());
		this.hashColumns.put("a_snd_dt_dd", getASndDtDd());
		this.hashColumns.put("a_trsm_usr_id", getATrsmUsrId());
		this.hashColumns.put("a_fld_20ft", getAFld20ft());
		this.hashColumns.put("p_search_option", getPSearchOption());
		this.hashColumns.put("a_receiver", getAReceiver());
		this.hashColumns.put("in_snd_dt_e", getInSndDtE());
		this.hashColumns.put("f_skd_dir_cd", getFSkdDirCd());
		this.hashColumns.put("in_snd_dt_s", getInSndDtS());
		this.hashColumns.put("f_msg_log_tp_id", getFMsgLogTpId());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("in_sub_no", getInSubNo());
		this.hashColumns.put("a_ks_type", getAKsType());
		this.hashColumns.put("f_ofc_cd", getFOfcCd());
		this.hashColumns.put("a_bl_knt", getABlKnt());
		this.hashColumns.put("a_msg_log_tp_id", getAMsgLogTpId());
		this.hashColumns.put("f_upd_usr_id", getFUpdUsrId());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("f_pol_cd", getFPolCd());
		this.hashColumns.put("a_submit_no", getASubmitNo());
		this.hashColumns.put("a_snd_dt_tt", getASndDtTt());
		this.hashColumns.put("if_sended", getIfSended());
		this.hashColumns.put("mf_snd_seq", getMfSndSeq());
		this.hashColumns.put("trsm_cxl_tp_cd", getTrsmCxlTpCd());
		this.hashColumns.put("trsm_cxl_rsn_cd", getTrsmCxlRsnCd());
		this.hashColumns.put("trsm_cxl_desc", getTrsmCxlDesc());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("a_ofc_cd", "aOfcCd");
		this.hashFields.put("f_bl_no", "fBlNo");
		this.hashFields.put("a_mf_rcvr_usr_id", "aMfRcvrUsrId");
		this.hashFields.put("f_trsm_usr_id", "fTrsmUsrId");
		this.hashFields.put("a_corr_cd1", "aCorrCd1");
		this.hashFields.put("f_snd_dt", "fSndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_bl_no", "inBlNo");
		this.hashFields.put("a_pod_cd", "aPodCd");
		this.hashFields.put("f_bl_knt", "fBlKnt");
		this.hashFields.put("a_vvd_cd", "aVvdCd");
		this.hashFields.put("in_ofc_cd", "inOfcCd");
		this.hashFields.put("f_vsl_cd", "fVslCd");
		this.hashFields.put("f_mf_rcvr_usr_id", "fMfRcvrUsrId");
		this.hashFields.put("f_cre_usr_id", "fCreUsrId");
		this.hashFields.put("in_pod_cd", "inPodCd");
		this.hashFields.put("f_upd_dt", "fUpdDt");
		this.hashFields.put("in_usr_id", "inUsrId");
		this.hashFields.put("f_kr_cstms_decl_cd", "fKrCstmsDeclCd");
		this.hashFields.put("in_msg_type", "inMsgType");
		this.hashFields.put("a_e_svc_send_date", "aESvcSendDate");
		this.hashFields.put("f_skd_voy_no", "fSkdVoyNo");
		this.hashFields.put("in_ks_type", "inKsType");
		this.hashFields.put("a_c_tp", "aCTp");
		this.hashFields.put("a_bl_no", "aBlNo");
		this.hashFields.put("a_pol_cd", "aPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("f_cre_dt", "fCreDt");
		this.hashFields.put("f_corr_cd1", "fCorrCd1");
		this.hashFields.put("a_fld_40ft", "aFld40ft");
		this.hashFields.put("f_pod_cd", "fPodCd");
		this.hashFields.put("a_snd_dt_dd", "aSndDtDd");
		this.hashFields.put("a_trsm_usr_id", "aTrsmUsrId");
		this.hashFields.put("a_fld_20ft", "aFld20ft");
		this.hashFields.put("p_search_option", "pSearchOption");
		this.hashFields.put("a_receiver", "aReceiver");
		this.hashFields.put("in_snd_dt_e", "inSndDtE");
		this.hashFields.put("f_skd_dir_cd", "fSkdDirCd");
		this.hashFields.put("in_snd_dt_s", "inSndDtS");
		this.hashFields.put("f_msg_log_tp_id", "fMsgLogTpId");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("in_sub_no", "inSubNo");
		this.hashFields.put("a_ks_type", "aKsType");
		this.hashFields.put("f_ofc_cd", "fOfcCd");
		this.hashFields.put("a_bl_knt", "aBlKnt");
		this.hashFields.put("a_msg_log_tp_id", "aMsgLogTpId");
		this.hashFields.put("f_upd_usr_id", "fUpdUsrId");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("f_pol_cd", "fPolCd");
		this.hashFields.put("a_submit_no", "aSubmitNo");
		this.hashFields.put("a_snd_dt_tt", "aSndDtTt");
		this.hashFields.put("if_sended", "ifSended");
		this.hashFields.put("mf_snd_seq", "mfSndSeq");
		this.hashFields.put("trsm_cxl_tp_cd", "trsmCxlTpCd");
		this.hashFields.put("trsm_cxl_rsn_cd", "trsmCxlRsnCd");
		this.hashFields.put("trsm_cxl_desc", "trsmCxlDesc");
		return this.hashFields;
	}

	/**
	 * @return the mfSndSeq
	 */
	public String getMfSndSeq() {
		return mfSndSeq;
	}

	/**
	 * @param mfSndSeq the mfSndSeq to set
	 */
	public void setMfSndSeq(String mfSndSeq) {
		this.mfSndSeq = mfSndSeq;
	}

	/**
	 * @return the ifSended
	 */
	public String getIfSended() {
		return ifSended;
	}

	/**
	 * @param ifSended the ifSended to set
	 */
	public void setIfSended(String ifSended) {
		this.ifSended = ifSended;
	}

	/**
	 * Column Info
	 * @return aOfcCd
	 */
	public String getAOfcCd() {
		return this.aOfcCd;
	}

	/**
	 * Column Info
	 * @return fBlNo
	 */
	public String getFBlNo() {
		return this.fBlNo;
	}

	/**
	 * Column Info
	 * @return aMfRcvrUsrId
	 */
	public String getAMfRcvrUsrId() {
		return this.aMfRcvrUsrId;
	}

	/**
	 * Column Info
	 * @return fTrsmUsrId
	 */
	public String getFTrsmUsrId() {
		return this.fTrsmUsrId;
	}

	/**
	 * Column Info
	 * @return aCorrCd1
	 */
	public String getACorrCd1() {
		return this.aCorrCd1;
	}

	/**
	 * Column Info
	 * @return fSndDt
	 */
	public String getFSndDt() {
		return this.fSndDt;
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
	 * @return inBlNo
	 */
	public String getInBlNo() {
		return this.inBlNo;
	}

	/**
	 * Column Info
	 * @return aPodCd
	 */
	public String getAPodCd() {
		return this.aPodCd;
	}

	/**
	 * Column Info
	 * @return fBlKnt
	 */
	public String getFBlKnt() {
		return this.fBlKnt;
	}

	/**
	 * Column Info
	 * @return aVvdCd
	 */
	public String getAVvdCd() {
		return this.aVvdCd;
	}

	/**
	 * Column Info
	 * @return inOfcCd
	 */
	public String getInOfcCd() {
		return this.inOfcCd;
	}

	/**
	 * Column Info
	 * @return fVslCd
	 */
	public String getFVslCd() {
		return this.fVslCd;
	}

	/**
	 * Column Info
	 * @return fMfRcvrUsrId
	 */
	public String getFMfRcvrUsrId() {
		return this.fMfRcvrUsrId;
	}

	/**
	 * Column Info
	 * @return fCreUsrId
	 */
	public String getFCreUsrId() {
		return this.fCreUsrId;
	}

	/**
	 * Column Info
	 * @return inPodCd
	 */
	public String getInPodCd() {
		return this.inPodCd;
	}

	/**
	 * Column Info
	 * @return fUpdDt
	 */
	public String getFUpdDt() {
		return this.fUpdDt;
	}

	/**
	 * Column Info
	 * @return inUsrId
	 */
	public String getInUsrId() {
		return this.inUsrId;
	}

	/**
	 * Column Info
	 * @return fKrCstmsDeclCd
	 */
	public String getFKrCstmsDeclCd() {
		return this.fKrCstmsDeclCd;
	}

	/**
	 * Column Info
	 * @return inMsgType
	 */
	public String getInMsgType() {
		return this.inMsgType;
	}

	/**
	 * Column Info
	 * @return aESvcSendDate
	 */
	public String getAESvcSendDate() {
		return this.aESvcSendDate;
	}

	/**
	 * Column Info
	 * @return fSkdVoyNo
	 */
	public String getFSkdVoyNo() {
		return this.fSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return inKsType
	 */
	public String getInKsType() {
		return this.inKsType;
	}

	/**
	 * Column Info
	 * @return aCTp
	 */
	public String getACTp() {
		return this.aCTp;
	}

	/**
	 * Column Info
	 * @return aBlNo
	 */
	public String getABlNo() {
		return this.aBlNo;
	}

	/**
	 * Column Info
	 * @return aPolCd
	 */
	public String getAPolCd() {
		return this.aPolCd;
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
	 * @return fCreDt
	 */
	public String getFCreDt() {
		return this.fCreDt;
	}

	/**
	 * Column Info
	 * @return fCorrCd1
	 */
	public String getFCorrCd1() {
		return this.fCorrCd1;
	}

	/**
	 * Column Info
	 * @return aFld40ft
	 */
	public String getAFld40ft() {
		return this.aFld40ft;
	}

	/**
	 * Column Info
	 * @return fPodCd
	 */
	public String getFPodCd() {
		return this.fPodCd;
	}

	/**
	 * Column Info
	 * @return aSndDtDd
	 */
	public String getASndDtDd() {
		return this.aSndDtDd;
	}

	/**
	 * Column Info
	 * @return aTrsmUsrId
	 */
	public String getATrsmUsrId() {
		return this.aTrsmUsrId;
	}

	/**
	 * Column Info
	 * @return aFld20ft
	 */
	public String getAFld20ft() {
		return this.aFld20ft;
	}

	/**
	 * Column Info
	 * @return pSearchOption
	 */
	public String getPSearchOption() {
		return this.pSearchOption;
	}

	/**
	 * Column Info
	 * @return aReceiver
	 */
	public String getAReceiver() {
		return this.aReceiver;
	}

	/**
	 * Column Info
	 * @return inSndDtE
	 */
	public String getInSndDtE() {
		return this.inSndDtE;
	}

	/**
	 * Column Info
	 * @return fSkdDirCd
	 */
	public String getFSkdDirCd() {
		return this.fSkdDirCd;
	}

	/**
	 * Column Info
	 * @return inSndDtS
	 */
	public String getInSndDtS() {
		return this.inSndDtS;
	}

	/**
	 * Column Info
	 * @return fMsgLogTpId
	 */
	public String getFMsgLogTpId() {
		return this.fMsgLogTpId;
	}

	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}

	/**
	 * Column Info
	 * @return inSubNo
	 */
	public String getInSubNo() {
		return this.inSubNo;
	}

	/**
	 * Column Info
	 * @return aKsType
	 */
	public String getAKsType() {
		return this.aKsType;
	}

	/**
	 * Column Info
	 * @return fOfcCd
	 */
	public String getFOfcCd() {
		return this.fOfcCd;
	}

	/**
	 * Column Info
	 * @return aBlKnt
	 */
	public String getABlKnt() {
		return this.aBlKnt;
	}

	/**
	 * Column Info
	 * @return aMsgLogTpId
	 */
	public String getAMsgLogTpId() {
		return this.aMsgLogTpId;
	}

	/**
	 * Column Info
	 * @return fUpdUsrId
	 */
	public String getFUpdUsrId() {
		return this.fUpdUsrId;
	}

	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return fPolCd
	 */
	public String getFPolCd() {
		return this.fPolCd;
	}

	/**
	 * Column Info
	 * @return aSubmitNo
	 */
	public String getASubmitNo() {
		return this.aSubmitNo;
	}

	/**
	 * Column Info
	 * @return aSndDtTt
	 */
	public String getASndDtTt() {
		return this.aSndDtTt;
	}

	/**
	 * Column Info
	 * @return trsmCxlTpCd
	 */
	public String getTrsmCxlTpCd() {
		return this.trsmCxlTpCd;
	}

	/**
	 * Column Info
	 * @return trsmCxlRsnCd
	 */
	public String getTrsmCxlRsnCd() {
		return this.trsmCxlRsnCd;
	}

	/**
	 * Column Info
	 * @return trsmCxlDesc
	 */
	public String getTrsmCxlDesc() {
		return this.trsmCxlDesc;
	}


	/**
	 * Column Info
	 * @param aOfcCd
	 */
	public void setAOfcCd(String aOfcCd) {
		this.aOfcCd = aOfcCd;
	}

	/**
	 * Column Info
	 * @param fBlNo
	 */
	public void setFBlNo(String fBlNo) {
		this.fBlNo = fBlNo;
	}

	/**
	 * Column Info
	 * @param aMfRcvrUsrId
	 */
	public void setAMfRcvrUsrId(String aMfRcvrUsrId) {
		this.aMfRcvrUsrId = aMfRcvrUsrId;
	}

	/**
	 * Column Info
	 * @param fTrsmUsrId
	 */
	public void setFTrsmUsrId(String fTrsmUsrId) {
		this.fTrsmUsrId = fTrsmUsrId;
	}

	/**
	 * Column Info
	 * @param aCorrCd1
	 */
	public void setACorrCd1(String aCorrCd1) {
		this.aCorrCd1 = aCorrCd1;
	}

	/**
	 * Column Info
	 * @param fSndDt
	 */
	public void setFSndDt(String fSndDt) {
		this.fSndDt = fSndDt;
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
	 * @param inBlNo
	 */
	public void setInBlNo(String inBlNo) {
		this.inBlNo = inBlNo;
	}

	/**
	 * Column Info
	 * @param aPodCd
	 */
	public void setAPodCd(String aPodCd) {
		this.aPodCd = aPodCd;
	}

	/**
	 * Column Info
	 * @param fBlKnt
	 */
	public void setFBlKnt(String fBlKnt) {
		this.fBlKnt = fBlKnt;
	}

	/**
	 * Column Info
	 * @param aVvdCd
	 */
	public void setAVvdCd(String aVvdCd) {
		this.aVvdCd = aVvdCd;
	}

	/**
	 * Column Info
	 * @param inOfcCd
	 */
	public void setInOfcCd(String inOfcCd) {
		this.inOfcCd = inOfcCd;
	}

	/**
	 * Column Info
	 * @param fVslCd
	 */
	public void setFVslCd(String fVslCd) {
		this.fVslCd = fVslCd;
	}

	/**
	 * Column Info
	 * @param fMfRcvrUsrId
	 */
	public void setFMfRcvrUsrId(String fMfRcvrUsrId) {
		this.fMfRcvrUsrId = fMfRcvrUsrId;
	}

	/**
	 * Column Info
	 * @param fCreUsrId
	 */
	public void setFCreUsrId(String fCreUsrId) {
		this.fCreUsrId = fCreUsrId;
	}

	/**
	 * Column Info
	 * @param inPodCd
	 */
	public void setInPodCd(String inPodCd) {
		this.inPodCd = inPodCd;
	}

	/**
	 * Column Info
	 * @param fUpdDt
	 */
	public void setFUpdDt(String fUpdDt) {
		this.fUpdDt = fUpdDt;
	}

	/**
	 * Column Info
	 * @param inUsrId
	 */
	public void setInUsrId(String inUsrId) {
		this.inUsrId = inUsrId;
	}

	/**
	 * Column Info
	 * @param fKrCstmsDeclCd
	 */
	public void setFKrCstmsDeclCd(String fKrCstmsDeclCd) {
		this.fKrCstmsDeclCd = fKrCstmsDeclCd;
	}

	/**
	 * Column Info
	 * @param inMsgType
	 */
	public void setInMsgType(String inMsgType) {
		this.inMsgType = inMsgType;
	}

	/**
	 * Column Info
	 * @param aESvcSendDate
	 */
	public void setAESvcSendDate(String aESvcSendDate) {
		this.aESvcSendDate = aESvcSendDate;
	}

	/**
	 * Column Info
	 * @param fSkdVoyNo
	 */
	public void setFSkdVoyNo(String fSkdVoyNo) {
		this.fSkdVoyNo = fSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param inKsType
	 */
	public void setInKsType(String inKsType) {
		this.inKsType = inKsType;
	}

	/**
	 * Column Info
	 * @param aCTp
	 */
	public void setACTp(String aCTp) {
		this.aCTp = aCTp;
	}

	/**
	 * Column Info
	 * @param aBlNo
	 */
	public void setABlNo(String aBlNo) {
		this.aBlNo = aBlNo;
	}

	/**
	 * Column Info
	 * @param aPolCd
	 */
	public void setAPolCd(String aPolCd) {
		this.aPolCd = aPolCd;
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
	 * @param fCreDt
	 */
	public void setFCreDt(String fCreDt) {
		this.fCreDt = fCreDt;
	}

	/**
	 * Column Info
	 * @param fCorrCd1
	 */
	public void setFCorrCd1(String fCorrCd1) {
		this.fCorrCd1 = fCorrCd1;
	}

	/**
	 * Column Info
	 * @param aFld40ft
	 */
	public void setAFld40ft(String aFld40ft) {
		this.aFld40ft = aFld40ft;
	}

	/**
	 * Column Info
	 * @param fPodCd
	 */
	public void setFPodCd(String fPodCd) {
		this.fPodCd = fPodCd;
	}

	/**
	 * Column Info
	 * @param aSndDtDd
	 */
	public void setASndDtDd(String aSndDtDd) {
		this.aSndDtDd = aSndDtDd;
	}

	/**
	 * Column Info
	 * @param aTrsmUsrId
	 */
	public void setATrsmUsrId(String aTrsmUsrId) {
		this.aTrsmUsrId = aTrsmUsrId;
	}

	/**
	 * Column Info
	 * @param aFld20ft
	 */
	public void setAFld20ft(String aFld20ft) {
		this.aFld20ft = aFld20ft;
	}

	/**
	 * Column Info
	 * @param pSearchOption
	 */
	public void setPSearchOption(String pSearchOption) {
		this.pSearchOption = pSearchOption;
	}

	/**
	 * Column Info
	 * @param aReceiver
	 */
	public void setAReceiver(String aReceiver) {
		this.aReceiver = aReceiver;
	}

	/**
	 * Column Info
	 * @param inSndDtE
	 */
	public void setInSndDtE(String inSndDtE) {
		this.inSndDtE = inSndDtE;
	}

	/**
	 * Column Info
	 * @param fSkdDirCd
	 */
	public void setFSkdDirCd(String fSkdDirCd) {
		this.fSkdDirCd = fSkdDirCd;
	}

	/**
	 * Column Info
	 * @param inSndDtS
	 */
	public void setInSndDtS(String inSndDtS) {
		this.inSndDtS = inSndDtS;
	}

	/**
	 * Column Info
	 * @param fMsgLogTpId
	 */
	public void setFMsgLogTpId(String fMsgLogTpId) {
		this.fMsgLogTpId = fMsgLogTpId;
	}

	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}

	/**
	 * Column Info
	 * @param inSubNo
	 */
	public void setInSubNo(String inSubNo) {
		this.inSubNo = inSubNo;
	}

	/**
	 * Column Info
	 * @param aKsType
	 */
	public void setAKsType(String aKsType) {
		this.aKsType = aKsType;
	}

	/**
	 * Column Info
	 * @param fOfcCd
	 */
	public void setFOfcCd(String fOfcCd) {
		this.fOfcCd = fOfcCd;
	}

	/**
	 * Column Info
	 * @param aBlKnt
	 */
	public void setABlKnt(String aBlKnt) {
		this.aBlKnt = aBlKnt;
	}

	/**
	 * Column Info
	 * @param aMsgLogTpId
	 */
	public void setAMsgLogTpId(String aMsgLogTpId) {
		this.aMsgLogTpId = aMsgLogTpId;
	}

	/**
	 * Column Info
	 * @param fUpdUsrId
	 */
	public void setFUpdUsrId(String fUpdUsrId) {
		this.fUpdUsrId = fUpdUsrId;
	}

	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param fPolCd
	 */
	public void setFPolCd(String fPolCd) {
		this.fPolCd = fPolCd;
	}

	/**
	 * Column Info
	 * @param aSubmitNo
	 */
	public void setASubmitNo(String aSubmitNo) {
		this.aSubmitNo = aSubmitNo;
	}

	/**
	 * Column Info
	 * @param aSndDtTt
	 */
	public void setASndDtTt(String aSndDtTt) {
		this.aSndDtTt = aSndDtTt;
	}

	/**
	 * Column Info
	 * @param trsmCxlTpCd
	 */
	public void setTrsmCxlTpCd(String trsmCxlTpCd) {
		this.trsmCxlTpCd = trsmCxlTpCd;
	}

	/**
	 * Column Info
	 * @param trsmCxlRsnCd
	 */
	public void setTrsmCxlRsnCd(String trsmCxlRsnCd) {
		this.trsmCxlRsnCd = trsmCxlRsnCd;
	}

	/**
	 * Column Info
	 * @param trsmCxlDesc
	 */
	public void setTrsmCxlDesc(String trsmCxlDesc) {
		this.trsmCxlDesc = trsmCxlDesc;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAOfcCd(JSPUtil.getParameter(request, "a_ofc_cd", ""));
		setFBlNo(JSPUtil.getParameter(request, "f_bl_no", ""));
		setAMfRcvrUsrId(JSPUtil.getParameter(request, "a_mf_rcvr_usr_id", ""));
		setFTrsmUsrId(JSPUtil.getParameter(request, "f_trsm_usr_id", ""));
		setACorrCd1(JSPUtil.getParameter(request, "a_corr_cd1", ""));
		setFSndDt(JSPUtil.getParameter(request, "f_snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInBlNo(JSPUtil.getParameter(request, "in_bl_no", ""));
		setAPodCd(JSPUtil.getParameter(request, "a_pod_cd", ""));
		setFBlKnt(JSPUtil.getParameter(request, "f_bl_knt", ""));
		setAVvdCd(JSPUtil.getParameter(request, "a_vvd_cd", ""));
		setInOfcCd(JSPUtil.getParameter(request, "in_ofc_cd", ""));
		setFVslCd(JSPUtil.getParameter(request, "f_vsl_cd", ""));
		setFMfRcvrUsrId(JSPUtil.getParameter(request, "f_mf_rcvr_usr_id", ""));
		setFCreUsrId(JSPUtil.getParameter(request, "f_cre_usr_id", ""));
		setInPodCd(JSPUtil.getParameter(request, "in_pod_cd", ""));
		setFUpdDt(JSPUtil.getParameter(request, "f_upd_dt", ""));
		setInUsrId(JSPUtil.getParameter(request, "in_usr_id", ""));
		setFKrCstmsDeclCd(JSPUtil.getParameter(request, "f_kr_cstms_decl_cd", ""));
		setInMsgType(JSPUtil.getParameter(request, "in_msg_type", ""));
		setAESvcSendDate(JSPUtil.getParameter(request, "a_e_svc_send_date", ""));
		setFSkdVoyNo(JSPUtil.getParameter(request, "f_skd_voy_no", ""));
		setInKsType(JSPUtil.getParameter(request, "in_ks_type", ""));
		setACTp(JSPUtil.getParameter(request, "a_c_tp", ""));
		setABlNo(JSPUtil.getParameter(request, "a_bl_no", ""));
		setAPolCd(JSPUtil.getParameter(request, "a_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFCreDt(JSPUtil.getParameter(request, "f_cre_dt", ""));
		setFCorrCd1(JSPUtil.getParameter(request, "f_corr_cd1", ""));
		setAFld40ft(JSPUtil.getParameter(request, "a_fld_40ft", ""));
		setFPodCd(JSPUtil.getParameter(request, "f_pod_cd", ""));
		setASndDtDd(JSPUtil.getParameter(request, "a_snd_dt_dd", ""));
		setATrsmUsrId(JSPUtil.getParameter(request, "a_trsm_usr_id", ""));
		setAFld20ft(JSPUtil.getParameter(request, "a_fld_20ft", ""));
		setPSearchOption(JSPUtil.getParameter(request, "p_search_option", ""));
		setAReceiver(JSPUtil.getParameter(request, "a_receiver", ""));
		setInSndDtE(JSPUtil.getParameter(request, "in_snd_dt_e", ""));
		setFSkdDirCd(JSPUtil.getParameter(request, "f_skd_dir_cd", ""));
		setInSndDtS(JSPUtil.getParameter(request, "in_snd_dt_s", ""));
		setFMsgLogTpId(JSPUtil.getParameter(request, "f_msg_log_tp_id", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setInSubNo(JSPUtil.getParameter(request, "in_sub_no", ""));
		setAKsType(JSPUtil.getParameter(request, "a_ks_type", ""));
		setFOfcCd(JSPUtil.getParameter(request, "f_ofc_cd", ""));
		setABlKnt(JSPUtil.getParameter(request, "a_bl_knt", ""));
		setAMsgLogTpId(JSPUtil.getParameter(request, "a_msg_log_tp_id", ""));
		setFUpdUsrId(JSPUtil.getParameter(request, "f_upd_usr_id", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setFPolCd(JSPUtil.getParameter(request, "f_pol_cd", ""));
		setASubmitNo(JSPUtil.getParameter(request, "a_submit_no", ""));
		setASndDtTt(JSPUtil.getParameter(request, "a_snd_dt_tt", ""));
		setIfSended(JSPUtil.getParameter(request, "if_sended", ""));
		setMfSndSeq(JSPUtil.getParameter(request, "mf_snd_seq", ""));
		setTrsmCxlTpCd(JSPUtil.getParameter(request, "trsm_cxl_tp_cd", ""));
		setTrsmCxlRsnCd(JSPUtil.getParameter(request, "trsm_cxl_rsn_cd", ""));
		setTrsmCxlDesc(JSPUtil.getParameter(request, "trsm_cxl_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorTransHistVO[]
	 */
	public KorTransHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorTransHistVO[]
	 */
	public KorTransHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorTransHistVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] aOfcCd = (JSPUtil.getParameter(request, prefix	+ "a_ofc_cd", length));
			String[] fBlNo = (JSPUtil.getParameter(request, prefix	+ "f_bl_no", length));
			String[] aMfRcvrUsrId = (JSPUtil.getParameter(request, prefix	+ "a_mf_rcvr_usr_id", length));
			String[] fTrsmUsrId = (JSPUtil.getParameter(request, prefix	+ "f_trsm_usr_id", length));
			String[] aCorrCd1 = (JSPUtil.getParameter(request, prefix	+ "a_corr_cd1", length));
			String[] fSndDt = (JSPUtil.getParameter(request, prefix	+ "f_snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inBlNo = (JSPUtil.getParameter(request, prefix	+ "in_bl_no", length));
			String[] aPodCd = (JSPUtil.getParameter(request, prefix	+ "a_pod_cd", length));
			String[] fBlKnt = (JSPUtil.getParameter(request, prefix	+ "f_bl_knt", length));
			String[] aVvdCd = (JSPUtil.getParameter(request, prefix	+ "a_vvd_cd", length));
			String[] inOfcCd = (JSPUtil.getParameter(request, prefix	+ "in_ofc_cd", length));
			String[] fVslCd = (JSPUtil.getParameter(request, prefix	+ "f_vsl_cd", length));
			String[] fMfRcvrUsrId = (JSPUtil.getParameter(request, prefix	+ "f_mf_rcvr_usr_id", length));
			String[] fCreUsrId = (JSPUtil.getParameter(request, prefix	+ "f_cre_usr_id", length));
			String[] inPodCd = (JSPUtil.getParameter(request, prefix	+ "in_pod_cd", length));
			String[] fUpdDt = (JSPUtil.getParameter(request, prefix	+ "f_upd_dt", length));
			String[] inUsrId = (JSPUtil.getParameter(request, prefix	+ "in_usr_id", length));
			String[] fKrCstmsDeclCd = (JSPUtil.getParameter(request, prefix	+ "f_kr_cstms_decl_cd", length));
			String[] inMsgType = (JSPUtil.getParameter(request, prefix	+ "in_msg_type", length));
			String[] aESvcSendDate = (JSPUtil.getParameter(request, prefix	+ "a_e_svc_send_date", length));
			String[] fSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "f_skd_voy_no", length));
			String[] inKsType = (JSPUtil.getParameter(request, prefix	+ "in_ks_type", length));
			String[] aCTp = (JSPUtil.getParameter(request, prefix	+ "a_c_tp", length));
			String[] aBlNo = (JSPUtil.getParameter(request, prefix	+ "a_bl_no", length));
			String[] aPolCd = (JSPUtil.getParameter(request, prefix	+ "a_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fCreDt = (JSPUtil.getParameter(request, prefix	+ "f_cre_dt", length));
			String[] fCorrCd1 = (JSPUtil.getParameter(request, prefix	+ "f_corr_cd1", length));
			String[] aFld40ft = (JSPUtil.getParameter(request, prefix	+ "a_fld_40ft", length));
			String[] fPodCd = (JSPUtil.getParameter(request, prefix	+ "f_pod_cd", length));
			String[] aSndDtDd = (JSPUtil.getParameter(request, prefix	+ "a_snd_dt_dd", length));
			String[] aTrsmUsrId = (JSPUtil.getParameter(request, prefix	+ "a_trsm_usr_id", length));
			String[] aFld20ft = (JSPUtil.getParameter(request, prefix	+ "a_fld_20ft", length));
			String[] pSearchOption = (JSPUtil.getParameter(request, prefix	+ "p_search_option", length));
			String[] aReceiver = (JSPUtil.getParameter(request, prefix	+ "a_receiver", length));
			String[] inSndDtE = (JSPUtil.getParameter(request, prefix	+ "in_snd_dt_e", length));
			String[] fSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "f_skd_dir_cd", length));
			String[] inSndDtS = (JSPUtil.getParameter(request, prefix	+ "in_snd_dt_s", length));
			String[] fMsgLogTpId = (JSPUtil.getParameter(request, prefix	+ "f_msg_log_tp_id", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] inSubNo = (JSPUtil.getParameter(request, prefix	+ "in_sub_no", length));
			String[] aKsType = (JSPUtil.getParameter(request, prefix	+ "a_ks_type", length));
			String[] fOfcCd = (JSPUtil.getParameter(request, prefix	+ "f_ofc_cd", length));
			String[] aBlKnt = (JSPUtil.getParameter(request, prefix	+ "a_bl_knt", length));
			String[] aMsgLogTpId = (JSPUtil.getParameter(request, prefix	+ "a_msg_log_tp_id", length));
			String[] fUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "f_upd_usr_id", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] fPolCd = (JSPUtil.getParameter(request, prefix	+ "f_pol_cd", length));
			String[] aSubmitNo = (JSPUtil.getParameter(request, prefix	+ "a_submit_no", length));
			String[] aSndDtTt = (JSPUtil.getParameter(request, prefix	+ "a_snd_dt_tt", length));
			String[] ifSended = (JSPUtil.getParameter(request, prefix	+ "if_sended", length));
			String[] mfSndSeq = (JSPUtil.getParameter(request, prefix	+ "mf_snd_seq", length));
			String[] trsmCxlTpCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_tp_cd", length));
			String[] trsmCxlRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_rsn_cd", length));
			String[] trsmCxlDesc = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_desc", length));

			for (int i = 0; i < length; i++) {
				model = new KorTransHistVO();
				if (aOfcCd[i] != null)
					model.setAOfcCd(aOfcCd[i]);
				if (fBlNo[i] != null)
					model.setFBlNo(fBlNo[i]);
				if (aMfRcvrUsrId[i] != null)
					model.setAMfRcvrUsrId(aMfRcvrUsrId[i]);
				if (fTrsmUsrId[i] != null)
					model.setFTrsmUsrId(fTrsmUsrId[i]);
				if (aCorrCd1[i] != null)
					model.setACorrCd1(aCorrCd1[i]);
				if (fSndDt[i] != null)
					model.setFSndDt(fSndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inBlNo[i] != null)
					model.setInBlNo(inBlNo[i]);
				if (aPodCd[i] != null)
					model.setAPodCd(aPodCd[i]);
				if (fBlKnt[i] != null)
					model.setFBlKnt(fBlKnt[i]);
				if (aVvdCd[i] != null)
					model.setAVvdCd(aVvdCd[i]);
				if (inOfcCd[i] != null)
					model.setInOfcCd(inOfcCd[i]);
				if (fVslCd[i] != null)
					model.setFVslCd(fVslCd[i]);
				if (fMfRcvrUsrId[i] != null)
					model.setFMfRcvrUsrId(fMfRcvrUsrId[i]);
				if (fCreUsrId[i] != null)
					model.setFCreUsrId(fCreUsrId[i]);
				if (inPodCd[i] != null)
					model.setInPodCd(inPodCd[i]);
				if (fUpdDt[i] != null)
					model.setFUpdDt(fUpdDt[i]);
				if (inUsrId[i] != null)
					model.setInUsrId(inUsrId[i]);
				if (fKrCstmsDeclCd[i] != null)
					model.setFKrCstmsDeclCd(fKrCstmsDeclCd[i]);
				if (inMsgType[i] != null)
					model.setInMsgType(inMsgType[i]);
				if (aESvcSendDate[i] != null)
					model.setAESvcSendDate(aESvcSendDate[i]);
				if (fSkdVoyNo[i] != null)
					model.setFSkdVoyNo(fSkdVoyNo[i]);
				if (inKsType[i] != null)
					model.setInKsType(inKsType[i]);
				if (aCTp[i] != null)
					model.setACTp(aCTp[i]);
				if (aBlNo[i] != null)
					model.setABlNo(aBlNo[i]);
				if (aPolCd[i] != null)
					model.setAPolCd(aPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fCreDt[i] != null)
					model.setFCreDt(fCreDt[i]);
				if (fCorrCd1[i] != null)
					model.setFCorrCd1(fCorrCd1[i]);
				if (aFld40ft[i] != null)
					model.setAFld40ft(aFld40ft[i]);
				if (fPodCd[i] != null)
					model.setFPodCd(fPodCd[i]);
				if (aSndDtDd[i] != null)
					model.setASndDtDd(aSndDtDd[i]);
				if (aTrsmUsrId[i] != null)
					model.setATrsmUsrId(aTrsmUsrId[i]);
				if (aFld20ft[i] != null)
					model.setAFld20ft(aFld20ft[i]);
				if (pSearchOption[i] != null)
					model.setPSearchOption(pSearchOption[i]);
				if (aReceiver[i] != null)
					model.setAReceiver(aReceiver[i]);
				if (inSndDtE[i] != null)
					model.setInSndDtE(inSndDtE[i]);
				if (fSkdDirCd[i] != null)
					model.setFSkdDirCd(fSkdDirCd[i]);
				if (inSndDtS[i] != null)
					model.setInSndDtS(inSndDtS[i]);
				if (fMsgLogTpId[i] != null)
					model.setFMsgLogTpId(fMsgLogTpId[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (inSubNo[i] != null)
					model.setInSubNo(inSubNo[i]);
				if (aKsType[i] != null)
					model.setAKsType(aKsType[i]);
				if (fOfcCd[i] != null)
					model.setFOfcCd(fOfcCd[i]);
				if (aBlKnt[i] != null)
					model.setABlKnt(aBlKnt[i]);
				if (aMsgLogTpId[i] != null)
					model.setAMsgLogTpId(aMsgLogTpId[i]);
				if (fUpdUsrId[i] != null)
					model.setFUpdUsrId(fUpdUsrId[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (fPolCd[i] != null)
					model.setFPolCd(fPolCd[i]);
				if (aSubmitNo[i] != null)
					model.setASubmitNo(aSubmitNo[i]);
				if (aSndDtTt[i] != null)
					model.setASndDtTt(aSndDtTt[i]);
				if (ifSended[i] != null)
					model.setIfSended(ifSended[i]);
				if (mfSndSeq[i] != null)
					model.setMfSndSeq(mfSndSeq[i]);
				if (trsmCxlTpCd[i] != null)
					model.setTrsmCxlTpCd(trsmCxlTpCd[i]);
				if (trsmCxlRsnCd[i] != null)
					model.setTrsmCxlRsnCd(trsmCxlRsnCd[i]);
				if (trsmCxlDesc[i] != null)
					model.setTrsmCxlDesc(trsmCxlDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorTransHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorTransHistVO[]
	 */
	public KorTransHistVO[] getKorTransHistVOs(){
		KorTransHistVO[] vos = (KorTransHistVO[])models.toArray(new KorTransHistVO[models.size()]);
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
		this.aOfcCd = this.aOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBlNo = this.fBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aMfRcvrUsrId = this.aMfRcvrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTrsmUsrId = this.fTrsmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCorrCd1 = this.aCorrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSndDt = this.fSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlNo = this.inBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPodCd = this.aPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fBlKnt = this.fBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aVvdCd = this.aVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOfcCd = this.inOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fVslCd = this.fVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMfRcvrUsrId = this.fMfRcvrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCreUsrId = this.fCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPodCd = this.inPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUpdDt = this.fUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsrId = this.inUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fKrCstmsDeclCd = this.fKrCstmsDeclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMsgType = this.inMsgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aESvcSendDate = this.aESvcSendDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdVoyNo = this.fSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inKsType = this.inKsType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCTp = this.aCTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBlNo = this.aBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aPolCd = this.aPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCreDt = this.fCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCorrCd1 = this.fCorrCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aFld40ft = this.aFld40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPodCd = this.fPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aSndDtDd = this.aSndDtDd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aTrsmUsrId = this.aTrsmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aFld20ft = this.aFld20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pSearchOption = this.pSearchOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aReceiver = this.aReceiver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSndDtE = this.inSndDtE .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fSkdDirCd = this.fSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSndDtS = this.inSndDtS .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fMsgLogTpId = this.fMsgLogTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSubNo = this.inSubNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aKsType = this.aKsType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fOfcCd = this.fOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aBlKnt = this.aBlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aMsgLogTpId = this.aMsgLogTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fUpdUsrId = this.fUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fPolCd = this.fPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aSubmitNo = this.aSubmitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aSndDtTt = this.aSndDtTt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSended = this.ifSended .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndSeq = this.mfSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlTpCd = this.trsmCxlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlRsnCd = this.trsmCxlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlDesc = this.trsmCxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
