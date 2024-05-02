/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VslRptInqVO.java
*@FileTitle : VslRptInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslRptInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslRptInqVO> models = new ArrayList<VslRptInqVO>();
	
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String searchinfo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String searchkey = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String searchcon = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslRptInqVO() {}

	public VslRptInqVO(String ibflag, String pagerows, String searchinfo, String searchkey, String searchcon, String toDt, String vpsPortCd, String vslCd, String fmDt, String vslSlanCd, String skdDirCd) {
		this.toDt = toDt;
		this.vslCd = vslCd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.fmDt = fmDt;
		this.searchinfo = searchinfo;
		this.vslSlanCd = vslSlanCd;
		this.searchkey = searchkey;
		this.skdDirCd = skdDirCd;
		this.searchcon = searchcon;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("searchinfo", getSearchinfo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("searchkey", getSearchkey());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("searchcon", getSearchcon());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("searchinfo", "searchinfo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("searchkey", "searchkey");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("searchcon", "searchcon");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return searchinfo
	 */
	public String getSearchinfo() {
		return this.searchinfo;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return searchkey
	 */
	public String getSearchkey() {
		return this.searchkey;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return searchcon
	 */
	public String getSearchcon() {
		return this.searchcon;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param searchinfo
	 */
	public void setSearchinfo(String searchinfo) {
		this.searchinfo = searchinfo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param searchkey
	 */
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param searchcon
	 */
	public void setSearchcon(String searchcon) {
		this.searchcon = searchcon;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setSearchinfo(JSPUtil.getParameter(request, prefix + "searchinfo", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setSearchkey(JSPUtil.getParameter(request, prefix + "searchkey", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSearchcon(JSPUtil.getParameter(request, prefix + "searchcon", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslRptInqVO[]
	 */
	public VslRptInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslRptInqVO[]
	 */
	public VslRptInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslRptInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] searchinfo = (JSPUtil.getParameter(request, prefix	+ "searchinfo", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] searchkey = (JSPUtil.getParameter(request, prefix	+ "searchkey", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] searchcon = (JSPUtil.getParameter(request, prefix	+ "searchcon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslRptInqVO();
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (searchinfo[i] != null)
					model.setSearchinfo(searchinfo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (searchkey[i] != null)
					model.setSearchkey(searchkey[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (searchcon[i] != null)
					model.setSearchcon(searchcon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslRptInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslRptInqVO[]
	 */
	public VslRptInqVO[] getVslRptInqVOs(){
		VslRptInqVO[] vos = (VslRptInqVO[])models.toArray(new VslRptInqVO[models.size()]);
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
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchinfo = this.searchinfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchkey = this.searchkey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchcon = this.searchcon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
