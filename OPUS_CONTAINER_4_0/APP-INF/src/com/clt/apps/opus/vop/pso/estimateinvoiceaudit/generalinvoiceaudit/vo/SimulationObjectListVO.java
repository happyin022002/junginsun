/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SimulationObjectListVO.java
*@FileTitle : SimulationObjectListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.02.23 정명훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SimulationObjectListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SimulationObjectListVO> models = new ArrayList<SimulationObjectListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String psoMeasUtNm = null;
	/* Column Info */
	private String psoObjListTpCd = null;
	/* Column Info */
	private String dfltVal = null;
	/* Column Info */
	private String objListNm = null;
	/* Column Info */
	private String objListNo = null;
	/* Column Info */
	private String psoMeasUtCd = null;
	/* Column Info */
	private String regVal = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SimulationObjectListVO() {}

	public SimulationObjectListVO(String ibflag, String pagerows, String objListNo, String objListNm, String psoObjListTpCd, String dfltVal, String regVal, String psoMeasUtCd, String psoMeasUtNm) {
		this.ibflag = ibflag;
		this.psoMeasUtNm = psoMeasUtNm;
		this.psoObjListTpCd = psoObjListTpCd;
		this.dfltVal = dfltVal;
		this.objListNm = objListNm;
		this.objListNo = objListNo;
		this.psoMeasUtCd = psoMeasUtCd;
		this.regVal = regVal;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pso_meas_ut_nm", getPsoMeasUtNm());
		this.hashColumns.put("pso_obj_list_tp_cd", getPsoObjListTpCd());
		this.hashColumns.put("dflt_val", getDfltVal());
		this.hashColumns.put("obj_list_nm", getObjListNm());
		this.hashColumns.put("obj_list_no", getObjListNo());
		this.hashColumns.put("pso_meas_ut_cd", getPsoMeasUtCd());
		this.hashColumns.put("reg_val", getRegVal());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pso_meas_ut_nm", "psoMeasUtNm");
		this.hashFields.put("pso_obj_list_tp_cd", "psoObjListTpCd");
		this.hashFields.put("dflt_val", "dfltVal");
		this.hashFields.put("obj_list_nm", "objListNm");
		this.hashFields.put("obj_list_no", "objListNo");
		this.hashFields.put("pso_meas_ut_cd", "psoMeasUtCd");
		this.hashFields.put("reg_val", "regVal");
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
	 * @return psoMeasUtNm
	 */
	public String getPsoMeasUtNm() {
		return this.psoMeasUtNm;
	}
	
	/**
	 * Column Info
	 * @return psoObjListTpCd
	 */
	public String getPsoObjListTpCd() {
		return this.psoObjListTpCd;
	}
	
	/**
	 * Column Info
	 * @return dfltVal
	 */
	public String getDfltVal() {
		return this.dfltVal;
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
	 * @return regVal
	 */
	public String getRegVal() {
		return this.regVal;
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
	 * @param psoMeasUtNm
	 */
	public void setPsoMeasUtNm(String psoMeasUtNm) {
		this.psoMeasUtNm = psoMeasUtNm;
	}
	
	/**
	 * Column Info
	 * @param psoObjListTpCd
	 */
	public void setPsoObjListTpCd(String psoObjListTpCd) {
		this.psoObjListTpCd = psoObjListTpCd;
	}
	
	/**
	 * Column Info
	 * @param dfltVal
	 */
	public void setDfltVal(String dfltVal) {
		this.dfltVal = dfltVal;
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
	 * @param regVal
	 */
	public void setRegVal(String regVal) {
		this.regVal = regVal;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPsoMeasUtNm(JSPUtil.getParameter(request, prefix + "pso_meas_ut_nm", ""));
		setPsoObjListTpCd(JSPUtil.getParameter(request, prefix + "pso_obj_list_tp_cd", ""));
		setDfltVal(JSPUtil.getParameter(request, prefix + "dflt_val", ""));
		setObjListNm(JSPUtil.getParameter(request, prefix + "obj_list_nm", ""));
		setObjListNo(JSPUtil.getParameter(request, prefix + "obj_list_no", ""));
		setPsoMeasUtCd(JSPUtil.getParameter(request, prefix + "pso_meas_ut_cd", ""));
		setRegVal(JSPUtil.getParameter(request, prefix + "reg_val", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SimulationObjectListVO[]
	 */
	public SimulationObjectListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SimulationObjectListVO[]
	 */
	public SimulationObjectListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SimulationObjectListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] psoMeasUtNm = (JSPUtil.getParameter(request, prefix	+ "pso_meas_ut_nm", length));
			String[] psoObjListTpCd = (JSPUtil.getParameter(request, prefix	+ "pso_obj_list_tp_cd", length));
			String[] dfltVal = (JSPUtil.getParameter(request, prefix	+ "dflt_val", length));
			String[] objListNm = (JSPUtil.getParameter(request, prefix	+ "obj_list_nm", length));
			String[] objListNo = (JSPUtil.getParameter(request, prefix	+ "obj_list_no", length));
			String[] psoMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "pso_meas_ut_cd", length));
			String[] regVal = (JSPUtil.getParameter(request, prefix	+ "reg_val", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SimulationObjectListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (psoMeasUtNm[i] != null)
					model.setPsoMeasUtNm(psoMeasUtNm[i]);
				if (psoObjListTpCd[i] != null)
					model.setPsoObjListTpCd(psoObjListTpCd[i]);
				if (dfltVal[i] != null)
					model.setDfltVal(dfltVal[i]);
				if (objListNm[i] != null)
					model.setObjListNm(objListNm[i]);
				if (objListNo[i] != null)
					model.setObjListNo(objListNo[i]);
				if (psoMeasUtCd[i] != null)
					model.setPsoMeasUtCd(psoMeasUtCd[i]);
				if (regVal[i] != null)
					model.setRegVal(regVal[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSimulationObjectListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SimulationObjectListVO[]
	 */
	public SimulationObjectListVO[] getSimulationObjectListVOs(){
		SimulationObjectListVO[] vos = (SimulationObjectListVO[])models.toArray(new SimulationObjectListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMeasUtNm = this.psoMeasUtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoObjListTpCd = this.psoObjListTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltVal = this.dfltVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNm = this.objListNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNo = this.objListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psoMeasUtCd = this.psoMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regVal = this.regVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
