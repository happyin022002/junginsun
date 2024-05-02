/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPayTermListVO.java
*@FileTitle : SearchPayTermListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.23 정윤태
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

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
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0001HTMLAction
 */
 
public class SearchPayTermListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPayTermListVO> models = new ArrayList<SearchPayTermListVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String ctrtPayTermCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String effDt = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String oriExpDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String expDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String oriEffDt = null;
	/* 而щ읆 �ㅻ챸 */
	private String fletCtrtNo = null;
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
	public SearchPayTermListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String effDt, String expDt, String oriEffDt, String oriExpDt, String ctrtPayTermCd
	 * @return 
	 */
	public SearchPayTermListVO(String ibflag, String pagerows, String fletCtrtNo, String effDt, String expDt, String oriEffDt, String oriExpDt, String ctrtPayTermCd) {
		this.ctrtPayTermCd = ctrtPayTermCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.oriExpDt = oriExpDt;
		this.expDt = expDt;
		this.oriEffDt = oriEffDt;
		this.fletCtrtNo = fletCtrtNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrt_pay_term_cd", getCtrtPayTermCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ori_exp_dt", getOriExpDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ori_eff_dt", getOriEffDt());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrt_pay_term_cd", "ctrtPayTermCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ori_exp_dt", "oriExpDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ori_eff_dt", "oriEffDt");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getCtrtPayTermCd() {
		return this.ctrtPayTermCd;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getOriExpDt() {
		return this.oriExpDt;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getOriEffDt() {
		return this.oriEffDt;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setCtrtPayTermCd(String ctrtPayTermCd) {
		this.ctrtPayTermCd = ctrtPayTermCd;
		//this.ctrtPayTermCd=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setOriExpDt(String oriExpDt) {
		this.oriExpDt = oriExpDt;
		//this.oriExpDt=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setOriEffDt(String oriEffDt) {
		this.oriEffDt = oriEffDt;
		//this.oriEffDt=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setCtrtPayTermCd(JSPUtil.getParameter(request, "ctrt_pay_term_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOriExpDt(JSPUtil.getParameter(request, "ori_exp_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setOriEffDt(JSPUtil.getParameter(request, "ori_eff_dt", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchPayTermListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchPayTermListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPayTermListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrtPayTermCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_pay_term_cd".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] oriExpDt = (JSPUtil.getParameter(request, prefix	+ "ori_exp_dt".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] oriEffDt = (JSPUtil.getParameter(request, prefix	+ "ori_eff_dt".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPayTermListVO();
				if (ctrtPayTermCd[i] != null)
					model.setCtrtPayTermCd(ctrtPayTermCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oriExpDt[i] != null)
					model.setOriExpDt(oriExpDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (oriEffDt[i] != null)
					model.setOriEffDt(oriEffDt[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchPayTermListVOs();
	}

	public SearchPayTermListVO[] getSearchPayTermListVOs(){
		SearchPayTermListVO[] vos = (SearchPayTermListVO[])models.toArray(new SearchPayTermListVO[models.size()]);
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
		this.ctrtPayTermCd = this.ctrtPayTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriExpDt = this.oriExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriEffDt = this.oriEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
