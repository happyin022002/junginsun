/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IrrCntrVO.java
*@FileTitle : IrrCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.07.29 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IrrCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IrrCntrVO> models = new ArrayList<IrrCntrVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String spclCgoIrrSeq = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String fCustNm = null;
	/* Column Info */
	private String spclCgoIrrCntrSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String awkCgoNetWgt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cgoSeq = null;
	/* Column Info */
	private String cellPsnNo = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String awkCgoGrsWgt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IrrCntrVO() {}

	public IrrCntrVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String spclCgoIrrSeq, String spclCgoIrrCntrSeq, String bkgNo, String blNo, String porCd, String polCd, String podCd, String delCd, String sCustNm, String fCustNm, String cCustNm, String cntrNo, String cgoSeq, String cntrTpszCd, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String imdgCompGrpCd, String prpShpNm, String spclCgoCateCd, String awkCgoGrsWgt, String awkCgoNetWgt, String dimLen, String dimWdt, String dimHgt, String cmdtDesc, String cellPsnNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.cCustNm = cCustNm;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.creDt = creDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.dimWdt = dimWdt;
		this.spclCgoIrrSeq = spclCgoIrrSeq;
		this.dimLen = dimLen;
		this.fCustNm = fCustNm;
		this.spclCgoIrrCntrSeq = spclCgoIrrCntrSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.awkCgoNetWgt = awkCgoNetWgt;
		this.updDt = updDt;
		this.cgoSeq = cgoSeq;
		this.cellPsnNo = cellPsnNo;
		this.sCustNm = sCustNm;
		this.dimHgt = dimHgt;
		this.delCd = delCd;
		this.spclCgoCateCd = spclCgoCateCd;
		this.skdVoyNo = skdVoyNo;
		this.awkCgoGrsWgt = awkCgoGrsWgt;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.prpShpNm = prpShpNm;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("spcl_cgo_irr_seq", getSpclCgoIrrSeq());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("f_cust_nm", getFCustNm());
		this.hashColumns.put("spcl_cgo_irr_cntr_seq", getSpclCgoIrrCntrSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("awk_cgo_net_wgt", getAwkCgoNetWgt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("cell_psn_no", getCellPsnNo());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("awk_cgo_grs_wgt", getAwkCgoGrsWgt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("spcl_cgo_irr_seq", "spclCgoIrrSeq");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("f_cust_nm", "fCustNm");
		this.hashFields.put("spcl_cgo_irr_cntr_seq", "spclCgoIrrCntrSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("awk_cgo_net_wgt", "awkCgoNetWgt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("cell_psn_no", "cellPsnNo");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("awk_cgo_grs_wgt", "awkCgoGrsWgt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
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
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
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
	 * @return dimWdt
	 */
	public String getDimWdt() {
		return this.dimWdt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoIrrSeq
	 */
	public String getSpclCgoIrrSeq() {
		return this.spclCgoIrrSeq;
	}
	
	/**
	 * Column Info
	 * @return dimLen
	 */
	public String getDimLen() {
		return this.dimLen;
	}
	
	/**
	 * Column Info
	 * @return fCustNm
	 */
	public String getFCustNm() {
		return this.fCustNm;
	}
	
	/**
	 * Column Info
	 * @return spclCgoIrrCntrSeq
	 */
	public String getSpclCgoIrrCntrSeq() {
		return this.spclCgoIrrCntrSeq;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return awkCgoNetWgt
	 */
	public String getAwkCgoNetWgt() {
		return this.awkCgoNetWgt;
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
	 * @return cgoSeq
	 */
	public String getCgoSeq() {
		return this.cgoSeq;
	}
	
	/**
	 * Column Info
	 * @return cellPsnNo
	 */
	public String getCellPsnNo() {
		return this.cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return dimHgt
	 */
	public String getDimHgt() {
		return this.dimHgt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoCateCd
	 */
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
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
	 * @return awkCgoGrsWgt
	 */
	public String getAwkCgoGrsWgt() {
		return this.awkCgoGrsWgt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
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
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
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
	 * @param dimWdt
	 */
	public void setDimWdt(String dimWdt) {
		this.dimWdt = dimWdt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoIrrSeq
	 */
	public void setSpclCgoIrrSeq(String spclCgoIrrSeq) {
		this.spclCgoIrrSeq = spclCgoIrrSeq;
	}
	
	/**
	 * Column Info
	 * @param dimLen
	 */
	public void setDimLen(String dimLen) {
		this.dimLen = dimLen;
	}
	
	/**
	 * Column Info
	 * @param fCustNm
	 */
	public void setFCustNm(String fCustNm) {
		this.fCustNm = fCustNm;
	}
	
	/**
	 * Column Info
	 * @param spclCgoIrrCntrSeq
	 */
	public void setSpclCgoIrrCntrSeq(String spclCgoIrrCntrSeq) {
		this.spclCgoIrrCntrSeq = spclCgoIrrCntrSeq;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param awkCgoNetWgt
	 */
	public void setAwkCgoNetWgt(String awkCgoNetWgt) {
		this.awkCgoNetWgt = awkCgoNetWgt;
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
	 * @param cgoSeq
	 */
	public void setCgoSeq(String cgoSeq) {
		this.cgoSeq = cgoSeq;
	}
	
	/**
	 * Column Info
	 * @param cellPsnNo
	 */
	public void setCellPsnNo(String cellPsnNo) {
		this.cellPsnNo = cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param dimHgt
	 */
	public void setDimHgt(String dimHgt) {
		this.dimHgt = dimHgt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoCateCd
	 */
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
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
	 * @param awkCgoGrsWgt
	 */
	public void setAwkCgoGrsWgt(String awkCgoGrsWgt) {
		this.awkCgoGrsWgt = awkCgoGrsWgt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, "imdg_comp_grp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDimWdt(JSPUtil.getParameter(request, "dim_wdt", ""));
		setSpclCgoIrrSeq(JSPUtil.getParameter(request, "spcl_cgo_irr_seq", ""));
		setDimLen(JSPUtil.getParameter(request, "dim_len", ""));
		setFCustNm(JSPUtil.getParameter(request, "f_cust_nm", ""));
		setSpclCgoIrrCntrSeq(JSPUtil.getParameter(request, "spcl_cgo_irr_cntr_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setAwkCgoNetWgt(JSPUtil.getParameter(request, "awk_cgo_net_wgt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCgoSeq(JSPUtil.getParameter(request, "cgo_seq", ""));
		setCellPsnNo(JSPUtil.getParameter(request, "cell_psn_no", ""));
		setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
		setDimHgt(JSPUtil.getParameter(request, "dim_hgt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, "spcl_cgo_cate_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setAwkCgoGrsWgt(JSPUtil.getParameter(request, "awk_cgo_grs_wgt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IrrCntrVO[]
	 */
	public IrrCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IrrCntrVO[]
	 */
	public IrrCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IrrCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix	+ "dim_wdt", length));
			String[] spclCgoIrrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_irr_seq", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] fCustNm = (JSPUtil.getParameter(request, prefix	+ "f_cust_nm", length));
			String[] spclCgoIrrCntrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_irr_cntr_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] awkCgoNetWgt = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_net_wgt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cgoSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_seq", length));
			String[] cellPsnNo = (JSPUtil.getParameter(request, prefix	+ "cell_psn_no", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix	+ "dim_hgt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] awkCgoGrsWgt = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_grs_wgt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IrrCntrVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (spclCgoIrrSeq[i] != null)
					model.setSpclCgoIrrSeq(spclCgoIrrSeq[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (fCustNm[i] != null)
					model.setFCustNm(fCustNm[i]);
				if (spclCgoIrrCntrSeq[i] != null)
					model.setSpclCgoIrrCntrSeq(spclCgoIrrCntrSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (awkCgoNetWgt[i] != null)
					model.setAwkCgoNetWgt(awkCgoNetWgt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cgoSeq[i] != null)
					model.setCgoSeq(cgoSeq[i]);
				if (cellPsnNo[i] != null)
					model.setCellPsnNo(cellPsnNo[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (awkCgoGrsWgt[i] != null)
					model.setAwkCgoGrsWgt(awkCgoGrsWgt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIrrCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IrrCntrVO[]
	 */
	public IrrCntrVO[] getIrrCntrVOs(){
		IrrCntrVO[] vos = (IrrCntrVO[])models.toArray(new IrrCntrVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimWdt = this.dimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoIrrSeq = this.spclCgoIrrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCustNm = this.fCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoIrrCntrSeq = this.spclCgoIrrCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoNetWgt = this.awkCgoNetWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoSeq = this.cgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cellPsnNo = this.cellPsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoGrsWgt = this.awkCgoGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
