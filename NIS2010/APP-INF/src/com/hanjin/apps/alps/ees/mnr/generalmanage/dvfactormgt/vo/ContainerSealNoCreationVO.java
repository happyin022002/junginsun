/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSealNoCreationVO.java
*@FileTitle : ContainerSealNoCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.29
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.11.29 김상수 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ContainerSealNoCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ContainerSealNoCreationVO> models = new ArrayList<ContainerSealNoCreationVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String updChk2 = null;
	/* Column Info */
	private String sealNoPfxNm = null;
	/* Column Info */
	private String n1stSerRngSealNo = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String frYear = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sealKndNm = null;
	/* Column Info */
	private String plnMonth = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String updChk = null;
	/* Column Info */
	private String cntrSealLostQty = null;
	/* Column Info */
	private String sealNoPfxNm0 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String plnQty = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lstSerRngSealNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ContainerSealNoCreationVO() {}

	public ContainerSealNoCreationVO(String ibflag, String pagerows, String cntrSealLostQty, String creDt, String creUsrId, String frYear, String lstSerRngSealNo, String n1stSerRngSealNo, String ofcCd, String plnMonth, String plnQty, String plnSeq, String plnYrmon, String rmk, String sealKndNm, String sealNoPfxNm, String sealNoPfxNm0, String updChk, String updChk2, String updDt, String updUsrId, String vndrNm, String vndrSeq) {
		this.updDt = updDt;
		this.rmk = rmk;
		this.updChk2 = updChk2;
		this.sealNoPfxNm = sealNoPfxNm;
		this.n1stSerRngSealNo = n1stSerRngSealNo;
		this.plnYrmon = plnYrmon;
		this.frYear = frYear;
		this.creDt = creDt;
		this.sealKndNm = sealKndNm;
		this.plnMonth = plnMonth;
		this.plnSeq = plnSeq;
		this.updChk = updChk;
		this.cntrSealLostQty = cntrSealLostQty;
		this.sealNoPfxNm0 = sealNoPfxNm0;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.plnQty = plnQty;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.lstSerRngSealNo = lstSerRngSealNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("upd_chk2", getUpdChk2());
		this.hashColumns.put("seal_no_pfx_nm", getSealNoPfxNm());
		this.hashColumns.put("n1st_ser_rng_seal_no", getN1stSerRngSealNo());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("fr_year", getFrYear());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("seal_knd_nm", getSealKndNm());
		this.hashColumns.put("pln_month", getPlnMonth());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("upd_chk", getUpdChk());
		this.hashColumns.put("cntr_seal_lost_qty", getCntrSealLostQty());
		this.hashColumns.put("seal_no_pfx_nm0", getSealNoPfxNm0());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("pln_qty", getPlnQty());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("lst_ser_rng_seal_no", getLstSerRngSealNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("upd_chk2", "updChk2");
		this.hashFields.put("seal_no_pfx_nm", "sealNoPfxNm");
		this.hashFields.put("n1st_ser_rng_seal_no", "n1stSerRngSealNo");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("fr_year", "frYear");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("seal_knd_nm", "sealKndNm");
		this.hashFields.put("pln_month", "plnMonth");
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("upd_chk", "updChk");
		this.hashFields.put("cntr_seal_lost_qty", "cntrSealLostQty");
		this.hashFields.put("seal_no_pfx_nm0", "sealNoPfxNm0");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("pln_qty", "plnQty");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("lst_ser_rng_seal_no", "lstSerRngSealNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return updChk2
	 */
	public String getUpdChk2() {
		return this.updChk2;
	}
	
	/**
	 * Column Info
	 * @return sealNoPfxNm
	 */
	public String getSealNoPfxNm() {
		return this.sealNoPfxNm;
	}
	
	/**
	 * Column Info
	 * @return n1stSerRngSealNo
	 */
	public String getN1stSerRngSealNo() {
		return this.n1stSerRngSealNo;
	}
	
	/**
	 * Column Info
	 * @return plnYrmon
	 */
	public String getPlnYrmon() {
		return this.plnYrmon;
	}
	
	/**
	 * Column Info
	 * @return frYear
	 */
	public String getFrYear() {
		return this.frYear;
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
	 * @return sealKndNm
	 */
	public String getSealKndNm() {
		return this.sealKndNm;
	}
	
	/**
	 * Column Info
	 * @return plnMonth
	 */
	public String getPlnMonth() {
		return this.plnMonth;
	}
	
	/**
	 * Column Info
	 * @return plnSeq
	 */
	public String getPlnSeq() {
		return this.plnSeq;
	}
	
	/**
	 * Column Info
	 * @return updChk
	 */
	public String getUpdChk() {
		return this.updChk;
	}
	
	/**
	 * Column Info
	 * @return cntrSealLostQty
	 */
	public String getCntrSealLostQty() {
		return this.cntrSealLostQty;
	}
	
	/**
	 * Column Info
	 * @return sealNoPfxNm0
	 */
	public String getSealNoPfxNm0() {
		return this.sealNoPfxNm0;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return plnQty
	 */
	public String getPlnQty() {
		return this.plnQty;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lstSerRngSealNo
	 */
	public String getLstSerRngSealNo() {
		return this.lstSerRngSealNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param updChk2
	 */
	public void setUpdChk2(String updChk2) {
		this.updChk2 = updChk2;
	}
	
	/**
	 * Column Info
	 * @param sealNoPfxNm
	 */
	public void setSealNoPfxNm(String sealNoPfxNm) {
		this.sealNoPfxNm = sealNoPfxNm;
	}
	
	/**
	 * Column Info
	 * @param n1stSerRngSealNo
	 */
	public void setN1stSerRngSealNo(String n1stSerRngSealNo) {
		this.n1stSerRngSealNo = n1stSerRngSealNo;
	}
	
	/**
	 * Column Info
	 * @param plnYrmon
	 */
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	
	/**
	 * Column Info
	 * @param frYear
	 */
	public void setFrYear(String frYear) {
		this.frYear = frYear;
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
	 * @param sealKndNm
	 */
	public void setSealKndNm(String sealKndNm) {
		this.sealKndNm = sealKndNm;
	}
	
	/**
	 * Column Info
	 * @param plnMonth
	 */
	public void setPlnMonth(String plnMonth) {
		this.plnMonth = plnMonth;
	}
	
	/**
	 * Column Info
	 * @param plnSeq
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}
	
	/**
	 * Column Info
	 * @param updChk
	 */
	public void setUpdChk(String updChk) {
		this.updChk = updChk;
	}
	
	/**
	 * Column Info
	 * @param cntrSealLostQty
	 */
	public void setCntrSealLostQty(String cntrSealLostQty) {
		this.cntrSealLostQty = cntrSealLostQty;
	}
	
	/**
	 * Column Info
	 * @param sealNoPfxNm0
	 */
	public void setSealNoPfxNm0(String sealNoPfxNm0) {
		this.sealNoPfxNm0 = sealNoPfxNm0;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param plnQty
	 */
	public void setPlnQty(String plnQty) {
		this.plnQty = plnQty;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lstSerRngSealNo
	 */
	public void setLstSerRngSealNo(String lstSerRngSealNo) {
		this.lstSerRngSealNo = lstSerRngSealNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setUpdChk2(JSPUtil.getParameter(request, prefix + "upd_chk2", ""));
		setSealNoPfxNm(JSPUtil.getParameter(request, prefix + "seal_no_pfx_nm", ""));
		setN1stSerRngSealNo(JSPUtil.getParameter(request, prefix + "n1st_ser_rng_seal_no", ""));
		setPlnYrmon(JSPUtil.getParameter(request, prefix + "pln_yrmon", ""));
		setFrYear(JSPUtil.getParameter(request, prefix + "fr_year", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSealKndNm(JSPUtil.getParameter(request, prefix + "seal_knd_nm", ""));
		setPlnMonth(JSPUtil.getParameter(request, prefix + "pln_month", ""));
		setPlnSeq(JSPUtil.getParameter(request, prefix + "pln_seq", ""));
		setUpdChk(JSPUtil.getParameter(request, prefix + "upd_chk", ""));
		setCntrSealLostQty(JSPUtil.getParameter(request, prefix + "cntr_seal_lost_qty", ""));
		setSealNoPfxNm0(JSPUtil.getParameter(request, prefix + "seal_no_pfx_nm0", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setPlnQty(JSPUtil.getParameter(request, prefix + "pln_qty", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLstSerRngSealNo(JSPUtil.getParameter(request, prefix + "lst_ser_rng_seal_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerSealNoCreationVO[]
	 */
	public ContainerSealNoCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerSealNoCreationVO[]
	 */
	public ContainerSealNoCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ContainerSealNoCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] updChk2 = (JSPUtil.getParameter(request, prefix	+ "upd_chk2", length));
			String[] sealNoPfxNm = (JSPUtil.getParameter(request, prefix	+ "seal_no_pfx_nm", length));
			String[] n1stSerRngSealNo = (JSPUtil.getParameter(request, prefix	+ "n1st_ser_rng_seal_no", length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon", length));
			String[] frYear = (JSPUtil.getParameter(request, prefix	+ "fr_year", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sealKndNm = (JSPUtil.getParameter(request, prefix	+ "seal_knd_nm", length));
			String[] plnMonth = (JSPUtil.getParameter(request, prefix	+ "pln_month", length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq", length));
			String[] updChk = (JSPUtil.getParameter(request, prefix	+ "upd_chk", length));
			String[] cntrSealLostQty = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_lost_qty", length));
			String[] sealNoPfxNm0 = (JSPUtil.getParameter(request, prefix	+ "seal_no_pfx_nm0", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] plnQty = (JSPUtil.getParameter(request, prefix	+ "pln_qty", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lstSerRngSealNo = (JSPUtil.getParameter(request, prefix	+ "lst_ser_rng_seal_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ContainerSealNoCreationVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (updChk2[i] != null)
					model.setUpdChk2(updChk2[i]);
				if (sealNoPfxNm[i] != null)
					model.setSealNoPfxNm(sealNoPfxNm[i]);
				if (n1stSerRngSealNo[i] != null)
					model.setN1stSerRngSealNo(n1stSerRngSealNo[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnYrmon[i]);
				if (frYear[i] != null)
					model.setFrYear(frYear[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sealKndNm[i] != null)
					model.setSealKndNm(sealKndNm[i]);
				if (plnMonth[i] != null)
					model.setPlnMonth(plnMonth[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (updChk[i] != null)
					model.setUpdChk(updChk[i]);
				if (cntrSealLostQty[i] != null)
					model.setCntrSealLostQty(cntrSealLostQty[i]);
				if (sealNoPfxNm0[i] != null)
					model.setSealNoPfxNm0(sealNoPfxNm0[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (plnQty[i] != null)
					model.setPlnQty(plnQty[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lstSerRngSealNo[i] != null)
					model.setLstSerRngSealNo(lstSerRngSealNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getContainerSealNoCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ContainerSealNoCreationVO[]
	 */
	public ContainerSealNoCreationVO[] getContainerSealNoCreationVOs(){
		ContainerSealNoCreationVO[] vos = (ContainerSealNoCreationVO[])models.toArray(new ContainerSealNoCreationVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updChk2 = this.updChk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoPfxNm = this.sealNoPfxNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stSerRngSealNo = this.n1stSerRngSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frYear = this.frYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealKndNm = this.sealKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnMonth = this.plnMonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updChk = this.updChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealLostQty = this.cntrSealLostQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoPfxNm0 = this.sealNoPfxNm0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnQty = this.plnQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstSerRngSealNo = this.lstSerRngSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
