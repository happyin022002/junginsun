/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualStlVvdVO.java
*@FileTitle : ManualStlVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.23 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManualStlVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManualStlVvdVO> models = new ArrayList<ManualStlVvdVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String acctYrmon = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String csrLoclAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManualStlVvdVO() {}

	public ManualStlVvdVO(String ibflag, String pagerows, String acctYrmon, String joCrrCd, String rlaneCd, String vvd, String csrLoclAmt, String csrNo) {
		this.vvd = vvd;
		this.csrNo = csrNo;
		this.acctYrmon = acctYrmon;
		this.ibflag = ibflag;
		this.joCrrCd = joCrrCd;
		this.rlaneCd = rlaneCd;
		this.csrLoclAmt = csrLoclAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("csr_locl_amt", getCsrLoclAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("csr_locl_amt", "csrLoclAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
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
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return csrLoclAmt
	 */
	public String getCsrLoclAmt() {
		return this.csrLoclAmt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
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
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param csrLoclAmt
	 */
	public void setCsrLoclAmt(String csrLoclAmt) {
		this.csrLoclAmt = csrLoclAmt;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setCsrLoclAmt(JSPUtil.getParameter(request, "csr_locl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManualStlVvdVO[]
	 */
	public ManualStlVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManualStlVvdVO[]
	 */
	public ManualStlVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManualStlVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] csrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "csr_locl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManualStlVvdVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (csrLoclAmt[i] != null)
					model.setCsrLoclAmt(csrLoclAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManualStlVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManualStlVvdVO[]
	 */
	public ManualStlVvdVO[] getManualStlVvdVOs(){
		ManualStlVvdVO[] vos = (ManualStlVvdVO[])models.toArray(new ManualStlVvdVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrLoclAmt = this.csrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
