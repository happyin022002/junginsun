/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COPReplanInfoVO.java
*@FileTitle : COPReplanInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.24 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class COPReplanInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<COPReplanInfoVO> models = new ArrayList<COPReplanInfoVO>();
	
	/* Column Info */
	private String ttlExpnAmt = null;
	/* Column Info */
	private String prodRev = null;
	/* Column Info */
	private String boundName = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String n2ndTsPortCd = null;
	/* Column Info */
	private String ibItchgCtnt = null;
	/* Column Info */
	private String n1stTsPortCd = null;
	/* Column Info */
	private String actStsCd = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obItchgCtnt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trnkAvalTeuSpc = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copSubStsCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String maxGrpSeq = null;
	/* Column Info */
	private String isfrmchg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String isnodchg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String frmcd = null;
	/* Column Info */
	private String maxDtlSeq = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String fromPctlNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String cmAmt = null;
	/* Column Info */
	private String iscompled = null;
	/* Column Info */
	private String nodcd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ttlTztmHrs = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String n3rdTsPortCd = null;
	/* Column Info */
	private String toPctlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public COPReplanInfoVO() {}

	public COPReplanInfoVO(String ibflag, String pagerows, String copNo, String bkgNo, String cntrNo, String cnmvYr, String cnmvSeq, String copStsCd, String pctlNo, String cntrTpszCd, String porNodCd, String polCd, String n1stTsPortCd, String n2ndTsPortCd, String n3rdTsPortCd, String podCd, String delNodCd, String ttlTztmHrs, String prodRev, String ttlExpnAmt, String cmAmt, String trnkAvalTeuSpc, String obItchgCtnt, String ibItchgCtnt, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String boundName, String iscompled, String isnodchg, String nodcd, String isfrmchg, String frmcd, String copSubStsCd, String maxGrpSeq, String maxDtlSeq, String ioBndCd, String fromPctlNo, String toPctlNo, String actStsCd) {
		this.ttlExpnAmt = ttlExpnAmt;
		this.prodRev = prodRev;
		this.boundName = boundName;
		this.cnmvSeq = cnmvSeq;
		this.creDt = creDt;
		this.copNo = copNo;
		this.n2ndTsPortCd = n2ndTsPortCd;
		this.ibItchgCtnt = ibItchgCtnt;
		this.n1stTsPortCd = n1stTsPortCd;
		this.actStsCd = actStsCd;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.obItchgCtnt = obItchgCtnt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.trnkAvalTeuSpc = trnkAvalTeuSpc;
		this.creOfcCd = creOfcCd;
		this.cntrTpszCd = cntrTpszCd;
		this.copSubStsCd = copSubStsCd;
		this.copStsCd = copStsCd;
		this.delNodCd = delNodCd;
		this.maxGrpSeq = maxGrpSeq;
		this.isfrmchg = isfrmchg;
		this.updUsrId = updUsrId;
		this.isnodchg = isnodchg;
		this.updDt = updDt;
		this.frmcd = frmcd;
		this.maxDtlSeq = maxDtlSeq;
		this.porNodCd = porNodCd;
		this.fromPctlNo = fromPctlNo;
		this.ioBndCd = ioBndCd;
		this.cmAmt = cmAmt;
		this.iscompled = iscompled;
		this.nodcd = nodcd;
		this.podCd = podCd;
		this.ttlTztmHrs = ttlTztmHrs;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cnmvYr = cnmvYr;
		this.n3rdTsPortCd = n3rdTsPortCd;
		this.toPctlNo = toPctlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_expn_amt", getTtlExpnAmt());
		this.hashColumns.put("prod_rev", getProdRev());
		this.hashColumns.put("bound_name", getBoundName());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("n2nd_ts_port_cd", getN2ndTsPortCd());
		this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
		this.hashColumns.put("n1st_ts_port_cd", getN1stTsPortCd());
		this.hashColumns.put("act_sts_cd", getActStsCd());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trnk_aval_teu_spc", getTrnkAvalTeuSpc());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sub_sts_cd", getCopSubStsCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("max_grp_seq", getMaxGrpSeq());
		this.hashColumns.put("isfrmchg", getIsfrmchg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("isnodchg", getIsnodchg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("frmcd", getFrmcd());
		this.hashColumns.put("max_dtl_seq", getMaxDtlSeq());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("from_pctl_no", getFromPctlNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cm_amt", getCmAmt());
		this.hashColumns.put("iscompled", getIscompled());
		this.hashColumns.put("nodcd", getNodcd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ttl_tztm_hrs", getTtlTztmHrs());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("n3rd_ts_port_cd", getN3rdTsPortCd());
		this.hashColumns.put("to_pctl_no", getToPctlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_expn_amt", "ttlExpnAmt");
		this.hashFields.put("prod_rev", "prodRev");
		this.hashFields.put("bound_name", "boundName");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("n2nd_ts_port_cd", "n2ndTsPortCd");
		this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
		this.hashFields.put("n1st_ts_port_cd", "n1stTsPortCd");
		this.hashFields.put("act_sts_cd", "actStsCd");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trnk_aval_teu_spc", "trnkAvalTeuSpc");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sub_sts_cd", "copSubStsCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("max_grp_seq", "maxGrpSeq");
		this.hashFields.put("isfrmchg", "isfrmchg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("isnodchg", "isnodchg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("frmcd", "frmcd");
		this.hashFields.put("max_dtl_seq", "maxDtlSeq");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("from_pctl_no", "fromPctlNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cm_amt", "cmAmt");
		this.hashFields.put("iscompled", "iscompled");
		this.hashFields.put("nodcd", "nodcd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ttl_tztm_hrs", "ttlTztmHrs");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("n3rd_ts_port_cd", "n3rdTsPortCd");
		this.hashFields.put("to_pctl_no", "toPctlNo");
		return this.hashFields;
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
	 * @return boundName
	 */
	public String getBoundName() {
		return this.boundName;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * Column Info
	 * @return n1stTsPortCd
	 */
	public String getN1stTsPortCd() {
		return this.n1stTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return actStsCd
	 */
	public String getActStsCd() {
		return this.actStsCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return trnkAvalTeuSpc
	 */
	public String getTrnkAvalTeuSpc() {
		return this.trnkAvalTeuSpc;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return copSubStsCd
	 */
	public String getCopSubStsCd() {
		return this.copSubStsCd;
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
	 * @return maxGrpSeq
	 */
	public String getMaxGrpSeq() {
		return this.maxGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return isfrmchg
	 */
	public String getIsfrmchg() {
		return this.isfrmchg;
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
	 * @return isnodchg
	 */
	public String getIsnodchg() {
		return this.isnodchg;
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
	 * @return frmcd
	 */
	public String getFrmcd() {
		return this.frmcd;
	}
	
	/**
	 * Column Info
	 * @return maxDtlSeq
	 */
	public String getMaxDtlSeq() {
		return this.maxDtlSeq;
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
	 * @return fromPctlNo
	 */
	public String getFromPctlNo() {
		return this.fromPctlNo;
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
	 * @return nodcd
	 */
	public String getNodcd() {
		return this.nodcd;
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
	 * @return ttlTztmHrs
	 */
	public String getTtlTztmHrs() {
		return this.ttlTztmHrs;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return n3rdTsPortCd
	 */
	public String getN3rdTsPortCd() {
		return this.n3rdTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return toPctlNo
	 */
	public String getToPctlNo() {
		return this.toPctlNo;
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
	 * @param boundName
	 */
	public void setBoundName(String boundName) {
		this.boundName = boundName;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * Column Info
	 * @param n1stTsPortCd
	 */
	public void setN1stTsPortCd(String n1stTsPortCd) {
		this.n1stTsPortCd = n1stTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param actStsCd
	 */
	public void setActStsCd(String actStsCd) {
		this.actStsCd = actStsCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param trnkAvalTeuSpc
	 */
	public void setTrnkAvalTeuSpc(String trnkAvalTeuSpc) {
		this.trnkAvalTeuSpc = trnkAvalTeuSpc;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param copSubStsCd
	 */
	public void setCopSubStsCd(String copSubStsCd) {
		this.copSubStsCd = copSubStsCd;
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
	 * @param maxGrpSeq
	 */
	public void setMaxGrpSeq(String maxGrpSeq) {
		this.maxGrpSeq = maxGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param isfrmchg
	 */
	public void setIsfrmchg(String isfrmchg) {
		this.isfrmchg = isfrmchg;
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
	 * @param isnodchg
	 */
	public void setIsnodchg(String isnodchg) {
		this.isnodchg = isnodchg;
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
	 * @param frmcd
	 */
	public void setFrmcd(String frmcd) {
		this.frmcd = frmcd;
	}
	
	/**
	 * Column Info
	 * @param maxDtlSeq
	 */
	public void setMaxDtlSeq(String maxDtlSeq) {
		this.maxDtlSeq = maxDtlSeq;
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
	 * @param fromPctlNo
	 */
	public void setFromPctlNo(String fromPctlNo) {
		this.fromPctlNo = fromPctlNo;
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
	 * @param nodcd
	 */
	public void setNodcd(String nodcd) {
		this.nodcd = nodcd;
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
	 * @param ttlTztmHrs
	 */
	public void setTtlTztmHrs(String ttlTztmHrs) {
		this.ttlTztmHrs = ttlTztmHrs;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param n3rdTsPortCd
	 */
	public void setN3rdTsPortCd(String n3rdTsPortCd) {
		this.n3rdTsPortCd = n3rdTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param toPctlNo
	 */
	public void setToPctlNo(String toPctlNo) {
		this.toPctlNo = toPctlNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTtlExpnAmt(JSPUtil.getParameter(request, "ttl_expn_amt", ""));
		setProdRev(JSPUtil.getParameter(request, "prod_rev", ""));
		setBoundName(JSPUtil.getParameter(request, "bound_name", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setN2ndTsPortCd(JSPUtil.getParameter(request, "n2nd_ts_port_cd", ""));
		setIbItchgCtnt(JSPUtil.getParameter(request, "ib_itchg_ctnt", ""));
		setN1stTsPortCd(JSPUtil.getParameter(request, "n1st_ts_port_cd", ""));
		setActStsCd(JSPUtil.getParameter(request, "act_sts_cd", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObItchgCtnt(JSPUtil.getParameter(request, "ob_itchg_ctnt", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrnkAvalTeuSpc(JSPUtil.getParameter(request, "trnk_aval_teu_spc", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCopSubStsCd(JSPUtil.getParameter(request, "cop_sub_sts_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setMaxGrpSeq(JSPUtil.getParameter(request, "max_grp_seq", ""));
		setIsfrmchg(JSPUtil.getParameter(request, "isfrmchg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIsnodchg(JSPUtil.getParameter(request, "isnodchg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFrmcd(JSPUtil.getParameter(request, "frmcd", ""));
		setMaxDtlSeq(JSPUtil.getParameter(request, "max_dtl_seq", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setFromPctlNo(JSPUtil.getParameter(request, "from_pctl_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCmAmt(JSPUtil.getParameter(request, "cm_amt", ""));
		setIscompled(JSPUtil.getParameter(request, "iscompled", ""));
		setNodcd(JSPUtil.getParameter(request, "nodcd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTtlTztmHrs(JSPUtil.getParameter(request, "ttl_tztm_hrs", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setN3rdTsPortCd(JSPUtil.getParameter(request, "n3rd_ts_port_cd", ""));
		setToPctlNo(JSPUtil.getParameter(request, "to_pctl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return COPReplanInfoVO[]
	 */
	public COPReplanInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return COPReplanInfoVO[]
	 */
	public COPReplanInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		COPReplanInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlExpnAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_expn_amt", length));
			String[] prodRev = (JSPUtil.getParameter(request, prefix	+ "prod_rev", length));
			String[] boundName = (JSPUtil.getParameter(request, prefix	+ "bound_name", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] n2ndTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_port_cd", length));
			String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ib_itchg_ctnt", length));
			String[] n1stTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_port_cd", length));
			String[] actStsCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_cd", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ob_itchg_ctnt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trnkAvalTeuSpc = (JSPUtil.getParameter(request, prefix	+ "trnk_aval_teu_spc", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copSubStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sub_sts_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] maxGrpSeq = (JSPUtil.getParameter(request, prefix	+ "max_grp_seq", length));
			String[] isfrmchg = (JSPUtil.getParameter(request, prefix	+ "isfrmchg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] isnodchg = (JSPUtil.getParameter(request, prefix	+ "isnodchg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] frmcd = (JSPUtil.getParameter(request, prefix	+ "frmcd", length));
			String[] maxDtlSeq = (JSPUtil.getParameter(request, prefix	+ "max_dtl_seq", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] fromPctlNo = (JSPUtil.getParameter(request, prefix	+ "from_pctl_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] cmAmt = (JSPUtil.getParameter(request, prefix	+ "cm_amt", length));
			String[] iscompled = (JSPUtil.getParameter(request, prefix	+ "iscompled", length));
			String[] nodcd = (JSPUtil.getParameter(request, prefix	+ "nodcd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ttlTztmHrs = (JSPUtil.getParameter(request, prefix	+ "ttl_tztm_hrs", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] n3rdTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_ts_port_cd", length));
			String[] toPctlNo = (JSPUtil.getParameter(request, prefix	+ "to_pctl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new COPReplanInfoVO();
				if (ttlExpnAmt[i] != null)
					model.setTtlExpnAmt(ttlExpnAmt[i]);
				if (prodRev[i] != null)
					model.setProdRev(prodRev[i]);
				if (boundName[i] != null)
					model.setBoundName(boundName[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (n2ndTsPortCd[i] != null)
					model.setN2ndTsPortCd(n2ndTsPortCd[i]);
				if (ibItchgCtnt[i] != null)
					model.setIbItchgCtnt(ibItchgCtnt[i]);
				if (n1stTsPortCd[i] != null)
					model.setN1stTsPortCd(n1stTsPortCd[i]);
				if (actStsCd[i] != null)
					model.setActStsCd(actStsCd[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obItchgCtnt[i] != null)
					model.setObItchgCtnt(obItchgCtnt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trnkAvalTeuSpc[i] != null)
					model.setTrnkAvalTeuSpc(trnkAvalTeuSpc[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copSubStsCd[i] != null)
					model.setCopSubStsCd(copSubStsCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (maxGrpSeq[i] != null)
					model.setMaxGrpSeq(maxGrpSeq[i]);
				if (isfrmchg[i] != null)
					model.setIsfrmchg(isfrmchg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (isnodchg[i] != null)
					model.setIsnodchg(isnodchg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (frmcd[i] != null)
					model.setFrmcd(frmcd[i]);
				if (maxDtlSeq[i] != null)
					model.setMaxDtlSeq(maxDtlSeq[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (fromPctlNo[i] != null)
					model.setFromPctlNo(fromPctlNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (cmAmt[i] != null)
					model.setCmAmt(cmAmt[i]);
				if (iscompled[i] != null)
					model.setIscompled(iscompled[i]);
				if (nodcd[i] != null)
					model.setNodcd(nodcd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ttlTztmHrs[i] != null)
					model.setTtlTztmHrs(ttlTztmHrs[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (n3rdTsPortCd[i] != null)
					model.setN3rdTsPortCd(n3rdTsPortCd[i]);
				if (toPctlNo[i] != null)
					model.setToPctlNo(toPctlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCOPReplanInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return COPReplanInfoVO[]
	 */
	public COPReplanInfoVO[] getCOPReplanInfoVOs(){
		COPReplanInfoVO[] vos = (COPReplanInfoVO[])models.toArray(new COPReplanInfoVO[models.size()]);
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
		this.ttlExpnAmt = this.ttlExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prodRev = this.prodRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundName = this.boundName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPortCd = this.n2ndTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibItchgCtnt = this.ibItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPortCd = this.n1stTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsCd = this.actStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obItchgCtnt = this.obItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAvalTeuSpc = this.trnkAvalTeuSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copSubStsCd = this.copSubStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxGrpSeq = this.maxGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfrmchg = this.isfrmchg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isnodchg = this.isnodchg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmcd = this.frmcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDtlSeq = this.maxDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromPctlNo = this.fromPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmAmt = this.cmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iscompled = this.iscompled .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodcd = this.nodcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTztmHrs = this.ttlTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdTsPortCd = this.n3rdTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPctlNo = this.toPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
