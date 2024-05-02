/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CprtItemVO.java
*@FileTitle : CprtItemVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.11.09 한동훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한동훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CprtItemVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CprtItemVO> models = new ArrayList<CprtItemVO>();
	
	private CprtItemVO cprtItemVO = null;
	
	private List<CprtItemVO> cprtItemListVOs = null;
	
	private List<CprtItemVO> cprtTmpltVOs = null;

	private List<RptTmpltNmVO> rptTmpltNmVOs = null;

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String rptTmpltNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rptItmId = null;
	/* Column Info */
	private String n2ndMstItmId = null;
	/* Column Info */
	private String rptItmGrpId = null;
	/* Column Info */
	private String rptItmNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mstItmId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cprtConvTpCd = null;
	/* Column Info */
	private String itmGrpNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CprtItemVO() {}

	public CprtItemVO(String ibflag, String pagerows, String rptItmId, String itmGrpNm, String rptItmGrpId, String dpSeq, String rptItmNm, String mstItmId, String n2ndMstItmId, String cprtConvTpCd, String creUsrId, String creDt, String updUsrId, String updDt, String rptTmpltNm) {
		this.updDt = updDt;
		this.dpSeq = dpSeq;
		this.rptTmpltNm = rptTmpltNm;
		this.creDt = creDt;
		this.rptItmId = rptItmId;
		this.n2ndMstItmId = n2ndMstItmId;
		this.rptItmGrpId = rptItmGrpId;
		this.rptItmNm = rptItmNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.mstItmId = mstItmId;
		this.creUsrId = creUsrId;
		this.cprtConvTpCd = cprtConvTpCd;
		this.itmGrpNm = itmGrpNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("rpt_tmplt_nm", getRptTmpltNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rpt_itm_id", getRptItmId());
		this.hashColumns.put("n2nd_mst_itm_id", getN2ndMstItmId());
		this.hashColumns.put("rpt_itm_grp_id", getRptItmGrpId());
		this.hashColumns.put("rpt_itm_nm", getRptItmNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mst_itm_id", getMstItmId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cprt_conv_tp_cd", getCprtConvTpCd());
		this.hashColumns.put("itm_grp_nm", getItmGrpNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("rpt_tmplt_nm", "rptTmpltNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rpt_itm_id", "rptItmId");
		this.hashFields.put("n2nd_mst_itm_id", "n2ndMstItmId");
		this.hashFields.put("rpt_itm_grp_id", "rptItmGrpId");
		this.hashFields.put("rpt_itm_nm", "rptItmNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mst_itm_id", "mstItmId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cprt_conv_tp_cd", "cprtConvTpCd");
		this.hashFields.put("itm_grp_nm", "itmGrpNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	public CprtItemVO getCprtItemVO() {
		return cprtItemVO;
	}

	public void setCprtItemVO(CprtItemVO cprtItemVO) {
		this.cprtItemVO = cprtItemVO;
	}

	public List<CprtItemVO> getCprtTmpltVOs() {
		return cprtTmpltVOs;
	}

	public void setCprtTmpltVOs(List<CprtItemVO> cprtTmpltVOs) {
		this.cprtTmpltVOs = cprtTmpltVOs;
	}

	public List<CprtItemVO> getCprtItemListVOs() {
		return cprtItemListVOs;
	}

	public void setCprtItemListVOs(List<CprtItemVO> cprtItemListVOs) {
		this.cprtItemListVOs = cprtItemListVOs;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return rptTmpltNm
	 */
	public String getRptTmpltNm() {
		return this.rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return rptItmId
	 */
	public String getRptItmId() {
		return this.rptItmId;
	}
	
	/**
	 * Column Info
	 * @return n2ndMstItmId
	 */
	public String getN2ndMstItmId() {
		return this.n2ndMstItmId;
	}
	
	/**
	 * Column Info
	 * @return rptItmGrpId
	 */
	public String getRptItmGrpId() {
		return this.rptItmGrpId;
	}
	
	/**
	 * Column Info
	 * @return rptItmNm
	 */
	public String getRptItmNm() {
		return this.rptItmNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return mstItmId
	 */
	public String getMstItmId() {
		return this.mstItmId;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return cprtConvTpCd
	 */
	public String getCprtConvTpCd() {
		return this.cprtConvTpCd;
	}
	
	/**
	 * Column Info
	 * @return itmGrpNm
	 */
	public String getItmGrpNm() {
		return this.itmGrpNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param rptTmpltNm
	 */
	public void setRptTmpltNm(String rptTmpltNm) {
		this.rptTmpltNm = rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param rptItmId
	 */
	public void setRptItmId(String rptItmId) {
		this.rptItmId = rptItmId;
	}
	
	/**
	 * Column Info
	 * @param n2ndMstItmId
	 */
	public void setN2ndMstItmId(String n2ndMstItmId) {
		this.n2ndMstItmId = n2ndMstItmId;
	}
	
	/**
	 * Column Info
	 * @param rptItmGrpId
	 */
	public void setRptItmGrpId(String rptItmGrpId) {
		this.rptItmGrpId = rptItmGrpId;
	}
	
	/**
	 * Column Info
	 * @param rptItmNm
	 */
	public void setRptItmNm(String rptItmNm) {
		this.rptItmNm = rptItmNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param mstItmId
	 */
	public void setMstItmId(String mstItmId) {
		this.mstItmId = mstItmId;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param cprtConvTpCd
	 */
	public void setCprtConvTpCd(String cprtConvTpCd) {
		this.cprtConvTpCd = cprtConvTpCd;
	}
	
	/**
	 * Column Info
	 * @param itmGrpNm
	 */
	public void setItmGrpNm(String itmGrpNm) {
		this.itmGrpNm = itmGrpNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setRptTmpltNm(JSPUtil.getParameter(request, "rpt_tmplt_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRptItmId(JSPUtil.getParameter(request, "rpt_itm_id", ""));
		setN2ndMstItmId(JSPUtil.getParameter(request, "n2nd_mst_itm_id", ""));
		setRptItmGrpId(JSPUtil.getParameter(request, "rpt_itm_grp_id", ""));
		setRptItmNm(JSPUtil.getParameter(request, "rpt_itm_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMstItmId(JSPUtil.getParameter(request, "mst_itm_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCprtConvTpCd(JSPUtil.getParameter(request, "cprt_conv_tp_cd", ""));
		setItmGrpNm(JSPUtil.getParameter(request, "itm_grp_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CprtItemVO[]
	 */
	public CprtItemVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CprtItemVO[]
	 */
	public CprtItemVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CprtItemVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] rptTmpltNm = (JSPUtil.getParameter(request, prefix	+ "rpt_tmplt_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rptItmId = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_id", length));
			String[] n2ndMstItmId = (JSPUtil.getParameter(request, prefix	+ "n2nd_mst_itm_id", length));
			String[] rptItmGrpId = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_grp_id", length));
			String[] rptItmNm = (JSPUtil.getParameter(request, prefix	+ "rpt_itm_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mstItmId = (JSPUtil.getParameter(request, prefix	+ "mst_itm_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cprtConvTpCd = (JSPUtil.getParameter(request, prefix	+ "cprt_conv_tp_cd", length));
			String[] itmGrpNm = (JSPUtil.getParameter(request, prefix	+ "itm_grp_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CprtItemVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (rptTmpltNm[i] != null)
					model.setRptTmpltNm(rptTmpltNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rptItmId[i] != null)
					model.setRptItmId(rptItmId[i]);
				if (n2ndMstItmId[i] != null)
					model.setN2ndMstItmId(n2ndMstItmId[i]);
				if (rptItmGrpId[i] != null)
					model.setRptItmGrpId(rptItmGrpId[i]);
				if (rptItmNm[i] != null)
					model.setRptItmNm(rptItmNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mstItmId[i] != null)
					model.setMstItmId(mstItmId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cprtConvTpCd[i] != null)
					model.setCprtConvTpCd(cprtConvTpCd[i]);
				if (itmGrpNm[i] != null)
					model.setItmGrpNm(itmGrpNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCprtItemVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CprtItemVO[]
	 */
	public CprtItemVO[] getCprtItemVOs(){
		CprtItemVO[] vos = (CprtItemVO[])models.toArray(new CprtItemVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptTmpltNm = this.rptTmpltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmId = this.rptItmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndMstItmId = this.n2ndMstItmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmGrpId = this.rptItmGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptItmNm = this.rptItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstItmId = this.mstItmId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cprtConvTpCd = this.cprtConvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmGrpNm = this.itmGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public List<RptTmpltNmVO> getRptTmpltNmVOs() {
		return rptTmpltNmVOs;
	}

	public void setRptTmpltNmVOs(List<RptTmpltNmVO> rptTmpltNmVOs) {
		this.rptTmpltNmVOs = rptTmpltNmVOs;
	}

}
