/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaiwanSearchContainerDescVO.java
*@FileTitle : TaiwanSearchContainerDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.20 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.vo;

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

public class TaiwanSearchContainerDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaiwanSearchContainerDescVO> models = new ArrayList<TaiwanSearchContainerDescVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String st13 = null;
	/* Column Info */
	private String cntrDesc = null;
	/* Column Info */
	private String dPunit = null;
	/* Column Info */
	private String dPkg = null;
	/* Column Info */
	private String dWgt = null;
	/* Column Info */
	private String dCmdt = null;
	/* Column Info */
	private String dMea = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaiwanSearchContainerDescVO() {}

	public TaiwanSearchContainerDescVO(String ibflag, String pagerows, String dCmdt, String dPunit, String dPkg, String dWgt, String dMea, String cntrDesc, String st13) {
		this.ibflag = ibflag;
		this.st13 = st13;
		this.cntrDesc = cntrDesc;
		this.dPunit = dPunit;
		this.dPkg = dPkg;
		this.dWgt = dWgt;
		this.dCmdt = dCmdt;
		this.dMea = dMea;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("st_13", getSt13());
		this.hashColumns.put("cntr_desc", getCntrDesc());
		this.hashColumns.put("d_punit", getDPunit());
		this.hashColumns.put("d_pkg", getDPkg());
		this.hashColumns.put("d_wgt", getDWgt());
		this.hashColumns.put("d_cmdt", getDCmdt());
		this.hashColumns.put("d_mea", getDMea());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("st_13", "st13");
		this.hashFields.put("cntr_desc", "cntrDesc");
		this.hashFields.put("d_punit", "dPunit");
		this.hashFields.put("d_pkg", "dPkg");
		this.hashFields.put("d_wgt", "dWgt");
		this.hashFields.put("d_cmdt", "dCmdt");
		this.hashFields.put("d_mea", "dMea");
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
	 * @return st13
	 */
	public String getSt13() {
		return this.st13;
	}
	
	/**
	 * Column Info
	 * @return cntrDesc
	 */
	public String getCntrDesc() {
		return this.cntrDesc;
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
	 * @return dCmdt
	 */
	public String getDCmdt() {
		return this.dCmdt;
	}
	
	/**
	 * Column Info
	 * @return dMea
	 */
	public String getDMea() {
		return this.dMea;
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
	 * @param st13
	 */
	public void setSt13(String st13) {
		this.st13 = st13;
	}
	
	/**
	 * Column Info
	 * @param cntrDesc
	 */
	public void setCntrDesc(String cntrDesc) {
		this.cntrDesc = cntrDesc;
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
	 * @param dCmdt
	 */
	public void setDCmdt(String dCmdt) {
		this.dCmdt = dCmdt;
	}
	
	/**
	 * Column Info
	 * @param dMea
	 */
	public void setDMea(String dMea) {
		this.dMea = dMea;
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
		setSt13(JSPUtil.getParameter(request, "st_13", ""));
		setCntrDesc(JSPUtil.getParameter(request, "cntr_desc", ""));
		setDPunit(JSPUtil.getParameter(request, "d_punit", ""));
		setDPkg(JSPUtil.getParameter(request, "d_pkg", ""));
		setDWgt(JSPUtil.getParameter(request, "d_wgt", ""));
		setDCmdt(JSPUtil.getParameter(request, "d_cmdt", ""));
		setDMea(JSPUtil.getParameter(request, "d_mea", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaiwanSearchContainerDescVO[]
	 */
	public TaiwanSearchContainerDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaiwanSearchContainerDescVO[]
	 */
	public TaiwanSearchContainerDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaiwanSearchContainerDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] st13 = (JSPUtil.getParameter(request, prefix	+ "st_13", length));
			String[] cntrDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_desc", length));
			String[] dPunit = (JSPUtil.getParameter(request, prefix	+ "d_punit", length));
			String[] dPkg = (JSPUtil.getParameter(request, prefix	+ "d_pkg", length));
			String[] dWgt = (JSPUtil.getParameter(request, prefix	+ "d_wgt", length));
			String[] dCmdt = (JSPUtil.getParameter(request, prefix	+ "d_cmdt", length));
			String[] dMea = (JSPUtil.getParameter(request, prefix	+ "d_mea", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaiwanSearchContainerDescVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (st13[i] != null)
					model.setSt13(st13[i]);
				if (cntrDesc[i] != null)
					model.setCntrDesc(cntrDesc[i]);
				if (dPunit[i] != null)
					model.setDPunit(dPunit[i]);
				if (dPkg[i] != null)
					model.setDPkg(dPkg[i]);
				if (dWgt[i] != null)
					model.setDWgt(dWgt[i]);
				if (dCmdt[i] != null)
					model.setDCmdt(dCmdt[i]);
				if (dMea[i] != null)
					model.setDMea(dMea[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaiwanSearchContainerDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaiwanSearchContainerDescVO[]
	 */
	public TaiwanSearchContainerDescVO[] getTaiwanSearchContainerDescVOs(){
		TaiwanSearchContainerDescVO[] vos = (TaiwanSearchContainerDescVO[])models.toArray(new TaiwanSearchContainerDescVO[models.size()]);
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
		this.st13 = this.st13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDesc = this.cntrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPunit = this.dPunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dPkg = this.dPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dWgt = this.dWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dCmdt = this.dCmdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dMea = this.dMea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
