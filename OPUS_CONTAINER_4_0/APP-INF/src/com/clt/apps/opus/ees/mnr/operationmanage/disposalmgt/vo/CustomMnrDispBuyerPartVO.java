/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchDisposalBuyerHeaderDataVO.java
*@FileTitle : searchDisposalBuyerHeaderDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.09.15 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
	
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrDispBuyerPartVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispBuyerPartVO> models = new ArrayList<CustomMnrDispBuyerPartVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrPrnrKndCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mnrPrnrEml = null;
	/* Column Info */
	private String partAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrPrnrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrDispBuyerPartVO() {}

	public CustomMnrDispBuyerPartVO(String ibflag, String pagerows, String delChk, String dispNo, String mnrPrnrId, String vndrLglEngNm, String mnrPrnrCntCd, String mnrPrnrSeq, String mnrPrnrKndCd, String ofcCd, String mnrPrnrEml, String partAmt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.mnrPrnrKndCd = mnrPrnrKndCd;
		this.dispNo = dispNo;
		this.creDt = creDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.delChk = delChk;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.mnrPrnrEml = mnrPrnrEml;
		this.partAmt = partAmt;
		this.updUsrId = updUsrId;
		this.mnrPrnrId = mnrPrnrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_prnr_knd_cd", getMnrPrnrKndCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mnr_prnr_eml", getMnrPrnrEml());
		this.hashColumns.put("part_amt", getPartAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_prnr_id", getMnrPrnrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_prnr_knd_cd", "mnrPrnrKndCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mnr_prnr_eml", "mnrPrnrEml");
		this.hashFields.put("part_amt", "partAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_prnr_id", "mnrPrnrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrKndCd
	 */
	public String getMnrPrnrKndCd() {
		return this.mnrPrnrKndCd;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
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
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrEml
	 */
	public String getMnrPrnrEml() {
		return this.mnrPrnrEml;
	}
	
	/**
	 * Column Info
	 * @return partAmt
	 */
	public String getPartAmt() {
		return this.partAmt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrId
	 */
	public String getMnrPrnrId() {
		return this.mnrPrnrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrKndCd
	 */
	public void setMnrPrnrKndCd(String mnrPrnrKndCd) {
		this.mnrPrnrKndCd = mnrPrnrKndCd;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
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
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrEml
	 */
	public void setMnrPrnrEml(String mnrPrnrEml) {
		this.mnrPrnrEml = mnrPrnrEml;
	}
	
	/**
	 * Column Info
	 * @param partAmt
	 */
	public void setPartAmt(String partAmt) {
		this.partAmt = partAmt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrId
	 */
	public void setMnrPrnrId(String mnrPrnrId) {
		this.mnrPrnrId = mnrPrnrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMnrPrnrKndCd(JSPUtil.getParameter(request, "mnr_prnr_knd_cd", ""));
		setDispNo(JSPUtil.getParameter(request, "disp_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, "mnr_prnr_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, "mnr_prnr_seq", ""));
		setDelChk(JSPUtil.getParameter(request, "del_chk", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setMnrPrnrEml(JSPUtil.getParameter(request, "mnr_prnr_eml", ""));
		setPartAmt(JSPUtil.getParameter(request, "part_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMnrPrnrId(JSPUtil.getParameter(request, "mnr_prnr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return searchDisposalBuyerHeaderDataVO[]
	 */
	public CustomMnrDispBuyerPartVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return searchDisposalBuyerHeaderDataVO[]
	 */
	public CustomMnrDispBuyerPartVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispBuyerPartVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrPrnrKndCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_knd_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mnrPrnrEml = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_eml", length));
			String[] partAmt = (JSPUtil.getParameter(request, prefix	+ "part_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrPrnrId = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispBuyerPartVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrPrnrKndCd[i] != null)
					model.setMnrPrnrKndCd(mnrPrnrKndCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mnrPrnrEml[i] != null)
					model.setMnrPrnrEml(mnrPrnrEml[i]);
				if (partAmt[i] != null)
					model.setPartAmt(partAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrPrnrId[i] != null)
					model.setMnrPrnrId(mnrPrnrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchDisposalBuyerHeaderDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return searchDisposalBuyerHeaderDataVO[]
	 */
	public CustomMnrDispBuyerPartVO[] getsearchDisposalBuyerHeaderDataVOs(){
		CustomMnrDispBuyerPartVO[] vos = (CustomMnrDispBuyerPartVO[])models.toArray(new CustomMnrDispBuyerPartVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrKndCd = this.mnrPrnrKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrEml = this.mnrPrnrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partAmt = this.partAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrId = this.mnrPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
