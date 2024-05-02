/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ErpFaInterfaceMGTVO.java
*@FileTitle : ErpFaInterfaceMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.13 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ErpFaInterfaceMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ErpFaInterfaceMGTVO> models = new ArrayList<ErpFaInterfaceMGTVO>();
	
	/* Column Info */
	private String ifSeq = null;
	/* Column Info */
	private String eqNoFm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locationSegment = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String assetType = null;
	/* Column Info */
	private String investCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String faIfGrpSeqNo = null;
	/* Column Info */
	private String datePlacedInService = null;
	/* Column Info */
	private String cost = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String attribute4 = null;
	/* Column Info */
	private String createdBy = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String manufacturer = null;
	/* Column Info */
	private String assetDescription = null;
	/* Column Info */
	private String tagNumber = null;
	/* Column Info */
	private String attribute1 = null;
	/* Column Info */
	private String attribute2 = null;
	/* Column Info */
	private String attribute3 = null;
	/* Column Info */
	private String ifTtlRowKnt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String actAmt = null;
	/* Column Info */
	private String faIfStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String eqSpecNo = null;
	/* Column Info */
	private String attribute21 = null;
	/* Column Info */
	private String agmt = null;
	/* Column Info */
	private String faIfTpCd = null;
	/* Column Info */
	private String eqNoTo = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String categorySegment = null;
	/* Column Info */
	private String deYrmon = null;
	/* Column Info */
	private String lastUpdateDate = null;
	/* Column Info */
	private String eaiIfNo = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String creationDate = null;
	/* Column Info */
	private String acqMth = null;
	/* Column Info */
	private String lastUpdatedBy = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String bookTypeCode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ErpFaInterfaceMGTVO() {}

	public ErpFaInterfaceMGTVO(String ibflag, String pagerows, String currCd, String agmtSeq, String vndrLglEngNm, String agmt, String eqNoTo, String eqKndCd, String eqNoFm, String onhDt, String actAmt, String deYrmon, String eqTpszCd, String faIfStsCd, String eqNo, String vndrSeq, String agmtOfcCtyCd, String investCd, String eqSpecNo, String delChk, String faIfTpCd, String updUsrId, String ifTtlRowKnt, String lifid, String seq, String totalCount, String rnum, String bookTypeCode, String assetDescription, String assetType, String categorySegment, String cost, String locationSegment, String datePlacedInService, String tagNumber, String attribute1, String attribute2, String attribute3, String attribute4, String createdBy, String creationDate, String lastUpdatedBy, String lastUpdateDate, String manufacturer, String attribute21, String acqMth, String ifSeq, String faIfGrpSeqNo, String eaiIfNo) {
		this.ifSeq = ifSeq;
		this.eqNoFm = eqNoFm;
		this.pagerows = pagerows;
		this.locationSegment = locationSegment;
		this.rnum = rnum;
		this.assetType = assetType;
		this.investCd = investCd;
		this.updUsrId = updUsrId;
		this.lifid = lifid;
		this.agmtSeq = agmtSeq;
		this.faIfGrpSeqNo = faIfGrpSeqNo;
		this.datePlacedInService = datePlacedInService;
		this.cost = cost;
		this.eqTpszCd = eqTpszCd;
		this.attribute4 = attribute4;
		this.createdBy = createdBy;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.manufacturer = manufacturer;
		this.assetDescription = assetDescription;
		this.tagNumber = tagNumber;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.ifTtlRowKnt = ifTtlRowKnt;
		this.currCd = currCd;
		this.vndrLglEngNm = vndrLglEngNm;
		this.onhDt = onhDt;
		this.actAmt = actAmt;
		this.faIfStsCd = faIfStsCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.totalCount = totalCount;
		this.eqSpecNo = eqSpecNo;
		this.attribute21 = attribute21;
		this.agmt = agmt;
		this.faIfTpCd = faIfTpCd;
		this.eqNoTo = eqNoTo;
		this.eqKndCd = eqKndCd;
		this.categorySegment = categorySegment;
		this.deYrmon = deYrmon;
		this.lastUpdateDate = lastUpdateDate;
		this.eaiIfNo = eaiIfNo;
		this.delChk = delChk;
		this.creationDate = creationDate;
		this.acqMth = acqMth;
		this.lastUpdatedBy = lastUpdatedBy;
		this.seq = seq;
		this.bookTypeCode = bookTypeCode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_seq", getIfSeq());
		this.hashColumns.put("eq_no_fm", getEqNoFm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("location_segment", getLocationSegment());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("asset_type", getAssetType());
		this.hashColumns.put("invest_cd", getInvestCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("fa_if_grp_seq_no", getFaIfGrpSeqNo());
		this.hashColumns.put("date_placed_in_service", getDatePlacedInService());
		this.hashColumns.put("cost", getCost());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("attribute4", getAttribute4());
		this.hashColumns.put("created_by", getCreatedBy());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("manufacturer", getManufacturer());
		this.hashColumns.put("asset_description", getAssetDescription());
		this.hashColumns.put("tag_number", getTagNumber());
		this.hashColumns.put("attribute1", getAttribute1());
		this.hashColumns.put("attribute2", getAttribute2());
		this.hashColumns.put("attribute3", getAttribute3());
		this.hashColumns.put("if_ttl_row_knt", getIfTtlRowKnt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("act_amt", getActAmt());
		this.hashColumns.put("fa_if_sts_cd", getFaIfStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		this.hashColumns.put("attribute21", getAttribute21());
		this.hashColumns.put("agmt", getAgmt());
		this.hashColumns.put("fa_if_tp_cd", getFaIfTpCd());
		this.hashColumns.put("eq_no_to", getEqNoTo());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("category_segment", getCategorySegment());
		this.hashColumns.put("de_yrmon", getDeYrmon());
		this.hashColumns.put("last_update_date", getLastUpdateDate());
		this.hashColumns.put("eai_if_no", getEaiIfNo());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("creation_date", getCreationDate());
		this.hashColumns.put("acq_mth", getAcqMth());
		this.hashColumns.put("last_updated_by", getLastUpdatedBy());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("book_type_code", getBookTypeCode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_seq", "ifSeq");
		this.hashFields.put("eq_no_fm", "eqNoFm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("location_segment", "locationSegment");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("asset_type", "assetType");
		this.hashFields.put("invest_cd", "investCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("fa_if_grp_seq_no", "faIfGrpSeqNo");
		this.hashFields.put("date_placed_in_service", "datePlacedInService");
		this.hashFields.put("cost", "cost");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("attribute4", "attribute4");
		this.hashFields.put("created_by", "createdBy");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("manufacturer", "manufacturer");
		this.hashFields.put("asset_description", "assetDescription");
		this.hashFields.put("tag_number", "tagNumber");
		this.hashFields.put("attribute1", "attribute1");
		this.hashFields.put("attribute2", "attribute2");
		this.hashFields.put("attribute3", "attribute3");
		this.hashFields.put("if_ttl_row_knt", "ifTtlRowKnt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("act_amt", "actAmt");
		this.hashFields.put("fa_if_sts_cd", "faIfStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		this.hashFields.put("attribute21", "attribute21");
		this.hashFields.put("agmt", "agmt");
		this.hashFields.put("fa_if_tp_cd", "faIfTpCd");
		this.hashFields.put("eq_no_to", "eqNoTo");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("category_segment", "categorySegment");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("last_update_date", "lastUpdateDate");
		this.hashFields.put("eai_if_no", "eaiIfNo");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("creation_date", "creationDate");
		this.hashFields.put("acq_mth", "acqMth");
		this.hashFields.put("last_updated_by", "lastUpdatedBy");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("book_type_code", "bookTypeCode");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifSeq
	 */
	public String getIfSeq() {
		return this.ifSeq;
	}
	
	/**
	 * Column Info
	 * @return eqNoFm
	 */
	public String getEqNoFm() {
		return this.eqNoFm;
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
	 * @return locationSegment
	 */
	public String getLocationSegment() {
		return this.locationSegment;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return assetType
	 */
	public String getAssetType() {
		return this.assetType;
	}
	
	/**
	 * Column Info
	 * @return investCd
	 */
	public String getInvestCd() {
		return this.investCd;
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
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return faIfGrpSeqNo
	 */
	public String getFaIfGrpSeqNo() {
		return this.faIfGrpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return datePlacedInService
	 */
	public String getDatePlacedInService() {
		return this.datePlacedInService;
	}
	
	/**
	 * Column Info
	 * @return cost
	 */
	public String getCost() {
		return this.cost;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return attribute4
	 */
	public String getAttribute4() {
		return this.attribute4;
	}
	
	/**
	 * Column Info
	 * @return createdBy
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
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
	 * @return manufacturer
	 */
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	/**
	 * Column Info
	 * @return assetDescription
	 */
	public String getAssetDescription() {
		return this.assetDescription;
	}
	
	/**
	 * Column Info
	 * @return tagNumber
	 */
	public String getTagNumber() {
		return this.tagNumber;
	}
	
	/**
	 * Column Info
	 * @return attribute1
	 */
	public String getAttribute1() {
		return this.attribute1;
	}
	
	/**
	 * Column Info
	 * @return attribute2
	 */
	public String getAttribute2() {
		return this.attribute2;
	}
	
	/**
	 * Column Info
	 * @return attribute3
	 */
	public String getAttribute3() {
		return this.attribute3;
	}
	
	/**
	 * Column Info
	 * @return ifTtlRowKnt
	 */
	public String getIfTtlRowKnt() {
		return this.ifTtlRowKnt;
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
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return actAmt
	 */
	public String getActAmt() {
		return this.actAmt;
	}
	
	/**
	 * Column Info
	 * @return faIfStsCd
	 */
	public String getFaIfStsCd() {
		return this.faIfStsCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * Column Info
	 * @return eqSpecNo
	 */
	public String getEqSpecNo() {
		return this.eqSpecNo;
	}
	
	/**
	 * Column Info
	 * @return attribute21
	 */
	public String getAttribute21() {
		return this.attribute21;
	}
	
	/**
	 * Column Info
	 * @return agmt
	 */
	public String getAgmt() {
		return this.agmt;
	}
	
	/**
	 * Column Info
	 * @return faIfTpCd
	 */
	public String getFaIfTpCd() {
		return this.faIfTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqNoTo
	 */
	public String getEqNoTo() {
		return this.eqNoTo;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return categorySegment
	 */
	public String getCategorySegment() {
		return this.categorySegment;
	}
	
	/**
	 * Column Info
	 * @return deYrmon
	 */
	public String getDeYrmon() {
		return this.deYrmon;
	}
	
	/**
	 * Column Info
	 * @return lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return this.lastUpdateDate;
	}
	
	/**
	 * Column Info
	 * @return eaiIfNo
	 */
	public String getEaiIfNo() {
		return this.eaiIfNo;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return creationDate
	 */
	public String getCreationDate() {
		return this.creationDate;
	}
	
	/**
	 * Column Info
	 * @return acqMth
	 */
	public String getAcqMth() {
		return this.acqMth;
	}
	
	/**
	 * Column Info
	 * @return lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return bookTypeCode
	 */
	public String getBookTypeCode() {
		return this.bookTypeCode;
	}
	

	/**
	 * Column Info
	 * @param ifSeq
	 */
	public void setIfSeq(String ifSeq) {
		this.ifSeq = ifSeq;
	}
	
	/**
	 * Column Info
	 * @param eqNoFm
	 */
	public void setEqNoFm(String eqNoFm) {
		this.eqNoFm = eqNoFm;
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
	 * @param locationSegment
	 */
	public void setLocationSegment(String locationSegment) {
		this.locationSegment = locationSegment;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param assetType
	 */
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	
	/**
	 * Column Info
	 * @param investCd
	 */
	public void setInvestCd(String investCd) {
		this.investCd = investCd;
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
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param faIfGrpSeqNo
	 */
	public void setFaIfGrpSeqNo(String faIfGrpSeqNo) {
		this.faIfGrpSeqNo = faIfGrpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param datePlacedInService
	 */
	public void setDatePlacedInService(String datePlacedInService) {
		this.datePlacedInService = datePlacedInService;
	}
	
	/**
	 * Column Info
	 * @param cost
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param attribute4
	 */
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	
	/**
	 * Column Info
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
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
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/**
	 * Column Info
	 * @param assetDescription
	 */
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	
	/**
	 * Column Info
	 * @param tagNumber
	 */
	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}
	
	/**
	 * Column Info
	 * @param attribute1
	 */
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	
	/**
	 * Column Info
	 * @param attribute2
	 */
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	
	/**
	 * Column Info
	 * @param attribute3
	 */
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	
	/**
	 * Column Info
	 * @param ifTtlRowKnt
	 */
	public void setIfTtlRowKnt(String ifTtlRowKnt) {
		this.ifTtlRowKnt = ifTtlRowKnt;
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
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param actAmt
	 */
	public void setActAmt(String actAmt) {
		this.actAmt = actAmt;
	}
	
	/**
	 * Column Info
	 * @param faIfStsCd
	 */
	public void setFaIfStsCd(String faIfStsCd) {
		this.faIfStsCd = faIfStsCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * Column Info
	 * @param eqSpecNo
	 */
	public void setEqSpecNo(String eqSpecNo) {
		this.eqSpecNo = eqSpecNo;
	}
	
	/**
	 * Column Info
	 * @param attribute21
	 */
	public void setAttribute21(String attribute21) {
		this.attribute21 = attribute21;
	}
	
	/**
	 * Column Info
	 * @param agmt
	 */
	public void setAgmt(String agmt) {
		this.agmt = agmt;
	}
	
	/**
	 * Column Info
	 * @param faIfTpCd
	 */
	public void setFaIfTpCd(String faIfTpCd) {
		this.faIfTpCd = faIfTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqNoTo
	 */
	public void setEqNoTo(String eqNoTo) {
		this.eqNoTo = eqNoTo;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param categorySegment
	 */
	public void setCategorySegment(String categorySegment) {
		this.categorySegment = categorySegment;
	}
	
	/**
	 * Column Info
	 * @param deYrmon
	 */
	public void setDeYrmon(String deYrmon) {
		this.deYrmon = deYrmon;
	}
	
	/**
	 * Column Info
	 * @param lastUpdateDate
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	/**
	 * Column Info
	 * @param eaiIfNo
	 */
	public void setEaiIfNo(String eaiIfNo) {
		this.eaiIfNo = eaiIfNo;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param creationDate
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * Column Info
	 * @param acqMth
	 */
	public void setAcqMth(String acqMth) {
		this.acqMth = acqMth;
	}
	
	/**
	 * Column Info
	 * @param lastUpdatedBy
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param bookTypeCode
	 */
	public void setBookTypeCode(String bookTypeCode) {
		this.bookTypeCode = bookTypeCode;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIfSeq(JSPUtil.getParameter(request, "if_seq", ""));
		setEqNoFm(JSPUtil.getParameter(request, "eq_no_fm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocationSegment(JSPUtil.getParameter(request, "location_segment", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setAssetType(JSPUtil.getParameter(request, "asset_type", ""));
		setInvestCd(JSPUtil.getParameter(request, "invest_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLifid(JSPUtil.getParameter(request, "lifid", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setFaIfGrpSeqNo(JSPUtil.getParameter(request, "fa_if_grp_seq_no", ""));
		setDatePlacedInService(JSPUtil.getParameter(request, "date_placed_in_service", ""));
		setCost(JSPUtil.getParameter(request, "cost", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setAttribute4(JSPUtil.getParameter(request, "attribute4", ""));
		setCreatedBy(JSPUtil.getParameter(request, "created_by", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setManufacturer(JSPUtil.getParameter(request, "manufacturer", ""));
		setAssetDescription(JSPUtil.getParameter(request, "asset_description", ""));
		setTagNumber(JSPUtil.getParameter(request, "tag_number", ""));
		setAttribute1(JSPUtil.getParameter(request, "attribute1", ""));
		setAttribute2(JSPUtil.getParameter(request, "attribute2", ""));
		setAttribute3(JSPUtil.getParameter(request, "attribute3", ""));
		setIfTtlRowKnt(JSPUtil.getParameter(request, "if_ttl_row_knt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setActAmt(JSPUtil.getParameter(request, "act_amt", ""));
		setFaIfStsCd(JSPUtil.getParameter(request, "fa_if_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, "eq_no", ""));
		setTotalCount(JSPUtil.getParameter(request, "total_count", ""));
		setEqSpecNo(JSPUtil.getParameter(request, "eq_spec_no", ""));
		setAttribute21(JSPUtil.getParameter(request, "attribute21", ""));
		setAgmt(JSPUtil.getParameter(request, "agmt", ""));
		setFaIfTpCd(JSPUtil.getParameter(request, "fa_if_tp_cd", ""));
		setEqNoTo(JSPUtil.getParameter(request, "eq_no_to", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setCategorySegment(JSPUtil.getParameter(request, "category_segment", ""));
		setDeYrmon(JSPUtil.getParameter(request, "de_yrmon", ""));
		setLastUpdateDate(JSPUtil.getParameter(request, "last_update_date", ""));
		setEaiIfNo(JSPUtil.getParameter(request, "eai_if_no", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setCreationDate(JSPUtil.getParameter(request, "creation_date", ""));
		setAcqMth(JSPUtil.getParameter(request, "acq_mth", ""));
		setLastUpdatedBy(JSPUtil.getParameter(request, "last_updated_by", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setBookTypeCode(JSPUtil.getParameter(request, "book_type_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ErpFaInterfaceMGTVO[]
	 */
	public ErpFaInterfaceMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ErpFaInterfaceMGTVO[]
	 */
	public ErpFaInterfaceMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ErpFaInterfaceMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifSeq = (JSPUtil.getParameter(request, prefix	+ "if_seq", length));
			String[] eqNoFm = (JSPUtil.getParameter(request, prefix	+ "eq_no_fm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locationSegment = (JSPUtil.getParameter(request, prefix	+ "location_segment", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] assetType = (JSPUtil.getParameter(request, prefix	+ "asset_type", length));
			String[] investCd = (JSPUtil.getParameter(request, prefix	+ "invest_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] faIfGrpSeqNo = (JSPUtil.getParameter(request, prefix	+ "fa_if_grp_seq_no", length));
			String[] datePlacedInService = (JSPUtil.getParameter(request, prefix	+ "date_placed_in_service", length));
			String[] cost = (JSPUtil.getParameter(request, prefix	+ "cost", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] attribute4 = (JSPUtil.getParameter(request, prefix	+ "attribute4", length));
			String[] createdBy = (JSPUtil.getParameter(request, prefix	+ "created_by", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] manufacturer = (JSPUtil.getParameter(request, prefix	+ "manufacturer", length));
			String[] assetDescription = (JSPUtil.getParameter(request, prefix	+ "asset_description", length));
			String[] tagNumber = (JSPUtil.getParameter(request, prefix	+ "tag_number", length));
			String[] attribute1 = (JSPUtil.getParameter(request, prefix	+ "attribute1", length));
			String[] attribute2 = (JSPUtil.getParameter(request, prefix	+ "attribute2", length));
			String[] attribute3 = (JSPUtil.getParameter(request, prefix	+ "attribute3", length));
			String[] ifTtlRowKnt = (JSPUtil.getParameter(request, prefix	+ "if_ttl_row_knt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] actAmt = (JSPUtil.getParameter(request, prefix	+ "act_amt", length));
			String[] faIfStsCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no", length));
			String[] attribute21 = (JSPUtil.getParameter(request, prefix	+ "attribute21", length));
			String[] agmt = (JSPUtil.getParameter(request, prefix	+ "agmt", length));
			String[] faIfTpCd = (JSPUtil.getParameter(request, prefix	+ "fa_if_tp_cd", length));
			String[] eqNoTo = (JSPUtil.getParameter(request, prefix	+ "eq_no_to", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] categorySegment = (JSPUtil.getParameter(request, prefix	+ "category_segment", length));
			String[] deYrmon = (JSPUtil.getParameter(request, prefix	+ "de_yrmon", length));
			String[] lastUpdateDate = (JSPUtil.getParameter(request, prefix	+ "last_update_date", length));
			String[] eaiIfNo = (JSPUtil.getParameter(request, prefix	+ "eai_if_no", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] creationDate = (JSPUtil.getParameter(request, prefix	+ "creation_date", length));
			String[] acqMth = (JSPUtil.getParameter(request, prefix	+ "acq_mth", length));
			String[] lastUpdatedBy = (JSPUtil.getParameter(request, prefix	+ "last_updated_by", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] bookTypeCode = (JSPUtil.getParameter(request, prefix	+ "book_type_code", length));
			
			for (int i = 0; i < length; i++) {
				model = new ErpFaInterfaceMGTVO();
				if (ifSeq[i] != null)
					model.setIfSeq(ifSeq[i]);
				if (eqNoFm[i] != null)
					model.setEqNoFm(eqNoFm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locationSegment[i] != null)
					model.setLocationSegment(locationSegment[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (assetType[i] != null)
					model.setAssetType(assetType[i]);
				if (investCd[i] != null)
					model.setInvestCd(investCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (faIfGrpSeqNo[i] != null)
					model.setFaIfGrpSeqNo(faIfGrpSeqNo[i]);
				if (datePlacedInService[i] != null)
					model.setDatePlacedInService(datePlacedInService[i]);
				if (cost[i] != null)
					model.setCost(cost[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (attribute4[i] != null)
					model.setAttribute4(attribute4[i]);
				if (createdBy[i] != null)
					model.setCreatedBy(createdBy[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (manufacturer[i] != null)
					model.setManufacturer(manufacturer[i]);
				if (assetDescription[i] != null)
					model.setAssetDescription(assetDescription[i]);
				if (tagNumber[i] != null)
					model.setTagNumber(tagNumber[i]);
				if (attribute1[i] != null)
					model.setAttribute1(attribute1[i]);
				if (attribute2[i] != null)
					model.setAttribute2(attribute2[i]);
				if (attribute3[i] != null)
					model.setAttribute3(attribute3[i]);
				if (ifTtlRowKnt[i] != null)
					model.setIfTtlRowKnt(ifTtlRowKnt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (actAmt[i] != null)
					model.setActAmt(actAmt[i]);
				if (faIfStsCd[i] != null)
					model.setFaIfStsCd(faIfStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				if (attribute21[i] != null)
					model.setAttribute21(attribute21[i]);
				if (agmt[i] != null)
					model.setAgmt(agmt[i]);
				if (faIfTpCd[i] != null)
					model.setFaIfTpCd(faIfTpCd[i]);
				if (eqNoTo[i] != null)
					model.setEqNoTo(eqNoTo[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (categorySegment[i] != null)
					model.setCategorySegment(categorySegment[i]);
				if (deYrmon[i] != null)
					model.setDeYrmon(deYrmon[i]);
				if (lastUpdateDate[i] != null)
					model.setLastUpdateDate(lastUpdateDate[i]);
				if (eaiIfNo[i] != null)
					model.setEaiIfNo(eaiIfNo[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (creationDate[i] != null)
					model.setCreationDate(creationDate[i]);
				if (acqMth[i] != null)
					model.setAcqMth(acqMth[i]);
				if (lastUpdatedBy[i] != null)
					model.setLastUpdatedBy(lastUpdatedBy[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (bookTypeCode[i] != null)
					model.setBookTypeCode(bookTypeCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getErpFaInterfaceMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ErpFaInterfaceMGTVO[]
	 */
	public ErpFaInterfaceMGTVO[] getErpFaInterfaceMGTVOs(){
		ErpFaInterfaceMGTVO[] vos = (ErpFaInterfaceMGTVO[])models.toArray(new ErpFaInterfaceMGTVO[models.size()]);
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
		this.ifSeq = this.ifSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoFm = this.eqNoFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationSegment = this.locationSegment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assetType = this.assetType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.investCd = this.investCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfGrpSeqNo = this.faIfGrpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datePlacedInService = this.datePlacedInService .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost = this.cost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute4 = this.attribute4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createdBy = this.createdBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manufacturer = this.manufacturer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assetDescription = this.assetDescription .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tagNumber = this.tagNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute1 = this.attribute1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute2 = this.attribute2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute3 = this.attribute3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTtlRowKnt = this.ifTtlRowKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAmt = this.actAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfStsCd = this.faIfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attribute21 = this.attribute21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt = this.agmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faIfTpCd = this.faIfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoTo = this.eqNoTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.categorySegment = this.categorySegment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon = this.deYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdateDate = this.lastUpdateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfNo = this.eaiIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creationDate = this.creationDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acqMth = this.acqMth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastUpdatedBy = this.lastUpdatedBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookTypeCode = this.bookTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
