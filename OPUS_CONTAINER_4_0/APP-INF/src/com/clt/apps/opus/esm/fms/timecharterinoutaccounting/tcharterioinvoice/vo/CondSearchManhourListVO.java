/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchManhourListVO.java
*@FileTitle : CondSearchManhourListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.11 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * @author 최우석
 * @see
 * @since J2EE 1.5
 */

public class CondSearchManhourListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchManhourListVO> models = new ArrayList<CondSearchManhourListVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpTeamCd = null;
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchManhourListVO() {}

	public CondSearchManhourListVO(String ibflag, String pagerows, String slpTpCd, String slpFuncCd, String slpTeamCd, String slpIssDt, String slpSerNo, String slpSeqNo) {
		this.ibflag = ibflag;
		this.slpSeqNo = slpSeqNo;
		this.slpTeamCd = slpTeamCd;
		this.slpFuncCd = slpFuncCd;
		this.slpIssDt = slpIssDt;
		this.slpTpCd = slpTpCd;
		this.slpSerNo = slpSerNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_team_cd", getSlpTeamCd());
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_team_cd", "slpTeamCd");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	public String getSlpTeamCd() {
		return this.slpTeamCd;
	}
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	public String getSlpIssDt() {
		return this.slpIssDt;
	}
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
		//this.slpSeqNo=true;
	}
	public void setSlpTeamCd(String slpTeamCd) {
		this.slpTeamCd = slpTeamCd;
		//this.slpTeamCd=true;
	}
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
		//this.slpFuncCd=true;
	}
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
		//this.slpIssDt=true;
	}
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
		//this.slpTpCd=true;
	}
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
		//this.slpSerNo=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slpSeqNo", ""));
		setSlpTeamCd(JSPUtil.getParameter(request, "slpTeamCd", ""));
		setSlpFuncCd(JSPUtil.getParameter(request, "slpFuncCd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slpIssDt", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slpTpCd", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slpSerNo", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CondSearchManhourListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CondSearchManhourListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchManhourListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no".trim(), length));
			String[] slpTeamCd = (JSPUtil.getParameter(request, prefix	+ "slp_team_cd".trim(), length));
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd".trim(), length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt".trim(), length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd".trim(), length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchManhourListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpTeamCd[i] != null)
					model.setSlpTeamCd(slpTeamCd[i]);
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCondSearchManhourListVOs();
	}

	public CondSearchManhourListVO[] getCondSearchManhourListVOs(){
		CondSearchManhourListVO[] vos = (CondSearchManhourListVO[])models.toArray(new CondSearchManhourListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTeamCd = this.slpTeamCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
