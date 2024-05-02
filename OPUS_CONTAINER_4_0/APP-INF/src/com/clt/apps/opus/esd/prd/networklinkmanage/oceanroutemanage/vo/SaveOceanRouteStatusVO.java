/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SaveOceanRouteStatusVO.java
*@FileTitle : SaveOceanRouteStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.18 김귀진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaveOceanRouteStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaveOceanRouteStatusVO> models = new ArrayList<SaveOceanRouteStatusVO>();
	
	/* Column Info */
	private String sLaneCd = null;
	/* Column Info */
	private String gStatus = null;
	private String sStandard = null;
	private String sMulti = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sUpdIndCd = null;
	/* Column Info */
	private String sLeg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sLaneTp = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaveOceanRouteStatusVO() {}

	public SaveOceanRouteStatusVO(String ibflag, String pagerows, String sLaneCd, String sLaneTp, String sLeg, String gStatus, String sStandard, String sMulti, String sUpdIndCd, String creOfcCd, String creUsrId, String updUsrId) {
		this.sLaneCd = sLaneCd;
		this.gStatus = gStatus;
		this.sStandard = sStandard;
		this.sMulti = sMulti;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.sUpdIndCd = sUpdIndCd;
		this.sLeg = sLeg;
		this.creOfcCd = creOfcCd;
		this.updUsrId = updUsrId;
		this.sLaneTp = sLaneTp;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_lane_cd", getSLaneCd());
		this.hashColumns.put("g_status", getGStatus());
		this.hashColumns.put("s_standard", getSStandard());
		this.hashColumns.put("s_multi", getSMulti());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_upd_ind_cd", getSUpdIndCd());
		this.hashColumns.put("s_leg", getSLeg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_lane_tp", getSLaneTp());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_lane_cd", "sLaneCd");
		this.hashFields.put("g_status", "gStatus");
		this.hashFields.put("s_standard", "sStandard");
		this.hashFields.put("s_multi", "sMulti");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_upd_ind_cd", "sUpdIndCd");
		this.hashFields.put("s_leg", "sLeg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_lane_tp", "sLaneTp");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sLaneCd
	 */
	public String getSLaneCd() {
		return this.sLaneCd;
	}
	
	/**
	 * Column Info
	 * @return gStatus
	 */
	public String getGStatus() {
		return this.gStatus;
	}

	/**
	 * Column Info
	 * @return sStandard
	 */
	public String getSStandard() {
		return this.sStandard;
	}

	/**
	 * Column Info
	 * @return sMulti
	 */
	public String getSMulti() {
		return this.sMulti;
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
	 * @return sUpdIndCd
	 */
	public String getSUpdIndCd() {
		return this.sUpdIndCd;
	}
	
	/**
	 * Column Info
	 * @return sLeg
	 */
	public String getSLeg() {
		return this.sLeg;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return sLaneTp
	 */
	public String getSLaneTp() {
		return this.sLaneTp;
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
	 * @param sLaneCd
	 */
	public void setSLaneCd(String sLaneCd) {
		this.sLaneCd = sLaneCd;
	}
	
	/**
	 * Column Info
	 * @param gStatus
	 */
	public void setGStatus(String gStatus) {
		this.gStatus = gStatus;
	}

	/**
	 * Column Info
	 * @param sStandard
	 */
	public void setSStandard(String sStandard) {
		this.sStandard = sStandard;
	}
	
	/**
	 * Column Info
	 * @param sMulti
	 */
	public void setSMulti(String sMulti) {
		this.sMulti = sMulti;
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
	 * @param sUpdIndCd
	 */
	public void setSUpdIndCd(String sUpdIndCd) {
		this.sUpdIndCd = sUpdIndCd;
	}
	
	/**
	 * Column Info
	 * @param sLeg
	 */
	public void setSLeg(String sLeg) {
		this.sLeg = sLeg;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param sLaneTp
	 */
	public void setSLaneTp(String sLaneTp) {
		this.sLaneTp = sLaneTp;
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
		setSLaneCd(JSPUtil.getParameter(request, "s_lane_cd", ""));
		setGStatus(JSPUtil.getParameter(request, "g_status", ""));
		setSStandard(JSPUtil.getParameter(request, "s_standard", ""));
		setSMulti(JSPUtil.getParameter(request, "s_multi", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSUpdIndCd(JSPUtil.getParameter(request, "s_upd_ind_cd", ""));
		setSLeg(JSPUtil.getParameter(request, "s_leg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSLaneTp(JSPUtil.getParameter(request, "s_lane_tp", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaveOceanRouteStatusVO[]
	 */
	public SaveOceanRouteStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaveOceanRouteStatusVO[]
	 */
	public SaveOceanRouteStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaveOceanRouteStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sLaneCd = (JSPUtil.getParameter(request, prefix	+ "s_lane_cd", length));
			String[] gStatus = (JSPUtil.getParameter(request, prefix	+ "g_status", length));
			String[] sStandard = (JSPUtil.getParameter(request, prefix	+ "s_standard", length));
			String[] sMulti = (JSPUtil.getParameter(request, prefix	+ "s_multi", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sUpdIndCd = (JSPUtil.getParameter(request, prefix	+ "s_upd_ind_cd", length));
			String[] sLeg = (JSPUtil.getParameter(request, prefix	+ "s_leg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sLaneTp = (JSPUtil.getParameter(request, prefix	+ "s_lane_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaveOceanRouteStatusVO();
				if (sLaneCd[i] != null)
					model.setSLaneCd(sLaneCd[i]);
				if (gStatus[i] != null)
					model.setGStatus(gStatus[i]);
				if (sStandard[i] != null)
					model.setSStandard(sStandard[i]);
				if (sMulti[i] != null)
					model.setSMulti(sMulti[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sUpdIndCd[i] != null)
					model.setSUpdIndCd(sUpdIndCd[i]);
				if (sLeg[i] != null)
					model.setSLeg(sLeg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sLaneTp[i] != null)
					model.setSLaneTp(sLaneTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaveOceanRouteStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaveOceanRouteStatusVO[]
	 */
	public SaveOceanRouteStatusVO[] getSaveOceanRouteStatusVOs(){
		SaveOceanRouteStatusVO[] vos = (SaveOceanRouteStatusVO[])models.toArray(new SaveOceanRouteStatusVO[models.size()]);
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
		this.sLaneCd = this.sLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gStatus = this.gStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStandard = this.sStandard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMulti = this.sMulti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUpdIndCd = this.sUpdIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLeg = this.sLeg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLaneTp = this.sLaneTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
