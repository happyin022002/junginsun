/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoaSimRsltVO.java
*@FileTitle : CoaSimRsltVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.12.30 서창열 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CoaSimRsltVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoaSimRsltVO> models = new ArrayList<CoaSimRsltVO>();
	
	/* Column Info */
	private String rev = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rpb = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String lf = null;
	/* Column Info */
	private String tot = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CoaSimRsltVO() {}

	public CoaSimRsltVO(String ibflag, String pagerows, String lf, String rpb, String rev, String op, String tot) {
		this.rev = rev;
		this.ibflag = ibflag;
		this.rpb = rpb;
		this.op = op;
		this.lf = lf;
		this.pagerows = pagerows;
		this.tot = tot;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpb", getRpb());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("lf", getLf());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tot", getTot());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev", "rev");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpb", "rpb");
		this.hashFields.put("op", "op");
		this.hashFields.put("lf", "lf");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tot", "tot");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return rpb
	 */
	public String getRpb() {
		return this.rpb;
	}
	
	/**
	 * Column Info
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return lf
	 */
	public String getLf() {
		return this.lf;
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
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
	}
	

	/**
	 * Column Info
	 * @param rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
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
	 * @param rpb
	 */
	public void setRpb(String rpb) {
		this.rpb = rpb;
	}
	
	/**
	 * Column Info
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param lf
	 */
	public void setLf(String lf) {
		this.lf = lf;
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
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRev(JSPUtil.getParameter(request, "rev", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRpb(JSPUtil.getParameter(request, "rpb", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setLf(JSPUtil.getParameter(request, "lf", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTot(JSPUtil.getParameter(request, "tot", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoaSimRsltVO[]
	 */
	public CoaSimRsltVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoaSimRsltVO[]
	 */
	public CoaSimRsltVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoaSimRsltVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rpb = (JSPUtil.getParameter(request, prefix	+ "rpb", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] lf = (JSPUtil.getParameter(request, prefix	+ "lf", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoaSimRsltVO();
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rpb[i] != null)
					model.setRpb(rpb[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (lf[i] != null)
					model.setLf(lf[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoaSimRsltVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoaSimRsltVO[]
	 */
	public CoaSimRsltVO[] getCoaSimRsltVOs(){
		CoaSimRsltVO[] vos = (CoaSimRsltVO[])models.toArray(new CoaSimRsltVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rpb = this.rpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lf = this.lf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
