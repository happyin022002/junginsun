/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectEdiInstrVO.java
*@FileTitle : RejectEdiInstrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.05 전용진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RejectEdiInstrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RejectEdiInstrVO> models = new ArrayList<RejectEdiInstrVO>();
	
	/* Column Info */
	private String cntrtsCd = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String rqstArrDt = null;
	/* Column Info */
	private String ibEdiId = null;
	/* Column Info */
	private String ibEdiOrgId = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String porCtnt = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String ibPodCd = null;
	/* Column Info */
	private String rqstDepDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String trnsIndCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String porNm = null;
	/* Column Info */
	private String podCtnt = null;
	/* Column Info */
	private String polCtnt = null;
	/* Column Info */
	private String ibPolCd = null;
	/* Column Info */
	private String delCtnt = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String mtyPkupDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RejectEdiInstrVO() {}

	public RejectEdiInstrVO(String ibflag, String pagerows, String xterRqstNo, String xterSndrId, String polCd, String podCd, String rqstDepDt, String mtyPkupDt, String rqstArrDt, String cntrtsCd, String porCtnt, String porNm, String polCtnt, String polNm, String podCtnt, String podNm, String delCtnt, String delNm, String trnsIndCtnt, String ibEdiOrgId, String ibEdiId, String ibPolCd, String ibPodCd) {
		this.cntrtsCd = cntrtsCd;
		this.xterSndrId = xterSndrId;
		this.podNm = podNm;
		this.rqstArrDt = rqstArrDt;
		this.ibEdiId = ibEdiId;
		this.ibEdiOrgId = ibEdiOrgId;
		this.delNm = delNm;
		this.porCtnt = porCtnt;
		this.polNm = polNm;
		this.ibPodCd = ibPodCd;
		this.rqstDepDt = rqstDepDt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.trnsIndCtnt = trnsIndCtnt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.porNm = porNm;
		this.podCtnt = podCtnt;
		this.polCtnt = polCtnt;
		this.ibPolCd = ibPolCd;
		this.delCtnt = delCtnt;
		this.xterRqstNo = xterRqstNo;
		this.mtyPkupDt = mtyPkupDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntrts_cd", getCntrtsCd());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("rqst_arr_dt", getRqstArrDt());
		this.hashColumns.put("ib_edi_id", getIbEdiId());
		this.hashColumns.put("ib_edi_org_id", getIbEdiOrgId());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("por_ctnt", getPorCtnt());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("ib_pod_cd", getIbPodCd());
		this.hashColumns.put("rqst_dep_dt", getRqstDepDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("trns_ind_ctnt", getTrnsIndCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("por_nm", getPorNm());
		this.hashColumns.put("pod_ctnt", getPodCtnt());
		this.hashColumns.put("pol_ctnt", getPolCtnt());
		this.hashColumns.put("ib_pol_cd", getIbPolCd());
		this.hashColumns.put("del_ctnt", getDelCtnt());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntrts_cd", "cntrtsCd");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("rqst_arr_dt", "rqstArrDt");
		this.hashFields.put("ib_edi_id", "ibEdiId");
		this.hashFields.put("ib_edi_org_id", "ibEdiOrgId");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("por_ctnt", "porCtnt");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("ib_pod_cd", "ibPodCd");
		this.hashFields.put("rqst_dep_dt", "rqstDepDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("trns_ind_ctnt", "trnsIndCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("por_nm", "porNm");
		this.hashFields.put("pod_ctnt", "podCtnt");
		this.hashFields.put("pol_ctnt", "polCtnt");
		this.hashFields.put("ib_pol_cd", "ibPolCd");
		this.hashFields.put("del_ctnt", "delCtnt");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrtsCd
	 */
	public String getCntrtsCd() {
		return this.cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return rqstArrDt
	 */
	public String getRqstArrDt() {
		return this.rqstArrDt;
	}
	
	/**
	 * Column Info
	 * @return ibEdiId
	 */
	public String getIbEdiId() {
		return this.ibEdiId;
	}
	
	/**
	 * Column Info
	 * @return ibEdiOrgId
	 */
	public String getIbEdiOrgId() {
		return this.ibEdiOrgId;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return porCtnt
	 */
	public String getPorCtnt() {
		return this.porCtnt;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return ibPodCd
	 */
	public String getIbPodCd() {
		return this.ibPodCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDepDt
	 */
	public String getRqstDepDt() {
		return this.rqstDepDt;
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
	 * Column Info
	 * @return trnsIndCtnt
	 */
	public String getTrnsIndCtnt() {
		return this.trnsIndCtnt;
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
	 * @return porNm
	 */
	public String getPorNm() {
		return this.porNm;
	}
	
	/**
	 * Column Info
	 * @return podCtnt
	 */
	public String getPodCtnt() {
		return this.podCtnt;
	}
	
	/**
	 * Column Info
	 * @return polCtnt
	 */
	public String getPolCtnt() {
		return this.polCtnt;
	}
	
	/**
	 * Column Info
	 * @return ibPolCd
	 */
	public String getIbPolCd() {
		return this.ibPolCd;
	}
	
	/**
	 * Column Info
	 * @return delCtnt
	 */
	public String getDelCtnt() {
		return this.delCtnt;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupDt
	 */
	public String getMtyPkupDt() {
		return this.mtyPkupDt;
	}
	

	/**
	 * Column Info
	 * @param cntrtsCd
	 */
	public void setCntrtsCd(String cntrtsCd) {
		this.cntrtsCd = cntrtsCd;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param rqstArrDt
	 */
	public void setRqstArrDt(String rqstArrDt) {
		this.rqstArrDt = rqstArrDt;
	}
	
	/**
	 * Column Info
	 * @param ibEdiId
	 */
	public void setIbEdiId(String ibEdiId) {
		this.ibEdiId = ibEdiId;
	}
	
	/**
	 * Column Info
	 * @param ibEdiOrgId
	 */
	public void setIbEdiOrgId(String ibEdiOrgId) {
		this.ibEdiOrgId = ibEdiOrgId;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param porCtnt
	 */
	public void setPorCtnt(String porCtnt) {
		this.porCtnt = porCtnt;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param ibPodCd
	 */
	public void setIbPodCd(String ibPodCd) {
		this.ibPodCd = ibPodCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDepDt
	 */
	public void setRqstDepDt(String rqstDepDt) {
		this.rqstDepDt = rqstDepDt;
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
	 * Column Info
	 * @param trnsIndCtnt
	 */
	public void setTrnsIndCtnt(String trnsIndCtnt) {
		this.trnsIndCtnt = trnsIndCtnt;
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
	 * @param porNm
	 */
	public void setPorNm(String porNm) {
		this.porNm = porNm;
	}
	
	/**
	 * Column Info
	 * @param podCtnt
	 */
	public void setPodCtnt(String podCtnt) {
		this.podCtnt = podCtnt;
	}
	
	/**
	 * Column Info
	 * @param polCtnt
	 */
	public void setPolCtnt(String polCtnt) {
		this.polCtnt = polCtnt;
	}
	
	/**
	 * Column Info
	 * @param ibPolCd
	 */
	public void setIbPolCd(String ibPolCd) {
		this.ibPolCd = ibPolCd;
	}
	
	/**
	 * Column Info
	 * @param delCtnt
	 */
	public void setDelCtnt(String delCtnt) {
		this.delCtnt = delCtnt;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupDt
	 */
	public void setMtyPkupDt(String mtyPkupDt) {
		this.mtyPkupDt = mtyPkupDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrtsCd(JSPUtil.getParameter(request, "cntrts_cd", ""));
		setXterSndrId(JSPUtil.getParameter(request, "xter_sndr_id", ""));
		setPodNm(JSPUtil.getParameter(request, "pod_nm", ""));
		setRqstArrDt(JSPUtil.getParameter(request, "rqst_arr_dt", ""));
		setIbEdiId(JSPUtil.getParameter(request, "ib_edi_id", ""));
		setIbEdiOrgId(JSPUtil.getParameter(request, "ib_edi_org_id", ""));
		setDelNm(JSPUtil.getParameter(request, "del_nm", ""));
		setPorCtnt(JSPUtil.getParameter(request, "por_ctnt", ""));
		setPolNm(JSPUtil.getParameter(request, "pol_nm", ""));
		setIbPodCd(JSPUtil.getParameter(request, "ib_pod_cd", ""));
		setRqstDepDt(JSPUtil.getParameter(request, "rqst_dep_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTrnsIndCtnt(JSPUtil.getParameter(request, "trns_ind_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPorNm(JSPUtil.getParameter(request, "por_nm", ""));
		setPodCtnt(JSPUtil.getParameter(request, "pod_ctnt", ""));
		setPolCtnt(JSPUtil.getParameter(request, "pol_ctnt", ""));
		setIbPolCd(JSPUtil.getParameter(request, "ib_pol_cd", ""));
		setDelCtnt(JSPUtil.getParameter(request, "del_ctnt", ""));
		setXterRqstNo(JSPUtil.getParameter(request, "xter_rqst_no", ""));
		setMtyPkupDt(JSPUtil.getParameter(request, "mty_pkup_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectEdiInstrVO[]
	 */
	public RejectEdiInstrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectEdiInstrVO[]
	 */
	public RejectEdiInstrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RejectEdiInstrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrtsCd = (JSPUtil.getParameter(request, prefix	+ "cntrts_cd", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] rqstArrDt = (JSPUtil.getParameter(request, prefix	+ "rqst_arr_dt", length));
			String[] ibEdiId = (JSPUtil.getParameter(request, prefix	+ "ib_edi_id", length));
			String[] ibEdiOrgId = (JSPUtil.getParameter(request, prefix	+ "ib_edi_org_id", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] porCtnt = (JSPUtil.getParameter(request, prefix	+ "por_ctnt", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] ibPodCd = (JSPUtil.getParameter(request, prefix	+ "ib_pod_cd", length));
			String[] rqstDepDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dep_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] trnsIndCtnt = (JSPUtil.getParameter(request, prefix	+ "trns_ind_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] porNm = (JSPUtil.getParameter(request, prefix	+ "por_nm", length));
			String[] podCtnt = (JSPUtil.getParameter(request, prefix	+ "pod_ctnt", length));
			String[] polCtnt = (JSPUtil.getParameter(request, prefix	+ "pol_ctnt", length));
			String[] ibPolCd = (JSPUtil.getParameter(request, prefix	+ "ib_pol_cd", length));
			String[] delCtnt = (JSPUtil.getParameter(request, prefix	+ "del_ctnt", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RejectEdiInstrVO();
				if (cntrtsCd[i] != null)
					model.setCntrtsCd(cntrtsCd[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (rqstArrDt[i] != null)
					model.setRqstArrDt(rqstArrDt[i]);
				if (ibEdiId[i] != null)
					model.setIbEdiId(ibEdiId[i]);
				if (ibEdiOrgId[i] != null)
					model.setIbEdiOrgId(ibEdiOrgId[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (porCtnt[i] != null)
					model.setPorCtnt(porCtnt[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (ibPodCd[i] != null)
					model.setIbPodCd(ibPodCd[i]);
				if (rqstDepDt[i] != null)
					model.setRqstDepDt(rqstDepDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (trnsIndCtnt[i] != null)
					model.setTrnsIndCtnt(trnsIndCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (porNm[i] != null)
					model.setPorNm(porNm[i]);
				if (podCtnt[i] != null)
					model.setPodCtnt(podCtnt[i]);
				if (polCtnt[i] != null)
					model.setPolCtnt(polCtnt[i]);
				if (ibPolCd[i] != null)
					model.setIbPolCd(ibPolCd[i]);
				if (delCtnt[i] != null)
					model.setDelCtnt(delCtnt[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (mtyPkupDt[i] != null)
					model.setMtyPkupDt(mtyPkupDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRejectEdiInstrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RejectEdiInstrVO[]
	 */
	public RejectEdiInstrVO[] getRejectEdiInstrVOs(){
		RejectEdiInstrVO[] vos = (RejectEdiInstrVO[])models.toArray(new RejectEdiInstrVO[models.size()]);
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
		this.cntrtsCd = this.cntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstArrDt = this.rqstArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEdiId = this.ibEdiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEdiOrgId = this.ibEdiOrgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCtnt = this.porCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPodCd = this.ibPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDepDt = this.rqstDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsIndCtnt = this.trnsIndCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNm = this.porNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCtnt = this.podCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCtnt = this.polCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPolCd = this.ibPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCtnt = this.delCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupDt = this.mtyPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
