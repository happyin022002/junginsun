/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalPlanINVO.java
*@FileTitle : DisposalPlanINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.08.31 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalPlanINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalPlanINVO> models = new ArrayList<DisposalPlanINVO>();
	
	/* Column Info */
	private String mnrPlnYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrPlnGrpNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String hoOfcCd = null;
	/* Column Info */
	private String mnrPlnOfcCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String cntrTpszCdSeq = null;
	/* Column Info */
	private String mnrPlnFlg = null;
	/* Column Info */
	private String mnrOfficeLevel = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalPlanINVO() {}

	public DisposalPlanINVO(String ibflag, String pagerows, String eqKndCd, String mnrPlnYr, String mnrPlnGrpNo, String creDt, String creUsrId, String mnrPlnFlg, String mnrPlnOfcCd, String cntrTpszCdSeq, String hoOfcCd, String mnrOfficeLevel) {
		this.mnrPlnYr = mnrPlnYr;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.mnrPlnGrpNo = mnrPlnGrpNo;
		this.creDt = creDt;
		this.hoOfcCd = hoOfcCd;
		this.mnrPlnOfcCd = mnrPlnOfcCd;
		this.eqKndCd = eqKndCd;
		this.cntrTpszCdSeq = cntrTpszCdSeq;
		this.mnrPlnFlg = mnrPlnFlg;
		this.mnrOfficeLevel = mnrOfficeLevel;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_pln_yr", getMnrPlnYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_pln_grp_no", getMnrPlnGrpNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ho_ofc_cd", getHoOfcCd());
		this.hashColumns.put("mnr_pln_ofc_cd", getMnrPlnOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("cntr_tpsz_cd_seq", getCntrTpszCdSeq());
		this.hashColumns.put("mnr_pln_flg", getMnrPlnFlg());
		this.hashColumns.put("mnr_office_level", getMnrOfficeLevel());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_pln_yr", "mnrPlnYr");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_pln_grp_no", "mnrPlnGrpNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ho_ofc_cd", "hoOfcCd");
		this.hashFields.put("mnr_pln_ofc_cd", "mnrPlnOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("cntr_tpsz_cd_seq", "cntrTpszCdSeq");
		this.hashFields.put("mnr_pln_flg", "mnrPlnFlg");
		this.hashFields.put("mnr_office_level", "mnrOfficeLevel");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnYr
	 */
	public String getMnrPlnYr() {
		return this.mnrPlnYr;
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
	 * @return mnrPlnGrpNo
	 */
	public String getMnrPlnGrpNo() {
		return this.mnrPlnGrpNo;
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
	 * @return hoOfcCd
	 */
	public String getHoOfcCd() {
		return this.hoOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnOfcCd
	 */
	public String getMnrPlnOfcCd() {
		return this.mnrPlnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdSeq
	 */
	public String getCntrTpszCdSeq() {
		return this.cntrTpszCdSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnFlg
	 */
	public String getMnrPlnFlg() {
		return this.mnrPlnFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrOfficeLevel
	 */
	public String getMnrOfficeLevel() {
		return this.mnrOfficeLevel;
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
	 * @param mnrPlnYr
	 */
	public void setMnrPlnYr(String mnrPlnYr) {
		this.mnrPlnYr = mnrPlnYr;
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
	 * @param mnrPlnGrpNo
	 */
	public void setMnrPlnGrpNo(String mnrPlnGrpNo) {
		this.mnrPlnGrpNo = mnrPlnGrpNo;
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
	 * @param hoOfcCd
	 */
	public void setHoOfcCd(String hoOfcCd) {
		this.hoOfcCd = hoOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnOfcCd
	 */
	public void setMnrPlnOfcCd(String mnrPlnOfcCd) {
		this.mnrPlnOfcCd = mnrPlnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdSeq
	 */
	public void setCntrTpszCdSeq(String cntrTpszCdSeq) {
		this.cntrTpszCdSeq = cntrTpszCdSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnFlg
	 */
	public void setMnrPlnFlg(String mnrPlnFlg) {
		this.mnrPlnFlg = mnrPlnFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrOfficeLevel
	 */
	public void setMnrOfficeLevel(String mnrOfficeLevel) {
		this.mnrOfficeLevel = mnrOfficeLevel;
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
		setMnrPlnYr(JSPUtil.getParameter(request, "mnr_pln_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrPlnGrpNo(JSPUtil.getParameter(request, "mnr_pln_grp_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setHoOfcCd(JSPUtil.getParameter(request, "ho_ofc_cd", ""));
		setMnrPlnOfcCd(JSPUtil.getParameter(request, "mnr_pln_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setCntrTpszCdSeq(JSPUtil.getParameter(request, "cntr_tpsz_cd_seq", ""));
		setMnrPlnFlg(JSPUtil.getParameter(request, "mnr_pln_flg", ""));
		setMnrOfficeLevel(JSPUtil.getParameter(request, "mnr_office_level", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalPlanINVO[]
	 */
	public DisposalPlanINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalPlanINVO[]
	 */
	public DisposalPlanINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalPlanINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrPlnYr = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrPlnGrpNo = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_grp_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] hoOfcCd = (JSPUtil.getParameter(request, prefix	+ "ho_ofc_cd", length));
			String[] mnrPlnOfcCd = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] cntrTpszCdSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_seq", length));
			String[] mnrPlnFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_flg", length));
			String[] mnrOfficeLevel = (JSPUtil.getParameter(request, prefix	+ "mnr_office_level", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalPlanINVO();
				if (mnrPlnYr[i] != null)
					model.setMnrPlnYr(mnrPlnYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrPlnGrpNo[i] != null)
					model.setMnrPlnGrpNo(mnrPlnGrpNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (hoOfcCd[i] != null)
					model.setHoOfcCd(hoOfcCd[i]);
				if (mnrPlnOfcCd[i] != null)
					model.setMnrPlnOfcCd(mnrPlnOfcCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (cntrTpszCdSeq[i] != null)
					model.setCntrTpszCdSeq(cntrTpszCdSeq[i]);
				if (mnrPlnFlg[i] != null)
					model.setMnrPlnFlg(mnrPlnFlg[i]);
				if (mnrOfficeLevel[i] != null)
					model.setMnrOfficeLevel(mnrOfficeLevel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalPlanINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalPlanINVO[]
	 */
	public DisposalPlanINVO[] getDisposalPlanINVOs(){
		DisposalPlanINVO[] vos = (DisposalPlanINVO[])models.toArray(new DisposalPlanINVO[models.size()]);
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
		this.mnrPlnYr = this.mnrPlnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnGrpNo = this.mnrPlnGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hoOfcCd = this.hoOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcCd = this.mnrPlnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdSeq = this.cntrTpszCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnFlg = this.mnrPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOfficeLevel = this.mnrOfficeLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
