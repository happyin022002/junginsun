/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UseStatusConditonFormulaDtlVO.java
*@FileTitle : UseStatusConditonFormulaDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.18 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UseStatusConditonFormulaDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UseStatusConditonFormulaDtlVO> models = new ArrayList<UseStatusConditonFormulaDtlVO>();
	
	/* Column Info */
	private String idNo = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String idTp = null;
	/* Column Info */
	private String chgTp = null;
	/* Column Info */
	private String chgTpNm = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String ver = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UseStatusConditonFormulaDtlVO() {}

	public UseStatusConditonFormulaDtlVO(String ibflag, String pagerows, String ydCd, String acctCd, String costCd, String vndrNm, String ver, String chgTp, String chgTpNm, String idNo, String idTp) {
		this.idNo = idNo;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.ydCd = ydCd;
		this.idTp = idTp;
		this.chgTp = chgTp;
		this.chgTpNm = chgTpNm;
		this.acctCd = acctCd;
		this.ver = ver;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("id_no", getIdNo());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("id_tp", getIdTp());
		this.hashColumns.put("chg_tp", getChgTp());
		this.hashColumns.put("chg_tp_nm", getChgTpNm());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ver", getVer());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("id_no", "idNo");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("id_tp", "idTp");
		this.hashFields.put("chg_tp", "chgTp");
		this.hashFields.put("chg_tp_nm", "chgTpNm");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ver", "ver");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idNo
	 */
	public String getIdNo() {
		return this.idNo;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
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
	 * @return idTp
	 */
	public String getIdTp() {
		return this.idTp;
	}
	
	/**
	 * Column Info
	 * @return chgTp
	 */
	public String getChgTp() {
		return this.chgTp;
	}
	
	/**
	 * Column Info
	 * @return chgTpNm
	 */
	public String getChgTpNm() {
		return this.chgTpNm;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return ver
	 */
	public String getVer() {
		return this.ver;
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
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
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
	 * @param idTp
	 */
	public void setIdTp(String idTp) {
		this.idTp = idTp;
	}
	
	/**
	 * Column Info
	 * @param chgTp
	 */
	public void setChgTp(String chgTp) {
		this.chgTp = chgTp;
	}
	
	/**
	 * Column Info
	 * @param chgTpNm
	 */
	public void setChgTpNm(String chgTpNm) {
		this.chgTpNm = chgTpNm;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param ver
	 */
	public void setVer(String ver) {
		this.ver = ver;
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
		setIdNo(JSPUtil.getParameter(request, "id_no", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setIdTp(JSPUtil.getParameter(request, "id_tp", ""));
		setChgTp(JSPUtil.getParameter(request, "chg_tp", ""));
		setChgTpNm(JSPUtil.getParameter(request, "chg_tp_nm", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setVer(JSPUtil.getParameter(request, "ver", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UseStatusConditonFormulaDtlVO[]
	 */
	public UseStatusConditonFormulaDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UseStatusConditonFormulaDtlVO[]
	 */
	public UseStatusConditonFormulaDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UseStatusConditonFormulaDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idNo = (JSPUtil.getParameter(request, prefix	+ "id_no", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] idTp = (JSPUtil.getParameter(request, prefix	+ "id_tp", length));
			String[] chgTp = (JSPUtil.getParameter(request, prefix	+ "chg_tp", length));
			String[] chgTpNm = (JSPUtil.getParameter(request, prefix	+ "chg_tp_nm", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] ver = (JSPUtil.getParameter(request, prefix	+ "ver", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UseStatusConditonFormulaDtlVO();
				if (idNo[i] != null)
					model.setIdNo(idNo[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (idTp[i] != null)
					model.setIdTp(idTp[i]);
				if (chgTp[i] != null)
					model.setChgTp(chgTp[i]);
				if (chgTpNm[i] != null)
					model.setChgTpNm(chgTpNm[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (ver[i] != null)
					model.setVer(ver[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUseStatusConditonFormulaDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UseStatusConditonFormulaDtlVO[]
	 */
	public UseStatusConditonFormulaDtlVO[] getUseStatusConditonFormulaDtlVOs(){
		UseStatusConditonFormulaDtlVO[] vos = (UseStatusConditonFormulaDtlVO[])models.toArray(new UseStatusConditonFormulaDtlVO[models.size()]);
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
		this.idNo = this.idNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idTp = this.idTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTp = this.chgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpNm = this.chgTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ver = this.ver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
