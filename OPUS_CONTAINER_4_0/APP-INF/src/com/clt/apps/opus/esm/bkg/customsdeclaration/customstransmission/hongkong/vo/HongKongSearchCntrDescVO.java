/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongSearchCntrDescVO.java
*@FileTitle : HongKongSearchCntrDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.17 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HongKongSearchCntrDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HongKongSearchCntrDescVO> models = new ArrayList<HongKongSearchCntrDescVO>();
	
	/* Column Info */
	private String dMunit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dMeas = null;
	/* Column Info */
	private String cusMark = null;
	/* Column Info */
	private String dDesc = null;
	/* Column Info */
	private String dPunit = null;
	/* Column Info */
	private String dPkg = null;
	/* Column Info */
	private String dWgt = null;
	/* Column Info */
	private String dWunit = null;
	/* Column Info */
	private String dCmdt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HongKongSearchCntrDescVO() {}

	public HongKongSearchCntrDescVO(String ibflag, String pagerows, String dCmdt, String dPunit, String dPkg, String dWunit, String dWgt, String dMunit, String dMeas, String dDesc, String cusMark) {
		this.dMunit = dMunit;
		this.ibflag = ibflag;
		this.dMeas = dMeas;
		this.cusMark = cusMark;
		this.dDesc = dDesc;
		this.dPunit = dPunit;
		this.dPkg = dPkg;
		this.dWgt = dWgt;
		this.dWunit = dWunit;
		this.dCmdt = dCmdt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("d_munit", getDMunit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("d_meas", getDMeas());
		this.hashColumns.put("cus_mark", getCusMark());
		this.hashColumns.put("d_desc", getDDesc());
		this.hashColumns.put("d_punit", getDPunit());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("d_wgt", getDWgt());
		this.hashColumns.put("d_wunit", getDWunit());
		this.hashColumns.put("d_cmdt", getDCmdt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("d_munit", "dMunit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("d_meas", "dMeas");
		this.hashFields.put("cus_mark", "cusMark");
		this.hashFields.put("d_desc", "dDesc");
		this.hashFields.put("d_punit", "dPunit");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("d_wgt", "dWgt");
		this.hashFields.put("d_wunit", "dWunit");
		this.hashFields.put("d_cmdt", "dCmdt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dMunit
	 */
	public String getDMunit() {
		return this.dMunit;
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
	 * @return dMeas
	 */
	public String getDMeas() {
		return this.dMeas;
	}
	
	/**
	 * Column Info
	 * @return cusMark
	 */
	public String getCusMark() {
		return this.cusMark;
	}
	
	/**
	 * Column Info
	 * @return dDesc
	 */
	public String getDDesc() {
		return this.dDesc;
	}
	
	/**
	 * Column Info
	 * @return dPunit
	 */
	public String getDPunit() {
		return this.dPunit;
	}
	
	/**
	 * Column Info
	 * @return dPkg
	 */
	public String getDPkg() {
		return this.dPkg;
	}
	
	/**
	 * Column Info
	 * @return dWgt
	 */
	public String getDWgt() {
		return this.dWgt;
	}
	
	/**
	 * Column Info
	 * @return dWunit
	 */
	public String getDWunit() {
		return this.dWunit;
	}
	
	/**
	 * Column Info
	 * @return dCmdt
	 */
	public String getDCmdt() {
		return this.dCmdt;
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
	 * @param dMunit
	 */
	public void setDMunit(String dMunit) {
		this.dMunit = dMunit;
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
	 * @param dMeas
	 */
	public void setDMeas(String dMeas) {
		this.dMeas = dMeas;
	}
	
	/**
	 * Column Info
	 * @param cusMark
	 */
	public void setCusMark(String cusMark) {
		this.cusMark = cusMark;
	}
	
	/**
	 * Column Info
	 * @param dDesc
	 */
	public void setDDesc(String dDesc) {
		this.dDesc = dDesc;
	}
	
	/**
	 * Column Info
	 * @param dPunit
	 */
	public void setDPunit(String dPunit) {
		this.dPunit = dPunit;
	}
	
	/**
	 * Column Info
	 * @param dPkg
	 */
	public void setDPkg(String dPkg) {
		this.dPkg = dPkg;
	}
	
	/**
	 * Column Info
	 * @param dWgt
	 */
	public void setDWgt(String dWgt) {
		this.dWgt = dWgt;
	}
	
	/**
	 * Column Info
	 * @param dWunit
	 */
	public void setDWunit(String dWunit) {
		this.dWunit = dWunit;
	}
	
	/**
	 * Column Info
	 * @param dCmdt
	 */
	public void setDCmdt(String dCmdt) {
		this.dCmdt = dCmdt;
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
		setDMunit(JSPUtil.getParameter(request, "d_munit", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDMeas(JSPUtil.getParameter(request, "d_meas", ""));
		setCusMark(JSPUtil.getParameter(request, "cus_mark", ""));
		setDDesc(JSPUtil.getParameter(request, "d_desc", ""));
		setDPunit(JSPUtil.getParameter(request, "d_punit", ""));
		setDPkg(JSPUtil.getParameter(request, "d_pkg", ""));
		setDWgt(JSPUtil.getParameter(request, "d_wgt", ""));
		setDWunit(JSPUtil.getParameter(request, "d_wunit", ""));
		setDCmdt(JSPUtil.getParameter(request, "d_cmdt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HongKongSearchCntrDescVO[]
	 */
	public HongKongSearchCntrDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HongKongSearchCntrDescVO[]
	 */
	public HongKongSearchCntrDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HongKongSearchCntrDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dMunit = (JSPUtil.getParameter(request, prefix	+ "d_munit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dMeas = (JSPUtil.getParameter(request, prefix	+ "d_meas", length));
			String[] cusMark = (JSPUtil.getParameter(request, prefix	+ "cus_mark", length));
			String[] dDesc = (JSPUtil.getParameter(request, prefix	+ "d_desc", length));
			String[] dPunit = (JSPUtil.getParameter(request, prefix	+ "d_punit", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] dWgt = (JSPUtil.getParameter(request, prefix	+ "d_wgt", length));
			String[] dWunit = (JSPUtil.getParameter(request, prefix	+ "d_wunit", length));
			String[] dCmdt = (JSPUtil.getParameter(request, prefix	+ "d_cmdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new HongKongSearchCntrDescVO();
				if (dMunit[i] != null)
					model.setDMunit(dMunit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dMeas[i] != null)
					model.setDMeas(dMeas[i]);
				if (cusMark[i] != null)
					model.setCusMark(cusMark[i]);
				if (dDesc[i] != null)
					model.setDDesc(dDesc[i]);
				if (dPunit[i] != null)
					model.setDPunit(dPunit[i]);
				if (dPkg[i] != null)
					model.setDPkg(dPkg[i]);
				if (dWgt[i] != null)
					model.setDWgt(dWgt[i]);
				if (dWunit[i] != null)
					model.setDWunit(dWunit[i]);
				if (dCmdt[i] != null)
					model.setDCmdt(dCmdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHongKongSearchCntrDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HongKongSearchCntrDescVO[]
	 */
	public HongKongSearchCntrDescVO[] getHongKongSearchCntrDescVOs(){
		HongKongSearchCntrDescVO[] vos = (HongKongSearchCntrDescVO[])models.toArray(new HongKongSearchCntrDescVO[models.size()]);
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
		this.dMunit = this.dMunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMeas = this.dMeas .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusMark = this.cusMark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dDesc = this.dDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPunit = this.dPunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWgt = this.dWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWunit = this.dWunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmdt = this.dCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
