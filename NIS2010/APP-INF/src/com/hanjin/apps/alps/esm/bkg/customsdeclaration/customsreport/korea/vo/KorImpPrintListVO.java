/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorImpPrintListVO.java
*@FileTitle : KorImpPrintListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.17 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ImpPrintListVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see ImpPrintListVO
 */

public class KorImpPrintListVO extends ImpPrintListVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorImpPrintListVO> models = new ArrayList<KorImpPrintListVO>();
	
	/* Column Info */
	private String loc2Info = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String nCustInfo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrInfo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String mrnBlTsCd = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String loc1Info = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String totWgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cCustInfo = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String whNm = null;
	/* Column Info */
	private String custInfo = null;
	/* Column Info */
	private String sCustInfo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorImpPrintListVO() {}

	public KorImpPrintListVO(String ibflag, String pagerows, String vslEngNm, String skdVoyNo, String mrnNo, String cgoTpCd, String loc1Info, String loc2Info, String vpsEtbDt, String msnNo, String blTpCd, String blNo, String cntrInfo, String cstmsDesc, String pckQty, String totWgt, String imdgUnNo, String whNm, String callSgnNo, String cntNm, String bkgCustTpCd, String custInfo, String cCustInfo, String nCustInfo, String sCustInfo, String mrnBlTsCd, String vpsEtdDt) {
		this.loc2Info = loc2Info;
		this.vpsEtbDt = vpsEtbDt;
		this.cgoTpCd = cgoTpCd;
		this.msnNo = msnNo;
		this.nCustInfo = nCustInfo;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.cntrInfo = cntrInfo;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.vslEngNm = vslEngNm;
		this.cstmsDesc = cstmsDesc;
		this.pckQty = pckQty;
		this.mrnBlTsCd = mrnBlTsCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.imdgUnNo = imdgUnNo;
		this.loc1Info = loc1Info;
		this.vpsEtdDt = vpsEtdDt;
		this.callSgnNo = callSgnNo;
		this.totWgt = totWgt;
		this.skdVoyNo = skdVoyNo;
		this.cCustInfo = cCustInfo;
		this.blTpCd = blTpCd;
		this.whNm = whNm;
		this.custInfo = custInfo;
		this.sCustInfo = sCustInfo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc2_info", getLoc2Info());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("n_cust_info", getNCustInfo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_info", getCntrInfo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("mrn_bl_ts_cd", getMrnBlTsCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("loc1_info", getLoc1Info());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("tot_wgt", getTotWgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("c_cust_info", getCCustInfo());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("wh_nm", getWhNm());
		this.hashColumns.put("cust_info", getCustInfo());
		this.hashColumns.put("s_cust_info", getSCustInfo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc2_info", "loc2Info");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("n_cust_info", "nCustInfo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_info", "cntrInfo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("mrn_bl_ts_cd", "mrnBlTsCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("loc1_info", "loc1Info");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("tot_wgt", "totWgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("c_cust_info", "cCustInfo");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("wh_nm", "whNm");
		this.hashFields.put("cust_info", "custInfo");
		this.hashFields.put("s_cust_info", "sCustInfo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return loc2Info
	 */
	public String getLoc2Info() {
		return this.loc2Info;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
	}
	
	/**
	 * Column Info
	 * @return nCustInfo
	 */
	public String getNCustInfo() {
		return this.nCustInfo;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return cntrInfo
	 */
	public String getCntrInfo() {
		return this.cntrInfo;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return mrnBlTsCd
	 */
	public String getMrnBlTsCd() {
		return this.mrnBlTsCd;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return loc1Info
	 */
	public String getLoc1Info() {
		return this.loc1Info;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return totWgt
	 */
	public String getTotWgt() {
		return this.totWgt;
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
	 * @return cCustInfo
	 */
	public String getCCustInfo() {
		return this.cCustInfo;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return whNm
	 */
	public String getWhNm() {
		return this.whNm;
	}
	
	/**
	 * Column Info
	 * @return custInfo
	 */
	public String getCustInfo() {
		return this.custInfo;
	}
	
	/**
	 * Column Info
	 * @return sCustInfo
	 */
	public String getSCustInfo() {
		return this.sCustInfo;
	}
	

	/**
	 * Column Info
	 * @param loc2Info
	 */
	public void setLoc2Info(String loc2Info) {
		this.loc2Info = loc2Info;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
	}
	
	/**
	 * Column Info
	 * @param nCustInfo
	 */
	public void setNCustInfo(String nCustInfo) {
		this.nCustInfo = nCustInfo;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param cntrInfo
	 */
	public void setCntrInfo(String cntrInfo) {
		this.cntrInfo = cntrInfo;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param mrnBlTsCd
	 */
	public void setMrnBlTsCd(String mrnBlTsCd) {
		this.mrnBlTsCd = mrnBlTsCd;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param loc1Info
	 */
	public void setLoc1Info(String loc1Info) {
		this.loc1Info = loc1Info;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param totWgt
	 */
	public void setTotWgt(String totWgt) {
		this.totWgt = totWgt;
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
	 * @param cCustInfo
	 */
	public void setCCustInfo(String cCustInfo) {
		this.cCustInfo = cCustInfo;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param whNm
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
	}
	
	/**
	 * Column Info
	 * @param custInfo
	 */
	public void setCustInfo(String custInfo) {
		this.custInfo = custInfo;
	}
	
	/**
	 * Column Info
	 * @param sCustInfo
	 */
	public void setSCustInfo(String sCustInfo) {
		this.sCustInfo = sCustInfo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLoc2Info(JSPUtil.getParameter(request, "loc2_info", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
		setMsnNo(JSPUtil.getParameter(request, "msn_no", ""));
		setNCustInfo(JSPUtil.getParameter(request, "n_cust_info", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrInfo(JSPUtil.getParameter(request, "cntr_info", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setMrnBlTsCd(JSPUtil.getParameter(request, "mrn_bl_ts_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setLoc1Info(JSPUtil.getParameter(request, "loc1_info", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setTotWgt(JSPUtil.getParameter(request, "tot_wgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCCustInfo(JSPUtil.getParameter(request, "c_cust_info", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setWhNm(JSPUtil.getParameter(request, "wh_nm", ""));
		setCustInfo(JSPUtil.getParameter(request, "cust_info", ""));
		setSCustInfo(JSPUtil.getParameter(request, "s_cust_info", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorImpPrintListVO[]
	 */
	public KorImpPrintListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorImpPrintListVO[]
	 */
	public KorImpPrintListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorImpPrintListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] loc2Info = (JSPUtil.getParameter(request, prefix	+ "loc2_info", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] nCustInfo = (JSPUtil.getParameter(request, prefix	+ "n_cust_info", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrInfo = (JSPUtil.getParameter(request, prefix	+ "cntr_info", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] mrnBlTsCd = (JSPUtil.getParameter(request, prefix	+ "mrn_bl_ts_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] loc1Info = (JSPUtil.getParameter(request, prefix	+ "loc1_info", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] totWgt = (JSPUtil.getParameter(request, prefix	+ "tot_wgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cCustInfo = (JSPUtil.getParameter(request, prefix	+ "c_cust_info", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] whNm = (JSPUtil.getParameter(request, prefix	+ "wh_nm", length));
			String[] custInfo = (JSPUtil.getParameter(request, prefix	+ "cust_info", length));
			String[] sCustInfo = (JSPUtil.getParameter(request, prefix	+ "s_cust_info", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorImpPrintListVO();
				if (loc2Info[i] != null)
					model.setLoc2Info(loc2Info[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (nCustInfo[i] != null)
					model.setNCustInfo(nCustInfo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrInfo[i] != null)
					model.setCntrInfo(cntrInfo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (mrnBlTsCd[i] != null)
					model.setMrnBlTsCd(mrnBlTsCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (loc1Info[i] != null)
					model.setLoc1Info(loc1Info[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (totWgt[i] != null)
					model.setTotWgt(totWgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cCustInfo[i] != null)
					model.setCCustInfo(cCustInfo[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (whNm[i] != null)
					model.setWhNm(whNm[i]);
				if (custInfo[i] != null)
					model.setCustInfo(custInfo[i]);
				if (sCustInfo[i] != null)
					model.setSCustInfo(sCustInfo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorImpPrintListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorImpPrintListVO[]
	 */
	public KorImpPrintListVO[] getKorImpPrintListVOs(){
		KorImpPrintListVO[] vos = (KorImpPrintListVO[])models.toArray(new KorImpPrintListVO[models.size()]);
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
		this.loc2Info = this.loc2Info .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustInfo = this.nCustInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrInfo = this.cntrInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnBlTsCd = this.mrnBlTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc1Info = this.loc1Info .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt = this.totWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustInfo = this.cCustInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whNm = this.whNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custInfo = this.custInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustInfo = this.sCustInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
