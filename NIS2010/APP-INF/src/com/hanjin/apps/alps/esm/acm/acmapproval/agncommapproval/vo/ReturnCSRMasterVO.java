/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReturnCSRMasterVO.java
*@FileTitle : ReturnCSRMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.17
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2013.06.17 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ReturnCSRMasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReturnCSRMasterVO> models = new ArrayList<ReturnCSRMasterVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String audNo = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String csrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String csrNoMaster = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String ifErrRsn = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ReturnCSRMasterVO() {}

	public ReturnCSRMasterVO(String ibflag, String pagerows, String csrNo, String csrNoMaster, String bkgCnt, String dateFm, String dateTo, String arOfcCd, String agnCd, String audNo, String usrId, String ifErrRsn) {
		this.dateFm = dateFm;
		this.audNo = audNo;
		this.agnCd = agnCd;
		this.csrNo = csrNo;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.dateTo = dateTo;
		this.csrNoMaster = csrNoMaster;
		this.bkgCnt = bkgCnt;
		this.ifErrRsn = ifErrRsn;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("aud_no", getAudNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("csr_no_master", getCsrNoMaster());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("if_err_rsn", getIfErrRsn());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("aud_no", "audNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("csr_no_master", "csrNoMaster");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("if_err_rsn", "ifErrRsn");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
	}
	
	/**
	 * Column Info
	 * @return audNo
	 */
	public String getAudNo() {
		return this.audNo;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return csrNoMaster
	 */
	public String getCsrNoMaster() {
		return this.csrNoMaster;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}
	
	/**
	 * Column Info
	 * @return ifErrRsn
	 */
	public String getIfErrRsn() {
		return this.ifErrRsn;
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
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
	}
	
	/**
	 * Column Info
	 * @param audNo
	 */
	public void setAudNo(String audNo) {
		this.audNo = audNo;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param csrNoMaster
	 */
	public void setCsrNoMaster(String csrNoMaster) {
		this.csrNoMaster = csrNoMaster;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Column Info
	 * @param ifErrRsn
	 */
	public void setIfErrRsn(String ifErrRsn) {
		this.ifErrRsn = ifErrRsn;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setAudNo(JSPUtil.getParameter(request, prefix + "aud_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setCsrNoMaster(JSPUtil.getParameter(request, prefix + "csr_no_master", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setIfErrRsn(JSPUtil.getParameter(request, prefix + "if_err_rsn", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReturnCSRMasterVO[]
	 */
	public ReturnCSRMasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReturnCSRMasterVO[]
	 */
	public ReturnCSRMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReturnCSRMasterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] audNo = (JSPUtil.getParameter(request, prefix	+ "aud_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] csrNoMaster = (JSPUtil.getParameter(request, prefix	+ "csr_no_master", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] ifErrRsn = (JSPUtil.getParameter(request, prefix	+ "if_err_rsn", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReturnCSRMasterVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (audNo[i] != null)
					model.setAudNo(audNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (csrNoMaster[i] != null)
					model.setCsrNoMaster(csrNoMaster[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (ifErrRsn[i] != null)
					model.setIfErrRsn(ifErrRsn[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReturnCSRMasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReturnCSRMasterVO[]
	 */
	public ReturnCSRMasterVO[] getReturnCSRMasterVOs(){
		ReturnCSRMasterVO[] vos = (ReturnCSRMasterVO[])models.toArray(new ReturnCSRMasterVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audNo = this.audNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNoMaster = this.csrNoMaster .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrRsn = this.ifErrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
