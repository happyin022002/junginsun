/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaInlandCostDetailVO.java
*@FileTitle : UsaInlandCostDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.04
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.04 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.usacostmgt.usainlandcostmanage.vo;

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
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaInlandCostDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaInlandCostDetailVO> models = new ArrayList<UsaInlandCostDetailVO>();
	
	/* Column Info */
	private String dmst40ftCostAmt = null;
	/* Column Info */
	private String rail20ftFuelScgTtlAmt = null;
	/* Column Info */
	private String costRoutGrpNo = null;
	/* Column Info */
	private String trk20ftFuelScgTtlAmt = null;
	/* Column Info */
	private String rail40ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String trk40ftBzcCostAmt = null;
	/* Column Info */
	private String rail20ftBzcCostAmt = null;
	/* Column Info */
	private String rail40ftBzcCostAmt = null;
	/* Column Info */
	private String n1stInlndRoutCmbFlg = null;
	/* Column Info */
	private String costTrfRoutSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trk20ftBzcCostAdjAmt = null;
	/* Column Info */
	private String rail40ftFuelScgSrcNm = null;
	/* Column Info */
	private String tollFeeAmt40 = null;
	/* Column Info */
	private String trk20ftBzcCostTtlAmt = null;
	/* Column Info */
	private String rail40ftBzcAgmtWgt = null;
	/* Column Info */
	private String trk40ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String rail20ftFuelScgSrcNm = null;
	/* Column Info */
	private String rail40ftFuelScgTtlAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String rail20ftFuelScgAmt = null;
	/* Column Info */
	private String trk20ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String costSelRoutFlg = null;
	/* Column Info */
	private String n2ndVndrSeq = null;
	/* Column Info */
	private String rail20ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String trk20ftBzcCostSrcNm = null;
	/* Column Info */
	private String inlnd20ftTtlAmt = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String trspAgmt20ftMtyYdCd = null;
	/* Column Info */
	private String trk20ftFuelScgAmt = null;
	/* Column Info */
	private String rail40ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String trk20ftBzcAgmtWgt = null;
	/* Column Info */
	private String trk40ftBzcCostTtlAmt = null;
	/* Column Info */
	private String rail20ftBzcCostSrcNm = null;
	/* Column Info */
	private String trk20ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String tml40ftCostSrcNm = null;
	/* Column Info */
	private String rail20ftBzcCostAdjAmt = null;
	/* Column Info */
	private String trspDiff20ft = null;
	/* Column Info */
	private String portLoc = null;
	/* Column Info */
	private String trk20ftFuelScgSrcNm = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String locNodCd = null;
	/* Column Info */
	private String tml20ftCostSrcNm = null;
	/* Column Info */
	private String rowNum = null;
	/* Column Info */
	private String trk40ftFuelScgAdjAmt = null;
	/* Column Info */
	private String rail20ftFuelScgAdjAmt = null;
	/* Column Info */
	private String rcvDeTermNm = null;
	/* Column Info */
	private String rail20ftBzcCostTtlAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String trspAgmt40ftMtyYdCd = null;
	/* Column Info */
	private String rfCnt = null;
	/* Column Info */
	private String trk20ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String mtyTrsp20ftCostAmt = null;
	/* Column Info */
	private String trk20ftFuelScgAdjAmt = null;
	/* Column Info */
	private String trk40ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String trk40ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String rail20ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* Column Info */
	private String costRoutGrpNoRnk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trk40ftBzcCostSrcNm = null;
	/* Column Info */
	private String rail40ftBzcCostAdjAmt = null;
	/* Column Info */
	private String trk40ftFuelScgSrcNm = null;
	/* Column Info */
	private String n1stVndrSeq = null;
	/* Column Info */
	private String mtyPkupRtnYdCd = null;
	/* Column Info */
	private String n1stVndrNm = null;
	/* Column Info */
	private String rail40ftFuelScgAmt = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String tollFeeAmt20 = null;
	/* Column Info */
	private String trk40ftFuelScgTtlAmt = null;
	/* Column Info */
	private String n3rdVndrSeq = null;
	/* Column Info */
	private String trk20ftBzcCostAmt = null;
	/* Column Info */
	private String trspDiff40ft = null;
	/* Column Info */
	private String rail40ftBzcCostSrcNm = null;
	/* Column Info */
	private String n3rdVndrNm = null;
	/* Column Info */
	private String inlnd40ftTtlAmt = null;
	/* Column Info */
	private String dmst20ftCostAmt = null;
	/* Column Info */
	private String n2ndInlndRoutCmbFlg = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String rail40ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String rail20ftBzcAgmtWgt = null;
	/* Column Info */
	private String trk40ftBzcCostAdjAmt = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String trk40ftBzcAgmtWgt = null;
	/* Column Info */
	private String trk40ftFuelScgAmt = null;
	/* Column Info */
	private String rail40ftFuelScgAdjAmt = null;
	/* Column Info */
	private String portNodCd = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String rail20ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String n2ndVndrNm = null;
	/* Column Info */
	private String agmtOldFlg = null;
	/* Column Info */
	private String rail40ftBzcCostTtlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaInlandCostDetailVO() {}

	public UsaInlandCostDetailVO(String ibflag, String pagerows, String dmst40ftCostAmt, String rail20ftFuelScgTtlAmt, String costRoutGrpNo, String trk20ftFuelScgTtlAmt, String rail40ftBzcAgmtWyTpCd, String trk40ftBzcCostAmt, String rail20ftBzcCostAmt, String rail40ftBzcCostAmt, String n1stInlndRoutCmbFlg, String costTrfRoutSeq, String rail40ftFuelScgSrcNm, String trk20ftBzcCostAdjAmt, String trk40ftBzcAgmtWyTpCd, String rail40ftBzcAgmtWgt, String trk20ftBzcCostTtlAmt, String rail20ftFuelScgSrcNm, String rail40ftFuelScgTtlAmt, String rcvDeTermCd, String rail20ftFuelScgAmt, String tollFeeAmt20, String tollFeeAmt40, String trk20ftFuelScgAgmtWgt, String updUsrId, String mtyTrsp40ftCostAmt, String costSelRoutFlg, String n2ndVndrSeq, String rail20ftBzcAgmtWyTpCd, String trk20ftBzcCostSrcNm, String inlnd20ftTtlAmt, String costTrfNo, String trspAgmt20ftMtyYdCd, String trk20ftFuelScgAmt, String rail40ftFuelScgAgmtWgt, String trk20ftBzcAgmtWgt, String trk40ftBzcCostTtlAmt, String rail20ftBzcCostSrcNm, String trk20ftBzcAgmtWyTpCd, String tml40ftCostSrcNm, String rail20ftBzcCostAdjAmt, String trspDiff20ft, String portLoc, String trk20ftFuelScgSrcNm, String tml40ftCostAmt, String locNodCd, String tml20ftCostSrcNm, String rowNum, String trk40ftFuelScgAdjAmt, String rcvDeTermNm, String rail20ftFuelScgAdjAmt, String rail20ftBzcCostTtlAmt, String trspAgmt40ftMtyYdCd, String mb20ftRto, String currCd, String rfCnt, String trk20ftFuelAgmtWyTpCd, String mtyTrsp20ftCostAmt, String trk20ftFuelScgAdjAmt, String trk40ftFuelScgAgmtWgt, String trk40ftFuelAgmtWyTpCd, String rail20ftFuelScgAgmtWgt, String mb40ftRto, String costRoutGrpNoRnk, String trk40ftBzcCostSrcNm, String n1stVndrSeq, String trk40ftFuelScgSrcNm, String rail40ftBzcCostAdjAmt, String n1stVndrNm, String mtyPkupRtnYdCd, String rail40ftFuelScgAmt, String trspCrrModCd, String n3rdVndrSeq, String trk40ftFuelScgTtlAmt, String trk20ftBzcCostAmt, String trspDiff40ft, String rail40ftBzcCostSrcNm, String n3rdVndrNm, String n2ndInlndRoutCmbFlg, String dmst20ftCostAmt, String inlnd40ftTtlAmt, String hubNodCd, String trk40ftBzcCostAdjAmt, String rail20ftBzcAgmtWgt, String rail40ftFuelAgmtWyTpCd, String trk40ftFuelScgAmt, String trk40ftBzcAgmtWgt, String sccCd, String rail40ftFuelScgAdjAmt, String tml20ftCostAmt, String portNodCd, String rail20ftFuelAgmtWyTpCd, String agmtOldFlg, String n2ndVndrNm, String rail40ftBzcCostTtlAmt) {
		this.dmst40ftCostAmt = dmst40ftCostAmt;
		this.rail20ftFuelScgTtlAmt = rail20ftFuelScgTtlAmt;
		this.costRoutGrpNo = costRoutGrpNo;
		this.trk20ftFuelScgTtlAmt = trk20ftFuelScgTtlAmt;
		this.rail40ftBzcAgmtWyTpCd = rail40ftBzcAgmtWyTpCd;
		this.trk40ftBzcCostAmt = trk40ftBzcCostAmt;
		this.rail20ftBzcCostAmt = rail20ftBzcCostAmt;
		this.rail40ftBzcCostAmt = rail40ftBzcCostAmt;
		this.n1stInlndRoutCmbFlg = n1stInlndRoutCmbFlg;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.pagerows = pagerows;
		this.trk20ftBzcCostAdjAmt = trk20ftBzcCostAdjAmt;
		this.rail40ftFuelScgSrcNm = rail40ftFuelScgSrcNm;
		this.tollFeeAmt40 = tollFeeAmt40;
		this.trk20ftBzcCostTtlAmt = trk20ftBzcCostTtlAmt;
		this.rail40ftBzcAgmtWgt = rail40ftBzcAgmtWgt;
		this.trk40ftBzcAgmtWyTpCd = trk40ftBzcAgmtWyTpCd;
		this.rail20ftFuelScgSrcNm = rail20ftFuelScgSrcNm;
		this.rail40ftFuelScgTtlAmt = rail40ftFuelScgTtlAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.rail20ftFuelScgAmt = rail20ftFuelScgAmt;
		this.trk20ftFuelScgAgmtWgt = trk20ftFuelScgAgmtWgt;
		this.updUsrId = updUsrId;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.costSelRoutFlg = costSelRoutFlg;
		this.n2ndVndrSeq = n2ndVndrSeq;
		this.rail20ftBzcAgmtWyTpCd = rail20ftBzcAgmtWyTpCd;
		this.trk20ftBzcCostSrcNm = trk20ftBzcCostSrcNm;
		this.inlnd20ftTtlAmt = inlnd20ftTtlAmt;
		this.costTrfNo = costTrfNo;
		this.trspAgmt20ftMtyYdCd = trspAgmt20ftMtyYdCd;
		this.trk20ftFuelScgAmt = trk20ftFuelScgAmt;
		this.rail40ftFuelScgAgmtWgt = rail40ftFuelScgAgmtWgt;
		this.trk20ftBzcAgmtWgt = trk20ftBzcAgmtWgt;
		this.trk40ftBzcCostTtlAmt = trk40ftBzcCostTtlAmt;
		this.rail20ftBzcCostSrcNm = rail20ftBzcCostSrcNm;
		this.trk20ftBzcAgmtWyTpCd = trk20ftBzcAgmtWyTpCd;
		this.tml40ftCostSrcNm = tml40ftCostSrcNm;
		this.rail20ftBzcCostAdjAmt = rail20ftBzcCostAdjAmt;
		this.trspDiff20ft = trspDiff20ft;
		this.portLoc = portLoc;
		this.trk20ftFuelScgSrcNm = trk20ftFuelScgSrcNm;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.locNodCd = locNodCd;
		this.tml20ftCostSrcNm = tml20ftCostSrcNm;
		this.rowNum = rowNum;
		this.trk40ftFuelScgAdjAmt = trk40ftFuelScgAdjAmt;
		this.rail20ftFuelScgAdjAmt = rail20ftFuelScgAdjAmt;
		this.rcvDeTermNm = rcvDeTermNm;
		this.rail20ftBzcCostTtlAmt = rail20ftBzcCostTtlAmt;
		this.currCd = currCd;
		this.mb20ftRto = mb20ftRto;
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
		this.rfCnt = rfCnt;
		this.trk20ftFuelAgmtWyTpCd = trk20ftFuelAgmtWyTpCd;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.trk20ftFuelScgAdjAmt = trk20ftFuelScgAdjAmt;
		this.trk40ftFuelScgAgmtWgt = trk40ftFuelScgAgmtWgt;
		this.trk40ftFuelAgmtWyTpCd = trk40ftFuelAgmtWyTpCd;
		this.rail20ftFuelScgAgmtWgt = rail20ftFuelScgAgmtWgt;
		this.mb40ftRto = mb40ftRto;
		this.costRoutGrpNoRnk = costRoutGrpNoRnk;
		this.ibflag = ibflag;
		this.trk40ftBzcCostSrcNm = trk40ftBzcCostSrcNm;
		this.rail40ftBzcCostAdjAmt = rail40ftBzcCostAdjAmt;
		this.trk40ftFuelScgSrcNm = trk40ftFuelScgSrcNm;
		this.n1stVndrSeq = n1stVndrSeq;
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
		this.n1stVndrNm = n1stVndrNm;
		this.rail40ftFuelScgAmt = rail40ftFuelScgAmt;
		this.trspCrrModCd = trspCrrModCd;
		this.tollFeeAmt20 = tollFeeAmt20;
		this.trk40ftFuelScgTtlAmt = trk40ftFuelScgTtlAmt;
		this.n3rdVndrSeq = n3rdVndrSeq;
		this.trk20ftBzcCostAmt = trk20ftBzcCostAmt;
		this.trspDiff40ft = trspDiff40ft;
		this.rail40ftBzcCostSrcNm = rail40ftBzcCostSrcNm;
		this.n3rdVndrNm = n3rdVndrNm;
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
		this.dmst20ftCostAmt = dmst20ftCostAmt;
		this.n2ndInlndRoutCmbFlg = n2ndInlndRoutCmbFlg;
		this.hubNodCd = hubNodCd;
		this.rail40ftFuelAgmtWyTpCd = rail40ftFuelAgmtWyTpCd;
		this.rail20ftBzcAgmtWgt = rail20ftBzcAgmtWgt;
		this.trk40ftBzcCostAdjAmt = trk40ftBzcCostAdjAmt;
		this.sccCd = sccCd;
		this.trk40ftBzcAgmtWgt = trk40ftBzcAgmtWgt;
		this.trk40ftFuelScgAmt = trk40ftFuelScgAmt;
		this.rail40ftFuelScgAdjAmt = rail40ftFuelScgAdjAmt;
		this.portNodCd = portNodCd;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.rail20ftFuelAgmtWyTpCd = rail20ftFuelAgmtWyTpCd;
		this.n2ndVndrNm = n2ndVndrNm;
		this.agmtOldFlg = agmtOldFlg;
		this.rail40ftBzcCostTtlAmt = rail40ftBzcCostTtlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmst_40ft_cost_amt", getDmst40ftCostAmt());
		this.hashColumns.put("rail_20ft_fuel_scg_ttl_amt", getRail20ftFuelScgTtlAmt());
		this.hashColumns.put("cost_rout_grp_no", getCostRoutGrpNo());
		this.hashColumns.put("trk_20ft_fuel_scg_ttl_amt", getTrk20ftFuelScgTtlAmt());
		this.hashColumns.put("rail_40ft_bzc_agmt_wy_tp_cd", getRail40ftBzcAgmtWyTpCd());
		this.hashColumns.put("trk_40ft_bzc_cost_amt", getTrk40ftBzcCostAmt());
		this.hashColumns.put("rail_20ft_bzc_cost_amt", getRail20ftBzcCostAmt());
		this.hashColumns.put("rail_40ft_bzc_cost_amt", getRail40ftBzcCostAmt());
		this.hashColumns.put("n1st_inlnd_rout_cmb_flg", getN1stInlndRoutCmbFlg());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trk_20ft_bzc_cost_adj_amt", getTrk20ftBzcCostAdjAmt());
		this.hashColumns.put("rail_40ft_fuel_scg_src_nm", getRail40ftFuelScgSrcNm());
		this.hashColumns.put("toll_fee_amt_40", getTollFeeAmt40());
		this.hashColumns.put("trk_20ft_bzc_cost_ttl_amt", getTrk20ftBzcCostTtlAmt());
		this.hashColumns.put("rail_40ft_bzc_agmt_wgt", getRail40ftBzcAgmtWgt());
		this.hashColumns.put("trk_40ft_bzc_agmt_wy_tp_cd", getTrk40ftBzcAgmtWyTpCd());
		this.hashColumns.put("rail_20ft_fuel_scg_src_nm", getRail20ftFuelScgSrcNm());
		this.hashColumns.put("rail_40ft_fuel_scg_ttl_amt", getRail40ftFuelScgTtlAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("rail_20ft_fuel_scg_amt", getRail20ftFuelScgAmt());
		this.hashColumns.put("trk_20ft_fuel_scg_agmt_wgt", getTrk20ftFuelScgAgmtWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("cost_sel_rout_flg", getCostSelRoutFlg());
		this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
		this.hashColumns.put("rail_20ft_bzc_agmt_wy_tp_cd", getRail20ftBzcAgmtWyTpCd());
		this.hashColumns.put("trk_20ft_bzc_cost_src_nm", getTrk20ftBzcCostSrcNm());
		this.hashColumns.put("inlnd_20ft_ttl_amt", getInlnd20ftTtlAmt());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("trsp_agmt_20ft_mty_yd_cd", getTrspAgmt20ftMtyYdCd());
		this.hashColumns.put("trk_20ft_fuel_scg_amt", getTrk20ftFuelScgAmt());
		this.hashColumns.put("rail_40ft_fuel_scg_agmt_wgt", getRail40ftFuelScgAgmtWgt());
		this.hashColumns.put("trk_20ft_bzc_agmt_wgt", getTrk20ftBzcAgmtWgt());
		this.hashColumns.put("trk_40ft_bzc_cost_ttl_amt", getTrk40ftBzcCostTtlAmt());
		this.hashColumns.put("rail_20ft_bzc_cost_src_nm", getRail20ftBzcCostSrcNm());
		this.hashColumns.put("trk_20ft_bzc_agmt_wy_tp_cd", getTrk20ftBzcAgmtWyTpCd());
		this.hashColumns.put("tml_40ft_cost_src_nm", getTml40ftCostSrcNm());
		this.hashColumns.put("rail_20ft_bzc_cost_adj_amt", getRail20ftBzcCostAdjAmt());
		this.hashColumns.put("trsp_diff_20ft", getTrspDiff20ft());
		this.hashColumns.put("port_loc", getPortLoc());
		this.hashColumns.put("trk_20ft_fuel_scg_src_nm", getTrk20ftFuelScgSrcNm());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("loc_nod_cd", getLocNodCd());
		this.hashColumns.put("tml_20ft_cost_src_nm", getTml20ftCostSrcNm());
		this.hashColumns.put("row_num", getRowNum());
		this.hashColumns.put("trk_40ft_fuel_scg_adj_amt", getTrk40ftFuelScgAdjAmt());
		this.hashColumns.put("rail_20ft_fuel_scg_adj_amt", getRail20ftFuelScgAdjAmt());
		this.hashColumns.put("rcv_de_term_nm", getRcvDeTermNm());
		this.hashColumns.put("rail_20ft_bzc_cost_ttl_amt", getRail20ftBzcCostTtlAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("trsp_agmt_40ft_mty_yd_cd", getTrspAgmt40ftMtyYdCd());
		this.hashColumns.put("rf_cnt", getRfCnt());
		this.hashColumns.put("trk_20ft_fuel_agmt_wy_tp_cd", getTrk20ftFuelAgmtWyTpCd());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("trk_20ft_fuel_scg_adj_amt", getTrk20ftFuelScgAdjAmt());
		this.hashColumns.put("trk_40ft_fuel_scg_agmt_wgt", getTrk40ftFuelScgAgmtWgt());
		this.hashColumns.put("trk_40ft_fuel_agmt_wy_tp_cd", getTrk40ftFuelAgmtWyTpCd());
		this.hashColumns.put("rail_20ft_fuel_scg_agmt_wgt", getRail20ftFuelScgAgmtWgt());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("cost_rout_grp_no_rnk", getCostRoutGrpNoRnk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trk_40ft_bzc_cost_src_nm", getTrk40ftBzcCostSrcNm());
		this.hashColumns.put("rail_40ft_bzc_cost_adj_amt", getRail40ftBzcCostAdjAmt());
		this.hashColumns.put("trk_40ft_fuel_scg_src_nm", getTrk40ftFuelScgSrcNm());
		this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
		this.hashColumns.put("mty_pkup_rtn_yd_cd", getMtyPkupRtnYdCd());
		this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
		this.hashColumns.put("rail_40ft_fuel_scg_amt", getRail40ftFuelScgAmt());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("toll_fee_amt_20", getTollFeeAmt20());
		this.hashColumns.put("trk_40ft_fuel_scg_ttl_amt", getTrk40ftFuelScgTtlAmt());
		this.hashColumns.put("n3rd_vndr_seq", getN3rdVndrSeq());
		this.hashColumns.put("trk_20ft_bzc_cost_amt", getTrk20ftBzcCostAmt());
		this.hashColumns.put("trsp_diff_40ft", getTrspDiff40ft());
		this.hashColumns.put("rail_40ft_bzc_cost_src_nm", getRail40ftBzcCostSrcNm());
		this.hashColumns.put("n3rd_vndr_nm", getN3rdVndrNm());
		this.hashColumns.put("inlnd_40ft_ttl_amt", getInlnd40ftTtlAmt());
		this.hashColumns.put("dmst_20ft_cost_amt", getDmst20ftCostAmt());
		this.hashColumns.put("n2nd_inlnd_rout_cmb_flg", getN2ndInlndRoutCmbFlg());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("rail_40ft_fuel_agmt_wy_tp_cd", getRail40ftFuelAgmtWyTpCd());
		this.hashColumns.put("rail_20ft_bzc_agmt_wgt", getRail20ftBzcAgmtWgt());
		this.hashColumns.put("trk_40ft_bzc_cost_adj_amt", getTrk40ftBzcCostAdjAmt());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("trk_40ft_bzc_agmt_wgt", getTrk40ftBzcAgmtWgt());
		this.hashColumns.put("trk_40ft_fuel_scg_amt", getTrk40ftFuelScgAmt());
		this.hashColumns.put("rail_40ft_fuel_scg_adj_amt", getRail40ftFuelScgAdjAmt());
		this.hashColumns.put("port_nod_cd", getPortNodCd());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("rail_20ft_fuel_agmt_wy_tp_cd", getRail20ftFuelAgmtWyTpCd());
		this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		this.hashColumns.put("rail_40ft_bzc_cost_ttl_amt", getRail40ftBzcCostTtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmst_40ft_cost_amt", "dmst40ftCostAmt");
		this.hashFields.put("rail_20ft_fuel_scg_ttl_amt", "rail20ftFuelScgTtlAmt");
		this.hashFields.put("cost_rout_grp_no", "costRoutGrpNo");
		this.hashFields.put("trk_20ft_fuel_scg_ttl_amt", "trk20ftFuelScgTtlAmt");
		this.hashFields.put("rail_40ft_bzc_agmt_wy_tp_cd", "rail40ftBzcAgmtWyTpCd");
		this.hashFields.put("trk_40ft_bzc_cost_amt", "trk40ftBzcCostAmt");
		this.hashFields.put("rail_20ft_bzc_cost_amt", "rail20ftBzcCostAmt");
		this.hashFields.put("rail_40ft_bzc_cost_amt", "rail40ftBzcCostAmt");
		this.hashFields.put("n1st_inlnd_rout_cmb_flg", "n1stInlndRoutCmbFlg");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trk_20ft_bzc_cost_adj_amt", "trk20ftBzcCostAdjAmt");
		this.hashFields.put("rail_40ft_fuel_scg_src_nm", "rail40ftFuelScgSrcNm");
		this.hashFields.put("toll_fee_amt_40", "tollFeeAmt40");
		this.hashFields.put("trk_20ft_bzc_cost_ttl_amt", "trk20ftBzcCostTtlAmt");
		this.hashFields.put("rail_40ft_bzc_agmt_wgt", "rail40ftBzcAgmtWgt");
		this.hashFields.put("trk_40ft_bzc_agmt_wy_tp_cd", "trk40ftBzcAgmtWyTpCd");
		this.hashFields.put("rail_20ft_fuel_scg_src_nm", "rail20ftFuelScgSrcNm");
		this.hashFields.put("rail_40ft_fuel_scg_ttl_amt", "rail40ftFuelScgTtlAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("rail_20ft_fuel_scg_amt", "rail20ftFuelScgAmt");
		this.hashFields.put("trk_20ft_fuel_scg_agmt_wgt", "trk20ftFuelScgAgmtWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("cost_sel_rout_flg", "costSelRoutFlg");
		this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
		this.hashFields.put("rail_20ft_bzc_agmt_wy_tp_cd", "rail20ftBzcAgmtWyTpCd");
		this.hashFields.put("trk_20ft_bzc_cost_src_nm", "trk20ftBzcCostSrcNm");
		this.hashFields.put("inlnd_20ft_ttl_amt", "inlnd20ftTtlAmt");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("trsp_agmt_20ft_mty_yd_cd", "trspAgmt20ftMtyYdCd");
		this.hashFields.put("trk_20ft_fuel_scg_amt", "trk20ftFuelScgAmt");
		this.hashFields.put("rail_40ft_fuel_scg_agmt_wgt", "rail40ftFuelScgAgmtWgt");
		this.hashFields.put("trk_20ft_bzc_agmt_wgt", "trk20ftBzcAgmtWgt");
		this.hashFields.put("trk_40ft_bzc_cost_ttl_amt", "trk40ftBzcCostTtlAmt");
		this.hashFields.put("rail_20ft_bzc_cost_src_nm", "rail20ftBzcCostSrcNm");
		this.hashFields.put("trk_20ft_bzc_agmt_wy_tp_cd", "trk20ftBzcAgmtWyTpCd");
		this.hashFields.put("tml_40ft_cost_src_nm", "tml40ftCostSrcNm");
		this.hashFields.put("rail_20ft_bzc_cost_adj_amt", "rail20ftBzcCostAdjAmt");
		this.hashFields.put("trsp_diff_20ft", "trspDiff20ft");
		this.hashFields.put("port_loc", "portLoc");
		this.hashFields.put("trk_20ft_fuel_scg_src_nm", "trk20ftFuelScgSrcNm");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("loc_nod_cd", "locNodCd");
		this.hashFields.put("tml_20ft_cost_src_nm", "tml20ftCostSrcNm");
		this.hashFields.put("row_num", "rowNum");
		this.hashFields.put("trk_40ft_fuel_scg_adj_amt", "trk40ftFuelScgAdjAmt");
		this.hashFields.put("rail_20ft_fuel_scg_adj_amt", "rail20ftFuelScgAdjAmt");
		this.hashFields.put("rcv_de_term_nm", "rcvDeTermNm");
		this.hashFields.put("rail_20ft_bzc_cost_ttl_amt", "rail20ftBzcCostTtlAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("trsp_agmt_40ft_mty_yd_cd", "trspAgmt40ftMtyYdCd");
		this.hashFields.put("rf_cnt", "rfCnt");
		this.hashFields.put("trk_20ft_fuel_agmt_wy_tp_cd", "trk20ftFuelAgmtWyTpCd");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("trk_20ft_fuel_scg_adj_amt", "trk20ftFuelScgAdjAmt");
		this.hashFields.put("trk_40ft_fuel_scg_agmt_wgt", "trk40ftFuelScgAgmtWgt");
		this.hashFields.put("trk_40ft_fuel_agmt_wy_tp_cd", "trk40ftFuelAgmtWyTpCd");
		this.hashFields.put("rail_20ft_fuel_scg_agmt_wgt", "rail20ftFuelScgAgmtWgt");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("cost_rout_grp_no_rnk", "costRoutGrpNoRnk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trk_40ft_bzc_cost_src_nm", "trk40ftBzcCostSrcNm");
		this.hashFields.put("rail_40ft_bzc_cost_adj_amt", "rail40ftBzcCostAdjAmt");
		this.hashFields.put("trk_40ft_fuel_scg_src_nm", "trk40ftFuelScgSrcNm");
		this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
		this.hashFields.put("mty_pkup_rtn_yd_cd", "mtyPkupRtnYdCd");
		this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
		this.hashFields.put("rail_40ft_fuel_scg_amt", "rail40ftFuelScgAmt");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("toll_fee_amt_20", "tollFeeAmt20");
		this.hashFields.put("trk_40ft_fuel_scg_ttl_amt", "trk40ftFuelScgTtlAmt");
		this.hashFields.put("n3rd_vndr_seq", "n3rdVndrSeq");
		this.hashFields.put("trk_20ft_bzc_cost_amt", "trk20ftBzcCostAmt");
		this.hashFields.put("trsp_diff_40ft", "trspDiff40ft");
		this.hashFields.put("rail_40ft_bzc_cost_src_nm", "rail40ftBzcCostSrcNm");
		this.hashFields.put("n3rd_vndr_nm", "n3rdVndrNm");
		this.hashFields.put("inlnd_40ft_ttl_amt", "inlnd40ftTtlAmt");
		this.hashFields.put("dmst_20ft_cost_amt", "dmst20ftCostAmt");
		this.hashFields.put("n2nd_inlnd_rout_cmb_flg", "n2ndInlndRoutCmbFlg");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("rail_40ft_fuel_agmt_wy_tp_cd", "rail40ftFuelAgmtWyTpCd");
		this.hashFields.put("rail_20ft_bzc_agmt_wgt", "rail20ftBzcAgmtWgt");
		this.hashFields.put("trk_40ft_bzc_cost_adj_amt", "trk40ftBzcCostAdjAmt");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("trk_40ft_bzc_agmt_wgt", "trk40ftBzcAgmtWgt");
		this.hashFields.put("trk_40ft_fuel_scg_amt", "trk40ftFuelScgAmt");
		this.hashFields.put("rail_40ft_fuel_scg_adj_amt", "rail40ftFuelScgAdjAmt");
		this.hashFields.put("port_nod_cd", "portNodCd");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("rail_20ft_fuel_agmt_wy_tp_cd", "rail20ftFuelAgmtWyTpCd");
		this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
		this.hashFields.put("rail_40ft_bzc_cost_ttl_amt", "rail40ftBzcCostTtlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmst40ftCostAmt
	 */
	public String getDmst40ftCostAmt() {
		return this.dmst40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rail20ftFuelScgTtlAmt
	 */
	public String getRail20ftFuelScgTtlAmt() {
		return this.rail20ftFuelScgTtlAmt;
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
	 * @return trk20ftFuelScgTtlAmt
	 */
	public String getTrk20ftFuelScgTtlAmt() {
		return this.trk20ftFuelScgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return rail40ftBzcAgmtWyTpCd
	 */
	public String getRail40ftBzcAgmtWyTpCd() {
		return this.rail40ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @return trk40ftBzcCostAmt
	 */
	public String getTrk40ftBzcCostAmt() {
		return this.trk40ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rail20ftBzcCostAmt
	 */
	public String getRail20ftBzcCostAmt() {
		return this.rail20ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rail40ftBzcCostAmt
	 */
	public String getRail40ftBzcCostAmt() {
		return this.rail40ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stInlndRoutCmbFlg
	 */
	public String getN1stInlndRoutCmbFlg() {
		return this.n1stInlndRoutCmbFlg;
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
	 * @return trk20ftBzcCostAdjAmt
	 */
	public String getTrk20ftBzcCostAdjAmt() {
		return this.trk20ftBzcCostAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return rail40ftFuelScgSrcNm
	 */
	public String getRail40ftFuelScgSrcNm() {
		return this.rail40ftFuelScgSrcNm;
	}
	
	/**
	 * Column Info
	 * @return tollFeeAmt40
	 */
	public String getTollFeeAmt40() {
		return this.tollFeeAmt40;
	}
	
	/**
	 * Column Info
	 * @return trk20ftBzcCostTtlAmt
	 */
	public String getTrk20ftBzcCostTtlAmt() {
		return this.trk20ftBzcCostTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return rail40ftBzcAgmtWgt
	 */
	public String getRail40ftBzcAgmtWgt() {
		return this.rail40ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return trk40ftBzcAgmtWyTpCd
	 */
	public String getTrk40ftBzcAgmtWyTpCd() {
		return this.trk40ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @return rail20ftFuelScgSrcNm
	 */
	public String getRail20ftFuelScgSrcNm() {
		return this.rail20ftFuelScgSrcNm;
	}
	
	/**
	 * Column Info
	 * @return rail40ftFuelScgTtlAmt
	 */
	public String getRail40ftFuelScgTtlAmt() {
		return this.rail40ftFuelScgTtlAmt;
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
	 * @return rail20ftFuelScgAmt
	 */
	public String getRail20ftFuelScgAmt() {
		return this.rail20ftFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return trk20ftFuelScgAgmtWgt
	 */
	public String getTrk20ftFuelScgAgmtWgt() {
		return this.trk20ftFuelScgAgmtWgt;
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
	 * @return n2ndVndrSeq
	 */
	public String getN2ndVndrSeq() {
		return this.n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return rail20ftBzcAgmtWyTpCd
	 */
	public String getRail20ftBzcAgmtWyTpCd() {
		return this.rail20ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @return trk20ftBzcCostSrcNm
	 */
	public String getTrk20ftBzcCostSrcNm() {
		return this.trk20ftBzcCostSrcNm;
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
	 * @return trspAgmt20ftMtyYdCd
	 */
	public String getTrspAgmt20ftMtyYdCd() {
		return this.trspAgmt20ftMtyYdCd;
	}
	
	/**
	 * Column Info
	 * @return trk20ftFuelScgAmt
	 */
	public String getTrk20ftFuelScgAmt() {
		return this.trk20ftFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return rail40ftFuelScgAgmtWgt
	 */
	public String getRail40ftFuelScgAgmtWgt() {
		return this.rail40ftFuelScgAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return trk20ftBzcAgmtWgt
	 */
	public String getTrk20ftBzcAgmtWgt() {
		return this.trk20ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return trk40ftBzcCostTtlAmt
	 */
	public String getTrk40ftBzcCostTtlAmt() {
		return this.trk40ftBzcCostTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return rail20ftBzcCostSrcNm
	 */
	public String getRail20ftBzcCostSrcNm() {
		return this.rail20ftBzcCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @return trk20ftBzcAgmtWyTpCd
	 */
	public String getTrk20ftBzcAgmtWyTpCd() {
		return this.trk20ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @return tml40ftCostSrcNm
	 */
	public String getTml40ftCostSrcNm() {
		return this.tml40ftCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @return rail20ftBzcCostAdjAmt
	 */
	public String getRail20ftBzcCostAdjAmt() {
		return this.rail20ftBzcCostAdjAmt;
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
	 * @return trk20ftFuelScgSrcNm
	 */
	public String getTrk20ftFuelScgSrcNm() {
		return this.trk20ftFuelScgSrcNm;
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
	 * @return tml20ftCostSrcNm
	 */
	public String getTml20ftCostSrcNm() {
		return this.tml20ftCostSrcNm;
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
	 * @return trk40ftFuelScgAdjAmt
	 */
	public String getTrk40ftFuelScgAdjAmt() {
		return this.trk40ftFuelScgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return rail20ftFuelScgAdjAmt
	 */
	public String getRail20ftFuelScgAdjAmt() {
		return this.rail20ftFuelScgAdjAmt;
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
	 * @return rail20ftBzcCostTtlAmt
	 */
	public String getRail20ftBzcCostTtlAmt() {
		return this.rail20ftBzcCostTtlAmt;
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
	 * @return rfCnt
	 */
	public String getRfCnt() {
		return this.rfCnt;
	}
	
	/**
	 * Column Info
	 * @return trk20ftFuelAgmtWyTpCd
	 */
	public String getTrk20ftFuelAgmtWyTpCd() {
		return this.trk20ftFuelAgmtWyTpCd;
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
	 * @return trk20ftFuelScgAdjAmt
	 */
	public String getTrk20ftFuelScgAdjAmt() {
		return this.trk20ftFuelScgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return trk40ftFuelScgAgmtWgt
	 */
	public String getTrk40ftFuelScgAgmtWgt() {
		return this.trk40ftFuelScgAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return trk40ftFuelAgmtWyTpCd
	 */
	public String getTrk40ftFuelAgmtWyTpCd() {
		return this.trk40ftFuelAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @return rail20ftFuelScgAgmtWgt
	 */
	public String getRail20ftFuelScgAgmtWgt() {
		return this.rail20ftFuelScgAgmtWgt;
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
	 * @return trk40ftBzcCostSrcNm
	 */
	public String getTrk40ftBzcCostSrcNm() {
		return this.trk40ftBzcCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @return rail40ftBzcCostAdjAmt
	 */
	public String getRail40ftBzcCostAdjAmt() {
		return this.rail40ftBzcCostAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return trk40ftFuelScgSrcNm
	 */
	public String getTrk40ftFuelScgSrcNm() {
		return this.trk40ftFuelScgSrcNm;
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
	 * @return mtyPkupRtnYdCd
	 */
	public String getMtyPkupRtnYdCd() {
		return this.mtyPkupRtnYdCd;
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
	 * @return rail40ftFuelScgAmt
	 */
	public String getRail40ftFuelScgAmt() {
		return this.rail40ftFuelScgAmt;
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
	 * @return tollFeeAmt20
	 */
	public String getTollFeeAmt20() {
		return this.tollFeeAmt20;
	}
	
	/**
	 * Column Info
	 * @return trk40ftFuelScgTtlAmt
	 */
	public String getTrk40ftFuelScgTtlAmt() {
		return this.trk40ftFuelScgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return n3rdVndrSeq
	 */
	public String getN3rdVndrSeq() {
		return this.n3rdVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return trk20ftBzcCostAmt
	 */
	public String getTrk20ftBzcCostAmt() {
		return this.trk20ftBzcCostAmt;
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
	 * @return rail40ftBzcCostSrcNm
	 */
	public String getRail40ftBzcCostSrcNm() {
		return this.rail40ftBzcCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @return n3rdVndrNm
	 */
	public String getN3rdVndrNm() {
		return this.n3rdVndrNm;
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
	 * @return dmst20ftCostAmt
	 */
	public String getDmst20ftCostAmt() {
		return this.dmst20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return n2ndInlndRoutCmbFlg
	 */
	public String getN2ndInlndRoutCmbFlg() {
		return this.n2ndInlndRoutCmbFlg;
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
	 * @return rail40ftFuelAgmtWyTpCd
	 */
	public String getRail40ftFuelAgmtWyTpCd() {
		return this.rail40ftFuelAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @return rail20ftBzcAgmtWgt
	 */
	public String getRail20ftBzcAgmtWgt() {
		return this.rail20ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return trk40ftBzcCostAdjAmt
	 */
	public String getTrk40ftBzcCostAdjAmt() {
		return this.trk40ftBzcCostAdjAmt;
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
	 * @return trk40ftBzcAgmtWgt
	 */
	public String getTrk40ftBzcAgmtWgt() {
		return this.trk40ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return trk40ftFuelScgAmt
	 */
	public String getTrk40ftFuelScgAmt() {
		return this.trk40ftFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @return rail40ftFuelScgAdjAmt
	 */
	public String getRail40ftFuelScgAdjAmt() {
		return this.rail40ftFuelScgAdjAmt;
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
	 * @return rail20ftFuelAgmtWyTpCd
	 */
	public String getRail20ftFuelAgmtWyTpCd() {
		return this.rail20ftFuelAgmtWyTpCd;
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
	 * @return agmtOldFlg
	 */
	public String getAgmtOldFlg() {
		return this.agmtOldFlg;
	}
	
	/**
	 * Column Info
	 * @return rail40ftBzcCostTtlAmt
	 */
	public String getRail40ftBzcCostTtlAmt() {
		return this.rail40ftBzcCostTtlAmt;
	}
	

	/**
	 * Column Info
	 * @param dmst40ftCostAmt
	 */
	public void setDmst40ftCostAmt(String dmst40ftCostAmt) {
		this.dmst40ftCostAmt = dmst40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rail20ftFuelScgTtlAmt
	 */
	public void setRail20ftFuelScgTtlAmt(String rail20ftFuelScgTtlAmt) {
		this.rail20ftFuelScgTtlAmt = rail20ftFuelScgTtlAmt;
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
	 * @param trk20ftFuelScgTtlAmt
	 */
	public void setTrk20ftFuelScgTtlAmt(String trk20ftFuelScgTtlAmt) {
		this.trk20ftFuelScgTtlAmt = trk20ftFuelScgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param rail40ftBzcAgmtWyTpCd
	 */
	public void setRail40ftBzcAgmtWyTpCd(String rail40ftBzcAgmtWyTpCd) {
		this.rail40ftBzcAgmtWyTpCd = rail40ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @param trk40ftBzcCostAmt
	 */
	public void setTrk40ftBzcCostAmt(String trk40ftBzcCostAmt) {
		this.trk40ftBzcCostAmt = trk40ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rail20ftBzcCostAmt
	 */
	public void setRail20ftBzcCostAmt(String rail20ftBzcCostAmt) {
		this.rail20ftBzcCostAmt = rail20ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rail40ftBzcCostAmt
	 */
	public void setRail40ftBzcCostAmt(String rail40ftBzcCostAmt) {
		this.rail40ftBzcCostAmt = rail40ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stInlndRoutCmbFlg
	 */
	public void setN1stInlndRoutCmbFlg(String n1stInlndRoutCmbFlg) {
		this.n1stInlndRoutCmbFlg = n1stInlndRoutCmbFlg;
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
	 * @param trk20ftBzcCostAdjAmt
	 */
	public void setTrk20ftBzcCostAdjAmt(String trk20ftBzcCostAdjAmt) {
		this.trk20ftBzcCostAdjAmt = trk20ftBzcCostAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param rail40ftFuelScgSrcNm
	 */
	public void setRail40ftFuelScgSrcNm(String rail40ftFuelScgSrcNm) {
		this.rail40ftFuelScgSrcNm = rail40ftFuelScgSrcNm;
	}
	
	/**
	 * Column Info
	 * @param tollFeeAmt40
	 */
	public void setTollFeeAmt40(String tollFeeAmt40) {
		this.tollFeeAmt40 = tollFeeAmt40;
	}
	
	/**
	 * Column Info
	 * @param trk20ftBzcCostTtlAmt
	 */
	public void setTrk20ftBzcCostTtlAmt(String trk20ftBzcCostTtlAmt) {
		this.trk20ftBzcCostTtlAmt = trk20ftBzcCostTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param rail40ftBzcAgmtWgt
	 */
	public void setRail40ftBzcAgmtWgt(String rail40ftBzcAgmtWgt) {
		this.rail40ftBzcAgmtWgt = rail40ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param trk40ftBzcAgmtWyTpCd
	 */
	public void setTrk40ftBzcAgmtWyTpCd(String trk40ftBzcAgmtWyTpCd) {
		this.trk40ftBzcAgmtWyTpCd = trk40ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @param rail20ftFuelScgSrcNm
	 */
	public void setRail20ftFuelScgSrcNm(String rail20ftFuelScgSrcNm) {
		this.rail20ftFuelScgSrcNm = rail20ftFuelScgSrcNm;
	}
	
	/**
	 * Column Info
	 * @param rail40ftFuelScgTtlAmt
	 */
	public void setRail40ftFuelScgTtlAmt(String rail40ftFuelScgTtlAmt) {
		this.rail40ftFuelScgTtlAmt = rail40ftFuelScgTtlAmt;
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
	 * @param rail20ftFuelScgAmt
	 */
	public void setRail20ftFuelScgAmt(String rail20ftFuelScgAmt) {
		this.rail20ftFuelScgAmt = rail20ftFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param trk20ftFuelScgAgmtWgt
	 */
	public void setTrk20ftFuelScgAgmtWgt(String trk20ftFuelScgAgmtWgt) {
		this.trk20ftFuelScgAgmtWgt = trk20ftFuelScgAgmtWgt;
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
	 * @param n2ndVndrSeq
	 */
	public void setN2ndVndrSeq(String n2ndVndrSeq) {
		this.n2ndVndrSeq = n2ndVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param rail20ftBzcAgmtWyTpCd
	 */
	public void setRail20ftBzcAgmtWyTpCd(String rail20ftBzcAgmtWyTpCd) {
		this.rail20ftBzcAgmtWyTpCd = rail20ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @param trk20ftBzcCostSrcNm
	 */
	public void setTrk20ftBzcCostSrcNm(String trk20ftBzcCostSrcNm) {
		this.trk20ftBzcCostSrcNm = trk20ftBzcCostSrcNm;
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
	 * @param trspAgmt20ftMtyYdCd
	 */
	public void setTrspAgmt20ftMtyYdCd(String trspAgmt20ftMtyYdCd) {
		this.trspAgmt20ftMtyYdCd = trspAgmt20ftMtyYdCd;
	}
	
	/**
	 * Column Info
	 * @param trk20ftFuelScgAmt
	 */
	public void setTrk20ftFuelScgAmt(String trk20ftFuelScgAmt) {
		this.trk20ftFuelScgAmt = trk20ftFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param rail40ftFuelScgAgmtWgt
	 */
	public void setRail40ftFuelScgAgmtWgt(String rail40ftFuelScgAgmtWgt) {
		this.rail40ftFuelScgAgmtWgt = rail40ftFuelScgAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param trk20ftBzcAgmtWgt
	 */
	public void setTrk20ftBzcAgmtWgt(String trk20ftBzcAgmtWgt) {
		this.trk20ftBzcAgmtWgt = trk20ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param trk40ftBzcCostTtlAmt
	 */
	public void setTrk40ftBzcCostTtlAmt(String trk40ftBzcCostTtlAmt) {
		this.trk40ftBzcCostTtlAmt = trk40ftBzcCostTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param rail20ftBzcCostSrcNm
	 */
	public void setRail20ftBzcCostSrcNm(String rail20ftBzcCostSrcNm) {
		this.rail20ftBzcCostSrcNm = rail20ftBzcCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @param trk20ftBzcAgmtWyTpCd
	 */
	public void setTrk20ftBzcAgmtWyTpCd(String trk20ftBzcAgmtWyTpCd) {
		this.trk20ftBzcAgmtWyTpCd = trk20ftBzcAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @param tml40ftCostSrcNm
	 */
	public void setTml40ftCostSrcNm(String tml40ftCostSrcNm) {
		this.tml40ftCostSrcNm = tml40ftCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @param rail20ftBzcCostAdjAmt
	 */
	public void setRail20ftBzcCostAdjAmt(String rail20ftBzcCostAdjAmt) {
		this.rail20ftBzcCostAdjAmt = rail20ftBzcCostAdjAmt;
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
	 * @param trk20ftFuelScgSrcNm
	 */
	public void setTrk20ftFuelScgSrcNm(String trk20ftFuelScgSrcNm) {
		this.trk20ftFuelScgSrcNm = trk20ftFuelScgSrcNm;
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
	 * @param tml20ftCostSrcNm
	 */
	public void setTml20ftCostSrcNm(String tml20ftCostSrcNm) {
		this.tml20ftCostSrcNm = tml20ftCostSrcNm;
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
	 * @param trk40ftFuelScgAdjAmt
	 */
	public void setTrk40ftFuelScgAdjAmt(String trk40ftFuelScgAdjAmt) {
		this.trk40ftFuelScgAdjAmt = trk40ftFuelScgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param rail20ftFuelScgAdjAmt
	 */
	public void setRail20ftFuelScgAdjAmt(String rail20ftFuelScgAdjAmt) {
		this.rail20ftFuelScgAdjAmt = rail20ftFuelScgAdjAmt;
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
	 * @param rail20ftBzcCostTtlAmt
	 */
	public void setRail20ftBzcCostTtlAmt(String rail20ftBzcCostTtlAmt) {
		this.rail20ftBzcCostTtlAmt = rail20ftBzcCostTtlAmt;
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
	 * @param rfCnt
	 */
	public void setRfCnt(String rfCnt) {
		this.rfCnt = rfCnt;
	}
	
	/**
	 * Column Info
	 * @param trk20ftFuelAgmtWyTpCd
	 */
	public void setTrk20ftFuelAgmtWyTpCd(String trk20ftFuelAgmtWyTpCd) {
		this.trk20ftFuelAgmtWyTpCd = trk20ftFuelAgmtWyTpCd;
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
	 * @param trk20ftFuelScgAdjAmt
	 */
	public void setTrk20ftFuelScgAdjAmt(String trk20ftFuelScgAdjAmt) {
		this.trk20ftFuelScgAdjAmt = trk20ftFuelScgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param trk40ftFuelScgAgmtWgt
	 */
	public void setTrk40ftFuelScgAgmtWgt(String trk40ftFuelScgAgmtWgt) {
		this.trk40ftFuelScgAgmtWgt = trk40ftFuelScgAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param trk40ftFuelAgmtWyTpCd
	 */
	public void setTrk40ftFuelAgmtWyTpCd(String trk40ftFuelAgmtWyTpCd) {
		this.trk40ftFuelAgmtWyTpCd = trk40ftFuelAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @param rail20ftFuelScgAgmtWgt
	 */
	public void setRail20ftFuelScgAgmtWgt(String rail20ftFuelScgAgmtWgt) {
		this.rail20ftFuelScgAgmtWgt = rail20ftFuelScgAgmtWgt;
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
	 * @param trk40ftBzcCostSrcNm
	 */
	public void setTrk40ftBzcCostSrcNm(String trk40ftBzcCostSrcNm) {
		this.trk40ftBzcCostSrcNm = trk40ftBzcCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @param rail40ftBzcCostAdjAmt
	 */
	public void setRail40ftBzcCostAdjAmt(String rail40ftBzcCostAdjAmt) {
		this.rail40ftBzcCostAdjAmt = rail40ftBzcCostAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param trk40ftFuelScgSrcNm
	 */
	public void setTrk40ftFuelScgSrcNm(String trk40ftFuelScgSrcNm) {
		this.trk40ftFuelScgSrcNm = trk40ftFuelScgSrcNm;
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
	 * @param mtyPkupRtnYdCd
	 */
	public void setMtyPkupRtnYdCd(String mtyPkupRtnYdCd) {
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
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
	 * @param rail40ftFuelScgAmt
	 */
	public void setRail40ftFuelScgAmt(String rail40ftFuelScgAmt) {
		this.rail40ftFuelScgAmt = rail40ftFuelScgAmt;
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
	 * @param tollFeeAmt20
	 */
	public void setTollFeeAmt20(String tollFeeAmt20) {
		this.tollFeeAmt20 = tollFeeAmt20;
	}
	
	/**
	 * Column Info
	 * @param trk40ftFuelScgTtlAmt
	 */
	public void setTrk40ftFuelScgTtlAmt(String trk40ftFuelScgTtlAmt) {
		this.trk40ftFuelScgTtlAmt = trk40ftFuelScgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param n3rdVndrSeq
	 */
	public void setN3rdVndrSeq(String n3rdVndrSeq) {
		this.n3rdVndrSeq = n3rdVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param trk20ftBzcCostAmt
	 */
	public void setTrk20ftBzcCostAmt(String trk20ftBzcCostAmt) {
		this.trk20ftBzcCostAmt = trk20ftBzcCostAmt;
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
	 * @param rail40ftBzcCostSrcNm
	 */
	public void setRail40ftBzcCostSrcNm(String rail40ftBzcCostSrcNm) {
		this.rail40ftBzcCostSrcNm = rail40ftBzcCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @param n3rdVndrNm
	 */
	public void setN3rdVndrNm(String n3rdVndrNm) {
		this.n3rdVndrNm = n3rdVndrNm;
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
	 * @param dmst20ftCostAmt
	 */
	public void setDmst20ftCostAmt(String dmst20ftCostAmt) {
		this.dmst20ftCostAmt = dmst20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param n2ndInlndRoutCmbFlg
	 */
	public void setN2ndInlndRoutCmbFlg(String n2ndInlndRoutCmbFlg) {
		this.n2ndInlndRoutCmbFlg = n2ndInlndRoutCmbFlg;
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
	 * @param rail40ftFuelAgmtWyTpCd
	 */
	public void setRail40ftFuelAgmtWyTpCd(String rail40ftFuelAgmtWyTpCd) {
		this.rail40ftFuelAgmtWyTpCd = rail40ftFuelAgmtWyTpCd;
	}
	
	/**
	 * Column Info
	 * @param rail20ftBzcAgmtWgt
	 */
	public void setRail20ftBzcAgmtWgt(String rail20ftBzcAgmtWgt) {
		this.rail20ftBzcAgmtWgt = rail20ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param trk40ftBzcCostAdjAmt
	 */
	public void setTrk40ftBzcCostAdjAmt(String trk40ftBzcCostAdjAmt) {
		this.trk40ftBzcCostAdjAmt = trk40ftBzcCostAdjAmt;
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
	 * @param trk40ftBzcAgmtWgt
	 */
	public void setTrk40ftBzcAgmtWgt(String trk40ftBzcAgmtWgt) {
		this.trk40ftBzcAgmtWgt = trk40ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param trk40ftFuelScgAmt
	 */
	public void setTrk40ftFuelScgAmt(String trk40ftFuelScgAmt) {
		this.trk40ftFuelScgAmt = trk40ftFuelScgAmt;
	}
	
	/**
	 * Column Info
	 * @param rail40ftFuelScgAdjAmt
	 */
	public void setRail40ftFuelScgAdjAmt(String rail40ftFuelScgAdjAmt) {
		this.rail40ftFuelScgAdjAmt = rail40ftFuelScgAdjAmt;
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
	 * @param rail20ftFuelAgmtWyTpCd
	 */
	public void setRail20ftFuelAgmtWyTpCd(String rail20ftFuelAgmtWyTpCd) {
		this.rail20ftFuelAgmtWyTpCd = rail20ftFuelAgmtWyTpCd;
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
	 * @param agmtOldFlg
	 */
	public void setAgmtOldFlg(String agmtOldFlg) {
		this.agmtOldFlg = agmtOldFlg;
	}
	
	/**
	 * Column Info
	 * @param rail40ftBzcCostTtlAmt
	 */
	public void setRail40ftBzcCostTtlAmt(String rail40ftBzcCostTtlAmt) {
		this.rail40ftBzcCostTtlAmt = rail40ftBzcCostTtlAmt;
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
		setDmst40ftCostAmt(JSPUtil.getParameter(request, prefix + "dmst_40ft_cost_amt", ""));
		setRail20ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_ttl_amt", ""));
		setCostRoutGrpNo(JSPUtil.getParameter(request, prefix + "cost_rout_grp_no", ""));
		setTrk20ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_ttl_amt", ""));
		setRail40ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_agmt_wy_tp_cd", ""));
		setTrk40ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_amt", ""));
		setRail20ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_amt", ""));
		setRail40ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_amt", ""));
		setN1stInlndRoutCmbFlg(JSPUtil.getParameter(request, prefix + "n1st_inlnd_rout_cmb_flg", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrk20ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_adj_amt", ""));
		setRail40ftFuelScgSrcNm(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_src_nm", ""));
		setTollFeeAmt40(JSPUtil.getParameter(request, prefix + "toll_fee_amt_40", ""));
		setTrk20ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_ttl_amt", ""));
		setRail40ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_agmt_wgt", ""));
		setTrk40ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_agmt_wy_tp_cd", ""));
		setRail20ftFuelScgSrcNm(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_src_nm", ""));
		setRail40ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_ttl_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setRail20ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_amt", ""));
		setTrk20ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_agmt_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setCostSelRoutFlg(JSPUtil.getParameter(request, prefix + "cost_sel_rout_flg", ""));
		setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
		setRail20ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_agmt_wy_tp_cd", ""));
		setTrk20ftBzcCostSrcNm(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_src_nm", ""));
		setInlnd20ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_20ft_ttl_amt", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setTrspAgmt20ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_20ft_mty_yd_cd", ""));
		setTrk20ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_amt", ""));
		setRail40ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_agmt_wgt", ""));
		setTrk20ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_agmt_wgt", ""));
		setTrk40ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_ttl_amt", ""));
		setRail20ftBzcCostSrcNm(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_src_nm", ""));
		setTrk20ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_agmt_wy_tp_cd", ""));
		setTml40ftCostSrcNm(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_src_nm", ""));
		setRail20ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_adj_amt", ""));
		setTrspDiff20ft(JSPUtil.getParameter(request, prefix + "trsp_diff_20ft", ""));
		setPortLoc(JSPUtil.getParameter(request, prefix + "port_loc", ""));
		setTrk20ftFuelScgSrcNm(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_src_nm", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setLocNodCd(JSPUtil.getParameter(request, prefix + "loc_nod_cd", ""));
		setTml20ftCostSrcNm(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_src_nm", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
		setTrk40ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_adj_amt", ""));
		setRail20ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_adj_amt", ""));
		setRcvDeTermNm(JSPUtil.getParameter(request, prefix + "rcv_de_term_nm", ""));
		setRail20ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_ttl_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setTrspAgmt40ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_40ft_mty_yd_cd", ""));
		setRfCnt(JSPUtil.getParameter(request, prefix + "rf_cnt", ""));
		setTrk20ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_agmt_wy_tp_cd", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setTrk20ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_adj_amt", ""));
		setTrk40ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_agmt_wgt", ""));
		setTrk40ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_agmt_wy_tp_cd", ""));
		setRail20ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_agmt_wgt", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setCostRoutGrpNoRnk(JSPUtil.getParameter(request, prefix + "cost_rout_grp_no_rnk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrk40ftBzcCostSrcNm(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_src_nm", ""));
		setRail40ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_adj_amt", ""));
		setTrk40ftFuelScgSrcNm(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_src_nm", ""));
		setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
		setMtyPkupRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_cd", ""));
		setN1stVndrNm(JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", ""));
		setRail40ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_amt", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setTollFeeAmt20(JSPUtil.getParameter(request, prefix + "toll_fee_amt_20", ""));
		setTrk40ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_ttl_amt", ""));
		setN3rdVndrSeq(JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", ""));
		setTrk20ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_amt", ""));
		setTrspDiff40ft(JSPUtil.getParameter(request, prefix + "trsp_diff_40ft", ""));
		setRail40ftBzcCostSrcNm(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_src_nm", ""));
		setN3rdVndrNm(JSPUtil.getParameter(request, prefix + "n3rd_vndr_nm", ""));
		setInlnd40ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_40ft_ttl_amt", ""));
		setDmst20ftCostAmt(JSPUtil.getParameter(request, prefix + "dmst_20ft_cost_amt", ""));
		setN2ndInlndRoutCmbFlg(JSPUtil.getParameter(request, prefix + "n2nd_inlnd_rout_cmb_flg", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setRail40ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_agmt_wy_tp_cd", ""));
		setRail20ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_agmt_wgt", ""));
		setTrk40ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_adj_amt", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setTrk40ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_agmt_wgt", ""));
		setTrk40ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_amt", ""));
		setRail40ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_adj_amt", ""));
		setPortNodCd(JSPUtil.getParameter(request, prefix + "port_nod_cd", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setRail20ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_agmt_wy_tp_cd", ""));
		setN2ndVndrNm(JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
		setRail40ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_ttl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaInlandCostDetailVO[]
	 */
	public UsaInlandCostDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaInlandCostDetailVO[]
	 */
	public UsaInlandCostDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaInlandCostDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmst40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_40ft_cost_amt", length));
			String[] rail20ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_ttl_amt", length));
			String[] costRoutGrpNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_grp_no", length));
			String[] trk20ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_ttl_amt", length));
			String[] rail40ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_agmt_wy_tp_cd", length));
			String[] trk40ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_amt", length));
			String[] rail20ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_amt", length));
			String[] rail40ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_amt", length));
			String[] n1stInlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "n1st_inlnd_rout_cmb_flg", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trk20ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_adj_amt", length));
			String[] rail40ftFuelScgSrcNm = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_src_nm", length));
			String[] tollFeeAmt40 = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt_40", length));
			String[] trk20ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_ttl_amt", length));
			String[] rail40ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_agmt_wgt", length));
			String[] trk40ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_agmt_wy_tp_cd", length));
			String[] rail20ftFuelScgSrcNm = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_src_nm", length));
			String[] rail40ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_ttl_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] rail20ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_amt", length));
			String[] trk20ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_agmt_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] costSelRoutFlg = (JSPUtil.getParameter(request, prefix	+ "cost_sel_rout_flg", length));
			String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_seq", length));
			String[] rail20ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_agmt_wy_tp_cd", length));
			String[] trk20ftBzcCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_src_nm", length));
			String[] inlnd20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_20ft_ttl_amt", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] trspAgmt20ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_20ft_mty_yd_cd", length));
			String[] trk20ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_amt", length));
			String[] rail40ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_agmt_wgt", length));
			String[] trk20ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_agmt_wgt", length));
			String[] trk40ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_ttl_amt", length));
			String[] rail20ftBzcCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_src_nm", length));
			String[] trk20ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_agmt_wy_tp_cd", length));
			String[] tml40ftCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_src_nm", length));
			String[] rail20ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_adj_amt", length));
			String[] trspDiff20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_20ft", length));
			String[] portLoc = (JSPUtil.getParameter(request, prefix	+ "port_loc", length));
			String[] trk20ftFuelScgSrcNm = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_src_nm", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] locNodCd = (JSPUtil.getParameter(request, prefix	+ "loc_nod_cd", length));
			String[] tml20ftCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_src_nm", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			String[] trk40ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_adj_amt", length));
			String[] rail20ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_adj_amt", length));
			String[] rcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_nm", length));
			String[] rail20ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_ttl_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] trspAgmt40ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_40ft_mty_yd_cd", length));
			String[] rfCnt = (JSPUtil.getParameter(request, prefix	+ "rf_cnt", length));
			String[] trk20ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_agmt_wy_tp_cd", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] trk20ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_adj_amt", length));
			String[] trk40ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_agmt_wgt", length));
			String[] trk40ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_agmt_wy_tp_cd", length));
			String[] rail20ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_agmt_wgt", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] costRoutGrpNoRnk = (JSPUtil.getParameter(request, prefix	+ "cost_rout_grp_no_rnk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trk40ftBzcCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_src_nm", length));
			String[] rail40ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_adj_amt", length));
			String[] trk40ftFuelScgSrcNm = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_src_nm", length));
			String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_seq", length));
			String[] mtyPkupRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_cd", length));
			String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_nm", length));
			String[] rail40ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_amt", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] tollFeeAmt20 = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt_20", length));
			String[] trk40ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_ttl_amt", length));
			String[] n3rdVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_vndr_seq", length));
			String[] trk20ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_amt", length));
			String[] trspDiff40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_40ft", length));
			String[] rail40ftBzcCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_src_nm", length));
			String[] n3rdVndrNm = (JSPUtil.getParameter(request, prefix	+ "n3rd_vndr_nm", length));
			String[] inlnd40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_ttl_amt", length));
			String[] dmst20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_20ft_cost_amt", length));
			String[] n2ndInlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "n2nd_inlnd_rout_cmb_flg", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] rail40ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_agmt_wy_tp_cd", length));
			String[] rail20ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_agmt_wgt", length));
			String[] trk40ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_adj_amt", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] trk40ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_agmt_wgt", length));
			String[] trk40ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_amt", length));
			String[] rail40ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_adj_amt", length));
			String[] portNodCd = (JSPUtil.getParameter(request, prefix	+ "port_nod_cd", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] rail20ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_agmt_wy_tp_cd", length));
			String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_nm", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			String[] rail40ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_ttl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaInlandCostDetailVO();
				if (dmst40ftCostAmt[i] != null)
					model.setDmst40ftCostAmt(dmst40ftCostAmt[i]);
				if (rail20ftFuelScgTtlAmt[i] != null)
					model.setRail20ftFuelScgTtlAmt(rail20ftFuelScgTtlAmt[i]);
				if (costRoutGrpNo[i] != null)
					model.setCostRoutGrpNo(costRoutGrpNo[i]);
				if (trk20ftFuelScgTtlAmt[i] != null)
					model.setTrk20ftFuelScgTtlAmt(trk20ftFuelScgTtlAmt[i]);
				if (rail40ftBzcAgmtWyTpCd[i] != null)
					model.setRail40ftBzcAgmtWyTpCd(rail40ftBzcAgmtWyTpCd[i]);
				if (trk40ftBzcCostAmt[i] != null)
					model.setTrk40ftBzcCostAmt(trk40ftBzcCostAmt[i]);
				if (rail20ftBzcCostAmt[i] != null)
					model.setRail20ftBzcCostAmt(rail20ftBzcCostAmt[i]);
				if (rail40ftBzcCostAmt[i] != null)
					model.setRail40ftBzcCostAmt(rail40ftBzcCostAmt[i]);
				if (n1stInlndRoutCmbFlg[i] != null)
					model.setN1stInlndRoutCmbFlg(n1stInlndRoutCmbFlg[i]);
				if (costTrfRoutSeq[i] != null)
					model.setCostTrfRoutSeq(costTrfRoutSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trk20ftBzcCostAdjAmt[i] != null)
					model.setTrk20ftBzcCostAdjAmt(trk20ftBzcCostAdjAmt[i]);
				if (rail40ftFuelScgSrcNm[i] != null)
					model.setRail40ftFuelScgSrcNm(rail40ftFuelScgSrcNm[i]);
				if (tollFeeAmt40[i] != null)
					model.setTollFeeAmt40(tollFeeAmt40[i]);
				if (trk20ftBzcCostTtlAmt[i] != null)
					model.setTrk20ftBzcCostTtlAmt(trk20ftBzcCostTtlAmt[i]);
				if (rail40ftBzcAgmtWgt[i] != null)
					model.setRail40ftBzcAgmtWgt(rail40ftBzcAgmtWgt[i]);
				if (trk40ftBzcAgmtWyTpCd[i] != null)
					model.setTrk40ftBzcAgmtWyTpCd(trk40ftBzcAgmtWyTpCd[i]);
				if (rail20ftFuelScgSrcNm[i] != null)
					model.setRail20ftFuelScgSrcNm(rail20ftFuelScgSrcNm[i]);
				if (rail40ftFuelScgTtlAmt[i] != null)
					model.setRail40ftFuelScgTtlAmt(rail40ftFuelScgTtlAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (rail20ftFuelScgAmt[i] != null)
					model.setRail20ftFuelScgAmt(rail20ftFuelScgAmt[i]);
				if (trk20ftFuelScgAgmtWgt[i] != null)
					model.setTrk20ftFuelScgAgmtWgt(trk20ftFuelScgAgmtWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (costSelRoutFlg[i] != null)
					model.setCostSelRoutFlg(costSelRoutFlg[i]);
				if (n2ndVndrSeq[i] != null)
					model.setN2ndVndrSeq(n2ndVndrSeq[i]);
				if (rail20ftBzcAgmtWyTpCd[i] != null)
					model.setRail20ftBzcAgmtWyTpCd(rail20ftBzcAgmtWyTpCd[i]);
				if (trk20ftBzcCostSrcNm[i] != null)
					model.setTrk20ftBzcCostSrcNm(trk20ftBzcCostSrcNm[i]);
				if (inlnd20ftTtlAmt[i] != null)
					model.setInlnd20ftTtlAmt(inlnd20ftTtlAmt[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (trspAgmt20ftMtyYdCd[i] != null)
					model.setTrspAgmt20ftMtyYdCd(trspAgmt20ftMtyYdCd[i]);
				if (trk20ftFuelScgAmt[i] != null)
					model.setTrk20ftFuelScgAmt(trk20ftFuelScgAmt[i]);
				if (rail40ftFuelScgAgmtWgt[i] != null)
					model.setRail40ftFuelScgAgmtWgt(rail40ftFuelScgAgmtWgt[i]);
				if (trk20ftBzcAgmtWgt[i] != null)
					model.setTrk20ftBzcAgmtWgt(trk20ftBzcAgmtWgt[i]);
				if (trk40ftBzcCostTtlAmt[i] != null)
					model.setTrk40ftBzcCostTtlAmt(trk40ftBzcCostTtlAmt[i]);
				if (rail20ftBzcCostSrcNm[i] != null)
					model.setRail20ftBzcCostSrcNm(rail20ftBzcCostSrcNm[i]);
				if (trk20ftBzcAgmtWyTpCd[i] != null)
					model.setTrk20ftBzcAgmtWyTpCd(trk20ftBzcAgmtWyTpCd[i]);
				if (tml40ftCostSrcNm[i] != null)
					model.setTml40ftCostSrcNm(tml40ftCostSrcNm[i]);
				if (rail20ftBzcCostAdjAmt[i] != null)
					model.setRail20ftBzcCostAdjAmt(rail20ftBzcCostAdjAmt[i]);
				if (trspDiff20ft[i] != null)
					model.setTrspDiff20ft(trspDiff20ft[i]);
				if (portLoc[i] != null)
					model.setPortLoc(portLoc[i]);
				if (trk20ftFuelScgSrcNm[i] != null)
					model.setTrk20ftFuelScgSrcNm(trk20ftFuelScgSrcNm[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (locNodCd[i] != null)
					model.setLocNodCd(locNodCd[i]);
				if (tml20ftCostSrcNm[i] != null)
					model.setTml20ftCostSrcNm(tml20ftCostSrcNm[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				if (trk40ftFuelScgAdjAmt[i] != null)
					model.setTrk40ftFuelScgAdjAmt(trk40ftFuelScgAdjAmt[i]);
				if (rail20ftFuelScgAdjAmt[i] != null)
					model.setRail20ftFuelScgAdjAmt(rail20ftFuelScgAdjAmt[i]);
				if (rcvDeTermNm[i] != null)
					model.setRcvDeTermNm(rcvDeTermNm[i]);
				if (rail20ftBzcCostTtlAmt[i] != null)
					model.setRail20ftBzcCostTtlAmt(rail20ftBzcCostTtlAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (trspAgmt40ftMtyYdCd[i] != null)
					model.setTrspAgmt40ftMtyYdCd(trspAgmt40ftMtyYdCd[i]);
				if (rfCnt[i] != null)
					model.setRfCnt(rfCnt[i]);
				if (trk20ftFuelAgmtWyTpCd[i] != null)
					model.setTrk20ftFuelAgmtWyTpCd(trk20ftFuelAgmtWyTpCd[i]);
				if (mtyTrsp20ftCostAmt[i] != null)
					model.setMtyTrsp20ftCostAmt(mtyTrsp20ftCostAmt[i]);
				if (trk20ftFuelScgAdjAmt[i] != null)
					model.setTrk20ftFuelScgAdjAmt(trk20ftFuelScgAdjAmt[i]);
				if (trk40ftFuelScgAgmtWgt[i] != null)
					model.setTrk40ftFuelScgAgmtWgt(trk40ftFuelScgAgmtWgt[i]);
				if (trk40ftFuelAgmtWyTpCd[i] != null)
					model.setTrk40ftFuelAgmtWyTpCd(trk40ftFuelAgmtWyTpCd[i]);
				if (rail20ftFuelScgAgmtWgt[i] != null)
					model.setRail20ftFuelScgAgmtWgt(rail20ftFuelScgAgmtWgt[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (costRoutGrpNoRnk[i] != null)
					model.setCostRoutGrpNoRnk(costRoutGrpNoRnk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trk40ftBzcCostSrcNm[i] != null)
					model.setTrk40ftBzcCostSrcNm(trk40ftBzcCostSrcNm[i]);
				if (rail40ftBzcCostAdjAmt[i] != null)
					model.setRail40ftBzcCostAdjAmt(rail40ftBzcCostAdjAmt[i]);
				if (trk40ftFuelScgSrcNm[i] != null)
					model.setTrk40ftFuelScgSrcNm(trk40ftFuelScgSrcNm[i]);
				if (n1stVndrSeq[i] != null)
					model.setN1stVndrSeq(n1stVndrSeq[i]);
				if (mtyPkupRtnYdCd[i] != null)
					model.setMtyPkupRtnYdCd(mtyPkupRtnYdCd[i]);
				if (n1stVndrNm[i] != null)
					model.setN1stVndrNm(n1stVndrNm[i]);
				if (rail40ftFuelScgAmt[i] != null)
					model.setRail40ftFuelScgAmt(rail40ftFuelScgAmt[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (tollFeeAmt20[i] != null)
					model.setTollFeeAmt20(tollFeeAmt20[i]);
				if (trk40ftFuelScgTtlAmt[i] != null)
					model.setTrk40ftFuelScgTtlAmt(trk40ftFuelScgTtlAmt[i]);
				if (n3rdVndrSeq[i] != null)
					model.setN3rdVndrSeq(n3rdVndrSeq[i]);
				if (trk20ftBzcCostAmt[i] != null)
					model.setTrk20ftBzcCostAmt(trk20ftBzcCostAmt[i]);
				if (trspDiff40ft[i] != null)
					model.setTrspDiff40ft(trspDiff40ft[i]);
				if (rail40ftBzcCostSrcNm[i] != null)
					model.setRail40ftBzcCostSrcNm(rail40ftBzcCostSrcNm[i]);
				if (n3rdVndrNm[i] != null)
					model.setN3rdVndrNm(n3rdVndrNm[i]);
				if (inlnd40ftTtlAmt[i] != null)
					model.setInlnd40ftTtlAmt(inlnd40ftTtlAmt[i]);
				if (dmst20ftCostAmt[i] != null)
					model.setDmst20ftCostAmt(dmst20ftCostAmt[i]);
				if (n2ndInlndRoutCmbFlg[i] != null)
					model.setN2ndInlndRoutCmbFlg(n2ndInlndRoutCmbFlg[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (rail40ftFuelAgmtWyTpCd[i] != null)
					model.setRail40ftFuelAgmtWyTpCd(rail40ftFuelAgmtWyTpCd[i]);
				if (rail20ftBzcAgmtWgt[i] != null)
					model.setRail20ftBzcAgmtWgt(rail20ftBzcAgmtWgt[i]);
				if (trk40ftBzcCostAdjAmt[i] != null)
					model.setTrk40ftBzcCostAdjAmt(trk40ftBzcCostAdjAmt[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (trk40ftBzcAgmtWgt[i] != null)
					model.setTrk40ftBzcAgmtWgt(trk40ftBzcAgmtWgt[i]);
				if (trk40ftFuelScgAmt[i] != null)
					model.setTrk40ftFuelScgAmt(trk40ftFuelScgAmt[i]);
				if (rail40ftFuelScgAdjAmt[i] != null)
					model.setRail40ftFuelScgAdjAmt(rail40ftFuelScgAdjAmt[i]);
				if (portNodCd[i] != null)
					model.setPortNodCd(portNodCd[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (rail20ftFuelAgmtWyTpCd[i] != null)
					model.setRail20ftFuelAgmtWyTpCd(rail20ftFuelAgmtWyTpCd[i]);
				if (n2ndVndrNm[i] != null)
					model.setN2ndVndrNm(n2ndVndrNm[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				if (rail40ftBzcCostTtlAmt[i] != null)
					model.setRail40ftBzcCostTtlAmt(rail40ftBzcCostTtlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaInlandCostDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaInlandCostDetailVO[]
	 */
	public UsaInlandCostDetailVO[] getUsaInlandCostDetailVOs(){
		UsaInlandCostDetailVO[] vos = (UsaInlandCostDetailVO[])models.toArray(new UsaInlandCostDetailVO[models.size()]);
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
		this.dmst40ftCostAmt = this.dmst40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgTtlAmt = this.rail20ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutGrpNo = this.costRoutGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgTtlAmt = this.trk20ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcAgmtWyTpCd = this.rail40ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostAmt = this.trk40ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostAmt = this.rail20ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostAmt = this.rail40ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stInlndRoutCmbFlg = this.n1stInlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostAdjAmt = this.trk20ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgSrcNm = this.rail40ftFuelScgSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt40 = this.tollFeeAmt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostTtlAmt = this.trk20ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcAgmtWgt = this.rail40ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcAgmtWyTpCd = this.trk40ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgSrcNm = this.rail20ftFuelScgSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgTtlAmt = this.rail40ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgAmt = this.rail20ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgAgmtWgt = this.trk20ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSelRoutFlg = this.costSelRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrSeq = this.n2ndVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcAgmtWyTpCd = this.rail20ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostSrcNm = this.trk20ftBzcCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd20ftTtlAmt = this.inlnd20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt20ftMtyYdCd = this.trspAgmt20ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgAmt = this.trk20ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgAgmtWgt = this.rail40ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcAgmtWgt = this.trk20ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostTtlAmt = this.trk40ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostSrcNm = this.rail20ftBzcCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcAgmtWyTpCd = this.trk20ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostSrcNm = this.tml40ftCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostAdjAmt = this.rail20ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff20ft = this.trspDiff20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLoc = this.portLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgSrcNm = this.trk20ftFuelScgSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNodCd = this.locNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSrcNm = this.tml20ftCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgAdjAmt = this.trk40ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgAdjAmt = this.rail20ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermNm = this.rcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostTtlAmt = this.rail20ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt40ftMtyYdCd = this.trspAgmt40ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCnt = this.rfCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelAgmtWyTpCd = this.trk20ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgAdjAmt = this.trk20ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgAgmtWgt = this.trk40ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelAgmtWyTpCd = this.trk40ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgAgmtWgt = this.rail20ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutGrpNoRnk = this.costRoutGrpNoRnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostSrcNm = this.trk40ftBzcCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostAdjAmt = this.rail40ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgSrcNm = this.trk40ftFuelScgSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrSeq = this.n1stVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdCd = this.mtyPkupRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrNm = this.n1stVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgAmt = this.rail40ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt20 = this.tollFeeAmt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgTtlAmt = this.trk40ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVndrSeq = this.n3rdVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostAmt = this.trk20ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff40ft = this.trspDiff40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostSrcNm = this.rail40ftBzcCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVndrNm = this.n3rdVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftTtlAmt = this.inlnd40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst20ftCostAmt = this.dmst20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndInlndRoutCmbFlg = this.n2ndInlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelAgmtWyTpCd = this.rail40ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcAgmtWgt = this.rail20ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostAdjAmt = this.trk40ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcAgmtWgt = this.trk40ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgAmt = this.trk40ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgAdjAmt = this.rail40ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNodCd = this.portNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelAgmtWyTpCd = this.rail20ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrNm = this.n2ndVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostTtlAmt = this.rail40ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
