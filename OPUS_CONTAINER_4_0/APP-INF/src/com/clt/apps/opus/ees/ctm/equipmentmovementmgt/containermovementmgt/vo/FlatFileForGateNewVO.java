/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FlatFileForGateNewVO.java
*@FileTitle : FlatFileForGateNewVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.02.17 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
	private String mgsCase = null;
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
	private String dmgFlgDt = null;
	/* Column Info */
	private String dmgUnflgDt = null;
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
	private String destNm = null;
	/* Column Info */
	private String destSte = null;
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
	
	// 2014.09.01 추가 NYK EDI Flat File 추가
	/* Column Info */
	private String ediCrrNo = null;
	/* Column Info */
	private String trspDocNo = null;
	/* Column Info */
	private String mtyRepoNo = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String mtyPlnNo = null;
	/* Column Info */
	private String tirNo = null;
	/* Column Info */
	private String ediVvdCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String oscaBkgFlg = null;
	/* Column Info */
	private String ediMtyEqRepoRefNo = null;
	/* Column Info */
	private String vgmDocIdNo = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmEdiWgtUtCd = null;
	/* Column Info */
	private String vgmDocTpCd = null;
	/* Column Info */
	private String vgmDtTpCd = null;
	/* Column Info */
	private String vgmHndlDt = null;
	/* Column Info */
	private String vgmCustCntcTpCd = null;
	/* Column Info */
	private String vgmCustCntcNm = null;
	/* Column Info */
	private String vgmCustFaxNo = null;
	/* Column Info */
	private String vgmCustEml = null;
	/* Column Info */
	private String vgmCustPhnNo = null;
	/* Column Info */
	private String vgmCustAddr = null;
	/* Column Info */
	private String cntrStwgPsnCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FlatFileForGateNewVO() {}

	public FlatFileForGateNewVO(String ibflag, String pagerows, String bkgCount, String[] bkgNumber, String bkgNumber0, String blNo, String callSignNo, String carrierCode, String carrierCountry, String checkNassignData, String chssCase, String mgsCase, String chssCode, String cntrNumber, String cntCd, String contStat, String delTag, String destLoc, String destNm, String destSte, String dir, String dmgFlag, String dmgFlgDt, String dmgUnflgDt, String ediId, String ediUiYn, String eventDate, String eventYard, String ffileRrefNo, String flatCarNbr, String gateIo, String hangerTag, String lloydNo, String lstmCd, String mgSet, String msgId, String muidArea, String muidDt, String muidSeq, String mvmtEdiStsTpFlg, String mvmtStatus, String nBkgNoFlg, String officeYard, String pickupNo, String pod, String pol, String resultIndicator, String resultMessage, String sealNo, String sightCd, String substitution, String termId, String transMode, String userId, String userNm, String vessel, String vndrSeq, String voyage, String cntrTpszCd, String ediBkgNo, String wayBillNo, String stowage, 
			String woNo, String ediVvdCd, String vslEngNm, String tirNo, String mtyPlnNo, String mtyRepoNo, String ediCrrNo, String trspDocNo, String oscaBkgFlg, String ediMtyEqRepoRefNo, String vgmDocIdNo, String vgmWgt, String vgmEdiWgtUtCd, String vgmDocTpCd, String vgmDtTpCd, String vgmHndlDt, String vgmCustCntcTpCd, String vgmCustCntcNm, String vgmCustFaxNo, String vgmCustEml, String vgmCustPhnNo, String vgmCustAddr, String cntrStwgPsnCtnt) {
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
		this.mgsCase = mgsCase;
		this.pod = pod;
		this.vessel = vessel;
		this.bkgCount = bkgCount;
		this.ediId = ediId;
		this.userNm = userNm;
		this.dmgFlag = dmgFlag;
		this.dmgFlgDt = dmgFlgDt;
		this.dmgUnflgDt = dmgUnflgDt;
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
		this.destNm = destNm;
		this.destSte = destSte;
		this.mvmtStatus = mvmtStatus;
		this.pickupNo = pickupNo;
		this.nBkgNoFlg = nBkgNoFlg;
		this.hangerTag = hangerTag;
		this.ediBkgNo = ediBkgNo;
		this.sightCd = sightCd;
		this.stowage = stowage;
		this.ediCrrNo = ediCrrNo;
		this.trspDocNo = trspDocNo;
		this.mtyRepoNo = mtyRepoNo;
		this.woNo = woNo;
		this.mtyPlnNo = mtyPlnNo;
		this.tirNo = tirNo;
		this.ediVvdCd = ediVvdCd;
		this.vslEngNm = vslEngNm;
		this.oscaBkgFlg = oscaBkgFlg;
		this.ediMtyEqRepoRefNo = ediMtyEqRepoRefNo;
		this.vgmDocIdNo = vgmDocIdNo;
		this.vgmWgt = vgmWgt;
		this.vgmEdiWgtUtCd = vgmEdiWgtUtCd;
		this.vgmDocTpCd = vgmDocTpCd;
		this.vgmDtTpCd = vgmDtTpCd;
		this.vgmHndlDt = vgmHndlDt;
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
		this.vgmCustCntcNm = vgmCustCntcNm;
		this.vgmCustFaxNo = vgmCustFaxNo;
		this.vgmCustEml = vgmCustEml;
		this.vgmCustPhnNo = vgmCustPhnNo;
		this.vgmCustAddr = vgmCustAddr;
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
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
		this.hashColumns.put("mgs_case", getMgsCase());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("vessel", getVessel());
		this.hashColumns.put("bkg_count", getBkgCount());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("dmg_flag", getDmgFlag());
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());
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
		this.hashColumns.put("dest_nm", getDestNm());
		this.hashColumns.put("dest_ste", getDestSte());
		this.hashColumns.put("mvmt_status", getMvmtStatus());
		this.hashColumns.put("pickup_no", getPickupNo());
		this.hashColumns.put("n_bkg_no_flg", getNBkgNoFlg());
		this.hashColumns.put("hanger_tag", getHangerTag());
		this.hashColumns.put("edi_bkg_no", getEdiBkgNo());
		this.hashColumns.put("sight_cd", getSightCd());
		this.hashColumns.put("stowage", getStowage());
		this.hashColumns.put("edi_crr_no", getEdiCrrNo());
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());
		this.hashColumns.put("mty_repo_no", getMtyRepoNo());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		this.hashColumns.put("tir_no", getTirNo());
		this.hashColumns.put("edi_vvd_cd", getEdiVvdCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("osca_bkg_flg", getOscaBkgFlg());
		this.hashColumns.put("edi_mty_eq_repo_ref_no", getEdiMtyEqRepoRefNo());
		this.hashColumns.put("vgm_doc_id_no", getVgmDocIdNo());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_edi_wgt_ut_cd", getVgmEdiWgtUtCd());
		this.hashColumns.put("vgm_doc_tp_cd", getVgmDocTpCd());
		this.hashColumns.put("vgm_dt_tp_cd", getVgmDtTpCd());
		this.hashColumns.put("vgm_hndl_dt", getVgmHndlDt());
		this.hashColumns.put("vgm_cust_cntc_tp_cd", getVgmCustCntcTpCd());
		this.hashColumns.put("vgm_cust_cntc_nm", getVgmCustCntcNm());
		this.hashColumns.put("vgm_cust_fax_no", getVgmCustFaxNo());
		this.hashColumns.put("vgm_cust_eml", getVgmCustEml());
		this.hashColumns.put("vgm_cust_phn_no", getVgmCustPhnNo());
		this.hashColumns.put("vgm_cust_addr", getVgmCustAddr());
		this.hashColumns.put("cntr_stwg_psn_ctnt", getCntrStwgPsnCtnt());
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
		this.hashFields.put("mgs_case", "mgsCase");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("vessel", "vessel");
		this.hashFields.put("bkg_count", "bkgCount");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("dmg_flag", "dmgFlag");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
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
		this.hashFields.put("dest_nm", "destNm");
		this.hashFields.put("dest_ste", "destSte");
		this.hashFields.put("mvmt_status", "mvmtStatus");
		this.hashFields.put("pickup_no", "pickupNo");
		this.hashFields.put("n_bkg_no_flg", "nBkgNoFlg");
		this.hashFields.put("hanger_tag", "hangerTag");
		this.hashFields.put("edi_bkg_no", "ediBkgNo");
		this.hashFields.put("sight_cd", "sightCd");
		this.hashFields.put("stowage", "stowage");
		this.hashFields.put("edi_crr_no", "ediCrrNo");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("mty_repo_no", "mtyRepoNo");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("tir_no", "tirNo");
		this.hashFields.put("edi_vvd_cd", "ediVvdCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("osca_bkg_flg", "oscaBkgFlg");
		this.hashFields.put("edi_mty_eq_repo_ref_no", "ediMtyEqRepoRefNo");
		this.hashFields.put("vgm_doc_id_no", "vgmDocIdNo");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_edi_wgt_ut_cd", "vgmEdiWgtUtCd");
		this.hashFields.put("vgm_doc_tp_cd", "vgmDocTpCd");
		this.hashFields.put("vgm_dt_tp_cd", "vgmDtTpCd");
		this.hashFields.put("vgm_hndl_dt", "vgmHndlDt");
		this.hashFields.put("vgm_cust_cntc_tp_cd", "vgmCustCntcTpCd");
		this.hashFields.put("vgm_cust_cntc_nm", "vgmCustCntcNm");
		this.hashFields.put("vgm_cust_fax_no", "vgmCustFaxNo");
		this.hashFields.put("vgm_cust_eml", "vgmCustEml");
		this.hashFields.put("vgm_cust_phn_no", "vgmCustPhnNo");
		this.hashFields.put("vgm_cust_addr", "vgmCustAddr");
		this.hashFields.put("cntr_stwg_psn_ctnt", "cntrStwgPsnCtnt");
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
	 * @return mgsCase
	 */
	public String getMgsCase() {
		return this.mgsCase;
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
	 * @return dmgFlgDt
	 */
	public String getDmgFlgDt() {
		return this.dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @return dmgUnflgDt
	 */
	public String getDmgUnflgDt() {
		return this.dmgUnflgDt;
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
	 * @return destNm
	 */
	public String getDestNm() {
		return this.destNm;
	}
	
	/**
	 * Column Info
	 * @return destSte
	 */
	public String getDestSte() {
		return this.destSte;
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
	 * @return ediCrrNo
	 */
	public String getEdiCrrNo() {
		return this.ediCrrNo;
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
	 * @return mtyRepoNo
	 */
	public String getMtyRepoNo() {
		return this.mtyRepoNo;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
	}
	
	/**
	 * Column Info
	 * @return tirNo
	 */
	public String getTirNo() {
		return this.tirNo;
	}
	
	/**
	 * Column Info
	 * @return ediVvdCd
	 */
	public String getEdiVvdCd() {
		return this.ediVvdCd;
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
	 * @return ediMtyEqRepoRefNo
	 */
	public String getEdiMtyEqRepoRefNo() {
		return this.ediMtyEqRepoRefNo;
	}
	
	/**
	 * Column Info
	 * @return vgmDocIdNo
	 */
	public String getVgmDocIdNo() {
		return this.vgmDocIdNo;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmEdiWgtUtCd
	 */
	public String getVgmEdiWgtUtCd() {
		return this.vgmEdiWgtUtCd;
	}
	
	
	/**
	 * Column Info
	 * @return vgmDocTpCd
	 */
	public String getVgmDocTpCd() {
		return this.vgmDocTpCd;
	}
	
	
	/**
	 * Column Info
	 * @return vgmDtTpCd
	 */
	public String getVgmDtTpCd() {
		return this.vgmDtTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmHndlDt
	 */
	public String getVgmHndlDt() {
		return this.vgmHndlDt;
	}
	
	/**
	 * Column Info
	 * @return vgmCustCntcTpCd
	 */
	public String getVgmCustCntcTpCd() {
		return this.vgmCustCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmCustCntcNm
	 */
	public String getVgmCustCntcNm() {
		return this.vgmCustCntcNm;
	}
	
	/**
	 * Column Info
	 * @return vgmCustFaxNo
	 */
	public String getVgmCustFaxNo() {
		return this.vgmCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return vgmCustEml
	 */
	public String getVgmCustEml() {
		return this.vgmCustEml;
	}
	
	/**
	 * Column Info
	 * @return vgmCustPhnNo
	 */
	public String getVgmCustPhnNo() {
		return this.vgmCustPhnNo;
	}
	
	/**
	 * Column Info
	 * @return vgmCustAddr
	 */
	public String getVgmCustAddr() {
		return this.vgmCustAddr;
	}
	
	/**
	 * Column Info
	 * @return cntrStwgPsnCtnt
	 */
	public String getCntrStwgPsnCtnt() {
		return this.cntrStwgPsnCtnt;
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
	 * @param mgsCase
	 */
	public void setMgsCase(String mgsCase) {
		this.mgsCase = mgsCase;
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
	 * @param dmgFlgDt
	 */
	public void setDmgFlgDt(String dmgFlgDt) {
		this.dmgFlgDt = dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @param dmgUnflgDt
	 */
	public void setDmgUnflgDt(String dmgUnflgDt) {
		this.dmgUnflgDt = dmgUnflgDt;
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
	 * @param destNm
	 */
	public void setDestNm(String destNm) {
		this.destNm = destNm;
	}
	
	/**
	 * Column Info
	 * @param destSte
	 */
	public void setDestSte(String destSte) {
		this.destSte = destSte;
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
	 * @param ediCrrNo
	 */
	public void setEdiCrrNo(String ediCrrNo) {
		this.ediCrrNo = ediCrrNo;
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
	 * @param mtyRepoNo
	 */
	public void setMtyRepoNo(String mtyRepoNo) {
		this.mtyRepoNo = mtyRepoNo;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
	}
	
	/**
	 * Column Info
	 * @param tirNo
	 */
	public void setTirNo(String tirNo) {
		this.tirNo = tirNo;
	}
	
	/**
	 * Column Info
	 * @param ediVvdCd
	 */
	public void setEdiVvdCd(String ediVvdCd) {
		this.ediVvdCd = ediVvdCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}

	public String getOscaBkgFlg() {
		return oscaBkgFlg;
	}

	public void setOscaBkgFlg(String oscaBkgFlg) {
		this.oscaBkgFlg = oscaBkgFlg;
	}
	
	/**
	 * Column Info
	 * @param ediMtyEqRepoRefNo
	 */
	public void setEdiMtyEqRepoRefNo(String ediMtyEqRepoRefNo) {
		this.ediMtyEqRepoRefNo = ediMtyEqRepoRefNo;
	}
	
	/**
	 * Column Info
	 * @param vgmDocIdNo
	 */
	public void setVgmDocIdNo(String vgmDocIdNo) {
		this.vgmDocIdNo = vgmDocIdNo;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	
	/**
	 * Column Info
	 * @param vgmEdiWgtUtCd
	 */
	public void setVgmEdiWgtUtCd(String vgmEdiWgtUtCd) {
		this.vgmEdiWgtUtCd = vgmEdiWgtUtCd;
	}
	
	
	/**
	 * Column Info
	 * @param vgmDocTpCd
	 */
	public void setVgmDocTpCd(String vgmDocTpCd) {
		this.vgmDocTpCd = vgmDocTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmDtTpCd
	 */
	public void setVgmDtTpCd(String vgmDtTpCd) {
		this.vgmDtTpCd = vgmDtTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmHndlDt
	 */
	public void setVgmHndlDt(String vgmHndlDt) {
		this.vgmHndlDt = vgmHndlDt;
	}
	
	/**
	 * Column Info
	 * @param vgmCustCntcTpCd
	 */
	public void setVgmCustCntcTpCd(String vgmCustCntcTpCd) {
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmCustCntcNm
	 */
	public void setVgmCustCntcNm(String vgmCustCntcNm) {
		this.vgmCustCntcNm = vgmCustCntcNm;
	}
	
	/**
	 * Column Info
	 * @param vgmCustFaxNo
	 */
	public void setVgmCustFaxNo(String vgmCustFaxNo) {
		this.vgmCustFaxNo = vgmCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param vgmCustEml
	 */
	public void setVgmCustEml(String vgmCustEml) {
		this.vgmCustEml = vgmCustEml;
	}
	
	/**
	 * Column Info
	 * @param vgmCustPhnNo
	 */
	public void setVgmCustPhnNo(String vgmCustPhnNo) {
		this.vgmCustPhnNo = vgmCustPhnNo;
	}
	
	/**
	 * Column Info
	 * @param vgmCustAddr
	 */
	public void setVgmCustAddr(String vgmCustAddr) {
		this.vgmCustAddr = vgmCustAddr;
	}
	
	/**
	 * Column Info
	 * @param cntrStwgPsnCtnt
	 */
	public void setCntrStwgPsnCtnt(String cntrStwgPsnCtnt) {
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
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
		setMgsCase(JSPUtil.getParameter(request, prefix + "mgs_case", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setVessel(JSPUtil.getParameter(request, prefix + "vessel", ""));
		setBkgCount(JSPUtil.getParameter(request, prefix + "bkg_count", ""));
		setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setDmgFlag(JSPUtil.getParameter(request, prefix + "dmg_flag", ""));
		setDmgFlgDt(JSPUtil.getParameter(request, prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request, prefix + "dmg_unflg_dt", ""));
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
		setDestNm(JSPUtil.getParameter(request, prefix + "dest_nm", ""));
		setDestSte(JSPUtil.getParameter(request, prefix + "dest_ste", ""));
		setMvmtStatus(JSPUtil.getParameter(request, prefix + "mvmt_status", ""));
		setPickupNo(JSPUtil.getParameter(request, prefix + "pickup_no", ""));
		setNBkgNoFlg(JSPUtil.getParameter(request, prefix + "n_bkg_no_flg", ""));
		setHangerTag(JSPUtil.getParameter(request, prefix + "hanger_tag", ""));
		setEdiBkgNo(JSPUtil.getParameter(request, prefix + "edi_bkg_no", ""));
		setSightCd(JSPUtil.getParameter(request, prefix + "sight_cd", ""));
		setStowage(JSPUtil.getParameter(request, prefix + "stowage", ""));
		setEdiCrrNo(JSPUtil.getParameter(request, prefix + "edi_crr_no", ""));
		setTrspDocNo(JSPUtil.getParameter(request, prefix + "trsp_doc_no", ""));
		setMtyRepoNo(JSPUtil.getParameter(request, prefix + "mty_repo_no", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, prefix + "mty_pln_no", ""));
		setTirNo(JSPUtil.getParameter(request, prefix + "tir_no", ""));
		setEdiVvdCd(JSPUtil.getParameter(request, prefix + "edi_vvd_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setOscaBkgFlg(JSPUtil.getParameter(request, prefix + "osca_bkg_flg", ""));
		setEdiMtyEqRepoRefNo(JSPUtil.getParameter(request, prefix + "edi_mty_eq_repo_ref_no", ""));
		setVgmDocIdNo(JSPUtil.getParameter(request, prefix + "vgm_doc_id_no", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmEdiWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_edi_wgt_ut_cd", ""));
		setVgmDocTpCd(JSPUtil.getParameter(request, prefix + "vgm_doc_tp_cd", ""));
		setVgmDtTpCd(JSPUtil.getParameter(request, prefix + "vgm_dt_tp_cd", ""));
		setVgmHndlDt(JSPUtil.getParameter(request, prefix + "vgm_hndl_dt", ""));
		setVgmCustCntcTpCd(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_tp_cd", ""));
		setVgmCustCntcNm(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_nm", ""));
		setVgmCustFaxNo(JSPUtil.getParameter(request, prefix + "vgm_cust_fax_no", ""));
		setVgmCustEml(JSPUtil.getParameter(request, prefix + "vgm_cust_eml", ""));
		setVgmCustPhnNo(JSPUtil.getParameter(request, prefix + "vgm_cust_phn_no", ""));
		setVgmCustAddr(JSPUtil.getParameter(request, prefix + "vgm_cust_addr", ""));
		setCntrStwgPsnCtnt(JSPUtil.getParameter(request, prefix + "cntr_stwg_psn_ctnt", ""));
		
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
			String[] mgsCase = (JSPUtil.getParameter(request, prefix	+ "mgs_case", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] vessel = (JSPUtil.getParameter(request, prefix	+ "vessel", length));
			String[] bkgCount = (JSPUtil.getParameter(request, prefix	+ "bkg_count", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] dmgFlag = (JSPUtil.getParameter(request, prefix	+ "dmg_flag", length));
			String[] dmgFlgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_flg_dt", length));
			String[] dmgUnflgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_unflg_dt", length));
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
			String[] destNm = (JSPUtil.getParameter(request, prefix	+ "dest_nm", length));
			String[] destSte = (JSPUtil.getParameter(request, prefix	+ "dest_ste", length));
			String[] mvmtStatus = (JSPUtil.getParameter(request, prefix	+ "mvmt_status", length));
			String[] pickupNo = (JSPUtil.getParameter(request, prefix	+ "pickup_no", length));
			String[] nBkgNoFlg = (JSPUtil.getParameter(request, prefix	+ "n_bkg_no_flg", length));
			String[] hangerTag = (JSPUtil.getParameter(request, prefix	+ "hanger_tag", length));
			String[] ediBkgNo = (JSPUtil.getParameter(request, prefix	+ "edi_bkg_no", length));
			String[] sightCd = (JSPUtil.getParameter(request, prefix	+ "sight_cd", length));
			String[] stowage = (JSPUtil.getParameter(request, prefix	+ "stowage", length));
			String[] ediCrrNo = (JSPUtil.getParameter(request, prefix	+ "edi_crr_no", length));
			String[] trspDocNo = (JSPUtil.getParameter(request, prefix	+ "trsp_doc_no", length));
			String[] mtyRepoNo = (JSPUtil.getParameter(request, prefix	+ "mty_repo_no", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			String[] tirNo = (JSPUtil.getParameter(request, prefix	+ "tir_no", length));
			String[] ediVvdCd = (JSPUtil.getParameter(request, prefix	+ "edi_vvd_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] oscaBkgFlg = (JSPUtil.getParameter(request, prefix	+ "osca_bkg_flg", length));
			String[] ediMtyEqRepoRefNo = (JSPUtil.getParameter(request, prefix	+ "edi_mty_eq_repo_ref_no", length));
			String[] vgmDocIdNo = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_id_no", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmEdiWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_edi_wgt_ut_cd", length));
			String[] vgmDocTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_tp_cd", length));
			String[] vgmDtTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_dt_tp_cd", length));
			String[] vgmHndlDt = (JSPUtil.getParameter(request, prefix	+ "vgm_hndl_dt", length));
			String[] vgmCustCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_tp_cd", length));
			String[] vgmCustCntcNm = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_nm", length));
			String[] vgmCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_fax_no", length));
			String[] vgmCustEml = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_eml", length));
			String[] vgmCustPhnNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_phn_no", length));
			String[] vgmCustAddr = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_addr", length));
			String[] cntrStwgPsnCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_psn_ctnt", length));
			
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
				if (mgsCase[i] != null)
					model.setMgsCase(mgsCase[i]);
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
				if (dmgFlgDt[i] != null)
					model.setDmgFlgDt(dmgFlgDt[i]);
				if (dmgUnflgDt[i] != null)
					model.setDmgUnflgDt(dmgUnflgDt[i]);
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
				if (destNm[i] != null)
					model.setDestNm(destNm[i]);
				if (destSte[i] != null)
					model.setDestSte(destSte[i]);
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
				if (ediCrrNo[i] != null)
					model.setEdiCrrNo(ediCrrNo[i]);
				if (trspDocNo[i] != null)
					model.setTrspDocNo(trspDocNo[i]);
				if (mtyRepoNo[i] != null)
					model.setMtyRepoNo(mtyRepoNo[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				if (tirNo[i] != null)
					model.setTirNo(tirNo[i]);
				if (ediVvdCd[i] != null)
					model.setEdiVvdCd(ediVvdCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (oscaBkgFlg[i] != null)
					model.setOscaBkgFlg(oscaBkgFlg[i]);
				if (ediMtyEqRepoRefNo[i] != null)
					model.setEdiMtyEqRepoRefNo(ediMtyEqRepoRefNo[i]);
				if (vgmDocIdNo[i] != null)
					model.setVgmDocIdNo(vgmDocIdNo[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmEdiWgtUtCd[i] != null)
					model.setVgmEdiWgtUtCd(vgmEdiWgtUtCd[i]);
				if (vgmDocTpCd[i] != null)
					model.setVgmDocTpCd(vgmDocTpCd[i]);
				if (vgmDtTpCd[i] != null)
					model.setVgmDtTpCd(vgmDtTpCd[i]);
				if (vgmHndlDt[i] != null)
					model.setVgmHndlDt(vgmHndlDt[i]);
				if (vgmCustCntcTpCd[i] != null)
					model.setVgmCustCntcTpCd(vgmCustCntcTpCd[i]);
				if (vgmCustCntcNm[i] != null)
					model.setVgmCustCntcNm(vgmCustCntcNm[i]);
				if (vgmCustFaxNo[i] != null)
					model.setVgmCustFaxNo(vgmCustFaxNo[i]);
				if (vgmCustEml[i] != null)
					model.setVgmCustEml(vgmCustEml[i]);
				if (vgmCustPhnNo[i] != null)
					model.setVgmCustPhnNo(vgmCustPhnNo[i]);
				if (vgmCustAddr[i] != null)
					model.setVgmCustAddr(vgmCustAddr[i]);
				if (cntrStwgPsnCtnt[i] != null)
					model.setCntrStwgPsnCtnt(cntrStwgPsnCtnt[i]);
				
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
		this.mgsCase = this.mgsCase .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vessel = this.vessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCount = this.bkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlag = this.dmgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt = this.dmgFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt = this.dmgUnflgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.destNm = this.destNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destSte = this.destSte .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStatus = this.mvmtStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickupNo = this.pickupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nBkgNoFlg = this.nBkgNoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hangerTag = this.hangerTag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediBkgNo = this.ediBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sightCd = this.sightCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stowage = this.stowage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCrrNo = this.ediCrrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo = this.trspDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoNo = this.mtyRepoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tirNo = this.tirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVvdCd = this.ediVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oscaBkgFlg = this.oscaBkgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMtyEqRepoRefNo = this.ediMtyEqRepoRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocIdNo = this.vgmDocIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmEdiWgtUtCd = this.vgmEdiWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocTpCd = this.vgmDocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtTpCd = this.vgmDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmHndlDt = this.vgmHndlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcTpCd = this.vgmCustCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcNm = this.vgmCustCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustFaxNo = this.vgmCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustEml = this.vgmCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustPhnNo = this.vgmCustPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustAddr = this.vgmCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgPsnCtnt = this.cntrStwgPsnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
