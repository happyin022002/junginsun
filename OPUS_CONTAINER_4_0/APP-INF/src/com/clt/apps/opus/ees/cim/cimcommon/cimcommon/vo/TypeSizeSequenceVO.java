/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CIMCommonDBDAOTypeSizeSequenceVO.java
*@FileTitle : CIMCommonDBDAOTypeSizeSequenceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.04.24 박광석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo;

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
 * @author 박광석 
 * @since J2EE 1.5
 */

public class TypeSizeSequenceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TypeSizeSequenceVO> models = new ArrayList<TypeSizeSequenceVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String dpSeq = null;
	/* �곹깭 */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/* 而щ읆 �ㅻ챸 */
	private String cntrTpszCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TypeSizeSequenceVO() {}

	public TypeSizeSequenceVO(String ibflag, String pagerows, String dpSeq, String cntrTpszCd) {
		this.dpSeq = dpSeq;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		return this.hashFields;
	}
	
	public String getDpSeq() {
		return this.dpSeq;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}

	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
		//this.dpSeq=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * 
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
		//this.cntrTpszCd=true;
	}
	
	/**
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public TypeSizeSequenceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 
	 * @param request
	 * @param prefix
	 * @return
	 */
	public TypeSizeSequenceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TypeSizeSequenceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TypeSizeSequenceVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCIMCommonDBDAOTypeSizeSequenceVOs();
	}

	/**
	 * 
	 * @return TypeSizeSequenceVO[]
	 */
	public TypeSizeSequenceVO[] getCIMCommonDBDAOTypeSizeSequenceVOs(){
		TypeSizeSequenceVO[] vos = (TypeSizeSequenceVO[])models.toArray(new TypeSizeSequenceVO[models.size()]);
		return vos;
	}
	
	/**
	 * 
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
