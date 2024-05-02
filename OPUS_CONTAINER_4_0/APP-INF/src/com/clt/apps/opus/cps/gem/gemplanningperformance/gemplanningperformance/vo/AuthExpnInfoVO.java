/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthExpnInfoVO.java
*@FileTitle : AuthExpnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.11 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 진윤오
 * @since J2EE 1.5
 * @see ..
 */

public class AuthExpnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthExpnInfoVO> models = new ArrayList<AuthExpnInfoVO>();
	
	/* Column Info */
	private String genExpnGroupCd = null;
	/* Column Info */
	private String engAbbrNm = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String langDiv = null;
	/* Column Info */
	private String krnAbbrNm = null;
	/* Column Info */
	private String ticCd = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AuthExpnInfoVO() {}

	public AuthExpnInfoVO(String ibflag, String pagerows, String ofcCd, String langDiv, String genExpnGroupCd, String genExpnCd, String engAbbrNm, String krnAbbrNm, String ticCd) {
		this.genExpnGroupCd = genExpnGroupCd;
		this.engAbbrNm = engAbbrNm;
		this.ibflag = ibflag;
		this.langDiv = langDiv;
		this.krnAbbrNm = krnAbbrNm;
		this.ticCd = ticCd;
		this.genExpnCd = genExpnCd;
		this.ofcCd = ofcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gen_expn_group_cd", getGenExpnGroupCd());
		this.hashColumns.put("eng_abbr_nm", getEngAbbrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lang_div", getLangDiv());
		this.hashColumns.put("krn_abbr_nm", getKrnAbbrNm());
		this.hashColumns.put("tic_cd", getTicCd());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gen_expn_group_cd", "genExpnGroupCd");
		this.hashFields.put("eng_abbr_nm", "engAbbrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lang_div", "langDiv");
		this.hashFields.put("krn_abbr_nm", "krnAbbrNm");
		this.hashFields.put("tic_cd", "ticCd");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getGenExpnGroupCd() {
		return this.genExpnGroupCd;
	}
	public String getEngAbbrNm() {
		return this.engAbbrNm;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getLangDiv() {
		return this.langDiv;
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
	public String getOfcCd() {
		return this.ofcCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setGenExpnGroupCd(String genExpnGroupCd) {
		this.genExpnGroupCd = genExpnGroupCd;
		//this.genExpnGroupCd=true;
	}
	public void setEngAbbrNm(String engAbbrNm) {
		this.engAbbrNm = engAbbrNm;
		//this.engAbbrNm=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setLangDiv(String langDiv) {
		this.langDiv = langDiv;
		//this.langDiv=true;
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
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
		//this.ofcCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setGenExpnGroupCd(JSPUtil.getParameter(request, "gen_expn_group_cd", ""));
		setEngAbbrNm(JSPUtil.getParameter(request, "eng_abbr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLangDiv(JSPUtil.getParameter(request, "lang_div", ""));
		setKrnAbbrNm(JSPUtil.getParameter(request, "krn_abbr_nm", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public AuthExpnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public AuthExpnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthExpnInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] genExpnGroupCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_group_cd".trim(), length));
			String[] engAbbrNm = (JSPUtil.getParameter(request, prefix	+ "eng_abbr_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] langDiv = (JSPUtil.getParameter(request, prefix	+ "lang_div".trim(), length));
			String[] krnAbbrNm = (JSPUtil.getParameter(request, prefix	+ "krn_abbr_nm".trim(), length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd".trim(), length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthExpnInfoVO();
				if (genExpnGroupCd[i] != null)
					model.setGenExpnGroupCd(genExpnGroupCd[i]);
				if (engAbbrNm[i] != null)
					model.setEngAbbrNm(engAbbrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (langDiv[i] != null)
					model.setLangDiv(langDiv[i]);
				if (krnAbbrNm[i] != null)
					model.setKrnAbbrNm(krnAbbrNm[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthExpnInfoVOs();
	}

	public AuthExpnInfoVO[] getAuthExpnInfoVOs(){
		AuthExpnInfoVO[] vos = (AuthExpnInfoVO[])models.toArray(new AuthExpnInfoVO[models.size()]);
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
	public void onDataFormat(){
		this.genExpnGroupCd = this.genExpnGroupCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAbbrNm = this.engAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.langDiv = this.langDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krnAbbrNm = this.krnAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
