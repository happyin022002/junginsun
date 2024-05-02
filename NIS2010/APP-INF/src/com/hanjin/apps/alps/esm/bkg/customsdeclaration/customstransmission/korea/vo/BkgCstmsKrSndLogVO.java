/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsKrSndLogVO.java
*@FileTitle : BkgCstmsKrSndLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.25 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsKrSndLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsKrSndLogVO> models = new ArrayList<BkgCstmsKrSndLogVO>();
	
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String resndChk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String teuCnt = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String inType = null;
	/* Column Info */
	private String subNo = null;
	/* Column Info */
	private String corrCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String ktPa = null;
	/* Column Info */
	private String feuCnt = null;
	/* Column Info */
	private String blKnt = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String trsmCxlTpCd = null;
	/* Column Info */
	private String trsmCxlRsnCd = null;
	/* Column Info */
	private String trsmCxlDesc = null;
	/* Column Info */
	private String mfSndSeq = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsKrSndLogVO() {}

	public BkgCstmsKrSndLogVO(String ibflag, String pagerows, String sndDt, String userId, String ofcCd, String vvd, String ioBndCd, String polCd, String podCd, String inType, String blKnt, String teuCnt, String feuCnt, String ktPa, String resndChk, String blNo, String corrCd, String subNo, String fltFileRefNo, String trsmCxlTpCd, String trsmCxlRsnCd, String trsmCxlDesc, String mfSndSeq) {
		this.sndDt = sndDt;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.resndChk = resndChk;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.teuCnt = teuCnt;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.inType = inType;
		this.subNo = subNo;
		this.corrCd = corrCd;
		this.userId = userId;
		this.ktPa = ktPa;
		this.feuCnt = feuCnt;
		this.blKnt = blKnt;
		this.fltFileRefNo = fltFileRefNo;
		this.trsmCxlTpCd = trsmCxlTpCd;
		this.trsmCxlRsnCd = trsmCxlRsnCd;
		this.trsmCxlDesc = trsmCxlDesc;
		this.mfSndSeq = mfSndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("resnd_chk", getResndChk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("teu_cnt", getTeuCnt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("sub_no", getSubNo());
		this.hashColumns.put("corr_cd", getCorrCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("kt_pa", getKtPa());
		this.hashColumns.put("feu_cnt", getFeuCnt());
		this.hashColumns.put("bl_knt", getBlKnt());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("trsm_cxl_tp_cd", getTrsmCxlTpCd());
		this.hashColumns.put("trsm_cxl_rsn_cd", getTrsmCxlRsnCd());
		this.hashColumns.put("trsm_cxl_desc", getTrsmCxlDesc());
		this.hashColumns.put("mf_snd_seq", getMfSndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("resnd_chk", "resndChk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("teu_cnt", "teuCnt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("sub_no", "subNo");
		this.hashFields.put("corr_cd", "corrCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("kt_pa", "ktPa");
		this.hashFields.put("feu_cnt", "feuCnt");
		this.hashFields.put("bl_knt", "blKnt");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("trsm_cxl_tp_cd", "trsmCxlTpCd");
		this.hashFields.put("trsm_cxl_rsn_cd", "trsmCxlRsnCd");
		this.hashFields.put("trsm_cxl_desc", "trsmCxlDesc");
		this.hashFields.put("mf_snd_seq", "mfSndSeq");
		return this.hashFields;
	}
	
	/**
	 * @return the fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return fltFileRefNo;
	}

	/**
	 * @param fltFileRefNo the fltFileRefNo to set
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}

	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
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
	 * @return resndChk
	 */
	public String getResndChk() {
		return this.resndChk;
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
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return teuCnt
	 */
	public String getTeuCnt() {
		return this.teuCnt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return corrCd
	 */
	public String getCorrCd() {
		return this.corrCd;
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
	 * @return ktPa
	 */
	public String getKtPa() {
		return this.ktPa;
	}
	
	/**
	 * Column Info
	 * @return feuCnt
	 */
	public String getFeuCnt() {
		return this.feuCnt;
	}
	
	/**
	 * Column Info
	 * @return blKnt
	 */
	public String getBlKnt() {
		return this.blKnt;
	}

	/**
	 * Column Info
	 * @return trsmCxlTpCd
	 */
	public String getTrsmCxlTpCd() {
		return trsmCxlTpCd;
	}

	/**
	 * Column Info
	 * @return trsmCxlRsnCd
	 */
	public String getTrsmCxlRsnCd() {
		return trsmCxlRsnCd;
	}

	/**
	 * Column Info
	 * @return trsmCxlDesc
	 */
	public String getTrsmCxlDesc() {
		return trsmCxlDesc;
	}
	
	/**
	 * Column Info
	 * @return mfSndSeq
	 */
	public String getMfSndSeq() {
		return mfSndSeq;
	}

	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
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
	 * @param resndChk
	 */
	public void setResndChk(String resndChk) {
		this.resndChk = resndChk;
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
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param teuCnt
	 */
	public void setTeuCnt(String teuCnt) {
		this.teuCnt = teuCnt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param corrCd
	 */
	public void setCorrCd(String corrCd) {
		this.corrCd = corrCd;
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
	 * @param ktPa
	 */
	public void setKtPa(String ktPa) {
		this.ktPa = ktPa;
	}
	
	/**
	 * Column Info
	 * @param feuCnt
	 */
	public void setFeuCnt(String feuCnt) {
		this.feuCnt = feuCnt;
	}
	
	/**
	 * Column Info
	 * @param blKnt
	 */
	public void setBlKnt(String blKnt) {
		this.blKnt = blKnt;
	}
	
	/**
	 * Column Info
	 * @param trsmCxlTpCd
	 */
	public void setTrsmCxlTpCd(String trsmCxlTpCd) {
		this.trsmCxlTpCd = trsmCxlTpCd;
	}

	/**
	 * Column Info
	 * @param trsmCxlRsnCd
	 */
	public void setTrsmCxlRsnCd(String trsmCxlRsnCd) {
		this.trsmCxlRsnCd = trsmCxlRsnCd;
	}

	/**
	 * Column Info
	 * @param trsmCxlDesc
	 */
	public void setTrsmCxlDesc(String trsmCxlDesc) {
		this.trsmCxlDesc = trsmCxlDesc;
	}
	
	/**
	 * Column Info
	 * @param mfSndSeq
	 */
	public void setMfSndSeq(String mfSndSeq) {
		this.mfSndSeq = mfSndSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setResndChk(JSPUtil.getParameter(request, "resnd_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTeuCnt(JSPUtil.getParameter(request, "teu_cnt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setInType(JSPUtil.getParameter(request, "in_type", ""));
		setSubNo(JSPUtil.getParameter(request, "sub_no", ""));
		setCorrCd(JSPUtil.getParameter(request, "corr_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setKtPa(JSPUtil.getParameter(request, "kt_pa", ""));
		setFeuCnt(JSPUtil.getParameter(request, "feu_cnt", ""));
		setBlKnt(JSPUtil.getParameter(request, "bl_knt", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, "flt_file_ref_no", ""));
		setTrsmCxlTpCd(JSPUtil.getParameter(request, "trsm_cxl_tp_cd", ""));
		setTrsmCxlRsnCd(JSPUtil.getParameter(request, "trsm_cxl_rsn_cd", ""));
		setTrsmCxlDesc(JSPUtil.getParameter(request, "trsm_cxl_desc", ""));
		setMfSndSeq(JSPUtil.getParameter(request, "mf_snd_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsKrSndLogVO[]
	 */
	public BkgCstmsKrSndLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsKrSndLogVO[]
	 */
	public BkgCstmsKrSndLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsKrSndLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] resndChk = (JSPUtil.getParameter(request, prefix	+ "resnd_chk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] teuCnt = (JSPUtil.getParameter(request, prefix	+ "teu_cnt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] subNo = (JSPUtil.getParameter(request, prefix	+ "sub_no", length));
			String[] corrCd = (JSPUtil.getParameter(request, prefix	+ "corr_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] ktPa = (JSPUtil.getParameter(request, prefix	+ "kt_pa", length));
			String[] feuCnt = (JSPUtil.getParameter(request, prefix	+ "feu_cnt", length));
			String[] blKnt = (JSPUtil.getParameter(request, prefix	+ "bl_knt", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] trsmCxlTpCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_tp_cd", length));
			String[] trsmCxlRsnCd = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_rsn_cd", length));
			String[] trsmCxlDesc = (JSPUtil.getParameter(request, prefix	+ "trsm_cxl_desc", length));
			String[] mfSndSeq = (JSPUtil.getParameter(request, prefix	+ "mf_snd_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsKrSndLogVO();
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (resndChk[i] != null)
					model.setResndChk(resndChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (teuCnt[i] != null)
					model.setTeuCnt(teuCnt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (subNo[i] != null)
					model.setSubNo(subNo[i]);
				if (corrCd[i] != null)
					model.setCorrCd(corrCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (ktPa[i] != null)
					model.setKtPa(ktPa[i]);
				if (feuCnt[i] != null)
					model.setFeuCnt(feuCnt[i]);
				if (blKnt[i] != null)
					model.setBlKnt(blKnt[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (trsmCxlTpCd[i] != null)
					model.setTrsmCxlTpCd(trsmCxlTpCd[i]);
				if (trsmCxlRsnCd[i] != null)
					model.setTrsmCxlRsnCd(trsmCxlRsnCd[i]);
				if (trsmCxlDesc[i] != null)
					model.setTrsmCxlDesc(trsmCxlDesc[i]);
				if (mfSndSeq[i] != null)
					model.setMfSndSeq(mfSndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsKrSndLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsKrSndLogVO[]
	 */
	public BkgCstmsKrSndLogVO[] getBkgCstmsKrSndLogVOs(){
		BkgCstmsKrSndLogVO[] vos = (BkgCstmsKrSndLogVO[])models.toArray(new BkgCstmsKrSndLogVO[models.size()]);
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
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.resndChk = this.resndChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuCnt = this.teuCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subNo = this.subNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrCd = this.corrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa = this.ktPa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feuCnt = this.feuCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blKnt = this.blKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlTpCd = this.trsmCxlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlRsnCd = this.trsmCxlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmCxlDesc = this.trsmCxlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndSeq = this.mfSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
