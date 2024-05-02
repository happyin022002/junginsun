/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccrualCodeInfo.java
*@FileTitle : AccrualCodeInfo
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class AccrualCodeInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AccrualCodeInfoVO> models = new ArrayList<AccrualCodeInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String code = null;

	/* Column Info */
	private String name = null;

	/* Column Info */
	private String dpSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AccrualCodeInfoVO() {}

	public AccrualCodeInfoVO(String ibflag, String pagerows, String code, String name, String dpSeq) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.code = code;
		this.name = name;
		this.dpSeq = dpSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("dp_seq", getDpSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("code", "code");
		this.hashFields.put("name", "name");
		this.hashFields.put("dp_seq", "dpSeq");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * 
	 * @return String code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 *
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 *
	 * @param String dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * 
	 * @return String dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccrualCodeInfo[]
	 */
	public AccrualCodeInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AccrualCodeInfo[]
	 */
	public AccrualCodeInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AccrualCodeInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new AccrualCodeInfoVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (code[i] != null) 
					model.setCode(code[i]);
				if (name[i] != null) 
					model.setName(name[i]);
				if (dpSeq[i] != null) 
					model.setDpSeq(dpSeq[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAccrualCodeInfos();
	}

	/**
	 * VO 배열을 반환
	 * @return AccrualCodeInfo[]
	 */
	public AccrualCodeInfoVO[] getAccrualCodeInfos(){
		AccrualCodeInfoVO[] vos = (AccrualCodeInfoVO[])models.toArray(new AccrualCodeInfoVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}