/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestDetailListVO.java
*@FileTitle : ChinaManifestDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaManifestDetailListVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaManifestDetailListVO> models = new ArrayList<ChinaManifestDetailListVO>();
	
	/* Column Info */
	private String ntfy = null;
	/* Column Info */
	private String cnCmdt = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String mkDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrMeas = null;
	/* Column Info */
	private String ovrHgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String meas = null;
	/* Column Info */
	private String bl = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String hsCd = null;
	/* Column Info */
	private String ovrLfLen = null;
	/* Column Info */
	private String cntrOpt = null;
	/* Column Info */
	private String pck = null;
	/* Column Info */
	private String ovrRtLen = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String svcPvd = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String imdgClssCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChinaManifestDetailListVO() {}

	public ChinaManifestDetailListVO(String ibflag, String pagerows, String svcPvd, String bl, String por, String pol, String pod, String del, String wgt, String pck, String meas, String shpr, String cnee, String ntfy, String mkDesc, String cmdtDesc, String cstmsDesc, String cnCmdt, String hsCd, String cntrOpt, String cntrNo, String cntrTpszCd, String sealNo, String cntrWgt, String cntrMeas, String cdoTemp, String imdgClssCd, String imdgUnNo, String ovrFwrdLen, String ovrBkwdLen, String ovrHgt, String ovrLfLen, String ovrRtLen) {
		this.ntfy = ntfy;
		this.cnCmdt = cnCmdt;
		this.por = por;
		this.mkDesc = mkDesc;
		this.pagerows = pagerows;
		this.cntrMeas = cntrMeas;
		this.ovrHgt = ovrHgt;
		this.ibflag = ibflag;
		this.wgt = wgt;
		this.meas = meas;
		this.bl = bl;
		this.cstmsDesc = cstmsDesc;
		this.pol = pol;
		this.cntrTpszCd = cntrTpszCd;
		this.del = del;
		this.imdgUnNo = imdgUnNo;
		this.pod = pod;
		this.sealNo = sealNo;
		this.cntrWgt = cntrWgt;
		this.hsCd = hsCd;
		this.ovrLfLen = ovrLfLen;
		this.cntrOpt = cntrOpt;
		this.pck = pck;
		this.ovrRtLen = ovrRtLen;
		this.cdoTemp = cdoTemp;
		this.cmdtDesc = cmdtDesc;
		this.ovrBkwdLen = ovrBkwdLen;
		this.cntrNo = cntrNo;
		this.cnee = cnee;
		this.svcPvd = svcPvd;
		this.ovrFwrdLen = ovrFwrdLen;
		this.shpr = shpr;
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());
		this.hashColumns.put("cn_cmdt", getCnCmdt());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_meas", getCntrMeas());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("meas", getMeas());
		this.hashColumns.put("bl", getBl());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("hs_cd", getHsCd());
		this.hashColumns.put("ovr_lf_len", getOvrLfLen());
		this.hashColumns.put("cntr_opt", getCntrOpt());
		this.hashColumns.put("pck", getPck());
		this.hashColumns.put("ovr_rt_len", getOvrRtLen());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("svc_pvd", getSvcPvd());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svc_pvd", "svcPvd");
		this.hashFields.put("bl", "bl");
		this.hashFields.put("por", "por");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("del", "del");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("pck", "pck");
		this.hashFields.put("meas", "meas");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("cn_cmdt", "cnCmdt");
		this.hashFields.put("hs_cd", "hsCd");
		this.hashFields.put("cntr_opt", "cntrOpt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cntr_meas", "cntrMeas");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("ovr_lf_len", "ovrLfLen");
		this.hashFields.put("ovr_rt_len", "ovrRtLen");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ntfy
	 */
	public String getNtfy() {
		return this.ntfy;
	}
	
	/**
	 * Column Info
	 * @return cnCmdt
	 */
	public String getCnCmdt() {
		return this.cnCmdt;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
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
	 * @return cntrMeas
	 */
	public String getCntrMeas() {
		return this.cntrMeas;
	}
	
	/**
	 * Column Info
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
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
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return meas
	 */
	public String getMeas() {
		return this.meas;
	}
	
	/**
	 * Column Info
	 * @return bl
	 */
	public String getBl() {
		return this.bl;
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
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
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
	 * @return del
	 */
	public String getDel() {
		return this.del;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
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
	 * @return hsCd
	 */
	public String getHsCd() {
		return this.hsCd;
	}
	
	/**
	 * Column Info
	 * @return ovrLfLen
	 */
	public String getOvrLfLen() {
		return this.ovrLfLen;
	}
	
	/**
	 * Column Info
	 * @return cntrOpt
	 */
	public String getCntrOpt() {
		return this.cntrOpt;
	}
	
	/**
	 * Column Info
	 * @return pck
	 */
	public String getPck() {
		return this.pck;
	}
	
	/**
	 * Column Info
	 * @return ovrRtLen
	 */
	public String getOvrRtLen() {
		return this.ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
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
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
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
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return svcPvd
	 */
	public String getSvcPvd() {
		return this.svcPvd;
	}
	
	/**
	 * Column Info
	 * @return ovrFwrdLen
	 */
	public String getOvrFwrdLen() {
		return this.ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
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
	 * @param ntfy
	 */
	public void setNtfy(String ntfy) {
		this.ntfy = ntfy;
	}
	
	/**
	 * Column Info
	 * @param cnCmdt
	 */
	public void setCnCmdt(String cnCmdt) {
		this.cnCmdt = cnCmdt;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
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
	 * @param cntrMeas
	 */
	public void setCntrMeas(String cntrMeas) {
		this.cntrMeas = cntrMeas;
	}
	
	/**
	 * Column Info
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
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
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param meas
	 */
	public void setMeas(String meas) {
		this.meas = meas;
	}
	
	/**
	 * Column Info
	 * @param bl
	 */
	public void setBl(String bl) {
		this.bl = bl;
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
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
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
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
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
	 * @param hsCd
	 */
	public void setHsCd(String hsCd) {
		this.hsCd = hsCd;
	}
	
	/**
	 * Column Info
	 * @param ovrLfLen
	 */
	public void setOvrLfLen(String ovrLfLen) {
		this.ovrLfLen = ovrLfLen;
	}
	
	/**
	 * Column Info
	 * @param cntrOpt
	 */
	public void setCntrOpt(String cntrOpt) {
		this.cntrOpt = cntrOpt;
	}
	
	/**
	 * Column Info
	 * @param pck
	 */
	public void setPck(String pck) {
		this.pck = pck;
	}
	
	/**
	 * Column Info
	 * @param ovrRtLen
	 */
	public void setOvrRtLen(String ovrRtLen) {
		this.ovrRtLen = ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
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
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
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
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param svcPvd
	 */
	public void setSvcPvd(String svcPvd) {
		this.svcPvd = svcPvd;
	}
	
	/**
	 * Column Info
	 * @param ovrFwrdLen
	 */
	public void setOvrFwrdLen(String ovrFwrdLen) {
		this.ovrFwrdLen = ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
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
		setNtfy(JSPUtil.getParameter(request, "ntfy", ""));
		setCnCmdt(JSPUtil.getParameter(request, "cn_cmdt", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrMeas(JSPUtil.getParameter(request, "cntr_meas", ""));
		setOvrHgt(JSPUtil.getParameter(request, "ovr_hgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setMeas(JSPUtil.getParameter(request, "meas", ""));
		setBl(JSPUtil.getParameter(request, "bl", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setHsCd(JSPUtil.getParameter(request, "hs_cd", ""));
		setOvrLfLen(JSPUtil.getParameter(request, "ovr_lf_len", ""));
		setCntrOpt(JSPUtil.getParameter(request, "cntr_opt", ""));
		setPck(JSPUtil.getParameter(request, "pck", ""));
		setOvrRtLen(JSPUtil.getParameter(request, "ovr_rt_len", ""));
		setCdoTemp(JSPUtil.getParameter(request, "cdo_temp", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, "ovr_bkwd_len", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setSvcPvd(JSPUtil.getParameter(request, "svc_pvd", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, "ovr_fwrd_len", ""));
		setShpr(JSPUtil.getParameter(request, "shpr", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaManifestDetailListVO[]
	 */
	public ChinaManifestDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaManifestDetailListVO[]
	 */
	public ChinaManifestDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaManifestDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ntfy = (JSPUtil.getParameter(request, prefix	+ "ntfy", length));
			String[] cnCmdt = (JSPUtil.getParameter(request, prefix	+ "cn_cmdt", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrMeas = (JSPUtil.getParameter(request, prefix	+ "cntr_meas", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] meas = (JSPUtil.getParameter(request, prefix	+ "meas", length));
			String[] bl = (JSPUtil.getParameter(request, prefix	+ "bl", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] hsCd = (JSPUtil.getParameter(request, prefix	+ "hs_cd", length));
			String[] ovrLfLen = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_len", length));
			String[] cntrOpt = (JSPUtil.getParameter(request, prefix	+ "cntr_opt", length));
			String[] pck = (JSPUtil.getParameter(request, prefix	+ "pck", length));
			String[] ovrRtLen = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_len", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] svcPvd = (JSPUtil.getParameter(request, prefix	+ "svc_pvd", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaManifestDetailListVO();
				if (ntfy[i] != null)
					model.setNtfy(ntfy[i]);
				if (cnCmdt[i] != null)
					model.setCnCmdt(cnCmdt[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrMeas[i] != null)
					model.setCntrMeas(cntrMeas[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (meas[i] != null)
					model.setMeas(meas[i]);
				if (bl[i] != null)
					model.setBl(bl[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (hsCd[i] != null)
					model.setHsCd(hsCd[i]);
				if (ovrLfLen[i] != null)
					model.setOvrLfLen(ovrLfLen[i]);
				if (cntrOpt[i] != null)
					model.setCntrOpt(cntrOpt[i]);
				if (pck[i] != null)
					model.setPck(pck[i]);
				if (ovrRtLen[i] != null)
					model.setOvrRtLen(ovrRtLen[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (svcPvd[i] != null)
					model.setSvcPvd(svcPvd[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaManifestDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaManifestDetailListVO[]
	 */
	public ChinaManifestDetailListVO[] getChinaManifestDetailListVOs(){
		ChinaManifestDetailListVO[] vos = (ChinaManifestDetailListVO[])models.toArray(new ChinaManifestDetailListVO[models.size()]);
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
		this.ntfy = this.ntfy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCmdt = this.cnCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeas = this.cntrMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meas = this.meas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bl = this.bl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hsCd = this.hsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfLen = this.ovrLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOpt = this.cntrOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pck = this.pck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrRtLen = this.ovrRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcPvd = this.svcPvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
