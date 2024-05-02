/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestCllDgByCntrUnInfoVO.java
*@FileTitle : CLLCDLManifestCllDgByCntrUnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.10 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestCllDgByCntrUnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CLLCDLManifestCllDgByCntrUnInfoVO> models = new ArrayList<CLLCDLManifestCllDgByCntrUnInfoVO>();
	
	/* Column Info */
	private String grsWgtCd = null;
	/* Column Info */
	private String emerCntcPhnNoCtnt = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String imdgPgNo = null;
	/* Column Info */
	private String imdgSubsRskLblCd = null;
	/* Column Info */
	private String netWgtCd = null;
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
	private String measQty = null;
	/* Column Info */
	private String hzdDesc = null;
	/* Column Info */
	private String tmlPckUtId = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String measQtyCd = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String dgCntrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CLLCDLManifestCllDgByCntrUnInfoVO() {}

	public CLLCDLManifestCllDgByCntrUnInfoVO(String ibflag, String pagerows, String imdgUnNo, String imdgClssCd, String prpShpNm, String emerCntcPhnNoCtnt, String imdgPgNo, String diffRmk, String emsNo, String imdgPckGrpCd, String mrnPolutFlg, String imdgSubsRskLblCd, String pckQty, String tmlPckUtId, String netWgt, String netWgtCd, String grsWgt, String grsWgtCd, String measQty, String measQtyCd, String hzdDesc, String spclStwgRqstDesc, String dgCntrSeq) {
		this.grsWgtCd = grsWgtCd;
		this.emerCntcPhnNoCtnt = emerCntcPhnNoCtnt;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.netWgt = netWgt;
		this.imdgPgNo = imdgPgNo;
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
		this.netWgtCd = netWgtCd;
		this.emsNo = emsNo;
		this.pagerows = pagerows;
		this.spclStwgRqstDesc = spclStwgRqstDesc;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.measQty = measQty;
		this.hzdDesc = hzdDesc;
		this.tmlPckUtId = tmlPckUtId;
		this.pckQty = pckQty;
		this.prpShpNm = prpShpNm;
		this.measQtyCd = measQtyCd;
		this.mrnPolutFlg = mrnPolutFlg;
		this.grsWgt = grsWgt;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.dgCntrSeq = dgCntrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grs_wgt_cd", getGrsWgtCd());
		this.hashColumns.put("emer_cntc_phn_no_ctnt", getEmerCntcPhnNoCtnt());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("imdg_pg_no", getImdgPgNo());
		this.hashColumns.put("imdg_subs_rsk_lbl_cd", getImdgSubsRskLblCd());
		this.hashColumns.put("net_wgt_cd", getNetWgtCd());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("spcl_stwg_rqst_desc", getSpclStwgRqstDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("hzd_desc", getHzdDesc());
		this.hashColumns.put("tml_pck_ut_id", getTmlPckUtId());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("meas_qty_cd", getMeasQtyCd());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grs_wgt_cd", "grsWgtCd");
		this.hashFields.put("emer_cntc_phn_no_ctnt", "emerCntcPhnNoCtnt");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("imdg_pg_no", "imdgPgNo");
		this.hashFields.put("imdg_subs_rsk_lbl_cd", "imdgSubsRskLblCd");
		this.hashFields.put("net_wgt_cd", "netWgtCd");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spcl_stwg_rqst_desc", "spclStwgRqstDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("hzd_desc", "hzdDesc");
		this.hashFields.put("tml_pck_ut_id", "tmlPckUtId");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("meas_qty_cd", "measQtyCd");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grsWgtCd
	 */
	public String getGrsWgtCd() {
		return this.grsWgtCd;
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
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
	}
	
	/**
	 * Column Info
	 * @return imdgPgNo
	 */
	public String getImdgPgNo() {
		return this.imdgPgNo;
	}
	
	/**
	 * Column Info
	 * @return imdgSubsRskLblCd
	 */
	public String getImdgSubsRskLblCd() {
		return this.imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @return netWgtCd
	 */
	public String getNetWgtCd() {
		return this.netWgtCd;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return tmlPckUtId
	 */
	public String getTmlPckUtId() {
		return this.tmlPckUtId;
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
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return measQtyCd
	 */
	public String getMeasQtyCd() {
		return this.measQtyCd;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @param grsWgtCd
	 */
	public void setGrsWgtCd(String grsWgtCd) {
		this.grsWgtCd = grsWgtCd;
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
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
	}
	
	/**
	 * Column Info
	 * @param imdgPgNo
	 */
	public void setImdgPgNo(String imdgPgNo) {
		this.imdgPgNo = imdgPgNo;
	}
	
	/**
	 * Column Info
	 * @param imdgSubsRskLblCd
	 */
	public void setImdgSubsRskLblCd(String imdgSubsRskLblCd) {
		this.imdgSubsRskLblCd = imdgSubsRskLblCd;
	}
	
	/**
	 * Column Info
	 * @param netWgtCd
	 */
	public void setNetWgtCd(String netWgtCd) {
		this.netWgtCd = netWgtCd;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param tmlPckUtId
	 */
	public void setTmlPckUtId(String tmlPckUtId) {
		this.tmlPckUtId = tmlPckUtId;
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
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param measQtyCd
	 */
	public void setMeasQtyCd(String measQtyCd) {
		this.measQtyCd = measQtyCd;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
	
	public String getDgCntrSeq() {
		return dgCntrSeq;
	}

	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGrsWgtCd(JSPUtil.getParameter(request, "grs_wgt_cd", ""));
		setEmerCntcPhnNoCtnt(JSPUtil.getParameter(request, "emer_cntc_phn_no_ctnt", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, "imdg_pck_grp_cd", ""));
		setNetWgt(JSPUtil.getParameter(request, "net_wgt", ""));
		setImdgPgNo(JSPUtil.getParameter(request, "imdg_pg_no", ""));
		setImdgSubsRskLblCd(JSPUtil.getParameter(request, "imdg_subs_rsk_lbl_cd", ""));
		setNetWgtCd(JSPUtil.getParameter(request, "net_wgt_cd", ""));
		setEmsNo(JSPUtil.getParameter(request, "ems_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSpclStwgRqstDesc(JSPUtil.getParameter(request, "spcl_stwg_rqst_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setHzdDesc(JSPUtil.getParameter(request, "hzd_desc", ""));
		setTmlPckUtId(JSPUtil.getParameter(request, "tml_pck_ut_id", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setMeasQtyCd(JSPUtil.getParameter(request, "meas_qty_cd", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, "mrn_polut_flg", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, "dg_cntr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestCllDgByCntrUnInfoVO[]
	 */
	public CLLCDLManifestCllDgByCntrUnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestCllDgByCntrUnInfoVO[]
	 */
	public CLLCDLManifestCllDgByCntrUnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestCllDgByCntrUnInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grsWgtCd = (JSPUtil.getParameter(request, prefix	+ "grs_wgt_cd", length));
			String[] emerCntcPhnNoCtnt = (JSPUtil.getParameter(request, prefix	+ "emer_cntc_phn_no_ctnt", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] imdgPgNo = (JSPUtil.getParameter(request, prefix	+ "imdg_pg_no", length));
			String[] imdgSubsRskLblCd = (JSPUtil.getParameter(request, prefix	+ "imdg_subs_rsk_lbl_cd", length));
			String[] netWgtCd = (JSPUtil.getParameter(request, prefix	+ "net_wgt_cd", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spclStwgRqstDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_stwg_rqst_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] hzdDesc = (JSPUtil.getParameter(request, prefix	+ "hzd_desc", length));
			String[] tmlPckUtId = (JSPUtil.getParameter(request, prefix	+ "tml_pck_ut_id", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] measQtyCd = (JSPUtil.getParameter(request, prefix	+ "meas_qty_cd", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestCllDgByCntrUnInfoVO();
				if (grsWgtCd[i] != null)
					model.setGrsWgtCd(grsWgtCd[i]);
				if (emerCntcPhnNoCtnt[i] != null)
					model.setEmerCntcPhnNoCtnt(emerCntcPhnNoCtnt[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (imdgPgNo[i] != null)
					model.setImdgPgNo(imdgPgNo[i]);
				if (imdgSubsRskLblCd[i] != null)
					model.setImdgSubsRskLblCd(imdgSubsRskLblCd[i]);
				if (netWgtCd[i] != null)
					model.setNetWgtCd(netWgtCd[i]);
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
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (hzdDesc[i] != null)
					model.setHzdDesc(hzdDesc[i]);
				if (tmlPckUtId[i] != null)
					model.setTmlPckUtId(tmlPckUtId[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (measQtyCd[i] != null)
					model.setMeasQtyCd(measQtyCd[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestCllDgByCntrUnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestCllDgByCntrUnInfoVO[]
	 */
	public CLLCDLManifestCllDgByCntrUnInfoVO[] getCLLCDLManifestCllDgByCntrUnInfoVOs(){
		CLLCDLManifestCllDgByCntrUnInfoVO[] vos = (CLLCDLManifestCllDgByCntrUnInfoVO[])models.toArray(new CLLCDLManifestCllDgByCntrUnInfoVO[models.size()]);
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
		this.grsWgtCd = this.grsWgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emerCntcPhnNoCtnt = this.emerCntcPhnNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPgNo = this.imdgPgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgSubsRskLblCd = this.imdgSubsRskLblCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtCd = this.netWgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclStwgRqstDesc = this.spclStwgRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hzdDesc = this.hzdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlPckUtId = this.tmlPckUtId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQtyCd = this.measQtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
