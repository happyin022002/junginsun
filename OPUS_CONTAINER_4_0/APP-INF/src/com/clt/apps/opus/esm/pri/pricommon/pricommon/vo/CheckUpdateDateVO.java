/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CheckUpdateDateVO.java
*@FileTitle : CheckUpdateDateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.12
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.08.12 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.pricommon.pricommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CheckUpdateDateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CheckUpdateDateVO> models = new ArrayList<CheckUpdateDateVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String key4 = null;
	/* Column Info */
	private String key3 = null;
	/* Column Info */
	private String pageName = null;
	/* Column Info */
	private String key6 = null;
	/* Column Info */
	private String key5 = null;
	/* Column Info */
	private String key2 = null;
	/* Column Info */
	private String key1 = null;
	/* Column Info */
	private String key10 = null;
	/* Column Info */
	private String key8 = null;
	/* Column Info */
	private String key7 = null;
	/* Column Info */
	private String key9 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tableName = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CheckUpdateDateVO() {}

	public CheckUpdateDateVO(String ibflag, String pagerows, String updDt, String updUsrId, String updUsrNm, String tableName, String key1, String key2, String key3, String key4, String key5, String key6, String key7, String key8, String key9, String key10, String pageName) {
		this.updDt = updDt;
		this.key4 = key4;
		this.key3 = key3;
		this.pageName = pageName;
		this.key6 = key6;
		this.key5 = key5;
		this.key2 = key2;
		this.key1 = key1;
		this.key10 = key10;
		this.key8 = key8;
		this.key7 = key7;
		this.key9 = key9;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.tableName = tableName;
		this.updUsrNm = updUsrNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("key4", getKey4());
		this.hashColumns.put("key3", getKey3());
		this.hashColumns.put("page_name", getPageName());
		this.hashColumns.put("key6", getKey6());
		this.hashColumns.put("key5", getKey5());
		this.hashColumns.put("key2", getKey2());
		this.hashColumns.put("key1", getKey1());
		this.hashColumns.put("key10", getKey10());
		this.hashColumns.put("key8", getKey8());
		this.hashColumns.put("key7", getKey7());
		this.hashColumns.put("key9", getKey9());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("table_name", getTableName());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("key4", "key4");
		this.hashFields.put("key3", "key3");
		this.hashFields.put("page_name", "pageName");
		this.hashFields.put("key6", "key6");
		this.hashFields.put("key5", "key5");
		this.hashFields.put("key2", "key2");
		this.hashFields.put("key1", "key1");
		this.hashFields.put("key10", "key10");
		this.hashFields.put("key8", "key8");
		this.hashFields.put("key7", "key7");
		this.hashFields.put("key9", "key9");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("table_name", "tableName");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return key4
	 */
	public String getKey4() {
		return this.key4;
	}
	
	/**
	 * Column Info
	 * @return key3
	 */
	public String getKey3() {
		return this.key3;
	}
	
	/**
	 * Column Info
	 * @return pageName
	 */
	public String getPageName() {
		return this.pageName;
	}
	
	/**
	 * Column Info
	 * @return key6
	 */
	public String getKey6() {
		return this.key6;
	}
	
	/**
	 * Column Info
	 * @return key5
	 */
	public String getKey5() {
		return this.key5;
	}
	
	/**
	 * Column Info
	 * @return key2
	 */
	public String getKey2() {
		return this.key2;
	}
	
	/**
	 * Column Info
	 * @return key1
	 */
	public String getKey1() {
		return this.key1;
	}
	
	/**
	 * Column Info
	 * @return key10
	 */
	public String getKey10() {
		return this.key10;
	}
	
	/**
	 * Column Info
	 * @return key8
	 */
	public String getKey8() {
		return this.key8;
	}
	
	/**
	 * Column Info
	 * @return key7
	 */
	public String getKey7() {
		return this.key7;
	}
	
	/**
	 * Column Info
	 * @return key9
	 */
	public String getKey9() {
		return this.key9;
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
	 * @return tableName
	 */
	public String getTableName() {
		return this.tableName;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param key4
	 */
	public void setKey4(String key4) {
		this.key4 = key4;
	}
	
	/**
	 * Column Info
	 * @param key3
	 */
	public void setKey3(String key3) {
		this.key3 = key3;
	}
	
	/**
	 * Column Info
	 * @param pageName
	 */
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	/**
	 * Column Info
	 * @param key6
	 */
	public void setKey6(String key6) {
		this.key6 = key6;
	}
	
	/**
	 * Column Info
	 * @param key5
	 */
	public void setKey5(String key5) {
		this.key5 = key5;
	}
	
	/**
	 * Column Info
	 * @param key2
	 */
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	
	/**
	 * Column Info
	 * @param key1
	 */
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	
	/**
	 * Column Info
	 * @param key10
	 */
	public void setKey10(String key10) {
		this.key10 = key10;
	}
	
	/**
	 * Column Info
	 * @param key8
	 */
	public void setKey8(String key8) {
		this.key8 = key8;
	}
	
	/**
	 * Column Info
	 * @param key7
	 */
	public void setKey7(String key7) {
		this.key7 = key7;
	}
	
	/**
	 * Column Info
	 * @param key9
	 */
	public void setKey9(String key9) {
		this.key9 = key9;
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
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setKey4(JSPUtil.getParameter(request, prefix + "key4", ""));
		setKey3(JSPUtil.getParameter(request, prefix + "key3", ""));
		setPageName(JSPUtil.getParameter(request, prefix + "page_name", ""));
		setKey6(JSPUtil.getParameter(request, prefix + "key6", ""));
		setKey5(JSPUtil.getParameter(request, prefix + "key5", ""));
		setKey2(JSPUtil.getParameter(request, prefix + "key2", ""));
		setKey1(JSPUtil.getParameter(request, prefix + "key1", ""));
		setKey10(JSPUtil.getParameter(request, prefix + "key10", ""));
		setKey8(JSPUtil.getParameter(request, prefix + "key8", ""));
		setKey7(JSPUtil.getParameter(request, prefix + "key7", ""));
		setKey9(JSPUtil.getParameter(request, prefix + "key9", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTableName(JSPUtil.getParameter(request, prefix + "table_name", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CheckUpdateDateVO[]
	 */
	public CheckUpdateDateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CheckUpdateDateVO[]
	 */
	public CheckUpdateDateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CheckUpdateDateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] key4 = (JSPUtil.getParameter(request, prefix	+ "key4", length));
			String[] key3 = (JSPUtil.getParameter(request, prefix	+ "key3", length));
			String[] pageName = (JSPUtil.getParameter(request, prefix	+ "page_name", length));
			String[] key6 = (JSPUtil.getParameter(request, prefix	+ "key6", length));
			String[] key5 = (JSPUtil.getParameter(request, prefix	+ "key5", length));
			String[] key2 = (JSPUtil.getParameter(request, prefix	+ "key2", length));
			String[] key1 = (JSPUtil.getParameter(request, prefix	+ "key1", length));
			String[] key10 = (JSPUtil.getParameter(request, prefix	+ "key10", length));
			String[] key8 = (JSPUtil.getParameter(request, prefix	+ "key8", length));
			String[] key7 = (JSPUtil.getParameter(request, prefix	+ "key7", length));
			String[] key9 = (JSPUtil.getParameter(request, prefix	+ "key9", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tableName = (JSPUtil.getParameter(request, prefix	+ "table_name", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CheckUpdateDateVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (key4[i] != null)
					model.setKey4(key4[i]);
				if (key3[i] != null)
					model.setKey3(key3[i]);
				if (pageName[i] != null)
					model.setPageName(pageName[i]);
				if (key6[i] != null)
					model.setKey6(key6[i]);
				if (key5[i] != null)
					model.setKey5(key5[i]);
				if (key2[i] != null)
					model.setKey2(key2[i]);
				if (key1[i] != null)
					model.setKey1(key1[i]);
				if (key10[i] != null)
					model.setKey10(key10[i]);
				if (key8[i] != null)
					model.setKey8(key8[i]);
				if (key7[i] != null)
					model.setKey7(key7[i]);
				if (key9[i] != null)
					model.setKey9(key9[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tableName[i] != null)
					model.setTableName(tableName[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCheckUpdateDateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CheckUpdateDateVO[]
	 */
	public CheckUpdateDateVO[] getCheckUpdateDateVOs(){
		CheckUpdateDateVO[] vos = (CheckUpdateDateVO[])models.toArray(new CheckUpdateDateVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key4 = this.key4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key3 = this.key3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageName = this.pageName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key6 = this.key6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key5 = this.key5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key2 = this.key2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key1 = this.key1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key10 = this.key10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key8 = this.key8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key7 = this.key7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key9 = this.key9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tableName = this.tableName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
