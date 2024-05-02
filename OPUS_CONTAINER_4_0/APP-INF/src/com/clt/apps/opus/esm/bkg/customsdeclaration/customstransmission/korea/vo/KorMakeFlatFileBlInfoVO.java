/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMakeFlatFileBlInfoVO.java
*@FileTitle : KorMakeFlatFileBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMakeFlatFileBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorMakeFlatFileBlInfoVO> models = new ArrayList<KorMakeFlatFileBlInfoVO>();

	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String polLoc = null;
	/* Column Info */
	private String d2Cnt = null;
	/* Column Info */
	private String blData = null;
	/* Column Info */
	private String d4Cnt = null;
	/* Column Info */
	private String aKtPort = null;
	/* Column Info */
	private String kcdTp = null;
	/* Column Info */
	private String podLoc = null;
	/* Column Info */
	private String kvIoQuay = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String scDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String resndChk = null;
	/* Column Info */
	private String mrnType = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mrnNbr = null;
	/* Column Info */
	private String kvDmCd = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String obType = null;
	/* Column Info */
	private String ktPort = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorMakeFlatFileBlInfoVO() {}

	public KorMakeFlatFileBlInfoVO(String ibflag, String pagerows, String resndChk, String ktPa, String mrnType, String mrnNbr, String d2Cnt, String d4Cnt, String kvDmCd, String kvIoQuay, String vslCd, String blNo, String ktPort, String obType, String podLoc, String polLoc, String bkgNo, String kcdTp, String aKtPort, String blData, String scDiv) {
		this.vslCd = vslCd;
		this.polLoc = polLoc;
		this.d2Cnt = d2Cnt;
		this.blData = blData;
		this.d4Cnt = d4Cnt;
		this.aKtPort = aKtPort;
		this.kcdTp = kcdTp;
		this.podLoc = podLoc;
		this.kvIoQuay = kvIoQuay;
		this.blNo = blNo;
		this.scDiv = scDiv;
		this.pagerows = pagerows;
		this.resndChk = resndChk;
		this.mrnType = mrnType;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.mrnNbr = mrnNbr;
		this.kvDmCd = kvDmCd;
		this.ktPa = ktPa;
		this.obType = obType;
		this.ktPort = ktPort;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pol_loc", getPolLoc());
		this.hashColumns.put("d2_cnt", getD2Cnt());
		this.hashColumns.put("bl_data", getBlData());
		this.hashColumns.put("d4_cnt", getD4Cnt());
		this.hashColumns.put("a_kt_port", getAKtPort());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("pod_loc", getPodLoc());
		this.hashColumns.put("kv_io_quay", getKvIoQuay());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sc_div", getScDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("resnd_chk", getResndChk());
		this.hashColumns.put("mrn_type", getMrnType());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mrn_nbr", getMrnNbr());
		this.hashColumns.put("kv_dm_cd", getKvDmCd());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("ob_type", getObType());
		this.hashColumns.put("kt_port", getKtPort());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pol_loc", "polLoc");
		this.hashFields.put("d2_cnt", "d2Cnt");
		this.hashFields.put("bl_data", "blData");
		this.hashFields.put("d4_cnt", "d4Cnt");
		this.hashFields.put("a_kt_port", "aKtPort");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("pod_loc", "podLoc");
		this.hashFields.put("kv_io_quay", "kvIoQuay");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sc_div", "scDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("resnd_chk", "resndChk");
		this.hashFields.put("mrn_type", "mrnType");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mrn_nbr", "mrnNbr");
		this.hashFields.put("kv_dm_cd", "kvDmCd");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("ob_type", "obType");
		this.hashFields.put("kt_port", "ktPort");
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
	 * @return polLoc
	 */
	public String getPolLoc() {
		return this.polLoc;
	}

	/**
	 * Column Info
	 * @return d2Cnt
	 */
	public String getD2Cnt() {
		return this.d2Cnt;
	}

	/**
	 * Column Info
	 * @return blData
	 */
	public String getBlData() {
		return this.blData;
	}

	/**
	 * Column Info
	 * @return d4Cnt
	 */
	public String getD4Cnt() {
		return this.d4Cnt;
	}

	/**
	 * Column Info
	 * @return aKtPort
	 */
	public String getAKtPort() {
		return this.aKtPort;
	}

	/**
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
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
	 * @return kvIoQuay
	 */
	public String getKvIoQuay() {
		return this.kvIoQuay;
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
	 * @return scDiv
	 */
	public String getScDiv() {
		return this.scDiv;
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
	 * @return mrnType
	 */
	public String getMrnType() {
		return this.mrnType;
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
	 * @return mrnNbr
	 */
	public String getMrnNbr() {
		return this.mrnNbr;
	}

	/**
	 * Column Info
	 * @return kvDmCd
	 */
	public String getKvDmCd() {
		return this.kvDmCd;
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
	 * @return obType
	 */
	public String getObType() {
		return this.obType;
	}

	/**
	 * Column Info
	 * @return ktPort
	 */
	public String getKtPort() {
		return this.ktPort;
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
	 * @param d2Cnt
	 */
	public void setD2Cnt(String d2Cnt) {
		this.d2Cnt = d2Cnt;
	}

	/**
	 * Column Info
	 * @param blData
	 */
	public void setBlData(String blData) {
		this.blData = blData;
	}

	/**
	 * Column Info
	 * @param d4Cnt
	 */
	public void setD4Cnt(String d4Cnt) {
		this.d4Cnt = d4Cnt;
	}

	/**
	 * Column Info
	 * @param aKtPort
	 */
	public void setAKtPort(String aKtPort) {
		this.aKtPort = aKtPort;
	}

	/**
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
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
	 * @param kvIoQuay
	 */
	public void setKvIoQuay(String kvIoQuay) {
		this.kvIoQuay = kvIoQuay;
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
	 * @param scDiv
	 */
	public void setScDiv(String scDiv) {
		this.scDiv = scDiv;
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
	 * @param mrnType
	 */
	public void setMrnType(String mrnType) {
		this.mrnType = mrnType;
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
	 * @param mrnNbr
	 */
	public void setMrnNbr(String mrnNbr) {
		this.mrnNbr = mrnNbr;
	}

	/**
	 * Column Info
	 * @param kvDmCd
	 */
	public void setKvDmCd(String kvDmCd) {
		this.kvDmCd = kvDmCd;
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
	 * @param obType
	 */
	public void setObType(String obType) {
		this.obType = obType;
	}

	/**
	 * Column Info
	 * @param ktPort
	 */
	public void setKtPort(String ktPort) {
		this.ktPort = ktPort;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPolLoc(JSPUtil.getParameter(request, "pol_loc", ""));
		setD2Cnt(JSPUtil.getParameter(request, "d2_cnt", ""));
		setBlData(JSPUtil.getParameter(request, "bl_data", ""));
		setD4Cnt(JSPUtil.getParameter(request, "d4_cnt", ""));
		setAKtPort(JSPUtil.getParameter(request, "a_kt_port", ""));
		setKcdTp(JSPUtil.getParameter(request, "kcd_tp", ""));
		setPodLoc(JSPUtil.getParameter(request, "pod_loc", ""));
		setKvIoQuay(JSPUtil.getParameter(request, "kv_io_quay", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setScDiv(JSPUtil.getParameter(request, "sc_div", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setResndChk(JSPUtil.getParameter(request, "resnd_chk", ""));
		setMrnType(JSPUtil.getParameter(request, "mrn_type", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMrnNbr(JSPUtil.getParameter(request, "mrn_nbr", ""));
		setKvDmCd(JSPUtil.getParameter(request, "kv_dm_cd", ""));
		setKtPa(JSPUtil.getParameter(request, "kt_pa", ""));
		setObType(JSPUtil.getParameter(request, "ob_type", ""));
		setKtPort(JSPUtil.getParameter(request, "kt_port", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMakeFlatFileBlInfoVO[]
	 */
	public KorMakeFlatFileBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorMakeFlatFileBlInfoVO[]
	 */
	public KorMakeFlatFileBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMakeFlatFileBlInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] polLoc = (JSPUtil.getParameter(request, prefix	+ "pol_loc", length));
			String[] d2Cnt = (JSPUtil.getParameter(request, prefix	+ "d2_cnt", length));
			String[] blData = (JSPUtil.getParameter(request, prefix	+ "bl_data", length));
			String[] d4Cnt = (JSPUtil.getParameter(request, prefix	+ "d4_cnt", length));
			String[] aKtPort = (JSPUtil.getParameter(request, prefix	+ "a_kt_port", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] podLoc = (JSPUtil.getParameter(request, prefix	+ "pod_loc", length));
			String[] kvIoQuay = (JSPUtil.getParameter(request, prefix	+ "kv_io_quay", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] scDiv = (JSPUtil.getParameter(request, prefix	+ "sc_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] resndChk = (JSPUtil.getParameter(request, prefix	+ "resnd_chk", length));
			String[] mrnType = (JSPUtil.getParameter(request, prefix	+ "mrn_type", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mrnNbr = (JSPUtil.getParameter(request, prefix	+ "mrn_nbr", length));
			String[] kvDmCd = (JSPUtil.getParameter(request, prefix	+ "kv_dm_cd", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] obType = (JSPUtil.getParameter(request, prefix	+ "ob_type", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));

			for (int i = 0; i < length; i++) {
				model = new KorMakeFlatFileBlInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (polLoc[i] != null)
					model.setPolLoc(polLoc[i]);
				if (d2Cnt[i] != null)
					model.setD2Cnt(d2Cnt[i]);
				if (blData[i] != null)
					model.setBlData(blData[i]);
				if (d4Cnt[i] != null)
					model.setD4Cnt(d4Cnt[i]);
				if (aKtPort[i] != null)
					model.setAKtPort(aKtPort[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (podLoc[i] != null)
					model.setPodLoc(podLoc[i]);
				if (kvIoQuay[i] != null)
					model.setKvIoQuay(kvIoQuay[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (scDiv[i] != null)
					model.setScDiv(scDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (resndChk[i] != null)
					model.setResndChk(resndChk[i]);
				if (mrnType[i] != null)
					model.setMrnType(mrnType[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mrnNbr[i] != null)
					model.setMrnNbr(mrnNbr[i]);
				if (kvDmCd[i] != null)
					model.setKvDmCd(kvDmCd[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (obType[i] != null)
					model.setObType(obType[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMakeFlatFileBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMakeFlatFileBlInfoVO[]
	 */
	public KorMakeFlatFileBlInfoVO[] getKorMakeFlatFileBlInfoVOs(){
		KorMakeFlatFileBlInfoVO[] vos = (KorMakeFlatFileBlInfoVO[])models.toArray(new KorMakeFlatFileBlInfoVO[models.size()]);
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
		this.polLoc = this.polLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Cnt = this.d2Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blData = this.blData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Cnt = this.d4Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aKtPort = this.aKtPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podLoc = this.podLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvIoQuay = this.kvIoQuay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scDiv = this.scDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resndChk = this.resndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnType = this.mrnType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNbr = this.mrnNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvDmCd = this.kvDmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obType = this.obType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
