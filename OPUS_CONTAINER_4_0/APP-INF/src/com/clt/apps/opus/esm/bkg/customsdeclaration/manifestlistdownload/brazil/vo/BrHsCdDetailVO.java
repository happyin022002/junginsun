/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrHsCdDetailVO.java
*@FileTitle : BrHsCdDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrHsCdDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrHsCdDetailVO> models = new ArrayList<BrHsCdDetailVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCateCtnt = null;
	/* Column Info */
	private String brzCmdtCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrHsCdDetailVO() {}

	public BrHsCdDetailVO(String ibflag, String pagerows, String cntCd, String brzCmdtCd, String actFlg, String cmdtDesc, String cmdtCateCtnt, String creUsrId, String creDt, String updUsrId, String updDt, String office) {
		this.office = office;
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cmdtCateCtnt = cmdtCateCtnt;
		this.brzCmdtCd = brzCmdtCd;
		this.cmdtDesc = cmdtDesc;
		this.actFlg = actFlg;
		this.cntCd = cntCd;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cate_ctnt", getCmdtCateCtnt());
		this.hashColumns.put("brz_cmdt_cd", getBrzCmdtCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cate_ctnt", "cmdtCateCtnt");
		this.hashFields.put("brz_cmdt_cd", "brzCmdtCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
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
	 * @return cmdtCateCtnt
	 */
	public String getCmdtCateCtnt() {
		return this.cmdtCateCtnt;
	}
	
	/**
	 * Column Info
	 * @return brzCmdtCd
	 */
	public String getBrzCmdtCd() {
		return this.brzCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
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
	 * @param cmdtCateCtnt
	 */
	public void setCmdtCateCtnt(String cmdtCateCtnt) {
		this.cmdtCateCtnt = cmdtCateCtnt;
	}
	
	/**
	 * Column Info
	 * @param brzCmdtCd
	 */
	public void setBrzCmdtCd(String brzCmdtCd) {
		this.brzCmdtCd = brzCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setOffice(JSPUtil.getParameter(request, prefix + "office", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCateCtnt(JSPUtil.getParameter(request, prefix + "cmdt_cate_ctnt", ""));
		setBrzCmdtCd(JSPUtil.getParameter(request, prefix + "brz_cmdt_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setActFlg(JSPUtil.getParameter(request, prefix + "act_flg", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrHsCdDetailVO[]
	 */
	public BrHsCdDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrHsCdDetailVO[]
	 */
	public BrHsCdDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrHsCdDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCateCtnt = (JSPUtil.getParameter(request, prefix	+ "cmdt_cate_ctnt", length));
			String[] brzCmdtCd = (JSPUtil.getParameter(request, prefix	+ "brz_cmdt_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrHsCdDetailVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCateCtnt[i] != null)
					model.setCmdtCateCtnt(cmdtCateCtnt[i]);
				if (brzCmdtCd[i] != null)
					model.setBrzCmdtCd(brzCmdtCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrHsCdDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrHsCdDetailVO[]
	 */
	public BrHsCdDetailVO[] getBrHsCdDetailVOs(){
		BrHsCdDetailVO[] vos = (BrHsCdDetailVO[])models.toArray(new BrHsCdDetailVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCateCtnt = this.cmdtCateCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brzCmdtCd = this.brzCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
