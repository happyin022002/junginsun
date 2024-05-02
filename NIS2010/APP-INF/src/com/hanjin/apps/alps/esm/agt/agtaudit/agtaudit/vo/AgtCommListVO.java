/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgtCommListVO.java
*@FileTitle : AgtCommListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.01
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.01 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo;

import java.lang.reflect.Field;
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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgtCommListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgtCommListVO> models = new ArrayList<AgtCommListVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String scp = null;
	/* Column Info */
	private String stsDv = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String tr = null;
	/* Column Info */
	private String commProcStsCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String sBlNo = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String comm1 = null;
	/* Column Info */
	private String comm2 = null;
	/* Column Info */
	private String exRate = null;
	/* Column Info */
	private String preAmt = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String lclAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String commProcStsRsn = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String brkg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chf = null;
	/* Column Info */
	private String acSeq = null;
	/* Column Info */
	private String doc = null;
	/* Column Info */
	private String agtCommCnt = null;
	/* Column Info */
	private String soc = null;
	/* Column Info */
	private String cross = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgtCommListVO() {}

	public AgtCommListVO(String ibflag, String pagerows, String scp, String svcScpCd, String port, String stsDv, String currCd, String ts, String tr, String bkgStsCd, String commProcStsCd, String searchDtTo, String sailArrDt, String blNo, String stsCd, String sBlNo, String agnCd, String blNos, String comm1, String comm2, String exRate, String preAmt, String bkgCreDt, String searchDtFr, String lclAmt, String updUsrId, String bkgOfcCd, String commProcRsltRsn, String commProcStsRsn, String sVvd, String ioBndCd, String arOfcCd, String brkg, String vvd, String bkgNo, String usdAmt, String creUsrId, String acSeq, String chf, String doc, String agtCommCnt, String soc, String cross) {
		this.port = port;
		this.scp = scp;
		this.stsDv = stsDv;
		this.currCd = currCd;
		this.ts = ts;
		this.tr = tr;
		this.commProcStsCd = commProcStsCd;
		this.bkgStsCd = bkgStsCd;
		this.svcScpCd = svcScpCd;
		this.searchDtTo = searchDtTo;
		this.sailArrDt = sailArrDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.sBlNo = sBlNo;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.blNos = blNos;
		this.comm1 = comm1;
		this.comm2 = comm2;
		this.exRate = exRate;
		this.preAmt = preAmt;
		this.bkgCreDt = bkgCreDt;
		this.searchDtFr = searchDtFr;
		this.lclAmt = lclAmt;
		this.updUsrId = updUsrId;
		this.commProcRsltRsn = commProcRsltRsn;
		this.bkgOfcCd = bkgOfcCd;
		this.commProcStsRsn = commProcStsRsn;
		this.sVvd = sVvd;
		this.ioBndCd = ioBndCd;
		this.arOfcCd = arOfcCd;
		this.vvd = vvd;
		this.brkg = brkg;
		this.creUsrId = creUsrId;
		this.usdAmt = usdAmt;
		this.bkgNo = bkgNo;
		this.chf = chf;
		this.acSeq = acSeq;
		this.doc = doc;
		this.agtCommCnt = agtCommCnt;
		this.soc = soc;
		this.cross = cross;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("scp", getScp());
		this.hashColumns.put("sts_dv", getStsDv());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("tr", getTr());
		this.hashColumns.put("comm_proc_sts_cd", getCommProcStsCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("s_bl_no", getSBlNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("comm1", getComm1());
		this.hashColumns.put("comm2", getComm2());
		this.hashColumns.put("ex_rate", getExRate());
		this.hashColumns.put("pre_amt", getPreAmt());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("lcl_amt", getLclAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("comm_proc_sts_rsn", getCommProcStsRsn());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("brkg", getBrkg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chf", getChf());
		this.hashColumns.put("ac_seq", getAcSeq());
		this.hashColumns.put("doc", getDoc());
		this.hashColumns.put("agt_comm_cnt", getAgtCommCnt());
		this.hashColumns.put("soc", getSoc());
		this.hashColumns.put("cross", getCross());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("scp", "scp");
		this.hashFields.put("sts_dv", "stsDv");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("tr", "tr");
		this.hashFields.put("comm_proc_sts_cd", "commProcStsCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("s_bl_no", "sBlNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("comm1", "comm1");
		this.hashFields.put("comm2", "comm2");
		this.hashFields.put("ex_rate", "exRate");
		this.hashFields.put("pre_amt", "preAmt");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("lcl_amt", "lclAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("comm_proc_sts_rsn", "commProcStsRsn");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("brkg", "brkg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chf", "chf");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("doc", "doc");
		this.hashFields.put("agt_comm_cnt", "agtCommCnt");
		this.hashFields.put("soc", "soc");
		this.hashFields.put("cross", "cross");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return scp
	 */
	public String getScp() {
		return this.scp;
	}
	
	/**
	 * Column Info
	 * @return stsDv
	 */
	public String getStsDv() {
		return this.stsDv;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return tr
	 */
	public String getTr() {
		return this.tr;
	}
	
	/**
	 * Column Info
	 * @return commProcStsCd
	 */
	public String getCommProcStsCd() {
		return this.commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return sBlNo
	 */
	public String getSBlNo() {
		return this.sBlNo;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
	}
	
	/**
	 * Column Info
	 * @return comm1
	 */
	public String getComm1() {
		return this.comm1;
	}
	
	/**
	 * Column Info
	 * @return comm2
	 */
	public String getComm2() {
		return this.comm2;
	}
	
	/**
	 * Column Info
	 * @return exRate
	 */
	public String getExRate() {
		return this.exRate;
	}
	
	/**
	 * Column Info
	 * @return preAmt
	 */
	public String getPreAmt() {
		return this.preAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
	}
	
	/**
	 * Column Info
	 * @return lclAmt
	 */
	public String getLclAmt() {
		return this.lclAmt;
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
	 * @return commProcRsltRsn
	 */
	public String getCommProcRsltRsn() {
		return this.commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return commProcStsRsn
	 */
	public String getCommProcStsRsn() {
		return this.commProcStsRsn;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
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
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return brkg
	 */
	public String getBrkg() {
		return this.brkg;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return chf
	 */
	public String getChf() {
		return this.chf;
	}
	
	/**
	 * Column Info
	 * @return acSeq
	 */
	public String getAcSeq() {
		return this.acSeq;
	}
	
	/**
	 * Column Info
	 * @return doc
	 */
	public String getDoc() {
		return this.doc;
	}
	
	/**
	 * Column Info
	 * @return agtCommCnt
	 */
	public String getAgtCommCnt() {
		return this.agtCommCnt;
	}
	
	/**
	 * Column Info
	 * @return soc
	 */
	public String getSoc() {
		return this.soc;
	}
	
	/**
	 * Column Info
	 * @return cross
	 */
	public String getCross() {
		return this.cross;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param scp
	 */
	public void setScp(String scp) {
		this.scp = scp;
	}
	
	/**
	 * Column Info
	 * @param stsDv
	 */
	public void setStsDv(String stsDv) {
		this.stsDv = stsDv;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param tr
	 */
	public void setTr(String tr) {
		this.tr = tr;
	}
	
	/**
	 * Column Info
	 * @param commProcStsCd
	 */
	public void setCommProcStsCd(String commProcStsCd) {
		this.commProcStsCd = commProcStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param sBlNo
	 */
	public void setSBlNo(String sBlNo) {
		this.sBlNo = sBlNo;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}
	
	/**
	 * Column Info
	 * @param comm1
	 */
	public void setComm1(String comm1) {
		this.comm1 = comm1;
	}
	
	/**
	 * Column Info
	 * @param comm2
	 */
	public void setComm2(String comm2) {
		this.comm2 = comm2;
	}
	
	/**
	 * Column Info
	 * @param exRate
	 */
	public void setExRate(String exRate) {
		this.exRate = exRate;
	}
	
	/**
	 * Column Info
	 * @param preAmt
	 */
	public void setPreAmt(String preAmt) {
		this.preAmt = preAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Column Info
	 * @param lclAmt
	 */
	public void setLclAmt(String lclAmt) {
		this.lclAmt = lclAmt;
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
	 * @param commProcRsltRsn
	 */
	public void setCommProcRsltRsn(String commProcRsltRsn) {
		this.commProcRsltRsn = commProcRsltRsn;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param commProcStsRsn
	 */
	public void setCommProcStsRsn(String commProcStsRsn) {
		this.commProcStsRsn = commProcStsRsn;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
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
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param brkg
	 */
	public void setBrkg(String brkg) {
		this.brkg = brkg;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param chf
	 */
	public void setChf(String chf) {
		this.chf = chf;
	}
	
	/**
	 * Column Info
	 * @param acSeq
	 */
	public void setAcSeq(String acSeq) {
		this.acSeq = acSeq;
	}
	
	/**
	 * Column Info
	 * @param doc
	 */
	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	/**
	 * Column Info
	 * @param agtCommCnt
	 */
	public void setAgtCommCnt(String agtCommCnt) {
		this.agtCommCnt = agtCommCnt;
	}
	
	/**
	 * Column Info
	 * @param soc
	 */
	public void setSoc(String soc) {
		this.soc = soc;
	}
	
	/**
	 * Column Info
	 * @param cross
	 */
	public void setCross(String cross) {
		this.cross = cross;
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
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setScp(JSPUtil.getParameter(request, prefix + "scp", ""));
		setStsDv(JSPUtil.getParameter(request, prefix + "sts_dv", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTs(JSPUtil.getParameter(request, prefix + "ts", ""));
		setTr(JSPUtil.getParameter(request, prefix + "tr", ""));
		setCommProcStsCd(JSPUtil.getParameter(request, prefix + "comm_proc_sts_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setSBlNo(JSPUtil.getParameter(request, prefix + "s_bl_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setComm1(JSPUtil.getParameter(request, prefix + "comm1", ""));
		setComm2(JSPUtil.getParameter(request, prefix + "comm2", ""));
		setExRate(JSPUtil.getParameter(request, prefix + "ex_rate", ""));
		setPreAmt(JSPUtil.getParameter(request, prefix + "pre_amt", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setLclAmt(JSPUtil.getParameter(request, prefix + "lcl_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCommProcRsltRsn(JSPUtil.getParameter(request, prefix + "comm_proc_rslt_rsn", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCommProcStsRsn(JSPUtil.getParameter(request, prefix + "comm_proc_sts_rsn", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBrkg(JSPUtil.getParameter(request, prefix + "brkg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChf(JSPUtil.getParameter(request, prefix + "chf", ""));
		setAcSeq(JSPUtil.getParameter(request, prefix + "ac_seq", ""));
		setDoc(JSPUtil.getParameter(request, prefix + "doc", ""));
		setAgtCommCnt(JSPUtil.getParameter(request, prefix + "agt_comm_cnt", ""));
		setSoc(JSPUtil.getParameter(request, prefix + "soc", ""));
		setCross(JSPUtil.getParameter(request, prefix + "cross", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgtCommListVO[]
	 */
	public AgtCommListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgtCommListVO[]
	 */
	public AgtCommListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgtCommListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] scp = (JSPUtil.getParameter(request, prefix	+ "scp", length));
			String[] stsDv = (JSPUtil.getParameter(request, prefix	+ "sts_dv", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] tr = (JSPUtil.getParameter(request, prefix	+ "tr", length));
			String[] commProcStsCd = (JSPUtil.getParameter(request, prefix	+ "comm_proc_sts_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] sBlNo = (JSPUtil.getParameter(request, prefix	+ "s_bl_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] comm1 = (JSPUtil.getParameter(request, prefix	+ "comm1", length));
			String[] comm2 = (JSPUtil.getParameter(request, prefix	+ "comm2", length));
			String[] exRate = (JSPUtil.getParameter(request, prefix	+ "ex_rate", length));
			String[] preAmt = (JSPUtil.getParameter(request, prefix	+ "pre_amt", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] lclAmt = (JSPUtil.getParameter(request, prefix	+ "lcl_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] commProcStsRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_sts_rsn", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] brkg = (JSPUtil.getParameter(request, prefix	+ "brkg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chf = (JSPUtil.getParameter(request, prefix	+ "chf", length));
			String[] acSeq = (JSPUtil.getParameter(request, prefix	+ "ac_seq", length));
			String[] doc = (JSPUtil.getParameter(request, prefix	+ "doc", length));
			String[] agtCommCnt = (JSPUtil.getParameter(request, prefix	+ "agt_comm_cnt", length));
			String[] soc = (JSPUtil.getParameter(request, prefix	+ "soc", length));
			String[] cross = (JSPUtil.getParameter(request, prefix	+ "cross", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgtCommListVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (scp[i] != null)
					model.setScp(scp[i]);
				if (stsDv[i] != null)
					model.setStsDv(stsDv[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (tr[i] != null)
					model.setTr(tr[i]);
				if (commProcStsCd[i] != null)
					model.setCommProcStsCd(commProcStsCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (sBlNo[i] != null)
					model.setSBlNo(sBlNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (comm1[i] != null)
					model.setComm1(comm1[i]);
				if (comm2[i] != null)
					model.setComm2(comm2[i]);
				if (exRate[i] != null)
					model.setExRate(exRate[i]);
				if (preAmt[i] != null)
					model.setPreAmt(preAmt[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (lclAmt[i] != null)
					model.setLclAmt(lclAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (commProcStsRsn[i] != null)
					model.setCommProcStsRsn(commProcStsRsn[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (brkg[i] != null)
					model.setBrkg(brkg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chf[i] != null)
					model.setChf(chf[i]);
				if (acSeq[i] != null)
					model.setAcSeq(acSeq[i]);
				if (doc[i] != null)
					model.setDoc(doc[i]);
				if (agtCommCnt[i] != null)
					model.setAgtCommCnt(agtCommCnt[i]);
				if (soc[i] != null)
					model.setSoc(soc[i]);
				if (cross[i] != null)
					model.setCross(cross[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgtCommListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgtCommListVO[]
	 */
	public AgtCommListVO[] getAgtCommListVOs(){
		AgtCommListVO[] vos = (AgtCommListVO[])models.toArray(new AgtCommListVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scp = this.scp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsDv = this.stsDv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tr = this.tr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcStsCd = this.commProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNo = this.sBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comm1 = this.comm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comm2 = this.comm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exRate = this.exRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preAmt = this.preAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmt = this.lclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commProcStsRsn = this.commProcStsRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkg = this.brkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chf = this.chf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq = this.acSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doc = this.doc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agtCommCnt = this.agtCommCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soc = this.soc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cross = this.cross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
