/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsCntrModificationVO.java
*@FileTitle : RocsCntrModificationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.13
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.13 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsCntrModificationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsCntrModificationVO> models = new ArrayList<RocsCntrModificationVO>();
	
	/* Column Info */
	private String isoCntrTpszCd = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String pckDesc = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszDesc = null;
	/* Column Info */
	private String t1DocCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrWgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String vslCallRefNo = null;
	/* Column Info */
	private String  userId = null;
	/* Column Info */
	private String ofcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsCntrModificationVO() {}

	public RocsCntrModificationVO(String ibflag, String pagerows, String cntrNo, String cntrSealNo, 
			String cntrTpszCd, String isoCntrTpszCd, String cntrTpszDesc, String pckQty, 
			String pckTpCd, String pckDesc, String cntrMfWgt, String cntrWgtUtCd, String t1DocCd,
			String vslCallRefNo, String bkgNo, String bkgNoSplit, String userId, String ofcCd) {
		this.isoCntrTpszCd = isoCntrTpszCd;
		this.bkgNoSplit = bkgNoSplit;
		this.pckDesc = pckDesc;
		this.cntrMfWgt = cntrMfWgt;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrTpszDesc = cntrTpszDesc;
		this.t1DocCd = t1DocCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrWgtUtCd = cntrWgtUtCd;
		this.pckQty = pckQty;
		this.cntrSealNo = cntrSealNo;
		this.pckTpCd = pckTpCd;
		this.vslCallRefNo = vslCallRefNo;
		this.userId = userId;
		this.ofcCd = ofcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("iso_cntr_tpsz_cd", getIsoCntrTpszCd());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("pck_desc", getPckDesc());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_desc", getCntrTpszDesc());
		this.hashColumns.put("t1_doc_cd", getT1DocCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_wgt_ut_cd", getCntrWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("vsl_call_ref_no", getVslCallRefNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("ofc_cd", getOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("iso_cntr_tpsz_cd", "isoCntrTpszCd");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("pck_desc", "pckDesc");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_desc", "cntrTpszDesc");
		this.hashFields.put("t1_doc_cd", "t1DocCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_wgt_ut_cd", "cntrWgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("vsl_call_ref_no", "vslCallRefNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("ofc_cd", "ofcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return isoCntrTpszCd
	 */
	public String getUserId() {
		return this.userId;
	}
	/**
	 * Column Info
	 * @return isoCntrTpszCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	/**
	 * Column Info
	 * @return isoCntrTpszCd
	 */
	public String getIsoCntrTpszCd() {
		return this.isoCntrTpszCd;
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
	 * @return pckDesc
	 */
	public String getPckDesc() {
		return this.pckDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cntrTpszDesc
	 */
	public String getCntrTpszDesc() {
		return this.cntrTpszDesc;
	}
	
	/**
	 * Column Info
	 * @return t1DocCd
	 */
	public String getT1DocCd() {
		return this.t1DocCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtUtCd
	 */
	public String getCntrWgtUtCd() {
		return this.cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslCallRefNo
	 */
	public String getVslCallRefNo() {
		return this.vslCallRefNo;
	}
	

	/**
	 * Column Info
	 * @param isoCntrTpszCd
	 */
	public void setIsoCntrTpszCd(String isoCntrTpszCd) {
		this.isoCntrTpszCd = isoCntrTpszCd;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param pckDesc
	 */
	public void setPckDesc(String pckDesc) {
		this.pckDesc = pckDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrTpszDesc
	 */
	public void setCntrTpszDesc(String cntrTpszDesc) {
		this.cntrTpszDesc = cntrTpszDesc;
	}
	
	/**
	 * Column Info
	 * @param t1DocCd
	 */
	public void setT1DocCd(String t1DocCd) {
		this.t1DocCd = t1DocCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtUtCd
	 */
	public void setCntrWgtUtCd(String cntrWgtUtCd) {
		this.cntrWgtUtCd = cntrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslCallRefNo
	 */
	public void setVslCallRefNo(String vslCallRefNo) {
		this.vslCallRefNo = vslCallRefNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIsoCntrTpszCd(JSPUtil.getParameter(request, "iso_cntr_tpsz_cd", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setPckDesc(JSPUtil.getParameter(request, "pck_desc", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, "cntr_mf_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszDesc(JSPUtil.getParameter(request, "cntr_tpsz_desc", ""));
		setT1DocCd(JSPUtil.getParameter(request, "t1_doc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrWgtUtCd(JSPUtil.getParameter(request, "cntr_wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setCntrSealNo(JSPUtil.getParameter(request, "cntr_seal_no", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setVslCallRefNo(JSPUtil.getParameter(request, "vsl_call_ref_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchCntrListVO[]
	 */
	public RocsCntrModificationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchCntrListVO[]
	 */
	public RocsCntrModificationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsCntrModificationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] isoCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "iso_cntr_tpsz_cd".trim(), length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split".trim(), length));
			String[] pckDesc = (JSPUtil.getParameter(request, prefix	+ "pck_desc".trim(), length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntrTpszDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_desc".trim(), length));
			String[] t1DocCd = (JSPUtil.getParameter(request, prefix	+ "t1_doc_cd".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] cntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_ut_cd".trim(), length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty".trim(), length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no".trim(), length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd".trim(), length));
			String[] vslCallRefNo = (JSPUtil.getParameter(request, prefix	+ "vsl_call_ref_no".trim(), length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsCntrModificationVO();
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (isoCntrTpszCd[i] != null)
					model.setIsoCntrTpszCd(isoCntrTpszCd[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (pckDesc[i] != null)
					model.setPckDesc(pckDesc[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszDesc[i] != null)
					model.setCntrTpszDesc(cntrTpszDesc[i]);
				if (t1DocCd[i] != null)
					model.setT1DocCd(t1DocCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrWgtUtCd[i] != null)
					model.setCntrWgtUtCd(cntrWgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (vslCallRefNo[i] != null)
					model.setVslCallRefNo(vslCallRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsCntrModificationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchCntrListVO[]
	 */
	public RocsCntrModificationVO[] getRocsCntrModificationVOs(){
		RocsCntrModificationVO[] vos = (RocsCntrModificationVO[])models.toArray(new RocsCntrModificationVO[models.size()]);
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
		this.isoCntrTpszCd = this.isoCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDesc = this.pckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszDesc = this.cntrTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1DocCd = this.t1DocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUtCd = this.cntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallRefNo = this.vslCallRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
