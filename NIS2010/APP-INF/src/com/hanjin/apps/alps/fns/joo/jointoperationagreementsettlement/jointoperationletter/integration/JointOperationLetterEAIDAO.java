/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationLetterEAIDAO.java
*@FileTitle : Mail or Fax EAI 처리 DAO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.08.21 장강철
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.01.07 김상수 [소스품질관리] R4J에 도출된 printStackTrace문 수정
*                   - printStackTrace => log.error로 수정
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.basic.JointOperationLetterBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.LetterVO;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxSendException;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;


/**
 * ALPS JointOperationLetterEAIDAO <br>
 * - ALPS-DangerousCargoRestriction system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author jang kang cheol
 * @see JointOperationLetterBCImpl 참조
 * @since J2EE 1.6
 */
public class JointOperationLetterEAIDAO extends EAIDAOSupport {
    /**
     * Mail System :
     * MCS Letter Informateion의 Mail을 전송합니다.<br>
     *
     * @param  LetterVO letterVO
     * @return String
     * @author jang kang cheol
     */
    public String sendMcsLetterEmail(LetterVO letterVO) throws DAOException {
        List<SingleMailAttachedFile> fileList = new ArrayList<SingleMailAttachedFile>();
        String[] fileParam = letterVO.getKeys().split( ";" );

        try {
            /****************************** Get Attatch File Start ******************************************/
            for(int i=0;i<fileParam.length;i++){
                if(letterVO.getKeys().equals("")){break;}
                SingleMailAttachedFile attatchedFile = new SingleMailAttachedFile();
                attatchedFile.setFileKey(  fileParam[i]   );
                fileList.add(attatchedFile);
            }
            /****************************** Get Attatch File End ******************************************/
            String[] strArr = new String[6];
            strArr[0] = "message;"   +letterVO.getContent();
            strArr[1] = "jb_eng_nm;" +letterVO.getJbEngNm() ;  //jb_eng_nm
            strArr[2] = "usr_nm;"    +letterVO.getUsrNm();     //usr_nm
            strArr[3] = "usr_eml;"   +letterVO.getUsrEml();    //usr_eml
            strArr[4] = "xtn_phn_no;"+letterVO.getXtnPhnNo(); //xtn_phn_no
            strArr[5] = "fax_no;"    +letterVO.getFaxNo() ;     //fax_no

            Collection<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
            ComRptDsgnXptInfoVO comRptDsgnXptInfoVO =  new ComRptDsgnXptInfoVO();
            TemplateMail        templateMail        =  new TemplateMail();


            templateMail.setBatFlg      (  "N"                        );
            templateMail.setBccRcvrEml  (  ""                         );
            templateMail.setCcRcvrEml   (  letterVO.getCcRcvrEmlCtnt());//CC
            templateMail.setAttachedFile(  fileList                   ); //x
            templateMail.setSubject     (  letterVO.getLtrTitCtnt()   );//x
            templateMail.setRdSubSysCd  (  letterVO.getSubSysCd()     );//x

            templateMail.setRecipient   (  letterVO.getRcvrEml()      );//x

            templateMail.setFrom        (  letterVO.getSndrEml(),letterVO.getUsrNm()      );
            StringBuilder sbTxt = new StringBuilder();
            sbTxt.append( FileUtils.fileReader(SiteConfigFactory.get("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), "FNS_JOO_0060_01T.html", strArr )  );
           // templateMail.setEmlCtnt( sbTxt );
            templateMail.setHtmlContent( sbTxt.toString() );

            comRptDsgnXptInfoVO.setRdParaCtnt( letterVO.getTmplparam()  );
            comRptDsgnXptInfoVO.setRdApplCd  ( ""                       );
            comRptDsgnXptInfoVO.setRdTmpltNm (  letterVO.getTmplmrd()   );//MRD명.
            comRptDsgnXptInfoVO.setXptFileNm (  letterVO.getLtrTitCtnt().replaceAll(" ", "")+".pdf"   );//ㅍ파일명
            comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
            comRptDsgnXptInfoVO.setCreUsrId( letterVO.getUsrId());
            comRptDsgnXptInfoVO.setUpdUsrId( letterVO.getUsrId());
            comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
            templateMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);

            return templateMail.send();

        } catch (MailerAppException e) {
            log.error("err " + e.toString(), e);
            log.error(e.getMessage());
            throw new DAOException(new ErrorHandler(e).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

    }

    /**
     * FAX System :
     * MCS Letter Informateion의 Fax를 전송합니다.<br>
     *
     * @param  LetterVO letterVO
     * @return String
     * @author jang kang cheol
     * @throws FaxSendException
     */
    public String sendMcsLetterFax(LetterVO letterVO) throws DAOException, FaxSendException {
        FaxMetaInfo faxMetaInfo = new FaxMetaInfo(
                letterVO.getSubSysCd(),
                letterVO.getTmplmrd(),//RD MRD 파일.
                                                 "N",  //B
                                                 letterVO.getLtrTitCtnt(),//제목
                                                 letterVO.getTmplparam(),   // "/rv bkg_no[('BKKZ4250001A1','KORY1025089','KORZC315127','KORY1025027','KORY1025041')] remark[test1@@test2@@test3@@test4] type[detail] usr_id[0660235]",
                                                 letterVO.getJoCntcFaxNoCtnt() ,//Fax 번호, "KIM;3411" jo_cntc_fax_no
                                                 letterVO.getOfcCd(),//Office Code 전송자 부서코드
                                                 letterVO.getUsrId() );//전송자 ID
        //faxMetaInfo.set
        return FaxUtility.registerDB(faxMetaInfo);
    }

    /**
     *  Mail System  :
     *  Invoice Letter Informateion의 Mail을 전송합니다.<br>
     *
     * @param  LetterVO letterVO
     * @return String
     * @author jang kang cheol
     */
    public String sendInvoiceLetterEmail(LetterVO letterVO) throws DAOException {
        List<SingleMailAttachedFile> fileList = new ArrayList<SingleMailAttachedFile>();
        String[] fileParam =  letterVO.getKeys().split( ";" );

        try {
            /****************************** Get Attatch File Start ******************************************/
            for(int i=0;i<fileParam.length;i++){
                if(letterVO.getKeys().equals("")){break;}
                SingleMailAttachedFile attatchedFile = new SingleMailAttachedFile();
                attatchedFile.setFileKey(  fileParam[i]   );
                fileList.add(attatchedFile);
            }
            /****************************** Get Attatch File End ******************************************/
            String[] strArr = new String[6];
            strArr[0] = "message;"+letterVO.getContent();
            strArr[1] = "jb_eng_nm;" +letterVO.getJbEngNm() ;  //jb_eng_nm
            strArr[2] = "usr_nm;"    +letterVO.getUsrNm();     //usr_nm
            strArr[3] = "usr_eml;"   +letterVO.getUsrEml();    //usr_eml
            strArr[4] = "xtn_phn_no;"+letterVO.getXtnPhnNo(); //xtn_phn_no
            strArr[5] = "fax_no;"    +letterVO.getFaxNo() ;     //fax_no

            Collection<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
            ComRptDsgnXptInfoVO comRptDsgnXptInfoVO =  new ComRptDsgnXptInfoVO();
            TemplateMail        templateMail        =  new TemplateMail();


            templateMail.setBatFlg      (  "N"                        );
            templateMail.setBccRcvrEml  (  ""                         );
            templateMail.setCcRcvrEml   (  letterVO.getCcRcvrEmlCtnt());//CC
            templateMail.setAttachedFile(  fileList                   );
            templateMail.setSubject     (  letterVO.getLtrTitCtnt()   );
            templateMail.setRdSubSysCd  (  letterVO.getSubSysCd()     );

            templateMail.setRecipient   (  letterVO.getRcvrEml()      );

            templateMail.setFrom        (  letterVO.getSndrEml(),letterVO.getUsrNm()      );

            StringBuilder sbTxt = new StringBuilder();
            sbTxt.append( FileUtils.fileReader(SiteConfigFactory.get("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), "FNS_JOO_0060_01T.html", strArr )  );
          //  templateMail.setTextContent( sbTxt.toString() );
            templateMail.setHtmlContent( sbTxt.toString() );

            comRptDsgnXptInfoVO.setRdParaCtnt( letterVO.getTmplparam()  );
            comRptDsgnXptInfoVO.setRdApplCd  ( ""                       );
            comRptDsgnXptInfoVO.setRdTmpltNm (  letterVO.getTmplmrd()   );//MRD명.
            comRptDsgnXptInfoVO.setXptFileNm (  letterVO.getLtrTitCtnt().replaceAll(" ", "")+".pdf"   );//ㅍ파일명
            comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
            comRptDsgnXptInfoVO.setCreUsrId( letterVO.getUsrId());
            comRptDsgnXptInfoVO.setUpdUsrId( letterVO.getUsrId());
            comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
            templateMail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
            return templateMail.send();

        } catch (MailerAppException e) {
            log.error("err " + e.toString(), e);
            log.error(e.getMessage());
            throw new DAOException(new ErrorHandler(e).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    /**
     * FAX System :
     * Invoice Letter Informateion의 Fax를 전송합니다.<br>
     *
     * @param  LetterVO letterVO
     * @return String
     * @author jang kang cheol
     * @throws FaxSendException
     */
    public String sendInvoiceLetterFax(LetterVO letterVO) throws DAOException, FaxSendException {
        FaxMetaInfo faxMetaInfo = new FaxMetaInfo(
                letterVO.getSubSysCd(),
                letterVO.getTmplmrd(),//RD MRD 파일.
                                                 "N",  //B
                                                 letterVO.getLtrTitCtnt(),//제목
                                                 letterVO.getTmplparam(),   // "/rv bkg_no[('BKKZ4250001A1','KORY1025089','KORZC315127','KORY1025027','KORY1025041')] remark[test1@@test2@@test3@@test4] type[detail] usr_id[0660235]",
                                                 letterVO.getJoCntcFaxNoCtnt() ,//Fax 번호, "KIM;3411" jo_cntc_fax_no
                                                 letterVO.getOfcCd(),//Office Code 전송자 부서코드
                                                 letterVO.getUsrId() );//전송자 ID
        //faxMetaInfo.set
        return FaxUtility.registerDB(faxMetaInfo);
    }

}
