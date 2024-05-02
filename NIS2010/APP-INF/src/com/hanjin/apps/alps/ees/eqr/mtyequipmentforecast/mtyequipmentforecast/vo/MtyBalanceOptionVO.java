/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MtyBalanceOptionVO.java
*@FileTitle : MtyBalanceOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.10
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.04.10 김종준 
* 1.0 Creation
=========================================================*/ 

package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo;

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
 * @author 김종준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */ 

public class MtyBalanceOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyBalanceOptionVO> models = new ArrayList<MtyBalanceOptionVO>();
	
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String searchFlag = null;
	/* Column Info */
	private String repoFlag = null;
	/* Column Info */
	private String fcastYrwk = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String locGrpCd = null;	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inpYrwk = null;
	/* Column Info */
	private String tpCd = null;
	/* Column Info */
	private String repoPlnYrwk = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String wkStDt = null;
	/* Page Number */
	private String wkEndDt = null;
	/* Page Number */
	private String currFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyBalanceOptionVO() {}

	public MtyBalanceOptionVO(String ibflag, String pagerows, String locCd, String locGrpCd, String fcastYrwk, String tpCd, String inpYrwk, String searchFlag, String repoFlag, String repoPlnId, String repoPlnYrwk, String wkStDt, String wkEndDt, String currFlag) {
		this.repoPlnId = repoPlnId;
		this.searchFlag = searchFlag;
		this.repoFlag = repoFlag;
		this.fcastYrwk = fcastYrwk;
		this.locCd = locCd;
		this.locGrpCd = locGrpCd;		
		this.ibflag = ibflag;
		this.inpYrwk = inpYrwk;
		this.tpCd = tpCd;
		this.repoPlnYrwk = repoPlnYrwk;
		this.pagerows = pagerows;
		this.wkStDt = wkStDt;
		this.wkEndDt = wkEndDt;
		this.currFlag = currFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("search_flag", getSearchFlag());
		this.hashColumns.put("repo_flag", getRepoFlag());
		this.hashColumns.put("fcast_yrwk", getFcastYrwk());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());		
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inp_yrwk", getInpYrwk());
		this.hashColumns.put("tp_cd", getTpCd());
		this.hashColumns.put("repo_pln_yrwk", getRepoPlnYrwk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("wk_st_dt", getWkStDt());
		this.hashColumns.put("wk_end_dt", getWkEndDt());
		this.hashColumns.put("curr_flag", getCurrFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("search_flag", "searchFlag");
		this.hashFields.put("repo_flag", "repoFlag");
		this.hashFields.put("fcast_yrwk", "fcastYrwk");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("loc_grp_cd", "locGrpCd");		
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inp_yrwk", "inpYrwk");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("repo_pln_yrwk", "repoPlnYrwk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("wk_st_dt", "wkStDt");
		this.hashFields.put("wk_end_dt", "wkEndDt");
		this.hashFields.put("curr_flag", "currFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return searchFlag
	 */
	public String getSearchFlag() {
		return this.searchFlag;
	}
	
	/**
	 * Column Info
	 * @return repoFlag
	 */
	public String getRepoFlag() {
		return this.repoFlag;
	}
	
	/**
	 * Column Info
	 * @return fcastYrwk
	 */
	public String getFcastYrwk() {
		return this.fcastYrwk;
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
	 * @return locGrpCd
	 */
	public String getLocGrpCd() {
		return this.locGrpCd;
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
	 * @return inpYrwk
	 */
	public String getInpYrwk() {
		return this.inpYrwk;
	}
	
	/**
	 * Column Info
	 * @return tpCd
	 */
	public String getTpCd() {
		return this.tpCd;
	}
	
	/**
	 * Column Info
	 * @return repoPlnYrwk
	 */
	public String getRepoPlnYrwk() {
		return this.repoPlnYrwk;
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
	 * @return wkStDt
	 */
	public String getWkStDt() {
		return this.wkStDt;
	}
	
	/**
	 * Column Info
	 * @return wkEndDt
	 */
	public String getWkEndDt() {
		return this.wkEndDt;
	}
	
	/**
	 * Column Info
	 * @return currFlag
	 */
	public String getCurrFlag() {
		return this.currFlag;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param searchFlag
	 */
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
	
	/**
	 * Column Info
	 * @param repoFlag
	 */
	public void setRepoFlag(String repoFlag) {
		this.repoFlag = repoFlag;
	}
	
	/**
	 * Column Info
	 * @param fcastYrwk
	 */
	public void setFcastYrwk(String fcastYrwk) {
		this.fcastYrwk = fcastYrwk;
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
	 * @param locGrpCd
	 */
	public void setLocGrpCd(String locGrpCd) {
		this.locGrpCd = locGrpCd;
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
	 * @param inpYrwk
	 */
	public void setInpYrwk(String inpYrwk) {
		this.inpYrwk = inpYrwk;
	}
	
	/**
	 * Column Info
	 * @param tpCd
	 */
	public void setTpCd(String tpCd) {
		this.tpCd = tpCd;
	}
	
	/**
	 * Column Info
	 * @param repoPlnYrwk
	 */
	public void setRepoPlnYrwk(String repoPlnYrwk) {
		this.repoPlnYrwk = repoPlnYrwk;
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
	 * @param wkStDt
	 */
	public void setWkStDt(String wkStDt) {
		this.wkStDt = wkStDt;
	}
	
	/**
	 * Column Info
	 * @param wkEndDt
	 */
	public void setWkEndDt(String wkEndDt) {
		this.wkEndDt = wkEndDt;
	}
	
	/**
	 * Column Info
	 * @param currFlag
	 */
	public void setCurrFlag(String currFlag) {
		this.currFlag = currFlag;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setSearchFlag(JSPUtil.getParameter(request, "search_flag", ""));
		setRepoFlag(JSPUtil.getParameter(request, "repo_flag", ""));
		setFcastYrwk(JSPUtil.getParameter(request, "fcast_yrwk", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setLocGrpCd(JSPUtil.getParameter(request, "loc_grp_cd", ""));		
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInpYrwk(JSPUtil.getParameter(request, "inp_yrwk", ""));
		setTpCd(JSPUtil.getParameter(request, "tp_cd", ""));
		setRepoPlnYrwk(JSPUtil.getParameter(request, "repo_pln_yrwk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setWkStDt(JSPUtil.getParameter(request, "wk_st_dt", ""));
		setWkEndDt(JSPUtil.getParameter(request, "wk_end_dt", ""));
		setCurrFlag(JSPUtil.getParameter(request, "curr_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyBalanceOptionVO[]
	 */
	public MtyBalanceOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyBalanceOptionVO[]
	 */
	public MtyBalanceOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyBalanceOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] searchFlag = (JSPUtil.getParameter(request, prefix	+ "search_flag", length));
			String[] repoFlag = (JSPUtil.getParameter(request, prefix	+ "repo_flag", length));
			String[] fcastYrwk = (JSPUtil.getParameter(request, prefix	+ "fcast_yrwk", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inpYrwk = (JSPUtil.getParameter(request, prefix	+ "inp_yrwk", length));
			String[] tpCd = (JSPUtil.getParameter(request, prefix	+ "tp_cd", length));
			String[] repoPlnYrwk = (JSPUtil.getParameter(request, prefix	+ "repo_pln_yrwk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] wkStDt = (JSPUtil.getParameter(request, prefix	+ "wk_st_dt", length));
			String[] wkEndDt = (JSPUtil.getParameter(request, prefix	+ "wk_end_dt", length));
			String[] currFlag = (JSPUtil.getParameter(request, prefix	+ "curr_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyBalanceOptionVO();
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (searchFlag[i] != null)
					model.setSearchFlag(searchFlag[i]);
				if (repoFlag[i] != null)
					model.setRepoFlag(repoFlag[i]);
				if (fcastYrwk[i] != null)
					model.setFcastYrwk(fcastYrwk[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);				
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inpYrwk[i] != null)
					model.setInpYrwk(inpYrwk[i]);
				if (tpCd[i] != null)
					model.setTpCd(tpCd[i]);
				if (repoPlnYrwk[i] != null)
					model.setRepoPlnYrwk(repoPlnYrwk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (wkStDt[i] != null)
					model.setWkStDt(wkStDt[i]);
				if (wkEndDt[i] != null)
					model.setWkEndDt(wkEndDt[i]);
				if (currFlag[i] != null)
					model.setCurrFlag(currFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyBalanceOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyBalanceOptionVO[]
	 */
	public MtyBalanceOptionVO[] getMtyBalanceOptionVOs(){
		MtyBalanceOptionVO[] vos = (MtyBalanceOptionVO[])models.toArray(new MtyBalanceOptionVO[models.size()]);
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
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchFlag = this.searchFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoFlag = this.repoFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastYrwk = this.fcastYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYrwk = this.inpYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd = this.tpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnYrwk = this.repoPlnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkStDt = this.wkStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkEndDt = this.wkEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlag = this.currFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
