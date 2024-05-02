/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCusmanVO.java
*@FileTitle : KorCusmanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.10 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCusmanVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCusmanVO> models = new ArrayList<KorCusmanVO>();
	
	/* Column Info */
	private String ioQuay = null;
	/* Column Info */
	private String d2Cnt = null;
	/* Column Info */
	private String discMdCd = null;
	/* Column Info */
	private String d4Cnt = null;
	/* Column Info */
	private String blData = null;
	/* Column Info */
	private String portTmlCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String scDiv = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String resndChk = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String inType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dmstPortCd = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String cBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCusmanVO() {}

	public KorCusmanVO(String ibflag, String pagerows, String bkgNo, String cstmsDeclTpCd, String dmstPortCd, String blData, String scDiv, String cBlNo, String resndChk, String ktPa, String ioBndCd, String mrnNo, String d2Cnt, String d4Cnt, String blNo, String discMdCd, String ioQuay, String vvd, String portCd, String inType, String podCd, String polCd, String cntrNo, String portTmlCd) {
		this.ioQuay = ioQuay;
		this.d2Cnt = d2Cnt;
		this.discMdCd = discMdCd;
		this.d4Cnt = d4Cnt;
		this.blData = blData;
		this.portTmlCd = portTmlCd;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.scDiv = scDiv;
		this.pagerows = pagerows;
		this.resndChk = resndChk;
		this.podCd = podCd;
		this.vvd = vvd;
		this.polCd = polCd;
		this.inType = inType;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.dmstPortCd = dmstPortCd;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.cntrNo = cntrNo;
		this.ktPa = ktPa;
		this.portCd = portCd;
		this.cBlNo = cBlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("io_quay", getIoQuay());
		this.hashColumns.put("d2_cnt", getD2Cnt());
		this.hashColumns.put("disc_md_cd", getDiscMdCd());
		this.hashColumns.put("d4_cnt", getD4Cnt());
		this.hashColumns.put("bl_data", getBlData());
		this.hashColumns.put("port_tml_cd", getPortTmlCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("sc_div", getScDiv());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("resnd_chk", getResndChk());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dmst_port_cd", getDmstPortCd());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("c_bl_no", getCBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("io_quay", "ioQuay");
		this.hashFields.put("d2_cnt", "d2Cnt");
		this.hashFields.put("disc_md_cd", "discMdCd");
		this.hashFields.put("d4_cnt", "d4Cnt");
		this.hashFields.put("bl_data", "blData");
		this.hashFields.put("port_tml_cd", "portTmlCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("sc_div", "scDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("resnd_chk", "resndChk");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dmst_port_cd", "dmstPortCd");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ioQuay
	 */
	public String getIoQuay() {
		return this.ioQuay;
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
	 * @return discMdCd
	 */
	public String getDiscMdCd() {
		return this.discMdCd;
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
	 * @return blData
	 */
	public String getBlData() {
		return this.blData;
	}
	
	/**
	 * Column Info
	 * @return portTmlCd
	 */
	public String getPortTmlCd() {
		return this.portTmlCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return dmstPortCd
	 */
	public String getDmstPortCd() {
		return this.dmstPortCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
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
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
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
	 * @return cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
	}
	

	/**
	 * Column Info
	 * @param ioQuay
	 */
	public void setIoQuay(String ioQuay) {
		this.ioQuay = ioQuay;
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
	 * @param discMdCd
	 */
	public void setDiscMdCd(String discMdCd) {
		this.discMdCd = discMdCd;
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
	 * @param blData
	 */
	public void setBlData(String blData) {
		this.blData = blData;
	}
	
	/**
	 * Column Info
	 * @param portTmlCd
	 */
	public void setPortTmlCd(String portTmlCd) {
		this.portTmlCd = portTmlCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param dmstPortCd
	 */
	public void setDmstPortCd(String dmstPortCd) {
		this.dmstPortCd = dmstPortCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
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
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param cBlNo
	 */
	public void setCBlNo(String cBlNo) {
		this.cBlNo = cBlNo;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIoQuay(JSPUtil.getParameter(request, prefix + "io_quay", ""));
		setD2Cnt(JSPUtil.getParameter(request, prefix + "d2_cnt", ""));
		setDiscMdCd(JSPUtil.getParameter(request, prefix + "disc_md_cd", ""));
		setD4Cnt(JSPUtil.getParameter(request, prefix + "d4_cnt", ""));
		setBlData(JSPUtil.getParameter(request, prefix + "bl_data", ""));
		setPortTmlCd(JSPUtil.getParameter(request, prefix + "port_tml_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, prefix + "mrn_no", ""));
		setScDiv(JSPUtil.getParameter(request, prefix + "sc_div", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setResndChk(JSPUtil.getParameter(request, prefix + "resnd_chk", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDmstPortCd(JSPUtil.getParameter(request, prefix + "dmst_port_cd", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setKtPa(JSPUtil.getParameter(request, prefix + "kt_pa", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCusmanVO[]
	 */
	public KorCusmanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCusmanVO[]
	 */
	public KorCusmanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCusmanVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ioQuay = (JSPUtil.getParameter(request, prefix	+ "io_quay", length));
			String[] d2Cnt = (JSPUtil.getParameter(request, prefix	+ "d2_cnt", length));
			String[] discMdCd = (JSPUtil.getParameter(request, prefix	+ "disc_md_cd", length));
			String[] d4Cnt = (JSPUtil.getParameter(request, prefix	+ "d4_cnt", length));
			String[] blData = (JSPUtil.getParameter(request, prefix	+ "bl_data", length));
			String[] portTmlCd = (JSPUtil.getParameter(request, prefix	+ "port_tml_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] scDiv = (JSPUtil.getParameter(request, prefix	+ "sc_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] resndChk = (JSPUtil.getParameter(request, prefix	+ "resnd_chk", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dmstPortCd = (JSPUtil.getParameter(request, prefix	+ "dmst_port_cd", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCusmanVO();
				if (ioQuay[i] != null)
					model.setIoQuay(ioQuay[i]);
				if (d2Cnt[i] != null)
					model.setD2Cnt(d2Cnt[i]);
				if (discMdCd[i] != null)
					model.setDiscMdCd(discMdCd[i]);
				if (d4Cnt[i] != null)
					model.setD4Cnt(d4Cnt[i]);
				if (blData[i] != null)
					model.setBlData(blData[i]);
				if (portTmlCd[i] != null)
					model.setPortTmlCd(portTmlCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (scDiv[i] != null)
					model.setScDiv(scDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (resndChk[i] != null)
					model.setResndChk(resndChk[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dmstPortCd[i] != null)
					model.setDmstPortCd(dmstPortCd[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCusmanVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCusmanVO[]
	 */
	public KorCusmanVO[] getKorCusmanVOs(){
		KorCusmanVO[] vos = (KorCusmanVO[])models.toArray(new KorCusmanVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ioQuay = this.ioQuay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Cnt = this.d2Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discMdCd = this.discMdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Cnt = this.d4Cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blData = this.blData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTmlCd = this.portTmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scDiv = this.scDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resndChk = this.resndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstPortCd = this.dmstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
