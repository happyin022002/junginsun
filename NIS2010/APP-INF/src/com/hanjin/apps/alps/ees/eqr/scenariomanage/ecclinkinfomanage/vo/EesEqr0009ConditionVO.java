/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0009ConditionVO.java
*@FileTitle : EesEqr0009ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.07.24		1.0 최초 생성
*
*@LastModifyDate : 2009.07.24
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0009ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0009ConditionVO> models = new ArrayList<EesEqr0009ConditionVO>();
	
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String toStatus = null;
	/* Column Info */
	private String fromLocation = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mode = null;
	/* Column Info */
	private String scnrRmk = null;
	/* Column Info */
	private String yyyyww = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String fromStatus = null;
	/* Column Info */
	private String transitTime = null;
	/* Column Info */
	private String toLocation = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0009ConditionVO() {}

	public EesEqr0009ConditionVO(String ibflag, String pagerows, String scnrRmk, String yyyyww, String seq, String fromStatus, String toStatus, String fromLocation, String toLocation, String transitTime, String mode, String scnrId, String statusType) {
		this.scnrId = scnrId;
		this.statusType = statusType;
		this.toStatus = toStatus;
		this.fromLocation = fromLocation;
		this.pagerows = pagerows;
		this.mode = mode;
		this.scnrRmk = scnrRmk;
		this.yyyyww = yyyyww;
		this.ibflag = ibflag;
		this.seq = seq;
		this.fromStatus = fromStatus;
		this.transitTime = transitTime;
		this.toLocation = toLocation;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("to_status", getToStatus());
		this.hashColumns.put("from_location", getFromLocation());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mode", getMode());
		this.hashColumns.put("scnr_rmk", getScnrRmk());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("from_status", getFromStatus());
		this.hashColumns.put("transit_time", getTransitTime());
		this.hashColumns.put("to_location", getToLocation());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("to_status", "toStatus");
		this.hashFields.put("from_location", "fromLocation");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mode", "mode");
		this.hashFields.put("scnr_rmk", "scnrRmk");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("from_status", "fromStatus");
		this.hashFields.put("transit_time", "transitTime");
		this.hashFields.put("to_location", "toLocation");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return toStatus
	 */
	public String getToStatus() {
		return this.toStatus;
	}
	
	/**
	 * Column Info
	 * @return fromLocation
	 */
	public String getFromLocation() {
		return this.fromLocation;
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
	 * @return mode
	 */
	public String getMode() {
		return this.mode;
	}
	
	/**
	 * Column Info
	 * @return scnrRmk
	 */
	public String getScnrRmk() {
		return this.scnrRmk;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return fromStatus
	 */
	public String getFromStatus() {
		return this.fromStatus;
	}
	
	/**
	 * Column Info
	 * @return transitTime
	 */
	public String getTransitTime() {
		return this.transitTime;
	}
	
	/**
	 * Column Info
	 * @return toLocation
	 */
	public String getToLocation() {
		return this.toLocation;
	}
	

	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param toStatus
	 */
	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}
	
	/**
	 * Column Info
	 * @param fromLocation
	 */
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
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
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Column Info
	 * @param scnrRmk
	 */
	public void setScnrRmk(String scnrRmk) {
		this.scnrRmk = scnrRmk;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param fromStatus
	 */
	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}
	
	/**
	 * Column Info
	 * @param transitTime
	 */
	public void setTransitTime(String transitTime) {
		this.transitTime = transitTime;
	}
	
	/**
	 * Column Info
	 * @param toLocation
	 */
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setToStatus(JSPUtil.getParameter(request, "toStatus", ""));
		setFromLocation(JSPUtil.getParameter(request, "fromLocation", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMode(JSPUtil.getParameter(request, "mode", ""));
		setScnrRmk(JSPUtil.getParameter(request, "scnr_rmk", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFromStatus(JSPUtil.getParameter(request, "fromStatus", ""));
		setTransitTime(JSPUtil.getParameter(request, "transitTime", ""));
		setToLocation(JSPUtil.getParameter(request, "toLocation", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr009ConditionVO[]
	 */
	public EesEqr0009ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr009ConditionVO[]
	 */
	public EesEqr0009ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0009ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] toStatus = (JSPUtil.getParameter(request, prefix	+ "to_status", length));
			String[] fromLocation = (JSPUtil.getParameter(request, prefix	+ "from_location", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mode = (JSPUtil.getParameter(request, prefix	+ "mode", length));
			String[] scnrRmk = (JSPUtil.getParameter(request, prefix	+ "scnr_rmk", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] fromStatus = (JSPUtil.getParameter(request, prefix	+ "from_status", length));
			String[] transitTime = (JSPUtil.getParameter(request, prefix	+ "transit_time", length));
			String[] toLocation = (JSPUtil.getParameter(request, prefix	+ "to_location", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0009ConditionVO();
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (toStatus[i] != null)
					model.setToStatus(toStatus[i]);
				if (fromLocation[i] != null)
					model.setFromLocation(fromLocation[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mode[i] != null)
					model.setMode(mode[i]);
				if (scnrRmk[i] != null)
					model.setScnrRmk(scnrRmk[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (fromStatus[i] != null)
					model.setFromStatus(fromStatus[i]);
				if (transitTime[i] != null)
					model.setTransitTime(transitTime[i]);
				if (toLocation[i] != null)
					model.setToLocation(toLocation[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr009ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr009ConditionVO[]
	 */
	public EesEqr0009ConditionVO[] getEesEqr009ConditionVOs(){
		EesEqr0009ConditionVO[] vos = (EesEqr0009ConditionVO[])models.toArray(new EesEqr0009ConditionVO[models.size()]);
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
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toStatus = this.toStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromLocation = this.fromLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode = this.mode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrRmk = this.scnrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromStatus = this.fromStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transitTime = this.transitTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toLocation = this.toLocation .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
