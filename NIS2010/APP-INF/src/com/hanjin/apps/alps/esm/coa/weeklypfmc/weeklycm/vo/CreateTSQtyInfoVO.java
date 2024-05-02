/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreateTSQtyInfoVO.java
*@FileTitle : CreateTSQtyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.16 김기대 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreateTSQtyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateTSQtyInfoVO> models = new ArrayList<CreateTSQtyInfoVO>();
	
	/* Column Info */
	private String costYrwkMin = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrwkMax = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateTSQtyInfoVO() {}

	public CreateTSQtyInfoVO(String ibflag, String pagerows, String costYrwkMin, String costYrwkMax) {
		this.costYrwkMin = costYrwkMin;
		this.ibflag = ibflag;
		this.costYrwkMax = costYrwkMax;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_yrwk_min", getCostYrwkMin());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrwk_max", getCostYrwkMax());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_yrwk_min", "costYrwkMin");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrwk_max", "costYrwkMax");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costYrwkMin
	 */
	public String getCostYrwkMin() {
		return this.costYrwkMin;
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
	 * @return costYrwkMax
	 */
	public String getCostYrwkMax() {
		return this.costYrwkMax;
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
	 * @param costYrwkMin
	 */
	public void setCostYrwkMin(String costYrwkMin) {
		this.costYrwkMin = costYrwkMin;
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
	 * @param costYrwkMax
	 */
	public void setCostYrwkMax(String costYrwkMax) {
		this.costYrwkMax = costYrwkMax;
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
		setCostYrwkMin(JSPUtil.getParameter(request, "cost_yrwk_min", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrwkMax(JSPUtil.getParameter(request, "cost_yrwk_max", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateTSQtyInfoVO[]
	 */
	public CreateTSQtyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateTSQtyInfoVO[]
	 */
	public CreateTSQtyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateTSQtyInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costYrwkMin = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk_min", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrwkMax = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk_max", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreateTSQtyInfoVO();
				if (costYrwkMin[i] != null)
					model.setCostYrwkMin(costYrwkMin[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrwkMax[i] != null)
					model.setCostYrwkMax(costYrwkMax[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateTSQtyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateTSQtyInfoVO[]
	 */
	public CreateTSQtyInfoVO[] getCreateTSQtyInfoVOs(){
		CreateTSQtyInfoVO[] vos = (CreateTSQtyInfoVO[])models.toArray(new CreateTSQtyInfoVO[models.size()]);
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
		this.costYrwkMin = this.costYrwkMin .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwkMax = this.costYrwkMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
