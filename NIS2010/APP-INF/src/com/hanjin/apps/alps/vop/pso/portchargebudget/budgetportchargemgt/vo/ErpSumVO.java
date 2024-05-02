/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ErpSumVO.java
*@FileTitle : ErpSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.31 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.vo;

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

public class ErpSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ErpSumVO> models = new ArrayList<ErpSumVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String txtedate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String txtsdate = null;
	/* Column Info */
	private String estmAmt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String acclAmt = null;
	/* Column Info */
	private String actAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ErpSumVO() {}

	public ErpSumVO(String ibflag, String pagerows, String txtedate, String revYrmon, String txtsdate, String acctCd, String estmAmt, String acclAmt, String actAmt, String creUsrId, String rlaneCd) {
		this.creUsrId = creUsrId;
		this.txtedate = txtedate;
		this.ibflag = ibflag;
		this.revYrmon = revYrmon;
		this.acctCd = acctCd;
		this.txtsdate = txtsdate;
		this.estmAmt = estmAmt;
		this.rlaneCd = rlaneCd;
		this.acclAmt = acclAmt;
		this.actAmt = actAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("txtedate", getTxtedate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("txtsdate", getTxtsdate());
		this.hashColumns.put("estm_amt", getEstmAmt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("accl_amt", getAcclAmt());
		this.hashColumns.put("act_amt", getActAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("txtedate", "txtedate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("txtsdate", "txtsdate");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("accl_amt", "acclAmt");
		this.hashFields.put("act_amt", "actAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return txtedate
	 */
	public String getTxtedate() {
		return this.txtedate;
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
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return txtsdate
	 */
	public String getTxtsdate() {
		return this.txtsdate;
	}
	
	/**
	 * Column Info
	 * @return estmAmt
	 */
	public String getEstmAmt() {
		return this.estmAmt;
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
	 * @return acclAmt
	 */
	public String getAcclAmt() {
		return this.acclAmt;
	}
	
	/**
	 * Column Info
	 * @return actAmt
	 */
	public String getActAmt() {
		return this.actAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param txtedate
	 */
	public void setTxtedate(String txtedate) {
		this.txtedate = txtedate;
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
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param txtsdate
	 */
	public void setTxtsdate(String txtsdate) {
		this.txtsdate = txtsdate;
	}
	
	/**
	 * Column Info
	 * @param estmAmt
	 */
	public void setEstmAmt(String estmAmt) {
		this.estmAmt = estmAmt;
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
	 * @param acclAmt
	 */
	public void setAcclAmt(String acclAmt) {
		this.acclAmt = acclAmt;
	}
	
	/**
	 * Column Info
	 * @param actAmt
	 */
	public void setActAmt(String actAmt) {
		this.actAmt = actAmt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTxtedate(JSPUtil.getParameter(request, prefix + "txtedate", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setTxtsdate(JSPUtil.getParameter(request, prefix + "txtsdate", ""));
		setEstmAmt(JSPUtil.getParameter(request, prefix + "estm_amt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAcclAmt(JSPUtil.getParameter(request, prefix + "accl_amt", ""));
		setActAmt(JSPUtil.getParameter(request, prefix + "act_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ErpSumVO[]
	 */
	public ErpSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ErpSumVO[]
	 */
	public ErpSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ErpSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] txtedate = (JSPUtil.getParameter(request, prefix	+ "txtedate", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] txtsdate = (JSPUtil.getParameter(request, prefix	+ "txtsdate", length));
			String[] estmAmt = (JSPUtil.getParameter(request, prefix	+ "estm_amt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] acclAmt = (JSPUtil.getParameter(request, prefix	+ "accl_amt", length));
			String[] actAmt = (JSPUtil.getParameter(request, prefix	+ "act_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ErpSumVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (txtedate[i] != null)
					model.setTxtedate(txtedate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (txtsdate[i] != null)
					model.setTxtsdate(txtsdate[i]);
				if (estmAmt[i] != null)
					model.setEstmAmt(estmAmt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (acclAmt[i] != null)
					model.setAcclAmt(acclAmt[i]);
				if (actAmt[i] != null)
					model.setActAmt(actAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getErpSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ErpSumVO[]
	 */
	public ErpSumVO[] getErpSumVOs(){
		ErpSumVO[] vos = (ErpSumVO[])models.toArray(new ErpSumVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtedate = this.txtedate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtsdate = this.txtsdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt = this.estmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAmt = this.acclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAmt = this.actAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
