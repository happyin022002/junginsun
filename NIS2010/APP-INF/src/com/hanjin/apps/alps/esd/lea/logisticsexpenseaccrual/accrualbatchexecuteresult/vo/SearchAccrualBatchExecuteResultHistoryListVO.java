/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualBatchExecuteResultHistoryListVO.java
*@FileTitle : SearchAccrualBatchExecuteResultHistoryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.28 전재홍 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전재홍
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualBatchExecuteResultHistoryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualBatchExecuteResultHistoryListVO> models = new ArrayList<SearchAccrualBatchExecuteResultHistoryListVO>();
	
	/* Column Info */
	private String revVvdIfFlg = null;
	/* Column Info */
	private String estmKnt = null;
	/* Column Info */
	private String batCmplFlgDesc = null;
	/* Column Info */
	private String estmUpdEndDt = null;
	/* Column Info */
	private String mapgAlocEndDt = null;
	/* Column Info */
	private String revVvdIfKnt = null;
	/* Column Info */
	private String apClzFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exeYrmonFrom = null;
	/* Column Info */
	private String estmEndDt = null;
	/* Column Info */
	private String monAvgXchRtIfFlgDesc = null;
	/* Column Info */
	private String estmStDt = null;
	/* Column Info */
	private String exeYrmonTo = null;
	/* Column Info */
	private String erpIfFlg = null;
	/* Column Info */
	private String mapgAlocStDt = null;
	/* Column Info */
	private String batRmk = null;
	/* Column Info */
	private String monAvgXchRtIfFlg = null;
	/* Column Info */
	private String estmUpdKnt = null;
	/* Column Info */
	private String monAvgXchRtIfKnt = null;
	/* Column Info */
	private String batCmplFlg = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String batStDt = null;
	/* Column Info */
	private String batId = null;
	/* Column Info */
	private String mapgAlocKnt = null;
	/* Column Info */
	private String erpIfDt = null;
	/* Column Info */
	private String errKnt = null;
	/* Column Info */
	private String mnlInpFlg = null;
	/* Column Info */
	private String revVvdIfFlgDesc = null;
	/* Column Info */
	private String batEndDt = null;
	/* Column Info */
	private String estmUpdStDt = null;
	/* Column Info */
	private String mnlInpFlgDesc = null;
	/* Column Info */
	private String apClzFlgDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualBatchExecuteResultHistoryListVO() {}

	public SearchAccrualBatchExecuteResultHistoryListVO(String ibflag, String pagerows, String exeYrmon, String apClzFlg, String apClzFlgDesc, String revVvdIfFlg, String revVvdIfKnt, String revVvdIfFlgDesc, String monAvgXchRtIfFlg, String monAvgXchRtIfKnt, String monAvgXchRtIfFlgDesc, String mnlInpFlg, String mnlInpFlgDesc, String erpIfFlg, String erpIfDt, String batId, String batStDt, String batEndDt, String estmStDt, String estmEndDt, String estmKnt, String estmUpdStDt, String estmUpdEndDt, String estmUpdKnt, String mapgAlocStDt, String mapgAlocEndDt, String mapgAlocKnt, String errKnt, String batCmplFlg, String batCmplFlgDesc, String batRmk, String exeYrmonFrom, String exeYrmonTo) {
		this.revVvdIfFlg = revVvdIfFlg;
		this.estmKnt = estmKnt;
		this.batCmplFlgDesc = batCmplFlgDesc;
		this.estmUpdEndDt = estmUpdEndDt;
		this.mapgAlocEndDt = mapgAlocEndDt;
		this.revVvdIfKnt = revVvdIfKnt;
		this.apClzFlg = apClzFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.exeYrmonFrom = exeYrmonFrom;
		this.estmEndDt = estmEndDt;
		this.monAvgXchRtIfFlgDesc = monAvgXchRtIfFlgDesc;
		this.estmStDt = estmStDt;
		this.exeYrmonTo = exeYrmonTo;
		this.erpIfFlg = erpIfFlg;
		this.mapgAlocStDt = mapgAlocStDt;
		this.batRmk = batRmk;
		this.monAvgXchRtIfFlg = monAvgXchRtIfFlg;
		this.estmUpdKnt = estmUpdKnt;
		this.monAvgXchRtIfKnt = monAvgXchRtIfKnt;
		this.batCmplFlg = batCmplFlg;
		this.exeYrmon = exeYrmon;
		this.batStDt = batStDt;
		this.batId = batId;
		this.mapgAlocKnt = mapgAlocKnt;
		this.erpIfDt = erpIfDt;
		this.errKnt = errKnt;
		this.mnlInpFlg = mnlInpFlg;
		this.revVvdIfFlgDesc = revVvdIfFlgDesc;
		this.batEndDt = batEndDt;
		this.estmUpdStDt = estmUpdStDt;
		this.mnlInpFlgDesc = mnlInpFlgDesc;
		this.apClzFlgDesc = apClzFlgDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev_vvd_if_flg", getRevVvdIfFlg());
		this.hashColumns.put("estm_knt", getEstmKnt());
		this.hashColumns.put("bat_cmpl_flg_desc", getBatCmplFlgDesc());
		this.hashColumns.put("estm_upd_end_dt", getEstmUpdEndDt());
		this.hashColumns.put("mapg_aloc_end_dt", getMapgAlocEndDt());
		this.hashColumns.put("rev_vvd_if_knt", getRevVvdIfKnt());
		this.hashColumns.put("ap_clz_flg", getApClzFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exe_yrmon_from", getExeYrmonFrom());
		this.hashColumns.put("estm_end_dt", getEstmEndDt());
		this.hashColumns.put("mon_avg_xch_rt_if_flg_desc", getMonAvgXchRtIfFlgDesc());
		this.hashColumns.put("estm_st_dt", getEstmStDt());
		this.hashColumns.put("exe_yrmon_to", getExeYrmonTo());
		this.hashColumns.put("erp_if_flg", getErpIfFlg());
		this.hashColumns.put("mapg_aloc_st_dt", getMapgAlocStDt());
		this.hashColumns.put("bat_rmk", getBatRmk());
		this.hashColumns.put("mon_avg_xch_rt_if_flg", getMonAvgXchRtIfFlg());
		this.hashColumns.put("estm_upd_knt", getEstmUpdKnt());
		this.hashColumns.put("mon_avg_xch_rt_if_knt", getMonAvgXchRtIfKnt());
		this.hashColumns.put("bat_cmpl_flg", getBatCmplFlg());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("bat_st_dt", getBatStDt());
		this.hashColumns.put("bat_id", getBatId());
		this.hashColumns.put("mapg_aloc_knt", getMapgAlocKnt());
		this.hashColumns.put("erp_if_dt", getErpIfDt());
		this.hashColumns.put("err_knt", getErrKnt());
		this.hashColumns.put("mnl_inp_flg", getMnlInpFlg());
		this.hashColumns.put("rev_vvd_if_flg_desc", getRevVvdIfFlgDesc());
		this.hashColumns.put("bat_end_dt", getBatEndDt());
		this.hashColumns.put("estm_upd_st_dt", getEstmUpdStDt());
		this.hashColumns.put("mnl_inp_flg_desc", getMnlInpFlgDesc());
		this.hashColumns.put("ap_clz_flg_desc", getApClzFlgDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev_vvd_if_flg", "revVvdIfFlg");
		this.hashFields.put("estm_knt", "estmKnt");
		this.hashFields.put("bat_cmpl_flg_desc", "batCmplFlgDesc");
		this.hashFields.put("estm_upd_end_dt", "estmUpdEndDt");
		this.hashFields.put("mapg_aloc_end_dt", "mapgAlocEndDt");
		this.hashFields.put("rev_vvd_if_knt", "revVvdIfKnt");
		this.hashFields.put("ap_clz_flg", "apClzFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exe_yrmon_from", "exeYrmonFrom");
		this.hashFields.put("estm_end_dt", "estmEndDt");
		this.hashFields.put("mon_avg_xch_rt_if_flg_desc", "monAvgXchRtIfFlgDesc");
		this.hashFields.put("estm_st_dt", "estmStDt");
		this.hashFields.put("exe_yrmon_to", "exeYrmonTo");
		this.hashFields.put("erp_if_flg", "erpIfFlg");
		this.hashFields.put("mapg_aloc_st_dt", "mapgAlocStDt");
		this.hashFields.put("bat_rmk", "batRmk");
		this.hashFields.put("mon_avg_xch_rt_if_flg", "monAvgXchRtIfFlg");
		this.hashFields.put("estm_upd_knt", "estmUpdKnt");
		this.hashFields.put("mon_avg_xch_rt_if_knt", "monAvgXchRtIfKnt");
		this.hashFields.put("bat_cmpl_flg", "batCmplFlg");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("bat_st_dt", "batStDt");
		this.hashFields.put("bat_id", "batId");
		this.hashFields.put("mapg_aloc_knt", "mapgAlocKnt");
		this.hashFields.put("erp_if_dt", "erpIfDt");
		this.hashFields.put("err_knt", "errKnt");
		this.hashFields.put("mnl_inp_flg", "mnlInpFlg");
		this.hashFields.put("rev_vvd_if_flg_desc", "revVvdIfFlgDesc");
		this.hashFields.put("bat_end_dt", "batEndDt");
		this.hashFields.put("estm_upd_st_dt", "estmUpdStDt");
		this.hashFields.put("mnl_inp_flg_desc", "mnlInpFlgDesc");
		this.hashFields.put("ap_clz_flg_desc", "apClzFlgDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revVvdIfFlg
	 */
	public String getRevVvdIfFlg() {
		return this.revVvdIfFlg;
	}
	
	/**
	 * Column Info
	 * @return estmKnt
	 */
	public String getEstmKnt() {
		return this.estmKnt;
	}
	
	/**
	 * Column Info
	 * @return batCmplFlgDesc
	 */
	public String getBatCmplFlgDesc() {
		return this.batCmplFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return estmUpdEndDt
	 */
	public String getEstmUpdEndDt() {
		return this.estmUpdEndDt;
	}
	
	/**
	 * Column Info
	 * @return mapgAlocEndDt
	 */
	public String getMapgAlocEndDt() {
		return this.mapgAlocEndDt;
	}
	
	/**
	 * Column Info
	 * @return revVvdIfKnt
	 */
	public String getRevVvdIfKnt() {
		return this.revVvdIfKnt;
	}
	
	/**
	 * Column Info
	 * @return apClzFlg
	 */
	public String getApClzFlg() {
		return this.apClzFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return exeYrmonFrom
	 */
	public String getExeYrmonFrom() {
		return this.exeYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @return estmEndDt
	 */
	public String getEstmEndDt() {
		return this.estmEndDt;
	}
	
	/**
	 * Column Info
	 * @return monAvgXchRtIfFlgDesc
	 */
	public String getMonAvgXchRtIfFlgDesc() {
		return this.monAvgXchRtIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return estmStDt
	 */
	public String getEstmStDt() {
		return this.estmStDt;
	}
	
	/**
	 * Column Info
	 * @return exeYrmonTo
	 */
	public String getExeYrmonTo() {
		return this.exeYrmonTo;
	}
	
	/**
	 * Column Info
	 * @return erpIfFlg
	 */
	public String getErpIfFlg() {
		return this.erpIfFlg;
	}
	
	/**
	 * Column Info
	 * @return mapgAlocStDt
	 */
	public String getMapgAlocStDt() {
		return this.mapgAlocStDt;
	}
	
	/**
	 * Column Info
	 * @return batRmk
	 */
	public String getBatRmk() {
		return this.batRmk;
	}
	
	/**
	 * Column Info
	 * @return monAvgXchRtIfFlg
	 */
	public String getMonAvgXchRtIfFlg() {
		return this.monAvgXchRtIfFlg;
	}
	
	/**
	 * Column Info
	 * @return estmUpdKnt
	 */
	public String getEstmUpdKnt() {
		return this.estmUpdKnt;
	}
	
	/**
	 * Column Info
	 * @return monAvgXchRtIfKnt
	 */
	public String getMonAvgXchRtIfKnt() {
		return this.monAvgXchRtIfKnt;
	}
	
	/**
	 * Column Info
	 * @return batCmplFlg
	 */
	public String getBatCmplFlg() {
		return this.batCmplFlg;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return batStDt
	 */
	public String getBatStDt() {
		return this.batStDt;
	}
	
	/**
	 * Column Info
	 * @return batId
	 */
	public String getBatId() {
		return this.batId;
	}
	
	/**
	 * Column Info
	 * @return mapgAlocKnt
	 */
	public String getMapgAlocKnt() {
		return this.mapgAlocKnt;
	}
	
	/**
	 * Column Info
	 * @return erpIfDt
	 */
	public String getErpIfDt() {
		return this.erpIfDt;
	}
	
	/**
	 * Column Info
	 * @return errKnt
	 */
	public String getErrKnt() {
		return this.errKnt;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlg
	 */
	public String getMnlInpFlg() {
		return this.mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @return revVvdIfFlgDesc
	 */
	public String getRevVvdIfFlgDesc() {
		return this.revVvdIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return batEndDt
	 */
	public String getBatEndDt() {
		return this.batEndDt;
	}
	
	/**
	 * Column Info
	 * @return estmUpdStDt
	 */
	public String getEstmUpdStDt() {
		return this.estmUpdStDt;
	}
	
	/**
	 * Column Info
	 * @return mnlInpFlgDesc
	 */
	public String getMnlInpFlgDesc() {
		return this.mnlInpFlgDesc;
	}
	
	/**
	 * Column Info
	 * @return apClzFlgDesc
	 */
	public String getApClzFlgDesc() {
		return this.apClzFlgDesc;
	}
	

	/**
	 * Column Info
	 * @param revVvdIfFlg
	 */
	public void setRevVvdIfFlg(String revVvdIfFlg) {
		this.revVvdIfFlg = revVvdIfFlg;
	}
	
	/**
	 * Column Info
	 * @param estmKnt
	 */
	public void setEstmKnt(String estmKnt) {
		this.estmKnt = estmKnt;
	}
	
	/**
	 * Column Info
	 * @param batCmplFlgDesc
	 */
	public void setBatCmplFlgDesc(String batCmplFlgDesc) {
		this.batCmplFlgDesc = batCmplFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param estmUpdEndDt
	 */
	public void setEstmUpdEndDt(String estmUpdEndDt) {
		this.estmUpdEndDt = estmUpdEndDt;
	}
	
	/**
	 * Column Info
	 * @param mapgAlocEndDt
	 */
	public void setMapgAlocEndDt(String mapgAlocEndDt) {
		this.mapgAlocEndDt = mapgAlocEndDt;
	}
	
	/**
	 * Column Info
	 * @param revVvdIfKnt
	 */
	public void setRevVvdIfKnt(String revVvdIfKnt) {
		this.revVvdIfKnt = revVvdIfKnt;
	}
	
	/**
	 * Column Info
	 * @param apClzFlg
	 */
	public void setApClzFlg(String apClzFlg) {
		this.apClzFlg = apClzFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param exeYrmonFrom
	 */
	public void setExeYrmonFrom(String exeYrmonFrom) {
		this.exeYrmonFrom = exeYrmonFrom;
	}
	
	/**
	 * Column Info
	 * @param estmEndDt
	 */
	public void setEstmEndDt(String estmEndDt) {
		this.estmEndDt = estmEndDt;
	}
	
	/**
	 * Column Info
	 * @param monAvgXchRtIfFlgDesc
	 */
	public void setMonAvgXchRtIfFlgDesc(String monAvgXchRtIfFlgDesc) {
		this.monAvgXchRtIfFlgDesc = monAvgXchRtIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param estmStDt
	 */
	public void setEstmStDt(String estmStDt) {
		this.estmStDt = estmStDt;
	}
	
	/**
	 * Column Info
	 * @param exeYrmonTo
	 */
	public void setExeYrmonTo(String exeYrmonTo) {
		this.exeYrmonTo = exeYrmonTo;
	}
	
	/**
	 * Column Info
	 * @param erpIfFlg
	 */
	public void setErpIfFlg(String erpIfFlg) {
		this.erpIfFlg = erpIfFlg;
	}
	
	/**
	 * Column Info
	 * @param mapgAlocStDt
	 */
	public void setMapgAlocStDt(String mapgAlocStDt) {
		this.mapgAlocStDt = mapgAlocStDt;
	}
	
	/**
	 * Column Info
	 * @param batRmk
	 */
	public void setBatRmk(String batRmk) {
		this.batRmk = batRmk;
	}
	
	/**
	 * Column Info
	 * @param monAvgXchRtIfFlg
	 */
	public void setMonAvgXchRtIfFlg(String monAvgXchRtIfFlg) {
		this.monAvgXchRtIfFlg = monAvgXchRtIfFlg;
	}
	
	/**
	 * Column Info
	 * @param estmUpdKnt
	 */
	public void setEstmUpdKnt(String estmUpdKnt) {
		this.estmUpdKnt = estmUpdKnt;
	}
	
	/**
	 * Column Info
	 * @param monAvgXchRtIfKnt
	 */
	public void setMonAvgXchRtIfKnt(String monAvgXchRtIfKnt) {
		this.monAvgXchRtIfKnt = monAvgXchRtIfKnt;
	}
	
	/**
	 * Column Info
	 * @param batCmplFlg
	 */
	public void setBatCmplFlg(String batCmplFlg) {
		this.batCmplFlg = batCmplFlg;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param batStDt
	 */
	public void setBatStDt(String batStDt) {
		this.batStDt = batStDt;
	}
	
	/**
	 * Column Info
	 * @param batId
	 */
	public void setBatId(String batId) {
		this.batId = batId;
	}
	
	/**
	 * Column Info
	 * @param mapgAlocKnt
	 */
	public void setMapgAlocKnt(String mapgAlocKnt) {
		this.mapgAlocKnt = mapgAlocKnt;
	}
	
	/**
	 * Column Info
	 * @param erpIfDt
	 */
	public void setErpIfDt(String erpIfDt) {
		this.erpIfDt = erpIfDt;
	}
	
	/**
	 * Column Info
	 * @param errKnt
	 */
	public void setErrKnt(String errKnt) {
		this.errKnt = errKnt;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlg
	 */
	public void setMnlInpFlg(String mnlInpFlg) {
		this.mnlInpFlg = mnlInpFlg;
	}
	
	/**
	 * Column Info
	 * @param revVvdIfFlgDesc
	 */
	public void setRevVvdIfFlgDesc(String revVvdIfFlgDesc) {
		this.revVvdIfFlgDesc = revVvdIfFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param batEndDt
	 */
	public void setBatEndDt(String batEndDt) {
		this.batEndDt = batEndDt;
	}
	
	/**
	 * Column Info
	 * @param estmUpdStDt
	 */
	public void setEstmUpdStDt(String estmUpdStDt) {
		this.estmUpdStDt = estmUpdStDt;
	}
	
	/**
	 * Column Info
	 * @param mnlInpFlgDesc
	 */
	public void setMnlInpFlgDesc(String mnlInpFlgDesc) {
		this.mnlInpFlgDesc = mnlInpFlgDesc;
	}
	
	/**
	 * Column Info
	 * @param apClzFlgDesc
	 */
	public void setApClzFlgDesc(String apClzFlgDesc) {
		this.apClzFlgDesc = apClzFlgDesc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRevVvdIfFlg(JSPUtil.getParameter(request, "rev_vvd_if_flg", ""));
		setEstmKnt(JSPUtil.getParameter(request, "estm_knt", ""));
		setBatCmplFlgDesc(JSPUtil.getParameter(request, "bat_cmpl_flg_desc", ""));
		setEstmUpdEndDt(JSPUtil.getParameter(request, "estm_upd_end_dt", ""));
		setMapgAlocEndDt(JSPUtil.getParameter(request, "mapg_aloc_end_dt", ""));
		setRevVvdIfKnt(JSPUtil.getParameter(request, "rev_vvd_if_knt", ""));
		setApClzFlg(JSPUtil.getParameter(request, "ap_clz_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setExeYrmonFrom(JSPUtil.getParameter(request, "exe_yrmon_from", ""));
		setEstmEndDt(JSPUtil.getParameter(request, "estm_end_dt", ""));
		setMonAvgXchRtIfFlgDesc(JSPUtil.getParameter(request, "mon_avg_xch_rt_if_flg_desc", ""));
		setEstmStDt(JSPUtil.getParameter(request, "estm_st_dt", ""));
		setExeYrmonTo(JSPUtil.getParameter(request, "exe_yrmon_to", ""));
		setErpIfFlg(JSPUtil.getParameter(request, "erp_if_flg", ""));
		setMapgAlocStDt(JSPUtil.getParameter(request, "mapg_aloc_st_dt", ""));
		setBatRmk(JSPUtil.getParameter(request, "bat_rmk", ""));
		setMonAvgXchRtIfFlg(JSPUtil.getParameter(request, "mon_avg_xch_rt_if_flg", ""));
		setEstmUpdKnt(JSPUtil.getParameter(request, "estm_upd_knt", ""));
		setMonAvgXchRtIfKnt(JSPUtil.getParameter(request, "mon_avg_xch_rt_if_knt", ""));
		setBatCmplFlg(JSPUtil.getParameter(request, "bat_cmpl_flg", ""));
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setBatStDt(JSPUtil.getParameter(request, "bat_st_dt", ""));
		setBatId(JSPUtil.getParameter(request, "bat_id", ""));
		setMapgAlocKnt(JSPUtil.getParameter(request, "mapg_aloc_knt", ""));
		setErpIfDt(JSPUtil.getParameter(request, "erp_if_dt", ""));
		setErrKnt(JSPUtil.getParameter(request, "err_knt", ""));
		setMnlInpFlg(JSPUtil.getParameter(request, "mnl_inp_flg", ""));
		setRevVvdIfFlgDesc(JSPUtil.getParameter(request, "rev_vvd_if_flg_desc", ""));
		setBatEndDt(JSPUtil.getParameter(request, "bat_end_dt", ""));
		setEstmUpdStDt(JSPUtil.getParameter(request, "estm_upd_st_dt", ""));
		setMnlInpFlgDesc(JSPUtil.getParameter(request, "mnl_inp_flg_desc", ""));
		setApClzFlgDesc(JSPUtil.getParameter(request, "ap_clz_flg_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualBatchExecuteResultHistoryListVO[]
	 */
	public SearchAccrualBatchExecuteResultHistoryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualBatchExecuteResultHistoryListVO[]
	 */
	public SearchAccrualBatchExecuteResultHistoryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualBatchExecuteResultHistoryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revVvdIfFlg = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_if_flg", length));
			String[] estmKnt = (JSPUtil.getParameter(request, prefix	+ "estm_knt", length));
			String[] batCmplFlgDesc = (JSPUtil.getParameter(request, prefix	+ "bat_cmpl_flg_desc", length));
			String[] estmUpdEndDt = (JSPUtil.getParameter(request, prefix	+ "estm_upd_end_dt", length));
			String[] mapgAlocEndDt = (JSPUtil.getParameter(request, prefix	+ "mapg_aloc_end_dt", length));
			String[] revVvdIfKnt = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_if_knt", length));
			String[] apClzFlg = (JSPUtil.getParameter(request, prefix	+ "ap_clz_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exeYrmonFrom = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon_from", length));
			String[] estmEndDt = (JSPUtil.getParameter(request, prefix	+ "estm_end_dt", length));
			String[] monAvgXchRtIfFlgDesc = (JSPUtil.getParameter(request, prefix	+ "mon_avg_xch_rt_if_flg_desc", length));
			String[] estmStDt = (JSPUtil.getParameter(request, prefix	+ "estm_st_dt", length));
			String[] exeYrmonTo = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon_to", length));
			String[] erpIfFlg = (JSPUtil.getParameter(request, prefix	+ "erp_if_flg", length));
			String[] mapgAlocStDt = (JSPUtil.getParameter(request, prefix	+ "mapg_aloc_st_dt", length));
			String[] batRmk = (JSPUtil.getParameter(request, prefix	+ "bat_rmk", length));
			String[] monAvgXchRtIfFlg = (JSPUtil.getParameter(request, prefix	+ "mon_avg_xch_rt_if_flg", length));
			String[] estmUpdKnt = (JSPUtil.getParameter(request, prefix	+ "estm_upd_knt", length));
			String[] monAvgXchRtIfKnt = (JSPUtil.getParameter(request, prefix	+ "mon_avg_xch_rt_if_knt", length));
			String[] batCmplFlg = (JSPUtil.getParameter(request, prefix	+ "bat_cmpl_flg", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] batStDt = (JSPUtil.getParameter(request, prefix	+ "bat_st_dt", length));
			String[] batId = (JSPUtil.getParameter(request, prefix	+ "bat_id", length));
			String[] mapgAlocKnt = (JSPUtil.getParameter(request, prefix	+ "mapg_aloc_knt", length));
			String[] erpIfDt = (JSPUtil.getParameter(request, prefix	+ "erp_if_dt", length));
			String[] errKnt = (JSPUtil.getParameter(request, prefix	+ "err_knt", length));
			String[] mnlInpFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg", length));
			String[] revVvdIfFlgDesc = (JSPUtil.getParameter(request, prefix	+ "rev_vvd_if_flg_desc", length));
			String[] batEndDt = (JSPUtil.getParameter(request, prefix	+ "bat_end_dt", length));
			String[] estmUpdStDt = (JSPUtil.getParameter(request, prefix	+ "estm_upd_st_dt", length));
			String[] mnlInpFlgDesc = (JSPUtil.getParameter(request, prefix	+ "mnl_inp_flg_desc", length));
			String[] apClzFlgDesc = (JSPUtil.getParameter(request, prefix	+ "ap_clz_flg_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualBatchExecuteResultHistoryListVO();
				if (revVvdIfFlg[i] != null)
					model.setRevVvdIfFlg(revVvdIfFlg[i]);
				if (estmKnt[i] != null)
					model.setEstmKnt(estmKnt[i]);
				if (batCmplFlgDesc[i] != null)
					model.setBatCmplFlgDesc(batCmplFlgDesc[i]);
				if (estmUpdEndDt[i] != null)
					model.setEstmUpdEndDt(estmUpdEndDt[i]);
				if (mapgAlocEndDt[i] != null)
					model.setMapgAlocEndDt(mapgAlocEndDt[i]);
				if (revVvdIfKnt[i] != null)
					model.setRevVvdIfKnt(revVvdIfKnt[i]);
				if (apClzFlg[i] != null)
					model.setApClzFlg(apClzFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exeYrmonFrom[i] != null)
					model.setExeYrmonFrom(exeYrmonFrom[i]);
				if (estmEndDt[i] != null)
					model.setEstmEndDt(estmEndDt[i]);
				if (monAvgXchRtIfFlgDesc[i] != null)
					model.setMonAvgXchRtIfFlgDesc(monAvgXchRtIfFlgDesc[i]);
				if (estmStDt[i] != null)
					model.setEstmStDt(estmStDt[i]);
				if (exeYrmonTo[i] != null)
					model.setExeYrmonTo(exeYrmonTo[i]);
				if (erpIfFlg[i] != null)
					model.setErpIfFlg(erpIfFlg[i]);
				if (mapgAlocStDt[i] != null)
					model.setMapgAlocStDt(mapgAlocStDt[i]);
				if (batRmk[i] != null)
					model.setBatRmk(batRmk[i]);
				if (monAvgXchRtIfFlg[i] != null)
					model.setMonAvgXchRtIfFlg(monAvgXchRtIfFlg[i]);
				if (estmUpdKnt[i] != null)
					model.setEstmUpdKnt(estmUpdKnt[i]);
				if (monAvgXchRtIfKnt[i] != null)
					model.setMonAvgXchRtIfKnt(monAvgXchRtIfKnt[i]);
				if (batCmplFlg[i] != null)
					model.setBatCmplFlg(batCmplFlg[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (batStDt[i] != null)
					model.setBatStDt(batStDt[i]);
				if (batId[i] != null)
					model.setBatId(batId[i]);
				if (mapgAlocKnt[i] != null)
					model.setMapgAlocKnt(mapgAlocKnt[i]);
				if (erpIfDt[i] != null)
					model.setErpIfDt(erpIfDt[i]);
				if (errKnt[i] != null)
					model.setErrKnt(errKnt[i]);
				if (mnlInpFlg[i] != null)
					model.setMnlInpFlg(mnlInpFlg[i]);
				if (revVvdIfFlgDesc[i] != null)
					model.setRevVvdIfFlgDesc(revVvdIfFlgDesc[i]);
				if (batEndDt[i] != null)
					model.setBatEndDt(batEndDt[i]);
				if (estmUpdStDt[i] != null)
					model.setEstmUpdStDt(estmUpdStDt[i]);
				if (mnlInpFlgDesc[i] != null)
					model.setMnlInpFlgDesc(mnlInpFlgDesc[i]);
				if (apClzFlgDesc[i] != null)
					model.setApClzFlgDesc(apClzFlgDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualBatchExecuteResultHistoryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualBatchExecuteResultHistoryListVO[]
	 */
	public SearchAccrualBatchExecuteResultHistoryListVO[] getSearchAccrualBatchExecuteResultHistoryListVOs(){
		SearchAccrualBatchExecuteResultHistoryListVO[] vos = (SearchAccrualBatchExecuteResultHistoryListVO[])models.toArray(new SearchAccrualBatchExecuteResultHistoryListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.revVvdIfFlg = this.revVvdIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmKnt = this.estmKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batCmplFlgDesc = this.batCmplFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmUpdEndDt = this.estmUpdEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgAlocEndDt = this.mapgAlocEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdIfKnt = this.revVvdIfKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apClzFlg = this.apClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmonFrom = this.exeYrmonFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmEndDt = this.estmEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAvgXchRtIfFlgDesc = this.monAvgXchRtIfFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmStDt = this.estmStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmonTo = this.exeYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfFlg = this.erpIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgAlocStDt = this.mapgAlocStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batRmk = this.batRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAvgXchRtIfFlg = this.monAvgXchRtIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmUpdKnt = this.estmUpdKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monAvgXchRtIfKnt = this.monAvgXchRtIfKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batCmplFlg = this.batCmplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batStDt = this.batStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batId = this.batId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgAlocKnt = this.mapgAlocKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.erpIfDt = this.erpIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errKnt = this.errKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlg = this.mnlInpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdIfFlgDesc = this.revVvdIfFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batEndDt = this.batEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmUpdStDt = this.estmUpdStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlInpFlgDesc = this.mnlInpFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apClzFlgDesc = this.apClzFlgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
