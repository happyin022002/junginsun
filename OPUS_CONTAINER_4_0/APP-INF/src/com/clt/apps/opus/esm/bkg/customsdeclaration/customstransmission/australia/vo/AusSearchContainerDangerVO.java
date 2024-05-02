/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AusSearchContainerDangerVO.java
*@FileTitle : AusSearchContainerDangerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.09.08 임재택
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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

public class AusSearchContainerDangerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AusSearchContainerDangerVO> models = new ArrayList<AusSearchContainerDangerVO>();

	/* Column Info */
	private String pageList = null;
	/* Column Info */
	private String phone = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shpNm = null;
	/* Column Info */
	private String imdgClass = null;
	/* Column Info */
	private String flshTemp = null;
	/* Column Info */
	private String dgRemark = null;
	/* Column Info */
	private String flshUnit = null;
	/* Column Info */
	private String unnbr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AusSearchContainerDangerVO() {}

	public AusSearchContainerDangerVO(String ibflag, String pagerows, String unnbr, String imdgClass, String shpNm, String phone, String pageList, String flshTemp, String flshUnit, String dgRemark) {
		this.pageList = pageList;
		this.phone = phone;
		this.ibflag = ibflag;
		this.shpNm = shpNm;
		this.imdgClass = imdgClass;
		this.flshTemp = flshTemp;
		this.dgRemark = dgRemark;
		this.flshUnit = flshUnit;
		this.unnbr = unnbr;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("page_list", getPageList());
		this.hashColumns.put("phone", getPhone());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shp_nm", getShpNm());
		this.hashColumns.put("imdg_class", getImdgClass());
		this.hashColumns.put("flsh_temp", getFlshTemp());
		this.hashColumns.put("dg_remark", getDgRemark());
		this.hashColumns.put("flsh_unit", getFlshUnit());
		this.hashColumns.put("unnbr", getUnnbr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("page_list", "pageList");
		this.hashFields.put("phone", "phone");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shp_nm", "shpNm");
		this.hashFields.put("imdg_class", "imdgClass");
		this.hashFields.put("flsh_temp", "flshTemp");
		this.hashFields.put("dg_remark", "dgRemark");
		this.hashFields.put("flsh_unit", "flshUnit");
		this.hashFields.put("unnbr", "unnbr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return pageList
	 */
	public String getPageList() {
		return this.pageList;
	}

	/**
	 * Column Info
	 * @return phone
	 */
	public String getPhone() {
		return this.phone;
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
	 * @return shpNm
	 */
	public String getShpNm() {
		return this.shpNm;
	}

	/**
	 * Column Info
	 * @return imdgClass
	 */
	public String getImdgClass() {
		return this.imdgClass;
	}

	/**
	 * Column Info
	 * @return flshTemp
	 */
	public String getFlshTemp() {
		return this.flshTemp;
	}

	/**
	 * Column Info
	 * @return dgRemark
	 */
	public String getDgRemark() {
		return this.dgRemark;
	}

	/**
	 * Column Info
	 * @return flshUnit
	 */
	public String getFlshUnit() {
		return this.flshUnit;
	}

	/**
	 * Column Info
	 * @return unnbr
	 */
	public String getUnnbr() {
		return this.unnbr;
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
	 * @param pageList
	 */
	public void setPageList(String pageList) {
		this.pageList = pageList;
	}

	/**
	 * Column Info
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @param shpNm
	 */
	public void setShpNm(String shpNm) {
		this.shpNm = shpNm;
	}

	/**
	 * Column Info
	 * @param imdgClass
	 */
	public void setImdgClass(String imdgClass) {
		this.imdgClass = imdgClass;
	}

	/**
	 * Column Info
	 * @param flshTemp
	 */
	public void setFlshTemp(String flshTemp) {
		this.flshTemp = flshTemp;
	}

	/**
	 * Column Info
	 * @param dgRemark
	 */
	public void setDgRemark(String dgRemark) {
		this.dgRemark = dgRemark;
	}

	/**
	 * Column Info
	 * @param flshUnit
	 */
	public void setFlshUnit(String flshUnit) {
		this.flshUnit = flshUnit;
	}

	/**
	 * Column Info
	 * @param unnbr
	 */
	public void setUnnbr(String unnbr) {
		this.unnbr = unnbr;
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
		setPageList(JSPUtil.getParameter(request, "page_list", ""));
		setPhone(JSPUtil.getParameter(request, "phone", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setShpNm(JSPUtil.getParameter(request, "shp_nm", ""));
		setImdgClass(JSPUtil.getParameter(request, "imdg_class", ""));
		setFlshTemp(JSPUtil.getParameter(request, "flsh_temp", ""));
		setDgRemark(JSPUtil.getParameter(request, "dg_remark", ""));
		setFlshUnit(JSPUtil.getParameter(request, "flsh_unit", ""));
		setUnnbr(JSPUtil.getParameter(request, "unnbr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusSearchContainerDangerVO[]
	 */
	public AusSearchContainerDangerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AusSearchContainerDangerVO[]
	 */
	public AusSearchContainerDangerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusSearchContainerDangerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] pageList = (JSPUtil.getParameter(request, prefix	+ "page_list", length));
			String[] phone = (JSPUtil.getParameter(request, prefix	+ "phone", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shpNm = (JSPUtil.getParameter(request, prefix	+ "shp_nm", length));
			String[] imdgClass = (JSPUtil.getParameter(request, prefix	+ "imdg_class", length));
			String[] flshTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_temp", length));
			String[] dgRemark = (JSPUtil.getParameter(request, prefix	+ "dg_remark", length));
			String[] flshUnit = (JSPUtil.getParameter(request, prefix	+ "flsh_unit", length));
			String[] unnbr = (JSPUtil.getParameter(request, prefix	+ "unnbr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new AusSearchContainerDangerVO();
				if (pageList[i] != null)
					model.setPageList(pageList[i]);
				if (phone[i] != null)
					model.setPhone(phone[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shpNm[i] != null)
					model.setShpNm(shpNm[i]);
				if (imdgClass[i] != null)
					model.setImdgClass(imdgClass[i]);
				if (flshTemp[i] != null)
					model.setFlshTemp(flshTemp[i]);
				if (dgRemark[i] != null)
					model.setDgRemark(dgRemark[i]);
				if (flshUnit[i] != null)
					model.setFlshUnit(flshUnit[i]);
				if (unnbr[i] != null)
					model.setUnnbr(unnbr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusSearchContainerDangerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusSearchContainerDangerVO[]
	 */
	public AusSearchContainerDangerVO[] getAusSearchContainerDangerVOs(){
		AusSearchContainerDangerVO[] vos = (AusSearchContainerDangerVO[])models.toArray(new AusSearchContainerDangerVO[models.size()]);
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
		this.pageList = this.pageList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phone = this.phone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpNm = this.shpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClass = this.imdgClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshTemp = this.flshTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgRemark = this.dgRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshUnit = this.flshUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unnbr = this.unnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
