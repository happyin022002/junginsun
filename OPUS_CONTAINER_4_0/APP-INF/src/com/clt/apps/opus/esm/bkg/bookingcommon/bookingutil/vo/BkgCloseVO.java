/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCloseVO.java
*@FileTitle : BkgCloseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.03 류대영 
* 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

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

public class BkgCloseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCloseVO> models = new ArrayList<BkgCloseVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String prePolYdCd = null;
	/* Column Info */
	private String cntrList = null;
	/* Column Info */
	private String closeVvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String newPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String preVvd = null;
	/* Column Info */
	private String prePodYdCd = null;
	/* Column Info */
	private String closePodCd = null;
	/* Column Info */
	private String prePolCd = null;
	/* Column Info */
	private String closePolYdCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String closePolCd = null;
	/* Column Info */
	private String prePodCd = null;
	/* Column Info */
	private String oldQtyVol = null;
	/* Column Info */
	private String newPolYdCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String newQtyVol = null;
	/* Column Info */
	private String newPodYdCd = null;
	/* Column Info */
	private String newPodCd = null;
	/* Column Info */
	private String newVvd = null;
	/* Column Info */
	private String newCntrList = null;
	/* Column Info */
	private String closePodYdCd = null;
	/* Column Info */
	private String newYdCdSeq = null;
	/* Column Info */
	private String preYdCdSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCloseVO() {}

	public BkgCloseVO(String ibflag, String pagerows, String bkgNo, String preVvd, String prePolCd, String prePolYdCd, String prePodCd, String prePodYdCd, String newVvd, String porCd, String newPolCd, String newPolYdCd, String newPodCd, String newPodYdCd, String podCd, String delCd, String closeVvd, String closePolCd, String closePolYdCd, String closePodCd, String closePodYdCd, String oldQtyVol, String newQtyVol, String cntrList, String newCntrList, String newYdCdSeq, String preYdCdSeq) {
		this.porCd = porCd;
		this.prePolYdCd = prePolYdCd;
		this.cntrList = cntrList;
		this.closeVvd = closeVvd;
		this.pagerows = pagerows;
		this.newPolCd = newPolCd;
		this.ibflag = ibflag;
		this.preVvd = preVvd;
		this.prePodYdCd = prePodYdCd;
		this.closePodCd = closePodCd;
		this.prePolCd = prePolCd;
		this.closePolYdCd = closePolYdCd;
		this.delCd = delCd;
		this.closePolCd = closePolCd;
		this.prePodCd = prePodCd;
		this.oldQtyVol = oldQtyVol;
		this.newPolYdCd = newPolYdCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.newQtyVol = newQtyVol;
		this.newPodYdCd = newPodYdCd;
		this.newPodCd = newPodCd;
		this.newVvd = newVvd;
		this.newCntrList = newCntrList;
		this.closePodYdCd = closePodYdCd;
		this.newYdCdSeq = newYdCdSeq;
		this.preYdCdSeq = preYdCdSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pre_pol_yd_cd", getPrePolYdCd());
		this.hashColumns.put("cntr_list", getCntrList());
		this.hashColumns.put("close_vvd", getCloseVvd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("new_pol_cd", getNewPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pre_vvd", getPreVvd());
		this.hashColumns.put("pre_pod_yd_cd", getPrePodYdCd());
		this.hashColumns.put("close_pod_cd", getClosePodCd());
		this.hashColumns.put("pre_pol_cd", getPrePolCd());
		this.hashColumns.put("close_pol_yd_cd", getClosePolYdCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("close_pol_cd", getClosePolCd());
		this.hashColumns.put("pre_pod_cd", getPrePodCd());
		this.hashColumns.put("old_qty_vol", getOldQtyVol());
		this.hashColumns.put("new_pol_yd_cd", getNewPolYdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("new_qty_vol", getNewQtyVol());
		this.hashColumns.put("new_pod_yd_cd", getNewPodYdCd());
		this.hashColumns.put("new_pod_cd", getNewPodCd());
		this.hashColumns.put("new_vvd", getNewVvd());
		this.hashColumns.put("new_cntr_list", getNewCntrList());
		this.hashColumns.put("close_pod_yd_cd", getClosePodYdCd());
		this.hashColumns.put("new_yd_cd_seq", getNewYdCdSeq());
		this.hashColumns.put("pre_yd_cd_seq", getPreYdCdSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pre_pol_yd_cd", "prePolYdCd");
		this.hashFields.put("cntr_list", "cntrList");
		this.hashFields.put("close_vvd", "closeVvd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("new_pol_cd", "newPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pre_vvd", "preVvd");
		this.hashFields.put("pre_pod_yd_cd", "prePodYdCd");
		this.hashFields.put("close_pod_cd", "closePodCd");
		this.hashFields.put("pre_pol_cd", "prePolCd");
		this.hashFields.put("close_pol_yd_cd", "closePolYdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("close_pol_cd", "closePolCd");
		this.hashFields.put("pre_pod_cd", "prePodCd");
		this.hashFields.put("old_qty_vol", "oldQtyVol");
		this.hashFields.put("new_pol_yd_cd", "newPolYdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("new_qty_vol", "newQtyVol");
		this.hashFields.put("new_pod_yd_cd", "newPodYdCd");
		this.hashFields.put("new_pod_cd", "newPodCd");
		this.hashFields.put("new_vvd", "newVvd");
		this.hashFields.put("new_cntr_list", "newCntrList");
		this.hashFields.put("close_pod_yd_cd", "closePodYdCd");
		this.hashFields.put("new_yd_cd_seq", "newYdCdSeq");
		this.hashFields.put("pre_yd_cd_seq", "preYdCdSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return prePolYdCd
	 */
	public String getPrePolYdCd() {
		return this.prePolYdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrList
	 */
	public String getCntrList() {
		return this.cntrList;
	}
	
	/**
	 * Column Info
	 * @return closeVvd
	 */
	public String getCloseVvd() {
		return this.closeVvd;
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
	 * @return newPolCd
	 */
	public String getNewPolCd() {
		return this.newPolCd;
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
	 * @return preVvd
	 */
	public String getPreVvd() {
		return this.preVvd;
	}
	
	/**
	 * Column Info
	 * @return prePodYdCd
	 */
	public String getPrePodYdCd() {
		return this.prePodYdCd;
	}
	
	/**
	 * Column Info
	 * @return closePodCd
	 */
	public String getClosePodCd() {
		return this.closePodCd;
	}
	
	/**
	 * Column Info
	 * @return prePolCd
	 */
	public String getPrePolCd() {
		return this.prePolCd;
	}
	
	/**
	 * Column Info
	 * @return closePolYdCd
	 */
	public String getClosePolYdCd() {
		return this.closePolYdCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return closePolCd
	 */
	public String getClosePolCd() {
		return this.closePolCd;
	}
	
	/**
	 * Column Info
	 * @return prePodCd
	 */
	public String getPrePodCd() {
		return this.prePodCd;
	}
	
	/**
	 * Column Info
	 * @return oldQtyVol
	 */
	public String getOldQtyVol() {
		return this.oldQtyVol;
	}
	
	/**
	 * Column Info
	 * @return newPolYdCd
	 */
	public String getNewPolYdCd() {
		return this.newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return newQtyVol
	 */
	public String getNewQtyVol() {
		return this.newQtyVol;
	}
	
	/**
	 * Column Info
	 * @return newPodYdCd
	 */
	public String getNewPodYdCd() {
		return this.newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return newPodCd
	 */
	public String getNewPodCd() {
		return this.newPodCd;
	}
	
	/**
	 * Column Info
	 * @return newVvd
	 */
	public String getNewVvd() {
		return this.newVvd;
	}
	
	/**
	 * Column Info
	 * @return newCntrList
	 */
	public String getNewCntrList() {
		return this.newCntrList;
	}
	
	/**
	 * Column Info
	 * @return closePodYdCd
	 */
	public String getClosePodYdCd() {
		return this.closePodYdCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param prePolYdCd
	 */
	public void setPrePolYdCd(String prePolYdCd) {
		this.prePolYdCd = prePolYdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrList
	 */
	public void setCntrList(String cntrList) {
		this.cntrList = cntrList;
	}
	
	/**
	 * Column Info
	 * @param closeVvd
	 */
	public void setCloseVvd(String closeVvd) {
		this.closeVvd = closeVvd;
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
	 * @param newPolCd
	 */
	public void setNewPolCd(String newPolCd) {
		this.newPolCd = newPolCd;
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
	 * @param preVvd
	 */
	public void setPreVvd(String preVvd) {
		this.preVvd = preVvd;
	}
	
	/**
	 * Column Info
	 * @param prePodYdCd
	 */
	public void setPrePodYdCd(String prePodYdCd) {
		this.prePodYdCd = prePodYdCd;
	}
	
	/**
	 * Column Info
	 * @param closePodCd
	 */
	public void setClosePodCd(String closePodCd) {
		this.closePodCd = closePodCd;
	}
	
	/**
	 * Column Info
	 * @param prePolCd
	 */
	public void setPrePolCd(String prePolCd) {
		this.prePolCd = prePolCd;
	}
	
	/**
	 * Column Info
	 * @param closePolYdCd
	 */
	public void setClosePolYdCd(String closePolYdCd) {
		this.closePolYdCd = closePolYdCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param closePolCd
	 */
	public void setClosePolCd(String closePolCd) {
		this.closePolCd = closePolCd;
	}
	
	/**
	 * Column Info
	 * @param prePodCd
	 */
	public void setPrePodCd(String prePodCd) {
		this.prePodCd = prePodCd;
	}
	
	/**
	 * Column Info
	 * @param oldQtyVol
	 */
	public void setOldQtyVol(String oldQtyVol) {
		this.oldQtyVol = oldQtyVol;
	}
	
	/**
	 * Column Info
	 * @param newPolYdCd
	 */
	public void setNewPolYdCd(String newPolYdCd) {
		this.newPolYdCd = newPolYdCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param newQtyVol
	 */
	public void setNewQtyVol(String newQtyVol) {
		this.newQtyVol = newQtyVol;
	}
	
	/**
	 * Column Info
	 * @param newPodYdCd
	 */
	public void setNewPodYdCd(String newPodYdCd) {
		this.newPodYdCd = newPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param newPodCd
	 */
	public void setNewPodCd(String newPodCd) {
		this.newPodCd = newPodCd;
	}
	
	/**
	 * Column Info
	 * @param newVvd
	 */
	public void setNewVvd(String newVvd) {
		this.newVvd = newVvd;
	}
	
	/**
	 * Column Info
	 * @param newCntrList
	 */
	public void setNewCntrList(String newCntrList) {
		this.newCntrList = newCntrList;
	}
	
	/**
	 * Column Info
	 * @param closePodYdCd
	 */
	public void setClosePodYdCd(String closePodYdCd) {
		this.closePodYdCd = closePodYdCd;
	}
	
	public String getNewYdCdSeq() {
		return newYdCdSeq;
	}

	public void setNewYdCdSeq(String newYdCdSeq) {
		this.newYdCdSeq = newYdCdSeq;
	}

	public String getPreYdCdSeq() {
		return preYdCdSeq;
	}

	public void setPreYdCdSeq(String preYdCdSeq) {
		this.preYdCdSeq = preYdCdSeq;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPrePolYdCd(JSPUtil.getParameter(request, prefix + "pre_pol_yd_cd", ""));
		setCntrList(JSPUtil.getParameter(request, prefix + "cntr_list", ""));
		setCloseVvd(JSPUtil.getParameter(request, prefix + "close_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNewPolCd(JSPUtil.getParameter(request, prefix + "new_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
		setPrePodYdCd(JSPUtil.getParameter(request, prefix + "pre_pod_yd_cd", ""));
		setClosePodCd(JSPUtil.getParameter(request, prefix + "close_pod_cd", ""));
		setPrePolCd(JSPUtil.getParameter(request, prefix + "pre_pol_cd", ""));
		setClosePolYdCd(JSPUtil.getParameter(request, prefix + "close_pol_yd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setClosePolCd(JSPUtil.getParameter(request, prefix + "close_pol_cd", ""));
		setPrePodCd(JSPUtil.getParameter(request, prefix + "pre_pod_cd", ""));
		setOldQtyVol(JSPUtil.getParameter(request, prefix + "old_qty_vol", ""));
		setNewPolYdCd(JSPUtil.getParameter(request, prefix + "new_pol_yd_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setNewQtyVol(JSPUtil.getParameter(request, prefix + "new_qty_vol", ""));
		setNewPodYdCd(JSPUtil.getParameter(request, prefix + "new_pod_yd_cd", ""));
		setNewPodCd(JSPUtil.getParameter(request, prefix + "new_pod_cd", ""));
		setNewVvd(JSPUtil.getParameter(request, prefix + "new_vvd", ""));
		setNewCntrList(JSPUtil.getParameter(request, prefix + "new_cntr_list", ""));
		setClosePodYdCd(JSPUtil.getParameter(request, prefix + "close_pod_yd_cd", ""));
		setNewYdCdSeq(JSPUtil.getParameter(request, prefix + "new_yd_cd_seq", ""));
		setPreYdCdSeq(JSPUtil.getParameter(request, prefix + "pre_yd_cd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCloseVO[]
	 */
	public BkgCloseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCloseVO[]
	 */
	public BkgCloseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCloseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] prePolYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_pol_yd_cd", length));
			String[] cntrList = (JSPUtil.getParameter(request, prefix	+ "cntr_list", length));
			String[] closeVvd = (JSPUtil.getParameter(request, prefix	+ "close_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] newPolCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] preVvd = (JSPUtil.getParameter(request, prefix	+ "pre_vvd", length));
			String[] prePodYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_pod_yd_cd", length));
			String[] closePodCd = (JSPUtil.getParameter(request, prefix	+ "close_pod_cd", length));
			String[] prePolCd = (JSPUtil.getParameter(request, prefix	+ "pre_pol_cd", length));
			String[] closePolYdCd = (JSPUtil.getParameter(request, prefix	+ "close_pol_yd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] closePolCd = (JSPUtil.getParameter(request, prefix	+ "close_pol_cd", length));
			String[] prePodCd = (JSPUtil.getParameter(request, prefix	+ "pre_pod_cd", length));
			String[] oldQtyVol = (JSPUtil.getParameter(request, prefix	+ "old_qty_vol", length));
			String[] newPolYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pol_yd_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] newQtyVol = (JSPUtil.getParameter(request, prefix	+ "new_qty_vol", length));
			String[] newPodYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_yd_cd", length));
			String[] newPodCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_cd", length));
			String[] newVvd = (JSPUtil.getParameter(request, prefix	+ "new_vvd", length));
			String[] newCntrList = (JSPUtil.getParameter(request, prefix	+ "new_cntr_list", length));
			String[] closePodYdCd = (JSPUtil.getParameter(request, prefix	+ "close_pod_yd_cd", length));
			String[] newYdCdSeq = (JSPUtil.getParameter(request, prefix	+ "new_yd_cd_seq", length));
			String[] preYdCdSeq = (JSPUtil.getParameter(request, prefix	+ "pre_yd_cd_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCloseVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (prePolYdCd[i] != null)
					model.setPrePolYdCd(prePolYdCd[i]);
				if (cntrList[i] != null)
					model.setCntrList(cntrList[i]);
				if (closeVvd[i] != null)
					model.setCloseVvd(closeVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (newPolCd[i] != null)
					model.setNewPolCd(newPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (preVvd[i] != null)
					model.setPreVvd(preVvd[i]);
				if (prePodYdCd[i] != null)
					model.setPrePodYdCd(prePodYdCd[i]);
				if (closePodCd[i] != null)
					model.setClosePodCd(closePodCd[i]);
				if (prePolCd[i] != null)
					model.setPrePolCd(prePolCd[i]);
				if (closePolYdCd[i] != null)
					model.setClosePolYdCd(closePolYdCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (closePolCd[i] != null)
					model.setClosePolCd(closePolCd[i]);
				if (prePodCd[i] != null)
					model.setPrePodCd(prePodCd[i]);
				if (oldQtyVol[i] != null)
					model.setOldQtyVol(oldQtyVol[i]);
				if (newPolYdCd[i] != null)
					model.setNewPolYdCd(newPolYdCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (newQtyVol[i] != null)
					model.setNewQtyVol(newQtyVol[i]);
				if (newPodYdCd[i] != null)
					model.setNewPodYdCd(newPodYdCd[i]);
				if (newPodCd[i] != null)
					model.setNewPodCd(newPodCd[i]);
				if (newVvd[i] != null)
					model.setNewVvd(newVvd[i]);
				if (newCntrList[i] != null)
					model.setNewCntrList(newCntrList[i]);
				if (closePodYdCd[i] != null)
					model.setClosePodYdCd(closePodYdCd[i]);
				if (newYdCdSeq[i] != null)
					model.setNewYdCdSeq(newYdCdSeq[i]);
				if (preYdCdSeq[i] != null)
					model.setPreYdCdSeq(preYdCdSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCloseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCloseVO[]
	 */
	public BkgCloseVO[] getBkgCloseVOs(){
		BkgCloseVO[] vos = (BkgCloseVO[])models.toArray(new BkgCloseVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePolYdCd = this.prePolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrList = this.cntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closeVvd = this.closeVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolCd = this.newPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preVvd = this.preVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePodYdCd = this.prePodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closePodCd = this.closePodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePolCd = this.prePolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closePolYdCd = this.closePolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closePolCd = this.closePolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePodCd = this.prePodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldQtyVol = this.oldQtyVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPolYdCd = this.newPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newQtyVol = this.newQtyVol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodYdCd = this.newPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodCd = this.newPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newVvd = this.newVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCntrList = this.newCntrList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.closePodYdCd = this.closePodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newYdCdSeq = this.newYdCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preYdCdSeq = this.preYdCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
