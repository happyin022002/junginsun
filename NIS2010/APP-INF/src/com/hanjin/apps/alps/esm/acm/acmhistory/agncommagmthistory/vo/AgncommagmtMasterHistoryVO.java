/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgncommagmtMasterHistoryVO.java
*@FileTitle : AgncommagmtMasterHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.22 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmhistory.agncommagmthistory.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgncommagmtMasterHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgncommagmtMasterHistoryVO> models = new ArrayList<AgncommagmtMasterHistoryVO>();
	
	/* Column Info */
	private String agmtHisNo = null;
	/* Column Info */
	private String creLoclDtTm = null;
	/* Column Info */
	private String loginOfc = null;
	/* Column Info */
	private String currentValue = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creGdtTm = null;
	/* Column Info */
	private String creGdt = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String previousValue = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgncommagmtMasterHistoryVO() {}

	public AgncommagmtMasterHistoryVO(String ibflag, String pagerows, String seq, String item, String agnAgmtNo, String currentValue, String previousValue, String creUsrId, String creLoclDt, String creLoclDtTm, String creGdt, String creGdtTm, String loginOfc, String agmtHisNo) {
		this.agmtHisNo = agmtHisNo;
		this.creLoclDtTm = creLoclDtTm;
		this.loginOfc = loginOfc;
		this.currentValue = currentValue;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.creGdtTm = creGdtTm;
		this.creGdt = creGdt;
		this.creLoclDt = creLoclDt;
		this.item = item;
		this.seq = seq;
		this.previousValue = previousValue;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_his_no", getAgmtHisNo());
		this.hashColumns.put("cre_locl_dt_tm", getCreLoclDtTm());
		this.hashColumns.put("login_ofc", getLoginOfc());
		this.hashColumns.put("current_value", getCurrentValue());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_gdt_tm", getCreGdtTm());
		this.hashColumns.put("cre_gdt", getCreGdt());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("previous_value", getPreviousValue());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_his_no", "agmtHisNo");
		this.hashFields.put("cre_locl_dt_tm", "creLoclDtTm");
		this.hashFields.put("login_ofc", "loginOfc");
		this.hashFields.put("current_value", "currentValue");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_gdt_tm", "creGdtTm");
		this.hashFields.put("cre_gdt", "creGdt");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("item", "item");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("previous_value", "previousValue");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtHisNo
	 */
	public String getAgmtHisNo() {
		return this.agmtHisNo;
	}
	
	/**
	 * Column Info
	 * @return creLoclDtTm
	 */
	public String getCreLoclDtTm() {
		return this.creLoclDtTm;
	}
	
	/**
	 * Column Info
	 * @return loginOfc
	 */
	public String getLoginOfc() {
		return this.loginOfc;
	}
	
	/**
	 * Column Info
	 * @return currentValue
	 */
	public String getCurrentValue() {
		return this.currentValue;
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
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return creGdtTm
	 */
	public String getCreGdtTm() {
		return this.creGdtTm;
	}
	
	/**
	 * Column Info
	 * @return creGdt
	 */
	public String getCreGdt() {
		return this.creGdt;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return previousValue
	 */
	public String getPreviousValue() {
		return this.previousValue;
	}
	

	/**
	 * Column Info
	 * @param agmtHisNo
	 */
	public void setAgmtHisNo(String agmtHisNo) {
		this.agmtHisNo = agmtHisNo;
	}
	
	/**
	 * Column Info
	 * @param creLoclDtTm
	 */
	public void setCreLoclDtTm(String creLoclDtTm) {
		this.creLoclDtTm = creLoclDtTm;
	}
	
	/**
	 * Column Info
	 * @param loginOfc
	 */
	public void setLoginOfc(String loginOfc) {
		this.loginOfc = loginOfc;
	}
	
	/**
	 * Column Info
	 * @param currentValue
	 */
	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
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
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param creGdtTm
	 */
	public void setCreGdtTm(String creGdtTm) {
		this.creGdtTm = creGdtTm;
	}
	
	/**
	 * Column Info
	 * @param creGdt
	 */
	public void setCreGdt(String creGdt) {
		this.creGdt = creGdt;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param previousValue
	 */
	public void setPreviousValue(String previousValue) {
		this.previousValue = previousValue;
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
		setAgmtHisNo(JSPUtil.getParameter(request, prefix + "agmt_his_no", ""));
		setCreLoclDtTm(JSPUtil.getParameter(request, prefix + "cre_locl_dt_tm", ""));
		setLoginOfc(JSPUtil.getParameter(request, prefix + "login_ofc", ""));
		setCurrentValue(JSPUtil.getParameter(request, prefix + "current_value", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreGdtTm(JSPUtil.getParameter(request, prefix + "cre_gdt_tm", ""));
		setCreGdt(JSPUtil.getParameter(request, prefix + "cre_gdt", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setItem(JSPUtil.getParameter(request, prefix + "item", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setPreviousValue(JSPUtil.getParameter(request, prefix + "previous_value", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgncommagmtMasterHistoryVO[]
	 */
	public AgncommagmtMasterHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgncommagmtMasterHistoryVO[]
	 */
	public AgncommagmtMasterHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgncommagmtMasterHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtHisNo = (JSPUtil.getParameter(request, prefix	+ "agmt_his_no", length));
			String[] creLoclDtTm = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt_tm", length));
			String[] loginOfc = (JSPUtil.getParameter(request, prefix	+ "login_ofc", length));
			String[] currentValue = (JSPUtil.getParameter(request, prefix	+ "current_value", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creGdtTm = (JSPUtil.getParameter(request, prefix	+ "cre_gdt_tm", length));
			String[] creGdt = (JSPUtil.getParameter(request, prefix	+ "cre_gdt", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] previousValue = (JSPUtil.getParameter(request, prefix	+ "previous_value", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgncommagmtMasterHistoryVO();
				if (agmtHisNo[i] != null)
					model.setAgmtHisNo(agmtHisNo[i]);
				if (creLoclDtTm[i] != null)
					model.setCreLoclDtTm(creLoclDtTm[i]);
				if (loginOfc[i] != null)
					model.setLoginOfc(loginOfc[i]);
				if (currentValue[i] != null)
					model.setCurrentValue(currentValue[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creGdtTm[i] != null)
					model.setCreGdtTm(creGdtTm[i]);
				if (creGdt[i] != null)
					model.setCreGdt(creGdt[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (previousValue[i] != null)
					model.setPreviousValue(previousValue[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgncommagmtMasterHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgncommagmtMasterHistoryVO[]
	 */
	public AgncommagmtMasterHistoryVO[] getAgncommagmtMasterHistoryVOs(){
		AgncommagmtMasterHistoryVO[] vos = (AgncommagmtMasterHistoryVO[])models.toArray(new AgncommagmtMasterHistoryVO[models.size()]);
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
		this.agmtHisNo = this.agmtHisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDtTm = this.creLoclDtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfc = this.loginOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currentValue = this.currentValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creGdtTm = this.creGdtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creGdt = this.creGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.previousValue = this.previousValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
