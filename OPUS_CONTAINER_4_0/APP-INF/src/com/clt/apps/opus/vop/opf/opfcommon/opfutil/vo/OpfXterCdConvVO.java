/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfXterCdConvVO.java
*@FileTitle : OpfXterCdConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.opfcommon.opfutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class OpfXterCdConvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpfXterCdConvVO> models = new ArrayList<OpfXterCdConvVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String xterCdRmk = null;
	/* Column Info */
	private String xterCdDesc = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String interCdCtnt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String xterCdCtnt = null;
	/* Column Info */
	private String edwUpdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String xterCdKndCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String xterCdSubSeq = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OpfXterCdConvVO() {}

	public OpfXterCdConvVO(String ibflag, String pagerows, String xterCdKndCtnt, String xterCdRmk, String xterCdCtnt, String xterCdSubSeq, String xterCdDesc, String interCdCtnt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String edwUpdDt) {
		this.updDt = updDt;
		this.xterCdRmk = xterCdRmk;
		this.xterCdDesc = xterCdDesc;
		this.deltFlg = deltFlg;
		this.interCdCtnt = interCdCtnt;
		this.creDt = creDt;
		this.xterCdCtnt = xterCdCtnt;
		this.edwUpdDt = edwUpdDt;
		this.pagerows = pagerows;
		this.xterCdKndCtnt = xterCdKndCtnt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.xterCdSubSeq = xterCdSubSeq;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("xter_cd_rmk", getXterCdRmk());
		this.hashColumns.put("xter_cd_desc", getXterCdDesc());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("inter_cd_ctnt", getInterCdCtnt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("xter_cd_ctnt", getXterCdCtnt());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("xter_cd_knd_ctnt", getXterCdKndCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("xter_cd_sub_seq", getXterCdSubSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("xter_cd_rmk", "xterCdRmk");
		this.hashFields.put("xter_cd_desc", "xterCdDesc");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("inter_cd_ctnt", "interCdCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("xter_cd_ctnt", "xterCdCtnt");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("xter_cd_knd_ctnt", "xterCdKndCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("xter_cd_sub_seq", "xterCdSubSeq");
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
	 * @return xterCdRmk
	 */
	public String getXterCdRmk() {
		return this.xterCdRmk;
	}
	
	/**
	 * Column Info
	 * @return xterCdDesc
	 */
	public String getXterCdDesc() {
		return this.xterCdDesc;
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
	 * @return interCdCtnt
	 */
	public String getInterCdCtnt() {
		return this.interCdCtnt;
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
	 * @return xterCdCtnt
	 */
	public String getXterCdCtnt() {
		return this.xterCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return edwUpdDt
	 */
	public String getEdwUpdDt() {
		return this.edwUpdDt;
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
	 * @return xterCdKndCtnt
	 */
	public String getXterCdKndCtnt() {
		return this.xterCdKndCtnt;
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
	 * @return xterCdSubSeq
	 */
	public String getXterCdSubSeq() {
		return this.xterCdSubSeq;
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
	 * @param xterCdRmk
	 */
	public void setXterCdRmk(String xterCdRmk) {
		this.xterCdRmk = xterCdRmk;
	}
	
	/**
	 * Column Info
	 * @param xterCdDesc
	 */
	public void setXterCdDesc(String xterCdDesc) {
		this.xterCdDesc = xterCdDesc;
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
	 * @param interCdCtnt
	 */
	public void setInterCdCtnt(String interCdCtnt) {
		this.interCdCtnt = interCdCtnt;
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
	 * @param xterCdCtnt
	 */
	public void setXterCdCtnt(String xterCdCtnt) {
		this.xterCdCtnt = xterCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param edwUpdDt
	 */
	public void setEdwUpdDt(String edwUpdDt) {
		this.edwUpdDt = edwUpdDt;
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
	 * @param xterCdKndCtnt
	 */
	public void setXterCdKndCtnt(String xterCdKndCtnt) {
		this.xterCdKndCtnt = xterCdKndCtnt;
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
	 * @param xterCdSubSeq
	 */
	public void setXterCdSubSeq(String xterCdSubSeq) {
		this.xterCdSubSeq = xterCdSubSeq;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setXterCdRmk(JSPUtil.getParameter(request, prefix + "xter_cd_rmk", ""));
		setXterCdDesc(JSPUtil.getParameter(request, prefix + "xter_cd_desc", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setInterCdCtnt(JSPUtil.getParameter(request, prefix + "inter_cd_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setXterCdCtnt(JSPUtil.getParameter(request, prefix + "xter_cd_ctnt", ""));
		setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setXterCdKndCtnt(JSPUtil.getParameter(request, prefix + "xter_cd_knd_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setXterCdSubSeq(JSPUtil.getParameter(request, prefix + "xter_cd_sub_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpfXterCdConvVO[]
	 */
	public OpfXterCdConvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpfXterCdConvVO[]
	 */
	public OpfXterCdConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpfXterCdConvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] xterCdRmk = (JSPUtil.getParameter(request, prefix	+ "xter_cd_rmk", length));
			String[] xterCdDesc = (JSPUtil.getParameter(request, prefix	+ "xter_cd_desc", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] interCdCtnt = (JSPUtil.getParameter(request, prefix	+ "inter_cd_ctnt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] xterCdCtnt = (JSPUtil.getParameter(request, prefix	+ "xter_cd_ctnt", length));
			String[] edwUpdDt = (JSPUtil.getParameter(request, prefix	+ "edw_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] xterCdKndCtnt = (JSPUtil.getParameter(request, prefix	+ "xter_cd_knd_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] xterCdSubSeq = (JSPUtil.getParameter(request, prefix	+ "xter_cd_sub_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpfXterCdConvVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (xterCdRmk[i] != null)
					model.setXterCdRmk(xterCdRmk[i]);
				if (xterCdDesc[i] != null)
					model.setXterCdDesc(xterCdDesc[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (interCdCtnt[i] != null)
					model.setInterCdCtnt(interCdCtnt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (xterCdCtnt[i] != null)
					model.setXterCdCtnt(xterCdCtnt[i]);
				if (edwUpdDt[i] != null)
					model.setEdwUpdDt(edwUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (xterCdKndCtnt[i] != null)
					model.setXterCdKndCtnt(xterCdKndCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (xterCdSubSeq[i] != null)
					model.setXterCdSubSeq(xterCdSubSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpfXterCdConvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpfXterCdConvVO[]
	 */
	public OpfXterCdConvVO[] getOpfXterCdConvVOs(){
		OpfXterCdConvVO[] vos = (OpfXterCdConvVO[])models.toArray(new OpfXterCdConvVO[models.size()]);
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
		this.xterCdRmk = this.xterCdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCdDesc = this.xterCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCdCtnt = this.interCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCdCtnt = this.xterCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt = this.edwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCdKndCtnt = this.xterCdKndCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterCdSubSeq = this.xterCdSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
