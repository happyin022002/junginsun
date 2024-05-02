/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorExportCorrVO.java
*@FileTitle : KorExportCorrVO
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

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorExportCorrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorExportCorrVO> models = new ArrayList<KorExportCorrVO>();

	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String krXptPckId = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Column Info */
	private String prtLodgFlg = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String divdPckQty = null;
	/* Column Info */
	private String preXptLicNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String divdPckUtCd = null;
	/* Column Info */
	private String prtLodgSeq = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String divdWgt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String divdWgtUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorExportCorrVO() {}

	public KorExportCorrVO(String ibflag, String pagerows, String smtAmdNo, String portCd, String xptLicNo, String krCstmsCorrId, String corrRsn, String pckQty, String pckTpCd, String cntrWgt, String wgtUtCd, String prtLodgFlg, String prtLodgSeq, String divdPckQty, String divdPckUtCd, String divdWgt, String divdWgtUtCd, String krXptPckId, String preXptLicNo, String userId) {
		this.smtAmdNo = smtAmdNo;
		this.krXptPckId = krXptPckId;
		this.cntrWgt = cntrWgt;
		this.krCstmsCorrId = krCstmsCorrId;
		this.prtLodgFlg = prtLodgFlg;
		this.xptLicNo = xptLicNo;
		this.pagerows = pagerows;
		this.divdPckQty = divdPckQty;
		this.preXptLicNo = preXptLicNo;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.divdPckUtCd = divdPckUtCd;
		this.prtLodgSeq = prtLodgSeq;
		this.userId = userId;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.divdWgt = divdWgt;
		this.portCd = portCd;
		this.pckTpCd = pckTpCd;
		this.divdWgtUtCd = divdWgtUtCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("kr_xpt_pck_id", getKrXptPckId());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("prt_lodg_flg", getPrtLodgFlg());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("divd_pck_qty", getDivdPckQty());
		this.hashColumns.put("pre_xpt_lic_no", getPreXptLicNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("divd_pck_ut_cd", getDivdPckUtCd());
		this.hashColumns.put("prt_lodg_seq", getPrtLodgSeq());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("divd_wgt", getDivdWgt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("divd_wgt_ut_cd", getDivdWgtUtCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("kr_xpt_pck_id", "krXptPckId");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("prt_lodg_flg", "prtLodgFlg");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("divd_pck_qty", "divdPckQty");
		this.hashFields.put("pre_xpt_lic_no", "preXptLicNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("divd_pck_ut_cd", "divdPckUtCd");
		this.hashFields.put("prt_lodg_seq", "prtLodgSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("divd_wgt", "divdWgt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("divd_wgt_ut_cd", "divdWgtUtCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}

	/**
	 * Column Info
	 * @return krXptPckId
	 */
	public String getKrXptPckId() {
		return this.krXptPckId;
	}

	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
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
	 * @return prtLodgFlg
	 */
	public String getPrtLodgFlg() {
		return this.prtLodgFlg;
	}

	/**
	 * Column Info
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
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
	 * @return divdPckQty
	 */
	public String getDivdPckQty() {
		return this.divdPckQty;
	}

	/**
	 * Column Info
	 * @return preXptLicNo
	 */
	public String getPreXptLicNo() {
		return this.preXptLicNo;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
	}

	/**
	 * Column Info
	 * @return divdPckUtCd
	 */
	public String getDivdPckUtCd() {
		return this.divdPckUtCd;
	}

	/**
	 * Column Info
	 * @return prtLodgSeq
	 */
	public String getPrtLodgSeq() {
		return this.prtLodgSeq;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}

	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}

	/**
	 * Column Info
	 * @return divdWgt
	 */
	public String getDivdWgt() {
		return this.divdWgt;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}

	/**
	 * Column Info
	 * @return divdWgtUtCd
	 */
	public String getDivdWgtUtCd() {
		return this.divdWgtUtCd;
	}


	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}

	/**
	 * Column Info
	 * @param krXptPckId
	 */
	public void setKrXptPckId(String krXptPckId) {
		this.krXptPckId = krXptPckId;
	}

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
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
	 * @param prtLodgFlg
	 */
	public void setPrtLodgFlg(String prtLodgFlg) {
		this.prtLodgFlg = prtLodgFlg;
	}

	/**
	 * Column Info
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
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
	 * @param divdPckQty
	 */
	public void setDivdPckQty(String divdPckQty) {
		this.divdPckQty = divdPckQty;
	}

	/**
	 * Column Info
	 * @param preXptLicNo
	 */
	public void setPreXptLicNo(String preXptLicNo) {
		this.preXptLicNo = preXptLicNo;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
	}

	/**
	 * Column Info
	 * @param divdPckUtCd
	 */
	public void setDivdPckUtCd(String divdPckUtCd) {
		this.divdPckUtCd = divdPckUtCd;
	}

	/**
	 * Column Info
	 * @param prtLodgSeq
	 */
	public void setPrtLodgSeq(String prtLodgSeq) {
		this.prtLodgSeq = prtLodgSeq;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}

	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}

	/**
	 * Column Info
	 * @param divdWgt
	 */
	public void setDivdWgt(String divdWgt) {
		this.divdWgt = divdWgt;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}

	/**
	 * Column Info
	 * @param divdWgtUtCd
	 */
	public void setDivdWgtUtCd(String divdWgtUtCd) {
		this.divdWgtUtCd = divdWgtUtCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSmtAmdNo(JSPUtil.getParameter(request, "smt_amd_no", ""));
		setKrXptPckId(JSPUtil.getParameter(request, "kr_xpt_pck_id", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, "kr_cstms_corr_id", ""));
		setPrtLodgFlg(JSPUtil.getParameter(request, "prt_lodg_flg", ""));
		setXptLicNo(JSPUtil.getParameter(request, "xpt_lic_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDivdPckQty(JSPUtil.getParameter(request, "divd_pck_qty", ""));
		setPreXptLicNo(JSPUtil.getParameter(request, "pre_xpt_lic_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, "corr_rsn", ""));
		setDivdPckUtCd(JSPUtil.getParameter(request, "divd_pck_ut_cd", ""));
		setPrtLodgSeq(JSPUtil.getParameter(request, "prt_lodg_seq", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setDivdWgt(JSPUtil.getParameter(request, "divd_wgt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setDivdWgtUtCd(JSPUtil.getParameter(request, "divd_wgt_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorExportCorrVO[]
	 */
	public KorExportCorrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorExportCorrVO[]
	 */
	public KorExportCorrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorExportCorrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] krXptPckId = (JSPUtil.getParameter(request, prefix	+ "kr_xpt_pck_id", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] prtLodgFlg = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_flg", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] divdPckQty = (JSPUtil.getParameter(request, prefix	+ "divd_pck_qty", length));
			String[] preXptLicNo = (JSPUtil.getParameter(request, prefix	+ "pre_xpt_lic_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] divdPckUtCd = (JSPUtil.getParameter(request, prefix	+ "divd_pck_ut_cd", length));
			String[] prtLodgSeq = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_seq", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] divdWgt = (JSPUtil.getParameter(request, prefix	+ "divd_wgt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] divdWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "divd_wgt_ut_cd", length));

			for (int i = 0; i < length; i++) {
				model = new KorExportCorrVO();
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (krXptPckId[i] != null)
					model.setKrXptPckId(krXptPckId[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (prtLodgFlg[i] != null)
					model.setPrtLodgFlg(prtLodgFlg[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (divdPckQty[i] != null)
					model.setDivdPckQty(divdPckQty[i]);
				if (preXptLicNo[i] != null)
					model.setPreXptLicNo(preXptLicNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (divdPckUtCd[i] != null)
					model.setDivdPckUtCd(divdPckUtCd[i]);
				if (prtLodgSeq[i] != null)
					model.setPrtLodgSeq(prtLodgSeq[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (divdWgt[i] != null)
					model.setDivdWgt(divdWgt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (divdWgtUtCd[i] != null)
					model.setDivdWgtUtCd(divdWgtUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorExportCorrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorExportCorrVO[]
	 */
	public KorExportCorrVO[] getKorExportCorrVOs(){
		KorExportCorrVO[] vos = (KorExportCorrVO[])models.toArray(new KorExportCorrVO[models.size()]);
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
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krXptPckId = this.krXptPckId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgFlg = this.prtLodgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckQty = this.divdPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preXptLicNo = this.preXptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckUtCd = this.divdPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgSeq = this.prtLodgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgt = this.divdWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgtUtCd = this.divdWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
