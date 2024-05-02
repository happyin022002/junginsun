/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceIssueDateVO.java
*@FileTitle : ARInvoiceIssueDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.03.15 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceIssueDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceIssueDateVO> models = new ArrayList<ARInvoiceIssueDateVO>();
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String localTotal = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String creUsrId1 = null;
	/* Column Info */
	private String creUsrId2 = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String dpPrcsKntLocal = null;
	/* Column Info */
	private String invXchRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceIssueDateVO() {}

	public ARInvoiceIssueDateVO(String ibflag, String pagerows, String issDt, String arOfcCd, String ioBndCd, String blSrcNo, String vvd, String custCd, String currCd, String invXchRt, String creUsrId1, String invNo, String revTpCd, String arIfNo, String sailArrDt, String polCd, String podCd, String chgAmt, String localTotal, String creUsrId2, String dpPrcsKnt, String dpPrcsKntLocal) {
		this.blSrcNo = blSrcNo;
		this.localTotal = localTotal;
		this.currCd = currCd;
		this.ioBndCd = ioBndCd;
		this.creUsrId1 = creUsrId1;
		this.creUsrId2 = creUsrId2;
		this.sailArrDt = sailArrDt;
		this.revTpCd = revTpCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.podCd = podCd;
		this.vvd = vvd;
		this.invNo = invNo;
		this.issDt = issDt;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.arIfNo = arIfNo;
		this.custCd = custCd;
		this.chgAmt = chgAmt;
		this.dpPrcsKntLocal = dpPrcsKntLocal;
		this.invXchRt = invXchRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("local_total", getLocalTotal());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cre_usr_id1", getCreUsrId1());
		this.hashColumns.put("cre_usr_id2", getCreUsrId2());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("dp_prcs_knt_local", getDpPrcsKntLocal());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("local_total", "localTotal");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cre_usr_id1", "creUsrId1");
		this.hashFields.put("cre_usr_id2", "creUsrId2");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("dp_prcs_knt_local", "dpPrcsKntLocal");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return localTotal
	 */
	public String getLocalTotal() {
		return this.localTotal;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId1
	 */
	public String getCreUsrId1() {
		return this.creUsrId1;
	}
	
	/**
	 * Column Info
	 * @return creUsrId2
	 */
	public String getCreUsrId2() {
		return this.creUsrId2;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKntLocal
	 */
	public String getDpPrcsKntLocal() {
		return this.dpPrcsKntLocal;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	

	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param localTotal
	 */
	public void setLocalTotal(String localTotal) {
		this.localTotal = localTotal;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId1
	 */
	public void setCreUsrId1(String creUsrId1) {
		this.creUsrId1 = creUsrId1;
	}
	
	/**
	 * Column Info
	 * @param creUsrId2
	 */
	public void setCreUsrId2(String creUsrId2) {
		this.creUsrId2 = creUsrId2;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param dpPrcsKntLocal
	 */
	public void setDpPrcsKntLocal(String dpPrcsKntLocal) {
		this.dpPrcsKntLocal = dpPrcsKntLocal;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
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
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setLocalTotal(JSPUtil.getParameter(request, prefix + "local_total", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setCreUsrId1(JSPUtil.getParameter(request, prefix + "cre_usr_id1", ""));
		setCreUsrId2(JSPUtil.getParameter(request, prefix + "cre_usr_id2", ""));
		setSailArrDt(JSPUtil.getParameter(request, prefix + "sail_arr_dt", ""));
		setRevTpCd(JSPUtil.getParameter(request, prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIssDt(JSPUtil.getParameter(request, prefix + "iss_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setDpPrcsKntLocal(JSPUtil.getParameter(request, prefix + "dp_prcs_knt_local", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceIssueDateVO[]
	 */
	public ARInvoiceIssueDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceIssueDateVO[]
	 */
	public ARInvoiceIssueDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceIssueDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] localTotal = (JSPUtil.getParameter(request, prefix	+ "local_total", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] creUsrId1 = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id1", length));
			String[] creUsrId2 = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id2", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] dpPrcsKntLocal = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt_local", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceIssueDateVO();
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (localTotal[i] != null)
					model.setLocalTotal(localTotal[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (creUsrId1[i] != null)
					model.setCreUsrId1(creUsrId1[i]);
				if (creUsrId2[i] != null)
					model.setCreUsrId2(creUsrId2[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (dpPrcsKntLocal[i] != null)
					model.setDpPrcsKntLocal(dpPrcsKntLocal[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceIssueDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceIssueDateVO[]
	 */
	public ARInvoiceIssueDateVO[] getARInvoiceIssueDateVOs(){
		ARInvoiceIssueDateVO[] vos = (ARInvoiceIssueDateVO[])models.toArray(new ARInvoiceIssueDateVO[models.size()]);
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
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTotal = this.localTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId1 = this.creUsrId1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId2 = this.creUsrId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKntLocal = this.dpPrcsKntLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
