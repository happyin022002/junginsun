/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniCgoClmLtgtVO.java
*@FileTitle : CniCgoClmLtgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2009.10.23 정행룡 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo;

import java.lang.reflect.Field;
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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniCgoClmLtgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniCgoClmLtgtVO> models = new ArrayList<CniCgoClmLtgtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String crtLocCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String crtNm = null;
	/* Column Info */
	private String crtCsNo = null;
	/* Column Info */
	private String cplnFileDt = null;
	/* Column Info */
	private String jmtRsltDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String deftAttyApntDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deftNm = null;
	/* Column Info */
	private String ltgtCsDesc = null;
	/* Column Info */
	private String pltNm = null;
	/* Column Info */
	private String deftAttyClmPtyNo = null;
	/* Column Info */
	private String refDeftAttyNo = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String jmtRsltCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniCgoClmLtgtVO() {}

	public CniCgoClmLtgtVO(String ibflag, String pagerows, String cgoClmNo, String pltNm, String deftNm, String deftAttyClmPtyNo, String deftAttyApntDt, String refDeftAttyNo, String crtNm, String crtLocCd, String crtCsNo, String cplnFileDt, String jmtRsltCd, String jmtRsltDt, String smnsSveDt, String ltgtCsDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.crtLocCd = crtLocCd;
		this.creDt = creDt;
		this.smnsSveDt = smnsSveDt;
		this.crtNm = crtNm;
		this.crtCsNo = crtCsNo;
		this.cplnFileDt = cplnFileDt;
		this.jmtRsltDt = jmtRsltDt;
		this.pagerows = pagerows;
		this.deftAttyApntDt = deftAttyApntDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.deftNm = deftNm;
		this.ltgtCsDesc = ltgtCsDesc;
		this.pltNm = pltNm;
		this.deftAttyClmPtyNo = deftAttyClmPtyNo;
		this.refDeftAttyNo = refDeftAttyNo;
		this.cgoClmNo = cgoClmNo;
		this.jmtRsltCd = jmtRsltCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("crt_loc_cd", getCrtLocCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("crt_nm", getCrtNm());
		this.hashColumns.put("crt_cs_no", getCrtCsNo());
		this.hashColumns.put("cpln_file_dt", getCplnFileDt());
		this.hashColumns.put("jmt_rslt_dt", getJmtRsltDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("deft_atty_apnt_dt", getDeftAttyApntDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("deft_nm", getDeftNm());
		this.hashColumns.put("ltgt_cs_desc", getLtgtCsDesc());
		this.hashColumns.put("plt_nm", getPltNm());
		this.hashColumns.put("deft_atty_clm_pty_no", getDeftAttyClmPtyNo());
		this.hashColumns.put("ref_deft_atty_no", getRefDeftAttyNo());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("jmt_rslt_cd", getJmtRsltCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("crt_loc_cd", "crtLocCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("crt_nm", "crtNm");
		this.hashFields.put("crt_cs_no", "crtCsNo");
		this.hashFields.put("cpln_file_dt", "cplnFileDt");
		this.hashFields.put("jmt_rslt_dt", "jmtRsltDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("deft_atty_apnt_dt", "deftAttyApntDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("deft_nm", "deftNm");
		this.hashFields.put("ltgt_cs_desc", "ltgtCsDesc");
		this.hashFields.put("plt_nm", "pltNm");
		this.hashFields.put("deft_atty_clm_pty_no", "deftAttyClmPtyNo");
		this.hashFields.put("ref_deft_atty_no", "refDeftAttyNo");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("jmt_rslt_cd", "jmtRsltCd");
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
	 * @return crtLocCd
	 */
	public String getCrtLocCd() {
		return this.crtLocCd;
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
	 * @return smnsSveDt
	 */
	public String getSmnsSveDt() {
		return this.smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @return crtNm
	 */
	public String getCrtNm() {
		return this.crtNm;
	}
	
	/**
	 * Column Info
	 * @return crtCsNo
	 */
	public String getCrtCsNo() {
		return this.crtCsNo;
	}
	
	/**
	 * Column Info
	 * @return cplnFileDt
	 */
	public String getCplnFileDt() {
		return this.cplnFileDt;
	}
	
	/**
	 * Column Info
	 * @return jmtRsltDt
	 */
	public String getJmtRsltDt() {
		return this.jmtRsltDt;
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
	 * @return deftAttyApntDt
	 */
	public String getDeftAttyApntDt() {
		return this.deftAttyApntDt;
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
	 * @return deftNm
	 */
	public String getDeftNm() {
		return this.deftNm;
	}
	
	/**
	 * Column Info
	 * @return ltgtCsDesc
	 */
	public String getLtgtCsDesc() {
		return this.ltgtCsDesc;
	}
	
	/**
	 * Column Info
	 * @return pltNm
	 */
	public String getPltNm() {
		return this.pltNm;
	}
	
	/**
	 * Column Info
	 * @return deftAttyClmPtyNo
	 */
	public String getDeftAttyClmPtyNo() {
		return this.deftAttyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return refDeftAttyNo
	 */
	public String getRefDeftAttyNo() {
		return this.refDeftAttyNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return jmtRsltCd
	 */
	public String getJmtRsltCd() {
		return this.jmtRsltCd;
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
	 * @param crtLocCd
	 */
	public void setCrtLocCd(String crtLocCd) {
		this.crtLocCd = crtLocCd;
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
	 * @param smnsSveDt
	 */
	public void setSmnsSveDt(String smnsSveDt) {
		this.smnsSveDt = smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @param crtNm
	 */
	public void setCrtNm(String crtNm) {
		this.crtNm = crtNm;
	}
	
	/**
	 * Column Info
	 * @param crtCsNo
	 */
	public void setCrtCsNo(String crtCsNo) {
		this.crtCsNo = crtCsNo;
	}
	
	/**
	 * Column Info
	 * @param cplnFileDt
	 */
	public void setCplnFileDt(String cplnFileDt) {
		this.cplnFileDt = cplnFileDt;
	}
	
	/**
	 * Column Info
	 * @param jmtRsltDt
	 */
	public void setJmtRsltDt(String jmtRsltDt) {
		this.jmtRsltDt = jmtRsltDt;
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
	 * @param deftAttyApntDt
	 */
	public void setDeftAttyApntDt(String deftAttyApntDt) {
		this.deftAttyApntDt = deftAttyApntDt;
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
	 * @param deftNm
	 */
	public void setDeftNm(String deftNm) {
		this.deftNm = deftNm;
	}
	
	/**
	 * Column Info
	 * @param ltgtCsDesc
	 */
	public void setLtgtCsDesc(String ltgtCsDesc) {
		this.ltgtCsDesc = ltgtCsDesc;
	}
	
	/**
	 * Column Info
	 * @param pltNm
	 */
	public void setPltNm(String pltNm) {
		this.pltNm = pltNm;
	}
	
	/**
	 * Column Info
	 * @param deftAttyClmPtyNo
	 */
	public void setDeftAttyClmPtyNo(String deftAttyClmPtyNo) {
		this.deftAttyClmPtyNo = deftAttyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param refDeftAttyNo
	 */
	public void setRefDeftAttyNo(String refDeftAttyNo) {
		this.refDeftAttyNo = refDeftAttyNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param jmtRsltCd
	 */
	public void setJmtRsltCd(String jmtRsltCd) {
		this.jmtRsltCd = jmtRsltCd;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCrtLocCd(JSPUtil.getParameter(request, "crt_loc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSmnsSveDt(JSPUtil.getParameter(request, "smns_sve_dt", ""));
		setCrtNm(JSPUtil.getParameter(request, "crt_nm", ""));
		setCrtCsNo(JSPUtil.getParameter(request, "crt_cs_no", ""));
		setCplnFileDt(JSPUtil.getParameter(request, "cpln_file_dt", ""));
		setJmtRsltDt(JSPUtil.getParameter(request, "jmt_rslt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDeftAttyApntDt(JSPUtil.getParameter(request, "deft_atty_apnt_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeftNm(JSPUtil.getParameter(request, "deft_nm", ""));
		setLtgtCsDesc(JSPUtil.getParameter(request, "ltgt_cs_desc", ""));
		setPltNm(JSPUtil.getParameter(request, "plt_nm", ""));
		setDeftAttyClmPtyNo(JSPUtil.getParameter(request, "deft_atty_clm_pty_no", ""));
		setRefDeftAttyNo(JSPUtil.getParameter(request, "ref_deft_atty_no", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setJmtRsltCd(JSPUtil.getParameter(request, "jmt_rslt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniCgoClmLtgtVO[]
	 */
	public CniCgoClmLtgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniCgoClmLtgtVO[]
	 */
	public CniCgoClmLtgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniCgoClmLtgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] crtLocCd = (JSPUtil.getParameter(request, prefix	+ "crt_loc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] crtNm = (JSPUtil.getParameter(request, prefix	+ "crt_nm", length));
			String[] crtCsNo = (JSPUtil.getParameter(request, prefix	+ "crt_cs_no", length));
			String[] cplnFileDt = (JSPUtil.getParameter(request, prefix	+ "cpln_file_dt", length));
			String[] jmtRsltDt = (JSPUtil.getParameter(request, prefix	+ "jmt_rslt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] deftAttyApntDt = (JSPUtil.getParameter(request, prefix	+ "deft_atty_apnt_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deftNm = (JSPUtil.getParameter(request, prefix	+ "deft_nm", length));
			String[] ltgtCsDesc = (JSPUtil.getParameter(request, prefix	+ "ltgt_cs_desc", length));
			String[] pltNm = (JSPUtil.getParameter(request, prefix	+ "plt_nm", length));
			String[] deftAttyClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "deft_atty_clm_pty_no", length));
			String[] refDeftAttyNo = (JSPUtil.getParameter(request, prefix	+ "ref_deft_atty_no", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] jmtRsltCd = (JSPUtil.getParameter(request, prefix	+ "jmt_rslt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniCgoClmLtgtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (crtLocCd[i] != null)
					model.setCrtLocCd(crtLocCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (crtNm[i] != null)
					model.setCrtNm(crtNm[i]);
				if (crtCsNo[i] != null)
					model.setCrtCsNo(crtCsNo[i]);
				if (cplnFileDt[i] != null)
					model.setCplnFileDt(cplnFileDt[i]);
				if (jmtRsltDt[i] != null)
					model.setJmtRsltDt(jmtRsltDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (deftAttyApntDt[i] != null)
					model.setDeftAttyApntDt(deftAttyApntDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deftNm[i] != null)
					model.setDeftNm(deftNm[i]);
				if (ltgtCsDesc[i] != null)
					model.setLtgtCsDesc(ltgtCsDesc[i]);
				if (pltNm[i] != null)
					model.setPltNm(pltNm[i]);
				if (deftAttyClmPtyNo[i] != null)
					model.setDeftAttyClmPtyNo(deftAttyClmPtyNo[i]);
				if (refDeftAttyNo[i] != null)
					model.setRefDeftAttyNo(refDeftAttyNo[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (jmtRsltCd[i] != null)
					model.setJmtRsltCd(jmtRsltCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniCgoClmLtgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniCgoClmLtgtVO[]
	 */
	public CniCgoClmLtgtVO[] getCniCgoClmLtgtVOs(){
		CniCgoClmLtgtVO[] vos = (CniCgoClmLtgtVO[])models.toArray(new CniCgoClmLtgtVO[models.size()]);
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
		this.crtLocCd = this.crtLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtNm = this.crtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCsNo = this.crtCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cplnFileDt = this.cplnFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jmtRsltDt = this.jmtRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyApntDt = this.deftAttyApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftNm = this.deftNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltgtCsDesc = this.ltgtCsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltNm = this.pltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyClmPtyNo = this.deftAttyClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDeftAttyNo = this.refDeftAttyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jmtRsltCd = this.jmtRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
