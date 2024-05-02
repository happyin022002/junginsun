/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AROfficeByUserOfficeVO.java
*@FileTitle : AROfficeByUserOfficeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo;

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

public class AROfficeByUserOfficeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AROfficeByUserOfficeVO> models = new ArrayList<AROfficeByUserOfficeVO>();
	
	/* Column Info */
	private String lginArHdQtrOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcLvlTp = null;
	/* Column Info */
	private String lginArOfcLvl = null;
	/* Column Info */
	private String lginArOfcCd = null;
	/* Column Info */
	private String lginOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AROfficeByUserOfficeVO() {}

	public AROfficeByUserOfficeVO(String ibflag, String pagerows, String lginArHdQtrOfcCd, String lginArOfcCd, String lginArOfcLvl, String lginOfcCd, String ofcLvlTp) {
		this.lginArHdQtrOfcCd = lginArHdQtrOfcCd;
		this.ibflag = ibflag;
		this.ofcLvlTp = ofcLvlTp;
		this.lginArOfcLvl = lginArOfcLvl;
		this.lginArOfcCd = lginArOfcCd;
		this.lginOfcCd = lginOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lgin_ar_hd_qtr_ofc_cd", getLginArHdQtrOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_lvl_tp", getOfcLvlTp());
		this.hashColumns.put("lgin_ar_ofc_lvl", getLginArOfcLvl());
		this.hashColumns.put("lgin_ar_ofc_cd", getLginArOfcCd());
		this.hashColumns.put("lgin_ofc_cd", getLginOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lgin_ar_hd_qtr_ofc_cd", "lginArHdQtrOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_lvl_tp", "ofcLvlTp");
		this.hashFields.put("lgin_ar_ofc_lvl", "lginArOfcLvl");
		this.hashFields.put("lgin_ar_ofc_cd", "lginArOfcCd");
		this.hashFields.put("lgin_ofc_cd", "lginOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lginArHdQtrOfcCd
	 */
	public String getLginArHdQtrOfcCd() {
		return this.lginArHdQtrOfcCd;
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
	 * @return ofcLvlTp
	 */
	public String getOfcLvlTp() {
		return this.ofcLvlTp;
	}
	
	/**
	 * Column Info
	 * @return lginArOfcLvl
	 */
	public String getLginArOfcLvl() {
		return this.lginArOfcLvl;
	}
	
	/**
	 * Column Info
	 * @return lginArOfcCd
	 */
	public String getLginArOfcCd() {
		return this.lginArOfcCd;
	}
	
	/**
	 * Column Info
	 * @return lginOfcCd
	 */
	public String getLginOfcCd() {
		return this.lginOfcCd;
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
	 * @param lginArHdQtrOfcCd
	 */
	public void setLginArHdQtrOfcCd(String lginArHdQtrOfcCd) {
		this.lginArHdQtrOfcCd = lginArHdQtrOfcCd;
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
	 * @param ofcLvlTp
	 */
	public void setOfcLvlTp(String ofcLvlTp) {
		this.ofcLvlTp = ofcLvlTp;
	}
	
	/**
	 * Column Info
	 * @param lginArOfcLvl
	 */
	public void setLginArOfcLvl(String lginArOfcLvl) {
		this.lginArOfcLvl = lginArOfcLvl;
	}
	
	/**
	 * Column Info
	 * @param lginArOfcCd
	 */
	public void setLginArOfcCd(String lginArOfcCd) {
		this.lginArOfcCd = lginArOfcCd;
	}
	
	/**
	 * Column Info
	 * @param lginOfcCd
	 */
	public void setLginOfcCd(String lginOfcCd) {
		this.lginOfcCd = lginOfcCd;
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
		setLginArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "lgin_ar_hd_qtr_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcLvlTp(JSPUtil.getParameter(request, prefix + "ofc_lvl_tp", ""));
		setLginArOfcLvl(JSPUtil.getParameter(request, prefix + "lgin_ar_ofc_lvl", ""));
		setLginArOfcCd(JSPUtil.getParameter(request, prefix + "lgin_ar_ofc_cd", ""));
		setLginOfcCd(JSPUtil.getParameter(request, prefix + "lgin_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AROfficeByUserOfficeVO[]
	 */
	public AROfficeByUserOfficeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AROfficeByUserOfficeVO[]
	 */
	public AROfficeByUserOfficeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AROfficeByUserOfficeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lginArHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "lgin_ar_hd_qtr_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcLvlTp = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl_tp", length));
			String[] lginArOfcLvl = (JSPUtil.getParameter(request, prefix	+ "lgin_ar_ofc_lvl", length));
			String[] lginArOfcCd = (JSPUtil.getParameter(request, prefix	+ "lgin_ar_ofc_cd", length));
			String[] lginOfcCd = (JSPUtil.getParameter(request, prefix	+ "lgin_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AROfficeByUserOfficeVO();
				if (lginArHdQtrOfcCd[i] != null)
					model.setLginArHdQtrOfcCd(lginArHdQtrOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcLvlTp[i] != null)
					model.setOfcLvlTp(ofcLvlTp[i]);
				if (lginArOfcLvl[i] != null)
					model.setLginArOfcLvl(lginArOfcLvl[i]);
				if (lginArOfcCd[i] != null)
					model.setLginArOfcCd(lginArOfcCd[i]);
				if (lginOfcCd[i] != null)
					model.setLginOfcCd(lginOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAROfficeByUserOfficeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AROfficeByUserOfficeVO[]
	 */
	public AROfficeByUserOfficeVO[] getAROfficeByUserOfficeVOs(){
		AROfficeByUserOfficeVO[] vos = (AROfficeByUserOfficeVO[])models.toArray(new AROfficeByUserOfficeVO[models.size()]);
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
		this.lginArHdQtrOfcCd = this.lginArHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLvlTp = this.ofcLvlTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginArOfcLvl = this.lginArOfcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginArOfcCd = this.lginArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginOfcCd = this.lginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
