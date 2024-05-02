/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EdiSendTargetVO.java
*@FileTitle : EdiSendTargetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
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

public class EdiSendTargetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiSendTargetVO> models = new ArrayList<EdiSendTargetVO>();
	
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String ediHdrSeq = null;
	/* Column Info */
	private String ediTpCd = null;
	/* Column Info */
	private String invDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EdiSendTargetVO() {}

	public EdiSendTargetVO(String ibflag, String pagerows, String ediTpCd, String invNo, String arIfNo, String cntrNo, String ediHdrSeq, String actCustCntCd, String actCustSeq, String invDt) {
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.arIfNo = arIfNo;
		this.actCustSeq = actCustSeq;
		this.actCustCntCd = actCustCntCd;
		this.ediHdrSeq = ediHdrSeq;
		this.ediTpCd = ediTpCd;
		this.invDt = invDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("edi_hdr_seq", getEdiHdrSeq());
		this.hashColumns.put("edi_tp_cd", getEdiTpCd());
		this.hashColumns.put("inv_dt", getInvDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("edi_hdr_seq", "ediHdrSeq");
		this.hashFields.put("edi_tp_cd", "ediTpCd");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ediHdrSeq
	 */
	public String getEdiHdrSeq() {
		return this.ediHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return ediTpCd
	 */
	public String getEdiTpCd() {
		return this.ediTpCd;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ediHdrSeq
	 */
	public void setEdiHdrSeq(String ediHdrSeq) {
		this.ediHdrSeq = ediHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param ediTpCd
	 */
	public void setEdiTpCd(String ediTpCd) {
		this.ediTpCd = ediTpCd;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
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
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request, prefix + "act_cust_cnt_cd", ""));
		setEdiHdrSeq(JSPUtil.getParameter(request, prefix + "edi_hdr_seq", ""));
		setEdiTpCd(JSPUtil.getParameter(request, prefix + "edi_tp_cd", ""));
		setInvDt(JSPUtil.getParameter(request, prefix + "inv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiSendTargetVO[]
	 */
	public EdiSendTargetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiSendTargetVO[]
	 */
	public EdiSendTargetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiSendTargetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] ediHdrSeq = (JSPUtil.getParameter(request, prefix	+ "edi_hdr_seq", length));
			String[] ediTpCd = (JSPUtil.getParameter(request, prefix	+ "edi_tp_cd", length));
			String[] invDt = (JSPUtil.getParameter(request, prefix	+ "inv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiSendTargetVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (ediHdrSeq[i] != null)
					model.setEdiHdrSeq(ediHdrSeq[i]);
				if (ediTpCd[i] != null)
					model.setEdiTpCd(ediTpCd[i]);
				if (invDt[i] != null)
					model.setInvDt(invDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiSendTargetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiSendTargetVO[]
	 */
	public EdiSendTargetVO[] getEdiSendTargetVOs(){
		EdiSendTargetVO[] vos = (EdiSendTargetVO[])models.toArray(new EdiSendTargetVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHdrSeq = this.ediHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediTpCd = this.ediTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt = this.invDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
