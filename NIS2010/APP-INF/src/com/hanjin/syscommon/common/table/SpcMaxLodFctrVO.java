/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpcMaxLodFctrVO.java
*@FileTitle : SpcMaxLodFctrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.23 최윤성 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpcMaxLodFctrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpcMaxLodFctrVO> models = new ArrayList<SpcMaxLodFctrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String voyDiffWk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String maxLdfRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpcMaxLodFctrVO() {}

	public SpcMaxLodFctrVO(String ibflag, String pagerows, String bseYr, String voyDiffWk, String rlaneCd, String dirCd, String trdCd, String subTrdCd, String maxLdfRto, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.voyDiffWk = voyDiffWk;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.maxLdfRto = maxLdfRto;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.dirCd = dirCd;
		this.subTrdCd = subTrdCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("voy_diff_wk", getVoyDiffWk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("max_ldf_rto", getMaxLdfRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("voy_diff_wk", "voyDiffWk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("max_ldf_rto", "maxLdfRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
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
	 * @return voyDiffWk
	 */
	public String getVoyDiffWk() {
		return this.voyDiffWk;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return maxLdfRto
	 */
	public String getMaxLdfRto() {
		return this.maxLdfRto;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param voyDiffWk
	 */
	public void setVoyDiffWk(String voyDiffWk) {
		this.voyDiffWk = voyDiffWk;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param maxLdfRto
	 */
	public void setMaxLdfRto(String maxLdfRto) {
		this.maxLdfRto = maxLdfRto;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setVoyDiffWk(JSPUtil.getParameter(request, "voy_diff_wk", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMaxLdfRto(JSPUtil.getParameter(request, "max_ldf_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpcMaxLodFctrVO[]
	 */
	public SpcMaxLodFctrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpcMaxLodFctrVO[]
	 */
	public SpcMaxLodFctrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpcMaxLodFctrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] voyDiffWk = (JSPUtil.getParameter(request, prefix	+ "voy_diff_wk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] maxLdfRto = (JSPUtil.getParameter(request, prefix	+ "max_ldf_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpcMaxLodFctrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (voyDiffWk[i] != null)
					model.setVoyDiffWk(voyDiffWk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (maxLdfRto[i] != null)
					model.setMaxLdfRto(maxLdfRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpcMaxLodFctrVOs();
	}
    
	/* 2009.08.12 HJ LEE */
	public SpcMaxLodFctrVO[] fromRequestGridArrayList(HttpServletRequest request, String prefix) {
		SpcMaxLodFctrVO model = null;		
		
		String[] tmp = request.getParameterValues(prefix + "FLG");
  		if(tmp == null)
   			return null;
        
  		String[] ldf = {"05","04","03","02","01"};  		
  		
  		int length = request.getParameterValues(prefix + "FLG").length;
  		
		try {
			
			
				String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			    String voyDiffWk = null;					   
			
			    String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			    String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			    String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			    String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			    String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));			    
			    String[] maxLdfRto05 = (JSPUtil.getParameter(request, prefix	+ "ldf_05", length));
			    String[] maxLdfRto04 = (JSPUtil.getParameter(request, prefix	+ "ldf_04", length));
			    String[] maxLdfRto03 = (JSPUtil.getParameter(request, prefix	+ "ldf_03", length));
			    String[] maxLdfRto02 = (JSPUtil.getParameter(request, prefix	+ "ldf_02", length));
			    String[] maxLdfRto01 = (JSPUtil.getParameter(request, prefix	+ "ldf_01", length));
			    String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "FLG", length));
			    String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			    String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			    String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			    String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			    for (int i = 0; i < length; i++) {
			    	voyDiffWk = maxLdfRto05[i]+","+maxLdfRto04[i]+","+maxLdfRto03[i]+","+maxLdfRto02[i]+","+maxLdfRto01[i];
			    	
			    	String[] arrTmp = voyDiffWk.split(",");
			    	for(int k = 0; k < ldf.length; k++){
			    		model = new SpcMaxLodFctrVO();
						if (updDt[i] != null)
							model.setUpdDt(updDt[i]);
						if (ldf[k] != null)
							model.setVoyDiffWk(ldf[k]);
						if (creDt[i] != null)
							model.setCreDt(creDt[i]);
						if (trdCd[i] != null)
							model.setTrdCd(trdCd[i]);
						if (bseYr[i] != null)
							model.setBseYr(bseYr[i]);
						if (rlaneCd[i] != null)
							model.setRlaneCd(rlaneCd[i]);
						if (pagerows[i] != null)
							model.setPagerows(pagerows[i]);
						if (arrTmp[k] != null)
							model.setMaxLdfRto(arrTmp[k]);
						if (ibflag[i] != null)
							model.setIbflag(ibflag[i]);
						if (creUsrId[i] != null)
							model.setCreUsrId(creUsrId[i]);
						if (dirCd[i] != null)
							model.setDirCd(dirCd[i]);
						if (subTrdCd[i] != null)
							model.setSubTrdCd(subTrdCd[i]);
						if (updUsrId[i] != null)
							model.setUpdUsrId(updUsrId[i]);
						models.add(model);
				}
			  }
		} catch (Exception e) {
			return null;
		}
		return getSpcMaxLodFctrVOs();
	}
	
	/**
	 * VO 배열을 반환
	 * @return SpcMaxLodFctrVO[]
	 */
	public SpcMaxLodFctrVO[] getSpcMaxLodFctrVOs(){
		SpcMaxLodFctrVO[] vos = (SpcMaxLodFctrVO[])models.toArray(new SpcMaxLodFctrVO[models.size()]);
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
		this.voyDiffWk = this.voyDiffWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxLdfRto = this.maxLdfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
