/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfDecEdiRtVO.java
*@FileTitle : KrWhfDecEdiRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.10.21 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfDecEdiRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfDecEdiRtVO> models = new ArrayList<KrWhfDecEdiRtVO>();
	
	/* Column Info */
	private String amount = null;
	/* Column Info */
	private String dcCd = null;
	/* Column Info */
	private String unit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rton = null;
	/* Column Info */
	private String dcReason = null;
	/* Column Info */
	private String dschInd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfDecEdiRtVO() {}

	public KrWhfDecEdiRtVO(String ibflag, String pagerows, String rton, String dschInd, String dcCd, String dcReason, String unit, String amount) {
		this.amount = amount;
		this.dcCd = dcCd;
		this.unit = unit;
		this.ibflag = ibflag;
		this.rton = rton;
		this.dcReason = dcReason;
		this.dschInd = dschInd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("dc_cd", getDcCd());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rton", getRton());
		this.hashColumns.put("dc_reason", getDcReason());
		this.hashColumns.put("dsch_ind", getDschInd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amount", "amount");
		this.hashFields.put("dc_cd", "dcCd");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rton", "rton");
		this.hashFields.put("dc_reason", "dcReason");
		this.hashFields.put("dsch_ind", "dschInd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
	}
	
	/**
	 * Column Info
	 * @return dcCd
	 */
	public String getDcCd() {
		return this.dcCd;
	}
	
	/**
	 * Column Info
	 * @return unit
	 */
	public String getUnit() {
		return this.unit;
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
	 * @return rton
	 */
	public String getRton() {
		return this.rton;
	}
	
	/**
	 * Column Info
	 * @return dcReason
	 */
	public String getDcReason() {
		return this.dcReason;
	}
	
	/**
	 * Column Info
	 * @return dschInd
	 */
	public String getDschInd() {
		return this.dschInd;
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
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * Column Info
	 * @param dcCd
	 */
	public void setDcCd(String dcCd) {
		this.dcCd = dcCd;
	}
	
	/**
	 * Column Info
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
	 * @param rton
	 */
	public void setRton(String rton) {
		this.rton = rton;
	}
	
	/**
	 * Column Info
	 * @param dcReason
	 */
	public void setDcReason(String dcReason) {
		this.dcReason = dcReason;
	}
	
	/**
	 * Column Info
	 * @param dschInd
	 */
	public void setDschInd(String dschInd) {
		this.dschInd = dschInd;
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
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setDcCd(JSPUtil.getParameter(request, "dc_cd", ""));
		setUnit(JSPUtil.getParameter(request, "unit", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRton(JSPUtil.getParameter(request, "rton", ""));
		setDcReason(JSPUtil.getParameter(request, "dc_reason", ""));
		setDschInd(JSPUtil.getParameter(request, "dsch_ind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfDecEdiRtVO[]
	 */
	public KrWhfDecEdiRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfDecEdiRtVO[]
	 */
	public KrWhfDecEdiRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfDecEdiRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] dcCd = (JSPUtil.getParameter(request, prefix	+ "dc_cd", length));
			String[] unit = (JSPUtil.getParameter(request, prefix	+ "unit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rton = (JSPUtil.getParameter(request, prefix	+ "rton", length));
			String[] dcReason = (JSPUtil.getParameter(request, prefix	+ "dc_reason", length));
			String[] dschInd = (JSPUtil.getParameter(request, prefix	+ "dsch_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfDecEdiRtVO();
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (dcCd[i] != null)
					model.setDcCd(dcCd[i]);
				if (unit[i] != null)
					model.setUnit(unit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rton[i] != null)
					model.setRton(rton[i]);
				if (dcReason[i] != null)
					model.setDcReason(dcReason[i]);
				if (dschInd[i] != null)
					model.setDschInd(dschInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfDecEdiRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfDecEdiRtVO[]
	 */
	public KrWhfDecEdiRtVO[] getKrWhfDecEdiRtVOs(){
		KrWhfDecEdiRtVO[] vos = (KrWhfDecEdiRtVO[])models.toArray(new KrWhfDecEdiRtVO[models.size()]);
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
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcCd = this.dcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit = this.unit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rton = this.rton .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcReason = this.dcReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dschInd = this.dschInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
