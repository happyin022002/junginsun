/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CanalTzFeeBalVO.java
*@FileTitle : CanalTzFeeBalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.22 김진일 
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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanalTzFeeBalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanalTzFeeBalVO> models = new ArrayList<CanalTzFeeBalVO>();
	
	/* Column Info */
	private String amountCreate = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String psoMsaAmtTpCd = null;
	/* Column Info */
	private String amountDebit = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String opflag = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String psoMsaStsCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CanalTzFeeBalVO() {}

	public CanalTzFeeBalVO(String ibflag, String pagerows, String seq, String item, String amountDebit, String amountCreate, String diffRmk, String vndrSeq, String revYrmon, String opflag, String updUsrId, String psoMsaStsCd, String psoMsaAmtTpCd) {
		this.amountCreate = amountCreate;
		this.revYrmon = revYrmon;
		this.psoMsaAmtTpCd = psoMsaAmtTpCd;
		this.amountDebit = amountDebit;
		this.pagerows = pagerows;
		this.opflag = opflag;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.vndrSeq = vndrSeq;
		this.item = item;
		this.psoMsaStsCd = psoMsaStsCd;
		this.seq = seq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amount_create", getAmountCreate());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("pso_msa_amt_tp_cd", getPsoMsaAmtTpCd());
		this.hashColumns.put("amount_debit", getAmountDebit());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("opflag", getOpflag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("pso_msa_sts_cd", getPsoMsaStsCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amount_create", "amountCreate");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("pso_msa_amt_tp_cd", "psoMsaAmtTpCd");
		this.hashFields.put("amount_debit", "amountDebit");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("opflag", "opflag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("item", "item");
		this.hashFields.put("pso_msa_sts_cd", "psoMsaStsCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amountCreate
	 */
	public String getAmountCreate() {
		return this.amountCreate;
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
	 * @return psoMsaAmtTpCd
	 */
	public String getPsoMsaAmtTpCd() {
		return this.psoMsaAmtTpCd;
	}
	
	/**
	 * Column Info
	 * @return amountDebit
	 */
	public String getAmountDebit() {
		return this.amountDebit;
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
	 * @return opflag
	 */
	public String getOpflag() {
		return this.opflag;
	}
	
	/**
	 * Status
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return psoMsaStsCd
	 */
	public String getPsoMsaStsCd() {
		return this.psoMsaStsCd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
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
	 * @param amountCreate
	 */
	public void setAmountCreate(String amountCreate) {
		this.amountCreate = amountCreate;
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
	 * @param psoMsaAmtTpCd
	 */
	public void setPsoMsaAmtTpCd(String psoMsaAmtTpCd) {
		this.psoMsaAmtTpCd = psoMsaAmtTpCd;
	}
	
	/**
	 * Column Info
	 * @param amountDebit
	 */
	public void setAmountDebit(String amountDebit) {
		this.amountDebit = amountDebit;
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
	 * @param opflag
	 */
	public void setOpflag(String opflag) {
		this.opflag = opflag;
	}
	
	/**
	 * Status
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param psoMsaStsCd
	 */
	public void setPsoMsaStsCd(String psoMsaStsCd) {
		this.psoMsaStsCd = psoMsaStsCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAmountCreate(JSPUtil.getParameter(request, "amount_create", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setPsoMsaAmtTpCd(JSPUtil.getParameter(request, "pso_msa_amt_tp_cd", ""));
		setAmountDebit(JSPUtil.getParameter(request, "amount_debit", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOpflag(JSPUtil.getParameter(request, "opflag", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setPsoMsaStsCd(JSPUtil.getParameter(request, "pso_msa_sts_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanalTzFeeBalVO[]
	 */
	public CanalTzFeeBalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanalTzFeeBalVO[]
	 */
	public CanalTzFeeBalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanalTzFeeBalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amountCreate = (JSPUtil.getParameter(request, prefix	+ "amount_create".trim(), length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon".trim(), length));
			String[] psoMsaAmtTpCd = (JSPUtil.getParameter(request, prefix	+ "pso_msa_amt_tp_cd".trim(), length));
			String[] amountDebit = (JSPUtil.getParameter(request, prefix	+ "amount_debit".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] opflag = (JSPUtil.getParameter(request, prefix	+ "opflag".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item".trim(), length));
			String[] psoMsaStsCd = (JSPUtil.getParameter(request, prefix	+ "pso_msa_sts_cd".trim(), length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CanalTzFeeBalVO();
				if (amountCreate[i] != null)
					model.setAmountCreate(amountCreate[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (psoMsaAmtTpCd[i] != null)
					model.setPsoMsaAmtTpCd(psoMsaAmtTpCd[i]);
				if (amountDebit[i] != null)
					model.setAmountDebit(amountDebit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (opflag[i] != null)
					model.setOpflag(opflag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (psoMsaStsCd[i] != null)
					model.setPsoMsaStsCd(psoMsaStsCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanalTzFeeBalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanalTzFeeBalVO[]
	 */
	public CanalTzFeeBalVO[] getCanalTzFeeBalVOs(){
		CanalTzFeeBalVO[] vos = (CanalTzFeeBalVO[])models.toArray(new CanalTzFeeBalVO[models.size()]);
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
		this.amountCreate = this.amountCreate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMsaAmtTpCd = this.psoMsaAmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amountDebit = this.amountDebit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opflag = this.opflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMsaStsCd = this.psoMsaStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
