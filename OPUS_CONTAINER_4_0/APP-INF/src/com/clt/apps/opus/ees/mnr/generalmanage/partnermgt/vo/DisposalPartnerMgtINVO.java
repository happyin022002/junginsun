/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalPartnerMgtINVO.java
*@FileTitle : DisposalPartnerMgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.12.21 권영법 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo;

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
 * @author 권영법
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPartnerMgtINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalPartnerMgtINVO> models = new ArrayList<DisposalPartnerMgtINVO>();
	
	/* Column Info */
	private String inMnrPrnrKndCd = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String fGubuns = null;
	/* Column Info */
	private String spPtalId = null;
	/* Column Info */
	private String inMnrPrnrStsCd = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String mnrPrnrTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String mnrPrnrCreSeq = null;
	/* Column Info */
	private String tocal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromcal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DisposalPartnerMgtINVO() {}

	public DisposalPartnerMgtINVO(String ibflag, String pagerows, String inMnrPrnrKndCd, String mnrGrpTpCd, String fGubuns, String inMnrPrnrStsCd, String mnrPrnrCntCd, String ctrlOfcCd, String mnrPrnrTpCd, String mnrPrnrSeq, String mnrPrnrCreSeq, String tocal, String fromcal, String spPtalId) {
		this.inMnrPrnrKndCd = inMnrPrnrKndCd;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.fGubuns = fGubuns;
		this.spPtalId = spPtalId;
		this.inMnrPrnrStsCd = inMnrPrnrStsCd;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.mnrPrnrTpCd = mnrPrnrTpCd;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.mnrPrnrCreSeq = mnrPrnrCreSeq;
		this.tocal = tocal;
		this.ibflag = ibflag;
		this.fromcal = fromcal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_mnr_prnr_knd_cd", getinMnrPrnrKndCd());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("f_gubuns", getFGubuns());
		this.hashColumns.put("sp_ptal_id", getSpPtalId());
		this.hashColumns.put("in_mnr_prnr_sts_cd", getMnrPrnrStsCd());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("mnr_prnr_tp_cd", getMnrPrnrTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("mnr_prnr_cre_seq", getMnrPrnrCreSeq());
		this.hashColumns.put("tocal", getTocal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fromcal", getFromcal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_mnr_prnr_knd_cd", "inMnrPrnrKndCd");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("f_gubuns", "fGubuns");
		this.hashFields.put("sp_ptal_id", "spPtalId");
		this.hashFields.put("in_mnr_prnr_sts_cd", "inMnrPrnrStsCd");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("mnr_prnr_tp_cd", "mnrPrnrTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("mnr_prnr_cre_seq", "mnrPrnrCreSeq");
		this.hashFields.put("tocal", "tocal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fromcal", "fromcal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inMnrPrnrKndCd
	 */
	public String getinMnrPrnrKndCd() {
		return this.inMnrPrnrKndCd;
	}
	
	/**
	 * Column Info
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return fGubuns
	 */
	public String getFGubuns() {
		return this.fGubuns;
	}
	
	/**
	 * Column Info
	 * @return spPtalId
	 */
	public String getSpPtalId() {
		return this.spPtalId;
	}
	
	/**
	 * Column Info
	 * @return inMnrPrnrStsCd
	 */
	public String getMnrPrnrStsCd() {
		return this.inMnrPrnrStsCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrTpCd
	 */
	public String getMnrPrnrTpCd() {
		return this.mnrPrnrTpCd;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCreSeq
	 */
	public String getMnrPrnrCreSeq() {
		return this.mnrPrnrCreSeq;
	}
	
	/**
	 * Column Info
	 * @return tocal
	 */
	public String getTocal() {
		return this.tocal;
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
	 * @return fromcal
	 */
	public String getFromcal() {
		return this.fromcal;
	}
	

	/**
	 * Column Info
	 * @param inMnrPrnrKndCd
	 */
	public void setinMnrPrnrKndCd(String inMnrPrnrKndCd) {
		this.inMnrPrnrKndCd = inMnrPrnrKndCd;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param fGubuns
	 */
	public void setFGubuns(String fGubuns) {
		this.fGubuns = fGubuns;
	}
	
	/**
	 * Column Info
	 * @param spPtalId
	 */
	public void setSpPtalId(String spPtalId) {
		this.spPtalId = spPtalId;
	}
	
	/**
	 * Column Info
	 * @param inMnrPrnrStsCd
	 */
	public void setMnrPrnrStsCd(String inMnrPrnrStsCd) {
		this.inMnrPrnrStsCd = inMnrPrnrStsCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrTpCd
	 */
	public void setMnrPrnrTpCd(String mnrPrnrTpCd) {
		this.mnrPrnrTpCd = mnrPrnrTpCd;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrCreSeq
	 */
	public void setMnrPrnrCreSeq(String mnrPrnrCreSeq) {
		this.mnrPrnrCreSeq = mnrPrnrCreSeq;
	}
	
	/**
	 * Column Info
	 * @param tocal
	 */
	public void setTocal(String tocal) {
		this.tocal = tocal;
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
	 * @param fromcal
	 */
	public void setFromcal(String fromcal) {
		this.fromcal = fromcal;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setinMnrPrnrKndCd(JSPUtil.getParameter(request, "in_mnr_prnr_knd_cd", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setFGubuns(JSPUtil.getParameter(request, "f_gubuns", ""));
		setSpPtalId(JSPUtil.getParameter(request, "sp_ptal_id", ""));
		setMnrPrnrStsCd(JSPUtil.getParameter(request, "in_mnr_prnr_sts_cd", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, "mnr_prnr_cnt_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setMnrPrnrTpCd(JSPUtil.getParameter(request, "mnr_prnr_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, "mnr_prnr_seq", ""));
		setMnrPrnrCreSeq(JSPUtil.getParameter(request, "mnr_prnr_cre_seq", ""));
		setTocal(JSPUtil.getParameter(request, "tocal", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFromcal(JSPUtil.getParameter(request, "fromcal", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPartnerMgtINVO[]
	 */
	public DisposalPartnerMgtINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalPartnerMgtINVO[]
	 */
	public DisposalPartnerMgtINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPartnerMgtINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inMnrPrnrKndCd = (JSPUtil.getParameter(request, prefix	+ "in_mnr_prnr_knd_cd", length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd", length));
			String[] fGubuns = (JSPUtil.getParameter(request, prefix	+ "f_gubuns", length));
			String[] spPtalId = (JSPUtil.getParameter(request, prefix	+ "sp_ptal_id", length));
			String[] inMnrPrnrStsCd = (JSPUtil.getParameter(request, prefix	+ "in_mnr_prnr_sts_cd", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] mnrPrnrTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] mnrPrnrCreSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cre_seq", length));
			String[] tocal = (JSPUtil.getParameter(request, prefix	+ "tocal", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromcal = (JSPUtil.getParameter(request, prefix	+ "fromcal", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalPartnerMgtINVO();
				if (inMnrPrnrKndCd[i] != null)
					model.setinMnrPrnrKndCd(inMnrPrnrKndCd[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (fGubuns[i] != null)
					model.setFGubuns(fGubuns[i]);
				if (spPtalId[i] != null)
					model.setSpPtalId(spPtalId[i]);
				if (inMnrPrnrStsCd[i] != null)
					model.setMnrPrnrStsCd(inMnrPrnrStsCd[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (mnrPrnrTpCd[i] != null)
					model.setMnrPrnrTpCd(mnrPrnrTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (mnrPrnrCreSeq[i] != null)
					model.setMnrPrnrCreSeq(mnrPrnrCreSeq[i]);
				if (tocal[i] != null)
					model.setTocal(tocal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromcal[i] != null)
					model.setFromcal(fromcal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPartnerMgtINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPartnerMgtINVO[]
	 */
	public DisposalPartnerMgtINVO[] getDisposalPartnerMgtINVOs(){
		DisposalPartnerMgtINVO[] vos = (DisposalPartnerMgtINVO[])models.toArray(new DisposalPartnerMgtINVO[models.size()]);
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
		this.inMnrPrnrKndCd = this.inMnrPrnrKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fGubuns = this.fGubuns .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spPtalId = this.spPtalId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inMnrPrnrStsCd = this.inMnrPrnrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrTpCd = this.mnrPrnrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCreSeq = this.mnrPrnrCreSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tocal = this.tocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromcal = this.fromcal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
