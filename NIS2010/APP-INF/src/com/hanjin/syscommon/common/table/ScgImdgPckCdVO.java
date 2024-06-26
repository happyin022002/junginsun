/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScgImdgPckCdVO.java
*@FileTitle : ScgImdgPckCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.04 이도형 
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
 * @author 이도형 
 * @since J2EE 1.5
 */

public class ScgImdgPckCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgImdgPckCdVO> models = new ArrayList<ScgImdgPckCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String imdgPckDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String imdgPckTpCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String imdgPckCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pckKndCd = null;
	/* Column Info */
	private String pckMtrlTpCd= null;
	/*	Column Info	*/
	private  String	 eaiIfFlg   =  null;
	/*	Column Info	*/
	private  String	 eaiEvntDt   =  null;
	/*	Column Info	*/
	private  String	 eaiIfId   =  null;
	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgImdgPckCdVO() {}

	public ScgImdgPckCdVO(String ibflag, String pagerows, String imdgPckCd, String imdgPckDesc, String imdgPckTpCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String pckKndCd, String pckMtrlTpCd,String eaiIfFlg,String eaiEvntDt,String eaiIfId) {
		this.updDt = updDt;
		this.imdgPckDesc = imdgPckDesc;
		this.creUsrId = creUsrId;
		this.imdgPckTpCd = imdgPckTpCd;
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.imdgPckCd = imdgPckCd;
		this.pckKndCd = pckKndCd;
		this.pckMtrlTpCd = pckMtrlTpCd;
		this.pagerows = pagerows;
		this.eaiIfFlg  = eaiIfFlg ;
		this.eaiEvntDt  = eaiEvntDt ;
		this.eaiIfId  = eaiIfId ;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("imdg_pck_desc", getImdgPckDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("imdg_pck_tp_cd", getImdgPckTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("imdg_pck_cd", getImdgPckCd());
		this.hashColumns.put("pck_knd_cd", getPckKndCd());
		this.hashColumns.put("pck_mtrl_tp_cd", getPckMtrlTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eai_if_flg", getEaiIfFlg());		
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());		
		this.hashColumns.put("eai_if_id", getEaiIfId());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("imdg_pck_desc", "imdgPckDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("imdg_pck_tp_cd", "imdgPckTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("imdg_pck_cd", "imdgPckCd");
		this.hashFields.put("pck_knd_cd", "pckKndCd");
		this.hashFields.put("pck_mtrl_tp_cd", "pckMtrlTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eai_if_flg", "eaiIfFlg");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getImdgPckDesc() {
		return this.imdgPckDesc;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getImdgPckTpCd() {
		return this.imdgPckTpCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getImdgPckCd() {
		return this.imdgPckCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	/**
	 * Column Info
	 * @return pckMtrlTpCd
	 */
	public String getPckMtrlTpCd() {
		return this.pckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @return pckKndCd
	 */
	public String getPckKndCd() {
		return this.pckKndCd;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setImdgPckDesc(String imdgPckDesc) {
		this.imdgPckDesc = imdgPckDesc;
		//this.imdgPckDesc=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setImdgPckTpCd(String imdgPckTpCd) {
		this.imdgPckTpCd = imdgPckTpCd;
		//this.imdgPckTpCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setImdgPckCd(String imdgPckCd) {
		this.imdgPckCd = imdgPckCd;
		//this.imdgPckCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * Column Info
	 * @param pckMtrlTpCd
	 */
	public void setPckMtrlTpCd(String pckMtrlTpCd) {
		this.pckMtrlTpCd = pckMtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @param pckKndCd
	 */
	public void setPckKndCd(String pckKndCd) {
		this.pckKndCd = pckKndCd;
	}
	/**
	* Column Info
	* @param  eaiIfFlg
	*/
	public void	setEaiIfFlg( String	eaiIfFlg ) {
		this.eaiIfFlg =	eaiIfFlg;
	}
 
	/**
	 * Column Info
	 * @return	eaiIfFlg
	 */
	 public	String	getEaiIfFlg() {
		 return	this.eaiIfFlg;
	 } 
 	/**
	* Column Info
	* @param  eaiEvntDt
	*/
	public void	setEaiEvntDt( String	eaiEvntDt ) {
		this.eaiEvntDt =	eaiEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	eaiEvntDt
	 */
	 public	String	getEaiEvntDt() {
		 return	this.eaiEvntDt;
	 } 
 	/**
	* Column Info
	* @param  eaiIfId
	*/
	public void	setEaiIfId( String	eaiIfId ) {
		this.eaiIfId =	eaiIfId;
	}
 
	/**
	 * Column Info
	 * @return	eaiIfId
	 */
	 public	String	getEaiIfId() {
		 return	this.eaiIfId;
	 } 
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setImdgPckDesc(JSPUtil.getParameter(request, "imdg_pck_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setImdgPckTpCd(JSPUtil.getParameter(request, "imdg_pck_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setImdgPckCd(JSPUtil.getParameter(request, "imdg_pck_cd", ""));
		setPckMtrlTpCd(JSPUtil.getParameter(request, "pck_mtrl_tp_cd", ""));
		setPckKndCd(JSPUtil.getParameter(request,  "pck_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEaiIfFlg(JSPUtil.getParameter(request,	"eai_if_flg", ""));
		setEaiEvntDt(JSPUtil.getParameter(request,	"eai_evnt_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request,	"eai_if_id", ""));
	}

	public ScgImdgPckCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ScgImdgPckCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgImdgPckCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] imdgPckDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_desc".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] imdgPckTpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_tp_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] imdgPckCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_cd".trim(), length));
			String[] pckMtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_mtrl_tp_cd", length));
			String[] pckKndCd = (JSPUtil.getParameter(request, prefix	+ "pck_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] eaiIfFlg =	(JSPUtil.getParameter(request, prefix +	"eai_if_flg".trim(),	length));
			String[] eaiEvntDt =	(JSPUtil.getParameter(request, prefix +	"eai_evnt_dt".trim(),	length));
			String[] eaiIfId =	(JSPUtil.getParameter(request, prefix +	"eai_if_id".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgImdgPckCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (imdgPckDesc[i] != null)
					model.setImdgPckDesc(imdgPckDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (imdgPckTpCd[i] != null)
					model.setImdgPckTpCd(imdgPckTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (imdgPckCd[i] != null)
					model.setImdgPckCd(imdgPckCd[i]);
				if (pckMtrlTpCd[i] != null)
					model.setPckMtrlTpCd(pckMtrlTpCd[i]);
				if (pckKndCd[i] != null)
					model.setPckKndCd(pckKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if ( eaiIfFlg[i] !=	null)
					model.setEaiIfFlg( eaiIfFlg[i]);
				if ( eaiEvntDt[i] !=	null)
					model.setEaiEvntDt( eaiEvntDt[i]);
				if ( eaiIfId[i] !=	null)
					model.setEaiIfId( eaiIfId[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getScgImdgPckCdVOs();
	}

	public ScgImdgPckCdVO[] getScgImdgPckCdVOs(){
		ScgImdgPckCdVO[] vos = (ScgImdgPckCdVO[])models.toArray(new ScgImdgPckCdVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckDesc = this.imdgPckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckTpCd = this.imdgPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckCd = this.imdgPckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckMtrlTpCd = this.pckMtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckKndCd = this.pckKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfFlg =	this.eaiIfFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt =	this.eaiEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId =	this.eaiIfId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
