/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24BlinfoVO.java
*@FileTitle : Eur24BlinfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2015.07.29 이종길 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이종길
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24BlinfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlinfoVO> models = new ArrayList<Eur24BlinfoVO>();
	
	/* Column Info */
	private String declareDate = null;
	/* Column Info */
	private String polFullname = null;
	/* Column Info */
	private String customsStatusCd = null;
	/* Column Info */
	private String vslName = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String blpkgu = null;
	/* Column Info */
	private String bldel = null;
	/* Column Info */
	private String transNation = null;
	/* Column Info */
	private String mvmtRefNo = null;
	/* Column Info */
	private String nextOfcCd = null;
	/* Column Info */
	private String podFullname = null;
	/* Column Info */
	private String blnbr = null;
	/* Column Info */
	private String declareLocName = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String unloadLocName = null;
	/* Column Info */
	private String svcEnsYn = null;
	/* Column Info */
	private String blpod = null;
	/* Column Info */
	private String itSeqN = null;
	/* Column Info */
	private String podOfcCd = null;
	/* Column Info */
	private String specialRemarks = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String blTransIdentity = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String commodity = null;
	/* Column Info */
	private String ctTel = null;
	/* Column Info */
	private String ctFax = null;
	/* Column Info */
	private String unloadLocEtaHis = null;
	/* Column Info */
	private String blmeau = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String unloadLocEta = null;
	/* Column Info */
	private String loadOfcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ctEmail = null;
	/* Column Info */
	private String blpol = null;
	/* Column Info */
	private String aeoStatus = null;
	/* Column Info */
	private String loadLocEtd = null;
	/* Column Info */
	private String processType = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String b = null;
	/* Column Info */
	private String c = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String mrn = null;
	/* Column Info */
	private String ctPosition = null;
	/* Column Info */
	private String nextLocEta = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String originalDate = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String consignPlace = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String declLocCd = null;
	/* Column Info */
	private String transDocNo = null;
	/* Column Info */
	private String prevLocCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String partShipment = null;
	/* Column Info */
	private String prnSeq = null;
	/* Column Info */
	private String declareLoc = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String svcDrYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsDeclDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blmea = null;
	/* Column Info */
	private String prn = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String delFullname = null;
	/* Column Info */
	private String processInfo = null;
	/* Column Info */
	private String descs = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String loadLocName = null;
	/* Column Info */
	private String transIdentity = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String trspDocNo = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String loadLocCd = null;
	/* Column Info */
	private String markno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itFileSeq = null;
	/* Column Info */
	private String itSeq = null;
	/* Column Info */
	private String trsmVal = null;
	/* Column Info */
	private String nextLocName = null;
	/* Column Info */
	private String paymentCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String unloadOfcCd = null;
	/* Column Info */
	private String blEntryLoc = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String blpkg = null;
	/* Column Info */
	private String customsRef = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String unloadLocCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ctName = null;
	/* Column Info */
	private String msgIdCd = null;
	/* Column Info */
	private String nextLocCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String svcAnYn = null;
	/* Column Info */
	private String blTransNation = null;
	/* Column Info */
	private String transDocName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public Eur24BlinfoVO() {}

	public Eur24BlinfoVO(String ibflag, String pagerows, String aeoStatus, String b, String bkgPodCd, String bkgPolCd, String blNo, String blTransIdentity, String blTransNation, String bldel, String blmea, String blmeau, String blnbr, String blpkg, String blpkgu, String blpod, String blpol, String c, String cmdtCd, String commodity, String consignPlace, String creDt, String creUsrId, String cstmsDeclDt, String cstmsPortCd, String customsStatusCd, String declLocCd, String declareDate, String declareLoc, String declareLocName, String delCd, String delFullname, String delNm, String descs, String itFileSeq, String itSeq, String itSeqN, String loadLocCd, String loadLocEtd, String loadLocName, String loadOfcCd, String markno, String measQty, String measUtCd, String mrn, String msgId, String msgIdCd, String nextLocCd, String nextLocEta, String nextLocName, String nextOfcCd, String partShipment, String paymentCd, String pckQty, String pckTpCd, String podCd, String podFullname, String podOfcCd, String podNm, String polCd, String polFullname, String polNm, String prevLocCd, String prn, String prnSeq, String processInfo, String processType, String skdDirCd, String skdVoyNo, String specialRemarks, String transDocName, String transDocNo, String transIdentity, String transNation, String trspDocNo, String unloadLocCd, String unloadLocEta, String unloadLocName, String unloadOfcCd, String updDt, String updUsrId, String vslCd, String vslName, String svcEnsYn, String svcAnYn, String svcDrYn, String ctName, String ctPosition, String ctEmail, String ctTel, String ctFax, String actWgt, String wgtUtCd, String unloadLocEtaHis, String originalDate, String customsRef, String mvmtRefNo, String blEntryLoc, String trsmVal, String custToOrdFlg) {
		this.declareDate = declareDate;
		this.polFullname = polFullname;
		this.customsStatusCd = customsStatusCd;
		this.vslName = vslName;
		this.updUsrId = updUsrId;
		this.blpkgu = blpkgu;
		this.bldel = bldel;
		this.transNation = transNation;
		this.mvmtRefNo = mvmtRefNo;
		this.nextOfcCd = nextOfcCd;
		this.podFullname = podFullname;
		this.blnbr = blnbr;
		this.declareLocName = declareLocName;
		this.bkgPodCd = bkgPodCd;
		this.unloadLocName = unloadLocName;
		this.svcEnsYn = svcEnsYn;
		this.blpod = blpod;
		this.itSeqN = itSeqN;
		this.podOfcCd = podOfcCd;
		this.specialRemarks = specialRemarks;
		this.bkgPolCd = bkgPolCd;
		this.blTransIdentity = blTransIdentity;
		this.updDt = updDt;
		this.pckTpCd = pckTpCd;
		this.commodity = commodity;
		this.ctTel = ctTel;
		this.ctFax = ctFax;
		this.unloadLocEtaHis = unloadLocEtaHis;
		this.blmeau = blmeau;
		this.msgId = msgId;
		this.unloadLocEta = unloadLocEta;
		this.loadOfcCd = loadOfcCd;
		this.creUsrId = creUsrId;
		this.ctEmail = ctEmail;
		this.blpol = blpol;
		this.aeoStatus = aeoStatus;
		this.loadLocEtd = loadLocEtd;
		this.processType = processType;
		this.measQty = measQty;
		this.b = b;
		this.c = c;
		this.cmdtCd = cmdtCd;
		this.mrn = mrn;
		this.ctPosition = ctPosition;
		this.nextLocEta = nextLocEta;
		this.wgtUtCd = wgtUtCd;
		this.originalDate = originalDate;
		this.delCd = delCd;
		this.consignPlace = consignPlace;
		this.pckQty = pckQty;
		this.declLocCd = declLocCd;
		this.transDocNo = transDocNo;
		this.prevLocCd = prevLocCd;
		this.blNo = blNo;
		this.partShipment = partShipment;
		this.prnSeq = prnSeq;
		this.declareLoc = declareLoc;
		this.delNm = delNm;
		this.actWgt = actWgt;
		this.cstmsPortCd = cstmsPortCd;
		this.svcDrYn = svcDrYn;
		this.pagerows = pagerows;
		this.cstmsDeclDt = cstmsDeclDt;
		this.vslCd = vslCd;
		this.blmea = blmea;
		this.prn = prn;
		this.creDt = creDt;
		this.delFullname = delFullname;
		this.processInfo = processInfo;
		this.descs = descs;
		this.polNm = polNm;
		this.loadLocName = loadLocName;
		this.transIdentity = transIdentity;
		this.podNm = podNm;
		this.trspDocNo = trspDocNo;
		this.custToOrdFlg = custToOrdFlg;
		this.loadLocCd = loadLocCd;
		this.markno = markno;
		this.ibflag = ibflag;
		this.itFileSeq = itFileSeq;
		this.itSeq = itSeq;
		this.trsmVal = trsmVal;
		this.nextLocName = nextLocName;
		this.paymentCd = paymentCd;
		this.polCd = polCd;
		this.unloadOfcCd = unloadOfcCd;
		this.blEntryLoc = blEntryLoc;
		this.skdDirCd = skdDirCd;
		this.blpkg = blpkg;
		this.customsRef = customsRef;
		this.podCd = podCd;
		this.unloadLocCd = unloadLocCd;
		this.skdVoyNo = skdVoyNo;
		this.ctName = ctName;
		this.msgIdCd = msgIdCd;
		this.nextLocCd = nextLocCd;
		this.measUtCd = measUtCd;
		this.svcAnYn = svcAnYn;
		this.blTransNation = blTransNation;
		this.transDocName = transDocName;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("declare_date", getDeclareDate());
		this.hashColumns.put("pol_fullname", getPolFullname());
		this.hashColumns.put("customs_status_cd", getCustomsStatusCd());
		this.hashColumns.put("vsl_name", getVslName());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("blpkgu", getBlpkgu());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("trans_nation", getTransNation());
		this.hashColumns.put("mvmt_ref_no", getMvmtRefNo());
		this.hashColumns.put("next_ofc_cd", getNextOfcCd());
		this.hashColumns.put("pod_fullname", getPodFullname());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("declare_loc_name", getDeclareLocName());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("unload_loc_name", getUnloadLocName());
		this.hashColumns.put("svc_ens_yn", getSvcEnsYn());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("it_seq_n", getItSeqN());
		this.hashColumns.put("pod_ofc_cd", getPodOfcCd());
		this.hashColumns.put("special_remarks", getSpecialRemarks());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		this.hashColumns.put("bl_trans_identity", getBlTransIdentity());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("commodity", getCommodity());
		this.hashColumns.put("ct_tel", getCtTel());
		this.hashColumns.put("ct_fax", getCtFax());
		this.hashColumns.put("unload_loc_eta_his", getUnloadLocEtaHis());
		this.hashColumns.put("blmeau", getBlmeau());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("unload_loc_eta", getUnloadLocEta());
		this.hashColumns.put("load_ofc_cd", getLoadOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ct_email", getCtEmail());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("aeo_status", getAeoStatus());
		this.hashColumns.put("load_loc_etd", getLoadLocEtd());
		this.hashColumns.put("process_type", getProcessType());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("b", getB());
		this.hashColumns.put("c", getC());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("mrn", getMrn());
		this.hashColumns.put("ct_position", getCtPosition());
		this.hashColumns.put("next_loc_eta", getNextLocEta());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("original_date", getOriginalDate());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("consign_place", getConsignPlace());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("decl_loc_cd", getDeclLocCd());
		this.hashColumns.put("trans_doc_no", getTransDocNo());
		this.hashColumns.put("prev_loc_cd", getPrevLocCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("part_shipment", getPartShipment());
		this.hashColumns.put("prn_seq", getPrnSeq());
		this.hashColumns.put("declare_loc", getDeclareLoc());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("svc_dr_yn", getSvcDrYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_decl_dt", getCstmsDeclDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("blmea", getBlmea());
		this.hashColumns.put("prn", getPrn());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("del_fullname", getDelFullname());
		this.hashColumns.put("process_info", getProcessInfo());
		this.hashColumns.put("descs", getDescs());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("load_loc_name", getLoadLocName());
		this.hashColumns.put("trans_identity", getTransIdentity());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("load_loc_cd", getLoadLocCd());
		this.hashColumns.put("markno", getMarkno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("it_file_seq", getItFileSeq());
		this.hashColumns.put("it_seq", getItSeq());
		this.hashColumns.put("trsm_val", getTrsmVal());
		this.hashColumns.put("next_loc_name", getNextLocName());
		this.hashColumns.put("payment_cd", getPaymentCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("unload_ofc_cd", getUnloadOfcCd());
		this.hashColumns.put("bl_entry_loc", getBlEntryLoc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("blpkg", getBlpkg());
		this.hashColumns.put("customs_ref", getCustomsRef());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("unload_loc_cd", getUnloadLocCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("ct_name", getCtName());
		this.hashColumns.put("msg_id_cd", getMsgIdCd());
		this.hashColumns.put("next_loc_cd", getNextLocCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("svc_an_yn", getSvcAnYn());
		this.hashColumns.put("bl_trans_nation", getBlTransNation());
		this.hashColumns.put("trans_doc_name", getTransDocName());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("declare_date", "declareDate");
		this.hashFields.put("pol_fullname", "polFullname");
		this.hashFields.put("customs_status_cd", "customsStatusCd");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("blpkgu", "blpkgu");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("trans_nation", "transNation");
		this.hashFields.put("mvmt_ref_no", "mvmtRefNo");
		this.hashFields.put("next_ofc_cd", "nextOfcCd");
		this.hashFields.put("pod_fullname", "podFullname");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("declare_loc_name", "declareLocName");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("unload_loc_name", "unloadLocName");
		this.hashFields.put("svc_ens_yn", "svcEnsYn");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("it_seq_n", "itSeqN");
		this.hashFields.put("pod_ofc_cd", "podOfcCd");
		this.hashFields.put("special_remarks", "specialRemarks");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("bl_trans_identity", "blTransIdentity");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("commodity", "commodity");
		this.hashFields.put("ct_tel", "ctTel");
		this.hashFields.put("ct_fax", "ctFax");
		this.hashFields.put("unload_loc_eta_his", "unloadLocEtaHis");
		this.hashFields.put("blmeau", "blmeau");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("unload_loc_eta", "unloadLocEta");
		this.hashFields.put("load_ofc_cd", "loadOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ct_email", "ctEmail");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("aeo_status", "aeoStatus");
		this.hashFields.put("load_loc_etd", "loadLocEtd");
		this.hashFields.put("process_type", "processType");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("b", "b");
		this.hashFields.put("c", "c");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("mrn", "mrn");
		this.hashFields.put("ct_position", "ctPosition");
		this.hashFields.put("next_loc_eta", "nextLocEta");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("original_date", "originalDate");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("consign_place", "consignPlace");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("decl_loc_cd", "declLocCd");
		this.hashFields.put("trans_doc_no", "transDocNo");
		this.hashFields.put("prev_loc_cd", "prevLocCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("part_shipment", "partShipment");
		this.hashFields.put("prn_seq", "prnSeq");
		this.hashFields.put("declare_loc", "declareLoc");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("svc_dr_yn", "svcDrYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_decl_dt", "cstmsDeclDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("blmea", "blmea");
		this.hashFields.put("prn", "prn");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("del_fullname", "delFullname");
		this.hashFields.put("process_info", "processInfo");
		this.hashFields.put("descs", "descs");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("load_loc_name", "loadLocName");
		this.hashFields.put("trans_identity", "transIdentity");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("load_loc_cd", "loadLocCd");
		this.hashFields.put("markno", "markno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("it_file_seq", "itFileSeq");
		this.hashFields.put("it_seq", "itSeq");
		this.hashFields.put("trsm_val", "trsmVal");
		this.hashFields.put("next_loc_name", "nextLocName");
		this.hashFields.put("payment_cd", "paymentCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("unload_ofc_cd", "unloadOfcCd");
		this.hashFields.put("bl_entry_loc", "blEntryLoc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("blpkg", "blpkg");
		this.hashFields.put("customs_ref", "customsRef");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("unload_loc_cd", "unloadLocCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("ct_name", "ctName");
		this.hashFields.put("msg_id_cd", "msgIdCd");
		this.hashFields.put("next_loc_cd", "nextLocCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("svc_an_yn", "svcAnYn");
		this.hashFields.put("bl_trans_nation", "blTransNation");
		this.hashFields.put("trans_doc_name", "transDocName");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return declareDate
	 */
	public String getDeclareDate() {
		return this.declareDate;
	}
	
	/**
	 * Column Info
	 * @return polFullname
	 */
	public String getPolFullname() {
		return this.polFullname;
	}
	
	/**
	 * Column Info
	 * @return customsStatusCd
	 */
	public String getCustomsStatusCd() {
		return this.customsStatusCd;
	}
	
	/**
	 * Column Info
	 * @return vslName
	 */
	public String getVslName() {
		return this.vslName;
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
	 * @return blpkgu
	 */
	public String getBlpkgu() {
		return this.blpkgu;
	}
	
	/**
	 * Column Info
	 * @return bldel
	 */
	public String getBldel() {
		return this.bldel;
	}
	
	/**
	 * Column Info
	 * @return transNation
	 */
	public String getTransNation() {
		return this.transNation;
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
	 * @return nextOfcCd
	 */
	public String getNextOfcCd() {
		return this.nextOfcCd;
	}
	
	/**
	 * Column Info
	 * @return podFullname
	 */
	public String getPodFullname() {
		return this.podFullname;
	}
	
	/**
	 * Column Info
	 * @return blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 * Column Info
	 * @return declareLocName
	 */
	public String getDeclareLocName() {
		return this.declareLocName;
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
	 * @return unloadLocName
	 */
	public String getUnloadLocName() {
		return this.unloadLocName;
	}
	
	/**
	 * Column Info
	 * @return svcEnsYn
	 */
	public String getSvcEnsYn() {
		return this.svcEnsYn;
	}
	
	/**
	 * Column Info
	 * @return blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 * Column Info
	 * @return itSeqN
	 */
	public String getItSeqN() {
		return this.itSeqN;
	}
	
	/**
	 * Column Info
	 * @return podOfcCd
	 */
	public String getPodOfcCd() {
		return this.podOfcCd;
	}
	
	/**
	 * Column Info
	 * @return specialRemarks
	 */
	public String getSpecialRemarks() {
		return this.specialRemarks;
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
	 * @return blTransIdentity
	 */
	public String getBlTransIdentity() {
		return this.blTransIdentity;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return commodity
	 */
	public String getCommodity() {
		return this.commodity;
	}
	
	/**
	 * Column Info
	 * @return ctTel
	 */
	public String getCtTel() {
		return this.ctTel;
	}
	
	/**
	 * Column Info
	 * @return ctFax
	 */
	public String getCtFax() {
		return this.ctFax;
	}
	
	/**
	 * Column Info
	 * @return unloadLocEtaHis
	 */
	public String getUnloadLocEtaHis() {
		return this.unloadLocEtaHis;
	}
	
	/**
	 * Column Info
	 * @return blmeau
	 */
	public String getBlmeau() {
		return this.blmeau;
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
	 * @return unloadLocEta
	 */
	public String getUnloadLocEta() {
		return this.unloadLocEta;
	}
	
	/**
	 * Column Info
	 * @return loadOfcCd
	 */
	public String getLoadOfcCd() {
		return this.loadOfcCd;
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
	 * @return ctEmail
	 */
	public String getCtEmail() {
		return this.ctEmail;
	}
	
	/**
	 * Column Info
	 * @return blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 * Column Info
	 * @return aeoStatus
	 */
	public String getAeoStatus() {
		return this.aeoStatus;
	}
	
	/**
	 * Column Info
	 * @return loadLocEtd
	 */
	public String getLoadLocEtd() {
		return this.loadLocEtd;
	}
	
	/**
	 * Column Info
	 * @return processType
	 */
	public String getProcessType() {
		return this.processType;
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
	 * @return b
	 */
	public String getB() {
		return this.b;
	}
	
	/**
	 * Column Info
	 * @return c
	 */
	public String getC() {
		return this.c;
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
	 * @return mrn
	 */
	public String getMrn() {
		return this.mrn;
	}
	
	/**
	 * Column Info
	 * @return ctPosition
	 */
	public String getCtPosition() {
		return this.ctPosition;
	}
	
	/**
	 * Column Info
	 * @return nextLocEta
	 */
	public String getNextLocEta() {
		return this.nextLocEta;
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
	 * @return originalDate
	 */
	public String getOriginalDate() {
		return this.originalDate;
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
	 * @return consignPlace
	 */
	public String getConsignPlace() {
		return this.consignPlace;
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
	 * @return declLocCd
	 */
	public String getDeclLocCd() {
		return this.declLocCd;
	}
	
	/**
	 * Column Info
	 * @return transDocNo
	 */
	public String getTransDocNo() {
		return this.transDocNo;
	}
	
	/**
	 * Column Info
	 * @return prevLocCd
	 */
	public String getPrevLocCd() {
		return this.prevLocCd;
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
	 * @return partShipment
	 */
	public String getPartShipment() {
		return this.partShipment;
	}
	
	/**
	 * Column Info
	 * @return prnSeq
	 */
	public String getPrnSeq() {
		return this.prnSeq;
	}
	
	/**
	 * Column Info
	 * @return declareLoc
	 */
	public String getDeclareLoc() {
		return this.declareLoc;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return svcDrYn
	 */
	public String getSvcDrYn() {
		return this.svcDrYn;
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
	 * @return cstmsDeclDt
	 */
	public String getCstmsDeclDt() {
		return this.cstmsDeclDt;
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
	 * @return blmea
	 */
	public String getBlmea() {
		return this.blmea;
	}
	
	/**
	 * Column Info
	 * @return prn
	 */
	public String getPrn() {
		return this.prn;
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
	 * @return delFullname
	 */
	public String getDelFullname() {
		return this.delFullname;
	}
	
	/**
	 * Column Info
	 * @return processInfo
	 */
	public String getProcessInfo() {
		return this.processInfo;
	}
	
	/**
	 * Column Info
	 * @return descs
	 */
	public String getDescs() {
		return this.descs;
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
	 * @return loadLocName
	 */
	public String getLoadLocName() {
		return this.loadLocName;
	}
	
	/**
	 * Column Info
	 * @return transIdentity
	 */
	public String getTransIdentity() {
		return this.transIdentity;
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
	 * @return trspDocNo
	 */
	public String getTrspDocNo() {
		return this.trspDocNo;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return loadLocCd
	 */
	public String getLoadLocCd() {
		return this.loadLocCd;
	}
	
	/**
	 * Column Info
	 * @return markno
	 */
	public String getMarkno() {
		return this.markno;
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
	 * @return itFileSeq
	 */
	public String getItFileSeq() {
		return this.itFileSeq;
	}
	
	/**
	 * Column Info
	 * @return itSeq
	 */
	public String getItSeq() {
		return this.itSeq;
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
	 * @return nextLocName
	 */
	public String getNextLocName() {
		return this.nextLocName;
	}
	
	/**
	 * Column Info
	 * @return paymentCd
	 */
	public String getPaymentCd() {
		return this.paymentCd;
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
	 * @return unloadOfcCd
	 */
	public String getUnloadOfcCd() {
		return this.unloadOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blEntryLoc
	 */
	public String getBlEntryLoc() {
		return this.blEntryLoc;
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
	 * @return blpkg
	 */
	public String getBlpkg() {
		return this.blpkg;
	}
	
	/**
	 * Column Info
	 * @return customsRef
	 */
	public String getCustomsRef() {
		return this.customsRef;
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
	 * @return unloadLocCd
	 */
	public String getUnloadLocCd() {
		return this.unloadLocCd;
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
	 * @return ctName
	 */
	public String getCtName() {
		return this.ctName;
	}
	
	/**
	 * Column Info
	 * @return msgIdCd
	 */
	public String getMsgIdCd() {
		return this.msgIdCd;
	}
	
	/**
	 * Column Info
	 * @return nextLocCd
	 */
	public String getNextLocCd() {
		return this.nextLocCd;
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
	 * @return svcAnYn
	 */
	public String getSvcAnYn() {
		return this.svcAnYn;
	}
	
	/**
	 * Column Info
	 * @return blTransNation
	 */
	public String getBlTransNation() {
		return this.blTransNation;
	}
	
	/**
	 * Column Info
	 * @return transDocName
	 */
	public String getTransDocName() {
		return this.transDocName;
	}
	

	/**
	 * Column Info
	 * @param declareDate
	 */
	public void setDeclareDate(String declareDate) {
		this.declareDate = declareDate;
	}
	
	/**
	 * Column Info
	 * @param polFullname
	 */
	public void setPolFullname(String polFullname) {
		this.polFullname = polFullname;
	}
	
	/**
	 * Column Info
	 * @param customsStatusCd
	 */
	public void setCustomsStatusCd(String customsStatusCd) {
		this.customsStatusCd = customsStatusCd;
	}
	
	/**
	 * Column Info
	 * @param vslName
	 */
	public void setVslName(String vslName) {
		this.vslName = vslName;
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
	 * @param blpkgu
	 */
	public void setBlpkgu(String blpkgu) {
		this.blpkgu = blpkgu;
	}
	
	/**
	 * Column Info
	 * @param bldel
	 */
	public void setBldel(String bldel) {
		this.bldel = bldel;
	}
	
	/**
	 * Column Info
	 * @param transNation
	 */
	public void setTransNation(String transNation) {
		this.transNation = transNation;
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
	 * @param nextOfcCd
	 */
	public void setNextOfcCd(String nextOfcCd) {
		this.nextOfcCd = nextOfcCd;
	}
	
	/**
	 * Column Info
	 * @param podFullname
	 */
	public void setPodFullname(String podFullname) {
		this.podFullname = podFullname;
	}
	
	/**
	 * Column Info
	 * @param blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * Column Info
	 * @param declareLocName
	 */
	public void setDeclareLocName(String declareLocName) {
		this.declareLocName = declareLocName;
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
	 * @param unloadLocName
	 */
	public void setUnloadLocName(String unloadLocName) {
		this.unloadLocName = unloadLocName;
	}
	
	/**
	 * Column Info
	 * @param svcEnsYn
	 */
	public void setSvcEnsYn(String svcEnsYn) {
		this.svcEnsYn = svcEnsYn;
	}
	
	/**
	 * Column Info
	 * @param blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * Column Info
	 * @param itSeqN
	 */
	public void setItSeqN(String itSeqN) {
		this.itSeqN = itSeqN;
	}
	
	/**
	 * Column Info
	 * @param podOfcCd
	 */
	public void setPodOfcCd(String podOfcCd) {
		this.podOfcCd = podOfcCd;
	}
	
	/**
	 * Column Info
	 * @param specialRemarks
	 */
	public void setSpecialRemarks(String specialRemarks) {
		this.specialRemarks = specialRemarks;
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
	 * @param blTransIdentity
	 */
	public void setBlTransIdentity(String blTransIdentity) {
		this.blTransIdentity = blTransIdentity;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param commodity
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	
	/**
	 * Column Info
	 * @param ctTel
	 */
	public void setCtTel(String ctTel) {
		this.ctTel = ctTel;
	}
	
	/**
	 * Column Info
	 * @param ctFax
	 */
	public void setCtFax(String ctFax) {
		this.ctFax = ctFax;
	}
	
	/**
	 * Column Info
	 * @param unloadLocEtaHis
	 */
	public void setUnloadLocEtaHis(String unloadLocEtaHis) {
		this.unloadLocEtaHis = unloadLocEtaHis;
	}
	
	/**
	 * Column Info
	 * @param blmeau
	 */
	public void setBlmeau(String blmeau) {
		this.blmeau = blmeau;
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
	 * @param unloadLocEta
	 */
	public void setUnloadLocEta(String unloadLocEta) {
		this.unloadLocEta = unloadLocEta;
	}
	
	/**
	 * Column Info
	 * @param loadOfcCd
	 */
	public void setLoadOfcCd(String loadOfcCd) {
		this.loadOfcCd = loadOfcCd;
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
	 * @param ctEmail
	 */
	public void setCtEmail(String ctEmail) {
		this.ctEmail = ctEmail;
	}
	
	/**
	 * Column Info
	 * @param blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * Column Info
	 * @param aeoStatus
	 */
	public void setAeoStatus(String aeoStatus) {
		this.aeoStatus = aeoStatus;
	}
	
	/**
	 * Column Info
	 * @param loadLocEtd
	 */
	public void setLoadLocEtd(String loadLocEtd) {
		this.loadLocEtd = loadLocEtd;
	}
	
	/**
	 * Column Info
	 * @param processType
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
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
	 * @param b
	 */
	public void setB(String b) {
		this.b = b;
	}
	
	/**
	 * Column Info
	 * @param c
	 */
	public void setC(String c) {
		this.c = c;
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
	 * @param mrn
	 */
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	
	/**
	 * Column Info
	 * @param ctPosition
	 */
	public void setCtPosition(String ctPosition) {
		this.ctPosition = ctPosition;
	}
	
	/**
	 * Column Info
	 * @param nextLocEta
	 */
	public void setNextLocEta(String nextLocEta) {
		this.nextLocEta = nextLocEta;
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
	 * @param originalDate
	 */
	public void setOriginalDate(String originalDate) {
		this.originalDate = originalDate;
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
	 * @param consignPlace
	 */
	public void setConsignPlace(String consignPlace) {
		this.consignPlace = consignPlace;
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
	 * @param declLocCd
	 */
	public void setDeclLocCd(String declLocCd) {
		this.declLocCd = declLocCd;
	}
	
	/**
	 * Column Info
	 * @param transDocNo
	 */
	public void setTransDocNo(String transDocNo) {
		this.transDocNo = transDocNo;
	}
	
	/**
	 * Column Info
	 * @param prevLocCd
	 */
	public void setPrevLocCd(String prevLocCd) {
		this.prevLocCd = prevLocCd;
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
	 * @param partShipment
	 */
	public void setPartShipment(String partShipment) {
		this.partShipment = partShipment;
	}
	
	/**
	 * Column Info
	 * @param prnSeq
	 */
	public void setPrnSeq(String prnSeq) {
		this.prnSeq = prnSeq;
	}
	
	/**
	 * Column Info
	 * @param declareLoc
	 */
	public void setDeclareLoc(String declareLoc) {
		this.declareLoc = declareLoc;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param svcDrYn
	 */
	public void setSvcDrYn(String svcDrYn) {
		this.svcDrYn = svcDrYn;
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
	 * @param cstmsDeclDt
	 */
	public void setCstmsDeclDt(String cstmsDeclDt) {
		this.cstmsDeclDt = cstmsDeclDt;
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
	 * @param blmea
	 */
	public void setBlmea(String blmea) {
		this.blmea = blmea;
	}
	
	/**
	 * Column Info
	 * @param prn
	 */
	public void setPrn(String prn) {
		this.prn = prn;
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
	 * @param delFullname
	 */
	public void setDelFullname(String delFullname) {
		this.delFullname = delFullname;
	}
	
	/**
	 * Column Info
	 * @param processInfo
	 */
	public void setProcessInfo(String processInfo) {
		this.processInfo = processInfo;
	}
	
	/**
	 * Column Info
	 * @param descs
	 */
	public void setDescs(String descs) {
		this.descs = descs;
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
	 * @param loadLocName
	 */
	public void setLoadLocName(String loadLocName) {
		this.loadLocName = loadLocName;
	}
	
	/**
	 * Column Info
	 * @param transIdentity
	 */
	public void setTransIdentity(String transIdentity) {
		this.transIdentity = transIdentity;
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
	 * @param trspDocNo
	 */
	public void setTrspDocNo(String trspDocNo) {
		this.trspDocNo = trspDocNo;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param loadLocCd
	 */
	public void setLoadLocCd(String loadLocCd) {
		this.loadLocCd = loadLocCd;
	}
	
	/**
	 * Column Info
	 * @param markno
	 */
	public void setMarkno(String markno) {
		this.markno = markno;
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
	 * @param itFileSeq
	 */
	public void setItFileSeq(String itFileSeq) {
		this.itFileSeq = itFileSeq;
	}
	
	/**
	 * Column Info
	 * @param itSeq
	 */
	public void setItSeq(String itSeq) {
		this.itSeq = itSeq;
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
	 * @param nextLocName
	 */
	public void setNextLocName(String nextLocName) {
		this.nextLocName = nextLocName;
	}
	
	/**
	 * Column Info
	 * @param paymentCd
	 */
	public void setPaymentCd(String paymentCd) {
		this.paymentCd = paymentCd;
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
	 * @param unloadOfcCd
	 */
	public void setUnloadOfcCd(String unloadOfcCd) {
		this.unloadOfcCd = unloadOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blEntryLoc
	 */
	public void setBlEntryLoc(String blEntryLoc) {
		this.blEntryLoc = blEntryLoc;
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
	 * @param blpkg
	 */
	public void setBlpkg(String blpkg) {
		this.blpkg = blpkg;
	}
	
	/**
	 * Column Info
	 * @param customsRef
	 */
	public void setCustomsRef(String customsRef) {
		this.customsRef = customsRef;
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
	 * @param unloadLocCd
	 */
	public void setUnloadLocCd(String unloadLocCd) {
		this.unloadLocCd = unloadLocCd;
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
	 * @param ctName
	 */
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	
	/**
	 * Column Info
	 * @param msgIdCd
	 */
	public void setMsgIdCd(String msgIdCd) {
		this.msgIdCd = msgIdCd;
	}
	
	/**
	 * Column Info
	 * @param nextLocCd
	 */
	public void setNextLocCd(String nextLocCd) {
		this.nextLocCd = nextLocCd;
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
	 * @param svcAnYn
	 */
	public void setSvcAnYn(String svcAnYn) {
		this.svcAnYn = svcAnYn;
	}
	
	/**
	 * Column Info
	 * @param blTransNation
	 */
	public void setBlTransNation(String blTransNation) {
		this.blTransNation = blTransNation;
	}
	
	/**
	 * Column Info
	 * @param transDocName
	 */
	public void setTransDocName(String transDocName) {
		this.transDocName = transDocName;
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
		setDeclareDate(JSPUtil.getParameter(request, prefix + "declare_date", ""));
		setPolFullname(JSPUtil.getParameter(request, prefix + "pol_fullname", ""));
		setCustomsStatusCd(JSPUtil.getParameter(request, prefix + "customs_status_cd", ""));
		setVslName(JSPUtil.getParameter(request, prefix + "vsl_name", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBlpkgu(JSPUtil.getParameter(request, prefix + "blpkgu", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setTransNation(JSPUtil.getParameter(request, prefix + "trans_nation", ""));
		setMvmtRefNo(JSPUtil.getParameter(request, prefix + "mvmt_ref_no", ""));
		setNextOfcCd(JSPUtil.getParameter(request, prefix + "next_ofc_cd", ""));
		setPodFullname(JSPUtil.getParameter(request, prefix + "pod_fullname", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setDeclareLocName(JSPUtil.getParameter(request, prefix + "declare_loc_name", ""));
		setBkgPodCd(JSPUtil.getParameter(request, prefix + "bkg_pod_cd", ""));
		setUnloadLocName(JSPUtil.getParameter(request, prefix + "unload_loc_name", ""));
		setSvcEnsYn(JSPUtil.getParameter(request, prefix + "svc_ens_yn", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setItSeqN(JSPUtil.getParameter(request, prefix + "it_seq_n", ""));
		setPodOfcCd(JSPUtil.getParameter(request, prefix + "pod_ofc_cd", ""));
		setSpecialRemarks(JSPUtil.getParameter(request, prefix + "special_remarks", ""));
		setBkgPolCd(JSPUtil.getParameter(request, prefix + "bkg_pol_cd", ""));
		setBlTransIdentity(JSPUtil.getParameter(request, prefix + "bl_trans_identity", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setCommodity(JSPUtil.getParameter(request, prefix + "commodity", ""));
		setCtTel(JSPUtil.getParameter(request, prefix + "ct_tel", ""));
		setCtFax(JSPUtil.getParameter(request, prefix + "ct_fax", ""));
		setUnloadLocEtaHis(JSPUtil.getParameter(request, prefix + "unload_loc_eta_his", ""));
		setBlmeau(JSPUtil.getParameter(request, prefix + "blmeau", ""));
		setMsgId(JSPUtil.getParameter(request, prefix + "msg_id", ""));
		setUnloadLocEta(JSPUtil.getParameter(request, prefix + "unload_loc_eta", ""));
		setLoadOfcCd(JSPUtil.getParameter(request, prefix + "load_ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCtEmail(JSPUtil.getParameter(request, prefix + "ct_email", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setAeoStatus(JSPUtil.getParameter(request, prefix + "aeo_status", ""));
		setLoadLocEtd(JSPUtil.getParameter(request, prefix + "load_loc_etd", ""));
		setProcessType(JSPUtil.getParameter(request, prefix + "process_type", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setB(JSPUtil.getParameter(request, prefix + "b", ""));
		setC(JSPUtil.getParameter(request, prefix + "c", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setMrn(JSPUtil.getParameter(request, prefix + "mrn", ""));
		setCtPosition(JSPUtil.getParameter(request, prefix + "ct_position", ""));
		setNextLocEta(JSPUtil.getParameter(request, prefix + "next_loc_eta", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setOriginalDate(JSPUtil.getParameter(request, prefix + "original_date", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setConsignPlace(JSPUtil.getParameter(request, prefix + "consign_place", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setDeclLocCd(JSPUtil.getParameter(request, prefix + "decl_loc_cd", ""));
		setTransDocNo(JSPUtil.getParameter(request, prefix + "trans_doc_no", ""));
		setPrevLocCd(JSPUtil.getParameter(request, prefix + "prev_loc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPartShipment(JSPUtil.getParameter(request, prefix + "part_shipment", ""));
		setPrnSeq(JSPUtil.getParameter(request, prefix + "prn_seq", ""));
		setDeclareLoc(JSPUtil.getParameter(request, prefix + "declare_loc", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setSvcDrYn(JSPUtil.getParameter(request, prefix + "svc_dr_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCstmsDeclDt(JSPUtil.getParameter(request, prefix + "cstms_decl_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBlmea(JSPUtil.getParameter(request, prefix + "blmea", ""));
		setPrn(JSPUtil.getParameter(request, prefix + "prn", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDelFullname(JSPUtil.getParameter(request, prefix + "del_fullname", ""));
		setProcessInfo(JSPUtil.getParameter(request, prefix + "process_info", ""));
		setDescs(JSPUtil.getParameter(request, prefix + "descs", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setLoadLocName(JSPUtil.getParameter(request, prefix + "load_loc_name", ""));
		setTransIdentity(JSPUtil.getParameter(request, prefix + "trans_identity", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setTrspDocNo(JSPUtil.getParameter(request, prefix + "trsp_doc_no", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
		setLoadLocCd(JSPUtil.getParameter(request, prefix + "load_loc_cd", ""));
		setMarkno(JSPUtil.getParameter(request, prefix + "markno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setItFileSeq(JSPUtil.getParameter(request, prefix + "it_file_seq", ""));
		setItSeq(JSPUtil.getParameter(request, prefix + "it_seq", ""));
		setTrsmVal(JSPUtil.getParameter(request, prefix + "trsm_val", ""));
		setNextLocName(JSPUtil.getParameter(request, prefix + "next_loc_name", ""));
		setPaymentCd(JSPUtil.getParameter(request, prefix + "payment_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setUnloadOfcCd(JSPUtil.getParameter(request, prefix + "unload_ofc_cd", ""));
		setBlEntryLoc(JSPUtil.getParameter(request, prefix + "bl_entry_loc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBlpkg(JSPUtil.getParameter(request, prefix + "blpkg", ""));
		setCustomsRef(JSPUtil.getParameter(request, prefix + "customs_ref", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setUnloadLocCd(JSPUtil.getParameter(request, prefix + "unload_loc_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCtName(JSPUtil.getParameter(request, prefix + "ct_name", ""));
		setMsgIdCd(JSPUtil.getParameter(request, prefix + "msg_id_cd", ""));
		setNextLocCd(JSPUtil.getParameter(request, prefix + "next_loc_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setSvcAnYn(JSPUtil.getParameter(request, prefix + "svc_an_yn", ""));
		setBlTransNation(JSPUtil.getParameter(request, prefix + "bl_trans_nation", ""));
		setTransDocName(JSPUtil.getParameter(request, prefix + "trans_doc_name", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlinfoVO[]
	 */
	public Eur24BlinfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlinfoVO[]
	 */
	public Eur24BlinfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlinfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] declareDate = (JSPUtil.getParameter(request, prefix	+ "declare_date", length));
			String[] polFullname = (JSPUtil.getParameter(request, prefix	+ "pol_fullname", length));
			String[] customsStatusCd = (JSPUtil.getParameter(request, prefix	+ "customs_status_cd", length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] blpkgu = (JSPUtil.getParameter(request, prefix	+ "blpkgu", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] transNation = (JSPUtil.getParameter(request, prefix	+ "trans_nation", length));
			String[] mvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "mvmt_ref_no", length));
			String[] nextOfcCd = (JSPUtil.getParameter(request, prefix	+ "next_ofc_cd", length));
			String[] podFullname = (JSPUtil.getParameter(request, prefix	+ "pod_fullname", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] declareLocName = (JSPUtil.getParameter(request, prefix	+ "declare_loc_name", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] unloadLocName = (JSPUtil.getParameter(request, prefix	+ "unload_loc_name", length));
			String[] svcEnsYn = (JSPUtil.getParameter(request, prefix	+ "svc_ens_yn", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] itSeqN = (JSPUtil.getParameter(request, prefix	+ "it_seq_n", length));
			String[] podOfcCd = (JSPUtil.getParameter(request, prefix	+ "pod_ofc_cd", length));
			String[] specialRemarks = (JSPUtil.getParameter(request, prefix	+ "special_remarks", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			String[] blTransIdentity = (JSPUtil.getParameter(request, prefix	+ "bl_trans_identity", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] commodity = (JSPUtil.getParameter(request, prefix	+ "commodity", length));
			String[] ctTel = (JSPUtil.getParameter(request, prefix	+ "ct_tel", length));
			String[] ctFax = (JSPUtil.getParameter(request, prefix	+ "ct_fax", length));
			String[] unloadLocEtaHis = (JSPUtil.getParameter(request, prefix	+ "unload_loc_eta_his", length));
			String[] blmeau = (JSPUtil.getParameter(request, prefix	+ "blmeau", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] unloadLocEta = (JSPUtil.getParameter(request, prefix	+ "unload_loc_eta", length));
			String[] loadOfcCd = (JSPUtil.getParameter(request, prefix	+ "load_ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ctEmail = (JSPUtil.getParameter(request, prefix	+ "ct_email", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] aeoStatus = (JSPUtil.getParameter(request, prefix	+ "aeo_status", length));
			String[] loadLocEtd = (JSPUtil.getParameter(request, prefix	+ "load_loc_etd", length));
			String[] processType = (JSPUtil.getParameter(request, prefix	+ "process_type", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] b = (JSPUtil.getParameter(request, prefix	+ "b", length));
			String[] c = (JSPUtil.getParameter(request, prefix	+ "c", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] mrn = (JSPUtil.getParameter(request, prefix	+ "mrn", length));
			String[] ctPosition = (JSPUtil.getParameter(request, prefix	+ "ct_position", length));
			String[] nextLocEta = (JSPUtil.getParameter(request, prefix	+ "next_loc_eta", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] originalDate = (JSPUtil.getParameter(request, prefix	+ "original_date", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] consignPlace = (JSPUtil.getParameter(request, prefix	+ "consign_place", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] declLocCd = (JSPUtil.getParameter(request, prefix	+ "decl_loc_cd", length));
			String[] transDocNo = (JSPUtil.getParameter(request, prefix	+ "trans_doc_no", length));
			String[] prevLocCd = (JSPUtil.getParameter(request, prefix	+ "prev_loc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] partShipment = (JSPUtil.getParameter(request, prefix	+ "part_shipment", length));
			String[] prnSeq = (JSPUtil.getParameter(request, prefix	+ "prn_seq", length));
			String[] declareLoc = (JSPUtil.getParameter(request, prefix	+ "declare_loc", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] svcDrYn = (JSPUtil.getParameter(request, prefix	+ "svc_dr_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsDeclDt = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blmea = (JSPUtil.getParameter(request, prefix	+ "blmea", length));
			String[] prn = (JSPUtil.getParameter(request, prefix	+ "prn", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] delFullname = (JSPUtil.getParameter(request, prefix	+ "del_fullname", length));
			String[] processInfo = (JSPUtil.getParameter(request, prefix	+ "process_info", length));
			String[] descs = (JSPUtil.getParameter(request, prefix	+ "descs", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] loadLocName = (JSPUtil.getParameter(request, prefix	+ "load_loc_name", length));
			String[] transIdentity = (JSPUtil.getParameter(request, prefix	+ "trans_identity", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] trspDocNo = (JSPUtil.getParameter(request, prefix	+ "trsp_doc_no", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] loadLocCd = (JSPUtil.getParameter(request, prefix	+ "load_loc_cd", length));
			String[] markno = (JSPUtil.getParameter(request, prefix	+ "markno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itFileSeq = (JSPUtil.getParameter(request, prefix	+ "it_file_seq", length));
			String[] itSeq = (JSPUtil.getParameter(request, prefix	+ "it_seq", length));
			String[] trsmVal = (JSPUtil.getParameter(request, prefix	+ "trsm_val", length));
			String[] nextLocName = (JSPUtil.getParameter(request, prefix	+ "next_loc_name", length));
			String[] paymentCd = (JSPUtil.getParameter(request, prefix	+ "payment_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] unloadOfcCd = (JSPUtil.getParameter(request, prefix	+ "unload_ofc_cd", length));
			String[] blEntryLoc = (JSPUtil.getParameter(request, prefix	+ "bl_entry_loc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] blpkg = (JSPUtil.getParameter(request, prefix	+ "blpkg", length));
			String[] customsRef = (JSPUtil.getParameter(request, prefix	+ "customs_ref", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] unloadLocCd = (JSPUtil.getParameter(request, prefix	+ "unload_loc_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ctName = (JSPUtil.getParameter(request, prefix	+ "ct_name", length));
			String[] msgIdCd = (JSPUtil.getParameter(request, prefix	+ "msg_id_cd", length));
			String[] nextLocCd = (JSPUtil.getParameter(request, prefix	+ "next_loc_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] svcAnYn = (JSPUtil.getParameter(request, prefix	+ "svc_an_yn", length));
			String[] blTransNation = (JSPUtil.getParameter(request, prefix	+ "bl_trans_nation", length));
			String[] transDocName = (JSPUtil.getParameter(request, prefix	+ "trans_doc_name", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlinfoVO();
				if (declareDate[i] != null)
					model.setDeclareDate(declareDate[i]);
				if (polFullname[i] != null)
					model.setPolFullname(polFullname[i]);
				if (customsStatusCd[i] != null)
					model.setCustomsStatusCd(customsStatusCd[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (blpkgu[i] != null)
					model.setBlpkgu(blpkgu[i]);
				if (bldel[i] != null)
					model.setBldel(bldel[i]);
				if (transNation[i] != null)
					model.setTransNation(transNation[i]);
				if (mvmtRefNo[i] != null)
					model.setMvmtRefNo(mvmtRefNo[i]);
				if (nextOfcCd[i] != null)
					model.setNextOfcCd(nextOfcCd[i]);
				if (podFullname[i] != null)
					model.setPodFullname(podFullname[i]);
				if (blnbr[i] != null)
					model.setBlnbr(blnbr[i]);
				if (declareLocName[i] != null)
					model.setDeclareLocName(declareLocName[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (unloadLocName[i] != null)
					model.setUnloadLocName(unloadLocName[i]);
				if (svcEnsYn[i] != null)
					model.setSvcEnsYn(svcEnsYn[i]);
				if (blpod[i] != null)
					model.setBlpod(blpod[i]);
				if (itSeqN[i] != null)
					model.setItSeqN(itSeqN[i]);
				if (podOfcCd[i] != null)
					model.setPodOfcCd(podOfcCd[i]);
				if (specialRemarks[i] != null)
					model.setSpecialRemarks(specialRemarks[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				if (blTransIdentity[i] != null)
					model.setBlTransIdentity(blTransIdentity[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (commodity[i] != null)
					model.setCommodity(commodity[i]);
				if (ctTel[i] != null)
					model.setCtTel(ctTel[i]);
				if (ctFax[i] != null)
					model.setCtFax(ctFax[i]);
				if (unloadLocEtaHis[i] != null)
					model.setUnloadLocEtaHis(unloadLocEtaHis[i]);
				if (blmeau[i] != null)
					model.setBlmeau(blmeau[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (unloadLocEta[i] != null)
					model.setUnloadLocEta(unloadLocEta[i]);
				if (loadOfcCd[i] != null)
					model.setLoadOfcCd(loadOfcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ctEmail[i] != null)
					model.setCtEmail(ctEmail[i]);
				if (blpol[i] != null)
					model.setBlpol(blpol[i]);
				if (aeoStatus[i] != null)
					model.setAeoStatus(aeoStatus[i]);
				if (loadLocEtd[i] != null)
					model.setLoadLocEtd(loadLocEtd[i]);
				if (processType[i] != null)
					model.setProcessType(processType[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (b[i] != null)
					model.setB(b[i]);
				if (c[i] != null)
					model.setC(c[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (mrn[i] != null)
					model.setMrn(mrn[i]);
				if (ctPosition[i] != null)
					model.setCtPosition(ctPosition[i]);
				if (nextLocEta[i] != null)
					model.setNextLocEta(nextLocEta[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (originalDate[i] != null)
					model.setOriginalDate(originalDate[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (consignPlace[i] != null)
					model.setConsignPlace(consignPlace[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (declLocCd[i] != null)
					model.setDeclLocCd(declLocCd[i]);
				if (transDocNo[i] != null)
					model.setTransDocNo(transDocNo[i]);
				if (prevLocCd[i] != null)
					model.setPrevLocCd(prevLocCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (partShipment[i] != null)
					model.setPartShipment(partShipment[i]);
				if (prnSeq[i] != null)
					model.setPrnSeq(prnSeq[i]);
				if (declareLoc[i] != null)
					model.setDeclareLoc(declareLoc[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (svcDrYn[i] != null)
					model.setSvcDrYn(svcDrYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsDeclDt[i] != null)
					model.setCstmsDeclDt(cstmsDeclDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blmea[i] != null)
					model.setBlmea(blmea[i]);
				if (prn[i] != null)
					model.setPrn(prn[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (delFullname[i] != null)
					model.setDelFullname(delFullname[i]);
				if (processInfo[i] != null)
					model.setProcessInfo(processInfo[i]);
				if (descs[i] != null)
					model.setDescs(descs[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (loadLocName[i] != null)
					model.setLoadLocName(loadLocName[i]);
				if (transIdentity[i] != null)
					model.setTransIdentity(transIdentity[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (trspDocNo[i] != null)
					model.setTrspDocNo(trspDocNo[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (loadLocCd[i] != null)
					model.setLoadLocCd(loadLocCd[i]);
				if (markno[i] != null)
					model.setMarkno(markno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itFileSeq[i] != null)
					model.setItFileSeq(itFileSeq[i]);
				if (itSeq[i] != null)
					model.setItSeq(itSeq[i]);
				if (trsmVal[i] != null)
					model.setTrsmVal(trsmVal[i]);
				if (nextLocName[i] != null)
					model.setNextLocName(nextLocName[i]);
				if (paymentCd[i] != null)
					model.setPaymentCd(paymentCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (unloadOfcCd[i] != null)
					model.setUnloadOfcCd(unloadOfcCd[i]);
				if (blEntryLoc[i] != null)
					model.setBlEntryLoc(blEntryLoc[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (blpkg[i] != null)
					model.setBlpkg(blpkg[i]);
				if (customsRef[i] != null)
					model.setCustomsRef(customsRef[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (unloadLocCd[i] != null)
					model.setUnloadLocCd(unloadLocCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ctName[i] != null)
					model.setCtName(ctName[i]);
				if (msgIdCd[i] != null)
					model.setMsgIdCd(msgIdCd[i]);
				if (nextLocCd[i] != null)
					model.setNextLocCd(nextLocCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (svcAnYn[i] != null)
					model.setSvcAnYn(svcAnYn[i]);
				if (blTransNation[i] != null)
					model.setBlTransNation(blTransNation[i]);
				if (transDocName[i] != null)
					model.setTransDocName(transDocName[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlinfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlinfoVO[]
	 */
	public Eur24BlinfoVO[] getEur24BlinfoVOs(){
		Eur24BlinfoVO[] vos = (Eur24BlinfoVO[])models.toArray(new Eur24BlinfoVO[models.size()]);
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
		this.declareDate = this.declareDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullname = this.polFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsStatusCd = this.customsStatusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgu = this.blpkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transNation = this.transNation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRefNo = this.mvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextOfcCd = this.nextOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFullname = this.podFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declareLocName = this.declareLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadLocName = this.unloadLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcEnsYn = this.svcEnsYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itSeqN = this.itSeqN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podOfcCd = this.podOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specialRemarks = this.specialRemarks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTransIdentity = this.blTransIdentity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodity = this.commodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctTel = this.ctTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctFax = this.ctFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadLocEtaHis = this.unloadLocEtaHis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmeau = this.blmeau .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadLocEta = this.unloadLocEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadOfcCd = this.loadOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctEmail = this.ctEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeoStatus = this.aeoStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadLocEtd = this.loadLocEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.processType = this.processType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.b = this.b .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.c = this.c .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrn = this.mrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctPosition = this.ctPosition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextLocEta = this.nextLocEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalDate = this.originalDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignPlace = this.consignPlace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declLocCd = this.declLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transDocNo = this.transDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevLocCd = this.prevLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partShipment = this.partShipment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnSeq = this.prnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declareLoc = this.declareLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcDrYn = this.svcDrYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclDt = this.cstmsDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmea = this.blmea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prn = this.prn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFullname = this.delFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.processInfo = this.processInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descs = this.descs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadLocName = this.loadLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transIdentity = this.transIdentity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo = this.trspDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadLocCd = this.loadLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.markno = this.markno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itFileSeq = this.itFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itSeq = this.itSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmVal = this.trsmVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextLocName = this.nextLocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paymentCd = this.paymentCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadOfcCd = this.unloadOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blEntryLoc = this.blEntryLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkg = this.blpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsRef = this.customsRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unloadLocCd = this.unloadLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctName = this.ctName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgIdCd = this.msgIdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextLocCd = this.nextLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcAnYn = this.svcAnYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTransNation = this.blTransNation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transDocName = this.transDocName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
