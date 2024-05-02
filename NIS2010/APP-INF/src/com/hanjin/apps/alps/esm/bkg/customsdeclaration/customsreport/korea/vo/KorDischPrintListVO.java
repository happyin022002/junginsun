/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDischPrintListVO.java
*@FileTitle : KorDischPrintListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.09.28 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischPrintListVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see DischPrintListVO
 */

public class KorDischPrintListVO extends DischPrintListVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorDischPrintListVO> models = new ArrayList<KorDischPrintListVO>();
	
	/* Column Info */
	private String cstmsDchgLocWhCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String bondedTp = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String coNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String mfSeqNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String bondedWh = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorDischPrintListVO() {}

	public KorDischPrintListVO(String ibflag, String pagerows, String blNo, String actWgt, String pckQty, String pckTpCd, String cstmsDchgLocWhCd, String bondedWh, String bondedTp, String custNm, String cntrNo, String mrnNo, String mrnChkNo, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String ioBndCd, String coNm, String vslEngNm, String vpsEtbDt, String mfSeqNo) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
		this.vslCd = vslCd;
		this.vpsEtbDt = vpsEtbDt;
		this.custNm = custNm;
		this.mrnChkNo = mrnChkNo;
		this.bondedTp = bondedTp;
		this.skdVoyNo = skdVoyNo;
		this.coNm = coNm;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.cntrNo = cntrNo;
		this.pckQty = pckQty;
		this.mfSeqNo = mfSeqNo;
		this.portCd = portCd;
		this.pckTpCd = pckTpCd;
		this.bondedWh = bondedWh;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("bonded_tp", getBondedTp());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("co_nm", getCoNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("mf_seq_no", getMfSeqNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("bonded_wh", getBondedWh());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("bonded_tp", "bondedTp");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("co_nm", "coNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("mf_seq_no", "mfSeqNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("bonded_wh", "bondedWh");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsDchgLocWhCd
	 */
	public String getCstmsDchgLocWhCd() {
		return this.cstmsDchgLocWhCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return mrnChkNo
	 */
	public String getMrnChkNo() {
		return this.mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @return bondedTp
	 */
	public String getBondedTp() {
		return this.bondedTp;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return coNm
	 */
	public String getCoNm() {
		return this.coNm;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return mfSeqNo
	 */
	public String getMfSeqNo() {
		return this.mfSeqNo;
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
	 * @return bondedWh
	 */
	public String getBondedWh() {
		return this.bondedWh;
	}
	

	/**
	 * Column Info
	 * @param cstmsDchgLocWhCd
	 */
	public void setCstmsDchgLocWhCd(String cstmsDchgLocWhCd) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param mrnChkNo
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @param bondedTp
	 */
	public void setBondedTp(String bondedTp) {
		this.bondedTp = bondedTp;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param coNm
	 */
	public void setCoNm(String coNm) {
		this.coNm = coNm;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param mfSeqNo
	 */
	public void setMfSeqNo(String mfSeqNo) {
		this.mfSeqNo = mfSeqNo;
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
	 * @param bondedWh
	 */
	public void setBondedWh(String bondedWh) {
		this.bondedWh = bondedWh;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCstmsDchgLocWhCd(JSPUtil.getParameter(request, "cstms_dchg_loc_wh_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setBondedTp(JSPUtil.getParameter(request, "bonded_tp", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setCoNm(JSPUtil.getParameter(request, "co_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setMfSeqNo(JSPUtil.getParameter(request, "mf_seq_no", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setBondedWh(JSPUtil.getParameter(request, "bonded_wh", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDischPrintListVO[]
	 */
	public KorDischPrintListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorDischPrintListVO[]
	 */
	public KorDischPrintListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDischPrintListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_loc_wh_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] bondedTp = (JSPUtil.getParameter(request, prefix	+ "bonded_tp", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] coNm = (JSPUtil.getParameter(request, prefix	+ "co_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] mfSeqNo = (JSPUtil.getParameter(request, prefix	+ "mf_seq_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] bondedWh = (JSPUtil.getParameter(request, prefix	+ "bonded_wh", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorDischPrintListVO();
				if (cstmsDchgLocWhCd[i] != null)
					model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (bondedTp[i] != null)
					model.setBondedTp(bondedTp[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (coNm[i] != null)
					model.setCoNm(coNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (mfSeqNo[i] != null)
					model.setMfSeqNo(mfSeqNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (bondedWh[i] != null)
					model.setBondedWh(bondedWh[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDischPrintListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDischPrintListVO[]
	 */
	public KorDischPrintListVO[] getKorDischPrintListVOs(){
		KorDischPrintListVO[] vos = (KorDischPrintListVO[])models.toArray(new KorDischPrintListVO[models.size()]);
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
		this.cstmsDchgLocWhCd = this.cstmsDchgLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedTp = this.bondedTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coNm = this.coNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSeqNo = this.mfSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondedWh = this.bondedWh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
