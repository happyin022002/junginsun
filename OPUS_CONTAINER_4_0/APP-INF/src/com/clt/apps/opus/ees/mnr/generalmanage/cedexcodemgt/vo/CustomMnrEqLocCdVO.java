/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MnrEqLocCdVO.java
*@FileTitle : MnrEqLocCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

import org.apache.log4j.Logger; 
 
/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박명신
 * @since J2EE 1.5 
 * @see AbstractValueObject  
 */

public class CustomMnrEqLocCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	   
	private Collection<CustomMnrEqLocCdVO> models = new ArrayList<CustomMnrEqLocCdVO>();
	private Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo");
	  
	/* Column Inpo */ 
	private String updDt = null;
	/* Column Inpo */
	private String eqLocCdLvl = null;
	/* Column Inpo */
	private String creUsrId = null;
	/* Column Inpo */
	private String eqLocCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Inpo */
	private String eqLocPrntCd = null;
	/* Column Inpo */
	private String creDt = null;
	/* Column Inpo */
	private String eqKndCd = null;
	/* Column Inpo */
	private String eqLocNm = null;
	/* Column Inpo */
	private String updUsrId = null;
	/* Column Inpo */
	private String eqLess20ftFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrEqLocCdVO() {}

	/**
	 * CustomMnrEqLocCdVO 객체를 생성
	 */
	public CustomMnrEqLocCdVO(String ibflag, String pagerows, String eqLocCdLvl, String eqLocCd, String eqLocNm, String eqLess20ftFlg, String eqKndCd, String eqLocPrntCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.eqLocCdLvl = eqLocCdLvl;
		this.creUsrId = creUsrId;
		this.eqLocCd = eqLocCd;
		this.ibflag = ibflag;
		this.eqLocPrntCd = eqLocPrntCd;
		this.creDt = creDt;
		this.eqKndCd = eqKndCd;
		this.eqLocNm = eqLocNm;
		this.updUsrId = updUsrId;
		this.eqLess20ftFlg = eqLess20ftFlg;
		this.pagerows = pagerows; 
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eq_loc_cd_lvl", getEqLocCdLvl());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_loc_prnt_cd", getEqLocPrntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_loc_nm", getEqLocNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eq_less_20ft_flg", getEqLess20ftFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eq_loc_cd_lvl", "eqLocCdLvl");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_loc_prnt_cd", "eqLocPrntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_loc_nm", "eqLocNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eq_less_20ft_flg", "eqLess20ftFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getEqLocCdLvl() {
		return this.eqLocCdLvl;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getEqLocCd() {
		return this.eqLocCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getEqLocPrntCd() {
		return this.eqLocPrntCd;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	public String getEqLocNm() {
		return this.eqLocNm;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getEqLess20ftFlg() {
		return this.eqLess20ftFlg;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setEqLocCdLvl(String eqLocCdLvl) {
		this.eqLocCdLvl = eqLocCdLvl;
		//this.eqLocCdLvl=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setEqLocCd(String eqLocCd) {
		this.eqLocCd = eqLocCd;
		//this.eqLocCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setEqLocPrntCd(String eqLocPrntCd) {
		this.eqLocPrntCd = eqLocPrntCd;
		//this.eqLocPrntCd=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
		//this.eqKndCd=true;
	}
	public void setEqLocNm(String eqLocNm) {
		this.eqLocNm = eqLocNm;
		//this.eqLocNm=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setEqLess20ftFlg(String eqLess20ftFlg) {
		this.eqLess20ftFlg = eqLess20ftFlg;
		//this.eqLess20ftFlg=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * request로 받아온 화면값을 해당 VO로 매핑한다.
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setEqLocCdLvl(JSPUtil.getParameter(request, "eq_loc_cd_lvl", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEqLocCd(JSPUtil.getParameter(request, "eq_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqLocPrntCd(JSPUtil.getParameter(request, "eq_loc_prnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqLocNm(JSPUtil.getParameter(request, "eq_loc_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEqLess20ftFlg(JSPUtil.getParameter(request, "eq_less_20ft_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CustomMnrEqLocCdVO[]   VO배열로    
	 */
	public CustomMnrEqLocCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CustomMnrEqLocCdVO[]   VO배열로    
	 */
	public CustomMnrEqLocCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrEqLocCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] eqLocCdLvl = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd_lvl".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eqLocPrntCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_prnt_cd".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] eqLocNm = (JSPUtil.getParameter(request, prefix	+ "eq_loc_nm".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] eqLess20ftFlg = (JSPUtil.getParameter(request, prefix	+ "eq_less_20ft_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrEqLocCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eqLocCdLvl[i] != null)
					model.setEqLocCdLvl(eqLocCdLvl[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqLocPrntCd[i] != null)
					model.setEqLocPrntCd(eqLocPrntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqLocNm[i] != null)
					model.setEqLocNm(eqLocNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eqLess20ftFlg[i] != null)
					model.setEqLess20ftFlg(eqLess20ftFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(),e); 
		}
		return getMnrEqLocCdVOs();
	}

	/**
	 * getMnrEqLocCdVOs 
	 * @return	CustomMnrEqLocCdVO[]   VO배열로    
	 */
	public CustomMnrEqLocCdVO[] getMnrEqLocCdVOs(){
		CustomMnrEqLocCdVO[] vos = (CustomMnrEqLocCdVO[])models.toArray(new CustomMnrEqLocCdVO[models.size()]);
		return vos;
	}
	
	/**
	 * 전체 필드네임을 리턴  
	 * @return String
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
			log.error(ex.getMessage(),ex);  
		}
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
			throw new IllegalAccessException(ex.getMessage());     
		}
		return arr; 
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCdLvl = this.eqLocCdLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCd = this.eqLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocPrntCd = this.eqLocPrntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocNm = this.eqLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLess20ftFlg = this.eqLess20ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
