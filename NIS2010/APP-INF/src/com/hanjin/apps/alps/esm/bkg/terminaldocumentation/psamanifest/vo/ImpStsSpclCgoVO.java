/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ImpStsSpclCgoVO.java
*@FileTitle : ImpStsSpclCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.10 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ImpStsSpclCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ImpStsSpclCgoVO> models = new ArrayList<ImpStsSpclCgoVO>();
	
	/* Column Info */
	private String ovrRtDimWdt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String ovrDimHgt = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String dchgOvrSzFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovrLfDimWdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dimWdt = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dimLen = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String ovrBakDimLen = null;
	/* Column Info */
	private String ldIns2 = null;
	/* Column Info */
	private String ldIns3 = null;
	/* Column Info */
	private String ldIns1 = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String dimHgt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cgoDesc = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ovrFntDimLen = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String typeCd = null;
	/* Column Info */
	private String dirDeFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ImpStsSpclCgoVO() {}

	public ImpStsSpclCgoVO(String ibflag, String pagerows, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String rfFlg, String ovrDimHgt, String ovrFntDimLen, String ovrBakDimLen, String ovrLfDimWdt, String ovrRtDimWdt, String dimLen, String dimWdt, String dimHgt, String cgoDesc, String cmdtDesc, String ldIns1, String ldIns2, String ldIns3, String dchgOvrSzFlg, String dirDeFlg, String userId, String vslCd, String skdVoyNo, String skdDirCd, String bkgNo, String typeCd, String cntrNo) {
		this.ovrRtDimWdt = ovrRtDimWdt;
		this.vslCd = vslCd;
		this.rfFlg = rfFlg;
		this.ovrDimHgt = ovrDimHgt;
		this.rdCgoFlg = rdCgoFlg;
		this.dchgOvrSzFlg = dchgOvrSzFlg;
		this.pagerows = pagerows;
		this.ovrLfDimWdt = ovrLfDimWdt;
		this.ibflag = ibflag;
		this.dimWdt = dimWdt;
		this.bbCgoFlg = bbCgoFlg;
		this.dimLen = dimLen;
		this.dcgoFlg = dcgoFlg;
		this.userId = userId;
		this.ovrBakDimLen = ovrBakDimLen;
		this.ldIns2 = ldIns2;
		this.ldIns3 = ldIns3;
		this.ldIns1 = ldIns1;
		this.awkCgoFlg = awkCgoFlg;
		this.dimHgt = dimHgt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.cgoDesc = cgoDesc;
		this.bkgNo = bkgNo;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.ovrFntDimLen = ovrFntDimLen;
		this.rcFlg = rcFlg;
		this.typeCd = typeCd;
		this.dirDeFlg = dirDeFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ovr_rt_dim_wdt", getOvrRtDimWdt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("ovr_dim_hgt", getOvrDimHgt());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("dchg_ovr_sz_flg", getDchgOvrSzFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovr_lf_dim_wdt", getOvrLfDimWdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dim_wdt", getDimWdt());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dim_len", getDimLen());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("ovr_bak_dim_len", getOvrBakDimLen());
		this.hashColumns.put("ld_ins2", getLdIns2());
		this.hashColumns.put("ld_ins3", getLdIns3());
		this.hashColumns.put("ld_ins1", getLdIns1());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("dim_hgt", getDimHgt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cgo_desc", getCgoDesc());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ovr_fnt_dim_len", getOvrFntDimLen());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("type_cd", getTypeCd());
		this.hashColumns.put("dir_de_flg", getDirDeFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ovr_rt_dim_wdt", "ovrRtDimWdt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("ovr_dim_hgt", "ovrDimHgt");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("dchg_ovr_sz_flg", "dchgOvrSzFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovr_lf_dim_wdt", "ovrLfDimWdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dim_wdt", "dimWdt");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dim_len", "dimLen");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("ovr_bak_dim_len", "ovrBakDimLen");
		this.hashFields.put("ld_ins2", "ldIns2");
		this.hashFields.put("ld_ins3", "ldIns3");
		this.hashFields.put("ld_ins1", "ldIns1");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("dim_hgt", "dimHgt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cgo_desc", "cgoDesc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ovr_fnt_dim_len", "ovrFntDimLen");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("dir_de_flg", "dirDeFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ovrRtDimWdt
	 */
	public String getOvrRtDimWdt() {
		return this.ovrRtDimWdt;
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
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}
	
	/**
	 * Column Info
	 * @return ovrDimHgt
	 */
	public String getOvrDimHgt() {
		return this.ovrDimHgt;
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
	 * @return dchgOvrSzFlg
	 */
	public String getDchgOvrSzFlg() {
		return this.dchgOvrSzFlg;
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
	 * @return ovrLfDimWdt
	 */
	public String getOvrLfDimWdt() {
		return this.ovrLfDimWdt;
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
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return ovrBakDimLen
	 */
	public String getOvrBakDimLen() {
		return this.ovrBakDimLen;
	}
	
	/**
	 * Column Info
	 * @return ldIns2
	 */
	public String getLdIns2() {
		return this.ldIns2;
	}
	
	/**
	 * Column Info
	 * @return ldIns3
	 */
	public String getLdIns3() {
		return this.ldIns3;
	}
	
	/**
	 * Column Info
	 * @return ldIns1
	 */
	public String getLdIns1() {
		return this.ldIns1;
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
	 * @return dimHgt
	 */
	public String getDimHgt() {
		return this.dimHgt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cgoDesc
	 */
	public String getCgoDesc() {
		return this.cgoDesc;
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
	 * @return ovrFntDimLen
	 */
	public String getOvrFntDimLen() {
		return this.ovrFntDimLen;
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
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
	}
	
	/**
	 * Column Info
	 * @return dirDeFlg
	 */
	public String getDirDeFlg() {
		return this.dirDeFlg;
	}
	

	/**
	 * Column Info
	 * @param ovrRtDimWdt
	 */
	public void setOvrRtDimWdt(String ovrRtDimWdt) {
		this.ovrRtDimWdt = ovrRtDimWdt;
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
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}
	
	/**
	 * Column Info
	 * @param ovrDimHgt
	 */
	public void setOvrDimHgt(String ovrDimHgt) {
		this.ovrDimHgt = ovrDimHgt;
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
	 * @param dchgOvrSzFlg
	 */
	public void setDchgOvrSzFlg(String dchgOvrSzFlg) {
		this.dchgOvrSzFlg = dchgOvrSzFlg;
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
	 * @param ovrLfDimWdt
	 */
	public void setOvrLfDimWdt(String ovrLfDimWdt) {
		this.ovrLfDimWdt = ovrLfDimWdt;
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
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param ovrBakDimLen
	 */
	public void setOvrBakDimLen(String ovrBakDimLen) {
		this.ovrBakDimLen = ovrBakDimLen;
	}
	
	/**
	 * Column Info
	 * @param ldIns2
	 */
	public void setLdIns2(String ldIns2) {
		this.ldIns2 = ldIns2;
	}
	
	/**
	 * Column Info
	 * @param ldIns3
	 */
	public void setLdIns3(String ldIns3) {
		this.ldIns3 = ldIns3;
	}
	
	/**
	 * Column Info
	 * @param ldIns1
	 */
	public void setLdIns1(String ldIns1) {
		this.ldIns1 = ldIns1;
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
	 * @param dimHgt
	 */
	public void setDimHgt(String dimHgt) {
		this.dimHgt = dimHgt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cgoDesc
	 */
	public void setCgoDesc(String cgoDesc) {
		this.cgoDesc = cgoDesc;
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
	 * @param ovrFntDimLen
	 */
	public void setOvrFntDimLen(String ovrFntDimLen) {
		this.ovrFntDimLen = ovrFntDimLen;
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
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	
	/**
	 * Column Info
	 * @param dirDeFlg
	 */
	public void setDirDeFlg(String dirDeFlg) {
		this.dirDeFlg = dirDeFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOvrRtDimWdt(JSPUtil.getParameter(request, "ovr_rt_dim_wdt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setRfFlg(JSPUtil.getParameter(request, "rf_flg", ""));
		setOvrDimHgt(JSPUtil.getParameter(request, "ovr_dim_hgt", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setDchgOvrSzFlg(JSPUtil.getParameter(request, "dchg_ovr_sz_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOvrLfDimWdt(JSPUtil.getParameter(request, "ovr_lf_dim_wdt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDimWdt(JSPUtil.getParameter(request, "dim_wdt", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDimLen(JSPUtil.getParameter(request, "dim_len", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setOvrBakDimLen(JSPUtil.getParameter(request, "ovr_bak_dim_len", ""));
		setLdIns2(JSPUtil.getParameter(request, "ld_ins2", ""));
		setLdIns3(JSPUtil.getParameter(request, "ld_ins3", ""));
		setLdIns1(JSPUtil.getParameter(request, "ld_ins1", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setDimHgt(JSPUtil.getParameter(request, "dim_hgt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setCgoDesc(JSPUtil.getParameter(request, "cgo_desc", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOvrFntDimLen(JSPUtil.getParameter(request, "ovr_fnt_dim_len", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setTypeCd(JSPUtil.getParameter(request, "type_cd", ""));
		setDirDeFlg(JSPUtil.getParameter(request, "dir_de_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ImpStsSpclCgoVO[]
	 */
	public ImpStsSpclCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ImpStsSpclCgoVO[]
	 */
	public ImpStsSpclCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ImpStsSpclCgoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ovrRtDimWdt = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_dim_wdt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] ovrDimHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_dim_hgt", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] dchgOvrSzFlg = (JSPUtil.getParameter(request, prefix	+ "dchg_ovr_sz_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovrLfDimWdt = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_dim_wdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dimWdt = (JSPUtil.getParameter(request, prefix	+ "dim_wdt", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dimLen = (JSPUtil.getParameter(request, prefix	+ "dim_len", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] ovrBakDimLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bak_dim_len", length));
			String[] ldIns2 = (JSPUtil.getParameter(request, prefix	+ "ld_ins2", length));
			String[] ldIns3 = (JSPUtil.getParameter(request, prefix	+ "ld_ins3", length));
			String[] ldIns1 = (JSPUtil.getParameter(request, prefix	+ "ld_ins1", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] dimHgt = (JSPUtil.getParameter(request, prefix	+ "dim_hgt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cgoDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_desc", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ovrFntDimLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fnt_dim_len", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			String[] dirDeFlg = (JSPUtil.getParameter(request, prefix	+ "dir_de_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ImpStsSpclCgoVO();
				if (ovrRtDimWdt[i] != null)
					model.setOvrRtDimWdt(ovrRtDimWdt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (ovrDimHgt[i] != null)
					model.setOvrDimHgt(ovrDimHgt[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (dchgOvrSzFlg[i] != null)
					model.setDchgOvrSzFlg(dchgOvrSzFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovrLfDimWdt[i] != null)
					model.setOvrLfDimWdt(ovrLfDimWdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dimWdt[i] != null)
					model.setDimWdt(dimWdt[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dimLen[i] != null)
					model.setDimLen(dimLen[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (ovrBakDimLen[i] != null)
					model.setOvrBakDimLen(ovrBakDimLen[i]);
				if (ldIns2[i] != null)
					model.setLdIns2(ldIns2[i]);
				if (ldIns3[i] != null)
					model.setLdIns3(ldIns3[i]);
				if (ldIns1[i] != null)
					model.setLdIns1(ldIns1[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (dimHgt[i] != null)
					model.setDimHgt(dimHgt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cgoDesc[i] != null)
					model.setCgoDesc(cgoDesc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ovrFntDimLen[i] != null)
					model.setOvrFntDimLen(ovrFntDimLen[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				if (dirDeFlg[i] != null)
					model.setDirDeFlg(dirDeFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getImpStsSpclCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ImpStsSpclCgoVO[]
	 */
	public ImpStsSpclCgoVO[] getImpStsSpclCgoVOs(){
		ImpStsSpclCgoVO[] vos = (ImpStsSpclCgoVO[])models.toArray(new ImpStsSpclCgoVO[models.size()]);
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
		this.ovrRtDimWdt = this.ovrRtDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDimHgt = this.ovrDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgOvrSzFlg = this.dchgOvrSzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfDimWdt = this.ovrLfDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimWdt = this.dimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimLen = this.dimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBakDimLen = this.ovrBakDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldIns2 = this.ldIns2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldIns3 = this.ldIns3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldIns1 = this.ldIns1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dimHgt = this.dimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc = this.cgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFntDimLen = this.ovrFntDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirDeFlg = this.dirDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
