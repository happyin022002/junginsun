/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustRepEmlInfoVO.java
*@FileTitle : CustRepEmlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.16  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

import java.lang.reflect.Field;
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

public class CustRepEmlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	 
	private Collection<CustRepEmlInfoVO> models = new ArrayList<CustRepEmlInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inEml = null;
	/* Column Info */
	private String inBound = null;
	/* Column Info */
	private String outEml = null;
	/* Column Info */
	private String outBound = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustRepEmlInfoVO() {}

	public CustRepEmlInfoVO(String ibflag, String pagerows, String arOfcCd, String outBound, String outEml, String inBound, String inEml) {
		this.ibflag = ibflag;
		this.inEml = inEml;
		this.inBound = inBound;
		this.outEml = outEml;
		this.outBound = outBound;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_eml", getInEml());
		this.hashColumns.put("in_bound", getInBound());
		this.hashColumns.put("out_eml", getOutEml());
		this.hashColumns.put("out_bound", getOutBound());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_eml", "inEml");
		this.hashFields.put("in_bound", "inBound");
		this.hashFields.put("out_eml", "outEml");
		this.hashFields.put("out_bound", "outBound");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
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
	 * @return inEml
	 */
	public String getInEml() {
		return this.inEml;
	}
	
	/**
	 * Column Info
	 * @return inBound
	 */
	public String getInBound() {
		return this.inBound;
	}
	
	/**
	 * Column Info
	 * @return outEml
	 */
	public String getOutEml() {
		return this.outEml;
	}
	
	/**
	 * Column Info
	 * @return outBound
	 */
	public String getOutBound() {
		return this.outBound;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @param inEml
	 */
	public void setInEml(String inEml) {
		this.inEml = inEml;
	}
	
	/**
	 * Column Info
	 * @param inBound
	 */
	public void setInBound(String inBound) {
		this.inBound = inBound;
	}
	
	/**
	 * Column Info
	 * @param outEml
	 */
	public void setOutEml(String outEml) {
		this.outEml = outEml;
	}
	
	/**
	 * Column Info
	 * @param outBound
	 */
	public void setOutBound(String outBound) {
		this.outBound = outBound;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
		setInEml(JSPUtil.getParameter(request, prefix + "in_eml", ""));
		setInBound(JSPUtil.getParameter(request, prefix + "in_bound", ""));
		setOutEml(JSPUtil.getParameter(request, prefix + "out_eml", ""));
		setOutBound(JSPUtil.getParameter(request, prefix + "out_bound", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustRepEmlInfoVO[]
	 */
	public CustRepEmlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustRepEmlInfoVO[]
	 */
	public CustRepEmlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustRepEmlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inEml = (JSPUtil.getParameter(request, prefix	+ "in_eml", length));
			String[] inBound = (JSPUtil.getParameter(request, prefix	+ "in_bound", length));
			String[] outEml = (JSPUtil.getParameter(request, prefix	+ "out_eml", length));
			String[] outBound = (JSPUtil.getParameter(request, prefix	+ "out_bound", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustRepEmlInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inEml[i] != null)
					model.setInEml(inEml[i]);
				if (inBound[i] != null)
					model.setInBound(inBound[i]);
				if (outEml[i] != null)
					model.setOutEml(outEml[i]);
				if (outBound[i] != null)
					model.setOutBound(outBound[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustRepEmlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustRepEmlInfoVO[]
	 */
	public CustRepEmlInfoVO[] getCustRepEmlInfoVOs(){
		CustRepEmlInfoVO[] vos = (CustRepEmlInfoVO[])models.toArray(new CustRepEmlInfoVO[models.size()]);
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
		this.inEml = this.inEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBound = this.inBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outEml = this.outEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outBound = this.outBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
