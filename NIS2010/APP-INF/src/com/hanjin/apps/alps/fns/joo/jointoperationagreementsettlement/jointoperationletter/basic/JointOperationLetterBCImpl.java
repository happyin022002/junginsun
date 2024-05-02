/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterBCImpl.java
*@FileTitle : MCS & Invoice Mail Address Select POP-UP
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.11 함대성
* 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.08 이준범 [CHM-201006731-01]
* 1. 대상 기능
*   - JO Member Information Creation(JOO_0066)
*   - Inquiry of JO Member Information(JOO_0067)
* 2. 보완 대상
*   - Revenue Lane 정보 반영 
*   - MS Office( Excel, Worl, Power Point등) 첨부
*   - Carrier Name등 컬럼 반영
* 2010.12.02 이준범 [CHM-201007349-01]
* 1. 보완 기능 
*   - JO Member Information Creation
*   - Inquiry of JO Member Information
* 2. 보완 요청 사항
*   - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration.JointOperationLetterDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration.JointOperationLetterEAIDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CarrierSeqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustCdNmVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.CustMemberVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvMcsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.InvoiceCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.JoTmpltNoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsCombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.McsLetterVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.PicOfUserInfoVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.TextNoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooCntcMbrVO;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooLetterVO;
import com.hanjin.syscommon.common.table.JooLtrTmpltVO;

/**
 * ALPS-JointOperationAgreementSettlement Business Logic Basic Command implementation<br>
 * - ALPS-JointOperationAgreementSettlement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0073EventResponse,JointOperationLetterBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class JointOperationLetterBCImpl extends BasicCommandSupport implements JointOperationLetterBC {

	// Database Access Object
	private transient JointOperationLetterDBDAO dbDao = null;

	/**
	 * JointOperationLetterBCImpl 객체 생성<br>
	 * JointOperationLetterDBDAO를 생성한다.<br>
	 */
	public JointOperationLetterBCImpl() {
		dbDao = new JointOperationLetterDBDAO();
	} 
	
	/**
	 * PersonInf 조회합니다.
	 * @param String car
	 * @return List<JooCntcMbrVO>
	 * @throws EventException
	 */
	public List<JooCntcMbrVO> searchPersonInfo(String car) throws EventException {
		try {
			return dbDao.searchPersonInfo(car);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"PersonInf", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"PersonInf", "Retrieve"}).getMessage(), ex);
        }
	}
	
	/**
	 *  Mail Address을 조회합니다.<br>
	 *  JointOperationLetter화면에 대한 조회 <br>
	 *  
	 * @param InvMcsLetterVO invMcsLetterVO
	 * @return List<InvMcsLetterVO>
	 * @exception EventException
	 */
	public List<InvMcsLetterVO> searchLetterSendList (InvMcsLetterVO  invMcsLetterVO ) throws EventException {
		try {
		    invMcsLetterVO.setFromDt(invMcsLetterVO.getFromDt().replace("-", ""));
		    invMcsLetterVO.setToDt(invMcsLetterVO.getToDt().replace("-", ""));
			return dbDao.searchLetterSendList(invMcsLetterVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Mail Address", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Mail Address", "Retrieve"}).getMessage(), ex);
        }
	}	
	
	/**
	 * 고객정보를 조회합니다.
	 * @param String car
	 * @return List<CustCdNmVO>
	 * @throws EventException
	 */
	public List<CustCdNmVO> searchCustCdNm(String car) throws EventException {
		try {
			return dbDao.searchCustCdNm(car);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Custormer Name", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Custormer Name", "Retrieve"}).getMessage(), ex);
        }
	}

	/**
	 * Carrier Seq를 조회합니다. 
	 * @param String car
	 * @param String customer
	 * @return List<CarrierSeqVO>
	 * @throws EventException
	 */
	public List<CarrierSeqVO> searchCarrierSeq(String car, String customer) throws EventException {
		try {
			return dbDao.searchCarrierSeq(car, customer);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"CarrierSeq ", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"CarrierSeq ", "Retrieve"}).getMessage(), ex);
        }
	}
	
	/**
	 * Member Info 조회합니다.<br>
	 * 
	 * @param CustMemberVO custMemberVO
	 * @return List<CustMemberVO>
	 * @exception EventException
	 */
	public List<CustMemberVO> searchMemberInfo(CustMemberVO custMemberVO) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			return dbDao.searchMemberInfo(custMemberVO); 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Member Info ", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Member Info ", "Retrieve"}).getMessage(), ex);
        }
	}
	
	/**
	 * CustCd Info를 조회합니다.<br>
	 * @param String custCntCd
	 * @param int custSeq 
	 * @return CustCdInfoVO  
	 * @exception EventException
	 */
	public CustCdInfoVO searchCustCdInfo(String custCntCd, int custSeq ) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			return dbDao.searchCustCdInfo(custCntCd, custSeq);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"CustCd Info", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"CustCd Info", "Retrieve"}).getMessage(), ex);
        }
	}
	
	/**
	 * Member Info를 저장합니다. <br>
	 * @param CustMemberVO[] custMemberVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void manageMemberInfo(CustMemberVO[] custMemberVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		
		try { 
			//List<CustMemberVO> insertVoList = new ArrayList<CustMemberVO>();
			//List<CustMemberVO> updateVoList = new ArrayList<CustMemberVO>();
			//List<CustMemberVO> deleteVoList = new ArrayList<CustMemberVO>();
			
			for (int inx=0; inx<custMemberVOs.length; inx++){
				if ("I".equals(custMemberVOs[inx].getIbflag())){
					custMemberVOs[inx].setUsrId(signOnUserAccount.getUsr_id());
					dbDao.addMemberInfo(custMemberVOs[inx]);
				}else if("U".equals(custMemberVOs[inx].getIbflag())){
					custMemberVOs[inx].setUsrId(signOnUserAccount.getUsr_id());
					dbDao.modifyMemberInfo(custMemberVOs[inx]);
				}else if("D".equals(custMemberVOs[inx].getIbflag())){
					custMemberVOs[inx].setUsrId(signOnUserAccount.getUsr_id());
					dbDao.removeMemberInfo(custMemberVOs[inx]);
				}
			}				

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Member Info", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Member Info", "Save"}).getMessage(), ex);
        }        
	}

	/**
	 * Carrier Member Info를 조회합니다.
     *
	 * @param String car
	 * @return List<JooCntcMbrVO>
	 * @exception EventException
	 */
	public List<JooCntcMbrVO> searchCarrierMemberInfo(String car) throws EventException {
		try {
			return dbDao.searchCarrierMemberInfo(car);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Member", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Carrier Member", "Retrieve"}).getMessage(), ex);
        }
	}
	
	
	/**
	 * MCS, Invoice TextNoLis 조회한다.
	 * @param String joLtrTpCd
     * @param String ofcCd
     * @param String userId
	 * @return List<JoTmpltNoVO>
	 * @throws EventException
	 */
	public List<JoTmpltNoVO> searchTempalteTextNoList(String joLtrTpCd, String ofcCd, String userId) throws EventException {
		try {
			return dbDao.searchTempalteTextNoList(joLtrTpCd, ofcCd, userId);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"TextNo", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"TextNo", "Retrieve"}).getMessage(), ex);
        }
	}
 
	
	/**
	 * Mcs, Invoice TempalteAddress 조회<br>
	 * @param String ofcCd
	 * @return JooLtrTmpltVO
	 * @exception EventException
	 */
	public JooLtrTmpltVO searchTempalteAddress( String ofcCd ) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			return dbDao.searchTempalteAddress(ofcCd);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template Address", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template Address", "Retrieve"}).getMessage(), ex);
        }
	}
	
	/**
     * Mcs, Invoice TempalteAddress 조회<br>
	 * @param String joLtrTpCd
     * @param String joTmpltNo
     * @param String ofcCd 
	 * @return JooLtrTmpltVO
	 * @exception EventException
	 */
	public JooLtrTmpltVO searchTemplate (String joLtrTpCd, String joTmpltNo, String ofcCd) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			return dbDao.searchTemplate(joLtrTpCd, ofcCd, joTmpltNo); 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template", "Retrieve"}).getMessage(), ex);
        }
	}
	
	
	
	/**
     * Mcs, Invoice TempalteAddress 생성<br>
	 * @param  JooLtrTmpltVO jooLtrTmpltVO 
	 * @param  String copy
	 * @param  SignOnUserAccount signOnUserAccount
	 * @return LetterVO
	 * @exception EventException
	 */
	public LetterVO createTemplate(JooLtrTmpltVO  jooLtrTmpltVO, String copy , SignOnUserAccount signOnUserAccount) throws EventException{
		try {
		    LetterVO  vo = new LetterVO();
			jooLtrTmpltVO .setCreUsrId(signOnUserAccount.getUsr_id());
			jooLtrTmpltVO .setUpdUsrId(signOnUserAccount.getUsr_id());
			jooLtrTmpltVO .setCreDt(signOnUserAccount.getCre_dt());
			jooLtrTmpltVO .setUpdDt(signOnUserAccount.getUpd_dt());
			
			String joTmpltNo = jooLtrTmpltVO .getJoTmpltNo()==""?"":jooLtrTmpltVO .getJoTmpltNo();
			
			if(!joTmpltNo.equals("") && !copy.equals("ok")){
				dbDao.modifyTemplate(jooLtrTmpltVO );
			}else{
 
			    vo.setOfcCd(     jooLtrTmpltVO.getOfcCd()      );
                vo.setCreUsrId(  jooLtrTmpltVO.getCreUsrId()      );
                vo.setJoLtrTpCd( jooLtrTmpltVO.getJoLtrTpCd()  );				    
                List<LetterVO> rstVO = dbDao.getNewTmpltSeqNo(vo);
 
                vo.setJoTmpltNo(      rstVO.get(0).getJoTmpltNo()        );
                vo.setJoLtrTmpltSeq(  rstVO.get(0).getJoLtrTmpltSeq()    );			    
 
                jooLtrTmpltVO.setJoTmpltNo( rstVO.get(0).getJoTmpltNo()    );
				dbDao.addTemplate(jooLtrTmpltVO ); 
			}
			return vo;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template", "Save"}).getMessage(), ex);
        }
	}
	
	/**
	 * 
     * Mcs, Invoice  삭제<br>
	 * @param String joLtrTpCd
	 * @param String joTmpltNo
     * @param String ofcCd
	 * @exception EventException
	 */
	public void removeTemplate (String joLtrTpCd, String joTmpltNo, String ofcCd) throws EventException{
	    
		// PDTO(Data Transfer Object including Parameters)
		
		try {
			dbDao.removeTemplate(joLtrTpCd, ofcCd, joTmpltNo); 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template", "Remove"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template", "Remove"}).getMessage(), ex);
        }
	}

    /**
     * 
     * [MCS & Invoice Letter Fax/E-mail Inquiry]을 [조회Retrieve]합니다.<br>
     * @param  String ofcCd
     * @param  String userId
     * @param  String fmDt
     * @param  String toDt
     * @throws EventException
     * @return List<LetterVO>
     * @author jang kang cheol
     */ 
    public List<LetterVO> searchLetterSendStsList(String ofcCd, String userId,
            String fmDt, String toDt) throws EventException {
        try {
            return dbDao.searchLetterSendStsList(  ofcCd,   userId, fmDt,  toDt);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Fax/Mail", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Fax/Mail", "Retrieve"}).getMessage(), ex);
        }
    }

    /**
     * 
     * [MCS Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     * @param LetterVO letterVO
     * @throws EventException
     * @return  List<TextNoVO>
     * @author jang kang cheol
     */
    public List<TextNoVO>  searchMcsTextNo(LetterVO letterVO ) throws EventException{
        try {
            return dbDao.searchMcsTextNo(  letterVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Text No", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Text No", "Retrieve"}).getMessage(), ex);
        }
    }
    
    /** 
     * 
     * D : [FnsJoo0060Event]<br>
     * [MCS Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @param  LetterVO[] letterVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @return LetterVO
     * @author jang kang cheol
     */
    public LetterVO manageMcsLetter( LetterVO letterVO, LetterVO[] letterVOs, SignOnUserAccount signOnUserAccount) throws EventException {

        String sJoLtrSeq = "";
        String sJoLtrNo  = "";
        try {
            String joltrseq = letterVO.getJoLtrSeq() ;
            
            /*********************KEY 처리 존재하면 삭제 처리***************************/
            if( !joltrseq.equals("") ){
                dbDao.removeLetterStl(letterVO);
                dbDao.removeLetterAttach(letterVO);        
                dbDao.removeLetter(letterVO);
   
            }
 
            
            String sUsrId = signOnUserAccount.getUsr_id();
            sJoLtrSeq = dbDao.searchJoLtrSeq();//LETTER SEQ 추출

            /***********************  Letter  Start ***************************/       
            LetterVO tmpletterVO = (LetterVO) letterVO.clone();
       
            tmpletterVO.setJoLtrSeq(  sJoLtrSeq );
            tmpletterVO.setCreUsrId(  sUsrId    );
            tmpletterVO.setUpdUsrId(  sUsrId    );     
            sJoLtrNo = dbDao.searchJoLtrNo(letterVO);
            tmpletterVO.setJoLtrNo(  sJoLtrNo );
            dbDao.addMcsLetter  (  tmpletterVO  );                
            /************************ Letter   End  ***************************/          
            
            
            /***********************  LetterStl Start *************************/        
            List<LetterVO> insertLetterStlList = new ArrayList<LetterVO>();

            for ( int i=0; i < letterVOs.length; i++ ) {
                letterVOs[i].setJoCrrCd( letterVO.getJoCrrCd() );                         
                letterVOs[i].setJoLtrSeq   ( sJoLtrSeq     );       
                letterVOs[i].setJoLtrStlSeq(  (i+1)+""     );                   
                letterVOs[i].setCreUsrId   (    sUsrId     );
                letterVOs[i].setUpdUsrId   (    sUsrId     );     
 
                insertLetterStlList.add(  letterVOs[i]   );
            }
            if ( insertLetterStlList.size() > 0 ) {                
                dbDao.addMcsLetterStl( insertLetterStlList);
            }
            /************************* LetterStl End ***********************/
            
            
            /***********************  LetterAttFile Start ***********************/
            List<LetterVO> insertLetterAtchFileList = new ArrayList<LetterVO>();
            LetterVO       letterAtchFile         = null;
            
            String[] attfilelist = null;
           // attfilelist = split( letterVO.getKeys(), ";");
            attfilelist =  letterVO.getKeys().split(";");
            if( !letterVO.getKeys().equals("") ){
                for(int i=0;i<attfilelist.length;i++){
                    letterAtchFile         =  new LetterVO();    
                    letterAtchFile.setJoLtrSeq(     sJoLtrSeq              );
                    letterAtchFile.setFileSavId(  attfilelist[i]  );     
                    
                    letterAtchFile.setCreUsrId(  sUsrId   );
                    letterAtchFile.setUpdUsrId(  sUsrId   );                    
                    insertLetterAtchFileList.add(letterAtchFile);
                }
            }
            if ( insertLetterAtchFileList.size() > 0 ) {                
                dbDao.addLetterAttach(  insertLetterAtchFileList);
            } 
 
            
            /*************************LetterAttFile End *******************/            
            return tmpletterVO;
        }catch(EventException ex){
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Mcs Info", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Mcs Info", "Save"}).getMessage(), ex);
        }
    }        
     
    /**
     * 
     * [MCS Letter Information Creation의 Text No]을 [조회 Retrieve]합니다.<br>
     *
     * @param  McsCombinedVO mcsCombinedVO
     * @throws EventException
     * @return List<McsCombinedVO> 
     * @author jang kang cheol
     */
    public List<McsCombinedVO> searchMcsCombined(McsCombinedVO mcsCombinedVO)
            throws EventException {
        try {
            return dbDao.searchMcsCombined( mcsCombinedVO );
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Mcs Combined", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Mcs Combined", "Retrieve"}).getMessage(), ex);
        }
          
    }
    /**
     * 
     * D : [FnsJoo0060Event]<br>
     * [MCS Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return List< McsLetterVO> 
     * @author jang kang cheol
     */
    public List<McsLetterVO> searchMcsLetter( LetterVO letterVO)
            throws EventException {
        try {
            return dbDao.searchMcsLetter(  letterVO );
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"McsLetter", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"McsLetter", "Retrieve"}).getMessage(), ex);
        }      
    }
    
    /**
     * 
     * D : [FnsJoo0060Event]<br>
     * [MCS Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO  letterVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void sendMcsLetter(LetterVO  letterVO) throws EventException {
        JointOperationLetterEAIDAO letterEAIDAO = new JointOperationLetterEAIDAO();

        try {
            List< LetterVO> letterVOs   = this.dbDao.searchComUserInfo(letterVO);
            if(letterVOs.size() > 0 ){
                letterVO.setContent(    letterVOs.get(0).getGreeting() );//Greeting
                letterVO.setUsrNm    (  letterVOs.get(0).getUsrNm()     );
                letterVO.setUsrEml   (  letterVOs.get(0).getUsrEml()    );
                letterVO.setJbEngNm  (  letterVOs.get(0).getJbEngNm()   );
                letterVO.setOfcCd    (  letterVOs.get(0).getOfcCd()     );
                letterVO.setXtnPhnNo (  letterVOs.get(0).getXtnPhnNo()  );
                letterVO.setFaxNo    (  letterVOs.get(0).getFaxNo()     );
            }
            if( letterVO.getSendType().equals("MAIL")){
                 String emlSndNo = letterEAIDAO.sendMcsLetterEmail(letterVO);
                 letterVO.setEmlSndNo(emlSndNo);
                 this.dbDao.modifyEmailResult( letterVO );
            }
            if( letterVO.getSendType().equals("FAX")){
                String faxSndNo = letterEAIDAO.sendMcsLetterFax(letterVO);
                letterVO.setFaxSndNo( faxSndNo);                
                this.dbDao.modifyFaxResult( letterVO );                
           }            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"McsLetter", "Send"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"McsLetter", "Send"}).getMessage(), ex);
        }       
    }
   
    /**
     * 
     * Mdm_Customer 자료를 CarCd로 조회합니다.<br>
     *
     * @param  carCd
     * @throws EventException
     * @return List<McsLetterVO>
     * @author jang kang cheol
     */
    public   List<McsLetterVO> searchToCustList(String carCd) throws EventException {
        try { 
            return dbDao.searchToCustList(  carCd );
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"ToCustList", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"ToCustList", "Retrieve"}).getMessage(), ex);
        }
         
    }

    /**
     * 
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return List<TextNoVO>
     * @author jang kang cheol
     */
    public List<TextNoVO>  searchInvoiceTextNo( LetterVO letterVO ) throws EventException{
        try {
            return dbDao.searchInvoiceTextNo( letterVO );
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice TextNo", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice TextNo", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * 
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO 
     * @throws EventException
     * @return List< InvoiceCombinedVO> 
     * @author jang kang cheol
     */
    public List<InvoiceCombinedVO> searchInvoiceLetter(  LetterVO letterVO )
            throws EventException { 
        try {
            return dbDao.searchInvoiceLetter(  letterVO );
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Letter", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Letter", "Retrieve"}).getMessage(), ex);
        }
    }    

    /**
     * 
     * 
     * D : [FnsJoo0062Event]<br>
     * Invoice Letter Information Creation  Letter 전송 .<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @author jang kang cheol
     */ 
    public void sendInvoiceLetter(LetterVO  letterVO) throws EventException {
        JointOperationLetterEAIDAO letterEAIDAO = new JointOperationLetterEAIDAO();
        try {
            List< LetterVO> letterVOs   = this.dbDao.searchComUserInfo(letterVO);
            if(letterVOs.size() > 0 ){
                letterVO.setContent(    letterVOs.get(0).getGreeting() );//Greeting
                letterVO.setUsrNm    (  letterVOs.get(0).getUsrNm()     );
                letterVO.setUsrEml   (  letterVOs.get(0).getUsrEml()    );
                letterVO.setJbEngNm  (  letterVOs.get(0).getJbEngNm()   );
                letterVO.setOfcCd    (  letterVOs.get(0).getOfcCd()     );
                letterVO.setXtnPhnNo (  letterVOs.get(0).getXtnPhnNo()  );
                letterVO.setFaxNo    (  letterVOs.get(0).getFaxNo()     );
            }
            if( letterVO.getSendType().equals("MAIL")){
                
                 String emlSndNo = letterEAIDAO.sendInvoiceLetterEmail(letterVO);
                 letterVO.setEmlSndNo(emlSndNo);
                 this.dbDao.modifyEmailResult( letterVO );
            }
            if( letterVO.getSendType().equals("FAX")){
                String faxSndNo = letterEAIDAO.sendInvoiceLetterFax(letterVO);
                letterVO.setFaxSndNo( faxSndNo);                
                this.dbDao.modifyFaxResult( letterVO );                
           }            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Letter", "Send"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Letter", "Send"}).getMessage(), ex);
        }    
    }    
    /**
     * 
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation ]을 [조회 Retrieve]합니다.<br>
     *
     * @param  InvoiceCombinedVO invoiceCombinedVO
     * @throws EventException
     * @return List<InvoiceCombinedVO> 
     * @author jang kang cheol
     */
    public List<InvoiceCombinedVO> searchInvoiceCombined(InvoiceCombinedVO invoiceCombinedVO)
            throws EventException {
        try {
            return dbDao.searchInvoiceCombined( invoiceCombinedVO );
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Combined", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Combined", "Retrieve"}).getMessage(), ex);
        }
    }
    /** 
     * 
     * D : [FnsJoo0062Event]<br>
     * [Invoice Letter Information Creation의 Text No]을 [조회 Get]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @param  LetterVO[] letterVOs
     * @param  SignOnUserAccount signOnUserAccount
     * @throws EventException
     * @return LetterVO letterVO
     * @author jang kang cheol
     */
    public LetterVO manageInvoiceLetter( LetterVO letterVO, LetterVO[] letterVOs, SignOnUserAccount signOnUserAccount) throws EventException {

        String sJoLtrSeq = "";
        String sJoLtrNo  = "";
        try {
            String joltrseq = letterVO.getJoLtrSeq() ;
            
            /*********************KEY 처리 존재하면 삭제 처리***************************/
            if( !joltrseq.equals("") ){
                dbDao.removeLetterAttach(letterVO);       
                dbDao.removeLetterStl(letterVO);            
                dbDao.removeLetter(letterVO);
            }
 
            
            String sUsrId = signOnUserAccount.getUsr_id();
            sJoLtrSeq = dbDao.searchJoLtrSeq();//LETTER SEQ 추출

            /***********************  Letter  Start ***************************/       
            LetterVO tmpletterVO = (LetterVO) letterVO.clone();
       
            tmpletterVO.setJoLtrSeq(  sJoLtrSeq );
            tmpletterVO.setCreUsrId(  sUsrId    );
            tmpletterVO.setUpdUsrId(  sUsrId    );     
            sJoLtrNo = dbDao.searchJoLtrNo(letterVO);
            tmpletterVO.setJoLtrNo(  sJoLtrNo   );
            dbDao.addInvoiceLetter (  tmpletterVO   );                
            /************************ Letter   End  ***************************/          
            
            
            /***********************  LetterStl Start *************************/        
 
            letterVO.setJoLtrSeq(sJoLtrSeq);
            dbDao.addInvoiceLetterStls( letterVO);
            /************************* LetterStl End ***********************/
            
            
            /***********************  LetterAttFile Start ***********************/
            List<LetterVO> insertLetterAtchFileList = new ArrayList<LetterVO>();
            LetterVO       letterAtchFile         = null;
            
            String[] attfilelist = null;
           // attfilelist =  split( letterVO.getKeys(), ";");
            attfilelist =  letterVO.getKeys().split(";");
            if( !letterVO.getKeys().equals("") ){
                for(int i=0;i<attfilelist.length;i++){
                    letterAtchFile         =  new LetterVO();    
                    letterAtchFile.setJoLtrSeq(     sJoLtrSeq              );
                    letterAtchFile.setFileSavId(  attfilelist[i]  );     
                    
                    letterAtchFile.setCreUsrId(  sUsrId   );
                    letterAtchFile.setUpdUsrId(  sUsrId   );                    
                    insertLetterAtchFileList.add(letterAtchFile);
                }
            }
            if ( insertLetterAtchFileList.size() > 0 ) {                
                dbDao.addLetterAttach(  insertLetterAtchFileList);
            } 
            /*************************LetterAttFile End *******************/            
            return tmpletterVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Letter", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Invoice Letter", "Save"}).getMessage(), ex);
        }
    }

    /**
     * 
     * [Bank detail & Signature Office]을 [조회 Get]합니다.<br>
     *
     * @param   LetterVO letterVO
     * @throws  EventException
     * @return  List<LetterVO>
     * @author  jang kang cheol
     */ 
   public List<LetterVO> searchOfficeCd(LetterVO letterVO) throws EventException{
       try {
           return dbDao.searchOfficeCd(letterVO);
       } catch (DAOException ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Code", "Retrieve"}).getMessage(), ex);
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"Office Code", "Retrieve"}).getMessage(), ex);
       }
   }
   
   /**
    * 
    * [Bank detail & Signature의  User Nm]을 [조회 Get]합니다.<br>
    * @param   LetterVO letterVO
    * @throws  EventException
    * @return  List<LetterVO>
    * @author  jang kang cheol
    */ 
   public List<LetterVO> searchUserNm(LetterVO letterVO) throws EventException{
       try {
           return dbDao.searchUserNm(letterVO); 
       } catch (DAOException ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"User Name", "Retrieve"}).getMessage(), ex);
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"User Name", "Retrieve"}).getMessage(), ex);
       }
   }
 
    /**
     * 
     * [Bank detail & detail]을 [조회 Retrieve]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return List<LetterVO>
     * @author jang kang cheol
     */
    public List<LetterVO> searchSignNBank(LetterVO letterVO) throws EventException{
        try {
            return dbDao.searchSignNBank(letterVO); 
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Sign Bank", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Sign Bank", "Retrieve"}).getMessage(), ex);
        }
    }
    
    /**
     * 
     * [Bank detail & detail]을 [저장  Save]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @return LetterVO
     * @author jang kang cheol
     */
    public LetterVO addSignNBank(LetterVO letterVO) throws EventException{
        try {
             letterVO.setUpdUsrId(letterVO.getCreUsrId());            
              List<LetterVO> rstVO = dbDao.getNewTmpltSeqNo(letterVO);
              letterVO.setJoTmpltNo(      rstVO.get(0).getJoTmpltNo()        );
              letterVO.setJoLtrTmpltSeq(  rstVO.get(0).getJoLtrTmpltSeq()    );
              dbDao.addSignNBank(letterVO);
              letterVO.setJoTmpltNo(    rstVO.get(0).getJoTmpltNo()   );
              return letterVO;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Sign Bank", "Save"}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Sign Bank", "Save"}).getMessage(), ex);
        }
    }
    /**
     * 
     * [Bank detail & detail]을  [삭제 Save]합니다.<br>
     *
     * @param  LetterVO letterVO
     * @throws EventException
     * @author jang kang cheol
     */
    public void removeSignNBank(LetterVO letterVO) throws EventException{
          try {
                dbDao.removeSignNBank(letterVO);
          } catch (DAOException ex) {
              throw new EventException(new ErrorHandler("JOO10007", new String[]{"Sign Bank", "Remove"}).getMessage(), ex);
          } catch (Exception ex) {
              throw new EventException(new ErrorHandler("JOO10007", new String[]{"Sign Bank", "Remove"}).getMessage(), ex);
          }
    }
    /**
     * Seq코드 정보를 읽어온다.
     * @param String joLtrTpCd
     * @param String ofcCd
     * @param String userId
     * @return List<LetterVO>
     * @throws EventException
     */
    public List<LetterVO> searchTempalteSeqList(String joLtrTpCd, String ofcCd, String userId) throws EventException{
        try {
            return dbDao.searchTempalteSeqList(joLtrTpCd, ofcCd, userId);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template Seq", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Template Seq", "Retrieve"}).getMessage(), ex);
        }     
    }

    /**
     * [MCS Letter Information Creation]을 [조회 Saved Retrieve]합니다.
     * @param  LetterVO letterVO
     * @return List<LetterVO>
     * @throws EventException
     */
    public List<LetterVO> searchJooLetter(LetterVO letterVO)
            throws EventException {
 
        try {
             return dbDao.searchJooLetter(letterVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Letter", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Letter", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * [MCS Letter Information Creation]을 [조회 Saved Retrieve]합니다.
     * @param  LetterVO letterVO
     * @return List<LetterVO>
     * @throws EventException
     */
    public List<LetterVO> searchJooLtrStl(LetterVO letterVO)
            throws EventException {
 
        try {
             return dbDao.searchJooLtrStl(letterVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Letter Stl", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Letter Stl", "Retrieve"}).getMessage(), ex);
        }
    }
    /**
     * 
     * [Invoice Letter Information Creation의 Ltr Stl 정보를 ]을 [조회 Retrieve]합니다.<br>
     *
     * @param   InvoiceCombinedVO invoiceCombinedVO
     * @throws  DAOException
     * @return  List<InvoiceCombinedVO>
     * @author  jang kang cheol
     */ 
   public List<InvoiceCombinedVO> searchSavedJooLtrStl(InvoiceCombinedVO invoiceCombinedVO) throws EventException{
        try {
            return dbDao.searchSavedJooLtrStl(invoiceCombinedVO);
       } catch (DAOException ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"Letter Stl Dtl", "Retrieve"}).getMessage(), ex);
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"Letter Stl Dtl", "Retrieve"}).getMessage(), ex);
       }
    }
  
	/**
	 * PIC of User 정보를 조회합니다.<br>
	 * 
	 * @param String joCntcPicId
	 * @return PicOfUserInfoVO
	 * @exception EventException
	 */
	public PicOfUserInfoVO searchPicUserIdInfo(String joCntcPicId) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			return dbDao.searchPicUserIdInfo(joCntcPicId); 
       } catch (DAOException ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"PIC of User Info ", "Retrieve"}).getMessage(), ex);
       } catch (Exception ex) {
           log.error("err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("JOO10007", new String[]{"PIC of User Info ", "Retrieve"}).getMessage(), ex);
       }
	}

}