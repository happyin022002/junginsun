/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSgBlplHdrCopyVO.java
*@FileTitle : RsltPriSgBlplHdrCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.11 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSgBlplHdrCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSgBlplHdrCopyVO> models = new ArrayList<RsltPriSgBlplHdrCopyVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String blplHdrSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String blplNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String blplRefYr = null;
	/* Column Info */
	private String blplHdrSeqCopy = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSgBlplHdrCopyVO() {}

	public RsltPriSgBlplHdrCopyVO(String ibflag, String pagerows, String blplHdrSeq, String effDt, String expDt, String blplRefYr, String blplNm, String cfmFlg, String cfmUsrId, String creUsrId, String creDt, String updUsrId, String updDt, String blplHdrSeqCopy) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.cfmFlg = cfmFlg;
		this.blplHdrSeq = blplHdrSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.blplNm = blplNm;
		this.creUsrId = creUsrId;
		this.cfmUsrId = cfmUsrId;
		this.expDt = expDt;
		this.blplRefYr = blplRefYr;
		this.blplHdrSeqCopy = blplHdrSeqCopy;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("blpl_hdr_seq", getBlplHdrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("blpl_nm", getBlplNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("blpl_ref_yr", getBlplRefYr());
		this.hashColumns.put("blpl_hdr_seq_copy", getBlplHdrSeqCopy());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("blpl_hdr_seq", "blplHdrSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("blpl_nm", "blplNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("blpl_ref_yr", "blplRefYr");
		this.hashFields.put("blpl_hdr_seq_copy", "blplHdrSeqCopy");
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return blplHdrSeq
	 */
	public String getBlplHdrSeq() {
		return this.blplHdrSeq;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return blplNm
	 */
	public String getBlplNm() {
		return this.blplNm;
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
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return blplRefYr
	 */
	public String getBlplRefYr() {
		return this.blplRefYr;
	}
	
	/**
	 * Column Info
	 * @return blplHdrSeqCopy
	 */
	public String getBlplHdrSeqCopy() {
		return this.blplHdrSeqCopy;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param blplHdrSeq
	 */
	public void setBlplHdrSeq(String blplHdrSeq) {
		this.blplHdrSeq = blplHdrSeq;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param blplNm
	 */
	public void setBlplNm(String blplNm) {
		this.blplNm = blplNm;
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
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param blplRefYr
	 */
	public void setBlplRefYr(String blplRefYr) {
		this.blplRefYr = blplRefYr;
	}
	
	/**
	 * Column Info
	 * @param blplHdrSeqCopy
	 */
	public void setBlplHdrSeqCopy(String blplHdrSeqCopy) {
		this.blplHdrSeqCopy = blplHdrSeqCopy;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setBlplHdrSeq(JSPUtil.getParameter(request, "blpl_hdr_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setBlplNm(JSPUtil.getParameter(request, "blpl_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCfmUsrId(JSPUtil.getParameter(request, "cfm_usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setBlplRefYr(JSPUtil.getParameter(request, "blpl_ref_yr", ""));
		setBlplHdrSeqCopy(JSPUtil.getParameter(request, "blpl_hdr_seq_copy", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSgBlplHdrCopyVO[]
	 */
	public RsltPriSgBlplHdrCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSgBlplHdrCopyVO[]
	 */
	public RsltPriSgBlplHdrCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSgBlplHdrCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] blplHdrSeq = (JSPUtil.getParameter(request, prefix	+ "blpl_hdr_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] blplNm = (JSPUtil.getParameter(request, prefix	+ "blpl_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] blplRefYr = (JSPUtil.getParameter(request, prefix	+ "blpl_ref_yr", length));
			String[] blplHdrSeqCopy = (JSPUtil.getParameter(request, prefix	+ "blpl_hdr_seq_copy", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSgBlplHdrCopyVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (blplHdrSeq[i] != null)
					model.setBlplHdrSeq(blplHdrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (blplNm[i] != null)
					model.setBlplNm(blplNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (blplRefYr[i] != null)
					model.setBlplRefYr(blplRefYr[i]);
				if (blplHdrSeqCopy[i] != null)
					model.setBlplHdrSeqCopy(blplHdrSeqCopy[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSgBlplHdrCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSgBlplHdrCopyVO[]
	 */
	public RsltPriSgBlplHdrCopyVO[] getRsltPriSgBlplHdrCopyVOs(){
		RsltPriSgBlplHdrCopyVO[] vos = (RsltPriSgBlplHdrCopyVO[])models.toArray(new RsltPriSgBlplHdrCopyVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplHdrSeq = this.blplHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplNm = this.blplNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplRefYr = this.blplRefYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplHdrSeqCopy = this.blplHdrSeqCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
