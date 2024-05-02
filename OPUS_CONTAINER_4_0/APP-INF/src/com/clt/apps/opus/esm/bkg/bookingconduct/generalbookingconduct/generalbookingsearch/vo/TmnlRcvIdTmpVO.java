/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TmnlRcvIdVO.java
*@FileTitle : TmnlRcvIdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.29 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TmnlRcvIdTmpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TmnlRcvIdTmpVO> models = new ArrayList<TmnlRcvIdTmpVO>();
	
	/* Column Info */
	private String bracCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediRcvId = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String ediId = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String kindCd = null;
	/* Column Info */
	private String flatFiles = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TmnlRcvIdTmpVO() {}

	public TmnlRcvIdTmpVO(String ibflag, String pagerows, String ediRcvId, String portCd, String ediId, String bracCd, String kind) {
		this.bracCd = bracCd;
		this.ibflag = ibflag;
		this.ediRcvId = ediRcvId;
		this.portCd = portCd;
		this.ediId = ediId;
		this.pagerows = pagerows;
		this.kindCd = kindCd;
		this.flatFiles = flatFiles;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("brac_cd", getBracCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_rcv_id", getEdiRcvId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kind_cd", getKindCd());
		this.hashColumns.put("flat_files", getFlatFiles());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("brac_cd", "bracCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_rcv_id", "ediRcvId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kind_cd", "kindCd");
		this.hashFields.put("flat_files", "flatFiles");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bracCd
	 */
	public String getBracCd() {
		return this.bracCd;
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
	 * @return ediRcvId
	 */
	public String getEdiRcvId() {
		return this.ediRcvId;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * kind
	 * @return kind
	 */
	public String getKindCd() {
		return this.kindCd;
	}	

	/**
	 * Column Info
	 * @return ediId
	 */
	public String getFlatFiles() {
		return this.flatFiles;
	}

	/**
	 * Column Info
	 * @param bracCd
	 */
	public void setBracCd(String bracCd) {
		this.bracCd = bracCd;
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
	 * @param ediRcvId
	 */
	public void setEdiRcvId(String ediRcvId) {
		this.ediRcvId = ediRcvId;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * kind
	 * @param kind
	 */
	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}

	/**
	 * Column Info
	 * @param ediId
	 */
	public void setFlatFiles(String flatFiles) {
		this.flatFiles = flatFiles;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBracCd(JSPUtil.getParameter(request, "brac_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEdiRcvId(JSPUtil.getParameter(request, "edi_rcv_id", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKindCd(JSPUtil.getParameter(request, "kind_cd", ""));
		setFlatFiles(JSPUtil.getParameter(request, "flat_files", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TmnlRcvIdVO[]
	 */
	public TmnlRcvIdTmpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TmnlRcvIdVO[]
	 */
	public TmnlRcvIdTmpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TmnlRcvIdTmpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bracCd = (JSPUtil.getParameter(request, prefix	+ "brac_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediRcvId = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] kindCd = (JSPUtil.getParameter(request, prefix	+ "kind_cd", length));
			String[] flatFiles = (JSPUtil.getParameter(request, prefix	+ "flat_files", length));
			
			for (int i = 0; i < length; i++) {
				model = new TmnlRcvIdTmpVO();
				if (bracCd[i] != null)
					model.setBracCd(bracCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediRcvId[i] != null)
					model.setEdiRcvId(ediRcvId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (kindCd[i] != null)
					model.setKindCd(kindCd[i]);
				if (flatFiles[i] != null)
					model.setFlatFiles(flatFiles[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTmnlRcvIdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TmnlRcvIdVO[]
	 */
	public TmnlRcvIdTmpVO[] getTmnlRcvIdVOs(){
		TmnlRcvIdTmpVO[] vos = (TmnlRcvIdTmpVO[])models.toArray(new TmnlRcvIdTmpVO[models.size()]);
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
		this.bracCd = this.bracCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvId = this.ediRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindCd = this.kindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFiles = this.flatFiles .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
