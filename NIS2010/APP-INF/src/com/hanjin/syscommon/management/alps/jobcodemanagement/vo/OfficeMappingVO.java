/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OfficeMappingVO.java
*@FileTitle : OfficeMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.04
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.06.04 최덕우 
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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfficeMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeMappingVO> models = new ArrayList<OfficeMappingVO>();
	
	/* Column Info */
	private String ofcTpChk = null;
	/* Column Info */
	private String checkVal = null;
	/* Column Info */
	private String ofcKndCd = null;
	/* Column Info */
	private String ofcTp = null;
	/* Column Info */
	private String checkValRead = null;
	/* Column Info */
	private String usrRoleCd = null;
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
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String jobCd = null;
	/* Column Info */
	private String reqCustCntCd = null;
	/* Column Info */
	private String ofcTpNm = null;
	/* Column Info */
	private String ofcKrnNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String level = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfficeMappingVO() {}

	public OfficeMappingVO(String ibflag, String level, String pagerows, String jobCd, String usrRoleCd, String checkVal, String ofcKndCd, String checkValRead, String arHdQtrOfcCd, String ofcEngNm, String ofcTpCd, String dummycol, String arOfcCd, String ofcCd, String reqCustCntCd, String prntOfcCd, String ofcKrnNm, String locCd, String creUsrId, String updUsrId, String ofcTpChk, String ofcTp, String ofcTpNm) {
		this.ofcTpChk = ofcTpChk;
		this.checkVal = checkVal;
		this.ofcKndCd = ofcKndCd;
		this.ofcTp = ofcTp;
		this.checkValRead = checkValRead;
		this.usrRoleCd = usrRoleCd;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.ofcEngNm = ofcEngNm;
		this.ofcTpCd = ofcTpCd;
		this.dummycol = dummycol;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.prntOfcCd = prntOfcCd;
		this.jobCd = jobCd;
		this.reqCustCntCd = reqCustCntCd;
		this.ofcTpNm = ofcTpNm;
		this.ofcKrnNm = ofcKrnNm;
		this.updUsrId = updUsrId;
		this.level = level;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_tp_chk", getOfcTpChk());
		this.hashColumns.put("check_val", getCheckVal());
		this.hashColumns.put("ofc_knd_cd", getOfcKndCd());
		this.hashColumns.put("ofc_tp", getOfcTp());
		this.hashColumns.put("check_val_read", getCheckValRead());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("dummycol", getDummycol());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("job_cd", getJobCd());
		this.hashColumns.put("req_cust_cnt_cd", getReqCustCntCd());
		this.hashColumns.put("ofc_tp_nm", getOfcTpNm());
		this.hashColumns.put("ofc_krn_nm", getOfcKrnNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("level", getLevel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_tp_chk", "ofcTpChk");
		this.hashFields.put("check_val", "checkVal");
		this.hashFields.put("ofc_knd_cd", "ofcKndCd");
		this.hashFields.put("ofc_tp", "ofcTp");
		this.hashFields.put("check_val_read", "checkValRead");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("dummycol", "dummycol");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("job_cd", "jobCd");
		this.hashFields.put("req_cust_cnt_cd", "reqCustCntCd");
		this.hashFields.put("ofc_tp_nm", "ofcTpNm");
		this.hashFields.put("ofc_krn_nm", "ofcKrnNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("level", "level");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcTpChk
	 */
	public String getOfcTpChk() {
		return this.ofcTpChk;
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
	 * @return ofcTp
	 */
	public String getOfcTp() {
		return this.ofcTp;
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
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
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
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return jobCd
	 */
	public String getJobCd() {
		return this.jobCd;
	}
	
	/**
	 * Column Info
	 * @return reqCustCntCd
	 */
	public String getReqCustCntCd() {
		return this.reqCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ofcTpNm
	 */
	public String getOfcTpNm() {
		return this.ofcTpNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param ofcTpChk
	 */
	public void setOfcTpChk(String ofcTpChk) {
		this.ofcTpChk = ofcTpChk;
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
	 * @param ofcTp
	 */
	public void setOfcTp(String ofcTp) {
		this.ofcTp = ofcTp;
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
	 * @param usrRoleCd
	 */
	public void setUsrRoleCd(String usrRoleCd) {
		this.usrRoleCd = usrRoleCd;
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
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param jobCd
	 */
	public void setJobCd(String jobCd) {
		this.jobCd = jobCd;
	}
	
	/**
	 * Column Info
	 * @param reqCustCntCd
	 */
	public void setReqCustCntCd(String reqCustCntCd) {
		this.reqCustCntCd = reqCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ofcTpNm
	 */
	public void setOfcTpNm(String ofcTpNm) {
		this.ofcTpNm = ofcTpNm;
	}
	
	/**
	 * Column Info
	 * @param ofcKrnNm
	 */
	public void setOfcKrnNm(String ofcKrnNm) {
		this.ofcKrnNm = ofcKrnNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
		setOfcTpChk(JSPUtil.getParameter(request, prefix + "ofc_tp_chk", ""));
		setCheckVal(JSPUtil.getParameter(request, prefix + "check_val", ""));
		setOfcKndCd(JSPUtil.getParameter(request, prefix + "ofc_knd_cd", ""));
		setOfcTp(JSPUtil.getParameter(request, prefix + "ofc_tp", ""));
		setCheckValRead(JSPUtil.getParameter(request, prefix + "check_val_read", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setDummycol(JSPUtil.getParameter(request, prefix + "dummycol", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setJobCd(JSPUtil.getParameter(request, prefix + "job_cd", ""));
		setReqCustCntCd(JSPUtil.getParameter(request, prefix + "req_cust_cnt_cd", ""));
		setOfcTpNm(JSPUtil.getParameter(request, prefix + "ofc_tp_nm", ""));
		setOfcKrnNm(JSPUtil.getParameter(request, prefix + "ofc_krn_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeMappingVO[]
	 */
	public OfficeMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeMappingVO[]
	 */
	public OfficeMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcTpChk = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_chk", length));
			String[] checkVal = (JSPUtil.getParameter(request, prefix	+ "check_val", length));
			String[] ofcKndCd = (JSPUtil.getParameter(request, prefix	+ "ofc_knd_cd", length));
			String[] ofcTp = (JSPUtil.getParameter(request, prefix	+ "ofc_tp", length));
			String[] checkValRead = (JSPUtil.getParameter(request, prefix	+ "check_val_read", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] dummycol = (JSPUtil.getParameter(request, prefix	+ "dummycol", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] jobCd = (JSPUtil.getParameter(request, prefix	+ "job_cd", length));
			String[] reqCustCntCd = (JSPUtil.getParameter(request, prefix	+ "req_cust_cnt_cd", length));
			String[] ofcTpNm = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_nm", length));
			String[] ofcKrnNm = (JSPUtil.getParameter(request, prefix	+ "ofc_krn_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeMappingVO();
				if (ofcTpChk[i] != null)
					model.setOfcTpChk(ofcTpChk[i]);
				if (checkVal[i] != null)
					model.setCheckVal(checkVal[i]);
				if (ofcKndCd[i] != null)
					model.setOfcKndCd(ofcKndCd[i]);
				if (ofcTp[i] != null)
					model.setOfcTp(ofcTp[i]);
				if (checkValRead[i] != null)
					model.setCheckValRead(checkValRead[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
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
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (jobCd[i] != null)
					model.setJobCd(jobCd[i]);
				if (reqCustCntCd[i] != null)
					model.setReqCustCntCd(reqCustCntCd[i]);
				if (ofcTpNm[i] != null)
					model.setOfcTpNm(ofcTpNm[i]);
				if (ofcKrnNm[i] != null)
					model.setOfcKrnNm(ofcKrnNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeMappingVO[]
	 */
	public OfficeMappingVO[] getOfficeMappingVOs(){
		OfficeMappingVO[] vos = (OfficeMappingVO[])models.toArray(new OfficeMappingVO[models.size()]);
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
		this.ofcTpChk = this.ofcTpChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVal = this.checkVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKndCd = this.ofcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTp = this.ofcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkValRead = this.checkValRead .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dummycol = this.dummycol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobCd = this.jobCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqCustCntCd = this.reqCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpNm = this.ofcTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcKrnNm = this.ofcKrnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
