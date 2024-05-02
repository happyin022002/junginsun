/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MtyRlseOrdExcelDGVO.java
*@FileTitle : MtyRlseOrdExcelDGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class MtyRlseOrdExcelDGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyRlseOrdExcelDGVO> models = new ArrayList<MtyRlseOrdExcelDGVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String bkgNo = null;

	/* Column Info */
	private String dcgoSeq = null;

	/* Column Info */
	private String cntrTpszCd = null;

	/* Column Info */
	private String cntrCgoSeq = null;

	/* Column Info */
	private String cntrNo = null;

	/* Column Info */
	private String imdgUnNo = null;

	/* Column Info */
	private String imdgClssCd = null;

	/* Column Info */
	private String prpShpNm = null;

	/* Column Info */
	private String emerCntcPhnNoCtnt = null;

	/* Column Info */
	private String unPageNo = null;

	/* Column Info */
	private String flshPntCdoTemp = null;

	/* Column Info */
	private String pointC = null;

	/* Column Info */
	private String diffRmk = null;

	/* Column Info */
	private String emsNo = null;

	/* Column Info */
	private String psaNo = null;

	/* Column Info */
	private String imdgPckGrpCd = null;

	/* Column Info */
	private String mfag = null;

	/* Column Info */
	private String mrnPolutFlg = null;

	/* Column Info */
	private String imdgSubsRskLblCd1 = null;

	/* Column Info */
	private String outImdgPckQty1 = null;

	/* Column Info */
	private String outImdgPckCd1 = null;

	/* Column Info */
	private String netWgt = null;

	/* Column Info */
	private String wgtUtCd = null;

	/* Column Info */
	private String grsWgt = null;

	/* Column Info */
	private String wgtUtCd1 = null;

	/* Column Info */
	private String hzdCtnt = null;

	/* Column Info */
	private String imdgSubsRskLblCd2 = null;

	/* Column Info */
	private String imdgLmtQtyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MtyRlseOrdExcelDGVO() {}

	public MtyRlseOrdExcelDGVO(String ibflag, String pagerows, String bkgNo, String dcgoSeq, String cntrTpszCd, String cntrCgoSeq, String cntrNo, String imdgUnNo, String imdgClssCd, String prpShpNm, String emerCntcPhnNoCtnt, String unPageNo, String flshPntCdoTemp, String pointC, String diffRmk, String emsNo, String psaNo, String imdgPckGrpCd, String mfag, String mrnPolutFlg, String imdgSubsRskLblCd1, String outImdgPckQty1, String outImdgPckCd1, String netWgt, String wgtUtCd, String grsWgt, String wgtUtCd1, String hzdCtnt, String imdgSubsRskLblCd2, String imdgLmtQtyFlg) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.dcgoSeq = dcgoSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrCgoSeq = cntrCgoSeq;
		this.cntrNo = cntrNo;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.prpShpNm = prpShpNm;
		this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
		this.unPageNo = unPageNo;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.pointC = pointC;
		this.diffRmk = diffRmk;
		this.emsNo = emsNo;
		this.psaNo = psaNo;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.mfag = mfag;
		this.mrnPolutFlg = mrnPolutFlg;
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
		this.outImdgPckQty1 = outImdgPckQty1;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.netWgt = netWgt;
		this.wgtUtCd = wgtUtCd;
		this.grsWgt = grsWgt;
		this.wgtUtCd1 = wgtUtCd1;
		this.hzdCtnt = hzdCtnt;
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("emer_cntc_phn_no_ctnt", getEmerCntcPhnNoCtnt());
		this.hashColumns.put("un_page_no", getUnPageNo());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("point_c", getPointC());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("mfag", getMfag());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd1", getImdgSubsRskLblCd1());
		this.hashColumns.put("out_imdg_pck_qty1", getOutImdgPckQty1());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("wgt_ut_cd1", getWgtUtCd1());
		this.hashColumns.put("hzd_ctnt", getHzdCtnt());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd2", getImdgSubsRskLblCd2());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("emer_cntc_phn_no_ctnt", "emerCntcPhnNoCtnt");
		this.hashFields.put("un_page_no", "unPageNo");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("point_c", "pointC");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("mfag", "mfag");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("imdg_subs_rsk_lbl_cd1", "imdgSubsRskLblCd1");
		this.hashFields.put("out_imdg_pck_qty1", "outImdgPckQty1");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("wgt_ut_cd1", "wgtUtCd1");
		this.hashFields.put("hzd_ctnt", "hzdCtnt");
		this.hashFields.put("imdg_subs_rsk_lbl_cd2", "imdgSubsRskLblCd2");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * 
	 * @return String bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 *
	 * @param String dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * 
	 * @return String dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 *
	 * @param String cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * 
	 * @return String cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 *
	 * @param String cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
	}
	
	/**
	 * 
	 * @return String cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
	}
	
	/**
	 *
	 * @param String cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 
	 * @return String cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 *
	 * @param String imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * 
	 * @return String imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 *
	 * @param String imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 
	 * @return String imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 *
	 * @param String prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * 
	 * @return String prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 *
	 * @param String emerCntcPhnNoCtnt
	 */
	public void setEmerCntcPhnNoCtnt(String emerCntcPhnNoCtnt) {
		this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
	}
	
	/**
	 * 
	 * @return String emerCntcPhnNoCtnt
	 */
	public String getEmerCntcPhnNoCtnt() {
		return this.emerCntcPhnNoCtnt;
	}
	
	/**
	 *
	 * @param String unPageNo
	 */
	public void setUnPageNo(String unPageNo) {
		this.unPageNo = unPageNo;
	}
	
	/**
	 * 
	 * @return String unPageNo
	 */
	public String getUnPageNo() {
		return this.unPageNo;
	}
	
	/**
	 *
	 * @param String flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}
	
	/**
	 * 
	 * @return String flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}
	
	/**
	 *
	 * @param String pointC
	 */
	public void setPointC(String pointC) {
		this.pointC = pointC;
	}
	
	/**
	 * 
	 * @return String pointC
	 */
	public String getPointC() {
		return this.pointC;
	}
	
	/**
	 *
	 * @param String diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * 
	 * @return String diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 *
	 * @param String emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}
	
	/**
	 * 
	 * @return String emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
	}
	
	/**
	 *
	 * @param String psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
	}
	
	/**
	 * 
	 * @return String psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}
	
	/**
	 *
	 * @param String imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * 
	 * @return String imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 *
	 * @param String mfag
	 */
	public void setMfag(String mfag) {
		this.mfag = mfag;
	}
	
	/**
	 * 
	 * @return String mfag
	 */
	public String getMfag() {
		return this.mfag;
	}
	
	/**
	 *
	 * @param String mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}
	
	/**
	 * 
	 * @return String mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}
	
	/**
	 *
	 * @param String imdgSubsRskLblCd1
	 */
	public void setImdgSubsRskLblCd1(String imdgSubsRskLblCd1) {
		this.imdgSubsRskLblCd1 = imdgSubsRskLblCd1;
	}
	
	/**
	 * 
	 * @return String imdgSubsRskLblCd1
	 */
	public String getImdgSubsRskLblCd1() {
		return this.imdgSubsRskLblCd1;
	}
	
	/**
	 *
	 * @param String outImdgPckQty1
	 */
	public void setOutImdgPckQty1(String outImdgPckQty1) {
		this.outImdgPckQty1 = outImdgPckQty1;
	}
	
	/**
	 * 
	 * @return String outImdgPckQty1
	 */
	public String getOutImdgPckQty1() {
		return this.outImdgPckQty1;
	}
	
	/**
	 *
	 * @param String outImdgPckCd1
	 */
	public void setOutImdgPckCd1(String outImdgPckCd1) {
		this.outImdgPckCd1 = outImdgPckCd1;
	}
	
	/**
	 * 
	 * @return String outImdgPckCd1
	 */
	public String getOutImdgPckCd1() {
		return this.outImdgPckCd1;
	}
	
	/**
	 *
	 * @param String netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
	}
	
	/**
	 * 
	 * @return String netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
	}
	
	/**
	 *
	 * @param String wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * 
	 * @return String wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 *
	 * @param String grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 
	 * @return String grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 *
	 * @param String wgtUtCd1
	 */
	public void setWgtUtCd1(String wgtUtCd1) {
		this.wgtUtCd1 = wgtUtCd1;
	}
	
	/**
	 * 
	 * @return String wgtUtCd1
	 */
	public String getWgtUtCd1() {
		return this.wgtUtCd1;
	}
	
	/**
	 *
	 * @param String hzdCtnt
	 */
	public void setHzdCtnt(String hzdCtnt) {
		this.hzdCtnt = hzdCtnt;
	}
	
	/**
	 * 
	 * @return String hzdCtnt
	 */
	public String getHzdCtnt() {
		return this.hzdCtnt;
	}
	
	/**
	 *
	 * @param String imdgSubsRskLblCd2
	 */
	public void setImdgSubsRskLblCd2(String imdgSubsRskLblCd2) {
		this.imdgSubsRskLblCd2 = imdgSubsRskLblCd2;
	}
	
	/**
	 * 
	 * @return String imdgSubsRskLblCd2
	 */
	public String getImdgSubsRskLblCd2() {
		return this.imdgSubsRskLblCd2;
	}
	
	/**
	 *
	 * @param String imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * 
	 * @return String imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, prefix + "cntr_cgo_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setEmerCntcPhnNoCtnt(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no_ctnt", ""));
		setUnPageNo(JSPUtil.getParameter(request, prefix + "un_page_no", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setPointC(JSPUtil.getParameter(request, prefix + "point_c", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setMfag(JSPUtil.getParameter(request, prefix + "mfag", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setImdgSubsRskLblCd1(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd1", ""));
		setOutImdgPckQty1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_qty1", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
		setWgtUtCd1(JSPUtil.getParameter(request, prefix + "wgt_ut_cd1", ""));
		setHzdCtnt(JSPUtil.getParameter(request, prefix + "hzd_ctnt", ""));
		setImdgSubsRskLblCd2(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_cd2", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdExcelDGVO[]
	 */
	public MtyRlseOrdExcelDGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdExcelDGVO[]
	 */
	public MtyRlseOrdExcelDGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyRlseOrdExcelDGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] emerCntcPhnNoCtnt = (JSPUtil.getParameter(request, prefix	+ "emer_cntc_phn_no_ctnt", length));
			String[] unPageNo = (JSPUtil.getParameter(request, prefix	+ "un_page_no", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] pointC = (JSPUtil.getParameter(request, prefix	+ "point_c", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] mfag = (JSPUtil.getParameter(request, prefix	+ "mfag", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] imdgSubsRskLblCd1 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd1", length));
			String[] outImdgPckQty1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_qty1", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] wgtUtCd1 = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd1", length));
			String[] hzdCtnt = (JSPUtil.getParameter(request, prefix	+ "hzd_ctnt", length));
			String[] imdgSubsRskLblCd2 = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd2", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new MtyRlseOrdExcelDGVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null) 
					model.setBkgNo(bkgNo[i]);
				if (dcgoSeq[i] != null) 
					model.setDcgoSeq(dcgoSeq[i]);
				if (cntrTpszCd[i] != null) 
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrCgoSeq[i] != null) 
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (cntrNo[i] != null) 
					model.setCntrNo(cntrNo[i]);
				if (imdgUnNo[i] != null) 
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null) 
					model.setImdgClssCd(imdgClssCd[i]);
				if (prpShpNm[i] != null) 
					model.setPrpShpNm(prpShpNm[i]);
				if (emerCntcPhnNoCtnt[i] != null) 
					model.setEmerCntcPhnNoCtnt(emerCntcPhnNoCtnt[i]);
				if (unPageNo[i] != null) 
					model.setUnPageNo(unPageNo[i]);
				if (flshPntCdoTemp[i] != null) 
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (pointC[i] != null) 
					model.setPointC(pointC[i]);
				if (diffRmk[i] != null) 
					model.setDiffRmk(diffRmk[i]);
				if (emsNo[i] != null) 
					model.setEmsNo(emsNo[i]);
				if (psaNo[i] != null) 
					model.setPsaNo(psaNo[i]);
				if (imdgPckGrpCd[i] != null) 
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (mfag[i] != null) 
					model.setMfag(mfag[i]);
				if (mrnPolutFlg[i] != null) 
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (imdgSubsRskLblCd1[i] != null) 
					model.setImdgSubsRskLblCd1(imdgSubsRskLblCd1[i]);
				if (outImdgPckQty1[i] != null) 
					model.setOutImdgPckQty1(outImdgPckQty1[i]);
				if (outImdgPckCd1[i] != null) 
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (netWgt[i] != null) 
					model.setNetWgt(netWgt[i]);
				if (wgtUtCd[i] != null) 
					model.setWgtUtCd(wgtUtCd[i]);
				if (grsWgt[i] != null) 
					model.setGrsWgt(grsWgt[i]);
				if (wgtUtCd1[i] != null) 
					model.setWgtUtCd1(wgtUtCd1[i]);
				if (hzdCtnt[i] != null) 
					model.setHzdCtnt(hzdCtnt[i]);
				if (imdgSubsRskLblCd2[i] != null) 
					model.setImdgSubsRskLblCd2(imdgSubsRskLblCd2[i]);
				if (imdgLmtQtyFlg[i] != null) 
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyRlseOrdExcelDGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyRlseOrdExcelDGVO[]
	 */
	public MtyRlseOrdExcelDGVO[] getMtyRlseOrdExcelDGVOs(){
		MtyRlseOrdExcelDGVO[] vos = (MtyRlseOrdExcelDGVO[])models.toArray(new MtyRlseOrdExcelDGVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPhnNoCtnt = this.emerCntcPhnNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unPageNo = this.unPageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pointC = this.pointC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfag = this.mfag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd1 = this.imdgSubsRskLblCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckQty1 = this.outImdgPckQty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd1 = this.wgtUtCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdCtnt = this.hzdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd2 = this.imdgSubsRskLblCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}