/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrStowageintVO.java
*@FileTitle : CntrStowageintVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.11.27 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrStowageintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrStowageintVO> models = new ArrayList<CntrStowageintVO>();
	
	/* Column Info */
	private String bkPod = null;
	/* Column Info */
	private String cntrtsCd = null;
	/* Column Info */
	private String boundType = null;
	/* Column Info */
	private String rf = null;
	/* Column Info */
	private String bkgCgoTyCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dg = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String bb = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String hbl = null;
	/* Column Info */
	private String flg = null;
	/* Column Info */
	private String bayPod = null;
	/* Column Info */
	private String ak = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bayPol = null;
	/* Column Info */
	private String pc = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String cgoTp = null;
	/* Column Info */
	private String stwg = null;
	/* Column Info */
	private String spCntrTyCd = null;
	/* Column Info */
	private String bkPol = null;
	/* Column Info */
	private String stwgStatus = null;
	private String codRqstRsnCd = null;
	private String codRqstRsnNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrStowageintVO() {}

	public CntrStowageintVO(String ibflag, String pagerows, String seq, String cntrNo, String cntrtsCd, String flg, String bkgNo, String blNo, String bkPol, String bkPod, String bayPol, String bayPod, String stwg, String cgoTp, String dg, String bb, String ak, String rf, String pc, String vvdCd, String polCd, String boundType, String stwgStatus, String bkgOfcCd, String bkgCgoTyCd, String spCntrTyCd, String hbl,String codRqstRsnCd,String codRqstRsnNm) {
		this.bkPod = bkPod;
		this.cntrtsCd = cntrtsCd;
		this.boundType = boundType;
		this.rf = rf;
		this.bkgCgoTyCd = bkgCgoTyCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dg = dg;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.bb = bb;
		this.bkgOfcCd = bkgOfcCd;
		this.hbl = hbl;
		this.flg = flg;
		this.bayPod = bayPod;
		this.ak = ak;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.bayPol = bayPol;
		this.pc = pc;
		this.seq = seq;
		this.cgoTp = cgoTp;
		this.stwg = stwg;
		this.spCntrTyCd = spCntrTyCd;
		this.bkPol = bkPol;
		this.stwgStatus = stwgStatus;
		this.codRqstRsnCd = codRqstRsnCd;
		this.codRqstRsnNm = codRqstRsnNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bk_pod", getBkPod());
		this.hashColumns.put("cntrts_cd", getCntrtsCd());
		this.hashColumns.put("bound_type", getBoundType());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("bkg_cgo_ty_cd", getBkgCgoTyCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg", getDg());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bb", getBb());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("hbl", getHbl());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("bay_pod", getBayPod());
		this.hashColumns.put("ak", getAk());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bay_pol", getBayPol());
		this.hashColumns.put("pc", getPc());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("cgo_tp", getCgoTp());
		this.hashColumns.put("stwg", getStwg());
		this.hashColumns.put("sp_cntr_ty_cd", getSpCntrTyCd());
		this.hashColumns.put("bk_pol", getBkPol());
		this.hashColumns.put("stwg_status", getStwgStatus());
		this.hashColumns.put("cod_rqst_rsn_cd", getCodRqstRsnCd());
		this.hashColumns.put("cod_rqst_rsn_nm", getCodRqstRsnNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bk_pod", "bkPod");
		this.hashFields.put("cntrts_cd", "cntrtsCd");
		this.hashFields.put("bound_type", "boundType");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("bkg_cgo_ty_cd", "bkgCgoTyCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg", "dg");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bb", "bb");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("hbl", "hbl");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("bay_pod", "bayPod");
		this.hashFields.put("ak", "ak");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bay_pol", "bayPol");
		this.hashFields.put("pc", "pc");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cgo_tp", "cgoTp");
		this.hashFields.put("stwg", "stwg");
		this.hashFields.put("sp_cntr_ty_cd", "spCntrTyCd");
		this.hashFields.put("bk_pol", "bkPol");
		this.hashFields.put("stwg_status", "stwgStatus");
		this.hashFields.put("cod_rqst_rsn_cd", "codRqstRsnCd");
		this.hashFields.put("cod_rqst_rsn_nm", "codRqstRsnNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkPod
	 */
	public String getBkPod() {
		return this.bkPod;
	}
	
	/**
	 * Column Info
	 * @return cntrtsCd
	 */
	public String getCntrtsCd() {
		return this.cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @return boundType
	 */
	public String getBoundType() {
		return this.boundType;
	}
	
	/**
	 * Column Info
	 * @return rf
	 */
	public String getRf() {
		return this.rf;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTyCd
	 */
	public String getBkgCgoTyCd() {
		return this.bkgCgoTyCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return dg
	 */
	public String getDg() {
		return this.dg;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return bb
	 */
	public String getBb() {
		return this.bb;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return hbl
	 */
	public String getHbl() {
		return this.hbl;
	}
	
	/**
	 * Column Info
	 * @return flg
	 */
	public String getFlg() {
		return this.flg;
	}
	
	/**
	 * Column Info
	 * @return bayPod
	 */
	public String getBayPod() {
		return this.bayPod;
	}
	
	/**
	 * Column Info
	 * @return ak
	 */
	public String getAk() {
		return this.ak;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bayPol
	 */
	public String getBayPol() {
		return this.bayPol;
	}
	
	/**
	 * Column Info
	 * @return pc
	 */
	public String getPc() {
		return this.pc;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return cgoTp
	 */
	public String getCgoTp() {
		return this.cgoTp;
	}
	
	/**
	 * Column Info
	 * @return stwg
	 */
	public String getStwg() {
		return this.stwg;
	}
	
	/**
	 * Column Info
	 * @return spCntrTyCd
	 */
	public String getSpCntrTyCd() {
		return this.spCntrTyCd;
	}
	
	/**
	 * Column Info
	 * @return bkPol
	 */
	public String getBkPol() {
		return this.bkPol;
	}
	
	/**
	 * Column Info
	 * @return stwgStatus
	 */
	public String getStwgStatus() {
		return this.stwgStatus;
	}
	

	/**
	 * Column Info
	 * @param bkPod
	 */
	public void setBkPod(String bkPod) {
		this.bkPod = bkPod;
	}
	
	/**
	 * Column Info
	 * @param cntrtsCd
	 */
	public void setCntrtsCd(String cntrtsCd) {
		this.cntrtsCd = cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @param boundType
	 */
	public void setBoundType(String boundType) {
		this.boundType = boundType;
	}
	
	/**
	 * Column Info
	 * @param rf
	 */
	public void setRf(String rf) {
		this.rf = rf;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTyCd
	 */
	public void setBkgCgoTyCd(String bkgCgoTyCd) {
		this.bkgCgoTyCd = bkgCgoTyCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param dg
	 */
	public void setDg(String dg) {
		this.dg = dg;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param bb
	 */
	public void setBb(String bb) {
		this.bb = bb;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param hbl
	 */
	public void setHbl(String hbl) {
		this.hbl = hbl;
	}
	
	/**
	 * Column Info
	 * @param flg
	 */
	public void setFlg(String flg) {
		this.flg = flg;
	}
	
	/**
	 * Column Info
	 * @param bayPod
	 */
	public void setBayPod(String bayPod) {
		this.bayPod = bayPod;
	}
	
	/**
	 * Column Info
	 * @param ak
	 */
	public void setAk(String ak) {
		this.ak = ak;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bayPol
	 */
	public void setBayPol(String bayPol) {
		this.bayPol = bayPol;
	}
	
	/**
	 * Column Info
	 * @param pc
	 */
	public void setPc(String pc) {
		this.pc = pc;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param cgoTp
	 */
	public void setCgoTp(String cgoTp) {
		this.cgoTp = cgoTp;
	}
	
	/**
	 * Column Info
	 * @param stwg
	 */
	public void setStwg(String stwg) {
		this.stwg = stwg;
	}
	
	/**
	 * Column Info
	 * @param spCntrTyCd
	 */
	public void setSpCntrTyCd(String spCntrTyCd) {
		this.spCntrTyCd = spCntrTyCd;
	}
	
	/**
	 * Column Info
	 * @param bkPol
	 */
	public void setBkPol(String bkPol) {
		this.bkPol = bkPol;
	}
	
	/**
	 * Column Info
	 * @param stwgStatus
	 */
	public void setStwgStatus(String stwgStatus) {
		this.stwgStatus = stwgStatus;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkPod(JSPUtil.getParameter(request, "bk_pod", ""));
		setCntrtsCd(JSPUtil.getParameter(request, "cntrts_cd", ""));
		setBoundType(JSPUtil.getParameter(request, "bound_type", ""));
		setRf(JSPUtil.getParameter(request, "rf", ""));
		setBkgCgoTyCd(JSPUtil.getParameter(request, "bkg_cgo_ty_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDg(JSPUtil.getParameter(request, "dg", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setBb(JSPUtil.getParameter(request, "bb", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setHbl(JSPUtil.getParameter(request, "hbl", ""));
		setFlg(JSPUtil.getParameter(request, "flg", ""));
		setBayPod(JSPUtil.getParameter(request, "bay_pod", ""));
		setAk(JSPUtil.getParameter(request, "ak", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBayPol(JSPUtil.getParameter(request, "bay_pol", ""));
		setPc(JSPUtil.getParameter(request, "pc", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setCgoTp(JSPUtil.getParameter(request, "cgo_tp", ""));
		setStwg(JSPUtil.getParameter(request, "stwg", ""));
		setSpCntrTyCd(JSPUtil.getParameter(request, "sp_cntr_ty_cd", ""));
		setBkPol(JSPUtil.getParameter(request, "bk_pol", ""));
		setStwgStatus(JSPUtil.getParameter(request, "stwg_status", ""));
		setCodRqstRsnCd(JSPUtil.getParameter(request, "cod_rqst_rsn_cd", ""));
		setCodRqstRsnNm(JSPUtil.getParameter(request, "cod_rqst_rsn_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrStowageintVO[]
	 */
	public CntrStowageintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrStowageintVO[]
	 */
	public CntrStowageintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrStowageintVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkPod = (JSPUtil.getParameter(request, prefix	+ "bk_pod", length));
			String[] cntrtsCd = (JSPUtil.getParameter(request, prefix	+ "cntrts_cd", length));
			String[] boundType = (JSPUtil.getParameter(request, prefix	+ "bound_type", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] bkgCgoTyCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_ty_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dg = (JSPUtil.getParameter(request, prefix	+ "dg", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] bb = (JSPUtil.getParameter(request, prefix	+ "bb", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] hbl = (JSPUtil.getParameter(request, prefix	+ "hbl", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] bayPod = (JSPUtil.getParameter(request, prefix	+ "bay_pod", length));
			String[] ak = (JSPUtil.getParameter(request, prefix	+ "ak", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bayPol = (JSPUtil.getParameter(request, prefix	+ "bay_pol", length));
			String[] pc = (JSPUtil.getParameter(request, prefix	+ "pc", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] cgoTp = (JSPUtil.getParameter(request, prefix	+ "cgo_tp", length));
			String[] stwg = (JSPUtil.getParameter(request, prefix	+ "stwg", length));
			String[] spCntrTyCd = (JSPUtil.getParameter(request, prefix	+ "sp_cntr_ty_cd", length));
			String[] bkPol = (JSPUtil.getParameter(request, prefix	+ "bk_pol", length));
			String[] stwgStatus = (JSPUtil.getParameter(request, prefix	+ "stwg_status", length));
			String[] codRqstRsnCd = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_rsn_cd", length));
			String[] codRqstRsnNm = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_rsn_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrStowageintVO();
				if (bkPod[i] != null)
					model.setBkPod(bkPod[i]);
				if (cntrtsCd[i] != null)
					model.setCntrtsCd(cntrtsCd[i]);
				if (boundType[i] != null)
					model.setBoundType(boundType[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (bkgCgoTyCd[i] != null)
					model.setBkgCgoTyCd(bkgCgoTyCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dg[i] != null)
					model.setDg(dg[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (bb[i] != null)
					model.setBb(bb[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (hbl[i] != null)
					model.setHbl(hbl[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (bayPod[i] != null)
					model.setBayPod(bayPod[i]);
				if (ak[i] != null)
					model.setAk(ak[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bayPol[i] != null)
					model.setBayPol(bayPol[i]);
				if (pc[i] != null)
					model.setPc(pc[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (cgoTp[i] != null)
					model.setCgoTp(cgoTp[i]);
				if (stwg[i] != null)
					model.setStwg(stwg[i]);
				if (spCntrTyCd[i] != null)
					model.setSpCntrTyCd(spCntrTyCd[i]);
				if (bkPol[i] != null)
					model.setBkPol(bkPol[i]);
				if (stwgStatus[i] != null)
					model.setStwgStatus(stwgStatus[i]);
				if (codRqstRsnCd[i] != null)
					model.setCodRqstRsnCd(codRqstRsnCd[i]);
				if (codRqstRsnNm[i] != null)
					model.setCodRqstRsnNm(codRqstRsnNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrStowageintVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrStowageintVO[]
	 */
	public CntrStowageintVO[] getCntrStowageintVOs(){
		CntrStowageintVO[] vos = (CntrStowageintVO[])models.toArray(new CntrStowageintVO[models.size()]);
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
		this.bkPod = this.bkPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtsCd = this.cntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundType = this.boundType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTyCd = this.bkgCgoTyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg = this.dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb = this.bb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hbl = this.hbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPod = this.bayPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak = this.ak .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPol = this.bayPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pc = this.pc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTp = this.cgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg = this.stwg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCntrTyCd = this.spCntrTyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkPol = this.bkPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgStatus = this.stwgStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstRsnCd = this.codRqstRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstRsnNm = this.codRqstRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getCodRqstRsnCd() {
		return codRqstRsnCd;
	}

	public void setCodRqstRsnCd(String codRqstRsnCd) {
		this.codRqstRsnCd = codRqstRsnCd;
	}

	public String getCodRqstRsnNm() {
		return codRqstRsnNm;
	}

	public void setCodRqstRsnNm(String codRqstRsnNm) {
		this.codRqstRsnNm = codRqstRsnNm;
	}
}
