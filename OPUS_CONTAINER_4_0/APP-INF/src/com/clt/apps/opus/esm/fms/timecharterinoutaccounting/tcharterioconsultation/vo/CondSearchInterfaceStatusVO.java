/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchInterfaceStatusVO.java
*@FileTitle : CondSearchInterfaceStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.08.03 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondSearchInterfaceStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchInterfaceStatusVO> models = new ArrayList<CondSearchInterfaceStatusVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String searchCsrNo = null;
	/* Column Info */
	private String condition = null;
	/* Column Info */
	private String frDuration = null;
	/* Column Info */
	private String toDuration = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchInterfaceStatusVO() {}

	public CondSearchInterfaceStatusVO(String ibflag, String pagerows, String slpOfcCd, String condition, String searchCsrNo, String frDuration, String toDuration) {
		this.ibflag = ibflag;
		this.searchCsrNo = searchCsrNo;
		this.condition = condition;
		this.frDuration = frDuration;
		this.toDuration = toDuration;
		this.slpOfcCd = slpOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("search_csr_no", getSearchCsrNo());
		this.hashColumns.put("condition", getCondition());
		this.hashColumns.put("fr_duration", getFrDuration());
		this.hashColumns.put("to_duration", getToDuration());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("search_csr_no", "searchCsrNo");
		this.hashFields.put("condition", "condition");
		this.hashFields.put("fr_duration", "frDuration");
		this.hashFields.put("to_duration", "toDuration");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return searchCsrNo
	 */
	public String getSearchCsrNo() {
		return this.searchCsrNo;
	}
	
	/**
	 * Column Info
	 * @return condition
	 */
	public String getCondition() {
		return this.condition;
	}
	
	/**
	 * Column Info
	 * @return frDuration
	 */
	public String getFrDuration() {
		return this.frDuration;
	}
	
	/**
	 * Column Info
	 * @return toDuration
	 */
	public String getToDuration() {
		return this.toDuration;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param searchCsrNo
	 */
	public void setSearchCsrNo(String searchCsrNo) {
		this.searchCsrNo = searchCsrNo;
	}
	
	/**
	 * Column Info
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	/**
	 * Column Info
	 * @param frDuration
	 */
	public void setFrDuration(String frDuration) {
		this.frDuration = frDuration;
	}
	
	/**
	 * Column Info
	 * @param toDuration
	 */
	public void setToDuration(String toDuration) {
		this.toDuration = toDuration;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSearchCsrNo(JSPUtil.getParameter(request, "search_csr_no", ""));
		setCondition(JSPUtil.getParameter(request, "condition", ""));
		setFrDuration(JSPUtil.getParameter(request, "fr_duration", ""));
		setToDuration(JSPUtil.getParameter(request, "to_duration", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchInterfaceStatusVO[]
	 */
	public CondSearchInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchInterfaceStatusVO[]
	 */
	public CondSearchInterfaceStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchInterfaceStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] searchCsrNo = (JSPUtil.getParameter(request, prefix	+ "search_csr_no", length));
			String[] condition = (JSPUtil.getParameter(request, prefix	+ "condition", length));
			String[] frDuration = (JSPUtil.getParameter(request, prefix	+ "fr_duration", length));
			String[] toDuration = (JSPUtil.getParameter(request, prefix	+ "to_duration", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchInterfaceStatusVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (searchCsrNo[i] != null)
					model.setSearchCsrNo(searchCsrNo[i]);
				if (condition[i] != null)
					model.setCondition(condition[i]);
				if (frDuration[i] != null)
					model.setFrDuration(frDuration[i]);
				if (toDuration[i] != null)
					model.setToDuration(toDuration[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchInterfaceStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchInterfaceStatusVO[]
	 */
	public CondSearchInterfaceStatusVO[] getCondSearchInterfaceStatusVOs(){
		CondSearchInterfaceStatusVO[] vos = (CondSearchInterfaceStatusVO[])models.toArray(new CondSearchInterfaceStatusVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchCsrNo = this.searchCsrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condition = this.condition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frDuration = this.frDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDuration = this.toDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
