/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DeleteTableGlMonXchRtVO.java
*@FileTitle : DeleteTableGlMonXchRtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.22 최 선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.common.tableSync.jms.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DeleteGlMonXchRtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DeleteGlMonXchRtVO> models = new ArrayList<DeleteGlMonXchRtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctXchRtLvl = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String acctXchRtYrmon = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DeleteGlMonXchRtVO() {}

	public DeleteGlMonXchRtVO(String ibflag, String pagerows, String acctXchRtYrmon, String acctXchRtLvl, String currCd, String eaiEvntDt) {
		this.ibflag = ibflag;
		this.acctXchRtLvl = acctXchRtLvl;
		this.currCd = currCd;
		this.acctXchRtYrmon = acctXchRtYrmon;
		this.eaiEvntDt = eaiEvntDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_xch_rt_lvl", getAcctXchRtLvl());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("acct_xch_rt_yrmon", getAcctXchRtYrmon());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_xch_rt_lvl", "acctXchRtLvl");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("acct_xch_rt_yrmon", "acctXchRtYrmon");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return acctXchRtLvl
	 */
	public String getAcctXchRtLvl() {
		return this.acctXchRtLvl;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return acctXchRtYrmon
	 */
	public String getAcctXchRtYrmon() {
		return this.acctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param acctXchRtLvl
	 */
	public void setAcctXchRtLvl(String acctXchRtLvl) {
		this.acctXchRtLvl = acctXchRtLvl;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param acctXchRtYrmon
	 */
	public void setAcctXchRtYrmon(String acctXchRtYrmon) {
		this.acctXchRtYrmon = acctXchRtYrmon;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
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
		setAcctXchRtLvl(JSPUtil.getParameter(request, "acct_xch_rt_lvl", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setAcctXchRtYrmon(JSPUtil.getParameter(request, "acct_xch_rt_yrmon", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DeleteTableGlMonXchRtVO[]
	 */
	public DeleteGlMonXchRtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DeleteTableGlMonXchRtVO[]
	 */
	public DeleteGlMonXchRtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DeleteGlMonXchRtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctXchRtLvl = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_lvl", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] acctXchRtYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_xch_rt_yrmon", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DeleteGlMonXchRtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctXchRtLvl[i] != null)
					model.setAcctXchRtLvl(acctXchRtLvl[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (acctXchRtYrmon[i] != null)
					model.setAcctXchRtYrmon(acctXchRtYrmon[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDeleteTableGlMonXchRtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DeleteTableGlMonXchRtVO[]
	 */
	public DeleteGlMonXchRtVO[] getDeleteTableGlMonXchRtVOs(){
		DeleteGlMonXchRtVO[] vos = (DeleteGlMonXchRtVO[])models.toArray(new DeleteGlMonXchRtVO[models.size()]);
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
		this.acctXchRtLvl = this.acctXchRtLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtYrmon = this.acctXchRtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
