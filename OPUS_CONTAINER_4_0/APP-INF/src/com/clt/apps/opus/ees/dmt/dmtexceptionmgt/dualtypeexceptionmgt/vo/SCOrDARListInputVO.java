/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCOrDARListInputVO.java
*@FileTitle : SCOrDARListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.dualtypeexceptionmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCOrDARListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCOrDARListInputVO> models = new ArrayList<SCOrDARListInputVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String dmdtCntrCgoTpCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String intgCdId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String dmdtCtrtExptTpCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String code2 = null;
	/* Column Info */
	private String code1 = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String steCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCOrDARListInputVO() {}

	public SCOrDARListInputVO(String ibflag, String pagerows, String custCd, String dmdtCtrtExptTpCd, String effDt, String expDt, String ioBndCd, String cntCd, String rgnCd, String steCd, String locCd, String dmdtCntrCgoTpCd, String intgCdId, String code1, String code2) {
		this.rgnCd = rgnCd;
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.intgCdId = intgCdId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.locCd = locCd;
		this.dmdtCtrtExptTpCd = dmdtCtrtExptTpCd;
		this.custCd = custCd;
		this.cntCd = cntCd;
		this.code2 = code2;
		this.code1 = code1;
		this.expDt = expDt;
		this.steCd = steCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("dmdt_cntr_cgo_tp_cd", getDmdtCntrCgoTpCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("intg_cd_id", getIntgCdId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("dmdt_ctrt_expt_tp_cd", getDmdtCtrtExptTpCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("code2", getCode2());
		this.hashColumns.put("code1", getCode1());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ste_cd", getSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("dmdt_cntr_cgo_tp_cd", "dmdtCntrCgoTpCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("intg_cd_id", "intgCdId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("dmdt_ctrt_expt_tp_cd", "dmdtCtrtExptTpCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("code2", "code2");
		this.hashFields.put("code1", "code1");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ste_cd", "steCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrCgoTpCd
	 */
	public String getDmdtCntrCgoTpCd() {
		return this.dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return intgCdId
	 */
	public String getIntgCdId() {
		return this.intgCdId;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCtrtExptTpCd
	 */
	public String getDmdtCtrtExptTpCd() {
		return this.dmdtCtrtExptTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return code2
	 */
	public String getCode2() {
		return this.code2;
	}
	
	/**
	 * Column Info
	 * @return code1
	 */
	public String getCode1() {
		return this.code1;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	

	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrCgoTpCd
	 */
	public void setDmdtCntrCgoTpCd(String dmdtCntrCgoTpCd) {
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param intgCdId
	 */
	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCtrtExptTpCd
	 */
	public void setDmdtCtrtExptTpCd(String dmdtCtrtExptTpCd) {
		this.dmdtCtrtExptTpCd = dmdtCtrtExptTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param code2
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	
	/**
	 * Column Info
	 * @param code1
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setDmdtCntrCgoTpCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIntgCdId(JSPUtil.getParameter(request, "intg_cd_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setDmdtCtrtExptTpCd(JSPUtil.getParameter(request, "dmdt_ctrt_expt_tp_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCode2(JSPUtil.getParameter(request, "code2", ""));
		setCode1(JSPUtil.getParameter(request, "code1", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCOrDARListInputVO[]
	 */
	public SCOrDARListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCOrDARListInputVO[]
	 */
	public SCOrDARListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCOrDARListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] dmdtCntrCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] intgCdId = (JSPUtil.getParameter(request, prefix	+ "intg_cd_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] dmdtCtrtExptTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ctrt_expt_tp_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] code2 = (JSPUtil.getParameter(request, prefix	+ "code2", length));
			String[] code1 = (JSPUtil.getParameter(request, prefix	+ "code1", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCOrDARListInputVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (dmdtCntrCgoTpCd[i] != null)
					model.setDmdtCntrCgoTpCd(dmdtCntrCgoTpCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (intgCdId[i] != null)
					model.setIntgCdId(intgCdId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (dmdtCtrtExptTpCd[i] != null)
					model.setDmdtCtrtExptTpCd(dmdtCtrtExptTpCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (code2[i] != null)
					model.setCode2(code2[i]);
				if (code1[i] != null)
					model.setCode1(code1[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCOrDARListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCOrDARListInputVO[]
	 */
	public SCOrDARListInputVO[] getSCOrDARListInputVOs(){
		SCOrDARListInputVO[] vos = (SCOrDARListInputVO[])models.toArray(new SCOrDARListInputVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpCd = this.dmdtCntrCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdId = this.intgCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCtrtExptTpCd = this.dmdtCtrtExptTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code2 = this.code2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code1 = this.code1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
