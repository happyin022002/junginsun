/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : PriSpScpGriRoutViaCpyVO.java
*@FileTitle : PriSpScpGriRoutViaCpyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.01
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.12.01 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpScpGriRoutViaCpyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpScpGriRoutViaCpyVO> models = new ArrayList<PriSpScpGriRoutViaCpyVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String griGrpSeq = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String griRoutViaSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String genSpclRtTpCd = null;
	/* Column Info */
	private String routViaPortTpCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String routViaPortDefCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriSpScpGriRoutViaCpyVO() {}

	public PriSpScpGriRoutViaCpyVO(String ibflag, String pagerows, String usrId, String propNo, String amdtSeq, String svcScpCd, String genSpclRtTpCd, String griGrpSeq, String orgDestTpCd, String griRoutViaSeq, String routViaPortTpCd, String routViaPortDefCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.griGrpSeq = griGrpSeq;
		this.usrId = usrId;
		this.updUsrId = updUsrId;
		this.griRoutViaSeq = griRoutViaSeq;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.amdtSeq = amdtSeq;
		this.orgDestTpCd = orgDestTpCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.routViaPortTpCd = routViaPortTpCd;
		this.svcScpCd = svcScpCd;
		this.updDt = updDt;
		this.propNo = propNo;
		this.routViaPortDefCd = routViaPortDefCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gri_grp_seq", getGriGrpSeq());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("gri_rout_via_seq", getGriRoutViaSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("rout_via_port_tp_cd", getRoutViaPortTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("rout_via_port_def_cd", getRoutViaPortDefCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gri_grp_seq", "griGrpSeq");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("gri_rout_via_seq", "griRoutViaSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("rout_via_port_tp_cd", "routViaPortTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("rout_via_port_def_cd", "routViaPortDefCd");
		return this.hashFields;
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
	 * @return griGrpSeq
	 */
	public String getGriGrpSeq() {
		return this.griGrpSeq;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return griRoutViaSeq
	 */
	public String getGriRoutViaSeq() {
		return this.griRoutViaSeq;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return routViaPortTpCd
	 */
	public String getRoutViaPortTpCd() {
		return this.routViaPortTpCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return routViaPortDefCd
	 */
	public String getRoutViaPortDefCd() {
		return this.routViaPortDefCd;
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
	 * @param griGrpSeq
	 */
	public void setGriGrpSeq(String griGrpSeq) {
		this.griGrpSeq = griGrpSeq;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param griRoutViaSeq
	 */
	public void setGriRoutViaSeq(String griRoutViaSeq) {
		this.griRoutViaSeq = griRoutViaSeq;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param routViaPortTpCd
	 */
	public void setRoutViaPortTpCd(String routViaPortTpCd) {
		this.routViaPortTpCd = routViaPortTpCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param routViaPortDefCd
	 */
	public void setRoutViaPortDefCd(String routViaPortDefCd) {
		this.routViaPortDefCd = routViaPortDefCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGriGrpSeq(JSPUtil.getParameter(request, prefix + "gri_grp_seq", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setGriRoutViaSeq(JSPUtil.getParameter(request, prefix + "gri_rout_via_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, prefix + "gen_spcl_rt_tp_cd", ""));
		setRoutViaPortTpCd(JSPUtil.getParameter(request, prefix + "rout_via_port_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "rout_via_port_def_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpScpGriRoutViaCpyVO[]
	 */
	public PriSpScpGriRoutViaCpyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpScpGriRoutViaCpyVO[]
	 */
	public PriSpScpGriRoutViaCpyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpScpGriRoutViaCpyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] griGrpSeq = (JSPUtil.getParameter(request, prefix	+ "gri_grp_seq", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] griRoutViaSeq = (JSPUtil.getParameter(request, prefix	+ "gri_rout_via_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			String[] routViaPortTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_via_port_tp_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] routViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_via_port_def_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpScpGriRoutViaCpyVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (griGrpSeq[i] != null)
					model.setGriGrpSeq(griGrpSeq[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (griRoutViaSeq[i] != null)
					model.setGriRoutViaSeq(griRoutViaSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				if (routViaPortTpCd[i] != null)
					model.setRoutViaPortTpCd(routViaPortTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (routViaPortDefCd[i] != null)
					model.setRoutViaPortDefCd(routViaPortDefCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpScpGriRoutViaCpyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpScpGriRoutViaCpyVO[]
	 */
	public PriSpScpGriRoutViaCpyVO[] getPriSpScpGriRoutViaCpyVOs(){
		PriSpScpGriRoutViaCpyVO[] vos = (PriSpScpGriRoutViaCpyVO[])models.toArray(new PriSpScpGriRoutViaCpyVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griGrpSeq = this.griGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griRoutViaSeq = this.griRoutViaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routViaPortTpCd = this.routViaPortTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routViaPortDefCd = this.routViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
