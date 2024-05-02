/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchPerfVolByRegionGroupDtlListVO.java
*@FileTitle : SearchPerfVolByRegionGroupDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.28
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.28 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPerfVolByRegionGroupDtlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPerfVolByRegionGroupDtlListVO> models = new ArrayList<SearchPerfVolByRegionGroupDtlListVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String rateType = null;
	/* Column Info */
	private String srUrgNm = null;
	/* Column Info */
	private String selfAudit = null;
	/* Column Info */
	private String siNo = null;
	/* Column Info */
	private String urgent = null;
	/* Column Info */
	private String amdFreq = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String regionNm = null;
	/* Column Info */
	private String rtnFreq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String picUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usrGroup = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String siKnd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String hBl = null;
	/* Column Info */
	private String cmCnt = null;
	/* Column Info */
	private String src = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPerfVolByRegionGroupDtlListVO() {}

	public SearchPerfVolByRegionGroupDtlListVO(String ibflag, String pagerows, String rtnFreq, String amdFreq, String picUsrId, String usrNm, String usrGroup, String region, String bkgNo, String siNo, String siKnd, String urgent, String src, String vvdCd, String pol, String del, String regionNm, String srUrgNm, String cntrCnt, String cmCnt, String hBl, String selfAudit, String rateType) {
		this.region = region;
		this.rateType = rateType;
		this.srUrgNm = srUrgNm;
		this.selfAudit = selfAudit;
		this.siNo = siNo;
		this.urgent = urgent;
		this.amdFreq = amdFreq;
		this.cntrCnt = cntrCnt;
		this.regionNm = regionNm;
		this.rtnFreq = rtnFreq;
		this.pagerows = pagerows;
		this.picUsrId = picUsrId;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.usrGroup = usrGroup;
		this.vvdCd = vvdCd;
		this.usrNm = usrNm;
		this.pol = pol;
		this.siKnd = siKnd;
		this.del = del;
		this.hBl = hBl;
		this.cmCnt = cmCnt;
		this.src = src;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("rate_type", getRateType());
		this.hashColumns.put("sr_urg_nm", getSrUrgNm());
		this.hashColumns.put("self_audit", getSelfAudit());
		this.hashColumns.put("si_no", getSiNo());
		this.hashColumns.put("urgent", getUrgent());
		this.hashColumns.put("amd_freq", getAmdFreq());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("region_nm", getRegionNm());
		this.hashColumns.put("rtn_freq", getRtnFreq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pic_usr_id", getPicUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usr_group", getUsrGroup());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("si_knd", getSiKnd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("h_bl", getHBl());
		this.hashColumns.put("cm_cnt", getCmCnt());
		this.hashColumns.put("src", getSrc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("rate_type", "rateType");
		this.hashFields.put("sr_urg_nm", "srUrgNm");
		this.hashFields.put("self_audit", "selfAudit");
		this.hashFields.put("si_no", "siNo");
		this.hashFields.put("urgent", "urgent");
		this.hashFields.put("amd_freq", "amdFreq");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("region_nm", "regionNm");
		this.hashFields.put("rtn_freq", "rtnFreq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pic_usr_id", "picUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usr_group", "usrGroup");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("si_knd", "siKnd");
		this.hashFields.put("del", "del");
		this.hashFields.put("h_bl", "hBl");
		this.hashFields.put("cm_cnt", "cmCnt");
		this.hashFields.put("src", "src");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return rateType
	 */
	public String getRateType() {
		return this.rateType;
	}
	
	/**
	 * Column Info
	 * @return srUrgNm
	 */
	public String getSrUrgNm() {
		return this.srUrgNm;
	}
	
	/**
	 * Column Info
	 * @return selfAudit
	 */
	public String getSelfAudit() {
		return this.selfAudit;
	}
	
	/**
	 * Column Info
	 * @return siNo
	 */
	public String getSiNo() {
		return this.siNo;
	}
	
	/**
	 * Column Info
	 * @return urgent
	 */
	public String getUrgent() {
		return this.urgent;
	}
	
	/**
	 * Column Info
	 * @return amdFreq
	 */
	public String getAmdFreq() {
		return this.amdFreq;
	}
	
	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return regionNm
	 */
	public String getRegionNm() {
		return this.regionNm;
	}
	
	/**
	 * Column Info
	 * @return rtnFreq
	 */
	public String getRtnFreq() {
		return this.rtnFreq;
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
	 * @return picUsrId
	 */
	public String getPicUsrId() {
		return this.picUsrId;
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
	 * @return usrGroup
	 */
	public String getUsrGroup() {
		return this.usrGroup;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return siKnd
	 */
	public String getSiKnd() {
		return this.siKnd;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return hBl
	 */
	public String getHBl() {
		return this.hBl;
	}
	
	/**
	 * Column Info
	 * @return cmCnt
	 */
	public String getCmCnt() {
		return this.cmCnt;
	}
	
	/**
	 * Column Info
	 * @return src
	 */
	public String getSrc() {
		return this.src;
	}
	

	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param rateType
	 */
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	
	/**
	 * Column Info
	 * @param srUrgNm
	 */
	public void setSrUrgNm(String srUrgNm) {
		this.srUrgNm = srUrgNm;
	}
	
	/**
	 * Column Info
	 * @param selfAudit
	 */
	public void setSelfAudit(String selfAudit) {
		this.selfAudit = selfAudit;
	}
	
	/**
	 * Column Info
	 * @param siNo
	 */
	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}
	
	/**
	 * Column Info
	 * @param urgent
	 */
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	
	/**
	 * Column Info
	 * @param amdFreq
	 */
	public void setAmdFreq(String amdFreq) {
		this.amdFreq = amdFreq;
	}
	
	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param regionNm
	 */
	public void setRegionNm(String regionNm) {
		this.regionNm = regionNm;
	}
	
	/**
	 * Column Info
	 * @param rtnFreq
	 */
	public void setRtnFreq(String rtnFreq) {
		this.rtnFreq = rtnFreq;
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
	 * @param picUsrId
	 */
	public void setPicUsrId(String picUsrId) {
		this.picUsrId = picUsrId;
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
	 * @param usrGroup
	 */
	public void setUsrGroup(String usrGroup) {
		this.usrGroup = usrGroup;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param siKnd
	 */
	public void setSiKnd(String siKnd) {
		this.siKnd = siKnd;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param hBl
	 */
	public void setHBl(String hBl) {
		this.hBl = hBl;
	}
	
	/**
	 * Column Info
	 * @param cmCnt
	 */
	public void setCmCnt(String cmCnt) {
		this.cmCnt = cmCnt;
	}
	
	/**
	 * Column Info
	 * @param src
	 */
	public void setSrc(String src) {
		this.src = src;
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
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setRateType(JSPUtil.getParameter(request, prefix + "rate_type", ""));
		setSrUrgNm(JSPUtil.getParameter(request, prefix + "sr_urg_nm", ""));
		setSelfAudit(JSPUtil.getParameter(request, prefix + "self_audit", ""));
		setSiNo(JSPUtil.getParameter(request, prefix + "si_no", ""));
		setUrgent(JSPUtil.getParameter(request, prefix + "urgent", ""));
		setAmdFreq(JSPUtil.getParameter(request, prefix + "amd_freq", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setRegionNm(JSPUtil.getParameter(request, prefix + "region_nm", ""));
		setRtnFreq(JSPUtil.getParameter(request, prefix + "rtn_freq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPicUsrId(JSPUtil.getParameter(request, prefix + "pic_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUsrGroup(JSPUtil.getParameter(request, prefix + "usr_group", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setSiKnd(JSPUtil.getParameter(request, prefix + "si_knd", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setHBl(JSPUtil.getParameter(request, prefix + "h_bl", ""));
		setCmCnt(JSPUtil.getParameter(request, prefix + "cm_cnt", ""));
		setSrc(JSPUtil.getParameter(request, prefix + "src", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPerfVolByRegionGroupDtlListVO[]
	 */
	public SearchPerfVolByRegionGroupDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPerfVolByRegionGroupDtlListVO[]
	 */
	public SearchPerfVolByRegionGroupDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPerfVolByRegionGroupDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] rateType = (JSPUtil.getParameter(request, prefix	+ "rate_type", length));
			String[] srUrgNm = (JSPUtil.getParameter(request, prefix	+ "sr_urg_nm", length));
			String[] selfAudit = (JSPUtil.getParameter(request, prefix	+ "self_audit", length));
			String[] siNo = (JSPUtil.getParameter(request, prefix	+ "si_no", length));
			String[] urgent = (JSPUtil.getParameter(request, prefix	+ "urgent", length));
			String[] amdFreq = (JSPUtil.getParameter(request, prefix	+ "amd_freq", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] regionNm = (JSPUtil.getParameter(request, prefix	+ "region_nm", length));
			String[] rtnFreq = (JSPUtil.getParameter(request, prefix	+ "rtn_freq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] picUsrId = (JSPUtil.getParameter(request, prefix	+ "pic_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usrGroup = (JSPUtil.getParameter(request, prefix	+ "usr_group", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] siKnd = (JSPUtil.getParameter(request, prefix	+ "si_knd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] hBl = (JSPUtil.getParameter(request, prefix	+ "h_bl", length));
			String[] cmCnt = (JSPUtil.getParameter(request, prefix	+ "cm_cnt", length));
			String[] src = (JSPUtil.getParameter(request, prefix	+ "src", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPerfVolByRegionGroupDtlListVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (rateType[i] != null)
					model.setRateType(rateType[i]);
				if (srUrgNm[i] != null)
					model.setSrUrgNm(srUrgNm[i]);
				if (selfAudit[i] != null)
					model.setSelfAudit(selfAudit[i]);
				if (siNo[i] != null)
					model.setSiNo(siNo[i]);
				if (urgent[i] != null)
					model.setUrgent(urgent[i]);
				if (amdFreq[i] != null)
					model.setAmdFreq(amdFreq[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (regionNm[i] != null)
					model.setRegionNm(regionNm[i]);
				if (rtnFreq[i] != null)
					model.setRtnFreq(rtnFreq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (picUsrId[i] != null)
					model.setPicUsrId(picUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usrGroup[i] != null)
					model.setUsrGroup(usrGroup[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (siKnd[i] != null)
					model.setSiKnd(siKnd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (hBl[i] != null)
					model.setHBl(hBl[i]);
				if (cmCnt[i] != null)
					model.setCmCnt(cmCnt[i]);
				if (src[i] != null)
					model.setSrc(src[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPerfVolByRegionGroupDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPerfVolByRegionGroupDtlListVO[]
	 */
	public SearchPerfVolByRegionGroupDtlListVO[] getSearchPerfVolByRegionGroupDtlListVOs(){
		SearchPerfVolByRegionGroupDtlListVO[] vos = (SearchPerfVolByRegionGroupDtlListVO[])models.toArray(new SearchPerfVolByRegionGroupDtlListVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateType = this.rateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srUrgNm = this.srUrgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selfAudit = this.selfAudit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siNo = this.siNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgent = this.urgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdFreq = this.amdFreq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regionNm = this.regionNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnFreq = this.rtnFreq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picUsrId = this.picUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrGroup = this.usrGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siKnd = this.siKnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hBl = this.hBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCnt = this.cmCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.src = this.src .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
