/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchHubLocationListVO.java
*@FileTitle : SearchHubLocationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.07.29 김귀진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.vo;

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
 * @author 김귀진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchHubLocationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHubLocationListVO> models = new ArrayList<SearchHubLocationListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String hubLocMtchRmk = null;
	/* Column Info */
	private String inHubLocCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String inPortCd = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String inLocCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hubLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchHubLocationListVO() {}

	public SearchHubLocationListVO(String ibflag, String pagerows, String portCd, String hubLocCd, String locCd, String trspModCd, String creOfcCd, String creDt, String updDt, String creUsrId, String hubLocMtchRmk, String inPortCd, String inHubLocCd, String inLocCd,  String updUsrId) {
		this.updDt = updDt;
		this.hubLocMtchRmk = hubLocMtchRmk;
		this.inHubLocCd = inHubLocCd;
		this.creDt = creDt;
		this.trspModCd = trspModCd;
		this.inPortCd = inPortCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.inLocCd = inLocCd;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("hub_loc_mtch_rmk", getHubLocMtchRmk());
		this.hashColumns.put("in_hub_loc_cd", getInHubLocCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("in_port_cd", getInPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("in_loc_cd", getInLocCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hub_loc_cd", getHubLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("hub_loc_mtch_rmk", "hubLocMtchRmk");
		this.hashFields.put("in_hub_loc_cd", "inHubLocCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("in_port_cd", "inPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("in_loc_cd", "inLocCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hub_loc_cd", "hubLocCd");
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
	 * @return hubLocMtchRmk
	 */
	public String getHubLocMtchRmk() {
		return this.hubLocMtchRmk;
	}
	
	/**
	 * Column Info
	 * @return inHubLocCd
	 */
	public String getInHubLocCd() {
		return this.inHubLocCd;
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
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return inPortCd
	 */
	public String getInPortCd() {
		return this.inPortCd;
	}
	
	/**
	 * Column Info
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return inLocCd
	 */
	public String getInLocCd() {
		return this.inLocCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return hubLocCd
	 */
	public String getHubLocCd() {
		return this.hubLocCd;
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
	 * @param hubLocMtchRmk
	 */
	public void setHubLocMtchRmk(String hubLocMtchRmk) {
		this.hubLocMtchRmk = hubLocMtchRmk;
	}
	
	/**
	 * Column Info
	 * @param inHubLocCd
	 */
	public void setInHubLocCd(String inHubLocCd) {
		this.inHubLocCd = inHubLocCd;
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
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param inPortCd
	 */
	public void setInPortCd(String inPortCd) {
		this.inPortCd = inPortCd;
	}
	
	/**
	 * Column Info
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param inLocCd
	 */
	public void setInLocCd(String inLocCd) {
		this.inLocCd = inLocCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
	 * @param hubLocCd
	 */
	public void setHubLocCd(String hubLocCd) {
		this.hubLocCd = hubLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setHubLocMtchRmk(JSPUtil.getParameter(request, "hub_loc_mtch_rmk", ""));
		setInHubLocCd(JSPUtil.getParameter(request, "in_hub_loc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrspModCd(JSPUtil.getParameter(request, "trsp_mod_cd", ""));
		setInPortCd(JSPUtil.getParameter(request, "in_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setInLocCd(JSPUtil.getParameter(request, "in_loc_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHubLocCd(JSPUtil.getParameter(request, "hub_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHubLocationListVO[]
	 */
	public SearchHubLocationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHubLocationListVO[]
	 */
	public SearchHubLocationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHubLocationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] hubLocMtchRmk = (JSPUtil.getParameter(request, prefix	+ "hub_loc_mtch_rmk", length));
			String[] inHubLocCd = (JSPUtil.getParameter(request, prefix	+ "in_hub_loc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] inPortCd = (JSPUtil.getParameter(request, prefix	+ "in_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] inLocCd = (JSPUtil.getParameter(request, prefix	+ "in_loc_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hubLocCd = (JSPUtil.getParameter(request, prefix	+ "hub_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHubLocationListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (hubLocMtchRmk[i] != null)
					model.setHubLocMtchRmk(hubLocMtchRmk[i]);
				if (inHubLocCd[i] != null)
					model.setInHubLocCd(inHubLocCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (inPortCd[i] != null)
					model.setInPortCd(inPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (inLocCd[i] != null)
					model.setInLocCd(inLocCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hubLocCd[i] != null)
					model.setHubLocCd(hubLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHubLocationListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHubLocationListVO[]
	 */
	public SearchHubLocationListVO[] getSearchHubLocationListVOs(){
		SearchHubLocationListVO[] vos = (SearchHubLocationListVO[])models.toArray(new SearchHubLocationListVO[models.size()]);
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
		this.hubLocMtchRmk = this.hubLocMtchRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inHubLocCd = this.inHubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPortCd = this.inPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inLocCd = this.inLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubLocCd = this.hubLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
