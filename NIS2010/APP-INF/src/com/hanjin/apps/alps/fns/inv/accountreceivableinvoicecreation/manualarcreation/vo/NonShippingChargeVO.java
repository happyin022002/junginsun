/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NonShippingChargeVO.java
*@FileTitle : NonShippingChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.22 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.manualarcreation.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NonShippingChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NonShippingChargeVO> models = new ArrayList<NonShippingChargeVO>();
	
	/* Column Info */
	private String repChgCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgFullNm = null;
	/* Column Info */
	private String drCr = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String city = null;
	/* Column Info */
	private String invRevTpSrcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String chgRmk = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String tvaFlg = null;
	/* Column Info */
	private String mnlFlg = null;
	/* Column Info */
	private String ttlLssCfmFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NonShippingChargeVO() {}

	public NonShippingChargeVO(String ibflag, String pagerows, String drCr, String acctCd, String chgFullNm, String custCode, String city, String currCd, String chgAmt, String chgRmk, String invRevTpSrcCd, String chgCd, String repChgCd, String invXchRt, String chgSeq, String tvaFlg, String mnlFlg ,String ttlLssCfmFlg) {
		this.repChgCd = repChgCd;
		this.currCd = currCd;
		this.chgFullNm = chgFullNm;
		this.drCr = drCr;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.city = city;
		this.invRevTpSrcCd = invRevTpSrcCd;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.custCode = custCode;
		this.chgAmt = chgAmt;
		this.invXchRt = invXchRt;
		this.chgRmk = chgRmk;
		this.chgSeq = chgSeq;
		this.tvaFlg = tvaFlg;
		this.mnlFlg = mnlFlg;
		this.ttlLssCfmFlg = ttlLssCfmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_chg_cd", getRepChgCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_full_nm", getChgFullNm());
		this.hashColumns.put("dr_cr", getDrCr());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("city", getCity());
		this.hashColumns.put("inv_rev_tp_src_cd", getInvRevTpSrcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("chg_rmk", getChgRmk());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("tva_flg", getTvaFlg());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		this.hashColumns.put("ttl_lss_cfm_flg" ,getTtlLssCfmFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("dr_cr", "drCr");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("city", "city");
		this.hashFields.put("inv_rev_tp_src_cd", "invRevTpSrcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("chg_rmk", "chgRmk");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("ttl_lss_cfm_flg", "ttlLssCfmFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repChgCd
	 */
	public String getRepChgCd() {
		return this.repChgCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return chgFullNm
	 */
	public String getChgFullNm() {
		return this.chgFullNm;
	}
	
	/**
	 * Column Info
	 * @return drCr
	 */
	public String getDrCr() {
		return this.drCr;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Column Info
	 * @return revCd
	 */
	public String getInvRevTpSrcCd() {
		return this.invRevTpSrcCd;
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
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
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
	 * @return chgRmk
	 */
	public String getChgRmk() {
		return this.chgRmk;
	}
	

	/**
	 * Column Info
	 * @param repChgCd
	 */
	public void setRepChgCd(String repChgCd) {
		this.repChgCd = repChgCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param chgFullNm
	 */
	public void setChgFullNm(String chgFullNm) {
		this.chgFullNm = chgFullNm;
	}
	
	/**
	 * Column Info
	 * @param drCr
	 */
	public void setDrCr(String drCr) {
		this.drCr = drCr;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Column Info
	 * @param revCd
	 */
	public void setInvRevTpSrcCd(String invRevTpSrcCd) {
		this.invRevTpSrcCd = invRevTpSrcCd;
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
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
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
	 * @param chgRmk
	 */
	public void setChgRmk(String chgRmk) {
		this.chgRmk = chgRmk;
	}
	
	public String getChgSeq() {
		return chgSeq;
	}

	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}

	public String getTvaFlg() {
		return tvaFlg;
	}

	public void setTvaFlg(String tvaFlg) {
		this.tvaFlg = tvaFlg;
	}

	public String getMnlFlg() {
		return mnlFlg;
	}

	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
	}

	/**
	 * @return the ttlLssCfmFlg
	 */
	public String getTtlLssCfmFlg() {
		return ttlLssCfmFlg;
	}

	/**
	 * @param ttlLssCfmFlg the ttlLssCfmFlg to set
	 */
	public void setTtlLssCfmFlg(String ttlLssCfmFlg) {
		this.ttlLssCfmFlg = ttlLssCfmFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepChgCd(JSPUtil.getParameter(request, "rep_chg_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setChgFullNm(JSPUtil.getParameter(request, "chg_full_nm", ""));
		setDrCr(JSPUtil.getParameter(request, "dr_cr", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCity(JSPUtil.getParameter(request, "city", ""));
		setInvRevTpSrcCd(JSPUtil.getParameter(request, "inv_rev_tp_src_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCustCode(JSPUtil.getParameter(request, "cust_code", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setChgRmk(JSPUtil.getParameter(request, "chg_rmk", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setTvaFlg(JSPUtil.getParameter(request, "tva_flg", ""));
		setMnlFlg(JSPUtil.getParameter(request, "mnl_flg", ""));
		setTtlLssCfmFlg(JSPUtil.getParameter(request, "ttl_lss_cfm_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NonShippingChargeVO[]
	 */
	public NonShippingChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NonShippingChargeVO[]
	 */
	public NonShippingChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NonShippingChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repChgCd = (JSPUtil.getParameter(request, prefix	+ "rep_chg_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgFullNm = (JSPUtil.getParameter(request, prefix	+ "chg_full_nm", length));
			String[] drCr = (JSPUtil.getParameter(request, prefix	+ "dr_cr", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] city = (JSPUtil.getParameter(request, prefix	+ "city", length));
			String[] invRevTpSrcCd = (JSPUtil.getParameter(request, prefix	+ "inv_rev_tp_src_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] chgRmk = (JSPUtil.getParameter(request, prefix	+ "chg_rmk", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] tvaFlg = (JSPUtil.getParameter(request, prefix	+ "tva_flg", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			String[] ttlLssCfmFlg = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cfm_flg", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new NonShippingChargeVO();
				if (repChgCd[i] != null)
					model.setRepChgCd(repChgCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgFullNm[i] != null)
					model.setChgFullNm(chgFullNm[i]);
				if (drCr[i] != null)
					model.setDrCr(drCr[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (city[i] != null)
					model.setCity(city[i]);
				if (invRevTpSrcCd[i] != null)
					model.setInvRevTpSrcCd(invRevTpSrcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (chgRmk[i] != null)
					model.setChgRmk(chgRmk[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (tvaFlg[i] != null)
					model.setTvaFlg(tvaFlg[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				if (ttlLssCfmFlg[i] != null)
					model.setTtlLssCfmFlg(ttlLssCfmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNonShippingChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NonShippingChargeVO[]
	 */
	public NonShippingChargeVO[] getNonShippingChargeVOs(){
		NonShippingChargeVO[] vos = (NonShippingChargeVO[])models.toArray(new NonShippingChargeVO[models.size()]);
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
		this.repChgCd = this.repChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm = this.chgFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drCr = this.drCr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.city = this.city .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRevTpSrcCd = this.invRevTpSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRmk = this.chgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg = this.tvaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmFlg = this.ttlLssCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
