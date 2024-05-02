/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UpdateCargoTrackingDataVO.java
*@FileTitle : UpdateCargoTrackingDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.09.24 전병석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo;

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
 * @author 전병석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UpdateCargoTrackingDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UpdateCargoTrackingDataVO> models = new ArrayList<UpdateCargoTrackingDataVO>();
	
	/* Column Info */
	private String nod = null;
	/* Column Info */
	private String callFrom = null;
	/* Column Info */
	private String custSts = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String ibflg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String dist = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UpdateCargoTrackingDataVO() {}

	public UpdateCargoTrackingDataVO(String ibflag, String pagerows, String dist, String bkgNo, String bkgNoSplit, String cntrNo, String ediSts, String nod, String eventDt, String callFrom, String custSts, String usrId, String ibflg) {
		this.nod = nod;
		this.callFrom = callFrom;
		this.custSts = custSts;
		this.bkgNoSplit = bkgNoSplit;
		this.pagerows = pagerows;
		this.eventDt = eventDt;
		this.ibflg = ibflg;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ediSts = ediSts;
		this.usrId = usrId;
		this.cntrNo = cntrNo;
		this.dist = dist;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nod", getNod());
		this.hashColumns.put("call_from", getCallFrom());
		this.hashColumns.put("cust_sts", getCustSts());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("ibflg", getIbflg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("dist", getDist());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nod", "nod");
		this.hashFields.put("call_from", "callFrom");
		this.hashFields.put("cust_sts", "custSts");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("ibflg", "ibflg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dist", "dist");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nod
	 */
	public String getNod() {
		return this.nod;
	}
	
	/**
	 * Column Info
	 * @return callFrom
	 */
	public String getCallFrom() {
		return this.callFrom;
	}
	
	/**
	 * Column Info
	 * @return custSts
	 */
	public String getCustSts() {
		return this.custSts;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
	}
	
	/**
	 * Column Info
	 * @return ibflg
	 */
	public String getIbflg() {
		return this.ibflg;
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
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return dist
	 */
	public String getDist() {
		return this.dist;
	}
	

	/**
	 * Column Info
	 * @param nod
	 */
	public void setNod(String nod) {
		this.nod = nod;
	}
	
	/**
	 * Column Info
	 * @param callFrom
	 */
	public void setCallFrom(String callFrom) {
		this.callFrom = callFrom;
	}
	
	/**
	 * Column Info
	 * @param custSts
	 */
	public void setCustSts(String custSts) {
		this.custSts = custSts;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
	}
	
	/**
	 * Column Info
	 * @param ibflg
	 */
	public void setIbflg(String ibflg) {
		this.ibflg = ibflg;
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
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param dist
	 */
	public void setDist(String dist) {
		this.dist = dist;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNod(JSPUtil.getParameter(request, "nod", ""));
		setCallFrom(JSPUtil.getParameter(request, "call_from", ""));
		setCustSts(JSPUtil.getParameter(request, "cust_sts", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEventDt(JSPUtil.getParameter(request, "event_dt", ""));
		setIbflg(JSPUtil.getParameter(request, "ibflg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setDist(JSPUtil.getParameter(request, "dist", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UpdateCargoTrackingDataVO[]
	 */
	public UpdateCargoTrackingDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UpdateCargoTrackingDataVO[]
	 */
	public UpdateCargoTrackingDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UpdateCargoTrackingDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nod = (JSPUtil.getParameter(request, prefix	+ "nod", length));
			String[] callFrom = (JSPUtil.getParameter(request, prefix	+ "call_from", length));
			String[] custSts = (JSPUtil.getParameter(request, prefix	+ "cust_sts", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] ibflg = (JSPUtil.getParameter(request, prefix	+ "ibflg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] dist = (JSPUtil.getParameter(request, prefix	+ "dist", length));
			
			for (int i = 0; i < length; i++) {
				model = new UpdateCargoTrackingDataVO();
				if (nod[i] != null)
					model.setNod(nod[i]);
				if (callFrom[i] != null)
					model.setCallFrom(callFrom[i]);
				if (custSts[i] != null)
					model.setCustSts(custSts[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (ibflg[i] != null)
					model.setIbflg(ibflg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (dist[i] != null)
					model.setDist(dist[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUpdateCargoTrackingDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UpdateCargoTrackingDataVO[]
	 */
	public UpdateCargoTrackingDataVO[] getUpdateCargoTrackingDataVOs(){
		UpdateCargoTrackingDataVO[] vos = (UpdateCargoTrackingDataVO[])models.toArray(new UpdateCargoTrackingDataVO[models.size()]);
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
		this.nod = this.nod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callFrom = this.callFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSts = this.custSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflg = this.ibflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dist = this.dist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
