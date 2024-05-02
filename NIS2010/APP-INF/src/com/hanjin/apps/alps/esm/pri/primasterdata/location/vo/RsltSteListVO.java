/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltSteListVO.java
*@FileTitle : RsltSteListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.30 최성민 
* 1.0 Creation
* * 2014.04.10 전윤주 [CHM-201429656] State code 항목 추가  (UI ID로 인한 로직 분기 위해 인자 추가)
=========================================================*/

package com.hanjin.apps.alps.esm.pri.primasterdata.location.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최성민
 * @since J2EE 1.5
 */

public class RsltSteListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSteListVO> models = new ArrayList<RsltSteListVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String uiId = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String comboCntCd = null;
	/* Column Info */
	private String scontiCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSteListVO() {}

	public RsltSteListVO(String ibflag, String pagerows, String comboCntCd, String steCd, String steNm, String contiCd, String uiId, String scontiCd) {
		this.contiCd = contiCd;
		this.uiId = uiId;
		this.ibflag = ibflag;
		this.steNm = steNm;
		this.steCd = steCd;
		this.comboCntCd = comboCntCd;
		this.scontiCd = scontiCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("ui_id", getUiId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("combo_cnt_cd", getComboCntCd());
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
		this.hashFields.put("ui_id", "uiId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("combo_cnt_cd", "comboCntCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getContiCd() {
		return this.contiCd;
	}
	public String getUiId() {
		return this.uiId;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getSteNm() {
		return this.steNm;
	}
	public String getSteCd() {
		return this.steCd;
	}
	public String getComboCntCd() {
		return this.comboCntCd;
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
	public void setUiId(String uiId) {
		this.uiId = uiId;
		//this.contiCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setSteNm(String steNm) {
		this.steNm = steNm;
		//this.steNm=true;
	}
	public void setSteCd(String steCd) {
		this.steCd = steCd;
		//this.steCd=true;
	}
	public void setComboCntCd(String comboCntCd) {
		this.comboCntCd = comboCntCd;
		//this.comboCntCd=true;
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
		setUiId(JSPUtil.getParameter(request, "ui_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSteNm(JSPUtil.getParameter(request, "ste_nm", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setComboCntCd(JSPUtil.getParameter(request, "combo_cnt_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RsltSteListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RsltSteListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSteListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd".trim(), length));
			String[] uiId = (JSPUtil.getParameter(request, prefix	+ "ui_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm".trim(), length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd".trim(), length));
			String[] comboCntCd = (JSPUtil.getParameter(request, prefix	+ "combo_cnt_cd".trim(), length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSteListVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (uiId[i] != null)
					model.setUiId(uiId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (comboCntCd[i] != null)
					model.setComboCntCd(comboCntCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getRsltSteListVOs();
	}

	public RsltSteListVO[] getRsltSteListVOs(){
		RsltSteListVO[] vos = (RsltSteListVO[])models.toArray(new RsltSteListVO[models.size()]);
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
		this.uiId = this.uiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboCntCd = this.comboCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
