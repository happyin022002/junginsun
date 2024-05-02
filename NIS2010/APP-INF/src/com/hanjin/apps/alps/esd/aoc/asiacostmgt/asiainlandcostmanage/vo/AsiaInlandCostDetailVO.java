/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostDetailVO.java
*@FileTitle : AsiaInlandCostDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AsiaInlandCostDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AsiaInlandCostDetailVO> models = new ArrayList<AsiaInlandCostDetailVO>();
	
	/* Column Info */
	private String rcvDeTermNm = null;
	/* Column Info */
	private String trspRateType40ft = null;
	/* Column Info */
	private String costRoutGrpNo = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String trspAgmt40ftMtyYdCd = null;
	/* Column Info */
	private String trsp40ftCostSysSrcNm = null;
	/* Column Info */
	private String mtyTrsp20ftCostAmt = null;
	/* Column Info */
	private String costTrfRoutSeq = null;
	/* Column Info */
	private String tml20ftCostSysSrcNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* Column Info */
	private String costRoutGrpNoRnk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n1stVndrSeq = null;
	/* Column Info */
	private String n1stVndrNm = null;
	/* Column Info */
	private String mtyPkupRtnYdCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String inlndRoutCmbFlg = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String costSelRoutFlg = null;
	/* Column Info */
	private String trspDiff40ft = null;
	/* Column Info */
	private String n2ndVndrSeq = null;
	/* Column Info */
	private String inlnd20ftTtlAmt = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String trsp20ftCostSysSrcNm = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String inlnd40ftTtlAmt = null;
	/* Column Info */
	private String trspAgmt20ftMtyYdCd = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String tml40ftCostSysSrcNm = null;
	/* Column Info */
	private String trspDiff20ft = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String portLoc = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String portNodCd = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String locNodCd = null;
	/* Column Info */
	private String agmtOldFlg = null;
	/* Column Info */
	private String n2ndVndrNm = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String trspRateType20ft = null;
	/* Column Info */
	private String agmtwgt20ft = null;
	/* Column Info */
	private String agmtwgt40ft = null;
	/* Column Info */
	private String rfCnt = null;
	/* Column Info */
	private String currCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AsiaInlandCostDetailVO() {}

	public AsiaInlandCostDetailVO(String ibflag, String pagerows, String rowNum, String portLoc, String rcvDeTermNm, String costSelRoutFlg, String portNodCd, String hubNodCd, String locNodCd, String mtyPkupRtnYdCd, String trspCrrModCd, String inlnd20ftTtlAmt, String inlnd40ftTtlAmt, String sccCd, String mb20ftRto, String mb40ftRto, String trsp20ftCostSysSrcNm, String trsp20ftCostAmt, String trspAgmt20ftMtyYdCd, String trspDiff20ft, String trspRateType20ft, String trsp40ftCostSysSrcNm, String trsp40ftCostAmt, String trspAgmt40ftMtyYdCd, String trspDiff40ft, String trspRateType40ft, String mtyTrsp20ftCostAmt, String mtyTrsp40ftCostAmt, String tml20ftCostSysSrcNm, String tml20ftCostAmt, String tml40ftCostSysSrcNm, String tml40ftCostAmt, String n1stVndrSeq, String n1stVndrNm, String inlndRoutCmbFlg, String n2ndVndrSeq, String n2ndVndrNm, String agmtOldFlg, String costTrfNo, String costTrfRoutSeq, String costRoutGrpNo, String costRoutGrpNoRnk, String rcvDeTermCd, String updUsrId, String agmtwgt20ft, String agmtwgt40ft, String rfCnt, String currCd) {
		this.rcvDeTermNm = rcvDeTermNm;
		this.trspRateType40ft = trspRateType40ft;
		this.costRoutGrpNo = costRoutGrpNo;
		this.mb20ftRto = mb20ftRto;
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
		this.trsp40ftCostSysSrcNm = trsp40ftCostSysSrcNm;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.tml20ftCostSysSrcNm = tml20ftCostSysSrcNm;
		this.pagerows = pagerows;
		this.mb40ftRto = mb40ftRto;
		this.costRoutGrpNoRnk = costRoutGrpNoRnk;
		this.ibflag = ibflag;
		this.n1stVndrSeq = n1stVndrSeq;
		this.n1stVndrNm = n1stVndrNm;
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
		this.trspCrrModCd = trspCrrModCd;
		this.updUsrId = updUsrId;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.costSelRoutFlg = costSelRoutFlg;
		this.trspDiff40ft = trspDiff40ft;
		this.n2ndVndrSeq = n2ndVndrSeq;
		this.inlnd20ftTtlAmt = inlnd20ftTtlAmt;
		this.costTrfNo = costTrfNo;
		this.trsp20ftCostSysSrcNm = trsp20ftCostSysSrcNm;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
		this.trspAgmt20ftMtyYdCd = trspAgmt20ftMtyYdCd;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.hubNodCd = hubNodCd;
		this.tml40ftCostSysSrcNm = tml40ftCostSysSrcNm;
		this.trspDiff20ft = trspDiff20ft;
		this.sccCd = sccCd;
		this.portLoc = portLoc;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.portNodCd = portNodCd;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.locNodCd = locNodCd;
		this.agmtOldFlg = agmtOldFlg;
		this.n2ndVndrNm = n2ndVndrNm;
		this.rowNum = rowNum;
		this.trspRateType20ft = trspRateType20ft;
		this.agmtwgt20ft = agmtwgt20ft;
		this.agmtwgt40ft = agmtwgt40ft;
		this.rfCnt = rfCnt;
		this.currCd = currCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcv_de_term_nm", getRcvDeTermNm());
		this.hashColumns.put("trsp_rate_type_40ft", getTrspRateType40ft());
		this.hashColumns.put("cost_rout_grp_no", getCostRoutGrpNo());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("trsp_agmt_40ft_mty_yd_cd", getTrspAgmt40ftMtyYdCd());
		this.hashColumns.put("trsp_40ft_cost_sys_src_nm", getTrsp40ftCostSysSrcNm());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("tml_20ft_cost_sys_src_nm", getTml20ftCostSysSrcNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("cost_rout_grp_no_rnk", getCostRoutGrpNoRnk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
		this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
		this.hashColumns.put("mty_pkup_rtn_yd_cd", getMtyPkupRtnYdCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("inlnd_rout_cmb_flg", getInlndRoutCmbFlg());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("cost_sel_rout_flg", getCostSelRoutFlg());
		this.hashColumns.put("trsp_diff_40ft", getTrspDiff40ft());
		this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
		this.hashColumns.put("inlnd_20ft_ttl_amt", getInlnd20ftTtlAmt());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("trsp_20ft_cost_sys_src_nm", getTrsp20ftCostSysSrcNm());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("inlnd_40ft_ttl_amt", getInlnd40ftTtlAmt());
		this.hashColumns.put("trsp_agmt_20ft_mty_yd_cd", getTrspAgmt20ftMtyYdCd());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("tml_40ft_cost_sys_src_nm", getTml40ftCostSysSrcNm());
		this.hashColumns.put("trsp_diff_20ft", getTrspDiff20ft());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("port_loc", getPortLoc());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("port_nod_cd", getPortNodCd());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("loc_nod_cd", getLocNodCd());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("trsp_rate_type_20ft", getTrspRateType20ft());
		this.hashColumns.put("agmt_wgt_20ft", getAgmtwgt20ft());
		this.hashColumns.put("agmt_wgt_40ft", getAgmtwgt40ft());
		this.hashColumns.put("rf_cnt", getRfCnt());
		this.hashColumns.put("curr_cd", getCurrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_de_term_nm", "rcvDeTermNm");
		this.hashFields.put("trsp_rate_type_40ft", "trspRateType40ft");
		this.hashFields.put("cost_rout_grp_no", "costRoutGrpNo");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("trsp_agmt_40ft_mty_yd_cd", "trspAgmt40ftMtyYdCd");
		this.hashFields.put("trsp_40ft_cost_sys_src_nm", "trsp40ftCostSysSrcNm");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("tml_20ft_cost_sys_src_nm", "tml20ftCostSysSrcNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("cost_rout_grp_no_rnk", "costRoutGrpNoRnk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
		this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
		this.hashFields.put("mty_pkup_rtn_yd_cd", "mtyPkupRtnYdCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("inlnd_rout_cmb_flg", "inlndRoutCmbFlg");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("cost_sel_rout_flg", "costSelRoutFlg");
		this.hashFields.put("trsp_diff_40ft", "trspDiff40ft");
		this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
		this.hashFields.put("inlnd_20ft_ttl_amt", "inlnd20ftTtlAmt");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("trsp_20ft_cost_sys_src_nm", "trsp20ftCostSysSrcNm");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("inlnd_40ft_ttl_amt", "inlnd40ftTtlAmt");
		this.hashFields.put("trsp_agmt_20ft_mty_yd_cd", "trspAgmt20ftMtyYdCd");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("tml_40ft_cost_sys_src_nm", "tml40ftCostSysSrcNm");
		this.hashFields.put("trsp_diff_20ft", "trspDiff20ft");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("port_loc", "portLoc");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("port_nod_cd", "portNodCd");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("loc_nod_cd", "locNodCd");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
		this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("trsp_rate_type_20ft", "trspRateType20ft");
		this.hashFields.put("agmt_wgt_20ft", "agmtwgt20ft");
		this.hashFields.put("agmt_wgt_40ft", "agmtwgt40ft");
		this.hashFields.put("rf_cnt", "rfCnt");
		this.hashFields.put("curr_cd","currCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermNm
	 */
	public String getRcvDeTermNm() {
		return this.rcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @return trspRateType40ft
	 */
	public String getTrspRateType40ft() {
		return this.trspRateType40ft;
	}
	
	/**
	 * Column Info
	 * @return costRoutGrpNo
	 */
	public String getCostRoutGrpNo() {
		return this.costRoutGrpNo;
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
	 * @return trspAgmt40ftMtyYdCd
	 */
	public String getTrspAgmt40ftMtyYdCd() {
		return this.trspAgmt40ftMtyYdCd;
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
	 * @return mtyTrsp20ftCostAmt
	 */
	public String getMtyTrsp20ftCostAmt() {
		return this.mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return costTrfRoutSeq
	 */
	public String getCostTrfRoutSeq() {
		return this.costTrfRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return tml20ftCostSysSrcNm
	 */
	public String getTml20ftCostSysSrcNm() {
		return this.tml20ftCostSysSrcNm;
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
	 * @return mb40ftRto
	 */
	public String getMb40ftRto() {
		return this.mb40ftRto;
	}
	
	/**
	 * Column Info
	 * @return costRoutGrpNoRnk
	 */
	public String getCostRoutGrpNoRnk() {
		return this.costRoutGrpNoRnk;
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
	 * @return n1stVndrSeq
	 */
	public String getN1stVndrSeq() {
		return this.n1stVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return n1stVndrNm
	 */
	public String getN1stVndrNm() {
		return this.n1stVndrNm;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupRtnYdCd
	 */
	public String getMtyPkupRtnYdCd() {
		return this.mtyPkupRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRoutCmbFlg
	 */
	public String getInlndRoutCmbFlg() {
		return this.inlndRoutCmbFlg;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
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
	 * @return costSelRoutFlg
	 */
	public String getCostSelRoutFlg() {
		return this.costSelRoutFlg;
	}
	
	/**
	 * Column Info
	 * @return trspDiff40ft
	 */
	public String getTrspDiff40ft() {
		return this.trspDiff40ft;
	}
	
	/**
	 * Column Info
	 * @return n2ndVndrSeq
	 */
	public String getN2ndVndrSeq() {
		return this.n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return inlnd20ftTtlAmt
	 */
	public String getInlnd20ftTtlAmt() {
		return this.inlnd20ftTtlAmt;
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
	 * @return trsp20ftCostSysSrcNm
	 */
	public String getTrsp20ftCostSysSrcNm() {
		return this.trsp20ftCostSysSrcNm;
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
	 * @return inlnd40ftTtlAmt
	 */
	public String getInlnd40ftTtlAmt() {
		return this.inlnd40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return trspAgmt20ftMtyYdCd
	 */
	public String getTrspAgmt20ftMtyYdCd() {
		return this.trspAgmt20ftMtyYdCd;
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
	 * @return hubNodCd
	 */
	public String getHubNodCd() {
		return this.hubNodCd;
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
	 * @return trspDiff20ft
	 */
	public String getTrspDiff20ft() {
		return this.trspDiff20ft;
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
	 * @return portLoc
	 */
	public String getPortLoc() {
		return this.portLoc;
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
	 * @return portNodCd
	 */
	public String getPortNodCd() {
		return this.portNodCd;
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
	 * @return locNodCd
	 */
	public String getLocNodCd() {
		return this.locNodCd;
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
	 * @return n2ndVndrNm
	 */
	public String getN2ndVndrNm() {
		return this.n2ndVndrNm;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return this.rowNum;
	}
	
	/**
	 * Column Info
	 * @return trspRateType20ft
	 */
	public String getTrspRateType20ft() {
		return this.trspRateType20ft;
	}
	
	/**
	 * Column Info
	 * @return agmtwgt20ft
	 */
	public String getAgmtwgt20ft() {
		return this.agmtwgt20ft;
	}
	
	/**
	 * Column Info
	 * @return agmtwgt40ft
	 */
	public String getAgmtwgt40ft() {
		return this.agmtwgt40ft;
	}
	
	/**
	 * Column Info
	 * @return rfCnt
	 */
	public String getRfCnt() {
		return this.rfCnt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd(){
		return this.currCd;
	}
	

	/**
	 * Column Info
	 * @param rcvDeTermNm
	 */
	public void setRcvDeTermNm(String rcvDeTermNm) {
		this.rcvDeTermNm = rcvDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param trspRateType40ft
	 */
	public void setTrspRateType40ft(String trspRateType40ft) {
		this.trspRateType40ft = trspRateType40ft;
	}
	
	/**
	 * Column Info
	 * @param costRoutGrpNo
	 */
	public void setCostRoutGrpNo(String costRoutGrpNo) {
		this.costRoutGrpNo = costRoutGrpNo;
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
	 * @param trspAgmt40ftMtyYdCd
	 */
	public void setTrspAgmt40ftMtyYdCd(String trspAgmt40ftMtyYdCd) {
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
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
	 * @param mtyTrsp20ftCostAmt
	 */
	public void setMtyTrsp20ftCostAmt(String mtyTrsp20ftCostAmt) {
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param costTrfRoutSeq
	 */
	public void setCostTrfRoutSeq(String costTrfRoutSeq) {
		this.costTrfRoutSeq = costTrfRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param tml20ftCostSysSrcNm
	 */
	public void setTml20ftCostSysSrcNm(String tml20ftCostSysSrcNm) {
		this.tml20ftCostSysSrcNm = tml20ftCostSysSrcNm;
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
	 * @param mb40ftRto
	 */
	public void setMb40ftRto(String mb40ftRto) {
		this.mb40ftRto = mb40ftRto;
	}
	
	/**
	 * Column Info
	 * @param costRoutGrpNoRnk
	 */
	public void setCostRoutGrpNoRnk(String costRoutGrpNoRnk) {
		this.costRoutGrpNoRnk = costRoutGrpNoRnk;
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
	 * @param n1stVndrSeq
	 */
	public void setN1stVndrSeq(String n1stVndrSeq) {
		this.n1stVndrSeq = n1stVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param n1stVndrNm
	 */
	public void setN1stVndrNm(String n1stVndrNm) {
		this.n1stVndrNm = n1stVndrNm;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupRtnYdCd
	 */
	public void setMtyPkupRtnYdCd(String mtyPkupRtnYdCd) {
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRoutCmbFlg
	 */
	public void setInlndRoutCmbFlg(String inlndRoutCmbFlg) {
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
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
	 * @param costSelRoutFlg
	 */
	public void setCostSelRoutFlg(String costSelRoutFlg) {
		this.costSelRoutFlg = costSelRoutFlg;
	}
	
	/**
	 * Column Info
	 * @param trspDiff40ft
	 */
	public void setTrspDiff40ft(String trspDiff40ft) {
		this.trspDiff40ft = trspDiff40ft;
	}
	
	/**
	 * Column Info
	 * @param n2ndVndrSeq
	 */
	public void setN2ndVndrSeq(String n2ndVndrSeq) {
		this.n2ndVndrSeq = n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param inlnd20ftTtlAmt
	 */
	public void setInlnd20ftTtlAmt(String inlnd20ftTtlAmt) {
		this.inlnd20ftTtlAmt = inlnd20ftTtlAmt;
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
	 * @param trsp20ftCostSysSrcNm
	 */
	public void setTrsp20ftCostSysSrcNm(String trsp20ftCostSysSrcNm) {
		this.trsp20ftCostSysSrcNm = trsp20ftCostSysSrcNm;
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
	 * @param inlnd40ftTtlAmt
	 */
	public void setInlnd40ftTtlAmt(String inlnd40ftTtlAmt) {
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param trspAgmt20ftMtyYdCd
	 */
	public void setTrspAgmt20ftMtyYdCd(String trspAgmt20ftMtyYdCd) {
		this.trspAgmt20ftMtyYdCd = trspAgmt20ftMtyYdCd;
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
	 * @param hubNodCd
	 */
	public void setHubNodCd(String hubNodCd) {
		this.hubNodCd = hubNodCd;
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
	 * @param trspDiff20ft
	 */
	public void setTrspDiff20ft(String trspDiff20ft) {
		this.trspDiff20ft = trspDiff20ft;
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
	 * @param portLoc
	 */
	public void setPortLoc(String portLoc) {
		this.portLoc = portLoc;
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
	 * @param portNodCd
	 */
	public void setPortNodCd(String portNodCd) {
		this.portNodCd = portNodCd;
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
	 * @param locNodCd
	 */
	public void setLocNodCd(String locNodCd) {
		this.locNodCd = locNodCd;
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
	 * @param n2ndVndrNm
	 */
	public void setN2ndVndrNm(String n2ndVndrNm) {
		this.n2ndVndrNm = n2ndVndrNm;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}
	
	/**
	 * Column Info
	 * @param trspRateType20ft
	 */
	public void setTrspRateType20ft(String trspRateType20ft) {
		this.trspRateType20ft = trspRateType20ft;
	}
	
	/**
	 * Column Info
	 * @param agmtwgt20ft
	 */
	public void setAgmtwgt20ft(String agmtwgt20ft) {
		this.agmtwgt20ft = agmtwgt20ft;
	}
	
	/**
	 * Column Info
	 * @param agmtwgt40ft
	 */
	public void setAgmtwgt40ft(String agmtwgt40ft) {
		this.agmtwgt40ft = agmtwgt40ft;
	}
	
	/**
	 * Column Info
	 * @param rfCnt
	 */
	public void setRfCnt(String rfCnt) {
		this.rfCnt = rfCnt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
		setRcvDeTermNm(JSPUtil.getParameter(request, prefix + "rcv_de_term_nm", ""));
		setTrspRateType40ft(JSPUtil.getParameter(request, prefix + "trsp_rate_type_40ft", ""));
		setCostRoutGrpNo(JSPUtil.getParameter(request, prefix + "cost_rout_grp_no", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setTrspAgmt40ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_40ft_mty_yd_cd", ""));
		setTrsp40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_sys_src_nm", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setTml20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_sys_src_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setCostRoutGrpNoRnk(JSPUtil.getParameter(request, prefix + "cost_rout_grp_no_rnk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
		setN1stVndrNm(JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", ""));
		setMtyPkupRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setInlndRoutCmbFlg(JSPUtil.getParameter(request, prefix + "inlnd_rout_cmb_flg", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setCostSelRoutFlg(JSPUtil.getParameter(request, prefix + "cost_sel_rout_flg", ""));
		setTrspDiff40ft(JSPUtil.getParameter(request, prefix + "trsp_diff_40ft", ""));
		setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
		setInlnd20ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_20ft_ttl_amt", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setTrsp20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_sys_src_nm", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setInlnd40ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_40ft_ttl_amt", ""));
		setTrspAgmt20ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_20ft_mty_yd_cd", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setTml40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_sys_src_nm", ""));
		setTrspDiff20ft(JSPUtil.getParameter(request, prefix + "trsp_diff_20ft", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setPortLoc(JSPUtil.getParameter(request, prefix + "port_loc", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setPortNodCd(JSPUtil.getParameter(request, prefix + "port_nod_cd", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setLocNodCd(JSPUtil.getParameter(request, prefix + "loc_nod_cd", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
		setN2ndVndrNm(JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setTrspRateType20ft(JSPUtil.getParameter(request, prefix + "trsp_rate_type_20ft", ""));
		setAgmtwgt20ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_20ft", ""));
		setAgmtwgt40ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_40ft", ""));
		setRfCnt(JSPUtil.getParameter(request, prefix + "rf_cnt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AsiaInlandCostDetailVO[]
	 */
	public AsiaInlandCostDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AsiaInlandCostDetailVO[]
	 */
	public AsiaInlandCostDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AsiaInlandCostDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_nm", length));
			String[] trspRateType40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_rate_type_40ft", length));
			String[] costRoutGrpNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_grp_no", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] trspAgmt40ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_40ft_mty_yd_cd", length));
			String[] trsp40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_sys_src_nm", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] tml20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_sys_src_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] costRoutGrpNoRnk = (JSPUtil.getParameter(request, prefix	+ "cost_rout_grp_no_rnk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_seq", length));
			String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_nm", length));
			String[] mtyPkupRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] inlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_cmb_flg", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] costSelRoutFlg = (JSPUtil.getParameter(request, prefix	+ "cost_sel_rout_flg", length));
			String[] trspDiff40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_40ft", length));
			String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_seq", length));
			String[] inlnd20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_20ft_ttl_amt", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] trsp20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_sys_src_nm", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] inlnd40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_ttl_amt", length));
			String[] trspAgmt20ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_20ft_mty_yd_cd", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] tml40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_sys_src_nm", length));
			String[] trspDiff20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_20ft", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] portLoc = (JSPUtil.getParameter(request, prefix	+ "port_loc", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] portNodCd = (JSPUtil.getParameter(request, prefix	+ "port_nod_cd", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] locNodCd = (JSPUtil.getParameter(request, prefix	+ "loc_nod_cd", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_nm", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] trspRateType20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_rate_type_20ft", length));
			String[] agmtwgt20ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_20ft", length));
			String[] agmtwgt40ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_40ft", length));
			String[] rfCnt = (JSPUtil.getParameter(request, prefix	+ "rf_cnt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AsiaInlandCostDetailVO();
				if (rcvDeTermNm[i] != null)
					model.setRcvDeTermNm(rcvDeTermNm[i]);
				if (trspRateType40ft[i] != null)
					model.setTrspRateType40ft(trspRateType40ft[i]);
				if (costRoutGrpNo[i] != null)
					model.setCostRoutGrpNo(costRoutGrpNo[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (trspAgmt40ftMtyYdCd[i] != null)
					model.setTrspAgmt40ftMtyYdCd(trspAgmt40ftMtyYdCd[i]);
				if (trsp40ftCostSysSrcNm[i] != null)
					model.setTrsp40ftCostSysSrcNm(trsp40ftCostSysSrcNm[i]);
				if (mtyTrsp20ftCostAmt[i] != null)
					model.setMtyTrsp20ftCostAmt(mtyTrsp20ftCostAmt[i]);
				if (costTrfRoutSeq[i] != null)
					model.setCostTrfRoutSeq(costTrfRoutSeq[i]);
				if (tml20ftCostSysSrcNm[i] != null)
					model.setTml20ftCostSysSrcNm(tml20ftCostSysSrcNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (costRoutGrpNoRnk[i] != null)
					model.setCostRoutGrpNoRnk(costRoutGrpNoRnk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n1stVndrSeq[i] != null)
					model.setN1stVndrSeq(n1stVndrSeq[i]);
				if (n1stVndrNm[i] != null)
					model.setN1stVndrNm(n1stVndrNm[i]);
				if (mtyPkupRtnYdCd[i] != null)
					model.setMtyPkupRtnYdCd(mtyPkupRtnYdCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (inlndRoutCmbFlg[i] != null)
					model.setInlndRoutCmbFlg(inlndRoutCmbFlg[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (costSelRoutFlg[i] != null)
					model.setCostSelRoutFlg(costSelRoutFlg[i]);
				if (trspDiff40ft[i] != null)
					model.setTrspDiff40ft(trspDiff40ft[i]);
				if (n2ndVndrSeq[i] != null)
					model.setN2ndVndrSeq(n2ndVndrSeq[i]);
				if (inlnd20ftTtlAmt[i] != null)
					model.setInlnd20ftTtlAmt(inlnd20ftTtlAmt[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (trsp20ftCostSysSrcNm[i] != null)
					model.setTrsp20ftCostSysSrcNm(trsp20ftCostSysSrcNm[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (inlnd40ftTtlAmt[i] != null)
					model.setInlnd40ftTtlAmt(inlnd40ftTtlAmt[i]);
				if (trspAgmt20ftMtyYdCd[i] != null)
					model.setTrspAgmt20ftMtyYdCd(trspAgmt20ftMtyYdCd[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (tml40ftCostSysSrcNm[i] != null)
					model.setTml40ftCostSysSrcNm(tml40ftCostSysSrcNm[i]);
				if (trspDiff20ft[i] != null)
					model.setTrspDiff20ft(trspDiff20ft[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (portLoc[i] != null)
					model.setPortLoc(portLoc[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (portNodCd[i] != null)
					model.setPortNodCd(portNodCd[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (locNodCd[i] != null)
					model.setLocNodCd(locNodCd[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				if (n2ndVndrNm[i] != null)
					model.setN2ndVndrNm(n2ndVndrNm[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (trspRateType20ft[i] != null)
					model.setTrspRateType20ft(trspRateType20ft[i]);
				if (agmtwgt20ft[i] != null)
					model.setAgmtwgt20ft(agmtwgt20ft[i]);
				if (agmtwgt40ft[i] != null)
					model.setAgmtwgt40ft(agmtwgt40ft[i]);
				if (rfCnt[i] != null)
					model.setRfCnt(rfCnt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlandCostDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AsiaInlandCostDetailVO[]
	 */
	public AsiaInlandCostDetailVO[] getInlandCostDetailVOs(){
		AsiaInlandCostDetailVO[] vos = (AsiaInlandCostDetailVO[])models.toArray(new AsiaInlandCostDetailVO[models.size()]);
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
		this.rcvDeTermNm = this.rcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRateType40ft = this.trspRateType40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutGrpNo = this.costRoutGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt40ftMtyYdCd = this.trspAgmt40ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostSysSrcNm = this.trsp40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSysSrcNm = this.tml20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutGrpNoRnk = this.costRoutGrpNoRnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrSeq = this.n1stVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrNm = this.n1stVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdCd = this.mtyPkupRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutCmbFlg = this.inlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSelRoutFlg = this.costSelRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff40ft = this.trspDiff40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrSeq = this.n2ndVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd20ftTtlAmt = this.inlnd20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostSysSrcNm = this.trsp20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftTtlAmt = this.inlnd40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt20ftMtyYdCd = this.trspAgmt20ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostSysSrcNm = this.tml40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff20ft = this.trspDiff20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLoc = this.portLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNodCd = this.portNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNodCd = this.locNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrNm = this.n2ndVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRateType20ft = this.trspRateType20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtwgt20ft = this.agmtwgt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtwgt40ft = this.agmtwgt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCnt = this.rfCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
