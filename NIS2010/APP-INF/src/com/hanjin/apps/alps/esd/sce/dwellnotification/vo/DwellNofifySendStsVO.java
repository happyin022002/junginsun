/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNofifySendStsVO.java
*@FileTitle : DwellNofifySendStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

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

public class DwellNofifySendStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DwellNofifySendStsVO> models = new ArrayList<DwellNofifySendStsVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String d72Cnt = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String emlSndDtDesc = null;
	/* Column Info */
	private String e48Cnt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String t96Cnt = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String v24Cnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DwellNofifySendStsVO() {}

	public DwellNofifySendStsVO(String ibflag, String pagerows, String emlSndDt, String d72Cnt, String scNo, String e48Cnt, String t96Cnt, String v24Cnt, String emlSndDtDesc, String custCntCd, String custSeq, String custCd) {
		this.ibflag = ibflag;
		this.emlSndDt = emlSndDt;
		this.d72Cnt = d72Cnt;
		this.custCd = custCd;
		this.scNo = scNo;
		this.emlSndDtDesc = emlSndDtDesc;
		this.e48Cnt = e48Cnt;
		this.custSeq = custSeq;
		this.t96Cnt = t96Cnt;
		this.custCntCd = custCntCd;
		this.v24Cnt = v24Cnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("d72_cnt", getD72Cnt());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("eml_snd_dt_desc", getEmlSndDtDesc());
		this.hashColumns.put("e48_cnt", getE48Cnt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("t96_cnt", getT96Cnt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("v24_cnt", getV24Cnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("d72_cnt", "d72Cnt");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("eml_snd_dt_desc", "emlSndDtDesc");
		this.hashFields.put("e48_cnt", "e48Cnt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("t96_cnt", "t96Cnt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("v24_cnt", "v24Cnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return d72Cnt
	 */
	public String getD72Cnt() {
		return this.d72Cnt;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return emlSndDtDesc
	 */
	public String getEmlSndDtDesc() {
		return this.emlSndDtDesc;
	}
	
	/**
	 * Column Info
	 * @return e48Cnt
	 */
	public String getE48Cnt() {
		return this.e48Cnt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return t96Cnt
	 */
	public String getT96Cnt() {
		return this.t96Cnt;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return v24Cnt
	 */
	public String getV24Cnt() {
		return this.v24Cnt;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param d72Cnt
	 */
	public void setD72Cnt(String d72Cnt) {
		this.d72Cnt = d72Cnt;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param emlSndDtDesc
	 */
	public void setEmlSndDtDesc(String emlSndDtDesc) {
		this.emlSndDtDesc = emlSndDtDesc;
	}
	
	/**
	 * Column Info
	 * @param e48Cnt
	 */
	public void setE48Cnt(String e48Cnt) {
		this.e48Cnt = e48Cnt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param t96Cnt
	 */
	public void setT96Cnt(String t96Cnt) {
		this.t96Cnt = t96Cnt;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param v24Cnt
	 */
	public void setV24Cnt(String v24Cnt) {
		this.v24Cnt = v24Cnt;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setD72Cnt(JSPUtil.getParameter(request, prefix + "d72_cnt", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setEmlSndDtDesc(JSPUtil.getParameter(request, prefix + "eml_snd_dt_desc", ""));
		setE48Cnt(JSPUtil.getParameter(request, prefix + "e48_cnt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setT96Cnt(JSPUtil.getParameter(request, prefix + "t96_cnt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setV24Cnt(JSPUtil.getParameter(request, prefix + "v24_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DwellNofifySendStsVO[]
	 */
	public DwellNofifySendStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DwellNofifySendStsVO[]
	 */
	public DwellNofifySendStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DwellNofifySendStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] d72Cnt = (JSPUtil.getParameter(request, prefix	+ "d72_cnt", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] emlSndDtDesc = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt_desc", length));
			String[] e48Cnt = (JSPUtil.getParameter(request, prefix	+ "e48_cnt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] t96Cnt = (JSPUtil.getParameter(request, prefix	+ "t96_cnt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] v24Cnt = (JSPUtil.getParameter(request, prefix	+ "v24_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DwellNofifySendStsVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (d72Cnt[i] != null)
					model.setD72Cnt(d72Cnt[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (emlSndDtDesc[i] != null)
					model.setEmlSndDtDesc(emlSndDtDesc[i]);
				if (e48Cnt[i] != null)
					model.setE48Cnt(e48Cnt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (t96Cnt[i] != null)
					model.setT96Cnt(t96Cnt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (v24Cnt[i] != null)
					model.setV24Cnt(v24Cnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDwellNofifySendStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DwellNofifySendStsVO[]
	 */
	public DwellNofifySendStsVO[] getDwellNofifySendStsVOs(){
		DwellNofifySendStsVO[] vos = (DwellNofifySendStsVO[])models.toArray(new DwellNofifySendStsVO[models.size()]);
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
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d72Cnt = this.d72Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDtDesc = this.emlSndDtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.e48Cnt = this.e48Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t96Cnt = this.t96Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.v24Cnt = this.v24Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
