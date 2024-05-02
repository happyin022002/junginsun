/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoCheckListSearchVO.java
*@FileTitle : DoCheckListSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoCheckListSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoCheckListSearchVO> models = new ArrayList<DoCheckListSearchVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String evntDtTo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rdFlag = null;
	/* Column Info */
	private String evntDtFm = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String excelFlg = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String evntUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoCheckListSearchVO() {}

	public DoCheckListSearchVO(String ibflag, String pagerows, String blNo, String evntOfcCd, String evntUsrId, String podCd, String delCd, String evntDtFm, String evntDtTo, String vslCd, String skdVoyNo, String skdDirCd, String rdFlag, String pageNo, String excelFlg) {
		this.vslCd = vslCd;
		this.evntOfcCd = evntOfcCd;
		this.evntDtTo = evntDtTo;
		this.delCd = delCd;
		this.rdFlag = rdFlag;
		this.evntDtFm = evntDtFm;
		this.skdVoyNo = skdVoyNo;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.excelFlg = excelFlg;
		this.pageNo = pageNo;
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("evnt_dt_to", getEvntDtTo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rd_flag", getRdFlag());
		this.hashColumns.put("evnt_dt_fm", getEvntDtFm());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("excel_flg", getExcelFlg());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("evnt_dt_to", "evntDtTo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rd_flag", "rdFlag");
		this.hashFields.put("evnt_dt_fm", "evntDtFm");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("excel_flg", "excelFlg");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		return this.hashFields;
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
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return evntDtTo
	 */
	public String getEvntDtTo() {
		return this.evntDtTo;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return rdFlag
	 */
	public String getRdFlag() {
		return this.rdFlag;
	}
	
	/**
	 * Column Info
	 * @return evntDtFm
	 */
	public String getEvntDtFm() {
		return this.evntDtFm;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return excelFlg
	 */
	public String getExcelFlg() {
		return this.excelFlg;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
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
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param evntDtTo
	 */
	public void setEvntDtTo(String evntDtTo) {
		this.evntDtTo = evntDtTo;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rdFlag
	 */
	public void setRdFlag(String rdFlag) {
		this.rdFlag = rdFlag;
	}
	
	/**
	 * Column Info
	 * @param evntDtFm
	 */
	public void setEvntDtFm(String evntDtFm) {
		this.evntDtFm = evntDtFm;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param excelFlg
	 */
	public void setExcelFlg(String excelFlg) {
		this.excelFlg = excelFlg;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setEvntDtTo(JSPUtil.getParameter(request, "evnt_dt_to", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setRdFlag(JSPUtil.getParameter(request, "rd_flag", ""));
		setEvntDtFm(JSPUtil.getParameter(request, "evnt_dt_fm", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setExcelFlg(JSPUtil.getParameter(request, "excel_flg", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoCheckListSearchVO[]
	 */
	public DoCheckListSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoCheckListSearchVO[]
	 */
	public DoCheckListSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoCheckListSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] evntDtTo = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_to", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rdFlag = (JSPUtil.getParameter(request, prefix	+ "rd_flag", length));
			String[] evntDtFm = (JSPUtil.getParameter(request, prefix	+ "evnt_dt_fm", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] excelFlg = (JSPUtil.getParameter(request, prefix	+ "excel_flg", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoCheckListSearchVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (evntDtTo[i] != null)
					model.setEvntDtTo(evntDtTo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rdFlag[i] != null)
					model.setRdFlag(rdFlag[i]);
				if (evntDtFm[i] != null)
					model.setEvntDtFm(evntDtFm[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (excelFlg[i] != null)
					model.setExcelFlg(excelFlg[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoCheckListSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoCheckListSearchVO[]
	 */
	public DoCheckListSearchVO[] getDoCheckListSearchVOs(){
		DoCheckListSearchVO[] vos = (DoCheckListSearchVO[])models.toArray(new DoCheckListSearchVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtTo = this.evntDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlag = this.rdFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDtFm = this.evntDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excelFlg = this.excelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
