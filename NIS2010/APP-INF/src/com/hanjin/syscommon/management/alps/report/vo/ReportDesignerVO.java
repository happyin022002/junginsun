/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ReportDesignerVO.java
*@FileTitle : Report Designer Insert
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-03
*@LastModifier : YongHoo-Kim
*@LastVersion : 1.0
* 2013-05-03 YongHoo-Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.management.alps.report.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.syscommon.management.alps.report.integration.ReportInsertDBDAO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author YongHoo-Kim
 * @see  ReportInsertDBDAO 참조
 * @since J2SE 6.0
 */
public class ReportDesignerVO extends AbstractValueObject {

	private static final long serialVersionUID = -453383795360405469L;

	private Collection<ReportDesignerVO> models = new ArrayList<ReportDesignerVO>();
	
	/* Column Info */
	private String rdApplCd = null;
	/* Column Info */
	private String rdSubSys = null;
	/* Column Info */
	private String faxEmlDivCd = null;
	/* Column Info */
	private String rdTmpltNm = null;
	/* Column Info */
	private String jbTitCtnt = null;
	/* Column Info */
	private String jbDesc = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ReportDesignerVO(String rdApplCd, String rdSubSys,
			String faxEmlDivCd, String rdTmpltNm, String jbTitCtnt,
			String jbDesc, String deltFlg, String creUsrId, String creDt,
			String updUsrId, String updDt, String ibflag) {
		this.rdApplCd = rdApplCd;
		this.rdSubSys = rdSubSys;
		this.faxEmlDivCd = faxEmlDivCd;
		this.rdTmpltNm = rdTmpltNm;
		this.jbTitCtnt = jbTitCtnt;
		this.jbDesc = jbDesc;
		this.deltFlg = deltFlg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ibflag = ibflag;
	}

	public ReportDesignerVO() {}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("rd_appl_cd", getRdApplCd());
		this.hashColumns.put("rd_sub_sys_cd", getRdSubSys());
		this.hashColumns.put("fax_eml_div_cd", getFaxEmlDivCd());
		this.hashColumns.put("rd_tmplt_nm", getRdTmpltNm());
		this.hashColumns.put("jb_tit_ctnt", getJbTitCtnt());
		this.hashColumns.put("jb_desc", getJbDesc());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		return hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("rd_appl_cd", "rdApplCd");
		this.hashFields.put("rd_sub_sys_cd", "rdSubSys");
		this.hashFields.put("fax_eml_div_cd", "faxEmlDivCd");
		this.hashFields.put("rd_tmplt_nm", "rdTmpltNm");
		this.hashFields.put("jb_tit_ctnt", "jbTitCtnt");
		this.hashFields.put("jb_desc", "jbDesc");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		return hashFields;
	}

	/**
	 * Column Info
	 * @return rdApplCd
	 */
	public String getRdApplCd() {
		return rdApplCd;
	}

	/**
	 * Column Info
	 * @return rdSubSys
	 */
	public String getRdSubSys() {
		return rdSubSys;
	}

	/**
	 * Column Info
	 * @return faxEmlDivCd
	 */
	public String getFaxEmlDivCd() {
		return faxEmlDivCd;
	}

	/**
	 * Column Info
	 * @return rdTmpltNm
	 */
	public String getRdTmpltNm() {
		return rdTmpltNm;
	}

	/**
	 * Column Info
	 * @return jbTitCtnt
	 */
	public String getJbTitCtnt() {
		return jbTitCtnt;
	}

	/**
	 * Column Info
	 * @return jbDesc
	 */
	public String getJbDesc() {
		return jbDesc;
	}

	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return deltFlg;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return creDt;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * Column Info
	 * @param reApplCd
	 */
	public void setRdApplCd(String reApplCd) {
		this.rdApplCd = reApplCd;
	}

	/**
	 * Column Info
	 * @param rdSubSys
	 */
	public void setRdSubSys(String rdSubSys) {
		this.rdSubSys = rdSubSys;
	}

	/**
	 * Column Info
	 * @param faxEmlDivCd
	 */
	public void setFaxEmlDivCd(String faxEmlDivCd) {
		this.faxEmlDivCd = faxEmlDivCd;
	}

	/**
	 * Column Info
	 * @param rdTmpltNm
	 */
	public void setRdTmpltNm(String rdTmpltNm) {
		this.rdTmpltNm = rdTmpltNm;
	}

	/**
	 * Column Info
	 * @param jbTitCtnt
	 */
	public void setJbTitCtnt(String jbTitCtnt) {
		this.jbTitCtnt = jbTitCtnt;
	}

	/**
	 * Column Info
	 * @param jbDesc
	 */
	public void setJbDesc(String jbDesc) {
		this.jbDesc = jbDesc;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRdApplCd(JSPUtil.getParameter(request, "rd_appl_cd", ""));
		setRdSubSys(JSPUtil.getParameter(request, "rd_sub_sys_cd", ""));
		setFaxEmlDivCd(JSPUtil.getParameter(request, "fax_eml_div_cd", ""));
		setRdTmpltNm(JSPUtil.getParameter(request, "rd_tmplt_nm", ""));
		setJbTitCtnt(JSPUtil.getParameter(request, "jb_tit_ctnt", ""));
		setJbDesc(JSPUtil.getParameter(request, "jb_desc", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return ReportDesignerVO[]
	 */
	public ReportDesignerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReportDesignerVO[]
	 */
	public ReportDesignerVO[] fromRequestGrid(HttpServletRequest request,
			String prefix) {
		ReportDesignerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] rdApplCd = (JSPUtil.getParameter(request, prefix+ "rd_appl_cd", length));
			String[] rdSubSys = (JSPUtil.getParameter(request, prefix+ "rd_sub_sys_cd", length));
			String[] faxEmlDivCd = (JSPUtil.getParameter(request, prefix+ "fax_eml_div_cd", length));
			String[] rdTmpltNm = (JSPUtil.getParameter(request, prefix+ "rd_tmplt_nm", length));
			String[] jbTitCtnt = (JSPUtil.getParameter(request, prefix+ "jb_tit_ctnt", length));
			String[] jbDesc = (JSPUtil.getParameter(request, prefix + "jb_desc", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix+ "delt_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));

			for (int i = 0; i < length; i++) {
				model = new ReportDesignerVO();
				if (rdApplCd[i] != null)
					model.setRdApplCd(rdApplCd[i]);
				if (rdSubSys[i] != null)
					model.setRdSubSys(rdSubSys[i]);
				if (faxEmlDivCd[i] != null)
					model.setFaxEmlDivCd(faxEmlDivCd[i]);
				if (rdTmpltNm[i] != null)
					model.setRdTmpltNm(rdTmpltNm[i]);
				if (jbTitCtnt[i] != null)
					model.setJbTitCtnt(jbTitCtnt[i]);
				if (jbDesc[i] != null)
					model.setJbDesc(creUsrId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(creUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReportDesignerVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return ReportDesignerVO[]
	 */
	public ReportDesignerVO[] getReportDesignerVOs(){
		ReportDesignerVO[] vos = (ReportDesignerVO[])models.toArray(new ReportDesignerVO[models.size()]);
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
		this.rdApplCd = this.rdApplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSubSys = this.rdSubSys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxEmlDivCd = this.faxEmlDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdTmpltNm = this.rdTmpltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbTitCtnt = this.jbTitCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbDesc = this.jbDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}
