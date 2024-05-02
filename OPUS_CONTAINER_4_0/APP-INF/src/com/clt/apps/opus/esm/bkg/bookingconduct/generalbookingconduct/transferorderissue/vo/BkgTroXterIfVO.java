/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgTroXterIfVO.java
*@FileTitle : BkgTroXterIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.23 이남경
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgTroXterIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgTroXterIfVO> models = new ArrayList<BkgTroXterIfVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifDt = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String ordNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ifSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String ackStsCd = null;
	/* Column Info */
	private String rtnTroFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rqstOrdMsg = null;
	/* Column Info */
	private String vvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgTroXterIfVO() {}

	public BkgTroXterIfVO(String ibflag, String pagerows, String bkgNo, String ioBndCd, String rtnTroFlg, String troSeq, String ifSeq, String ifDt, String ordNo, String ackStsCd, String rqstOrdMsg, String creUsrId, String creDt, String updUsrId, String updDt, String docUsrId, String usrNm, String bkgStsCd, String vvd) {
		this.updDt = updDt;
		this.ifDt = ifDt;
		this.docUsrId = docUsrId;
		this.ordNo = ordNo;
		this.bkgStsCd = bkgStsCd;
		this.troSeq = troSeq;
		this.creDt = creDt;
		this.ifSeq = ifSeq;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.usrNm = usrNm;
		this.ackStsCd = ackStsCd;
		this.rtnTroFlg = rtnTroFlg;
		this.updUsrId = updUsrId;
		this.rqstOrdMsg = rqstOrdMsg;
		this.vvd = vvd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_dt", getIfDt());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("ord_no", getOrdNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("if_seq", getIfSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("ack_sts_cd", getAckStsCd());
		this.hashColumns.put("rtn_tro_flg", getRtnTroFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rqst_ord_msg", getRqstOrdMsg());
		this.hashColumns.put("vvd", getVvd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("ord_no", "ordNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("if_seq", "ifSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("ack_sts_cd", "ackStsCd");
		this.hashFields.put("rtn_tro_flg", "rtnTroFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rqst_ord_msg", "rqstOrdMsg");
		this.hashFields.put("vvd", "vvd");
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
	 * @return ifDt
	 */
	public String getIfDt() {
		return this.ifDt;
	}

	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}

	/**
	 * Column Info
	 * @return ordNo
	 */
	public String getOrdNo() {
		return this.ordNo;
	}

	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}

	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
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
	 * @return ifSeq
	 */
	public String getIfSeq() {
		return this.ifSeq;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ackStsCd
	 */
	public String getAckStsCd() {
		return this.ackStsCd;
	}

	/**
	 * Column Info
	 * @return rtnTroFlg
	 */
	public String getRtnTroFlg() {
		return this.rtnTroFlg;
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
	 * @return rqstOrdMsg
	 */
	public String getRqstOrdMsg() {
		return this.rqstOrdMsg;
	}
	
	/**
	 * Column Info
	 * @return rqstOrdMsg
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @param ifDt
	 */
	public void setIfDt(String ifDt) {
		this.ifDt = ifDt;
	}

	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}

	/**
	 * Column Info
	 * @param ordNo
	 */
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}

	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
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
	 * @param ifSeq
	 */
	public void setIfSeq(String ifSeq) {
		this.ifSeq = ifSeq;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ackStsCd
	 */
	public void setAckStsCd(String ackStsCd) {
		this.ackStsCd = ackStsCd;
	}

	/**
	 * Column Info
	 * @param rtnTroFlg
	 */
	public void setRtnTroFlg(String rtnTroFlg) {
		this.rtnTroFlg = rtnTroFlg;
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
	 * @param rqstOrdMsg
	 */
	public void setRqstOrdMsg(String rqstOrdMsg) {
		this.rqstOrdMsg = rqstOrdMsg;
	}

	/**
	 * Column Info
	 * @param rqstOrdMsg
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIfDt(JSPUtil.getParameter(request, "if_dt", ""));
		setDocUsrId(JSPUtil.getParameter(request, "doc_usr_id", ""));
		setOrdNo(JSPUtil.getParameter(request, "ord_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setIfSeq(JSPUtil.getParameter(request, "if_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setAckStsCd(JSPUtil.getParameter(request, "ack_sts_cd", ""));
		setRtnTroFlg(JSPUtil.getParameter(request, "rtn_tro_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRqstOrdMsg(JSPUtil.getParameter(request, "rqst_ord_msg", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTroXterIfVO[]
	 */
	public BkgTroXterIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgTroXterIfVO[]
	 */
	public BkgTroXterIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTroXterIfVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifDt = (JSPUtil.getParameter(request, prefix	+ "if_dt", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] ordNo = (JSPUtil.getParameter(request, prefix	+ "ord_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ifSeq = (JSPUtil.getParameter(request, prefix	+ "if_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] ackStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_sts_cd", length));
			String[] rtnTroFlg = (JSPUtil.getParameter(request, prefix	+ "rtn_tro_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rqstOrdMsg = (JSPUtil.getParameter(request, prefix	+ "rqst_ord_msg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));

			for (int i = 0; i < length; i++) {
				model = new BkgTroXterIfVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifDt[i] != null)
					model.setIfDt(ifDt[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (ordNo[i] != null)
					model.setOrdNo(ordNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ifSeq[i] != null)
					model.setIfSeq(ifSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (ackStsCd[i] != null)
					model.setAckStsCd(ackStsCd[i]);
				if (rtnTroFlg[i] != null)
					model.setRtnTroFlg(rtnTroFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rqstOrdMsg[i] != null)
					model.setRqstOrdMsg(rqstOrdMsg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTroXterIfVOVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTroXterIfVO[]
	 */
	public BkgTroXterIfVO[] getBkgTroXterIfVOVOs(){
		BkgTroXterIfVO[] vos = (BkgTroXterIfVO[])models.toArray(new BkgTroXterIfVO[models.size()]);
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
		this.ifDt = this.ifDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordNo = this.ordNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSeq = this.ifSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackStsCd = this.ackStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnTroFlg = this.rtnTroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOrdMsg = this.rqstOrdMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
