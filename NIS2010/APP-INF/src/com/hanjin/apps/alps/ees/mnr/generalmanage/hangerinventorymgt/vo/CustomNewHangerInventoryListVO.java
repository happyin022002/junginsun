/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomNewHangerInventoryListVO.java
*@FileTitle : CustomNewHangerInventoryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.03
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.02.03 박정민   
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomNewHangerInventoryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomNewHangerInventoryListVO> models = new ArrayList<CustomNewHangerInventoryListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lstMon = null;
	/* Column Info */
	private String invtYrmon = null;
	/* Column Info */
	private String invtRmk = null;
	/* Column Info */
	private String rprHngrQty = null;
	/* Column Info */
	private String intgCdValDpDesc = null;
	/* Column Info */
	private String deHngrQty = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String obHngrQty = null;
	/* Column Info */
	private String dispHngrQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lvl = null;
	/* Column Info */
	private String intgCdValCtnt = null;
	/* Column Info */
	private String fstMon = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String repoOutHngrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomNewHangerInventoryListVO() {}

	public CustomNewHangerInventoryListVO(String ibflag, String pagerows, String lvl, String arHdQtrOfcCd, String invtYrmon, String ofcCd, String intgCdValCtnt, String intgCdValDpDesc, String fstMon, String lstMon, String deHngrQty, String obHngrQty, String repoOutHngrQty, String rprHngrQty, String dispHngrQty, String invtRmk, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.lstMon = lstMon;
		this.invtYrmon = invtYrmon;
		this.invtRmk = invtRmk;
		this.rprHngrQty = rprHngrQty;
		this.intgCdValDpDesc = intgCdValDpDesc;
		this.deHngrQty = deHngrQty;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.obHngrQty = obHngrQty;
		this.dispHngrQty = dispHngrQty;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.lvl = lvl;
		this.intgCdValCtnt = intgCdValCtnt;
		this.fstMon = fstMon;
		this.updUsrId = updUsrId;
		this.repoOutHngrQty = repoOutHngrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lst_mon", getLstMon());
		this.hashColumns.put("invt_yrmon", getInvtYrmon());
		this.hashColumns.put("invt_rmk", getInvtRmk());
		this.hashColumns.put("rpr_hngr_qty", getRprHngrQty());
		this.hashColumns.put("intg_cd_val_dp_desc", getIntgCdValDpDesc());
		this.hashColumns.put("de_hngr_qty", getDeHngrQty());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("ob_hngr_qty", getObHngrQty());
		this.hashColumns.put("disp_hngr_qty", getDispHngrQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lvl", getLvl());
		this.hashColumns.put("intg_cd_val_ctnt", getIntgCdValCtnt());
		this.hashColumns.put("fst_mon", getFstMon());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("repo_out_hngr_qty", getRepoOutHngrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lst_mon", "lstMon");
		this.hashFields.put("invt_yrmon", "invtYrmon");
		this.hashFields.put("invt_rmk", "invtRmk");
		this.hashFields.put("rpr_hngr_qty", "rprHngrQty");
		this.hashFields.put("intg_cd_val_dp_desc", "intgCdValDpDesc");
		this.hashFields.put("de_hngr_qty", "deHngrQty");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("ob_hngr_qty", "obHngrQty");
		this.hashFields.put("disp_hngr_qty", "dispHngrQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("intg_cd_val_ctnt", "intgCdValCtnt");
		this.hashFields.put("fst_mon", "fstMon");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("repo_out_hngr_qty", "repoOutHngrQty");
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
	 * @return lstMon
	 */
	public String getLstMon() {
		return this.lstMon;
	}
	
	/**
	 * Column Info
	 * @return invtYrmon
	 */
	public String getInvtYrmon() {
		return this.invtYrmon;
	}
	
	/**
	 * Column Info
	 * @return invtRmk
	 */
	public String getInvtRmk() {
		return this.invtRmk;
	}
	
	/**
	 * Column Info
	 * @return rprHngrQty
	 */
	public String getRprHngrQty() {
		return this.rprHngrQty;
	}
	
	/**
	 * Column Info
	 * @return intgCdValDpDesc
	 */
	public String getIntgCdValDpDesc() {
		return this.intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @return deHngrQty
	 */
	public String getDeHngrQty() {
		return this.deHngrQty;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return obHngrQty
	 */
	public String getObHngrQty() {
		return this.obHngrQty;
	}
	
	/**
	 * Column Info
	 * @return dispHngrQty
	 */
	public String getDispHngrQty() {
		return this.dispHngrQty;
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
	 * @return lvl
	 */
	public String getLvl() {
		return this.lvl;
	}
	
	/**
	 * Column Info
	 * @return intgCdValCtnt
	 */
	public String getIntgCdValCtnt() {
		return this.intgCdValCtnt;
	}
	
	/**
	 * Column Info
	 * @return fstMon
	 */
	public String getFstMon() {
		return this.fstMon;
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
	 * @return repoOutHngrQty
	 */
	public String getRepoOutHngrQty() {
		return this.repoOutHngrQty;
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
	 * @param lstMon
	 */
	public void setLstMon(String lstMon) {
		this.lstMon = lstMon;
	}
	
	/**
	 * Column Info
	 * @param invtYrmon
	 */
	public void setInvtYrmon(String invtYrmon) {
		this.invtYrmon = invtYrmon;
	}
	
	/**
	 * Column Info
	 * @param invtRmk
	 */
	public void setInvtRmk(String invtRmk) {
		this.invtRmk = invtRmk;
	}
	
	/**
	 * Column Info
	 * @param rprHngrQty
	 */
	public void setRprHngrQty(String rprHngrQty) {
		this.rprHngrQty = rprHngrQty;
	}
	
	/**
	 * Column Info
	 * @param intgCdValDpDesc
	 */
	public void setIntgCdValDpDesc(String intgCdValDpDesc) {
		this.intgCdValDpDesc = intgCdValDpDesc;
	}
	
	/**
	 * Column Info
	 * @param deHngrQty
	 */
	public void setDeHngrQty(String deHngrQty) {
		this.deHngrQty = deHngrQty;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param obHngrQty
	 */
	public void setObHngrQty(String obHngrQty) {
		this.obHngrQty = obHngrQty;
	}
	
	/**
	 * Column Info
	 * @param dispHngrQty
	 */
	public void setDispHngrQty(String dispHngrQty) {
		this.dispHngrQty = dispHngrQty;
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
	 * @param lvl
	 */
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Column Info
	 * @param intgCdValCtnt
	 */
	public void setIntgCdValCtnt(String intgCdValCtnt) {
		this.intgCdValCtnt = intgCdValCtnt;
	}
	
	/**
	 * Column Info
	 * @param fstMon
	 */
	public void setFstMon(String fstMon) {
		this.fstMon = fstMon;
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
	 * @param repoOutHngrQty
	 */
	public void setRepoOutHngrQty(String repoOutHngrQty) {
		this.repoOutHngrQty = repoOutHngrQty;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLstMon(JSPUtil.getParameter(request, prefix + "lst_mon", ""));
		setInvtYrmon(JSPUtil.getParameter(request, prefix + "invt_yrmon", ""));
		setInvtRmk(JSPUtil.getParameter(request, prefix + "invt_rmk", ""));
		setRprHngrQty(JSPUtil.getParameter(request, prefix + "rpr_hngr_qty", ""));
		setIntgCdValDpDesc(JSPUtil.getParameter(request, prefix + "intg_cd_val_dp_desc", ""));
		setDeHngrQty(JSPUtil.getParameter(request, prefix + "de_hngr_qty", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setObHngrQty(JSPUtil.getParameter(request, prefix + "ob_hngr_qty", ""));
		setDispHngrQty(JSPUtil.getParameter(request, prefix + "disp_hngr_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLvl(JSPUtil.getParameter(request, prefix + "lvl", ""));
		setIntgCdValCtnt(JSPUtil.getParameter(request, prefix + "intg_cd_val_ctnt", ""));
		setFstMon(JSPUtil.getParameter(request, prefix + "fst_mon", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRepoOutHngrQty(JSPUtil.getParameter(request, prefix + "repo_out_hngr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomNewHangerInventoryListVO[]
	 */
	public CustomNewHangerInventoryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomNewHangerInventoryListVO[]
	 */
	public CustomNewHangerInventoryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomNewHangerInventoryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lstMon = (JSPUtil.getParameter(request, prefix	+ "lst_mon", length));
			String[] invtYrmon = (JSPUtil.getParameter(request, prefix	+ "invt_yrmon", length));
			String[] invtRmk = (JSPUtil.getParameter(request, prefix	+ "invt_rmk", length));
			String[] rprHngrQty = (JSPUtil.getParameter(request, prefix	+ "rpr_hngr_qty", length));
			String[] intgCdValDpDesc = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_dp_desc", length));
			String[] deHngrQty = (JSPUtil.getParameter(request, prefix	+ "de_hngr_qty", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] obHngrQty = (JSPUtil.getParameter(request, prefix	+ "ob_hngr_qty", length));
			String[] dispHngrQty = (JSPUtil.getParameter(request, prefix	+ "disp_hngr_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lvl = (JSPUtil.getParameter(request, prefix	+ "lvl", length));
			String[] intgCdValCtnt = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_ctnt", length));
			String[] fstMon = (JSPUtil.getParameter(request, prefix	+ "fst_mon", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] repoOutHngrQty = (JSPUtil.getParameter(request, prefix	+ "repo_out_hngr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomNewHangerInventoryListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lstMon[i] != null)
					model.setLstMon(lstMon[i]);
				if (invtYrmon[i] != null)
					model.setInvtYrmon(invtYrmon[i]);
				if (invtRmk[i] != null)
					model.setInvtRmk(invtRmk[i]);
				if (rprHngrQty[i] != null)
					model.setRprHngrQty(rprHngrQty[i]);
				if (intgCdValDpDesc[i] != null)
					model.setIntgCdValDpDesc(intgCdValDpDesc[i]);
				if (deHngrQty[i] != null)
					model.setDeHngrQty(deHngrQty[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (obHngrQty[i] != null)
					model.setObHngrQty(obHngrQty[i]);
				if (dispHngrQty[i] != null)
					model.setDispHngrQty(dispHngrQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lvl[i] != null)
					model.setLvl(lvl[i]);
				if (intgCdValCtnt[i] != null)
					model.setIntgCdValCtnt(intgCdValCtnt[i]);
				if (fstMon[i] != null)
					model.setFstMon(fstMon[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (repoOutHngrQty[i] != null)
					model.setRepoOutHngrQty(repoOutHngrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomNewHangerInventoryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomNewHangerInventoryListVO[]
	 */
	public CustomNewHangerInventoryListVO[] getCustomNewHangerInventoryListVOs(){
		CustomNewHangerInventoryListVO[] vos = (CustomNewHangerInventoryListVO[])models.toArray(new CustomNewHangerInventoryListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstMon = this.lstMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invtYrmon = this.invtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invtRmk = this.invtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprHngrQty = this.rprHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValDpDesc = this.intgCdValDpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deHngrQty = this.deHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obHngrQty = this.obHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispHngrQty = this.dispHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl = this.lvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValCtnt = this.intgCdValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fstMon = this.fstMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoOutHngrQty = this.repoOutHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
