/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoaAgmtRstrMgmtVO.java
*@FileTitle : CoaAgmtRstrMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.28 장영석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장영석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CoaAgmtRstrMgmtConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoaAgmtRstrMgmtConditionVO> models = new ArrayList<CoaAgmtRstrMgmtConditionVO>();
	
	/* Column Info */
	private String code = null;	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String coaCostSrcCd = null;
	/* Column Info */
	private String n2ndNodCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String locDeltFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String locGrpTpCd = null;
	/* Column Info */
	private String n4thNodCd = null;
	/* Column Info */
	private String costSrcUseFlg = null;
	/* Column Info */
	private String n1stNodCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String n3rdNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/* iterator List Info */
	private List<HashMap<String, Object>> DynamicSrcCd = new ArrayList<HashMap<String, Object>>();
	
	public CoaAgmtRstrMgmtConditionVO() {}

	public CoaAgmtRstrMgmtConditionVO(String code, String ibflag, String pagerows, String locGrpTpCd, String coaCostSrcCd, String n1stNodCd, String n2ndNodCd, String n3rdNodCd, String n4thNodCd, String costSrcUseFlg, String locDeltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.code = code;
		this.updDt = updDt;
		this.coaCostSrcCd = coaCostSrcCd;
		this.n2ndNodCd = n2ndNodCd;
		this.creDt = creDt;
		this.locDeltFlg = locDeltFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.locGrpTpCd = locGrpTpCd;
		this.n4thNodCd = n4thNodCd;
		this.costSrcUseFlg = costSrcUseFlg;
		this.n1stNodCd = n1stNodCd;
		this.updUsrId = updUsrId;
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("coa_cost_src_cd", getCoaCostSrcCd());
		this.hashColumns.put("n2nd_nod_cd", getN2ndNodCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("loc_delt_flg", getLocDeltFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("loc_grp_tp_cd", getLocGrpTpCd());
		this.hashColumns.put("n4th_nod_cd", getN4thNodCd());
		this.hashColumns.put("cost_src_use_flg", getCostSrcUseFlg());
		this.hashColumns.put("n1st_nod_cd", getN1stNodCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("n3rd_nod_cd", getN3rdNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("code", "code");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("coa_cost_src_cd", "coaCostSrcCd");
		this.hashFields.put("n2nd_nod_cd", "n2ndNodCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("loc_delt_flg", "locDeltFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("loc_grp_tp_cd", "locGrpTpCd");
		this.hashFields.put("n4th_nod_cd", "n4thNodCd");
		this.hashFields.put("cost_src_use_flg", "costSrcUseFlg");
		this.hashFields.put("n1st_nod_cd", "n1stNodCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("n3rd_nod_cd", "n3rdNodCd");
		return this.hashFields;
	}
	
	
	public List<HashMap<String, Object>> getDynamicSrcCd() {
		return DynamicSrcCd;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * @return coaCostSrcCd
	 */
	public String getCoaCostSrcCd() {
		return this.coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndNodCd
	 */
	public String getN2ndNodCd() {
		return this.n2ndNodCd;
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
	 * @return locDeltFlg
	 */
	public String getLocDeltFlg() {
		return this.locDeltFlg;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return locGrpTpCd
	 */
	public String getLocGrpTpCd() {
		return this.locGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return n4thNodCd
	 */
	public String getN4thNodCd() {
		return this.n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @return costSrcUseFlg
	 */
	public String getCostSrcUseFlg() {
		return this.costSrcUseFlg;
	}
	
	/**
	 * Column Info
	 * @return n1stNodCd
	 */
	public String getN1stNodCd() {
		return this.n1stNodCd;
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
	 * @return n3rdNodCd
	 */
	public String getN3rdNodCd() {
		return this.n3rdNodCd;
	}
	
	public void setDynamicSrcCd(List<HashMap<String, Object>> dynamicSrcCd) {
		DynamicSrcCd = dynamicSrcCd;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @param coaCostSrcCd
	 */
	public void setCoaCostSrcCd(String coaCostSrcCd) {
		this.coaCostSrcCd = coaCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndNodCd
	 */
	public void setN2ndNodCd(String n2ndNodCd) {
		this.n2ndNodCd = n2ndNodCd;
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
	 * @param locDeltFlg
	 */
	public void setLocDeltFlg(String locDeltFlg) {
		this.locDeltFlg = locDeltFlg;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param locGrpTpCd
	 */
	public void setLocGrpTpCd(String locGrpTpCd) {
		this.locGrpTpCd = locGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param n4thNodCd
	 */
	public void setN4thNodCd(String n4thNodCd) {
		this.n4thNodCd = n4thNodCd;
	}
	
	/**
	 * Column Info
	 * @param costSrcUseFlg
	 */
	public void setCostSrcUseFlg(String costSrcUseFlg) {
		this.costSrcUseFlg = costSrcUseFlg;
	}
	
	/**
	 * Column Info
	 * @param n1stNodCd
	 */
	public void setN1stNodCd(String n1stNodCd) {
		this.n1stNodCd = n1stNodCd;
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
	 * @param n3rdNodCd
	 */
	public void setN3rdNodCd(String n3rdNodCd) {
		this.n3rdNodCd = n3rdNodCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCode(JSPUtil.getParameter(request, "code", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCoaCostSrcCd(JSPUtil.getParameter(request, "coa_cost_src_cd", ""));
		setN2ndNodCd(JSPUtil.getParameter(request, "n2nd_nod_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setLocDeltFlg(JSPUtil.getParameter(request, "loc_delt_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setLocGrpTpCd(JSPUtil.getParameter(request, "loc_grp_tp_cd", ""));
		setN4thNodCd(JSPUtil.getParameter(request, "n4th_nod_cd", ""));
		setCostSrcUseFlg(JSPUtil.getParameter(request, "cost_src_use_flg", ""));
		setN1stNodCd(JSPUtil.getParameter(request, "n1st_nod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setN3rdNodCd(JSPUtil.getParameter(request, "n3rd_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoaAgmtRstrMgmtVO[]
	 */
	public CoaAgmtRstrMgmtConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoaAgmtRstrMgmtVO[]
	 */
	public CoaAgmtRstrMgmtConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoaAgmtRstrMgmtConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] coaCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "coa_cost_src_cd", length));
			String[] n2ndNodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_nod_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] locDeltFlg = (JSPUtil.getParameter(request, prefix	+ "loc_delt_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] locGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_tp_cd", length));
			String[] n4thNodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_nod_cd", length));
			String[] costSrcUseFlg = (JSPUtil.getParameter(request, prefix	+ "cost_src_use_flg", length));
			String[] n1stNodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_nod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] n3rdNodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoaAgmtRstrMgmtConditionVO();
				if (code[i] != null)
					model.setCode(code[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (coaCostSrcCd[i] != null)
					model.setCoaCostSrcCd(coaCostSrcCd[i]);
				if (n2ndNodCd[i] != null)
					model.setN2ndNodCd(n2ndNodCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (locDeltFlg[i] != null)
					model.setLocDeltFlg(locDeltFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (locGrpTpCd[i] != null)
					model.setLocGrpTpCd(locGrpTpCd[i]);
				if (n4thNodCd[i] != null)
					model.setN4thNodCd(n4thNodCd[i]);
				if (costSrcUseFlg[i] != null)
					model.setCostSrcUseFlg(costSrcUseFlg[i]);
				if (n1stNodCd[i] != null)
					model.setN1stNodCd(n1stNodCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (n3rdNodCd[i] != null)
					model.setN3rdNodCd(n3rdNodCd[i]);
				
				//--------------------------------------------
				//method 추가
				if (i==0) {
					//예외적인 처리--------------------------------------------------------------------START
					
					try {						
						
						
						String[] coa_cost_src_cd = code[0].split("[|]");
						if(coa_cost_src_cd.length > 0){
							HashMap<String, Object> hMap = null;
				            for(int j=0; j<coa_cost_src_cd.length; j++){
				            	hMap = new HashMap<String, Object>();
				            	String[] cost_src_use_cd = (JSPUtil.getParameter(request, coa_cost_src_cd[j], length));
				            	hMap.put(coa_cost_src_cd[j], cost_src_use_cd);
				            	DynamicSrcCd.add(hMap);
				            }
				            if(DynamicSrcCd.size() > 0) {
				            	model.setDynamicSrcCd(DynamicSrcCd);
				            }
						}	
					} catch (Exception e) {
						return null;
					} 
					//예외적인 처리--------------------------------------------------------------------END						
				}				
				//--------------------------------------------
	
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoaAgmtRstrMgmtConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoaAgmtRstrMgmtVO[]
	 */
	public CoaAgmtRstrMgmtConditionVO[] getCoaAgmtRstrMgmtConditionVOs(){
		CoaAgmtRstrMgmtConditionVO[] vos = (CoaAgmtRstrMgmtConditionVO[])models.toArray(new CoaAgmtRstrMgmtConditionVO[models.size()]);
		return vos;
	}
	
//	/**
//	 * VO 반환
//	 * @return CoaAgmtRstrMgmtVO
//	 */
//	public CoaAgmtRstrMgmtConditionVO getCoaAgmtRstrMgmtConditionVO(){
//		CoaAgmtRstrMgmtConditionVO vo = (CoaAgmtRstrMgmtConditionVO)models.toArray(new CoaAgmtRstrMgmtConditionVO);
//		return vo;
//	}
	
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
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCostSrcCd = this.coaCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndNodCd = this.n2ndNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDeltFlg = this.locDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpTpCd = this.locGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thNodCd = this.n4thNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costSrcUseFlg = this.costSrcUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stNodCd = this.n1stNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdNodCd = this.n3rdNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	

}
