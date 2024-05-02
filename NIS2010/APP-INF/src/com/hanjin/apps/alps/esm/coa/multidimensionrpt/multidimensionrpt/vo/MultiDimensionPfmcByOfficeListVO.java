/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MultiDimensionPfmcByOfficeListVO.java
*@FileTitle : MultiDimensionPfmcByOfficeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.09.22 김기식 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MultiDimensionPfmcByOfficeListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultiDimensionPfmcByOfficeListVO> models = new ArrayList<MultiDimensionPfmcByOfficeListVO>();
	
	/* Column Info */
	private String rev = null;
	/* Column Info */
	private String save = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String repoCostAmt = null;
	/* Column Info */
	private String cost = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String pod = null;
	
	/////////////////////////////////////
	String[] cArr = null;	
	String[] rtoArr = null;
	
	/* DB RowSet 객체  */
	private DBRowSet rowSet = null;	
		
	/** DBRowSet Getter */
	public DBRowSet getRowSet() {
		return rowSet;
	}
	/** DBRowSet Setter */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
	public String[] getCArr() {
		return cArr;
	}
	public void setCArr(String[] rowSetHeader) {
		this.cArr = rowSetHeader;
	}	
	public String[] getRtoArr() {
		return rtoArr;
	}
	public void setRtoArr(String[] rowSetHeader) {
		this.rtoArr = rowSetHeader;
	}
	//////////////////////////

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MultiDimensionPfmcByOfficeListVO() {}

	public MultiDimensionPfmcByOfficeListVO(String ibflag, String pagerows, String trdCd, String dirCd, String cntrTpszCd, String bkgQty, String rev, String cost, String cm, String repoCostAmt, String save, String crAmt, String bkgNo, String rlaneCd, String pol, String pod, String por, String del) {
		this.rev = rev;
		this.save = save;
		this.por = por;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.repoCostAmt = repoCostAmt;
		this.cost = cost;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.crAmt = crAmt;
		this.cm = cm;
		this.bkgQty = bkgQty;
		this.pol = pol;
		this.cntrTpszCd = cntrTpszCd;
		this.del = del;
		this.dirCd = dirCd;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("save", getSave());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("repo_cost_amt", getRepoCostAmt());
		this.hashColumns.put("cost", getCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev", "rev");
		this.hashFields.put("save", "save");
		this.hashFields.put("por", "por");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("repo_cost_amt", "repoCostAmt");
		this.hashFields.put("cost", "cost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("del", "del");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rev
	 */
	public String getRev() {
		return this.rev;
	}
	
	/**
	 * Column Info
	 * @return save
	 */
	public String getSave() {
		return this.save;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return repoCostAmt
	 */
	public String getRepoCostAmt() {
		return this.repoCostAmt;
	}
	
	/**
	 * Column Info
	 * @return cost
	 */
	public String getCost() {
		return this.cost;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
	}
	
	/**
	 * Column Info
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}
	
	/**
	 * Column Info
	 * @param save
	 */
	public void setSave(String save) {
		this.save = save;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param repoCostAmt
	 */
	public void setRepoCostAmt(String repoCostAmt) {
		this.repoCostAmt = repoCostAmt;
	}
	
	/**
	 * Column Info
	 * @param cost
	 */
	public void setCost(String cost) {
		this.cost = cost;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
	}
	
	/**
	 * Column Info
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRev(JSPUtil.getParameter(request, "rev", ""));
		setSave(JSPUtil.getParameter(request, "save", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setRepoCostAmt(JSPUtil.getParameter(request, "repo_cost_amt", ""));
		setCost(JSPUtil.getParameter(request, "cost", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setBkgQty(JSPUtil.getParameter(request, "bkg_qty", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MultiDimensionPfmcByOfficeListVO[]
	 */
	public MultiDimensionPfmcByOfficeListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MultiDimensionPfmcByOfficeListVO[]
	 */
	public MultiDimensionPfmcByOfficeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultiDimensionPfmcByOfficeListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] save = (JSPUtil.getParameter(request, prefix	+ "save", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] repoCostAmt = (JSPUtil.getParameter(request, prefix	+ "repo_cost_amt", length));
			String[] cost = (JSPUtil.getParameter(request, prefix	+ "cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new MultiDimensionPfmcByOfficeListVO();
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (save[i] != null)
					model.setSave(save[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (repoCostAmt[i] != null)
					model.setRepoCostAmt(repoCostAmt[i]);
				if (cost[i] != null)
					model.setCost(cost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMultiDimensionPfmcByOfficeListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MultiDimensionPfmcByOfficeListVO[]
	 */
	public MultiDimensionPfmcByOfficeListVO[] getMultiDimensionPfmcByOfficeListVOs(){
		MultiDimensionPfmcByOfficeListVO[] vos = (MultiDimensionPfmcByOfficeListVO[])models.toArray(new MultiDimensionPfmcByOfficeListVO[models.size()]);
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
		this.rev = this.rev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.save = this.save .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoCostAmt = this.repoCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cost = this.cost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
