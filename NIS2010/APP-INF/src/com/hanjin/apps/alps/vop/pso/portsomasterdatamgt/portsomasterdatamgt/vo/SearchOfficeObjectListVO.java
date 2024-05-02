/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOfficeObjectListVO.java
*@FileTitle : SearchOfficeObjectListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.06.15 김진일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.portsomasterdatamgt.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOfficeObjectListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeObjectListVO> models = new ArrayList<SearchOfficeObjectListVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String psoObjCdDsp = null;
	/* Column Info */
	private String psoMeasUtCdDsp = null;
	/* Column Info */
	private String objListNm = null;
	/* Column Info */
	private String psoOfcCd = null;
	/* Column Info */
	private String objListNo = null;
	/* Column Info */
	private String psoMeasUtCd = null;
	/* Column Info */
	private String psoObjCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOfficeObjectListVO() {}

	public SearchOfficeObjectListVO(String ibflag, String pagerows, String rn, String objListNo, String psoObjCdDsp, String psoObjCd, String objListNm, String psoMeasUtCdDsp, String psoMeasUtCd, String psoOfcCd, String creUsrId) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.rn = rn;
		this.psoObjCdDsp = psoObjCdDsp;
		this.psoMeasUtCdDsp = psoMeasUtCdDsp;
		this.objListNm = objListNm;
		this.psoOfcCd = psoOfcCd;
		this.objListNo = objListNo;
		this.psoMeasUtCd = psoMeasUtCd;
		this.psoObjCd = psoObjCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("pso_obj_cd_dsp", getPsoObjCdDsp());
		this.hashColumns.put("pso_meas_ut_cd_dsp", getPsoMeasUtCdDsp());
		this.hashColumns.put("obj_list_nm", getObjListNm());
		this.hashColumns.put("pso_ofc_cd", getPsoOfcCd());
		this.hashColumns.put("obj_list_no", getObjListNo());
		this.hashColumns.put("pso_meas_ut_cd", getPsoMeasUtCd());
		this.hashColumns.put("pso_obj_cd", getPsoObjCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("pso_obj_cd_dsp", "psoObjCdDsp");
		this.hashFields.put("pso_meas_ut_cd_dsp", "psoMeasUtCdDsp");
		this.hashFields.put("obj_list_nm", "objListNm");
		this.hashFields.put("pso_ofc_cd", "psoOfcCd");
		this.hashFields.put("obj_list_no", "objListNo");
		this.hashFields.put("pso_meas_ut_cd", "psoMeasUtCd");
		this.hashFields.put("pso_obj_cd", "psoObjCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return psoObjCdDsp
	 */
	public String getPsoObjCdDsp() {
		return this.psoObjCdDsp;
	}
	
	/**
	 * Column Info
	 * @return psoMeasUtCdDsp
	 */
	public String getPsoMeasUtCdDsp() {
		return this.psoMeasUtCdDsp;
	}
	
	/**
	 * Column Info
	 * @return objListNm
	 */
	public String getObjListNm() {
		return this.objListNm;
	}
	
	/**
	 * Column Info
	 * @return psoOfcCd
	 */
	public String getPsoOfcCd() {
		return this.psoOfcCd;
	}
	
	/**
	 * Column Info
	 * @return objListNo
	 */
	public String getObjListNo() {
		return this.objListNo;
	}
	
	/**
	 * Column Info
	 * @return psoMeasUtCd
	 */
	public String getPsoMeasUtCd() {
		return this.psoMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return psoObjCd
	 */
	public String getPsoObjCd() {
		return this.psoObjCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param psoObjCdDsp
	 */
	public void setPsoObjCdDsp(String psoObjCdDsp) {
		this.psoObjCdDsp = psoObjCdDsp;
	}
	
	/**
	 * Column Info
	 * @param psoMeasUtCdDsp
	 */
	public void setPsoMeasUtCdDsp(String psoMeasUtCdDsp) {
		this.psoMeasUtCdDsp = psoMeasUtCdDsp;
	}
	
	/**
	 * Column Info
	 * @param objListNm
	 */
	public void setObjListNm(String objListNm) {
		this.objListNm = objListNm;
	}
	
	/**
	 * Column Info
	 * @param psoOfcCd
	 */
	public void setPsoOfcCd(String psoOfcCd) {
		this.psoOfcCd = psoOfcCd;
	}
	
	/**
	 * Column Info
	 * @param objListNo
	 */
	public void setObjListNo(String objListNo) {
		this.objListNo = objListNo;
	}
	
	/**
	 * Column Info
	 * @param psoMeasUtCd
	 */
	public void setPsoMeasUtCd(String psoMeasUtCd) {
		this.psoMeasUtCd = psoMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param psoObjCd
	 */
	public void setPsoObjCd(String psoObjCd) {
		this.psoObjCd = psoObjCd;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRn(JSPUtil.getParameter(request, "rn", ""));
		setPsoObjCdDsp(JSPUtil.getParameter(request, "pso_obj_cd_dsp", ""));
		setPsoMeasUtCdDsp(JSPUtil.getParameter(request, "pso_meas_ut_cd_dsp", ""));
		setObjListNm(JSPUtil.getParameter(request, "obj_list_nm", ""));
		setPsoOfcCd(JSPUtil.getParameter(request, "pso_ofc_cd", ""));
		setObjListNo(JSPUtil.getParameter(request, "obj_list_no", ""));
		setPsoMeasUtCd(JSPUtil.getParameter(request, "pso_meas_ut_cd", ""));
		setPsoObjCd(JSPUtil.getParameter(request, "pso_obj_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOfficeObjectListVO[]
	 */
	public SearchOfficeObjectListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOfficeObjectListVO[]
	 */
	public SearchOfficeObjectListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficeObjectListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] psoObjCdDsp = (JSPUtil.getParameter(request, prefix	+ "pso_obj_cd_dsp", length));
			String[] psoMeasUtCdDsp = (JSPUtil.getParameter(request, prefix	+ "pso_meas_ut_cd_dsp", length));
			String[] objListNm = (JSPUtil.getParameter(request, prefix	+ "obj_list_nm", length));
			String[] psoOfcCd = (JSPUtil.getParameter(request, prefix	+ "pso_ofc_cd", length));
			String[] objListNo = (JSPUtil.getParameter(request, prefix	+ "obj_list_no", length));
			String[] psoMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "pso_meas_ut_cd", length));
			String[] psoObjCd = (JSPUtil.getParameter(request, prefix	+ "pso_obj_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeObjectListVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (psoObjCdDsp[i] != null)
					model.setPsoObjCdDsp(psoObjCdDsp[i]);
				if (psoMeasUtCdDsp[i] != null)
					model.setPsoMeasUtCdDsp(psoMeasUtCdDsp[i]);
				if (objListNm[i] != null)
					model.setObjListNm(objListNm[i]);
				if (psoOfcCd[i] != null)
					model.setPsoOfcCd(psoOfcCd[i]);
				if (objListNo[i] != null)
					model.setObjListNo(objListNo[i]);
				if (psoMeasUtCd[i] != null)
					model.setPsoMeasUtCd(psoMeasUtCd[i]);
				if (psoObjCd[i] != null)
					model.setPsoObjCd(psoObjCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOfficeObjectListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOfficeObjectListVO[]
	 */
	public SearchOfficeObjectListVO[] getSearchOfficeObjectListVOs(){
		SearchOfficeObjectListVO[] vos = (SearchOfficeObjectListVO[])models.toArray(new SearchOfficeObjectListVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoObjCdDsp = this.psoObjCdDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMeasUtCdDsp = this.psoMeasUtCdDsp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNm = this.objListNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoOfcCd = this.psoOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNo = this.objListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMeasUtCd = this.psoMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoObjCd = this.psoObjCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
