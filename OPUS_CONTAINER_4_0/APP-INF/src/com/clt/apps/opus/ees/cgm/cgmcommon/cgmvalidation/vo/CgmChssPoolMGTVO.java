/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmChssPoolMGTVO.java
*@FileTitle : CgmChssPoolMGTVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.21 최민회 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo;

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
 * @author 최민회
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CgmChssPoolMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CgmChssPoolMGTVO> models = new ArrayList<CgmChssPoolMGTVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String poolMgmtCoNm = null;
	/* Column Info */
	private String chssPoolNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String poolMgmtCoCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CgmChssPoolMGTVO() {}

	public CgmChssPoolMGTVO(String ibflag, String pagerows, String chssPoolCd, String chssPoolNm, String poolMgmtCoCd, String poolMgmtCoNm, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.chssPoolCd = chssPoolCd;
		this.creDt = creDt;
		this.poolMgmtCoNm = poolMgmtCoNm;
		this.chssPoolNm = chssPoolNm;
		this.updUsrId = updUsrId;
		this.poolMgmtCoCd = poolMgmtCoCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pool_mgmt_co_nm", getPoolMgmtCoNm());
		this.hashColumns.put("chss_pool_nm", getChssPoolNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pool_mgmt_co_cd", getPoolMgmtCoCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pool_mgmt_co_nm", "poolMgmtCoNm");
		this.hashFields.put("chss_pool_nm", "chssPoolNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pool_mgmt_co_cd", "poolMgmtCoCd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return poolMgmtCoNm
	 */
	public String getPoolMgmtCoNm() {
		return this.poolMgmtCoNm;
	}
	
	/**
	 * Column Info
	 * @return chssPoolNm
	 */
	public String getChssPoolNm() {
		return this.chssPoolNm;
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
	 * @return poolMgmtCoCd
	 */
	public String getPoolMgmtCoCd() {
		return this.poolMgmtCoCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param poolMgmtCoNm
	 */
	public void setPoolMgmtCoNm(String poolMgmtCoNm) {
		this.poolMgmtCoNm = poolMgmtCoNm;
	}
	
	/**
	 * Column Info
	 * @param chssPoolNm
	 */
	public void setChssPoolNm(String chssPoolNm) {
		this.chssPoolNm = chssPoolNm;
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
	 * @param poolMgmtCoCd
	 */
	public void setPoolMgmtCoCd(String poolMgmtCoCd) {
		this.poolMgmtCoCd = poolMgmtCoCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setPoolMgmtCoNm(JSPUtil.getParameter(request, "pool_mgmt_co_nm", ""));
		setChssPoolNm(JSPUtil.getParameter(request, "chss_pool_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPoolMgmtCoCd(JSPUtil.getParameter(request, "pool_mgmt_co_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CgmChssPoolMGTVO[]
	 */
	public CgmChssPoolMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CgmChssPoolMGTVO[]
	 */
	public CgmChssPoolMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CgmChssPoolMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] poolMgmtCoNm = (JSPUtil.getParameter(request, prefix	+ "pool_mgmt_co_nm", length));
			String[] chssPoolNm = (JSPUtil.getParameter(request, prefix	+ "chss_pool_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] poolMgmtCoCd = (JSPUtil.getParameter(request, prefix	+ "pool_mgmt_co_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CgmChssPoolMGTVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (poolMgmtCoNm[i] != null)
					model.setPoolMgmtCoNm(poolMgmtCoNm[i]);
				if (chssPoolNm[i] != null)
					model.setChssPoolNm(chssPoolNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (poolMgmtCoCd[i] != null)
					model.setPoolMgmtCoCd(poolMgmtCoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCgmChssPoolMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CgmChssPoolMGTVO[]
	 */
	public CgmChssPoolMGTVO[] getCgmChssPoolMGTVOs(){
		CgmChssPoolMGTVO[] vos = (CgmChssPoolMGTVO[])models.toArray(new CgmChssPoolMGTVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolMgmtCoNm = this.poolMgmtCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolNm = this.chssPoolNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolMgmtCoCd = this.poolMgmtCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
