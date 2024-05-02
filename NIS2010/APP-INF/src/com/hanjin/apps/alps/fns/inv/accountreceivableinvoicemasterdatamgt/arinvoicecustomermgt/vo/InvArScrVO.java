/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArScrVO.java
*@FileTitle : InvArScrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.09 최도순 
* 1.0 Creation
=========================================================*/

package  com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArScrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvArScrVO> models = new ArrayList<InvArScrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String scrEndDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String scrSeq = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custScrDivCd = null;
	/* Column Info */
	private String custScrKrwAmt = null;
	/* Column Info */
	private String crCurrCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String custScrUsdAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String scrStDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String custScrAmt = null;
	/* Column Info */
	private String scrRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArScrVO() {}

	public InvArScrVO(String ibflag, String pagerows, String custCntCd, String custSeq, String scrSeq, String arOfcCd, String custScrDivCd, String custScrAmt, String custScrUsdAmt, String crCurrCd, String scrStDt, String scrEndDt, String scrRmk, String creUsrId, String creDt, String updUsrId, String updDt, String custScrKrwAmt) {
		this.updDt = updDt;
		this.scrEndDt = scrEndDt;
		this.creDt = creDt;
		this.scrSeq = scrSeq;
		this.custSeq = custSeq;
		this.custScrDivCd = custScrDivCd;
		this.custScrKrwAmt = custScrKrwAmt;
		this.crCurrCd = crCurrCd;
		this.arOfcCd = arOfcCd;
		this.custScrUsdAmt = custScrUsdAmt;
		this.pagerows = pagerows;
		this.scrStDt = scrStDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.custScrAmt = custScrAmt;
		this.scrRmk = scrRmk;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("scr_end_dt", getScrEndDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("scr_seq", getScrSeq());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_scr_div_cd", getCustScrDivCd());
		this.hashColumns.put("cust_scr_krw_amt", getCustScrKrwAmt());
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cust_scr_usd_amt", getCustScrUsdAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("scr_st_dt", getScrStDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_scr_amt", getCustScrAmt());
		this.hashColumns.put("scr_rmk", getScrRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("scr_end_dt", "scrEndDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("scr_seq", "scrSeq");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_scr_div_cd", "custScrDivCd");
		this.hashFields.put("cust_scr_krw_amt", "custScrKrwAmt");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_scr_usd_amt", "custScrUsdAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("scr_st_dt", "scrStDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_scr_amt", "custScrAmt");
		this.hashFields.put("scr_rmk", "scrRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return scrEndDt
	 */
	public String getScrEndDt() {
		return this.scrEndDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return scrSeq
	 */
	public String getScrSeq() {
		return this.scrSeq;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custScrDivCd
	 */
	public String getCustScrDivCd() {
		return this.custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @return custScrKrwAmt
	 */
	public String getCustScrKrwAmt() {
		return this.custScrKrwAmt;
	}
	
	/**
	 * Column Info
	 * @return crCurrCd
	 */
	public String getCrCurrCd() {
		return this.crCurrCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custScrUsdAmt
	 */
	public String getCustScrUsdAmt() {
		return this.custScrUsdAmt;
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
	 * @return scrStDt
	 */
	public String getScrStDt() {
		return this.scrStDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return custScrAmt
	 */
	public String getCustScrAmt() {
		return this.custScrAmt;
	}
	
	/**
	 * Column Info
	 * @return scrRmk
	 */
	public String getScrRmk() {
		return this.scrRmk;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param scrEndDt
	 */
	public void setScrEndDt(String scrEndDt) {
		this.scrEndDt = scrEndDt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param scrSeq
	 */
	public void setScrSeq(String scrSeq) {
		this.scrSeq = scrSeq;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custScrDivCd
	 */
	public void setCustScrDivCd(String custScrDivCd) {
		this.custScrDivCd = custScrDivCd;
	}
	
	/**
	 * Column Info
	 * @param custScrKrwAmt
	 */
	public void setCustScrKrwAmt(String custScrKrwAmt) {
		this.custScrKrwAmt = custScrKrwAmt;
	}
	
	/**
	 * Column Info
	 * @param crCurrCd
	 */
	public void setCrCurrCd(String crCurrCd) {
		this.crCurrCd = crCurrCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custScrUsdAmt
	 */
	public void setCustScrUsdAmt(String custScrUsdAmt) {
		this.custScrUsdAmt = custScrUsdAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param scrStDt
	 */
	public void setScrStDt(String scrStDt) {
		this.scrStDt = scrStDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param custScrAmt
	 */
	public void setCustScrAmt(String custScrAmt) {
		this.custScrAmt = custScrAmt;
	}
	
	/**
	 * Column Info
	 * @param scrRmk
	 */
	public void setScrRmk(String scrRmk) {
		this.scrRmk = scrRmk;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setScrEndDt(JSPUtil.getParameter(request, "scr_end_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setScrSeq(JSPUtil.getParameter(request, "scr_seq", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustScrDivCd(JSPUtil.getParameter(request, "cust_scr_div_cd", ""));
		setCustScrKrwAmt(JSPUtil.getParameter(request, "cust_scr_krw_amt", ""));
		setCrCurrCd(JSPUtil.getParameter(request, "cr_curr_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setCustScrUsdAmt(JSPUtil.getParameter(request, "cust_scr_usd_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setScrStDt(JSPUtil.getParameter(request, "scr_st_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCustScrAmt(JSPUtil.getParameter(request, "cust_scr_amt", ""));
		setScrRmk(JSPUtil.getParameter(request, "scr_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArScrVO[]
	 */
	public InvArScrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvArScrVO[]
	 */
	public InvArScrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArScrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] scrEndDt = (JSPUtil.getParameter(request, prefix	+ "scr_end_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] scrSeq = (JSPUtil.getParameter(request, prefix	+ "scr_seq", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custScrDivCd = (JSPUtil.getParameter(request, prefix	+ "cust_scr_div_cd", length));
			String[] custScrKrwAmt = (JSPUtil.getParameter(request, prefix	+ "cust_scr_krw_amt", length));
			String[] crCurrCd = (JSPUtil.getParameter(request, prefix	+ "cr_curr_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] custScrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cust_scr_usd_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] scrStDt = (JSPUtil.getParameter(request, prefix	+ "scr_st_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] custScrAmt = (JSPUtil.getParameter(request, prefix	+ "cust_scr_amt", length));
			String[] scrRmk = (JSPUtil.getParameter(request, prefix	+ "scr_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvArScrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (scrEndDt[i] != null)
					model.setScrEndDt(scrEndDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (scrSeq[i] != null)
					model.setScrSeq(scrSeq[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custScrDivCd[i] != null)
					model.setCustScrDivCd(custScrDivCd[i]);
				if (custScrKrwAmt[i] != null)
					model.setCustScrKrwAmt(custScrKrwAmt[i]);
				if (crCurrCd[i] != null)
					model.setCrCurrCd(crCurrCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (custScrUsdAmt[i] != null)
					model.setCustScrUsdAmt(custScrUsdAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (scrStDt[i] != null)
					model.setScrStDt(scrStDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (custScrAmt[i] != null)
					model.setCustScrAmt(custScrAmt[i]);
				if (scrRmk[i] != null)
					model.setScrRmk(scrRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvArScrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvArScrVO[]
	 */
	public InvArScrVO[] getInvArScrVOs(){
		InvArScrVO[] vos = (InvArScrVO[])models.toArray(new InvArScrVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrEndDt = this.scrEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrSeq = this.scrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrDivCd = this.custScrDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrKrwAmt = this.custScrKrwAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd = this.crCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrUsdAmt = this.custScrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrStDt = this.scrStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custScrAmt = this.custScrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scrRmk = this.scrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
