/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExCntrTransmitBlInfoVO.java
*@FileTitle : ExCntrTransmitBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.20
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExCntrTransmitBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ExCntrTransmitBlInfoVO> models = new ArrayList<ExCntrTransmitBlInfoVO>();

	/* Column Info */
	private String salesName = null;
	/* Column Info */
	private String msncfm = null;
	/* Column Info */
	private String ntfy25 = null;
	/* Column Info */
	private String delAms = null;
	/* Column Info */
	private String blcmd = null;
	/* Column Info */
	private String ntfy21 = null;
	/* Column Info */
	private String ntfy22 = null;
	/* Column Info */
	private String bldel = null;
	/* Column Info */
	private String ntfy23 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntfy24 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String dgFlag = null;
	/* Column Info */
	private String rlyFullname = null;
	/* Column Info */
	private String shprcd = null;
	/* Column Info */
	private String contactName = null;
	/* Column Info */
	private String blplace = null;
	/* Column Info */
	private String blnbr = null;
	/* Column Info */
	private String bldate = null;
	/* Column Info */
	private String ppdofc = null;
	/* Column Info */
	private String eqpickdt = null;
	/* Column Info */
	private String blpkg = null;
	/* Column Info */
	private String localIpi = null;
	/* Column Info */
	private String ntfy2cd = null;
	/* Column Info */
	private String podFullname = null;
	/* Column Info */
	private String tranMode = null;
	/* Column Info */
	private String shprcn = null;
	/* Column Info */
	private String cargotype = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String porFullname = null;
	/* Column Info */
	private String srnbr = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String thdofc = null;
	/* Column Info */
	private String blrly = null;
	/* Column Info */
	private String rgnBkgnbr = null;
	/* Column Info */
	private String scno = null;
	/* Column Info */
	private String expo1 = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String brac = null;
	/* Column Info */
	private String eqrel = null;
	/* Column Info */
	private String ntfy5 = null;
	/* Column Info */
	private String ntfy4 = null;
	/* Column Info */
	private String cmdesc = null;
	/* Column Info */
	private String ntfy3 = null;
	/* Column Info */
	private String ntfy2 = null;
	/* Column Info */
	private String ntfy1 = null;
	/* Column Info */
	private String eqrtn = null;
	/* Column Info */
	private String ntfy2cn = null;
	/* Column Info */
	private String polAms = null;
	/* Column Info */
	private String salesOffice = null;
	/* Column Info */
	private String ffwdcd = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String blpkgu = null;
	/* Column Info */
	private String forwardCd = null;
	/* Column Info */
	private String cctofc = null;
	/* Column Info */
	private String ffwdcn = null;
	/* Column Info */
	private String blmea = null;
	/* Column Info */
	private String podAms = null;
	/* Column Info */
	private String haulMode = null;
	/* Column Info */
	private String expo5 = null;
	/* Column Info */
	private String expo4 = null;
	/* Column Info */
	private String expo3 = null;
	/* Column Info */
	private String expo2 = null;
	/* Column Info */
	private String finalEta = null;
	/* Column Info */
	private String msn = null;
	/* Column Info */
	private String cnee5 = null;
	/* Column Info */
	private String cnee3 = null;
	/* Column Info */
	private String blrepcmd = null;
	/* Column Info */
	private String cnee4 = null;
	/* Column Info */
	private String expocd = null;
	/* Column Info */
	private String cnee1 = null;
	/* Column Info */
	private String ntfycn = null;
	/* Column Info */
	private String cnee2 = null;
	/* Column Info */
	private String expocn = null;
	/* Column Info */
	private String custrefNum = null;
	/* Column Info */
	private String rcFlag = null;
	/* Column Info */
	private String bbFlag = null;
	/* Column Info */
	private String blpod = null;
	/* Column Info */
	private String blorg = null;
	/* Column Info */
	private String blWgtUnit = null;
	/* Column Info */
	private String cneecn = null;
	/* Column Info */
	private String blpor = null;
	/* Column Info */
	private String ausQuar = null;
	/* Column Info */
	private String rdFlag = null;
	/* Column Info */
	private String blpol = null;
	/* Column Info */
	private String blMeaUnit = null;
	/* Column Info */
	private String ntfycd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ffwd5 = null;
	/* Column Info */
	private String blrepcmdcd = null;
	/* Column Info */
	private String ffwd2 = null;
	/* Column Info */
	private String cneecd = null;
	/* Column Info */
	private String ffwd1 = null;
	/* Column Info */
	private String ffwd4 = null;
	/* Column Info */
	private String ffwd3 = null;
	/* Column Info */
	private String akFlag = null;
	/* Column Info */
	private String onboard = null;
	/* Column Info */
	private String polFullname = null;
	/* Column Info */
	private String waybillInd = null;
	/* Column Info */
	private String blts = null;
	/* Column Info */
	private String bltp = null;
	/* Column Info */
	private String funcCode = null;
	/* Column Info */
	private String shpr2 = null;
	/* Column Info */
	private String shpr1 = null;
	/* Column Info */
	private String blwgt = null;
	/* Column Info */
	private String rlyAms = null;
	/* Column Info */
	private String shpr5 = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String shpr4 = null;
	/* Column Info */
	private String shpr3 = null;
	/* Column Info */
	private String porAms = null;
	/* Column Info */
	private String commodity = null;
	/* Column Info */
	private String bkgnbr = null;
	/* Column Info */
	private String delFullname = null;
	/* Column Info */
	private String blcopy = null;
	/* Column Info */
	private String rfano = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ExCntrTransmitBlInfoVO() {}

	public ExCntrTransmitBlInfoVO(String ibflag, String pagerows, String blnbr, String blpol, String polAms, String polFullname, String blpod, String podAms, String podFullname, String blpor, String porAms, String porFullname, String bldel, String delAms, String delFullname, String blrly, String rlyAms, String rlyFullname, String blplace, String bldate, String brac, String pol, String pod, String haulMode, String tranMode, String forwardCd, String salesOffice, String salesName, String contactName, String shprcn, String shprcd, String shpr1, String shpr2, String shpr3, String shpr4, String shpr5, String cneecn, String cneecd, String cnee1, String cnee2, String cnee3, String cnee4, String cnee5, String ntfycn, String ntfycd, String ntfy1, String ntfy2, String ntfy3, String ntfy4, String ntfy5, String ntfy2cn, String ntfy2cd, String ntfy21, String ntfy22, String ntfy23, String ntfy24, String ntfy25, String ffwdcn, String ffwdcd, String ffwd1, String ffwd2, String ffwd3, String ffwd4, String ffwd5, String expocn, String expocd, String expo1, String expo2, String expo3, String expo4, String expo5, String blcopy, String blorg, String blpkg, String blpkgu, String blwgt, String blWgtUnit, String blmea, String blMeaUnit, String rdtype, String cargotype, String commodity, String blcmd, String blrepcmdcd, String blrepcmd, String remark, String ausQuar, String srnbr, String bkgnbr, String rgnBkgnbr, String ppdofc, String cctofc, String thdofc, String scno, String rfano, String waybillInd, String custrefNum, String finalEta, String funcCode, String onboard, String invNo, String blts, String bltp, String msn, String msncfm, String cmdesc, String localIpi, String eqrel, String eqpickdt, String eqrtn, String bkgCgoTp, String dgFlag, String rcFlag, String akFlag, String bbFlag, String rdFlag, String cmdtCd, String cmdtNm) {
		this.salesName = salesName;
		this.msncfm = msncfm;
		this.ntfy25 = ntfy25;
		this.delAms = delAms;
		this.blcmd = blcmd;
		this.ntfy21 = ntfy21;
		this.ntfy22 = ntfy22;
		this.bldel = bldel;
		this.ntfy23 = ntfy23;
		this.pagerows = pagerows;
		this.ntfy24 = ntfy24;
		this.pol = pol;
		this.pod = pod;
		this.bkgCgoTp = bkgCgoTp;
		this.dgFlag = dgFlag;
		this.rlyFullname = rlyFullname;
		this.shprcd = shprcd;
		this.contactName = contactName;
		this.blplace = blplace;
		this.blnbr = blnbr;
		this.bldate = bldate;
		this.ppdofc = ppdofc;
		this.eqpickdt = eqpickdt;
		this.blpkg = blpkg;
		this.localIpi = localIpi;
		this.ntfy2cd = ntfy2cd;
		this.podFullname = podFullname;
		this.tranMode = tranMode;
		this.shprcn = shprcn;
		this.cargotype = cargotype;
		this.cmdtCd = cmdtCd;
		this.porFullname = porFullname;
		this.srnbr = srnbr;
		this.rdtype = rdtype;
		this.thdofc = thdofc;
		this.blrly = blrly;
		this.rgnBkgnbr = rgnBkgnbr;
		this.scno = scno;
		this.expo1 = expo1;
		this.invNo = invNo;
		this.brac = brac;
		this.eqrel = eqrel;
		this.ntfy5 = ntfy5;
		this.ntfy4 = ntfy4;
		this.cmdesc = cmdesc;
		this.ntfy3 = ntfy3;
		this.ntfy2 = ntfy2;
		this.ntfy1 = ntfy1;
		this.eqrtn = eqrtn;
		this.ntfy2cn = ntfy2cn;
		this.polAms = polAms;
		this.salesOffice = salesOffice;
		this.ffwdcd = ffwdcd;
		this.remark = remark;
		this.blpkgu = blpkgu;
		this.forwardCd = forwardCd;
		this.cctofc = cctofc;
		this.ffwdcn = ffwdcn;
		this.blmea = blmea;
		this.podAms = podAms;
		this.haulMode = haulMode;
		this.expo5 = expo5;
		this.expo4 = expo4;
		this.expo3 = expo3;
		this.expo2 = expo2;
		this.finalEta = finalEta;
		this.msn = msn;
		this.cnee5 = cnee5;
		this.cnee3 = cnee3;
		this.blrepcmd = blrepcmd;
		this.cnee4 = cnee4;
		this.expocd = expocd;
		this.cnee1 = cnee1;
		this.ntfycn = ntfycn;
		this.cnee2 = cnee2;
		this.expocn = expocn;
		this.custrefNum = custrefNum;
		this.rcFlag = rcFlag;
		this.bbFlag = bbFlag;
		this.blpod = blpod;
		this.blorg = blorg;
		this.blWgtUnit = blWgtUnit;
		this.cneecn = cneecn;
		this.blpor = blpor;
		this.ausQuar = ausQuar;
		this.rdFlag = rdFlag;
		this.blpol = blpol;
		this.blMeaUnit = blMeaUnit;
		this.ntfycd = ntfycd;
		this.ibflag = ibflag;
		this.ffwd5 = ffwd5;
		this.blrepcmdcd = blrepcmdcd;
		this.ffwd2 = ffwd2;
		this.cneecd = cneecd;
		this.ffwd1 = ffwd1;
		this.ffwd4 = ffwd4;
		this.ffwd3 = ffwd3;
		this.akFlag = akFlag;
		this.onboard = onboard;
		this.polFullname = polFullname;
		this.waybillInd = waybillInd;
		this.blts = blts;
		this.bltp = bltp;
		this.funcCode = funcCode;
		this.shpr2 = shpr2;
		this.shpr1 = shpr1;
		this.blwgt = blwgt;
		this.rlyAms = rlyAms;
		this.shpr5 = shpr5;
		this.cmdtNm = cmdtNm;
		this.shpr4 = shpr4;
		this.shpr3 = shpr3;
		this.porAms = porAms;
		this.commodity = commodity;
		this.bkgnbr = bkgnbr;
		this.delFullname = delFullname;
		this.blcopy = blcopy;
		this.rfano = rfano;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sales_name", getSalesName());
		this.hashColumns.put("msncfm", getMsncfm());
		this.hashColumns.put("ntfy25", getNtfy25());
		this.hashColumns.put("del_ams", getDelAms());
		this.hashColumns.put("blcmd", getBlcmd());
		this.hashColumns.put("ntfy21", getNtfy21());
		this.hashColumns.put("ntfy22", getNtfy22());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("ntfy23", getNtfy23());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntfy24", getNtfy24());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("dg_flag", getDgFlag());
		this.hashColumns.put("rly_fullname", getRlyFullname());
		this.hashColumns.put("shprcd", getShprcd());
		this.hashColumns.put("contact_name", getContactName());
		this.hashColumns.put("blplace", getBlplace());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("bldate", getBldate());
		this.hashColumns.put("ppdofc", getPpdofc());
		this.hashColumns.put("eqpickdt", getEqpickdt());
		this.hashColumns.put("blpkg", getBlpkg());
		this.hashColumns.put("local_ipi", getLocalIpi());
		this.hashColumns.put("ntfy2cd", getNtfy2cd());
		this.hashColumns.put("pod_fullname", getPodFullname());
		this.hashColumns.put("tran_mode", getTranMode());
		this.hashColumns.put("shprcn", getShprcn());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("por_fullname", getPorFullname());
		this.hashColumns.put("srnbr", getSrnbr());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("thdofc", getThdofc());
		this.hashColumns.put("blrly", getBlrly());
		this.hashColumns.put("rgn_bkgnbr", getRgnBkgnbr());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("expo1", getExpo1());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("brac", getBrac());
		this.hashColumns.put("eqrel", getEqrel());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("cmdesc", getCmdesc());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("ntfy1", getNtfy1());
		this.hashColumns.put("eqrtn", getEqrtn());
		this.hashColumns.put("ntfy2cn", getNtfy2cn());
		this.hashColumns.put("pol_ams", getPolAms());
		this.hashColumns.put("sales_office", getSalesOffice());
		this.hashColumns.put("ffwdcd", getFfwdcd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("blpkgu", getBlpkgu());
		this.hashColumns.put("forward_cd", getForwardCd());
		this.hashColumns.put("cctofc", getCctofc());
		this.hashColumns.put("ffwdcn", getFfwdcn());
		this.hashColumns.put("blmea", getBlmea());
		this.hashColumns.put("pod_ams", getPodAms());
		this.hashColumns.put("haul_mode", getHaulMode());
		this.hashColumns.put("expo5", getExpo5());
		this.hashColumns.put("expo4", getExpo4());
		this.hashColumns.put("expo3", getExpo3());
		this.hashColumns.put("expo2", getExpo2());
		this.hashColumns.put("final_eta", getFinalEta());
		this.hashColumns.put("msn", getMsn());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("blrepcmd", getBlrepcmd());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("expocd", getExpocd());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("ntfycn", getNtfycn());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("expocn", getExpocn());
		this.hashColumns.put("custref_num", getCustrefNum());
		this.hashColumns.put("rc_flag", getRcFlag());
		this.hashColumns.put("bb_flag", getBbFlag());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("blorg", getBlorg());
		this.hashColumns.put("bl_wgt_unit", getBlWgtUnit());
		this.hashColumns.put("cneecn", getCneecn());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("aus_quar", getAusQuar());
		this.hashColumns.put("rd_flag", getRdFlag());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("bl_mea_unit", getBlMeaUnit());
		this.hashColumns.put("ntfycd", getNtfycd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ffwd5", getFfwd5());
		this.hashColumns.put("blrepcmdcd", getBlrepcmdcd());
		this.hashColumns.put("ffwd2", getFfwd2());
		this.hashColumns.put("cneecd", getCneecd());
		this.hashColumns.put("ffwd1", getFfwd1());
		this.hashColumns.put("ffwd4", getFfwd4());
		this.hashColumns.put("ffwd3", getFfwd3());
		this.hashColumns.put("ak_flag", getAkFlag());
		this.hashColumns.put("onboard", getOnboard());
		this.hashColumns.put("pol_fullname", getPolFullname());
		this.hashColumns.put("waybill_ind", getWaybillInd());
		this.hashColumns.put("blts", getBlts());
		this.hashColumns.put("bltp", getBltp());
		this.hashColumns.put("func_code", getFuncCode());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("blwgt", getBlwgt());
		this.hashColumns.put("rly_ams", getRlyAms());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("por_ams", getPorAms());
		this.hashColumns.put("commodity", getCommodity());
		this.hashColumns.put("bkgnbr", getBkgnbr());
		this.hashColumns.put("del_fullname", getDelFullname());
		this.hashColumns.put("blcopy", getBlcopy());
		this.hashColumns.put("rfano", getRfano());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sales_name", "salesName");
		this.hashFields.put("msncfm", "msncfm");
		this.hashFields.put("ntfy25", "ntfy25");
		this.hashFields.put("del_ams", "delAms");
		this.hashFields.put("blcmd", "blcmd");
		this.hashFields.put("ntfy21", "ntfy21");
		this.hashFields.put("ntfy22", "ntfy22");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("ntfy23", "ntfy23");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntfy24", "ntfy24");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("dg_flag", "dgFlag");
		this.hashFields.put("rly_fullname", "rlyFullname");
		this.hashFields.put("shprcd", "shprcd");
		this.hashFields.put("contact_name", "contactName");
		this.hashFields.put("blplace", "blplace");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("bldate", "bldate");
		this.hashFields.put("ppdofc", "ppdofc");
		this.hashFields.put("eqpickdt", "eqpickdt");
		this.hashFields.put("blpkg", "blpkg");
		this.hashFields.put("local_ipi", "localIpi");
		this.hashFields.put("ntfy2cd", "ntfy2cd");
		this.hashFields.put("pod_fullname", "podFullname");
		this.hashFields.put("tran_mode", "tranMode");
		this.hashFields.put("shprcn", "shprcn");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("por_fullname", "porFullname");
		this.hashFields.put("srnbr", "srnbr");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("thdofc", "thdofc");
		this.hashFields.put("blrly", "blrly");
		this.hashFields.put("rgn_bkgnbr", "rgnBkgnbr");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("expo1", "expo1");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("brac", "brac");
		this.hashFields.put("eqrel", "eqrel");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("cmdesc", "cmdesc");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("ntfy1", "ntfy1");
		this.hashFields.put("eqrtn", "eqrtn");
		this.hashFields.put("ntfy2cn", "ntfy2cn");
		this.hashFields.put("pol_ams", "polAms");
		this.hashFields.put("sales_office", "salesOffice");
		this.hashFields.put("ffwdcd", "ffwdcd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("blpkgu", "blpkgu");
		this.hashFields.put("forward_cd", "forwardCd");
		this.hashFields.put("cctofc", "cctofc");
		this.hashFields.put("ffwdcn", "ffwdcn");
		this.hashFields.put("blmea", "blmea");
		this.hashFields.put("pod_ams", "podAms");
		this.hashFields.put("haul_mode", "haulMode");
		this.hashFields.put("expo5", "expo5");
		this.hashFields.put("expo4", "expo4");
		this.hashFields.put("expo3", "expo3");
		this.hashFields.put("expo2", "expo2");
		this.hashFields.put("final_eta", "finalEta");
		this.hashFields.put("msn", "msn");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("blrepcmd", "blrepcmd");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("expocd", "expocd");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("ntfycn", "ntfycn");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("expocn", "expocn");
		this.hashFields.put("custref_num", "custrefNum");
		this.hashFields.put("rc_flag", "rcFlag");
		this.hashFields.put("bb_flag", "bbFlag");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("blorg", "blorg");
		this.hashFields.put("bl_wgt_unit", "blWgtUnit");
		this.hashFields.put("cneecn", "cneecn");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("aus_quar", "ausQuar");
		this.hashFields.put("rd_flag", "rdFlag");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("bl_mea_unit", "blMeaUnit");
		this.hashFields.put("ntfycd", "ntfycd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ffwd5", "ffwd5");
		this.hashFields.put("blrepcmdcd", "blrepcmdcd");
		this.hashFields.put("ffwd2", "ffwd2");
		this.hashFields.put("cneecd", "cneecd");
		this.hashFields.put("ffwd1", "ffwd1");
		this.hashFields.put("ffwd4", "ffwd4");
		this.hashFields.put("ffwd3", "ffwd3");
		this.hashFields.put("ak_flag", "akFlag");
		this.hashFields.put("onboard", "onboard");
		this.hashFields.put("pol_fullname", "polFullname");
		this.hashFields.put("waybill_ind", "waybillInd");
		this.hashFields.put("blts", "blts");
		this.hashFields.put("bltp", "bltp");
		this.hashFields.put("func_code", "funcCode");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("blwgt", "blwgt");
		this.hashFields.put("rly_ams", "rlyAms");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("por_ams", "porAms");
		this.hashFields.put("commodity", "commodity");
		this.hashFields.put("bkgnbr", "bkgnbr");
		this.hashFields.put("del_fullname", "delFullname");
		this.hashFields.put("blcopy", "blcopy");
		this.hashFields.put("rfano", "rfano");
		return this.hashFields;
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
	 * @return msncfm
	 */
	public String getMsncfm() {
		return this.msncfm;
	}

	/**
	 * Column Info
	 * @return ntfy25
	 */
	public String getNtfy25() {
		return this.ntfy25;
	}

	/**
	 * Column Info
	 * @return delAms
	 */
	public String getDelAms() {
		return this.delAms;
	}

	/**
	 * Column Info
	 * @return blcmd
	 */
	public String getBlcmd() {
		return this.blcmd;
	}

	/**
	 * Column Info
	 * @return ntfy21
	 */
	public String getNtfy21() {
		return this.ntfy21;
	}

	/**
	 * Column Info
	 * @return ntfy22
	 */
	public String getNtfy22() {
		return this.ntfy22;
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
	 * @return ntfy23
	 */
	public String getNtfy23() {
		return this.ntfy23;
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
	 * @return ntfy24
	 */
	public String getNtfy24() {
		return this.ntfy24;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}

	/**
	 * Column Info
	 * @return bkgCgoTp
	 */
	public String getBkgCgoTp() {
		return this.bkgCgoTp;
	}

	/**
	 * Column Info
	 * @return dgFlag
	 */
	public String getDgFlag() {
		return this.dgFlag;
	}

	/**
	 * Column Info
	 * @return rlyFullname
	 */
	public String getRlyFullname() {
		return this.rlyFullname;
	}

	/**
	 * Column Info
	 * @return shprcd
	 */
	public String getShprcd() {
		return this.shprcd;
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
	 * @return blplace
	 */
	public String getBlplace() {
		return this.blplace;
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
	 * @return bldate
	 */
	public String getBldate() {
		return this.bldate;
	}

	/**
	 * Column Info
	 * @return ppdofc
	 */
	public String getPpdofc() {
		return this.ppdofc;
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
	 * @return blpkg
	 */
	public String getBlpkg() {
		return this.blpkg;
	}

	/**
	 * Column Info
	 * @return localIpi
	 */
	public String getLocalIpi() {
		return this.localIpi;
	}

	/**
	 * Column Info
	 * @return ntfy2cd
	 */
	public String getNtfy2cd() {
		return this.ntfy2cd;
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
	 * @return tranMode
	 */
	public String getTranMode() {
		return this.tranMode;
	}

	/**
	 * Column Info
	 * @return shprcn
	 */
	public String getShprcn() {
		return this.shprcn;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return porFullname
	 */
	public String getPorFullname() {
		return this.porFullname;
	}

	/**
	 * Column Info
	 * @return srnbr
	 */
	public String getSrnbr() {
		return this.srnbr;
	}

	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}

	/**
	 * Column Info
	 * @return thdofc
	 */
	public String getThdofc() {
		return this.thdofc;
	}

	/**
	 * Column Info
	 * @return blrly
	 */
	public String getBlrly() {
		return this.blrly;
	}

	/**
	 * Column Info
	 * @return rgnBkgnbr
	 */
	public String getRgnBkgnbr() {
		return this.rgnBkgnbr;
	}

	/**
	 * Column Info
	 * @return scno
	 */
	public String getScno() {
		return this.scno;
	}

	/**
	 * Column Info
	 * @return expo1
	 */
	public String getExpo1() {
		return this.expo1;
	}

	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return cmdesc
	 */
	public String getCmdesc() {
		return this.cmdesc;
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
	 * @return ntfy2
	 */
	public String getNtfy2() {
		return this.ntfy2;
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
	 * @return ntfy2cn
	 */
	public String getNtfy2cn() {
		return this.ntfy2cn;
	}

	/**
	 * Column Info
	 * @return polAms
	 */
	public String getPolAms() {
		return this.polAms;
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
	 * @return ffwdcd
	 */
	public String getFfwdcd() {
		return this.ffwdcd;
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
	 * @return blpkgu
	 */
	public String getBlpkgu() {
		return this.blpkgu;
	}

	/**
	 * Column Info
	 * @return forwardCd
	 */
	public String getForwardCd() {
		return this.forwardCd;
	}

	/**
	 * Column Info
	 * @return cctofc
	 */
	public String getCctofc() {
		return this.cctofc;
	}

	/**
	 * Column Info
	 * @return ffwdcn
	 */
	public String getFfwdcn() {
		return this.ffwdcn;
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
	 * @return podAms
	 */
	public String getPodAms() {
		return this.podAms;
	}

	/**
	 * Column Info
	 * @return haulMode
	 */
	public String getHaulMode() {
		return this.haulMode;
	}

	/**
	 * Column Info
	 * @return expo5
	 */
	public String getExpo5() {
		return this.expo5;
	}

	/**
	 * Column Info
	 * @return expo4
	 */
	public String getExpo4() {
		return this.expo4;
	}

	/**
	 * Column Info
	 * @return expo3
	 */
	public String getExpo3() {
		return this.expo3;
	}

	/**
	 * Column Info
	 * @return expo2
	 */
	public String getExpo2() {
		return this.expo2;
	}

	/**
	 * Column Info
	 * @return finalEta
	 */
	public String getFinalEta() {
		return this.finalEta;
	}

	/**
	 * Column Info
	 * @return msn
	 */
	public String getMsn() {
		return this.msn;
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
	 * @return cnee3
	 */
	public String getCnee3() {
		return this.cnee3;
	}

	/**
	 * Column Info
	 * @return blrepcmd
	 */
	public String getBlrepcmd() {
		return this.blrepcmd;
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
	 * @return expocd
	 */
	public String getExpocd() {
		return this.expocd;
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
	 * @return ntfycn
	 */
	public String getNtfycn() {
		return this.ntfycn;
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
	 * @return expocn
	 */
	public String getExpocn() {
		return this.expocn;
	}

	/**
	 * Column Info
	 * @return custrefNum
	 */
	public String getCustrefNum() {
		return this.custrefNum;
	}

	/**
	 * Column Info
	 * @return rcFlag
	 */
	public String getRcFlag() {
		return this.rcFlag;
	}

	/**
	 * Column Info
	 * @return bbFlag
	 */
	public String getBbFlag() {
		return this.bbFlag;
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
	 * @return blorg
	 */
	public String getBlorg() {
		return this.blorg;
	}

	/**
	 * Column Info
	 * @return blWgtUnit
	 */
	public String getBlWgtUnit() {
		return this.blWgtUnit;
	}

	/**
	 * Column Info
	 * @return cneecn
	 */
	public String getCneecn() {
		return this.cneecn;
	}

	/**
	 * Column Info
	 * @return blpor
	 */
	public String getBlpor() {
		return this.blpor;
	}

	/**
	 * Column Info
	 * @return ausQuar
	 */
	public String getAusQuar() {
		return this.ausQuar;
	}

	/**
	 * Column Info
	 * @return rdFlag
	 */
	public String getRdFlag() {
		return this.rdFlag;
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
	 * @return blMeaUnit
	 */
	public String getBlMeaUnit() {
		return this.blMeaUnit;
	}

	/**
	 * Column Info
	 * @return ntfycd
	 */
	public String getNtfycd() {
		return this.ntfycd;
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
	 * @return ffwd5
	 */
	public String getFfwd5() {
		return this.ffwd5;
	}

	/**
	 * Column Info
	 * @return blrepcmdcd
	 */
	public String getBlrepcmdcd() {
		return this.blrepcmdcd;
	}

	/**
	 * Column Info
	 * @return ffwd2
	 */
	public String getFfwd2() {
		return this.ffwd2;
	}

	/**
	 * Column Info
	 * @return cneecd
	 */
	public String getCneecd() {
		return this.cneecd;
	}

	/**
	 * Column Info
	 * @return ffwd1
	 */
	public String getFfwd1() {
		return this.ffwd1;
	}

	/**
	 * Column Info
	 * @return ffwd4
	 */
	public String getFfwd4() {
		return this.ffwd4;
	}

	/**
	 * Column Info
	 * @return ffwd3
	 */
	public String getFfwd3() {
		return this.ffwd3;
	}

	/**
	 * Column Info
	 * @return akFlag
	 */
	public String getAkFlag() {
		return this.akFlag;
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
	 * @return polFullname
	 */
	public String getPolFullname() {
		return this.polFullname;
	}

	/**
	 * Column Info
	 * @return waybillInd
	 */
	public String getWaybillInd() {
		return this.waybillInd;
	}

	/**
	 * Column Info
	 * @return blts
	 */
	public String getBlts() {
		return this.blts;
	}

	/**
	 * Column Info
	 * @return bltp
	 */
	public String getBltp() {
		return this.bltp;
	}

	/**
	 * Column Info
	 * @return funcCode
	 */
	public String getFuncCode() {
		return this.funcCode;
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
	 * @return shpr1
	 */
	public String getShpr1() {
		return this.shpr1;
	}

	/**
	 * Column Info
	 * @return blwgt
	 */
	public String getBlwgt() {
		return this.blwgt;
	}

	/**
	 * Column Info
	 * @return rlyAms
	 */
	public String getRlyAms() {
		return this.rlyAms;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return shpr3
	 */
	public String getShpr3() {
		return this.shpr3;
	}

	/**
	 * Column Info
	 * @return porAms
	 */
	public String getPorAms() {
		return this.porAms;
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
	 * @return bkgnbr
	 */
	public String getBkgnbr() {
		return this.bkgnbr;
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
	 * @return blcopy
	 */
	public String getBlcopy() {
		return this.blcopy;
	}

	/**
	 * Column Info
	 * @return rfano
	 */
	public String getRfano() {
		return this.rfano;
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
	 * @param msncfm
	 */
	public void setMsncfm(String msncfm) {
		this.msncfm = msncfm;
	}

	/**
	 * Column Info
	 * @param ntfy25
	 */
	public void setNtfy25(String ntfy25) {
		this.ntfy25 = ntfy25;
	}

	/**
	 * Column Info
	 * @param delAms
	 */
	public void setDelAms(String delAms) {
		this.delAms = delAms;
	}

	/**
	 * Column Info
	 * @param blcmd
	 */
	public void setBlcmd(String blcmd) {
		this.blcmd = blcmd;
	}

	/**
	 * Column Info
	 * @param ntfy21
	 */
	public void setNtfy21(String ntfy21) {
		this.ntfy21 = ntfy21;
	}

	/**
	 * Column Info
	 * @param ntfy22
	 */
	public void setNtfy22(String ntfy22) {
		this.ntfy22 = ntfy22;
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
	 * @param ntfy23
	 */
	public void setNtfy23(String ntfy23) {
		this.ntfy23 = ntfy23;
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
	 * @param ntfy24
	 */
	public void setNtfy24(String ntfy24) {
		this.ntfy24 = ntfy24;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * Column Info
	 * @param bkgCgoTp
	 */
	public void setBkgCgoTp(String bkgCgoTp) {
		this.bkgCgoTp = bkgCgoTp;
	}

	/**
	 * Column Info
	 * @param dgFlag
	 */
	public void setDgFlag(String dgFlag) {
		this.dgFlag = dgFlag;
	}

	/**
	 * Column Info
	 * @param rlyFullname
	 */
	public void setRlyFullname(String rlyFullname) {
		this.rlyFullname = rlyFullname;
	}

	/**
	 * Column Info
	 * @param shprcd
	 */
	public void setShprcd(String shprcd) {
		this.shprcd = shprcd;
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
	 * @param blplace
	 */
	public void setBlplace(String blplace) {
		this.blplace = blplace;
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
	 * @param bldate
	 */
	public void setBldate(String bldate) {
		this.bldate = bldate;
	}

	/**
	 * Column Info
	 * @param ppdofc
	 */
	public void setPpdofc(String ppdofc) {
		this.ppdofc = ppdofc;
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
	 * @param blpkg
	 */
	public void setBlpkg(String blpkg) {
		this.blpkg = blpkg;
	}

	/**
	 * Column Info
	 * @param localIpi
	 */
	public void setLocalIpi(String localIpi) {
		this.localIpi = localIpi;
	}

	/**
	 * Column Info
	 * @param ntfy2cd
	 */
	public void setNtfy2cd(String ntfy2cd) {
		this.ntfy2cd = ntfy2cd;
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
	 * @param tranMode
	 */
	public void setTranMode(String tranMode) {
		this.tranMode = tranMode;
	}

	/**
	 * Column Info
	 * @param shprcn
	 */
	public void setShprcn(String shprcn) {
		this.shprcn = shprcn;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * @param porFullname
	 */
	public void setPorFullname(String porFullname) {
		this.porFullname = porFullname;
	}

	/**
	 * Column Info
	 * @param srnbr
	 */
	public void setSrnbr(String srnbr) {
		this.srnbr = srnbr;
	}

	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}

	/**
	 * Column Info
	 * @param thdofc
	 */
	public void setThdofc(String thdofc) {
		this.thdofc = thdofc;
	}

	/**
	 * Column Info
	 * @param blrly
	 */
	public void setBlrly(String blrly) {
		this.blrly = blrly;
	}

	/**
	 * Column Info
	 * @param rgnBkgnbr
	 */
	public void setRgnBkgnbr(String rgnBkgnbr) {
		this.rgnBkgnbr = rgnBkgnbr;
	}

	/**
	 * Column Info
	 * @param scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}

	/**
	 * Column Info
	 * @param expo1
	 */
	public void setExpo1(String expo1) {
		this.expo1 = expo1;
	}

	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param cmdesc
	 */
	public void setCmdesc(String cmdesc) {
		this.cmdesc = cmdesc;
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
	 * @param ntfy2
	 */
	public void setNtfy2(String ntfy2) {
		this.ntfy2 = ntfy2;
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
	 * @param ntfy2cn
	 */
	public void setNtfy2cn(String ntfy2cn) {
		this.ntfy2cn = ntfy2cn;
	}

	/**
	 * Column Info
	 * @param polAms
	 */
	public void setPolAms(String polAms) {
		this.polAms = polAms;
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
	 * @param ffwdcd
	 */
	public void setFfwdcd(String ffwdcd) {
		this.ffwdcd = ffwdcd;
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
	 * @param blpkgu
	 */
	public void setBlpkgu(String blpkgu) {
		this.blpkgu = blpkgu;
	}

	/**
	 * Column Info
	 * @param forwardCd
	 */
	public void setForwardCd(String forwardCd) {
		this.forwardCd = forwardCd;
	}

	/**
	 * Column Info
	 * @param cctofc
	 */
	public void setCctofc(String cctofc) {
		this.cctofc = cctofc;
	}

	/**
	 * Column Info
	 * @param ffwdcn
	 */
	public void setFfwdcn(String ffwdcn) {
		this.ffwdcn = ffwdcn;
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
	 * @param podAms
	 */
	public void setPodAms(String podAms) {
		this.podAms = podAms;
	}

	/**
	 * Column Info
	 * @param haulMode
	 */
	public void setHaulMode(String haulMode) {
		this.haulMode = haulMode;
	}

	/**
	 * Column Info
	 * @param expo5
	 */
	public void setExpo5(String expo5) {
		this.expo5 = expo5;
	}

	/**
	 * Column Info
	 * @param expo4
	 */
	public void setExpo4(String expo4) {
		this.expo4 = expo4;
	}

	/**
	 * Column Info
	 * @param expo3
	 */
	public void setExpo3(String expo3) {
		this.expo3 = expo3;
	}

	/**
	 * Column Info
	 * @param expo2
	 */
	public void setExpo2(String expo2) {
		this.expo2 = expo2;
	}

	/**
	 * Column Info
	 * @param finalEta
	 */
	public void setFinalEta(String finalEta) {
		this.finalEta = finalEta;
	}

	/**
	 * Column Info
	 * @param msn
	 */
	public void setMsn(String msn) {
		this.msn = msn;
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
	 * @param cnee3
	 */
	public void setCnee3(String cnee3) {
		this.cnee3 = cnee3;
	}

	/**
	 * Column Info
	 * @param blrepcmd
	 */
	public void setBlrepcmd(String blrepcmd) {
		this.blrepcmd = blrepcmd;
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
	 * @param expocd
	 */
	public void setExpocd(String expocd) {
		this.expocd = expocd;
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
	 * @param ntfycn
	 */
	public void setNtfycn(String ntfycn) {
		this.ntfycn = ntfycn;
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
	 * @param expocn
	 */
	public void setExpocn(String expocn) {
		this.expocn = expocn;
	}

	/**
	 * Column Info
	 * @param custrefNum
	 */
	public void setCustrefNum(String custrefNum) {
		this.custrefNum = custrefNum;
	}

	/**
	 * Column Info
	 * @param rcFlag
	 */
	public void setRcFlag(String rcFlag) {
		this.rcFlag = rcFlag;
	}

	/**
	 * Column Info
	 * @param bbFlag
	 */
	public void setBbFlag(String bbFlag) {
		this.bbFlag = bbFlag;
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
	 * @param blorg
	 */
	public void setBlorg(String blorg) {
		this.blorg = blorg;
	}

	/**
	 * Column Info
	 * @param blWgtUnit
	 */
	public void setBlWgtUnit(String blWgtUnit) {
		this.blWgtUnit = blWgtUnit;
	}

	/**
	 * Column Info
	 * @param cneecn
	 */
	public void setCneecn(String cneecn) {
		this.cneecn = cneecn;
	}

	/**
	 * Column Info
	 * @param blpor
	 */
	public void setBlpor(String blpor) {
		this.blpor = blpor;
	}

	/**
	 * Column Info
	 * @param ausQuar
	 */
	public void setAusQuar(String ausQuar) {
		this.ausQuar = ausQuar;
	}

	/**
	 * Column Info
	 * @param rdFlag
	 */
	public void setRdFlag(String rdFlag) {
		this.rdFlag = rdFlag;
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
	 * @param blMeaUnit
	 */
	public void setBlMeaUnit(String blMeaUnit) {
		this.blMeaUnit = blMeaUnit;
	}

	/**
	 * Column Info
	 * @param ntfycd
	 */
	public void setNtfycd(String ntfycd) {
		this.ntfycd = ntfycd;
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
	 * @param ffwd5
	 */
	public void setFfwd5(String ffwd5) {
		this.ffwd5 = ffwd5;
	}

	/**
	 * Column Info
	 * @param blrepcmdcd
	 */
	public void setBlrepcmdcd(String blrepcmdcd) {
		this.blrepcmdcd = blrepcmdcd;
	}

	/**
	 * Column Info
	 * @param ffwd2
	 */
	public void setFfwd2(String ffwd2) {
		this.ffwd2 = ffwd2;
	}

	/**
	 * Column Info
	 * @param cneecd
	 */
	public void setCneecd(String cneecd) {
		this.cneecd = cneecd;
	}

	/**
	 * Column Info
	 * @param ffwd1
	 */
	public void setFfwd1(String ffwd1) {
		this.ffwd1 = ffwd1;
	}

	/**
	 * Column Info
	 * @param ffwd4
	 */
	public void setFfwd4(String ffwd4) {
		this.ffwd4 = ffwd4;
	}

	/**
	 * Column Info
	 * @param ffwd3
	 */
	public void setFfwd3(String ffwd3) {
		this.ffwd3 = ffwd3;
	}

	/**
	 * Column Info
	 * @param akFlag
	 */
	public void setAkFlag(String akFlag) {
		this.akFlag = akFlag;
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
	 * @param polFullname
	 */
	public void setPolFullname(String polFullname) {
		this.polFullname = polFullname;
	}

	/**
	 * Column Info
	 * @param waybillInd
	 */
	public void setWaybillInd(String waybillInd) {
		this.waybillInd = waybillInd;
	}

	/**
	 * Column Info
	 * @param blts
	 */
	public void setBlts(String blts) {
		this.blts = blts;
	}

	/**
	 * Column Info
	 * @param bltp
	 */
	public void setBltp(String bltp) {
		this.bltp = bltp;
	}

	/**
	 * Column Info
	 * @param funcCode
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
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
	 * @param shpr1
	 */
	public void setShpr1(String shpr1) {
		this.shpr1 = shpr1;
	}

	/**
	 * Column Info
	 * @param blwgt
	 */
	public void setBlwgt(String blwgt) {
		this.blwgt = blwgt;
	}

	/**
	 * Column Info
	 * @param rlyAms
	 */
	public void setRlyAms(String rlyAms) {
		this.rlyAms = rlyAms;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param shpr3
	 */
	public void setShpr3(String shpr3) {
		this.shpr3 = shpr3;
	}

	/**
	 * Column Info
	 * @param porAms
	 */
	public void setPorAms(String porAms) {
		this.porAms = porAms;
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
	 * @param bkgnbr
	 */
	public void setBkgnbr(String bkgnbr) {
		this.bkgnbr = bkgnbr;
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
	 * @param blcopy
	 */
	public void setBlcopy(String blcopy) {
		this.blcopy = blcopy;
	}

	/**
	 * Column Info
	 * @param rfano
	 */
	public void setRfano(String rfano) {
		this.rfano = rfano;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSalesName(JSPUtil.getParameter(request, "sales_name", ""));
		setMsncfm(JSPUtil.getParameter(request, "msncfm", ""));
		setNtfy25(JSPUtil.getParameter(request, "ntfy25", ""));
		setDelAms(JSPUtil.getParameter(request, "del_ams", ""));
		setBlcmd(JSPUtil.getParameter(request, "blcmd", ""));
		setNtfy21(JSPUtil.getParameter(request, "ntfy21", ""));
		setNtfy22(JSPUtil.getParameter(request, "ntfy22", ""));
		setBldel(JSPUtil.getParameter(request, "bldel", ""));
		setNtfy23(JSPUtil.getParameter(request, "ntfy23", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNtfy24(JSPUtil.getParameter(request, "ntfy24", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, "bkg_cgo_tp", ""));
		setDgFlag(JSPUtil.getParameter(request, "dg_flag", ""));
		setRlyFullname(JSPUtil.getParameter(request, "rly_fullname", ""));
		setShprcd(JSPUtil.getParameter(request, "shprcd", ""));
		setContactName(JSPUtil.getParameter(request, "contact_name", ""));
		setBlplace(JSPUtil.getParameter(request, "blplace", ""));
		setBlnbr(JSPUtil.getParameter(request, "blnbr", ""));
		setBldate(JSPUtil.getParameter(request, "bldate", ""));
		setPpdofc(JSPUtil.getParameter(request, "ppdofc", ""));
		setEqpickdt(JSPUtil.getParameter(request, "eqpickdt", ""));
		setBlpkg(JSPUtil.getParameter(request, "blpkg", ""));
		setLocalIpi(JSPUtil.getParameter(request, "local_ipi", ""));
		setNtfy2cd(JSPUtil.getParameter(request, "ntfy2cd", ""));
		setPodFullname(JSPUtil.getParameter(request, "pod_fullname", ""));
		setTranMode(JSPUtil.getParameter(request, "tran_mode", ""));
		setShprcn(JSPUtil.getParameter(request, "shprcn", ""));
		setCargotype(JSPUtil.getParameter(request, "cargotype", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setPorFullname(JSPUtil.getParameter(request, "por_fullname", ""));
		setSrnbr(JSPUtil.getParameter(request, "srnbr", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setThdofc(JSPUtil.getParameter(request, "thdofc", ""));
		setBlrly(JSPUtil.getParameter(request, "blrly", ""));
		setRgnBkgnbr(JSPUtil.getParameter(request, "rgn_bkgnbr", ""));
		setScno(JSPUtil.getParameter(request, "scno", ""));
		setExpo1(JSPUtil.getParameter(request, "expo1", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setBrac(JSPUtil.getParameter(request, "brac", ""));
		setEqrel(JSPUtil.getParameter(request, "eqrel", ""));
		setNtfy5(JSPUtil.getParameter(request, "ntfy5", ""));
		setNtfy4(JSPUtil.getParameter(request, "ntfy4", ""));
		setCmdesc(JSPUtil.getParameter(request, "cmdesc", ""));
		setNtfy3(JSPUtil.getParameter(request, "ntfy3", ""));
		setNtfy2(JSPUtil.getParameter(request, "ntfy2", ""));
		setNtfy1(JSPUtil.getParameter(request, "ntfy1", ""));
		setEqrtn(JSPUtil.getParameter(request, "eqrtn", ""));
		setNtfy2cn(JSPUtil.getParameter(request, "ntfy2cn", ""));
		setPolAms(JSPUtil.getParameter(request, "pol_ams", ""));
		setSalesOffice(JSPUtil.getParameter(request, "sales_office", ""));
		setFfwdcd(JSPUtil.getParameter(request, "ffwdcd", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setBlpkgu(JSPUtil.getParameter(request, "blpkgu", ""));
		setForwardCd(JSPUtil.getParameter(request, "forward_cd", ""));
		setCctofc(JSPUtil.getParameter(request, "cctofc", ""));
		setFfwdcn(JSPUtil.getParameter(request, "ffwdcn", ""));
		setBlmea(JSPUtil.getParameter(request, "blmea", ""));
		setPodAms(JSPUtil.getParameter(request, "pod_ams", ""));
		setHaulMode(JSPUtil.getParameter(request, "haul_mode", ""));
		setExpo5(JSPUtil.getParameter(request, "expo5", ""));
		setExpo4(JSPUtil.getParameter(request, "expo4", ""));
		setExpo3(JSPUtil.getParameter(request, "expo3", ""));
		setExpo2(JSPUtil.getParameter(request, "expo2", ""));
		setFinalEta(JSPUtil.getParameter(request, "final_eta", ""));
		setMsn(JSPUtil.getParameter(request, "msn", ""));
		setCnee5(JSPUtil.getParameter(request, "cnee5", ""));
		setCnee3(JSPUtil.getParameter(request, "cnee3", ""));
		setBlrepcmd(JSPUtil.getParameter(request, "blrepcmd", ""));
		setCnee4(JSPUtil.getParameter(request, "cnee4", ""));
		setExpocd(JSPUtil.getParameter(request, "expocd", ""));
		setCnee1(JSPUtil.getParameter(request, "cnee1", ""));
		setNtfycn(JSPUtil.getParameter(request, "ntfycn", ""));
		setCnee2(JSPUtil.getParameter(request, "cnee2", ""));
		setExpocn(JSPUtil.getParameter(request, "expocn", ""));
		setCustrefNum(JSPUtil.getParameter(request, "custref_num", ""));
		setRcFlag(JSPUtil.getParameter(request, "rc_flag", ""));
		setBbFlag(JSPUtil.getParameter(request, "bb_flag", ""));
		setBlpod(JSPUtil.getParameter(request, "blpod", ""));
		setBlorg(JSPUtil.getParameter(request, "blorg", ""));
		setBlWgtUnit(JSPUtil.getParameter(request, "bl_wgt_unit", ""));
		setCneecn(JSPUtil.getParameter(request, "cneecn", ""));
		setBlpor(JSPUtil.getParameter(request, "blpor", ""));
		setAusQuar(JSPUtil.getParameter(request, "aus_quar", ""));
		setRdFlag(JSPUtil.getParameter(request, "rd_flag", ""));
		setBlpol(JSPUtil.getParameter(request, "blpol", ""));
		setBlMeaUnit(JSPUtil.getParameter(request, "bl_mea_unit", ""));
		setNtfycd(JSPUtil.getParameter(request, "ntfycd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFfwd5(JSPUtil.getParameter(request, "ffwd5", ""));
		setBlrepcmdcd(JSPUtil.getParameter(request, "blrepcmdcd", ""));
		setFfwd2(JSPUtil.getParameter(request, "ffwd2", ""));
		setCneecd(JSPUtil.getParameter(request, "cneecd", ""));
		setFfwd1(JSPUtil.getParameter(request, "ffwd1", ""));
		setFfwd4(JSPUtil.getParameter(request, "ffwd4", ""));
		setFfwd3(JSPUtil.getParameter(request, "ffwd3", ""));
		setAkFlag(JSPUtil.getParameter(request, "ak_flag", ""));
		setOnboard(JSPUtil.getParameter(request, "onboard", ""));
		setPolFullname(JSPUtil.getParameter(request, "pol_fullname", ""));
		setWaybillInd(JSPUtil.getParameter(request, "waybill_ind", ""));
		setBlts(JSPUtil.getParameter(request, "blts", ""));
		setBltp(JSPUtil.getParameter(request, "bltp", ""));
		setFuncCode(JSPUtil.getParameter(request, "func_code", ""));
		setShpr2(JSPUtil.getParameter(request, "shpr2", ""));
		setShpr1(JSPUtil.getParameter(request, "shpr1", ""));
		setBlwgt(JSPUtil.getParameter(request, "blwgt", ""));
		setRlyAms(JSPUtil.getParameter(request, "rly_ams", ""));
		setShpr5(JSPUtil.getParameter(request, "shpr5", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setShpr4(JSPUtil.getParameter(request, "shpr4", ""));
		setShpr3(JSPUtil.getParameter(request, "shpr3", ""));
		setPorAms(JSPUtil.getParameter(request, "por_ams", ""));
		setCommodity(JSPUtil.getParameter(request, "commodity", ""));
		setBkgnbr(JSPUtil.getParameter(request, "bkgnbr", ""));
		setDelFullname(JSPUtil.getParameter(request, "del_fullname", ""));
		setBlcopy(JSPUtil.getParameter(request, "blcopy", ""));
		setRfano(JSPUtil.getParameter(request, "rfano", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExCntrTransmitBlInfoVO[]
	 */
	public ExCntrTransmitBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ExCntrTransmitBlInfoVO[]
	 */
	public ExCntrTransmitBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExCntrTransmitBlInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] salesName = (JSPUtil.getParameter(request, prefix	+ "sales_name", length));
			String[] msncfm = (JSPUtil.getParameter(request, prefix	+ "msncfm", length));
			String[] ntfy25 = (JSPUtil.getParameter(request, prefix	+ "ntfy25", length));
			String[] delAms = (JSPUtil.getParameter(request, prefix	+ "del_ams", length));
			String[] blcmd = (JSPUtil.getParameter(request, prefix	+ "blcmd", length));
			String[] ntfy21 = (JSPUtil.getParameter(request, prefix	+ "ntfy21", length));
			String[] ntfy22 = (JSPUtil.getParameter(request, prefix	+ "ntfy22", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] ntfy23 = (JSPUtil.getParameter(request, prefix	+ "ntfy23", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntfy24 = (JSPUtil.getParameter(request, prefix	+ "ntfy24", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] dgFlag = (JSPUtil.getParameter(request, prefix	+ "dg_flag", length));
			String[] rlyFullname = (JSPUtil.getParameter(request, prefix	+ "rly_fullname", length));
			String[] shprcd = (JSPUtil.getParameter(request, prefix	+ "shprcd", length));
			String[] contactName = (JSPUtil.getParameter(request, prefix	+ "contact_name", length));
			String[] blplace = (JSPUtil.getParameter(request, prefix	+ "blplace", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] bldate = (JSPUtil.getParameter(request, prefix	+ "bldate", length));
			String[] ppdofc = (JSPUtil.getParameter(request, prefix	+ "ppdofc", length));
			String[] eqpickdt = (JSPUtil.getParameter(request, prefix	+ "eqpickdt", length));
			String[] blpkg = (JSPUtil.getParameter(request, prefix	+ "blpkg", length));
			String[] localIpi = (JSPUtil.getParameter(request, prefix	+ "local_ipi", length));
			String[] ntfy2cd = (JSPUtil.getParameter(request, prefix	+ "ntfy2cd", length));
			String[] podFullname = (JSPUtil.getParameter(request, prefix	+ "pod_fullname", length));
			String[] tranMode = (JSPUtil.getParameter(request, prefix	+ "tran_mode", length));
			String[] shprcn = (JSPUtil.getParameter(request, prefix	+ "shprcn", length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] porFullname = (JSPUtil.getParameter(request, prefix	+ "por_fullname", length));
			String[] srnbr = (JSPUtil.getParameter(request, prefix	+ "srnbr", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] thdofc = (JSPUtil.getParameter(request, prefix	+ "thdofc", length));
			String[] blrly = (JSPUtil.getParameter(request, prefix	+ "blrly", length));
			String[] rgnBkgnbr = (JSPUtil.getParameter(request, prefix	+ "rgn_bkgnbr", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] expo1 = (JSPUtil.getParameter(request, prefix	+ "expo1", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] brac = (JSPUtil.getParameter(request, prefix	+ "brac", length));
			String[] eqrel = (JSPUtil.getParameter(request, prefix	+ "eqrel", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] cmdesc = (JSPUtil.getParameter(request, prefix	+ "cmdesc", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			String[] eqrtn = (JSPUtil.getParameter(request, prefix	+ "eqrtn", length));
			String[] ntfy2cn = (JSPUtil.getParameter(request, prefix	+ "ntfy2cn", length));
			String[] polAms = (JSPUtil.getParameter(request, prefix	+ "pol_ams", length));
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "sales_office", length));
			String[] ffwdcd = (JSPUtil.getParameter(request, prefix	+ "ffwdcd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] blpkgu = (JSPUtil.getParameter(request, prefix	+ "blpkgu", length));
			String[] forwardCd = (JSPUtil.getParameter(request, prefix	+ "forward_cd", length));
			String[] cctofc = (JSPUtil.getParameter(request, prefix	+ "cctofc", length));
			String[] ffwdcn = (JSPUtil.getParameter(request, prefix	+ "ffwdcn", length));
			String[] blmea = (JSPUtil.getParameter(request, prefix	+ "blmea", length));
			String[] podAms = (JSPUtil.getParameter(request, prefix	+ "pod_ams", length));
			String[] haulMode = (JSPUtil.getParameter(request, prefix	+ "haul_mode", length));
			String[] expo5 = (JSPUtil.getParameter(request, prefix	+ "expo5", length));
			String[] expo4 = (JSPUtil.getParameter(request, prefix	+ "expo4", length));
			String[] expo3 = (JSPUtil.getParameter(request, prefix	+ "expo3", length));
			String[] expo2 = (JSPUtil.getParameter(request, prefix	+ "expo2", length));
			String[] finalEta = (JSPUtil.getParameter(request, prefix	+ "final_eta", length));
			String[] msn = (JSPUtil.getParameter(request, prefix	+ "msn", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] blrepcmd = (JSPUtil.getParameter(request, prefix	+ "blrepcmd", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] expocd = (JSPUtil.getParameter(request, prefix	+ "expocd", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] ntfycn = (JSPUtil.getParameter(request, prefix	+ "ntfycn", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] expocn = (JSPUtil.getParameter(request, prefix	+ "expocn", length));
			String[] custrefNum = (JSPUtil.getParameter(request, prefix	+ "custref_num", length));
			String[] rcFlag = (JSPUtil.getParameter(request, prefix	+ "rc_flag", length));
			String[] bbFlag = (JSPUtil.getParameter(request, prefix	+ "bb_flag", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] blorg = (JSPUtil.getParameter(request, prefix	+ "blorg", length));
			String[] blWgtUnit = (JSPUtil.getParameter(request, prefix	+ "bl_wgt_unit", length));
			String[] cneecn = (JSPUtil.getParameter(request, prefix	+ "cneecn", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] ausQuar = (JSPUtil.getParameter(request, prefix	+ "aus_quar", length));
			String[] rdFlag = (JSPUtil.getParameter(request, prefix	+ "rd_flag", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] blMeaUnit = (JSPUtil.getParameter(request, prefix	+ "bl_mea_unit", length));
			String[] ntfycd = (JSPUtil.getParameter(request, prefix	+ "ntfycd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ffwd5 = (JSPUtil.getParameter(request, prefix	+ "ffwd5", length));
			String[] blrepcmdcd = (JSPUtil.getParameter(request, prefix	+ "blrepcmdcd", length));
			String[] ffwd2 = (JSPUtil.getParameter(request, prefix	+ "ffwd2", length));
			String[] cneecd = (JSPUtil.getParameter(request, prefix	+ "cneecd", length));
			String[] ffwd1 = (JSPUtil.getParameter(request, prefix	+ "ffwd1", length));
			String[] ffwd4 = (JSPUtil.getParameter(request, prefix	+ "ffwd4", length));
			String[] ffwd3 = (JSPUtil.getParameter(request, prefix	+ "ffwd3", length));
			String[] akFlag = (JSPUtil.getParameter(request, prefix	+ "ak_flag", length));
			String[] onboard = (JSPUtil.getParameter(request, prefix	+ "onboard", length));
			String[] polFullname = (JSPUtil.getParameter(request, prefix	+ "pol_fullname", length));
			String[] waybillInd = (JSPUtil.getParameter(request, prefix	+ "waybill_ind", length));
			String[] blts = (JSPUtil.getParameter(request, prefix	+ "blts", length));
			String[] bltp = (JSPUtil.getParameter(request, prefix	+ "bltp", length));
			String[] funcCode = (JSPUtil.getParameter(request, prefix	+ "func_code", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] blwgt = (JSPUtil.getParameter(request, prefix	+ "blwgt", length));
			String[] rlyAms = (JSPUtil.getParameter(request, prefix	+ "rly_ams", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] porAms = (JSPUtil.getParameter(request, prefix	+ "por_ams", length));
			String[] commodity = (JSPUtil.getParameter(request, prefix	+ "commodity", length));
			String[] bkgnbr = (JSPUtil.getParameter(request, prefix	+ "bkgnbr", length));
			String[] delFullname = (JSPUtil.getParameter(request, prefix	+ "del_fullname", length));
			String[] blcopy = (JSPUtil.getParameter(request, prefix	+ "blcopy", length));
			String[] rfano = (JSPUtil.getParameter(request, prefix	+ "rfano", length));

			for (int i = 0; i < length; i++) {
				model = new ExCntrTransmitBlInfoVO();
				if (salesName[i] != null)
					model.setSalesName(salesName[i]);
				if (msncfm[i] != null)
					model.setMsncfm(msncfm[i]);
				if (ntfy25[i] != null)
					model.setNtfy25(ntfy25[i]);
				if (delAms[i] != null)
					model.setDelAms(delAms[i]);
				if (blcmd[i] != null)
					model.setBlcmd(blcmd[i]);
				if (ntfy21[i] != null)
					model.setNtfy21(ntfy21[i]);
				if (ntfy22[i] != null)
					model.setNtfy22(ntfy22[i]);
				if (bldel[i] != null)
					model.setBldel(bldel[i]);
				if (ntfy23[i] != null)
					model.setNtfy23(ntfy23[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntfy24[i] != null)
					model.setNtfy24(ntfy24[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (dgFlag[i] != null)
					model.setDgFlag(dgFlag[i]);
				if (rlyFullname[i] != null)
					model.setRlyFullname(rlyFullname[i]);
				if (shprcd[i] != null)
					model.setShprcd(shprcd[i]);
				if (contactName[i] != null)
					model.setContactName(contactName[i]);
				if (blplace[i] != null)
					model.setBlplace(blplace[i]);
				if (blnbr[i] != null)
					model.setBlnbr(blnbr[i]);
				if (bldate[i] != null)
					model.setBldate(bldate[i]);
				if (ppdofc[i] != null)
					model.setPpdofc(ppdofc[i]);
				if (eqpickdt[i] != null)
					model.setEqpickdt(eqpickdt[i]);
				if (blpkg[i] != null)
					model.setBlpkg(blpkg[i]);
				if (localIpi[i] != null)
					model.setLocalIpi(localIpi[i]);
				if (ntfy2cd[i] != null)
					model.setNtfy2cd(ntfy2cd[i]);
				if (podFullname[i] != null)
					model.setPodFullname(podFullname[i]);
				if (tranMode[i] != null)
					model.setTranMode(tranMode[i]);
				if (shprcn[i] != null)
					model.setShprcn(shprcn[i]);
				if (cargotype[i] != null)
					model.setCargotype(cargotype[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (porFullname[i] != null)
					model.setPorFullname(porFullname[i]);
				if (srnbr[i] != null)
					model.setSrnbr(srnbr[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (thdofc[i] != null)
					model.setThdofc(thdofc[i]);
				if (blrly[i] != null)
					model.setBlrly(blrly[i]);
				if (rgnBkgnbr[i] != null)
					model.setRgnBkgnbr(rgnBkgnbr[i]);
				if (scno[i] != null)
					model.setScno(scno[i]);
				if (expo1[i] != null)
					model.setExpo1(expo1[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (brac[i] != null)
					model.setBrac(brac[i]);
				if (eqrel[i] != null)
					model.setEqrel(eqrel[i]);
				if (ntfy5[i] != null)
					model.setNtfy5(ntfy5[i]);
				if (ntfy4[i] != null)
					model.setNtfy4(ntfy4[i]);
				if (cmdesc[i] != null)
					model.setCmdesc(cmdesc[i]);
				if (ntfy3[i] != null)
					model.setNtfy3(ntfy3[i]);
				if (ntfy2[i] != null)
					model.setNtfy2(ntfy2[i]);
				if (ntfy1[i] != null)
					model.setNtfy1(ntfy1[i]);
				if (eqrtn[i] != null)
					model.setEqrtn(eqrtn[i]);
				if (ntfy2cn[i] != null)
					model.setNtfy2cn(ntfy2cn[i]);
				if (polAms[i] != null)
					model.setPolAms(polAms[i]);
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (ffwdcd[i] != null)
					model.setFfwdcd(ffwdcd[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (blpkgu[i] != null)
					model.setBlpkgu(blpkgu[i]);
				if (forwardCd[i] != null)
					model.setForwardCd(forwardCd[i]);
				if (cctofc[i] != null)
					model.setCctofc(cctofc[i]);
				if (ffwdcn[i] != null)
					model.setFfwdcn(ffwdcn[i]);
				if (blmea[i] != null)
					model.setBlmea(blmea[i]);
				if (podAms[i] != null)
					model.setPodAms(podAms[i]);
				if (haulMode[i] != null)
					model.setHaulMode(haulMode[i]);
				if (expo5[i] != null)
					model.setExpo5(expo5[i]);
				if (expo4[i] != null)
					model.setExpo4(expo4[i]);
				if (expo3[i] != null)
					model.setExpo3(expo3[i]);
				if (expo2[i] != null)
					model.setExpo2(expo2[i]);
				if (finalEta[i] != null)
					model.setFinalEta(finalEta[i]);
				if (msn[i] != null)
					model.setMsn(msn[i]);
				if (cnee5[i] != null)
					model.setCnee5(cnee5[i]);
				if (cnee3[i] != null)
					model.setCnee3(cnee3[i]);
				if (blrepcmd[i] != null)
					model.setBlrepcmd(blrepcmd[i]);
				if (cnee4[i] != null)
					model.setCnee4(cnee4[i]);
				if (expocd[i] != null)
					model.setExpocd(expocd[i]);
				if (cnee1[i] != null)
					model.setCnee1(cnee1[i]);
				if (ntfycn[i] != null)
					model.setNtfycn(ntfycn[i]);
				if (cnee2[i] != null)
					model.setCnee2(cnee2[i]);
				if (expocn[i] != null)
					model.setExpocn(expocn[i]);
				if (custrefNum[i] != null)
					model.setCustrefNum(custrefNum[i]);
				if (rcFlag[i] != null)
					model.setRcFlag(rcFlag[i]);
				if (bbFlag[i] != null)
					model.setBbFlag(bbFlag[i]);
				if (blpod[i] != null)
					model.setBlpod(blpod[i]);
				if (blorg[i] != null)
					model.setBlorg(blorg[i]);
				if (blWgtUnit[i] != null)
					model.setBlWgtUnit(blWgtUnit[i]);
				if (cneecn[i] != null)
					model.setCneecn(cneecn[i]);
				if (blpor[i] != null)
					model.setBlpor(blpor[i]);
				if (ausQuar[i] != null)
					model.setAusQuar(ausQuar[i]);
				if (rdFlag[i] != null)
					model.setRdFlag(rdFlag[i]);
				if (blpol[i] != null)
					model.setBlpol(blpol[i]);
				if (blMeaUnit[i] != null)
					model.setBlMeaUnit(blMeaUnit[i]);
				if (ntfycd[i] != null)
					model.setNtfycd(ntfycd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ffwd5[i] != null)
					model.setFfwd5(ffwd5[i]);
				if (blrepcmdcd[i] != null)
					model.setBlrepcmdcd(blrepcmdcd[i]);
				if (ffwd2[i] != null)
					model.setFfwd2(ffwd2[i]);
				if (cneecd[i] != null)
					model.setCneecd(cneecd[i]);
				if (ffwd1[i] != null)
					model.setFfwd1(ffwd1[i]);
				if (ffwd4[i] != null)
					model.setFfwd4(ffwd4[i]);
				if (ffwd3[i] != null)
					model.setFfwd3(ffwd3[i]);
				if (akFlag[i] != null)
					model.setAkFlag(akFlag[i]);
				if (onboard[i] != null)
					model.setOnboard(onboard[i]);
				if (polFullname[i] != null)
					model.setPolFullname(polFullname[i]);
				if (waybillInd[i] != null)
					model.setWaybillInd(waybillInd[i]);
				if (blts[i] != null)
					model.setBlts(blts[i]);
				if (bltp[i] != null)
					model.setBltp(bltp[i]);
				if (funcCode[i] != null)
					model.setFuncCode(funcCode[i]);
				if (shpr2[i] != null)
					model.setShpr2(shpr2[i]);
				if (shpr1[i] != null)
					model.setShpr1(shpr1[i]);
				if (blwgt[i] != null)
					model.setBlwgt(blwgt[i]);
				if (rlyAms[i] != null)
					model.setRlyAms(rlyAms[i]);
				if (shpr5[i] != null)
					model.setShpr5(shpr5[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (shpr4[i] != null)
					model.setShpr4(shpr4[i]);
				if (shpr3[i] != null)
					model.setShpr3(shpr3[i]);
				if (porAms[i] != null)
					model.setPorAms(porAms[i]);
				if (commodity[i] != null)
					model.setCommodity(commodity[i]);
				if (bkgnbr[i] != null)
					model.setBkgnbr(bkgnbr[i]);
				if (delFullname[i] != null)
					model.setDelFullname(delFullname[i]);
				if (blcopy[i] != null)
					model.setBlcopy(blcopy[i]);
				if (rfano[i] != null)
					model.setRfano(rfano[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExCntrTransmitBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExCntrTransmitBlInfoVO[]
	 */
	public ExCntrTransmitBlInfoVO[] getExCntrTransmitBlInfoVOs(){
		ExCntrTransmitBlInfoVO[] vos = (ExCntrTransmitBlInfoVO[])models.toArray(new ExCntrTransmitBlInfoVO[models.size()]);
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
		this.salesName = this.salesName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msncfm = this.msncfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy25 = this.ntfy25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAms = this.delAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blcmd = this.blcmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy21 = this.ntfy21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy22 = this.ntfy22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy23 = this.ntfy23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy24 = this.ntfy24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlag = this.dgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyFullname = this.rlyFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcd = this.shprcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactName = this.contactName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplace = this.blplace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldate = this.bldate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdofc = this.ppdofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqpickdt = this.eqpickdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkg = this.blpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localIpi = this.localIpi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2cd = this.ntfy2cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFullname = this.podFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tranMode = this.tranMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcn = this.shprcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porFullname = this.porFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srnbr = this.srnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.thdofc = this.thdofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrly = this.blrly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnBkgnbr = this.rgnBkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo1 = this.expo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brac = this.brac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrel = this.eqrel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdesc = this.cmdesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrtn = this.eqrtn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2cn = this.ntfy2cn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAms = this.polAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwdcd = this.ffwdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgu = this.blpkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forwardCd = this.forwardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctofc = this.cctofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwdcn = this.ffwdcn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmea = this.blmea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAms = this.podAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulMode = this.haulMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo5 = this.expo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo4 = this.expo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo3 = this.expo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo2 = this.expo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalEta = this.finalEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn = this.msn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrepcmd = this.blrepcmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expocd = this.expocd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycn = this.ntfycn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expocn = this.expocn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custrefNum = this.custrefNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlag = this.rcFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbFlag = this.bbFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blorg = this.blorg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWgtUnit = this.blWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneecn = this.cneecn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ausQuar = this.ausQuar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlag = this.rdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeaUnit = this.blMeaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycd = this.ntfycd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd5 = this.ffwd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrepcmdcd = this.blrepcmdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd2 = this.ffwd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneecd = this.cneecd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd1 = this.ffwd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd4 = this.ffwd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd3 = this.ffwd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akFlag = this.akFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onboard = this.onboard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullname = this.polFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waybillInd = this.waybillInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blts = this.blts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bltp = this.bltp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCode = this.funcCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgt = this.blwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyAms = this.rlyAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAms = this.porAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodity = this.commodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnbr = this.bkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFullname = this.delFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blcopy = this.blcopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfano = this.rfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
