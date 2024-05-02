/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRiderInVO.java
*@FileTitle : BlRiderInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.17 이진서
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CSRInvAgmtLnkInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CSRInvAgmtLnkInVO> models = new ArrayList<CSRInvAgmtLnkInVO>();

	private SignOnUserAccount account = null;
	private CSRComApFileUpldVO[] csrComApFileUpldVOs = null;
	private String[] Keys= null;

	/**
	 * @return the keys
	 */
	public String[] getKeys() {
		return Keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(String[] keys) {
		Keys = keys;
	}

	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/* Column Info */
	private String csrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String csrFileUpldTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CSRInvAgmtLnkInVO() {}


	/**
	 * @return the csrComApFileUpldVOs
	 */
	public CSRComApFileUpldVO[] getCsrComApFileUpldVOs() {
		return csrComApFileUpldVOs;
	}

	/**
	 * @param csrComApFileUpldVOs the csrComApFileUpldVOs to set
	 */
	public void setCsrComApFileUpldVOs(CSRComApFileUpldVO[] csrComApFileUpldVOs) {
		this.csrComApFileUpldVOs = csrComApFileUpldVOs;
	}

	public CSRInvAgmtLnkInVO(String ibflag, String pagerows, String csrNo,  String csrFileUpldTpCd) {
		this.csrNo = csrNo;
		this.ibflag = ibflag;
		this.csrFileUpldTpCd = csrFileUpldTpCd;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("csr_file_upld_tp_cd", getCsrFileUpldTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ibflag", "ibflag");
		
		this.hashFields.put("csr_file_upld_tp_cd", "csrFileUpldTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
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
	 * @return csrFileUpldTpCd
	 */
	public String getCsrFileUpldTpCd() {
		return this.csrFileUpldTpCd;
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
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
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
	 * @param csrFileUpldTpCd
	 */
	public void setCsrFileUpldTpCd(String csrFileUpldTpCd) {
		this.csrFileUpldTpCd = csrFileUpldTpCd;
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
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		
		setCsrFileUpldTpCd(JSPUtil.getParameter(request, "csr_file_upld_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CSRInvAgmtLnkInVO[]
	 */
	public CSRInvAgmtLnkInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CSRInvAgmtLnkInVO[]
	 */
	public CSRInvAgmtLnkInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CSRInvAgmtLnkInVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			
			String[] csrFileUpldTpCd = (JSPUtil.getParameter(request, prefix	+ "csr_file_upld_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CSRInvAgmtLnkInVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);

				if (csrFileUpldTpCd[i] != null)
					model.setCsrFileUpldTpCd(csrFileUpldTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCSRInvAgmtLnkInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CSRInvAgmtLnkInVO[]
	 */
	public CSRInvAgmtLnkInVO[] getCSRInvAgmtLnkInVOs(){
		CSRInvAgmtLnkInVO[] vos = (CSRInvAgmtLnkInVO[])models.toArray(new CSRInvAgmtLnkInVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.csrFileUpldTpCd = this.csrFileUpldTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
