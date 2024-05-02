/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptUserListConditionVO.java
*@FileTitle : ReceiptUserListConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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

public class ReceiptUserListConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptUserListConditionVO> models = new ArrayList<ReceiptUserListConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String toRctDpsDt = null;
	/* Column Info */
	private String fmRctDt = null;
	/* Column Info */
	private String toRctDt = null;
	/* Column Info */
	private String fmRctDpsDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptUserListConditionVO() {}

	public ReceiptUserListConditionVO(String ibflag, String pagerows, String usrId, String fmRctDt, String toRctDt, String fmRctDpsDt, String toRctDpsDt) {
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.toRctDpsDt = toRctDpsDt;
		this.fmRctDt = fmRctDt;
		this.toRctDt = toRctDt;
		this.fmRctDpsDt = fmRctDpsDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("to_rct_dps_dt", getToRctDpsDt());
		this.hashColumns.put("fm_rct_dt", getFmRctDt());
		this.hashColumns.put("to_rct_dt", getToRctDt());
		this.hashColumns.put("fm_rct_dps_dt", getFmRctDpsDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("to_rct_dps_dt", "toRctDpsDt");
		this.hashFields.put("fm_rct_dt", "fmRctDt");
		this.hashFields.put("to_rct_dt", "toRctDt");
		this.hashFields.put("fm_rct_dps_dt", "fmRctDpsDt");
		this.hashFields.put("pagerows", "pagerows");
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
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return toRctDpsDt
	 */
	public String getToRctDpsDt() {
		return this.toRctDpsDt;
	}
	
	/**
	 * Column Info
	 * @return fmRctDt
	 */
	public String getFmRctDt() {
		return this.fmRctDt;
	}
	
	/**
	 * Column Info
	 * @return toRctDt
	 */
	public String getToRctDt() {
		return this.toRctDt;
	}
	
	/**
	 * Column Info
	 * @return fmRctDpsDt
	 */
	public String getFmRctDpsDt() {
		return this.fmRctDpsDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param toRctDpsDt
	 */
	public void setToRctDpsDt(String toRctDpsDt) {
		this.toRctDpsDt = toRctDpsDt;
	}
	
	/**
	 * Column Info
	 * @param fmRctDt
	 */
	public void setFmRctDt(String fmRctDt) {
		this.fmRctDt = fmRctDt;
	}
	
	/**
	 * Column Info
	 * @param toRctDt
	 */
	public void setToRctDt(String toRctDt) {
		this.toRctDt = toRctDt;
	}
	
	/**
	 * Column Info
	 * @param fmRctDpsDt
	 */
	public void setFmRctDpsDt(String fmRctDpsDt) {
		this.fmRctDpsDt = fmRctDpsDt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setToRctDpsDt(JSPUtil.getParameter(request, prefix + "to_rct_dps_dt", ""));
		setFmRctDt(JSPUtil.getParameter(request, prefix + "fm_rct_dt", ""));
		setToRctDt(JSPUtil.getParameter(request, prefix + "to_rct_dt", ""));
		setFmRctDpsDt(JSPUtil.getParameter(request, prefix + "fm_rct_dps_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptUserListConditionVO[]
	 */
	public ReceiptUserListConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptUserListConditionVO[]
	 */
	public ReceiptUserListConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptUserListConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] toRctDpsDt = (JSPUtil.getParameter(request, prefix	+ "to_rct_dps_dt", length));
			String[] fmRctDt = (JSPUtil.getParameter(request, prefix	+ "fm_rct_dt", length));
			String[] toRctDt = (JSPUtil.getParameter(request, prefix	+ "to_rct_dt", length));
			String[] fmRctDpsDt = (JSPUtil.getParameter(request, prefix	+ "fm_rct_dps_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptUserListConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (toRctDpsDt[i] != null)
					model.setToRctDpsDt(toRctDpsDt[i]);
				if (fmRctDt[i] != null)
					model.setFmRctDt(fmRctDt[i]);
				if (toRctDt[i] != null)
					model.setToRctDt(toRctDt[i]);
				if (fmRctDpsDt[i] != null)
					model.setFmRctDpsDt(fmRctDpsDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptUserListConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptUserListConditionVO[]
	 */
	public ReceiptUserListConditionVO[] getReceiptUserListConditionVOs(){
		ReceiptUserListConditionVO[] vos = (ReceiptUserListConditionVO[])models.toArray(new ReceiptUserListConditionVO[models.size()]);
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
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRctDpsDt = this.toRctDpsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRctDt = this.fmRctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRctDt = this.toRctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRctDpsDt = this.fmRctDpsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
