/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ActualCostListVO.java
*@FileTitle : ActualCostListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActualCostListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActualCostListVO> models = new ArrayList<ActualCostListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aftBkgActCostItmNm = null;
	/* Column Info */
	private String aftBkgActCostItmLvl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String aftBkgActCostAmt = null;
	/* Column Info */
	private String aftBkgActCostRmk = null;
	/* Column Info */
	private String aftBkgActCostCurrCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ActualCostListVO() {}

	public ActualCostListVO(String ibflag, String pagerows, String aftExptDarNo, String aftBkgActCostItmLvl, String aftBkgActCostItmNm, String aftBkgActCostCurrCd, String aftBkgActCostAmt, String aftBkgActCostRmk, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.aftBkgActCostItmNm = aftBkgActCostItmNm;
		this.aftBkgActCostItmLvl = aftBkgActCostItmLvl;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.aftBkgActCostAmt = aftBkgActCostAmt;
		this.aftBkgActCostRmk = aftBkgActCostRmk;
		this.aftBkgActCostCurrCd = aftBkgActCostCurrCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("aft_bkg_act_cost_itm_nm", getAftBkgActCostItmNm());
		this.hashColumns.put("aft_bkg_act_cost_itm_lvl", getAftBkgActCostItmLvl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("aft_bkg_act_cost_amt", getAftBkgActCostAmt());
		this.hashColumns.put("aft_bkg_act_cost_rmk", getAftBkgActCostRmk());
		this.hashColumns.put("aft_bkg_act_cost_curr_cd", getAftBkgActCostCurrCd());
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
		this.hashFields.put("aft_bkg_act_cost_itm_nm", "aftBkgActCostItmNm");
		this.hashFields.put("aft_bkg_act_cost_itm_lvl", "aftBkgActCostItmLvl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("aft_bkg_act_cost_amt", "aftBkgActCostAmt");
		this.hashFields.put("aft_bkg_act_cost_rmk", "aftBkgActCostRmk");
		this.hashFields.put("aft_bkg_act_cost_curr_cd", "aftBkgActCostCurrCd");
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
	 * @return aftBkgActCostItmNm
	 */
	public String getAftBkgActCostItmNm() {
		return this.aftBkgActCostItmNm;
	}
	
	/**
	 * Column Info
	 * @return aftBkgActCostItmLvl
	 */
	public String getAftBkgActCostItmLvl() {
		return this.aftBkgActCostItmLvl;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return aftBkgActCostAmt
	 */
	public String getAftBkgActCostAmt() {
		return this.aftBkgActCostAmt;
	}
	
	/**
	 * Column Info
	 * @return aftBkgActCostRmk
	 */
	public String getAftBkgActCostRmk() {
		return this.aftBkgActCostRmk;
	}
	
	/**
	 * Column Info
	 * @return aftBkgActCostCurrCd
	 */
	public String getAftBkgActCostCurrCd() {
		return this.aftBkgActCostCurrCd;
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
	 * @param aftBkgActCostItmNm
	 */
	public void setAftBkgActCostItmNm(String aftBkgActCostItmNm) {
		this.aftBkgActCostItmNm = aftBkgActCostItmNm;
	}
	
	/**
	 * Column Info
	 * @param aftBkgActCostItmLvl
	 */
	public void setAftBkgActCostItmLvl(String aftBkgActCostItmLvl) {
		this.aftBkgActCostItmLvl = aftBkgActCostItmLvl;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param aftBkgActCostAmt
	 */
	public void setAftBkgActCostAmt(String aftBkgActCostAmt) {
		this.aftBkgActCostAmt = aftBkgActCostAmt;
	}
	
	/**
	 * Column Info
	 * @param aftBkgActCostRmk
	 */
	public void setAftBkgActCostRmk(String aftBkgActCostRmk) {
		this.aftBkgActCostRmk = aftBkgActCostRmk;
	}
	
	/**
	 * Column Info
	 * @param aftBkgActCostCurrCd
	 */
	public void setAftBkgActCostCurrCd(String aftBkgActCostCurrCd) {
		this.aftBkgActCostCurrCd = aftBkgActCostCurrCd;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAftBkgActCostItmNm(JSPUtil.getParameter(request, prefix + "aft_bkg_act_cost_itm_nm", ""));
		setAftBkgActCostItmLvl(JSPUtil.getParameter(request, prefix + "aft_bkg_act_cost_itm_lvl", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setAftBkgActCostAmt(JSPUtil.getParameter(request, prefix + "aft_bkg_act_cost_amt", ""));
		setAftBkgActCostRmk(JSPUtil.getParameter(request, prefix + "aft_bkg_act_cost_rmk", ""));
		setAftBkgActCostCurrCd(JSPUtil.getParameter(request, prefix + "aft_bkg_act_cost_curr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActualCostListVO[]
	 */
	public ActualCostListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActualCostListVO[]
	 */
	public ActualCostListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActualCostListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aftBkgActCostItmNm = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_act_cost_itm_nm", length));
			String[] aftBkgActCostItmLvl = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_act_cost_itm_lvl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] aftBkgActCostAmt = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_act_cost_amt", length));
			String[] aftBkgActCostRmk = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_act_cost_rmk", length));
			String[] aftBkgActCostCurrCd = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_act_cost_curr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActualCostListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aftBkgActCostItmNm[i] != null)
					model.setAftBkgActCostItmNm(aftBkgActCostItmNm[i]);
				if (aftBkgActCostItmLvl[i] != null)
					model.setAftBkgActCostItmLvl(aftBkgActCostItmLvl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (aftBkgActCostAmt[i] != null)
					model.setAftBkgActCostAmt(aftBkgActCostAmt[i]);
				if (aftBkgActCostRmk[i] != null)
					model.setAftBkgActCostRmk(aftBkgActCostRmk[i]);
				if (aftBkgActCostCurrCd[i] != null)
					model.setAftBkgActCostCurrCd(aftBkgActCostCurrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActualCostListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActualCostListVO[]
	 */
	public ActualCostListVO[] getActualCostListVOs(){
		ActualCostListVO[] vos = (ActualCostListVO[])models.toArray(new ActualCostListVO[models.size()]);
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
		this.aftBkgActCostItmNm = this.aftBkgActCostItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgActCostItmLvl = this.aftBkgActCostItmLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgActCostAmt = this.aftBkgActCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgActCostRmk = this.aftBkgActCostRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgActCostCurrCd = this.aftBkgActCostCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
