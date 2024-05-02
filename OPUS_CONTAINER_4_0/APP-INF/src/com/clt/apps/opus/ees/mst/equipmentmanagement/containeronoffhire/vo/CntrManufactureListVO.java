/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrManufactureInfoVO.java
*@FileTitle : CntrManufactureInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.02
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.08.02 남궁진호 
* 1.0 Creation
* Sheet의 Data를 300건씩 배열로 묶어 처리하도록 변경함
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrManufactureListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrManufactureListVO> models = new ArrayList<CntrManufactureListVO>();
	
	/* Column Info */
	private String onhYdCd = null;
	/* Column Info */
	private String lstmcd = null;
	/* Column Info */
	private String mFlg = null;
	/* Column Info */
	private String mftrVndrSeq = null;
	/* Column Info */
	private String cntrNos = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String ceflg = null;
	/* Column Info */
	private String onhDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mdFlg = null;
	/* Column Info */
	private String mftDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aeflg = null;
	/* Column Info */
	private String eeflg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String mftrVndrNm = null;
	/* Column Info */
	private String beflg = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String deflg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrManufactureListVO() {}

	public CntrManufactureListVO(String ibflag, String pagerows, String onhYdCd, String lstmcd, String mFlg, String mftrVndrSeq, String cntrNos, String ceflg, String onhDt, String mdFlg, String mftDt, String creUsrId, String aeflg, String cntrNo, String vndrSeq, String eeflg, String cntrTpszCd, String mftrVndrNm, String beflg, String lstmCd, String updUsrId, String deflg, String agmtCtyCd, String agmtSeq) {
		this.onhYdCd = onhYdCd;
		this.lstmcd = lstmcd;
		this.mFlg = mFlg;
		this.mftrVndrSeq = mftrVndrSeq;
		this.cntrNos = cntrNos;
		this.agmtSeq = agmtSeq;
		this.ceflg = ceflg;
		this.onhDt = onhDt;
		this.pagerows = pagerows;
		this.mdFlg = mdFlg;
		this.mftDt = mftDt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.aeflg = aeflg;
		this.eeflg = eeflg;
		this.vndrSeq = vndrSeq;
		this.cntrNo = cntrNo;
		this.agmtCtyCd = agmtCtyCd;
		this.cntrTpszCd = cntrTpszCd;
		this.mftrVndrNm = mftrVndrNm;
		this.beflg = beflg;
		this.lstmCd = lstmCd;
		this.deflg = deflg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("lstmcd", getLstmcd());
		this.hashColumns.put("m_flg", getMFlg());
		this.hashColumns.put("mftr_vndr_seq", getMftrVndrSeq());
		this.hashColumns.put("cntr_nos", getCntrNos());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("ceflg", getCeflg());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("md_flg", getMdFlg());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("aeflg", getAeflg());
		this.hashColumns.put("eeflg", getEeflg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("mftr_vndr_nm", getMftrVndrNm());
		this.hashColumns.put("beflg", getBeflg());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("deflg", getDeflg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("lstmcd", "lstmcd");
		this.hashFields.put("m_flg", "mFlg");
		this.hashFields.put("mftr_vndr_seq", "mftrVndrSeq");
		this.hashFields.put("cntr_nos", "cntrNos");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("md_flg", "mdFlg");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("aeflg", "aeflg");
		this.hashFields.put("eeflg", "eeflg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("mftr_vndr_nm", "mftrVndrNm");
		this.hashFields.put("beflg", "beflg");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("deflg", "deflg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return onhYdCd
	 */
	public String getOnhYdCd() {
		return this.onhYdCd;
	}
	
	/**
	 * Column Info
	 * @return lstmcd
	 */
	public String getLstmcd() {
		return this.lstmcd;
	}
	
	/**
	 * Column Info
	 * @return mFlg
	 */
	public String getMFlg() {
		return this.mFlg;
	}
	
	/**
	 * Column Info
	 * @return mftrVndrSeq
	 */
	public String getMftrVndrSeq() {
		return this.mftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNos
	 */
	public String getCntrNos() {
		return this.cntrNos;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return ceflg
	 */
	public String getCeflg() {
		return this.ceflg;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
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
	 * @return mdFlg
	 */
	public String getMdFlg() {
		return this.mdFlg;
	}
	
	/**
	 * Column Info
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
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
	 * @return aeflg
	 */
	public String getAeflg() {
		return this.aeflg;
	}
	
	/**
	 * Column Info
	 * @return eeflg
	 */
	public String getEeflg() {
		return this.eeflg;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return mftrVndrNm
	 */
	public String getMftrVndrNm() {
		return this.mftrVndrNm;
	}
	
	/**
	 * Column Info
	 * @return beflg
	 */
	public String getBeflg() {
		return this.beflg;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return deflg
	 */
	public String getDeflg() {
		return this.deflg;
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
	 * @param onhYdCd
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
	}
	
	/**
	 * Column Info
	 * @param lstmcd
	 */
	public void setLstmcd(String lstmcd) {
		this.lstmcd = lstmcd;
	}
	
	/**
	 * Column Info
	 * @param mFlg
	 */
	public void setMFlg(String mFlg) {
		this.mFlg = mFlg;
	}
	
	/**
	 * Column Info
	 * @param mftrVndrSeq
	 */
	public void setMftrVndrSeq(String mftrVndrSeq) {
		this.mftrVndrSeq = mftrVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNos
	 */
	public void setCntrNos(String cntrNos) {
		this.cntrNos = cntrNos;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param ceflg
	 */
	public void setCeflg(String ceflg) {
		this.ceflg = ceflg;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
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
	 * @param mdFlg
	 */
	public void setMdFlg(String mdFlg) {
		this.mdFlg = mdFlg;
	}
	
	/**
	 * Column Info
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
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
	 * @param aeflg
	 */
	public void setAeflg(String aeflg) {
		this.aeflg = aeflg;
	}
	
	/**
	 * Column Info
	 * @param eeflg
	 */
	public void setEeflg(String eeflg) {
		this.eeflg = eeflg;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param mftrVndrNm
	 */
	public void setMftrVndrNm(String mftrVndrNm) {
		this.mftrVndrNm = mftrVndrNm;
	}
	
	/**
	 * Column Info
	 * @param beflg
	 */
	public void setBeflg(String beflg) {
		this.beflg = beflg;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param deflg
	 */
	public void setDeflg(String deflg) {
		this.deflg = deflg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setOnhYdCd(JSPUtil.getParameter(request, prefix + "onh_yd_cd", ""));
		setLstmcd(JSPUtil.getParameter(request, prefix + "lstmcd", ""));
		setMFlg(JSPUtil.getParameter(request, prefix + "m_flg", ""));
		setMftrVndrSeq(JSPUtil.getParameter(request, prefix + "mftr_vndr_seq", ""));
		setCntrNos(JSPUtil.getParameter(request, prefix + "cntr_nos", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setCeflg(JSPUtil.getParameter(request, prefix + "ceflg", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMdFlg(JSPUtil.getParameter(request, prefix + "md_flg", ""));
		setMftDt(JSPUtil.getParameter(request, prefix + "mft_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAeflg(JSPUtil.getParameter(request, prefix + "aeflg", ""));
		setEeflg(JSPUtil.getParameter(request, prefix + "eeflg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, prefix + "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setMftrVndrNm(JSPUtil.getParameter(request, prefix + "mftr_vndr_nm", ""));
		setBeflg(JSPUtil.getParameter(request, prefix + "beflg", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setDeflg(JSPUtil.getParameter(request, prefix + "deflg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrManufactureInfoVO[]
	 */
	public CntrManufactureListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrManufactureInfoVO[]
	 */
	public CntrManufactureListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrManufactureListVO model = null;
		String arrCntrNo="";
		String arrMftrDt="";
		String arrMftrVndrSeq="";
		String arrAeflg="";
		String arrBeflg="";
		String arrCeflg="";
		String arrDeflg="";
		String arrEeflg="";
		
		String cntrNOs="";
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mftrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mftr_vndr_seq", length));
			String[] cntrNos = (JSPUtil.getParameter(request, prefix	+ "cntr_nos", length));
			String[] ceflg = (JSPUtil.getParameter(request, prefix	+ "ceflg", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] aeflg = (JSPUtil.getParameter(request, prefix	+ "aeflg", length));
			String[] eeflg = (JSPUtil.getParameter(request, prefix	+ "eeflg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] beflg = (JSPUtil.getParameter(request, prefix	+ "beflg", length));
			String[] deflg = (JSPUtil.getParameter(request, prefix	+ "deflg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrManufactureListVO();
				if (cntrNo[i] != null)					arrCntrNo=arrCntrNo+"|"+cntrNo[i];
				if (mftrVndrSeq[i] != null)				arrMftrVndrSeq=arrMftrVndrSeq+"|"+mftrVndrSeq[i];
				if (mftDt[i] != null)					arrMftrDt=arrMftrDt+"|"+mftDt[i];
				if (aeflg[i] != null)					arrAeflg = arrAeflg+"|"+aeflg[i];
				if (beflg[i] != null)					arrBeflg = arrBeflg+"|"+beflg[i];
				if (ceflg[i] != null)					arrCeflg = arrCeflg+"|"+ceflg[i];
				if (deflg[i] != null)					arrDeflg = arrDeflg+"|"+deflg[i];
				if (eeflg[i] != null)					arrEeflg = arrEeflg+"|"+eeflg[i];
				cntrNOs = cntrNos[i];
				if((i+1)%300==0){
					model.setCntrNo(arrCntrNo+"|");
					model.setMftrVndrSeq(arrMftrVndrSeq+"|");
					model.setMftDt(arrMftrDt+"|");
					model.setAeflg(arrAeflg+"|");
					model.setBeflg(arrBeflg+"|");
					model.setCeflg(arrCeflg+"|");
					model.setDeflg(arrDeflg+"|");
					model.setCntrNos(cntrNOs+"|");
					models.add(model);
					 arrCntrNo="";
					 arrMftrDt="";
					 arrMftrVndrSeq="";
					 arrAeflg="";
					 arrBeflg="";
					 arrCeflg="";
					 arrDeflg="";
					 arrEeflg="";
				}else if((i+1)/300==length/300 && (i+1)%300 > 0 && i+1==length) {
					model.setCntrNo(arrCntrNo+"|");
					model.setMftrVndrSeq(arrMftrVndrSeq+"|");
					model.setMftDt(arrMftrDt+"|");
					model.setAeflg(arrAeflg+"|");
					model.setBeflg(arrBeflg+"|");
					model.setCeflg(arrCeflg+"|");
					model.setDeflg(arrDeflg+"|");
					model.setCntrNos(cntrNOs+"|");
					models.add(model);
				}
			}
		} catch (Exception e) {
			return null;
		}
		return getCntrManufactureInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrManufactureInfoVO[]
	 */
	public CntrManufactureListVO[] getCntrManufactureInfoVOs(){
		CntrManufactureListVO[] vos = (CntrManufactureListVO[])models.toArray(new CntrManufactureListVO[models.size()]);
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
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmcd = this.lstmcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mFlg = this.mFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftrVndrSeq = this.mftrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNos = this.cntrNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg = this.ceflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdFlg = this.mdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeflg = this.aeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeflg = this.eeflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftrVndrNm = this.mftrVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beflg = this.beflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deflg = this.deflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
