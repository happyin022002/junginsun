/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchActItemMstVO.java
*@FileTitle : SearchActItemMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.18
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.18 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchActItemMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchActItemMstVO> models = new ArrayList<SearchActItemMstVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String itemCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slsActTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String slsActSubTpCd = null;
	/* Column Info */
	private String itemDesc = null;
	/* Column Info */
	private String slsActTpDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String slsActSubTpDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchActItemMstVO() {}

	public SearchActItemMstVO(String ibflag, String pagerows, String slsActTpCd, String slsActSubTpCd, String slsActTpDesc, String slsActSubTpDesc, String creUsrId, String creDt, String updUsrId, String updDt, String itemCd, String itemDesc) {
		this.updDt = updDt;
		this.itemCd = itemCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.slsActTpCd = slsActTpCd;
		this.creDt = creDt;
		this.slsActSubTpCd = slsActSubTpCd;
		this.itemDesc = itemDesc;
		this.slsActTpDesc = slsActTpDesc;
		this.updUsrId = updUsrId;
		this.slsActSubTpDesc = slsActSubTpDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("item_cd", getItemCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sls_act_tp_cd", getSlsActTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sls_act_sub_tp_cd", getSlsActSubTpCd());
		this.hashColumns.put("item_desc", getItemDesc());
		this.hashColumns.put("sls_act_tp_desc", getSlsActTpDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sls_act_sub_tp_desc", getSlsActSubTpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("item_cd", "itemCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sls_act_tp_cd", "slsActTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sls_act_sub_tp_cd", "slsActSubTpCd");
		this.hashFields.put("item_desc", "itemDesc");
		this.hashFields.put("sls_act_tp_desc", "slsActTpDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sls_act_sub_tp_desc", "slsActSubTpDesc");
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
	 * @return itemCd
	 */
	public String getItemCd() {
		return this.itemCd;
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
	 * @return slsActTpCd
	 */
	public String getSlsActTpCd() {
		return this.slsActTpCd;
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
	 * @return slsActSubTpCd
	 */
	public String getSlsActSubTpCd() {
		return this.slsActSubTpCd;
	}
	
	/**
	 * Column Info
	 * @return itemDesc
	 */
	public String getItemDesc() {
		return this.itemDesc;
	}
	
	/**
	 * Column Info
	 * @return slsActTpDesc
	 */
	public String getSlsActTpDesc() {
		return this.slsActTpDesc;
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
	 * @return slsActSubTpDesc
	 */
	public String getSlsActSubTpDesc() {
		return this.slsActSubTpDesc;
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
	 * @param itemCd
	 */
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
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
	 * @param slsActTpCd
	 */
	public void setSlsActTpCd(String slsActTpCd) {
		this.slsActTpCd = slsActTpCd;
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
	 * @param slsActSubTpCd
	 */
	public void setSlsActSubTpCd(String slsActSubTpCd) {
		this.slsActSubTpCd = slsActSubTpCd;
	}
	
	/**
	 * Column Info
	 * @param itemDesc
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	/**
	 * Column Info
	 * @param slsActTpDesc
	 */
	public void setSlsActTpDesc(String slsActTpDesc) {
		this.slsActTpDesc = slsActTpDesc;
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
	 * @param slsActSubTpDesc
	 */
	public void setSlsActSubTpDesc(String slsActSubTpDesc) {
		this.slsActSubTpDesc = slsActSubTpDesc;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setItemCd(JSPUtil.getParameter(request, prefix + "item_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlsActTpCd(JSPUtil.getParameter(request, prefix + "sls_act_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSlsActSubTpCd(JSPUtil.getParameter(request, prefix + "sls_act_sub_tp_cd", ""));
		setItemDesc(JSPUtil.getParameter(request, prefix + "item_desc", ""));
		setSlsActTpDesc(JSPUtil.getParameter(request, prefix + "sls_act_tp_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setSlsActSubTpDesc(JSPUtil.getParameter(request, prefix + "sls_act_sub_tp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchActItemMstVO[]
	 */
	public SearchActItemMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchActItemMstVO[]
	 */
	public SearchActItemMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchActItemMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] itemCd = (JSPUtil.getParameter(request, prefix	+ "item_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slsActTpCd = (JSPUtil.getParameter(request, prefix	+ "sls_act_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] slsActSubTpCd = (JSPUtil.getParameter(request, prefix	+ "sls_act_sub_tp_cd", length));
			String[] itemDesc = (JSPUtil.getParameter(request, prefix	+ "item_desc", length));
			String[] slsActTpDesc = (JSPUtil.getParameter(request, prefix	+ "sls_act_tp_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] slsActSubTpDesc = (JSPUtil.getParameter(request, prefix	+ "sls_act_sub_tp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchActItemMstVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (itemCd[i] != null)
					model.setItemCd(itemCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slsActTpCd[i] != null)
					model.setSlsActTpCd(slsActTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (slsActSubTpCd[i] != null)
					model.setSlsActSubTpCd(slsActSubTpCd[i]);
				if (itemDesc[i] != null)
					model.setItemDesc(itemDesc[i]);
				if (slsActTpDesc[i] != null)
					model.setSlsActTpDesc(slsActTpDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (slsActSubTpDesc[i] != null)
					model.setSlsActSubTpDesc(slsActSubTpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchActItemMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchActItemMstVO[]
	 */
	public SearchActItemMstVO[] getSearchActItemMstVOs(){
		SearchActItemMstVO[] vos = (SearchActItemMstVO[])models.toArray(new SearchActItemMstVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemCd = this.itemCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActTpCd = this.slsActTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActSubTpCd = this.slsActSubTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemDesc = this.itemDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActTpDesc = this.slsActTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActSubTpDesc = this.slsActSubTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
