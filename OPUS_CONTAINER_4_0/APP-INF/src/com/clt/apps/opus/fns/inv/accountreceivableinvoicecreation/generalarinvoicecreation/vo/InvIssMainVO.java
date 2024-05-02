/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvArIssVO.java
*@FileTitle : InvArIssVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김세일
 * @since J2EE 1.5
 */

public class InvIssMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvIssMainVO> models = new ArrayList<InvIssMainVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String rissDt = null;
	/* Column Info */
	private String actInvNo = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String custEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String issDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String invIssRmk = null;
	/* Column Info */
	private String custFaxNo = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String faxSndNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sendFlag = null;
	/* Column Info */
	private String issueGubn = null;
	/* Column Info */
	private String attach = null;
	/* Column Info */
	private String fKey = null;
	/* Column Info */
	private String rdName = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String nameFlag = null;
	/* Column Info */
	private String titleFlag = null;
	
//	private InvEmailFaxVO invEmailFaxVO = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvIssMainVO() {}

	public InvIssMainVO(String ibflag, String pagerows, String invNo, String invSeq, String actInvNo, String issOfcCd, String issDt, String rissDt, String invIssRmk, String custEml, String emlSndDt, String emlSndNo, String custFaxNo, String faxSndDt, String faxSndNo, String creUsrId, String creDt, String updUsrId, String sendFlag, String issueGubn, String attach, String fKey, String rdName, String vvd, String portCd, String blSrcNo, String updDt, String nameFlag, String titleFlag) {
		this.updDt = updDt;
		this.emlSndDt = emlSndDt;
		this.rissDt = rissDt;
		this.actInvNo = actInvNo;
		this.issOfcCd = issOfcCd;
		this.creDt = creDt;
		this.invSeq = invSeq;
		this.emlSndNo = emlSndNo;
		this.custEml = custEml;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.issDt = issDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.invIssRmk = invIssRmk;
		this.custFaxNo = custFaxNo;
		this.faxSndDt = faxSndDt;
		this.faxSndNo = faxSndNo;
		this.updUsrId = updUsrId;
		this.sendFlag = sendFlag;
		this.issueGubn = issueGubn;
		this.attach = attach;
		this.fKey = fKey;
		this.rdName = rdName;
		this.vvd = vvd;
		this.portCd = portCd;
		this.blSrcNo = blSrcNo;
		this.nameFlag = nameFlag;
		this.titleFlag = titleFlag;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("riss_dt", getRissDt());
		this.hashColumns.put("act_inv_no", getActInvNo());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_iss_rmk", getInvIssRmk());
		this.hashColumns.put("cust_fax_no", getCustFaxNo());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("fax_snd_no", getFaxSndNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("send_flag", getSendFlag());
		this.hashColumns.put("issue_gubn", getIssueGubn());	
		this.hashColumns.put("attach", getAttach());	
		this.hashColumns.put("f_key", getFKey());	
		this.hashColumns.put("rd_name", getRdName());	
		this.hashColumns.put("vvd", getVvd());	
		this.hashColumns.put("port_cd", getPortCd());	
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("name_flag", getNameFlag());
		this.hashColumns.put("title_flag", getTitleFlag());
		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("riss_dt", "rissDt");
		this.hashFields.put("act_inv_no", "actInvNo");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_iss_rmk", "invIssRmk");
		this.hashFields.put("cust_fax_no", "custFaxNo");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("fax_snd_no", "faxSndNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("send_flag", "sendFlag");	
		this.hashFields.put("issue_gubn", "issueGubn");
		this.hashFields.put("attach", "attach");
		this.hashFields.put("f_key", "fKey");
		this.hashFields.put("rd_name", "rdName");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("name_flag", "nameFlag");
		this.hashFields.put("title_flag", "titleFlag");
		
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	public String getRissDt() {
		return this.rissDt;
	}
	public String getActInvNo() {
		return this.actInvNo;
	}
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getInvSeq() {
		return this.invSeq;
	}
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	public String getCustEml() {
		return this.custEml;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getInvNo() {
		return this.invNo;
	}
	public String getIssDt() {
		return this.issDt;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getInvIssRmk() {
		return this.invIssRmk;
	}
	public String getCustFaxNo() {
		return this.custFaxNo;
	}
	public String getFaxSndDt() {
		return this.faxSndDt;
	}
	public String getFaxSndNo() {
		return this.faxSndNo;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
		//this.emlSndDt=true;
	}
	public void setRissDt(String rissDt) {
		this.rissDt = rissDt;
		//this.rissDt=true;
	}
	public void setActInvNo(String actInvNo) {
		this.actInvNo = actInvNo;
		//this.actInvNo=true;
	}
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
		//this.issOfcCd=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
		//this.invSeq=true;
	}
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
		//this.emlSndNo=true;
	}
	public void setCustEml(String custEml) {
		this.custEml = custEml;
		//this.custEml=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setInvNo(String invNo) {
		this.invNo = invNo;
		//this.invNo=true;
	}
	public void setIssDt(String issDt) {
		this.issDt = issDt;
		//this.issDt=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setInvIssRmk(String invIssRmk) {
		this.invIssRmk = invIssRmk;
		//this.invIssRmk=true;
	}
	public void setCustFaxNo(String custFaxNo) {
		this.custFaxNo = custFaxNo;
		//this.custFaxNo=true;
	}
	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
		//this.faxSndDt=true;
	}
	public void setFaxSndNo(String faxSndNo) {
		this.faxSndNo = faxSndNo;
		//this.faxSndNo=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}

	/**
	 * @return the sendFlag
	 */
	public String getSendFlag() {
		return sendFlag;
	}

	/**
	 * @param sendFlag the sendFlag to set
	 */

	public void setSendFlag(String sendFlag) {
		this.sendFlag = sendFlag;
	}
	
	/**
	 * @return the invEmailFaxVO
	 */
//	public InvEmailFaxVO getInvEmailFaxVO() {
//		return invEmailFaxVO;
//	}

	/**
	 * @param invEmailFaxVO the invEmailFaxVO to set
	 */
//	public void setInvEmailFaxVO(InvEmailFaxVO invEmailFaxVO) {
//		this.invEmailFaxVO = invEmailFaxVO;
//	}

	/**
	 * @return the issueGubn
	 */
	public String getIssueGubn() {
		return issueGubn;
	}

	/**
	 * @param issueGubn the issueGubn to set
	 */
	public void setIssueGubn(String issueGubn) {
		this.issueGubn = issueGubn;
	}

	/**
	 * @return the attach
	 */
	public String getAttach() {
		return attach;
	}

	/**
	 * @param add the  to set
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * @return the fKey
	 */
	public String getFKey() {
		return fKey;
	}

	/**
	 * @param key the fKey to set
	 */
	public void setFKey(String key) {
		fKey = key;
	}

	/**
	 * @return the rdName
	 */
	public String getRdName() {
		return rdName;
	}

	/**
	 * @param rdName the rdName to set
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the nameFlag
	 */
	public String getNameFlag() {
		return nameFlag;
	}

	/**
	 * @param nameFlag the nameFlag to set
	 */
	public void setNameFlag(String nameFlag) {
		this.nameFlag = nameFlag;
	}

	/**
	 * @return the titleFlag
	 */
	public String getTitleFlag() {
		return titleFlag;
	}

	/**
	 * @param titleFlag the titleFlag to set
	 */
	public void setTitleFlag(String titleFlag) {
		this.titleFlag = titleFlag;
	}

	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setEmlSndDt(JSPUtil.getParameter(request, "eml_snd_dt", ""));
		setRissDt(JSPUtil.getParameter(request, "riss_dt", ""));
		setActInvNo(JSPUtil.getParameter(request, "act_inv_no", ""));
		setIssOfcCd(JSPUtil.getParameter(request, "iss_ofc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setEmlSndNo(JSPUtil.getParameter(request, "eml_snd_no", ""));
		setCustEml(JSPUtil.getParameter(request, "cust_eml", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvIssRmk(JSPUtil.getParameter(request, "inv_iss_rmk", ""));
		setCustFaxNo(JSPUtil.getParameter(request, "cust_fax_no", ""));
		setFaxSndDt(JSPUtil.getParameter(request, "fax_snd_dt", ""));
		setFaxSndNo(JSPUtil.getParameter(request, "fax_snd_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSendFlag(JSPUtil.getParameter(request, "send_flag", ""));
		setIssueGubn(JSPUtil.getParameter(request, "issue_gubn", ""));
		setAttach(JSPUtil.getParameter(request, "attach", ""));
		setFKey(JSPUtil.getParameter(request, "f_key", ""));
		setRdName(JSPUtil.getParameter(request, "rd_name", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setNameFlag(JSPUtil.getParameter(request, "name_flag", ""));
		setTitleFlag(JSPUtil.getParameter(request, "title_flag", ""));
		
	}

	public InvIssMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public InvIssMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvIssMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt".trim(), length));
			String[] rissDt = (JSPUtil.getParameter(request, prefix	+ "riss_dt".trim(), length));
			String[] actInvNo = (JSPUtil.getParameter(request, prefix	+ "act_inv_no".trim(), length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq".trim(), length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no".trim(), length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no".trim(), length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] invIssRmk = (JSPUtil.getParameter(request, prefix	+ "inv_iss_rmk".trim(), length));
			String[] custFaxNo = (JSPUtil.getParameter(request, prefix	+ "cust_fax_no".trim(), length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt".trim(), length));
			String[] faxSndNo = (JSPUtil.getParameter(request, prefix	+ "fax_snd_no".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] sendFlag = (JSPUtil.getParameter(request, prefix	+ "send_flag".trim(), length));
			String[] issueGubn = (JSPUtil.getParameter(request, prefix	+ "issue_gubn".trim(), length));
			String[] attach = (JSPUtil.getParameter(request, prefix	+ "attach".trim(), length));
			String[] fKey = (JSPUtil.getParameter(request, prefix	+ "f_key".trim(), length));
			String[] rdName = (JSPUtil.getParameter(request, prefix	+ "rd_name".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no".trim(), length));
			String[] nameFlag = (JSPUtil.getParameter(request, prefix	+ "name_flag".trim(), length));
			String[] titleFlag = (JSPUtil.getParameter(request, prefix	+ "title_flag".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new InvIssMainVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (rissDt[i] != null)
					model.setRissDt(rissDt[i]);
				if (actInvNo[i] != null)
					model.setActInvNo(actInvNo[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (custEml[i] != null)
					model.setCustEml(custEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invIssRmk[i] != null)
					model.setInvIssRmk(invIssRmk[i]);
				if (custFaxNo[i] != null)
					model.setCustFaxNo(custFaxNo[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (faxSndNo[i] != null)
					model.setFaxSndNo(faxSndNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sendFlag[i] != null)
					model.setSendFlag(sendFlag[i]);
				if (issueGubn[i] != null)
					model.setIssueGubn(issueGubn[i]);				
				if (attach[i] != null)
					model.setAttach(attach[i]);
				if (fKey[i] != null)
					model.setFKey(fKey[i]);
				if (rdName[i] != null)
					model.setRdName(rdName[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (nameFlag[i] != null)
					model.setNameFlag(nameFlag[i]);
				if (titleFlag[i] != null)
					model.setTitleFlag(titleFlag[i]);
				
				models.add(model);
			}

		} catch (Exception e) {}
		return getInvArIssVOs();
	}

	public InvIssMainVO[] getInvArIssVOs(){
		InvIssMainVO[] vos = (InvIssMainVO[])models.toArray(new InvIssMainVO[models.size()]);
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
	 * @exception IllegalAccessException
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissDt = this.rissDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo = this.actInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssRmk = this.invIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFaxNo = this.custFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndNo = this.faxSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendFlag = this.sendFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueGubn = this.issueGubn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attach = this.attach.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fKey = this.fKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdName = this.rdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nameFlag = this.nameFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.titleFlag = this.titleFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
