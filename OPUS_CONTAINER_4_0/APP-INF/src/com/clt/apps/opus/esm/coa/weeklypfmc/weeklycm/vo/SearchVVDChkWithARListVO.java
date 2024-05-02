/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchVVDChkWithARListVO.java
*@FileTitle : SearchVVDChkWithARListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.09.10 박수훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo;

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
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVVDChkWithARListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchVVDChkWithARListVO> models = new ArrayList<SearchVVDChkWithARListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String monTgtFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String rslt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String fCostYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String fCostFmMon = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String rsltCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String lstLodgPortCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchVVDChkWithARListVO() {}

	public SearchVVDChkWithARListVO(String ibflag, String pagerows, String rsltCd, String rslt, String trdCd, String rlaneCd, String iocCd, String vslCd, String skdVoyNo, String dirCd, String vvd, String slanCd, String monTgtFlg, String deltFlg, String costYrmon, String costWk, String lstLodgPortCd, String fCostYr, String fCostFmMon, String creUsrId, String updUsrId) {
		this.iocCd = iocCd;
		this.vslCd = vslCd;
		this.monTgtFlg = monTgtFlg;
		this.deltFlg = deltFlg;
		this.rslt = rslt;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.fCostYr = fCostYr;
		this.rlaneCd = rlaneCd;
		this.fCostFmMon = fCostFmMon;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.slanCd = slanCd;
		this.costWk = costWk;
		this.rsltCd = rsltCd;
		this.dirCd = dirCd;
		this.lstLodgPortCd = lstLodgPortCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("mon_tgt_flg", getMonTgtFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rslt", getRslt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("f_cost_yr", getFCostYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("f_cost_fm_mon", getFCostFmMon());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("rslt_cd", getRsltCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lst_lodg_port_cd", getLstLodgPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("mon_tgt_flg", "monTgtFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("rslt", "rslt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("f_cost_yr", "fCostYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("f_cost_fm_mon", "fCostFmMon");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("rslt_cd", "rsltCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lst_lodg_port_cd", "lstLodgPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return monTgtFlg
	 */
	public String getMonTgtFlg() {
		return this.monTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return rslt
	 */
	public String getRslt() {
		return this.rslt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return fCostYr
	 */
	public String getFCostYr() {
		return this.fCostYr;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fCostFmMon
	 */
	public String getFCostFmMon() {
		return this.fCostFmMon;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @return rsltCd
	 */
	public String getRsltCd() {
		return this.rsltCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return lstLodgPortCd
	 */
	public String getLstLodgPortCd() {
		return this.lstLodgPortCd;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param monTgtFlg
	 */
	public void setMonTgtFlg(String monTgtFlg) {
		this.monTgtFlg = monTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param rslt
	 */
	public void setRslt(String rslt) {
		this.rslt = rslt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param fCostYr
	 */
	public void setFCostYr(String fCostYr) {
		this.fCostYr = fCostYr;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fCostFmMon
	 */
	public void setFCostFmMon(String fCostFmMon) {
		this.fCostFmMon = fCostFmMon;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @param rsltCd
	 */
	public void setRsltCd(String rsltCd) {
		this.rsltCd = rsltCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param lstLodgPortCd
	 */
	public void setLstLodgPortCd(String lstLodgPortCd) {
		this.lstLodgPortCd = lstLodgPortCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setMonTgtFlg(JSPUtil.getParameter(request, "mon_tgt_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setRslt(JSPUtil.getParameter(request, "rslt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setFCostYr(JSPUtil.getParameter(request, "f_cost_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setFCostFmMon(JSPUtil.getParameter(request, "f_cost_fm_mon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setRsltCd(JSPUtil.getParameter(request, "rslt_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setLstLodgPortCd(JSPUtil.getParameter(request, "lst_lodg_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchVVDChkWithARListVO[]
	 */
	public SearchVVDChkWithARListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchVVDChkWithARListVO[]
	 */
	public SearchVVDChkWithARListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVVDChkWithARListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] monTgtFlg = (JSPUtil.getParameter(request, prefix	+ "mon_tgt_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] rslt = (JSPUtil.getParameter(request, prefix	+ "rslt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] fCostYr = (JSPUtil.getParameter(request, prefix	+ "f_cost_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] fCostFmMon = (JSPUtil.getParameter(request, prefix	+ "f_cost_fm_mon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] rsltCd = (JSPUtil.getParameter(request, prefix	+ "rslt_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] lstLodgPortCd = (JSPUtil.getParameter(request, prefix	+ "lst_lodg_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchVVDChkWithARListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (monTgtFlg[i] != null)
					model.setMonTgtFlg(monTgtFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (rslt[i] != null)
					model.setRslt(rslt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (fCostYr[i] != null)
					model.setFCostYr(fCostYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (fCostFmMon[i] != null)
					model.setFCostFmMon(fCostFmMon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (rsltCd[i] != null)
					model.setRsltCd(rsltCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (lstLodgPortCd[i] != null)
					model.setLstLodgPortCd(lstLodgPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVVDChkWithARListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchVVDChkWithARListVO[]
	 */
	public SearchVVDChkWithARListVO[] getSearchVVDChkWithARListVOs(){
		SearchVVDChkWithARListVO[] vos = (SearchVVDChkWithARListVO[])models.toArray(new SearchVVDChkWithARListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monTgtFlg = this.monTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rslt = this.rslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostYr = this.fCostYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCostFmMon = this.fCostFmMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltCd = this.rsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstLodgPortCd = this.lstLodgPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
