/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpclRiderVO.java
*@FileTitle : SpclRiderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.19 이진서
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

public class SpclRiderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SpclRiderVO> models = new ArrayList<SpclRiderVO>();

	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String imgSeq = null;
	/* Column Info */
	private String rgstUsrId = null;
	/* Column Info */
	private String cargoContain = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String cargoCnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileSize = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rgstOfcCd = null;
	/* Column Info */
	private String filePathRmk = null;
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

	public SpclRiderVO() {}

	public SpclRiderVO(String ibflag, String pagerows, String bkgNo, String ridrTpCd, String fileNm, String fileSize, String imgSeq, String filePathRmk, String fileSavId, String cargoContain, String cargoCnt, String dcgoSeq, String rgstOfcCd, String rgstDt, String rgstUsrId) {
		this.fileSavId = fileSavId;
		this.imgSeq = imgSeq;
		this.rgstUsrId = rgstUsrId;
		this.cargoContain = cargoContain;
		this.dcgoSeq = dcgoSeq;
		this.cargoCnt = cargoCnt;
		this.pagerows = pagerows;
		this.fileSize = fileSize;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rgstOfcCd = rgstOfcCd;
		this.filePathRmk = filePathRmk;
		this.ridrTpCd = ridrTpCd;
		this.fileNm = fileNm;
		this.rgstDt = rgstDt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("img_seq", getImgSeq());
		this.hashColumns.put("rgst_usr_id", getRgstUsrId());
		this.hashColumns.put("cargo_contain", getCargoContain());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("cargo_cnt", getCargoCnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rgst_ofc_cd", getRgstOfcCd());
		this.hashColumns.put("file_path_rmk", getFilePathRmk());
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
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("img_seq", "imgSeq");
		this.hashFields.put("rgst_usr_id", "rgstUsrId");
		this.hashFields.put("cargo_contain", "cargoContain");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("cargo_cnt", "cargoCnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rgst_ofc_cd", "rgstOfcCd");
		this.hashFields.put("file_path_rmk", "filePathRmk");
		this.hashFields.put("ridr_tp_cd", "ridrTpCd");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("rgst_dt", "rgstDt");
		return this.hashFields;
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
	 * @return imgSeq
	 */
	public String getImgSeq() {
		return this.imgSeq;
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
	 * @return cargoContain
	 */
	public String getCargoContain() {
		return this.cargoContain;
	}

	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}

	/**
	 * Column Info
	 * @return cargoCnt
	 */
	public String getCargoCnt() {
		return this.cargoCnt;
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
	 * @return fileSize
	 */
	public String getFileSize() {
		return this.fileSize;
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
	 * @return rgstOfcCd
	 */
	public String getRgstOfcCd() {
		return this.rgstOfcCd;
	}

	/**
	 * Column Info
	 * @return filePathRmk
	 */
	public String getFilePathRmk() {
		return this.filePathRmk;
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
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}

	/**
	 * Column Info
	 * @param imgSeq
	 */
	public void setImgSeq(String imgSeq) {
		this.imgSeq = imgSeq;
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
	 * @param cargoContain
	 */
	public void setCargoContain(String cargoContain) {
		this.cargoContain = cargoContain;
	}

	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}

	/**
	 * Column Info
	 * @param cargoCnt
	 */
	public void setCargoCnt(String cargoCnt) {
		this.cargoCnt = cargoCnt;
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
	 * @param fileSize
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
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
	 * @param rgstOfcCd
	 */
	public void setRgstOfcCd(String rgstOfcCd) {
		this.rgstOfcCd = rgstOfcCd;
	}

	/**
	 * Column Info
	 * @param filePathRmk
	 */
	public void setFilePathRmk(String filePathRmk) {
		this.filePathRmk = filePathRmk;
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
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setImgSeq(JSPUtil.getParameter(request, "img_seq", ""));
		setRgstUsrId(JSPUtil.getParameter(request, "rgst_usr_id", ""));
		setCargoContain(JSPUtil.getParameter(request, "cargo_contain", ""));
		setDcgoSeq(JSPUtil.getParameter(request, "dcgo_seq", ""));
		setCargoCnt(JSPUtil.getParameter(request, "cargo_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFileSize(JSPUtil.getParameter(request, "file_size", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRgstOfcCd(JSPUtil.getParameter(request, "rgst_ofc_cd", ""));
		setFilePathRmk(JSPUtil.getParameter(request, "file_path_rmk", ""));
		setRidrTpCd(JSPUtil.getParameter(request, "ridr_tp_cd", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpclRiderVO[]
	 */
	public SpclRiderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SpclRiderVO[]
	 */
	public SpclRiderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpclRiderVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] imgSeq = (JSPUtil.getParameter(request, prefix	+ "img_seq", length));
			String[] rgstUsrId = (JSPUtil.getParameter(request, prefix	+ "rgst_usr_id", length));
			String[] cargoContain = (JSPUtil.getParameter(request, prefix	+ "cargo_contain", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] cargoCnt = (JSPUtil.getParameter(request, prefix	+ "cargo_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rgstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgst_ofc_cd", length));
			String[] filePathRmk = (JSPUtil.getParameter(request, prefix	+ "file_path_rmk", length));
			String[] ridrTpCd = (JSPUtil.getParameter(request, prefix	+ "ridr_tp_cd", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));

			for (int i = 0; i < length; i++) {
				model = new SpclRiderVO();
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (imgSeq[i] != null)
					model.setImgSeq(imgSeq[i]);
				if (rgstUsrId[i] != null)
					model.setRgstUsrId(rgstUsrId[i]);
				if (cargoContain[i] != null)
					model.setCargoContain(cargoContain[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (cargoCnt[i] != null)
					model.setCargoCnt(cargoCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rgstOfcCd[i] != null)
					model.setRgstOfcCd(rgstOfcCd[i]);
				if (filePathRmk[i] != null)
					model.setFilePathRmk(filePathRmk[i]);
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
		return getSpclRiderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpclRiderVO[]
	 */
	public SpclRiderVO[] getSpclRiderVOs(){
		SpclRiderVO[] vos = (SpclRiderVO[])models.toArray(new SpclRiderVO[models.size()]);
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
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgSeq = this.imgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstUsrId = this.rgstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoContain = this.cargoContain .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoCnt = this.cargoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstOfcCd = this.rgstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathRmk = this.filePathRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ridrTpCd = this.ridrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
