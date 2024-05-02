/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EstmActRsltVO.java
*@FileTitle : EstmActRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.23
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.08.23 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstmActRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstmActRsltVO> models = new ArrayList<EstmActRsltVO>();
	
	/* Column Info */
	private String bsaQty = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String adjBsaSltPrc = null;
	/* Column Info */
	private String estmVvdHdrId = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String actAmt = null;
	/* Column Info */
	private String cntrBlkDivCd = null;
	/* Column Info */
	private String adjAcclAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String joStlJbNm = null;
	/* Column Info */
	private String estmActSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String adjRsltCd = null;
	/* Column Info */
	private String adjRmk = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String adjRlseRmk = null;
	/* Column Info */
	private String adjBsaQty = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String vndrCustSeq = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String acclAmtCorrFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String adjEstmFlg = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String diffAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String joCntrDivCtnt = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String adjEstmAmt = null;
	/* Column Info */
	private String acclAmt = null;
	/* Column Info */
	private String joIocDivCd = null;
	/* Column Info */
	private String joStlJbCd = null;
	/* Column Info */
	private String sysSrcId = null;
	/* Column Info */
	private String estmCnt = null;
	/* Column Info */
	private String totPageCnt = null;		// 페이지 수
	/* Column Info */
	private String seqNo = null;		// 순번
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstmActRsltVO() {}

	public EstmActRsltVO(String ibflag, String pagerows, String adjBsaSltPrc, String vslCd, String bsaQty, String estmVvdHdrId, String trdCd, String rlaneCd, String cntrBlkDivCd, String actAmt, String adjAcclAmt, String revDirCd, String locCd, String acctCd, String joStlJbNm, String estmActSeq, String updUsrId, String custCntCd, String adjRmk, String revYrmon, String adjBsaQty, String exeYrmon, String vndrCustSeq, String skdVoyNo, String joCrrCd, String estmAmt, String acclAmtCorrFlg, String custSeq, String adjEstmFlg, String skdDirCd, String estmVvdTpCd, String vvd, String creUsrId, String diffAmt, String joCntrDivCtnt, String bsaSltPrc, String reDivrCd, String adjEstmAmt, String joIocDivCd, String acclAmt, String joStlJbCd, String sysSrcId, String adjRlseRmk, String adjRsltCd, String estmCnt, String totPageCnt, String seqNo) {
		this.bsaQty = bsaQty;
		this.vslCd = vslCd;
		this.adjBsaSltPrc = adjBsaSltPrc;
		this.estmVvdHdrId = estmVvdHdrId;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.actAmt = actAmt;
		this.cntrBlkDivCd = cntrBlkDivCd;
		this.adjAcclAmt = adjAcclAmt;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.joStlJbNm = joStlJbNm;
		this.estmActSeq = estmActSeq;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.adjRsltCd = adjRsltCd;
		this.adjRmk = adjRmk;
		this.revYrmon = revYrmon;
		this.adjRlseRmk = adjRlseRmk;
		this.adjBsaQty = adjBsaQty;
		this.exeYrmon = exeYrmon;
		this.vndrCustSeq = vndrCustSeq;
		this.estmAmt = estmAmt;
		this.skdVoyNo = skdVoyNo;
		this.joCrrCd = joCrrCd;
		this.custSeq = custSeq;
		this.acclAmtCorrFlg = acclAmtCorrFlg;
		this.skdDirCd = skdDirCd;
		this.adjEstmFlg = adjEstmFlg;
		this.estmVvdTpCd = estmVvdTpCd;
		this.vvd = vvd;
		this.diffAmt = diffAmt;
		this.creUsrId = creUsrId;
		this.joCntrDivCtnt = joCntrDivCtnt;
		this.bsaSltPrc = bsaSltPrc;
		this.reDivrCd = reDivrCd;
		this.adjEstmAmt = adjEstmAmt;
		this.acclAmt = acclAmt;
		this.joIocDivCd = joIocDivCd;
		this.joStlJbCd = joStlJbCd;
		this.sysSrcId = sysSrcId;
		this.estmCnt = estmCnt;		
		this.totPageCnt = totPageCnt;		
		this.seqNo = seqNo;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bsa_qty", getBsaQty());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("adj_bsa_slt_prc", getAdjBsaSltPrc());
		this.hashColumns.put("estm_vvd_hdr_id", getEstmVvdHdrId());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("act_amt", getActAmt());
		this.hashColumns.put("cntr_blk_div_cd", getCntrBlkDivCd());
		this.hashColumns.put("adj_accl_amt", getAdjAcclAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("jo_stl_jb_nm", getJoStlJbNm());
		this.hashColumns.put("estm_act_seq", getEstmActSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("adj_rslt_cd", getAdjRsltCd());
		this.hashColumns.put("adj_rmk", getAdjRmk());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("adj_rlse_rmk", getAdjRlseRmk());
		this.hashColumns.put("adj_bsa_qty", getAdjBsaQty());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("vndr_cust_seq", getVndrCustSeq());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("accl_amt_corr_flg", getAcclAmtCorrFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("adj_estm_flg", getAdjEstmFlg());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("jo_cntr_div_ctnt", getJoCntrDivCtnt());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("adj_estm_amt", getAdjEstmAmt());
		this.hashColumns.put("accl_amt", getAcclAmt());
		this.hashColumns.put("jo_ioc_div_cd", getJoIocDivCd());
		this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());
		this.hashColumns.put("sys_src_id", getSysSrcId());
		this.hashColumns.put("estm_cnt", getEstmCnt());		
		this.hashColumns.put("tot_page_cnt", getTotPageCnt());		
		this.hashColumns.put("seq_no", getSeqNo());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bsa_qty", "bsaQty");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("adj_bsa_slt_prc", "adjBsaSltPrc");
		this.hashFields.put("estm_vvd_hdr_id", "estmVvdHdrId");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("act_amt", "actAmt");
		this.hashFields.put("cntr_blk_div_cd", "cntrBlkDivCd");
		this.hashFields.put("adj_accl_amt", "adjAcclAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("jo_stl_jb_nm", "joStlJbNm");
		this.hashFields.put("estm_act_seq", "estmActSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("adj_rslt_cd", "adjRsltCd");
		this.hashFields.put("adj_rmk", "adjRmk");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("adj_rlse_rmk", "adjRlseRmk");
		this.hashFields.put("adj_bsa_qty", "adjBsaQty");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("vndr_cust_seq", "vndrCustSeq");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("accl_amt_corr_flg", "acclAmtCorrFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("adj_estm_flg", "adjEstmFlg");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("jo_cntr_div_ctnt", "joCntrDivCtnt");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("adj_estm_amt", "adjEstmAmt");
		this.hashFields.put("accl_amt", "acclAmt");
		this.hashFields.put("jo_ioc_div_cd", "joIocDivCd");
		this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");
		this.hashFields.put("sys_src_id", "sysSrcId");
		this.hashFields.put("estm_cnt", "estmCnt");
		this.hashFields.put("tot_page_cnt", "totPageCnt");	
		this.hashFields.put("seq_no", "seqNo");		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bsaQty
	 */
	public String getBsaQty() {
		return this.bsaQty;
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
	 * @return adjBsaSltPrc
	 */
	public String getAdjBsaSltPrc() {
		return this.adjBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return estmVvdHdrId
	 */
	public String getEstmVvdHdrId() {
		return this.estmVvdHdrId;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return actAmt
	 */
	public String getActAmt() {
		return this.actAmt;
	}
	
	/**
	 * Column Info
	 * @return cntrBlkDivCd
	 */
	public String getCntrBlkDivCd() {
		return this.cntrBlkDivCd;
	}
	
	/**
	 * Column Info
	 * @return adjAcclAmt
	 */
	public String getAdjAcclAmt() {
		return this.adjAcclAmt;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return joStlJbNm
	 */
	public String getJoStlJbNm() {
		return this.joStlJbNm;
	}
	
	/**
	 * Column Info
	 * @return estmActSeq
	 */
	public String getEstmActSeq() {
		return this.estmActSeq;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return adjRsltCd
	 */
	public String getAdjRsltCd() {
		return this.adjRsltCd;
	}
	
	/**
	 * Column Info
	 * @return adjRmk
	 */
	public String getAdjRmk() {
		return this.adjRmk;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return adjRlseRmk
	 */
	public String getAdjRlseRmk() {
		return this.adjRlseRmk;
	}
	
	/**
	 * Column Info
	 * @return adjBsaQty
	 */
	public String getAdjBsaQty() {
		return this.adjBsaQty;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return vndrCustSeq
	 */
	public String getVndrCustSeq() {
		return this.vndrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
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
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return acclAmtCorrFlg
	 */
	public String getAcclAmtCorrFlg() {
		return this.acclAmtCorrFlg;
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
	 * @return adjEstmFlg
	 */
	public String getAdjEstmFlg() {
		return this.adjEstmFlg;
	}
	
	/**
	 * Column Info
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
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
	 * @return diffAmt
	 */
	public String getDiffAmt() {
		return this.diffAmt;
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
	 * @return joCntrDivCtnt
	 */
	public String getJoCntrDivCtnt() {
		return this.joCntrDivCtnt;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return adjEstmAmt
	 */
	public String getAdjEstmAmt() {
		return this.adjEstmAmt;
	}
	
	/**
	 * Column Info
	 * @return acclAmt
	 */
	public String getAcclAmt() {
		return this.acclAmt;
	}
	
	/**
	 * Column Info
	 * @return joIocDivCd
	 */
	public String getJoIocDivCd() {
		return this.joIocDivCd;
	}
	
	/**
	 * Column Info
	 * @return joStlJbCd
	 */
	public String getJoStlJbCd() {
		return this.joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @return sysSrcId
	 */
	public String getSysSrcId() {
		return this.sysSrcId;
	}

	/**
	 * Column Info
	 * @return estmCnt
	 */
	public String getEstmCnt() {
		return this.estmCnt;
	}
	
	/**
	 * Column Info
	 * @return totPageCnt
	 */
	public String getTotPageCnt() {
		return this.totPageCnt;
	}

	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}

	
	/**
	 * Column Info
	 * @param bsaQty
	 */
	public void setBsaQty(String bsaQty) {
		this.bsaQty = bsaQty;
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
	 * @param adjBsaSltPrc
	 */
	public void setAdjBsaSltPrc(String adjBsaSltPrc) {
		this.adjBsaSltPrc = adjBsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param estmVvdHdrId
	 */
	public void setEstmVvdHdrId(String estmVvdHdrId) {
		this.estmVvdHdrId = estmVvdHdrId;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param actAmt
	 */
	public void setActAmt(String actAmt) {
		this.actAmt = actAmt;
	}
	
	/**
	 * Column Info
	 * @param cntrBlkDivCd
	 */
	public void setCntrBlkDivCd(String cntrBlkDivCd) {
		this.cntrBlkDivCd = cntrBlkDivCd;
	}
	
	/**
	 * Column Info
	 * @param adjAcclAmt
	 */
	public void setAdjAcclAmt(String adjAcclAmt) {
		this.adjAcclAmt = adjAcclAmt;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param joStlJbNm
	 */
	public void setJoStlJbNm(String joStlJbNm) {
		this.joStlJbNm = joStlJbNm;
	}
	
	/**
	 * Column Info
	 * @param estmActSeq
	 */
	public void setEstmActSeq(String estmActSeq) {
		this.estmActSeq = estmActSeq;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param adjRsltCd
	 */
	public void setAdjRsltCd(String adjRsltCd) {
		this.adjRsltCd = adjRsltCd;
	}
	
	/**
	 * Column Info
	 * @param adjRmk
	 */
	public void setAdjRmk(String adjRmk) {
		this.adjRmk = adjRmk;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param adjRlseRmk
	 */
	public void setAdjRlseRmk(String adjRlseRmk) {
		this.adjRlseRmk = adjRlseRmk;
	}
	
	/**
	 * Column Info
	 * @param adjBsaQty
	 */
	public void setAdjBsaQty(String adjBsaQty) {
		this.adjBsaQty = adjBsaQty;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param vndrCustSeq
	 */
	public void setVndrCustSeq(String vndrCustSeq) {
		this.vndrCustSeq = vndrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
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
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param acclAmtCorrFlg
	 */
	public void setAcclAmtCorrFlg(String acclAmtCorrFlg) {
		this.acclAmtCorrFlg = acclAmtCorrFlg;
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
	 * @param adjEstmFlg
	 */
	public void setAdjEstmFlg(String adjEstmFlg) {
		this.adjEstmFlg = adjEstmFlg;
	}
	
	/**
	 * Column Info
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
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
	 * @param diffAmt
	 */
	public void setDiffAmt(String diffAmt) {
		this.diffAmt = diffAmt;
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
	 * @param joCntrDivCtnt
	 */
	public void setJoCntrDivCtnt(String joCntrDivCtnt) {
		this.joCntrDivCtnt = joCntrDivCtnt;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param adjEstmAmt
	 */
	public void setAdjEstmAmt(String adjEstmAmt) {
		this.adjEstmAmt = adjEstmAmt;
	}
	
	/**
	 * Column Info
	 * @param acclAmt
	 */
	public void setAcclAmt(String acclAmt) {
		this.acclAmt = acclAmt;
	}
	
	/**
	 * Column Info
	 * @param joIocDivCd
	 */
	public void setJoIocDivCd(String joIocDivCd) {
		this.joIocDivCd = joIocDivCd;
	}
	
	/**
	 * Column Info
	 * @param joStlJbCd
	 */
	public void setJoStlJbCd(String joStlJbCd) {
		this.joStlJbCd = joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @param sysSrcId
	 */
	public void setSysSrcId(String sysSrcId) {
		this.sysSrcId = sysSrcId;
	}
	
	/**
	 * Column Info
	 * @param estmCnt
	 */
	public void setEstmCnt(String estmCnt) {
		this.estmCnt = estmCnt;
	}
	
	/**
	 * Column Info
	 * @param totPageCnt
	 */
	public void setTotPageCnt(String totPageCnt) {
		this.totPageCnt = totPageCnt;
	}

	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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
		setBsaQty(JSPUtil.getParameter(request, prefix + "bsa_qty", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setAdjBsaSltPrc(JSPUtil.getParameter(request, prefix + "adj_bsa_slt_prc", ""));
		setEstmVvdHdrId(JSPUtil.getParameter(request, prefix + "estm_vvd_hdr_id", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
		setCntrBlkDivCd(JSPUtil.getParameter(request, prefix + "cntr_blk_div_cd", ""));
		setAdjAcclAmt(JSPUtil.getParameter(request, prefix + "adj_accl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setJoStlJbNm(JSPUtil.getParameter(request, prefix + "jo_stl_jb_nm", ""));
		setEstmActSeq(JSPUtil.getParameter(request, prefix + "estm_act_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setAdjRsltCd(JSPUtil.getParameter(request, prefix + "adj_rslt_cd", ""));
		setAdjRmk(JSPUtil.getParameter(request, prefix + "adj_rmk", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setAdjRlseRmk(JSPUtil.getParameter(request, prefix + "adj_rlse_rmk", ""));
		setAdjBsaQty(JSPUtil.getParameter(request, prefix + "adj_bsa_qty", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setVndrCustSeq(JSPUtil.getParameter(request, prefix + "vndr_cust_seq", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setAcclAmtCorrFlg(JSPUtil.getParameter(request, prefix + "accl_amt_corr_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setAdjEstmFlg(JSPUtil.getParameter(request, prefix + "adj_estm_flg", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setDiffAmt(JSPUtil.getParameter(request, prefix + "diff_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setJoCntrDivCtnt(JSPUtil.getParameter(request, prefix + "jo_cntr_div_ctnt", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, prefix + "bsa_slt_prc", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setAdjEstmAmt(JSPUtil.getParameter(request, prefix + "adj_estm_amt", ""));
		setAcclAmt(JSPUtil.getParameter(request, prefix + "accl_amt", ""));
		setJoIocDivCd(JSPUtil.getParameter(request, prefix + "jo_ioc_div_cd", ""));
		setJoStlJbCd(JSPUtil.getParameter(request, prefix + "jo_stl_jb_cd", ""));
		setSysSrcId(JSPUtil.getParameter(request, prefix + "sys_src_id", ""));
		setEstmCnt(JSPUtil.getParameter(request, prefix + "estm_cnt", ""));		
		setTotPageCnt(JSPUtil.getParameter(request, prefix + "tot_page_cnt", ""));
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstmActRsltVO[]
	 */
	public EstmActRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstmActRsltVO[]
	 */
	public EstmActRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstmActRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bsaQty = (JSPUtil.getParameter(request, prefix	+ "bsa_qty", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] adjBsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "adj_bsa_slt_prc", length));
			String[] estmVvdHdrId = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_hdr_id", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] actAmt = (JSPUtil.getParameter(request, prefix	+ "act_amt", length));
			String[] cntrBlkDivCd = (JSPUtil.getParameter(request, prefix	+ "cntr_blk_div_cd", length));
			String[] adjAcclAmt = (JSPUtil.getParameter(request, prefix	+ "adj_accl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] joStlJbNm = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_nm", length));
			String[] estmActSeq = (JSPUtil.getParameter(request, prefix	+ "estm_act_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] adjRsltCd = (JSPUtil.getParameter(request, prefix	+ "adj_rslt_cd", length));
			String[] adjRmk = (JSPUtil.getParameter(request, prefix	+ "adj_rmk", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] adjRlseRmk = (JSPUtil.getParameter(request, prefix	+ "adj_rlse_rmk", length));
			String[] adjBsaQty = (JSPUtil.getParameter(request, prefix	+ "adj_bsa_qty", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] vndrCustSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_seq", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] acclAmtCorrFlg = (JSPUtil.getParameter(request, prefix	+ "accl_amt_corr_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] adjEstmFlg = (JSPUtil.getParameter(request, prefix	+ "adj_estm_flg", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] joCntrDivCtnt = (JSPUtil.getParameter(request, prefix	+ "jo_cntr_div_ctnt", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] adjEstmAmt = (JSPUtil.getParameter(request, prefix	+ "adj_estm_amt", length));
			String[] acclAmt = (JSPUtil.getParameter(request, prefix	+ "accl_amt", length));
			String[] joIocDivCd = (JSPUtil.getParameter(request, prefix	+ "jo_ioc_div_cd", length));
			String[] joStlJbCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd", length));
			String[] sysSrcId = (JSPUtil.getParameter(request, prefix	+ "sys_src_id", length));
			String[] estmCnt = (JSPUtil.getParameter(request, prefix	+ "estm_cnt", length));			
			String[] totPageCnt = (JSPUtil.getParameter(request, prefix	+ "tot_page_cnt", length));	
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));			
			
			for (int i = 0; i < length; i++) {
				model = new EstmActRsltVO();
				if (bsaQty[i] != null)
					model.setBsaQty(bsaQty[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (adjBsaSltPrc[i] != null)
					model.setAdjBsaSltPrc(adjBsaSltPrc[i]);
				if (estmVvdHdrId[i] != null)
					model.setEstmVvdHdrId(estmVvdHdrId[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (actAmt[i] != null)
					model.setActAmt(actAmt[i]);
				if (cntrBlkDivCd[i] != null)
					model.setCntrBlkDivCd(cntrBlkDivCd[i]);
				if (adjAcclAmt[i] != null)
					model.setAdjAcclAmt(adjAcclAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (joStlJbNm[i] != null)
					model.setJoStlJbNm(joStlJbNm[i]);
				if (estmActSeq[i] != null)
					model.setEstmActSeq(estmActSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (adjRsltCd[i] != null)
					model.setAdjRsltCd(adjRsltCd[i]);
				if (adjRmk[i] != null)
					model.setAdjRmk(adjRmk[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (adjRlseRmk[i] != null)
					model.setAdjRlseRmk(adjRlseRmk[i]);
				if (adjBsaQty[i] != null)
					model.setAdjBsaQty(adjBsaQty[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (vndrCustSeq[i] != null)
					model.setVndrCustSeq(vndrCustSeq[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (acclAmtCorrFlg[i] != null)
					model.setAcclAmtCorrFlg(acclAmtCorrFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (adjEstmFlg[i] != null)
					model.setAdjEstmFlg(adjEstmFlg[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (diffAmt[i] != null)
					model.setDiffAmt(diffAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (joCntrDivCtnt[i] != null)
					model.setJoCntrDivCtnt(joCntrDivCtnt[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (adjEstmAmt[i] != null)
					model.setAdjEstmAmt(adjEstmAmt[i]);
				if (acclAmt[i] != null)
					model.setAcclAmt(acclAmt[i]);
				if (joIocDivCd[i] != null)
					model.setJoIocDivCd(joIocDivCd[i]);
				if (joStlJbCd[i] != null)
					model.setJoStlJbCd(joStlJbCd[i]);
				if (sysSrcId[i] != null)
					model.setSysSrcId(sysSrcId[i]);
				if (estmCnt[i] != null)
					model.setEstmCnt(estmCnt[i]);
				if (totPageCnt[i] != null)
					model.setTotPageCnt(totPageCnt[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstmActRsltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstmActRsltVO[]
	 */
	public EstmActRsltVO[] getEstmActRsltVOs(){
		EstmActRsltVO[] vos = (EstmActRsltVO[])models.toArray(new EstmActRsltVO[models.size()]);
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
		this.bsaQty = this.bsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjBsaSltPrc = this.adjBsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdHdrId = this.estmVvdHdrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAmt = this.actAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrBlkDivCd = this.cntrBlkDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAcclAmt = this.adjAcclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbNm = this.joStlJbNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmActSeq = this.estmActSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRsltCd = this.adjRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRmk = this.adjRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjRlseRmk = this.adjRlseRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjBsaQty = this.adjBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustSeq = this.vndrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAmtCorrFlg = this.acclAmtCorrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjEstmFlg = this.adjEstmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntrDivCtnt = this.joCntrDivCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjEstmAmt = this.adjEstmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAmt = this.acclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joIocDivCd = this.joIocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCd = this.joStlJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSrcId = this.sysSrcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCnt = this.estmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.totPageCnt = this.totPageCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}