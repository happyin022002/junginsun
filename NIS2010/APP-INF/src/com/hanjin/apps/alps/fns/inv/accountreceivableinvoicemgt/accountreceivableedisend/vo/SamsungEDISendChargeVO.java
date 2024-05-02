/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SamsungEDISendChargeVO.java
*@FileTitle : SamsungEDISendChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.14 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamsungEDISendChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamsungEDISendChargeVO> models = new ArrayList<SamsungEDISendChargeVO>();
	
	/* Column Info */
	private String taxCurCd = null;
	/* Column Info */
	private String blLineNoChg = null;
	/* Column Info */
	private String msgNoChg = null;
	/* Column Info */
	private String ratExRate = null;
	/* Column Info */
	private String reqCurCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String msgIdChg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chargeCd = null;
	/* Column Info */
	private String taxAmount = null;
	/* Column Info */
	private String ratExRateDate = null;
	/* Column Info */
	private String supAmount = null;
	/* Column Info */
	private String blSrcNoChg = null;
	/* Column Info */
	private String frtIssueDate = null;
	/* Column Info */
	private String supCurCd = null;
	/* Column Info */
	private String destCurCd = null;
	/* Column Info */
	private String basicCurCd = null;
	/* Column Info */
	private String reqAmount = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamsungEDISendChargeVO() {}

	public SamsungEDISendChargeVO(String ibflag, String pagerows, String chargeCd, String frtIssueDate, String reqAmount, String reqCurCd, String supAmount, String supCurCd, String taxAmount, String taxCurCd, String ratExRate, String basicCurCd, String destCurCd, String ratExRateDate, String msgIdChg, String msgNoChg, String blLineNoChg, String blSrcNoChg) {
		this.taxCurCd = taxCurCd;
		this.blLineNoChg = blLineNoChg;
		this.msgNoChg = msgNoChg;
		this.ratExRate = ratExRate;
		this.reqCurCd = reqCurCd;
		this.pagerows = pagerows;
		this.msgIdChg = msgIdChg;
		this.ibflag = ibflag;
		this.chargeCd = chargeCd;
		this.taxAmount = taxAmount;
		this.ratExRateDate = ratExRateDate;
		this.supAmount = supAmount;
		this.blSrcNoChg = blSrcNoChg;
		this.frtIssueDate = frtIssueDate;
		this.supCurCd = supCurCd;
		this.destCurCd = destCurCd;
		this.basicCurCd = basicCurCd;
		this.reqAmount = reqAmount;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tax_cur_cd", getTaxCurCd());
		this.hashColumns.put("bl_line_no_chg", getBlLineNoChg());
		this.hashColumns.put("msg_no_chg", getMsgNoChg());
		this.hashColumns.put("rat_ex_rate", getRatExRate());
		this.hashColumns.put("req_cur_cd", getReqCurCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("msg_id_chg", getMsgIdChg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("charge_cd", getChargeCd());
		this.hashColumns.put("tax_amount", getTaxAmount());
		this.hashColumns.put("rat_ex_rate_date", getRatExRateDate());
		this.hashColumns.put("sup_amount", getSupAmount());
		this.hashColumns.put("bl_src_no_chg", getBlSrcNoChg());
		this.hashColumns.put("frt_issue_date", getFrtIssueDate());
		this.hashColumns.put("sup_cur_cd", getSupCurCd());
		this.hashColumns.put("dest_cur_cd", getDestCurCd());
		this.hashColumns.put("basic_cur_cd", getBasicCurCd());
		this.hashColumns.put("req_amount", getReqAmount());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tax_cur_cd", "taxCurCd");
		this.hashFields.put("bl_line_no_chg", "blLineNoChg");
		this.hashFields.put("msg_no_chg", "msgNoChg");
		this.hashFields.put("rat_ex_rate", "ratExRate");
		this.hashFields.put("req_cur_cd", "reqCurCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("msg_id_chg", "msgIdChg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("charge_cd", "chargeCd");
		this.hashFields.put("tax_amount", "taxAmount");
		this.hashFields.put("rat_ex_rate_date", "ratExRateDate");
		this.hashFields.put("sup_amount", "supAmount");
		this.hashFields.put("bl_src_no_chg", "blSrcNoChg");
		this.hashFields.put("frt_issue_date", "frtIssueDate");
		this.hashFields.put("sup_cur_cd", "supCurCd");
		this.hashFields.put("dest_cur_cd", "destCurCd");
		this.hashFields.put("basic_cur_cd", "basicCurCd");
		this.hashFields.put("req_amount", "reqAmount");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return taxCurCd
	 */
	public String getTaxCurCd() {
		return this.taxCurCd;
	}
	
	/**
	 * Column Info
	 * @return blLineNoChg
	 */
	public String getBlLineNoChg() {
		return this.blLineNoChg;
	}
	
	/**
	 * Column Info
	 * @return msgNoChg
	 */
	public String getMsgNoChg() {
		return this.msgNoChg;
	}
	
	/**
	 * Column Info
	 * @return ratExRate
	 */
	public String getRatExRate() {
		return this.ratExRate;
	}
	
	/**
	 * Column Info
	 * @return reqCurCd
	 */
	public String getReqCurCd() {
		return this.reqCurCd;
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
	 * @return msgIdChg
	 */
	public String getMsgIdChg() {
		return this.msgIdChg;
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
	 * @return chargeCd
	 */
	public String getChargeCd() {
		return this.chargeCd;
	}
	
	/**
	 * Column Info
	 * @return taxAmount
	 */
	public String getTaxAmount() {
		return this.taxAmount;
	}
	
	/**
	 * Column Info
	 * @return ratExRateDate
	 */
	public String getRatExRateDate() {
		return this.ratExRateDate;
	}
	
	/**
	 * Column Info
	 * @return supAmount
	 */
	public String getSupAmount() {
		return this.supAmount;
	}
	
	/**
	 * Column Info
	 * @return blSrcNoChg
	 */
	public String getBlSrcNoChg() {
		return this.blSrcNoChg;
	}
	
	/**
	 * Column Info
	 * @return frtIssueDate
	 */
	public String getFrtIssueDate() {
		return this.frtIssueDate;
	}
	
	/**
	 * Column Info
	 * @return supCurCd
	 */
	public String getSupCurCd() {
		return this.supCurCd;
	}
	
	/**
	 * Column Info
	 * @return destCurCd
	 */
	public String getDestCurCd() {
		return this.destCurCd;
	}
	
	/**
	 * Column Info
	 * @return basicCurCd
	 */
	public String getBasicCurCd() {
		return this.basicCurCd;
	}
	
	/**
	 * Column Info
	 * @return reqAmount
	 */
	public String getReqAmount() {
		return this.reqAmount;
	}
	

	/**
	 * Column Info
	 * @param taxCurCd
	 */
	public void setTaxCurCd(String taxCurCd) {
		this.taxCurCd = taxCurCd;
	}
	
	/**
	 * Column Info
	 * @param blLineNoChg
	 */
	public void setBlLineNoChg(String blLineNoChg) {
		this.blLineNoChg = blLineNoChg;
	}
	
	/**
	 * Column Info
	 * @param msgNoChg
	 */
	public void setMsgNoChg(String msgNoChg) {
		this.msgNoChg = msgNoChg;
	}
	
	/**
	 * Column Info
	 * @param ratExRate
	 */
	public void setRatExRate(String ratExRate) {
		this.ratExRate = ratExRate;
	}
	
	/**
	 * Column Info
	 * @param reqCurCd
	 */
	public void setReqCurCd(String reqCurCd) {
		this.reqCurCd = reqCurCd;
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
	 * @param msgIdChg
	 */
	public void setMsgIdChg(String msgIdChg) {
		this.msgIdChg = msgIdChg;
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
	 * @param chargeCd
	 */
	public void setChargeCd(String chargeCd) {
		this.chargeCd = chargeCd;
	}
	
	/**
	 * Column Info
	 * @param taxAmount
	 */
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	/**
	 * Column Info
	 * @param ratExRateDate
	 */
	public void setRatExRateDate(String ratExRateDate) {
		this.ratExRateDate = ratExRateDate;
	}
	
	/**
	 * Column Info
	 * @param supAmount
	 */
	public void setSupAmount(String supAmount) {
		this.supAmount = supAmount;
	}
	
	/**
	 * Column Info
	 * @param blSrcNoChg
	 */
	public void setBlSrcNoChg(String blSrcNoChg) {
		this.blSrcNoChg = blSrcNoChg;
	}
	
	/**
	 * Column Info
	 * @param frtIssueDate
	 */
	public void setFrtIssueDate(String frtIssueDate) {
		this.frtIssueDate = frtIssueDate;
	}
	
	/**
	 * Column Info
	 * @param supCurCd
	 */
	public void setSupCurCd(String supCurCd) {
		this.supCurCd = supCurCd;
	}
	
	/**
	 * Column Info
	 * @param destCurCd
	 */
	public void setDestCurCd(String destCurCd) {
		this.destCurCd = destCurCd;
	}
	
	/**
	 * Column Info
	 * @param basicCurCd
	 */
	public void setBasicCurCd(String basicCurCd) {
		this.basicCurCd = basicCurCd;
	}
	
	/**
	 * Column Info
	 * @param reqAmount
	 */
	public void setReqAmount(String reqAmount) {
		this.reqAmount = reqAmount;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTaxCurCd(JSPUtil.getParameter(request, "tax_cur_cd", ""));
		setBlLineNoChg(JSPUtil.getParameter(request, "bl_line_no_chg", ""));
		setMsgNoChg(JSPUtil.getParameter(request, "msg_no_chg", ""));
		setRatExRate(JSPUtil.getParameter(request, "rat_ex_rate", ""));
		setReqCurCd(JSPUtil.getParameter(request, "req_cur_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMsgIdChg(JSPUtil.getParameter(request, "msg_id_chg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChargeCd(JSPUtil.getParameter(request, "charge_cd", ""));
		setTaxAmount(JSPUtil.getParameter(request, "tax_amount", ""));
		setRatExRateDate(JSPUtil.getParameter(request, "rat_ex_rate_date", ""));
		setSupAmount(JSPUtil.getParameter(request, "sup_amount", ""));
		setBlSrcNoChg(JSPUtil.getParameter(request, "bl_src_no_chg", ""));
		setFrtIssueDate(JSPUtil.getParameter(request, "frt_issue_date", ""));
		setSupCurCd(JSPUtil.getParameter(request, "sup_cur_cd", ""));
		setDestCurCd(JSPUtil.getParameter(request, "dest_cur_cd", ""));
		setBasicCurCd(JSPUtil.getParameter(request, "basic_cur_cd", ""));
		setReqAmount(JSPUtil.getParameter(request, "req_amount", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamsungEDISendChargeVO[]
	 */
	public SamsungEDISendChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamsungEDISendChargeVO[]
	 */
	public SamsungEDISendChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamsungEDISendChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] taxCurCd = (JSPUtil.getParameter(request, prefix	+ "tax_cur_cd", length));
			String[] blLineNoChg = (JSPUtil.getParameter(request, prefix	+ "bl_line_no_chg", length));
			String[] msgNoChg = (JSPUtil.getParameter(request, prefix	+ "msg_no_chg", length));
			String[] ratExRate = (JSPUtil.getParameter(request, prefix	+ "rat_ex_rate", length));
			String[] reqCurCd = (JSPUtil.getParameter(request, prefix	+ "req_cur_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] msgIdChg = (JSPUtil.getParameter(request, prefix	+ "msg_id_chg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chargeCd = (JSPUtil.getParameter(request, prefix	+ "charge_cd", length));
			String[] taxAmount = (JSPUtil.getParameter(request, prefix	+ "tax_amount", length));
			String[] ratExRateDate = (JSPUtil.getParameter(request, prefix	+ "rat_ex_rate_date", length));
			String[] supAmount = (JSPUtil.getParameter(request, prefix	+ "sup_amount", length));
			String[] blSrcNoChg = (JSPUtil.getParameter(request, prefix	+ "bl_src_no_chg", length));
			String[] frtIssueDate = (JSPUtil.getParameter(request, prefix	+ "frt_issue_date", length));
			String[] supCurCd = (JSPUtil.getParameter(request, prefix	+ "sup_cur_cd", length));
			String[] destCurCd = (JSPUtil.getParameter(request, prefix	+ "dest_cur_cd", length));
			String[] basicCurCd = (JSPUtil.getParameter(request, prefix	+ "basic_cur_cd", length));
			String[] reqAmount = (JSPUtil.getParameter(request, prefix	+ "req_amount", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamsungEDISendChargeVO();
				if (taxCurCd[i] != null)
					model.setTaxCurCd(taxCurCd[i]);
				if (blLineNoChg[i] != null)
					model.setBlLineNoChg(blLineNoChg[i]);
				if (msgNoChg[i] != null)
					model.setMsgNoChg(msgNoChg[i]);
				if (ratExRate[i] != null)
					model.setRatExRate(ratExRate[i]);
				if (reqCurCd[i] != null)
					model.setReqCurCd(reqCurCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (msgIdChg[i] != null)
					model.setMsgIdChg(msgIdChg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chargeCd[i] != null)
					model.setChargeCd(chargeCd[i]);
				if (taxAmount[i] != null)
					model.setTaxAmount(taxAmount[i]);
				if (ratExRateDate[i] != null)
					model.setRatExRateDate(ratExRateDate[i]);
				if (supAmount[i] != null)
					model.setSupAmount(supAmount[i]);
				if (blSrcNoChg[i] != null)
					model.setBlSrcNoChg(blSrcNoChg[i]);
				if (frtIssueDate[i] != null)
					model.setFrtIssueDate(frtIssueDate[i]);
				if (supCurCd[i] != null)
					model.setSupCurCd(supCurCd[i]);
				if (destCurCd[i] != null)
					model.setDestCurCd(destCurCd[i]);
				if (basicCurCd[i] != null)
					model.setBasicCurCd(basicCurCd[i]);
				if (reqAmount[i] != null)
					model.setReqAmount(reqAmount[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamsungEDISendChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamsungEDISendChargeVO[]
	 */
	public SamsungEDISendChargeVO[] getSamsungEDISendChargeVOs(){
		SamsungEDISendChargeVO[] vos = (SamsungEDISendChargeVO[])models.toArray(new SamsungEDISendChargeVO[models.size()]);
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
		this.taxCurCd = this.taxCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLineNoChg = this.blLineNoChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNoChg = this.msgNoChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratExRate = this.ratExRate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqCurCd = this.reqCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgIdChg = this.msgIdChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeCd = this.chargeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxAmount = this.taxAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratExRateDate = this.ratExRateDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supAmount = this.supAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNoChg = this.blSrcNoChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtIssueDate = this.frtIssueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supCurCd = this.supCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCurCd = this.destCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basicCurCd = this.basicCurCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqAmount = this.reqAmount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
