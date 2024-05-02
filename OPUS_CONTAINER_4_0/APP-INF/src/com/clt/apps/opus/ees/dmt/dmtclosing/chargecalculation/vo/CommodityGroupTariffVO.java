/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommodityGroupTariffVO.java
*@FileTitle : CommodityGroupTariffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.18 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommodityGroupTariffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommodityGroupTariffVO> models = new ArrayList<CommodityGroupTariffVO>();
	
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cmdtOvrDys = null;
	/* Column Info */
	private String cmdtExptAplyDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlDys = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String addDys = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String cmdtExptAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommodityGroupTariffVO() {}

	public CommodityGroupTariffVO(String ibflag, String pagerows, String addDys, String ttlDys, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String repCmdtCd, String cmdtExptAplyDt, String cmdtCd, String cmdtOvrDys, String currCd, String cmdtExptAmt) {
		this.xcldSatFlg = xcldSatFlg;
		this.xcldSunFlg = xcldSunFlg;
		this.currCd = currCd;
		this.cmdtOvrDys = cmdtOvrDys;
		this.cmdtExptAplyDt = cmdtExptAplyDt;
		this.pagerows = pagerows;
		this.ttlDys = ttlDys;
		this.ibflag = ibflag;
		this.addDys = addDys;
		this.cmdtCd = cmdtCd;
		this.xcldHolFlg = xcldHolFlg;
		this.repCmdtCd = repCmdtCd;
		this.cmdtExptAmt = cmdtExptAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cmdt_ovr_dys", getCmdtOvrDys());
		this.hashColumns.put("cmdt_expt_aply_dt", getCmdtExptAplyDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_dys", getTtlDys());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("add_dys", getAddDys());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("cmdt_expt_amt", getCmdtExptAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cmdt_ovr_dys", "cmdtOvrDys");
		this.hashFields.put("cmdt_expt_aply_dt", "cmdtExptAplyDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_dys", "ttlDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("add_dys", "addDys");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("cmdt_expt_amt", "cmdtExptAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtOvrDys
	 */
	public String getCmdtOvrDys() {
		return this.cmdtOvrDys;
	}
	
	/**
	 * Column Info
	 * @return cmdtExptAplyDt
	 */
	public String getCmdtExptAplyDt() {
		return this.cmdtExptAplyDt;
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
	 * @return ttlDys
	 */
	public String getTtlDys() {
		return this.ttlDys;
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
	 * @return addDys
	 */
	public String getAddDys() {
		return this.addDys;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtExptAmt
	 */
	public String getCmdtExptAmt() {
		return this.cmdtExptAmt;
	}
	

	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtOvrDys
	 */
	public void setCmdtOvrDys(String cmdtOvrDys) {
		this.cmdtOvrDys = cmdtOvrDys;
	}
	
	/**
	 * Column Info
	 * @param cmdtExptAplyDt
	 */
	public void setCmdtExptAplyDt(String cmdtExptAplyDt) {
		this.cmdtExptAplyDt = cmdtExptAplyDt;
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
	 * @param ttlDys
	 */
	public void setTtlDys(String ttlDys) {
		this.ttlDys = ttlDys;
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
	 * @param addDys
	 */
	public void setAddDys(String addDys) {
		this.addDys = addDys;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtExptAmt
	 */
	public void setCmdtExptAmt(String cmdtExptAmt) {
		this.cmdtExptAmt = cmdtExptAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCmdtOvrDys(JSPUtil.getParameter(request, "cmdt_ovr_dys", ""));
		setCmdtExptAplyDt(JSPUtil.getParameter(request, "cmdt_expt_aply_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTtlDys(JSPUtil.getParameter(request, "ttl_dys", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAddDys(JSPUtil.getParameter(request, "add_dys", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setCmdtExptAmt(JSPUtil.getParameter(request, "cmdt_expt_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommodityGroupTariffVO[]
	 */
	public CommodityGroupTariffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommodityGroupTariffVO[]
	 */
	public CommodityGroupTariffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommodityGroupTariffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cmdtOvrDys = (JSPUtil.getParameter(request, prefix	+ "cmdt_ovr_dys", length));
			String[] cmdtExptAplyDt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_aply_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlDys = (JSPUtil.getParameter(request, prefix	+ "ttl_dys", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] addDys = (JSPUtil.getParameter(request, prefix	+ "add_dys", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] cmdtExptAmt = (JSPUtil.getParameter(request, prefix	+ "cmdt_expt_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommodityGroupTariffVO();
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cmdtOvrDys[i] != null)
					model.setCmdtOvrDys(cmdtOvrDys[i]);
				if (cmdtExptAplyDt[i] != null)
					model.setCmdtExptAplyDt(cmdtExptAplyDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlDys[i] != null)
					model.setTtlDys(ttlDys[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (addDys[i] != null)
					model.setAddDys(addDys[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (cmdtExptAmt[i] != null)
					model.setCmdtExptAmt(cmdtExptAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommodityGroupTariffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommodityGroupTariffVO[]
	 */
	public CommodityGroupTariffVO[] getCommodityGroupTariffVOs(){
		CommodityGroupTariffVO[] vos = (CommodityGroupTariffVO[])models.toArray(new CommodityGroupTariffVO[models.size()]);
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
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtOvrDys = this.cmdtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAplyDt = this.cmdtExptAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlDys = this.ttlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addDys = this.addDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtExptAmt = this.cmdtExptAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
