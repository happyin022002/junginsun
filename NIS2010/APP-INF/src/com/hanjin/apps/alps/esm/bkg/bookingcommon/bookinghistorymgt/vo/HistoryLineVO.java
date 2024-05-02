/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HistoryLineVO.java
*@FileTitle : HistoryLineVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.10 이남경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HistoryLineVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HistoryLineVO> models = new ArrayList<HistoryLineVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hisCateNm = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String uiId = null;
	/* Column Info */
	private String localTime = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String bkgDocProcTpCd = null;
	/* Column Info */
	private String corrNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HistoryLineVO() {}

	public HistoryLineVO(String ibflag, String pagerows, String bkgDocProcTpCd, String bkgNo, String caFlg, String crntCtnt, String hisCateNm, String localTime, String uiId, String corrNo, String preCtnt) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.hisCateNm = hisCateNm;
		this.caFlg = caFlg;
		this.uiId = uiId;
		this.localTime = localTime;
		this.crntCtnt = crntCtnt;
		this.bkgDocProcTpCd = bkgDocProcTpCd;
		this.corrNo = corrNo;
		this.pagerows = pagerows;
		this.preCtnt= preCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("his_cate_nm", getHisCateNm());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("ui_id", getUiId());
		this.hashColumns.put("local_time", getLocalTime());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("bkg_doc_proc_tp_cd", getBkgDocProcTpCd());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("his_cate_nm", "hisCateNm");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("ui_id", "uiId");
		this.hashFields.put("local_time", "localTime");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("bkg_doc_proc_tp_cd", "bkgDocProcTpCd");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_ctnt", "preCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return hisCateNm
	 */
	public String getHisCateNm() {
		return this.hisCateNm;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return uiId
	 */
	public String getUiId() {
		return this.uiId;
	}
	
	/**
	 * Column Info
	 * @return localTime
	 */
	public String getLocalTime() {
		return this.localTime;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
	}
	
	/**
	 * Column Info
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return preCtnt;
	}
	
	/**
	 * Column Info
	 * @return bkgDocProcTpCd
	 */
	public String getBkgDocProcTpCd() {
		return this.bkgDocProcTpCd;
	}

	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return corrNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param hisCateNm
	 */
	public void setHisCateNm(String hisCateNm) {
		this.hisCateNm = hisCateNm;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param uiId
	 */
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	
	/**
	 * Column Info
	 * @param localTime
	 */
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
	}

	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
	}
	
	/**
	 * Column Info
	 * @param bkgDocProcTpCd
	 */
	public void setBkgDocProcTpCd(String bkgDocProcTpCd) {
		this.bkgDocProcTpCd = bkgDocProcTpCd;
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
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHisCateNm(JSPUtil.getParameter(request, "his_cate_nm", ""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg", ""));
		setUiId(JSPUtil.getParameter(request, "ui_id", ""));
		setLocalTime(JSPUtil.getParameter(request, "local_time", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setBkgDocProcTpCd(JSPUtil.getParameter(request, "bkg_doc_proc_tp_cd", ""));
		setCorrNo(JSPUtil.getParameter(request, "corr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HistoryLineVO[]
	 */
	public HistoryLineVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HistoryLineVO[]
	 */
	public HistoryLineVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HistoryLineVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hisCateNm = (JSPUtil.getParameter(request, prefix	+ "his_cate_nm", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] uiId = (JSPUtil.getParameter(request, prefix	+ "ui_id", length));
			String[] localTime = (JSPUtil.getParameter(request, prefix	+ "local_time", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] bkgDocProcTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_doc_proc_tp_cd", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new HistoryLineVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hisCateNm[i] != null)
					model.setHisCateNm(hisCateNm[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (uiId[i] != null)
					model.setUiId(uiId[i]);
				if (localTime[i] != null)
					model.setLocalTime(localTime[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (bkgDocProcTpCd[i] != null)
					model.setBkgDocProcTpCd(bkgDocProcTpCd[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHistoryLineVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HistoryLineVO[]
	 */
	public HistoryLineVO[] getHistoryLineVOs(){
		HistoryLineVO[] vos = (HistoryLineVO[])models.toArray(new HistoryLineVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisCateNm = this.hisCateNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiId = this.uiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTime = this.localTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDocProcTpCd = this.bkgDocProcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
