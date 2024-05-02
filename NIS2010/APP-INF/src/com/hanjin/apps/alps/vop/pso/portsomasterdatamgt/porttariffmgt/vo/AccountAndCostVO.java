/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccountAndCostVO.java
*@FileTitle : AccountAndCostVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.24
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.12.24 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AccountAndCostVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AccountAndCostVO> models = new ArrayList<AccountAndCostVO>();
	
	/* Column Info */
	private String acctNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String acctCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AccountAndCostVO() {}

	public AccountAndCostVO(String ibflag, String pagerows, String acctCd, String acctNm, String costCd, String costNm) {
		this.acctNm = acctNm;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.costNm = costNm;
		this.acctCd = acctCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acctNm
	 */
	public String getAcctNm() {
		return this.acctNm;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return costNm
	 */
	public String getCostNm() {
		return this.costNm;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
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
	 * @param acctNm
	 */
	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param costNm
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
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
		setAcctNm(JSPUtil.getParameter(request, "acct_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setCostNm(JSPUtil.getParameter(request, "cost_nm", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccountAndCostVO[]
	 */
	public AccountAndCostVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AccountAndCostVO[]
	 */
	public AccountAndCostVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AccountAndCostVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AccountAndCostVO();
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAccountAndCostVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AccountAndCostVO[]
	 */
	public AccountAndCostVO[] getAccountAndCostVOs(){
		AccountAndCostVO[] vos = (AccountAndCostVO[])models.toArray(new AccountAndCostVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
