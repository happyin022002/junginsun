/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0123ConditionVO.java
*@FileTitle : EesEqr0123ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           			modifier date    explanation
* 1		1.0		Lee Byoung Hun		2009.07.10		1.0 최초 생성
*
*@LastModifyDate : 2009.07.10
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0123ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0123ConditionVO> models = new ArrayList<EesEqr0123ConditionVO>();
	
	/* Column Info */
	private String toTypeBy = null;
	/* Column Info */
	private String fmToAt = null;
	/* Column Info */
	private String toEccCd = null;
	/* Column Info */
	private String fmPlnYr = null;
	/* Column Info */
	private String toType = null;
	/* Column Info */
	private String atEccCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String atType = null;
	/* Column Info */
	private String atTypeBy = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String s1Ibflag = null;
	/* Column Info */
	private String fmEccCd = null;
	/* Column Info */
	private String monthWeek = null;
	/* Column Info */
	private String fmType = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String atPlnYr = null;
	/* Column Info */
	private String fmTypeBy = null;
	/* Column Info */
	private String s1RccCd = null;
	
	private List<String> month = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0123ConditionVO() {}

	public EesEqr0123ConditionVO(String ibflag, String pagerows, String fmToAt, String fmType, String fmEccCd, String fmTypeBy, String fmPlnYr, String toType, String toEccCd, String toTypeBy, String atType, String atEccCd, String atTypeBy, String atPlnYr, String cntrTpszCd, String monthWeek, String s1RccCd, String s1Ibflag) {
		this.toTypeBy = toTypeBy;
		this.fmToAt = fmToAt;
		this.toEccCd = toEccCd;
		this.fmPlnYr = fmPlnYr;
		this.toType = toType;
		this.atEccCd = atEccCd;
		this.pagerows = pagerows;
		this.atType = atType;
		this.atTypeBy = atTypeBy;
		this.ibflag = ibflag;
		this.fmEccCd = fmEccCd;
		this.monthWeek = monthWeek;
		this.fmType = fmType;
		this.cntrTpszCd = cntrTpszCd;
		this.atPlnYr = atPlnYr;
		this.fmTypeBy = fmTypeBy;
		this.s1RccCd = s1RccCd;
		this.s1Ibflag = s1Ibflag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_type_by", getToTypeBy());
		this.hashColumns.put("fm_to_at", getFmToAt());
		this.hashColumns.put("to_ecc_cd", getToEccCd());
		this.hashColumns.put("fm_pln_yr", getFmPlnYr());
		this.hashColumns.put("to_type", getToType());
		this.hashColumns.put("at_ecc_cd", getAtEccCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("at_type", getAtType());
		this.hashColumns.put("at_type_by", getAtTypeBy());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_ecc_cd", getFmEccCd());
		this.hashColumns.put("month_week", getMonthWeek());
		this.hashColumns.put("fm_type", getFmType());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("at_pln_yr", getAtPlnYr());
		this.hashColumns.put("fm_type_by", getFmTypeBy());
		this.hashColumns.put("s1_rcc_cd", getS1RccCd());
		this.hashColumns.put("s1_ibflag", getS1Ibflag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_type_by", "toTypeBy");
		this.hashFields.put("fm_to_at", "fmToAt");
		this.hashFields.put("to_ecc_cd", "toEccCd");
		this.hashFields.put("fm_pln_yr", "fmPlnYr");
		this.hashFields.put("to_type", "toType");
		this.hashFields.put("at_ecc_cd", "atEccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("at_type", "atType");
		this.hashFields.put("at_type_by", "atTypeBy");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_ecc_cd", "fmEccCd");
		this.hashFields.put("month_week", "monthWeek");
		this.hashFields.put("fm_type", "fmType");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("at_pln_yr", "atPlnYr");
		this.hashFields.put("fm_type_by", "fmTypeBy");
		this.hashFields.put("s1_rcc_cd", "s1RccCd");
		this.hashFields.put("s1_ibflag", "s1Ibflag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toTypeBy
	 */
	public String getToTypeBy() {
		return this.toTypeBy;
	}
	
	/**
	 * Column Info
	 * @return fmToAt
	 */
	public String getFmToAt() {
		return this.fmToAt;
	}
	
	/**
	 * Column Info
	 * @return toEccCd
	 */
	public String getToEccCd() {
		return this.toEccCd;
	}
	
	/**
	 * Column Info
	 * @return fmPlnYr
	 */
	public String getFmPlnYr() {
		return this.fmPlnYr;
	}
	
	/**
	 * Column Info
	 * @return toType
	 */
	public String getToType() {
		return this.toType;
	}
	
	/**
	 * Column Info
	 * @return atEccCd
	 */
	public String getAtEccCd() {
		return this.atEccCd;
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
	 * @return atType
	 */
	public String getAtType() {
		return this.atType;
	}
	
	/**
	 * Column Info
	 * @return atTypeBy
	 */
	public String getAtTypeBy() {
		return this.atTypeBy;
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
	 * @return fmEccCd
	 */
	public String getFmEccCd() {
		return this.fmEccCd;
	}
	
	/**
	 * Column Info
	 * @return monthWeek
	 */
	public String getMonthWeek() {
		return this.monthWeek;
	}
	
	/**
	 * Column Info
	 * @return fmType
	 */
	public String getFmType() {
		return this.fmType;
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
	 * @return atPlnYr
	 */
	public String getAtPlnYr() {
		return this.atPlnYr;
	}
	
	/**
	 * Column Info
	 * @return fmTypeBy
	 */
	public String getFmTypeBy() {
		return this.fmTypeBy;
	}
	
	/**
	 * Column Info
	 * @return fmTypeBy
	 */
	public String getS1RccCd() {
		return this.s1RccCd;
	}
	
	/**
	 * Column Info
	 * @return fmTypeBy
	 */
	public String getS1Ibflag() {
		return this.s1Ibflag;
	}
	
	/**
	 * Column Info
	 * @return fmTypeBy
	 */
	public List<String> getMonth() {
		return this.month;
	}

	/**
	 * Column Info
	 * @param toTypeBy
	 */
	public void setToTypeBy(String toTypeBy) {
		this.toTypeBy = toTypeBy;
	}
	
	/**
	 * Column Info
	 * @param fmToAt
	 */
	public void setFmToAt(String fmToAt) {
		this.fmToAt = fmToAt;
	}
	
	/**
	 * Column Info
	 * @param toEccCd
	 */
	public void setToEccCd(String toEccCd) {
		this.toEccCd = toEccCd;
	}
	
	/**
	 * Column Info
	 * @param fmPlnYr
	 */
	public void setFmPlnYr(String fmPlnYr) {
		this.fmPlnYr = fmPlnYr;
	}
	
	/**
	 * Column Info
	 * @param toType
	 */
	public void setToType(String toType) {
		this.toType = toType;
	}
	
	/**
	 * Column Info
	 * @param atEccCd
	 */
	public void setAtEccCd(String atEccCd) {
		this.atEccCd = atEccCd;
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
	 * @param atType
	 */
	public void setAtType(String atType) {
		this.atType = atType;
	}
	
	/**
	 * Column Info
	 * @param atTypeBy
	 */
	public void setAtTypeBy(String atTypeBy) {
		this.atTypeBy = atTypeBy;
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
	 * @param fmEccCd
	 */
	public void setFmEccCd(String fmEccCd) {
		this.fmEccCd = fmEccCd;
	}
	
	/**
	 * Column Info
	 * @param monthWeek
	 */
	public void setMonthWeek(String monthWeek) {
		this.monthWeek = monthWeek;
	}
	
	/**
	 * Column Info
	 * @param fmType
	 */
	public void setFmType(String fmType) {
		this.fmType = fmType;
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
	 * @param atPlnYr
	 */
	public void setAtPlnYr(String atPlnYr) {
		this.atPlnYr = atPlnYr;
	}
	
	/**
	 * Column Info
	 * @param fmTypeBy
	 */
	public void setFmTypeBy(String fmTypeBy) {
		this.fmTypeBy = fmTypeBy;
	}
	
	/**
	 * Column Info
	 * @param fmTypeBy
	 */
	public void setS1RccCd(String s1RccCd) {
		this.s1RccCd = s1RccCd;
	}
	
	/**
	 * Column Info
	 * @param fmTypeBy
	 */
	public void setS1Ibflag(String s1Ibflag) {
		this.s1Ibflag = s1Ibflag;
	}
	
	/**
	 * Column Info
	 * @param fmTypeBy
	 */
	public void setMonth(List<String> month) {
		this.month = month;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToTypeBy(JSPUtil.getParameter(request, "toTypeBy", ""));
		setFmToAt(JSPUtil.getParameter(request, "fmToAt", ""));
		setToEccCd(JSPUtil.getParameter(request, "toEccCd", ""));
		setFmPlnYr(JSPUtil.getParameter(request, "fmPlnYr", ""));
		setToType(JSPUtil.getParameter(request, "toType", ""));
		setAtEccCd(JSPUtil.getParameter(request, "atEccCd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAtType(JSPUtil.getParameter(request, "atType", ""));
		setAtTypeBy(JSPUtil.getParameter(request, "atTypeBy", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmEccCd(JSPUtil.getParameter(request, "fmEccCd", ""));
		setMonthWeek(JSPUtil.getParameter(request, "monthWeek", ""));
		setFmType(JSPUtil.getParameter(request, "fmType", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntrTpszCd", ""));
		setAtPlnYr(JSPUtil.getParameter(request, "atPlnYr", ""));
		setFmTypeBy(JSPUtil.getParameter(request, "fmTypeBy", ""));
		setS1RccCd(JSPUtil.getParameter(request, "s1_rcc_cd", ""));
		setS1Ibflag(JSPUtil.getParameter(request, "s1_ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr123ConditionVO[]
	 */
	public EesEqr0123ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr123ConditionVO[]
	 */
	public EesEqr0123ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0123ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toTypeBy = (JSPUtil.getParameter(request, prefix	+ "to_type_by", length));
			String[] fmToAt = (JSPUtil.getParameter(request, prefix	+ "fm_to_at", length));
			String[] toEccCd = (JSPUtil.getParameter(request, prefix	+ "to_ecc_cd", length));
			String[] fmPlnYr = (JSPUtil.getParameter(request, prefix	+ "fm_pln_yr", length));
			String[] toType = (JSPUtil.getParameter(request, prefix	+ "to_type", length));
			String[] atEccCd = (JSPUtil.getParameter(request, prefix	+ "at_ecc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] atType = (JSPUtil.getParameter(request, prefix	+ "at_type", length));
			String[] atTypeBy = (JSPUtil.getParameter(request, prefix	+ "at_type_by", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmEccCd = (JSPUtil.getParameter(request, prefix	+ "fm_ecc_cd", length));
			String[] monthWeek = (JSPUtil.getParameter(request, prefix	+ "month_week", length));
			String[] fmType = (JSPUtil.getParameter(request, prefix	+ "fm_type", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] atPlnYr = (JSPUtil.getParameter(request, prefix	+ "at_pln_yr", length));
			String[] fmTypeBy = (JSPUtil.getParameter(request, prefix	+ "fm_type_by", length));
			String[] s1RccCd = (JSPUtil.getParameter(request, prefix	+ "s1_rcc_cd", length));
			String[] s1Ibflag = (JSPUtil.getParameter(request, prefix	+ "s1_ibflag", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0123ConditionVO();
				if (toTypeBy[i] != null)
					model.setToTypeBy(toTypeBy[i]);
				if (fmToAt[i] != null)
					model.setFmToAt(fmToAt[i]);
				if (toEccCd[i] != null)
					model.setToEccCd(toEccCd[i]);
				if (fmPlnYr[i] != null)
					model.setFmPlnYr(fmPlnYr[i]);
				if (toType[i] != null)
					model.setToType(toType[i]);
				if (atEccCd[i] != null)
					model.setAtEccCd(atEccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atType[i] != null)
					model.setAtType(atType[i]);
				if (atTypeBy[i] != null)
					model.setAtTypeBy(atTypeBy[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmEccCd[i] != null)
					model.setFmEccCd(fmEccCd[i]);
				if (monthWeek[i] != null)
					model.setMonthWeek(monthWeek[i]);
				if (fmType[i] != null)
					model.setFmType(fmType[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (atPlnYr[i] != null)
					model.setAtPlnYr(atPlnYr[i]);
				if (fmTypeBy[i] != null)
					model.setFmTypeBy(fmTypeBy[i]);
				if (s1RccCd[i] != null)
					model.setS1RccCd(s1RccCd[i]);
				if (s1Ibflag[i] != null)
					model.setS1Ibflag(s1Ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr123ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr123ConditionVO[]
	 */
	public EesEqr0123ConditionVO[] getEesEqr123ConditionVOs(){
		EesEqr0123ConditionVO[] vos = (EesEqr0123ConditionVO[])models.toArray(new EesEqr0123ConditionVO[models.size()]);
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
		this.toTypeBy = this.toTypeBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmToAt = this.fmToAt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEccCd = this.toEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPlnYr = this.fmPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toType = this.toType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atEccCd = this.atEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atType = this.atType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atTypeBy = this.atTypeBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEccCd = this.fmEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monthWeek = this.monthWeek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmType = this.fmType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atPlnYr = this.atPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTypeBy = this.fmTypeBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s1RccCd = this.s1RccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s1Ibflag = this.s1Ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
