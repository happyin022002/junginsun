/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApprovalListVO.java
*@FileTitle : ApprovalListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.10.26 이호선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ApprovalListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ApprovalListVO> models = new ArrayList<ApprovalListVO>();
	
	/* Column Info */
	private String cntrSpecNo = null;
	/* Column Info */
	private String cntrOnhAuthNo = null;
	/* Column Info */
	private String pkupDueDt = null;
	/* Column Info */
	private String liftOnChg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String newVanTpCd = null;
	/* Column Info */
	private String minOnhDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String onhQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lonChg = null;
	/* Column Info */
	private String pickQty = null;
	/* Column Info */
	private String pkupChgAmt = null;
	/* Column Info */
	private String pkupChgCrAmt = null;
	/* Column Info */
	private String pkupFmDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ApprovalListVO() {}

	public ApprovalListVO(String ibflag, String pagerows, String cntrOnhAuthNo, String cntrTpszCd, String newVanTpCd, String onhQty, String pickQty, String pkupDueDt, String minOnhDys, String pkupChgAmt, String pkupChgCrAmt, String liftOnChg, String freeDys, String lonChg, String cntrSpecNo, String pkupFmDt) {
		this.cntrSpecNo = cntrSpecNo;
		this.cntrOnhAuthNo = cntrOnhAuthNo;
		this.pkupDueDt = pkupDueDt;
		this.liftOnChg = liftOnChg;
		this.pagerows = pagerows;
		this.newVanTpCd = newVanTpCd;
		this.minOnhDys = minOnhDys;
		this.ibflag = ibflag;
		this.freeDys = freeDys;
		this.onhQty = onhQty;
		this.cntrTpszCd = cntrTpszCd;
		this.lonChg = lonChg;
		this.pickQty = pickQty;
		this.pkupChgAmt = pkupChgAmt;
		this.pkupChgCrAmt = pkupChgCrAmt;
		this.pkupFmDt = pkupFmDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());
		this.hashColumns.put("cntr_onh_auth_no", getCntrOnhAuthNo());
		this.hashColumns.put("pkup_due_dt", getPkupDueDt());
		this.hashColumns.put("lift_on_chg", getLiftOnChg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("new_van_tp_cd", getNewVanTpCd());
		this.hashColumns.put("min_onh_dys", getMinOnhDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("onh_qty", getOnhQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lon_chg", getLonChg());
		this.hashColumns.put("pick_qty", getPickQty());
		this.hashColumns.put("pkup_chg_amt", getPkupChgAmt());
		this.hashColumns.put("pkup_chg_cr_amt", getPkupChgCrAmt());
		this.hashColumns.put("pkup_fm_dt", getPkupFmDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("cntr_onh_auth_no", "cntrOnhAuthNo");
		this.hashFields.put("pkup_due_dt", "pkupDueDt");
		this.hashFields.put("lift_on_chg", "liftOnChg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("new_van_tp_cd", "newVanTpCd");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("onh_qty", "onhQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lon_chg", "lonChg");
		this.hashFields.put("pick_qty", "pickQty");
		this.hashFields.put("pkup_chg_amt", "pkupChgAmt");
		this.hashFields.put("pkup_chg_cr_amt", "pkupChgCrAmt");
		this.hashFields.put("pkup_fm_dt", "pkupFmDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrSpecNo
	 */
	public String getCntrSpecNo() {
		return this.cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @return cntrOnhAuthNo
	 */
	public String getCntrOnhAuthNo() {
		return this.cntrOnhAuthNo;
	}
	
	/**
	 * Column Info
	 * @return pkupDueDt
	 */
	public String getPkupDueDt() {
		return this.pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @return liftOnChg
	 */
	public String getLiftOnChg() {
		return this.liftOnChg;
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
	 * @return newVanTpCd
	 */
	public String getNewVanTpCd() {
		return this.newVanTpCd;
	}
	
	/**
	 * Column Info
	 * @return minOnhDys
	 */
	public String getMinOnhDys() {
		return this.minOnhDys;
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
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
	}
	
	/**
	 * Column Info
	 * @return onhQty
	 */
	public String getOnhQty() {
		return this.onhQty;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return lonChg
	 */
	public String getLonChg() {
		return this.lonChg;
	}
	
	/**
	 * Column Info
	 * @return pickQty
	 */
	public String getPickQty() {
		return this.pickQty;
	}
	
	/**
	 * Column Info
	 * @return pkupChgAmt
	 */
	public String getPkupChgAmt() {
		return this.pkupChgAmt;
	}
	
	/**
	 * Column Info
	 * @return pkupChgCrAmt
	 */
	public String getPkupChgCrAmt() {
		return this.pkupChgCrAmt;
	}
	

	/**
	 * Column Info
	 * @param cntrSpecNo
	 */
	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
	}
	
	/**
	 * Column Info
	 * @param cntrOnhAuthNo
	 */
	public void setCntrOnhAuthNo(String cntrOnhAuthNo) {
		this.cntrOnhAuthNo = cntrOnhAuthNo;
	}
	
	/**
	 * Column Info
	 * @param pkupDueDt
	 */
	public void setPkupDueDt(String pkupDueDt) {
		this.pkupDueDt = pkupDueDt;
	}
	
	/**
	 * Column Info
	 * @param liftOnChg
	 */
	public void setLiftOnChg(String liftOnChg) {
		this.liftOnChg = liftOnChg;
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
	 * @param newVanTpCd
	 */
	public void setNewVanTpCd(String newVanTpCd) {
		this.newVanTpCd = newVanTpCd;
	}
	
	/**
	 * Column Info
	 * @param minOnhDys
	 */
	public void setMinOnhDys(String minOnhDys) {
		this.minOnhDys = minOnhDys;
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
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
	}
	
	/**
	 * Column Info
	 * @param onhQty
	 */
	public void setOnhQty(String onhQty) {
		this.onhQty = onhQty;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param lonChg
	 */
	public void setLonChg(String lonChg) {
		this.lonChg = lonChg;
	}
	
	/**
	 * Column Info
	 * @param pickQty
	 */
	public void setPickQty(String pickQty) {
		this.pickQty = pickQty;
	}
	
	/**
	 * Column Info
	 * @param pkupChgAmt
	 */
	public void setPkupChgAmt(String pkupChgAmt) {
		this.pkupChgAmt = pkupChgAmt;
	}
	
	/**
	 * Column Info
	 * @param pkupChgCrAmt
	 */
	public void setPkupChgCrAmt(String pkupChgCrAmt) {
		this.pkupChgCrAmt = pkupChgCrAmt;
	}
	
	/**
	 * Column Info
	 * @return pkupFmDt
	 */
	public String getPkupFmDt() {
		return this.pkupFmDt;
	}
	
	/**
	 * Column Info
	 * @param pkupFmDt
	 */
	public void setPkupFmDt(String pkupFmDt) {
		this.pkupFmDt = pkupFmDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrSpecNo(JSPUtil.getParameter(request, "cntr_spec_no", ""));
		setCntrOnhAuthNo(JSPUtil.getParameter(request, "cntr_onh_auth_no", ""));
		setPkupDueDt(JSPUtil.getParameter(request, "pkup_due_dt", ""));
		setLiftOnChg(JSPUtil.getParameter(request, "lift_on_chg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNewVanTpCd(JSPUtil.getParameter(request, "new_van_tp_cd", ""));
		setMinOnhDys(JSPUtil.getParameter(request, "min_onh_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFreeDys(JSPUtil.getParameter(request, "free_dys", ""));
		setOnhQty(JSPUtil.getParameter(request, "onh_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLonChg(JSPUtil.getParameter(request, "lon_chg", ""));
		setPickQty(JSPUtil.getParameter(request, "pick_qty", ""));
		setPkupChgAmt(JSPUtil.getParameter(request, "pkup_chg_amt", ""));
		setPkupChgCrAmt(JSPUtil.getParameter(request, "pkup_chg_cr_amt", ""));
		setPkupFmDt(JSPUtil.getParameter(request, "pkup_fm_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApprovalListVO[]
	 */
	public ApprovalListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ApprovalListVO[]
	 */
	public ApprovalListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ApprovalListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no", length));
			String[] cntrOnhAuthNo = (JSPUtil.getParameter(request, prefix	+ "cntr_onh_auth_no", length));
			String[] pkupDueDt = (JSPUtil.getParameter(request, prefix	+ "pkup_due_dt", length));
			String[] liftOnChg = (JSPUtil.getParameter(request, prefix	+ "lift_on_chg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] newVanTpCd = (JSPUtil.getParameter(request, prefix	+ "new_van_tp_cd", length));
			String[] minOnhDys = (JSPUtil.getParameter(request, prefix	+ "min_onh_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] onhQty = (JSPUtil.getParameter(request, prefix	+ "onh_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lonChg = (JSPUtil.getParameter(request, prefix	+ "lon_chg", length));
			String[] pickQty = (JSPUtil.getParameter(request, prefix	+ "pick_qty", length));
			String[] pkupChgAmt = (JSPUtil.getParameter(request, prefix	+ "pkup_chg_amt", length));
			String[] pkupChgCrAmt = (JSPUtil.getParameter(request, prefix	+ "pkup_chg_cr_amt", length));
			String[] pkupFmDt = (JSPUtil.getParameter(request, prefix	+ "pkup_fm_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ApprovalListVO();
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				if (cntrOnhAuthNo[i] != null)
					model.setCntrOnhAuthNo(cntrOnhAuthNo[i]);
				if (pkupDueDt[i] != null)
					model.setPkupDueDt(pkupDueDt[i]);
				if (liftOnChg[i] != null)
					model.setLiftOnChg(liftOnChg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (newVanTpCd[i] != null)
					model.setNewVanTpCd(newVanTpCd[i]);
				if (minOnhDys[i] != null)
					model.setMinOnhDys(minOnhDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (onhQty[i] != null)
					model.setOnhQty(onhQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lonChg[i] != null)
					model.setLonChg(lonChg[i]);
				if (pickQty[i] != null)
					model.setPickQty(pickQty[i]);
				if (pkupChgAmt[i] != null)
					model.setPkupChgAmt(pkupChgAmt[i]);
				if (pkupChgCrAmt[i] != null)
					model.setPkupChgCrAmt(pkupChgCrAmt[i]);
				if (pkupFmDt[i] != null)
					model.setPkupFmDt(pkupFmDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getApprovalListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ApprovalListVO[]
	 */
	public ApprovalListVO[] getApprovalListVOs(){
		ApprovalListVO[] vos = (ApprovalListVO[])models.toArray(new ApprovalListVO[models.size()]);
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
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhAuthNo = this.cntrOnhAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDueDt = this.pkupDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liftOnChg = this.liftOnChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVanTpCd = this.newVanTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys = this.minOnhDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhQty = this.onhQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lonChg = this.lonChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pickQty = this.pickQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupChgAmt = this.pkupChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupChgCrAmt = this.pkupChgCrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupFmDt = this.pkupFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
