/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInvoicePoolChassisVO.java
*@FileTitle : SearchInvoicePoolChassisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.08.10 손은주(TRS) 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 손은주(TRS)
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchInvoicePoolChassisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInvoicePoolChassisVO> models = new ArrayList<SearchInvoicePoolChassisVO>();
	
	/* Column Info */
	private String paymtSpCd = null;
	/* Column Info */
	private String invTtlAmt = null;
	/* Column Info */
	private String invVatAmt = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String insflag = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String invRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String invBzcAmt = null;
	/* Column Info */
	private String poolChssCostYrmon = null;	
	/* Column Info */
	private String hiddenChssPoolCd = null;
	/* Column Info */
	private String rgstNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	
	public SearchInvoicePoolChassisVO() {}

	public SearchInvoicePoolChassisVO(String ibflag, String pagerows, String insflag, String invNo, String paymtSpCd, String usrId, String ofcCd, String invCurrCd, String invBzcAmt, String invTtlAmt, String invRcvDt, String invIssDt, String invVatAmt, String poolChssCostYrmon, String chssPoolCd, String hiddenChssPoolCd, String rgstNo) {
		this.paymtSpCd = paymtSpCd;
		this.invTtlAmt = invTtlAmt;
		this.invVatAmt = invVatAmt;
		this.chssPoolCd = chssPoolCd;
		this.insflag = insflag;
		this.invIssDt = invIssDt;
		this.invCurrCd = invCurrCd;
		this.invRcvDt = invRcvDt;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.invBzcAmt = invBzcAmt;
		this.poolChssCostYrmon = poolChssCostYrmon;
		this.hiddenChssPoolCd = hiddenChssPoolCd;
		this.rgstNo = rgstNo;
	}
	

	
	/**
	 * Column Info
	 * @return paymtSpCd
	 */
	public String getPaymtSpCd() {
		return this.paymtSpCd;
	}
	
	/**
	 * Column Info
	 * @return invTtlAmt
	 */
	public String getInvTtlAmt() {
		return this.invTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invVatAmt
	 */
	public String getInvVatAmt() {
		return this.invVatAmt;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return insflag
	 */
	public String getInsflag() {
		return this.insflag;
	}
	
	/**
	 * Column Info
	 * @return invIssDt
	 */
	public String getInvIssDt() {
		return this.invIssDt;
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
	 * @return invRcvDt
	 */
	public String getInvRcvDt() {
		return this.invRcvDt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return invBzcAmt
	 */
	public String getInvBzcAmt() {
		return this.invBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return poolChssCostYrmon
	 */
	public String getPoolChssCostYrmon() {
		return this.poolChssCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param hiddenChssPoolCd
	 */
	public String getHiddenChssPoolCd() {
		return this.hiddenChssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	

	/**
	 * Column Info
	 * @param paymtSpCd
	 */
	public void setPaymtSpCd(String paymtSpCd) {
		this.paymtSpCd = paymtSpCd;
	}
	
	/**
	 * Column Info
	 * @param invTtlAmt
	 */
	public void setInvTtlAmt(String invTtlAmt) {
		this.invTtlAmt = invTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invVatAmt
	 */
	public void setInvVatAmt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param insflag
	 */
	public void setInsflag(String insflag) {
		this.insflag = insflag;
	}
	
	/**
	 * Column Info
	 * @param invIssDt
	 */
	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
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
	 * @param invRcvDt
	 */
	public void setInvRcvDt(String invRcvDt) {
		this.invRcvDt = invRcvDt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param invBzcAmt
	 */
	public void setInvBzcAmt(String invBzcAmt) {
		this.invBzcAmt = invBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param poolChssCostYrmon
	 */
	public void setPoolChssCostYrmon(String poolChssCostYrmon) {
		this.poolChssCostYrmon = poolChssCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param hiddenChssPoolCd
	 */
	public void setHiddenChssPoolCd(String hiddenChssPoolCd) {
		this.hiddenChssPoolCd = hiddenChssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPaymtSpCd(JSPUtil.getParameter(request, "paymt_sp_cd", ""));
		setInvTtlAmt(JSPUtil.getParameter(request, "inv_ttl_amt", ""));
		setInvVatAmt(JSPUtil.getParameter(request, "inv_vat_amt", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setInsflag(JSPUtil.getParameter(request, "insflag", ""));
		setInvIssDt(JSPUtil.getParameter(request, "inv_iss_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, "inv_curr_cd", ""));
		setInvRcvDt(JSPUtil.getParameter(request, "inv_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setInvBzcAmt(JSPUtil.getParameter(request, "inv_bzc_amt", ""));
		setPoolChssCostYrmon(JSPUtil.getParameter(request, "pool_chss_cost_yrmon", ""));
		setHiddenChssPoolCd(JSPUtil.getParameter(request, "hidden_chss_pool_cd", ""));
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInvoicePoolChassisVO[]
	 */
	public SearchInvoicePoolChassisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInvoicePoolChassisVO[]
	 */
	public SearchInvoicePoolChassisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInvoicePoolChassisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] paymtSpCd = (JSPUtil.getParameter(request, prefix	+ "paymt_sp_cd", length));
			String[] invTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_amt", length));
			String[] invVatAmt = (JSPUtil.getParameter(request, prefix	+ "inv_vat_amt", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] insflag = (JSPUtil.getParameter(request, prefix	+ "insflag", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] invRcvDt = (JSPUtil.getParameter(request, prefix	+ "inv_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] invBzcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bzc_amt", length));
			String[] poolChssCostYrmon = (JSPUtil.getParameter(request, prefix	+ "pool_chss_cost_yrmon", length));
			String[] hiddenChssPoolCd = (JSPUtil.getParameter(request, prefix	+ "hidden_chss_pool_cd", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInvoicePoolChassisVO();
				if (paymtSpCd[i] != null)
					model.setPaymtSpCd(paymtSpCd[i]);
				if (invTtlAmt[i] != null)
					model.setInvTtlAmt(invTtlAmt[i]);
				if (invVatAmt[i] != null)
					model.setInvVatAmt(invVatAmt[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (insflag[i] != null)
					model.setInsflag(insflag[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (invRcvDt[i] != null)
					model.setInvRcvDt(invRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (invBzcAmt[i] != null)
					model.setInvBzcAmt(invBzcAmt[i]);
				if (poolChssCostYrmon[i] != null)
					model.setPoolChssCostYrmon(poolChssCostYrmon[i]);
				if (hiddenChssPoolCd[i] != null)
					model.setHiddenChssPoolCd(hiddenChssPoolCd[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInvoicePoolChassisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInvoicePoolChassisVO[]
	 */
	public SearchInvoicePoolChassisVO[] getSearchInvoicePoolChassisVOs(){
		SearchInvoicePoolChassisVO[] vos = (SearchInvoicePoolChassisVO[])models.toArray(new SearchInvoicePoolChassisVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.paymtSpCd = this.paymtSpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlAmt = this.invTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt = this.invVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insflag = this.insflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRcvDt = this.invRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBzcAmt = this.invBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolChssCostYrmon = this.poolChssCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenChssPoolCd = this.hiddenChssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("paymt_sp_cd",		getPaymtSpCd());
		this.hashColumns.put("inv_ttl_amt",		getInvTtlAmt());
		this.hashColumns.put("inv_vat_amt",		getInvVatAmt());
		this.hashColumns.put("chss_pool_cd",		getChssPoolCd());
		this.hashColumns.put("insflag",			getInsflag());
		this.hashColumns.put("inv_iss_dt",		getInvIssDt());
		this.hashColumns.put("inv_curr_cd",		getInvCurrCd());
		this.hashColumns.put("inv_rcv_dt",		getInvRcvDt());
		this.hashColumns.put("pagerows",		getPagerows());
		this.hashColumns.put("inv_no",			getInvNo());
		this.hashColumns.put("ofc_cd",			getOfcCd());
		this.hashColumns.put("ibflag",			getIbflag());
		this.hashColumns.put("usr_id",			getUsrId());
		this.hashColumns.put("inv_bzc_amt",		getInvBzcAmt());
		this.hashColumns.put("pool_chss_cost_yrmon",getPoolChssCostYrmon());
		this.hashColumns.put("hidden_chss_pool_cd",		getHiddenChssPoolCd());
		this.hashColumns.put("rgst_no",		getRgstNo());
		return this.hashColumns; 
	}

	

	@Override
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("paymt_sp_cd", "paymt_sp_cd");
		this.hashFields.put("inv_ttl_amt", "inv_ttl_amt");
		this.hashFields.put("inv_vat_amt", "inv_vat_amt");
		this.hashFields.put("chss_pool_cd", "chss_pool_cd");
		this.hashFields.put("insflag", "insflag");
		this.hashFields.put("inv_iss_dt", "inv_iss_dt");
		this.hashFields.put("inv_curr_cd", "inv_curr_cd");
		this.hashFields.put("inv_rcv_dt", "inv_rcv_dt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "inv_no");
		this.hashFields.put("ofc_cd", "ofc_cd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usr_id");
		this.hashFields.put("inv_bzc_amt", "inv_bzc_amt");
		this.hashFields.put("pool_chss_cost_yrmon", "pool_chss_cost_yrmon");
		return this.hashFields;
	}
}
