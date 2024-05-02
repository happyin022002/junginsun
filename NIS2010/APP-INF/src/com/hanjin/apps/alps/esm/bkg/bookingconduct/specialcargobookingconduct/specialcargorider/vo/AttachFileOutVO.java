/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AttachFileOutVO.java
*@FileTitle : AttachFileOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.26 이진서
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo;

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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AttachFileOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AttachFileOutVO> models = new ArrayList<AttachFileOutVO>();

	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String idx = null;
	/* Column Info */
	private String rgstUsrId = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String ridrTpCd = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String rgstDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AttachFileOutVO() {}

	public AttachFileOutVO(String ibflag, String pagerows, String idx, String ridrTpCd, String bkgNo, String blNo, String slanCd, String vslCd, String polCd, String podCd, String fileNm, String cntrNo, String cntrCgoSeq, String bkgOfcCd, String obSlsOfcCd, String rgstUsrId, String rgstOfcCd, String rgstDt, String usrNm, String fileSavId) {
		this.bkgOfcCd = bkgOfcCd;
		this.fileSavId = fileSavId;
		this.vslCd = vslCd;
		this.idx = idx;
		this.rgstUsrId = rgstUsrId;
		this.blNo = blNo;
		this.cntrCgoSeq = cntrCgoSeq;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.usrNm = usrNm;
		this.rgstOfcCd = rgstOfcCd;
		this.cntrNo = cntrNo;
		this.obSlsOfcCd = obSlsOfcCd;
		this.ridrTpCd = ridrTpCd;
		this.fileNm = fileNm;
		this.rgstDt = rgstDt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("idx", getIdx());
		this.hashColumns.put("rgst_usr_id", getRgstUsrId());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ridr_tp_cd", getRidrTpCd());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("rgst_dt", getRgstDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("idx", "idx");
		this.hashFields.put("rgst_usr_id", "rgstUsrId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ridr_tp_cd", "ridrTpCd");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("rgst_dt", "rgstDt");
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
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return idx
	 */
	public String getIdx() {
		return this.idx;
	}

	/**
	 * Column Info
	 * @return rgstUsrId
	 */
	public String getRgstUsrId() {
		return this.rgstUsrId;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}

	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}

	/**
	 * Column Info
	 * @return rgstOfcCd
	 */
	public String getRgstOfcCd() {
		return this.rgstOfcCd;
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
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}

	/**
	 * Column Info
	 * @return ridrTpCd
	 */
	public String getRidrTpCd() {
		return this.ridrTpCd;
	}

	/**
	 * Column Info
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
	}

	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
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
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param idx
	 */
	public void setIdx(String idx) {
		this.idx = idx;
	}

	/**
	 * Column Info
	 * @param rgstUsrId
	 */
	public void setRgstUsrId(String rgstUsrId) {
		this.rgstUsrId = rgstUsrId;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}

	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	/**
	 * Column Info
	 * @param rgstOfcCd
	 */
	public void setRgstOfcCd(String rgstOfcCd) {
		this.rgstOfcCd = rgstOfcCd;
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
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}

	/**
	 * Column Info
	 * @param ridrTpCd
	 */
	public void setRidrTpCd(String ridrTpCd) {
		this.ridrTpCd = ridrTpCd;
	}

	/**
	 * Column Info
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIdx(JSPUtil.getParameter(request, "idx", ""));
		setRgstUsrId(JSPUtil.getParameter(request, "rgst_usr_id", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, "cntr_cgo_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, "rgst_ofc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setRidrTpCd(JSPUtil.getParameter(request, "ridr_tp_cd", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AttachFileOutVO[]
	 */
	public AttachFileOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AttachFileOutVO[]
	 */
	public AttachFileOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AttachFileOutVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] idx = (JSPUtil.getParameter(request, prefix	+ "idx", length));
			String[] rgstUsrId = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_id", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] ridrTpCd = (JSPUtil.getParameter(request, prefix	+ "ridr_tp_cd", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));

			for (int i = 0; i < length; i++) {
				model = new AttachFileOutVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (idx[i] != null)
					model.setIdx(idx[i]);
				if (rgstUsrId[i] != null)
					model.setRgstUsrId(rgstUsrId[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (ridrTpCd[i] != null)
					model.setRidrTpCd(ridrTpCd[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAttachFileOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AttachFileOutVO[]
	 */
	public AttachFileOutVO[] getAttachFileOutVOs(){
		AttachFileOutVO[] vos = (AttachFileOutVO[])models.toArray(new AttachFileOutVO[models.size()]);
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
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idx = this.idx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrId = this.rgstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ridrTpCd = this.ridrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
