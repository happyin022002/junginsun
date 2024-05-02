/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgChgeListVO.java
*@FileTitle : BkgChgeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.03 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgChgeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgChgeListVO> models = new ArrayList<BkgChgeListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String perTpCd = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String trfRtAmt = null;
	/* Column Info */
	private String ratAsCntrQty = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String tvaFlg = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String chgRmk = null;
	/* Page Number */
	private String userId = null;
	/* Page Number */
	private String mriMaxSeq = null;	
	/* Page Number */
	private String tjSrcNm = null;		
	/* Page Number */
	private String revType = null;
	/* Page Number */
	private String ofcCd = null;
	/* Page Number */
	private String subsCoCd = null;	
	/* Page Number */
	private String vvd = null;	
	/* Page Number */
	private String revVvd = null;	
	/* Page Number */
	private String acctDivCd = null;	
	/* Page Number */
	private String revCoaAcctCd = null;	
	/* Page Number */
	private String acctCd = null;
	/* Page Number */
	private String chgSeq = null;
	/* Page Number */
	private String arIfSerNo = null;
	
	/* Page Number */
	private String pagerows = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgChgeListVO() {}

	public BkgChgeListVO(String ibflag, String pagerows, String seq, String chgCd, String ratAsCntrQty, String trfRtAmt, String perTpCd, String currCd, String chgAmt, String chgRmk, String userId, String mriMaxSeq, String tjSrcNm, String revType, String ofcCd, String subsCoCd, String vvd, String revVvd, String acctDivCd, String revCoaAcctCd, String acctCd, String tvaFlg, String invXchRt, String chgSeq, String arIfSerNo) {
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.perTpCd = perTpCd;
		this.chgAmt = chgAmt;
		this.seq = seq;
		this.trfRtAmt = trfRtAmt;
		this.ratAsCntrQty = ratAsCntrQty;
		this.invXchRt = invXchRt;
		this.tvaFlg = tvaFlg;
		this.chgCd = chgCd;
		this.chgRmk = chgRmk;
		this.userId = userId;
		this.mriMaxSeq = mriMaxSeq;
		this.tjSrcNm = tjSrcNm;	
		this.revType = revType;
		this.ofcCd = ofcCd;
		this.subsCoCd = subsCoCd;
		this.vvd = vvd;
		this.revVvd = revVvd;
		this.acctDivCd = acctDivCd;
		this.revCoaAcctCd = revCoaAcctCd;
		this.acctCd = acctCd;
		this.chgSeq = chgSeq;
		this.arIfSerNo = arIfSerNo;
		
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("per_tp_cd", getPerTpCd());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("tva_flg", getTvaFlg());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("chg_rmk", getChgRmk());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("mri_max_seq", getMriMaxSeq());
		this.hashColumns.put("tj_src_nm", getTjSrcNm());
		this.hashColumns.put("rev_type", getRevType());	
		this.hashColumns.put("ofc_cd", getOfcCd());	
		this.hashColumns.put("subs_co_cd", getSubsCoCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("acct_div_cd", getAcctDivCd());	
		this.hashColumns.put("rev_coa_acct_cd", getRevCoaAcctCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());
				
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("chg_rmk", "chgRmk");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("mri_max_seq", "mriMaxSeq");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("subs_co_cd", "subsCoCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("acct_div_cd", "acctDivCd");
		this.hashFields.put("rev_coa_acct_cd", "revCoaAcctCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return perTpCd
	 */
	public String getPerTpCd() {
		return this.perTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return trfRtAmt
	 */
	public String getTrfRtAmt() {
		return this.trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ratAsCntrQty
	 */
	public String getRatAsCntrQty() {
		return this.ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return tvaFlg
	 */
	public String getTvaFlg() {
		return this.tvaFlg;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return chgRmk
	 */
	public String getChgRmk() {
		return this.chgRmk;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param perTpCd
	 */
	public void setPerTpCd(String perTpCd) {
		this.perTpCd = perTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param trfRtAmt
	 */
	public void setTrfRtAmt(String trfRtAmt) {
		this.trfRtAmt = trfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ratAsCntrQty
	 */
	public void setRatAsCntrQty(String ratAsCntrQty) {
		this.ratAsCntrQty = ratAsCntrQty;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param tvaFlg
	 */
	public void setTvaFlg(String tvaFlg) {
		this.tvaFlg = tvaFlg;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param chgRmk
	 */
	public void setChgRmk(String chgRmk) {
		this.chgRmk = chgRmk;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}	

	public String getMriMaxSeq() {
		return mriMaxSeq;
	}

	public void setMriMaxSeq(String mriMaxSeq) {
		this.mriMaxSeq = mriMaxSeq;
	}
    
	public String getTjSrcNm() {
		return tjSrcNm;
	}

	public void setTjSrcNm(String tjSrcNm) {
		this.tjSrcNm = tjSrcNm;
	}	

	public String getRevType() {
		return revType;
	}

	public void setRevType(String revType) {
		this.revType = revType;
	}
    
	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}	

	public String getSubsCoCd() {
		return subsCoCd;
	}

	public void setSubsCoCd(String subsCoCd) {
		this.subsCoCd = subsCoCd;
	}
    
	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getRevVvd() {
		return revVvd;
	}

	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}	

	public String getAcctDivCd() {
		return acctDivCd;
	}

	public void setAcctDivCd(String acctDivCd) {
		this.acctDivCd = acctDivCd;
	}
    
	public String getRevCoaAcctCd() {
		return revCoaAcctCd;
	}

	public void setRevCoaAcctCd(String revCoaAcctCd) {
		this.revCoaAcctCd = revCoaAcctCd;
	}

	public String getAcctCd() {
		return acctCd;
	}

	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}

	/**
	 * @return the chgSeq
	 */
	public String getChgSeq() {
		return chgSeq;
	}

	/**
	 * @param chgSeq the chgSeq to set
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}

	/**
	 * @return the arIfSerNo
	 */
	public String getArIfSerNo() {
		return arIfSerNo;
	}

	/**
	 * @param arIfSerNo the arIfSerNo to set
	 */
	public void setArIfSerNo(String arIfSerNo) {
		this.arIfSerNo = arIfSerNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request, "per_tp_cd", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setTrfRtAmt(JSPUtil.getParameter(request, "trf_rt_amt", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request, "rat_as_cntr_qty", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setTvaFlg(JSPUtil.getParameter(request, "tva_flg", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setChgRmk(JSPUtil.getParameter(request, "chg_rmk", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setMriMaxSeq(JSPUtil.getParameter(request, "mri_max_seq", ""));
		setTjSrcNm(JSPUtil.getParameter(request, "tj_src_nm", ""));
		setRevType(JSPUtil.getParameter(request, "rev_type", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSubsCoCd(JSPUtil.getParameter(request, "subs_co_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setAcctDivCd(JSPUtil.getParameter(request, "acct_div_cd", ""));
		setRevCoaAcctCd(JSPUtil.getParameter(request, "rev_coa_acct_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setChgSeq(JSPUtil.getParameter(request, "chg_seq", ""));
		setArIfSerNo(JSPUtil.getParameter(request, "ar_if_ser_no", ""));
		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgChgeListVO[]
	 */
	public BkgChgeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgChgeListVO[]
	 */
	public BkgChgeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgChgeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] perTpCd = (JSPUtil.getParameter(request, prefix	+ "per_tp_cd".trim(), length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt".trim(), length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq".trim(), length));
			String[] trfRtAmt = (JSPUtil.getParameter(request, prefix	+ "trf_rt_amt".trim(), length));
			String[] ratAsCntrQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_cntr_qty".trim(), length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt".trim(), length));
			String[] tvaFlg = (JSPUtil.getParameter(request, prefix	+ "tva_flg".trim(), length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd".trim(), length));
			String[] chgRmk = (JSPUtil.getParameter(request, prefix	+ "chg_rmk".trim(), length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id".trim(), length));
			String[] mriMaxSeq = (JSPUtil.getParameter(request, prefix	+ "mri_max_seq".trim(), length));
			String[] tjSrcNm = (JSPUtil.getParameter(request, prefix	+ "tj_src_nm".trim(), length));
			String[] revType = (JSPUtil.getParameter(request, prefix	+ "rev_type".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] subsCoCd = (JSPUtil.getParameter(request, prefix	+ "subs_co_cd".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd".trim(), length));
			String[] acctDivCd = (JSPUtil.getParameter(request, prefix	+ "acct_div_cd".trim(), length));
			String[] revCoaAcctCd = (JSPUtil.getParameter(request, prefix	+ "rev_coa_acct_cd".trim(), length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd".trim(), length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq".trim(), length));
			String[] arIfSerNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_ser_no".trim(), length));
			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgChgeListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (perTpCd[i] != null)
					model.setPerTpCd(perTpCd[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (trfRtAmt[i] != null)
					model.setTrfRtAmt(trfRtAmt[i]);
				if (ratAsCntrQty[i] != null)
					model.setRatAsCntrQty(ratAsCntrQty[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (tvaFlg[i] != null)
					model.setTvaFlg(tvaFlg[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (chgRmk[i] != null)
					model.setChgRmk(chgRmk[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (mriMaxSeq[i] != null)
					model.setMriMaxSeq(mriMaxSeq[i]);
				if (tjSrcNm[i] != null)
					model.setTjSrcNm(tjSrcNm[i]);
				if (revType[i] != null)
					model.setRevType(revType[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (subsCoCd[i] != null)
					model.setSubsCoCd(subsCoCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (acctDivCd[i] != null)
					model.setAcctDivCd(acctDivCd[i]);
				if (revCoaAcctCd[i] != null)
					model.setRevCoaAcctCd(revCoaAcctCd[i]);
				if (acctCd[i] != null)
					model.setRevCoaAcctCd(acctCd[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (arIfSerNo[i] != null)
					model.setArIfSerNo(arIfSerNo[i]);
				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgChgeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgChgeListVO[]
	 */
	public BkgChgeListVO[] getBkgChgeListVOs(){
		BkgChgeListVO[] vos = (BkgChgeListVO[])models.toArray(new BkgChgeListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd = this.perTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt = this.trfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty = this.ratAsCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg = this.tvaFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRmk = this.chgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mriMaxSeq = this.mriMaxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm = this.tjSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType = this.revType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsCoCd = this.subsCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDivCd = this.acctDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revCoaAcctCd = this.revCoaAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo = this.arIfSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
						
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
