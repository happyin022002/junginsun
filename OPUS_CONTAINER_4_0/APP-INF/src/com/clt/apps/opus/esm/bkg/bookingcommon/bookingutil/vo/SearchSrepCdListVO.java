/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSrepCdListVO.java
*@FileTitle : SearchSrepCdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.01 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSrepCdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSrepCdListVO> models = new ArrayList<SearchSrepCdListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String srepMgrCd = null;
	/* Column Info */
	private String ctrlAreaOfcNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String srepSexCd = null;
	/* Column Info */
	private String subTeamCd = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSrepCdListVO() {}

	public SearchSrepCdListVO(String ibflag, String pagerows, String srepCd, String ofcCd, String srepNm, String subTeamCd, String srepMgrCd, String ctrlAreaOfcNm, String srepSexCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.srepMgrCd = srepMgrCd;
		this.ctrlAreaOfcNm = ctrlAreaOfcNm;
		this.creDt = creDt;
		this.srepSexCd = srepSexCd;
		this.subTeamCd = subTeamCd;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.srepNm = srepNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("srep_mgr_cd", getSrepMgrCd());
		this.hashColumns.put("ctrl_area_ofc_nm", getCtrlAreaOfcNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("srep_sex_cd", getSrepSexCd());
		this.hashColumns.put("sub_team_cd", getSubTeamCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("srep_mgr_cd", "srepMgrCd");
		this.hashFields.put("ctrl_area_ofc_nm", "ctrlAreaOfcNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("srep_sex_cd", "srepSexCd");
		this.hashFields.put("sub_team_cd", "subTeamCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return srepMgrCd
	 */
	public String getSrepMgrCd() {
		return this.srepMgrCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlAreaOfcNm
	 */
	public String getCtrlAreaOfcNm() {
		return this.ctrlAreaOfcNm;
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
	 * @return srepSexCd
	 */
	public String getSrepSexCd() {
		return this.srepSexCd;
	}
	
	/**
	 * Column Info
	 * @return subTeamCd
	 */
	public String getSubTeamCd() {
		return this.subTeamCd;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param srepMgrCd
	 */
	public void setSrepMgrCd(String srepMgrCd) {
		this.srepMgrCd = srepMgrCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlAreaOfcNm
	 */
	public void setCtrlAreaOfcNm(String ctrlAreaOfcNm) {
		this.ctrlAreaOfcNm = ctrlAreaOfcNm;
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
	 * @param srepSexCd
	 */
	public void setSrepSexCd(String srepSexCd) {
		this.srepSexCd = srepSexCd;
	}
	
	/**
	 * Column Info
	 * @param subTeamCd
	 */
	public void setSubTeamCd(String subTeamCd) {
		this.subTeamCd = subTeamCd;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSrepMgrCd(JSPUtil.getParameter(request, "srep_mgr_cd", ""));
		setCtrlAreaOfcNm(JSPUtil.getParameter(request, "ctrl_area_ofc_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSrepSexCd(JSPUtil.getParameter(request, "srep_sex_cd", ""));
		setSubTeamCd(JSPUtil.getParameter(request, "sub_team_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSrepNm(JSPUtil.getParameter(request, "srep_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSrepCdListVO[]
	 */
	public SearchSrepCdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSrepCdListVO[]
	 */
	public SearchSrepCdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSrepCdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] srepMgrCd = (JSPUtil.getParameter(request, prefix	+ "srep_mgr_cd", length));
			String[] ctrlAreaOfcNm = (JSPUtil.getParameter(request, prefix	+ "ctrl_area_ofc_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] srepSexCd = (JSPUtil.getParameter(request, prefix	+ "srep_sex_cd", length));
			String[] subTeamCd = (JSPUtil.getParameter(request, prefix	+ "sub_team_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSrepCdListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (srepMgrCd[i] != null)
					model.setSrepMgrCd(srepMgrCd[i]);
				if (ctrlAreaOfcNm[i] != null)
					model.setCtrlAreaOfcNm(ctrlAreaOfcNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (srepSexCd[i] != null)
					model.setSrepSexCd(srepSexCd[i]);
				if (subTeamCd[i] != null)
					model.setSubTeamCd(subTeamCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSrepCdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSrepCdListVO[]
	 */
	public SearchSrepCdListVO[] getSearchSrepCdListVOs(){
		SearchSrepCdListVO[] vos = (SearchSrepCdListVO[])models.toArray(new SearchSrepCdListVO[models.size()]);
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
		this.srepMgrCd = this.srepMgrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlAreaOfcNm = this.ctrlAreaOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepSexCd = this.srepSexCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTeamCd = this.subTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
