/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondCalOffhireInvoiceVO.java
*@FileTitle : CondCalOffhireInvoiceVO
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

public class CondCalOffhireInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondCalOffhireInvoiceVO> models = new ArrayList<CondCalOffhireInvoiceVO>();
	
	/* Column Info */
	private String effDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String acmmFlg = null;
	/* Column Info */
	private String acmmRtAmt = null;
	/* Column Info */
	private String bunkerVvd = null;
	/* Column Info */
	private String invUsdDys = null;
	/* Column Info */
	private String fletBrogRtAmt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String brogFlg = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String oriEffDt = null;
	/* Column Info */
	private String oriExpDt = null;
	/* Column Info */
	private String offhSeq = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fletOffhRsnCd = null;
	
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
	public CondCalOffhireInvoiceVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String effDt, String acmmRtAmt, String bunkerVvd, String fletBrogRtAmt, String invUsdDys, String expDt, String fletCtrtNo, String acmmFlg, String brogFlg, String oriEffDt, String oriExpDt, String offhSeq, String vslCd
	 * @return 
	 */
	public CondCalOffhireInvoiceVO(String ibflag, String pagerows, String effDt, String acmmRtAmt, String bunkerVvd, String fletBrogRtAmt, String invUsdDys, String expDt, String fletCtrtNo, String acmmFlg, String brogFlg, String oriEffDt, String oriExpDt, String offhSeq, String vslCd, String fletOffhRsnCd) {
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.acmmFlg = acmmFlg;
		this.acmmRtAmt = acmmRtAmt;
		this.bunkerVvd = bunkerVvd;
		this.invUsdDys = invUsdDys;
		this.fletBrogRtAmt = fletBrogRtAmt;
		this.expDt = expDt;
		this.brogFlg = brogFlg;
		this.fletCtrtNo = fletCtrtNo;
		this.oriEffDt = oriEffDt;
		this.oriExpDt = oriExpDt;
		this.offhSeq = offhSeq;
		this.vslCd = vslCd;
		this.fletOffhRsnCd = fletOffhRsnCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acmm_flg", getAcmmFlg());
		this.hashColumns.put("acmm_rt_amt", getAcmmRtAmt());
		this.hashColumns.put("bunker_vvd", getBunkerVvd());
		this.hashColumns.put("inv_usd_dys", getInvUsdDys());
		this.hashColumns.put("flet_brog_rt_amt", getFletBrogRtAmt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("brog_flg", getBrogFlg());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("ori_eff_dt", getOriEffDt());
		this.hashColumns.put("ori_exp_dt", getOriExpDt());
		this.hashColumns.put("offh_seq", getOffhSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("flet_offh_rsn_cd", getFletOffhRsnCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acmm_flg", "acmmFlg");
		this.hashFields.put("acmm_rt_amt", "acmmRtAmt");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("inv_usd_dys", "invUsdDys");
		this.hashFields.put("flet_brog_rt_amt", "fletBrogRtAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("brog_flg", "brogFlg");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("ori_eff_dt", "oriEffDt");
		this.hashFields.put("ori_exp_dt", "oriExpDt");
		this.hashFields.put("offh_seq", "offhSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("flet_offh_rsn_cd", "fletOffhRsnCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	public String getAcmmRtAmt() {
		return this.acmmRtAmt;
	}
	public String getBunkerVvd() {
		return this.bunkerVvd;
	}
	public String getInvUsdDys() {
		return this.invUsdDys;
	}
	public String getFletBrogRtAmt() {
		return this.fletBrogRtAmt;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getBrogFlg() {
		return this.brogFlg;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getOriEffDt() {
		return this.oriEffDt;
	}
	public String getOriExpDt() {
		return this.oriExpDt;
	}
	public String getOffhSeq() {
		return this.offhSeq;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getFletOffhRsnCd() {
		return this.fletOffhRsnCd;
	}
	public String getPagerows() {
		return this.pagerows;
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
	public void setAcmmRtAmt(String acmmRtAmt) {
		this.acmmRtAmt = acmmRtAmt;
		//this.acmmRtAmt=true;
	}
	public void setBunkerVvd(String bunkerVvd) {
		this.bunkerVvd = bunkerVvd;
		//this.bunkerVvd=true;
	}
	public void setInvUsdDys(String invUsdDys) {
		this.invUsdDys = invUsdDys;
		//this.invUsdDys=true;
	}
	public void setFletBrogRtAmt(String fletBrogRtAmt) {
		this.fletBrogRtAmt = fletBrogRtAmt;
		//this.fletBrogRtAmt=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setBrogFlg(String brogFlg) {
		this.brogFlg = brogFlg;
		//this.brogFlg=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setOriEffDt(String oriEffDt) {
		this.oriEffDt = oriEffDt;
		//this.oriEffDt=true;
	}
	public void setOriExpDt(String oriExpDt) {
		this.oriExpDt = oriExpDt;
		//this.oriExpDt=true;
	}
	public void setOffhSeq(String offhSeq) {
		this.offhSeq = offhSeq;
		//this.offhSeq=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setFletOffhRsnCd(String fletOffhRsnCd) {
		this.fletOffhRsnCd = fletOffhRsnCd;
		//this.fletOffhRsnCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcmmFlg(JSPUtil.getParameter(request, "acmm_flg", ""));
		setAcmmRtAmt(JSPUtil.getParameter(request, "acmm_rt_amt", ""));
		setBunkerVvd(JSPUtil.getParameter(request, "bunker_vvd", ""));
		setInvUsdDys(JSPUtil.getParameter(request, "inv_usd_dys", ""));
		setFletBrogRtAmt(JSPUtil.getParameter(request, "flet_brog_rt_amt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setBrogFlg(JSPUtil.getParameter(request, "brog_flg", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setOriEffDt(JSPUtil.getParameter(request, "ori_eff_dt", ""));
		setOriExpDt(JSPUtil.getParameter(request, "ori_exp_dt", ""));
		setOffhSeq(JSPUtil.getParameter(request, "offh_seq", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setFletOffhRsnCd(JSPUtil.getParameter(request, "flet_offh_rsn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CondCalOffhireInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CondCalOffhireInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondCalOffhireInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] acmmFlg = (JSPUtil.getParameter(request, prefix	+ "acmm_flg".trim(), length));
			String[] acmmRtAmt = (JSPUtil.getParameter(request, prefix	+ "acmm_rt_amt".trim(), length));
			String[] bunkerVvd = (JSPUtil.getParameter(request, prefix	+ "bunker_vvd".trim(), length));
			String[] invUsdDys = (JSPUtil.getParameter(request, prefix	+ "inv_usd_dys".trim(), length));
			String[] fletBrogRtAmt = (JSPUtil.getParameter(request, prefix	+ "flet_brog_rt_amt".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] brogFlg = (JSPUtil.getParameter(request, prefix	+ "brog_flg".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] oriEffDt = (JSPUtil.getParameter(request, prefix	+ "ori_eff_dt".trim(), length));
			String[] oriExpDt = (JSPUtil.getParameter(request, prefix	+ "ori_exp_dt".trim(), length));
			String[] offhSeq = (JSPUtil.getParameter(request, prefix	+ "offh_seq".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] fletOffhRsnCd = (JSPUtil.getParameter(request, prefix	+ "flet_offh_rsn_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondCalOffhireInvoiceVO();
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acmmFlg[i] != null)
					model.setAcmmFlg(acmmFlg[i]);
				if (acmmRtAmt[i] != null)
					model.setAcmmRtAmt(acmmRtAmt[i]);
				if (bunkerVvd[i] != null)
					model.setBunkerVvd(bunkerVvd[i]);
				if (invUsdDys[i] != null)
					model.setInvUsdDys(invUsdDys[i]);
				if (fletBrogRtAmt[i] != null)
					model.setFletBrogRtAmt(fletBrogRtAmt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (brogFlg[i] != null)
					model.setBrogFlg(brogFlg[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (oriEffDt[i] != null)
					model.setOriEffDt(oriEffDt[i]);
				if (oriExpDt[i] != null)
					model.setOriExpDt(oriExpDt[i]);
				if (offhSeq[i] != null)
					model.setOffhSeq(offhSeq[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fletOffhRsnCd[i] != null)
					model.setFletOffhRsnCd(fletOffhRsnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCondCalOffhireInvoiceVOs();
	}

	public CondCalOffhireInvoiceVO[] getCondCalOffhireInvoiceVOs(){
		CondCalOffhireInvoiceVO[] vos = (CondCalOffhireInvoiceVO[])models.toArray(new CondCalOffhireInvoiceVO[models.size()]);
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
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmFlg = this.acmmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmRtAmt = this.acmmRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd = this.bunkerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdDys = this.invUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletBrogRtAmt = this.fletBrogRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFlg = this.brogFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriEffDt = this.oriEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriExpDt = this.oriExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhSeq = this.offhSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOffhRsnCd = this.fletOffhRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
