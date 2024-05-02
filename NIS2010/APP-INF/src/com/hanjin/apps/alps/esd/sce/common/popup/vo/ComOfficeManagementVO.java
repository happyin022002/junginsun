/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComOfficeManagementVO.java
*@FileTitle : ComOfficeManagementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.31 신한성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.common.popup.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComOfficeManagementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComOfficeManagementVO> models = new ArrayList<ComOfficeManagementVO>();
	
	/* Column Info */
	private String mapgOfcEngNm = null;
	/* Column Info */
	private String ofcCdName = null;
	/* Column Info */
	private String locTxt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String mstOfcCd = null;
	/* Column Info */
	private String mapgOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ofcnmTxt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ofcTxt = null;
	/* Column Info */
	private String distCd = null;
	/* Column Info */
	private String selOfcCd = null;
	/* Column Info */
	private String dist = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComOfficeManagementVO() {}

	public ComOfficeManagementVO(String ibflag, String pagerows, String ofcCd, String mapgOfcCd, String mapgOfcEngNm, String locCd, String creUsrId, String creDt, String deltFlg, String ofcEngNm, String distCd, String ofcCdName, String dist, String locTxt, String ofcnmTxt, String ofcTxt, String mstOfcCd, String selOfcCd) {
		this.mapgOfcEngNm = mapgOfcEngNm;
		this.ofcCdName = ofcCdName;
		this.locTxt = locTxt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.ofcEngNm = ofcEngNm;
		this.mstOfcCd = mstOfcCd;
		this.mapgOfcCd = mapgOfcCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ofcnmTxt = ofcnmTxt;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.ofcTxt = ofcTxt;
		this.distCd = distCd;
		this.selOfcCd = selOfcCd;
		this.dist = dist;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mapg_ofc_eng_nm", getMapgOfcEngNm());
		this.hashColumns.put("ofc_cd_name", getOfcCdName());
		this.hashColumns.put("loc_txt", getLocTxt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("mst_ofc_cd", getMstOfcCd());
		this.hashColumns.put("mapg_ofc_cd", getMapgOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ofcnm_txt", getOfcnmTxt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ofc_txt", getOfcTxt());
		this.hashColumns.put("dist_cd", getDistCd());
		this.hashColumns.put("sel_ofc_cd", getSelOfcCd());
		this.hashColumns.put("dist", getDist());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mapg_ofc_eng_nm", "mapgOfcEngNm");
		this.hashFields.put("ofc_cd_name", "ofcCdName");
		this.hashFields.put("loc_txt", "locTxt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("mst_ofc_cd", "mstOfcCd");
		this.hashFields.put("mapg_ofc_cd", "mapgOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ofcnm_txt", "ofcnmTxt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ofc_txt", "ofcTxt");
		this.hashFields.put("dist_cd", "distCd");
		this.hashFields.put("sel_ofc_cd", "selOfcCd");
		this.hashFields.put("dist", "dist");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mapgOfcEngNm
	 */
	public String getMapgOfcEngNm() {
		return this.mapgOfcEngNm;
	}
	
	/**
	 * Column Info
	 * @return ofcCdName
	 */
	public String getOfcCdName() {
		return this.ofcCdName;
	}
	
	/**
	 * Column Info
	 * @return locTxt
	 */
	public String getLocTxt() {
		return this.locTxt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return mstOfcCd
	 */
	public String getMstOfcCd() {
		return this.mstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mapgOfcCd
	 */
	public String getMapgOfcCd() {
		return this.mapgOfcCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcnmTxt
	 */
	public String getOfcnmTxt() {
		return this.ofcnmTxt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return ofcTxt
	 */
	public String getOfcTxt() {
		return this.ofcTxt;
	}
	
	/**
	 * Column Info
	 * @return distCd
	 */
	public String getDistCd() {
		return this.distCd;
	}
	
	/**
	 * Column Info
	 * @return selOfcCd
	 */
	public String getSelOfcCd() {
		return this.selOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dist
	 */
	public String getDist() {
		return this.dist;
	}
	

	/**
	 * Column Info
	 * @param mapgOfcEngNm
	 */
	public void setMapgOfcEngNm(String mapgOfcEngNm) {
		this.mapgOfcEngNm = mapgOfcEngNm;
	}
	
	/**
	 * Column Info
	 * @param ofcCdName
	 */
	public void setOfcCdName(String ofcCdName) {
		this.ofcCdName = ofcCdName;
	}
	
	/**
	 * Column Info
	 * @param locTxt
	 */
	public void setLocTxt(String locTxt) {
		this.locTxt = locTxt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param mstOfcCd
	 */
	public void setMstOfcCd(String mstOfcCd) {
		this.mstOfcCd = mstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mapgOfcCd
	 */
	public void setMapgOfcCd(String mapgOfcCd) {
		this.mapgOfcCd = mapgOfcCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcnmTxt
	 */
	public void setOfcnmTxt(String ofcnmTxt) {
		this.ofcnmTxt = ofcnmTxt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param ofcTxt
	 */
	public void setOfcTxt(String ofcTxt) {
		this.ofcTxt = ofcTxt;
	}
	
	/**
	 * Column Info
	 * @param distCd
	 */
	public void setDistCd(String distCd) {
		this.distCd = distCd;
	}
	
	/**
	 * Column Info
	 * @param selOfcCd
	 */
	public void setSelOfcCd(String selOfcCd) {
		this.selOfcCd = selOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dist
	 */
	public void setDist(String dist) {
		this.dist = dist;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMapgOfcEngNm(JSPUtil.getParameter(request, "mapg_ofc_eng_nm", ""));
		setOfcCdName(JSPUtil.getParameter(request, "ofc_cd_name", ""));
		setLocTxt(JSPUtil.getParameter(request, "loc_txt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOfcEngNm(JSPUtil.getParameter(request, "ofc_eng_nm", ""));
		setMstOfcCd(JSPUtil.getParameter(request, "mst_ofc_cd", ""));
		setMapgOfcCd(JSPUtil.getParameter(request, "mapg_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setOfcnmTxt(JSPUtil.getParameter(request, "ofcnm_txt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setOfcTxt(JSPUtil.getParameter(request, "ofc_txt", ""));
		setDistCd(JSPUtil.getParameter(request, "dist_cd", ""));
		setSelOfcCd(JSPUtil.getParameter(request, "sel_ofc_cd", ""));
		setDist(JSPUtil.getParameter(request, "dist", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComOfficeManagementVO[]
	 */
	public ComOfficeManagementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComOfficeManagementVO[]
	 */
	public ComOfficeManagementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComOfficeManagementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mapgOfcEngNm = (JSPUtil.getParameter(request, prefix	+ "mapg_ofc_eng_nm", length));
			String[] ofcCdName = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_name", length));
			String[] locTxt = (JSPUtil.getParameter(request, prefix	+ "loc_txt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] mstOfcCd = (JSPUtil.getParameter(request, prefix	+ "mst_ofc_cd", length));
			String[] mapgOfcCd = (JSPUtil.getParameter(request, prefix	+ "mapg_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ofcnmTxt = (JSPUtil.getParameter(request, prefix	+ "ofcnm_txt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ofcTxt = (JSPUtil.getParameter(request, prefix	+ "ofc_txt", length));
			String[] distCd = (JSPUtil.getParameter(request, prefix	+ "dist_cd", length));
			String[] selOfcCd = (JSPUtil.getParameter(request, prefix	+ "sel_ofc_cd", length));
			String[] dist = (JSPUtil.getParameter(request, prefix	+ "dist", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComOfficeManagementVO();
				if (mapgOfcEngNm[i] != null)
					model.setMapgOfcEngNm(mapgOfcEngNm[i]);
				if (ofcCdName[i] != null)
					model.setOfcCdName(ofcCdName[i]);
				if (locTxt[i] != null)
					model.setLocTxt(locTxt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (mstOfcCd[i] != null)
					model.setMstOfcCd(mstOfcCd[i]);
				if (mapgOfcCd[i] != null)
					model.setMapgOfcCd(mapgOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ofcnmTxt[i] != null)
					model.setOfcnmTxt(ofcnmTxt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ofcTxt[i] != null)
					model.setOfcTxt(ofcTxt[i]);
				if (distCd[i] != null)
					model.setDistCd(distCd[i]);
				if (selOfcCd[i] != null)
					model.setSelOfcCd(selOfcCd[i]);
				if (dist[i] != null)
					model.setDist(dist[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComOfficeManagementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComOfficeManagementVO[]
	 */
	public ComOfficeManagementVO[] getComOfficeManagementVOs(){
		ComOfficeManagementVO[] vos = (ComOfficeManagementVO[])models.toArray(new ComOfficeManagementVO[models.size()]);
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
		this.mapgOfcEngNm = this.mapgOfcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdName = this.ofcCdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTxt = this.locTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstOfcCd = this.mstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgOfcCd = this.mapgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcnmTxt = this.ofcnmTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTxt = this.ofcTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.distCd = this.distCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selOfcCd = this.selOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dist = this.dist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
