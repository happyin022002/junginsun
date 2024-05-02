/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtTariffTypeVO.java
*@FileTitle : DmtTariffTypeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.13 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

/**
 * @author 9011620
 *
 */
/**
 * @author 9011620
 *
 */
public class WeekendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WeekendVO> models = new ArrayList<WeekendVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String wkndTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Create User ID */
	private String creUsrId = null;
	/* Update User ID */
	private String updUsrId = null;
	/* Create Office ID */
	private String creOfcCd = null;
	/* Update Office ID */
	private String updOfcCd = null;
	/* Create Date */
	private String creDt = null;
	/* Update Date */
	private String updDt = null;
	
	
	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public WeekendVO() {}

	public WeekendVO(String ibflag, String pagerows, String cntCd, String wkndTpCd, String creUsrId, String updUsrId, String creOfcCd, String updOfcCd, String updDt,String creDt) {
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.wkndTpCd = wkndTpCd;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.creOfcCd = creOfcCd;
		this.updOfcCd = updOfcCd;
		this.creDt = creDt;
		this.updDt = updDt;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("wknd_tp_cd", getWkndTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("wknd_tp_cd", "wkndTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_dt", "updDt");
		return this.hashFields;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	

	/**
	 * Column Info
	 * @return
	 */
	public String getCntCd() {
		return cntCd;
	}


	/**
	 * Column Info 
	 * @return
	 */
	public String getWkndTpCd() {
		return wkndTpCd;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param wkndTpCd
	 */
	public void setWkndTpCd(String wkndTpCd) {
		this.wkndTpCd = wkndTpCd;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
		
	/**
	 * @return
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return
	 */
	public String getCreOfcCd() {
		return creOfcCd;
	}

	/**
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}

	/**
	 * @return
	 */
	public String getUpdOfcCd() {
		return updOfcCd;
	}

	/**
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
	}
	
	
	/**
	 * @return
	 */
	public String getCreDt() {
		return creDt;
	}

	/**
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * @return
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setWkndTpCd(JSPUtil.getParameter(request, "wknd_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return DmtTariffTypeVO[]
	 */
	public WeekendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtTariffTypeVO[]
	 */
	public WeekendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WeekendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag   = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntCd    = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] wkndTpCd = (JSPUtil.getParameter(request, prefix	+ "wknd_tp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd".trim(), length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd".trim(), length));
			String[] creDt    = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] updDt    = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new WeekendVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (wkndTpCd[i] != null)
					model.setWkndTpCd(wkndTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWeekendVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return WeekendVO[]
	 */
	public WeekendVO[] getWeekendVOs(){
		WeekendVO[] vos = (WeekendVO[])models.toArray(new WeekendVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wkndTpCd = this.wkndTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt	 = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt	 = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
