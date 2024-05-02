/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JooComActualCarrierVO.java
*@FileTitle : JooComActualCarrierVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo;

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
public class JooComActualCarrierVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JooComActualCarrierVO> models = new ArrayList<JooComActualCarrierVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String joCrrCd = null;

	/* Column Info */
	private String vndrSeq = null;

	/* Column Info */
	private String vndrLglEngNm = null;

	/* Column Info */
	private String custCntCd = null;

	/* Column Info */
	private String custSeq = null;

	/* Column Info */
	private String custCd = null;

	/* Column Info */
	private String custLglEngNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public JooComActualCarrierVO() {}

	public JooComActualCarrierVO(String ibflag, String pagerows, String joCrrCd, String vndrSeq, String vndrLglEngNm, String custCntCd, String custSeq, String custCd, String custLglEngNm) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.joCrrCd = joCrrCd;
		this.vndrSeq = vndrSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.custCd = custCd;
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
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
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
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
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JooComActualCarrierVO[]
	 */
	public JooComActualCarrierVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JooComActualCarrierVO[]
	 */
	public JooComActualCarrierVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JooComActualCarrierVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new JooComActualCarrierVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (joCrrCd[i] != null) 
					model.setJoCrrCd(joCrrCd[i]);
				if (vndrSeq[i] != null) 
					model.setVndrSeq(vndrSeq[i]);
				if (vndrLglEngNm[i] != null) 
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (custCntCd[i] != null) 
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null) 
					model.setCustSeq(custSeq[i]);
				if (custCd[i] != null) 
					model.setCustCd(custCd[i]);
				if (custLglEngNm[i] != null) 
					model.setCustLglEngNm(custLglEngNm[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJooComActualCarrierVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JooComActualCarrierVO[]
	 */
	public JooComActualCarrierVO[] getJooComActualCarrierVOs(){
		JooComActualCarrierVO[] vos = (JooComActualCarrierVO[])models.toArray(new JooComActualCarrierVO[models.size()]);
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
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}