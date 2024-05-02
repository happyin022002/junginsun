/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpensePlanVO.java
*@FileTitle : ExpensePlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.25 장준우 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see ..
 */
public class ExpensePlanVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private Collection<ExpensePlanVO> models = new ArrayList<ExpensePlanVO>();
	
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo");
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String plnSeq = null;
	/* Column Info */
	private String verSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqTermNm = null;
	/* Column Info */
	private String expnMonCd = null;
	/* Column Info */
	private String expnAmt = null;	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Sequence Number */
	private String insertSeq = null;
	
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public ExpensePlanVO() {}
	
	/**
	 * Constructor
	 */
	public ExpensePlanVO(String ibflag, String plnYr, String plnSeq, String verSeq,
			String eqKndCd, String eqTermNm, String expnMonCd, String expnAmt,
			String creUsrId, String updUsrId, String pagerows, String insertSeq) {
		this.ibflag = ibflag;
		this.plnYr = plnYr;
		this.plnSeq = plnSeq;
		this.verSeq = verSeq;
		this.eqKndCd = eqKndCd;
		this.eqTermNm = eqTermNm;
		this.expnMonCd = expnMonCd;
		this.expnAmt = expnAmt;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.insertSeq = insertSeq;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("pln_seq", getPlnSeq());
		this.hashColumns.put("ver_seq", getVerSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_term_nm", getEqTermNm());
		this.hashColumns.put("expn_mon_cd", getExpnMonCd());
		this.hashColumns.put("expn_amt", getExpnAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("insert_seq", getInsertSeq());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");		
		this.hashFields.put("pln_yr", "plnYr");		
		this.hashFields.put("pln_seq", "plnSeq");
		this.hashFields.put("ver_seq", "verSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_term_nm", "eqTermNm");
		this.hashFields.put("expn_mon_cd", "expnMonCd");
		this.hashFields.put("expn_amt", "expnAmt");	
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("insert_seq", "insertSeq");		
		return this.hashFields;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setPlnSeq(JSPUtil.getParameter(request, "pln_seq", ""));
		setVerSeq(JSPUtil.getParameter(request, "ver_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqTermNm(JSPUtil.getParameter(request, "eq_term_nm", ""));
		setExpnMonCd(JSPUtil.getParameter(request, "expn_mon_cd", ""));
		setExpnAmt(JSPUtil.getParameter(request, "expn_amt", ""));		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInsertSeq(JSPUtil.getParameter(request, "insert_seq", ""));
	}
	
	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public ExpensePlanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public ExpensePlanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExpensePlanVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] plnSeq = (JSPUtil.getParameter(request, prefix	+ "pln_seq".trim(), length));
			String[] verSeq = (JSPUtil.getParameter(request, prefix	+ "ver_seq".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] eqTermNm = (JSPUtil.getParameter(request, prefix	+ "eq_term_nm".trim(), length));
			String[] expnMonCd = (JSPUtil.getParameter(request, prefix	+ "expn_mon_cd".trim(), length));
			String[] expnAmt = (JSPUtil.getParameter(request, prefix	+ "expn_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] insertSeq = (JSPUtil.getParameter(request, prefix	+ "insert_seq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExpensePlanVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnSeq[i] != null)
					model.setPlnSeq(plnSeq[i]);
				if (verSeq[i] != null)
					model.setVerSeq(verSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqTermNm[i] != null)
					model.setEqTermNm(eqTermNm[i]);
				if (expnMonCd[i] != null)
					model.setExpnMonCd(expnMonCd[i]);
				if (expnAmt[i] != null)
					model.setExpnAmt(expnAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (insertSeq[i] != null)
					model.setInsertSeq(insertSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getExpensePlanVOs();
	}

	public ExpensePlanVO[] getExpensePlanVOs(){
		ExpensePlanVO[] vos = (ExpensePlanVO[])models.toArray(new ExpensePlanVO[models.size()]);
		return vos;
	}
	
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
			log.error(ex.getMessage(), ex);
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * @return the plnYr
	 */
	public String getPlnYr() {
		return plnYr;
	}

	/**
	 * @param plnYr the plnYr to set
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}

	/**
	 * @return the plnSeq
	 */
	public String getPlnSeq() {
		return plnSeq;
	}

	/**
	 * @param plnSeq the plnSeq to set
	 */
	public void setPlnSeq(String plnSeq) {
		this.plnSeq = plnSeq;
	}

	/**
	 * @return the verSeq
	 */
	public String getVerSeq() {
		return verSeq;
	}

	/**
	 * @param verSeq the verSeq to set
	 */
	public void setVerSeq(String verSeq) {
		this.verSeq = verSeq;
	}

	/**
	 * @return the eqKndCd
	 */
	public String getEqKndCd() {
		return eqKndCd;
	}

	/**
	 * @param eqKndCd the eqKndCd to set
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}

	/**
	 * @return the eqTermNm
	 */
	public String getEqTermNm() {
		return eqTermNm;
	}

	/**
	 * @param eqTermNm the eqTermNm to set
	 */
	public void setEqTermNm(String eqTermNm) {
		this.eqTermNm = eqTermNm;
	}

	/**
	 * @return the expnMonCd
	 */
	public String getExpnMonCd() {
		return expnMonCd;
	}

	/**
	 * @param expnMonCd the expnMonCd to set
	 */
	public void setExpnMonCd(String expnMonCd) {
		this.expnMonCd = expnMonCd;
	}

	/**
	 * @return the expnAmt
	 */
	public String getExpnAmt() {
		return expnAmt;
	}

	/**
	 * @param expnAmt the expnAmt to set
	 */
	public void setExpnAmt(String expnAmt) {
		this.expnAmt = expnAmt;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return the pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * 
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * @return the insertSeq
	 */
	public String getInsertSeq() {
		return insertSeq;
	}

	/**
	 * @param insertSeq the insertSeq to set
	 */
	public void setInsertSeq(String insertSeq) {
		this.insertSeq = insertSeq;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnSeq = this.plnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.verSeq = this.verSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTermNm = this.eqTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.expnMonCd = this.expnMonCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.expnAmt = this.expnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insertSeq = this.insertSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}