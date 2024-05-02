/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustCdValidationVO.java
*@FileTitle : CustCdValidationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustCdValidationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustCdValidationVO> models = new ArrayList<CustCdValidationVO>();
	
	/* Column Info */
	private String bkgCustTpCdView = null;
	/* Column Info */
	private String valCustFaxNo = null;
	/* Column Info */
	private String bkgCustCntCd = null;
	/* Column Info */
	private String valUsrId = null;
	/* Column Info */
	private String rowCount = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntcEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String valCdImgIdx = null;
	/* Column Info */
	private String bkgCustNm = null;
	/* Column Info */
	private String grpSeq = null;
	/* Column Info */
	private String mdmCustAddr = null;
	/* Column Info */
	private String valCustCd = null;
	/* Column Info */
	private String ntcFaxNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String bkgCustFaxNo = null;
	/* Column Info */
	private String valCd = null;
	/* Column Info */
	private String bkgCustAddr = null;
	/* Column Info */
	private String orgCustCd = null;
	/* Column Info */
	private String lvlCd = null;
	/* Column Info */
	private String valCustNm = null;
	/* Column Info */
	private String valCdNm = null;
	/* Column Info */
	private String bkgCustSeq = null;
	/* Column Info */
	private String grpImgIdx = null;
	/* Column Info */
	private String valCustAddr = null;
	/* Column Info */
	private String corCustCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String valUsrNm = null;
	/* Column Info */
	private String mdmCustNm = null;
	/* Column Info */
	private String mtchFlg = null;
	/* Column Info */
	private String grpSeqView = null;
	/* Column Info */
	private String mdmCustCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustCdValidationVO() {}

	public CustCdValidationVO(String ibflag, String pagerows, String bkgNo, String bkgCustTpCd, String blNo, String mdmCustCd, String mdmCustNm, String mdmCustAddr, String bkgCustCntCd, String bkgCustSeq, String bkgCustNm, String bkgCustAddr, String valCustCd, String valCustNm, String valCustAddr, String bkgCustFaxNo, String valCustFaxNo, String corCustCd, String rowCount, String valCd, String valCdNm, String valCdImgIdx, String valUsrId, String valUsrNm, String mtchFlg, String ntcFaxNo, String ntcEml, String lvlCd, String grpSeq, String grpSeqView, String grpImgIdx, String bkgCustTpCdView, String orgCustCd) {
		this.bkgCustTpCdView = bkgCustTpCdView;
		this.valCustFaxNo = valCustFaxNo;
		this.bkgCustCntCd = bkgCustCntCd;
		this.valUsrId = valUsrId;
		this.rowCount = rowCount;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ntcEml = ntcEml;
		this.ibflag = ibflag;
		this.valCdImgIdx = valCdImgIdx;
		this.bkgCustNm = bkgCustNm;
		this.grpSeq = grpSeq;
		this.mdmCustAddr = mdmCustAddr;
		this.valCustCd = valCustCd;
		this.ntcFaxNo = ntcFaxNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.bkgCustFaxNo = bkgCustFaxNo;
		this.valCd = valCd;
		this.bkgCustAddr = bkgCustAddr;
		this.orgCustCd = orgCustCd;
		this.lvlCd = lvlCd;
		this.valCustNm = valCustNm;
		this.valCdNm = valCdNm;
		this.bkgCustSeq = bkgCustSeq;
		this.grpImgIdx = grpImgIdx;
		this.valCustAddr = valCustAddr;
		this.corCustCd = corCustCd;
		this.bkgNo = bkgNo;
		this.valUsrNm = valUsrNm;
		this.mdmCustNm = mdmCustNm;
		this.mtchFlg = mtchFlg;
		this.grpSeqView = grpSeqView;
		this.mdmCustCd = mdmCustCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cust_tp_cd_view", getBkgCustTpCdView());
		this.hashColumns.put("val_cust_fax_no", getValCustFaxNo());
		this.hashColumns.put("bkg_cust_cnt_cd", getBkgCustCntCd());
		this.hashColumns.put("val_usr_id", getValUsrId());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("val_cd_img_idx", getValCdImgIdx());
		this.hashColumns.put("bkg_cust_nm", getBkgCustNm());
		this.hashColumns.put("grp_seq", getGrpSeq());
		this.hashColumns.put("mdm_cust_addr", getMdmCustAddr());
		this.hashColumns.put("val_cust_cd", getValCustCd());
		this.hashColumns.put("ntc_fax_no", getNtcFaxNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("bkg_cust_fax_no", getBkgCustFaxNo());
		this.hashColumns.put("val_cd", getValCd());
		this.hashColumns.put("bkg_cust_addr", getBkgCustAddr());
		this.hashColumns.put("org_cust_cd", getOrgCustCd());
		this.hashColumns.put("lvl_cd", getLvlCd());
		this.hashColumns.put("val_cust_nm", getValCustNm());
		this.hashColumns.put("val_cd_nm", getValCdNm());
		this.hashColumns.put("bkg_cust_seq", getBkgCustSeq());
		this.hashColumns.put("grp_img_idx", getGrpImgIdx());
		this.hashColumns.put("val_cust_addr", getValCustAddr());
		this.hashColumns.put("cor_cust_cd", getCorCustCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("val_usr_nm", getValUsrNm());
		this.hashColumns.put("mdm_cust_nm", getMdmCustNm());
		this.hashColumns.put("mtch_flg", getMtchFlg());
		this.hashColumns.put("grp_seq_view", getGrpSeqView());
		this.hashColumns.put("mdm_cust_cd", getMdmCustCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cust_tp_cd_view", "bkgCustTpCdView");
		this.hashFields.put("val_cust_fax_no", "valCustFaxNo");
		this.hashFields.put("bkg_cust_cnt_cd", "bkgCustCntCd");
		this.hashFields.put("val_usr_id", "valUsrId");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("val_cd_img_idx", "valCdImgIdx");
		this.hashFields.put("bkg_cust_nm", "bkgCustNm");
		this.hashFields.put("grp_seq", "grpSeq");
		this.hashFields.put("mdm_cust_addr", "mdmCustAddr");
		this.hashFields.put("val_cust_cd", "valCustCd");
		this.hashFields.put("ntc_fax_no", "ntcFaxNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("bkg_cust_fax_no", "bkgCustFaxNo");
		this.hashFields.put("val_cd", "valCd");
		this.hashFields.put("bkg_cust_addr", "bkgCustAddr");
		this.hashFields.put("org_cust_cd", "orgCustCd");
		this.hashFields.put("lvl_cd", "lvlCd");
		this.hashFields.put("val_cust_nm", "valCustNm");
		this.hashFields.put("val_cd_nm", "valCdNm");
		this.hashFields.put("bkg_cust_seq", "bkgCustSeq");
		this.hashFields.put("grp_img_idx", "grpImgIdx");
		this.hashFields.put("val_cust_addr", "valCustAddr");
		this.hashFields.put("cor_cust_cd", "corCustCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("val_usr_nm", "valUsrNm");
		this.hashFields.put("mdm_cust_nm", "mdmCustNm");
		this.hashFields.put("mtch_flg", "mtchFlg");
		this.hashFields.put("grp_seq_view", "grpSeqView");
		this.hashFields.put("mdm_cust_cd", "mdmCustCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCdView
	 */
	public String getBkgCustTpCdView() {
		return this.bkgCustTpCdView;
	}
	
	/**
	 * Column Info
	 * @return valCustFaxNo
	 */
	public String getValCustFaxNo() {
		return this.valCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCustCntCd
	 */
	public String getBkgCustCntCd() {
		return this.bkgCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return valUsrId
	 */
	public String getValUsrId() {
		return this.valUsrId;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
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
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
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
	 * @return valCdImgIdx
	 */
	public String getValCdImgIdx() {
		return this.valCdImgIdx;
	}
	
	/**
	 * Column Info
	 * @return bkgCustNm
	 */
	public String getBkgCustNm() {
		return this.bkgCustNm;
	}
	
	/**
	 * Column Info
	 * @return grpSeq
	 */
	public String getGrpSeq() {
		return this.grpSeq;
	}
	
	/**
	 * Column Info
	 * @return mdmCustAddr
	 */
	public String getMdmCustAddr() {
		return this.mdmCustAddr;
	}
	
	/**
	 * Column Info
	 * @return valCustCd
	 */
	public String getValCustCd() {
		return this.valCustCd;
	}
	
	/**
	 * Column Info
	 * @return ntcFaxNo
	 */
	public String getNtcFaxNo() {
		return this.ntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustFaxNo
	 */
	public String getBkgCustFaxNo() {
		return this.bkgCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return valCd
	 */
	public String getValCd() {
		return this.valCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCustAddr
	 */
	public String getBkgCustAddr() {
		return this.bkgCustAddr;
	}
	
	/**
	 * Column Info
	 * @return orgCustCd
	 */
	public String getOrgCustCd() {
		return this.orgCustCd;
	}
	
	/**
	 * Column Info
	 * @return lvlCd
	 */
	public String getLvlCd() {
		return this.lvlCd;
	}
	
	/**
	 * Column Info
	 * @return valCustNm
	 */
	public String getValCustNm() {
		return this.valCustNm;
	}
	
	/**
	 * Column Info
	 * @return valCdNm
	 */
	public String getValCdNm() {
		return this.valCdNm;
	}
	
	/**
	 * Column Info
	 * @return bkgCustSeq
	 */
	public String getBkgCustSeq() {
		return this.bkgCustSeq;
	}
	
	/**
	 * Column Info
	 * @return grpImgIdx
	 */
	public String getGrpImgIdx() {
		return this.grpImgIdx;
	}
	
	/**
	 * Column Info
	 * @return valCustAddr
	 */
	public String getValCustAddr() {
		return this.valCustAddr;
	}
	
	/**
	 * Column Info
	 * @return corCustCd
	 */
	public String getCorCustCd() {
		return this.corCustCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return valUsrNm
	 */
	public String getValUsrNm() {
		return this.valUsrNm;
	}
	
	/**
	 * Column Info
	 * @return mdmCustNm
	 */
	public String getMdmCustNm() {
		return this.mdmCustNm;
	}
	
	/**
	 * Column Info
	 * @return mtchFlg
	 */
	public String getMtchFlg() {
		return this.mtchFlg;
	}
	
	/**
	 * Column Info
	 * @return grpSeqView
	 */
	public String getGrpSeqView() {
		return this.grpSeqView;
	}
	
	/**
	 * Column Info
	 * @return mdmCustCd
	 */
	public String getMdmCustCd() {
		return this.mdmCustCd;
	}
	

	/**
	 * Column Info
	 * @param bkgCustTpCdView
	 */
	public void setBkgCustTpCdView(String bkgCustTpCdView) {
		this.bkgCustTpCdView = bkgCustTpCdView;
	}
	
	/**
	 * Column Info
	 * @param valCustFaxNo
	 */
	public void setValCustFaxNo(String valCustFaxNo) {
		this.valCustFaxNo = valCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCustCntCd
	 */
	public void setBkgCustCntCd(String bkgCustCntCd) {
		this.bkgCustCntCd = bkgCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param valUsrId
	 */
	public void setValUsrId(String valUsrId) {
		this.valUsrId = valUsrId;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
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
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
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
	 * @param valCdImgIdx
	 */
	public void setValCdImgIdx(String valCdImgIdx) {
		this.valCdImgIdx = valCdImgIdx;
	}
	
	/**
	 * Column Info
	 * @param bkgCustNm
	 */
	public void setBkgCustNm(String bkgCustNm) {
		this.bkgCustNm = bkgCustNm;
	}
	
	/**
	 * Column Info
	 * @param grpSeq
	 */
	public void setGrpSeq(String grpSeq) {
		this.grpSeq = grpSeq;
	}
	
	/**
	 * Column Info
	 * @param mdmCustAddr
	 */
	public void setMdmCustAddr(String mdmCustAddr) {
		this.mdmCustAddr = mdmCustAddr;
	}
	
	/**
	 * Column Info
	 * @param valCustCd
	 */
	public void setValCustCd(String valCustCd) {
		this.valCustCd = valCustCd;
	}
	
	/**
	 * Column Info
	 * @param ntcFaxNo
	 */
	public void setNtcFaxNo(String ntcFaxNo) {
		this.ntcFaxNo = ntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustFaxNo
	 */
	public void setBkgCustFaxNo(String bkgCustFaxNo) {
		this.bkgCustFaxNo = bkgCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param valCd
	 */
	public void setValCd(String valCd) {
		this.valCd = valCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCustAddr
	 */
	public void setBkgCustAddr(String bkgCustAddr) {
		this.bkgCustAddr = bkgCustAddr;
	}
	
	/**
	 * Column Info
	 * @param orgCustCd
	 */
	public void setOrgCustCd(String orgCustCd) {
		this.orgCustCd = orgCustCd;
	}
	
	/**
	 * Column Info
	 * @param lvlCd
	 */
	public void setLvlCd(String lvlCd) {
		this.lvlCd = lvlCd;
	}
	
	/**
	 * Column Info
	 * @param valCustNm
	 */
	public void setValCustNm(String valCustNm) {
		this.valCustNm = valCustNm;
	}
	
	/**
	 * Column Info
	 * @param valCdNm
	 */
	public void setValCdNm(String valCdNm) {
		this.valCdNm = valCdNm;
	}
	
	/**
	 * Column Info
	 * @param bkgCustSeq
	 */
	public void setBkgCustSeq(String bkgCustSeq) {
		this.bkgCustSeq = bkgCustSeq;
	}
	
	/**
	 * Column Info
	 * @param grpImgIdx
	 */
	public void setGrpImgIdx(String grpImgIdx) {
		this.grpImgIdx = grpImgIdx;
	}
	
	/**
	 * Column Info
	 * @param valCustAddr
	 */
	public void setValCustAddr(String valCustAddr) {
		this.valCustAddr = valCustAddr;
	}
	
	/**
	 * Column Info
	 * @param corCustCd
	 */
	public void setCorCustCd(String corCustCd) {
		this.corCustCd = corCustCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param valUsrNm
	 */
	public void setValUsrNm(String valUsrNm) {
		this.valUsrNm = valUsrNm;
	}
	
	/**
	 * Column Info
	 * @param mdmCustNm
	 */
	public void setMdmCustNm(String mdmCustNm) {
		this.mdmCustNm = mdmCustNm;
	}
	
	/**
	 * Column Info
	 * @param mtchFlg
	 */
	public void setMtchFlg(String mtchFlg) {
		this.mtchFlg = mtchFlg;
	}
	
	/**
	 * Column Info
	 * @param grpSeqView
	 */
	public void setGrpSeqView(String grpSeqView) {
		this.grpSeqView = grpSeqView;
	}
	
	/**
	 * Column Info
	 * @param mdmCustCd
	 */
	public void setMdmCustCd(String mdmCustCd) {
		this.mdmCustCd = mdmCustCd;
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
		setBkgCustTpCdView(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd_view", ""));
		setValCustFaxNo(JSPUtil.getParameter(request, prefix + "val_cust_fax_no", ""));
		setBkgCustCntCd(JSPUtil.getParameter(request, prefix + "bkg_cust_cnt_cd", ""));
		setValUsrId(JSPUtil.getParameter(request, prefix + "val_usr_id", ""));
		setRowCount(JSPUtil.getParameter(request, prefix + "row_count", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNtcEml(JSPUtil.getParameter(request, prefix + "ntc_eml", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setValCdImgIdx(JSPUtil.getParameter(request, prefix + "val_cd_img_idx", ""));
		setBkgCustNm(JSPUtil.getParameter(request, prefix + "bkg_cust_nm", ""));
		setGrpSeq(JSPUtil.getParameter(request, prefix + "grp_seq", ""));
		setMdmCustAddr(JSPUtil.getParameter(request, prefix + "mdm_cust_addr", ""));
		setValCustCd(JSPUtil.getParameter(request, prefix + "val_cust_cd", ""));
		setNtcFaxNo(JSPUtil.getParameter(request, prefix + "ntc_fax_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setBkgCustFaxNo(JSPUtil.getParameter(request, prefix + "bkg_cust_fax_no", ""));
		setValCd(JSPUtil.getParameter(request, prefix + "val_cd", ""));
		setBkgCustAddr(JSPUtil.getParameter(request, prefix + "bkg_cust_addr", ""));
		setOrgCustCd(JSPUtil.getParameter(request, prefix + "org_cust_cd", ""));
		setLvlCd(JSPUtil.getParameter(request, prefix + "lvl_cd", ""));
		setValCustNm(JSPUtil.getParameter(request, prefix + "val_cust_nm", ""));
		setValCdNm(JSPUtil.getParameter(request, prefix + "val_cd_nm", ""));
		setBkgCustSeq(JSPUtil.getParameter(request, prefix + "bkg_cust_seq", ""));
		setGrpImgIdx(JSPUtil.getParameter(request, prefix + "grp_img_idx", ""));
		setValCustAddr(JSPUtil.getParameter(request, prefix + "val_cust_addr", ""));
		setCorCustCd(JSPUtil.getParameter(request, prefix + "cor_cust_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setValUsrNm(JSPUtil.getParameter(request, prefix + "val_usr_nm", ""));
		setMdmCustNm(JSPUtil.getParameter(request, prefix + "mdm_cust_nm", ""));
		setMtchFlg(JSPUtil.getParameter(request, prefix + "mtch_flg", ""));
		setGrpSeqView(JSPUtil.getParameter(request, prefix + "grp_seq_view", ""));
		setMdmCustCd(JSPUtil.getParameter(request, prefix + "mdm_cust_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustCdValidationVO[]
	 */
	public CustCdValidationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustCdValidationVO[]
	 */
	public CustCdValidationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustCdValidationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCustTpCdView = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd_view", length));
			String[] valCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "val_cust_fax_no", length));
			String[] bkgCustCntCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_cnt_cd", length));
			String[] valUsrId = (JSPUtil.getParameter(request, prefix	+ "val_usr_id", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] valCdImgIdx = (JSPUtil.getParameter(request, prefix	+ "val_cd_img_idx", length));
			String[] bkgCustNm = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_nm", length));
			String[] grpSeq = (JSPUtil.getParameter(request, prefix	+ "grp_seq", length));
			String[] mdmCustAddr = (JSPUtil.getParameter(request, prefix	+ "mdm_cust_addr", length));
			String[] valCustCd = (JSPUtil.getParameter(request, prefix	+ "val_cust_cd", length));
			String[] ntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] bkgCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_fax_no", length));
			String[] valCd = (JSPUtil.getParameter(request, prefix	+ "val_cd", length));
			String[] bkgCustAddr = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_addr", length));
			String[] orgCustCd = (JSPUtil.getParameter(request, prefix	+ "org_cust_cd", length));
			String[] lvlCd = (JSPUtil.getParameter(request, prefix	+ "lvl_cd", length));
			String[] valCustNm = (JSPUtil.getParameter(request, prefix	+ "val_cust_nm", length));
			String[] valCdNm = (JSPUtil.getParameter(request, prefix	+ "val_cd_nm", length));
			String[] bkgCustSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_seq", length));
			String[] grpImgIdx = (JSPUtil.getParameter(request, prefix	+ "grp_img_idx", length));
			String[] valCustAddr = (JSPUtil.getParameter(request, prefix	+ "val_cust_addr", length));
			String[] corCustCd = (JSPUtil.getParameter(request, prefix	+ "cor_cust_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] valUsrNm = (JSPUtil.getParameter(request, prefix	+ "val_usr_nm", length));
			String[] mdmCustNm = (JSPUtil.getParameter(request, prefix	+ "mdm_cust_nm", length));
			String[] mtchFlg = (JSPUtil.getParameter(request, prefix	+ "mtch_flg", length));
			String[] grpSeqView = (JSPUtil.getParameter(request, prefix	+ "grp_seq_view", length));
			String[] mdmCustCd = (JSPUtil.getParameter(request, prefix	+ "mdm_cust_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustCdValidationVO();
				if (bkgCustTpCdView[i] != null)
					model.setBkgCustTpCdView(bkgCustTpCdView[i]);
				if (valCustFaxNo[i] != null)
					model.setValCustFaxNo(valCustFaxNo[i]);
				if (bkgCustCntCd[i] != null)
					model.setBkgCustCntCd(bkgCustCntCd[i]);
				if (valUsrId[i] != null)
					model.setValUsrId(valUsrId[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (valCdImgIdx[i] != null)
					model.setValCdImgIdx(valCdImgIdx[i]);
				if (bkgCustNm[i] != null)
					model.setBkgCustNm(bkgCustNm[i]);
				if (grpSeq[i] != null)
					model.setGrpSeq(grpSeq[i]);
				if (mdmCustAddr[i] != null)
					model.setMdmCustAddr(mdmCustAddr[i]);
				if (valCustCd[i] != null)
					model.setValCustCd(valCustCd[i]);
				if (ntcFaxNo[i] != null)
					model.setNtcFaxNo(ntcFaxNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (bkgCustFaxNo[i] != null)
					model.setBkgCustFaxNo(bkgCustFaxNo[i]);
				if (valCd[i] != null)
					model.setValCd(valCd[i]);
				if (bkgCustAddr[i] != null)
					model.setBkgCustAddr(bkgCustAddr[i]);
				if (orgCustCd[i] != null)
					model.setOrgCustCd(orgCustCd[i]);
				if (lvlCd[i] != null)
					model.setLvlCd(lvlCd[i]);
				if (valCustNm[i] != null)
					model.setValCustNm(valCustNm[i]);
				if (valCdNm[i] != null)
					model.setValCdNm(valCdNm[i]);
				if (bkgCustSeq[i] != null)
					model.setBkgCustSeq(bkgCustSeq[i]);
				if (grpImgIdx[i] != null)
					model.setGrpImgIdx(grpImgIdx[i]);
				if (valCustAddr[i] != null)
					model.setValCustAddr(valCustAddr[i]);
				if (corCustCd[i] != null)
					model.setCorCustCd(corCustCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (valUsrNm[i] != null)
					model.setValUsrNm(valUsrNm[i]);
				if (mdmCustNm[i] != null)
					model.setMdmCustNm(mdmCustNm[i]);
				if (mtchFlg[i] != null)
					model.setMtchFlg(mtchFlg[i]);
				if (grpSeqView[i] != null)
					model.setGrpSeqView(grpSeqView[i]);
				if (mdmCustCd[i] != null)
					model.setMdmCustCd(mdmCustCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustCdValidationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustCdValidationVO[]
	 */
	public CustCdValidationVO[] getCustCdValidationVOs(){
		CustCdValidationVO[] vos = (CustCdValidationVO[])models.toArray(new CustCdValidationVO[models.size()]);
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
		this.bkgCustTpCdView = this.bkgCustTpCdView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCustFaxNo = this.valCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustCntCd = this.bkgCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valUsrId = this.valUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCdImgIdx = this.valCdImgIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustNm = this.bkgCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq = this.grpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmCustAddr = this.mdmCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCustCd = this.valCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNo = this.ntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustFaxNo = this.bkgCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCd = this.valCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustAddr = this.bkgCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCustCd = this.orgCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvlCd = this.lvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCustNm = this.valCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCdNm = this.valCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustSeq = this.bkgCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpImgIdx = this.grpImgIdx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCustAddr = this.valCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corCustCd = this.corCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valUsrNm = this.valUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmCustNm = this.mdmCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtchFlg = this.mtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeqView = this.grpSeqView .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdmCustCd = this.mdmCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
