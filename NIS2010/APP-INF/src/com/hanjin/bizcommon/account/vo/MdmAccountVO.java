/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MdmAccountVO.java
*@FileTitle : MdmAccountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.22 김석준 
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.account.vo;

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
 * @author 김석준
 * @see
 * @since J2EE 1.5
 */
public class MdmAccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmAccountVO> models = new ArrayList<MdmAccountVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String acctCd = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctEngNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmAccountVO() {}

	public MdmAccountVO(String ibflag, String pagerows, String acctCd, String acctEngNm) {
		this.acctCd = acctCd;
		this.ibflag = ibflag;
		this.acctEngNm = acctEngNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_eng_nm", getAcctEngNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_eng_nm", "acctEngNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getAcctEngNm() {
		return this.acctEngNm;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setAcctEngNm(String acctEngNm) {
		this.acctEngNm = acctEngNm;
		//this.acctEngNm=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public MdmAccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MdmAccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmAccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] acctEngNm = (JSPUtil.getParameter(request, prefix	+ "acct_eng_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmAccountVO();
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctEngNm[i] != null)
					model.setAcctEngNm(acctEngNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getMdmAccountVOs();
	}

	public MdmAccountVO[] getMdmAccountVOs(){
		MdmAccountVO[] vos = (MdmAccountVO[])models.toArray(new MdmAccountVO[models.size()]);
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
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctEngNm = this.acctEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
