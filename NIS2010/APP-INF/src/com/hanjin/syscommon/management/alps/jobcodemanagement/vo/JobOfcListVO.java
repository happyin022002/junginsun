/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OfficListVO.java
*@FileTitle : OfficListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.jobcodemanagement.vo;

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

public class JobOfcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JobOfcListVO> models = new ArrayList<JobOfcListVO>();
	
	/* Column Info */
	private String checkVal = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String checkValRead = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String dummycol = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String level = null;
	/* Column Info */
	private String repCustCntCd = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String ofcKrnNm = null;
	/* Column Info */
	private String locCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JobOfcListVO() {}

	public JobOfcListVO(String ibflag, String pagerows, String checkValRead, String checkVal, String level, String ofcCd, String arHdQtrOfcCd, String ofcEngNm, String ofcKrnNm, String prntOfcCd, String ofcKndCd, String repCustCntCd, String arOfcCd, String dummycol, String ofcTpCd, String locCd) {
		this.checkVal = checkVal;
		this.ofcKndCd = ofcKndCd;
		this.checkValRead = checkValRead;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.ofcEngNm = ofcEngNm;
		this.ofcTpCd = ofcTpCd;
		this.dummycol = dummycol;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.level = level;
		this.repCustCntCd = repCustCntCd;
		this.prntOfcCd = prntOfcCd;
		this.ofcKrnNm = ofcKrnNm;
		this.locCd = locCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("check_val", getCheckVal());
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("check_val_read", getCheckValRead());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("dummycol", getDummycol());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("ofc_krn_nm", getOfcKrnNm());
		this.hashColumns.put("loc_cd", getLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("check_val", "checkVal");
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("check_val_read", "checkValRead");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("dummycol", "dummycol");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("level", "level");
		this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("ofc_krn_nm", "ofcKrnNm");
		this.hashFields.put("loc_cd", "locCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return checkVal
	 */
	public String getCheckVal() {
		return this.checkVal;
	}
	
	/**
	 * Column Info
	 * @return ofcKndCd
	 */
	public String getOfcKndCd() {
		return this.ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @return checkValRead
	 */
	public String getCheckValRead() {
		return this.checkValRead;
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
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return dummycol
	 */
	public String getDummycol() {
		return this.dummycol;
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
	 * @return level
	 */
	public String getLevel() {
		return this.level;
	}
	
	/**
	 * Column Info
	 * @return repCustCntCd
	 */
	public String getRepCustCntCd() {
		return this.repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcKrnNm
	 */
	public String getOfcKrnNm() {
		return this.ofcKrnNm;
	}
	

	/**
	 * Column Info
	 * @param checkVal
	 */
	public void setCheckVal(String checkVal) {
		this.checkVal = checkVal;
	}
	
	/**
	 * Column Info
	 * @param ofcKndCd
	 */
	public void setOfcKndCd(String ofcKndCd) {
		this.ofcKndCd = ofcKndCd;
	}
	
	/**
	 * Column Info
	 * @param checkValRead
	 */
	public void setCheckValRead(String checkValRead) {
		this.checkValRead = checkValRead;
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
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param dummycol
	 */
	public void setDummycol(String dummycol) {
		this.dummycol = dummycol;
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
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * Column Info
	 * @param repCustCntCd
	 */
	public void setRepCustCntCd(String repCustCntCd) {
		this.repCustCntCd = repCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcKrnNm
	 */
	public void setOfcKrnNm(String ofcKrnNm) {
		this.ofcKrnNm = ofcKrnNm;
	}		
	
	/**
	 * @return the locCd
	 */
	public String getLocCd() {
		return locCd;
	}

	/**
	 * @param locCd the locCd to set
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
		setCheckVal(JSPUtil.getParameter(request, prefix + "check_val", ""));
		setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
		setCheckValRead(JSPUtil.getParameter(request, prefix + "check_val_read", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setDummycol(JSPUtil.getParameter(request, prefix + "dummycol", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
		setRepCustCntCd(JSPUtil.getParameter(request, prefix + "rep_cust_cnt_cd", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setOfcKrnNm(JSPUtil.getParameter(request, prefix + "ofc_krn_nm", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficListVO[]
	 */
	public JobOfcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficListVO[]
	 */
	public JobOfcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JobOfcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] checkVal = (JSPUtil.getParameter(request, prefix	+ "check_val", length));
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] checkValRead = (JSPUtil.getParameter(request, prefix	+ "check_val_read", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] dummycol = (JSPUtil.getParameter(request, prefix	+ "dummycol", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			String[] repCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rep_cust_cnt_cd", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] ofcKrnNm = (JSPUtil.getParameter(request, prefix	+ "ofc_krn_nm", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new JobOfcListVO();
				if (checkVal[i] != null)
					model.setCheckVal(checkVal[i]);
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (checkValRead[i] != null)
					model.setCheckValRead(checkValRead[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (dummycol[i] != null)
					model.setDummycol(dummycol[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				if (repCustCntCd[i] != null)
					model.setRepCustCntCd(repCustCntCd[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (ofcKrnNm[i] != null)
					model.setOfcKrnNm(ofcKrnNm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJobOfcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficListVO[]
	 */
	public JobOfcListVO[] getJobOfcListVOs(){
		JobOfcListVO[] vos = (JobOfcListVO[])models.toArray(new JobOfcListVO[models.size()]);
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
		this.checkVal = this.checkVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkValRead = this.checkValRead .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dummycol = this.dummycol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCntCd = this.repCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKrnNm = this.ofcKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
