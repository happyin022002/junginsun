/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoPorDtVO.java
*@FileTitle : Edi315PrefixMainCOPInfoPorDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixMainCOPInfoPorDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoPorDtVO> models = new ArrayList<Edi315PrefixMainCOPInfoPorDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String porEtd = null;
	/* Column Info */
	private String porEtdGmt = null;
	/* Column Info */
	private String porAtdGmt = null;
	/* Column Info */
	private String porAtd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoPorDtVO() {}

	public Edi315PrefixMainCOPInfoPorDtVO(String ibflag, String pagerows, String porEtd, String porEtdGmt, String porAtd, String porAtdGmt) {
		this.ibflag = ibflag;
		this.porEtd = porEtd;
		this.porEtdGmt = porEtdGmt;
		this.porAtdGmt = porAtdGmt;
		this.porAtd = porAtd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("por_etd", getPorEtd());
		this.hashColumns.put("por_etd_gmt", getPorEtdGmt());
		this.hashColumns.put("por_atd_gmt", getPorAtdGmt());
		this.hashColumns.put("por_atd", getPorAtd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("por_etd", "porEtd");
		this.hashFields.put("por_etd_gmt", "porEtdGmt");
		this.hashFields.put("por_atd_gmt", "porAtdGmt");
		this.hashFields.put("por_atd", "porAtd");
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
	 * @return porEtd
	 */
	public String getPorEtd() {
		return this.porEtd;
	}
	
	/**
	 * Column Info
	 * @return porEtdGmt
	 */
	public String getPorEtdGmt() {
		return this.porEtdGmt;
	}
	
	/**
	 * Column Info
	 * @return porAtdGmt
	 */
	public String getPorAtdGmt() {
		return this.porAtdGmt;
	}
	
	/**
	 * Column Info
	 * @return porAtd
	 */
	public String getPorAtd() {
		return this.porAtd;
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
	 * @param porEtd
	 */
	public void setPorEtd(String porEtd) {
		this.porEtd = porEtd;
	}
	
	/**
	 * Column Info
	 * @param porEtdGmt
	 */
	public void setPorEtdGmt(String porEtdGmt) {
		this.porEtdGmt = porEtdGmt;
	}
	
	/**
	 * Column Info
	 * @param porAtdGmt
	 */
	public void setPorAtdGmt(String porAtdGmt) {
		this.porAtdGmt = porAtdGmt;
	}
	
	/**
	 * Column Info
	 * @param porAtd
	 */
	public void setPorAtd(String porAtd) {
		this.porAtd = porAtd;
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
		setPorEtd(JSPUtil.getParameter(request, prefix + "por_etd", ""));
		setPorEtdGmt(JSPUtil.getParameter(request, prefix + "por_etd_gmt", ""));
		setPorAtdGmt(JSPUtil.getParameter(request, prefix + "por_atd_gmt", ""));
		setPorAtd(JSPUtil.getParameter(request, prefix + "por_atd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoPorDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPorDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoPorDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPorDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoPorDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] porEtd = (JSPUtil.getParameter(request, prefix	+ "por_etd", length));
			String[] porEtdGmt = (JSPUtil.getParameter(request, prefix	+ "por_etd_gmt", length));
			String[] porAtdGmt = (JSPUtil.getParameter(request, prefix	+ "por_atd_gmt", length));
			String[] porAtd = (JSPUtil.getParameter(request, prefix	+ "por_atd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoPorDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (porEtd[i] != null)
					model.setPorEtd(porEtd[i]);
				if (porEtdGmt[i] != null)
					model.setPorEtdGmt(porEtdGmt[i]);
				if (porAtdGmt[i] != null)
					model.setPorAtdGmt(porAtdGmt[i]);
				if (porAtd[i] != null)
					model.setPorAtd(porAtd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoPorDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoPorDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPorDtVO[] getEdi315PrefixMainCOPInfoPorDtVOs(){
		Edi315PrefixMainCOPInfoPorDtVO[] vos = (Edi315PrefixMainCOPInfoPorDtVO[])models.toArray(new Edi315PrefixMainCOPInfoPorDtVO[models.size()]);
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
		this.porEtd = this.porEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEtdGmt = this.porEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAtdGmt = this.porAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAtd = this.porAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
