/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgCustAvcNtcSndHisSchVO.java
*@FileTitle : BkgCustAvcNtcSndHisSchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCustAvcNtcSndHisSchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCustAvcNtcSndHisSchVO> models = new ArrayList<BkgCustAvcNtcSndHisSchVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String eDirCd = null;
	/* Column Info */
	private String wDirCd = null;
	/* Column Info */
	private String sDirCd = null;
	/* Column Info */
	private String nDirCd = null;
	/* Column Info */
	private String dirStsCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String sntOfcCd = null;
	/* Column Info */
	private String srcDatTpCd = null;
	
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCustAvcNtcSndHisSchVO() {}

	public BkgCustAvcNtcSndHisSchVO(String ibflag, String vvd, String eDirCd, String wDirCd, String dirStsCd, String polCd, String podCd, String delCd, String custCntCd, String custSeq, String bkgCustTpCd, String sntOfcCd, String srcDatTpCd, String sDirCd, String nDirCd) {
		this.vvd = vvd;
		this.eDirCd = eDirCd;
		this.wDirCd = wDirCd;
		this.dirStsCd = dirStsCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.delCd = delCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.bkgCustTpCd = bkgCustTpCd;
		this.sntOfcCd = sntOfcCd;
		this.ibflag = ibflag;
		this.srcDatTpCd = srcDatTpCd;
		this.sDirCd = sDirCd;
		this.nDirCd = nDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("e_dir_cd", getEDirCd());
		this.hashColumns.put("w_dir_cd", getWDirCd());
		this.hashColumns.put("dir_sts_cd", getDirStsCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("snt_ofc_cd", getSntOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("src_dat_tp_cd", getSrcDatTpCd());
		this.hashColumns.put("s_dir_cd", getSDirCd());
		this.hashColumns.put("n_dir_cd", getNDirCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("e_dir_cd", "eDirCd");
		this.hashFields.put("w_dir_cd", "wDirCd");
		this.hashFields.put("dir_sts_cd", "dirStsCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("snt_ofc_cd", "sntOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("src_dat_tp_cd", "srcDatTpCd");
		this.hashFields.put("s_dir_cd", "sDirCd");
		this.hashFields.put("n_dir_cd", "nDirCd");
		return this.hashFields;
	}
	
public Collection<BkgCustAvcNtcSndHisSchVO> getModels() {
		return models;
	}

	public void setModels(Collection<BkgCustAvcNtcSndHisSchVO> models) {
		this.models = models;
	}

	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	public String getEDirCd() {
		return eDirCd;
	}

	public void setEDirCd(String eDirCd) {
		this.eDirCd = eDirCd;
	}
	
	public String getWDirCd() {
		return wDirCd;
	}

	public void setWDirCd(String wDirCd) {
		this.wDirCd = wDirCd;
	}
	
	public String getSDirCd() {
		return sDirCd;
	}

	public void setSDirCd(String sDirCd) {
		this.sDirCd = sDirCd;
	}
	
	public String getNDirCd() {
		return nDirCd;
	}

	public void setNDirCd(String nDirCd) {
		this.nDirCd = nDirCd;
	}
	
	public String getDirStsCd() {
		return dirStsCd;
	}

	public void setDirStsCd(String dirStsCd) {
		this.dirStsCd = dirStsCd;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getPodCd() {
		return podCd;
	}
	
	public String getSntOfcCd() {
		return sntOfcCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getDelCd() {
		return delCd;
	}

	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getBkgCustTpCd() {
		return bkgCustTpCd;
	}

	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	public void setSntOfcCd(String sntOfcCd) {
		this.sntOfcCd = sntOfcCd;
	}

	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @return srcDatTpCd
	 */
	public String getSrcDatTpCd() {
		return this.srcDatTpCd;
	}
	
	/**
	 * Column Info
	 * @param srcDatTpCd
	 */
	public void setSrcDatTpCd(String srcDatTpCd) {
		this.srcDatTpCd = srcDatTpCd;
	}
	

	public HashMap<String, String> getHashColumns() {
		return hashColumns;
	}

	public void setHashColumns(HashMap<String, String> hashColumns) {
		this.hashColumns = hashColumns;
	}

	public HashMap<String, String> getHashFields() {
		return hashFields;
	}

	public void setHashFields(HashMap<String, String> hashFields) {
		this.hashFields = hashFields;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setEDirCd(JSPUtil.getParameter(request, prefix + "e_dir_cd", ""));
		setWDirCd(JSPUtil.getParameter(request, prefix + "w_dir_cd", ""));
		setDirStsCd(JSPUtil.getParameter(request, prefix + "dir_sts_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", ""));
		setSntOfcCd(JSPUtil.getParameter(request, prefix + "snt_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrcDatTpCd(JSPUtil.getParameter(request, prefix + "src_dat_tp_cd", ""));
		setSDirCd(JSPUtil.getParameter(request, prefix + "s_dir_cd", ""));
		setNDirCd(JSPUtil.getParameter(request, prefix + "n_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCustAvcNtcSndHisSchVO[]
	 */
	public BkgCustAvcNtcSndHisSchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCustAvcNtcSndHisSchVO[]
	 */
	public BkgCustAvcNtcSndHisSchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCustAvcNtcSndHisSchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] eDirCd = (JSPUtil.getParameter(request, prefix	+ "e_dir_cd", length));
			String[] wDirCd = (JSPUtil.getParameter(request, prefix	+ "w_dir_cd", length));
			String[] sDirCd = (JSPUtil.getParameter(request, prefix	+ "s_dir_cd", length));
			String[] nDirCd = (JSPUtil.getParameter(request, prefix	+ "n_dir_cd", length));
			String[] dirStsCd = (JSPUtil.getParameter(request, prefix	+ "dir_sts_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd", length));
			String[] sntOfcCd = (JSPUtil.getParameter(request, prefix	+ "snt_ofc_cd", length));
			String[] srcDatTpCd = (JSPUtil.getParameter(request, prefix	+ "src_dat_tp_cd", length));

			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCustAvcNtcSndHisSchVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (eDirCd[i] != null)
					model.setEDirCd(eDirCd[i]);
				if (wDirCd[i] != null)
					model.setWDirCd(wDirCd[i]);
				if (sDirCd[i] != null)
					model.setSDirCd(sDirCd[i]);
				if (nDirCd[i] != null)
					model.setNDirCd(nDirCd[i]);
				if (dirStsCd[i] != null)
					model.setDirStsCd(dirStsCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (sntOfcCd[i] != null)
					model.setSntOfcCd(sntOfcCd[i]);
				if (srcDatTpCd[i] != null)
					model.setSrcDatTpCd(srcDatTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCustAvcNtcSndHisSchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCustAvcNtcSndHisSchVO[]
	 */
	public BkgCustAvcNtcSndHisSchVO[] getBkgCustAvcNtcSndHisSchVOs(){
		BkgCustAvcNtcSndHisSchVO[] vos = (BkgCustAvcNtcSndHisSchVO[])models.toArray(new BkgCustAvcNtcSndHisSchVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eDirCd = this.eDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wDirCd = this.wDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirStsCd = this.dirStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntOfcCd = this.sntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcDatTpCd = this.srcDatTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDirCd = this.sDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nDirCd = this.nDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
