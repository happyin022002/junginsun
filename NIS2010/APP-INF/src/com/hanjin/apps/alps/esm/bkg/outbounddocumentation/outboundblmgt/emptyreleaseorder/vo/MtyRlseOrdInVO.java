/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyRlseOrdInVO.java
*@FileTitle : MtyRlseOrdInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.17 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyRlseOrdInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyRlseOrdInVO> models = new ArrayList<MtyRlseOrdInVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String piType = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String endDt2 = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fromDt2 = null;
	/* Column Info */
	private String eqConfirm = null;
	/* Column Info */
	private String emptyFullChk = null;
	/* Column Info */
	private String datetype = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyRlseOrdInVO() {}

	public MtyRlseOrdInVO(String ibflag, String pagerows, String datetype, String fromDt, String endDt, String bkgOfcCd, String docUsrId, String eqCtrlOfcCd, String vvd, String porCd, String polCd, String podCd, String mtyPkupYdCd, String fullRtnYdCd, String bkgNo, String piType, String fromDt2, String emptyFullChk, String eqConfirm, String endDt2) {
		this.bkgOfcCd = bkgOfcCd;
		this.porCd = porCd;
		this.fromDt = fromDt;
		this.piType = piType;
		this.docUsrId = docUsrId;
		this.endDt = endDt;
		this.endDt2 = endDt2;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.fullRtnYdCd = fullRtnYdCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.fromDt2 = fromDt2;
		this.eqConfirm = eqConfirm;
		this.emptyFullChk = emptyFullChk;
		this.datetype = datetype;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("pi_type", getPiType());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("end_dt2", getEndDt2());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("from_dt2", getFromDt2());
		this.hashColumns.put("eq_confirm", getEqConfirm());
		this.hashColumns.put("empty_full_chk", getEmptyFullChk());
		this.hashColumns.put("datetype", getDatetype());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("pi_type", "piType");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("end_dt2", "endDt2");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("from_dt2", "fromDt2");
		this.hashFields.put("eq_confirm", "eqConfirm");
		this.hashFields.put("empty_full_chk", "emptyFullChk");
		this.hashFields.put("datetype", "datetype");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return piType
	 */
	public String getPiType() {
		return this.piType;
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
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return endDt2
	 */
	public String getEndDt2() {
		return this.endDt2;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return fromDt2
	 */
	public String getFromDt2() {
		return this.fromDt2;
	}
	
	/**
	 * Column Info
	 * @return eqConfirm
	 */
	public String getEqConfirm() {
		return this.eqConfirm;
	}
	
	/**
	 * Column Info
	 * @return emptyFullChk
	 */
	public String getEmptyFullChk() {
		return this.emptyFullChk;
	}
	
	/**
	 * Column Info
	 * @return datetype
	 */
	public String getDatetype() {
		return this.datetype;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param piType
	 */
	public void setPiType(String piType) {
		this.piType = piType;
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
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param endDt2
	 */
	public void setEndDt2(String endDt2) {
		this.endDt2 = endDt2;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param fromDt2
	 */
	public void setFromDt2(String fromDt2) {
		this.fromDt2 = fromDt2;
	}
	
	/**
	 * Column Info
	 * @param eqConfirm
	 */
	public void setEqConfirm(String eqConfirm) {
		this.eqConfirm = eqConfirm;
	}
	
	/**
	 * Column Info
	 * @param emptyFullChk
	 */
	public void setEmptyFullChk(String emptyFullChk) {
		this.emptyFullChk = emptyFullChk;
	}
	
	/**
	 * Column Info
	 * @param datetype
	 */
	public void setDatetype(String datetype) {
		this.datetype = datetype;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setPiType(JSPUtil.getParameter(request, "pi_type", ""));
		setDocUsrId(JSPUtil.getParameter(request, "doc_usr_id", ""));
		setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
		setEndDt2(JSPUtil.getParameter(request, "end_dt2", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, "eq_ctrl_ofc_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, "mty_pkup_yd_cd", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, "full_rtn_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setFromDt2(JSPUtil.getParameter(request, "from_dt2", ""));
		setEqConfirm(JSPUtil.getParameter(request, "eq_confirm", ""));
		setEmptyFullChk(JSPUtil.getParameter(request, "empty_full_chk", ""));
		setDatetype(JSPUtil.getParameter(request, "datetype", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdInVO[]
	 */
	public MtyRlseOrdInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdInVO[]
	 */
	public MtyRlseOrdInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyRlseOrdInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] piType = (JSPUtil.getParameter(request, prefix	+ "pi_type", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] endDt2 = (JSPUtil.getParameter(request, prefix	+ "end_dt2", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fromDt2 = (JSPUtil.getParameter(request, prefix	+ "from_dt2", length));
			String[] eqConfirm = (JSPUtil.getParameter(request, prefix	+ "eq_confirm", length));
			String[] emptyFullChk = (JSPUtil.getParameter(request, prefix	+ "empty_full_chk", length));
			String[] datetype = (JSPUtil.getParameter(request, prefix	+ "datetype", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyRlseOrdInVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (piType[i] != null)
					model.setPiType(piType[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (endDt2[i] != null)
					model.setEndDt2(endDt2[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fromDt2[i] != null)
					model.setFromDt2(fromDt2[i]);
				if (eqConfirm[i] != null)
					model.setEqConfirm(eqConfirm[i]);
				if (emptyFullChk[i] != null)
					model.setEmptyFullChk(emptyFullChk[i]);
				if (datetype[i] != null)
					model.setDatetype(datetype[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyRlseOrdInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyRlseOrdInVO[]
	 */
	public MtyRlseOrdInVO[] getMtyRlseOrdInVOs(){
		MtyRlseOrdInVO[] vos = (MtyRlseOrdInVO[])models.toArray(new MtyRlseOrdInVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.piType = this.piType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDt2 = this.endDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt2 = this.fromDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqConfirm = this.eqConfirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyFullChk = this.emptyFullChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.datetype = this.datetype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
