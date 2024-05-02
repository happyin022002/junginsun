/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchFeederReeferCostVO.java
*@FileTitle : SearchFeederReeferCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.05  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.costmanage.oceanfeedercostmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFeederReeferCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFeederReeferCostVO> models = new ArrayList<SearchFeederReeferCostVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String tml40ftCostSysSrcCd = null;
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
	private String mtyTrsp40ftCostSysSrcCd = null;
	/* Column Info */
	private String fdr20ftTtlAmt = null;
	/* Column Info */
	private String mtyTrsp20ftTtlCostAmt = null;
	/* Column Info */
	private String trsp40ftTtlCostAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String trsp20ftCostSysSrcNm = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String trsp20ftAdjCostAmt = null;
	/* Column Info */
	private String tml20ftCostSysSrcCd = null;
	/* Column Info */
	private String mtyTrsp40ftAdjCostAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String mb20ftRto = null;
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
	private String tml20ftCostSysSrcNm = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wtrRcvTermCd = null;
	/* Column Info */
	private String mtyTrsp20ftCostSysSrcCd = null;
	/* Column Info */
	private String trsp20ftCostSysSrcCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String wtrDeTermCd = null;
	/* Column Info */
	private String fdr40ftTtlAmt = null;
	/* Column Info */
	private String tml40ftAdjCostAmt = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String pctlIoBndNm = null;
	/* Column Info */
	private String mtyTrsp40ftTtlCostAmt = null;
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
	private String trsp40ftCostSysSrcCd = null;
	/* Column Info */
	private String trsp40ftAdjCostAmt = null;
	/* Column Info */
	private String tml20ftTtlCostAmt = null;
	/* Column Info */
	private String agmtOldFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFeederReeferCostVO() {}

	public SearchFeederReeferCostVO(String ibflag, String pagerows, String fmNodCd, String toNodCd, String pctlIoBndNm, String dirCd, String wtrRcvTermCd, String wtrDeTermCd, String fdr20ftTtlAmt, String fdr40ftTtlAmt, String sccCd, String mb20ftRto, String mb40ftRto, String trsp20ftCostSysSrcCd, String trsp20ftCostSysSrcNm, String trsp20ftCostAmt, String trsp20ftAdjCostAmt, String trsp20ftTtlCostAmt, String trsp40ftCostSysSrcCd, String trsp40ftCostSysSrcNm, String trsp40ftCostAmt, String trsp40ftAdjCostAmt, String trsp40ftTtlCostAmt, String mtyTrsp20ftCostSysSrcCd, String mtyTrsp20ftCostSysSrcNm, String mtyTrsp20ftCostAmt, String mtyTrsp20ftAdjCostAmt, String mtyTrsp20ftTtlCostAmt, String mtyTrsp40ftCostSysSrcCd, String mtyTrsp40ftCostSysSrcNm, String mtyTrsp40ftCostAmt, String mtyTrsp40ftAdjCostAmt, String mtyTrsp40ftTtlCostAmt, String tml20ftCostSysSrcCd, String tml20ftCostSysSrcNm, String tml20ftCostAmt, String tml20ftAdjCostAmt, String tml20ftTtlCostAmt, String tml40ftCostSysSrcCd, String tml40ftCostSysSrcNm, String tml40ftCostAmt, String tml40ftAdjCostAmt, String tml40ftTtlCostAmt, String vndrSeq, String vndrNm, String agmtOldFlg, String costTrfRoutSeq, String costTrfNo, String updUsrId) {
		this.toNodCd = toNodCd;
		this.tml40ftCostSysSrcCd = tml40ftCostSysSrcCd;
		this.trsp40ftCostSysSrcNm = trsp40ftCostSysSrcNm;
		this.mtyTrsp20ftCostSysSrcNm = mtyTrsp20ftCostSysSrcNm;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.mtyTrsp40ftCostSysSrcCd = mtyTrsp40ftCostSysSrcCd;
		this.fdr20ftTtlAmt = fdr20ftTtlAmt;
		this.mtyTrsp20ftTtlCostAmt = mtyTrsp20ftTtlCostAmt;
		this.trsp40ftTtlCostAmt = trsp40ftTtlCostAmt;
		this.updUsrId = updUsrId;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.trsp20ftCostSysSrcNm = trsp20ftCostSysSrcNm;
		this.costTrfNo = costTrfNo;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.trsp20ftAdjCostAmt = trsp20ftAdjCostAmt;
		this.tml20ftCostSysSrcCd = tml20ftCostSysSrcCd;
		this.mtyTrsp40ftAdjCostAmt = mtyTrsp40ftAdjCostAmt;
		this.vndrSeq = vndrSeq;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.mb20ftRto = mb20ftRto;
		this.mtyTrsp40ftCostSysSrcNm = mtyTrsp40ftCostSysSrcNm;
		this.tml40ftTtlCostAmt = tml40ftTtlCostAmt;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.mtyTrsp20ftAdjCostAmt = mtyTrsp20ftAdjCostAmt;
		this.tml20ftAdjCostAmt = tml20ftAdjCostAmt;
		this.tml20ftCostSysSrcNm = tml20ftCostSysSrcNm;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.wtrRcvTermCd = wtrRcvTermCd;
		this.mtyTrsp20ftCostSysSrcCd = mtyTrsp20ftCostSysSrcCd;
		this.trsp20ftCostSysSrcCd = trsp20ftCostSysSrcCd;
		this.dirCd = dirCd;
		this.wtrDeTermCd = wtrDeTermCd;
		this.fdr40ftTtlAmt = fdr40ftTtlAmt;
		this.tml40ftAdjCostAmt = tml40ftAdjCostAmt;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.pctlIoBndNm = pctlIoBndNm;
		this.mtyTrsp40ftTtlCostAmt = mtyTrsp40ftTtlCostAmt;
		this.fmNodCd = fmNodCd;
		this.tml40ftCostSysSrcNm = tml40ftCostSysSrcNm;
		this.sccCd = sccCd;
		this.trsp20ftTtlCostAmt = trsp20ftTtlCostAmt;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.trsp40ftCostSysSrcCd = trsp40ftCostSysSrcCd;
		this.trsp40ftAdjCostAmt = trsp40ftAdjCostAmt;
		this.tml20ftTtlCostAmt = tml20ftTtlCostAmt;
		this.agmtOldFlg = agmtOldFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("tml_40ft_cost_sys_src_cd", getTml40ftCostSysSrcCd());
		this.hashColumns.put("trsp_40ft_cost_sys_src_nm", getTrsp40ftCostSysSrcNm());
		this.hashColumns.put("mty_trsp_20ft_cost_sys_src_nm", getMtyTrsp20ftCostSysSrcNm());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("mty_trsp_40ft_cost_sys_src_cd", getMtyTrsp40ftCostSysSrcCd());
		this.hashColumns.put("fdr_20ft_ttl_amt", getFdr20ftTtlAmt());
		this.hashColumns.put("mty_trsp_20ft_ttl_cost_amt", getMtyTrsp20ftTtlCostAmt());
		this.hashColumns.put("trsp_40ft_ttl_cost_amt", getTrsp40ftTtlCostAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("trsp_20ft_cost_sys_src_nm", getTrsp20ftCostSysSrcNm());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("trsp_20ft_adj_cost_amt", getTrsp20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_cost_sys_src_cd", getTml20ftCostSysSrcCd());
		this.hashColumns.put("mty_trsp_40ft_adj_cost_amt", getMtyTrsp40ftAdjCostAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("mty_trsp_40ft_cost_sys_src_nm", getMtyTrsp40ftCostSysSrcNm());
		this.hashColumns.put("tml_40ft_ttl_cost_amt", getTml40ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("mty_trsp_20ft_adj_cost_amt", getMtyTrsp20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_adj_cost_amt", getTml20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_cost_sys_src_nm", getTml20ftCostSysSrcNm());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wtr_rcv_term_cd", getWtrRcvTermCd());
		this.hashColumns.put("mty_trsp_20ft_cost_sys_src_cd", getMtyTrsp20ftCostSysSrcCd());
		this.hashColumns.put("trsp_20ft_cost_sys_src_cd", getTrsp20ftCostSysSrcCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("wtr_de_term_cd", getWtrDeTermCd());
		this.hashColumns.put("fdr_40ft_ttl_amt", getFdr40ftTtlAmt());
		this.hashColumns.put("tml_40ft_adj_cost_amt", getTml40ftAdjCostAmt());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("pctl_io_bnd_nm", getPctlIoBndNm());
		this.hashColumns.put("mty_trsp_40ft_ttl_cost_amt", getMtyTrsp40ftTtlCostAmt());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("tml_40ft_cost_sys_src_nm", getTml40ftCostSysSrcNm());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("trsp_20ft_ttl_cost_amt", getTrsp20ftTtlCostAmt());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("trsp_40ft_cost_sys_src_cd", getTrsp40ftCostSysSrcCd());
		this.hashColumns.put("trsp_40ft_adj_cost_amt", getTrsp40ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_ttl_cost_amt", getTml20ftTtlCostAmt());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("tml_40ft_cost_sys_src_cd", "tml40ftCostSysSrcCd");
		this.hashFields.put("trsp_40ft_cost_sys_src_nm", "trsp40ftCostSysSrcNm");
		this.hashFields.put("mty_trsp_20ft_cost_sys_src_nm", "mtyTrsp20ftCostSysSrcNm");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("mty_trsp_40ft_cost_sys_src_cd", "mtyTrsp40ftCostSysSrcCd");
		this.hashFields.put("fdr_20ft_ttl_amt", "fdr20ftTtlAmt");
		this.hashFields.put("mty_trsp_20ft_ttl_cost_amt", "mtyTrsp20ftTtlCostAmt");
		this.hashFields.put("trsp_40ft_ttl_cost_amt", "trsp40ftTtlCostAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("trsp_20ft_cost_sys_src_nm", "trsp20ftCostSysSrcNm");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("trsp_20ft_adj_cost_amt", "trsp20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_cost_sys_src_cd", "tml20ftCostSysSrcCd");
		this.hashFields.put("mty_trsp_40ft_adj_cost_amt", "mtyTrsp40ftAdjCostAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("mty_trsp_40ft_cost_sys_src_nm", "mtyTrsp40ftCostSysSrcNm");
		this.hashFields.put("tml_40ft_ttl_cost_amt", "tml40ftTtlCostAmt");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("mty_trsp_20ft_adj_cost_amt", "mtyTrsp20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_adj_cost_amt", "tml20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_cost_sys_src_nm", "tml20ftCostSysSrcNm");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wtr_rcv_term_cd", "wtrRcvTermCd");
		this.hashFields.put("mty_trsp_20ft_cost_sys_src_cd", "mtyTrsp20ftCostSysSrcCd");
		this.hashFields.put("trsp_20ft_cost_sys_src_cd", "trsp20ftCostSysSrcCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("wtr_de_term_cd", "wtrDeTermCd");
		this.hashFields.put("fdr_40ft_ttl_amt", "fdr40ftTtlAmt");
		this.hashFields.put("tml_40ft_adj_cost_amt", "tml40ftAdjCostAmt");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("pctl_io_bnd_nm", "pctlIoBndNm");
		this.hashFields.put("mty_trsp_40ft_ttl_cost_amt", "mtyTrsp40ftTtlCostAmt");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("tml_40ft_cost_sys_src_nm", "tml40ftCostSysSrcNm");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("trsp_20ft_ttl_cost_amt", "trsp20ftTtlCostAmt");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("trsp_40ft_cost_sys_src_cd", "trsp40ftCostSysSrcCd");
		this.hashFields.put("trsp_40ft_adj_cost_amt", "trsp40ftAdjCostAmt");
		this.hashFields.put("tml_20ft_ttl_cost_amt", "tml20ftTtlCostAmt");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
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
	 * @return tml40ftCostSysSrcCd
	 */
	public String getTml40ftCostSysSrcCd() {
		return this.tml40ftCostSysSrcCd;
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
	 * @return mtyTrsp40ftCostSysSrcCd
	 */
	public String getMtyTrsp40ftCostSysSrcCd() {
		return this.mtyTrsp40ftCostSysSrcCd;
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
	 * @return trsp40ftTtlCostAmt
	 */
	public String getTrsp40ftTtlCostAmt() {
		return this.trsp40ftTtlCostAmt;
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
	 * @return mtyTrsp40ftCostAmt
	 */
	public String getMtyTrsp40ftCostAmt() {
		return this.mtyTrsp40ftCostAmt;
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
	 * @return trsp40ftCostAmt
	 */
	public String getTrsp40ftCostAmt() {
		return this.trsp40ftCostAmt;
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
	 * @return tml20ftCostSysSrcCd
	 */
	public String getTml20ftCostSysSrcCd() {
		return this.tml20ftCostSysSrcCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return mb20ftRto
	 */
	public String getMb20ftRto() {
		return this.mb20ftRto;
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
	 * @return wtrRcvTermCd
	 */
	public String getWtrRcvTermCd() {
		return this.wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp20ftCostSysSrcCd
	 */
	public String getMtyTrsp20ftCostSysSrcCd() {
		return this.mtyTrsp20ftCostSysSrcCd;
	}
	
	/**
	 * Column Info
	 * @return trsp20ftCostSysSrcCd
	 */
	public String getTrsp20ftCostSysSrcCd() {
		return this.trsp20ftCostSysSrcCd;
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
	 * @return wtrDeTermCd
	 */
	public String getWtrDeTermCd() {
		return this.wtrDeTermCd;
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
	 * @return pctlIoBndNm
	 */
	public String getPctlIoBndNm() {
		return this.pctlIoBndNm;
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
	 * @return trsp40ftCostSysSrcCd
	 */
	public String getTrsp40ftCostSysSrcCd() {
		return this.trsp40ftCostSysSrcCd;
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
	 * @return agmtOldFlg
	 */
	public String getAgmtOldFlg() {
		return this.agmtOldFlg;
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
	 * @param tml40ftCostSysSrcCd
	 */
	public void setTml40ftCostSysSrcCd(String tml40ftCostSysSrcCd) {
		this.tml40ftCostSysSrcCd = tml40ftCostSysSrcCd;
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
	 * @param mtyTrsp40ftCostSysSrcCd
	 */
	public void setMtyTrsp40ftCostSysSrcCd(String mtyTrsp40ftCostSysSrcCd) {
		this.mtyTrsp40ftCostSysSrcCd = mtyTrsp40ftCostSysSrcCd;
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
	 * @param trsp40ftTtlCostAmt
	 */
	public void setTrsp40ftTtlCostAmt(String trsp40ftTtlCostAmt) {
		this.trsp40ftTtlCostAmt = trsp40ftTtlCostAmt;
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
	 * @param mtyTrsp40ftCostAmt
	 */
	public void setMtyTrsp40ftCostAmt(String mtyTrsp40ftCostAmt) {
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
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
	 * @param trsp40ftCostAmt
	 */
	public void setTrsp40ftCostAmt(String trsp40ftCostAmt) {
		this.trsp40ftCostAmt = trsp40ftCostAmt;
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
	 * @param tml20ftCostSysSrcCd
	 */
	public void setTml20ftCostSysSrcCd(String tml20ftCostSysSrcCd) {
		this.tml20ftCostSysSrcCd = tml20ftCostSysSrcCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param mb20ftRto
	 */
	public void setMb20ftRto(String mb20ftRto) {
		this.mb20ftRto = mb20ftRto;
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
	 * @param wtrRcvTermCd
	 */
	public void setWtrRcvTermCd(String wtrRcvTermCd) {
		this.wtrRcvTermCd = wtrRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp20ftCostSysSrcCd
	 */
	public void setMtyTrsp20ftCostSysSrcCd(String mtyTrsp20ftCostSysSrcCd) {
		this.mtyTrsp20ftCostSysSrcCd = mtyTrsp20ftCostSysSrcCd;
	}
	
	/**
	 * Column Info
	 * @param trsp20ftCostSysSrcCd
	 */
	public void setTrsp20ftCostSysSrcCd(String trsp20ftCostSysSrcCd) {
		this.trsp20ftCostSysSrcCd = trsp20ftCostSysSrcCd;
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
	 * @param wtrDeTermCd
	 */
	public void setWtrDeTermCd(String wtrDeTermCd) {
		this.wtrDeTermCd = wtrDeTermCd;
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
	 * @param pctlIoBndNm
	 */
	public void setPctlIoBndNm(String pctlIoBndNm) {
		this.pctlIoBndNm = pctlIoBndNm;
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
	 * @param trsp40ftCostSysSrcCd
	 */
	public void setTrsp40ftCostSysSrcCd(String trsp40ftCostSysSrcCd) {
		this.trsp40ftCostSysSrcCd = trsp40ftCostSysSrcCd;
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
	 * @param agmtOldFlg
	 */
	public void setAgmtOldFlg(String agmtOldFlg) {
		this.agmtOldFlg = agmtOldFlg;
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
		setTml40ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_sys_src_cd", ""));
		setTrsp40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_sys_src_nm", ""));
		setMtyTrsp20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_sys_src_nm", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setMtyTrsp40ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_sys_src_cd", ""));
		setFdr20ftTtlAmt(JSPUtil.getParameter(request, prefix + "fdr_20ft_ttl_amt", ""));
		setMtyTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_ttl_cost_amt", ""));
		setTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_ttl_cost_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setTrsp20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_sys_src_nm", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_adj_cost_amt", ""));
		setTml20ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_sys_src_cd", ""));
		setMtyTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_adj_cost_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setMtyTrsp40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_sys_src_nm", ""));
		setTml40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_ttl_cost_amt", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setMtyTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_adj_cost_amt", ""));
		setTml20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_adj_cost_amt", ""));
		setTml20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_sys_src_nm", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWtrRcvTermCd(JSPUtil.getParameter(request, prefix + "wtr_rcv_term_cd", ""));
		setMtyTrsp20ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_sys_src_cd", ""));
		setTrsp20ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_sys_src_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setWtrDeTermCd(JSPUtil.getParameter(request, prefix + "wtr_de_term_cd", ""));
		setFdr40ftTtlAmt(JSPUtil.getParameter(request, prefix + "fdr_40ft_ttl_amt", ""));
		setTml40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_adj_cost_amt", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setPctlIoBndNm(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_nm", ""));
		setMtyTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_ttl_cost_amt", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setTml40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_sys_src_nm", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_ttl_cost_amt", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setTrsp40ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_sys_src_cd", ""));
		setTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_adj_cost_amt", ""));
		setTml20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_ttl_cost_amt", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFeederReeferCostVO[]
	 */
	public SearchFeederReeferCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFeederReeferCostVO[]
	 */
	public SearchFeederReeferCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFeederReeferCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] tml40ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_sys_src_cd", length));
			String[] trsp40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_sys_src_nm", length));
			String[] mtyTrsp20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_sys_src_nm", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] mtyTrsp40ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_sys_src_cd", length));
			String[] fdr20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fdr_20ft_ttl_amt", length));
			String[] mtyTrsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_ttl_cost_amt", length));
			String[] trsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_ttl_cost_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] trsp20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_sys_src_nm", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] trsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_adj_cost_amt", length));
			String[] tml20ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_sys_src_cd", length));
			String[] mtyTrsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_adj_cost_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] mtyTrsp40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_sys_src_nm", length));
			String[] tml40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_ttl_cost_amt", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] mtyTrsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_adj_cost_amt", length));
			String[] tml20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_adj_cost_amt", length));
			String[] tml20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_sys_src_nm", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wtrRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_rcv_term_cd", length));
			String[] mtyTrsp20ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_sys_src_cd", length));
			String[] trsp20ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_sys_src_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] wtrDeTermCd = (JSPUtil.getParameter(request, prefix	+ "wtr_de_term_cd", length));
			String[] fdr40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "fdr_40ft_ttl_amt", length));
			String[] tml40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_adj_cost_amt", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] pctlIoBndNm = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_nm", length));
			String[] mtyTrsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_ttl_cost_amt", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] tml40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_sys_src_nm", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] trsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_ttl_cost_amt", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] trsp40ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_sys_src_cd", length));
			String[] trsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_adj_cost_amt", length));
			String[] tml20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_ttl_cost_amt", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFeederReeferCostVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (tml40ftCostSysSrcCd[i] != null)
					model.setTml40ftCostSysSrcCd(tml40ftCostSysSrcCd[i]);
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
				if (mtyTrsp40ftCostSysSrcCd[i] != null)
					model.setMtyTrsp40ftCostSysSrcCd(mtyTrsp40ftCostSysSrcCd[i]);
				if (fdr20ftTtlAmt[i] != null)
					model.setFdr20ftTtlAmt(fdr20ftTtlAmt[i]);
				if (mtyTrsp20ftTtlCostAmt[i] != null)
					model.setMtyTrsp20ftTtlCostAmt(mtyTrsp20ftTtlCostAmt[i]);
				if (trsp40ftTtlCostAmt[i] != null)
					model.setTrsp40ftTtlCostAmt(trsp40ftTtlCostAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (trsp20ftCostSysSrcNm[i] != null)
					model.setTrsp20ftCostSysSrcNm(trsp20ftCostSysSrcNm[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (trsp20ftAdjCostAmt[i] != null)
					model.setTrsp20ftAdjCostAmt(trsp20ftAdjCostAmt[i]);
				if (tml20ftCostSysSrcCd[i] != null)
					model.setTml20ftCostSysSrcCd(tml20ftCostSysSrcCd[i]);
				if (mtyTrsp40ftAdjCostAmt[i] != null)
					model.setMtyTrsp40ftAdjCostAmt(mtyTrsp40ftAdjCostAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
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
				if (tml20ftCostSysSrcNm[i] != null)
					model.setTml20ftCostSysSrcNm(tml20ftCostSysSrcNm[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wtrRcvTermCd[i] != null)
					model.setWtrRcvTermCd(wtrRcvTermCd[i]);
				if (mtyTrsp20ftCostSysSrcCd[i] != null)
					model.setMtyTrsp20ftCostSysSrcCd(mtyTrsp20ftCostSysSrcCd[i]);
				if (trsp20ftCostSysSrcCd[i] != null)
					model.setTrsp20ftCostSysSrcCd(trsp20ftCostSysSrcCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (wtrDeTermCd[i] != null)
					model.setWtrDeTermCd(wtrDeTermCd[i]);
				if (fdr40ftTtlAmt[i] != null)
					model.setFdr40ftTtlAmt(fdr40ftTtlAmt[i]);
				if (tml40ftAdjCostAmt[i] != null)
					model.setTml40ftAdjCostAmt(tml40ftAdjCostAmt[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (pctlIoBndNm[i] != null)
					model.setPctlIoBndNm(pctlIoBndNm[i]);
				if (mtyTrsp40ftTtlCostAmt[i] != null)
					model.setMtyTrsp40ftTtlCostAmt(mtyTrsp40ftTtlCostAmt[i]);
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
				if (trsp40ftCostSysSrcCd[i] != null)
					model.setTrsp40ftCostSysSrcCd(trsp40ftCostSysSrcCd[i]);
				if (trsp40ftAdjCostAmt[i] != null)
					model.setTrsp40ftAdjCostAmt(trsp40ftAdjCostAmt[i]);
				if (tml20ftTtlCostAmt[i] != null)
					model.setTml20ftTtlCostAmt(tml20ftTtlCostAmt[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFeederReeferCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFeederReeferCostVO[]
	 */
	public SearchFeederReeferCostVO[] getSearchFeederReeferCostVOs(){
		SearchFeederReeferCostVO[] vos = (SearchFeederReeferCostVO[])models.toArray(new SearchFeederReeferCostVO[models.size()]);
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
		this.tml40ftCostSysSrcCd = this.tml40ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostSysSrcNm = this.trsp40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostSysSrcNm = this.mtyTrsp20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostSysSrcCd = this.mtyTrsp40ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr20ftTtlAmt = this.fdr20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftTtlCostAmt = this.mtyTrsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftTtlCostAmt = this.trsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostSysSrcNm = this.trsp20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftAdjCostAmt = this.trsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSysSrcCd = this.tml20ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftAdjCostAmt = this.mtyTrsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostSysSrcNm = this.mtyTrsp40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftTtlCostAmt = this.tml40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftAdjCostAmt = this.mtyTrsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftAdjCostAmt = this.tml20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSysSrcNm = this.tml20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrRcvTermCd = this.wtrRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostSysSrcCd = this.mtyTrsp20ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostSysSrcCd = this.trsp20ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtrDeTermCd = this.wtrDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdr40ftTtlAmt = this.fdr40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftAdjCostAmt = this.tml40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndNm = this.pctlIoBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftTtlCostAmt = this.mtyTrsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostSysSrcNm = this.tml40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftTtlCostAmt = this.trsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostSysSrcCd = this.trsp40ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftAdjCostAmt = this.trsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftTtlCostAmt = this.tml20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
