/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VskPortNworkVO.java
*@FileTitle : VskPortNworkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.06.11 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.portinformationmgt.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VskPortNworkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VskPortNworkVO> models = new ArrayList<VskPortNworkVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String holEndDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String holRmk = null;
	/* Column Info */
	private String holSeq = null;
	/* Column Info */
	private String holStDt = null;
	/* Column Info */
	private String holNm = null;
	/* Column Info */
	private String tempLocCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VskPortNworkVO() {}

	public VskPortNworkVO(String ibflag, String pagerows, String locCd, String holSeq, String holStDt, String holEndDt, String holNm, String holRmk, String updUsrId, String updDt, String creUsrId, String tempLocCd) {
		this.updDt = updDt;
		this.holEndDt = holEndDt;
		this.creUsrId = creUsrId;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.holRmk = holRmk;
		this.holSeq = holSeq;
		this.holStDt = holStDt;
		this.holNm = holNm;
		this.tempLocCd = tempLocCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hol_end_dt", getHolEndDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hol_rmk", getHolRmk());
		this.hashColumns.put("hol_seq", getHolSeq());
		this.hashColumns.put("hol_st_dt", getHolStDt());
		this.hashColumns.put("hol_nm", getHolNm());
		this.hashColumns.put("temp_loc_cd", getTempLocCd());
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
		this.hashFields.put("hol_end_dt", "holEndDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hol_rmk", "holRmk");
		this.hashFields.put("hol_seq", "holSeq");
		this.hashFields.put("hol_st_dt", "holStDt");
		this.hashFields.put("hol_nm", "holNm");
		this.hashFields.put("temp_loc_cd", "tempLocCd");
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
	 * @return holEndDt
	 */
	public String getHolEndDt() {
		return this.holEndDt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return holRmk
	 */
	public String getHolRmk() {
		return this.holRmk;
	}
	
	/**
	 * Column Info
	 * @return holSeq
	 */
	public String getHolSeq() {
		return this.holSeq;
	}
	
	/**
	 * Column Info
	 * @return holStDt
	 */
	public String getHolStDt() {
		return this.holStDt;
	}
	
	/**
	 * Column Info
	 * @return holNm
	 */
	public String getHolNm() {
		return this.holNm;
	}
	
	/**
	 * Column Info
	 * @return tempLocCd
	 */
	public String getTempLocCd() {
		return this.tempLocCd;
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
	 * @param holEndDt
	 */
	public void setHolEndDt(String holEndDt) {
		this.holEndDt = holEndDt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param holRmk
	 */
	public void setHolRmk(String holRmk) {
		this.holRmk = holRmk;
	}
	
	/**
	 * Column Info
	 * @param holSeq
	 */
	public void setHolSeq(String holSeq) {
		this.holSeq = holSeq;
	}
	
	/**
	 * Column Info
	 * @param holStDt
	 */
	public void setHolStDt(String holStDt) {
		this.holStDt = holStDt;
	}
	
	/**
	 * Column Info
	 * @param holNm
	 */
	public void setHolNm(String holNm) {
		this.holNm = holNm;
	}
	
	/**
	 * Column Info
	 * @param tempLocCd
	 */
	public void setTempLocCd(String tempLocCd) {
		this.tempLocCd = tempLocCd;
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
		setHolEndDt(JSPUtil.getParameter(request, "hol_end_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHolRmk(JSPUtil.getParameter(request, "hol_rmk", ""));
		setHolSeq(JSPUtil.getParameter(request, "hol_seq", ""));
		setHolStDt(JSPUtil.getParameter(request, "hol_st_dt", ""));
		setHolNm(JSPUtil.getParameter(request, "hol_nm", ""));
		setTempLocCd(JSPUtil.getParameter(request, "temp_loc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPortNworkVO[]
	 */
	public VskPortNworkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPortNworkVO[]
	 */
	public VskPortNworkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPortNworkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] holEndDt = (JSPUtil.getParameter(request, prefix	+ "hol_end_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] holRmk = (JSPUtil.getParameter(request, prefix	+ "hol_rmk".trim(), length));
			String[] holSeq = (JSPUtil.getParameter(request, prefix	+ "hol_seq".trim(), length));
			String[] holStDt = (JSPUtil.getParameter(request, prefix	+ "hol_st_dt".trim(), length));
			String[] holNm = (JSPUtil.getParameter(request, prefix	+ "hol_nm".trim(), length));
			String[] tempLocCd = (JSPUtil.getParameter(request, prefix	+ "temp_loc_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPortNworkVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (holEndDt[i] != null)
					model.setHolEndDt(holEndDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (holRmk[i] != null)
					model.setHolRmk(holRmk[i]);
				if (holSeq[i] != null)
					model.setHolSeq(holSeq[i]);
				if (holStDt[i] != null)
					model.setHolStDt(holStDt[i]);
				if (holNm[i] != null)
					model.setHolNm(holNm[i]);
				if (tempLocCd[i] != null)
					model.setTempLocCd(tempLocCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPortNworkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPortNworkVO[]
	 */
	public VskPortNworkVO[] getVskPortNworkVOs(){
		VskPortNworkVO[] vos = (VskPortNworkVO[])models.toArray(new VskPortNworkVO[models.size()]);
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
		this.holEndDt = this.holEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holRmk = this.holRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holSeq = this.holSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holStDt = this.holStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holNm = this.holNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempLocCd = this.tempLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
