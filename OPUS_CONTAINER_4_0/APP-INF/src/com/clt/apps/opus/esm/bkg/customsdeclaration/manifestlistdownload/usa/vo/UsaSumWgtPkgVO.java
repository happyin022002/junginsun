/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaSumWgtPkgVO.java
*@FileTitle : UsaSumWgtPkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.18 이수빈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이수빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaSumWgtPkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaSumWgtPkgVO> models = new ArrayList<UsaSumWgtPkgVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String sumCntrWgtQty = null;
	/* Column Info */
	private String sumCntrPckQty = null;
	/* Column Info */
	private String actWgt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaSumWgtPkgVO() {}

	public UsaSumWgtPkgVO(String ibflag, String pagerows, String sumCntrPckQty, String sumCntrWgtQty, String pckQty, String actWgt) {
		this.ibflag = ibflag;
		this.pckQty = pckQty;
		this.sumCntrWgtQty = sumCntrWgtQty;
		this.sumCntrPckQty = sumCntrPckQty;
		this.actWgt = actWgt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("sum_cntr_wgt_qty", getSumCntrWgtQty());
		this.hashColumns.put("sum_cntr_pck_qty", getSumCntrPckQty());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("sum_cntr_wgt_qty", "sumCntrWgtQty");
		this.hashFields.put("sum_cntr_pck_qty", "sumCntrPckQty");
		this.hashFields.put("act_wgt", "actWgt");
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return sumCntrWgtQty
	 */
	public String getSumCntrWgtQty() {
		return this.sumCntrWgtQty;
	}
	
	/**
	 * Column Info
	 * @return sumCntrPckQty
	 */
	public String getSumCntrPckQty() {
		return this.sumCntrPckQty;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param sumCntrWgtQty
	 */
	public void setSumCntrWgtQty(String sumCntrWgtQty) {
		this.sumCntrWgtQty = sumCntrWgtQty;
	}
	
	/**
	 * Column Info
	 * @param sumCntrPckQty
	 */
	public void setSumCntrPckQty(String sumCntrPckQty) {
		this.sumCntrPckQty = sumCntrPckQty;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setSumCntrWgtQty(JSPUtil.getParameter(request, "sum_cntr_wgt_qty", ""));
		setSumCntrPckQty(JSPUtil.getParameter(request, "sum_cntr_pck_qty", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaSumWgtPkgVO[]
	 */
	public UsaSumWgtPkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaSumWgtPkgVO[]
	 */
	public UsaSumWgtPkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaSumWgtPkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] sumCntrWgtQty = (JSPUtil.getParameter(request, prefix	+ "sum_cntr_wgt_qty", length));
			String[] sumCntrPckQty = (JSPUtil.getParameter(request, prefix	+ "sum_cntr_pck_qty", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaSumWgtPkgVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (sumCntrWgtQty[i] != null)
					model.setSumCntrWgtQty(sumCntrWgtQty[i]);
				if (sumCntrPckQty[i] != null)
					model.setSumCntrPckQty(sumCntrPckQty[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaSumWgtPkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaSumWgtPkgVO[]
	 */
	public UsaSumWgtPkgVO[] getUsaSumWgtPkgVOs(){
		UsaSumWgtPkgVO[] vos = (UsaSumWgtPkgVO[])models.toArray(new UsaSumWgtPkgVO[models.size()]);
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
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCntrWgtQty = this.sumCntrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumCntrPckQty = this.sumCntrPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}