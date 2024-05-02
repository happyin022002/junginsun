/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TSRemainListInputVO.java
*@FileTitle : TSRemainListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.28 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSRemainListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TSRemainListInputVO> models = new ArrayList<TSRemainListInputVO>();
	
	/* Column Info */
	private String cnmvStsCds = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String locYdCd = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String cntrTpszCds = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TSRemainListInputVO() {}

	public TSRemainListInputVO(String ibflag, String pagerows, String locCd, String locYdCd, String vpsEtbDt, String vpsEtdDt, String vpsEtaDt, String nextVvd, String cnmvStsCds, String cntrTpszCds, String cntrQty) {
		this.cnmvStsCds = cnmvStsCds;
		this.vpsEtbDt = vpsEtbDt;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.vpsEtdDt = vpsEtdDt;
		this.locYdCd = locYdCd;
		this.nextVvd = nextVvd;
		this.cntrQty = cntrQty;
		this.cntrTpszCds = cntrTpszCds;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnmv_sts_cds", getCnmvStsCds());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("loc_yd_cd", getLocYdCd());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("cntr_tpsz_cds", getCntrTpszCds());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnmv_sts_cds", "cnmvStsCds");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("loc_yd_cd", "locYdCd");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("cntr_tpsz_cds", "cntrTpszCds");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCds
	 */
	public String getCnmvStsCds() {
		return this.cnmvStsCds;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return locYdCd
	 */
	public String getLocYdCd() {
		return this.locYdCd;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCds
	 */
	public String getCntrTpszCds() {
		return this.cntrTpszCds;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @param cnmvStsCds
	 */
	public void setCnmvStsCds(String cnmvStsCds) {
		this.cnmvStsCds = cnmvStsCds;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param locYdCd
	 */
	public void setLocYdCd(String locYdCd) {
		this.locYdCd = locYdCd;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCds
	 */
	public void setCntrTpszCds(String cntrTpszCds) {
		this.cntrTpszCds = cntrTpszCds;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
		setCnmvStsCds(JSPUtil.getParameter(request, "cnmv_sts_cds", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setLocYdCd(JSPUtil.getParameter(request, "loc_yd_cd", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setCntrTpszCds(JSPUtil.getParameter(request, "cntr_tpsz_cds", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSRemainListInputVO[]
	 */
	public TSRemainListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSRemainListInputVO[]
	 */
	public TSRemainListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSRemainListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnmvStsCds = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cds".trim(), length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt".trim(), length));
			String[] locYdCd = (JSPUtil.getParameter(request, prefix	+ "loc_yd_cd".trim(), length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd".trim(), length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty".trim(), length));
			String[] cntrTpszCds = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cds".trim(), length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TSRemainListInputVO();
				if (cnmvStsCds[i] != null)
					model.setCnmvStsCds(cnmvStsCds[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (locYdCd[i] != null)
					model.setLocYdCd(locYdCd[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (cntrTpszCds[i] != null)
					model.setCntrTpszCds(cntrTpszCds[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSRemainListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSRemainListInputVO[]
	 */
	public TSRemainListInputVO[] getTSRemainListInputVOs(){
		TSRemainListInputVO[] vos = (TSRemainListInputVO[])models.toArray(new TSRemainListInputVO[models.size()]);
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
		this.cnmvStsCds = this.cnmvStsCds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locYdCd = this.locYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCds = this.cntrTpszCds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
