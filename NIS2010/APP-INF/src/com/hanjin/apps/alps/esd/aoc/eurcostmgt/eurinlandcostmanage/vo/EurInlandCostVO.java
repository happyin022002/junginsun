/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurInlandCostVO.java
*@FileTitle : EurInlandCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27  
* 1.0 Creation
* 
* History
* 2015.02.03 CHM-201533794 전지예 [AOC] 45' Cost 추가
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.eurcostmgt.eurinlandcostmanage.vo;

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

public class EurInlandCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurInlandCostVO> models = new ArrayList<EurInlandCostVO>();
	
	/* Column Info */
	private String costRoutGrpNo = null;
	/* Column Info */
	private String agmtWgt20ft = null;
	/* Column Info */
	private String tml40ftCostSysSrcCd = null;
	/* Column Info */
	private String costTrfRoutSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trsp45ftCostSysSrcCd = null;
	/* Column Info */
	private String mtyTrsp40ftCostSysSrcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String mtyTrsp20ftTtlCostAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String trsp40ftTtlCostAmt = null;
	/* Column Info */
	private String mtyTrsp45ftAdjCostAmt = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String n2ndVndrSeq = null;
	/* Column Info */
	private String inlnd20ftTtlAmt = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String rf40ftTtlCostAmt = null;
	/* Column Info */
	private String trspAgmt20ftMtyYdCd = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String trsp45ftAdjCostAmt = null;
	/* Column Info */
	private String trspRateType45ft = null;
	/* Column Info */
	private String trsp20ftAdjCostAmt = null;
	/* Column Info */
	private String trspDiff20ft = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String tml20ftCostSysSrcCd = null;
	/* Column Info */
	private String portLoc = null;
	/* Column Info */
	private String mtyTrsp40ftAdjCostAmt = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String inlnd45ftTtlAmt = null;
	/* Column Info */
	private String locNodCd = null;
	/* Column Info */
	private String mtyTrsp45ftTtlCostAmt = null;
	/* Column Info */
	private String mtyTrsp45ftCostAmt = null;
	/* Column Info */
	private String agmtWgt45ft = null;
	/* Column Info */
	private String rcvDeTermNm = null;
	/* Column Info */
	private String trspRateType40ft = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String trspAgmt40ftMtyYdCd = null;
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
	private String mtyTrsp45ftCostSysSrcCd = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsp45ftCostAmt = null;
	/* Column Info */
	private String rf20ftTtlCostAmt = null;
	/* Column Info */
	private String n1stVndrSeq = null;
	/* Column Info */
	private String mb45ftRto = null;
	/* Column Info */
	private String locGrpNo = null;
	/* Column Info */
	private String trsp20ftCostSysSrcCd = null;
	/* Column Info */
	private String mtyTrsp20ftCostSysSrcCd = null;
	/* Column Info */
	private String n1stVndrNm = null;
	/* Column Info */
	private String mtyPkupRtnYdCd = null;
	/* Column Info */
	private String inlndRoutCmbFlg = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String trspDiff40ft = null;
	/* Column Info */
	private String costTrfRfSeq = null;
	/* Column Info */
	private String tml40ftAdjCostAmt = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String inlnd40ftTtlAmt = null;
	/* Column Info */
	private String agmtWgt40ft = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String tml45ftCostAmt = null;
	/* Column Info */
	private String mtyTrsp40ftTtlCostAmt = null;
	/* Column Info */
	private String trspDiff45ft = null;
	/* Column Info */
	private String tml45ftCostSysSrcCd = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String trsp20ftTtlCostAmt = null;
	/* Column Info */
	private String portNodCd = null;
	/* Column Info */
	private String hjlFeeAmt = null;
	/* Column Info */
	private String trsp40ftCostSysSrcCd = null;
	/* Column Info */
	private String tml20ftTtlCostAmt = null;
	/* Column Info */
	private String trsp40ftAdjCostAmt = null;
	/* Column Info */
	private String trsp45ftTtlCostAmt = null;
	/* Column Info */
	private String agmtOldFlg = null;
	/* Column Info */
	private String n2ndVndrNm = null;
	/* Column Info */
	private String trspAgmt45ftMtyYdCd = null;
	/* Column Info */
	private String trspRateType20ft = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EurInlandCostVO() {}

	public EurInlandCostVO(String ibflag, String pagerows, String portLoc, String portNodCd, String hubNodCd, String locNodCd, String mtyPkupRtnYdCd, String rcvDeTermCd, String rcvDeTermNm, String trspCrrModCd, String currCd, String inlnd20ftTtlAmt, String inlnd40ftTtlAmt, String inlnd45ftTtlAmt, String locGrpNo, String sccCd, String mb20ftRto, String mb40ftRto, String mb45ftRto, String trsp20ftCostSysSrcCd, String trsp20ftCostAmt, String trsp20ftAdjCostAmt, String trsp20ftTtlCostAmt, String trspAgmt20ftMtyYdCd, String trspDiff20ft, String agmtWgt20ft, String trspRateType20ft, String trsp40ftCostSysSrcCd, String trsp40ftCostAmt, String trsp40ftAdjCostAmt, String trsp40ftTtlCostAmt, String trspAgmt40ftMtyYdCd, String trspDiff40ft, String agmtWgt40ft, String trspRateType40ft, String trsp45ftCostSysSrcCd, String trsp45ftCostAmt, String trsp45ftAdjCostAmt, String trsp45ftTtlCostAmt, String trspAgmt45ftMtyYdCd, String trspDiff45ft, String agmtWgt45ft, String trspRateType45ft, String mtyTrsp20ftCostSysSrcCd, String mtyTrsp20ftCostAmt, String mtyTrsp20ftAdjCostAmt, String mtyTrsp20ftTtlCostAmt, String mtyTrsp40ftCostSysSrcCd, String mtyTrsp40ftCostAmt, String mtyTrsp40ftAdjCostAmt, String mtyTrsp40ftTtlCostAmt, String mtyTrsp45ftCostSysSrcCd, String mtyTrsp45ftCostAmt, String mtyTrsp45ftAdjCostAmt, String mtyTrsp45ftTtlCostAmt, String tml20ftCostSysSrcCd, String tml20ftCostAmt, String tml20ftAdjCostAmt, String tml20ftTtlCostAmt, String tml40ftCostSysSrcCd, String tml40ftCostAmt, String tml40ftAdjCostAmt, String tml40ftTtlCostAmt, String tml45ftCostSysSrcCd, String tml45ftCostAmt, String tml45ftAdjCostAmt, String tml45ftTtlCostAmt, String hjlFeeAmt, String n1stVndrSeq, String n1stVndrNm, String inlndRoutCmbFlg, String n2ndVndrSeq, String n2ndVndrNm, String agmtOldFlg, String costTrfRoutSeq, String costRoutGrpNo, String cntCd, String costTrfNo, String updUsrId, String chk, String costTrfRfSeq, String rf20ftTtlCostAmt, String rf40ftTtlCostAmt) {
		this.costRoutGrpNo = costRoutGrpNo;
		this.agmtWgt20ft = agmtWgt20ft;
		this.tml40ftCostSysSrcCd = tml40ftCostSysSrcCd;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.pagerows = pagerows;
		this.trsp45ftCostSysSrcCd = trsp45ftCostSysSrcCd;
		this.mtyTrsp40ftCostSysSrcCd = mtyTrsp40ftCostSysSrcCd;
		this.cntCd = cntCd;
		this.mtyTrsp20ftTtlCostAmt = mtyTrsp20ftTtlCostAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.updUsrId = updUsrId;
		this.trsp40ftTtlCostAmt = trsp40ftTtlCostAmt;
		this.mtyTrsp45ftAdjCostAmt = mtyTrsp45ftAdjCostAmt;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.n2ndVndrSeq = n2ndVndrSeq;
		this.inlnd20ftTtlAmt = inlnd20ftTtlAmt;
		this.costTrfNo = costTrfNo;
		this.rf40ftTtlCostAmt = rf40ftTtlCostAmt;
		this.trspAgmt20ftMtyYdCd = trspAgmt20ftMtyYdCd;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.trsp45ftAdjCostAmt = trsp45ftAdjCostAmt;
		this.trspRateType45ft = trspRateType45ft;
		this.trsp20ftAdjCostAmt = trsp20ftAdjCostAmt;
		this.trspDiff20ft = trspDiff20ft;
		this.chk = chk;
		this.tml20ftCostSysSrcCd = tml20ftCostSysSrcCd;
		this.portLoc = portLoc;
		this.mtyTrsp40ftAdjCostAmt = mtyTrsp40ftAdjCostAmt;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.inlnd45ftTtlAmt = inlnd45ftTtlAmt;
		this.locNodCd = locNodCd;
		this.mtyTrsp45ftTtlCostAmt = mtyTrsp45ftTtlCostAmt;
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
		this.agmtWgt45ft = agmtWgt45ft;
		this.rcvDeTermNm = rcvDeTermNm;
		this.trspRateType40ft = trspRateType40ft;
		this.mb20ftRto = mb20ftRto;
		this.currCd = currCd;
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
		this.tml40ftTtlCostAmt = tml40ftTtlCostAmt;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.mtyTrsp20ftAdjCostAmt = mtyTrsp20ftAdjCostAmt;
		this.tml20ftAdjCostAmt = tml20ftAdjCostAmt;
		this.tml45ftTtlCostAmt = tml45ftTtlCostAmt;
		this.tml45ftAdjCostAmt = tml45ftAdjCostAmt;
		this.mtyTrsp45ftCostSysSrcCd = mtyTrsp45ftCostSysSrcCd;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.trsp45ftCostAmt = trsp45ftCostAmt;
		this.rf20ftTtlCostAmt = rf20ftTtlCostAmt;
		this.n1stVndrSeq = n1stVndrSeq;
		this.mb45ftRto = mb45ftRto;
		this.locGrpNo = locGrpNo;
		this.trsp20ftCostSysSrcCd = trsp20ftCostSysSrcCd;
		this.mtyTrsp20ftCostSysSrcCd = mtyTrsp20ftCostSysSrcCd;
		this.n1stVndrNm = n1stVndrNm;
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
		this.trspCrrModCd = trspCrrModCd;
		this.trspDiff40ft = trspDiff40ft;
		this.costTrfRfSeq = costTrfRfSeq;
		this.tml40ftAdjCostAmt = tml40ftAdjCostAmt;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
		this.agmtWgt40ft = agmtWgt40ft;
		this.hubNodCd = hubNodCd;
		this.tml45ftCostAmt = tml45ftCostAmt;
		this.mtyTrsp40ftTtlCostAmt = mtyTrsp40ftTtlCostAmt;
		this.trspDiff45ft = trspDiff45ft;
		this.tml45ftCostSysSrcCd = tml45ftCostSysSrcCd;
		this.sccCd = sccCd;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.trsp20ftTtlCostAmt = trsp20ftTtlCostAmt;
		this.portNodCd = portNodCd;
		this.hjlFeeAmt = hjlFeeAmt;
		this.trsp40ftCostSysSrcCd = trsp40ftCostSysSrcCd;
		this.tml20ftTtlCostAmt = tml20ftTtlCostAmt;
		this.trsp40ftAdjCostAmt = trsp40ftAdjCostAmt;
		this.trsp45ftTtlCostAmt = trsp45ftTtlCostAmt;
		this.agmtOldFlg = agmtOldFlg;
		this.n2ndVndrNm = n2ndVndrNm;
		this.trspAgmt45ftMtyYdCd = trspAgmt45ftMtyYdCd;
		this.trspRateType20ft = trspRateType20ft;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_rout_grp_no", getCostRoutGrpNo());
		this.hashColumns.put("agmt_wgt_20ft", getAgmtWgt20ft());
		this.hashColumns.put("tml_40ft_cost_sys_src_cd", getTml40ftCostSysSrcCd());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_45ft_cost_sys_src_cd", getTrsp45ftCostSysSrcCd());
		this.hashColumns.put("mty_trsp_40ft_cost_sys_src_cd", getMtyTrsp40ftCostSysSrcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("mty_trsp_20ft_ttl_cost_amt", getMtyTrsp20ftTtlCostAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("trsp_40ft_ttl_cost_amt", getTrsp40ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_45ft_adj_cost_amt", getMtyTrsp45ftAdjCostAmt());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
		this.hashColumns.put("inlnd_20ft_ttl_amt", getInlnd20ftTtlAmt());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("rf_40ft_ttl_cost_amt", getRf40ftTtlCostAmt());
		this.hashColumns.put("trsp_agmt_20ft_mty_yd_cd", getTrspAgmt20ftMtyYdCd());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("trsp_45ft_adj_cost_amt", getTrsp45ftAdjCostAmt());
		this.hashColumns.put("trsp_rate_type_45ft", getTrspRateType45ft());
		this.hashColumns.put("trsp_20ft_adj_cost_amt", getTrsp20ftAdjCostAmt());
		this.hashColumns.put("trsp_diff_20ft", getTrspDiff20ft());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("tml_20ft_cost_sys_src_cd", getTml20ftCostSysSrcCd());
		this.hashColumns.put("port_loc", getPortLoc());
		this.hashColumns.put("mty_trsp_40ft_adj_cost_amt", getMtyTrsp40ftAdjCostAmt());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("inlnd_45ft_ttl_amt", getInlnd45ftTtlAmt());
		this.hashColumns.put("loc_nod_cd", getLocNodCd());
		this.hashColumns.put("mty_trsp_45ft_ttl_cost_amt", getMtyTrsp45ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_45ft_cost_amt", getMtyTrsp45ftCostAmt());
		this.hashColumns.put("agmt_wgt_45ft", getAgmtWgt45ft());
		this.hashColumns.put("rcv_de_term_nm", getRcvDeTermNm());
		this.hashColumns.put("trsp_rate_type_40ft", getTrspRateType40ft());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("trsp_agmt_40ft_mty_yd_cd", getTrspAgmt40ftMtyYdCd());
		this.hashColumns.put("tml_40ft_ttl_cost_amt", getTml40ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("mty_trsp_20ft_adj_cost_amt", getMtyTrsp20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_adj_cost_amt", getTml20ftAdjCostAmt());
		this.hashColumns.put("tml_45ft_ttl_cost_amt", getTml45ftTtlCostAmt());
		this.hashColumns.put("tml_45ft_adj_cost_amt", getTml45ftAdjCostAmt());
		this.hashColumns.put("mty_trsp_45ft_cost_sys_src_cd", getMtyTrsp45ftCostSysSrcCd());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_45ft_cost_amt", getTrsp45ftCostAmt());
		this.hashColumns.put("rf_20ft_ttl_cost_amt", getRf20ftTtlCostAmt());
		this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
		this.hashColumns.put("mb_45ft_rto", getMb45ftRto());
		this.hashColumns.put("loc_grp_no", getLocGrpNo());
		this.hashColumns.put("trsp_20ft_cost_sys_src_cd", getTrsp20ftCostSysSrcCd());
		this.hashColumns.put("mty_trsp_20ft_cost_sys_src_cd", getMtyTrsp20ftCostSysSrcCd());
		this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
		this.hashColumns.put("mty_pkup_rtn_yd_cd", getMtyPkupRtnYdCd());
		this.hashColumns.put("inlnd_rout_cmb_flg", getInlndRoutCmbFlg());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("trsp_diff_40ft", getTrspDiff40ft());
		this.hashColumns.put("cost_trf_rf_seq", getCostTrfRfSeq());
		this.hashColumns.put("tml_40ft_adj_cost_amt", getTml40ftAdjCostAmt());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("inlnd_40ft_ttl_amt", getInlnd40ftTtlAmt());
		this.hashColumns.put("agmt_wgt_40ft", getAgmtWgt40ft());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("tml_45ft_cost_amt", getTml45ftCostAmt());
		this.hashColumns.put("mty_trsp_40ft_ttl_cost_amt", getMtyTrsp40ftTtlCostAmt());
		this.hashColumns.put("trsp_diff_45ft", getTrspDiff45ft());
		this.hashColumns.put("tml_45ft_cost_sys_src_cd", getTml45ftCostSysSrcCd());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("trsp_20ft_ttl_cost_amt", getTrsp20ftTtlCostAmt());
		this.hashColumns.put("port_nod_cd", getPortNodCd());
		this.hashColumns.put("hjl_fee_amt", getHjlFeeAmt());
		this.hashColumns.put("trsp_40ft_cost_sys_src_cd", getTrsp40ftCostSysSrcCd());
		this.hashColumns.put("tml_20ft_ttl_cost_amt", getTml20ftTtlCostAmt());
		this.hashColumns.put("trsp_40ft_adj_cost_amt", getTrsp40ftAdjCostAmt());
		this.hashColumns.put("trsp_45ft_ttl_cost_amt", getTrsp45ftTtlCostAmt());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
		this.hashColumns.put("trsp_agmt_45ft_mty_yd_cd", getTrspAgmt45ftMtyYdCd());
		this.hashColumns.put("trsp_rate_type_20ft", getTrspRateType20ft());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_rout_grp_no", "costRoutGrpNo");
		this.hashFields.put("agmt_wgt_20ft", "agmtWgt20ft");
		this.hashFields.put("tml_40ft_cost_sys_src_cd", "tml40ftCostSysSrcCd");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_45ft_cost_sys_src_cd", "trsp45ftCostSysSrcCd");
		this.hashFields.put("mty_trsp_40ft_cost_sys_src_cd", "mtyTrsp40ftCostSysSrcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("mty_trsp_20ft_ttl_cost_amt", "mtyTrsp20ftTtlCostAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("trsp_40ft_ttl_cost_amt", "trsp40ftTtlCostAmt");
		this.hashFields.put("mty_trsp_45ft_adj_cost_amt", "mtyTrsp45ftAdjCostAmt");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
		this.hashFields.put("inlnd_20ft_ttl_amt", "inlnd20ftTtlAmt");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("rf_40ft_ttl_cost_amt", "rf40ftTtlCostAmt");
		this.hashFields.put("trsp_agmt_20ft_mty_yd_cd", "trspAgmt20ftMtyYdCd");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("trsp_45ft_adj_cost_amt", "trsp45ftAdjCostAmt");
		this.hashFields.put("trsp_rate_type_45ft", "trspRateType45ft");
		this.hashFields.put("trsp_20ft_adj_cost_amt", "trsp20ftAdjCostAmt");
		this.hashFields.put("trsp_diff_20ft", "trspDiff20ft");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("tml_20ft_cost_sys_src_cd", "tml20ftCostSysSrcCd");
		this.hashFields.put("port_loc", "portLoc");
		this.hashFields.put("mty_trsp_40ft_adj_cost_amt", "mtyTrsp40ftAdjCostAmt");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("inlnd_45ft_ttl_amt", "inlnd45ftTtlAmt");
		this.hashFields.put("loc_nod_cd", "locNodCd");
		this.hashFields.put("mty_trsp_45ft_ttl_cost_amt", "mtyTrsp45ftTtlCostAmt");
		this.hashFields.put("mty_trsp_45ft_cost_amt", "mtyTrsp45ftCostAmt");
		this.hashFields.put("agmt_wgt_45ft", "agmtWgt45ft");
		this.hashFields.put("rcv_de_term_nm", "rcvDeTermNm");
		this.hashFields.put("trsp_rate_type_40ft", "trspRateType40ft");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trsp_agmt_40ft_mty_yd_cd", "trspAgmt40ftMtyYdCd");
		this.hashFields.put("tml_40ft_ttl_cost_amt", "tml40ftTtlCostAmt");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("mty_trsp_20ft_adj_cost_amt", "mtyTrsp20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_adj_cost_amt", "tml20ftAdjCostAmt");
		this.hashFields.put("tml_45ft_ttl_cost_amt", "tml45ftTtlCostAmt");
		this.hashFields.put("tml_45ft_adj_cost_amt", "tml45ftAdjCostAmt");
		this.hashFields.put("mty_trsp_45ft_cost_sys_src_cd", "mtyTrsp45ftCostSysSrcCd");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_45ft_cost_amt", "trsp45ftCostAmt");
		this.hashFields.put("rf_20ft_ttl_cost_amt", "rf20ftTtlCostAmt");
		this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
		this.hashFields.put("mb_45ft_rto", "mb45ftRto");
		this.hashFields.put("loc_grp_no", "locGrpNo");
		this.hashFields.put("trsp_20ft_cost_sys_src_cd", "trsp20ftCostSysSrcCd");
		this.hashFields.put("mty_trsp_20ft_cost_sys_src_cd", "mtyTrsp20ftCostSysSrcCd");
		this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
		this.hashFields.put("mty_pkup_rtn_yd_cd", "mtyPkupRtnYdCd");
		this.hashFields.put("inlnd_rout_cmb_flg", "inlndRoutCmbFlg");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("trsp_diff_40ft", "trspDiff40ft");
		this.hashFields.put("cost_trf_rf_seq", "costTrfRfSeq");
		this.hashFields.put("tml_40ft_adj_cost_amt", "tml40ftAdjCostAmt");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("inlnd_40ft_ttl_amt", "inlnd40ftTtlAmt");
		this.hashFields.put("agmt_wgt_40ft", "agmtWgt40ft");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("tml_45ft_cost_amt", "tml45ftCostAmt");
		this.hashFields.put("mty_trsp_40ft_ttl_cost_amt", "mtyTrsp40ftTtlCostAmt");
		this.hashFields.put("trsp_diff_45ft", "trspDiff45ft");
		this.hashFields.put("tml_45ft_cost_sys_src_cd", "tml45ftCostSysSrcCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("trsp_20ft_ttl_cost_amt", "trsp20ftTtlCostAmt");
		this.hashFields.put("port_nod_cd", "portNodCd");
		this.hashFields.put("hjl_fee_amt", "hjlFeeAmt");
		this.hashFields.put("trsp_40ft_cost_sys_src_cd", "trsp40ftCostSysSrcCd");
		this.hashFields.put("tml_20ft_ttl_cost_amt", "tml20ftTtlCostAmt");
		this.hashFields.put("trsp_40ft_adj_cost_amt", "trsp40ftAdjCostAmt");
		this.hashFields.put("trsp_45ft_ttl_cost_amt", "trsp45ftTtlCostAmt");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
		this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
		this.hashFields.put("trsp_agmt_45ft_mty_yd_cd", "trspAgmt45ftMtyYdCd");
		this.hashFields.put("trsp_rate_type_20ft", "trspRateType20ft");
		return this.hashFields;
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
	 * @return agmtWgt20ft
	 */
	public String getAgmtWgt20ft() {
		return this.agmtWgt20ft;
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
	 * @return trsp45ftCostSysSrcCd
	 */
	public String getTrsp45ftCostSysSrcCd() {
		return this.trsp45ftCostSysSrcCd;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
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
	 * @return trsp40ftTtlCostAmt
	 */
	public String getTrsp40ftTtlCostAmt() {
		return this.trsp40ftTtlCostAmt;
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
	 * @return mtyTrsp40ftCostAmt
	 */
	public String getMtyTrsp40ftCostAmt() {
		return this.mtyTrsp40ftCostAmt;
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
	 * @return rf40ftTtlCostAmt
	 */
	public String getRf40ftTtlCostAmt() {
		return this.rf40ftTtlCostAmt;
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
	 * @return trsp45ftAdjCostAmt
	 */
	public String getTrsp45ftAdjCostAmt() {
		return this.trsp45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trspRateType45ft
	 */
	public String getTrspRateType45ft() {
		return this.trspRateType45ft;
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
	 * @return trspDiff20ft
	 */
	public String getTrspDiff20ft() {
		return this.trspDiff20ft;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
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
	 * @return portLoc
	 */
	public String getPortLoc() {
		return this.portLoc;
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
	 * @return inlnd45ftTtlAmt
	 */
	public String getInlnd45ftTtlAmt() {
		return this.inlnd45ftTtlAmt;
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
	 * @return mtyTrsp45ftTtlCostAmt
	 */
	public String getMtyTrsp45ftTtlCostAmt() {
		return this.mtyTrsp45ftTtlCostAmt;
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
	 * @return agmtWgt45ft
	 */
	public String getAgmtWgt45ft() {
		return this.agmtWgt45ft;
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
	 * @return trspAgmt40ftMtyYdCd
	 */
	public String getTrspAgmt40ftMtyYdCd() {
		return this.trspAgmt40ftMtyYdCd;
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
	 * @return mtyTrsp45ftCostSysSrcCd
	 */
	public String getMtyTrsp45ftCostSysSrcCd() {
		return this.mtyTrsp45ftCostSysSrcCd;
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
	 * @return rf20ftTtlCostAmt
	 */
	public String getRf20ftTtlCostAmt() {
		return this.rf20ftTtlCostAmt;
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
	 * @return mb45ftRto
	 */
	public String getMb45ftRto() {
		return this.mb45ftRto;
	}
	
	/**
	 * Column Info
	 * @return locGrpNo
	 */
	public String getLocGrpNo() {
		return this.locGrpNo;
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
	 * @return mtyTrsp20ftCostSysSrcCd
	 */
	public String getMtyTrsp20ftCostSysSrcCd() {
		return this.mtyTrsp20ftCostSysSrcCd;
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
	 * @return trspDiff40ft
	 */
	public String getTrspDiff40ft() {
		return this.trspDiff40ft;
	}
	
	/**
	 * Column Info
	 * @return costTrfRfSeq
	 */
	public String getCostTrfRfSeq() {
		return this.costTrfRfSeq;
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
	 * @return inlnd40ftTtlAmt
	 */
	public String getInlnd40ftTtlAmt() {
		return this.inlnd40ftTtlAmt;
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
	 * @return hubNodCd
	 */
	public String getHubNodCd() {
		return this.hubNodCd;
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
	 * @return mtyTrsp40ftTtlCostAmt
	 */
	public String getMtyTrsp40ftTtlCostAmt() {
		return this.mtyTrsp40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return trspDiff45ft
	 */
	public String getTrspDiff45ft() {
		return this.trspDiff45ft;
	}
	
	/**
	 * Column Info
	 * @return tml45ftCostSysSrcCd
	 */
	public String getTml45ftCostSysSrcCd() {
		return this.tml45ftCostSysSrcCd;
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
	 * @return tml20ftCostAmt
	 */
	public String getTml20ftCostAmt() {
		return this.tml20ftCostAmt;
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
	 * @return portNodCd
	 */
	public String getPortNodCd() {
		return this.portNodCd;
	}
	
	/**
	 * Column Info
	 * @return hjlFeeAmt
	 */
	public String getHjlFeeAmt() {
		return this.hjlFeeAmt;
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
	 * @return tml20ftTtlCostAmt
	 */
	public String getTml20ftTtlCostAmt() {
		return this.tml20ftTtlCostAmt;
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
	 * @return n2ndVndrNm
	 */
	public String getN2ndVndrNm() {
		return this.n2ndVndrNm;
	}
	
	/**
	 * Column Info
	 * @return trspAgmt45ftMtyYdCd
	 */
	public String getTrspAgmt45ftMtyYdCd() {
		return this.trspAgmt45ftMtyYdCd;
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
	 * @param costRoutGrpNo
	 */
	public void setCostRoutGrpNo(String costRoutGrpNo) {
		this.costRoutGrpNo = costRoutGrpNo;
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
	 * @param tml40ftCostSysSrcCd
	 */
	public void setTml40ftCostSysSrcCd(String tml40ftCostSysSrcCd) {
		this.tml40ftCostSysSrcCd = tml40ftCostSysSrcCd;
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
	 * @param trsp45ftCostSysSrcCd
	 */
	public void setTrsp45ftCostSysSrcCd(String trsp45ftCostSysSrcCd) {
		this.trsp45ftCostSysSrcCd = trsp45ftCostSysSrcCd;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
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
	 * @param trsp40ftTtlCostAmt
	 */
	public void setTrsp40ftTtlCostAmt(String trsp40ftTtlCostAmt) {
		this.trsp40ftTtlCostAmt = trsp40ftTtlCostAmt;
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
	 * @param mtyTrsp40ftCostAmt
	 */
	public void setMtyTrsp40ftCostAmt(String mtyTrsp40ftCostAmt) {
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
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
	 * @param rf40ftTtlCostAmt
	 */
	public void setRf40ftTtlCostAmt(String rf40ftTtlCostAmt) {
		this.rf40ftTtlCostAmt = rf40ftTtlCostAmt;
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
	 * @param trsp45ftAdjCostAmt
	 */
	public void setTrsp45ftAdjCostAmt(String trsp45ftAdjCostAmt) {
		this.trsp45ftAdjCostAmt = trsp45ftAdjCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trspRateType45ft
	 */
	public void setTrspRateType45ft(String trspRateType45ft) {
		this.trspRateType45ft = trspRateType45ft;
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
	 * @param trspDiff20ft
	 */
	public void setTrspDiff20ft(String trspDiff20ft) {
		this.trspDiff20ft = trspDiff20ft;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
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
	 * @param portLoc
	 */
	public void setPortLoc(String portLoc) {
		this.portLoc = portLoc;
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
	 * @param inlnd45ftTtlAmt
	 */
	public void setInlnd45ftTtlAmt(String inlnd45ftTtlAmt) {
		this.inlnd45ftTtlAmt = inlnd45ftTtlAmt;
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
	 * @param mtyTrsp45ftTtlCostAmt
	 */
	public void setMtyTrsp45ftTtlCostAmt(String mtyTrsp45ftTtlCostAmt) {
		this.mtyTrsp45ftTtlCostAmt = mtyTrsp45ftTtlCostAmt;
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
	 * @param agmtWgt45ft
	 */
	public void setAgmtWgt45ft(String agmtWgt45ft) {
		this.agmtWgt45ft = agmtWgt45ft;
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
	 * @param trspAgmt40ftMtyYdCd
	 */
	public void setTrspAgmt40ftMtyYdCd(String trspAgmt40ftMtyYdCd) {
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
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
	 * @param mtyTrsp45ftCostSysSrcCd
	 */
	public void setMtyTrsp45ftCostSysSrcCd(String mtyTrsp45ftCostSysSrcCd) {
		this.mtyTrsp45ftCostSysSrcCd = mtyTrsp45ftCostSysSrcCd;
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
	 * @param rf20ftTtlCostAmt
	 */
	public void setRf20ftTtlCostAmt(String rf20ftTtlCostAmt) {
		this.rf20ftTtlCostAmt = rf20ftTtlCostAmt;
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
	 * @param mb45ftRto
	 */
	public void setMb45ftRto(String mb45ftRto) {
		this.mb45ftRto = mb45ftRto;
	}
	
	/**
	 * Column Info
	 * @param locGrpNo
	 */
	public void setLocGrpNo(String locGrpNo) {
		this.locGrpNo = locGrpNo;
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
	 * @param mtyTrsp20ftCostSysSrcCd
	 */
	public void setMtyTrsp20ftCostSysSrcCd(String mtyTrsp20ftCostSysSrcCd) {
		this.mtyTrsp20ftCostSysSrcCd = mtyTrsp20ftCostSysSrcCd;
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
	 * @param trspDiff40ft
	 */
	public void setTrspDiff40ft(String trspDiff40ft) {
		this.trspDiff40ft = trspDiff40ft;
	}
	
	/**
	 * Column Info
	 * @param costTrfRfSeq
	 */
	public void setCostTrfRfSeq(String costTrfRfSeq) {
		this.costTrfRfSeq = costTrfRfSeq;
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
	 * @param inlnd40ftTtlAmt
	 */
	public void setInlnd40ftTtlAmt(String inlnd40ftTtlAmt) {
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
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
	 * @param hubNodCd
	 */
	public void setHubNodCd(String hubNodCd) {
		this.hubNodCd = hubNodCd;
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
	 * @param mtyTrsp40ftTtlCostAmt
	 */
	public void setMtyTrsp40ftTtlCostAmt(String mtyTrsp40ftTtlCostAmt) {
		this.mtyTrsp40ftTtlCostAmt = mtyTrsp40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param trspDiff45ft
	 */
	public void setTrspDiff45ft(String trspDiff45ft) {
		this.trspDiff45ft = trspDiff45ft;
	}
	
	/**
	 * Column Info
	 * @param tml45ftCostSysSrcCd
	 */
	public void setTml45ftCostSysSrcCd(String tml45ftCostSysSrcCd) {
		this.tml45ftCostSysSrcCd = tml45ftCostSysSrcCd;
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
	 * @param tml20ftCostAmt
	 */
	public void setTml20ftCostAmt(String tml20ftCostAmt) {
		this.tml20ftCostAmt = tml20ftCostAmt;
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
	 * @param portNodCd
	 */
	public void setPortNodCd(String portNodCd) {
		this.portNodCd = portNodCd;
	}
	
	/**
	 * Column Info
	 * @param hjlFeeAmt
	 */
	public void setHjlFeeAmt(String hjlFeeAmt) {
		this.hjlFeeAmt = hjlFeeAmt;
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
	 * @param tml20ftTtlCostAmt
	 */
	public void setTml20ftTtlCostAmt(String tml20ftTtlCostAmt) {
		this.tml20ftTtlCostAmt = tml20ftTtlCostAmt;
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
	 * @param n2ndVndrNm
	 */
	public void setN2ndVndrNm(String n2ndVndrNm) {
		this.n2ndVndrNm = n2ndVndrNm;
	}
	
	/**
	 * Column Info
	 * @param trspAgmt45ftMtyYdCd
	 */
	public void setTrspAgmt45ftMtyYdCd(String trspAgmt45ftMtyYdCd) {
		this.trspAgmt45ftMtyYdCd = trspAgmt45ftMtyYdCd;
	}
	
	/**
	 * Column Info
	 * @param trspRateType20ft
	 */
	public void setTrspRateType20ft(String trspRateType20ft) {
		this.trspRateType20ft = trspRateType20ft;
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
		setCostRoutGrpNo(JSPUtil.getParameter(request, prefix + "cost_rout_grp_no", ""));
		setAgmtWgt20ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_20ft", ""));
		setTml40ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_sys_src_cd", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrsp45ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "trsp_45ft_cost_sys_src_cd", ""));
		setMtyTrsp40ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_sys_src_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setMtyTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_ttl_cost_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_ttl_cost_amt", ""));
		setMtyTrsp45ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_adj_cost_amt", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
		setInlnd20ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_20ft_ttl_amt", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setRf40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_ttl_cost_amt", ""));
		setTrspAgmt20ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_20ft_mty_yd_cd", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setTrsp45ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_adj_cost_amt", ""));
		setTrspRateType45ft(JSPUtil.getParameter(request, prefix + "trsp_rate_type_45ft", ""));
		setTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_adj_cost_amt", ""));
		setTrspDiff20ft(JSPUtil.getParameter(request, prefix + "trsp_diff_20ft", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setTml20ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_sys_src_cd", ""));
		setPortLoc(JSPUtil.getParameter(request, prefix + "port_loc", ""));
		setMtyTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_adj_cost_amt", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setInlnd45ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_45ft_ttl_amt", ""));
		setLocNodCd(JSPUtil.getParameter(request, prefix + "loc_nod_cd", ""));
		setMtyTrsp45ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_ttl_cost_amt", ""));
		setMtyTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_cost_amt", ""));
		setAgmtWgt45ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_45ft", ""));
		setRcvDeTermNm(JSPUtil.getParameter(request, prefix + "rcv_de_term_nm", ""));
		setTrspRateType40ft(JSPUtil.getParameter(request, prefix + "trsp_rate_type_40ft", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTrspAgmt40ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_40ft_mty_yd_cd", ""));
		setTml40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_ttl_cost_amt", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setMtyTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_adj_cost_amt", ""));
		setTml20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_adj_cost_amt", ""));
		setTml45ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_ttl_cost_amt", ""));
		setTml45ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_adj_cost_amt", ""));
		setMtyTrsp45ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_cost_sys_src_cd", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_cost_amt", ""));
		setRf20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_ttl_cost_amt", ""));
		setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
		setMb45ftRto(JSPUtil.getParameter(request, prefix + "mb_45ft_rto", ""));
		setLocGrpNo(JSPUtil.getParameter(request, prefix + "loc_grp_no", ""));
		setTrsp20ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_sys_src_cd", ""));
		setMtyTrsp20ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_sys_src_cd", ""));
		setN1stVndrNm(JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", ""));
		setMtyPkupRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_cd", ""));
		setInlndRoutCmbFlg(JSPUtil.getParameter(request, prefix + "inlnd_rout_cmb_flg", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setTrspDiff40ft(JSPUtil.getParameter(request, prefix + "trsp_diff_40ft", ""));
		setCostTrfRfSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rf_seq", ""));
		setTml40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_adj_cost_amt", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setInlnd40ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_40ft_ttl_amt", ""));
		setAgmtWgt40ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_40ft", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setTml45ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_cost_amt", ""));
		setMtyTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_ttl_cost_amt", ""));
		setTrspDiff45ft(JSPUtil.getParameter(request, prefix + "trsp_diff_45ft", ""));
		setTml45ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "tml_45ft_cost_sys_src_cd", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_ttl_cost_amt", ""));
		setPortNodCd(JSPUtil.getParameter(request, prefix + "port_nod_cd", ""));
		setHjlFeeAmt(JSPUtil.getParameter(request, prefix + "hjl_fee_amt", ""));
		setTrsp40ftCostSysSrcCd(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_sys_src_cd", ""));
		setTml20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_ttl_cost_amt", ""));
		setTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_adj_cost_amt", ""));
		setTrsp45ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_ttl_cost_amt", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
		setN2ndVndrNm(JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", ""));
		setTrspAgmt45ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_45ft_mty_yd_cd", ""));
		setTrspRateType20ft(JSPUtil.getParameter(request, prefix + "trsp_rate_type_20ft", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurInlandCostVO[]
	 */
	public EurInlandCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurInlandCostVO[]
	 */
	public EurInlandCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurInlandCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costRoutGrpNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_grp_no", length));
			String[] agmtWgt20ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_20ft", length));
			String[] tml40ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_sys_src_cd", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trsp45ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_cost_sys_src_cd", length));
			String[] mtyTrsp40ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_sys_src_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] mtyTrsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_ttl_cost_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] trsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_ttl_cost_amt", length));
			String[] mtyTrsp45ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_adj_cost_amt", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_seq", length));
			String[] inlnd20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_20ft_ttl_amt", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] rf40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_ttl_cost_amt", length));
			String[] trspAgmt20ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_20ft_mty_yd_cd", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] trsp45ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_adj_cost_amt", length));
			String[] trspRateType45ft = (JSPUtil.getParameter(request, prefix	+ "trsp_rate_type_45ft", length));
			String[] trsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_adj_cost_amt", length));
			String[] trspDiff20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_20ft", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] tml20ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_sys_src_cd", length));
			String[] portLoc = (JSPUtil.getParameter(request, prefix	+ "port_loc", length));
			String[] mtyTrsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_adj_cost_amt", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] inlnd45ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_45ft_ttl_amt", length));
			String[] locNodCd = (JSPUtil.getParameter(request, prefix	+ "loc_nod_cd", length));
			String[] mtyTrsp45ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_ttl_cost_amt", length));
			String[] mtyTrsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_cost_amt", length));
			String[] agmtWgt45ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_45ft", length));
			String[] rcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_nm", length));
			String[] trspRateType40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_rate_type_40ft", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] trspAgmt40ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_40ft_mty_yd_cd", length));
			String[] tml40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_ttl_cost_amt", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] mtyTrsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_adj_cost_amt", length));
			String[] tml20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_adj_cost_amt", length));
			String[] tml45ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_ttl_cost_amt", length));
			String[] tml45ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_adj_cost_amt", length));
			String[] mtyTrsp45ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_cost_sys_src_cd", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_cost_amt", length));
			String[] rf20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_ttl_cost_amt", length));
			String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_seq", length));
			String[] mb45ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_45ft_rto", length));
			String[] locGrpNo = (JSPUtil.getParameter(request, prefix	+ "loc_grp_no", length));
			String[] trsp20ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_sys_src_cd", length));
			String[] mtyTrsp20ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_sys_src_cd", length));
			String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_nm", length));
			String[] mtyPkupRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_cd", length));
			String[] inlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_cmb_flg", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] trspDiff40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_40ft", length));
			String[] costTrfRfSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rf_seq", length));
			String[] tml40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_adj_cost_amt", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] inlnd40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_ttl_amt", length));
			String[] agmtWgt40ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_40ft", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] tml45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_cost_amt", length));
			String[] mtyTrsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_ttl_cost_amt", length));
			String[] trspDiff45ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_45ft", length));
			String[] tml45ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_cost_sys_src_cd", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] trsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_ttl_cost_amt", length));
			String[] portNodCd = (JSPUtil.getParameter(request, prefix	+ "port_nod_cd", length));
			String[] hjlFeeAmt = (JSPUtil.getParameter(request, prefix	+ "hjl_fee_amt", length));
			String[] trsp40ftCostSysSrcCd = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_sys_src_cd", length));
			String[] tml20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_ttl_cost_amt", length));
			String[] trsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_adj_cost_amt", length));
			String[] trsp45ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_ttl_cost_amt", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_nm", length));
			String[] trspAgmt45ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_45ft_mty_yd_cd", length));
			String[] trspRateType20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_rate_type_20ft", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurInlandCostVO();
				if (costRoutGrpNo[i] != null)
					model.setCostRoutGrpNo(costRoutGrpNo[i]);
				if (agmtWgt20ft[i] != null)
					model.setAgmtWgt20ft(agmtWgt20ft[i]);
				if (tml40ftCostSysSrcCd[i] != null)
					model.setTml40ftCostSysSrcCd(tml40ftCostSysSrcCd[i]);
				if (costTrfRoutSeq[i] != null)
					model.setCostTrfRoutSeq(costTrfRoutSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trsp45ftCostSysSrcCd[i] != null)
					model.setTrsp45ftCostSysSrcCd(trsp45ftCostSysSrcCd[i]);
				if (mtyTrsp40ftCostSysSrcCd[i] != null)
					model.setMtyTrsp40ftCostSysSrcCd(mtyTrsp40ftCostSysSrcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (mtyTrsp20ftTtlCostAmt[i] != null)
					model.setMtyTrsp20ftTtlCostAmt(mtyTrsp20ftTtlCostAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (trsp40ftTtlCostAmt[i] != null)
					model.setTrsp40ftTtlCostAmt(trsp40ftTtlCostAmt[i]);
				if (mtyTrsp45ftAdjCostAmt[i] != null)
					model.setMtyTrsp45ftAdjCostAmt(mtyTrsp45ftAdjCostAmt[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (n2ndVndrSeq[i] != null)
					model.setN2ndVndrSeq(n2ndVndrSeq[i]);
				if (inlnd20ftTtlAmt[i] != null)
					model.setInlnd20ftTtlAmt(inlnd20ftTtlAmt[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (rf40ftTtlCostAmt[i] != null)
					model.setRf40ftTtlCostAmt(rf40ftTtlCostAmt[i]);
				if (trspAgmt20ftMtyYdCd[i] != null)
					model.setTrspAgmt20ftMtyYdCd(trspAgmt20ftMtyYdCd[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (trsp45ftAdjCostAmt[i] != null)
					model.setTrsp45ftAdjCostAmt(trsp45ftAdjCostAmt[i]);
				if (trspRateType45ft[i] != null)
					model.setTrspRateType45ft(trspRateType45ft[i]);
				if (trsp20ftAdjCostAmt[i] != null)
					model.setTrsp20ftAdjCostAmt(trsp20ftAdjCostAmt[i]);
				if (trspDiff20ft[i] != null)
					model.setTrspDiff20ft(trspDiff20ft[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (tml20ftCostSysSrcCd[i] != null)
					model.setTml20ftCostSysSrcCd(tml20ftCostSysSrcCd[i]);
				if (portLoc[i] != null)
					model.setPortLoc(portLoc[i]);
				if (mtyTrsp40ftAdjCostAmt[i] != null)
					model.setMtyTrsp40ftAdjCostAmt(mtyTrsp40ftAdjCostAmt[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (inlnd45ftTtlAmt[i] != null)
					model.setInlnd45ftTtlAmt(inlnd45ftTtlAmt[i]);
				if (locNodCd[i] != null)
					model.setLocNodCd(locNodCd[i]);
				if (mtyTrsp45ftTtlCostAmt[i] != null)
					model.setMtyTrsp45ftTtlCostAmt(mtyTrsp45ftTtlCostAmt[i]);
				if (mtyTrsp45ftCostAmt[i] != null)
					model.setMtyTrsp45ftCostAmt(mtyTrsp45ftCostAmt[i]);
				if (agmtWgt45ft[i] != null)
					model.setAgmtWgt45ft(agmtWgt45ft[i]);
				if (rcvDeTermNm[i] != null)
					model.setRcvDeTermNm(rcvDeTermNm[i]);
				if (trspRateType40ft[i] != null)
					model.setTrspRateType40ft(trspRateType40ft[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (trspAgmt40ftMtyYdCd[i] != null)
					model.setTrspAgmt40ftMtyYdCd(trspAgmt40ftMtyYdCd[i]);
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
				if (mtyTrsp45ftCostSysSrcCd[i] != null)
					model.setMtyTrsp45ftCostSysSrcCd(mtyTrsp45ftCostSysSrcCd[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsp45ftCostAmt[i] != null)
					model.setTrsp45ftCostAmt(trsp45ftCostAmt[i]);
				if (rf20ftTtlCostAmt[i] != null)
					model.setRf20ftTtlCostAmt(rf20ftTtlCostAmt[i]);
				if (n1stVndrSeq[i] != null)
					model.setN1stVndrSeq(n1stVndrSeq[i]);
				if (mb45ftRto[i] != null)
					model.setMb45ftRto(mb45ftRto[i]);
				if (locGrpNo[i] != null)
					model.setLocGrpNo(locGrpNo[i]);
				if (trsp20ftCostSysSrcCd[i] != null)
					model.setTrsp20ftCostSysSrcCd(trsp20ftCostSysSrcCd[i]);
				if (mtyTrsp20ftCostSysSrcCd[i] != null)
					model.setMtyTrsp20ftCostSysSrcCd(mtyTrsp20ftCostSysSrcCd[i]);
				if (n1stVndrNm[i] != null)
					model.setN1stVndrNm(n1stVndrNm[i]);
				if (mtyPkupRtnYdCd[i] != null)
					model.setMtyPkupRtnYdCd(mtyPkupRtnYdCd[i]);
				if (inlndRoutCmbFlg[i] != null)
					model.setInlndRoutCmbFlg(inlndRoutCmbFlg[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (trspDiff40ft[i] != null)
					model.setTrspDiff40ft(trspDiff40ft[i]);
				if (costTrfRfSeq[i] != null)
					model.setCostTrfRfSeq(costTrfRfSeq[i]);
				if (tml40ftAdjCostAmt[i] != null)
					model.setTml40ftAdjCostAmt(tml40ftAdjCostAmt[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (inlnd40ftTtlAmt[i] != null)
					model.setInlnd40ftTtlAmt(inlnd40ftTtlAmt[i]);
				if (agmtWgt40ft[i] != null)
					model.setAgmtWgt40ft(agmtWgt40ft[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (tml45ftCostAmt[i] != null)
					model.setTml45ftCostAmt(tml45ftCostAmt[i]);
				if (mtyTrsp40ftTtlCostAmt[i] != null)
					model.setMtyTrsp40ftTtlCostAmt(mtyTrsp40ftTtlCostAmt[i]);
				if (trspDiff45ft[i] != null)
					model.setTrspDiff45ft(trspDiff45ft[i]);
				if (tml45ftCostSysSrcCd[i] != null)
					model.setTml45ftCostSysSrcCd(tml45ftCostSysSrcCd[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (trsp20ftTtlCostAmt[i] != null)
					model.setTrsp20ftTtlCostAmt(trsp20ftTtlCostAmt[i]);
				if (portNodCd[i] != null)
					model.setPortNodCd(portNodCd[i]);
				if (hjlFeeAmt[i] != null)
					model.setHjlFeeAmt(hjlFeeAmt[i]);
				if (trsp40ftCostSysSrcCd[i] != null)
					model.setTrsp40ftCostSysSrcCd(trsp40ftCostSysSrcCd[i]);
				if (tml20ftTtlCostAmt[i] != null)
					model.setTml20ftTtlCostAmt(tml20ftTtlCostAmt[i]);
				if (trsp40ftAdjCostAmt[i] != null)
					model.setTrsp40ftAdjCostAmt(trsp40ftAdjCostAmt[i]);
				if (trsp45ftTtlCostAmt[i] != null)
					model.setTrsp45ftTtlCostAmt(trsp45ftTtlCostAmt[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				if (n2ndVndrNm[i] != null)
					model.setN2ndVndrNm(n2ndVndrNm[i]);
				if (trspAgmt45ftMtyYdCd[i] != null)
					model.setTrspAgmt45ftMtyYdCd(trspAgmt45ftMtyYdCd[i]);
				if (trspRateType20ft[i] != null)
					model.setTrspRateType20ft(trspRateType20ft[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurInlandCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurInlandCostVO[]
	 */
	public EurInlandCostVO[] getEurInlandCostVOs(){
		EurInlandCostVO[] vos = (EurInlandCostVO[])models.toArray(new EurInlandCostVO[models.size()]);
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
		this.costRoutGrpNo = this.costRoutGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWgt20ft = this.agmtWgt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostSysSrcCd = this.tml40ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftCostSysSrcCd = this.trsp45ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostSysSrcCd = this.mtyTrsp40ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftTtlCostAmt = this.mtyTrsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftTtlCostAmt = this.trsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftAdjCostAmt = this.mtyTrsp45ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrSeq = this.n2ndVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd20ftTtlAmt = this.inlnd20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftTtlCostAmt = this.rf40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt20ftMtyYdCd = this.trspAgmt20ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftAdjCostAmt = this.trsp45ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRateType45ft = this.trspRateType45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftAdjCostAmt = this.trsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff20ft = this.trspDiff20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSysSrcCd = this.tml20ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLoc = this.portLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftAdjCostAmt = this.mtyTrsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd45ftTtlAmt = this.inlnd45ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNodCd = this.locNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftTtlCostAmt = this.mtyTrsp45ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftCostAmt = this.mtyTrsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWgt45ft = this.agmtWgt45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermNm = this.rcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRateType40ft = this.trspRateType40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt40ftMtyYdCd = this.trspAgmt40ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftTtlCostAmt = this.tml40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftAdjCostAmt = this.mtyTrsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftAdjCostAmt = this.tml20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftTtlCostAmt = this.tml45ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftAdjCostAmt = this.tml45ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftCostSysSrcCd = this.mtyTrsp45ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftCostAmt = this.trsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftTtlCostAmt = this.rf20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrSeq = this.n1stVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb45ftRto = this.mb45ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpNo = this.locGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostSysSrcCd = this.trsp20ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostSysSrcCd = this.mtyTrsp20ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrNm = this.n1stVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdCd = this.mtyPkupRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutCmbFlg = this.inlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff40ft = this.trspDiff40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRfSeq = this.costTrfRfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftAdjCostAmt = this.tml40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftTtlAmt = this.inlnd40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWgt40ft = this.agmtWgt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftCostAmt = this.tml45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftTtlCostAmt = this.mtyTrsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff45ft = this.trspDiff45ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftCostSysSrcCd = this.tml45ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftTtlCostAmt = this.trsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNodCd = this.portNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjlFeeAmt = this.hjlFeeAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostSysSrcCd = this.trsp40ftCostSysSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftTtlCostAmt = this.tml20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftAdjCostAmt = this.trsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftTtlCostAmt = this.trsp45ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrNm = this.n2ndVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt45ftMtyYdCd = this.trspAgmt45ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRateType20ft = this.trspRateType20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
