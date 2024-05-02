/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SitProBlLdfBlRootVO.java
*@FileTitle : SitProBlLdfBlRootVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SitProBlLdfBlRootVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProBlLdfBlRootVO> models = new ArrayList<SitProBlLdfBlRootVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String vvd = null;

	/* Column Info */
	private String ibConVvd = null;

	/* Column Info */
	private String obConVvd = null;

	/* Column Info */
	private String vslCallsign = null;

	/* Column Info */
	private String vslLloydcode = null;

	/* Column Info */
	private String vslFullname = null;

	/* Column Info */
	private String vslFlag = null;

	/* Column Info */
	private String port = null;

	/* Column Info */
	private String portname = null;

	/* Column Info */
	private String eta = null;

	/* Column Info */
	private String etd = null;

	/* Column Info */
	private String ata = null;

	/* Column Info */
	private String atd = null;

	/* Column Info */
	private String nextport = null;

	/* Column Info */
	private String nextportEta = null;

	/* Column Info */
	private String prevport = null;

	/* Column Info */
	private String prevportEtd = null;

	/* Column Info */
	private String ioInd = null;

	/* Column Info */
	private String compId = null;

	/* Column Info */
	private String mrn = null;

	/* Column Info */
	private String blnbr = null;

	/* Column Info */
	private String blpol = null;

	/* Column Info */
	private String polAms = null;

	/* Column Info */
	private String polFullname = null;

	/* Column Info */
	private String blpod = null;

	/* Column Info */
	private String podAms = null;

	/* Column Info */
	private String podFullname = null;

	/* Column Info */
	private String blpor = null;

	/* Column Info */
	private String porAms = null;

	/* Column Info */
	private String porFullname = null;

	/* Column Info */
	private String porYard = null;

	/* Column Info */
	private String bldel = null;

	/* Column Info */
	private String delAms = null;

	/* Column Info */
	private String delFullname = null;

	/* Column Info */
	private String delYard = null;

	/* Column Info */
	private String svcScp = null;

	/* Column Info */
	private String blCmplSts = null;

	/* Column Info */
	private String blCmplTp = null;

	/* Column Info */
	private String blrly = null;

	/* Column Info */
	private String rlyAms = null;

	/* Column Info */
	private String rlyFullname = null;

	/* Column Info */
	private String blplace = null;

	/* Column Info */
	private String bldate = null;

	/* Column Info */
	private String blcopy = null;

	/* Column Info */
	private String blorg = null;

	/* Column Info */
	private String blpkg = null;

	/* Column Info */
	private String blpkgu = null;

	/* Column Info */
	private String blwgt = null;

	/* Column Info */
	private String blWgtUnit = null;

	/* Column Info */
	private String blmea = null;

	/* Column Info */
	private String blMeaUnit = null;

	/* Column Info */
	private String rdtype = null;

	/* Column Info */
	private String cargotype = null;

	/* Column Info */
	private String commodity = null;

	/* Column Info */
	private String blcmd = null;

	/* Column Info */
	private String blrepcmdcd = null;

	/* Column Info */
	private String blrepcmd = null;

	/* Column Info */
	private String remark = null;

	/* Column Info */
	private String ausQuar = null;

	/* Column Info */
	private String srnbr = null;

	/* Column Info */
	private String bkgnbr = null;

	/* Column Info */
	private String rgnBkgnbr = null;

	/* Column Info */
	private String cvrdBy = null;

	/* Column Info */
	private String scno = null;

	/* Column Info */
	private String rfano = null;

	/* Column Info */
	private String twSoNo = null;

	/* Column Info */
	private String waybillInd = null;

	/* Column Info */
	private String custrefNum = null;

	/* Column Info */
	private String finalEta = null;

	/* Column Info */
	private String funcCode = null;

	/* Column Info */
	private String onboard = null;

	/* Column Info */
	private String invNo = null;

	/* Column Info */
	private String blts = null;

	/* Column Info */
	private String bltp = null;

	/* Column Info */
	private String msn = null;

	/* Column Info */
	private String msncfm = null;

	/* Column Info */
	private String indAgree = null;

	/* Column Info */
	private String valueAgree = null;

	/* Column Info */
	private String euMrnSeq = null;

	/* Column Info */
	private String euMrnValue = null;

	/* Column Info */
	private String euPort = null;

	/* Column Info */
	private String euMrnDate = null;

	/* Column Info */
	private String euMrnSource = null;

	/* Column Info */
	private String hantype = null;

	/* Column Info */
	private String count = null;

	/* Column Info */
	private String elno = null;

	/* Column Info */
	private String elpk = null;

	/* Column Info */
	private String elpku = null;

	/* Column Info */
	private String elwt = null;

	/* Column Info */
	private String elwtu = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SitProBlLdfBlRootVO() {}

	public SitProBlLdfBlRootVO(String ibflag, String pagerows, String vvd, String ibConVvd, String obConVvd, String vslCallsign, String vslLloydcode, String vslFullname, String vslFlag, String port, String portname, String eta, String etd, String ata, String atd, String nextport, String nextportEta, String prevport, String prevportEtd, String ioInd, String compId, String mrn, String blnbr, String blpol, String polAms, String polFullname, String blpod, String podAms, String podFullname, String blpor, String porAms, String porFullname, String porYard, String bldel, String delAms, String delFullname, String delYard, String svcScp, String blCmplSts, String blCmplTp, String blrly, String rlyAms, String rlyFullname, String blplace, String bldate, String blcopy, String blorg, String blpkg, String blpkgu, String blwgt, String blWgtUnit, String blmea, String blMeaUnit, String rdtype, String cargotype, String commodity, String blcmd, String blrepcmdcd, String blrepcmd, String remark, String ausQuar, String srnbr, String bkgnbr, String rgnBkgnbr, String cvrdBy, String scno, String rfano, String twSoNo, String waybillInd, String custrefNum, String finalEta, String funcCode, String onboard, String invNo, String blts, String bltp, String msn, String msncfm, String indAgree, String valueAgree, String euMrnSeq, String euMrnValue, String euPort, String euMrnDate, String euMrnSource, String hantype, String count, String elno, String elpk, String elpku, String elwt, String elwtu) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibConVvd = ibConVvd;
		this.obConVvd = obConVvd;
		this.vslCallsign = vslCallsign;
		this.vslLloydcode = vslLloydcode;
		this.vslFullname = vslFullname;
		this.vslFlag = vslFlag;
		this.port = port;
		this.portname = portname;
		this.eta = eta;
		this.etd = etd;
		this.ata = ata;
		this.atd = atd;
		this.nextport = nextport;
		this.nextportEta = nextportEta;
		this.prevport = prevport;
		this.prevportEtd = prevportEtd;
		this.ioInd = ioInd;
		this.compId = compId;
		this.mrn = mrn;
		this.blnbr = blnbr;
		this.blpol = blpol;
		this.polAms = polAms;
		this.polFullname = polFullname;
		this.blpod = blpod;
		this.podAms = podAms;
		this.podFullname = podFullname;
		this.blpor = blpor;
		this.porAms = porAms;
		this.porFullname = porFullname;
		this.porYard = porYard;
		this.bldel = bldel;
		this.delAms = delAms;
		this.delFullname = delFullname;
		this.delYard = delYard;
		this.svcScp = svcScp;
		this.blCmplSts = blCmplSts;
		this.blCmplTp = blCmplTp;
		this.blrly = blrly;
		this.rlyAms = rlyAms;
		this.rlyFullname = rlyFullname;
		this.blplace = blplace;
		this.bldate = bldate;
		this.blcopy = blcopy;
		this.blorg = blorg;
		this.blpkg = blpkg;
		this.blpkgu = blpkgu;
		this.blwgt = blwgt;
		this.blWgtUnit = blWgtUnit;
		this.blmea = blmea;
		this.blMeaUnit = blMeaUnit;
		this.rdtype = rdtype;
		this.cargotype = cargotype;
		this.commodity = commodity;
		this.blcmd = blcmd;
		this.blrepcmdcd = blrepcmdcd;
		this.blrepcmd = blrepcmd;
		this.remark = remark;
		this.ausQuar = ausQuar;
		this.srnbr = srnbr;
		this.bkgnbr = bkgnbr;
		this.rgnBkgnbr = rgnBkgnbr;
		this.cvrdBy = cvrdBy;
		this.scno = scno;
		this.rfano = rfano;
		this.twSoNo = twSoNo;
		this.waybillInd = waybillInd;
		this.custrefNum = custrefNum;
		this.finalEta = finalEta;
		this.funcCode = funcCode;
		this.onboard = onboard;
		this.invNo = invNo;
		this.blts = blts;
		this.bltp = bltp;
		this.msn = msn;
		this.msncfm = msncfm;
		this.indAgree = indAgree;
		this.valueAgree = valueAgree;
		this.euMrnSeq = euMrnSeq;
		this.euMrnValue = euMrnValue;
		this.euPort = euPort;
		this.euMrnDate = euMrnDate;
		this.euMrnSource = euMrnSource;
		this.hantype = hantype;
		this.count = count;
		this.elno = elno;
		this.elpk = elpk;
		this.elpku = elpku;
		this.elwt = elwt;
		this.elwtu = elwtu;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ib_con_vvd", getIbConVvd());
		this.hashColumns.put("ob_con_vvd", getObConVvd());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("portname", getPortname());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("ata", getAta());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("nextport", getNextport());
		this.hashColumns.put("nextport_eta", getNextportEta());
		this.hashColumns.put("prevport", getPrevport());
		this.hashColumns.put("prevport_etd", getPrevportEtd());
		this.hashColumns.put("io_ind", getIoInd());
		this.hashColumns.put("comp_id", getCompId());
		this.hashColumns.put("mrn", getMrn());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("pol_ams", getPolAms());
		this.hashColumns.put("pol_fullname", getPolFullname());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("pod_ams", getPodAms());
		this.hashColumns.put("pod_fullname", getPodFullname());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("por_ams", getPorAms());
		this.hashColumns.put("por_fullname", getPorFullname());
		this.hashColumns.put("por_yard", getPorYard());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("del_ams", getDelAms());
		this.hashColumns.put("del_fullname", getDelFullname());
		this.hashColumns.put("del_yard", getDelYard());
		this.hashColumns.put("svc_scp", getSvcScp());
		this.hashColumns.put("bl_cmpl_sts", getBlCmplSts());
		this.hashColumns.put("bl_cmpl_tp", getBlCmplTp());
		this.hashColumns.put("blrly", getBlrly());
		this.hashColumns.put("rly_ams", getRlyAms());
		this.hashColumns.put("rly_fullname", getRlyFullname());
		this.hashColumns.put("blplace", getBlplace());
		this.hashColumns.put("bldate", getBldate());
		this.hashColumns.put("blcopy", getBlcopy());
		this.hashColumns.put("blorg", getBlorg());
		this.hashColumns.put("blpkg", getBlpkg());
		this.hashColumns.put("blpkgu", getBlpkgu());
		this.hashColumns.put("blwgt", getBlwgt());
		this.hashColumns.put("bl_wgt_unit", getBlWgtUnit());
		this.hashColumns.put("blmea", getBlmea());
		this.hashColumns.put("bl_mea_unit", getBlMeaUnit());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("commodity", getCommodity());
		this.hashColumns.put("blcmd", getBlcmd());
		this.hashColumns.put("blrepcmdcd", getBlrepcmdcd());
		this.hashColumns.put("blrepcmd", getBlrepcmd());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("aus_quar", getAusQuar());
		this.hashColumns.put("srnbr", getSrnbr());
		this.hashColumns.put("bkgnbr", getBkgnbr());
		this.hashColumns.put("rgn_bkgnbr", getRgnBkgnbr());
		this.hashColumns.put("cvrd_by", getCvrdBy());
		this.hashColumns.put("scno", getScno());
		this.hashColumns.put("rfano", getRfano());
		this.hashColumns.put("tw_so_no", getTwSoNo());
		this.hashColumns.put("waybill_ind", getWaybillInd());
		this.hashColumns.put("custref_num", getCustrefNum());
		this.hashColumns.put("final_eta", getFinalEta());
		this.hashColumns.put("func_code", getFuncCode());
		this.hashColumns.put("onboard", getOnboard());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("blts", getBlts());
		this.hashColumns.put("bltp", getBltp());
		this.hashColumns.put("msn", getMsn());
		this.hashColumns.put("msncfm", getMsncfm());
		this.hashColumns.put("ind_agree", getIndAgree());
		this.hashColumns.put("value_agree", getValueAgree());
		this.hashColumns.put("eu_mrn_seq", getEuMrnSeq());
		this.hashColumns.put("eu_mrn_value", getEuMrnValue());
		this.hashColumns.put("eu_port", getEuPort());
		this.hashColumns.put("eu_mrn_date", getEuMrnDate());
		this.hashColumns.put("eu_mrn_source", getEuMrnSource());
		this.hashColumns.put("hantype", getHantype());
		this.hashColumns.put("count", getCount());
		this.hashColumns.put("elno", getElno());
		this.hashColumns.put("elpk", getElpk());
		this.hashColumns.put("elpku", getElpku());
		this.hashColumns.put("elwt", getElwt());
		this.hashColumns.put("elwtu", getElwtu());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ib_con_vvd", "ibConVvd");
		this.hashFields.put("ob_con_vvd", "obConVvd");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("port", "port");
		this.hashFields.put("portname", "portname");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("ata", "ata");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("nextport", "nextport");
		this.hashFields.put("nextport_eta", "nextportEta");
		this.hashFields.put("prevport", "prevport");
		this.hashFields.put("prevport_etd", "prevportEtd");
		this.hashFields.put("io_ind", "ioInd");
		this.hashFields.put("comp_id", "compId");
		this.hashFields.put("mrn", "mrn");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("pol_ams", "polAms");
		this.hashFields.put("pol_fullname", "polFullname");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("pod_ams", "podAms");
		this.hashFields.put("pod_fullname", "podFullname");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("por_ams", "porAms");
		this.hashFields.put("por_fullname", "porFullname");
		this.hashFields.put("por_yard", "porYard");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("del_ams", "delAms");
		this.hashFields.put("del_fullname", "delFullname");
		this.hashFields.put("del_yard", "delYard");
		this.hashFields.put("svc_scp", "svcScp");
		this.hashFields.put("bl_cmpl_sts", "blCmplSts");
		this.hashFields.put("bl_cmpl_tp", "blCmplTp");
		this.hashFields.put("blrly", "blrly");
		this.hashFields.put("rly_ams", "rlyAms");
		this.hashFields.put("rly_fullname", "rlyFullname");
		this.hashFields.put("blplace", "blplace");
		this.hashFields.put("bldate", "bldate");
		this.hashFields.put("blcopy", "blcopy");
		this.hashFields.put("blorg", "blorg");
		this.hashFields.put("blpkg", "blpkg");
		this.hashFields.put("blpkgu", "blpkgu");
		this.hashFields.put("blwgt", "blwgt");
		this.hashFields.put("bl_wgt_unit", "blWgtUnit");
		this.hashFields.put("blmea", "blmea");
		this.hashFields.put("bl_mea_unit", "blMeaUnit");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("commodity", "commodity");
		this.hashFields.put("blcmd", "blcmd");
		this.hashFields.put("blrepcmdcd", "blrepcmdcd");
		this.hashFields.put("blrepcmd", "blrepcmd");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("aus_quar", "ausQuar");
		this.hashFields.put("srnbr", "srnbr");
		this.hashFields.put("bkgnbr", "bkgnbr");
		this.hashFields.put("rgn_bkgnbr", "rgnBkgnbr");
		this.hashFields.put("cvrd_by", "cvrdBy");
		this.hashFields.put("scno", "scno");
		this.hashFields.put("rfano", "rfano");
		this.hashFields.put("tw_so_no", "twSoNo");
		this.hashFields.put("waybill_ind", "waybillInd");
		this.hashFields.put("custref_num", "custrefNum");
		this.hashFields.put("final_eta", "finalEta");
		this.hashFields.put("func_code", "funcCode");
		this.hashFields.put("onboard", "onboard");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("blts", "blts");
		this.hashFields.put("bltp", "bltp");
		this.hashFields.put("msn", "msn");
		this.hashFields.put("msncfm", "msncfm");
		this.hashFields.put("ind_agree", "indAgree");
		this.hashFields.put("value_agree", "valueAgree");
		this.hashFields.put("eu_mrn_seq", "euMrnSeq");
		this.hashFields.put("eu_mrn_value", "euMrnValue");
		this.hashFields.put("eu_port", "euPort");
		this.hashFields.put("eu_mrn_date", "euMrnDate");
		this.hashFields.put("eu_mrn_source", "euMrnSource");
		this.hashFields.put("hantype", "hantype");
		this.hashFields.put("count", "count");
		this.hashFields.put("elno", "elno");
		this.hashFields.put("elpk", "elpk");
		this.hashFields.put("elpku", "elpku");
		this.hashFields.put("elwt", "elwt");
		this.hashFields.put("elwtu", "elwtu");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * 
	 * @return String vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 *
	 * @param String ibConVvd
	 */
	public void setIbConVvd(String ibConVvd) {
		this.ibConVvd = ibConVvd;
	}
	
	/**
	 * 
	 * @return String ibConVvd
	 */
	public String getIbConVvd() {
		return this.ibConVvd;
	}
	
	/**
	 *
	 * @param String obConVvd
	 */
	public void setObConVvd(String obConVvd) {
		this.obConVvd = obConVvd;
	}
	
	/**
	 * 
	 * @return String obConVvd
	 */
	public String getObConVvd() {
		return this.obConVvd;
	}
	
	/**
	 *
	 * @param String vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
	}
	
	/**
	 * 
	 * @return String vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
	}
	
	/**
	 *
	 * @param String vslLloydcode
	 */
	public void setVslLloydcode(String vslLloydcode) {
		this.vslLloydcode = vslLloydcode;
	}
	
	/**
	 * 
	 * @return String vslLloydcode
	 */
	public String getVslLloydcode() {
		return this.vslLloydcode;
	}
	
	/**
	 *
	 * @param String vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
	}
	
	/**
	 * 
	 * @return String vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
	}
	
	/**
	 *
	 * @param String vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * 
	 * @return String vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 *
	 * @param String port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * 
	 * @return String port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 *
	 * @param String portname
	 */
	public void setPortname(String portname) {
		this.portname = portname;
	}
	
	/**
	 * 
	 * @return String portname
	 */
	public String getPortname() {
		return this.portname;
	}
	
	/**
	 *
	 * @param String eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * 
	 * @return String eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 *
	 * @param String etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * 
	 * @return String etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 *
	 * @param String ata
	 */
	public void setAta(String ata) {
		this.ata = ata;
	}
	
	/**
	 * 
	 * @return String ata
	 */
	public String getAta() {
		return this.ata;
	}
	
	/**
	 *
	 * @param String atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * 
	 * @return String atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 *
	 * @param String nextport
	 */
	public void setNextport(String nextport) {
		this.nextport = nextport;
	}
	
	/**
	 * 
	 * @return String nextport
	 */
	public String getNextport() {
		return this.nextport;
	}
	
	/**
	 *
	 * @param String nextportEta
	 */
	public void setNextportEta(String nextportEta) {
		this.nextportEta = nextportEta;
	}
	
	/**
	 * 
	 * @return String nextportEta
	 */
	public String getNextportEta() {
		return this.nextportEta;
	}
	
	/**
	 *
	 * @param String prevport
	 */
	public void setPrevport(String prevport) {
		this.prevport = prevport;
	}
	
	/**
	 * 
	 * @return String prevport
	 */
	public String getPrevport() {
		return this.prevport;
	}
	
	/**
	 *
	 * @param String prevportEtd
	 */
	public void setPrevportEtd(String prevportEtd) {
		this.prevportEtd = prevportEtd;
	}
	
	/**
	 * 
	 * @return String prevportEtd
	 */
	public String getPrevportEtd() {
		return this.prevportEtd;
	}
	
	/**
	 *
	 * @param String ioInd
	 */
	public void setIoInd(String ioInd) {
		this.ioInd = ioInd;
	}
	
	/**
	 * 
	 * @return String ioInd
	 */
	public String getIoInd() {
		return this.ioInd;
	}
	
	/**
	 *
	 * @param String compId
	 */
	public void setCompId(String compId) {
		this.compId = compId;
	}
	
	/**
	 * 
	 * @return String compId
	 */
	public String getCompId() {
		return this.compId;
	}
	
	/**
	 *
	 * @param String mrn
	 */
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	
	/**
	 * 
	 * @return String mrn
	 */
	public String getMrn() {
		return this.mrn;
	}
	
	/**
	 *
	 * @param String blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * 
	 * @return String blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 *
	 * @param String blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * 
	 * @return String blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 *
	 * @param String polAms
	 */
	public void setPolAms(String polAms) {
		this.polAms = polAms;
	}
	
	/**
	 * 
	 * @return String polAms
	 */
	public String getPolAms() {
		return this.polAms;
	}
	
	/**
	 *
	 * @param String polFullname
	 */
	public void setPolFullname(String polFullname) {
		this.polFullname = polFullname;
	}
	
	/**
	 * 
	 * @return String polFullname
	 */
	public String getPolFullname() {
		return this.polFullname;
	}
	
	/**
	 *
	 * @param String blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * 
	 * @return String blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 *
	 * @param String podAms
	 */
	public void setPodAms(String podAms) {
		this.podAms = podAms;
	}
	
	/**
	 * 
	 * @return String podAms
	 */
	public String getPodAms() {
		return this.podAms;
	}
	
	/**
	 *
	 * @param String podFullname
	 */
	public void setPodFullname(String podFullname) {
		this.podFullname = podFullname;
	}
	
	/**
	 * 
	 * @return String podFullname
	 */
	public String getPodFullname() {
		return this.podFullname;
	}
	
	/**
	 *
	 * @param String blpor
	 */
	public void setBlpor(String blpor) {
		this.blpor = blpor;
	}
	
	/**
	 * 
	 * @return String blpor
	 */
	public String getBlpor() {
		return this.blpor;
	}
	
	/**
	 *
	 * @param String porAms
	 */
	public void setPorAms(String porAms) {
		this.porAms = porAms;
	}
	
	/**
	 * 
	 * @return String porAms
	 */
	public String getPorAms() {
		return this.porAms;
	}
	
	/**
	 *
	 * @param String porFullname
	 */
	public void setPorFullname(String porFullname) {
		this.porFullname = porFullname;
	}
	
	/**
	 * 
	 * @return String porFullname
	 */
	public String getPorFullname() {
		return this.porFullname;
	}
	
	/**
	 *
	 * @param String porYard
	 */
	public void setPorYard(String porYard) {
		this.porYard = porYard;
	}
	
	/**
	 * 
	 * @return String porYard
	 */
	public String getPorYard() {
		return this.porYard;
	}
	
	/**
	 *
	 * @param String bldel
	 */
	public void setBldel(String bldel) {
		this.bldel = bldel;
	}
	
	/**
	 * 
	 * @return String bldel
	 */
	public String getBldel() {
		return this.bldel;
	}
	
	/**
	 *
	 * @param String delAms
	 */
	public void setDelAms(String delAms) {
		this.delAms = delAms;
	}
	
	/**
	 * 
	 * @return String delAms
	 */
	public String getDelAms() {
		return this.delAms;
	}
	
	/**
	 *
	 * @param String delFullname
	 */
	public void setDelFullname(String delFullname) {
		this.delFullname = delFullname;
	}
	
	/**
	 * 
	 * @return String delFullname
	 */
	public String getDelFullname() {
		return this.delFullname;
	}
	
	/**
	 *
	 * @param String delYard
	 */
	public void setDelYard(String delYard) {
		this.delYard = delYard;
	}
	
	/**
	 * 
	 * @return String delYard
	 */
	public String getDelYard() {
		return this.delYard;
	}
	
	/**
	 *
	 * @param String svcScp
	 */
	public void setSvcScp(String svcScp) {
		this.svcScp = svcScp;
	}
	
	/**
	 * 
	 * @return String svcScp
	 */
	public String getSvcScp() {
		return this.svcScp;
	}
	
	/**
	 *
	 * @param String blCmplSts
	 */
	public void setBlCmplSts(String blCmplSts) {
		this.blCmplSts = blCmplSts;
	}
	
	/**
	 * 
	 * @return String blCmplSts
	 */
	public String getBlCmplSts() {
		return this.blCmplSts;
	}
	
	/**
	 *
	 * @param String blCmplTp
	 */
	public void setBlCmplTp(String blCmplTp) {
		this.blCmplTp = blCmplTp;
	}
	
	/**
	 * 
	 * @return String blCmplTp
	 */
	public String getBlCmplTp() {
		return this.blCmplTp;
	}
	
	/**
	 *
	 * @param String blrly
	 */
	public void setBlrly(String blrly) {
		this.blrly = blrly;
	}
	
	/**
	 * 
	 * @return String blrly
	 */
	public String getBlrly() {
		return this.blrly;
	}
	
	/**
	 *
	 * @param String rlyAms
	 */
	public void setRlyAms(String rlyAms) {
		this.rlyAms = rlyAms;
	}
	
	/**
	 * 
	 * @return String rlyAms
	 */
	public String getRlyAms() {
		return this.rlyAms;
	}
	
	/**
	 *
	 * @param String rlyFullname
	 */
	public void setRlyFullname(String rlyFullname) {
		this.rlyFullname = rlyFullname;
	}
	
	/**
	 * 
	 * @return String rlyFullname
	 */
	public String getRlyFullname() {
		return this.rlyFullname;
	}
	
	/**
	 *
	 * @param String blplace
	 */
	public void setBlplace(String blplace) {
		this.blplace = blplace;
	}
	
	/**
	 * 
	 * @return String blplace
	 */
	public String getBlplace() {
		return this.blplace;
	}
	
	/**
	 *
	 * @param String bldate
	 */
	public void setBldate(String bldate) {
		this.bldate = bldate;
	}
	
	/**
	 * 
	 * @return String bldate
	 */
	public String getBldate() {
		return this.bldate;
	}
	
	/**
	 *
	 * @param String blcopy
	 */
	public void setBlcopy(String blcopy) {
		this.blcopy = blcopy;
	}
	
	/**
	 * 
	 * @return String blcopy
	 */
	public String getBlcopy() {
		return this.blcopy;
	}
	
	/**
	 *
	 * @param String blorg
	 */
	public void setBlorg(String blorg) {
		this.blorg = blorg;
	}
	
	/**
	 * 
	 * @return String blorg
	 */
	public String getBlorg() {
		return this.blorg;
	}
	
	/**
	 *
	 * @param String blpkg
	 */
	public void setBlpkg(String blpkg) {
		this.blpkg = blpkg;
	}
	
	/**
	 * 
	 * @return String blpkg
	 */
	public String getBlpkg() {
		return this.blpkg;
	}
	
	/**
	 *
	 * @param String blpkgu
	 */
	public void setBlpkgu(String blpkgu) {
		this.blpkgu = blpkgu;
	}
	
	/**
	 * 
	 * @return String blpkgu
	 */
	public String getBlpkgu() {
		return this.blpkgu;
	}
	
	/**
	 *
	 * @param String blwgt
	 */
	public void setBlwgt(String blwgt) {
		this.blwgt = blwgt;
	}
	
	/**
	 * 
	 * @return String blwgt
	 */
	public String getBlwgt() {
		return this.blwgt;
	}
	
	/**
	 *
	 * @param String blWgtUnit
	 */
	public void setBlWgtUnit(String blWgtUnit) {
		this.blWgtUnit = blWgtUnit;
	}
	
	/**
	 * 
	 * @return String blWgtUnit
	 */
	public String getBlWgtUnit() {
		return this.blWgtUnit;
	}
	
	/**
	 *
	 * @param String blmea
	 */
	public void setBlmea(String blmea) {
		this.blmea = blmea;
	}
	
	/**
	 * 
	 * @return String blmea
	 */
	public String getBlmea() {
		return this.blmea;
	}
	
	/**
	 *
	 * @param String blMeaUnit
	 */
	public void setBlMeaUnit(String blMeaUnit) {
		this.blMeaUnit = blMeaUnit;
	}
	
	/**
	 * 
	 * @return String blMeaUnit
	 */
	public String getBlMeaUnit() {
		return this.blMeaUnit;
	}
	
	/**
	 *
	 * @param String rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * 
	 * @return String rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 *
	 * @param String cargotype
	 */
	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
	}
	
	/**
	 * 
	 * @return String cargotype
	 */
	public String getCargotype() {
		return this.cargotype;
	}
	
	/**
	 *
	 * @param String commodity
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	
	/**
	 * 
	 * @return String commodity
	 */
	public String getCommodity() {
		return this.commodity;
	}
	
	/**
	 *
	 * @param String blcmd
	 */
	public void setBlcmd(String blcmd) {
		this.blcmd = blcmd;
	}
	
	/**
	 * 
	 * @return String blcmd
	 */
	public String getBlcmd() {
		return this.blcmd;
	}
	
	/**
	 *
	 * @param String blrepcmdcd
	 */
	public void setBlrepcmdcd(String blrepcmdcd) {
		this.blrepcmdcd = blrepcmdcd;
	}
	
	/**
	 * 
	 * @return String blrepcmdcd
	 */
	public String getBlrepcmdcd() {
		return this.blrepcmdcd;
	}
	
	/**
	 *
	 * @param String blrepcmd
	 */
	public void setBlrepcmd(String blrepcmd) {
		this.blrepcmd = blrepcmd;
	}
	
	/**
	 * 
	 * @return String blrepcmd
	 */
	public String getBlrepcmd() {
		return this.blrepcmd;
	}
	
	/**
	 *
	 * @param String remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 
	 * @return String remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 *
	 * @param String ausQuar
	 */
	public void setAusQuar(String ausQuar) {
		this.ausQuar = ausQuar;
	}
	
	/**
	 * 
	 * @return String ausQuar
	 */
	public String getAusQuar() {
		return this.ausQuar;
	}
	
	/**
	 *
	 * @param String srnbr
	 */
	public void setSrnbr(String srnbr) {
		this.srnbr = srnbr;
	}
	
	/**
	 * 
	 * @return String srnbr
	 */
	public String getSrnbr() {
		return this.srnbr;
	}
	
	/**
	 *
	 * @param String bkgnbr
	 */
	public void setBkgnbr(String bkgnbr) {
		this.bkgnbr = bkgnbr;
	}
	
	/**
	 * 
	 * @return String bkgnbr
	 */
	public String getBkgnbr() {
		return this.bkgnbr;
	}
	
	/**
	 *
	 * @param String rgnBkgnbr
	 */
	public void setRgnBkgnbr(String rgnBkgnbr) {
		this.rgnBkgnbr = rgnBkgnbr;
	}
	
	/**
	 * 
	 * @return String rgnBkgnbr
	 */
	public String getRgnBkgnbr() {
		return this.rgnBkgnbr;
	}
	
	/**
	 *
	 * @param String cvrdBy
	 */
	public void setCvrdBy(String cvrdBy) {
		this.cvrdBy = cvrdBy;
	}
	
	/**
	 * 
	 * @return String cvrdBy
	 */
	public String getCvrdBy() {
		return this.cvrdBy;
	}
	
	/**
	 *
	 * @param String scno
	 */
	public void setScno(String scno) {
		this.scno = scno;
	}
	
	/**
	 * 
	 * @return String scno
	 */
	public String getScno() {
		return this.scno;
	}
	
	/**
	 *
	 * @param String rfano
	 */
	public void setRfano(String rfano) {
		this.rfano = rfano;
	}
	
	/**
	 * 
	 * @return String rfano
	 */
	public String getRfano() {
		return this.rfano;
	}
	
	/**
	 *
	 * @param String twSoNo
	 */
	public void setTwSoNo(String twSoNo) {
		this.twSoNo = twSoNo;
	}
	
	/**
	 * 
	 * @return String twSoNo
	 */
	public String getTwSoNo() {
		return this.twSoNo;
	}
	
	/**
	 *
	 * @param String waybillInd
	 */
	public void setWaybillInd(String waybillInd) {
		this.waybillInd = waybillInd;
	}
	
	/**
	 * 
	 * @return String waybillInd
	 */
	public String getWaybillInd() {
		return this.waybillInd;
	}
	
	/**
	 *
	 * @param String custrefNum
	 */
	public void setCustrefNum(String custrefNum) {
		this.custrefNum = custrefNum;
	}
	
	/**
	 * 
	 * @return String custrefNum
	 */
	public String getCustrefNum() {
		return this.custrefNum;
	}
	
	/**
	 *
	 * @param String finalEta
	 */
	public void setFinalEta(String finalEta) {
		this.finalEta = finalEta;
	}
	
	/**
	 * 
	 * @return String finalEta
	 */
	public String getFinalEta() {
		return this.finalEta;
	}
	
	/**
	 *
	 * @param String funcCode
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	
	/**
	 * 
	 * @return String funcCode
	 */
	public String getFuncCode() {
		return this.funcCode;
	}
	
	/**
	 *
	 * @param String onboard
	 */
	public void setOnboard(String onboard) {
		this.onboard = onboard;
	}
	
	/**
	 * 
	 * @return String onboard
	 */
	public String getOnboard() {
		return this.onboard;
	}
	
	/**
	 *
	 * @param String invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * 
	 * @return String invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 *
	 * @param String blts
	 */
	public void setBlts(String blts) {
		this.blts = blts;
	}
	
	/**
	 * 
	 * @return String blts
	 */
	public String getBlts() {
		return this.blts;
	}
	
	/**
	 *
	 * @param String bltp
	 */
	public void setBltp(String bltp) {
		this.bltp = bltp;
	}
	
	/**
	 * 
	 * @return String bltp
	 */
	public String getBltp() {
		return this.bltp;
	}
	
	/**
	 *
	 * @param String msn
	 */
	public void setMsn(String msn) {
		this.msn = msn;
	}
	
	/**
	 * 
	 * @return String msn
	 */
	public String getMsn() {
		return this.msn;
	}
	
	/**
	 *
	 * @param String msncfm
	 */
	public void setMsncfm(String msncfm) {
		this.msncfm = msncfm;
	}
	
	/**
	 * 
	 * @return String msncfm
	 */
	public String getMsncfm() {
		return this.msncfm;
	}
	
	/**
	 *
	 * @param String indAgree
	 */
	public void setIndAgree(String indAgree) {
		this.indAgree = indAgree;
	}
	
	/**
	 * 
	 * @return String indAgree
	 */
	public String getIndAgree() {
		return this.indAgree;
	}
	
	/**
	 *
	 * @param String valueAgree
	 */
	public void setValueAgree(String valueAgree) {
		this.valueAgree = valueAgree;
	}
	
	/**
	 * 
	 * @return String valueAgree
	 */
	public String getValueAgree() {
		return this.valueAgree;
	}
	
	/**
	 *
	 * @param String euMrnSeq
	 */
	public void setEuMrnSeq(String euMrnSeq) {
		this.euMrnSeq = euMrnSeq;
	}
	
	/**
	 * 
	 * @return String euMrnSeq
	 */
	public String getEuMrnSeq() {
		return this.euMrnSeq;
	}
	
	/**
	 *
	 * @param String euMrnValue
	 */
	public void setEuMrnValue(String euMrnValue) {
		this.euMrnValue = euMrnValue;
	}
	
	/**
	 * 
	 * @return String euMrnValue
	 */
	public String getEuMrnValue() {
		return this.euMrnValue;
	}
	
	/**
	 *
	 * @param String euPort
	 */
	public void setEuPort(String euPort) {
		this.euPort = euPort;
	}
	
	/**
	 * 
	 * @return String euPort
	 */
	public String getEuPort() {
		return this.euPort;
	}
	
	/**
	 *
	 * @param String euMrnDate
	 */
	public void setEuMrnDate(String euMrnDate) {
		this.euMrnDate = euMrnDate;
	}
	
	/**
	 * 
	 * @return String euMrnDate
	 */
	public String getEuMrnDate() {
		return this.euMrnDate;
	}
	
	/**
	 *
	 * @param String euMrnSource
	 */
	public void setEuMrnSource(String euMrnSource) {
		this.euMrnSource = euMrnSource;
	}
	
	/**
	 * 
	 * @return String euMrnSource
	 */
	public String getEuMrnSource() {
		return this.euMrnSource;
	}
	
	/**
	 *
	 * @param String hantype
	 */
	public void setHantype(String hantype) {
		this.hantype = hantype;
	}
	
	/**
	 * 
	 * @return String hantype
	 */
	public String getHantype() {
		return this.hantype;
	}
	
	/**
	 *
	 * @param String count
	 */
	public void setCount(String count) {
		this.count = count;
	}
	
	/**
	 * 
	 * @return String count
	 */
	public String getCount() {
		return this.count;
	}
	
	/**
	 *
	 * @param String elno
	 */
	public void setElno(String elno) {
		this.elno = elno;
	}
	
	/**
	 * 
	 * @return String elno
	 */
	public String getElno() {
		return this.elno;
	}
	
	/**
	 *
	 * @param String elpk
	 */
	public void setElpk(String elpk) {
		this.elpk = elpk;
	}
	
	/**
	 * 
	 * @return String elpk
	 */
	public String getElpk() {
		return this.elpk;
	}
	
	/**
	 *
	 * @param String elpku
	 */
	public void setElpku(String elpku) {
		this.elpku = elpku;
	}
	
	/**
	 * 
	 * @return String elpku
	 */
	public String getElpku() {
		return this.elpku;
	}
	
	/**
	 *
	 * @param String elwt
	 */
	public void setElwt(String elwt) {
		this.elwt = elwt;
	}
	
	/**
	 * 
	 * @return String elwt
	 */
	public String getElwt() {
		return this.elwt;
	}
	
	/**
	 *
	 * @param String elwtu
	 */
	public void setElwtu(String elwtu) {
		this.elwtu = elwtu;
	}
	
	/**
	 * 
	 * @return String elwtu
	 */
	public String getElwtu() {
		return this.elwtu;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbConVvd(JSPUtil.getParameter(request, prefix + "ib_con_vvd", ""));
		setObConVvd(JSPUtil.getParameter(request, prefix + "ob_con_vvd", ""));
		setVslCallsign(JSPUtil.getParameter(request, prefix + "vsl_callsign", ""));
		setVslLloydcode(JSPUtil.getParameter(request, prefix + "vsl_lloydcode", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setVslFlag(JSPUtil.getParameter(request, prefix + "vsl_flag", ""));
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setPortname(JSPUtil.getParameter(request, prefix + "portname", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setAta(JSPUtil.getParameter(request, prefix + "ata", ""));
		setAtd(JSPUtil.getParameter(request, prefix + "atd", ""));
		setNextport(JSPUtil.getParameter(request, prefix + "nextport", ""));
		setNextportEta(JSPUtil.getParameter(request, prefix + "nextport_eta", ""));
		setPrevport(JSPUtil.getParameter(request, prefix + "prevport", ""));
		setPrevportEtd(JSPUtil.getParameter(request, prefix + "prevport_etd", ""));
		setIoInd(JSPUtil.getParameter(request, prefix + "io_ind", ""));
		setCompId(JSPUtil.getParameter(request, prefix + "comp_id", ""));
		setMrn(JSPUtil.getParameter(request, prefix + "mrn", ""));
		setBlnbr(JSPUtil.getParameter(request, prefix + "blnbr", ""));
		setBlpol(JSPUtil.getParameter(request, prefix + "blpol", ""));
		setPolAms(JSPUtil.getParameter(request, prefix + "pol_ams", ""));
		setPolFullname(JSPUtil.getParameter(request, prefix + "pol_fullname", ""));
		setBlpod(JSPUtil.getParameter(request, prefix + "blpod", ""));
		setPodAms(JSPUtil.getParameter(request, prefix + "pod_ams", ""));
		setPodFullname(JSPUtil.getParameter(request, prefix + "pod_fullname", ""));
		setBlpor(JSPUtil.getParameter(request, prefix + "blpor", ""));
		setPorAms(JSPUtil.getParameter(request, prefix + "por_ams", ""));
		setPorFullname(JSPUtil.getParameter(request, prefix + "por_fullname", ""));
		setPorYard(JSPUtil.getParameter(request, prefix + "por_yard", ""));
		setBldel(JSPUtil.getParameter(request, prefix + "bldel", ""));
		setDelAms(JSPUtil.getParameter(request, prefix + "del_ams", ""));
		setDelFullname(JSPUtil.getParameter(request, prefix + "del_fullname", ""));
		setDelYard(JSPUtil.getParameter(request, prefix + "del_yard", ""));
		setSvcScp(JSPUtil.getParameter(request, prefix + "svc_scp", ""));
		setBlCmplSts(JSPUtil.getParameter(request, prefix + "bl_cmpl_sts", ""));
		setBlCmplTp(JSPUtil.getParameter(request, prefix + "bl_cmpl_tp", ""));
		setBlrly(JSPUtil.getParameter(request, prefix + "blrly", ""));
		setRlyAms(JSPUtil.getParameter(request, prefix + "rly_ams", ""));
		setRlyFullname(JSPUtil.getParameter(request, prefix + "rly_fullname", ""));
		setBlplace(JSPUtil.getParameter(request, prefix + "blplace", ""));
		setBldate(JSPUtil.getParameter(request, prefix + "bldate", ""));
		setBlcopy(JSPUtil.getParameter(request, prefix + "blcopy", ""));
		setBlorg(JSPUtil.getParameter(request, prefix + "blorg", ""));
		setBlpkg(JSPUtil.getParameter(request, prefix + "blpkg", ""));
		setBlpkgu(JSPUtil.getParameter(request, prefix + "blpkgu", ""));
		setBlwgt(JSPUtil.getParameter(request, prefix + "blwgt", ""));
		setBlWgtUnit(JSPUtil.getParameter(request, prefix + "bl_wgt_unit", ""));
		setBlmea(JSPUtil.getParameter(request, prefix + "blmea", ""));
		setBlMeaUnit(JSPUtil.getParameter(request, prefix + "bl_mea_unit", ""));
		setRdtype(JSPUtil.getParameter(request, prefix + "rdtype", ""));
		setCargotype(JSPUtil.getParameter(request, prefix + "cargotype", ""));
		setCommodity(JSPUtil.getParameter(request, prefix + "commodity", ""));
		setBlcmd(JSPUtil.getParameter(request, prefix + "blcmd", ""));
		setBlrepcmdcd(JSPUtil.getParameter(request, prefix + "blrepcmdcd", ""));
		setBlrepcmd(JSPUtil.getParameter(request, prefix + "blrepcmd", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setAusQuar(JSPUtil.getParameter(request, prefix + "aus_quar", ""));
		setSrnbr(JSPUtil.getParameter(request, prefix + "srnbr", ""));
		setBkgnbr(JSPUtil.getParameter(request, prefix + "bkgnbr", ""));
		setRgnBkgnbr(JSPUtil.getParameter(request, prefix + "rgn_bkgnbr", ""));
		setCvrdBy(JSPUtil.getParameter(request, prefix + "cvrd_by", ""));
		setScno(JSPUtil.getParameter(request, prefix + "scno", ""));
		setRfano(JSPUtil.getParameter(request, prefix + "rfano", ""));
		setTwSoNo(JSPUtil.getParameter(request, prefix + "tw_so_no", ""));
		setWaybillInd(JSPUtil.getParameter(request, prefix + "waybill_ind", ""));
		setCustrefNum(JSPUtil.getParameter(request, prefix + "custref_num", ""));
		setFinalEta(JSPUtil.getParameter(request, prefix + "final_eta", ""));
		setFuncCode(JSPUtil.getParameter(request, prefix + "func_code", ""));
		setOnboard(JSPUtil.getParameter(request, prefix + "onboard", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setBlts(JSPUtil.getParameter(request, prefix + "blts", ""));
		setBltp(JSPUtil.getParameter(request, prefix + "bltp", ""));
		setMsn(JSPUtil.getParameter(request, prefix + "msn", ""));
		setMsncfm(JSPUtil.getParameter(request, prefix + "msncfm", ""));
		setIndAgree(JSPUtil.getParameter(request, prefix + "ind_agree", ""));
		setValueAgree(JSPUtil.getParameter(request, prefix + "value_agree", ""));
		setEuMrnSeq(JSPUtil.getParameter(request, prefix + "eu_mrn_seq", ""));
		setEuMrnValue(JSPUtil.getParameter(request, prefix + "eu_mrn_value", ""));
		setEuPort(JSPUtil.getParameter(request, prefix + "eu_port", ""));
		setEuMrnDate(JSPUtil.getParameter(request, prefix + "eu_mrn_date", ""));
		setEuMrnSource(JSPUtil.getParameter(request, prefix + "eu_mrn_source", ""));
		setHantype(JSPUtil.getParameter(request, prefix + "hantype", ""));
		setCount(JSPUtil.getParameter(request, prefix + "count", ""));
		setElno(JSPUtil.getParameter(request, prefix + "elno", ""));
		setElpk(JSPUtil.getParameter(request, prefix + "elpk", ""));
		setElpku(JSPUtil.getParameter(request, prefix + "elpku", ""));
		setElwt(JSPUtil.getParameter(request, prefix + "elwt", ""));
		setElwtu(JSPUtil.getParameter(request, prefix + "elwtu", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProBlLdfBlRootVO[]
	 */
	public SitProBlLdfBlRootVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProBlLdfBlRootVO[]
	 */
	public SitProBlLdfBlRootVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProBlLdfBlRootVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibConVvd = (JSPUtil.getParameter(request, prefix	+ "ib_con_vvd", length));
			String[] obConVvd = (JSPUtil.getParameter(request, prefix	+ "ob_con_vvd", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] portname = (JSPUtil.getParameter(request, prefix	+ "portname", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] ata = (JSPUtil.getParameter(request, prefix	+ "ata", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] nextport = (JSPUtil.getParameter(request, prefix	+ "nextport", length));
			String[] nextportEta = (JSPUtil.getParameter(request, prefix	+ "nextport_eta", length));
			String[] prevport = (JSPUtil.getParameter(request, prefix	+ "prevport", length));
			String[] prevportEtd = (JSPUtil.getParameter(request, prefix	+ "prevport_etd", length));
			String[] ioInd = (JSPUtil.getParameter(request, prefix	+ "io_ind", length));
			String[] compId = (JSPUtil.getParameter(request, prefix	+ "comp_id", length));
			String[] mrn = (JSPUtil.getParameter(request, prefix	+ "mrn", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] polAms = (JSPUtil.getParameter(request, prefix	+ "pol_ams", length));
			String[] polFullname = (JSPUtil.getParameter(request, prefix	+ "pol_fullname", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] podAms = (JSPUtil.getParameter(request, prefix	+ "pod_ams", length));
			String[] podFullname = (JSPUtil.getParameter(request, prefix	+ "pod_fullname", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] porAms = (JSPUtil.getParameter(request, prefix	+ "por_ams", length));
			String[] porFullname = (JSPUtil.getParameter(request, prefix	+ "por_fullname", length));
			String[] porYard = (JSPUtil.getParameter(request, prefix	+ "por_yard", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] delAms = (JSPUtil.getParameter(request, prefix	+ "del_ams", length));
			String[] delFullname = (JSPUtil.getParameter(request, prefix	+ "del_fullname", length));
			String[] delYard = (JSPUtil.getParameter(request, prefix	+ "del_yard", length));
			String[] svcScp = (JSPUtil.getParameter(request, prefix	+ "svc_scp", length));
			String[] blCmplSts = (JSPUtil.getParameter(request, prefix	+ "bl_cmpl_sts", length));
			String[] blCmplTp = (JSPUtil.getParameter(request, prefix	+ "bl_cmpl_tp", length));
			String[] blrly = (JSPUtil.getParameter(request, prefix	+ "blrly", length));
			String[] rlyAms = (JSPUtil.getParameter(request, prefix	+ "rly_ams", length));
			String[] rlyFullname = (JSPUtil.getParameter(request, prefix	+ "rly_fullname", length));
			String[] blplace = (JSPUtil.getParameter(request, prefix	+ "blplace", length));
			String[] bldate = (JSPUtil.getParameter(request, prefix	+ "bldate", length));
			String[] blcopy = (JSPUtil.getParameter(request, prefix	+ "blcopy", length));
			String[] blorg = (JSPUtil.getParameter(request, prefix	+ "blorg", length));
			String[] blpkg = (JSPUtil.getParameter(request, prefix	+ "blpkg", length));
			String[] blpkgu = (JSPUtil.getParameter(request, prefix	+ "blpkgu", length));
			String[] blwgt = (JSPUtil.getParameter(request, prefix	+ "blwgt", length));
			String[] blWgtUnit = (JSPUtil.getParameter(request, prefix	+ "bl_wgt_unit", length));
			String[] blmea = (JSPUtil.getParameter(request, prefix	+ "blmea", length));
			String[] blMeaUnit = (JSPUtil.getParameter(request, prefix	+ "bl_mea_unit", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype", length));
			String[] commodity = (JSPUtil.getParameter(request, prefix	+ "commodity", length));
			String[] blcmd = (JSPUtil.getParameter(request, prefix	+ "blcmd", length));
			String[] blrepcmdcd = (JSPUtil.getParameter(request, prefix	+ "blrepcmdcd", length));
			String[] blrepcmd = (JSPUtil.getParameter(request, prefix	+ "blrepcmd", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] ausQuar = (JSPUtil.getParameter(request, prefix	+ "aus_quar", length));
			String[] srnbr = (JSPUtil.getParameter(request, prefix	+ "srnbr", length));
			String[] bkgnbr = (JSPUtil.getParameter(request, prefix	+ "bkgnbr", length));
			String[] rgnBkgnbr = (JSPUtil.getParameter(request, prefix	+ "rgn_bkgnbr", length));
			String[] cvrdBy = (JSPUtil.getParameter(request, prefix	+ "cvrd_by", length));
			String[] scno = (JSPUtil.getParameter(request, prefix	+ "scno", length));
			String[] rfano = (JSPUtil.getParameter(request, prefix	+ "rfano", length));
			String[] twSoNo = (JSPUtil.getParameter(request, prefix	+ "tw_so_no", length));
			String[] waybillInd = (JSPUtil.getParameter(request, prefix	+ "waybill_ind", length));
			String[] custrefNum = (JSPUtil.getParameter(request, prefix	+ "custref_num", length));
			String[] finalEta = (JSPUtil.getParameter(request, prefix	+ "final_eta", length));
			String[] funcCode = (JSPUtil.getParameter(request, prefix	+ "func_code", length));
			String[] onboard = (JSPUtil.getParameter(request, prefix	+ "onboard", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] blts = (JSPUtil.getParameter(request, prefix	+ "blts", length));
			String[] bltp = (JSPUtil.getParameter(request, prefix	+ "bltp", length));
			String[] msn = (JSPUtil.getParameter(request, prefix	+ "msn", length));
			String[] msncfm = (JSPUtil.getParameter(request, prefix	+ "msncfm", length));
			String[] indAgree = (JSPUtil.getParameter(request, prefix	+ "ind_agree", length));
			String[] valueAgree = (JSPUtil.getParameter(request, prefix	+ "value_agree", length));
			String[] euMrnSeq = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_seq", length));
			String[] euMrnValue = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_value", length));
			String[] euPort = (JSPUtil.getParameter(request, prefix	+ "eu_port", length));
			String[] euMrnDate = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_date", length));
			String[] euMrnSource = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_source", length));
			String[] hantype = (JSPUtil.getParameter(request, prefix	+ "hantype", length));
			String[] count = (JSPUtil.getParameter(request, prefix	+ "count", length));
			String[] elno = (JSPUtil.getParameter(request, prefix	+ "elno", length));
			String[] elpk = (JSPUtil.getParameter(request, prefix	+ "elpk", length));
			String[] elpku = (JSPUtil.getParameter(request, prefix	+ "elpku", length));
			String[] elwt = (JSPUtil.getParameter(request, prefix	+ "elwt", length));
			String[] elwtu = (JSPUtil.getParameter(request, prefix	+ "elwtu", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new SitProBlLdfBlRootVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null) 
					model.setVvd(vvd[i]);
				if (ibConVvd[i] != null) 
					model.setIbConVvd(ibConVvd[i]);
				if (obConVvd[i] != null) 
					model.setObConVvd(obConVvd[i]);
				if (vslCallsign[i] != null) 
					model.setVslCallsign(vslCallsign[i]);
				if (vslLloydcode[i] != null) 
					model.setVslLloydcode(vslLloydcode[i]);
				if (vslFullname[i] != null) 
					model.setVslFullname(vslFullname[i]);
				if (vslFlag[i] != null) 
					model.setVslFlag(vslFlag[i]);
				if (port[i] != null) 
					model.setPort(port[i]);
				if (portname[i] != null) 
					model.setPortname(portname[i]);
				if (eta[i] != null) 
					model.setEta(eta[i]);
				if (etd[i] != null) 
					model.setEtd(etd[i]);
				if (ata[i] != null) 
					model.setAta(ata[i]);
				if (atd[i] != null) 
					model.setAtd(atd[i]);
				if (nextport[i] != null) 
					model.setNextport(nextport[i]);
				if (nextportEta[i] != null) 
					model.setNextportEta(nextportEta[i]);
				if (prevport[i] != null) 
					model.setPrevport(prevport[i]);
				if (prevportEtd[i] != null) 
					model.setPrevportEtd(prevportEtd[i]);
				if (ioInd[i] != null) 
					model.setIoInd(ioInd[i]);
				if (compId[i] != null) 
					model.setCompId(compId[i]);
				if (mrn[i] != null) 
					model.setMrn(mrn[i]);
				if (blnbr[i] != null) 
					model.setBlnbr(blnbr[i]);
				if (blpol[i] != null) 
					model.setBlpol(blpol[i]);
				if (polAms[i] != null) 
					model.setPolAms(polAms[i]);
				if (polFullname[i] != null) 
					model.setPolFullname(polFullname[i]);
				if (blpod[i] != null) 
					model.setBlpod(blpod[i]);
				if (podAms[i] != null) 
					model.setPodAms(podAms[i]);
				if (podFullname[i] != null) 
					model.setPodFullname(podFullname[i]);
				if (blpor[i] != null) 
					model.setBlpor(blpor[i]);
				if (porAms[i] != null) 
					model.setPorAms(porAms[i]);
				if (porFullname[i] != null) 
					model.setPorFullname(porFullname[i]);
				if (porYard[i] != null) 
					model.setPorYard(porYard[i]);
				if (bldel[i] != null) 
					model.setBldel(bldel[i]);
				if (delAms[i] != null) 
					model.setDelAms(delAms[i]);
				if (delFullname[i] != null) 
					model.setDelFullname(delFullname[i]);
				if (delYard[i] != null) 
					model.setDelYard(delYard[i]);
				if (svcScp[i] != null) 
					model.setSvcScp(svcScp[i]);
				if (blCmplSts[i] != null) 
					model.setBlCmplSts(blCmplSts[i]);
				if (blCmplTp[i] != null) 
					model.setBlCmplTp(blCmplTp[i]);
				if (blrly[i] != null) 
					model.setBlrly(blrly[i]);
				if (rlyAms[i] != null) 
					model.setRlyAms(rlyAms[i]);
				if (rlyFullname[i] != null) 
					model.setRlyFullname(rlyFullname[i]);
				if (blplace[i] != null) 
					model.setBlplace(blplace[i]);
				if (bldate[i] != null) 
					model.setBldate(bldate[i]);
				if (blcopy[i] != null) 
					model.setBlcopy(blcopy[i]);
				if (blorg[i] != null) 
					model.setBlorg(blorg[i]);
				if (blpkg[i] != null) 
					model.setBlpkg(blpkg[i]);
				if (blpkgu[i] != null) 
					model.setBlpkgu(blpkgu[i]);
				if (blwgt[i] != null) 
					model.setBlwgt(blwgt[i]);
				if (blWgtUnit[i] != null) 
					model.setBlWgtUnit(blWgtUnit[i]);
				if (blmea[i] != null) 
					model.setBlmea(blmea[i]);
				if (blMeaUnit[i] != null) 
					model.setBlMeaUnit(blMeaUnit[i]);
				if (rdtype[i] != null) 
					model.setRdtype(rdtype[i]);
				if (cargotype[i] != null) 
					model.setCargotype(cargotype[i]);
				if (commodity[i] != null) 
					model.setCommodity(commodity[i]);
				if (blcmd[i] != null) 
					model.setBlcmd(blcmd[i]);
				if (blrepcmdcd[i] != null) 
					model.setBlrepcmdcd(blrepcmdcd[i]);
				if (blrepcmd[i] != null) 
					model.setBlrepcmd(blrepcmd[i]);
				if (remark[i] != null) 
					model.setRemark(remark[i]);
				if (ausQuar[i] != null) 
					model.setAusQuar(ausQuar[i]);
				if (srnbr[i] != null) 
					model.setSrnbr(srnbr[i]);
				if (bkgnbr[i] != null) 
					model.setBkgnbr(bkgnbr[i]);
				if (rgnBkgnbr[i] != null) 
					model.setRgnBkgnbr(rgnBkgnbr[i]);
				if (cvrdBy[i] != null) 
					model.setCvrdBy(cvrdBy[i]);
				if (scno[i] != null) 
					model.setScno(scno[i]);
				if (rfano[i] != null) 
					model.setRfano(rfano[i]);
				if (twSoNo[i] != null) 
					model.setTwSoNo(twSoNo[i]);
				if (waybillInd[i] != null) 
					model.setWaybillInd(waybillInd[i]);
				if (custrefNum[i] != null) 
					model.setCustrefNum(custrefNum[i]);
				if (finalEta[i] != null) 
					model.setFinalEta(finalEta[i]);
				if (funcCode[i] != null) 
					model.setFuncCode(funcCode[i]);
				if (onboard[i] != null) 
					model.setOnboard(onboard[i]);
				if (invNo[i] != null) 
					model.setInvNo(invNo[i]);
				if (blts[i] != null) 
					model.setBlts(blts[i]);
				if (bltp[i] != null) 
					model.setBltp(bltp[i]);
				if (msn[i] != null) 
					model.setMsn(msn[i]);
				if (msncfm[i] != null) 
					model.setMsncfm(msncfm[i]);
				if (indAgree[i] != null) 
					model.setIndAgree(indAgree[i]);
				if (valueAgree[i] != null) 
					model.setValueAgree(valueAgree[i]);
				if (euMrnSeq[i] != null) 
					model.setEuMrnSeq(euMrnSeq[i]);
				if (euMrnValue[i] != null) 
					model.setEuMrnValue(euMrnValue[i]);
				if (euPort[i] != null) 
					model.setEuPort(euPort[i]);
				if (euMrnDate[i] != null) 
					model.setEuMrnDate(euMrnDate[i]);
				if (euMrnSource[i] != null) 
					model.setEuMrnSource(euMrnSource[i]);
				if (hantype[i] != null) 
					model.setHantype(hantype[i]);
				if (count[i] != null) 
					model.setCount(count[i]);
				if (elno[i] != null) 
					model.setElno(elno[i]);
				if (elpk[i] != null) 
					model.setElpk(elpk[i]);
				if (elpku[i] != null) 
					model.setElpku(elpku[i]);
				if (elwt[i] != null) 
					model.setElwt(elwt[i]);
				if (elwtu[i] != null) 
					model.setElwtu(elwtu[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProBlLdfBlRootVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProBlLdfBlRootVO[]
	 */
	public SitProBlLdfBlRootVO[] getSitProBlLdfBlRootVOs(){
		SitProBlLdfBlRootVO[] vos = (SitProBlLdfBlRootVO[])models.toArray(new SitProBlLdfBlRootVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibConVvd = this.ibConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obConVvd = this.obConVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode = this.vslLloydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portname = this.portname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ata = this.ata .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextport = this.nextport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextportEta = this.nextportEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevport = this.prevport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevportEtd = this.prevportEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioInd = this.ioInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compId = this.compId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrn = this.mrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAms = this.polAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullname = this.polFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAms = this.podAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFullname = this.podFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAms = this.porAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porFullname = this.porFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYard = this.porYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAms = this.delAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFullname = this.delFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYard = this.delYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScp = this.svcScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCmplSts = this.blCmplSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCmplTp = this.blCmplTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrly = this.blrly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyAms = this.rlyAms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyFullname = this.rlyFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplace = this.blplace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldate = this.bldate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blcopy = this.blcopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blorg = this.blorg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkg = this.blpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgu = this.blpkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgt = this.blwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blWgtUnit = this.blWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmea = this.blmea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMeaUnit = this.blMeaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodity = this.commodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blcmd = this.blcmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrepcmdcd = this.blrepcmdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrepcmd = this.blrepcmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ausQuar = this.ausQuar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srnbr = this.srnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnbr = this.bkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnBkgnbr = this.rgnBkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrdBy = this.cvrdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno = this.scno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfano = this.rfano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twSoNo = this.twSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.waybillInd = this.waybillInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custrefNum = this.custrefNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalEta = this.finalEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCode = this.funcCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onboard = this.onboard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blts = this.blts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bltp = this.bltp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msn = this.msn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msncfm = this.msncfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indAgree = this.indAgree .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valueAgree = this.valueAgree .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euMrnSeq = this.euMrnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euMrnValue = this.euMrnValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euPort = this.euPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euMrnDate = this.euMrnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euMrnSource = this.euMrnSource .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hantype = this.hantype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count = this.count .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elno = this.elno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elpk = this.elpk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elpku = this.elpku .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elwt = this.elwt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.elwtu = this.elwtu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}