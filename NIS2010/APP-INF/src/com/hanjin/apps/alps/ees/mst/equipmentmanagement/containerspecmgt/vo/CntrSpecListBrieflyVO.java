/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : asdfVO.java
*@FileTitle : asdfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.04
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2011.07.04 나상보 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo;

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
 * @author 나상보
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrSpecListBrieflyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrSpecListBrieflyVO> models = new ArrayList<CntrSpecListBrieflyVO>();
	
	/* Column Info */
	private String cntrSpecNo = null;
	/* Column Info */
	private String lodCapa = null;
	/* Column Info */
	private String opnDorWdt = null;
	/* Column Info */
	private String toSpecYr = null;
	/* Column Info */
	private String minTemp = null;
	/* Column Info */
	private String rfMdlNm = null;
	/* Column Info */
	private String xterLen = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlActQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrHngrRckFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String fromSpecYr = null;
	/* Column Info */
	private String aproTirNo = null;
	/* Column Info */
	private String aproUicNo = null;
	/* Column Info */
	private String tareWgt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String ttlLotQty = null;
	/* Column Info */
	private String opnDorHgt = null;
	/* Column Info */
	private String ownCntrFlg = null;
	/* Column Info */
	private String interLen = null;
	/* Column Info */
	private String lotNo = null;
	/* Column Info */
	private String rcLdbHgt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String serRange = null;
	/* Column Info */
	private String interWdt = null;
	/* Column Info */
	private String interHgt = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Column Info */
	private String aproTctNo = null;
	/* Column Info */
	private String maxTemp = null;
	/* Column Info */
	private String rfMkrSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String fctrySpecNo = null;
	/* Column Info */
	private String aproCscNo = null;
	/* Column Info */
	private String tnkCapa = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String xterHgt = null;
	/* Column Info */
	private String cntrMtrlCd = null;
	/* Column Info */
	private String cntrGrsWgt = null;
	/* Column Info */
	private String xterWdt = null;
	/* Column Info */
	private String rfRfrNo = null;
	/* Column Info */
	private String rfTpCd = null;
	/* Column Info */
	private String rcLdbCapa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrSpecListBrieflyVO() {}

	public CntrSpecListBrieflyVO(String ibflag, String pagerows, String cntrSpecNo, String lodCapa, String opnDorWdt, String toSpecYr, String minTemp, String xterLen, String rfMdlNm, String cntrTpszCd, String fromSpecYr, String aproTirNo, String aproUicNo, String tareWgt, String lstmCd, String opnDorHgt, String ownCntrFlg, String interLen, String lotNo, String rcLdbHgt, String agmtNo, String serRange, String interWdt, String interHgt, String aproTctNo, String maxTemp, String rfMkrSeq, String vndrSeq, String tnkCapa, String aproCscNo, String fctrySpecNo, String xterHgt, String vndrAbbrNm, String cntrGrsWgt, String cntrMtrlCd, String xterWdt, String rfRfrNo, String rcLdbCapa, String ttlLotQty, String ttlActQty, String rfTpCd, String cntrHngrRckFlg, String plstFlrFlg) {
		this.cntrSpecNo = cntrSpecNo;
		this.lodCapa = lodCapa;
		this.opnDorWdt = opnDorWdt;
		this.toSpecYr = toSpecYr;
		this.minTemp = minTemp;
		this.rfMdlNm = rfMdlNm;
		this.xterLen = xterLen;
		this.pagerows = pagerows;
		this.ttlActQty = ttlActQty;
		this.ibflag = ibflag;
		this.cntrHngrRckFlg = cntrHngrRckFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.fromSpecYr = fromSpecYr;
		this.aproTirNo = aproTirNo;
		this.aproUicNo = aproUicNo;
		this.tareWgt = tareWgt;
		this.lstmCd = lstmCd;
		this.ttlLotQty = ttlLotQty;
		this.opnDorHgt = opnDorHgt;
		this.ownCntrFlg = ownCntrFlg;
		this.interLen = interLen;
		this.lotNo = lotNo;
		this.rcLdbHgt = rcLdbHgt;
		this.agmtNo = agmtNo;
		this.serRange = serRange;
		this.interWdt = interWdt;
		this.interHgt = interHgt;
		this.plstFlrFlg = plstFlrFlg;
		this.aproTctNo = aproTctNo;
		this.maxTemp = maxTemp;
		this.rfMkrSeq = rfMkrSeq;
		this.vndrSeq = vndrSeq;
		this.fctrySpecNo = fctrySpecNo;
		this.aproCscNo = aproCscNo;
		this.tnkCapa = tnkCapa;
		this.vndrAbbrNm = vndrAbbrNm;
		this.xterHgt = xterHgt;
		this.cntrMtrlCd = cntrMtrlCd;
		this.cntrGrsWgt = cntrGrsWgt;
		this.xterWdt = xterWdt;
		this.rfRfrNo = rfRfrNo;
		this.rfTpCd = rfTpCd;
		this.rcLdbCapa = rcLdbCapa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());
		this.hashColumns.put("lod_capa", getLodCapa());
		this.hashColumns.put("opn_dor_wdt", getOpnDorWdt());
		this.hashColumns.put("to_spec_yr", getToSpecYr());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());
		this.hashColumns.put("xter_len", getXterLen());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_act_qty", getTtlActQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_hngr_rck_flg", getCntrHngrRckFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("from_spec_yr", getFromSpecYr());
		this.hashColumns.put("apro_tir_no", getAproTirNo());
		this.hashColumns.put("apro_uic_no", getAproUicNo());
		this.hashColumns.put("tare_wgt", getTareWgt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("ttl_lot_qty", getTtlLotQty());
		this.hashColumns.put("opn_dor_hgt", getOpnDorHgt());
		this.hashColumns.put("own_cntr_flg", getOwnCntrFlg());
		this.hashColumns.put("inter_len", getInterLen());
		this.hashColumns.put("lot_no", getLotNo());
		this.hashColumns.put("rc_ldb_hgt", getRcLdbHgt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("ser_range", getSerRange());
		this.hashColumns.put("inter_wdt", getInterWdt());
		this.hashColumns.put("inter_hgt", getInterHgt());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("apro_tct_no", getAproTctNo());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fctry_spec_no", getFctrySpecNo());
		this.hashColumns.put("apro_csc_no", getAproCscNo());
		this.hashColumns.put("tnk_capa", getTnkCapa());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("xter_hgt", getXterHgt());
		this.hashColumns.put("cntr_mtrl_cd", getCntrMtrlCd());
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());
		this.hashColumns.put("xter_wdt", getXterWdt());
		this.hashColumns.put("rf_rfr_no", getRfRfrNo());
		this.hashColumns.put("rf_tp_cd", getRfTpCd());
		this.hashColumns.put("rc_ldb_capa", getRcLdbCapa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("lod_capa", "lodCapa");
		this.hashFields.put("opn_dor_wdt", "opnDorWdt");
		this.hashFields.put("to_spec_yr", "toSpecYr");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("xter_len", "xterLen");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_act_qty", "ttlActQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_hngr_rck_flg", "cntrHngrRckFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("from_spec_yr", "fromSpecYr");
		this.hashFields.put("apro_tir_no", "aproTirNo");
		this.hashFields.put("apro_uic_no", "aproUicNo");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("ttl_lot_qty", "ttlLotQty");
		this.hashFields.put("opn_dor_hgt", "opnDorHgt");
		this.hashFields.put("own_cntr_flg", "ownCntrFlg");
		this.hashFields.put("inter_len", "interLen");
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("rc_ldb_hgt", "rcLdbHgt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ser_range", "serRange");
		this.hashFields.put("inter_wdt", "interWdt");
		this.hashFields.put("inter_hgt", "interHgt");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("apro_tct_no", "aproTctNo");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fctry_spec_no", "fctrySpecNo");
		this.hashFields.put("apro_csc_no", "aproCscNo");
		this.hashFields.put("tnk_capa", "tnkCapa");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("xter_hgt", "xterHgt");
		this.hashFields.put("cntr_mtrl_cd", "cntrMtrlCd");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("xter_wdt", "xterWdt");
		this.hashFields.put("rf_rfr_no", "rfRfrNo");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("rc_ldb_capa", "rcLdbCapa");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrSpecNo
	 */
	public String getCntrSpecNo() {
		return this.cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @return lodCapa
	 */
	public String getLodCapa() {
		return this.lodCapa;
	}
	
	/**
	 * Column Info
	 * @return opnDorWdt
	 */
	public String getOpnDorWdt() {
		return this.opnDorWdt;
	}
	
	/**
	 * Column Info
	 * @return toSpecYr
	 */
	public String getToSpecYr() {
		return this.toSpecYr;
	}
	
	/**
	 * Column Info
	 * @return minTemp
	 */
	public String getMinTemp() {
		return this.minTemp;
	}
	
	/**
	 * Column Info
	 * @return rfMdlNm
	 */
	public String getRfMdlNm() {
		return this.rfMdlNm;
	}
	
	/**
	 * Column Info
	 * @return xterLen
	 */
	public String getXterLen() {
		return this.xterLen;
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
	 * @return ttlActQty
	 */
	public String getTtlActQty() {
		return this.ttlActQty;
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
	 * @return cntrHngrRckFlg
	 */
	public String getCntrHngrRckFlg() {
		return this.cntrHngrRckFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return fromSpecYr
	 */
	public String getFromSpecYr() {
		return this.fromSpecYr;
	}
	
	/**
	 * Column Info
	 * @return aproTirNo
	 */
	public String getAproTirNo() {
		return this.aproTirNo;
	}
	
	/**
	 * Column Info
	 * @return aproUicNo
	 */
	public String getAproUicNo() {
		return this.aproUicNo;
	}
	
	/**
	 * Column Info
	 * @return tareWgt
	 */
	public String getTareWgt() {
		return this.tareWgt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return ttlLotQty
	 */
	public String getTtlLotQty() {
		return this.ttlLotQty;
	}
	
	/**
	 * Column Info
	 * @return opnDorHgt
	 */
	public String getOpnDorHgt() {
		return this.opnDorHgt;
	}
	
	/**
	 * Column Info
	 * @return ownCntrFlg
	 */
	public String getOwnCntrFlg() {
		return this.ownCntrFlg;
	}
	
	/**
	 * Column Info
	 * @return interLen
	 */
	public String getInterLen() {
		return this.interLen;
	}
	
	/**
	 * Column Info
	 * @return lotNo
	 */
	public String getLotNo() {
		return this.lotNo;
	}
	
	/**
	 * Column Info
	 * @return rcLdbHgt
	 */
	public String getRcLdbHgt() {
		return this.rcLdbHgt;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return serRange
	 */
	public String getSerRange() {
		return this.serRange;
	}
	
	/**
	 * Column Info
	 * @return interWdt
	 */
	public String getInterWdt() {
		return this.interWdt;
	}
	
	/**
	 * Column Info
	 * @return interHgt
	 */
	public String getInterHgt() {
		return this.interHgt;
	}
	
	/**
	 * Column Info
	 * @return plstFlrFlg
	 */
	public String getPlstFlrFlg() {
		return this.plstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @return aproTctNo
	 */
	public String getAproTctNo() {
		return this.aproTctNo;
	}
	
	/**
	 * Column Info
	 * @return maxTemp
	 */
	public String getMaxTemp() {
		return this.maxTemp;
	}
	
	/**
	 * Column Info
	 * @return rfMkrSeq
	 */
	public String getRfMkrSeq() {
		return this.rfMkrSeq;
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
	 * @return fctrySpecNo
	 */
	public String getFctrySpecNo() {
		return this.fctrySpecNo;
	}
	
	/**
	 * Column Info
	 * @return aproCscNo
	 */
	public String getAproCscNo() {
		return this.aproCscNo;
	}
	
	/**
	 * Column Info
	 * @return tnkCapa
	 */
	public String getTnkCapa() {
		return this.tnkCapa;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return xterHgt
	 */
	public String getXterHgt() {
		return this.xterHgt;
	}
	
	/**
	 * Column Info
	 * @return cntrMtrlCd
	 */
	public String getCntrMtrlCd() {
		return this.cntrMtrlCd;
	}
	
	/**
	 * Column Info
	 * @return cntrGrsWgt
	 */
	public String getCntrGrsWgt() {
		return this.cntrGrsWgt;
	}
	
	/**
	 * Column Info
	 * @return xterWdt
	 */
	public String getXterWdt() {
		return this.xterWdt;
	}
	
	/**
	 * Column Info
	 * @return rfRfrNo
	 */
	public String getRfRfrNo() {
		return this.rfRfrNo;
	}
	
	/**
	 * Column Info
	 * @return rfTpCd
	 */
	public String getRfTpCd() {
		return this.rfTpCd;
	}
	
	/**
	 * Column Info
	 * @return rcLdbCapa
	 */
	public String getRcLdbCapa() {
		return this.rcLdbCapa;
	}
	

	/**
	 * Column Info
	 * @param cntrSpecNo
	 */
	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @param lodCapa
	 */
	public void setLodCapa(String lodCapa) {
		this.lodCapa = lodCapa;
	}
	
	/**
	 * Column Info
	 * @param opnDorWdt
	 */
	public void setOpnDorWdt(String opnDorWdt) {
		this.opnDorWdt = opnDorWdt;
	}
	
	/**
	 * Column Info
	 * @param toSpecYr
	 */
	public void setToSpecYr(String toSpecYr) {
		this.toSpecYr = toSpecYr;
	}
	
	/**
	 * Column Info
	 * @param minTemp
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}
	
	/**
	 * Column Info
	 * @param rfMdlNm
	 */
	public void setRfMdlNm(String rfMdlNm) {
		this.rfMdlNm = rfMdlNm;
	}
	
	/**
	 * Column Info
	 * @param xterLen
	 */
	public void setXterLen(String xterLen) {
		this.xterLen = xterLen;
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
	 * @param ttlActQty
	 */
	public void setTtlActQty(String ttlActQty) {
		this.ttlActQty = ttlActQty;
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
	 * @param cntrHngrRckFlg
	 */
	public void setCntrHngrRckFlg(String cntrHngrRckFlg) {
		this.cntrHngrRckFlg = cntrHngrRckFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param fromSpecYr
	 */
	public void setFromSpecYr(String fromSpecYr) {
		this.fromSpecYr = fromSpecYr;
	}
	
	/**
	 * Column Info
	 * @param aproTirNo
	 */
	public void setAproTirNo(String aproTirNo) {
		this.aproTirNo = aproTirNo;
	}
	
	/**
	 * Column Info
	 * @param aproUicNo
	 */
	public void setAproUicNo(String aproUicNo) {
		this.aproUicNo = aproUicNo;
	}
	
	/**
	 * Column Info
	 * @param tareWgt
	 */
	public void setTareWgt(String tareWgt) {
		this.tareWgt = tareWgt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param ttlLotQty
	 */
	public void setTtlLotQty(String ttlLotQty) {
		this.ttlLotQty = ttlLotQty;
	}
	
	/**
	 * Column Info
	 * @param opnDorHgt
	 */
	public void setOpnDorHgt(String opnDorHgt) {
		this.opnDorHgt = opnDorHgt;
	}
	
	/**
	 * Column Info
	 * @param ownCntrFlg
	 */
	public void setOwnCntrFlg(String ownCntrFlg) {
		this.ownCntrFlg = ownCntrFlg;
	}
	
	/**
	 * Column Info
	 * @param interLen
	 */
	public void setInterLen(String interLen) {
		this.interLen = interLen;
	}
	
	/**
	 * Column Info
	 * @param lotNo
	 */
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	
	/**
	 * Column Info
	 * @param rcLdbHgt
	 */
	public void setRcLdbHgt(String rcLdbHgt) {
		this.rcLdbHgt = rcLdbHgt;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param serRange
	 */
	public void setSerRange(String serRange) {
		this.serRange = serRange;
	}
	
	/**
	 * Column Info
	 * @param interWdt
	 */
	public void setInterWdt(String interWdt) {
		this.interWdt = interWdt;
	}
	
	/**
	 * Column Info
	 * @param interHgt
	 */
	public void setInterHgt(String interHgt) {
		this.interHgt = interHgt;
	}
	
	/**
	 * Column Info
	 * @param plstFlrFlg
	 */
	public void setPlstFlrFlg(String plstFlrFlg) {
		this.plstFlrFlg = plstFlrFlg;
	}
	
	/**
	 * Column Info
	 * @param aproTctNo
	 */
	public void setAproTctNo(String aproTctNo) {
		this.aproTctNo = aproTctNo;
	}
	
	/**
	 * Column Info
	 * @param maxTemp
	 */
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}
	
	/**
	 * Column Info
	 * @param rfMkrSeq
	 */
	public void setRfMkrSeq(String rfMkrSeq) {
		this.rfMkrSeq = rfMkrSeq;
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
	 * @param fctrySpecNo
	 */
	public void setFctrySpecNo(String fctrySpecNo) {
		this.fctrySpecNo = fctrySpecNo;
	}
	
	/**
	 * Column Info
	 * @param aproCscNo
	 */
	public void setAproCscNo(String aproCscNo) {
		this.aproCscNo = aproCscNo;
	}
	
	/**
	 * Column Info
	 * @param tnkCapa
	 */
	public void setTnkCapa(String tnkCapa) {
		this.tnkCapa = tnkCapa;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param xterHgt
	 */
	public void setXterHgt(String xterHgt) {
		this.xterHgt = xterHgt;
	}
	
	/**
	 * Column Info
	 * @param cntrMtrlCd
	 */
	public void setCntrMtrlCd(String cntrMtrlCd) {
		this.cntrMtrlCd = cntrMtrlCd;
	}
	
	/**
	 * Column Info
	 * @param cntrGrsWgt
	 */
	public void setCntrGrsWgt(String cntrGrsWgt) {
		this.cntrGrsWgt = cntrGrsWgt;
	}
	
	/**
	 * Column Info
	 * @param xterWdt
	 */
	public void setXterWdt(String xterWdt) {
		this.xterWdt = xterWdt;
	}
	
	/**
	 * Column Info
	 * @param rfRfrNo
	 */
	public void setRfRfrNo(String rfRfrNo) {
		this.rfRfrNo = rfRfrNo;
	}
	
	/**
	 * Column Info
	 * @param rfTpCd
	 */
	public void setRfTpCd(String rfTpCd) {
		this.rfTpCd = rfTpCd;
	}
	
	/**
	 * Column Info
	 * @param rcLdbCapa
	 */
	public void setRcLdbCapa(String rcLdbCapa) {
		this.rcLdbCapa = rcLdbCapa;
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
		setCntrSpecNo(JSPUtil.getParameter(request, prefix + "cntr_spec_no", ""));
		setLodCapa(JSPUtil.getParameter(request, prefix + "lod_capa", ""));
		setOpnDorWdt(JSPUtil.getParameter(request, prefix + "opn_dor_wdt", ""));
		setToSpecYr(JSPUtil.getParameter(request, prefix + "to_spec_yr", ""));
		setMinTemp(JSPUtil.getParameter(request, prefix + "min_temp", ""));
		setRfMdlNm(JSPUtil.getParameter(request, prefix + "rf_mdl_nm", ""));
		setXterLen(JSPUtil.getParameter(request, prefix + "xter_len", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlActQty(JSPUtil.getParameter(request, prefix + "ttl_act_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrHngrRckFlg(JSPUtil.getParameter(request, prefix + "cntr_hngr_rck_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFromSpecYr(JSPUtil.getParameter(request, prefix + "from_spec_yr", ""));
		setAproTirNo(JSPUtil.getParameter(request, prefix + "apro_tir_no", ""));
		setAproUicNo(JSPUtil.getParameter(request, prefix + "apro_uic_no", ""));
		setTareWgt(JSPUtil.getParameter(request, prefix + "tare_wgt", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setTtlLotQty(JSPUtil.getParameter(request, prefix + "ttl_lot_qty", ""));
		setOpnDorHgt(JSPUtil.getParameter(request, prefix + "opn_dor_hgt", ""));
		setOwnCntrFlg(JSPUtil.getParameter(request, prefix + "own_cntr_flg", ""));
		setInterLen(JSPUtil.getParameter(request, prefix + "inter_len", ""));
		setLotNo(JSPUtil.getParameter(request, prefix + "lot_no", ""));
		setRcLdbHgt(JSPUtil.getParameter(request, prefix + "rc_ldb_hgt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setSerRange(JSPUtil.getParameter(request, prefix + "ser_range", ""));
		setInterWdt(JSPUtil.getParameter(request, prefix + "inter_wdt", ""));
		setInterHgt(JSPUtil.getParameter(request, prefix + "inter_hgt", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, prefix + "plst_flr_flg", ""));
		setAproTctNo(JSPUtil.getParameter(request, prefix + "apro_tct_no", ""));
		setMaxTemp(JSPUtil.getParameter(request, prefix + "max_temp", ""));
		setRfMkrSeq(JSPUtil.getParameter(request, prefix + "rf_mkr_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setFctrySpecNo(JSPUtil.getParameter(request, prefix + "fctry_spec_no", ""));
		setAproCscNo(JSPUtil.getParameter(request, prefix + "apro_csc_no", ""));
		setTnkCapa(JSPUtil.getParameter(request, prefix + "tnk_capa", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", ""));
		setXterHgt(JSPUtil.getParameter(request, prefix + "xter_hgt", ""));
		setCntrMtrlCd(JSPUtil.getParameter(request, prefix + "cntr_mtrl_cd", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request, prefix + "cntr_grs_wgt", ""));
		setXterWdt(JSPUtil.getParameter(request, prefix + "xter_wdt", ""));
		setRfRfrNo(JSPUtil.getParameter(request, prefix + "rf_rfr_no", ""));
		setRfTpCd(JSPUtil.getParameter(request, prefix + "rf_tp_cd", ""));
		setRcLdbCapa(JSPUtil.getParameter(request, prefix + "rc_ldb_capa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return asdfVO[]
	 */
	public CntrSpecListBrieflyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return asdfVO[]
	 */
	public CntrSpecListBrieflyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrSpecListBrieflyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no", length));
			String[] lodCapa = (JSPUtil.getParameter(request, prefix	+ "lod_capa", length));
			String[] opnDorWdt = (JSPUtil.getParameter(request, prefix	+ "opn_dor_wdt", length));
			String[] toSpecYr = (JSPUtil.getParameter(request, prefix	+ "to_spec_yr", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] rfMdlNm = (JSPUtil.getParameter(request, prefix	+ "rf_mdl_nm", length));
			String[] xterLen = (JSPUtil.getParameter(request, prefix	+ "xter_len", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlActQty = (JSPUtil.getParameter(request, prefix	+ "ttl_act_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrHngrRckFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] fromSpecYr = (JSPUtil.getParameter(request, prefix	+ "from_spec_yr", length));
			String[] aproTirNo = (JSPUtil.getParameter(request, prefix	+ "apro_tir_no", length));
			String[] aproUicNo = (JSPUtil.getParameter(request, prefix	+ "apro_uic_no", length));
			String[] tareWgt = (JSPUtil.getParameter(request, prefix	+ "tare_wgt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] ttlLotQty = (JSPUtil.getParameter(request, prefix	+ "ttl_lot_qty", length));
			String[] opnDorHgt = (JSPUtil.getParameter(request, prefix	+ "opn_dor_hgt", length));
			String[] ownCntrFlg = (JSPUtil.getParameter(request, prefix	+ "own_cntr_flg", length));
			String[] interLen = (JSPUtil.getParameter(request, prefix	+ "inter_len", length));
			String[] lotNo = (JSPUtil.getParameter(request, prefix	+ "lot_no", length));
			String[] rcLdbHgt = (JSPUtil.getParameter(request, prefix	+ "rc_ldb_hgt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] serRange = (JSPUtil.getParameter(request, prefix	+ "ser_range", length));
			String[] interWdt = (JSPUtil.getParameter(request, prefix	+ "inter_wdt", length));
			String[] interHgt = (JSPUtil.getParameter(request, prefix	+ "inter_hgt", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] aproTctNo = (JSPUtil.getParameter(request, prefix	+ "apro_tct_no", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] rfMkrSeq = (JSPUtil.getParameter(request, prefix	+ "rf_mkr_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] fctrySpecNo = (JSPUtil.getParameter(request, prefix	+ "fctry_spec_no", length));
			String[] aproCscNo = (JSPUtil.getParameter(request, prefix	+ "apro_csc_no", length));
			String[] tnkCapa = (JSPUtil.getParameter(request, prefix	+ "tnk_capa", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] xterHgt = (JSPUtil.getParameter(request, prefix	+ "xter_hgt", length));
			String[] cntrMtrlCd = (JSPUtil.getParameter(request, prefix	+ "cntr_mtrl_cd", length));
			String[] cntrGrsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_grs_wgt", length));
			String[] xterWdt = (JSPUtil.getParameter(request, prefix	+ "xter_wdt", length));
			String[] rfRfrNo = (JSPUtil.getParameter(request, prefix	+ "rf_rfr_no", length));
			String[] rfTpCd = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd", length));
			String[] rcLdbCapa = (JSPUtil.getParameter(request, prefix	+ "rc_ldb_capa", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrSpecListBrieflyVO();
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				if (lodCapa[i] != null)
					model.setLodCapa(lodCapa[i]);
				if (opnDorWdt[i] != null)
					model.setOpnDorWdt(opnDorWdt[i]);
				if (toSpecYr[i] != null)
					model.setToSpecYr(toSpecYr[i]);
				if (minTemp[i] != null)
					model.setMinTemp(minTemp[i]);
				if (rfMdlNm[i] != null)
					model.setRfMdlNm(rfMdlNm[i]);
				if (xterLen[i] != null)
					model.setXterLen(xterLen[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlActQty[i] != null)
					model.setTtlActQty(ttlActQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrHngrRckFlg[i] != null)
					model.setCntrHngrRckFlg(cntrHngrRckFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (fromSpecYr[i] != null)
					model.setFromSpecYr(fromSpecYr[i]);
				if (aproTirNo[i] != null)
					model.setAproTirNo(aproTirNo[i]);
				if (aproUicNo[i] != null)
					model.setAproUicNo(aproUicNo[i]);
				if (tareWgt[i] != null)
					model.setTareWgt(tareWgt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (ttlLotQty[i] != null)
					model.setTtlLotQty(ttlLotQty[i]);
				if (opnDorHgt[i] != null)
					model.setOpnDorHgt(opnDorHgt[i]);
				if (ownCntrFlg[i] != null)
					model.setOwnCntrFlg(ownCntrFlg[i]);
				if (interLen[i] != null)
					model.setInterLen(interLen[i]);
				if (lotNo[i] != null)
					model.setLotNo(lotNo[i]);
				if (rcLdbHgt[i] != null)
					model.setRcLdbHgt(rcLdbHgt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (serRange[i] != null)
					model.setSerRange(serRange[i]);
				if (interWdt[i] != null)
					model.setInterWdt(interWdt[i]);
				if (interHgt[i] != null)
					model.setInterHgt(interHgt[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (aproTctNo[i] != null)
					model.setAproTctNo(aproTctNo[i]);
				if (maxTemp[i] != null)
					model.setMaxTemp(maxTemp[i]);
				if (rfMkrSeq[i] != null)
					model.setRfMkrSeq(rfMkrSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fctrySpecNo[i] != null)
					model.setFctrySpecNo(fctrySpecNo[i]);
				if (aproCscNo[i] != null)
					model.setAproCscNo(aproCscNo[i]);
				if (tnkCapa[i] != null)
					model.setTnkCapa(tnkCapa[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (xterHgt[i] != null)
					model.setXterHgt(xterHgt[i]);
				if (cntrMtrlCd[i] != null)
					model.setCntrMtrlCd(cntrMtrlCd[i]);
				if (cntrGrsWgt[i] != null)
					model.setCntrGrsWgt(cntrGrsWgt[i]);
				if (xterWdt[i] != null)
					model.setXterWdt(xterWdt[i]);
				if (rfRfrNo[i] != null)
					model.setRfRfrNo(rfRfrNo[i]);
				if (rfTpCd[i] != null)
					model.setRfTpCd(rfTpCd[i]);
				if (rcLdbCapa[i] != null)
					model.setRcLdbCapa(rcLdbCapa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getasdfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return asdfVO[]
	 */
	public CntrSpecListBrieflyVO[] getasdfVOs(){
		CntrSpecListBrieflyVO[] vos = (CntrSpecListBrieflyVO[])models.toArray(new CntrSpecListBrieflyVO[models.size()]);
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
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodCapa = this.lodCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnDorWdt = this.opnDorWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSpecYr = this.toSpecYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm = this.rfMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterLen = this.xterLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlActQty = this.ttlActQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckFlg = this.cntrHngrRckFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromSpecYr = this.fromSpecYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTirNo = this.aproTirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUicNo = this.aproUicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt = this.tareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLotQty = this.ttlLotQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opnDorHgt = this.opnDorHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownCntrFlg = this.ownCntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interLen = this.interLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotNo = this.lotNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcLdbHgt = this.rcLdbHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serRange = this.serRange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interWdt = this.interWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interHgt = this.interHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproTctNo = this.aproTctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq = this.rfMkrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctrySpecNo = this.fctrySpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproCscNo = this.aproCscNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tnkCapa = this.tnkCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterHgt = this.xterHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMtrlCd = this.cntrMtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt = this.cntrGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterWdt = this.xterWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRfrNo = this.rfRfrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd = this.rfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcLdbCapa = this.rcLdbCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
