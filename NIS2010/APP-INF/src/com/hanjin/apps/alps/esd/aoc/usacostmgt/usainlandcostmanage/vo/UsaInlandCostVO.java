/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaInlandCostVO.java
*@FileTitle : UsaInlandCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.03.03 CHLOE MIJIN SEO 
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

public class UsaInlandCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaInlandCostVO> models = new ArrayList<UsaInlandCostVO>();
	
	/* Column Info */
	private String dmst20ftCostSrcCd = null;
	/* Column Info */
	private String rail20ftFuelScgTtlAmt = null;
	/* Column Info */
	private String costRoutGrpNo = null;
	/* Column Info */
	private String rail40ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String rail40ftBzcCostAmt = null;
	/* Column Info */
	private String rail20ftBzcCostAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trk20ftBzcCostAdjAmt = null;
	/* Column Info */
	private String rail20ftFuelScgSrcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String trk20ftBzcCostTtlAmt = null;
	/* Column Info */
	private String trk40ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String mtyTrsp20ftTtlCostAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String trk20ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String mtyTrsp20ftCostSrcCd = null;
	/* Column Info */
	private String inlnd20ftTtlAmt = null;
	/* Column Info */
	private String costTrfNo = null;
	/* Column Info */
	private String rf40ftTtlCostAmt = null;
	/* Column Info */
	private String rail40ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String trk40ftBzcCostTtlAmt = null;
	/* Column Info */
	private String trk20ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String rail20ftBzcCostAdjAmt = null;
	/* Column Info */
	private String portLoc = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String locNodCd = null;
	/* Column Info */
	private String trk20ftFuelScgSrcCd = null;
	/* Column Info */
	private String trk40ftFuelScgAdjAmt = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String trspAgmt40ftMtyYdCd = null;
	/* Column Info */
	private String tml40ftTtlCostAmt = null;
	/* Column Info */
	private String trk20ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String trk20ftFuelScgAdjAmt = null;
	/* Column Info */
	private String mtyTrsp40ftCostSrcCd = null;
	/* Column Info */
	private String trk40ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String trk40ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String rail20ftFuelScgAgmtWgt = null;
	/* Column Info */
	private String rail40ftTtlAmt = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String tollFeeAmt20 = null;
	/* Column Info */
	private String trk40ftFuelScgTtlAmt = null;
	/* Column Info */
	private String trk20ftBzcCostAmt = null;
	/* Column Info */
	private String trspDiff40ft = null;
	/* Column Info */
	private String costTrfRfSeq = null;
	/* Column Info */
	private String loclIpiSvcModNm = null;
	/* Column Info */
	private String n2ndInlndRoutCmbFlg = null;
	/* Column Info */
	private String inlnd40ftTtlAmt = null;
	/* Column Info */
	private String dmst20ftCostAmt = null;
	/* Column Info */
	private String rail40ftBzcCostSrcCd = null;
	/* Column Info */
	private String hubNodCd = null;
	/* Column Info */
	private String rail20ftBzcAgmtWgt = null;
	/* Column Info */
	private String mtyTrsp40ftTtlCostAmt = null;
	/* Column Info */
	private String dmst20ftAdjCostAmt = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String portNodCd = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String rail20ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String tml20ftTtlCostAmt = null;
	/* Column Info */
	private String agmtOldFlg = null;
	/* Column Info */
	private String n2ndVndrNm = null;
	/* Column Info */
	private String dmst40ftCostAmt = null;
	/* Column Info */
	private String dmst20ftTtlCostAmt = null;
	/* Column Info */
	private String trk20ftFuelScgTtlAmt = null;
	/* Column Info */
	private String trk40ftBzcCostAmt = null;
	/* Column Info */
	private String tml40ftCostSrcCd = null;
	/* Column Info */
	private String dmst40ftCostSrcCd = null;
	/* Column Info */
	private String n1stInlndRoutCmbFlg = null;
	/* Column Info */
	private String costTrfRoutSeq = null;
	/* Column Info */
	private String tollFeeAmt40 = null;
	/* Column Info */
	private String trk40ftBzcCostSrcCd = null;
	/* Column Info */
	private String rail40ftBzcAgmtWgt = null;
	/* Column Info */
	private String trk20ftBzcCostSrcCd = null;
	/* Column Info */
	private String rail40ftFuelScgTtlAmt = null;
	/* Column Info */
	private String rail20ftFuelScgAmt = null;
	/* Column Info */
	private String n2ndVndrSeq = null;
	/* Column Info */
	private String rail20ftBzcAgmtWyTpCd = null;
	/* Column Info */
	private String trspAgmt20ftMtyYdCd = null;
	/* Column Info */
	private String trk20ftFuelScgAmt = null;
	/* Column Info */
	private String trk20ftBzcAgmtWgt = null;
	/* Column Info */
	private String tml20ftCostSrcCd = null;
	/* Column Info */
	private String trspDiff20ft = null;
	/* Column Info */
	private String trk40ftTtlAmt = null;
	/* Column Info */
	private String loclIpiSvcMod = null;
	/* Column Info */
	private String mtyTrsp40ftAdjCostAmt = null;
	/* Column Info */
	private String rail20ftFuelScgAdjAmt = null;
	/* Column Info */
	private String rcvDeTermNm = null;
	/* Column Info */
	private String rail20ftBzcCostTtlAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dmst40ftTtlCostAmt = null;
	/* Column Info */
	private String rail20ftTtlAmt = null;
	/* Column Info */
	private String rail20ftBzcCostSrcCd = null;
	/* Column Info */
	private String mtyTrsp20ftCostAmt = null;
	/* Column Info */
	private String mtyTrsp20ftAdjCostAmt = null;
	/* Column Info */
	private String tml20ftAdjCostAmt = null;
	/* Column Info */
	private String rail40ftFuelScgSrcCd = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n1stVndrSeq = null;
	/* Column Info */
	private String rail40ftBzcCostAdjAmt = null;
	/* Column Info */
	private String rf20ftTtlCostAmt = null;
	/* Column Info */
	private String dmst40ftAdjCostAmt = null;
	/* Column Info */
	private String n1stVndrNm = null;
	/* Column Info */
	private String mtyPkupRtnYdCd = null;
	/* Column Info */
	private String rail40ftFuelScgAmt = null;
	/* Column Info */
	private String n3rdVndrSeq = null;
	/* Column Info */
	private String trk20ftTtlAmt = null;
	/* Column Info */
	private String tml40ftAdjCostAmt = null;
	/* Column Info */
	private String n3rdVndrNm = null;
	/* Column Info */
	private String trk40ftFuelScgSrcCd = null;
	/* Column Info */
	private String rail40ftFuelAgmtWyTpCd = null;
	/* Column Info */
	private String trk40ftBzcCostAdjAmt = null;
	/* Column Info */
	private String trk40ftBzcAgmtWgt = null;
	/* Column Info */
	private String trk40ftFuelScgAmt = null;
	/* Column Info */
	private String rail40ftFuelScgAdjAmt = null;
	/* Column Info */
	private String rail40ftBzcCostTtlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaInlandCostVO() {}

	public UsaInlandCostVO(String ibflag, String pagerows, String portLoc, String portNodCd, String hubNodCd, String locNodCd, String mtyPkupRtnYdCd, String rcvDeTermCd, String rcvDeTermNm, String trspCrrModCd, String loclIpiSvcMod, String loclIpiSvcModNm, String currCd, String rf20ftTtlCostAmt, String rf40ftTtlCostAmt, String inlnd20ftTtlAmt, String inlnd40ftTtlAmt, String rail20ftTtlAmt, String rail40ftTtlAmt, String trk20ftTtlAmt, String trk40ftTtlAmt, String sccCd, String mb20ftRto, String mb40ftRto, String rail20ftBzcCostSrcCd, String rail20ftBzcCostAmt, String rail20ftBzcCostAdjAmt, String rail20ftBzcCostTtlAmt, String rail20ftBzcAgmtWgt, String rail20ftBzcAgmtWyTpCd, String rail20ftFuelScgSrcCd, String rail20ftFuelScgAmt, String rail20ftFuelScgAdjAmt, String rail20ftFuelScgTtlAmt, String rail20ftFuelScgAgmtWgt, String rail20ftFuelAgmtWyTpCd, String rail40ftBzcCostSrcCd, String rail40ftBzcCostAmt, String rail40ftBzcCostAdjAmt, String rail40ftBzcCostTtlAmt, String rail40ftBzcAgmtWgt, String rail40ftBzcAgmtWyTpCd, String rail40ftFuelScgSrcCd, String rail40ftFuelScgAmt, String rail40ftFuelScgAdjAmt, String rail40ftFuelScgTtlAmt, String rail40ftFuelScgAgmtWgt, String rail40ftFuelAgmtWyTpCd, String trk20ftBzcCostSrcCd, String trk20ftBzcCostAmt, String trk20ftBzcCostAdjAmt, String trk20ftBzcCostTtlAmt, String trspAgmt20ftMtyYdCd, String trspDiff20ft, String trk20ftBzcAgmtWgt, String trk20ftBzcAgmtWyTpCd, String trk20ftFuelScgSrcCd, String trk20ftFuelScgAmt, String trk20ftFuelScgAdjAmt, String trk20ftFuelScgTtlAmt, String trk20ftFuelScgAgmtWgt, String trk20ftFuelAgmtWyTpCd, String trk40ftBzcCostSrcCd, String trk40ftBzcCostAmt, String trk40ftBzcCostAdjAmt, String trk40ftBzcCostTtlAmt, String trspAgmt40ftMtyYdCd, String trspDiff40ft, String trk40ftBzcAgmtWgt, String trk40ftBzcAgmtWyTpCd, String trk40ftFuelScgSrcCd, String trk40ftFuelScgAmt, String trk40ftFuelScgAdjAmt, String trk40ftFuelScgTtlAmt, String trk40ftFuelScgAgmtWgt, String trk40ftFuelAgmtWyTpCd, String mtyTrsp20ftCostSrcCd, String mtyTrsp20ftCostAmt, String mtyTrsp20ftAdjCostAmt, String mtyTrsp20ftTtlCostAmt, String mtyTrsp40ftCostSrcCd, String mtyTrsp40ftCostAmt, String mtyTrsp40ftAdjCostAmt, String mtyTrsp40ftTtlCostAmt, String dmst20ftCostSrcCd, String dmst20ftCostAmt, String dmst20ftAdjCostAmt, String dmst20ftTtlCostAmt, String dmst40ftCostSrcCd, String dmst40ftCostAmt, String dmst40ftAdjCostAmt, String dmst40ftTtlCostAmt, String tml20ftCostSrcCd, String tml20ftCostAmt, String tml20ftAdjCostAmt, String tml20ftTtlCostAmt, String tml40ftCostSrcCd, String tml40ftCostAmt, String tml40ftAdjCostAmt, String tml40ftTtlCostAmt, String n1stVndrSeq, String n1stVndrNm, String n1stInlndRoutCmbFlg, String n2ndVndrSeq, String n2ndVndrNm, String n2ndInlndRoutCmbFlg, String n3rdVndrSeq, String n3rdVndrNm, String agmtOldFlg, String costTrfRoutSeq, String costRoutGrpNo, String cntCd, String costTrfNo, String updUsrId, String costTrfRfSeq, String tollFeeAmt20, String tollFeeAmt40) {
		this.dmst20ftCostSrcCd = dmst20ftCostSrcCd;
		this.rail20ftFuelScgTtlAmt = rail20ftFuelScgTtlAmt;
		this.costRoutGrpNo = costRoutGrpNo;
		this.rail40ftBzcAgmtWyTpCd = rail40ftBzcAgmtWyTpCd;
		this.rail40ftBzcCostAmt = rail40ftBzcCostAmt;
		this.rail20ftBzcCostAmt = rail20ftBzcCostAmt;
		this.pagerows = pagerows;
		this.trk20ftBzcCostAdjAmt = trk20ftBzcCostAdjAmt;
		this.rail20ftFuelScgSrcCd = rail20ftFuelScgSrcCd;
		this.cntCd = cntCd;
		this.trk20ftBzcCostTtlAmt = trk20ftBzcCostTtlAmt;
		this.trk40ftBzcAgmtWyTpCd = trk40ftBzcAgmtWyTpCd;
		this.mtyTrsp20ftTtlCostAmt = mtyTrsp20ftTtlCostAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.trk20ftFuelScgAgmtWgt = trk20ftFuelScgAgmtWgt;
		this.updUsrId = updUsrId;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.mtyTrsp20ftCostSrcCd = mtyTrsp20ftCostSrcCd;
		this.inlnd20ftTtlAmt = inlnd20ftTtlAmt;
		this.costTrfNo = costTrfNo;
		this.rf40ftTtlCostAmt = rf40ftTtlCostAmt;
		this.rail40ftFuelScgAgmtWgt = rail40ftFuelScgAgmtWgt;
		this.trk40ftBzcCostTtlAmt = trk40ftBzcCostTtlAmt;
		this.trk20ftBzcAgmtWyTpCd = trk20ftBzcAgmtWyTpCd;
		this.rail20ftBzcCostAdjAmt = rail20ftBzcCostAdjAmt;
		this.portLoc = portLoc;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.locNodCd = locNodCd;
		this.trk20ftFuelScgSrcCd = trk20ftFuelScgSrcCd;
		this.trk40ftFuelScgAdjAmt = trk40ftFuelScgAdjAmt;
		this.mb20ftRto = mb20ftRto;
		this.trspAgmt40ftMtyYdCd = trspAgmt40ftMtyYdCd;
		this.tml40ftTtlCostAmt = tml40ftTtlCostAmt;
		this.trk20ftFuelAgmtWyTpCd = trk20ftFuelAgmtWyTpCd;
		this.trk20ftFuelScgAdjAmt = trk20ftFuelScgAdjAmt;
		this.mtyTrsp40ftCostSrcCd = mtyTrsp40ftCostSrcCd;
		this.trk40ftFuelScgAgmtWgt = trk40ftFuelScgAgmtWgt;
		this.trk40ftFuelAgmtWyTpCd = trk40ftFuelAgmtWyTpCd;
		this.rail20ftFuelScgAgmtWgt = rail20ftFuelScgAgmtWgt;
		this.rail40ftTtlAmt = rail40ftTtlAmt;
		this.trspCrrModCd = trspCrrModCd;
		this.tollFeeAmt20 = tollFeeAmt20;
		this.trk40ftFuelScgTtlAmt = trk40ftFuelScgTtlAmt;
		this.trk20ftBzcCostAmt = trk20ftBzcCostAmt;
		this.trspDiff40ft = trspDiff40ft;
		this.costTrfRfSeq = costTrfRfSeq;
		this.loclIpiSvcModNm = loclIpiSvcModNm;
		this.n2ndInlndRoutCmbFlg = n2ndInlndRoutCmbFlg;
		this.inlnd40ftTtlAmt = inlnd40ftTtlAmt;
		this.dmst20ftCostAmt = dmst20ftCostAmt;
		this.rail40ftBzcCostSrcCd = rail40ftBzcCostSrcCd;
		this.hubNodCd = hubNodCd;
		this.rail20ftBzcAgmtWgt = rail20ftBzcAgmtWgt;
		this.mtyTrsp40ftTtlCostAmt = mtyTrsp40ftTtlCostAmt;
		this.dmst20ftAdjCostAmt = dmst20ftAdjCostAmt;
		this.sccCd = sccCd;
		this.portNodCd = portNodCd;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.rail20ftFuelAgmtWyTpCd = rail20ftFuelAgmtWyTpCd;
		this.tml20ftTtlCostAmt = tml20ftTtlCostAmt;
		this.agmtOldFlg = agmtOldFlg;
		this.n2ndVndrNm = n2ndVndrNm;
		this.dmst40ftCostAmt = dmst40ftCostAmt;
		this.dmst20ftTtlCostAmt = dmst20ftTtlCostAmt;
		this.trk20ftFuelScgTtlAmt = trk20ftFuelScgTtlAmt;
		this.trk40ftBzcCostAmt = trk40ftBzcCostAmt;
		this.tml40ftCostSrcCd = tml40ftCostSrcCd;
		this.dmst40ftCostSrcCd = dmst40ftCostSrcCd;
		this.n1stInlndRoutCmbFlg = n1stInlndRoutCmbFlg;
		this.costTrfRoutSeq = costTrfRoutSeq;
		this.tollFeeAmt40 = tollFeeAmt40;
		this.trk40ftBzcCostSrcCd = trk40ftBzcCostSrcCd;
		this.rail40ftBzcAgmtWgt = rail40ftBzcAgmtWgt;
		this.trk20ftBzcCostSrcCd = trk20ftBzcCostSrcCd;
		this.rail40ftFuelScgTtlAmt = rail40ftFuelScgTtlAmt;
		this.rail20ftFuelScgAmt = rail20ftFuelScgAmt;
		this.n2ndVndrSeq = n2ndVndrSeq;
		this.rail20ftBzcAgmtWyTpCd = rail20ftBzcAgmtWyTpCd;
		this.trspAgmt20ftMtyYdCd = trspAgmt20ftMtyYdCd;
		this.trk20ftFuelScgAmt = trk20ftFuelScgAmt;
		this.trk20ftBzcAgmtWgt = trk20ftBzcAgmtWgt;
		this.tml20ftCostSrcCd = tml20ftCostSrcCd;
		this.trspDiff20ft = trspDiff20ft;
		this.trk40ftTtlAmt = trk40ftTtlAmt;
		this.loclIpiSvcMod = loclIpiSvcMod;
		this.mtyTrsp40ftAdjCostAmt = mtyTrsp40ftAdjCostAmt;
		this.rail20ftFuelScgAdjAmt = rail20ftFuelScgAdjAmt;
		this.rcvDeTermNm = rcvDeTermNm;
		this.rail20ftBzcCostTtlAmt = rail20ftBzcCostTtlAmt;
		this.currCd = currCd;
		this.dmst40ftTtlCostAmt = dmst40ftTtlCostAmt;
		this.rail20ftTtlAmt = rail20ftTtlAmt;
		this.rail20ftBzcCostSrcCd = rail20ftBzcCostSrcCd;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.mtyTrsp20ftAdjCostAmt = mtyTrsp20ftAdjCostAmt;
		this.tml20ftAdjCostAmt = tml20ftAdjCostAmt;
		this.rail40ftFuelScgSrcCd = rail40ftFuelScgSrcCd;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.n1stVndrSeq = n1stVndrSeq;
		this.rail40ftBzcCostAdjAmt = rail40ftBzcCostAdjAmt;
		this.rf20ftTtlCostAmt = rf20ftTtlCostAmt;
		this.dmst40ftAdjCostAmt = dmst40ftAdjCostAmt;
		this.n1stVndrNm = n1stVndrNm;
		this.mtyPkupRtnYdCd = mtyPkupRtnYdCd;
		this.rail40ftFuelScgAmt = rail40ftFuelScgAmt;
		this.n3rdVndrSeq = n3rdVndrSeq;
		this.trk20ftTtlAmt = trk20ftTtlAmt;
		this.tml40ftAdjCostAmt = tml40ftAdjCostAmt;
		this.n3rdVndrNm = n3rdVndrNm;
		this.trk40ftFuelScgSrcCd = trk40ftFuelScgSrcCd;
		this.rail40ftFuelAgmtWyTpCd = rail40ftFuelAgmtWyTpCd;
		this.trk40ftBzcCostAdjAmt = trk40ftBzcCostAdjAmt;
		this.trk40ftBzcAgmtWgt = trk40ftBzcAgmtWgt;
		this.trk40ftFuelScgAmt = trk40ftFuelScgAmt;
		this.rail40ftFuelScgAdjAmt = rail40ftFuelScgAdjAmt;
		this.rail40ftBzcCostTtlAmt = rail40ftBzcCostTtlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmst_20ft_cost_src_cd", getDmst20ftCostSrcCd());
		this.hashColumns.put("rail_20ft_fuel_scg_ttl_amt", getRail20ftFuelScgTtlAmt());
		this.hashColumns.put("cost_rout_grp_no", getCostRoutGrpNo());
		this.hashColumns.put("rail_40ft_bzc_agmt_wy_tp_cd", getRail40ftBzcAgmtWyTpCd());
		this.hashColumns.put("rail_40ft_bzc_cost_amt", getRail40ftBzcCostAmt());
		this.hashColumns.put("rail_20ft_bzc_cost_amt", getRail20ftBzcCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trk_20ft_bzc_cost_adj_amt", getTrk20ftBzcCostAdjAmt());
		this.hashColumns.put("rail_20ft_fuel_scg_src_cd", getRail20ftFuelScgSrcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("trk_20ft_bzc_cost_ttl_amt", getTrk20ftBzcCostTtlAmt());
		this.hashColumns.put("trk_40ft_bzc_agmt_wy_tp_cd", getTrk40ftBzcAgmtWyTpCd());
		this.hashColumns.put("mty_trsp_20ft_ttl_cost_amt", getMtyTrsp20ftTtlCostAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("trk_20ft_fuel_scg_agmt_wgt", getTrk20ftFuelScgAgmtWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("mty_trsp_20ft_cost_src_cd", getMtyTrsp20ftCostSrcCd());
		this.hashColumns.put("inlnd_20ft_ttl_amt", getInlnd20ftTtlAmt());
		this.hashColumns.put("cost_trf_no", getCostTrfNo());
		this.hashColumns.put("rf_40ft_ttl_cost_amt", getRf40ftTtlCostAmt());
		this.hashColumns.put("rail_40ft_fuel_scg_agmt_wgt", getRail40ftFuelScgAgmtWgt());
		this.hashColumns.put("trk_40ft_bzc_cost_ttl_amt", getTrk40ftBzcCostTtlAmt());
		this.hashColumns.put("trk_20ft_bzc_agmt_wy_tp_cd", getTrk20ftBzcAgmtWyTpCd());
		this.hashColumns.put("rail_20ft_bzc_cost_adj_amt", getRail20ftBzcCostAdjAmt());
		this.hashColumns.put("port_loc", getPortLoc());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("loc_nod_cd", getLocNodCd());
		this.hashColumns.put("trk_20ft_fuel_scg_src_cd", getTrk20ftFuelScgSrcCd());
		this.hashColumns.put("trk_40ft_fuel_scg_adj_amt", getTrk40ftFuelScgAdjAmt());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("trsp_agmt_40ft_mty_yd_cd", getTrspAgmt40ftMtyYdCd());
		this.hashColumns.put("tml_40ft_ttl_cost_amt", getTml40ftTtlCostAmt());
		this.hashColumns.put("trk_20ft_fuel_agmt_wy_tp_cd", getTrk20ftFuelAgmtWyTpCd());
		this.hashColumns.put("trk_20ft_fuel_scg_adj_amt", getTrk20ftFuelScgAdjAmt());
		this.hashColumns.put("mty_trsp_40ft_cost_src_cd", getMtyTrsp40ftCostSrcCd());
		this.hashColumns.put("trk_40ft_fuel_scg_agmt_wgt", getTrk40ftFuelScgAgmtWgt());
		this.hashColumns.put("trk_40ft_fuel_agmt_wy_tp_cd", getTrk40ftFuelAgmtWyTpCd());
		this.hashColumns.put("rail_20ft_fuel_scg_agmt_wgt", getRail20ftFuelScgAgmtWgt());
		this.hashColumns.put("rail_40ft_ttl_amt", getRail40ftTtlAmt());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("toll_fee_amt_20", getTollFeeAmt20());
		this.hashColumns.put("trk_40ft_fuel_scg_ttl_amt", getTrk40ftFuelScgTtlAmt());
		this.hashColumns.put("trk_20ft_bzc_cost_amt", getTrk20ftBzcCostAmt());
		this.hashColumns.put("trsp_diff_40ft", getTrspDiff40ft());
		this.hashColumns.put("cost_trf_rf_seq", getCostTrfRfSeq());
		this.hashColumns.put("locl_ipi_svc_mod_nm", getLoclIpiSvcModNm());
		this.hashColumns.put("n2nd_inlnd_rout_cmb_flg", getN2ndInlndRoutCmbFlg());
		this.hashColumns.put("inlnd_40ft_ttl_amt", getInlnd40ftTtlAmt());
		this.hashColumns.put("dmst_20ft_cost_amt", getDmst20ftCostAmt());
		this.hashColumns.put("rail_40ft_bzc_cost_src_cd", getRail40ftBzcCostSrcCd());
		this.hashColumns.put("hub_nod_cd", getHubNodCd());
		this.hashColumns.put("rail_20ft_bzc_agmt_wgt", getRail20ftBzcAgmtWgt());
		this.hashColumns.put("mty_trsp_40ft_ttl_cost_amt", getMtyTrsp40ftTtlCostAmt());
		this.hashColumns.put("dmst_20ft_adj_cost_amt", getDmst20ftAdjCostAmt());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("port_nod_cd", getPortNodCd());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("rail_20ft_fuel_agmt_wy_tp_cd", getRail20ftFuelAgmtWyTpCd());
		this.hashColumns.put("tml_20ft_ttl_cost_amt", getTml20ftTtlCostAmt());
		this.hashColumns.put("agmt_old_flg", getAgmtOldFlg());
		this.hashColumns.put("n2nd_vndr_nm", getN2ndVndrNm());
		this.hashColumns.put("dmst_40ft_cost_amt", getDmst40ftCostAmt());
		this.hashColumns.put("dmst_20ft_ttl_cost_amt", getDmst20ftTtlCostAmt());
		this.hashColumns.put("trk_20ft_fuel_scg_ttl_amt", getTrk20ftFuelScgTtlAmt());
		this.hashColumns.put("trk_40ft_bzc_cost_amt", getTrk40ftBzcCostAmt());
		this.hashColumns.put("tml_40ft_cost_src_cd", getTml40ftCostSrcCd());
		this.hashColumns.put("dmst_40ft_cost_src_cd", getDmst40ftCostSrcCd());
		this.hashColumns.put("n1st_inlnd_rout_cmb_flg", getN1stInlndRoutCmbFlg());
		this.hashColumns.put("cost_trf_rout_seq", getCostTrfRoutSeq());
		this.hashColumns.put("toll_fee_amt_40", getTollFeeAmt40());
		this.hashColumns.put("trk_40ft_bzc_cost_src_cd", getTrk40ftBzcCostSrcCd());
		this.hashColumns.put("rail_40ft_bzc_agmt_wgt", getRail40ftBzcAgmtWgt());
		this.hashColumns.put("trk_20ft_bzc_cost_src_cd", getTrk20ftBzcCostSrcCd());
		this.hashColumns.put("rail_40ft_fuel_scg_ttl_amt", getRail40ftFuelScgTtlAmt());
		this.hashColumns.put("rail_20ft_fuel_scg_amt", getRail20ftFuelScgAmt());
		this.hashColumns.put("n2nd_vndr_seq", getN2ndVndrSeq());
		this.hashColumns.put("rail_20ft_bzc_agmt_wy_tp_cd", getRail20ftBzcAgmtWyTpCd());
		this.hashColumns.put("trsp_agmt_20ft_mty_yd_cd", getTrspAgmt20ftMtyYdCd());
		this.hashColumns.put("trk_20ft_fuel_scg_amt", getTrk20ftFuelScgAmt());
		this.hashColumns.put("trk_20ft_bzc_agmt_wgt", getTrk20ftBzcAgmtWgt());
		this.hashColumns.put("tml_20ft_cost_src_cd", getTml20ftCostSrcCd());
		this.hashColumns.put("trsp_diff_20ft", getTrspDiff20ft());
		this.hashColumns.put("trk_40ft_ttl_amt", getTrk40ftTtlAmt());
		this.hashColumns.put("locl_ipi_svc_mod", getLoclIpiSvcMod());
		this.hashColumns.put("mty_trsp_40ft_adj_cost_amt", getMtyTrsp40ftAdjCostAmt());
		this.hashColumns.put("rail_20ft_fuel_scg_adj_amt", getRail20ftFuelScgAdjAmt());
		this.hashColumns.put("rcv_de_term_nm", getRcvDeTermNm());
		this.hashColumns.put("rail_20ft_bzc_cost_ttl_amt", getRail20ftBzcCostTtlAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dmst_40ft_ttl_cost_amt", getDmst40ftTtlCostAmt());
		this.hashColumns.put("rail_20ft_ttl_amt", getRail20ftTtlAmt());
		this.hashColumns.put("rail_20ft_bzc_cost_src_cd", getRail20ftBzcCostSrcCd());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("mty_trsp_20ft_adj_cost_amt", getMtyTrsp20ftAdjCostAmt());
		this.hashColumns.put("tml_20ft_adj_cost_amt", getTml20ftAdjCostAmt());
		this.hashColumns.put("rail_40ft_fuel_scg_src_cd", getRail40ftFuelScgSrcCd());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n1st_vndr_seq", getN1stVndrSeq());
		this.hashColumns.put("rail_40ft_bzc_cost_adj_amt", getRail40ftBzcCostAdjAmt());
		this.hashColumns.put("rf_20ft_ttl_cost_amt", getRf20ftTtlCostAmt());
		this.hashColumns.put("dmst_40ft_adj_cost_amt", getDmst40ftAdjCostAmt());
		this.hashColumns.put("n1st_vndr_nm", getN1stVndrNm());
		this.hashColumns.put("mty_pkup_rtn_yd_cd", getMtyPkupRtnYdCd());
		this.hashColumns.put("rail_40ft_fuel_scg_amt", getRail40ftFuelScgAmt());
		this.hashColumns.put("n3rd_vndr_seq", getN3rdVndrSeq());
		this.hashColumns.put("trk_20ft_ttl_amt", getTrk20ftTtlAmt());
		this.hashColumns.put("tml_40ft_adj_cost_amt", getTml40ftAdjCostAmt());
		this.hashColumns.put("n3rd_vndr_nm", getN3rdVndrNm());
		this.hashColumns.put("trk_40ft_fuel_scg_src_cd", getTrk40ftFuelScgSrcCd());
		this.hashColumns.put("rail_40ft_fuel_agmt_wy_tp_cd", getRail40ftFuelAgmtWyTpCd());
		this.hashColumns.put("trk_40ft_bzc_cost_adj_amt", getTrk40ftBzcCostAdjAmt());
		this.hashColumns.put("trk_40ft_bzc_agmt_wgt", getTrk40ftBzcAgmtWgt());
		this.hashColumns.put("trk_40ft_fuel_scg_amt", getTrk40ftFuelScgAmt());
		this.hashColumns.put("rail_40ft_fuel_scg_adj_amt", getRail40ftFuelScgAdjAmt());
		this.hashColumns.put("rail_40ft_bzc_cost_ttl_amt", getRail40ftBzcCostTtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmst_20ft_cost_src_cd", "dmst20ftCostSrcCd");
		this.hashFields.put("rail_20ft_fuel_scg_ttl_amt", "rail20ftFuelScgTtlAmt");
		this.hashFields.put("cost_rout_grp_no", "costRoutGrpNo");
		this.hashFields.put("rail_40ft_bzc_agmt_wy_tp_cd", "rail40ftBzcAgmtWyTpCd");
		this.hashFields.put("rail_40ft_bzc_cost_amt", "rail40ftBzcCostAmt");
		this.hashFields.put("rail_20ft_bzc_cost_amt", "rail20ftBzcCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trk_20ft_bzc_cost_adj_amt", "trk20ftBzcCostAdjAmt");
		this.hashFields.put("rail_20ft_fuel_scg_src_cd", "rail20ftFuelScgSrcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("trk_20ft_bzc_cost_ttl_amt", "trk20ftBzcCostTtlAmt");
		this.hashFields.put("trk_40ft_bzc_agmt_wy_tp_cd", "trk40ftBzcAgmtWyTpCd");
		this.hashFields.put("mty_trsp_20ft_ttl_cost_amt", "mtyTrsp20ftTtlCostAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("trk_20ft_fuel_scg_agmt_wgt", "trk20ftFuelScgAgmtWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("mty_trsp_20ft_cost_src_cd", "mtyTrsp20ftCostSrcCd");
		this.hashFields.put("inlnd_20ft_ttl_amt", "inlnd20ftTtlAmt");
		this.hashFields.put("cost_trf_no", "costTrfNo");
		this.hashFields.put("rf_40ft_ttl_cost_amt", "rf40ftTtlCostAmt");
		this.hashFields.put("rail_40ft_fuel_scg_agmt_wgt", "rail40ftFuelScgAgmtWgt");
		this.hashFields.put("trk_40ft_bzc_cost_ttl_amt", "trk40ftBzcCostTtlAmt");
		this.hashFields.put("trk_20ft_bzc_agmt_wy_tp_cd", "trk20ftBzcAgmtWyTpCd");
		this.hashFields.put("rail_20ft_bzc_cost_adj_amt", "rail20ftBzcCostAdjAmt");
		this.hashFields.put("port_loc", "portLoc");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("loc_nod_cd", "locNodCd");
		this.hashFields.put("trk_20ft_fuel_scg_src_cd", "trk20ftFuelScgSrcCd");
		this.hashFields.put("trk_40ft_fuel_scg_adj_amt", "trk40ftFuelScgAdjAmt");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("trsp_agmt_40ft_mty_yd_cd", "trspAgmt40ftMtyYdCd");
		this.hashFields.put("tml_40ft_ttl_cost_amt", "tml40ftTtlCostAmt");
		this.hashFields.put("trk_20ft_fuel_agmt_wy_tp_cd", "trk20ftFuelAgmtWyTpCd");
		this.hashFields.put("trk_20ft_fuel_scg_adj_amt", "trk20ftFuelScgAdjAmt");
		this.hashFields.put("mty_trsp_40ft_cost_src_cd", "mtyTrsp40ftCostSrcCd");
		this.hashFields.put("trk_40ft_fuel_scg_agmt_wgt", "trk40ftFuelScgAgmtWgt");
		this.hashFields.put("trk_40ft_fuel_agmt_wy_tp_cd", "trk40ftFuelAgmtWyTpCd");
		this.hashFields.put("rail_20ft_fuel_scg_agmt_wgt", "rail20ftFuelScgAgmtWgt");
		this.hashFields.put("rail_40ft_ttl_amt", "rail40ftTtlAmt");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("toll_fee_amt_20", "tollFeeAmt20");
		this.hashFields.put("trk_40ft_fuel_scg_ttl_amt", "trk40ftFuelScgTtlAmt");
		this.hashFields.put("trk_20ft_bzc_cost_amt", "trk20ftBzcCostAmt");
		this.hashFields.put("trsp_diff_40ft", "trspDiff40ft");
		this.hashFields.put("cost_trf_rf_seq", "costTrfRfSeq");
		this.hashFields.put("locl_ipi_svc_mod_nm", "loclIpiSvcModNm");
		this.hashFields.put("n2nd_inlnd_rout_cmb_flg", "n2ndInlndRoutCmbFlg");
		this.hashFields.put("inlnd_40ft_ttl_amt", "inlnd40ftTtlAmt");
		this.hashFields.put("dmst_20ft_cost_amt", "dmst20ftCostAmt");
		this.hashFields.put("rail_40ft_bzc_cost_src_cd", "rail40ftBzcCostSrcCd");
		this.hashFields.put("hub_nod_cd", "hubNodCd");
		this.hashFields.put("rail_20ft_bzc_agmt_wgt", "rail20ftBzcAgmtWgt");
		this.hashFields.put("mty_trsp_40ft_ttl_cost_amt", "mtyTrsp40ftTtlCostAmt");
		this.hashFields.put("dmst_20ft_adj_cost_amt", "dmst20ftAdjCostAmt");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("port_nod_cd", "portNodCd");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("rail_20ft_fuel_agmt_wy_tp_cd", "rail20ftFuelAgmtWyTpCd");
		this.hashFields.put("tml_20ft_ttl_cost_amt", "tml20ftTtlCostAmt");
		this.hashFields.put("agmt_old_flg", "agmtOldFlg");
		this.hashFields.put("n2nd_vndr_nm", "n2ndVndrNm");
		this.hashFields.put("dmst_40ft_cost_amt", "dmst40ftCostAmt");
		this.hashFields.put("dmst_20ft_ttl_cost_amt", "dmst20ftTtlCostAmt");
		this.hashFields.put("trk_20ft_fuel_scg_ttl_amt", "trk20ftFuelScgTtlAmt");
		this.hashFields.put("trk_40ft_bzc_cost_amt", "trk40ftBzcCostAmt");
		this.hashFields.put("tml_40ft_cost_src_cd", "tml40ftCostSrcCd");
		this.hashFields.put("dmst_40ft_cost_src_cd", "dmst40ftCostSrcCd");
		this.hashFields.put("n1st_inlnd_rout_cmb_flg", "n1stInlndRoutCmbFlg");
		this.hashFields.put("cost_trf_rout_seq", "costTrfRoutSeq");
		this.hashFields.put("toll_fee_amt_40", "tollFeeAmt40");
		this.hashFields.put("trk_40ft_bzc_cost_src_cd", "trk40ftBzcCostSrcCd");
		this.hashFields.put("rail_40ft_bzc_agmt_wgt", "rail40ftBzcAgmtWgt");
		this.hashFields.put("trk_20ft_bzc_cost_src_cd", "trk20ftBzcCostSrcCd");
		this.hashFields.put("rail_40ft_fuel_scg_ttl_amt", "rail40ftFuelScgTtlAmt");
		this.hashFields.put("rail_20ft_fuel_scg_amt", "rail20ftFuelScgAmt");
		this.hashFields.put("n2nd_vndr_seq", "n2ndVndrSeq");
		this.hashFields.put("rail_20ft_bzc_agmt_wy_tp_cd", "rail20ftBzcAgmtWyTpCd");
		this.hashFields.put("trsp_agmt_20ft_mty_yd_cd", "trspAgmt20ftMtyYdCd");
		this.hashFields.put("trk_20ft_fuel_scg_amt", "trk20ftFuelScgAmt");
		this.hashFields.put("trk_20ft_bzc_agmt_wgt", "trk20ftBzcAgmtWgt");
		this.hashFields.put("tml_20ft_cost_src_cd", "tml20ftCostSrcCd");
		this.hashFields.put("trsp_diff_20ft", "trspDiff20ft");
		this.hashFields.put("trk_40ft_ttl_amt", "trk40ftTtlAmt");
		this.hashFields.put("locl_ipi_svc_mod", "loclIpiSvcMod");
		this.hashFields.put("mty_trsp_40ft_adj_cost_amt", "mtyTrsp40ftAdjCostAmt");
		this.hashFields.put("rail_20ft_fuel_scg_adj_amt", "rail20ftFuelScgAdjAmt");
		this.hashFields.put("rcv_de_term_nm", "rcvDeTermNm");
		this.hashFields.put("rail_20ft_bzc_cost_ttl_amt", "rail20ftBzcCostTtlAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dmst_40ft_ttl_cost_amt", "dmst40ftTtlCostAmt");
		this.hashFields.put("rail_20ft_ttl_amt", "rail20ftTtlAmt");
		this.hashFields.put("rail_20ft_bzc_cost_src_cd", "rail20ftBzcCostSrcCd");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("mty_trsp_20ft_adj_cost_amt", "mtyTrsp20ftAdjCostAmt");
		this.hashFields.put("tml_20ft_adj_cost_amt", "tml20ftAdjCostAmt");
		this.hashFields.put("rail_40ft_fuel_scg_src_cd", "rail40ftFuelScgSrcCd");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n1st_vndr_seq", "n1stVndrSeq");
		this.hashFields.put("rail_40ft_bzc_cost_adj_amt", "rail40ftBzcCostAdjAmt");
		this.hashFields.put("rf_20ft_ttl_cost_amt", "rf20ftTtlCostAmt");
		this.hashFields.put("dmst_40ft_adj_cost_amt", "dmst40ftAdjCostAmt");
		this.hashFields.put("n1st_vndr_nm", "n1stVndrNm");
		this.hashFields.put("mty_pkup_rtn_yd_cd", "mtyPkupRtnYdCd");
		this.hashFields.put("rail_40ft_fuel_scg_amt", "rail40ftFuelScgAmt");
		this.hashFields.put("n3rd_vndr_seq", "n3rdVndrSeq");
		this.hashFields.put("trk_20ft_ttl_amt", "trk20ftTtlAmt");
		this.hashFields.put("tml_40ft_adj_cost_amt", "tml40ftAdjCostAmt");
		this.hashFields.put("n3rd_vndr_nm", "n3rdVndrNm");
		this.hashFields.put("trk_40ft_fuel_scg_src_cd", "trk40ftFuelScgSrcCd");
		this.hashFields.put("rail_40ft_fuel_agmt_wy_tp_cd", "rail40ftFuelAgmtWyTpCd");
		this.hashFields.put("trk_40ft_bzc_cost_adj_amt", "trk40ftBzcCostAdjAmt");
		this.hashFields.put("trk_40ft_bzc_agmt_wgt", "trk40ftBzcAgmtWgt");
		this.hashFields.put("trk_40ft_fuel_scg_amt", "trk40ftFuelScgAmt");
		this.hashFields.put("rail_40ft_fuel_scg_adj_amt", "rail40ftFuelScgAdjAmt");
		this.hashFields.put("rail_40ft_bzc_cost_ttl_amt", "rail40ftBzcCostTtlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmst20ftCostSrcCd
	 */
	public String getDmst20ftCostSrcCd() {
		return this.dmst20ftCostSrcCd;
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
	 * @return rail40ftBzcAgmtWyTpCd
	 */
	public String getRail40ftBzcAgmtWyTpCd() {
		return this.rail40ftBzcAgmtWyTpCd;
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
	 * @return rail20ftBzcCostAmt
	 */
	public String getRail20ftBzcCostAmt() {
		return this.rail20ftBzcCostAmt;
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
	 * @return rail20ftFuelScgSrcCd
	 */
	public String getRail20ftFuelScgSrcCd() {
		return this.rail20ftFuelScgSrcCd;
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
	 * @return trk20ftBzcCostTtlAmt
	 */
	public String getTrk20ftBzcCostTtlAmt() {
		return this.trk20ftBzcCostTtlAmt;
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
	 * @return mtyTrsp20ftCostSrcCd
	 */
	public String getMtyTrsp20ftCostSrcCd() {
		return this.mtyTrsp20ftCostSrcCd;
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
	 * @return rail40ftFuelScgAgmtWgt
	 */
	public String getRail40ftFuelScgAgmtWgt() {
		return this.rail40ftFuelScgAgmtWgt;
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
	 * @return trk20ftBzcAgmtWyTpCd
	 */
	public String getTrk20ftBzcAgmtWyTpCd() {
		return this.trk20ftBzcAgmtWyTpCd;
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
	 * @return portLoc
	 */
	public String getPortLoc() {
		return this.portLoc;
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
	 * @return trk20ftFuelScgSrcCd
	 */
	public String getTrk20ftFuelScgSrcCd() {
		return this.trk20ftFuelScgSrcCd;
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
	 * @return tml40ftTtlCostAmt
	 */
	public String getTml40ftTtlCostAmt() {
		return this.tml40ftTtlCostAmt;
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
	 * @return trk20ftFuelScgAdjAmt
	 */
	public String getTrk20ftFuelScgAdjAmt() {
		return this.trk20ftFuelScgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrsp40ftCostSrcCd
	 */
	public String getMtyTrsp40ftCostSrcCd() {
		return this.mtyTrsp40ftCostSrcCd;
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
	 * @return rail40ftTtlAmt
	 */
	public String getRail40ftTtlAmt() {
		return this.rail40ftTtlAmt;
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
	 * @return costTrfRfSeq
	 */
	public String getCostTrfRfSeq() {
		return this.costTrfRfSeq;
	}
	
	/**
	 * Column Info
	 * @return loclIpiSvcModNm
	 */
	public String getLoclIpiSvcModNm() {
		return this.loclIpiSvcModNm;
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
	 * @return rail40ftBzcCostSrcCd
	 */
	public String getRail40ftBzcCostSrcCd() {
		return this.rail40ftBzcCostSrcCd;
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
	 * @return rail20ftBzcAgmtWgt
	 */
	public String getRail20ftBzcAgmtWgt() {
		return this.rail20ftBzcAgmtWgt;
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
	 * @return dmst20ftAdjCostAmt
	 */
	public String getDmst20ftAdjCostAmt() {
		return this.dmst20ftAdjCostAmt;
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
	 * @return n2ndVndrNm
	 */
	public String getN2ndVndrNm() {
		return this.n2ndVndrNm;
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
	 * @return dmst20ftTtlCostAmt
	 */
	public String getDmst20ftTtlCostAmt() {
		return this.dmst20ftTtlCostAmt;
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
	 * @return trk40ftBzcCostAmt
	 */
	public String getTrk40ftBzcCostAmt() {
		return this.trk40ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tml40ftCostSrcCd
	 */
	public String getTml40ftCostSrcCd() {
		return this.tml40ftCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return dmst40ftCostSrcCd
	 */
	public String getDmst40ftCostSrcCd() {
		return this.dmst40ftCostSrcCd;
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
	 * Column Info
	 * @return tollFeeAmt40
	 */
	public String getTollFeeAmt40() {
		return this.tollFeeAmt40;
	}
	
	/**
	 * Column Info
	 * @return trk40ftBzcCostSrcCd
	 */
	public String getTrk40ftBzcCostSrcCd() {
		return this.trk40ftBzcCostSrcCd;
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
	 * @return trk20ftBzcCostSrcCd
	 */
	public String getTrk20ftBzcCostSrcCd() {
		return this.trk20ftBzcCostSrcCd;
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
	 * @return rail20ftFuelScgAmt
	 */
	public String getRail20ftFuelScgAmt() {
		return this.rail20ftFuelScgAmt;
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
	 * @return trk20ftBzcAgmtWgt
	 */
	public String getTrk20ftBzcAgmtWgt() {
		return this.trk20ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @return tml20ftCostSrcCd
	 */
	public String getTml20ftCostSrcCd() {
		return this.tml20ftCostSrcCd;
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
	 * @return trk40ftTtlAmt
	 */
	public String getTrk40ftTtlAmt() {
		return this.trk40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return loclIpiSvcMod
	 */
	public String getLoclIpiSvcMod() {
		return this.loclIpiSvcMod;
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
	 * @return dmst40ftTtlCostAmt
	 */
	public String getDmst40ftTtlCostAmt() {
		return this.dmst40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rail20ftTtlAmt
	 */
	public String getRail20ftTtlAmt() {
		return this.rail20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return rail20ftBzcCostSrcCd
	 */
	public String getRail20ftBzcCostSrcCd() {
		return this.rail20ftBzcCostSrcCd;
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
	 * @return rail40ftFuelScgSrcCd
	 */
	public String getRail40ftFuelScgSrcCd() {
		return this.rail40ftFuelScgSrcCd;
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
	 * @return n1stVndrSeq
	 */
	public String getN1stVndrSeq() {
		return this.n1stVndrSeq;
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
	 * @return rf20ftTtlCostAmt
	 */
	public String getRf20ftTtlCostAmt() {
		return this.rf20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return dmst40ftAdjCostAmt
	 */
	public String getDmst40ftAdjCostAmt() {
		return this.dmst40ftAdjCostAmt;
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
	 * @return rail40ftFuelScgAmt
	 */
	public String getRail40ftFuelScgAmt() {
		return this.rail40ftFuelScgAmt;
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
	 * @return trk20ftTtlAmt
	 */
	public String getTrk20ftTtlAmt() {
		return this.trk20ftTtlAmt;
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
	 * @return n3rdVndrNm
	 */
	public String getN3rdVndrNm() {
		return this.n3rdVndrNm;
	}
	
	/**
	 * Column Info
	 * @return trk40ftFuelScgSrcCd
	 */
	public String getTrk40ftFuelScgSrcCd() {
		return this.trk40ftFuelScgSrcCd;
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
	 * @return trk40ftBzcCostAdjAmt
	 */
	public String getTrk40ftBzcCostAdjAmt() {
		return this.trk40ftBzcCostAdjAmt;
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
	 * @return rail40ftBzcCostTtlAmt
	 */
	public String getRail40ftBzcCostTtlAmt() {
		return this.rail40ftBzcCostTtlAmt;
	}
	

	/**
	 * Column Info
	 * @param dmst20ftCostSrcCd
	 */
	public void setDmst20ftCostSrcCd(String dmst20ftCostSrcCd) {
		this.dmst20ftCostSrcCd = dmst20ftCostSrcCd;
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
	 * @param rail40ftBzcAgmtWyTpCd
	 */
	public void setRail40ftBzcAgmtWyTpCd(String rail40ftBzcAgmtWyTpCd) {
		this.rail40ftBzcAgmtWyTpCd = rail40ftBzcAgmtWyTpCd;
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
	 * @param rail20ftBzcCostAmt
	 */
	public void setRail20ftBzcCostAmt(String rail20ftBzcCostAmt) {
		this.rail20ftBzcCostAmt = rail20ftBzcCostAmt;
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
	 * @param rail20ftFuelScgSrcCd
	 */
	public void setRail20ftFuelScgSrcCd(String rail20ftFuelScgSrcCd) {
		this.rail20ftFuelScgSrcCd = rail20ftFuelScgSrcCd;
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
	 * @param trk20ftBzcCostTtlAmt
	 */
	public void setTrk20ftBzcCostTtlAmt(String trk20ftBzcCostTtlAmt) {
		this.trk20ftBzcCostTtlAmt = trk20ftBzcCostTtlAmt;
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
	 * @param mtyTrsp20ftCostSrcCd
	 */
	public void setMtyTrsp20ftCostSrcCd(String mtyTrsp20ftCostSrcCd) {
		this.mtyTrsp20ftCostSrcCd = mtyTrsp20ftCostSrcCd;
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
	 * @param rail40ftFuelScgAgmtWgt
	 */
	public void setRail40ftFuelScgAgmtWgt(String rail40ftFuelScgAgmtWgt) {
		this.rail40ftFuelScgAgmtWgt = rail40ftFuelScgAgmtWgt;
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
	 * @param trk20ftBzcAgmtWyTpCd
	 */
	public void setTrk20ftBzcAgmtWyTpCd(String trk20ftBzcAgmtWyTpCd) {
		this.trk20ftBzcAgmtWyTpCd = trk20ftBzcAgmtWyTpCd;
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
	 * @param portLoc
	 */
	public void setPortLoc(String portLoc) {
		this.portLoc = portLoc;
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
	 * @param trk20ftFuelScgSrcCd
	 */
	public void setTrk20ftFuelScgSrcCd(String trk20ftFuelScgSrcCd) {
		this.trk20ftFuelScgSrcCd = trk20ftFuelScgSrcCd;
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
	 * @param tml40ftTtlCostAmt
	 */
	public void setTml40ftTtlCostAmt(String tml40ftTtlCostAmt) {
		this.tml40ftTtlCostAmt = tml40ftTtlCostAmt;
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
	 * @param trk20ftFuelScgAdjAmt
	 */
	public void setTrk20ftFuelScgAdjAmt(String trk20ftFuelScgAdjAmt) {
		this.trk20ftFuelScgAdjAmt = trk20ftFuelScgAdjAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrsp40ftCostSrcCd
	 */
	public void setMtyTrsp40ftCostSrcCd(String mtyTrsp40ftCostSrcCd) {
		this.mtyTrsp40ftCostSrcCd = mtyTrsp40ftCostSrcCd;
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
	 * @param rail40ftTtlAmt
	 */
	public void setRail40ftTtlAmt(String rail40ftTtlAmt) {
		this.rail40ftTtlAmt = rail40ftTtlAmt;
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
	 * @param costTrfRfSeq
	 */
	public void setCostTrfRfSeq(String costTrfRfSeq) {
		this.costTrfRfSeq = costTrfRfSeq;
	}
	
	/**
	 * Column Info
	 * @param loclIpiSvcModNm
	 */
	public void setLoclIpiSvcModNm(String loclIpiSvcModNm) {
		this.loclIpiSvcModNm = loclIpiSvcModNm;
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
	 * @param rail40ftBzcCostSrcCd
	 */
	public void setRail40ftBzcCostSrcCd(String rail40ftBzcCostSrcCd) {
		this.rail40ftBzcCostSrcCd = rail40ftBzcCostSrcCd;
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
	 * @param rail20ftBzcAgmtWgt
	 */
	public void setRail20ftBzcAgmtWgt(String rail20ftBzcAgmtWgt) {
		this.rail20ftBzcAgmtWgt = rail20ftBzcAgmtWgt;
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
	 * @param dmst20ftAdjCostAmt
	 */
	public void setDmst20ftAdjCostAmt(String dmst20ftAdjCostAmt) {
		this.dmst20ftAdjCostAmt = dmst20ftAdjCostAmt;
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
	 * Column Info
	 * @param n2ndVndrNm
	 */
	public void setN2ndVndrNm(String n2ndVndrNm) {
		this.n2ndVndrNm = n2ndVndrNm;
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
	 * @param dmst20ftTtlCostAmt
	 */
	public void setDmst20ftTtlCostAmt(String dmst20ftTtlCostAmt) {
		this.dmst20ftTtlCostAmt = dmst20ftTtlCostAmt;
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
	 * @param trk40ftBzcCostAmt
	 */
	public void setTrk40ftBzcCostAmt(String trk40ftBzcCostAmt) {
		this.trk40ftBzcCostAmt = trk40ftBzcCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tml40ftCostSrcCd
	 */
	public void setTml40ftCostSrcCd(String tml40ftCostSrcCd) {
		this.tml40ftCostSrcCd = tml40ftCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param dmst40ftCostSrcCd
	 */
	public void setDmst40ftCostSrcCd(String dmst40ftCostSrcCd) {
		this.dmst40ftCostSrcCd = dmst40ftCostSrcCd;
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
	 * Column Info
	 * @param tollFeeAmt40
	 */
	public void setTollFeeAmt40(String tollFeeAmt40) {
		this.tollFeeAmt40 = tollFeeAmt40;
	}
	
	/**
	 * Column Info
	 * @param trk40ftBzcCostSrcCd
	 */
	public void setTrk40ftBzcCostSrcCd(String trk40ftBzcCostSrcCd) {
		this.trk40ftBzcCostSrcCd = trk40ftBzcCostSrcCd;
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
	 * @param trk20ftBzcCostSrcCd
	 */
	public void setTrk20ftBzcCostSrcCd(String trk20ftBzcCostSrcCd) {
		this.trk20ftBzcCostSrcCd = trk20ftBzcCostSrcCd;
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
	 * @param rail20ftFuelScgAmt
	 */
	public void setRail20ftFuelScgAmt(String rail20ftFuelScgAmt) {
		this.rail20ftFuelScgAmt = rail20ftFuelScgAmt;
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
	 * @param trk20ftBzcAgmtWgt
	 */
	public void setTrk20ftBzcAgmtWgt(String trk20ftBzcAgmtWgt) {
		this.trk20ftBzcAgmtWgt = trk20ftBzcAgmtWgt;
	}
	
	/**
	 * Column Info
	 * @param tml20ftCostSrcCd
	 */
	public void setTml20ftCostSrcCd(String tml20ftCostSrcCd) {
		this.tml20ftCostSrcCd = tml20ftCostSrcCd;
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
	 * @param trk40ftTtlAmt
	 */
	public void setTrk40ftTtlAmt(String trk40ftTtlAmt) {
		this.trk40ftTtlAmt = trk40ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param loclIpiSvcMod
	 */
	public void setLoclIpiSvcMod(String loclIpiSvcMod) {
		this.loclIpiSvcMod = loclIpiSvcMod;
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
	 * @param dmst40ftTtlCostAmt
	 */
	public void setDmst40ftTtlCostAmt(String dmst40ftTtlCostAmt) {
		this.dmst40ftTtlCostAmt = dmst40ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rail20ftTtlAmt
	 */
	public void setRail20ftTtlAmt(String rail20ftTtlAmt) {
		this.rail20ftTtlAmt = rail20ftTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param rail20ftBzcCostSrcCd
	 */
	public void setRail20ftBzcCostSrcCd(String rail20ftBzcCostSrcCd) {
		this.rail20ftBzcCostSrcCd = rail20ftBzcCostSrcCd;
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
	 * @param rail40ftFuelScgSrcCd
	 */
	public void setRail40ftFuelScgSrcCd(String rail40ftFuelScgSrcCd) {
		this.rail40ftFuelScgSrcCd = rail40ftFuelScgSrcCd;
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
	 * @param n1stVndrSeq
	 */
	public void setN1stVndrSeq(String n1stVndrSeq) {
		this.n1stVndrSeq = n1stVndrSeq;
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
	 * @param rf20ftTtlCostAmt
	 */
	public void setRf20ftTtlCostAmt(String rf20ftTtlCostAmt) {
		this.rf20ftTtlCostAmt = rf20ftTtlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param dmst40ftAdjCostAmt
	 */
	public void setDmst40ftAdjCostAmt(String dmst40ftAdjCostAmt) {
		this.dmst40ftAdjCostAmt = dmst40ftAdjCostAmt;
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
	 * @param rail40ftFuelScgAmt
	 */
	public void setRail40ftFuelScgAmt(String rail40ftFuelScgAmt) {
		this.rail40ftFuelScgAmt = rail40ftFuelScgAmt;
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
	 * @param trk20ftTtlAmt
	 */
	public void setTrk20ftTtlAmt(String trk20ftTtlAmt) {
		this.trk20ftTtlAmt = trk20ftTtlAmt;
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
	 * @param n3rdVndrNm
	 */
	public void setN3rdVndrNm(String n3rdVndrNm) {
		this.n3rdVndrNm = n3rdVndrNm;
	}
	
	/**
	 * Column Info
	 * @param trk40ftFuelScgSrcCd
	 */
	public void setTrk40ftFuelScgSrcCd(String trk40ftFuelScgSrcCd) {
		this.trk40ftFuelScgSrcCd = trk40ftFuelScgSrcCd;
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
	 * @param trk40ftBzcCostAdjAmt
	 */
	public void setTrk40ftBzcCostAdjAmt(String trk40ftBzcCostAdjAmt) {
		this.trk40ftBzcCostAdjAmt = trk40ftBzcCostAdjAmt;
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
		setDmst20ftCostSrcCd(JSPUtil.getParameter(request, prefix + "dmst_20ft_cost_src_cd", ""));
		setRail20ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_ttl_amt", ""));
		setCostRoutGrpNo(JSPUtil.getParameter(request, prefix + "cost_rout_grp_no", ""));
		setRail40ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_agmt_wy_tp_cd", ""));
		setRail40ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_amt", ""));
		setRail20ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrk20ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_adj_amt", ""));
		setRail20ftFuelScgSrcCd(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_src_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setTrk20ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_ttl_amt", ""));
		setTrk40ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_agmt_wy_tp_cd", ""));
		setMtyTrsp20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_ttl_cost_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setTrk20ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_agmt_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setMtyTrsp20ftCostSrcCd(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_src_cd", ""));
		setInlnd20ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_20ft_ttl_amt", ""));
		setCostTrfNo(JSPUtil.getParameter(request, prefix + "cost_trf_no", ""));
		setRf40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_ttl_cost_amt", ""));
		setRail40ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_agmt_wgt", ""));
		setTrk40ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_ttl_amt", ""));
		setTrk20ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_agmt_wy_tp_cd", ""));
		setRail20ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_adj_amt", ""));
		setPortLoc(JSPUtil.getParameter(request, prefix + "port_loc", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setLocNodCd(JSPUtil.getParameter(request, prefix + "loc_nod_cd", ""));
		setTrk20ftFuelScgSrcCd(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_src_cd", ""));
		setTrk40ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_adj_amt", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setTrspAgmt40ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_40ft_mty_yd_cd", ""));
		setTml40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_ttl_cost_amt", ""));
		setTrk20ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_agmt_wy_tp_cd", ""));
		setTrk20ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_adj_amt", ""));
		setMtyTrsp40ftCostSrcCd(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_src_cd", ""));
		setTrk40ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_agmt_wgt", ""));
		setTrk40ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_agmt_wy_tp_cd", ""));
		setRail20ftFuelScgAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_agmt_wgt", ""));
		setRail40ftTtlAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_ttl_amt", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setTollFeeAmt20(JSPUtil.getParameter(request, prefix + "toll_fee_amt_20", ""));
		setTrk40ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_ttl_amt", ""));
		setTrk20ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_amt", ""));
		setTrspDiff40ft(JSPUtil.getParameter(request, prefix + "trsp_diff_40ft", ""));
		setCostTrfRfSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rf_seq", ""));
		setLoclIpiSvcModNm(JSPUtil.getParameter(request, prefix + "locl_ipi_svc_mod_nm", ""));
		setN2ndInlndRoutCmbFlg(JSPUtil.getParameter(request, prefix + "n2nd_inlnd_rout_cmb_flg", ""));
		setInlnd40ftTtlAmt(JSPUtil.getParameter(request, prefix + "inlnd_40ft_ttl_amt", ""));
		setDmst20ftCostAmt(JSPUtil.getParameter(request, prefix + "dmst_20ft_cost_amt", ""));
		setRail40ftBzcCostSrcCd(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_src_cd", ""));
		setHubNodCd(JSPUtil.getParameter(request, prefix + "hub_nod_cd", ""));
		setRail20ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_agmt_wgt", ""));
		setMtyTrsp40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_ttl_cost_amt", ""));
		setDmst20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "dmst_20ft_adj_cost_amt", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setPortNodCd(JSPUtil.getParameter(request, prefix + "port_nod_cd", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setRail20ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_agmt_wy_tp_cd", ""));
		setTml20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_ttl_cost_amt", ""));
		setAgmtOldFlg(JSPUtil.getParameter(request, prefix + "agmt_old_flg", ""));
		setN2ndVndrNm(JSPUtil.getParameter(request, prefix + "n2nd_vndr_nm", ""));
		setDmst40ftCostAmt(JSPUtil.getParameter(request, prefix + "dmst_40ft_cost_amt", ""));
		setDmst20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "dmst_20ft_ttl_cost_amt", ""));
		setTrk20ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_ttl_amt", ""));
		setTrk40ftBzcCostAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_amt", ""));
		setTml40ftCostSrcCd(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_src_cd", ""));
		setDmst40ftCostSrcCd(JSPUtil.getParameter(request, prefix + "dmst_40ft_cost_src_cd", ""));
		setN1stInlndRoutCmbFlg(JSPUtil.getParameter(request, prefix + "n1st_inlnd_rout_cmb_flg", ""));
		setCostTrfRoutSeq(JSPUtil.getParameter(request, prefix + "cost_trf_rout_seq", ""));
		setTollFeeAmt40(JSPUtil.getParameter(request, prefix + "toll_fee_amt_40", ""));
		setTrk40ftBzcCostSrcCd(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_src_cd", ""));
		setRail40ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_agmt_wgt", ""));
		setTrk20ftBzcCostSrcCd(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_cost_src_cd", ""));
		setRail40ftFuelScgTtlAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_ttl_amt", ""));
		setRail20ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_amt", ""));
		setN2ndVndrSeq(JSPUtil.getParameter(request, prefix + "n2nd_vndr_seq", ""));
		setRail20ftBzcAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_agmt_wy_tp_cd", ""));
		setTrspAgmt20ftMtyYdCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_20ft_mty_yd_cd", ""));
		setTrk20ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_fuel_scg_amt", ""));
		setTrk20ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_20ft_bzc_agmt_wgt", ""));
		setTml20ftCostSrcCd(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_src_cd", ""));
		setTrspDiff20ft(JSPUtil.getParameter(request, prefix + "trsp_diff_20ft", ""));
		setTrk40ftTtlAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_ttl_amt", ""));
		setLoclIpiSvcMod(JSPUtil.getParameter(request, prefix + "locl_ipi_svc_mod", ""));
		setMtyTrsp40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_adj_cost_amt", ""));
		setRail20ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_fuel_scg_adj_amt", ""));
		setRcvDeTermNm(JSPUtil.getParameter(request, prefix + "rcv_de_term_nm", ""));
		setRail20ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_ttl_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setDmst40ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "dmst_40ft_ttl_cost_amt", ""));
		setRail20ftTtlAmt(JSPUtil.getParameter(request, prefix + "rail_20ft_ttl_amt", ""));
		setRail20ftBzcCostSrcCd(JSPUtil.getParameter(request, prefix + "rail_20ft_bzc_cost_src_cd", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setMtyTrsp20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_adj_cost_amt", ""));
		setTml20ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_adj_cost_amt", ""));
		setRail40ftFuelScgSrcCd(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_src_cd", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN1stVndrSeq(JSPUtil.getParameter(request, prefix + "n1st_vndr_seq", ""));
		setRail40ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_adj_amt", ""));
		setRf20ftTtlCostAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_ttl_cost_amt", ""));
		setDmst40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "dmst_40ft_adj_cost_amt", ""));
		setN1stVndrNm(JSPUtil.getParameter(request, prefix + "n1st_vndr_nm", ""));
		setMtyPkupRtnYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_rtn_yd_cd", ""));
		setRail40ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_amt", ""));
		setN3rdVndrSeq(JSPUtil.getParameter(request, prefix + "n3rd_vndr_seq", ""));
		setTrk20ftTtlAmt(JSPUtil.getParameter(request, prefix + "trk_20ft_ttl_amt", ""));
		setTml40ftAdjCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_adj_cost_amt", ""));
		setN3rdVndrNm(JSPUtil.getParameter(request, prefix + "n3rd_vndr_nm", ""));
		setTrk40ftFuelScgSrcCd(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_src_cd", ""));
		setRail40ftFuelAgmtWyTpCd(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_agmt_wy_tp_cd", ""));
		setTrk40ftBzcCostAdjAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_cost_adj_amt", ""));
		setTrk40ftBzcAgmtWgt(JSPUtil.getParameter(request, prefix + "trk_40ft_bzc_agmt_wgt", ""));
		setTrk40ftFuelScgAmt(JSPUtil.getParameter(request, prefix + "trk_40ft_fuel_scg_amt", ""));
		setRail40ftFuelScgAdjAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_fuel_scg_adj_amt", ""));
		setRail40ftBzcCostTtlAmt(JSPUtil.getParameter(request, prefix + "rail_40ft_bzc_cost_ttl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaInlandCostVO[]
	 */
	public UsaInlandCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaInlandCostVO[]
	 */
	public UsaInlandCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaInlandCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmst20ftCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "dmst_20ft_cost_src_cd", length));
			String[] rail20ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_ttl_amt", length));
			String[] costRoutGrpNo = (JSPUtil.getParameter(request, prefix	+ "cost_rout_grp_no", length));
			String[] rail40ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_agmt_wy_tp_cd", length));
			String[] rail40ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_amt", length));
			String[] rail20ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trk20ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_adj_amt", length));
			String[] rail20ftFuelScgSrcCd = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_src_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] trk20ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_ttl_amt", length));
			String[] trk40ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_agmt_wy_tp_cd", length));
			String[] mtyTrsp20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_ttl_cost_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] trk20ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_agmt_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] mtyTrsp20ftCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_src_cd", length));
			String[] inlnd20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_20ft_ttl_amt", length));
			String[] costTrfNo = (JSPUtil.getParameter(request, prefix	+ "cost_trf_no", length));
			String[] rf40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_ttl_cost_amt", length));
			String[] rail40ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_agmt_wgt", length));
			String[] trk40ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_ttl_amt", length));
			String[] trk20ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_agmt_wy_tp_cd", length));
			String[] rail20ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_adj_amt", length));
			String[] portLoc = (JSPUtil.getParameter(request, prefix	+ "port_loc", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] locNodCd = (JSPUtil.getParameter(request, prefix	+ "loc_nod_cd", length));
			String[] trk20ftFuelScgSrcCd = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_src_cd", length));
			String[] trk40ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_adj_amt", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] trspAgmt40ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_40ft_mty_yd_cd", length));
			String[] tml40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_ttl_cost_amt", length));
			String[] trk20ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_agmt_wy_tp_cd", length));
			String[] trk20ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_adj_amt", length));
			String[] mtyTrsp40ftCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_src_cd", length));
			String[] trk40ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_agmt_wgt", length));
			String[] trk40ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_agmt_wy_tp_cd", length));
			String[] rail20ftFuelScgAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_agmt_wgt", length));
			String[] rail40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_ttl_amt", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] tollFeeAmt20 = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt_20", length));
			String[] trk40ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_ttl_amt", length));
			String[] trk20ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_amt", length));
			String[] trspDiff40ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_40ft", length));
			String[] costTrfRfSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rf_seq", length));
			String[] loclIpiSvcModNm = (JSPUtil.getParameter(request, prefix	+ "locl_ipi_svc_mod_nm", length));
			String[] n2ndInlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "n2nd_inlnd_rout_cmb_flg", length));
			String[] inlnd40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_ttl_amt", length));
			String[] dmst20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_20ft_cost_amt", length));
			String[] rail40ftBzcCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_src_cd", length));
			String[] hubNodCd = (JSPUtil.getParameter(request, prefix	+ "hub_nod_cd", length));
			String[] rail20ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_agmt_wgt", length));
			String[] mtyTrsp40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_ttl_cost_amt", length));
			String[] dmst20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_20ft_adj_cost_amt", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] portNodCd = (JSPUtil.getParameter(request, prefix	+ "port_nod_cd", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] rail20ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_agmt_wy_tp_cd", length));
			String[] tml20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_ttl_cost_amt", length));
			String[] agmtOldFlg = (JSPUtil.getParameter(request, prefix	+ "agmt_old_flg", length));
			String[] n2ndVndrNm = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_nm", length));
			String[] dmst40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_40ft_cost_amt", length));
			String[] dmst20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_20ft_ttl_cost_amt", length));
			String[] trk20ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_ttl_amt", length));
			String[] trk40ftBzcCostAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_amt", length));
			String[] tml40ftCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_src_cd", length));
			String[] dmst40ftCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "dmst_40ft_cost_src_cd", length));
			String[] n1stInlndRoutCmbFlg = (JSPUtil.getParameter(request, prefix	+ "n1st_inlnd_rout_cmb_flg", length));
			String[] costTrfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_rout_seq", length));
			String[] tollFeeAmt40 = (JSPUtil.getParameter(request, prefix	+ "toll_fee_amt_40", length));
			String[] trk40ftBzcCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_src_cd", length));
			String[] rail40ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_agmt_wgt", length));
			String[] trk20ftBzcCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_cost_src_cd", length));
			String[] rail40ftFuelScgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_ttl_amt", length));
			String[] rail20ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_amt", length));
			String[] n2ndVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n2nd_vndr_seq", length));
			String[] rail20ftBzcAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_agmt_wy_tp_cd", length));
			String[] trspAgmt20ftMtyYdCd = (JSPUtil.getParameter(request, prefix	+ "trsp_agmt_20ft_mty_yd_cd", length));
			String[] trk20ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_fuel_scg_amt", length));
			String[] trk20ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_bzc_agmt_wgt", length));
			String[] tml20ftCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_src_cd", length));
			String[] trspDiff20ft = (JSPUtil.getParameter(request, prefix	+ "trsp_diff_20ft", length));
			String[] trk40ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_ttl_amt", length));
			String[] loclIpiSvcMod = (JSPUtil.getParameter(request, prefix	+ "locl_ipi_svc_mod", length));
			String[] mtyTrsp40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_adj_cost_amt", length));
			String[] rail20ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_fuel_scg_adj_amt", length));
			String[] rcvDeTermNm = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_nm", length));
			String[] rail20ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_ttl_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] dmst40ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_40ft_ttl_cost_amt", length));
			String[] rail20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_ttl_amt", length));
			String[] rail20ftBzcCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "rail_20ft_bzc_cost_src_cd", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] mtyTrsp20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_adj_cost_amt", length));
			String[] tml20ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_adj_cost_amt", length));
			String[] rail40ftFuelScgSrcCd = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_src_cd", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n1stVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_seq", length));
			String[] rail40ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_adj_amt", length));
			String[] rf20ftTtlCostAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_ttl_cost_amt", length));
			String[] dmst40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "dmst_40ft_adj_cost_amt", length));
			String[] n1stVndrNm = (JSPUtil.getParameter(request, prefix	+ "n1st_vndr_nm", length));
			String[] mtyPkupRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_rtn_yd_cd", length));
			String[] rail40ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_amt", length));
			String[] n3rdVndrSeq = (JSPUtil.getParameter(request, prefix	+ "n3rd_vndr_seq", length));
			String[] trk20ftTtlAmt = (JSPUtil.getParameter(request, prefix	+ "trk_20ft_ttl_amt", length));
			String[] tml40ftAdjCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_adj_cost_amt", length));
			String[] n3rdVndrNm = (JSPUtil.getParameter(request, prefix	+ "n3rd_vndr_nm", length));
			String[] trk40ftFuelScgSrcCd = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_src_cd", length));
			String[] rail40ftFuelAgmtWyTpCd = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_agmt_wy_tp_cd", length));
			String[] trk40ftBzcCostAdjAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_cost_adj_amt", length));
			String[] trk40ftBzcAgmtWgt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_bzc_agmt_wgt", length));
			String[] trk40ftFuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "trk_40ft_fuel_scg_amt", length));
			String[] rail40ftFuelScgAdjAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_fuel_scg_adj_amt", length));
			String[] rail40ftBzcCostTtlAmt = (JSPUtil.getParameter(request, prefix	+ "rail_40ft_bzc_cost_ttl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaInlandCostVO();
				if (dmst20ftCostSrcCd[i] != null)
					model.setDmst20ftCostSrcCd(dmst20ftCostSrcCd[i]);
				if (rail20ftFuelScgTtlAmt[i] != null)
					model.setRail20ftFuelScgTtlAmt(rail20ftFuelScgTtlAmt[i]);
				if (costRoutGrpNo[i] != null)
					model.setCostRoutGrpNo(costRoutGrpNo[i]);
				if (rail40ftBzcAgmtWyTpCd[i] != null)
					model.setRail40ftBzcAgmtWyTpCd(rail40ftBzcAgmtWyTpCd[i]);
				if (rail40ftBzcCostAmt[i] != null)
					model.setRail40ftBzcCostAmt(rail40ftBzcCostAmt[i]);
				if (rail20ftBzcCostAmt[i] != null)
					model.setRail20ftBzcCostAmt(rail20ftBzcCostAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trk20ftBzcCostAdjAmt[i] != null)
					model.setTrk20ftBzcCostAdjAmt(trk20ftBzcCostAdjAmt[i]);
				if (rail20ftFuelScgSrcCd[i] != null)
					model.setRail20ftFuelScgSrcCd(rail20ftFuelScgSrcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (trk20ftBzcCostTtlAmt[i] != null)
					model.setTrk20ftBzcCostTtlAmt(trk20ftBzcCostTtlAmt[i]);
				if (trk40ftBzcAgmtWyTpCd[i] != null)
					model.setTrk40ftBzcAgmtWyTpCd(trk40ftBzcAgmtWyTpCd[i]);
				if (mtyTrsp20ftTtlCostAmt[i] != null)
					model.setMtyTrsp20ftTtlCostAmt(mtyTrsp20ftTtlCostAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (trk20ftFuelScgAgmtWgt[i] != null)
					model.setTrk20ftFuelScgAgmtWgt(trk20ftFuelScgAgmtWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (mtyTrsp20ftCostSrcCd[i] != null)
					model.setMtyTrsp20ftCostSrcCd(mtyTrsp20ftCostSrcCd[i]);
				if (inlnd20ftTtlAmt[i] != null)
					model.setInlnd20ftTtlAmt(inlnd20ftTtlAmt[i]);
				if (costTrfNo[i] != null)
					model.setCostTrfNo(costTrfNo[i]);
				if (rf40ftTtlCostAmt[i] != null)
					model.setRf40ftTtlCostAmt(rf40ftTtlCostAmt[i]);
				if (rail40ftFuelScgAgmtWgt[i] != null)
					model.setRail40ftFuelScgAgmtWgt(rail40ftFuelScgAgmtWgt[i]);
				if (trk40ftBzcCostTtlAmt[i] != null)
					model.setTrk40ftBzcCostTtlAmt(trk40ftBzcCostTtlAmt[i]);
				if (trk20ftBzcAgmtWyTpCd[i] != null)
					model.setTrk20ftBzcAgmtWyTpCd(trk20ftBzcAgmtWyTpCd[i]);
				if (rail20ftBzcCostAdjAmt[i] != null)
					model.setRail20ftBzcCostAdjAmt(rail20ftBzcCostAdjAmt[i]);
				if (portLoc[i] != null)
					model.setPortLoc(portLoc[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (locNodCd[i] != null)
					model.setLocNodCd(locNodCd[i]);
				if (trk20ftFuelScgSrcCd[i] != null)
					model.setTrk20ftFuelScgSrcCd(trk20ftFuelScgSrcCd[i]);
				if (trk40ftFuelScgAdjAmt[i] != null)
					model.setTrk40ftFuelScgAdjAmt(trk40ftFuelScgAdjAmt[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (trspAgmt40ftMtyYdCd[i] != null)
					model.setTrspAgmt40ftMtyYdCd(trspAgmt40ftMtyYdCd[i]);
				if (tml40ftTtlCostAmt[i] != null)
					model.setTml40ftTtlCostAmt(tml40ftTtlCostAmt[i]);
				if (trk20ftFuelAgmtWyTpCd[i] != null)
					model.setTrk20ftFuelAgmtWyTpCd(trk20ftFuelAgmtWyTpCd[i]);
				if (trk20ftFuelScgAdjAmt[i] != null)
					model.setTrk20ftFuelScgAdjAmt(trk20ftFuelScgAdjAmt[i]);
				if (mtyTrsp40ftCostSrcCd[i] != null)
					model.setMtyTrsp40ftCostSrcCd(mtyTrsp40ftCostSrcCd[i]);
				if (trk40ftFuelScgAgmtWgt[i] != null)
					model.setTrk40ftFuelScgAgmtWgt(trk40ftFuelScgAgmtWgt[i]);
				if (trk40ftFuelAgmtWyTpCd[i] != null)
					model.setTrk40ftFuelAgmtWyTpCd(trk40ftFuelAgmtWyTpCd[i]);
				if (rail20ftFuelScgAgmtWgt[i] != null)
					model.setRail20ftFuelScgAgmtWgt(rail20ftFuelScgAgmtWgt[i]);
				if (rail40ftTtlAmt[i] != null)
					model.setRail40ftTtlAmt(rail40ftTtlAmt[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (tollFeeAmt20[i] != null)
					model.setTollFeeAmt20(tollFeeAmt20[i]);
				if (trk40ftFuelScgTtlAmt[i] != null)
					model.setTrk40ftFuelScgTtlAmt(trk40ftFuelScgTtlAmt[i]);
				if (trk20ftBzcCostAmt[i] != null)
					model.setTrk20ftBzcCostAmt(trk20ftBzcCostAmt[i]);
				if (trspDiff40ft[i] != null)
					model.setTrspDiff40ft(trspDiff40ft[i]);
				if (costTrfRfSeq[i] != null)
					model.setCostTrfRfSeq(costTrfRfSeq[i]);
				if (loclIpiSvcModNm[i] != null)
					model.setLoclIpiSvcModNm(loclIpiSvcModNm[i]);
				if (n2ndInlndRoutCmbFlg[i] != null)
					model.setN2ndInlndRoutCmbFlg(n2ndInlndRoutCmbFlg[i]);
				if (inlnd40ftTtlAmt[i] != null)
					model.setInlnd40ftTtlAmt(inlnd40ftTtlAmt[i]);
				if (dmst20ftCostAmt[i] != null)
					model.setDmst20ftCostAmt(dmst20ftCostAmt[i]);
				if (rail40ftBzcCostSrcCd[i] != null)
					model.setRail40ftBzcCostSrcCd(rail40ftBzcCostSrcCd[i]);
				if (hubNodCd[i] != null)
					model.setHubNodCd(hubNodCd[i]);
				if (rail20ftBzcAgmtWgt[i] != null)
					model.setRail20ftBzcAgmtWgt(rail20ftBzcAgmtWgt[i]);
				if (mtyTrsp40ftTtlCostAmt[i] != null)
					model.setMtyTrsp40ftTtlCostAmt(mtyTrsp40ftTtlCostAmt[i]);
				if (dmst20ftAdjCostAmt[i] != null)
					model.setDmst20ftAdjCostAmt(dmst20ftAdjCostAmt[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (portNodCd[i] != null)
					model.setPortNodCd(portNodCd[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (rail20ftFuelAgmtWyTpCd[i] != null)
					model.setRail20ftFuelAgmtWyTpCd(rail20ftFuelAgmtWyTpCd[i]);
				if (tml20ftTtlCostAmt[i] != null)
					model.setTml20ftTtlCostAmt(tml20ftTtlCostAmt[i]);
				if (agmtOldFlg[i] != null)
					model.setAgmtOldFlg(agmtOldFlg[i]);
				if (n2ndVndrNm[i] != null)
					model.setN2ndVndrNm(n2ndVndrNm[i]);
				if (dmst40ftCostAmt[i] != null)
					model.setDmst40ftCostAmt(dmst40ftCostAmt[i]);
				if (dmst20ftTtlCostAmt[i] != null)
					model.setDmst20ftTtlCostAmt(dmst20ftTtlCostAmt[i]);
				if (trk20ftFuelScgTtlAmt[i] != null)
					model.setTrk20ftFuelScgTtlAmt(trk20ftFuelScgTtlAmt[i]);
				if (trk40ftBzcCostAmt[i] != null)
					model.setTrk40ftBzcCostAmt(trk40ftBzcCostAmt[i]);
				if (tml40ftCostSrcCd[i] != null)
					model.setTml40ftCostSrcCd(tml40ftCostSrcCd[i]);
				if (dmst40ftCostSrcCd[i] != null)
					model.setDmst40ftCostSrcCd(dmst40ftCostSrcCd[i]);
				if (n1stInlndRoutCmbFlg[i] != null)
					model.setN1stInlndRoutCmbFlg(n1stInlndRoutCmbFlg[i]);
				if (costTrfRoutSeq[i] != null)
					model.setCostTrfRoutSeq(costTrfRoutSeq[i]);
				if (tollFeeAmt40[i] != null)
					model.setTollFeeAmt40(tollFeeAmt40[i]);
				if (trk40ftBzcCostSrcCd[i] != null)
					model.setTrk40ftBzcCostSrcCd(trk40ftBzcCostSrcCd[i]);
				if (rail40ftBzcAgmtWgt[i] != null)
					model.setRail40ftBzcAgmtWgt(rail40ftBzcAgmtWgt[i]);
				if (trk20ftBzcCostSrcCd[i] != null)
					model.setTrk20ftBzcCostSrcCd(trk20ftBzcCostSrcCd[i]);
				if (rail40ftFuelScgTtlAmt[i] != null)
					model.setRail40ftFuelScgTtlAmt(rail40ftFuelScgTtlAmt[i]);
				if (rail20ftFuelScgAmt[i] != null)
					model.setRail20ftFuelScgAmt(rail20ftFuelScgAmt[i]);
				if (n2ndVndrSeq[i] != null)
					model.setN2ndVndrSeq(n2ndVndrSeq[i]);
				if (rail20ftBzcAgmtWyTpCd[i] != null)
					model.setRail20ftBzcAgmtWyTpCd(rail20ftBzcAgmtWyTpCd[i]);
				if (trspAgmt20ftMtyYdCd[i] != null)
					model.setTrspAgmt20ftMtyYdCd(trspAgmt20ftMtyYdCd[i]);
				if (trk20ftFuelScgAmt[i] != null)
					model.setTrk20ftFuelScgAmt(trk20ftFuelScgAmt[i]);
				if (trk20ftBzcAgmtWgt[i] != null)
					model.setTrk20ftBzcAgmtWgt(trk20ftBzcAgmtWgt[i]);
				if (tml20ftCostSrcCd[i] != null)
					model.setTml20ftCostSrcCd(tml20ftCostSrcCd[i]);
				if (trspDiff20ft[i] != null)
					model.setTrspDiff20ft(trspDiff20ft[i]);
				if (trk40ftTtlAmt[i] != null)
					model.setTrk40ftTtlAmt(trk40ftTtlAmt[i]);
				if (loclIpiSvcMod[i] != null)
					model.setLoclIpiSvcMod(loclIpiSvcMod[i]);
				if (mtyTrsp40ftAdjCostAmt[i] != null)
					model.setMtyTrsp40ftAdjCostAmt(mtyTrsp40ftAdjCostAmt[i]);
				if (rail20ftFuelScgAdjAmt[i] != null)
					model.setRail20ftFuelScgAdjAmt(rail20ftFuelScgAdjAmt[i]);
				if (rcvDeTermNm[i] != null)
					model.setRcvDeTermNm(rcvDeTermNm[i]);
				if (rail20ftBzcCostTtlAmt[i] != null)
					model.setRail20ftBzcCostTtlAmt(rail20ftBzcCostTtlAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dmst40ftTtlCostAmt[i] != null)
					model.setDmst40ftTtlCostAmt(dmst40ftTtlCostAmt[i]);
				if (rail20ftTtlAmt[i] != null)
					model.setRail20ftTtlAmt(rail20ftTtlAmt[i]);
				if (rail20ftBzcCostSrcCd[i] != null)
					model.setRail20ftBzcCostSrcCd(rail20ftBzcCostSrcCd[i]);
				if (mtyTrsp20ftCostAmt[i] != null)
					model.setMtyTrsp20ftCostAmt(mtyTrsp20ftCostAmt[i]);
				if (mtyTrsp20ftAdjCostAmt[i] != null)
					model.setMtyTrsp20ftAdjCostAmt(mtyTrsp20ftAdjCostAmt[i]);
				if (tml20ftAdjCostAmt[i] != null)
					model.setTml20ftAdjCostAmt(tml20ftAdjCostAmt[i]);
				if (rail40ftFuelScgSrcCd[i] != null)
					model.setRail40ftFuelScgSrcCd(rail40ftFuelScgSrcCd[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n1stVndrSeq[i] != null)
					model.setN1stVndrSeq(n1stVndrSeq[i]);
				if (rail40ftBzcCostAdjAmt[i] != null)
					model.setRail40ftBzcCostAdjAmt(rail40ftBzcCostAdjAmt[i]);
				if (rf20ftTtlCostAmt[i] != null)
					model.setRf20ftTtlCostAmt(rf20ftTtlCostAmt[i]);
				if (dmst40ftAdjCostAmt[i] != null)
					model.setDmst40ftAdjCostAmt(dmst40ftAdjCostAmt[i]);
				if (n1stVndrNm[i] != null)
					model.setN1stVndrNm(n1stVndrNm[i]);
				if (mtyPkupRtnYdCd[i] != null)
					model.setMtyPkupRtnYdCd(mtyPkupRtnYdCd[i]);
				if (rail40ftFuelScgAmt[i] != null)
					model.setRail40ftFuelScgAmt(rail40ftFuelScgAmt[i]);
				if (n3rdVndrSeq[i] != null)
					model.setN3rdVndrSeq(n3rdVndrSeq[i]);
				if (trk20ftTtlAmt[i] != null)
					model.setTrk20ftTtlAmt(trk20ftTtlAmt[i]);
				if (tml40ftAdjCostAmt[i] != null)
					model.setTml40ftAdjCostAmt(tml40ftAdjCostAmt[i]);
				if (n3rdVndrNm[i] != null)
					model.setN3rdVndrNm(n3rdVndrNm[i]);
				if (trk40ftFuelScgSrcCd[i] != null)
					model.setTrk40ftFuelScgSrcCd(trk40ftFuelScgSrcCd[i]);
				if (rail40ftFuelAgmtWyTpCd[i] != null)
					model.setRail40ftFuelAgmtWyTpCd(rail40ftFuelAgmtWyTpCd[i]);
				if (trk40ftBzcCostAdjAmt[i] != null)
					model.setTrk40ftBzcCostAdjAmt(trk40ftBzcCostAdjAmt[i]);
				if (trk40ftBzcAgmtWgt[i] != null)
					model.setTrk40ftBzcAgmtWgt(trk40ftBzcAgmtWgt[i]);
				if (trk40ftFuelScgAmt[i] != null)
					model.setTrk40ftFuelScgAmt(trk40ftFuelScgAmt[i]);
				if (rail40ftFuelScgAdjAmt[i] != null)
					model.setRail40ftFuelScgAdjAmt(rail40ftFuelScgAdjAmt[i]);
				if (rail40ftBzcCostTtlAmt[i] != null)
					model.setRail40ftBzcCostTtlAmt(rail40ftBzcCostTtlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaInlandCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaInlandCostVO[]
	 */
	public UsaInlandCostVO[] getUsaInlandCostVOs(){
		UsaInlandCostVO[] vos = (UsaInlandCostVO[])models.toArray(new UsaInlandCostVO[models.size()]);
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
		this.dmst20ftCostSrcCd = this.dmst20ftCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgTtlAmt = this.rail20ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRoutGrpNo = this.costRoutGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcAgmtWyTpCd = this.rail40ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostAmt = this.rail40ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostAmt = this.rail20ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostAdjAmt = this.trk20ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgSrcCd = this.rail20ftFuelScgSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostTtlAmt = this.trk20ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcAgmtWyTpCd = this.trk40ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftTtlCostAmt = this.mtyTrsp20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgAgmtWgt = this.trk20ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostSrcCd = this.mtyTrsp20ftCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd20ftTtlAmt = this.inlnd20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfNo = this.costTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40ftTtlCostAmt = this.rf40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgAgmtWgt = this.rail40ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostTtlAmt = this.trk40ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcAgmtWyTpCd = this.trk20ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostAdjAmt = this.rail20ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portLoc = this.portLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNodCd = this.locNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgSrcCd = this.trk20ftFuelScgSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgAdjAmt = this.trk40ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt40ftMtyYdCd = this.trspAgmt40ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftTtlCostAmt = this.tml40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelAgmtWyTpCd = this.trk20ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgAdjAmt = this.trk20ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostSrcCd = this.mtyTrsp40ftCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgAgmtWgt = this.trk40ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelAgmtWyTpCd = this.trk40ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgAgmtWgt = this.rail20ftFuelScgAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftTtlAmt = this.rail40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt20 = this.tollFeeAmt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgTtlAmt = this.trk40ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostAmt = this.trk20ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff40ft = this.trspDiff40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRfSeq = this.costTrfRfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclIpiSvcModNm = this.loclIpiSvcModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndInlndRoutCmbFlg = this.n2ndInlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftTtlAmt = this.inlnd40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst20ftCostAmt = this.dmst20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostSrcCd = this.rail40ftBzcCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubNodCd = this.hubNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcAgmtWgt = this.rail20ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftTtlCostAmt = this.mtyTrsp40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst20ftAdjCostAmt = this.dmst20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNodCd = this.portNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelAgmtWyTpCd = this.rail20ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftTtlCostAmt = this.tml20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOldFlg = this.agmtOldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrNm = this.n2ndVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst40ftCostAmt = this.dmst40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst20ftTtlCostAmt = this.dmst20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgTtlAmt = this.trk20ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostAmt = this.trk40ftBzcCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostSrcCd = this.tml40ftCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst40ftCostSrcCd = this.dmst40ftCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stInlndRoutCmbFlg = this.n1stInlndRoutCmbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfRoutSeq = this.costTrfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tollFeeAmt40 = this.tollFeeAmt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostSrcCd = this.trk40ftBzcCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcAgmtWgt = this.rail40ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcCostSrcCd = this.trk20ftBzcCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgTtlAmt = this.rail40ftFuelScgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgAmt = this.rail20ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVndrSeq = this.n2ndVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcAgmtWyTpCd = this.rail20ftBzcAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmt20ftMtyYdCd = this.trspAgmt20ftMtyYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftFuelScgAmt = this.trk20ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftBzcAgmtWgt = this.trk20ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostSrcCd = this.tml20ftCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDiff20ft = this.trspDiff20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftTtlAmt = this.trk40ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclIpiSvcMod = this.loclIpiSvcMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftAdjCostAmt = this.mtyTrsp40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftFuelScgAdjAmt = this.rail20ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermNm = this.rcvDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostTtlAmt = this.rail20ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst40ftTtlCostAmt = this.dmst40ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftTtlAmt = this.rail20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail20ftBzcCostSrcCd = this.rail20ftBzcCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftAdjCostAmt = this.mtyTrsp20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftAdjCostAmt = this.tml20ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgSrcCd = this.rail40ftFuelScgSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrSeq = this.n1stVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostAdjAmt = this.rail40ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftTtlCostAmt = this.rf20ftTtlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmst40ftAdjCostAmt = this.dmst40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVndrNm = this.n1stVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupRtnYdCd = this.mtyPkupRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgAmt = this.rail40ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVndrSeq = this.n3rdVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk20ftTtlAmt = this.trk20ftTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftAdjCostAmt = this.tml40ftAdjCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVndrNm = this.n3rdVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgSrcCd = this.trk40ftFuelScgSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelAgmtWyTpCd = this.rail40ftFuelAgmtWyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcCostAdjAmt = this.trk40ftBzcCostAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftBzcAgmtWgt = this.trk40ftBzcAgmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trk40ftFuelScgAmt = this.trk40ftFuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftFuelScgAdjAmt = this.rail40ftFuelScgAdjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail40ftBzcCostTtlAmt = this.rail40ftBzcCostTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
