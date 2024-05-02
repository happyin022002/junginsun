/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpusQtyDtlVO.java
*@FileTitle : OpusQtyDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.11.04 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpusQtyDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpusQtyDtlVO> models = new ArrayList<OpusQtyDtlVO>();
	
	/* Column Info */
	private String dryCgoFlg = null;
	/* Column Info */
	private String merHngrFlg = null;
	/* Column Info */
	private String crrHngrSglBarUseFlg = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String crrHngrFlg = null;
	/* Column Info */
	private String crrHngrTplBarUseFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String eqSubstCntrTpszCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String substSeq = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String crrHngrDblBarUseFlg = null;
	/* Column Info */
	private String rcFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpusQtyDtlVO() {}

	public OpusQtyDtlVO(String ibflag, String pagerows, String bkgNo, String cntrTpszCd, String substSeq, String rcvTermCd, String deTermCd, String opCntrQty, String awkCgoFlg, String dcgoFlg, String rcFlg, String bbCgoFlg, String socFlg, String crrHngrSglBarUseFlg, String crrHngrDblBarUseFlg, String crrHngrTplBarUseFlg, String eqSubstCntrTpszCd, String dryCgoFlg, String crrHngrFlg, String merHngrFlg) {
		this.dryCgoFlg = dryCgoFlg;
		this.merHngrFlg = merHngrFlg;
		this.crrHngrSglBarUseFlg = crrHngrSglBarUseFlg;
		this.awkCgoFlg = awkCgoFlg;
		this.crrHngrFlg = crrHngrFlg;
		this.crrHngrTplBarUseFlg = crrHngrTplBarUseFlg;
		this.pagerows = pagerows;
		this.socFlg = socFlg;
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.substSeq = substSeq;
		this.bbCgoFlg = bbCgoFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.dcgoFlg = dcgoFlg;
		this.opCntrQty = opCntrQty;
		this.rcvTermCd = rcvTermCd;
		this.crrHngrDblBarUseFlg = crrHngrDblBarUseFlg;
		this.rcFlg = rcFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dry_cgo_flg", getDryCgoFlg());
		this.hashColumns.put("mer_hngr_flg", getMerHngrFlg());
		this.hashColumns.put("crr_hngr_sgl_bar_use_flg", getCrrHngrSglBarUseFlg());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("crr_hngr_flg", getCrrHngrFlg());
		this.hashColumns.put("crr_hngr_tpl_bar_use_flg", getCrrHngrTplBarUseFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("subst_seq", getSubstSeq());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("crr_hngr_dbl_bar_use_flg", getCrrHngrDblBarUseFlg());
		this.hashColumns.put("rc_flg", getRcFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dry_cgo_flg", "dryCgoFlg");
		this.hashFields.put("mer_hngr_flg", "merHngrFlg");
		this.hashFields.put("crr_hngr_sgl_bar_use_flg", "crrHngrSglBarUseFlg");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("crr_hngr_flg", "crrHngrFlg");
		this.hashFields.put("crr_hngr_tpl_bar_use_flg", "crrHngrTplBarUseFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("subst_seq", "substSeq");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("crr_hngr_dbl_bar_use_flg", "crrHngrDblBarUseFlg");
		this.hashFields.put("rc_flg", "rcFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dryCgoFlg
	 */
	public String getDryCgoFlg() {
		return this.dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return merHngrFlg
	 */
	public String getMerHngrFlg() {
		return this.merHngrFlg;
	}
	
	/**
	 * Column Info
	 * @return crrHngrSglBarUseFlg
	 */
	public String getCrrHngrSglBarUseFlg() {
		return this.crrHngrSglBarUseFlg;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return crrHngrFlg
	 */
	public String getCrrHngrFlg() {
		return this.crrHngrFlg;
	}
	
	/**
	 * Column Info
	 * @return crrHngrTplBarUseFlg
	 */
	public String getCrrHngrTplBarUseFlg() {
		return this.crrHngrTplBarUseFlg;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return eqSubstCntrTpszCd
	 */
	public String getEqSubstCntrTpszCd() {
		return this.eqSubstCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return substSeq
	 */
	public String getSubstSeq() {
		return this.substSeq;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return crrHngrDblBarUseFlg
	 */
	public String getCrrHngrDblBarUseFlg() {
		return this.crrHngrDblBarUseFlg;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	

	/**
	 * Column Info
	 * @param dryCgoFlg
	 */
	public void setDryCgoFlg(String dryCgoFlg) {
		this.dryCgoFlg = dryCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param merHngrFlg
	 */
	public void setMerHngrFlg(String merHngrFlg) {
		this.merHngrFlg = merHngrFlg;
	}
	
	/**
	 * Column Info
	 * @param crrHngrSglBarUseFlg
	 */
	public void setCrrHngrSglBarUseFlg(String crrHngrSglBarUseFlg) {
		this.crrHngrSglBarUseFlg = crrHngrSglBarUseFlg;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param crrHngrFlg
	 */
	public void setCrrHngrFlg(String crrHngrFlg) {
		this.crrHngrFlg = crrHngrFlg;
	}
	
	/**
	 * Column Info
	 * @param crrHngrTplBarUseFlg
	 */
	public void setCrrHngrTplBarUseFlg(String crrHngrTplBarUseFlg) {
		this.crrHngrTplBarUseFlg = crrHngrTplBarUseFlg;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param eqSubstCntrTpszCd
	 */
	public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param substSeq
	 */
	public void setSubstSeq(String substSeq) {
		this.substSeq = substSeq;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param crrHngrDblBarUseFlg
	 */
	public void setCrrHngrDblBarUseFlg(String crrHngrDblBarUseFlg) {
		this.crrHngrDblBarUseFlg = crrHngrDblBarUseFlg;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDryCgoFlg(JSPUtil.getParameter(request, "dry_cgo_flg", ""));
		setMerHngrFlg(JSPUtil.getParameter(request, "mer_hngr_flg", ""));
		setCrrHngrSglBarUseFlg(JSPUtil.getParameter(request, "crr_hngr_sgl_bar_use_flg", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setCrrHngrFlg(JSPUtil.getParameter(request, "crr_hngr_flg", ""));
		setCrrHngrTplBarUseFlg(JSPUtil.getParameter(request, "crr_hngr_tpl_bar_use_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setEqSubstCntrTpszCd(JSPUtil.getParameter(request, "eq_subst_cntr_tpsz_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSubstSeq(JSPUtil.getParameter(request, "subst_seq", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setCrrHngrDblBarUseFlg(JSPUtil.getParameter(request, "crr_hngr_dbl_bar_use_flg", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpusQtyDtlVO[]
	 */
	public OpusQtyDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpusQtyDtlVO[]
	 */
	public OpusQtyDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpusQtyDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dryCgoFlg = (JSPUtil.getParameter(request, prefix	+ "dry_cgo_flg", length));
			String[] merHngrFlg = (JSPUtil.getParameter(request, prefix	+ "mer_hngr_flg", length));
			String[] crrHngrSglBarUseFlg = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_sgl_bar_use_flg", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] crrHngrFlg = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_flg", length));
			String[] crrHngrTplBarUseFlg = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_tpl_bar_use_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cntr_tpsz_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] substSeq = (JSPUtil.getParameter(request, prefix	+ "subst_seq", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] crrHngrDblBarUseFlg = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_dbl_bar_use_flg", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpusQtyDtlVO();
				if (dryCgoFlg[i] != null)
					model.setDryCgoFlg(dryCgoFlg[i]);
				if (merHngrFlg[i] != null)
					model.setMerHngrFlg(merHngrFlg[i]);
				if (crrHngrSglBarUseFlg[i] != null)
					model.setCrrHngrSglBarUseFlg(crrHngrSglBarUseFlg[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (crrHngrFlg[i] != null)
					model.setCrrHngrFlg(crrHngrFlg[i]);
				if (crrHngrTplBarUseFlg[i] != null)
					model.setCrrHngrTplBarUseFlg(crrHngrTplBarUseFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (eqSubstCntrTpszCd[i] != null)
					model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (substSeq[i] != null)
					model.setSubstSeq(substSeq[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (crrHngrDblBarUseFlg[i] != null)
					model.setCrrHngrDblBarUseFlg(crrHngrDblBarUseFlg[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpusQtyDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpusQtyDtlVO[]
	 */
	public OpusQtyDtlVO[] getOpusQtyDtlVOs(){
		OpusQtyDtlVO[] vos = (OpusQtyDtlVO[])models.toArray(new OpusQtyDtlVO[models.size()]);
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
		this.dryCgoFlg = this.dryCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.merHngrFlg = this.merHngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrSglBarUseFlg = this.crrHngrSglBarUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrFlg = this.crrHngrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrTplBarUseFlg = this.crrHngrTplBarUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substSeq = this.substSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrDblBarUseFlg = this.crrHngrDblBarUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
