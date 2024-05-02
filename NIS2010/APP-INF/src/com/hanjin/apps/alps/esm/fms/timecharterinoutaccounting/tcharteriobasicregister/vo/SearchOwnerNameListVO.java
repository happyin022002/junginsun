/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOwnerNameListVO.java
*@FileTitle : SearchOwnerNameListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.04.23 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo;

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
 * @author 윤세영
 * @since J2EE 1.5
 * @see ESM_FMS_0080HTMLAction
 */

public class SearchOwnerNameListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOwnerNameListVO> models = new ArrayList<SearchOwnerNameListVO>();
	
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String ownrSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String ownrNm = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletOwnrTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchOwnerNameListVO() {}

	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String ownrSeq, String ownrNm, String fletOwnrTpCd
	 * @return 
	 */
	public SearchOwnerNameListVO(String ibflag, String pagerows, String ownrSeq, String ownrNm, String fletOwnrTpCd) {
		this.ibflag = ibflag;
		this.ownrSeq = ownrSeq;
		this.ownrNm = ownrNm;
		this.fletOwnrTpCd = fletOwnrTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ownr_seq", getOwnrSeq());
		this.hashColumns.put("ownr_nm", getOwnrNm());
		this.hashColumns.put("flet_ownr_tp_cd", getFletOwnrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ownr_seq", "ownrSeq");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("flet_ownr_tp_cd", "fletOwnrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getOwnrSeq() {
		return this.ownrSeq;
	}
	public String getOwnrNm() {
		return this.ownrNm;
	}
	public String getFletOwnrTpCd() {
		return this.fletOwnrTpCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setOwnrSeq(String ownrSeq) {
		this.ownrSeq = ownrSeq;
		//this.ownrSeq=true;
	}
	public void setOwnrNm(String ownrNm) {
		this.ownrNm = ownrNm;
		//this.ownrNm=true;
	}
	public void setFletOwnrTpCd(String fletOwnrTpCd) {
		this.fletOwnrTpCd = fletOwnrTpCd;
		//this.fletOwnrTpCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOwnrSeq(JSPUtil.getParameter(request, "ownr_seq", ""));
		setOwnrNm(JSPUtil.getParameter(request, "ownr_nm", ""));
		setFletOwnrTpCd(JSPUtil.getParameter(request, "flet_ownr_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchOwnerNameListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchOwnerNameListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOwnerNameListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ownrSeq = (JSPUtil.getParameter(request, prefix	+ "ownr_seq".trim(), length));
			String[] ownrNm = (JSPUtil.getParameter(request, prefix	+ "ownr_nm".trim(), length));
			String[] fletOwnrTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ownr_tp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOwnerNameListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ownrSeq[i] != null)
					model.setOwnrSeq(ownrSeq[i]);
				if (ownrNm[i] != null)
					model.setOwnrNm(ownrNm[i]);
				if (fletOwnrTpCd[i] != null)
					model.setFletOwnrTpCd(fletOwnrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchOwnerNameListVOs();
	}

	public SearchOwnerNameListVO[] getSearchOwnerNameListVOs(){
		SearchOwnerNameListVO[] vos = (SearchOwnerNameListVO[])models.toArray(new SearchOwnerNameListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrSeq = this.ownrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm = this.ownrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOwnrTpCd = this.fletOwnrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
