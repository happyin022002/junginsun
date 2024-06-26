/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BdrSpclVO.java
*@FileTitle : BdrSpclVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.10.30 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BdrSpclVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BdrSpclVO> models = new ArrayList<BdrSpclVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclcgoflag = null;
	/* Column Info */
	private String bdrflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BdrSpclVO() {}

	public BdrSpclVO(String ibflag, String pagerows, String bdrflag, String spclcgoflag) {
		this.ibflag = ibflag;
		this.spclcgoflag = spclcgoflag;
		this.bdrflag = bdrflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spclcgoflag", getSpclcgoflag());
		this.hashColumns.put("bdrflag", getBdrflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spclcgoflag", "spclcgoflag");
		this.hashFields.put("bdrflag", "bdrflag");
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
	 * @return spclcgoflag
	 */
	public String getSpclcgoflag() {
		return this.spclcgoflag;
	}
	
	/**
	 * Column Info
	 * @return bdrflag
	 */
	public String getBdrflag() {
		return this.bdrflag;
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
	 * @param spclcgoflag
	 */
	public void setSpclcgoflag(String spclcgoflag) {
		this.spclcgoflag = spclcgoflag;
	}
	
	/**
	 * Column Info
	 * @param bdrflag
	 */
	public void setBdrflag(String bdrflag) {
		this.bdrflag = bdrflag;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpclcgoflag(JSPUtil.getParameter(request, "spclcgoflag", ""));
		setBdrflag(JSPUtil.getParameter(request, "bdrflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BdrSpclVO[]
	 */
	public BdrSpclVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BdrSpclVO[]
	 */
	public BdrSpclVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BdrSpclVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclcgoflag = (JSPUtil.getParameter(request, prefix	+ "spclcgoflag", length));
			String[] bdrflag = (JSPUtil.getParameter(request, prefix	+ "bdrflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BdrSpclVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclcgoflag[i] != null)
					model.setSpclcgoflag(spclcgoflag[i]);
				if (bdrflag[i] != null)
					model.setBdrflag(bdrflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBdrSpclVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BdrSpclVO[]
	 */
	public BdrSpclVO[] getBdrSpclVOs(){
		BdrSpclVO[] vos = (BdrSpclVO[])models.toArray(new BdrSpclVO[models.size()]);
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
		this.spclcgoflag = this.spclcgoflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrflag = this.bdrflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
