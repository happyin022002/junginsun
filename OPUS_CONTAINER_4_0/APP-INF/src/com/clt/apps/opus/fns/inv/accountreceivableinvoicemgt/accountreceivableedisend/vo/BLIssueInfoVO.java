/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssueInfoVO.java
*@FileTitle : BLIssueInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
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

public class BLIssueInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BLIssueInfoVO> models = new ArrayList<BLIssueInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blIssuer = null;
	/* Column Info */
	private String blPlace = null;
	/* Column Info */
	private String conInd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BLIssueInfoVO() {}

	public BLIssueInfoVO(String ibflag, String pagerows, String conInd, String blPlace, String blIssuer) {
		this.ibflag = ibflag;
		this.blIssuer = blIssuer;
		this.blPlace = blPlace;
		this.conInd = conInd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_issuer", getBlIssuer());
		this.hashColumns.put("bl_place", getBlPlace());
		this.hashColumns.put("con_ind", getConInd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_issuer", "blIssuer");
		this.hashFields.put("bl_place", "blPlace");
		this.hashFields.put("con_ind", "conInd");
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
	 * @return blIssuer
	 */
	public String getBlIssuer() {
		return this.blIssuer;
	}
	
	/**
	 * Column Info
	 * @return blPlace
	 */
	public String getBlPlace() {
		return this.blPlace;
	}
	
	/**
	 * Column Info
	 * @return conInd
	 */
	public String getConInd() {
		return this.conInd;
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
	 * @param blIssuer
	 */
	public void setBlIssuer(String blIssuer) {
		this.blIssuer = blIssuer;
	}
	
	/**
	 * Column Info
	 * @param blPlace
	 */
	public void setBlPlace(String blPlace) {
		this.blPlace = blPlace;
	}
	
	/**
	 * Column Info
	 * @param conInd
	 */
	public void setConInd(String conInd) {
		this.conInd = conInd;
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
		setBlIssuer(JSPUtil.getParameter(request, prefix + "bl_issuer", ""));
		setBlPlace(JSPUtil.getParameter(request, prefix + "bl_place", ""));
		setConInd(JSPUtil.getParameter(request, prefix + "con_ind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BLIssueInfoVO[]
	 */
	public BLIssueInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BLIssueInfoVO[]
	 */
	public BLIssueInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BLIssueInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blIssuer = (JSPUtil.getParameter(request, prefix	+ "bl_issuer", length));
			String[] blPlace = (JSPUtil.getParameter(request, prefix	+ "bl_place", length));
			String[] conInd = (JSPUtil.getParameter(request, prefix	+ "con_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BLIssueInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blIssuer[i] != null)
					model.setBlIssuer(blIssuer[i]);
				if (blPlace[i] != null)
					model.setBlPlace(blPlace[i]);
				if (conInd[i] != null)
					model.setConInd(conInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBLIssueInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BLIssueInfoVO[]
	 */
	public BLIssueInfoVO[] getBLIssueInfoVOs(){
		BLIssueInfoVO[] vos = (BLIssueInfoVO[])models.toArray(new BLIssueInfoVO[models.size()]);
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
		this.blIssuer = this.blIssuer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPlace = this.blPlace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conInd = this.conInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
