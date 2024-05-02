/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AusCuscarMarkDescVO.java
*@FileTitle : AusCuscarMarkDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.29  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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

public class AusCuscarMarkDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusCuscarMarkDescVO> models = new ArrayList<AusCuscarMarkDescVO>();
	
	/* Column Info */
	private String mark01 = null;
	/* Column Info */
	private String mark10 = null;
	/* Column Info */
	private String mark02 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mark09 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mark08 = null;
	/* Column Info */
	private String mark07 = null;
	/* Column Info */
	private String mark06 = null;
	/* Column Info */
	private String mark05 = null;
	/* Column Info */
	private String description = null;
	/* Column Info */
	private String mark04 = null;
	/* Column Info */
	private String mark03 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusCuscarMarkDescVO() {}

	public AusCuscarMarkDescVO(String ibflag, String pagerows, String description, String mark01, String mark02, String mark03, String mark04, String mark05, String mark06, String mark07, String mark08, String mark09, String mark10) {
		this.mark01 = mark01;
		this.mark10 = mark10;
		this.mark02 = mark02;
		this.pagerows = pagerows;
		this.mark09 = mark09;
		this.ibflag = ibflag;
		this.mark08 = mark08;
		this.mark07 = mark07;
		this.mark06 = mark06;
		this.mark05 = mark05;
		this.description = description;
		this.mark04 = mark04;
		this.mark03 = mark03;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mark01", getMark01());
		this.hashColumns.put("mark10", getMark10());
		this.hashColumns.put("mark02", getMark02());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mark09", getMark09());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mark08", getMark08());
		this.hashColumns.put("mark07", getMark07());
		this.hashColumns.put("mark06", getMark06());
		this.hashColumns.put("mark05", getMark05());
		this.hashColumns.put("description", getDescription());
		this.hashColumns.put("mark04", getMark04());
		this.hashColumns.put("mark03", getMark03());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mark01", "mark01");
		this.hashFields.put("mark10", "mark10");
		this.hashFields.put("mark02", "mark02");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mark09", "mark09");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mark08", "mark08");
		this.hashFields.put("mark07", "mark07");
		this.hashFields.put("mark06", "mark06");
		this.hashFields.put("mark05", "mark05");
		this.hashFields.put("description", "description");
		this.hashFields.put("mark04", "mark04");
		this.hashFields.put("mark03", "mark03");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mark01
	 */
	public String getMark01() {
		return this.mark01;
	}
	
	/**
	 * Column Info
	 * @return mark10
	 */
	public String getMark10() {
		return this.mark10;
	}
	
	/**
	 * Column Info
	 * @return mark02
	 */
	public String getMark02() {
		return this.mark02;
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
	 * @return mark09
	 */
	public String getMark09() {
		return this.mark09;
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
	 * @return mark08
	 */
	public String getMark08() {
		return this.mark08;
	}
	
	/**
	 * Column Info
	 * @return mark07
	 */
	public String getMark07() {
		return this.mark07;
	}
	
	/**
	 * Column Info
	 * @return mark06
	 */
	public String getMark06() {
		return this.mark06;
	}
	
	/**
	 * Column Info
	 * @return mark05
	 */
	public String getMark05() {
		return this.mark05;
	}
	
	/**
	 * Column Info
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Column Info
	 * @return mark04
	 */
	public String getMark04() {
		return this.mark04;
	}
	
	/**
	 * Column Info
	 * @return mark03
	 */
	public String getMark03() {
		return this.mark03;
	}
	

	/**
	 * Column Info
	 * @param mark01
	 */
	public void setMark01(String mark01) {
		this.mark01 = mark01;
	}
	
	/**
	 * Column Info
	 * @param mark10
	 */
	public void setMark10(String mark10) {
		this.mark10 = mark10;
	}
	
	/**
	 * Column Info
	 * @param mark02
	 */
	public void setMark02(String mark02) {
		this.mark02 = mark02;
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
	 * @param mark09
	 */
	public void setMark09(String mark09) {
		this.mark09 = mark09;
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
	 * @param mark08
	 */
	public void setMark08(String mark08) {
		this.mark08 = mark08;
	}
	
	/**
	 * Column Info
	 * @param mark07
	 */
	public void setMark07(String mark07) {
		this.mark07 = mark07;
	}
	
	/**
	 * Column Info
	 * @param mark06
	 */
	public void setMark06(String mark06) {
		this.mark06 = mark06;
	}
	
	/**
	 * Column Info
	 * @param mark05
	 */
	public void setMark05(String mark05) {
		this.mark05 = mark05;
	}
	
	/**
	 * Column Info
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Column Info
	 * @param mark04
	 */
	public void setMark04(String mark04) {
		this.mark04 = mark04;
	}
	
	/**
	 * Column Info
	 * @param mark03
	 */
	public void setMark03(String mark03) {
		this.mark03 = mark03;
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
		setMark01(JSPUtil.getParameter(request, prefix + "mark01", ""));
		setMark10(JSPUtil.getParameter(request, prefix + "mark10", ""));
		setMark02(JSPUtil.getParameter(request, prefix + "mark02", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMark09(JSPUtil.getParameter(request, prefix + "mark09", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMark08(JSPUtil.getParameter(request, prefix + "mark08", ""));
		setMark07(JSPUtil.getParameter(request, prefix + "mark07", ""));
		setMark06(JSPUtil.getParameter(request, prefix + "mark06", ""));
		setMark05(JSPUtil.getParameter(request, prefix + "mark05", ""));
		setDescription(JSPUtil.getParameter(request, prefix + "description", ""));
		setMark04(JSPUtil.getParameter(request, prefix + "mark04", ""));
		setMark03(JSPUtil.getParameter(request, prefix + "mark03", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusCuscarMarkDescVO[]
	 */
	public AusCuscarMarkDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusCuscarMarkDescVO[]
	 */
	public AusCuscarMarkDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusCuscarMarkDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mark01 = (JSPUtil.getParameter(request, prefix	+ "mark01", length));
			String[] mark10 = (JSPUtil.getParameter(request, prefix	+ "mark10", length));
			String[] mark02 = (JSPUtil.getParameter(request, prefix	+ "mark02", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mark09 = (JSPUtil.getParameter(request, prefix	+ "mark09", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mark08 = (JSPUtil.getParameter(request, prefix	+ "mark08", length));
			String[] mark07 = (JSPUtil.getParameter(request, prefix	+ "mark07", length));
			String[] mark06 = (JSPUtil.getParameter(request, prefix	+ "mark06", length));
			String[] mark05 = (JSPUtil.getParameter(request, prefix	+ "mark05", length));
			String[] description = (JSPUtil.getParameter(request, prefix	+ "description", length));
			String[] mark04 = (JSPUtil.getParameter(request, prefix	+ "mark04", length));
			String[] mark03 = (JSPUtil.getParameter(request, prefix	+ "mark03", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusCuscarMarkDescVO();
				if (mark01[i] != null)
					model.setMark01(mark01[i]);
				if (mark10[i] != null)
					model.setMark10(mark10[i]);
				if (mark02[i] != null)
					model.setMark02(mark02[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mark09[i] != null)
					model.setMark09(mark09[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mark08[i] != null)
					model.setMark08(mark08[i]);
				if (mark07[i] != null)
					model.setMark07(mark07[i]);
				if (mark06[i] != null)
					model.setMark06(mark06[i]);
				if (mark05[i] != null)
					model.setMark05(mark05[i]);
				if (description[i] != null)
					model.setDescription(description[i]);
				if (mark04[i] != null)
					model.setMark04(mark04[i]);
				if (mark03[i] != null)
					model.setMark03(mark03[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusCuscarMarkDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusCuscarMarkDescVO[]
	 */
	public AusCuscarMarkDescVO[] getAusCuscarMarkDescVOs(){
		AusCuscarMarkDescVO[] vos = (AusCuscarMarkDescVO[])models.toArray(new AusCuscarMarkDescVO[models.size()]);
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
		this.mark01 = this.mark01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark10 = this.mark10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark02 = this.mark02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark09 = this.mark09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark08 = this.mark08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark07 = this.mark07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark06 = this.mark06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark05 = this.mark05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description = this.description .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark04 = this.mark04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mark03 = this.mark03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
