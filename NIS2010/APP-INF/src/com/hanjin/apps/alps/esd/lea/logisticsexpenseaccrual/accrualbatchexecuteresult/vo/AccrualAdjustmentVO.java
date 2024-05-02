/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualAdjustmentVO.java
*@FileTitle : AccrualAdjustmentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AccrualAdjustmentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AccrualAdjustmentVO> models = new ArrayList<AccrualAdjustmentVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String acclLgcTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dateSts = null;
	/* Column Info */
	private String acclAdjFctrFnlFlg = null;
	/* Column Info */
	private String acclAdjFctrAplyEndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String acclAdjFctrAplyProcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inputSw = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String acclAdjFctrCfmFlg = null;
	/* Column Info */
	private String acclAdjFctrRt = null;
	/* Column Info */
	private String acclAdjFctrAplyStDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AccrualAdjustmentVO() {}

	public AccrualAdjustmentVO(String ibflag, String pagerows, String updDt, String revYrmon, String deltFlg, String exeYrmon, String acclLgcTpCd, String creDt, String acclAdjFctrAplyEndDt, String acclAdjFctrAplyProcCd, String inputSw, String creUsrId, String acclAdjFctrCfmFlg, String acclAdjFctrRt, String acclAdjFctrAplyStDt, String updUsrId, String acclAdjFctrFnlFlg, String dateSts) {
		this.updDt = updDt;
		this.revYrmon = revYrmon;
		this.deltFlg = deltFlg;
		this.exeYrmon = exeYrmon;
		this.acclLgcTpCd = acclLgcTpCd;
		this.creDt = creDt;
		this.dateSts = dateSts;
		this.acclAdjFctrFnlFlg = acclAdjFctrFnlFlg;
		this.acclAdjFctrAplyEndDt = acclAdjFctrAplyEndDt;
		this.pagerows = pagerows;
		this.acclAdjFctrAplyProcCd = acclAdjFctrAplyProcCd;
		this.ibflag = ibflag;
		this.inputSw = inputSw;
		this.creUsrId = creUsrId;
		this.acclAdjFctrCfmFlg = acclAdjFctrCfmFlg;
		this.acclAdjFctrRt = acclAdjFctrRt;
		this.acclAdjFctrAplyStDt = acclAdjFctrAplyStDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("accl_lgc_tp_cd", getAcclLgcTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("date_sts", getDateSts());
		this.hashColumns.put("accl_adj_fctr_fnl_flg", getAcclAdjFctrFnlFlg());
		this.hashColumns.put("accl_adj_fctr_aply_end_dt", getAcclAdjFctrAplyEndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("accl_adj_fctr_aply_proc_cd", getAcclAdjFctrAplyProcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("input_sw", getInputSw());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("accl_adj_fctr_cfm_flg", getAcclAdjFctrCfmFlg());
		this.hashColumns.put("accl_adj_fctr_rt", getAcclAdjFctrRt());
		this.hashColumns.put("accl_adj_fctr_aply_st_dt", getAcclAdjFctrAplyStDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("accl_lgc_tp_cd", "acclLgcTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("date_sts", "dateSts");
		this.hashFields.put("accl_adj_fctr_fnl_flg", "acclAdjFctrFnlFlg");
		this.hashFields.put("accl_adj_fctr_aply_end_dt", "acclAdjFctrAplyEndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("accl_adj_fctr_aply_proc_cd", "acclAdjFctrAplyProcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("input_sw", "inputSw");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("accl_adj_fctr_cfm_flg", "acclAdjFctrCfmFlg");
		this.hashFields.put("accl_adj_fctr_rt", "acclAdjFctrRt");
		this.hashFields.put("accl_adj_fctr_aply_st_dt", "acclAdjFctrAplyStDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}
	
	/**
	 * Column Info
	 * @return acclLgcTpCd
	 */
	public String getAcclLgcTpCd() {
		return this.acclLgcTpCd;
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
	 * @return dateSts
	 */
	public String getDateSts() {
		return this.dateSts;
	}
	
	/**
	 * Column Info
	 * @return acclAdjFctrFnlFlg
	 */
	public String getAcclAdjFctrFnlFlg() {
		return this.acclAdjFctrFnlFlg;
	}
	
	/**
	 * Column Info
	 * @return acclAdjFctrAplyEndDt
	 */
	public String getAcclAdjFctrAplyEndDt() {
		return this.acclAdjFctrAplyEndDt;
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
	 * @return acclAdjFctrAplyProcCd
	 */
	public String getAcclAdjFctrAplyProcCd() {
		return this.acclAdjFctrAplyProcCd;
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
	 * @return inputSw
	 */
	public String getInputSw() {
		return this.inputSw;
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
	 * @return acclAdjFctrCfmFlg
	 */
	public String getAcclAdjFctrCfmFlg() {
		return this.acclAdjFctrCfmFlg;
	}
	
	/**
	 * Column Info
	 * @return acclAdjFctrRt
	 */
	public String getAcclAdjFctrRt() {
		return this.acclAdjFctrRt;
	}
	
	/**
	 * Column Info
	 * @return acclAdjFctrAplyStDt
	 */
	public String getAcclAdjFctrAplyStDt() {
		return this.acclAdjFctrAplyStDt;
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
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}
	
	/**
	 * Column Info
	 * @param acclLgcTpCd
	 */
	public void setAcclLgcTpCd(String acclLgcTpCd) {
		this.acclLgcTpCd = acclLgcTpCd;
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
	 * @param dateSts
	 */
	public void setDateSts(String dateSts) {
		this.dateSts = dateSts;
	}
	
	/**
	 * Column Info
	 * @param acclAdjFctrFnlFlg
	 */
	public void setAcclAdjFctrFnlFlg(String acclAdjFctrFnlFlg) {
		this.acclAdjFctrFnlFlg = acclAdjFctrFnlFlg;
	}
	
	/**
	 * Column Info
	 * @param acclAdjFctrAplyEndDt
	 */
	public void setAcclAdjFctrAplyEndDt(String acclAdjFctrAplyEndDt) {
		this.acclAdjFctrAplyEndDt = acclAdjFctrAplyEndDt;
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
	 * @param acclAdjFctrAplyProcCd
	 */
	public void setAcclAdjFctrAplyProcCd(String acclAdjFctrAplyProcCd) {
		this.acclAdjFctrAplyProcCd = acclAdjFctrAplyProcCd;
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
	 * @param inputSw
	 */
	public void setInputSw(String inputSw) {
		this.inputSw = inputSw;
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
	 * @param acclAdjFctrCfmFlg
	 */
	public void setAcclAdjFctrCfmFlg(String acclAdjFctrCfmFlg) {
		this.acclAdjFctrCfmFlg = acclAdjFctrCfmFlg;
	}
	
	/**
	 * Column Info
	 * @param acclAdjFctrRt
	 */
	public void setAcclAdjFctrRt(String acclAdjFctrRt) {
		this.acclAdjFctrRt = acclAdjFctrRt;
	}
	
	/**
	 * Column Info
	 * @param acclAdjFctrAplyStDt
	 */
	public void setAcclAdjFctrAplyStDt(String acclAdjFctrAplyStDt) {
		this.acclAdjFctrAplyStDt = acclAdjFctrAplyStDt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setAcclLgcTpCd(JSPUtil.getParameter(request, prefix + "accl_lgc_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDateSts(JSPUtil.getParameter(request, prefix + "date_sts", ""));
		setAcclAdjFctrFnlFlg(JSPUtil.getParameter(request, prefix + "accl_adj_fctr_fnl_flg", ""));
		setAcclAdjFctrAplyEndDt(JSPUtil.getParameter(request, prefix + "accl_adj_fctr_aply_end_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAcclAdjFctrAplyProcCd(JSPUtil.getParameter(request, prefix + "accl_adj_fctr_aply_proc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInputSw(JSPUtil.getParameter(request, prefix + "input_sw", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAcclAdjFctrCfmFlg(JSPUtil.getParameter(request, prefix + "accl_adj_fctr_cfm_flg", ""));
		setAcclAdjFctrRt(JSPUtil.getParameter(request, prefix + "accl_adj_fctr_rt", ""));
		setAcclAdjFctrAplyStDt(JSPUtil.getParameter(request, prefix + "accl_adj_fctr_aply_st_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccrualAdjustmentVO[]
	 */
	public AccrualAdjustmentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AccrualAdjustmentVO[]
	 */
	public AccrualAdjustmentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AccrualAdjustmentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] acclLgcTpCd = (JSPUtil.getParameter(request, prefix	+ "accl_lgc_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dateSts = (JSPUtil.getParameter(request, prefix	+ "date_sts", length));
			String[] acclAdjFctrFnlFlg = (JSPUtil.getParameter(request, prefix	+ "accl_adj_fctr_fnl_flg", length));
			String[] acclAdjFctrAplyEndDt = (JSPUtil.getParameter(request, prefix	+ "accl_adj_fctr_aply_end_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] acclAdjFctrAplyProcCd = (JSPUtil.getParameter(request, prefix	+ "accl_adj_fctr_aply_proc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inputSw = (JSPUtil.getParameter(request, prefix	+ "input_sw", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] acclAdjFctrCfmFlg = (JSPUtil.getParameter(request, prefix	+ "accl_adj_fctr_cfm_flg", length));
			String[] acclAdjFctrRt = (JSPUtil.getParameter(request, prefix	+ "accl_adj_fctr_rt", length));
			String[] acclAdjFctrAplyStDt = (JSPUtil.getParameter(request, prefix	+ "accl_adj_fctr_aply_st_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new AccrualAdjustmentVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (acclLgcTpCd[i] != null)
					model.setAcclLgcTpCd(acclLgcTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dateSts[i] != null)
					model.setDateSts(dateSts[i]);
				if (acclAdjFctrFnlFlg[i] != null)
					model.setAcclAdjFctrFnlFlg(acclAdjFctrFnlFlg[i]);
				if (acclAdjFctrAplyEndDt[i] != null)
					model.setAcclAdjFctrAplyEndDt(acclAdjFctrAplyEndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (acclAdjFctrAplyProcCd[i] != null)
					model.setAcclAdjFctrAplyProcCd(acclAdjFctrAplyProcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inputSw[i] != null)
					model.setInputSw(inputSw[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (acclAdjFctrCfmFlg[i] != null)
					model.setAcclAdjFctrCfmFlg(acclAdjFctrCfmFlg[i]);
				if (acclAdjFctrRt[i] != null)
					model.setAcclAdjFctrRt(acclAdjFctrRt[i]);
				if (acclAdjFctrAplyStDt[i] != null)
					model.setAcclAdjFctrAplyStDt(acclAdjFctrAplyStDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAccrualAdjustmentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AccrualAdjustmentVO[]
	 */
	public AccrualAdjustmentVO[] getAccrualAdjustmentVOs(){
		AccrualAdjustmentVO[] vos = (AccrualAdjustmentVO[])models.toArray(new AccrualAdjustmentVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclLgcTpCd = this.acclLgcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateSts = this.dateSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAdjFctrFnlFlg = this.acclAdjFctrFnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAdjFctrAplyEndDt = this.acclAdjFctrAplyEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAdjFctrAplyProcCd = this.acclAdjFctrAplyProcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inputSw = this.inputSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAdjFctrCfmFlg = this.acclAdjFctrCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAdjFctrRt = this.acclAdjFctrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAdjFctrAplyStDt = this.acclAdjFctrAplyStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
