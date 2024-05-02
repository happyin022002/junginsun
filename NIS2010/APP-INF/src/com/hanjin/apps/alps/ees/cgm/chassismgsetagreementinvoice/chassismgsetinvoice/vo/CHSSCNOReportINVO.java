/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CHSSCNOReportINVO.java
*@FileTitle : CHSSCNOReportINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSSCNOReportINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSSCNOReportINVO> models = new ArrayList<CHSSCNOReportINVO>();
	
	/* Column Info */
	private String toBseDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String searchScNo = null;
	/* Column Info */
	private String fromBseDt = null;
	/* Column Info */
	private String searchYdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSSCNOReportINVO() {}

	public CHSSCNOReportINVO(String ibflag, String pagerows, String fromBseDt, String toBseDt, String searchScNo, String searchYdCd) {
		this.toBseDt = toBseDt;
		this.ibflag = ibflag;
		this.searchScNo = searchScNo;
		this.fromBseDt = fromBseDt;
		this.searchYdCd = searchYdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_bse_dt", getToBseDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("search_sc_no", getSearchScNo());
		this.hashColumns.put("from_bse_dt", getFromBseDt());
		this.hashColumns.put("search_yd_cd", getSearchYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_bse_dt", "toBseDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("search_sc_no", "searchScNo");
		this.hashFields.put("from_bse_dt", "fromBseDt");
		this.hashFields.put("search_yd_cd", "searchYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toBseDt
	 */
	public String getToBseDt() {
		return this.toBseDt;
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
	 * @return searchScNo
	 */
	public String getSearchScNo() {
		return this.searchScNo;
	}
	
	/**
	 * Column Info
	 * @return fromBseDt
	 */
	public String getFromBseDt() {
		return this.fromBseDt;
	}
	
	/**
	 * Column Info
	 * @return searchYdCd
	 */
	public String getSearchYdCd() {
		return this.searchYdCd;
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
	 * @param toBseDt
	 */
	public void setToBseDt(String toBseDt) {
		this.toBseDt = toBseDt;
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
	 * @param searchScNo
	 */
	public void setSearchScNo(String searchScNo) {
		this.searchScNo = searchScNo;
	}
	
	/**
	 * Column Info
	 * @param fromBseDt
	 */
	public void setFromBseDt(String fromBseDt) {
		this.fromBseDt = fromBseDt;
	}
	
	/**
	 * Column Info
	 * @param searchYdCd
	 */
	public void setSearchYdCd(String searchYdCd) {
		this.searchYdCd = searchYdCd;
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
		setToBseDt(JSPUtil.getParameter(request, prefix + "to_bse_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSearchScNo(JSPUtil.getParameter(request, prefix + "search_sc_no", ""));
		setFromBseDt(JSPUtil.getParameter(request, prefix + "from_bse_dt", ""));
		setSearchYdCd(JSPUtil.getParameter(request, prefix + "search_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSSCNOReportINVO[]
	 */
	public CHSSCNOReportINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSSCNOReportINVO[]
	 */
	public CHSSCNOReportINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSSCNOReportINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toBseDt = (JSPUtil.getParameter(request, prefix	+ "to_bse_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] searchScNo = (JSPUtil.getParameter(request, prefix	+ "search_sc_no", length));
			String[] fromBseDt = (JSPUtil.getParameter(request, prefix	+ "from_bse_dt", length));
			String[] searchYdCd = (JSPUtil.getParameter(request, prefix	+ "search_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSSCNOReportINVO();
				if (toBseDt[i] != null)
					model.setToBseDt(toBseDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (searchScNo[i] != null)
					model.setSearchScNo(searchScNo[i]);
				if (fromBseDt[i] != null)
					model.setFromBseDt(fromBseDt[i]);
				if (searchYdCd[i] != null)
					model.setSearchYdCd(searchYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSSCNOReportINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSSCNOReportINVO[]
	 */
	public CHSSCNOReportINVO[] getCHSSCNOReportINVOs(){
		CHSSCNOReportINVO[] vos = (CHSSCNOReportINVO[])models.toArray(new CHSSCNOReportINVO[models.size()]);
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
		this.toBseDt = this.toBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchScNo = this.searchScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromBseDt = this.fromBseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchYdCd = this.searchYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
