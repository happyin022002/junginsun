/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectEdiMstVO.java
*@FileTitle : RejectEdiMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.05 전용진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RejectEdiMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RejectEdiMstVO> models = new ArrayList<RejectEdiMstVO>();
	
	/* Column Info */
	private String bed3 = null;
	/* Column Info */
	private String olddir = null;
	/* Column Info */
	private String tloyd = null;
	/* Column Info */
	private String salesName = null;
	/* Column Info */
	private String drInd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oldvslname = null;
	/* Column Info */
	private String regionalBkgnbr = null;
	/* Column Info */
	private String oldvsl = null;
	/* Column Info */
	private String pucyCd = null;
	/* Column Info */
	private String cne1 = null;
	/* Column Info */
	private String rtcyAddr5 = null;
	/* Column Info */
	private String rtcyAddr4 = null;
	/* Column Info */
	private String rtcyAddr3 = null;
	/* Column Info */
	private String rtcyAddr2 = null;
	/* Column Info */
	private String rtcyCnt = null;
	/* Column Info */
	private String loyd = null;
	/* Column Info */
	private String rtcyAddr1 = null;
	/* Column Info */
	private String etd4 = null;
	/* Column Info */
	private String etd3 = null;
	/* Column Info */
	private String etd2 = null;
	/* Column Info */
	private String oldvslCallSign = null;
	/* Column Info */
	private String todir = null;
	/* Column Info */
	private String cmd = null;
	/* Column Info */
	private String vslCallSign = null;
	/* Column Info */
	private String rfInd = null;
	/* Column Info */
	private String contactName = null;
	/* Column Info */
	private String rdtyp = null;
	/* Column Info */
	private String rdUnd = null;
	/* Column Info */
	private String tovsl = null;
	/* Column Info */
	private String ibIeInd = null;
	/* Column Info */
	private String eqpickdt = null;
	/* Column Info */
	private String tovoy = null;
	/* Column Info */
	private String socInd = null;
	/* Column Info */
	private String shCd1 = null;
	/* Column Info */
	private String truck = null;
	/* Column Info */
	private String ffCd1 = null;
	/* Column Info */
	private String tvsl = null;
	/* Column Info */
	private String cargotype = null;
	/* Column Info */
	private String rtcyCd = null;
	/* Column Info */
	private String tdir = null;
	/* Column Info */
	private String port4 = null;
	/* Column Info */
	private String bkgStf = null;
	/* Column Info */
	private String port3 = null;
	/* Column Info */
	private String rejDesc = null;
	/* Column Info */
	private String port2 = null;
	/* Column Info */
	private String port1 = null;
	/* Column Info */
	private String port5 = null;
	/* Column Info */
	private String akInd = null;
	/* Column Info */
	private String qual5 = null;
	/* Column Info */
	private String qual4 = null;
	/* Column Info */
	private String qual3 = null;
	/* Column Info */
	private String qual2 = null;
	/* Column Info */
	private String qual1 = null;
	/* Column Info */
	private String tvslname = null;
	/* Column Info */
	private String cnCd1 = null;
	/* Column Info */
	private String brac = null;
	/* Column Info */
	private String bkgStfFax = null;
	/* Column Info */
	private String cct2 = null;
	/* Column Info */
	private String eqrel = null;
	/* Column Info */
	private String ntfy5 = null;
	/* Column Info */
	private String ntfy4 = null;
	/* Column Info */
	private String blPoNo = null;
	/* Column Info */
	private String ntfy3 = null;
	/* Column Info */
	private String vpsCctDt = null;
	/* Column Info */
	private String ntfy2 = null;
	/* Column Info */
	private String punit = null;
	/* Column Info */
	private String ntfy1 = null;
	/* Column Info */
	private String eqrtn = null;
	/* Column Info */
	private String vsld = null;
	/* Column Info */
	private String cmdd = null;
	/* Column Info */
	private String salesOffice = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String munit = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String udInd = null;
	/* Column Info */
	private String tvoy = null;
	/* Column Info */
	private String oldvoy = null;
	/* Column Info */
	private String pucyCnt = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfMa = null;
	/* Column Info */
	private String bkgStfName = null;
	/* Column Info */
	private String hdInd = null;
	/* Column Info */
	private String custRefNo = null;
	/* Column Info */
	private String udCd = null;
	/* Column Info */
	private String cancelBit = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String cnee5 = null;
	/* Column Info */
	private String ewunit = null;
	/* Column Info */
	private String cnee3 = null;
	/* Column Info */
	private String cnee4 = null;
	/* Column Info */
	private String cnee1 = null;
	/* Column Info */
	private String bvLane = null;
	/* Column Info */
	private String pkg = null;
	/* Column Info */
	private String cnee2 = null;
	/* Column Info */
	private String boundInd = null;
	/* Column Info */
	private String refVoyage = null;
	/* Column Info */
	private String cfmInd = null;
	/* Column Info */
	private String smod = null;
	/* Column Info */
	private String vslname = null;
	/* Column Info */
	private String bbInd = null;
	/* Column Info */
	private String contactTel = null;
	/* Column Info */
	private String vslld = null;
	/* Column Info */
	private String rtcyNm = null;
	/* Column Info */
	private String vvdRefNo = null;
	/* Column Info */
	private String eta31 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String tvslCallSign = null;
	/* Column Info */
	private String meas = null;
	/* Column Info */
	private String pucyNm = null;
	/* Column Info */
	private String wunit = null;
	/* Column Info */
	private String blSiNo = null;
	/* Column Info */
	private String bkgLane = null;
	/* Column Info */
	private String bkgDt = null;
	/* Column Info */
	private String bkgStfTel = null;
	/* Column Info */
	private String onboard = null;
	/* Column Info */
	private String pucyAddr2 = null;
	/* Column Info */
	private String pucyAddr3 = null;
	/* Column Info */
	private String ffn1 = null;
	/* Column Info */
	private String pucyAddr1 = null;
	/* Column Info */
	private String shpr2 = null;
	/* Column Info */
	private String shn1 = null;
	/* Column Info */
	private String shpr1 = null;
	/* Column Info */
	private String pucyAddr4 = null;
	/* Column Info */
	private String pucyAddr5 = null;
	/* Column Info */
	private String eta3 = null;
	/* Column Info */
	private String eta2 = null;
	/* Column Info */
	private String shpr5 = null;
	/* Column Info */
	private String shpr4 = null;
	/* Column Info */
	private String eta4 = null;
	/* Column Info */
	private String shpr3 = null;
	/* Column Info */
	private String name5 = null;
	/* Column Info */
	private String name3 = null;
	/* Column Info */
	private String name4 = null;
	/* Column Info */
	private String blkstwg = null;
	/* Column Info */
	private String frtTerm = null;
	/* Column Info */
	private String ewgt = null;
	/* Column Info */
	private String unlc4 = null;
	/* Column Info */
	private String ediGroupId = null;
	/* Column Info */
	private String unlc5 = null;
	/* Column Info */
	private String oldloyd = null;
	/* Column Info */
	private String bkgnbr = null;
	/* Column Info */
	private String name1 = null;
	/* Column Info */
	private String name2 = null;
	/* Column Info */
	private String unlc1 = null;
	/* Column Info */
	private String unlc2 = null;
	/* Column Info */
	private String rfCa = null;
	/* Column Info */
	private String unlc3 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RejectEdiMstVO() {}

	public RejectEdiMstVO(String ibflag, String pagerows, String bkgnbr, String bkgDt, String brac, String blNo, String bkgLane, String tovsl, String loyd, String vslname, String vslCallSign, String tovoy, String todir, String vslld, String vsld, String oldvsl, String oldloyd, String oldvslname, String oldvslCallSign, String oldvoy, String olddir, String tvsl, String tloyd, String tvslname, String tvslCallSign, String tvoy, String tdir, String name1, String qual1, String port1, String unlc1, String name2, String qual2, String port2, String unlc2, String eta2, String etd2, String cct2, String vpsCctDt, String name3, String qual3, String port3, String unlc3, String eta3, String eta31, String etd3, String etd4, String bed3, String name4, String qual4, String port4, String unlc4, String eta4, String name5, String qual5, String port5, String unlc5, String punit, String pkg, String wunit, String wgt, String ewunit, String ewgt, String munit, String meas, String rdtyp, String smod, String truck, String remark, String cmd, String cmdd, String eqrel, String shn1, String ffn1, String cne1, String shCd1, String ffCd1, String cnCd1, String shpr1, String shpr2, String shpr3, String shpr4, String shpr5, String cnee1, String cnee2, String cnee3, String cnee4, String cnee5, String ntfy1, String ntfy2, String ntfy3, String ntfy4, String ntfy5, String cancelBit, String cargotype, String drInd, String rfInd, String akInd, String bbInd, String hdInd, String udInd, String rdUnd, String rfCa, String rfMa, String socInd, String salesOffice, String salesName, String contactName, String contactTel, String boundInd, String regionalBkgnbr, String custRefNo, String refVoyage, String soNo, String blkstwg, String eqpickdt, String eqrtn, String pucyCnt, String pucyCd, String pucyNm, String pucyAddr1, String pucyAddr2, String pucyAddr3, String pucyAddr4, String pucyAddr5, String rtcyCnt, String rtcyCd, String rtcyNm, String rtcyAddr1, String rtcyAddr2, String rtcyAddr3, String rtcyAddr4, String rtcyAddr5, String blPoNo, String blSiNo, String frtTerm, String bkgOfc, String onboard, String cfmInd, String rejDesc, String scNo, String ibIeInd, String bvLane, String vvdRefNo, String udCd, String bkgStf, String bkgStfName, String bkgStfTel, String bkgStfFax, String ediGroupId) {
		this.bed3 = bed3;
		this.olddir = olddir;
		this.tloyd = tloyd;
		this.salesName = salesName;
		this.drInd = drInd;
		this.pagerows = pagerows;
		this.oldvslname = oldvslname;
		this.regionalBkgnbr = regionalBkgnbr;
		this.oldvsl = oldvsl;
		this.pucyCd = pucyCd;
		this.cne1 = cne1;
		this.rtcyAddr5 = rtcyAddr5;
		this.rtcyAddr4 = rtcyAddr4;
		this.rtcyAddr3 = rtcyAddr3;
		this.rtcyAddr2 = rtcyAddr2;
		this.rtcyCnt = rtcyCnt;
		this.loyd = loyd;
		this.rtcyAddr1 = rtcyAddr1;
		this.etd4 = etd4;
		this.etd3 = etd3;
		this.etd2 = etd2;
		this.oldvslCallSign = oldvslCallSign;
		this.todir = todir;
		this.cmd = cmd;
		this.vslCallSign = vslCallSign;
		this.rfInd = rfInd;
		this.contactName = contactName;
		this.rdtyp = rdtyp;
		this.rdUnd = rdUnd;
		this.tovsl = tovsl;
		this.ibIeInd = ibIeInd;
		this.eqpickdt = eqpickdt;
		this.tovoy = tovoy;
		this.socInd = socInd;
		this.shCd1 = shCd1;
		this.truck = truck;
		this.ffCd1 = ffCd1;
		this.tvsl = tvsl;
		this.cargotype = cargotype;
		this.rtcyCd = rtcyCd;
		this.tdir = tdir;
		this.port4 = port4;
		this.bkgStf = bkgStf;
		this.port3 = port3;
		this.rejDesc = rejDesc;
		this.port2 = port2;
		this.port1 = port1;
		this.port5 = port5;
		this.akInd = akInd;
		this.qual5 = qual5;
		this.qual4 = qual4;
		this.qual3 = qual3;
		this.qual2 = qual2;
		this.qual1 = qual1;
		this.tvslname = tvslname;
		this.cnCd1 = cnCd1;
		this.brac = brac;
		this.bkgStfFax = bkgStfFax;
		this.cct2 = cct2;
		this.eqrel = eqrel;
		this.ntfy5 = ntfy5;
		this.ntfy4 = ntfy4;
		this.blPoNo = blPoNo;
		this.ntfy3 = ntfy3;
		this.vpsCctDt = vpsCctDt;
		this.ntfy2 = ntfy2;
		this.punit = punit;
		this.ntfy1 = ntfy1;
		this.eqrtn = eqrtn;
		this.vsld = vsld;
		this.cmdd = cmdd;
		this.salesOffice = salesOffice;
		this.remark = remark;
		this.munit = munit;
		this.blNo = blNo;
		this.udInd = udInd;
		this.tvoy = tvoy;
		this.oldvoy = oldvoy;
		this.pucyCnt = pucyCnt;
		this.wgt = wgt;
		this.scNo = scNo;
		this.rfMa = rfMa;
		this.bkgStfName = bkgStfName;
		this.hdInd = hdInd;
		this.custRefNo = custRefNo;
		this.udCd = udCd;
		this.cancelBit = cancelBit;
		this.soNo = soNo;
		this.cnee5 = cnee5;
		this.ewunit = ewunit;
		this.cnee3 = cnee3;
		this.cnee4 = cnee4;
		this.cnee1 = cnee1;
		this.bvLane = bvLane;
		this.pkg = pkg;
		this.cnee2 = cnee2;
		this.boundInd = boundInd;
		this.refVoyage = refVoyage;
		this.cfmInd = cfmInd;
		this.smod = smod;
		this.vslname = vslname;
		this.bbInd = bbInd;
		this.contactTel = contactTel;
		this.vslld = vslld;
		this.rtcyNm = rtcyNm;
		this.vvdRefNo = vvdRefNo;
		this.eta31 = eta31;
		this.ibflag = ibflag;
		this.bkgOfc = bkgOfc;
		this.tvslCallSign = tvslCallSign;
		this.meas = meas;
		this.pucyNm = pucyNm;
		this.wunit = wunit;
		this.blSiNo = blSiNo;
		this.bkgLane = bkgLane;
		this.bkgDt = bkgDt;
		this.bkgStfTel = bkgStfTel;
		this.onboard = onboard;
		this.pucyAddr2 = pucyAddr2;
		this.pucyAddr3 = pucyAddr3;
		this.ffn1 = ffn1;
		this.pucyAddr1 = pucyAddr1;
		this.shpr2 = shpr2;
		this.shn1 = shn1;
		this.shpr1 = shpr1;
		this.pucyAddr4 = pucyAddr4;
		this.pucyAddr5 = pucyAddr5;
		this.eta3 = eta3;
		this.eta2 = eta2;
		this.shpr5 = shpr5;
		this.shpr4 = shpr4;
		this.eta4 = eta4;
		this.shpr3 = shpr3;
		this.name5 = name5;
		this.name3 = name3;
		this.name4 = name4;
		this.blkstwg = blkstwg;
		this.frtTerm = frtTerm;
		this.ewgt = ewgt;
		this.unlc4 = unlc4;
		this.ediGroupId = ediGroupId;
		this.unlc5 = unlc5;
		this.oldloyd = oldloyd;
		this.bkgnbr = bkgnbr;
		this.name1 = name1;
		this.name2 = name2;
		this.unlc1 = unlc1;
		this.unlc2 = unlc2;
		this.rfCa = rfCa;
		this.unlc3 = unlc3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bed3", getBed3());
		this.hashColumns.put("olddir", getOlddir());
		this.hashColumns.put("tloyd", getTloyd());
		this.hashColumns.put("sales_name", getSalesName());
		this.hashColumns.put("dr_ind", getDrInd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("oldvslname", getOldvslname());
		this.hashColumns.put("regional_bkgnbr", getRegionalBkgnbr());
		this.hashColumns.put("oldvsl", getOldvsl());
		this.hashColumns.put("pucy_cd", getPucyCd());
		this.hashColumns.put("cne1", getCne1());
		this.hashColumns.put("rtcy_addr5", getRtcyAddr5());
		this.hashColumns.put("rtcy_addr4", getRtcyAddr4());
		this.hashColumns.put("rtcy_addr3", getRtcyAddr3());
		this.hashColumns.put("rtcy_addr2", getRtcyAddr2());
		this.hashColumns.put("rtcy_cnt", getRtcyCnt());
		this.hashColumns.put("loyd", getLoyd());
		this.hashColumns.put("rtcy_addr1", getRtcyAddr1());
		this.hashColumns.put("etd4", getEtd4());
		this.hashColumns.put("etd3", getEtd3());
		this.hashColumns.put("etd2", getEtd2());
		this.hashColumns.put("oldvsl_call_sign", getOldvslCallSign());
		this.hashColumns.put("todir", getTodir());
		this.hashColumns.put("cmd", getCmd());
		this.hashColumns.put("vsl_call_sign", getVslCallSign());
		this.hashColumns.put("rf_ind", getRfInd());
		this.hashColumns.put("contact_name", getContactName());
		this.hashColumns.put("rdtyp", getRdtyp());
		this.hashColumns.put("rd_und", getRdUnd());
		this.hashColumns.put("tovsl", getTovsl());
		this.hashColumns.put("ib_ie_ind", getIbIeInd());
		this.hashColumns.put("eqpickdt", getEqpickdt());
		this.hashColumns.put("tovoy", getTovoy());
		this.hashColumns.put("soc_ind", getSocInd());
		this.hashColumns.put("sh_cd1", getShCd1());
		this.hashColumns.put("truck", getTruck());
		this.hashColumns.put("ff_cd1", getFfCd1());
		this.hashColumns.put("tvsl", getTvsl());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("rtcy_cd", getRtcyCd());
		this.hashColumns.put("tdir", getTdir());
		this.hashColumns.put("port4", getPort4());
		this.hashColumns.put("bkg_stf", getBkgStf());
		this.hashColumns.put("port3", getPort3());
		this.hashColumns.put("rej_desc", getRejDesc());
		this.hashColumns.put("port2", getPort2());
		this.hashColumns.put("port1", getPort1());
		this.hashColumns.put("port5", getPort5());
		this.hashColumns.put("ak_ind", getAkInd());
		this.hashColumns.put("qual5", getQual5());
		this.hashColumns.put("qual4", getQual4());
		this.hashColumns.put("qual3", getQual3());
		this.hashColumns.put("qual2", getQual2());
		this.hashColumns.put("qual1", getQual1());
		this.hashColumns.put("tvslname", getTvslname());
		this.hashColumns.put("cn_cd1", getCnCd1());
		this.hashColumns.put("brac", getBrac());
		this.hashColumns.put("bkg_stf_fax", getBkgStfFax());
		this.hashColumns.put("cct2", getCct2());
		this.hashColumns.put("eqrel", getEqrel());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("bl_po_no", getBlPoNo());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("vps_cct_dt", getVpsCctDt());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("punit", getPunit());
		this.hashColumns.put("ntfy1", getNtfy1());
		this.hashColumns.put("eqrtn", getEqrtn());
		this.hashColumns.put("vsld", getVsld());
		this.hashColumns.put("cmdd", getCmdd());
		this.hashColumns.put("sales_office", getSalesOffice());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("munit", getMunit());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ud_ind", getUdInd());
		this.hashColumns.put("tvoy", getTvoy());
		this.hashColumns.put("oldvoy", getOldvoy());
		this.hashColumns.put("pucy_cnt", getPucyCnt());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rf_ma", getRfMa());
		this.hashColumns.put("bkg_stf_name", getBkgStfName());
		this.hashColumns.put("hd_ind", getHdInd());
		this.hashColumns.put("cust_ref_no", getCustRefNo());
		this.hashColumns.put("ud_cd", getUdCd());
		this.hashColumns.put("cancel_bit", getCancelBit());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("ewunit", getEwunit());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("bv_lane", getBvLane());
		this.hashColumns.put("pkg", getPkg());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("bound_ind", getBoundInd());
		this.hashColumns.put("ref_voyage", getRefVoyage());
		this.hashColumns.put("cfm_ind", getCfmInd());
		this.hashColumns.put("smod", getSmod());
		this.hashColumns.put("vslname", getVslname());
		this.hashColumns.put("bb_ind", getBbInd());
		this.hashColumns.put("contact_tel", getContactTel());
		this.hashColumns.put("vslld", getVslld());
		this.hashColumns.put("rtcy_nm", getRtcyNm());
		this.hashColumns.put("vvd_ref_no", getVvdRefNo());
		this.hashColumns.put("eta3_1", getEta31());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("tvsl_call_sign", getTvslCallSign());
		this.hashColumns.put("meas", getMeas());
		this.hashColumns.put("pucy_nm", getPucyNm());
		this.hashColumns.put("wunit", getWunit());
		this.hashColumns.put("bl_si_no", getBlSiNo());
		this.hashColumns.put("bkg_lane", getBkgLane());
		this.hashColumns.put("bkg_dt", getBkgDt());
		this.hashColumns.put("bkg_stf_tel", getBkgStfTel());
		this.hashColumns.put("onboard", getOnboard());
		this.hashColumns.put("pucy_addr2", getPucyAddr2());
		this.hashColumns.put("pucy_addr3", getPucyAddr3());
		this.hashColumns.put("ffn1", getFfn1());
		this.hashColumns.put("pucy_addr1", getPucyAddr1());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("shn1", getShn1());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("pucy_addr4", getPucyAddr4());
		this.hashColumns.put("pucy_addr5", getPucyAddr5());
		this.hashColumns.put("eta3", getEta3());
		this.hashColumns.put("eta2", getEta2());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("eta4", getEta4());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("name5", getName5());
		this.hashColumns.put("name3", getName3());
		this.hashColumns.put("name4", getName4());
		this.hashColumns.put("blkstwg", getBlkstwg());
		this.hashColumns.put("frt_term", getFrtTerm());
		this.hashColumns.put("ewgt", getEwgt());
		this.hashColumns.put("unlc4", getUnlc4());
		this.hashColumns.put("edi_group_id", getEdiGroupId());
		this.hashColumns.put("unlc5", getUnlc5());
		this.hashColumns.put("oldloyd", getOldloyd());
		this.hashColumns.put("bkgnbr", getBkgnbr());
		this.hashColumns.put("name1", getName1());
		this.hashColumns.put("name2", getName2());
		this.hashColumns.put("unlc1", getUnlc1());
		this.hashColumns.put("unlc2", getUnlc2());
		this.hashColumns.put("rf_ca", getRfCa());
		this.hashColumns.put("unlc3", getUnlc3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bed3", "bed3");
		this.hashFields.put("olddir", "olddir");
		this.hashFields.put("tloyd", "tloyd");
		this.hashFields.put("sales_name", "salesName");
		this.hashFields.put("dr_ind", "drInd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("oldvslname", "oldvslname");
		this.hashFields.put("regional_bkgnbr", "regionalBkgnbr");
		this.hashFields.put("oldvsl", "oldvsl");
		this.hashFields.put("pucy_cd", "pucyCd");
		this.hashFields.put("cne1", "cne1");
		this.hashFields.put("rtcy_addr5", "rtcyAddr5");
		this.hashFields.put("rtcy_addr4", "rtcyAddr4");
		this.hashFields.put("rtcy_addr3", "rtcyAddr3");
		this.hashFields.put("rtcy_addr2", "rtcyAddr2");
		this.hashFields.put("rtcy_cnt", "rtcyCnt");
		this.hashFields.put("loyd", "loyd");
		this.hashFields.put("rtcy_addr1", "rtcyAddr1");
		this.hashFields.put("etd4", "etd4");
		this.hashFields.put("etd3", "etd3");
		this.hashFields.put("etd2", "etd2");
		this.hashFields.put("oldvsl_call_sign", "oldvslCallSign");
		this.hashFields.put("todir", "todir");
		this.hashFields.put("cmd", "cmd");
		this.hashFields.put("vsl_call_sign", "vslCallSign");
		this.hashFields.put("rf_ind", "rfInd");
		this.hashFields.put("contact_name", "contactName");
		this.hashFields.put("rdtyp", "rdtyp");
		this.hashFields.put("rd_und", "rdUnd");
		this.hashFields.put("tovsl", "tovsl");
		this.hashFields.put("ib_ie_ind", "ibIeInd");
		this.hashFields.put("eqpickdt", "eqpickdt");
		this.hashFields.put("tovoy", "tovoy");
		this.hashFields.put("soc_ind", "socInd");
		this.hashFields.put("sh_cd1", "shCd1");
		this.hashFields.put("truck", "truck");
		this.hashFields.put("ff_cd1", "ffCd1");
		this.hashFields.put("tvsl", "tvsl");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("rtcy_cd", "rtcyCd");
		this.hashFields.put("tdir", "tdir");
		this.hashFields.put("port4", "port4");
		this.hashFields.put("bkg_stf", "bkgStf");
		this.hashFields.put("port3", "port3");
		this.hashFields.put("rej_desc", "rejDesc");
		this.hashFields.put("port2", "port2");
		this.hashFields.put("port1", "port1");
		this.hashFields.put("port5", "port5");
		this.hashFields.put("ak_ind", "akInd");
		this.hashFields.put("qual5", "qual5");
		this.hashFields.put("qual4", "qual4");
		this.hashFields.put("qual3", "qual3");
		this.hashFields.put("qual2", "qual2");
		this.hashFields.put("qual1", "qual1");
		this.hashFields.put("tvslname", "tvslname");
		this.hashFields.put("cn_cd1", "cnCd1");
		this.hashFields.put("brac", "brac");
		this.hashFields.put("bkg_stf_fax", "bkgStfFax");
		this.hashFields.put("cct2", "cct2");
		this.hashFields.put("eqrel", "eqrel");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("bl_po_no", "blPoNo");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("vps_cct_dt", "vpsCctDt");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("punit", "punit");
		this.hashFields.put("ntfy1", "ntfy1");
		this.hashFields.put("eqrtn", "eqrtn");
		this.hashFields.put("vsld", "vsld");
		this.hashFields.put("cmdd", "cmdd");
		this.hashFields.put("sales_office", "salesOffice");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("munit", "munit");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ud_ind", "udInd");
		this.hashFields.put("tvoy", "tvoy");
		this.hashFields.put("oldvoy", "oldvoy");
		this.hashFields.put("pucy_cnt", "pucyCnt");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rf_ma", "rfMa");
		this.hashFields.put("bkg_stf_name", "bkgStfName");
		this.hashFields.put("hd_ind", "hdInd");
		this.hashFields.put("cust_ref_no", "custRefNo");
		this.hashFields.put("ud_cd", "udCd");
		this.hashFields.put("cancel_bit", "cancelBit");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("ewunit", "ewunit");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("bv_lane", "bvLane");
		this.hashFields.put("pkg", "pkg");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("bound_ind", "boundInd");
		this.hashFields.put("ref_voyage", "refVoyage");
		this.hashFields.put("cfm_ind", "cfmInd");
		this.hashFields.put("smod", "smod");
		this.hashFields.put("vslname", "vslname");
		this.hashFields.put("bb_ind", "bbInd");
		this.hashFields.put("contact_tel", "contactTel");
		this.hashFields.put("vslld", "vslld");
		this.hashFields.put("rtcy_nm", "rtcyNm");
		this.hashFields.put("vvd_ref_no", "vvdRefNo");
		this.hashFields.put("eta3_1", "eta31");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("tvsl_call_sign", "tvslCallSign");
		this.hashFields.put("meas", "meas");
		this.hashFields.put("pucy_nm", "pucyNm");
		this.hashFields.put("wunit", "wunit");
		this.hashFields.put("bl_si_no", "blSiNo");
		this.hashFields.put("bkg_lane", "bkgLane");
		this.hashFields.put("bkg_dt", "bkgDt");
		this.hashFields.put("bkg_stf_tel", "bkgStfTel");
		this.hashFields.put("onboard", "onboard");
		this.hashFields.put("pucy_addr2", "pucyAddr2");
		this.hashFields.put("pucy_addr3", "pucyAddr3");
		this.hashFields.put("ffn1", "ffn1");
		this.hashFields.put("pucy_addr1", "pucyAddr1");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("shn1", "shn1");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("pucy_addr4", "pucyAddr4");
		this.hashFields.put("pucy_addr5", "pucyAddr5");
		this.hashFields.put("eta3", "eta3");
		this.hashFields.put("eta2", "eta2");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("eta4", "eta4");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("name5", "name5");
		this.hashFields.put("name3", "name3");
		this.hashFields.put("name4", "name4");
		this.hashFields.put("blkstwg", "blkstwg");
		this.hashFields.put("frt_term", "frtTerm");
		this.hashFields.put("ewgt", "ewgt");
		this.hashFields.put("unlc4", "unlc4");
		this.hashFields.put("edi_group_id", "ediGroupId");
		this.hashFields.put("unlc5", "unlc5");
		this.hashFields.put("oldloyd", "oldloyd");
		this.hashFields.put("bkgnbr", "bkgnbr");
		this.hashFields.put("name1", "name1");
		this.hashFields.put("name2", "name2");
		this.hashFields.put("unlc1", "unlc1");
		this.hashFields.put("unlc2", "unlc2");
		this.hashFields.put("rf_ca", "rfCa");
		this.hashFields.put("unlc3", "unlc3");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bed3
	 */
	public String getBed3() {
		return this.bed3;
	}
	
	/**
	 * Column Info
	 * @return olddir
	 */
	public String getOlddir() {
		return this.olddir;
	}
	
	/**
	 * Column Info
	 * @return tloyd
	 */
	public String getTloyd() {
		return this.tloyd;
	}
	
	/**
	 * Column Info
	 * @return salesName
	 */
	public String getSalesName() {
		return this.salesName;
	}
	
	/**
	 * Column Info
	 * @return drInd
	 */
	public String getDrInd() {
		return this.drInd;
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
	 * @return oldvslname
	 */
	public String getOldvslname() {
		return this.oldvslname;
	}
	
	/**
	 * Column Info
	 * @return regionalBkgnbr
	 */
	public String getRegionalBkgnbr() {
		return this.regionalBkgnbr;
	}
	
	/**
	 * Column Info
	 * @return oldvsl
	 */
	public String getOldvsl() {
		return this.oldvsl;
	}
	
	/**
	 * Column Info
	 * @return pucyCd
	 */
	public String getPucyCd() {
		return this.pucyCd;
	}
	
	/**
	 * Column Info
	 * @return cne1
	 */
	public String getCne1() {
		return this.cne1;
	}
	
	/**
	 * Column Info
	 * @return rtcyAddr5
	 */
	public String getRtcyAddr5() {
		return this.rtcyAddr5;
	}
	
	/**
	 * Column Info
	 * @return rtcyAddr4
	 */
	public String getRtcyAddr4() {
		return this.rtcyAddr4;
	}
	
	/**
	 * Column Info
	 * @return rtcyAddr3
	 */
	public String getRtcyAddr3() {
		return this.rtcyAddr3;
	}
	
	/**
	 * Column Info
	 * @return rtcyAddr2
	 */
	public String getRtcyAddr2() {
		return this.rtcyAddr2;
	}
	
	/**
	 * Column Info
	 * @return rtcyCnt
	 */
	public String getRtcyCnt() {
		return this.rtcyCnt;
	}
	
	/**
	 * Column Info
	 * @return loyd
	 */
	public String getLoyd() {
		return this.loyd;
	}
	
	/**
	 * Column Info
	 * @return rtcyAddr1
	 */
	public String getRtcyAddr1() {
		return this.rtcyAddr1;
	}
	
	/**
	 * Column Info
	 * @return etd4
	 */
	public String getEtd4() {
		return this.etd4;
	}
	
	/**
	 * Column Info
	 * @return etd3
	 */
	public String getEtd3() {
		return this.etd3;
	}
	
	/**
	 * Column Info
	 * @return etd2
	 */
	public String getEtd2() {
		return this.etd2;
	}
	
	/**
	 * Column Info
	 * @return oldvslCallSign
	 */
	public String getOldvslCallSign() {
		return this.oldvslCallSign;
	}
	
	/**
	 * Column Info
	 * @return todir
	 */
	public String getTodir() {
		return this.todir;
	}
	
	/**
	 * Column Info
	 * @return cmd
	 */
	public String getCmd() {
		return this.cmd;
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
	 * @return rfInd
	 */
	public String getRfInd() {
		return this.rfInd;
	}
	
	/**
	 * Column Info
	 * @return contactName
	 */
	public String getContactName() {
		return this.contactName;
	}
	
	/**
	 * Column Info
	 * @return rdtyp
	 */
	public String getRdtyp() {
		return this.rdtyp;
	}
	
	/**
	 * Column Info
	 * @return rdUnd
	 */
	public String getRdUnd() {
		return this.rdUnd;
	}
	
	/**
	 * Column Info
	 * @return tovsl
	 */
	public String getTovsl() {
		return this.tovsl;
	}
	
	/**
	 * Column Info
	 * @return ibIeInd
	 */
	public String getIbIeInd() {
		return this.ibIeInd;
	}
	
	/**
	 * Column Info
	 * @return eqpickdt
	 */
	public String getEqpickdt() {
		return this.eqpickdt;
	}
	
	/**
	 * Column Info
	 * @return tovoy
	 */
	public String getTovoy() {
		return this.tovoy;
	}
	
	/**
	 * Column Info
	 * @return socInd
	 */
	public String getSocInd() {
		return this.socInd;
	}
	
	/**
	 * Column Info
	 * @return shCd1
	 */
	public String getShCd1() {
		return this.shCd1;
	}
	
	/**
	 * Column Info
	 * @return truck
	 */
	public String getTruck() {
		return this.truck;
	}
	
	/**
	 * Column Info
	 * @return ffCd1
	 */
	public String getFfCd1() {
		return this.ffCd1;
	}
	
	/**
	 * Column Info
	 * @return tvsl
	 */
	public String getTvsl() {
		return this.tvsl;
	}
	
	/**
	 * Column Info
	 * @return cargotype
	 */
	public String getCargotype() {
		return this.cargotype;
	}
	
	/**
	 * Column Info
	 * @return rtcyCd
	 */
	public String getRtcyCd() {
		return this.rtcyCd;
	}
	
	/**
	 * Column Info
	 * @return tdir
	 */
	public String getTdir() {
		return this.tdir;
	}
	
	/**
	 * Column Info
	 * @return port4
	 */
	public String getPort4() {
		return this.port4;
	}
	
	/**
	 * Column Info
	 * @return bkgStf
	 */
	public String getBkgStf() {
		return this.bkgStf;
	}
	
	/**
	 * Column Info
	 * @return port3
	 */
	public String getPort3() {
		return this.port3;
	}
	
	/**
	 * Column Info
	 * @return rejDesc
	 */
	public String getRejDesc() {
		return this.rejDesc;
	}
	
	/**
	 * Column Info
	 * @return port2
	 */
	public String getPort2() {
		return this.port2;
	}
	
	/**
	 * Column Info
	 * @return port1
	 */
	public String getPort1() {
		return this.port1;
	}
	
	/**
	 * Column Info
	 * @return port5
	 */
	public String getPort5() {
		return this.port5;
	}
	
	/**
	 * Column Info
	 * @return akInd
	 */
	public String getAkInd() {
		return this.akInd;
	}
	
	/**
	 * Column Info
	 * @return qual5
	 */
	public String getQual5() {
		return this.qual5;
	}
	
	/**
	 * Column Info
	 * @return qual4
	 */
	public String getQual4() {
		return this.qual4;
	}
	
	/**
	 * Column Info
	 * @return qual3
	 */
	public String getQual3() {
		return this.qual3;
	}
	
	/**
	 * Column Info
	 * @return qual2
	 */
	public String getQual2() {
		return this.qual2;
	}
	
	/**
	 * Column Info
	 * @return qual1
	 */
	public String getQual1() {
		return this.qual1;
	}
	
	/**
	 * Column Info
	 * @return tvslname
	 */
	public String getTvslname() {
		return this.tvslname;
	}
	
	/**
	 * Column Info
	 * @return cnCd1
	 */
	public String getCnCd1() {
		return this.cnCd1;
	}
	
	/**
	 * Column Info
	 * @return brac
	 */
	public String getBrac() {
		return this.brac;
	}
	
	/**
	 * Column Info
	 * @return bkgStfFax
	 */
	public String getBkgStfFax() {
		return this.bkgStfFax;
	}
	
	/**
	 * Column Info
	 * @return cct2
	 */
	public String getCct2() {
		return this.cct2;
	}
	
	/**
	 * Column Info
	 * @return eqrel
	 */
	public String getEqrel() {
		return this.eqrel;
	}
	
	/**
	 * Column Info
	 * @return ntfy5
	 */
	public String getNtfy5() {
		return this.ntfy5;
	}
	
	/**
	 * Column Info
	 * @return ntfy4
	 */
	public String getNtfy4() {
		return this.ntfy4;
	}
	
	/**
	 * Column Info
	 * @return blPoNo
	 */
	public String getBlPoNo() {
		return this.blPoNo;
	}
	
	/**
	 * Column Info
	 * @return ntfy3
	 */
	public String getNtfy3() {
		return this.ntfy3;
	}
	
	/**
	 * Column Info
	 * @return vpsCctDt
	 */
	public String getVpsCctDt() {
		return this.vpsCctDt;
	}
	
	/**
	 * Column Info
	 * @return ntfy2
	 */
	public String getNtfy2() {
		return this.ntfy2;
	}
	
	/**
	 * Column Info
	 * @return punit
	 */
	public String getPunit() {
		return this.punit;
	}
	
	/**
	 * Column Info
	 * @return ntfy1
	 */
	public String getNtfy1() {
		return this.ntfy1;
	}
	
	/**
	 * Column Info
	 * @return eqrtn
	 */
	public String getEqrtn() {
		return this.eqrtn;
	}
	
	/**
	 * Column Info
	 * @return vsld
	 */
	public String getVsld() {
		return this.vsld;
	}
	
	/**
	 * Column Info
	 * @return cmdd
	 */
	public String getCmdd() {
		return this.cmdd;
	}
	
	/**
	 * Column Info
	 * @return salesOffice
	 */
	public String getSalesOffice() {
		return this.salesOffice;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return munit
	 */
	public String getMunit() {
		return this.munit;
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
	 * @return udInd
	 */
	public String getUdInd() {
		return this.udInd;
	}
	
	/**
	 * Column Info
	 * @return tvoy
	 */
	public String getTvoy() {
		return this.tvoy;
	}
	
	/**
	 * Column Info
	 * @return oldvoy
	 */
	public String getOldvoy() {
		return this.oldvoy;
	}
	
	/**
	 * Column Info
	 * @return pucyCnt
	 */
	public String getPucyCnt() {
		return this.pucyCnt;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return rfMa
	 */
	public String getRfMa() {
		return this.rfMa;
	}
	
	/**
	 * Column Info
	 * @return bkgStfName
	 */
	public String getBkgStfName() {
		return this.bkgStfName;
	}
	
	/**
	 * Column Info
	 * @return hdInd
	 */
	public String getHdInd() {
		return this.hdInd;
	}
	
	/**
	 * Column Info
	 * @return custRefNo
	 */
	public String getCustRefNo() {
		return this.custRefNo;
	}
	
	/**
	 * Column Info
	 * @return udCd
	 */
	public String getUdCd() {
		return this.udCd;
	}
	
	/**
	 * Column Info
	 * @return cancelBit
	 */
	public String getCancelBit() {
		return this.cancelBit;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return cnee5
	 */
	public String getCnee5() {
		return this.cnee5;
	}
	
	/**
	 * Column Info
	 * @return ewunit
	 */
	public String getEwunit() {
		return this.ewunit;
	}
	
	/**
	 * Column Info
	 * @return cnee3
	 */
	public String getCnee3() {
		return this.cnee3;
	}
	
	/**
	 * Column Info
	 * @return cnee4
	 */
	public String getCnee4() {
		return this.cnee4;
	}
	
	/**
	 * Column Info
	 * @return cnee1
	 */
	public String getCnee1() {
		return this.cnee1;
	}
	
	/**
	 * Column Info
	 * @return bvLane
	 */
	public String getBvLane() {
		return this.bvLane;
	}
	
	/**
	 * Column Info
	 * @return pkg
	 */
	public String getPkg() {
		return this.pkg;
	}
	
	/**
	 * Column Info
	 * @return cnee2
	 */
	public String getCnee2() {
		return this.cnee2;
	}
	
	/**
	 * Column Info
	 * @return boundInd
	 */
	public String getBoundInd() {
		return this.boundInd;
	}
	
	/**
	 * Column Info
	 * @return refVoyage
	 */
	public String getRefVoyage() {
		return this.refVoyage;
	}
	
	/**
	 * Column Info
	 * @return cfmInd
	 */
	public String getCfmInd() {
		return this.cfmInd;
	}
	
	/**
	 * Column Info
	 * @return smod
	 */
	public String getSmod() {
		return this.smod;
	}
	
	/**
	 * Column Info
	 * @return vslname
	 */
	public String getVslname() {
		return this.vslname;
	}
	
	/**
	 * Column Info
	 * @return bbInd
	 */
	public String getBbInd() {
		return this.bbInd;
	}
	
	/**
	 * Column Info
	 * @return contactTel
	 */
	public String getContactTel() {
		return this.contactTel;
	}
	
	/**
	 * Column Info
	 * @return vslld
	 */
	public String getVslld() {
		return this.vslld;
	}
	
	/**
	 * Column Info
	 * @return rtcyNm
	 */
	public String getRtcyNm() {
		return this.rtcyNm;
	}
	
	/**
	 * Column Info
	 * @return vvdRefNo
	 */
	public String getVvdRefNo() {
		return this.vvdRefNo;
	}
	
	/**
	 * Column Info
	 * @return eta31
	 */
	public String getEta31() {
		return this.eta31;
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
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return tvslCallSign
	 */
	public String getTvslCallSign() {
		return this.tvslCallSign;
	}
	
	/**
	 * Column Info
	 * @return meas
	 */
	public String getMeas() {
		return this.meas;
	}
	
	/**
	 * Column Info
	 * @return pucyNm
	 */
	public String getPucyNm() {
		return this.pucyNm;
	}
	
	/**
	 * Column Info
	 * @return wunit
	 */
	public String getWunit() {
		return this.wunit;
	}
	
	/**
	 * Column Info
	 * @return blSiNo
	 */
	public String getBlSiNo() {
		return this.blSiNo;
	}
	
	/**
	 * Column Info
	 * @return bkgLane
	 */
	public String getBkgLane() {
		return this.bkgLane;
	}
	
	/**
	 * Column Info
	 * @return bkgDt
	 */
	public String getBkgDt() {
		return this.bkgDt;
	}
	
	/**
	 * Column Info
	 * @return bkgStfTel
	 */
	public String getBkgStfTel() {
		return this.bkgStfTel;
	}
	
	/**
	 * Column Info
	 * @return onboard
	 */
	public String getOnboard() {
		return this.onboard;
	}
	
	/**
	 * Column Info
	 * @return pucyAddr2
	 */
	public String getPucyAddr2() {
		return this.pucyAddr2;
	}
	
	/**
	 * Column Info
	 * @return pucyAddr3
	 */
	public String getPucyAddr3() {
		return this.pucyAddr3;
	}
	
	/**
	 * Column Info
	 * @return ffn1
	 */
	public String getFfn1() {
		return this.ffn1;
	}
	
	/**
	 * Column Info
	 * @return pucyAddr1
	 */
	public String getPucyAddr1() {
		return this.pucyAddr1;
	}
	
	/**
	 * Column Info
	 * @return shpr2
	 */
	public String getShpr2() {
		return this.shpr2;
	}
	
	/**
	 * Column Info
	 * @return shn1
	 */
	public String getShn1() {
		return this.shn1;
	}
	
	/**
	 * Column Info
	 * @return shpr1
	 */
	public String getShpr1() {
		return this.shpr1;
	}
	
	/**
	 * Column Info
	 * @return pucyAddr4
	 */
	public String getPucyAddr4() {
		return this.pucyAddr4;
	}
	
	/**
	 * Column Info
	 * @return pucyAddr5
	 */
	public String getPucyAddr5() {
		return this.pucyAddr5;
	}
	
	/**
	 * Column Info
	 * @return eta3
	 */
	public String getEta3() {
		return this.eta3;
	}
	
	/**
	 * Column Info
	 * @return eta2
	 */
	public String getEta2() {
		return this.eta2;
	}
	
	/**
	 * Column Info
	 * @return shpr5
	 */
	public String getShpr5() {
		return this.shpr5;
	}
	
	/**
	 * Column Info
	 * @return shpr4
	 */
	public String getShpr4() {
		return this.shpr4;
	}
	
	/**
	 * Column Info
	 * @return eta4
	 */
	public String getEta4() {
		return this.eta4;
	}
	
	/**
	 * Column Info
	 * @return shpr3
	 */
	public String getShpr3() {
		return this.shpr3;
	}
	
	/**
	 * Column Info
	 * @return name5
	 */
	public String getName5() {
		return this.name5;
	}
	
	/**
	 * Column Info
	 * @return name3
	 */
	public String getName3() {
		return this.name3;
	}
	
	/**
	 * Column Info
	 * @return name4
	 */
	public String getName4() {
		return this.name4;
	}
	
	/**
	 * Column Info
	 * @return blkstwg
	 */
	public String getBlkstwg() {
		return this.blkstwg;
	}
	
	/**
	 * Column Info
	 * @return frtTerm
	 */
	public String getFrtTerm() {
		return this.frtTerm;
	}
	
	/**
	 * Column Info
	 * @return ewgt
	 */
	public String getEwgt() {
		return this.ewgt;
	}
	
	/**
	 * Column Info
	 * @return unlc4
	 */
	public String getUnlc4() {
		return this.unlc4;
	}
	
	/**
	 * Column Info
	 * @return ediGroupId
	 */
	public String getEdiGroupId() {
		return this.ediGroupId;
	}
	
	/**
	 * Column Info
	 * @return unlc5
	 */
	public String getUnlc5() {
		return this.unlc5;
	}
	
	/**
	 * Column Info
	 * @return oldloyd
	 */
	public String getOldloyd() {
		return this.oldloyd;
	}
	
	/**
	 * Column Info
	 * @return bkgnbr
	 */
	public String getBkgnbr() {
		return this.bkgnbr;
	}
	
	/**
	 * Column Info
	 * @return name1
	 */
	public String getName1() {
		return this.name1;
	}
	
	/**
	 * Column Info
	 * @return name2
	 */
	public String getName2() {
		return this.name2;
	}
	
	/**
	 * Column Info
	 * @return unlc1
	 */
	public String getUnlc1() {
		return this.unlc1;
	}
	
	/**
	 * Column Info
	 * @return unlc2
	 */
	public String getUnlc2() {
		return this.unlc2;
	}
	
	/**
	 * Column Info
	 * @return rfCa
	 */
	public String getRfCa() {
		return this.rfCa;
	}
	
	/**
	 * Column Info
	 * @return unlc3
	 */
	public String getUnlc3() {
		return this.unlc3;
	}
	

	/**
	 * Column Info
	 * @param bed3
	 */
	public void setBed3(String bed3) {
		this.bed3 = bed3;
	}
	
	/**
	 * Column Info
	 * @param olddir
	 */
	public void setOlddir(String olddir) {
		this.olddir = olddir;
	}
	
	/**
	 * Column Info
	 * @param tloyd
	 */
	public void setTloyd(String tloyd) {
		this.tloyd = tloyd;
	}
	
	/**
	 * Column Info
	 * @param salesName
	 */
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	
	/**
	 * Column Info
	 * @param drInd
	 */
	public void setDrInd(String drInd) {
		this.drInd = drInd;
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
	 * @param oldvslname
	 */
	public void setOldvslname(String oldvslname) {
		this.oldvslname = oldvslname;
	}
	
	/**
	 * Column Info
	 * @param regionalBkgnbr
	 */
	public void setRegionalBkgnbr(String regionalBkgnbr) {
		this.regionalBkgnbr = regionalBkgnbr;
	}
	
	/**
	 * Column Info
	 * @param oldvsl
	 */
	public void setOldvsl(String oldvsl) {
		this.oldvsl = oldvsl;
	}
	
	/**
	 * Column Info
	 * @param pucyCd
	 */
	public void setPucyCd(String pucyCd) {
		this.pucyCd = pucyCd;
	}
	
	/**
	 * Column Info
	 * @param cne1
	 */
	public void setCne1(String cne1) {
		this.cne1 = cne1;
	}
	
	/**
	 * Column Info
	 * @param rtcyAddr5
	 */
	public void setRtcyAddr5(String rtcyAddr5) {
		this.rtcyAddr5 = rtcyAddr5;
	}
	
	/**
	 * Column Info
	 * @param rtcyAddr4
	 */
	public void setRtcyAddr4(String rtcyAddr4) {
		this.rtcyAddr4 = rtcyAddr4;
	}
	
	/**
	 * Column Info
	 * @param rtcyAddr3
	 */
	public void setRtcyAddr3(String rtcyAddr3) {
		this.rtcyAddr3 = rtcyAddr3;
	}
	
	/**
	 * Column Info
	 * @param rtcyAddr2
	 */
	public void setRtcyAddr2(String rtcyAddr2) {
		this.rtcyAddr2 = rtcyAddr2;
	}
	
	/**
	 * Column Info
	 * @param rtcyCnt
	 */
	public void setRtcyCnt(String rtcyCnt) {
		this.rtcyCnt = rtcyCnt;
	}
	
	/**
	 * Column Info
	 * @param loyd
	 */
	public void setLoyd(String loyd) {
		this.loyd = loyd;
	}
	
	/**
	 * Column Info
	 * @param rtcyAddr1
	 */
	public void setRtcyAddr1(String rtcyAddr1) {
		this.rtcyAddr1 = rtcyAddr1;
	}
	
	/**
	 * Column Info
	 * @param etd4
	 */
	public void setEtd4(String etd4) {
		this.etd4 = etd4;
	}
	
	/**
	 * Column Info
	 * @param etd3
	 */
	public void setEtd3(String etd3) {
		this.etd3 = etd3;
	}
	
	/**
	 * Column Info
	 * @param etd2
	 */
	public void setEtd2(String etd2) {
		this.etd2 = etd2;
	}
	
	/**
	 * Column Info
	 * @param oldvslCallSign
	 */
	public void setOldvslCallSign(String oldvslCallSign) {
		this.oldvslCallSign = oldvslCallSign;
	}
	
	/**
	 * Column Info
	 * @param todir
	 */
	public void setTodir(String todir) {
		this.todir = todir;
	}
	
	/**
	 * Column Info
	 * @param cmd
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
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
	 * @param rfInd
	 */
	public void setRfInd(String rfInd) {
		this.rfInd = rfInd;
	}
	
	/**
	 * Column Info
	 * @param contactName
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	/**
	 * Column Info
	 * @param rdtyp
	 */
	public void setRdtyp(String rdtyp) {
		this.rdtyp = rdtyp;
	}
	
	/**
	 * Column Info
	 * @param rdUnd
	 */
	public void setRdUnd(String rdUnd) {
		this.rdUnd = rdUnd;
	}
	
	/**
	 * Column Info
	 * @param tovsl
	 */
	public void setTovsl(String tovsl) {
		this.tovsl = tovsl;
	}
	
	/**
	 * Column Info
	 * @param ibIeInd
	 */
	public void setIbIeInd(String ibIeInd) {
		this.ibIeInd = ibIeInd;
	}
	
	/**
	 * Column Info
	 * @param eqpickdt
	 */
	public void setEqpickdt(String eqpickdt) {
		this.eqpickdt = eqpickdt;
	}
	
	/**
	 * Column Info
	 * @param tovoy
	 */
	public void setTovoy(String tovoy) {
		this.tovoy = tovoy;
	}
	
	/**
	 * Column Info
	 * @param socInd
	 */
	public void setSocInd(String socInd) {
		this.socInd = socInd;
	}
	
	/**
	 * Column Info
	 * @param shCd1
	 */
	public void setShCd1(String shCd1) {
		this.shCd1 = shCd1;
	}
	
	/**
	 * Column Info
	 * @param truck
	 */
	public void setTruck(String truck) {
		this.truck = truck;
	}
	
	/**
	 * Column Info
	 * @param ffCd1
	 */
	public void setFfCd1(String ffCd1) {
		this.ffCd1 = ffCd1;
	}
	
	/**
	 * Column Info
	 * @param tvsl
	 */
	public void setTvsl(String tvsl) {
		this.tvsl = tvsl;
	}
	
	/**
	 * Column Info
	 * @param cargotype
	 */
	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
	}
	
	/**
	 * Column Info
	 * @param rtcyCd
	 */
	public void setRtcyCd(String rtcyCd) {
		this.rtcyCd = rtcyCd;
	}
	
	/**
	 * Column Info
	 * @param tdir
	 */
	public void setTdir(String tdir) {
		this.tdir = tdir;
	}
	
	/**
	 * Column Info
	 * @param port4
	 */
	public void setPort4(String port4) {
		this.port4 = port4;
	}
	
	/**
	 * Column Info
	 * @param bkgStf
	 */
	public void setBkgStf(String bkgStf) {
		this.bkgStf = bkgStf;
	}
	
	/**
	 * Column Info
	 * @param port3
	 */
	public void setPort3(String port3) {
		this.port3 = port3;
	}
	
	/**
	 * Column Info
	 * @param rejDesc
	 */
	public void setRejDesc(String rejDesc) {
		this.rejDesc = rejDesc;
	}
	
	/**
	 * Column Info
	 * @param port2
	 */
	public void setPort2(String port2) {
		this.port2 = port2;
	}
	
	/**
	 * Column Info
	 * @param port1
	 */
	public void setPort1(String port1) {
		this.port1 = port1;
	}
	
	/**
	 * Column Info
	 * @param port5
	 */
	public void setPort5(String port5) {
		this.port5 = port5;
	}
	
	/**
	 * Column Info
	 * @param akInd
	 */
	public void setAkInd(String akInd) {
		this.akInd = akInd;
	}
	
	/**
	 * Column Info
	 * @param qual5
	 */
	public void setQual5(String qual5) {
		this.qual5 = qual5;
	}
	
	/**
	 * Column Info
	 * @param qual4
	 */
	public void setQual4(String qual4) {
		this.qual4 = qual4;
	}
	
	/**
	 * Column Info
	 * @param qual3
	 */
	public void setQual3(String qual3) {
		this.qual3 = qual3;
	}
	
	/**
	 * Column Info
	 * @param qual2
	 */
	public void setQual2(String qual2) {
		this.qual2 = qual2;
	}
	
	/**
	 * Column Info
	 * @param qual1
	 */
	public void setQual1(String qual1) {
		this.qual1 = qual1;
	}
	
	/**
	 * Column Info
	 * @param tvslname
	 */
	public void setTvslname(String tvslname) {
		this.tvslname = tvslname;
	}
	
	/**
	 * Column Info
	 * @param cnCd1
	 */
	public void setCnCd1(String cnCd1) {
		this.cnCd1 = cnCd1;
	}
	
	/**
	 * Column Info
	 * @param brac
	 */
	public void setBrac(String brac) {
		this.brac = brac;
	}
	
	/**
	 * Column Info
	 * @param bkgStfFax
	 */
	public void setBkgStfFax(String bkgStfFax) {
		this.bkgStfFax = bkgStfFax;
	}
	
	/**
	 * Column Info
	 * @param cct2
	 */
	public void setCct2(String cct2) {
		this.cct2 = cct2;
	}
	
	/**
	 * Column Info
	 * @param eqrel
	 */
	public void setEqrel(String eqrel) {
		this.eqrel = eqrel;
	}
	
	/**
	 * Column Info
	 * @param ntfy5
	 */
	public void setNtfy5(String ntfy5) {
		this.ntfy5 = ntfy5;
	}
	
	/**
	 * Column Info
	 * @param ntfy4
	 */
	public void setNtfy4(String ntfy4) {
		this.ntfy4 = ntfy4;
	}
	
	/**
	 * Column Info
	 * @param blPoNo
	 */
	public void setBlPoNo(String blPoNo) {
		this.blPoNo = blPoNo;
	}
	
	/**
	 * Column Info
	 * @param ntfy3
	 */
	public void setNtfy3(String ntfy3) {
		this.ntfy3 = ntfy3;
	}
	
	/**
	 * Column Info
	 * @param vpsCctDt
	 */
	public void setVpsCctDt(String vpsCctDt) {
		this.vpsCctDt = vpsCctDt;
	}
	
	/**
	 * Column Info
	 * @param ntfy2
	 */
	public void setNtfy2(String ntfy2) {
		this.ntfy2 = ntfy2;
	}
	
	/**
	 * Column Info
	 * @param punit
	 */
	public void setPunit(String punit) {
		this.punit = punit;
	}
	
	/**
	 * Column Info
	 * @param ntfy1
	 */
	public void setNtfy1(String ntfy1) {
		this.ntfy1 = ntfy1;
	}
	
	/**
	 * Column Info
	 * @param eqrtn
	 */
	public void setEqrtn(String eqrtn) {
		this.eqrtn = eqrtn;
	}
	
	/**
	 * Column Info
	 * @param vsld
	 */
	public void setVsld(String vsld) {
		this.vsld = vsld;
	}
	
	/**
	 * Column Info
	 * @param cmdd
	 */
	public void setCmdd(String cmdd) {
		this.cmdd = cmdd;
	}
	
	/**
	 * Column Info
	 * @param salesOffice
	 */
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param munit
	 */
	public void setMunit(String munit) {
		this.munit = munit;
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
	 * @param udInd
	 */
	public void setUdInd(String udInd) {
		this.udInd = udInd;
	}
	
	/**
	 * Column Info
	 * @param tvoy
	 */
	public void setTvoy(String tvoy) {
		this.tvoy = tvoy;
	}
	
	/**
	 * Column Info
	 * @param oldvoy
	 */
	public void setOldvoy(String oldvoy) {
		this.oldvoy = oldvoy;
	}
	
	/**
	 * Column Info
	 * @param pucyCnt
	 */
	public void setPucyCnt(String pucyCnt) {
		this.pucyCnt = pucyCnt;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param rfMa
	 */
	public void setRfMa(String rfMa) {
		this.rfMa = rfMa;
	}
	
	/**
	 * Column Info
	 * @param bkgStfName
	 */
	public void setBkgStfName(String bkgStfName) {
		this.bkgStfName = bkgStfName;
	}
	
	/**
	 * Column Info
	 * @param hdInd
	 */
	public void setHdInd(String hdInd) {
		this.hdInd = hdInd;
	}
	
	/**
	 * Column Info
	 * @param custRefNo
	 */
	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}
	
	/**
	 * Column Info
	 * @param udCd
	 */
	public void setUdCd(String udCd) {
		this.udCd = udCd;
	}
	
	/**
	 * Column Info
	 * @param cancelBit
	 */
	public void setCancelBit(String cancelBit) {
		this.cancelBit = cancelBit;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param cnee5
	 */
	public void setCnee5(String cnee5) {
		this.cnee5 = cnee5;
	}
	
	/**
	 * Column Info
	 * @param ewunit
	 */
	public void setEwunit(String ewunit) {
		this.ewunit = ewunit;
	}
	
	/**
	 * Column Info
	 * @param cnee3
	 */
	public void setCnee3(String cnee3) {
		this.cnee3 = cnee3;
	}
	
	/**
	 * Column Info
	 * @param cnee4
	 */
	public void setCnee4(String cnee4) {
		this.cnee4 = cnee4;
	}
	
	/**
	 * Column Info
	 * @param cnee1
	 */
	public void setCnee1(String cnee1) {
		this.cnee1 = cnee1;
	}
	
	/**
	 * Column Info
	 * @param bvLane
	 */
	public void setBvLane(String bvLane) {
		this.bvLane = bvLane;
	}
	
	/**
	 * Column Info
	 * @param pkg
	 */
	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
	/**
	 * Column Info
	 * @param cnee2
	 */
	public void setCnee2(String cnee2) {
		this.cnee2 = cnee2;
	}
	
	/**
	 * Column Info
	 * @param boundInd
	 */
	public void setBoundInd(String boundInd) {
		this.boundInd = boundInd;
	}
	
	/**
	 * Column Info
	 * @param refVoyage
	 */
	public void setRefVoyage(String refVoyage) {
		this.refVoyage = refVoyage;
	}
	
	/**
	 * Column Info
	 * @param cfmInd
	 */
	public void setCfmInd(String cfmInd) {
		this.cfmInd = cfmInd;
	}
	
	/**
	 * Column Info
	 * @param smod
	 */
	public void setSmod(String smod) {
		this.smod = smod;
	}
	
	/**
	 * Column Info
	 * @param vslname
	 */
	public void setVslname(String vslname) {
		this.vslname = vslname;
	}
	
	/**
	 * Column Info
	 * @param bbInd
	 */
	public void setBbInd(String bbInd) {
		this.bbInd = bbInd;
	}
	
	/**
	 * Column Info
	 * @param contactTel
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	
	/**
	 * Column Info
	 * @param vslld
	 */
	public void setVslld(String vslld) {
		this.vslld = vslld;
	}
	
	/**
	 * Column Info
	 * @param rtcyNm
	 */
	public void setRtcyNm(String rtcyNm) {
		this.rtcyNm = rtcyNm;
	}
	
	/**
	 * Column Info
	 * @param vvdRefNo
	 */
	public void setVvdRefNo(String vvdRefNo) {
		this.vvdRefNo = vvdRefNo;
	}
	
	/**
	 * Column Info
	 * @param eta31
	 */
	public void setEta31(String eta31) {
		this.eta31 = eta31;
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
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param tvslCallSign
	 */
	public void setTvslCallSign(String tvslCallSign) {
		this.tvslCallSign = tvslCallSign;
	}
	
	/**
	 * Column Info
	 * @param meas
	 */
	public void setMeas(String meas) {
		this.meas = meas;
	}
	
	/**
	 * Column Info
	 * @param pucyNm
	 */
	public void setPucyNm(String pucyNm) {
		this.pucyNm = pucyNm;
	}
	
	/**
	 * Column Info
	 * @param wunit
	 */
	public void setWunit(String wunit) {
		this.wunit = wunit;
	}
	
	/**
	 * Column Info
	 * @param blSiNo
	 */
	public void setBlSiNo(String blSiNo) {
		this.blSiNo = blSiNo;
	}
	
	/**
	 * Column Info
	 * @param bkgLane
	 */
	public void setBkgLane(String bkgLane) {
		this.bkgLane = bkgLane;
	}
	
	/**
	 * Column Info
	 * @param bkgDt
	 */
	public void setBkgDt(String bkgDt) {
		this.bkgDt = bkgDt;
	}
	
	/**
	 * Column Info
	 * @param bkgStfTel
	 */
	public void setBkgStfTel(String bkgStfTel) {
		this.bkgStfTel = bkgStfTel;
	}
	
	/**
	 * Column Info
	 * @param onboard
	 */
	public void setOnboard(String onboard) {
		this.onboard = onboard;
	}
	
	/**
	 * Column Info
	 * @param pucyAddr2
	 */
	public void setPucyAddr2(String pucyAddr2) {
		this.pucyAddr2 = pucyAddr2;
	}
	
	/**
	 * Column Info
	 * @param pucyAddr3
	 */
	public void setPucyAddr3(String pucyAddr3) {
		this.pucyAddr3 = pucyAddr3;
	}
	
	/**
	 * Column Info
	 * @param ffn1
	 */
	public void setFfn1(String ffn1) {
		this.ffn1 = ffn1;
	}
	
	/**
	 * Column Info
	 * @param pucyAddr1
	 */
	public void setPucyAddr1(String pucyAddr1) {
		this.pucyAddr1 = pucyAddr1;
	}
	
	/**
	 * Column Info
	 * @param shpr2
	 */
	public void setShpr2(String shpr2) {
		this.shpr2 = shpr2;
	}
	
	/**
	 * Column Info
	 * @param shn1
	 */
	public void setShn1(String shn1) {
		this.shn1 = shn1;
	}
	
	/**
	 * Column Info
	 * @param shpr1
	 */
	public void setShpr1(String shpr1) {
		this.shpr1 = shpr1;
	}
	
	/**
	 * Column Info
	 * @param pucyAddr4
	 */
	public void setPucyAddr4(String pucyAddr4) {
		this.pucyAddr4 = pucyAddr4;
	}
	
	/**
	 * Column Info
	 * @param pucyAddr5
	 */
	public void setPucyAddr5(String pucyAddr5) {
		this.pucyAddr5 = pucyAddr5;
	}
	
	/**
	 * Column Info
	 * @param eta3
	 */
	public void setEta3(String eta3) {
		this.eta3 = eta3;
	}
	
	/**
	 * Column Info
	 * @param eta2
	 */
	public void setEta2(String eta2) {
		this.eta2 = eta2;
	}
	
	/**
	 * Column Info
	 * @param shpr5
	 */
	public void setShpr5(String shpr5) {
		this.shpr5 = shpr5;
	}
	
	/**
	 * Column Info
	 * @param shpr4
	 */
	public void setShpr4(String shpr4) {
		this.shpr4 = shpr4;
	}
	
	/**
	 * Column Info
	 * @param eta4
	 */
	public void setEta4(String eta4) {
		this.eta4 = eta4;
	}
	
	/**
	 * Column Info
	 * @param shpr3
	 */
	public void setShpr3(String shpr3) {
		this.shpr3 = shpr3;
	}
	
	/**
	 * Column Info
	 * @param name5
	 */
	public void setName5(String name5) {
		this.name5 = name5;
	}
	
	/**
	 * Column Info
	 * @param name3
	 */
	public void setName3(String name3) {
		this.name3 = name3;
	}
	
	/**
	 * Column Info
	 * @param name4
	 */
	public void setName4(String name4) {
		this.name4 = name4;
	}
	
	/**
	 * Column Info
	 * @param blkstwg
	 */
	public void setBlkstwg(String blkstwg) {
		this.blkstwg = blkstwg;
	}
	
	/**
	 * Column Info
	 * @param frtTerm
	 */
	public void setFrtTerm(String frtTerm) {
		this.frtTerm = frtTerm;
	}
	
	/**
	 * Column Info
	 * @param ewgt
	 */
	public void setEwgt(String ewgt) {
		this.ewgt = ewgt;
	}
	
	/**
	 * Column Info
	 * @param unlc4
	 */
	public void setUnlc4(String unlc4) {
		this.unlc4 = unlc4;
	}
	
	/**
	 * Column Info
	 * @param ediGroupId
	 */
	public void setEdiGroupId(String ediGroupId) {
		this.ediGroupId = ediGroupId;
	}
	
	/**
	 * Column Info
	 * @param unlc5
	 */
	public void setUnlc5(String unlc5) {
		this.unlc5 = unlc5;
	}
	
	/**
	 * Column Info
	 * @param oldloyd
	 */
	public void setOldloyd(String oldloyd) {
		this.oldloyd = oldloyd;
	}
	
	/**
	 * Column Info
	 * @param bkgnbr
	 */
	public void setBkgnbr(String bkgnbr) {
		this.bkgnbr = bkgnbr;
	}
	
	/**
	 * Column Info
	 * @param name1
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}
	
	/**
	 * Column Info
	 * @param name2
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	/**
	 * Column Info
	 * @param unlc1
	 */
	public void setUnlc1(String unlc1) {
		this.unlc1 = unlc1;
	}
	
	/**
	 * Column Info
	 * @param unlc2
	 */
	public void setUnlc2(String unlc2) {
		this.unlc2 = unlc2;
	}
	
	/**
	 * Column Info
	 * @param rfCa
	 */
	public void setRfCa(String rfCa) {
		this.rfCa = rfCa;
	}
	
	/**
	 * Column Info
	 * @param unlc3
	 */
	public void setUnlc3(String unlc3) {
		this.unlc3 = unlc3;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBed3(JSPUtil.getParameter(request, "bed3", ""));
		setOlddir(JSPUtil.getParameter(request, "olddir", ""));
		setTloyd(JSPUtil.getParameter(request, "tloyd", ""));
		setSalesName(JSPUtil.getParameter(request, "sales_name", ""));
		setDrInd(JSPUtil.getParameter(request, "dr_ind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOldvslname(JSPUtil.getParameter(request, "oldvslname", ""));
		setRegionalBkgnbr(JSPUtil.getParameter(request, "regional_bkgnbr", ""));
		setOldvsl(JSPUtil.getParameter(request, "oldvsl", ""));
		setPucyCd(JSPUtil.getParameter(request, "pucy_cd", ""));
		setCne1(JSPUtil.getParameter(request, "cne1", ""));
		setRtcyAddr5(JSPUtil.getParameter(request, "rtcy_addr5", ""));
		setRtcyAddr4(JSPUtil.getParameter(request, "rtcy_addr4", ""));
		setRtcyAddr3(JSPUtil.getParameter(request, "rtcy_addr3", ""));
		setRtcyAddr2(JSPUtil.getParameter(request, "rtcy_addr2", ""));
		setRtcyCnt(JSPUtil.getParameter(request, "rtcy_cnt", ""));
		setLoyd(JSPUtil.getParameter(request, "loyd", ""));
		setRtcyAddr1(JSPUtil.getParameter(request, "rtcy_addr1", ""));
		setEtd4(JSPUtil.getParameter(request, "etd4", ""));
		setEtd3(JSPUtil.getParameter(request, "etd3", ""));
		setEtd2(JSPUtil.getParameter(request, "etd2", ""));
		setOldvslCallSign(JSPUtil.getParameter(request, "oldvsl_call_sign", ""));
		setTodir(JSPUtil.getParameter(request, "todir", ""));
		setCmd(JSPUtil.getParameter(request, "cmd", ""));
		setVslCallSign(JSPUtil.getParameter(request, "vsl_call_sign", ""));
		setRfInd(JSPUtil.getParameter(request, "rf_ind", ""));
		setContactName(JSPUtil.getParameter(request, "contact_name", ""));
		setRdtyp(JSPUtil.getParameter(request, "rdtyp", ""));
		setRdUnd(JSPUtil.getParameter(request, "rd_und", ""));
		setTovsl(JSPUtil.getParameter(request, "tovsl", ""));
		setIbIeInd(JSPUtil.getParameter(request, "ib_ie_ind", ""));
		setEqpickdt(JSPUtil.getParameter(request, "eqpickdt", ""));
		setTovoy(JSPUtil.getParameter(request, "tovoy", ""));
		setSocInd(JSPUtil.getParameter(request, "soc_ind", ""));
		setShCd1(JSPUtil.getParameter(request, "sh_cd1", ""));
		setTruck(JSPUtil.getParameter(request, "truck", ""));
		setFfCd1(JSPUtil.getParameter(request, "ff_cd1", ""));
		setTvsl(JSPUtil.getParameter(request, "tvsl", ""));
		setCargotype(JSPUtil.getParameter(request, "cargotype", ""));
		setRtcyCd(JSPUtil.getParameter(request, "rtcy_cd", ""));
		setTdir(JSPUtil.getParameter(request, "tdir", ""));
		setPort4(JSPUtil.getParameter(request, "port4", ""));
		setBkgStf(JSPUtil.getParameter(request, "bkg_stf", ""));
		setPort3(JSPUtil.getParameter(request, "port3", ""));
		setRejDesc(JSPUtil.getParameter(request, "rej_desc", ""));
		setPort2(JSPUtil.getParameter(request, "port2", ""));
		setPort1(JSPUtil.getParameter(request, "port1", ""));
		setPort5(JSPUtil.getParameter(request, "port5", ""));
		setAkInd(JSPUtil.getParameter(request, "ak_ind", ""));
		setQual5(JSPUtil.getParameter(request, "qual5", ""));
		setQual4(JSPUtil.getParameter(request, "qual4", ""));
		setQual3(JSPUtil.getParameter(request, "qual3", ""));
		setQual2(JSPUtil.getParameter(request, "qual2", ""));
		setQual1(JSPUtil.getParameter(request, "qual1", ""));
		setTvslname(JSPUtil.getParameter(request, "tvslname", ""));
		setCnCd1(JSPUtil.getParameter(request, "cn_cd1", ""));
		setBrac(JSPUtil.getParameter(request, "brac", ""));
		setBkgStfFax(JSPUtil.getParameter(request, "bkg_stf_fax", ""));
		setCct2(JSPUtil.getParameter(request, "cct2", ""));
		setEqrel(JSPUtil.getParameter(request, "eqrel", ""));
		setNtfy5(JSPUtil.getParameter(request, "ntfy5", ""));
		setNtfy4(JSPUtil.getParameter(request, "ntfy4", ""));
		setBlPoNo(JSPUtil.getParameter(request, "bl_po_no", ""));
		setNtfy3(JSPUtil.getParameter(request, "ntfy3", ""));
		setVpsCctDt(JSPUtil.getParameter(request, "vps_cct_dt", ""));
		setNtfy2(JSPUtil.getParameter(request, "ntfy2", ""));
		setPunit(JSPUtil.getParameter(request, "punit", ""));
		setNtfy1(JSPUtil.getParameter(request, "ntfy1", ""));
		setEqrtn(JSPUtil.getParameter(request, "eqrtn", ""));
		setVsld(JSPUtil.getParameter(request, "vsld", ""));
		setCmdd(JSPUtil.getParameter(request, "cmdd", ""));
		setSalesOffice(JSPUtil.getParameter(request, "sales_office", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setMunit(JSPUtil.getParameter(request, "munit", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setUdInd(JSPUtil.getParameter(request, "ud_ind", ""));
		setTvoy(JSPUtil.getParameter(request, "tvoy", ""));
		setOldvoy(JSPUtil.getParameter(request, "oldvoy", ""));
		setPucyCnt(JSPUtil.getParameter(request, "pucy_cnt", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setRfMa(JSPUtil.getParameter(request, "rf_ma", ""));
		setBkgStfName(JSPUtil.getParameter(request, "bkg_stf_name", ""));
		setHdInd(JSPUtil.getParameter(request, "hd_ind", ""));
		setCustRefNo(JSPUtil.getParameter(request, "cust_ref_no", ""));
		setUdCd(JSPUtil.getParameter(request, "ud_cd", ""));
		setCancelBit(JSPUtil.getParameter(request, "cancel_bit", ""));
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setCnee5(JSPUtil.getParameter(request, "cnee5", ""));
		setEwunit(JSPUtil.getParameter(request, "ewunit", ""));
		setCnee3(JSPUtil.getParameter(request, "cnee3", ""));
		setCnee4(JSPUtil.getParameter(request, "cnee4", ""));
		setCnee1(JSPUtil.getParameter(request, "cnee1", ""));
		setBvLane(JSPUtil.getParameter(request, "bv_lane", ""));
		setPkg(JSPUtil.getParameter(request, "pkg", ""));
		setCnee2(JSPUtil.getParameter(request, "cnee2", ""));
		setBoundInd(JSPUtil.getParameter(request, "bound_ind", ""));
		setRefVoyage(JSPUtil.getParameter(request, "ref_voyage", ""));
		setCfmInd(JSPUtil.getParameter(request, "cfm_ind", ""));
		setSmod(JSPUtil.getParameter(request, "smod", ""));
		setVslname(JSPUtil.getParameter(request, "vslname", ""));
		setBbInd(JSPUtil.getParameter(request, "bb_ind", ""));
		setContactTel(JSPUtil.getParameter(request, "contact_tel", ""));
		setVslld(JSPUtil.getParameter(request, "vslld", ""));
		setRtcyNm(JSPUtil.getParameter(request, "rtcy_nm", ""));
		setVvdRefNo(JSPUtil.getParameter(request, "vvd_ref_no", ""));
		setEta31(JSPUtil.getParameter(request, "eta3_1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgOfc(JSPUtil.getParameter(request, "bkg_ofc", ""));
		setTvslCallSign(JSPUtil.getParameter(request, "tvsl_call_sign", ""));
		setMeas(JSPUtil.getParameter(request, "meas", ""));
		setPucyNm(JSPUtil.getParameter(request, "pucy_nm", ""));
		setWunit(JSPUtil.getParameter(request, "wunit", ""));
		setBlSiNo(JSPUtil.getParameter(request, "bl_si_no", ""));
		setBkgLane(JSPUtil.getParameter(request, "bkg_lane", ""));
		setBkgDt(JSPUtil.getParameter(request, "bkg_dt", ""));
		setBkgStfTel(JSPUtil.getParameter(request, "bkg_stf_tel", ""));
		setOnboard(JSPUtil.getParameter(request, "onboard", ""));
		setPucyAddr2(JSPUtil.getParameter(request, "pucy_addr2", ""));
		setPucyAddr3(JSPUtil.getParameter(request, "pucy_addr3", ""));
		setFfn1(JSPUtil.getParameter(request, "ffn1", ""));
		setPucyAddr1(JSPUtil.getParameter(request, "pucy_addr1", ""));
		setShpr2(JSPUtil.getParameter(request, "shpr2", ""));
		setShn1(JSPUtil.getParameter(request, "shn1", ""));
		setShpr1(JSPUtil.getParameter(request, "shpr1", ""));
		setPucyAddr4(JSPUtil.getParameter(request, "pucy_addr4", ""));
		setPucyAddr5(JSPUtil.getParameter(request, "pucy_addr5", ""));
		setEta3(JSPUtil.getParameter(request, "eta3", ""));
		setEta2(JSPUtil.getParameter(request, "eta2", ""));
		setShpr5(JSPUtil.getParameter(request, "shpr5", ""));
		setShpr4(JSPUtil.getParameter(request, "shpr4", ""));
		setEta4(JSPUtil.getParameter(request, "eta4", ""));
		setShpr3(JSPUtil.getParameter(request, "shpr3", ""));
		setName5(JSPUtil.getParameter(request, "name5", ""));
		setName3(JSPUtil.getParameter(request, "name3", ""));
		setName4(JSPUtil.getParameter(request, "name4", ""));
		setBlkstwg(JSPUtil.getParameter(request, "blkstwg", ""));
		setFrtTerm(JSPUtil.getParameter(request, "frt_term", ""));
		setEwgt(JSPUtil.getParameter(request, "ewgt", ""));
		setUnlc4(JSPUtil.getParameter(request, "unlc4", ""));
		setEdiGroupId(JSPUtil.getParameter(request, "edi_group_id", ""));
		setUnlc5(JSPUtil.getParameter(request, "unlc5", ""));
		setOldloyd(JSPUtil.getParameter(request, "oldloyd", ""));
		setBkgnbr(JSPUtil.getParameter(request, "bkgnbr", ""));
		setName1(JSPUtil.getParameter(request, "name1", ""));
		setName2(JSPUtil.getParameter(request, "name2", ""));
		setUnlc1(JSPUtil.getParameter(request, "unlc1", ""));
		setUnlc2(JSPUtil.getParameter(request, "unlc2", ""));
		setRfCa(JSPUtil.getParameter(request, "rf_ca", ""));
		setUnlc3(JSPUtil.getParameter(request, "unlc3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectEdiMstVO[]
	 */
	public RejectEdiMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectEdiMstVO[]
	 */
	public RejectEdiMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RejectEdiMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bed3 = (JSPUtil.getParameter(request, prefix	+ "bed3", length));
			String[] olddir = (JSPUtil.getParameter(request, prefix	+ "olddir", length));
			String[] tloyd = (JSPUtil.getParameter(request, prefix	+ "tloyd", length));
			String[] salesName = (JSPUtil.getParameter(request, prefix	+ "sales_name", length));
			String[] drInd = (JSPUtil.getParameter(request, prefix	+ "dr_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldvslname = (JSPUtil.getParameter(request, prefix	+ "oldvslname", length));
			String[] regionalBkgnbr = (JSPUtil.getParameter(request, prefix	+ "regional_bkgnbr", length));
			String[] oldvsl = (JSPUtil.getParameter(request, prefix	+ "oldvsl", length));
			String[] pucyCd = (JSPUtil.getParameter(request, prefix	+ "pucy_cd", length));
			String[] cne1 = (JSPUtil.getParameter(request, prefix	+ "cne1", length));
			String[] rtcyAddr5 = (JSPUtil.getParameter(request, prefix	+ "rtcy_addr5", length));
			String[] rtcyAddr4 = (JSPUtil.getParameter(request, prefix	+ "rtcy_addr4", length));
			String[] rtcyAddr3 = (JSPUtil.getParameter(request, prefix	+ "rtcy_addr3", length));
			String[] rtcyAddr2 = (JSPUtil.getParameter(request, prefix	+ "rtcy_addr2", length));
			String[] rtcyCnt = (JSPUtil.getParameter(request, prefix	+ "rtcy_cnt", length));
			String[] loyd = (JSPUtil.getParameter(request, prefix	+ "loyd", length));
			String[] rtcyAddr1 = (JSPUtil.getParameter(request, prefix	+ "rtcy_addr1", length));
			String[] etd4 = (JSPUtil.getParameter(request, prefix	+ "etd4", length));
			String[] etd3 = (JSPUtil.getParameter(request, prefix	+ "etd3", length));
			String[] etd2 = (JSPUtil.getParameter(request, prefix	+ "etd2", length));
			String[] oldvslCallSign = (JSPUtil.getParameter(request, prefix	+ "oldvsl_call_sign", length));
			String[] todir = (JSPUtil.getParameter(request, prefix	+ "todir", length));
			String[] cmd = (JSPUtil.getParameter(request, prefix	+ "cmd", length));
			String[] vslCallSign = (JSPUtil.getParameter(request, prefix	+ "vsl_call_sign", length));
			String[] rfInd = (JSPUtil.getParameter(request, prefix	+ "rf_ind", length));
			String[] contactName = (JSPUtil.getParameter(request, prefix	+ "contact_name", length));
			String[] rdtyp = (JSPUtil.getParameter(request, prefix	+ "rdtyp", length));
			String[] rdUnd = (JSPUtil.getParameter(request, prefix	+ "rd_und", length));
			String[] tovsl = (JSPUtil.getParameter(request, prefix	+ "tovsl", length));
			String[] ibIeInd = (JSPUtil.getParameter(request, prefix	+ "ib_ie_ind", length));
			String[] eqpickdt = (JSPUtil.getParameter(request, prefix	+ "eqpickdt", length));
			String[] tovoy = (JSPUtil.getParameter(request, prefix	+ "tovoy", length));
			String[] socInd = (JSPUtil.getParameter(request, prefix	+ "soc_ind", length));
			String[] shCd1 = (JSPUtil.getParameter(request, prefix	+ "sh_cd1", length));
			String[] truck = (JSPUtil.getParameter(request, prefix	+ "truck", length));
			String[] ffCd1 = (JSPUtil.getParameter(request, prefix	+ "ff_cd1", length));
			String[] tvsl = (JSPUtil.getParameter(request, prefix	+ "tvsl", length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype", length));
			String[] rtcyCd = (JSPUtil.getParameter(request, prefix	+ "rtcy_cd", length));
			String[] tdir = (JSPUtil.getParameter(request, prefix	+ "tdir", length));
			String[] port4 = (JSPUtil.getParameter(request, prefix	+ "port4", length));
			String[] bkgStf = (JSPUtil.getParameter(request, prefix	+ "bkg_stf", length));
			String[] port3 = (JSPUtil.getParameter(request, prefix	+ "port3", length));
			String[] rejDesc = (JSPUtil.getParameter(request, prefix	+ "rej_desc", length));
			String[] port2 = (JSPUtil.getParameter(request, prefix	+ "port2", length));
			String[] port1 = (JSPUtil.getParameter(request, prefix	+ "port1", length));
			String[] port5 = (JSPUtil.getParameter(request, prefix	+ "port5", length));
			String[] akInd = (JSPUtil.getParameter(request, prefix	+ "ak_ind", length));
			String[] qual5 = (JSPUtil.getParameter(request, prefix	+ "qual5", length));
			String[] qual4 = (JSPUtil.getParameter(request, prefix	+ "qual4", length));
			String[] qual3 = (JSPUtil.getParameter(request, prefix	+ "qual3", length));
			String[] qual2 = (JSPUtil.getParameter(request, prefix	+ "qual2", length));
			String[] qual1 = (JSPUtil.getParameter(request, prefix	+ "qual1", length));
			String[] tvslname = (JSPUtil.getParameter(request, prefix	+ "tvslname", length));
			String[] cnCd1 = (JSPUtil.getParameter(request, prefix	+ "cn_cd1", length));
			String[] brac = (JSPUtil.getParameter(request, prefix	+ "brac", length));
			String[] bkgStfFax = (JSPUtil.getParameter(request, prefix	+ "bkg_stf_fax", length));
			String[] cct2 = (JSPUtil.getParameter(request, prefix	+ "cct2", length));
			String[] eqrel = (JSPUtil.getParameter(request, prefix	+ "eqrel", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] blPoNo = (JSPUtil.getParameter(request, prefix	+ "bl_po_no", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] vpsCctDt = (JSPUtil.getParameter(request, prefix	+ "vps_cct_dt", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] punit = (JSPUtil.getParameter(request, prefix	+ "punit", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			String[] eqrtn = (JSPUtil.getParameter(request, prefix	+ "eqrtn", length));
			String[] vsld = (JSPUtil.getParameter(request, prefix	+ "vsld", length));
			String[] cmdd = (JSPUtil.getParameter(request, prefix	+ "cmdd", length));
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "sales_office", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] munit = (JSPUtil.getParameter(request, prefix	+ "munit", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] udInd = (JSPUtil.getParameter(request, prefix	+ "ud_ind", length));
			String[] tvoy = (JSPUtil.getParameter(request, prefix	+ "tvoy", length));
			String[] oldvoy = (JSPUtil.getParameter(request, prefix	+ "oldvoy", length));
			String[] pucyCnt = (JSPUtil.getParameter(request, prefix	+ "pucy_cnt", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfMa = (JSPUtil.getParameter(request, prefix	+ "rf_ma", length));
			String[] bkgStfName = (JSPUtil.getParameter(request, prefix	+ "bkg_stf_name", length));
			String[] hdInd = (JSPUtil.getParameter(request, prefix	+ "hd_ind", length));
			String[] custRefNo = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no", length));
			String[] udCd = (JSPUtil.getParameter(request, prefix	+ "ud_cd", length));
			String[] cancelBit = (JSPUtil.getParameter(request, prefix	+ "cancel_bit", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] ewunit = (JSPUtil.getParameter(request, prefix	+ "ewunit", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] bvLane = (JSPUtil.getParameter(request, prefix	+ "bv_lane", length));
			String[] pkg = (JSPUtil.getParameter(request, prefix	+ "pkg", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] boundInd = (JSPUtil.getParameter(request, prefix	+ "bound_ind", length));
			String[] refVoyage = (JSPUtil.getParameter(request, prefix	+ "ref_voyage", length));
			String[] cfmInd = (JSPUtil.getParameter(request, prefix	+ "cfm_ind", length));
			String[] smod = (JSPUtil.getParameter(request, prefix	+ "smod", length));
			String[] vslname = (JSPUtil.getParameter(request, prefix	+ "vslname", length));
			String[] bbInd = (JSPUtil.getParameter(request, prefix	+ "bb_ind", length));
			String[] contactTel = (JSPUtil.getParameter(request, prefix	+ "contact_tel", length));
			String[] vslld = (JSPUtil.getParameter(request, prefix	+ "vslld", length));
			String[] rtcyNm = (JSPUtil.getParameter(request, prefix	+ "rtcy_nm", length));
			String[] vvdRefNo = (JSPUtil.getParameter(request, prefix	+ "vvd_ref_no", length));
			String[] eta31 = (JSPUtil.getParameter(request, prefix	+ "eta3_1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] tvslCallSign = (JSPUtil.getParameter(request, prefix	+ "tvsl_call_sign", length));
			String[] meas = (JSPUtil.getParameter(request, prefix	+ "meas", length));
			String[] pucyNm = (JSPUtil.getParameter(request, prefix	+ "pucy_nm", length));
			String[] wunit = (JSPUtil.getParameter(request, prefix	+ "wunit", length));
			String[] blSiNo = (JSPUtil.getParameter(request, prefix	+ "bl_si_no", length));
			String[] bkgLane = (JSPUtil.getParameter(request, prefix	+ "bkg_lane", length));
			String[] bkgDt = (JSPUtil.getParameter(request, prefix	+ "bkg_dt", length));
			String[] bkgStfTel = (JSPUtil.getParameter(request, prefix	+ "bkg_stf_tel", length));
			String[] onboard = (JSPUtil.getParameter(request, prefix	+ "onboard", length));
			String[] pucyAddr2 = (JSPUtil.getParameter(request, prefix	+ "pucy_addr2", length));
			String[] pucyAddr3 = (JSPUtil.getParameter(request, prefix	+ "pucy_addr3", length));
			String[] ffn1 = (JSPUtil.getParameter(request, prefix	+ "ffn1", length));
			String[] pucyAddr1 = (JSPUtil.getParameter(request, prefix	+ "pucy_addr1", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] shn1 = (JSPUtil.getParameter(request, prefix	+ "shn1", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] pucyAddr4 = (JSPUtil.getParameter(request, prefix	+ "pucy_addr4", length));
			String[] pucyAddr5 = (JSPUtil.getParameter(request, prefix	+ "pucy_addr5", length));
			String[] eta3 = (JSPUtil.getParameter(request, prefix	+ "eta3", length));
			String[] eta2 = (JSPUtil.getParameter(request, prefix	+ "eta2", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] eta4 = (JSPUtil.getParameter(request, prefix	+ "eta4", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] name5 = (JSPUtil.getParameter(request, prefix	+ "name5", length));
			String[] name3 = (JSPUtil.getParameter(request, prefix	+ "name3", length));
			String[] name4 = (JSPUtil.getParameter(request, prefix	+ "name4", length));
			String[] blkstwg = (JSPUtil.getParameter(request, prefix	+ "blkstwg", length));
			String[] frtTerm = (JSPUtil.getParameter(request, prefix	+ "frt_term", length));
			String[] ewgt = (JSPUtil.getParameter(request, prefix	+ "ewgt", length));
			String[] unlc4 = (JSPUtil.getParameter(request, prefix	+ "unlc4", length));
			String[] ediGroupId = (JSPUtil.getParameter(request, prefix	+ "edi_group_id", length));
			String[] unlc5 = (JSPUtil.getParameter(request, prefix	+ "unlc5", length));
			String[] oldloyd = (JSPUtil.getParameter(request, prefix	+ "oldloyd", length));
			String[] bkgnbr = (JSPUtil.getParameter(request, prefix	+ "bkgnbr", length));
			String[] name1 = (JSPUtil.getParameter(request, prefix	+ "name1", length));
			String[] name2 = (JSPUtil.getParameter(request, prefix	+ "name2", length));
			String[] unlc1 = (JSPUtil.getParameter(request, prefix	+ "unlc1", length));
			String[] unlc2 = (JSPUtil.getParameter(request, prefix	+ "unlc2", length));
			String[] rfCa = (JSPUtil.getParameter(request, prefix	+ "rf_ca", length));
			String[] unlc3 = (JSPUtil.getParameter(request, prefix	+ "unlc3", length));
			
			for (int i = 0; i < length; i++) {
				model = new RejectEdiMstVO();
				if (bed3[i] != null)
					model.setBed3(bed3[i]);
				if (olddir[i] != null)
					model.setOlddir(olddir[i]);
				if (tloyd[i] != null)
					model.setTloyd(tloyd[i]);
				if (salesName[i] != null)
					model.setSalesName(salesName[i]);
				if (drInd[i] != null)
					model.setDrInd(drInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldvslname[i] != null)
					model.setOldvslname(oldvslname[i]);
				if (regionalBkgnbr[i] != null)
					model.setRegionalBkgnbr(regionalBkgnbr[i]);
				if (oldvsl[i] != null)
					model.setOldvsl(oldvsl[i]);
				if (pucyCd[i] != null)
					model.setPucyCd(pucyCd[i]);
				if (cne1[i] != null)
					model.setCne1(cne1[i]);
				if (rtcyAddr5[i] != null)
					model.setRtcyAddr5(rtcyAddr5[i]);
				if (rtcyAddr4[i] != null)
					model.setRtcyAddr4(rtcyAddr4[i]);
				if (rtcyAddr3[i] != null)
					model.setRtcyAddr3(rtcyAddr3[i]);
				if (rtcyAddr2[i] != null)
					model.setRtcyAddr2(rtcyAddr2[i]);
				if (rtcyCnt[i] != null)
					model.setRtcyCnt(rtcyCnt[i]);
				if (loyd[i] != null)
					model.setLoyd(loyd[i]);
				if (rtcyAddr1[i] != null)
					model.setRtcyAddr1(rtcyAddr1[i]);
				if (etd4[i] != null)
					model.setEtd4(etd4[i]);
				if (etd3[i] != null)
					model.setEtd3(etd3[i]);
				if (etd2[i] != null)
					model.setEtd2(etd2[i]);
				if (oldvslCallSign[i] != null)
					model.setOldvslCallSign(oldvslCallSign[i]);
				if (todir[i] != null)
					model.setTodir(todir[i]);
				if (cmd[i] != null)
					model.setCmd(cmd[i]);
				if (vslCallSign[i] != null)
					model.setVslCallSign(vslCallSign[i]);
				if (rfInd[i] != null)
					model.setRfInd(rfInd[i]);
				if (contactName[i] != null)
					model.setContactName(contactName[i]);
				if (rdtyp[i] != null)
					model.setRdtyp(rdtyp[i]);
				if (rdUnd[i] != null)
					model.setRdUnd(rdUnd[i]);
				if (tovsl[i] != null)
					model.setTovsl(tovsl[i]);
				if (ibIeInd[i] != null)
					model.setIbIeInd(ibIeInd[i]);
				if (eqpickdt[i] != null)
					model.setEqpickdt(eqpickdt[i]);
				if (tovoy[i] != null)
					model.setTovoy(tovoy[i]);
				if (socInd[i] != null)
					model.setSocInd(socInd[i]);
				if (shCd1[i] != null)
					model.setShCd1(shCd1[i]);
				if (truck[i] != null)
					model.setTruck(truck[i]);
				if (ffCd1[i] != null)
					model.setFfCd1(ffCd1[i]);
				if (tvsl[i] != null)
					model.setTvsl(tvsl[i]);
				if (cargotype[i] != null)
					model.setCargotype(cargotype[i]);
				if (rtcyCd[i] != null)
					model.setRtcyCd(rtcyCd[i]);
				if (tdir[i] != null)
					model.setTdir(tdir[i]);
				if (port4[i] != null)
					model.setPort4(port4[i]);
				if (bkgStf[i] != null)
					model.setBkgStf(bkgStf[i]);
				if (port3[i] != null)
					model.setPort3(port3[i]);
				if (rejDesc[i] != null)
					model.setRejDesc(rejDesc[i]);
				if (port2[i] != null)
					model.setPort2(port2[i]);
				if (port1[i] != null)
					model.setPort1(port1[i]);
				if (port5[i] != null)
					model.setPort5(port5[i]);
				if (akInd[i] != null)
					model.setAkInd(akInd[i]);
				if (qual5[i] != null)
					model.setQual5(qual5[i]);
				if (qual4[i] != null)
					model.setQual4(qual4[i]);
				if (qual3[i] != null)
					model.setQual3(qual3[i]);
				if (qual2[i] != null)
					model.setQual2(qual2[i]);
				if (qual1[i] != null)
					model.setQual1(qual1[i]);
				if (tvslname[i] != null)
					model.setTvslname(tvslname[i]);
				if (cnCd1[i] != null)
					model.setCnCd1(cnCd1[i]);
				if (brac[i] != null)
					model.setBrac(brac[i]);
				if (bkgStfFax[i] != null)
					model.setBkgStfFax(bkgStfFax[i]);
				if (cct2[i] != null)
					model.setCct2(cct2[i]);
				if (eqrel[i] != null)
					model.setEqrel(eqrel[i]);
				if (ntfy5[i] != null)
					model.setNtfy5(ntfy5[i]);
				if (ntfy4[i] != null)
					model.setNtfy4(ntfy4[i]);
				if (blPoNo[i] != null)
					model.setBlPoNo(blPoNo[i]);
				if (ntfy3[i] != null)
					model.setNtfy3(ntfy3[i]);
				if (vpsCctDt[i] != null)
					model.setVpsCctDt(vpsCctDt[i]);
				if (ntfy2[i] != null)
					model.setNtfy2(ntfy2[i]);
				if (punit[i] != null)
					model.setPunit(punit[i]);
				if (ntfy1[i] != null)
					model.setNtfy1(ntfy1[i]);
				if (eqrtn[i] != null)
					model.setEqrtn(eqrtn[i]);
				if (vsld[i] != null)
					model.setVsld(vsld[i]);
				if (cmdd[i] != null)
					model.setCmdd(cmdd[i]);
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (munit[i] != null)
					model.setMunit(munit[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (udInd[i] != null)
					model.setUdInd(udInd[i]);
				if (tvoy[i] != null)
					model.setTvoy(tvoy[i]);
				if (oldvoy[i] != null)
					model.setOldvoy(oldvoy[i]);
				if (pucyCnt[i] != null)
					model.setPucyCnt(pucyCnt[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfMa[i] != null)
					model.setRfMa(rfMa[i]);
				if (bkgStfName[i] != null)
					model.setBkgStfName(bkgStfName[i]);
				if (hdInd[i] != null)
					model.setHdInd(hdInd[i]);
				if (custRefNo[i] != null)
					model.setCustRefNo(custRefNo[i]);
				if (udCd[i] != null)
					model.setUdCd(udCd[i]);
				if (cancelBit[i] != null)
					model.setCancelBit(cancelBit[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (cnee5[i] != null)
					model.setCnee5(cnee5[i]);
				if (ewunit[i] != null)
					model.setEwunit(ewunit[i]);
				if (cnee3[i] != null)
					model.setCnee3(cnee3[i]);
				if (cnee4[i] != null)
					model.setCnee4(cnee4[i]);
				if (cnee1[i] != null)
					model.setCnee1(cnee1[i]);
				if (bvLane[i] != null)
					model.setBvLane(bvLane[i]);
				if (pkg[i] != null)
					model.setPkg(pkg[i]);
				if (cnee2[i] != null)
					model.setCnee2(cnee2[i]);
				if (boundInd[i] != null)
					model.setBoundInd(boundInd[i]);
				if (refVoyage[i] != null)
					model.setRefVoyage(refVoyage[i]);
				if (cfmInd[i] != null)
					model.setCfmInd(cfmInd[i]);
				if (smod[i] != null)
					model.setSmod(smod[i]);
				if (vslname[i] != null)
					model.setVslname(vslname[i]);
				if (bbInd[i] != null)
					model.setBbInd(bbInd[i]);
				if (contactTel[i] != null)
					model.setContactTel(contactTel[i]);
				if (vslld[i] != null)
					model.setVslld(vslld[i]);
				if (rtcyNm[i] != null)
					model.setRtcyNm(rtcyNm[i]);
				if (vvdRefNo[i] != null)
					model.setVvdRefNo(vvdRefNo[i]);
				if (eta31[i] != null)
					model.setEta31(eta31[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (tvslCallSign[i] != null)
					model.setTvslCallSign(tvslCallSign[i]);
				if (meas[i] != null)
					model.setMeas(meas[i]);
				if (pucyNm[i] != null)
					model.setPucyNm(pucyNm[i]);
				if (wunit[i] != null)
					model.setWunit(wunit[i]);
				if (blSiNo[i] != null)
					model.setBlSiNo(blSiNo[i]);
				if (bkgLane[i] != null)
					model.setBkgLane(bkgLane[i]);
				if (bkgDt[i] != null)
					model.setBkgDt(bkgDt[i]);
				if (bkgStfTel[i] != null)
					model.setBkgStfTel(bkgStfTel[i]);
				if (onboard[i] != null)
					model.setOnboard(onboard[i]);
				if (pucyAddr2[i] != null)
					model.setPucyAddr2(pucyAddr2[i]);
				if (pucyAddr3[i] != null)
					model.setPucyAddr3(pucyAddr3[i]);
				if (ffn1[i] != null)
					model.setFfn1(ffn1[i]);
				if (pucyAddr1[i] != null)
					model.setPucyAddr1(pucyAddr1[i]);
				if (shpr2[i] != null)
					model.setShpr2(shpr2[i]);
				if (shn1[i] != null)
					model.setShn1(shn1[i]);
				if (shpr1[i] != null)
					model.setShpr1(shpr1[i]);
				if (pucyAddr4[i] != null)
					model.setPucyAddr4(pucyAddr4[i]);
				if (pucyAddr5[i] != null)
					model.setPucyAddr5(pucyAddr5[i]);
				if (eta3[i] != null)
					model.setEta3(eta3[i]);
				if (eta2[i] != null)
					model.setEta2(eta2[i]);
				if (shpr5[i] != null)
					model.setShpr5(shpr5[i]);
				if (shpr4[i] != null)
					model.setShpr4(shpr4[i]);
				if (eta4[i] != null)
					model.setEta4(eta4[i]);
				if (shpr3[i] != null)
					model.setShpr3(shpr3[i]);
				if (name5[i] != null)
					model.setName5(name5[i]);
				if (name3[i] != null)
					model.setName3(name3[i]);
				if (name4[i] != null)
					model.setName4(name4[i]);
				if (blkstwg[i] != null)
					model.setBlkstwg(blkstwg[i]);
				if (frtTerm[i] != null)
					model.setFrtTerm(frtTerm[i]);
				if (ewgt[i] != null)
					model.setEwgt(ewgt[i]);
				if (unlc4[i] != null)
					model.setUnlc4(unlc4[i]);
				if (ediGroupId[i] != null)
					model.setEdiGroupId(ediGroupId[i]);
				if (unlc5[i] != null)
					model.setUnlc5(unlc5[i]);
				if (oldloyd[i] != null)
					model.setOldloyd(oldloyd[i]);
				if (bkgnbr[i] != null)
					model.setBkgnbr(bkgnbr[i]);
				if (name1[i] != null)
					model.setName1(name1[i]);
				if (name2[i] != null)
					model.setName2(name2[i]);
				if (unlc1[i] != null)
					model.setUnlc1(unlc1[i]);
				if (unlc2[i] != null)
					model.setUnlc2(unlc2[i]);
				if (rfCa[i] != null)
					model.setRfCa(rfCa[i]);
				if (unlc3[i] != null)
					model.setUnlc3(unlc3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRejectEdiMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RejectEdiMstVO[]
	 */
	public RejectEdiMstVO[] getRejectEdiMstVOs(){
		RejectEdiMstVO[] vos = (RejectEdiMstVO[])models.toArray(new RejectEdiMstVO[models.size()]);
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
		this.bed3 = this.bed3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.olddir = this.olddir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tloyd = this.tloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesName = this.salesName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drInd = this.drInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldvslname = this.oldvslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionalBkgnbr = this.regionalBkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldvsl = this.oldvsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyCd = this.pucyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cne1 = this.cne1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyAddr5 = this.rtcyAddr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyAddr4 = this.rtcyAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyAddr3 = this.rtcyAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyAddr2 = this.rtcyAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyCnt = this.rtcyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loyd = this.loyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyAddr1 = this.rtcyAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd4 = this.etd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd3 = this.etd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd2 = this.etd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldvslCallSign = this.oldvslCallSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todir = this.todir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmd = this.cmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallSign = this.vslCallSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfInd = this.rfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactName = this.contactName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtyp = this.rdtyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdUnd = this.rdUnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tovsl = this.tovsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibIeInd = this.ibIeInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqpickdt = this.eqpickdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tovoy = this.tovoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socInd = this.socInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCd1 = this.shCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.truck = this.truck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCd1 = this.ffCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvsl = this.tvsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyCd = this.rtcyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tdir = this.tdir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port4 = this.port4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStf = this.bkgStf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port3 = this.port3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejDesc = this.rejDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port2 = this.port2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port1 = this.port1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port5 = this.port5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akInd = this.akInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qual5 = this.qual5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qual4 = this.qual4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qual3 = this.qual3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qual2 = this.qual2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qual1 = this.qual1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvslname = this.tvslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCd1 = this.cnCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brac = this.brac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStfFax = this.bkgStfFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct2 = this.cct2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrel = this.eqrel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPoNo = this.blPoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsCctDt = this.vpsCctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.punit = this.punit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrtn = this.eqrtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsld = this.vsld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdd = this.cmdd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.munit = this.munit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udInd = this.udInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvoy = this.tvoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldvoy = this.oldvoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyCnt = this.pucyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMa = this.rfMa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStfName = this.bkgStfName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdInd = this.hdInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRefNo = this.custRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.udCd = this.udCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelBit = this.cancelBit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ewunit = this.ewunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvLane = this.bvLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkg = this.pkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundInd = this.boundInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVoyage = this.refVoyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmInd = this.cfmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smod = this.smod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslname = this.vslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbInd = this.bbInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactTel = this.contactTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslld = this.vslld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtcyNm = this.rtcyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRefNo = this.vvdRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta31 = this.eta31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvslCallSign = this.tvslCallSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meas = this.meas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyNm = this.pucyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wunit = this.wunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSiNo = this.blSiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgLane = this.bkgLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDt = this.bkgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStfTel = this.bkgStfTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onboard = this.onboard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyAddr2 = this.pucyAddr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyAddr3 = this.pucyAddr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffn1 = this.ffn1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyAddr1 = this.pucyAddr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shn1 = this.shn1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyAddr4 = this.pucyAddr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pucyAddr5 = this.pucyAddr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta3 = this.eta3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta2 = this.eta2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta4 = this.eta4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name5 = this.name5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name3 = this.name3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name4 = this.name4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blkstwg = this.blkstwg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTerm = this.frtTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ewgt = this.ewgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unlc4 = this.unlc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGroupId = this.ediGroupId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unlc5 = this.unlc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldloyd = this.oldloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnbr = this.bkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name1 = this.name1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name2 = this.name2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unlc1 = this.unlc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unlc2 = this.unlc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCa = this.rfCa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unlc3 = this.unlc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
