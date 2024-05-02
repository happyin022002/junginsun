/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualReplanInfoVO.java
*@FileTitle : ManualReplanInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.10.16 오현경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.copreport.manualcntrmapping.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManualReplanInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManualReplanInfoVO> models = new ArrayList<ManualReplanInfoVO>();
	
	/* Column Info */
	private String subStsCd = null;
	/* Column Info */
	private String mstlclcd = null;
	/* Column Info */
	private String ttlExpnAmt = null;
	/* Column Info */
	private String prodRev = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String rplnMan = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String n1stTsPortCd = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obItchgCtnt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String routePc = null;
	/* Column Info */
	private String bkgcrtToDt = null;
	/* Column Info */
	private String bkgRcvDt = null;
	/* Column Info */
	private String routeSo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sts = null;
	/* Column Info */
	private String bkgcrtFmDt = null;
	/* Column Info */
	private String n3rdTsPortCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String rplnCnfm = null;
	/* Column Info */
	private String bkgRcvNo = null;
	/* Column Info */
	private String boundName = null;
	/* Column Info */
	private String officeCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n2ndTsPortCd = null;
	/* Column Info */
	private String ibItchgCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String routeCop = null;
	/* Column Info */
	private String cmAmt = null;
	/* Column Info */
	private String iscompled = null;
	/* Column Info */
	private String ttlTztmHrs = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String trnkAvalTeuspc = null;
	/* Column Info */
	private String pnd = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String iobndcd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManualReplanInfoVO() {}

	public ManualReplanInfoVO(String ibflag, String pagerows, String mstlclcd, String ttlExpnAmt, String bkgRcvNo, String prodRev, String boundName, String officeCd, String cnmvSeq, String creDt, String copNo, String n2ndTsPortCd, String ibItchgCtnt, String n1stTsPortCd, String pctlNo, String obItchgCtnt, String polCd, String trnkAvalTeuspc, String creOfcCd, String cntrTpszCd, String copStsCd, String delNodCd, String updUsrId, String rmk, String updDt, String routePc, String porNodCd, String routeCop, String cmAmt, String iscompled, String bkgRcvDt, String routeSo, String podCd, String ttlTztmHrs, String creUsrId, String bkgNo, String cntrNo, String sts, String cnmvYr, String iobndcd, String n3rdTsPortCd, String fromDt, String toDt, String pnd, String rplnMan, String rplnCnfm, String subStsCd, String bkgcrtFmDt, String bkgcrtToDt) {
		this.subStsCd = subStsCd;
		this.mstlclcd = mstlclcd;
		this.ttlExpnAmt = ttlExpnAmt;
		this.prodRev = prodRev;
		this.cnmvSeq = cnmvSeq;
		this.rplnMan = rplnMan;
		this.copNo = copNo;
		this.n1stTsPortCd = n1stTsPortCd;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.obItchgCtnt = obItchgCtnt;
		this.polCd = polCd;
		this.cntrTpszCd = cntrTpszCd;
		this.copStsCd = copStsCd;
		this.delNodCd = delNodCd;
		this.updUsrId = updUsrId;
		this.routePc = routePc;
		this.bkgcrtToDt = bkgcrtToDt;
		this.bkgRcvDt = bkgRcvDt;
		this.routeSo = routeSo;
		this.podCd = podCd;
		this.toDt = toDt;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.sts = sts;
		this.bkgcrtFmDt = bkgcrtFmDt;
		this.n3rdTsPortCd = n3rdTsPortCd;
		this.fromDt = fromDt;
		this.rplnCnfm = rplnCnfm;
		this.bkgRcvNo = bkgRcvNo;
		this.boundName = boundName;
		this.officeCd = officeCd;
		this.creDt = creDt;
		this.n2ndTsPortCd = n2ndTsPortCd;
		this.ibItchgCtnt = ibItchgCtnt;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.updDt = updDt;
		this.rmk = rmk;
		this.porNodCd = porNodCd;
		this.routeCop = routeCop;
		this.cmAmt = cmAmt;
		this.iscompled = iscompled;
		this.ttlTztmHrs = ttlTztmHrs;
		this.cntrNo = cntrNo;
		this.trnkAvalTeuspc = trnkAvalTeuspc;
		this.pnd = pnd;
		this.cnmvYr = cnmvYr;
		this.iobndcd = iobndcd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sub_sts_cd", getSubStsCd());
		this.hashColumns.put("mstlclcd", getMstlclcd());
		this.hashColumns.put("ttl_expn_amt", getTtlExpnAmt());
		this.hashColumns.put("prod_rev", getProdRev());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("rpln_man", getRplnMan());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("n1st_ts_port_cd", getN1stTsPortCd());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("route_pc", getRoutePc());
		this.hashColumns.put("bkgcrt_to_dt", getBkgcrtToDt());
		this.hashColumns.put("bkg_rcv_dt", getBkgRcvDt());
		this.hashColumns.put("route_so", getRouteSo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sts", getSts());
		this.hashColumns.put("bkgcrt_fm_dt", getBkgcrtFmDt());
		this.hashColumns.put("n3rd_ts_port_cd", getN3rdTsPortCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("rpln_cnfm", getRplnCnfm());
		this.hashColumns.put("bkg_rcv_no", getBkgRcvNo());
		this.hashColumns.put("bound_name", getBoundName());
		this.hashColumns.put("office_cd", getOfficeCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n2nd_ts_port_cd", getN2ndTsPortCd());
		this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("route_cop", getRouteCop());
		this.hashColumns.put("cm_amt", getCmAmt());
		this.hashColumns.put("iscompled", getIscompled());
		this.hashColumns.put("ttl_tztm_hrs", getTtlTztmHrs());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("trnk_aval_teuspc", getTrnkAvalTeuspc());
		this.hashColumns.put("pnd", getPnd());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("iobndcd", getIobndcd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sub_sts_cd", "subStsCd");
		this.hashFields.put("mstlclcd", "mstlclcd");
		this.hashFields.put("ttl_expn_amt", "ttlExpnAmt");
		this.hashFields.put("prod_rev", "prodRev");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("rpln_man", "rplnMan");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("n1st_ts_port_cd", "n1stTsPortCd");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("route_pc", "routePc");
		this.hashFields.put("bkgcrt_to_dt", "bkgcrtToDt");
		this.hashFields.put("bkg_rcv_dt", "bkgRcvDt");
		this.hashFields.put("route_so", "routeSo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sts", "sts");
		this.hashFields.put("bkgcrt_fm_dt", "bkgcrtFmDt");
		this.hashFields.put("n3rd_ts_port_cd", "n3rdTsPortCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("rpln_cnfm", "rplnCnfm");
		this.hashFields.put("bkg_rcv_no", "bkgRcvNo");
		this.hashFields.put("bound_name", "boundName");
		this.hashFields.put("office_cd", "officeCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n2nd_ts_port_cd", "n2ndTsPortCd");
		this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("route_cop", "routeCop");
		this.hashFields.put("cm_amt", "cmAmt");
		this.hashFields.put("iscompled", "iscompled");
		this.hashFields.put("ttl_tztm_hrs", "ttlTztmHrs");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("trnk_aval_teuspc", "trnkAvalTeuspc");
		this.hashFields.put("pnd", "pnd");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("iobndcd", "iobndcd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return subStsCd
	 */
	public String getSubStsCd() {
		return this.subStsCd;
	}
	
	/**
	 * Column Info
	 * @return mstlclcd
	 */
	public String getMstlclcd() {
		return this.mstlclcd;
	}
	
	/**
	 * Column Info
	 * @return ttlExpnAmt
	 */
	public String getTtlExpnAmt() {
		return this.ttlExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return prodRev
	 */
	public String getProdRev() {
		return this.prodRev;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return rplnMan
	 */
	public String getRplnMan() {
		return this.rplnMan;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPortCd
	 */
	public String getN1stTsPortCd() {
		return this.n1stTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return obItchgCtnt
	 */
	public String getObItchgCtnt() {
		return this.obItchgCtnt;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
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
	 * @return routePc
	 */
	public String getRoutePc() {
		return this.routePc;
	}
	
	/**
	 * Column Info
	 * @return bkgcrtToDt
	 */
	public String getBkgcrtToDt() {
		return this.bkgcrtToDt;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvDt
	 */
	public String getBkgRcvDt() {
		return this.bkgRcvDt;
	}
	
	/**
	 * Column Info
	 * @return routeSo
	 */
	public String getRouteSo() {
		return this.routeSo;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return sts
	 */
	public String getSts() {
		return this.sts;
	}
	
	/**
	 * Column Info
	 * @return bkgcrtFmDt
	 */
	public String getBkgcrtFmDt() {
		return this.bkgcrtFmDt;
	}
	
	/**
	 * Column Info
	 * @return n3rdTsPortCd
	 */
	public String getN3rdTsPortCd() {
		return this.n3rdTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return rplnCnfm
	 */
	public String getRplnCnfm() {
		return this.rplnCnfm;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvNo
	 */
	public String getBkgRcvNo() {
		return this.bkgRcvNo;
	}
	
	/**
	 * Column Info
	 * @return boundName
	 */
	public String getBoundName() {
		return this.boundName;
	}
	
	/**
	 * Column Info
	 * @return officeCd
	 */
	public String getOfficeCd() {
		return this.officeCd;
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
	 * @return n2ndTsPortCd
	 */
	public String getN2ndTsPortCd() {
		return this.n2ndTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return ibItchgCtnt
	 */
	public String getIbItchgCtnt() {
		return this.ibItchgCtnt;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return routeCop
	 */
	public String getRouteCop() {
		return this.routeCop;
	}
	
	/**
	 * Column Info
	 * @return cmAmt
	 */
	public String getCmAmt() {
		return this.cmAmt;
	}
	
	/**
	 * Column Info
	 * @return iscompled
	 */
	public String getIscompled() {
		return this.iscompled;
	}
	
	/**
	 * Column Info
	 * @return ttlTztmHrs
	 */
	public String getTtlTztmHrs() {
		return this.ttlTztmHrs;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return trnkAvalTeuspc
	 */
	public String getTrnkAvalTeuspc() {
		return this.trnkAvalTeuspc;
	}
	
	/**
	 * Column Info
	 * @return pnd
	 */
	public String getPnd() {
		return this.pnd;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return iobndcd
	 */
	public String getIobndcd() {
		return this.iobndcd;
	}
	

	/**
	 * Column Info
	 * @param subStsCd
	 */
	public void setSubStsCd(String subStsCd) {
		this.subStsCd = subStsCd;
	}
	
	/**
	 * Column Info
	 * @param mstlclcd
	 */
	public void setMstlclcd(String mstlclcd) {
		this.mstlclcd = mstlclcd;
	}
	
	/**
	 * Column Info
	 * @param ttlExpnAmt
	 */
	public void setTtlExpnAmt(String ttlExpnAmt) {
		this.ttlExpnAmt = ttlExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param prodRev
	 */
	public void setProdRev(String prodRev) {
		this.prodRev = prodRev;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param rplnMan
	 */
	public void setRplnMan(String rplnMan) {
		this.rplnMan = rplnMan;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPortCd
	 */
	public void setN1stTsPortCd(String n1stTsPortCd) {
		this.n1stTsPortCd = n1stTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param obItchgCtnt
	 */
	public void setObItchgCtnt(String obItchgCtnt) {
		this.obItchgCtnt = obItchgCtnt;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
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
	 * @param routePc
	 */
	public void setRoutePc(String routePc) {
		this.routePc = routePc;
	}
	
	/**
	 * Column Info
	 * @param bkgcrtToDt
	 */
	public void setBkgcrtToDt(String bkgcrtToDt) {
		this.bkgcrtToDt = bkgcrtToDt;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvDt
	 */
	public void setBkgRcvDt(String bkgRcvDt) {
		this.bkgRcvDt = bkgRcvDt;
	}
	
	/**
	 * Column Info
	 * @param routeSo
	 */
	public void setRouteSo(String routeSo) {
		this.routeSo = routeSo;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param sts
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	/**
	 * Column Info
	 * @param bkgcrtFmDt
	 */
	public void setBkgcrtFmDt(String bkgcrtFmDt) {
		this.bkgcrtFmDt = bkgcrtFmDt;
	}
	
	/**
	 * Column Info
	 * @param n3rdTsPortCd
	 */
	public void setN3rdTsPortCd(String n3rdTsPortCd) {
		this.n3rdTsPortCd = n3rdTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param rplnCnfm
	 */
	public void setRplnCnfm(String rplnCnfm) {
		this.rplnCnfm = rplnCnfm;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvNo
	 */
	public void setBkgRcvNo(String bkgRcvNo) {
		this.bkgRcvNo = bkgRcvNo;
	}
	
	/**
	 * Column Info
	 * @param boundName
	 */
	public void setBoundName(String boundName) {
		this.boundName = boundName;
	}
	
	/**
	 * Column Info
	 * @param officeCd
	 */
	public void setOfficeCd(String officeCd) {
		this.officeCd = officeCd;
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
	 * @param n2ndTsPortCd
	 */
	public void setN2ndTsPortCd(String n2ndTsPortCd) {
		this.n2ndTsPortCd = n2ndTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param ibItchgCtnt
	 */
	public void setIbItchgCtnt(String ibItchgCtnt) {
		this.ibItchgCtnt = ibItchgCtnt;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param routeCop
	 */
	public void setRouteCop(String routeCop) {
		this.routeCop = routeCop;
	}
	
	/**
	 * Column Info
	 * @param cmAmt
	 */
	public void setCmAmt(String cmAmt) {
		this.cmAmt = cmAmt;
	}
	
	/**
	 * Column Info
	 * @param iscompled
	 */
	public void setIscompled(String iscompled) {
		this.iscompled = iscompled;
	}
	
	/**
	 * Column Info
	 * @param ttlTztmHrs
	 */
	public void setTtlTztmHrs(String ttlTztmHrs) {
		this.ttlTztmHrs = ttlTztmHrs;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param trnkAvalTeuspc
	 */
	public void setTrnkAvalTeuspc(String trnkAvalTeuspc) {
		this.trnkAvalTeuspc = trnkAvalTeuspc;
	}
	
	/**
	 * Column Info
	 * @param pnd
	 */
	public void setPnd(String pnd) {
		this.pnd = pnd;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param iobndcd
	 */
	public void setIobndcd(String iobndcd) {
		this.iobndcd = iobndcd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSubStsCd(JSPUtil.getParameter(request, "sub_sts_cd", ""));
		setMstlclcd(JSPUtil.getParameter(request, "mstlclcd", ""));
		setTtlExpnAmt(JSPUtil.getParameter(request, "ttl_expn_amt", ""));
		setProdRev(JSPUtil.getParameter(request, "prod_rev", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setRplnMan(JSPUtil.getParameter(request, "rpln_man", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setN1stTsPortCd(JSPUtil.getParameter(request, "n1st_ts_port_cd", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObItchgCtnt(JSPUtil.getParameter(request, "ob_itchg_ctnt", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRoutePc(JSPUtil.getParameter(request, "route_pc", ""));
		setBkgcrtToDt(JSPUtil.getParameter(request, "bkgcrt_to_dt", ""));
		setBkgRcvDt(JSPUtil.getParameter(request, "bkg_rcv_dt", ""));
		setRouteSo(JSPUtil.getParameter(request, "route_so", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSts(JSPUtil.getParameter(request, "sts", ""));
		setBkgcrtFmDt(JSPUtil.getParameter(request, "bkgcrt_fm_dt", ""));
		setN3rdTsPortCd(JSPUtil.getParameter(request, "n3rd_ts_port_cd", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setRplnCnfm(JSPUtil.getParameter(request, "rpln_cnfm", ""));
		setBkgRcvNo(JSPUtil.getParameter(request, "bkg_rcv_no", ""));
		setBoundName(JSPUtil.getParameter(request, "bound_name", ""));
		setOfficeCd(JSPUtil.getParameter(request, "office_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN2ndTsPortCd(JSPUtil.getParameter(request, "n2nd_ts_port_cd", ""));
		setIbItchgCtnt(JSPUtil.getParameter(request, "ib_itchg_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setRouteCop(JSPUtil.getParameter(request, "route_cop", ""));
		setCmAmt(JSPUtil.getParameter(request, "cm_amt", ""));
		setIscompled(JSPUtil.getParameter(request, "iscompled", ""));
		setTtlTztmHrs(JSPUtil.getParameter(request, "ttl_tztm_hrs", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTrnkAvalTeuspc(JSPUtil.getParameter(request, "trnk_aval_teuspc", ""));
		setPnd(JSPUtil.getParameter(request, "pnd", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setIobndcd(JSPUtil.getParameter(request, "iobndcd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManualReplanInfoVO[]
	 */
	public ManualReplanInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManualReplanInfoVO[]
	 */
	public ManualReplanInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManualReplanInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] subStsCd = (JSPUtil.getParameter(request, prefix	+ "sub_sts_cd", length));
			String[] mstlclcd = (JSPUtil.getParameter(request, prefix	+ "mstlclcd", length));
			String[] ttlExpnAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_expn_amt", length));
			String[] prodRev = (JSPUtil.getParameter(request, prefix	+ "prod_rev", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] rplnMan = (JSPUtil.getParameter(request, prefix	+ "rpln_man", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] n1stTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_port_cd", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ob_itchg_ctnt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] routePc = (JSPUtil.getParameter(request, prefix	+ "route_pc", length));
			String[] bkgcrtToDt = (JSPUtil.getParameter(request, prefix	+ "bkgcrt_to_dt", length));
			String[] bkgRcvDt = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_dt", length));
			String[] routeSo = (JSPUtil.getParameter(request, prefix	+ "route_so", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sts = (JSPUtil.getParameter(request, prefix	+ "sts", length));
			String[] bkgcrtFmDt = (JSPUtil.getParameter(request, prefix	+ "bkgcrt_fm_dt", length));
			String[] n3rdTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_ts_port_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] rplnCnfm = (JSPUtil.getParameter(request, prefix	+ "rpln_cnfm", length));
			String[] bkgRcvNo = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_no", length));
			String[] boundName = (JSPUtil.getParameter(request, prefix	+ "bound_name", length));
			String[] officeCd = (JSPUtil.getParameter(request, prefix	+ "office_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n2ndTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_port_cd", length));
			String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ib_itchg_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] routeCop = (JSPUtil.getParameter(request, prefix	+ "route_cop", length));
			String[] cmAmt = (JSPUtil.getParameter(request, prefix	+ "cm_amt", length));
			String[] iscompled = (JSPUtil.getParameter(request, prefix	+ "iscompled", length));
			String[] ttlTztmHrs = (JSPUtil.getParameter(request, prefix	+ "ttl_tztm_hrs", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] trnkAvalTeuspc = (JSPUtil.getParameter(request, prefix	+ "trnk_aval_teuspc", length));
			String[] pnd = (JSPUtil.getParameter(request, prefix	+ "pnd", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] iobndcd = (JSPUtil.getParameter(request, prefix	+ "iobndcd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManualReplanInfoVO();
				if (subStsCd[i] != null)
					model.setSubStsCd(subStsCd[i]);
				if (mstlclcd[i] != null)
					model.setMstlclcd(mstlclcd[i]);
				if (ttlExpnAmt[i] != null)
					model.setTtlExpnAmt(ttlExpnAmt[i]);
				if (prodRev[i] != null)
					model.setProdRev(prodRev[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (rplnMan[i] != null)
					model.setRplnMan(rplnMan[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (n1stTsPortCd[i] != null)
					model.setN1stTsPortCd(n1stTsPortCd[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obItchgCtnt[i] != null)
					model.setObItchgCtnt(obItchgCtnt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (routePc[i] != null)
					model.setRoutePc(routePc[i]);
				if (bkgcrtToDt[i] != null)
					model.setBkgcrtToDt(bkgcrtToDt[i]);
				if (bkgRcvDt[i] != null)
					model.setBkgRcvDt(bkgRcvDt[i]);
				if (routeSo[i] != null)
					model.setRouteSo(routeSo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sts[i] != null)
					model.setSts(sts[i]);
				if (bkgcrtFmDt[i] != null)
					model.setBkgcrtFmDt(bkgcrtFmDt[i]);
				if (n3rdTsPortCd[i] != null)
					model.setN3rdTsPortCd(n3rdTsPortCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (rplnCnfm[i] != null)
					model.setRplnCnfm(rplnCnfm[i]);
				if (bkgRcvNo[i] != null)
					model.setBkgRcvNo(bkgRcvNo[i]);
				if (boundName[i] != null)
					model.setBoundName(boundName[i]);
				if (officeCd[i] != null)
					model.setOfficeCd(officeCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n2ndTsPortCd[i] != null)
					model.setN2ndTsPortCd(n2ndTsPortCd[i]);
				if (ibItchgCtnt[i] != null)
					model.setIbItchgCtnt(ibItchgCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (routeCop[i] != null)
					model.setRouteCop(routeCop[i]);
				if (cmAmt[i] != null)
					model.setCmAmt(cmAmt[i]);
				if (iscompled[i] != null)
					model.setIscompled(iscompled[i]);
				if (ttlTztmHrs[i] != null)
					model.setTtlTztmHrs(ttlTztmHrs[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (trnkAvalTeuspc[i] != null)
					model.setTrnkAvalTeuspc(trnkAvalTeuspc[i]);
				if (pnd[i] != null)
					model.setPnd(pnd[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (iobndcd[i] != null)
					model.setIobndcd(iobndcd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManualReplanInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManualReplanInfoVO[]
	 */
	public ManualReplanInfoVO[] getManualReplanInfoVOs(){
		ManualReplanInfoVO[] vos = (ManualReplanInfoVO[])models.toArray(new ManualReplanInfoVO[models.size()]);
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
		this.subStsCd = this.subStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstlclcd = this.mstlclcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlExpnAmt = this.ttlExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prodRev = this.prodRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnMan = this.rplnMan .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPortCd = this.n1stTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obItchgCtnt = this.obItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routePc = this.routePc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgcrtToDt = this.bkgcrtToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvDt = this.bkgRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeSo = this.routeSo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sts = this.sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgcrtFmDt = this.bkgcrtFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTsPortCd = this.n3rdTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rplnCnfm = this.rplnCnfm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvNo = this.bkgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundName = this.boundName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officeCd = this.officeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPortCd = this.n2ndTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibItchgCtnt = this.ibItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeCop = this.routeCop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmAmt = this.cmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iscompled = this.iscompled .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTztmHrs = this.ttlTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAvalTeuspc = this.trnkAvalTeuspc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pnd = this.pnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iobndcd = this.iobndcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
