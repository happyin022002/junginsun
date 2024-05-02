/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AttentionVO.java
*@FileTitle : AttentionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.11.25 김태균 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AttentionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AttentionVO> models = new ArrayList<AttentionVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String custCntcPntSeq = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String payrCntcPntPhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String payrCntcPntEml = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String payrCntcPntFaxNo = null;
	/* Column Info */
	private String dmdtPayrCntcPntNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AttentionVO() {}

	public AttentionVO(String ibflag, String pagerows, String dmdtPayrCntcPntNm, String payrCntcPntPhnNo, String payrCntcPntFaxNo, String payrCntcPntEml, String svrId, String custCntCd, String custSeq, String custCntcPntSeq, String ofcCd) {
		this.ofcCd = ofcCd;
		this.custCntcPntSeq = custCntcPntSeq;
		this.svrId = svrId;
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
		this.ibflag = ibflag;
		this.payrCntcPntEml = payrCntcPntEml;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("payr_cntc_pnt_phn_no", getPayrCntcPntPhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("payr_cntc_pnt_eml", getPayrCntcPntEml());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("payr_cntc_pnt_fax_no", getPayrCntcPntFaxNo());
		this.hashColumns.put("dmdt_payr_cntc_pnt_nm", getDmdtPayrCntcPntNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("payr_cntc_pnt_phn_no", "payrCntcPntPhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("payr_cntc_pnt_eml", "payrCntcPntEml");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("payr_cntc_pnt_fax_no", "payrCntcPntFaxNo");
		this.hashFields.put("dmdt_payr_cntc_pnt_nm", "dmdtPayrCntcPntNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return custCntcPntSeq
	 */
	public String getCustCntcPntSeq() {
		return this.custCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return payrCntcPntPhnNo
	 */
	public String getPayrCntcPntPhnNo() {
		return this.payrCntcPntPhnNo;
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
	 * @return payrCntcPntEml
	 */
	public String getPayrCntcPntEml() {
		return this.payrCntcPntEml;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return payrCntcPntFaxNo
	 */
	public String getPayrCntcPntFaxNo() {
		return this.payrCntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtPayrCntcPntNm
	 */
	public String getDmdtPayrCntcPntNm() {
		return this.dmdtPayrCntcPntNm;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntcPntSeq
	 */
	public void setCustCntcPntSeq(String custCntcPntSeq) {
		this.custCntcPntSeq = custCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param payrCntcPntPhnNo
	 */
	public void setPayrCntcPntPhnNo(String payrCntcPntPhnNo) {
		this.payrCntcPntPhnNo = payrCntcPntPhnNo;
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
	 * @param payrCntcPntEml
	 */
	public void setPayrCntcPntEml(String payrCntcPntEml) {
		this.payrCntcPntEml = payrCntcPntEml;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param payrCntcPntFaxNo
	 */
	public void setPayrCntcPntFaxNo(String payrCntcPntFaxNo) {
		this.payrCntcPntFaxNo = payrCntcPntFaxNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtPayrCntcPntNm
	 */
	public void setDmdtPayrCntcPntNm(String dmdtPayrCntcPntNm) {
		this.dmdtPayrCntcPntNm = dmdtPayrCntcPntNm;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCustCntcPntSeq(JSPUtil.getParameter(request, "cust_cntc_pnt_seq", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setPayrCntcPntPhnNo(JSPUtil.getParameter(request, "payr_cntc_pnt_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPayrCntcPntEml(JSPUtil.getParameter(request, "payr_cntc_pnt_eml", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPayrCntcPntFaxNo(JSPUtil.getParameter(request, "payr_cntc_pnt_fax_no", ""));
		setDmdtPayrCntcPntNm(JSPUtil.getParameter(request, "dmdt_payr_cntc_pnt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AttentionVO[]
	 */
	public AttentionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AttentionVO[]
	 */
	public AttentionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AttentionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_seq", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] payrCntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] payrCntcPntEml = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_eml", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] payrCntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_fax_no", length));
			String[] dmdtPayrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_payr_cntc_pnt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AttentionVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (custCntcPntSeq[i] != null)
					model.setCustCntcPntSeq(custCntcPntSeq[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (payrCntcPntPhnNo[i] != null)
					model.setPayrCntcPntPhnNo(payrCntcPntPhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (payrCntcPntEml[i] != null)
					model.setPayrCntcPntEml(payrCntcPntEml[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (payrCntcPntFaxNo[i] != null)
					model.setPayrCntcPntFaxNo(payrCntcPntFaxNo[i]);
				if (dmdtPayrCntcPntNm[i] != null)
					model.setDmdtPayrCntcPntNm(dmdtPayrCntcPntNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAttentionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AttentionVO[]
	 */
	public AttentionVO[] getAttentionVOs(){
		AttentionVO[] vos = (AttentionVO[])models.toArray(new AttentionVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcPntSeq = this.custCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntPhnNo = this.payrCntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntEml = this.payrCntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntFaxNo = this.payrCntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtPayrCntcPntNm = this.dmdtPayrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
