/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PodComboVO.java
*@FileTitle : PodComboVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.06.23 우지석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

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
 * @author 우지석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PodComboVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PodComboVO> models = new ArrayList<PodComboVO>();
	
	/* Column Info remark*/
	private String vslCd = null;
	/* Column Info */
	private String cntrSzCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String intgCdId = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String wgp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrWgtGrpCd = null;
	/* Column Info */
	private String cntrGrsWgt = null;
	/* Column Info */
	private String vslOprTpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String intgCdValCtnt = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String val = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String fullMtyCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PodComboVO() {}

	public PodComboVO(String ibflag, String pagerows, String vslCd, String cntrSzCd, String skdVoyNo, String skdDirCd, String intgCdId, String podCd, String wgp, String ydCd, String cntrWgtGrpCd, String cntrGrsWgt, String cntrTpszCd, String intgCdValCtnt, String vslOprTpCd, String name, String val, String cntrQty, String fullMtyCd) {
		this.vslCd = vslCd;
		this.cntrSzCd = cntrSzCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.intgCdId = intgCdId;
		this.podCd = podCd;
		this.wgp = wgp;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.cntrWgtGrpCd = cntrWgtGrpCd;
		this.cntrGrsWgt = cntrGrsWgt;
		this.vslOprTpCd = vslOprTpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.intgCdValCtnt = intgCdValCtnt;
		this.name = name;
		this.val = val;
		this.cntrQty = cntrQty;
		this.fullMtyCd = fullMtyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("intg_cd_id", getIntgCdId());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("wgp", getWgp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_wgt_grp_cd", getCntrWgtGrpCd());
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());
		this.hashColumns.put("vsl_opr_tp_cd", getVslOprTpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("intg_cd_val_ctnt", getIntgCdValCtnt());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("val", getVal());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("full_mty_cd", getFullMtyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("intg_cd_id", "intgCdId");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("wgp", "wgp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_wgt_grp_cd", "cntrWgtGrpCd");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("vsl_opr_tp_cd", "vslOprTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("intg_cd_val_ctnt", "intgCdValCtnt");
		this.hashFields.put("name", "name");
		this.hashFields.put("val", "val");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("full_mty_cd", "fullMtyCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public String getCntrSzCd() {
		return this.cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return wgp
	 */
	public String getWgp() {
		return this.wgp;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtGrpCd
	 */
	public String getCntrWgtGrpCd() {
		return this.cntrWgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrGrsWgt
	 */
	public String getCntrGrsWgt() {
		return this.cntrGrsWgt;
	}
	
	/**
	 * Column Info
	 * @return vslOprTpCd
	 */
	public String getVslOprTpCd() {
		return this.vslOprTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return intgCdValCtnt
	 */
	public String getIntgCdValCtnt() {
		return this.intgCdValCtnt;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Column Info
	 * @return val
	 */
	public String getVal() {
		return this.val;
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
	 * @return fullMtyCd
	 */
	public String getFullMtyCd() {
		return this.fullMtyCd;
	}

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSzCd
	 */
	public void setCntrSzCd(String cntrSzCd) {
		this.cntrSzCd = cntrSzCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param wgp
	 */
	public void setWgp(String wgp) {
		this.wgp = wgp;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtGrpCd
	 */
	public void setCntrWgtGrpCd(String cntrWgtGrpCd) {
		this.cntrWgtGrpCd = cntrWgtGrpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrGrsWgt
	 */
	public void setCntrGrsWgt(String cntrGrsWgt) {
		this.cntrGrsWgt = cntrGrsWgt;
	}
	
	/**
	 * Column Info
	 * @param vslOprTpCd
	 */
	public void setVslOprTpCd(String vslOprTpCd) {
		this.vslOprTpCd = vslOprTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param intgCdValCtnt
	 */
	public void setIntgCdValCtnt(String intgCdValCtnt) {
		this.intgCdValCtnt = intgCdValCtnt;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Column Info
	 * @param name
	 */
	public void setVal(String val) {
		this.val = val;
	}

	/**
	 * Column Info
	 * @param name
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}

	/**
	 * Column Info
	 * @param name
	 */
	public void setFullMtyCd(String fullMtyCd) {
		this.fullMtyCd = fullMtyCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCntrSzCd(JSPUtil.getParameter(request, "cntr_sz_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIntgCdId(JSPUtil.getParameter(request, "intg_cd_id", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setWgp(JSPUtil.getParameter(request, "wgp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCntrWgtGrpCd(JSPUtil.getParameter(request, "cntr_wgt_grp_cd", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request, "cntr_grs_wgt", ""));
		setVslOprTpCd(JSPUtil.getParameter(request, "vsl_opr_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setIntgCdValCtnt(JSPUtil.getParameter(request, "intg_cd_val_ctnt", ""));
		setName(JSPUtil.getParameter(request, "name", ""));
		setVal(JSPUtil.getParameter(request, "val", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setFullMtyCd(JSPUtil.getParameter(request, "full_mty_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PodComboVO[]
	 */
	public PodComboVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PodComboVO[]
	 */
	public PodComboVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PodComboVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] intgCdId = (JSPUtil.getParameter(request, prefix	+ "intg_cd_id", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] wgp = (JSPUtil.getParameter(request, prefix	+ "wgp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrWgtGrpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_grp_cd", length));
			String[] cntrGrsWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_grs_wgt", length));
			String[] vslOprTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_opr_tp_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] intgCdValCtnt = (JSPUtil.getParameter(request, prefix	+ "intg_cd_val_ctnt", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] val = (JSPUtil.getParameter(request, prefix	+ "val", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] fullMtyCd = (JSPUtil.getParameter(request, prefix	+ "full_mty_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PodComboVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrSzCd[i] != null)
					model.setCntrSzCd(cntrSzCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (intgCdId[i] != null)
					model.setIntgCdId(intgCdId[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (wgp[i] != null)
					model.setWgp(wgp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrWgtGrpCd[i] != null)
					model.setCntrWgtGrpCd(cntrWgtGrpCd[i]);
				if (cntrWgtGrpCd[i] != null)
					model.setCntrGrsWgt(cntrGrsWgt[i]);
				if (vslOprTpCd[i] != null)
					model.setVslOprTpCd(vslOprTpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (intgCdValCtnt[i] != null)
					model.setIntgCdValCtnt(intgCdValCtnt[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (val[i] != null)
					model.setVal(val[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (fullMtyCd[i] != null)
					model.setFullMtyCd(fullMtyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPodComboVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PodComboVO[]
	 */
	public PodComboVO[] getPodComboVOs(){
		PodComboVO[] vos = (PodComboVO[])models.toArray(new PodComboVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd = this.cntrSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdId = this.intgCdId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgp = this.wgp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtGrpCd = this.cntrWgtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt = this.cntrGrsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslOprTpCd = this.vslOprTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intgCdValCtnt = this.intgCdValCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullMtyCd = this.fullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
