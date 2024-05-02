/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlnadCostInquiryVO.java
*@FileTitle : AsiaInlnadCostInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.26  
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

import com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo.AsiaInlnadCostInquiryVO;
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

public class AsiaInlnadCostInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AsiaInlnadCostInquiryVO> models = new ArrayList<AsiaInlnadCostInquiryVO>();
	
	/* Column Info */
	private String trsp40ftCostSysSrcNm = null;
	/* Column Info */
	private String mtyTrsp20ftCostSysSrcNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String mtyTrsp20ftTtlCostAmt = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String trsp40ftTtlCostAmt = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String costSelRoutFlg = null;
	/* Column Info */
	private String n2ndVndrSeq = null;
	/* Column Info */
	private String inlnd20ftTtlAmt = null;
	/* Column Info */
	private String trsp20ftCostSysSrcNm = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String trspAgmt20ftMtyYdCd = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String trsp20ftAdjCostAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String trspDiff20ft = null;
	/* Column Info */
	private String portLoc = null;
	/* Column Info */
	private String mtyTrsp40ftAdjCostAmt = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String locNodCd = null;
	/* Column Info */
	private String loclUpdDt = null;
	/* Column Info */
	private String rcvDeTermNm = null;
	/* Column Info */
	private String trspRateType40ft = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String trspAgmt40ftMtyYdCd = null;
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
	private String tml20ftCostSysSrcNm = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String n1stVndrSeq = null;
	/* Column Info */
	private String locGrpNo = null;
	/* Column Info */
	private String n1stVndrNm = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String inlndRoutCmbFlg = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String trspDiff40ft = null;
	/* Column Info */
	private String tml40ftAdjCostAmt = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String inlnd40ftTtlAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String mtyTrsp40ftTtlCostAmt = null;
	/* Column Info */
	private String tml40ftCostSysSrcNm = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String trsp20ftTtlCostAmt = null;
	/* Column Info */
	private String portNodCd = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String trsp40ftAdjCostAmt = null;
	/* Column Info */
	private String tml20ftTtlCostAmt = null;
	/* Column Info */
	private String n2ndVndrNm = null;
	/* Column Info */
	private String trspRateType20ft = null;
	/* Column Info */
	private String agmtOldFlg = null;
	/* Column Info */
	private String costTrfRoutSeq = null;
	/* Column Info */
	private String agmtwgt20ft = null;
	/* Column Info */
	private String agmtwgt40ft = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rf20ftTtlCostAmt = null;
	/* Column Info */
	private String rf40ftTtlCostAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AsiaInlnadCostInquiryVO() {}

	public AsiaInlnadCostInquiryVO(String ibflag, String pagerows, String cntCd, String ioBndCd, String costTrfNo, String costTrfStsNm, String effFmDt, String portLoc, String rcvDeTermNm, String costSelRoutFlg, String portNodCd, String hubNodCd, String locNodCd, String trspCrrModCd, String inlnd20ftTtlAmt, String inlnd40ftTtlAmt, String locGrpNo, String sccCd, String mb20ftRto, String mb40ftRto, String trsp20ftCostSysSrcNm, String trsp20ftCostAmt, String trsp20ftAdjCostAmt, String trsp20ftTtlCostAmt, String trspAgmt20ftMtyYdCd, String trspDiff20ft, String trspRateType20ft, String trsp40ftCostSysSrcNm, String trsp40ftCostAmt, String trsp40ftAdjCostAmt, String trsp40ftTtlCostAmt, String trspAgmt40ftMtyYdCd, String trspDiff40ft, String trspRateType40ft, String mtyTrsp20ftCostSysSrcNm, String mtyTrsp20ftCostAmt, String mtyTrsp20ftAdjCostAmt, String mtyTrsp20ftTtlCostAmt, String mtyTrsp40ftCostSysSrcNm, String mtyTrsp40ftCostAmt, String mtyTrsp40ftAdjCostAmt, String mtyTrsp40ftTtlCostAmt, String tml20ftCostSysSrcNm, String tml20ftCostAmt, String tml20ftAdjCostAmt, String tml20ftTtlCostAmt, String tml40ftCostSysSrcNm, String tml40ftCostAmt, String tml40ftAdjCostAmt, String tml40ftTtlCostAmt, String n1stVndrSeq, String n1stVndrNm, String inlndRoutCmbFlg, String n2ndVndrSeq, String n2ndVndrNm, String loclCreDt, String creUsrId, String creOfcCd, String loclUpdDt, String updUsrId, String updOfcCd, String agmtOldFlg, String costTrfRoutSeq, String agmtwgt20ft, String agmtwgt40ft, String currCd, String rf20ftTtlCostAmt, String rf40ftTtlCostAmt) {
		this.trsp40ftCostSysSrcNm = trsp40ftCostSysSrcNm;
		this.mtyTrsp20ftCostSysSrcNm = mtyTrsp20ftCostSysSrcNm;
		this.pagerows = pagerows;
		this.cntCd = cntCd;
		this.mtyTrsp20ftTtlCostAmt = mtyTrsp20ftTtlCostAmt;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.trsp40ftTtlCostAmt = trsp40ftTtlCostAmt;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.costSelRoutFlg = costSelRoutFlg;
		this.n2ndVndrSeq = n2ndVndrSeq;
		this.inlnd20ftTtlAmt = inlnd20ftTtlAmt;
		this.trsp20ftCostSysSrcNm = trsp20ftCostSysSrcNm;
		this.costTrfNo = costTrfNo;
		this.trspAgmt20ftMtyYdCd = trspAgmt20ftMtyYdCd;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.trsp20ftAdjCostAmt = trsp20ftAdjCostAmt;
		this.creUsrId = creUsrId;
		this.trspDiff20ft = trspDiff20ft;
		this.portLoc = portLoc;
		this.mtyTrsp40ftAdjCostAmt = mtyTrsp40ftAdjCostAmt;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.locNodCd = locNodCd;
		this.loclUpdDt = loclUpdDt;
		this.rcvDeTermNm = rcvDeTermNm;
		this.trspRateType40ft = trspRateType40ft;
		this.mb20ftRto = mb20ftRto;
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
		this.costTrfStsNm = costTrfStsNm;
		this.mtyTrsp40ftCostSysSrcNm = mtyTrsp40ftCostSysSrcNm;
		this.tml40ftTtlCostAmt = tml40ftTtlCostAmt;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.mtyTrsp20ftAdjCostAmt = mtyTrsp20ftAdjCostAmt;
		this.tml20ftAdjCostAmt = tml20ftAdjCostAmt;
		this.tml20ftCostSysSrcNm = tml20ftCostSysSrcNm;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.creOfcCd = creOfcCd;
		this.n1stVndrSeq = n1stVndrSeq;
		this.locGrpNo = locGrpNo;
		this.n1stVndrNm = n1stVndrNm;
		this.effFmDt = effFmDt;
		this.inlndRoutCmbFlg = inlndRoutCmbFlg;
		this.trspCrrModCd = trspCrrModCd;
		this.trspDiff40ft = trspDiff40ft;
		this.tml40ftAdjCostAmt = tml40ftAdjCostAmt;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.loclCreDt = loclCreDt;
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
		this.ioBndCd = ioBndCd;
		this.hubNodCd = hubNodCd;
		this.mtyTrsp40ftTtlCostAmt = mtyTrsp40ftTtlCostAmt;
		this.tml40ftCostSysSrcNm = tml40ftCostSysSrcNm;
		this.sccCd = sccCd;
		this.trsp20ftTtlCostAmt = trsp20ftTtlCostAmt;
		this.portNodCd = portNodCd;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.trsp40ftAdjCostAmt = trsp40ftAdjCostAmt;
		this.tml20ftTtlCostAmt = tml20ftTtlCostAmt;
		this.n2ndVndrNm = n2ndVndrNm;
		this.trspRateType20ft = trspRateType20ft;
		this.agmtOldFlg = agmtOldFlg;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.agmtwgt20ft = agmtwgt20ft;
		this.agmtwgt40ft = agmtwgt40ft;
		this.currCd = currCd;
		this.rf20ftTtlCostAmt = rf20ftTtlCostAmt;
		this.rf40ftTtlCostAmt = rf40ftTtlCostAmt;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_40ft_cost_sys_src_nm", getTrsp40ftCostSysSrcNm());
		this.hashColumns.put("mty_trsp_20ft_cost_sys_src_nm", getMtyTrsp20ftCostSysSrcNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("mty_trsp_20ft_ttl_cost_amt", getMtyTrsp20ftTtlCostAmt());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("trsp_40ft_ttl_cost_amt", getTrsp40ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("cost_sel_rout_flg", getCostSelRoutFlg());
		this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
		this.hashColumns.put("inlnd_20ft_ttl_amt", getInlnd20ftTtlAmt());
		this.hashColumns.put("trsp_20ft_cost_sys_src_nm", getTrsp20ftCostSysSrcNm());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("trsp_agmt_20ft_mty_yd_cd", getTrspAgmt20ftMtyYdCd());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("trsp_20ft_adj_cost_amt", getTrsp20ftAdjCostAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("trsp_diff_20ft", getTrspDiff20ft());
		this.hashColumns.put("port_loc", getPortLoc());
		this.hashColumns.put("mty_trsp_40ft_adj_cost_amt", getMtyTrsp40ftAdjCostAmt());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("loc_nod_cd", getLocNodCd());
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());
		this.hashColumns.put("rcv_de_term_nm", getRcvDeTermNm());
		this.hashColumns.put("trsp_rate_type_40ft", getTrspRateType40ft());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("trsp_agmt_40ft_mty_yd_cd", getTrspAgmt40ftMtyYdCd());
		this.hashColumns.put("cost_trf_sts_nm", getCostTrfStsNm());
		this.hashColumns.put("mty_trsp_40ft_cost_sys_src_nm", getMtyTrsp40ftCostSysSrcNm());
		this.hashColumns.put("tml_40ft_ttl_cost_amt", getTml40ftTtlCostAmt());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("mty_trsp_20ft_adj_cost_amt", getMtyTrsp20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_adj_cost_amt", getTml20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_cost_sys_src_nm", getTml20ftCostSysSrcNm());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
		this.hashColumns.put("loc_grp_no", getLocGrpNo());
		this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("inlnd_rout_cmb_flg", getInlndRoutCmbFlg());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("trsp_diff_40ft", getTrspDiff40ft());
		this.hashColumns.put("tml_40ft_adj_cost_amt", getTml40ftAdjCostAmt());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("inlnd_40ft_ttl_amt", getInlnd40ftTtlAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("mty_trsp_40ft_ttl_cost_amt", getMtyTrsp40ftTtlCostAmt());
		this.hashColumns.put("tml_40ft_cost_sys_src_nm", getTml40ftCostSysSrcNm());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("trsp_20ft_ttl_cost_amt", getTrsp20ftTtlCostAmt());
		this.hashColumns.put("port_nod_cd", getPortNodCd());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("trsp_40ft_adj_cost_amt", getTrsp40ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_ttl_cost_amt", getTml20ftTtlCostAmt());
		this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
		this.hashColumns.put("trsp_rate_type_20ft", getTrspRateType20ft());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("agmt_wgt_20ft", getAgmtwgt20ft());
		this.hashColumns.put("agmt_wgt_40ft", getAgmtwgt40ft());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rf_20ft_ttl_cost_amt", getRf20ftTtlCostAmt());
		this.hashColumns.put("rf_40ft_ttl_cost_amt", getRf40ftTtlCostAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_40ft_cost_sys_src_nm", "trsp40ftCostSysSrcNm");
		this.hashFields.put("mty_trsp_20ft_cost_sys_src_nm", "mtyTrsp20ftCostSysSrcNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("mty_trsp_20ft_ttl_cost_amt", "mtyTrsp20ftTtlCostAmt");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("trsp_40ft_ttl_cost_amt", "trsp40ftTtlCostAmt");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("cost_sel_rout_flg", "costSelRoutFlg");
		this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
		this.hashFields.put("inlnd_20ft_ttl_amt", "inlnd20ftTtlAmt");
		this.hashFields.put("trsp_20ft_cost_sys_src_nm", "trsp20ftCostSysSrcNm");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("trsp_agmt_20ft_mty_yd_cd", "trspAgmt20ftMtyYdCd");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("trsp_20ft_adj_cost_amt", "trsp20ftAdjCostAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("trsp_diff_20ft", "trspDiff20ft");
		this.hashFields.put("port_loc", "portLoc");
		this.hashFields.put("mty_trsp_40ft_adj_cost_amt", "mtyTrsp40ftAdjCostAmt");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("loc_nod_cd", "locNodCd");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("rcv_de_term_nm", "rcvDeTermNm");
		this.hashFields.put("trsp_rate_type_40ft", "trspRateType40ft");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("trsp_agmt_40ft_mty_yd_cd", "trspAgmt40ftMtyYdCd");
		this.hashFields.put("cost_trf_sts_nm", "costTrfStsNm");
		this.hashFields.put("mty_trsp_40ft_cost_sys_src_nm", "mtyTrsp40ftCostSysSrcNm");
		this.hashFields.put("tml_40ft_ttl_cost_amt", "tml40ftTtlCostAmt");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("mty_trsp_20ft_adj_cost_amt", "mtyTrsp20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_adj_cost_amt", "tml20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_cost_sys_src_nm", "tml20ftCostSysSrcNm");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
		this.hashFields.put("loc_grp_no", "locGrpNo");
		this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("inlnd_rout_cmb_flg", "inlndRoutCmbFlg");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("trsp_diff_40ft", "trspDiff40ft");
		this.hashFields.put("tml_40ft_adj_cost_amt", "tml40ftAdjCostAmt");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("inlnd_40ft_ttl_amt", "inlnd40ftTtlAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("mty_trsp_40ft_ttl_cost_amt", "mtyTrsp40ftTtlCostAmt");
		this.hashFields.put("tml_40ft_cost_sys_src_nm", "tml40ftCostSysSrcNm");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("trsp_20ft_ttl_cost_amt", "trsp20ftTtlCostAmt");
		this.hashFields.put("port_nod_cd", "portNodCd");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("trsp_40ft_adj_cost_amt", "trsp40ftAdjCostAmt");
		this.hashFields.put("tml_20ft_ttl_cost_amt", "tml20ftTtlCostAmt");
		this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
		this.hashFields.put("trsp_rate_type_20ft", "trspRateType20ft");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("agmt_wgt_20ft", "agmtwgt20ft");
		this.hashFields.put("agmt_wgt_40ft", "agmtwgt40ft");
		this.hashFields.put("curr_cd","currCd");
		this.hashFields.put("rf_20ft_ttl_cost_amt", "rf20ftTtlCostAmt");
		this.hashFields.put("rf_40ft_ttl_cost_amt", "rf40ftTtlCostAmt");
		return this.hashFields;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return trsp20ftAdjCostAmt
	 */
	public String getTrsp20ftAdjCostAmt() {
		return this.trsp20ftAdjCostAmt;
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
	 * @return trspDiff20ft
	 */
	public String getTrspDiff20ft() {
		return this.trspDiff20ft;
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
	 * @return locNodCd
	 */
	public String getLocNodCd() {
		return this.locNodCd;
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
	 * @return trspAgmt40ftMtyYdCd
	 */
	public String getTrspAgmt40ftMtyYdCd() {
		return this.trspAgmt40ftMtyYdCd;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return locGrpNo
	 */
	public String getLocGrpNo() {
		return this.locGrpNo;
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
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
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
	 * @return inlnd40ftTtlAmt
	 */
	public String getInlnd40ftTtlAmt() {
		return this.inlnd40ftTtlAmt;
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
	 * @return hubNodCd
	 */
	public String getHubNodCd() {
		return this.hubNodCd;
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
	 * @return portNodCd
	 */
	public String getPortNodCd() {
		return this.portNodCd;
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
	 * @return n2ndVndrNm
	 */
	public String getN2ndVndrNm() {
		return this.n2ndVndrNm;
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
	 * @return agmtOldFlg
	 */
	public String getAgmtOldFlg() {
		return this.agmtOldFlg;
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
	 * @return currCd
	 */
	public String getCurrCd(){
		return this.currCd;
	}
	
	
	/**
	 * Column Info
	 * @return rf20ftTtlCostAmt
	 */
	public String getRf20ftTtlCostAmt(){
		return this.rf20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rf40ftTtlCostAmt
	 */
	public String getRf40ftTtlCostAmt(){
		return this.rf40ftTtlCostAmt;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param trsp20ftAdjCostAmt
	 */
	public void setTrsp20ftAdjCostAmt(String trsp20ftAdjCostAmt) {
		this.trsp20ftAdjCostAmt = trsp20ftAdjCostAmt;
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
	 * @param trspDiff20ft
	 */
	public void setTrspDiff20ft(String trspDiff20ft) {
		this.trspDiff20ft = trspDiff20ft;
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
	 * @param locNodCd
	 */
	public void setLocNodCd(String locNodCd) {
		this.locNodCd = locNodCd;
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
	 * @param trspAgmt40ftMtyYdCd
	 */
	public void setTrspAgmt40ftMtyYdCd(String trspAgmt40ftMtyYdCd) {
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param locGrpNo
	 */
	public void setLocGrpNo(String locGrpNo) {
		this.locGrpNo = locGrpNo;
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
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
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
	 * @param inlnd40ftTtlAmt
	 */
	public void setInlnd40ftTtlAmt(String inlnd40ftTtlAmt) {
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
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
	 * @param hubNodCd
	 */
	public void setHubNodCd(String hubNodCd) {
		this.hubNodCd = hubNodCd;
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
	 * @param portNodCd
	 */
	public void setPortNodCd(String portNodCd) {
		this.portNodCd = portNodCd;
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
	 * @param n2ndVndrNm
	 */
	public void setN2ndVndrNm(String n2ndVndrNm) {
		this.n2ndVndrNm = n2ndVndrNm;
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
	 * @param agmtOldFlg
	 */
	public void setAgmtOldFlg(String agmtOldFlg) {
		this.agmtOldFlg = agmtOldFlg;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param rf40ftTtlCostAmt
	 */
	public void setRf40ftTtlCostAmt(String rf40ftTtlCostAmt) {
		this.rf40ftTtlCostAmt = rf40ftTtlCostAmt;
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
		setTrsp40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_sys_src_nm", ""));
		setMtyTrsp20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_sys_src_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setMtyTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_ttl_cost_amt", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_ttl_cost_amt", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setCostSelRoutFlg(JSPUtil.getParameter(request, prefix + "cost_sel_rout_flg", ""));
		setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
		setInlnd20ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_20ft_ttl_amt", ""));
		setTrsp20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_sys_src_nm", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setTrspAgmt20ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_20ft_mty_yd_cd", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_adj_cost_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTrspDiff20ft(JSPUtil.getParameter(request, prefix + "trsp_diff_20ft", ""));
		setPortLoc(JSPUtil.getParameter(request, prefix + "port_loc", ""));
		setMtyTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_adj_cost_amt", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setLocNodCd(JSPUtil.getParameter(request, prefix + "loc_nod_cd", ""));
		setLoclUpdDt(JSPUtil.getParameter(request, prefix + "locl_upd_dt", ""));
		setRcvDeTermNm(JSPUtil.getParameter(request, prefix + "rcv_de_term_nm", ""));
		setTrspRateType40ft(JSPUtil.getParameter(request, prefix + "trsp_rate_type_40ft", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setTrspAgmt40ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_40ft_mty_yd_cd", ""));
		setCostTrfStsNm(JSPUtil.getParameter(request, prefix + "cost_trf_sts_nm", ""));
		setMtyTrsp40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_sys_src_nm", ""));
		setTml40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_ttl_cost_amt", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setMtyTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_adj_cost_amt", ""));
		setTml20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_adj_cost_amt", ""));
		setTml20ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_sys_src_nm", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
		setLocGrpNo(JSPUtil.getParameter(request, prefix + "loc_grp_no", ""));
		setN1stVndrNm(JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setInlndRoutCmbFlg(JSPUtil.getParameter(request, prefix + "inlnd_rout_cmb_flg", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setTrspDiff40ft(JSPUtil.getParameter(request, prefix + "trsp_diff_40ft", ""));
		setTml40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_adj_cost_amt", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setInlnd40ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_40ft_ttl_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setMtyTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_ttl_cost_amt", ""));
		setTml40ftCostSysSrcNm(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_sys_src_nm", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_ttl_cost_amt", ""));
		setPortNodCd(JSPUtil.getParameter(request, prefix + "port_nod_cd", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_adj_cost_amt", ""));
		setTml20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_ttl_cost_amt", ""));
		setN2ndVndrNm(JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", ""));
		setTrspRateType20ft(JSPUtil.getParameter(request, prefix + "trsp_rate_type_20ft", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setAgmtwgt20ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_20ft", ""));
		setAgmtwgt40ft(JSPUtil.getParameter(request, prefix + "agmt_wgt_40ft", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setRf20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_ttl_cost_amt", ""));
		setRf40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_ttl_cost_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AsiaInlnadCostInquiryVO[]
	 */
	public AsiaInlnadCostInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AsiaInlnadCostInquiryVO[]
	 */
	public AsiaInlnadCostInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AsiaInlnadCostInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trsp40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_sys_src_nm", length));
			String[] mtyTrsp20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_sys_src_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] mtyTrsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_ttl_cost_amt", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] trsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_ttl_cost_amt", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] costSelRoutFlg = (JSPUtil.getParameter(request, prefix	+ "cost_sel_rout_flg", length));
			String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_seq", length));
			String[] inlnd20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_20ft_ttl_amt", length));
			String[] trsp20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_sys_src_nm", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] trspAgmt20ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_20ft_mty_yd_cd", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] trsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_adj_cost_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] trspDiff20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_20ft", length));
			String[] portLoc = (JSPUtil.getParameter(request, prefix	+ "port_loc", length));
			String[] mtyTrsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_adj_cost_amt", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] locNodCd = (JSPUtil.getParameter(request, prefix	+ "loc_nod_cd", length));
			String[] loclUpdDt = (JSPUtil.getParameter(request, prefix	+ "locl_upd_dt", length));
			String[] rcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_nm", length));
			String[] trspRateType40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_rate_type_40ft", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] trspAgmt40ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_40ft_mty_yd_cd", length));
			String[] costTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_nm", length));
			String[] mtyTrsp40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_sys_src_nm", length));
			String[] tml40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_ttl_cost_amt", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] mtyTrsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_adj_cost_amt", length));
			String[] tml20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_adj_cost_amt", length));
			String[] tml20ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_sys_src_nm", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_seq", length));
			String[] locGrpNo = (JSPUtil.getParameter(request, prefix	+ "loc_grp_no", length));
			String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_nm", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] inlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "inlnd_rout_cmb_flg", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] trspDiff40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_40ft", length));
			String[] tml40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_adj_cost_amt", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] inlnd40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_ttl_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] mtyTrsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_ttl_cost_amt", length));
			String[] tml40ftCostSysSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_sys_src_nm", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] trsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_ttl_cost_amt", length));
			String[] portNodCd = (JSPUtil.getParameter(request, prefix	+ "port_nod_cd", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] trsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_adj_cost_amt", length));
			String[] tml20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_ttl_cost_amt", length));
			String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_nm", length));
			String[] trspRateType20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_rate_type_20ft", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] agmtwgt20ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_20ft", length));
			String[] agmtwgt40ft = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt_40ft", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rf20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_ttl_cost_amt", length));
			String[] rf40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_ttl_cost_amt", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new AsiaInlnadCostInquiryVO();
				if (trsp40ftCostSysSrcNm[i] != null)
					model.setTrsp40ftCostSysSrcNm(trsp40ftCostSysSrcNm[i]);
				if (mtyTrsp20ftCostSysSrcNm[i] != null)
					model.setMtyTrsp20ftCostSysSrcNm(mtyTrsp20ftCostSysSrcNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (mtyTrsp20ftTtlCostAmt[i] != null)
					model.setMtyTrsp20ftTtlCostAmt(mtyTrsp20ftTtlCostAmt[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (trsp40ftTtlCostAmt[i] != null)
					model.setTrsp40ftTtlCostAmt(trsp40ftTtlCostAmt[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (costSelRoutFlg[i] != null)
					model.setCostSelRoutFlg(costSelRoutFlg[i]);
				if (n2ndVndrSeq[i] != null)
					model.setN2ndVndrSeq(n2ndVndrSeq[i]);
				if (inlnd20ftTtlAmt[i] != null)
					model.setInlnd20ftTtlAmt(inlnd20ftTtlAmt[i]);
				if (trsp20ftCostSysSrcNm[i] != null)
					model.setTrsp20ftCostSysSrcNm(trsp20ftCostSysSrcNm[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (trspAgmt20ftMtyYdCd[i] != null)
					model.setTrspAgmt20ftMtyYdCd(trspAgmt20ftMtyYdCd[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (trsp20ftAdjCostAmt[i] != null)
					model.setTrsp20ftAdjCostAmt(trsp20ftAdjCostAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (trspDiff20ft[i] != null)
					model.setTrspDiff20ft(trspDiff20ft[i]);
				if (portLoc[i] != null)
					model.setPortLoc(portLoc[i]);
				if (mtyTrsp40ftAdjCostAmt[i] != null)
					model.setMtyTrsp40ftAdjCostAmt(mtyTrsp40ftAdjCostAmt[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (locNodCd[i] != null)
					model.setLocNodCd(locNodCd[i]);
				if (loclUpdDt[i] != null)
					model.setLoclUpdDt(loclUpdDt[i]);
				if (rcvDeTermNm[i] != null)
					model.setRcvDeTermNm(rcvDeTermNm[i]);
				if (trspRateType40ft[i] != null)
					model.setTrspRateType40ft(trspRateType40ft[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (trspAgmt40ftMtyYdCd[i] != null)
					model.setTrspAgmt40ftMtyYdCd(trspAgmt40ftMtyYdCd[i]);
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
				if (tml20ftCostSysSrcNm[i] != null)
					model.setTml20ftCostSysSrcNm(tml20ftCostSysSrcNm[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (n1stVndrSeq[i] != null)
					model.setN1stVndrSeq(n1stVndrSeq[i]);
				if (locGrpNo[i] != null)
					model.setLocGrpNo(locGrpNo[i]);
				if (n1stVndrNm[i] != null)
					model.setN1stVndrNm(n1stVndrNm[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (inlndRoutCmbFlg[i] != null)
					model.setInlndRoutCmbFlg(inlndRoutCmbFlg[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (trspDiff40ft[i] != null)
					model.setTrspDiff40ft(trspDiff40ft[i]);
				if (tml40ftAdjCostAmt[i] != null)
					model.setTml40ftAdjCostAmt(tml40ftAdjCostAmt[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (inlnd40ftTtlAmt[i] != null)
					model.setInlnd40ftTtlAmt(inlnd40ftTtlAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (mtyTrsp40ftTtlCostAmt[i] != null)
					model.setMtyTrsp40ftTtlCostAmt(mtyTrsp40ftTtlCostAmt[i]);
				if (tml40ftCostSysSrcNm[i] != null)
					model.setTml40ftCostSysSrcNm(tml40ftCostSysSrcNm[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (trsp20ftTtlCostAmt[i] != null)
					model.setTrsp20ftTtlCostAmt(trsp20ftTtlCostAmt[i]);
				if (portNodCd[i] != null)
					model.setPortNodCd(portNodCd[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (trsp40ftAdjCostAmt[i] != null)
					model.setTrsp40ftAdjCostAmt(trsp40ftAdjCostAmt[i]);
				if (tml20ftTtlCostAmt[i] != null)
					model.setTml20ftTtlCostAmt(tml20ftTtlCostAmt[i]);
				if (n2ndVndrNm[i] != null)
					model.setN2ndVndrNm(n2ndVndrNm[i]);
				if (trspRateType20ft[i] != null)
					model.setTrspRateType20ft(trspRateType20ft[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				if (costTrfRoutSeq[i] != null)
					model.setCostTrfRoutSeq(costTrfRoutSeq[i]);
				if (agmtwgt20ft[i] != null)
					model.setAgmtwgt20ft(agmtwgt20ft[i]);
				if (agmtwgt40ft[i] != null)
					model.setAgmtwgt40ft(agmtwgt40ft[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rf20ftTtlCostAmt[i] != null)
					model.setRf20ftTtlCostAmt(rf20ftTtlCostAmt[i]);
				if (rf40ftTtlCostAmt[i] != null)
					model.setRf40ftTtlCostAmt(rf40ftTtlCostAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlnadCostInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AsiaInlnadCostInquiryVO[]
	 */
	public AsiaInlnadCostInquiryVO[] getInlnadCostInquiryVOs(){
		AsiaInlnadCostInquiryVO[] vos = (AsiaInlnadCostInquiryVO[])models.toArray(new AsiaInlnadCostInquiryVO[models.size()]);
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
		this.trsp40ftCostSysSrcNm = this.trsp40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostSysSrcNm = this.mtyTrsp20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftTtlCostAmt = this.mtyTrsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftTtlCostAmt = this.trsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSelRoutFlg = this.costSelRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrSeq = this.n2ndVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd20ftTtlAmt = this.inlnd20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostSysSrcNm = this.trsp20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt20ftMtyYdCd = this.trspAgmt20ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftAdjCostAmt = this.trsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff20ft = this.trspDiff20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLoc = this.portLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftAdjCostAmt = this.mtyTrsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNodCd = this.locNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt = this.loclUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermNm = this.rcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRateType40ft = this.trspRateType40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt40ftMtyYdCd = this.trspAgmt40ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsNm = this.costTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostSysSrcNm = this.mtyTrsp40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftTtlCostAmt = this.tml40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftAdjCostAmt = this.mtyTrsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftAdjCostAmt = this.tml20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSysSrcNm = this.tml20ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrSeq = this.n1stVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpNo = this.locGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrNm = this.n1stVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRoutCmbFlg = this.inlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff40ft = this.trspDiff40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftAdjCostAmt = this.tml40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftTtlAmt = this.inlnd40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftTtlCostAmt = this.mtyTrsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostSysSrcNm = this.tml40ftCostSysSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftTtlCostAmt = this.trsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNodCd = this.portNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftAdjCostAmt = this.trsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftTtlCostAmt = this.tml20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrNm = this.n2ndVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRateType20ft = this.trspRateType20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtwgt20ft = this.agmtwgt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtwgt40ft = this.agmtwgt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftTtlCostAmt = this.rf20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftTtlCostAmt = this.rf40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}