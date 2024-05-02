/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreatorVO.java
*@FileTitle : CreatorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.06.11 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBizNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorBizNoVO> models = new ArrayList<KorBizNoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bizCustCd = null;
	/* Column Info */
	private String bizCntCd = null;
	/* Column Info */
	private String bizNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorBizNoVO() {}

	public KorBizNoVO(String ibflag, String pagerows, String bizCntCd, String bizCustCd, String bizNo) {
		this.ibflag = ibflag;
		this.bizCustCd = bizCustCd;
		this.bizCntCd = bizCntCd;
		this.bizNo = bizNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("biz_cust_cd", getBizCustCd());
		this.hashColumns.put("biz_cnt_cd", getBizCntCd());
		this.hashColumns.put("biz_no", getBizNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("biz_cust_cd", "bizCustCd");
		this.hashFields.put("biz_cnt_cd", "bizCntCd");
		this.hashFields.put("biz_no", "bizNo");
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
	 * @return bizCustCd
	 */
	public String getBizCustCd() {
		return this.bizCustCd;
	}
	
	/**
	 * Column Info
	 * @return bizCntCd
	 */
	public String getBizCntCd() {
		return this.bizCntCd;
	}
	
	/**
	 * Column Info
	 * @return bizNo
	 */
	public String getBizNo() {
		return this.bizNo;
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
	 * @param bizCustCd
	 */
	public void setBizCustCd(String bizCustCd) {
		this.bizCustCd = bizCustCd;
	}
	
	/**
	 * Column Info
	 * @param bizCntCd
	 */
	public void setBizCntCd(String bizCntCd) {
		this.bizCntCd = bizCntCd;
	}
	
	/**
	 * Column Info
	 * @param bizNo
	 */
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
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
		setBizCustCd(JSPUtil.getParameter(request, "biz_cust_cd", ""));
		setBizCntCd(JSPUtil.getParameter(request, "biz_cnt_cd", ""));
		setBizNo(JSPUtil.getParameter(request, "biz_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreatorVO[]
	 */
	public KorBizNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreatorVO[]
	 */
	public KorBizNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBizNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bizCustCd = (JSPUtil.getParameter(request, prefix	+ "biz_cust_cd", length));
			String[] bizCntCd = (JSPUtil.getParameter(request, prefix	+ "biz_cnt_cd", length));
			String[] bizNo = (JSPUtil.getParameter(request, prefix	+ "biz_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBizNoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bizCustCd[i] != null)
					model.setBizCustCd(bizCustCd[i]);
				if (bizCntCd[i] != null)
					model.setBizCntCd(bizCntCd[i]);
				if (bizNo[i] != null)
					model.setBizNo(bizNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreatorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreatorVO[]
	 */
	public KorBizNoVO[] getCreatorVOs(){
		KorBizNoVO[] vos = (KorBizNoVO[])models.toArray(new KorBizNoVO[models.size()]);
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
		this.bizCustCd = this.bizCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizCntCd = this.bizCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizNo = this.bizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
