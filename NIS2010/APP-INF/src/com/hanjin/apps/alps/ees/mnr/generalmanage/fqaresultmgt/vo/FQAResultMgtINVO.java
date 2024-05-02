/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FQAResultMgtINVO.java
*@FileTitle : FQAResultMgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 성덕경
*@LastVersion : 1.0
* 2009.05.20 성덕경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo;

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
 * @author 성덕경
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class FQAResultMgtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FQAResultMgtINVO> models = new ArrayList<FQAResultMgtINVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydCd = null;
	
	private String fileSeq = null;
	/* Column Info */
	private String fldAudDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String keyValue = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FQAResultMgtINVO() {}
	/**
	 * Table Column name 으로 맴버변수 선언한다.
	 * @return HashMap
	 */
	public FQAResultMgtINVO(String ibflag, String pagerows, String vndrSeq, String ofcCd, String fldAudDt, String ydCd, String keyValue, String fileSeq) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.fldAudDt = fldAudDt;
		this.ydCd = ydCd;
		this.pagerows = pagerows;
		this.keyValue = keyValue;
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("fld_aud_dt", getFldAudDt());
		this.hashColumns.put("key_value", getKeyValue());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_seq", getFileSeq());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("fld_aud_dt", "fldAudDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("key_value", "keyValue");
		this.hashFields.put("file_seq", "fileSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	/**
	 * Column Info
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	/**
	 * Column Info
	 * @return fldAudDt
	 */
	public String getFldAudDt() {
		return this.fldAudDt;
	}
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return keyValue
	 */
	public String getKeyValue() {
		return this.keyValue;
	}
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	/**
	 * Column Info
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	/**
	 * Column Info
	 * @param fldAudDt
	 */
	public void setFldAudDt(String fldAudDt) {
		this.fldAudDt = fldAudDt;
	}
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param keyValue
	 */
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setFldAudDt(JSPUtil.getParameter(request, "fld_aud_dt", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKeyValue(JSPUtil.getParameter(request, "key_value", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return FQAResultMgtINVO[]
	 */
	public FQAResultMgtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FQAResultMgtINVO[]
	 */
	public FQAResultMgtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FQAResultMgtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq".trim(), length));
			String[] fldAudDt = (JSPUtil.getParameter(request, prefix	+ "fld_aud_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] keyValue = (JSPUtil.getParameter(request, prefix	+ "key_value".trim(), length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd".trim(), length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new FQAResultMgtINVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (fldAudDt[i] != null)
					model.setFldAudDt(fldAudDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (keyValue[i] != null)
					model.setKeyValue(keyValue[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFQAResultMgtINVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return FQAResultMgtINVO[]
	 */
	public FQAResultMgtINVO[] getFQAResultMgtINVOs(){
		FQAResultMgtINVO[] vos = (FQAResultMgtINVO[])models.toArray(new FQAResultMgtINVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fldAudDt = this.fldAudDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyValue = this.keyValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
