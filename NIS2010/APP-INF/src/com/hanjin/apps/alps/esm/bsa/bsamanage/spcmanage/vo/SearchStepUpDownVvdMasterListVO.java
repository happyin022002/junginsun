/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchStepUpDownVvdMasterListVO.java
*@FileTitle : SearchStepUpDownVvdMasterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.10.05 남궁진호 
* 1.0 Creation
* 
* 2016.01.29 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.spcmanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchStepUpDownVvdMasterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchStepUpDownVvdMasterListVO> models = new ArrayList<SearchStepUpDownVvdMasterListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bsaOpNm = null;
	/* Column Info */
	private String vopCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String portBsaCfmFlg = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vslCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bsaCapa = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsaOpJbCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String portBsaCapa = null;
	/* Column Info */
	private String stupFlg = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String costYrwk = null;
	/* Column Info */
	private String mnlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchStepUpDownVvdMasterListVO() {}

	public SearchStepUpDownVvdMasterListVO(String ibflag, String pagerows, String costYrwk, String subTrdCd, String slanCd, String trdCd, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String bsaOpCd, String bsaOpNm, String iocCd, String vopCd, String vslCapa, String bsaCapa, String portBsaCapa, String crrCd, String bsaOpJbCd, String stupFlg, String portBsaCfmFlg, String mnlFlg) {
		this.iocCd = iocCd;
		this.vslCd = vslCd;
		this.bsaOpNm = bsaOpNm;
		this.vopCd = vopCd;
		this.trdCd = trdCd;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.portBsaCfmFlg = portBsaCfmFlg;
		this.crrCd = crrCd;
		this.skdDirCd = skdDirCd;
		this.vslCapa = vslCapa;
		this.pagerows = pagerows;
		this.bsaCapa = bsaCapa;
		this.ibflag = ibflag;
		this.bsaOpJbCd = bsaOpJbCd;
		this.slanCd = slanCd;
		this.portBsaCapa = portBsaCapa;
		this.stupFlg = stupFlg;
		this.bsaOpCd = bsaOpCd;
		this.subTrdCd = subTrdCd;
		this.costYrwk = costYrwk;
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bsa_op_nm", getBsaOpNm());
		this.hashColumns.put("vop_cd", getVopCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("port_bsa_cfm_flg", getPortBsaCfmFlg());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vsl_capa", getVslCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa_op_jb_cd", getBsaOpJbCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("port_bsa_capa", getPortBsaCapa());
		this.hashColumns.put("stup_flg", getStupFlg());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("cost_yrwk", getCostYrwk());
		this.hashColumns.put("mnl_flg", getMnlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bsa_op_nm", "bsaOpNm");
		this.hashFields.put("vop_cd", "vopCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("port_bsa_cfm_flg", "portBsaCfmFlg");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vsl_capa", "vslCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa_op_jb_cd", "bsaOpJbCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("port_bsa_capa", "portBsaCapa");
		this.hashFields.put("stup_flg", "stupFlg");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("cost_yrwk", "costYrwk");
		this.hashFields.put("mnl_flg", "mnlFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
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
	 * @return bsaOpNm
	 */
	public String getBsaOpNm() {
		return this.bsaOpNm;
	}
	
	/**
	 * Column Info
	 * @return vopCd
	 */
	public String getVopCd() {
		return this.vopCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return portBsaCfmFlg
	 */
	public String getPortBsaCfmFlg() {
		return this.portBsaCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vslCapa
	 */
	public String getVslCapa() {
		return this.vslCapa;
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
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
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
	 * @return bsaOpJbCd
	 */
	public String getBsaOpJbCd() {
		return this.bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return portBsaCapa
	 */
	public String getPortBsaCapa() {
		return this.portBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return stupFlg
	 */
	public String getStupFlg() {
		return this.stupFlg;
	}
	
	/**
	 * Column Info
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return costYrwk
	 */
	public String getCostYrwk() {
		return this.costYrwk;
	}
	
	/**
	 * Column Info
	 * @return costYrwk
	 */
	public String getMnlFlg() {
		return this.mnlFlg;
	}
	

	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
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
	 * @param bsaOpNm
	 */
	public void setBsaOpNm(String bsaOpNm) {
		this.bsaOpNm = bsaOpNm;
	}
	
	/**
	 * Column Info
	 * @param vopCd
	 */
	public void setVopCd(String vopCd) {
		this.vopCd = vopCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param portBsaCfmFlg
	 */
	public void setPortBsaCfmFlg(String portBsaCfmFlg) {
		this.portBsaCfmFlg = portBsaCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vslCapa
	 */
	public void setVslCapa(String vslCapa) {
		this.vslCapa = vslCapa;
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
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
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
	 * @param bsaOpJbCd
	 */
	public void setBsaOpJbCd(String bsaOpJbCd) {
		this.bsaOpJbCd = bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param portBsaCapa
	 */
	public void setPortBsaCapa(String portBsaCapa) {
		this.portBsaCapa = portBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param stupFlg
	 */
	public void setStupFlg(String stupFlg) {
		this.stupFlg = stupFlg;
	}
	
	/**
	 * Column Info
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param costYrwk
	 */
	public void setCostYrwk(String costYrwk) {
		this.costYrwk = costYrwk;
	}

	/**
	 * Column Info
	 * @param mnlFlg
	 */
	public void setMnlFlg(String mnlFlg) {
		this.mnlFlg = mnlFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBsaOpNm(JSPUtil.getParameter(request, "bsa_op_nm", ""));
		setVopCd(JSPUtil.getParameter(request, "vop_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPortBsaCfmFlg(JSPUtil.getParameter(request, "port_bsa_cfm_flg", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setVslCapa(JSPUtil.getParameter(request, "vsl_capa", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsaOpJbCd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setPortBsaCapa(JSPUtil.getParameter(request, "port_bsa_capa", ""));
		setStupFlg(JSPUtil.getParameter(request, "stup_flg", ""));
		setBsaOpCd(JSPUtil.getParameter(request, "bsa_op_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setCostYrwk(JSPUtil.getParameter(request, "cost_yrwk", ""));
		setMnlFlg(JSPUtil.getParameter(request, "mnl_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchStepUpDownVvdMasterListVO[]
	 */
	public SearchStepUpDownVvdMasterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchStepUpDownVvdMasterListVO[]
	 */
	public SearchStepUpDownVvdMasterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchStepUpDownVvdMasterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bsaOpNm = (JSPUtil.getParameter(request, prefix	+ "bsa_op_nm", length));
			String[] vopCd = (JSPUtil.getParameter(request, prefix	+ "vop_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] portBsaCfmFlg = (JSPUtil.getParameter(request, prefix	+ "port_bsa_cfm_flg", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vslCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsaOpJbCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_jb_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] portBsaCapa = (JSPUtil.getParameter(request, prefix	+ "port_bsa_capa", length));
			String[] stupFlg = (JSPUtil.getParameter(request, prefix	+ "stup_flg", length));
			String[] bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] costYrwk = (JSPUtil.getParameter(request, prefix	+ "cost_yrwk", length));
			String[] mnlFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchStepUpDownVvdMasterListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bsaOpNm[i] != null)
					model.setBsaOpNm(bsaOpNm[i]);
				if (vopCd[i] != null)
					model.setVopCd(vopCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (portBsaCfmFlg[i] != null)
					model.setPortBsaCfmFlg(portBsaCfmFlg[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vslCapa[i] != null)
					model.setVslCapa(vslCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsaOpJbCd[i] != null)
					model.setBsaOpJbCd(bsaOpJbCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (portBsaCapa[i] != null)
					model.setPortBsaCapa(portBsaCapa[i]);
				if (stupFlg[i] != null)
					model.setStupFlg(stupFlg[i]);
				if (bsaOpCd[i] != null)
					model.setBsaOpCd(bsaOpCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (costYrwk[i] != null)
					model.setCostYrwk(costYrwk[i]);
				if (mnlFlg[i] != null)
					model.setMnlFlg(mnlFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchStepUpDownVvdMasterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchStepUpDownVvdMasterListVO[]
	 */
	public SearchStepUpDownVvdMasterListVO[] getSearchStepUpDownVvdMasterListVOs(){
		SearchStepUpDownVvdMasterListVO[] vos = (SearchStepUpDownVvdMasterListVO[])models.toArray(new SearchStepUpDownVvdMasterListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpNm = this.bsaOpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopCd = this.vopCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBsaCfmFlg = this.portBsaCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCapa = this.vslCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpJbCd = this.bsaOpJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portBsaCapa = this.portBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stupFlg = this.stupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrwk = this.costYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg = this.mnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
