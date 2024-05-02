/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VskSkdInfoForDepRptVO.java
*@FileTitle : VskSkdInfoForDepRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.vo;

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

public class VskSkdInfoForDepRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskSkdInfoForDepRptVO> models = new ArrayList<VskSkdInfoForDepRptVO>();
	
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String lastClptIndSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lastVslCd = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String lastSkdVoyNo = null;
	/* Column Info */
	private String lastSkdDirCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String lastPortCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VskSkdInfoForDepRptVO() {}

	public VskSkdInfoForDepRptVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String clptIndSeq, String lastVslCd, String lastSkdVoyNo, String lastSkdDirCd, String lastPortCd, String lastClptIndSeq) {
		this.vpsPortCd = vpsPortCd;
		this.vslCd = vslCd;
		this.lastClptIndSeq = lastClptIndSeq;
		this.ibflag = ibflag;
		this.lastVslCd = lastVslCd;
		this.clptIndSeq = clptIndSeq;
		this.lastSkdVoyNo = lastSkdVoyNo;
		this.lastSkdDirCd = lastSkdDirCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.lastPortCd = lastPortCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("last_clpt_ind_seq", getLastClptIndSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("last_vsl_cd", getLastVslCd());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("last_skd_voy_no", getLastSkdVoyNo());
		this.hashColumns.put("last_skd_dir_cd", getLastSkdDirCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("last_port_cd", getLastPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("last_clpt_ind_seq", "lastClptIndSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("last_vsl_cd", "lastVslCd");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("last_skd_voy_no", "lastSkdVoyNo");
		this.hashFields.put("last_skd_dir_cd", "lastSkdDirCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("last_port_cd", "lastPortCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return lastClptIndSeq
	 */
	public String getLastClptIndSeq() {
		return this.lastClptIndSeq;
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
	 * @return lastVslCd
	 */
	public String getLastVslCd() {
		return this.lastVslCd;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return lastSkdVoyNo
	 */
	public String getLastSkdVoyNo() {
		return this.lastSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return lastSkdDirCd
	 */
	public String getLastSkdDirCd() {
		return this.lastSkdDirCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return lastPortCd
	 */
	public String getLastPortCd() {
		return this.lastPortCd;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param lastClptIndSeq
	 */
	public void setLastClptIndSeq(String lastClptIndSeq) {
		this.lastClptIndSeq = lastClptIndSeq;
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
	 * @param lastVslCd
	 */
	public void setLastVslCd(String lastVslCd) {
		this.lastVslCd = lastVslCd;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param lastSkdVoyNo
	 */
	public void setLastSkdVoyNo(String lastSkdVoyNo) {
		this.lastSkdVoyNo = lastSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param lastSkdDirCd
	 */
	public void setLastSkdDirCd(String lastSkdDirCd) {
		this.lastSkdDirCd = lastSkdDirCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param lastPortCd
	 */
	public void setLastPortCd(String lastPortCd) {
		this.lastPortCd = lastPortCd;
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
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLastClptIndSeq(JSPUtil.getParameter(request, prefix + "last_clpt_ind_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLastVslCd(JSPUtil.getParameter(request, prefix + "last_vsl_cd", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setLastSkdVoyNo(JSPUtil.getParameter(request, prefix + "last_skd_voy_no", ""));
		setLastSkdDirCd(JSPUtil.getParameter(request, prefix + "last_skd_dir_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setLastPortCd(JSPUtil.getParameter(request, prefix + "last_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskSkdInfoForDepRptVO[]
	 */
	public VskSkdInfoForDepRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskSkdInfoForDepRptVO[]
	 */
	public VskSkdInfoForDepRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskSkdInfoForDepRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] lastClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "last_clpt_ind_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lastVslCd = (JSPUtil.getParameter(request, prefix	+ "last_vsl_cd", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] lastSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "last_skd_voy_no", length));
			String[] lastSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "last_skd_dir_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] lastPortCd = (JSPUtil.getParameter(request, prefix	+ "last_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskSkdInfoForDepRptVO();
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (lastClptIndSeq[i] != null)
					model.setLastClptIndSeq(lastClptIndSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lastVslCd[i] != null)
					model.setLastVslCd(lastVslCd[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (lastSkdVoyNo[i] != null)
					model.setLastSkdVoyNo(lastSkdVoyNo[i]);
				if (lastSkdDirCd[i] != null)
					model.setLastSkdDirCd(lastSkdDirCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (lastPortCd[i] != null)
					model.setLastPortCd(lastPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskSkdInfoForDepRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskSkdInfoForDepRptVO[]
	 */
	public VskSkdInfoForDepRptVO[] getVskSkdInfoForDepRptVOs(){
		VskSkdInfoForDepRptVO[] vos = (VskSkdInfoForDepRptVO[])models.toArray(new VskSkdInfoForDepRptVO[models.size()]);
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
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastClptIndSeq = this.lastClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastVslCd = this.lastVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastSkdVoyNo = this.lastSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastSkdDirCd = this.lastSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastPortCd = this.lastPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
