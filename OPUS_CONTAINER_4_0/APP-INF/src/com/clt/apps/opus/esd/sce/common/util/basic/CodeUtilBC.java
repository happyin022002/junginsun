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
* 2009-04-06 Jeong-seon An [N200903200140]   [SCEM] COP Header 로직 보완:OB_ITCHG_CTNT,IB_ITCHG_CTNT 컬럼 modify
=========================================================*/
 
package com.clt.apps.opus.esd.sce.common.util.basic;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

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
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @param String orderByField
	 * @return String
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, String valueField, 
							   String textField, String orderByField)
								throws EventException;
	
	
	/**
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @param String orderByField
	 * @param String options
	 * @return String
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, String valueField, 
							   String textField, String orderByField, String options)
								throws EventException;
	
	/**
	 * 
	 * @param String selectName
	 * @param String table
	 * @param String valueField
	 * @param String textField
	 * @return String
	 * @throws EventException
	 */
	public String searchCodeCombo(String selectName, String table, String valueField, 
							   String textField)
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
	 * 코드/코드명 리스트를 가져온다.
	 * 
	 * @param String table
	 * @param String codeField
	 * @param String nameField
	 * @param String whereField
	 * @return String whereField
	 * @throws EventException
	 */
	public RequestDataSetBC searchCodeNameList(String table, String codeField, String nameField, String whereField)
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ComVvdManagementVO	comVvdManagementVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
//	public List<CodeUtilVO> searchCodeNameListString(CodeUtilVO codeUtilVO) throws EventException;
	
	/**
	 * 코드/코드명 리스트를 String으로 가져온다&&&.
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
	public String searchCodeNameListContents(String dist, String sltcd, String table, String codeField, String nameField, String whereField)
								throws EventException;		
	/**
	 * 공통코드의 코드/코드명 리스트을 가져온다.
	 * 
	 * @param String subCode
	 * @return RequestDataSetBC
	 * @throws EventException
	 */
	//public RequestDataSetBC searchCommonCodeNameList(String subCode) throws EventException ;
	
	
	/**
	 * 공통코드의 코드/코드명 리스트을 가져온다.<p>
	 * 
	 * @param RequestDataSetBC codeList
	 * @param String code
	 * @return String
	 * @throws EventException<br>
	 */
	public String searchCommonCodeName(RequestDataSetBC codeList, String code) throws EventException  ;
	
	
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
    public String searchCodeComboRail(String selectName, String table, String valueField, 
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
	 * COP 변경시 COA batch 요건에 따라 sce_bkg_if에 업데이트 치는 것.
	 * @param map
	 * @throws EventException
	 */
	//public void modifyBkgIf( HashMap map ) throws EventException;
	
	
	/**
	 * @param inbkg_no
	 * @param inbkg_no_split
	 * @param in_con
	 * @throws EventException
	 */
	//public void modifyRailChk( String inbkg_no, String inbkg_no_split, Connection in_con ) throws EventException;
	
	/**
	 * @param incop_no
	 * @param in_con
	 * @throws EventException
	 */
	//public void modifyRailChk( String incop_no, Connection in_con ) throws EventException;
	
	/**
	 * @param cop_no
	 * @param unmatchedCode
	 * @param in_con
	 * @throws EventException
	 */
//	public void modifyUnmatchedReason( String cop_no, String unmatchedCode) throws EventException;	
	
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
	
	/** ExptMst 테이블 cancel 
	 * Replan 시 Expt 지우고 재 생성 하기 위함. yjlee 20080728
	 * @param String copNo
	 * @return int
	 * @throws DAOException
	 */
	public int cancelExptMst(String copNo) throws DAOException;	
	
	/** SCE_COP_HDR 테이블 modify 
	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
	 * @param copNo
	 * @throws EventException
	 */
	//public void modifyItchgCtnt(String copNo) throws EventException;
	
	/** SCE_COP_HDR 테이블 modify 
	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
	 * @param soOfc
	 * @param soSeq
	 * @throws EventException
	 */
	//public void modifyItchgCtnt(String soOfc, String soSeq) throws EventException;
	
	/** SCE_COP_HDR 테이블 modify 
	 * 2009-04-06 Jeong-seon An [N200903200140]관련; OB_ITCHG_CTNT&IB_ITCHG_CTNT컬럼 modify
	 * @param rcvDt
	 * @param rcvNo
	 * @throws EventException
	 */
	//public void modifyItchgCtntBkgIf(String rcvDt, String rcvNo) throws EventException;
	
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

	
}
