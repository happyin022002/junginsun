/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BankAcctCmbSeqVO.java
*@FileTitle : BankAcctCmbSeqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BankAcctCmbSeqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BankAcctCmbSeqVO> models = new ArrayList<BankAcctCmbSeqVO>();
	
	/* Column Info */
	private String bankAcctNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String asetCdCmbSeq = null;
	/* Column Info */
	private String chgCdCmbSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BankAcctCmbSeqVO() {}

	public BankAcctCmbSeqVO(String ibflag, String pagerows, String bankAcctNo, String asetCdCmbSeq, String chgCdCmbSeq) {
		this.bankAcctNo = bankAcctNo;
		this.ibflag = ibflag;
		this.asetCdCmbSeq = asetCdCmbSeq;
		this.chgCdCmbSeq = chgCdCmbSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aset_cd_cmb_seq", getAsetCdCmbSeq());
		this.hashColumns.put("chg_cd_cmb_seq", getChgCdCmbSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aset_cd_cmb_seq", "asetCdCmbSeq");
		this.hashFields.put("chg_cd_cmb_seq", "chgCdCmbSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
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
	 * @return asetCdCmbSeq
	 */
	public String getAsetCdCmbSeq() {
		return this.asetCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCdCmbSeq
	 */
	public String getChgCdCmbSeq() {
		return this.chgCdCmbSeq;
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
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
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
	 * @param asetCdCmbSeq
	 */
	public void setAsetCdCmbSeq(String asetCdCmbSeq) {
		this.asetCdCmbSeq = asetCdCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCdCmbSeq
	 */
	public void setChgCdCmbSeq(String chgCdCmbSeq) {
		this.chgCdCmbSeq = chgCdCmbSeq;
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
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAsetCdCmbSeq(JSPUtil.getParameter(request, prefix + "aset_cd_cmb_seq", ""));
		setChgCdCmbSeq(JSPUtil.getParameter(request, prefix + "chg_cd_cmb_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankAcctCmbSeqVO[]
	 */
	public BankAcctCmbSeqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BankAcctCmbSeqVO[]
	 */
	public BankAcctCmbSeqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BankAcctCmbSeqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] asetCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "aset_cd_cmb_seq", length));
			String[] chgCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "chg_cd_cmb_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BankAcctCmbSeqVO();
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (asetCdCmbSeq[i] != null)
					model.setAsetCdCmbSeq(asetCdCmbSeq[i]);
				if (chgCdCmbSeq[i] != null)
					model.setChgCdCmbSeq(chgCdCmbSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBankAcctCmbSeqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BankAcctCmbSeqVO[]
	 */
	public BankAcctCmbSeqVO[] getBankAcctCmbSeqVOs(){
		BankAcctCmbSeqVO[] vos = (BankAcctCmbSeqVO[])models.toArray(new BankAcctCmbSeqVO[models.size()]);
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
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCdCmbSeq = this.asetCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCdCmbSeq = this.chgCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
