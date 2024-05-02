/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgBayRcvMsgDtlVO.java
*@FileTitle : DgBayRcvMsgDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgBayRcvMsgDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgBayRcvMsgDtlVO> models = new ArrayList<DgBayRcvMsgDtlVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cellPsnNo = null;
	/* Column Info */
	private String isoCntrTpszCd = null;
	/* Column Info */
	private String bayPlnId = null;
	/* Column Info */
	private String eurDgCntrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String delCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cntrWgtUtCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String grsWgt = null;
	/* Column Info */
	private String eurDgFullMtyCd = null;
	/* Column Info */
	private String cntrOprId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DgBayRcvMsgDtlVO() {}

	public DgBayRcvMsgDtlVO(String ibflag, String pagerows, String bayPlnId, String eurDgCntrId, String cellPsnNo, String grsWgt, String cntrWgtUtCd, String isoCntrTpszCd, String polCd, String podCd, String delCd, String eurDgFullMtyCd, String cntrOprId, String imdgClssCd, String imdgUnNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.cellPsnNo = cellPsnNo;
		this.isoCntrTpszCd = isoCntrTpszCd;
		this.bayPlnId = bayPlnId;
		this.eurDgCntrId = eurDgCntrId;
		this.creDt = creDt;
		this.delCd = delCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cntrWgtUtCd = cntrWgtUtCd;
		this.updUsrId = updUsrId;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.grsWgt = grsWgt;
		this.eurDgFullMtyCd = eurDgFullMtyCd;
		this.cntrOprId = cntrOprId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cell_psn_no", getCellPsnNo());
		this.hashColumns.put("iso_cntr_tpsz_cd", getIsoCntrTpszCd());
		this.hashColumns.put("bay_pln_id", getBayPlnId());
		this.hashColumns.put("eur_dg_cntr_id", getEurDgCntrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cntr_wgt_ut_cd", getCntrWgtUtCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		this.hashColumns.put("eur_dg_full_mty_cd", getEurDgFullMtyCd());
		this.hashColumns.put("cntr_opr_id", getCntrOprId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cell_psn_no", "cellPsnNo");
		this.hashFields.put("iso_cntr_tpsz_cd", "isoCntrTpszCd");
		this.hashFields.put("bay_pln_id", "bayPlnId");
		this.hashFields.put("eur_dg_cntr_id", "eurDgCntrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_wgt_ut_cd", "cntrWgtUtCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("eur_dg_full_mty_cd", "eurDgFullMtyCd");
		this.hashFields.put("cntr_opr_id", "cntrOprId");
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
	 * @return cellPsnNo
	 */
	public String getCellPsnNo() {
		return this.cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @return isoCntrTpszCd
	 */
	public String getIsoCntrTpszCd() {
		return this.isoCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return bayPlnId
	 */
	public String getBayPlnId() {
		return this.bayPlnId;
	}
	
	/**
	 * Column Info
	 * @return eurDgCntrId
	 */
	public String getEurDgCntrId() {
		return this.eurDgCntrId;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntrWgtUtCd
	 */
	public String getCntrWgtUtCd() {
		return this.cntrWgtUtCd;
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
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
	}
	
	/**
	 * Column Info
	 * @return eurDgFullMtyCd
	 */
	public String getEurDgFullMtyCd() {
		return this.eurDgFullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntrOprId
	 */
	public String getCntrOprId() {
		return this.cntrOprId;
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
	 * @param cellPsnNo
	 */
	public void setCellPsnNo(String cellPsnNo) {
		this.cellPsnNo = cellPsnNo;
	}
	
	/**
	 * Column Info
	 * @param isoCntrTpszCd
	 */
	public void setIsoCntrTpszCd(String isoCntrTpszCd) {
		this.isoCntrTpszCd = isoCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param bayPlnId
	 */
	public void setBayPlnId(String bayPlnId) {
		this.bayPlnId = bayPlnId;
	}
	
	/**
	 * Column Info
	 * @param eurDgCntrId
	 */
	public void setEurDgCntrId(String eurDgCntrId) {
		this.eurDgCntrId = eurDgCntrId;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntrWgtUtCd
	 */
	public void setCntrWgtUtCd(String cntrWgtUtCd) {
		this.cntrWgtUtCd = cntrWgtUtCd;
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
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
	}
	
	/**
	 * Column Info
	 * @param eurDgFullMtyCd
	 */
	public void setEurDgFullMtyCd(String eurDgFullMtyCd) {
		this.eurDgFullMtyCd = eurDgFullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntrOprId
	 */
	public void setCntrOprId(String cntrOprId) {
		this.cntrOprId = cntrOprId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCellPsnNo(JSPUtil.getParameter(request, "cell_psn_no", ""));
		setIsoCntrTpszCd(JSPUtil.getParameter(request, "iso_cntr_tpsz_cd", ""));
		setBayPlnId(JSPUtil.getParameter(request, "bay_pln_id", ""));
		setEurDgCntrId(JSPUtil.getParameter(request, "eur_dg_cntr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCntrWgtUtCd(JSPUtil.getParameter(request, "cntr_wgt_ut_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, "grs_wgt", ""));
		setEurDgFullMtyCd(JSPUtil.getParameter(request, "eur_dg_full_mty_cd", ""));
		setCntrOprId(JSPUtil.getParameter(request, "cntr_opr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgBayRcvMsgDtlVO[]
	 */
	public DgBayRcvMsgDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgBayRcvMsgDtlVO[]
	 */
	public DgBayRcvMsgDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgBayRcvMsgDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cellPsnNo = (JSPUtil.getParameter(request, prefix	+ "cell_psn_no", length));
			String[] isoCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "iso_cntr_tpsz_cd", length));
			String[] bayPlnId = (JSPUtil.getParameter(request, prefix	+ "bay_pln_id", length));
			String[] eurDgCntrId = (JSPUtil.getParameter(request, prefix	+ "eur_dg_cntr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_ut_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			String[] eurDgFullMtyCd = (JSPUtil.getParameter(request, prefix	+ "eur_dg_full_mty_cd", length));
			String[] cntrOprId = (JSPUtil.getParameter(request, prefix	+ "cntr_opr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgBayRcvMsgDtlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cellPsnNo[i] != null)
					model.setCellPsnNo(cellPsnNo[i]);
				if (isoCntrTpszCd[i] != null)
					model.setIsoCntrTpszCd(isoCntrTpszCd[i]);
				if (bayPlnId[i] != null)
					model.setBayPlnId(bayPlnId[i]);
				if (eurDgCntrId[i] != null)
					model.setEurDgCntrId(eurDgCntrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cntrWgtUtCd[i] != null)
					model.setCntrWgtUtCd(cntrWgtUtCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				if (eurDgFullMtyCd[i] != null)
					model.setEurDgFullMtyCd(eurDgFullMtyCd[i]);
				if (cntrOprId[i] != null)
					model.setCntrOprId(cntrOprId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgBayRcvMsgDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgBayRcvMsgDtlVO[]
	 */
	public DgBayRcvMsgDtlVO[] getDgBayRcvMsgDtlVOs(){
		DgBayRcvMsgDtlVO[] vos = (DgBayRcvMsgDtlVO[])models.toArray(new DgBayRcvMsgDtlVO[models.size()]);
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
		this.cellPsnNo = this.cellPsnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCntrTpszCd = this.isoCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bayPlnId = this.bayPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgCntrId = this.eurDgCntrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUtCd = this.cntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurDgFullMtyCd = this.eurDgFullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOprId = this.cntrOprId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
