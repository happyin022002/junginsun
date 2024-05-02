/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaBkgCntrInfoVO.java
*@FileTitle : PsaBkgCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.11
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

public class PsaBkgCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaBkgCntrInfoVO> models = new ArrayList<PsaBkgCntrInfoVO>();

	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String pbcCntrHeight = null;
	/* Column Info */
	private String psaIfCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Column Info */
	private String spclCgoDtlFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String psaSerNo = null;
	/* Column Info */
	private String ovrHgtFlg = null;
	/* Column Info */
	private String rcTemp = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pbcCntrTp = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String ovrLenFlg = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String ovrWdtFlg = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String cntrKnt = null;
	/* Column Info */
	private String humidNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaBkgCntrInfoVO() {}

	public PsaBkgCntrInfoVO(String ibflag, String pagerows, String bkgNo, String bkgSeq, String psaSerNo, String psaIfCd, String cntrTpszCd, String fullMtyCd, String dcgoFlg, String rcFlg, String rdCgoFlg, String ovrHgtFlg, String ovrWdtFlg, String ovrLenFlg, String cntrKnt, String rcTemp, String spclCgoDtlFlg, String pbcCntrHeight, String pbcCntrTp, String usrId, String humidNo) {
		this.rdCgoFlg = rdCgoFlg;
		this.pbcCntrHeight = pbcCntrHeight;
		this.psaIfCd = psaIfCd;
		this.pagerows = pagerows;
		this.bkgSeq = bkgSeq;
		this.spclCgoDtlFlg = spclCgoDtlFlg;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.psaSerNo = psaSerNo;
		this.ovrHgtFlg = ovrHgtFlg;
		this.rcTemp = rcTemp;
		this.usrId = usrId;
		this.pbcCntrTp = pbcCntrTp;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.ovrLenFlg = ovrLenFlg;
		this.fullMtyCd = fullMtyCd;
		this.ovrWdtFlg = ovrWdtFlg;
		this.rcFlg = rcFlg;
		this.cntrKnt = cntrKnt;
		this.humidNo = humidNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("pbc_cntr_height", getPbcCntrHeight());
		this.hashColumns.put("psa_if_cd", getPsaIfCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("spcl_cgo_dtl_flg", getSpclCgoDtlFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("psa_ser_no", getPsaSerNo());
		this.hashColumns.put("ovr_hgt_flg", getOvrHgtFlg());
		this.hashColumns.put("rc_temp", getRcTemp());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pbc_cntr_tp", getPbcCntrTp());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("ovr_len_flg", getOvrLenFlg());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("ovr_wdt_flg", getOvrWdtFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("cntr_knt", getCntrKnt());
		this.hashColumns.put("humid_no", getHumidNo());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("pbc_cntr_height", "pbcCntrHeight");
		this.hashFields.put("psa_if_cd", "psaIfCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("spcl_cgo_dtl_flg", "spclCgoDtlFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("psa_ser_no", "psaSerNo");
		this.hashFields.put("ovr_hgt_flg", "ovrHgtFlg");
		this.hashFields.put("rc_temp", "rcTemp");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pbc_cntr_tp", "pbcCntrTp");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("ovr_len_flg", "ovrLenFlg");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("ovr_wdt_flg", "ovrWdtFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("cntr_knt", "cntrKnt");
		this.hashFields.put("humid_no", "humidNo");

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
	 * Column Info
	 * @return psaIfCd
	 */
	public String getPsaIfCd() {
		return this.psaIfCd;
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
	 * Column Info
	 * @return spclCgoDtlFlg
	 */
	public String getSpclCgoDtlFlg() {
		return this.spclCgoDtlFlg;
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
	 * @return psaSerNo
	 */
	public String getPsaSerNo() {
		return this.psaSerNo;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
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
	 * @return cntrKnt
	 */
	public String getCntrKnt() {
		return this.cntrKnt;
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
	 * Column Info
	 * @param psaIfCd
	 */
	public void setPsaIfCd(String psaIfCd) {
		this.psaIfCd = psaIfCd;
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
	 * Column Info
	 * @param spclCgoDtlFlg
	 */
	public void setSpclCgoDtlFlg(String spclCgoDtlFlg) {
		this.spclCgoDtlFlg = spclCgoDtlFlg;
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
	 * @param psaSerNo
	 */
	public void setPsaSerNo(String psaSerNo) {
		this.psaSerNo = psaSerNo;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
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
	 * Column Info
	 * @param cntrKnt
	 */
	public void setCntrKnt(String cntrKnt) {
		this.cntrKnt = cntrKnt;
	}

	public String getHumidNo() {
		return humidNo;
	}

	public void setHumidNo(String humidNo) {
		this.humidNo = humidNo;
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
		setRdCgoFlg(JSPUtil.getParameter(request, prefix + "rd_cgo_flg", ""));
		setPbcCntrHeight(JSPUtil.getParameter(request, prefix + "pbc_cntr_height", ""));
		setPsaIfCd(JSPUtil.getParameter(request, prefix + "psa_if_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setSpclCgoDtlFlg(JSPUtil.getParameter(request, prefix + "spcl_cgo_dtl_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPsaSerNo(JSPUtil.getParameter(request, prefix + "psa_ser_no", ""));
		setOvrHgtFlg(JSPUtil.getParameter(request, prefix + "ovr_hgt_flg", ""));
		setRcTemp(JSPUtil.getParameter(request, prefix + "rc_temp", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPbcCntrTp(JSPUtil.getParameter(request, prefix + "pbc_cntr_tp", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setOvrLenFlg(JSPUtil.getParameter(request, prefix + "ovr_len_flg", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setOvrWdtFlg(JSPUtil.getParameter(request, prefix + "ovr_wdt_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setCntrKnt(JSPUtil.getParameter(request, prefix + "cntr_knt", ""));
		setHumidNo(JSPUtil.getParameter(request, prefix + "humid_no", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaBkgCntrInfoVO[]
	 */
	public PsaBkgCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaBkgCntrInfoVO[]
	 */
	public PsaBkgCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaBkgCntrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] pbcCntrHeight = (JSPUtil.getParameter(request, prefix	+ "pbc_cntr_height", length));
			String[] psaIfCd = (JSPUtil.getParameter(request, prefix	+ "psa_if_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] spclCgoDtlFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_dtl_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] psaSerNo = (JSPUtil.getParameter(request, prefix	+ "psa_ser_no", length));
			String[] ovrHgtFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt_flg", length));
			String[] rcTemp = (JSPUtil.getParameter(request, prefix	+ "rc_temp", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pbcCntrTp = (JSPUtil.getParameter(request, prefix	+ "pbc_cntr_tp", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] ovrLenFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_len_flg", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] ovrWdtFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_wdt_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] cntrKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_knt", length));
			String[] humidNo = (JSPUtil.getParameter(request, prefix	+ "humid_no", length));


			for (int i = 0; i < length; i++) {
				model = new PsaBkgCntrInfoVO();
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (pbcCntrHeight[i] != null)
					model.setPbcCntrHeight(pbcCntrHeight[i]);
				if (psaIfCd[i] != null)
					model.setPsaIfCd(psaIfCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (spclCgoDtlFlg[i] != null)
					model.setSpclCgoDtlFlg(spclCgoDtlFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (psaSerNo[i] != null)
					model.setPsaSerNo(psaSerNo[i]);
				if (ovrHgtFlg[i] != null)
					model.setOvrHgtFlg(ovrHgtFlg[i]);
				if (rcTemp[i] != null)
					model.setRcTemp(rcTemp[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pbcCntrTp[i] != null)
					model.setPbcCntrTp(pbcCntrTp[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (ovrLenFlg[i] != null)
					model.setOvrLenFlg(ovrLenFlg[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (ovrWdtFlg[i] != null)
					model.setOvrWdtFlg(ovrWdtFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (cntrKnt[i] != null)
					model.setCntrKnt(cntrKnt[i]);
				if (humidNo[i] != null)
					model.setHumidNo(humidNo[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaBkgCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaBkgCntrInfoVO[]
	 */
	public PsaBkgCntrInfoVO[] getPsaBkgCntrInfoVOs(){
		PsaBkgCntrInfoVO[] vos = (PsaBkgCntrInfoVO[])models.toArray(new PsaBkgCntrInfoVO[models.size()]);
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
		this.psaIfCd = this.psaIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDtlFlg = this.spclCgoDtlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaSerNo = this.psaSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgtFlg = this.ovrHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcTemp = this.rcTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pbcCntrTp = this.pbcCntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrLenFlg = this.ovrLenFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWdtFlg = this.ovrWdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrKnt = this.cntrKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.humidNo = this.humidNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
