/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchDVFactorListDataVO.java
*@FileTitle : searchDVFactorListDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.26 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrEqDpcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrEqDpcVO> models = new ArrayList<CustomMnrEqDpcVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cdId = null;
	/* Column Info */
	private String eqDpcYr = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqMtrlCd = null;
	/* Column Info */
	private String cdDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqDpcRt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eqInitPrc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String maxDpcRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrEqDpcVO() {}

	/**
	 * CustomMnrEqDpcVO 객체 생성
	 */
	public CustomMnrEqDpcVO(String ibflag, String pagerows, String eqDpcYr, String cdId, String eqKndCd, String currCd, String eqInitPrc, String eqDpcRt, String eqMtrlCd, String creUsrId, String creDt, String updUsrId, String updDt, String cdDesc, String maxDpcRto) {
		this.updDt = updDt;
		this.currCd = currCd;
		this.creDt = creDt;
		this.cdId = cdId;
		this.eqDpcYr = eqDpcYr;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.eqMtrlCd = eqMtrlCd;
		this.cdDesc = cdDesc;
		this.ibflag = ibflag;
		this.eqDpcRt = eqDpcRt;
		this.creUsrId = creUsrId;
		this.eqInitPrc = eqInitPrc;
		this.updUsrId = updUsrId;
		this.maxDpcRto = maxDpcRto;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cd_id", getCdId());
		this.hashColumns.put("eq_dpc_yr", getEqDpcYr());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_mtrl_cd", getEqMtrlCd());
		this.hashColumns.put("cd_desc", getCdDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_dpc_rt", getEqDpcRt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eq_init_prc", getEqInitPrc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("max_dpc_rto", getMaxDpcRto());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cd_id", "cdId");
		this.hashFields.put("eq_dpc_yr", "eqDpcYr");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_mtrl_cd", "eqMtrlCd");
		this.hashFields.put("cd_desc", "cdDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_dpc_rt", "eqDpcRt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_init_prc", "eqInitPrc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("max_dpc_rto", "maxDpcRto");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return cdId
	 */
	public String getCdId() {
		return this.cdId;
	}
	
	/**
	 * Column Info
	 * @return eqDpcYr
	 */
	public String getEqDpcYr() {
		return this.eqDpcYr;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return eqMtrlCd
	 */
	public String getEqMtrlCd() {
		return this.eqMtrlCd;
	}
	
	/**
	 * Column Info
	 * @return cdDesc
	 */
	public String getCdDesc() {
		return this.cdDesc;
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
	 * @return eqDpcRt
	 */
	public String getEqDpcRt() {
		return this.eqDpcRt;
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
	 * @return eqInitPrc
	 */
	public String getEqInitPrc() {
		return this.eqInitPrc;
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
	 * @return maxDpcRto
	 */
	public String getMaxDpcRto() {
		return this.maxDpcRto;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param cdId
	 */
	public void setCdId(String cdId) {
		this.cdId = cdId;
	}
	
	/**
	 * Column Info
	 * @param eqDpcYr
	 */
	public void setEqDpcYr(String eqDpcYr) {
		this.eqDpcYr = eqDpcYr;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param eqMtrlCd
	 */
	public void setEqMtrlCd(String eqMtrlCd) {
		this.eqMtrlCd = eqMtrlCd;
	}
	
	/**
	 * Column Info
	 * @param cdDesc
	 */
	public void setCdDesc(String cdDesc) {
		this.cdDesc = cdDesc;
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
	 * @param eqDpcRt
	 */
	public void setEqDpcRt(String eqDpcRt) {
		this.eqDpcRt = eqDpcRt;
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
	 * @param eqInitPrc
	 */
	public void setEqInitPrc(String eqInitPrc) {
		this.eqInitPrc = eqInitPrc;
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
	 * @param maxDpcRto
	 */
	public void setMaxDpcRto(String maxDpcRto) {
		this.maxDpcRto = maxDpcRto;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCdId(JSPUtil.getParameter(request, "cd_id", ""));
		setEqDpcYr(JSPUtil.getParameter(request, "eq_dpc_yr", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqMtrlCd(JSPUtil.getParameter(request, "eq_mtrl_cd", ""));
		setCdDesc(JSPUtil.getParameter(request, "cd_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqDpcRt(JSPUtil.getParameter(request, "eq_dpc_rt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEqInitPrc(JSPUtil.getParameter(request, "eq_init_prc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMaxDpcRto(JSPUtil.getParameter(request, "max_dpc_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchDVFactorListDataVO[]
	 */
	public CustomMnrEqDpcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchDVFactorListDataVO[]
	 */
	public CustomMnrEqDpcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrEqDpcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] cdId = (JSPUtil.getParameter(request, prefix	+ "cd_id".trim(), length));
			String[] eqDpcYr = (JSPUtil.getParameter(request, prefix	+ "eq_dpc_yr".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] eqMtrlCd = (JSPUtil.getParameter(request, prefix	+ "eq_mtrl_cd".trim(), length));
			String[] cdDesc = (JSPUtil.getParameter(request, prefix	+ "cd_desc".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eqDpcRt = (JSPUtil.getParameter(request, prefix	+ "eq_dpc_rt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] eqInitPrc = (JSPUtil.getParameter(request, prefix	+ "eq_init_prc".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] maxDpcRto = (JSPUtil.getParameter(request, prefix	+ "max_dpc_rto".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrEqDpcVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cdId[i] != null)
					model.setCdId(cdId[i]);
				if (eqDpcYr[i] != null)
					model.setEqDpcYr(eqDpcYr[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqMtrlCd[i] != null)
					model.setEqMtrlCd(eqMtrlCd[i]);
				if (cdDesc[i] != null)
					model.setCdDesc(cdDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqDpcRt[i] != null)
					model.setEqDpcRt(eqDpcRt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eqInitPrc[i] != null)
					model.setEqInitPrc(eqInitPrc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (maxDpcRto[i] != null)
					model.setMaxDpcRto(maxDpcRto[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchDVFactorListDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchDVFactorListDataVO[]
	 */
	public CustomMnrEqDpcVO[] getsearchDVFactorListDataVOs(){
		CustomMnrEqDpcVO[] vos = (CustomMnrEqDpcVO[])models.toArray(new CustomMnrEqDpcVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdId = this.cdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDpcYr = this.eqDpcYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMtrlCd = this.eqMtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdDesc = this.cdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDpcRt = this.eqDpcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqInitPrc = this.eqInitPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDpcRto = this.maxDpcRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
