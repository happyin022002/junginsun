/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScoStmtCdConvVO.java
*@FileTitle : ScoStmtCdConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;
 
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

public class ScoStmtCdConvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScoStmtCdConvVO> models = new ArrayList<ScoStmtCdConvVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String convTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String srcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srcDesc = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String tgtDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String tgtCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScoStmtCdConvVO() {}

	public ScoStmtCdConvVO(String ibflag, String pagerows, String convTpCd, String srcCd, String tgtCd, String srcDesc, String tgtDesc, String useFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.convTpCd = convTpCd;
		this.creUsrId = creUsrId;
		this.srcCd = srcCd;
		this.ibflag = ibflag;
		this.srcDesc = srcDesc;
		this.deltFlg = deltFlg;
		this.useFlg = useFlg;
		this.tgtDesc = tgtDesc;
		this.creDt = creDt;
		this.tgtCd = tgtCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("conv_tp_cd", getConvTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("src_desc", getSrcDesc());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("tgt_desc", getTgtDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("tgt_cd", getTgtCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("conv_tp_cd", "convTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("src_desc", "srcDesc");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("tgt_desc", "tgtDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tgt_cd", "tgtCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return convTpCd
	 */
	public String getConvTpCd() {
		return this.convTpCd;
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
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
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
	 * @return srcDesc
	 */
	public String getSrcDesc() {
		return this.srcDesc;
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
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
	}
	
	/**
	 * Column Info
	 * @return tgtDesc
	 */
	public String getTgtDesc() {
		return this.tgtDesc;
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
	 * @return tgtCd
	 */
	public String getTgtCd() {
		return this.tgtCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param convTpCd
	 */
	public void setConvTpCd(String convTpCd) {
		this.convTpCd = convTpCd;
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
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
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
	 * @param srcDesc
	 */
	public void setSrcDesc(String srcDesc) {
		this.srcDesc = srcDesc;
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
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
	}
	
	/**
	 * Column Info
	 * @param tgtDesc
	 */
	public void setTgtDesc(String tgtDesc) {
		this.tgtDesc = tgtDesc;
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
	 * @param tgtCd
	 */
	public void setTgtCd(String tgtCd) {
		this.tgtCd = tgtCd;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setConvTpCd(JSPUtil.getParameter(request, prefix + "conv_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrcDesc(JSPUtil.getParameter(request, prefix + "src_desc", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setTgtDesc(JSPUtil.getParameter(request, prefix + "tgt_desc", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTgtCd(JSPUtil.getParameter(request, prefix + "tgt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScoStmtCdConvVO[]
	 */
	public ScoStmtCdConvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScoStmtCdConvVO[]
	 */
	public ScoStmtCdConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScoStmtCdConvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] convTpCd = (JSPUtil.getParameter(request, prefix	+ "conv_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srcDesc = (JSPUtil.getParameter(request, prefix	+ "src_desc", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] tgtDesc = (JSPUtil.getParameter(request, prefix	+ "tgt_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] tgtCd = (JSPUtil.getParameter(request, prefix	+ "tgt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScoStmtCdConvVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (convTpCd[i] != null)
					model.setConvTpCd(convTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srcDesc[i] != null)
					model.setSrcDesc(srcDesc[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (tgtDesc[i] != null)
					model.setTgtDesc(tgtDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (tgtCd[i] != null)
					model.setTgtCd(tgtCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScoStmtCdConvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScoStmtCdConvVO[]
	 */
	public ScoStmtCdConvVO[] getScoStmtCdConvVOs(){
		ScoStmtCdConvVO[] vos = (ScoStmtCdConvVO[])models.toArray(new ScoStmtCdConvVO[models.size()]);
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
		this.convTpCd = this.convTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcDesc = this.srcDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtDesc = this.tgtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtCd = this.tgtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
