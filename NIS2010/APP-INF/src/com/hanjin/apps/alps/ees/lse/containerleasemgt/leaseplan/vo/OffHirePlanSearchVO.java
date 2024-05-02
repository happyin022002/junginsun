/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOffHirePlanVO.java
*@FileTitle : SearchOffHirePlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 오봉현
*@LastVersion : 1.0
* 2009.06.02 오봉현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 오봉현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OffHirePlanSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OffHirePlanSearchVO> models = new ArrayList<OffHirePlanSearchVO>();
	
	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.vo");
	
	/* Column Info */
	private String offhPlnTpCd = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String offhVerSeq = null;
	/* Column Info */
	private String cntrTpszCd = null; 
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String offhRgnLocCd = null;
	/* Column Info */
	private String offhLocTpCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String offhYrmon = null;
	/* Column Info */
	private String fromOffhYrmon = null;
	/* Column Info */
	private String toOffhYrmon = null;
	/* Column Info */
	private String locTp = null;
	/* Column Info */
	private String locCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * Constructor
	 */
	public OffHirePlanSearchVO() {}

	/**
	 * Constructor
	 */
	public OffHirePlanSearchVO(String offhPlnTpCd, String plnYr, String offhVerSeq, String cntrTpszCd, String lstmCd, String offhRgnLocCd, String offhLocTpCd
			                 , String usrId, String offhYrmon, String fromOffhYrmon, String toOffhYrmon, String locTp, String locCd) {
		this.offhPlnTpCd = offhPlnTpCd;
		this.plnYr = plnYr;
		this.offhVerSeq = offhVerSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.lstmCd = lstmCd;
		this.offhRgnLocCd = offhRgnLocCd;
		this.offhLocTpCd = offhLocTpCd;
		this.usrId = usrId;
		this.offhYrmon = offhYrmon;
		this.fromOffhYrmon = fromOffhYrmon;
		this.toOffhYrmon = toOffhYrmon;
		this.locTp = locTp;
		this.locCd = locCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("offh_pln_tp_cd", getOffhPlnTpCd());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("offh_ver_seq", getOffhVerSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("offh_rgn_loc_cd", getOffhRgnLocCd());
		this.hashColumns.put("offh_loc_tp_cd", getOffhLocTpCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("offh_yrmon", getOffhYrmon().replaceAll("-", ""));
		this.hashColumns.put("from_offh_yrmon", getFromOffhYrmon().replaceAll("-", ""));
		this.hashColumns.put("to_offh_yrmon", getToOffhYrmon().replaceAll("-", ""));
		this.hashColumns.put("loc_tp", getLocTp());
		this.hashColumns.put("loc_cd", getLocCd());
		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("offh_pln_tp_cd", "offhPlnTpCd");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("offh_ver_seq", "offhVerSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("offh_rgn_loc_cd", "offhRgnLocCd");
		this.hashFields.put("offh_loc_tp_cd", "offhLocTpCd");
		this.hashColumns.put("usr_id", usrId);
		this.hashColumns.put("offh_yrmon", offhYrmon);
		this.hashColumns.put("from_offh_yrmon", fromOffhYrmon);
		this.hashColumns.put("to_offh_yrmon", toOffhYrmon);
		this.hashColumns.put("loc_tp", locTp);
		this.hashColumns.put("loc_cd", locCd);

		return this.hashFields;
	}
	
	public String getOffhPlnTpCd() {
		return offhPlnTpCd;
	}
	public String getPlnYr() {
		return this.plnYr;
	}
	public String getOffhVerSeq() {
		return offhVerSeq;
	}
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}
	public String getLstmCd() {
		return lstmCd;
	}
	public String getOffhRgnLocCd() {
		return offhRgnLocCd;
	}
	public String getOffhLocTpCd() {
		return offhLocTpCd;
	}
	public String getUsrId() {
		return usrId;
	}
	public String getOffhYrmon() {
		return offhYrmon;
	}
	public String getFromOffhYrmon() {
		return fromOffhYrmon;
	}
	public String getToOffhYrmon() {
		return toOffhYrmon;
	}
	public String getLocTp() {
		return locTp;
	}
	public String getLocCd() {
		return locCd;
	}
	public void setOffhPlnTpCd(String offhPlnTpCd) {
		this.offhPlnTpCd = offhPlnTpCd;
	}
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	public void setOffhVerSeq(String offhVerSeq) {
		this.offhVerSeq = offhVerSeq;
	}
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	public void setOffhRgnLocCd(String offhRgnLocCd) {
		this.offhRgnLocCd = offhRgnLocCd;
	}
	public void setOffhLocTpCd(String offhLocTpCd) {
		this.offhLocTpCd = offhLocTpCd;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public void setOffhYrmon(String offhYrmon) {
		this.offhYrmon = offhYrmon;
	}
	public void setFromOffhYrmon(String fromOffhYrmon) {
		this.fromOffhYrmon = fromOffhYrmon;
	}
	public void setToOffhYrmon(String toOffhYrmon) {
		this.toOffhYrmon = toOffhYrmon;
	}
	public void setLocTp(String locTp) {
		this.locTp = locTp;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffhPlnTpCd(JSPUtil.getParameter(request, "offh_pln_tp_cd", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setOffhVerSeq(JSPUtil.getParameter(request, "offh_ver_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setOffhRgnLocCd(JSPUtil.getParameter(request, "offh_rgn_loc_cd", ""));
		setOffhLocTpCd(JSPUtil.getParameter(request, "offh_loc_tp_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setOffhYrmon(JSPUtil.getParameter(request, "offh_yrmon", ""));
		setFromOffhYrmon(JSPUtil.getParameter(request, "from_offh_yrmon", ""));
		setToOffhYrmon(JSPUtil.getParameter(request, "to_offh_yrmon", ""));
		setLocTp(JSPUtil.getParameter(request, "loc_tp", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public OffHirePlanSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public OffHirePlanSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OffHirePlanSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] offhPlnTpCd = (JSPUtil.getParameter(request, prefix	+ "offh_pln_tp_cd".trim(), length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr".trim(), length));
			String[] offhVerSeq = (JSPUtil.getParameter(request, prefix	+ "offh_ver_seq".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd".trim(), length));
			String[] offhRgnLocCd = (JSPUtil.getParameter(request, prefix	+ "offh_rgn_loc_cd".trim(), length));
			String[] offhLocTpCd = (JSPUtil.getParameter(request, prefix	+ "offh_loc_tp_cd".trim(), length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id".trim(), length));
			String[] offhYrmon = (JSPUtil.getParameter(request, prefix	+ "offh_yrmon".trim(), length));
			String[] fromOffhYrmon = (JSPUtil.getParameter(request, prefix	+ "from_offh_yrmon".trim(), length));
			String[] toOffhYrmon = (JSPUtil.getParameter(request, prefix	+ "to_offh_yrmon".trim(), length));
			String[] locTp = (JSPUtil.getParameter(request, prefix	+ "loc_tp".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new OffHirePlanSearchVO();
				if (offhPlnTpCd[i] != null)
					model.setOffhPlnTpCd(offhPlnTpCd[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (offhVerSeq[i] != null)
					model.setOffhVerSeq(offhVerSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (offhRgnLocCd[i] != null)
					model.setOffhRgnLocCd(offhRgnLocCd[i]);
				if (offhLocTpCd[i] != null)
					model.setOffhLocTpCd(offhLocTpCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (offhYrmon[i] != null)
					model.setOffhYrmon(offhYrmon[i]);

				if (fromOffhYrmon[i] != null)
					model.setFromOffhYrmon(fromOffhYrmon[i]);
				if (toOffhYrmon[i] != null)
					model.setToOffhYrmon(toOffhYrmon[i]);
				if (locTp[i] != null)
					model.setLocTp(locTp[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getSearchOffHirePlanVOs();
	}

	public OffHirePlanSearchVO[] getSearchOffHirePlanVOs(){
		OffHirePlanSearchVO[] vos = (OffHirePlanSearchVO[])models.toArray(new OffHirePlanSearchVO[models.size()]);
		return vos;
	}
	
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
			log.error(ex.getMessage(), ex);
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.offhPlnTpCd = this.offhPlnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhVerSeq = this.offhVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhRgnLocCd = this.offhRgnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhLocTpCd = this.offhLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhYrmon = this.offhYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromOffhYrmon = this.fromOffhYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOffhYrmon = this.toOffhYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp = this.locTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}