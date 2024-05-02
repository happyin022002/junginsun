/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CllRfAkCgoDetailVO.java
*@FileTitle : CllRfAkCgoDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.18 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CllRfAkCgoDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CllRfAkCgoDetailVO> models = new ArrayList<CllRfAkCgoDetailVO>();
	
	/* Column Info */
	private String ovrSdLen = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrVentRto = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String fdoTemp = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ovrHgt = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String ovrWgtUtCd = null;
	/* Column Info */
	private String cntrLodgNo = null;
	/* Column Info */
	private String ovrPortLen = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ovrBkwdLen = null;
	/* Column Info */
	private String ovrCntrWgt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String ovrFwrdLen = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String clptIndSeq = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CllRfAkCgoDetailVO() {}

	public CllRfAkCgoDetailVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String bkgNo, String cntrNo, String cntrLodgNo, String ovrFwrdLen, String ovrBkwdLen, String ovrHgt, String ovrPortLen, String ovrSdLen, String ovrWgtUtCd, String ovrCntrWgt, String fdoTemp, String cdoTemp, String cntrVentRto, String updUsrId, String rcSeq, String awkCgoSeq, String clptIndSeq) {
		this.ovrSdLen = ovrSdLen;
		this.vslCd = vslCd;
		this.cntrVentRto = cntrVentRto;
		this.skdVoyNo = skdVoyNo;
		this.fdoTemp = fdoTemp;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ovrHgt = ovrHgt;
		this.cdoTemp = cdoTemp;
		this.ovrWgtUtCd = ovrWgtUtCd;
		this.cntrLodgNo = cntrLodgNo;
		this.ovrPortLen = ovrPortLen;
		this.cntrNo = cntrNo;
		this.ovrBkwdLen = ovrBkwdLen;
		this.ovrCntrWgt = ovrCntrWgt;
		this.portCd = portCd;
		this.ovrFwrdLen = ovrFwrdLen;
		this.updUsrId = updUsrId;
		this.rcSeq = rcSeq;
		this.awkCgoSeq = awkCgoSeq;
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ovr_sd_len", getOvrSdLen());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_vent_rto", getCntrVentRto());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("fdo_temp", getFdoTemp());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ovr_hgt", getOvrHgt());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("ovr_wgt_ut_cd", getOvrWgtUtCd());
		this.hashColumns.put("cntr_lodg_no", getCntrLodgNo());
		this.hashColumns.put("ovr_port_len", getOvrPortLen());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ovr_bkwd_len", getOvrBkwdLen());
		this.hashColumns.put("ovr_cntr_wgt", getOvrCntrWgt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("ovr_fwrd_len", getOvrFwrdLen());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ovr_sd_len", "ovrSdLen");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_vent_rto", "cntrVentRto");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("fdo_temp", "fdoTemp");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ovr_hgt", "ovrHgt");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("ovr_wgt_ut_cd", "ovrWgtUtCd");
		this.hashFields.put("cntr_lodg_no", "cntrLodgNo");
		this.hashFields.put("ovr_port_len", "ovrPortLen");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ovr_bkwd_len", "ovrBkwdLen");
		this.hashFields.put("ovr_cntr_wgt", "ovrCntrWgt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("ovr_fwrd_len", "ovrFwrdLen");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ovrSdLen
	 */
	public String getOvrSdLen() {
		return this.ovrSdLen;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return cntrVentRto
	 */
	public String getCntrVentRto() {
		return this.cntrVentRto;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return fdoTemp
	 */
	public String getFdoTemp() {
		return this.fdoTemp;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return ovrHgt
	 */
	public String getOvrHgt() {
		return this.ovrHgt;
	}
	
	/**
	 * Column Info
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
	}
	
	/**
	 * Column Info
	 * @return ovrWgtUtCd
	 */
	public String getOvrWgtUtCd() {
		return this.ovrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrLodgNo
	 */
	public String getCntrLodgNo() {
		return this.cntrLodgNo;
	}
	
	/**
	 * Column Info
	 * @return ovrPortLen
	 */
	public String getOvrPortLen() {
		return this.ovrPortLen;
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
	 * @return ovrBkwdLen
	 */
	public String getOvrBkwdLen() {
		return this.ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @return ovrCntrWgt
	 */
	public String getOvrCntrWgt() {
		return this.ovrCntrWgt;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return ovrFwrdLen
	 */
	public String getOvrFwrdLen() {
		return this.ovrFwrdLen;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	

	/**
	 * Column Info
	 * @param ovrSdLen
	 */
	public void setOvrSdLen(String ovrSdLen) {
		this.ovrSdLen = ovrSdLen;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param cntrVentRto
	 */
	public void setCntrVentRto(String cntrVentRto) {
		this.cntrVentRto = cntrVentRto;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param fdoTemp
	 */
	public void setFdoTemp(String fdoTemp) {
		this.fdoTemp = fdoTemp;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param ovrHgt
	 */
	public void setOvrHgt(String ovrHgt) {
		this.ovrHgt = ovrHgt;
	}
	
	/**
	 * Column Info
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
	}
	
	/**
	 * Column Info
	 * @param ovrWgtUtCd
	 */
	public void setOvrWgtUtCd(String ovrWgtUtCd) {
		this.ovrWgtUtCd = ovrWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrLodgNo
	 */
	public void setCntrLodgNo(String cntrLodgNo) {
		this.cntrLodgNo = cntrLodgNo;
	}
	
	/**
	 * Column Info
	 * @param ovrPortLen
	 */
	public void setOvrPortLen(String ovrPortLen) {
		this.ovrPortLen = ovrPortLen;
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
	 * @param ovrBkwdLen
	 */
	public void setOvrBkwdLen(String ovrBkwdLen) {
		this.ovrBkwdLen = ovrBkwdLen;
	}
	
	/**
	 * Column Info
	 * @param ovrCntrWgt
	 */
	public void setOvrCntrWgt(String ovrCntrWgt) {
		this.ovrCntrWgt = ovrCntrWgt;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param ovrFwrdLen
	 */
	public void setOvrFwrdLen(String ovrFwrdLen) {
		this.ovrFwrdLen = ovrFwrdLen;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	public String getRcSeq() {
		return rcSeq;
	}

	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}

	public String getAwkCgoSeq() {
		return awkCgoSeq;
	}

	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOvrSdLen(JSPUtil.getParameter(request, "ovr_sd_len", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCntrVentRto(JSPUtil.getParameter(request, "cntr_vent_rto", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setFdoTemp(JSPUtil.getParameter(request, "fdo_temp", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setOvrHgt(JSPUtil.getParameter(request, "ovr_hgt", ""));
		setCdoTemp(JSPUtil.getParameter(request, "cdo_temp", ""));
		setOvrWgtUtCd(JSPUtil.getParameter(request, "ovr_wgt_ut_cd", ""));
		setCntrLodgNo(JSPUtil.getParameter(request, "cntr_lodg_no", ""));
		setOvrPortLen(JSPUtil.getParameter(request, "ovr_port_len", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setOvrBkwdLen(JSPUtil.getParameter(request, "ovr_bkwd_len", ""));
		setOvrCntrWgt(JSPUtil.getParameter(request, "ovr_cntr_wgt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setOvrFwrdLen(JSPUtil.getParameter(request, "ovr_fwrd_len", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRcSeq(JSPUtil.getParameter(request, "rc_seq", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, "awk_cgo_seq", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllRfAkCgoDetailVO[]
	 */
	public CllRfAkCgoDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CllRfAkCgoDetailVO[]
	 */
	public CllRfAkCgoDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllRfAkCgoDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ovrSdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_sd_len", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrVentRto = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_rto", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] fdoTemp = (JSPUtil.getParameter(request, prefix	+ "fdo_temp", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ovrHgt = (JSPUtil.getParameter(request, prefix	+ "ovr_hgt", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] ovrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "ovr_wgt_ut_cd", length));
			String[] cntrLodgNo = (JSPUtil.getParameter(request, prefix	+ "cntr_lodg_no", length));
			String[] ovrPortLen = (JSPUtil.getParameter(request, prefix	+ "ovr_port_len", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ovrBkwdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_bkwd_len", length));
			String[] ovrCntrWgt = (JSPUtil.getParameter(request, prefix	+ "ovr_cntr_wgt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] ovrFwrdLen = (JSPUtil.getParameter(request, prefix	+ "ovr_fwrd_len", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new CllRfAkCgoDetailVO();
				if (ovrSdLen[i] != null)
					model.setOvrSdLen(ovrSdLen[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrVentRto[i] != null)
					model.setCntrVentRto(cntrVentRto[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (fdoTemp[i] != null)
					model.setFdoTemp(fdoTemp[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ovrHgt[i] != null)
					model.setOvrHgt(ovrHgt[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (ovrWgtUtCd[i] != null)
					model.setOvrWgtUtCd(ovrWgtUtCd[i]);
				if (cntrLodgNo[i] != null)
					model.setCntrLodgNo(cntrLodgNo[i]);
				if (ovrPortLen[i] != null)
					model.setOvrPortLen(ovrPortLen[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ovrBkwdLen[i] != null)
					model.setOvrBkwdLen(ovrBkwdLen[i]);
				if (ovrCntrWgt[i] != null)
					model.setOvrCntrWgt(ovrCntrWgt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ovrFwrdLen[i] != null)
					model.setOvrFwrdLen(ovrFwrdLen[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllRfAkCgoDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllRfAkCgoDetailVO[]
	 */
	public CllRfAkCgoDetailVO[] getCllRfAkCgoDetailVOs(){
		CllRfAkCgoDetailVO[] vos = (CllRfAkCgoDetailVO[])models.toArray(new CllRfAkCgoDetailVO[models.size()]);
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
		this.ovrSdLen = this.ovrSdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentRto = this.cntrVentRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdoTemp = this.fdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrHgt = this.ovrHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrWgtUtCd = this.ovrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodgNo = this.cntrLodgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrPortLen = this.ovrPortLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrBkwdLen = this.ovrBkwdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrCntrWgt = this.ovrCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrFwrdLen = this.ovrFwrdLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
