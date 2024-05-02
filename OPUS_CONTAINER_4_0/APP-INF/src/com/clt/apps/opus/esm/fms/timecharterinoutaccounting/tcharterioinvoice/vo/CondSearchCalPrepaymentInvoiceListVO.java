/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchCalPrepaymentInvoiceListVO.java
*@FileTitle : CondSearchCalPrepaymentInvoiceListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.22 정윤태 
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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondSearchCalPrepaymentInvoiceListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchCalPrepaymentInvoiceListVO> models = new ArrayList<CondSearchCalPrepaymentInvoiceListVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String acmmFlg = null;
	/* Column Info */
	private String acmmRtAmt = null;
	/* Column Info */
	private String oriExpDt = null;
	/* Column Info */
	private String fletBrogRtAmt = null;
	/* Column Info */
	private String ppayHirNo = null;
	/* Column Info */
	private String oriEffDt = null;
	/* Column Info */
	private String brogFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String fletCtrtTpGb = null;
	/* Column Info */
	private String oriInvUsdDys = null;
	/* Column Info */
	private String invUsdDys = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String months = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CondSearchCalPrepaymentInvoiceListVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtTpGb, String oriInvUsdDys, String invUsdDys, String vslCd, String ppayHirNo, String effDt, String expDt, String fletCtrtNo, String oriEffDt, String oriExpDt, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg, String months
	 * @return 
	 */
	public CondSearchCalPrepaymentInvoiceListVO(String ibflag, String pagerows, String fletCtrtTpGb, String oriInvUsdDys, String invUsdDys, String vslCd, String ppayHirNo, String effDt, String expDt, String fletCtrtNo, String oriEffDt, String oriExpDt, String acmmRtAmt, String fletBrogRtAmt, String acmmFlg, String brogFlg, String months) {
		this.vslCd = vslCd;
		this.acmmFlg = acmmFlg;
		this.acmmRtAmt = acmmRtAmt;
		this.oriExpDt = oriExpDt;
		this.fletBrogRtAmt = fletBrogRtAmt;
		this.ppayHirNo = ppayHirNo;
		this.oriEffDt = oriEffDt;
		this.brogFlg = brogFlg;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.fletCtrtTpGb = fletCtrtTpGb;
		this.oriInvUsdDys = oriInvUsdDys;
		this.invUsdDys = invUsdDys;
		this.expDt = expDt;
		this.months = months;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("acmm_flg", getAcmmFlg());
		this.hashColumns.put("acmm_rt_amt", getAcmmRtAmt());
		this.hashColumns.put("ori_exp_dt", getOriExpDt());
		this.hashColumns.put("flet_brog_rt_amt", getFletBrogRtAmt());
		this.hashColumns.put("ppay_hir_no", getPpayHirNo());
		this.hashColumns.put("ori_eff_dt", getOriEffDt());
		this.hashColumns.put("brog_flg", getBrogFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("flet_ctrt_tp_gb", getFletCtrtTpGb());
		this.hashColumns.put("ori_inv_usd_dys", getOriInvUsdDys());
		this.hashColumns.put("inv_usd_dys", getInvUsdDys());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("months", getMonths());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("acmm_flg", "acmmFlg");
		this.hashFields.put("acmm_rt_amt", "acmmRtAmt");
		this.hashFields.put("ori_exp_dt", "oriExpDt");
		this.hashFields.put("flet_brog_rt_amt", "fletBrogRtAmt");
		this.hashFields.put("ppay_hir_no", "ppayHirNo");
		this.hashFields.put("ori_eff_dt", "oriEffDt");
		this.hashFields.put("brog_flg", "brogFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("flet_ctrt_tp_gb", "fletCtrtTpGb");
		this.hashFields.put("ori_inv_usd_dys", "oriInvUsdDys");
		this.hashFields.put("inv_usd_dys", "invUsdDys");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("months", "months");
		return this.hashFields;
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
	 * @return acmmFlg
	 */
	public String getAcmmFlg() {
		return this.acmmFlg;
	}
	
	/**
	 * Column Info
	 * @return acmmRtAmt
	 */
	public String getAcmmRtAmt() {
		return this.acmmRtAmt;
	}
	
	/**
	 * Column Info
	 * @return oriExpDt
	 */
	public String getOriExpDt() {
		return this.oriExpDt;
	}
	
	/**
	 * Column Info
	 * @return fletBrogRtAmt
	 */
	public String getFletBrogRtAmt() {
		return this.fletBrogRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ppayHirNo
	 */
	public String getPpayHirNo() {
		return this.ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @return oriEffDt
	 */
	public String getOriEffDt() {
		return this.oriEffDt;
	}
	
	/**
	 * Column Info
	 * @return brogFlg
	 */
	public String getBrogFlg() {
		return this.brogFlg;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtTpGb
	 */
	public String getFletCtrtTpGb() {
		return this.fletCtrtTpGb;
	}
	
	/**
	 * Column Info
	 * @return oriInvUsdDys
	 */
	public String getOriInvUsdDys() {
		return this.oriInvUsdDys;
	}
	
	/**
	 * Column Info
	 * @return invUsdDys
	 */
	public String getInvUsdDys() {
		return this.invUsdDys;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return months
	 */
	public String getMonths() {
		return this.months;
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
	 * @param acmmFlg
	 */
	public void setAcmmFlg(String acmmFlg) {
		this.acmmFlg = acmmFlg;
	}
	
	/**
	 * Column Info
	 * @param acmmRtAmt
	 */
	public void setAcmmRtAmt(String acmmRtAmt) {
		this.acmmRtAmt = acmmRtAmt;
	}
	
	/**
	 * Column Info
	 * @param oriExpDt
	 */
	public void setOriExpDt(String oriExpDt) {
		this.oriExpDt = oriExpDt;
	}
	
	/**
	 * Column Info
	 * @param fletBrogRtAmt
	 */
	public void setFletBrogRtAmt(String fletBrogRtAmt) {
		this.fletBrogRtAmt = fletBrogRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ppayHirNo
	 */
	public void setPpayHirNo(String ppayHirNo) {
		this.ppayHirNo = ppayHirNo;
	}
	
	/**
	 * Column Info
	 * @param oriEffDt
	 */
	public void setOriEffDt(String oriEffDt) {
		this.oriEffDt = oriEffDt;
	}
	
	/**
	 * Column Info
	 * @param brogFlg
	 */
	public void setBrogFlg(String brogFlg) {
		this.brogFlg = brogFlg;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param fletCtrtTpGb
	 */
	public void setFletCtrtTpGb(String fletCtrtTpGb) {
		this.fletCtrtTpGb = fletCtrtTpGb;
	}
	
	/**
	 * Column Info
	 * @param oriInvUsdDys
	 */
	public void setOriInvUsdDys(String oriInvUsdDys) {
		this.oriInvUsdDys = oriInvUsdDys;
	}
	
	/**
	 * Column Info
	 * @param invUsdDys
	 */
	public void setInvUsdDys(String invUsdDys) {
		this.invUsdDys = invUsdDys;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param months
	 */
	public void setMonths(String months) {
		this.months = months;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setAcmmFlg(JSPUtil.getParameter(request, "acmm_flg", ""));
		setAcmmRtAmt(JSPUtil.getParameter(request, "acmm_rt_amt", ""));
		setOriExpDt(JSPUtil.getParameter(request, "ori_exp_dt", ""));
		setFletBrogRtAmt(JSPUtil.getParameter(request, "flet_brog_rt_amt", ""));
		setPpayHirNo(JSPUtil.getParameter(request, "ppay_hir_no", ""));
		setOriEffDt(JSPUtil.getParameter(request, "ori_eff_dt", ""));
		setBrogFlg(JSPUtil.getParameter(request, "brog_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setFletCtrtTpGb(JSPUtil.getParameter(request, "flet_ctrt_tp_gb", ""));
		setOriInvUsdDys(JSPUtil.getParameter(request, "ori_inv_usd_dys", ""));
		setInvUsdDys(JSPUtil.getParameter(request, "inv_usd_dys", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setMonths(JSPUtil.getParameter(request, "months", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchCalPrepaymentInvoiceListVO[]
	 */
	public CondSearchCalPrepaymentInvoiceListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchCalPrepaymentInvoiceListVO[]
	 */
	public CondSearchCalPrepaymentInvoiceListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchCalPrepaymentInvoiceListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] acmmFlg = (JSPUtil.getParameter(request, prefix	+ "acmm_flg".trim(), length));
			String[] acmmRtAmt = (JSPUtil.getParameter(request, prefix	+ "acmm_rt_amt".trim(), length));
			String[] oriExpDt = (JSPUtil.getParameter(request, prefix	+ "ori_exp_dt".trim(), length));
			String[] fletBrogRtAmt = (JSPUtil.getParameter(request, prefix	+ "flet_brog_rt_amt".trim(), length));
			String[] ppayHirNo = (JSPUtil.getParameter(request, prefix	+ "ppay_hir_no".trim(), length));
			String[] oriEffDt = (JSPUtil.getParameter(request, prefix	+ "ori_eff_dt".trim(), length));
			String[] brogFlg = (JSPUtil.getParameter(request, prefix	+ "brog_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] fletCtrtTpGb = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_gb".trim(), length));
			String[] oriInvUsdDys = (JSPUtil.getParameter(request, prefix	+ "ori_inv_usd_dys".trim(), length));
			String[] invUsdDys = (JSPUtil.getParameter(request, prefix	+ "inv_usd_dys".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] months = (JSPUtil.getParameter(request, prefix	+ "months".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchCalPrepaymentInvoiceListVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (acmmFlg[i] != null)
					model.setAcmmFlg(acmmFlg[i]);
				if (acmmRtAmt[i] != null)
					model.setAcmmRtAmt(acmmRtAmt[i]);
				if (oriExpDt[i] != null)
					model.setOriExpDt(oriExpDt[i]);
				if (fletBrogRtAmt[i] != null)
					model.setFletBrogRtAmt(fletBrogRtAmt[i]);
				if (ppayHirNo[i] != null)
					model.setPpayHirNo(ppayHirNo[i]);
				if (oriEffDt[i] != null)
					model.setOriEffDt(oriEffDt[i]);
				if (brogFlg[i] != null)
					model.setBrogFlg(brogFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (fletCtrtTpGb[i] != null)
					model.setFletCtrtTpGb(fletCtrtTpGb[i]);
				if (oriInvUsdDys[i] != null)
					model.setOriInvUsdDys(oriInvUsdDys[i]);
				if (invUsdDys[i] != null)
					model.setInvUsdDys(invUsdDys[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (months[i] != null)
					model.setMonths(months[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchCalPrepaymentInvoiceListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchCalPrepaymentInvoiceListVO[]
	 */
	public CondSearchCalPrepaymentInvoiceListVO[] getCondSearchCalPrepaymentInvoiceListVOs(){
		CondSearchCalPrepaymentInvoiceListVO[] vos = (CondSearchCalPrepaymentInvoiceListVO[])models.toArray(new CondSearchCalPrepaymentInvoiceListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmFlg = this.acmmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmRtAmt = this.acmmRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriExpDt = this.oriExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletBrogRtAmt = this.fletBrogRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayHirNo = this.ppayHirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriEffDt = this.oriEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogFlg = this.brogFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpGb = this.fletCtrtTpGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oriInvUsdDys = this.oriInvUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdDys = this.invUsdDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.months = this.months .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
