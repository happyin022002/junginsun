/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DiffList.java
*@FileTitle : DiffList
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.11.01 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.common.diff;

import java.util.ArrayList;
import java.util.List;
/**
 * NIS2010-Diff  - 두 글의 다른점을 비교한다.
 *
 * @author Minseok Song
 * @see 
 * @since J2EE 1.6
 */
public class DiffList{
	public static final Integer OPEN_TAG = new Integer(1);
	public static final Integer CLOSE_TAG = new Integer(2);
	public static final Integer OPEN_CHANGE_TAG = new Integer(3);
	public static final Integer CLOSE_CHANGE_TAG = new Integer(4);
	public static final Integer DATA = new Integer(5);
	public static final Integer CHANGE_DATA = new Integer(6);
	private List<String> oldLine = new ArrayList<String>();
	private List<String> newLine = new ArrayList<String>();
	private List<Integer> tag = new ArrayList<Integer>();
	/**
	 * DiffList 객체 생성<br>
	 * DiffList를 생성한다.<br>
	 */
	public DiffList(){
		
	}
	

    /**
     * 기존 문장, 바뀐 문장, 두 문장간의 비교 Tag를 쌍으로 하여 1 Line을 해당 Data 객체에 추가 한다.
     * 
     * @param String oldStr 기존 문장
     * @param String newStr 바뀐 문장
     * @param int tag 바뀐내용
     */	
	public void addLine(String oldStr,String newStr,int tag){
		oldLine.add(oldStr);
		newLine.add(newStr);
		this.tag.add(tag);
	}
	

    /**
     * idx에 해당하는 기존 문장을 return한다.
     * 
     * @param int idx 순서번호
     * @return String 기존 문장
     */
	public String getOldLine(int idx){
		return oldLine.get(idx);
	}

    /**
     * idx에 해당하는 새로운 문장을 return한다.
     * 
     * @param int idx 순서번호
     * @return String 새로운 문장
     */
	public String getNewLine(int idx){
		return newLine.get(idx);
	}

    /**
     * idx에 해당하는 Tag를 return한다.
     * 
     * @param int idx 순서번호
     * @return int Tag
     */
	public int getTag(int idx){
		return tag.get(idx);
	}

    /**
     * list의 총 갯수를 return
     * 
     * @return int 갯수
     */
	public int size(){
		return oldLine.size();
	}
}