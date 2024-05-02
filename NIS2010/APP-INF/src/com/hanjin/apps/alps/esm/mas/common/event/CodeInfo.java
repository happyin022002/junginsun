/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: CodeInfo.java
*@FileTitle 	: 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-11-16 Park Eun Ju
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.event;


/**
 * 클래스 개요 : 코드 모델 Bean<p>
 * <p/> 작성일 : 2006.<p>
 * 
 * @author 
 * @see
 * @since
 */
public class CodeInfo implements java.io.Serializable, Comparable {

	/**
	 * code 값
	 */
	private String code;

	/**
	 * sort key
	 */
	private String sortKey;

	/**
	 * code 명
	 */
	private String name;

	private String selected;
	
	private String flag;
	/**
	 * 1. 기능 : CodeInfo 생성자<p>
	 * 2. 처리개요 :<p>
	 *  - CodeInfo 객체를 생성<p>
	 * 3. 주의사항 :<p>
	 */
	public CodeInfo() {
		//
	}

	/**
	 * 1. 기능 : CodeInfo 생성자<p>
	 * 2. 처리개요 :<p>
	 *  - code값, code명을 받아 모델 setting<p>
	 * 3. 주의사항 :<p>
	 *
	 * @param sortKey
	 * @param code code 값
	 * @param name code 명
	 */
	public CodeInfo(String sortKey, String code, String name) {
		this.code = code;
		this.name = name;
		this.sortKey = sortKey;
	}
	
	/**
	 * 
	 * @param code
	 * @param name
	 * @param select
	 * @param flag
	 */
	public CodeInfo(String code, String name, String select, String flag){
		this.code = code;
		this.name = name;
		this.selected = select;
		this.flag = flag;
	}

	/**
	 * 1. 기능 : CodeInfo 생성자 <p>
	 * 2. 처리개요 :<p>
	 *  - code값, code명을 받아 모델 setting<p>
	 * 3. 주의사항 : <p>
	 * 
	 * @param code code 값
	 * @param name code 명
	 */
	public CodeInfo(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * 1. 기능 : code 값 return
	 * <p>
	 * 2. 처리개요 :
	 * <p>
	 * 3. 주의사항 :
	 * <p>
	 * 
	 * @return String code 값
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 1. 기능 : code 명 return<p>
	 * 2. 처리개요 : getter method <p>
	 * 3. 주의사항 : <p>
	 * 
	 * @return String code 명
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * key 값을 반환한다.
	 * @return
	 */
	public String getSortKey() {
		return sortKey;
	}

	/**
	 * option 중 디폴드 세팅 여부를 반환한다.
	 * [selected/ ]
	 * 
	 * @return
	 */
	public String getSelected(){
		return this.selected;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFlag(){
		return this.flag;
	}
	
	/**
	 * key 값을 세팅한다.
	 * @param sortKey
	 */
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	/**
	 * 구현 메소드
	 * @param  Object o
	 * @return int
	 */
	public int compareTo(Object o) {
		CodeInfo bean = (CodeInfo) o;
		//오름차순 정렬 
		return (this.sortKey.compareTo( bean.sortKey));
		
	}

	/**
	 * code를 세팅한다.
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * name을 세팅한다.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
