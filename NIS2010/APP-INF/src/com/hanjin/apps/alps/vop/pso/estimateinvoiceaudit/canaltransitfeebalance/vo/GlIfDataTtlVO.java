/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GlIfDataTtlVO.java
*@FileTitle : GlIfDataTtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.08.13 정명훈 
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

public class GlIfDataTtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GlIfDataTtlVO> models = new ArrayList<GlIfDataTtlVO>();
	
	/* Column Info */
	private String amt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String debit = null;
	/* Column Info */
	private String credit = null;
	/* Column Info */
	private String section = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlIfDataTtlVO() {}

	public GlIfDataTtlVO(String ibflag, String pagerows, String section, String debit, String credit, String amt) {
		this.amt = amt;
		this.ibflag = ibflag;
		this.debit = debit;
		this.credit = credit;
		this.section = section;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("debit", getDebit());
		this.hashColumns.put("credit", getCredit());
		this.hashColumns.put("section", getSection());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amt", "amt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("debit", "debit");
		this.hashFields.put("credit", "credit");
		this.hashFields.put("section", "section");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
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
	 * Column Info
	 * @return section
	 */
	public String getSection() {
		return this.section;
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
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
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
	 * Column Info
	 * @param section
	 */
	public void setSection(String section) {
		this.section = section;
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
		setAmt(JSPUtil.getParameter(request, "amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDebit(JSPUtil.getParameter(request, "debit", ""));
		setCredit(JSPUtil.getParameter(request, "credit", ""));
		setSection(JSPUtil.getParameter(request, "section", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlIfDataTtlVO[]
	 */
	public GlIfDataTtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlIfDataTtlVO[]
	 */
	public GlIfDataTtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlIfDataTtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] debit = (JSPUtil.getParameter(request, prefix	+ "debit", length));
			String[] credit = (JSPUtil.getParameter(request, prefix	+ "credit", length));
			String[] section = (JSPUtil.getParameter(request, prefix	+ "section", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlIfDataTtlVO();
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (debit[i] != null)
					model.setDebit(debit[i]);
				if (credit[i] != null)
					model.setCredit(credit[i]);
				if (section[i] != null)
					model.setSection(section[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlIfDataTtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlIfDataTtlVO[]
	 */
	public GlIfDataTtlVO[] getGlIfDataTtlVOs(){
		GlIfDataTtlVO[] vos = (GlIfDataTtlVO[])models.toArray(new GlIfDataTtlVO[models.size()]);
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
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.debit = this.debit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.credit = this.credit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.section = this.section .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
