/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VgmHistoryVO.java
*@FileTitle : VgmHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VgmHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VgmHistoryVO> models = new ArrayList<VgmHistoryVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vgmWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vgmSeq = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String esigCoNm = null;
	/* Column Info */
	private String vgmCreLoclDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ifFlg = null;
	/* Column Info */
	private String clzFlg = null;
	/* Column Info */
	private String vgmCreGloDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VgmHistoryVO() {}

	public VgmHistoryVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String vgmSeq, String vgmWgt, String wgtUtCd, String esigCoNm, String usrId, String vgmCreLoclDt, String ifFlg, String clzFlg, String vgmCreGloDt) {
		this.pagerows = pagerows;
		this.vgmWgt = vgmWgt;
		this.ibflag = ibflag;
		this.wgtUtCd = wgtUtCd;
		this.bkgNo = bkgNo;
		this.vgmSeq = vgmSeq;
		this.usrId = usrId;
		this.esigCoNm = esigCoNm;
		this.vgmCreLoclDt = vgmCreLoclDt;
		this.cntrNo = cntrNo;
		this.ifFlg = ifFlg;
		this.clzFlg = clzFlg;
		this.vgmCreGloDt = vgmCreGloDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vgm_seq", getVgmSeq());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("esig_co_nm", getEsigCoNm());
		this.hashColumns.put("vgm_cre_locl_dt", getVgmCreLoclDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("if_flg", getIfFlg());
		this.hashColumns.put("clz_flg", getClzFlg());
		this.hashColumns.put("vgm_cre_glo_dt", getVgmCreGloDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vgm_seq", "vgmSeq");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("esig_co_nm", "esigCoNm");
		this.hashFields.put("vgm_cre_locl_dt", "vgmCreLoclDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("if_flg", "ifFlg");
		this.hashFields.put("clz_flg", "clzFlg");
		this.hashFields.put("vgm_cre_glo_dt", "vgmCreGloDt");
		return this.hashFields;
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
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return vgmSeq
	 */
	public String getVgmSeq() {
		return this.vgmSeq;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return esigCoNm
	 */
	public String getEsigCoNm() {
		return this.esigCoNm;
	}
	
	/**
	 * Column Info
	 * @return vgmCreLoclDt
	 */
	public String getVgmCreLoclDt() {
		return this.vgmCreLoclDt;
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
	 * @return ifFlg
	 */
	public String getIfFlg() {
		return this.ifFlg;
	}
	
	/**
	 * Column Info
	 * @return clzFlg
	 */
	public String getClzFlg() {
		return this.clzFlg;
	}
	
	/**
	 * Column Info
	 * @return vgmCreGloDt
	 */
	public String getVgmCreGloDt() {
		return this.vgmCreGloDt;
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
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param vgmSeq
	 */
	public void setVgmSeq(String vgmSeq) {
		this.vgmSeq = vgmSeq;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param esigCoNm
	 */
	public void setEsigCoNm(String esigCoNm) {
		this.esigCoNm = esigCoNm;
	}
	
	/**
	 * Column Info
	 * @param vgmCreLoclDt
	 */
	public void setVgmCreLoclDt(String vgmCreLoclDt) {
		this.vgmCreLoclDt = vgmCreLoclDt;
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
	 * @param ifFlg
	 */
	public void setIfFlg(String ifFlg) {
		this.ifFlg = ifFlg;
	}
	
	/**
	 * Column Info
	 * @param clzFlg
	 */
	public void setClzFlg(String clzFlg) {
		this.clzFlg = clzFlg;
	}
	
	/**
	 * Column Info
	 * @param vgmCreGloDt
	 */
	public void setVgmCreGloDt(String vgmCreGloDt) {
		this.vgmCreGloDt = vgmCreGloDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVgmSeq(JSPUtil.getParameter(request, prefix + "vgm_seq", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setEsigCoNm(JSPUtil.getParameter(request, prefix + "esig_co_nm", ""));
		setVgmCreLoclDt(JSPUtil.getParameter(request, prefix + "vgm_cre_locl_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setIfFlg(JSPUtil.getParameter(request, prefix + "if_flg", ""));
		setClzFlg(JSPUtil.getParameter(request, prefix + "clz_flg", ""));
		setVgmCreGloDt(JSPUtil.getParameter(request, prefix + "vgm_cre_glo_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VgmHistoryVO[]
	 */
	public VgmHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VgmHistoryVO[]
	 */
	public VgmHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VgmHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vgmSeq = (JSPUtil.getParameter(request, prefix	+ "vgm_seq", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] esigCoNm = (JSPUtil.getParameter(request, prefix	+ "esig_co_nm", length));
			String[] vgmCreLoclDt = (JSPUtil.getParameter(request, prefix	+ "vgm_cre_locl_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ifFlg = (JSPUtil.getParameter(request, prefix	+ "if_flg", length));
			String[] clzFlg = (JSPUtil.getParameter(request, prefix	+ "clz_flg", length));
			String[] vgmCreGloDt = (JSPUtil.getParameter(request, prefix	+ "vgm_cre_glo_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new VgmHistoryVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vgmSeq[i] != null)
					model.setVgmSeq(vgmSeq[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (esigCoNm[i] != null)
					model.setEsigCoNm(esigCoNm[i]);
				if (vgmCreLoclDt[i] != null)
					model.setVgmCreLoclDt(vgmCreLoclDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ifFlg[i] != null)
					model.setIfFlg(ifFlg[i]);
				if (clzFlg[i] != null)
					model.setClzFlg(clzFlg[i]);
				if (vgmCreGloDt[i] != null)
					model.setVgmCreGloDt(vgmCreGloDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVgmHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VgmHistoryVO[]
	 */
	public VgmHistoryVO[] getVgmHistoryVOs(){
		VgmHistoryVO[] vos = (VgmHistoryVO[])models.toArray(new VgmHistoryVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSeq = this.vgmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esigCoNm = this.esigCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCreLoclDt = this.vgmCreLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlg = this.ifFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzFlg = this.clzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCreGloDt = this.vgmCreGloDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
