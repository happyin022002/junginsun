/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaIgmVslVO.java
*@FileTitle : IndiaIgmVslVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.01 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaIgmVslVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaIgmVslVO> models = new ArrayList<IndiaIgmVslVO>();
	
	/* Column Info */
	private String genDt = null;
	/* Column Info */
	private String otrDchgCd = null;
	/* Column Info */
	private String idaAgnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaIgmVslVO() {}

	public IndiaIgmVslVO(String ibflag, String pagerows, String idaAgnId, String otrDchgCd, String genDt) {
		this.genDt = genDt;
		this.otrDchgCd = otrDchgCd;
		this.idaAgnId = idaAgnId;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gen_dt", getGenDt());
		this.hashColumns.put("otr_dchg_cd", getOtrDchgCd());
		this.hashColumns.put("ida_agn_id", getIdaAgnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gen_dt", "genDt");
		this.hashFields.put("otr_dchg_cd", "otrDchgCd");
		this.hashFields.put("ida_agn_id", "idaAgnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return genDt
	 */
	public String getGenDt() {
		return this.genDt;
	}
	
	/**
	 * Column Info
	 * @return otrDchgCd
	 */
	public String getOtrDchgCd() {
		return this.otrDchgCd;
	}
	
	/**
	 * Column Info
	 * @return idaAgnId
	 */
	public String getIdaAgnId() {
		return this.idaAgnId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param genDt
	 */
	public void setGenDt(String genDt) {
		this.genDt = genDt;
	}
	
	/**
	 * Column Info
	 * @param otrDchgCd
	 */
	public void setOtrDchgCd(String otrDchgCd) {
		this.otrDchgCd = otrDchgCd;
	}
	
	/**
	 * Column Info
	 * @param idaAgnId
	 */
	public void setIdaAgnId(String idaAgnId) {
		this.idaAgnId = idaAgnId;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setGenDt(JSPUtil.getParameter(request, "gen_dt", ""));
		setOtrDchgCd(JSPUtil.getParameter(request, "otr_dchg_cd", ""));
		setIdaAgnId(JSPUtil.getParameter(request, "ida_agn_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaIgmVslVO[]
	 */
	public IndiaIgmVslVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaIgmVslVO[]
	 */
	public IndiaIgmVslVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaIgmVslVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] genDt = (JSPUtil.getParameter(request, prefix	+ "gen_dt", length));
			String[] otrDchgCd = (JSPUtil.getParameter(request, prefix	+ "otr_dchg_cd", length));
			String[] idaAgnId = (JSPUtil.getParameter(request, prefix	+ "ida_agn_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaIgmVslVO();
				if (genDt[i] != null)
					model.setGenDt(genDt[i]);
				if (otrDchgCd[i] != null)
					model.setOtrDchgCd(otrDchgCd[i]);
				if (idaAgnId[i] != null)
					model.setIdaAgnId(idaAgnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaIgmVslVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaIgmVslVO[]
	 */
	public IndiaIgmVslVO[] getIndiaIgmVslVOs(){
		IndiaIgmVslVO[] vos = (IndiaIgmVslVO[])models.toArray(new IndiaIgmVslVO[models.size()]);
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
		this.genDt = this.genDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrDchgCd = this.otrDchgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaAgnId = this.idaAgnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
