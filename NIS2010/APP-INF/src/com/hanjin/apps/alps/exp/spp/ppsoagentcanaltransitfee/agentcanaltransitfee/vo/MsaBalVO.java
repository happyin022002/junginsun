/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MsaBalVO.java
*@FileTitle : MsaBalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김성광
*@LastVersion : 1.0
* 2009.08.20 김성광 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.vo;

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
 * @author 김성광
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MsaBalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MsaBalVO> models = new ArrayList<MsaBalVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String psoMsaAmtTpCd = null;
	/* Column Info */
	private String psoMsaStsCd = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String msaSeq = null;
	/* Column Info */
	private String amountCredit = null;
	/* Column Info */
	private String amountDebit = null;
	/* Column Info */
	private String exist = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MsaBalVO() {}

	public MsaBalVO(String ibflag, String pagerows, String msaSeq, String psoMsaAmtTpCd, String item, String amountDebit, String amountCredit, String diffRmk, String revYrmon, String vndrSeq, String psoMsaStsCd, String exist) {
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.revYrmon = revYrmon;
		this.vndrSeq = vndrSeq;
		this.psoMsaAmtTpCd = psoMsaAmtTpCd;
		this.psoMsaStsCd = psoMsaStsCd;
		this.item = item;
		this.msaSeq = msaSeq;
		this.amountCredit = amountCredit;
		this.amountDebit = amountDebit;
		this.exist = exist;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pso_msa_amt_tp_cd", getPsoMsaAmtTpCd());
		this.hashColumns.put("pso_msa_sts_cd", getPsoMsaStsCd());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("msa_seq", getMsaSeq());
		this.hashColumns.put("amount_credit", getAmountCredit());
		this.hashColumns.put("amount_debit", getAmountDebit());
		this.hashColumns.put("exist", getExist());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pso_msa_amt_tp_cd", "psoMsaAmtTpCd");
		this.hashFields.put("pso_msa_sts_cd", "psoMsaStsCd");
		this.hashFields.put("item", "item");
		this.hashFields.put("msa_seq", "msaSeq");
		this.hashFields.put("amount_credit", "amountCredit");
		this.hashFields.put("amount_debit", "amountDebit");
		this.hashFields.put("exist", "exist");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return psoMsaAmtTpCd
	 */
	public String getPsoMsaAmtTpCd() {
		return this.psoMsaAmtTpCd;
	}
	
	/**
	 * Column Info
	 * @return psoMsaStsCd
	 */
	public String getPsoMsaStsCd() {
		return this.psoMsaStsCd;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return msaSeq
	 */
	public String getMsaSeq() {
		return this.msaSeq;
	}
	
	/**
	 * Column Info
	 * @return amountCredit
	 */
	public String getAmountCredit() {
		return this.amountCredit;
	}
	
	/**
	 * Column Info
	 * @return amountDebit
	 */
	public String getAmountDebit() {
		return this.amountDebit;
	}
	
	/**
	 * Column Info
	 * @return exist
	 */
	public String getExist() {
		return this.exist;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param psoMsaAmtTpCd
	 */
	public void setPsoMsaAmtTpCd(String psoMsaAmtTpCd) {
		this.psoMsaAmtTpCd = psoMsaAmtTpCd;
	}
	
	/**
	 * Column Info
	 * @param psoMsaStsCd
	 */
	public void setPsoMsaStsCd(String psoMsaStsCd) {
		this.psoMsaStsCd = psoMsaStsCd;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param msaSeq
	 */
	public void setMsaSeq(String msaSeq) {
		this.msaSeq = msaSeq;
	}
	
	/**
	 * Column Info
	 * @param amountCredit
	 */
	public void setAmountCredit(String amountCredit) {
		this.amountCredit = amountCredit;
	}
	
	/**
	 * Column Info
	 * @param amountDebit
	 */
	public void setAmountDebit(String amountDebit) {
		this.amountDebit = amountDebit;
	}
	
	/**
	 * Column Info
	 * @param exist
	 */
	public void setExist(String exist) {
		this.exist = exist;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setPsoMsaAmtTpCd(JSPUtil.getParameter(request, "pso_msa_amt_tp_cd", ""));
		setPsoMsaStsCd(JSPUtil.getParameter(request, "pso_msa_sts_cd", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setMsaSeq(JSPUtil.getParameter(request, "msa_seq", ""));
		setAmountCredit(JSPUtil.getParameter(request, "amount_credit", ""));
		setAmountDebit(JSPUtil.getParameter(request, "amount_debit", ""));
		setExist(JSPUtil.getParameter(request, "exist", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MsaBalVO[]
	 */
	public MsaBalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MsaBalVO[]
	 */
	public MsaBalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MsaBalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] psoMsaAmtTpCd = (JSPUtil.getParameter(request, prefix	+ "pso_msa_amt_tp_cd", length));
			String[] psoMsaStsCd = (JSPUtil.getParameter(request, prefix	+ "pso_msa_sts_cd", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] msaSeq = (JSPUtil.getParameter(request, prefix	+ "msa_seq", length));
			String[] amountCredit = (JSPUtil.getParameter(request, prefix	+ "amount_credit", length));
			String[] amountDebit = (JSPUtil.getParameter(request, prefix	+ "amount_debit", length));
			String[] exist = (JSPUtil.getParameter(request, prefix	+ "exist", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MsaBalVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (psoMsaAmtTpCd[i] != null)
					model.setPsoMsaAmtTpCd(psoMsaAmtTpCd[i]);
				if (psoMsaStsCd[i] != null)
					model.setPsoMsaStsCd(psoMsaStsCd[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (msaSeq[i] != null)
					model.setMsaSeq(msaSeq[i]);
				if (amountCredit[i] != null)
					model.setAmountCredit(amountCredit[i]);
				if (amountDebit[i] != null)
					model.setAmountDebit(amountDebit[i]);
				if (exist[i] != null)
					model.setExist(exist[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMsaBalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MsaBalVO[]
	 */
	public MsaBalVO[] getMsaBalVOs(){
		MsaBalVO[] vos = (MsaBalVO[])models.toArray(new MsaBalVO[models.size()]);
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
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMsaAmtTpCd = this.psoMsaAmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMsaStsCd = this.psoMsaStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msaSeq = this.msaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountCredit = this.amountCredit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountDebit = this.amountDebit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exist = this.exist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
