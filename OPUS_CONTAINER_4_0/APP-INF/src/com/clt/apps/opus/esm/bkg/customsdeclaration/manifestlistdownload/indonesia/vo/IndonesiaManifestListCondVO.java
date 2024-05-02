/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaManifestListCondVO.java
*@FileTitle : IndonesiaManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장지영
*@LastVersion : 1.0
* 2009.09.29 장지영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo;

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
 * @author JI-YOUNG JANG
 * @since J2EE 1.5
 */
public class IndonesiaManifestListCondVO extends ManifestListCondVO{

	private static final long serialVersionUID = 1L;
	
	private Collection<IndonesiaManifestListCondVO> models = new ArrayList<IndonesiaManifestListCondVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgNo = null;	 
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
	private String blNo = null;
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
	/* Column Info */
	private String boundCd = null;
	/* Column Info */
	private String mfTpCd = null;
	/* Page Number */
	private String pagerows = null;
	private String whereQuery = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndonesiaManifestListCondVO() {}

	public IndonesiaManifestListCondVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, 
			String skdDirCd, String bkgNo,String mtFlag,String polCd,String podCd, String boundCd, String mfTpCd,
			String blNo,String blNoTp,String blNoChk,String difChr,String cntrNo,String pgNo,String blTpCd,String whereQuery) {
		this.ibflag = ibflag;
		this.vslCd = vslCd;
		this.bkgNo = bkgNo;		 
		this.skdDirCd = skdDirCd;
		this.skdVoyNo = skdVoyNo;
		this.mtFlag = mtFlag;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.polCd = polCd;
		this.boundCd = boundCd;
		this.mfTpCd = mfTpCd;
		this.blNo = blNo;
		this.pgNo = pgNo;
		this.blTpCd = blTpCd;
		this.blNoTp = blNoTp;
		this.blNoChk = blNoChk;
		this.cntrNo = cntrNo;
		this.difChr = difChr;
		this.whereQuery = whereQuery;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_no", getBkgNo());		 
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("mt_flag", getMtFlag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bound_cd", getBoundCd());
		this.hashColumns.put("mf_tp_cd", getMfTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pg_no", getPgNo());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("dif_chr", getDifChr());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("where_query", getWhereQuery());
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
		this.hashFields.put("bkg_no", "bkgNo");		 
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("mt_flag", "mtFlag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bound_cd", "boundCd");
		this.hashFields.put("mf_tp_cd", "mfTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pg_no", "pgNo");
		this.hashFields.put("where_query", "whereQuery");
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
	public String getWhereQuery() {
		return this.whereQuery;
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
	public String getBoundCd() {
		return this.boundCd;
	}
	public String getMfTpCd() {
		return this.mfTpCd;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getBkgNo() {
		return this.bkgNo;
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
	}
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	public void setWhereQuery(String whereQuery) {
		this.whereQuery = whereQuery;
	}
	public void setPgNo(String pgNo) {
		this.pgNo = pgNo;
	}
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	public void setDifChr(String difChr) {
		this.difChr = difChr;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
	}
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	public void setBoundCd(String boundCd) {
		this.boundCd = boundCd;
	}
	public void setMfTpCd(String mfTpCd) {
		this.mfTpCd = mfTpCd;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	public void setMtFlag(String mtFlag) {
		this.mtFlag = mtFlag;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));		 
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));		 
		setMtFlag(JSPUtil.getParameter(request, "mt_flag", ""));		 
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));		 
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));		 
		setBoundCd(JSPUtil.getParameter(request, "bound_cd", ""));	
		setMfTpCd(JSPUtil.getParameter(request, "mf_tp_cd", ""));	
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));	
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));	
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));		
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));		
		setDifChr(JSPUtil.getParameter(request, "dif_chr", ""));		
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));	
		setWhereQuery(JSPUtil.getParameter(request, "where_query", ""));	
		setPgNo(JSPUtil.getParameter(request, "pg_no", ""));		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public IndonesiaManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public IndonesiaManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndonesiaManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));			 
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));	
			String[] mtFlag = (JSPUtil.getParameter(request, prefix	+ "mt_flag".trim(), length));	
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));	
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));	
			String[] boundCd = (JSPUtil.getParameter(request, prefix	+ "bound_cd".trim(), length));	
			String[] mfTpCd = (JSPUtil.getParameter(request, prefix	+ "mf_tp_cd".trim(), length));	
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));	
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd".trim(), length));	
			String[] pgNo = (JSPUtil.getParameter(request, prefix	+ "pg_no".trim(), length));	
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));	
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));	
			String[] difChr = (JSPUtil.getParameter(request, prefix	+ "dif_chr".trim(), length));	
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));	
			String[] whereQuery = (JSPUtil.getParameter(request, prefix	+ "where_query".trim(), length));	
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new IndonesiaManifestListCondVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (whereQuery[i] != null)
					model.setWhereQuery(whereQuery[i]);
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
				if (boundCd[i] != null)
					model.setBoundCd(boundCd[i]);
				if (mfTpCd[i] != null)
					model.setMfTpCd(mfTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);				 
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
		return getIndonesiaManifestListCondVOs();
	}

	public IndonesiaManifestListCondVO[] getIndonesiaManifestListCondVOs(){
		IndonesiaManifestListCondVO[] vos = (IndonesiaManifestListCondVO[])models.toArray(new IndonesiaManifestListCondVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		 
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
		this.boundCd = this.boundCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfTpCd = this.mfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.difChr = this.difChr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whereQuery = this.whereQuery .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
