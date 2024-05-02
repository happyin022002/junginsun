/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GlIfDataThisMonVO.java
*@FileTitle : GlIfDataThisMonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.08.14 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeebalance.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GlIfDataThisMonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GlIfDataThisMonVO> models = new ArrayList<GlIfDataThisMonVO>();
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String glDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slip = null;
	/* Column Info */
	private String debit = null;
	/* Column Info */
	private String credit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlIfDataThisMonVO() {}

	public GlIfDataThisMonVO(String ibflag, String pagerows, String glDt, String debit, String credit, String slip, String csrNo, String invNo) {
		this.invNo = invNo;
		this.csrNo = csrNo;
		this.glDt = glDt;
		this.ibflag = ibflag;
		this.slip = slip;
		this.debit = debit;
		this.credit = credit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("gl_dt", getGlDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slip", getSlip());
		this.hashColumns.put("debit", getDebit());
		this.hashColumns.put("credit", getCredit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slip", "slip");
		this.hashFields.put("debit", "debit");
		this.hashFields.put("credit", "credit");
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
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
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
	 * @return slip
	 */
	public String getSlip() {
		return this.slip;
	}
	
	/**
	 * Column Info
	 * @return debit
	 */
	public String getDebit() {
		return this.debit;
	}
	
	/**
	 * Column Info
	 * @return credit
	 */
	public String getCredit() {
		return this.credit;
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
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
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
	 * @param slip
	 */
	public void setSlip(String slip) {
		this.slip = slip;
	}
	
	/**
	 * Column Info
	 * @param debit
	 */
	public void setDebit(String debit) {
		this.debit = debit;
	}
	
	/**
	 * Column Info
	 * @param credit
	 */
	public void setCredit(String credit) {
		this.credit = credit;
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
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setGlDt(JSPUtil.getParameter(request, "gl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlip(JSPUtil.getParameter(request, "slip", ""));
		setDebit(JSPUtil.getParameter(request, "debit", ""));
		setCredit(JSPUtil.getParameter(request, "credit", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlIfDataThisMonVO[]
	 */
	public GlIfDataThisMonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlIfDataThisMonVO[]
	 */
	public GlIfDataThisMonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlIfDataThisMonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] glDt = (JSPUtil.getParameter(request, prefix	+ "gl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slip = (JSPUtil.getParameter(request, prefix	+ "slip", length));
			String[] debit = (JSPUtil.getParameter(request, prefix	+ "debit", length));
			String[] credit = (JSPUtil.getParameter(request, prefix	+ "credit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlIfDataThisMonVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (glDt[i] != null)
					model.setGlDt(glDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slip[i] != null)
					model.setSlip(slip[i]);
				if (debit[i] != null)
					model.setDebit(debit[i]);
				if (credit[i] != null)
					model.setCredit(credit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlIfDataThisMonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlIfDataThisMonVO[]
	 */
	public GlIfDataThisMonVO[] getGlIfDataThisMonVOs(){
		GlIfDataThisMonVO[] vos = (GlIfDataThisMonVO[])models.toArray(new GlIfDataThisMonVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt = this.glDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slip = this.slip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.debit = this.debit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.credit = this.credit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
