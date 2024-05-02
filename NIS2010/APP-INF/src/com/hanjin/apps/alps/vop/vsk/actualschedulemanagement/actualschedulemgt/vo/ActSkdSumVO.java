/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActSkdSumVO.java
*@FileTitle : ActSkdSumVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.09
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2009.08.14 정진우 
* 1.0 Creation

* History
* 2011.08.09 김민아 CHM-201112647-01 Actual SKD input Ratio Tab 및 조회 로직 변경 요청. 페이징 처리에 따른 변수 추가.
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActSkdSumVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActSkdSumVO> models = new ArrayList<ActSkdSumVO>();
	
	/* Column Info */
	private String ctrlOfc = null;
	/* Column Info */
	private String inputtedCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String targetLaneCnt = null;
	/* Column Info */
	private String overdueRto = null;
	/* Column Info */
	private String targetVvdCnt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String inputRto = null;
	/* Column Info */
	private String rhq = null;
	/* Column Info */
	private String ttlPortCnt = null;
	/* Column Info */
	private String overInputCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String totalCnt = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActSkdSumVO() {}

	public ActSkdSumVO(String ibflag, String pagerows, String rhq, String ctrlOfc, String portCd, String targetLaneCnt, String targetVvdCnt, String inputtedCnt, String inputRto, String overdueRto, String ttlPortCnt, String overInputCnt, String totalCnt) {
		this.ctrlOfc = ctrlOfc;
		this.inputtedCnt = inputtedCnt;
		this.ibflag = ibflag;
		this.targetLaneCnt = targetLaneCnt;
		this.overdueRto = overdueRto;
		this.targetVvdCnt = targetVvdCnt;
		this.portCd = portCd;
		this.inputRto = inputRto;
		this.rhq = rhq;
		this.ttlPortCnt = ttlPortCnt;
		this.overInputCnt = overInputCnt;
		this.pagerows = pagerows;
		this.totalCnt = totalCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrl_ofc", getCtrlOfc());
		this.hashColumns.put("inputted_cnt", getInputtedCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("target_lane_cnt", getTargetLaneCnt());
		this.hashColumns.put("overdue_rto", getOverdueRto());
		this.hashColumns.put("target_vvd_cnt", getTargetVvdCnt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("input_rto", getInputRto());
		this.hashColumns.put("rhq", getRhq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_port_cnt", getTtlPortCnt());
		this.hashColumns.put("over_input_cnt", getOverInputCnt());
		this.hashColumns.put("total_cnt", getTotalCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrl_ofc", "ctrlOfc");
		this.hashFields.put("inputted_cnt", "inputtedCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("target_lane_cnt", "targetLaneCnt");
		this.hashFields.put("overdue_rto", "overdueRto");
		this.hashFields.put("target_vvd_cnt", "targetVvdCnt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("input_rto", "inputRto");
		this.hashFields.put("rhq", "rhq");
		this.hashFields.put("ttl_port_cnt", "ttlPortCnt");
		this.hashFields.put("over_input_cnt", "overInputCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("total_cnt", "totalCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfc
	 */
	public String getCtrlOfc() {
		return this.ctrlOfc;
	}
	
	/**
	 * Column Info
	 * @return inputtedCnt
	 */
	public String getInputtedCnt() {
		return this.inputtedCnt;
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
	 * @return targetLaneCnt
	 */
	public String getTargetLaneCnt() {
		return this.targetLaneCnt;
	}
	
	/**
	 * Column Info
	 * @return overdueRto
	 */
	public String getOverdueRto() {
		return this.overdueRto;
	}
	
	/**
	 * Column Info
	 * @return targetVvdCnt
	 */
	public String getTargetVvdCnt() {
		return this.targetVvdCnt;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return inputRto
	 */
	public String getInputRto() {
		return this.inputRto;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	
	/**
	 * Column Info
	 * @return ttlPortCnt
	 */
	public String getTtlPortCnt() {
		return this.ttlPortCnt;
	}
	
	/**
	 * Column Info
	 * @return overInputCnt
	 */
	public String getOverInputCnt() {
		return this.overInputCnt;
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
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}	

	/**
	 * Column Info
	 * @param ctrlOfc
	 */
	public void setCtrlOfc(String ctrlOfc) {
		this.ctrlOfc = ctrlOfc;
	}
	
	/**
	 * Column Info
	 * @param inputtedCnt
	 */
	public void setInputtedCnt(String inputtedCnt) {
		this.inputtedCnt = inputtedCnt;
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
	 * @param targetLaneCnt
	 */
	public void setTargetLaneCnt(String targetLaneCnt) {
		this.targetLaneCnt = targetLaneCnt;
	}
	
	/**
	 * Column Info
	 * @param overdueRto
	 */
	public void setOverdueRto(String overdueRto) {
		this.overdueRto = overdueRto;
	}
	
	/**
	 * Column Info
	 * @param targetVvdCnt
	 */
	public void setTargetVvdCnt(String targetVvdCnt) {
		this.targetVvdCnt = targetVvdCnt;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param inputRto
	 */
	public void setInputRto(String inputRto) {
		this.inputRto = inputRto;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Column Info
	 * @param ttlPortCnt
	 */
	public void setTtlPortCnt(String ttlPortCnt) {
		this.ttlPortCnt = ttlPortCnt;
	}
	
	/**
	 * Column Info
	 * @param overInputCnt
	 */
	public void setOverInputCnt(String overInputCnt) {
		this.overInputCnt = overInputCnt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCtrlOfc(JSPUtil.getParameter(request, "ctrl_ofc", ""));
		setInputtedCnt(JSPUtil.getParameter(request, "inputted_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTargetLaneCnt(JSPUtil.getParameter(request, "target_lane_cnt", ""));
		setOverdueRto(JSPUtil.getParameter(request, "overdue_rto", ""));
		setTargetVvdCnt(JSPUtil.getParameter(request, "target_vvd_cnt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setInputRto(JSPUtil.getParameter(request, "input_rto", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
		setTtlPortCnt(JSPUtil.getParameter(request, "ttl_port_cnt", ""));
		setOverInputCnt(JSPUtil.getParameter(request, "over_input_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActSkdSumVO[]
	 */
	public ActSkdSumVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActSkdSumVO[]
	 */
	public ActSkdSumVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActSkdSumVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrlOfc = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc", length));
			String[] inputtedCnt = (JSPUtil.getParameter(request, prefix	+ "inputted_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] targetLaneCnt = (JSPUtil.getParameter(request, prefix	+ "target_lane_cnt", length));
			String[] overdueRto = (JSPUtil.getParameter(request, prefix	+ "overdue_rto", length));
			String[] targetVvdCnt = (JSPUtil.getParameter(request, prefix	+ "target_vvd_cnt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] inputRto = (JSPUtil.getParameter(request, prefix	+ "input_rto", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			String[] ttlPortCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_port_cnt", length));
			String[] overInputCnt = (JSPUtil.getParameter(request, prefix	+ "over_input_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActSkdSumVO();
				if (ctrlOfc[i] != null)
					model.setCtrlOfc(ctrlOfc[i]);
				if (inputtedCnt[i] != null)
					model.setInputtedCnt(inputtedCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (targetLaneCnt[i] != null)
					model.setTargetLaneCnt(targetLaneCnt[i]);
				if (overdueRto[i] != null)
					model.setOverdueRto(overdueRto[i]);
				if (targetVvdCnt[i] != null)
					model.setTargetVvdCnt(targetVvdCnt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (inputRto[i] != null)
					model.setInputRto(inputRto[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				if (ttlPortCnt[i] != null)
					model.setTtlPortCnt(ttlPortCnt[i]);
				if (overInputCnt[i] != null)
					model.setOverInputCnt(overInputCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActSkdSumVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActSkdSumVO[]
	 */
	public ActSkdSumVO[] getActSkdSumVOs(){
		ActSkdSumVO[] vos = (ActSkdSumVO[])models.toArray(new ActSkdSumVO[models.size()]);
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
		this.ctrlOfc = this.ctrlOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputtedCnt = this.inputtedCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetLaneCnt = this.targetLaneCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdueRto = this.overdueRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.targetVvdCnt = this.targetVvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputRto = this.inputRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPortCnt = this.ttlPortCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overInputCnt = this.overInputCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
