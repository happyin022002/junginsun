/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SriLankaCargoInfoVO.java
*@FileTitle : SriLankaCargoInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo;

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

public class SriLankaCargoInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaCargoInfoVO> models = new ArrayList<SriLankaCargoInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dgDesc = null;
	/* Column Info */
	private String cargoDesc = null;
	/* Column Info */
	private String splitDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SriLankaCargoInfoVO() {}

	public SriLankaCargoInfoVO(String ibflag, String pagerows, String cargoDesc, String splitDesc, String dgDesc) {
		this.ibflag = ibflag;
		this.dgDesc = dgDesc;
		this.cargoDesc = cargoDesc;
		this.splitDesc = splitDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg_desc", getDgDesc());
		this.hashColumns.put("cargo_desc", getCargoDesc());
		this.hashColumns.put("split_desc", getSplitDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg_desc", "dgDesc");
		this.hashFields.put("cargo_desc", "cargoDesc");
		this.hashFields.put("split_desc", "splitDesc");
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
	 * @return dgDesc
	 */
	public String getDgDesc() {
		return this.dgDesc;
	}
	
	/**
	 * Column Info
	 * @return cargoDesc
	 */
	public String getCargoDesc() {
		return this.cargoDesc;
	}
	
	/**
	 * Column Info
	 * @return splitDesc
	 */
	public String getSplitDesc() {
		return this.splitDesc;
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
	 * @param dgDesc
	 */
	public void setDgDesc(String dgDesc) {
		this.dgDesc = dgDesc;
	}
	
	/**
	 * Column Info
	 * @param cargoDesc
	 */
	public void setCargoDesc(String cargoDesc) {
		this.cargoDesc = cargoDesc;
	}
	
	/**
	 * Column Info
	 * @param splitDesc
	 */
	public void setSplitDesc(String splitDesc) {
		this.splitDesc = splitDesc;
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
		setDgDesc(JSPUtil.getParameter(request, prefix + "dg_desc", ""));
		setCargoDesc(JSPUtil.getParameter(request, prefix + "cargo_desc", ""));
		setSplitDesc(JSPUtil.getParameter(request, prefix + "split_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaCargoInfoVO[]
	 */
	public SriLankaCargoInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaCargoInfoVO[]
	 */
	public SriLankaCargoInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaCargoInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dgDesc = (JSPUtil.getParameter(request, prefix	+ "dg_desc", length));
			String[] cargoDesc = (JSPUtil.getParameter(request, prefix	+ "cargo_desc", length));
			String[] splitDesc = (JSPUtil.getParameter(request, prefix	+ "split_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaCargoInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dgDesc[i] != null)
					model.setDgDesc(dgDesc[i]);
				if (cargoDesc[i] != null)
					model.setCargoDesc(cargoDesc[i]);
				if (splitDesc[i] != null)
					model.setSplitDesc(splitDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaCargoInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaCargoInfoVO[]
	 */
	public SriLankaCargoInfoVO[] getSriLankaCargoInfoVOs(){
		SriLankaCargoInfoVO[] vos = (SriLankaCargoInfoVO[])models.toArray(new SriLankaCargoInfoVO[models.size()]);
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
		this.dgDesc = this.dgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoDesc = this.cargoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitDesc = this.splitDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
