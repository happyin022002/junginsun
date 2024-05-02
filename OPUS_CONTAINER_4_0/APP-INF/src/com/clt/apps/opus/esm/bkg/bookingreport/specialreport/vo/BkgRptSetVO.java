/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgRptSetVO.java
*@FileTitle : BkgRptSetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.05.28 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class BkgRptSetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgRptSetVO> models = new ArrayList<BkgRptSetVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String visFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rptId = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgCustTpCd = null;
	/* Column Info */
	private String bkgRptKndCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String ownrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgRptSetVO() {}

	public BkgRptSetVO(String ibflag, String pagerows, String usrId, String bkgRptKndCd, String rptId, String visFlg, String dpSeq, String scNo, String bkgCustTpCd, String custCntCd, String custSeq, String creUsrId, String creDt, String updUsrId, String updDt, String usrNm, String ofcCd, String ownrFlg) {
		this.updDt = updDt;
		this.dpSeq = dpSeq;
		this.creDt = creDt;
		this.custSeq = custSeq;
		this.visFlg = visFlg;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.rptId = rptId;
		this.scNo = scNo;
		this.bkgCustTpCd = bkgCustTpCd;
		this.bkgRptKndCd = bkgRptKndCd;
		this.updUsrId = updUsrId;
		this.custCntCd = custCntCd;
		this.ownrFlg = ownrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("vis_flg", getVisFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rpt_id", getRptId());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("bkg_rpt_knd_cd", getBkgRptKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("ownr_flg", getOwnrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("vis_flg", "visFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rpt_id", "rptId");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("bkg_rpt_knd_cd", "bkgRptKndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ownr_flg", "ownrFlg");
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
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return visFlg
	 */
	public String getVisFlg() {
		return this.visFlg;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return rptId
	 */
	public String getRptId() {
		return this.rptId;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRptKndCd
	 */
	public String getBkgRptKndCd() {
		return this.bkgRptKndCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return ownrFlg
	 */
	public String getOwnrFlg() {
		return this.ownrFlg;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param visFlg
	 */
	public void setVisFlg(String visFlg) {
		this.visFlg = visFlg;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param rptId
	 */
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRptKndCd
	 */
	public void setBkgRptKndCd(String bkgRptKndCd) {
		this.bkgRptKndCd = bkgRptKndCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param ownrFlg
	 */
	public void setOwnrFlg(String ownrFlg) {
		this.ownrFlg = ownrFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setVisFlg(JSPUtil.getParameter(request, "vis_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setRptId(JSPUtil.getParameter(request, "rpt_id", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setBkgRptKndCd(JSPUtil.getParameter(request, "bkg_rpt_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setOwnrFlg(JSPUtil.getParameter(request, "ownr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgRptSetVO[]
	 */
	public BkgRptSetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgRptSetVO[]
	 */
	public BkgRptSetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgRptSetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq".trim(), length));
			String[] visFlg = (JSPUtil.getParameter(request, prefix	+ "vis_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm".trim(), length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id".trim(), length));
			String[] rptId = (JSPUtil.getParameter(request, prefix	+ "rpt_id".trim(), length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no".trim(), length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cust_tp_cd".trim(), length));
			String[] bkgRptKndCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rpt_knd_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd".trim(), length));
			String[] ownrFlg = (JSPUtil.getParameter(request, prefix	+ "ownr_flg".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgRptSetVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (visFlg[i] != null)
					model.setVisFlg(visFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rptId[i] != null)
					model.setRptId(rptId[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (bkgRptKndCd[i] != null)
					model.setBkgRptKndCd(bkgRptKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (ownrFlg[i] != null)
					model.setOwnrFlg(ownrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgRptSetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgRptSetVO[]
	 */
	public BkgRptSetVO[] getBkgRptSetVOs(){
		BkgRptSetVO[] vos = (BkgRptSetVO[])models.toArray(new BkgRptSetVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.visFlg = this.visFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptId = this.rptId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRptKndCd = this.bkgRptKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrFlg = this.ownrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
