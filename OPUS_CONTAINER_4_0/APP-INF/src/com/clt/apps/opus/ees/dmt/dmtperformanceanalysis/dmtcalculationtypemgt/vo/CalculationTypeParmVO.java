/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CalculationTypeParmVO.java
*@FileTitle : CalculationTypeParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.16 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 황효근
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class CalculationTypeParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CalculationTypeParmVO> models = new ArrayList<CalculationTypeParmVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String dmdtCalcTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String calcTpSeq = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String valCurr = null;
	/* Column Info */
	private String valTobe = null;
	/* Column Info */
	private String valExp = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CalculationTypeParmVO() {}

	public CalculationTypeParmVO(String ibflag, String pagerows, String calcTpSeq, String cntCd, String rgnCd, String steCd, String locCd, String ioBndCd, String dmdtCalcTpCd, String effDt, String expDt, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String valCurr, String valTobe, String valExp) {
		this.updDt = updDt;
		this.rgnCd = rgnCd;
		this.valCurr = valCurr;
		this.dmdtCalcTpCd = dmdtCalcTpCd;
		this.creDt = creDt;
		this.valTobe = valTobe;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.calcTpSeq = calcTpSeq;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.effDt = effDt;
		this.creUsrId = creUsrId;
		this.valExp = valExp;
		this.creOfcCd = creOfcCd;
		this.cntCd = cntCd;
		this.expDt = expDt;
		this.steCd = steCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("val_curr", getValCurr());
		this.hashColumns.put("dmdt_calc_tp_cd", getDmdtCalcTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("val_tobe", getValTobe());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("calc_tp_seq", getCalcTpSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("val_exp", getValExp());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("val_curr", "valCurr");
		this.hashFields.put("dmdt_calc_tp_cd", "dmdtCalcTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("val_tobe", "valTobe");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("calc_tp_seq", "calcTpSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("val_exp", "valExp");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
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
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return valCurr
	 */
	public String getValCurr() {
		return this.valCurr;
	}
	
	/**
	 * Column Info
	 * @return dmdtCalcTpCd
	 */
	public String getDmdtCalcTpCd() {
		return this.dmdtCalcTpCd;
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
	 * @return valTobe
	 */
	public String getValTobe() {
		return this.valTobe;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return calcTpSeq
	 */
	public String getCalcTpSeq() {
		return this.calcTpSeq;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return valExp
	 */
	public String getValExp() {
		return this.valExp;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param valCurr
	 */
	public void setValCurr(String valCurr) {
		this.valCurr = valCurr;
	}
	
	/**
	 * Column Info
	 * @param dmdtCalcTpCd
	 */
	public void setDmdtCalcTpCd(String dmdtCalcTpCd) {
		this.dmdtCalcTpCd = dmdtCalcTpCd;
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
	 * @param valTobe
	 */
	public void setValTobe(String valTobe) {
		this.valTobe = valTobe;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param calcTpSeq
	 */
	public void setCalcTpSeq(String calcTpSeq) {
		this.calcTpSeq = calcTpSeq;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param valExp
	 */
	public void setValExp(String valExp) {
		this.valExp = valExp;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setValCurr(JSPUtil.getParameter(request, "val_curr", ""));
		setDmdtCalcTpCd(JSPUtil.getParameter(request, "dmdt_calc_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setValTobe(JSPUtil.getParameter(request, "val_tobe", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCalcTpSeq(JSPUtil.getParameter(request, "calc_tp_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setValExp(JSPUtil.getParameter(request, "val_exp", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return CalculationTypeParmVO[]
	 */
	public CalculationTypeParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CalculationTypeParmVO[]
	 */
	public CalculationTypeParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CalculationTypeParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd".trim(), length));
			String[] valCurr = (JSPUtil.getParameter(request, prefix	+ "val_curr".trim(), length));
			String[] dmdtCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_calc_tp_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] valTobe = (JSPUtil.getParameter(request, prefix	+ "val_tobe".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] calcTpSeq = (JSPUtil.getParameter(request, prefix	+ "calc_tp_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] valExp = (JSPUtil.getParameter(request, prefix	+ "val_exp".trim(), length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd".trim(), length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CalculationTypeParmVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (valCurr[i] != null)
					model.setValCurr(valCurr[i]);
				if (dmdtCalcTpCd[i] != null)
					model.setDmdtCalcTpCd(dmdtCalcTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (valTobe[i] != null)
					model.setValTobe(valTobe[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (calcTpSeq[i] != null)
					model.setCalcTpSeq(calcTpSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (valExp[i] != null)
					model.setValExp(valExp[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCalculationTypeParmVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return CalculationTypeParmVO[]
	 */
	public CalculationTypeParmVO[] getCalculationTypeParmVOs(){
		CalculationTypeParmVO[] vos = (CalculationTypeParmVO[])models.toArray(new CalculationTypeParmVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valCurr = this.valCurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCalcTpCd = this.dmdtCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valTobe = this.valTobe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpSeq = this.calcTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valExp = this.valExp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
