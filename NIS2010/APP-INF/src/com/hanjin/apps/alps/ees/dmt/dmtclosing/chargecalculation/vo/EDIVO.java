/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EDIVO.java
*@FileTitle : EDIVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EDIVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EDIVO> models = new ArrayList<EDIVO>();
	
	private SignOnUserAccount acount = null;
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dmdtEdiHisSeq = null;
	/* Column Info */
	private String detFtOvrDys = null;
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String ediIssUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ediIssDt = null;
	/* Column Info */
	private String detFtEndDt = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String demFtEndDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ftEndDt = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EDIVO() {}

	public EDIVO(String ibflag, String pagerows, String bkgNo, String sysAreaGrpId, String cntrNo, String cntrCycNo, String dmdtEdiHisSeq, String ediIssDt, String ediIssUsrId, String demFtEndDt, String detFtEndDt, String detFtOvrDys, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String ftEndDt) {
		this.updDt = updDt;
		this.dmdtEdiHisSeq = dmdtEdiHisSeq;
		this.detFtOvrDys = detFtOvrDys;
		this.cntrCycNo = cntrCycNo;
		this.ediIssUsrId = ediIssUsrId;
		this.creDt = creDt;
		this.ediIssDt = ediIssDt;
		this.detFtEndDt = detFtEndDt;
		this.sysAreaGrpId = sysAreaGrpId;
		this.pagerows = pagerows;
		this.demFtEndDt = demFtEndDt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.cntrNo = cntrNo;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dmdt_edi_his_seq", getDmdtEdiHisSeq());
		this.hashColumns.put("det_ft_ovr_dys", getDetFtOvrDys());
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("edi_iss_usr_id", getEdiIssUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("edi_iss_dt", getEdiIssDt());
		this.hashColumns.put("det_ft_end_dt", getDetFtEndDt());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dem_ft_end_dt", getDemFtEndDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dmdt_edi_his_seq", "dmdtEdiHisSeq");
		this.hashFields.put("det_ft_ovr_dys", "detFtOvrDys");
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("edi_iss_usr_id", "ediIssUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("edi_iss_dt", "ediIssDt");
		this.hashFields.put("det_ft_end_dt", "detFtEndDt");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dem_ft_end_dt", "demFtEndDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtEdiHisSeq
	 */
	public String getDmdtEdiHisSeq() {
		return this.dmdtEdiHisSeq;
	}
	
	/**
	 * Column Info
	 * @return detFtOvrDys
	 */
	public String getDetFtOvrDys() {
		return this.detFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return ediIssUsrId
	 */
	public String getEdiIssUsrId() {
		return this.ediIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return ediIssDt
	 */
	public String getEdiIssDt() {
		return this.ediIssDt;
	}
	
	/**
	 * Column Info
	 * @return detFtEndDt
	 */
	public String getDetFtEndDt() {
		return this.detFtEndDt;
	}
	
	/**
	 * Column Info
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
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
	 * @return demFtEndDt
	 */
	public String getDemFtEndDt() {
		return this.demFtEndDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return ftEndDt
	 */
	public String getFtEndDt() {
		return ftEndDt;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtEdiHisSeq
	 */
	public void setDmdtEdiHisSeq(String dmdtEdiHisSeq) {
		this.dmdtEdiHisSeq = dmdtEdiHisSeq;
	}
	
	/**
	 * Column Info
	 * @param detFtOvrDys
	 */
	public void setDetFtOvrDys(String detFtOvrDys) {
		this.detFtOvrDys = detFtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param ediIssUsrId
	 */
	public void setEdiIssUsrId(String ediIssUsrId) {
		this.ediIssUsrId = ediIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param ediIssDt
	 */
	public void setEdiIssDt(String ediIssDt) {
		this.ediIssDt = ediIssDt;
	}
	
	/**
	 * Column Info
	 * @param detFtEndDt
	 */
	public void setDetFtEndDt(String detFtEndDt) {
		this.detFtEndDt = detFtEndDt;
	}
	
	/**
	 * Column Info
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
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
	 * @param demFtEndDt
	 */
	public void setDemFtEndDt(String demFtEndDt) {
		this.demFtEndDt = demFtEndDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @return ftEndDt
	 */
	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDmdtEdiHisSeq(JSPUtil.getParameter(request, "dmdt_edi_his_seq", ""));
		setDetFtOvrDys(JSPUtil.getParameter(request, "det_ft_ovr_dys", ""));
		setCntrCycNo(JSPUtil.getParameter(request, "cntr_cyc_no", ""));
		setEdiIssUsrId(JSPUtil.getParameter(request, "edi_iss_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEdiIssDt(JSPUtil.getParameter(request, "edi_iss_dt", ""));
		setDetFtEndDt(JSPUtil.getParameter(request, "det_ft_end_dt", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, "sys_area_grp_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDemFtEndDt(JSPUtil.getParameter(request, "dem_ft_end_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFtEndDt(JSPUtil.getParameter(request, "ft_end_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EDIVO[]
	 */
	public EDIVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EDIVO[]
	 */
	public EDIVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EDIVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dmdtEdiHisSeq = (JSPUtil.getParameter(request, prefix	+ "dmdt_edi_his_seq", length));
			String[] detFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "det_ft_ovr_dys", length));
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] ediIssUsrId = (JSPUtil.getParameter(request, prefix	+ "edi_iss_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ediIssDt = (JSPUtil.getParameter(request, prefix	+ "edi_iss_dt", length));
			String[] detFtEndDt = (JSPUtil.getParameter(request, prefix	+ "det_ft_end_dt", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] demFtEndDt = (JSPUtil.getParameter(request, prefix	+ "dem_ft_end_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));

			
			for (int i = 0; i < length; i++) {
				model = new EDIVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dmdtEdiHisSeq[i] != null)
					model.setDmdtEdiHisSeq(dmdtEdiHisSeq[i]);
				if (detFtOvrDys[i] != null)
					model.setDetFtOvrDys(detFtOvrDys[i]);
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (ediIssUsrId[i] != null)
					model.setEdiIssUsrId(ediIssUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ediIssDt[i] != null)
					model.setEdiIssDt(ediIssDt[i]);
				if (detFtEndDt[i] != null)
					model.setDetFtEndDt(detFtEndDt[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (demFtEndDt[i] != null)
					model.setDemFtEndDt(demFtEndDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updUsrId[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEDIVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EDIVO[]
	 */
	public EDIVO[] getEDIVOs(){
		EDIVO[] vos = (EDIVO[])models.toArray(new EDIVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtEdiHisSeq = this.dmdtEdiHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detFtOvrDys = this.detFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediIssUsrId = this.ediIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediIssDt = this.ediIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detFtEndDt = this.detFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demFtEndDt = this.demFtEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	/**
	 * @return the acount
	 */
	public SignOnUserAccount getAcount() {
		return acount;
	}

	/**
	 * @param acount the acount to set
	 */
	public void setAcount(SignOnUserAccount acount) {
		this.acount = acount;
	}	
}
