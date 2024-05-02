/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GetCodeSelectVO.java
*@FileTitle : GetCodeSelectVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.07.26 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.common.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GetCodeSelectVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GetCodeSelectVO> models = new ArrayList<GetCodeSelectVO>();
	
	/* Column Info */
	private String teamCode = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String simNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rtnDate = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String prntOfcCd = null;
	/* Column Info */
	private String ofcLevel = null;
	/* Column Info */
	private String costYr = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String rt = null;
	/* Column Info */
	private String key = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GetCodeSelectVO() {}

	public GetCodeSelectVO(String ibflag, String pagerows, String code, String name, String key, String rtnDate, String etdDt, String ofcCd, String prntOfcCd, String simNo, String ofcLevel, String costYr, String costWk, String teamCode, String rt) {
		this.teamCode = teamCode;
		this.code = code;
		this.etdDt = etdDt;
		this.simNo = simNo;
		this.pagerows = pagerows;
		this.rtnDate = rtnDate;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.prntOfcCd = prntOfcCd;
		this.ofcLevel = ofcLevel;
		this.costYr = costYr;
		this.costWk = costWk;
		this.name = name;
		this.rt = rt;
		this.key = key;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("team_code", getTeamCode());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rtn_date", getRtnDate());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prnt_ofc_cd", getPrntOfcCd());
		this.hashColumns.put("ofc_level", getOfcLevel());
		this.hashColumns.put("cost_yr", getCostYr());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("rt", getRt());
		this.hashColumns.put("key", getKey());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("team_code", "teamCode");
		this.hashFields.put("code", "code");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rtn_date", "rtnDate");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prnt_ofc_cd", "prntOfcCd");
		this.hashFields.put("ofc_level", "ofcLevel");
		this.hashFields.put("cost_yr", "costYr");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("name", "name");
		this.hashFields.put("rt", "rt");
		this.hashFields.put("key", "key");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return teamCode
	 */
	public String getTeamCode() {
		return this.teamCode;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @return rtnDate
	 */
	public String getRtnDate() {
		return this.rtnDate;
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
	 * @return prntOfcCd
	 */
	public String getPrntOfcCd() {
		return this.prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcLevel
	 */
	public String getOfcLevel() {
		return this.ofcLevel;
	}
	
	/**
	 * Column Info
	 * @return costYr
	 */
	public String getCostYr() {
		return this.costYr;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return rt
	 */
	public String getRt() {
		return this.rt;
	}
	
	/**
	 * Column Info
	 * @return key
	 */
	public String getKey() {
		return this.key;
	}
	

	/**
	 * Column Info
	 * @param teamCode
	 */
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
	 * @param rtnDate
	 */
	public void setRtnDate(String rtnDate) {
		this.rtnDate = rtnDate;
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
	 * @param prntOfcCd
	 */
	public void setPrntOfcCd(String prntOfcCd) {
		this.prntOfcCd = prntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcLevel
	 */
	public void setOfcLevel(String ofcLevel) {
		this.ofcLevel = ofcLevel;
	}
	
	/**
	 * Column Info
	 * @param costYr
	 */
	public void setCostYr(String costYr) {
		this.costYr = costYr;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param rt
	 */
	public void setRt(String rt) {
		this.rt = rt;
	}
	
	/**
	 * Column Info
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setTeamCode(JSPUtil.getParameter(request, prefix + "team_code", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRtnDate(JSPUtil.getParameter(request, prefix + "rtn_date", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPrntOfcCd(JSPUtil.getParameter(request, prefix + "prnt_ofc_cd", ""));
		setOfcLevel(JSPUtil.getParameter(request, prefix + "ofc_level", ""));
		setCostYr(JSPUtil.getParameter(request, prefix + "cost_yr", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setRt(JSPUtil.getParameter(request, prefix + "rt", ""));
		setKey(JSPUtil.getParameter(request, prefix + "key", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetCodeSelectVO[]
	 */
	public GetCodeSelectVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GetCodeSelectVO[]
	 */
	public GetCodeSelectVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GetCodeSelectVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] teamCode = (JSPUtil.getParameter(request, prefix	+ "team_code", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rtnDate = (JSPUtil.getParameter(request, prefix	+ "rtn_date", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] prntOfcCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ofc_cd", length));
			String[] ofcLevel = (JSPUtil.getParameter(request, prefix	+ "ofc_level", length));
			String[] costYr = (JSPUtil.getParameter(request, prefix	+ "cost_yr", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] rt = (JSPUtil.getParameter(request, prefix	+ "rt", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			
			for (int i = 0; i < length; i++) {
				model = new GetCodeSelectVO();
				if (teamCode[i] != null)
					model.setTeamCode(teamCode[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rtnDate[i] != null)
					model.setRtnDate(rtnDate[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (prntOfcCd[i] != null)
					model.setPrntOfcCd(prntOfcCd[i]);
				if (ofcLevel[i] != null)
					model.setOfcLevel(ofcLevel[i]);
				if (costYr[i] != null)
					model.setCostYr(costYr[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (rt[i] != null)
					model.setRt(rt[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGetCodeSelectVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GetCodeSelectVO[]
	 */
	public GetCodeSelectVO[] getGetCodeSelectVOs(){
		GetCodeSelectVO[] vos = (GetCodeSelectVO[])models.toArray(new GetCodeSelectVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.teamCode = this.teamCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDate = this.rtnDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntOfcCd = this.prntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLevel = this.ofcLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYr = this.costYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rt = this.rt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
