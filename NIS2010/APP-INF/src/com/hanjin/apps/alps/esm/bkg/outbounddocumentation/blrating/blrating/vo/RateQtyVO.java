/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateQtyVO.java
*@FileTitle : RateQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.23 김태경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RateQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RateQtyVO> models = new ArrayList<RateQtyVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqSubQty = null;
	/* Column Info */
	private String eqSub = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String qty = null;
	/* Column Info */
	private String ibFlag = null;
	/* Column Info */
	private String cgo = null;
	/* Column Info */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RateQtyVO() {}

	public RateQtyVO(String ibflag, String pagerows, String ibFlag, String cntrTpszCd, String qty, String cgo, String eqSub, String eqSubQty) {
		this.ibflag = ibflag;
		this.eqSubQty = eqSubQty;
		this.eqSub = eqSub;
		this.cntrTpszCd = cntrTpszCd;
		this.qty = qty;
		this.ibFlag = ibFlag;
		this.cgo = cgo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_sub_qty", getEqSubQty());
		this.hashColumns.put("eq_sub", getEqSub());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("ib_flag", getIbFlag());
		this.hashColumns.put("cgo", getCgo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_sub_qty", "eqSubQty");
		this.hashFields.put("eq_sub", "eqSub");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("ib_flag", "ibFlag");
		this.hashFields.put("cgo", "cgo");
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
	 * @return eqSubQty
	 */
	public String getEqSubQty() {
		return this.eqSubQty;
	}
	
	/**
	 * Column Info
	 * @return eqSub
	 */
	public String getEqSub() {
		return this.eqSub;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
	}
	
	/**
	 * Column Info
	 * @return ibFlag
	 */
	public String getIbFlag() {
		return this.ibFlag;
	}
	
	/**
	 * Column Info
	 * @return cgo
	 */
	public String getCgo() {
		return this.cgo;
	}
	
	/**
	 * Column Info
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
	 * @param eqSubQty
	 */
	public void setEqSubQty(String eqSubQty) {
		this.eqSubQty = eqSubQty;
	}
	
	/**
	 * Column Info
	 * @param eqSub
	 */
	public void setEqSub(String eqSub) {
		this.eqSub = eqSub;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	/**
	 * Column Info
	 * @param ibFlag
	 */
	public void setIbFlag(String ibFlag) {
		this.ibFlag = ibFlag;
	}
	
	/**
	 * Column Info
	 * @param cgo
	 */
	public void setCgo(String cgo) {
		this.cgo = cgo;
	}
	
	/**
	 * Column Info
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
		setEqSubQty(JSPUtil.getParameter(request, "eq_sub_qty", ""));
		setEqSub(JSPUtil.getParameter(request, "eq_sub", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setQty(JSPUtil.getParameter(request, "qty", ""));
		setIbFlag(JSPUtil.getParameter(request, "ib_flag", ""));
		setCgo(JSPUtil.getParameter(request, "cgo", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RateQtyVO[]
	 */
	public RateQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RateQtyVO[]
	 */
	public RateQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RateQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqSubQty = (JSPUtil.getParameter(request, prefix	+ "eq_sub_qty", length));
			String[] eqSub = (JSPUtil.getParameter(request, prefix	+ "eq_sub", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] ibFlag = (JSPUtil.getParameter(request, prefix	+ "ib_flag", length));
			String[] cgo = (JSPUtil.getParameter(request, prefix	+ "cgo", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RateQtyVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqSubQty[i] != null)
					model.setEqSubQty(eqSubQty[i]);
				if (eqSub[i] != null)
					model.setEqSub(eqSub[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (ibFlag[i] != null)
					model.setIbFlag(ibFlag[i]);
				if (cgo[i] != null)
					model.setCgo(cgo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRateQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RateQtyVO[]
	 */
	public RateQtyVO[] getRateQtyVOs(){
		RateQtyVO[] vos = (RateQtyVO[])models.toArray(new RateQtyVO[models.size()]);
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
		this.eqSubQty = this.eqSubQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSub = this.eqSub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFlag = this.ibFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgo = this.cgo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
