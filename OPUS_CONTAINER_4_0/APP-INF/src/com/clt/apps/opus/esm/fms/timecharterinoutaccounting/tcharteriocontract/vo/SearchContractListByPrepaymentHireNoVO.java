/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContractListByPrepaymentHireNoVO.java
*@FileTitle : SearchContractListByPrepaymentHireNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.21 정윤태 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

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
 * @see ESM_FMS_0001HTMLAction
 */
 
public class SearchContractListByPrepaymentHireNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContractListByPrepaymentHireNoVO> models = new ArrayList<SearchContractListByPrepaymentHireNoVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String ppayHirNo = null;
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
	public SearchContractListByPrepaymentHireNoVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String ppayHirNo, String fletCtrtTpCd
	 * @return 
	 */
	public SearchContractListByPrepaymentHireNoVO(String ibflag, String pagerows, String ppayHirNo, String fletCtrtTpCd) {
		this.ibflag = ibflag;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.ppayHirNo = ppayHirNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("ppay_hir_no", getPpayHirNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	public String getPpayHirNo() {
		return this.ppayHirNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
		//this.fletCtrtTpCd=true;
	}
	public void setPpayHirNo(String ppayHirNo) {
		this.ppayHirNo = ppayHirNo;
		//this.ppayHirNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setPpayHirNo(JSPUtil.getParameter(request, "ppay_hir_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchContractListByPrepaymentHireNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchContractListByPrepaymentHireNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContractListByPrepaymentHireNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd".trim(), length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContractListByPrepaymentHireNoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (ppayHirNo[i] != null)
					model.setPpayHirNo(ppayHirNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchContractListByPrepaymentHireNoVOs();
	}

	public SearchContractListByPrepaymentHireNoVO[] getSearchContractListByPrepaymentHireNoVOs(){
		SearchContractListByPrepaymentHireNoVO[] vos = (SearchContractListByPrepaymentHireNoVO[])models.toArray(new SearchContractListByPrepaymentHireNoVO[models.size()]);
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
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
