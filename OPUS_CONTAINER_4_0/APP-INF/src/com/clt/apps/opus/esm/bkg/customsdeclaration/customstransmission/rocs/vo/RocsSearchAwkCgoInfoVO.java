/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RocsSearchAwkCgoInfoVO.java
*@FileTitle : RocsSearchAwkCgoInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo;

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

public class RocsSearchAwkCgoInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchAwkCgoInfoVO> models = new ArrayList<RocsSearchAwkCgoInfoVO>();
	
	/* Column Info */
	private String akWdt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String akHgt = null;
	/* Column Info */
	private String akLgt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RocsSearchAwkCgoInfoVO() {}

	public RocsSearchAwkCgoInfoVO(String ibflag, String pagerows, String akLgt, String akHgt, String akWdt) {
		this.akWdt = akWdt;
		this.ibflag = ibflag;
		this.akHgt = akHgt;
		this.akLgt = akLgt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ak_wdt", getAkWdt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ak_hgt", getAkHgt());
		this.hashColumns.put("ak_lgt", getAkLgt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ak_wdt", "akWdt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ak_hgt", "akHgt");
		this.hashFields.put("ak_lgt", "akLgt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return akWdt
	 */
	public String getAkWdt() {
		return this.akWdt;
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
	 * @return akHgt
	 */
	public String getAkHgt() {
		return this.akHgt;
	}
	
	/**
	 * Column Info
	 * @return akLgt
	 */
	public String getAkLgt() {
		return this.akLgt;
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
	 * @param akWdt
	 */
	public void setAkWdt(String akWdt) {
		this.akWdt = akWdt;
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
	 * @param akHgt
	 */
	public void setAkHgt(String akHgt) {
		this.akHgt = akHgt;
	}
	
	/**
	 * Column Info
	 * @param akLgt
	 */
	public void setAkLgt(String akLgt) {
		this.akLgt = akLgt;
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
		setAkWdt(JSPUtil.getParameter(request, prefix + "ak_wdt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAkHgt(JSPUtil.getParameter(request, prefix + "ak_hgt", ""));
		setAkLgt(JSPUtil.getParameter(request, prefix + "ak_lgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchAwkCgoInfoVO[]
	 */
	public RocsSearchAwkCgoInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchAwkCgoInfoVO[]
	 */
	public RocsSearchAwkCgoInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchAwkCgoInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] akWdt = (JSPUtil.getParameter(request, prefix	+ "ak_wdt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] akHgt = (JSPUtil.getParameter(request, prefix	+ "ak_hgt", length));
			String[] akLgt = (JSPUtil.getParameter(request, prefix	+ "ak_lgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchAwkCgoInfoVO();
				if (akWdt[i] != null)
					model.setAkWdt(akWdt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (akHgt[i] != null)
					model.setAkHgt(akHgt[i]);
				if (akLgt[i] != null)
					model.setAkLgt(akLgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchAwkCgoInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchAwkCgoInfoVO[]
	 */
	public RocsSearchAwkCgoInfoVO[] getRocsSearchAwkCgoInfoVOs(){
		RocsSearchAwkCgoInfoVO[] vos = (RocsSearchAwkCgoInfoVO[])models.toArray(new RocsSearchAwkCgoInfoVO[models.size()]);
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
		this.akWdt = this.akWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akHgt = this.akHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akLgt = this.akLgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
