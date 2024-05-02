/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgPrnrAproRqstFileVO.java
*@FileTitle : ScgPrnrAproRqstFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.08.13 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPrnrAproRqstFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPrnrAproRqstFileVO> models = new ArrayList<ScgPrnrAproRqstFileVO>();
	
	/* Column Info */
	private String spclCgoRqstSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String spclCgoRqstAtchFileSeq = null;
	/* Column Info */
	private String fileSetYn = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String updUsrId = null;
    /* Column Info */
    private String prnrCgoRqstSeq = null;
    
    private boolean skip = false;
    
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgPrnrAproRqstFileVO() {}

	public ScgPrnrAproRqstFileVO(String ibflag, String pagerows, String crrCd, String bkgRefNo, String spclCgoRqstSeq, String spclCgoRqstAtchFileSeq, String fileNm, String fileSavId, String creUsrId, String creDt, String updUsrId, String updDt, String fileSetYn, String prnrCgoRqstSeq) {
		this.spclCgoRqstSeq = spclCgoRqstSeq;
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.creDt = creDt;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.bkgRefNo = bkgRefNo;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.spclCgoRqstAtchFileSeq = spclCgoRqstAtchFileSeq;
		this.fileSetYn = fileSetYn;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.prnrCgoRqstSeq = prnrCgoRqstSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("spcl_cgo_rqst_atch_file_seq", getSpclCgoRqstAtchFileSeq());
		this.hashColumns.put("file_set_yn", getFileSetYn());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("prnr_cgo_rqst_seq", getPrnrCgoRqstSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("spcl_cgo_rqst_atch_file_seq", "spclCgoRqstAtchFileSeq");
		this.hashFields.put("file_set_yn", "fileSetYn");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("prnr_cgo_rqst_seq", "prnrCgoRqstSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return spclCgoRqstSeq
	 */
	public String getSpclCgoRqstSeq() {
		return this.spclCgoRqstSeq;
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
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
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
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return bkgRefNo
	 */
	public String getBkgRefNo() {
		return this.bkgRefNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return spclCgoRqstAtchFileSeq
	 */
	public String getSpclCgoRqstAtchFileSeq() {
		return this.spclCgoRqstAtchFileSeq;
	}
	
	/**
	 * Column Info
	 * @return fileSetYn
	 */
	public String getFileSetYn() {
		return this.fileSetYn;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return prnrCgoRqstSeq
	 */
	public String getPrnrCgoRqstSeq() {
		return this.prnrCgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param spclCgoRqstSeq
	 */
	public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
		this.spclCgoRqstSeq = spclCgoRqstSeq;
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
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
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
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param bkgRefNo
	 */
	public void setBkgRefNo(String bkgRefNo) {
		this.bkgRefNo = bkgRefNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param spclCgoRqstAtchFileSeq
	 */
	public void setSpclCgoRqstAtchFileSeq(String spclCgoRqstAtchFileSeq) {
		this.spclCgoRqstAtchFileSeq = spclCgoRqstAtchFileSeq;
	}
	
	/**
	 * Column Info
	 * @param fileSetYn
	 */
	public void setFileSetYn(String fileSetYn) {
		this.fileSetYn = fileSetYn;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param prnrCgoRqstSeq
	 */
	public void setPrnrCgoRqstSeq(String prnrCgoRqstSeq) {
		this.prnrCgoRqstSeq = prnrCgoRqstSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSpclCgoRqstSeq(JSPUtil.getParameter(request, "spcl_cgo_rqst_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgRefNo(JSPUtil.getParameter(request, "bkg_ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSpclCgoRqstAtchFileSeq(JSPUtil.getParameter(request, "spcl_cgo_rqst_atch_file_seq", ""));
		setFileSetYn(JSPUtil.getParameter(request, "file_set_yn", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPrnrCgoRqstSeq(JSPUtil.getParameter(request, "prnr_cgo_rqst_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrAproRqstFileVO[]
	 */
	public ScgPrnrAproRqstFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPrnrAproRqstFileVO[]
	 */
	public ScgPrnrAproRqstFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPrnrAproRqstFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rqst_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] spclCgoRqstAtchFileSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rqst_atch_file_seq", length));
			String[] fileSetYn = (JSPUtil.getParameter(request, prefix	+ "file_set_yn", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] prnrCgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "prnr_cgo_rqst_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPrnrAproRqstFileVO();
				if (spclCgoRqstSeq[i] != null)
					model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (spclCgoRqstAtchFileSeq[i] != null)
					model.setSpclCgoRqstAtchFileSeq(spclCgoRqstAtchFileSeq[i]);
				if (fileSetYn[i] != null)
					model.setFileSetYn(fileSetYn[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (prnrCgoRqstSeq[i] != null)
					model.setPrnrCgoRqstSeq(prnrCgoRqstSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPrnrAproRqstFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPrnrAproRqstFileVO[]
	 */
	public ScgPrnrAproRqstFileVO[] getScgPrnrAproRqstFileVOs(){
		ScgPrnrAproRqstFileVO[] vos = (ScgPrnrAproRqstFileVO[])models.toArray(new ScgPrnrAproRqstFileVO[models.size()]);
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
		this.spclCgoRqstSeq = this.spclCgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoRqstAtchFileSeq = this.spclCgoRqstAtchFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSetYn = this.fileSetYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrCgoRqstSeq = this.prnrCgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public boolean getSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
}
