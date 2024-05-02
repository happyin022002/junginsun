/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkganDestOfcStupVO.java
*@FileTitle : BkganDestOfcStupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.29 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkganDestOfcStupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkganDestOfcStupVO> models = new ArrayList<BkganDestOfcStupVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String pHndlOfcCd = null;
	/* Column Info */
	private String ntcEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String destOfcCntcCd = null;
	/* Column Info */
	private String pEqCtrlOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkganDestOfcStupVO() {}

	public BkganDestOfcStupVO(String ibflag, String pagerows, String eqCtrlOfcCd, String hndlOfcCd, String destOfcCntcCd, String phnNo, String ntcEml, String diffRmk, String updUsrId, String pEqCtrlOfcCd, String pHndlOfcCd) {
		this.phnNo = phnNo;
		this.pHndlOfcCd = pHndlOfcCd;
		this.ntcEml = ntcEml;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.destOfcCntcCd = destOfcCntcCd;
		this.pEqCtrlOfcCd = pEqCtrlOfcCd;
		this.updUsrId = updUsrId;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("p_hndl_ofc_cd", getPHndlOfcCd());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("dest_ofc_cntc_cd", getDestOfcCntcCd());
		this.hashColumns.put("p_eq_ctrl_ofc_cd", getPEqCtrlOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("p_hndl_ofc_cd", "pHndlOfcCd");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("dest_ofc_cntc_cd", "destOfcCntcCd");
		this.hashFields.put("p_eq_ctrl_ofc_cd", "pEqCtrlOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return pHndlOfcCd
	 */
	public String getPHndlOfcCd() {
		return this.pHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return destOfcCntcCd
	 */
	public String getDestOfcCntcCd() {
		return this.destOfcCntcCd;
	}
	
	/**
	 * Column Info
	 * @return pEqCtrlOfcCd
	 */
	public String getPEqCtrlOfcCd() {
		return this.pEqCtrlOfcCd;
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
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param pHndlOfcCd
	 */
	public void setPHndlOfcCd(String pHndlOfcCd) {
		this.pHndlOfcCd = pHndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param destOfcCntcCd
	 */
	public void setDestOfcCntcCd(String destOfcCntcCd) {
		this.destOfcCntcCd = destOfcCntcCd;
	}
	
	/**
	 * Column Info
	 * @param pEqCtrlOfcCd
	 */
	public void setPEqCtrlOfcCd(String pEqCtrlOfcCd) {
		this.pEqCtrlOfcCd = pEqCtrlOfcCd;
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
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setPHndlOfcCd(JSPUtil.getParameter(request, "p_hndl_ofc_cd", ""));
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, "eq_ctrl_ofc_cd", ""));
		setDestOfcCntcCd(JSPUtil.getParameter(request, "dest_ofc_cntc_cd", ""));
		setPEqCtrlOfcCd(JSPUtil.getParameter(request, "p_eq_ctrl_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkganDestOfcStupVO[]
	 */
	public BkganDestOfcStupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkganDestOfcStupVO[]
	 */
	public BkganDestOfcStupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkganDestOfcStupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] pHndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_hndl_ofc_cd", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] destOfcCntcCd = (JSPUtil.getParameter(request, prefix	+ "dest_ofc_cntc_cd", length));
			String[] pEqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_eq_ctrl_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkganDestOfcStupVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (pHndlOfcCd[i] != null)
					model.setPHndlOfcCd(pHndlOfcCd[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (destOfcCntcCd[i] != null)
					model.setDestOfcCntcCd(destOfcCntcCd[i]);
				if (pEqCtrlOfcCd[i] != null)
					model.setPEqCtrlOfcCd(pEqCtrlOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkganDestOfcStupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkganDestOfcStupVO[]
	 */
	public BkganDestOfcStupVO[] getBkganDestOfcStupVOs(){
		BkganDestOfcStupVO[] vos = (BkganDestOfcStupVO[])models.toArray(new BkganDestOfcStupVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pHndlOfcCd = this.pHndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destOfcCntcCd = this.destOfcCntcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pEqCtrlOfcCd = this.pEqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
