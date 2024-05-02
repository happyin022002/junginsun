/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanSearchVO.java
*@FileTitle : PlanSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.29 노정용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Lease Plan Search VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 노정용
 * @since J2EE 1.5
 * @see ..
 */

public class PlanSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PlanSearchVO> models = new ArrayList<PlanSearchVO>();
	
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo");
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String plnYrmon = null;
	/* Column Info */
	private String plnMonCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String mftVndrSeq = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String deYr = null;
	/* Column Info */
	private String deMon = null;
	/* Column Info */
	private String cntrTpszCd = null; 
	/* Column Info */
	private String onhireLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private int iPage = 1;
	/* Column Info */
	private String excelFlg = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public PlanSearchVO() {}

	/**
	 * Constructor
	 */
	public PlanSearchVO(String ibflag, String pagerows, String plnYr, String plnYrmon, String plnMonCd, String agmtCtyCd, String agmtSeq, String mftVndrSeq, 
			            String locCd, String locTp, String deYr, String deMon, String cntrTpszCd, String onhireLocCd, String excelFlg) {
		this.ibflag = ibflag;
		this.plnYr = plnYr;
		this.plnYrmon = plnYrmon;
		this.plnMonCd = plnMonCd;
		this.agmtSeq = agmtSeq;
		this.agmtCtyCd = agmtCtyCd;
		this.mftVndrSeq = mftVndrSeq;
		this.locCd = locCd;
		this.locTp = locTp;
		this.deYr = deYr;
		this.deMon = deMon;
		this.cntrTpszCd = cntrTpszCd;
		this.onhireLocCd = onhireLocCd;
		this.pagerows = pagerows;
		this.excelFlg = excelFlg;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("pln_yrmon", getPlnYrmon());
		this.hashColumns.put("pln_mon_cd", getPlnMonCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("mft_vndr_seq", getMftVndrSeq());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("de_yr", getDeYr());
		this.hashColumns.put("de_mon", getDeMon());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("onhire_loc_cd", getOnhireLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("excel_flg", getExcelFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("pln_yrmon", "plnYrmon");
		this.hashFields.put("pln_mon_cd", "plnMonCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("mft_vndr_seq", "mftVndrSeq");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("de_yr", "deYr");
		this.hashFields.put("de_mon", "deMon");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("onhire_loc_cd", "onhireLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("excel_flg", "excelFlg");
		
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getPlnYr() {
		return this.plnYr;
	}
	public String getPlnYrmon() {
		return this.plnYrmon;
	}
	public String getPlnMonCd() {
		return this.plnMonCd;
	}
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	public String getMftVndrSeq() {
		return this.mftVndrSeq;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}
	public void setPlnMonCd(String plnMonCd) {
		this.plnMonCd = plnMonCd;
	}
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	public void setMftVndrSeq(String mftVndrSeq) {
		this.mftVndrSeq = mftVndrSeq;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	public String getLocCd() {
		return locCd;
	}
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	public String getLocTp() {
		return locTp;
	}
	public void setDeYr(String deYr) {
		this.deYr = deYr;
	}
	public String getDeYr() {
		return deYr;
	}
	public void setDeMon(String deMon) {
		this.deMon = deMon;
	}
	public String getDeMon() {
		return deMon;
	}
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}
	public void setOnhireLocCd(String onhireLocCd) {
		this.onhireLocCd = onhireLocCd;
	}
	public String getOnhireLocCd() {
		return onhireLocCd;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}
	public int getIPage() {
		return iPage;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setPlnYrmon(JSPUtil.getParameter(request, "pln_yrmon", "").replaceAll("-", ""));
		setPlnMonCd(JSPUtil.getParameter(request, "pln_mon_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setMftVndrSeq(JSPUtil.getParameter(request, "mft_vndr_seq", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setDeYr(JSPUtil.getParameter(request, "de_yr", ""));
		setDeMon(JSPUtil.getParameter(request, "de_mon", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOnhireLocCd(JSPUtil.getParameter(request, "onhire_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setExcelFlg(JSPUtil.getParameter(request, "excel_flg", ""));		
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public PlanSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public PlanSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PlanSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] plnYrmon = (JSPUtil.getParameter(request, prefix	+ "pln_yrmon".trim(), length));
			String[] plnMonCd = (JSPUtil.getParameter(request, prefix	+ "pln_mon_cd".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] mftVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mft_vndr_seq".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp".trim(), length));
			String[] deYr = (JSPUtil.getParameter(request, prefix	+ "de_yr".trim(), length));
			String[] deMon = (JSPUtil.getParameter(request, prefix	+ "de_mon".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] onhireLocCd = (JSPUtil.getParameter(request, prefix	+ "onhire_loc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PlanSearchVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (plnYrmon[i] != null)
					model.setPlnYrmon(plnMonCd[i]);
				if (plnMonCd[i] != null)
					model.setPlnMonCd(plnMonCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (mftVndrSeq[i] != null)
					model.setMftVndrSeq(mftVndrSeq[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (deYr[i] != null)
					model.setDeYr(deYr[i]);
				if (deMon[i] != null)
					model.setDeMon(deMon[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (onhireLocCd[i] != null)
					model.setOnhireLocCd(onhireLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);

				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getPlanSearchVOs();
	}

	public PlanSearchVO[] getPlanSearchVOs(){
		PlanSearchVO[] vos = (PlanSearchVO[])models.toArray(new PlanSearchVO[models.size()]);
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
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrmon = this.plnYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnMonCd = this.plnMonCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftVndrSeq = this.mftVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYr = this.deYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deMon = this.deMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhireLocCd = this.onhireLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}

	public String getExcelFlg() {
		return excelFlg;
	}
}