/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RetroActFilterSchVO.java
*@FileTitle : RetroActFilterSchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

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

public class TxsBkgListForAuditSchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TxsBkgListForAuditSchVO> models = new ArrayList<TxsBkgListForAuditSchVO>();
	
	/* Column Info */
	private String searchOption = null;
	/* Column Info */
	private String date = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String triAxel = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String deTermCd = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TxsBkgListForAuditSchVO() {}

	public TxsBkgListForAuditSchVO(String searchOption, String date, String svcScpCd, String fromDt, String toDt, String triAxel, String rcvTermCd, String deTermCd) {

		this.searchOption = searchOption;
		this.date = date;
		this.svcScpCd = svcScpCd;
		this.fromDt = fromDt;
		this.toDt = toDt;
		this.triAxel = triAxel;
		this.rcvTermCd = rcvTermCd;
		this.deTermCd = deTermCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("search_option", getSearchOption());
		this.hashColumns.put("date", getDate());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("tri_axel", getTriAxel());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){

		this.hashFields.put("search_option", "searchOption");
		this.hashFields.put("date", "date");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("tri_axel", "triAxel");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return searchOption
	 */
	public String getSearchOption() {
		return this.searchOption;
	}
	
	/**
	 * Column Info
	 * @return date
	 */
	public String getDate() {
		return this.date;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return triAxel
	 */
	public String getTriAxel() {
		return this.triAxel;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}

	/**
	 * Column Info
	 * @param searchOption
	 */
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	
	/**
	 * Column Info
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param triAxel
	 */
	public void setTriAxel(String triAxel) {
		this.triAxel = triAxel;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
		setSearchOption(JSPUtil.getParameter(request, prefix + "search_option", ""));
		setDate(JSPUtil.getParameter(request, prefix + "date", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setTriAxel(JSPUtil.getParameter(request, prefix + "tri_axel", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TxsBkgListForAuditSchVO[]
	 */
	public TxsBkgListForAuditSchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TxsBkgListForAuditSchVO[]
	 */
	public TxsBkgListForAuditSchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TxsBkgListForAuditSchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] searchOption = (JSPUtil.getParameter(request, prefix	+ "search_option", length));
			String[] date = (JSPUtil.getParameter(request, prefix	+ "date", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] triAxel = (JSPUtil.getParameter(request, prefix	+ "tri_axel", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
						
			for (int i = 0; i < length; i++) {
				model = new TxsBkgListForAuditSchVO();
				if (searchOption[i] != null)
					model.setSearchOption(searchOption[i]);
				if (date[i] != null)
					model.setDate(date[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (triAxel[i] != null)
					model.setTriAxel(triAxel[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTxsBkgListForAuditSchVOs();
		
	}

	/**
	 * VO 배열을 반환
	 * @return EqSubErrSchVO[]
	 */
	public TxsBkgListForAuditSchVO[] getTxsBkgListForAuditSchVOs(){
		TxsBkgListForAuditSchVO[] vos = (TxsBkgListForAuditSchVO[])models.toArray(new TxsBkgListForAuditSchVO[models.size()]);
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
		this.searchOption = this.searchOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.date = this.date .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAxel = this.triAxel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
