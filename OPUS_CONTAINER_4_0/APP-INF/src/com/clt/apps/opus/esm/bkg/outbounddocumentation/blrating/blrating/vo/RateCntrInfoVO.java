/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RateCntrInfoVO.java
*@FileTitle : RateCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.25 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RateCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RateCntrInfoVO> models = new ArrayList<RateCntrInfoVO>();
	
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String cntrDpSeq = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dcgoCnt = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String hngrFlg = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String eqSubstTpszCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RateCntrInfoVO() {}

	public RateCntrInfoVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String cntrTpszCd, String cntrDpSeq, String rcvTermCd, String deTermCd, String cntrPrtFlg, String cntrVolQty, String eqSubstTpszCd, String hngrFlg, String dcgoFlg, String bbCgoFlg, String awkCgoFlg, String rcFlg, String rdCgoFlg, String socFlg, String dcgoCnt, String flexHgtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
		this.cntrDpSeq = cntrDpSeq;
		this.rdCgoFlg = rdCgoFlg;
		this.awkCgoFlg = awkCgoFlg;
		this.pagerows = pagerows;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.dcgoCnt = dcgoCnt;
		this.bbCgoFlg = bbCgoFlg;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.hngrFlg = hngrFlg;
		this.flexHgtFlg = flexHgtFlg;
		this.rcvTermCd = rcvTermCd;
		this.rcFlg = rcFlg;
		this.cntrVolQty = cntrVolQty;
		this.eqSubstTpszCd = eqSubstTpszCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("cntr_dp_seq", getCntrDpSeq());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dcgo_cnt", getDcgoCnt());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("hngr_flg", getHngrFlg());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("eq_subst_tpsz_cd", getEqSubstTpszCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("cntr_dp_seq", "cntrDpSeq");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dcgo_cnt", "dcgoCnt");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("hngr_flg", "hngrFlg");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("eq_subst_tpsz_cd", "eqSubstTpszCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrDpSeq
	 */
	public String getCntrDpSeq() {
		return this.cntrDpSeq;
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
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return dcgoCnt
	 */
	public String getDcgoCnt() {
		return this.dcgoCnt;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return hngrFlg
	 */
	public String getHngrFlg() {
		return this.hngrFlg;
	}
	
	/**
	 * Column Info
	 * @return flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return this.flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
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
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return eqSubstTpszCd
	 */
	public String getEqSubstTpszCd() {
		return this.eqSubstTpszCd;
	}
	

	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrDpSeq
	 */
	public void setCntrDpSeq(String cntrDpSeq) {
		this.cntrDpSeq = cntrDpSeq;
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
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param dcgoCnt
	 */
	public void setDcgoCnt(String dcgoCnt) {
		this.dcgoCnt = dcgoCnt;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param hngrFlg
	 */
	public void setHngrFlg(String hngrFlg) {
		this.hngrFlg = hngrFlg;
	}
	
	/**
	 * Column Info
	 * @param flexHgtFlg
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
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
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param eqSubstTpszCd
	 */
	public void setEqSubstTpszCd(String eqSubstTpszCd) {
		this.eqSubstTpszCd = eqSubstTpszCd;
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
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setCntrDpSeq(JSPUtil.getParameter(request, prefix + "cntr_dp_seq", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSocFlg(JSPUtil.getParameter(request, prefix + "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDcgoCnt(JSPUtil.getParameter(request, prefix + "dcgo_cnt", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setHngrFlg(JSPUtil.getParameter(request, prefix + "hngr_flg", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setEqSubstTpszCd(JSPUtil.getParameter(request, prefix + "eq_subst_tpsz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RateCntrInfoVO[]
	 */
	public RateCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RateCntrInfoVO[]
	 */
	public RateCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RateCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] cntrDpSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_dp_seq", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dcgoCnt = (JSPUtil.getParameter(request, prefix	+ "dcgo_cnt", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] hngrFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_flg", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] eqSubstTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_tpsz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RateCntrInfoVO();
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (cntrDpSeq[i] != null)
					model.setCntrDpSeq(cntrDpSeq[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dcgoCnt[i] != null)
					model.setDcgoCnt(dcgoCnt[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (hngrFlg[i] != null)
					model.setHngrFlg(hngrFlg[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (eqSubstTpszCd[i] != null)
					model.setEqSubstTpszCd(eqSubstTpszCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRateCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RateCntrInfoVO[]
	 */
	public RateCntrInfoVO[] getRateCntrInfoVOs(){
		RateCntrInfoVO[] vos = (RateCntrInfoVO[])models.toArray(new RateCntrInfoVO[models.size()]);
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
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDpSeq = this.cntrDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoCnt = this.dcgoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrFlg = this.hngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstTpszCd = this.eqSubstTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
