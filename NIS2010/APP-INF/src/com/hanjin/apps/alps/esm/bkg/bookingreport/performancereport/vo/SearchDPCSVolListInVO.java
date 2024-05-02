/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchDPCSVolListInVO.java
*@FileTitle : SearchDPCSVolListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.15 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchDPCSVolListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDPCSVolListInVO> models = new ArrayList<SearchDPCSVolListInVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String toMt = null;
	/* Column Info */
	private String picCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pfmByQueueCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String fromMt = null;
	/* Column Info */
	private String docPart = null;
	/* Column Info */
	private String docPartEu = null;
	/* Column Info */
	private String docPartJp = null;
	/* Column Info */
	private String docPartSw = null;
	/* Column Info */
	private String docPartOt = null;
	/* Column Info */
	private String docPartCn = null;
	/* Column Info */
	private String dpcsOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDPCSVolListInVO() {}

	public SearchDPCSVolListInVO(String ibflag, String pagerows, String fromDt, String toDt, String fromMt, String toMt, String vvdCd, String polCd, String podCd, String pfmByQueueCd, String srKndCd, String picCd, String bkgNo, String usrId, String docPart, String docPartEu, String docPartJp, String docPartSw, String docPartOt, String docPartCn, String dpcsOfcCd) {
		this.fromDt = fromDt;
		this.toMt = toMt;
		this.picCd = picCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.srKndCd = srKndCd;
		this.bkgNo = bkgNo;
		this.vvdCd = vvdCd;
		this.pfmByQueueCd = pfmByQueueCd;
		this.usrId = usrId;
		this.fromMt = fromMt;
		this.docPart = docPart;
		this.docPartEu = docPartEu;
		this.docPartJp = docPartJp;
		this.docPartSw = docPartSw;
		this.docPartOt = docPartOt;
		this.docPartCn = docPartCn;
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("to_mt", getToMt());
		this.hashColumns.put("pic_cd", getPicCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pfm_by_queue_cd", getPfmByQueueCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("from_mt", getFromMt());
		this.hashColumns.put("doc_part", getDocPart());
		this.hashColumns.put("doc_part_eu", getDocPartEu());
		this.hashColumns.put("doc_part_jp", getDocPartJp());
		this.hashColumns.put("doc_part_sw", getDocPartSw());
		this.hashColumns.put("doc_part_ot", getDocPartOt());
		this.hashColumns.put("doc_part_cn", getDocPartCn());
		this.hashColumns.put("dpcs_ofc_cd", getDpcsOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("to_mt", "toMt");
		this.hashFields.put("pic_cd", "picCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pfm_by_queue_cd", "pfmByQueueCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("from_mt", "fromMt");
		this.hashFields.put("doc_part", "docPart");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("doc_part_jp", "docPartJp");
		this.hashFields.put("doc_part_sw", "docPartSw");
		this.hashFields.put("doc_part_ot", "docPartOt");
		this.hashFields.put("doc_part_cn", "docPartCn");
		this.hashFields.put("dpcs_ofc_cd", "dpcsOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return toMt
	 */
	public String getToMt() {
		return this.toMt;
	}
	
	/**
	 * Column Info
	 * @return picCd
	 */
	public String getPicCd() {
		return this.picCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return pfmByQueueCd
	 */
	public String getPfmByQueueCd() {
		return this.pfmByQueueCd;
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
	 * @return fromMt
	 */
	public String getFromMt() {
		return this.fromMt;
	}
	/**
	 * Column Info
	 * @return docPart
	 */
	public String getDocPart() {
		return this.docPart;
	}
	
	/**
	 * Column Info
	 * @return docPartEu
	 */
	public String getDocPartEu() {
		return this.docPartEu;
	}
	
	/**
	 * Column Info
	 * @return docPartJp
	 */
	public String getDocPartJp() {
		return this.docPartJp;
	}
	
	/**
	 * Column Info
	 * @return docPartSw
	 */
	public String getDocPartSw() {
		return this.docPartSw;
	}
	
	/**
	 * Column Info
	 * @return docPartOt
	 */
	public String getDocPartOt() {
		return this.docPartOt;
	}
	
	/**
	 * Column Info
	 * @return docPartCn
	 */
	public String getDocPartCn() {
		return this.docPartCn;
	}
	
	/**
	 * Column Info
	 * @return dpcsOfcCd
	 */
	public String getDpcsOfcCd() {
		return this.dpcsOfcCd;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param toMt
	 */
	public void setToMt(String toMt) {
		this.toMt = toMt;
	}
	
	/**
	 * Column Info
	 * @param picCd
	 */
	public void setPicCd(String picCd) {
		this.picCd = picCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param pfmByQueueCd
	 */
	public void setPfmByQueueCd(String pfmByQueueCd) {
		this.pfmByQueueCd = pfmByQueueCd;
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
	 * @param fromMt
	 */
	public void setFromMt(String fromMt) {
		this.fromMt = fromMt;
	}
	/**
	 * Column Info
	 * @param docPart
	 */
	public void setDocPart(String docPart) {
		this.docPart = docPart;
	}
	
	/**
	 * Column Info
	 * @param docPartEu
	 */
	public void setDocPartEu(String docPartEu) {
		this.docPartEu = docPartEu;
	}
	
	/**
	 * Column Info
	 * @param docPartJp
	 */
	public void setDocPartJp(String docPartJp) {
		this.docPartJp = docPartJp;
	}
	
	/**
	 * Column Info
	 * @param docPartSw
	 */
	public void setDocPartSw(String docPartSw) {
		this.docPartSw = docPartSw;
	}
	
	/**
	 * Column Info
	 * @param docPartOt
	 */
	public void setDocPartOt(String docPartOt) {
		this.docPartOt = docPartOt;
	}
	
	/**
	 * Column Info
	 * @param docPartCn
	 */
	public void setDocPartCn(String docPartCn) {
		this.docPartCn = docPartCn;
	}
	
	/**
	 * Column Info
	 * @param dpcsOfcCd
	 */
	public void setDpcsOfcCd(String dpcsOfcCd) {
		this.dpcsOfcCd = dpcsOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setToMt(JSPUtil.getParameter(request, "to_mt", ""));
		setPicCd(JSPUtil.getParameter(request, "pic_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPfmByQueueCd(JSPUtil.getParameter(request, "pfm_by_queue_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setFromMt(JSPUtil.getParameter(request, "from_mt", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
		setDocPartOt(JSPUtil.getParameter(request, "doc_part_ot", ""));
		setDocPartCn(JSPUtil.getParameter(request, "doc_part_cn", ""));
		setDpcsOfcCd(JSPUtil.getParameter(request, "dpcs_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDPCSVolListInVO[]
	 */
	public SearchDPCSVolListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDPCSVolListInVO[]
	 */
	public SearchDPCSVolListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDPCSVolListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] toMt = (JSPUtil.getParameter(request, prefix	+ "to_mt", length));
			String[] picCd = (JSPUtil.getParameter(request, prefix	+ "pic_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pfmByQueueCd = (JSPUtil.getParameter(request, prefix	+ "pfm_by_queue_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] fromMt = (JSPUtil.getParameter(request, prefix	+ "from_mt", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			String[] docPartOt = (JSPUtil.getParameter(request, prefix	+ "doc_part_ot", length));
			String[] docPartCn = (JSPUtil.getParameter(request, prefix	+ "doc_part_cn", length));
			String[] dpcsOfcCd = (JSPUtil.getParameter(request, prefix	+ "dpcs_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDPCSVolListInVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (toMt[i] != null)
					model.setToMt(toMt[i]);
				if (picCd[i] != null)
					model.setPicCd(picCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pfmByQueueCd[i] != null)
					model.setPfmByQueueCd(pfmByQueueCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (fromMt[i] != null)
					model.setFromMt(fromMt[i]);
				if (docPart[i] != null)
					model.setDocPart(docPart[i]);
				if (docPartEu[i] != null)
					model.setDocPartEu(docPartEu[i]);
				if (docPartJp[i] != null)
					model.setDocPartJp(docPartJp[i]);
				if (docPartSw[i] != null)
					model.setDocPartSw(docPartSw[i]);
				if (docPartOt[i] != null)
					model.setDocPartOt(docPartOt[i]);
				if (docPartCn[i] != null)
					model.setDocPartCn(docPartCn[i]);
				if (dpcsOfcCd[i] != null)
					model.setDpcsOfcCd(dpcsOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDPCSVolListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDPCSVolListInVO[]
	 */
	public SearchDPCSVolListInVO[] getSearchDPCSVolListInVOs(){
		SearchDPCSVolListInVO[] vos = (SearchDPCSVolListInVO[])models.toArray(new SearchDPCSVolListInVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMt = this.toMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picCd = this.picCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmByQueueCd = this.pfmByQueueCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromMt = this.fromMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartOt = this.docPartOt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartCn = this.docPartCn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcsOfcCd = this.dpcsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
