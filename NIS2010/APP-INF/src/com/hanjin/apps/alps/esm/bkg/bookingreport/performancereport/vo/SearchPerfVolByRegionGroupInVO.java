/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchPerfVolByRegionGroupInVO.java
*@FileTitle : SearchPerfVolByRegionGroupInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.08  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPerfVolByRegionGroupInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPerfVolByRegionGroupInVO> models = new ArrayList<SearchPerfVolByRegionGroupInVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String listAtndUsrId = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String toMt = null;
	/* Column Info */
	private String selGroup = null;
	/* Column Info */
	private String picCd = null;
	/* Column Info */
	private String qGroup = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String selRegion = null;
	/* Column Info */
	private String pfmByQueueCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String atndUsrId = null;
	/* Column Info */
	private String sel = null;
	/* Column Info */
	private String fromMt = null;
	/* Column Info */
	private String dpcsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPerfVolByRegionGroupInVO() {}

	public SearchPerfVolByRegionGroupInVO(String ibflag, String pagerows, String region, String fromDt, String toMt, String selGroup, String picCd, String qGroup, String toDt, String srKndCd, String bkgNo, String selRegion, String vvdCd, String pfmByQueueCd, String usrId, String atndUsrId, String fromMt, String dpcsOfcCd, String sel, String srStsCd, String listAtndUsrId) {
		this.region = region;
		this.fromDt = fromDt;
		this.listAtndUsrId = listAtndUsrId;
		this.srStsCd = srStsCd;
		this.toMt = toMt;
		this.selGroup = selGroup;
		this.picCd = picCd;
		this.qGroup = qGroup;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.ibflag = ibflag;
		this.srKndCd = srKndCd;
		this.bkgNo = bkgNo;
		this.selRegion = selRegion;
		this.pfmByQueueCd = pfmByQueueCd;
		this.vvdCd = vvdCd;
		this.usrId = usrId;
		this.atndUsrId = atndUsrId;
		this.sel = sel;
		this.fromMt = fromMt;
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("list_atnd_usr_id", getListAtndUsrId());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("to_mt", getToMt());
		this.hashColumns.put("sel_group", getSelGroup());
		this.hashColumns.put("pic_cd", getPicCd());
		this.hashColumns.put("q_group", getQGroup());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sel_region", getSelRegion());
		this.hashColumns.put("pfm_by_queue_cd", getPfmByQueueCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("atnd_usr_id", getAtndUsrId());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("from_mt", getFromMt());
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("list_atnd_usr_id", "listAtndUsrId");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("to_mt", "toMt");
		this.hashFields.put("sel_group", "selGroup");
		this.hashFields.put("pic_cd", "picCd");
		this.hashFields.put("q_group", "qGroup");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sel_region", "selRegion");
		this.hashFields.put("pfm_by_queue_cd", "pfmByQueueCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("atnd_usr_id", "atndUsrId");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("from_mt", "fromMt");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
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
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return listAtndUsrId
	 */
	public String getListAtndUsrId() {
		return this.listAtndUsrId;
	}
	
	/**
	 * Column Info
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return toMt
	 */
	public String getToMt() {
		return this.toMt;
	}
	
	/**
	 * Column Info
	 * @return selGroup
	 */
	public String getSelGroup() {
		return this.selGroup;
	}
	
	/**
	 * Column Info
	 * @return picCd
	 */
	public String getPicCd() {
		return this.picCd;
	}
	
	/**
	 * Column Info
	 * @return qGroup
	 */
	public String getQGroup() {
		return this.qGroup;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return selRegion
	 */
	public String getSelRegion() {
		return this.selRegion;
	}
	
	/**
	 * Column Info
	 * @return pfmByQueueCd
	 */
	public String getPfmByQueueCd() {
		return this.pfmByQueueCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return atndUsrId
	 */
	public String getAtndUsrId() {
		return this.atndUsrId;
	}
	
	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}
	
	/**
	 * Column Info
	 * @return fromMt
	 */
	public String getFromMt() {
		return this.fromMt;
	}
	
	/**
	 * Column Info
	 * @return dpcsOfcCd
	 */
	public String getDpcsOfcCd() {
		return this.dpcsOfcCd;
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
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param listAtndUsrId
	 */
	public void setListAtndUsrId(String listAtndUsrId) {
		this.listAtndUsrId = listAtndUsrId;
	}
	
	/**
	 * Column Info
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param toMt
	 */
	public void setToMt(String toMt) {
		this.toMt = toMt;
	}
	
	/**
	 * Column Info
	 * @param selGroup
	 */
	public void setSelGroup(String selGroup) {
		this.selGroup = selGroup;
	}
	
	/**
	 * Column Info
	 * @param picCd
	 */
	public void setPicCd(String picCd) {
		this.picCd = picCd;
	}
	
	/**
	 * Column Info
	 * @param qGroup
	 */
	public void setQGroup(String qGroup) {
		this.qGroup = qGroup;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param selRegion
	 */
	public void setSelRegion(String selRegion) {
		this.selRegion = selRegion;
	}
	
	/**
	 * Column Info
	 * @param pfmByQueueCd
	 */
	public void setPfmByQueueCd(String pfmByQueueCd) {
		this.pfmByQueueCd = pfmByQueueCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param atndUsrId
	 */
	public void setAtndUsrId(String atndUsrId) {
		this.atndUsrId = atndUsrId;
	}
	
	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}
	
	/**
	 * Column Info
	 * @param fromMt
	 */
	public void setFromMt(String fromMt) {
		this.fromMt = fromMt;
	}
	
	/**
	 * Column Info
	 * @param dpcsOfcCd
	 */
	public void setDpcsOfcCd(String dpcsOfcCd) {
		this.dpcsOfcCd = dpcsOfcCd;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setListAtndUsrId(JSPUtil.getParameter(request, prefix + "list_atnd_usr_id", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setToMt(JSPUtil.getParameter(request, prefix + "to_mt", ""));
		setSelGroup(JSPUtil.getParameter(request, prefix + "sel_group", ""));
		setPicCd(JSPUtil.getParameter(request, prefix + "pic_cd", ""));
		setQGroup(JSPUtil.getParameter(request, prefix + "q_group", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrKndCd(JSPUtil.getParameter(request, prefix + "sr_knd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSelRegion(JSPUtil.getParameter(request, prefix + "sel_region", ""));
		setPfmByQueueCd(JSPUtil.getParameter(request, prefix + "pfm_by_queue_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAtndUsrId(JSPUtil.getParameter(request, prefix + "atnd_usr_id", ""));
		setSel(JSPUtil.getParameter(request, prefix + "sel", ""));
		setFromMt(JSPUtil.getParameter(request, prefix + "from_mt", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request, prefix + "dpcs_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPerfVolByRegionGroupInVO[]
	 */
	public SearchPerfVolByRegionGroupInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPerfVolByRegionGroupInVO[]
	 */
	public SearchPerfVolByRegionGroupInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPerfVolByRegionGroupInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] listAtndUsrId = (JSPUtil.getParameter(request, prefix	+ "list_atnd_usr_id", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] toMt = (JSPUtil.getParameter(request, prefix	+ "to_mt", length));
			String[] selGroup = (JSPUtil.getParameter(request, prefix	+ "sel_group", length));
			String[] picCd = (JSPUtil.getParameter(request, prefix	+ "pic_cd", length));
			String[] qGroup = (JSPUtil.getParameter(request, prefix	+ "q_group", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] selRegion = (JSPUtil.getParameter(request, prefix	+ "sel_region", length));
			String[] pfmByQueueCd = (JSPUtil.getParameter(request, prefix	+ "pfm_by_queue_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] atndUsrId = (JSPUtil.getParameter(request, prefix	+ "atnd_usr_id", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] fromMt = (JSPUtil.getParameter(request, prefix	+ "from_mt", length));
			String[] dpcsOfcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPerfVolByRegionGroupInVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (listAtndUsrId[i] != null)
					model.setListAtndUsrId(listAtndUsrId[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (toMt[i] != null)
					model.setToMt(toMt[i]);
				if (selGroup[i] != null)
					model.setSelGroup(selGroup[i]);
				if (picCd[i] != null)
					model.setPicCd(picCd[i]);
				if (qGroup[i] != null)
					model.setQGroup(qGroup[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (selRegion[i] != null)
					model.setSelRegion(selRegion[i]);
				if (pfmByQueueCd[i] != null)
					model.setPfmByQueueCd(pfmByQueueCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (atndUsrId[i] != null)
					model.setAtndUsrId(atndUsrId[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (fromMt[i] != null)
					model.setFromMt(fromMt[i]);
				if (dpcsOfcCd[i] != null)
					model.setDpcsOfcCd(dpcsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPerfVolByRegionGroupInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPerfVolByRegionGroupInVO[]
	 */
	public SearchPerfVolByRegionGroupInVO[] getSearchPerfVolByRegionGroupInVOs(){
		SearchPerfVolByRegionGroupInVO[] vos = (SearchPerfVolByRegionGroupInVO[])models.toArray(new SearchPerfVolByRegionGroupInVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.listAtndUsrId = this.listAtndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMt = this.toMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selGroup = this.selGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picCd = this.picCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qGroup = this.qGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selRegion = this.selRegion .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmByQueueCd = this.pfmByQueueCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atndUsrId = this.atndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromMt = this.fromMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd = this.dpcsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
