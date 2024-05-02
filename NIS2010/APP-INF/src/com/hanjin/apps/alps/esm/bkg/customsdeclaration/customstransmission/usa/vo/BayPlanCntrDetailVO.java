/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BayPlanCntrDetailVO.java
*@FileTitle : BayPlanCntrDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.14 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BayPlanCntrDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BayPlanCntrDetailVO> models = new ArrayList<BayPlanCntrDetailVO>();
	
	/* Column Info */
	private String fmInd = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String imdg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pos = null;
	/* Column Info */
	private String unno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrtype = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String scac = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BayPlanCntrDetailVO() {}

	public BayPlanCntrDetailVO(String ibflag, String pagerows, String cntrNo, String cntrtype, String fmInd, String pos, String wgt, String por, String pol, String pod, String del, String imdg, String unno, String scac) {
		this.fmInd = fmInd;
		this.por = por;
		this.imdg = imdg;
		this.pagerows = pagerows;
		this.pos = pos;
		this.unno = unno;
		this.ibflag = ibflag;
		this.cntrtype = cntrtype;
		this.wgt = wgt;
		this.scac = scac;
		this.cntrNo = cntrNo;
		this.pol = pol;
		this.del = del;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_ind", getFmInd());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("imdg", getImdg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pos", getPos());
		this.hashColumns.put("unno", getUnno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntrtype", getCntrtype());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("scac", getScac());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_ind", "fmInd");
		this.hashFields.put("por", "por");
		this.hashFields.put("imdg", "imdg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pos", "pos");
		this.hashFields.put("unno", "unno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntrtype", "cntrtype");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("scac", "scac");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmInd
	 */
	public String getFmInd() {
		return this.fmInd;
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
	 * @return imdg
	 */
	public String getImdg() {
		return this.imdg;
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
	 * @return pos
	 */
	public String getPos() {
		return this.pos;
	}
	
	/**
	 * Column Info
	 * @return unno
	 */
	public String getUnno() {
		return this.unno;
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
	 * @return cntrtype
	 */
	public String getCntrtype() {
		return this.cntrtype;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return scac
	 */
	public String getScac() {
		return this.scac;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return del
	 */
	public String getDel() {
		return this.del;
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
	 * @param fmInd
	 */
	public void setFmInd(String fmInd) {
		this.fmInd = fmInd;
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
	 * @param imdg
	 */
	public void setImdg(String imdg) {
		this.imdg = imdg;
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
	 * @param pos
	 */
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	/**
	 * Column Info
	 * @param unno
	 */
	public void setUnno(String unno) {
		this.unno = unno;
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
	 * @param cntrtype
	 */
	public void setCntrtype(String cntrtype) {
		this.cntrtype = cntrtype;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param scac
	 */
	public void setScac(String scac) {
		this.scac = scac;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
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
		setFmInd(JSPUtil.getParameter(request, "fm_ind", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setImdg(JSPUtil.getParameter(request, "imdg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPos(JSPUtil.getParameter(request, "pos", ""));
		setUnno(JSPUtil.getParameter(request, "unno", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrtype(JSPUtil.getParameter(request, "cntrtype", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setScac(JSPUtil.getParameter(request, "scac", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BayPlanCntrDetailVO[]
	 */
	public BayPlanCntrDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BayPlanCntrDetailVO[]
	 */
	public BayPlanCntrDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BayPlanCntrDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmInd = (JSPUtil.getParameter(request, prefix	+ "fm_ind", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] imdg = (JSPUtil.getParameter(request, prefix	+ "imdg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pos = (JSPUtil.getParameter(request, prefix	+ "pos", length));
			String[] unno = (JSPUtil.getParameter(request, prefix	+ "unno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrtype = (JSPUtil.getParameter(request, prefix	+ "cntrtype", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] scac = (JSPUtil.getParameter(request, prefix	+ "scac", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new BayPlanCntrDetailVO();
				if (fmInd[i] != null)
					model.setFmInd(fmInd[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (imdg[i] != null)
					model.setImdg(imdg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pos[i] != null)
					model.setPos(pos[i]);
				if (unno[i] != null)
					model.setUnno(unno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrtype[i] != null)
					model.setCntrtype(cntrtype[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (scac[i] != null)
					model.setScac(scac[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBayPlanCntrDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BayPlanCntrDetailVO[]
	 */
	public BayPlanCntrDetailVO[] getBayPlanCntrDetailVOs(){
		BayPlanCntrDetailVO[] vos = (BayPlanCntrDetailVO[])models.toArray(new BayPlanCntrDetailVO[models.size()]);
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
		this.fmInd = this.fmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg = this.imdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pos = this.pos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unno = this.unno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtype = this.cntrtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scac = this.scac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
