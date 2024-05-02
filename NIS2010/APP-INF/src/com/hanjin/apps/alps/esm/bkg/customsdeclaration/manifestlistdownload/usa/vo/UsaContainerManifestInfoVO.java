/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaContainerManifestInfoVO.java
*@FileTitle : UsaContainerManifestInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaContainerManifestInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaContainerManifestInfoVO> models = new ArrayList<UsaContainerManifestInfoVO>();
	
	/* Column Info */
	private String usaLstLocCd = null;
	/* Column Info */
	private String fFlg = null;
	/* Column Info */
	private String ibdTrspTpCd = null;
	/* Column Info */
	private String ibdTrspNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cstmsMfTpCd = null;
	/* Column Info */
	private String cFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String amsPckTpCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String oFlg = null;
	/* Column Info */
	private String mfSts = null;
	/* Column Info */
	private String cgoWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaContainerManifestInfoVO() {}

	public UsaContainerManifestInfoVO(String ibflag, String pagerows, String blNo, String vvd, String podCd, String polCd, String delCd, String usaLstLocCd, String pckQty, String amsPckTpCd, String cgoWgt, String wgtUtCd, String ibdTrspNo, String ibdTrspTpCd, String cstmsClrTpCd, String mfSts, String fFlg, String oFlg, String cFlg, String cstmsMfTpCd, String vpsEtaDt) {
		this.usaLstLocCd = usaLstLocCd;
		this.fFlg = fFlg;
		this.ibdTrspTpCd = ibdTrspTpCd;
		this.ibdTrspNo = ibdTrspNo;
		this.delCd = delCd;
		this.vpsEtaDt = vpsEtaDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cstmsMfTpCd = cstmsMfTpCd;
		this.cFlg = cFlg;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.amsPckTpCd = amsPckTpCd;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.oFlg = oFlg;
		this.mfSts = mfSts;
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("usa_lst_loc_cd", getUsaLstLocCd());
		this.hashColumns.put("f_flg", getFFlg());
		this.hashColumns.put("ibd_trsp_tp_cd", getIbdTrspTpCd());
		this.hashColumns.put("ibd_trsp_no", getIbdTrspNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cstms_mf_tp_cd", getCstmsMfTpCd());
		this.hashColumns.put("c_flg", getCFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("ams_pck_tp_cd", getAmsPckTpCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("o_flg", getOFlg());
		this.hashColumns.put("mf_sts", getMfSts());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("usa_lst_loc_cd", "usaLstLocCd");
		this.hashFields.put("f_flg", "fFlg");
		this.hashFields.put("ibd_trsp_tp_cd", "ibdTrspTpCd");
		this.hashFields.put("ibd_trsp_no", "ibdTrspNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cstms_mf_tp_cd", "cstmsMfTpCd");
		this.hashFields.put("c_flg", "cFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("ams_pck_tp_cd", "amsPckTpCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("o_flg", "oFlg");
		this.hashFields.put("mf_sts", "mfSts");
		this.hashFields.put("cgo_wgt", "cgoWgt");
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
	 * @return fFlg
	 */
	public String getFFlg() {
		return this.fFlg;
	}
	
	/**
	 * Column Info
	 * @return ibdTrspTpCd
	 */
	public String getIbdTrspTpCd() {
		return this.ibdTrspTpCd;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return cstmsMfTpCd
	 */
	public String getCstmsMfTpCd() {
		return this.cstmsMfTpCd;
	}
	
	/**
	 * Column Info
	 * @return cFlg
	 */
	public String getCFlg() {
		return this.cFlg;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return oFlg
	 */
	public String getOFlg() {
		return this.oFlg;
	}
	
	/**
	 * Column Info
	 * @return mfSts
	 */
	public String getMfSts() {
		return this.mfSts;
	}
	
	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
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
	 * @param fFlg
	 */
	public void setFFlg(String fFlg) {
		this.fFlg = fFlg;
	}
	
	/**
	 * Column Info
	 * @param ibdTrspTpCd
	 */
	public void setIbdTrspTpCd(String ibdTrspTpCd) {
		this.ibdTrspTpCd = ibdTrspTpCd;
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
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param cstmsMfTpCd
	 */
	public void setCstmsMfTpCd(String cstmsMfTpCd) {
		this.cstmsMfTpCd = cstmsMfTpCd;
	}
	
	/**
	 * Column Info
	 * @param cFlg
	 */
	public void setCFlg(String cFlg) {
		this.cFlg = cFlg;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param oFlg
	 */
	public void setOFlg(String oFlg) {
		this.oFlg = oFlg;
	}
	
	/**
	 * Column Info
	 * @param mfSts
	 */
	public void setMfSts(String mfSts) {
		this.mfSts = mfSts;
	}
	
	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUsaLstLocCd(JSPUtil.getParameter(request, "usa_lst_loc_cd", ""));
		setFFlg(JSPUtil.getParameter(request, "f_flg", ""));
		setIbdTrspTpCd(JSPUtil.getParameter(request, "ibd_trsp_tp_cd", ""));
		setIbdTrspNo(JSPUtil.getParameter(request, "ibd_trsp_no", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCstmsMfTpCd(JSPUtil.getParameter(request, "cstms_mf_tp_cd", ""));
		setCFlg(JSPUtil.getParameter(request, "c_flg", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, "cstms_clr_tp_cd", ""));
		setAmsPckTpCd(JSPUtil.getParameter(request, "ams_pck_tp_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setOFlg(JSPUtil.getParameter(request, "o_flg", ""));
		setMfSts(JSPUtil.getParameter(request, "mf_sts", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaContainerManifestInfoVO[]
	 */
	public UsaContainerManifestInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaContainerManifestInfoVO[]
	 */
	public UsaContainerManifestInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaContainerManifestInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] usaLstLocCd = (JSPUtil.getParameter(request, prefix	+ "usa_lst_loc_cd", length));
			String[] fFlg = (JSPUtil.getParameter(request, prefix	+ "f_flg", length));
			String[] ibdTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_tp_cd", length));
			String[] ibdTrspNo = (JSPUtil.getParameter(request, prefix	+ "ibd_trsp_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cstmsMfTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_tp_cd", length));
			String[] cFlg = (JSPUtil.getParameter(request, prefix	+ "c_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] amsPckTpCd = (JSPUtil.getParameter(request, prefix	+ "ams_pck_tp_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] oFlg = (JSPUtil.getParameter(request, prefix	+ "o_flg", length));
			String[] mfSts = (JSPUtil.getParameter(request, prefix	+ "mf_sts", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaContainerManifestInfoVO();
				if (usaLstLocCd[i] != null)
					model.setUsaLstLocCd(usaLstLocCd[i]);
				if (fFlg[i] != null)
					model.setFFlg(fFlg[i]);
				if (ibdTrspTpCd[i] != null)
					model.setIbdTrspTpCd(ibdTrspTpCd[i]);
				if (ibdTrspNo[i] != null)
					model.setIbdTrspNo(ibdTrspNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cstmsMfTpCd[i] != null)
					model.setCstmsMfTpCd(cstmsMfTpCd[i]);
				if (cFlg[i] != null)
					model.setCFlg(cFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (amsPckTpCd[i] != null)
					model.setAmsPckTpCd(amsPckTpCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (oFlg[i] != null)
					model.setOFlg(oFlg[i]);
				if (mfSts[i] != null)
					model.setMfSts(mfSts[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaContainerManifestInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaContainerManifestInfoVO[]
	 */
	public UsaContainerManifestInfoVO[] getUsaContainerManifestInfoVOs(){
		UsaContainerManifestInfoVO[] vos = (UsaContainerManifestInfoVO[])models.toArray(new UsaContainerManifestInfoVO[models.size()]);
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
		this.fFlg = this.fFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspTpCd = this.ibdTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTrspNo = this.ibdTrspNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfTpCd = this.cstmsMfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cFlg = this.cFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amsPckTpCd = this.amsPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oFlg = this.oFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSts = this.mfSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
