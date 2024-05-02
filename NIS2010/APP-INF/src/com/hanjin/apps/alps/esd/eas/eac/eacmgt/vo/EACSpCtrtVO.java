/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EACSpContactPointVO.java
*@FileTitle : EACSpContactPointVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.18
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.11.18 백형인 
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


public class EACSpCtrtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACSpCtrtVO> models = new ArrayList<EACSpCtrtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eacFaxUseFlg = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String vndrCntcPntNm = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrEml = null;
	/* Column Info */
	private String psnNm = null;
	/* Column Info */
	private String psnDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String vndrCntcPntSeq = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eacEmlUseFlg = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACSpCtrtVO() {}

	public EACSpCtrtVO(String ibflag, String pagerows, String vndrSeq, String vndrCntcPntSeq, String vndrCntcPntNm, String psnNm, String psnDesc, String steNm, String ctyNm, String phnNo, String faxNo, String vndrEml, String eacEmlUseFlg, String eacFaxUseFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String vndrLglEngNm, String zipCd, String engAddr, String steCd, String creUsrNm) {
		this.updDt = updDt;
		this.eacFaxUseFlg = eacFaxUseFlg;
		this.phnNo = phnNo;
		this.engAddr = engAddr;
		this.deltFlg = deltFlg;
		this.vndrCntcPntNm = vndrCntcPntNm;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.creUsrNm = creUsrNm;
		this.pagerows = pagerows;
		this.vndrEml = vndrEml;
		this.psnNm = psnNm;
		this.psnDesc = psnDesc;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.steNm = steNm;
		this.vndrCntcPntSeq = vndrCntcPntSeq;
		this.zipCd = zipCd;
		this.vndrSeq = vndrSeq;
		this.eacEmlUseFlg = eacEmlUseFlg;
		this.faxNo = faxNo;
		this.ctyNm = ctyNm;
		this.steCd = steCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eac_fax_use_flg", getEacFaxUseFlg());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vndr_cntc_pnt_nm", getVndrCntcPntNm());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_nm", getCreUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("psn_nm", getPsnNm());
		this.hashColumns.put("psn_desc", getPsnDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eac_eml_use_flg", getEacEmlUseFlg());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eac_fax_use_flg", "eacFaxUseFlg");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vndr_cntc_pnt_nm", "vndrCntcPntNm");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_nm", "creUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("psn_nm", "psnNm");
		this.hashFields.put("psn_desc", "psnDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eac_eml_use_flg", "eacEmlUseFlg");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return eacFaxUseFlg
	 */
	public String getEacFaxUseFlg() {
		return this.eacFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrCntcPntNm
	 */
	public String getVndrCntcPntNm() {
		return this.vndrCntcPntNm;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
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
	 * @return creUsrNm
	 */
	public String getCreUsrNm() {
		return this.creUsrNm;
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
	 * @return vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
	}
	
	/**
	 * Column Info
	 * @return psnNm
	 */
	public String getPsnNm() {
		return this.psnNm;
	}
	
	/**
	 * Column Info
	 * @return psnDesc
	 */
	public String getPsnDesc() {
		return this.psnDesc;
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
	 * @return vndrCntcPntSeq
	 */
	public String getVndrCntcPntSeq() {
		return this.vndrCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return eacEmlUseFlg
	 */
	public String getEacEmlUseFlg() {
		return this.eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
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
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param eacFaxUseFlg
	 */
	public void setEacFaxUseFlg(String eacFaxUseFlg) {
		this.eacFaxUseFlg = eacFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrCntcPntNm
	 */
	public void setVndrCntcPntNm(String vndrCntcPntNm) {
		this.vndrCntcPntNm = vndrCntcPntNm;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
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
	 * @param creUsrNm
	 */
	public void setCreUsrNm(String creUsrNm) {
		this.creUsrNm = creUsrNm;
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
	 * @param vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
	}
	
	/**
	 * Column Info
	 * @param psnNm
	 */
	public void setPsnNm(String psnNm) {
		this.psnNm = psnNm;
	}
	
	/**
	 * Column Info
	 * @param psnDesc
	 */
	public void setPsnDesc(String psnDesc) {
		this.psnDesc = psnDesc;
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
	 * @param vndrCntcPntSeq
	 */
	public void setVndrCntcPntSeq(String vndrCntcPntSeq) {
		this.vndrCntcPntSeq = vndrCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param eacEmlUseFlg
	 */
	public void setEacEmlUseFlg(String eacEmlUseFlg) {
		this.eacEmlUseFlg = eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
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
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setEacFaxUseFlg(JSPUtil.getParameter(request, prefix + "eac_fax_use_flg", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setEngAddr(JSPUtil.getParameter(request, prefix + "eng_addr", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVndrCntcPntNm(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_nm", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCreUsrNm(JSPUtil.getParameter(request, prefix + "cre_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
		setPsnNm(JSPUtil.getParameter(request, prefix + "psn_nm", ""));
		setPsnDesc(JSPUtil.getParameter(request, prefix + "psn_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
		setVndrCntcPntSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setEacEmlUseFlg(JSPUtil.getParameter(request, prefix + "eac_eml_use_flg", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACSpContactPointVO[]
	 */
	public EACSpCtrtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACSpContactPointVO[]
	 */
	public EACSpCtrtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACSpCtrtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eacFaxUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_fax_use_flg", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vndrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_nm", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrNm = (JSPUtil.getParameter(request, prefix	+ "cre_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] psnNm = (JSPUtil.getParameter(request, prefix	+ "psn_nm", length));
			String[] psnDesc = (JSPUtil.getParameter(request, prefix	+ "psn_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_seq", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] eacEmlUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_eml_use_flg", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACSpCtrtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eacFaxUseFlg[i] != null)
					model.setEacFaxUseFlg(eacFaxUseFlg[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (vndrCntcPntNm[i] != null)
					model.setVndrCntcPntNm(vndrCntcPntNm[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrNm[i] != null)
					model.setCreUsrNm(creUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);
				if (psnNm[i] != null)
					model.setPsnNm(psnNm[i]);
				if (psnDesc[i] != null)
					model.setPsnDesc(psnDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (vndrCntcPntSeq[i] != null)
					model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eacEmlUseFlg[i] != null)
					model.setEacEmlUseFlg(eacEmlUseFlg[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACSpContactPointVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACSpContactPointVO[]
	 */
	public EACSpCtrtVO[] getEACSpContactPointVOs(){
		EACSpCtrtVO[] vos = (EACSpCtrtVO[])models.toArray(new EACSpCtrtVO[models.size()]);
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
		this.eacFaxUseFlg = this.eacFaxUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntNm = this.vndrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrNm = this.creUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psnNm = this.psnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psnDesc = this.psnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntSeq = this.vndrCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacEmlUseFlg = this.eacEmlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
