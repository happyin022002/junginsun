/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaSrlNoVO.java
*@FileTitle : PsaSrlNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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

public class PsaSrlNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaSrlNoVO> models = new ArrayList<PsaSrlNoVO>();

	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String pbcCntrHeight = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String psaSerNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ovrHgtFlg = null;
	/* Column Info */
	private String rcTemp = null;
	/* Column Info */
	private String pbcCntrTp = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String ovrLenFlg = null;
	/* Column Info */
	private String ovrWdtFlg = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String ydCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaSrlNoVO() {}

	public PsaSrlNoVO(String ibflag, String pagerows, String psaSerNo, String bkgNo, String bkgSeq, String cntrTpszCd, String dcgoFlg, String rcFlg, String rdCgoFlg, String ovrHgtFlg, String ovrWdtFlg, String ovrLenFlg, String rcTemp, String pbcCntrHeight, String pbcCntrTp, String ydCd) {
		this.rdCgoFlg = rdCgoFlg;
		this.pbcCntrHeight = pbcCntrHeight;
		this.pagerows = pagerows;
		this.bkgSeq = bkgSeq;
		this.ibflag = ibflag;
		this.psaSerNo = psaSerNo;
		this.bkgNo = bkgNo;
		this.ovrHgtFlg = ovrHgtFlg;
		this.rcTemp = rcTemp;
		this.pbcCntrTp = pbcCntrTp;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.ovrLenFlg = ovrLenFlg;
		this.ovrWdtFlg = ovrWdtFlg;
		this.rcFlg = rcFlg;
		this.ydCd = ydCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("pbc_cntr_height", getPbcCntrHeight());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("psa_ser_no", getPsaSerNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ovr_hgt_flg", getOvrHgtFlg());
		this.hashColumns.put("rc_temp", getRcTemp());
		this.hashColumns.put("pbc_cntr_tp", getPbcCntrTp());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("ovr_len_flg", getOvrLenFlg());
		this.hashColumns.put("ovr_wdt_flg", getOvrWdtFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("yd_cd", getYdCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("pbc_cntr_height", "pbcCntrHeight");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("psa_ser_no", "psaSerNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ovr_hgt_flg", "ovrHgtFlg");
		this.hashFields.put("rc_temp", "rcTemp");
		this.hashFields.put("pbc_cntr_tp", "pbcCntrTp");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("ovr_len_flg", "ovrLenFlg");
		this.hashFields.put("ovr_wdt_flg", "ovrWdtFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("yd_cd", "ydCd");
		return this.hashFields;
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
	 * @return pbcCntrHeight
	 */
	public String getPbcCntrHeight() {
		return this.pbcCntrHeight;
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
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
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
	 * @return psaSerNo
	 */
	public String getPsaSerNo() {
		return this.psaSerNo;
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
	 * @return ovrHgtFlg
	 */
	public String getOvrHgtFlg() {
		return this.ovrHgtFlg;
	}

	/**
	 * Column Info
	 * @return rcTemp
	 */
	public String getRcTemp() {
		return this.rcTemp;
	}

	/**
	 * Column Info
	 * @return pbcCntrTp
	 */
	public String getPbcCntrTp() {
		return this.pbcCntrTp;
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
	 * @return ovrLenFlg
	 */
	public String getOvrLenFlg() {
		return this.ovrLenFlg;
	}

	/**
	 * Column Info
	 * @return ovrWdtFlg
	 */
	public String getOvrWdtFlg() {
		return this.ovrWdtFlg;
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
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}

	/**
	 * Column Info
	 * @param pbcCntrHeight
	 */
	public void setPbcCntrHeight(String pbcCntrHeight) {
		this.pbcCntrHeight = pbcCntrHeight;
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
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
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
	 * @param psaSerNo
	 */
	public void setPsaSerNo(String psaSerNo) {
		this.psaSerNo = psaSerNo;
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
	 * @param ovrHgtFlg
	 */
	public void setOvrHgtFlg(String ovrHgtFlg) {
		this.ovrHgtFlg = ovrHgtFlg;
	}

	/**
	 * Column Info
	 * @param rcTemp
	 */
	public void setRcTemp(String rcTemp) {
		this.rcTemp = rcTemp;
	}

	/**
	 * Column Info
	 * @param pbcCntrTp
	 */
	public void setPbcCntrTp(String pbcCntrTp) {
		this.pbcCntrTp = pbcCntrTp;
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
	 * @param ovrLenFlg
	 */
	public void setOvrLenFlg(String ovrLenFlg) {
		this.ovrLenFlg = ovrLenFlg;
	}

	/**
	 * Column Info
	 * @param ovrWdtFlg
	 */
	public void setOvrWdtFlg(String ovrWdtFlg) {
		this.ovrWdtFlg = ovrWdtFlg;
	}

	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}

/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setPbcCntrHeight(JSPUtil.getParameter(request, prefix + "pbc_cntr_height", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPsaSerNo(JSPUtil.getParameter(request, prefix + "psa_ser_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOvrHgtFlg(JSPUtil.getParameter(request, prefix + "ovr_hgt_flg", ""));
		setRcTemp(JSPUtil.getParameter(request, prefix + "rc_temp", ""));
		setPbcCntrTp(JSPUtil.getParameter(request, prefix + "pbc_cntr_tp", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setOvrLenFlg(JSPUtil.getParameter(request, prefix + "ovr_len_flg", ""));
		setOvrWdtFlg(JSPUtil.getParameter(request, prefix + "ovr_wdt_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaSrlNoVO[]
	 */
	public PsaSrlNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaSrlNoVO[]
	 */
	public PsaSrlNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaSrlNoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] pbcCntrHeight = (JSPUtil.getParameter(request, prefix	+ "pbc_cntr_height", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] psaSerNo = (JSPUtil.getParameter(request, prefix	+ "psa_ser_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ovrHgtFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt_flg", length));
			String[] rcTemp = (JSPUtil.getParameter(request, prefix	+ "rc_temp", length));
			String[] pbcCntrTp = (JSPUtil.getParameter(request, prefix	+ "pbc_cntr_tp", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] ovrLenFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_len_flg", length));
			String[] ovrWdtFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_wdt_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));

			for (int i = 0; i < length; i++) {
				model = new PsaSrlNoVO();
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (pbcCntrHeight[i] != null)
					model.setPbcCntrHeight(pbcCntrHeight[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (psaSerNo[i] != null)
					model.setPsaSerNo(psaSerNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ovrHgtFlg[i] != null)
					model.setOvrHgtFlg(ovrHgtFlg[i]);
				if (rcTemp[i] != null)
					model.setRcTemp(rcTemp[i]);
				if (pbcCntrTp[i] != null)
					model.setPbcCntrTp(pbcCntrTp[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (ovrLenFlg[i] != null)
					model.setOvrLenFlg(ovrLenFlg[i]);
				if (ovrWdtFlg[i] != null)
					model.setOvrWdtFlg(ovrWdtFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaSrlNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaSrlNoVO[]
	 */
	public PsaSrlNoVO[] getPsaSrlNoVOs(){
		PsaSrlNoVO[] vos = (PsaSrlNoVO[])models.toArray(new PsaSrlNoVO[models.size()]);
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
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pbcCntrHeight = this.pbcCntrHeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaSerNo = this.psaSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgtFlg = this.ovrHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcTemp = this.rcTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pbcCntrTp = this.pbcCntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLenFlg = this.ovrLenFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWdtFlg = this.ovrWdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
