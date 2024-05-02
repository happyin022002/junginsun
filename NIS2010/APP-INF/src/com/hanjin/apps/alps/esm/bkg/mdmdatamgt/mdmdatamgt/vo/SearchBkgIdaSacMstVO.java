/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchBkgIdaSacMstVO.java
*@FileTitle : SearchBkgIdaSacMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.28 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.mdmdatamgt.mdmdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBkgIdaSacMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchBkgIdaSacMstVO> models = new ArrayList<SearchBkgIdaSacMstVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String idaSacNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String level = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String idaIgstRto = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String idaSgstRto = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prntIdaSacCd = null;
	/* Column Info */
	private String idaUgstRto = null;
	/* Column Info */
	private String idaCgstRto = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String idaGstRto = null;
	/* Column Info */
	private String idaSacTpCd = null;
	/* Column Info */
	private String idaSacCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchBkgIdaSacMstVO() {}

	public SearchBkgIdaSacMstVO(String ibflag, String pagerows, String level, String idaSacCd, String idaSacNm, String idaSacTpCd, String prntIdaSacCd, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId, String idaGstRto, String idaCgstRto, String idaSgstRto, String idaIgstRto, String idaUgstRto) {
		this.pagerows = pagerows;
		this.idaSacNm = idaSacNm;
		this.ibflag = ibflag;
		this.level = level;
		this.deltFlg = deltFlg;
		this.idaIgstRto = idaIgstRto;
		this.updUsrId = updUsrId;
		this.idaSgstRto = idaSgstRto;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.prntIdaSacCd = prntIdaSacCd;
		this.idaUgstRto = idaUgstRto;
		this.idaCgstRto = idaCgstRto;
		this.updDt = updDt;
		this.idaGstRto = idaGstRto;
		this.idaSacTpCd = idaSacTpCd;
		this.idaSacCd = idaSacCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ida_sac_nm", getIdaSacNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ida_igst_rto", getIdaIgstRto());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prnt_ida_sac_cd", getPrntIdaSacCd());
		this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());
		this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ida_gst_rto", getIdaGstRto());
		this.hashColumns.put("ida_sac_tp_cd", getIdaSacTpCd());
		this.hashColumns.put("ida_sac_cd", getIdaSacCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ida_sac_nm", "idaSacNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("level", "level");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ida_igst_rto", "idaIgstRto");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ida_sgst_rto", "idaSgstRto");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prnt_ida_sac_cd", "prntIdaSacCd");
		this.hashFields.put("ida_ugst_rto", "idaUgstRto");
		this.hashFields.put("ida_cgst_rto", "idaCgstRto");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ida_gst_rto", "idaGstRto");
		this.hashFields.put("ida_sac_tp_cd", "idaSacTpCd");
		this.hashFields.put("ida_sac_cd", "idaSacCd");
		return this.hashFields;
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
	 * @return idaSacNm
	 */
	public String getIdaSacNm() {
		return this.idaSacNm;
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
	 * @return level
	 */
	public String getLevel() {
		return this.level;
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
	 * @return idaIgstRto
	 */
	public String getIdaIgstRto() {
		return this.idaIgstRto;
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
	 * @return idaSgstRto
	 */
	public String getIdaSgstRto() {
		return this.idaSgstRto;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return prntIdaSacCd
	 */
	public String getPrntIdaSacCd() {
		return this.prntIdaSacCd;
	}
	
	/**
	 * Column Info
	 * @return idaUgstRto
	 */
	public String getIdaUgstRto() {
		return this.idaUgstRto;
	}
	
	/**
	 * Column Info
	 * @return idaCgstRto
	 */
	public String getIdaCgstRto() {
		return this.idaCgstRto;
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
	 * @return idaGstRto
	 */
	public String getIdaGstRto() {
		return this.idaGstRto;
	}
	
	/**
	 * Column Info
	 * @return idaSacTpCd
	 */
	public String getIdaSacTpCd() {
		return this.idaSacTpCd;
	}
	
	/**
	 * Column Info
	 * @return idaSacCd
	 */
	public String getIdaSacCd() {
		return this.idaSacCd;
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
	 * @param idaSacNm
	 */
	public void setIdaSacNm(String idaSacNm) {
		this.idaSacNm = idaSacNm;
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
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
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
	 * @param idaIgstRto
	 */
	public void setIdaIgstRto(String idaIgstRto) {
		this.idaIgstRto = idaIgstRto;
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
	 * @param idaSgstRto
	 */
	public void setIdaSgstRto(String idaSgstRto) {
		this.idaSgstRto = idaSgstRto;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param prntIdaSacCd
	 */
	public void setPrntIdaSacCd(String prntIdaSacCd) {
		this.prntIdaSacCd = prntIdaSacCd;
	}
	
	/**
	 * Column Info
	 * @param idaUgstRto
	 */
	public void setIdaUgstRto(String idaUgstRto) {
		this.idaUgstRto = idaUgstRto;
	}
	
	/**
	 * Column Info
	 * @param idaCgstRto
	 */
	public void setIdaCgstRto(String idaCgstRto) {
		this.idaCgstRto = idaCgstRto;
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
	 * @param idaGstRto
	 */
	public void setIdaGstRto(String idaGstRto) {
		this.idaGstRto = idaGstRto;
	}
	
	/**
	 * Column Info
	 * @param idaSacTpCd
	 */
	public void setIdaSacTpCd(String idaSacTpCd) {
		this.idaSacTpCd = idaSacTpCd;
	}
	
	/**
	 * Column Info
	 * @param idaSacCd
	 */
	public void setIdaSacCd(String idaSacCd) {
		this.idaSacCd = idaSacCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIdaSacNm(JSPUtil.getParameter(request, prefix + "ida_sac_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setIdaIgstRto(JSPUtil.getParameter(request, prefix + "ida_igst_rto", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setIdaSgstRto(JSPUtil.getParameter(request, prefix + "ida_sgst_rto", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPrntIdaSacCd(JSPUtil.getParameter(request, prefix + "prnt_ida_sac_cd", ""));
		setIdaUgstRto(JSPUtil.getParameter(request, prefix + "ida_ugst_rto", ""));
		setIdaCgstRto(JSPUtil.getParameter(request, prefix + "ida_cgst_rto", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIdaGstRto(JSPUtil.getParameter(request, prefix + "ida_gst_rto", ""));
		setIdaSacTpCd(JSPUtil.getParameter(request, prefix + "ida_sac_tp_cd", ""));
		setIdaSacCd(JSPUtil.getParameter(request, prefix + "ida_sac_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBkgIdaSacMstVO[]
	 */
	public SearchBkgIdaSacMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBkgIdaSacMstVO[]
	 */
	public SearchBkgIdaSacMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBkgIdaSacMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] idaSacNm = (JSPUtil.getParameter(request, prefix	+ "ida_sac_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] idaIgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_igst_rto", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] idaSgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_sgst_rto", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] prntIdaSacCd = (JSPUtil.getParameter(request, prefix	+ "prnt_ida_sac_cd", length));
			String[] idaUgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_ugst_rto", length));
			String[] idaCgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_cgst_rto", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] idaGstRto = (JSPUtil.getParameter(request, prefix	+ "ida_gst_rto", length));
			String[] idaSacTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_sac_tp_cd", length));
			String[] idaSacCd = (JSPUtil.getParameter(request, prefix	+ "ida_sac_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchBkgIdaSacMstVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (idaSacNm[i] != null)
					model.setIdaSacNm(idaSacNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (idaIgstRto[i] != null)
					model.setIdaIgstRto(idaIgstRto[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (idaSgstRto[i] != null)
					model.setIdaSgstRto(idaSgstRto[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prntIdaSacCd[i] != null)
					model.setPrntIdaSacCd(prntIdaSacCd[i]);
				if (idaUgstRto[i] != null)
					model.setIdaUgstRto(idaUgstRto[i]);
				if (idaCgstRto[i] != null)
					model.setIdaCgstRto(idaCgstRto[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (idaGstRto[i] != null)
					model.setIdaGstRto(idaGstRto[i]);
				if (idaSacTpCd[i] != null)
					model.setIdaSacTpCd(idaSacTpCd[i]);
				if (idaSacCd[i] != null)
					model.setIdaSacCd(idaSacCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBkgIdaSacMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBkgIdaSacMstVO[]
	 */
	public SearchBkgIdaSacMstVO[] getSearchBkgIdaSacMstVOs(){
		SearchBkgIdaSacMstVO[] vos = (SearchBkgIdaSacMstVO[])models.toArray(new SearchBkgIdaSacMstVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacNm = this.idaSacNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstRto = this.idaIgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstRto = this.idaSgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntIdaSacCd = this.prntIdaSacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstRto = this.idaUgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstRto = this.idaCgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstRto = this.idaGstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacTpCd = this.idaSacTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacCd = this.idaSacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
