/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PriSpScpAmdtSmryVO.java
*@FileTitle : PriSpScpAmdtSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.06 변영주 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 변영주
 * @since J2EE 1.5
 */

public class PriSpScpAmdtSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpScpAmdtSmryVO> models = new ArrayList<PriSpScpAmdtSmryVO>();
	
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String acptFlg = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String propScpTermTpCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String amdtFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriSpScpAmdtSmryVO() {}

	public PriSpScpAmdtSmryVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String propScpTermTpCd, String amdtFlg, String acptFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updUsrId = updUsrId;
		this.acptFlg = acptFlg;
		this.ibflag = ibflag;
		this.updDt = updDt;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.propScpTermTpCd = propScpTermTpCd;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.amdtSeq = amdtSeq;
		this.amdtFlg = amdtFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("acpt_flg", getAcptFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prop_scp_term_tp_cd", getPropScpTermTpCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("amdt_flg", getAmdtFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("acpt_flg", "acptFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prop_scp_term_tp_cd", "propScpTermTpCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("amdt_flg", "amdtFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getAcptFlg() {
		return this.acptFlg;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getPropScpTermTpCd() {
		return this.propScpTermTpCd;
	}
	public String getPropNo() {
		return this.propNo;
	}
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	public String getAmdtFlg() {
		return this.amdtFlg;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setAcptFlg(String acptFlg) {
		this.acptFlg = acptFlg;
		//this.acptFlg=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setPropScpTermTpCd(String propScpTermTpCd) {
		this.propScpTermTpCd = propScpTermTpCd;
		//this.propScpTermTpCd=true;
	}
	public void setPropNo(String propNo) {
		this.propNo = propNo;
		//this.propNo=true;
	}
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
		//this.svcScpCd=true;
	}
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
		//this.amdtSeq=true;
	}
	public void setAmdtFlg(String amdtFlg) {
		this.amdtFlg = amdtFlg;
		//this.amdtFlg=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAcptFlg(JSPUtil.getParameter(request, "acpt_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPropScpTermTpCd(JSPUtil.getParameter(request, "prop_scp_term_tp_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setAmdtFlg(JSPUtil.getParameter(request, "amdt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public PriSpScpAmdtSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public PriSpScpAmdtSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpScpAmdtSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] acptFlg = (JSPUtil.getParameter(request, prefix	+ "acpt_flg".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] propScpTermTpCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_term_tp_cd".trim(), length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no".trim(), length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd".trim(), length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq".trim(), length));
			String[] amdtFlg = (JSPUtil.getParameter(request, prefix	+ "amdt_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpScpAmdtSmryVO();
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (acptFlg[i] != null)
					model.setAcptFlg(acptFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (propScpTermTpCd[i] != null)
					model.setPropScpTermTpCd(propScpTermTpCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (amdtFlg[i] != null)
					model.setAmdtFlg(amdtFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getPriSpScpAmdtSmryVOs();
	}

	public PriSpScpAmdtSmryVO[] getPriSpScpAmdtSmryVOs(){
		PriSpScpAmdtSmryVO[] vos = (PriSpScpAmdtSmryVO[])models.toArray(new PriSpScpAmdtSmryVO[models.size()]);
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
		} catch (Exception ex) {}
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
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptFlg = this.acptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpTermTpCd = this.propScpTermTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtFlg = this.amdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
