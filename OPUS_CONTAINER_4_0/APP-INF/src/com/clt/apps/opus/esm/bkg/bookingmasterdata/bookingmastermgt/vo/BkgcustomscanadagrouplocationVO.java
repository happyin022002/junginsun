/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgcustomscanadagrouplocationVO.java
*@FileTitle : BkgcustomscanadagrouplocationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.07.01 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgcustomscanadagrouplocationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgcustomscanadagrouplocationVO> models = new ArrayList<BkgcustomscanadagrouplocationVO>();
	
	/* Column Info */
	private String gdsDesc = null;
	/* Column Info */
	private String cstmsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podDesc = null;
	/* Column Info */
	private String pHubLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String pPodCd = null;
	/* Column Info */
	private String delDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trspModId = null;
	/* Column Info */
	private String pDelCd = null;
	/* Column Info */
	private String hubDesc = null;
	/* Column Info */
	private String hubLocCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String gdsLocSeq = null;
	/* Column Info */
	private String podYdNo = null;
	/* Column Info */
	private String ydDesc = null;
	/* Column Info */
	private String podCdCpy = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgcustomscanadagrouplocationVO() {}

	public BkgcustomscanadagrouplocationVO(String ibflag, String pagerows, String podCd, String delCd, String hubLocCd, String trspModId, String gdsDesc, String cstmsCd, String podDesc, String delDesc, String hubDesc, String updUsrId, String pPodCd, String pDelCd, String pHubLocCd, String gdsLocSeq, String podYdNo, String ydDesc, String podCdCpy) {
		this.gdsDesc = gdsDesc;
		this.delCd = delCd;
		this.podDesc = podDesc;
		this.pHubLocCd = pHubLocCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.pPodCd = pPodCd;
		this.delDesc = delDesc;
		this.cstmsCd = cstmsCd;
		this.ibflag = ibflag;
		this.trspModId = trspModId;
		this.pDelCd = pDelCd;
		this.hubDesc = hubDesc;
		this.hubLocCd = hubLocCd;
		this.updUsrId = updUsrId;
		this.gdsLocSeq = gdsLocSeq;
		this.podYdNo = podYdNo;
		this.ydDesc = ydDesc;
		this.podCdCpy = podCdCpy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gds_desc", getGdsDesc());
		this.hashColumns.put("cstms_cd", getCstmsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_desc", getPodDesc());
		this.hashColumns.put("p_hub_loc_cd", getPHubLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("p_pod_cd", getPPodCd());
		this.hashColumns.put("del_desc", getDelDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_mod_id", getTrspModId());
		this.hashColumns.put("p_del_cd", getPDelCd());
		this.hashColumns.put("hub_desc", getHubDesc());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gds_loc_seq", getGdsLocSeq());
		this.hashColumns.put("pod_yd_no", getPodYdNo());
		this.hashColumns.put("yd_desc", getYdDesc());
		this.hashColumns.put("pod_cd_cpy", getPodCdCpy());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gds_desc", "gdsDesc");
		this.hashFields.put("cstms_cd", "cstmsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_desc", "podDesc");
		this.hashFields.put("p_hub_loc_cd", "pHubLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("p_pod_cd", "pPodCd");
		this.hashFields.put("del_desc", "delDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsp_mod_id", "trspModId");
		this.hashFields.put("p_del_cd", "pDelCd");
		this.hashFields.put("hub_desc", "hubDesc");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gds_loc_seq", "gdsLocSeq");
		this.hashFields.put("pod_yd_no", "podYdNo");
		this.hashFields.put("yd_desc", "ydDesc");
		this.hashFields.put("pod_cd_cpy", "podCdCpy");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return gdsDesc
	 */
	public String getGdsDesc() {
		return this.gdsDesc;
	}
	
	/**
	 * Column Info
	 * @return cstmsCd
	 */
	public String getCstmsCd() {
		return this.cstmsCd;
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
	 * @return podDesc
	 */
	public String getPodDesc() {
		return this.podDesc;
	}
	
	/**
	 * Column Info
	 * @return pHubLocCd
	 */
	public String getPHubLocCd() {
		return this.pHubLocCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return pPodCd
	 */
	public String getPPodCd() {
		return this.pPodCd;
	}
	
	/**
	 * Column Info
	 * @return delDesc
	 */
	public String getDelDesc() {
		return this.delDesc;
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
	 * @return trspModId
	 */
	public String getTrspModId() {
		return this.trspModId;
	}
	
	/**
	 * Column Info
	 * @return pDelCd
	 */
	public String getPDelCd() {
		return this.pDelCd;
	}
	
	/**
	 * Column Info
	 * @return hubDesc
	 */
	public String getHubDesc() {
		return this.hubDesc;
	}
	
	/**
	 * Column Info
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
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
	 * @return gdsLocSeq
	 */
	public String getGdsLocSeq() {
		return this.gdsLocSeq;
	}
	
	/**
	 * Column Info
	 * @return podYdNo
	 */
	public String getPodYdNo() {
		return this.podYdNo;
	}
	
	/**
	 * Column Info
	 * @return ydDesc
	 */
	public String getYdDesc() {
		return this.ydDesc;
	}
	
	/**
	 * Column Info
	 * @return podCdCpy
	 */
	public String getPodCdCpy() {
		return this.podCdCpy;
	}
	

	/**
	 * Column Info
	 * @param gdsDesc
	 */
	public void setGdsDesc(String gdsDesc) {
		this.gdsDesc = gdsDesc;
	}
	
	/**
	 * Column Info
	 * @param cstmsCd
	 */
	public void setCstmsCd(String cstmsCd) {
		this.cstmsCd = cstmsCd;
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
	 * @param podDesc
	 */
	public void setPodDesc(String podDesc) {
		this.podDesc = podDesc;
	}
	
	/**
	 * Column Info
	 * @param pHubLocCd
	 */
	public void setPHubLocCd(String pHubLocCd) {
		this.pHubLocCd = pHubLocCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param pPodCd
	 */
	public void setPPodCd(String pPodCd) {
		this.pPodCd = pPodCd;
	}
	
	/**
	 * Column Info
	 * @param delDesc
	 */
	public void setDelDesc(String delDesc) {
		this.delDesc = delDesc;
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
	 * @param trspModId
	 */
	public void setTrspModId(String trspModId) {
		this.trspModId = trspModId;
	}
	
	/**
	 * Column Info
	 * @param pDelCd
	 */
	public void setPDelCd(String pDelCd) {
		this.pDelCd = pDelCd;
	}
	
	/**
	 * Column Info
	 * @param hubDesc
	 */
	public void setHubDesc(String hubDesc) {
		this.hubDesc = hubDesc;
	}
	
	/**
	 * Column Info
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
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
	 * @param gdsLocSeq
	 */
	public void setGdsLocSeq(String gdsLocSeq) {
		this.gdsLocSeq = gdsLocSeq;
	}
	
	/**
	 * Column Info
	 * @param podYdNo
	 */
	public void setPodYdNo(String podYdNo) {
		this.podYdNo = podYdNo;
	}
	
	/**
	 * Column Info
	 * @param ydDesc
	 */
	public void setYdDesc(String ydDesc) {
		this.ydDesc = ydDesc;
	}
	
	/**
	 * Column Info
	 * @param podCdCpy
	 */
	public void setPodCdCpy(String podCdCpy) {
		this.podCdCpy = podCdCpy;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGdsDesc(JSPUtil.getParameter(request, "gds_desc", ""));
		setCstmsCd(JSPUtil.getParameter(request, "cstms_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPodDesc(JSPUtil.getParameter(request, "pod_desc", ""));
		setPHubLocCd(JSPUtil.getParameter(request, "p_hub_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPPodCd(JSPUtil.getParameter(request, "p_pod_cd", ""));
		setDelDesc(JSPUtil.getParameter(request, "del_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrspModId(JSPUtil.getParameter(request, "trsp_mod_id", ""));
		setPDelCd(JSPUtil.getParameter(request, "p_del_cd", ""));
		setHubDesc(JSPUtil.getParameter(request, "hub_desc", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setGdsLocSeq(JSPUtil.getParameter(request, "gds_loc_seq", ""));
		setPodYdNo(JSPUtil.getParameter(request, "pod_yd_no", ""));
		setYdDesc(JSPUtil.getParameter(request, "yd_desc", ""));
		setPodCdCpy(JSPUtil.getParameter(request, "pod_cd_cpy", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgcustomscanadagrouplocationVO[]
	 */
	public BkgcustomscanadagrouplocationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgcustomscanadagrouplocationVO[]
	 */
	public BkgcustomscanadagrouplocationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgcustomscanadagrouplocationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] gdsDesc = (JSPUtil.getParameter(request, prefix	+ "gds_desc".trim(), length));
			String[] cstmsCd = (JSPUtil.getParameter(request, prefix + "cstms_cd".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] podDesc = (JSPUtil.getParameter(request, prefix	+ "pod_desc".trim(), length));
			String[] pHubLocCd = (JSPUtil.getParameter(request, prefix	+ "p_hub_loc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] pPodCd = (JSPUtil.getParameter(request, prefix	+ "p_pod_cd".trim(), length));
			String[] delDesc = (JSPUtil.getParameter(request, prefix	+ "del_desc".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] trspModId = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_id".trim(), length));
			String[] pDelCd = (JSPUtil.getParameter(request, prefix	+ "p_del_cd".trim(), length));
			String[] hubDesc = (JSPUtil.getParameter(request, prefix	+ "hub_desc".trim(), length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] gdsLocSeq = (JSPUtil.getParameter(request, prefix	+ "gds_loc_seq".trim(), length));
			String[] podYdNo = (JSPUtil.getParameter(request, prefix	+ "pod_yd_no".trim(), length));
			String[] ydDesc = (JSPUtil.getParameter(request, prefix	+ "yd_desc".trim(), length));
			String[] podCdCpy = (JSPUtil.getParameter(request, prefix	+ "pod_cd_cpy".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgcustomscanadagrouplocationVO();
				if (gdsDesc[i] != null)
					model.setGdsDesc(gdsDesc[i]);
				if (cstmsCd[i] != null)
					model.setCstmsCd(cstmsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podDesc[i] != null)
					model.setPodDesc(podDesc[i]);
				if (pHubLocCd[i] != null)
					model.setPHubLocCd(pHubLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pPodCd[i] != null)
					model.setPPodCd(pPodCd[i]);
				if (delDesc[i] != null)
					model.setDelDesc(delDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trspModId[i] != null)
					model.setTrspModId(trspModId[i]);
				if (pDelCd[i] != null)
					model.setPDelCd(pDelCd[i]);
				if (hubDesc[i] != null)
					model.setHubDesc(hubDesc[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (gdsLocSeq[i] != null)
					model.setGdsLocSeq(gdsLocSeq[i]);
				if (podYdNo[i] != null)
					model.setPodYdNo(podYdNo[i]);
				if (ydDesc[i] != null)
					model.setYdDesc(ydDesc[i]);
				if (podCdCpy[i] != null)
					model.setPodCdCpy(podCdCpy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgcustomscanadagrouplocationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgcustomscanadagrouplocationVO[]
	 */
	public BkgcustomscanadagrouplocationVO[] getBkgcustomscanadagrouplocationVOs(){
		BkgcustomscanadagrouplocationVO[] vos = (BkgcustomscanadagrouplocationVO[])models.toArray(new BkgcustomscanadagrouplocationVO[models.size()]);
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
		this.gdsDesc = this.gdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsCd = this.cstmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDesc = this.podDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pHubLocCd = this.pHubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pPodCd = this.pPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDesc = this.delDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModId = this.trspModId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDelCd = this.pDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubDesc = this.hubDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdsLocSeq = this.gdsLocSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdNo = this.podYdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydDesc = this.ydDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCdCpy = this.podCdCpy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
