/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMakeFlatFileMasterInfoVO.java
*@FileTitle : KorMakeFlatFileMasterInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMakeFlatFileMasterInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMakeFlatFileMasterInfoVO> models = new ArrayList<KorMakeFlatFileMasterInfoVO>();
	
	/* Column Info */
	private String unPolLoc = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String unPodLoc = null;
	/* Column Info */
	private String locCustoms = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String resndChk = null;
	/* Column Info */
	private String vndrScac = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String mrnType = null;
	/* Column Info */
	private String flatData = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String callSign = null;
	/* Column Info */
	private String imCustoms = null;
	/* Column Info */
	private String mrnNbr = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String bayVslNm = null;
	/* Column Info */
	private String kvSeq = null;
	/* Column Info */
	private String obType = null;
	/* Column Info */
	private String msnNbr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorMakeFlatFileMasterInfoVO() {}

	public KorMakeFlatFileMasterInfoVO(String ibflag, String pagerows, String resndChk, String ktPa, String mrnType, String imCustoms, String locCustoms, String vslFlag, String bayVslNm, String callSign, String mrnNbr, String vslCd, String vndrScac, String unPolLoc, String polLoc, String unPodLoc, String podLoc, String etaDt, String etdDt, String msnNbr, String obType, String svrId, String kvSeq, String flatData) {
		this.unPolLoc = unPolLoc;
		this.vslCd = vslCd;
		this.polLoc = polLoc;
		this.etaDt = etaDt;
		this.vslFlag = vslFlag;
		this.etdDt = etdDt;
		this.podLoc = podLoc;
		this.unPodLoc = unPodLoc;
		this.locCustoms = locCustoms;
		this.pagerows = pagerows;
		this.resndChk = resndChk;
		this.vndrScac = vndrScac;
		this.svrId = svrId;
		this.mrnType = mrnType;
		this.flatData = flatData;
		this.ibflag = ibflag;
		this.callSign = callSign;
		this.imCustoms = imCustoms;
		this.mrnNbr = mrnNbr;
		this.ktPa = ktPa;
		this.bayVslNm = bayVslNm;
		this.kvSeq = kvSeq;
		this.obType = obType;
		this.msnNbr = msnNbr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("un_pol_loc", getUnPolLoc());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("un_pod_loc", getUnPodLoc());
		this.hashColumns.put("loc_customs", getLocCustoms());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("resnd_chk", getResndChk());
		this.hashColumns.put("vndr_scac", getVndrScac());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("mrn_type", getMrnType());
		this.hashColumns.put("flat_data", getFlatData());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("call_sign", getCallSign());
		this.hashColumns.put("im_customs", getImCustoms());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("bay_vsl_nm", getBayVslNm());
		this.hashColumns.put("kv_seq", getKvSeq());
		this.hashColumns.put("ob_type", getObType());
		this.hashColumns.put("msn_nbr", getMsnNbr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("un_pol_loc", "unPolLoc");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("un_pod_loc", "unPodLoc");
		this.hashFields.put("loc_customs", "locCustoms");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("resnd_chk", "resndChk");
		this.hashFields.put("vndr_scac", "vndrScac");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("mrn_type", "mrnType");
		this.hashFields.put("flat_data", "flatData");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("call_sign", "callSign");
		this.hashFields.put("im_customs", "imCustoms");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("bay_vsl_nm", "bayVslNm");
		this.hashFields.put("kv_seq", "kvSeq");
		this.hashFields.put("ob_type", "obType");
		this.hashFields.put("msn_nbr", "msnNbr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return unPolLoc
	 */
	public String getUnPolLoc() {
		return this.unPolLoc;
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
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return podLoc
	 */
	public String getPodLoc() {
		return this.podLoc;
	}
	
	/**
	 * Column Info
	 * @return unPodLoc
	 */
	public String getUnPodLoc() {
		return this.unPodLoc;
	}
	
	/**
	 * Column Info
	 * @return locCustoms
	 */
	public String getLocCustoms() {
		return this.locCustoms;
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
	 * @return resndChk
	 */
	public String getResndChk() {
		return this.resndChk;
	}
	
	/**
	 * Column Info
	 * @return vndrScac
	 */
	public String getVndrScac() {
		return this.vndrScac;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return mrnType
	 */
	public String getMrnType() {
		return this.mrnType;
	}
	
	/**
	 * Column Info
	 * @return flatData
	 */
	public String getFlatData() {
		return this.flatData;
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
	 * @return callSign
	 */
	public String getCallSign() {
		return this.callSign;
	}
	
	/**
	 * Column Info
	 * @return imCustoms
	 */
	public String getImCustoms() {
		return this.imCustoms;
	}
	
	/**
	 * Column Info
	 * @return mrnNbr
	 */
	public String getMrnNbr() {
		return this.mrnNbr;
	}
	
	/**
	 * Column Info
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
	}
	
	/**
	 * Column Info
	 * @return bayVslNm
	 */
	public String getBayVslNm() {
		return this.bayVslNm;
	}
	
	/**
	 * Column Info
	 * @return kvSeq
	 */
	public String getKvSeq() {
		return this.kvSeq;
	}
	
	/**
	 * Column Info
	 * @return obType
	 */
	public String getObType() {
		return this.obType;
	}
	
	/**
	 * Column Info
	 * @return msnNbr
	 */
	public String getMsnNbr() {
		return this.msnNbr;
	}
	

	/**
	 * Column Info
	 * @param unPolLoc
	 */
	public void setUnPolLoc(String unPolLoc) {
		this.unPolLoc = unPolLoc;
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
	 * @param polLoc
	 */
	public void setPolLoc(String polLoc) {
		this.polLoc = polLoc;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param podLoc
	 */
	public void setPodLoc(String podLoc) {
		this.podLoc = podLoc;
	}
	
	/**
	 * Column Info
	 * @param unPodLoc
	 */
	public void setUnPodLoc(String unPodLoc) {
		this.unPodLoc = unPodLoc;
	}
	
	/**
	 * Column Info
	 * @param locCustoms
	 */
	public void setLocCustoms(String locCustoms) {
		this.locCustoms = locCustoms;
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
	 * @param resndChk
	 */
	public void setResndChk(String resndChk) {
		this.resndChk = resndChk;
	}
	
	/**
	 * Column Info
	 * @param vndrScac
	 */
	public void setVndrScac(String vndrScac) {
		this.vndrScac = vndrScac;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param mrnType
	 */
	public void setMrnType(String mrnType) {
		this.mrnType = mrnType;
	}
	
	/**
	 * Column Info
	 * @param flatData
	 */
	public void setFlatData(String flatData) {
		this.flatData = flatData;
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
	 * @param callSign
	 */
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	
	/**
	 * Column Info
	 * @param imCustoms
	 */
	public void setImCustoms(String imCustoms) {
		this.imCustoms = imCustoms;
	}
	
	/**
	 * Column Info
	 * @param mrnNbr
	 */
	public void setMrnNbr(String mrnNbr) {
		this.mrnNbr = mrnNbr;
	}
	
	/**
	 * Column Info
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
	}
	
	/**
	 * Column Info
	 * @param bayVslNm
	 */
	public void setBayVslNm(String bayVslNm) {
		this.bayVslNm = bayVslNm;
	}
	
	/**
	 * Column Info
	 * @param kvSeq
	 */
	public void setKvSeq(String kvSeq) {
		this.kvSeq = kvSeq;
	}
	
	/**
	 * Column Info
	 * @param obType
	 */
	public void setObType(String obType) {
		this.obType = obType;
	}
	
	/**
	 * Column Info
	 * @param msnNbr
	 */
	public void setMsnNbr(String msnNbr) {
		this.msnNbr = msnNbr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUnPolLoc(JSPUtil.getParameter(request, "un_pol_loc", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setVslFlag(JSPUtil.getParameter(request, "vsl_flag", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
		setUnPodLoc(JSPUtil.getParameter(request, "un_pod_loc", ""));
		setLocCustoms(JSPUtil.getParameter(request, "loc_customs", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setResndChk(JSPUtil.getParameter(request, "resnd_chk", ""));
		setVndrScac(JSPUtil.getParameter(request, "vndr_scac", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setMrnType(JSPUtil.getParameter(request, "mrn_type", ""));
		setFlatData(JSPUtil.getParameter(request, "flat_data", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCallSign(JSPUtil.getParameter(request, "call_sign", ""));
		setImCustoms(JSPUtil.getParameter(request, "im_customs", ""));
		setMrnNbr(JSPUtil.getParameter(request, "mrn_nbr", ""));
		setKtPa(JSPUtil.getParameter(request, "kt_pa", ""));
		setBayVslNm(JSPUtil.getParameter(request, "bay_vsl_nm", ""));
		setKvSeq(JSPUtil.getParameter(request, "kv_seq", ""));
		setObType(JSPUtil.getParameter(request, "ob_type", ""));
		setMsnNbr(JSPUtil.getParameter(request, "msn_nbr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMakeFlatFileMasterInfoVO[]
	 */
	public KorMakeFlatFileMasterInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMakeFlatFileMasterInfoVO[]
	 */
	public KorMakeFlatFileMasterInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMakeFlatFileMasterInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] unPolLoc = (JSPUtil.getParameter(request, prefix	+ "un_pol_loc", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] unPodLoc = (JSPUtil.getParameter(request, prefix	+ "un_pod_loc", length));
			String[] locCustoms = (JSPUtil.getParameter(request, prefix	+ "loc_customs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] resndChk = (JSPUtil.getParameter(request, prefix	+ "resnd_chk", length));
			String[] vndrScac = (JSPUtil.getParameter(request, prefix	+ "vndr_scac", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] mrnType = (JSPUtil.getParameter(request, prefix	+ "mrn_type", length));
			String[] flatData = (JSPUtil.getParameter(request, prefix	+ "flat_data", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] callSign = (JSPUtil.getParameter(request, prefix	+ "call_sign", length));
			String[] imCustoms = (JSPUtil.getParameter(request, prefix	+ "im_customs", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] bayVslNm = (JSPUtil.getParameter(request, prefix	+ "bay_vsl_nm", length));
			String[] kvSeq = (JSPUtil.getParameter(request, prefix	+ "kv_seq", length));
			String[] obType = (JSPUtil.getParameter(request, prefix	+ "ob_type", length));
			String[] msnNbr = (JSPUtil.getParameter(request, prefix	+ "msn_nbr", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMakeFlatFileMasterInfoVO();
				if (unPolLoc[i] != null)
					model.setUnPolLoc(unPolLoc[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (unPodLoc[i] != null)
					model.setUnPodLoc(unPodLoc[i]);
				if (locCustoms[i] != null)
					model.setLocCustoms(locCustoms[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (resndChk[i] != null)
					model.setResndChk(resndChk[i]);
				if (vndrScac[i] != null)
					model.setVndrScac(vndrScac[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (mrnType[i] != null)
					model.setMrnType(mrnType[i]);
				if (flatData[i] != null)
					model.setFlatData(flatData[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (callSign[i] != null)
					model.setCallSign(callSign[i]);
				if (imCustoms[i] != null)
					model.setImCustoms(imCustoms[i]);
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (bayVslNm[i] != null)
					model.setBayVslNm(bayVslNm[i]);
				if (kvSeq[i] != null)
					model.setKvSeq(kvSeq[i]);
				if (obType[i] != null)
					model.setObType(obType[i]);
				if (msnNbr[i] != null)
					model.setMsnNbr(msnNbr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMakeFlatFileMasterInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMakeFlatFileMasterInfoVO[]
	 */
	public KorMakeFlatFileMasterInfoVO[] getKorMakeFlatFileMasterInfoVOs(){
		KorMakeFlatFileMasterInfoVO[] vos = (KorMakeFlatFileMasterInfoVO[])models.toArray(new KorMakeFlatFileMasterInfoVO[models.size()]);
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
		this.unPolLoc = this.unPolLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unPodLoc = this.unPodLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCustoms = this.locCustoms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resndChk = this.resndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrScac = this.vndrScac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnType = this.mrnType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatData = this.flatData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSign = this.callSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imCustoms = this.imCustoms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayVslNm = this.bayVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvSeq = this.kvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obType = this.obType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNbr = this.msnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
