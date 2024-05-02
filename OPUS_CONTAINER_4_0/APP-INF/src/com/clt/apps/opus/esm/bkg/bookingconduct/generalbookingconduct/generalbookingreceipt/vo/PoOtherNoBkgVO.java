/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PoOtherNoBkgVO.java
*@FileTitle : PoOtherNoBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.07.03 이진서
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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

public class PoOtherNoBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PoOtherNoBkgVO> models = new ArrayList<PoOtherNoBkgVO>();

	/* Column Info */
	private String custRefNoCtnt = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String popuptpcd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgRefTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String xterRqstNo = null;
	private String caFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PoOtherNoBkgVO() {}

	public PoOtherNoBkgVO(String ibflag, String pagerows, String custRefNoCtnt, String refSeq, String bkgNo, String bkgRefTpCd, String cntrNo, String bkgNoSplit, String blNoTp, String blNo, String popuptpcd, String xterSndrId, String xterRqstNo, String xterRqstSeq, String caFlg) {
		this.custRefNoCtnt = custRefNoCtnt;
		this.xterSndrId = xterSndrId;
		this.bkgNoSplit = bkgNoSplit;
		this.blNo = blNo;
		this.popuptpcd = popuptpcd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.refSeq = refSeq;
		this.bkgNo = bkgNo;
		this.bkgRefTpCd = bkgRefTpCd;
		this.cntrNo = cntrNo;
		this.xterRqstSeq = xterRqstSeq;
		this.blNoTp = blNoTp;
		this.xterRqstNo = xterRqstNo;
		this.caFlg = caFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_ref_no_ctnt", getCustRefNoCtnt());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("popuptpcd", getPopuptpcd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_ref_tp_cd", getBkgRefTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("ca_flg", getCaFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_ref_no_ctnt", "custRefNoCtnt");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("popuptpcd", "popuptpcd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_ref_tp_cd", "bkgRefTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("ca_flg", "caFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return custRefNoCtnt
	 */
	public String getCustRefNoCtnt() {
		return this.custRefNoCtnt;
	}

	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}

	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return popuptpcd
	 */
	public String getPopuptpcd() {
		return this.popuptpcd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
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
	 * @return bkgRefTpCd
	 */
	public String getBkgRefTpCd() {
		return this.bkgRefTpCd;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}

	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}

	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}


	/**
	 * Column Info
	 * @param custRefNoCtnt
	 */
	public void setCustRefNoCtnt(String custRefNoCtnt) {
		this.custRefNoCtnt = custRefNoCtnt;
	}

	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}

	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param popuptpcd
	 */
	public void setPopuptpcd(String popuptpcd) {
		this.popuptpcd = popuptpcd;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
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
	 * @param bkgRefTpCd
	 */
	public void setBkgRefTpCd(String bkgRefTpCd) {
		this.bkgRefTpCd = bkgRefTpCd;
	}

	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}

	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}

	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * @return the caFlg
	 */
	public String getCaFlg() {
		return caFlg;
	}

	/**
	 * @param caFlg the caFlg to set
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustRefNoCtnt(JSPUtil.getParameter(request, "cust_ref_no_ctnt", ""));
		setXterSndrId(JSPUtil.getParameter(request, "xter_sndr_id", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPopuptpcd(JSPUtil.getParameter(request, "popuptpcd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgRefTpCd(JSPUtil.getParameter(request, "bkg_ref_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, "xter_rqst_seq", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setXterRqstNo(JSPUtil.getParameter(request, "xter_rqst_no", ""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PoOtherNoBkgVO[]
	 */
	public PoOtherNoBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PoOtherNoBkgVO[]
	 */
	public PoOtherNoBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PoOtherNoBkgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] custRefNoCtnt = (JSPUtil.getParameter(request, prefix	+ "cust_ref_no_ctnt", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] popuptpcd = (JSPUtil.getParameter(request, prefix	+ "popuptpcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgRefTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));

			for (int i = 0; i < length; i++) {
				model = new PoOtherNoBkgVO();
				if (custRefNoCtnt[i] != null)
					model.setCustRefNoCtnt(custRefNoCtnt[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (popuptpcd[i] != null)
					model.setPopuptpcd(popuptpcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgRefTpCd[i] != null)
					model.setBkgRefTpCd(bkgRefTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPoOtherNoBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PoOtherNoBkgVO[]
	 */
	public PoOtherNoBkgVO[] getPoOtherNoBkgVOs(){
		PoOtherNoBkgVO[] vos = (PoOtherNoBkgVO[])models.toArray(new PoOtherNoBkgVO[models.size()]);
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
		this.custRefNoCtnt = this.custRefNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.popuptpcd = this.popuptpcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefTpCd = this.bkgRefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
