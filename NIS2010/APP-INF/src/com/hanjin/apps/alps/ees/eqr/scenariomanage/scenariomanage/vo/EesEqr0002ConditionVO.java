/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : 0002ConditionVO.java
*@FileTitle : 0002ConditionVO
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

public class EesEqr0002ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0002ConditionVO> models = new ArrayList<EesEqr0002ConditionVO>();
	
	/* Column Info */
	private String scnrsyear = null;
	/* Column Info */
	private String scnreyear = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String scnrseq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scnrweek = null;
	/* Column Info */
	private String scnrsweek = null;
	/* Column Info */
	private String scnreweek = null;
	/* Column Info */
	private String yyyy = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String scnrid = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0002ConditionVO() {}

	public EesEqr0002ConditionVO(String ibflag, String pagerows, String scnrsyear, String scnrsweek, String scnreyear, String scnreweek, String yyyy, String scnrweek, String scnrseq, String creUsrId, String status, String scnrid) {
		this.scnrsyear = scnrsyear;
		this.scnreyear = scnreyear;
		this.creUsrId = creUsrId;
		this.scnrseq = scnrseq;
		this.ibflag = ibflag;
		this.scnrweek = scnrweek;
		this.scnrsweek = scnrsweek;
		this.scnreweek = scnreweek;
		this.yyyy = yyyy;
		this.status = status;
		this.scnrid = scnrid;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scnrsyear", getScnrsyear());
		this.hashColumns.put("scnreyear", getScnreyear());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("scnrseq", getScnrseq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("scnrweek", getScnrweek());
		this.hashColumns.put("scnrsweek", getScnrsweek());
		this.hashColumns.put("scnreweek", getScnreweek());
		this.hashColumns.put("yyyy", getYyyy());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("scnrid", getScnrid());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scnrsyear", "scnrsyear");
		this.hashFields.put("scnreyear", "scnreyear");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("scnrseq", "scnrseq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scnrweek", "scnrweek");
		this.hashFields.put("scnrsweek", "scnrsweek");
		this.hashFields.put("scnreweek", "scnreweek");
		this.hashFields.put("yyyy", "yyyy");
		this.hashFields.put("status", "status");
		this.hashFields.put("scnrid", "scnrid");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scnrsyear
	 */
	public String getScnrsyear() {
		return this.scnrsyear;
	}
	
	/**
	 * Column Info
	 * @return scnreyear
	 */
	public String getScnreyear() {
		return this.scnreyear;
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
	 * @return scnrseq
	 */
	public String getScnrseq() {
		return this.scnrseq;
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
	 * @return scnrweek
	 */
	public String getScnrweek() {
		return this.scnrweek;
	}
	
	/**
	 * Column Info
	 * @return scnrsweek
	 */
	public String getScnrsweek() {
		return this.scnrsweek;
	}
	
	/**
	 * Column Info
	 * @return scnreweek
	 */
	public String getScnreweek() {
		return this.scnreweek;
	}
	
	/**
	 * Column Info
	 * @return yyyy
	 */
	public String getYyyy() {
		return this.yyyy;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return scnrid
	 */
	public String getScnrid() {
		return this.scnrid;
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
	 * @param scnrsyear
	 */
	public void setScnrsyear(String scnrsyear) {
		this.scnrsyear = scnrsyear;
	}
	
	/**
	 * Column Info
	 * @param scnreyear
	 */
	public void setScnreyear(String scnreyear) {
		this.scnreyear = scnreyear;
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
	 * @param scnrseq
	 */
	public void setScnrseq(String scnrseq) {
		this.scnrseq = scnrseq;
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
	 * @param scnrweek
	 */
	public void setScnrweek(String scnrweek) {
		this.scnrweek = scnrweek;
	}
	
	/**
	 * Column Info
	 * @param scnrsweek
	 */
	public void setScnrsweek(String scnrsweek) {
		this.scnrsweek = scnrsweek;
	}
	
	/**
	 * Column Info
	 * @param scnreweek
	 */
	public void setScnreweek(String scnreweek) {
		this.scnreweek = scnreweek;
	}
	
	/**
	 * Column Info
	 * @param yyyy
	 */
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param scnrid
	 */
	public void setScnrid(String scnrid) {
		this.scnrid = scnrid;
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
		setScnrsyear(JSPUtil.getParameter(request, "scnrSYear", ""));
		setScnreyear(JSPUtil.getParameter(request, "scnrEYear", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setScnrseq(JSPUtil.getParameter(request, "scnrSeq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScnrweek(JSPUtil.getParameter(request, "scnrWeek", ""));
		setScnrsweek(JSPUtil.getParameter(request, "scnrSWeek", ""));
		setScnreweek(JSPUtil.getParameter(request, "scnrEWeek", ""));
		setYyyy(JSPUtil.getParameter(request, "yyyy", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setScnrid(JSPUtil.getParameter(request, "scnr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return 0002ConditionVO[]
	 */
	public EesEqr0002ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return 0002ConditionVO[]
	 */
	public EesEqr0002ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0002ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scnrsyear = (JSPUtil.getParameter(request, prefix	+ "scnrSYear", length));
			String[] scnreyear = (JSPUtil.getParameter(request, prefix	+ "scnrEYear", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] scnrseq = (JSPUtil.getParameter(request, prefix	+ "scnrSeq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scnrweek = (JSPUtil.getParameter(request, prefix	+ "scnrWeek", length));
			String[] scnrsweek = (JSPUtil.getParameter(request, prefix	+ "scnrSWeek", length));
			String[] scnreweek = (JSPUtil.getParameter(request, prefix	+ "scnrEWeek", length));
			String[] yyyy = (JSPUtil.getParameter(request, prefix	+ "yyyy", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] scnrid = (JSPUtil.getParameter(request, prefix	+ "scnrid", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0002ConditionVO();
				if (scnrsyear[i] != null)
					model.setScnrsyear(scnrsyear[i]);
				if (scnreyear[i] != null)
					model.setScnreyear(scnreyear[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (scnrseq[i] != null)
					model.setScnrseq(scnrseq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scnrweek[i] != null)
					model.setScnrweek(scnrweek[i]);
				if (scnrsweek[i] != null)
					model.setScnrsweek(scnrsweek[i]);
				if (scnreweek[i] != null)
					model.setScnreweek(scnreweek[i]);
				if (yyyy[i] != null)
					model.setYyyy(yyyy[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (scnrid[i] != null)
					model.setScnrid(scnrid[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0002ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return 0002ConditionVO[]
	 */
	public EesEqr0002ConditionVO[] getEesEqr0002ConditionVOs(){
		EesEqr0002ConditionVO[] vos = (EesEqr0002ConditionVO[])models.toArray(new EesEqr0002ConditionVO[models.size()]);
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
		this.scnrsyear = this.scnrsyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnreyear = this.scnreyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrseq = this.scnrseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrweek = this.scnrweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrsweek = this.scnrsweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnreweek = this.scnreweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyy = this.yyyy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrid = this.scnrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
