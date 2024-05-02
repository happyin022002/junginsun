/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ToDmtTariffTypeVO.java
*@FileTitle : ToDmtTariffTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.07.03 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ToDmtTariffTypeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ToDmtTariffTypeVO> models = new ArrayList<ToDmtTariffTypeVO>();
	
	/* Column Info */
	private String toOrgDestContiCd = null;
	/* Column Info */
	private String toCvrgContiCd = null;
	/* Column Info */
	private String toCvrgSteCd = null;
	/* Column Info */
	private String toOrgDestCntCd = null;
	/* Column Info */
	private String toCvrgYdCd = null;
	/* Column Info */
	private String toOrgDestLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toOrgDestSteCd = null;
	/* Column Info */
	private String toCvrgCntCd = null;
	/* Column Info */
	private String toCvrgLocCd = null;
	/* Column Info */
	private String toCvrgRgnCd = null;
	/* Column Info */
	private String toOrgDestRgnCd = null;
	/* Column Info */
	private String toDmdtDeTermCd = null;
	/* Column Info */
	private String toDmdtDeTermNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ToDmtTariffTypeVO() {}

	public ToDmtTariffTypeVO(String ibflag, String pagerows, String toCvrgCntCd, String toCvrgContiCd, String toCvrgLocCd, String toCvrgRgnCd, String toCvrgSteCd, String toCvrgYdCd, String toOrgDestCntCd, String toOrgDestContiCd, String toOrgDestLocCd, String toOrgDestRgnCd, String toOrgDestSteCd, String toDmdtDeTermCd, String toDmdtDeTermNm) {
		this.toOrgDestContiCd = toOrgDestContiCd;
		this.toCvrgContiCd = toCvrgContiCd;
		this.toCvrgSteCd = toCvrgSteCd;
		this.toOrgDestCntCd = toOrgDestCntCd;
		this.toCvrgYdCd = toCvrgYdCd;
		this.toOrgDestLocCd = toOrgDestLocCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.toOrgDestSteCd = toOrgDestSteCd;
		this.toCvrgCntCd = toCvrgCntCd;
		this.toCvrgLocCd = toCvrgLocCd;
		this.toCvrgRgnCd = toCvrgRgnCd;
		this.toOrgDestRgnCd = toOrgDestRgnCd;
		this.toDmdtDeTermCd = toDmdtDeTermCd;
		this.toDmdtDeTermNm = toDmdtDeTermNm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_org_dest_conti_cd", getToOrgDestContiCd());
		this.hashColumns.put("to_cvrg_conti_cd", getToCvrgContiCd());
		this.hashColumns.put("to_cvrg_ste_cd", getToCvrgSteCd());
		this.hashColumns.put("to_org_dest_cnt_cd", getToOrgDestCntCd());
		this.hashColumns.put("to_cvrg_yd_cd", getToCvrgYdCd());
		this.hashColumns.put("to_org_dest_loc_cd", getToOrgDestLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_org_dest_ste_cd", getToOrgDestSteCd());
		this.hashColumns.put("to_cvrg_cnt_cd", getToCvrgCntCd());
		this.hashColumns.put("to_cvrg_loc_cd", getToCvrgLocCd());
		this.hashColumns.put("to_cvrg_rgn_cd", getToCvrgRgnCd());
		this.hashColumns.put("to_org_dest_rgn_cd", getToOrgDestRgnCd());
		this.hashColumns.put("to_dmdt_de_term_cd", getToDmdtDeTermCd());
		this.hashColumns.put("to_dmdt_de_term_nm", getToDmdtDeTermNm());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_org_dest_conti_cd", "toOrgDestContiCd");
		this.hashFields.put("to_cvrg_conti_cd", "toCvrgContiCd");
		this.hashFields.put("to_cvrg_ste_cd", "toCvrgSteCd");
		this.hashFields.put("to_org_dest_cnt_cd", "toOrgDestCntCd");
		this.hashFields.put("to_cvrg_yd_cd", "toCvrgYdCd");
		this.hashFields.put("to_org_dest_loc_cd", "toOrgDestLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_org_dest_ste_cd", "toOrgDestSteCd");
		this.hashFields.put("to_cvrg_cnt_cd", "toCvrgCntCd");
		this.hashFields.put("to_cvrg_loc_cd", "toCvrgLocCd");
		this.hashFields.put("to_cvrg_rgn_cd", "toCvrgRgnCd");
		this.hashFields.put("to_org_dest_rgn_cd", "toOrgDestRgnCd");
		this.hashFields.put("to_dmdt_de_term_cd", "toDmdtDeTermCd");
		this.hashFields.put("to_dmdt_de_term_nm", "toDmdtDeTermNm");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toOrgDestContiCd
	 */
	public String getToOrgDestContiCd() {
		return this.toOrgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @return toCvrgContiCd
	 */
	public String getToCvrgContiCd() {
		return this.toCvrgContiCd;
	}
	
	/**
	 * Column Info
	 * @return toCvrgSteCd
	 */
	public String getToCvrgSteCd() {
		return this.toCvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @return toOrgDestCntCd
	 */
	public String getToOrgDestCntCd() {
		return this.toOrgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return toCvrgYdCd
	 */
	public String getToCvrgYdCd() {
		return this.toCvrgYdCd;
	}
	
	/**
	 * Column Info
	 * @return toOrgDestLocCd
	 */
	public String getToOrgDestLocCd() {
		return this.toOrgDestLocCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return toOrgDestSteCd
	 */
	public String getToOrgDestSteCd() {
		return this.toOrgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @return toCvrgCntCd
	 */
	public String getToCvrgCntCd() {
		return this.toCvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @return toCvrgLocCd
	 */
	public String getToCvrgLocCd() {
		return this.toCvrgLocCd;
	}
	
	/**
	 * Column Info
	 * @return toCvrgRgnCd
	 */
	public String getToCvrgRgnCd() {
		return this.toCvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @return toOrgDestRgnCd
	 */
	public String getToOrgDestRgnCd() {
		return this.toOrgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @return toDmdtDeTermCd
	 */
	public String getToDmdtDeTermCd() {
		return this.toDmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getToDmdtDeTermNm() {
		return this.toDmdtDeTermNm;
	}

	/**
	 * Column Info
	 * @param toOrgDestContiCd
	 */
	public void setToOrgDestContiCd(String toOrgDestContiCd) {
		this.toOrgDestContiCd = toOrgDestContiCd;
	}
	
	/**
	 * Column Info
	 * @param toCvrgContiCd
	 */
	public void setToCvrgContiCd(String toCvrgContiCd) {
		this.toCvrgContiCd = toCvrgContiCd;
	}
	
	/**
	 * Column Info
	 * @param toCvrgSteCd
	 */
	public void setToCvrgSteCd(String toCvrgSteCd) {
		this.toCvrgSteCd = toCvrgSteCd;
	}
	
	/**
	 * Column Info
	 * @param toOrgDestCntCd
	 */
	public void setToOrgDestCntCd(String toOrgDestCntCd) {
		this.toOrgDestCntCd = toOrgDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param toCvrgYdCd
	 */
	public void setToCvrgYdCd(String toCvrgYdCd) {
		this.toCvrgYdCd = toCvrgYdCd;
	}
	
	/**
	 * Column Info
	 * @param toOrgDestLocCd
	 */
	public void setToOrgDestLocCd(String toOrgDestLocCd) {
		this.toOrgDestLocCd = toOrgDestLocCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param toOrgDestSteCd
	 */
	public void setToOrgDestSteCd(String toOrgDestSteCd) {
		this.toOrgDestSteCd = toOrgDestSteCd;
	}
	
	/**
	 * Column Info
	 * @param toCvrgCntCd
	 */
	public void setToCvrgCntCd(String toCvrgCntCd) {
		this.toCvrgCntCd = toCvrgCntCd;
	}
	
	/**
	 * Column Info
	 * @param toCvrgLocCd
	 */
	public void setToCvrgLocCd(String toCvrgLocCd) {
		this.toCvrgLocCd = toCvrgLocCd;
	}
	
	/**
	 * Column Info
	 * @param toCvrgRgnCd
	 */
	public void setToCvrgRgnCd(String toCvrgRgnCd) {
		this.toCvrgRgnCd = toCvrgRgnCd;
	}
	
	/**
	 * Column Info
	 * @param toOrgDestRgnCd
	 */
	public void setToOrgDestRgnCd(String toOrgDestRgnCd) {
		this.toOrgDestRgnCd = toOrgDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @param toDmdtDeTermCd
	 */
	public void setToDmdtDeTermCd(String toDmdtDeTermCd) {
		this.toDmdtDeTermCd = toDmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setToDmdtDeTermNm(String toDmdtDeTermNm) {
		this.toDmdtDeTermNm = toDmdtDeTermNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToOrgDestContiCd(JSPUtil.getParameter(request, "to_org_dest_conti_cd", ""));
		setToCvrgContiCd(JSPUtil.getParameter(request, "to_cvrg_conti_cd", ""));
		setToCvrgSteCd(JSPUtil.getParameter(request, "to_cvrg_ste_cd", ""));
		setToOrgDestCntCd(JSPUtil.getParameter(request, "to_org_dest_cnt_cd", ""));
		setToCvrgYdCd(JSPUtil.getParameter(request, "to_cvrg_yd_cd", ""));
		setToOrgDestLocCd(JSPUtil.getParameter(request, "to_org_dest_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToOrgDestSteCd(JSPUtil.getParameter(request, "to_org_dest_ste_cd", ""));
		setToCvrgCntCd(JSPUtil.getParameter(request, "to_cvrg_cnt_cd", ""));
		setToCvrgLocCd(JSPUtil.getParameter(request, "to_cvrg_loc_cd", ""));
		setToCvrgRgnCd(JSPUtil.getParameter(request, "to_cvrg_rgn_cd", ""));
		setToOrgDestRgnCd(JSPUtil.getParameter(request, "to_org_dest_rgn_cd", ""));
		setToDmdtDeTermCd(JSPUtil.getParameter(request, "to_dmdt_de_term_cd", ""));
		setToDmdtDeTermNm(JSPUtil.getParameter(request, "to_dmdt_de_term_nm", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ToDmtTariffTypeVO[]
	 */
	public ToDmtTariffTypeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ToDmtTariffTypeVO[]
	 */
	public ToDmtTariffTypeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ToDmtTariffTypeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toOrgDestContiCd = (JSPUtil.getParameter(request, prefix	+ "to_org_dest_conti_cd", length));
			String[] toCvrgContiCd = (JSPUtil.getParameter(request, prefix	+ "to_cvrg_conti_cd", length));
			String[] toCvrgSteCd = (JSPUtil.getParameter(request, prefix	+ "to_cvrg_ste_cd", length));
			String[] toOrgDestCntCd = (JSPUtil.getParameter(request, prefix	+ "to_org_dest_cnt_cd", length));
			String[] toCvrgYdCd = (JSPUtil.getParameter(request, prefix	+ "to_cvrg_yd_cd", length));
			String[] toOrgDestLocCd = (JSPUtil.getParameter(request, prefix	+ "to_org_dest_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toOrgDestSteCd = (JSPUtil.getParameter(request, prefix	+ "to_org_dest_ste_cd", length));
			String[] toCvrgCntCd = (JSPUtil.getParameter(request, prefix	+ "to_cvrg_cnt_cd", length));
			String[] toCvrgLocCd = (JSPUtil.getParameter(request, prefix	+ "to_cvrg_loc_cd", length));
			String[] toCvrgRgnCd = (JSPUtil.getParameter(request, prefix	+ "to_cvrg_rgn_cd", length));
			String[] toOrgDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "to_org_dest_rgn_cd", length));
			String[] toDmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "to_dmdt_de_term_cd", length));
			String[] toDmdtDeTermNm = (JSPUtil.getParameter(request, prefix + "to_dmdt_de_term_nm", length));

			for (int i = 0; i < length; i++) {
				model = new ToDmtTariffTypeVO();
				if (toOrgDestContiCd[i] != null)
					model.setToOrgDestContiCd(toOrgDestContiCd[i]);
				if (toCvrgContiCd[i] != null)
					model.setToCvrgContiCd(toCvrgContiCd[i]);
				if (toCvrgSteCd[i] != null)
					model.setToCvrgSteCd(toCvrgSteCd[i]);
				if (toOrgDestCntCd[i] != null)
					model.setToOrgDestCntCd(toOrgDestCntCd[i]);
				if (toCvrgYdCd[i] != null)
					model.setToCvrgYdCd(toCvrgYdCd[i]);
				if (toOrgDestLocCd[i] != null)
					model.setToOrgDestLocCd(toOrgDestLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toOrgDestSteCd[i] != null)
					model.setToOrgDestSteCd(toOrgDestSteCd[i]);
				if (toCvrgCntCd[i] != null)
					model.setToCvrgCntCd(toCvrgCntCd[i]);
				if (toCvrgLocCd[i] != null)
					model.setToCvrgLocCd(toCvrgLocCd[i]);
				if (toCvrgRgnCd[i] != null)
					model.setToCvrgRgnCd(toCvrgRgnCd[i]);
				if (toOrgDestRgnCd[i] != null)
					model.setToOrgDestRgnCd(toOrgDestRgnCd[i]);
				if (toDmdtDeTermCd[i] != null)
					model.setToDmdtDeTermCd(toDmdtDeTermCd[i]);
				if (toDmdtDeTermNm[i] != null)
					model.setToDmdtDeTermNm(toDmdtDeTermNm[i]);	
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getToDmtTariffTypeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ToDmtTariffTypeVO[]
	 */
	public ToDmtTariffTypeVO[] getToDmtTariffTypeVOs(){
		ToDmtTariffTypeVO[] vos = (ToDmtTariffTypeVO[])models.toArray(new ToDmtTariffTypeVO[models.size()]);
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
		this.toOrgDestContiCd = this.toOrgDestContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCvrgContiCd = this.toCvrgContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCvrgSteCd = this.toCvrgSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOrgDestCntCd = this.toOrgDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCvrgYdCd = this.toCvrgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOrgDestLocCd = this.toOrgDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOrgDestSteCd = this.toOrgDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCvrgCntCd = this.toCvrgCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCvrgLocCd = this.toCvrgLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCvrgRgnCd = this.toCvrgRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOrgDestRgnCd = this.toOrgDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDmdtDeTermCd = this.toDmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDmdtDeTermNm = this.toDmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
