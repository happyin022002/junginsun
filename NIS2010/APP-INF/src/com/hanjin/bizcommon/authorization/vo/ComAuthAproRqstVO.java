/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : ComAuthAproRqstVO.java
*@FileTitle : ComAuthAproRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.08  
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

public class ComAuthAproRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComAuthAproRqstVO> models = new ArrayList<ComAuthAproRqstVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String authRqstRsn = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String crntAuthAproRqstSeq = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rqstUsrJbTitNm = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String authApstsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rqstOfcNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstEndDt = null;
	/* Column Info */
	private String rqstStDt = null;
	/* Column Info */
	private String authAproRqstNo = null;
	/* Column Info */
	private String authPgmBtnSeq = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComAuthAproRqstVO() {}

	public ComAuthAproRqstVO(String ibflag, String pagerows, String authRqstRsn, String authAproRqstNo, String authPgmBtnSeq, String authApstsCd, String crntAuthAproRqstSeq, String rqstUsrId, String rqstUsrNm, String rqstOfcCd, String rqstOfcNm, String rqstUsrJbTitNm, String rqstStDt, String rqstEndDt, String cfmFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.authRqstRsn = authRqstRsn;
		this.rqstUsrId = rqstUsrId;
		this.deltFlg = deltFlg;
		this.crntAuthAproRqstSeq = crntAuthAproRqstSeq;
		this.rqstUsrNm = rqstUsrNm;
		this.creDt = creDt;
		this.rqstUsrJbTitNm = rqstUsrJbTitNm;
		this.cfmFlg = cfmFlg;
		this.authApstsCd = authApstsCd;
		this.pagerows = pagerows;
		this.rqstOfcNm = rqstOfcNm;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rqstEndDt = rqstEndDt;
		this.rqstStDt = rqstStDt;
		this.authAproRqstNo = authAproRqstNo;
		this.authPgmBtnSeq = authPgmBtnSeq;
		this.rqstOfcCd = rqstOfcCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("auth_rqst_rsn", getAuthRqstRsn());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("crnt_auth_apro_rqst_seq", getCrntAuthAproRqstSeq());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rqst_usr_jb_tit_nm", getRqstUsrJbTitNm());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("auth_apsts_cd", getAuthApstsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rqst_ofc_nm", getRqstOfcNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_end_dt", getRqstEndDt());
		this.hashColumns.put("rqst_st_dt", getRqstStDt());
		this.hashColumns.put("auth_apro_rqst_no", getAuthAproRqstNo());
		this.hashColumns.put("auth_pgm_btn_seq", getAuthPgmBtnSeq());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("auth_rqst_rsn", "authRqstRsn");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("crnt_auth_apro_rqst_seq", "crntAuthAproRqstSeq");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rqst_usr_jb_tit_nm", "rqstUsrJbTitNm");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("auth_apsts_cd", "authApstsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rqst_ofc_nm", "rqstOfcNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_end_dt", "rqstEndDt");
		this.hashFields.put("rqst_st_dt", "rqstStDt");
		this.hashFields.put("auth_apro_rqst_no", "authAproRqstNo");
		this.hashFields.put("auth_pgm_btn_seq", "authPgmBtnSeq");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return authRqstRsn
	 */
	public String getAuthRqstRsn() {
		return this.authRqstRsn;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return crntAuthAproRqstSeq
	 */
	public String getCrntAuthAproRqstSeq() {
		return this.crntAuthAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
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
	 * @return rqstUsrJbTitNm
	 */
	public String getRqstUsrJbTitNm() {
		return this.rqstUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return authApstsCd
	 */
	public String getAuthApstsCd() {
		return this.authApstsCd;
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
	 * @return rqstOfcNm
	 */
	public String getRqstOfcNm() {
		return this.rqstOfcNm;
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
	 * @return rqstEndDt
	 */
	public String getRqstEndDt() {
		return this.rqstEndDt;
	}
	
	/**
	 * Column Info
	 * @return rqstStDt
	 */
	public String getRqstStDt() {
		return this.rqstStDt;
	}
	
	/**
	 * Column Info
	 * @return authAproRqstNo
	 */
	public String getAuthAproRqstNo() {
		return this.authAproRqstNo;
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
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param authRqstRsn
	 */
	public void setAuthRqstRsn(String authRqstRsn) {
		this.authRqstRsn = authRqstRsn;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param crntAuthAproRqstSeq
	 */
	public void setCrntAuthAproRqstSeq(String crntAuthAproRqstSeq) {
		this.crntAuthAproRqstSeq = crntAuthAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
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
	 * @param rqstUsrJbTitNm
	 */
	public void setRqstUsrJbTitNm(String rqstUsrJbTitNm) {
		this.rqstUsrJbTitNm = rqstUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param authApstsCd
	 */
	public void setAuthApstsCd(String authApstsCd) {
		this.authApstsCd = authApstsCd;
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
	 * @param rqstOfcNm
	 */
	public void setRqstOfcNm(String rqstOfcNm) {
		this.rqstOfcNm = rqstOfcNm;
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
	 * @param rqstEndDt
	 */
	public void setRqstEndDt(String rqstEndDt) {
		this.rqstEndDt = rqstEndDt;
	}
	
	/**
	 * Column Info
	 * @param rqstStDt
	 */
	public void setRqstStDt(String rqstStDt) {
		this.rqstStDt = rqstStDt;
	}
	
	/**
	 * Column Info
	 * @param authAproRqstNo
	 */
	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
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
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setAuthRqstRsn(JSPUtil.getParameter(request, prefix + "auth_rqst_rsn", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCrntAuthAproRqstSeq(JSPUtil.getParameter(request, prefix + "crnt_auth_apro_rqst_seq", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRqstUsrJbTitNm(JSPUtil.getParameter(request, prefix + "rqst_usr_jb_tit_nm", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setAuthApstsCd(JSPUtil.getParameter(request, prefix + "auth_apsts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstOfcNm(JSPUtil.getParameter(request, prefix + "rqst_ofc_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstEndDt(JSPUtil.getParameter(request, prefix + "rqst_end_dt", ""));
		setRqstStDt(JSPUtil.getParameter(request, prefix + "rqst_st_dt", ""));
		setAuthAproRqstNo(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_no", ""));
		setAuthPgmBtnSeq(JSPUtil.getParameter(request, prefix + "auth_pgm_btn_seq", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComAuthAproRqstVO[]
	 */
	public ComAuthAproRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComAuthAproRqstVO[]
	 */
	public ComAuthAproRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComAuthAproRqstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] authRqstRsn = (JSPUtil.getParameter(request, prefix	+ "auth_rqst_rsn", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] crntAuthAproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "crnt_auth_apro_rqst_seq", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rqstUsrJbTitNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_jb_tit_nm", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] authApstsCd = (JSPUtil.getParameter(request, prefix	+ "auth_apsts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstOfcNm = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstEndDt = (JSPUtil.getParameter(request, prefix	+ "rqst_end_dt", length));
			String[] rqstStDt = (JSPUtil.getParameter(request, prefix	+ "rqst_st_dt", length));
			String[] authAproRqstNo = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_no", length));
			String[] authPgmBtnSeq = (JSPUtil.getParameter(request, prefix	+ "auth_pgm_btn_seq", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComAuthAproRqstVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (authRqstRsn[i] != null)
					model.setAuthRqstRsn(authRqstRsn[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (crntAuthAproRqstSeq[i] != null)
					model.setCrntAuthAproRqstSeq(crntAuthAproRqstSeq[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rqstUsrJbTitNm[i] != null)
					model.setRqstUsrJbTitNm(rqstUsrJbTitNm[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (authApstsCd[i] != null)
					model.setAuthApstsCd(authApstsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstOfcNm[i] != null)
					model.setRqstOfcNm(rqstOfcNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstEndDt[i] != null)
					model.setRqstEndDt(rqstEndDt[i]);
				if (rqstStDt[i] != null)
					model.setRqstStDt(rqstStDt[i]);
				if (authAproRqstNo[i] != null)
					model.setAuthAproRqstNo(authAproRqstNo[i]);
				if (authPgmBtnSeq[i] != null)
					model.setAuthPgmBtnSeq(authPgmBtnSeq[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComAuthAproRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComAuthAproRqstVO[]
	 */
	public ComAuthAproRqstVO[] getComAuthAproRqstVOs(){
		ComAuthAproRqstVO[] vos = (ComAuthAproRqstVO[])models.toArray(new ComAuthAproRqstVO[models.size()]);
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
		this.authRqstRsn = this.authRqstRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntAuthAproRqstSeq = this.crntAuthAproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrJbTitNm = this.rqstUsrJbTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authApstsCd = this.authApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcNm = this.rqstOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEndDt = this.rqstEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDt = this.rqstStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstNo = this.authAproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authPgmBtnSeq = this.authPgmBtnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
