/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRApprovalCommonManagementVO.java
*@FileTitle : CSRApprovalCommonManagementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo;

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

public class CSRApprovalCommonManagementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CSRApprovalCommonManagementVO> models = new ArrayList<CSRApprovalCommonManagementVO>();
	
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String aproRqstSeq = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String loginUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String aproCd = null;
	/* Column Info */
	private String chkCurrAproUsrYn = null;
	/* Column Info */
	private String editableYn = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CSRApprovalCommonManagementVO() {}

	public CSRApprovalCommonManagementVO(String ibflag, String pagerows, String aproRmk, String aproRqstNo, String aproUsrId, String aproRqstSeq, String aproUsrNm, String aproCd, String aproOfcCd, String editableYn, String aproDt, String loginUsrId, String csrNo, String chkCurrAproUsrYn) {
		this.aproRmk = aproRmk;
		this.csrNo = csrNo;
		this.aproRqstSeq = aproRqstSeq;
		this.aproUsrNm = aproUsrNm;
		this.aproOfcCd = aproOfcCd;
		this.aproDt = aproDt;
		this.loginUsrId = loginUsrId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.aproRqstNo = aproRqstNo;
		this.aproUsrId = aproUsrId;
		this.aproCd = aproCd;
		this.chkCurrAproUsrYn = chkCurrAproUsrYn;
		this.editableYn = editableYn;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("apro_rqst_seq", getAproRqstSeq());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("login_usr_id", getLoginUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("apro_cd", getAproCd());
		this.hashColumns.put("chk_curr_apro_usr_yn", getChkCurrAproUsrYn());
		this.hashColumns.put("editable_yn", getEditableYn());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("apro_rqst_seq", "aproRqstSeq");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("login_usr_id", "loginUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("apro_cd", "aproCd");
		this.hashFields.put("chk_curr_apro_usr_yn", "chkCurrAproUsrYn");
		this.hashFields.put("editable_yn", "editableYn");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return aproRqstSeq
	 */
	public String getAproRqstSeq() {
		return this.aproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return loginUsrId
	 */
	public String getLoginUsrId() {
		return this.loginUsrId;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproCd
	 */
	public String getAproCd() {
		return this.aproCd;
	}
	
	/**
	 * Column Info
	 * @return chkCurrAproUsrYn
	 */
	public String getChkCurrAproUsrYn() {
		return this.chkCurrAproUsrYn;
	}
	
	/**
	 * Column Info
	 * @return editableYn
	 */
	public String getEditableYn() {
		return this.editableYn;
	}
	

	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param aproRqstSeq
	 */
	public void setAproRqstSeq(String aproRqstSeq) {
		this.aproRqstSeq = aproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param loginUsrId
	 */
	public void setLoginUsrId(String loginUsrId) {
		this.loginUsrId = loginUsrId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproCd
	 */
	public void setAproCd(String aproCd) {
		this.aproCd = aproCd;
	}
	
	/**
	 * Column Info
	 * @param chkCurrAproUsrYn
	 */
	public void setChkCurrAproUsrYn(String chkCurrAproUsrYn) {
		this.chkCurrAproUsrYn = chkCurrAproUsrYn;
	}
	
	/**
	 * Column Info
	 * @param editableYn
	 */
	public void setEditableYn(String editableYn) {
		this.editableYn = editableYn;
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
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setAproRqstSeq(JSPUtil.getParameter(request, prefix + "apro_rqst_seq", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setLoginUsrId(JSPUtil.getParameter(request, prefix + "login_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAproRqstNo(JSPUtil.getParameter(request, prefix + "apro_rqst_no", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setAproCd(JSPUtil.getParameter(request, prefix + "apro_cd", ""));
		setChkCurrAproUsrYn(JSPUtil.getParameter(request, prefix + "chk_curr_apro_usr_yn", ""));
		setEditableYn(JSPUtil.getParameter(request, prefix + "editable_yn", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSRApprovalCommonManagementVO[]
	 */
	public CSRApprovalCommonManagementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CSRApprovalCommonManagementVO[]
	 */
	public CSRApprovalCommonManagementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSRApprovalCommonManagementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] aproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_seq", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] loginUsrId = (JSPUtil.getParameter(request, prefix	+ "login_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] aproCd = (JSPUtil.getParameter(request, prefix	+ "apro_cd", length));
			String[] chkCurrAproUsrYn = (JSPUtil.getParameter(request, prefix	+ "chk_curr_apro_usr_yn", length));
			String[] editableYn = (JSPUtil.getParameter(request, prefix	+ "editable_yn", length));
			
			for (int i = 0; i < length; i++) {
				model = new CSRApprovalCommonManagementVO();
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (aproRqstSeq[i] != null)
					model.setAproRqstSeq(aproRqstSeq[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (loginUsrId[i] != null)
					model.setLoginUsrId(loginUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (aproCd[i] != null)
					model.setAproCd(aproCd[i]);
				if (chkCurrAproUsrYn[i] != null)
					model.setChkCurrAproUsrYn(chkCurrAproUsrYn[i]);
				if (editableYn[i] != null)
					model.setEditableYn(editableYn[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSRApprovalCommonManagementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CSRApprovalCommonManagementVO[]
	 */
	public CSRApprovalCommonManagementVO[] getCSRApprovalCommonManagementVOs(){
		CSRApprovalCommonManagementVO[] vos = (CSRApprovalCommonManagementVO[])models.toArray(new CSRApprovalCommonManagementVO[models.size()]);
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
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstSeq = this.aproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginUsrId = this.loginUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproCd = this.aproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCurrAproUsrYn = this.chkCurrAproUsrYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.editableYn = this.editableYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
