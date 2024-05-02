/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocTurnTimeInVO.java
*@FileTitle : DocTurnTimeInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.25 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocTurnTimeInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocTurnTimeInVO> models = new ArrayList<DocTurnTimeInVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String periodFromDt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pfmByQueueCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pfmByPic = null;
	/* Column Info */
	private String periodToDt = null;
	/* Column Info */
	private String docPart = null;
	/* Column Info */
	private String docPartEu = null;
	/* Column Info */
	private String docPartJp = null;
	/* Column Info */
	private String docPartSw = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocTurnTimeInVO() {}

	public DocTurnTimeInVO(String ibflag, String pagerows, String usrId, String periodFromDt, String periodToDt, String vvdCd, String bkgNo, String polCd, String podCd, String pfmByQueueCd, String pfmByPic, String bkgOfcCd, String srKndCd, String docPart, String docPartEu, String docPartJp, String docPartSw) {
		this.bkgOfcCd = bkgOfcCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.srKndCd = srKndCd;
		this.periodFromDt = periodFromDt;
		this.vvdCd = vvdCd;
		this.pfmByQueueCd = pfmByQueueCd;
		this.usrId = usrId;
		this.pfmByPic = pfmByPic;
		this.periodToDt = periodToDt;
		this.docPart = docPart;
		this.docPartEu = docPartEu;
		this.docPartJp = docPartJp;
		this.docPartSw = docPartSw;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("period_from_dt", getPeriodFromDt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pfm_by_queue_cd", getPfmByQueueCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pfm_by_pic", getPfmByPic());
		this.hashColumns.put("period_to_dt", getPeriodToDt());
		this.hashColumns.put("doc_part", getDocPart());
		this.hashColumns.put("doc_part_eu", getDocPartEu());
		this.hashColumns.put("doc_part_jp", getDocPartJp());
		this.hashColumns.put("doc_part_sw", getDocPartSw());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("period_from_dt", "periodFromDt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pfm_by_queue_cd", "pfmByQueueCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pfm_by_pic", "pfmByPic");
		this.hashFields.put("period_to_dt", "periodToDt");
		this.hashFields.put("doc_part", "docPart");
		this.hashFields.put("doc_part_eu", "docPartEu");
		this.hashFields.put("doc_part_jp", "docPartJp");
		this.hashFields.put("doc_part_sw", "docPartSw");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return periodFromDt
	 */
	public String getPeriodFromDt() {
		return this.periodFromDt;
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
	 * @return pfmByPic
	 */
	public String getPfmByPic() {
		return this.pfmByPic;
	}
	
	/**
	 * Column Info
	 * @return periodToDt
	 */
	public String getPeriodToDt() {
		return this.periodToDt;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param periodFromDt
	 */
	public void setPeriodFromDt(String periodFromDt) {
		this.periodFromDt = periodFromDt;
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
	 * @param pfmByPic
	 */
	public void setPfmByPic(String pfmByPic) {
		this.pfmByPic = pfmByPic;
	}
	
	/**
	 * Column Info
	 * @param periodToDt
	 */
	public void setPeriodToDt(String periodToDt) {
		this.periodToDt = periodToDt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setPeriodFromDt(JSPUtil.getParameter(request, "period_from_dt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPfmByQueueCd(JSPUtil.getParameter(request, "pfm_by_queue_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPfmByPic(JSPUtil.getParameter(request, "pfm_by_pic", ""));
		setPeriodToDt(JSPUtil.getParameter(request, "period_to_dt", ""));
		setDocPart(JSPUtil.getParameter(request, "doc_part", ""));
		setDocPartEu(JSPUtil.getParameter(request, "doc_part_eu", ""));
		setDocPartJp(JSPUtil.getParameter(request, "doc_part_jp", ""));
		setDocPartSw(JSPUtil.getParameter(request, "doc_part_sw", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocTurnTimeInVO[]
	 */
	public DocTurnTimeInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocTurnTimeInVO[]
	 */
	public DocTurnTimeInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocTurnTimeInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] periodFromDt = (JSPUtil.getParameter(request, prefix	+ "period_from_dt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pfmByQueueCd = (JSPUtil.getParameter(request, prefix	+ "pfm_by_queue_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pfmByPic = (JSPUtil.getParameter(request, prefix	+ "pfm_by_pic", length));
			String[] periodToDt = (JSPUtil.getParameter(request, prefix	+ "period_to_dt", length));
			String[] docPart = (JSPUtil.getParameter(request, prefix	+ "doc_part", length));
			String[] docPartEu = (JSPUtil.getParameter(request, prefix	+ "doc_part_eu", length));
			String[] docPartJp = (JSPUtil.getParameter(request, prefix	+ "doc_part_jp", length));
			String[] docPartSw = (JSPUtil.getParameter(request, prefix	+ "doc_part_sw", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocTurnTimeInVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (periodFromDt[i] != null)
					model.setPeriodFromDt(periodFromDt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pfmByQueueCd[i] != null)
					model.setPfmByQueueCd(pfmByQueueCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pfmByPic[i] != null)
					model.setPfmByPic(pfmByPic[i]);
				if (periodToDt[i] != null)
					model.setPeriodToDt(periodToDt[i]);
				if (docPart[i] != null)
					model.setDocPart(docPart[i]);
				if (docPartEu[i] != null)
					model.setDocPartEu(docPartEu[i]);
				if (docPartJp[i] != null)
					model.setDocPartJp(docPartJp[i]);
				if (docPartSw[i] != null)
					model.setDocPartSw(docPartSw[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocTurnTimeInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocTurnTimeInVO[]
	 */
	public DocTurnTimeInVO[] getDocTurnTimeInVOs(){
		DocTurnTimeInVO[] vos = (DocTurnTimeInVO[])models.toArray(new DocTurnTimeInVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodFromDt = this.periodFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmByQueueCd = this.pfmByQueueCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfmByPic = this.pfmByPic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodToDt = this.periodToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPart = this.docPart .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartEu = this.docPartEu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartJp = this.docPartJp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docPartSw = this.docPartSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
