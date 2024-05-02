/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMyPerformanceVO.java
*@FileTitle : SearchMyPerformanceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMyPerformanceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMyPerformanceVO> models = new ArrayList<SearchMyPerformanceVO>();
	
	/* 而щ읆 �ㅻ챸 */
	private String ediCgoRmk = null;
	/* 而щ읆 �ㅻ챸 */
	private String ediGrpDesc = null;
	/* �곹깭 */
	private String ibflag = null;
	/* 而щ읆 �ㅻ챸 */
	private String ediGrpCd = null;
	/* 而щ읆 �ㅻ챸 */
	private String custTrdPrnrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMyPerformanceVO() {}

	public SearchMyPerformanceVO(String ibflag, String pagerows, String ediCgoRmk, String ediGrpCd, String ediGrpDesc, String custTrdPrnrId) {
		this.ediCgoRmk = ediCgoRmk;
		this.ediGrpDesc = ediGrpDesc;
		this.ibflag = ibflag;
		this.ediGrpCd = ediGrpCd;
		this.custTrdPrnrId = custTrdPrnrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_cgo_rmk", getEdiCgoRmk());
		this.hashColumns.put("edi_grp_desc", getEdiGrpDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_cgo_rmk", "ediCgoRmk");
		this.hashFields.put("edi_grp_desc", "ediGrpDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * 而щ읆 �ㅻ챸
	 * @return ediCgoRmk
	 */
	public String getEdiCgoRmk() {
		return this.ediCgoRmk;
	}
	
	/**
	 * 而щ읆 �ㅻ챸
	 * @return ediGrpDesc
	 */
	public String getEdiGrpDesc() {
		return this.ediGrpDesc;
	}
	
	/**
	 * �곹깭
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * 而щ읆 �ㅻ챸
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * 而щ읆 �ㅻ챸
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * 而щ읆 �ㅻ챸
	 * @param ediCgoRmk
	 */
	public void setEdiCgoRmk(String ediCgoRmk) {
		this.ediCgoRmk = ediCgoRmk;
	}
	
	/**
	 * 而щ읆 �ㅻ챸
	 * @param ediGrpDesc
	 */
	public void setEdiGrpDesc(String ediGrpDesc) {
		this.ediGrpDesc = ediGrpDesc;
	}
	
	/**
	 * �곹깭
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 而щ읆 �ㅻ챸
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * 而щ읆 �ㅻ챸
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEdiCgoRmk(JSPUtil.getParameter(request, "edi_cgo_rmk", ""));
		setEdiGrpDesc(JSPUtil.getParameter(request, "edi_grp_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, "cust_trd_prnr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMyPerformanceVO[]
	 */
	public SearchMyPerformanceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMyPerformanceVO[]
	 */
	public SearchMyPerformanceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMyPerformanceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ediCgoRmk = (JSPUtil.getParameter(request, prefix	+ "edi_cgo_rmk", length));
			String[] ediGrpDesc = (JSPUtil.getParameter(request, prefix	+ "edi_grp_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMyPerformanceVO();
				if (ediCgoRmk[i] != null)
					model.setEdiCgoRmk(ediCgoRmk[i]);
				if (ediGrpDesc[i] != null)
					model.setEdiGrpDesc(ediGrpDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMyPerformanceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMyPerformanceVO[]
	 */
	public SearchMyPerformanceVO[] getSearchMyPerformanceVOs(){
		SearchMyPerformanceVO[] vos = (SearchMyPerformanceVO[])models.toArray(new SearchMyPerformanceVO[models.size()]);
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ediCgoRmk = this.ediCgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpDesc = this.ediGrpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
