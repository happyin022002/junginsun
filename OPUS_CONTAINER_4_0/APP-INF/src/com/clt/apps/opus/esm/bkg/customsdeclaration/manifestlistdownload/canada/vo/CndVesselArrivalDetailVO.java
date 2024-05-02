/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndBlDetailVO.java
*@FileTitle : CndBlDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.05.12 김민정 
* 1.0 Creation
* --------------------------------------------------------
* History
* 2013.04.12 김보배 [CHM-201324023] [BKG] ACI - Vessel Arrival Transmit (A6) 화면 및 로직 보완
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김민정
 * @since J2EE 1.5
 * @see ..
 */

public class CndVesselArrivalDetailVO extends VesselArrivalDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndVesselArrivalDetailVO> models = new ArrayList<CndVesselArrivalDetailVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String othMty = null;
	/* Column Info */
	private String teuMty = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String feuFul = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String feuMty = null;
	/* Column Info */
	private String teuFul = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String cndVslCd = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String othFul = null;
	/* Column Info */
	private String crwKnt = null;
	/* Column Info */
	private String actArrDt = null;
		
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndVesselArrivalDetailVO() {}

	public CndVesselArrivalDetailVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String crrCd, String vpsEtaDt, String cvyRefNo, String capNm, String cgoWgt, String teuFul, String feuFul, String othFul, String teuMty, String feuMty, String othMty, String attrCtnt2, String updUsrId, String cndVslCd, String crwKnt, String actArrDt) {
		this.ibflag = ibflag;
		this.othMty = othMty;
		this.teuMty = teuMty;
		this.skdDirCd = skdDirCd;
		this.feuFul = feuFul;
		this.capNm = capNm;
		this.feuMty = feuMty;
		this.teuFul = teuFul;
		this.attrCtnt2 = attrCtnt2;
		this.updUsrId = updUsrId;
		this.vpsEtaDt = vpsEtaDt;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.crrCd = crrCd;
		this.cndVslCd = cndVslCd;
		this.cgoWgt = cgoWgt;
		this.cvyRefNo = cvyRefNo;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.othFul = othFul;
		this.crwKnt = crwKnt;
		this.actArrDt = actArrDt;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oth_mty", getOthMty());
		this.hashColumns.put("teu_mty", getTeuMty());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("feu_ful", getFeuFul());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("feu_mty", getFeuMty());
		this.hashColumns.put("teu_ful", getTeuFul());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("cnd_vsl_cd", getCndVslCd());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("oth_ful", getOthFul());
		this.hashColumns.put("crw_knt", getCrwKnt());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oth_mty", "othMty");
		this.hashFields.put("teu_mty", "teuMty");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("feu_ful", "feuFul");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("feu_mty", "feuMty");
		this.hashFields.put("teu_ful", "teuFul");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("cnd_vsl_cd", "cndVslCd");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("oth_ful", "othFul");
		this.hashFields.put("crw_knt", "crwKnt");
		this.hashFields.put("act_arr_dt", "actArrDt");
		
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getOthMty() {
		return this.othMty;
	}
	public String getTeuMty() {
		return this.teuMty;
	}
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getFeuFul() {
		return this.feuFul;
	}
	public String getCapNm() {
		return this.capNm;
	}
	public String getFeuMty() {
		return this.feuMty;
	}
	public String getTeuFul() {
		return this.teuFul;
	}
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	public String getCrrCd() {
		return this.crrCd;
	}
	public String getCndVslCd() {
		return this.cndVslCd;
	}
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	public String getCvyRefNo() {
		return this.cvyRefNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	public String getOthFul() {
		return this.othFul;
	}
	public String getCrwKnt() {
		return this.crwKnt;
	}
	public String getActArrDt() {
		return this.actArrDt;
	}
	
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setOthMty(String othMty) {
		this.othMty = othMty;
		//this.othMty=true;
	}
	public void setTeuMty(String teuMty) {
		this.teuMty = teuMty;
		//this.teuMty=true;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setFeuFul(String feuFul) {
		this.feuFul = feuFul;
		//this.feuFul=true;
	}
	public void setCapNm(String capNm) {
		this.capNm = capNm;
		//this.capNm=true;
	}
	public void setFeuMty(String feuMty) {
		this.feuMty = feuMty;
		//this.feuMty=true;
	}
	public void setTeuFul(String teuFul) {
		this.teuFul = teuFul;
		//this.teuFul=true;
	}
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
		//this.attrCtnt2=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
		//this.vpsEtaDt=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
		//this.crrCd=true;
	}
	public void setCndVslCd(String cndVslCd) {
		this.cndVslCd = cndVslCd;
		//this.cndVslCd=true;
	}
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
		//this.cgoWgt=true;
	}
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
		//this.cvyRefNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
		//this.vpsPortCd=true;
	}
	public void setOthFul(String othFul) {
		this.othFul = othFul;
		//this.othFul=true;
	}
	public void setCrwKnt(String crwKnt) {
		this.crwKnt = crwKnt;
		//this.othFul=true;
	}
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
	}
	
	
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOthMty(JSPUtil.getParameter(request, "oth_mty", ""));
		setTeuMty(JSPUtil.getParameter(request, "teu_mty", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setFeuFul(JSPUtil.getParameter(request, "feu_ful", ""));
		setCapNm(JSPUtil.getParameter(request, "cap_nm", ""));
		setFeuMty(JSPUtil.getParameter(request, "feu_mty", ""));
		setTeuFul(JSPUtil.getParameter(request, "teu_ful", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, "attr_ctnt2", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setCndVslCd(JSPUtil.getParameter(request, "cnd_vsl_cd", ""));
		setCgoWgt(JSPUtil.getParameter(request, "cgo_wgt", ""));
		setCvyRefNo(JSPUtil.getParameter(request, "cvy_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setOthFul(JSPUtil.getParameter(request, "oth_ful", ""));
		setCrwKnt(JSPUtil.getParameter(request, "crw_knt", ""));
		setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
		
	}

	public CndVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CndVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndVesselArrivalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] othMty = (JSPUtil.getParameter(request, prefix	+ "oth_mty".trim(), length));
			String[] teuMty = (JSPUtil.getParameter(request, prefix	+ "teu_mty".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] feuFul = (JSPUtil.getParameter(request, prefix	+ "feu_ful".trim(), length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm".trim(), length));
			String[] feuMty = (JSPUtil.getParameter(request, prefix	+ "feu_mty".trim(), length));
			String[] teuFul = (JSPUtil.getParameter(request, prefix	+ "teu_ful".trim(), length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] cndVslCd = (JSPUtil.getParameter(request, prefix	+ "cnd_vsl_cd".trim(), length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt".trim(), length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd".trim(), length));
			String[] othFul = (JSPUtil.getParameter(request, prefix	+ "oth_ful".trim(), length));
			String[] crwKnt = (JSPUtil.getParameter(request, prefix	+ "crw_knt".trim(), length));			
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt".trim(), length));

			
			for (int i = 0; i < length; i++) {
				model = new CndVesselArrivalDetailVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (othMty[i] != null)
					model.setOthMty(othMty[i]);
				if (teuMty[i] != null)
					model.setTeuMty(teuMty[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (feuFul[i] != null)
					model.setFeuFul(feuFul[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (feuMty[i] != null)
					model.setFeuMty(feuMty[i]);
				if (teuFul[i] != null)
					model.setTeuFul(teuFul[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (cndVslCd[i] != null)
					model.setCndVslCd(cndVslCd[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (othFul[i] != null)
					model.setOthFul(othFul[i]);
				if (crwKnt[i] != null)
					model.setCrwKnt(crwKnt[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
												
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndBlDetailVOs();
	}

	public CndVesselArrivalDetailVO[] getCndBlDetailVOs(){
		CndVesselArrivalDetailVO[] vos = (CndVesselArrivalDetailVO[])models.toArray(new CndVesselArrivalDetailVO[models.size()]);
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
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othMty = this.othMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuMty = this.teuMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuFul = this.feuFul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuMty = this.feuMty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuFul = this.teuFul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndVslCd = this.cndVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othFul = this.othFul .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crwKnt = this.crwKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
