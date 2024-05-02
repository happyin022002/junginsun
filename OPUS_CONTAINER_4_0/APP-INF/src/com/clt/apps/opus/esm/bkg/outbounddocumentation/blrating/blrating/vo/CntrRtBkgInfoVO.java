/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRtBkgInfoVO.java
*@FileTitle : CntrRtBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.09.10 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrRtBkgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrRtBkgInfoVO> models = new ArrayList<CntrRtBkgInfoVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String rtBlTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mstCvrdBlNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cneeNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String contractNo = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String pstRlyPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrRtBkgInfoVO() {}

	public CntrRtBkgInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String vvd, String porCd, String polCd, String podCd, String delCd, String preRlyPortCd, String pstRlyPortCd, String contractNo, String cstmsDesc, String mstCvrdBlNo, String rtAplyDt, String rtBlTpCd, String shprCd, String shprNm, String cneeCd, String cneeNm, String creUsrId, String updUsrId) {
		this.cneeCd = cneeCd;
		this.porCd = porCd;
		this.preRlyPortCd = preRlyPortCd;
		this.rtAplyDt = rtAplyDt;
		this.rtBlTpCd = rtBlTpCd;
		this.delCd = delCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.mstCvrdBlNo = mstCvrdBlNo;
		this.vvd = vvd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.cneeNm = cneeNm;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.cstmsDesc = cstmsDesc;
		this.contractNo = contractNo;
		this.shprNm = shprNm;
		this.updUsrId = updUsrId;
		this.shprCd = shprCd;
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("rt_bl_tp_cd", getRtBlTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mst_cvrd_bl_no", getMstCvrdBlNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("contract_no", getContractNo());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("rt_bl_tp_cd", "rtBlTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mst_cvrd_bl_no", "mstCvrdBlNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("contract_no", "contractNo");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return rtBlTpCd
	 */
	public String getRtBlTpCd() {
		return this.rtBlTpCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return mstCvrdBlNo
	 */
	public String getMstCvrdBlNo() {
		return this.mstCvrdBlNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return contractNo
	 */
	public String getContractNo() {
		return this.contractNo;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
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
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	

	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param rtBlTpCd
	 */
	public void setRtBlTpCd(String rtBlTpCd) {
		this.rtBlTpCd = rtBlTpCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param mstCvrdBlNo
	 */
	public void setMstCvrdBlNo(String mstCvrdBlNo) {
		this.mstCvrdBlNo = mstCvrdBlNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param contractNo
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
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
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCneeCd(JSPUtil.getParameter(request, "cnee_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, "rt_aply_dt", ""));
		setRtBlTpCd(JSPUtil.getParameter(request, "rt_bl_tp_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMstCvrdBlNo(JSPUtil.getParameter(request, "mst_cvrd_bl_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setContractNo(JSPUtil.getParameter(request, "contract_no", ""));
		setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setShprCd(JSPUtil.getParameter(request, "shpr_cd", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrRtBkgInfoVO[]
	 */
	public CntrRtBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrRtBkgInfoVO[]
	 */
	public CntrRtBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrRtBkgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] rtBlTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_bl_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mstCvrdBlNo = (JSPUtil.getParameter(request, prefix	+ "mst_cvrd_bl_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] contractNo = (JSPUtil.getParameter(request, prefix	+ "contract_no", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrRtBkgInfoVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (rtBlTpCd[i] != null)
					model.setRtBlTpCd(rtBlTpCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mstCvrdBlNo[i] != null)
					model.setMstCvrdBlNo(mstCvrdBlNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (contractNo[i] != null)
					model.setContractNo(contractNo[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrRtBkgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrRtBkgInfoVO[]
	 */
	public CntrRtBkgInfoVO[] getCntrRtBkgInfoVOs(){
		CntrRtBkgInfoVO[] vos = (CntrRtBkgInfoVO[])models.toArray(new CntrRtBkgInfoVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBlTpCd = this.rtBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstCvrdBlNo = this.mstCvrdBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contractNo = this.contractNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
