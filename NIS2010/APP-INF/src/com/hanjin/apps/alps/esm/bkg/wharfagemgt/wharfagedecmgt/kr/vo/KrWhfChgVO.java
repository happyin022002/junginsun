/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfChgVO.java
*@FileTitle : KrWhfChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.16 민동진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfChgVO> models = new ArrayList<KrWhfChgVO>();
	
	/* Column Info */
	private String bkgRtWhfExptCd = null;
	/* Column Info */
	private String blCvrdTpCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String feuQty = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String hcbQty = null;
	/* Column Info */
	private String fHcbQty = null;
	/* Column Info */
	private String fFeuQty = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String teuQty = null;
	/* Column Info */
	private String amount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fTeuQty = null;
	/* Column Info */
	private String xptRefNo = null;
	/* Column Info */
	private String whfShprRgstNo = null;
	/* Column Info */
	private String ratAsQtySum = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfChgVO() {}

	public KrWhfChgVO(String ibflag, String pagerows, String bkgNo, String blNo, String custNm, String xptRefNo, String ratUtCd, String ratAsQtySum, String amount, String teuQty, String feuQty, String hcbQty, String blCvrdTpCd, String bkgRtWhfExptCd, String whfShprRgstNo, String blTpCd, String cntrSzCd, String fTeuQty, String fFeuQty, String fHcbQty) {
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
		this.blCvrdTpCd = blCvrdTpCd;
		this.custNm = custNm;
		this.feuQty = feuQty;
		this.cntrSzCd = cntrSzCd;
		this.hcbQty = hcbQty;
		this.fHcbQty = fHcbQty;
		this.fFeuQty = fFeuQty;
		this.ratUtCd = ratUtCd;
		this.blNo = blNo;
		this.blTpCd = blTpCd;
		this.pagerows = pagerows;
		this.teuQty = teuQty;
		this.amount = amount;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.fTeuQty = fTeuQty;
		this.xptRefNo = xptRefNo;
		this.whfShprRgstNo = whfShprRgstNo;
		this.ratAsQtySum = ratAsQtySum;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_rt_whf_expt_cd", getBkgRtWhfExptCd());
		this.hashColumns.put("bl_cvrd_tp_cd", getBlCvrdTpCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("feu_qty", getFeuQty());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("hcb_qty", getHcbQty());
		this.hashColumns.put("f_hcb_qty", getFHcbQty());
		this.hashColumns.put("f_feu_qty", getFFeuQty());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("teu_qty", getTeuQty());
		this.hashColumns.put("amount", getAmount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("f_teu_qty", getFTeuQty());
		this.hashColumns.put("xpt_ref_no", getXptRefNo());
		this.hashColumns.put("whf_shpr_rgst_no", getWhfShprRgstNo());
		this.hashColumns.put("rat_as_qty_sum", getRatAsQtySum());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_rt_whf_expt_cd", "bkgRtWhfExptCd");
		this.hashFields.put("bl_cvrd_tp_cd", "blCvrdTpCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("feu_qty", "feuQty");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("hcb_qty", "hcbQty");
		this.hashFields.put("f_hcb_qty", "fHcbQty");
		this.hashFields.put("f_feu_qty", "fFeuQty");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("teu_qty", "teuQty");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("f_teu_qty", "fTeuQty");
		this.hashFields.put("xpt_ref_no", "xptRefNo");
		this.hashFields.put("whf_shpr_rgst_no", "whfShprRgstNo");
		this.hashFields.put("rat_as_qty_sum", "ratAsQtySum");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgRtWhfExptCd
	 */
	public String getBkgRtWhfExptCd() {
		return this.bkgRtWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @return blCvrdTpCd
	 */
	public String getBlCvrdTpCd() {
		return this.blCvrdTpCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return feuQty
	 */
	public String getFeuQty() {
		return this.feuQty;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return hcbQty
	 */
	public String getHcbQty() {
		return this.hcbQty;
	}
	
	/**
	 * Column Info
	 * @return fHcbQty
	 */
	public String getFHcbQty() {
		return this.fHcbQty;
	}
	
	/**
	 * Column Info
	 * @return fFeuQty
	 */
	public String getFFeuQty() {
		return this.fFeuQty;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
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
	 * @return teuQty
	 */
	public String getTeuQty() {
		return this.teuQty;
	}
	
	/**
	 * Column Info
	 * @return amount
	 */
	public String getAmount() {
		return this.amount;
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
	 * @return fTeuQty
	 */
	public String getFTeuQty() {
		return this.fTeuQty;
	}
	
	/**
	 * Column Info
	 * @return xptRefNo
	 */
	public String getXptRefNo() {
		return this.xptRefNo;
	}
	
	/**
	 * Column Info
	 * @return whfShprRgstNo
	 */
	public String getWhfShprRgstNo() {
		return this.whfShprRgstNo;
	}
	
	/**
	 * Column Info
	 * @return ratAsQtySum
	 */
	public String getRatAsQtySum() {
		return this.ratAsQtySum;
	}
	

	/**
	 * Column Info
	 * @param bkgRtWhfExptCd
	 */
	public void setBkgRtWhfExptCd(String bkgRtWhfExptCd) {
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @param blCvrdTpCd
	 */
	public void setBlCvrdTpCd(String blCvrdTpCd) {
		this.blCvrdTpCd = blCvrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param feuQty
	 */
	public void setFeuQty(String feuQty) {
		this.feuQty = feuQty;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param hcbQty
	 */
	public void setHcbQty(String hcbQty) {
		this.hcbQty = hcbQty;
	}
	
	/**
	 * Column Info
	 * @param fHcbQty
	 */
	public void setFHcbQty(String fHcbQty) {
		this.fHcbQty = fHcbQty;
	}
	
	/**
	 * Column Info
	 * @param fFeuQty
	 */
	public void setFFeuQty(String fFeuQty) {
		this.fFeuQty = fFeuQty;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
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
	 * @param teuQty
	 */
	public void setTeuQty(String teuQty) {
		this.teuQty = teuQty;
	}
	
	/**
	 * Column Info
	 * @param amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
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
	 * @param fTeuQty
	 */
	public void setFTeuQty(String fTeuQty) {
		this.fTeuQty = fTeuQty;
	}
	
	/**
	 * Column Info
	 * @param xptRefNo
	 */
	public void setXptRefNo(String xptRefNo) {
		this.xptRefNo = xptRefNo;
	}
	
	/**
	 * Column Info
	 * @param whfShprRgstNo
	 */
	public void setWhfShprRgstNo(String whfShprRgstNo) {
		this.whfShprRgstNo = whfShprRgstNo;
	}
	
	/**
	 * Column Info
	 * @param ratAsQtySum
	 */
	public void setRatAsQtySum(String ratAsQtySum) {
		this.ratAsQtySum = ratAsQtySum;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgRtWhfExptCd(JSPUtil.getParameter(request, "bkg_rt_whf_expt_cd", ""));
		setBlCvrdTpCd(JSPUtil.getParameter(request, "bl_cvrd_tp_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setFeuQty(JSPUtil.getParameter(request, "feu_qty", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
		setHcbQty(JSPUtil.getParameter(request, "hcb_qty", ""));
		setFHcbQty(JSPUtil.getParameter(request, "f_hcb_qty", ""));
		setFFeuQty(JSPUtil.getParameter(request, "f_feu_qty", ""));
		setRatUtCd(JSPUtil.getParameter(request, "rat_ut_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTeuQty(JSPUtil.getParameter(request, "teu_qty", ""));
		setAmount(JSPUtil.getParameter(request, "amount", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setFTeuQty(JSPUtil.getParameter(request, "f_teu_qty", ""));
		setXptRefNo(JSPUtil.getParameter(request, "xpt_ref_no", ""));
		setWhfShprRgstNo(JSPUtil.getParameter(request, "whf_shpr_rgst_no", ""));
		setRatAsQtySum(JSPUtil.getParameter(request, "rat_as_qty_sum", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfChgVO[]
	 */
	public KrWhfChgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfChgVO[]
	 */
	public KrWhfChgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfChgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgRtWhfExptCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rt_whf_expt_cd", length));
			String[] blCvrdTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_cvrd_tp_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] feuQty = (JSPUtil.getParameter(request, prefix	+ "feu_qty", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] hcbQty = (JSPUtil.getParameter(request, prefix	+ "hcb_qty", length));
			String[] fHcbQty = (JSPUtil.getParameter(request, prefix	+ "f_hcb_qty", length));
			String[] fFeuQty = (JSPUtil.getParameter(request, prefix	+ "f_feu_qty", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] teuQty = (JSPUtil.getParameter(request, prefix	+ "teu_qty", length));
			String[] amount = (JSPUtil.getParameter(request, prefix	+ "amount", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fTeuQty = (JSPUtil.getParameter(request, prefix	+ "f_teu_qty", length));
			String[] xptRefNo = (JSPUtil.getParameter(request, prefix	+ "xpt_ref_no", length));
			String[] whfShprRgstNo = (JSPUtil.getParameter(request, prefix	+ "whf_shpr_rgst_no", length));
			String[] ratAsQtySum = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty_sum", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfChgVO();
				if (bkgRtWhfExptCd[i] != null)
					model.setBkgRtWhfExptCd(bkgRtWhfExptCd[i]);
				if (blCvrdTpCd[i] != null)
					model.setBlCvrdTpCd(blCvrdTpCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (feuQty[i] != null)
					model.setFeuQty(feuQty[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (hcbQty[i] != null)
					model.setHcbQty(hcbQty[i]);
				if (fHcbQty[i] != null)
					model.setFHcbQty(fHcbQty[i]);
				if (fFeuQty[i] != null)
					model.setFFeuQty(fFeuQty[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (teuQty[i] != null)
					model.setTeuQty(teuQty[i]);
				if (amount[i] != null)
					model.setAmount(amount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fTeuQty[i] != null)
					model.setFTeuQty(fTeuQty[i]);
				if (xptRefNo[i] != null)
					model.setXptRefNo(xptRefNo[i]);
				if (whfShprRgstNo[i] != null)
					model.setWhfShprRgstNo(whfShprRgstNo[i]);
				if (ratAsQtySum[i] != null)
					model.setRatAsQtySum(ratAsQtySum[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfChgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfChgVO[]
	 */
	public KrWhfChgVO[] getKrWhfChgVOs(){
		KrWhfChgVO[] vos = (KrWhfChgVO[])models.toArray(new KrWhfChgVO[models.size()]);
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
		this.bkgRtWhfExptCd = this.bkgRtWhfExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCvrdTpCd = this.blCvrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuQty = this.feuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcbQty = this.hcbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fHcbQty = this.fHcbQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFeuQty = this.fFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuQty = this.teuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount = this.amount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fTeuQty = this.fTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptRefNo = this.xptRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfShprRgstNo = this.whfShprRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQtySum = this.ratAsQtySum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
