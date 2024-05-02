/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltCopyToProposalVO.java
*@FileTitle : RsltCopyToProposalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.14 이승준 
* 1.0 Creation
* 
* Ticket ID : CHM-201216141
설계자 : 송민석
개발자 : 이석준
2012.02.16 이석준[CHM-201216141] 미주 법인화에 따른 미주 지역의 Signatory Name 변경

=========================================================*/

package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltCopyToProposalVO extends AbstractValueObject { 

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltCopyToProposalVO> models = new ArrayList<RsltCopyToProposalVO>();
	
	/* Column Info */
	private String frmGrpCmdtCnt = null; 
	/* Column Info */
	private String newPropNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frmRateSCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String frmRateGCnt = null;
	/* Column Info */
	private String genSpclRtTpCdFrom = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String frmGrpLocCnt = null;
	/* Column Info */
	private String appOfcCd = null;
	/* Column Info */
	private String qttnOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String qttnSrepCd = null;

	/* Column Info */
	private String cntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltCopyToProposalVO() {}

	public RsltCopyToProposalVO(String ibflag, String pagerows, String newPropNo, String creUsrId, String qttnOfcCd, String updUsrId, String qttnNo, String qttnVerNo, String frmGrpLocCnt, String frmGrpCmdtCnt, String frmRateGCnt, String frmRateSCnt, String genSpclRtTpCdFrom, String appOfcCd,String qttnSrepCd,String cntCd) {
		this.frmGrpCmdtCnt = frmGrpCmdtCnt;
		this.newPropNo = newPropNo;
		this.pagerows = pagerows;
		this.frmRateSCnt = frmRateSCnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.frmRateGCnt = frmRateGCnt;
		this.genSpclRtTpCdFrom = genSpclRtTpCdFrom;
		this.qttnNo = qttnNo;
		this.qttnVerNo = qttnVerNo;
		this.frmGrpLocCnt = frmGrpLocCnt;
		this.appOfcCd = appOfcCd;
		this.qttnOfcCd = qttnOfcCd;
		this.updUsrId = updUsrId;
		this.qttnSrepCd = qttnSrepCd;
		this.cntCd = cntCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_grp_cmdt_cnt", getFrmGrpCmdtCnt());
		this.hashColumns.put("new_prop_no", getNewPropNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frm_rate_s_cnt", getFrmRateSCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("frm_rate_g_cnt", getFrmRateGCnt());
		this.hashColumns.put("gen_spcl_rt_tp_cd_from", getGenSpclRtTpCdFrom());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("frm_grp_loc_cnt", getFrmGrpLocCnt());
		this.hashColumns.put("app_ofc_cd", getAppOfcCd());
		this.hashColumns.put("qttn_ofc_cd", getQttnOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("qttn_srep_cd", getQttnSrepCd());
		this.hashColumns.put("cnt_cd", getCntCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_grp_cmdt_cnt", "frmGrpCmdtCnt");
		this.hashFields.put("new_prop_no", "newPropNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frm_rate_s_cnt", "frmRateSCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("frm_rate_g_cnt", "frmRateGCnt");
		this.hashFields.put("gen_spcl_rt_tp_cd_from", "genSpclRtTpCdFrom");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("frm_grp_loc_cnt", "frmGrpLocCnt");
		this.hashFields.put("app_ofc_cd", "appOfcCd");
		this.hashFields.put("qttn_ofc_cd", "qttnOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("qttn_srep_cd", "qttnSrepCd");
		this.hashFields.put("cnt_cd", "cntCd");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmGrpCmdtCnt
	 */
	public String getFrmGrpCmdtCnt() {
		return this.frmGrpCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @return newPropNo
	 */
	public String getNewPropNo() {
		return this.newPropNo;
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
	 * @return frmRateSCnt
	 */
	public String getFrmRateSCnt() {
		return this.frmRateSCnt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return frmRateGCnt
	 */
	public String getFrmRateGCnt() {
		return this.frmRateGCnt;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCdFrom
	 */
	public String getGenSpclRtTpCdFrom() {
		return this.genSpclRtTpCdFrom;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return frmGrpLocCnt
	 */
	public String getFrmGrpLocCnt() {
		return this.frmGrpLocCnt;
	}
	
	/**
	 * Column Info
	 * @return appOfcCd
	 */
	public String getAppOfcCd() {
		return this.appOfcCd;
	}
	
	/**
	 * Column Info
	 * @return qttnOfcCd
	 */
	public String getQttnOfcCd() {
		return this.qttnOfcCd;
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
	 * @return qttnSrepCd
	 */
	public String getQttnSrepCd() {
		return this.qttnSrepCd;
	}
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	/**
	 * Column Info
	 * @param frmGrpCmdtCnt
	 */
	public void setFrmGrpCmdtCnt(String frmGrpCmdtCnt) {
		this.frmGrpCmdtCnt = frmGrpCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @param newPropNo
	 */
	public void setNewPropNo(String newPropNo) {
		this.newPropNo = newPropNo;
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
	 * @param frmRateSCnt
	 */
	public void setFrmRateSCnt(String frmRateSCnt) {
		this.frmRateSCnt = frmRateSCnt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param frmRateGCnt
	 */
	public void setFrmRateGCnt(String frmRateGCnt) {
		this.frmRateGCnt = frmRateGCnt;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCdFrom
	 */
	public void setGenSpclRtTpCdFrom(String genSpclRtTpCdFrom) {
		this.genSpclRtTpCdFrom = genSpclRtTpCdFrom;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param frmGrpLocCnt
	 */
	public void setFrmGrpLocCnt(String frmGrpLocCnt) {
		this.frmGrpLocCnt = frmGrpLocCnt;
	}
	
	/**
	 * Column Info
	 * @param appOfcCd
	 */
	public void setAppOfcCd(String appOfcCd) {
		this.appOfcCd = appOfcCd;
	}
	
	/**
	 * Column Info
	 * @param qttnOfcCd
	 */
	public void setQttnOfcCd(String qttnOfcCd) {
		this.qttnOfcCd = qttnOfcCd;
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
	 * @param qttnSrepCd
	 */
	public void setQttnSrepCd(String qttnSrepCd) {
		this.qttnSrepCd = qttnSrepCd;
	}
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrmGrpCmdtCnt(JSPUtil.getParameter(request, "frm_grp_cmdt_cnt", ""));
		setNewPropNo(JSPUtil.getParameter(request, "new_prop_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFrmRateSCnt(JSPUtil.getParameter(request, "frm_rate_s_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFrmRateGCnt(JSPUtil.getParameter(request, "frm_rate_g_cnt", ""));
		setGenSpclRtTpCdFrom(JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd_from", ""));
		setQttnNo(JSPUtil.getParameter(request, "qttn_no", ""));
		setQttnVerNo(JSPUtil.getParameter(request, "qttn_ver_no", ""));
		setFrmGrpLocCnt(JSPUtil.getParameter(request, "frm_grp_loc_cnt", ""));
		setAppOfcCd(JSPUtil.getParameter(request, "app_ofc_cd", ""));
		setQttnOfcCd(JSPUtil.getParameter(request, "qttn_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setQttnSrepCd(JSPUtil.getParameter(request, "qttn_srep_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltCopyToProposalVO[]
	 */
	public RsltCopyToProposalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltCopyToProposalVO[]
	 */
	public RsltCopyToProposalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltCopyToProposalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmGrpCmdtCnt = (JSPUtil.getParameter(request, prefix	+ "frm_grp_cmdt_cnt", length));
			String[] newPropNo = (JSPUtil.getParameter(request, prefix	+ "new_prop_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frmRateSCnt = (JSPUtil.getParameter(request, prefix	+ "frm_rate_s_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] frmRateGCnt = (JSPUtil.getParameter(request, prefix	+ "frm_rate_g_cnt", length));
			String[] genSpclRtTpCdFrom = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd_from", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] frmGrpLocCnt = (JSPUtil.getParameter(request, prefix	+ "frm_grp_loc_cnt", length));
			String[] appOfcCd = (JSPUtil.getParameter(request, prefix	+ "app_ofc_cd", length));
			String[] qttnOfcCd = (JSPUtil.getParameter(request, prefix	+ "qttn_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			String[] qttnSrepCd = (JSPUtil.getParameter(request, prefix	+ "qttn_srep_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));

			for (int i = 0; i < length; i++) {
				model = new RsltCopyToProposalVO();
				if (frmGrpCmdtCnt[i] != null)
					model.setFrmGrpCmdtCnt(frmGrpCmdtCnt[i]);
				if (newPropNo[i] != null)
					model.setNewPropNo(newPropNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frmRateSCnt[i] != null)
					model.setFrmRateSCnt(frmRateSCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (frmRateGCnt[i] != null)
					model.setFrmRateGCnt(frmRateGCnt[i]);
				if (genSpclRtTpCdFrom[i] != null)
					model.setGenSpclRtTpCdFrom(genSpclRtTpCdFrom[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (frmGrpLocCnt[i] != null)
					model.setFrmGrpLocCnt(frmGrpLocCnt[i]);
				if (appOfcCd[i] != null)
					model.setAppOfcCd(appOfcCd[i]);
				if (qttnOfcCd[i] != null)
					model.setQttnOfcCd(qttnOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				
				if (qttnSrepCd[i] != null)
					model.setQttnSrepCd(qttnSrepCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltCopyToProposalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltCopyToProposalVO[]
	 */
	public RsltCopyToProposalVO[] getRsltCopyToProposalVOs(){
		RsltCopyToProposalVO[] vos = (RsltCopyToProposalVO[])models.toArray(new RsltCopyToProposalVO[models.size()]);
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
		this.frmGrpCmdtCnt = this.frmGrpCmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPropNo = this.newPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRateSCnt = this.frmRateSCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmRateGCnt = this.frmRateGCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCdFrom = this.genSpclRtTpCdFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmGrpLocCnt = this.frmGrpLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appOfcCd = this.appOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnOfcCd = this.qttnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnSrepCd = this.qttnSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
