/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : LookupDetailVO.java
*@FileTitle : LookupDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.27  
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

public class LookupDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LookupDetailVO> models = new ArrayList<LookupDetailVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String luCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String luTpCd = null;
	/* Column Info */
	private String luStDt = null;
	/* Column Info */
	private String luDesc = null;
	/* Column Info */
	private String enblFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String attrCtnt1 = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String luEndDt = null;
	/* Column Info */
	private String attrCtnt2 = null;
	/* Column Info */
	private String attrCtnt3 = null;
	/* Column Info */
	private String attrCtnt4 = null;
	/* Column Info */
	private String attrCtnt5 = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public LookupDetailVO() {}

	public LookupDetailVO(String ibflag, String pagerows, String dpSeq, String luTpCd, String luCd, String luDesc, String enblFlg, String luStDt, String luEndDt, String attrCtnt1, String attrCtnt2, String attrCtnt3, String attrCtnt4, String attrCtnt5, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.dpSeq = dpSeq;
		this.luCd = luCd;
		this.creDt = creDt;
		this.luTpCd = luTpCd;
		this.luStDt = luStDt;
		this.luDesc = luDesc;
		this.enblFlg = enblFlg;
		this.pagerows = pagerows;
		this.attrCtnt1 = attrCtnt1;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.luEndDt = luEndDt;
		this.attrCtnt2 = attrCtnt2;
		this.attrCtnt3 = attrCtnt3;
		this.attrCtnt4 = attrCtnt4;
		this.attrCtnt5 = attrCtnt5;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("lu_cd", getLuCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("lu_tp_cd", getLuTpCd());
		this.hashColumns.put("lu_st_dt", getLuStDt());
		this.hashColumns.put("lu_desc", getLuDesc());
		this.hashColumns.put("enbl_flg", getEnblFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lu_end_dt", getLuEndDt());
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("lu_cd", "luCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("lu_tp_cd", "luTpCd");
		this.hashFields.put("lu_st_dt", "luStDt");
		this.hashFields.put("lu_desc", "luDesc");
		this.hashFields.put("enbl_flg", "enblFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lu_end_dt", "luEndDt");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
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
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return luCd
	 */
	public String getLuCd() {
		return this.luCd;
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
	 * @return luTpCd
	 */
	public String getLuTpCd() {
		return this.luTpCd;
	}
	
	/**
	 * Column Info
	 * @return luStDt
	 */
	public String getLuStDt() {
		return this.luStDt;
	}
	
	/**
	 * Column Info
	 * @return luDesc
	 */
	public String getLuDesc() {
		return this.luDesc;
	}
	
	/**
	 * Column Info
	 * @return enblFlg
	 */
	public String getEnblFlg() {
		return this.enblFlg;
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
	 * @return attrCtnt1
	 */
	public String getAttrCtnt1() {
		return this.attrCtnt1;
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
	 * @return luEndDt
	 */
	public String getLuEndDt() {
		return this.luEndDt;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt2
	 */
	public String getAttrCtnt2() {
		return this.attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt3
	 */
	public String getAttrCtnt3() {
		return this.attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt4
	 */
	public String getAttrCtnt4() {
		return this.attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @return attrCtnt5
	 */
	public String getAttrCtnt5() {
		return this.attrCtnt5;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param luCd
	 */
	public void setLuCd(String luCd) {
		this.luCd = luCd;
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
	 * @param luTpCd
	 */
	public void setLuTpCd(String luTpCd) {
		this.luTpCd = luTpCd;
	}
	
	/**
	 * Column Info
	 * @param luStDt
	 */
	public void setLuStDt(String luStDt) {
		this.luStDt = luStDt;
	}
	
	/**
	 * Column Info
	 * @param luDesc
	 */
	public void setLuDesc(String luDesc) {
		this.luDesc = luDesc;
	}
	
	/**
	 * Column Info
	 * @param enblFlg
	 */
	public void setEnblFlg(String enblFlg) {
		this.enblFlg = enblFlg;
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
	 * @param attrCtnt1
	 */
	public void setAttrCtnt1(String attrCtnt1) {
		this.attrCtnt1 = attrCtnt1;
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
	 * @param luEndDt
	 */
	public void setLuEndDt(String luEndDt) {
		this.luEndDt = luEndDt;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt2
	 */
	public void setAttrCtnt2(String attrCtnt2) {
		this.attrCtnt2 = attrCtnt2;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt3
	 */
	public void setAttrCtnt3(String attrCtnt3) {
		this.attrCtnt3 = attrCtnt3;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt4
	 */
	public void setAttrCtnt4(String attrCtnt4) {
		this.attrCtnt4 = attrCtnt4;
	}
	
	/**
	 * Column Info
	 * @param attrCtnt5
	 */
	public void setAttrCtnt5(String attrCtnt5) {
		this.attrCtnt5 = attrCtnt5;
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
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setLuCd(JSPUtil.getParameter(request, prefix + "lu_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLuTpCd(JSPUtil.getParameter(request, prefix + "lu_tp_cd", ""));
		setLuStDt(JSPUtil.getParameter(request, prefix + "lu_st_dt", ""));
		setLuDesc(JSPUtil.getParameter(request, prefix + "lu_desc", ""));
		setEnblFlg(JSPUtil.getParameter(request, prefix + "enbl_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAttrCtnt1(JSPUtil.getParameter(request, prefix + "attr_ctnt1", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLuEndDt(JSPUtil.getParameter(request, prefix + "lu_end_dt", ""));
		setAttrCtnt2(JSPUtil.getParameter(request, prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request, prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request, prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request, prefix + "attr_ctnt5", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LookupDetailVO[]
	 */
	public LookupDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LookupDetailVO[]
	 */
	public LookupDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LookupDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] luCd = (JSPUtil.getParameter(request, prefix	+ "lu_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] luTpCd = (JSPUtil.getParameter(request, prefix	+ "lu_tp_cd", length));
			String[] luStDt = (JSPUtil.getParameter(request, prefix	+ "lu_st_dt", length));
			String[] luDesc = (JSPUtil.getParameter(request, prefix	+ "lu_desc", length));
			String[] enblFlg = (JSPUtil.getParameter(request, prefix	+ "enbl_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] attrCtnt1 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt1", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] luEndDt = (JSPUtil.getParameter(request, prefix	+ "lu_end_dt", length));
			String[] attrCtnt2 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt2", length));
			String[] attrCtnt3 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt3", length));
			String[] attrCtnt4 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt4", length));
			String[] attrCtnt5 = (JSPUtil.getParameter(request, prefix	+ "attr_ctnt5", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new LookupDetailVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (luCd[i] != null)
					model.setLuCd(luCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (luTpCd[i] != null)
					model.setLuTpCd(luTpCd[i]);
				if (luStDt[i] != null)
					model.setLuStDt(luStDt[i]);
				if (luDesc[i] != null)
					model.setLuDesc(luDesc[i]);
				if (enblFlg[i] != null)
					model.setEnblFlg(enblFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (attrCtnt1[i] != null)
					model.setAttrCtnt1(attrCtnt1[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (luEndDt[i] != null)
					model.setLuEndDt(luEndDt[i]);
				if (attrCtnt2[i] != null)
					model.setAttrCtnt2(attrCtnt2[i]);
				if (attrCtnt3[i] != null)
					model.setAttrCtnt3(attrCtnt3[i]);
				if (attrCtnt4[i] != null)
					model.setAttrCtnt4(attrCtnt4[i]);
				if (attrCtnt5[i] != null)
					model.setAttrCtnt5(attrCtnt5[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLookupDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LookupDetailVO[]
	 */
	public LookupDetailVO[] getLookupDetailVOs(){
		LookupDetailVO[] vos = (LookupDetailVO[])models.toArray(new LookupDetailVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luCd = this.luCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luTpCd = this.luTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luStDt = this.luStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luDesc = this.luDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enblFlg = this.enblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 = this.attrCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luEndDt = this.luEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 = this.attrCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 = this.attrCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 = this.attrCtnt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 = this.attrCtnt5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
