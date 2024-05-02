/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SplitBlInfoVO.java
*@FileTitle : SplitBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.07 최영희
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
* 2012.02.27 정선용 [CHM-201215886-01] Split 기능 보완(eq tp,qty 추가)
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SplitBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SplitBlInfoVO> models = new ArrayList<SplitBlInfoVO>();

	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String advshtgcd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pc = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pctlNo =null;
	/* Column Info */
	private String rtnRoute = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String docTpCd = null;
	/* Column Info */
	private String oldBkgNo = null;
	/* Column Info */
	private String rdCgoFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SplitBlInfoVO() {}

	public SplitBlInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String tvvd, String actWgt, String wgtUtCd, String pckQty, String pckTpCd, String measQty, String measUtCd, String advshtgcd, String pc, String pctlNo, String rtnRoute,
		String xterSndrId, String xterRqstNo, String xterRqstSeq, String docTpCd, String oldBkgNo, String rdCgoFlg) {
		this.tvvd = tvvd;
		this.advshtgcd = advshtgcd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pc = pc;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.pctlNo=pctlNo;
		this.rtnRoute=rtnRoute;
		this.xterSndrId = xterSndrId;
		this.xterRqstNo = xterRqstNo;
		this.xterRqstSeq = xterRqstSeq;
		this.docTpCd = docTpCd;
		this.oldBkgNo = oldBkgNo;
		this.rdCgoFlg = rdCgoFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("adv_shtg_cd", getAdvshtgcd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pc", getPc());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("rtn_route", getRtnRoute());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("doc_tp_cd", getDocTpCd());
		this.hashColumns.put("old_bkg_no", getOldBkgNo());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("adv_shtg_cd", "advshtgcd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pc", "pc");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("rtn_route", "rtnRoute");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("old_bkg_no", "oldBkgNo");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}

	/**
	 * Column Info
	 * @return as
	 */
	public String getAdvshtgcd() {
		return this.advshtgcd;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}

	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}

	/**
	 * Column Info
	 * @return pc
	 */
	public String getPc() {
		return this.pc;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}

	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */	
	public String getPctlNo(){
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return rtnRoute
	 */
	public String getRtnRoute() {
		return rtnRoute;
	}

	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return xterSndrId;
	}

	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return xterRqstNo;
	}

	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return xterRqstSeq;
	}

	/**
	 * Column Info
	 * @return docTpCd
	 */
	public String getDocTpCd() {
		return docTpCd;
	}

	/**
	 * Column Info
	 * @return oldBkgNo
	 */
	public String getOldBkgNo() {
		return oldBkgNo;
	}

	public String getRdCgoFlg() {
		return rdCgoFlg;
	}

	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}

	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}

	/**
	 * Column Info
	 * @param as
	 */
	public void setAdvshtgcd(String advshtgcd) {
		this.advshtgcd = advshtgcd;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}

	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}

	/**
	 * Column Info
	 * @param pc
	 */
	public void setPc(String pc) {
		this.pc = pc;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo){
		this.pctlNo = pctlNo;
	}

	/**
	 * Column Info
	 * @param rtnRoute
	 */
	public void setRtnRoute(String rtnRoute) {
		this.rtnRoute = rtnRoute;
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
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
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
	 * @param docTpCd
	 */
	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
	}

	/**
	 * Column Info
	 * @param docTpCd
	 */
	public void setOldBkgNo(String oldBkgNo) {
		this.oldBkgNo = oldBkgNo;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
		setAdvshtgcd(JSPUtil.getParameter(request, "advshtgcd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPc(JSPUtil.getParameter(request, "pc", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no",""));
		setRtnRoute(JSPUtil.getParameter(request, "rtn_route",""));
		setXterSndrId(JSPUtil.getParameter(request, "xter_sndr_id",""));
		setXterRqstNo(JSPUtil.getParameter(request, "xter_rqst_no",""));
		setXterRqstSeq(JSPUtil.getParameter(request, "xter_rqst_seq",""));
		setDocTpCd(JSPUtil.getParameter(request, "doc_tp_cd",""));
		setOldBkgNo(JSPUtil.getParameter(request, "old_bkg_no",""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg",""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SplitBlInfoVO[]
	 */
	public SplitBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SplitBlInfoVO[]
	 */
	public SplitBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SplitBlInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] advshtgcd = (JSPUtil.getParameter(request, prefix	+ "adv_shtg_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pc = (JSPUtil.getParameter(request, prefix	+ "pc", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] rtnRoute = (JSPUtil.getParameter(request, prefix	+ "rtn_route", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] docTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_tp_cd", length));
			String[] oldBkgNo = (JSPUtil.getParameter(request, prefix	+ "old_bkg_no", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SplitBlInfoVO();
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (advshtgcd[i] != null)
					model.setAdvshtgcd(advshtgcd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pc[i] != null)
					model.setPc(pc[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (rtnRoute[i] != null)
					model.setRtnRoute(rtnRoute[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (docTpCd[i] != null)
					model.setDocTpCd(docTpCd[i]);
				if (oldBkgNo[i] != null)
					model.setOldBkgNo(oldBkgNo[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSplitBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SplitBlInfoVO[]
	 */
	public SplitBlInfoVO[] getSplitBlInfoVOs(){
		SplitBlInfoVO[] vos = (SplitBlInfoVO[])models.toArray(new SplitBlInfoVO[models.size()]);
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
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.advshtgcd = this.advshtgcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pc = this.pc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnRoute = this.rtnRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd = this.docTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldBkgNo = this.oldBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
