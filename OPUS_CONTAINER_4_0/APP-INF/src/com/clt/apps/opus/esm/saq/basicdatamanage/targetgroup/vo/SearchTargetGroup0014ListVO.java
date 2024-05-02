/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SearchTargetGroup0014ListVO.java
*@FileTitle      : SearchTargetGroup0014ListVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTargetGroup0014ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTargetGroup0014ListVO> models = new ArrayList<SearchTargetGroup0014ListVO>();
	
	/* Column Info */
	private String saqTgtGrpDesc = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String saqTgtGrpCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTargetGroup0014ListVO() {}

	public SearchTargetGroup0014ListVO(String ibflag, String pagerows, String saqTgtGrpCd, String ofcCd, String saqTgtGrpDesc, String deltFlg) {
		this.saqTgtGrpDesc = saqTgtGrpDesc;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.saqTgtGrpCd = saqTgtGrpCd;
		this.deltFlg = deltFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("saq_tgt_grp_desc", getSaqTgtGrpDesc());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("saq_tgt_grp_cd", getSaqTgtGrpCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("saq_tgt_grp_desc", "saqTgtGrpDesc");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("saq_tgt_grp_cd", "saqTgtGrpCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return saqTgtGrpDesc
	 */
	public String getSaqTgtGrpDesc() {
		return this.saqTgtGrpDesc;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return saqTgtGrpCd
	 */
	public String getSaqTgtGrpCd() {
		return this.saqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @param saqTgtGrpDesc
	 */
	public void setSaqTgtGrpDesc(String saqTgtGrpDesc) {
		this.saqTgtGrpDesc = saqTgtGrpDesc;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param saqTgtGrpCd
	 */
	public void setSaqTgtGrpCd(String saqTgtGrpCd) {
		this.saqTgtGrpCd = saqTgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
		setSaqTgtGrpDesc(JSPUtil.getParameter(request, "saq_tgt_grp_desc", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSaqTgtGrpCd(JSPUtil.getParameter(request, "saq_tgt_grp_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTargetGroup0014ListVO[]
	 */
	public SearchTargetGroup0014ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTargetGroup0014ListVO[]
	 */
	public SearchTargetGroup0014ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTargetGroup0014ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] saqTgtGrpDesc = (JSPUtil.getParameter(request, prefix	+ "saq_tgt_grp_desc", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] saqTgtGrpCd = (JSPUtil.getParameter(request, prefix	+ "saq_tgt_grp_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTargetGroup0014ListVO();
				if (saqTgtGrpDesc[i] != null)
					model.setSaqTgtGrpDesc(saqTgtGrpDesc[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (saqTgtGrpCd[i] != null)
					model.setSaqTgtGrpCd(saqTgtGrpCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTargetGroup0014ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTargetGroup0014ListVO[]
	 */
	public SearchTargetGroup0014ListVO[] getSearchTargetGroup0014ListVOs(){
		SearchTargetGroup0014ListVO[] vos = (SearchTargetGroup0014ListVO[])models.toArray(new SearchTargetGroup0014ListVO[models.size()]);
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
		this.saqTgtGrpDesc = this.saqTgtGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqTgtGrpCd = this.saqTgtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
