/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseNameVO.java
*@FileTitle : ExpenseNameVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.04 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 진윤오
 * @since J2EE 1.5
 */

public class ExpenseNameVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExpenseNameVO> models = new ArrayList<ExpenseNameVO>();
	
	/* Column Info */
	private String engAbbrNm = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String krnAbbrNm = null;
	/* Column Info */
	private String ticCd = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExpenseNameVO() {}

	public ExpenseNameVO(String ibflag, String pagerows, String genExpnCd, String engAbbrNm, String krnAbbrNm, String ticCd) {
		this.engAbbrNm = engAbbrNm;
		this.ibflag = ibflag;
		this.krnAbbrNm = krnAbbrNm;
		this.ticCd = ticCd;
		this.genExpnCd = genExpnCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eng_abbr_nm", getEngAbbrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("krn_abbr_nm", getKrnAbbrNm());
		this.hashColumns.put("tic_cd", getTicCd());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eng_abbr_nm", "engAbbrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("krn_abbr_nm", "krnAbbrNm");
		this.hashFields.put("tic_cd", "ticCd");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getEngAbbrNm() {
		return this.engAbbrNm;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getKrnAbbrNm() {
		return this.krnAbbrNm;
	}
	public String getTicCd() {
		return this.ticCd;
	}
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setEngAbbrNm(String engAbbrNm) {
		this.engAbbrNm = engAbbrNm;
		//this.engAbbrNm=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setKrnAbbrNm(String krnAbbrNm) {
		this.krnAbbrNm = krnAbbrNm;
		//this.krnAbbrNm=true;
	}
	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
		//this.ticCd=true;
	}
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
		//this.genExpnCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setEngAbbrNm(JSPUtil.getParameter(request, "eng_abbr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKrnAbbrNm(JSPUtil.getParameter(request, "krn_abbr_nm", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public ExpenseNameVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ExpenseNameVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExpenseNameVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] engAbbrNm = (JSPUtil.getParameter(request, prefix	+ "eng_abbr_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] krnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "krn_abbr_nm".trim(), length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd".trim(), length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExpenseNameVO();
				if (engAbbrNm[i] != null)
					model.setEngAbbrNm(engAbbrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (krnAbbrNm[i] != null)
					model.setKrnAbbrNm(krnAbbrNm[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getExpenseNameVOs();
	}

	public ExpenseNameVO[] getExpenseNameVOs(){
		ExpenseNameVO[] vos = (ExpenseNameVO[])models.toArray(new ExpenseNameVO[models.size()]);
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
		} catch (Exception ex) {}
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
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.engAbbrNm = this.engAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnAbbrNm = this.krnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
