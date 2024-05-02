/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24BlCMinfoListOBVO.java
*@FileTitle : Eur24BlCMinfoListOBVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.05
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.08.05 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24BlCMinfoListOBVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlCMinfoListOBVO> models = new ArrayList<Eur24BlCMinfoListOBVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String handleInfo = null;
	/* Column Info */
	private String cmFlag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mfItmNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String pkgCount = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmCntrNo = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String itemGrossWgt = null;
	/* Column Info */
	private String pkgType = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String handleCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String undgNo = null;
	/* Column Info */
	private String cmShipMark = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String tariffCd = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cmCntrPkg = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String pieceCount = null;
	/* Column Info */
	private String goodsDesc = null;
	/* Column Info */
	private String goodsItemNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlCMinfoListOBVO() {}

	public Eur24BlCMinfoListOBVO(String ibflag, String pagerows, String vslCd, String handleInfo, String creDt, String blNo, String pkgCount, String cmCntrNo, String measQty, String pckQty, String itemGrossWgt, String pckTpCd, String pkgType, String updUsrId, String cstmsPortCd, String handleCd, String updDt, String undgNo, String cmShipMark, String skdVoyNo, String tariffCd, String cntrMfMkDesc, String skdDirCd, String cntrCgoSeq, String creUsrId, String cmCntrPkg, String cntrNo, String cntrMfGdsDesc, String pieceCount, String goodsDesc, String goodsItemNo, String cmFlag, String mfItmNo) {
		this.vslCd = vslCd;
		this.handleInfo = handleInfo;
		this.cmFlag = cmFlag;
		this.creDt = creDt;
		this.mfItmNo = mfItmNo;
		this.blNo = blNo;
		this.pkgCount = pkgCount;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cmCntrNo = cmCntrNo;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.itemGrossWgt = itemGrossWgt;
		this.pkgType = pkgType;
		this.pckTpCd = pckTpCd;
		this.updUsrId = updUsrId;
		this.cstmsPortCd = cstmsPortCd;
		this.handleCd = handleCd;
		this.updDt = updDt;
		this.undgNo = undgNo;
		this.cmShipMark = cmShipMark;
		this.skdVoyNo = skdVoyNo;
		this.tariffCd = tariffCd;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.skdDirCd = skdDirCd;
		this.cntrCgoSeq = cntrCgoSeq;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.cmCntrPkg = cmCntrPkg;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.pieceCount = pieceCount;
		this.goodsDesc = goodsDesc;
		this.goodsItemNo = goodsItemNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("handle_info", getHandleInfo());
		this.hashColumns.put("cm_flag", getCmFlag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mf_itm_no", getMfItmNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pkg_count", getPkgCount());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_cntr_no", getCmCntrNo());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("item_gross_wgt", getItemGrossWgt());
		this.hashColumns.put("pkg_type", getPkgType());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("handle_cd", getHandleCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("undg_no", getUndgNo());
		this.hashColumns.put("cm_ship_mark", getCmShipMark());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("tariff_cd", getTariffCd());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cm_cntr_pkg", getCmCntrPkg());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("piece_count", getPieceCount());
		this.hashColumns.put("goods_desc", getGoodsDesc());
		this.hashColumns.put("goods_item_no", getGoodsItemNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("handle_info", "handleInfo");
		this.hashFields.put("cm_flag", "cmFlag");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mf_itm_no", "mfItmNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pkg_count", "pkgCount");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_cntr_no", "cmCntrNo");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("item_gross_wgt", "itemGrossWgt");
		this.hashFields.put("pkg_type", "pkgType");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("handle_cd", "handleCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("undg_no", "undgNo");
		this.hashFields.put("cm_ship_mark", "cmShipMark");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("tariff_cd", "tariffCd");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cm_cntr_pkg", "cmCntrPkg");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("piece_count", "pieceCount");
		this.hashFields.put("goods_desc", "goodsDesc");
		this.hashFields.put("goods_item_no", "goodsItemNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return handleInfo
	 */
	public String getHandleInfo() {
		return this.handleInfo;
	}
	
	/**
	 * Column Info
	 * @return cmFlag
	 */
	public String getCmFlag() {
		return this.cmFlag;
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
	 * @return mfItmNo
	 */
	public String getMfItmNo() {
		return this.mfItmNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return pkgCount
	 */
	public String getPkgCount() {
		return this.pkgCount;
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
	 * @return cmCntrNo
	 */
	public String getCmCntrNo() {
		return this.cmCntrNo;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return itemGrossWgt
	 */
	public String getItemGrossWgt() {
		return this.itemGrossWgt;
	}
	
	/**
	 * Column Info
	 * @return pkgType
	 */
	public String getPkgType() {
		return this.pkgType;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
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
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return handleCd
	 */
	public String getHandleCd() {
		return this.handleCd;
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
	 * @return undgNo
	 */
	public String getUndgNo() {
		return this.undgNo;
	}
	
	/**
	 * Column Info
	 * @return cmShipMark
	 */
	public String getCmShipMark() {
		return this.cmShipMark;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return tariffCd
	 */
	public String getTariffCd() {
		return this.tariffCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc
	 */
	public String getCntrMfMkDesc() {
		return this.cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cmCntrPkg
	 */
	public String getCmCntrPkg() {
		return this.cmCntrPkg;
	}
	
	/**
	 * Column Info
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return pieceCount
	 */
	public String getPieceCount() {
		return this.pieceCount;
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
	 * @return goodsItemNo
	 */
	public String getGoodsItemNo() {
		return this.goodsItemNo;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param handleInfo
	 */
	public void setHandleInfo(String handleInfo) {
		this.handleInfo = handleInfo;
	}
	
	/**
	 * Column Info
	 * @param cmFlag
	 */
	public void setCmFlag(String cmFlag) {
		this.cmFlag = cmFlag;
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
	 * @param mfItmNo
	 */
	public void setMfItmNo(String mfItmNo) {
		this.mfItmNo = mfItmNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param pkgCount
	 */
	public void setPkgCount(String pkgCount) {
		this.pkgCount = pkgCount;
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
	 * @param cmCntrNo
	 */
	public void setCmCntrNo(String cmCntrNo) {
		this.cmCntrNo = cmCntrNo;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param itemGrossWgt
	 */
	public void setItemGrossWgt(String itemGrossWgt) {
		this.itemGrossWgt = itemGrossWgt;
	}
	
	/**
	 * Column Info
	 * @param pkgType
	 */
	public void setPkgType(String pkgType) {
		this.pkgType = pkgType;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
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
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param handleCd
	 */
	public void setHandleCd(String handleCd) {
		this.handleCd = handleCd;
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
	 * @param undgNo
	 */
	public void setUndgNo(String undgNo) {
		this.undgNo = undgNo;
	}
	
	/**
	 * Column Info
	 * @param cmShipMark
	 */
	public void setCmShipMark(String cmShipMark) {
		this.cmShipMark = cmShipMark;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param tariffCd
	 */
	public void setTariffCd(String tariffCd) {
		this.tariffCd = tariffCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc
	 */
	public void setCntrMfMkDesc(String cntrMfMkDesc) {
		this.cntrMfMkDesc = cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cmCntrPkg
	 */
	public void setCmCntrPkg(String cmCntrPkg) {
		this.cmCntrPkg = cmCntrPkg;
	}
	
	/**
	 * Column Info
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param pieceCount
	 */
	public void setPieceCount(String pieceCount) {
		this.pieceCount = pieceCount;
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
	 * @param goodsItemNo
	 */
	public void setGoodsItemNo(String goodsItemNo) {
		this.goodsItemNo = goodsItemNo;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setHandleInfo(JSPUtil.getParameter(request, prefix + "handle_info", ""));
		setCmFlag(JSPUtil.getParameter(request, prefix + "cm_flag", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMfItmNo(JSPUtil.getParameter(request, prefix + "mf_itm_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPkgCount(JSPUtil.getParameter(request, prefix + "pkg_count", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmCntrNo(JSPUtil.getParameter(request, prefix + "cm_cntr_no", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setItemGrossWgt(JSPUtil.getParameter(request, prefix + "item_gross_wgt", ""));
		setPkgType(JSPUtil.getParameter(request, prefix + "pkg_type", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setHandleCd(JSPUtil.getParameter(request, prefix + "handle_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUndgNo(JSPUtil.getParameter(request, prefix + "undg_no", ""));
		setCmShipMark(JSPUtil.getParameter(request, prefix + "cm_ship_mark", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTariffCd(JSPUtil.getParameter(request, prefix + "tariff_cd", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCmCntrPkg(JSPUtil.getParameter(request, prefix + "cm_cntr_pkg", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setPieceCount(JSPUtil.getParameter(request, prefix + "piece_count", ""));
		setGoodsDesc(JSPUtil.getParameter(request, prefix + "goods_desc", ""));
		setGoodsItemNo(JSPUtil.getParameter(request, prefix + "goods_item_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlCMinfoListOBVO[]
	 */
	public Eur24BlCMinfoListOBVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlCMinfoListOBVO[]
	 */
	public Eur24BlCMinfoListOBVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlCMinfoListOBVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] handleInfo = (JSPUtil.getParameter(request, prefix	+ "handle_info", length));
			String[] cmFlag = (JSPUtil.getParameter(request, prefix	+ "cm_flag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mfItmNo = (JSPUtil.getParameter(request, prefix	+ "mf_itm_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pkgCount = (JSPUtil.getParameter(request, prefix	+ "pkg_count", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmCntrNo = (JSPUtil.getParameter(request, prefix	+ "cm_cntr_no", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] itemGrossWgt = (JSPUtil.getParameter(request, prefix	+ "item_gross_wgt", length));
			String[] pkgType = (JSPUtil.getParameter(request, prefix	+ "pkg_type", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] handleCd = (JSPUtil.getParameter(request, prefix	+ "handle_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] undgNo = (JSPUtil.getParameter(request, prefix	+ "undg_no", length));
			String[] cmShipMark = (JSPUtil.getParameter(request, prefix	+ "cm_ship_mark", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] tariffCd = (JSPUtil.getParameter(request, prefix	+ "tariff_cd", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cmCntrPkg = (JSPUtil.getParameter(request, prefix	+ "cm_cntr_pkg", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] pieceCount = (JSPUtil.getParameter(request, prefix	+ "piece_count", length));
			String[] goodsDesc = (JSPUtil.getParameter(request, prefix	+ "goods_desc", length));
			String[] goodsItemNo = (JSPUtil.getParameter(request, prefix	+ "goods_item_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlCMinfoListOBVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (handleInfo[i] != null)
					model.setHandleInfo(handleInfo[i]);
				if (cmFlag[i] != null)
					model.setCmFlag(cmFlag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mfItmNo[i] != null)
					model.setMfItmNo(mfItmNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pkgCount[i] != null)
					model.setPkgCount(pkgCount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmCntrNo[i] != null)
					model.setCmCntrNo(cmCntrNo[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (itemGrossWgt[i] != null)
					model.setItemGrossWgt(itemGrossWgt[i]);
				if (pkgType[i] != null)
					model.setPkgType(pkgType[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (handleCd[i] != null)
					model.setHandleCd(handleCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (undgNo[i] != null)
					model.setUndgNo(undgNo[i]);
				if (cmShipMark[i] != null)
					model.setCmShipMark(cmShipMark[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (tariffCd[i] != null)
					model.setTariffCd(tariffCd[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cmCntrPkg[i] != null)
					model.setCmCntrPkg(cmCntrPkg[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (pieceCount[i] != null)
					model.setPieceCount(pieceCount[i]);
				if (goodsDesc[i] != null)
					model.setGoodsDesc(goodsDesc[i]);
				if (goodsItemNo[i] != null)
					model.setGoodsItemNo(goodsItemNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlCMinfoListOBVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlCMinfoListOBVO[]
	 */
	public Eur24BlCMinfoListOBVO[] getEur24BlCMinfoListOBVOs(){
		Eur24BlCMinfoListOBVO[] vos = (Eur24BlCMinfoListOBVO[])models.toArray(new Eur24BlCMinfoListOBVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.handleInfo = this.handleInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmFlag = this.cmFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfItmNo = this.mfItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCount = this.pkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrNo = this.cmCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemGrossWgt = this.itemGrossWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgType = this.pkgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.handleCd = this.handleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undgNo = this.undgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmShipMark = this.cmShipMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffCd = this.tariffCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrPkg = this.cmCntrPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pieceCount = this.pieceCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsDesc = this.goodsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsItemNo = this.goodsItemNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
