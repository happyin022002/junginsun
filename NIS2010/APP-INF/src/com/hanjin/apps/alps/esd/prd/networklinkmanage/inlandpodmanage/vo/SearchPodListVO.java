/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPodListVO.java
*@FileTitle : SearchPodListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.10.14 김귀진 
* 1.0 Creation
* 2011.11.02 이수진 [CHM-201113877-01] Constraint 기능상에 Update 이력 관리 기능 추가  - Creation/Update Office Code 추가
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandpodmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPodListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPodListVO> models = new ArrayList<SearchPodListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String delTerm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String delCode = null;
	/* Column Info */
	private String remarks = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String transMode = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String service = null;
	/* Column Info */
	private String laneCode = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String delState = null;
	/* Column Info */
	private String delFlag = null;
	/* Column Info */
	private String pctlIo = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	
	private String locationState = null; 
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updOfcCd = null;
	
	private String pctlImdgClssCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPodListVO() {}

	public SearchPodListVO(String ibflag, String pagerows, String laneCode, String podCode, String delCode, String delState, String delTerm, String transMode, String service, String remarks, String delFlag, String creUsrId, String creDt, String updUsrId, String updDt,String locationState, String pctlIo, String pctlIoBndCd, String creOfcCd, String updOfcCd, String pctlImdgClssCtnt ) {
		this.updDt = updDt;
		this.delTerm = delTerm;
		this.creDt = creDt;
		this.delCode = delCode;
		this.remarks = remarks;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.transMode = transMode;
		this.creUsrId = creUsrId;
		this.podCode = podCode;
		this.service = service;
		this.laneCode = laneCode;
		this.updUsrId = updUsrId;
		this.delState = delState;
		this.delFlag = delFlag;
		this.locationState = locationState;
		this.pctlIo = pctlIo;
		this.pctlIoBndCd = pctlIoBndCd;
		this.creOfcCd = creOfcCd;
		this.updOfcCd = updOfcCd;
		this.pctlImdgClssCtnt = pctlImdgClssCtnt;
	}
	
	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("del_term", getDelTerm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("del_code", getDelCode());
		this.hashColumns.put("remarks", getRemarks());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trans_mode", getTransMode());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("service", getService());
		this.hashColumns.put("lane_code", getLaneCode());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("del_state", getDelState());
		this.hashColumns.put("del_flag", getDelFlag());
		this.hashColumns.put("location_state", this.getLocationState());
		this.hashColumns.put("pctl_io", getPctlIo());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("pctl_imdg_clss_ctnt", getPctlImdgClssCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("del_term", "delTerm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("del_code", "delCode");
		this.hashFields.put("remarks", "remarks");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trans_mode", "transMode");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("service", "service");
		this.hashFields.put("lane_code", "laneCode");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("del_state", "delState");
		this.hashFields.put("del_flag", "delFlag");
		this.hashFields.put("location_state", "locationState");
		this.hashFields.put("pctl_io", "pctlIo");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("pctl_imdg_clss_ctnt", "pctlImdgClssCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return delTerm
	 */
	public String getDelTerm() {
		return this.delTerm;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return delCode
	 */
	public String getDelCode() {
		return this.delCode;
	}
	
	/**
	 * Column Info
	 * @return remarks
	 */
	public String getRemarks() {
		return this.remarks;
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
	 * @return transMode
	 */
	public String getTransMode() {
		return this.transMode;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return service
	 */
	public String getService() {
		return this.service;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return delState
	 */
	public String getDelState() {
		return this.delState;
	}
	
	/**
	 * Column Info
	 * @return delFlag
	 */
	public String getDelFlag() {
		return this.delFlag;
	}
	
	/**
	 * Column Info
	 * @return pctlIo
	 */
	public String getPctlIo() {
		return this.pctlIo;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndCd
	 */
	public String getPctlIoBndCd() {
		return this.pctlIoBndCd;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
	}
	
	public String getPctlImdgClssCtnt() {
		return pctlImdgClssCtnt;
	}

	public void setPctlImdgClssCtnt(String pctlImdgClssCtnt) {
		this.pctlImdgClssCtnt = pctlImdgClssCtnt;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param delTerm
	 */
	public void setDelTerm(String delTerm) {
		this.delTerm = delTerm;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param delCode
	 */
	public void setDelCode(String delCode) {
		this.delCode = delCode;
	}
	
	/**
	 * Column Info
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * @param transMode
	 */
	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param service
	 */
	public void setService(String service) {
		this.service = service;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param delState
	 */
	public void setDelState(String delState) {
		this.delState = delState;
	}
	
	/**
	 * Column Info
	 * @param delFlag
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	/**
	 * Column Info
	 * @param pctlIo
	 */
	public void setPctlIo(String pctlIo) {
		this.pctlIo = pctlIo;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndCd
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDelTerm(JSPUtil.getParameter(request, "del_term", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDelCode(JSPUtil.getParameter(request, "del_code", ""));
		setRemarks(JSPUtil.getParameter(request, "remarks", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTransMode(JSPUtil.getParameter(request, "trans_mode", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPodCode(JSPUtil.getParameter(request, "pod_code", ""));
		setService(JSPUtil.getParameter(request, "service", ""));
		setLaneCode(JSPUtil.getParameter(request, "lane_code", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDelState(JSPUtil.getParameter(request, "del_state", ""));
		setDelFlag(JSPUtil.getParameter(request, "del_flag", ""));
		setLocationState(JSPUtil.getParameter(request, "location_state", ""));
		setPctlIo(JSPUtil.getParameter(request, "pctl_io", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, "pctl_io_bnd_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setPctlImdgClssCtnt(JSPUtil.getParameter(request, "pctl_imdg_clss_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPodListVO[]
	 */
	public SearchPodListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPodListVO[]
	 */
	public SearchPodListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPodListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] delTerm = (JSPUtil.getParameter(request, prefix	+ "del_term", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] delCode = (JSPUtil.getParameter(request, prefix	+ "del_code", length));
			String[] remarks = (JSPUtil.getParameter(request, prefix	+ "remarks", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] transMode = (JSPUtil.getParameter(request, prefix	+ "trans_mode", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] service = (JSPUtil.getParameter(request, prefix	+ "service", length));
			String[] laneCode = (JSPUtil.getParameter(request, prefix	+ "lane_code", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] delState = (JSPUtil.getParameter(request, prefix	+ "del_state", length));
			String[] delFlag = (JSPUtil.getParameter(request, prefix	+ "del_flag", length));
			String[] locationState = (JSPUtil.getParameter(request, prefix	+ "location_state", length));
			String[] pctlIo = (JSPUtil.getParameter(request, prefix	+ "pctl_io", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] pctlImdgClssCtnt = (JSPUtil.getParameter(request, prefix	+ "pctl_imdg_clss_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPodListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (delTerm[i] != null)
					model.setDelTerm(delTerm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (delCode[i] != null)
					model.setDelCode(delCode[i]);
				if (remarks[i] != null)
					model.setRemarks(remarks[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (transMode[i] != null)
					model.setTransMode(transMode[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (service[i] != null)
					model.setService(service[i]);
				if (laneCode[i] != null)
					model.setLaneCode(laneCode[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (delState[i] != null)
					model.setDelState(delState[i]);
				if (delFlag[i] != null)
					model.setDelFlag(delFlag[i]);
				if(locationState[i] !=null)
					model.setLocationState(locationState[i]);
				if(pctlIo[i] !=null)
					model.setPctlIo(pctlIo[i]);
				if(pctlIoBndCd[i] !=null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if(updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if(pctlImdgClssCtnt[i] != null)
					model.setPctlImdgClssCtnt(pctlImdgClssCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPodListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPodListVO[]
	 */
	public SearchPodListVO[] getSearchPodListVOs(){
		SearchPodListVO[] vos = (SearchPodListVO[])models.toArray(new SearchPodListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delTerm = this.delTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCode = this.delCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarks = this.remarks .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transMode = this.transMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.service = this.service .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCode = this.laneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delState = this.delState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delFlag = this.delFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationState = this.locationState .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIo = this.pctlIo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlImdgClssCtnt = this.pctlImdgClssCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
