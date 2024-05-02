/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VslDepRptVO.java
*@FileTitle : VslDepRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.11  
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

public class VslDepRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslDepRptVO> models = new ArrayList<VslDepRptVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mssPortCnt = null;
	/* Column Info */
	private String depRptCnt = null;
	/* Column Info */
	private String portCnt = null;
	/* Column Info */
	private String mssMtchRptCnt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslDepRptVO() {}

	public VslDepRptVO(String ibflag, String pagerows, String vslSlanCd, String vvdCnt, String portCnt, String depRptCnt, String mssPortCnt, String mssMtchRptCnt) {
		this.ibflag = ibflag;
		this.mssPortCnt = mssPortCnt;
		this.depRptCnt = depRptCnt;
		this.portCnt = portCnt;
		this.mssMtchRptCnt = mssMtchRptCnt;
		this.vslSlanCd = vslSlanCd;
		this.vvdCnt = vvdCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mss_port_cnt", getMssPortCnt());
		this.hashColumns.put("dep_rpt_cnt", getDepRptCnt());
		this.hashColumns.put("port_cnt", getPortCnt());
		this.hashColumns.put("mss_mtch_rpt_cnt", getMssMtchRptCnt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vvd_cnt", getVvdCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mss_port_cnt", "mssPortCnt");
		this.hashFields.put("dep_rpt_cnt", "depRptCnt");
		this.hashFields.put("port_cnt", "portCnt");
		this.hashFields.put("mss_mtch_rpt_cnt", "mssMtchRptCnt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return mssPortCnt
	 */
	public String getMssPortCnt() {
		return this.mssPortCnt;
	}
	
	/**
	 * Column Info
	 * @return depRptCnt
	 */
	public String getDepRptCnt() {
		return this.depRptCnt;
	}
	
	/**
	 * Column Info
	 * @return portCnt
	 */
	public String getPortCnt() {
		return this.portCnt;
	}
	
	/**
	 * Column Info
	 * @return mssMtchRptCnt
	 */
	public String getMssMtchRptCnt() {
		return this.mssMtchRptCnt;
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
	 * @return vvdCnt
	 */
	public String getVvdCnt() {
		return this.vvdCnt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param mssPortCnt
	 */
	public void setMssPortCnt(String mssPortCnt) {
		this.mssPortCnt = mssPortCnt;
	}
	
	/**
	 * Column Info
	 * @param depRptCnt
	 */
	public void setDepRptCnt(String depRptCnt) {
		this.depRptCnt = depRptCnt;
	}
	
	/**
	 * Column Info
	 * @param portCnt
	 */
	public void setPortCnt(String portCnt) {
		this.portCnt = portCnt;
	}
	
	/**
	 * Column Info
	 * @param mssMtchRptCnt
	 */
	public void setMssMtchRptCnt(String mssMtchRptCnt) {
		this.mssMtchRptCnt = mssMtchRptCnt;
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
	 * @param vvdCnt
	 */
	public void setVvdCnt(String vvdCnt) {
		this.vvdCnt = vvdCnt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMssPortCnt(JSPUtil.getParameter(request, prefix + "mss_port_cnt", ""));
		setDepRptCnt(JSPUtil.getParameter(request, prefix + "dep_rpt_cnt", ""));
		setPortCnt(JSPUtil.getParameter(request, prefix + "port_cnt", ""));
		setMssMtchRptCnt(JSPUtil.getParameter(request, prefix + "mss_mtch_rpt_cnt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslDepRptVO[]
	 */
	public VslDepRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslDepRptVO[]
	 */
	public VslDepRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslDepRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mssPortCnt = (JSPUtil.getParameter(request, prefix	+ "mss_port_cnt", length));
			String[] depRptCnt = (JSPUtil.getParameter(request, prefix	+ "dep_rpt_cnt", length));
			String[] portCnt = (JSPUtil.getParameter(request, prefix	+ "port_cnt", length));
			String[] mssMtchRptCnt = (JSPUtil.getParameter(request, prefix	+ "mss_mtch_rpt_cnt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslDepRptVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mssPortCnt[i] != null)
					model.setMssPortCnt(mssPortCnt[i]);
				if (depRptCnt[i] != null)
					model.setDepRptCnt(depRptCnt[i]);
				if (portCnt[i] != null)
					model.setPortCnt(portCnt[i]);
				if (mssMtchRptCnt[i] != null)
					model.setMssMtchRptCnt(mssMtchRptCnt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslDepRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslDepRptVO[]
	 */
	public VslDepRptVO[] getVslDepRptVOs(){
		VslDepRptVO[] vos = (VslDepRptVO[])models.toArray(new VslDepRptVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssPortCnt = this.mssPortCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depRptCnt = this.depRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCnt = this.portCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssMtchRptCnt = this.mssMtchRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
