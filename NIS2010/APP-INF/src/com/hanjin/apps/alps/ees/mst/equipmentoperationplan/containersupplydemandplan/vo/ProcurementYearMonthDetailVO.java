/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProcurementYearMonthDetailVO.java
*@FileTitle : ProcurementYearMonthDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.24 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ProcurementYearMonthDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProcurementYearMonthDetailVO> models = new ArrayList<ProcurementYearMonthDetailVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n10 = null;
	/* Column Info */
	private String cntrProcuPlnCd = null;
	/* Column Info */
	private String n1 = null;
	/* Column Info */
	private String n12 = null;
	/* Column Info */
	private String n11 = null;
	/* Column Info */
	private String n5 = null;
	/* Column Info */
	private String n4 = null;
	/* Column Info */
	private String n3 = null;
	/* Column Info */
	private String n2 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n9 = null;
	/* Column Info */
	private String n8 = null;
	/* Column Info */
	private String n7 = null;
	/* Column Info */
	private String tpszLev = null;
	/* Column Info */
	private String n6 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpLev = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProcurementYearMonthDetailVO() {}

	public ProcurementYearMonthDetailVO(String ibflag, String pagerows, String plnYr, String cntrTpszCd, String cntrProcuPlnCd, String n1, String n2, String n3, String n4, String n5, String n6, String n7, String n8, String n9, String n10, String n11, String n12, String creUsrId, String creDt, String updUsrId, String updDt, String tpszLev, String tpLev) {
		this.updDt = updDt;
		this.n10 = n10;
		this.cntrProcuPlnCd = cntrProcuPlnCd;
		this.n1 = n1;
		this.n12 = n12;
		this.n11 = n11;
		this.n5 = n5;
		this.n4 = n4;
		this.n3 = n3;
		this.n2 = n2;
		this.creDt = creDt;
		this.n9 = n9;
		this.n8 = n8;
		this.n7 = n7;
		this.tpszLev = tpszLev;
		this.n6 = n6;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.tpLev = tpLev;
		this.plnYr = plnYr;
		this.cntrTpszCd = cntrTpszCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n10", getN10());
		this.hashColumns.put("cntr_procu_pln_cd", getCntrProcuPlnCd());
		this.hashColumns.put("n1", getN1());
		this.hashColumns.put("n12", getN12());
		this.hashColumns.put("n11", getN11());
		this.hashColumns.put("n5", getN5());
		this.hashColumns.put("n4", getN4());
		this.hashColumns.put("n3", getN3());
		this.hashColumns.put("n2", getN2());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n9", getN9());
		this.hashColumns.put("n8", getN8());
		this.hashColumns.put("n7", getN7());
		this.hashColumns.put("tpsz_lev", getTpszLev());
		this.hashColumns.put("n6", getN6());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tp_lev", getTpLev());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n10", "n10");
		this.hashFields.put("cntr_procu_pln_cd", "cntrProcuPlnCd");
		this.hashFields.put("n1", "n1");
		this.hashFields.put("n12", "n12");
		this.hashFields.put("n11", "n11");
		this.hashFields.put("n5", "n5");
		this.hashFields.put("n4", "n4");
		this.hashFields.put("n3", "n3");
		this.hashFields.put("n2", "n2");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n9", "n9");
		this.hashFields.put("n8", "n8");
		this.hashFields.put("n7", "n7");
		this.hashFields.put("tpsz_lev", "tpszLev");
		this.hashFields.put("n6", "n6");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tp_lev", "tpLev");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return n10
	 */
	public String getN10() {
		return this.n10;
	}
	
	/**
	 * Column Info
	 * @return cntrProcuPlnCd
	 */
	public String getCntrProcuPlnCd() {
		return this.cntrProcuPlnCd;
	}
	
	/**
	 * Column Info
	 * @return n1
	 */
	public String getN1() {
		return this.n1;
	}
	
	/**
	 * Column Info
	 * @return n12
	 */
	public String getN12() {
		return this.n12;
	}
	
	/**
	 * Column Info
	 * @return n11
	 */
	public String getN11() {
		return this.n11;
	}
	
	/**
	 * Column Info
	 * @return n5
	 */
	public String getN5() {
		return this.n5;
	}
	
	/**
	 * Column Info
	 * @return n4
	 */
	public String getN4() {
		return this.n4;
	}
	
	/**
	 * Column Info
	 * @return n3
	 */
	public String getN3() {
		return this.n3;
	}
	
	/**
	 * Column Info
	 * @return n2
	 */
	public String getN2() {
		return this.n2;
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
	 * @return n9
	 */
	public String getN9() {
		return this.n9;
	}
	
	/**
	 * Column Info
	 * @return n8
	 */
	public String getN8() {
		return this.n8;
	}
	
	/**
	 * Column Info
	 * @return n7
	 */
	public String getN7() {
		return this.n7;
	}
	
	/**
	 * Column Info
	 * @return tpszLev
	 */
	public String getTpszLev() {
		return this.tpszLev;
	}
	
	/**
	 * Column Info
	 * @return n6
	 */
	public String getN6() {
		return this.n6;
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
	 * @return tpLev
	 */
	public String getTpLev() {
		return this.tpLev;
	}
	
	/**
	 * Column Info
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param n10
	 */
	public void setN10(String n10) {
		this.n10 = n10;
	}
	
	/**
	 * Column Info
	 * @param cntrProcuPlnCd
	 */
	public void setCntrProcuPlnCd(String cntrProcuPlnCd) {
		this.cntrProcuPlnCd = cntrProcuPlnCd;
	}
	
	/**
	 * Column Info
	 * @param n1
	 */
	public void setN1(String n1) {
		this.n1 = n1;
	}
	
	/**
	 * Column Info
	 * @param n12
	 */
	public void setN12(String n12) {
		this.n12 = n12;
	}
	
	/**
	 * Column Info
	 * @param n11
	 */
	public void setN11(String n11) {
		this.n11 = n11;
	}
	
	/**
	 * Column Info
	 * @param n5
	 */
	public void setN5(String n5) {
		this.n5 = n5;
	}
	
	/**
	 * Column Info
	 * @param n4
	 */
	public void setN4(String n4) {
		this.n4 = n4;
	}
	
	/**
	 * Column Info
	 * @param n3
	 */
	public void setN3(String n3) {
		this.n3 = n3;
	}
	
	/**
	 * Column Info
	 * @param n2
	 */
	public void setN2(String n2) {
		this.n2 = n2;
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
	 * @param n9
	 */
	public void setN9(String n9) {
		this.n9 = n9;
	}
	
	/**
	 * Column Info
	 * @param n8
	 */
	public void setN8(String n8) {
		this.n8 = n8;
	}
	
	/**
	 * Column Info
	 * @param n7
	 */
	public void setN7(String n7) {
		this.n7 = n7;
	}
	
	/**
	 * Column Info
	 * @param tpszLev
	 */
	public void setTpszLev(String tpszLev) {
		this.tpszLev = tpszLev;
	}
	
	/**
	 * Column Info
	 * @param n6
	 */
	public void setN6(String n6) {
		this.n6 = n6;
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
	 * @param tpLev
	 */
	public void setTpLev(String tpLev) {
		this.tpLev = tpLev;
	}
	
	/**
	 * Column Info
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN10(JSPUtil.getParameter(request, "n10", ""));
		setCntrProcuPlnCd(JSPUtil.getParameter(request, "cntr_procu_pln_cd", ""));
		setN1(JSPUtil.getParameter(request, "n1", ""));
		setN12(JSPUtil.getParameter(request, "n12", ""));
		setN11(JSPUtil.getParameter(request, "n11", ""));
		setN5(JSPUtil.getParameter(request, "n5", ""));
		setN4(JSPUtil.getParameter(request, "n4", ""));
		setN3(JSPUtil.getParameter(request, "n3", ""));
		setN2(JSPUtil.getParameter(request, "n2", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN9(JSPUtil.getParameter(request, "n9", ""));
		setN8(JSPUtil.getParameter(request, "n8", ""));
		setN7(JSPUtil.getParameter(request, "n7", ""));
		setTpszLev(JSPUtil.getParameter(request, "tpsz_lev", ""));
		setN6(JSPUtil.getParameter(request, "n6", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpLev(JSPUtil.getParameter(request, "tp_lev", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProcurementYearMonthDetailVO[]
	 */
	public ProcurementYearMonthDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProcurementYearMonthDetailVO[]
	 */
	public ProcurementYearMonthDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProcurementYearMonthDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n10 = (JSPUtil.getParameter(request, prefix	+ "n10", length));
			String[] cntrProcuPlnCd = (JSPUtil.getParameter(request, prefix	+ "cntr_procu_pln_cd", length));
			String[] n1 = (JSPUtil.getParameter(request, prefix	+ "n1", length));
			String[] n12 = (JSPUtil.getParameter(request, prefix	+ "n12", length));
			String[] n11 = (JSPUtil.getParameter(request, prefix	+ "n11", length));
			String[] n5 = (JSPUtil.getParameter(request, prefix	+ "n5", length));
			String[] n4 = (JSPUtil.getParameter(request, prefix	+ "n4", length));
			String[] n3 = (JSPUtil.getParameter(request, prefix	+ "n3", length));
			String[] n2 = (JSPUtil.getParameter(request, prefix	+ "n2", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n9 = (JSPUtil.getParameter(request, prefix	+ "n9", length));
			String[] n8 = (JSPUtil.getParameter(request, prefix	+ "n8", length));
			String[] n7 = (JSPUtil.getParameter(request, prefix	+ "n7", length));
			String[] tpszLev = (JSPUtil.getParameter(request, prefix	+ "tpsz_lev", length));
			String[] n6 = (JSPUtil.getParameter(request, prefix	+ "n6", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpLev = (JSPUtil.getParameter(request, prefix	+ "tp_lev", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProcurementYearMonthDetailVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n10[i] != null)
					model.setN10(n10[i]);
				if (cntrProcuPlnCd[i] != null)
					model.setCntrProcuPlnCd(cntrProcuPlnCd[i]);
				if (n1[i] != null)
					model.setN1(n1[i]);
				if (n12[i] != null)
					model.setN12(n12[i]);
				if (n11[i] != null)
					model.setN11(n11[i]);
				if (n5[i] != null)
					model.setN5(n5[i]);
				if (n4[i] != null)
					model.setN4(n4[i]);
				if (n3[i] != null)
					model.setN3(n3[i]);
				if (n2[i] != null)
					model.setN2(n2[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n9[i] != null)
					model.setN9(n9[i]);
				if (n8[i] != null)
					model.setN8(n8[i]);
				if (n7[i] != null)
					model.setN7(n7[i]);
				if (tpszLev[i] != null)
					model.setTpszLev(tpszLev[i]);
				if (n6[i] != null)
					model.setN6(n6[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpLev[i] != null)
					model.setTpLev(tpLev[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProcurementYearMonthDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProcurementYearMonthDetailVO[]
	 */
	public ProcurementYearMonthDetailVO[] getProcurementYearMonthDetailVOs(){
		ProcurementYearMonthDetailVO[] vos = (ProcurementYearMonthDetailVO[])models.toArray(new ProcurementYearMonthDetailVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n10 = this.n10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrProcuPlnCd = this.cntrProcuPlnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1 = this.n1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n12 = this.n12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n11 = this.n11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5 = this.n5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4 = this.n4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3 = this.n3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2 = this.n2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n9 = this.n9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n8 = this.n8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n7 = this.n7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszLev = this.tpszLev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6 = this.n6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpLev = this.tpLev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
