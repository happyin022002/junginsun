/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : searchNisHbl1VO.java
*@FileTitle : searchNisHbl1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class searchNisHbl1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<searchNisHbl1VO> models = new ArrayList<searchNisHbl1VO>();
	
	/* Column Info */
	private String blGdsDesc = null;
	/* Column Info */
	private String cneeAddr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xterSiNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String shprAddr = null;
	/* Column Info */
	private String notiAddr = null;
	/* Column Info */
	private String hblWgt = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cmdtMeasQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String hblSeq = null;
	/* Column Info */
	private String blMkDesc = null;
	/* Column Info */
	private String cmdtMeasUtCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String xterSiSeq = null;
	/* Column Info */
	private String notiNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public searchNisHbl1VO() {}

	public searchNisHbl1VO(String ibflag, String pagerows, String xterSiNo, String xterSiSeq, String bkgNo, String hblNo, String shprNm, String shprAddr, String cneeNm, String cneeAddr, String notiNm, String notiAddr, String hblWgt, String wgtUtCd, String pckQty, String pckTpCd, String cmdtMeasQty, String cmdtMeasUtCd, String blMkDesc, String blGdsDesc, String hblSeq) {
		this.blGdsDesc = blGdsDesc;
		this.cneeAddr = cneeAddr;
		this.pagerows = pagerows;
		this.xterSiNo = xterSiNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.shprAddr = shprAddr;
		this.notiAddr = notiAddr;
		this.hblWgt = hblWgt;
		this.wgtUtCd = wgtUtCd;
		this.cmdtMeasQty = cmdtMeasQty;
		this.pckQty = pckQty;
		this.hblNo = hblNo;
		this.hblSeq = hblSeq;
		this.blMkDesc = blMkDesc;
		this.cmdtMeasUtCd = cmdtMeasUtCd;
		this.shprNm = shprNm;
		this.pckTpCd = pckTpCd;
		this.xterSiSeq = xterSiSeq;
		this.notiNm = notiNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_gds_desc", getBlGdsDesc());
		this.hashColumns.put("cnee_addr", getCneeAddr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xter_si_no", getXterSiNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("shpr_addr", getShprAddr());
		this.hashColumns.put("noti_addr", getNotiAddr());
		this.hashColumns.put("hbl_wgt", getHblWgt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cmdt_meas_qty", getCmdtMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("hbl_seq", getHblSeq());
		this.hashColumns.put("bl_mk_desc", getBlMkDesc());
		this.hashColumns.put("cmdt_meas_ut_cd", getCmdtMeasUtCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("xter_si_seq", getXterSiSeq());
		this.hashColumns.put("noti_nm", getNotiNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_gds_desc", "blGdsDesc");
		this.hashFields.put("cnee_addr", "cneeAddr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xter_si_no", "xterSiNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("shpr_addr", "shprAddr");
		this.hashFields.put("noti_addr", "notiAddr");
		this.hashFields.put("hbl_wgt", "hblWgt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cmdt_meas_qty", "cmdtMeasQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("hbl_seq", "hblSeq");
		this.hashFields.put("bl_mk_desc", "blMkDesc");
		this.hashFields.put("cmdt_meas_ut_cd", "cmdtMeasUtCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("xter_si_seq", "xterSiSeq");
		this.hashFields.put("noti_nm", "notiNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blGdsDesc
	 */
	public String getBlGdsDesc() {
		return this.blGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return cneeAddr
	 */
	public String getCneeAddr() {
		return this.cneeAddr;
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
	 * @return xterSiNo
	 */
	public String getXterSiNo() {
		return this.xterSiNo;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return shprAddr
	 */
	public String getShprAddr() {
		return this.shprAddr;
	}
	
	/**
	 * Column Info
	 * @return notiAddr
	 */
	public String getNotiAddr() {
		return this.notiAddr;
	}
	
	/**
	 * Column Info
	 * @return hblWgt
	 */
	public String getHblWgt() {
		return this.hblWgt;
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
	 * @return cmdtMeasQty
	 */
	public String getCmdtMeasQty() {
		return this.cmdtMeasQty;
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
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return hblSeq
	 */
	public String getHblSeq() {
		return this.hblSeq;
	}
	
	/**
	 * Column Info
	 * @return blMkDesc
	 */
	public String getBlMkDesc() {
		return this.blMkDesc;
	}
	
	/**
	 * Column Info
	 * @return cmdtMeasUtCd
	 */
	public String getCmdtMeasUtCd() {
		return this.cmdtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
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
	 * @return xterSiSeq
	 */
	public String getXterSiSeq() {
		return this.xterSiSeq;
	}
	
	/**
	 * Column Info
	 * @return notiNm
	 */
	public String getNotiNm() {
		return this.notiNm;
	}
	

	/**
	 * Column Info
	 * @param blGdsDesc
	 */
	public void setBlGdsDesc(String blGdsDesc) {
		this.blGdsDesc = blGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param cneeAddr
	 */
	public void setCneeAddr(String cneeAddr) {
		this.cneeAddr = cneeAddr;
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
	 * @param xterSiNo
	 */
	public void setXterSiNo(String xterSiNo) {
		this.xterSiNo = xterSiNo;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param shprAddr
	 */
	public void setShprAddr(String shprAddr) {
		this.shprAddr = shprAddr;
	}
	
	/**
	 * Column Info
	 * @param notiAddr
	 */
	public void setNotiAddr(String notiAddr) {
		this.notiAddr = notiAddr;
	}
	
	/**
	 * Column Info
	 * @param hblWgt
	 */
	public void setHblWgt(String hblWgt) {
		this.hblWgt = hblWgt;
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
	 * @param cmdtMeasQty
	 */
	public void setCmdtMeasQty(String cmdtMeasQty) {
		this.cmdtMeasQty = cmdtMeasQty;
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
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param hblSeq
	 */
	public void setHblSeq(String hblSeq) {
		this.hblSeq = hblSeq;
	}
	
	/**
	 * Column Info
	 * @param blMkDesc
	 */
	public void setBlMkDesc(String blMkDesc) {
		this.blMkDesc = blMkDesc;
	}
	
	/**
	 * Column Info
	 * @param cmdtMeasUtCd
	 */
	public void setCmdtMeasUtCd(String cmdtMeasUtCd) {
		this.cmdtMeasUtCd = cmdtMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
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
	 * @param xterSiSeq
	 */
	public void setXterSiSeq(String xterSiSeq) {
		this.xterSiSeq = xterSiSeq;
	}
	
	/**
	 * Column Info
	 * @param notiNm
	 */
	public void setNotiNm(String notiNm) {
		this.notiNm = notiNm;
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
		setBlGdsDesc(JSPUtil.getParameter(request, prefix + "bl_gds_desc", ""));
		setCneeAddr(JSPUtil.getParameter(request, prefix + "cnee_addr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setXterSiNo(JSPUtil.getParameter(request, prefix + "xter_si_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setShprAddr(JSPUtil.getParameter(request, prefix + "shpr_addr", ""));
		setNotiAddr(JSPUtil.getParameter(request, prefix + "noti_addr", ""));
		setHblWgt(JSPUtil.getParameter(request, prefix + "hbl_wgt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCmdtMeasQty(JSPUtil.getParameter(request, prefix + "cmdt_meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
		setHblSeq(JSPUtil.getParameter(request, prefix + "hbl_seq", ""));
		setBlMkDesc(JSPUtil.getParameter(request, prefix + "bl_mk_desc", ""));
		setCmdtMeasUtCd(JSPUtil.getParameter(request, prefix + "cmdt_meas_ut_cd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setXterSiSeq(JSPUtil.getParameter(request, prefix + "xter_si_seq", ""));
		setNotiNm(JSPUtil.getParameter(request, prefix + "noti_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchNisHbl1VO[]
	 */
	public searchNisHbl1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchNisHbl1VO[]
	 */
	public searchNisHbl1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		searchNisHbl1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blGdsDesc = (JSPUtil.getParameter(request, prefix	+ "bl_gds_desc", length));
			String[] cneeAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_addr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xterSiNo = (JSPUtil.getParameter(request, prefix	+ "xter_si_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] shprAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_addr", length));
			String[] notiAddr = (JSPUtil.getParameter(request, prefix	+ "noti_addr", length));
			String[] hblWgt = (JSPUtil.getParameter(request, prefix	+ "hbl_wgt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cmdtMeasQty = (JSPUtil.getParameter(request, prefix	+ "cmdt_meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] hblSeq = (JSPUtil.getParameter(request, prefix	+ "hbl_seq", length));
			String[] blMkDesc = (JSPUtil.getParameter(request, prefix	+ "bl_mk_desc", length));
			String[] cmdtMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_meas_ut_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] xterSiSeq = (JSPUtil.getParameter(request, prefix	+ "xter_si_seq", length));
			String[] notiNm = (JSPUtil.getParameter(request, prefix	+ "noti_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new searchNisHbl1VO();
				if (blGdsDesc[i] != null)
					model.setBlGdsDesc(blGdsDesc[i]);
				if (cneeAddr[i] != null)
					model.setCneeAddr(cneeAddr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xterSiNo[i] != null)
					model.setXterSiNo(xterSiNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (shprAddr[i] != null)
					model.setShprAddr(shprAddr[i]);
				if (notiAddr[i] != null)
					model.setNotiAddr(notiAddr[i]);
				if (hblWgt[i] != null)
					model.setHblWgt(hblWgt[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cmdtMeasQty[i] != null)
					model.setCmdtMeasQty(cmdtMeasQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (hblSeq[i] != null)
					model.setHblSeq(hblSeq[i]);
				if (blMkDesc[i] != null)
					model.setBlMkDesc(blMkDesc[i]);
				if (cmdtMeasUtCd[i] != null)
					model.setCmdtMeasUtCd(cmdtMeasUtCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (xterSiSeq[i] != null)
					model.setXterSiSeq(xterSiSeq[i]);
				if (notiNm[i] != null)
					model.setNotiNm(notiNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchNisHbl1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchNisHbl1VO[]
	 */
	public searchNisHbl1VO[] getsearchNisHbl1VOs(){
		searchNisHbl1VO[] vos = (searchNisHbl1VO[])models.toArray(new searchNisHbl1VO[models.size()]);
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
		this.blGdsDesc = this.blGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAddr = this.cneeAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiNo = this.xterSiNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprAddr = this.shprAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiAddr = this.notiAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblWgt = this.hblWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtMeasQty = this.cmdtMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblSeq = this.hblSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blMkDesc = this.blMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtMeasUtCd = this.cmdtMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSiSeq = this.xterSiSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notiNm = this.notiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
