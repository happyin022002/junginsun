/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationProgramInfoVO.java
*@FileTitle : AuthorizationProgramInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.authorization.vo;

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

public class AuthorizationProgramInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthorizationProgramInfoVO> models = new ArrayList<AuthorizationProgramInfoVO>();
	
	/* Column Info */
	private String dtlPgmUrlCtnt = null;
	/* Column Info */
	private String pgmRmk = null;
	/* Column Info */
	private String subSysCd = null;
	/* Column Info */
	private String subSysCdAuth = null;
	/* Column Info */
	private String authPgmFldSeq = null;
	/* Column Info */
	private String authAproTpCd = null;
	/* Column Info */
	private String btnUseFlg = null;
	/* Column Info */
	private String pgmFldId = null;
	/* Column Info */
	private String pgmNm = null;
	/* Column Info */
	private String pgmBtnNm = null;
	/* Column Info */
	private String pgmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String authAproTpNm = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String authPgmBtnSeq = null;
	/* Column Info */
	private String fldUseFlg = null;
	/* Column Info */
	private String pgmFldNm = null;
	/* Column Info */
	private String pgmUseFlg = null;
	/* Column Info */
	private String pgmBtnId = null;
	/* Column Info */
	private String authPgmSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthorizationProgramInfoVO() {}

	public AuthorizationProgramInfoVO(String ibflag, String pagerows, String dtlPgmUrlCtnt, String pgmRmk, String subSysCd, String subSysCdAuth, String ofcCd, String pgmNo, String pgmNm, String pgmUseFlg, String authAproTpCd, String authAproTpNm, String authPgmBtnSeq, String authPgmFldSeq, String authPgmSeq, String pgmBtnId, String pgmBtnNm, String btnUseFlg, String pgmFldId, String pgmFldNm, String fldUseFlg, String usrId) {
		this.dtlPgmUrlCtnt = dtlPgmUrlCtnt;
		this.pgmRmk = pgmRmk;
		this.subSysCd = subSysCd;
		this.subSysCdAuth = subSysCdAuth;
		this.authPgmFldSeq = authPgmFldSeq;
		this.authAproTpCd = authAproTpCd;
		this.btnUseFlg = btnUseFlg;
		this.pgmFldId = pgmFldId;
		this.pgmNm = pgmNm;
		this.pgmBtnNm = pgmBtnNm;
		this.pgmNo = pgmNo;
		this.pagerows = pagerows;
		this.authAproTpNm = authAproTpNm;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.authPgmBtnSeq = authPgmBtnSeq;
		this.fldUseFlg = fldUseFlg;
		this.pgmFldNm = pgmFldNm;
		this.pgmUseFlg = pgmUseFlg;
		this.pgmBtnId = pgmBtnId;
		this.authPgmSeq = authPgmSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dtl_pgm_url_ctnt", getDtlPgmUrlCtnt());
		this.hashColumns.put("pgm_rmk", getPgmRmk());
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("sub_sys_cd_auth", getSubSysCdAuth());
		this.hashColumns.put("auth_pgm_fld_seq", getAuthPgmFldSeq());
		this.hashColumns.put("auth_apro_tp_cd", getAuthAproTpCd());
		this.hashColumns.put("btn_use_flg", getBtnUseFlg());
		this.hashColumns.put("pgm_fld_id", getPgmFldId());
		this.hashColumns.put("pgm_nm", getPgmNm());
		this.hashColumns.put("pgm_btn_nm", getPgmBtnNm());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("auth_apro_tp_nm", getAuthAproTpNm());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("auth_pgm_btn_seq", getAuthPgmBtnSeq());
		this.hashColumns.put("fld_use_flg", getFldUseFlg());
		this.hashColumns.put("pgm_fld_nm", getPgmFldNm());
		this.hashColumns.put("pgm_use_flg", getPgmUseFlg());
		this.hashColumns.put("pgm_btn_id", getPgmBtnId());
		this.hashColumns.put("auth_pgm_seq", getAuthPgmSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dtl_pgm_url_ctnt", "dtlPgmUrlCtnt");
		this.hashFields.put("pgm_rmk", "pgmRmk");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("sub_sys_cd_auth", "subSysCdAuth");
		this.hashFields.put("auth_pgm_fld_seq", "authPgmFldSeq");
		this.hashFields.put("auth_apro_tp_cd", "authAproTpCd");
		this.hashFields.put("btn_use_flg", "btnUseFlg");
		this.hashFields.put("pgm_fld_id", "pgmFldId");
		this.hashFields.put("pgm_nm", "pgmNm");
		this.hashFields.put("pgm_btn_nm", "pgmBtnNm");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("auth_apro_tp_nm", "authAproTpNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("auth_pgm_btn_seq", "authPgmBtnSeq");
		this.hashFields.put("fld_use_flg", "fldUseFlg");
		this.hashFields.put("pgm_fld_nm", "pgmFldNm");
		this.hashFields.put("pgm_use_flg", "pgmUseFlg");
		this.hashFields.put("pgm_btn_id", "pgmBtnId");
		this.hashFields.put("auth_pgm_seq", "authPgmSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dtlPgmUrlCtnt
	 */
	public String getDtlPgmUrlCtnt() {
		return this.dtlPgmUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @return subSysCd
	 */
	public String getPgmRmk() {
		return this.pgmRmk;
	}
	
	/**
	 * Column Info
	 * @return subSysCd
	 */
	public String getSubSysCd() {
		return this.subSysCd;
	}
	
	/**
	 * Column Info
	 * @return subSysCd
	 */
	public String getSubSysCdAuth() {
		return this.subSysCdAuth;
	}
	
	/**
	 * Column Info
	 * @return authPgmFldSeq
	 */
	public String getAuthPgmFldSeq() {
		return this.authPgmFldSeq;
	}
	
	/**
	 * Column Info
	 * @return authAproTpCd
	 */
	public String getAuthAproTpCd() {
		return this.authAproTpCd;
	}
	
	/**
	 * Column Info
	 * @return btnUseFlg
	 */
	public String getBtnUseFlg() {
		return this.btnUseFlg;
	}
	
	/**
	 * Column Info
	 * @return pgmFldId
	 */
	public String getPgmFldId() {
		return this.pgmFldId;
	}
	
	/**
	 * Column Info
	 * @return pgmNm
	 */
	public String getPgmNm() {
		return this.pgmNm;
	}
	
	/**
	 * Column Info
	 * @return pgmBtnNm
	 */
	public String getPgmBtnNm() {
		return this.pgmBtnNm;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
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
	 * @return authAproTpNm
	 */
	public String getAuthAproTpNm() {
		return this.authAproTpNm;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return authPgmBtnSeq
	 */
	public String getAuthPgmBtnSeq() {
		return this.authPgmBtnSeq;
	}
	
	/**
	 * Column Info
	 * @return fldUseFlg
	 */
	public String getFldUseFlg() {
		return this.fldUseFlg;
	}
	
	/**
	 * Column Info
	 * @return pgmFldNm
	 */
	public String getPgmFldNm() {
		return this.pgmFldNm;
	}
	
	/**
	 * Column Info
	 * @return pgmUseFlg
	 */
	public String getPgmUseFlg() {
		return this.pgmUseFlg;
	}
	
	/**
	 * Column Info
	 * @return pgmBtnId
	 */
	public String getPgmBtnId() {
		return this.pgmBtnId;
	}
	
	/**
	 * Column Info
	 * @return authPgmSeq
	 */
	public String getAuthPgmSeq() {
		return this.authPgmSeq;
	}
	
	/**
	 * Column Info
	 * @param dtlPgmUrlCtnt
	 */
	public void setDtlPgmUrlCtnt(String dtlPgmUrlCtnt) {
		this.dtlPgmUrlCtnt = dtlPgmUrlCtnt;
	}
	
	/**
	 * Column Info
	 * @param subSysCd
	 */
	public void setPgmRmk(String pgmRmk) {
		this.pgmRmk = pgmRmk;
	}
	
	/**
	 * Column Info
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	
	/**
	 * Column Info
	 * @param subSysCd
	 */
	public void setSubSysCdAuth(String subSysCdAuth) {
		this.subSysCdAuth = subSysCdAuth;
	}
	
	/**
	 * Column Info
	 * @param authPgmFldSeq
	 */
	public void setAuthPgmFldSeq(String authPgmFldSeq) {
		this.authPgmFldSeq = authPgmFldSeq;
	}
	
	/**
	 * Column Info
	 * @param authAproTpCd
	 */
	public void setAuthAproTpCd(String authAproTpCd) {
		this.authAproTpCd = authAproTpCd;
	}
	
	/**
	 * Column Info
	 * @param btnUseFlg
	 */
	public void setBtnUseFlg(String btnUseFlg) {
		this.btnUseFlg = btnUseFlg;
	}
	
	/**
	 * Column Info
	 * @param pgmFldId
	 */
	public void setPgmFldId(String pgmFldId) {
		this.pgmFldId = pgmFldId;
	}
	
	/**
	 * Column Info
	 * @param pgmNm
	 */
	public void setPgmNm(String pgmNm) {
		this.pgmNm = pgmNm;
	}
	
	/**
	 * Column Info
	 * @param pgmBtnNm
	 */
	public void setPgmBtnNm(String pgmBtnNm) {
		this.pgmBtnNm = pgmBtnNm;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
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
	 * @param authAproTpNm
	 */
	public void setAuthAproTpNm(String authAproTpNm) {
		this.authAproTpNm = authAproTpNm;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param authPgmBtnSeq
	 */
	public void setAuthPgmBtnSeq(String authPgmBtnSeq) {
		this.authPgmBtnSeq = authPgmBtnSeq;
	}
	
	/**
	 * Column Info
	 * @param fldUseFlg
	 */
	public void setFldUseFlg(String fldUseFlg) {
		this.fldUseFlg = fldUseFlg;
	}
	
	/**
	 * Column Info
	 * @param pgmFldNm
	 */
	public void setPgmFldNm(String pgmFldNm) {
		this.pgmFldNm = pgmFldNm;
	}
	
	/**
	 * Column Info
	 * @param pgmUseFlg
	 */
	public void setPgmUseFlg(String pgmUseFlg) {
		this.pgmUseFlg = pgmUseFlg;
	}
	
	/**
	 * Column Info
	 * @param pgmBtnId
	 */
	public void setPgmBtnId(String pgmBtnId) {
		this.pgmBtnId = pgmBtnId;
	}
	
	/**
	 * Column Info
	 * @param authPgmSeq
	 */
	public void setAuthPgmSeq(String authPgmSeq) {
		this.authPgmSeq = authPgmSeq;
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
		setDtlPgmUrlCtnt(JSPUtil.getParameter(request, prefix + "dtl_pgm_url_ctnt", ""));
		setPgmRmk(JSPUtil.getParameter(request, prefix + "pgm_rmk", ""));
		setSubSysCd(JSPUtil.getParameter(request, prefix + "sub_sys_cd", ""));
		setSubSysCdAuth(JSPUtil.getParameter(request, prefix + "sub_sys_cd_auth", ""));
		setAuthPgmFldSeq(JSPUtil.getParameter(request, prefix + "auth_pgm_fld_seq", ""));
		setAuthAproTpCd(JSPUtil.getParameter(request, prefix + "auth_apro_tp_cd", ""));
		setBtnUseFlg(JSPUtil.getParameter(request, prefix + "btn_use_flg", ""));
		setPgmFldId(JSPUtil.getParameter(request, prefix + "pgm_fld_id", ""));
		setPgmNm(JSPUtil.getParameter(request, prefix + "pgm_nm", ""));
		setPgmBtnNm(JSPUtil.getParameter(request, prefix + "pgm_btn_nm", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAuthAproTpNm(JSPUtil.getParameter(request, prefix + "auth_apro_tp_nm", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAuthPgmBtnSeq(JSPUtil.getParameter(request, prefix + "auth_pgm_btn_seq", ""));
		setFldUseFlg(JSPUtil.getParameter(request, prefix + "fld_use_flg", ""));
		setPgmFldNm(JSPUtil.getParameter(request, prefix + "pgm_fld_nm", ""));
		setPgmUseFlg(JSPUtil.getParameter(request, prefix + "pgm_use_flg", ""));
		setPgmBtnId(JSPUtil.getParameter(request, prefix + "pgm_btn_id", ""));
		setAuthPgmSeq(JSPUtil.getParameter(request, prefix + "auth_pgm_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthorizationProgramInfoVO[]
	 */
	public AuthorizationProgramInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthorizationProgramInfoVO[]
	 */
	public AuthorizationProgramInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthorizationProgramInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dtlPgmUrlCtnt = (JSPUtil.getParameter(request, prefix	+ "dtl_pgm_url_ctnt", length));
			String[] pgmRmk = (JSPUtil.getParameter(request, prefix	+ "pgm_rmk", length));
			String[] subSysCd = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd", length));
			String[] subSysCdAuth = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd_auth", length));
			String[] authPgmFldSeq = (JSPUtil.getParameter(request, prefix	+ "auth_pgm_fld_seq", length));
			String[] authAproTpCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_tp_cd", length));
			String[] btnUseFlg = (JSPUtil.getParameter(request, prefix	+ "btn_use_flg", length));
			String[] pgmFldId = (JSPUtil.getParameter(request, prefix	+ "pgm_fld_id", length));
			String[] pgmNm = (JSPUtil.getParameter(request, prefix	+ "pgm_nm", length));
			String[] pgmBtnNm = (JSPUtil.getParameter(request, prefix	+ "pgm_btn_nm", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] authAproTpNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_tp_nm", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] authPgmBtnSeq = (JSPUtil.getParameter(request, prefix	+ "auth_pgm_btn_seq", length));
			String[] fldUseFlg = (JSPUtil.getParameter(request, prefix	+ "fld_use_flg", length));
			String[] pgmFldNm = (JSPUtil.getParameter(request, prefix	+ "pgm_fld_nm", length));
			String[] pgmUseFlg = (JSPUtil.getParameter(request, prefix	+ "pgm_use_flg", length));
			String[] pgmBtnId = (JSPUtil.getParameter(request, prefix	+ "pgm_btn_id", length));
			String[] authPgmSeq = (JSPUtil.getParameter(request, prefix	+ "auth_pgm_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthorizationProgramInfoVO();
				if (dtlPgmUrlCtnt[i] != null)
					model.setDtlPgmUrlCtnt(dtlPgmUrlCtnt[i]);
				if (pgmRmk[i] != null)
					model.setPgmRmk(pgmRmk[i]);
				if (subSysCd[i] != null)
					model.setSubSysCd(subSysCd[i]);
				if (subSysCdAuth[i] != null)
					model.setSubSysCdAuth(subSysCdAuth[i]);
				if (authPgmFldSeq[i] != null)
					model.setAuthPgmFldSeq(authPgmFldSeq[i]);
				if (authAproTpCd[i] != null)
					model.setAuthAproTpCd(authAproTpCd[i]);
				if (btnUseFlg[i] != null)
					model.setBtnUseFlg(btnUseFlg[i]);
				if (pgmFldId[i] != null)
					model.setPgmFldId(pgmFldId[i]);
				if (pgmNm[i] != null)
					model.setPgmNm(pgmNm[i]);
				if (pgmBtnNm[i] != null)
					model.setPgmBtnNm(pgmBtnNm[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (authAproTpNm[i] != null)
					model.setAuthAproTpNm(authAproTpNm[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (authPgmBtnSeq[i] != null)
					model.setAuthPgmBtnSeq(authPgmBtnSeq[i]);
				if (fldUseFlg[i] != null)
					model.setFldUseFlg(fldUseFlg[i]);
				if (pgmFldNm[i] != null)
					model.setPgmFldNm(pgmFldNm[i]);
				if (pgmUseFlg[i] != null)
					model.setPgmUseFlg(pgmUseFlg[i]);
				if (pgmBtnId[i] != null)
					model.setPgmBtnId(pgmBtnId[i]);
				if (authPgmSeq[i] != null)
					model.setAuthPgmSeq(authPgmSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthorizationProgramInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthorizationProgramInfoVO[]
	 */
	public AuthorizationProgramInfoVO[] getAuthorizationProgramInfoVOs(){
		AuthorizationProgramInfoVO[] vos = (AuthorizationProgramInfoVO[])models.toArray(new AuthorizationProgramInfoVO[models.size()]);
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
		this.dtlPgmUrlCtnt = this.dtlPgmUrlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmRmk = this.pgmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd = this.subSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCdAuth = this.subSysCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authPgmFldSeq = this.authPgmFldSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproTpCd = this.authAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.btnUseFlg = this.btnUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmFldId = this.pgmFldId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNm = this.pgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmBtnNm = this.pgmBtnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproTpNm = this.authAproTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authPgmBtnSeq = this.authPgmBtnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldUseFlg = this.fldUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmFldNm = this.pgmFldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmUseFlg = this.pgmUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmBtnId = this.pgmBtnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authPgmSeq = this.authPgmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
