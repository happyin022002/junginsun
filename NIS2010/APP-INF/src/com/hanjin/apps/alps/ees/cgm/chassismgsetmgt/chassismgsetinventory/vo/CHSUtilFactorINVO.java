/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSUtilFactorINVO.java
*@FileTitle : CHSUtilFactorINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.08.11 조재성 
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

public class CHSUtilFactorINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSUtilFactorINVO> models = new ArrayList<CHSUtilFactorINVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String eg5PreKntQty = null;
	/* Column Info */
	private String cntrPsnStsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrDryRfIndCd = null;
	/* Column Info */
	private String chssUsgRto = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSUtilFactorINVO() {}

	public CHSUtilFactorINVO(String ibflag, String pagerows, String locCd, String ydCd, String cntrDryRfIndCd, String eg5PreKntQty, String cnmvStsCd, String cntrPsnStsCd, String chssUsgRto, String updUsrId, String creUsrId) {
		this.creUsrId = creUsrId;
		this.cnmvStsCd = cnmvStsCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.eg5PreKntQty = eg5PreKntQty;
		this.cntrPsnStsCd = cntrPsnStsCd;
		this.updUsrId = updUsrId;
		this.cntrDryRfIndCd = cntrDryRfIndCd;
		this.chssUsgRto = chssUsgRto;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("eg5_pre_knt_qty", getEg5PreKntQty());
		this.hashColumns.put("cntr_psn_sts_cd", getCntrPsnStsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_dry_rf_ind_cd", getCntrDryRfIndCd());
		this.hashColumns.put("chss_usg_rto", getChssUsgRto());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("eg5_pre_knt_qty", "eg5PreKntQty");
		this.hashFields.put("cntr_psn_sts_cd", "cntrPsnStsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_dry_rf_ind_cd", "cntrDryRfIndCd");
		this.hashFields.put("chss_usg_rto", "chssUsgRto");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return eg5PreKntQty
	 */
	public String getEg5PreKntQty() {
		return this.eg5PreKntQty;
	}
	
	/**
	 * Column Info
	 * @return cntrPsnStsCd
	 */
	public String getCntrPsnStsCd() {
		return this.cntrPsnStsCd;
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
	 * @return cntrDryRfIndCd
	 */
	public String getCntrDryRfIndCd() {
		return this.cntrDryRfIndCd;
	}
	
	/**
	 * Column Info
	 * @return chssUsgRto
	 */
	public String getChssUsgRto() {
		return this.chssUsgRto;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param eg5PreKntQty
	 */
	public void setEg5PreKntQty(String eg5PreKntQty) {
		this.eg5PreKntQty = eg5PreKntQty;
	}
	
	/**
	 * Column Info
	 * @param cntrPsnStsCd
	 */
	public void setCntrPsnStsCd(String cntrPsnStsCd) {
		this.cntrPsnStsCd = cntrPsnStsCd;
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
	 * @param cntrDryRfIndCd
	 */
	public void setCntrDryRfIndCd(String cntrDryRfIndCd) {
		this.cntrDryRfIndCd = cntrDryRfIndCd;
	}
	
	/**
	 * Column Info
	 * @param chssUsgRto
	 */
	public void setChssUsgRto(String chssUsgRto) {
		this.chssUsgRto = chssUsgRto;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setEg5PreKntQty(JSPUtil.getParameter(request, "eg5_pre_knt_qty", ""));
		setCntrPsnStsCd(JSPUtil.getParameter(request, "cntr_psn_sts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCntrDryRfIndCd(JSPUtil.getParameter(request, "cntr_dry_rf_ind_cd", ""));
		setChssUsgRto(JSPUtil.getParameter(request, "chss_usg_rto", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSUtilFactorINVO[]
	 */
	public CHSUtilFactorINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSUtilFactorINVO[]
	 */
	public CHSUtilFactorINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSUtilFactorINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] eg5PreKntQty = (JSPUtil.getParameter(request, prefix	+ "eg5_pre_knt_qty", length));
			String[] cntrPsnStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_psn_sts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrDryRfIndCd = (JSPUtil.getParameter(request, prefix	+ "cntr_dry_rf_ind_cd", length));
			String[] chssUsgRto = (JSPUtil.getParameter(request, prefix	+ "chss_usg_rto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSUtilFactorINVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (eg5PreKntQty[i] != null)
					model.setEg5PreKntQty(eg5PreKntQty[i]);
				if (cntrPsnStsCd[i] != null)
					model.setCntrPsnStsCd(cntrPsnStsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrDryRfIndCd[i] != null)
					model.setCntrDryRfIndCd(cntrDryRfIndCd[i]);
				if (chssUsgRto[i] != null)
					model.setChssUsgRto(chssUsgRto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSUtilFactorINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSUtilFactorINVO[]
	 */
	public CHSUtilFactorINVO[] getCHSUtilFactorINVOs(){
		CHSUtilFactorINVO[] vos = (CHSUtilFactorINVO[])models.toArray(new CHSUtilFactorINVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eg5PreKntQty = this.eg5PreKntQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPsnStsCd = this.cntrPsnStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDryRfIndCd = this.cntrDryRfIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssUsgRto = this.chssUsgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
