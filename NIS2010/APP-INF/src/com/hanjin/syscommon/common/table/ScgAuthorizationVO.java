/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgAuthorizationVO.java
*@FileTitle : ScgAuthorizationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.22 이도형 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이도형
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgAuthorizationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgAuthorizationVO> models = new ArrayList<ScgAuthorizationVO>();
	
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String vslSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAproRqstSeq = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String spclCgoAuthNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String authOfcCd = null;
	/* Column Info */
	private String spclCgoAuthCd = null;
	/* Column Info */
	private String authDt = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String spclCgoAuthRjctCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String spclCgoAuthRmk = null;
	/* Column Info */
	private String bbCgoSeq = null;
	/* Column Info */
	private String spclCgoAuthSeq = null;
	/* Column Info */
	private String authUsrId = null;
	/* Column Info */
	private String aproRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgAuthorizationVO() {}

	public ScgAuthorizationVO(String ibflag, String pagerows, String bkgNo, String spclCgoAproRqstSeq, String vslPrePstCd, String vslSeq, String spclCgoAuthSeq, String spclCgoCateCd, String dcgoSeq, String rcSeq, String bbCgoSeq, String awkCgoSeq, String rgnShpOprCd, String spclCgoAuthCd, String authOfcCd, String authUsrId, String authDt, String spclCgoAuthNo, String spclCgoAuthRjctCd, String aproRefNo, String spclCgoAuthRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.rcSeq = rcSeq;
		this.creDt = creDt;
		this.awkCgoSeq = awkCgoSeq;
		this.dcgoSeq = dcgoSeq;
		this.vslSeq = vslSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
		this.vslPrePstCd = vslPrePstCd;
		this.updUsrId = updUsrId;
		this.spclCgoAuthNo = spclCgoAuthNo;
		this.updDt = updDt;
		this.rgnShpOprCd = rgnShpOprCd;
		this.authOfcCd = authOfcCd;
		this.spclCgoAuthCd = spclCgoAuthCd;
		this.authDt = authDt;
		this.spclCgoCateCd = spclCgoCateCd;
		this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.spclCgoAuthRmk = spclCgoAuthRmk;
		this.bbCgoSeq = bbCgoSeq;
		this.spclCgoAuthSeq = spclCgoAuthSeq;
		this.authUsrId = authUsrId;
		this.aproRefNo = aproRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("spcl_cgo_auth_no", getSpclCgoAuthNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
		this.hashColumns.put("spcl_cgo_auth_cd", getSpclCgoAuthCd());
		this.hashColumns.put("auth_dt", getAuthDt());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("spcl_cgo_auth_rjct_cd", getSpclCgoAuthRjctCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spcl_cgo_auth_rmk", getSpclCgoAuthRmk());
		this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
		this.hashColumns.put("spcl_cgo_auth_seq", getSpclCgoAuthSeq());
		this.hashColumns.put("auth_usr_id", getAuthUsrId());
		this.hashColumns.put("apro_ref_no", getAproRefNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("spcl_cgo_auth_no", "spclCgoAuthNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("auth_ofc_cd", "authOfcCd");
		this.hashFields.put("spcl_cgo_auth_cd", "spclCgoAuthCd");
		this.hashFields.put("auth_dt", "authDt");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("spcl_cgo_auth_rjct_cd", "spclCgoAuthRjctCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spcl_cgo_auth_rmk", "spclCgoAuthRmk");
		this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
		this.hashFields.put("spcl_cgo_auth_seq", "spclCgoAuthSeq");
		this.hashFields.put("auth_usr_id", "authUsrId");
		this.hashFields.put("apro_ref_no", "aproRefNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
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
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
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
	 * @return spclCgoAproRqstSeq
	 */
	public String getSpclCgoAproRqstSeq() {
		return this.spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
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
	 * @return spclCgoAuthNo
	 */
	public String getSpclCgoAuthNo() {
		return this.spclCgoAuthNo;
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
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return authOfcCd
	 */
	public String getAuthOfcCd() {
		return this.authOfcCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAuthCd
	 */
	public String getSpclCgoAuthCd() {
		return this.spclCgoAuthCd;
	}
	
	/**
	 * Column Info
	 * @return authDt
	 */
	public String getAuthDt() {
		return this.authDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoCateCd
	 */
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAuthRjctCd
	 */
	public String getSpclCgoAuthRjctCd() {
		return this.spclCgoAuthRjctCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return spclCgoAuthRmk
	 */
	public String getSpclCgoAuthRmk() {
		return this.spclCgoAuthRmk;
	}
	
	/**
	 * Column Info
	 * @return bbCgoSeq
	 */
	public String getBbCgoSeq() {
		return this.bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAuthSeq
	 */
	public String getSpclCgoAuthSeq() {
		return this.spclCgoAuthSeq;
	}
	
	/**
	 * Column Info
	 * @return authUsrId
	 */
	public String getAuthUsrId() {
		return this.authUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproRefNo
	 */
	public String getAproRefNo() {
		return this.aproRefNo;
	}
	

	/**
	 * Column Info
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
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
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
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
	 * @param spclCgoAproRqstSeq
	 */
	public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthNo
	 */
	public void setSpclCgoAuthNo(String spclCgoAuthNo) {
		this.spclCgoAuthNo = spclCgoAuthNo;
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
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @param authOfcCd
	 */
	public void setAuthOfcCd(String authOfcCd) {
		this.authOfcCd = authOfcCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthCd
	 */
	public void setSpclCgoAuthCd(String spclCgoAuthCd) {
		this.spclCgoAuthCd = spclCgoAuthCd;
	}
	
	/**
	 * Column Info
	 * @param authDt
	 */
	public void setAuthDt(String authDt) {
		this.authDt = authDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoCateCd
	 */
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthRjctCd
	 */
	public void setSpclCgoAuthRjctCd(String spclCgoAuthRjctCd) {
		this.spclCgoAuthRjctCd = spclCgoAuthRjctCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param spclCgoAuthRmk
	 */
	public void setSpclCgoAuthRmk(String spclCgoAuthRmk) {
		this.spclCgoAuthRmk = spclCgoAuthRmk;
	}
	
	/**
	 * Column Info
	 * @param bbCgoSeq
	 */
	public void setBbCgoSeq(String bbCgoSeq) {
		this.bbCgoSeq = bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAuthSeq
	 */
	public void setSpclCgoAuthSeq(String spclCgoAuthSeq) {
		this.spclCgoAuthSeq = spclCgoAuthSeq;
	}
	
	/**
	 * Column Info
	 * @param authUsrId
	 */
	public void setAuthUsrId(String authUsrId) {
		this.authUsrId = authUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproRefNo
	 */
	public void setAproRefNo(String aproRefNo) {
		this.aproRefNo = aproRefNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRcSeq(JSPUtil.getParameter(request, "rc_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, "awk_cgo_seq", ""));
		setDcgoSeq(JSPUtil.getParameter(request, "dcgo_seq", ""));
		setVslSeq(JSPUtil.getParameter(request, "vsl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, "spcl_cgo_apro_rqst_seq", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, "vsl_pre_pst_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSpclCgoAuthNo(JSPUtil.getParameter(request, "spcl_cgo_auth_no", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, "rgn_shp_opr_cd", ""));
		setAuthOfcCd(JSPUtil.getParameter(request, "auth_ofc_cd", ""));
		setSpclCgoAuthCd(JSPUtil.getParameter(request, "spcl_cgo_auth_cd", ""));
		setAuthDt(JSPUtil.getParameter(request, "auth_dt", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, "spcl_cgo_cate_cd", ""));
		setSpclCgoAuthRjctCd(JSPUtil.getParameter(request, "spcl_cgo_auth_rjct_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSpclCgoAuthRmk(JSPUtil.getParameter(request, "spcl_cgo_auth_rmk", ""));
		setBbCgoSeq(JSPUtil.getParameter(request, "bb_cgo_seq", ""));
		setSpclCgoAuthSeq(JSPUtil.getParameter(request, "spcl_cgo_auth_seq", ""));
		setAuthUsrId(JSPUtil.getParameter(request, "auth_usr_id", ""));
		setAproRefNo(JSPUtil.getParameter(request, "apro_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgAuthorizationVO[]
	 */
	public ScgAuthorizationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgAuthorizationVO[]
	 */
	public ScgAuthorizationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgAuthorizationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_rqst_seq", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] spclCgoAuthNo = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] authOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_ofc_cd", length));
			String[] spclCgoAuthCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_cd", length));
			String[] authDt = (JSPUtil.getParameter(request, prefix	+ "auth_dt", length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd", length));
			String[] spclCgoAuthRjctCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_rjct_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] spclCgoAuthRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_rmk", length));
			String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_seq", length));
			String[] spclCgoAuthSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_auth_seq", length));
			String[] authUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_usr_id", length));
			String[] aproRefNo = (JSPUtil.getParameter(request, prefix	+ "apro_ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgAuthorizationVO();
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAproRqstSeq[i] != null)
					model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (spclCgoAuthNo[i] != null)
					model.setSpclCgoAuthNo(spclCgoAuthNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (authOfcCd[i] != null)
					model.setAuthOfcCd(authOfcCd[i]);
				if (spclCgoAuthCd[i] != null)
					model.setSpclCgoAuthCd(spclCgoAuthCd[i]);
				if (authDt[i] != null)
					model.setAuthDt(authDt[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (spclCgoAuthRjctCd[i] != null)
					model.setSpclCgoAuthRjctCd(spclCgoAuthRjctCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (spclCgoAuthRmk[i] != null)
					model.setSpclCgoAuthRmk(spclCgoAuthRmk[i]);
				if (bbCgoSeq[i] != null)
					model.setBbCgoSeq(bbCgoSeq[i]);
				if (spclCgoAuthSeq[i] != null)
					model.setSpclCgoAuthSeq(spclCgoAuthSeq[i]);
				if (authUsrId[i] != null)
					model.setAuthUsrId(authUsrId[i]);
				if (aproRefNo[i] != null)
					model.setAproRefNo(aproRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgAuthorizationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgAuthorizationVO[]
	 */
	public ScgAuthorizationVO[] getScgAuthorizationVOs(){
		ScgAuthorizationVO[] vos = (ScgAuthorizationVO[])models.toArray(new ScgAuthorizationVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthNo = this.spclCgoAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authOfcCd = this.authOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthCd = this.spclCgoAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authDt = this.authDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthRjctCd = this.spclCgoAuthRjctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthRmk = this.spclCgoAuthRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoSeq = this.bbCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAuthSeq = this.spclCgoAuthSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authUsrId = this.authUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRefNo = this.aproRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
