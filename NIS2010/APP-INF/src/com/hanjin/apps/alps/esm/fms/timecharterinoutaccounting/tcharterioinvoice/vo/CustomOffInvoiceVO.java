/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomOffInvoiceVO.java
*@FileTitle : CustomOffInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.08 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0014HTMLAction
 */

public class CustomOffInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomOffInvoiceVO> models = new ArrayList<CustomOffInvoiceVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String offhSeq = null;
	/* Column Info */
	private String effDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String acmmFlg = null;
	/* Column Info */
	private String invUsdDys = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String brogFlg = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Inpo */
	private String bunkerVvd = null;
	/* Column Inpo */
	private String fletOffhRsnCd = null;
	/* Column Inpo */
	private String invSeq = null;
	/* Column Inpo */
	private String oriEffDt = null;
	/* Column Inpo */
	private String oriExpDt = null;
	/* Column Inpo */
	private String invDesc = null;
	
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CustomOffInvoiceVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String effDt, String expDt, String invUsdDys, String offhSeq, String acmmFlg, String brogFlg, String vslCd, String creUsrId, String updUsrId, String bunkerVvd, String fletOffhRsnCd, String String invSeq, String oriEffDt, String oriExpDt, String invDesc
	 * @return 
	 */
	public CustomOffInvoiceVO(String ibflag, String pagerows, String fletCtrtNo, String effDt, String expDt, String invUsdDys, String offhSeq, String acmmFlg, String brogFlg, String vslCd, String creUsrId, String updUsrId, String bunkerVvd, String fletOffhRsnCd, String invSeq, String oriEffDt, String oriExpDt, String invDesc) {
		this.vslCd = vslCd;
		this.creUsrId = creUsrId;
		this.offhSeq = offhSeq;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.acmmFlg = acmmFlg;
		this.invUsdDys = invUsdDys;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.brogFlg = brogFlg;
		this.fletCtrtNo = fletCtrtNo;
		this.bunkerVvd = bunkerVvd;
		this.fletOffhRsnCd = fletOffhRsnCd;
		this.invSeq = invSeq;
		this.oriEffDt = oriEffDt;
		this.oriExpDt = oriExpDt;
		this.invDesc = invDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("offh_seq", getOffhSeq());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acmm_flg", getAcmmFlg());
		this.hashColumns.put("inv_usd_dys", getInvUsdDys());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("brog_flg", getBrogFlg());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("bunker_vvd", getBunkerVvd());
		this.hashColumns.put("flet_offh_rsn_cd", getFletOffhRsnCd());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("ori_eff_dt", getOriEffDt());
		this.hashColumns.put("ori_exp_dt", getOriExpDt());
		this.hashColumns.put("inv_desc", getInvDesc());
		this.hashColumns.put("pagerows", getPagerows());
		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("offh_seq", "offhSeq");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acmm_flg", "acmmFlg");
		this.hashFields.put("inv_usd_dys", "invUsdDys");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("brog_flg", "brogFlg");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("flet_offh_rsn_cd", "fletOffhRsnCd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("ori_eff_dt", "oriEffDt");
		this.hashFields.put("ori_exp_dt", "oriExpDt");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getVslCd() {
		return this.vslCd;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getOffhSeq() {
		return this.offhSeq;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getAcmmFlg() {
		return this.acmmFlg;
	}
	public String getInvUsdDys() {
		return this.invUsdDys;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getBrogFlg() {
		return this.brogFlg;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getBunkerVvd() {
		return this.bunkerVvd;
	}
	public String getFletOffhRsnCd() {
		return this.fletOffhRsnCd;
	}
	public String getInvSeq() {
		return this.invSeq;
	}
	public String getOriEffDt() {
		return this.oriEffDt;
	}
	public String getOriExpDt() {
		return this.oriExpDt;
	}
	public String getInvDesc() {
		return this.invDesc;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setOffhSeq(String offhSeq) {
		this.offhSeq = offhSeq;
		//this.offhSeq=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setAcmmFlg(String acmmFlg) {
		this.acmmFlg = acmmFlg;
		//this.acmmFlg=true;
	}
	public void setInvUsdDys(String invUsdDys) {
		this.invUsdDys = invUsdDys;
		//this.invUsdDys=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setBrogFlg(String brogFlg) {
		this.brogFlg = brogFlg;
		//this.brogFlg=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
		//this.bunkerVvd=true;
	}
	public void setFletOffhRsnCd(String fletOffhRsnCd) {
		this.fletOffhRsnCd = fletOffhRsnCd;
		//this.fletOffhRsnCd=true;
	}
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
		//this.invSeq=true;
	}
	public void setOriEffDt(String oriEffDt) {
		this.oriEffDt = oriEffDt;
		//this.oriEffDt=true;
	}
	public void setOriExpDt(String oriExpDt) {
		this.oriExpDt = oriExpDt;
		//this.oriExpDt=true;
	}
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc;
		//this.invDesc=true;
	}
	
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setOffhSeq(JSPUtil.getParameter(request, "offh_seq", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcmmFlg(JSPUtil.getParameter(request, "acmm_flg", ""));
		setInvUsdDys(JSPUtil.getParameter(request, "inv_usd_dys", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setBrogFlg(JSPUtil.getParameter(request, "brog_flg", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
		setFletOffhRsnCd(JSPUtil.getParameter(request, "flet_offh_rsn_cd", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setOriEffDt(JSPUtil.getParameter(request, "ori_eff_dt", ""));
		setOriExpDt(JSPUtil.getParameter(request, "ori_exp_dt", ""));
		setInvDesc(JSPUtil.getParameter(request, "inv_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomOffInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomOffInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomOffInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] offhSeq = (JSPUtil.getParameter(request, prefix	+ "offh_seq".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] acmmFlg = (JSPUtil.getParameter(request, prefix	+ "acmm_flg".trim(), length));
			String[] invUsdDys = (JSPUtil.getParameter(request, prefix	+ "inv_usd_dys".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] brogFlg = (JSPUtil.getParameter(request, prefix	+ "brog_flg".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd".trim(), length));
			String[] fletOffhRsnCd = (JSPUtil.getParameter(request, prefix	+ "flet_offh_rsn_cd".trim(), length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq".trim(), length));
			String[] oriEffDt = (JSPUtil.getParameter(request, prefix	+ "ori_eff_dt".trim(), length));
			String[] oriExpDt = (JSPUtil.getParameter(request, prefix	+ "ori_exp_dt".trim(), length));
			String[] invDesc = (JSPUtil.getParameter(request, prefix	+ "inv_desc".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomOffInvoiceVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (offhSeq[i] != null)
					model.setOffhSeq(offhSeq[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acmmFlg[i] != null)
					model.setAcmmFlg(acmmFlg[i]);
				if (invUsdDys[i] != null)
					model.setInvUsdDys(invUsdDys[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (brogFlg[i] != null)
					model.setBrogFlg(brogFlg[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (bunkerVvd[i] != null)
					model.setBunkerVvd(bunkerVvd[i]);
				if (fletOffhRsnCd[i] != null)
					model.setFletOffhRsnCd(fletOffhRsnCd[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (oriEffDt[i] != null)
					model.setOriEffDt(oriEffDt[i]);
				if (oriExpDt[i] != null)
					model.setOriExpDt(oriExpDt[i]);
				if (invDesc[i] != null)
					model.setInvDesc(invDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomOffInvoiceVOs();
	}

	public CustomOffInvoiceVO[] getCustomOffInvoiceVOs(){
		CustomOffInvoiceVO[] vos = (CustomOffInvoiceVO[])models.toArray(new CustomOffInvoiceVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSeq = this.offhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmFlg = this.acmmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdDys = this.invUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFlg = this.brogFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd = this.bunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOffhRsnCd = this.fletOffhRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriEffDt = this.oriEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriExpDt = this.oriExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc = this.invDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
