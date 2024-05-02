/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DgRiderCntrListVO.java
*@FileTitle : DgRiderCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.22  
* 1.0 Creation
* 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgRiderCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgRiderCntrListVO> models = new ArrayList<DgRiderCntrListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cargoName = null;
	/* Column Info */
	private String cargoValue = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DgRiderCntrListVO() {}

	public DgRiderCntrListVO(String ibflag, String pagerows, String cargoName, String cargoValue) {
		this.ibflag = ibflag;
		this.cargoName = cargoName;
		this.cargoValue = cargoValue;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cargo_name", getCargoName());
		this.hashColumns.put("cargo_value", getCargoValue());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cargo_name", "cargoName");
		this.hashFields.put("cargo_value", "cargoValue");
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
	 * @return cargoName
	 */
	public String getCargoName() {
		return this.cargoName;
	}
	
	/**
	 * Column Info
	 * @return cargoValue
	 */
	public String getCargoValue() {
		return this.cargoValue;
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
	 * @param cargoName
	 */
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	
	/**
	 * Column Info
	 * @param cargoValue
	 */
	public void setCargoValue(String cargoValue) {
		this.cargoValue = cargoValue;
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
		setCargoName(JSPUtil.getParameter(request, prefix + "cargo_name", ""));
		setCargoValue(JSPUtil.getParameter(request, prefix + "cargo_value", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgRiderCntrListVO[]
	 */
	public DgRiderCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgRiderCntrListVO[]
	 */
	public DgRiderCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgRiderCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cargoName = (JSPUtil.getParameter(request, prefix	+ "cargo_name", length));
			String[] cargoValue = (JSPUtil.getParameter(request, prefix	+ "cargo_value", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgRiderCntrListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cargoName[i] != null)
					model.setCargoName(cargoName[i]);
				if (cargoValue[i] != null)
					model.setCargoValue(cargoValue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgRiderCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgRiderCntrListVO[]
	 */
	public DgRiderCntrListVO[] getDgRiderCntrListVOs(){
		DgRiderCntrListVO[] vos = (DgRiderCntrListVO[])models.toArray(new DgRiderCntrListVO[models.size()]);
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
		this.cargoName = this.cargoName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoValue = this.cargoValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
