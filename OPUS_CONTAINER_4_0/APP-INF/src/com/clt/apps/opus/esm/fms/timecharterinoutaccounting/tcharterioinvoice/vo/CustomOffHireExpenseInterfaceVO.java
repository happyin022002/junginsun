/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomOffHireExpenseInterfaceVO.java
*@FileTitle : CustomOffHireExpenseInterfaceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.07.28 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomOffHireExpenseInterfaceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomOffHireExpenseInterfaceVO> models = new ArrayList<CustomOffHireExpenseInterfaceVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String csrSlpFlg = null;
	/* Column Info */
	private String offhDurDys = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String foilQty = null;
	/* Column Info */
	private String offhDesc = null;
	/* Column Info */
	private String doilQty = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String foilPrc = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String offhSeq = null;
	/* Column Info */
	private String doilPrc = null;
	/* Column Info */
	private String fletAccTpCd = null;
	/* Column Info */
	private String orgOnhDt = null;
	/* Column Info */
	private String offhDt = null;
	/* Column Info */
	private String offhRsn = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String orgOffhDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomOffHireExpenseInterfaceVO() {}

	public CustomOffHireExpenseInterfaceVO(String ibflag, String pagerows, String vslCd, String offhSeq, String offhDt, String onhDt, String offhDurDys, String fletAccTpCd, String foilQty, String foilPrc, String doilQty, String doilPrc, String offhRsn, String offhDesc, String csrSlpFlg, String orgOffhDt, String orgOnhDt, String creUsrId, String creDt, String updUsrId, String updDt, String deltFlg) {
		this.updDt = updDt;
		this.csrSlpFlg = csrSlpFlg;
		this.offhDurDys = offhDurDys;
		this.vslCd = vslCd;
		this.foilQty = foilQty;
		this.offhDesc = offhDesc;
		this.doilQty = doilQty;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.foilPrc = foilPrc;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.offhSeq = offhSeq;
		this.doilPrc = doilPrc;
		this.fletAccTpCd = fletAccTpCd;
		this.orgOnhDt = orgOnhDt;
		this.offhDt = offhDt;
		this.offhRsn = offhRsn;
		this.updUsrId = updUsrId;
		this.orgOffhDt = orgOffhDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("csr_slp_flg", getCsrSlpFlg());
		this.hashColumns.put("offh_dur_dys", getOffhDurDys());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("foil_qty", getFoilQty());
		this.hashColumns.put("offh_desc", getOffhDesc());
		this.hashColumns.put("doil_qty", getDoilQty());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("foil_prc", getFoilPrc());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("offh_seq", getOffhSeq());
		this.hashColumns.put("doil_prc", getDoilPrc());
		this.hashColumns.put("flet_acc_tp_cd", getFletAccTpCd());
		this.hashColumns.put("org_onh_dt", getOrgOnhDt());
		this.hashColumns.put("offh_dt", getOffhDt());
		this.hashColumns.put("offh_rsn", getOffhRsn());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("org_offh_dt", getOrgOffhDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("csr_slp_flg", "csrSlpFlg");
		this.hashFields.put("offh_dur_dys", "offhDurDys");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("foil_qty", "foilQty");
		this.hashFields.put("offh_desc", "offhDesc");
		this.hashFields.put("doil_qty", "doilQty");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("foil_prc", "foilPrc");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("offh_seq", "offhSeq");
		this.hashFields.put("doil_prc", "doilPrc");
		this.hashFields.put("flet_acc_tp_cd", "fletAccTpCd");
		this.hashFields.put("org_onh_dt", "orgOnhDt");
		this.hashFields.put("offh_dt", "offhDt");
		this.hashFields.put("offh_rsn", "offhRsn");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_offh_dt", "orgOffhDt");
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
	 * @return csrSlpFlg
	 */
	public String getCsrSlpFlg() {
		return this.csrSlpFlg;
	}
	
	/**
	 * Column Info
	 * @return offhDurDys
	 */
	public String getOffhDurDys() {
		return this.offhDurDys;
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
	 * @return foilQty
	 */
	public String getFoilQty() {
		return this.foilQty;
	}
	
	/**
	 * Column Info
	 * @return offhDesc
	 */
	public String getOffhDesc() {
		return this.offhDesc;
	}
	
	/**
	 * Column Info
	 * @return doilQty
	 */
	public String getDoilQty() {
		return this.doilQty;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return foilPrc
	 */
	public String getFoilPrc() {
		return this.foilPrc;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return offhSeq
	 */
	public String getOffhSeq() {
		return this.offhSeq;
	}
	
	/**
	 * Column Info
	 * @return doilPrc
	 */
	public String getDoilPrc() {
		return this.doilPrc;
	}
	
	/**
	 * Column Info
	 * @return fletAccTpCd
	 */
	public String getFletAccTpCd() {
		return this.fletAccTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgOnhDt
	 */
	public String getOrgOnhDt() {
		return this.orgOnhDt;
	}
	
	/**
	 * Column Info
	 * @return offhDt
	 */
	public String getOffhDt() {
		return this.offhDt;
	}
	
	/**
	 * Column Info
	 * @return offhRsn
	 */
	public String getOffhRsn() {
		return this.offhRsn;
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
	 * @return orgOffhDt
	 */
	public String getOrgOffhDt() {
		return this.orgOffhDt;
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
	 * @param csrSlpFlg
	 */
	public void setCsrSlpFlg(String csrSlpFlg) {
		this.csrSlpFlg = csrSlpFlg;
	}
	
	/**
	 * Column Info
	 * @param offhDurDys
	 */
	public void setOffhDurDys(String offhDurDys) {
		this.offhDurDys = offhDurDys;
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
	 * @param foilQty
	 */
	public void setFoilQty(String foilQty) {
		this.foilQty = foilQty;
	}
	
	/**
	 * Column Info
	 * @param offhDesc
	 */
	public void setOffhDesc(String offhDesc) {
		this.offhDesc = offhDesc;
	}
	
	/**
	 * Column Info
	 * @param doilQty
	 */
	public void setDoilQty(String doilQty) {
		this.doilQty = doilQty;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param foilPrc
	 */
	public void setFoilPrc(String foilPrc) {
		this.foilPrc = foilPrc;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param offhSeq
	 */
	public void setOffhSeq(String offhSeq) {
		this.offhSeq = offhSeq;
	}
	
	/**
	 * Column Info
	 * @param doilPrc
	 */
	public void setDoilPrc(String doilPrc) {
		this.doilPrc = doilPrc;
	}
	
	/**
	 * Column Info
	 * @param fletAccTpCd
	 */
	public void setFletAccTpCd(String fletAccTpCd) {
		this.fletAccTpCd = fletAccTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgOnhDt
	 */
	public void setOrgOnhDt(String orgOnhDt) {
		this.orgOnhDt = orgOnhDt;
	}
	
	/**
	 * Column Info
	 * @param offhDt
	 */
	public void setOffhDt(String offhDt) {
		this.offhDt = offhDt;
	}
	
	/**
	 * Column Info
	 * @param offhRsn
	 */
	public void setOffhRsn(String offhRsn) {
		this.offhRsn = offhRsn;
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
	 * @param orgOffhDt
	 */
	public void setOrgOffhDt(String orgOffhDt) {
		this.orgOffhDt = orgOffhDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCsrSlpFlg(JSPUtil.getParameter(request, "csr_slp_flg", ""));
		setOffhDurDys(JSPUtil.getParameter(request, "offh_dur_dys", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setFoilQty(JSPUtil.getParameter(request, "foil_qty", ""));
		setOffhDesc(JSPUtil.getParameter(request, "offh_desc", ""));
		setDoilQty(JSPUtil.getParameter(request, "doil_qty", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFoilPrc(JSPUtil.getParameter(request, "foil_prc", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOffhSeq(JSPUtil.getParameter(request, "offh_seq", ""));
		setDoilPrc(JSPUtil.getParameter(request, "doil_prc", ""));
		setFletAccTpCd(JSPUtil.getParameter(request, "flet_acc_tp_cd", ""));
		setOrgOnhDt(JSPUtil.getParameter(request, "org_onh_dt", ""));
		setOffhDt(JSPUtil.getParameter(request, "offh_dt", ""));
		setOffhRsn(JSPUtil.getParameter(request, "offh_rsn", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOrgOffhDt(JSPUtil.getParameter(request, "org_offh_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomOffHireExpenseInterfaceVO[]
	 */
	public CustomOffHireExpenseInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomOffHireExpenseInterfaceVO[]
	 */
	public CustomOffHireExpenseInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomOffHireExpenseInterfaceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] csrSlpFlg = (JSPUtil.getParameter(request, prefix	+ "csr_slp_flg", length));
			String[] offhDurDys = (JSPUtil.getParameter(request, prefix	+ "offh_dur_dys", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] foilQty = (JSPUtil.getParameter(request, prefix	+ "foil_qty", length));
			String[] offhDesc = (JSPUtil.getParameter(request, prefix	+ "offh_desc", length));
			String[] doilQty = (JSPUtil.getParameter(request, prefix	+ "doil_qty", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] foilPrc = (JSPUtil.getParameter(request, prefix	+ "foil_prc", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] offhSeq = (JSPUtil.getParameter(request, prefix	+ "offh_seq", length));
			String[] doilPrc = (JSPUtil.getParameter(request, prefix	+ "doil_prc", length));
			String[] fletAccTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_acc_tp_cd", length));
			String[] orgOnhDt = (JSPUtil.getParameter(request, prefix	+ "org_onh_dt", length));
			String[] offhDt = (JSPUtil.getParameter(request, prefix	+ "offh_dt", length));
			String[] offhRsn = (JSPUtil.getParameter(request, prefix	+ "offh_rsn", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] orgOffhDt = (JSPUtil.getParameter(request, prefix	+ "org_offh_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomOffHireExpenseInterfaceVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (csrSlpFlg[i] != null)
					model.setCsrSlpFlg(csrSlpFlg[i]);
				if (offhDurDys[i] != null)
					model.setOffhDurDys(offhDurDys[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (foilQty[i] != null)
					model.setFoilQty(foilQty[i]);
				if (offhDesc[i] != null)
					model.setOffhDesc(offhDesc[i]);
				if (doilQty[i] != null)
					model.setDoilQty(doilQty[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (foilPrc[i] != null)
					model.setFoilPrc(foilPrc[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (offhSeq[i] != null)
					model.setOffhSeq(offhSeq[i]);
				if (doilPrc[i] != null)
					model.setDoilPrc(doilPrc[i]);
				if (fletAccTpCd[i] != null)
					model.setFletAccTpCd(fletAccTpCd[i]);
				if (orgOnhDt[i] != null)
					model.setOrgOnhDt(orgOnhDt[i]);
				if (offhDt[i] != null)
					model.setOffhDt(offhDt[i]);
				if (offhRsn[i] != null)
					model.setOffhRsn(offhRsn[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (orgOffhDt[i] != null)
					model.setOrgOffhDt(orgOffhDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomOffHireExpenseInterfaceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomOffHireExpenseInterfaceVO[]
	 */
	public CustomOffHireExpenseInterfaceVO[] getCustomOffHireExpenseInterfaceVOs(){
		CustomOffHireExpenseInterfaceVO[] vos = (CustomOffHireExpenseInterfaceVO[])models.toArray(new CustomOffHireExpenseInterfaceVO[models.size()]);
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
		this.csrSlpFlg = this.csrSlpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDurDys = this.offhDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilQty = this.foilQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDesc = this.offhDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilQty = this.doilQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilPrc = this.foilPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSeq = this.offhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilPrc = this.doilPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletAccTpCd = this.fletAccTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOnhDt = this.orgOnhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhDt = this.offhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRsn = this.offhRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgOffhDt = this.orgOffhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
