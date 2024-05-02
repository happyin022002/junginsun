/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AuthorityCarrierVO.java
*@FileTitle : AuthorityCarrierVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo;

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
public class AuthorityCarrierVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthorityCarrierVO> models = new ArrayList<AuthorityCarrierVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String joCrrCd = null;

	/* Column Info */
	private String trdCd = null;

	/* Column Info */
	private String rlaneCd = null;

	/* Column Info */
	private String authOfcCd = null;

	/* Column Info */
	private String joCrrAuthCd = null;

	/* Column Info */
	private String deltFlg = null;

	/* Column Info */
	private String vndrSeq = null;

	/* Column Info */
	private String vndrLglEngNm = null;

	/* Column Info */
	private String custCd = null;

	/* Column Info */
	private String custCntCd = null;

	/* Column Info */
	private String custSeq = null;

	/* Column Info */
	private String custLglEngNm = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthorityCarrierVO() {}

	public AuthorityCarrierVO(String ibflag, String pagerows, String joCrrCd, String trdCd, String rlaneCd, String authOfcCd, String joCrrAuthCd, String deltFlg, String vndrSeq, String vndrLglEngNm, String custCd, String custCntCd, String custSeq, String custLglEngNm, String creDt, String creUsrId, String updDt, String updUsrId) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.joCrrCd = joCrrCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.authOfcCd = authOfcCd;
		this.joCrrAuthCd = joCrrAuthCd;
		this.deltFlg = deltFlg;
		this.vndrSeq = vndrSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.custCd = custCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.custLglEngNm = custLglEngNm;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.updDt = updDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("auth_ofc_cd", getAuthOfcCd());
		this.hashColumns.put("jo_crr_auth_cd", getJoCrrAuthCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("auth_ofc_cd", "authOfcCd");
		this.hashFields.put("jo_crr_auth_cd", "joCrrAuthCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * 
	 * @return String joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 *
	 * @param String trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * 
	 * @return String trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 *
	 * @param String rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * 
	 * @return String rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 *
	 * @param String authOfcCd
	 */
	public void setAuthOfcCd(String authOfcCd) {
		this.authOfcCd = authOfcCd;
	}
	
	/**
	 * 
	 * @return String authOfcCd
	 */
	public String getAuthOfcCd() {
		return this.authOfcCd;
	}
	
	/**
	 *
	 * @param String joCrrAuthCd
	 */
	public void setJoCrrAuthCd(String joCrrAuthCd) {
		this.joCrrAuthCd = joCrrAuthCd;
	}
	
	/**
	 * 
	 * @return String joCrrAuthCd
	 */
	public String getJoCrrAuthCd() {
		return this.joCrrAuthCd;
	}
	
	/**
	 *
	 * @param String deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 
	 * @return String deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 *
	 * @param String vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * 
	 * @return String vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 *
	 * @param String vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * 
	 * @return String vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 *
	 * @param String custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * 
	 * @return String custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 *
	 * @param String custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 
	 * @return String custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 *
	 * @param String custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * 
	 * @return String custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 *
	 * @param String custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * 
	 * @return String custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAuthOfcCd(JSPUtil.getParameter(request, prefix + "auth_ofc_cd", ""));
		setJoCrrAuthCd(JSPUtil.getParameter(request, prefix + "jo_crr_auth_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthorityCarrierVO[]
	 */
	public AuthorityCarrierVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthorityCarrierVO[]
	 */
	public AuthorityCarrierVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthorityCarrierVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] authOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_ofc_cd", length));
			String[] joCrrAuthCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_auth_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new AuthorityCarrierVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (joCrrCd[i] != null) 
					model.setJoCrrCd(joCrrCd[i]);
				if (trdCd[i] != null) 
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null) 
					model.setRlaneCd(rlaneCd[i]);
				if (authOfcCd[i] != null) 
					model.setAuthOfcCd(authOfcCd[i]);
				if (joCrrAuthCd[i] != null) 
					model.setJoCrrAuthCd(joCrrAuthCd[i]);
				if (deltFlg[i] != null) 
					model.setDeltFlg(deltFlg[i]);
				if (vndrSeq[i] != null) 
					model.setVndrSeq(vndrSeq[i]);
				if (vndrLglEngNm[i] != null) 
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (custCd[i] != null) 
					model.setCustCd(custCd[i]);
				if (custCntCd[i] != null) 
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null) 
					model.setCustSeq(custSeq[i]);
				if (custLglEngNm[i] != null) 
					model.setCustLglEngNm(custLglEngNm[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthorityCarrierVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthorityCarrierVO[]
	 */
	public AuthorityCarrierVO[] getAuthorityCarrierVOs(){
		AuthorityCarrierVO[] vos = (AuthorityCarrierVO[])models.toArray(new AuthorityCarrierVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authOfcCd = this.authOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrAuthCd = this.joCrrAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}