/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BangladeshManifestListInboundVO.java
*@FileTitle : BangladeshManifestListInboundVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier :
*@LastVersion : 1.0
* 2011.08.11
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

public class BangladeshManifestListInboundVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;

	private Collection<BangladeshManifestListInboundVO> models = new ArrayList<BangladeshManifestListInboundVO>();

	/* Column Info */
	private String cntrTpszIsoCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String perishCd = null;
	/* Column Info */
	private String notyNm = null;
	/* Column Info */
	private String marks = null;
	/* Column Info */
	private String vat = null;
	/* Column Info */
	private String remarks = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blNetWgt = null;
	/* Column Info */
	private String height = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String seal = null;
	/* Column Info */
	private String consNm = null;
	/* Column Info */
	private String description = null;
	/* Column Info */
	private String notyLice = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String orgBlNo = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String lineNo = null;
	/* Column Info */
	private String consLice = null;
	/* Column Info */
	private String cntrGrossWgt = null;
	/* Column Info */
	private String un = null;
	/* Column Info */
	private String blGrossWgt = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String offDock = null;
	/* Column Info */
	private String goodsDate = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String cntrUtCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTareWgt = null;
	/* Column Info */
	private String cntrTz = null;
	/* Column Info */
	private String temp = null;
	/* Column Info */
	private String imco = null;
	/* Column Info */
	private String goodsDesc = null;
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

	public BangladeshManifestListInboundVO() {}

	public BangladeshManifestListInboundVO(String ibflag, String pagerows, String lineNo, String blNo, String qty, String description, String marks, String goodsDesc, String goodsDate, String consLice, String consNm, String notyLice, String notyNm, String blGrossWgt, String blNetWgt, String cntrNo, String seal, String cntrSize, String cntrType, String height, String cntrGrossWgt, String cntrTareWgt, String status, String imco, String un, String vat, String cmdtCd, String offDock, String perishCd, String remarks, String orgBlNo, String cntrTz, String polCd, String podCd, String cntrWgt, String cntrUtCd, String bkgCgoTpCd, String vslNm, String voyNo, String temp, String vvd, String creUsrId, String updUsrId, String cntrTpszIsoCd, String hblInd, String cntrLocCd, String hblCode) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.perishCd = perishCd;
		this.notyNm = notyNm;
		this.marks = marks;
		this.vat = vat;
		this.remarks = remarks;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.blNetWgt = blNetWgt;
		this.height = height;
		this.cmdtCd = cmdtCd;
		this.seal = seal;
		this.consNm = consNm;
		this.description = description;
		this.notyLice = notyLice;
		this.updUsrId = updUsrId;
		this.voyNo = voyNo;
		this.orgBlNo = orgBlNo;
		this.cntrWgt = cntrWgt;
		this.status = status;
		this.vslNm = vslNm;
		this.qty = qty;
		this.lineNo = lineNo;
		this.consLice = consLice;
		this.cntrGrossWgt = cntrGrossWgt;
		this.un = un;
		this.blGrossWgt = blGrossWgt;
		this.cntrType = cntrType;
		this.vvd = vvd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.offDock = offDock;
		this.goodsDate = goodsDate;
		this.cntrSize = cntrSize;
		this.cntrUtCd = cntrUtCd;
		this.cntrNo = cntrNo;
		this.cntrTareWgt = cntrTareWgt;
		this.cntrTz = cntrTz;
		this.temp = temp;
		this.imco = imco;
		this.goodsDesc = goodsDesc;
		this.hblInd = hblInd;
		this.cntrLocCd = cntrLocCd;
		this.hblCode = hblCode;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("perish_cd", getPerishCd());
		this.hashColumns.put("noty_nm", getNotyNm());
		this.hashColumns.put("marks", getMarks());
		this.hashColumns.put("vat", getVat());
		this.hashColumns.put("remarks", getRemarks());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_net_wgt", getBlNetWgt());
		this.hashColumns.put("height", getHeight());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("seal", getSeal());
		this.hashColumns.put("cons_nm", getConsNm());
		this.hashColumns.put("description", getDescription());
		this.hashColumns.put("noty_lice", getNotyLice());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("org_bl_no", getOrgBlNo());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("line_no", getLineNo());
		this.hashColumns.put("cons_lice", getConsLice());
		this.hashColumns.put("cntr_gross_wgt", getCntrGrossWgt());
		this.hashColumns.put("un", getUn());
		this.hashColumns.put("bl_gross_wgt", getBlGrossWgt());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("off_dock", getOffDock());
		this.hashColumns.put("goods_date", getGoodsDate());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("cntr_ut_cd", getCntrUtCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tare_wgt", getCntrTareWgt());
		this.hashColumns.put("cntr_tz", getCntrTz());
		this.hashColumns.put("temp", getTemp());
		this.hashColumns.put("imco", getImco());
		this.hashColumns.put("goods_desc", getGoodsDesc());
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
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("perish_cd", "perishCd");
		this.hashFields.put("noty_nm", "notyNm");
		this.hashFields.put("marks", "marks");
		this.hashFields.put("vat", "vat");
		this.hashFields.put("remarks", "remarks");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_net_wgt", "blNetWgt");
		this.hashFields.put("height", "height");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("seal", "seal");
		this.hashFields.put("cons_nm", "consNm");
		this.hashFields.put("description", "description");
		this.hashFields.put("noty_lice", "notyLice");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("org_bl_no", "orgBlNo");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("status", "status");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("line_no", "lineNo");
		this.hashFields.put("cons_lice", "consLice");
		this.hashFields.put("cntr_gross_wgt", "cntrGrossWgt");
		this.hashFields.put("un", "un");
		this.hashFields.put("bl_gross_wgt", "blGrossWgt");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("off_dock", "offDock");
		this.hashFields.put("goods_date", "goodsDate");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("cntr_ut_cd", "cntrUtCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tare_wgt", "cntrTareWgt");
		this.hashFields.put("cntr_tz", "cntrTz");
		this.hashFields.put("temp", "temp");
		this.hashFields.put("imco", "imco");
		this.hashFields.put("goods_desc", "goodsDesc");
		this.hashFields.put("hbl_ind", "hblInd");
		this.hashFields.put("cntr_loc_cd", "cntrLocCd");
		this.hashFields.put("hbl_code", "hblCode");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrTpszIsoCd
	 */
	public String getCntrTpszIsoCd() {
		return this.cntrTpszIsoCd;
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
	 * @return notyNm
	 */
	public String getNotyNm() {
		return this.notyNm;
	}

	/**
	 * Column Info
	 * @return marks
	 */
	public String getMarks() {
		return this.marks;
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
	 * @return remarks
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return blNetWgt
	 */
	public String getBlNetWgt() {
		return this.blNetWgt;
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
	 * @return consNm
	 */
	public String getConsNm() {
		return this.consNm;
	}

	/**
	 * Column Info
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Column Info
	 * @return notyLice
	 */
	public String getNotyLice() {
		return this.notyLice;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
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
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}

	/**
	 * Column Info
	 * @return lineNo
	 */
	public String getLineNo() {
		return this.lineNo;
	}

	/**
	 * Column Info
	 * @return consLice
	 */
	public String getConsLice() {
		return this.consLice;
	}

	/**
	 * Column Info
	 * @return cntrGrossWgt
	 */
	public String getCntrGrossWgt() {
		return this.cntrGrossWgt;
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
	 * @return blGrossWgt
	 */
	public String getBlGrossWgt() {
		return this.blGrossWgt;
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
	 * @return offDock
	 */
	public String getOffDock() {
		return this.offDock;
	}

	/**
	 * Column Info
	 * @return goodsDate
	 */
	public String getGoodsDate() {
		return this.goodsDate;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return cntrTareWgt
	 */
	public String getCntrTareWgt() {
		return this.cntrTareWgt;
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
	 * @return temp
	 */
	public String getTemp() {
		return this.temp;
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
	 * @param cntrTpszIsoCd
	 */
	public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
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
	 * @param notyNm
	 */
	public void setNotyNm(String notyNm) {
		this.notyNm = notyNm;
	}

	/**
	 * Column Info
	 * @param marks
	 */
	public void setMarks(String marks) {
		this.marks = marks;
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
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param blNetWgt
	 */
	public void setBlNetWgt(String blNetWgt) {
		this.blNetWgt = blNetWgt;
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
	 * @param consNm
	 */
	public void setConsNm(String consNm) {
		this.consNm = consNm;
	}

	/**
	 * Column Info
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Column Info
	 * @param notyLice
	 */
	public void setNotyLice(String notyLice) {
		this.notyLice = notyLice;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}

	/**
	 * Column Info
	 * @param lineNo
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	/**
	 * Column Info
	 * @param consLice
	 */
	public void setConsLice(String consLice) {
		this.consLice = consLice;
	}

	/**
	 * Column Info
	 * @param cntrGrossWgt
	 */
	public void setCntrGrossWgt(String cntrGrossWgt) {
		this.cntrGrossWgt = cntrGrossWgt;
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
	 * @param blGrossWgt
	 */
	public void setBlGrossWgt(String blGrossWgt) {
		this.blGrossWgt = blGrossWgt;
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
	 * @param offDock
	 */
	public void setOffDock(String offDock) {
		this.offDock = offDock;
	}

	/**
	 * Column Info
	 * @param goodsDate
	 */
	public void setGoodsDate(String goodsDate) {
		this.goodsDate = goodsDate;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param cntrTareWgt
	 */
	public void setCntrTareWgt(String cntrTareWgt) {
		this.cntrTareWgt = cntrTareWgt;
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
	 * @param temp
	 */
	public void setTemp(String temp) {
		this.temp = temp;
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
		setCntrTpszIsoCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setPerishCd(JSPUtil.getParameter(request, prefix + "perish_cd", ""));
		setNotyNm(JSPUtil.getParameter(request, prefix + "noty_nm", ""));
		setMarks(JSPUtil.getParameter(request, prefix + "marks", ""));
		setVat(JSPUtil.getParameter(request, prefix + "vat", ""));
		setRemarks(JSPUtil.getParameter(request, prefix + "remarks", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlNetWgt(JSPUtil.getParameter(request, prefix + "bl_net_wgt", ""));
		setHeight(JSPUtil.getParameter(request, prefix + "height", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setSeal(JSPUtil.getParameter(request, prefix + "seal", ""));
		setConsNm(JSPUtil.getParameter(request, prefix + "cons_nm", ""));
		setDescription(JSPUtil.getParameter(request, prefix + "description", ""));
		setNotyLice(JSPUtil.getParameter(request, prefix + "noty_lice", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setVoyNo(JSPUtil.getParameter(request, prefix + "voy_no", ""));
		setOrgBlNo(JSPUtil.getParameter(request, prefix + "org_bl_no", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setLineNo(JSPUtil.getParameter(request, prefix + "line_no", ""));
		setConsLice(JSPUtil.getParameter(request, prefix + "cons_lice", ""));
		setCntrGrossWgt(JSPUtil.getParameter(request, prefix + "cntr_gross_wgt", ""));
		setUn(JSPUtil.getParameter(request, prefix + "un", ""));
		setBlGrossWgt(JSPUtil.getParameter(request, prefix + "bl_gross_wgt", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOffDock(JSPUtil.getParameter(request, prefix + "off_dock", ""));
		setGoodsDate(JSPUtil.getParameter(request, prefix + "goods_date", ""));
		setCntrSize(JSPUtil.getParameter(request, prefix + "cntr_size", ""));
		setCntrUtCd(JSPUtil.getParameter(request, prefix + "cntr_ut_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTareWgt(JSPUtil.getParameter(request, prefix + "cntr_tare_wgt", ""));
		setCntrTz(JSPUtil.getParameter(request, prefix + "cntr_tz", ""));
		setTemp(JSPUtil.getParameter(request, prefix + "temp", ""));
		setImco(JSPUtil.getParameter(request, prefix + "imco", ""));
		setGoodsDesc(JSPUtil.getParameter(request, prefix + "goods_desc", ""));
		setHblInd(JSPUtil.getParameter(request, prefix + "hbl_ind", ""));
		setCntrLocCd(JSPUtil.getParameter(request, prefix + "cntr_loc_cd", ""));
		setHblCode(JSPUtil.getParameter(request, prefix + "hbl_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BangladeshManifestListInboundVO[]
	 */
	public BangladeshManifestListInboundVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BangladeshManifestListInboundVO[]
	 */
	public BangladeshManifestListInboundVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BangladeshManifestListInboundVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_iso_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] perishCd = (JSPUtil.getParameter(request, prefix	+ "perish_cd", length));
			String[] notyNm = (JSPUtil.getParameter(request, prefix	+ "noty_nm", length));
			String[] marks = (JSPUtil.getParameter(request, prefix	+ "marks", length));
			String[] vat = (JSPUtil.getParameter(request, prefix	+ "vat", length));
			String[] remarks = (JSPUtil.getParameter(request, prefix	+ "remarks", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blNetWgt = (JSPUtil.getParameter(request, prefix	+ "bl_net_wgt", length));
			String[] height = (JSPUtil.getParameter(request, prefix	+ "height", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] seal = (JSPUtil.getParameter(request, prefix	+ "seal", length));
			String[] consNm = (JSPUtil.getParameter(request, prefix	+ "cons_nm", length));
			String[] description = (JSPUtil.getParameter(request, prefix	+ "description", length));
			String[] notyLice = (JSPUtil.getParameter(request, prefix	+ "noty_lice", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] orgBlNo = (JSPUtil.getParameter(request, prefix	+ "org_bl_no", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] lineNo = (JSPUtil.getParameter(request, prefix	+ "line_no", length));
			String[] consLice = (JSPUtil.getParameter(request, prefix	+ "cons_lice", length));
			String[] cntrGrossWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_gross_wgt", length));
			String[] un = (JSPUtil.getParameter(request, prefix	+ "un", length));
			String[] blGrossWgt = (JSPUtil.getParameter(request, prefix	+ "bl_gross_wgt", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] offDock = (JSPUtil.getParameter(request, prefix	+ "off_dock", length));
			String[] goodsDate = (JSPUtil.getParameter(request, prefix	+ "goods_date", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] cntrUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_ut_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTareWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_tare_wgt", length));
			String[] cntrTz = (JSPUtil.getParameter(request, prefix	+ "cntr_tz", length));
			String[] temp = (JSPUtil.getParameter(request, prefix	+ "temp", length));
			String[] imco = (JSPUtil.getParameter(request, prefix	+ "imco", length));
			String[] goodsDesc = (JSPUtil.getParameter(request, prefix	+ "goods_desc", length));
			String[] hblInd = (JSPUtil.getParameter(request, prefix	+ "hbl_ind", length));
			String[] cntrLocCd = (JSPUtil.getParameter(request, prefix	+ "cntr_loc_cd", length));
			String[] hblCode = (JSPUtil.getParameter(request, prefix	+ "hbl_code", length));

			for (int i = 0; i < length; i++) {
				model = new BangladeshManifestListInboundVO();
				if (cntrTpszIsoCd[i] != null)
					model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (perishCd[i] != null)
					model.setPerishCd(perishCd[i]);
				if (notyNm[i] != null)
					model.setNotyNm(notyNm[i]);
				if (marks[i] != null)
					model.setMarks(marks[i]);
				if (vat[i] != null)
					model.setVat(vat[i]);
				if (remarks[i] != null)
					model.setRemarks(remarks[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blNetWgt[i] != null)
					model.setBlNetWgt(blNetWgt[i]);
				if (height[i] != null)
					model.setHeight(height[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (seal[i] != null)
					model.setSeal(seal[i]);
				if (consNm[i] != null)
					model.setConsNm(consNm[i]);
				if (description[i] != null)
					model.setDescription(description[i]);
				if (notyLice[i] != null)
					model.setNotyLice(notyLice[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (orgBlNo[i] != null)
					model.setOrgBlNo(orgBlNo[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (lineNo[i] != null)
					model.setLineNo(lineNo[i]);
				if (consLice[i] != null)
					model.setConsLice(consLice[i]);
				if (cntrGrossWgt[i] != null)
					model.setCntrGrossWgt(cntrGrossWgt[i]);
				if (un[i] != null)
					model.setUn(un[i]);
				if (blGrossWgt[i] != null)
					model.setBlGrossWgt(blGrossWgt[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (offDock[i] != null)
					model.setOffDock(offDock[i]);
				if (goodsDate[i] != null)
					model.setGoodsDate(goodsDate[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (cntrUtCd[i] != null)
					model.setCntrUtCd(cntrUtCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTareWgt[i] != null)
					model.setCntrTareWgt(cntrTareWgt[i]);
				if (cntrTz[i] != null)
					model.setCntrTz(cntrTz[i]);
				if (temp[i] != null)
					model.setTemp(temp[i]);
				if (imco[i] != null)
					model.setImco(imco[i]);
				if (goodsDesc[i] != null)
					model.setGoodsDesc(goodsDesc[i]);
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
		return getBangladeshManifestListInboundVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BangladeshManifestListInboundVO[]
	 */
	public BangladeshManifestListInboundVO[] getBangladeshManifestListInboundVOs(){
		BangladeshManifestListInboundVO[] vos = (BangladeshManifestListInboundVO[])models.toArray(new BangladeshManifestListInboundVO[models.size()]);
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
		this.cntrTpszIsoCd = this.cntrTpszIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perishCd = this.perishCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notyNm = this.notyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marks = this.marks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vat = this.vat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarks = this.remarks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNetWgt = this.blNetWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.height = this.height .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seal = this.seal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consNm = this.consNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description = this.description .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notyLice = this.notyLice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBlNo = this.orgBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineNo = this.lineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consLice = this.consLice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrossWgt = this.cntrGrossWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.un = this.un .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blGrossWgt = this.blGrossWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offDock = this.offDock .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsDate = this.goodsDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUtCd = this.cntrUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTareWgt = this.cntrTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTz = this.cntrTz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.temp = this.temp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imco = this.imco .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsDesc = this.goodsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblInd = this.hblInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLocCd = this.cntrLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCode = this.hblCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
