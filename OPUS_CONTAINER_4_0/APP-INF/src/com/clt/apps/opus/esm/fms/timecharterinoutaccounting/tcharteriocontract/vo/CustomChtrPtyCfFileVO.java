/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomChtrPtyCfFileVO.java
*@FileTitle : CustomChtrPtyCfFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.24
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 정윤태
 * @since J2EE 1.5
 * @see ESM_FMS_0001HTMLAction
 */
 
public class CustomChtrPtyCfFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomChtrPtyCfFileVO> models = new ArrayList<CustomChtrPtyCfFileVO>();
	
	/* Column Inpo */
	private String updDt = null;
	/* Column Inpo */
	private String fileSavId = null;
	/* Column Inpo */
	private String creUsrId = null;
	/* Status */
	private String ibflag = null;
	/* Column Inpo */
	private String fileDesc = null;
	/* Column Inpo */
	private String creDt = null;
	/* Column Inpo */
	private String fileSeq = null;
	/* Column Inpo */
	private String fletFileTpCd = null;
	/* Column Inpo */
	private String fileNm = null;
	/* Column Inpo */
	private String updUsrId = null;
	/* Column Inpo */
	private String fletCtrtNo = null;
	/* Column Inpo */
	private String effDt = null;
	/* Column Inpo */
	private String expDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public CustomChtrPtyCfFileVO() {}
	
	/**
	 * 생성자
	 * @param String ibflag, String pagerows, String fletCtrtNo, String fileSeq, String fletFileTpCd, String fileNm, String fileDesc, String fileSavId, String creUsrId, String creDt, String updUsrId, String updDt
	 * @return 
	 */
	public CustomChtrPtyCfFileVO(String ibflag, String pagerows, String fletCtrtNo, String fileSeq, String fletFileTpCd, String fileNm, String fileDesc, String fileSavId, String creUsrId, String creDt, String updUsrId, String updDt, String effDt, String expDt) {
		this.updDt = updDt;
		this.fileSavId = fileSavId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.fileDesc = fileDesc;
		this.creDt = creDt;
		this.fileSeq = fileSeq;
		this.fletFileTpCd = fletFileTpCd;
		this.fileNm = fileNm;
		this.updUsrId = updUsrId;
		this.fletCtrtNo = fletCtrtNo;
		this.effDt = effDt;
		this.expDt = expDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_desc", getFileDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("flet_file_tp_cd", getFletFileTpCd());
		this.hashColumns.put("file_nm", getFileNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_desc", "fileDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("flet_file_tp_cd", "fletFileTpCd");
		this.hashFields.put("file_nm", "fileNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getFileSavId() {
		return this.fileSavId;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFileDesc() {
		return this.fileDesc;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getFileSeq() {
		return this.fileSeq;
	}
	public String getFletFileTpCd() {
		return this.fletFileTpCd;
	}
	public String getFileNm() {
		return this.fileNm;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
	}
	public String getEffDt() {
		return this.effDt;
	}
	public String getExpDt() {
		return this.expDt;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
		//this.fileSavId=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
		//this.fileDesc=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
		//this.fileSeq=true;
	}
	public void setFletFileTpCd(String fletFileTpCd) {
		this.fletFileTpCd = fletFileTpCd;
		//this.fletFileTpCd=true;
	}
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
		//this.fileNm=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
		//this.fletCtrtNo=true;
	}
	public void setEffDt(String effDt) {
		this.effDt = effDt;
		//this.effDt=true;
	}
	public void setExpDt(String expDt) {
		this.expDt = expDt;
		//this.expDt=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFileSavId(JSPUtil.getParameter(request, "file_sav_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFileDesc(JSPUtil.getParameter(request, "file_desc", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setFletFileTpCd(JSPUtil.getParameter(request, "flet_file_tp_cd", ""));
		setFileNm(JSPUtil.getParameter(request, "file_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomChtrPtyCfFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomChtrPtyCfFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomChtrPtyCfFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] fileDesc = (JSPUtil.getParameter(request, prefix	+ "file_desc".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq".trim(), length));
			String[] fletFileTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_file_tp_cd".trim(), length));
			String[] fileNm = (JSPUtil.getParameter(request, prefix	+ "file_nm".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomChtrPtyCfFileVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileDesc[i] != null)
					model.setFileDesc(fileDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (fletFileTpCd[i] != null)
					model.setFletFileTpCd(fletFileTpCd[i]);
				if (fileNm[i] != null)
					model.setFileNm(fileNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCustomChtrPtyCfFileVOs();
	}

	public CustomChtrPtyCfFileVO[] getCustomChtrPtyCfFileVOs(){
		CustomChtrPtyCfFileVO[] vos = (CustomChtrPtyCfFileVO[])models.toArray(new CustomChtrPtyCfFileVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}

}
