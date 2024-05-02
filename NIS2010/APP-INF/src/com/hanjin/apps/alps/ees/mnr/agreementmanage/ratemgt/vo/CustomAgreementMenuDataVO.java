/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomAgreementMenuDataVO.java
*@FileTitle : CustomAgreementMenuDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.22 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomAgreementMenuDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomAgreementMenuDataVO> models = new ArrayList<CustomAgreementMenuDataVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String tabTitle = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String mnrOrdTpCd = null;
	/* Column Info */
	private String eqType = null;
	/* Column Info */
	private String tabType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * CustomAgreementMenuDataVO을 생성함 
	 */ 
	public CustomAgreementMenuDataVO() {}
	
	/**
	 * CustomAgreementMenuDataVO을 생성함 
	 */    
	public CustomAgreementMenuDataVO(String ibflag, String pagerows, String dpSeq, String tabTitle, String mnrOrdTpCd, String tabType, String eqType, String costCd) {
		this.dpSeq = dpSeq;
		this.tabTitle = tabTitle;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.mnrOrdTpCd = mnrOrdTpCd;
		this.eqType = eqType;
		this.tabType = tabType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("tab_title", getTabTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("mnr_ord_tp_cd", getMnrOrdTpCd());
		this.hashColumns.put("eq_type", getEqType());
		this.hashColumns.put("tab_type", getTabType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("tab_title", "tabTitle");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("mnr_ord_tp_cd", "mnrOrdTpCd");
		this.hashFields.put("eq_type", "eqType");
		this.hashFields.put("tab_type", "tabType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return tabTitle
	 */
	public String getTabTitle() {
		return this.tabTitle;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdTpCd
	 */
	public String getMnrOrdTpCd() {
		return this.mnrOrdTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqType
	 */
	public String getEqType() {
		return this.eqType;
	}
	
	/**
	 * Column Info
	 * @return tabType
	 */
	public String getTabType() {
		return this.tabType;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param tabTitle
	 */
	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdTpCd
	 */
	public void setMnrOrdTpCd(String mnrOrdTpCd) {
		this.mnrOrdTpCd = mnrOrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqType
	 */
	public void setEqType(String eqType) {
		this.eqType = eqType;
	}
	
	/**
	 * Column Info
	 * @param tabType
	 */
	public void setTabType(String tabType) {
		this.tabType = tabType;
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
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setTabTitle(JSPUtil.getParameter(request, "tab_title", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setMnrOrdTpCd(JSPUtil.getParameter(request, "mnr_ord_tp_cd", ""));
		setEqType(JSPUtil.getParameter(request, "eq_type", ""));
		setTabType(JSPUtil.getParameter(request, "tab_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomAgreementMenuDataVO[]
	 */
	public CustomAgreementMenuDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomAgreementMenuDataVO[]
	 */
	public CustomAgreementMenuDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomAgreementMenuDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq".trim(), length));
			String[] tabTitle = (JSPUtil.getParameter(request, prefix	+ "tab_title".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd".trim(), length));
			String[] mnrOrdTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_tp_cd".trim(), length));
			String[] eqType = (JSPUtil.getParameter(request, prefix	+ "eq_type".trim(), length));
			String[] tabType = (JSPUtil.getParameter(request, prefix	+ "tab_type".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomAgreementMenuDataVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (tabTitle[i] != null)
					model.setTabTitle(tabTitle[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (mnrOrdTpCd[i] != null)
					model.setMnrOrdTpCd(mnrOrdTpCd[i]);
				if (eqType[i] != null)
					model.setEqType(eqType[i]);
				if (tabType[i] != null)
					model.setTabType(tabType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomAgreementMenuDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomAgreementMenuDataVO[]
	 */
	public CustomAgreementMenuDataVO[] getCustomAgreementMenuDataVOs(){
		CustomAgreementMenuDataVO[] vos = (CustomAgreementMenuDataVO[])models.toArray(new CustomAgreementMenuDataVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabTitle = this.tabTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdTpCd = this.mnrOrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqType = this.eqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabType = this.tabType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
