/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorIbDgCgoVO.java
*@FileTitle : KorIbDgCgoVO
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

public class KorIbDgCgoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorIbDgCgoVO> models = new ArrayList<KorIbDgCgoVO>();

	/* Column Info */
	private String ibSeq = null;
	/* Column Info */
	private String job = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String sndChk = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String netWeight = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String imdgCompGrpCd = null;
	/* Column Info */
	private String substance = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String certiNo = null;
	/* Column Info */
	private String cntrSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String certiSeqNo = null;
	/* Column Info */
	private String maxVvdSeq = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String imdgUnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorIbDgCgoVO() {}

	public KorIbDgCgoVO(String ibflag, String pagerows, String ibSeq, String job, String msnNo, String sndChk, String ioBndCd, String blNo, String netWeight, String vvd, String podCd, String substance, String bkgNo, String polCd, String cstmsDeclTpCd, String certiNo, String cntrNo, String userId, String cntrSeq, String certiSeqNo, String maxVvdSeq, String imdgUnNo, String imdgClssCd, String imdgCompGrpCd) {
		this.ibSeq = ibSeq;
		this.job = job;
		this.msnNo = msnNo;
		this.sndChk = sndChk;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.netWeight = netWeight;
		this.vvd = vvd;
		this.podCd = podCd;
		this.imdgCompGrpCd = imdgCompGrpCd;
		this.substance = substance;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.cntrNo = cntrNo;
		this.certiNo = certiNo;
		this.cntrSeq = cntrSeq;
		this.userId = userId;
		this.certiSeqNo = certiSeqNo;
		this.maxVvdSeq = maxVvdSeq;
		this.imdgClssCd = imdgClssCd;
		this.imdgUnNo = imdgUnNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_seq", getIbSeq());
		this.hashColumns.put("job", getJob());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("snd_chk", getSndChk());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("net_weight", getNetWeight());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("imdg_comp_grp_cd", getImdgCompGrpCd());
		this.hashColumns.put("substance", getSubstance());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("certi_no", getCertiNo());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("certi_seq_no", getCertiSeqNo());
		this.hashColumns.put("max_vvd_seq", getMaxVvdSeq());
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
		this.hashFields.put("job", "job");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("snd_chk", "sndChk");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("net_weight", "netWeight");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("imdg_comp_grp_cd", "imdgCompGrpCd");
		this.hashFields.put("substance", "substance");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("certi_no", "certiNo");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("certi_seq_no", "certiSeqNo");
		this.hashFields.put("max_vvd_seq", "maxVvdSeq");
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
	 * @return job
	 */
	public String getJob() {
		return this.job;
	}

	/**
	 * Column Info
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
	}

	/**
	 * Column Info
	 * @return sndChk
	 */
	public String getSndChk() {
		return this.sndChk;
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
	 * @return imdgCompGrpCd
	 */
	public String getImdgCompGrpCd() {
		return this.imdgCompGrpCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
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
	 * @return certiNo
	 */
	public String getCertiNo() {
		return this.certiNo;
	}

	/**
	 * Column Info
	 * @return cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
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
	 * @return certiSeqNo
	 */
	public String getCertiSeqNo() {
		return this.certiSeqNo;
	}

	/**
	 * Column Info
	 * @return maxVvdSeq
	 */
	public String getMaxVvdSeq() {
		return this.maxVvdSeq;
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
	 * @param job
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * Column Info
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
	}

	/**
	 * Column Info
	 * @param sndChk
	 */
	public void setSndChk(String sndChk) {
		this.sndChk = sndChk;
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
	 * @param imdgCompGrpCd
	 */
	public void setImdgCompGrpCd(String imdgCompGrpCd) {
		this.imdgCompGrpCd = imdgCompGrpCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
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
	 * @param certiNo
	 */
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}

	/**
	 * Column Info
	 * @param cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
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
	 * @param certiSeqNo
	 */
	public void setCertiSeqNo(String certiSeqNo) {
		this.certiSeqNo = certiSeqNo;
	}

	/**
	 * Column Info
	 * @param maxVvdSeq
	 */
	public void setMaxVvdSeq(String maxVvdSeq) {
		this.maxVvdSeq = maxVvdSeq;
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
		setJob(JSPUtil.getParameter(request, prefix + "job", ""));
		setMsnNo(JSPUtil.getParameter(request, prefix + "msn_no", ""));
		setSndChk(JSPUtil.getParameter(request, prefix + "snd_chk", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNetWeight(JSPUtil.getParameter(request, prefix + "net_weight", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setImdgCompGrpCd(JSPUtil.getParameter(request, prefix + "imdg_comp_grp_cd", ""));
		setSubstance(JSPUtil.getParameter(request, prefix + "substance", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCertiNo(JSPUtil.getParameter(request, prefix + "certi_no", ""));
		setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCertiSeqNo(JSPUtil.getParameter(request, prefix + "certi_seq_no", ""));
		setMaxVvdSeq(JSPUtil.getParameter(request, prefix + "max_vvd_seq", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorIbDgCgoVO[]
	 */
	public KorIbDgCgoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorIbDgCgoVO[]
	 */
	public KorIbDgCgoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorIbDgCgoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibSeq = (JSPUtil.getParameter(request, prefix	+ "ib_seq", length));
			String[] job = (JSPUtil.getParameter(request, prefix	+ "job", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] sndChk = (JSPUtil.getParameter(request, prefix	+ "snd_chk", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] netWeight = (JSPUtil.getParameter(request, prefix	+ "net_weight", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] imdgCompGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_comp_grp_cd", length));
			String[] substance = (JSPUtil.getParameter(request, prefix	+ "substance", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] certiNo = (JSPUtil.getParameter(request, prefix	+ "certi_no", length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] certiSeqNo = (JSPUtil.getParameter(request, prefix	+ "certi_seq_no", length));
			String[] maxVvdSeq = (JSPUtil.getParameter(request, prefix	+ "max_vvd_seq", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));

			for (int i = 0; i < length; i++) {
				model = new KorIbDgCgoVO();
				if (ibSeq[i] != null)
					model.setIbSeq(ibSeq[i]);
				if (job[i] != null)
					model.setJob(job[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (sndChk[i] != null)
					model.setSndChk(sndChk[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (netWeight[i] != null)
					model.setNetWeight(netWeight[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (imdgCompGrpCd[i] != null)
					model.setImdgCompGrpCd(imdgCompGrpCd[i]);
				if (substance[i] != null)
					model.setSubstance(substance[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (certiNo[i] != null)
					model.setCertiNo(certiNo[i]);
				if (cntrSeq[i] != null)
					model.setCntrSeq(cntrSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (certiSeqNo[i] != null)
					model.setCertiSeqNo(certiSeqNo[i]);
				if (maxVvdSeq[i] != null)
					model.setMaxVvdSeq(maxVvdSeq[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorIbDgCgoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorIbDgCgoVO[]
	 */
	public KorIbDgCgoVO[] getKorIbDgCgoVOs(){
		KorIbDgCgoVO[] vos = (KorIbDgCgoVO[])models.toArray(new KorIbDgCgoVO[models.size()]);
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
		this.job = this.job .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndChk = this.sndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWeight = this.netWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgCompGrpCd = this.imdgCompGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substance = this.substance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiNo = this.certiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiSeqNo = this.certiSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxVvdSeq = this.maxVvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
