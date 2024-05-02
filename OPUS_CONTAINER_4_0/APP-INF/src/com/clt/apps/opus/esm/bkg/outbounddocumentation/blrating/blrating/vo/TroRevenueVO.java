/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TroRevenueVO.java
*@FileTitle : TroRevenueVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.02.18 이진서 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TroRevenueVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TroRevenueVO> models = new ArrayList<TroRevenueVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String haulageCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String payerCustSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String payerCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String chgCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TroRevenueVO() {}

	public TroRevenueVO(String ibflag, String pagerows, String payerCustSeq, String bkgNo, String creUsrId, String currCd, String rate, String cntrNo, String cltOfcCd, String haulageCd, String payerCntCd, String updUsrId, String ioBndCd, String cntrTpszCd, String chgCd) {
		this.currCd = currCd;
		this.cltOfcCd = cltOfcCd;
		this.haulageCd = haulageCd;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.payerCustSeq = payerCustSeq;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.rate = rate;
		this.cntrNo = cntrNo;
		this.payerCntCd = payerCntCd;
		this.updUsrId = updUsrId;
		this.cntrTpszCd = cntrTpszCd;
		this.chgCd = chgCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("haulage_cd", getHaulageCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("payer_cust_seq", getPayerCustSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("payer_cnt_cd", getPayerCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("chg_cd", getChgCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("haulage_cd", "haulageCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("payer_cust_seq", "payerCustSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("payer_cnt_cd", "payerCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("chg_cd", "chgCd");
		return this.hashFields;
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
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return haulageCd
	 */
	public String getHaulageCd() {
		return this.haulageCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return payerCustSeq
	 */
	public String getPayerCustSeq() {
		return this.payerCustSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
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
	 * @return payerCntCd
	 */
	public String getPayerCntCd() {
		return this.payerCntCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param haulageCd
	 */
	public void setHaulageCd(String haulageCd) {
		this.haulageCd = haulageCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param payerCustSeq
	 */
	public void setPayerCustSeq(String payerCustSeq) {
		this.payerCustSeq = payerCustSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
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
	 * @param payerCntCd
	 */
	public void setPayerCntCd(String payerCntCd) {
		this.payerCntCd = payerCntCd;
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
	 * @param updUsrId
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setHaulageCd(JSPUtil.getParameter(request, prefix + "haulage_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPayerCustSeq(JSPUtil.getParameter(request, prefix + "payer_cust_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPayerCntCd(JSPUtil.getParameter(request, prefix + "payer_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroRevenueVO[]
	 */
	public TroRevenueVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TroRevenueVO[]
	 */
	public TroRevenueVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TroRevenueVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] haulageCd = (JSPUtil.getParameter(request, prefix	+ "haulage_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] payerCustSeq = (JSPUtil.getParameter(request, prefix	+ "payer_cust_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] payerCntCd = (JSPUtil.getParameter(request, prefix	+ "payer_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TroRevenueVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (haulageCd[i] != null)
					model.setHaulageCd(haulageCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (payerCustSeq[i] != null)
					model.setPayerCustSeq(payerCustSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (payerCntCd[i] != null)
					model.setPayerCntCd(payerCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTroRevenueVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TroRevenueVO[]
	 */
	public TroRevenueVO[] getTroRevenueVOs(){
		TroRevenueVO[] vos = (TroRevenueVO[])models.toArray(new TroRevenueVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulageCd = this.haulageCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCustSeq = this.payerCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerCntCd = this.payerCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
