/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCorrInfoVO.java
*@FileTitle : KorCorrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.24 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SndCorrVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see SndCorrVO
 */

public class KorCorrInfoVO extends SndCorrVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorCorrInfoVO> models = new ArrayList<KorCorrInfoVO>();

	/* Column Info */
	private String amdtRcvrFlg = null;
	/* Column Info */
	private String callYr = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String ioTmlLocCd = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cBlNo = null;
	/* Column Info */
	private String dchgMzdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String krVslCallSgnCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCorrInfoVO() {}

	public KorCorrInfoVO(String ibflag, String pagerows, String subNo, String bkgNo, String cstmsDeclTpCd, String blNo, String krCstmsCorrId, String corrRsn, String userId, String trnsSeq, String portCd, String amdtRcvrFlg, String krVslCallSgnCd, String callYr, String callKnt, String vslNm, String vslRgstCntCd, String dchgMzdCd, String ioTmlLocCd, String vvd, String cBlNo) {
		this.amdtRcvrFlg = amdtRcvrFlg;
		this.callYr = callYr;
		this.trnsSeq = trnsSeq;
		this.ioTmlLocCd = ioTmlLocCd;
		this.krCstmsCorrId = krCstmsCorrId;
		this.vslNm = vslNm;
		this.blNo = blNo;
		this.dchgMzdCd = dchgMzdCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.corrRsn = corrRsn;
		this.vslRgstCntCd = vslRgstCntCd;
		this.subNo = subNo;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.krVslCallSgnCd = krVslCallSgnCd;
		this.userId = userId;
		this.callKnt = callKnt;
		this.portCd = portCd;
		this.cBlNo = cBlNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_rcvr_flg", getAmdtRcvrFlg());
		this.hashColumns.put("call_yr", getCallYr());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("io_tml_loc_cd", getIoTmlLocCd());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("dchg_mzd_cd", getDchgMzdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("kr_vsl_call_sgn_cd", getKrVslCallSgnCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("c_bl_no", getCBlNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_rcvr_flg", "amdtRcvrFlg");
		this.hashFields.put("call_yr", "callYr");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("io_tml_loc_cd", "ioTmlLocCd");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("dchg_mzd_cd", "dchgMzdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("kr_vsl_call_sgn_cd", "krVslCallSgnCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
	}

	/**
	 * @return the cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
	}

	/**
	 * @param blNo the cBlNo to set
	 */
	public void setCBlNo(String blNo) {
		this.cBlNo = blNo;
	}

	/**
	 * Column Info
	 * @return amdtRcvrFlg
	 */
	public String getAmdtRcvrFlg() {
		return this.amdtRcvrFlg;
	}

	/**
	 * Column Info
	 * @return callYr
	 */
	public String getCallYr() {
		return this.callYr;
	}

	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}

	/**
	 * Column Info
	 * @return ioTmlLocCd
	 */
	public String getIoTmlLocCd() {
		return this.ioTmlLocCd;
	}

	/**
	 * Column Info
	 * @return krCstmsCorrId
	 */
	public String getKrCstmsCorrId() {
		return this.krCstmsCorrId;
	}

	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}

	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return dchgMzdCd
	 */
	public String getDchgMzdCd() {
		return this.dchgMzdCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
	}

	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}

	/**
	 * Column Info
	 * @return subNo
	 */
	public String getSubNo() {
		return this.subNo;
	}

	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @return krVslCallSgnCd
	 */
	public String getKrVslCallSgnCd() {
		return this.krVslCallSgnCd;
	}

	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Column Info
	 * @return callKnt
	 */
	public String getCallKnt() {
		return this.callKnt;
	}

	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}


	/**
	 * Column Info
	 * @param amdtRcvrFlg
	 */
	public void setAmdtRcvrFlg(String amdtRcvrFlg) {
		this.amdtRcvrFlg = amdtRcvrFlg;
	}

	/**
	 * Column Info
	 * @param callYr
	 */
	public void setCallYr(String callYr) {
		this.callYr = callYr;
	}

	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}

	/**
	 * Column Info
	 * @param ioTmlLocCd
	 */
	public void setIoTmlLocCd(String ioTmlLocCd) {
		this.ioTmlLocCd = ioTmlLocCd;
	}

	/**
	 * Column Info
	 * @param krCstmsCorrId
	 */
	public void setKrCstmsCorrId(String krCstmsCorrId) {
		this.krCstmsCorrId = krCstmsCorrId;
	}

	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}

	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param dchgMzdCd
	 */
	public void setDchgMzdCd(String dchgMzdCd) {
		this.dchgMzdCd = dchgMzdCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
	}

	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}

	/**
	 * Column Info
	 * @param subNo
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}

	/**
	 * Column Info
	 * @param krVslCallSgnCd
	 */
	public void setKrVslCallSgnCd(String krVslCallSgnCd) {
		this.krVslCallSgnCd = krVslCallSgnCd;
	}

	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Column Info
	 * @param callKnt
	 */
	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAmdtRcvrFlg(JSPUtil.getParameter(request, "amdt_rcvr_flg", ""));
		setCallYr(JSPUtil.getParameter(request, "call_yr", ""));
		setTrnsSeq(JSPUtil.getParameter(request, "trns_seq", ""));
		setIoTmlLocCd(JSPUtil.getParameter(request, "io_tml_loc_cd", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, "kr_cstms_corr_id", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setDchgMzdCd(JSPUtil.getParameter(request, "dchg_mzd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCorrRsn(JSPUtil.getParameter(request, "corr_rsn", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setSubNo(JSPUtil.getParameter(request, "sub_no", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setKrVslCallSgnCd(JSPUtil.getParameter(request, "kr_vsl_call_sgn_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setCBlNo(JSPUtil.getParameter(request, "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCorrInfoVO[]
	 */
	public KorCorrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCorrInfoVO[]
	 */
	public KorCorrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCorrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] amdtRcvrFlg = (JSPUtil.getParameter(request, prefix	+ "amdt_rcvr_flg", length));
			String[] callYr = (JSPUtil.getParameter(request, prefix	+ "call_yr", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] ioTmlLocCd = (JSPUtil.getParameter(request, prefix	+ "io_tml_loc_cd", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] dchgMzdCd = (JSPUtil.getParameter(request, prefix	+ "dchg_mzd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] krVslCallSgnCd = (JSPUtil.getParameter(request, prefix	+ "kr_vsl_call_sgn_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));

			for (int i = 0; i < length; i++) {
				model = new KorCorrInfoVO();
				if (amdtRcvrFlg[i] != null)
					model.setAmdtRcvrFlg(amdtRcvrFlg[i]);
				if (callYr[i] != null)
					model.setCallYr(callYr[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (ioTmlLocCd[i] != null)
					model.setIoTmlLocCd(ioTmlLocCd[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (dchgMzdCd[i] != null)
					model.setDchgMzdCd(dchgMzdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (krVslCallSgnCd[i] != null)
					model.setKrVslCallSgnCd(krVslCallSgnCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCorrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCorrInfoVO[]
	 */
	public KorCorrInfoVO[] getKorCorrInfoVOs(){
		KorCorrInfoVO[] vos = (KorCorrInfoVO[])models.toArray(new KorCorrInfoVO[models.size()]);
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
		this.amdtRcvrFlg = this.amdtRcvrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYr = this.callYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioTmlLocCd = this.ioTmlLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgMzdCd = this.dchgMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krVslCallSgnCd = this.krVslCallSgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
