/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SaveOceanLinkRHQVO.java
*@FileTitle : SaveOceanLinkRHQVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.17 김귀진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanlinkmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SaveOceanLinkRHQVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SaveOceanLinkRHQVO> models = new ArrayList<SaveOceanLinkRHQVO>();
	
	/* Column Info */
	private String sTo = null;
	/* Column Info */
	private String sLane = null;
	/* Column Info */
	private String hFrom = null;
	/* Column Info */
	private String sMn = null;
	/* Column Info */
	private String sDr = null;
	/* Column Info */
	private String sTe = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hLane = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sTTime = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String sWb = null;
	/* Column Info */
	private String sFrom = null;
	/* Column Info */
	private String sSpBdName = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sTu = null;
	/* Column Info */
	private String sSn = null;
	/* Column Info */
	private String hTo = null;
	/* Column Info */
	private String sFqc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sFi = null;
	/* Column Info */
	private String sSt = null;
	/* Column Info */
	private String sSpBd = null;
	/* Column Info */
	private String sBd = null;
	/* Column Info */
	private String hChkLaneDirTztm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SaveOceanLinkRHQVO() {}

	public SaveOceanLinkRHQVO(String ibflag, String pagerows, String sLane, String sFrom, String sTo, String sTTime, String sFqc, String sBd, String sDr, String sSpBd, String sSpBdName, String sSn, String sMn, String sTe, String sWb, String sTu, String sFi, String sSt, String hChkLaneDirTztm, String creOfcCd, String creUsrId, String updUsrId, String hLane, String hFrom, String hTo) {
		this.sTo = sTo;
		this.sLane = sLane;
		this.hFrom = hFrom;
		this.sMn = sMn;
		this.sDr = sDr;
		this.sTe = sTe;
		this.pagerows = pagerows;
		this.hLane = hLane;
		this.ibflag = ibflag;
		this.sTTime = sTTime;
		this.creOfcCd = creOfcCd;
		this.sWb = sWb;
		this.sFrom = sFrom;
		this.sSpBdName = sSpBdName;
		this.updUsrId = updUsrId;
		this.sTu = sTu;
		this.sSn = sSn;
		this.hTo = hTo;
		this.sFqc = sFqc;
		this.creUsrId = creUsrId;
		this.sFi = sFi;
		this.sSt = sSt;
		this.sSpBd = sSpBd;
		this.sBd = sBd;
		this.hChkLaneDirTztm = hChkLaneDirTztm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_to", getSTo());
		this.hashColumns.put("s_lane", getSLane());
		this.hashColumns.put("h_from", getHFrom());
		this.hashColumns.put("s_mn", getSMn());
		this.hashColumns.put("s_dr", getSDr());
		this.hashColumns.put("s_te", getSTe());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("h_lane", getHLane());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_t_time", getSTTime());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("s_wb", getSWb());
		this.hashColumns.put("s_from", getSFrom());
		this.hashColumns.put("s_sp_bd_name", getSSpBdName());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("s_tu", getSTu());
		this.hashColumns.put("s_sn", getSSn());
		this.hashColumns.put("h_to", getHTo());
		this.hashColumns.put("s_fqc", getSFqc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("s_fi", getSFi());
		this.hashColumns.put("s_st", getSSt());
		this.hashColumns.put("s_sp_bd", getSSpBd());
		this.hashColumns.put("s_bd", getSBd());
		this.hashColumns.put("h_chk_lane_dir_tztm", getHChkLaneDirTztm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_to", "sTo");
		this.hashFields.put("s_lane", "sLane");
		this.hashFields.put("h_from", "hFrom");
		this.hashFields.put("s_mn", "sMn");
		this.hashFields.put("s_dr", "sDr");
		this.hashFields.put("s_te", "sTe");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("h_lane", "hLane");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_t_time", "sTTime");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("s_wb", "sWb");
		this.hashFields.put("s_from", "sFrom");
		this.hashFields.put("s_sp_bd_name", "sSpBdName");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("s_tu", "sTu");
		this.hashFields.put("s_sn", "sSn");
		this.hashFields.put("h_to", "hTo");
		this.hashFields.put("s_fqc", "sFqc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("s_fi", "sFi");
		this.hashFields.put("s_st", "sSt");
		this.hashFields.put("s_sp_bd", "sSpBd");
		this.hashFields.put("s_bd", "sBd");
		this.hashFields.put("h_chk_lane_dir_tztm", "hChkLaneDirTztm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sTo
	 */
	public String getSTo() {
		return this.sTo;
	}
	
	/**
	 * Column Info
	 * @return sLane
	 */
	public String getSLane() {
		return this.sLane;
	}
	
	/**
	 * Column Info
	 * @return hFrom
	 */
	public String getHFrom() {
		return this.hFrom;
	}
	
	/**
	 * Column Info
	 * @return sMn
	 */
	public String getSMn() {
		return this.sMn;
	}
	
	/**
	 * Column Info
	 * @return sDr
	 */
	public String getSDr() {
		return this.sDr;
	}
	
	/**
	 * Column Info
	 * @return sTe
	 */
	public String getSTe() {
		return this.sTe;
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
	 * @return hLane
	 */
	public String getHLane() {
		return this.hLane;
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
	 * @return sTTime
	 */
	public String getSTTime() {
		return this.sTTime;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sWb
	 */
	public String getSWb() {
		return this.sWb;
	}
	
	/**
	 * Column Info
	 * @return sFrom
	 */
	public String getSFrom() {
		return this.sFrom;
	}
	
	/**
	 * Column Info
	 * @return sSpBdName
	 */
	public String getSSpBdName() {
		return this.sSpBdName;
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
	 * @return sTu
	 */
	public String getSTu() {
		return this.sTu;
	}
	
	/**
	 * Column Info
	 * @return sSn
	 */
	public String getSSn() {
		return this.sSn;
	}
	
	/**
	 * Column Info
	 * @return hTo
	 */
	public String getHTo() {
		return this.hTo;
	}
	
	/**
	 * Column Info
	 * @return sFqc
	 */
	public String getSFqc() {
		return this.sFqc;
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
	 * @return sFi
	 */
	public String getSFi() {
		return this.sFi;
	}
	
	/**
	 * Column Info
	 * @return sSt
	 */
	public String getSSt() {
		return this.sSt;
	}
	
	/**
	 * Column Info
	 * @return sSpBd
	 */
	public String getSSpBd() {
		return this.sSpBd;
	}
	
	/**
	 * Column Info
	 * @return sBd
	 */
	public String getSBd() {
		return this.sBd;
	}
	
	/**
	 * Column Info
	 * @return hChkLaneDirTztm
	 */
	public String getHChkLaneDirTztm() {
		return this.hChkLaneDirTztm;
	}
	

	/**
	 * Column Info
	 * @param sTo
	 */
	public void setSTo(String sTo) {
		this.sTo = sTo;
	}
	
	/**
	 * Column Info
	 * @param sLane
	 */
	public void setSLane(String sLane) {
		this.sLane = sLane;
	}
	
	/**
	 * Column Info
	 * @param hFrom
	 */
	public void setHFrom(String hFrom) {
		this.hFrom = hFrom;
	}
	
	/**
	 * Column Info
	 * @param sMn
	 */
	public void setSMn(String sMn) {
		this.sMn = sMn;
	}
	
	/**
	 * Column Info
	 * @param sDr
	 */
	public void setSDr(String sDr) {
		this.sDr = sDr;
	}
	
	/**
	 * Column Info
	 * @param sTe
	 */
	public void setSTe(String sTe) {
		this.sTe = sTe;
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
	 * @param hLane
	 */
	public void setHLane(String hLane) {
		this.hLane = hLane;
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
	 * @param sTTime
	 */
	public void setSTTime(String sTTime) {
		this.sTTime = sTTime;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sWb
	 */
	public void setSWb(String sWb) {
		this.sWb = sWb;
	}
	
	/**
	 * Column Info
	 * @param sFrom
	 */
	public void setSFrom(String sFrom) {
		this.sFrom = sFrom;
	}
	
	/**
	 * Column Info
	 * @param sSpBdName
	 */
	public void setSSpBdName(String sSpBdName) {
		this.sSpBdName = sSpBdName;
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
	 * @param sTu
	 */
	public void setSTu(String sTu) {
		this.sTu = sTu;
	}
	
	/**
	 * Column Info
	 * @param sSn
	 */
	public void setSSn(String sSn) {
		this.sSn = sSn;
	}
	
	/**
	 * Column Info
	 * @param hTo
	 */
	public void setHTo(String hTo) {
		this.hTo = hTo;
	}
	
	/**
	 * Column Info
	 * @param sFqc
	 */
	public void setSFqc(String sFqc) {
		this.sFqc = sFqc;
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
	 * @param sFi
	 */
	public void setSFi(String sFi) {
		this.sFi = sFi;
	}
	
	/**
	 * Column Info
	 * @param sSt
	 */
	public void setSSt(String sSt) {
		this.sSt = sSt;
	}
	
	/**
	 * Column Info
	 * @param sSpBd
	 */
	public void setSSpBd(String sSpBd) {
		this.sSpBd = sSpBd;
	}
	
	/**
	 * Column Info
	 * @param sBd
	 */
	public void setSBd(String sBd) {
		this.sBd = sBd;
	}
	
	/**
	 * Column Info
	 * @param hChkLaneDirTztm
	 */
	public void setHChkLaneDirTztm(String hChkLaneDirTztm) {
		this.hChkLaneDirTztm = hChkLaneDirTztm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSTo(JSPUtil.getParameter(request, "s_to", ""));
		setSLane(JSPUtil.getParameter(request, "s_lane", ""));
		setHFrom(JSPUtil.getParameter(request, "h_from", ""));
		setSMn(JSPUtil.getParameter(request, "s_mn", ""));
		setSDr(JSPUtil.getParameter(request, "s_dr", ""));
		setSTe(JSPUtil.getParameter(request, "s_te", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHLane(JSPUtil.getParameter(request, "h_lane", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSTTime(JSPUtil.getParameter(request, "s_t_time", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setSWb(JSPUtil.getParameter(request, "s_wb", ""));
		setSFrom(JSPUtil.getParameter(request, "s_from", ""));
		setSSpBdName(JSPUtil.getParameter(request, "s_sp_bd_name", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSTu(JSPUtil.getParameter(request, "s_tu", ""));
		setSSn(JSPUtil.getParameter(request, "s_sn", ""));
		setHTo(JSPUtil.getParameter(request, "h_to", ""));
		setSFqc(JSPUtil.getParameter(request, "s_fqc", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSFi(JSPUtil.getParameter(request, "s_fi", ""));
		setSSt(JSPUtil.getParameter(request, "s_st", ""));
		setSSpBd(JSPUtil.getParameter(request, "s_sp_bd", ""));
		setSBd(JSPUtil.getParameter(request, "s_bd", ""));
		setHChkLaneDirTztm(JSPUtil.getParameter(request, "h_chk_lane_dir_tztm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SaveOceanLinkRHQVO[]
	 */
	public SaveOceanLinkRHQVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SaveOceanLinkRHQVO[]
	 */
	public SaveOceanLinkRHQVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SaveOceanLinkRHQVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sTo = (JSPUtil.getParameter(request, prefix	+ "s_to", length));
			String[] sLane = (JSPUtil.getParameter(request, prefix	+ "s_lane", length));
			String[] hFrom = (JSPUtil.getParameter(request, prefix	+ "h_from", length));
			String[] sMn = (JSPUtil.getParameter(request, prefix	+ "s_mn", length));
			String[] sDr = (JSPUtil.getParameter(request, prefix	+ "s_dr", length));
			String[] sTe = (JSPUtil.getParameter(request, prefix	+ "s_te", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hLane = (JSPUtil.getParameter(request, prefix	+ "h_lane", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sTTime = (JSPUtil.getParameter(request, prefix	+ "s_t_time", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] sWb = (JSPUtil.getParameter(request, prefix	+ "s_wb", length));
			String[] sFrom = (JSPUtil.getParameter(request, prefix	+ "s_from", length));
			String[] sSpBdName = (JSPUtil.getParameter(request, prefix	+ "s_sp_bd_name", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sTu = (JSPUtil.getParameter(request, prefix	+ "s_tu", length));
			String[] sSn = (JSPUtil.getParameter(request, prefix	+ "s_sn", length));
			String[] hTo = (JSPUtil.getParameter(request, prefix	+ "h_to", length));
			String[] sFqc = (JSPUtil.getParameter(request, prefix	+ "s_fqc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sFi = (JSPUtil.getParameter(request, prefix	+ "s_fi", length));
			String[] sSt = (JSPUtil.getParameter(request, prefix	+ "s_st", length));
			String[] sSpBd = (JSPUtil.getParameter(request, prefix	+ "s_sp_bd", length));
			String[] sBd = (JSPUtil.getParameter(request, prefix	+ "s_bd", length));
			String[] hChkLaneDirTztm = (JSPUtil.getParameter(request, prefix	+ "h_chk_lane_dir_tztm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SaveOceanLinkRHQVO();
				if (sTo[i] != null)
					model.setSTo(sTo[i]);
				if (sLane[i] != null)
					model.setSLane(sLane[i]);
				if (hFrom[i] != null)
					model.setHFrom(hFrom[i]);
				if (sMn[i] != null)
					model.setSMn(sMn[i]);
				if (sDr[i] != null)
					model.setSDr(sDr[i]);
				if (sTe[i] != null)
					model.setSTe(sTe[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hLane[i] != null)
					model.setHLane(hLane[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sTTime[i] != null)
					model.setSTTime(sTTime[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (sWb[i] != null)
					model.setSWb(sWb[i]);
				if (sFrom[i] != null)
					model.setSFrom(sFrom[i]);
				if (sSpBdName[i] != null)
					model.setSSpBdName(sSpBdName[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sTu[i] != null)
					model.setSTu(sTu[i]);
				if (sSn[i] != null)
					model.setSSn(sSn[i]);
				if (hTo[i] != null)
					model.setHTo(hTo[i]);
				if (sFqc[i] != null)
					model.setSFqc(sFqc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sFi[i] != null)
					model.setSFi(sFi[i]);
				if (sSt[i] != null)
					model.setSSt(sSt[i]);
				if (sSpBd[i] != null)
					model.setSSpBd(sSpBd[i]);
				if (sBd[i] != null)
					model.setSBd(sBd[i]);
				if (hChkLaneDirTztm[i] != null)
					model.setHChkLaneDirTztm(hChkLaneDirTztm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSaveOceanLinkRHQVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SaveOceanLinkRHQVO[]
	 */
	public SaveOceanLinkRHQVO[] getSaveOceanLinkRHQVOs(){
		SaveOceanLinkRHQVO[] vos = (SaveOceanLinkRHQVO[])models.toArray(new SaveOceanLinkRHQVO[models.size()]);
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
		this.sTo = this.sTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLane = this.sLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hFrom = this.hFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sMn = this.sMn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDr = this.sDr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTe = this.sTe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hLane = this.hLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTTime = this.sTTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sWb = this.sWb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFrom = this.sFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpBdName = this.sSpBdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTu = this.sTu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSn = this.sSn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hTo = this.hTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFqc = this.sFqc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFi = this.sFi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSt = this.sSt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSpBd = this.sSpBd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBd = this.sBd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hChkLaneDirTztm = this.hChkLaneDirTztm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
