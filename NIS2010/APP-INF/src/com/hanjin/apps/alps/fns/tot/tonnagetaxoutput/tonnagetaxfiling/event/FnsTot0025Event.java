/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsTot0025Event.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.11.25 이병훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * FNS_TOT_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_TOT_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byoung Hun
 * @see FNS_TOT_0025HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsTot0025Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Period */
	private String year = null;
	
	public FnsTot0025Event(){}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

}