/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ImmediateExitCreationVO.java
*@FileTitle : ImmediateExitCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see ..
 */
public class ImmediateExitCreationVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private Collection<ImmediateExitCreationVO> models = new ArrayList<ImmediateExitCreationVO>();
	
	private Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo");

		
	/* Status */
	private String ibflag = null;	
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String imdtExtFlg = null;	
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String agmtSeq = null;	
	/* Column Info */
	private String onhYdCd = null;	
	/* Column Info */
	private String crntYdCd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String cnmvDt = null;
	/* Column Info */
	private String fullFlg = null;
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private int iPage = 1;
		
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * @return the cntrNo
	 */
	public String getCntrNo() {
		return cntrNo;
	}

	/**
	 * @param cntrNo the cntrNo to set
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * @return the cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}

	/**
	 * @param cntrTpszCd the cntrTpszCd to set
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}

	/**
	 * @return the onhDt
	 */
	public String getOnhDt() {
		return onhDt;
	}

	/**
	 * @param onhDt the onhDt to set
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}

	/**
	 * @return the imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return imdtExtFlg;
	}

	/**
	 * @param imdtExtFlg the imdtExtFlg to set
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}

	/**
	 * @return the agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return agmtCtyCd;
	}

	/**
	 * @param agmtCtyCd the agmtCtyCd to set
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}

	/**
	 * @return the agmtSeq
	 */
	public String getAgmtSeq() {
		return agmtSeq;
	}

	/**
	 * @param agmtSeq the agmtSeq to set
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	/**
	 * @return the onhYdCd
	 */
	public String getOnhYdCd() {
		return onhYdCd;
	}

	/**
	 * @param onhYdCd the onhYdCd to set
	 */
	public void setOnhYdCd(String onhYdCd) {
		this.onhYdCd = onhYdCd;
	}

	/**
	 * @return the crntYdCd
	 */
	public String getCrntYdCd() {
		return crntYdCd;
	}

	/**
	 * @param crntYdCd the crntYdCd to set
	 */
	public void setCrntYdCd(String crntYdCd) {
		this.crntYdCd = crntYdCd;
	}

	/**
	 * @return the cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return cnmvStsCd;
	}

	/**
	 * @param cnmvStsCd the cnmvStsCd to set
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}

	/**
	 * @return the aciacDivCd
	 */
	public String getAciacDivCd() {
		return aciacDivCd;
	}

	/**
	 * @param aciacDivCd the aciacDivCd to set
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}

	/**
	 * @return the cnmvDt
	 */
	public String getCnmvDt() {
		return cnmvDt;
	}

	/**
	 * @param cnmvDt the cnmvDt to set
	 */
	public void setCnmvDt(String cnmvDt) {
		this.cnmvDt = cnmvDt;
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

	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the fullFlg
	 */
	public String getFullFlg() {
		return fullFlg;
	}

	/**
	 * @param fullFlg the fullFlg to set
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param page the iPage to set
	 */
	public void setIPage(int page) {
		iPage = page;
	}

	/**
	 * Constructor
	 */
	public ImmediateExitCreationVO() {}	
	
	/**
	 * Constructor
	 */
	public ImmediateExitCreationVO(String ibflag, String cntrNo,
			String cntrTpszCd, String onhDt, String imdtExtFlg,
			String agmtCtyCd, String agmtSeq, String onhYdCd, String crntYdCd,
			String cnmvStsCd, String aciacDivCd, String cnmvDt, String fullFlg,
			String creUsrId, String updUsrId, String pagerows) {
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.onhDt = onhDt;
		this.imdtExtFlg = imdtExtFlg;
		this.agmtCtyCd = agmtCtyCd;
		this.agmtSeq = agmtSeq;
		this.onhYdCd = onhYdCd;
		this.crntYdCd = crntYdCd;
		this.cnmvStsCd = cnmvStsCd;
		this.aciacDivCd = aciacDivCd;
		this.cnmvDt = cnmvDt;
		this.fullFlg = fullFlg;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){				
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");		
		this.hashFields.put("onh_yd_cd", "onhYdCd");		
		this.hashFields.put("crnt_yd_cd", "crntYdCd");		
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");		
		this.hashFields.put("aciac_div_cd", "aciacDivCd");		
		this.hashFields.put("cnmv_dt", "cnmvDt");		
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));		
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, "onh_dt", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));		
		setOnhYdCd(JSPUtil.getParameter(request, "onh_yd_cd", ""));		
		setCrntYdCd(JSPUtil.getParameter(request, "crnt_yd_cd", ""));		
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));		
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));		
		setCnmvDt(JSPUtil.getParameter(request, "cnmv_dt", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
				
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public ImmediateExitCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	
	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public ImmediateExitCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ImmediateExitCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt".trim(), length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));			
			String[] onhYdCd = (JSPUtil.getParameter(request, prefix	+ "onh_yd_cd".trim(), length));			
			String[] crntYdCd = (JSPUtil.getParameter(request, prefix	+ "crnt_yd_cd".trim(), length));			
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd".trim(), length));			
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd".trim(), length));
			String[] cnmvDt = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt".trim(), length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ImmediateExitCreationVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);				
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);				
				if (onhYdCd[i] != null)
					model.setOnhYdCd(onhYdCd[i]);				
				if (crntYdCd[i] != null)
					model.setCrntYdCd(crntYdCd[i]);				
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);								
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (cnmvDt[i] != null)
					model.setCnmvDt(cnmvDt[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getSearchParamVOs();
	}

	public ImmediateExitCreationVO[] getSearchParamVOs(){
		ImmediateExitCreationVO[] vos = (ImmediateExitCreationVO[])models.toArray(new ImmediateExitCreationVO[models.size()]);
		return vos;
	}
	
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
			log.error(ex.getMessage(), ex);
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){		
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhYdCd = this.onhYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.crntYdCd = this.crntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt = this.cnmvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}