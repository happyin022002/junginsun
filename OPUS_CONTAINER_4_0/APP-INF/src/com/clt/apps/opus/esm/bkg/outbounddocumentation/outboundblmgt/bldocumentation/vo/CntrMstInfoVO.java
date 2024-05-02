/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CntrMstInfoVO.java
*@FileTitle : CntrMstInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2010.01.07 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrMstInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrMstInfoVO> models = new ArrayList<CntrMstInfoVO>();
	
	/* Column Info */
	private String cnmvStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String cntrStsCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String eccCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String sysAreaGrpId = null;
	/* Column Info */
	private String imdtExtFlg = null;	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrMstInfoVO() {}

	public CntrMstInfoVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String cntrStsCd, String cnmvCycNo, String cnmvStsCd, String dmgFlg, String aciacDivCd, String eccCd, String sysAreaGrpId, String imdtExtFlg) {
		this.cnmvStsCd = cnmvStsCd;
		this.ibflag = ibflag;
		this.cnmvCycNo = cnmvCycNo;
		this.cntrStsCd = cntrStsCd;
		this.cntrNo = cntrNo;
		this.eccCd = eccCd;
		this.cntrTpszCd = cntrTpszCd;
		this.aciacDivCd = aciacDivCd;
		this.dmgFlg = dmgFlg;
		this.sysAreaGrpId = sysAreaGrpId;
		this.imdtExtFlg = imdtExtFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ecc_cd", getEccCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("sys_area_grp_id", getSysAreaGrpId());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("sys_area_grp_id", "sysAreaGrpId");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return cntrStsCd
	 */
	public String getCntrStsCd() {
		return this.cntrStsCd;
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
	 * @return eccCd
	 */
	public String getEccCd() {
		return this.eccCd;
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
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}
	
	/**
	 * Column Info
	 * @return sysAreaGrpId
	 */
	public String getSysAreaGrpId() {
		return this.sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param cntrStsCd
	 */
	public void setCntrStsCd(String cntrStsCd) {
		this.cntrStsCd = cntrStsCd;
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
	 * @param eccCd
	 */
	public void setEccCd(String eccCd) {
		this.eccCd = eccCd;
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
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}
	
	/**
	 * Column Info
	 * @param sysAreaGrpId
	 */
	public void setSysAreaGrpId(String sysAreaGrpId) {
		this.sysAreaGrpId = sysAreaGrpId;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
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
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setCntrStsCd(JSPUtil.getParameter(request, "cntr_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setEccCd(JSPUtil.getParameter(request, "ecc_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setSysAreaGrpId(JSPUtil.getParameter(request, "sys_area_grp_id", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrMstInfoVO[]
	 */
	public CntrMstInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrMstInfoVO[]
	 */
	public CntrMstInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrMstInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] cntrStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] eccCd = (JSPUtil.getParameter(request, prefix	+ "ecc_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] sysAreaGrpId = (JSPUtil.getParameter(request, prefix	+ "sys_area_grp_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrMstInfoVO();
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (cntrStsCd[i] != null)
					model.setCntrStsCd(cntrStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (eccCd[i] != null)
					model.setEccCd(eccCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (sysAreaGrpId[i] != null)
					model.setSysAreaGrpId(sysAreaGrpId[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrMstInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrMstInfoVO[]
	 */
	public CntrMstInfoVO[] getCntrMstInfoVOs(){
		CntrMstInfoVO[] vos = (CntrMstInfoVO[])models.toArray(new CntrMstInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd = this.cntrStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd = this.eccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysAreaGrpId = this.sysAreaGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
