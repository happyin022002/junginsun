/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceVO.java
*@FileTitle : ARInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.29 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

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

public class ARInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceVO> models = new ArrayList<ARInvoiceVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String arIfSerNo = null;
	/* Column Info */
	private String invXchRtDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceVO() {}

	public ARInvoiceVO(String ibflag, String pagerows, String arIfNo, String arIfSerNo, String chgSeq, String invXchRt, String invXchRtDt, String updUsrId,String usdXchRt) {
		this.ibflag = ibflag;
		this.arIfNo = arIfNo;
		this.chgSeq = chgSeq;
		this.invXchRt = invXchRt;
		this.usdXchRt = usdXchRt;
		this.arIfSerNo = arIfSerNo;
		this.invXchRtDt = invXchRtDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	
	/**
	 * @return the usdXchRt
	 */
	public String getUsdXchRt() {
		return usdXchRt;
	}

	/**
	 * @param usdXchRt the usdXchRt to set
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the invXchRtDt
	 */
	public String getInvXchRtDt() {
		return invXchRtDt;
	}

	/**
	 * @param invXchRtDt the invXchRtDt to set
	 */
	public void setInvXchRtDt(String invXchRtDt) {
		this.invXchRtDt = invXchRtDt;
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
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
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
	 * @return arIfSerNo
	 */
	public String getArIfSerNo() {
		return this.arIfSerNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param arIfSerNo
	 */
	public void setArIfSerNo(String arIfSerNo) {
		this.arIfSerNo = arIfSerNo;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setInvXchRt(JSPUtil.getParameter(request, "usd_xch_rt", ""));
		setInvXchRtDt(JSPUtil.getParameter(request, "inv_xch_rt_dt", ""));
		setArIfSerNo(JSPUtil.getParameter(request, "ar_if_ser_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceVO[]
	 */
	public ARInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceVO[]
	 */
	public ARInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] invXchRtDt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt_dt", length));
			String[] arIfSerNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_ser_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (usdXchRt[i] != null)
					model.setInvXchRt(usdXchRt[i]);
				if (invXchRtDt[i] != null)
					model.setInvXchRtDt(invXchRtDt[i]);
				if (arIfSerNo[i] != null)
					model.setArIfSerNo(arIfSerNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceVO[]
	 */
	public ARInvoiceVO[] getARInvoiceVOs(){
		ARInvoiceVO[] vos = (ARInvoiceVO[])models.toArray(new ARInvoiceVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt = this.invXchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo = this.arIfSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
