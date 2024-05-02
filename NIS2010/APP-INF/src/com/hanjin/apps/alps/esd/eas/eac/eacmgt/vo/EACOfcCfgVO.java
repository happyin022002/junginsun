/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EACOfficeConfigVO.java
*@FileTitle : EACOfficeConfigVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.11.24 백형인 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 백형인
 * @since J2EE 1.6
 * @see AbstractValueObject
 */


public class EACOfcCfgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACOfcCfgVO> models = new ArrayList<EACOfcCfgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eacOfcCd = null;
	/* Column Info */
	private String ftrCtnt = null;
	/* Column Info */
	private String eacOfcUrl = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String ofcZipCd = null;
	/* Column Info */
	private String ofcPhnNo = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String ofcEml = null;
	/* Column Info */
	private String ofcAddr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ofcFaxNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACOfcCfgVO() {}

	public EACOfcCfgVO(String ibflag, String pagerows, String eacOfcCd, String ofcEngNm, String ofcAddr, String steNm, String ctyNm, String ofcZipCd, String ofcPhnNo, String ofcFaxNo, String ofcEml, String eacOfcUrl, String ftrCtnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.eacOfcCd = eacOfcCd;
		this.ftrCtnt = ftrCtnt;
		this.eacOfcUrl = eacOfcUrl;
		this.creDt = creDt;
		this.ofcEngNm = ofcEngNm;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.steNm = steNm;
		this.ofcZipCd = ofcZipCd;
		this.ofcPhnNo = ofcPhnNo;
		this.ctyNm = ctyNm;
		this.ofcEml = ofcEml;
		this.ofcAddr = ofcAddr;
		this.updUsrId = updUsrId;
		this.ofcFaxNo = ofcFaxNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eac_ofc_cd", getEacOfcCd());
		this.hashColumns.put("ftr_ctnt", getFtrCtnt());
		this.hashColumns.put("eac_ofc_url", getEacOfcUrl());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("ofc_zip_cd", getOfcZipCd());
		this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ofc_eml", getOfcEml());
		this.hashColumns.put("ofc_addr", getOfcAddr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eac_ofc_cd", "eacOfcCd");
		this.hashFields.put("ftr_ctnt", "ftrCtnt");
		this.hashFields.put("eac_ofc_url", "eacOfcUrl");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("ofc_zip_cd", "ofcZipCd");
		this.hashFields.put("ofc_phn_no", "ofcPhnNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ofc_eml", "ofcEml");
		this.hashFields.put("ofc_addr", "ofcAddr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ofc_fax_no", "ofcFaxNo");
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
	 * @return eacOfcCd
	 */
	public String getEacOfcCd() {
		return this.eacOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ftrCtnt
	 */
	public String getFtrCtnt() {
		return this.ftrCtnt;
	}
	
	/**
	 * Column Info
	 * @return eacOfcUrl
	 */
	public String getEacOfcUrl() {
		return this.eacOfcUrl;
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
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
	}
	
	/**
	 * Column Info
	 * @return ofcZipCd
	 */
	public String getOfcZipCd() {
		return this.ofcZipCd;
	}
	
	/**
	 * Column Info
	 * @return ofcPhnNo
	 */
	public String getOfcPhnNo() {
		return this.ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return ofcEml
	 */
	public String getOfcEml() {
		return this.ofcEml;
	}
	
	/**
	 * Column Info
	 * @return ofcAddr
	 */
	public String getOfcAddr() {
		return this.ofcAddr;
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
	 * @return ofcFaxNo
	 */
	public String getOfcFaxNo() {
		return this.ofcFaxNo;
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
	 * @param eacOfcCd
	 */
	public void setEacOfcCd(String eacOfcCd) {
		this.eacOfcCd = eacOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ftrCtnt
	 */
	public void setFtrCtnt(String ftrCtnt) {
		this.ftrCtnt = ftrCtnt;
	}
	
	/**
	 * Column Info
	 * @param eacOfcUrl
	 */
	public void setEacOfcUrl(String eacOfcUrl) {
		this.eacOfcUrl = eacOfcUrl;
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
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
	}
	
	/**
	 * Column Info
	 * @param ofcZipCd
	 */
	public void setOfcZipCd(String ofcZipCd) {
		this.ofcZipCd = ofcZipCd;
	}
	
	/**
	 * Column Info
	 * @param ofcPhnNo
	 */
	public void setOfcPhnNo(String ofcPhnNo) {
		this.ofcPhnNo = ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param ofcEml
	 */
	public void setOfcEml(String ofcEml) {
		this.ofcEml = ofcEml;
	}
	
	/**
	 * Column Info
	 * @param ofcAddr
	 */
	public void setOfcAddr(String ofcAddr) {
		this.ofcAddr = ofcAddr;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ofcFaxNo
	 */
	public void setOfcFaxNo(String ofcFaxNo) {
		this.ofcFaxNo = ofcFaxNo;
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
		setEacOfcCd(JSPUtil.getParameter(request, prefix + "eac_ofc_cd", ""));
		setFtrCtnt(JSPUtil.getParameter(request, prefix + "ftr_ctnt", ""));
		setEacOfcUrl(JSPUtil.getParameter(request, prefix + "eac_ofc_url", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
		setOfcZipCd(JSPUtil.getParameter(request, prefix + "ofc_zip_cd", ""));
		setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setOfcEml(JSPUtil.getParameter(request, prefix + "ofc_eml", ""));
		setOfcAddr(JSPUtil.getParameter(request, prefix + "ofc_addr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOfcFaxNo(JSPUtil.getParameter(request, prefix + "ofc_fax_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACOfficeConfigVO[]
	 */
	public EACOfcCfgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACOfficeConfigVO[]
	 */
	public EACOfcCfgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACOfcCfgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eacOfcCd = (JSPUtil.getParameter(request, prefix	+ "eac_ofc_cd", length));
			String[] ftrCtnt = (JSPUtil.getParameter(request, prefix	+ "ftr_ctnt", length));
			String[] eacOfcUrl = (JSPUtil.getParameter(request, prefix	+ "eac_ofc_url", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] ofcZipCd = (JSPUtil.getParameter(request, prefix	+ "ofc_zip_cd", length));
			String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ofc_phn_no", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] ofcEml = (JSPUtil.getParameter(request, prefix	+ "ofc_eml", length));
			String[] ofcAddr = (JSPUtil.getParameter(request, prefix	+ "ofc_addr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ofc_fax_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACOfcCfgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eacOfcCd[i] != null)
					model.setEacOfcCd(eacOfcCd[i]);
				if (ftrCtnt[i] != null)
					model.setFtrCtnt(ftrCtnt[i]);
				if (eacOfcUrl[i] != null)
					model.setEacOfcUrl(eacOfcUrl[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (ofcZipCd[i] != null)
					model.setOfcZipCd(ofcZipCd[i]);
				if (ofcPhnNo[i] != null)
					model.setOfcPhnNo(ofcPhnNo[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (ofcEml[i] != null)
					model.setOfcEml(ofcEml[i]);
				if (ofcAddr[i] != null)
					model.setOfcAddr(ofcAddr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ofcFaxNo[i] != null)
					model.setOfcFaxNo(ofcFaxNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACOfficeConfigVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACOfficeConfigVO[]
	 */
	public EACOfcCfgVO[] getEACOfficeConfigVOs(){
		EACOfcCfgVO[] vos = (EACOfcCfgVO[])models.toArray(new EACOfcCfgVO[models.size()]);
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
		this.eacOfcCd = this.eacOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftrCtnt = this.ftrCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacOfcUrl = this.eacOfcUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcZipCd = this.ofcZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcPhnNo = this.ofcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEml = this.ofcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAddr = this.ofcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFaxNo = this.ofcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
