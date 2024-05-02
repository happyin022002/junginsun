/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSpaceAllocation0053ManageListVO.java
*@FileTitle : SearchSpaceAllocation0053ManageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.22 한상훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceAllocation0053ManageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceAllocation0053ManageListVO> models = new ArrayList<SearchSpaceAllocation0053ManageListVO>();
	
	/* Column Info */
	private String ctrlPortFlg = null;
	/* Column Info */
	private String ctrl40ftHcFlg = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repTrdCd = null;
	/* Column Info */
	private String ctrlSpcFlg = null;
	/* Column Info */
	private String forWeight = null;
	/* Column Info */
	private String ctrl45ftHcFlg = null;
	/* Column Info */
	private String ctrlWgtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String forHc45 = null;
	/* Column Info */
	private String forVolum = null;
	/* Column Info */
	private String ctrlRfFlg = null;
	/* Column Info */
	private String forHc = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String forReefer = null;
	/* Column Info */
	private String repSubTrdCd = null;
	/* Column Info */
	private String week = null;
	/* Column Info */
	private String ctrl53ftFlg = null;
	/* Column Info */
	private String for53ft = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceAllocation0053ManageListVO() {}

	public SearchSpaceAllocation0053ManageListVO(String ibflag, String pagerows, String repTrdCd, String repSubTrdCd, String rlaneCd, String dirCd, String week, String vvd, String ctrlSpcFlg, String ctrl40ftHcFlg, String ctrl45ftHcFlg, String ctrl53ftFlg, String ctrlRfFlg, String ctrlPortFlg, String ctrlWgtFlg, String forVolum, String forHc, String forHc45, String for53ft, String forReefer, String forWeight) {
		this.ctrlPortFlg = ctrlPortFlg;
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
		this.rlaneCd = rlaneCd;
		this.repTrdCd = repTrdCd;
		this.ctrlSpcFlg = ctrlSpcFlg;
		this.forWeight = forWeight;
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
		this.ctrlWgtFlg = ctrlWgtFlg;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.forHc45 = forHc45;
		this.forVolum = forVolum;
		this.ctrlRfFlg = ctrlRfFlg;
		this.forHc = forHc;
		this.dirCd = dirCd;
		this.forReefer = forReefer;
		this.repSubTrdCd = repSubTrdCd;
		this.week = week;
		this.ctrl53ftFlg = ctrl53ftFlg;
		this.for53ft = for53ft;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctrl_port_flg", getCtrlPortFlg());
		this.hashColumns.put("ctrl_40ft_hc_flg", getCtrl40ftHcFlg());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rep_trd_cd", getRepTrdCd());
		this.hashColumns.put("ctrl_spc_flg", getCtrlSpcFlg());
		this.hashColumns.put("for_weight", getForWeight());
		this.hashColumns.put("ctrl_45ft_hc_flg", getCtrl45ftHcFlg());
		this.hashColumns.put("ctrl_wgt_flg", getCtrlWgtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("for_hc45", getForHc45());
		this.hashColumns.put("for_volum", getForVolum());
		this.hashColumns.put("ctrl_rf_flg", getCtrlRfFlg());
		this.hashColumns.put("for_hc", getForHc());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("for_reefer", getForReefer());
		this.hashColumns.put("rep_sub_trd_cd", getRepSubTrdCd());
		this.hashColumns.put("week", getWeek());
		this.hashColumns.put("ctrl_53ft_flg", getCtrl53ftFlg());
		this.hashColumns.put("for_53ft", getFor53ft());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctrl_port_flg", "ctrlPortFlg");
		this.hashFields.put("ctrl_40ft_hc_flg", "ctrl40ftHcFlg");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rep_trd_cd", "repTrdCd");
		this.hashFields.put("ctrl_spc_flg", "ctrlSpcFlg");
		this.hashFields.put("for_weight", "forWeight");
		this.hashFields.put("ctrl_45ft_hc_flg", "ctrl45ftHcFlg");
		this.hashFields.put("ctrl_wgt_flg", "ctrlWgtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("for_hc45", "forHc45");
		this.hashFields.put("for_volum", "forVolum");
		this.hashFields.put("ctrl_rf_flg", "ctrlRfFlg");
		this.hashFields.put("for_hc", "forHc");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("for_reefer", "forReefer");
		this.hashFields.put("rep_sub_trd_cd", "repSubTrdCd");
		this.hashFields.put("week", "week");
		this.hashFields.put("ctrl_53ft_flg", "ctrl53ftFlg");
		this.hashFields.put("for_53ft", "for53ft");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrlPortFlg
	 */
	public String getCtrlPortFlg() {
		return this.ctrlPortFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrl40ftHcFlg
	 */
	public String getCtrl40ftHcFlg() {
		return this.ctrl40ftHcFlg;
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
	 * @return repTrdCd
	 */
	public String getRepTrdCd() {
		return this.repTrdCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlSpcFlg
	 */
	public String getCtrlSpcFlg() {
		return this.ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @return forWeight
	 */
	public String getForWeight() {
		return this.forWeight;
	}
	
	/**
	 * Column Info
	 * @return ctrl45ftHcFlg
	 */
	public String getCtrl45ftHcFlg() {
		return this.ctrl45ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrlWgtFlg
	 */
	public String getCtrlWgtFlg() {
		return this.ctrlWgtFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return forHc45
	 */
	public String getForHc45() {
		return this.forHc45;
	}
	
	/**
	 * Column Info
	 * @return forVolum
	 */
	public String getForVolum() {
		return this.forVolum;
	}
	
	/**
	 * Column Info
	 * @return ctrlRfFlg
	 */
	public String getCtrlRfFlg() {
		return this.ctrlRfFlg;
	}
	
	/**
	 * Column Info
	 * @return forHc
	 */
	public String getForHc() {
		return this.forHc;
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
	 * @return forReefer
	 */
	public String getForReefer() {
		return this.forReefer;
	}
	
	/**
	 * Column Info
	 * @return repSubTrdCd
	 */
	public String getRepSubTrdCd() {
		return this.repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	
	/**
	 * Column Info
	 * @return ctrl53ftFlg
	 */
	public String getCtrl53ftFlg() { 
		return this.ctrl53ftFlg;
	}
	
	/** 
	 * Column Info
	 * @return for53ft
	 */
	public String getFor53ft() {
		return this.for53ft;
	}
	

	/**
	 * Column Info
	 * @param ctrlPortFlg
	 */
	public void setCtrlPortFlg(String ctrlPortFlg) {
		this.ctrlPortFlg = ctrlPortFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrl40ftHcFlg
	 */
	public void setCtrl40ftHcFlg(String ctrl40ftHcFlg) {
		this.ctrl40ftHcFlg = ctrl40ftHcFlg;
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
	 * @param repTrdCd
	 */
	public void setRepTrdCd(String repTrdCd) {
		this.repTrdCd = repTrdCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlSpcFlg
	 */
	public void setCtrlSpcFlg(String ctrlSpcFlg) {
		this.ctrlSpcFlg = ctrlSpcFlg;
	}
	
	/**
	 * Column Info
	 * @param forWeight
	 */
	public void setForWeight(String forWeight) {
		this.forWeight = forWeight;
	}
	
	/**
	 * Column Info
	 * @param ctrl45ftHcFlg
	 */
	public void setCtrl45ftHcFlg(String ctrl45ftHcFlg) {
		this.ctrl45ftHcFlg = ctrl45ftHcFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrlWgtFlg
	 */
	public void setCtrlWgtFlg(String ctrlWgtFlg) {
		this.ctrlWgtFlg = ctrlWgtFlg;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param forHc45
	 */
	public void setForHc45(String forHc45) {
		this.forHc45 = forHc45;
	}
	
	/**
	 * Column Info
	 * @param forVolum
	 */
	public void setForVolum(String forVolum) {
		this.forVolum = forVolum;
	}
	
	/**
	 * Column Info
	 * @param ctrlRfFlg
	 */
	public void setCtrlRfFlg(String ctrlRfFlg) {
		this.ctrlRfFlg = ctrlRfFlg;
	}
	
	/**
	 * Column Info
	 * @param forHc
	 */
	public void setForHc(String forHc) {
		this.forHc = forHc;
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
	 * @param forReefer
	 */
	public void setForReefer(String forReefer) {
		this.forReefer = forReefer;
	}
	
	/**
	 * Column Info
	 * @param repSubTrdCd
	 */
	public void setRepSubTrdCd(String repSubTrdCd) {
		this.repSubTrdCd = repSubTrdCd;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
	}
	
	/**
	 * Column Info
	 * @return ctrl53ftFlg
	 */
	public void setCtrl53ftFlg(String ctrl53ftFlg) {
		this.ctrl53ftFlg = ctrl53ftFlg;
	}
	
	/**
	 * Column Info
	 * @return for53ft
	 */
	public void setFor53ft(String for53ft) {
		this.for53ft = for53ft;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCtrlPortFlg(JSPUtil.getParameter(request, "ctrl_port_flg", ""));
		setCtrl40ftHcFlg(JSPUtil.getParameter(request, "ctrl_40ft_hc_flg", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRepTrdCd(JSPUtil.getParameter(request, "rep_trd_cd", ""));
		setCtrlSpcFlg(JSPUtil.getParameter(request, "ctrl_spc_flg", ""));
		setForWeight(JSPUtil.getParameter(request, "for_weight", ""));
		setCtrl45ftHcFlg(JSPUtil.getParameter(request, "ctrl_45ft_hc_flg", ""));
		setCtrlWgtFlg(JSPUtil.getParameter(request, "ctrl_wgt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setForHc45(JSPUtil.getParameter(request, "for_hc45", ""));
		setForVolum(JSPUtil.getParameter(request, "for_volum", ""));
		setCtrlRfFlg(JSPUtil.getParameter(request, "ctrl_rf_flg", ""));
		setForHc(JSPUtil.getParameter(request, "for_hc", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setForReefer(JSPUtil.getParameter(request, "for_reefer", ""));
		setRepSubTrdCd(JSPUtil.getParameter(request, "rep_sub_trd_cd", ""));
		setWeek(JSPUtil.getParameter(request, "week", ""));
		setCtrl53ftFlg(JSPUtil.getParameter(request, "ctrl_53ft_flg", ""));
		setFor53ft(JSPUtil.getParameter(request, "for_53ft", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceAllocation0053ManageListVO[]
	 */
	public SearchSpaceAllocation0053ManageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceAllocation0053ManageListVO[]
	 */
	public SearchSpaceAllocation0053ManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceAllocation0053ManageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrlPortFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_port_flg", length));
			String[] ctrl40ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_40ft_hc_flg", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_trd_cd", length));
			String[] ctrlSpcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_spc_flg", length));
			String[] forWeight = (JSPUtil.getParameter(request, prefix	+ "for_weight", length));
			String[] ctrl45ftHcFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_45ft_hc_flg", length));
			String[] ctrlWgtFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_wgt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] forHc45 = (JSPUtil.getParameter(request, prefix	+ "for_hc45", length));
			String[] forVolum = (JSPUtil.getParameter(request, prefix	+ "for_volum", length));
			String[] ctrlRfFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_rf_flg", length));
			String[] forHc = (JSPUtil.getParameter(request, prefix	+ "for_hc", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] forReefer = (JSPUtil.getParameter(request, prefix	+ "for_reefer", length));
			String[] repSubTrdCd = (JSPUtil.getParameter(request, prefix	+ "rep_sub_trd_cd", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			String[] ctrl53ftFlg = (JSPUtil.getParameter(request, prefix	+ "ctrl_53ft_flg", length));
			String[] for53ft = (JSPUtil.getParameter(request, prefix	+ "for_53ft", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceAllocation0053ManageListVO();
				if (ctrlPortFlg[i] != null)
					model.setCtrlPortFlg(ctrlPortFlg[i]);
				if (ctrl40ftHcFlg[i] != null)
					model.setCtrl40ftHcFlg(ctrl40ftHcFlg[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repTrdCd[i] != null)
					model.setRepTrdCd(repTrdCd[i]);
				if (ctrlSpcFlg[i] != null)
					model.setCtrlSpcFlg(ctrlSpcFlg[i]);
				if (forWeight[i] != null)
					model.setForWeight(forWeight[i]);
				if (ctrl45ftHcFlg[i] != null)
					model.setCtrl45ftHcFlg(ctrl45ftHcFlg[i]);
				if (ctrlWgtFlg[i] != null)
					model.setCtrlWgtFlg(ctrlWgtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (forHc45[i] != null)
					model.setForHc45(forHc45[i]);
				if (forVolum[i] != null)
					model.setForVolum(forVolum[i]);
				if (ctrlRfFlg[i] != null)
					model.setCtrlRfFlg(ctrlRfFlg[i]);
				if (forHc[i] != null)
					model.setForHc(forHc[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (forReefer[i] != null)
					model.setForReefer(forReefer[i]);
				if (repSubTrdCd[i] != null)
					model.setRepSubTrdCd(repSubTrdCd[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				if (ctrl53ftFlg[i] != null)
					model.setCtrl53ftFlg(week[i]);
				if (for53ft[i] != null)
					model.setFor53ft(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceAllocation0053ManageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceAllocation0053ManageListVO[]
	 */
	public SearchSpaceAllocation0053ManageListVO[] getSearchSpaceAllocation0053ManageListVOs(){
		SearchSpaceAllocation0053ManageListVO[] vos = (SearchSpaceAllocation0053ManageListVO[])models.toArray(new SearchSpaceAllocation0053ManageListVO[models.size()]);
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
		this.ctrlPortFlg = this.ctrlPortFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl40ftHcFlg = this.ctrl40ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repTrdCd = this.repTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlSpcFlg = this.ctrlSpcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forWeight = this.forWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl45ftHcFlg = this.ctrl45ftHcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlWgtFlg = this.ctrlWgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forHc45 = this.forHc45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forVolum = this.forVolum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlRfFlg = this.ctrlRfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forHc = this.forHc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.forReefer = this.forReefer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repSubTrdCd = this.repSubTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrl53ftFlg = this.ctrl53ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.for53ft = this.for53ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
