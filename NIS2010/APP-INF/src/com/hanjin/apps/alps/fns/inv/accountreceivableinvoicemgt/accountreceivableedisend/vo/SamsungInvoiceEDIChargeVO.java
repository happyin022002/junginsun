/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SamsungInvoiceEDIChargeVO.java
*@FileTitle : SamsungInvoiceEDIChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.05 박정진 
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

public class SamsungInvoiceEDIChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamsungInvoiceEDIChargeVO> models = new ArrayList<SamsungInvoiceEDIChargeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String msgNo = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* Column Info */
	private String vatCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vatAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String blLineNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamsungInvoiceEDIChargeVO() {}

	public SamsungInvoiceEDIChargeVO(String ibflag, String pagerows, String msgId, String msgNo, String blLineNo, String blSrcNo, String chgCd, String chgAmt, String chgCurrCd, String vatAmt, String vatCurrCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.blSrcNo = blSrcNo;
		this.creDt = creDt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.msgNo = msgNo;
		this.chgCurrCd = chgCurrCd;
		this.vatCurrCd = vatCurrCd;
		this.ibflag = ibflag;
		this.vatAmt = vatAmt;
		this.creUsrId = creUsrId;
		this.blLineNo = blLineNo;
		this.chgAmt = chgAmt;
		this.msgId = msgId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("msg_no", getMsgNo());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("vat_curr_cd", getVatCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vat_amt", getVatAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bl_line_no", getBlLineNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("msg_no", "msgNo");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("vat_curr_cd", "vatCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bl_line_no", "blLineNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return msgNo
	 */
	public String getMsgNo() {
		return this.msgNo;
	}
	
	/**
	 * Column Info
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return vatCurrCd
	 */
	public String getVatCurrCd() {
		return this.vatCurrCd;
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
	 * @return vatAmt
	 */
	public String getVatAmt() {
		return this.vatAmt;
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
	 * @return blLineNo
	 */
	public String getBlLineNo() {
		return this.blLineNo;
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
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param msgNo
	 */
	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}
	
	/**
	 * Column Info
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param vatCurrCd
	 */
	public void setVatCurrCd(String vatCurrCd) {
		this.vatCurrCd = vatCurrCd;
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
	 * @param vatAmt
	 */
	public void setVatAmt(String vatAmt) {
		this.vatAmt = vatAmt;
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
	 * @param blLineNo
	 */
	public void setBlLineNo(String blLineNo) {
		this.blLineNo = blLineNo;
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
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMsgNo(JSPUtil.getParameter(request, "msg_no", ""));
		setChgCurrCd(JSPUtil.getParameter(request, "chg_curr_cd", ""));
		setVatCurrCd(JSPUtil.getParameter(request, "vat_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVatAmt(JSPUtil.getParameter(request, "vat_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBlLineNo(JSPUtil.getParameter(request, "bl_line_no", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setMsgId(JSPUtil.getParameter(request, "msg_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamsungInvoiceEDIChargeVO[]
	 */
	public SamsungInvoiceEDIChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamsungInvoiceEDIChargeVO[]
	 */
	public SamsungInvoiceEDIChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamsungInvoiceEDIChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] msgNo = (JSPUtil.getParameter(request, prefix	+ "msg_no", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] vatCurrCd = (JSPUtil.getParameter(request, prefix	+ "vat_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vatAmt = (JSPUtil.getParameter(request, prefix	+ "vat_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] blLineNo = (JSPUtil.getParameter(request, prefix	+ "bl_line_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamsungInvoiceEDIChargeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (msgNo[i] != null)
					model.setMsgNo(msgNo[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (vatCurrCd[i] != null)
					model.setVatCurrCd(vatCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vatAmt[i] != null)
					model.setVatAmt(vatAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blLineNo[i] != null)
					model.setBlLineNo(blLineNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamsungInvoiceEDIChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamsungInvoiceEDIChargeVO[]
	 */
	public SamsungInvoiceEDIChargeVO[] getSamsungInvoiceEDIChargeVOs(){
		SamsungInvoiceEDIChargeVO[] vos = (SamsungInvoiceEDIChargeVO[])models.toArray(new SamsungInvoiceEDIChargeVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNo = this.msgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatCurrCd = this.vatCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt = this.vatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLineNo = this.blLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
