/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchUserGroupIdVO.java
*@FileTitle : SearchUserGroupIdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.01 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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

public class SearchUserGroupIdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUserGroupIdVO> models = new ArrayList<SearchUserGroupIdVO>();
	
	/* Column Info */
	private String dpcsWrkGrpCd2 = null;
	/* Column Info */
	private String dpcsWrkSvrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String dpcsWrkPrtCd = null;
	/* Column Info */
	private String dpcsWrkGrpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUserGroupIdVO() {}

	public SearchUserGroupIdVO(String ibflag, String pagerows, String usrId, String dpcsWrkGrpCd, String dpcsWrkGrpCd2, String dpcsWrkPrtCd, String dpcsWrkSvrCd) {
		this.dpcsWrkGrpCd2 = dpcsWrkGrpCd2;
		this.dpcsWrkSvrCd = dpcsWrkSvrCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.dpcsWrkPrtCd = dpcsWrkPrtCd;
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dpcs_wrk_grp_cd_2", getDpcsWrkGrpCd2());
		this.hashColumns.put("dpcs_wrk_svr_cd", getDpcsWrkSvrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("dpcs_wrk_prt_cd", getDpcsWrkPrtCd());
		this.hashColumns.put("dpcs_wrk_grp_cd", getDpcsWrkGrpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dpcs_wrk_grp_cd_2", "dpcsWrkGrpCd2");
		this.hashFields.put("dpcs_wrk_svr_cd", "dpcsWrkSvrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("dpcs_wrk_prt_cd", "dpcsWrkPrtCd");
		this.hashFields.put("dpcs_wrk_grp_cd", "dpcsWrkGrpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkGrpCd2
	 */
	public String getDpcsWrkGrpCd2() {
		return this.dpcsWrkGrpCd2;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkSvrCd
	 */
	public String getDpcsWrkSvrCd() {
		return this.dpcsWrkSvrCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkPrtCd
	 */
	public String getDpcsWrkPrtCd() {
		return this.dpcsWrkPrtCd;
	}
	
	/**
	 * Column Info
	 * @return dpcsWrkGrpCd
	 */
	public String getDpcsWrkGrpCd() {
		return this.dpcsWrkGrpCd;
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
	 * @param dpcsWrkGrpCd2
	 */
	public void setDpcsWrkGrpCd2(String dpcsWrkGrpCd2) {
		this.dpcsWrkGrpCd2 = dpcsWrkGrpCd2;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkSvrCd
	 */
	public void setDpcsWrkSvrCd(String dpcsWrkSvrCd) {
		this.dpcsWrkSvrCd = dpcsWrkSvrCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkPrtCd
	 */
	public void setDpcsWrkPrtCd(String dpcsWrkPrtCd) {
		this.dpcsWrkPrtCd = dpcsWrkPrtCd;
	}
	
	/**
	 * Column Info
	 * @param dpcsWrkGrpCd
	 */
	public void setDpcsWrkGrpCd(String dpcsWrkGrpCd) {
		this.dpcsWrkGrpCd = dpcsWrkGrpCd;
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
		setDpcsWrkGrpCd2(JSPUtil.getParameter(request, "dpcs_wrk_grp_cd_2", ""));
		setDpcsWrkSvrCd(JSPUtil.getParameter(request, "dpcs_wrk_svr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setDpcsWrkPrtCd(JSPUtil.getParameter(request, "dpcs_wrk_prt_cd", ""));
		setDpcsWrkGrpCd(JSPUtil.getParameter(request, "dpcs_wrk_grp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUserGroupIdVO[]
	 */
	public SearchUserGroupIdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUserGroupIdVO[]
	 */
	public SearchUserGroupIdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUserGroupIdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpcsWrkGrpCd2 = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_cd_2", length));
			String[] dpcsWrkSvrCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_svr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] dpcsWrkPrtCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_prt_cd", length));
			String[] dpcsWrkGrpCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_wrk_grp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUserGroupIdVO();
				if (dpcsWrkGrpCd2[i] != null)
					model.setDpcsWrkGrpCd2(dpcsWrkGrpCd2[i]);
				if (dpcsWrkSvrCd[i] != null)
					model.setDpcsWrkSvrCd(dpcsWrkSvrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (dpcsWrkPrtCd[i] != null)
					model.setDpcsWrkPrtCd(dpcsWrkPrtCd[i]);
				if (dpcsWrkGrpCd[i] != null)
					model.setDpcsWrkGrpCd(dpcsWrkGrpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUserGroupIdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUserGroupIdVO[]
	 */
	public SearchUserGroupIdVO[] getSearchUserGroupIdVOs(){
		SearchUserGroupIdVO[] vos = (SearchUserGroupIdVO[])models.toArray(new SearchUserGroupIdVO[models.size()]);
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
		this.dpcsWrkGrpCd2 = this.dpcsWrkGrpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkSvrCd = this.dpcsWrkSvrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkPrtCd = this.dpcsWrkPrtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsWrkGrpCd = this.dpcsWrkGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
