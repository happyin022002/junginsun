/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrTypzQtyVO.java
*@FileTitle : CntrTypzQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.18 이혜민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo;

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
 * @author 이혜민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrTypzQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrTypzQtyVO> models = new ArrayList<CntrTypzQtyVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String awkCgoQty = null;
	/* Column Info */
	private String dCgoQty = null;
	/* Column Info */
	private String rfCgoQty = null;
	/* Column Info */
	private String bbCgoQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String eqTpsz = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrTypzQtyVO() {}

	public CntrTypzQtyVO(String ibflag, String pagerows, String cntrTpszCd, String opCntrQty, String awkCgoQty, String dCgoQty, String rfCgoQty, String bbCgoQty, String eqTpsz) {
		this.ibflag = ibflag;
		this.awkCgoQty = awkCgoQty;
		this.dCgoQty = dCgoQty;
		this.rfCgoQty = rfCgoQty;
		this.bbCgoQty = bbCgoQty;
		this.cntrTpszCd = cntrTpszCd;
		this.opCntrQty = opCntrQty;
		this.eqTpsz = eqTpsz;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("awk_cgo_qty", getAwkCgoQty());
		this.hashColumns.put("dcgo_qty", getDCgoQty());
		this.hashColumns.put("rf_cgo_qty", getRfCgoQty());
		this.hashColumns.put("bb_cgo_qty", getBbCgoQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("eq_tpsz", getEqTpsz());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("awk_cgo_qty", "awkCgoQty");
		this.hashFields.put("dcgo_qty", "dCgoQty");
		this.hashFields.put("rf_cgo_qty", "rfCgoQty");
		this.hashFields.put("bb_cgo_qty", "bbCgoQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("eq_tpsz", "eqTpsz");
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
	 * @return awkCgoQty
	 */
	public String getAwkCgoQty() {
		return this.awkCgoQty;
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
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return eqTpsz
	 */
	public String getEqTpsz() {
		return this.eqTpsz;
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
	 * @param awkCgoQty
	 */
	public void setAwkCgoQty(String awkCgoQty) {
		this.awkCgoQty = awkCgoQty;
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
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param eqTpsz
	 */
	public void setEqTpsz(String eqTpsz) {
		this.eqTpsz = eqTpsz;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
		
	/**
	 * @return the dCgoQty
	 */
	public String getDCgoQty() {
		return dCgoQty;
	}

	/**
	 * @param cgoQty the dCgoQty to set
	 */
	public void setDCgoQty(String cgoQty) {
		dCgoQty = cgoQty;
	}

	/**
	 * @return the rfCgoQty
	 */
	public String getRfCgoQty() {
		return rfCgoQty;
	}

	/**
	 * @param rfCgoQty the rfCgoQty to set
	 */
	public void setRfCgoQty(String rfCgoQty) {
		this.rfCgoQty = rfCgoQty;
	}

	/**
	 * @return the bbCgoQty
	 */
	public String getBbCgoQty() {
		return bbCgoQty;
	}

	/**
	 * @param bbCgoQty the bbCgoQty to set
	 */
	public void setBbCgoQty(String bbCgoQty) {
		this.bbCgoQty = bbCgoQty;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAwkCgoQty(JSPUtil.getParameter(request, "awk_cgo_qty", ""));
		setDCgoQty(JSPUtil.getParameter(request, "dcgo_qty", ""));
		setRfCgoQty(JSPUtil.getParameter(request, "rf_cgo_qty", ""));
		setBbCgoQty(JSPUtil.getParameter(request, "bb_cgo_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setEqTpsz(JSPUtil.getParameter(request, "eq_tpsz", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrTypzQtyVO[]
	 */
	public CntrTypzQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrTypzQtyVO[]
	 */
	public CntrTypzQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrTypzQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] awkCgoQty = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_qty", length));
			String[] dCgoQty = (JSPUtil.getParameter(request, prefix	+ "dcgo_qty", length));
			String[] rfCgoQty = (JSPUtil.getParameter(request, prefix	+ "rf_cgo_qty", length));
			String[] bbCgoQty = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] eqTpsz = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrTypzQtyVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (awkCgoQty[i] != null)
					model.setAwkCgoQty(awkCgoQty[i]);
				if (dCgoQty[i] != null)
					model.setDCgoQty(dCgoQty[i]);
				if (rfCgoQty[i] != null)
					model.setRfCgoQty(rfCgoQty[i]);
				if (bbCgoQty[i] != null)
					model.setBbCgoQty(bbCgoQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (eqTpsz[i] != null)
					model.setEqTpsz(eqTpsz[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrTypzQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrTypzQtyVO[]
	 */
	public CntrTypzQtyVO[] getCntrTypzQtyVOs(){
		CntrTypzQtyVO[] vos = (CntrTypzQtyVO[])models.toArray(new CntrTypzQtyVO[models.size()]);
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
		this.awkCgoQty = this.awkCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCgoQty = this.dCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCgoQty = this.rfCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoQty = this.bbCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpsz = this.eqTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
