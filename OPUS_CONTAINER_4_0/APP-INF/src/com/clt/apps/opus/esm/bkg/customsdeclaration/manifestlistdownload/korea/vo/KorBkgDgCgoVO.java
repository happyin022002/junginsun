/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorBkgDgCgoVO.java
*@FileTitle : KorBkgDgCgoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.07
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.06.07 김민정
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBkgDgCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorBkgDgCgoVO> models = new ArrayList<KorBkgDgCgoVO>();

	/* Column Info */
	private String ibSeq = null;
	/* Column Info */
	private String calcWeight = null;
	/* Column Info */
	private String job = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String netWeight = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String substance = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String certiNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String jcInd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String mfSeqNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgUnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorBkgDgCgoVO() {}

	public KorBkgDgCgoVO(String ibflag, String pagerows, String bkgNo, String cstmsDeclTpCd, String ibSeq, String ioBndCd, String mrnNo, String cntrNo, String imdgUnNo, String mfSeqNo, String vvd, String polCd, String podCd, String imdgClssCd, String imdgCompGrpCd, String certiNo, String job, String blNo, String substance, String netWeight, String calcWeight, String jcInd, String prpShpNm) {
		this.ibSeq = ibSeq;
		this.calcWeight = calcWeight;
		this.job = job;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.netWeight = netWeight;
		this.vvd = vvd;
		this.podCd = podCd;
		this.substance = substance;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.certiNo = certiNo;
		this.cntrNo = cntrNo;
		this.jcInd = jcInd;
		this.prpShpNm = prpShpNm;
		this.mfSeqNo = mfSeqNo;
		this.imdgClssCd = imdgClssCd;
		this.imdgUnNo = imdgUnNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_seq", getIbSeq());
		this.hashColumns.put("calc_weight", getCalcWeight());
		this.hashColumns.put("job", getJob());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("net_weight", getNetWeight());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("substance", getSubstance());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("certi_no", getCertiNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("jc_ind", getJcInd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("mf_seq_no", getMfSeqNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_seq", "ibSeq");
		this.hashFields.put("calc_weight", "calcWeight");
		this.hashFields.put("job", "job");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("net_weight", "netWeight");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("substance", "substance");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("certi_no", "certiNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("jc_ind", "jcInd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("mf_seq_no", "mfSeqNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return ibSeq
	 */
	public String getIbSeq() {
		return this.ibSeq;
	}

	/**
	 * Column Info
	 * @return calcWeight
	 */
	public String getCalcWeight() {
		return this.calcWeight;
	}

	/**
	 * Column Info
	 * @return job
	 */
	public String getJob() {
		return this.job;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return netWeight
	 */
	public String getNetWeight() {
		return this.netWeight;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}

	/**
	 * Column Info
	 * @return substance
	 */
	public String getSubstance() {
		return this.substance;
	}

	/**
	 * Column Info
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @return certiNo
	 */
	public String getCertiNo() {
		return this.certiNo;
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
	 * @return jcInd
	 */
	public String getJcInd() {
		return this.jcInd;
	}

	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}

	/**
	 * Column Info
	 * @return mfSeqNo
	 */
	public String getMfSeqNo() {
		return this.mfSeqNo;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}


	/**
	 * Column Info
	 * @param ibSeq
	 */
	public void setIbSeq(String ibSeq) {
		this.ibSeq = ibSeq;
	}

	/**
	 * Column Info
	 * @param calcWeight
	 */
	public void setCalcWeight(String calcWeight) {
		this.calcWeight = calcWeight;
	}

	/**
	 * Column Info
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param netWeight
	 */
	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * Column Info
	 * @param substance
	 */
	public void setSubstance(String substance) {
		this.substance = substance;
	}

	/**
	 * Column Info
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @param certiNo
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
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
	 * @param jcInd
	 */
	public void setJcInd(String jcInd) {
		this.jcInd = jcInd;
	}

	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}

	/**
	 * Column Info
	 * @param mfSeqNo
	 */
	public void setMfSeqNo(String mfSeqNo) {
		this.mfSeqNo = mfSeqNo;
	}

	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
		setIbSeq(JSPUtil.getParameter(request, prefix + "ib_seq", ""));
		setCalcWeight(JSPUtil.getParameter(request, prefix + "calc_weight", ""));
		setJob(JSPUtil.getParameter(request, prefix + "job", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNetWeight(JSPUtil.getParameter(request, prefix + "net_weight", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSubstance(JSPUtil.getParameter(request, prefix + "substance", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setCertiNo(JSPUtil.getParameter(request, prefix + "certi_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setJcInd(JSPUtil.getParameter(request, prefix + "jc_ind", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setMfSeqNo(JSPUtil.getParameter(request, prefix + "mf_seq_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBkgDgCgoVO[]
	 */
	public KorBkgDgCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorBkgDgCgoVO[]
	 */
	public KorBkgDgCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBkgDgCgoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibSeq = (JSPUtil.getParameter(request, prefix	+ "ib_seq", length));
			String[] calcWeight = (JSPUtil.getParameter(request, prefix	+ "calc_weight", length));
			String[] job = (JSPUtil.getParameter(request, prefix	+ "job", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] netWeight = (JSPUtil.getParameter(request, prefix	+ "net_weight", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] substance = (JSPUtil.getParameter(request, prefix	+ "substance", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] certiNo = (JSPUtil.getParameter(request, prefix	+ "certi_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] jcInd = (JSPUtil.getParameter(request, prefix	+ "jc_ind", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] mfSeqNo = (JSPUtil.getParameter(request, prefix	+ "mf_seq_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));

			for (int i = 0; i < length; i++) {
				model = new KorBkgDgCgoVO();
				if (ibSeq[i] != null)
					model.setIbSeq(ibSeq[i]);
				if (calcWeight[i] != null)
					model.setCalcWeight(calcWeight[i]);
				if (job[i] != null)
					model.setJob(job[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (netWeight[i] != null)
					model.setNetWeight(netWeight[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (substance[i] != null)
					model.setSubstance(substance[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (certiNo[i] != null)
					model.setCertiNo(certiNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (jcInd[i] != null)
					model.setJcInd(jcInd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (mfSeqNo[i] != null)
					model.setMfSeqNo(mfSeqNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBkgDgCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBkgDgCgoVO[]
	 */
	public KorBkgDgCgoVO[] getKorBkgDgCgoVOs(){
		KorBkgDgCgoVO[] vos = (KorBkgDgCgoVO[])models.toArray(new KorBkgDgCgoVO[models.size()]);
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
		this.ibSeq = this.ibSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcWeight = this.calcWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.job = this.job .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWeight = this.netWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substance = this.substance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiNo = this.certiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jcInd = this.jcInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSeqNo = this.mfSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
