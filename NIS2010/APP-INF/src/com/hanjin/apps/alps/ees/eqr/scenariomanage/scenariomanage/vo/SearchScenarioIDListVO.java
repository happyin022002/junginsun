/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchScenarioIDListVO.java
*@FileTitle : SearchScenarioIDListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.23 이행지 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo;

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
 * @author 이행지
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchScenarioIDListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScenarioIDListVO> models = new ArrayList<SearchScenarioIDListVO>();
	
	/* Column Info */
	private String manual = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String scnrRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String repo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String auto = null;
	/* Column Info */
	private String repoPlnDtrbFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String week = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScenarioIDListVO() {}

	public SearchScenarioIDListVO(String ibflag, String pagerows, String week, String scnrId, String scnrRmk, String updUsrId, String updDt, String creDt, String repoPlnDtrbFlg, String repo, String auto, String manual) {
		this.manual = manual;
		this.updDt = updDt;
		this.scnrRmk = scnrRmk;
		this.ibflag = ibflag;
		this.scnrId = scnrId;
		this.repo = repo;
		this.creDt = creDt;
		this.auto = auto;
		this.repoPlnDtrbFlg = repoPlnDtrbFlg;
		this.updUsrId = updUsrId;
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
		this.hashColumns.put("scnr_rmk", getScnrRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("repo", getRepo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("auto", getAuto());
		this.hashColumns.put("repo_pln_dtrb_flg", getRepoPlnDtrbFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
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
		this.hashFields.put("scnr_rmk", "scnrRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("repo", "repo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("auto", "auto");
		this.hashFields.put("repo_pln_dtrb_flg", "repoPlnDtrbFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return scnrRmk
	 */
	public String getScnrRmk() {
		return this.scnrRmk;
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
	 * @return repo
	 */
	public String getRepo() {
		return this.repo;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param scnrRmk
	 */
	public void setScnrRmk(String scnrRmk) {
		this.scnrRmk = scnrRmk;
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
	 * @param repo
	 */
	public void setRepo(String repo) {
		this.repo = repo;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setScnrRmk(JSPUtil.getParameter(request, "scnr_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setRepo(JSPUtil.getParameter(request, "repo", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAuto(JSPUtil.getParameter(request, "auto", ""));
		setRepoPlnDtrbFlg(JSPUtil.getParameter(request, "repo_pln_dtrb_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScenarioIDListVO[]
	 */
	public SearchScenarioIDListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScenarioIDListVO[]
	 */
	public SearchScenarioIDListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScenarioIDListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] manual = (JSPUtil.getParameter(request, prefix	+ "manual", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] scnrRmk = (JSPUtil.getParameter(request, prefix	+ "scnr_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] repo = (JSPUtil.getParameter(request, prefix	+ "repo", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] auto = (JSPUtil.getParameter(request, prefix	+ "auto", length));
			String[] repoPlnDtrbFlg = (JSPUtil.getParameter(request, prefix	+ "repo_pln_dtrb_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScenarioIDListVO();
				if (manual[i] != null)
					model.setManual(manual[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (scnrRmk[i] != null)
					model.setScnrRmk(scnrRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (repo[i] != null)
					model.setRepo(repo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (auto[i] != null)
					model.setAuto(auto[i]);
				if (repoPlnDtrbFlg[i] != null)
					model.setRepoPlnDtrbFlg(repoPlnDtrbFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScenarioIDListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScenarioIDListVO[]
	 */
	public SearchScenarioIDListVO[] getSearchScenarioIDListVOs(){
		SearchScenarioIDListVO[] vos = (SearchScenarioIDListVO[])models.toArray(new SearchScenarioIDListVO[models.size()]);
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
		this.scnrRmk = this.scnrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repo = this.repo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auto = this.auto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnDtrbFlg = this.repoPlnDtrbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
