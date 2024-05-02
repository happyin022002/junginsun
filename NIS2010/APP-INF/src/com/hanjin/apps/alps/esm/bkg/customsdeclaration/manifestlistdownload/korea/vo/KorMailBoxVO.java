/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : KorMailBoxVO.java
*@FileTitle : KorMailBoxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorMailBoxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMailBoxVO> models = new ArrayList<KorMailBoxVO>();
	
	/* Column Info */
	private String bkgActwgtQty = null;
	/* Column Info */
	private String prtLodgFlg = null;
	/* Column Info */
	private String kcdTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ktSeq = null;
	/* Column Info */
	private String exptKdTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String username = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bmeElno = null;
	/* Column Info */
	private String bkgActwgtTp = null;
	/* Column Info */
	private String bkgPkgCd = null;
	/* Column Info */
	private String bkgPkgQty = null;
	/* Column Info */
	private String ktPort = null;
	/* Column Info */
	private String cBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public KorMailBoxVO() {}

	public KorMailBoxVO(String ibflag, String pagerows, String bkgActwgtQty, String kcdTp, String ktSeq, String exptKdTp, String username, String bkgNo, String bmeElno, String bkgActwgtTp, String bkgPkgCd, String bkgPkgQty, String ktPort, String cBlNo, String prtLodgFlg) {
		this.bkgActwgtQty = bkgActwgtQty;
		this.prtLodgFlg = prtLodgFlg;
		this.kcdTp = kcdTp;
		this.pagerows = pagerows;
		this.ktSeq = ktSeq;
		this.exptKdTp = exptKdTp;
		this.ibflag = ibflag;
		this.username = username;
		this.bkgNo = bkgNo;
		this.bmeElno = bmeElno;
		this.bkgActwgtTp = bkgActwgtTp;
		this.bkgPkgCd = bkgPkgCd;
		this.bkgPkgQty = bkgPkgQty;
		this.ktPort = ktPort;
		this.cBlNo = cBlNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_actwgt_qty", getBkgActwgtQty());
		this.hashColumns.put("prt_lodg_flg", getPrtLodgFlg());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kt_seq", getKtSeq());
		this.hashColumns.put("expt_kd_tp", getExptKdTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bme_elno", getBmeElno());
		this.hashColumns.put("bkg_actwgt_tp", getBkgActwgtTp());
		this.hashColumns.put("bkg_pkg_cd", getBkgPkgCd());
		this.hashColumns.put("bkg_pkg_qty", getBkgPkgQty());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("c_bl_no", getCBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_actwgt_qty", "bkgActwgtQty");
		this.hashFields.put("prt_lodg_flg", "prtLodgFlg");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kt_seq", "ktSeq");
		this.hashFields.put("expt_kd_tp", "exptKdTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("username", "username");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bme_elno", "bmeElno");
		this.hashFields.put("bkg_actwgt_tp", "bkgActwgtTp");
		this.hashFields.put("bkg_pkg_cd", "bkgPkgCd");
		this.hashFields.put("bkg_pkg_qty", "bkgPkgQty");
		this.hashFields.put("kt_port", "ktPort");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgActwgtQty
	 */
	public String getBkgActwgtQty() {
		return this.bkgActwgtQty;
	}
	
	/**
	 * Column Info
	 * @return prtLodgFlg
	 */
	public String getPrtLodgFlg() {
		return this.prtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
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
	 * @return ktSeq
	 */
	public String getKtSeq() {
		return this.ktSeq;
	}
	
	/**
	 * Column Info
	 * @return exptKdTp
	 */
	public String getExptKdTp() {
		return this.exptKdTp;
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
	 * @return username
	 */
	public String getUsername() {
		return this.username;
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
	 * @return bmeElno
	 */
	public String getBmeElno() {
		return this.bmeElno;
	}
	
	/**
	 * Column Info
	 * @return bkgActwgtTp
	 */
	public String getBkgActwgtTp() {
		return this.bkgActwgtTp;
	}
	
	/**
	 * Column Info
	 * @return bkgPkgCd
	 */
	public String getBkgPkgCd() {
		return this.bkgPkgCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPkgQty
	 */
	public String getBkgPkgQty() {
		return this.bkgPkgQty;
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
	 * @return cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
	}
	

	/**
	 * Column Info
	 * @param bkgActwgtQty
	 */
	public void setBkgActwgtQty(String bkgActwgtQty) {
		this.bkgActwgtQty = bkgActwgtQty;
	}
	
	/**
	 * Column Info
	 * @param prtLodgFlg
	 */
	public void setPrtLodgFlg(String prtLodgFlg) {
		this.prtLodgFlg = prtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
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
	 * @param ktSeq
	 */
	public void setKtSeq(String ktSeq) {
		this.ktSeq = ktSeq;
	}
	
	/**
	 * Column Info
	 * @param exptKdTp
	 */
	public void setExptKdTp(String exptKdTp) {
		this.exptKdTp = exptKdTp;
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
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @param bmeElno
	 */
	public void setBmeElno(String bmeElno) {
		this.bmeElno = bmeElno;
	}
	
	/**
	 * Column Info
	 * @param bkgActwgtTp
	 */
	public void setBkgActwgtTp(String bkgActwgtTp) {
		this.bkgActwgtTp = bkgActwgtTp;
	}
	
	/**
	 * Column Info
	 * @param bkgPkgCd
	 */
	public void setBkgPkgCd(String bkgPkgCd) {
		this.bkgPkgCd = bkgPkgCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPkgQty
	 */
	public void setBkgPkgQty(String bkgPkgQty) {
		this.bkgPkgQty = bkgPkgQty;
	}
	
	/**
	 * Column Info
	 * @param ktPort
	 */
	public void setKtPort(String ktPort) {
		this.ktPort = ktPort;
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
		setBkgActwgtQty(JSPUtil.getParameter(request, prefix + "bkg_actwgt_qty", ""));
		setPrtLodgFlg(JSPUtil.getParameter(request, prefix + "prt_lodg_flg", ""));
		setKcdTp(JSPUtil.getParameter(request, prefix + "kcd_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setKtSeq(JSPUtil.getParameter(request, prefix + "kt_seq", ""));
		setExptKdTp(JSPUtil.getParameter(request, prefix + "expt_kd_tp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsername(JSPUtil.getParameter(request, prefix + "username", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBmeElno(JSPUtil.getParameter(request, prefix + "bme_elno", ""));
		setBkgActwgtTp(JSPUtil.getParameter(request, prefix + "bkg_actwgt_tp", ""));
		setBkgPkgCd(JSPUtil.getParameter(request, prefix + "bkg_pkg_cd", ""));
		setBkgPkgQty(JSPUtil.getParameter(request, prefix + "bkg_pkg_qty", ""));
		setKtPort(JSPUtil.getParameter(request, prefix + "kt_port", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMailBoxVO[]
	 */
	public KorMailBoxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMailBoxVO[]
	 */
	public KorMailBoxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMailBoxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgActwgtQty = (JSPUtil.getParameter(request, prefix	+ "bkg_actwgt_qty", length));
			String[] prtLodgFlg = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_flg", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ktSeq = (JSPUtil.getParameter(request, prefix	+ "kt_seq", length));
			String[] exptKdTp = (JSPUtil.getParameter(request, prefix	+ "expt_kd_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bmeElno = (JSPUtil.getParameter(request, prefix	+ "bme_elno", length));
			String[] bkgActwgtTp = (JSPUtil.getParameter(request, prefix	+ "bkg_actwgt_tp", length));
			String[] bkgPkgCd = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_cd", length));
			String[] bkgPkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_pkg_qty", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMailBoxVO();
				if (bkgActwgtQty[i] != null)
					model.setBkgActwgtQty(bkgActwgtQty[i]);
				if (prtLodgFlg[i] != null)
					model.setPrtLodgFlg(prtLodgFlg[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ktSeq[i] != null)
					model.setKtSeq(ktSeq[i]);
				if (exptKdTp[i] != null)
					model.setExptKdTp(exptKdTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (username[i] != null)
					model.setUsername(username[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bmeElno[i] != null)
					model.setBmeElno(bmeElno[i]);
				if (bkgActwgtTp[i] != null)
					model.setBkgActwgtTp(bkgActwgtTp[i]);
				if (bkgPkgCd[i] != null)
					model.setBkgPkgCd(bkgPkgCd[i]);
				if (bkgPkgQty[i] != null)
					model.setBkgPkgQty(bkgPkgQty[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMailBoxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMailBoxVO[]
	 */
	public KorMailBoxVO[] getKorMailBoxVOs(){
		KorMailBoxVO[] vos = (KorMailBoxVO[])models.toArray(new KorMailBoxVO[models.size()]);
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
		this.bkgActwgtQty = this.bkgActwgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgFlg = this.prtLodgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktSeq = this.ktSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptKdTp = this.exptKdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bmeElno = this.bmeElno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgActwgtTp = this.bkgActwgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPkgCd = this.bkgPkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPkgQty = this.bkgPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
