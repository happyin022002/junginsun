/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurFeederCostInquiryVO.java
*@FileTitle : EurFeederCostInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24  
* 1.0 Creation
*--------------------------------------------------------
* History
* 2015.02.03 전지예 [CHM-201533794] [AOC] 45' Cost 추가
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.eurcostmgt.euroceanfeedercostmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurFeederCostInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurFeederCostInquiryVO> models = new ArrayList<EurFeederCostInquiryVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String agmtWgt20ft = null;
	/* Column Info */
	private String trsp40ftCostSysSrcNm = null;
	/* Column Info */
	private String mtyTrsp20ftCostSysSrcNm = null;
	/* Column Info */
	private String costTrfRoutSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String mtyTrsp45ftCostSysSrcNm = null;
	/* Column Info */
	private String fdr20ftTtlAmt = null;
	/* Column Info */
	private String mtyTrsp20ftTtlCostAmt = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String trsp40ftTtlCostAmt = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String mtyTrsp45ftAdjCostAmt = null;
	/* Column Info */
	private String fdr45ftTtlAmt = null;
	/* Column Info */
	private String trsp20ftCostSysSrcNm = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String tml45ftCostSysSrcNm = null;
	/* Column Info */
	private String trsp45ftAdjCostAmt = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Column Info */
	private String trsp20ftAdjCostAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mtyTrsp40ftAdjCostAmt = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String mtyTrsp45ftTtlCostAmt = null;
	/* Column Info */
	private String agmtWgt45ft = null;
	/* Column Info */
	private String mtyTrsp45ftCostAmt = null;
	/* Column Info */
	private String trsp45ftCostSysSrcNm = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String costTrfStsNm = null;
	/* Column Info */
	private String mtyTrsp40ftCostSysSrcNm = null;
	/* Column Info */
	private String tml40ftTtlCostAmt = null;
	/* Column Info */
	private String mtyTrsp20ftCostAmt = null;
	/* Column Info */
	private String mtyTrsp20ftAdjCostAmt = null;
	/* Column Info */
	private String tml20ftAdjCostAmt = null;
	/* Column Info */
	private String tml45ftTtlCostAmt = null;
	/* Column Info */
	private String tml45ftAdjCostAmt = null;
	/* Column Info */
	private String tml20ftCostSysSrcNm = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsp45ftCostAmt = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String mb45ftRto = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String fdr40ftTtlAmt = null;
	/* Column Info */
	private String tml40ftAdjCostAmt = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String pctlIoBndNm = null;
	/* Column Info */
	private String agmtWgt40ft = null;
	/* Column Info */
	private String mtyTrsp40ftTtlCostAmt = null;
	/* Column Info */
	private String tml45ftCostAmt = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String tml40ftCostSysSrcNm = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String trsp20ftTtlCostAmt = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String trsp40ftAdjCostAmt = null;
	/* Column Info */
	private String tml20ftTtlCostAmt = null;
	/* Column Info */
	private String trsp45ftTtlCostAmt = null;
	/* Column Info */
	private String agmtOldFlg = null;
	/* Column Info */
	private String updUsrNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EurFeederCostInquiryVO() {}

	public EurFeederCostInquiryVO(String ibflag, String pagerows, String agmtOldFlg, String agmtWgt20ft, String agmtWgt40ft, String agmtWgt45ft, String costTrfNo, String costTrfRoutSeq, String costTrfStsNm, String creOfcCd, String creUsrNm, String currCd, String dirCd, String effFmDt, String fdr20ftTtlAmt, String fdr40ftTtlAmt, String fdr45ftTtlAmt, String fmNodCd, String loclCreDt, String loclUpdDt, String mb20ftRto, String mb40ftRto, String mb45ftRto, String mtyTrsp20ftAdjCostAmt, String mtyTrsp20ftCostAmt, String mtyTrsp20ftCostSysSrcNm, String mtyTrsp20ftTtlCostAmt, String mtyTrsp40ftAdjCostAmt, String mtyTrsp40ftCostAmt, String mtyTrsp40ftCostSysSrcNm, String mtyTrsp40ftTtlCostAmt, String mtyTrsp45ftAdjCostAmt, String mtyTrsp45ftCostAmt, String mtyTrsp45ftCostSysSrcNm, String mtyTrsp45ftTtlCostAmt, String pctlIoBndNm, String sccCd, String tml20ftAdjCostAmt, String tml20ftCostAmt, String tml20ftCostSysSrcNm, String tml20ftTtlCostAmt, String tml40ftAdjCostAmt, String tml40ftCostAmt, String tml40ftCostSysSrcNm, String tml40ftTtlCostAmt, String tml45ftAdjCostAmt, String tml45ftCostAmt, String tml45ftCostSysSrcNm, String tml45ftTtlCostAmt, String toNodCd, String trsp20ftAdjCostAmt, String trsp20ftCostAmt, String trsp20ftCostSysSrcNm, String trsp20ftTtlCostAmt, String trsp40ftAdjCostAmt, String trsp40ftCostAmt, String trsp40ftCostSysSrcNm, String trsp40ftTtlCostAmt, String trsp45ftAdjCostAmt, String trsp45ftCostAmt, String trsp45ftCostSysSrcNm, String trsp45ftTtlCostAmt, String updOfcCd, String updUsrNm, String vndrNm, String vndrSeq, String wtrDeTermCd, String wtrRcvTermCd) {
		this.toNodCd = toNodCd;
		this.agmtWgt20ft = agmtWgt20ft;
		this.trsp40ftCostSysSrcNm = trsp40ftCostSysSrcNm;
		this.mtyTrsp20ftCostSysSrcNm = mtyTrsp20ftCostSysSrcNm;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.mtyTrsp45ftCostSysSrcNm = mtyTrsp45ftCostSysSrcNm;
		this.fdr20ftTtlAmt = fdr20ftTtlAmt;
		this.mtyTrsp20ftTtlCostAmt = mtyTrsp20ftTtlCostAmt;
		this.updOfcCd = updOfcCd;
		this.trsp40ftTtlCostAmt = trsp40ftTtlCostAmt;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.mtyTrsp45ftAdjCostAmt = mtyTrsp45ftAdjCostAmt;
		this.fdr45ftTtlAmt = fdr45ftTtlAmt;
		this.trsp20ftCostSysSrcNm = trsp20ftCostSysSrcNm;
		this.costTrfNo = costTrfNo;
		this.tml45ftCostSysSrcNm = tml45ftCostSysSrcNm;
		this.trsp45ftAdjCostAmt = trsp45ftAdjCostAmt;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.creUsrNm = creUsrNm;
		this.trsp20ftAdjCostAmt = trsp20ftAdjCostAmt;
		this.vndrSeq = vndrSeq;
		this.mtyTrsp40ftAdjCostAmt = mtyTrsp40ftAdjCostAmt;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.loclUpdDt = loclUpdDt;
		this.mtyTrsp45ftTtlCostAmt = mtyTrsp45ftTtlCostAmt;
		this.agmtWgt45ft = agmtWgt45ft;
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
		this.trsp45ftCostSysSrcNm = trsp45ftCostSysSrcNm;
		this.mb20ftRto = mb20ftRto;
		this.currCd = currCd;
		this.costTrfStsNm = costTrfStsNm;
		this.mtyTrsp40ftCostSysSrcNm = mtyTrsp40ftCostSysSrcNm;
		this.tml40ftTtlCostAmt = tml40ftTtlCostAmt;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.mtyTrsp20ftAdjCostAmt = mtyTrsp20ftAdjCostAmt;
		this.tml20ftAdjCostAmt = tml20ftAdjCostAmt;
		this.tml45ftTtlCostAmt = tml45ftTtlCostAmt;
		this.tml45ftAdjCostAmt = tml45ftAdjCostAmt;
		this.tml20ftCostSysSrcNm = tml20ftCostSysSrcNm;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.trsp45ftCostAmt = trsp45ftCostAmt;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.mb45ftRto = mb45ftRto;
		this.creOfcCd = creOfcCd;
		this.effFmDt = effFmDt;
		this.wtrDeTermCd = wtrDeTermCd;
		this.dirCd = dirCd;
		this.fdr40ftTtlAmt = fdr40ftTtlAmt;
		this.tml40ftAdjCostAmt = tml40ftAdjCostAmt;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.loclCreDt = loclCreDt;
		this.pctlIoBndNm = pctlIoBndNm;
		this.agmtWgt40ft = agmtWgt40ft;
		this.mtyTrsp40ftTtlCostAmt = mtyTrsp40ftTtlCostAmt;
		this.tml45ftCostAmt = tml45ftCostAmt;
		this.fmNodCd = fmNodCd;
		this.tml40ftCostSysSrcNm = tml40ftCostSysSrcNm;
		this.sccCd = sccCd;
		this.trsp20ftTtlCostAmt = trsp20ftTtlCostAmt;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.trsp40ftAdjCostAmt = trsp40ftAdjCostAmt;
		this.tml20ftTtlCostAmt = tml20ftTtlCostAmt;
		this.trsp45ftTtlCostAmt = trsp45ftTtlCostAmt;
		this.agmtOldFlg = agmtOldFlg;
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("agmt_wgt_20ft", getAgmtWgt20ft());
		this.hashColumns.put("trsp_40ft_cost_sys_src_nm", getTrsp40ftCostSysSrcNm());
		this.hashColumns.put("mty_trsp_20ft_cost_sys_src_nm", getMtyTrsp20ftCostSysSrcNm());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("mty_trsp_45ft_cost_sys_src_nm", getMtyTrsp45ftCostSysSrcNm());
		this.hashColumns.put("fdr_20ft_ttl_amt", getFdr20ftTtlAmt());
		this.hashColumns.put("mty_trsp_20ft_ttl_cost_amt", getMtyTrsp20ftTtlCostAmt());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("trsp_40ft_ttl_cost_amt", getTrsp40ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("mty_trsp_45ft_adj_cost_amt", getMtyTrsp45ftAdjCostAmt());
		this.hashColumns.put("fdr_45ft_ttl_amt", getFdr45ftTtlAmt());
		this.hashColumns.put("trsp_20ft_cost_sys_src_nm", getTrsp20ftCostSysSrcNm());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("tml_45ft_cost_sys_src_nm", getTml45ftCostSysSrcNm());
		this.hashColumns.put("trsp_45ft_adj_cost_amt", getTrsp45ftAdjCostAmt());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("trsp_20ft_adj_cost_amt", getTrsp20ftAdjCostAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mty_trsp_40ft_adj_cost_amt", getMtyTrsp40ftAdjCostAmt());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("mty_trsp_45ft_ttl_cost_amt", getMtyTrsp45ftTtlCostAmt());
		this.hashColumns.put("agmt_wgt_45ft", getAgmtWgt45ft());
		this.hashColumns.put("mty_trsp_45ft_cost_amt", getMtyTrsp45ftCostAmt());
		this.hashColumns.put("trsp_45ft_cost_sys_src_nm", getTrsp45ftCostSysSrcNm());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_trf_sts_nm", getCostTrfStsNm());
		this.hashColumns.put("mty_trsp_40ft_cost_sys_src_nm", getMtyTrsp40ftCostSysSrcNm());
		this.hashColumns.put("tml_40ft_ttl_cost_amt", getTml40ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("mty_trsp_20ft_adj_cost_amt", getMtyTrsp20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_adj_cost_amt", getTml20ftAdjCostAmt());
		this.hashColumns.put("tml_45ft_ttl_cost_amt", getTml45ftTtlCostAmt());
		this.hashColumns.put("tml_45ft_adj_cost_amt", getTml45ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_cost_sys_src_nm", getTml20ftCostSysSrcNm());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_45ft_cost_amt", getTrsp45ftCostAmt());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("mb_45ft_rto", getMb45ftRto());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("fdr_40ft_ttl_amt", getFdr40ftTtlAmt());
		this.hashColumns.put("tml_40ft_adj_cost_amt", getTml40ftAdjCostAmt());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("pctl_io_bnd_nm", getPctlIoBndNm());
		this.hashColumns.put("agmt_wgt_40ft", getAgmtWgt40ft());
		this.hashColumns.put("mty_trsp_40ft_ttl_cost_amt", getMtyTrsp40ftTtlCostAmt());
		this.hashColumns.put("tml_45ft_cost_amt", getTml45ftCostAmt());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("tml_40ft_cost_sys_src_nm", getTml40ftCostSysSrcNm());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("trsp_20ft_ttl_cost_amt", getTrsp20ftTtlCostAmt());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("trsp_40ft_adj_cost_amt", getTrsp40ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_ttl_cost_amt", getTml20ftTtlCostAmt());
		this.hashColumns.put("trsp_45ft_ttl_cost_amt", getTrsp45ftTtlCostAmt());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("agmt_wgt_20ft", "agmtWgt20ft");
		this.hashFields.put("trsp_40ft_cost_sys_src_nm", "trsp40ftCostSysSrcNm");
		this.hashFields.put("mty_trsp_20ft_cost_sys_src_nm", "mtyTrsp20ftCostSysSrcNm");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("mty_trsp_45ft_cost_sys_src_nm", "mtyTrsp45ftCostSysSrcNm");
		this.hashFields.put("fdr_20ft_ttl_amt", "fdr20ftTtlAmt");
		this.hashFields.put("mty_trsp_20ft_ttl_cost_amt", "mtyTrsp20ftTtlCostAmt");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("trsp_40ft_ttl_cost_amt", "trsp40ftTtlCostAmt");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("mty_trsp_45ft_adj_cost_amt", "mtyTrsp45ftAdjCostAmt");
		this.hashFields.put("fdr_45ft_ttl_amt", "fdr45ftTtlAmt");
		this.hashFields.put("trsp_20ft_cost_sys_src_nm", "trsp20ftCostSysSrcNm");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("tml_45ft_cost_sys_src_nm", "tml45ftCostSysSrcNm");
		this.hashFields.put("trsp_45ft_adj_cost_amt", "trsp45ftAdjCostAmt");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("trsp_20ft_adj_cost_amt", "trsp20ftAdjCostAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mty_trsp_40ft_adj_cost_amt", "mtyTrsp40ftAdjCostAmt");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("mty_trsp_45ft_ttl_cost_amt", "mtyTrsp45ftTtlCostAmt");
		this.hashFields.put("agmt_wgt_45ft", "agmtWgt45ft");
		this.hashFields.put("mty_trsp_45ft_cost_amt", "mtyTrsp45ftCostAmt");
		this.hashFields.put("trsp_45ft_cost_sys_src_nm", "trsp45ftCostSysSrcNm");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_trf_sts_nm", "costTrfStsNm");
		this.hashFields.put("mty_trsp_40ft_cost_sys_src_nm", "mtyTrsp40ftCostSysSrcNm");
		this.hashFields.put("tml_40ft_ttl_cost_amt", "tml40ftTtlCostAmt");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("mty_trsp_20ft_adj_cost_amt", "mtyTrsp20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_adj_cost_amt", "tml20ftAdjCostAmt");
		this.hashFields.put("tml_45ft_ttl_cost_amt", "tml45ftTtlCostAmt");
		this.hashFields.put("tml_45ft_adj_cost_amt", "tml45ftAdjCostAmt");
		this.hashFields.put("tml_20ft_cost_sys_src_nm", "tml20ftCostSysSrcNm");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_45ft_cost_amt", "trsp45ftCostAmt");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("mb_45ft_rto", "mb45ftRto");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("fdr_40ft_ttl_amt", "fdr40ftTtlAmt");
		this.hashFields.put("tml_40ft_adj_cost_amt", "tml40ftAdjCostAmt");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("pctl_io_bnd_nm", "pctlIoBndNm");
		this.hashFields.put("agmt_wgt_40ft", "agmtWgt40ft");
		this.hashFields.put("mty_trsp_40ft_ttl_cost_amt", "mtyTrsp40ftTtlCostAmt");
		this.hashFields.put("tml_45ft_cost_amt", "tml45ftCostAmt");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("tml_40ft_cost_sys_src_nm", "tml40ftCostSysSrcNm");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("trsp_20ft_ttl_cost_amt", "trsp20ftTtlCostAmt");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("trsp_40ft_adj_cost_amt", "trsp40ftAdjCostAmt");
		this.hashFields.put("tml_20ft_ttl_cost_amt", "tml20ftTtlCostAmt");
		this.hashFields.put("trsp_45ft_ttl_cost_amt", "trsp45ftTtlCostAmt");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return agmtWgt20ft
	 */
	public String getAgmtWgt20ft() {
		return this.agmtWgt20ft;
	}
	
	/**
	 * Column Info
	 * @return trsp40ftCostSysSrcNm
	 */
	public String getTrsp40ftCostSysSrcNm() {
		return this.trsp40ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp20ftCostSysSrcNm
	 */
	public String getMtyTrsp20ftCostSysSrcNm() {
		return this.mtyTrsp20ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return costTrfRoutSeq
	 */
	public String getCostTrfRoutSeq() {
		return this.costTrfRoutSeq;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp45ftCostSysSrcNm
	 */
	public String getMtyTrsp45ftCostSysSrcNm() {
		return this.mtyTrsp45ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return fdr20ftTtlAmt
	 */
	public String getFdr20ftTtlAmt() {
		return this.fdr20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp20ftTtlCostAmt
	 */
	public String getMtyTrsp20ftTtlCostAmt() {
		return this.mtyTrsp20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trsp40ftTtlCostAmt
	 */
	public String getTrsp40ftTtlCostAmt() {
		return this.trsp40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp40ftCostAmt
	 */
	public String getMtyTrsp40ftCostAmt() {
		return this.mtyTrsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp45ftAdjCostAmt
	 */
	public String getMtyTrsp45ftAdjCostAmt() {
		return this.mtyTrsp45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return fdr45ftTtlAmt
	 */
	public String getFdr45ftTtlAmt() {
		return this.fdr45ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftCostSysSrcNm
	 */
	public String getTrsp20ftCostSysSrcNm() {
		return this.trsp20ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return costTrfNo
	 */
	public String getCostTrfNo() {
		return this.costTrfNo;
	}
	
	/**
	 * Column Info
	 * @return tml45ftCostSysSrcNm
	 */
	public String getTml45ftCostSysSrcNm() {
		return this.tml45ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return trsp45ftAdjCostAmt
	 */
	public String getTrsp45ftAdjCostAmt() {
		return this.trsp45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp40ftCostAmt
	 */
	public String getTrsp40ftCostAmt() {
		return this.trsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftAdjCostAmt
	 */
	public String getTrsp20ftAdjCostAmt() {
		return this.trsp20ftAdjCostAmt;
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
	 * @return mtyTrsp40ftAdjCostAmt
	 */
	public String getMtyTrsp40ftAdjCostAmt() {
		return this.mtyTrsp40ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml40ftCostAmt
	 */
	public String getTml40ftCostAmt() {
		return this.tml40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return loclUpdDt
	 */
	public String getLoclUpdDt() {
		return this.loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp45ftTtlCostAmt
	 */
	public String getMtyTrsp45ftTtlCostAmt() {
		return this.mtyTrsp45ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtWgt45ft
	 */
	public String getAgmtWgt45ft() {
		return this.agmtWgt45ft;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp45ftCostAmt
	 */
	public String getMtyTrsp45ftCostAmt() {
		return this.mtyTrsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp45ftCostSysSrcNm
	 */
	public String getTrsp45ftCostSysSrcNm() {
		return this.trsp45ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return mb20ftRto
	 */
	public String getMb20ftRto() {
		return this.mb20ftRto;
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
	 * @return costTrfStsNm
	 */
	public String getCostTrfStsNm() {
		return this.costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp40ftCostSysSrcNm
	 */
	public String getMtyTrsp40ftCostSysSrcNm() {
		return this.mtyTrsp40ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return tml40ftTtlCostAmt
	 */
	public String getTml40ftTtlCostAmt() {
		return this.tml40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp20ftCostAmt
	 */
	public String getMtyTrsp20ftCostAmt() {
		return this.mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp20ftAdjCostAmt
	 */
	public String getMtyTrsp20ftAdjCostAmt() {
		return this.mtyTrsp20ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml20ftAdjCostAmt
	 */
	public String getTml20ftAdjCostAmt() {
		return this.tml20ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml45ftTtlCostAmt
	 */
	public String getTml45ftTtlCostAmt() {
		return this.tml45ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml45ftAdjCostAmt
	 */
	public String getTml45ftAdjCostAmt() {
		return this.tml45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml20ftCostSysSrcNm
	 */
	public String getTml20ftCostSysSrcNm() {
		return this.tml20ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return mb40ftRto
	 */
	public String getMb40ftRto() {
		return this.mb40ftRto;
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
	 * @return trsp45ftCostAmt
	 */
	public String getTrsp45ftCostAmt() {
		return this.trsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return mb45ftRto
	 */
	public String getMb45ftRto() {
		return this.mb45ftRto;
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
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return fdr40ftTtlAmt
	 */
	public String getFdr40ftTtlAmt() {
		return this.fdr40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return tml40ftAdjCostAmt
	 */
	public String getTml40ftAdjCostAmt() {
		return this.tml40ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftCostAmt
	 */
	public String getTrsp20ftCostAmt() {
		return this.trsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndNm
	 */
	public String getPctlIoBndNm() {
		return this.pctlIoBndNm;
	}
	
	/**
	 * Column Info
	 * @return agmtWgt40ft
	 */
	public String getAgmtWgt40ft() {
		return this.agmtWgt40ft;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp40ftTtlCostAmt
	 */
	public String getMtyTrsp40ftTtlCostAmt() {
		return this.mtyTrsp40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml45ftCostAmt
	 */
	public String getTml45ftCostAmt() {
		return this.tml45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return tml40ftCostSysSrcNm
	 */
	public String getTml40ftCostSysSrcNm() {
		return this.tml40ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftTtlCostAmt
	 */
	public String getTrsp20ftTtlCostAmt() {
		return this.trsp20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml20ftCostAmt
	 */
	public String getTml20ftCostAmt() {
		return this.tml20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp40ftAdjCostAmt
	 */
	public String getTrsp40ftAdjCostAmt() {
		return this.trsp40ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml20ftTtlCostAmt
	 */
	public String getTml20ftTtlCostAmt() {
		return this.tml20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trsp45ftTtlCostAmt
	 */
	public String getTrsp45ftTtlCostAmt() {
		return this.trsp45ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtOldFlg
	 */
	public String getAgmtOldFlg() {
		return this.agmtOldFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param agmtWgt20ft
	 */
	public void setAgmtWgt20ft(String agmtWgt20ft) {
		this.agmtWgt20ft = agmtWgt20ft;
	}
	
	/**
	 * Column Info
	 * @param trsp40ftCostSysSrcNm
	 */
	public void setTrsp40ftCostSysSrcNm(String trsp40ftCostSysSrcNm) {
		this.trsp40ftCostSysSrcNm = trsp40ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp20ftCostSysSrcNm
	 */
	public void setMtyTrsp20ftCostSysSrcNm(String mtyTrsp20ftCostSysSrcNm) {
		this.mtyTrsp20ftCostSysSrcNm = mtyTrsp20ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param costTrfRoutSeq
	 */
	public void setCostTrfRoutSeq(String costTrfRoutSeq) {
		this.costTrfRoutSeq = costTrfRoutSeq;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp45ftCostSysSrcNm
	 */
	public void setMtyTrsp45ftCostSysSrcNm(String mtyTrsp45ftCostSysSrcNm) {
		this.mtyTrsp45ftCostSysSrcNm = mtyTrsp45ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param fdr20ftTtlAmt
	 */
	public void setFdr20ftTtlAmt(String fdr20ftTtlAmt) {
		this.fdr20ftTtlAmt = fdr20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp20ftTtlCostAmt
	 */
	public void setMtyTrsp20ftTtlCostAmt(String mtyTrsp20ftTtlCostAmt) {
		this.mtyTrsp20ftTtlCostAmt = mtyTrsp20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trsp40ftTtlCostAmt
	 */
	public void setTrsp40ftTtlCostAmt(String trsp40ftTtlCostAmt) {
		this.trsp40ftTtlCostAmt = trsp40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp40ftCostAmt
	 */
	public void setMtyTrsp40ftCostAmt(String mtyTrsp40ftCostAmt) {
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp45ftAdjCostAmt
	 */
	public void setMtyTrsp45ftAdjCostAmt(String mtyTrsp45ftAdjCostAmt) {
		this.mtyTrsp45ftAdjCostAmt = mtyTrsp45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param fdr45ftTtlAmt
	 */
	public void setFdr45ftTtlAmt(String fdr45ftTtlAmt) {
		this.fdr45ftTtlAmt = fdr45ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftCostSysSrcNm
	 */
	public void setTrsp20ftCostSysSrcNm(String trsp20ftCostSysSrcNm) {
		this.trsp20ftCostSysSrcNm = trsp20ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param costTrfNo
	 */
	public void setCostTrfNo(String costTrfNo) {
		this.costTrfNo = costTrfNo;
	}
	
	/**
	 * Column Info
	 * @param tml45ftCostSysSrcNm
	 */
	public void setTml45ftCostSysSrcNm(String tml45ftCostSysSrcNm) {
		this.tml45ftCostSysSrcNm = tml45ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param trsp45ftAdjCostAmt
	 */
	public void setTrsp45ftAdjCostAmt(String trsp45ftAdjCostAmt) {
		this.trsp45ftAdjCostAmt = trsp45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp40ftCostAmt
	 */
	public void setTrsp40ftCostAmt(String trsp40ftCostAmt) {
		this.trsp40ftCostAmt = trsp40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftAdjCostAmt
	 */
	public void setTrsp20ftAdjCostAmt(String trsp20ftAdjCostAmt) {
		this.trsp20ftAdjCostAmt = trsp20ftAdjCostAmt;
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
	 * @param mtyTrsp40ftAdjCostAmt
	 */
	public void setMtyTrsp40ftAdjCostAmt(String mtyTrsp40ftAdjCostAmt) {
		this.mtyTrsp40ftAdjCostAmt = mtyTrsp40ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml40ftCostAmt
	 */
	public void setTml40ftCostAmt(String tml40ftCostAmt) {
		this.tml40ftCostAmt = tml40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param loclUpdDt
	 */
	public void setLoclUpdDt(String loclUpdDt) {
		this.loclUpdDt = loclUpdDt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp45ftTtlCostAmt
	 */
	public void setMtyTrsp45ftTtlCostAmt(String mtyTrsp45ftTtlCostAmt) {
		this.mtyTrsp45ftTtlCostAmt = mtyTrsp45ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtWgt45ft
	 */
	public void setAgmtWgt45ft(String agmtWgt45ft) {
		this.agmtWgt45ft = agmtWgt45ft;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp45ftCostAmt
	 */
	public void setMtyTrsp45ftCostAmt(String mtyTrsp45ftCostAmt) {
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp45ftCostSysSrcNm
	 */
	public void setTrsp45ftCostSysSrcNm(String trsp45ftCostSysSrcNm) {
		this.trsp45ftCostSysSrcNm = trsp45ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param mb20ftRto
	 */
	public void setMb20ftRto(String mb20ftRto) {
		this.mb20ftRto = mb20ftRto;
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
	 * @param costTrfStsNm
	 */
	public void setCostTrfStsNm(String costTrfStsNm) {
		this.costTrfStsNm = costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp40ftCostSysSrcNm
	 */
	public void setMtyTrsp40ftCostSysSrcNm(String mtyTrsp40ftCostSysSrcNm) {
		this.mtyTrsp40ftCostSysSrcNm = mtyTrsp40ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param tml40ftTtlCostAmt
	 */
	public void setTml40ftTtlCostAmt(String tml40ftTtlCostAmt) {
		this.tml40ftTtlCostAmt = tml40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp20ftCostAmt
	 */
	public void setMtyTrsp20ftCostAmt(String mtyTrsp20ftCostAmt) {
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp20ftAdjCostAmt
	 */
	public void setMtyTrsp20ftAdjCostAmt(String mtyTrsp20ftAdjCostAmt) {
		this.mtyTrsp20ftAdjCostAmt = mtyTrsp20ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml20ftAdjCostAmt
	 */
	public void setTml20ftAdjCostAmt(String tml20ftAdjCostAmt) {
		this.tml20ftAdjCostAmt = tml20ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml45ftTtlCostAmt
	 */
	public void setTml45ftTtlCostAmt(String tml45ftTtlCostAmt) {
		this.tml45ftTtlCostAmt = tml45ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml45ftAdjCostAmt
	 */
	public void setTml45ftAdjCostAmt(String tml45ftAdjCostAmt) {
		this.tml45ftAdjCostAmt = tml45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml20ftCostSysSrcNm
	 */
	public void setTml20ftCostSysSrcNm(String tml20ftCostSysSrcNm) {
		this.tml20ftCostSysSrcNm = tml20ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param mb40ftRto
	 */
	public void setMb40ftRto(String mb40ftRto) {
		this.mb40ftRto = mb40ftRto;
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
	 * @param trsp45ftCostAmt
	 */
	public void setTrsp45ftCostAmt(String trsp45ftCostAmt) {
		this.trsp45ftCostAmt = trsp45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param mb45ftRto
	 */
	public void setMb45ftRto(String mb45ftRto) {
		this.mb45ftRto = mb45ftRto;
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
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param fdr40ftTtlAmt
	 */
	public void setFdr40ftTtlAmt(String fdr40ftTtlAmt) {
		this.fdr40ftTtlAmt = fdr40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param tml40ftAdjCostAmt
	 */
	public void setTml40ftAdjCostAmt(String tml40ftAdjCostAmt) {
		this.tml40ftAdjCostAmt = tml40ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftCostAmt
	 */
	public void setTrsp20ftCostAmt(String trsp20ftCostAmt) {
		this.trsp20ftCostAmt = trsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndNm
	 */
	public void setPctlIoBndNm(String pctlIoBndNm) {
		this.pctlIoBndNm = pctlIoBndNm;
	}
	
	/**
	 * Column Info
	 * @param agmtWgt40ft
	 */
	public void setAgmtWgt40ft(String agmtWgt40ft) {
		this.agmtWgt40ft = agmtWgt40ft;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp40ftTtlCostAmt
	 */
	public void setMtyTrsp40ftTtlCostAmt(String mtyTrsp40ftTtlCostAmt) {
		this.mtyTrsp40ftTtlCostAmt = mtyTrsp40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml45ftCostAmt
	 */
	public void setTml45ftCostAmt(String tml45ftCostAmt) {
		this.tml45ftCostAmt = tml45ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param tml40ftCostSysSrcNm
	 */
	public void setTml40ftCostSysSrcNm(String tml40ftCostSysSrcNm) {
		this.tml40ftCostSysSrcNm = tml40ftCostSysSrcNm;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftTtlCostAmt
	 */
	public void setTrsp20ftTtlCostAmt(String trsp20ftTtlCostAmt) {
		this.trsp20ftTtlCostAmt = trsp20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml20ftCostAmt
	 */
	public void setTml20ftCostAmt(String tml20ftCostAmt) {
		this.tml20ftCostAmt = tml20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp40ftAdjCostAmt
	 */
	public void setTrsp40ftAdjCostAmt(String trsp40ftAdjCostAmt) {
		this.trsp40ftAdjCostAmt = trsp40ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml20ftTtlCostAmt
	 */
	public void setTml20ftTtlCostAmt(String tml20ftTtlCostAmt) {
		this.tml20ftTtlCostAmt = tml20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trsp45ftTtlCostAmt
	 */
	public void setTrsp45ftTtlCostAmt(String trsp45ftTtlCostAmt) {
		this.trsp45ftTtlCostAmt = trsp45ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param agmtOldFlg
	 */
	public void setAgmtOldFlg(String agmtOldFlg) {
		this.agmtOldFlg = agmtOldFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setAgmtWgt20ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_20ft", ""));
		setTrsp40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_sys_src_nm", ""));
		setMtyTrsp20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_sys_src_nm", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setMtyTrsp45ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_cost_sys_src_nm", ""));
		setFdr20ftTtlAmt(JSPUtil.getParameter(request, prefix + "fdr_20ft_ttl_amt", ""));
		setMtyTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_ttl_cost_amt", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_ttl_cost_amt", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setMtyTrsp45ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_adj_cost_amt", ""));
		setFdr45ftTtlAmt(JSPUtil.getParameter(request, prefix + "fdr_45ft_ttl_amt", ""));
		setTrsp20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_sys_src_nm", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setTml45ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_45ft_cost_sys_src_nm", ""));
		setTrsp45ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_adj_cost_amt", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_adj_cost_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMtyTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_adj_cost_amt", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setMtyTrsp45ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_ttl_cost_amt", ""));
		setAgmtWgt45ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_45ft", ""));
		setMtyTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_cost_amt", ""));
		setTrsp45ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_45ft_cost_sys_src_nm", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCostTrfStsNm(JSPUtil.getParameter(request, prefix + "cost_trf_sts_nm", ""));
		setMtyTrsp40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_sys_src_nm", ""));
		setTml40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_ttl_cost_amt", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setMtyTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_adj_cost_amt", ""));
		setTml20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_adj_cost_amt", ""));
		setTml45ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_ttl_cost_amt", ""));
		setTml45ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_adj_cost_amt", ""));
		setTml20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_sys_src_nm", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_cost_amt", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
		setMb45ftRto(JSPUtil.getParameter(request, prefix + "mb_45ft_rto", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setFdr40ftTtlAmt(JSPUtil.getParameter(request, prefix + "fdr_40ft_ttl_amt", ""));
		setTml40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_adj_cost_amt", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setPctlIoBndNm(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_nm", ""));
		setAgmtWgt40ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_40ft", ""));
		setMtyTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_ttl_cost_amt", ""));
		setTml45ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_cost_amt", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setTml40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_sys_src_nm", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_ttl_cost_amt", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_adj_cost_amt", ""));
		setTml20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_ttl_cost_amt", ""));
		setTrsp45ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_ttl_cost_amt", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurFeederCostInquiryVO[]
	 */
	public EurFeederCostInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurFeederCostInquiryVO[]
	 */
	public EurFeederCostInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurFeederCostInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] agmtWgt20ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_20ft", length));
			String[] trsp40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_sys_src_nm", length));
			String[] mtyTrsp20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_sys_src_nm", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] mtyTrsp45ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_cost_sys_src_nm", length));
			String[] fdr20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fdr_20ft_ttl_amt", length));
			String[] mtyTrsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_ttl_cost_amt", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] trsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_ttl_cost_amt", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] mtyTrsp45ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_adj_cost_amt", length));
			String[] fdr45ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fdr_45ft_ttl_amt", length));
			String[] trsp20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_sys_src_nm", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] tml45ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_cost_sys_src_nm", length));
			String[] trsp45ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_adj_cost_amt", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] trsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_adj_cost_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mtyTrsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_adj_cost_amt", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] mtyTrsp45ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_ttl_cost_amt", length));
			String[] agmtWgt45ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_45ft", length));
			String[] mtyTrsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_cost_amt", length));
			String[] trsp45ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_cost_sys_src_nm", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_nm", length));
			String[] mtyTrsp40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_sys_src_nm", length));
			String[] tml40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_ttl_cost_amt", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] mtyTrsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_adj_cost_amt", length));
			String[] tml20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_adj_cost_amt", length));
			String[] tml45ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_ttl_cost_amt", length));
			String[] tml45ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_adj_cost_amt", length));
			String[] tml20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_sys_src_nm", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_cost_amt", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] mb45ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_45ft_rto", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] fdr40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fdr_40ft_ttl_amt", length));
			String[] tml40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_adj_cost_amt", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] pctlIoBndNm = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_nm", length));
			String[] agmtWgt40ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_40ft", length));
			String[] mtyTrsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_ttl_cost_amt", length));
			String[] tml45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_cost_amt", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] tml40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_sys_src_nm", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] trsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_ttl_cost_amt", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] trsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_adj_cost_amt", length));
			String[] tml20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_ttl_cost_amt", length));
			String[] trsp45ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_ttl_cost_amt", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurFeederCostInquiryVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (agmtWgt20ft[i] != null)
					model.setAgmtWgt20ft(agmtWgt20ft[i]);
				if (trsp40ftCostSysSrcNm[i] != null)
					model.setTrsp40ftCostSysSrcNm(trsp40ftCostSysSrcNm[i]);
				if (mtyTrsp20ftCostSysSrcNm[i] != null)
					model.setMtyTrsp20ftCostSysSrcNm(mtyTrsp20ftCostSysSrcNm[i]);
				if (costTrfRoutSeq[i] != null)
					model.setCostTrfRoutSeq(costTrfRoutSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (mtyTrsp45ftCostSysSrcNm[i] != null)
					model.setMtyTrsp45ftCostSysSrcNm(mtyTrsp45ftCostSysSrcNm[i]);
				if (fdr20ftTtlAmt[i] != null)
					model.setFdr20ftTtlAmt(fdr20ftTtlAmt[i]);
				if (mtyTrsp20ftTtlCostAmt[i] != null)
					model.setMtyTrsp20ftTtlCostAmt(mtyTrsp20ftTtlCostAmt[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (trsp40ftTtlCostAmt[i] != null)
					model.setTrsp40ftTtlCostAmt(trsp40ftTtlCostAmt[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (mtyTrsp45ftAdjCostAmt[i] != null)
					model.setMtyTrsp45ftAdjCostAmt(mtyTrsp45ftAdjCostAmt[i]);
				if (fdr45ftTtlAmt[i] != null)
					model.setFdr45ftTtlAmt(fdr45ftTtlAmt[i]);
				if (trsp20ftCostSysSrcNm[i] != null)
					model.setTrsp20ftCostSysSrcNm(trsp20ftCostSysSrcNm[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (tml45ftCostSysSrcNm[i] != null)
					model.setTml45ftCostSysSrcNm(tml45ftCostSysSrcNm[i]);
				if (trsp45ftAdjCostAmt[i] != null)
					model.setTrsp45ftAdjCostAmt(trsp45ftAdjCostAmt[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (trsp20ftAdjCostAmt[i] != null)
					model.setTrsp20ftAdjCostAmt(trsp20ftAdjCostAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mtyTrsp40ftAdjCostAmt[i] != null)
					model.setMtyTrsp40ftAdjCostAmt(mtyTrsp40ftAdjCostAmt[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (mtyTrsp45ftTtlCostAmt[i] != null)
					model.setMtyTrsp45ftTtlCostAmt(mtyTrsp45ftTtlCostAmt[i]);
				if (agmtWgt45ft[i] != null)
					model.setAgmtWgt45ft(agmtWgt45ft[i]);
				if (mtyTrsp45ftCostAmt[i] != null)
					model.setMtyTrsp45ftCostAmt(mtyTrsp45ftCostAmt[i]);
				if (trsp45ftCostSysSrcNm[i] != null)
					model.setTrsp45ftCostSysSrcNm(trsp45ftCostSysSrcNm[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costTrfStsNm[i] != null)
					model.setCostTrfStsNm(costTrfStsNm[i]);
				if (mtyTrsp40ftCostSysSrcNm[i] != null)
					model.setMtyTrsp40ftCostSysSrcNm(mtyTrsp40ftCostSysSrcNm[i]);
				if (tml40ftTtlCostAmt[i] != null)
					model.setTml40ftTtlCostAmt(tml40ftTtlCostAmt[i]);
				if (mtyTrsp20ftCostAmt[i] != null)
					model.setMtyTrsp20ftCostAmt(mtyTrsp20ftCostAmt[i]);
				if (mtyTrsp20ftAdjCostAmt[i] != null)
					model.setMtyTrsp20ftAdjCostAmt(mtyTrsp20ftAdjCostAmt[i]);
				if (tml20ftAdjCostAmt[i] != null)
					model.setTml20ftAdjCostAmt(tml20ftAdjCostAmt[i]);
				if (tml45ftTtlCostAmt[i] != null)
					model.setTml45ftTtlCostAmt(tml45ftTtlCostAmt[i]);
				if (tml45ftAdjCostAmt[i] != null)
					model.setTml45ftAdjCostAmt(tml45ftAdjCostAmt[i]);
				if (tml20ftCostSysSrcNm[i] != null)
					model.setTml20ftCostSysSrcNm(tml20ftCostSysSrcNm[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsp45ftCostAmt[i] != null)
					model.setTrsp45ftCostAmt(trsp45ftCostAmt[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (mb45ftRto[i] != null)
					model.setMb45ftRto(mb45ftRto[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (fdr40ftTtlAmt[i] != null)
					model.setFdr40ftTtlAmt(fdr40ftTtlAmt[i]);
				if (tml40ftAdjCostAmt[i] != null)
					model.setTml40ftAdjCostAmt(tml40ftAdjCostAmt[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (pctlIoBndNm[i] != null)
					model.setPctlIoBndNm(pctlIoBndNm[i]);
				if (agmtWgt40ft[i] != null)
					model.setAgmtWgt40ft(agmtWgt40ft[i]);
				if (mtyTrsp40ftTtlCostAmt[i] != null)
					model.setMtyTrsp40ftTtlCostAmt(mtyTrsp40ftTtlCostAmt[i]);
				if (tml45ftCostAmt[i] != null)
					model.setTml45ftCostAmt(tml45ftCostAmt[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (tml40ftCostSysSrcNm[i] != null)
					model.setTml40ftCostSysSrcNm(tml40ftCostSysSrcNm[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (trsp20ftTtlCostAmt[i] != null)
					model.setTrsp20ftTtlCostAmt(trsp20ftTtlCostAmt[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (trsp40ftAdjCostAmt[i] != null)
					model.setTrsp40ftAdjCostAmt(trsp40ftAdjCostAmt[i]);
				if (tml20ftTtlCostAmt[i] != null)
					model.setTml20ftTtlCostAmt(tml20ftTtlCostAmt[i]);
				if (trsp45ftTtlCostAmt[i] != null)
					model.setTrsp45ftTtlCostAmt(trsp45ftTtlCostAmt[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurFeederCostInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurFeederCostInquiryVO[]
	 */
	public EurFeederCostInquiryVO[] getEurFeederCostInquiryVOs(){
		EurFeederCostInquiryVO[] vos = (EurFeederCostInquiryVO[])models.toArray(new EurFeederCostInquiryVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWgt20ft = this.agmtWgt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostSysSrcNm = this.trsp40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostSysSrcNm = this.mtyTrsp20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftCostSysSrcNm = this.mtyTrsp45ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr20ftTtlAmt = this.fdr20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftTtlCostAmt = this.mtyTrsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftTtlCostAmt = this.trsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftAdjCostAmt = this.mtyTrsp45ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr45ftTtlAmt = this.fdr45ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostSysSrcNm = this.trsp20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftCostSysSrcNm = this.tml45ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftAdjCostAmt = this.trsp45ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftAdjCostAmt = this.trsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftAdjCostAmt = this.mtyTrsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftTtlCostAmt = this.mtyTrsp45ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWgt45ft = this.agmtWgt45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftCostAmt = this.mtyTrsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftCostSysSrcNm = this.trsp45ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsNm = this.costTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostSysSrcNm = this.mtyTrsp40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftTtlCostAmt = this.tml40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftAdjCostAmt = this.mtyTrsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftAdjCostAmt = this.tml20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftTtlCostAmt = this.tml45ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftAdjCostAmt = this.tml45ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSysSrcNm = this.tml20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftCostAmt = this.trsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb45ftRto = this.mb45ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr40ftTtlAmt = this.fdr40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftAdjCostAmt = this.tml40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndNm = this.pctlIoBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWgt40ft = this.agmtWgt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftTtlCostAmt = this.mtyTrsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftCostAmt = this.tml45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostSysSrcNm = this.tml40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftTtlCostAmt = this.trsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftAdjCostAmt = this.trsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftTtlCostAmt = this.tml20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftTtlCostAmt = this.trsp45ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
