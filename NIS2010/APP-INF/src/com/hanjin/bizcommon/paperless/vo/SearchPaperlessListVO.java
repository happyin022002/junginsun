/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchPaperlessListVO.java
*@FileTitle : SearchPaperlessListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.paperless.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPaperlessListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPaperlessListVO> models = new ArrayList<SearchPaperlessListVO>();
	
	/* Column Info */
	private String fileUpldNm = null;
	/* Column Info */
	private String emlTitNm = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pprlEmlRcvCd = null;
	/* Column Info */
	private String sndrEml = null;
	/* Column Info */
	private String atchFilePathCtnt = null;
	/* Column Info */
	private String frCreDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String orgFileNm = null;
	/* Column Info */
	private String pprlEmlCtnt = null;
	/* Column Info */
	private String arcType = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String toCreDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchPaperlessListVO() {}

	public SearchPaperlessListVO(String ibflag, String pagerows, String arcType, String bkgNo, String blNo, String slanCd, String tVvd, String polCd, String podCd, String ofcCd, String shpr, String sndUsrId, String sndrEml, String pprlEmlCtnt, String emlTitNm, String useFlg, String fileUpldNm, String atchFilePathCtnt, String orgFileNm, String creDt, String pprlEmlRcvCd, String frCreDt, String toCreDt) {
		this.fileUpldNm = fileUpldNm;
		this.emlTitNm = emlTitNm;
		this.useFlg = useFlg;
		this.creDt = creDt;
		this.pprlEmlRcvCd = pprlEmlRcvCd;
		this.sndrEml = sndrEml;
		this.atchFilePathCtnt = atchFilePathCtnt;
		this.frCreDt = frCreDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.sndUsrId = sndUsrId;
		this.slanCd = slanCd;
		this.tVvd = tVvd;
		this.orgFileNm = orgFileNm;
		this.pprlEmlCtnt = pprlEmlCtnt;
		this.arcType = arcType;
		this.shpr = shpr;
		this.toCreDt = toCreDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_upld_nm", getFileUpldNm());
		this.hashColumns.put("eml_tit_nm", getEmlTitNm());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pprl_eml_rcv_cd", getPprlEmlRcvCd());
		this.hashColumns.put("sndr_eml", getSndrEml());
		this.hashColumns.put("atch_file_path_ctnt", getAtchFilePathCtnt());
		this.hashColumns.put("fr_cre_dt", getFrCreDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("org_file_nm", getOrgFileNm());
		this.hashColumns.put("pprl_eml_ctnt", getPprlEmlCtnt());
		this.hashColumns.put("arc_type", getArcType());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("to_cre_dt", getToCreDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_upld_nm", "fileUpldNm");
		this.hashFields.put("eml_tit_nm", "emlTitNm");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pprl_eml_rcv_cd", "pprlEmlRcvCd");
		this.hashFields.put("sndr_eml", "sndrEml");
		this.hashFields.put("atch_file_path_ctnt", "atchFilePathCtnt");
		this.hashFields.put("fr_cre_dt", "frCreDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("org_file_nm", "orgFileNm");
		this.hashFields.put("pprl_eml_ctnt", "pprlEmlCtnt");
		this.hashFields.put("arc_type", "arcType");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("to_cre_dt", "toCreDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileUpldNm
	 */
	public String getFileUpldNm() {
		return this.fileUpldNm;
	}
	
	/**
	 * Column Info
	 * @return emlTitNm
	 */
	public String getEmlTitNm() {
		return this.emlTitNm;
	}
	
	/**
	 * Column Info
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
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
	 * @return pprlEmlRcvCd
	 */
	public String getPprlEmlRcvCd() {
		return this.pprlEmlRcvCd;
	}
	
	/**
	 * Column Info
	 * @return sndrEml
	 */
	public String getSndrEml() {
		return this.sndrEml;
	}
	
	/**
	 * Column Info
	 * @return atchFilePathCtnt
	 */
	public String getAtchFilePathCtnt() {
		return this.atchFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @return frCreDt
	 */
	public String getFrCreDt() {
		return this.frCreDt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return orgFileNm
	 */
	public String getOrgFileNm() {
		return this.orgFileNm;
	}
	
	/**
	 * Column Info
	 * @return pprlEmlCtnt
	 */
	public String getPprlEmlCtnt() {
		return this.pprlEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @return arcType
	 */
	public String getArcType() {
		return this.arcType;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return toCreDt
	 */
	public String getToCreDt() {
		return this.toCreDt;
	}
	

	/**
	 * Column Info
	 * @param fileUpldNm
	 */
	public void setFileUpldNm(String fileUpldNm) {
		this.fileUpldNm = fileUpldNm;
	}
	
	/**
	 * Column Info
	 * @param emlTitNm
	 */
	public void setEmlTitNm(String emlTitNm) {
		this.emlTitNm = emlTitNm;
	}
	
	/**
	 * Column Info
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
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
	 * @param pprlEmlRcvCd
	 */
	public void setPprlEmlRcvCd(String pprlEmlRcvCd) {
		this.pprlEmlRcvCd = pprlEmlRcvCd;
	}
	
	/**
	 * Column Info
	 * @param sndrEml
	 */
	public void setSndrEml(String sndrEml) {
		this.sndrEml = sndrEml;
	}
	
	/**
	 * Column Info
	 * @param atchFilePathCtnt
	 */
	public void setAtchFilePathCtnt(String atchFilePathCtnt) {
		this.atchFilePathCtnt = atchFilePathCtnt;
	}
	
	/**
	 * Column Info
	 * @param frCreDt
	 */
	public void setFrCreDt(String frCreDt) {
		this.frCreDt = frCreDt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param orgFileNm
	 */
	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}
	
	/**
	 * Column Info
	 * @param pprlEmlCtnt
	 */
	public void setPprlEmlCtnt(String pprlEmlCtnt) {
		this.pprlEmlCtnt = pprlEmlCtnt;
	}
	
	/**
	 * Column Info
	 * @param arcType
	 */
	public void setArcType(String arcType) {
		this.arcType = arcType;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param toCreDt
	 */
	public void setToCreDt(String toCreDt) {
		this.toCreDt = toCreDt;
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
		setFileUpldNm(JSPUtil.getParameter(request, prefix + "file_upld_nm", ""));
		setEmlTitNm(JSPUtil.getParameter(request, prefix + "eml_tit_nm", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPprlEmlRcvCd(JSPUtil.getParameter(request, prefix + "pprl_eml_rcv_cd", ""));
		setSndrEml(JSPUtil.getParameter(request, prefix + "sndr_eml", ""));
		setAtchFilePathCtnt(JSPUtil.getParameter(request, prefix + "atch_file_path_ctnt", ""));
		setFrCreDt(JSPUtil.getParameter(request, prefix + "fr_cre_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setSndUsrId(JSPUtil.getParameter(request, prefix + "snd_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setOrgFileNm(JSPUtil.getParameter(request, prefix + "org_file_nm", ""));
		setPprlEmlCtnt(JSPUtil.getParameter(request, prefix + "pprl_eml_ctnt", ""));
		setArcType(JSPUtil.getParameter(request, prefix + "arc_type", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setToCreDt(JSPUtil.getParameter(request, prefix + "to_cre_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPaperlessListVO[]
	 */
	public SearchPaperlessListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPaperlessListVO[]
	 */
	public SearchPaperlessListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPaperlessListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileUpldNm = (JSPUtil.getParameter(request, prefix	+ "file_upld_nm", length));
			String[] emlTitNm = (JSPUtil.getParameter(request, prefix	+ "eml_tit_nm", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pprlEmlRcvCd = (JSPUtil.getParameter(request, prefix	+ "pprl_eml_rcv_cd", length));
			String[] sndrEml = (JSPUtil.getParameter(request, prefix	+ "sndr_eml", length));
			String[] atchFilePathCtnt = (JSPUtil.getParameter(request, prefix	+ "atch_file_path_ctnt", length));
			String[] frCreDt = (JSPUtil.getParameter(request, prefix	+ "fr_cre_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] orgFileNm = (JSPUtil.getParameter(request, prefix	+ "org_file_nm", length));
			String[] pprlEmlCtnt = (JSPUtil.getParameter(request, prefix	+ "pprl_eml_ctnt", length));
			String[] arcType = (JSPUtil.getParameter(request, prefix	+ "arc_type", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] toCreDt = (JSPUtil.getParameter(request, prefix	+ "to_cre_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPaperlessListVO();
				if (fileUpldNm[i] != null)
					model.setFileUpldNm(fileUpldNm[i]);
				if (emlTitNm[i] != null)
					model.setEmlTitNm(emlTitNm[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pprlEmlRcvCd[i] != null)
					model.setPprlEmlRcvCd(pprlEmlRcvCd[i]);
				if (sndrEml[i] != null)
					model.setSndrEml(sndrEml[i]);
				if (atchFilePathCtnt[i] != null)
					model.setAtchFilePathCtnt(atchFilePathCtnt[i]);
				if (frCreDt[i] != null)
					model.setFrCreDt(frCreDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (orgFileNm[i] != null)
					model.setOrgFileNm(orgFileNm[i]);
				if (pprlEmlCtnt[i] != null)
					model.setPprlEmlCtnt(pprlEmlCtnt[i]);
				if (arcType[i] != null)
					model.setArcType(arcType[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (toCreDt[i] != null)
					model.setToCreDt(toCreDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPaperlessListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPaperlessListVO[]
	 */
	public SearchPaperlessListVO[] getSearchPaperlessListVOs(){
		SearchPaperlessListVO[] vos = (SearchPaperlessListVO[])models.toArray(new SearchPaperlessListVO[models.size()]);
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
		this.fileUpldNm = this.fileUpldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlTitNm = this.emlTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pprlEmlRcvCd = this.pprlEmlRcvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrEml = this.sndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFilePathCtnt = this.atchFilePathCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frCreDt = this.frCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFileNm = this.orgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pprlEmlCtnt = this.pprlEmlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arcType = this.arcType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCreDt = this.toCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
