/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostAuditSearchVO.java
*@FileTitle : PayableRentalCostAuditSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.10.01 노정용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo;

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
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayableRentalCostAuditSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayableRentalCostAuditSearchVO> models = new ArrayList<PayableRentalCostAuditSearchVO>();
	
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String chgCostYrmon = null;
	/* Column Info */
	private String chgSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayableRentalCostAuditSearchVO() {}

	public PayableRentalCostAuditSearchVO(String ibflag, String pagerows, String chgCostYrmon, String chgSeq, String agmtCtyCd, String agmtSeq, String invNo) {
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.agmtSeq = agmtSeq;
		this.agmtCtyCd = agmtCtyCd;
		this.chgCostYrmon = chgCostYrmon;
		this.chgSeq = chgSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("chg_cost_yrmon", getChgCostYrmon());
		this.hashColumns.put("chg_seq", getChgSeq());
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
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("chg_cost_yrmon", "chgCostYrmon");
		this.hashFields.put("chg_seq", "chgSeq");
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return chgCostYrmon
	 */
	public String getChgCostYrmon() {
		return this.chgCostYrmon;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param chgCostYrmon
	 */
	public void setChgCostYrmon(String chgCostYrmon) {
		this.chgCostYrmon = chgCostYrmon;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
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
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setChgCostYrmon(JSPUtil.getParameter(request, "chg_cost_yrmon", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayableRentalCostAuditSearchVO[]
	 */
	public PayableRentalCostAuditSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayableRentalCostAuditSearchVO[]
	 */
	public PayableRentalCostAuditSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayableRentalCostAuditSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd", length));
			String[] chgCostYrmon = (JSPUtil.getParameter(request, prefix	+ "chg_cost_yrmon", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayableRentalCostAuditSearchVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (chgCostYrmon[i] != null)
					model.setChgCostYrmon(chgCostYrmon[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayableRentalCostAuditSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayableRentalCostAuditSearchVO[]
	 */
	public PayableRentalCostAuditSearchVO[] getPayableRentalCostAuditSearchVOs(){
		PayableRentalCostAuditSearchVO[] vos = (PayableRentalCostAuditSearchVO[])models.toArray(new PayableRentalCostAuditSearchVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCostYrmon = this.chgCostYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
