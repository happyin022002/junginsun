/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWhfBlExpInfoVO.java
*@FileTitle : KrWhfBlExpInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfBlExpInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfBlExpInfoVO> models = new ArrayList<KrWhfBlExpInfoVO>();
	
	/* Column Info */
	private String bkgRtWhfExptCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ca = null;
	/* Column Info */
	private String shipperName = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String bdr = null;
	/* Column Info */
	private String whfShprRgstNo = null;
	/* Column Info */
	private String exportRef = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfBlExpInfoVO() {}

	public KrWhfBlExpInfoVO(String ibflag, String pagerows, String shipperName, String exportRef, String cstmsDesc, String bkgCgoTpCd, String bkgRtWhfExptCd, String whfShprRgstNo, String bdr, String ca) {
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.ibflag = ibflag;
		this.ca = ca;
		this.shipperName = shipperName;
		this.cstmsDesc = cstmsDesc;
		this.bdr = bdr;
		this.whfShprRgstNo = whfShprRgstNo;
		this.exportRef = exportRef;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_rt_whf_expt_cd", getBkgRtWhfExptCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ca", getCa());
		this.hashColumns.put("shipper_name", getShipperName());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("bdr", getBdr());
		this.hashColumns.put("whf_shpr_rgst_no", getWhfShprRgstNo());
		this.hashColumns.put("export_ref", getExportRef());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_rt_whf_expt_cd", "bkgRtWhfExptCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ca", "ca");
		this.hashFields.put("shipper_name", "shipperName");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("bdr", "bdr");
		this.hashFields.put("whf_shpr_rgst_no", "whfShprRgstNo");
		this.hashFields.put("export_ref", "exportRef");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return ca
	 */
	public String getCa() {
		return this.ca;
	}
	
	/**
	 * Column Info
	 * @return shipperName
	 */
	public String getShipperName() {
		return this.shipperName;
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
	 * @return bdr
	 */
	public String getBdr() {
		return this.bdr;
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
	 * @return exportRef
	 */
	public String getExportRef() {
		return this.exportRef;
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
	 * @param bkgRtWhfExptCd
	 */
	public void setBkgRtWhfExptCd(String bkgRtWhfExptCd) {
		this.bkgRtWhfExptCd = bkgRtWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param ca
	 */
	public void setCa(String ca) {
		this.ca = ca;
	}
	
	/**
	 * Column Info
	 * @param shipperName
	 */
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
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
	 * @param bdr
	 */
	public void setBdr(String bdr) {
		this.bdr = bdr;
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
	 * @param exportRef
	 */
	public void setExportRef(String exportRef) {
		this.exportRef = exportRef;
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
		setBkgRtWhfExptCd(JSPUtil.getParameter(request, prefix + "bkg_rt_whf_expt_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCa(JSPUtil.getParameter(request, prefix + "ca", ""));
		setShipperName(JSPUtil.getParameter(request, prefix + "shipper_name", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setBdr(JSPUtil.getParameter(request, prefix + "bdr", ""));
		setWhfShprRgstNo(JSPUtil.getParameter(request, prefix + "whf_shpr_rgst_no", ""));
		setExportRef(JSPUtil.getParameter(request, prefix + "export_ref", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfBlExpInfoVO[]
	 */
	public KrWhfBlExpInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfBlExpInfoVO[]
	 */
	public KrWhfBlExpInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfBlExpInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgRtWhfExptCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rt_whf_expt_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ca = (JSPUtil.getParameter(request, prefix	+ "ca", length));
			String[] shipperName = (JSPUtil.getParameter(request, prefix	+ "shipper_name", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] bdr = (JSPUtil.getParameter(request, prefix	+ "bdr", length));
			String[] whfShprRgstNo = (JSPUtil.getParameter(request, prefix	+ "whf_shpr_rgst_no", length));
			String[] exportRef = (JSPUtil.getParameter(request, prefix	+ "export_ref", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfBlExpInfoVO();
				if (bkgRtWhfExptCd[i] != null)
					model.setBkgRtWhfExptCd(bkgRtWhfExptCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ca[i] != null)
					model.setCa(ca[i]);
				if (shipperName[i] != null)
					model.setShipperName(shipperName[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (bdr[i] != null)
					model.setBdr(bdr[i]);
				if (whfShprRgstNo[i] != null)
					model.setWhfShprRgstNo(whfShprRgstNo[i]);
				if (exportRef[i] != null)
					model.setExportRef(exportRef[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfBlExpInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfBlExpInfoVO[]
	 */
	public KrWhfBlExpInfoVO[] getKrWhfBlExpInfoVOs(){
		KrWhfBlExpInfoVO[] vos = (KrWhfBlExpInfoVO[])models.toArray(new KrWhfBlExpInfoVO[models.size()]);
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
		this.bkgRtWhfExptCd = this.bkgRtWhfExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ca = this.ca .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperName = this.shipperName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdr = this.bdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfShprRgstNo = this.whfShprRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exportRef = this.exportRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
