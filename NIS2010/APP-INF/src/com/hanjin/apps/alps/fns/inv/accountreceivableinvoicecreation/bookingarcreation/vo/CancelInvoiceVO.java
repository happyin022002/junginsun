/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CancelInvoiceVO.java
*@FileTitle : CancelInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.09 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CancelInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CancelInvoiceVO> models = new ArrayList<CancelInvoiceVO>();
	
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String ifNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String newIfNo = null;
	/* Column Info */
	private String otsSmryCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String uiType = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String invCustFlg = null;
	/* Column Info */
	private String invCustCntCd = null;
	/* Column Info */
	private String invCustSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CancelInvoiceVO() {}

	public CancelInvoiceVO(String ibflag, String pagerows, String ifNo, String newIfNo, String otsSmryCd, String userId, String effDt, String revTpCd, String revSrcCd, String uiType, String invNo, String arOfcCd, String actCustCntCd, String actCustSeq,String invCustFlg,String invCustCntCd,String invCustSeq) {
		this.effDt = effDt;
		this.ifNo = ifNo;
		this.ibflag = ibflag;
		this.revSrcCd = revSrcCd;
		this.newIfNo = newIfNo;
		this.otsSmryCd = otsSmryCd;
		this.userId = userId;
		this.revTpCd = revTpCd;
		this.uiType = uiType;
		this.invNo = invNo;
		this.arOfcCd = arOfcCd;
		this.actCustCntCd = actCustCntCd;
		this.actCustSeq = actCustSeq;
		this.pagerows = pagerows;
		this.invCustFlg = invCustFlg;
		this.invCustCntCd = invCustCntCd;
		this.invCustSeq = invCustSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("new_if_no", getNewIfNo());
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("ui_type", getUiType());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_cust_flg", getInvCustFlg());
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("new_if_no", "newIfNo");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ui_type", "uiType");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ar_ofc_Cd", "arOfcCd");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_cust_flg", "invCustFlg");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		return this.hashFields;
	}
	
	
	/**
	 * @return the invCustCntCd
	 */
	public String getInvCustCntCd() {
		return invCustCntCd;
	}

	/**
	 * @param invCustCntCd the invCustCntCd to set
	 */
	public void setInvCustCntCd(String invCustCntCd) {
		this.invCustCntCd = invCustCntCd;
	}

	/**
	 * @return the invCustSeq
	 */
	public String getInvCustSeq() {
		return invCustSeq;
	}

	/**
	 * @param invCustSeq the invCustSeq to set
	 */
	public void setInvCustSeq(String invCustSeq) {
		this.invCustSeq = invCustSeq;
	}

	/**
	 * @return the invCustFlg
	 */
	public String getInvCustFlg() {
		return invCustFlg;
	}

	/**
	 * @param invCustFlg the invCustFlg to set
	 */
	public void setInvCustFlg(String invCustFlg) {
		this.invCustFlg = invCustFlg;
	}

	/**
	 * @return the actCustCntCd
	 */
	public String getActCustCntCd() {
		return actCustCntCd;
	}

	/**
	 * @param actCustCntCd the actCustCntCd to set
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}

	/**
	 * @return the actCustSeq
	 */
	public String getActCustSeq() {
		return actCustSeq;
	}

	/**
	 * @param actCustSeq the actCustSeq to set
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}

	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the uiType
	 */
	public String getUiType() {
		return uiType;
	}

	/**
	 * @param uiType the uiType to set
	 */
	public void setUiType(String uiType) {
		this.uiType = uiType;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return ifNo
	 */
	public String getIfNo() {
		return this.ifNo;
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
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
	}
	
	/**
	 * Column Info
	 * @return newIfNo
	 */
	public String getNewIfNo() {
		return this.newIfNo;
	}
	
	/**
	 * Column Info
	 * @return otsSmryCd
	 */
	public String getOtsSmryCd() {
		return this.otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param ifNo
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
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
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * Column Info
	 * @param newIfNo
	 */
	public void setNewIfNo(String newIfNo) {
		this.newIfNo = newIfNo;
	}
	
	/**
	 * Column Info
	 * @param otsSmryCd
	 */
	public void setOtsSmryCd(String otsSmryCd) {
		this.otsSmryCd = otsSmryCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
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
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIfNo(JSPUtil.getParameter(request, "if_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setNewIfNo(JSPUtil.getParameter(request, "new_if_no", ""));
		setOtsSmryCd(JSPUtil.getParameter(request, "ots_smry_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setUiType(JSPUtil.getParameter(request, "ui_type", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvCustFlg(JSPUtil.getParameter(request, "inv_cust_flg", ""));
		setInvCustCntCd(JSPUtil.getParameter(request, "Inv_cust_cnt_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request, "inv_cust_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CancelInvoiceVO[]
	 */
	public CancelInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CancelInvoiceVO[]
	 */
	public CancelInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CancelInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] newIfNo = (JSPUtil.getParameter(request, prefix	+ "new_if_no", length));
			String[] otsSmryCd = (JSPUtil.getParameter(request, prefix	+ "ots_smry_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] uiType = (JSPUtil.getParameter(request, prefix	+ "ui_type", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] invCustFlg = (JSPUtil.getParameter(request, prefix	+ "inv_cust_flg", length));
			String[] invCustCntCd = (JSPUtil.getParameter(request, prefix	+ "inv_cust_cnt_cd", length));
			String[] invCustSeq = (JSPUtil.getParameter(request, prefix	+ "inv_cust_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CancelInvoiceVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (newIfNo[i] != null)
					model.setNewIfNo(newIfNo[i]);
				if (otsSmryCd[i] != null)
					model.setOtsSmryCd(otsSmryCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (uiType[i] != null)
					model.setUiType(uiType[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (invCustFlg[i] != null)
					model.setInvCustFlg(invCustFlg[i]);
				if (invCustCntCd[i] != null)
					model.setInvCustCntCd(invCustCntCd[i]);
				if (invCustSeq[i] != null)
					model.setInvCustSeq(invCustSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCancelInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CancelInvoiceVO[]
	 */
	public CancelInvoiceVO[] getCancelInvoiceVOs(){
		CancelInvoiceVO[] vos = (CancelInvoiceVO[])models.toArray(new CancelInvoiceVO[models.size()]);
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
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newIfNo = this.newIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd = this.otsSmryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiType = this.uiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustFlg = this.invCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd = this.invCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq = this.invCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
