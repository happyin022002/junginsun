/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOffhireSelectionListVO.java
*@FileTitle : SearchOffhireSelectionListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.12 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0078HTMLAction
 */

public class SearchOffhireSelectionListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOffhireSelectionListVO> models = new ArrayList<SearchOffhireSelectionListVO>();
	
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String duration = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String fletOffhRsnCd = null;
	/* Column Info */
	private String fletOffhRsnNm = null;
	/* Column Info */
	private String fromTime = null;
	/* Column Info */
	private String bunkerVvd = null;
	/* Column Info */
	private String toTime = null;
	/* Column Info */
	private String invUsdDys = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String expDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public SearchOffhireSelectionListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String duration, String fletOffhRsnCd, String fletOffhRsnNm, String invSeq, String bunkerVvd, String effDt, String expDt, String fromTime, String toTime, String invUsdDys
	 * @return 
	 */
	public SearchOffhireSelectionListVO(String ibflag, String pagerows, String duration, String fletOffhRsnCd, String fletOffhRsnNm, String invSeq, String bunkerVvd, String effDt, String expDt, String fromTime, String toTime, String invUsdDys) {
		this.effDt = effDt;
		this.duration = duration;
		this.ibflag = ibflag;
		this.fletOffhRsnCd = fletOffhRsnCd;
		this.fletOffhRsnNm = fletOffhRsnNm;
		this.fromTime = fromTime;
		this.bunkerVvd = bunkerVvd;
		this.toTime = toTime;
		this.invUsdDys = invUsdDys;
		this.invSeq = invSeq;
		this.expDt = expDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flet_offh_rsn_cd", getFletOffhRsnCd());
		this.hashColumns.put("flet_offh_rsn_nm", getFletOffhRsnNm());
		this.hashColumns.put("from_time", getFromTime());
		this.hashColumns.put("bunker_vvd", getBunkerVvd());
		this.hashColumns.put("to_time", getToTime());
		this.hashColumns.put("inv_usd_dys", getInvUsdDys());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flet_offh_rsn_cd", "fletOffhRsnCd");
		this.hashFields.put("flet_offh_rsn_nm", "fletOffhRsnNm");
		this.hashFields.put("from_time", "fromTime");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("to_time", "toTime");
		this.hashFields.put("inv_usd_dys", "invUsdDys");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getEffDt() {
		return this.effDt;
	}
	public String getDuration() {
		return this.duration;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFletOffhRsnCd() {
		return this.fletOffhRsnCd;
	}
	public String getFletOffhRsnNm() {
		return this.fletOffhRsnNm;
	}
	public String getFromTime() {
		return this.fromTime;
	}
	public String getBunkerVvd() {
		return this.bunkerVvd;
	}
	public String getToTime() {
		return this.toTime;
	}
	public String getInvUsdDys() {
		return this.invUsdDys;
	}
	public String getInvSeq() {
		return this.invSeq;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setDuration(String duration) {
		this.duration = duration;
		//this.duration=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFletOffhRsnCd(String fletOffhRsnCd) {
		this.fletOffhRsnCd = fletOffhRsnCd;
		//this.fletOffhRsnCd=true;
	}
	public void setFletOffhRsnNm(String fletOffhRsnNm) {
		this.fletOffhRsnNm = fletOffhRsnNm;
		//this.fletOffhRsnNm=true;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
		//this.fromTime=true;
	}
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
		//this.bunkerVvd=true;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
		//this.toTime=true;
	}
	public void setInvUsdDys(String invUsdDys) {
		this.invUsdDys = invUsdDys;
		//this.invUsdDys=true;
	}
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
		//this.invSeq=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setDuration(JSPUtil.getParameter(request, "duration", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFletOffhRsnCd(JSPUtil.getParameter(request, "flet_offh_rsn_cd", ""));
		setFletOffhRsnNm(JSPUtil.getParameter(request, "flet_offh_rsn_nm", ""));
		setFromTime(JSPUtil.getParameter(request, "from_time", ""));
		setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
		setToTime(JSPUtil.getParameter(request, "to_time", ""));
		setInvUsdDys(JSPUtil.getParameter(request, "inv_usd_dys", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SearchOffhireSelectionListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SearchOffhireSelectionListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOffhireSelectionListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fletOffhRsnCd = (JSPUtil.getParameter(request, prefix	+ "flet_offh_rsn_cd".trim(), length));
			String[] fletOffhRsnNm = (JSPUtil.getParameter(request, prefix	+ "flet_offh_rsn_nm".trim(), length));
			String[] fromTime = (JSPUtil.getParameter(request, prefix	+ "from_time".trim(), length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd".trim(), length));
			String[] toTime = (JSPUtil.getParameter(request, prefix	+ "to_time".trim(), length));
			String[] invUsdDys = (JSPUtil.getParameter(request, prefix	+ "inv_usd_dys".trim(), length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOffhireSelectionListVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fletOffhRsnCd[i] != null)
					model.setFletOffhRsnCd(fletOffhRsnCd[i]);
				if (fletOffhRsnNm[i] != null)
					model.setFletOffhRsnNm(fletOffhRsnNm[i]);
				if (fromTime[i] != null)
					model.setFromTime(fromTime[i]);
				if (bunkerVvd[i] != null)
					model.setBunkerVvd(bunkerVvd[i]);
				if (toTime[i] != null)
					model.setToTime(toTime[i]);
				if (invUsdDys[i] != null)
					model.setInvUsdDys(invUsdDys[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSearchOffhireSelectionListVOs();
	}

	public SearchOffhireSelectionListVO[] getSearchOffhireSelectionListVOs(){
		SearchOffhireSelectionListVO[] vos = (SearchOffhireSelectionListVO[])models.toArray(new SearchOffhireSelectionListVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOffhRsnCd = this.fletOffhRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOffhRsnNm = this.fletOffhRsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromTime = this.fromTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd = this.bunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTime = this.toTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdDys = this.invUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
