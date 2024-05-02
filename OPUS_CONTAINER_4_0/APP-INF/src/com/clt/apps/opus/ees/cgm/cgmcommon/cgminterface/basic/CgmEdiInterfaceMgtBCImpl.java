/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmEdiInterfaceMgtBCImpl.java
*@FileTitle : common EDI Send
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : P.K.S
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration.CgmEdiSendEAIDAO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.integration.CgmSendDBDAO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.vo.ChassisShipMentFlatFileVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * COM-OperationManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_MNR_0139EventResponse,EQFlagMgtBC DAO class reference
 * @since J2EE 1.4
 */
public class CgmEdiInterfaceMgtBCImpl extends BasicCommandSupport implements CgmEdiInterfaceMgtBC {

	// Database Access Object
//	private transient InterfaceMgtDBDAO dbDao = null;
	private transient CgmEdiSendEAIDAO eaiDao = null;
	private transient CgmSendDBDAO dbDao = null;

	/**
	 * creating InterfaceMgtBCImpl object<br>
	 * creating GeneralCodeCheckMgtDBDAODAO <br>
	 */
	public CgmEdiInterfaceMgtBCImpl() {
	//	dbDao = new InterfaceMgtDBDAO();
		eaiDao = new CgmEdiSendEAIDAO();
		dbDao  = new CgmSendDBDAO();
	}

	/**
	 *
	 * @return String
	 * @exception EventException
	 */
	public String chaShipmentSendBasic() throws EventException{

	//	String trsmModCd=docResultVO.getTrsmModCd();
		String cgmRefNo="";
//		String ifTrcSeq="";
		
		try {
//				String[] pools = {"IAS", "NEWPORT"};
				List<ChassisShipMentFlatFileVO> poolList = dbDao.searchChassisShipmentRecieverData();
				for(int k=0; k<poolList.size(); k++){
					StringBuffer flatFile = new StringBuffer("");
					ChassisShipMentFlatFileVO sendChassisShipMentFlatFileVO = new ChassisShipMentFlatFileVO();// dbDao.searchIFEstimateHRDData(docResultVO);
					sendChassisShipMentFlatFileVO.setFwCd(poolList.get(k).getFwCd());
					sendChassisShipMentFlatFileVO.setFwNm(poolList.get(k).getFwNm());
				// 	$$$MSGSTART: + SENDER_ID(20) + RECEIVER_ID(20) + CHSHIP(MSG Type, 10) + Flat File Ref # (14)
					List<ChassisShipMentFlatFileVO> sendChassisShipMentFlatFileVOs = new ArrayList<ChassisShipMentFlatFileVO>();
					sendChassisShipMentFlatFileVOs = dbDao.searchChassisShipMentFlatFile(sendChassisShipMentFlatFileVO);
								
				//	SENDER : NYKS / RECEIVER : FLEXIVAN      
				//	SENDER : NYKS / RECEIVER : TRACINTERMODAL
				//	SENDER : NYKS / RECEIVER : IAS 
					 
					//RCV ID 조회
					String rcvId = poolList.get(k).getFwCd();
					//SND ID 조회
					String sndId = "NYKS";
	
					String referenceNumber = "";
					String header = "";
					
					if(sendChassisShipMentFlatFileVOs != null && sendChassisShipMentFlatFileVOs.size() > 0){
						referenceNumber = ReferenceNumberGeneratorBroker.getKey("CGM","CGM_EDI_SEQ");
						header = "$$$MSGSTART:"
							       + StringUtils.rightPad(StringUtils.trimToEmpty(sndId), 20, " ")
					               + StringUtils.rightPad(StringUtils.trimToEmpty(rcvId), 20, " ")
					               + StringUtils.rightPad("CHSHIP", 10, " ")
					               + referenceNumber;
						flatFile.append(header+"\n");
						for(int i = 0;i < sendChassisShipMentFlatFileVOs.size();i++){
							flatFile.append("{SHIP_INFO\n");
							flatFile.append("IMEX:"+sendChassisShipMentFlatFileVOs.get(i).getImex()+"\n");
							flatFile.append("POOL_CD:"+sendChassisShipMentFlatFileVOs.get(i).getPoolCd()+"\n");
							flatFile.append("BL_NO:"+sendChassisShipMentFlatFileVOs.get(i).getBlNo()+"\n");
							flatFile.append("BL_DT:"+sendChassisShipMentFlatFileVOs.get(i).getBlDt()+"\n");
							flatFile.append("BKG_NO:"+sendChassisShipMentFlatFileVOs.get(i).getBkgNo()+"\n");
							flatFile.append("BKG_DT:"+sendChassisShipMentFlatFileVOs.get(i).getBkgDt()+"\n");
							flatFile.append("TRANS_TP:"+sendChassisShipMentFlatFileVOs.get(i).getTransTp() +"\n");
							flatFile.append("MODE:"+sendChassisShipMentFlatFileVOs.get(i).getMode()+"\n");	
							flatFile.append("ETA:"+sendChassisShipMentFlatFileVOs.get(i).getEta()+"\n");
							flatFile.append("ETA_GMT:"+sendChassisShipMentFlatFileVOs.get(i).getEtaGmt()+"\n");
							flatFile.append("ETD:"+sendChassisShipMentFlatFileVOs.get(i).getEtd()+"\n");
							flatFile.append("ETD_GMT:"+sendChassisShipMentFlatFileVOs.get(i).getEtdGmt()+"\n");
							flatFile.append("ARR_LOC:"+sendChassisShipMentFlatFileVOs.get(i).getArrLoc()+"\n");
							flatFile.append("DEP_LOC:"+sendChassisShipMentFlatFileVOs.get(i).getDepLoc()+"\n");
							flatFile.append("CNTR_NO:"+sendChassisShipMentFlatFileVOs.get(i).getCntrNo()+"\n");
							flatFile.append("CNTR_CHK:"+sendChassisShipMentFlatFileVOs.get(i).getCntrChk()+"\n");
							flatFile.append("CNTR_TP:"+sendChassisShipMentFlatFileVOs.get(i).getCntrTp()+"\n");
							flatFile.append("SHPR_CD:"+sendChassisShipMentFlatFileVOs.get(i).getShprCd()+"\n");
							flatFile.append("SHPR_NM:"+sendChassisShipMentFlatFileVOs.get(i).getShprNm()+"\n");
							flatFile.append("FW_CD:"+sendChassisShipMentFlatFileVOs.get(i).getFwCd()+"\n");
							flatFile.append("FW_NM:"+sendChassisShipMentFlatFileVOs.get(i).getFwNm()+"\n");
							flatFile.append("CNEE_CD:"+sendChassisShipMentFlatFileVOs.get(i).getCneeCd()+"\n");
							flatFile.append("CNEE_NM:"+sendChassisShipMentFlatFileVOs.get(i).getCneeNm()+"\n");
							flatFile.append("DEST_IM:"+sendChassisShipMentFlatFileVOs.get(i).getDestIm()+"\n");
							flatFile.append("DEST_EX:"+sendChassisShipMentFlatFileVOs.get(i).getDestEx()+"\n");
	
							flatFile.append("EQREL:"+sendChassisShipMentFlatFileVOs.get(i).getEqrel()+"\n");
							flatFile.append("EQRTN:"+sendChassisShipMentFlatFileVOs.get(i).getEqrtn()+"\n");
							flatFile.append("POD_SVC:"+sendChassisShipMentFlatFileVOs.get(i).getPodSvc()+"\n");
							flatFile.append("POL_SVC:"+sendChassisShipMentFlatFileVOs.get(i).getPolSvc()+"\n");
							flatFile.append("POD_VSL:"+sendChassisShipMentFlatFileVOs.get(i).getPodVsl()+"\n");
							flatFile.append("POL_VSL:"+sendChassisShipMentFlatFileVOs.get(i).getPolVsl()+"\n");
							flatFile.append("POD_VOY:"+sendChassisShipMentFlatFileVOs.get(i).getPodVoy()+"\n");
							flatFile.append("POL_VOY:"+sendChassisShipMentFlatFileVOs.get(i).getPolVoy()+"\n");
							flatFile.append("CONTRACT:"+sendChassisShipMentFlatFileVOs.get(i).getContract()+"\n");
							flatFile.append("}SHIP_INFO\n");
						}
						sendChassisShipMentFlatFileVO.setFlatFile(flatFile.toString());
						cgmRefNo = eaiDao.sendEDIData(sendChassisShipMentFlatFileVO);
					}
					
					
				}
		} catch (EAIException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),de);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return  cgmRefNo;
	}	
}