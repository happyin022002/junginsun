/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtOfcUsrTrfOptVO.java
*@FileTitle : DmtOfcUsrTrfOptVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class DmtOfcUsrTrfOptVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtOfcUsrTrfOptVO> models = new ArrayList<DmtOfcUsrTrfOptVO>();
	
	/* Column Info */
	private String detObFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String demIbFlg = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String cmbIbFlg = null;
	/* Column Info */
	private String allTrfTpFlg = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cmbObFlg = null;
	/* Column Info */
	private String detIbFlg = null;
	/* Column Info */
	private String demObFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String creUsrId = null;
	/* Page Number */
	private String updUsrId = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtOfcUsrTrfOptVO() {}

	public DmtOfcUsrTrfOptVO(String ibflag, String pagerows, String ofcCd, String usrId, String allTrfTpFlg, String demIbFlg, String demObFlg, String detIbFlg, String detObFlg, String cmbIbFlg, String cmbObFlg) {
		this.detObFlg = detObFlg;
		this.ofcCd = ofcCd;
		this.demIbFlg = demIbFlg;
		this.ibflag = ibflag;
		this.cmbIbFlg = cmbIbFlg;
		this.allTrfTpFlg = allTrfTpFlg;
		this.usrId = usrId;
		this.cmbObFlg = cmbObFlg;
		this.detIbFlg = detIbFlg;
		this.demObFlg = demObFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("det_ob_flg", getDetObFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("dem_ib_flg", getDemIbFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmb_ib_flg", getCmbIbFlg());
		this.hashColumns.put("all_trf_tp_flg", getAllTrfTpFlg());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cmb_ob_flg", getCmbObFlg());
		this.hashColumns.put("det_ib_flg", getDetIbFlg());
		this.hashColumns.put("dem_ob_flg", getDemObFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("det_ob_flg", "detObFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("dem_ib_flg", "demIbFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmb_ib_flg", "cmbIbFlg");
		this.hashFields.put("all_trf_tp_flg", "allTrfTpFlg");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cmb_ob_flg", "cmbObFlg");
		this.hashFields.put("det_ib_flg", "detIbFlg");
		this.hashFields.put("dem_ob_flg", "demObFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return detObFlg
	 */
	public String getDetObFlg() {
		return this.detObFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return demIbFlg
	 */
	public String getDemIbFlg() {
		return this.demIbFlg;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return cmbIbFlg
	 */
	public String getCmbIbFlg() {
		return this.cmbIbFlg;
	}
	
	/**
	 * Column Info
	 * @return allTrfTpFlg
	 */
	public String getAllTrfTpFlg() {
		return this.allTrfTpFlg;
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
	 * @return cmbObFlg
	 */
	public String getCmbObFlg() {
		return this.cmbObFlg;
	}
	
	/**
	 * Column Info
	 * @return detIbFlg
	 */
	public String getDetIbFlg() {
		return this.detIbFlg;
	}
	
	/**
	 * Column Info
	 * @return demObFlg
	 */
	public String getDemObFlg() {
		return this.demObFlg;
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
	 * @param detObFlg
	 */
	public void setDetObFlg(String detObFlg) {
		this.detObFlg = detObFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param demIbFlg
	 */
	public void setDemIbFlg(String demIbFlg) {
		this.demIbFlg = demIbFlg;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cmbIbFlg
	 */
	public void setCmbIbFlg(String cmbIbFlg) {
		this.cmbIbFlg = cmbIbFlg;
	}
	
	/**
	 * Column Info
	 * @param allTrfTpFlg
	 */
	public void setAllTrfTpFlg(String allTrfTpFlg) {
		this.allTrfTpFlg = allTrfTpFlg;
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
	 * @param cmbObFlg
	 */
	public void setCmbObFlg(String cmbObFlg) {
		this.cmbObFlg = cmbObFlg;
	}
	
	/**
	 * Column Info
	 * @param detIbFlg
	 */
	public void setDetIbFlg(String detIbFlg) {
		this.detIbFlg = detIbFlg;
	}
	
	/**
	 * Column Info
	 * @param demObFlg
	 */
	public void setDemObFlg(String demObFlg) {
		this.demObFlg = demObFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDetObFlg(JSPUtil.getParameter(request, "det_ob_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDemIbFlg(JSPUtil.getParameter(request, "dem_ib_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmbIbFlg(JSPUtil.getParameter(request, "cmb_ib_flg", ""));
		setAllTrfTpFlg(JSPUtil.getParameter(request, "all_trf_tp_flg", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCmbObFlg(JSPUtil.getParameter(request, "cmb_ob_flg", ""));
		setDetIbFlg(JSPUtil.getParameter(request, "det_ib_flg", ""));
		setDemObFlg(JSPUtil.getParameter(request, "dem_ob_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return DmtOfcUsrTrfOptVO[]
	 */
	public DmtOfcUsrTrfOptVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtOfcUsrTrfOptVO[]
	 */
	public DmtOfcUsrTrfOptVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtOfcUsrTrfOptVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] detObFlg = (JSPUtil.getParameter(request, prefix	+ "det_ob_flg".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] demIbFlg = (JSPUtil.getParameter(request, prefix	+ "dem_ib_flg".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cmbIbFlg = (JSPUtil.getParameter(request, prefix	+ "cmb_ib_flg".trim(), length));
			String[] allTrfTpFlg = (JSPUtil.getParameter(request, prefix	+ "all_trf_tp_flg".trim(), length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id".trim(), length));
			String[] cmbObFlg = (JSPUtil.getParameter(request, prefix	+ "cmb_ob_flg".trim(), length));
			String[] detIbFlg = (JSPUtil.getParameter(request, prefix	+ "det_ib_flg".trim(), length));
			String[] demObFlg = (JSPUtil.getParameter(request, prefix	+ "dem_ob_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtOfcUsrTrfOptVO();
				if (detObFlg[i] != null)
					model.setDetObFlg(detObFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (demIbFlg[i] != null)
					model.setDemIbFlg(demIbFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmbIbFlg[i] != null)
					model.setCmbIbFlg(cmbIbFlg[i]);
				if (allTrfTpFlg[i] != null)
					model.setAllTrfTpFlg(allTrfTpFlg[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cmbObFlg[i] != null)
					model.setCmbObFlg(cmbObFlg[i]);
				if (detIbFlg[i] != null)
					model.setDetIbFlg(detIbFlg[i]);
				if (demObFlg[i] != null)
					model.setDemObFlg(demObFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtOfcUsrTrfOptVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return DmtOfcUsrTrfOptVO[]
	 */
	public DmtOfcUsrTrfOptVO[] getDmtOfcUsrTrfOptVOs(){
		DmtOfcUsrTrfOptVO[] vos = (DmtOfcUsrTrfOptVO[])models.toArray(new DmtOfcUsrTrfOptVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.detObFlg = this.detObFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demIbFlg = this.demIbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbIbFlg = this.cmbIbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTrfTpFlg = this.allTrfTpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmbObFlg = this.cmbObFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detIbFlg = this.detIbFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demObFlg = this.demObFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
}
