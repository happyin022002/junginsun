/**
 * Copyright(c) 2010 CyberLogitec
 * @FileName : FlatFileForGateNewVO.java
 * @FileTitle : FlatFileForGateNewVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.06.02
 * @LastModifier : 김상현
 * @LastVersion : 1.1
 * 2010.02.17 김상수 1.0 Creation
 * 2016.06.02 김상현 1.1 [CHM-201641731] VGM 항목 추가
 */

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object.
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FlatFileForGateNewVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FlatFileForGateNewVO> models = new ArrayList<FlatFileForGateNewVO>();
	
	/* Column Info */
	private String eventDate = null;
	/* Column Info */
	private String[] bkgNumber = null;
	/* Column Info */
	private String chssCode = null;
	/* Column Info */
	private String substitution = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String muidArea = null;
	/* Column Info */
	private String termId = null;
	/* Column Info */
	private String flatCarNbr = null;
	/* Column Info */
	private String carrierCountry = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String contStat = null;
	/* Column Info */
	private String delTag = null;
	/* Column Info */
	private String chssCase = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String vessel = null;
	/* Column Info */
	private String bkgCount = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String dmgFlag = null;
	/* Column Info */
	private String gateIo = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String officeYard = null;
	/* Column Info */
	private String voyage = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNumber = null;
	/* Column Info */
	private String resultIndicator = null;
	/* Column Info */
	private String callSignNo = null;
	/* Column Info */
	private String checkNassignData = null;
	/* Column Info */
	private String bkgNumber0 = null;
	/* Column Info */
	private String mgSet = null;
	/* Column Info */
	private String ffileRrefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dir = null;
	/* Column Info */
	private String muidDt = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String muidSeq = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String wayBillNo = null;
	/* Column Info */
	private String eventYard = null;
	/* Column Info */
	private String mvmtEdiStsTpFlg = null;
	/* Column Info */
	private String ediUiYn = null;
	/* Column Info */
	private String carrierCode = null;
	/* Column Info */
	private String resultMessage = null;
	/* Column Info */
	private String destLoc = null;
	/* Column Info */
	private String mvmtStatus = null;
	/* Column Info */
	private String pickupNo = null;
	/* Column Info */
	private String nBkgNoFlg = null;
	/* Column Info */
	private String hangerTag = null;
	/* Column Info */
	private String ediBkgNo = null;
	/* Column Info */
	private String sightCd = null;
	/* Column Info */
	private String stowage = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String vgmWgtQty = null;
	/* Column Info */
	private String vgmVrfyDt = null;
	/* Column Info */
	private String vgmSigCtnt = null;
	/* Column Info */
	private String vgmRefNo = null;
	/* Column Info */
	private String vgmWgtPtyCtnt = null;
	/* Column Info */
	private String vgmVrfyOrdCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FlatFileForGateNewVO() {}

	public FlatFileForGateNewVO(String ibflag, String pagerows, String bkgCount, String[] bkgNumber, String bkgNumber0, String blNo, String callSignNo, String carrierCode, String carrierCountry, String checkNassignData, String chssCase, String chssCode, String cntrNumber, String cntCd, String contStat, String delTag, String destLoc, String dir, String dmgFlag, String ediId, String ediUiYn, String eventDate, String eventYard, String ffileRrefNo, String flatCarNbr, String gateIo, String hangerTag, String lloydNo, String lstmCd, String mgSet, String msgId, String muidArea, String muidDt, String muidSeq, String mvmtEdiStsTpFlg, String mvmtStatus, String nBkgNoFlg, String officeYard, String pickupNo, String pod, String pol, String resultIndicator, String resultMessage, String sealNo, String sightCd, String substitution, String termId, String transMode, String userId, String userNm, String vessel, String vndrSeq, String voyage, String cntrTpszCd, String ediBkgNo, String wayBillNo, String stowage, String vgmMzdTpCd, String vgmWgtUtCd, String vgmWgtQty, String vgmVrfyDt, String vgmSigCtnt, String vgmRefNo, String vgmWgtPtyCtnt, String vgmVrfyOrdCtnt) {
		this.eventDate = eventDate;
		this.bkgNumber = bkgNumber;
		this.chssCode = chssCode;
		this.substitution = substitution;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.muidArea = muidArea;
		this.termId = termId;
		this.flatCarNbr = flatCarNbr;
		this.carrierCountry = carrierCountry;
		this.cntrTpszCd = cntrTpszCd;
		this.cntCd = cntCd;
		this.pol = pol;
		this.userId = userId;
		this.lstmCd = lstmCd;
		this.contStat = contStat;
		this.delTag = delTag;
		this.chssCase = chssCase;
		this.pod = pod;
		this.vessel = vessel;
		this.bkgCount = bkgCount;
		this.ediId = ediId;
		this.userNm = userNm;
		this.dmgFlag = dmgFlag;
		this.gateIo = gateIo;
		this.transMode = transMode;
		this.lloydNo = lloydNo;
		this.officeYard = officeYard;
		this.voyage = voyage;
		this.vndrSeq = vndrSeq;
		this.cntrNumber = cntrNumber;
		this.resultIndicator = resultIndicator;
		this.callSignNo = callSignNo;
		this.checkNassignData = checkNassignData;
		this.bkgNumber0 = bkgNumber0;
		this.mgSet = mgSet;
		this.ffileRrefNo = ffileRrefNo;
		this.ibflag = ibflag;
		this.dir = dir;
		this.muidDt = muidDt;
		this.msgId = msgId;
		this.muidSeq = muidSeq;
		this.sealNo = sealNo;
		this.wayBillNo = wayBillNo;
		this.eventYard = eventYard;
		this.mvmtEdiStsTpFlg = mvmtEdiStsTpFlg;
		this.ediUiYn = ediUiYn;
		this.carrierCode = carrierCode;
		this.resultMessage = resultMessage;
		this.destLoc = destLoc;
		this.mvmtStatus = mvmtStatus;
		this.pickupNo = pickupNo;
		this.nBkgNoFlg = nBkgNoFlg;
		this.hangerTag = hangerTag;
		this.ediBkgNo = ediBkgNo;
		this.sightCd = sightCd;
		this.stowage = stowage;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.vgmWgtQty = vgmWgtQty;
		this.vgmVrfyDt = vgmVrfyDt;
		this.vgmSigCtnt = vgmSigCtnt;
		this.vgmRefNo = vgmRefNo;
		this.vgmWgtPtyCtnt = vgmWgtPtyCtnt;
		this.vgmVrfyOrdCtnt = vgmVrfyOrdCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("event_date", getEventDate());
		this.hashColumns.put("chss_code", getChssCode());
		this.hashColumns.put("substitution", getSubstitution());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("muid_area", getMuidArea());
		this.hashColumns.put("term_id", getTermId());
		this.hashColumns.put("flat_car_nbr", getFlatCarNbr());
		this.hashColumns.put("carrier_country", getCarrierCountry());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("cont_stat", getContStat());
		this.hashColumns.put("del_tag", getDelTag());
		this.hashColumns.put("chss_case", getChssCase());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("vessel", getVessel());
		this.hashColumns.put("bkg_count", getBkgCount());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("dmg_flag", getDmgFlag());
		this.hashColumns.put("gate_io", getGateIo());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("office_yard", getOfficeYard());
		this.hashColumns.put("voyage", getVoyage());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_number", getCntrNumber());
		this.hashColumns.put("result_indicator", getResultIndicator());
		this.hashColumns.put("call_sign_no", getCallSignNo());
		this.hashColumns.put("check_nassign_data", getCheckNassignData());
		this.hashColumns.put("bkg_number0", getBkgNumber0());
		this.hashColumns.put("mg_set", getMgSet());
		this.hashColumns.put("ffile_rref_no", getFfileRrefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dir", getDir());
		this.hashColumns.put("muid_dt", getMuidDt());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("muid_seq", getMuidSeq());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("way_bill_no", getWayBillNo());
		this.hashColumns.put("event_yard", getEventYard());
		this.hashColumns.put("mvmt_edi_sts_tp_flg", getMvmtEdiStsTpFlg());
		this.hashColumns.put("edi_ui_yn", getEdiUiYn());
		this.hashColumns.put("carrier_code", getCarrierCode());
		this.hashColumns.put("result_message", getResultMessage());
		this.hashColumns.put("dest_loc", getDestLoc());
		this.hashColumns.put("mvmt_status", getMvmtStatus());
		this.hashColumns.put("pickup_no", getPickupNo());
		this.hashColumns.put("n_bkg_no_flg", getNBkgNoFlg());
		this.hashColumns.put("hanger_tag", getHangerTag());
		this.hashColumns.put("edi_bkg_no", getEdiBkgNo());
		this.hashColumns.put("sight_cd", getSightCd());
		this.hashColumns.put("stowage", getStowage());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("vgm_wgt_qty", getVgmWgtQty());
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());
		this.hashColumns.put("vgm_sig_ctnt", getVgmSigCtnt());
		this.hashColumns.put("vgm_ref_no", getVgmRefNo());
		this.hashColumns.put("vgm_wgt_pty_ctnt", getVgmWgtPtyCtnt());
		this.hashColumns.put("vgm_vrfy_ord_ctnt", getVgmVrfyOrdCtnt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("event_date", "eventDate");
		this.hashFields.put("bkg_number", "bkgNumber");
		this.hashFields.put("chss_code", "chssCode");
		this.hashFields.put("substitution", "substitution");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("muid_area", "muidArea");
		this.hashFields.put("term_id", "termId");
		this.hashFields.put("flat_car_nbr", "flatCarNbr");
		this.hashFields.put("carrier_country", "carrierCountry");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("cont_stat", "contStat");
		this.hashFields.put("del_tag", "delTag");
		this.hashFields.put("chss_case", "chssCase");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("vessel", "vessel");
		this.hashFields.put("bkg_count", "bkgCount");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("dmg_flag", "dmgFlag");
		this.hashFields.put("gate_io", "gateIo");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("office_yard", "officeYard");
		this.hashFields.put("voyage", "voyage");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_number", "cntrNumber");
		this.hashFields.put("result_indicator", "resultIndicator");
		this.hashFields.put("call_sign_no", "callSignNo");
		this.hashFields.put("check_nassign_data", "checkNassignData");
		this.hashFields.put("bkg_number0", "bkgNumber0");
		this.hashFields.put("mg_set", "mgSet");
		this.hashFields.put("ffile_rref_no", "ffileRrefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dir", "dir");
		this.hashFields.put("muid_dt", "muidDt");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("muid_seq", "muidSeq");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("way_bill_no", "wayBillNo");
		this.hashFields.put("event_yard", "eventYard");
		this.hashFields.put("mvmt_edi_sts_tp_flg", "mvmtEdiStsTpFlg");
		this.hashFields.put("edi_ui_yn", "ediUiYn");
		this.hashFields.put("carrier_code", "carrierCode");
		this.hashFields.put("result_message", "resultMessage");
		this.hashFields.put("dest_loc", "destLoc");
		this.hashFields.put("mvmt_status", "mvmtStatus");
		this.hashFields.put("pickup_no", "pickupNo");
		this.hashFields.put("n_bkg_no_flg", "nBkgNoFlg");
		this.hashFields.put("hanger_tag", "hangerTag");
		this.hashFields.put("edi_bkg_no", "ediBkgNo");
		this.hashFields.put("sight_cd", "sightCd");
		this.hashFields.put("stowage", "stowage");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("vgm_wgt_qty", "vgmWgtQty");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("vgm_sig_ctnt", "vgmSigCtnt");
		this.hashFields.put("vgm_ref_no", "vgmRefNo");
		this.hashFields.put("vgm_wgt_pty_ctnt", "vgmWgtPtyCtnt");
		this.hashFields.put("vgm_vrfy_ord_ctnt", "vgmVrfyOrdCtnt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return eventDate
	 */
	public String getEventDate() {
		return this.eventDate;
	}

	/**
	 * Column Info
	 * @return bkgNumber
	 */
	public String[] getBkgNumber() {
		return this.bkgNumber;
	}
	
	/**
	 * Column Info
	 * @return chssCode
	 */
	public String getChssCode() {
		return this.chssCode;
	}
	
	/**
	 * Column Info
	 * @return substitution
	 */
	public String getSubstitution() {
		return this.substitution;
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
	 * @return muidArea
	 */
	public String getMuidArea() {
		return this.muidArea;
	}
	
	/**
	 * Column Info
	 * @return termId
	 */
	public String getTermId() {
		return this.termId;
	}
	
	/**
	 * Column Info
	 * @return flatCarNbr
	 */
	public String getFlatCarNbr() {
		return this.flatCarNbr;
	}
	
	/**
	 * Column Info
	 * @return carrierCountry
	 */
	public String getCarrierCountry() {
		return this.carrierCountry;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return contStat
	 */
	public String getContStat() {
		return this.contStat;
	}
	
	/**
	 * Column Info
	 * @return delTag
	 */
	public String getDelTag() {
		return this.delTag;
	}
	
	/**
	 * Column Info
	 * @return chssCase
	 */
	public String getChssCase() {
		return this.chssCase;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return vessel
	 */
	public String getVessel() {
		return this.vessel;
	}
	
	/**
	 * Column Info
	 * @return bkgCount
	 */
	public String getBkgCount() {
		return this.bkgCount;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return dmgFlag
	 */
	public String getDmgFlag() {
		return this.dmgFlag;
	}
	
	/**
	 * Column Info
	 * @return gateIo
	 */
	public String getGateIo() {
		return this.gateIo;
	}
	
	/**
	 * Column Info
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
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
	 * @return officeYard
	 */
	public String getOfficeYard() {
		return this.officeYard;
	}
	
	/**
	 * Column Info
	 * @return voyage
	 */
	public String getVoyage() {
		return this.voyage;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNumber
	 */
	public String getCntrNumber() {
		return this.cntrNumber;
	}
	
	/**
	 * Column Info
	 * @return resultIndicator
	 */
	public String getResultIndicator() {
		return this.resultIndicator;
	}
	
	/**
	 * Column Info
	 * @return callSignNo
	 */
	public String getCallSignNo() {
		return this.callSignNo;
	}
	
	/**
	 * Column Info
	 * @return checkNassignData
	 */
	public String getCheckNassignData() {
		return this.checkNassignData;
	}
	
	/**
	 * Column Info
	 * @return bkgNumber0
	 */
	public String getBkgNumber0() {
		return this.bkgNumber0;
	}
	
	/**
	 * Column Info
	 * @return mgSet
	 */
	public String getMgSet() {
		return this.mgSet;
	}
	
	/**
	 * Column Info
	 * @return ffileRrefNo
	 */
	public String getFfileRrefNo() {
		return this.ffileRrefNo;
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
	 * @return dir
	 */
	public String getDir() {
		return this.dir;
	}
	
	/**
	 * Column Info
	 * @return muidDt
	 */
	public String getMuidDt() {
		return this.muidDt;
	}
	
	/**
	 * Column Info
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 * Column Info
	 * @return muidSeq
	 */
	public String getMuidSeq() {
		return this.muidSeq;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return wayBillNo
	 */
	public String getWayBillNo() {
		return this.wayBillNo;
	}
	
	/**
	 * Column Info
	 * @return eventYard
	 */
	public String getEventYard() {
		return this.eventYard;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiStsTpFlg
	 */
	public String getMvmtEdiStsTpFlg() {
		return this.mvmtEdiStsTpFlg;
	}
	
	/**
	 * Column Info
	 * @return ediUiYn
	 */
	public String getEdiUiYn() {
		return this.ediUiYn;
	}
	
	/**
	 * Column Info
	 * @return carrierCode
	 */
	public String getCarrierCode() {
		return this.carrierCode;
	}
	
	/**
	 * Column Info
	 * @return resultMessage
	 */
	public String getResultMessage() {
		return this.resultMessage;
	}
	
	/**
	 * Column Info
	 * @return destLoc
	 */
	public String getDestLoc() {
		return this.destLoc;
	}
	
	/**
	 * Column Info
	 * @return mvmtStatus
	 */
	public String getMvmtStatus() {
		return this.mvmtStatus;
	}
	
	/**
	 * Column Info
	 * @return pickupNo
	 */
	public String getPickupNo() {
		return this.pickupNo;
	}
	
	/**
	 * Column Info
	 * @return nBkgNoFlg
	 */
	public String getNBkgNoFlg() {
		return this.nBkgNoFlg;
	}
	
	/**
	 * Column Info
	 * @return hangerTag
	 */
	public String getHangerTag() {
		return this.hangerTag;
	}
	
	/**
	 * Column Info
	 * @return ediBkgNo
	 */
	public String getEdiBkgNo() {
		return this.ediBkgNo;
	}
	
	/**
	 * Column Info
	 * @return sightCd
	 */
	public String getSightCd() {
		return this.sightCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStwgNo
	 */
	public String getStowage() {
		return this.stowage;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmMzdTpCd() {
		return vgmMzdTpCd;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmWgtUtCd() {
		return vgmWgtUtCd;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmWgtQty() {
		return vgmWgtQty;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmVrfyDt() {
		return vgmVrfyDt;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmSigCtnt() {
		return vgmSigCtnt;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmRefNo() {
		return vgmRefNo;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmWgtPtyCtnt() {
		return vgmWgtPtyCtnt;
	}

	/**
	 * Column Info
	 * @return
	 */
	public String getVgmVrfyOrdCtnt() {
		return vgmVrfyOrdCtnt;
	}

	/**
	 * Column Info
	 * @param eventDate
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	/**
	 * Column Info
	 * @param bkgNumber
	 */
	public void setBkgNumber(String[] bkgNumber) {
		this.bkgNumber = bkgNumber;
	}
	
	/**
	 * Column Info
	 * @param chssCode
	 */
	public void setChssCode(String chssCode) {
		this.chssCode = chssCode;
	}
	
	/**
	 * Column Info
	 * @param substitution
	 */
	public void setSubstitution(String substitution) {
		this.substitution = substitution;
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
	 * @param muidArea
	 */
	public void setMuidArea(String muidArea) {
		this.muidArea = muidArea;
	}
	
	/**
	 * Column Info
	 * @param termId
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}
	
	/**
	 * Column Info
	 * @param flatCarNbr
	 */
	public void setFlatCarNbr(String flatCarNbr) {
		this.flatCarNbr = flatCarNbr;
	}
	
	/**
	 * Column Info
	 * @param carrierCountry
	 */
	public void setCarrierCountry(String carrierCountry) {
		this.carrierCountry = carrierCountry;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
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
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param contStat
	 */
	public void setContStat(String contStat) {
		this.contStat = contStat;
	}
	
	/**
	 * Column Info
	 * @param delTag
	 */
	public void setDelTag(String delTag) {
		this.delTag = delTag;
	}
	
	/**
	 * Column Info
	 * @param chssCase
	 */
	public void setChssCase(String chssCase) {
		this.chssCase = chssCase;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param vessel
	 */
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	
	/**
	 * Column Info
	 * @param bkgCount
	 */
	public void setBkgCount(String bkgCount) {
		this.bkgCount = bkgCount;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	/**
	 * Column Info
	 * @param dmgFlag
	 */
	public void setDmgFlag(String dmgFlag) {
		this.dmgFlag = dmgFlag;
	}
	
	/**
	 * Column Info
	 * @param gateIo
	 */
	public void setGateIo(String gateIo) {
		this.gateIo = gateIo;
	}
	
	/**
	 * Column Info
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
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
	 * @param officeYard
	 */
	public void setOfficeYard(String officeYard) {
		this.officeYard = officeYard;
	}
	
	/**
	 * Column Info
	 * @param voyage
	 */
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNumber
	 */
	public void setCntrNumber(String cntrNumber) {
		this.cntrNumber = cntrNumber;
	}
	
	/**
	 * Column Info
	 * @param resultIndicator
	 */
	public void setResultIndicator(String resultIndicator) {
		this.resultIndicator = resultIndicator;
	}
	
	/**
	 * Column Info
	 * @param callSignNo
	 */
	public void setCallSignNo(String callSignNo) {
		this.callSignNo = callSignNo;
	}
	
	/**
	 * Column Info
	 * @param checkNassignData
	 */
	public void setCheckNassignData(String checkNassignData) {
		this.checkNassignData = checkNassignData;
	}
	
	/**
	 * Column Info
	 * @param bkgNumber0
	 */
	public void setBkgNumber0(String bkgNumber0) {
		this.bkgNumber0 = bkgNumber0;
	}
	
	/**
	 * Column Info
	 * @param mgSet
	 */
	public void setMgSet(String mgSet) {
		this.mgSet = mgSet;
	}
	
	/**
	 * Column Info
	 * @param ffileRrefNo
	 */
	public void setFfileRrefNo(String ffileRrefNo) {
		this.ffileRrefNo = ffileRrefNo;
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
	 * @param dir
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	/**
	 * Column Info
	 * @param muidDt
	 */
	public void setMuidDt(String muidDt) {
		this.muidDt = muidDt;
	}
	
	/**
	 * Column Info
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param muidSeq
	 */
	public void setMuidSeq(String muidSeq) {
		this.muidSeq = muidSeq;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param wayBillNo
	 */
	public void setWayBillNo(String wayBillNo) {
		this.wayBillNo = wayBillNo;
	}
	
	/**
	 * Column Info
	 * @param eventYard
	 */
	public void setEventYard(String eventYard) {
		this.eventYard = eventYard;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiStsTpFlg
	 */
	public void setMvmtEdiStsTpFlg(String mvmtEdiStsTpFlg) {
		this.mvmtEdiStsTpFlg = mvmtEdiStsTpFlg;
	}
	
	/**
	 * Column Info
	 * @param ediUiYn
	 */
	public void setEdiUiYn(String ediUiYn) {
		this.ediUiYn = ediUiYn;
	}
	
	/**
	 * Column Info
	 * @param carrierCode
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	/**
	 * Column Info
	 * @param resultMessage
	 */
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	/**
	 * Column Info
	 * @param destLoc
	 */
	public void setDestLoc(String destLoc) {
		this.destLoc = destLoc;
	}
	
	/**
	 * Column Info
	 * @param mvmtStatus
	 */
	public void setMvmtStatus(String mvmtStatus) {
		this.mvmtStatus = mvmtStatus;
	}
	
	/**
	 * Column Info
	 * @param pickupNo
	 */
	public void setPickupNo(String pickupNo) {
		this.pickupNo = pickupNo;
	}
	
	/**
	 * Column Info
	 * @param nBkgNoFlg
	 */
	public void setNBkgNoFlg(String nBkgNoFlg) {
		this.nBkgNoFlg = nBkgNoFlg;
	}
	
	/**
	 * Column Info
	 * @param hangerTag
	 */
	public void setHangerTag(String hangerTag) {
		this.hangerTag = hangerTag;
	}
	
	/**
	 * Column Info
	 * @param ediBkgNo
	 */
	public void setEdiBkgNo(String ediBkgNo) {
		this.ediBkgNo = ediBkgNo;
	}
	
	/**
	 * Column Info
	 * @param sightCd
	 */
	public void setSightCd(String sightCd) {
		this.sightCd = sightCd;
	}
	
	/**
	 * Column Info
	 * @param sightCd
	 */
	public void setStowage(String stowage) {
		this.stowage = stowage;
	}

	/**
	 * Column Info
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
	}

	/**
	 * Column Info
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
	}

	/**
	 * Column Info
	 * @param vgmWgtQty
	 */
	public void setVgmWgtQty(String vgmWgtQty) {
		this.vgmWgtQty = vgmWgtQty;
	}

	/**
	 * Column Info
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
	}

	/**
	 * Column Info
	 * @param vgmSigCtnt
	 */
	public void setVgmSigCtnt(String vgmSigCtnt) {
		this.vgmSigCtnt = vgmSigCtnt;
	}

	/**
	 * Column Info
	 * @param vgmRefNo
	 */
	public void setVgmRefNo(String vgmRefNo) {
		this.vgmRefNo = vgmRefNo;
	}

	/**
	 * Column Info
	 * @param vgmWgtPtyCtnt
	 */
	public void setVgmWgtPtyCtnt(String vgmWgtPtyCtnt) {
		this.vgmWgtPtyCtnt = vgmWgtPtyCtnt;
	}

	/**
	 * Column Info
	 * @param vgmVrfyOrdCtnt
	 */
	public void setVgmVrfyOrdCtnt(String vgmVrfyOrdCtnt) {
		this.vgmVrfyOrdCtnt = vgmVrfyOrdCtnt;
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
		setEventDate(JSPUtil.getParameter(request, prefix + "event_date", ""));
		setChssCode(JSPUtil.getParameter(request, prefix + "chss_code", ""));
		setSubstitution(JSPUtil.getParameter(request, prefix + "substitution", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMuidArea(JSPUtil.getParameter(request, prefix + "muid_area", ""));
		setTermId(JSPUtil.getParameter(request, prefix + "term_id", ""));
		setFlatCarNbr(JSPUtil.getParameter(request, prefix + "flat_car_nbr", ""));
		setCarrierCountry(JSPUtil.getParameter(request, prefix + "carrier_country", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setContStat(JSPUtil.getParameter(request, prefix + "cont_stat", ""));
		setDelTag(JSPUtil.getParameter(request, prefix + "del_tag", ""));
		setChssCase(JSPUtil.getParameter(request, prefix + "chss_case", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setVessel(JSPUtil.getParameter(request, prefix + "vessel", ""));
		setBkgCount(JSPUtil.getParameter(request, prefix + "bkg_count", ""));
		setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setDmgFlag(JSPUtil.getParameter(request, prefix + "dmg_flag", ""));
		setGateIo(JSPUtil.getParameter(request, prefix + "gate_io", ""));
		setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setOfficeYard(JSPUtil.getParameter(request, prefix + "office_yard", ""));
		setVoyage(JSPUtil.getParameter(request, prefix + "voyage", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNumber(JSPUtil.getParameter(request, prefix + "cntr_number", ""));
		setResultIndicator(JSPUtil.getParameter(request, prefix + "result_indicator", ""));
		setCallSignNo(JSPUtil.getParameter(request, prefix + "call_sign_no", ""));
		setCheckNassignData(JSPUtil.getParameter(request, prefix + "check_nassign_data", ""));
		setBkgNumber0(JSPUtil.getParameter(request, prefix + "bkg_number0", ""));
		setMgSet(JSPUtil.getParameter(request, prefix + "mg_set", ""));
		setFfileRrefNo(JSPUtil.getParameter(request, prefix + "ffile_rref_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDir(JSPUtil.getParameter(request, prefix + "dir", ""));
		setMuidDt(JSPUtil.getParameter(request, prefix + "muid_dt", ""));
		setMsgId(JSPUtil.getParameter(request, prefix + "msg_id", ""));
		setMuidSeq(JSPUtil.getParameter(request, prefix + "muid_seq", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setWayBillNo(JSPUtil.getParameter(request, prefix + "way_bill_no", ""));
		setEventYard(JSPUtil.getParameter(request, prefix + "event_yard", ""));
		setMvmtEdiStsTpFlg(JSPUtil.getParameter(request, prefix + "mvmt_edi_sts_tp_flg", ""));
		setEdiUiYn(JSPUtil.getParameter(request, prefix + "edi_ui_yn", ""));
		setCarrierCode(JSPUtil.getParameter(request, prefix + "carrier_code", ""));
		setResultMessage(JSPUtil.getParameter(request, prefix + "result_message", ""));
		setDestLoc(JSPUtil.getParameter(request, prefix + "dest_loc", ""));
		setMvmtStatus(JSPUtil.getParameter(request, prefix + "mvmt_status", ""));
		setPickupNo(JSPUtil.getParameter(request, prefix + "pickup_no", ""));
		setNBkgNoFlg(JSPUtil.getParameter(request, prefix + "n_bkg_no_flg", ""));
		setHangerTag(JSPUtil.getParameter(request, prefix + "hanger_tag", ""));
		setEdiBkgNo(JSPUtil.getParameter(request, prefix + "edi_bkg_no", ""));
		setSightCd(JSPUtil.getParameter(request, prefix + "sight_cd", ""));
		setStowage(JSPUtil.getParameter(request, prefix + "stowage", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setVgmWgtQty(JSPUtil.getParameter(request, prefix + "vgm_wgt_qty", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", ""));
		setVgmSigCtnt(JSPUtil.getParameter(request, prefix + "vgm_sig_ctnt", ""));
		setVgmRefNo(JSPUtil.getParameter(request, prefix + "vgm_ref_no", ""));
		setVgmWgtPtyCtnt(JSPUtil.getParameter(request, prefix + "vgm_wgt_pty_ctnt", ""));
		setVgmVrfyOrdCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_ord_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FlatFileForGateNewVO[]
	 */
	public FlatFileForGateNewVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FlatFileForGateNewVO[]
	 */
	public FlatFileForGateNewVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FlatFileForGateNewVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eventDate = (JSPUtil.getParameter(request, prefix	+ "event_date", length));
			String[] chssCode = (JSPUtil.getParameter(request, prefix	+ "chss_code", length));
			String[] substitution = (JSPUtil.getParameter(request, prefix	+ "substitution", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] muidArea = (JSPUtil.getParameter(request, prefix	+ "muid_area", length));
			String[] termId = (JSPUtil.getParameter(request, prefix	+ "term_id", length));
			String[] flatCarNbr = (JSPUtil.getParameter(request, prefix	+ "flat_car_nbr", length));
			String[] carrierCountry = (JSPUtil.getParameter(request, prefix	+ "carrier_country", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] contStat = (JSPUtil.getParameter(request, prefix	+ "cont_stat", length));
			String[] delTag = (JSPUtil.getParameter(request, prefix	+ "del_tag", length));
			String[] chssCase = (JSPUtil.getParameter(request, prefix	+ "chss_case", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] vessel = (JSPUtil.getParameter(request, prefix	+ "vessel", length));
			String[] bkgCount = (JSPUtil.getParameter(request, prefix	+ "bkg_count", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] dmgFlag = (JSPUtil.getParameter(request, prefix	+ "dmg_flag", length));
			String[] gateIo = (JSPUtil.getParameter(request, prefix	+ "gate_io", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] officeYard = (JSPUtil.getParameter(request, prefix	+ "office_yard", length));
			String[] voyage = (JSPUtil.getParameter(request, prefix	+ "voyage", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] cntrNumber = (JSPUtil.getParameter(request, prefix	+ "cntr_number", length));
			String[] resultIndicator = (JSPUtil.getParameter(request, prefix	+ "result_indicator", length));
			String[] callSignNo = (JSPUtil.getParameter(request, prefix	+ "call_sign_no", length));
			String[] checkNassignData = (JSPUtil.getParameter(request, prefix	+ "check_nassign_data", length));
			String[] bkgNumber0 = (JSPUtil.getParameter(request, prefix	+ "bkg_number0", length));
			String[] mgSet = (JSPUtil.getParameter(request, prefix	+ "mg_set", length));
			String[] ffileRrefNo = (JSPUtil.getParameter(request, prefix	+ "ffile_rref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dir = (JSPUtil.getParameter(request, prefix	+ "dir", length));
			String[] muidDt = (JSPUtil.getParameter(request, prefix	+ "muid_dt", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] muidSeq = (JSPUtil.getParameter(request, prefix	+ "muid_seq", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] wayBillNo = (JSPUtil.getParameter(request, prefix	+ "way_bill_no", length));
			String[] eventYard = (JSPUtil.getParameter(request, prefix	+ "event_yard", length));
			String[] mvmtEdiStsTpFlg = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_sts_tp_flg", length));
			String[] ediUiYn = (JSPUtil.getParameter(request, prefix	+ "edi_ui_yn", length));
			String[] carrierCode = (JSPUtil.getParameter(request, prefix	+ "carrier_code", length));
			String[] resultMessage = (JSPUtil.getParameter(request, prefix	+ "result_message", length));
			String[] destLoc = (JSPUtil.getParameter(request, prefix	+ "dest_loc", length));
			String[] mvmtStatus = (JSPUtil.getParameter(request, prefix	+ "mvmt_status", length));
			String[] pickupNo = (JSPUtil.getParameter(request, prefix	+ "pickup_no", length));
			String[] nBkgNoFlg = (JSPUtil.getParameter(request, prefix	+ "n_bkg_no_flg", length));
			String[] hangerTag = (JSPUtil.getParameter(request, prefix	+ "hanger_tag", length));
			String[] ediBkgNo = (JSPUtil.getParameter(request, prefix	+ "edi_bkg_no", length));
			String[] sightCd = (JSPUtil.getParameter(request, prefix	+ "sight_cd", length));
			String[] stowage = (JSPUtil.getParameter(request, prefix	+ "stowage", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", length));
			String[] vgmWgtQty = (JSPUtil.getParameter(request, prefix + "vgm_wgt_qty", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", length));
			String[] vgmSigCtnt = (JSPUtil.getParameter(request, prefix + "vgm_sig_ctnt", length));
			String[] vgmRefNo = (JSPUtil.getParameter(request, prefix + "vgm_ref_no", length));
			String[] vgmWgtPtyCtnt = (JSPUtil.getParameter(request, prefix + "vgm_wgt_pty_ctnt", length));
			String[] vgmVrfyOrdCtnt = (JSPUtil.getParameter(request, prefix + "vgm_vrfy_ord_ctnt", length));

			for (int i = 0; i < length; i++) {
				model = new FlatFileForGateNewVO();
				if (eventDate[i] != null)
					model.setEventDate(eventDate[i]);
				if (chssCode[i] != null)
					model.setChssCode(chssCode[i]);
				if (substitution[i] != null)
					model.setSubstitution(substitution[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (muidArea[i] != null)
					model.setMuidArea(muidArea[i]);
				if (termId[i] != null)
					model.setTermId(termId[i]);
				if (flatCarNbr[i] != null)
					model.setFlatCarNbr(flatCarNbr[i]);
				if (carrierCountry[i] != null)
					model.setCarrierCountry(carrierCountry[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (contStat[i] != null)
					model.setContStat(contStat[i]);
				if (delTag[i] != null)
					model.setDelTag(delTag[i]);
				if (chssCase[i] != null)
					model.setChssCase(chssCase[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (vessel[i] != null)
					model.setVessel(vessel[i]);
				if (bkgCount[i] != null)
					model.setBkgCount(bkgCount[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (dmgFlag[i] != null)
					model.setDmgFlag(dmgFlag[i]);
				if (gateIo[i] != null)
					model.setGateIo(gateIo[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (officeYard[i] != null)
					model.setOfficeYard(officeYard[i]);
				if (voyage[i] != null)
					model.setVoyage(voyage[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (cntrNumber[i] != null)
					model.setCntrNumber(cntrNumber[i]);
				if (resultIndicator[i] != null)
					model.setResultIndicator(resultIndicator[i]);
				if (callSignNo[i] != null)
					model.setCallSignNo(callSignNo[i]);
				if (checkNassignData[i] != null)
					model.setCheckNassignData(checkNassignData[i]);
				if (bkgNumber0[i] != null)
					model.setBkgNumber0(bkgNumber0[i]);
				if (mgSet[i] != null)
					model.setMgSet(mgSet[i]);
				if (ffileRrefNo[i] != null)
					model.setFfileRrefNo(ffileRrefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dir[i] != null)
					model.setDir(dir[i]);
				if (muidDt[i] != null)
					model.setMuidDt(muidDt[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (muidSeq[i] != null)
					model.setMuidSeq(muidSeq[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (wayBillNo[i] != null)
					model.setWayBillNo(wayBillNo[i]);
				if (eventYard[i] != null)
					model.setEventYard(eventYard[i]);
				if (mvmtEdiStsTpFlg[i] != null)
					model.setMvmtEdiStsTpFlg(mvmtEdiStsTpFlg[i]);
				if (ediUiYn[i] != null)
					model.setEdiUiYn(ediUiYn[i]);
				if (carrierCode[i] != null)
					model.setCarrierCode(carrierCode[i]);
				if (resultMessage[i] != null)
					model.setResultMessage(resultMessage[i]);
				if (destLoc[i] != null)
					model.setDestLoc(destLoc[i]);
				if (mvmtStatus[i] != null)
					model.setMvmtStatus(mvmtStatus[i]);
				if (pickupNo[i] != null)
					model.setPickupNo(pickupNo[i]);
				if (nBkgNoFlg[i] != null)
					model.setNBkgNoFlg(nBkgNoFlg[i]);
				if (hangerTag[i] != null)
					model.setHangerTag(hangerTag[i]);
				if (ediBkgNo[i] != null)
					model.setEdiBkgNo(ediBkgNo[i]);
				if (sightCd[i] != null)
					model.setSightCd(sightCd[i]);
				if (stowage[i] != null)
					model.setStowage(stowage[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (vgmWgtQty[i] != null)
					model.setVgmWgtQty(vgmWgtQty[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);
				if (vgmSigCtnt[i] != null)
					model.setVgmSigCtnt(vgmSigCtnt[i]);
				if (vgmRefNo[i] != null)
					model.setVgmRefNo(vgmRefNo[i]);
				if (vgmWgtPtyCtnt[i] != null)
					model.setVgmWgtPtyCtnt(vgmWgtPtyCtnt[i]);
				if (vgmVrfyOrdCtnt[i] != null)
					model.setVgmVrfyOrdCtnt(vgmVrfyOrdCtnt[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFlatFileForGateNewVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FlatFileForGateNewVO[]
	 */
	public FlatFileForGateNewVO[] getFlatFileForGateNewVOs(){
		FlatFileForGateNewVO[] vos = (FlatFileForGateNewVO[])models.toArray(new FlatFileForGateNewVO[models.size()]);
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
		this.eventDate = this.eventDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCode = this.chssCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substitution = this.substitution .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.muidArea = this.muidArea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termId = this.termId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatCarNbr = this.flatCarNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCountry = this.carrierCountry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contStat = this.contStat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTag = this.delTag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCase = this.chssCase .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vessel = this.vessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCount = this.bkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlag = this.dmgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gateIo = this.gateIo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeYard = this.officeYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyage = this.voyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNumber = this.cntrNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resultIndicator = this.resultIndicator .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSignNo = this.callSignNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkNassignData = this.checkNassignData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNumber0 = this.bkgNumber0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgSet = this.mgSet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffileRrefNo = this.ffileRrefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dir = this.dir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.muidDt = this.muidDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.muidSeq = this.muidSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wayBillNo = this.wayBillNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventYard = this.eventYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiStsTpFlg = this.mvmtEdiStsTpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUiYn = this.ediUiYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCode = this.carrierCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resultMessage = this.resultMessage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLoc = this.destLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStatus = this.mvmtStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickupNo = this.pickupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nBkgNoFlg = this.nBkgNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hangerTag = this.hangerTag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediBkgNo = this.ediBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sightCd = this.sightCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stowage = this.stowage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtQty = this.vgmWgtQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSigCtnt = this.vgmSigCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmRefNo = this.vgmRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtPtyCtnt = this.vgmWgtPtyCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyOrdCtnt = this.vgmVrfyOrdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
