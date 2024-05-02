/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : XterDgRiderVO.java
*@FileTitle : XterDgRiderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.22  
* 1.0 Creation
* 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterDgRiderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterDgRiderVO> models = new ArrayList<XterDgRiderVO>();
	
	/* Column Info */
	private String fileSize = null;
	/* Column Info */
	private String fileSavId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String cargoContain = null;
	/* Column Info */
	private String cargoCnt = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String ridrTpCd = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Bkg Number */
	private String bkgNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public XterDgRiderVO() {}

	public XterDgRiderVO(String ibflag, String pagerows, String xterRqstNo, String ridrTpCd, String fileNm, String fileSize, String fileSavId, String cargoContain, String cargoCnt, String dcgoSeq, String bkgNo) {
		this.fileSize = fileSize;
		this.fileSavId = fileSavId;
		this.ibflag = ibflag;
		this.dcgoSeq = dcgoSeq;
		this.cargoContain = cargoContain;
		this.cargoCnt = cargoCnt;
		this.fileNm = fileNm;
		this.ridrTpCd = ridrTpCd;
		this.xterRqstNo = xterRqstNo;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("cargo_contain", getCargoContain());
		this.hashColumns.put("cargo_cnt", getCargoCnt());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("ridr_tp_cd", getRidrTpCd());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("cargo_contain", "cargoContain");
		this.hashFields.put("cargo_cnt", "cargoCnt");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("ridr_tp_cd", "ridrTpCd");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fileSize
	 */
	public String getFileSize() {
		return this.fileSize;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
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
	 * @return cargoCnt
	 */
	public String getCargoCnt() {
		return this.cargoCnt;
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
	 * @return ridrTpCd
	 */
	public String getRidrTpCd() {
		return this.ridrTpCd;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param fileSize
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
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
	 * @param cargoCnt
	 */
	public void setCargoCnt(String cargoCnt) {
		this.cargoCnt = cargoCnt;
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
	 * @param ridrTpCd
	 */
	public void setRidrTpCd(String ridrTpCd) {
		this.ridrTpCd = ridrTpCd;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
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
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setCargoContain(JSPUtil.getParameter(request, prefix + "cargo_contain", ""));
		setCargoCnt(JSPUtil.getParameter(request, prefix + "cargo_cnt", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setRidrTpCd(JSPUtil.getParameter(request, prefix + "ridr_tp_cd", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterDgRiderVO[]
	 */
	public XterDgRiderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterDgRiderVO[]
	 */
	public XterDgRiderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterDgRiderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] cargoContain = (JSPUtil.getParameter(request, prefix	+ "cargo_contain", length));
			String[] cargoCnt = (JSPUtil.getParameter(request, prefix	+ "cargo_cnt", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] ridrTpCd = (JSPUtil.getParameter(request, prefix	+ "ridr_tp_cd", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkgNo", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterDgRiderVO();
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (cargoContain[i] != null)
					model.setCargoContain(cargoContain[i]);
				if (cargoCnt[i] != null)
					model.setCargoCnt(cargoCnt[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (ridrTpCd[i] != null)
					model.setRidrTpCd(ridrTpCd[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterDgRiderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterDgRiderVO[]
	 */
	public XterDgRiderVO[] getXterDgRiderVOs(){
		XterDgRiderVO[] vos = (XterDgRiderVO[])models.toArray(new XterDgRiderVO[models.size()]);
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
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoContain = this.cargoContain .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargoCnt = this.cargoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ridrTpCd = this.ridrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
