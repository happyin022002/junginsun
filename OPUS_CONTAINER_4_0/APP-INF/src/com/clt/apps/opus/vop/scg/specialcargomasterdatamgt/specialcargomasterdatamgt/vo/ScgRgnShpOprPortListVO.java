/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SqlName1VO.java
*@FileTitle : SqlName1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.21 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgRgnShpOprPortListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgRgnShpOprPortListVO> models = new ArrayList<ScgRgnShpOprPortListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String rgnShpOprDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String keyRgnShpOprCd = null;
	/* Column Info */
	private String keyLocCd = null;
	/* Column Info */
	private String rgnShpOprAbbrCd = null;
	/* Column Info */
	private String updUsrId = null;
 
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgRgnShpOprPortListVO() {}

	public ScgRgnShpOprPortListVO(String ibflag, String pagerows, String keyLocCd, String keyRgnShpOprCd, String locCd, String rgnShpOprCd, String cntNm, String rgnShpOprAbbrCd, String rgnShpOprDesc, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rgnShpOprCd = rgnShpOprCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.cntNm = cntNm;
		this.rgnShpOprDesc = rgnShpOprDesc;
		this.creUsrId = creUsrId;
		this.keyRgnShpOprCd = keyRgnShpOprCd;
		this.keyLocCd = keyLocCd;
		this.rgnShpOprAbbrCd = rgnShpOprAbbrCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("rgn_shp_opr_desc", getRgnShpOprDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("key_rgn_shp_opr_cd", getKeyRgnShpOprCd());
		this.hashColumns.put("key_loc_cd", getKeyLocCd());
		this.hashColumns.put("rgn_shp_opr_abbr_cd", getRgnShpOprAbbrCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("rgn_shp_opr_desc", "rgnShpOprDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("key_rgn_shp_opr_cd", "keyRgnShpOprCd");
		this.hashFields.put("key_loc_cd", "keyLocCd");
		this.hashFields.put("rgn_shp_opr_abbr_cd", "rgnShpOprAbbrCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}
	
	/**
	 * Column Info
	 * @return rgnShpOprDesc
	 */
	public String getRgnShpOprDesc() {
		return this.rgnShpOprDesc;
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
	 * @return keyRgnShpOprCd
	 */
	public String getKeyRgnShpOprCd() {
		return this.keyRgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return keyLocCd
	 */
	public String getKeyLocCd() {
		return this.keyLocCd;
	}
	
	/**
	 * Column Info
	 * @return rgnShpOprAbbrCd
	 */
	public String getRgnShpOprAbbrCd() {
		return this.rgnShpOprAbbrCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}
	
	/**
	 * Column Info
	 * @param rgnShpOprDesc
	 */
	public void setRgnShpOprDesc(String rgnShpOprDesc) {
		this.rgnShpOprDesc = rgnShpOprDesc;
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
	 * @param keyRgnShpOprCd
	 */
	public void setKeyRgnShpOprCd(String keyRgnShpOprCd) {
		this.keyRgnShpOprCd = keyRgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @param keyLocCd
	 */
	public void setKeyLocCd(String keyLocCd) {
		this.keyLocCd = keyLocCd;
	}
	
	/**
	 * Column Info
	 * @param rgnShpOprAbbrCd
	 */
	public void setRgnShpOprAbbrCd(String rgnShpOprAbbrCd) {
		this.rgnShpOprAbbrCd = rgnShpOprAbbrCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, "rgn_shp_opr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCntNm(JSPUtil.getParameter(request, "cnt_nm", ""));
		setRgnShpOprDesc(JSPUtil.getParameter(request, "rgn_shp_opr_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setKeyRgnShpOprCd(JSPUtil.getParameter(request, "key_rgn_shp_opr_cd", ""));
		setKeyLocCd(JSPUtil.getParameter(request, "key_loc_cd", ""));
		setRgnShpOprAbbrCd(JSPUtil.getParameter(request, "rgn_shp_opr_abbr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgRgnShpOprPortListVO[]
	 */
	public ScgRgnShpOprPortListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgRgnShpOprPortListVO[]
	 */
	public ScgRgnShpOprPortListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgRgnShpOprPortListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm".trim(), length));
			String[] rgnShpOprDesc = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_desc".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] keyRgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "key_rgn_shp_opr_cd".trim(), length));
			String[] keyLocCd = (JSPUtil.getParameter(request, prefix	+ "key_loc_cd".trim(), length));
			String[] rgnShpOprAbbrCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_abbr_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgRgnShpOprPortListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (rgnShpOprDesc[i] != null)
					model.setRgnShpOprDesc(rgnShpOprDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (keyRgnShpOprCd[i] != null)
					model.setKeyRgnShpOprCd(keyRgnShpOprCd[i]);
				if (keyLocCd[i] != null)
					model.setKeyLocCd(keyLocCd[i]);
				if (rgnShpOprAbbrCd[i] != null)
					model.setRgnShpOprAbbrCd(rgnShpOprAbbrCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgRgnShpOprPortListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgRgnShpOprPortListVO[]
	 */
	public ScgRgnShpOprPortListVO[] getScgRgnShpOprPortListVOs(){
		ScgRgnShpOprPortListVO[] vos = (ScgRgnShpOprPortListVO[])models.toArray(new ScgRgnShpOprPortListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprDesc = this.rgnShpOprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyRgnShpOprCd = this.keyRgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyLocCd = this.keyLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprAbbrCd = this.rgnShpOprAbbrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
