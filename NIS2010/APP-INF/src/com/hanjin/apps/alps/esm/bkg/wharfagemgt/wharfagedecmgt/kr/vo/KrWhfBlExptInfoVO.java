/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfBlExptInfoVO.java
*@FileTitle : KrWhfBlExptInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.09.11 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfBlExptInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfBlExptInfoVO> models = new ArrayList<KrWhfBlExptInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String krWhfExptCd = null;
	/* Column Info */
	private String whfShprRgstNo = null;
	/* Column Info */
	private String krWhfExptApplFlg = null;
	/* Column Info */
	private String krWhfExptDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfBlExptInfoVO() {}

	public KrWhfBlExptInfoVO(String ibflag, String pagerows, String krWhfExptCd, String krWhfExptDesc, String krWhfExptApplFlg, String whfShprRgstNo) {
		this.ibflag = ibflag;
		this.krWhfExptCd = krWhfExptCd;
		this.whfShprRgstNo = whfShprRgstNo;
		this.krWhfExptApplFlg = krWhfExptApplFlg;
		this.krWhfExptDesc = krWhfExptDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("kr_whf_expt_cd", getKrWhfExptCd());
		this.hashColumns.put("whf_shpr_rgst_no", getWhfShprRgstNo());
		this.hashColumns.put("kr_whf_expt_appl_flg", getKrWhfExptApplFlg());
		this.hashColumns.put("kr_whf_expt_desc", getKrWhfExptDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kr_whf_expt_cd", "krWhfExptCd");
		this.hashFields.put("whf_shpr_rgst_no", "whfShprRgstNo");
		this.hashFields.put("kr_whf_expt_appl_flg", "krWhfExptApplFlg");
		this.hashFields.put("kr_whf_expt_desc", "krWhfExptDesc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return krWhfExptCd
	 */
	public String getKrWhfExptCd() {
		return this.krWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @return whfShprRgstNo
	 */
	public String getWhfShprRgstNo() {
		return this.whfShprRgstNo;
	}
	
	/**
	 * Column Info
	 * @return krWhfExptApplFlg
	 */
	public String getKrWhfExptApplFlg() {
		return this.krWhfExptApplFlg;
	}
	
	/**
	 * Column Info
	 * @return krWhfExptDesc
	 */
	public String getKrWhfExptDesc() {
		return this.krWhfExptDesc;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param krWhfExptCd
	 */
	public void setKrWhfExptCd(String krWhfExptCd) {
		this.krWhfExptCd = krWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @param whfShprRgstNo
	 */
	public void setWhfShprRgstNo(String whfShprRgstNo) {
		this.whfShprRgstNo = whfShprRgstNo;
	}
	
	/**
	 * Column Info
	 * @param krWhfExptApplFlg
	 */
	public void setKrWhfExptApplFlg(String krWhfExptApplFlg) {
		this.krWhfExptApplFlg = krWhfExptApplFlg;
	}
	
	/**
	 * Column Info
	 * @param krWhfExptDesc
	 */
	public void setKrWhfExptDesc(String krWhfExptDesc) {
		this.krWhfExptDesc = krWhfExptDesc;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKrWhfExptCd(JSPUtil.getParameter(request, "kr_whf_expt_cd", ""));
		setWhfShprRgstNo(JSPUtil.getParameter(request, "whf_shpr_rgst_no", ""));
		setKrWhfExptApplFlg(JSPUtil.getParameter(request, "kr_whf_expt_appl_flg", ""));
		setKrWhfExptDesc(JSPUtil.getParameter(request, "kr_whf_expt_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfBlExptInfoVO[]
	 */
	public KrWhfBlExptInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfBlExptInfoVO[]
	 */
	public KrWhfBlExptInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfBlExptInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] krWhfExptCd = (JSPUtil.getParameter(request, prefix	+ "kr_whf_expt_cd", length));
			String[] whfShprRgstNo = (JSPUtil.getParameter(request, prefix	+ "whf_shpr_rgst_no", length));
			String[] krWhfExptApplFlg = (JSPUtil.getParameter(request, prefix	+ "kr_whf_expt_appl_flg", length));
			String[] krWhfExptDesc = (JSPUtil.getParameter(request, prefix	+ "kr_whf_expt_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfBlExptInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (krWhfExptCd[i] != null)
					model.setKrWhfExptCd(krWhfExptCd[i]);
				if (whfShprRgstNo[i] != null)
					model.setWhfShprRgstNo(whfShprRgstNo[i]);
				if (krWhfExptApplFlg[i] != null)
					model.setKrWhfExptApplFlg(krWhfExptApplFlg[i]);
				if (krWhfExptDesc[i] != null)
					model.setKrWhfExptDesc(krWhfExptDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfBlExptInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfBlExptInfoVO[]
	 */
	public KrWhfBlExptInfoVO[] getKrWhfBlExptInfoVOs(){
		KrWhfBlExptInfoVO[] vos = (KrWhfBlExptInfoVO[])models.toArray(new KrWhfBlExptInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfExptCd = this.krWhfExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfShprRgstNo = this.whfShprRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfExptApplFlg = this.krWhfExptApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfExptDesc = this.krWhfExptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
