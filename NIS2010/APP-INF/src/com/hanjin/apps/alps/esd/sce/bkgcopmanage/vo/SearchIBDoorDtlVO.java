/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchIBDoorDtlVO.java
*@FileTitle : SearchIBDoorDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.12.11 김인수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIBDoorDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIBDoorDtlVO> models = new ArrayList<SearchIBDoorDtlVO>();
	
	/* Column Info */
	private String preEstmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String postEstmDt = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String estmDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIBDoorDtlVO() {}

	public SearchIBDoorDtlVO(String ibflag, String pagerows, String copNo, String copDtlSeq, String estmDt, String preEstmDt, String postEstmDt) {
		this.preEstmDt = preEstmDt;
		this.ibflag = ibflag;
		this.postEstmDt = postEstmDt;
		this.copNo = copNo;
		this.copDtlSeq = copDtlSeq;
		this.estmDt = estmDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_estm_dt", getPreEstmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("post_estm_dt", getPostEstmDt());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("estm_dt", getEstmDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_estm_dt", "preEstmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("post_estm_dt", "postEstmDt");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("estm_dt", "estmDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return preEstmDt
	 */
	public String getPreEstmDt() {
		return this.preEstmDt;
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
	 * @return postEstmDt
	 */
	public String getPostEstmDt() {
		return this.postEstmDt;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return estmDt
	 */
	public String getEstmDt() {
		return this.estmDt;
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
	 * @param preEstmDt
	 */
	public void setPreEstmDt(String preEstmDt) {
		this.preEstmDt = preEstmDt;
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
	 * @param postEstmDt
	 */
	public void setPostEstmDt(String postEstmDt) {
		this.postEstmDt = postEstmDt;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param estmDt
	 */
	public void setEstmDt(String estmDt) {
		this.estmDt = estmDt;
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
		setPreEstmDt(JSPUtil.getParameter(request, "pre_estm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPostEstmDt(JSPUtil.getParameter(request, "post_estm_dt", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setEstmDt(JSPUtil.getParameter(request, "estm_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIBDoorDtlVO[]
	 */
	public SearchIBDoorDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIBDoorDtlVO[]
	 */
	public SearchIBDoorDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIBDoorDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] preEstmDt = (JSPUtil.getParameter(request, prefix	+ "pre_estm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] postEstmDt = (JSPUtil.getParameter(request, prefix	+ "post_estm_dt", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] estmDt = (JSPUtil.getParameter(request, prefix	+ "estm_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIBDoorDtlVO();
				if (preEstmDt[i] != null)
					model.setPreEstmDt(preEstmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (postEstmDt[i] != null)
					model.setPostEstmDt(postEstmDt[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (estmDt[i] != null)
					model.setEstmDt(estmDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIBDoorDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIBDoorDtlVO[]
	 */
	public SearchIBDoorDtlVO[] getSearchIBDoorDtlVOs(){
		SearchIBDoorDtlVO[] vos = (SearchIBDoorDtlVO[])models.toArray(new SearchIBDoorDtlVO[models.size()]);
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
		this.preEstmDt = this.preEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postEstmDt = this.postEstmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmDt = this.estmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
