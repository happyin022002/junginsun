/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgDpcsDocWeightVO.java
*@FileTitle : BkgDpcsDocWeightVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.05.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgDpcsDocWeightVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgDpcsDocWeightVO> models = new ArrayList<BkgDpcsDocWeightVO>();
	
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String hrdCdgIdSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String srKind = null;
	/* Column Info */
	private String docGroup = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String point = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srKindDesc = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hrdCdgId = null;
	/* Column Info */
	private String docGroupDesc = null;
	/* Column Info */
	private String srcDesc = null;
	/* Column Info */
	private String src = null;
	/* Column Info */
	private String border = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgDpcsDocWeightVO() {}

	public BkgDpcsDocWeightVO(String ibflag, String pagerows, String docGroup, String docGroupDesc, String srKind, String srKindDesc, String src, String srcDesc, String border, String point, String remark, String creUsrId, String creDt, String hrdCdgId, String hrdCdgIdSeq) {
		this.remark = remark;
		this.hrdCdgIdSeq = hrdCdgIdSeq;
		this.creDt = creDt;
		this.srKind = srKind;
		this.docGroup = docGroup;
		this.pagerows = pagerows;
		this.point = point;
		this.ibflag = ibflag;
		this.srKindDesc = srKindDesc;
		this.creUsrId = creUsrId;
		this.hrdCdgId = hrdCdgId;
		this.docGroupDesc = docGroupDesc;
		this.srcDesc = srcDesc;
		this.src = src;
		this.border = border;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("hrd_cdg_id_seq", getHrdCdgIdSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sr_kind", getSrKind());
		this.hashColumns.put("doc_group", getDocGroup());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("point", getPoint());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sr_kind_desc", getSrKindDesc());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("hrd_cdg_id", getHrdCdgId());
		this.hashColumns.put("doc_group_desc", getDocGroupDesc());
		this.hashColumns.put("src_desc", getSrcDesc());
		this.hashColumns.put("src", getSrc());
		this.hashColumns.put("border", getBorder());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("remark", "remark");
		this.hashFields.put("hrd_cdg_id_seq", "hrdCdgIdSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sr_kind", "srKind");
		this.hashFields.put("doc_group", "docGroup");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("point", "point");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sr_kind_desc", "srKindDesc");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("hrd_cdg_id", "hrdCdgId");
		this.hashFields.put("doc_group_desc", "docGroupDesc");
		this.hashFields.put("src_desc", "srcDesc");
		this.hashFields.put("src", "src");
		this.hashFields.put("border", "border");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return hrdCdgIdSeq
	 */
	public String getHrdCdgIdSeq() {
		return this.hrdCdgIdSeq;
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
	 * @return srKind
	 */
	public String getSrKind() {
		return this.srKind;
	}
	
	/**
	 * Column Info
	 * @return docGroup
	 */
	public String getDocGroup() {
		return this.docGroup;
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
	 * @return point
	 */
	public String getPoint() {
		return this.point;
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
	 * @return srKindDesc
	 */
	public String getSrKindDesc() {
		return this.srKindDesc;
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
	 * @return hrdCdgId
	 */
	public String getHrdCdgId() {
		return this.hrdCdgId;
	}
	
	/**
	 * Column Info
	 * @return docGroupDesc
	 */
	public String getDocGroupDesc() {
		return this.docGroupDesc;
	}
	
	/**
	 * Column Info
	 * @return srcDesc
	 */
	public String getSrcDesc() {
		return this.srcDesc;
	}
	
	/**
	 * Column Info
	 * @return src
	 */
	public String getSrc() {
		return this.src;
	}
	
	/**
	 * Column Info
	 * @return border
	 */
	public String getBorder() {
		return this.border;
	}
	

	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param hrdCdgIdSeq
	 */
	public void setHrdCdgIdSeq(String hrdCdgIdSeq) {
		this.hrdCdgIdSeq = hrdCdgIdSeq;
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
	 * @param srKind
	 */
	public void setSrKind(String srKind) {
		this.srKind = srKind;
	}
	
	/**
	 * Column Info
	 * @param docGroup
	 */
	public void setDocGroup(String docGroup) {
		this.docGroup = docGroup;
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
	 * @param point
	 */
	public void setPoint(String point) {
		this.point = point;
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
	 * @param srKindDesc
	 */
	public void setSrKindDesc(String srKindDesc) {
		this.srKindDesc = srKindDesc;
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
	 * @param hrdCdgId
	 */
	public void setHrdCdgId(String hrdCdgId) {
		this.hrdCdgId = hrdCdgId;
	}
	
	/**
	 * Column Info
	 * @param docGroupDesc
	 */
	public void setDocGroupDesc(String docGroupDesc) {
		this.docGroupDesc = docGroupDesc;
	}
	
	/**
	 * Column Info
	 * @param srcDesc
	 */
	public void setSrcDesc(String srcDesc) {
		this.srcDesc = srcDesc;
	}
	
	/**
	 * Column Info
	 * @param src
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * Column Info
	 * @param border
	 */
	public void setBorder(String border) {
		this.border = border;
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
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setHrdCdgIdSeq(JSPUtil.getParameter(request, prefix + "hrd_cdg_id_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSrKind(JSPUtil.getParameter(request, prefix + "sr_kind", ""));
		setDocGroup(JSPUtil.getParameter(request, prefix + "doc_group", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPoint(JSPUtil.getParameter(request, prefix + "point", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrKindDesc(JSPUtil.getParameter(request, prefix + "sr_kind_desc", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setHrdCdgId(JSPUtil.getParameter(request, prefix + "hrd_cdg_id", ""));
		setDocGroupDesc(JSPUtil.getParameter(request, prefix + "doc_group_desc", ""));
		setSrcDesc(JSPUtil.getParameter(request, prefix + "src_desc", ""));
		setSrc(JSPUtil.getParameter(request, prefix + "src", ""));
		setBorder(JSPUtil.getParameter(request, prefix + "border", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgDpcsDocWeightVO[]
	 */
	public BkgDpcsDocWeightVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgDpcsDocWeightVO[]
	 */
	public BkgDpcsDocWeightVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgDpcsDocWeightVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] hrdCdgIdSeq = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_id_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] srKind = (JSPUtil.getParameter(request, prefix	+ "sr_kind", length));
			String[] docGroup = (JSPUtil.getParameter(request, prefix	+ "doc_group", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] point = (JSPUtil.getParameter(request, prefix	+ "point", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srKindDesc = (JSPUtil.getParameter(request, prefix	+ "sr_kind_desc", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hrdCdgId = (JSPUtil.getParameter(request, prefix	+ "hrd_cdg_id", length));
			String[] docGroupDesc = (JSPUtil.getParameter(request, prefix	+ "doc_group_desc", length));
			String[] srcDesc = (JSPUtil.getParameter(request, prefix	+ "src_desc", length));
			String[] src = (JSPUtil.getParameter(request, prefix	+ "src", length));
			String[] border = (JSPUtil.getParameter(request, prefix	+ "border", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgDpcsDocWeightVO();
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (hrdCdgIdSeq[i] != null)
					model.setHrdCdgIdSeq(hrdCdgIdSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (srKind[i] != null)
					model.setSrKind(srKind[i]);
				if (docGroup[i] != null)
					model.setDocGroup(docGroup[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (point[i] != null)
					model.setPoint(point[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srKindDesc[i] != null)
					model.setSrKindDesc(srKindDesc[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hrdCdgId[i] != null)
					model.setHrdCdgId(hrdCdgId[i]);
				if (docGroupDesc[i] != null)
					model.setDocGroupDesc(docGroupDesc[i]);
				if (srcDesc[i] != null)
					model.setSrcDesc(srcDesc[i]);
				if (src[i] != null)
					model.setSrc(src[i]);
				if (border[i] != null)
					model.setBorder(border[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgDpcsDocWeightVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgDpcsDocWeightVO[]
	 */
	public BkgDpcsDocWeightVO[] getBkgDpcsDocWeightVOs(){
		BkgDpcsDocWeightVO[] vos = (BkgDpcsDocWeightVO[])models.toArray(new BkgDpcsDocWeightVO[models.size()]);
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
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgIdSeq = this.hrdCdgIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKind = this.srKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docGroup = this.docGroup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.point = this.point .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKindDesc = this.srKindDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hrdCdgId = this.hrdCdgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docGroupDesc = this.docGroupDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcDesc = this.srcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.src = this.src .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.border = this.border .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
