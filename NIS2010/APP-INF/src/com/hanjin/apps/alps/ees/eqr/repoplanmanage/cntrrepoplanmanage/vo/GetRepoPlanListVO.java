/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GetRepoPlanListVO.java
*@FileTitle : GetRepoPlanListVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.14		1.0 최초 생성
*
*@LastModifyDate : 2009.08.14
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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

public class GetRepoPlanListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetRepoPlanListVO> models = new ArrayList<GetRepoPlanListVO>();
	
	/* Column Info */
	private String manual = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String repoPlnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String auto = null;
	/* Column Info */
	private String repoPlnDtrbFlg = null;
	/* Column Info */
	private String usrid = null;
	/* Column Info */
	private String repoPlnRmk = null;
	/* Column Info */
	private String week = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetRepoPlanListVO() {}

	public GetRepoPlanListVO(String ibflag, String pagerows, String week, String repoPlnId, String repoPlnRmk, String usrid, String updDt, String creDt, String repoPlnDtrbFlg, String auto, String manual, String scnrId) {
		this.manual = manual;
		this.updDt = updDt;
		this.repoPlnId = repoPlnId;
		this.ibflag = ibflag;
		this.scnrId = scnrId;
		this.creDt = creDt;
		this.auto = auto;
		this.repoPlnDtrbFlg = repoPlnDtrbFlg;
		this.usrid = usrid;
		this.repoPlnRmk = repoPlnRmk;
		this.week = week;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("manual", getManual());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("auto", getAuto());
		this.hashColumns.put("repo_pln_dtrb_flg", getRepoPlnDtrbFlg());
		this.hashColumns.put("usrID", getUsrid());									// 대소문자 구분 주의
		this.hashColumns.put("repo_pln_rmk", getRepoPlnRmk());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("manual", "manual");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("auto", "auto");
		this.hashFields.put("repo_pln_dtrb_flg", "repoPlnDtrbFlg");
		this.hashFields.put("usrid", "usrid");
		this.hashFields.put("repo_pln_rmk", "repoPlnRmk");
		this.hashFields.put("week", "week");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return manual
	 */
	public String getManual() {
		return this.manual;
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
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
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
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
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
	 * @return auto
	 */
	public String getAuto() {
		return this.auto;
	}
	
	/**
	 * Column Info
	 * @return repoPlnDtrbFlg
	 */
	public String getRepoPlnDtrbFlg() {
		return this.repoPlnDtrbFlg;
	}
	
	/**
	 * Column Info
	 * @return usrid
	 */
	public String getUsrid() {
		return this.usrid;
	}
	
	/**
	 * Column Info
	 * @return repoPlnRmk
	 */
	public String getRepoPlnRmk() {
		return this.repoPlnRmk;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
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
	 * @param manual
	 */
	public void setManual(String manual) {
		this.manual = manual;
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
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
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
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
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
	 * @param auto
	 */
	public void setAuto(String auto) {
		this.auto = auto;
	}
	
	/**
	 * Column Info
	 * @param repoPlnDtrbFlg
	 */
	public void setRepoPlnDtrbFlg(String repoPlnDtrbFlg) {
		this.repoPlnDtrbFlg = repoPlnDtrbFlg;
	}
	
	/**
	 * Column Info
	 * @param usrid
	 */
	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}
	
	/**
	 * Column Info
	 * @param repoPlnRmk
	 */
	public void setRepoPlnRmk(String repoPlnRmk) {
		this.repoPlnRmk = repoPlnRmk;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setManual(JSPUtil.getParameter(request, "manual", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAuto(JSPUtil.getParameter(request, "auto", ""));
		setRepoPlnDtrbFlg(JSPUtil.getParameter(request, "repo_pln_dtrb_flg", ""));
		setUsrid(JSPUtil.getParameter(request, "usrid", ""));
		setRepoPlnRmk(JSPUtil.getParameter(request, "repo_pln_rmk", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetRepoPlanListVO[]
	 */
	public GetRepoPlanListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetRepoPlanListVO[]
	 */
	public GetRepoPlanListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetRepoPlanListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] manual = (JSPUtil.getParameter(request, prefix	+ "manual", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] auto = (JSPUtil.getParameter(request, prefix	+ "auto", length));
			String[] repoPlnDtrbFlg = (JSPUtil.getParameter(request, prefix	+ "repo_pln_dtrb_flg", length));
			String[] usrid = (JSPUtil.getParameter(request, prefix	+ "usrid", length));
			String[] repoPlnRmk = (JSPUtil.getParameter(request, prefix	+ "repo_pln_rmk", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetRepoPlanListVO();
				if (manual[i] != null)
					model.setManual(manual[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (auto[i] != null)
					model.setAuto(auto[i]);
				if (repoPlnDtrbFlg[i] != null)
					model.setRepoPlnDtrbFlg(repoPlnDtrbFlg[i]);
				if (usrid[i] != null)
					model.setUsrid(usrid[i]);
				if (repoPlnRmk[i] != null)
					model.setRepoPlnRmk(repoPlnRmk[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetRepoPlanListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetRepoPlanListVO[]
	 */
	public GetRepoPlanListVO[] getGetRepoPlanListVOs(){
		GetRepoPlanListVO[] vos = (GetRepoPlanListVO[])models.toArray(new GetRepoPlanListVO[models.size()]);
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
		this.manual = this.manual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auto = this.auto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnDtrbFlg = this.repoPlnDtrbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrid = this.usrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnRmk = this.repoPlnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
