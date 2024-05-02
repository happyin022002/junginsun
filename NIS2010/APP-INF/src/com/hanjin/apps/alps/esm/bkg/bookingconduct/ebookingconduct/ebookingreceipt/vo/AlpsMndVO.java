/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NisMndVO.java
*@FileTitle : NisMndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.13
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.12.13 민동진 
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
 * @author 민동진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AlpsMndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AlpsMndVO> models = new ArrayList<AlpsMndVO>();
	
	/* Column Info */
	private String pckNm = null;
	/* Column Info */
	private String mkDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String xptImp = null;
	/* Column Info */
	private String rider = null;
	/* Column Info */
	private String poNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrDesc = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String cntrCmdtDesc = null;
	/* Column Info */
	private String actWgtPrnFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String ttlPckDesc = null;
	/* Column Info */
	private String pckCmdtDesc = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AlpsMndVO() {}

	public AlpsMndVO(String ibflag, String pagerows, String mkDesc, String pckQty, String pckTpCd, String pckNm, String actWgt, String wgtUtCd, String actWgtPrnFlg, String measQty, String measUtCd, String cmdtDesc, String pckCmdtDesc, String cntrCmdtDesc, String cstmsDesc, String ttlPckDesc, String cntrDesc, String xptImp, String poNo, String rider) {
		this.pckNm = pckNm;
		this.mkDesc = mkDesc;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.xptImp = xptImp;
		this.rider = rider;
		this.poNo = poNo;
		this.ibflag = ibflag;
		this.cntrDesc = cntrDesc;
		this.cmdtDesc = cmdtDesc;
		this.cstmsDesc = cstmsDesc;
		this.cntrCmdtDesc = cntrCmdtDesc;
		this.actWgtPrnFlg = actWgtPrnFlg;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.ttlPckDesc = ttlPckDesc;
		this.pckCmdtDesc = pckCmdtDesc;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pck_nm", getPckNm());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("xpt_imp", getXptImp());
		this.hashColumns.put("rider", getRider());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_desc", getCntrDesc());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("cntr_cmdt_desc", getCntrCmdtDesc());
		this.hashColumns.put("act_wgt_prn_flg", getActWgtPrnFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("ttl_pck_desc", getTtlPckDesc());
		this.hashColumns.put("pck_cmdt_desc", getPckCmdtDesc());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pck_nm", "pckNm");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("xpt_imp", "xptImp");
		this.hashFields.put("rider", "rider");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_desc", "cntrDesc");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("cntr_cmdt_desc", "cntrCmdtDesc");
		this.hashFields.put("act_wgt_prn_flg", "actWgtPrnFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("ttl_pck_desc", "ttlPckDesc");
		this.hashFields.put("pck_cmdt_desc", "pckCmdtDesc");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pckNm
	 */
	public String getPckNm() {
		return this.pckNm;
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
	 * @return xptImp
	 */
	public String getXptImp() {
		return this.xptImp;
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
	 * @return cntrDesc
	 */
	public String getCntrDesc() {
		return this.cntrDesc;
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
	 * @return cntrCmdtDesc
	 */
	public String getCntrCmdtDesc() {
		return this.cntrCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return actWgtPrnFlg
	 */
	public String getActWgtPrnFlg() {
		return this.actWgtPrnFlg;
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
	 * @return ttlPckDesc
	 */
	public String getTtlPckDesc() {
		return this.ttlPckDesc;
	}
	
	/**
	 * Column Info
	 * @return pckCmdtDesc
	 */
	public String getPckCmdtDesc() {
		return this.pckCmdtDesc;
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
	 * @param pckNm
	 */
	public void setPckNm(String pckNm) {
		this.pckNm = pckNm;
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
	 * @param xptImp
	 */
	public void setXptImp(String xptImp) {
		this.xptImp = xptImp;
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
	 * @param cntrDesc
	 */
	public void setCntrDesc(String cntrDesc) {
		this.cntrDesc = cntrDesc;
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
	 * @param cntrCmdtDesc
	 */
	public void setCntrCmdtDesc(String cntrCmdtDesc) {
		this.cntrCmdtDesc = cntrCmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param actWgtPrnFlg
	 */
	public void setActWgtPrnFlg(String actWgtPrnFlg) {
		this.actWgtPrnFlg = actWgtPrnFlg;
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
	 * @param ttlPckDesc
	 */
	public void setTtlPckDesc(String ttlPckDesc) {
		this.ttlPckDesc = ttlPckDesc;
	}
	
	/**
	 * Column Info
	 * @param pckCmdtDesc
	 */
	public void setPckCmdtDesc(String pckCmdtDesc) {
		this.pckCmdtDesc = pckCmdtDesc;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPckNm(JSPUtil.getParameter(request, "pck_nm", ""));
		setMkDesc(JSPUtil.getParameter(request, "mk_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setXptImp(JSPUtil.getParameter(request, "xpt_imp", ""));
		setRider(JSPUtil.getParameter(request, "rider", ""));
		setPoNo(JSPUtil.getParameter(request, "po_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrDesc(JSPUtil.getParameter(request, "cntr_desc", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setCntrCmdtDesc(JSPUtil.getParameter(request, "cntr_cmdt_desc", ""));
		setActWgtPrnFlg(JSPUtil.getParameter(request, "act_wgt_prn_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setTtlPckDesc(JSPUtil.getParameter(request, "ttl_pck_desc", ""));
		setPckCmdtDesc(JSPUtil.getParameter(request, "pck_cmdt_desc", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NisMndVO[]
	 */
	public AlpsMndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NisMndVO[]
	 */
	public AlpsMndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AlpsMndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pckNm = (JSPUtil.getParameter(request, prefix	+ "pck_nm", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] xptImp = (JSPUtil.getParameter(request, prefix	+ "xpt_imp", length));
			String[] rider = (JSPUtil.getParameter(request, prefix	+ "rider", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_desc", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] cntrCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_cmdt_desc", length));
			String[] actWgtPrnFlg = (JSPUtil.getParameter(request, prefix	+ "act_wgt_prn_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] ttlPckDesc = (JSPUtil.getParameter(request, prefix	+ "ttl_pck_desc", length));
			String[] pckCmdtDesc = (JSPUtil.getParameter(request, prefix	+ "pck_cmdt_desc", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AlpsMndVO();
				if (pckNm[i] != null)
					model.setPckNm(pckNm[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (xptImp[i] != null)
					model.setXptImp(xptImp[i]);
				if (rider[i] != null)
					model.setRider(rider[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrDesc[i] != null)
					model.setCntrDesc(cntrDesc[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (cntrCmdtDesc[i] != null)
					model.setCntrCmdtDesc(cntrCmdtDesc[i]);
				if (actWgtPrnFlg[i] != null)
					model.setActWgtPrnFlg(actWgtPrnFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (ttlPckDesc[i] != null)
					model.setTtlPckDesc(ttlPckDesc[i]);
				if (pckCmdtDesc[i] != null)
					model.setPckCmdtDesc(pckCmdtDesc[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNisMndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NisMndVO[]
	 */
	public AlpsMndVO[] getNisMndVOs(){
		AlpsMndVO[] vos = (AlpsMndVO[])models.toArray(new AlpsMndVO[models.size()]);
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
		this.pckNm = this.pckNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImp = this.xptImp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rider = this.rider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDesc = this.cntrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCmdtDesc = this.cntrCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgtPrnFlg = this.actWgtPrnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlPckDesc = this.ttlPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckCmdtDesc = this.pckCmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
