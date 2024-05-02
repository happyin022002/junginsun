/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSAssetsDetailVO.java
*@FileTitle : CHSAssetsDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.25
*@LastModifier : NK
*@LastVersion : 1.0
* 2011.05.25 NK 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSAssetsDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSAssetsDetailVO> models = new ArrayList<CHSAssetsDetailVO>();
	
	/* Column Info */
	private String lotNo = null;
	/* Column Info */
	private String mftrVndrSeq = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mftDt = null;
	/* Column Info */
	private String fmPrd = null;
	/* Column Info */
	private String toPrd = null;	
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String eqSpecNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSAssetsDetailVO() {}

	public CHSAssetsDetailVO(String ibflag, String pagerows, String seq, String vndrAbbrNm, String mftrVndrSeq, String cntrTpszCd, String lstmCd, String cntrNo, String mftDt, String fmPrd, String toPrd, String cntrStsCd, String lotNo, String rccCd, String lccCd, String crntYdCd, String cnmvStsCd, String cnmvDt,String eqSpecNo) {
		this.lotNo = lotNo;
		this.mftrVndrSeq = mftrVndrSeq;
		this.cnmvDt = cnmvDt;
		this.cntrStsCd = cntrStsCd;
		this.crntYdCd = crntYdCd;
		this.rccCd = rccCd;
		this.pagerows = pagerows;
		this.mftDt = mftDt;
		this.fmPrd = fmPrd;
		this.toPrd = toPrd;
		this.lccCd = lccCd;
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.seq = seq;
		this.vndrAbbrNm = vndrAbbrNm;
		this.lstmCd = lstmCd;
		this.eqSpecNo = eqSpecNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lot_no", getLotNo());
		this.hashColumns.put("mftr_vndr_seq", getMftrVndrSeq());
		this.hashColumns.put("cnmv_dt", getCnmvDt());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mft_dt", getMftDt());
		this.hashColumns.put("fm_prd", getFmPrd());
		this.hashColumns.put("to_prd", getToPrd());		
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lot_no", "lotNo");
		this.hashFields.put("mftr_vndr_seq", "mftrVndrSeq");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("fm_prd", "fmPrd");
		this.hashFields.put("to_prd", "toPrd");		
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lotNo
	 */
	public String getLotNo() {
		return this.lotNo;
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
	 * @return cnmvDt
	 */
	public String getCnmvDt() {
		return this.cnmvDt;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @return crntYdCd
	 */
	public String getCrntYdCd() {
		return this.crntYdCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
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
	 * @return mftDt
	 */
	public String getMftDt() {
		return this.mftDt;
	}
	
	/**
	 * Column Info
	 * @return fmPrd
	 */
	public String getFmPrd() {
		return this.fmPrd;
	}
	
	/**
	 * Column Info
	 * @return toPrd
	 */
	public String getToPrd() {
		return this.toPrd;
	}	
	
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
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
	 * @return eqSpecNo
	 */
	public String getEqSpecNo() {
		return this.eqSpecNo;
	}
	

	/**
	 * Column Info
	 * @param lotNo
	 */
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
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
	 * @param cnmvDt
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
	}
	
	/**
	 * Column Info
	 * @param crntYdCd
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
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
	 * @param mftDt
	 */
	public void setMftDt(String mftDt) {
		this.mftDt = mftDt;
	}
	
	/**
	 * Column Info
	 * @param fmPrd
	 */
	public void setFmPrd(String fmPrd) {
		this.fmPrd = fmPrd;
	}
	
	/**
	 * Column Info
	 * @param toPrd
	 */
	public void setToPrd(String toPrd) {
		this.toPrd = toPrd;
	}	
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
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
	 * @param eqSpecNo
	 */
	public void setEqSpecNo(String eqSpecNo) {
		this.eqSpecNo = eqSpecNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLotNo(JSPUtil.getParameter(request, "lot_no", ""));
		setMftrVndrSeq(JSPUtil.getParameter(request, "mftr_vndr_seq", ""));
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setCntrStsCd(JSPUtil.getParameter(request, "cntr_sts_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));
		setRccCd(JSPUtil.getParameter(request, "rcc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMftDt(JSPUtil.getParameter(request, "mft_dt", ""));
		setFmPrd(JSPUtil.getParameter(request, "fm_prd", ""));
		setToPrd(JSPUtil.getParameter(request, "to_prd", ""));		
		setLccCd(JSPUtil.getParameter(request, "lcc_cd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setEqSpecNo(JSPUtil.getParameter(request, "eq_spec_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AssetsDetailVO[]
	 */
	public CHSAssetsDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AssetsDetailVO[]
	 */
	public CHSAssetsDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSAssetsDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lotNo = (JSPUtil.getParameter(request, prefix	+ "lot_no", length));
			String[] mftrVndrSeq = (JSPUtil.getParameter(request, prefix	+ "mftr_vndr_seq", length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mftDt = (JSPUtil.getParameter(request, prefix	+ "mft_dt", length));
			String[] fmPrd = (JSPUtil.getParameter(request, prefix	+ "fm_prd", length));
			String[] toPrd = (JSPUtil.getParameter(request, prefix	+ "to_prd", length));			
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSAssetsDetailVO();
				if (lotNo[i] != null)
					model.setLotNo(lotNo[i]);
				if (mftrVndrSeq[i] != null)
					model.setMftrVndrSeq(mftrVndrSeq[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mftDt[i] != null)
					model.setMftDt(mftDt[i]);
				if (fmPrd[i] != null)
					model.setFmPrd(fmPrd[i]);
				if (toPrd[i] != null)
					model.setToPrd(toPrd[i]);				
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAssetsDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AssetsDetailVO[]
	 */
	public CHSAssetsDetailVO[] getAssetsDetailVOs(){
		CHSAssetsDetailVO[] vos = (CHSAssetsDetailVO[])models.toArray(new CHSAssetsDetailVO[models.size()]);
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
		this.lotNo = this.lotNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftrVndrSeq = this.mftrVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt = this.mftDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrd = this.fmPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrd = this.toPrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
