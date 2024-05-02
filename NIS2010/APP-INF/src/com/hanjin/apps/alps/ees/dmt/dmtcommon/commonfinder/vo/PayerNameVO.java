/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayerNameVO.java
*@FileTitle : PayerNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.31 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PayerNameVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PayerNameVO> models = new ArrayList<PayerNameVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custName = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String lgsFlg = null;
	/* Page Number */
	private String nmdCustFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PayerNameVO() {}

	public PayerNameVO(String ibflag, String pagerows, String deltFlg, String custCd, String custName, String lgsFlg, String nmdCustFlg) {
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.custCd = custCd;
		this.custName = custName;
		this.pagerows = pagerows;
		this.lgsFlg = lgsFlg;
		this.nmdCustFlg = nmdCustFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lgs_flg", getLgsFlg());
		this.hashColumns.put("nmd_cust_flg", getNmdCustFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lgs_flg", "lgsFlg");
		this.hashFields.put("nmd_cust_flg", "nmdCustFlg");
		return this.hashFields;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return custName
	 */
	public String getCustName() {
		return this.custName;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getLgsFlg() {
		return lgsFlg;
	}

	public void setLgsFlg(String lgsFlg) {
		this.lgsFlg = lgsFlg;
	}

	public String getNmdCustFlg() {
		return nmdCustFlg;
	}

	public void setNmdCustFlg(String nmdCustFlg) {
		this.nmdCustFlg = nmdCustFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCustName(JSPUtil.getParameter(request, "cust_name", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLgsFlg(JSPUtil.getParameter(request, "lgs_flg", ""));
		setNmdCustFlg(JSPUtil.getParameter(request, "nmdCustFlg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PayerNameVO[]
	 */
	public PayerNameVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PayerNameVO[]
	 */
	public PayerNameVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PayerNameVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lgsFlg = (JSPUtil.getParameter(request, prefix	+ "lgs_flg", length));
			String[] nmdCustFlg = (JSPUtil.getParameter(request, prefix	+ "nmd_cust_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PayerNameVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custName[i] != null)
					model.setCustName(custName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lgsFlg[i] != null)
					model.setLgsFlg(lgsFlg[i]);
				if (nmdCustFlg[i] != null)
					model.setNmdCustFlg(nmdCustFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPayerNameVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PayerNameVO[]
	 */
	public PayerNameVO[] getPayerNameVOs(){
		PayerNameVO[] vos = (PayerNameVO[])models.toArray(new PayerNameVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsFlg = this.lgsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nmdCustFlg = this.nmdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
