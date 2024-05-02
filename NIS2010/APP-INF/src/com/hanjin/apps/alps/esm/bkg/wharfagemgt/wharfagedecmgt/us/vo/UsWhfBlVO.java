/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWhfBlVO.java
*@FileTitle : UsWhfBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.14
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.14 김민정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsWhfBlVO extends WhfBlVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsWhfBlVO> models = new ArrayList<UsWhfBlVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usaWhfTrspTpCd = null;
	/* Column Info */
	private String whfUtPrc = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String usaWhfExptFlg = null;
	/* Column Info */
	private String ft45 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String orgDestLocCd = null;
	/* Column Info */
	private String partial = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String ft40 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String usaWhfRatUtCd = null;
	/* Column Info */
	private String ft20 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String steCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsWhfBlVO() {}

	public UsWhfBlVO(String ibflag, String pagerows, String blNo, String ioBndCd, String cntrNo, String fullMtyCd, String cstmsDesc, String usaWhfExptFlg, String orgDestLocCd, String usaWhfTrspTpCd, String term, String ft20, String ft40, String ft45, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String cntrTpszCd, String usaWhfRatUtCd, String ratAsQty, String whfUtPrc, String creUsrId, String steCd, String crrCd, String bkgNo, String partial) {
		this.vslCd = vslCd;
		this.blNo = blNo;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.usaWhfTrspTpCd = usaWhfTrspTpCd;
		this.whfUtPrc = whfUtPrc;
		this.cstmsDesc = cstmsDesc;
		this.cntrTpszCd = cntrTpszCd;
		this.portCd = portCd;
		this.usaWhfExptFlg = usaWhfExptFlg;
		this.ft45 = ft45;
		this.skdVoyNo = skdVoyNo;
		this.orgDestLocCd = orgDestLocCd;
		this.partial = partial;
		this.ioBndCd = ioBndCd;
		this.ft40 = ft40;
		this.skdDirCd = skdDirCd;
		this.usaWhfRatUtCd = usaWhfRatUtCd;
		this.ft20 = ft20;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.term = term;
		this.cntrNo = cntrNo;
		this.fullMtyCd = fullMtyCd;
		this.ratAsQty = ratAsQty;
		this.steCd = steCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usa_whf_trsp_tp_cd", getUsaWhfTrspTpCd());
		this.hashColumns.put("whf_ut_prc", getWhfUtPrc());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("usa_whf_expt_flg", getUsaWhfExptFlg());
		this.hashColumns.put("ft45", getFt45());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("org_dest_loc_cd", getOrgDestLocCd());
		this.hashColumns.put("partial", getPartial());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ft40", getFt40());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("usa_whf_rat_ut_cd", getUsaWhfRatUtCd());
		this.hashColumns.put("ft20", getFt20());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("ste_cd", getSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usa_whf_trsp_tp_cd", "usaWhfTrspTpCd");
		this.hashFields.put("whf_ut_prc", "whfUtPrc");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("usa_whf_expt_flg", "usaWhfExptFlg");
		this.hashFields.put("ft45", "ft45");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("org_dest_loc_cd", "orgDestLocCd");
		this.hashFields.put("partial", "partial");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ft40", "ft40");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("usa_whf_rat_ut_cd", "usaWhfRatUtCd");
		this.hashFields.put("ft20", "ft20");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("term", "term");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("ste_cd", "steCd");
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return usaWhfTrspTpCd
	 */
	public String getUsaWhfTrspTpCd() {
		return this.usaWhfTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return whfUtPrc
	 */
	public String getWhfUtPrc() {
		return this.whfUtPrc;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return usaWhfExptFlg
	 */
	public String getUsaWhfExptFlg() {
		return this.usaWhfExptFlg;
	}
	
	/**
	 * Column Info
	 * @return ft45
	 */
	public String getFt45() {
		return this.ft45;
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
	 * @return orgDestLocCd
	 */
	public String getOrgDestLocCd() {
		return this.orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return partial
	 */
	public String getPartial() {
		return this.partial;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return ft40
	 */
	public String getFt40() {
		return this.ft40;
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
	 * @return usaWhfRatUtCd
	 */
	public String getUsaWhfRatUtCd() {
		return this.usaWhfRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return ft20
	 */
	public String getFt20() {
		return this.ft20;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param usaWhfTrspTpCd
	 */
	public void setUsaWhfTrspTpCd(String usaWhfTrspTpCd) {
		this.usaWhfTrspTpCd = usaWhfTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param whfUtPrc
	 */
	public void setWhfUtPrc(String whfUtPrc) {
		this.whfUtPrc = whfUtPrc;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param usaWhfExptFlg
	 */
	public void setUsaWhfExptFlg(String usaWhfExptFlg) {
		this.usaWhfExptFlg = usaWhfExptFlg;
	}
	
	/**
	 * Column Info
	 * @param ft45
	 */
	public void setFt45(String ft45) {
		this.ft45 = ft45;
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
	 * @param orgDestLocCd
	 */
	public void setOrgDestLocCd(String orgDestLocCd) {
		this.orgDestLocCd = orgDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param partial
	 */
	public void setPartial(String partial) {
		this.partial = partial;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param ft40
	 */
	public void setFt40(String ft40) {
		this.ft40 = ft40;
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
	 * @param usaWhfRatUtCd
	 */
	public void setUsaWhfRatUtCd(String usaWhfRatUtCd) {
		this.usaWhfRatUtCd = usaWhfRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param ft20
	 */
	public void setFt20(String ft20) {
		this.ft20 = ft20;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsaWhfTrspTpCd(JSPUtil.getParameter(request, "usa_whf_trsp_tp_cd", ""));
		setWhfUtPrc(JSPUtil.getParameter(request, "whf_ut_prc", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUsaWhfExptFlg(JSPUtil.getParameter(request, "usa_whf_expt_flg", ""));
		setFt45(JSPUtil.getParameter(request, "ft45", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setOrgDestLocCd(JSPUtil.getParameter(request, "org_dest_loc_cd", ""));
		setPartial(JSPUtil.getParameter(request, "partial", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setFt40(JSPUtil.getParameter(request, "ft40", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setUsaWhfRatUtCd(JSPUtil.getParameter(request, "usa_whf_rat_ut_cd", ""));
		setFt20(JSPUtil.getParameter(request, "ft20", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setTerm(JSPUtil.getParameter(request, "term", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
		setRatAsQty(JSPUtil.getParameter(request, "rat_as_qty", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsWhfBlVO[]
	 */
	public UsWhfBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsWhfBlVO[]
	 */
	public UsWhfBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsWhfBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usaWhfTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "usa_whf_trsp_tp_cd", length));
			String[] whfUtPrc = (JSPUtil.getParameter(request, prefix	+ "whf_ut_prc", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] usaWhfExptFlg = (JSPUtil.getParameter(request, prefix	+ "usa_whf_expt_flg", length));
			String[] ft45 = (JSPUtil.getParameter(request, prefix	+ "ft45", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] orgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_loc_cd", length));
			String[] partial = (JSPUtil.getParameter(request, prefix	+ "partial", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] ft40 = (JSPUtil.getParameter(request, prefix	+ "ft40", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] usaWhfRatUtCd = (JSPUtil.getParameter(request, prefix	+ "usa_whf_rat_ut_cd", length));
			String[] ft20 = (JSPUtil.getParameter(request, prefix	+ "ft20", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsWhfBlVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usaWhfTrspTpCd[i] != null)
					model.setUsaWhfTrspTpCd(usaWhfTrspTpCd[i]);
				if (whfUtPrc[i] != null)
					model.setWhfUtPrc(whfUtPrc[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (usaWhfExptFlg[i] != null)
					model.setUsaWhfExptFlg(usaWhfExptFlg[i]);
				if (ft45[i] != null)
					model.setFt45(ft45[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (orgDestLocCd[i] != null)
					model.setOrgDestLocCd(orgDestLocCd[i]);
				if (partial[i] != null)
					model.setPartial(partial[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (ft40[i] != null)
					model.setFt40(ft40[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (usaWhfRatUtCd[i] != null)
					model.setUsaWhfRatUtCd(usaWhfRatUtCd[i]);
				if (ft20[i] != null)
					model.setFt20(ft20[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsWhfBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsWhfBlVO[]
	 */
	public UsWhfBlVO[] getUsWhfBlVOs(){
		UsWhfBlVO[] vos = (UsWhfBlVO[])models.toArray(new UsWhfBlVO[models.size()]);
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
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfTrspTpCd = this.usaWhfTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfUtPrc = this.whfUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfExptFlg = this.usaWhfExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft45 = this.ft45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestLocCd = this.orgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partial = this.partial .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft40 = this.ft40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaWhfRatUtCd = this.usaWhfRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft20 = this.ft20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
