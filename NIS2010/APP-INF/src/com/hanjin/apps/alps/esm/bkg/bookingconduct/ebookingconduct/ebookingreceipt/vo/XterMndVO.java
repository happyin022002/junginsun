/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : XterMndVO.java
*@FileTitle : XterMndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.20 류대영 
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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterMndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterMndVO> models = new ArrayList<XterMndVO>();
	
	/* Column Info */
	private String lcdt2 = null;
	/* Column Info */
	private String hinv2 = null;
	/* Column Info */
	private String lcno2 = null;
	/* Column Info */
	private String idXptLicCnt = null;
	/* Column Info */
	private String mkDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String misc = null;
	/* Column Info */
	private String xptImp = null;
	/* Column Info */
	private String krXptLicCnt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String rider = null;
	/* Column Info */
	private String poNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String bkpo2 = null;
	/* Column Info */
	private String miscDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterMndVO() {}

	public XterMndVO(String ibflag, String pagerows, String mkDesc, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String cmdtDesc, String miscDesc, String misc, String xptImp, String bkpo2, String lcno2, String hinv2, String lcdt2, String poNo, String rider, String polCd, String cstmsDesc, String krXptLicCnt, String idXptLicCnt) {
		this.lcdt2 = lcdt2;
		this.hinv2 = hinv2;
		this.lcno2 = lcno2;
		this.idXptLicCnt = idXptLicCnt;
		this.mkDesc = mkDesc;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.misc = misc;
		this.xptImp = xptImp;
		this.krXptLicCnt = krXptLicCnt;
		this.polCd = polCd;
		this.rider = rider;
		this.poNo = poNo;
		this.ibflag = ibflag;
		this.cmdtDesc = cmdtDesc;
		this.cstmsDesc = cstmsDesc;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.bkpo2 = bkpo2;
		this.miscDesc = miscDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lcdt2", getLcdt2());
		this.hashColumns.put("hinv2", getHinv2());
		this.hashColumns.put("lcno2", getLcno2());
		this.hashColumns.put("id_xpt_lic_cnt", getIdXptLicCnt());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("misc", getMisc());
		this.hashColumns.put("xpt_imp", getXptImp());
		this.hashColumns.put("kr_xpt_lic_cnt", getKrXptLicCnt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("rider", getRider());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("bkpo2", getBkpo2());
		this.hashColumns.put("misc_desc", getMiscDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lcdt2", "lcdt2");
		this.hashFields.put("hinv2", "hinv2");
		this.hashFields.put("lcno2", "lcno2");
		this.hashFields.put("id_xpt_lic_cnt", "idXptLicCnt");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("misc", "misc");
		this.hashFields.put("xpt_imp", "xptImp");
		this.hashFields.put("kr_xpt_lic_cnt", "krXptLicCnt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rider", "rider");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("bkpo2", "bkpo2");
		this.hashFields.put("misc_desc", "miscDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lcdt2
	 */
	public String getLcdt2() {
		return this.lcdt2;
	}
	
	/**
	 * Column Info
	 * @return hinv2
	 */
	public String getHinv2() {
		return this.hinv2;
	}
	
	/**
	 * Column Info
	 * @return lcno2
	 */
	public String getLcno2() {
		return this.lcno2;
	}
	
	/**
	 * Column Info
	 * @return idXptLicCnt
	 */
	public String getIdXptLicCnt() {
		return this.idXptLicCnt;
	}
	
	/**
	 * Column Info
	 * @return mkDesc
	 */
	public String getMkDesc() {
		return this.mkDesc;
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
	 * Column Info
	 * @return misc
	 */
	public String getMisc() {
		return this.misc;
	}
	
	/**
	 * Column Info
	 * @return xptImp
	 */
	public String getXptImp() {
		return this.xptImp;
	}
	
	/**
	 * Column Info
	 * @return krXptLicCnt
	 */
	public String getKrXptLicCnt() {
		return this.krXptLicCnt;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return rider
	 */
	public String getRider() {
		return this.rider;
	}
	
	/**
	 * Column Info
	 * @return poNo
	 */
	public String getPoNo() {
		return this.poNo;
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
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return bkpo2
	 */
	public String getBkpo2() {
		return this.bkpo2;
	}
	
	/**
	 * Column Info
	 * @return miscDesc
	 */
	public String getMiscDesc() {
		return this.miscDesc;
	}
	

	/**
	 * Column Info
	 * @param lcdt2
	 */
	public void setLcdt2(String lcdt2) {
		this.lcdt2 = lcdt2;
	}
	
	/**
	 * Column Info
	 * @param hinv2
	 */
	public void setHinv2(String hinv2) {
		this.hinv2 = hinv2;
	}
	
	/**
	 * Column Info
	 * @param lcno2
	 */
	public void setLcno2(String lcno2) {
		this.lcno2 = lcno2;
	}
	
	/**
	 * Column Info
	 * @param idXptLicCnt
	 */
	public void setIdXptLicCnt(String idXptLicCnt) {
		this.idXptLicCnt = idXptLicCnt;
	}
	
	/**
	 * Column Info
	 * @param mkDesc
	 */
	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
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
	 * Column Info
	 * @param misc
	 */
	public void setMisc(String misc) {
		this.misc = misc;
	}
	
	/**
	 * Column Info
	 * @param xptImp
	 */
	public void setXptImp(String xptImp) {
		this.xptImp = xptImp;
	}
	
	/**
	 * Column Info
	 * @param krXptLicCnt
	 */
	public void setKrXptLicCnt(String krXptLicCnt) {
		this.krXptLicCnt = krXptLicCnt;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param rider
	 */
	public void setRider(String rider) {
		this.rider = rider;
	}
	
	/**
	 * Column Info
	 * @param poNo
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
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
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param bkpo2
	 */
	public void setBkpo2(String bkpo2) {
		this.bkpo2 = bkpo2;
	}
	
	/**
	 * Column Info
	 * @param miscDesc
	 */
	public void setMiscDesc(String miscDesc) {
		this.miscDesc = miscDesc;
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
		setLcdt2(JSPUtil.getParameter(request, prefix + "lcdt2", ""));
		setHinv2(JSPUtil.getParameter(request, prefix + "hinv2", ""));
		setLcno2(JSPUtil.getParameter(request, prefix + "lcno2", ""));
		setIdXptLicCnt(JSPUtil.getParameter(request, prefix + "id_xpt_lic_cnt", ""));
		setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setMisc(JSPUtil.getParameter(request, prefix + "misc", ""));
		setXptImp(JSPUtil.getParameter(request, prefix + "xpt_imp", ""));
		setKrXptLicCnt(JSPUtil.getParameter(request, prefix + "kr_xpt_lic_cnt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setRider(JSPUtil.getParameter(request, prefix + "rider", ""));
		setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setBkpo2(JSPUtil.getParameter(request, prefix + "bkpo2", ""));
		setMiscDesc(JSPUtil.getParameter(request, prefix + "misc_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterMndVO[]
	 */
	public XterMndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterMndVO[]
	 */
	public XterMndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterMndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lcdt2 = (JSPUtil.getParameter(request, prefix	+ "lcdt2", length));
			String[] hinv2 = (JSPUtil.getParameter(request, prefix	+ "hinv2", length));
			String[] lcno2 = (JSPUtil.getParameter(request, prefix	+ "lcno2", length));
			String[] idXptLicCnt = (JSPUtil.getParameter(request, prefix	+ "id_xpt_lic_cnt", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] misc = (JSPUtil.getParameter(request, prefix	+ "misc", length));
			String[] xptImp = (JSPUtil.getParameter(request, prefix	+ "xpt_imp", length));
			String[] krXptLicCnt = (JSPUtil.getParameter(request, prefix	+ "kr_xpt_lic_cnt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] rider = (JSPUtil.getParameter(request, prefix	+ "rider", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] bkpo2 = (JSPUtil.getParameter(request, prefix	+ "bkpo2", length));
			String[] miscDesc = (JSPUtil.getParameter(request, prefix	+ "misc_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterMndVO();
				if (lcdt2[i] != null)
					model.setLcdt2(lcdt2[i]);
				if (hinv2[i] != null)
					model.setHinv2(hinv2[i]);
				if (lcno2[i] != null)
					model.setLcno2(lcno2[i]);
				if (idXptLicCnt[i] != null)
					model.setIdXptLicCnt(idXptLicCnt[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (misc[i] != null)
					model.setMisc(misc[i]);
				if (xptImp[i] != null)
					model.setXptImp(xptImp[i]);
				if (krXptLicCnt[i] != null)
					model.setKrXptLicCnt(krXptLicCnt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (rider[i] != null)
					model.setRider(rider[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (bkpo2[i] != null)
					model.setBkpo2(bkpo2[i]);
				if (miscDesc[i] != null)
					model.setMiscDesc(miscDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterMndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterMndVO[]
	 */
	public XterMndVO[] getXterMndVOs(){
		XterMndVO[] vos = (XterMndVO[])models.toArray(new XterMndVO[models.size()]);
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
		this.lcdt2 = this.lcdt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hinv2 = this.hinv2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcno2 = this.lcno2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idXptLicCnt = this.idXptLicCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misc = this.misc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImp = this.xptImp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krXptLicCnt = this.krXptLicCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rider = this.rider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkpo2 = this.bkpo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miscDesc = this.miscDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
