/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeUtilBC.java
*@FileTitle : 코드 성격의 데이터를 가져오는 Util BC interface
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-02
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-10-02 Seong-mun Kang
* 1.0 최초 생성
* 2009-04-06 Jeong-seon An [N200903200140]   [SCEM] COP Healer 로직 보완:OB_ITCHG_CTNT,IB_ITCHG_CTNT 컬럼 modify
* 2011-07-04 채창호 [CHM-201111830]:Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2011-07-07 채창호 [CHM-201111381-01]: Dwell Notification Management 신규개발 요청.
* 2012-04-27 채창호 [CHM-201217464-01]:SCEM(Customer EDI) upgrade project 관련 화면 수정 요청(1)
=========================================================*/
 
package com.hanjin.apps.alps.esd.sce.common.util.basic;


import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * 코드 성격의 데이터를 가져오는 Util BC interface
 * 
 * @author Seong-mun Kang
 * @see CodeUtilBCImpl.java
 * @since J2EE 1.4
 */

public interface CodeUtilBC {

	/**
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @param String orderByField
	 * @param String options
	 * @param String addOption
	 * @return String
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, String valueField, 
							   String textField, String orderByField, String options, String addOption)
								throws EventException;
	
	
	/**
	 * 코드명을 가져온다.
	 * 
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String code
	 * @return String
	 * @throws EventException
	 */
	public String searchCodeName(String table, String codeField, String nameField, String code)
								throws EventException;
	
	

	
	/**
	 * 코드/코드명 리스트를 String으로 가져온다.
	 * 
	 * @param String dist
	 * @param String sltcd
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String whereField
	 * @return String
	 * @throws EventException
	 */
	public String searchCodeNameListString(String dist, String sltcd, String table, String codeField, String nameField, String whereField)
								throws EventException;
	
	/**
     * 
     * @param String selectName
     * @param String table
     * @param String valueField
     * @param String textField
     * @param String whereField
     * @param String orderByField
     * @param String options
     * @param String addOption
     * @return String
     * @throws EventException
     */
    public String searchCodeCombo(String selectName, String table, String valueField, 
                               String textField, String whereField, String orderByField, String options, String addOption)
                                throws EventException;
    
    /**
     * 
     * @param String selectName
     * @param String table
     * @param String valueField
     * @param String textField
     * @param String whereField
     * @param String orderByField
     * @param String options
     * @param String addOption
     * @return String
     * @throws EventException
     */
    public String searchCodeComboActual(String selectName, String table, String valueField, 
            String textField, String whereField, String orderByField, String options, String addOption)
             throws EventException;
    
   
    /**
     * 
     * @param String variable
     * @param String table
     * @param String valueField
     * @param String textField
     * @param String whereField 
     * @param String orderByField
     * @return String
     * @throws EventException
     */
	public String searchCodeComboSheet(String variable, String table, String valueField, String textField, 
									String whereField, String orderByField) throws EventException ;

	/**
	 * 코드명 리스트를 js 변수로 저장해서 가져온다.<br>
	 * 
	 * @param boolean codeIdxFlg
	 * @param String variable
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String whereField
	 * @return String
	 * @throws EventException<br>
	 */
	public String searchCodeNameListJsArray(boolean codeIdxFlg, String variable, String table, String codeField, String 
											nameField, String whereField) throws EventException ;
	
	

    /**
     * COP History Setting;<br>
     * @param String cop_no
     * @param String event_cd
     * @param String ofc_cd
     * @param String usr_id
     * @param String cmmt_yn
     * @return String
     * @throws EventException
     */
	public String  addSceCopHistory(String cop_no, String event_cd, String ofc_cd, String usr_id, String cmmt_yn) throws EventException;
	
//	/** ExptMst 테이블 cancel 
//	 * Replan 시 Expt 지우고 재 생성 하기 위함. yjlee 20080728
//	 * @param copNo
//	 * @param usrId
//	 * @return
//	 * @throws DAOException
//	 */
//	public int modifyExptMst(String copNo, String usrId) throws DAOException;	
	
	/**
	 * S/C No prefix List 콤보를 조회합니다.<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchScPrefixList() throws EventException;
	
	/**
	 * * Sting문자를 입력받아 ","구분자로 잘라 List의 형태로 반환..<br>
	 * 
	 * @param str String
	 * @return List<String>
	 */

	public List<String> replaceStrToList(String str) throws EventException;
	
	/**
	 * Sting문자를 입력받아 ","구분자로 자르고 해당 문자를 ''로 감싼 형태로 다시 반환.
	 * 
	 * @param str String
	 * @return String
	 */
	public String convertStr(String str) throws EventException;
	
//	/** SCE_COP_HDR 테이블 modify 
//	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
//	 * @param copNo
//	 * @throws EventException
//	 */
//	public void modifyItchgCtnt(String copNo) throws EventException;
//	
//	/** SCE_COP_HDR 테이블 modify 
//	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
//	 * @param soOfc
//	 * @param soSeq
//	 * @throws EventException
//	 */
//	public void modifyItchgCtnt(String soOfc, String soSeq) throws EventException;
	
//	/** SCE_COP_HDR 테이블 modify 
//	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
//	 * @param rcvDt
//	 * @param rcvNo
//	 * @throws EventException
//	 */
//	public void modifyItchgCtntBkgIf(String rcvDt, String rcvNo) throws EventException;
	
	/** Exception 판별 로직
	 *  MVMT 대상으로 Actual Delay판별 
	 *  SCE_EXCEPTION_RESIST_ACT_PRC 안에 로직 다 있으므로 prc call하는 method. 
	 *  Replan 시 Expt 지우고 재 생성 하기 위함. yjlee 20080728
	 * @param copNo
	 * @param usrId
	 * @return
	 * @throws DAOException
	 */
//	public String setCopExptResistAct(String copNo, String userId, String cmmt_yn)  throws DAOException;

	/**
	 * @param ofc_cd
	 * @return
	 * @throws DAOException
	 */
	public int searchOfcInfo(String ofc_cd) throws DAOException;
	
}
