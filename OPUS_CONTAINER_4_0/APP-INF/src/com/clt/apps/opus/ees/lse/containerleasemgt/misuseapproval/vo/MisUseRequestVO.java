/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MisUseRequestVO.java
*@FileTitle : MisUseRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.30 장준우 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 장준우
 * @since J2EE 1.6
 * @see ..
 */
public class MisUseRequestVO extends AbstractValueObject {
	private static final long serialVersionUID = 1L;
	
	private Collection<MisUseRequestVO> models = new ArrayList<MisUseRequestVO>();
	
	private Logger log = Logger.getLogger("com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo");

		
	/* Status */
	private String ibflag = null;	
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String aproNo = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String mssRqstIoModCd = null;
	/* Column Info */
	private String n1stRefOfcCd = null;
	/* Column Info */
	private String n2ndRefOfcCd = null;
	/* Column Info */
	private String n3rdRefOfcCd = null;
	/* Column Info */
	private String n4thRefOfcCd = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String refOfcCd = null;	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private int iPage = 1;
	
	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * @return the rqstNo
	 */
	public String getRqstNo() {
		return rqstNo;
	}

	/**
	 * @param rqstNo the rqstNo to set
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * @return the aproNo
	 */
	public String getAproNo() {
		return aproNo;
	}
	
	/**
	 * @param aproNo the aproNo to set
	 */
	public void setAproNo(String aproNo) {
		this.aproNo = aproNo;
	}
	
	/**
	 * @return the rqstDt
	 */
	public String getRqstDt() {
		return rqstDt;
	}

	/**
	 * @param rqstDt the rqstDt to set
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}

	/**
	 * @return the rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return rqstOfcCd;
	}

	/**
	 * @param rqstOfcCd the rqstOfcCd to set
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}

	/**
	 * @return the mssRqstIoModCd
	 */
	public String getMssRqstIoModCd() {
		return mssRqstIoModCd;
	}

	/**
	 * @param mssRqstIoModCd the mssRqstIoModCd to set
	 */
	public void setMssRqstIoModCd(String mssRqstIoModCd) {
		this.mssRqstIoModCd = mssRqstIoModCd;
	}

	/**
	 * @return the n1stRefOfcCd
	 */
	public String getN1stRefOfcCd() {
		return n1stRefOfcCd;
	}

	/**
	 * @param n1stRefOfcCd the n1stRefOfcCd to set
	 */
	public void setN1stRefOfcCd(String n1stRefOfcCd) {
		this.n1stRefOfcCd = n1stRefOfcCd;
	}

	/**
	 * @return the n2ndRefOfcCd
	 */
	public String getN2ndRefOfcCd() {
		return n2ndRefOfcCd;
	}

	/**
	 * @param n2ndRefOfcCd the n2ndRefOfcCd to set
	 */
	public void setN2ndRefOfcCd(String n2ndRefOfcCd) {
		this.n2ndRefOfcCd = n2ndRefOfcCd;
	}

	/**
	 * @return the n3rdRefOfcCd
	 */
	public String getN3rdRefOfcCd() {
		return n3rdRefOfcCd;
	}

	/**
	 * @param n3rdRefOfcCd the n3rdRefOfcCd to set
	 */
	public void setN3rdRefOfcCd(String n3rdRefOfcCd) {
		this.n3rdRefOfcCd = n3rdRefOfcCd;
	}

	/**
	 * @return the n4thRefOfcCd
	 */
	public String getN4thRefOfcCd() {
		return n4thRefOfcCd;
	}

	/**
	 * @param n4thRefOfcCd the n4thRefOfcCd to set
	 */
	public void setN4thRefOfcCd(String n4thRefOfcCd) {
		this.n4thRefOfcCd = n4thRefOfcCd;
	}

	/**
	 * @return the rqstUsrId
	 */
	public String getRqstUsrId() {
		return rqstUsrId;
	}

	/**
	 * @param rqstUsrId the rqstUsrId to set
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}

	/**
	 * @return the diffRmk
	 */
	public String getDiffRmk() {
		return diffRmk;
	}

	/**
	 * @param diffRmk the diffRmk to set
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}

	/**
	 * @return the currCd
	 */
	public String getCurrCd() {
		return currCd;
	}

	/**
	 * @param currCd the currCd to set
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * @return the refOfcCd
	 */
	public String getRefOfcCd() {
		return refOfcCd;
	}

	/**
	 * @param refOfcCd the currCd to set
	 */
	public void setRefOfcCd(String refOfcCd) {
		this.refOfcCd = refOfcCd;
	}		

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}

	/**
	 * @param page the iPage to set
	 */
	public void setIPage(int page) {
		iPage = page;
	}



	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public MisUseRequestVO() {		
	}
		
	/**
	 * Constructor
	 */
	public MisUseRequestVO(String ibflag, String rqstNo, String aproNo, String rqstDt, String rqstOfcCd,
			String mssRqstIoModCd, String n1stRefOfcCd, String n2ndRefOfcCd,
			String n3rdRefOfcCd, String n4thRefOfcCd, String rqstUsrId,
			String diffRmk, String currCd, String refOfcCd, String creUsrId, String updUsrId,
			String pagerows) {
		this.ibflag = ibflag;
		this.rqstNo = rqstNo;
		this.aproNo = aproNo;
		this.rqstDt = rqstDt;
		this.rqstOfcCd = rqstOfcCd;
		this.mssRqstIoModCd = mssRqstIoModCd;
		this.n1stRefOfcCd = n1stRefOfcCd;
		this.n2ndRefOfcCd = n2ndRefOfcCd;
		this.n3rdRefOfcCd = n3rdRefOfcCd;
		this.n4thRefOfcCd = n4thRefOfcCd;
		this.rqstUsrId = rqstUsrId;
		this.diffRmk = diffRmk;
		this.currCd = currCd;
		this.refOfcCd = refOfcCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}

	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());				
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("apro_no", getAproNo());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("mss_rqst_io_mod_cd", getMssRqstIoModCd());
		this.hashColumns.put("n1st_ref_ofc_cd", getN1stRefOfcCd());
		this.hashColumns.put("n2nd_ref_ofc_cd", getN2ndRefOfcCd());
		this.hashColumns.put("n3rd_ref_ofc_cd", getN3rdRefOfcCd());
		this.hashColumns.put("n4th_ref_ofc_cd", getN4thRefOfcCd());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("ref_ofc_cd", getRefOfcCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("apro_no", "aproNo");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("mss_rqst_io_mod_cd", "mssRqstIoModCd");
		this.hashFields.put("n1st_ref_ofc_cd", "n1stRefOfcCd");
		this.hashFields.put("n2nd_ref_ofc_cd", "n2ndRefOfcCd");
		this.hashFields.put("n3rd_ref_ofc_cd", "n3rdRefOfcCd");
		this.hashFields.put("n4th_ref_ofc_cd", "n4thRefOfcCd");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("curr_cd", "currCd");		
		this.hashFields.put("ref_ofc_cd", "refOfcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * hasHttpServletRequestInfo
	 * @return
	 */
	public void fromRequest(HttpServletRequest request) {
		
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));		
		setRqstNo(JSPUtil.getParameter(request, "rqst_no", ""));
		setAproNo(JSPUtil.getParameter(request, "apro_no", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", "").replaceAll("-", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
		setMssRqstIoModCd(JSPUtil.getParameter(request, "mss_rqst_io_mod_cd", ""));
		setN1stRefOfcCd(JSPUtil.getParameter(request, "n1st_ref_ofc_cd", ""));
		setN2ndRefOfcCd(JSPUtil.getParameter(request, "n2nd_ref_ofc_cd", ""));
		setN3rdRefOfcCd(JSPUtil.getParameter(request, "n3rd_ref_ofc_cd", ""));
		setN4thRefOfcCd(JSPUtil.getParameter(request, "n4th_ref_ofc_cd", ""));
		setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setRefOfcCd(JSPUtil.getParameter(request, "ref_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
				
	}

	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public MisUseRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	
	/**
	 * hasHttpServletRequestGridInfo
	 * @return
	 */
	public MisUseRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MisUseRequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {			
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no".trim(), length));
			String[] aproNo = (JSPUtil.getParameter(request, prefix	+ "apro_no".trim(), length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt".trim(), length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd".trim(), length));
			String[] mssRqstIoModCd = (JSPUtil.getParameter(request, prefix	+ "mss_rqst_io_mod_cd".trim(), length));
			String[] n1stRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ref_ofc_cd".trim(), length));
			String[] n2ndRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ref_ofc_cd".trim(), length));	
			String[] n3rdRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_ref_ofc_cd".trim(), length));
			String[] n4thRefOfcCd = (JSPUtil.getParameter(request, prefix	+ "n4th_ref_ofc_cd".trim(), length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));			
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));			
			String[] refOfcCd = (JSPUtil.getParameter(request, prefix	+ "ref_ofc_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MisUseRequestVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);				
				if (aproNo[i] != null)
					model.setAproNo(aproNo[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);				
				if (mssRqstIoModCd[i] != null)
					model.setMssRqstIoModCd(mssRqstIoModCd[i]);
				if (n1stRefOfcCd[i] != null)
					model.setN1stRefOfcCd(n1stRefOfcCd[i]);				
				if (n2ndRefOfcCd[i] != null)
					model.setN2ndRefOfcCd(n2ndRefOfcCd[i]);
				if (n3rdRefOfcCd[i] != null)
					model.setN3rdRefOfcCd(n3rdRefOfcCd[i]);
				if (n4thRefOfcCd[i] != null)
					model.setN4thRefOfcCd(n4thRefOfcCd[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);				
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);				
				if (refOfcCd[i] != null)
					model.setRefOfcCd(refOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return getSearchParamVOs();
	}

	public MisUseRequestVO[] getSearchParamVOs(){
		MisUseRequestVO[] vos = (MisUseRequestVO[])models.toArray(new MisUseRequestVO[models.size()]);
		return vos;
	}
	
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
			log.error(ex.getMessage(), ex);
		}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
			log.error(ex.getMessage(), ex);
			throw new IllegalAccessException(ex.getMessage());
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){		
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproNo = this.aproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mssRqstIoModCd = this.mssRqstIoModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stRefOfcCd = this.n1stRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRefOfcCd = this.n2ndRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdRefOfcCd = this.n3rdRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thRefOfcCd = this.n4thRefOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refOfcCd = this.refOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}