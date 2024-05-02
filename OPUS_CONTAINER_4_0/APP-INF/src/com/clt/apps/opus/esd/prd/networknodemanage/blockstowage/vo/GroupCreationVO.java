/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GroupCreationVO.java
*@FileTitle : GroupCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.08.05 노승배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GroupCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GroupCreationVO> models = new ArrayList<GroupCreationVO>();
	
	/* Column Info */
	private String uDate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String cDate = null;
	/* Column Info */
	private String uUserId = null;
	/* Column Info */
	private String cUserId = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String groupCode = null;
	/* Column Info */
	private String laneCode = null;
	/* Column Info */
	private String hubCode = null;
	/* Column Info */
	private String delFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GroupCreationVO() {}

	public GroupCreationVO(String ibflag, String pagerows, String delFlag, String podCode, String hubCode, String laneCode, String groupCode, String cUserId, String cDate, String uUserId, String uDate, String userId) {
		this.uDate = uDate;
		this.ibflag = ibflag;
		this.podCode = podCode;
		this.cDate = cDate;
		this.uUserId = uUserId;
		this.cUserId = cUserId;
		this.userId = userId;
		this.groupCode = groupCode;
		this.laneCode = laneCode;
		this.hubCode = hubCode;
		this.delFlag = delFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("u_date", getUDate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("c_date", getCDate());
		this.hashColumns.put("u_user_id", getUUserId());
		this.hashColumns.put("c_user_id", getCUserId());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("group_code", getGroupCode());
		this.hashColumns.put("lane_code", getLaneCode());
		this.hashColumns.put("hub_code", getHubCode());
		this.hashColumns.put("del_flag", getDelFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("u_date", "uDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("c_date", "cDate");
		this.hashFields.put("u_user_id", "uUserId");
		this.hashFields.put("c_user_id", "cUserId");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("group_code", "groupCode");
		this.hashFields.put("lane_code", "laneCode");
		this.hashFields.put("hub_code", "hubCode");
		this.hashFields.put("del_flag", "delFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return uDate
	 */
	public String getUDate() {
		return this.uDate;
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
	 * @return podCode
	 */
	public String getPodCode() {
		return this.podCode;
	}
	
	/**
	 * Column Info
	 * @return cDate
	 */
	public String getCDate() {
		return this.cDate;
	}
	
	/**
	 * Column Info
	 * @return uUserId
	 */
	public String getUUserId() {
		return this.uUserId;
	}
	
	/**
	 * Column Info
	 * @return cUserId
	 */
	public String getCUserId() {
		return this.cUserId;
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
	 * @return groupCode
	 */
	public String getGroupCode() {
		return this.groupCode;
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
	 * @return hubCode
	 */
	public String getHubCode() {
		return this.hubCode;
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
	

	/**
	 * Column Info
	 * @param uDate
	 */
	public void setUDate(String uDate) {
		this.uDate = uDate;
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
	 * @param podCode
	 */
	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}
	
	/**
	 * Column Info
	 * @param cDate
	 */
	public void setCDate(String cDate) {
		this.cDate = cDate;
	}
	
	/**
	 * Column Info
	 * @param uUserId
	 */
	public void setUUserId(String uUserId) {
		this.uUserId = uUserId;
	}
	
	/**
	 * Column Info
	 * @param cUserId
	 */
	public void setCUserId(String cUserId) {
		this.cUserId = cUserId;
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
	 * @param groupCode
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
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
	 * @param hubCode
	 */
	public void setHubCode(String hubCode) {
		this.hubCode = hubCode;
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
		setUDate(JSPUtil.getParameter(request, "u_date", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodCode(JSPUtil.getParameter(request, "pod_code", ""));
		setCDate(JSPUtil.getParameter(request, "c_date", ""));
		setUUserId(JSPUtil.getParameter(request, "u_user_id", ""));
		setCUserId(JSPUtil.getParameter(request, "c_user_id", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setGroupCode(JSPUtil.getParameter(request, "group_code", ""));
		setLaneCode(JSPUtil.getParameter(request, "lane_code", ""));
		setHubCode(JSPUtil.getParameter(request, "hub_code", ""));
		setDelFlag(JSPUtil.getParameter(request, "del_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GroupCreationVO[]
	 */
	public GroupCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GroupCreationVO[]
	 */
	public GroupCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GroupCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] uDate = (JSPUtil.getParameter(request, prefix	+ "u_date", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] cDate = (JSPUtil.getParameter(request, prefix	+ "c_date", length));
			String[] uUserId = (JSPUtil.getParameter(request, prefix	+ "u_user_id", length));
			String[] cUserId = (JSPUtil.getParameter(request, prefix	+ "c_user_id", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] groupCode = (JSPUtil.getParameter(request, prefix	+ "group_code", length));
			String[] laneCode = (JSPUtil.getParameter(request, prefix	+ "lane_code", length));
			String[] hubCode = (JSPUtil.getParameter(request, prefix	+ "hub_code", length));
			String[] delFlag = (JSPUtil.getParameter(request, prefix	+ "del_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GroupCreationVO();
				if (uDate[i] != null)
					model.setUDate(uDate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (cDate[i] != null)
					model.setCDate(cDate[i]);
				if (uUserId[i] != null)
					model.setUUserId(uUserId[i]);
				if (cUserId[i] != null)
					model.setCUserId(cUserId[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (groupCode[i] != null)
					model.setGroupCode(groupCode[i]);
				if (laneCode[i] != null)
					model.setLaneCode(laneCode[i]);
				if (hubCode[i] != null)
					model.setHubCode(hubCode[i]);
				if (delFlag[i] != null)
					model.setDelFlag(delFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGroupCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GroupCreationVO[]
	 */
	public GroupCreationVO[] getGroupCreationVOs(){
		GroupCreationVO[] vos = (GroupCreationVO[])models.toArray(new GroupCreationVO[models.size()]);
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
		this.uDate = this.uDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDate = this.cDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uUserId = this.uUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cUserId = this.cUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupCode = this.groupCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCode = this.laneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubCode = this.hubCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlag = this.delFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
