/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsManifestListCondVO.java
*@FileTitle : RocsManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 임재택
 * @since J2EE 1.5
 */
public class RocsManifestListCondVO extends ManifestListCondVO{

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsManifestListCondVO> models = new ArrayList<RocsManifestListCondVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String crnNumber = null;	 
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String mtFlag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String  blNo = null;
	/* Column Info */
	private String blNoChk = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String difChr = null;
	/* Column Info */
	private String pgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsManifestListCondVO() {}

	public RocsManifestListCondVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, 
			String skdDirCd, String crnNumber,String mtFlag,String polCd,String podCd,
			String blNo,String blNoTp,String blNoChk,String difChr,String cntrNo,String pgNo,String blTpCd) {
		this.ibflag = ibflag;
		this.vslCd = vslCd;
		this.crnNumber = crnNumber;		 
		this.skdDirCd = skdDirCd;
		this.skdVoyNo = skdVoyNo;
		this.mtFlag = mtFlag;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.polCd = polCd;
		this.blNo = blNo;
		this.pgNo = pgNo;
		this.blTpCd = blTpCd;
		this.blNoTp = blNoTp;
		this.blNoChk = blNoChk;
		this.cntrNo = cntrNo;
		this.difChr = difChr;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("frm_crn_number", getCrnNumber());		 
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("mt_flag", getMtFlag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pg_no", getPgNo());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("dif_chr", getDifChr());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("frm_crn_number", "crnNumber");		 
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("mt_flag", "mtFlag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pg_no", "pgNo");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("dif_chr", "difChr");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getCntrNo() {
		return this.cntrNo;
	}
	public String getBlTpCd() {
		return this.blTpCd;
	}
	public String getPgNo() {
		return this.pgNo;
	}
	public String getDifChr() {
		return this.difChr;
	}
	public String getBlNo() {
		return this.blNo;
	}
	public String getBlNoTp() {
		return this.blNoTp;
	}
	public String getBlNoChk() {
		return this.blNoChk;
	}
	public String getPolCd() {
		return this.polCd;
	}
	public String getPodCd() {
		return this.podCd;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getCrnNumber() {
		return this.crnNumber;
	}
	 
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	public String getMtFlag() {
		return this.mtFlag;
	}
	
	public String getPagerows() {
		return this.pagerows;
	}
	 

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
		//this.ibflag=true;
	}
	public void setPgNo(String pgNo) {
		this.pgNo = pgNo;
		 
	}
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
		 
	}
	public void setDifChr(String difChr) {
		this.difChr = difChr;
		//this.ibflag=true;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
		//this.ibflag=true;
	}
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
		//this.ibflag=true;
	}
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
		//this.ibflag=true;
	}
	public void setPolCd(String polCd) {
		this.polCd = polCd;
		//this.ibflag=true;
	}
	public void setPodCd(String podCd) {
		this.podCd = podCd;
		//this.ibflag=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setCrnNumber(String crnNumber) {
		this.crnNumber = crnNumber;
		//this.clptSeq=true;
	}
	 
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setMtFlag(String mtFlag) {
		this.mtFlag = mtFlag;
		//this.skdVoyNo=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCrnNumber(JSPUtil.getParameter(request, "frm_crn_number", ""));		 
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));		 
		setMtFlag(JSPUtil.getParameter(request, "mt_flag", ""));		 
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));		 
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));		
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));	
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));	
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));		
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));		
		setDifChr(JSPUtil.getParameter(request, "dif_chr", ""));		
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));		
		setPgNo(JSPUtil.getParameter(request, "pg_no", ""));		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RocsManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RocsManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] crnnumber = (JSPUtil.getParameter(request, prefix	+ "frm_crn_number".trim(), length));			 
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));	
			String[] mtFlag = (JSPUtil.getParameter(request, prefix	+ "mt_flag".trim(), length));	
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));	
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));	
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));	
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd".trim(), length));	
			String[] pgNo = (JSPUtil.getParameter(request, prefix	+ "pg_no".trim(), length));	
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));	
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));	
			String[] difChr = (JSPUtil.getParameter(request, prefix	+ "dif_chr".trim(), length));	
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));	
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsManifestListCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pgNo[i] != null)
					model.setPgNo(pgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (difChr[i] != null)
					model.setDifChr(difChr[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (crnnumber[i] != null)
					model.setCrnNumber(crnnumber[i]);				 
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);				 
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (mtFlag[i] != null)
					model.setMtFlag(mtFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsManifestListCondVOs();
	}

	public RocsManifestListCondVO[] getRocsManifestListCondVOs(){
		RocsManifestListCondVO[] vos = (RocsManifestListCondVO[])models.toArray(new RocsManifestListCondVO[models.size()]);
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
	 * @throws IllegalAccessException
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crnNumber = this.crnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		 
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		 
		this.mtFlag = this.mtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgNo = this.pgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difChr = this.difChr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
