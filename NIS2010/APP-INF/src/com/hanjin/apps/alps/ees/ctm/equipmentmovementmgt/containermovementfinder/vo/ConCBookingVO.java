/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ConCBookingVO.java
*@FileTitle : ConCBookingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.08.22 최덕우 
* 1.0 Creation
* =======================================================
* History
* 2014.03.10 박다은 [CHM-201428741]	CTM: Stowage Plan POD (BKG/MVMT VL/VD unmatch Inquiry)
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ConCBookingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConCBookingVO> models = new ArrayList<ConCBookingVO>();
	
	/* Column Info */
	private String restuff = null;
	/* Column Info */
	private String cgoType = null;
	/* Column Info */
	private String pYard = null;
	/* Column Info */
	private String loclType = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String viewtype = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String mvType = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String flgrslt = null;
	/* Column Info */
	private String vlsCd = null;
	/* Column Info */
	private String fullFg = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String splnPod = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String matPod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ConCBookingVO() {}

	public ConCBookingVO(String ibflag, String pagerows, String cgoType, String loclType, String viewtype, String mvmtStsCd, String bkgNo, String polCd, String mvType, String cntrNo, String cntrTpszCd, String flgrslt, String fullFg, String vlsCd, String orgYdCd, String evntDt, String svrId, String pYard, String restuff, String ttl, String splnPod, String podCd, String skdVoyNo, String matPod) {
		this.restuff = restuff;
		this.cgoType = cgoType;
		this.pYard = pYard;
		this.loclType = loclType;
		this.ttl = ttl;
		this.orgYdCd = orgYdCd;
		this.pagerows = pagerows;
		this.viewtype = viewtype;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.mvType = mvType;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.flgrslt = flgrslt;
		this.vlsCd = vlsCd;
		this.fullFg = fullFg;
		this.evntDt = evntDt;
		this.splnPod = splnPod;
		this.podCd = podCd;
		this.skdVoyNo = skdVoyNo;
		this.matPod = matPod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("restuff", getRestuff());
		this.hashColumns.put("cgo_type", getCgoType());
		this.hashColumns.put("p_yard", getPYard());
		this.hashColumns.put("locl_type", getLoclType());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("viewtype", getViewtype());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("mv_type", getMvType());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("flgrslt", getFlgrslt());
		this.hashColumns.put("vls_cd", getVlsCd());
		this.hashColumns.put("full_fg", getFullFg());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("spln_pod", getSplnPod());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("mat_pod", getMatPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("restuff", "restuff");
		this.hashFields.put("cgo_type", "cgoType");
		this.hashFields.put("p_yard", "pYard");
		this.hashFields.put("locl_type", "loclType");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("viewtype", "viewtype");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("mv_type", "mvType");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("flgrslt", "flgrslt");
		this.hashFields.put("vls_cd", "vlsCd");
		this.hashFields.put("full_fg", "fullFg");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("spln_cd", "splnPod");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("mat_pod", "matPod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return restuff
	 */
	public String getRestuff() {
		return this.restuff;
	}
	
	/**
	 * Column Info
	 * @return cgoType
	 */
	public String getCgoType() {
		return this.cgoType;
	}
	
	/**
	 * Column Info
	 * @return pYard
	 */
	public String getPYard() {
		return this.pYard;
	}
	
	/**
	 * Column Info
	 * @return loclType
	 */
	public String getLoclType() {
		return this.loclType;
	}
	
	/**
	 * Column Info
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
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
	 * @return viewtype
	 */
	public String getViewtype() {
		return this.viewtype;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
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
	 * @return mvType
	 */
	public String getMvType() {
		return this.mvType;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return flgrslt
	 */
	public String getFlgrslt() {
		return this.flgrslt;
	}
	
	/**
	 * Column Info
	 * @return vlsCd
	 */
	public String getVlsCd() {
		return this.vlsCd;
	}
	
	/**
	 * Column Info
	 * @return fullFg
	 */
	public String getFullFg() {
		return this.fullFg;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return splnPod
	 */
	public String getSplnPod() {
		return this.splnPod;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return matPod
	 */
	public String getMatPod() {
		return this.matPod;
	}
	
	/**
	 * Column Info
	 * @param restuff
	 */
	public void setRestuff(String restuff) {
		this.restuff = restuff;
	}
	
	/**
	 * Column Info
	 * @param cgoType
	 */
	public void setCgoType(String cgoType) {
		this.cgoType = cgoType;
	}
	
	/**
	 * Column Info
	 * @param pYard
	 */
	public void setPYard(String pYard) {
		this.pYard = pYard;
	}
	
	/**
	 * Column Info
	 * @param loclType
	 */
	public void setLoclType(String loclType) {
		this.loclType = loclType;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
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
	 * @param viewtype
	 */
	public void setViewtype(String viewtype) {
		this.viewtype = viewtype;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
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
	 * @param mvType
	 */
	public void setMvType(String mvType) {
		this.mvType = mvType;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param flgrslt
	 */
	public void setFlgrslt(String flgrslt) {
		this.flgrslt = flgrslt;
	}
	
	/**
	 * Column Info
	 * @param vlsCd
	 */
	public void setVlsCd(String vlsCd) {
		this.vlsCd = vlsCd;
	}
	
	/**
	 * Column Info
	 * @param fullFg
	 */
	public void setFullFg(String fullFg) {
		this.fullFg = fullFg;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param splnPod
	 */
	public void setSplnPod(String splnPod) {
		this.splnPod = splnPod;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param matPod
	 */
	public void setMatPod(String matPod) {
		this.matPod = matPod;
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
		setRestuff(JSPUtil.getParameter(request, prefix + "restuff", ""));
		setCgoType(JSPUtil.getParameter(request, prefix + "cgo_type", ""));
		setPYard(JSPUtil.getParameter(request, prefix + "p_yard", ""));
		setLoclType(JSPUtil.getParameter(request, prefix + "locl_type", ""));
		setTtl(JSPUtil.getParameter(request, prefix + "ttl", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setViewtype(JSPUtil.getParameter(request, prefix + "viewtype", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, prefix + "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setMvType(JSPUtil.getParameter(request, prefix + "mv_type", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFlgrslt(JSPUtil.getParameter(request, prefix + "flgrslt", ""));
		setVlsCd(JSPUtil.getParameter(request, prefix + "vls_cd", ""));
		setFullFg(JSPUtil.getParameter(request, prefix + "full_fg", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setSplnPod(JSPUtil.getParameter(request, prefix + "spln_pod", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setMatPod(JSPUtil.getParameter(request, prefix + "mat_pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConCBookingVO[]
	 */
	public ConCBookingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConCBookingVO[]
	 */
	public ConCBookingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConCBookingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] restuff = (JSPUtil.getParameter(request, prefix	+ "restuff", length));
			String[] cgoType = (JSPUtil.getParameter(request, prefix	+ "cgo_type", length));
			String[] pYard = (JSPUtil.getParameter(request, prefix	+ "p_yard", length));
			String[] loclType = (JSPUtil.getParameter(request, prefix	+ "locl_type", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] viewtype = (JSPUtil.getParameter(request, prefix	+ "viewtype", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] mvType = (JSPUtil.getParameter(request, prefix	+ "mv_type", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] flgrslt = (JSPUtil.getParameter(request, prefix	+ "flgrslt", length));
			String[] vlsCd = (JSPUtil.getParameter(request, prefix	+ "vls_cd", length));
			String[] fullFg = (JSPUtil.getParameter(request, prefix	+ "full_fg", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] splnPod = (JSPUtil.getParameter(request, prefix	+ "spln_pod", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] matPod = (JSPUtil.getParameter(request, prefix	+ "mat_pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new ConCBookingVO();
				if (restuff[i] != null)
					model.setRestuff(restuff[i]);
				if (cgoType[i] != null)
					model.setCgoType(cgoType[i]);
				if (pYard[i] != null)
					model.setPYard(pYard[i]);
				if (loclType[i] != null)
					model.setLoclType(loclType[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (viewtype[i] != null)
					model.setViewtype(viewtype[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (mvType[i] != null)
					model.setMvType(mvType[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (flgrslt[i] != null)
					model.setFlgrslt(flgrslt[i]);
				if (vlsCd[i] != null)
					model.setVlsCd(vlsCd[i]);
				if (fullFg[i] != null)
					model.setFullFg(fullFg[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (splnPod[i] != null)
					model.setSplnPod(splnPod[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (matPod[i] != null)
					model.setMatPod(matPod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConCBookingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ConCBookingVO[]
	 */
	public ConCBookingVO[] getConCBookingVOs(){
		ConCBookingVO[] vos = (ConCBookingVO[])models.toArray(new ConCBookingVO[models.size()]);
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
		this.restuff = this.restuff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoType = this.cgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard = this.pYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclType = this.loclType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewtype = this.viewtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvType = this.mvType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgrslt = this.flgrslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlsCd = this.vlsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFg = this.fullFg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splnPod = this.splnPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matPod = this.matPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
