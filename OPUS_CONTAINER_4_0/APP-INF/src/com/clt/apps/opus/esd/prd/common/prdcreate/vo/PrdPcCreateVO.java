/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdPcCreateVO.java
*@FileTitle : PrdPcCreateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 정선용
*@LastVersion : 1.0 
* 2009.08.24 정선용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.prd.common.prdcreate.vo;

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
 * @author 정선용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdPcCreateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdPcCreateVO> models = new ArrayList<PrdPcCreateVO>();
	
	/* Column Info */
	private String hdPctlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pcRtnStr = null;
	/* Page Number */
	private String pagerows = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	private String minPctlNo;

	private String maxPctlNo;

	private String skdType;
	
	private String skdDate;

	private String obTroFlg;

	private String ibTroFlg;
	
	
	public PrdPcCreateVO() {}

	public PrdPcCreateVO(String ibflag, String pagerows, String hdPctlNo, String pcRtnStr, String minPctlNo, String maxPctlNo,String skdType, String skdDate, String obTroFlg, String ibTroFlg) {
		this.hdPctlNo = hdPctlNo;
		this.ibflag = ibflag;
		this.pcRtnStr = pcRtnStr;
		this.pagerows = pagerows;
		this.minPctlNo = minPctlNo;
		this.maxPctlNo = maxPctlNo;
		this.skdType = skdType;
		this.skdDate = skdDate;
		this.obTroFlg = obTroFlg;
		this.ibTroFlg = ibTroFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hd_pctl_no", getHdPctlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pc_rtn_str", getPcRtnStr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("min_pctl_no", getMinPctlNo());
		this.hashColumns.put("max_pctl_no", getMaxPctlNo());
		this.hashColumns.put("skd_type", getSkdType());
		this.hashColumns.put("skd_date", getSkdDate());
		this.hashColumns.put("ob_tro_flg", getObTroFlg());
		this.hashColumns.put("ib_tro_flg", getIbTroFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hd_pctl_no", "hdPctlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pc_rtn_str", "pcRtnStr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("min_pctl_no", "minPctlNo");
		this.hashFields.put("max_pctl_no", "maxPctlNo");
		this.hashFields.put("skd_type", "skdType");
		this.hashFields.put("skd_date", "skdDate");
		this.hashFields.put("ob_tro_flg", "obTroFlg");
		this.hashFields.put("ib_tro_flg", "ibTroFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hdPctlNo
	 */
	public String getHdPctlNo() {
		return this.hdPctlNo;
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
	 * @return pcRtnStr
	 */
	public String getPcRtnStr() {
		return this.pcRtnStr;
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
	 * @param hdPctlNo
	 */
	public void setHdPctlNo(String hdPctlNo) {
		this.hdPctlNo = hdPctlNo;
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
	 * @param pcRtnStr
	 */
	public void setPcRtnStr(String pcRtnStr) {
		this.pcRtnStr = pcRtnStr;
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
		setHdPctlNo(JSPUtil.getParameter(request, "hd_pctl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPcRtnStr(JSPUtil.getParameter(request, "pc_rtn_str", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		
		setMinPctlNo (JSPUtil.getParameter(request, "min_pctl_no", ""));
		setMaxPctlNo (JSPUtil.getParameter(request, "max_pctl_no", ""));
		setSkdType (JSPUtil.getParameter(request, "skd_type", ""));
		setSkdDate (JSPUtil.getParameter(request, "skd_date", ""));

		setObTroFlg (JSPUtil.getParameter(request, "ob_tro_flg", ""));
		setIbTroFlg (JSPUtil.getParameter(request, "ib_tro_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdPcCreateVO[]
	 */
	public PrdPcCreateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdPcCreateVO[]
	 */
	public PrdPcCreateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdPcCreateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hdPctlNo = (JSPUtil.getParameter(request, prefix	+ "hd_pctl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pcRtnStr = (JSPUtil.getParameter(request, prefix	+ "pc_rtn_str", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] minPctlNo = (JSPUtil.getParameter(request, prefix	+ "min_pctl_no", length));
			String[] maxPctlNo = (JSPUtil.getParameter(request, prefix	+ "max_pctl_no", length));			
			String[] skdType = (JSPUtil.getParameter(request, prefix	+ "skd_type", length));
			String[] skdDate = (JSPUtil.getParameter(request, prefix	+ "skd_date", length));	
			String[] obTroFlg = (JSPUtil.getParameter(request, prefix	+ "ob_tro_flg", length));	
			String[] ibTroFlg = (JSPUtil.getParameter(request, prefix	+ "ib_tro_flg", length));	
			
			for (int i = 0; i < length; i++) {
				model = new PrdPcCreateVO();
				if (hdPctlNo[i] != null)
					model.setHdPctlNo(hdPctlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pcRtnStr[i] != null)
					model.setPcRtnStr(pcRtnStr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (minPctlNo[i] != null)
					model.setMinPctlNo(minPctlNo[i]);	
				if (maxPctlNo[i] != null)
					model.setMaxPctlNo(maxPctlNo[i]);	
				if (skdType[i] != null)
					model.setSkdType(skdType[i]);		
				if (skdDate[i] != null)
					model.setSkdDate(skdDate[i]);				
				if (obTroFlg[i] != null)
					model.setObTroFlg(obTroFlg[i]);				
				if (ibTroFlg[i] != null)
					model.setIbTroFlg(ibTroFlg[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdPcCreateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdPcCreateVO[]
	 */
	public PrdPcCreateVO[] getPrdPcCreateVOs(){
		PrdPcCreateVO[] vos = (PrdPcCreateVO[])models.toArray(new PrdPcCreateVO[models.size()]);
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
		this.hdPctlNo = this.hdPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcRtnStr = this.pcRtnStr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minPctlNo = this.minPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxPctlNo = this.maxPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdType = this.skdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDate = this.skdDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTroFlg = this.obTroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTroFlg = this.ibTroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
				
	}

	public void setMinPctlNo(String minPctlNo) {
		this.minPctlNo = minPctlNo;
		
	}

	public String getMinPctlNo() {
		return minPctlNo;
	}

	public void setMaxPctlNo(String maxPctlNo) {
		this.maxPctlNo = maxPctlNo;
		
	}

	public String getMaxPctlNo() {
		return maxPctlNo;
	}

	public void setSkdType(String skdType) {
		this.skdType = skdType;
	}

	public String getSkdType() {
		return skdType;
	}
	
	public void setSkdDate(String skdDate) {
		this.skdDate = skdDate;
	}
	
	public String getSkdDate() {
		return skdDate;
	}
	
	public void setObTroFlg(String obTroFlg) {
		this.obTroFlg = obTroFlg;
	}
	
	public String getObTroFlg() {
		return obTroFlg;
	}
	
	public void setIbTroFlg(String ibTroFlg) {
		this.ibTroFlg = ibTroFlg;
	}
	
	public String getIbTroFlg() {
		return ibTroFlg;
	}
 
	
}
