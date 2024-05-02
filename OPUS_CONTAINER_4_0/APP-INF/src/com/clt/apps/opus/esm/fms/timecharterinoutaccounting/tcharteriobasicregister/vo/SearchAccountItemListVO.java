/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccountItemListVO.java
*@FileTitle : SearchAccountItemListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.26 정윤태
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo;

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
 * @author 정윤태
 * @since J2EE 1.5
 * @see  ESM_FMS_0076HTMLAction
 */

public class SearchAccountItemListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccountItemListVO> models = new ArrayList<SearchAccountItemListVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String fletAcctCateCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmSeq = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctItmNm = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String acctCd = null;
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
	public SearchAccountItemListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String acctItmNm, String acctCd, String acctItmSeq, String fletAcctCateCd
	 * @return 
	 */
	public SearchAccountItemListVO(String ibflag, String pagerows, String acctItmNm, String acctCd, String acctItmSeq, String fletAcctCateCd) {
		this.fletAcctCateCd = fletAcctCateCd;
		this.acctItmSeq = acctItmSeq;
		this.acctItmNm = acctItmNm;
		this.ibflag = ibflag;
		this.acctCd = acctCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flet_acct_cate_cd", getFletAcctCateCd());
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flet_acct_cate_cd", "fletAcctCateCd");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getFletAcctCateCd() {
		return this.fletAcctCateCd;
	}
	public String getAcctItmSeq() {
		return this.acctItmSeq;
	}
	public String getAcctItmNm() {
		return this.acctItmNm;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getAcctCd() {
		return this.acctCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setFletAcctCateCd(String fletAcctCateCd) {
		this.fletAcctCateCd = fletAcctCateCd;
		//this.fletAcctCateCd=true;
	}
	public void setAcctItmSeq(String acctItmSeq) {
		this.acctItmSeq = acctItmSeq;
		//this.acctItmSeq=true;
	}
	public void setAcctItmNm(String acctItmNm) {
		this.acctItmNm = acctItmNm;
		//this.acctItmNm=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
		//this.acctCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setFletAcctCateCd(JSPUtil.getParameter(request, "flet_acct_cate_cd", ""));
		setAcctItmSeq(JSPUtil.getParameter(request, "acct_itm_seq", ""));
		setAcctItmNm(JSPUtil.getParameter(request, "acct_itm_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchAccountItemListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchAccountItemListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccountItemListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fletAcctCateCd = (JSPUtil.getParameter(request, prefix	+ "flet_acct_cate_cd".trim(), length));
			String[] acctItmSeq = (JSPUtil.getParameter(request, prefix	+ "acct_itm_seq".trim(), length));
			String[] acctItmNm = (JSPUtil.getParameter(request, prefix	+ "acct_itm_nm".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccountItemListVO();
				if (fletAcctCateCd[i] != null)
					model.setFletAcctCateCd(fletAcctCateCd[i]);
				if (acctItmSeq[i] != null)
					model.setAcctItmSeq(acctItmSeq[i]);
				if (acctItmNm[i] != null)
					model.setAcctItmNm(acctItmNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchAccountItemListVOs();
	}

	public SearchAccountItemListVO[] getSearchAccountItemListVOs(){
		SearchAccountItemListVO[] vos = (SearchAccountItemListVO[])models.toArray(new SearchAccountItemListVO[models.size()]);
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
		this.fletAcctCateCd = this.fletAcctCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq = this.acctItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmNm = this.acctItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
