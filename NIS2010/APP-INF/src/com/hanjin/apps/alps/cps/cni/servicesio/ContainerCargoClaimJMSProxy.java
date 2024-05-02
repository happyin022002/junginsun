/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerCargoClaimJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-05-25
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009-06-19 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.cps.cni.servicesio;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.event.CpsCni0014Event;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo.GwApproveStatusVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.com.COM005R001Document;
import com.hanjin.irep.com.COM005R001Document.COM005R001;
import com.hanjin.irep.com.COM005R001Document.COM005R001.DataArea.CargoClaimInfoReturn;
import com.jf.transfer.TransferEAI;

/**
 * It's ContainerCargoClaimJMSProxy.java
 * 
 * @author Hyunsu, Ryu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class ContainerCargoClaimJMSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	
	/**
	 * JMS Receive(COM005_R001)<br>
	 * 
	 * @param TransferEAI eai
	 * @throws EventException 
	 * @exception EventException, XmlException, Exception
	 */
	public void com005R001ReceiveJMS(TransferEAI eai) throws DAOException, EventException {
		
		ContainerCargoClaimSC  sc = new ContainerCargoClaimSC();
		
		String xml = eai.getMessage();
		//log.debug("======================================");
		//log.debug("xml : " + str);
		//log.debug("======================================");
		
		try {
			Event event = new CpsCni0014Event();		
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.COMMAND03);
			event.setFormCommand(f);
			
			COM005R001Document doc = COM005R001Document.Factory.parse(xml);
			COM005R001 sync = doc.getCOM005R001();
			com.hanjin.irep.com.COM005R001Document.COM005R001.DataArea data = 
				sync.getDataArea();
			
			CargoClaimInfoReturn[] vos =  data.getCargoClaimInfoReturnArray();
			
			if (vos != null && vos.length > 0) {				
				GwApproveStatusVO vo = new GwApproveStatusVO();
				
				CargoClaimInfoReturn param = data.getCargoClaimInfoReturnArray(0);
				// 클레임번호
				String cgoClmNo = param.getREQUESTID();
				vo.setCgoClmNo(cgoClmNo);
				// 승인 코멘트
				String clmStlAuthRmk = param.getRESULTMSG();
				vo.setClmStlAuthRmk(clmStlAuthRmk);	
				// 승인자 아이디
				String userId = param.getATTRIBUTE1();
				vo.setUpdUsrId(userId);
				
				// Doc NO 
				String clmStlAuthNo = param.getATTRIBUTE5();
				
				if (!StringUtils.isEmpty(clmStlAuthNo)) {
					vo.setClmStlAuthNo(clmStlAuthNo);
				}
				
				// ---------------------------------------------
				// 승인여부 
				// --------------------------------------------
				// C (CANCLE)       : EP내에서 결재 상신을 하기 전에 취소 or 삭제.
				// N (REJECT)        : 결재 상신 후 반송
				// Y (COMPLETE)  : 결재 완료.
				// P  - GW Draft Box에 저장 or 정상기안 , 최초 기안시
				String clmStlAuthCd = param.getRESULT();				
				vo.setClmStlAuthCd(clmStlAuthCd);
			
				((CpsCni0014Event) event).setGwApproveStatusVO(vo);
				sc.perform(event);
				
				eai.commit(sync.getEAIHeader().getInstanceId());
				
			}
			
					
		} catch (EventException ee) {			
			eai.rollback(ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (XmlException ex) {			
			eai.rollback(ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception e){			
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}
	

}
