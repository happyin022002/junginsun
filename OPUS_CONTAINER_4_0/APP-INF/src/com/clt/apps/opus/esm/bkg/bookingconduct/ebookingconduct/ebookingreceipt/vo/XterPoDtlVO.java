/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : XterPoDtlVO.java
*@FileTitle : XterPoDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.01 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterPoDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterPoDtlVO> models = new ArrayList<XterPoDtlVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String poNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itmDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String itmNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterPoDtlVO() {}

	public XterPoDtlVO(String ibflag, String pagerows, String poNo, String itmNo, String itmDesc, String pckQty, String pckTpCd, String cntrWgt, String wgtUtCd, String measQty, String measUtCd, String cntrNo) {
		this.cntrWgt = cntrWgt;
		this.poNo = poNo;
		this.ibflag = ibflag;
		this.itmDesc = itmDesc;
		this.cntrNo = cntrNo;
		this.measQty = measQty;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.itmNo = itmNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("po_no", getPoNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("itm_desc", getItmDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("itm_no", getItmNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("po_no", "poNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("itm_desc", "itmDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("itm_no", "itmNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
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
	 * @return itmDesc
	 */
	public String getItmDesc() {
		return this.itmDesc;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return itmNo
	 */
	public String getItmNo() {
		return this.itmNo;
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
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
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
	 * @param itmDesc
	 */
	public void setItmDesc(String itmDesc) {
		this.itmDesc = itmDesc;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param itmNo
	 */
	public void setItmNo(String itmNo) {
		this.itmNo = itmNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setPoNo(JSPUtil.getParameter(request, prefix + "po_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setItmDesc(JSPUtil.getParameter(request, prefix + "itm_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setItmNo(JSPUtil.getParameter(request, prefix + "itm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterPoDtlVO[]
	 */
	public XterPoDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterPoDtlVO[]
	 */
	public XterPoDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterPoDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] poNo = (JSPUtil.getParameter(request, prefix	+ "po_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itmDesc = (JSPUtil.getParameter(request, prefix	+ "itm_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] itmNo = (JSPUtil.getParameter(request, prefix	+ "itm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterPoDtlVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (poNo[i] != null)
					model.setPoNo(poNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itmDesc[i] != null)
					model.setItmDesc(itmDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (itmNo[i] != null)
					model.setItmNo(itmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterPoDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterPoDtlVO[]
	 */
	public XterPoDtlVO[] getXterPoDtlVOs(){
		XterPoDtlVO[] vos = (XterPoDtlVO[])models.toArray(new XterPoDtlVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poNo = this.poNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmDesc = this.itmDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNo = this.itmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
