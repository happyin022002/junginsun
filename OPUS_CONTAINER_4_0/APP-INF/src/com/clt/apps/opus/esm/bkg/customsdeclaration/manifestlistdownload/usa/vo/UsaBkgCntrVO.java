/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaBkgCntrVO.java
*@FileTitle : UsaBkgCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBkgCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBkgCntrVO> models = new ArrayList<UsaBkgCntrVO>();
	
	/* Column Info */
	private String xptFlg = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String cgoArrAcptDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String prtFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arrFlg = null;
	/* Column Info */
	private String xptAcptDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String fullMtyCd = null;
	/* Column Info */
	private String xptDt = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaBkgCntrVO() {}

	public UsaBkgCntrVO(String ibflag, String pagerows, String arrDt, String arrFlg, String blNo, String cgoArrAcptDt, String cntrNo, String cntrTpszCd, String cntCd, String creUsrId, String fullMtyCd, String grsWgt, String pckQty, String pckTpCd, String prtFlg, String updUsrId, String wgtUtCd, String xptAcptDt, String xptDt, String xptFlg) {
		this.xptFlg = xptFlg;
		this.arrDt = arrDt;
		this.cgoArrAcptDt = cgoArrAcptDt;
		this.blNo = blNo;
		this.prtFlg = prtFlg;
		this.pagerows = pagerows;
		this.arrFlg = arrFlg;
		this.xptAcptDt = xptAcptDt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntCd = cntCd;
		this.pckQty = pckQty;
		this.fullMtyCd = fullMtyCd;
		this.xptDt = xptDt;
		this.pckTpCd = pckTpCd;
		this.updUsrId = updUsrId;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xpt_flg", getXptFlg());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("cgo_arr_acpt_dt", getCgoArrAcptDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("prt_flg", getPrtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("arr_flg", getArrFlg());
		this.hashColumns.put("xpt_acpt_dt", getXptAcptDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		this.hashColumns.put("xpt_dt", getXptDt());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xpt_flg", "xptFlg");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("cgo_arr_acpt_dt", "cgoArrAcptDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("prt_flg", "prtFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("arr_flg", "arrFlg");
		this.hashFields.put("xpt_acpt_dt", "xptAcptDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		this.hashFields.put("xpt_dt", "xptDt");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("grs_wgt", "grsWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xptFlg
	 */
	public String getXptFlg() {
		return this.xptFlg;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return cgoArrAcptDt
	 */
	public String getCgoArrAcptDt() {
		return this.cgoArrAcptDt;
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
	 * @return prtFlg
	 */
	public String getPrtFlg() {
		return this.prtFlg;
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
	 * @return arrFlg
	 */
	public String getArrFlg() {
		return this.arrFlg;
	}
	
	/**
	 * Column Info
	 * @return xptAcptDt
	 */
	public String getXptAcptDt() {
		return this.xptAcptDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return xptDt
	 */
	public String getXptDt() {
		return this.xptDt;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	

	/**
	 * Column Info
	 * @param xptFlg
	 */
	public void setXptFlg(String xptFlg) {
		this.xptFlg = xptFlg;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param cgoArrAcptDt
	 */
	public void setCgoArrAcptDt(String cgoArrAcptDt) {
		this.cgoArrAcptDt = cgoArrAcptDt;
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
	 * @param prtFlg
	 */
	public void setPrtFlg(String prtFlg) {
		this.prtFlg = prtFlg;
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
	 * @param arrFlg
	 */
	public void setArrFlg(String arrFlg) {
		this.arrFlg = arrFlg;
	}
	
	/**
	 * Column Info
	 * @param xptAcptDt
	 */
	public void setXptAcptDt(String xptAcptDt) {
		this.xptAcptDt = xptAcptDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param fullMtyCd
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param xptDt
	 */
	public void setXptDt(String xptDt) {
		this.xptDt = xptDt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setXptFlg(JSPUtil.getParameter(request, prefix + "xpt_flg", ""));
		setArrDt(JSPUtil.getParameter(request, prefix + "arr_dt", ""));
		setCgoArrAcptDt(JSPUtil.getParameter(request, prefix + "cgo_arr_acpt_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPrtFlg(JSPUtil.getParameter(request, prefix + "prt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setArrFlg(JSPUtil.getParameter(request, prefix + "arr_flg", ""));
		setXptAcptDt(JSPUtil.getParameter(request, prefix + "xpt_acpt_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setFullMtyCd(JSPUtil.getParameter(request, prefix + "full_mty_cd", ""));
		setXptDt(JSPUtil.getParameter(request, prefix + "xpt_dt", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBkgCntrVO[]
	 */
	public UsaBkgCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBkgCntrVO[]
	 */
	public UsaBkgCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBkgCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xptFlg = (JSPUtil.getParameter(request, prefix	+ "xpt_flg", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] cgoArrAcptDt = (JSPUtil.getParameter(request, prefix	+ "cgo_arr_acpt_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] prtFlg = (JSPUtil.getParameter(request, prefix	+ "prt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] arrFlg = (JSPUtil.getParameter(request, prefix	+ "arr_flg", length));
			String[] xptAcptDt = (JSPUtil.getParameter(request, prefix	+ "xpt_acpt_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			String[] xptDt = (JSPUtil.getParameter(request, prefix	+ "xpt_dt", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBkgCntrVO();
				if (xptFlg[i] != null)
					model.setXptFlg(xptFlg[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (cgoArrAcptDt[i] != null)
					model.setCgoArrAcptDt(cgoArrAcptDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (prtFlg[i] != null)
					model.setPrtFlg(prtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arrFlg[i] != null)
					model.setArrFlg(arrFlg[i]);
				if (xptAcptDt[i] != null)
					model.setXptAcptDt(xptAcptDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				if (xptDt[i] != null)
					model.setXptDt(xptDt[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBkgCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBkgCntrVO[]
	 */
	public UsaBkgCntrVO[] getUsaBkgCntrVOs(){
		UsaBkgCntrVO[] vos = (UsaBkgCntrVO[])models.toArray(new UsaBkgCntrVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.xptFlg = this.xptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoArrAcptDt = this.cgoArrAcptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtFlg = this.prtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFlg = this.arrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptAcptDt = this.xptAcptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptDt = this.xptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
