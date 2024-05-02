/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoteConversionBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2013.08.21 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.basic;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.NoteConversionGroupLocationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @see Esm_pri_4005EventResponse 참조
 * @since J2EE 1.4
 */

public interface NoteConversionBC {
	
	/**
	 * 조회 이벤트 처리<br>
	 *  NoteConversionGroupLocation화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param NoteConversionGroupLocationVO noteConversionGroupLocationVO
	 * @return NoteConversionGroupLocationVO
	 * @exception EventException
	 */
	public NoteConversionGroupLocationVO searchGroupLocationList(NoteConversionGroupLocationVO noteConversionGroupLocationVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param NoteConversionGroupLocationVO noteConversionGroupLocationVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageGroupLocation(NoteConversionGroupLocationVO noteConversionGroupLocationVO, SignOnUserAccount account) throws EventException;
}