/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AustraliaManifestTransmitVO.java
*@FileTitle : AustraliaManifestTransmitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.09.10 임재택
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AustraliaManifestTransmitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AustraliaManifestTransmitVO> models = new ArrayList<AustraliaManifestTransmitVO>();

	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String bkgSpeBb = null;
	/* Column Info */
	private String st9 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String transGubun = null;
	/* Column Info */
	private String bkgSpeDg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ediInd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgSpeRd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String st10 = null;
	/* Column Info */
	private String bkgSpeRf = null;
	/* Column Info */
	private String bkgSpeAk = null;
	/* Column Info */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AustraliaManifestTransmitVO() {}

	public AustraliaManifestTransmitVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String ediInd, String transGubun, String bkgNo, String cntrNo, String bkgCgoTp, String bkgSpeRf, String bkgSpeDg, String bkgSpeAk, String bkgSpeBb, String cmdtDesc, String cmdtCd, String bkgSpeRd, String st9, String st10, String portCd) {
		this.vslCd = vslCd;
		this.bkgCgoTp = bkgCgoTp;
		this.bkgSpeBb = bkgSpeBb;
		this.st9 = st9;
		this.skdVoyNo = skdVoyNo;
		this.transGubun = transGubun;
		this.bkgSpeDg = bkgSpeDg;
		this.skdDirCd = skdDirCd;
		this.ediInd = ediInd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.bkgSpeRd = bkgSpeRd;
		this.cmdtCd = cmdtCd;
		this.cmdtDesc = cmdtDesc;
		this.cntrNo = cntrNo;
		this.st10 = st10;
		this.bkgSpeRf = bkgSpeRf;
		this.bkgSpeAk = bkgSpeAk;
		this.portCd = portCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("bkg_spe_bb", getBkgSpeBb());
		this.hashColumns.put("st_9", getSt9());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("trans_gubun", getTransGubun());
		this.hashColumns.put("bkg_spe_dg", getBkgSpeDg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("edi_ind", getEdiInd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_spe_rd", getBkgSpeRd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("st_10", getSt10());
		this.hashColumns.put("bkg_spe_rf", getBkgSpeRf());
		this.hashColumns.put("bkg_spe_ak", getBkgSpeAk());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("bkg_spe_bb", "bkgSpeBb");
		this.hashFields.put("st_9", "st9");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("trans_gubun", "transGubun");
		this.hashFields.put("bkg_spe_dg", "bkgSpeDg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("edi_ind", "ediInd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_spe_rd", "bkgSpeRd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("st_10", "st10");
		this.hashFields.put("bkg_spe_rf", "bkgSpeRf");
		this.hashFields.put("bkg_spe_ak", "bkgSpeAk");
		this.hashFields.put("port_cd", "portCd");
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
	 * @return bkgCgoTp
	 */
	public String getBkgCgoTp() {
		return this.bkgCgoTp;
	}

	/**
	 * Column Info
	 * @return bkgSpeBb
	 */
	public String getBkgSpeBb() {
		return this.bkgSpeBb;
	}

	/**
	 * Column Info
	 * @return st9
	 */
	public String getSt9() {
		return this.st9;
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
	 * @return transGubun
	 */
	public String getTransGubun() {
		return this.transGubun;
	}

	/**
	 * Column Info
	 * @return bkgSpeDg
	 */
	public String getBkgSpeDg() {
		return this.bkgSpeDg;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}

	/**
	 * Column Info
	 * @return ediInd
	 */
	public String getEdiInd() {
		return this.ediInd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}

	/**
	 * Column Info
	 * @return bkgSpeRd
	 */
	public String getBkgSpeRd() {
		return this.bkgSpeRd;
	}

	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}

	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
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
	 * @return st10
	 */
	public String getSt10() {
		return this.st10;
	}

	/**
	 * Column Info
	 * @return bkgSpeRf
	 */
	public String getBkgSpeRf() {
		return this.bkgSpeRf;
	}

	/**
	 * Column Info
	 * @return bkgSpeAk
	 */
	public String getBkgSpeAk() {
		return this.bkgSpeAk;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @param bkgCgoTp
	 */
	public void setBkgCgoTp(String bkgCgoTp) {
		this.bkgCgoTp = bkgCgoTp;
	}

	/**
	 * Column Info
	 * @param bkgSpeBb
	 */
	public void setBkgSpeBb(String bkgSpeBb) {
		this.bkgSpeBb = bkgSpeBb;
	}

	/**
	 * Column Info
	 * @param st9
	 */
	public void setSt9(String st9) {
		this.st9 = st9;
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
	 * @param transGubun
	 */
	public void setTransGubun(String transGubun) {
		this.transGubun = transGubun;
	}

	/**
	 * Column Info
	 * @param bkgSpeDg
	 */
	public void setBkgSpeDg(String bkgSpeDg) {
		this.bkgSpeDg = bkgSpeDg;
	}

	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * Column Info
	 * @param ediInd
	 */
	public void setEdiInd(String ediInd) {
		this.ediInd = ediInd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @param bkgSpeRd
	 */
	public void setBkgSpeRd(String bkgSpeRd) {
		this.bkgSpeRd = bkgSpeRd;
	}

	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
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
	 * @param st10
	 */
	public void setSt10(String st10) {
		this.st10 = st10;
	}

	/**
	 * Column Info
	 * @param bkgSpeRf
	 */
	public void setBkgSpeRf(String bkgSpeRf) {
		this.bkgSpeRf = bkgSpeRf;
	}

	/**
	 * Column Info
	 * @param bkgSpeAk
	 */
	public void setBkgSpeAk(String bkgSpeAk) {
		this.bkgSpeAk = bkgSpeAk;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, "bkg_cgo_tp", ""));
		setBkgSpeBb(JSPUtil.getParameter(request, "bkg_spe_bb", ""));
		setSt9(JSPUtil.getParameter(request, "st_9", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setTransGubun(JSPUtil.getParameter(request, "trans_gubun", ""));
		setBkgSpeDg(JSPUtil.getParameter(request, "bkg_spe_dg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setEdiInd(JSPUtil.getParameter(request, "edi_ind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgSpeRd(JSPUtil.getParameter(request, "bkg_spe_rd", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSt10(JSPUtil.getParameter(request, "st_10", ""));
		setBkgSpeRf(JSPUtil.getParameter(request, "bkg_spe_rf", ""));
		setBkgSpeAk(JSPUtil.getParameter(request, "bkg_spe_ak", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AustraliaManifestTransmitVO[]
	 */
	public AustraliaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AustraliaManifestTransmitVO[]
	 */
	public AustraliaManifestTransmitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AustraliaManifestTransmitVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] bkgSpeBb = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_bb", length));
			String[] st9 = (JSPUtil.getParameter(request, prefix	+ "st_9", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] transGubun = (JSPUtil.getParameter(request, prefix	+ "trans_gubun", length));
			String[] bkgSpeDg = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_dg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ediInd = (JSPUtil.getParameter(request, prefix	+ "edi_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgSpeRd = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] st10 = (JSPUtil.getParameter(request, prefix	+ "st_10", length));
			String[] bkgSpeRf = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rf", length));
			String[] bkgSpeAk = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_ak", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));

			for (int i = 0; i < length; i++) {
				model = new AustraliaManifestTransmitVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (bkgSpeBb[i] != null)
					model.setBkgSpeBb(bkgSpeBb[i]);
				if (st9[i] != null)
					model.setSt9(st9[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (transGubun[i] != null)
					model.setTransGubun(transGubun[i]);
				if (bkgSpeDg[i] != null)
					model.setBkgSpeDg(bkgSpeDg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ediInd[i] != null)
					model.setEdiInd(ediInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgSpeRd[i] != null)
					model.setBkgSpeRd(bkgSpeRd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (st10[i] != null)
					model.setSt10(st10[i]);
				if (bkgSpeRf[i] != null)
					model.setBkgSpeRf(bkgSpeRf[i]);
				if (bkgSpeAk[i] != null)
					model.setBkgSpeAk(bkgSpeAk[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAustraliaManifestTransmitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AustraliaManifestTransmitVO[]
	 */
	public AustraliaManifestTransmitVO[] getAustraliaManifestTransmitVOs(){
		AustraliaManifestTransmitVO[] vos = (AustraliaManifestTransmitVO[])models.toArray(new AustraliaManifestTransmitVO[models.size()]);
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
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeBb = this.bkgSpeBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st9 = this.st9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transGubun = this.transGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeDg = this.bkgSpeDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediInd = this.ediInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRd = this.bkgSpeRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st10 = this.st10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRf = this.bkgSpeRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeAk = this.bkgSpeAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
