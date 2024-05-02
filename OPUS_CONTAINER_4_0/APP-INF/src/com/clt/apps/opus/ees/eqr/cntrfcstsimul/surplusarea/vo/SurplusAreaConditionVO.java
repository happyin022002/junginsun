/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SurplusAreaConditionVO.java
*@FileTitle : SurplusAreaConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrfcstsimul.surplusarea.vo;

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
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SurplusAreaConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SurplusAreaConditionVO> models = new ArrayList<SurplusAreaConditionVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String fmYrwk = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toYrwk = null;
	/* Column Info */
	private String levelCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String currYrwk = null;
	/* Column Info */
	private String locTypeCode = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SurplusAreaConditionVO() {}

	public SurplusAreaConditionVO(String ibflag, String pagerows, String fmYrwk, String locCd, String toYrwk, String rccCd, String locTypeCode, String currYrwk, String ofcCd, String levelCd) {
		this.ofcCd = ofcCd;
		this.fmYrwk = fmYrwk;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.toYrwk = toYrwk;
		this.levelCd = levelCd;
		this.rccCd = rccCd;
		this.currYrwk = currYrwk;
		this.locTypeCode = locTypeCode;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("fm_yrwk", getFmYrwk());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_yrwk", getToYrwk());
		this.hashColumns.put("level_cd", getLevelCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("curr_yrwk", getCurrYrwk());
		this.hashColumns.put("loc_type_code", getLocTypeCode());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("fm_yrwk", "fmYrwk");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_yrwk", "toYrwk");
		this.hashFields.put("level_cd", "levelCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("curr_yrwk", "currYrwk");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return fmYrwk
	 */
	public String getFmYrwk() {
		return this.fmYrwk;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return toYrwk
	 */
	public String getToYrwk() {
		return this.toYrwk;
	}
	
	/**
	 * Column Info
	 * @return levelCd
	 */
	public String getLevelCd() {
		return this.levelCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return currYrwk
	 */
	public String getCurrYrwk() {
		return this.currYrwk;
	}
	
	/**
	 * Column Info
	 * @return locTypeCode
	 */
	public String getLocTypeCode() {
		return this.locTypeCode;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param fmYrwk
	 */
	public void setFmYrwk(String fmYrwk) {
		this.fmYrwk = fmYrwk;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param toYrwk
	 */
	public void setToYrwk(String toYrwk) {
		this.toYrwk = toYrwk;
	}
	
	/**
	 * Column Info
	 * @param levelCd
	 */
	public void setLevelCd(String levelCd) {
		this.levelCd = levelCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param currYrwk
	 */
	public void setCurrYrwk(String currYrwk) {
		this.currYrwk = currYrwk;
	}
	
	/**
	 * Column Info
	 * @param locTypeCode
	 */
	public void setLocTypeCode(String locTypeCode) {
		this.locTypeCode = locTypeCode;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setFmYrwk(JSPUtil.getParameter(request, prefix + "fm_yrwk", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToYrwk(JSPUtil.getParameter(request, prefix + "to_yrwk", ""));
		setLevelCd(JSPUtil.getParameter(request, prefix + "level_cd", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setCurrYrwk(JSPUtil.getParameter(request, prefix + "curr_yrwk", ""));
		setLocTypeCode(JSPUtil.getParameter(request, prefix + "loc_type_code", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SurplusAreaConditionVO[]
	 */
	public SurplusAreaConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SurplusAreaConditionVO[]
	 */
	public SurplusAreaConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SurplusAreaConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] fmYrwk = (JSPUtil.getParameter(request, prefix	+ "fm_yrwk", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toYrwk = (JSPUtil.getParameter(request, prefix	+ "to_yrwk", length));
			String[] levelCd = (JSPUtil.getParameter(request, prefix	+ "level_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] currYrwk = (JSPUtil.getParameter(request, prefix	+ "curr_yrwk", length));
			String[] locTypeCode = (JSPUtil.getParameter(request, prefix	+ "loc_type_code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SurplusAreaConditionVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (fmYrwk[i] != null)
					model.setFmYrwk(fmYrwk[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toYrwk[i] != null)
					model.setToYrwk(toYrwk[i]);
				if (levelCd[i] != null)
					model.setLevelCd(levelCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (currYrwk[i] != null)
					model.setCurrYrwk(currYrwk[i]);
				if (locTypeCode[i] != null)
					model.setLocTypeCode(locTypeCode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSurplusAreaConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SurplusAreaConditionVO[]
	 */
	public SurplusAreaConditionVO[] getSurplusAreaConditionVOs(){
		SurplusAreaConditionVO[] vos = (SurplusAreaConditionVO[])models.toArray(new SurplusAreaConditionVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYrwk = this.fmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYrwk = this.toYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.levelCd = this.levelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currYrwk = this.currYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode = this.locTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
