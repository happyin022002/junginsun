/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDiffQtyListVO.java
*@FileTitle : SearchDiffQtyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.01.15 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.bkgcopmanage.vo;

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
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDiffQtyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDiffQtyListVO> models = new ArrayList<SearchDiffQtyListVO>();
	
	/* Column Info */
	private String pseudoCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String attachCnt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDiffQtyListVO() {}

	public SearchDiffQtyListVO(String ibflag, String pagerows, String cntrTpszCd, String pseudoCnt, String attachCnt, String cntrCnt, String qty) {
		this.pseudoCnt = pseudoCnt;
		this.ibflag = ibflag;
		this.attachCnt = attachCnt;
		this.cntrTpszCd = cntrTpszCd;
		this.qty = qty;
		this.cntrCnt = cntrCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pseudo_cnt", getPseudoCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("attach_cnt", getAttachCnt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pseudo_cnt", "pseudoCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attach_cnt", "attachCnt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pseudoCnt
	 */
	public String getPseudoCnt() {
		return this.pseudoCnt;
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
	 * @return attachCnt
	 */
	public String getAttachCnt() {
		return this.attachCnt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
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
	 * @param pseudoCnt
	 */
	public void setPseudoCnt(String pseudoCnt) {
		this.pseudoCnt = pseudoCnt;
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
	 * @param attachCnt
	 */
	public void setAttachCnt(String attachCnt) {
		this.attachCnt = attachCnt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
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
		setPseudoCnt(JSPUtil.getParameter(request, prefix + "pseudo_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAttachCnt(JSPUtil.getParameter(request, prefix + "attach_cnt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDiffQtyListVO[]
	 */
	public SearchDiffQtyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDiffQtyListVO[]
	 */
	public SearchDiffQtyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDiffQtyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pseudoCnt = (JSPUtil.getParameter(request, prefix	+ "pseudo_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] attachCnt = (JSPUtil.getParameter(request, prefix	+ "attach_cnt", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDiffQtyListVO();
				if (pseudoCnt[i] != null)
					model.setPseudoCnt(pseudoCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (attachCnt[i] != null)
					model.setAttachCnt(attachCnt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDiffQtyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDiffQtyListVO[]
	 */
	public SearchDiffQtyListVO[] getSearchDiffQtyListVOs(){
		SearchDiffQtyListVO[] vos = (SearchDiffQtyListVO[])models.toArray(new SearchDiffQtyListVO[models.size()]);
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
		this.pseudoCnt = this.pseudoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachCnt = this.attachCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
