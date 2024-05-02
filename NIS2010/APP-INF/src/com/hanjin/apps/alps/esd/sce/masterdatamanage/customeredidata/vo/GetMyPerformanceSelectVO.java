/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetMyPerformanceSelectVO.java
*@FileTitle : GetMyPerformanceSelectVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.08.21 전병석 
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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetMyPerformanceSelectVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetMyPerformanceSelectVO> models = new ArrayList<GetMyPerformanceSelectVO>();
	
	/* Column Info */
	private String edi_cgo_rmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cust_trd_prnr_id = null;
	/* Column Info */
	private String edi_grp_desc = null;
	/* Column Info */
	private String edi_grp_cd = null;
	/* Page Number */
	private String pagerows = null;
	
	private String edi_sts = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetMyPerformanceSelectVO() {}

	public GetMyPerformanceSelectVO(String ibflag, String pagerows, String edi_grp_cd, String cust_trd_prnr_id, String edi_grp_desc, String edi_cgo_rmk, String edi_sts) {
		this.edi_cgo_rmk = edi_cgo_rmk;
		this.ibflag = ibflag;
		this.cust_trd_prnr_id = cust_trd_prnr_id;
		this.edi_grp_desc = edi_grp_desc;
		this.edi_grp_cd = edi_grp_cd;
		this.edi_sts = edi_sts;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edi_cgo_rmk", getEdi_cgo_rmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cust_trd_prnr_id", getCust_trd_prnr_id());
		this.hashColumns.put("edi_grp_desc", getEdi_grp_desc());
		this.hashColumns.put("edi_grp_cd", getEdi_grp_cd());
		this.hashColumns.put("edi_sts", getEdi_sts());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edi_cgo_rmk", "edi_cgo_rmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cust_trd_prnr_id", "cust_trd_prnr_id");
		this.hashFields.put("edi_grp_desc", "edi_grp_desc");
		this.hashFields.put("edi_grp_cd", "edi_grp_cd");
		this.hashFields.put("edi_sts", "edi_sts");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return edi_sts
	 */
	public String getEdi_sts() {
		return this.edi_sts;
	}
	
	/**
	 * Column Info
	 * @return d
	 */
	public String getEdi_cgo_rmk() {
		return this.edi_cgo_rmk;
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
	 * @return b
	 */
	public String getCust_trd_prnr_id() {
		return this.cust_trd_prnr_id;
	}
	
	/**
	 * Column Info
	 * @return c
	 */
	public String getEdi_grp_desc() {
		return this.edi_grp_desc;
	}
	
	/**
	 * Column Info
	 * @return a
	 */
	public String getEdi_grp_cd() {
		return this.edi_grp_cd;
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
	 * @param d
	 */
	public void setEdi_sts(String edi_sts) {
		this.edi_sts = edi_sts;
	}

	/**
	 * Column Info
	 * @param d
	 */
	public void setEdi_cgo_rmk(String edi_cgo_rmk) {
		this.edi_cgo_rmk = edi_cgo_rmk;
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
	 * @param b
	 */
	public void setCust_trd_prnr_id(String cust_trd_prnr_id) {
		this.cust_trd_prnr_id = cust_trd_prnr_id;
	}
	
	/**
	 * Column Info
	 * @param c
	 */
	public void setEdi_grp_desc(String edi_grp_desc) {
		this.edi_grp_desc = edi_grp_desc;
	}
	
	/**
	 * Column Info
	 * @param a
	 */
	public void setEdi_grp_cd(String a) {
		this.edi_grp_cd = edi_grp_cd;
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
		setEdi_cgo_rmk(JSPUtil.getParameter(request, "edi_cgo_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCust_trd_prnr_id(JSPUtil.getParameter(request, "cust_trd_prnr_id", ""));
		setEdi_grp_desc(JSPUtil.getParameter(request, "edi_grp_desc", ""));
		setEdi_grp_cd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setEdi_sts(JSPUtil.getParameter(request, "edi_sts", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetMyPerformanceSelectVO[]
	 */
	public GetMyPerformanceSelectVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetMyPerformanceSelectVO[]
	 */
	public GetMyPerformanceSelectVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetMyPerformanceSelectVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] d = (JSPUtil.getParameter(request, prefix	+ "edi_cgo_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cust_trd_prnr_id = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] edi_grp_desc = (JSPUtil.getParameter(request, prefix	+ "edi_grp_desc", length));
			String[] edi_grp_cd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] edi_sts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetMyPerformanceSelectVO();
				if (d[i] != null)
					model.setEdi_cgo_rmk(d[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cust_trd_prnr_id[i] != null)
					model.setCust_trd_prnr_id(cust_trd_prnr_id[i]);
				if (edi_grp_desc[i] != null)
					model.setEdi_grp_desc(edi_grp_desc[i]);
				if (edi_grp_cd[i] != null)
					model.setEdi_grp_cd(edi_grp_cd[i]);
				if (edi_sts[i] != null)
					model.setEdi_sts(edi_sts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetMyPerformanceSelectVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetMyPerformanceSelectVO[]
	 */
	public GetMyPerformanceSelectVO[] getGetMyPerformanceSelectVOs(){
		GetMyPerformanceSelectVO[] vos = (GetMyPerformanceSelectVO[])models.toArray(new GetMyPerformanceSelectVO[models.size()]);
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
		this.edi_cgo_rmk = this.edi_cgo_rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cust_trd_prnr_id = this.cust_trd_prnr_id .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi_grp_desc = this.edi_grp_desc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi_grp_cd = this.edi_grp_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi_sts = this.edi_sts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
