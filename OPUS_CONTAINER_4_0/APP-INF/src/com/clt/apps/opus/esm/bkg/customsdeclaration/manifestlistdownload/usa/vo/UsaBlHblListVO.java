/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaBlHblListVO.java
*@FileTitle : UsaBlHblListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.18
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.18 이수빈 
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

public class UsaBlHblListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBlHblListVO> models = new ArrayList<UsaBlHblListVO>();
	
	/* Column Info */
	private String ibdTrspNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String amsPckTpCd = null;
	/* Column Info */
	private String cnee = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaBlHblListVO() {}

	public UsaBlHblListVO(String ibflag, String pagerows, String blNo, String cstmsClrCd, String pckQty, String amsPckTpCd, String ibdTrspNo, String hubLocCd, String cnee) {
		this.ibdTrspNo = ibdTrspNo;
		this.ibflag = ibflag;
		this.cstmsClrCd = cstmsClrCd;
		this.amsPckTpCd = amsPckTpCd;
		this.cnee = cnee;
		this.pckQty = pckQty;
		this.blNo = blNo;
		this.hubLocCd = hubLocCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("ams_pck_tp_cd", getAmsPckTpCd());
		this.hashColumns.put("cnee", getCnee());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("ams_pck_tp_cd", "amsPckTpCd");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspNo
	 */
	public String getIbdTrspNo() {
		return this.ibdTrspNo;
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
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
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
	 * @param ibdTrspNo
	 */
	public void setIbdTrspNo(String ibdTrspNo) {
		this.ibdTrspNo = ibdTrspNo;
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
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
		setIbdTrspNo(JSPUtil.getParameter(request, "ibd_trsp_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, "cstms_clr_cd", ""));
		setAmsPckTpCd(JSPUtil.getParameter(request, "ams_pck_tp_cd", ""));
		setCnee(JSPUtil.getParameter(request, "cnee", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBlHblListVO[]
	 */
	public UsaBlHblListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBlHblListVO[]
	 */
	public UsaBlHblListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBlHblListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] amsPckTpCd = (JSPUtil.getParameter(request, prefix	+ "ams_pck_tp_cd", length));
			String[] cnee = (JSPUtil.getParameter(request, prefix	+ "cnee", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBlHblListVO();
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (amsPckTpCd[i] != null)
					model.setAmsPckTpCd(amsPckTpCd[i]);
				if (cnee[i] != null)
					model.setCnee(cnee[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBlHblListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBlHblListVO[]
	 */
	public UsaBlHblListVO[] getUsaBlHblListVOs(){
		UsaBlHblListVO[] vos = (UsaBlHblListVO[])models.toArray(new UsaBlHblListVO[models.size()]);
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
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsPckTpCd = this.amsPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee = this.cnee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
