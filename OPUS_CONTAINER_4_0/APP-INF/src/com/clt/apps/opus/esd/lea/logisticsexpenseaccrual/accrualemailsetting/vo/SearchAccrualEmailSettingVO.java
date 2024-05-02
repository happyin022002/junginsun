/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAccrualEmailSettingVO.java
*@FileTitle : SearchAccrualEmailSettingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : Jeon Jae Hong
*@LastVersion : 1.0
* 2009.09.21 Jeon Jae Hong 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Jeon Jae Hong
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccrualEmailSettingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccrualEmailSettingVO> models = new ArrayList<SearchAccrualEmailSettingVO>();
	
	/* Column Info */
	private String pgmSubSysCd = null;
	/* Column Info */
	private String batToEml = null;
	/* Column Info */
	private String emlSvrIp = null;
	/* Column Info */
	private String batCcEml = null;
	/* Column Info */
	private String batFmEml = null;
	/* Column Info */
	private String ifToEml = null;
	/* Column Info */
	private String batCtnt = null;
	/* Column Info */
	private String ifCcEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ifCtnt = null;
	/* Column Info */
	private String batSubjNm = null;
	/* Column Info */
	private String ifFmEml = null;
	/* Column Info */
	private String ifSubjNm = null;
	/* Column Info */
	private String ifSndFlg = null;
	/* Column Info */
	private String batSndFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccrualEmailSettingVO() {}

	public SearchAccrualEmailSettingVO(String ibflag, String pagerows, String pgmSubSysCd, String emlSvrIp, String portNo, String batFmEml, String batToEml, String batCcEml, String batSubjNm, String batCtnt, String batSndFlg, String ifFmEml, String ifToEml, String ifCcEml, String ifSubjNm, String ifCtnt, String ifSndFlg) {
		this.pgmSubSysCd = pgmSubSysCd;
		this.batToEml = batToEml;
		this.emlSvrIp = emlSvrIp;
		this.batCcEml = batCcEml;
		this.batFmEml = batFmEml;
		this.ifToEml = ifToEml;
		this.batCtnt = batCtnt;
		this.ifCcEml = ifCcEml;
		this.pagerows = pagerows;
		this.portNo = portNo;
		this.ibflag = ibflag;
		this.ifCtnt = ifCtnt;
		this.batSubjNm = batSubjNm;
		this.ifFmEml = ifFmEml;
		this.ifSubjNm = ifSubjNm;
		this.ifSndFlg = ifSndFlg;
		this.batSndFlg = batSndFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pgm_sub_sys_cd", getPgmSubSysCd());
		this.hashColumns.put("bat_to_eml", getBatToEml());
		this.hashColumns.put("eml_svr_ip", getEmlSvrIp());
		this.hashColumns.put("bat_cc_eml", getBatCcEml());
		this.hashColumns.put("bat_fm_eml", getBatFmEml());
		this.hashColumns.put("if_to_eml", getIfToEml());
		this.hashColumns.put("bat_ctnt", getBatCtnt());
		this.hashColumns.put("if_cc_eml", getIfCcEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_no", getPortNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("if_ctnt", getIfCtnt());
		this.hashColumns.put("bat_subj_nm", getBatSubjNm());
		this.hashColumns.put("if_fm_eml", getIfFmEml());
		this.hashColumns.put("if_subj_nm", getIfSubjNm());
		this.hashColumns.put("if_snd_flg", getIfSndFlg());
		this.hashColumns.put("bat_snd_flg", getBatSndFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pgm_sub_sys_cd", "pgmSubSysCd");
		this.hashFields.put("bat_to_eml", "batToEml");
		this.hashFields.put("eml_svr_ip", "emlSvrIp");
		this.hashFields.put("bat_cc_eml", "batCcEml");
		this.hashFields.put("bat_fm_eml", "batFmEml");
		this.hashFields.put("if_to_eml", "ifToEml");
		this.hashFields.put("bat_ctnt", "batCtnt");
		this.hashFields.put("if_cc_eml", "ifCcEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_no", "portNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("if_ctnt", "ifCtnt");
		this.hashFields.put("bat_subj_nm", "batSubjNm");
		this.hashFields.put("if_fm_eml", "ifFmEml");
		this.hashFields.put("if_subj_nm", "ifSubjNm");
		this.hashFields.put("if_snd_flg", "ifSndFlg");
		this.hashFields.put("bat_snd_flg", "batSndFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pgmSubSysCd
	 */
	public String getPgmSubSysCd() {
		return this.pgmSubSysCd;
	}
	
	/**
	 * Column Info
	 * @return batToEml
	 */
	public String getBatToEml() {
		return this.batToEml;
	}
	
	/**
	 * Column Info
	 * @return emlSvrIp
	 */
	public String getEmlSvrIp() {
		return this.emlSvrIp;
	}
	
	/**
	 * Column Info
	 * @return batCcEml
	 */
	public String getBatCcEml() {
		return this.batCcEml;
	}
	
	/**
	 * Column Info
	 * @return batFmEml
	 */
	public String getBatFmEml() {
		return this.batFmEml;
	}
	
	/**
	 * Column Info
	 * @return ifToEml
	 */
	public String getIfToEml() {
		return this.ifToEml;
	}
	
	/**
	 * Column Info
	 * @return batCtnt
	 */
	public String getBatCtnt() {
		return this.batCtnt;
	}
	
	/**
	 * Column Info
	 * @return ifCcEml
	 */
	public String getIfCcEml() {
		return this.ifCcEml;
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
	 * @return portNo
	 */
	public String getPortNo() {
		return this.portNo;
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
	 * @return ifCtnt
	 */
	public String getIfCtnt() {
		return this.ifCtnt;
	}
	
	/**
	 * Column Info
	 * @return batSubjNm
	 */
	public String getBatSubjNm() {
		return this.batSubjNm;
	}
	
	/**
	 * Column Info
	 * @return ifFmEml
	 */
	public String getIfFmEml() {
		return this.ifFmEml;
	}
	
	/**
	 * Column Info
	 * @return ifSubjNm
	 */
	public String getIfSubjNm() {
		return this.ifSubjNm;
	}
	
	/**
	 * Column Info
	 * @return ifSndFlg
	 */
	public String getIfSndFlg() {
		return this.ifSndFlg;
	}
	
	/**
	 * Column Info
	 * @return batSndFlg
	 */
	public String getBatSndFlg() {
		return this.batSndFlg;
	}
	

	/**
	 * Column Info
	 * @param pgmSubSysCd
	 */
	public void setPgmSubSysCd(String pgmSubSysCd) {
		this.pgmSubSysCd = pgmSubSysCd;
	}
	
	/**
	 * Column Info
	 * @param batToEml
	 */
	public void setBatToEml(String batToEml) {
		this.batToEml = batToEml;
	}
	
	/**
	 * Column Info
	 * @param emlSvrIp
	 */
	public void setEmlSvrIp(String emlSvrIp) {
		this.emlSvrIp = emlSvrIp;
	}
	
	/**
	 * Column Info
	 * @param batCcEml
	 */
	public void setBatCcEml(String batCcEml) {
		this.batCcEml = batCcEml;
	}
	
	/**
	 * Column Info
	 * @param batFmEml
	 */
	public void setBatFmEml(String batFmEml) {
		this.batFmEml = batFmEml;
	}
	
	/**
	 * Column Info
	 * @param ifToEml
	 */
	public void setIfToEml(String ifToEml) {
		this.ifToEml = ifToEml;
	}
	
	/**
	 * Column Info
	 * @param batCtnt
	 */
	public void setBatCtnt(String batCtnt) {
		this.batCtnt = batCtnt;
	}
	
	/**
	 * Column Info
	 * @param ifCcEml
	 */
	public void setIfCcEml(String ifCcEml) {
		this.ifCcEml = ifCcEml;
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
	 * @param portNo
	 */
	public void setPortNo(String portNo) {
		this.portNo = portNo;
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
	 * @param ifCtnt
	 */
	public void setIfCtnt(String ifCtnt) {
		this.ifCtnt = ifCtnt;
	}
	
	/**
	 * Column Info
	 * @param batSubjNm
	 */
	public void setBatSubjNm(String batSubjNm) {
		this.batSubjNm = batSubjNm;
	}
	
	/**
	 * Column Info
	 * @param ifFmEml
	 */
	public void setIfFmEml(String ifFmEml) {
		this.ifFmEml = ifFmEml;
	}
	
	/**
	 * Column Info
	 * @param ifSubjNm
	 */
	public void setIfSubjNm(String ifSubjNm) {
		this.ifSubjNm = ifSubjNm;
	}
	
	/**
	 * Column Info
	 * @param ifSndFlg
	 */
	public void setIfSndFlg(String ifSndFlg) {
		this.ifSndFlg = ifSndFlg;
	}
	
	/**
	 * Column Info
	 * @param batSndFlg
	 */
	public void setBatSndFlg(String batSndFlg) {
		this.batSndFlg = batSndFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPgmSubSysCd(JSPUtil.getParameter(request, "pgm_sub_sys_cd", ""));
		setBatToEml(JSPUtil.getParameter(request, "bat_to_eml", ""));
		setEmlSvrIp(JSPUtil.getParameter(request, "eml_svr_ip", ""));
		setBatCcEml(JSPUtil.getParameter(request, "bat_cc_eml", ""));
		setBatFmEml(JSPUtil.getParameter(request, "bat_fm_eml", ""));
		setIfToEml(JSPUtil.getParameter(request, "if_to_eml", ""));
		setBatCtnt(JSPUtil.getParameter(request, "bat_ctnt", ""));
		setIfCcEml(JSPUtil.getParameter(request, "if_cc_eml", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPortNo(JSPUtil.getParameter(request, "port_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIfCtnt(JSPUtil.getParameter(request, "if_ctnt", ""));
		setBatSubjNm(JSPUtil.getParameter(request, "bat_subj_nm", ""));
		setIfFmEml(JSPUtil.getParameter(request, "if_fm_eml", ""));
		setIfSubjNm(JSPUtil.getParameter(request, "if_subj_nm", ""));
		setIfSndFlg(JSPUtil.getParameter(request, "if_snd_flg", ""));
		setBatSndFlg(JSPUtil.getParameter(request, "bat_snd_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccrualEmailSettingVO[]
	 */
	public SearchAccrualEmailSettingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccrualEmailSettingVO[]
	 */
	public SearchAccrualEmailSettingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccrualEmailSettingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pgmSubSysCd = (JSPUtil.getParameter(request, prefix	+ "pgm_sub_sys_cd", length));
			String[] batToEml = (JSPUtil.getParameter(request, prefix	+ "bat_to_eml", length));
			String[] emlSvrIp = (JSPUtil.getParameter(request, prefix	+ "eml_svr_ip", length));
			String[] batCcEml = (JSPUtil.getParameter(request, prefix	+ "bat_cc_eml", length));
			String[] batFmEml = (JSPUtil.getParameter(request, prefix	+ "bat_fm_eml", length));
			String[] ifToEml = (JSPUtil.getParameter(request, prefix	+ "if_to_eml", length));
			String[] batCtnt = (JSPUtil.getParameter(request, prefix	+ "bat_ctnt", length));
			String[] ifCcEml = (JSPUtil.getParameter(request, prefix	+ "if_cc_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] portNo = (JSPUtil.getParameter(request, prefix	+ "port_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ifCtnt = (JSPUtil.getParameter(request, prefix	+ "if_ctnt", length));
			String[] batSubjNm = (JSPUtil.getParameter(request, prefix	+ "bat_subj_nm", length));
			String[] ifFmEml = (JSPUtil.getParameter(request, prefix	+ "if_fm_eml", length));
			String[] ifSubjNm = (JSPUtil.getParameter(request, prefix	+ "if_subj_nm", length));
			String[] ifSndFlg = (JSPUtil.getParameter(request, prefix	+ "if_snd_flg", length));
			String[] batSndFlg = (JSPUtil.getParameter(request, prefix	+ "bat_snd_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccrualEmailSettingVO();
				if (pgmSubSysCd[i] != null)
					model.setPgmSubSysCd(pgmSubSysCd[i]);
				if (batToEml[i] != null)
					model.setBatToEml(batToEml[i]);
				if (emlSvrIp[i] != null)
					model.setEmlSvrIp(emlSvrIp[i]);
				if (batCcEml[i] != null)
					model.setBatCcEml(batCcEml[i]);
				if (batFmEml[i] != null)
					model.setBatFmEml(batFmEml[i]);
				if (ifToEml[i] != null)
					model.setIfToEml(ifToEml[i]);
				if (batCtnt[i] != null)
					model.setBatCtnt(batCtnt[i]);
				if (ifCcEml[i] != null)
					model.setIfCcEml(ifCcEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portNo[i] != null)
					model.setPortNo(portNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ifCtnt[i] != null)
					model.setIfCtnt(ifCtnt[i]);
				if (batSubjNm[i] != null)
					model.setBatSubjNm(batSubjNm[i]);
				if (ifFmEml[i] != null)
					model.setIfFmEml(ifFmEml[i]);
				if (ifSubjNm[i] != null)
					model.setIfSubjNm(ifSubjNm[i]);
				if (ifSndFlg[i] != null)
					model.setIfSndFlg(ifSndFlg[i]);
				if (batSndFlg[i] != null)
					model.setBatSndFlg(batSndFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccrualEmailSettingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccrualEmailSettingVO[]
	 */
	public SearchAccrualEmailSettingVO[] getSearchAccrualEmailSettingVOs(){
		SearchAccrualEmailSettingVO[] vos = (SearchAccrualEmailSettingVO[])models.toArray(new SearchAccrualEmailSettingVO[models.size()]);
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
		this.pgmSubSysCd = this.pgmSubSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batToEml = this.batToEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSvrIp = this.emlSvrIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batCcEml = this.batCcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batFmEml = this.batFmEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifToEml = this.ifToEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batCtnt = this.batCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCcEml = this.ifCcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portNo = this.portNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifCtnt = this.ifCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSubjNm = this.batSubjNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFmEml = this.ifFmEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSubjNm = this.ifSubjNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSndFlg = this.ifSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batSndFlg = this.batSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
