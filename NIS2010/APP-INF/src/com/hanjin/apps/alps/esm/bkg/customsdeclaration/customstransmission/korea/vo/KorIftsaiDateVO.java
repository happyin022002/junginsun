/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorIftsaiDateVO.java
*@FileTitle : KorIftsaiDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.30 박상훈 
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

public class KorIftsaiDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorIftsaiDateVO> models = new ArrayList<KorIftsaiDateVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String locDesc = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cct = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String vpsCallSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String portInd = null;
	/* Column Info */
	private String ft = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorIftsaiDateVO() {}

	public KorIftsaiDateVO(String ibflag, String pagerows, String portInd, String locCd, String locDesc, String ydCd, String eta, String etd, String etb, String cct, String ft, String vslCd, String skdVoyNo, String skdDirCd, String vpsCallSeq) {
		this.etb = etb;
		this.eta = eta;
		this.vslCd = vslCd;
		this.etd = etd;
		this.locDesc = locDesc;
		this.skdVoyNo = skdVoyNo;
		this.cct = cct;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.vpsCallSeq = vpsCallSeq;
		this.ydCd = ydCd;
		this.portInd = portInd;
		this.ft = ft;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("loc_desc", getLocDesc());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cct", getCct());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("vps_call_seq", getVpsCallSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("port_ind", getPortInd());
		this.hashColumns.put("ft", getFt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("loc_desc", "locDesc");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cct", "cct");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vps_call_seq", "vpsCallSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("port_ind", "portInd");
		this.hashFields.put("ft", "ft");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return locDesc
	 */
	public String getLocDesc() {
		return this.locDesc;
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
	 * @return cct
	 */
	public String getCct() {
		return this.cct;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return vpsCallSeq
	 */
	public String getVpsCallSeq() {
		return this.vpsCallSeq;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return portInd
	 */
	public String getPortInd() {
		return this.portInd;
	}
	
	/**
	 * Column Info
	 * @return ft
	 */
	public String getFt() {
		return this.ft;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param locDesc
	 */
	public void setLocDesc(String locDesc) {
		this.locDesc = locDesc;
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
	 * @param cct
	 */
	public void setCct(String cct) {
		this.cct = cct;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param vpsCallSeq
	 */
	public void setVpsCallSeq(String vpsCallSeq) {
		this.vpsCallSeq = vpsCallSeq;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param portInd
	 */
	public void setPortInd(String portInd) {
		this.portInd = portInd;
	}
	
	/**
	 * Column Info
	 * @param ft
	 */
	public void setFt(String ft) {
		this.ft = ft;
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
		setEtb(JSPUtil.getParameter(request, prefix + "etb", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setLocDesc(JSPUtil.getParameter(request, prefix + "loc_desc", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCct(JSPUtil.getParameter(request, prefix + "cct", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setVpsCallSeq(JSPUtil.getParameter(request, prefix + "vps_call_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setPortInd(JSPUtil.getParameter(request, prefix + "port_ind", ""));
		setFt(JSPUtil.getParameter(request, prefix + "ft", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorIftsaiDateVO[]
	 */
	public KorIftsaiDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorIftsaiDateVO[]
	 */
	public KorIftsaiDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorIftsaiDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] locDesc = (JSPUtil.getParameter(request, prefix	+ "loc_desc", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cct = (JSPUtil.getParameter(request, prefix	+ "cct", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] vpsCallSeq = (JSPUtil.getParameter(request, prefix	+ "vps_call_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] portInd = (JSPUtil.getParameter(request, prefix	+ "port_ind", length));
			String[] ft = (JSPUtil.getParameter(request, prefix	+ "ft", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorIftsaiDateVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (locDesc[i] != null)
					model.setLocDesc(locDesc[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cct[i] != null)
					model.setCct(cct[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (vpsCallSeq[i] != null)
					model.setVpsCallSeq(vpsCallSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (portInd[i] != null)
					model.setPortInd(portInd[i]);
				if (ft[i] != null)
					model.setFt(ft[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorIftsaiDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorIftsaiDateVO[]
	 */
	public KorIftsaiDateVO[] getKorIftsaiDateVOs(){
		KorIftsaiDateVO[] vos = (KorIftsaiDateVO[])models.toArray(new KorIftsaiDateVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDesc = this.locDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cct = this.cct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsCallSeq = this.vpsCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInd = this.portInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ft = this.ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
