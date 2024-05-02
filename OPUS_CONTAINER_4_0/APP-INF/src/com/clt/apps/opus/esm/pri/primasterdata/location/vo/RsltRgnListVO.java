/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltRgnListVO.java
*@FileTitle : RsltRgnListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.04 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.primasterdata.location.vo;

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
 * @author 최성민
 * @since J2EE 1.5
 */

public class RsltRgnListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRgnListVO> models = new ArrayList<RsltRgnListVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String rgnCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String rgnNm = null;
	/* Column Info */
	private String combo2CntCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRgnListVO() {}

	public RsltRgnListVO(String ibflag, String pagerows, String combo2CntCd, String rgnCd, String rgnNm, String contiCd, String scontiCd) {
		this.contiCd = contiCd;
		this.rgnCd = rgnCd;
		this.ibflag = ibflag;
		this.rgnNm = rgnNm;
		this.combo2CntCd = combo2CntCd;
		this.scontiCd = scontiCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rgn_nm", getRgnNm());
		this.hashColumns.put("combo2_cnt_cd", getCombo2CntCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rgn_nm", "rgnNm");
		this.hashFields.put("combo2_cnt_cd", "combo2CntCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getContiCd() {
		return this.contiCd;
	}
	public String getRgnCd() {
		return this.rgnCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getRgnNm() {
		return this.rgnNm;
	}
	public String getCombo2CntCd() {
		return this.combo2CntCd;
	}
	public String getScontiCd() {
		return this.scontiCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
		//this.contiCd=true;
	}
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
		//this.rgnCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setRgnNm(String rgnNm) {
		this.rgnNm = rgnNm;
		//this.rgnNm=true;
	}
	public void setCombo2CntCd(String combo2CntCd) {
		this.combo2CntCd = combo2CntCd;
		//this.combo2CntCd=true;
	}
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
		//this.scontiCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRgnNm(JSPUtil.getParameter(request, "rgn_nm", ""));
		setCombo2CntCd(JSPUtil.getParameter(request, "combo2_cnt_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RsltRgnListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltRgnListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRgnListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd".trim(), length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rgnNm = (JSPUtil.getParameter(request, prefix	+ "rgn_nm".trim(), length));
			String[] combo2CntCd = (JSPUtil.getParameter(request, prefix	+ "combo2_cnt_cd".trim(), length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRgnListVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rgnNm[i] != null)
					model.setRgnNm(rgnNm[i]);
				if (combo2CntCd[i] != null)
					model.setCombo2CntCd(combo2CntCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getRsltRgnListVOs();
	}

	public RsltRgnListVO[] getRsltRgnListVOs(){
		RsltRgnListVO[] vos = (RsltRgnListVO[])models.toArray(new RsltRgnListVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnNm = this.rgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo2CntCd = this.combo2CntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
