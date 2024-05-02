/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchParamVO.java
*@FileTitle : SearchParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;


/**
 * Search Param VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see ..
 */
public class SearchParamVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;

	private Collection<SearchParamVO> models = new ArrayList<SearchParamVO>();

	private Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo");

	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String chkCntr = null;
	/* Column Info */
	private String cntrNo = null;
	/* Page Number */
	private String pagerows = null;

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
	 * @return the agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return agmtCtyCd;
	}

	/**
	 * @param agmtCtyCd the agmtCtyCd to set
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * @return the agmtSeq
	 */
	public String getAgmtSeq() {
		return agmtSeq;
	}

	/**
	 * @param agmtSeq the agmtSeq to set
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * @return the locTp
	 */
	public String getLocTp() {
		return locTp;
	}

	/**
	 * @param locTp the locTp to set
	 */
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}

	/**
	 * @return the locCd
	 */
	public String getLocCd() {
		return locCd;
	}

	/**
	 * @param locCd the locCd to set
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param page the iPage to set
	 */
	public void setIPage(int page) {
		iPage = page;
	}

	/**
	 * @return the chkCntr
	 */
	public String getChkCntr() {
		return chkCntr;
	}

	/**
	 * @param chkCntr the chkCntr to set
	 */
	public void setChkCntr(String chkCntr) {
		this.chkCntr = chkCntr;
	}

	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/* Column Info */
	private int iPage = 1;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * Constructor
	 */
	public SearchParamVO() {}

	/**
	 * Constructor
	 */
	public SearchParamVO(String ibflag, String chkCntr, String cntrNo, String agmtCtyCd, String agmtSeq,
			String locTp, String locCd, String pagerows) {
		this.ibflag = ibflag;
		this.agmtCtyCd = agmtCtyCd;
		this.agmtSeq = agmtSeq;
		this.locTp = locTp;
		this.locCd = locCd;
		this.chkCntr = chkCntr;
		this.cntrNo = cntrNo;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("chk_cntr", getChkCntr());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("chk_cntr", "chkCntr");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {

		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setChkCntr(JSPUtil.getParameter(request, "chk_cntr", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));

	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public SearchParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchParamVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {

			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] chkCntr = (JSPUtil.getParameter(request, prefix	+ "chk_cntr".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new SearchParamVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (chkCntr[i] != null)
					model.setChkCntr(chkCntr[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getSearchParamVOs();
	}

	public SearchParamVO[] getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new SearchParamVO[models.size()]);
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
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCntr = this.chkCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}