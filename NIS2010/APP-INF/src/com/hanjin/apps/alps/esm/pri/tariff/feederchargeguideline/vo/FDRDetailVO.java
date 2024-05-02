/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FDRDetailVO.java
*@FileTitle : FDRDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo;

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

public class FDRDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FDRDetailVO> models = new ArrayList<FDRDetailVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String loclCurrCost20ftFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCost45ftFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String glineRf40ftFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCost40ftFrtRtAmt = null;
	/* Column Info */
	private String gline45ftFrtRtAmt = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String mbRf20ftRto = null;
	/* Column Info */
	private String trspRf40ftCostAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mbRf40ftRto = null;
	/* Column Info */
	private String mtyTrsp40ftCostAmt = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String rcSvcFlg = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String cost40ftFrtRtAmt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String loclCurrCostRf20ftRtAmt = null;
	/* Column Info */
	private String mtyTrspRf40ftCostAmt = null;
	/* Column Info */
	private String tmlRf20ftCostAmt = null;
	/* Column Info */
	private String trsp40ftCostAmt = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String nextN1stCmncAmdtSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fdrRtRmk = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String tml40ftCostAmt = null;
	/* Column Info */
	private String mtyTrsp45ftCostAmt = null;
	/* Column Info */
	private String mb20ftRto = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mtyTrsp20ftCostAmt = null;
	/* Column Info */
	private String mtyTrspRf20ftCostAmt = null;
	/* Column Info */
	private String glineRf20ftFrtRtAmt = null;
	/* Column Info */
	private String pntLocNm = null;
	/* Column Info */
	private String mb40ftRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trsp45ftCostAmt = null;
	/* Column Info */
	private String cost45ftFrtRtAmt = null;
	/* Column Info */
	private String mb45ftRto = null;
	/* Column Info */
	private String costRf40ftFrtRtAmt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String loclCurrCostRf40ftRtAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trspRf20ftCostAmt = null;
	/* Column Info */
	private String gline20ftFrtRtAmt = null;
	/* Column Info */
	private String tmlRf40ftCostAmt = null;
	/* Column Info */
	private String trsp20ftCostAmt = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String tml45ftCostAmt = null;
	/* Column Info */
	private String cost20ftFrtRtAmt = null;
	/* Column Info */
	private String loclCurrCdRf = null;
	/* Column Info */
	private String gline40ftFrtRtAmt = null;
	/* Column Info */
	private String tml20ftCostAmt = null;
	/* Column Info */
	private String costRf20ftFrtRtAmt = null;
	/* Column Info */
	private String fdrTrfNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FDRDetailVO() {}

	public FDRDetailVO(String ibflag, String pagerows, String svcScpCd, String orgDestTpCd, String fdrTrfNo, String amdtSeq, String rtSeq, String pntLocCd, String pntLocNm, String bsePortLocCd, String rcvDeTermCd, String gline20ftFrtRtAmt, String gline40ftFrtRtAmt, String gline45ftFrtRtAmt, String cost20ftFrtRtAmt, String cost40ftFrtRtAmt, String cost45ftFrtRtAmt, String loclCurrCost20ftFrtRtAmt, String loclCurrCost40ftFrtRtAmt, String loclCurrCost45ftFrtRtAmt, String trsp20ftCostAmt, String trsp40ftCostAmt, String trsp45ftCostAmt, String mtyTrsp20ftCostAmt, String mtyTrsp40ftCostAmt, String mtyTrsp45ftCostAmt, String tml20ftCostAmt, String tml40ftCostAmt, String tml45ftCostAmt, String mb20ftRto, String mb40ftRto, String mb45ftRto, String rcSvcFlg, String glineRf20ftFrtRtAmt, String glineRf40ftFrtRtAmt, String costRf20ftFrtRtAmt, String costRf40ftFrtRtAmt, String loclCurrCostRf20ftRtAmt, String loclCurrCostRf40ftRtAmt, String trspRf20ftCostAmt, String trspRf40ftCostAmt, String mtyTrspRf20ftCostAmt, String mtyTrspRf40ftCostAmt, String tmlRf20ftCostAmt, String tmlRf40ftCostAmt, String mbRf20ftRto, String mbRf40ftRto, String n1stCmncAmdtSeq, String nextN1stCmncAmdtSeq, String effDt, String expDt, String srcInfoCd, String fdrRtRmk, String loclCurrCd, String loclCurrCdRf, String creUsrId, String creDt, String updUsrId, String updDt, String rhqCd) {
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.pntLocCd = pntLocCd;
		this.loclCurrCost20ftFrtRtAmt = loclCurrCost20ftFrtRtAmt;
		this.loclCurrCost45ftFrtRtAmt = loclCurrCost45ftFrtRtAmt;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.glineRf40ftFrtRtAmt = glineRf40ftFrtRtAmt;
		this.loclCurrCost40ftFrtRtAmt = loclCurrCost40ftFrtRtAmt;
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
		this.rcvDeTermCd = rcvDeTermCd;
		this.mbRf20ftRto = mbRf20ftRto;
		this.trspRf40ftCostAmt = trspRf40ftCostAmt;
		this.updUsrId = updUsrId;
		this.mbRf40ftRto = mbRf40ftRto;
		this.mtyTrsp40ftCostAmt = mtyTrsp40ftCostAmt;
		this.bsePortLocCd = bsePortLocCd;
		this.rhqCd = rhqCd;
		this.rcSvcFlg = rcSvcFlg;
		this.loclCurrCd = loclCurrCd;
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
		this.orgDestTpCd = orgDestTpCd;
		this.loclCurrCostRf20ftRtAmt = loclCurrCostRf20ftRtAmt;
		this.mtyTrspRf40ftCostAmt = mtyTrspRf40ftCostAmt;
		this.tmlRf20ftCostAmt = tmlRf20ftCostAmt;
		this.trsp40ftCostAmt = trsp40ftCostAmt;
		this.rtSeq = rtSeq;
		this.nextN1stCmncAmdtSeq = nextN1stCmncAmdtSeq;
		this.creUsrId = creUsrId;
		this.fdrRtRmk = fdrRtRmk;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.tml40ftCostAmt = tml40ftCostAmt;
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
		this.mb20ftRto = mb20ftRto;
		this.creDt = creDt;
		this.mtyTrsp20ftCostAmt = mtyTrsp20ftCostAmt;
		this.mtyTrspRf20ftCostAmt = mtyTrspRf20ftCostAmt;
		this.glineRf20ftFrtRtAmt = glineRf20ftFrtRtAmt;
		this.pntLocNm = pntLocNm;
		this.mb40ftRto = mb40ftRto;
		this.ibflag = ibflag;
		this.trsp45ftCostAmt = trsp45ftCostAmt;
		this.cost45ftFrtRtAmt = cost45ftFrtRtAmt;
		this.mb45ftRto = mb45ftRto;
		this.costRf40ftFrtRtAmt = costRf40ftFrtRtAmt;
		this.expDt = expDt;
		this.loclCurrCostRf40ftRtAmt = loclCurrCostRf40ftRtAmt;
		this.updDt = updDt;
		this.trspRf20ftCostAmt = trspRf20ftCostAmt;
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
		this.tmlRf40ftCostAmt = tmlRf40ftCostAmt;
		this.trsp20ftCostAmt = trsp20ftCostAmt;
		this.srcInfoCd = srcInfoCd;
		this.tml45ftCostAmt = tml45ftCostAmt;
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
		this.loclCurrCdRf = loclCurrCdRf;
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
		this.tml20ftCostAmt = tml20ftCostAmt;
		this.costRf20ftFrtRtAmt = costRf20ftFrtRtAmt;
		this.fdrTrfNo = fdrTrfNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("locl_curr_cost_20ft_frt_rt_amt", getLoclCurrCost20ftFrtRtAmt());
		this.hashColumns.put("locl_curr_cost_45ft_frt_rt_amt", getLoclCurrCost45ftFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("gline_rf_40ft_frt_rt_amt", getGlineRf40ftFrtRtAmt());
		this.hashColumns.put("locl_curr_cost_40ft_frt_rt_amt", getLoclCurrCost40ftFrtRtAmt());
		this.hashColumns.put("gline_45ft_frt_rt_amt", getGline45ftFrtRtAmt());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("mb_rf_20ft_rto", getMbRf20ftRto());
		this.hashColumns.put("trsp_rf_40ft_cost_amt", getTrspRf40ftCostAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mb_rf_40ft_rto", getMbRf40ftRto());
		this.hashColumns.put("mty_trsp_40ft_cost_amt", getMtyTrsp40ftCostAmt());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("rc_svc_flg", getRcSvcFlg());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cost_40ft_frt_rt_amt", getCost40ftFrtRtAmt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("locl_curr_cost_rf_20ft_rt_amt", getLoclCurrCostRf20ftRtAmt());
		this.hashColumns.put("mty_trsp_rf_40ft_cost_amt", getMtyTrspRf40ftCostAmt());
		this.hashColumns.put("tml_rf_20ft_cost_amt", getTmlRf20ftCostAmt());
		this.hashColumns.put("trsp_40ft_cost_amt", getTrsp40ftCostAmt());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("next_n1st_cmnc_amdt_seq", getNextN1stCmncAmdtSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fdr_rt_rmk", getFdrRtRmk());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("tml_40ft_cost_amt", getTml40ftCostAmt());
		this.hashColumns.put("mty_trsp_45ft_cost_amt", getMtyTrsp45ftCostAmt());
		this.hashColumns.put("mb_20ft_rto", getMb20ftRto());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mty_trsp_20ft_cost_amt", getMtyTrsp20ftCostAmt());
		this.hashColumns.put("mty_trsp_rf_20ft_cost_amt", getMtyTrspRf20ftCostAmt());
		this.hashColumns.put("gline_rf_20ft_frt_rt_amt", getGlineRf20ftFrtRtAmt());
		this.hashColumns.put("pnt_loc_nm", getPntLocNm());
		this.hashColumns.put("mb_40ft_rto", getMb40ftRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_45ft_cost_amt", getTrsp45ftCostAmt());
		this.hashColumns.put("cost_45ft_frt_rt_amt", getCost45ftFrtRtAmt());
		this.hashColumns.put("mb_45ft_rto", getMb45ftRto());
		this.hashColumns.put("cost_rf_40ft_frt_rt_amt", getCostRf40ftFrtRtAmt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("locl_curr_cost_rf_40ft_rt_amt", getLoclCurrCostRf40ftRtAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsp_rf_20ft_cost_amt", getTrspRf20ftCostAmt());
		this.hashColumns.put("gline_20ft_frt_rt_amt", getGline20ftFrtRtAmt());
		this.hashColumns.put("tml_rf_40ft_cost_amt", getTmlRf40ftCostAmt());
		this.hashColumns.put("trsp_20ft_cost_amt", getTrsp20ftCostAmt());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("tml_45ft_cost_amt", getTml45ftCostAmt());
		this.hashColumns.put("cost_20ft_frt_rt_amt", getCost20ftFrtRtAmt());
		this.hashColumns.put("locl_curr_cd_rf", getLoclCurrCdRf());
		this.hashColumns.put("gline_40ft_frt_rt_amt", getGline40ftFrtRtAmt());
		this.hashColumns.put("tml_20ft_cost_amt", getTml20ftCostAmt());
		this.hashColumns.put("cost_rf_20ft_frt_rt_amt", getCostRf20ftFrtRtAmt());
		this.hashColumns.put("fdr_trf_no", getFdrTrfNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("locl_curr_cost_20ft_frt_rt_amt", "loclCurrCost20ftFrtRtAmt");
		this.hashFields.put("locl_curr_cost_45ft_frt_rt_amt", "loclCurrCost45ftFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("gline_rf_40ft_frt_rt_amt", "glineRf40ftFrtRtAmt");
		this.hashFields.put("locl_curr_cost_40ft_frt_rt_amt", "loclCurrCost40ftFrtRtAmt");
		this.hashFields.put("gline_45ft_frt_rt_amt", "gline45ftFrtRtAmt");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("mb_rf_20ft_rto", "mbRf20ftRto");
		this.hashFields.put("trsp_rf_40ft_cost_amt", "trspRf40ftCostAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mb_rf_40ft_rto", "mbRf40ftRto");
		this.hashFields.put("mty_trsp_40ft_cost_amt", "mtyTrsp40ftCostAmt");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("rc_svc_flg", "rcSvcFlg");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cost_40ft_frt_rt_amt", "cost40ftFrtRtAmt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("locl_curr_cost_rf_20ft_rt_amt", "loclCurrCostRf20ftRtAmt");
		this.hashFields.put("mty_trsp_rf_40ft_cost_amt", "mtyTrspRf40ftCostAmt");
		this.hashFields.put("tml_rf_20ft_cost_amt", "tmlRf20ftCostAmt");
		this.hashFields.put("trsp_40ft_cost_amt", "trsp40ftCostAmt");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("next_n1st_cmnc_amdt_seq", "nextN1stCmncAmdtSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fdr_rt_rmk", "fdrRtRmk");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("tml_40ft_cost_amt", "tml40ftCostAmt");
		this.hashFields.put("mty_trsp_45ft_cost_amt", "mtyTrsp45ftCostAmt");
		this.hashFields.put("mb_20ft_rto", "mb20ftRto");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mty_trsp_20ft_cost_amt", "mtyTrsp20ftCostAmt");
		this.hashFields.put("mty_trsp_rf_20ft_cost_amt", "mtyTrspRf20ftCostAmt");
		this.hashFields.put("gline_rf_20ft_frt_rt_amt", "glineRf20ftFrtRtAmt");
		this.hashFields.put("pnt_loc_nm", "pntLocNm");
		this.hashFields.put("mb_40ft_rto", "mb40ftRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_45ft_cost_amt", "trsp45ftCostAmt");
		this.hashFields.put("cost_45ft_frt_rt_amt", "cost45ftFrtRtAmt");
		this.hashFields.put("mb_45ft_rto", "mb45ftRto");
		this.hashFields.put("cost_rf_40ft_frt_rt_amt", "costRf40ftFrtRtAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("locl_curr_cost_rf_40ft_rt_amt", "loclCurrCostRf40ftRtAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsp_rf_20ft_cost_amt", "trspRf20ftCostAmt");
		this.hashFields.put("gline_20ft_frt_rt_amt", "gline20ftFrtRtAmt");
		this.hashFields.put("tml_rf_40ft_cost_amt", "tmlRf40ftCostAmt");
		this.hashFields.put("trsp_20ft_cost_amt", "trsp20ftCostAmt");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("tml_45ft_cost_amt", "tml45ftCostAmt");
		this.hashFields.put("cost_20ft_frt_rt_amt", "cost20ftFrtRtAmt");
		this.hashFields.put("locl_curr_cd_rf", "loclCurrCdRf");
		this.hashFields.put("gline_40ft_frt_rt_amt", "gline40ftFrtRtAmt");
		this.hashFields.put("tml_20ft_cost_amt", "tml20ftCostAmt");
		this.hashFields.put("cost_rf_20ft_frt_rt_amt", "costRf20ftFrtRtAmt");
		this.hashFields.put("fdr_trf_no", "fdrTrfNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return pntLocCd
	 */
	public String getPntLocCd() {
		return this.pntLocCd;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCost20ftFrtRtAmt
	 */
	public String getLoclCurrCost20ftFrtRtAmt() {
		return this.loclCurrCost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCost45ftFrtRtAmt
	 */
	public String getLoclCurrCost45ftFrtRtAmt() {
		return this.loclCurrCost45ftFrtRtAmt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return glineRf40ftFrtRtAmt
	 */
	public String getGlineRf40ftFrtRtAmt() {
		return this.glineRf40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCost40ftFrtRtAmt
	 */
	public String getLoclCurrCost40ftFrtRtAmt() {
		return this.loclCurrCost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return gline45ftFrtRtAmt
	 */
	public String getGline45ftFrtRtAmt() {
		return this.gline45ftFrtRtAmt;
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
	 * @return mbRf20ftRto
	 */
	public String getMbRf20ftRto() {
		return this.mbRf20ftRto;
	}
	
	/**
	 * Column Info
	 * @return trspRf40ftCostAmt
	 */
	public String getTrspRf40ftCostAmt() {
		return this.trspRf40ftCostAmt;
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
	 * @return mbRf40ftRto
	 */
	public String getMbRf40ftRto() {
		return this.mbRf40ftRto;
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
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return rcSvcFlg
	 */
	public String getRcSvcFlg() {
		return this.rcSvcFlg;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cost40ftFrtRtAmt
	 */
	public String getCost40ftFrtRtAmt() {
		return this.cost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCostRf20ftRtAmt
	 */
	public String getLoclCurrCostRf20ftRtAmt() {
		return this.loclCurrCostRf20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return mtyTrspRf40ftCostAmt
	 */
	public String getMtyTrspRf40ftCostAmt() {
		return this.mtyTrspRf40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return tmlRf20ftCostAmt
	 */
	public String getTmlRf20ftCostAmt() {
		return this.tmlRf20ftCostAmt;
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
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return nextN1stCmncAmdtSeq
	 */
	public String getNextN1stCmncAmdtSeq() {
		return this.nextN1stCmncAmdtSeq;
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
	 * @return fdrRtRmk
	 */
	public String getFdrRtRmk() {
		return this.fdrRtRmk;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
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
	 * @return mtyTrsp45ftCostAmt
	 */
	public String getMtyTrsp45ftCostAmt() {
		return this.mtyTrsp45ftCostAmt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return mtyTrspRf20ftCostAmt
	 */
	public String getMtyTrspRf20ftCostAmt() {
		return this.mtyTrspRf20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return glineRf20ftFrtRtAmt
	 */
	public String getGlineRf20ftFrtRtAmt() {
		return this.glineRf20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return pntLocNm
	 */
	public String getPntLocNm() {
		return this.pntLocNm;
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
	 * @return cost45ftFrtRtAmt
	 */
	public String getCost45ftFrtRtAmt() {
		return this.cost45ftFrtRtAmt;
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
	 * @return costRf40ftFrtRtAmt
	 */
	public String getCostRf40ftFrtRtAmt() {
		return this.costRf40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCostRf40ftRtAmt
	 */
	public String getLoclCurrCostRf40ftRtAmt() {
		return this.loclCurrCostRf40ftRtAmt;
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
	 * @return trspRf20ftCostAmt
	 */
	public String getTrspRf20ftCostAmt() {
		return this.trspRf20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @return gline20ftFrtRtAmt
	 */
	public String getGline20ftFrtRtAmt() {
		return this.gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return tmlRf40ftCostAmt
	 */
	public String getTmlRf40ftCostAmt() {
		return this.tmlRf40ftCostAmt;
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
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
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
	 * @return cost20ftFrtRtAmt
	 */
	public String getCost20ftFrtRtAmt() {
		return this.cost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCdRf
	 */
	public String getLoclCurrCdRf() {
		return this.loclCurrCdRf;
	}
	
	/**
	 * Column Info
	 * @return gline40ftFrtRtAmt
	 */
	public String getGline40ftFrtRtAmt() {
		return this.gline40ftFrtRtAmt;
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
	 * @return costRf20ftFrtRtAmt
	 */
	public String getCostRf20ftFrtRtAmt() {
		return this.costRf20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return fdrTrfNo
	 */
	public String getFdrTrfNo() {
		return this.fdrTrfNo;
	}
	

	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param pntLocCd
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCost20ftFrtRtAmt
	 */
	public void setLoclCurrCost20ftFrtRtAmt(String loclCurrCost20ftFrtRtAmt) {
		this.loclCurrCost20ftFrtRtAmt = loclCurrCost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCost45ftFrtRtAmt
	 */
	public void setLoclCurrCost45ftFrtRtAmt(String loclCurrCost45ftFrtRtAmt) {
		this.loclCurrCost45ftFrtRtAmt = loclCurrCost45ftFrtRtAmt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param glineRf40ftFrtRtAmt
	 */
	public void setGlineRf40ftFrtRtAmt(String glineRf40ftFrtRtAmt) {
		this.glineRf40ftFrtRtAmt = glineRf40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCost40ftFrtRtAmt
	 */
	public void setLoclCurrCost40ftFrtRtAmt(String loclCurrCost40ftFrtRtAmt) {
		this.loclCurrCost40ftFrtRtAmt = loclCurrCost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param gline45ftFrtRtAmt
	 */
	public void setGline45ftFrtRtAmt(String gline45ftFrtRtAmt) {
		this.gline45ftFrtRtAmt = gline45ftFrtRtAmt;
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
	 * @param mbRf20ftRto
	 */
	public void setMbRf20ftRto(String mbRf20ftRto) {
		this.mbRf20ftRto = mbRf20ftRto;
	}
	
	/**
	 * Column Info
	 * @param trspRf40ftCostAmt
	 */
	public void setTrspRf40ftCostAmt(String trspRf40ftCostAmt) {
		this.trspRf40ftCostAmt = trspRf40ftCostAmt;
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
	 * @param mbRf40ftRto
	 */
	public void setMbRf40ftRto(String mbRf40ftRto) {
		this.mbRf40ftRto = mbRf40ftRto;
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
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param rcSvcFlg
	 */
	public void setRcSvcFlg(String rcSvcFlg) {
		this.rcSvcFlg = rcSvcFlg;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cost40ftFrtRtAmt
	 */
	public void setCost40ftFrtRtAmt(String cost40ftFrtRtAmt) {
		this.cost40ftFrtRtAmt = cost40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCostRf20ftRtAmt
	 */
	public void setLoclCurrCostRf20ftRtAmt(String loclCurrCostRf20ftRtAmt) {
		this.loclCurrCostRf20ftRtAmt = loclCurrCostRf20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param mtyTrspRf40ftCostAmt
	 */
	public void setMtyTrspRf40ftCostAmt(String mtyTrspRf40ftCostAmt) {
		this.mtyTrspRf40ftCostAmt = mtyTrspRf40ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param tmlRf20ftCostAmt
	 */
	public void setTmlRf20ftCostAmt(String tmlRf20ftCostAmt) {
		this.tmlRf20ftCostAmt = tmlRf20ftCostAmt;
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
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param nextN1stCmncAmdtSeq
	 */
	public void setNextN1stCmncAmdtSeq(String nextN1stCmncAmdtSeq) {
		this.nextN1stCmncAmdtSeq = nextN1stCmncAmdtSeq;
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
	 * @param fdrRtRmk
	 */
	public void setFdrRtRmk(String fdrRtRmk) {
		this.fdrRtRmk = fdrRtRmk;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
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
	 * @param mtyTrsp45ftCostAmt
	 */
	public void setMtyTrsp45ftCostAmt(String mtyTrsp45ftCostAmt) {
		this.mtyTrsp45ftCostAmt = mtyTrsp45ftCostAmt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param mtyTrspRf20ftCostAmt
	 */
	public void setMtyTrspRf20ftCostAmt(String mtyTrspRf20ftCostAmt) {
		this.mtyTrspRf20ftCostAmt = mtyTrspRf20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param glineRf20ftFrtRtAmt
	 */
	public void setGlineRf20ftFrtRtAmt(String glineRf20ftFrtRtAmt) {
		this.glineRf20ftFrtRtAmt = glineRf20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param pntLocNm
	 */
	public void setPntLocNm(String pntLocNm) {
		this.pntLocNm = pntLocNm;
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
	 * @param cost45ftFrtRtAmt
	 */
	public void setCost45ftFrtRtAmt(String cost45ftFrtRtAmt) {
		this.cost45ftFrtRtAmt = cost45ftFrtRtAmt;
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
	 * @param costRf40ftFrtRtAmt
	 */
	public void setCostRf40ftFrtRtAmt(String costRf40ftFrtRtAmt) {
		this.costRf40ftFrtRtAmt = costRf40ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCostRf40ftRtAmt
	 */
	public void setLoclCurrCostRf40ftRtAmt(String loclCurrCostRf40ftRtAmt) {
		this.loclCurrCostRf40ftRtAmt = loclCurrCostRf40ftRtAmt;
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
	 * @param trspRf20ftCostAmt
	 */
	public void setTrspRf20ftCostAmt(String trspRf20ftCostAmt) {
		this.trspRf20ftCostAmt = trspRf20ftCostAmt;
	}
	
	/**
	 * Column Info
	 * @param gline20ftFrtRtAmt
	 */
	public void setGline20ftFrtRtAmt(String gline20ftFrtRtAmt) {
		this.gline20ftFrtRtAmt = gline20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param tmlRf40ftCostAmt
	 */
	public void setTmlRf40ftCostAmt(String tmlRf40ftCostAmt) {
		this.tmlRf40ftCostAmt = tmlRf40ftCostAmt;
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
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
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
	 * @param cost20ftFrtRtAmt
	 */
	public void setCost20ftFrtRtAmt(String cost20ftFrtRtAmt) {
		this.cost20ftFrtRtAmt = cost20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCdRf
	 */
	public void setLoclCurrCdRf(String loclCurrCdRf) {
		this.loclCurrCdRf = loclCurrCdRf;
	}
	
	/**
	 * Column Info
	 * @param gline40ftFrtRtAmt
	 */
	public void setGline40ftFrtRtAmt(String gline40ftFrtRtAmt) {
		this.gline40ftFrtRtAmt = gline40ftFrtRtAmt;
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
	 * @param costRf20ftFrtRtAmt
	 */
	public void setCostRf20ftFrtRtAmt(String costRf20ftFrtRtAmt) {
		this.costRf20ftFrtRtAmt = costRf20ftFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param fdrTrfNo
	 */
	public void setFdrTrfNo(String fdrTrfNo) {
		this.fdrTrfNo = fdrTrfNo;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setLoclCurrCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_20ft_frt_rt_amt", ""));
		setLoclCurrCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_45ft_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setGlineRf40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_rf_40ft_frt_rt_amt", ""));
		setLoclCurrCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_40ft_frt_rt_amt", ""));
		setGline45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_45ft_frt_rt_amt", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, prefix + "rcv_de_term_cd", ""));
		setMbRf20ftRto(JSPUtil.getParameter(request, prefix + "mb_rf_20ft_rto", ""));
		setTrspRf40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_rf_40ft_cost_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMbRf40ftRto(JSPUtil.getParameter(request, prefix + "mb_rf_40ft_rto", ""));
		setMtyTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_40ft_cost_amt", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setRcSvcFlg(JSPUtil.getParameter(request, prefix + "rc_svc_flg", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCost40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_40ft_frt_rt_amt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setLoclCurrCostRf20ftRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_rf_20ft_rt_amt", ""));
		setMtyTrspRf40ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_rf_40ft_cost_amt", ""));
		setTmlRf20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_rf_20ft_cost_amt", ""));
		setTrsp40ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_40ft_cost_amt", ""));
		setRtSeq(JSPUtil.getParameter(request, prefix + "rt_seq", ""));
		setNextN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "next_n1st_cmnc_amdt_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFdrRtRmk(JSPUtil.getParameter(request, prefix + "fdr_rt_rmk", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setTml40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_40ft_cost_amt", ""));
		setMtyTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_45ft_cost_amt", ""));
		setMb20ftRto(JSPUtil.getParameter(request, prefix + "mb_20ft_rto", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMtyTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_20ft_cost_amt", ""));
		setMtyTrspRf20ftCostAmt(JSPUtil.getParameter(request, prefix + "mty_trsp_rf_20ft_cost_amt", ""));
		setGlineRf20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_rf_20ft_frt_rt_amt", ""));
		setPntLocNm(JSPUtil.getParameter(request, prefix + "pnt_loc_nm", ""));
		setMb40ftRto(JSPUtil.getParameter(request, prefix + "mb_40ft_rto", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrsp45ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_45ft_cost_amt", ""));
		setCost45ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_45ft_frt_rt_amt", ""));
		setMb45ftRto(JSPUtil.getParameter(request, prefix + "mb_45ft_rto", ""));
		setCostRf40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_rf_40ft_frt_rt_amt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setLoclCurrCostRf40ftRtAmt(JSPUtil.getParameter(request, prefix + "locl_curr_cost_rf_40ft_rt_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTrspRf20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_rf_20ft_cost_amt", ""));
		setGline20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_20ft_frt_rt_amt", ""));
		setTmlRf40ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_rf_40ft_cost_amt", ""));
		setTrsp20ftCostAmt(JSPUtil.getParameter(request, prefix + "trsp_20ft_cost_amt", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setTml45ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_45ft_cost_amt", ""));
		setCost20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_20ft_frt_rt_amt", ""));
		setLoclCurrCdRf(JSPUtil.getParameter(request, prefix + "locl_curr_cd_rf", ""));
		setGline40ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "gline_40ft_frt_rt_amt", ""));
		setTml20ftCostAmt(JSPUtil.getParameter(request, prefix + "tml_20ft_cost_amt", ""));
		setCostRf20ftFrtRtAmt(JSPUtil.getParameter(request, prefix + "cost_rf_20ft_frt_rt_amt", ""));
		setFdrTrfNo(JSPUtil.getParameter(request, prefix + "fdr_trf_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FDRDetailVO[]
	 */
	public FDRDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FDRDetailVO[]
	 */
	public FDRDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FDRDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] loclCurrCost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_20ft_frt_rt_amt", length));
			String[] loclCurrCost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_45ft_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] glineRf40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_rf_40ft_frt_rt_amt", length));
			String[] loclCurrCost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_40ft_frt_rt_amt", length));
			String[] gline45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_45ft_frt_rt_amt", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] mbRf20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_rf_20ft_rto", length));
			String[] trspRf40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_rf_40ft_cost_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mbRf40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_rf_40ft_rto", length));
			String[] mtyTrsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_40ft_cost_amt", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] rcSvcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_svc_flg", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] cost40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_40ft_frt_rt_amt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] loclCurrCostRf20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_rf_20ft_rt_amt", length));
			String[] mtyTrspRf40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_rf_40ft_cost_amt", length));
			String[] tmlRf20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_rf_20ft_cost_amt", length));
			String[] trsp40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_40ft_cost_amt", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] nextN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "next_n1st_cmnc_amdt_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fdrRtRmk = (JSPUtil.getParameter(request, prefix	+ "fdr_rt_rmk", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] tml40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_40ft_cost_amt", length));
			String[] mtyTrsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_45ft_cost_amt", length));
			String[] mb20ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_20ft_rto", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mtyTrsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_20ft_cost_amt", length));
			String[] mtyTrspRf20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "mty_trsp_rf_20ft_cost_amt", length));
			String[] glineRf20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_rf_20ft_frt_rt_amt", length));
			String[] pntLocNm = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_nm", length));
			String[] mb40ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_40ft_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trsp45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_45ft_cost_amt", length));
			String[] cost45ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_45ft_frt_rt_amt", length));
			String[] mb45ftRto = (JSPUtil.getParameter(request, prefix	+ "mb_45ft_rto", length));
			String[] costRf40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_rf_40ft_frt_rt_amt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] loclCurrCostRf40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cost_rf_40ft_rt_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trspRf20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_rf_20ft_cost_amt", length));
			String[] gline20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_20ft_frt_rt_amt", length));
			String[] tmlRf40ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_rf_40ft_cost_amt", length));
			String[] trsp20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "trsp_20ft_cost_amt", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] tml45ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_45ft_cost_amt", length));
			String[] cost20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_20ft_frt_rt_amt", length));
			String[] loclCurrCdRf = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd_rf", length));
			String[] gline40ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "gline_40ft_frt_rt_amt", length));
			String[] tml20ftCostAmt = (JSPUtil.getParameter(request, prefix	+ "tml_20ft_cost_amt", length));
			String[] costRf20ftFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "cost_rf_20ft_frt_rt_amt", length));
			String[] fdrTrfNo = (JSPUtil.getParameter(request, prefix	+ "fdr_trf_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new FDRDetailVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (loclCurrCost20ftFrtRtAmt[i] != null)
					model.setLoclCurrCost20ftFrtRtAmt(loclCurrCost20ftFrtRtAmt[i]);
				if (loclCurrCost45ftFrtRtAmt[i] != null)
					model.setLoclCurrCost45ftFrtRtAmt(loclCurrCost45ftFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (glineRf40ftFrtRtAmt[i] != null)
					model.setGlineRf40ftFrtRtAmt(glineRf40ftFrtRtAmt[i]);
				if (loclCurrCost40ftFrtRtAmt[i] != null)
					model.setLoclCurrCost40ftFrtRtAmt(loclCurrCost40ftFrtRtAmt[i]);
				if (gline45ftFrtRtAmt[i] != null)
					model.setGline45ftFrtRtAmt(gline45ftFrtRtAmt[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (mbRf20ftRto[i] != null)
					model.setMbRf20ftRto(mbRf20ftRto[i]);
				if (trspRf40ftCostAmt[i] != null)
					model.setTrspRf40ftCostAmt(trspRf40ftCostAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mbRf40ftRto[i] != null)
					model.setMbRf40ftRto(mbRf40ftRto[i]);
				if (mtyTrsp40ftCostAmt[i] != null)
					model.setMtyTrsp40ftCostAmt(mtyTrsp40ftCostAmt[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (rcSvcFlg[i] != null)
					model.setRcSvcFlg(rcSvcFlg[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (cost40ftFrtRtAmt[i] != null)
					model.setCost40ftFrtRtAmt(cost40ftFrtRtAmt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (loclCurrCostRf20ftRtAmt[i] != null)
					model.setLoclCurrCostRf20ftRtAmt(loclCurrCostRf20ftRtAmt[i]);
				if (mtyTrspRf40ftCostAmt[i] != null)
					model.setMtyTrspRf40ftCostAmt(mtyTrspRf40ftCostAmt[i]);
				if (tmlRf20ftCostAmt[i] != null)
					model.setTmlRf20ftCostAmt(tmlRf20ftCostAmt[i]);
				if (trsp40ftCostAmt[i] != null)
					model.setTrsp40ftCostAmt(trsp40ftCostAmt[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (nextN1stCmncAmdtSeq[i] != null)
					model.setNextN1stCmncAmdtSeq(nextN1stCmncAmdtSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fdrRtRmk[i] != null)
					model.setFdrRtRmk(fdrRtRmk[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (tml40ftCostAmt[i] != null)
					model.setTml40ftCostAmt(tml40ftCostAmt[i]);
				if (mtyTrsp45ftCostAmt[i] != null)
					model.setMtyTrsp45ftCostAmt(mtyTrsp45ftCostAmt[i]);
				if (mb20ftRto[i] != null)
					model.setMb20ftRto(mb20ftRto[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mtyTrsp20ftCostAmt[i] != null)
					model.setMtyTrsp20ftCostAmt(mtyTrsp20ftCostAmt[i]);
				if (mtyTrspRf20ftCostAmt[i] != null)
					model.setMtyTrspRf20ftCostAmt(mtyTrspRf20ftCostAmt[i]);
				if (glineRf20ftFrtRtAmt[i] != null)
					model.setGlineRf20ftFrtRtAmt(glineRf20ftFrtRtAmt[i]);
				if (pntLocNm[i] != null)
					model.setPntLocNm(pntLocNm[i]);
				if (mb40ftRto[i] != null)
					model.setMb40ftRto(mb40ftRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trsp45ftCostAmt[i] != null)
					model.setTrsp45ftCostAmt(trsp45ftCostAmt[i]);
				if (cost45ftFrtRtAmt[i] != null)
					model.setCost45ftFrtRtAmt(cost45ftFrtRtAmt[i]);
				if (mb45ftRto[i] != null)
					model.setMb45ftRto(mb45ftRto[i]);
				if (costRf40ftFrtRtAmt[i] != null)
					model.setCostRf40ftFrtRtAmt(costRf40ftFrtRtAmt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (loclCurrCostRf40ftRtAmt[i] != null)
					model.setLoclCurrCostRf40ftRtAmt(loclCurrCostRf40ftRtAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trspRf20ftCostAmt[i] != null)
					model.setTrspRf20ftCostAmt(trspRf20ftCostAmt[i]);
				if (gline20ftFrtRtAmt[i] != null)
					model.setGline20ftFrtRtAmt(gline20ftFrtRtAmt[i]);
				if (tmlRf40ftCostAmt[i] != null)
					model.setTmlRf40ftCostAmt(tmlRf40ftCostAmt[i]);
				if (trsp20ftCostAmt[i] != null)
					model.setTrsp20ftCostAmt(trsp20ftCostAmt[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (tml45ftCostAmt[i] != null)
					model.setTml45ftCostAmt(tml45ftCostAmt[i]);
				if (cost20ftFrtRtAmt[i] != null)
					model.setCost20ftFrtRtAmt(cost20ftFrtRtAmt[i]);
				if (loclCurrCdRf[i] != null)
					model.setLoclCurrCdRf(loclCurrCdRf[i]);
				if (gline40ftFrtRtAmt[i] != null)
					model.setGline40ftFrtRtAmt(gline40ftFrtRtAmt[i]);
				if (tml20ftCostAmt[i] != null)
					model.setTml20ftCostAmt(tml20ftCostAmt[i]);
				if (costRf20ftFrtRtAmt[i] != null)
					model.setCostRf20ftFrtRtAmt(costRf20ftFrtRtAmt[i]);
				if (fdrTrfNo[i] != null)
					model.setFdrTrfNo(fdrTrfNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFDRDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FDRDetailVO[]
	 */
	public FDRDetailVO[] getFDRDetailVOs(){
		FDRDetailVO[] vos = (FDRDetailVO[])models.toArray(new FDRDetailVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost20ftFrtRtAmt = this.loclCurrCost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost45ftFrtRtAmt = this.loclCurrCost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineRf40ftFrtRtAmt = this.glineRf40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCost40ftFrtRtAmt = this.loclCurrCost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline45ftFrtRtAmt = this.gline45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbRf20ftRto = this.mbRf20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRf40ftCostAmt = this.trspRf40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbRf40ftRto = this.mbRf40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp40ftCostAmt = this.mtyTrsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSvcFlg = this.rcSvcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost40ftFrtRtAmt = this.cost40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCostRf20ftRtAmt = this.loclCurrCostRf20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspRf40ftCostAmt = this.mtyTrspRf40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlRf20ftCostAmt = this.tmlRf20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp40ftCostAmt = this.trsp40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextN1stCmncAmdtSeq = this.nextN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrRtRmk = this.fdrRtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml40ftCostAmt = this.tml40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp45ftCostAmt = this.mtyTrsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb20ftRto = this.mb20ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrsp20ftCostAmt = this.mtyTrsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTrspRf20ftCostAmt = this.mtyTrspRf20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineRf20ftFrtRtAmt = this.glineRf20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocNm = this.pntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb40ftRto = this.mb40ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp45ftCostAmt = this.trsp45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost45ftFrtRtAmt = this.cost45ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mb45ftRto = this.mb45ftRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRf40ftFrtRtAmt = this.costRf40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCostRf40ftRtAmt = this.loclCurrCostRf40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRf20ftCostAmt = this.trspRf20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline20ftFrtRtAmt = this.gline20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlRf40ftCostAmt = this.tmlRf40ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsp20ftCostAmt = this.trsp20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml45ftCostAmt = this.tml45ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost20ftFrtRtAmt = this.cost20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCdRf = this.loclCurrCdRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gline40ftFrtRtAmt = this.gline40ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tml20ftCostAmt = this.tml20ftCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costRf20ftFrtRtAmt = this.costRf20ftFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrTrfNo = this.fdrTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
