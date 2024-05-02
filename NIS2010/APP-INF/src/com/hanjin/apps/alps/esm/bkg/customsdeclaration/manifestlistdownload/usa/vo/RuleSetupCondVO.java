/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SetupListCondVOVO.java
*@FileTitle : SetupListCondVOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.29 이수빈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListCondVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 이수빈
 * @since J2EE 1.5
 */

public class RuleSetupCondVO extends SetupListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RuleSetupCondVO> models = new ArrayList<RuleSetupCondVO>();
	
	/* Column Info */
	private String locCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String frobFlg = null;
	/* Column Info */
	private String cstmsDivId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String xptImpCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RuleSetupCondVO() {}

	public RuleSetupCondVO(String ibflag, String pagerows, String cntCd, String cstmsDivId, String locCd, String frobFlg, String xptImpCd, String blTpCd) {
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.frobFlg = frobFlg;
		this.cstmsDivId = cstmsDivId;
		this.cntCd = cntCd;
		this.xptImpCd = xptImpCd;
		this.blTpCd = blTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frob_flg", getFrobFlg());
		this.hashColumns.put("cstms_div_id", getCstmsDivId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("xpt_imp_cd", getXptImpCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frob_flg", "frobFlg");
		this.hashFields.put("cstms_div_id", "cstmsDivId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("xpt_imp_cd", "xptImpCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getLocCd() {
		return this.locCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFrobFlg() {
		return this.frobFlg;
	}
	public String getCstmsDivId() {
		return this.cstmsDivId;
	}
	public String getCntCd() {
		return this.cntCd;
	}
	public String getXptImpCd() {
		return this.xptImpCd;
	}
	public String getBlTpCd() {
		return this.blTpCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
		//this.locCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFrobFlg(String frobFlg) {
		this.frobFlg = frobFlg;
		//this.frobFlg=true;
	}
	public void setCstmsDivId(String cstmsDivId) {
		this.cstmsDivId = cstmsDivId;
		//this.cstmsDivId=true;
	}
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
		//this.cntCd=true;
	}
	public void setXptImpCd(String xptImpCd) {
		this.xptImpCd = xptImpCd;
		//this.xptImpCd=true;
	}
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
		//this.blTpCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrobFlg(JSPUtil.getParameter(request, "frob_flg", ""));
		setCstmsDivId(JSPUtil.getParameter(request, "cstms_div_id", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setXptImpCd(JSPUtil.getParameter(request, "xpt_imp_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public RuleSetupCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public RuleSetupCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RuleSetupCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] frobFlg = (JSPUtil.getParameter(request, prefix	+ "frob_flg".trim(), length));
			String[] cstmsDivId = (JSPUtil.getParameter(request, prefix	+ "cstms_div_id".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] xptImpCd = (JSPUtil.getParameter(request, prefix	+ "xpt_imp_cd".trim(), length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RuleSetupCondVO();
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frobFlg[i] != null)
					model.setFrobFlg(frobFlg[i]);
				if (cstmsDivId[i] != null)
					model.setCstmsDivId(cstmsDivId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (xptImpCd[i] != null)
					model.setXptImpCd(xptImpCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSetupListCondVOVOs();
	}

	public RuleSetupCondVO[] getSetupListCondVOVOs(){
		RuleSetupCondVO[] vos = (RuleSetupCondVO[])models.toArray(new RuleSetupCondVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frobFlg = this.frobFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDivId = this.cstmsDivId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptImpCd = this.xptImpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
