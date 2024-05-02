/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaBlMultiBlListVO.java
*@FileTitle : UsaBlMultiBlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.01 이수빈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이수빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBlMultiBlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBlMultiBlListVO> models = new ArrayList<UsaBlMultiBlListVO>();
	
	/* Column Info */
	private String usaLstLocCd = null;
	/* Column Info */
	private String cstmsFileTpCd = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String foc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String amsPckTpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaBlMultiBlListVO() {}

	public UsaBlMultiBlListVO(String ibflag, String pagerows, String blNo, String cstmsFileTpCd, String foc, String pckQty, String amsPckTpCd, String ibdTrspNo, String hubLocCd, String usaLstLocCd, String delCd, String cntrNo, String cntrTpszCd, String cnee) {
		this.usaLstLocCd = usaLstLocCd;
		this.cstmsFileTpCd = cstmsFileTpCd;
		this.ibdTrspNo = ibdTrspNo;
		this.delCd = delCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.foc = foc;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.amsPckTpCd = amsPckTpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cnee = cnee;
		this.pckQty = pckQty;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usa_lst_loc_cd", getUsaLstLocCd());
		this.hashColumns.put("cstms_file_tp_cd", getCstmsFileTpCd());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("foc", getFoc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ams_pck_tp_cd", getAmsPckTpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usa_lst_loc_cd", "usaLstLocCd");
		this.hashFields.put("cstms_file_tp_cd", "cstmsFileTpCd");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("foc", "foc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ams_pck_tp_cd", "amsPckTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return usaLstLocCd
	 */
	public String getUsaLstLocCd() {
		return this.usaLstLocCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsFileTpCd
	 */
	public String getCstmsFileTpCd() {
		return this.cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspNo
	 */
	public String getIbdTrspNo() {
		return this.ibdTrspNo;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return foc
	 */
	public String getFoc() {
		return this.foc;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return amsPckTpCd
	 */
	public String getAmsPckTpCd() {
		return this.amsPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cnee
	 */
	public String getCnee() {
		return this.cnee;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
	}
	

	/**
	 * Column Info
	 * @param usaLstLocCd
	 */
	public void setUsaLstLocCd(String usaLstLocCd) {
		this.usaLstLocCd = usaLstLocCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsFileTpCd
	 */
	public void setCstmsFileTpCd(String cstmsFileTpCd) {
		this.cstmsFileTpCd = cstmsFileTpCd;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspNo
	 */
	public void setIbdTrspNo(String ibdTrspNo) {
		this.ibdTrspNo = ibdTrspNo;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param foc
	 */
	public void setFoc(String foc) {
		this.foc = foc;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param amsPckTpCd
	 */
	public void setAmsPckTpCd(String amsPckTpCd) {
		this.amsPckTpCd = amsPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cnee
	 */
	public void setCnee(String cnee) {
		this.cnee = cnee;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUsaLstLocCd(JSPUtil.getParameter(request, "usa_lst_loc_cd", ""));
		setCstmsFileTpCd(JSPUtil.getParameter(request, "cstms_file_tp_cd", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, "ibd_trsp_no", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFoc(JSPUtil.getParameter(request, "foc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setAmsPckTpCd(JSPUtil.getParameter(request, "ams_pck_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBlMultiBlListVO[]
	 */
	public UsaBlMultiBlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBlMultiBlListVO[]
	 */
	public UsaBlMultiBlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBlMultiBlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usaLstLocCd = (JSPUtil.getParameter(request, prefix	+ "usa_lst_loc_cd", length));
			String[] cstmsFileTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_file_tp_cd", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] foc = (JSPUtil.getParameter(request, prefix	+ "foc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] amsPckTpCd = (JSPUtil.getParameter(request, prefix	+ "ams_pck_tp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBlMultiBlListVO();
				if (usaLstLocCd[i] != null)
					model.setUsaLstLocCd(usaLstLocCd[i]);
				if (cstmsFileTpCd[i] != null)
					model.setCstmsFileTpCd(cstmsFileTpCd[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (foc[i] != null)
					model.setFoc(foc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (amsPckTpCd[i] != null)
					model.setAmsPckTpCd(amsPckTpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBlMultiBlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBlMultiBlListVO[]
	 */
	public UsaBlMultiBlListVO[] getUsaBlMultiBlListVOs(){
		UsaBlMultiBlListVO[] vos = (UsaBlMultiBlListVO[])models.toArray(new UsaBlMultiBlListVO[models.size()]);
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
		this.usaLstLocCd = this.usaLstLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsFileTpCd = this.cstmsFileTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foc = this.foc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsPckTpCd = this.amsPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
