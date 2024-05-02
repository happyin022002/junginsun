/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickupReturnCYVO.java
*@FileTitle : PickupReturnCYVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.05 노승배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PickupReturnCYVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PickupReturnCYVO> models = new ArrayList<PickupReturnCYVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cargoType = null;
	/* Column Info */
	private String pickupCy = null;
	/* Column Info */
	private String laneCode = null;
	/* Column Info */
	private String returnCy = null;
	/* Column Info */
	private String polPod = null;
	/* Column Info */
	private String boundCode = null;
	/* Column Info */
	private String porDel = null;
	/* Column Info */
	private String delFlag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updDt = null;
//	, cre_usr_id, upd_usr_id, cre_dt, upd_dt
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PickupReturnCYVO() {}

	public PickupReturnCYVO(String ibflag, String pagerows, String delFlag, String porDel, String polPod, String laneCode, String boundCode, String cargoType, String pickupCy, String returnCy, String userId, String creUsrId, String updUsrId, String creDt, String updDt) {
		this.ibflag = ibflag;
		this.userId = userId;
		this.cargoType = cargoType;
		this.pickupCy = pickupCy;
		this.laneCode = laneCode;
		this.returnCy = returnCy;
		this.polPod = polPod;
		this.boundCode = boundCode;
		this.porDel = porDel;
		this.delFlag = delFlag;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.creDt = creDt;
		this.updDt = updDt; 
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cargo_type", getCargoType());
		this.hashColumns.put("pickup_cy", getPickupCy());
		this.hashColumns.put("lane_code", getLaneCode());
		this.hashColumns.put("return_cy", getReturnCy());
		this.hashColumns.put("pol_pod", getPolPod());
		this.hashColumns.put("bound_code", getBoundCode());
		this.hashColumns.put("por_del", getPorDel());
		this.hashColumns.put("del_flag", getDelFlag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());  //, cre_usr_id, upd_usr_id, cre_dt, upd_dt
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cargo_type", "cargoType");
		this.hashFields.put("pickup_cy", "pickupCy");
		this.hashFields.put("lane_code", "laneCode");
		this.hashFields.put("return_cy", "returnCy");
		this.hashFields.put("pol_pod", "polPod");
		this.hashFields.put("bound_code", "boundCode");
		this.hashFields.put("por_del", "porDel");
		this.hashFields.put("del_flag", "delFlag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId"); //, creUsrId, updUsrId, creDt, updDt
		this.hashFields.put("upd_usr_id", "updUsrId"); //, cre_usr_id, upd_usr_id, cre_dt, upd_dt
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return cargoType
	 */
	public String getCargoType() {
		return this.cargoType;
	}
	
	/**
	 * Column Info
	 * @return pickupCy
	 */
	public String getPickupCy() {
		return this.pickupCy;
	}
	
	/**
	 * Column Info
	 * @return laneCode
	 */
	public String getLaneCode() {
		return this.laneCode;
	}
	
	/**
	 * Column Info
	 * @return returnCy
	 */
	public String getReturnCy() {
		return this.returnCy;
	}
	
	/**
	 * Column Info
	 * @return polPod
	 */
	public String getPolPod() {
		return this.polPod;
	}
	
	/**
	 * Column Info
	 * @return boundCode
	 */
	public String getBoundCode() {
		return this.boundCode;
	}
	
	/**
	 * Column Info
	 * @return porDel
	 */
	public String getPorDel() {
		return this.porDel;
	}
	
	/**
	 * Column Info
	 * @return delFlag
	 */
	public String getDelFlag() {
		return this.delFlag;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public String getUpdDt() {
		return updDt;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param cargoType
	 */
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	/**
	 * Column Info
	 * @param pickupCy
	 */
	public void setPickupCy(String pickupCy) {
		this.pickupCy = pickupCy;
	}
	
	/**
	 * Column Info
	 * @param laneCode
	 */
	public void setLaneCode(String laneCode) {
		this.laneCode = laneCode;
	}
	
	/**
	 * Column Info
	 * @param returnCy
	 */
	public void setReturnCy(String returnCy) {
		this.returnCy = returnCy;
	}
	
	/**
	 * Column Info
	 * @param polPod
	 */
	public void setPolPod(String polPod) {
		this.polPod = polPod;
	}
	
	/**
	 * Column Info
	 * @param boundCode
	 */
	public void setBoundCode(String boundCode) {
		this.boundCode = boundCode;
	}
	
	/**
	 * Column Info
	 * @param porDel
	 */
	public void setPorDel(String porDel) {
		this.porDel = porDel;
	}
	
	/**
	 * Column Info
	 * @param delFlag
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
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
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCargoType(JSPUtil.getParameter(request, "cargo_type", ""));
		setPickupCy(JSPUtil.getParameter(request, "pickup_cy", ""));
		setLaneCode(JSPUtil.getParameter(request, "lane_code", ""));
		setReturnCy(JSPUtil.getParameter(request, "return_cy", ""));
		setPolPod(JSPUtil.getParameter(request, "pol_pod", ""));
		setBoundCode(JSPUtil.getParameter(request, "bound_code", ""));
		setPorDel(JSPUtil.getParameter(request, "por_del", ""));
		setDelFlag(JSPUtil.getParameter(request, "del_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", "")); //, creUsrId, updUsrId, creDt, updDt
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", "")); //, cre_usr_id, upd_usr_id, cre_dt, upd_dt
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PickupReturnCYVO[]
	 */
	public PickupReturnCYVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PickupReturnCYVO[]
	 */
	public PickupReturnCYVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PickupReturnCYVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] cargoType = (JSPUtil.getParameter(request, prefix	+ "cargo_type", length));
			String[] pickupCy = (JSPUtil.getParameter(request, prefix	+ "pickup_cy", length));
			String[] laneCode = (JSPUtil.getParameter(request, prefix	+ "lane_code", length));
			String[] returnCy = (JSPUtil.getParameter(request, prefix	+ "return_cy", length));
			String[] polPod = (JSPUtil.getParameter(request, prefix	+ "pol_pod", length));
			String[] boundCode = (JSPUtil.getParameter(request, prefix	+ "bound_code", length));
			String[] porDel = (JSPUtil.getParameter(request, prefix	+ "por_del", length));
			String[] delFlag = (JSPUtil.getParameter(request, prefix	+ "del_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length)); //, creUsrId, updUsrId, creDt, updDt
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length)); //, cre_usr_id, upd_usr_id, cre_dt, upd_dt
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PickupReturnCYVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (cargoType[i] != null)
					model.setCargoType(cargoType[i]);
				if (pickupCy[i] != null)
					model.setPickupCy(pickupCy[i]);
				if (laneCode[i] != null)
					model.setLaneCode(laneCode[i]);
				if (returnCy[i] != null)
					model.setReturnCy(returnCy[i]);
				if (polPod[i] != null)
					model.setPolPod(polPod[i]);
				if (boundCode[i] != null)
					model.setBoundCode(boundCode[i]);
				if (porDel[i] != null)
					model.setPorDel(porDel[i]);
				if (delFlag[i] != null)
					model.setDelFlag(delFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)                //, creUsrId, updUsrId, creDt, updDt
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPickupReturnCYVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PickupReturnCYVO[]
	 */
	public PickupReturnCYVO[] getPickupReturnCYVOs(){
		PickupReturnCYVO[] vos = (PickupReturnCYVO[])models.toArray(new PickupReturnCYVO[models.size()]);
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
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoType = this.cargoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickupCy = this.pickupCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCode = this.laneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.returnCy = this.returnCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPod = this.polPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundCode = this.boundCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDel = this.porDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlag = this.delFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); //, creUsrId, updUsrId, creDt, updDt
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
