/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerTypeSizeCodeVOVO.java
*@FileTitle : ContainerTypeSizeCodeVOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.05 민정호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo;

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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ContainerTypeSizeCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ContainerTypeSizeCodeVO> models = new ArrayList<ContainerTypeSizeCodeVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String updUsrId = null;
	
	/* Column Info */
	private String rptDpSeq = null;
	/* Column Info */
	private String isoCntrTpszNm = null;
	/* Column Info */
	private String cntrTpszIsoCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String cntrTpszDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszGrpCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrSzTeuCapa = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ContainerTypeSizeCodeVO() {}

	public ContainerTypeSizeCodeVO(String updDt, String updUsrId, String ibflag, String pagerows, String cntrTpszCd, String cntrTpszDesc, String cntrTpszIsoCd, String isoCntrTpszNm, String cntrSzTeuCapa, String cntrTpszGrpCd, String rptDpSeq, String aciacDivCd) {
		this.updDt = updDt;
		this.updUsrId = updUsrId;
		this.rptDpSeq = rptDpSeq;
		this.isoCntrTpszNm = isoCntrTpszNm;
		this.cntrTpszIsoCd = cntrTpszIsoCd;
		this.aciacDivCd = aciacDivCd;
		this.cntrTpszDesc = cntrTpszDesc;
		this.ibflag = ibflag;
		this.cntrTpszGrpCd = cntrTpszGrpCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrSzTeuCapa = cntrSzTeuCapa;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("rpt_dp_seq", getRptDpSeq());
		this.hashColumns.put("iso_cntr_tpsz_nm", getIsoCntrTpszNm());
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("cntr_tpsz_desc", getCntrTpszDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_grp_cd", getCntrTpszGrpCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_sz_teu_capa", getCntrSzTeuCapa());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");		
		this.hashFields.put("rpt_dp_seq", "rptDpSeq");
		this.hashFields.put("iso_cntr_tpsz_nm", "isoCntrTpszNm");
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("cntr_tpsz_desc", "cntrTpszDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_grp_cd", "cntrTpszGrpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_sz_teu_capa", "cntrSzTeuCapa");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rptDpSeq
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rptDpSeq
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}	
		
	/**
	 * Column Info
	 * @return rptDpSeq
	 */
	public String getRptDpSeq() {
		return this.rptDpSeq;
	}
	
	/**
	 * Column Info
	 * @return isoCntrTpszNm
	 */
	public String getIsoCntrTpszNm() {
		return this.isoCntrTpszNm;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszIsoCd
	 */
	public String getCntrTpszIsoCd() {
		return this.cntrTpszIsoCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszRmk
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszDesc
	 */
	public String getCntrTpszDesc() {
		return this.cntrTpszDesc;
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
	 * @return cntrTpszGrpCd
	 */
	public String getCntrTpszGrpCd() {
		return this.cntrTpszGrpCd;
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
	 * @return cntrSzTeuCapa
	 */
	public String getCntrSzTeuCapa() {
		return this.cntrSzTeuCapa;
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
	 * @param rptDpSeq
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rptDpSeq
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}	

	/**
	 * Column Info
	 * @param rptDpSeq
	 */
	public void setRptDpSeq(String rptDpSeq) {
		this.rptDpSeq = rptDpSeq;
	}
	
	/**
	 * Column Info
	 * @param isoCntrTpszNm
	 */
	public void setIsoCntrTpszNm(String isoCntrTpszNm) {
		this.isoCntrTpszNm = isoCntrTpszNm;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszIsoCd
	 */
	public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszRmk
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszDesc
	 */
	public void setCntrTpszDesc(String cntrTpszDesc) {
		this.cntrTpszDesc = cntrTpszDesc;
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
	 * @param cntrTpszGrpCd
	 */
	public void setCntrTpszGrpCd(String cntrTpszGrpCd) {
		this.cntrTpszGrpCd = cntrTpszGrpCd;
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
	 * @param cntrSzTeuCapa
	 */
	public void setCntrSzTeuCapa(String cntrSzTeuCapa) {
		this.cntrSzTeuCapa = cntrSzTeuCapa;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dp", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));		
		setRptDpSeq(JSPUtil.getParameter(request, "rpt_dp_seq", ""));
		setIsoCntrTpszNm(JSPUtil.getParameter(request, "iso_cntr_tpsz_nm", ""));
		setCntrTpszIsoCd(JSPUtil.getParameter(request, "cntr_tpsz_iso_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setCntrTpszDesc(JSPUtil.getParameter(request, "cntr_tpsz_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrTpszGrpCd(JSPUtil.getParameter(request, "cntr_tpsz_grp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrSzTeuCapa(JSPUtil.getParameter(request, "cntr_sz_teu_capa", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContainerTypeSizeCodeVOVO[]
	 */
	public ContainerTypeSizeCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContainerTypeSizeCodeVOVO[]
	 */
	public ContainerTypeSizeCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ContainerTypeSizeCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));			
			String[] rptDpSeq = (JSPUtil.getParameter(request, prefix	+ "rpt_dp_seq".trim(), length));
			String[] isoCntrTpszNm = (JSPUtil.getParameter(request, prefix	+ "iso_cntr_tpsz_nm".trim(), length));
			String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_iso_cd".trim(), length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd".trim(), length));
			String[] cntrTpszDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_desc".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntrTpszGrpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_grp_cd".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] cntrSzTeuCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_sz_teu_capa".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ContainerTypeSizeCodeVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);				
				if (rptDpSeq[i] != null)
					model.setRptDpSeq(rptDpSeq[i]);
				if (isoCntrTpszNm[i] != null)
					model.setIsoCntrTpszNm(isoCntrTpszNm[i]);
				if (cntrTpszIsoCd[i] != null)
					model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (cntrTpszDesc[i] != null)
					model.setCntrTpszDesc(cntrTpszDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszGrpCd[i] != null)
					model.setCntrTpszGrpCd(cntrTpszGrpCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrSzTeuCapa[i] != null)
					model.setCntrSzTeuCapa(cntrSzTeuCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getContainerTypeSizeCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ContainerTypeSizeCodeVOVO[]
	 */
	public ContainerTypeSizeCodeVO[] getContainerTypeSizeCodeVOs(){
		ContainerTypeSizeCodeVO[] vos = (ContainerTypeSizeCodeVO[])models.toArray(new ContainerTypeSizeCodeVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.rptDpSeq = this.rptDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCntrTpszNm = this.isoCntrTpszNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszIsoCd = this.cntrTpszIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszDesc = this.cntrTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszGrpCd = this.cntrTpszGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzTeuCapa = this.cntrSzTeuCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
