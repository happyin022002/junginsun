/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyBkgListInputVO.java
*@FileTitle : EmptyBkgListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.30 김병규 
* 1.0 Creation
* =======================================================
* * 2015.07.29 YongChan Shin [CHM-201537230] Empty Repo BKG Inquiry 화면 조회옵션 추가
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

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
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EmptyBkgListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptyBkgListInputVO> models = new ArrayList<EmptyBkgListInputVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String cntrNo2 = null;
	/* Column Info */
	private String creFromDt = null;
	/* Column Info */
	private String creToDt = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String cntrAttach = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCdFlg = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String bkgDateTp = null;
	
	// 2015-07-29, added by yongchan shin
	/* Column Info */
	private String bkgStatus = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String cntrTpsz = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EmptyBkgListInputVO() {}

	public EmptyBkgListInputVO(String ibflag, String pagerows, String bkgNo, String blNo, String cntrNo1, String cntrNo2, String polCd, String podCd, String preRlyPortCd, String pstRlyPortCd, String creFromDt, String creToDt, String vvdCd, String vvdCdFlg, String bkgOfcCd, String cntrAttach, String bkgDateTp, String bkgStatus, String tpsztype, String cntrTpsz) {
		this.bkgOfcCd = bkgOfcCd;
		this.cntrNo2 = cntrNo2;
		this.creFromDt = creFromDt;
		this.creToDt = creToDt;
		this.preRlyPortCd = preRlyPortCd;
		this.cntrAttach = cntrAttach;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cntrNo1 = cntrNo1;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.vvdCdFlg = vvdCdFlg;
		this.vvdCd = vvdCd;
		this.pstRlyPortCd = pstRlyPortCd;
		this.bkgDateTp = bkgDateTp;		
		this.bkgStatus = bkgStatus;
		this.tpsztype  = tpsztype;
		this.cntrTpsz  = cntrTpsz;		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cntr_no2", getCntrNo2());
		this.hashColumns.put("cre_from_dt", getCreFromDt());
		this.hashColumns.put("cre_to_dt", getCreToDt());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("cntr_attach", getCntrAttach());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd_flg", getVvdCdFlg());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("bkg_date_tp", getBkgDateTp());	
		this.hashColumns.put("bkg_status", getBkgStatus());	
		this.hashColumns.put("tpsztype", getTpsztype());	
		this.hashColumns.put("cntrTpsz", getCntrTpsz());	
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cntr_no2", "cntrNo2");
		this.hashFields.put("cre_from_dt", "creFromDt");
		this.hashFields.put("cre_to_dt", "creToDt");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("cntr_attach", "cntrAttach");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd_flg", "vvdCdFlg");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("bkg_date_tp", "bkgDateTp");		
		this.hashFields.put("bkg_status", "bkgStatus");		
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("cntrTpsz", "cntrTpsz");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo2
	 */
	public String getCntrNo2() {
		return this.cntrNo2;
	}
	
	/**
	 * Column Info
	 * @return creFromDt
	 */
	public String getCreFromDt() {
		return this.creFromDt;
	}
	
	/**
	 * Column Info
	 * @return creToDt
	 */
	public String getCreToDt() {
		return this.creToDt;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return cntrAttach
	 */
	public String getCntrAttach() {
		return this.cntrAttach;
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
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCdFlg
	 */
	public String getVvdCdFlg() {
		return this.vvdCdFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDateTp
	 */
	public String getBkgDateTp() {
		return this.bkgDateTp;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo2
	 */
	public void setCntrNo2(String cntrNo2) {
		this.cntrNo2 = cntrNo2;
	}
	
	/**
	 * Column Info
	 * @param creFromDt
	 */
	public void setCreFromDt(String creFromDt) {
		this.creFromDt = creFromDt;
	}
	
	/**
	 * Column Info
	 * @param creToDt
	 */
	public void setCreToDt(String creToDt) {
		this.creToDt = creToDt;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param cntrAttach
	 */
	public void setCntrAttach(String cntrAttach) {
		this.cntrAttach = cntrAttach;
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
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCdFlg
	 */
	public void setVvdCdFlg(String vvdCdFlg) {
		this.vvdCdFlg = vvdCdFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDateTp
	 */
	public void setBkgDateTp(String bkgDateTp) {
		this.bkgDateTp = bkgDateTp;
	}

	/**
	 * Column Info
	 * @return bkgStatus
	 */
	public String getBkgStatus() {
		return bkgStatus;
	}
	
	/**
	 * Column Info
	 * @param bkgStatus
	 */
	public void setBkgStatus(String bkgStatus) {
		this.bkgStatus = bkgStatus;
	}	
	
	/**
	 * Column Info
	 * @return tpsztype
	 */	
	public String getTpsztype() {
		return tpsztype;
	}

	/**
	 * Column Info
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}	
	
	/**
	 * Column Info
	 * @return cntrTpsz
	 */		
	public String getCntrTpsz() {
		return cntrTpsz;
	}

	/**
	 * Column Info
	 * @param cntrTpsz
	 */
	public void setCntrTpsz(String cntrTpsz) {
		this.cntrTpsz = cntrTpsz;
	}	
		
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setCntrNo2(JSPUtil.getParameter(request, "cntr_no2", ""));
		setCreFromDt(JSPUtil.getParameter(request, "cre_from_dt", ""));
		setCreToDt(JSPUtil.getParameter(request, "cre_to_dt", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setCntrAttach(JSPUtil.getParameter(request, "cntr_attach", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrNo1(JSPUtil.getParameter(request, "cntr_no1", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCdFlg(JSPUtil.getParameter(request, "vvd_cd_flg", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setBkgDateTp(JSPUtil.getParameter(request, "bkg_date_tp", ""));		
		setBkgStatus(JSPUtil.getParameter(request, "bkg_status", ""));	
		setTpsztype(JSPUtil.getParameter(request, "tpsztype", ""));	
		setCntrTpsz(JSPUtil.getParameter(request, "cntrTpsz", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptyBkgListInputVO[]
	 */
	public EmptyBkgListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptyBkgListInputVO[]
	 */
	public EmptyBkgListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptyBkgListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] cntrNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_no2", length));
			String[] creFromDt = (JSPUtil.getParameter(request, prefix	+ "cre_from_dt", length));
			String[] creToDt = (JSPUtil.getParameter(request, prefix	+ "cre_to_dt", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] cntrAttach = (JSPUtil.getParameter(request, prefix	+ "cntr_attach", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCdFlg = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_flg", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] bkgDateTp = (JSPUtil.getParameter(request, prefix	+ "bkg_date_tp", length));			
			String[] bkgStatus = (JSPUtil.getParameter(request, prefix	+ "bkg_status", length));	
			String[] tpsztype  = (JSPUtil.getParameter(request, prefix	+ "tpsztype", length));	
			String[] cntrTpsz  = (JSPUtil.getParameter(request, prefix	+ "cntrTpsz", length));	
			
			for (int i = 0; i < length; i++) {
				model = new EmptyBkgListInputVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (cntrNo2[i] != null)
					model.setCntrNo2(cntrNo2[i]);
				if (creFromDt[i] != null)
					model.setCreFromDt(creFromDt[i]);
				if (creToDt[i] != null)
					model.setCreToDt(creToDt[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (cntrAttach[i] != null)
					model.setCntrAttach(cntrAttach[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCdFlg[i] != null)
					model.setVvdCdFlg(vvdCdFlg[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (bkgDateTp[i] != null)
					model.setBkgDateTp(bkgDateTp[i]);		
				if (bkgStatus[i] != null)
					model.setBkgStatus(bkgStatus[i]);	
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);	
				if (cntrTpsz[i] != null)
					model.setCntrTpsz(cntrTpsz[i]);					
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptyBkgListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptyBkgListInputVO[]
	 */
	public EmptyBkgListInputVO[] getEmptyBkgListInputVOs(){
		EmptyBkgListInputVO[] vos = (EmptyBkgListInputVO[])models.toArray(new EmptyBkgListInputVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo2 = this.cntrNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFromDt = this.creFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creToDt = this.creToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAttach = this.cntrAttach .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdFlg = this.vvdCdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDateTp = this.bkgDateTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.bkgStatus = this.bkgStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.cntrTpsz = this.cntrTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}






}
