/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ErpErrorInputVO.java
*@FileTitle : ErpErrorInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2010.12.21 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ErpErrorInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ErpErrorInputVO> models = new ArrayList<ErpErrorInputVO>();
	
	/* Column Info */
	private String ifNo = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ifFlag = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String revSrcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ErpErrorInputVO() {}

	public ErpErrorInputVO(String ibflag, String pagerows, String dateOption, String fromDate, String toDate, String ifNo, String ifFlag, String arHdQtrOfcCd, String arOfcCd, String blNo, String invNo, String revTpCd, String revSrcCd) {
		this.ifNo = ifNo;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.toDate = toDate;
		this.blNo = blNo;
		this.revTpCd = revTpCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.ifFlag = ifFlag;
		this.fromDate = fromDate;
		this.dateOption = dateOption;
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("if_flag", getIfFlag());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("if_flag", "ifFlag");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ifNo
	 */
	public String getIfNo() {
		return this.ifNo;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return ifFlag
	 */
	public String getIfFlag() {
		return this.ifFlag;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return dateOption
	 */
	public String getDateOption() {
		return this.dateOption;
	}
	
	/**
	 * Column Info
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
	}
	

	/**
	 * Column Info
	 * @param ifNo
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param ifFlag
	 */
	public void setIfFlag(String ifFlag) {
		this.ifFlag = ifFlag;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param dateOption
	 */
	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}
	
	/**
	 * Column Info
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
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
		setIfNo(JSPUtil.getParameter(request, prefix + "if_no", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setRevTpCd(JSPUtil.getParameter(request, prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIfFlag(JSPUtil.getParameter(request, prefix + "if_flag", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setDateOption(JSPUtil.getParameter(request, prefix + "date_option", ""));
		setRevSrcCd(JSPUtil.getParameter(request, prefix + "rev_src_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ErpErrorInputVO[]
	 */
	public ErpErrorInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ErpErrorInputVO[]
	 */
	public ErpErrorInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ErpErrorInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ifFlag = (JSPUtil.getParameter(request, prefix	+ "if_flag", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ErpErrorInputVO();
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ifFlag[i] != null)
					model.setIfFlag(ifFlag[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getErpErrorInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ErpErrorInputVO[]
	 */
	public ErpErrorInputVO[] getErpErrorInputVOs(){
		ErpErrorInputVO[] vos = (ErpErrorInputVO[])models.toArray(new ErpErrorInputVO[models.size()]);
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
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlag = this.ifFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
