/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaTransmitDetailVO.java
*@FileTitle : IndiaTransmitDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.11 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.TransmitDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaTransmitDetailVO extends TransmitDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaTransmitDetailVO> models = new ArrayList<IndiaTransmitDetailVO>();
	
	/* Column Info */
	private String cntrTpszValue = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String idaTrspCd = null;
	/* Column Info */
	private String blDeclTpCd = null;
	/* Column Info */
	private String ialRgnCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String idaStwgNo = null;
	/* Column Info */
	private String spclCgoDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String polCdLen3 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String lineCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaTransmitDetailVO() {}

	public IndiaTransmitDetailVO(String ibflag, String pagerows, String idaStwgNo, String cntrNo, String cntrWgt, String cntrTpszValue, String cnmvStsCd, String imdgClssCd, String polCdLen3, String ialRgnCd, String blDeclTpCd, String idaTrspCd, String lineCd, String rcFlg, String spclCgoDesc) {
		this.cntrTpszValue = cntrTpszValue;
		this.cntrWgt = cntrWgt;
		this.idaTrspCd = idaTrspCd;
		this.blDeclTpCd = blDeclTpCd;
		this.ialRgnCd = ialRgnCd;
		this.pagerows = pagerows;
		this.idaStwgNo = idaStwgNo;
		this.spclCgoDesc = spclCgoDesc;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.polCdLen3 = polCdLen3;
		this.cntrNo = cntrNo;
		this.rcFlg = rcFlg;
		this.imdgClssCd = imdgClssCd;
		this.lineCd = lineCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_value", getCntrTpszValue());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("ida_trsp_cd", getIdaTrspCd());
		this.hashColumns.put("bl_decl_tp_cd", getBlDeclTpCd());
		this.hashColumns.put("ial_rgn_cd", getIalRgnCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ida_stwg_no", getIdaStwgNo());
		this.hashColumns.put("spcl_cgo_desc", getSpclCgoDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("pol_cd_len3", getPolCdLen3());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("line_cd", getLineCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_tpsz_value", "cntrTpszValue");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("ida_trsp_cd", "idaTrspCd");
		this.hashFields.put("bl_decl_tp_cd", "blDeclTpCd");
		this.hashFields.put("ial_rgn_cd", "ialRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ida_stwg_no", "idaStwgNo");
		this.hashFields.put("spcl_cgo_desc", "spclCgoDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("pol_cd_len3", "polCdLen3");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("line_cd", "lineCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszValue
	 */
	public String getCntrTpszValue() {
		return this.cntrTpszValue;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return idaTrspCd
	 */
	public String getIdaTrspCd() {
		return this.idaTrspCd;
	}
	
	/**
	 * Column Info
	 * @return blDeclTpCd
	 */
	public String getBlDeclTpCd() {
		return this.blDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return ialRgnCd
	 */
	public String getIalRgnCd() {
		return this.ialRgnCd;
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
	 * @return idaStwgNo
	 */
	public String getIdaStwgNo() {
		return this.idaStwgNo;
	}
	
	/**
	 * Column Info
	 * @return spclCgoDesc
	 */
	public String getSpclCgoDesc() {
		return this.spclCgoDesc;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return polCdLen3
	 */
	public String getPolCdLen3() {
		return this.polCdLen3;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return lineCd
	 */
	public String getLineCd() {
		return this.lineCd;
	}
	

	/**
	 * Column Info
	 * @param cntrTpszValue
	 */
	public void setCntrTpszValue(String cntrTpszValue) {
		this.cntrTpszValue = cntrTpszValue;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param idaTrspCd
	 */
	public void setIdaTrspCd(String idaTrspCd) {
		this.idaTrspCd = idaTrspCd;
	}
	
	/**
	 * Column Info
	 * @param blDeclTpCd
	 */
	public void setBlDeclTpCd(String blDeclTpCd) {
		this.blDeclTpCd = blDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param ialRgnCd
	 */
	public void setIalRgnCd(String ialRgnCd) {
		this.ialRgnCd = ialRgnCd;
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
	 * @param idaStwgNo
	 */
	public void setIdaStwgNo(String idaStwgNo) {
		this.idaStwgNo = idaStwgNo;
	}
	
	/**
	 * Column Info
	 * @param spclCgoDesc
	 */
	public void setSpclCgoDesc(String spclCgoDesc) {
		this.spclCgoDesc = spclCgoDesc;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param polCdLen3
	 */
	public void setPolCdLen3(String polCdLen3) {
		this.polCdLen3 = polCdLen3;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param lineCd
	 */
	public void setLineCd(String lineCd) {
		this.lineCd = lineCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrTpszValue(JSPUtil.getParameter(request, "cntr_tpsz_value", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setIdaTrspCd(JSPUtil.getParameter(request, "ida_trsp_cd", ""));
		setBlDeclTpCd(JSPUtil.getParameter(request, "bl_decl_tp_cd", ""));
		setIalRgnCd(JSPUtil.getParameter(request, "ial_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIdaStwgNo(JSPUtil.getParameter(request, "ida_stwg_no", ""));
		setSpclCgoDesc(JSPUtil.getParameter(request, "spcl_cgo_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setPolCdLen3(JSPUtil.getParameter(request, "pol_cd_len3", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setLineCd(JSPUtil.getParameter(request, "line_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaTransmitDetailVO[]
	 */
	public IndiaTransmitDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaTransmitDetailVO[]
	 */
	public IndiaTransmitDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaTransmitDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrTpszValue = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_value", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] idaTrspCd = (JSPUtil.getParameter(request, prefix	+ "ida_trsp_cd", length));
			String[] blDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_decl_tp_cd", length));
			String[] ialRgnCd = (JSPUtil.getParameter(request, prefix	+ "ial_rgn_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] idaStwgNo = (JSPUtil.getParameter(request, prefix	+ "ida_stwg_no", length));
			String[] spclCgoDesc = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] polCdLen3 = (JSPUtil.getParameter(request, prefix	+ "pol_cd_len3", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] lineCd = (JSPUtil.getParameter(request, prefix	+ "line_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaTransmitDetailVO();
				if (cntrTpszValue[i] != null)
					model.setCntrTpszValue(cntrTpszValue[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (idaTrspCd[i] != null)
					model.setIdaTrspCd(idaTrspCd[i]);
				if (blDeclTpCd[i] != null)
					model.setBlDeclTpCd(blDeclTpCd[i]);
				if (ialRgnCd[i] != null)
					model.setIalRgnCd(ialRgnCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (idaStwgNo[i] != null)
					model.setIdaStwgNo(idaStwgNo[i]);
				if (spclCgoDesc[i] != null)
					model.setSpclCgoDesc(spclCgoDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (polCdLen3[i] != null)
					model.setPolCdLen3(polCdLen3[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (lineCd[i] != null)
					model.setLineCd(lineCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaTransmitDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaTransmitDetailVO[]
	 */
	public IndiaTransmitDetailVO[] getIndiaTransmitDetailVOs(){
		IndiaTransmitDetailVO[] vos = (IndiaTransmitDetailVO[])models.toArray(new IndiaTransmitDetailVO[models.size()]);
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
		this.cntrTpszValue = this.cntrTpszValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaTrspCd = this.idaTrspCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDeclTpCd = this.blDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ialRgnCd = this.ialRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaStwgNo = this.idaStwgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoDesc = this.spclCgoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCdLen3 = this.polCdLen3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineCd = this.lineCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
