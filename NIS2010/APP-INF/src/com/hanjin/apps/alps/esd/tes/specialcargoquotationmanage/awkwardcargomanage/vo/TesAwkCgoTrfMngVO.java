/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesAwkCgoTrfMngVO.java
*@FileTitle : TesAwkCgoTrfMngVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo;

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

public class TesAwkCgoTrfMngVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAwkCgoTrfMngVO> models = new ArrayList<TesAwkCgoTrfMngVO>();
	
	/* Column Info */
	private String ttlLoclCurrCd = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String fmlUsdAmt40ft = null;
	/* Column Info */
	private String manLoclAmt20ft = null;
	/* Column Info */
	private String fmlLoclCurrCd = null;
	/* Column Info */
	private String chkAuthYn = null;
	/* Column Info */
	private String sumUsdAmt20ft = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String toYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String spclCgoRefSeq = null;
	/* Column Info */
	private String trfCond = null;
	/* Column Info */
	private String toNodYdNo = null;
	/* Column Info */
	private String usdXchDt = null;
	/* Column Info */
	private String chkSpclCgoRefSeq = null;
	/* Column Info */
	private String ttlUsdAmt40ft = null;
	/* Column Info */
	private String condNo = null;
	/* Column Info */
	private String lclAmt = null;
	/* Column Info */
	private String manUsdAmt40ft = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String selectRow = null;
	/* Column Info */
	private String manUsdAmt20ft = null;
	/* Column Info */
	private String autoUsdAmt40ft = null;
	/* Column Info */
	private String fmlLoclAmt20ft = null;
	/* Column Info */
	private String ioGaCd = null;
	/* Column Info */
	private String lstUpdUsrId = null;
	/* Column Info */
	private String amt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chkFlg = null;
	/* Column Info */
	private String actYdOfcAuthYn = null;
	/* Column Info */
	private String fmlLoclAmt40ft = null;
	/* Column Info */
	private String condDesc = null;
	/* Column Info */
	private String lstUpdDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String calcUsdAmt40ft = null;
	/* Column Info */
	private String mnYdFlg = null;
	/* Column Info */
	private String fmlUsdAmt20ft = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String calcUsdAmt20ft = null;
	/* Column Info */
	private String ttlLoclAmt40ft = null;
	/* Column Info */
	private String ttlUsdAmt20ft = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lgOfcCd = null;
	/* Column Info */
	private String condNoT3 = null;
	/* Column Info */
	private String fmLocCd = null;
	/* Column Info */
	private String ttlLoclAmt20ft = null;
	/* Column Info */
	private String autoUsdAmt20ft = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String tmlAwkTsCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String selectCol = null;
	/* Column Info */
	private String calcRmk = null;
	/* Column Info */
	private String toLocCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String aplyRto = null;
	/* Column Info */
	private String fmNodYdNo = null;
	/* Column Info */
	private String yearMonth = null;
	/* Column Info */
	private String tmlActCostSeq = null;
	/* Column Info */
	private String manLoclAmt40ft = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String tmlAwkCgoTrfTpCd = null;
	/* Column Info */
	private String sumUsdAmt40ft = null;
	/* Column Info */
	private String tmlAwkTrfVerNo = null;
	/* Column Info */
	private String manLoclCurrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesAwkCgoTrfMngVO() {}

	public TesAwkCgoTrfMngVO(String ibflag, String pagerows, String creUsrId, String creDt, String updUsrId, String updDt, String calcUsdAmt40ft, String manLoclAmt20ft, String mnYdFlg, String calcUsdAmt20ft, String tmlCd, String vndrNm, String trfCond, String fmLocCd, String autoUsdAmt20ft, String tmlAwkTsCd, String manUsdAmt40ft, String fmlLoclCurrCd, String fmNodYdNo, String manUsdAmt20ft, String autoUsdAmt40ft, String calcRmk, String toLocCd, String fmlLoclAmt20ft, String ioGaCd, String lstUpdUsrId, String ioBndCd, String aplyRto, String manLoclAmt40ft, String chkFlg, String toNodYdNo, String ydCd, String manLoclCurrCd, String fmlLoclAmt40ft, String lstUpdDt, String yearMonth, String tmlAwkCgoTrfTpCd, String portCd, String lgOfcCd, String chkAuthYn, String usdXchDt, String amt, String currCd, String lclAmt, String condNo, String condNoT3, String ttlLoclCurrCd, String ttlLoclAmt20ft, String ttlLoclAmt40ft, String selectCol, String selectRow, String tmlActCostSeq, String spclCgoRefSeq, String tmlAwkTrfVerNo, String sumUsdAmt20ft, String sumUsdAmt40ft, String condDesc, String chkSpclCgoRefSeq, String ttlUsdAmt20ft, String ttlUsdAmt40ft, String fmlUsdAmt20ft, String fmlUsdAmt40ft, String actYdOfcAuthYn, String fmYdCd, String toYdCd) {
		this.ttlLoclCurrCd = ttlLoclCurrCd;
		this.fmYdCd = fmYdCd;
		this.fmlUsdAmt40ft = fmlUsdAmt40ft;
		this.manLoclAmt20ft = manLoclAmt20ft;
		this.fmlLoclCurrCd = fmlLoclCurrCd;
		this.chkAuthYn = chkAuthYn;
		this.sumUsdAmt20ft = sumUsdAmt20ft;
		this.tmlCd = tmlCd;
		this.toYdCd = toYdCd;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.spclCgoRefSeq = spclCgoRefSeq;
		this.trfCond = trfCond;
		this.toNodYdNo = toNodYdNo;
		this.usdXchDt = usdXchDt;
		this.chkSpclCgoRefSeq = chkSpclCgoRefSeq;
		this.ttlUsdAmt40ft = ttlUsdAmt40ft;
		this.condNo = condNo;
		this.lclAmt = lclAmt;
		this.manUsdAmt40ft = manUsdAmt40ft;
		this.updUsrId = updUsrId;
		this.selectRow = selectRow;
		this.manUsdAmt20ft = manUsdAmt20ft;
		this.autoUsdAmt40ft = autoUsdAmt40ft;
		this.fmlLoclAmt20ft = fmlLoclAmt20ft;
		this.ioGaCd = ioGaCd;
		this.lstUpdUsrId = lstUpdUsrId;
		this.amt = amt;
		this.creUsrId = creUsrId;
		this.chkFlg = chkFlg;
		this.actYdOfcAuthYn = actYdOfcAuthYn;
		this.fmlLoclAmt40ft = fmlLoclAmt40ft;
		this.condDesc = condDesc;
		this.lstUpdDt = lstUpdDt;
		this.currCd = currCd;
		this.calcUsdAmt40ft = calcUsdAmt40ft;
		this.mnYdFlg = mnYdFlg;
		this.fmlUsdAmt20ft = fmlUsdAmt20ft;
		this.creDt = creDt;
		this.calcUsdAmt20ft = calcUsdAmt20ft;
		this.ttlLoclAmt40ft = ttlLoclAmt40ft;
		this.ttlUsdAmt20ft = ttlUsdAmt20ft;
		this.ibflag = ibflag;
		this.lgOfcCd = lgOfcCd;
		this.condNoT3 = condNoT3;
		this.fmLocCd = fmLocCd;
		this.ttlLoclAmt20ft = ttlLoclAmt20ft;
		this.autoUsdAmt20ft = autoUsdAmt20ft;
		this.portCd = portCd;
		this.tmlAwkTsCd = tmlAwkTsCd;
		this.updDt = updDt;
		this.selectCol = selectCol;
		this.calcRmk = calcRmk;
		this.toLocCd = toLocCd;
		this.ioBndCd = ioBndCd;
		this.aplyRto = aplyRto;
		this.fmNodYdNo = fmNodYdNo;
		this.yearMonth = yearMonth;
		this.tmlActCostSeq = tmlActCostSeq;
		this.manLoclAmt40ft = manLoclAmt40ft;
		this.ydCd = ydCd;
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
		this.sumUsdAmt40ft = sumUsdAmt40ft;
		this.tmlAwkTrfVerNo = tmlAwkTrfVerNo;
		this.manLoclCurrCd = manLoclCurrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_locl_curr_cd", getTtlLoclCurrCd());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("fml_usd_amt_40ft", getFmlUsdAmt40ft());
		this.hashColumns.put("man_locl_amt_20ft", getManLoclAmt20ft());
		this.hashColumns.put("fml_locl_curr_cd", getFmlLoclCurrCd());
		this.hashColumns.put("chk_auth_yn", getChkAuthYn());
		this.hashColumns.put("sum_usd_amt_20ft", getSumUsdAmt20ft());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("to_yd_cd", getToYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("spcl_cgo_ref_seq", getSpclCgoRefSeq());
		this.hashColumns.put("trf_cond", getTrfCond());
		this.hashColumns.put("to_nod_yd_no", getToNodYdNo());
		this.hashColumns.put("usd_xch_dt", getUsdXchDt());
		this.hashColumns.put("chk_spcl_cgo_ref_seq", getChkSpclCgoRefSeq());
		this.hashColumns.put("ttl_usd_amt_40ft", getTtlUsdAmt40ft());
		this.hashColumns.put("cond_no", getCondNo());
		this.hashColumns.put("lcl_amt", getLclAmt());
		this.hashColumns.put("man_usd_amt_40ft", getManUsdAmt40ft());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("select_row", getSelectRow());
		this.hashColumns.put("man_usd_amt_20ft", getManUsdAmt20ft());
		this.hashColumns.put("auto_usd_amt_40ft", getAutoUsdAmt40ft());
		this.hashColumns.put("fml_locl_amt_20ft", getFmlLoclAmt20ft());
		this.hashColumns.put("io_ga_cd", getIoGaCd());
		this.hashColumns.put("lst_upd_usr_id", getLstUpdUsrId());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chk_flg", getChkFlg());
		this.hashColumns.put("act_yd_ofc_auth_yn", getActYdOfcAuthYn());
		this.hashColumns.put("fml_locl_amt_40ft", getFmlLoclAmt40ft());
		this.hashColumns.put("cond_desc", getCondDesc());
		this.hashColumns.put("lst_upd_dt", getLstUpdDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("calc_usd_amt_40ft", getCalcUsdAmt40ft());
		this.hashColumns.put("mn_yd_flg", getMnYdFlg());
		this.hashColumns.put("fml_usd_amt_20ft", getFmlUsdAmt20ft());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("calc_usd_amt_20ft", getCalcUsdAmt20ft());
		this.hashColumns.put("ttl_locl_amt_40ft", getTtlLoclAmt40ft());
		this.hashColumns.put("ttl_usd_amt_20ft", getTtlUsdAmt20ft());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lg_ofc_cd", getLgOfcCd());
		this.hashColumns.put("cond_no_t3", getCondNoT3());
		this.hashColumns.put("fm_loc_cd", getFmLocCd());
		this.hashColumns.put("ttl_locl_amt_20ft", getTtlLoclAmt20ft());
		this.hashColumns.put("auto_usd_amt_20ft", getAutoUsdAmt20ft());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("tml_awk_ts_cd", getTmlAwkTsCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("select_col", getSelectCol());
		this.hashColumns.put("calc_rmk", getCalcRmk());
		this.hashColumns.put("to_loc_cd", getToLocCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("aply_rto", getAplyRto());
		this.hashColumns.put("fm_nod_yd_no", getFmNodYdNo());
		this.hashColumns.put("year_month", getYearMonth());
		this.hashColumns.put("tml_act_cost_seq", getTmlActCostSeq());
		this.hashColumns.put("man_locl_amt_40ft", getManLoclAmt40ft());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tml_awk_cgo_trf_tp_cd", getTmlAwkCgoTrfTpCd());
		this.hashColumns.put("sum_usd_amt_40ft", getSumUsdAmt40ft());
		this.hashColumns.put("tml_awk_trf_ver_no", getTmlAwkTrfVerNo());
		this.hashColumns.put("man_locl_curr_cd", getManLoclCurrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_locl_curr_cd", "ttlLoclCurrCd");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("fml_usd_amt_40ft", "fmlUsdAmt40ft");
		this.hashFields.put("man_locl_amt_20ft", "manLoclAmt20ft");
		this.hashFields.put("fml_locl_curr_cd", "fmlLoclCurrCd");
		this.hashFields.put("chk_auth_yn", "chkAuthYn");
		this.hashFields.put("sum_usd_amt_20ft", "sumUsdAmt20ft");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("to_yd_cd", "toYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("spcl_cgo_ref_seq", "spclCgoRefSeq");
		this.hashFields.put("trf_cond", "trfCond");
		this.hashFields.put("to_nod_yd_no", "toNodYdNo");
		this.hashFields.put("usd_xch_dt", "usdXchDt");
		this.hashFields.put("chk_spcl_cgo_ref_seq", "chkSpclCgoRefSeq");
		this.hashFields.put("ttl_usd_amt_40ft", "ttlUsdAmt40ft");
		this.hashFields.put("cond_no", "condNo");
		this.hashFields.put("lcl_amt", "lclAmt");
		this.hashFields.put("man_usd_amt_40ft", "manUsdAmt40ft");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("select_row", "selectRow");
		this.hashFields.put("man_usd_amt_20ft", "manUsdAmt20ft");
		this.hashFields.put("auto_usd_amt_40ft", "autoUsdAmt40ft");
		this.hashFields.put("fml_locl_amt_20ft", "fmlLoclAmt20ft");
		this.hashFields.put("io_ga_cd", "ioGaCd");
		this.hashFields.put("lst_upd_usr_id", "lstUpdUsrId");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk_flg", "chkFlg");
		this.hashFields.put("act_yd_ofc_auth_yn", "actYdOfcAuthYn");
		this.hashFields.put("fml_locl_amt_40ft", "fmlLoclAmt40ft");
		this.hashFields.put("cond_desc", "condDesc");
		this.hashFields.put("lst_upd_dt", "lstUpdDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("calc_usd_amt_40ft", "calcUsdAmt40ft");
		this.hashFields.put("mn_yd_flg", "mnYdFlg");
		this.hashFields.put("fml_usd_amt_20ft", "fmlUsdAmt20ft");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("calc_usd_amt_20ft", "calcUsdAmt20ft");
		this.hashFields.put("ttl_locl_amt_40ft", "ttlLoclAmt40ft");
		this.hashFields.put("ttl_usd_amt_20ft", "ttlUsdAmt20ft");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lg_ofc_cd", "lgOfcCd");
		this.hashFields.put("cond_no_t3", "condNoT3");
		this.hashFields.put("fm_loc_cd", "fmLocCd");
		this.hashFields.put("ttl_locl_amt_20ft", "ttlLoclAmt20ft");
		this.hashFields.put("auto_usd_amt_20ft", "autoUsdAmt20ft");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("tml_awk_ts_cd", "tmlAwkTsCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("select_col", "selectCol");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("to_loc_cd", "toLocCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("aply_rto", "aplyRto");
		this.hashFields.put("fm_nod_yd_no", "fmNodYdNo");
		this.hashFields.put("year_month", "yearMonth");
		this.hashFields.put("tml_act_cost_seq", "tmlActCostSeq");
		this.hashFields.put("man_locl_amt_40ft", "manLoclAmt40ft");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tml_awk_cgo_trf_tp_cd", "tmlAwkCgoTrfTpCd");
		this.hashFields.put("sum_usd_amt_40ft", "sumUsdAmt40ft");
		this.hashFields.put("tml_awk_trf_ver_no", "tmlAwkTrfVerNo");
		this.hashFields.put("man_locl_curr_cd", "manLoclCurrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ttlLoclCurrCd
	 */
	public String getTtlLoclCurrCd() {
		return this.ttlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return fmlUsdAmt40ft
	 */
	public String getFmlUsdAmt40ft() {
		return this.fmlUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return manLoclAmt20ft
	 */
	public String getManLoclAmt20ft() {
		return this.manLoclAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return fmlLoclCurrCd
	 */
	public String getFmlLoclCurrCd() {
		return this.fmlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return chkAuthYn
	 */
	public String getChkAuthYn() {
		return this.chkAuthYn;
	}
	
	/**
	 * Column Info
	 * @return sumUsdAmt20ft
	 */
	public String getSumUsdAmt20ft() {
		return this.sumUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @return spclCgoRefSeq
	 */
	public String getSpclCgoRefSeq() {
		return this.spclCgoRefSeq;
	}
	
	/**
	 * Column Info
	 * @return trfCond
	 */
	public String getTrfCond() {
		return this.trfCond;
	}
	
	/**
	 * Column Info
	 * @return toNodYdNo
	 */
	public String getToNodYdNo() {
		return this.toNodYdNo;
	}
	
	/**
	 * Column Info
	 * @return usdXchDt
	 */
	public String getUsdXchDt() {
		return this.usdXchDt;
	}
	
	/**
	 * Column Info
	 * @return chkSpclCgoRefSeq
	 */
	public String getChkSpclCgoRefSeq() {
		return this.chkSpclCgoRefSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlUsdAmt40ft
	 */
	public String getTtlUsdAmt40ft() {
		return this.ttlUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return condNo
	 */
	public String getCondNo() {
		return this.condNo;
	}
	
	/**
	 * Column Info
	 * @return lclAmt
	 */
	public String getLclAmt() {
		return this.lclAmt;
	}
	
	/**
	 * Column Info
	 * @return manUsdAmt40ft
	 */
	public String getManUsdAmt40ft() {
		return this.manUsdAmt40ft;
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
	 * @return selectRow
	 */
	public String getSelectRow() {
		return this.selectRow;
	}
	
	/**
	 * Column Info
	 * @return manUsdAmt20ft
	 */
	public String getManUsdAmt20ft() {
		return this.manUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return autoUsdAmt40ft
	 */
	public String getAutoUsdAmt40ft() {
		return this.autoUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return fmlLoclAmt20ft
	 */
	public String getFmlLoclAmt20ft() {
		return this.fmlLoclAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return ioGaCd
	 */
	public String getIoGaCd() {
		return this.ioGaCd;
	}
	
	/**
	 * Column Info
	 * @return lstUpdUsrId
	 */
	public String getLstUpdUsrId() {
		return this.lstUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
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
	 * @return chkFlg
	 */
	public String getChkFlg() {
		return this.chkFlg;
	}
	
	/**
	 * Column Info
	 * @return actYdOfcAuthYn
	 */
	public String getActYdOfcAuthYn() {
		return this.actYdOfcAuthYn;
	}
	
	/**
	 * Column Info
	 * @return fmlLoclAmt40ft
	 */
	public String getFmlLoclAmt40ft() {
		return this.fmlLoclAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return condDesc
	 */
	public String getCondDesc() {
		return this.condDesc;
	}
	
	/**
	 * Column Info
	 * @return lstUpdDt
	 */
	public String getLstUpdDt() {
		return this.lstUpdDt;
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
	 * @return calcUsdAmt40ft
	 */
	public String getCalcUsdAmt40ft() {
		return this.calcUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return mnYdFlg
	 */
	public String getMnYdFlg() {
		return this.mnYdFlg;
	}
	
	/**
	 * Column Info
	 * @return fmlUsdAmt20ft
	 */
	public String getFmlUsdAmt20ft() {
		return this.fmlUsdAmt20ft;
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
	 * @return calcUsdAmt20ft
	 */
	public String getCalcUsdAmt20ft() {
		return this.calcUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return ttlLoclAmt40ft
	 */
	public String getTtlLoclAmt40ft() {
		return this.ttlLoclAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return ttlUsdAmt20ft
	 */
	public String getTtlUsdAmt20ft() {
		return this.ttlUsdAmt20ft;
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
	 * @return lgOfcCd
	 */
	public String getLgOfcCd() {
		return this.lgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return condNoT3
	 */
	public String getCondNoT3() {
		return this.condNoT3;
	}
	
	/**
	 * Column Info
	 * @return fmLocCd
	 */
	public String getFmLocCd() {
		return this.fmLocCd;
	}
	
	/**
	 * Column Info
	 * @return ttlLoclAmt20ft
	 */
	public String getTtlLoclAmt20ft() {
		return this.ttlLoclAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return autoUsdAmt20ft
	 */
	public String getAutoUsdAmt20ft() {
		return this.autoUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkTsCd
	 */
	public String getTmlAwkTsCd() {
		return this.tmlAwkTsCd;
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
	 * @return selectCol
	 */
	public String getSelectCol() {
		return this.selectCol;
	}
	
	/**
	 * Column Info
	 * @return calcRmk
	 */
	public String getCalcRmk() {
		return this.calcRmk;
	}
	
	/**
	 * Column Info
	 * @return toLocCd
	 */
	public String getToLocCd() {
		return this.toLocCd;
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
	 * @return aplyRto
	 */
	public String getAplyRto() {
		return this.aplyRto;
	}
	
	/**
	 * Column Info
	 * @return fmNodYdNo
	 */
	public String getFmNodYdNo() {
		return this.fmNodYdNo;
	}
	
	/**
	 * Column Info
	 * @return yearMonth
	 */
	public String getYearMonth() {
		return this.yearMonth;
	}
	
	/**
	 * Column Info
	 * @return tmlActCostSeq
	 */
	public String getTmlActCostSeq() {
		return this.tmlActCostSeq;
	}
	
	/**
	 * Column Info
	 * @return manLoclAmt40ft
	 */
	public String getManLoclAmt40ft() {
		return this.manLoclAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkCgoTrfTpCd
	 */
	public String getTmlAwkCgoTrfTpCd() {
		return this.tmlAwkCgoTrfTpCd;
	}
	
	/**
	 * Column Info
	 * @return sumUsdAmt40ft
	 */
	public String getSumUsdAmt40ft() {
		return this.sumUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @return tmlAwkTrfVerNo
	 */
	public String getTmlAwkTrfVerNo() {
		return this.tmlAwkTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @return manLoclCurrCd
	 */
	public String getManLoclCurrCd() {
		return this.manLoclCurrCd;
	}
	

	/**
	 * Column Info
	 * @param ttlLoclCurrCd
	 */
	public void setTtlLoclCurrCd(String ttlLoclCurrCd) {
		this.ttlLoclCurrCd = ttlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param fmlUsdAmt40ft
	 */
	public void setFmlUsdAmt40ft(String fmlUsdAmt40ft) {
		this.fmlUsdAmt40ft = fmlUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param manLoclAmt20ft
	 */
	public void setManLoclAmt20ft(String manLoclAmt20ft) {
		this.manLoclAmt20ft = manLoclAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param fmlLoclCurrCd
	 */
	public void setFmlLoclCurrCd(String fmlLoclCurrCd) {
		this.fmlLoclCurrCd = fmlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param chkAuthYn
	 */
	public void setChkAuthYn(String chkAuthYn) {
		this.chkAuthYn = chkAuthYn;
	}
	
	/**
	 * Column Info
	 * @param sumUsdAmt20ft
	 */
	public void setSumUsdAmt20ft(String sumUsdAmt20ft) {
		this.sumUsdAmt20ft = sumUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
	 * @param spclCgoRefSeq
	 */
	public void setSpclCgoRefSeq(String spclCgoRefSeq) {
		this.spclCgoRefSeq = spclCgoRefSeq;
	}
	
	/**
	 * Column Info
	 * @param trfCond
	 */
	public void setTrfCond(String trfCond) {
		this.trfCond = trfCond;
	}
	
	/**
	 * Column Info
	 * @param toNodYdNo
	 */
	public void setToNodYdNo(String toNodYdNo) {
		this.toNodYdNo = toNodYdNo;
	}
	
	/**
	 * Column Info
	 * @param usdXchDt
	 */
	public void setUsdXchDt(String usdXchDt) {
		this.usdXchDt = usdXchDt;
	}
	
	/**
	 * Column Info
	 * @param chkSpclCgoRefSeq
	 */
	public void setChkSpclCgoRefSeq(String chkSpclCgoRefSeq) {
		this.chkSpclCgoRefSeq = chkSpclCgoRefSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlUsdAmt40ft
	 */
	public void setTtlUsdAmt40ft(String ttlUsdAmt40ft) {
		this.ttlUsdAmt40ft = ttlUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param condNo
	 */
	public void setCondNo(String condNo) {
		this.condNo = condNo;
	}
	
	/**
	 * Column Info
	 * @param lclAmt
	 */
	public void setLclAmt(String lclAmt) {
		this.lclAmt = lclAmt;
	}
	
	/**
	 * Column Info
	 * @param manUsdAmt40ft
	 */
	public void setManUsdAmt40ft(String manUsdAmt40ft) {
		this.manUsdAmt40ft = manUsdAmt40ft;
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
	 * @param selectRow
	 */
	public void setSelectRow(String selectRow) {
		this.selectRow = selectRow;
	}
	
	/**
	 * Column Info
	 * @param manUsdAmt20ft
	 */
	public void setManUsdAmt20ft(String manUsdAmt20ft) {
		this.manUsdAmt20ft = manUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param autoUsdAmt40ft
	 */
	public void setAutoUsdAmt40ft(String autoUsdAmt40ft) {
		this.autoUsdAmt40ft = autoUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param fmlLoclAmt20ft
	 */
	public void setFmlLoclAmt20ft(String fmlLoclAmt20ft) {
		this.fmlLoclAmt20ft = fmlLoclAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param ioGaCd
	 */
	public void setIoGaCd(String ioGaCd) {
		this.ioGaCd = ioGaCd;
	}
	
	/**
	 * Column Info
	 * @param lstUpdUsrId
	 */
	public void setLstUpdUsrId(String lstUpdUsrId) {
		this.lstUpdUsrId = lstUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
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
	 * @param chkFlg
	 */
	public void setChkFlg(String chkFlg) {
		this.chkFlg = chkFlg;
	}
	
	/**
	 * Column Info
	 * @param actYdOfcAuthYn
	 */
	public void setActYdOfcAuthYn(String actYdOfcAuthYn) {
		this.actYdOfcAuthYn = actYdOfcAuthYn;
	}
	
	/**
	 * Column Info
	 * @param fmlLoclAmt40ft
	 */
	public void setFmlLoclAmt40ft(String fmlLoclAmt40ft) {
		this.fmlLoclAmt40ft = fmlLoclAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param condDesc
	 */
	public void setCondDesc(String condDesc) {
		this.condDesc = condDesc;
	}
	
	/**
	 * Column Info
	 * @param lstUpdDt
	 */
	public void setLstUpdDt(String lstUpdDt) {
		this.lstUpdDt = lstUpdDt;
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
	 * @param calcUsdAmt40ft
	 */
	public void setCalcUsdAmt40ft(String calcUsdAmt40ft) {
		this.calcUsdAmt40ft = calcUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param mnYdFlg
	 */
	public void setMnYdFlg(String mnYdFlg) {
		this.mnYdFlg = mnYdFlg;
	}
	
	/**
	 * Column Info
	 * @param fmlUsdAmt20ft
	 */
	public void setFmlUsdAmt20ft(String fmlUsdAmt20ft) {
		this.fmlUsdAmt20ft = fmlUsdAmt20ft;
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
	 * @param calcUsdAmt20ft
	 */
	public void setCalcUsdAmt20ft(String calcUsdAmt20ft) {
		this.calcUsdAmt20ft = calcUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param ttlLoclAmt40ft
	 */
	public void setTtlLoclAmt40ft(String ttlLoclAmt40ft) {
		this.ttlLoclAmt40ft = ttlLoclAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param ttlUsdAmt20ft
	 */
	public void setTtlUsdAmt20ft(String ttlUsdAmt20ft) {
		this.ttlUsdAmt20ft = ttlUsdAmt20ft;
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
	 * @param lgOfcCd
	 */
	public void setLgOfcCd(String lgOfcCd) {
		this.lgOfcCd = lgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param condNoT3
	 */
	public void setCondNoT3(String condNoT3) {
		this.condNoT3 = condNoT3;
	}
	
	/**
	 * Column Info
	 * @param fmLocCd
	 */
	public void setFmLocCd(String fmLocCd) {
		this.fmLocCd = fmLocCd;
	}
	
	/**
	 * Column Info
	 * @param ttlLoclAmt20ft
	 */
	public void setTtlLoclAmt20ft(String ttlLoclAmt20ft) {
		this.ttlLoclAmt20ft = ttlLoclAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param autoUsdAmt20ft
	 */
	public void setAutoUsdAmt20ft(String autoUsdAmt20ft) {
		this.autoUsdAmt20ft = autoUsdAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkTsCd
	 */
	public void setTmlAwkTsCd(String tmlAwkTsCd) {
		this.tmlAwkTsCd = tmlAwkTsCd;
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
	 * @param selectCol
	 */
	public void setSelectCol(String selectCol) {
		this.selectCol = selectCol;
	}
	
	/**
	 * Column Info
	 * @param calcRmk
	 */
	public void setCalcRmk(String calcRmk) {
		this.calcRmk = calcRmk;
	}
	
	/**
	 * Column Info
	 * @param toLocCd
	 */
	public void setToLocCd(String toLocCd) {
		this.toLocCd = toLocCd;
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
	 * @param aplyRto
	 */
	public void setAplyRto(String aplyRto) {
		this.aplyRto = aplyRto;
	}
	
	/**
	 * Column Info
	 * @param fmNodYdNo
	 */
	public void setFmNodYdNo(String fmNodYdNo) {
		this.fmNodYdNo = fmNodYdNo;
	}
	
	/**
	 * Column Info
	 * @param yearMonth
	 */
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	
	/**
	 * Column Info
	 * @param tmlActCostSeq
	 */
	public void setTmlActCostSeq(String tmlActCostSeq) {
		this.tmlActCostSeq = tmlActCostSeq;
	}
	
	/**
	 * Column Info
	 * @param manLoclAmt40ft
	 */
	public void setManLoclAmt40ft(String manLoclAmt40ft) {
		this.manLoclAmt40ft = manLoclAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkCgoTrfTpCd
	 */
	public void setTmlAwkCgoTrfTpCd(String tmlAwkCgoTrfTpCd) {
		this.tmlAwkCgoTrfTpCd = tmlAwkCgoTrfTpCd;
	}
	
	/**
	 * Column Info
	 * @param sumUsdAmt40ft
	 */
	public void setSumUsdAmt40ft(String sumUsdAmt40ft) {
		this.sumUsdAmt40ft = sumUsdAmt40ft;
	}
	
	/**
	 * Column Info
	 * @param tmlAwkTrfVerNo
	 */
	public void setTmlAwkTrfVerNo(String tmlAwkTrfVerNo) {
		this.tmlAwkTrfVerNo = tmlAwkTrfVerNo;
	}
	
	/**
	 * Column Info
	 * @param manLoclCurrCd
	 */
	public void setManLoclCurrCd(String manLoclCurrCd) {
		this.manLoclCurrCd = manLoclCurrCd;
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
		setTtlLoclCurrCd(JSPUtil.getParameter(request, prefix + "ttl_locl_curr_cd", ""));
		setFmYdCd(JSPUtil.getParameter(request, prefix + "fm_yd_cd", ""));
		setFmlUsdAmt40ft(JSPUtil.getParameter(request, prefix + "fml_usd_amt_40ft", ""));
		setManLoclAmt20ft(JSPUtil.getParameter(request, prefix + "man_locl_amt_20ft", ""));
		setFmlLoclCurrCd(JSPUtil.getParameter(request, prefix + "fml_locl_curr_cd", ""));
		setChkAuthYn(JSPUtil.getParameter(request, prefix + "chk_auth_yn", ""));
		setSumUsdAmt20ft(JSPUtil.getParameter(request, prefix + "sum_usd_amt_20ft", ""));
		setTmlCd(JSPUtil.getParameter(request, prefix + "tml_cd", ""));
		setToYdCd(JSPUtil.getParameter(request, prefix + "to_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setSpclCgoRefSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_ref_seq", ""));
		setTrfCond(JSPUtil.getParameter(request, prefix + "trf_cond", ""));
		setToNodYdNo(JSPUtil.getParameter(request, prefix + "to_nod_yd_no", ""));
		setUsdXchDt(JSPUtil.getParameter(request, prefix + "usd_xch_dt", ""));
		setChkSpclCgoRefSeq(JSPUtil.getParameter(request, prefix + "chk_spcl_cgo_ref_seq", ""));
		setTtlUsdAmt40ft(JSPUtil.getParameter(request, prefix + "ttl_usd_amt_40ft", ""));
		setCondNo(JSPUtil.getParameter(request, prefix + "cond_no", ""));
		setLclAmt(JSPUtil.getParameter(request, prefix + "lcl_amt", ""));
		setManUsdAmt40ft(JSPUtil.getParameter(request, prefix + "man_usd_amt_40ft", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSelectRow(JSPUtil.getParameter(request, prefix + "select_row", ""));
		setManUsdAmt20ft(JSPUtil.getParameter(request, prefix + "man_usd_amt_20ft", ""));
		setAutoUsdAmt40ft(JSPUtil.getParameter(request, prefix + "auto_usd_amt_40ft", ""));
		setFmlLoclAmt20ft(JSPUtil.getParameter(request, prefix + "fml_locl_amt_20ft", ""));
		setIoGaCd(JSPUtil.getParameter(request, prefix + "io_ga_cd", ""));
		setLstUpdUsrId(JSPUtil.getParameter(request, prefix + "lst_upd_usr_id", ""));
		setAmt(JSPUtil.getParameter(request, prefix + "amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChkFlg(JSPUtil.getParameter(request, prefix + "chk_flg", ""));
		setActYdOfcAuthYn(JSPUtil.getParameter(request, prefix + "act_yd_ofc_auth_yn", ""));
		setFmlLoclAmt40ft(JSPUtil.getParameter(request, prefix + "fml_locl_amt_40ft", ""));
		setCondDesc(JSPUtil.getParameter(request, prefix + "cond_desc", ""));
		setLstUpdDt(JSPUtil.getParameter(request, prefix + "lst_upd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCalcUsdAmt40ft(JSPUtil.getParameter(request, prefix + "calc_usd_amt_40ft", ""));
		setMnYdFlg(JSPUtil.getParameter(request, prefix + "mn_yd_flg", ""));
		setFmlUsdAmt20ft(JSPUtil.getParameter(request, prefix + "fml_usd_amt_20ft", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCalcUsdAmt20ft(JSPUtil.getParameter(request, prefix + "calc_usd_amt_20ft", ""));
		setTtlLoclAmt40ft(JSPUtil.getParameter(request, prefix + "ttl_locl_amt_40ft", ""));
		setTtlUsdAmt20ft(JSPUtil.getParameter(request, prefix + "ttl_usd_amt_20ft", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLgOfcCd(JSPUtil.getParameter(request, prefix + "lg_ofc_cd", ""));
		setCondNoT3(JSPUtil.getParameter(request, prefix + "cond_no_t3", ""));
		setFmLocCd(JSPUtil.getParameter(request, prefix + "fm_loc_cd", ""));
		setTtlLoclAmt20ft(JSPUtil.getParameter(request, prefix + "ttl_locl_amt_20ft", ""));
		setAutoUsdAmt20ft(JSPUtil.getParameter(request, prefix + "auto_usd_amt_20ft", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setTmlAwkTsCd(JSPUtil.getParameter(request, prefix + "tml_awk_ts_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSelectCol(JSPUtil.getParameter(request, prefix + "select_col", ""));
		setCalcRmk(JSPUtil.getParameter(request, prefix + "calc_rmk", ""));
		setToLocCd(JSPUtil.getParameter(request, prefix + "to_loc_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setAplyRto(JSPUtil.getParameter(request, prefix + "aply_rto", ""));
		setFmNodYdNo(JSPUtil.getParameter(request, prefix + "fm_nod_yd_no", ""));
		setYearMonth(JSPUtil.getParameter(request, prefix + "year_month", ""));
		setTmlActCostSeq(JSPUtil.getParameter(request, prefix + "tml_act_cost_seq", ""));
		setManLoclAmt40ft(JSPUtil.getParameter(request, prefix + "man_locl_amt_40ft", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTmlAwkCgoTrfTpCd(JSPUtil.getParameter(request, prefix + "tml_awk_cgo_trf_tp_cd", ""));
		setSumUsdAmt40ft(JSPUtil.getParameter(request, prefix + "sum_usd_amt_40ft", ""));
		setTmlAwkTrfVerNo(JSPUtil.getParameter(request, prefix + "tml_awk_trf_ver_no", ""));
		setManLoclCurrCd(JSPUtil.getParameter(request, prefix + "man_locl_curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAwkCgoTrfMngVO[]
	 */
	public TesAwkCgoTrfMngVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAwkCgoTrfMngVO[]
	 */
	public TesAwkCgoTrfMngVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAwkCgoTrfMngVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "ttl_locl_curr_cd", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] fmlUsdAmt40ft = (JSPUtil.getParameter(request, prefix	+ "fml_usd_amt_40ft", length));
			String[] manLoclAmt20ft = (JSPUtil.getParameter(request, prefix	+ "man_locl_amt_20ft", length));
			String[] fmlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "fml_locl_curr_cd", length));
			String[] chkAuthYn = (JSPUtil.getParameter(request, prefix	+ "chk_auth_yn", length));
			String[] sumUsdAmt20ft = (JSPUtil.getParameter(request, prefix	+ "sum_usd_amt_20ft", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] spclCgoRefSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_ref_seq", length));
			String[] trfCond = (JSPUtil.getParameter(request, prefix	+ "trf_cond", length));
			String[] toNodYdNo = (JSPUtil.getParameter(request, prefix	+ "to_nod_yd_no", length));
			String[] usdXchDt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_dt", length));
			String[] chkSpclCgoRefSeq = (JSPUtil.getParameter(request, prefix	+ "chk_spcl_cgo_ref_seq", length));
			String[] ttlUsdAmt40ft = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt_40ft", length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no", length));
			String[] lclAmt = (JSPUtil.getParameter(request, prefix	+ "lcl_amt", length));
			String[] manUsdAmt40ft = (JSPUtil.getParameter(request, prefix	+ "man_usd_amt_40ft", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] selectRow = (JSPUtil.getParameter(request, prefix	+ "select_row", length));
			String[] manUsdAmt20ft = (JSPUtil.getParameter(request, prefix	+ "man_usd_amt_20ft", length));
			String[] autoUsdAmt40ft = (JSPUtil.getParameter(request, prefix	+ "auto_usd_amt_40ft", length));
			String[] fmlLoclAmt20ft = (JSPUtil.getParameter(request, prefix	+ "fml_locl_amt_20ft", length));
			String[] ioGaCd = (JSPUtil.getParameter(request, prefix	+ "io_ga_cd", length));
			String[] lstUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "lst_upd_usr_id", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chkFlg = (JSPUtil.getParameter(request, prefix	+ "chk_flg", length));
			String[] actYdOfcAuthYn = (JSPUtil.getParameter(request, prefix	+ "act_yd_ofc_auth_yn", length));
			String[] fmlLoclAmt40ft = (JSPUtil.getParameter(request, prefix	+ "fml_locl_amt_40ft", length));
			String[] condDesc = (JSPUtil.getParameter(request, prefix	+ "cond_desc", length));
			String[] lstUpdDt = (JSPUtil.getParameter(request, prefix	+ "lst_upd_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] calcUsdAmt40ft = (JSPUtil.getParameter(request, prefix	+ "calc_usd_amt_40ft", length));
			String[] mnYdFlg = (JSPUtil.getParameter(request, prefix	+ "mn_yd_flg", length));
			String[] fmlUsdAmt20ft = (JSPUtil.getParameter(request, prefix	+ "fml_usd_amt_20ft", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] calcUsdAmt20ft = (JSPUtil.getParameter(request, prefix	+ "calc_usd_amt_20ft", length));
			String[] ttlLoclAmt40ft = (JSPUtil.getParameter(request, prefix	+ "ttl_locl_amt_40ft", length));
			String[] ttlUsdAmt20ft = (JSPUtil.getParameter(request, prefix	+ "ttl_usd_amt_20ft", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lgOfcCd = (JSPUtil.getParameter(request, prefix	+ "lg_ofc_cd", length));
			String[] condNoT3 = (JSPUtil.getParameter(request, prefix	+ "cond_no_t3", length));
			String[] fmLocCd = (JSPUtil.getParameter(request, prefix	+ "fm_loc_cd", length));
			String[] ttlLoclAmt20ft = (JSPUtil.getParameter(request, prefix	+ "ttl_locl_amt_20ft", length));
			String[] autoUsdAmt20ft = (JSPUtil.getParameter(request, prefix	+ "auto_usd_amt_20ft", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] tmlAwkTsCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_ts_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] selectCol = (JSPUtil.getParameter(request, prefix	+ "select_col", length));
			String[] calcRmk = (JSPUtil.getParameter(request, prefix	+ "calc_rmk", length));
			String[] toLocCd = (JSPUtil.getParameter(request, prefix	+ "to_loc_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] aplyRto = (JSPUtil.getParameter(request, prefix	+ "aply_rto", length));
			String[] fmNodYdNo = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yd_no", length));
			String[] yearMonth = (JSPUtil.getParameter(request, prefix	+ "year_month", length));
			String[] tmlActCostSeq = (JSPUtil.getParameter(request, prefix	+ "tml_act_cost_seq", length));
			String[] manLoclAmt40ft = (JSPUtil.getParameter(request, prefix	+ "man_locl_amt_40ft", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] tmlAwkCgoTrfTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_awk_cgo_trf_tp_cd", length));
			String[] sumUsdAmt40ft = (JSPUtil.getParameter(request, prefix	+ "sum_usd_amt_40ft", length));
			String[] tmlAwkTrfVerNo = (JSPUtil.getParameter(request, prefix	+ "tml_awk_trf_ver_no", length));
			String[] manLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "man_locl_curr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAwkCgoTrfMngVO();
				if (ttlLoclCurrCd[i] != null)
					model.setTtlLoclCurrCd(ttlLoclCurrCd[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (fmlUsdAmt40ft[i] != null)
					model.setFmlUsdAmt40ft(fmlUsdAmt40ft[i]);
				if (manLoclAmt20ft[i] != null)
					model.setManLoclAmt20ft(manLoclAmt20ft[i]);
				if (fmlLoclCurrCd[i] != null)
					model.setFmlLoclCurrCd(fmlLoclCurrCd[i]);
				if (chkAuthYn[i] != null)
					model.setChkAuthYn(chkAuthYn[i]);
				if (sumUsdAmt20ft[i] != null)
					model.setSumUsdAmt20ft(sumUsdAmt20ft[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (spclCgoRefSeq[i] != null)
					model.setSpclCgoRefSeq(spclCgoRefSeq[i]);
				if (trfCond[i] != null)
					model.setTrfCond(trfCond[i]);
				if (toNodYdNo[i] != null)
					model.setToNodYdNo(toNodYdNo[i]);
				if (usdXchDt[i] != null)
					model.setUsdXchDt(usdXchDt[i]);
				if (chkSpclCgoRefSeq[i] != null)
					model.setChkSpclCgoRefSeq(chkSpclCgoRefSeq[i]);
				if (ttlUsdAmt40ft[i] != null)
					model.setTtlUsdAmt40ft(ttlUsdAmt40ft[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				if (lclAmt[i] != null)
					model.setLclAmt(lclAmt[i]);
				if (manUsdAmt40ft[i] != null)
					model.setManUsdAmt40ft(manUsdAmt40ft[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (selectRow[i] != null)
					model.setSelectRow(selectRow[i]);
				if (manUsdAmt20ft[i] != null)
					model.setManUsdAmt20ft(manUsdAmt20ft[i]);
				if (autoUsdAmt40ft[i] != null)
					model.setAutoUsdAmt40ft(autoUsdAmt40ft[i]);
				if (fmlLoclAmt20ft[i] != null)
					model.setFmlLoclAmt20ft(fmlLoclAmt20ft[i]);
				if (ioGaCd[i] != null)
					model.setIoGaCd(ioGaCd[i]);
				if (lstUpdUsrId[i] != null)
					model.setLstUpdUsrId(lstUpdUsrId[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chkFlg[i] != null)
					model.setChkFlg(chkFlg[i]);
				if (actYdOfcAuthYn[i] != null)
					model.setActYdOfcAuthYn(actYdOfcAuthYn[i]);
				if (fmlLoclAmt40ft[i] != null)
					model.setFmlLoclAmt40ft(fmlLoclAmt40ft[i]);
				if (condDesc[i] != null)
					model.setCondDesc(condDesc[i]);
				if (lstUpdDt[i] != null)
					model.setLstUpdDt(lstUpdDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (calcUsdAmt40ft[i] != null)
					model.setCalcUsdAmt40ft(calcUsdAmt40ft[i]);
				if (mnYdFlg[i] != null)
					model.setMnYdFlg(mnYdFlg[i]);
				if (fmlUsdAmt20ft[i] != null)
					model.setFmlUsdAmt20ft(fmlUsdAmt20ft[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (calcUsdAmt20ft[i] != null)
					model.setCalcUsdAmt20ft(calcUsdAmt20ft[i]);
				if (ttlLoclAmt40ft[i] != null)
					model.setTtlLoclAmt40ft(ttlLoclAmt40ft[i]);
				if (ttlUsdAmt20ft[i] != null)
					model.setTtlUsdAmt20ft(ttlUsdAmt20ft[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lgOfcCd[i] != null)
					model.setLgOfcCd(lgOfcCd[i]);
				if (condNoT3[i] != null)
					model.setCondNoT3(condNoT3[i]);
				if (fmLocCd[i] != null)
					model.setFmLocCd(fmLocCd[i]);
				if (ttlLoclAmt20ft[i] != null)
					model.setTtlLoclAmt20ft(ttlLoclAmt20ft[i]);
				if (autoUsdAmt20ft[i] != null)
					model.setAutoUsdAmt20ft(autoUsdAmt20ft[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (tmlAwkTsCd[i] != null)
					model.setTmlAwkTsCd(tmlAwkTsCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (selectCol[i] != null)
					model.setSelectCol(selectCol[i]);
				if (calcRmk[i] != null)
					model.setCalcRmk(calcRmk[i]);
				if (toLocCd[i] != null)
					model.setToLocCd(toLocCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (aplyRto[i] != null)
					model.setAplyRto(aplyRto[i]);
				if (fmNodYdNo[i] != null)
					model.setFmNodYdNo(fmNodYdNo[i]);
				if (yearMonth[i] != null)
					model.setYearMonth(yearMonth[i]);
				if (tmlActCostSeq[i] != null)
					model.setTmlActCostSeq(tmlActCostSeq[i]);
				if (manLoclAmt40ft[i] != null)
					model.setManLoclAmt40ft(manLoclAmt40ft[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (tmlAwkCgoTrfTpCd[i] != null)
					model.setTmlAwkCgoTrfTpCd(tmlAwkCgoTrfTpCd[i]);
				if (sumUsdAmt40ft[i] != null)
					model.setSumUsdAmt40ft(sumUsdAmt40ft[i]);
				if (tmlAwkTrfVerNo[i] != null)
					model.setTmlAwkTrfVerNo(tmlAwkTrfVerNo[i]);
				if (manLoclCurrCd[i] != null)
					model.setManLoclCurrCd(manLoclCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAwkCgoTrfMngVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAwkCgoTrfMngVO[]
	 */
	public TesAwkCgoTrfMngVO[] getTesAwkCgoTrfMngVOs(){
		TesAwkCgoTrfMngVO[] vos = (TesAwkCgoTrfMngVO[])models.toArray(new TesAwkCgoTrfMngVO[models.size()]);
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
		this.ttlLoclCurrCd = this.ttlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmlUsdAmt40ft = this.fmlUsdAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manLoclAmt20ft = this.manLoclAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmlLoclCurrCd = this.fmlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAuthYn = this.chkAuthYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumUsdAmt20ft = this.sumUsdAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRefSeq = this.spclCgoRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCond = this.trfCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYdNo = this.toNodYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchDt = this.usdXchDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkSpclCgoRefSeq = this.chkSpclCgoRefSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt40ft = this.ttlUsdAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclAmt = this.lclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manUsdAmt40ft = this.manUsdAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectRow = this.selectRow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manUsdAmt20ft = this.manUsdAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoUsdAmt40ft = this.autoUsdAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmlLoclAmt20ft = this.fmlLoclAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioGaCd = this.ioGaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUpdUsrId = this.lstUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg = this.chkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actYdOfcAuthYn = this.actYdOfcAuthYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmlLoclAmt40ft = this.fmlLoclAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condDesc = this.condDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstUpdDt = this.lstUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcUsdAmt40ft = this.calcUsdAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnYdFlg = this.mnYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmlUsdAmt20ft = this.fmlUsdAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcUsdAmt20ft = this.calcUsdAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoclAmt40ft = this.ttlLoclAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUsdAmt20ft = this.ttlUsdAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgOfcCd = this.lgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNoT3 = this.condNoT3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLocCd = this.fmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLoclAmt20ft = this.ttlLoclAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoUsdAmt20ft = this.autoUsdAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkTsCd = this.tmlAwkTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectCol = this.selectCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk = this.calcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocCd = this.toLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyRto = this.aplyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYdNo = this.fmNodYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yearMonth = this.yearMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlActCostSeq = this.tmlActCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manLoclAmt40ft = this.manLoclAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkCgoTrfTpCd = this.tmlAwkCgoTrfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumUsdAmt40ft = this.sumUsdAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAwkTrfVerNo = this.tmlAwkTrfVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manLoclCurrCd = this.manLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
