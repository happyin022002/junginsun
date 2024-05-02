/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EasPayrCntcPntVO.java
*@FileTitle : EasPayrCntcPntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.11
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.11 KIM HYUN HWA 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EasPayrCntcPntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EasPayrCntcPntVO> models = new ArrayList<EasPayrCntcPntVO>();
	
	/* Column Info */
	private String custCntcPntSeq = null;
	/* Column Info */
	private String cntcPntEml = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String payrCntcPntNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntcPntNm = null;
	/* Column Info */
	private String cntcPntFaxNo = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String cntcPntPhnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EasPayrCntcPntVO() {}

	public EasPayrCntcPntVO(String ibflag, String pagerows, String svrId, String custCntCd, String custSeq, String custCd, String custCntcPntSeq, String cntcPntNm, String payrCntcPntNm, String cntcPntPhnNo, String cntcPntFaxNo, String cntcPntEml, String creUsrId, String creOfcCd, String updUsrId, String updOfcCd) {
		this.custCntcPntSeq = custCntcPntSeq;
		this.cntcPntEml = cntcPntEml;
		this.custSeq = custSeq;
		this.payrCntcPntNm = payrCntcPntNm;
		this.pagerows = pagerows;
		this.cntcPntNm = cntcPntNm;
		this.cntcPntFaxNo = cntcPntFaxNo;
		this.svrId = svrId;
		this.cntcPntPhnNo = cntcPntPhnNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.custCd = custCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
		this.hashColumns.put("cntc_pnt_eml", getCntcPntEml());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("payr_cntc_pnt_nm", getPayrCntcPntNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntc_pnt_nm", getCntcPntNm());
		this.hashColumns.put("cntc_pnt_fax_no", getCntcPntFaxNo());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cntc_pnt_phn_no", getCntcPntPhnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
		this.hashFields.put("cntc_pnt_eml", "cntcPntEml");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("payr_cntc_pnt_nm", "payrCntcPntNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntc_pnt_nm", "cntcPntNm");
		this.hashFields.put("cntc_pnt_fax_no", "cntcPntFaxNo");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cntc_pnt_phn_no", "cntcPntPhnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
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
	 * @return cntcPntEml
	 */
	public String getCntcPntEml() {
		return this.cntcPntEml;
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
	 * @return payrCntcPntNm
	 */
	public String getPayrCntcPntNm() {
		return this.payrCntcPntNm;
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
	 * @return cntcPntNm
	 */
	public String getCntcPntNm() {
		return this.cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @return cntcPntFaxNo
	 */
	public String getCntcPntFaxNo() {
		return this.cntcPntFaxNo;
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
	 * @return cntcPntPhnNo
	 */
	public String getCntcPntPhnNo() {
		return this.cntcPntPhnNo;
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
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @param cntcPntEml
	 */
	public void setCntcPntEml(String cntcPntEml) {
		this.cntcPntEml = cntcPntEml;
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
	 * @param payrCntcPntNm
	 */
	public void setPayrCntcPntNm(String payrCntcPntNm) {
		this.payrCntcPntNm = payrCntcPntNm;
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
	 * @param cntcPntNm
	 */
	public void setCntcPntNm(String cntcPntNm) {
		this.cntcPntNm = cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @param cntcPntFaxNo
	 */
	public void setCntcPntFaxNo(String cntcPntFaxNo) {
		this.cntcPntFaxNo = cntcPntFaxNo;
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
	 * @param cntcPntPhnNo
	 */
	public void setCntcPntPhnNo(String cntcPntPhnNo) {
		this.cntcPntPhnNo = cntcPntPhnNo;
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
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustCntcPntSeq(JSPUtil.getParameter(request, "cust_cntc_pnt_seq", ""));
		setCntcPntEml(JSPUtil.getParameter(request, "cntc_pnt_eml", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setPayrCntcPntNm(JSPUtil.getParameter(request, "payr_cntc_pnt_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntcPntNm(JSPUtil.getParameter(request, "cntc_pnt_nm", ""));
		setCntcPntFaxNo(JSPUtil.getParameter(request, "cntc_pnt_fax_no", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setCntcPntPhnNo(JSPUtil.getParameter(request, "cntc_pnt_phn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EasPayrCntcPntVO[]
	 */
	public EasPayrCntcPntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EasPayrCntcPntVO[]
	 */
	public EasPayrCntcPntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EasPayrCntcPntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_seq", length));
			String[] cntcPntEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_eml", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] payrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "payr_cntc_pnt_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntcPntNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_nm", length));
			String[] cntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_fax_no", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] cntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_phn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EasPayrCntcPntVO();
				if (custCntcPntSeq[i] != null)
					model.setCustCntcPntSeq(custCntcPntSeq[i]);
				if (cntcPntEml[i] != null)
					model.setCntcPntEml(cntcPntEml[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (payrCntcPntNm[i] != null)
					model.setPayrCntcPntNm(payrCntcPntNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntcPntNm[i] != null)
					model.setCntcPntNm(cntcPntNm[i]);
				if (cntcPntFaxNo[i] != null)
					model.setCntcPntFaxNo(cntcPntFaxNo[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (cntcPntPhnNo[i] != null)
					model.setCntcPntPhnNo(cntcPntPhnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEasPayrCntcPntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EasPayrCntcPntVO[]
	 */
	public EasPayrCntcPntVO[] getEasPayrCntcPntVOs(){
		EasPayrCntcPntVO[] vos = (EasPayrCntcPntVO[])models.toArray(new EasPayrCntcPntVO[models.size()]);
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
		this.custCntcPntSeq = this.custCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntEml = this.cntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCntcPntNm = this.payrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntNm = this.cntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntFaxNo = this.cntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntPhnNo = this.cntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
