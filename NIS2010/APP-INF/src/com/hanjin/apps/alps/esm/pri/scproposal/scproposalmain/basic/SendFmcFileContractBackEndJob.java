/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SendFmcFileContractBackEndJob.java
*@FileTitle : S/C Send FMC FileContract Webservice 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.11
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.09.11 송호진
* 1.0 Creation
=========================================================
* History
* 2014.09.17 송호진 [CHM-201430558] FMC Auto-filing 개발 요청
* 2014.09.23 송호진 [CHM-201432102] FMC Auto-Filing 과 관련하여 성능 이슈 해결을 위한 Log 생성 - Key 추가
* 2014.11.20 송호진 [CHM-201432557] S/C scope duration 로직 수정 - 신규 Svc Scp 의 경우 PRI_SP_SCP_DUR.CTRT_EFF_DT Update 
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration.SCProposalMainDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration.SCProposalMainEAIDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.CstPriSpMnFileDtVO;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * S/C Send FMC FileContract Webservice 비지니스 트랜잭션을 처리한다.
 * 
 * @author Song Ho Jin
 * @see SCProposalMainDBDAO
 * @since J2EE 1.6
 */
public class SendFmcFileContractBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -4990121540809163259L;

	private  SCProposalMainDBDAO mainDbDao = new SCProposalMainDBDAO();
	/*
	private  SCNoteConversionProposalDBDAO noteDbDao = new SCNoteConversionProposalDBDAO();
	private	 SCDurationProposalDBDAO durDbDao = new SCDurationProposalDBDAO();
	*/
	private  CstPriSpMnFileDtVO fileDtVo = new CstPriSpMnFileDtVO();
	private  SignOnUserAccount account;

	/**
	 * S/C Send FMC FileContract Webservice 조건을 셋팅한다. <br>
	 *  
	 * @param CstPriSpMnFileDtVO fileDtVo
	 * @param SignOnUserAccount account
	 * @return 
	 * @exception
	 */	
	public void setSendFmcFileContractVO( CstPriSpMnFileDtVO fileDtVo, SignOnUserAccount account) {
		this.fileDtVo = fileDtVo;
		this.account = account;
	}

	/**
	 * S/C Send FMC FileContract Webservice 을 수행한다. <br>
	 *  
	 * @return List<CstPriSpMnFileDtVO>
	 * @exception Exception
	 */
	public List<CstPriSpMnFileDtVO> doStart() throws Exception {
//        PriSpMnVO priSpMnVO = new PriSpMnVO();
        List<CstPriSpMnFileDtVO> list = new ArrayList<CstPriSpMnFileDtVO>();
		
		try {
        	// RD Report 를 생성하는 Connection 과 SC 에서 Transaction 을 수행하는 Connection 이 서로 다른바
        	// 부득이 하나의 실행 안에서 begin - commit 을 분리하여 수행토록 수정 함. 2014.10.29

            // PRI_SP_FILE_PROG 를 신규 생성 한다.
			int newFileProgSeq = mainDbDao.searchPriSpFileProgNewSeq(fileDtVo);
			fileDtVo.setCreUsrId(account.getUsr_id());

			fileDtVo.setFileProgSeq(newFileProgSeq+"");
			mainDbDao.createPriSpFileProg(fileDtVo);

			log.error ("FileContract-#2|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());
            // INTERFACE : Webservice 로 FMC 로  을 전송
            SCProposalMainEAIDAO eaiDao = new SCProposalMainEAIDAO();
            eaiDao.sendFmcFileContract(fileDtVo);
            
			log.error ("FileContract-#3|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());
            // Webservice 의 결과로 전송된 값을 기반하여 PRI_SP_FILE_PROG 의 Update 및 PRI_SP_FILE_ERR 테이블을 생성한다.
            fileDtVo.setCreUsrId(account.getUsr_id());
            fileDtVo.setUpdUsrId(account.getUsr_id());

            mainDbDao.modifyPriSpFileProgUsingRtnMsg(fileDtVo);
            mainDbDao.createPriSpFileErrUsingRtnMsg(fileDtVo);
            
            CstPriSpMnFileDtVO newFileDtVo = new CstPriSpMnFileDtVO();
            ObjectCloner.build(fileDtVo, newFileDtVo);
            list.add(newFileDtVo);
			log.error ("FileContract-#4|"+fileDtVo.getScNo()+"|"+fileDtVo.getAmdtSeq()+"|"+fileDtVo.getFileProgSeq());

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
        return list;
		
	}
}
