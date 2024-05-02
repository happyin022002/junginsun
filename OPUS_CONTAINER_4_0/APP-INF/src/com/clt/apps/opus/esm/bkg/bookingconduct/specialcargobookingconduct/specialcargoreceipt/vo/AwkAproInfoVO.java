/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AwkAproInfoVO.java
*@FileTitle : AwkAproInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2010.02.25 이병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AwkAproInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AwkAproInfoVO> models = new ArrayList<AwkAproInfoVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstGdt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AwkAproInfoVO() {}

	public AwkAproInfoVO(String ibflag, String pagerows, String rqstUsrId, String rqstDt, String rqstGdt) {
		this.rqstDt = rqstDt;
		this.rqstUsrId = rqstUsrId;
		this.ibflag = ibflag;
		this.rqstGdt = rqstGdt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_gdt", getRqstGdt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_gdt", "rqstGdt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return rqstGdt
	 */
	public String getRqstGdt() {
		return this.rqstGdt;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param rqstGdt
	 */
	public void setRqstGdt(String rqstGdt) {
		this.rqstGdt = rqstGdt;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstGdt(JSPUtil.getParameter(request, prefix + "rqst_gdt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AwkAproInfoVO[]
	 */
	public AwkAproInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AwkAproInfoVO[]
	 */
	public AwkAproInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AwkAproInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstGdt = (JSPUtil.getParameter(request, prefix	+ "rqst_gdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AwkAproInfoVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstGdt[i] != null)
					model.setRqstGdt(rqstGdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAwkAproInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AwkAproInfoVO[]
	 */
	public AwkAproInfoVO[] getAwkAproInfoVOs(){
		AwkAproInfoVO[] vos = (AwkAproInfoVO[])models.toArray(new AwkAproInfoVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstGdt = this.rqstGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
