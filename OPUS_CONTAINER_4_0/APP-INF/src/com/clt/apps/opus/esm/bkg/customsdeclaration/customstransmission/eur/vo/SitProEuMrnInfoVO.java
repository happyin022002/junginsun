/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SitProEuMrnInfoVO.java
*@FileTitle : SitProEuMrnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.31  
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.12.23 김보배 [CHM-201327974] Sitpro 항목 추가
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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

public class SitProEuMrnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProEuMrnInfoVO> models = new ArrayList<SitProEuMrnInfoVO>();
	
	/* Column Info */
	private String euMrnDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String euMrnValue = null;
	/* Column Info */
	private String euPort = null;
	/* Column Info */
	private String euMrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String euMrnSource = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProEuMrnInfoVO() {}

	public SitProEuMrnInfoVO(String ibflag, String pagerows, String euMrnNo, String euMrnValue, String euPort, String euMrnDate, String euMrnSource) {
		this.euMrnDate = euMrnDate;
		this.ibflag = ibflag;
		this.euMrnValue = euMrnValue;
		this.euPort = euPort;
		this.euMrnNo = euMrnNo;
		this.pagerows = pagerows;
		this.euMrnSource = euMrnSource;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eu_mrn_date", getEuMrnDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eu_mrn_value", getEuMrnValue());
		this.hashColumns.put("eu_port", getEuPort());
		this.hashColumns.put("eu_mrn_no", getEuMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eu_mrn_source", getEuMrnSource());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eu_mrn_date", "euMrnDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eu_mrn_value", "euMrnValue");
		this.hashFields.put("eu_port", "euPort");
		this.hashFields.put("eu_mrn_no", "euMrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eu_mrn_source", "euMrnSource");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return euMrnDate
	 */
	public String getEuMrnDate() {
		return this.euMrnDate;
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
	 * @return euMrnValue
	 */
	public String getEuMrnValue() {
		return this.euMrnValue;
	}
	
	/**
	 * Column Info
	 * @return euPort
	 */
	public String getEuPort() {
		return this.euPort;
	}
	
	/**
	 * Column Info
	 * @return euMrnNo
	 */
	public String getEuMrnNo() {
		return this.euMrnNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Colum Info
	 * @return euMrnSource
	 */
	public String getEuMrnSource() {
		return this.euMrnSource;
	}
	

	/**
	 * Column Info
	 * @param euMrnDate
	 */
	public void setEuMrnDate(String euMrnDate) {
		this.euMrnDate = euMrnDate;
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
	 * @param euMrnValue
	 */
	public void setEuMrnValue(String euMrnValue) {
		this.euMrnValue = euMrnValue;
	}
	
	/**
	 * Column Info
	 * @param euPort
	 */
	public void setEuPort(String euPort) {
		this.euPort = euPort;
	}
	
	/**
	 * Column Info
	 * @param euMrnNo
	 */
	public void setEuMrnNo(String euMrnNo) {
		this.euMrnNo = euMrnNo;
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
	 * @param euMrnSource
	 */
	public void setEuMrnSource(String euMrnSource){
		this.euMrnSource = euMrnSource;
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
		setEuMrnDate(JSPUtil.getParameter(request, prefix + "eu_mrn_date", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEuMrnValue(JSPUtil.getParameter(request, prefix + "eu_mrn_value", ""));
		setEuPort(JSPUtil.getParameter(request, prefix + "eu_port", ""));
		setEuMrnNo(JSPUtil.getParameter(request, prefix + "eu_mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEuMrnSource(JSPUtil.getParameter(request, prefix + "eu_mrn_source", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProEuMrnInfoVO[]
	 */
	public SitProEuMrnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProEuMrnInfoVO[]
	 */
	public SitProEuMrnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProEuMrnInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] euMrnDate = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] euMrnValue = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_value", length));
			String[] euPort = (JSPUtil.getParameter(request, prefix	+ "eu_port", length));
			String[] euMrnNo = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] euMrnSource = (JSPUtil.getParameter(request, prefix	+ "eu_mrn_source", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProEuMrnInfoVO();
				if (euMrnDate[i] != null)
					model.setEuMrnDate(euMrnDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (euMrnValue[i] != null)
					model.setEuMrnValue(euMrnValue[i]);
				if (euPort[i] != null)
					model.setEuPort(euPort[i]);
				if (euMrnNo[i] != null)
					model.setEuMrnNo(euMrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (euMrnSource[i] != null)
					model.setEuMrnSource(euMrnSource[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProEuMrnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProEuMrnInfoVO[]
	 */
	public SitProEuMrnInfoVO[] getSitProEuMrnInfoVOs(){
		SitProEuMrnInfoVO[] vos = (SitProEuMrnInfoVO[])models.toArray(new SitProEuMrnInfoVO[models.size()]);
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
		this.euMrnDate = this.euMrnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euMrnValue = this.euMrnValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euPort = this.euPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euMrnNo = this.euMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.euMrnSource = this.euMrnSource .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
