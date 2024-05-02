/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VslABLogRptVO.java
*@FileTitle : VslABLogRptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.10
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.10 진마리아 
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

public class VslABLogRptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslABLogRptVO> models = new ArrayList<VslABLogRptVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mssMtchRptCnt = null;
	/* Column Info */
	private String ablogRptCnt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String mssRptCnt = null;
	/* Column Info */
	private String vvdCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslABLogRptVO() {}

	public VslABLogRptVO(String ibflag, String pagerows, String vslSlanCd, String vvdCnt, String ablogRptCnt, String mssRptCnt, String mssMtchRptCnt) {
		this.ibflag = ibflag;
		this.mssMtchRptCnt = mssMtchRptCnt;
		this.ablogRptCnt = ablogRptCnt;
		this.vslSlanCd = vslSlanCd;
		this.mssRptCnt = mssRptCnt;
		this.vvdCnt = vvdCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mss_mtch_rpt_cnt", getMssMtchRptCnt());
		this.hashColumns.put("ablog_rpt_cnt", getAblogRptCnt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("mss_rpt_cnt", getMssRptCnt());
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
		this.hashFields.put("mss_mtch_rpt_cnt", "mssMtchRptCnt");
		this.hashFields.put("ablog_rpt_cnt", "ablogRptCnt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("mss_rpt_cnt", "mssRptCnt");
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
	 * @return mssMtchRptCnt
	 */
	public String getMssMtchRptCnt() {
		return this.mssMtchRptCnt;
	}
	
	/**
	 * Column Info
	 * @return ablogRptCnt
	 */
	public String getAblogRptCnt() {
		return this.ablogRptCnt;
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
	 * @return mssRptCnt
	 */
	public String getMssRptCnt() {
		return this.mssRptCnt;
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
	 * @param mssMtchRptCnt
	 */
	public void setMssMtchRptCnt(String mssMtchRptCnt) {
		this.mssMtchRptCnt = mssMtchRptCnt;
	}
	
	/**
	 * Column Info
	 * @param ablogRptCnt
	 */
	public void setAblogRptCnt(String ablogRptCnt) {
		this.ablogRptCnt = ablogRptCnt;
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
	 * @param mssRptCnt
	 */
	public void setMssRptCnt(String mssRptCnt) {
		this.mssRptCnt = mssRptCnt;
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
		setMssMtchRptCnt(JSPUtil.getParameter(request, prefix + "mss_mtch_rpt_cnt", ""));
		setAblogRptCnt(JSPUtil.getParameter(request, prefix + "ablog_rpt_cnt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setMssRptCnt(JSPUtil.getParameter(request, prefix + "mss_rpt_cnt", ""));
		setVvdCnt(JSPUtil.getParameter(request, prefix + "vvd_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslABLogRptVO[]
	 */
	public VslABLogRptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslABLogRptVO[]
	 */
	public VslABLogRptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslABLogRptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mssMtchRptCnt = (JSPUtil.getParameter(request, prefix	+ "mss_mtch_rpt_cnt", length));
			String[] ablogRptCnt = (JSPUtil.getParameter(request, prefix	+ "ablog_rpt_cnt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] mssRptCnt = (JSPUtil.getParameter(request, prefix	+ "mss_rpt_cnt", length));
			String[] vvdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslABLogRptVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mssMtchRptCnt[i] != null)
					model.setMssMtchRptCnt(mssMtchRptCnt[i]);
				if (ablogRptCnt[i] != null)
					model.setAblogRptCnt(ablogRptCnt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (mssRptCnt[i] != null)
					model.setMssRptCnt(mssRptCnt[i]);
				if (vvdCnt[i] != null)
					model.setVvdCnt(vvdCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslABLogRptVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslABLogRptVO[]
	 */
	public VslABLogRptVO[] getVslABLogRptVOs(){
		VslABLogRptVO[] vos = (VslABLogRptVO[])models.toArray(new VslABLogRptVO[models.size()]);
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
		this.mssMtchRptCnt = this.mssMtchRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ablogRptCnt = this.ablogRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssRptCnt = this.mssRptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt = this.vvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
