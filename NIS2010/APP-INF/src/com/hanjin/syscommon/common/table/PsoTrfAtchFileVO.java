package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

public class PsoTrfAtchFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsoTrfAtchFileVO> models = new ArrayList<PsoTrfAtchFileVO>();
	
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String pagerows = null;	
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String ydChgVerSeq = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String fileNm = null;
	/* Column Info */
	private String fileSize = null;
	/* Column Info */
	private String filePath = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String atchFileDivCd = null;
	/*CTRT_SCR_FLG*/
	private String ctrtScrFlg = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsoTrfAtchFileVO() {}

	public PsoTrfAtchFileVO(String ibflag, String pagerows, String ydChgNo, String ydChgVerSeq, String fileSavId, String fileNm, String fileSize, String filePath, String creUsrId, String creDt, String updUsrId, String updDt, String atchFileDivCd, String ctrtScrFlg) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.ydChgNo = ydChgNo;
		this.ydChgVerSeq = ydChgVerSeq;
		this.fileSavId = fileSavId;
		this.fileNm = fileNm;
		this.fileSize = fileSize;
		this.filePath = filePath;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.atchFileDivCd = atchFileDivCd;
		this.ctrtScrFlg = ctrtScrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("file_path", getFilePath());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("atch_file_div_cd", getAtchFileDivCd());
		this.hashColumns.put("ctrt_scr_flg", getCtrtScrFlg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("file_path", "filePath");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("atch_file_div_cd", "atchFileDivCd");
		this.hashFields.put("ctrt_scr_flg", "ctrtScrFlg");
		
		return this.hashFields;
	}
	
	
	
	public String getCtrtScrFlg() {
		return ctrtScrFlg;
	}

	public void setCtrtScrFlg(String ctrtScrFlg) {
		this.ctrtScrFlg = ctrtScrFlg;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
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
	 * @return fileNm
	 */
	public String getFileNm() {
		return this.fileNm;
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
	 * @return filePath
	 */
	public String getFilePath() {
		return this.filePath;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}		

	/**
	 * Column Info
	 * @return atchFileDivCd
	 */
	public String getAtchFileDivCd() {
		return this.atchFileDivCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
		
	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
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
	 * @param fileNm
	 */
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
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
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}	
	
	/**
	 * Column Info
	 * @param atchFileDivCd
	 */
	public void setAtchFileDivCd(String atchFileDivCd) {
		this.atchFileDivCd = atchFileDivCd;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setFileSize(JSPUtil.getParameter(request, "file_size", ""));
		setFilePath(JSPUtil.getParameter(request, "file_path", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setAtchFileDivCd(JSPUtil.getParameter(request, "atch_file_div_cd", ""));		
		setCtrtScrFlg(JSPUtil.getParameter(request, "ctrt_scr_flg", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsoTrfAtchFileVO[]
	 */
	public PsoTrfAtchFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsoTrfAtchFileVO[]
	 */
	public PsoTrfAtchFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsoTrfAtchFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix	+ "yd_chg_ver_seq", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix + "file_sav_id", length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] filePath = (JSPUtil.getParameter(request, prefix + "file_path", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] atchFileDivCd = (JSPUtil.getParameter(request, prefix + "atch_file_div_cd", length));
			String[] ctrtScrFlg = (JSPUtil.getParameter(request, prefix + "ctrt_scr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsoTrfAtchFileVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);				
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (filePath[i] != null)
					model.setFilePath(filePath[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (atchFileDivCd[i] != null)
					model.setAtchFileDivCd(atchFileDivCd[i]);				
				if (ctrtScrFlg[i] != null)
					model.setCtrtScrFlg(ctrtScrFlg[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsoTrfAtchFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsoTrfAtchFileVO[]
	 */
	public PsoTrfAtchFileVO[] getPsoTrfAtchFileVOs(){
		PsoTrfAtchFileVO[] vos = (PsoTrfAtchFileVO[])models.toArray(new PsoTrfAtchFileVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNm = this.fileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filePath = this.filePath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileDivCd = this.atchFileDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.ctrtScrFlg = this.ctrtScrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
	}
}
