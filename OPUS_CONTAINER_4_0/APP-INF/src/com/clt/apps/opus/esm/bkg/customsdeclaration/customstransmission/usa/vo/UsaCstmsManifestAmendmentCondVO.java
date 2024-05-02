/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCstmsManifestAmendmentCondVO.java
*@FileTitle : UsaCstmsManifestAmendmentCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO
 */

public class UsaCstmsManifestAmendmentCondVO extends com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaCstmsManifestAmendmentCondVO> models = new ArrayList<UsaCstmsManifestAmendmentCondVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String sndDtFlg = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String stsDiv = null;
	/* Column Info */
	private String aiType = null;
	/* Column Info */
	private String sSndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String mblNo = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String eSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaCstmsManifestAmendmentCondVO() {}

	public UsaCstmsManifestAmendmentCondVO(String ibflag, String pagerows, String aiType, String bkgNo, String bkgOfcCd, String docUsrId, String eSndDt, String fullMtyCd, String mblNo, String obSrepCd, String podCd, String polCd, String sndDtFlg, String stsDiv, String sSndDt, String vvdCd) {
		this.bkgOfcCd = bkgOfcCd;
		this.sndDtFlg = sndDtFlg;
		this.docUsrId = docUsrId;
		this.stsDiv = stsDiv;
		this.aiType = aiType;
		this.sSndDt = sSndDt;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.mblNo = mblNo;
		this.fullMtyCd = fullMtyCd;
		this.eSndDt = eSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("snd_dt_flg", getSndDtFlg());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("sts_div", getStsDiv());
		this.hashColumns.put("ai_type", getAiType());
		this.hashColumns.put("s_snd_dt", getSSndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("mbl_no", getMblNo());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("e_snd_dt", getESndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("snd_dt_flg", "sndDtFlg");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("sts_div", "stsDiv");
		this.hashFields.put("ai_type", "aiType");
		this.hashFields.put("s_snd_dt", "sSndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("mbl_no", "mblNo");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("e_snd_dt", "eSndDt");
		return this.hashFields;
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
	 * @return sndDtFlg
	 */
	public String getSndDtFlg() {
		return this.sndDtFlg;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return stsDiv
	 */
	public String getStsDiv() {
		return this.stsDiv;
	}
	
	/**
	 * Column Info
	 * @return aiType
	 */
	public String getAiType() {
		return this.aiType;
	}
	
	/**
	 * Column Info
	 * @return sSndDt
	 */
	public String getSSndDt() {
		return this.sSndDt;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return mblNo
	 */
	public String getMblNo() {
		return this.mblNo;
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
	 * @return eSndDt
	 */
	public String getESndDt() {
		return this.eSndDt;
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
	 * @param sndDtFlg
	 */
	public void setSndDtFlg(String sndDtFlg) {
		this.sndDtFlg = sndDtFlg;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param stsDiv
	 */
	public void setStsDiv(String stsDiv) {
		this.stsDiv = stsDiv;
	}
	
	/**
	 * Column Info
	 * @param aiType
	 */
	public void setAiType(String aiType) {
		this.aiType = aiType;
	}
	
	/**
	 * Column Info
	 * @param sSndDt
	 */
	public void setSSndDt(String sSndDt) {
		this.sSndDt = sSndDt;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param mblNo
	 */
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
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
	 * @param eSndDt
	 */
	public void setESndDt(String eSndDt) {
		this.eSndDt = eSndDt;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setSndDtFlg(JSPUtil.getParameter(request, prefix + "snd_dt_flg", ""));
		setDocUsrId(JSPUtil.getParameter(request, prefix + "doc_usr_id", ""));
		setStsDiv(JSPUtil.getParameter(request, prefix + "sts_div", ""));
		setAiType(JSPUtil.getParameter(request, prefix + "ai_type", ""));
		setSSndDt(JSPUtil.getParameter(request, prefix + "s_snd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setMblNo(JSPUtil.getParameter(request, prefix + "mbl_no", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setESndDt(JSPUtil.getParameter(request, prefix + "e_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaCstmsManifestAmendmentCondVO[]
	 */
	public UsaCstmsManifestAmendmentCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaCstmsManifestAmendmentCondVO[]
	 */
	public UsaCstmsManifestAmendmentCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaCstmsManifestAmendmentCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] sndDtFlg = (JSPUtil.getParameter(request, prefix	+ "snd_dt_flg", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] stsDiv = (JSPUtil.getParameter(request, prefix	+ "sts_div", length));
			String[] aiType = (JSPUtil.getParameter(request, prefix	+ "ai_type", length));
			String[] sSndDt = (JSPUtil.getParameter(request, prefix	+ "s_snd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] mblNo = (JSPUtil.getParameter(request, prefix	+ "mbl_no", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] eSndDt = (JSPUtil.getParameter(request, prefix	+ "e_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaCstmsManifestAmendmentCondVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (sndDtFlg[i] != null)
					model.setSndDtFlg(sndDtFlg[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (stsDiv[i] != null)
					model.setStsDiv(stsDiv[i]);
				if (aiType[i] != null)
					model.setAiType(aiType[i]);
				if (sSndDt[i] != null)
					model.setSSndDt(sSndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (mblNo[i] != null)
					model.setMblNo(mblNo[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (eSndDt[i] != null)
					model.setESndDt(eSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaCstmsManifestAmendmentCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaCstmsManifestAmendmentCondVO[]
	 */
	public UsaCstmsManifestAmendmentCondVO[] getUsaCstmsManifestAmendmentCondVOs(){
		UsaCstmsManifestAmendmentCondVO[] vos = (UsaCstmsManifestAmendmentCondVO[])models.toArray(new UsaCstmsManifestAmendmentCondVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDtFlg = this.sndDtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsDiv = this.stsDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aiType = this.aiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSndDt = this.sSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblNo = this.mblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eSndDt = this.eSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
