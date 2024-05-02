/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairExpensePlanINVO.java
*@FileTitle : RepairExpensePlanINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.07.06 정영훈 
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
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairExpensePlanINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RepairExpensePlanINVO> models = new ArrayList<RepairExpensePlanINVO>();
	
	/* Column Info */
	private String mnrPlnYr = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrPlnOfcCd = null;
	/* Column Info */
	private String hoofc = null;
	/* Column Info */
	private String delall = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String mnrPlnFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String mnrOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RepairExpensePlanINVO() {}

	public RepairExpensePlanINVO(String ibflag, String pagerows, String mnrPlnYr, String creUsrId, String creDt, String hoofc, String mnrPlnOfcCd, String ctrlOfcCd, String mnrPlnFlg, String delall, String ofcTpCd, String mnrOfcCd) {
		this.mnrPlnYr = mnrPlnYr;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creDt = creDt;
		this.mnrPlnOfcCd = mnrPlnOfcCd;
		this.hoofc = hoofc;
		this.delall = delall;
		this.ctrlOfcCd = ctrlOfcCd;
		this.mnrPlnFlg = mnrPlnFlg;
		this.pagerows = pagerows;
		this.ofcTpCd = ofcTpCd;
		this.mnrOfcCd = mnrOfcCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_pln_yr", getMnrPlnYr());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_pln_ofc_cd", getMnrPlnOfcCd());
		this.hashColumns.put("hoofc", getHoofc());
		this.hashColumns.put("delall", getDelall());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("mnr_pln_flg", getMnrPlnFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("mnr_ofc_cd", getMnrOfcCd());

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
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_pln_ofc_cd", "mnrPlnOfcCd");
		this.hashFields.put("hoofc", "hoofc");
		this.hashFields.put("delall", "delall");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("mnr_pln_flg", "mnrPlnFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("mnr_ofc_cd", "mnrOfcCd");
		
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return hoofc
	 */
	public String getHoofc() {
		return this.hoofc;
	}
	
	/**
	 * Column Info
	 * @return delall
	 */
	public String getDelall() {
		return this.delall;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mnrPlnFlg
	 */
	public String getMnrPlnFlg() {
		return this.mnrPlnFlg;
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
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrOfcCd
	 */
	public String getMnrOfcCd() {
		return this.mnrOfcCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param hoofc
	 */
	public void setHoofc(String hoofc) {
		this.hoofc = hoofc;
	}
	
	/**
	 * Column Info
	 * @param delall
	 */
	public void setDelall(String delall) {
		this.delall = delall;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mnrPlnFlg
	 */
	public void setMnrPlnFlg(String mnrPlnFlg) {
		this.mnrPlnFlg = mnrPlnFlg;
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
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrOfcCd
	 */
	public void setMnrOfcCd(String mnrOfcCd) {
		this.mnrOfcCd = mnrOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrPlnYr(JSPUtil.getParameter(request, "mnr_pln_yr", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrPlnOfcCd(JSPUtil.getParameter(request, "mnr_pln_ofc_cd", ""));
		setHoofc(JSPUtil.getParameter(request, "hoofc", ""));
		setDelall(JSPUtil.getParameter(request, "delall", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setMnrPlnFlg(JSPUtil.getParameter(request, "mnr_pln_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcTpCd(JSPUtil.getParameter(request, "ofc_tp_cd", ""));
		setMnrOfcCd(JSPUtil.getParameter(request, "mnr_ofc_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RepairExpensePlanINVO[]
	 */
	public RepairExpensePlanINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RepairExpensePlanINVO[]
	 */
	public RepairExpensePlanINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RepairExpensePlanINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrPlnYr = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_yr", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrPlnOfcCd = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_ofc_cd", length));
			String[] hoofc = (JSPUtil.getParameter(request, prefix	+ "hoofc", length));
			String[] delall = (JSPUtil.getParameter(request, prefix	+ "delall", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] mnrPlnFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_pln_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] mnrOfcCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ofc_cd", length));

			for (int i = 0; i < length; i++) {
				model = new RepairExpensePlanINVO();
				if (mnrPlnYr[i] != null)
					model.setMnrPlnYr(mnrPlnYr[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrPlnOfcCd[i] != null)
					model.setMnrPlnOfcCd(mnrPlnOfcCd[i]);
				if (hoofc[i] != null)
					model.setHoofc(hoofc[i]);
				if (delall[i] != null)
					model.setDelall(delall[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (mnrPlnFlg[i] != null)
					model.setMnrPlnFlg(mnrPlnFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (mnrOfcCd[i] != null)
					model.setMnrOfcCd(mnrOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRepairExpensePlanINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RepairExpensePlanINVO[]
	 */
	public RepairExpensePlanINVO[] getRepairExpensePlanINVOs(){
		RepairExpensePlanINVO[] vos = (RepairExpensePlanINVO[])models.toArray(new RepairExpensePlanINVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnOfcCd = this.mnrPlnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hoofc = this.hoofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delall = this.delall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPlnFlg = this.mnrPlnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOfcCd = this.mnrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
