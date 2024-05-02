/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaSearchPkgMarkVO.java
*@FileTitle : ManilaSearchPkgMarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

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

public class ManilaSearchPkgMarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManilaSearchPkgMarkVO> models = new ArrayList<ManilaSearchPkgMarkVO>();
	
	/* Column Info */
	private String mark2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String descGood2 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String regNumber5 = null;
	/* Column Info */
	private String blNo4 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManilaSearchPkgMarkVO() {}

	public ManilaSearchPkgMarkVO(String ibflag, String pagerows, String regNumber5, String blNo4, String descGood2, String mark2, String seq) {
		this.mark2 = mark2;
		this.ibflag = ibflag;
		this.descGood2 = descGood2;
		this.seq = seq;
		this.regNumber5 = regNumber5;
		this.blNo4 = blNo4;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mark2", getMark2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("desc_good2", getDescGood2());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("reg_number5", getRegNumber5());
		this.hashColumns.put("bl_no4", getBlNo4());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mark2", "mark2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("desc_good2", "descGood2");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("reg_number5", "regNumber5");
		this.hashFields.put("bl_no4", "blNo4");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mark2
	 */
	public String getMark2() {
		return this.mark2;
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
	 * @return descGood2
	 */
	public String getDescGood2() {
		return this.descGood2;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return regNumber5
	 */
	public String getRegNumber5() {
		return this.regNumber5;
	}
	
	/**
	 * Column Info
	 * @return blNo4
	 */
	public String getBlNo4() {
		return this.blNo4;
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
	 * @param mark2
	 */
	public void setMark2(String mark2) {
		this.mark2 = mark2;
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
	 * @param descGood2
	 */
	public void setDescGood2(String descGood2) {
		this.descGood2 = descGood2;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param regNumber5
	 */
	public void setRegNumber5(String regNumber5) {
		this.regNumber5 = regNumber5;
	}
	
	/**
	 * Column Info
	 * @param blNo4
	 */
	public void setBlNo4(String blNo4) {
		this.blNo4 = blNo4;
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
		setMark2(JSPUtil.getParameter(request, "mark2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDescGood2(JSPUtil.getParameter(request, "desc_good2", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRegNumber5(JSPUtil.getParameter(request, "reg_number5", ""));
		setBlNo4(JSPUtil.getParameter(request, "bl_no4", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManilaSearchPkgMarkVO[]
	 */
	public ManilaSearchPkgMarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManilaSearchPkgMarkVO[]
	 */
	public ManilaSearchPkgMarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManilaSearchPkgMarkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mark2 = (JSPUtil.getParameter(request, prefix	+ "mark2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] descGood2 = (JSPUtil.getParameter(request, prefix	+ "desc_good2", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] regNumber5 = (JSPUtil.getParameter(request, prefix	+ "reg_number5", length));
			String[] blNo4 = (JSPUtil.getParameter(request, prefix	+ "bl_no4", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManilaSearchPkgMarkVO();
				if (mark2[i] != null)
					model.setMark2(mark2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (descGood2[i] != null)
					model.setDescGood2(descGood2[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (regNumber5[i] != null)
					model.setRegNumber5(regNumber5[i]);
				if (blNo4[i] != null)
					model.setBlNo4(blNo4[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManilaSearchPkgMarkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManilaSearchPkgMarkVO[]
	 */
	public ManilaSearchPkgMarkVO[] getManilaSearchPkgMarkVOs(){
		ManilaSearchPkgMarkVO[] vos = (ManilaSearchPkgMarkVO[])models.toArray(new ManilaSearchPkgMarkVO[models.size()]);
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
		this.mark2 = this.mark2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descGood2 = this.descGood2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regNumber5 = this.regNumber5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo4 = this.blNo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
