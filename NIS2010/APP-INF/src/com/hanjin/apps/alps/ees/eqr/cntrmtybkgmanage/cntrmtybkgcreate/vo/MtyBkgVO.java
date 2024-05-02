/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MtyBkgVO.java
*@FileTitle : MtyBkgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.09.04 신용찬 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo;

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
 * @author 신용찬
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyBkgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyBkgVO> models = new ArrayList<MtyBkgVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyBkgNo = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String usrId = null;
	
	private EesEqr1018MultiVO eesEqr1018MultiVO = null;	

	public EesEqr1018MultiVO getEesEqr1018MultiVO() {
		return eesEqr1018MultiVO;
	}

	public void setEesEqr1018MultiVO(EesEqr1018MultiVO eesEqr1018MultiVO) {
		this.eesEqr1018MultiVO = eesEqr1018MultiVO;
	}



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyBkgVO() {}

	public MtyBkgVO(String ibflag, String pagerows, String mtyBkgNo, String usrId, String gubun, String[] table_name, String splitFlg) {
		this.mtyBkgNo = mtyBkgNo;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.pagerows = pagerows;
		this.splitFlg = splitFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mty_bkg_no", getMtyBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("splitFlg", getSplitFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mty_bkg_no", "mtyBkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("splitFlg", "splitFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mtyBkgNo
	 */
	public String getMtyBkgNo() {
		return this.mtyBkgNo;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @param mtyBkgNo
	 */
	public void setMtyBkgNo(String mtyBkgNo) {
		this.mtyBkgNo = mtyBkgNo;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMtyBkgNo(JSPUtil.getParameter(request, "mty_bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setSplitFlg(JSPUtil.getParameter(request, "splitFlg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyBkgVO[]
	 */
	public MtyBkgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyBkgVO[]
	 */
	public MtyBkgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyBkgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mtyBkgNo = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "splitFlg", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyBkgVO();
				if (mtyBkgNo[i] != null)
					model.setMtyBkgNo(mtyBkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyBkgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyBkgVO[]
	 */
	public MtyBkgVO[] getMtyBkgVOs(){
		MtyBkgVO[] vos = (MtyBkgVO[])models.toArray(new MtyBkgVO[models.size()]);
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
		this.mtyBkgNo = this.mtyBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
