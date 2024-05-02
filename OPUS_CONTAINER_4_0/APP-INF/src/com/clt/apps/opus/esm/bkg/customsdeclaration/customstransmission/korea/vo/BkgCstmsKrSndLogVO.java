/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BkgCstmsKrSndLogVO.java
*@FileTitle : BkgCstmsKrSndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.30  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class BkgCstmsKrSndLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsKrSndLogVO> models = new ArrayList<BkgCstmsKrSndLogVO>();
	
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String ediSndMsgCtnt = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String trsmCxlDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String resndChk = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String teuCnt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String corrCd = null;
	/* Column Info */
	private String mfSndSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String feuCnt = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String blKnt = null;
	/* Column Info */
	private String trsmCxlTpCd = null;
	/* Column Info */
	private String trsmCxlRsnCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCstmsKrSndLogVO() {}

	public BkgCstmsKrSndLogVO(String ibflag, String pagerows, String sndDt, String ioBndCd, String blNo, String resndChk, String vvd, String podCd, String teuCnt, String ofcCd, String polCd, String inType, String subNo, String corrCd, String userId, String ktPa, String feuCnt, String blKnt, String fltFileRefNo, String trsmCxlTpCd, String trsmCxlRsnCd, String trsmCxlDesc, String mfSndSeq, String ediSndMsgCtnt) {
		this.fltFileRefNo = fltFileRefNo;
		this.ediSndMsgCtnt = ediSndMsgCtnt;
		this.sndDt = sndDt;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.trsmCxlDesc = trsmCxlDesc;
		this.pagerows = pagerows;
		this.resndChk = resndChk;
		this.vvd = vvd;
		this.podCd = podCd;
		this.teuCnt = teuCnt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.inType = inType;
		this.subNo = subNo;
		this.corrCd = corrCd;
		this.mfSndSeq = mfSndSeq;
		this.userId = userId;
		this.feuCnt = feuCnt;
		this.ktPa = ktPa;
		this.blKnt = blKnt;
		this.trsmCxlTpCd = trsmCxlTpCd;
		this.trsmCxlRsnCd = trsmCxlRsnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("edi_snd_msg_ctnt", getEdiSndMsgCtnt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("trsm_cxl_desc", getTrsmCxlDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("resnd_chk", getResndChk());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("teu_cnt", getTeuCnt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("corr_cd", getCorrCd());
		this.hashColumns.put("mf_snd_seq", getMfSndSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("feu_cnt", getFeuCnt());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("bl_knt", getBlKnt());
		this.hashColumns.put("trsm_cxl_tp_cd", getTrsmCxlTpCd());
		this.hashColumns.put("trsm_cxl_rsn_cd", getTrsmCxlRsnCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("edi_snd_msg_ctnt", "ediSndMsgCtnt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("trsm_cxl_desc", "trsmCxlDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("resnd_chk", "resndChk");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("teu_cnt", "teuCnt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("corr_cd", "corrCd");
		this.hashFields.put("mf_snd_seq", "mfSndSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("feu_cnt", "feuCnt");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("bl_knt", "blKnt");
		this.hashFields.put("trsm_cxl_tp_cd", "trsmCxlTpCd");
		this.hashFields.put("trsm_cxl_rsn_cd", "trsmCxlRsnCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @return ediSndMsgCtnt
	 */
	public String getEdiSndMsgCtnt() {
		return this.ediSndMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return trsmCxlDesc
	 */
	public String getTrsmCxlDesc() {
		return this.trsmCxlDesc;
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
	 * @return resndChk
	 */
	public String getResndChk() {
		return this.resndChk;
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
	 * @return teuCnt
	 */
	public String getTeuCnt() {
		return this.teuCnt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
	}
	
	/**
	 * Column Info
	 * @return subNo
	 */
	public String getSubNo() {
		return this.subNo;
	}
	
	/**
	 * Column Info
	 * @return corrCd
	 */
	public String getCorrCd() {
		return this.corrCd;
	}
	
	/**
	 * Column Info
	 * @return mfSndSeq
	 */
	public String getMfSndSeq() {
		return this.mfSndSeq;
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
	 * @return feuCnt
	 */
	public String getFeuCnt() {
		return this.feuCnt;
	}
	
	/**
	 * Column Info
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
	}
	
	/**
	 * Column Info
	 * @return blKnt
	 */
	public String getBlKnt() {
		return this.blKnt;
	}
	
	/**
	 * Column Info
	 * @return trsmCxlTpCd
	 */
	public String getTrsmCxlTpCd() {
		return this.trsmCxlTpCd;
	}
	
	/**
	 * Column Info
	 * @return trsmCxlRsnCd
	 */
	public String getTrsmCxlRsnCd() {
		return this.trsmCxlRsnCd;
	}
	

	/**
	 * Column Info
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @param ediSndMsgCtnt
	 */
	public void setEdiSndMsgCtnt(String ediSndMsgCtnt) {
		this.ediSndMsgCtnt = ediSndMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param trsmCxlDesc
	 */
	public void setTrsmCxlDesc(String trsmCxlDesc) {
		this.trsmCxlDesc = trsmCxlDesc;
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
	 * @param resndChk
	 */
	public void setResndChk(String resndChk) {
		this.resndChk = resndChk;
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
	 * @param teuCnt
	 */
	public void setTeuCnt(String teuCnt) {
		this.teuCnt = teuCnt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
	}
	
	/**
	 * Column Info
	 * @param subNo
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}
	
	/**
	 * Column Info
	 * @param corrCd
	 */
	public void setCorrCd(String corrCd) {
		this.corrCd = corrCd;
	}
	
	/**
	 * Column Info
	 * @param mfSndSeq
	 */
	public void setMfSndSeq(String mfSndSeq) {
		this.mfSndSeq = mfSndSeq;
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
	 * @param feuCnt
	 */
	public void setFeuCnt(String feuCnt) {
		this.feuCnt = feuCnt;
	}
	
	/**
	 * Column Info
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
	}
	
	/**
	 * Column Info
	 * @param blKnt
	 */
	public void setBlKnt(String blKnt) {
		this.blKnt = blKnt;
	}
	
	/**
	 * Column Info
	 * @param trsmCxlTpCd
	 */
	public void setTrsmCxlTpCd(String trsmCxlTpCd) {
		this.trsmCxlTpCd = trsmCxlTpCd;
	}
	
	/**
	 * Column Info
	 * @param trsmCxlRsnCd
	 */
	public void setTrsmCxlRsnCd(String trsmCxlRsnCd) {
		this.trsmCxlRsnCd = trsmCxlRsnCd;
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
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setEdiSndMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_snd_msg_ctnt", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setTrsmCxlDesc(JSPUtil.getParameter(request, prefix + "trsm_cxl_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setResndChk(JSPUtil.getParameter(request, prefix + "resnd_chk", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setTeuCnt(JSPUtil.getParameter(request, prefix + "teu_cnt", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setSubNo(JSPUtil.getParameter(request, prefix + "sub_no", ""));
		setCorrCd(JSPUtil.getParameter(request, prefix + "corr_cd", ""));
		setMfSndSeq(JSPUtil.getParameter(request, prefix + "mf_snd_seq", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setFeuCnt(JSPUtil.getParameter(request, prefix + "feu_cnt", ""));
		setKtPa(JSPUtil.getParameter(request, prefix + "kt_pa", ""));
		setBlKnt(JSPUtil.getParameter(request, prefix + "bl_knt", ""));
		setTrsmCxlTpCd(JSPUtil.getParameter(request, prefix + "trsm_cxl_tp_cd", ""));
		setTrsmCxlRsnCd(JSPUtil.getParameter(request, prefix + "trsm_cxl_rsn_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsKrSndLogVO[]
	 */
	public BkgCstmsKrSndLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsKrSndLogVO[]
	 */
	public BkgCstmsKrSndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsKrSndLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] ediSndMsgCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg_ctnt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] trsmCxlDesc = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] resndChk = (JSPUtil.getParameter(request, prefix	+ "resnd_chk", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] teuCnt = (JSPUtil.getParameter(request, prefix	+ "teu_cnt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] corrCd = (JSPUtil.getParameter(request, prefix	+ "corr_cd", length));
			String[] mfSndSeq = (JSPUtil.getParameter(request, prefix	+ "mf_snd_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] feuCnt = (JSPUtil.getParameter(request, prefix	+ "feu_cnt", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] blKnt = (JSPUtil.getParameter(request, prefix	+ "bl_knt", length));
			String[] trsmCxlTpCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_tp_cd", length));
			String[] trsmCxlRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_rsn_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsKrSndLogVO();
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (ediSndMsgCtnt[i] != null)
					model.setEdiSndMsgCtnt(ediSndMsgCtnt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (trsmCxlDesc[i] != null)
					model.setTrsmCxlDesc(trsmCxlDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (resndChk[i] != null)
					model.setResndChk(resndChk[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (teuCnt[i] != null)
					model.setTeuCnt(teuCnt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (corrCd[i] != null)
					model.setCorrCd(corrCd[i]);
				if (mfSndSeq[i] != null)
					model.setMfSndSeq(mfSndSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (feuCnt[i] != null)
					model.setFeuCnt(feuCnt[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (blKnt[i] != null)
					model.setBlKnt(blKnt[i]);
				if (trsmCxlTpCd[i] != null)
					model.setTrsmCxlTpCd(trsmCxlTpCd[i]);
				if (trsmCxlRsnCd[i] != null)
					model.setTrsmCxlRsnCd(trsmCxlRsnCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsKrSndLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsKrSndLogVO[]
	 */
	public BkgCstmsKrSndLogVO[] getBkgCstmsKrSndLogVOs(){
		BkgCstmsKrSndLogVO[] vos = (BkgCstmsKrSndLogVO[])models.toArray(new BkgCstmsKrSndLogVO[models.size()]);
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
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsgCtnt = this.ediSndMsgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlDesc = this.trsmCxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resndChk = this.resndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuCnt = this.teuCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrCd = this.corrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndSeq = this.mfSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuCnt = this.feuCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blKnt = this.blKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlTpCd = this.trsmCxlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlRsnCd = this.trsmCxlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
