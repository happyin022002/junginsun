/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OftPrecheckVO.java
*@FileTitle : OftPrecheckVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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

public class OftPrecheckVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OftPrecheckVO> models = new ArrayList<OftPrecheckVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nonRtStsCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String chkOft = null;
	/* Column Info */
	private String applicationDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OftPrecheckVO() {}

	public OftPrecheckVO(String ibflag, String pagerows, String nonRtStsCd, String chkOft, String applicationDt, String frtTermCd, String svcScpCd) {
		this.ibflag = ibflag;
		this.nonRtStsCd = nonRtStsCd;
		this.svcScpCd = svcScpCd;
		this.frtTermCd = frtTermCd;
		this.chkOft = chkOft;
		this.applicationDt = applicationDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("non_rt_sts_cd", getNonRtStsCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("chk_oft", getChkOft());
		this.hashColumns.put("application_dt", getApplicationDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("non_rt_sts_cd", "nonRtStsCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("chk_oft", "chkOft");
		this.hashFields.put("application_dt", "applicationDt");
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
	 * @return nonRtStsCd
	 */
	public String getNonRtStsCd() {
		return this.nonRtStsCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return chkOft
	 */
	public String getChkOft() {
		return this.chkOft;
	}
	
	/**
	 * Column Info
	 * @return applicationDt
	 */
	public String getApplicationDt() {
		return this.applicationDt;
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
	 * @param nonRtStsCd
	 */
	public void setNonRtStsCd(String nonRtStsCd) {
		this.nonRtStsCd = nonRtStsCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param chkOft
	 */
	public void setChkOft(String chkOft) {
		this.chkOft = chkOft;
	}
	
	/**
	 * Column Info
	 * @param applicationDt
	 */
	public void setApplicationDt(String applicationDt) {
		this.applicationDt = applicationDt;
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
		setNonRtStsCd(JSPUtil.getParameter(request, prefix + "non_rt_sts_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setChkOft(JSPUtil.getParameter(request, prefix + "chk_oft", ""));
		setApplicationDt(JSPUtil.getParameter(request, prefix + "application_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OftPrecheckVO[]
	 */
	public OftPrecheckVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OftPrecheckVO[]
	 */
	public OftPrecheckVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OftPrecheckVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nonRtStsCd = (JSPUtil.getParameter(request, prefix	+ "non_rt_sts_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] chkOft = (JSPUtil.getParameter(request, prefix	+ "chk_oft", length));
			String[] applicationDt = (JSPUtil.getParameter(request, prefix	+ "application_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new OftPrecheckVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nonRtStsCd[i] != null)
					model.setNonRtStsCd(nonRtStsCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (chkOft[i] != null)
					model.setChkOft(chkOft[i]);
				if (applicationDt[i] != null)
					model.setApplicationDt(applicationDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOftPrecheckVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OftPrecheckVO[]
	 */
	public OftPrecheckVO[] getOftPrecheckVOs(){
		OftPrecheckVO[] vos = (OftPrecheckVO[])models.toArray(new OftPrecheckVO[models.size()]);
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
		this.nonRtStsCd = this.nonRtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOft = this.chkOft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applicationDt = this.applicationDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
