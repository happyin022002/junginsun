/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchChgDeltPathStupVO.java
*@FileTitle : SearchChgDeltPathStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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

public class SearchChgDeltPathStupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchChgDeltPathStupVO> models = new ArrayList<SearchChgDeltPathStupVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgDeltOfcCd = null;
	/* Column Info */
	private String crntFlg = null;
	/* Column Info */
	private String tobeFlg = null;
	/* Column Info */
	private String expFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchChgDeltPathStupVO() {}

	public SearchChgDeltPathStupVO(String ibflag, String pagerows, String chgDeltOfcCd, String crntFlg, String tobeFlg, String expFlg) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.chgDeltOfcCd = chgDeltOfcCd;
		this.crntFlg = crntFlg;
		this.tobeFlg = tobeFlg;
		this.expFlg = expFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_delt_ofc_cd", getChgDeltOfcCd());
		this.hashColumns.put("crnt_flg", getCrntFlg());
		this.hashColumns.put("tobe_flg", getTobeFlg());
		this.hashColumns.put("exp_flg", getExpFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_delt_ofc_cd", "chgDeltOfcCd");
		this.hashFields.put("crnt_flg", "crntFlg");
		this.hashFields.put("tobe_flg", "tobeFlg");
		this.hashFields.put("exp_flg", "expFlg");
		
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}	
	/**
	 * Column Info
	 * @return chgDeltOfcCd
	 */
	public String getChgDeltOfcCd() {
		return this.chgDeltOfcCd;
	}
	/**
	 * Column Info
	 * @return crntFlg
	 */
	public String getCrntFlg() {
		return this.crntFlg;
		
	}
	/**
	 * Column Info
	 * @return tobeFlg
	 */
	public String getTobeFlg() {
		return this.tobeFlg;		
	}
	/**
	 * Column Info
	 * @return expFlg
	 */
	public String getExpFlg() {
		return this.expFlg;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param chgDeltOfcCd
	 */
	public void setChgDeltOfcCd(String chgDeltOfcCd) {
		this.chgDeltOfcCd = chgDeltOfcCd;
	}
	/**
	 * Column Info
	 * @param crntFlg
	 */
	public void setCrntFlg(String crntFlg) {
		this.crntFlg = crntFlg;
	}
	/**
	 * Column Info
	 * @param tobeFlg
	 */
	public void setTobeFlg(String tobeFlg) {
		this.tobeFlg = tobeFlg;
	}
	/**
	 * Column Info
	 * @param expFlg
	 */
	public void setExpFlg(String expFlg) {
		this.expFlg = expFlg;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChgDeltOfcCd(JSPUtil.getParameter(request, prefix + "chg_delt_ofc_cd", ""));
		setCrntFlg(JSPUtil.getParameter(request, prefix + "crnt_flg", ""));
		setTobeFlg(JSPUtil.getParameter(request, prefix + "tobe_flg", ""));
		setExpFlg(JSPUtil.getParameter(request, prefix + "exp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchChgDeltPathStupVO[]
	 */
	public SearchChgDeltPathStupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchChgDeltPathStupVO[]
	 */
	public SearchChgDeltPathStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchChgDeltPathStupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] chgDeltOfcCd = (JSPUtil.getParameter(request, prefix + "chg_delt_ofc_cd", length));
			String[] crntFlg = (JSPUtil.getParameter(request, prefix + "crnt_flg", length));
			String[] tobeFlg = (JSPUtil.getParameter(request, prefix + "tobe_flg", length));
			String[] expFlg = (JSPUtil.getParameter(request, prefix	+ "exp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchChgDeltPathStupVO();
				
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgDeltOfcCd[i] != null)
					model.setChgDeltOfcCd(chgDeltOfcCd[i]);
				if (crntFlg[i] != null)
					model.setCrntFlg(crntFlg[i]);
				if (tobeFlg[i] != null)
					model.setTobeFlg(tobeFlg[i]);
				if (expFlg[i] != null)
					model.setExpFlg(expFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchChgDeltPathStupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchChgDeltPathStupVO[]
	 */
	public SearchChgDeltPathStupVO[] getSearchChgDeltPathStupVOs(){
		SearchChgDeltPathStupVO[] vos = (SearchChgDeltPathStupVO[])models.toArray(new SearchChgDeltPathStupVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.chgDeltOfcCd = this.chgDeltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.crntFlg = this.crntFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.tobeFlg = this.tobeFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.expFlg = this.expFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
