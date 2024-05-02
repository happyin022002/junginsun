/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BangladeshManifestListOutboundVO.java
*@FileTitle : BangladeshManifestListOutboundVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.09
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BangladeshManifestListOutboundVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;

	private Collection<BangladeshManifestListOutboundVO> models = new ArrayList<BangladeshManifestListOutboundVO>();

	/* Column Info */
	private String slNo = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String perishCd = null;
	/* Column Info */
	private String weight = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String expDate = null;
	/* Column Info */
	private String sbDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String packNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String height = null;
	/* Column Info */
	private String shipperNm = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String seal = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String orgBlNo = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String trNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String packNat = null;
	/* Column Info */
	private String expNo = null;
	/* Column Info */
	private String trDate = null;
	/* Column Info */
	private String sbillNo = null;
	/* Column Info */
	private String un = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String offDock = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String cntrUtCd = null;
	/* Column Info */
	private String grossWgt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTz = null;
	/* Column Info */
	private String imco = null;
	/* Column Info */
	private String goodsDesc = null;
	/* Column Info */
	private String markNo = null;
	/* Column Info */
	private String hblInd = null;
	/* Column Info */
	private String cntrLocCd = null;
	/* Column Info */
	private String hblCode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BangladeshManifestListOutboundVO() {}

	public BangladeshManifestListOutboundVO(String ibflag, String pagerows, String slNo, String trNo, String trDate, String sbillNo, String sbDate, String expNo, String expDate, String podNm, String markNo, String packNo, String packNat, String goodsDesc, String grossWgt, String cntrNo, String seal, String cntrSize, String cntrType, String height, String weight, String status, String imco, String un, String vat, String cmdtCd, String offDock, String perishCd, String shipperNm, String cneeNm, String orgBlNo, String cntrTz, String polCd, String podCd, String cntrWgt, String cntrUtCd, String bkgCgoTpCd, String vslNm, String voyNo, String vvd, String creUsrId, String updUsrId, String hblInd, String cntrLocCd, String hblCode) {
		this.slNo = slNo;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.perishCd = perishCd;
		this.weight = weight;
		this.vat = vat;
		this.expDate = expDate;
		this.sbDate = sbDate;
		this.pagerows = pagerows;
		this.packNo = packNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.height = height;
		this.shipperNm = shipperNm;
		this.cmdtCd = cmdtCd;
		this.seal = seal;
		this.updUsrId = updUsrId;
		this.voyNo = voyNo;
		this.orgBlNo = orgBlNo;
		this.cntrWgt = cntrWgt;
		this.podNm = podNm;
		this.status = status;
		this.trNo = trNo;
		this.vslNm = vslNm;
		this.packNat = packNat;
		this.expNo = expNo;
		this.trDate = trDate;
		this.sbillNo = sbillNo;
		this.un = un;
		this.cntrType = cntrType;
		this.vvd = vvd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.cneeNm = cneeNm;
		this.offDock = offDock;
		this.cntrSize = cntrSize;
		this.cntrUtCd = cntrUtCd;
		this.grossWgt = grossWgt;
		this.cntrNo = cntrNo;
		this.cntrTz = cntrTz;
		this.imco = imco;
		this.goodsDesc = goodsDesc;
		this.markNo = markNo;
		this.hblInd = hblInd;
		this.cntrLocCd = cntrLocCd;
		this.hblCode = hblCode;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sl_no", getSlNo());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("perish_cd", getPerishCd());
		this.hashColumns.put("weight", getWeight());
		this.hashColumns.put("vat", getVat());
		this.hashColumns.put("exp_date", getExpDate());
		this.hashColumns.put("sb_date", getSbDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pack_no", getPackNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("height", getHeight());
		this.hashColumns.put("shipper_nm", getShipperNm());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("seal", getSeal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("org_bl_no", getOrgBlNo());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("tr_no", getTrNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("pack_nat", getPackNat());
		this.hashColumns.put("exp_no", getExpNo());
		this.hashColumns.put("tr_date", getTrDate());
		this.hashColumns.put("sbill_no", getSbillNo());
		this.hashColumns.put("un", getUn());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("off_dock", getOffDock());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("cntr_ut_cd", getCntrUtCd());
		this.hashColumns.put("gross_wgt", getGrossWgt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tz", getCntrTz());
		this.hashColumns.put("imco", getImco());
		this.hashColumns.put("goods_desc", getGoodsDesc());
		this.hashColumns.put("mark_no", getMarkNo());
		this.hashColumns.put("hbl_ind", getHblInd());
		this.hashColumns.put("cntr_loc_cd", getCntrLocCd());
		this.hashColumns.put("hbl_code", getHblCode());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sl_no", "slNo");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("perish_cd", "perishCd");
		this.hashFields.put("weight", "weight");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("exp_date", "expDate");
		this.hashFields.put("sb_date", "sbDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pack_no", "packNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("height", "height");
		this.hashFields.put("shipper_nm", "shipperNm");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("seal", "seal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("org_bl_no", "orgBlNo");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("status", "status");
		this.hashFields.put("tr_no", "trNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("pack_nat", "packNat");
		this.hashFields.put("exp_no", "expNo");
		this.hashFields.put("tr_date", "trDate");
		this.hashFields.put("sbill_no", "sbillNo");
		this.hashFields.put("un", "un");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("off_dock", "offDock");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("cntr_ut_cd", "cntrUtCd");
		this.hashFields.put("gross_wgt", "grossWgt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tz", "cntrTz");
		this.hashFields.put("imco", "imco");
		this.hashFields.put("goods_desc", "goodsDesc");
		this.hashFields.put("mark_no", "markNo");
		this.hashFields.put("hbl_ind", "hblInd");
		this.hashFields.put("cntr_loc_cd", "cntrLocCd");
		this.hashFields.put("hbl_code", "hblCode");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return slNo
	 */
	public String getSlNo() {
		return this.slNo;
	}

	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @return perishCd
	 */
	public String getPerishCd() {
		return this.perishCd;
	}

	/**
	 * Column Info
	 * @return weight
	 */
	public String getWeight() {
		return this.weight;
	}

	/**
	 * Column Info
	 * @return vat
	 */
	public String getVat() {
		return this.vat;
	}

	/**
	 * Column Info
	 * @return expDate
	 */
	public String getExpDate() {
		return this.expDate;
	}

	/**
	 * Column Info
	 * @return sbDate
	 */
	public String getSbDate() {
		return this.sbDate;
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
	 * @return packNo
	 */
	public String getPackNo() {
		return this.packNo;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return height
	 */
	public String getHeight() {
		return this.height;
	}

	/**
	 * Column Info
	 * @return shipperNm
	 */
	public String getShipperNm() {
		return this.shipperNm;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return seal
	 */
	public String getSeal() {
		return this.seal;
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
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}

	/**
	 * Column Info
	 * @return orgBlNo
	 */
	public String getOrgBlNo() {
		return this.orgBlNo;
	}

	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}

	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}

	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Column Info
	 * @return trNo
	 */
	public String getTrNo() {
		return this.trNo;
	}

	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}

	/**
	 * Column Info
	 * @return packNat
	 */
	public String getPackNat() {
		return this.packNat;
	}

	/**
	 * Column Info
	 * @return expNo
	 */
	public String getExpNo() {
		return this.expNo;
	}

	/**
	 * Column Info
	 * @return trDate
	 */
	public String getTrDate() {
		return this.trDate;
	}

	/**
	 * Column Info
	 * @return sbillNo
	 */
	public String getSbillNo() {
		return this.sbillNo;
	}

	/**
	 * Column Info
	 * @return un
	 */
	public String getUn() {
		return this.un;
	}

	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
	}

	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}

	/**
	 * Column Info
	 * @return offDock
	 */
	public String getOffDock() {
		return this.offDock;
	}

	/**
	 * Column Info
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
	}

	/**
	 * Column Info
	 * @return cntrUtCd
	 */
	public String getCntrUtCd() {
		return this.cntrUtCd;
	}

	/**
	 * Column Info
	 * @return grossWgt
	 */
	public String getGrossWgt() {
		return this.grossWgt;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return cntrTz
	 */
	public String getCntrTz() {
		return this.cntrTz;
	}

	/**
	 * Column Info
	 * @return imco
	 */
	public String getImco() {
		return this.imco;
	}

	/**
	 * Column Info
	 * @return goodsDesc
	 */
	public String getGoodsDesc() {
		return this.goodsDesc;
	}

	/**
	 * Column Info
	 * @return markNo
	 */
	public String getMarkNo() {
		return this.markNo;
	}

	/**
	 * Column Info
	 * @return hblInd
	 */
	public String getHblInd() {
		return this.hblInd;
	}
	
	/**
	 * Column Info
	 * @return cntrLocCd
	 */
	public String getCntrLocCd() {
		return this.cntrLocCd;
	}
	
	/**
	 * Column Info
	 * @return hblCode
	 */
	public String getHblCode() {
		return this.hblCode;
	}
	
	/**
	 * Column Info
	 * @param slNo
	 */
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}

	/**
	 * Column Info
	 * @param perishCd
	 */
	public void setPerishCd(String perishCd) {
		this.perishCd = perishCd;
	}

	/**
	 * Column Info
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * Column Info
	 * @param vat
	 */
	public void setVat(String vat) {
		this.vat = vat;
	}

	/**
	 * Column Info
	 * @param expDate
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	/**
	 * Column Info
	 * @param sbDate
	 */
	public void setSbDate(String sbDate) {
		this.sbDate = sbDate;
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
	 * @param packNo
	 */
	public void setPackNo(String packNo) {
		this.packNo = packNo;
	}

	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param height
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Column Info
	 * @param shipperNm
	 */
	public void setShipperNm(String shipperNm) {
		this.shipperNm = shipperNm;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * @param seal
	 */
	public void setSeal(String seal) {
		this.seal = seal;
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
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}

	/**
	 * Column Info
	 * @param orgBlNo
	 */
	public void setOrgBlNo(String orgBlNo) {
		this.orgBlNo = orgBlNo;
	}

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}

	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}

	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Column Info
	 * @param trNo
	 */
	public void setTrNo(String trNo) {
		this.trNo = trNo;
	}

	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}

	/**
	 * Column Info
	 * @param packNat
	 */
	public void setPackNat(String packNat) {
		this.packNat = packNat;
	}

	/**
	 * Column Info
	 * @param expNo
	 */
	public void setExpNo(String expNo) {
		this.expNo = expNo;
	}

	/**
	 * Column Info
	 * @param trDate
	 */
	public void setTrDate(String trDate) {
		this.trDate = trDate;
	}

	/**
	 * Column Info
	 * @param sbillNo
	 */
	public void setSbillNo(String sbillNo) {
		this.sbillNo = sbillNo;
	}

	/**
	 * Column Info
	 * @param un
	 */
	public void setUn(String un) {
		this.un = un;
	}

	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}

	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}

	/**
	 * Column Info
	 * @param offDock
	 */
	public void setOffDock(String offDock) {
		this.offDock = offDock;
	}

	/**
	 * Column Info
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
	}

	/**
	 * Column Info
	 * @param cntrUtCd
	 */
	public void setCntrUtCd(String cntrUtCd) {
		this.cntrUtCd = cntrUtCd;
	}

	/**
	 * Column Info
	 * @param grossWgt
	 */
	public void setGrossWgt(String grossWgt) {
		this.grossWgt = grossWgt;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param cntrTz
	 */
	public void setCntrTz(String cntrTz) {
		this.cntrTz = cntrTz;
	}

	/**
	 * Column Info
	 * @param imco
	 */
	public void setImco(String imco) {
		this.imco = imco;
	}

	/**
	 * Column Info
	 * @param goodsDesc
	 */
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	/**
	 * Column Info
	 * @param markNo
	 */
	public void setMarkNo(String markNo) {
		this.markNo = markNo;
	}
	
	/**
	 * Column Info
	 * @param hblInd
	 */
	public void setHblInd(String hblInd) {
		this.hblInd = hblInd;
	}
	
	/**
	 * Column Info
	 * @param cntrLocCd
	 */
	public void setCntrLocCd(String cntrLocCd) {
		this.cntrLocCd = cntrLocCd;
	}
	
	/**
	 * Column Info
	 * @param hblCode
	 */
	public void setHblCode(String hblCode) {
		this.hblCode = hblCode;
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
		setSlNo(JSPUtil.getParameter(request, prefix + "sl_no", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setPerishCd(JSPUtil.getParameter(request, prefix + "perish_cd", ""));
		setWeight(JSPUtil.getParameter(request, prefix + "weight", ""));
		setVat(JSPUtil.getParameter(request, prefix + "vat", ""));
		setExpDate(JSPUtil.getParameter(request, prefix + "exp_date", ""));
		setSbDate(JSPUtil.getParameter(request, prefix + "sb_date", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPackNo(JSPUtil.getParameter(request, prefix + "pack_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHeight(JSPUtil.getParameter(request, prefix + "height", ""));
		setShipperNm(JSPUtil.getParameter(request, prefix + "shipper_nm", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setSeal(JSPUtil.getParameter(request, prefix + "seal", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
		setOrgBlNo(JSPUtil.getParameter(request, prefix + "org_bl_no", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setTrNo(JSPUtil.getParameter(request, prefix + "tr_no", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setPackNat(JSPUtil.getParameter(request, prefix + "pack_nat", ""));
		setExpNo(JSPUtil.getParameter(request, prefix + "exp_no", ""));
		setTrDate(JSPUtil.getParameter(request, prefix + "tr_date", ""));
		setSbillNo(JSPUtil.getParameter(request, prefix + "sbill_no", ""));
		setUn(JSPUtil.getParameter(request, prefix + "un", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setOffDock(JSPUtil.getParameter(request, prefix + "off_dock", ""));
		setCntrSize(JSPUtil.getParameter(request, prefix + "cntr_size", ""));
		setCntrUtCd(JSPUtil.getParameter(request, prefix + "cntr_ut_cd", ""));
		setGrossWgt(JSPUtil.getParameter(request, prefix + "gross_wgt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTz(JSPUtil.getParameter(request, prefix + "cntr_tz", ""));
		setImco(JSPUtil.getParameter(request, prefix + "imco", ""));
		setGoodsDesc(JSPUtil.getParameter(request, prefix + "goods_desc", ""));
		setMarkNo(JSPUtil.getParameter(request, prefix + "mark_no", ""));
		setHblInd(JSPUtil.getParameter(request, prefix + "hbl_ind", ""));
		setCntrLocCd(JSPUtil.getParameter(request, prefix + "cntr_loc_cd", ""));
		setHblCode(JSPUtil.getParameter(request, prefix + "hbl_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BangladeshManifestListOutboundVO[]
	 */
	public BangladeshManifestListOutboundVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BangladeshManifestListOutboundVO[]
	 */
	public BangladeshManifestListOutboundVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BangladeshManifestListOutboundVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] slNo = (JSPUtil.getParameter(request, prefix	+ "sl_no", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] perishCd = (JSPUtil.getParameter(request, prefix	+ "perish_cd", length));
			String[] weight = (JSPUtil.getParameter(request, prefix	+ "weight", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat", length));
			String[] expDate = (JSPUtil.getParameter(request, prefix	+ "exp_date", length));
			String[] sbDate = (JSPUtil.getParameter(request, prefix	+ "sb_date", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] packNo = (JSPUtil.getParameter(request, prefix	+ "pack_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] height = (JSPUtil.getParameter(request, prefix	+ "height", length));
			String[] shipperNm = (JSPUtil.getParameter(request, prefix	+ "shipper_nm", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] seal = (JSPUtil.getParameter(request, prefix	+ "seal", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] orgBlNo = (JSPUtil.getParameter(request, prefix	+ "org_bl_no", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] trNo = (JSPUtil.getParameter(request, prefix	+ "tr_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] packNat = (JSPUtil.getParameter(request, prefix	+ "pack_nat", length));
			String[] expNo = (JSPUtil.getParameter(request, prefix	+ "exp_no", length));
			String[] trDate = (JSPUtil.getParameter(request, prefix	+ "tr_date", length));
			String[] sbillNo = (JSPUtil.getParameter(request, prefix	+ "sbill_no", length));
			String[] un = (JSPUtil.getParameter(request, prefix	+ "un", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] offDock = (JSPUtil.getParameter(request, prefix	+ "off_dock", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] cntrUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ut_cd", length));
			String[] grossWgt = (JSPUtil.getParameter(request, prefix	+ "gross_wgt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTz = (JSPUtil.getParameter(request, prefix	+ "cntr_tz", length));
			String[] imco = (JSPUtil.getParameter(request, prefix	+ "imco", length));
			String[] goodsDesc = (JSPUtil.getParameter(request, prefix	+ "goods_desc", length));
			String[] markNo = (JSPUtil.getParameter(request, prefix	+ "mark_no", length));
			String[] hblInd = (JSPUtil.getParameter(request, prefix	+ "hbl_ind", length));
			String[] cntrLocCd = (JSPUtil.getParameter(request, prefix	+ "cntr_loc_cd", length));
			String[] hblCode = (JSPUtil.getParameter(request, prefix	+ "hbl_code", length));

			for (int i = 0; i < length; i++) {
				model = new BangladeshManifestListOutboundVO();
				if (slNo[i] != null)
					model.setSlNo(slNo[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (perishCd[i] != null)
					model.setPerishCd(perishCd[i]);
				if (weight[i] != null)
					model.setWeight(weight[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (expDate[i] != null)
					model.setExpDate(expDate[i]);
				if (sbDate[i] != null)
					model.setSbDate(sbDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (packNo[i] != null)
					model.setPackNo(packNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (height[i] != null)
					model.setHeight(height[i]);
				if (shipperNm[i] != null)
					model.setShipperNm(shipperNm[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (seal[i] != null)
					model.setSeal(seal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (orgBlNo[i] != null)
					model.setOrgBlNo(orgBlNo[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (trNo[i] != null)
					model.setTrNo(trNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (packNat[i] != null)
					model.setPackNat(packNat[i]);
				if (expNo[i] != null)
					model.setExpNo(expNo[i]);
				if (trDate[i] != null)
					model.setTrDate(trDate[i]);
				if (sbillNo[i] != null)
					model.setSbillNo(sbillNo[i]);
				if (un[i] != null)
					model.setUn(un[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (offDock[i] != null)
					model.setOffDock(offDock[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (cntrUtCd[i] != null)
					model.setCntrUtCd(cntrUtCd[i]);
				if (grossWgt[i] != null)
					model.setGrossWgt(grossWgt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTz[i] != null)
					model.setCntrTz(cntrTz[i]);
				if (imco[i] != null)
					model.setImco(imco[i]);
				if (goodsDesc[i] != null)
					model.setGoodsDesc(goodsDesc[i]);
				if (markNo[i] != null)
					model.setMarkNo(markNo[i]);
				if (hblInd[i] != null)
					model.setHblInd(hblInd[i]);
				if (cntrLocCd[i] != null)
					model.setCntrLocCd(cntrLocCd[i]);
				if (hblCode[i] != null)
					model.setHblCode(hblCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBangladeshManifestListOutboundVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BangladeshManifestListOutboundVO[]
	 */
	public BangladeshManifestListOutboundVO[] getBangladeshManifestListOutboundVOs(){
		BangladeshManifestListOutboundVO[] vos = (BangladeshManifestListOutboundVO[])models.toArray(new BangladeshManifestListOutboundVO[models.size()]);
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
		this.slNo = this.slNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perishCd = this.perishCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.weight = this.weight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDate = this.expDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbDate = this.sbDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packNo = this.packNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.height = this.height .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperNm = this.shipperNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seal = this.seal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBlNo = this.orgBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trNo = this.trNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.packNat = this.packNat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expNo = this.expNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trDate = this.trDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sbillNo = this.sbillNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.un = this.un .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDock = this.offDock .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUtCd = this.cntrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossWgt = this.grossWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTz = this.cntrTz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imco = this.imco .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsDesc = this.goodsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.markNo = this.markNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblInd = this.hblInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLocCd = this.cntrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCode = this.hblCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
