/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RptItmStupVO.java
*@FileTitle : RptItmStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RptItmStupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RptItmStupVO> models = new ArrayList<RptItmStupVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String portCoffFlg = null;
	/* Column Info */
	private String mtyPkupYdFlg = null;
	/* Column Info */
	private String callSgnFlg = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String railRcvFlg = null;
	/* Column Info */
	private String xchRtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String itmSeq = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String rctNtcRmk = null;
	/* Column Info */
	private String crnFlg = null;
	/* Column Info */
	private String docCoffFlg = null;
	/* Column Info */
	private String custCoffFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mrnFlg = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String fullRtnYdFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RptItmStupVO() {}

	public RptItmStupVO(String ibflag, String pagerows, String itmSeq, String bkgOfcCd, String custCd, String custCntCd, String custSeq, String mtyPkupYdFlg, String fullRtnYdFlg, String portCoffFlg, String railRcvFlg, String docCoffFlg, String custCoffFlg, String callSgnFlg, String mrnFlg, String crnFlg, String xchRtFlg, String diffRmk, String rctNtcRmk, String creUsrId, String updUsrId) {
		this.bkgOfcCd = bkgOfcCd;
		this.portCoffFlg = portCoffFlg;
		this.mtyPkupYdFlg = mtyPkupYdFlg;
		this.callSgnFlg = callSgnFlg;
		this.custSeq = custSeq;
		this.railRcvFlg = railRcvFlg;
		this.xchRtFlg = xchRtFlg;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.itmSeq = itmSeq;
		this.custCd = custCd;
		this.rctNtcRmk = rctNtcRmk;
		this.crnFlg = crnFlg;
		this.docCoffFlg = docCoffFlg;
		this.custCoffFlg = custCoffFlg;
		this.updUsrId = updUsrId;
		this.mrnFlg = mrnFlg;
		this.custCntCd = custCntCd;
		this.fullRtnYdFlg = fullRtnYdFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("port_coff_flg", getPortCoffFlg());
		this.hashColumns.put("mty_pkup_yd_flg", getMtyPkupYdFlg());
		this.hashColumns.put("call_sgn_flg", getCallSgnFlg());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("rail_rcv_flg", getRailRcvFlg());
		this.hashColumns.put("xch_rt_flg", getXchRtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("itm_seq", getItmSeq());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("rct_ntc_rmk", getRctNtcRmk());
		this.hashColumns.put("crn_flg", getCrnFlg());
		this.hashColumns.put("doc_coff_flg", getDocCoffFlg());
		this.hashColumns.put("cust_coff_flg", getCustCoffFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mrn_flg", getMrnFlg());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("full_rtn_yd_flg", getFullRtnYdFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("port_coff_flg", "portCoffFlg");
		this.hashFields.put("mty_pkup_yd_flg", "mtyPkupYdFlg");
		this.hashFields.put("call_sgn_flg", "callSgnFlg");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("rail_rcv_flg", "railRcvFlg");
		this.hashFields.put("xch_rt_flg", "xchRtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("itm_seq", "itmSeq");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("rct_ntc_rmk", "rctNtcRmk");
		this.hashFields.put("crn_flg", "crnFlg");
		this.hashFields.put("doc_coff_flg", "docCoffFlg");
		this.hashFields.put("cust_coff_flg", "custCoffFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mrn_flg", "mrnFlg");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("full_rtn_yd_flg", "fullRtnYdFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return portCoffFlg
	 */
	public String getPortCoffFlg() {
		return this.portCoffFlg;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdFlg
	 */
	public String getMtyPkupYdFlg() {
		return this.mtyPkupYdFlg;
	}
	
	/**
	 * Column Info
	 * @return callSgnFlg
	 */
	public String getCallSgnFlg() {
		return this.callSgnFlg;
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
	 * @return railRcvFlg
	 */
	public String getRailRcvFlg() {
		return this.railRcvFlg;
	}
	
	/**
	 * Column Info
	 * @return xchRtFlg
	 */
	public String getXchRtFlg() {
		return this.xchRtFlg;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return itmSeq
	 */
	public String getItmSeq() {
		return this.itmSeq;
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
	 * @return rctNtcRmk
	 */
	public String getRctNtcRmk() {
		return this.rctNtcRmk;
	}
	
	/**
	 * Column Info
	 * @return crnFlg
	 */
	public String getCrnFlg() {
		return this.crnFlg;
	}
	
	/**
	 * Column Info
	 * @return docCoffFlg
	 */
	public String getDocCoffFlg() {
		return this.docCoffFlg;
	}
	
	/**
	 * Column Info
	 * @return custCoffFlg
	 */
	public String getCustCoffFlg() {
		return this.custCoffFlg;
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
	 * @return mrnFlg
	 */
	public String getMrnFlg() {
		return this.mrnFlg;
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
	 * @return fullRtnYdFlg
	 */
	public String getFullRtnYdFlg() {
		return this.fullRtnYdFlg;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param portCoffFlg
	 */
	public void setPortCoffFlg(String portCoffFlg) {
		this.portCoffFlg = portCoffFlg;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdFlg
	 */
	public void setMtyPkupYdFlg(String mtyPkupYdFlg) {
		this.mtyPkupYdFlg = mtyPkupYdFlg;
	}
	
	/**
	 * Column Info
	 * @param callSgnFlg
	 */
	public void setCallSgnFlg(String callSgnFlg) {
		this.callSgnFlg = callSgnFlg;
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
	 * @param railRcvFlg
	 */
	public void setRailRcvFlg(String railRcvFlg) {
		this.railRcvFlg = railRcvFlg;
	}
	
	/**
	 * Column Info
	 * @param xchRtFlg
	 */
	public void setXchRtFlg(String xchRtFlg) {
		this.xchRtFlg = xchRtFlg;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param itmSeq
	 */
	public void setItmSeq(String itmSeq) {
		this.itmSeq = itmSeq;
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
	 * @param rctNtcRmk
	 */
	public void setRctNtcRmk(String rctNtcRmk) {
		this.rctNtcRmk = rctNtcRmk;
	}
	
	/**
	 * Column Info
	 * @param crnFlg
	 */
	public void setCrnFlg(String crnFlg) {
		this.crnFlg = crnFlg;
	}
	
	/**
	 * Column Info
	 * @param docCoffFlg
	 */
	public void setDocCoffFlg(String docCoffFlg) {
		this.docCoffFlg = docCoffFlg;
	}
	
	/**
	 * Column Info
	 * @param custCoffFlg
	 */
	public void setCustCoffFlg(String custCoffFlg) {
		this.custCoffFlg = custCoffFlg;
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
	 * @param mrnFlg
	 */
	public void setMrnFlg(String mrnFlg) {
		this.mrnFlg = mrnFlg;
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
	 * @param fullRtnYdFlg
	 */
	public void setFullRtnYdFlg(String fullRtnYdFlg) {
		this.fullRtnYdFlg = fullRtnYdFlg;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setPortCoffFlg(JSPUtil.getParameter(request, prefix + "port_coff_flg", ""));
		setMtyPkupYdFlg(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_flg", ""));
		setCallSgnFlg(JSPUtil.getParameter(request, prefix + "call_sgn_flg", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setRailRcvFlg(JSPUtil.getParameter(request, prefix + "rail_rcv_flg", ""));
		setXchRtFlg(JSPUtil.getParameter(request, prefix + "xch_rt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setItmSeq(JSPUtil.getParameter(request, prefix + "itm_seq", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setRctNtcRmk(JSPUtil.getParameter(request, prefix + "rct_ntc_rmk", ""));
		setCrnFlg(JSPUtil.getParameter(request, prefix + "crn_flg", ""));
		setDocCoffFlg(JSPUtil.getParameter(request, prefix + "doc_coff_flg", ""));
		setCustCoffFlg(JSPUtil.getParameter(request, prefix + "cust_coff_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMrnFlg(JSPUtil.getParameter(request, prefix + "mrn_flg", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setFullRtnYdFlg(JSPUtil.getParameter(request, prefix + "full_rtn_yd_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RptItmStupVO[]
	 */
	public RptItmStupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RptItmStupVO[]
	 */
	public RptItmStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RptItmStupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] portCoffFlg = (JSPUtil.getParameter(request, prefix	+ "port_coff_flg", length));
			String[] mtyPkupYdFlg = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_flg", length));
			String[] callSgnFlg = (JSPUtil.getParameter(request, prefix	+ "call_sgn_flg", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] railRcvFlg = (JSPUtil.getParameter(request, prefix	+ "rail_rcv_flg", length));
			String[] xchRtFlg = (JSPUtil.getParameter(request, prefix	+ "xch_rt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] itmSeq = (JSPUtil.getParameter(request, prefix	+ "itm_seq", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] rctNtcRmk = (JSPUtil.getParameter(request, prefix	+ "rct_ntc_rmk", length));
			String[] crnFlg = (JSPUtil.getParameter(request, prefix	+ "crn_flg", length));
			String[] docCoffFlg = (JSPUtil.getParameter(request, prefix	+ "doc_coff_flg", length));
			String[] custCoffFlg = (JSPUtil.getParameter(request, prefix	+ "cust_coff_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mrnFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_flg", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] fullRtnYdFlg = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RptItmStupVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (portCoffFlg[i] != null)
					model.setPortCoffFlg(portCoffFlg[i]);
				if (mtyPkupYdFlg[i] != null)
					model.setMtyPkupYdFlg(mtyPkupYdFlg[i]);
				if (callSgnFlg[i] != null)
					model.setCallSgnFlg(callSgnFlg[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (railRcvFlg[i] != null)
					model.setRailRcvFlg(railRcvFlg[i]);
				if (xchRtFlg[i] != null)
					model.setXchRtFlg(xchRtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (itmSeq[i] != null)
					model.setItmSeq(itmSeq[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (rctNtcRmk[i] != null)
					model.setRctNtcRmk(rctNtcRmk[i]);
				if (crnFlg[i] != null)
					model.setCrnFlg(crnFlg[i]);
				if (docCoffFlg[i] != null)
					model.setDocCoffFlg(docCoffFlg[i]);
				if (custCoffFlg[i] != null)
					model.setCustCoffFlg(custCoffFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mrnFlg[i] != null)
					model.setMrnFlg(mrnFlg[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (fullRtnYdFlg[i] != null)
					model.setFullRtnYdFlg(fullRtnYdFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRptItmStupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RptItmStupVO[]
	 */
	public RptItmStupVO[] getRptItmStupVOs(){
		RptItmStupVO[] vos = (RptItmStupVO[])models.toArray(new RptItmStupVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCoffFlg = this.portCoffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdFlg = this.mtyPkupYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnFlg = this.callSgnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRcvFlg = this.railRcvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtFlg = this.xchRtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmSeq = this.itmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNtcRmk = this.rctNtcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnFlg = this.crnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docCoffFlg = this.docCoffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCoffFlg = this.custCoffFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnFlg = this.mrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdFlg = this.fullRtnYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
