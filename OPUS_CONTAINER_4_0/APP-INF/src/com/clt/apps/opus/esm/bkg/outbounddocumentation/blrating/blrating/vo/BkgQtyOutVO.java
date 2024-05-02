/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgQtyOutVO.java
*@FileTitle : BkgQtyOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.03 이진서
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgQtyOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgQtyOutVO> models = new ArrayList<BkgQtyOutVO>();

	/* Column Info */
	private String dcgoQty = null;
	/* Column Info */
	private String crrHngrSglBarQty = null;
	/* Column Info */
	private String eqSubstCgoQty = null;
	/* Column Info */
	private String awkCgoQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crrHngrDblBarQty = null;
	/* Column Info */
	private String eqSubstCntrTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rcQty = null;
	/* Column Info */
	private String bbCgoQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String merHngrQty = null;
	/* Column Info */
	private String drQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgQtyOutVO() {}

	public BkgQtyOutVO(String ibflag, String pagerows, String bkgNo, String cntrTpszCd, String opCntrQty, String drQty, String rcQty, String awkCgoQty, String bbCgoQty, String dcgoQty, String imdgClssCd, String eqSubstCntrTpszCd, String eqSubstCgoQty, String crrHngrSglBarQty, String crrHngrDblBarQty, String merHngrQty) {
		this.dcgoQty = dcgoQty;
		this.crrHngrSglBarQty = crrHngrSglBarQty;
		this.eqSubstCgoQty = eqSubstCgoQty;
		this.awkCgoQty = awkCgoQty;
		this.pagerows = pagerows;
		this.crrHngrDblBarQty = crrHngrDblBarQty;
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rcQty = rcQty;
		this.bbCgoQty = bbCgoQty;
		this.cntrTpszCd = cntrTpszCd;
		this.opCntrQty = opCntrQty;
		this.imdgClssCd = imdgClssCd;
		this.merHngrQty = merHngrQty;
		this.drQty = drQty;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dcgo_qty", getDcgoQty());
		this.hashColumns.put("crr_hngr_sgl_bar_qty", getCrrHngrSglBarQty());
		this.hashColumns.put("eq_subst_cgo_qty", getEqSubstCgoQty());
		this.hashColumns.put("awk_cgo_qty", getAwkCgoQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crr_hngr_dbl_bar_qty", getCrrHngrDblBarQty());
		this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rc_qty", getRcQty());
		this.hashColumns.put("bb_cgo_qty", getBbCgoQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("mer_hngr_qty", getMerHngrQty());
		this.hashColumns.put("dr_qty", getDrQty());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dcgo_qty", "dcgoQty");
		this.hashFields.put("crr_hngr_sgl_bar_qty", "crrHngrSglBarQty");
		this.hashFields.put("eq_subst_cgo_qty", "eqSubstCgoQty");
		this.hashFields.put("awk_cgo_qty", "awkCgoQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crr_hngr_dbl_bar_qty", "crrHngrDblBarQty");
		this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rc_qty", "rcQty");
		this.hashFields.put("bb_cgo_qty", "bbCgoQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("mer_hngr_qty", "merHngrQty");
		this.hashFields.put("dr_qty", "drQty");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return dcgoQty
	 */
	public String getDcgoQty() {
		return this.dcgoQty;
	}

	/**
	 * Column Info
	 * @return crrHngrSglBarQty
	 */
	public String getCrrHngrSglBarQty() {
		return this.crrHngrSglBarQty;
	}

	/**
	 * Column Info
	 * @return eqSubstCgoQty
	 */
	public String getEqSubstCgoQty() {
		return this.eqSubstCgoQty;
	}

	/**
	 * Column Info
	 * @return awkCgoQty
	 */
	public String getAwkCgoQty() {
		return this.awkCgoQty;
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
	 * @return crrHngrDblBarQty
	 */
	public String getCrrHngrDblBarQty() {
		return this.crrHngrDblBarQty;
	}

	/**
	 * Column Info
	 * @return eqSubstCntrTpszCd
	 */
	public String getEqSubstCntrTpszCd() {
		return this.eqSubstCntrTpszCd;
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
	 * @return rcQty
	 */
	public String getRcQty() {
		return this.rcQty;
	}

	/**
	 * Column Info
	 * @return bbCgoQty
	 */
	public String getBbCgoQty() {
		return this.bbCgoQty;
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
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}

	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}

	/**
	 * Column Info
	 * @return merHngrQty
	 */
	public String getMerHngrQty() {
		return this.merHngrQty;
	}

	/**
	 * Column Info
	 * @return drQty
	 */
	public String getDrQty() {
		return this.drQty;
	}


	/**
	 * Column Info
	 * @param dcgoQty
	 */
	public void setDcgoQty(String dcgoQty) {
		this.dcgoQty = dcgoQty;
	}

	/**
	 * Column Info
	 * @param crrHngrSglBarQty
	 */
	public void setCrrHngrSglBarQty(String crrHngrSglBarQty) {
		this.crrHngrSglBarQty = crrHngrSglBarQty;
	}

	/**
	 * Column Info
	 * @param eqSubstCgoQty
	 */
	public void setEqSubstCgoQty(String eqSubstCgoQty) {
		this.eqSubstCgoQty = eqSubstCgoQty;
	}

	/**
	 * Column Info
	 * @param awkCgoQty
	 */
	public void setAwkCgoQty(String awkCgoQty) {
		this.awkCgoQty = awkCgoQty;
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
	 * @param crrHngrDblBarQty
	 */
	public void setCrrHngrDblBarQty(String crrHngrDblBarQty) {
		this.crrHngrDblBarQty = crrHngrDblBarQty;
	}

	/**
	 * Column Info
	 * @param eqSubstCntrTpszCd
	 */
	public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
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
	 * @param rcQty
	 */
	public void setRcQty(String rcQty) {
		this.rcQty = rcQty;
	}

	/**
	 * Column Info
	 * @param bbCgoQty
	 */
	public void setBbCgoQty(String bbCgoQty) {
		this.bbCgoQty = bbCgoQty;
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
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}

	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * Column Info
	 * @param merHngrQty
	 */
	public void setMerHngrQty(String merHngrQty) {
		this.merHngrQty = merHngrQty;
	}

	/**
	 * Column Info
	 * @param drQty
	 */
	public void setDrQty(String drQty) {
		this.drQty = drQty;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDcgoQty(JSPUtil.getParameter(request, "dcgo_qty", ""));
		setCrrHngrSglBarQty(JSPUtil.getParameter(request, "crr_hngr_sgl_bar_qty", ""));
		setEqSubstCgoQty(JSPUtil.getParameter(request, "eq_subst_cgo_qty", ""));
		setAwkCgoQty(JSPUtil.getParameter(request, "awk_cgo_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCrrHngrDblBarQty(JSPUtil.getParameter(request, "crr_hngr_dbl_bar_qty", ""));
		setEqSubstCntrTpszCd(JSPUtil.getParameter(request, "eq_subst_cntr_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRcQty(JSPUtil.getParameter(request, "rc_qty", ""));
		setBbCgoQty(JSPUtil.getParameter(request, "bb_cgo_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setMerHngrQty(JSPUtil.getParameter(request, "mer_hngr_qty", ""));
		setDrQty(JSPUtil.getParameter(request, "dr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgQtyOutVO[]
	 */
	public BkgQtyOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgQtyOutVO[]
	 */
	public BkgQtyOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgQtyOutVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] dcgoQty = (JSPUtil.getParameter(request, prefix	+ "dcgo_qty", length));
			String[] crrHngrSglBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_sgl_bar_qty", length));
			String[] eqSubstCgoQty = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cgo_qty", length));
			String[] awkCgoQty = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crrHngrDblBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_dbl_bar_qty", length));
			String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cntr_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rcQty = (JSPUtil.getParameter(request, prefix	+ "rc_qty", length));
			String[] bbCgoQty = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] merHngrQty = (JSPUtil.getParameter(request, prefix	+ "mer_hngr_qty", length));
			String[] drQty = (JSPUtil.getParameter(request, prefix	+ "dr_qty", length));

			for (int i = 0; i < length; i++) {
				model = new BkgQtyOutVO();
				if (dcgoQty[i] != null)
					model.setDcgoQty(dcgoQty[i]);
				if (crrHngrSglBarQty[i] != null)
					model.setCrrHngrSglBarQty(crrHngrSglBarQty[i]);
				if (eqSubstCgoQty[i] != null)
					model.setEqSubstCgoQty(eqSubstCgoQty[i]);
				if (awkCgoQty[i] != null)
					model.setAwkCgoQty(awkCgoQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crrHngrDblBarQty[i] != null)
					model.setCrrHngrDblBarQty(crrHngrDblBarQty[i]);
				if (eqSubstCntrTpszCd[i] != null)
					model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rcQty[i] != null)
					model.setRcQty(rcQty[i]);
				if (bbCgoQty[i] != null)
					model.setBbCgoQty(bbCgoQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (merHngrQty[i] != null)
					model.setMerHngrQty(merHngrQty[i]);
				if (drQty[i] != null)
					model.setDrQty(drQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgQtyOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgQtyOutVO[]
	 */
	public BkgQtyOutVO[] getBkgQtyOutVOs(){
		BkgQtyOutVO[] vos = (BkgQtyOutVO[])models.toArray(new BkgQtyOutVO[models.size()]);
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
		this.dcgoQty = this.dcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrSglBarQty = this.crrHngrSglBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCgoQty = this.eqSubstCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoQty = this.awkCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrDblBarQty = this.crrHngrDblBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcQty = this.rcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoQty = this.bbCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.merHngrQty = this.merHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drQty = this.drQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
