/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : searchBlCMinfoVO.java
*@FileTitle : searchBlCMinfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.20 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.vo;

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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchBlCMinfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchBlCMinfoVO> models = new ArrayList<searchBlCMinfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String handleInfo = null;
	/* Column Info */
	private String cmFlag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String pkgCount = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cmCntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String itemGrossWgt = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String pkgType = null;
	/* Column Info */
	private String updUsrId = null;
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
	private String creUsrId = null;
	/* Column Info */
	private String cmCntrPkg = null;
	/* Column Info */
	private String cntrNo = null;
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
	
	public searchBlCMinfoVO() {}

	public searchBlCMinfoVO(String ibflag, String pagerows, String goodsItemNo, String cmFlag, String pieceCount, String pkgCount, String pkgType, String goodsDesc, String itemGrossWgt, String tariffCd, String undgNo, String handleCd, String handleInfo, String cmCntrNo, String cmCntrPkg, String cmShipMark, String vslCd, String skdVoyNo, String skdDirCd, String blNo, String polCd, String cntrNo, String cntrMfSeq, String pckQty, String cntrMfMkDesc, String cntrMfGdsDesc, String pckTpCd, String measQty, String cntrMfWgt, String wgtUtCd, String measUtCd, String cmdtHsCd, String dcgoSeq, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.handleInfo = handleInfo;
		this.cmFlag = cmFlag;
		this.creDt = creDt;
		this.dcgoSeq = dcgoSeq;
		this.cntrMfWgt = cntrMfWgt;
		this.blNo = blNo;
		this.cntrMfSeq = cntrMfSeq;
		this.pkgCount = pkgCount;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cmCntrNo = cmCntrNo;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.itemGrossWgt = itemGrossWgt;
		this.cmdtHsCd = cmdtHsCd;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.pkgType = pkgType;
		this.updUsrId = updUsrId;
		this.handleCd = handleCd;
		this.updDt = updDt;
		this.undgNo = undgNo;
		this.cmShipMark = cmShipMark;
		this.skdVoyNo = skdVoyNo;
		this.tariffCd = tariffCd;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.cmCntrPkg = cmCntrPkg;
		this.cntrNo = cntrNo;
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
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("pkg_count", getPkgCount());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cm_cntr_no", getCmCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("item_gross_wgt", getItemGrossWgt());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("pkg_type", getPkgType());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("handle_cd", getHandleCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("undg_no", getUndgNo());
		this.hashColumns.put("cm_ship_mark", getCmShipMark());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("tariff_cd", getTariffCd());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cm_cntr_pkg", getCmCntrPkg());
		this.hashColumns.put("cntr_no", getCntrNo());
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
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("pkg_count", "pkgCount");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cm_cntr_no", "cmCntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("item_gross_wgt", "itemGrossWgt");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("pkg_type", "pkgType");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("handle_cd", "handleCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("undg_no", "undgNo");
		this.hashFields.put("cm_ship_mark", "cmShipMark");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("tariff_cd", "tariffCd");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cm_cntr_pkg", "cmCntrPkg");
		this.hashFields.put("cntr_no", "cntrNo");
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
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
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
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return pkgType
	 */
	public String getPkgType() {
		return this.pkgType;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
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
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param pkgType
	 */
	public void setPkgType(String pkgType) {
		this.pkgType = pkgType;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setPkgCount(JSPUtil.getParameter(request, prefix + "pkg_count", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCmCntrNo(JSPUtil.getParameter(request, prefix + "cm_cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setItemGrossWgt(JSPUtil.getParameter(request, prefix + "item_gross_wgt", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setPkgType(JSPUtil.getParameter(request, prefix + "pkg_type", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHandleCd(JSPUtil.getParameter(request, prefix + "handle_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUndgNo(JSPUtil.getParameter(request, prefix + "undg_no", ""));
		setCmShipMark(JSPUtil.getParameter(request, prefix + "cm_ship_mark", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setTariffCd(JSPUtil.getParameter(request, prefix + "tariff_cd", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCmCntrPkg(JSPUtil.getParameter(request, prefix + "cm_cntr_pkg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setPieceCount(JSPUtil.getParameter(request, prefix + "piece_count", ""));
		setGoodsDesc(JSPUtil.getParameter(request, prefix + "goods_desc", ""));
		setGoodsItemNo(JSPUtil.getParameter(request, prefix + "goods_item_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchBlCMinfoVO[]
	 */
	public searchBlCMinfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchBlCMinfoVO[]
	 */
	public searchBlCMinfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchBlCMinfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] handleInfo = (JSPUtil.getParameter(request, prefix	+ "handle_info", length));
			String[] cmFlag = (JSPUtil.getParameter(request, prefix	+ "cm_flag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] pkgCount = (JSPUtil.getParameter(request, prefix	+ "pkg_count", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cmCntrNo = (JSPUtil.getParameter(request, prefix	+ "cm_cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] itemGrossWgt = (JSPUtil.getParameter(request, prefix	+ "item_gross_wgt", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] pkgType = (JSPUtil.getParameter(request, prefix	+ "pkg_type", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] handleCd = (JSPUtil.getParameter(request, prefix	+ "handle_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] undgNo = (JSPUtil.getParameter(request, prefix	+ "undg_no", length));
			String[] cmShipMark = (JSPUtil.getParameter(request, prefix	+ "cm_ship_mark", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] tariffCd = (JSPUtil.getParameter(request, prefix	+ "tariff_cd", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cmCntrPkg = (JSPUtil.getParameter(request, prefix	+ "cm_cntr_pkg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] pieceCount = (JSPUtil.getParameter(request, prefix	+ "piece_count", length));
			String[] goodsDesc = (JSPUtil.getParameter(request, prefix	+ "goods_desc", length));
			String[] goodsItemNo = (JSPUtil.getParameter(request, prefix	+ "goods_item_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchBlCMinfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (handleInfo[i] != null)
					model.setHandleInfo(handleInfo[i]);
				if (cmFlag[i] != null)
					model.setCmFlag(cmFlag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (pkgCount[i] != null)
					model.setPkgCount(pkgCount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cmCntrNo[i] != null)
					model.setCmCntrNo(cmCntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (itemGrossWgt[i] != null)
					model.setItemGrossWgt(itemGrossWgt[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (pkgType[i] != null)
					model.setPkgType(pkgType[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
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
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cmCntrPkg[i] != null)
					model.setCmCntrPkg(cmCntrPkg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
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
		return getsearchBlCMinfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchBlCMinfoVO[]
	 */
	public searchBlCMinfoVO[] getsearchBlCMinfoVOs(){
		searchBlCMinfoVO[] vos = (searchBlCMinfoVO[])models.toArray(new searchBlCMinfoVO[models.size()]);
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
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCount = this.pkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrNo = this.cmCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemGrossWgt = this.itemGrossWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgType = this.pkgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.handleCd = this.handleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undgNo = this.undgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmShipMark = this.cmShipMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffCd = this.tariffCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCntrPkg = this.cmCntrPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pieceCount = this.pieceCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsDesc = this.goodsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodsItemNo = this.goodsItemNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
