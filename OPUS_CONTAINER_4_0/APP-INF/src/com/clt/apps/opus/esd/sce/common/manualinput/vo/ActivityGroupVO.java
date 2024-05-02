/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ActivityGroupVO.java
*@FileTitle : ActivityGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.30  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.manualinput.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActivityGroupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActivityGroupVO> models = new ArrayList<ActivityGroupVO>();
	
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String bkgTermCd = null;
	/* Column Info */
	private String chkNodTpCd = null;
	/* Column Info */
	private String chkAftTrspModCd = null;
	/* Column Info */
	private String aftTrspModCd = null;
	/* Column Info */
	private String chkSpclNodTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chkBkgTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chkTrspBndCd = null;
	/* Column Info */
	private String chkBfrTrspModCd = null;
	/* Column Info */
	private String bfrTrspModCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String copDtlGrpCd = null;
	/* Column Info */
	private String nodTpCd = null;
	/* Column Info */
	private String spclNodTpCd = null;
	/* Column Info */
	private String comboDummyCol = null;
	/* Column Info */
	private String copDtlGrpCdCombo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActivityGroupVO() {}

	public ActivityGroupVO(String ibflag, String pagerows, String nodTpCd, String bkgTermCd, String bfrTrspModCd, String aftTrspModCd, String trspBndCd, String spclNodTpCd, String copDtlGrpCd, String copDtlGrpCdCombo, String comboDummyCol, String userId, String chkNodTpCd, String chkBkgTermCd, String chkBfrTrspModCd, String chkAftTrspModCd, String chkTrspBndCd, String chkSpclNodTpCd) {
		this.trspBndCd = trspBndCd;
		this.bkgTermCd = bkgTermCd;
		this.chkNodTpCd = chkNodTpCd;
		this.chkAftTrspModCd = chkAftTrspModCd;
		this.aftTrspModCd = aftTrspModCd;
		this.chkSpclNodTpCd = chkSpclNodTpCd;
		this.pagerows = pagerows;
		this.chkBkgTermCd = chkBkgTermCd;
		this.ibflag = ibflag;
		this.chkTrspBndCd = chkTrspBndCd;
		this.chkBfrTrspModCd = chkBfrTrspModCd;
		this.bfrTrspModCd = bfrTrspModCd;
		this.userId = userId;
		this.copDtlGrpCd = copDtlGrpCd;
		this.nodTpCd = nodTpCd;
		this.spclNodTpCd = spclNodTpCd;
		this.comboDummyCol = comboDummyCol;
		this.copDtlGrpCdCombo = copDtlGrpCdCombo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("bkg_term_cd", getBkgTermCd());
		this.hashColumns.put("chk_nod_tp_cd", getChkNodTpCd());
		this.hashColumns.put("chk_aft_trsp_mod_cd", getChkAftTrspModCd());
		this.hashColumns.put("aft_trsp_mod_cd", getAftTrspModCd());
		this.hashColumns.put("chk_spcl_nod_tp_cd", getChkSpclNodTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chk_bkg_term_cd", getChkBkgTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk_trsp_bnd_cd", getChkTrspBndCd());
		this.hashColumns.put("chk_bfr_trsp_mod_cd", getChkBfrTrspModCd());
		this.hashColumns.put("bfr_trsp_mod_cd", getBfrTrspModCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("cop_dtl_grp_cd", getCopDtlGrpCd());
		this.hashColumns.put("nod_tp_cd", getNodTpCd());
		this.hashColumns.put("spcl_nod_tp_cd", getSpclNodTpCd());
		this.hashColumns.put("combo_dummy_col", getComboDummyCol());
		this.hashColumns.put("cop_dtl_grp_cd_combo", getCopDtlGrpCdCombo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("bkg_term_cd", "bkgTermCd");
		this.hashFields.put("chk_nod_tp_cd", "chkNodTpCd");
		this.hashFields.put("chk_aft_trsp_mod_cd", "chkAftTrspModCd");
		this.hashFields.put("aft_trsp_mod_cd", "aftTrspModCd");
		this.hashFields.put("chk_spcl_nod_tp_cd", "chkSpclNodTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chk_bkg_term_cd", "chkBkgTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk_trsp_bnd_cd", "chkTrspBndCd");
		this.hashFields.put("chk_bfr_trsp_mod_cd", "chkBfrTrspModCd");
		this.hashFields.put("bfr_trsp_mod_cd", "bfrTrspModCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("cop_dtl_grp_cd", "copDtlGrpCd");
		this.hashFields.put("nod_tp_cd", "nodTpCd");
		this.hashFields.put("spcl_nod_tp_cd", "spclNodTpCd");
		this.hashFields.put("combo_dummy_col", "comboDummyCol");
		this.hashFields.put("cop_dtl_grp_cd_combo", "copDtlGrpCdCombo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return bkgTermCd
	 */
	public String getBkgTermCd() {
		return this.bkgTermCd;
	}
	
	/**
	 * Column Info
	 * @return chkNodTpCd
	 */
	public String getChkNodTpCd() {
		return this.chkNodTpCd;
	}
	
	/**
	 * Column Info
	 * @return chkAftTrspModCd
	 */
	public String getChkAftTrspModCd() {
		return this.chkAftTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return aftTrspModCd
	 */
	public String getAftTrspModCd() {
		return this.aftTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return chkSpclNodTpCd
	 */
	public String getChkSpclNodTpCd() {
		return this.chkSpclNodTpCd;
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
	 * @return chkBkgTermCd
	 */
	public String getChkBkgTermCd() {
		return this.chkBkgTermCd;
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
	 * @return chkTrspBndCd
	 */
	public String getChkTrspBndCd() {
		return this.chkTrspBndCd;
	}
	
	/**
	 * Column Info
	 * @return chkBfrTrspModCd
	 */
	public String getChkBfrTrspModCd() {
		return this.chkBfrTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return bfrTrspModCd
	 */
	public String getBfrTrspModCd() {
		return this.bfrTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return copDtlGrpCd
	 */
	public String getCopDtlGrpCd() {
		return this.copDtlGrpCd;
	}
	
	/**
	 * Column Info
	 * @return nodTpCd
	 */
	public String getNodTpCd() {
		return this.nodTpCd;
	}
	
	/**
	 * Column Info
	 * @return spclNodTpCd
	 */
	public String getSpclNodTpCd() {
		return this.spclNodTpCd;
	}
	
	/**
	 * Column Info
	 * @return comboDummyCol
	 */
	public String getComboDummyCol() {
		return this.comboDummyCol;
	}
	
	/**
	 * Column Info
	 * @return copDtlGrpCdCombo
	 */
	public String getCopDtlGrpCdCombo() {
		return this.copDtlGrpCdCombo;
	}
	

	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param bkgTermCd
	 */
	public void setBkgTermCd(String bkgTermCd) {
		this.bkgTermCd = bkgTermCd;
	}
	
	/**
	 * Column Info
	 * @param chkNodTpCd
	 */
	public void setChkNodTpCd(String chkNodTpCd) {
		this.chkNodTpCd = chkNodTpCd;
	}
	
	/**
	 * Column Info
	 * @param chkAftTrspModCd
	 */
	public void setChkAftTrspModCd(String chkAftTrspModCd) {
		this.chkAftTrspModCd = chkAftTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param aftTrspModCd
	 */
	public void setAftTrspModCd(String aftTrspModCd) {
		this.aftTrspModCd = aftTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param chkSpclNodTpCd
	 */
	public void setChkSpclNodTpCd(String chkSpclNodTpCd) {
		this.chkSpclNodTpCd = chkSpclNodTpCd;
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
	 * @param chkBkgTermCd
	 */
	public void setChkBkgTermCd(String chkBkgTermCd) {
		this.chkBkgTermCd = chkBkgTermCd;
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
	 * @param chkTrspBndCd
	 */
	public void setChkTrspBndCd(String chkTrspBndCd) {
		this.chkTrspBndCd = chkTrspBndCd;
	}
	
	/**
	 * Column Info
	 * @param chkBfrTrspModCd
	 */
	public void setChkBfrTrspModCd(String chkBfrTrspModCd) {
		this.chkBfrTrspModCd = chkBfrTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param bfrTrspModCd
	 */
	public void setBfrTrspModCd(String bfrTrspModCd) {
		this.bfrTrspModCd = bfrTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param copDtlGrpCd
	 */
	public void setCopDtlGrpCd(String copDtlGrpCd) {
		this.copDtlGrpCd = copDtlGrpCd;
	}
	
	/**
	 * Column Info
	 * @param nodTpCd
	 */
	public void setNodTpCd(String nodTpCd) {
		this.nodTpCd = nodTpCd;
	}
	
	/**
	 * Column Info
	 * @param spclNodTpCd
	 */
	public void setSpclNodTpCd(String spclNodTpCd) {
		this.spclNodTpCd = spclNodTpCd;
	}
	
	/**
	 * Column Info
	 * @param comboDummyCol
	 */
	public void setComboDummyCol(String comboDummyCol) {
		this.comboDummyCol = comboDummyCol;
	}
	
	/**
	 * Column Info
	 * @param copDtlGrpCdCombo
	 */
	public void setCopDtlGrpCdCombo(String copDtlGrpCdCombo) {
		this.copDtlGrpCdCombo = copDtlGrpCdCombo;
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
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setBkgTermCd(JSPUtil.getParameter(request, prefix + "bkg_term_cd", ""));
		setChkNodTpCd(JSPUtil.getParameter(request, prefix + "chk_nod_tp_cd", ""));
		setChkAftTrspModCd(JSPUtil.getParameter(request, prefix + "chk_aft_trsp_mod_cd", ""));
		setAftTrspModCd(JSPUtil.getParameter(request, prefix + "aft_trsp_mod_cd", ""));
		setChkSpclNodTpCd(JSPUtil.getParameter(request, prefix + "chk_spcl_nod_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChkBkgTermCd(JSPUtil.getParameter(request, prefix + "chk_bkg_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChkTrspBndCd(JSPUtil.getParameter(request, prefix + "chk_trsp_bnd_cd", ""));
		setChkBfrTrspModCd(JSPUtil.getParameter(request, prefix + "chk_bfr_trsp_mod_cd", ""));
		setBfrTrspModCd(JSPUtil.getParameter(request, prefix + "bfr_trsp_mod_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setCopDtlGrpCd(JSPUtil.getParameter(request, prefix + "cop_dtl_grp_cd", ""));
		setNodTpCd(JSPUtil.getParameter(request, prefix + "nod_tp_cd", ""));
		setSpclNodTpCd(JSPUtil.getParameter(request, prefix + "spcl_nod_tp_cd", ""));
		setComboDummyCol(JSPUtil.getParameter(request, prefix + "combo_dummy_col", ""));
		setCopDtlGrpCdCombo(JSPUtil.getParameter(request, prefix + "cop_dtl_grp_cd_combo", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActivityGroupVO[]
	 */
	public ActivityGroupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActivityGroupVO[]
	 */
	public ActivityGroupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActivityGroupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] bkgTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_term_cd", length));
			String[] chkNodTpCd = (JSPUtil.getParameter(request, prefix	+ "chk_nod_tp_cd", length));
			String[] chkAftTrspModCd = (JSPUtil.getParameter(request, prefix	+ "chk_aft_trsp_mod_cd", length));
			String[] aftTrspModCd = (JSPUtil.getParameter(request, prefix	+ "aft_trsp_mod_cd", length));
			String[] chkSpclNodTpCd = (JSPUtil.getParameter(request, prefix	+ "chk_spcl_nod_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chkBkgTermCd = (JSPUtil.getParameter(request, prefix	+ "chk_bkg_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chkTrspBndCd = (JSPUtil.getParameter(request, prefix	+ "chk_trsp_bnd_cd", length));
			String[] chkBfrTrspModCd = (JSPUtil.getParameter(request, prefix	+ "chk_bfr_trsp_mod_cd", length));
			String[] bfrTrspModCd = (JSPUtil.getParameter(request, prefix	+ "bfr_trsp_mod_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] copDtlGrpCd = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_grp_cd", length));
			String[] nodTpCd = (JSPUtil.getParameter(request, prefix	+ "nod_tp_cd", length));
			String[] spclNodTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_nod_tp_cd", length));
			String[] comboDummyCol = (JSPUtil.getParameter(request, prefix	+ "combo_dummy_col", length));
			String[] copDtlGrpCdCombo = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_grp_cd_combo", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActivityGroupVO();
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (bkgTermCd[i] != null)
					model.setBkgTermCd(bkgTermCd[i]);
				if (chkNodTpCd[i] != null)
					model.setChkNodTpCd(chkNodTpCd[i]);
				if (chkAftTrspModCd[i] != null)
					model.setChkAftTrspModCd(chkAftTrspModCd[i]);
				if (aftTrspModCd[i] != null)
					model.setAftTrspModCd(aftTrspModCd[i]);
				if (chkSpclNodTpCd[i] != null)
					model.setChkSpclNodTpCd(chkSpclNodTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chkBkgTermCd[i] != null)
					model.setChkBkgTermCd(chkBkgTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chkTrspBndCd[i] != null)
					model.setChkTrspBndCd(chkTrspBndCd[i]);
				if (chkBfrTrspModCd[i] != null)
					model.setChkBfrTrspModCd(chkBfrTrspModCd[i]);
				if (bfrTrspModCd[i] != null)
					model.setBfrTrspModCd(bfrTrspModCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (copDtlGrpCd[i] != null)
					model.setCopDtlGrpCd(copDtlGrpCd[i]);
				if (nodTpCd[i] != null)
					model.setNodTpCd(nodTpCd[i]);
				if (spclNodTpCd[i] != null)
					model.setSpclNodTpCd(spclNodTpCd[i]);
				if (comboDummyCol[i] != null)
					model.setComboDummyCol(comboDummyCol[i]);
				if (copDtlGrpCdCombo[i] != null)
					model.setCopDtlGrpCdCombo(copDtlGrpCdCombo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActivityGroupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActivityGroupVO[]
	 */
	public ActivityGroupVO[] getActivityGroupVOs(){
		ActivityGroupVO[] vos = (ActivityGroupVO[])models.toArray(new ActivityGroupVO[models.size()]);
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
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTermCd = this.bkgTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkNodTpCd = this.chkNodTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkAftTrspModCd = this.chkAftTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftTrspModCd = this.aftTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkSpclNodTpCd = this.chkSpclNodTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBkgTermCd = this.chkBkgTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTrspBndCd = this.chkTrspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkBfrTrspModCd = this.chkBfrTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrTrspModCd = this.bfrTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlGrpCd = this.copDtlGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTpCd = this.nodTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclNodTpCd = this.spclNodTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboDummyCol = this.comboDummyCol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlGrpCdCombo = this.copDtlGrpCdCombo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
