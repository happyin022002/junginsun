/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AfterBookingFullHistoryVO.java
*@FileTitle : AfterBookingFullHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

import java.lang.reflect.Field;
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

public class AfterBookingFullHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingFullHistoryVO> models = new ArrayList<AfterBookingFullHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aftBkgFullHisRqstSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custAnsRmk = null;
	/* Column Info */
	private String usrActRmk = null;
	/* Column Info */
	private String aftCustAnsDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingFullHistoryVO() {}

	public AfterBookingFullHistoryVO(String ibflag, String pagerows, String aftExptDarNo, String aftBkgFullHisRqstSeq, String aftCustAnsDt, String usrActRmk, String custAnsRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.aftBkgFullHisRqstSeq = aftBkgFullHisRqstSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.creDt = creDt;
		this.custAnsRmk = custAnsRmk;
		this.usrActRmk = usrActRmk;
		this.aftCustAnsDt = aftCustAnsDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("aft_bkg_full_his_rqst_seq", getAftBkgFullHisRqstSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_ans_rmk", getCustAnsRmk());
		this.hashColumns.put("usr_act_rmk", getUsrActRmk());
		this.hashColumns.put("aft_cust_ans_dt", getAftCustAnsDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("aft_bkg_full_his_rqst_seq", "aftBkgFullHisRqstSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_ans_rmk", "custAnsRmk");
		this.hashFields.put("usr_act_rmk", "usrActRmk");
		this.hashFields.put("aft_cust_ans_dt", "aftCustAnsDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return aftBkgFullHisRqstSeq
	 */
	public String getAftBkgFullHisRqstSeq() {
		return this.aftBkgFullHisRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return custAnsRmk
	 */
	public String getCustAnsRmk() {
		return this.custAnsRmk;
	}
	
	/**
	 * Column Info
	 * @return usrActRmk
	 */
	public String getUsrActRmk() {
		return this.usrActRmk;
	}
	
	/**
	 * Column Info
	 * @return aftCustAnsDt
	 */
	public String getAftCustAnsDt() {
		return this.aftCustAnsDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param aftBkgFullHisRqstSeq
	 */
	public void setAftBkgFullHisRqstSeq(String aftBkgFullHisRqstSeq) {
		this.aftBkgFullHisRqstSeq = aftBkgFullHisRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param custAnsRmk
	 */
	public void setCustAnsRmk(String custAnsRmk) {
		this.custAnsRmk = custAnsRmk;
	}
	
	/**
	 * Column Info
	 * @param usrActRmk
	 */
	public void setUsrActRmk(String usrActRmk) {
		this.usrActRmk = usrActRmk;
	}
	
	/**
	 * Column Info
	 * @param aftCustAnsDt
	 */
	public void setAftCustAnsDt(String aftCustAnsDt) {
		this.aftCustAnsDt = aftCustAnsDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAftBkgFullHisRqstSeq(JSPUtil.getParameter(request, prefix + "aft_bkg_full_his_rqst_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCustAnsRmk(JSPUtil.getParameter(request, prefix + "cust_ans_rmk", ""));
		setUsrActRmk(JSPUtil.getParameter(request, prefix + "usr_act_rmk", ""));
		setAftCustAnsDt(JSPUtil.getParameter(request, prefix + "aft_cust_ans_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingFullHistoryVO[]
	 */
	public AfterBookingFullHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingFullHistoryVO[]
	 */
	public AfterBookingFullHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingFullHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aftBkgFullHisRqstSeq = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_full_his_rqst_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] custAnsRmk = (JSPUtil.getParameter(request, prefix	+ "cust_ans_rmk", length));
			String[] usrActRmk = (JSPUtil.getParameter(request, prefix	+ "usr_act_rmk", length));
			String[] aftCustAnsDt = (JSPUtil.getParameter(request, prefix	+ "aft_cust_ans_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingFullHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aftBkgFullHisRqstSeq[i] != null)
					model.setAftBkgFullHisRqstSeq(aftBkgFullHisRqstSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custAnsRmk[i] != null)
					model.setCustAnsRmk(custAnsRmk[i]);
				if (usrActRmk[i] != null)
					model.setUsrActRmk(usrActRmk[i]);
				if (aftCustAnsDt[i] != null)
					model.setAftCustAnsDt(aftCustAnsDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingFullHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingFullHistoryVO[]
	 */
	public AfterBookingFullHistoryVO[] getAfterBookingFullHistoryVOs(){
		AfterBookingFullHistoryVO[] vos = (AfterBookingFullHistoryVO[])models.toArray(new AfterBookingFullHistoryVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgFullHisRqstSeq = this.aftBkgFullHisRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custAnsRmk = this.custAnsRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrActRmk = this.usrActRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftCustAnsDt = this.aftCustAnsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
