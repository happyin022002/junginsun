/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriTrfInlndRtVO.java
*@FileTitle : RsltPriTrfInlndRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.12.29 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.tariff.inlandrates.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriTrfInlndRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriTrfInlndRtVO> models = new ArrayList<RsltPriTrfInlndRtVO>();
	
	/* Column Info */
	private String trfInlndSeq = null;
	/* Column Info */
	private String inlndOneWy45ftRtAmtProp = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String inlnd20ftRtAmt = null;
	/* Column Info */
	private String srcInfoCdProp = null;
	/* Column Info */
	private String prcInlndRtTrspModCd = null;
	/* Column Info */
	private String inlndOneWy45ftRtAmt = null;
	/* Column Info */
	private String inlndOneWy40ftHcRtAmtPp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inlndRtBseLocCd = null;
	/* Column Info */
	private String inlndRtViaLocCd = null;
	/* Column Info */
	private String inlndRtLmtWgtUtCd = null;
	/* Column Info */
	private String inlndRtLmtWgtUtCdProp = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String prcCgoTpCdProp = null;
	/* Column Info */
	private String inlndRtBseLocZipCdProp = null;
	/* Column Info */
	private String trfInlndStsCd = null;
	/* Column Info */
	private String inlndOneWy40ftRtAmt = null;
	/* Column Info */
	private String inlndRtRmkProp = null;
	/* Column Info */
	private String inlndRtMinLmtWgt = null;
	/* Column Info */
	private String inlndOneWy20ftRtAmt = null;
	/* Column Info */
	private String inlndRtLmtWgtProp = null;
	/* Column Info */
	private String inlndOneWyBxRtAmtProp = null;
	/* Column Info */
	private String inlndRtTermCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String inlnd40ftHcRtAmtProp = null;
	/* Column Info */
	private String inlndRtMinLmtWgtProp = null;
	/* Column Info */
	private String prcInlndRtTrspModCdProp = null;
	/* Column Info */
	private String inlnd45ftRtAmt = null;
	/* Column Info */
	private String inlndRtViaLocCdProp = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String inlndOneWy40ftRtAmtProp = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String inlndRtBseLocCdProp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inlnd40ftRtAmtProp = null;
	/* Column Info */
	private String inlndRtLmtWgt = null;
	/* Column Info */
	private String inlndBxRtAmt = null;
	/* Column Info */
	private String inlndBxRtAmtProp = null;
	/* Column Info */
	private String inlndOneWy40ftHcRtAmt = null;
	/* Column Info */
	private String colorFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String currCdProp = null;
	/* Column Info */
	private String inlndRtBseLocNm = null;
	/* Column Info */
	private String trfInlndRtSeq = null;
	/* Column Info */
	private String inputFlg = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String inlndRtBseLocNmProp = null;
	/* Column Info */
	private String inlnd40ftHcRtAmt = null;
	/* Column Info */
	private String inlndOneWy20ftRtAmtProp = null;
	/* Column Info */
	private String inlnd40ftRtAmt = null;
	/* Column Info */
	private String rowProperties = null;
	/* Column Info */
	private String inlndRtRmk = null;
	/* Column Info */
	private String inlnd45ftRtAmtProp = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String inlndRtBseLocZipCd = null;
	/* Column Info */
	private String inlndOneWyBxRtAmt = null;
	/* Column Info */
	private String inlndRtTermCdProp = null;
	/* Column Info */
	private String inlnd20ftRtAmtProp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriTrfInlndRtVO() {}

	public RsltPriTrfInlndRtVO(String ibflag, String pagerows, String trfPfxCd, String trfNo, String trfInlndSeq, String amdtSeq, String trfInlndRtSeq, String inlndRtBseLocCd, String inlndRtBseLocCdProp, String inlndRtBseLocNm, String inlndRtBseLocNmProp, String inlndRtBseLocZipCd, String inlndRtBseLocZipCdProp, String inlndRtTermCd, String inlndRtTermCdProp, String inlndRtViaLocCd, String inlndRtViaLocCdProp, String prcInlndRtTrspModCd, String prcInlndRtTrspModCdProp, String inlndRtLmtWgt, String inlndRtLmtWgtProp, String inlndRtMinLmtWgt, String inlndRtMinLmtWgtProp, String inlndRtLmtWgtUtCd, String inlndRtLmtWgtUtCdProp, String prcCgoTpCd, String prcCgoTpCdProp, String currCd, String currCdProp, String inlndBxRtAmt, String inlndBxRtAmtProp, String inlnd20ftRtAmt, String inlnd20ftRtAmtProp, String inlnd40ftRtAmt, String inlnd40ftRtAmtProp, String inlnd40ftHcRtAmt, String inlnd40ftHcRtAmtProp, String inlnd45ftRtAmt, String inlnd45ftRtAmtProp, String inlndOneWyBxRtAmt, String inlndOneWyBxRtAmtProp, String inlndOneWy20ftRtAmt, String inlndOneWy20ftRtAmtProp, String inlndOneWy40ftRtAmt, String inlndOneWy40ftRtAmtProp, String inlndOneWy40ftHcRtAmt, String inlndOneWy40ftHcRtAmtPp, String inlndOneWy45ftRtAmt, String inlndOneWy45ftRtAmtProp, String inlndRtRmk, String inlndRtRmkProp, String n1stCmncAmdtSeq, String srcInfoCd, String srcInfoCdProp, String creUsrId, String creDt, String updUsrId, String updDt, String inputFlg, String colorFlg, String trfInlndStsCd, String rqstOfcCd, String rowProperties) {
		this.trfInlndSeq = trfInlndSeq;
		this.inlndOneWy45ftRtAmtProp = inlndOneWy45ftRtAmtProp;
		this.amdtSeq = amdtSeq;
		this.inlnd20ftRtAmt = inlnd20ftRtAmt;
		this.srcInfoCdProp = srcInfoCdProp;
		this.prcInlndRtTrspModCd = prcInlndRtTrspModCd;
		this.inlndOneWy45ftRtAmt = inlndOneWy45ftRtAmt;
		this.inlndOneWy40ftHcRtAmtPp = inlndOneWy40ftHcRtAmtPp;
		this.pagerows = pagerows;
		this.inlndRtBseLocCd = inlndRtBseLocCd;
		this.inlndRtViaLocCd = inlndRtViaLocCd;
		this.inlndRtLmtWgtUtCd = inlndRtLmtWgtUtCd;
		this.inlndRtLmtWgtUtCdProp = inlndRtLmtWgtUtCdProp;
		this.trfPfxCd = trfPfxCd;
		this.updUsrId = updUsrId;
		this.prcCgoTpCdProp = prcCgoTpCdProp;
		this.inlndRtBseLocZipCdProp = inlndRtBseLocZipCdProp;
		this.trfInlndStsCd = trfInlndStsCd;
		this.inlndOneWy40ftRtAmt = inlndOneWy40ftRtAmt;
		this.inlndRtRmkProp = inlndRtRmkProp;
		this.inlndRtMinLmtWgt = inlndRtMinLmtWgt;
		this.inlndOneWy20ftRtAmt = inlndOneWy20ftRtAmt;
		this.inlndRtLmtWgtProp = inlndRtLmtWgtProp;
		this.inlndOneWyBxRtAmtProp = inlndOneWyBxRtAmtProp;
		this.inlndRtTermCd = inlndRtTermCd;
		this.creUsrId = creUsrId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.trfNo = trfNo;
		this.inlnd40ftHcRtAmtProp = inlnd40ftHcRtAmtProp;
		this.inlndRtMinLmtWgtProp = inlndRtMinLmtWgtProp;
		this.prcInlndRtTrspModCdProp = prcInlndRtTrspModCdProp;
		this.inlnd45ftRtAmt = inlnd45ftRtAmt;
		this.inlndRtViaLocCdProp = inlndRtViaLocCdProp;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.inlndOneWy40ftRtAmtProp = inlndOneWy40ftRtAmtProp;
		this.creDt = creDt;
		this.inlndRtBseLocCdProp = inlndRtBseLocCdProp;
		this.ibflag = ibflag;
		this.inlnd40ftRtAmtProp = inlnd40ftRtAmtProp;
		this.inlndRtLmtWgt = inlndRtLmtWgt;
		this.inlndBxRtAmt = inlndBxRtAmt;
		this.inlndBxRtAmtProp = inlndBxRtAmtProp;
		this.inlndOneWy40ftHcRtAmt = inlndOneWy40ftHcRtAmt;
		this.colorFlg = colorFlg;
		this.updDt = updDt;
		this.currCdProp = currCdProp;
		this.inlndRtBseLocNm = inlndRtBseLocNm;
		this.trfInlndRtSeq = trfInlndRtSeq;
		this.inputFlg = inputFlg;
		this.srcInfoCd = srcInfoCd;
		this.inlndRtBseLocNmProp = inlndRtBseLocNmProp;
		this.inlnd40ftHcRtAmt = inlnd40ftHcRtAmt;
		this.inlndOneWy20ftRtAmtProp = inlndOneWy20ftRtAmtProp;
		this.inlnd40ftRtAmt = inlnd40ftRtAmt;
		this.rowProperties = rowProperties;
		this.inlndRtRmk = inlndRtRmk;
		this.inlnd45ftRtAmtProp = inlnd45ftRtAmtProp;
		this.rqstOfcCd = rqstOfcCd;
		this.inlndRtBseLocZipCd = inlndRtBseLocZipCd;
		this.inlndOneWyBxRtAmt = inlndOneWyBxRtAmt;
		this.inlndRtTermCdProp = inlndRtTermCdProp;
		this.inlnd20ftRtAmtProp = inlnd20ftRtAmtProp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trf_inlnd_seq", getTrfInlndSeq());
		this.hashColumns.put("inlnd_one_wy_45ft_rt_amt_prop", getInlndOneWy45ftRtAmtProp());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("inlnd_20ft_rt_amt", getInlnd20ftRtAmt());
		this.hashColumns.put("src_info_cd_prop", getSrcInfoCdProp());
		this.hashColumns.put("prc_inlnd_rt_trsp_mod_cd", getPrcInlndRtTrspModCd());
		this.hashColumns.put("inlnd_one_wy_45ft_rt_amt", getInlndOneWy45ftRtAmt());
		this.hashColumns.put("inlnd_one_wy_40ft_hc_rt_amt_pp", getInlndOneWy40ftHcRtAmtPp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inlnd_rt_bse_loc_cd", getInlndRtBseLocCd());
		this.hashColumns.put("inlnd_rt_via_loc_cd", getInlndRtViaLocCd());
		this.hashColumns.put("inlnd_rt_lmt_wgt_ut_cd", getInlndRtLmtWgtUtCd());
		this.hashColumns.put("inlnd_rt_lmt_wgt_ut_cd_prop", getInlndRtLmtWgtUtCdProp());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prc_cgo_tp_cd_prop", getPrcCgoTpCdProp());
		this.hashColumns.put("inlnd_rt_bse_loc_zip_cd_prop", getInlndRtBseLocZipCdProp());
		this.hashColumns.put("trf_inlnd_sts_cd", getTrfInlndStsCd());
		this.hashColumns.put("inlnd_one_wy_40ft_rt_amt", getInlndOneWy40ftRtAmt());
		this.hashColumns.put("inlnd_rt_rmk_prop", getInlndRtRmkProp());
		this.hashColumns.put("inlnd_rt_min_lmt_wgt", getInlndRtMinLmtWgt());
		this.hashColumns.put("inlnd_one_wy_20ft_rt_amt", getInlndOneWy20ftRtAmt());
		this.hashColumns.put("inlnd_rt_lmt_wgt_prop", getInlndRtLmtWgtProp());
		this.hashColumns.put("inlnd_one_wy_bx_rt_amt_prop", getInlndOneWyBxRtAmtProp());
		this.hashColumns.put("inlnd_rt_term_cd", getInlndRtTermCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("inlnd_40ft_hc_rt_amt_prop", getInlnd40ftHcRtAmtProp());
		this.hashColumns.put("inlnd_rt_min_lmt_wgt_prop", getInlndRtMinLmtWgtProp());
		this.hashColumns.put("prc_inlnd_rt_trsp_mod_cd_prop", getPrcInlndRtTrspModCdProp());
		this.hashColumns.put("inlnd_45ft_rt_amt", getInlnd45ftRtAmt());
		this.hashColumns.put("inlnd_rt_via_loc_cd_prop", getInlndRtViaLocCdProp());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("inlnd_one_wy_40ft_rt_amt_prop", getInlndOneWy40ftRtAmtProp());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inlnd_rt_bse_loc_cd_prop", getInlndRtBseLocCdProp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inlnd_40ft_rt_amt_prop", getInlnd40ftRtAmtProp());
		this.hashColumns.put("inlnd_rt_lmt_wgt", getInlndRtLmtWgt());
		this.hashColumns.put("inlnd_bx_rt_amt", getInlndBxRtAmt());
		this.hashColumns.put("inlnd_bx_rt_amt_prop", getInlndBxRtAmtProp());
		this.hashColumns.put("inlnd_one_wy_40ft_hc_rt_amt", getInlndOneWy40ftHcRtAmt());
		this.hashColumns.put("color_flg", getColorFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("curr_cd_prop", getCurrCdProp());
		this.hashColumns.put("inlnd_rt_bse_loc_nm", getInlndRtBseLocNm());
		this.hashColumns.put("trf_inlnd_rt_seq", getTrfInlndRtSeq());
		this.hashColumns.put("input_flg", getInputFlg());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("inlnd_rt_bse_loc_nm_prop", getInlndRtBseLocNmProp());
		this.hashColumns.put("inlnd_40ft_hc_rt_amt", getInlnd40ftHcRtAmt());
		this.hashColumns.put("inlnd_one_wy_20ft_rt_amt_prop", getInlndOneWy20ftRtAmtProp());
		this.hashColumns.put("inlnd_40ft_rt_amt", getInlnd40ftRtAmt());
		this.hashColumns.put("row_properties", getRowProperties());
		this.hashColumns.put("inlnd_rt_rmk", getInlndRtRmk());
		this.hashColumns.put("inlnd_45ft_rt_amt_prop", getInlnd45ftRtAmtProp());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("inlnd_rt_bse_loc_zip_cd", getInlndRtBseLocZipCd());
		this.hashColumns.put("inlnd_one_wy_bx_rt_amt", getInlndOneWyBxRtAmt());
		this.hashColumns.put("inlnd_rt_term_cd_prop", getInlndRtTermCdProp());
		this.hashColumns.put("inlnd_20ft_rt_amt_prop", getInlnd20ftRtAmtProp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trf_inlnd_seq", "trfInlndSeq");
		this.hashFields.put("inlnd_one_wy_45ft_rt_amt_prop", "inlndOneWy45ftRtAmtProp");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("inlnd_20ft_rt_amt", "inlnd20ftRtAmt");
		this.hashFields.put("src_info_cd_prop", "srcInfoCdProp");
		this.hashFields.put("prc_inlnd_rt_trsp_mod_cd", "prcInlndRtTrspModCd");
		this.hashFields.put("inlnd_one_wy_45ft_rt_amt", "inlndOneWy45ftRtAmt");
		this.hashFields.put("inlnd_one_wy_40ft_hc_rt_amt_pp", "inlndOneWy40ftHcRtAmtPp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inlnd_rt_bse_loc_cd", "inlndRtBseLocCd");
		this.hashFields.put("inlnd_rt_via_loc_cd", "inlndRtViaLocCd");
		this.hashFields.put("inlnd_rt_lmt_wgt_ut_cd", "inlndRtLmtWgtUtCd");
		this.hashFields.put("inlnd_rt_lmt_wgt_ut_cd_prop", "inlndRtLmtWgtUtCdProp");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prc_cgo_tp_cd_prop", "prcCgoTpCdProp");
		this.hashFields.put("inlnd_rt_bse_loc_zip_cd_prop", "inlndRtBseLocZipCdProp");
		this.hashFields.put("trf_inlnd_sts_cd", "trfInlndStsCd");
		this.hashFields.put("inlnd_one_wy_40ft_rt_amt", "inlndOneWy40ftRtAmt");
		this.hashFields.put("inlnd_rt_rmk_prop", "inlndRtRmkProp");
		this.hashFields.put("inlnd_rt_min_lmt_wgt", "inlndRtMinLmtWgt");
		this.hashFields.put("inlnd_one_wy_20ft_rt_amt", "inlndOneWy20ftRtAmt");
		this.hashFields.put("inlnd_rt_lmt_wgt_prop", "inlndRtLmtWgtProp");
		this.hashFields.put("inlnd_one_wy_bx_rt_amt_prop", "inlndOneWyBxRtAmtProp");
		this.hashFields.put("inlnd_rt_term_cd", "inlndRtTermCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("inlnd_40ft_hc_rt_amt_prop", "inlnd40ftHcRtAmtProp");
		this.hashFields.put("inlnd_rt_min_lmt_wgt_prop", "inlndRtMinLmtWgtProp");
		this.hashFields.put("prc_inlnd_rt_trsp_mod_cd_prop", "prcInlndRtTrspModCdProp");
		this.hashFields.put("inlnd_45ft_rt_amt", "inlnd45ftRtAmt");
		this.hashFields.put("inlnd_rt_via_loc_cd_prop", "inlndRtViaLocCdProp");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("inlnd_one_wy_40ft_rt_amt_prop", "inlndOneWy40ftRtAmtProp");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inlnd_rt_bse_loc_cd_prop", "inlndRtBseLocCdProp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inlnd_40ft_rt_amt_prop", "inlnd40ftRtAmtProp");
		this.hashFields.put("inlnd_rt_lmt_wgt", "inlndRtLmtWgt");
		this.hashFields.put("inlnd_bx_rt_amt", "inlndBxRtAmt");
		this.hashFields.put("inlnd_bx_rt_amt_prop", "inlndBxRtAmtProp");
		this.hashFields.put("inlnd_one_wy_40ft_hc_rt_amt", "inlndOneWy40ftHcRtAmt");
		this.hashFields.put("color_flg", "colorFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("curr_cd_prop", "currCdProp");
		this.hashFields.put("inlnd_rt_bse_loc_nm", "inlndRtBseLocNm");
		this.hashFields.put("trf_inlnd_rt_seq", "trfInlndRtSeq");
		this.hashFields.put("input_flg", "inputFlg");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("inlnd_rt_bse_loc_nm_prop", "inlndRtBseLocNmProp");
		this.hashFields.put("inlnd_40ft_hc_rt_amt", "inlnd40ftHcRtAmt");
		this.hashFields.put("inlnd_one_wy_20ft_rt_amt_prop", "inlndOneWy20ftRtAmtProp");
		this.hashFields.put("inlnd_40ft_rt_amt", "inlnd40ftRtAmt");
		this.hashFields.put("row_properties", "rowProperties");
		this.hashFields.put("inlnd_rt_rmk", "inlndRtRmk");
		this.hashFields.put("inlnd_45ft_rt_amt_prop", "inlnd45ftRtAmtProp");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("inlnd_rt_bse_loc_zip_cd", "inlndRtBseLocZipCd");
		this.hashFields.put("inlnd_one_wy_bx_rt_amt", "inlndOneWyBxRtAmt");
		this.hashFields.put("inlnd_rt_term_cd_prop", "inlndRtTermCdProp");
		this.hashFields.put("inlnd_20ft_rt_amt_prop", "inlnd20ftRtAmtProp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trfInlndSeq
	 */
	public String getTrfInlndSeq() {
		return this.trfInlndSeq;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy45ftRtAmtProp
	 */
	public String getInlndOneWy45ftRtAmtProp() {
		return this.inlndOneWy45ftRtAmtProp;
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
	 * @return inlnd20ftRtAmt
	 */
	public String getInlnd20ftRtAmt() {
		return this.inlnd20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCdProp
	 */
	public String getSrcInfoCdProp() {
		return this.srcInfoCdProp;
	}
	
	/**
	 * Column Info
	 * @return prcInlndRtTrspModCd
	 */
	public String getPrcInlndRtTrspModCd() {
		return this.prcInlndRtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy45ftRtAmt
	 */
	public String getInlndOneWy45ftRtAmt() {
		return this.inlndOneWy45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy40ftHcRtAmtPp
	 */
	public String getInlndOneWy40ftHcRtAmtPp() {
		return this.inlndOneWy40ftHcRtAmtPp;
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
	 * @return inlndRtBseLocCd
	 */
	public String getInlndRtBseLocCd() {
		return this.inlndRtBseLocCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRtViaLocCd
	 */
	public String getInlndRtViaLocCd() {
		return this.inlndRtViaLocCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRtLmtWgtUtCd
	 */
	public String getInlndRtLmtWgtUtCd() {
		return this.inlndRtLmtWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRtLmtWgtUtCdProp
	 */
	public String getInlndRtLmtWgtUtCdProp() {
		return this.inlndRtLmtWgtUtCdProp;
	}
	
	/**
	 * Column Info
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
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
	 * @return prcCgoTpCdProp
	 */
	public String getPrcCgoTpCdProp() {
		return this.prcCgoTpCdProp;
	}
	
	/**
	 * Column Info
	 * @return inlndRtBseLocZipCdProp
	 */
	public String getInlndRtBseLocZipCdProp() {
		return this.inlndRtBseLocZipCdProp;
	}
	
	/**
	 * Column Info
	 * @return trfInlndStsCd
	 */
	public String getTrfInlndStsCd() {
		return this.trfInlndStsCd;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy40ftRtAmt
	 */
	public String getInlndOneWy40ftRtAmt() {
		return this.inlndOneWy40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndRtRmkProp
	 */
	public String getInlndRtRmkProp() {
		return this.inlndRtRmkProp;
	}
	
	/**
	 * Column Info
	 * @return inlndRtMinLmtWgt
	 */
	public String getInlndRtMinLmtWgt() {
		return this.inlndRtMinLmtWgt;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy20ftRtAmt
	 */
	public String getInlndOneWy20ftRtAmt() {
		return this.inlndOneWy20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndRtLmtWgtProp
	 */
	public String getInlndRtLmtWgtProp() {
		return this.inlndRtLmtWgtProp;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWyBxRtAmtProp
	 */
	public String getInlndOneWyBxRtAmtProp() {
		return this.inlndOneWyBxRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @return inlndRtTermCd
	 */
	public String getInlndRtTermCd() {
		return this.inlndRtTermCd;
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
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return inlnd40ftHcRtAmtProp
	 */
	public String getInlnd40ftHcRtAmtProp() {
		return this.inlnd40ftHcRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @return inlndRtMinLmtWgtProp
	 */
	public String getInlndRtMinLmtWgtProp() {
		return this.inlndRtMinLmtWgtProp;
	}
	
	/**
	 * Column Info
	 * @return prcInlndRtTrspModCdProp
	 */
	public String getPrcInlndRtTrspModCdProp() {
		return this.prcInlndRtTrspModCdProp;
	}
	
	/**
	 * Column Info
	 * @return inlnd45ftRtAmt
	 */
	public String getInlnd45ftRtAmt() {
		return this.inlnd45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndRtViaLocCdProp
	 */
	public String getInlndRtViaLocCdProp() {
		return this.inlndRtViaLocCdProp;
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
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy40ftRtAmtProp
	 */
	public String getInlndOneWy40ftRtAmtProp() {
		return this.inlndOneWy40ftRtAmtProp;
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
	 * @return inlndRtBseLocCdProp
	 */
	public String getInlndRtBseLocCdProp() {
		return this.inlndRtBseLocCdProp;
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
	 * @return inlnd40ftRtAmtProp
	 */
	public String getInlnd40ftRtAmtProp() {
		return this.inlnd40ftRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @return inlndRtLmtWgt
	 */
	public String getInlndRtLmtWgt() {
		return this.inlndRtLmtWgt;
	}
	
	/**
	 * Column Info
	 * @return inlndBxRtAmt
	 */
	public String getInlndBxRtAmt() {
		return this.inlndBxRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndBxRtAmtProp
	 */
	public String getInlndBxRtAmtProp() {
		return this.inlndBxRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy40ftHcRtAmt
	 */
	public String getInlndOneWy40ftHcRtAmt() {
		return this.inlndOneWy40ftHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return colorFlg
	 */
	public String getColorFlg() {
		return this.colorFlg;
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
	 * @return currCdProp
	 */
	public String getCurrCdProp() {
		return this.currCdProp;
	}
	
	/**
	 * Column Info
	 * @return inlndRtBseLocNm
	 */
	public String getInlndRtBseLocNm() {
		return this.inlndRtBseLocNm;
	}
	
	/**
	 * Column Info
	 * @return trfInlndRtSeq
	 */
	public String getTrfInlndRtSeq() {
		return this.trfInlndRtSeq;
	}
	
	/**
	 * Column Info
	 * @return inputFlg
	 */
	public String getInputFlg() {
		return this.inputFlg;
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
	 * @return inlndRtBseLocNmProp
	 */
	public String getInlndRtBseLocNmProp() {
		return this.inlndRtBseLocNmProp;
	}
	
	/**
	 * Column Info
	 * @return inlnd40ftHcRtAmt
	 */
	public String getInlnd40ftHcRtAmt() {
		return this.inlnd40ftHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWy20ftRtAmtProp
	 */
	public String getInlndOneWy20ftRtAmtProp() {
		return this.inlndOneWy20ftRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @return inlnd40ftRtAmt
	 */
	public String getInlnd40ftRtAmt() {
		return this.inlnd40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return rowProperties
	 */
	public String getRowProperties() {
		return this.rowProperties;
	}
	
	/**
	 * Column Info
	 * @return inlndRtRmk
	 */
	public String getInlndRtRmk() {
		return this.inlndRtRmk;
	}
	
	/**
	 * Column Info
	 * @return inlnd45ftRtAmtProp
	 */
	public String getInlnd45ftRtAmtProp() {
		return this.inlnd45ftRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return inlndRtBseLocZipCd
	 */
	public String getInlndRtBseLocZipCd() {
		return this.inlndRtBseLocZipCd;
	}
	
	/**
	 * Column Info
	 * @return inlndOneWyBxRtAmt
	 */
	public String getInlndOneWyBxRtAmt() {
		return this.inlndOneWyBxRtAmt;
	}
	
	/**
	 * Column Info
	 * @return inlndRtTermCdProp
	 */
	public String getInlndRtTermCdProp() {
		return this.inlndRtTermCdProp;
	}
	
	/**
	 * Column Info
	 * @return inlnd20ftRtAmtProp
	 */
	public String getInlnd20ftRtAmtProp() {
		return this.inlnd20ftRtAmtProp;
	}
	

	/**
	 * Column Info
	 * @param trfInlndSeq
	 */
	public void setTrfInlndSeq(String trfInlndSeq) {
		this.trfInlndSeq = trfInlndSeq;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy45ftRtAmtProp
	 */
	public void setInlndOneWy45ftRtAmtProp(String inlndOneWy45ftRtAmtProp) {
		this.inlndOneWy45ftRtAmtProp = inlndOneWy45ftRtAmtProp;
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
	 * @param inlnd20ftRtAmt
	 */
	public void setInlnd20ftRtAmt(String inlnd20ftRtAmt) {
		this.inlnd20ftRtAmt = inlnd20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCdProp
	 */
	public void setSrcInfoCdProp(String srcInfoCdProp) {
		this.srcInfoCdProp = srcInfoCdProp;
	}
	
	/**
	 * Column Info
	 * @param prcInlndRtTrspModCd
	 */
	public void setPrcInlndRtTrspModCd(String prcInlndRtTrspModCd) {
		this.prcInlndRtTrspModCd = prcInlndRtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy45ftRtAmt
	 */
	public void setInlndOneWy45ftRtAmt(String inlndOneWy45ftRtAmt) {
		this.inlndOneWy45ftRtAmt = inlndOneWy45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy40ftHcRtAmtPp
	 */
	public void setInlndOneWy40ftHcRtAmtPp(String inlndOneWy40ftHcRtAmtPp) {
		this.inlndOneWy40ftHcRtAmtPp = inlndOneWy40ftHcRtAmtPp;
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
	 * @param inlndRtBseLocCd
	 */
	public void setInlndRtBseLocCd(String inlndRtBseLocCd) {
		this.inlndRtBseLocCd = inlndRtBseLocCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRtViaLocCd
	 */
	public void setInlndRtViaLocCd(String inlndRtViaLocCd) {
		this.inlndRtViaLocCd = inlndRtViaLocCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRtLmtWgtUtCd
	 */
	public void setInlndRtLmtWgtUtCd(String inlndRtLmtWgtUtCd) {
		this.inlndRtLmtWgtUtCd = inlndRtLmtWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRtLmtWgtUtCdProp
	 */
	public void setInlndRtLmtWgtUtCdProp(String inlndRtLmtWgtUtCdProp) {
		this.inlndRtLmtWgtUtCdProp = inlndRtLmtWgtUtCdProp;
	}
	
	/**
	 * Column Info
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
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
	 * @param prcCgoTpCdProp
	 */
	public void setPrcCgoTpCdProp(String prcCgoTpCdProp) {
		this.prcCgoTpCdProp = prcCgoTpCdProp;
	}
	
	/**
	 * Column Info
	 * @param inlndRtBseLocZipCdProp
	 */
	public void setInlndRtBseLocZipCdProp(String inlndRtBseLocZipCdProp) {
		this.inlndRtBseLocZipCdProp = inlndRtBseLocZipCdProp;
	}
	
	/**
	 * Column Info
	 * @param trfInlndStsCd
	 */
	public void setTrfInlndStsCd(String trfInlndStsCd) {
		this.trfInlndStsCd = trfInlndStsCd;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy40ftRtAmt
	 */
	public void setInlndOneWy40ftRtAmt(String inlndOneWy40ftRtAmt) {
		this.inlndOneWy40ftRtAmt = inlndOneWy40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndRtRmkProp
	 */
	public void setInlndRtRmkProp(String inlndRtRmkProp) {
		this.inlndRtRmkProp = inlndRtRmkProp;
	}
	
	/**
	 * Column Info
	 * @param inlndRtMinLmtWgt
	 */
	public void setInlndRtMinLmtWgt(String inlndRtMinLmtWgt) {
		this.inlndRtMinLmtWgt = inlndRtMinLmtWgt;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy20ftRtAmt
	 */
	public void setInlndOneWy20ftRtAmt(String inlndOneWy20ftRtAmt) {
		this.inlndOneWy20ftRtAmt = inlndOneWy20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndRtLmtWgtProp
	 */
	public void setInlndRtLmtWgtProp(String inlndRtLmtWgtProp) {
		this.inlndRtLmtWgtProp = inlndRtLmtWgtProp;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWyBxRtAmtProp
	 */
	public void setInlndOneWyBxRtAmtProp(String inlndOneWyBxRtAmtProp) {
		this.inlndOneWyBxRtAmtProp = inlndOneWyBxRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @param inlndRtTermCd
	 */
	public void setInlndRtTermCd(String inlndRtTermCd) {
		this.inlndRtTermCd = inlndRtTermCd;
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
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param inlnd40ftHcRtAmtProp
	 */
	public void setInlnd40ftHcRtAmtProp(String inlnd40ftHcRtAmtProp) {
		this.inlnd40ftHcRtAmtProp = inlnd40ftHcRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @param inlndRtMinLmtWgtProp
	 */
	public void setInlndRtMinLmtWgtProp(String inlndRtMinLmtWgtProp) {
		this.inlndRtMinLmtWgtProp = inlndRtMinLmtWgtProp;
	}
	
	/**
	 * Column Info
	 * @param prcInlndRtTrspModCdProp
	 */
	public void setPrcInlndRtTrspModCdProp(String prcInlndRtTrspModCdProp) {
		this.prcInlndRtTrspModCdProp = prcInlndRtTrspModCdProp;
	}
	
	/**
	 * Column Info
	 * @param inlnd45ftRtAmt
	 */
	public void setInlnd45ftRtAmt(String inlnd45ftRtAmt) {
		this.inlnd45ftRtAmt = inlnd45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndRtViaLocCdProp
	 */
	public void setInlndRtViaLocCdProp(String inlndRtViaLocCdProp) {
		this.inlndRtViaLocCdProp = inlndRtViaLocCdProp;
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
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy40ftRtAmtProp
	 */
	public void setInlndOneWy40ftRtAmtProp(String inlndOneWy40ftRtAmtProp) {
		this.inlndOneWy40ftRtAmtProp = inlndOneWy40ftRtAmtProp;
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
	 * @param inlndRtBseLocCdProp
	 */
	public void setInlndRtBseLocCdProp(String inlndRtBseLocCdProp) {
		this.inlndRtBseLocCdProp = inlndRtBseLocCdProp;
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
	 * @param inlnd40ftRtAmtProp
	 */
	public void setInlnd40ftRtAmtProp(String inlnd40ftRtAmtProp) {
		this.inlnd40ftRtAmtProp = inlnd40ftRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @param inlndRtLmtWgt
	 */
	public void setInlndRtLmtWgt(String inlndRtLmtWgt) {
		this.inlndRtLmtWgt = inlndRtLmtWgt;
	}
	
	/**
	 * Column Info
	 * @param inlndBxRtAmt
	 */
	public void setInlndBxRtAmt(String inlndBxRtAmt) {
		this.inlndBxRtAmt = inlndBxRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndBxRtAmtProp
	 */
	public void setInlndBxRtAmtProp(String inlndBxRtAmtProp) {
		this.inlndBxRtAmtProp = inlndBxRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy40ftHcRtAmt
	 */
	public void setInlndOneWy40ftHcRtAmt(String inlndOneWy40ftHcRtAmt) {
		this.inlndOneWy40ftHcRtAmt = inlndOneWy40ftHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param colorFlg
	 */
	public void setColorFlg(String colorFlg) {
		this.colorFlg = colorFlg;
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
	 * @param currCdProp
	 */
	public void setCurrCdProp(String currCdProp) {
		this.currCdProp = currCdProp;
	}
	
	/**
	 * Column Info
	 * @param inlndRtBseLocNm
	 */
	public void setInlndRtBseLocNm(String inlndRtBseLocNm) {
		this.inlndRtBseLocNm = inlndRtBseLocNm;
	}
	
	/**
	 * Column Info
	 * @param trfInlndRtSeq
	 */
	public void setTrfInlndRtSeq(String trfInlndRtSeq) {
		this.trfInlndRtSeq = trfInlndRtSeq;
	}
	
	/**
	 * Column Info
	 * @param inputFlg
	 */
	public void setInputFlg(String inputFlg) {
		this.inputFlg = inputFlg;
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
	 * @param inlndRtBseLocNmProp
	 */
	public void setInlndRtBseLocNmProp(String inlndRtBseLocNmProp) {
		this.inlndRtBseLocNmProp = inlndRtBseLocNmProp;
	}
	
	/**
	 * Column Info
	 * @param inlnd40ftHcRtAmt
	 */
	public void setInlnd40ftHcRtAmt(String inlnd40ftHcRtAmt) {
		this.inlnd40ftHcRtAmt = inlnd40ftHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWy20ftRtAmtProp
	 */
	public void setInlndOneWy20ftRtAmtProp(String inlndOneWy20ftRtAmtProp) {
		this.inlndOneWy20ftRtAmtProp = inlndOneWy20ftRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @param inlnd40ftRtAmt
	 */
	public void setInlnd40ftRtAmt(String inlnd40ftRtAmt) {
		this.inlnd40ftRtAmt = inlnd40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param rowProperties
	 */
	public void setRowProperties(String rowProperties) {
		this.rowProperties = rowProperties;
	}
	
	/**
	 * Column Info
	 * @param inlndRtRmk
	 */
	public void setInlndRtRmk(String inlndRtRmk) {
		this.inlndRtRmk = inlndRtRmk;
	}
	
	/**
	 * Column Info
	 * @param inlnd45ftRtAmtProp
	 */
	public void setInlnd45ftRtAmtProp(String inlnd45ftRtAmtProp) {
		this.inlnd45ftRtAmtProp = inlnd45ftRtAmtProp;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param inlndRtBseLocZipCd
	 */
	public void setInlndRtBseLocZipCd(String inlndRtBseLocZipCd) {
		this.inlndRtBseLocZipCd = inlndRtBseLocZipCd;
	}
	
	/**
	 * Column Info
	 * @param inlndOneWyBxRtAmt
	 */
	public void setInlndOneWyBxRtAmt(String inlndOneWyBxRtAmt) {
		this.inlndOneWyBxRtAmt = inlndOneWyBxRtAmt;
	}
	
	/**
	 * Column Info
	 * @param inlndRtTermCdProp
	 */
	public void setInlndRtTermCdProp(String inlndRtTermCdProp) {
		this.inlndRtTermCdProp = inlndRtTermCdProp;
	}
	
	/**
	 * Column Info
	 * @param inlnd20ftRtAmtProp
	 */
	public void setInlnd20ftRtAmtProp(String inlnd20ftRtAmtProp) {
		this.inlnd20ftRtAmtProp = inlnd20ftRtAmtProp;
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
		setTrfInlndSeq(JSPUtil.getParameter(request, prefix + "trf_inlnd_seq", ""));
		setInlndOneWy45ftRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_45ft_rt_amt_prop", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setInlnd20ftRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_20ft_rt_amt", ""));
		setSrcInfoCdProp(JSPUtil.getParameter(request, prefix + "src_info_cd_prop", ""));
		setPrcInlndRtTrspModCd(JSPUtil.getParameter(request, prefix + "prc_inlnd_rt_trsp_mod_cd", ""));
		setInlndOneWy45ftRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_45ft_rt_amt", ""));
		setInlndOneWy40ftHcRtAmtPp(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_40ft_hc_rt_amt_pp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInlndRtBseLocCd(JSPUtil.getParameter(request, prefix + "inlnd_rt_bse_loc_cd", ""));
		setInlndRtViaLocCd(JSPUtil.getParameter(request, prefix + "inlnd_rt_via_loc_cd", ""));
		setInlndRtLmtWgtUtCd(JSPUtil.getParameter(request, prefix + "inlnd_rt_lmt_wgt_ut_cd", ""));
		setInlndRtLmtWgtUtCdProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_lmt_wgt_ut_cd_prop", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPrcCgoTpCdProp(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd_prop", ""));
		setInlndRtBseLocZipCdProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_bse_loc_zip_cd_prop", ""));
		setTrfInlndStsCd(JSPUtil.getParameter(request, prefix + "trf_inlnd_sts_cd", ""));
		setInlndOneWy40ftRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_40ft_rt_amt", ""));
		setInlndRtRmkProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_rmk_prop", ""));
		setInlndRtMinLmtWgt(JSPUtil.getParameter(request, prefix + "inlnd_rt_min_lmt_wgt", ""));
		setInlndOneWy20ftRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_20ft_rt_amt", ""));
		setInlndRtLmtWgtProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_lmt_wgt_prop", ""));
		setInlndOneWyBxRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_bx_rt_amt_prop", ""));
		setInlndRtTermCd(JSPUtil.getParameter(request, prefix + "inlnd_rt_term_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setInlnd40ftHcRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_40ft_hc_rt_amt_prop", ""));
		setInlndRtMinLmtWgtProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_min_lmt_wgt_prop", ""));
		setPrcInlndRtTrspModCdProp(JSPUtil.getParameter(request, prefix + "prc_inlnd_rt_trsp_mod_cd_prop", ""));
		setInlnd45ftRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_45ft_rt_amt", ""));
		setInlndRtViaLocCdProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_via_loc_cd_prop", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setInlndOneWy40ftRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_40ft_rt_amt_prop", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInlndRtBseLocCdProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_bse_loc_cd_prop", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInlnd40ftRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_40ft_rt_amt_prop", ""));
		setInlndRtLmtWgt(JSPUtil.getParameter(request, prefix + "inlnd_rt_lmt_wgt", ""));
		setInlndBxRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_bx_rt_amt", ""));
		setInlndBxRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_bx_rt_amt_prop", ""));
		setInlndOneWy40ftHcRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_40ft_hc_rt_amt", ""));
		setColorFlg(JSPUtil.getParameter(request, prefix + "color_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCurrCdProp(JSPUtil.getParameter(request, prefix + "curr_cd_prop", ""));
		setInlndRtBseLocNm(JSPUtil.getParameter(request, prefix + "inlnd_rt_bse_loc_nm", ""));
		setTrfInlndRtSeq(JSPUtil.getParameter(request, prefix + "trf_inlnd_rt_seq", ""));
		setInputFlg(JSPUtil.getParameter(request, prefix + "input_flg", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setInlndRtBseLocNmProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_bse_loc_nm_prop", ""));
		setInlnd40ftHcRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_40ft_hc_rt_amt", ""));
		setInlndOneWy20ftRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_20ft_rt_amt_prop", ""));
		setInlnd40ftRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_40ft_rt_amt", ""));
		setRowProperties(JSPUtil.getParameter(request, prefix + "row_properties", ""));
		setInlndRtRmk(JSPUtil.getParameter(request, prefix + "inlnd_rt_rmk", ""));
		setInlnd45ftRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_45ft_rt_amt_prop", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setInlndRtBseLocZipCd(JSPUtil.getParameter(request, prefix + "inlnd_rt_bse_loc_zip_cd", ""));
		setInlndOneWyBxRtAmt(JSPUtil.getParameter(request, prefix + "inlnd_one_wy_bx_rt_amt", ""));
		setInlndRtTermCdProp(JSPUtil.getParameter(request, prefix + "inlnd_rt_term_cd_prop", ""));
		setInlnd20ftRtAmtProp(JSPUtil.getParameter(request, prefix + "inlnd_20ft_rt_amt_prop", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriTrfInlndRtVO[]
	 */
	public RsltPriTrfInlndRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriTrfInlndRtVO[]
	 */
	public RsltPriTrfInlndRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriTrfInlndRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trfInlndSeq = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_seq", length));
			String[] inlndOneWy45ftRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_45ft_rt_amt_prop", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] inlnd20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_20ft_rt_amt", length));
			String[] srcInfoCdProp = (JSPUtil.getParameter(request, prefix	+ "src_info_cd_prop", length));
			String[] prcInlndRtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "prc_inlnd_rt_trsp_mod_cd", length));
			String[] inlndOneWy45ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_45ft_rt_amt", length));
			String[] inlndOneWy40ftHcRtAmtPp = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_40ft_hc_rt_amt_pp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inlndRtBseLocCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_bse_loc_cd", length));
			String[] inlndRtViaLocCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_via_loc_cd", length));
			String[] inlndRtLmtWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_lmt_wgt_ut_cd", length));
			String[] inlndRtLmtWgtUtCdProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_lmt_wgt_ut_cd_prop", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] prcCgoTpCdProp = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd_prop", length));
			String[] inlndRtBseLocZipCdProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_bse_loc_zip_cd_prop", length));
			String[] trfInlndStsCd = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_sts_cd", length));
			String[] inlndOneWy40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_40ft_rt_amt", length));
			String[] inlndRtRmkProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_rmk_prop", length));
			String[] inlndRtMinLmtWgt = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_min_lmt_wgt", length));
			String[] inlndOneWy20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_20ft_rt_amt", length));
			String[] inlndRtLmtWgtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_lmt_wgt_prop", length));
			String[] inlndOneWyBxRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_bx_rt_amt_prop", length));
			String[] inlndRtTermCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_term_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] inlnd40ftHcRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_hc_rt_amt_prop", length));
			String[] inlndRtMinLmtWgtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_min_lmt_wgt_prop", length));
			String[] prcInlndRtTrspModCdProp = (JSPUtil.getParameter(request, prefix	+ "prc_inlnd_rt_trsp_mod_cd_prop", length));
			String[] inlnd45ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_45ft_rt_amt", length));
			String[] inlndRtViaLocCdProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_via_loc_cd_prop", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] inlndOneWy40ftRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_40ft_rt_amt_prop", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] inlndRtBseLocCdProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_bse_loc_cd_prop", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inlnd40ftRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_rt_amt_prop", length));
			String[] inlndRtLmtWgt = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_lmt_wgt", length));
			String[] inlndBxRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_bx_rt_amt", length));
			String[] inlndBxRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_bx_rt_amt_prop", length));
			String[] inlndOneWy40ftHcRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_40ft_hc_rt_amt", length));
			String[] colorFlg = (JSPUtil.getParameter(request, prefix	+ "color_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] currCdProp = (JSPUtil.getParameter(request, prefix	+ "curr_cd_prop", length));
			String[] inlndRtBseLocNm = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_bse_loc_nm", length));
			String[] trfInlndRtSeq = (JSPUtil.getParameter(request, prefix	+ "trf_inlnd_rt_seq", length));
			String[] inputFlg = (JSPUtil.getParameter(request, prefix	+ "input_flg", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] inlndRtBseLocNmProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_bse_loc_nm_prop", length));
			String[] inlnd40ftHcRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_hc_rt_amt", length));
			String[] inlndOneWy20ftRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_20ft_rt_amt_prop", length));
			String[] inlnd40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_40ft_rt_amt", length));
			String[] rowProperties = (JSPUtil.getParameter(request, prefix	+ "row_properties", length));
			String[] inlndRtRmk = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_rmk", length));
			String[] inlnd45ftRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_45ft_rt_amt_prop", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] inlndRtBseLocZipCd = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_bse_loc_zip_cd", length));
			String[] inlndOneWyBxRtAmt = (JSPUtil.getParameter(request, prefix	+ "inlnd_one_wy_bx_rt_amt", length));
			String[] inlndRtTermCdProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_rt_term_cd_prop", length));
			String[] inlnd20ftRtAmtProp = (JSPUtil.getParameter(request, prefix	+ "inlnd_20ft_rt_amt_prop", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriTrfInlndRtVO();
				if (trfInlndSeq[i] != null)
					model.setTrfInlndSeq(trfInlndSeq[i]);
				if (inlndOneWy45ftRtAmtProp[i] != null)
					model.setInlndOneWy45ftRtAmtProp(inlndOneWy45ftRtAmtProp[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (inlnd20ftRtAmt[i] != null)
					model.setInlnd20ftRtAmt(inlnd20ftRtAmt[i]);
				if (srcInfoCdProp[i] != null)
					model.setSrcInfoCdProp(srcInfoCdProp[i]);
				if (prcInlndRtTrspModCd[i] != null)
					model.setPrcInlndRtTrspModCd(prcInlndRtTrspModCd[i]);
				if (inlndOneWy45ftRtAmt[i] != null)
					model.setInlndOneWy45ftRtAmt(inlndOneWy45ftRtAmt[i]);
				if (inlndOneWy40ftHcRtAmtPp[i] != null)
					model.setInlndOneWy40ftHcRtAmtPp(inlndOneWy40ftHcRtAmtPp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inlndRtBseLocCd[i] != null)
					model.setInlndRtBseLocCd(inlndRtBseLocCd[i]);
				if (inlndRtViaLocCd[i] != null)
					model.setInlndRtViaLocCd(inlndRtViaLocCd[i]);
				if (inlndRtLmtWgtUtCd[i] != null)
					model.setInlndRtLmtWgtUtCd(inlndRtLmtWgtUtCd[i]);
				if (inlndRtLmtWgtUtCdProp[i] != null)
					model.setInlndRtLmtWgtUtCdProp(inlndRtLmtWgtUtCdProp[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (prcCgoTpCdProp[i] != null)
					model.setPrcCgoTpCdProp(prcCgoTpCdProp[i]);
				if (inlndRtBseLocZipCdProp[i] != null)
					model.setInlndRtBseLocZipCdProp(inlndRtBseLocZipCdProp[i]);
				if (trfInlndStsCd[i] != null)
					model.setTrfInlndStsCd(trfInlndStsCd[i]);
				if (inlndOneWy40ftRtAmt[i] != null)
					model.setInlndOneWy40ftRtAmt(inlndOneWy40ftRtAmt[i]);
				if (inlndRtRmkProp[i] != null)
					model.setInlndRtRmkProp(inlndRtRmkProp[i]);
				if (inlndRtMinLmtWgt[i] != null)
					model.setInlndRtMinLmtWgt(inlndRtMinLmtWgt[i]);
				if (inlndOneWy20ftRtAmt[i] != null)
					model.setInlndOneWy20ftRtAmt(inlndOneWy20ftRtAmt[i]);
				if (inlndRtLmtWgtProp[i] != null)
					model.setInlndRtLmtWgtProp(inlndRtLmtWgtProp[i]);
				if (inlndOneWyBxRtAmtProp[i] != null)
					model.setInlndOneWyBxRtAmtProp(inlndOneWyBxRtAmtProp[i]);
				if (inlndRtTermCd[i] != null)
					model.setInlndRtTermCd(inlndRtTermCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (inlnd40ftHcRtAmtProp[i] != null)
					model.setInlnd40ftHcRtAmtProp(inlnd40ftHcRtAmtProp[i]);
				if (inlndRtMinLmtWgtProp[i] != null)
					model.setInlndRtMinLmtWgtProp(inlndRtMinLmtWgtProp[i]);
				if (prcInlndRtTrspModCdProp[i] != null)
					model.setPrcInlndRtTrspModCdProp(prcInlndRtTrspModCdProp[i]);
				if (inlnd45ftRtAmt[i] != null)
					model.setInlnd45ftRtAmt(inlnd45ftRtAmt[i]);
				if (inlndRtViaLocCdProp[i] != null)
					model.setInlndRtViaLocCdProp(inlndRtViaLocCdProp[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (inlndOneWy40ftRtAmtProp[i] != null)
					model.setInlndOneWy40ftRtAmtProp(inlndOneWy40ftRtAmtProp[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (inlndRtBseLocCdProp[i] != null)
					model.setInlndRtBseLocCdProp(inlndRtBseLocCdProp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inlnd40ftRtAmtProp[i] != null)
					model.setInlnd40ftRtAmtProp(inlnd40ftRtAmtProp[i]);
				if (inlndRtLmtWgt[i] != null)
					model.setInlndRtLmtWgt(inlndRtLmtWgt[i]);
				if (inlndBxRtAmt[i] != null)
					model.setInlndBxRtAmt(inlndBxRtAmt[i]);
				if (inlndBxRtAmtProp[i] != null)
					model.setInlndBxRtAmtProp(inlndBxRtAmtProp[i]);
				if (inlndOneWy40ftHcRtAmt[i] != null)
					model.setInlndOneWy40ftHcRtAmt(inlndOneWy40ftHcRtAmt[i]);
				if (colorFlg[i] != null)
					model.setColorFlg(colorFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (currCdProp[i] != null)
					model.setCurrCdProp(currCdProp[i]);
				if (inlndRtBseLocNm[i] != null)
					model.setInlndRtBseLocNm(inlndRtBseLocNm[i]);
				if (trfInlndRtSeq[i] != null)
					model.setTrfInlndRtSeq(trfInlndRtSeq[i]);
				if (inputFlg[i] != null)
					model.setInputFlg(inputFlg[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (inlndRtBseLocNmProp[i] != null)
					model.setInlndRtBseLocNmProp(inlndRtBseLocNmProp[i]);
				if (inlnd40ftHcRtAmt[i] != null)
					model.setInlnd40ftHcRtAmt(inlnd40ftHcRtAmt[i]);
				if (inlndOneWy20ftRtAmtProp[i] != null)
					model.setInlndOneWy20ftRtAmtProp(inlndOneWy20ftRtAmtProp[i]);
				if (inlnd40ftRtAmt[i] != null)
					model.setInlnd40ftRtAmt(inlnd40ftRtAmt[i]);
				if (rowProperties[i] != null)
					model.setRowProperties(rowProperties[i]);
				if (inlndRtRmk[i] != null)
					model.setInlndRtRmk(inlndRtRmk[i]);
				if (inlnd45ftRtAmtProp[i] != null)
					model.setInlnd45ftRtAmtProp(inlnd45ftRtAmtProp[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (inlndRtBseLocZipCd[i] != null)
					model.setInlndRtBseLocZipCd(inlndRtBseLocZipCd[i]);
				if (inlndOneWyBxRtAmt[i] != null)
					model.setInlndOneWyBxRtAmt(inlndOneWyBxRtAmt[i]);
				if (inlndRtTermCdProp[i] != null)
					model.setInlndRtTermCdProp(inlndRtTermCdProp[i]);
				if (inlnd20ftRtAmtProp[i] != null)
					model.setInlnd20ftRtAmtProp(inlnd20ftRtAmtProp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriTrfInlndRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriTrfInlndRtVO[]
	 */
	public RsltPriTrfInlndRtVO[] getRsltPriTrfInlndRtVOs(){
		RsltPriTrfInlndRtVO[] vos = (RsltPriTrfInlndRtVO[])models.toArray(new RsltPriTrfInlndRtVO[models.size()]);
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
		this.trfInlndSeq = this.trfInlndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy45ftRtAmtProp = this.inlndOneWy45ftRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd20ftRtAmt = this.inlnd20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCdProp = this.srcInfoCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcInlndRtTrspModCd = this.prcInlndRtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy45ftRtAmt = this.inlndOneWy45ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy40ftHcRtAmtPp = this.inlndOneWy40ftHcRtAmtPp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtBseLocCd = this.inlndRtBseLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtViaLocCd = this.inlndRtViaLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtLmtWgtUtCd = this.inlndRtLmtWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtLmtWgtUtCdProp = this.inlndRtLmtWgtUtCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCdProp = this.prcCgoTpCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtBseLocZipCdProp = this.inlndRtBseLocZipCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndStsCd = this.trfInlndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy40ftRtAmt = this.inlndOneWy40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtRmkProp = this.inlndRtRmkProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtMinLmtWgt = this.inlndRtMinLmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy20ftRtAmt = this.inlndOneWy20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtLmtWgtProp = this.inlndRtLmtWgtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWyBxRtAmtProp = this.inlndOneWyBxRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtTermCd = this.inlndRtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftHcRtAmtProp = this.inlnd40ftHcRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtMinLmtWgtProp = this.inlndRtMinLmtWgtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcInlndRtTrspModCdProp = this.prcInlndRtTrspModCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd45ftRtAmt = this.inlnd45ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtViaLocCdProp = this.inlndRtViaLocCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy40ftRtAmtProp = this.inlndOneWy40ftRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtBseLocCdProp = this.inlndRtBseLocCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftRtAmtProp = this.inlnd40ftRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtLmtWgt = this.inlndRtLmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndBxRtAmt = this.inlndBxRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndBxRtAmtProp = this.inlndBxRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy40ftHcRtAmt = this.inlndOneWy40ftHcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colorFlg = this.colorFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCdProp = this.currCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtBseLocNm = this.inlndRtBseLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfInlndRtSeq = this.trfInlndRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputFlg = this.inputFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtBseLocNmProp = this.inlndRtBseLocNmProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftHcRtAmt = this.inlnd40ftHcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWy20ftRtAmtProp = this.inlndOneWy20ftRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd40ftRtAmt = this.inlnd40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowProperties = this.rowProperties .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtRmk = this.inlndRtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd45ftRtAmtProp = this.inlnd45ftRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtBseLocZipCd = this.inlndRtBseLocZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndOneWyBxRtAmt = this.inlndOneWyBxRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlndRtTermCdProp = this.inlndRtTermCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inlnd20ftRtAmtProp = this.inlnd20ftRtAmtProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
