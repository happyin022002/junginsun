/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaImportVO.java
*@FileTitle : PsaImportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier :
*@LastVersion : 1.0
* 2010.03.03
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

public class PsaImportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaImportVO> models = new ArrayList<PsaImportVO>();

	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String psaCntrTpCd = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String transTpCd = null;
	/* Column Info */
	private String opusCntrSzCd = null;
	/* Column Info */
	private String opusCntrTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String nextPod = null;
	/* Column Info */
	private String psaCntrSzCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rlyPort = null;
	/* Column Info */
	private String psaSpecial = null;
	/* Column Info */
	private String opusPortCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String opusLoad = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String psaPortCd = null;
	/* Column Info */
	private String psaLoad = null;
	/* Column Info */
	private String opusSpecial = null;

	private PsaJurongIfVO[] psaJurongIfVOs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaImportVO() {}

	public PsaImportVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String vvd, String rlyPort, String transTpCd, String etdDt, String vslNm, String userId, String opusCntrTpCd, String opusCntrSzCd, String opusPortCd, String opusSpecial, String opusLoad, String psaCntrTpCd, String psaCntrSzCd, String psaPortCd, String psaSpecial, String psaLoad, String diff, String etaDt, String nextPod, String nextVvd) {
		this.diff = diff;
		this.etaDt = etaDt;
		this.psaCntrTpCd = psaCntrTpCd;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.transTpCd = transTpCd;
		this.opusCntrSzCd = opusCntrSzCd;
		this.opusCntrTpCd = opusCntrTpCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.nextPod = nextPod;
		this.psaCntrSzCd = psaCntrSzCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rlyPort = rlyPort;
		this.psaSpecial = psaSpecial;
		this.opusPortCd = opusPortCd;
		this.cntrNo = cntrNo;
		this.opusLoad = opusLoad;
		this.userId = userId;
		this.nextVvd = nextVvd;
		this.psaPortCd = psaPortCd;
		this.psaLoad = psaLoad;
		this.opusSpecial = opusSpecial;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("psa_cntr_tp_cd", getPsaCntrTpCd());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("trans_tp_cd", getTransTpCd());
		this.hashColumns.put("opus_cntr_sz_cd", getOpusCntrSzCd());
		this.hashColumns.put("opus_cntr_tp_cd", getOpusCntrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("next_pod", getNextPod());
		this.hashColumns.put("psa_cntr_sz_cd", getPsaCntrSzCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rly_port", getRlyPort());
		this.hashColumns.put("psa_special", getPsaSpecial());
		this.hashColumns.put("opus_port_cd", getOpusPortCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("opus_load", getOpusLoad());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("psa_port_cd", getPsaPortCd());
		this.hashColumns.put("psa_load", getPsaLoad());
		this.hashColumns.put("opus_special", getOpusSpecial());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("diff", "diff");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("psa_cntr_tp_cd", "psaCntrTpCd");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("trans_tp_cd", "transTpCd");
		this.hashFields.put("opus_cntr_sz_cd", "opusCntrSzCd");
		this.hashFields.put("opus_cntr_tp_cd", "opusCntrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("next_pod", "nextPod");
		this.hashFields.put("psa_cntr_sz_cd", "psaCntrSzCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rly_port", "rlyPort");
		this.hashFields.put("psa_special", "psaSpecial");
		this.hashFields.put("opus_port_cd", "opusPortCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("opus_load", "opusLoad");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("psa_port_cd", "psaPortCd");
		this.hashFields.put("psa_load", "psaLoad");
		this.hashFields.put("opus_special", "opusSpecial");
		return this.hashFields;
	}

	/**
	 * @return the psaJurongIfVOs
	 */
	public PsaJurongIfVO[] getPsaJurongIfVOs() {
		return psaJurongIfVOs;
	}

	/**
	 * @param psaJurongIfVOs the psaJurongIfVOs to set
	 */
	public void setPsaJurongIfVOs(PsaJurongIfVO[] psaJurongIfVOs) {
		this.psaJurongIfVOs = psaJurongIfVOs;
	}

	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}

	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}

	/**
	 * Column Info
	 * @return psaCntrTpCd
	 */
	public String getPsaCntrTpCd() {
		return this.psaCntrTpCd;
	}

	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}

	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}

	/**
	 * Column Info
	 * @return transTpCd
	 */
	public String getTransTpCd() {
		return this.transTpCd;
	}

	/**
	 * Column Info
	 * @return opusCntrSzCd
	 */
	public String getOpusCntrSzCd() {
		return this.opusCntrSzCd;
	}

	/**
	 * Column Info
	 * @return opusCntrTpCd
	 */
	public String getOpusCntrTpCd() {
		return this.opusCntrTpCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}

	/**
	 * Column Info
	 * @return nextPod
	 */
	public String getNextPod() {
		return this.nextPod;
	}

	/**
	 * Column Info
	 * @return psaCntrSzCd
	 */
	public String getPsaCntrSzCd() {
		return this.psaCntrSzCd;
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
	 * @return rlyPort
	 */
	public String getRlyPort() {
		return this.rlyPort;
	}

	/**
	 * Column Info
	 * @return psaSpecial
	 */
	public String getPsaSpecial() {
		return this.psaSpecial;
	}

	/**
	 * Column Info
	 * @return opusPortCd
	 */
	public String getOpusPortCd() {
		return this.opusPortCd;
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
	 * @return opusLoad
	 */
	public String getOpusLoad() {
		return this.opusLoad;
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
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}

	/**
	 * Column Info
	 * @return psaPortCd
	 */
	public String getPsaPortCd() {
		return this.psaPortCd;
	}

	/**
	 * Column Info
	 * @return psaLoad
	 */
	public String getPsaLoad() {
		return this.psaLoad;
	}

	/**
	 * Column Info
	 * @return opusSpecial
	 */
	public String getOpusSpecial() {
		return this.opusSpecial;
	}


	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}

	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}

	/**
	 * Column Info
	 * @param psaCntrTpCd
	 */
	public void setPsaCntrTpCd(String psaCntrTpCd) {
		this.psaCntrTpCd = psaCntrTpCd;
	}

	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}

	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * Column Info
	 * @param transTpCd
	 */
	public void setTransTpCd(String transTpCd) {
		this.transTpCd = transTpCd;
	}

	/**
	 * Column Info
	 * @param opusCntrSzCd
	 */
	public void setOpusCntrSzCd(String opusCntrSzCd) {
		this.opusCntrSzCd = opusCntrSzCd;
	}

	/**
	 * Column Info
	 * @param opusCntrTpCd
	 */
	public void setOpusCntrTpCd(String opusCntrTpCd) {
		this.opusCntrTpCd = opusCntrTpCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param nextPod
	 */
	public void setNextPod(String nextPod) {
		this.nextPod = nextPod;
	}

	/**
	 * Column Info
	 * @param psaCntrSzCd
	 */
	public void setPsaCntrSzCd(String psaCntrSzCd) {
		this.psaCntrSzCd = psaCntrSzCd;
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
	 * @param rlyPort
	 */
	public void setRlyPort(String rlyPort) {
		this.rlyPort = rlyPort;
	}

	/**
	 * Column Info
	 * @param psaSpecial
	 */
	public void setPsaSpecial(String psaSpecial) {
		this.psaSpecial = psaSpecial;
	}

	/**
	 * Column Info
	 * @param opusPortCd
	 */
	public void setOpusPortCd(String opusPortCd) {
		this.opusPortCd = opusPortCd;
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
	 * @param opusLoad
	 */
	public void setOpusLoad(String opusLoad) {
		this.opusLoad = opusLoad;
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
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}

	/**
	 * Column Info
	 * @param psaPortCd
	 */
	public void setPsaPortCd(String psaPortCd) {
		this.psaPortCd = psaPortCd;
	}

	/**
	 * Column Info
	 * @param psaLoad
	 */
	public void setPsaLoad(String psaLoad) {
		this.psaLoad = psaLoad;
	}

	/**
	 * Column Info
	 * @param opusSpecial
	 */
	public void setOpusSpecial(String opusSpecial) {
		this.opusSpecial = opusSpecial;
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
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setPsaCntrTpCd(JSPUtil.getParameter(request, prefix + "psa_cntr_tp_cd", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setTransTpCd(JSPUtil.getParameter(request, prefix + "trans_tp_cd", ""));
		setOpusCntrSzCd(JSPUtil.getParameter(request, prefix + "opus_cntr_sz_cd", ""));
		setOpusCntrTpCd(JSPUtil.getParameter(request, prefix + "opus_cntr_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setNextPod(JSPUtil.getParameter(request, prefix + "next_pod", ""));
		setPsaCntrSzCd(JSPUtil.getParameter(request, prefix + "psa_cntr_sz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRlyPort(JSPUtil.getParameter(request, prefix + "rly_port", ""));
		setPsaSpecial(JSPUtil.getParameter(request, prefix + "psa_special", ""));
		setOpusPortCd(JSPUtil.getParameter(request, prefix + "opus_port_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setOpusLoad(JSPUtil.getParameter(request, prefix + "opus_load", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setNextVvd(JSPUtil.getParameter(request, prefix + "next_vvd", ""));
		setPsaPortCd(JSPUtil.getParameter(request, prefix + "psa_port_cd", ""));
		setPsaLoad(JSPUtil.getParameter(request, prefix + "psa_load", ""));
		setOpusSpecial(JSPUtil.getParameter(request, prefix + "opus_special", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaImportVO[]
	 */
	public PsaImportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaImportVO[]
	 */
	public PsaImportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaImportVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] psaCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "psa_cntr_tp_cd", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] transTpCd = (JSPUtil.getParameter(request, prefix	+ "trans_tp_cd", length));
			String[] opusCntrSzCd = (JSPUtil.getParameter(request, prefix	+ "opus_cntr_sz_cd", length));
			String[] opusCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "opus_cntr_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] nextPod = (JSPUtil.getParameter(request, prefix	+ "next_pod", length));
			String[] psaCntrSzCd = (JSPUtil.getParameter(request, prefix	+ "psa_cntr_sz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rlyPort = (JSPUtil.getParameter(request, prefix	+ "rly_port", length));
			String[] psaSpecial = (JSPUtil.getParameter(request, prefix	+ "psa_special", length));
			String[] opusPortCd = (JSPUtil.getParameter(request, prefix	+ "opus_port_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] opusLoad = (JSPUtil.getParameter(request, prefix	+ "opus_load", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] psaPortCd = (JSPUtil.getParameter(request, prefix	+ "psa_port_cd", length));
			String[] psaLoad = (JSPUtil.getParameter(request, prefix	+ "psa_load", length));
			String[] opusSpecial = (JSPUtil.getParameter(request, prefix	+ "opus_special", length));

			for (int i = 0; i < length; i++) {
				model = new PsaImportVO();
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (psaCntrTpCd[i] != null)
					model.setPsaCntrTpCd(psaCntrTpCd[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (transTpCd[i] != null)
					model.setTransTpCd(transTpCd[i]);
				if (opusCntrSzCd[i] != null)
					model.setOpusCntrSzCd(opusCntrSzCd[i]);
				if (opusCntrTpCd[i] != null)
					model.setOpusCntrTpCd(opusCntrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (nextPod[i] != null)
					model.setNextPod(nextPod[i]);
				if (psaCntrSzCd[i] != null)
					model.setPsaCntrSzCd(psaCntrSzCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rlyPort[i] != null)
					model.setRlyPort(rlyPort[i]);
				if (psaSpecial[i] != null)
					model.setPsaSpecial(psaSpecial[i]);
				if (opusPortCd[i] != null)
					model.setOpusPortCd(opusPortCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (opusLoad[i] != null)
					model.setOpusLoad(opusLoad[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (psaPortCd[i] != null)
					model.setPsaPortCd(psaPortCd[i]);
				if (psaLoad[i] != null)
					model.setPsaLoad(psaLoad[i]);
				if (opusSpecial[i] != null)
					model.setOpusSpecial(opusSpecial[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaImportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaImportVO[]
	 */
	public PsaImportVO[] getPsaImportVOs(){
		PsaImportVO[] vos = (PsaImportVO[])models.toArray(new PsaImportVO[models.size()]);
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
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaCntrTpCd = this.psaCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTpCd = this.transTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusCntrSzCd = this.opusCntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusCntrTpCd = this.opusCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPod = this.nextPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaCntrSzCd = this.psaCntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlyPort = this.rlyPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaSpecial = this.psaSpecial .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusPortCd = this.opusPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusLoad = this.opusLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaPortCd = this.psaPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaLoad = this.psaLoad .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opusSpecial = this.opusSpecial .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
