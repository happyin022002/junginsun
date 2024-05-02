/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JooLtrStlVO.java
*@FileTitle : JooLtrStlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.13 장강철 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JooLtrStlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JooLtrStlVO> models = new ArrayList<JooLtrStlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String joHjsAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String joLtrStlSeq = null;
	/* Column Info */
	private String acctYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String joLtrSeq = null;
	/* Column Info */
	private String joPrnrAmt = null;
	/* Column Info */
	private String joBalAmt = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String stlRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JooLtrStlVO() {}

	public JooLtrStlVO(String ibflag, String pagerows, String joLtrSeq, String joLtrStlSeq, String vslSlanCd, String ttlAmt, String joHjsAmt, String joPrnrAmt, String joBalAmt, String stlRmk, String creDt, String creUsrId, String updDt, String updUsrId, String acctYrmon, String joCrrCd, String stlCmbSeq) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.joCrrCd = joCrrCd;
		this.ttlAmt = ttlAmt;
		this.vslSlanCd = vslSlanCd;
		this.joHjsAmt = joHjsAmt;
		this.pagerows = pagerows;
		this.joLtrStlSeq = joLtrStlSeq;
		this.acctYrmon = acctYrmon;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.joLtrSeq = joLtrSeq;
		this.joPrnrAmt = joPrnrAmt;
		this.joBalAmt = joBalAmt;
		this.stlCmbSeq = stlCmbSeq;
		this.updUsrId = updUsrId;
		this.stlRmk = stlRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("jo_hjs_amt", getJoHjsAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jo_ltr_stl_seq", getJoLtrStlSeq());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("jo_ltr_seq", getJoLtrSeq());
		this.hashColumns.put("jo_prnr_amt", getJoPrnrAmt());
		this.hashColumns.put("jo_bal_amt", getJoBalAmt());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("stl_rmk", getStlRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("jo_hjs_amt", "joHjsAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jo_ltr_stl_seq", "joLtrStlSeq");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("jo_ltr_seq", "joLtrSeq");
		this.hashFields.put("jo_prnr_amt", "joPrnrAmt");
		this.hashFields.put("jo_bal_amt", "joBalAmt");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stl_rmk", "stlRmk");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return joHjsAmt
	 */
	public String getJoHjsAmt() {
		return this.joHjsAmt;
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
	 * @return joLtrStlSeq
	 */
	public String getJoLtrStlSeq() {
		return this.joLtrStlSeq;
	}
	
	/**
	 * Column Info
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
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
	 * @return joLtrSeq
	 */
	public String getJoLtrSeq() {
		return this.joLtrSeq;
	}
	
	/**
	 * Column Info
	 * @return joPrnrAmt
	 */
	public String getJoPrnrAmt() {
		return this.joPrnrAmt;
	}
	
	/**
	 * Column Info
	 * @return joBalAmt
	 */
	public String getJoBalAmt() {
		return this.joBalAmt;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
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
	 * @return stlRmk
	 */
	public String getStlRmk() {
		return this.stlRmk;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param joHjsAmt
	 */
	public void setJoHjsAmt(String joHjsAmt) {
		this.joHjsAmt = joHjsAmt;
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
	 * @param joLtrStlSeq
	 */
	public void setJoLtrStlSeq(String joLtrStlSeq) {
		this.joLtrStlSeq = joLtrStlSeq;
	}
	
	/**
	 * Column Info
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
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
	 * @param joLtrSeq
	 */
	public void setJoLtrSeq(String joLtrSeq) {
		this.joLtrSeq = joLtrSeq;
	}
	
	/**
	 * Column Info
	 * @param joPrnrAmt
	 */
	public void setJoPrnrAmt(String joPrnrAmt) {
		this.joPrnrAmt = joPrnrAmt;
	}
	
	/**
	 * Column Info
	 * @param joBalAmt
	 */
	public void setJoBalAmt(String joBalAmt) {
		this.joBalAmt = joBalAmt;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
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
	 * @param stlRmk
	 */
	public void setStlRmk(String stlRmk) {
		this.stlRmk = stlRmk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setTtlAmt(JSPUtil.getParameter(request, "ttl_amt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setJoHjsAmt(JSPUtil.getParameter(request, "jo_hjs_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setJoLtrStlSeq(JSPUtil.getParameter(request, "jo_ltr_stl_seq", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setJoLtrSeq(JSPUtil.getParameter(request, "jo_ltr_seq", ""));
		setJoPrnrAmt(JSPUtil.getParameter(request, "jo_prnr_amt", ""));
		setJoBalAmt(JSPUtil.getParameter(request, "jo_bal_amt", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setStlRmk(JSPUtil.getParameter(request, "stl_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JooLtrStlVO[]
	 */
	public JooLtrStlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JooLtrStlVO[]
	 */
	public JooLtrStlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JooLtrStlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] joHjsAmt = (JSPUtil.getParameter(request, prefix	+ "jo_hjs_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] joLtrStlSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_stl_seq", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] joLtrSeq = (JSPUtil.getParameter(request, prefix	+ "jo_ltr_seq", length));
			String[] joPrnrAmt = (JSPUtil.getParameter(request, prefix	+ "jo_prnr_amt", length));
			String[] joBalAmt = (JSPUtil.getParameter(request, prefix	+ "jo_bal_amt", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] stlRmk = (JSPUtil.getParameter(request, prefix	+ "stl_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new JooLtrStlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (joHjsAmt[i] != null)
					model.setJoHjsAmt(joHjsAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (joLtrStlSeq[i] != null)
					model.setJoLtrStlSeq(joLtrStlSeq[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (joLtrSeq[i] != null)
					model.setJoLtrSeq(joLtrSeq[i]);
				if (joPrnrAmt[i] != null)
					model.setJoPrnrAmt(joPrnrAmt[i]);
				if (joBalAmt[i] != null)
					model.setJoBalAmt(joBalAmt[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (stlRmk[i] != null)
					model.setStlRmk(stlRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJooLtrStlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JooLtrStlVO[]
	 */
	public JooLtrStlVO[] getJooLtrStlVOs(){
		JooLtrStlVO[] vos = (JooLtrStlVO[])models.toArray(new JooLtrStlVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joHjsAmt = this.joHjsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrStlSeq = this.joLtrStlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joLtrSeq = this.joLtrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joPrnrAmt = this.joPrnrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBalAmt = this.joBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlRmk = this.stlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
