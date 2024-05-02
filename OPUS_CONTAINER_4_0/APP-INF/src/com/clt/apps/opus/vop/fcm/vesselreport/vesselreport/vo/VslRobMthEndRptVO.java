/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VslRobMthEndRptVO.java
*@FileTitle : VslRobMthEndRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.11 진마리아 
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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslRobMthEndRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslRobMthEndRptVO> models = new ArrayList<VslRobMthEndRptVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String robMthEndRptCnt = null;
	/* Column Info */
	private String mssMtchRptCnt = null;
	/* Column Info */
	private String mssRptCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslRobMthEndRptVO() {}

	public VslRobMthEndRptVO(String ibflag, String pagerows, String mssMtchRptCnt, String robMthEndRptCnt, String vslSlanCd, String mssRptCnt, String vslCd) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.vslSlanCd = vslSlanCd;
		this.robMthEndRptCnt = robMthEndRptCnt;
		this.mssMtchRptCnt = mssMtchRptCnt;
		this.mssRptCnt = mssRptCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("rob_mth_end_rpt_cnt", getRobMthEndRptCnt());
		this.hashColumns.put("mss_mtch_rpt_cnt", getMssMtchRptCnt());
		this.hashColumns.put("mss_rpt_cnt", getMssRptCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("rob_mth_end_rpt_cnt", "robMthEndRptCnt");
		this.hashFields.put("mss_mtch_rpt_cnt", "mssMtchRptCnt");
		this.hashFields.put("mss_rpt_cnt", "mssRptCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return robMthEndRptCnt
	 */
	public String getRobMthEndRptCnt() {
		return this.robMthEndRptCnt;
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
	 * @return mssRptCnt
	 */
	public String getMssRptCnt() {
		return this.mssRptCnt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param robMthEndRptCnt
	 */
	public void setRobMthEndRptCnt(String robMthEndRptCnt) {
		this.robMthEndRptCnt = robMthEndRptCnt;
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
	 * @param mssRptCnt
	 */
	public void setMssRptCnt(String mssRptCnt) {
		this.mssRptCnt = mssRptCnt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setRobMthEndRptCnt(JSPUtil.getParameter(request, prefix + "rob_mth_end_rpt_cnt", ""));
		setMssMtchRptCnt(JSPUtil.getParameter(request, prefix + "mss_mtch_rpt_cnt", ""));
		setMssRptCnt(JSPUtil.getParameter(request, prefix + "mss_rpt_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslRobMthEndRptVO[]
	 */
	public VslRobMthEndRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslRobMthEndRptVO[]
	 */
	public VslRobMthEndRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslRobMthEndRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] robMthEndRptCnt = (JSPUtil.getParameter(request, prefix	+ "rob_mth_end_rpt_cnt", length));
			String[] mssMtchRptCnt = (JSPUtil.getParameter(request, prefix	+ "mss_mtch_rpt_cnt", length));
			String[] mssRptCnt = (JSPUtil.getParameter(request, prefix	+ "mss_rpt_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslRobMthEndRptVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (robMthEndRptCnt[i] != null)
					model.setRobMthEndRptCnt(robMthEndRptCnt[i]);
				if (mssMtchRptCnt[i] != null)
					model.setMssMtchRptCnt(mssMtchRptCnt[i]);
				if (mssRptCnt[i] != null)
					model.setMssRptCnt(mssRptCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslRobMthEndRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslRobMthEndRptVO[]
	 */
	public VslRobMthEndRptVO[] getVslRobMthEndRptVOs(){
		VslRobMthEndRptVO[] vos = (VslRobMthEndRptVO[])models.toArray(new VslRobMthEndRptVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.robMthEndRptCnt = this.robMthEndRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssMtchRptCnt = this.mssMtchRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssRptCnt = this.mssRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
