/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NisAkVO.java
*@FileTitle : NisAkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.10.26 김민정 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.11.08 김영철 [CHM-201006978-01] AK 화면의 Commodity 입력 포맷을 RF와 동일하게 수정하고 BKG 메인의 Commoidty 코드가 자동 I/F 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AlpsAkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AlpsAkVO> models = new ArrayList<AlpsAkVO>();
	
	/* Column Info */
	private String ttlDimWdt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String ttlDimHgt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String wgtUtCd2 = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String maxAwkCgoSeq = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ttlDimLen = null;
	/* Column Info */
	private String stwgRqstDesc = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String ovrLfLen = null;
	/* Column Info */
	private String ovrRtLen = null;
	/* Column Info */
	private String ovrVoidSltQty = null;
	/* Column Info */
	private String inGaFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AlpsAkVO() {}

	public AlpsAkVO(String ibflag, String pagerows, String bkgNo, String awkCgoSeq, String cntrNo, String cntrTpszCd, String status, String cmdtCd, String ttlDimLen, String ttlDimWdt, String ttlDimHgt, String grsWgt, String wgtUtCd, String pckQty, String pckTpCd, String netWgt, String wgtUtCd2, String stwgRqstDesc, String maxAwkCgoSeq, String cmdtNm, String ovrFwrdLen, String ovrBkwdLen, String ovrHgt, String ovrLfLen, String ovrRtLen, String ovrVoidSltQty, String inGaFlg) {
		this.ttlDimWdt = ttlDimWdt;
		this.status = status;
		this.netWgt = netWgt;
		this.awkCgoSeq = awkCgoSeq;
		this.ttlDimHgt = ttlDimHgt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.wgtUtCd2 = wgtUtCd2;
		this.cmdtCd = cmdtCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.maxAwkCgoSeq = maxAwkCgoSeq;
		this.pckQty = pckQty;
		this.ttlDimLen = ttlDimLen;
		this.stwgRqstDesc = stwgRqstDesc;
		this.pckTpCd = pckTpCd;
		this.grsWgt = grsWgt;
		this.cmdtNm = cmdtNm;
		this.ovrFwrdLen = ovrFwrdLen;
		this.ovrBkwdLen = ovrBkwdLen;
		this.ovrHgt = ovrHgt;
		this.ovrLfLen = ovrLfLen;
		this.ovrRtLen = ovrRtLen;
		this.ovrVoidSltQty = ovrVoidSltQty;
		this.inGaFlg = inGaFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_dim_wdt", getTtlDimWdt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("ttl_dim_hgt", getTtlDimHgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("wgt_ut_cd2", getWgtUtCd2());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("max_awk_cgo_seq", getMaxAwkCgoSeq());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ttl_dim_len", getTtlDimLen());
		this.hashColumns.put("stwg_rqst_desc", getStwgRqstDesc());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("ovr_lf_len", getOvrLfLen());
		this.hashColumns.put("ovr_rt_len", getOvrRtLen());
		this.hashColumns.put("ovr_void_slt_qty", getOvrVoidSltQty());
		this.hashColumns.put("in_ga_flg", getInGaFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_dim_wdt", "ttlDimWdt");
		this.hashFields.put("status", "status");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("ttl_dim_hgt", "ttlDimHgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("wgt_ut_cd2", "wgtUtCd2");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("max_awk_cgo_seq", "maxAwkCgoSeq");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ttl_dim_len", "ttlDimLen");
		this.hashFields.put("stwg_rqst_desc", "stwgRqstDesc");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("ovr_lf_len", "ovrLfLen");
		this.hashFields.put("ovr_rt_len", "ovrRtLen");
		this.hashFields.put("ovr_void_slt_qty", "ovrVoidSltQty");
		this.hashFields.put("in_ga_flg", "inGaFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ttlDimWdt
	 */
	public String getTtlDimWdt() {
		return this.ttlDimWdt;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
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
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlDimHgt
	 */
	public String getTtlDimHgt() {
		return this.ttlDimHgt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd2
	 */
	public String getWgtUtCd2() {
		return this.wgtUtCd2;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return maxAwkCgoSeq
	 */
	public String getMaxAwkCgoSeq() {
		return this.maxAwkCgoSeq;
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
	 * @return ttlDimLen
	 */
	public String getTtlDimLen() {
		return this.ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @return stwgRqstDesc
	 */
	public String getStwgRqstDesc() {
		return this.stwgRqstDesc;
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
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
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
	 * @return ovrRtLen
	 */
	public String getOvrRtLen() {
		return this.ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @return ovrVoidSltQty
	 */
	public String getOvrVoidSltQty() {
		return this.ovrVoidSltQty;
	}
	
	/**
	 * Column Info
	 * @return inGaFlg
	 */
	public String getInGaFlg() {
		return this.inGaFlg;
	}
	
	/**
	 * Column Info
	 * @param ttlDimWdt
	 */
	public void setTtlDimWdt(String ttlDimWdt) {
		this.ttlDimWdt = ttlDimWdt;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlDimHgt
	 */
	public void setTtlDimHgt(String ttlDimHgt) {
		this.ttlDimHgt = ttlDimHgt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd2
	 */
	public void setWgtUtCd2(String wgtUtCd2) {
		this.wgtUtCd2 = wgtUtCd2;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param maxAwkCgoSeq
	 */
	public void setMaxAwkCgoSeq(String maxAwkCgoSeq) {
		this.maxAwkCgoSeq = maxAwkCgoSeq;
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
	 * @param ttlDimLen
	 */
	public void setTtlDimLen(String ttlDimLen) {
		this.ttlDimLen = ttlDimLen;
	}
	
	/**
	 * Column Info
	 * @param stwgRqstDesc
	 */
	public void setStwgRqstDesc(String stwgRqstDesc) {
		this.stwgRqstDesc = stwgRqstDesc;
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
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}

	public String getCmdtNm() {
		return cmdtNm;
	}

	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
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
	 * @param ovrRtLen
	 */
	public void setOvrRtLen(String ovrRtLen) {
		this.ovrRtLen = ovrRtLen;
	}
	
	/**
	 * Column Info
	 * @param ovrVoidSltQty
	 */
	public void setOvrVoidSltQty(String ovrVoidSltQty) {
		this.ovrVoidSltQty = ovrVoidSltQty;
	}
	
	/**
	 * Column Info
	 * @param inGaFlg
	 */
	public void setInGaFlg(String inGaFlg) {
		this.inGaFlg = inGaFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTtlDimWdt(JSPUtil.getParameter(request, "ttl_dim_wdt", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setNetWgt(JSPUtil.getParameter(request, "net_wgt", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, "awk_cgo_seq", ""));
		setTtlDimHgt(JSPUtil.getParameter(request, "ttl_dim_hgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setWgtUtCd2(JSPUtil.getParameter(request, "wgt_ut_cd2", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMaxAwkCgoSeq(JSPUtil.getParameter(request, "max_awk_cgo_seq", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setTtlDimLen(JSPUtil.getParameter(request, "ttl_dim_len", ""));
		setStwgRqstDesc(JSPUtil.getParameter(request, "stwg_rqst_desc", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
		setCmdtNm(JSPUtil.getParameter(request, "cmdt_nm", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, "ovr_fwrd_len", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, "ovr_bkwd_len", ""));
		setOvrHgt(JSPUtil.getParameter(request, "ovr_hgt", ""));
		setOvrLfLen(JSPUtil.getParameter(request, "ovr_lf_len", ""));
		setOvrRtLen(JSPUtil.getParameter(request, "ovr_rt_len", ""));
		setOvrVoidSltQty(JSPUtil.getParameter(request, "ovr_void_slt_qty", ""));
		setInGaFlg(JSPUtil.getParameter(request, "in_ga_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NisAkVO[]
	 */
	public AlpsAkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NisAkVO[]
	 */
	public AlpsAkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AlpsAkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlDimWdt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_wdt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] ttlDimHgt = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_hgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] wgtUtCd2 = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd2", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] maxAwkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "max_awk_cgo_seq", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ttlDimLen = (JSPUtil.getParameter(request, prefix	+ "ttl_dim_len", length));
			String[] stwgRqstDesc = (JSPUtil.getParameter(request, prefix	+ "stwg_rqst_desc", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] ovrLfLen = (JSPUtil.getParameter(request, prefix	+ "ovr_lf_len", length));
			String[] ovrRtLen = (JSPUtil.getParameter(request, prefix	+ "ovr_rt_len", length));
			String[] ovrVoidSltQty = (JSPUtil.getParameter(request, prefix	+ "ovr_void_slt_qty", length));
			String[] inGaFlg = (JSPUtil.getParameter(request, prefix	+ "in_ga_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AlpsAkVO();
				if (ttlDimWdt[i] != null)
					model.setTtlDimWdt(ttlDimWdt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (ttlDimHgt[i] != null)
					model.setTtlDimHgt(ttlDimHgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (wgtUtCd2[i] != null)
					model.setWgtUtCd2(wgtUtCd2[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (maxAwkCgoSeq[i] != null)
					model.setMaxAwkCgoSeq(maxAwkCgoSeq[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ttlDimLen[i] != null)
					model.setTtlDimLen(ttlDimLen[i]);
				if (stwgRqstDesc[i] != null)
					model.setStwgRqstDesc(stwgRqstDesc[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (ovrLfLen[i] != null)
					model.setOvrLfLen(ovrLfLen[i]);
				if (ovrRtLen[i] != null)
					model.setOvrRtLen(ovrRtLen[i]);
				if (ovrVoidSltQty[i] != null)
					model.setOvrVoidSltQty(ovrVoidSltQty[i]);
				if (inGaFlg[i] != null)
					model.setInGaFlg(inGaFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNisAkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NisAkVO[]
	 */
	public AlpsAkVO[] getNisAkVOs(){
		AlpsAkVO[] vos = (AlpsAkVO[])models.toArray(new AlpsAkVO[models.size()]);
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
		this.ttlDimWdt = this.ttlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimHgt = this.ttlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd2 = this.wgtUtCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxAwkCgoSeq = this.maxAwkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDimLen = this.ttlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgRqstDesc = this.stwgRqstDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLfLen = this.ovrLfLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrRtLen = this.ovrRtLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrVoidSltQty = this.ovrVoidSltQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inGaFlg = this.inGaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
