/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltCntListVO.java
*@FileTitle : RsltCntListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.28 최성민 
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

public class RsltCntListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCntListVO> models = new ArrayList<RsltCntListVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String cntNm = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCntListVO() {}

	public RsltCntListVO(String ibflag, String pagerows, String cntCd, String cntNm, String contiCd, String scontiCd) {
		this.contiCd = contiCd;
		this.cntNm = cntNm;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.scontiCd = scontiCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
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
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getContiCd() {
		return this.contiCd;
	}
	public String getCntNm() {
		return this.cntNm;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCntCd() {
		return this.cntCd;
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
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
		//this.cntNm=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
		//this.cntCd=true;
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
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RsltCntListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltCntListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCntListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd".trim(), length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltCntListVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getRsltCntListVOs();
	}

	public RsltCntListVO[] getRsltCntListVOs(){
		RsltCntListVO[] vos = (RsltCntListVO[])models.toArray(new RsltCntListVO[models.size()]);
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
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
