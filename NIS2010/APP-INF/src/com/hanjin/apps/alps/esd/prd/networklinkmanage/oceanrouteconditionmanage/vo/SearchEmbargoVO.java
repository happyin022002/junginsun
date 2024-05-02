/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchEmbargoVO.java
*@FileTitle : SearchEmbargoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.18 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEmbargoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEmbargoVO> models = new ArrayList<SearchEmbargoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fmCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mbgoRmk = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String toCntCd = null;
	/* Column Info */
	private String iTo = null;
	/* Column Info */
	private String iFrom = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEmbargoVO() {}

	public SearchEmbargoVO(String ibflag, String pagerows, String fmCntCd, String toCntCd, String creDt, String updUsrId, String updDt, String mbgoRmk, String iFrom, String iTo, String creOfcCd, String creUsrId) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.fmCntCd = fmCntCd;
		this.ibflag = ibflag;
		this.mbgoRmk = mbgoRmk;
		this.creOfcCd = creOfcCd;
		this.creDt = creDt;
		this.toCntCd = toCntCd;
		this.iTo = iTo;
		this.iFrom = iFrom;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fm_cnt_cd", getFmCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mbgo_rmk", getMbgoRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_cnt_cd", getToCntCd());
		this.hashColumns.put("i_to", getITo());
		this.hashColumns.put("i_from", getIFrom());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fm_cnt_cd", "fmCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mbgo_rmk", "mbgoRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_cnt_cd", "toCntCd");
		this.hashFields.put("i_to", "iTo");
		this.hashFields.put("i_from", "iFrom");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fmCntCd
	 */
	public String getFmCntCd() {
		return this.fmCntCd;
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
	 * @return mbgoRmk
	 */
	public String getMbgoRmk() {
		return this.mbgoRmk;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return toCntCd
	 */
	public String getToCntCd() {
		return this.toCntCd;
	}
	
	/**
	 * Column Info
	 * @return iTo
	 */
	public String getITo() {
		return this.iTo;
	}
	
	/**
	 * Column Info
	 * @return iFrom
	 */
	public String getIFrom() {
		return this.iFrom;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param fmCntCd
	 */
	public void setFmCntCd(String fmCntCd) {
		this.fmCntCd = fmCntCd;
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
	 * @param mbgoRmk
	 */
	public void setMbgoRmk(String mbgoRmk) {
		this.mbgoRmk = mbgoRmk;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param toCntCd
	 */
	public void setToCntCd(String toCntCd) {
		this.toCntCd = toCntCd;
	}
	
	/**
	 * Column Info
	 * @param iTo
	 */
	public void setITo(String iTo) {
		this.iTo = iTo;
	}
	
	/**
	 * Column Info
	 * @param iFrom
	 */
	public void setIFrom(String iFrom) {
		this.iFrom = iFrom;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFmCntCd(JSPUtil.getParameter(request, "fm_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMbgoRmk(JSPUtil.getParameter(request, "mbgo_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setToCntCd(JSPUtil.getParameter(request, "to_cnt_cd", ""));
		setITo(JSPUtil.getParameter(request, "i_to", ""));
		setIFrom(JSPUtil.getParameter(request, "i_from", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEmbargoVO[]
	 */
	public SearchEmbargoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEmbargoVO[]
	 */
	public SearchEmbargoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEmbargoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fmCntCd = (JSPUtil.getParameter(request, prefix	+ "fm_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mbgoRmk = (JSPUtil.getParameter(request, prefix	+ "mbgo_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] toCntCd = (JSPUtil.getParameter(request, prefix	+ "to_cnt_cd", length));
			String[] iTo = (JSPUtil.getParameter(request, prefix	+ "i_to", length));
			String[] iFrom = (JSPUtil.getParameter(request, prefix	+ "i_from", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEmbargoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fmCntCd[i] != null)
					model.setFmCntCd(fmCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mbgoRmk[i] != null)
					model.setMbgoRmk(mbgoRmk[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (toCntCd[i] != null)
					model.setToCntCd(toCntCd[i]);
				if (iTo[i] != null)
					model.setITo(iTo[i]);
				if (iFrom[i] != null)
					model.setIFrom(iFrom[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEmbargoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEmbargoVO[]
	 */
	public SearchEmbargoVO[] getSearchEmbargoVOs(){
		SearchEmbargoVO[] vos = (SearchEmbargoVO[])models.toArray(new SearchEmbargoVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCntCd = this.fmCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mbgoRmk = this.mbgoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCntCd = this.toCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iTo = this.iTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iFrom = this.iFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
