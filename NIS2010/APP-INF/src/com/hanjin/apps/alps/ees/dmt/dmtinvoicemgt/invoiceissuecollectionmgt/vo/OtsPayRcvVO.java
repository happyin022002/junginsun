/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OtsPayRcvVO.java
*@FileTitle : OtsPayRcvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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

public class OtsPayRcvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsPayRcvVO> models = new ArrayList<OtsPayRcvVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invPayAmt = null;
	/* Column Info */
	private String dmdtInvNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eaiIfId = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtInvPayTpCd = null;
	/* Column Info */
	private String invPayDt = null;
	/* Column Info */
	private String invPayCoffDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String invPayOfcCd = null;
	/* Column Info */
	private String invOtsPaySeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String invBalAmt = null;
	/* Column Info */
	private String invPayRcvSeq = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OtsPayRcvVO() {}

	public OtsPayRcvVO(String ibflag, String pagerows, String dmdtInvNo, String invOtsPaySeq, String blNo, String dmdtInvPayTpCd, String ioBndCd, String invPayDt, String invPayAmt, String invCurrCd, String invPayCoffDt, String creUsrId, String creDt, String updUsrId, String updDt, String invPayOfcCd, String eaiIfId, String bkgNo, String invBalAmt, String invPayRcvSeq) {
		this.updDt = updDt;
		this.invPayAmt = invPayAmt;
		this.dmdtInvNo = dmdtInvNo;
		this.creDt = creDt;
		this.eaiIfId = eaiIfId;
		this.ioBndCd = ioBndCd;
		this.invCurrCd = invCurrCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.dmdtInvPayTpCd = dmdtInvPayTpCd;
		this.invPayDt = invPayDt;
		this.invPayCoffDt = invPayCoffDt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.invPayOfcCd = invPayOfcCd;
		this.invOtsPaySeq = invOtsPaySeq;
		this.updUsrId = updUsrId;
		this.bkgNo = bkgNo;
		this.invBalAmt = invBalAmt;
		this.invPayRcvSeq = invPayRcvSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_pay_amt", getInvPayAmt());
		this.hashColumns.put("dmdt_inv_no", getDmdtInvNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_inv_pay_tp_cd", getDmdtInvPayTpCd());
		this.hashColumns.put("inv_pay_dt", getInvPayDt());
		this.hashColumns.put("inv_pay_coff_dt", getInvPayCoffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inv_pay_ofc_cd", getInvPayOfcCd());
		this.hashColumns.put("inv_ots_pay_seq", getInvOtsPaySeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("inv_bal_amt", getInvBalAmt());
		this.hashColumns.put("inv_pay_rcv_seq", getInvPayRcvSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_pay_amt", "invPayAmt");
		this.hashFields.put("dmdt_inv_no", "dmdtInvNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_inv_pay_tp_cd", "dmdtInvPayTpCd");
		this.hashFields.put("inv_pay_dt", "invPayDt");
		this.hashFields.put("inv_pay_coff_dt", "invPayCoffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inv_pay_ofc_cd", "invPayOfcCd");
		this.hashFields.put("inv_ots_pay_seq", "invOtsPaySeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_no", "updUsrId");
		this.hashFields.put("inv_bal_amt", "bkgNo");
		this.hashFields.put("inv_pay_rcv_seq", "invBalAmt");
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
	 * @return invPayAmt
	 */
	public String getInvPayAmt() {
		return this.invPayAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtInvNo
	 */
	public String getDmdtInvNo() {
		return this.dmdtInvNo;
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
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
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
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return dmdtInvPayTpCd
	 */
	public String getDmdtInvPayTpCd() {
		return this.dmdtInvPayTpCd;
	}
	
	/**
	 * Column Info
	 * @return invPayDt
	 */
	public String getInvPayDt() {
		return this.invPayDt;
	}
	
	/**
	 * Column Info
	 * @return invPayCoffDt
	 */
	public String getInvPayCoffDt() {
		return this.invPayCoffDt;
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
	 * @return invPayOfcCd
	 */
	public String getInvPayOfcCd() {
		return this.invPayOfcCd;
	}
	
	/**
	 * Column Info
	 * @return invOtsPaySeq
	 */
	public String getInvOtsPaySeq() {
		return this.invOtsPaySeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return invBalAmt
	 */
	public String getInvBalAmt() {
		return this.invBalAmt;
	}
	
	/**
	 * Column Info
	 * @return invPayRcvSeq
	 */
	public String getInvPayRcvSeq() {
		return this.invPayRcvSeq;
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
	 * @param invPayAmt
	 */
	public void setInvPayAmt(String invPayAmt) {
		this.invPayAmt = invPayAmt;
	}
	
	/**
	 * Column Info
	 * @param dmdtInvNo
	 */
	public void setDmdtInvNo(String dmdtInvNo) {
		this.dmdtInvNo = dmdtInvNo;
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
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
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
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param dmdtInvPayTpCd
	 */
	public void setDmdtInvPayTpCd(String dmdtInvPayTpCd) {
		this.dmdtInvPayTpCd = dmdtInvPayTpCd;
	}
	
	/**
	 * Column Info
	 * @param invPayDt
	 */
	public void setInvPayDt(String invPayDt) {
		this.invPayDt = invPayDt;
	}
	
	/**
	 * Column Info
	 * @param invPayCoffDt
	 */
	public void setInvPayCoffDt(String invPayCoffDt) {
		this.invPayCoffDt = invPayCoffDt;
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
	 * @param invPayOfcCd
	 */
	public void setInvPayOfcCd(String invPayOfcCd) {
		this.invPayOfcCd = invPayOfcCd;
	}
	
	/**
	 * Column Info
	 * @param invOtsPaySeq
	 */
	public void setInvOtsPaySeq(String invOtsPaySeq) {
		this.invOtsPaySeq = invOtsPaySeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param invBalAmt
	 */
	public void setInvBalAmt(String invBalAmt) {
		this.invBalAmt = invBalAmt;
	}
	
	/**
	 * Column Info
	 * @param invPayRcvSeq
	 */
	public void setInvPayRcvSeq(String invPayRcvSeq) {
		this.invPayRcvSeq = invPayRcvSeq;
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
		setInvPayAmt(JSPUtil.getParameter(request, prefix + "inv_pay_amt", ""));
		setDmdtInvNo(JSPUtil.getParameter(request, prefix + "dmdt_inv_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDmdtInvPayTpCd(JSPUtil.getParameter(request, prefix + "dmdt_inv_pay_tp_cd", ""));
		setInvPayDt(JSPUtil.getParameter(request, prefix + "inv_pay_dt", ""));
		setInvPayCoffDt(JSPUtil.getParameter(request, prefix + "inv_pay_coff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInvPayOfcCd(JSPUtil.getParameter(request, prefix + "inv_pay_ofc_cd", ""));
		setInvOtsPaySeq(JSPUtil.getParameter(request, prefix + "inv_ots_pay_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setInvBalAmt(JSPUtil.getParameter(request, prefix + "inv_bal_amt", ""));
		setInvPayRcvSeq(JSPUtil.getParameter(request, prefix + "inv_pay_rcv_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsPayRcvVO[]
	 */
	public OtsPayRcvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsPayRcvVO[]
	 */
	public OtsPayRcvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsPayRcvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invPayAmt = (JSPUtil.getParameter(request, prefix	+ "inv_pay_amt", length));
			String[] dmdtInvNo = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtInvPayTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_inv_pay_tp_cd", length));
			String[] invPayDt = (JSPUtil.getParameter(request, prefix	+ "inv_pay_dt", length));
			String[] invPayCoffDt = (JSPUtil.getParameter(request, prefix	+ "inv_pay_coff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] invPayOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_pay_ofc_cd", length));
			String[] invOtsPaySeq = (JSPUtil.getParameter(request, prefix	+ "inv_ots_pay_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] invBalAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bal_amt", length));
			String[] invPayRcvSeq = (JSPUtil.getParameter(request, prefix	+ "inv_pay_rcv_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsPayRcvVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invPayAmt[i] != null)
					model.setInvPayAmt(invPayAmt[i]);
				if (dmdtInvNo[i] != null)
					model.setDmdtInvNo(dmdtInvNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtInvPayTpCd[i] != null)
					model.setDmdtInvPayTpCd(dmdtInvPayTpCd[i]);
				if (invPayDt[i] != null)
					model.setInvPayDt(invPayDt[i]);
				if (invPayCoffDt[i] != null)
					model.setInvPayCoffDt(invPayCoffDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (invPayOfcCd[i] != null)
					model.setInvPayOfcCd(invPayOfcCd[i]);
				if (invOtsPaySeq[i] != null)
					model.setInvOtsPaySeq(invOtsPaySeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (invBalAmt[i] != null)
					model.setInvBalAmt(invBalAmt[i]);				
				if (invPayRcvSeq[i] != null)
					model.setInvPayRcvSeq(invPayRcvSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsPayRcvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsPayRcvVO[]
	 */
	public OtsPayRcvVO[] getOtsPayRcvVOs(){
		OtsPayRcvVO[] vos = (OtsPayRcvVO[])models.toArray(new OtsPayRcvVO[models.size()]);
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
		this.invPayAmt = this.invPayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvNo = this.dmdtInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvPayTpCd = this.dmdtInvPayTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayDt = this.invPayDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayCoffDt = this.invPayCoffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayOfcCd = this.invPayOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOtsPaySeq = this.invOtsPaySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBalAmt = this.invBalAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPayRcvSeq = this.invPayRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
