/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonClzVO.java
*@FileTitle : MonClzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.07.24 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.vo;

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
 * @author 최정미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MonClzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MonClzVO> models = new ArrayList<MonClzVO>();
	
	/* Column Info */
	private String atUpdDt = null;
	/* Column Info */
	private String inUpdDt = null;
	/* Column Info */
	private String atCreDt = null;
	/* Column Info */
	private String atClzDivCd = null;
	/* Column Info */
	private String atCreUsrId = null;
	/* Column Info */
	private String inClzYrmon = null;
	/* Column Info */
	private String inUpdUsrId = null;
	/* Column Info */
	private String inCreDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inClzDt = null;
	/* Column Info */
	private String inGlIfFlg = null;
	/* Column Info */
	private String atClzDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inClzDivCd = null;
	/* Column Info */
	private String inClzFlg = null;
	/* Column Info */
	private String glifClzYrmon = null;
	/* Column Info */
	private String atUpdUsrId = null;
	/* Column Info */
	private String inCreUsrId = null;
	/* Column Info */
	private String atClzFlg = null;
	/* Column Info */
	private String atClzYrmon = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MonClzVO() {}

	public MonClzVO(String ibflag, String pagerows, String inClzYrmon, String inClzDivCd, String inClzDt, String inClzFlg, String inGlIfFlg, String inCreUsrId, String inCreDt, String inUpdUsrId, String inUpdDt, String atClzYrmon, String atClzDivCd, String atClzDt, String atClzFlg, String atCreUsrId, String atCreDt, String atUpdUsrId, String atUpdDt, String glifClzYrmon) {
		this.atUpdDt = atUpdDt;
		this.inUpdDt = inUpdDt;
		this.atCreDt = atCreDt;
		this.atClzDivCd = atClzDivCd;
		this.atCreUsrId = atCreUsrId;
		this.inClzYrmon = inClzYrmon;
		this.inUpdUsrId = inUpdUsrId;
		this.inCreDt = inCreDt;
		this.pagerows = pagerows;
		this.inClzDt = inClzDt;
		this.inGlIfFlg = inGlIfFlg;
		this.atClzDt = atClzDt;
		this.ibflag = ibflag;
		this.inClzDivCd = inClzDivCd;
		this.inClzFlg = inClzFlg;
		this.glifClzYrmon = glifClzYrmon;
		this.atUpdUsrId = atUpdUsrId;
		this.inCreUsrId = inCreUsrId;
		this.atClzFlg = atClzFlg;
		this.atClzYrmon = atClzYrmon;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("at_upd_dt", getAtUpdDt());
		this.hashColumns.put("in_upd_dt", getInUpdDt());
		this.hashColumns.put("at_cre_dt", getAtCreDt());
		this.hashColumns.put("at_clz_div_cd", getAtClzDivCd());
		this.hashColumns.put("at_cre_usr_id", getAtCreUsrId());
		this.hashColumns.put("in_clz_yrmon", getInClzYrmon());
		this.hashColumns.put("in_upd_usr_id", getInUpdUsrId());
		this.hashColumns.put("in_cre_dt", getInCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_clz_dt", getInClzDt());
		this.hashColumns.put("in_gl_if_flg", getInGlIfFlg());
		this.hashColumns.put("at_clz_dt", getAtClzDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_clz_div_cd", getInClzDivCd());
		this.hashColumns.put("in_clz_flg", getInClzFlg());
		this.hashColumns.put("glif_clz_yrmon", getGlifClzYrmon());
		this.hashColumns.put("at_upd_usr_id", getAtUpdUsrId());
		this.hashColumns.put("in_cre_usr_id", getInCreUsrId());
		this.hashColumns.put("at_clz_flg", getAtClzFlg());
		this.hashColumns.put("at_clz_yrmon", getAtClzYrmon());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("at_upd_dt", "atUpdDt");
		this.hashFields.put("in_upd_dt", "inUpdDt");
		this.hashFields.put("at_cre_dt", "atCreDt");
		this.hashFields.put("at_clz_div_cd", "atClzDivCd");
		this.hashFields.put("at_cre_usr_id", "atCreUsrId");
		this.hashFields.put("in_clz_yrmon", "inClzYrmon");
		this.hashFields.put("in_upd_usr_id", "inUpdUsrId");
		this.hashFields.put("in_cre_dt", "inCreDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_clz_dt", "inClzDt");
		this.hashFields.put("in_gl_if_flg", "inGlIfFlg");
		this.hashFields.put("at_clz_dt", "atClzDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_clz_div_cd", "inClzDivCd");
		this.hashFields.put("in_clz_flg", "inClzFlg");
		this.hashFields.put("glif_clz_yrmon", "glifClzYrmon");
		this.hashFields.put("at_upd_usr_id", "atUpdUsrId");
		this.hashFields.put("in_cre_usr_id", "inCreUsrId");
		this.hashFields.put("at_clz_flg", "atClzFlg");
		this.hashFields.put("at_clz_yrmon", "atClzYrmon");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return atUpdDt
	 */
	public String getAtUpdDt() {
		return this.atUpdDt;
	}
	
	/**
	 * Column Info
	 * @return inUpdDt
	 */
	public String getInUpdDt() {
		return this.inUpdDt;
	}
	
	/**
	 * Column Info
	 * @return atCreDt
	 */
	public String getAtCreDt() {
		return this.atCreDt;
	}
	
	/**
	 * Column Info
	 * @return atClzDivCd
	 */
	public String getAtClzDivCd() {
		return this.atClzDivCd;
	}
	
	/**
	 * Column Info
	 * @return atCreUsrId
	 */
	public String getAtCreUsrId() {
		return this.atCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return inClzYrmon
	 */
	public String getInClzYrmon() {
		return this.inClzYrmon;
	}
	
	/**
	 * Column Info
	 * @return inUpdUsrId
	 */
	public String getInUpdUsrId() {
		return this.inUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return inCreDt
	 */
	public String getInCreDt() {
		return this.inCreDt;
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
	 * @return inClzDt
	 */
	public String getInClzDt() {
		return this.inClzDt;
	}
	
	/**
	 * Column Info
	 * @return inGlIfFlg
	 */
	public String getInGlIfFlg() {
		return this.inGlIfFlg;
	}
	
	/**
	 * Column Info
	 * @return atClzDt
	 */
	public String getAtClzDt() {
		return this.atClzDt;
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
	 * @return inClzDivCd
	 */
	public String getInClzDivCd() {
		return this.inClzDivCd;
	}
	
	/**
	 * Column Info
	 * @return inClzFlg
	 */
	public String getInClzFlg() {
		return this.inClzFlg;
	}
	
	/**
	 * Column Info
	 * @return glifClzYrmon
	 */
	public String getGlifClzYrmon() {
		return this.glifClzYrmon;
	}
	
	/**
	 * Column Info
	 * @return atUpdUsrId
	 */
	public String getAtUpdUsrId() {
		return this.atUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return inCreUsrId
	 */
	public String getInCreUsrId() {
		return this.inCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return atClzFlg
	 */
	public String getAtClzFlg() {
		return this.atClzFlg;
	}
	
	/**
	 * Column Info
	 * @return atClzYrmon
	 */
	public String getAtClzYrmon() {
		return this.atClzYrmon;
	}
	

	/**
	 * Column Info
	 * @param atUpdDt
	 */
	public void setAtUpdDt(String atUpdDt) {
		this.atUpdDt = atUpdDt;
	}
	
	/**
	 * Column Info
	 * @param inUpdDt
	 */
	public void setInUpdDt(String inUpdDt) {
		this.inUpdDt = inUpdDt;
	}
	
	/**
	 * Column Info
	 * @param atCreDt
	 */
	public void setAtCreDt(String atCreDt) {
		this.atCreDt = atCreDt;
	}
	
	/**
	 * Column Info
	 * @param atClzDivCd
	 */
	public void setAtClzDivCd(String atClzDivCd) {
		this.atClzDivCd = atClzDivCd;
	}
	
	/**
	 * Column Info
	 * @param atCreUsrId
	 */
	public void setAtCreUsrId(String atCreUsrId) {
		this.atCreUsrId = atCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param inClzYrmon
	 */
	public void setInClzYrmon(String inClzYrmon) {
		this.inClzYrmon = inClzYrmon;
	}
	
	/**
	 * Column Info
	 * @param inUpdUsrId
	 */
	public void setInUpdUsrId(String inUpdUsrId) {
		this.inUpdUsrId = inUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param inCreDt
	 */
	public void setInCreDt(String inCreDt) {
		this.inCreDt = inCreDt;
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
	 * @param inClzDt
	 */
	public void setInClzDt(String inClzDt) {
		this.inClzDt = inClzDt;
	}
	
	/**
	 * Column Info
	 * @param inGlIfFlg
	 */
	public void setInGlIfFlg(String inGlIfFlg) {
		this.inGlIfFlg = inGlIfFlg;
	}
	
	/**
	 * Column Info
	 * @param atClzDt
	 */
	public void setAtClzDt(String atClzDt) {
		this.atClzDt = atClzDt;
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
	 * @param inClzDivCd
	 */
	public void setInClzDivCd(String inClzDivCd) {
		this.inClzDivCd = inClzDivCd;
	}
	
	/**
	 * Column Info
	 * @param inClzFlg
	 */
	public void setInClzFlg(String inClzFlg) {
		this.inClzFlg = inClzFlg;
	}
	
	/**
	 * Column Info
	 * @param glifClzYrmon
	 */
	public void setGlifClzYrmon(String glifClzYrmon) {
		this.glifClzYrmon = glifClzYrmon;
	}
	
	/**
	 * Column Info
	 * @param atUpdUsrId
	 */
	public void setAtUpdUsrId(String atUpdUsrId) {
		this.atUpdUsrId = atUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param inCreUsrId
	 */
	public void setInCreUsrId(String inCreUsrId) {
		this.inCreUsrId = inCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param atClzFlg
	 */
	public void setAtClzFlg(String atClzFlg) {
		this.atClzFlg = atClzFlg;
	}
	
	/**
	 * Column Info
	 * @param atClzYrmon
	 */
	public void setAtClzYrmon(String atClzYrmon) {
		this.atClzYrmon = atClzYrmon;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAtUpdDt(JSPUtil.getParameter(request, "at_upd_dt", ""));
		setInUpdDt(JSPUtil.getParameter(request, "in_upd_dt", ""));
		setAtCreDt(JSPUtil.getParameter(request, "at_cre_dt", ""));
		setAtClzDivCd(JSPUtil.getParameter(request, "at_clz_div_cd", ""));
		setAtCreUsrId(JSPUtil.getParameter(request, "at_cre_usr_id", ""));
		setInClzYrmon(JSPUtil.getParameter(request, "in_clz_yrmon", ""));
		setInUpdUsrId(JSPUtil.getParameter(request, "in_upd_usr_id", ""));
		setInCreDt(JSPUtil.getParameter(request, "in_cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInClzDt(JSPUtil.getParameter(request, "in_clz_dt", ""));
		setInGlIfFlg(JSPUtil.getParameter(request, "in_gl_if_flg", ""));
		setAtClzDt(JSPUtil.getParameter(request, "at_clz_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInClzDivCd(JSPUtil.getParameter(request, "in_clz_div_cd", ""));
		setInClzFlg(JSPUtil.getParameter(request, "in_clz_flg", ""));
		setGlifClzYrmon(JSPUtil.getParameter(request, "glif_clz_yrmon", ""));
		setAtUpdUsrId(JSPUtil.getParameter(request, "at_upd_usr_id", ""));
		setInCreUsrId(JSPUtil.getParameter(request, "in_cre_usr_id", ""));
		setAtClzFlg(JSPUtil.getParameter(request, "at_clz_flg", ""));
		setAtClzYrmon(JSPUtil.getParameter(request, "at_clz_yrmon", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MonClzVO[]
	 */
	public MonClzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MonClzVO[]
	 */
	public MonClzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MonClzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] atUpdDt = (JSPUtil.getParameter(request, prefix	+ "at_upd_dt", length));
			String[] inUpdDt = (JSPUtil.getParameter(request, prefix	+ "in_upd_dt", length));
			String[] atCreDt = (JSPUtil.getParameter(request, prefix	+ "at_cre_dt", length));
			String[] atClzDivCd = (JSPUtil.getParameter(request, prefix	+ "at_clz_div_cd", length));
			String[] atCreUsrId = (JSPUtil.getParameter(request, prefix	+ "at_cre_usr_id", length));
			String[] inClzYrmon = (JSPUtil.getParameter(request, prefix	+ "in_clz_yrmon", length));
			String[] inUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "in_upd_usr_id", length));
			String[] inCreDt = (JSPUtil.getParameter(request, prefix	+ "in_cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inClzDt = (JSPUtil.getParameter(request, prefix	+ "in_clz_dt", length));
			String[] inGlIfFlg = (JSPUtil.getParameter(request, prefix	+ "in_gl_if_flg", length));
			String[] atClzDt = (JSPUtil.getParameter(request, prefix	+ "at_clz_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inClzDivCd = (JSPUtil.getParameter(request, prefix	+ "in_clz_div_cd", length));
			String[] inClzFlg = (JSPUtil.getParameter(request, prefix	+ "in_clz_flg", length));
			String[] glifClzYrmon = (JSPUtil.getParameter(request, prefix	+ "glif_clz_yrmon", length));
			String[] atUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "at_upd_usr_id", length));
			String[] inCreUsrId = (JSPUtil.getParameter(request, prefix	+ "in_cre_usr_id", length));
			String[] atClzFlg = (JSPUtil.getParameter(request, prefix	+ "at_clz_flg", length));
			String[] atClzYrmon = (JSPUtil.getParameter(request, prefix	+ "at_clz_yrmon", length));
			
			for (int i = 0; i < length; i++) {
				model = new MonClzVO();
				if (atUpdDt[i] != null)
					model.setAtUpdDt(atUpdDt[i]);
				if (inUpdDt[i] != null)
					model.setInUpdDt(inUpdDt[i]);
				if (atCreDt[i] != null)
					model.setAtCreDt(atCreDt[i]);
				if (atClzDivCd[i] != null)
					model.setAtClzDivCd(atClzDivCd[i]);
				if (atCreUsrId[i] != null)
					model.setAtCreUsrId(atCreUsrId[i]);
				if (inClzYrmon[i] != null)
					model.setInClzYrmon(inClzYrmon[i]);
				if (inUpdUsrId[i] != null)
					model.setInUpdUsrId(inUpdUsrId[i]);
				if (inCreDt[i] != null)
					model.setInCreDt(inCreDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inClzDt[i] != null)
					model.setInClzDt(inClzDt[i]);
				if (inGlIfFlg[i] != null)
					model.setInGlIfFlg(inGlIfFlg[i]);
				if (atClzDt[i] != null)
					model.setAtClzDt(atClzDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inClzDivCd[i] != null)
					model.setInClzDivCd(inClzDivCd[i]);
				if (inClzFlg[i] != null)
					model.setInClzFlg(inClzFlg[i]);
				if (glifClzYrmon[i] != null)
					model.setGlifClzYrmon(glifClzYrmon[i]);
				if (atUpdUsrId[i] != null)
					model.setAtUpdUsrId(atUpdUsrId[i]);
				if (inCreUsrId[i] != null)
					model.setInCreUsrId(inCreUsrId[i]);
				if (atClzFlg[i] != null)
					model.setAtClzFlg(atClzFlg[i]);
				if (atClzYrmon[i] != null)
					model.setAtClzYrmon(atClzYrmon[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMonClzVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MonClzVO[]
	 */
	public MonClzVO[] getMonClzVOs(){
		MonClzVO[] vos = (MonClzVO[])models.toArray(new MonClzVO[models.size()]);
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
		this.atUpdDt = this.atUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUpdDt = this.inUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atCreDt = this.atCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atClzDivCd = this.atClzDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atCreUsrId = this.atCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inClzYrmon = this.inClzYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUpdUsrId = this.inUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCreDt = this.inCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inClzDt = this.inClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inGlIfFlg = this.inGlIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atClzDt = this.atClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inClzDivCd = this.inClzDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inClzFlg = this.inClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glifClzYrmon = this.glifClzYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atUpdUsrId = this.atUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCreUsrId = this.inCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atClzFlg = this.atClzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atClzYrmon = this.atClzYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
