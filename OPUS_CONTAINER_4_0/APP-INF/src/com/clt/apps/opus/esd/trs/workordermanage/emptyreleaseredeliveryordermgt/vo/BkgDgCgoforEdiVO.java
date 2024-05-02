/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgDgCgoforEdiVO.java
*@FileTitle : BkgDgCgoforEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.20  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo;

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

public class BkgDgCgoforEdiVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgDgCgoforEdiVO> models = new ArrayList<BkgDgCgoforEdiVO>();
	
	/* Column Info */
	private String emerCntcPhnNoCtnt = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String imdgSubsRskLblRmk = null;
	/* Column Info */
	private String psaNo = null;
	/* Column Info */
	private String emsNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spclStwgRqstDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String outImdgPckCd1 = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgLmtQtyFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgDgCgoforEdiVO() {}

	public BkgDgCgoforEdiVO(String ibflag, String pagerows, String imdgUnNo, String imdgClssCd, String emerCntcPhnNoCtnt, String flshPntCdoTemp, String diffRmk, String emsNo, String psaNo, String dcgoFlg, String awkCgoFlg, String rcFlg, String rdCgoFlg, String imdgPckGrpCd, String prpShpNm, String mrnPolutFlg, String outImdgPckCd1, String hzdDesc, String spclStwgRqstDesc, String imdgLmtQtyFlg, String imdgSubsRskLblRmk) {
		this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.rdCgoFlg = rdCgoFlg;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.awkCgoFlg = awkCgoFlg;
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
		this.psaNo = psaNo;
		this.emsNo = emsNo;
		this.pagerows = pagerows;
		this.spclStwgRqstDesc = spclStwgRqstDesc;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.dcgoFlg = dcgoFlg;
		this.hzdDesc = hzdDesc;
		this.prpShpNm = prpShpNm;
		this.rcFlg = rcFlg;
		this.mrnPolutFlg = mrnPolutFlg;
		this.outImdgPckCd1 = outImdgPckCd1;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("emer_cntc_phn_no_ctnt", getEmerCntcPhnNoCtnt());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("imdg_subs_rsk_lbl_rmk", getImdgSubsRskLblRmk());
		this.hashColumns.put("psa_no", getPsaNo());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("out_imdg_pck_cd1", getOutImdgPckCd1());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_lmt_qty_flg", getImdgLmtQtyFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("emer_cntc_phn_no_ctnt", "emerCntcPhnNoCtnt");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("imdg_subs_rsk_lbl_rmk", "imdgSubsRskLblRmk");
		this.hashFields.put("psa_no", "psaNo");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("out_imdg_pck_cd1", "outImdgPckCd1");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_lmt_qty_flg", "imdgLmtQtyFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return emerCntcPhnNoCtnt
	 */
	public String getEmerCntcPhnNoCtnt() {
		return this.emerCntcPhnNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblRmk
	 */
	public String getImdgSubsRskLblRmk() {
		return this.imdgSubsRskLblRmk;
	}
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}
	
	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
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
	 * @return spclStwgRqstDesc
	 */
	public String getSpclStwgRqstDesc() {
		return this.spclStwgRqstDesc;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return hzdDesc
	 */
	public String getHzdDesc() {
		return this.hzdDesc;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @return outImdgPckCd1
	 */
	public String getOutImdgPckCd1() {
		return this.outImdgPckCd1;
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
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return imdgLmtQtyFlg
	 */
	public String getImdgLmtQtyFlg() {
		return this.imdgLmtQtyFlg;
	}
	

	/**
	 * Column Info
	 * @param emerCntcPhnNoCtnt
	 */
	public void setEmerCntcPhnNoCtnt(String emerCntcPhnNoCtnt) {
		this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblRmk
	 */
	public void setImdgSubsRskLblRmk(String imdgSubsRskLblRmk) {
		this.imdgSubsRskLblRmk = imdgSubsRskLblRmk;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
	}
	
	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
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
	 * @param spclStwgRqstDesc
	 */
	public void setSpclStwgRqstDesc(String spclStwgRqstDesc) {
		this.spclStwgRqstDesc = spclStwgRqstDesc;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param hzdDesc
	 */
	public void setHzdDesc(String hzdDesc) {
		this.hzdDesc = hzdDesc;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @param outImdgPckCd1
	 */
	public void setOutImdgPckCd1(String outImdgPckCd1) {
		this.outImdgPckCd1 = outImdgPckCd1;
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
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param imdgLmtQtyFlg
	 */
	public void setImdgLmtQtyFlg(String imdgLmtQtyFlg) {
		this.imdgLmtQtyFlg = imdgLmtQtyFlg;
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
		setEmerCntcPhnNoCtnt(JSPUtil.getParameter(request, prefix + "emer_cntc_phn_no_ctnt", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setImdgSubsRskLblRmk(JSPUtil.getParameter(request, prefix + "imdg_subs_rsk_lbl_rmk", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSpclStwgRqstDesc(JSPUtil.getParameter(request, prefix + "spcl_stwg_rqst_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setHzdDesc(JSPUtil.getParameter(request, prefix + "hzd_desc", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, prefix + "mrn_polut_flg", ""));
		setOutImdgPckCd1(JSPUtil.getParameter(request, prefix + "out_imdg_pck_cd1", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setImdgLmtQtyFlg(JSPUtil.getParameter(request, prefix + "imdg_lmt_qty_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDgCgoforEdiVO[]
	 */
	public BkgDgCgoforEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgDgCgoforEdiVO[]
	 */
	public BkgDgCgoforEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgDgCgoforEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] emerCntcPhnNoCtnt = (JSPUtil.getParameter(request, prefix	+ "emer_cntc_phn_no_ctnt", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] imdgSubsRskLblRmk = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_rmk", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spclStwgRqstDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_stwg_rqst_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] outImdgPckCd1 = (JSPUtil.getParameter(request, prefix	+ "out_imdg_pck_cd1", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgLmtQtyFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_lmt_qty_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgDgCgoforEdiVO();
				if (emerCntcPhnNoCtnt[i] != null)
					model.setEmerCntcPhnNoCtnt(emerCntcPhnNoCtnt[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (imdgSubsRskLblRmk[i] != null)
					model.setImdgSubsRskLblRmk(imdgSubsRskLblRmk[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spclStwgRqstDesc[i] != null)
					model.setSpclStwgRqstDesc(spclStwgRqstDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (outImdgPckCd1[i] != null)
					model.setOutImdgPckCd1(outImdgPckCd1[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgLmtQtyFlg[i] != null)
					model.setImdgLmtQtyFlg(imdgLmtQtyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgDgCgoforEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgDgCgoforEdiVO[]
	 */
	public BkgDgCgoforEdiVO[] getBkgDgCgoforEdiVOs(){
		BkgDgCgoforEdiVO[] vos = (BkgDgCgoforEdiVO[])models.toArray(new BkgDgCgoforEdiVO[models.size()]);
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
		this.emerCntcPhnNoCtnt = this.emerCntcPhnNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblRmk = this.imdgSubsRskLblRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclStwgRqstDesc = this.spclStwgRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outImdgPckCd1 = this.outImdgPckCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgLmtQtyFlg = this.imdgLmtQtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
