/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBkgInfoVO.java
*@FileTitle : KorBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.06 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBkgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorBkgInfoVO> models = new ArrayList<KorBkgInfoVO>();
	
	/* Column Info */
	private String cstmTpCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bkgRepCmdtCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String discCd = null;
	/* Column Info */
	private String localTs = null;
	/* Column Info */
	private String vvdPolCd = null;
	/* Column Info */
	private String vvdSlanCd = null;
	/* Column Info */
	private String vvdVslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgPodCd = null;
	/* Column Info */
	private String bkgPolCd = null;
	/* Column Info */
	private String blTp = null;
	/* Column Info */
	private String bkgBkgNo = null;
	/* Column Info */
	private String vvdSkdDirCd = null;
	/* Column Info */
	private String vvdSkdVoyNo = null;
	/* Column Info */
	private String vvdPodCd = null;
	/* Column Info */
	private String bkgBlNo = null;
	/* Column Info */
	private String krCstmsCustTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorBkgInfoVO() {}

	public KorBkgInfoVO(String ibflag, String pagerows, String bkgBkgNo, String vvdPolCd, String vvdPodCd, String vvdSlanCd, String bkgPodCd, String bkgCgoTpCd, String bkgRepCmdtCd, String bkgStsCd, String vvdVslCd, String vvdSkdVoyNo, String vvdSkdDirCd, String localTs, String blTp, String discCd, String cstmTpCd, String krCstmsCustTpCd, String bkgPolCd) {
		this.cstmTpCd = cstmTpCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bkgRepCmdtCd = bkgRepCmdtCd;
		this.bkgStsCd = bkgStsCd;
		this.discCd = discCd;
		this.localTs = localTs;
		this.vvdPolCd = vvdPolCd;
		this.vvdSlanCd = vvdSlanCd;
		this.vvdVslCd = vvdVslCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgPodCd = bkgPodCd;
		this.blTp = blTp;
		this.bkgBkgNo = bkgBkgNo;
		this.vvdSkdDirCd = vvdSkdDirCd;
		this.vvdSkdVoyNo = vvdSkdVoyNo;
		this.vvdPodCd = vvdPodCd;
		this.krCstmsCustTpCd = krCstmsCustTpCd;
		this.bkgPolCd = bkgPolCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstm_tp_cd", getCstmTpCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bkg_rep_cmdt_cd", getBkgRepCmdtCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("disc_cd", getDiscCd());
		this.hashColumns.put("local_ts", getLocalTs());
		this.hashColumns.put("vvd_pol_cd", getVvdPolCd());
		this.hashColumns.put("vvd_slan_cd", getVvdSlanCd());
		this.hashColumns.put("vvd_vsl_cd", getVvdVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("bkg_bkg_no", getBkgBkgNo());
		this.hashColumns.put("vvd_skd_dir_cd", getVvdSkdDirCd());
		this.hashColumns.put("vvd_skd_voy_no", getVvdSkdVoyNo());
		this.hashColumns.put("vvd_pod_cd", getVvdPodCd());
		this.hashColumns.put("kr_cstms_cust_tp_cd", getKrCstmsCustTpCd());
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstm_tp_cd", "cstmTpCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bkg_rep_cmdt_cd", "bkgRepCmdtCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("disc_cd", "discCd");
		this.hashFields.put("local_ts", "localTs");
		this.hashFields.put("vvd_pol_cd", "vvdPolCd");
		this.hashFields.put("vvd_slan_cd", "vvdSlanCd");
		this.hashFields.put("vvd_vsl_cd", "vvdVslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("bkg_bkg_no", "bkgBkgNo");
		this.hashFields.put("vvd_skd_dir_cd", "vvdSkdDirCd");
		this.hashFields.put("vvd_skd_voy_no", "vvdSkdVoyNo");
		this.hashFields.put("vvd_pod_cd", "vvdPodCd");
		this.hashFields.put("kr_cstms_cust_tp_cd", "krCstmsCustTpCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		return this.hashFields;
	}
	
	/**
	 * @return the bkgBlNo
	 */
	public String getBkgBlNo() {
		return bkgBlNo;
	}

	/**
	 * @param bkgBlNo the bkgBlNo to set
	 */
	public void setBkgBlNo(String bkgBlNo) {
		this.bkgBlNo = bkgBlNo;
	}

	/**
	 * @return the krCstmsCustTpCd
	 */
	public String getKrCstmsCustTpCd() {
		return krCstmsCustTpCd;
	}

	/**
	 * @param krCstmsCustTpCd the krCstmsCustTpCd to set
	 */
	public void setKrCstmsCustTpCd(String krCstmsCustTpCd) {
		this.krCstmsCustTpCd = krCstmsCustTpCd;
	}

	/**
	 * @return the bkgPolCd
	 */
	public String getBkgPolCd() {
		return bkgPolCd;
	}

	/**
	 * @param bkgPolCd the bkgPolCd to set
	 */
	public void setBkgPolCd(String bkgPolCd) {
		this.bkgPolCd = bkgPolCd;
	}

	/**
	 * Column Info
	 * @return cstmTpCd
	 */
	public String getCstmTpCd() {
		return this.cstmTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRepCmdtCd
	 */
	public String getBkgRepCmdtCd() {
		return this.bkgRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return discCd
	 */
	public String getDiscCd() {
		return this.discCd;
	}
	
	/**
	 * Column Info
	 * @return localTs
	 */
	public String getLocalTs() {
		return this.localTs;
	}
	
	/**
	 * Column Info
	 * @return vvdPolCd
	 */
	public String getVvdPolCd() {
		return this.vvdPolCd;
	}
	
	/**
	 * Column Info
	 * @return vvdSlanCd
	 */
	public String getVvdSlanCd() {
		return this.vvdSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vvdVslCd
	 */
	public String getVvdVslCd() {
		return this.vvdVslCd;
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
	 * @return bkgPodCd
	 */
	public String getBkgPodCd() {
		return this.bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @return blTp
	 */
	public String getBlTp() {
		return this.blTp;
	}
	
	/**
	 * Column Info
	 * @return bkgBkgNo
	 */
	public String getBkgBkgNo() {
		return this.bkgBkgNo;
	}
	
	/**
	 * Column Info
	 * @return vvdSkdDirCd
	 */
	public String getVvdSkdDirCd() {
		return this.vvdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vvdSkdVoyNo
	 */
	public String getVvdSkdVoyNo() {
		return this.vvdSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vvdPodCd
	 */
	public String getVvdPodCd() {
		return this.vvdPodCd;
	}
	

	/**
	 * Column Info
	 * @param cstmTpCd
	 */
	public void setCstmTpCd(String cstmTpCd) {
		this.cstmTpCd = cstmTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRepCmdtCd
	 */
	public void setBkgRepCmdtCd(String bkgRepCmdtCd) {
		this.bkgRepCmdtCd = bkgRepCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param discCd
	 */
	public void setDiscCd(String discCd) {
		this.discCd = discCd;
	}
	
	/**
	 * Column Info
	 * @param localTs
	 */
	public void setLocalTs(String localTs) {
		this.localTs = localTs;
	}
	
	/**
	 * Column Info
	 * @param vvdPolCd
	 */
	public void setVvdPolCd(String vvdPolCd) {
		this.vvdPolCd = vvdPolCd;
	}
	
	/**
	 * Column Info
	 * @param vvdSlanCd
	 */
	public void setVvdSlanCd(String vvdSlanCd) {
		this.vvdSlanCd = vvdSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vvdVslCd
	 */
	public void setVvdVslCd(String vvdVslCd) {
		this.vvdVslCd = vvdVslCd;
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
	 * @param bkgPodCd
	 */
	public void setBkgPodCd(String bkgPodCd) {
		this.bkgPodCd = bkgPodCd;
	}
	
	/**
	 * Column Info
	 * @param blTp
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}
	
	/**
	 * Column Info
	 * @param bkgBkgNo
	 */
	public void setBkgBkgNo(String bkgBkgNo) {
		this.bkgBkgNo = bkgBkgNo;
	}
	
	/**
	 * Column Info
	 * @param vvdSkdDirCd
	 */
	public void setVvdSkdDirCd(String vvdSkdDirCd) {
		this.vvdSkdDirCd = vvdSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vvdSkdVoyNo
	 */
	public void setVvdSkdVoyNo(String vvdSkdVoyNo) {
		this.vvdSkdVoyNo = vvdSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vvdPodCd
	 */
	public void setVvdPodCd(String vvdPodCd) {
		this.vvdPodCd = vvdPodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCstmTpCd(JSPUtil.getParameter(request, "cstm_tp_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setBkgRepCmdtCd(JSPUtil.getParameter(request, "bkg_rep_cmdt_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setDiscCd(JSPUtil.getParameter(request, "disc_cd", ""));
		setLocalTs(JSPUtil.getParameter(request, "local_ts", ""));
		setVvdPolCd(JSPUtil.getParameter(request, "vvd_pol_cd", ""));
		setVvdSlanCd(JSPUtil.getParameter(request, "vvd_slan_cd", ""));
		setVvdVslCd(JSPUtil.getParameter(request, "vvd_vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgPodCd(JSPUtil.getParameter(request, "bkg_pod_cd", ""));
		setBlTp(JSPUtil.getParameter(request, "bl_tp", ""));
		setBkgBkgNo(JSPUtil.getParameter(request, "bkg_bkg_no", ""));
		setVvdSkdDirCd(JSPUtil.getParameter(request, "vvd_skd_dir_cd", ""));
		setVvdSkdVoyNo(JSPUtil.getParameter(request, "vvd_skd_voy_no", ""));
		setVvdPodCd(JSPUtil.getParameter(request, "vvd_pod_cd", ""));
		setKrCstmsCustTpCd(JSPUtil.getParameter(request, "kr_cstms_cust_tp_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request, "bkg_pol_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBkgInfoVO[]
	 */
	public KorBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorBkgInfoVO[]
	 */
	public KorBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBkgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmTpCd = (JSPUtil.getParameter(request, prefix	+ "cstm_tp_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bkgRepCmdtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rep_cmdt_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] discCd = (JSPUtil.getParameter(request, prefix	+ "disc_cd", length));
			String[] localTs = (JSPUtil.getParameter(request, prefix	+ "local_ts", length));
			String[] vvdPolCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pol_cd", length));
			String[] vvdSlanCd = (JSPUtil.getParameter(request, prefix	+ "vvd_slan_cd", length));
			String[] vvdVslCd = (JSPUtil.getParameter(request, prefix	+ "vvd_vsl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgPodCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_cd", length));
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp", length));
			String[] bkgBkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_bkg_no", length));
			String[] vvdSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "vvd_skd_dir_cd", length));
			String[] vvdSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "vvd_skd_voy_no", length));
			String[] vvdPodCd = (JSPUtil.getParameter(request, prefix	+ "vvd_pod_cd", length));
			String[] krCstmsCustTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_cust_tp_cd", length));
			String[] bkgPolCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBkgInfoVO();
				if (cstmTpCd[i] != null)
					model.setCstmTpCd(cstmTpCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bkgRepCmdtCd[i] != null)
					model.setBkgRepCmdtCd(bkgRepCmdtCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (discCd[i] != null)
					model.setDiscCd(discCd[i]);
				if (localTs[i] != null)
					model.setLocalTs(localTs[i]);
				if (vvdPolCd[i] != null)
					model.setVvdPolCd(vvdPolCd[i]);
				if (vvdSlanCd[i] != null)
					model.setVvdSlanCd(vvdSlanCd[i]);
				if (vvdVslCd[i] != null)
					model.setVvdVslCd(vvdVslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgPodCd[i] != null)
					model.setBkgPodCd(bkgPodCd[i]);
				if (blTp[i] != null)
					model.setBlTp(blTp[i]);
				if (bkgBkgNo[i] != null)
					model.setBkgBkgNo(bkgBkgNo[i]);
				if (vvdSkdDirCd[i] != null)
					model.setVvdSkdDirCd(vvdSkdDirCd[i]);
				if (vvdSkdVoyNo[i] != null)
					model.setVvdSkdVoyNo(vvdSkdVoyNo[i]);
				if (vvdPodCd[i] != null)
					model.setVvdPodCd(vvdPodCd[i]);
				if (krCstmsCustTpCd[i] != null)
					model.setKrCstmsCustTpCd(krCstmsCustTpCd[i]);
				if (bkgPolCd[i] != null)
					model.setBkgPolCd(bkgPolCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBkgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBkgInfoVO[]
	 */
	public KorBkgInfoVO[] getKorBkgInfoVOs(){
		KorBkgInfoVO[] vos = (KorBkgInfoVO[])models.toArray(new KorBkgInfoVO[models.size()]);
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
		this.cstmTpCd = this.cstmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRepCmdtCd = this.bkgRepCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discCd = this.discCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTs = this.localTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPolCd = this.vvdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSlanCd = this.vvdSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdVslCd = this.vvdVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd = this.bkgPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBkgNo = this.bkgBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSkdDirCd = this.vvdSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdSkdVoyNo = this.vvdSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPodCd = this.vvdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCustTpCd = this.krCstmsCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd = this.bkgPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
