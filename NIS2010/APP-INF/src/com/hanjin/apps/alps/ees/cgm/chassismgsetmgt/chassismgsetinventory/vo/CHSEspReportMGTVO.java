/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSEspReportMGTVO.java
*@FileTitle : CHSEspReportMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.09.18 조재성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 조재성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSEspReportMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSEspReportMGTVO> models = new ArrayList<CHSEspReportMGTVO>();
	
	/* Column Info */
	private String t20 = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String t45 = null;
	/* Column Info */
	private String t40 = null;
	/* Column Info */
	private String backEndJobKey = null;
	/* Column Info */
	private String turnTimeInqFmDys = null;
	/* Column Info */
	private String mdiff = null;
	/* Column Info */
	private String troughputInqFmDys = null;
	/* Column Info */
	private String troughputInqToDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String subj = null;
	/* Column Info */
	private String turnTimeInqToDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String crntSccCd = null;
	/* Column Info */
	private String r5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSEspReportMGTVO() {}

	public CHSEspReportMGTVO(String ibflag, String pagerows, String crntSccCd, String troughputInqFmDys, String troughputInqToDys, String turnTimeInqFmDys, String turnTimeInqToDys, String gubun, String subj, String t20, String t40, String t45, String r5, String userId, String backEndJobKey, String mdiff) {
		this.t20 = t20;
		this.gubun = gubun;
		this.t45 = t45;
		this.t40 = t40;
		this.backEndJobKey = backEndJobKey;
		this.turnTimeInqFmDys = turnTimeInqFmDys;
		this.mdiff = mdiff;
		this.troughputInqFmDys = troughputInqFmDys;
		this.troughputInqToDys = troughputInqToDys;
		this.pagerows = pagerows;
		this.subj = subj;
		this.turnTimeInqToDys = turnTimeInqToDys;
		this.ibflag = ibflag;
		this.userId = userId;
		this.crntSccCd = crntSccCd;
		this.r5 = r5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t20", getT20());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("t45", getT45());
		this.hashColumns.put("t40", getT40());
		this.hashColumns.put("back_end_job_key", getBackEndJobKey());
		this.hashColumns.put("turn_time_inq_fm_dys", getTurnTimeInqFmDys());
		this.hashColumns.put("mdiff", getMdiff());
		this.hashColumns.put("troughput_inq_fm_dys", getTroughputInqFmDys());
		this.hashColumns.put("troughput_inq_to_dys", getTroughputInqToDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("subj", getSubj());
		this.hashColumns.put("turn_time_inq_to_dys", getTurnTimeInqToDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("crnt_scc_cd", getCrntSccCd());
		this.hashColumns.put("r5", getR5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t20", "t20");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("t45", "t45");
		this.hashFields.put("t40", "t40");
		this.hashFields.put("back_end_job_key", "backEndJobKey");
		this.hashFields.put("turn_time_inq_fm_dys", "turnTimeInqFmDys");
		this.hashFields.put("mdiff", "mdiff");
		this.hashFields.put("troughput_inq_fm_dys", "troughputInqFmDys");
		this.hashFields.put("troughput_inq_to_dys", "troughputInqToDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("subj", "subj");
		this.hashFields.put("turn_time_inq_to_dys", "turnTimeInqToDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("crnt_scc_cd", "crntSccCd");
		this.hashFields.put("r5", "r5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return t20
	 */
	public String getT20() {
		return this.t20;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return t45
	 */
	public String getT45() {
		return this.t45;
	}
	
	/**
	 * Column Info
	 * @return t40
	 */
	public String getT40() {
		return this.t40;
	}
	
	/**
	 * Column Info
	 * @return backEndJobKey
	 */
	public String getBackEndJobKey() {
		return this.backEndJobKey;
	}
	
	/**
	 * Column Info
	 * @return turnTimeInqFmDys
	 */
	public String getTurnTimeInqFmDys() {
		return this.turnTimeInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return mdiff
	 */
	public String getMdiff() {
		return this.mdiff;
	}
	
	/**
	 * Column Info
	 * @return troughputInqFmDys
	 */
	public String getTroughputInqFmDys() {
		return this.troughputInqFmDys;
	}
	
	/**
	 * Column Info
	 * @return troughputInqToDys
	 */
	public String getTroughputInqToDys() {
		return this.troughputInqToDys;
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
	 * @return subj
	 */
	public String getSubj() {
		return this.subj;
	}
	
	/**
	 * Column Info
	 * @return turnTimeInqToDys
	 */
	public String getTurnTimeInqToDys() {
		return this.turnTimeInqToDys;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return crntSccCd
	 */
	public String getCrntSccCd() {
		return this.crntSccCd;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	

	/**
	 * Column Info
	 * @param t20
	 */
	public void setT20(String t20) {
		this.t20 = t20;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param t45
	 */
	public void setT45(String t45) {
		this.t45 = t45;
	}
	
	/**
	 * Column Info
	 * @param t40
	 */
	public void setT40(String t40) {
		this.t40 = t40;
	}
	
	/**
	 * Column Info
	 * @param backEndJobKey
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}
	
	/**
	 * Column Info
	 * @param turnTimeInqFmDys
	 */
	public void setTurnTimeInqFmDys(String turnTimeInqFmDys) {
		this.turnTimeInqFmDys = turnTimeInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param mdiff
	 */
	public void setMdiff(String mdiff) {
		this.mdiff = mdiff;
	}
	
	/**
	 * Column Info
	 * @param troughputInqFmDys
	 */
	public void setTroughputInqFmDys(String troughputInqFmDys) {
		this.troughputInqFmDys = troughputInqFmDys;
	}
	
	/**
	 * Column Info
	 * @param troughputInqToDys
	 */
	public void setTroughputInqToDys(String troughputInqToDys) {
		this.troughputInqToDys = troughputInqToDys;
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
	 * @param subj
	 */
	public void setSubj(String subj) {
		this.subj = subj;
	}
	
	/**
	 * Column Info
	 * @param turnTimeInqToDys
	 */
	public void setTurnTimeInqToDys(String turnTimeInqToDys) {
		this.turnTimeInqToDys = turnTimeInqToDys;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param crntSccCd
	 */
	public void setCrntSccCd(String crntSccCd) {
		this.crntSccCd = crntSccCd;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setT20(JSPUtil.getParameter(request, "t20", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setT45(JSPUtil.getParameter(request, "t45", ""));
		setT40(JSPUtil.getParameter(request, "t40", ""));
		setBackEndJobKey(JSPUtil.getParameter(request, "back_end_job_key", ""));
		setTurnTimeInqFmDys(JSPUtil.getParameter(request, "turn_time_inq_fm_dys", ""));
		setMdiff(JSPUtil.getParameter(request, "mdiff", ""));
		setTroughputInqFmDys(JSPUtil.getParameter(request, "troughput_inq_fm_dys", ""));
		setTroughputInqToDys(JSPUtil.getParameter(request, "troughput_inq_to_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubj(JSPUtil.getParameter(request, "subj", ""));
		setTurnTimeInqToDys(JSPUtil.getParameter(request, "turn_time_inq_to_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCrntSccCd(JSPUtil.getParameter(request, "crnt_scc_cd", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSEspReportMGTVO[]
	 */
	public CHSEspReportMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSEspReportMGTVO[]
	 */
	public CHSEspReportMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSEspReportMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] t20 = (JSPUtil.getParameter(request, prefix	+ "t20", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] t45 = (JSPUtil.getParameter(request, prefix	+ "t45", length));
			String[] t40 = (JSPUtil.getParameter(request, prefix	+ "t40", length));
			String[] backEndJobKey = (JSPUtil.getParameter(request, prefix	+ "back_end_job_key", length));
			String[] turnTimeInqFmDys = (JSPUtil.getParameter(request, prefix	+ "turn_time_inq_fm_dys", length));
			String[] mdiff = (JSPUtil.getParameter(request, prefix	+ "mdiff", length));
			String[] troughputInqFmDys = (JSPUtil.getParameter(request, prefix	+ "troughput_inq_fm_dys", length));
			String[] troughputInqToDys = (JSPUtil.getParameter(request, prefix	+ "troughput_inq_to_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] subj = (JSPUtil.getParameter(request, prefix	+ "subj", length));
			String[] turnTimeInqToDys = (JSPUtil.getParameter(request, prefix	+ "turn_time_inq_to_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] crntSccCd = (JSPUtil.getParameter(request, prefix	+ "crnt_scc_cd", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSEspReportMGTVO();
				if (t20[i] != null)
					model.setT20(t20[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (t45[i] != null)
					model.setT45(t45[i]);
				if (t40[i] != null)
					model.setT40(t40[i]);
				if (backEndJobKey[i] != null)
					model.setBackEndJobKey(backEndJobKey[i]);
				if (turnTimeInqFmDys[i] != null)
					model.setTurnTimeInqFmDys(turnTimeInqFmDys[i]);
				if (mdiff[i] != null)
					model.setMdiff(mdiff[i]);
				if (troughputInqFmDys[i] != null)
					model.setTroughputInqFmDys(troughputInqFmDys[i]);
				if (troughputInqToDys[i] != null)
					model.setTroughputInqToDys(troughputInqToDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (subj[i] != null)
					model.setSubj(subj[i]);
				if (turnTimeInqToDys[i] != null)
					model.setTurnTimeInqToDys(turnTimeInqToDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (crntSccCd[i] != null)
					model.setCrntSccCd(crntSccCd[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSEspReportMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSEspReportMGTVO[]
	 */
	public CHSEspReportMGTVO[] getCHSEspReportMGTVOs(){
		CHSEspReportMGTVO[] vos = (CHSEspReportMGTVO[])models.toArray(new CHSEspReportMGTVO[models.size()]);
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
		this.t20 = this.t20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t45 = this.t45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t40 = this.t40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.backEndJobKey = this.backEndJobKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnTimeInqFmDys = this.turnTimeInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdiff = this.mdiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troughputInqFmDys = this.troughputInqFmDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troughputInqToDys = this.troughputInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subj = this.subj .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnTimeInqToDys = this.turnTimeInqToDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSccCd = this.crntSccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
