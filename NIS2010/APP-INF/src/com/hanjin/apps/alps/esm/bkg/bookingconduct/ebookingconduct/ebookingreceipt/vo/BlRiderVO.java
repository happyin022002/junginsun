/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BlRiderVO.java
*@FileTitle : BlRiderVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.13  
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

public class BlRiderVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlRiderVO> models = new ArrayList<BlRiderVO>();
	
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String imgSeq = null;
	/* Column Info */
	private String fileDesc = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bbCgoSeq = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String filePathRmk = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String ridrTpCd = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String fileSize = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlRiderVO() {}

	public BlRiderVO(String ibflag, String pagerows, String xterSndrId, String xterRqstNo, String xterRqstSeq, String imgSeq, String ridrTpCd, String dcgoSeq, String awkCgoSeq, String bbCgoSeq, String fileNm, String filePathRmk, String fileSavId, String fileDesc, String fileSize) {
		this.xterSndrId = xterSndrId;
		this.fileSavId = fileSavId;
		this.imgSeq = imgSeq;
		this.fileDesc = fileDesc;
		this.dcgoSeq = dcgoSeq;
		this.awkCgoSeq = awkCgoSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bbCgoSeq = bbCgoSeq;
		this.xterRqstSeq = xterRqstSeq;
		this.filePathRmk = filePathRmk;
		this.xterRqstNo = xterRqstNo;
		this.ridrTpCd = ridrTpCd;
		this.fileNm = fileNm;
		this.fileSize = fileSize;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("img_seq", getImgSeq());
		this.hashColumns.put("file_desc", getFileDesc());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bb_cgo_seq", getBbCgoSeq());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("file_path_rmk", getFilePathRmk());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("ridr_tp_cd", getRidrTpCd());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("file_size", getFileSize());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("img_seq", "imgSeq");
		this.hashFields.put("file_desc", "fileDesc");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bb_cgo_seq", "bbCgoSeq");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("file_path_rmk", "filePathRmk");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("ridr_tp_cd", "ridrTpCd");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("file_size", "fileSize");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
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
	 * @return fileDesc
	 */
	public String getFileDesc() {
		return this.fileDesc;
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
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
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
	 * @return bbCgoSeq
	 */
	public String getBbCgoSeq() {
		return this.bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
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
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
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
	

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
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
	 * @param fileDesc
	 */
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
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
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
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
	 * @param bbCgoSeq
	 */
	public void setBbCgoSeq(String bbCgoSeq) {
		this.bbCgoSeq = bbCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
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
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
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
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setImgSeq(JSPUtil.getParameter(request, prefix + "img_seq", ""));
		setFileDesc(JSPUtil.getParameter(request, prefix + "file_desc", ""));
		setDcgoSeq(JSPUtil.getParameter(request, prefix + "dcgo_seq", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, prefix + "awk_cgo_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBbCgoSeq(JSPUtil.getParameter(request, prefix + "bb_cgo_seq", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setFilePathRmk(JSPUtil.getParameter(request, prefix + "file_path_rmk", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setRidrTpCd(JSPUtil.getParameter(request, prefix + "ridr_tp_cd", ""));
		setFileNm(JSPUtil.getParameter(request, prefix + "file_nm", ""));
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlRiderVO[]
	 */
	public BlRiderVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlRiderVO[]
	 */
	public BlRiderVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlRiderVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] imgSeq = (JSPUtil.getParameter(request, prefix	+ "img_seq", length));
			String[] fileDesc = (JSPUtil.getParameter(request, prefix	+ "file_desc", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bbCgoSeq = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_seq", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] filePathRmk = (JSPUtil.getParameter(request, prefix	+ "file_path_rmk", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] ridrTpCd = (JSPUtil.getParameter(request, prefix	+ "ridr_tp_cd", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlRiderVO();
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (imgSeq[i] != null)
					model.setImgSeq(imgSeq[i]);
				if (fileDesc[i] != null)
					model.setFileDesc(fileDesc[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bbCgoSeq[i] != null)
					model.setBbCgoSeq(bbCgoSeq[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (filePathRmk[i] != null)
					model.setFilePathRmk(filePathRmk[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (ridrTpCd[i] != null)
					model.setRidrTpCd(ridrTpCd[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlRiderVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlRiderVO[]
	 */
	public BlRiderVO[] getBlRiderVOs(){
		BlRiderVO[] vos = (BlRiderVO[])models.toArray(new BlRiderVO[models.size()]);
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
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgSeq = this.imgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDesc = this.fileDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoSeq = this.bbCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePathRmk = this.filePathRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ridrTpCd = this.ridrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
