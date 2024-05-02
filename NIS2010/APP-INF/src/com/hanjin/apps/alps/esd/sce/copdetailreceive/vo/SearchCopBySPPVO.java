/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchCopBySPPVO.java
*@FileTitle : SearchCopBySPPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.11 김성일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;

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
 * @author 김성일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchCopBySPPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCopBySPPVO> models = new ArrayList<SearchCopBySPPVO>();
	
	/* Column Info */
	private String inActDatRcvDt = null;
	/* Column Info */
	private String inActDt = null;
	/* Column Info */
	private String inActStsMapgCd = null;
	/* Column Info */
	private String inActRcvTpCd = null;
	/* Column Info */
	private String copNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inCntrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inNodCd = null;
	/* Column Info */
	private String inActRcvNo = null;
	/* Column Info */
	private String inActRcvDt = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String inActCd = null;
	/* Column Info */
	private String inUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCopBySPPVO() {}

	public SearchCopBySPPVO(String ibflag, String pagerows, String copNo, String inActRcvDt, String inActRcvNo, String inNodCd, String inCntrNo, String inBkgNo, String inActRcvTpCd, String inActStsMapgCd, String inActCd, String inActDt, String inUsrId, String inActDatRcvDt) {
		this.inActDatRcvDt = inActDatRcvDt;
		this.inActDt = inActDt;
		this.inActStsMapgCd = inActStsMapgCd;
		this.inActRcvTpCd = inActRcvTpCd;
		this.copNo = copNo;
		this.pagerows = pagerows;
		this.inCntrNo = inCntrNo;
		this.ibflag = ibflag;
		this.inNodCd = inNodCd;
		this.inActRcvNo = inActRcvNo;
		this.inActRcvDt = inActRcvDt;
		this.inBkgNo = inBkgNo;
		this.inActCd = inActCd;
		this.inUsrId = inUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_act_dat_rcv_dt", getInActDatRcvDt());
		this.hashColumns.put("in_act_dt", getInActDt());
		this.hashColumns.put("in_act_sts_mapg_cd", getInActStsMapgCd());
		this.hashColumns.put("in_act_rcv_tp_cd", getInActRcvTpCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_nod_cd", getInNodCd());
		this.hashColumns.put("in_act_rcv_no", getInActRcvNo());
		this.hashColumns.put("in_act_rcv_dt", getInActRcvDt());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("in_act_cd", getInActCd());
		this.hashColumns.put("in_usr_id", getInUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_act_dat_rcv_dt", "inActDatRcvDt");
		this.hashFields.put("in_act_dt", "inActDt");
		this.hashFields.put("in_act_sts_mapg_cd", "inActStsMapgCd");
		this.hashFields.put("in_act_rcv_tp_cd", "inActRcvTpCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_nod_cd", "inNodCd");
		this.hashFields.put("in_act_rcv_no", "inActRcvNo");
		this.hashFields.put("in_act_rcv_dt", "inActRcvDt");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("in_act_cd", "inActCd");
		this.hashFields.put("in_usr_id", "inUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inActDatRcvDt
	 */
	public String getInActDatRcvDt() {
		return this.inActDatRcvDt;
	}
	
	/**
	 * Column Info
	 * @return inActDt
	 */
	public String getInActDt() {
		return this.inActDt;
	}
	
	/**
	 * Column Info
	 * @return inActStsMapgCd
	 */
	public String getInActStsMapgCd() {
		return this.inActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return inActRcvTpCd
	 */
	public String getInActRcvTpCd() {
		return this.inActRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
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
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
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
	 * @return inNodCd
	 */
	public String getInNodCd() {
		return this.inNodCd;
	}
	
	/**
	 * Column Info
	 * @return inActRcvNo
	 */
	public String getInActRcvNo() {
		return this.inActRcvNo;
	}
	
	/**
	 * Column Info
	 * @return inActRcvDt
	 */
	public String getInActRcvDt() {
		return this.inActRcvDt;
	}
	
	/**
	 * Column Info
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}
	
	/**
	 * Column Info
	 * @return inActCd
	 */
	public String getInActCd() {
		return this.inActCd;
	}
	
	/**
	 * Column Info
	 * @return inUsrId
	 */
	public String getInUsrId() {
		return this.inUsrId;
	}
	

	/**
	 * Column Info
	 * @param inActDatRcvDt
	 */
	public void setInActDatRcvDt(String inActDatRcvDt) {
		this.inActDatRcvDt = inActDatRcvDt;
	}
	
	/**
	 * Column Info
	 * @param inActDt
	 */
	public void setInActDt(String inActDt) {
		this.inActDt = inActDt;
	}
	
	/**
	 * Column Info
	 * @param inActStsMapgCd
	 */
	public void setInActStsMapgCd(String inActStsMapgCd) {
		this.inActStsMapgCd = inActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param inActRcvTpCd
	 */
	public void setInActRcvTpCd(String inActRcvTpCd) {
		this.inActRcvTpCd = inActRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
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
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
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
	 * @param inNodCd
	 */
	public void setInNodCd(String inNodCd) {
		this.inNodCd = inNodCd;
	}
	
	/**
	 * Column Info
	 * @param inActRcvNo
	 */
	public void setInActRcvNo(String inActRcvNo) {
		this.inActRcvNo = inActRcvNo;
	}
	
	/**
	 * Column Info
	 * @param inActRcvDt
	 */
	public void setInActRcvDt(String inActRcvDt) {
		this.inActRcvDt = inActRcvDt;
	}
	
	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}
	
	/**
	 * Column Info
	 * @param inActCd
	 */
	public void setInActCd(String inActCd) {
		this.inActCd = inActCd;
	}
	
	/**
	 * Column Info
	 * @param inUsrId
	 */
	public void setInUsrId(String inUsrId) {
		this.inUsrId = inUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setInActDatRcvDt(JSPUtil.getParameter(request, "in_act_dat_rcv_dt", ""));
		setInActDt(JSPUtil.getParameter(request, "in_act_dt", ""));
		setInActStsMapgCd(JSPUtil.getParameter(request, "in_act_sts_mapg_cd", ""));
		setInActRcvTpCd(JSPUtil.getParameter(request, "in_act_rcv_tp_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInNodCd(JSPUtil.getParameter(request, "in_nod_cd", ""));
		setInActRcvNo(JSPUtil.getParameter(request, "in_act_rcv_no", ""));
		setInActRcvDt(JSPUtil.getParameter(request, "in_act_rcv_dt", ""));
		setInBkgNo(JSPUtil.getParameter(request, "in_bkg_no", ""));
		setInActCd(JSPUtil.getParameter(request, "in_act_cd", ""));
		setInUsrId(JSPUtil.getParameter(request, "in_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCopBySPPVO[]
	 */
	public SearchCopBySPPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCopBySPPVO[]
	 */
	public SearchCopBySPPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCopBySPPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inActDatRcvDt = (JSPUtil.getParameter(request, prefix	+ "in_act_dat_rcv_dt", length));
			String[] inActDt = (JSPUtil.getParameter(request, prefix	+ "in_act_dt", length));
			String[] inActStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "in_act_sts_mapg_cd", length));
			String[] inActRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "in_act_rcv_tp_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inNodCd = (JSPUtil.getParameter(request, prefix	+ "in_nod_cd", length));
			String[] inActRcvNo = (JSPUtil.getParameter(request, prefix	+ "in_act_rcv_no", length));
			String[] inActRcvDt = (JSPUtil.getParameter(request, prefix	+ "in_act_rcv_dt", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] inActCd = (JSPUtil.getParameter(request, prefix	+ "in_act_cd", length));
			String[] inUsrId = (JSPUtil.getParameter(request, prefix	+ "in_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCopBySPPVO();
				if (inActDatRcvDt[i] != null)
					model.setInActDatRcvDt(inActDatRcvDt[i]);
				if (inActDt[i] != null)
					model.setInActDt(inActDt[i]);
				if (inActStsMapgCd[i] != null)
					model.setInActStsMapgCd(inActStsMapgCd[i]);
				if (inActRcvTpCd[i] != null)
					model.setInActRcvTpCd(inActRcvTpCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inNodCd[i] != null)
					model.setInNodCd(inNodCd[i]);
				if (inActRcvNo[i] != null)
					model.setInActRcvNo(inActRcvNo[i]);
				if (inActRcvDt[i] != null)
					model.setInActRcvDt(inActRcvDt[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (inActCd[i] != null)
					model.setInActCd(inActCd[i]);
				if (inUsrId[i] != null)
					model.setInUsrId(inUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCopBySPPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCopBySPPVO[]
	 */
	public SearchCopBySPPVO[] getSearchCopBySPPVOs(){
		SearchCopBySPPVO[] vos = (SearchCopBySPPVO[])models.toArray(new SearchCopBySPPVO[models.size()]);
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
		this.inActDatRcvDt = this.inActDatRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActDt = this.inActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActStsMapgCd = this.inActStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActRcvTpCd = this.inActRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inNodCd = this.inNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActRcvNo = this.inActRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActRcvDt = this.inActRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActCd = this.inActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsrId = this.inUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
