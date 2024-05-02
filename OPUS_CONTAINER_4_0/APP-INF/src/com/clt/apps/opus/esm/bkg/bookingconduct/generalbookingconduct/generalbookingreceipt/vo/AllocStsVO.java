package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AllocStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AllocStsVO> models = new ArrayList<AllocStsVO>();
	
	/* Column Info */
	private String beforeAlocStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String alocSvcCd = null;
	/* Column Info */
	private String bkgAlocRmk = null;
	/* Column Info */
	private String alocStsCd = null;
	/* Column Info */
	private String bkgAlocTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String receiptNtcFlg = null;
	/* Page Number */
	private String standbyNtcFlg = null;
	/* Page Number */
	private String autoNotification = null;
	/* Page Number */
	private String docTpCd = null;
	/* Page Number */
	private String bkgCntcPsonEml = null;
	/* Page Number */
	private String siCntcPsonEml = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AllocStsVO() {}

	public AllocStsVO(String ibflag, String pagerows, String alocSvcCd, String bkgAlocRmk, String bkgAlocTpCd, String alocStsCd, String beforeAlocStsCd, String receiptNtcFlg, String standbyNtcFlg, String autoNotification, String docTpCd, String bkgCntcPsonEml,  String siCntcPsonEml) {
		this.beforeAlocStsCd = beforeAlocStsCd;
		this.ibflag = ibflag;
		this.alocSvcCd = alocSvcCd;
		this.bkgAlocRmk = bkgAlocRmk;
		this.alocStsCd = alocStsCd;
		this.bkgAlocTpCd = bkgAlocTpCd;
		this.pagerows = pagerows;
		this.receiptNtcFlg = receiptNtcFlg;
		this.standbyNtcFlg = standbyNtcFlg;
		this.autoNotification = autoNotification;
		this.docTpCd = docTpCd;
		this.bkgCntcPsonEml = bkgCntcPsonEml;
		this.siCntcPsonEml = siCntcPsonEml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("before_aloc_sts_cd", getBeforeAlocStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aloc_svc_cd", getAlocSvcCd());
		this.hashColumns.put("bkg_aloc_rmk", getBkgAlocRmk());
		this.hashColumns.put("aloc_sts_cd", getAlocStsCd());
		this.hashColumns.put("bkg_aloc_tp_cd", getBkgAlocTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("receipt_ntc_flg", getReceiptNtcFlg());
		this.hashColumns.put("standby_ntc_flg", getStandbyNtcFlg());
		this.hashColumns.put("auto_notification", getAutoNotification());
		this.hashColumns.put("doc_tp_cd", getDocTpCd());
		this.hashColumns.put("bkg_cntc_pson_eml", getBkgCntcPsonEml());
		this.hashColumns.put("si_cntc_pson_eml", getSiCntcPsonEml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("before_aloc_sts_cd", "beforeAlocStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aloc_svc_cd", "alocSvcCd");
		this.hashFields.put("bkg_aloc_rmk", "bkgAlocRmk");
		this.hashFields.put("aloc_sts_cd", "alocStsCd");
		this.hashFields.put("bkg_aloc_tp_cd", "bkgAlocTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("receipt_ntc_flg", "receiptNtcFlg");
		this.hashFields.put("standby_ntc_flg", "standbyNtcFlg");
		this.hashFields.put("auto_notification", "autoNotification");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("bkg_cntc_pson_eml", "bkgCntcPsonEml");
		this.hashFields.put("si_cntc_pson_eml", "siCntcPsonEml");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return beforeAlocStsCd
	 */
	public String getBeforeAlocStsCd() {
		return this.beforeAlocStsCd;
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
	 * @return alocSvcCd
	 */
	public String getAlocSvcCd() {
		return this.alocSvcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgAlocRmk
	 */
	public String getBkgAlocRmk() {
		return this.bkgAlocRmk;
	}
	
	/**
	 * Column Info
	 * @return alocStsCd
	 */
	public String getAlocStsCd() {
		return this.alocStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgAlocTpCd
	 */
	public String getBkgAlocTpCd() {
		return this.bkgAlocTpCd;
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
	 * @return receiptNtcFlg
	 */
	public String getReceiptNtcFlg() {
		return this.receiptNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return standbyNtcFlg
	 */
	public String getStandbyNtcFlg() {
		return this.standbyNtcFlg;
	}
	
	/**
	 * Column Info
	 * @return autoNotification
	 */
	public String getAutoNotification() {
		return this.autoNotification;
	}
	
	/**
	 * Column Info
	 * @return docTpCd
	 */
	public String getDocTpCd() {
		return this.docTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCntcPsonEml
	 */
	public String getBkgCntcPsonEml() {
		return this.bkgCntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @return siCntcPsonEml
	 */
	public String getSiCntcPsonEml() {
		return this.siCntcPsonEml;
	}

	/**
	 * Column Info
	 * @param beforeAlocStsCd
	 */
	public void setBeforeAlocStsCd(String beforeAlocStsCd) {
		this.beforeAlocStsCd = beforeAlocStsCd;
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
	 * @param alocSvcCd
	 */
	public void setAlocSvcCd(String alocSvcCd) {
		this.alocSvcCd = alocSvcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgAlocRmk
	 */
	public void setBkgAlocRmk(String bkgAlocRmk) {
		this.bkgAlocRmk = bkgAlocRmk;
	}
	
	/**
	 * Column Info
	 * @param alocStsCd
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgAlocTpCd
	 */
	public void setBkgAlocTpCd(String bkgAlocTpCd) {
		this.bkgAlocTpCd = bkgAlocTpCd;
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
	 * @param receiptNtcFlg
	 */
	public void setReceiptNtcFlg(String receiptNtcFlg) {
		this.receiptNtcFlg = receiptNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param standbyNtcFlg
	 */
	public void setStandbyNtcFlg(String standbyNtcFlg) {
		this.standbyNtcFlg = standbyNtcFlg;
	}
	
	/**
	 * Column Info
	 * @param autoNotification
	 */
	public void setAutoNotification(String autoNotification) {
		this.autoNotification = autoNotification;
	}
	
	/**
	 * Column Info
	 * @param docTpCd
	 */
	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCntcPsonEml
	 */
	public void setBkgCntcPsonEml(String bkgCntcPsonEml) {
		this.bkgCntcPsonEml = bkgCntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @param siCntcPsonEml
	 */
	public void setSiCntcPsonEml(String siCntcPsonEml) {
		this.siCntcPsonEml = siCntcPsonEml;
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
		setBeforeAlocStsCd(JSPUtil.getParameter(request, prefix + "before_aloc_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAlocSvcCd(JSPUtil.getParameter(request, prefix + "aloc_svc_cd", ""));
		setBkgAlocRmk(JSPUtil.getParameter(request, prefix + "bkg_aloc_rmk", ""));
		setAlocStsCd(JSPUtil.getParameter(request, prefix + "aloc_sts_cd", ""));
		setBkgAlocTpCd(JSPUtil.getParameter(request, prefix + "bkg_aloc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setReceiptNtcFlg(JSPUtil.getParameter(request, prefix + "receipt_ntc_flg", ""));
		setStandbyNtcFlg(JSPUtil.getParameter(request, prefix + "standby_ntc_flg", ""));
		setAutoNotification(JSPUtil.getParameter(request, prefix + "auto_notification", ""));
		setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
		setBkgCntcPsonEml(JSPUtil.getParameter(request, prefix + "bkg_cntc_pson_eml", ""));
		setSiCntcPsonEml(JSPUtil.getParameter(request, prefix + "si_cntc_pson_eml", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AllocStsVO[]
	 */
	public AllocStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AllocStsVO[]
	 */
	public AllocStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AllocStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] beforeAlocStsCd = (JSPUtil.getParameter(request, prefix	+ "before_aloc_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alocSvcCd = (JSPUtil.getParameter(request, prefix	+ "aloc_svc_cd", length));
			String[] bkgAlocRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_rmk", length));
			String[] alocStsCd = (JSPUtil.getParameter(request, prefix	+ "aloc_sts_cd", length));
			String[] bkgAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_aloc_tp_cd", length));
			String[] receiptNtcFlg = (JSPUtil.getParameter(request, prefix	+ "receipt_ntc_flg", length));
			String[] standbyNtcFlg = (JSPUtil.getParameter(request, prefix	+ "standby_ntc_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] autoNotification = (JSPUtil.getParameter(request, prefix	+ "auto_notification", length));
			String[] docTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_tp_cd", length));
			String[] bkgCntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "bkg_cntc_pson_eml", length));
			String[] siCntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "si_cntc_pson_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new AllocStsVO();
				if (beforeAlocStsCd[i] != null)
					model.setBeforeAlocStsCd(beforeAlocStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alocSvcCd[i] != null)
					model.setAlocSvcCd(alocSvcCd[i]);
				if (bkgAlocRmk[i] != null)
					model.setBkgAlocRmk(bkgAlocRmk[i]);
				if (alocStsCd[i] != null)
					model.setAlocStsCd(alocStsCd[i]);
				if (bkgAlocTpCd[i] != null)
					model.setBkgAlocTpCd(bkgAlocTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (receiptNtcFlg[i] != null)
					model.setReceiptNtcFlg(receiptNtcFlg[i]);
				if (standbyNtcFlg[i] != null)
					model.setStandbyNtcFlg(standbyNtcFlg[i]);
				if (autoNotification[i] != null)
					model.setAutoNotification(autoNotification[i]);
				if (docTpCd[i] != null)
					model.setDocTpCd(docTpCd[i]);
				if (bkgCntcPsonEml[i] != null)
					model.setBkgCntcPsonEml(bkgCntcPsonEml[i]);
				if (siCntcPsonEml[i] != null)
					model.setSiCntcPsonEml(siCntcPsonEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAllocStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AllocStsVO[]
	 */
	public AllocStsVO[] getAllocStsVOs(){
		AllocStsVO[] vos = (AllocStsVO[])models.toArray(new AllocStsVO[models.size()]);
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
		this.beforeAlocStsCd = this.beforeAlocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocSvcCd = this.alocSvcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocRmk = this.bkgAlocRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocStsCd = this.alocStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAlocTpCd = this.bkgAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiptNtcFlg = this.receiptNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standbyNtcFlg = this.standbyNtcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoNotification = this.autoNotification .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd = this.docTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntcPsonEml = this.bkgCntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siCntcPsonEml = this.siCntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
