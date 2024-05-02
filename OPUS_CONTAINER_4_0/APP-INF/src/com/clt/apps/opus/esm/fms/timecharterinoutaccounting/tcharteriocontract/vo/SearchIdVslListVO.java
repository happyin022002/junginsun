/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchIdVslListVO.java
*@FileTitle : SearchIdVslListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.02.01 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIdVslListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIdVslListVO> models = new ArrayList<SearchIdVslListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oriVslCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String fletRptFlg = null;
	/* Column Info */
	private String oriVslEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIdVslListVO() {}

	public SearchIdVslListVO(String ibflag, String pagerows, String vslCd, String vslEngNm, String oriVslCd, String oriVslEngNm, String useFlg, String fletRptFlg) {
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.oriVslCd = oriVslCd;
		this.vslEngNm = vslEngNm;
		this.useFlg = useFlg;
		this.fletRptFlg = fletRptFlg;
		this.oriVslEngNm = oriVslEngNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ori_vsl_cd", getOriVslCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("flet_rpt_flg", getFletRptFlg());
		this.hashColumns.put("ori_vsl_eng_nm", getOriVslEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ori_vsl_cd", "oriVslCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("flet_rpt_flg", "fletRptFlg");
		this.hashFields.put("ori_vsl_eng_nm", "oriVslEngNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return oriVslCd
	 */
	public String getOriVslCd() {
		return this.oriVslCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
	}
	
	/**
	 * Column Info
	 * @return fletRptFlg
	 */
	public String getFletRptFlg() {
		return this.fletRptFlg;
	}
	
	/**
	 * Column Info
	 * @return oriVslEngNm
	 */
	public String getOriVslEngNm() {
		return this.oriVslEngNm;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param oriVslCd
	 */
	public void setOriVslCd(String oriVslCd) {
		this.oriVslCd = oriVslCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
	}
	
	/**
	 * Column Info
	 * @param fletRptFlg
	 */
	public void setFletRptFlg(String fletRptFlg) {
		this.fletRptFlg = fletRptFlg;
	}
	
	/**
	 * Column Info
	 * @param oriVslEngNm
	 */
	public void setOriVslEngNm(String oriVslEngNm) {
		this.oriVslEngNm = oriVslEngNm;
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
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOriVslCd(JSPUtil.getParameter(request, "ori_vsl_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setUseFlg(JSPUtil.getParameter(request, "use_flg", ""));
		setFletRptFlg(JSPUtil.getParameter(request, "flet_rpt_flg", ""));
		setOriVslEngNm(JSPUtil.getParameter(request, "ori_vsl_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIdVslListVO[]
	 */
	public SearchIdVslListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIdVslListVO[]
	 */
	public SearchIdVslListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIdVslListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oriVslCd = (JSPUtil.getParameter(request, prefix	+ "ori_vsl_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] fletRptFlg = (JSPUtil.getParameter(request, prefix	+ "flet_rpt_flg", length));
			String[] oriVslEngNm = (JSPUtil.getParameter(request, prefix	+ "ori_vsl_eng_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIdVslListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oriVslCd[i] != null)
					model.setOriVslCd(oriVslCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (fletRptFlg[i] != null)
					model.setFletRptFlg(fletRptFlg[i]);
				if (oriVslEngNm[i] != null)
					model.setOriVslEngNm(oriVslEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIdVslListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIdVslListVO[]
	 */
	public SearchIdVslListVO[] getSearchIdVslListVOs(){
		SearchIdVslListVO[] vos = (SearchIdVslListVO[])models.toArray(new SearchIdVslListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriVslCd = this.oriVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletRptFlg = this.fletRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriVslEngNm = this.oriVslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
