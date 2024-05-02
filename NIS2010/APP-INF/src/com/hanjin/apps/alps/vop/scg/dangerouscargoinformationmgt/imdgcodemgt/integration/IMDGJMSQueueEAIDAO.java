/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : IMDGJMSQueueEAIDAO.java
 *@FileTitle : Send WebLogic JMS Queue EAIDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-05-20
 *@LastModifier : Yongsang, YOON
 *@LastVersion : 1.0
 * 2014-05-20 Yongsang, YOON
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.UNNumberListOptionVO;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.irep.alps.EAIHeaderType;
import com.hanjin.irep.alps.IMDG0010001Document;
import com.hanjin.irep.alps.IMDG0010001Document.IMDG0010001;
import com.hanjin.irep.alps.IMDG0010001Document.IMDG0010001.DataArea.UNNOCollection;
import com.hanjin.irep.alps.IMDG0020001Document;
import com.hanjin.irep.alps.IMDG0020001Document.IMDG0020001;
import com.hanjin.irep.alps.IMDG0020001Document.IMDG0020001.DataArea.PCKCDCollection;
import com.hanjin.irep.alps.IMDG0030001Document;
import com.hanjin.irep.alps.IMDG0030001Document.IMDG0030001;
import com.hanjin.irep.alps.IMDG0030001Document.IMDG0030001.DataArea.SUBSRSKLBLCollection;
import com.hanjin.irep.alps.IMDG0040001Document;
import com.hanjin.irep.alps.IMDG0040001Document.IMDG0040001;
import com.hanjin.irep.alps.IMDG0040001Document.IMDG0040001.DataArea.CLSSSCDCollection;
import com.hanjin.irep.alps.IMDG005R001Document;
import com.hanjin.irep.alps.IMDG005R001Document.IMDG005R001;
import com.hanjin.irep.alps.IMDG005R001Document.IMDG005R001.DataArea.ApprovalREQReplyCollection;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.syscommon.common.table.ScgImdgSubsRskLblVO;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;
import com.jf.transfer.jms.send.vandor.WeblogicSendQClient;

/**
 * It's ASynch JMS Listener
 * 
 * @author Yongsang, YOON
 * @see
 * @since
 */
@SuppressWarnings("serial")
public class IMDGJMSQueueEAIDAO extends DBDAOSupport {

	/*
	 * public static void main(String[] args) { IMDGJMSQueueEAIDAO
	 * logicJMSQueueEAIDAO = new IMDGJMSQueueEAIDAO(); try {
	 * List<UNNumberListOptionVO> list = new ArrayList<UNNumberListOptionVO>();
	 * UNNumberListOptionVO vo = new UNNumberListOptionVO();
	 * vo.setAwayFmImdgClssFlg("t1111"); vo.setAwayFmImdgSegrGrpFlg("t222");
	 * list.add(vo); logicJMSQueueEAIDAO.sendDbIMDG0010001(list); } catch
	 * (DAOException e) { 
	 * e.printStackTrace(); } }
	 */
	/**
	 * JMS send ScgImdgUnNoVO <br>
	 * <br>
	 * 
	 * @param List<UNNumberListOptionVO> list
	 * @return String
	 * @throws DAOException
	 */
	public String sendDbIMDG0010001(List<UNNumberListOptionVO> list) throws DAOException {

		String reString = "";
		TransferEAI eai = null;

		String sendUrl = "";
		String factory = "";
		String queue = "";
		try {
			// Request Start
			String dest = "IMDG001_0001";
			String instanceId = dest + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());

			sendUrl = SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL");
			factory = SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY");
			queue = SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE");

			IMDG0010001Document doc = IMDG0010001Document.Factory.newInstance();
			IMDG0010001 imdg0010001 = IMDG0010001.Factory.newInstance();

			EAIHeaderType headerType = imdg0010001.addNewEAIHeader();

			IMDG0010001.DataArea dataArea = imdg0010001.addNewDataArea();

			UNNOCollection collection = dataArea.addNewUNNOCollection();

			// DBRowSet dbRowset = new SQLExecuter("").executeQuery(
			// (ISQLTemplate) new IMDGJMSQueueEAIDAOScgImdgUnNoVORSQL(),
			// param, velParam);
			// list = (List) RowSetUtil.rowSetToVOs(dbRowset,
			// ScgImdgUnNoVO.class);
			int i = 0;
			for (UNNumberListOptionVO vo : list) {
				IMDG0010001.DataArea.UNNOCollection.UNNO o = collection.addNewUNNO();
				o.setAWAYFMIMDGCLSSFLG(vo.getAwayFmImdgClssFlg());
				o.setAWAYFMIMDGSEGRGRPFLG(vo.getAwayFmImdgSegrGrpFlg());
				o.setCFRDGWETCD(vo.getCfrDgWetCd());
				o.setCFRPSNINHZNCD(vo.getCfrPsnInhZnCd());
				o.setCFRRPTQTY(vo.getCfrRptQty());
				o.setCFRRSTROPRNM(vo.getCfrRstrOprNm());
				o.setCFRRSTRPORTNM(vo.getCfrRstrPortNm());
				o.setCFRTOXCCD(vo.getCfrToxcCd());
				o.setCFRXTDCLSSCD(vo.getCfrXtdClssCd());
				o.setCLRLIVQTRSTWGFLG(vo.getClrLivQtrStwgFlg());
				o.setCREDT(vo.getCreDt());
				o.setCREUSRID(vo.getCreUsrId());
				o.setEMERRSPNGIDCHRNO(vo.getEmerRspnGidChrNo());
				o.setEMERRSPNGIDNO(vo.getEmerRspnGidNo());
				o.setFLSHPNTTEMPCTNT(vo.getFlshPntTempCtnt());
				o.setHCDGDPNDQTYFLG(vo.getHcdgDpndQtyFlg());
				o.setHCDGFLG(vo.getHcdgFlg());
				o.setHCDGINTMDBCRSTRDESC(vo.getHcdgIntmdBcRstrDesc());
				o.setHCDGPCKRSTRDESC(vo.getHcdgPckRstrDesc());
				o.setHCDGRMK(vo.getHcdgRmk());
				o.setHCDGTNKRSTRDESC(vo.getHcdgTnkRstrDesc());
				o.setIMDGCLSSCD(vo.getImdgClssCd());
				o.setIMDGCOMPGRPCD(vo.getImdgCompGrpCd());
				o.setIMDGEMERNO(vo.getImdgEmerNo());
				o.setIMDGEXPTQTYCD(vo.getImdgExptQtyCd());
				o.setIMDGEXPTQTYDESC(vo.getImdgExptQtyDesc());
				o.setIMDGFDSTUFSTWGCD(vo.getImdgFdStufStwgCd());
				o.setIMDGHTSRCSTWGCD(vo.getImdgHtSrcStwgCd());
				o.setIMDGLMTQTY(vo.getImdgLmtQty());
				o.setIMDGLMTQTYDESC(vo.getImdgLmtQtyDesc());
				o.setIMDGLMTQTYMEASUTCD(vo.getImdgLmtQty());
				o.setIMDGMRNPOLUTCD(vo.getImdgMrnPolutCd());
				o.setIMDGPCKGRPCD(vo.getImdgPckGrpCd());
				o.setIMDGSBSTPPTDESC(vo.getImdgSbstPptDesc());
				o.setIMDGSTWGCATECD(vo.getImdgStwgCateCd());
				o.setIMDGSUBSRSKLBLRMK(vo.getImdgSubsRskLblRmk());
				// o.setIMDGTBLNO(/vo.getIMDGTB)
				o.setIMDGUNNO(vo.getImdgUnNo());
				o.setIMDGUNNOHLDFLG(vo.getImdgUnNoHldFlg());
				o.setIMDGUNNOSEQ(vo.getImdgUnNoSeq());
				// o.setLIFID(vo.gwtli)
				o.setLKPORTAUTHNO(vo.getLkPortAuthNo());
				o.setN1STBOMPORTTRSTNO(vo.getN1stBomPortTrstNo());
				o.setN1STIMDGIBCINSTRSEQ(vo.getN1stImdgIbcInstrSeq());
				o.setN1STIMDGIBCPROVISEQ(vo.getN1stImdgIbcProviSeq());
				o.setN1STIMDGPCKINSTRCD(vo.getN1stImdgPckInstrCd());
				o.setN1STIMDGPCKINSTRSEQ(vo.getN1stImdgPckInstrSeq());
				o.setN1STIMDGPCKPROVISEQ(vo.getN1stImdgPckProviSeq());
				o.setN1STIMDGTNKINSTRPROVICD(vo.getN1stImdgTnkInstrProviCd());
				o.setN1STIMDGTNKINSTRPROVISEQ(vo.getN1stImdgTnkInstrProviSeq());
				o.setN1STIMDGUNTNKINSTRCD(vo.getN1stImdgUnTnkInstrCd());
				o.setN1STIMDGUNTNKINSTRSEQ(vo.getN1stImdgUnTnkInstrSeq());
				o.setLKPORTAUTHNO(vo.getLkPortAuthNo());
				o.setN2NDBOMPORTTRSTNO(vo.getN2ndBomPortTrstNo());
				o.setN2NDIMDGIBCINSTRSEQ(vo.getN2ndImdgIbcInstrSeq());
				o.setN2NDIMDGIBCPROVISEQ(vo.getN2ndImdgIbcProviSeq());
				// o.setN2NDIMDGPCKINSTRCD(vo.getN2ndImdgPckInstrCd());
				o.setN2NDIMDGPCKINSTRSEQ(vo.getN2ndImdgPckInstrSeq());
				o.setN2NDIMDGPCKPROVISEQ(vo.getN2ndImdgPckProviSeq());
				o.setN2NDIMDGTNKINSTRPROVICD(vo.getN2ndImdgTnkInstrProviCd());
				o.setN2NDIMDGTNKINSTRPROVISEQ(vo.getN2ndImdgTnkInstrProviSeq());
				o.setN2NDIMDGUNTNKINSTRCD(vo.getN2ndImdgUnTnkInstrCd());
				o.setN2NDIMDGUNTNKINSTRSEQ(vo.getN2ndImdgUnTnkInstrSeq());

				o.setN3RDBOMPORTTRSTNO(vo.getN3rdBomPortTrstNo());
				o.setN3RDIMDGIBCINSTRSEQ(vo.getN3rdImdgIbcInstrSeq());
				o.setN3RDIMDGIBCPROVISEQ(vo.getN3rdImdgIbcProviSeq());
				o.setN3RDIMDGPCKINSTRSEQ(vo.getN3rdImdgPckInstrSeq());
				o.setN3RDIMDGPCKPROVISEQ(vo.getN3rdImdgPckProviSeq());
				o.setN3RDIMDGTNKINSTRPROVICD(vo.getN3rdImdgTnkInstrProviCd());
				o.setN3RDIMDGTNKINSTRPROVISEQ(vo.getN3rdImdgTnkInstrProviSeq());

				o.setN4THBOMPORTTRSTNO(vo.getN4thBomPortTrstNo());
				o.setN4THIMDGIBCINSTRSEQ(vo.getN4thImdgIbcInstrSeq());
				o.setN4THIMDGIBCPROVISEQ(vo.getN4thImdgIbcProviSeq());
				o.setN4THIMDGPCKPROVISEQ(vo.getN4thImdgPckProviSeq());
				o.setN4THIMDGTNKINSTRPROVICD(vo.getN4thImdgTnkInstrProviCd());
				o.setN4THIMDGTNKINSTRPROVISEQ(vo.getN4thImdgTnkInstrProviSeq());

				o.setN5THIMDGIBCINSTRSEQ(vo.getN5thImdgIbcInstrSeq());
				o.setN5THIMDGIBCPROVISEQ(vo.getN5thImdgIbcProviSeq());
				o.setN5THIMDGPCKPROVISEQ(vo.getN5thImdgPckProviSeq());
				o.setN5THIMDGTNKINSTRPROVICD(vo.getN5thImdgTnkInstrProviCd());
				o.setN5THIMDGTNKINSTRPROVISEQ(vo.getN5thImdgTnkInstrProviSeq());

				o.setPKGAUTHNO(vo.getPkgAuthNo());
				o.setPSANO(vo.getPsaNo());

				o.setSEGRASFORIMDGCLSSCD(vo.getSegrAsForImdgClssCd());
				o.setSEGRASFORIMDGCLSSFLG(vo.getSegrAsForImdgClssFlg());
				o.setSEGRDESC(vo.getSegrDesc());
				o.setSPRTFMIMDGCLSSFLG(vo.getSprtFmImdgClssFlg());
				o.setSPRTFMIMDGSEGRGRPFLG(vo.getSprtFmImdgSegrGrpFlg());
				o.setSPRTHLDFMIMDGCLSSFLG(vo.getSprtHldFmImdgClssFlg());
				o.setSPRTLONFMIMDGCLSSFLG(vo.getSprtLonFmImdgClssFlg());

				o.setUPDDT(vo.getUpdDt());
				o.setUPDUSRID(vo.getUpdUsrId());

				o.setDELTFLG("D".equals(vo.getIbflag()) ? "Y" : null);

				collection.setUNNOArray(i++, o);
			}

			dataArea.setUNNOCollection(collection);
			imdg0010001.setDataArea(dataArea);
			headerType.setInstanceId(instanceId);
			imdg0010001.setEAIHeader(headerType);
			doc.setIMDG0010001(imdg0010001);
			eai = new WeblogicSendQClient(sendUrl, this.getClass());
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setDestination(dest);
			// eai.setMessage(doc); // bind message It is using for string
			// message objects.
			eai.setObj(doc); // The Object convert a String by toString() method
								// in Connector Module.
			log.info("imdg0010001 indtance id ::: " + headerType.getInstanceId());
			reString = eai.commit(instanceId);
			reString = instanceId;
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("EAIException : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error("Exception : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			eai.close();
		}
		return reString;
	}

	/**
	 * JMS send ScgImdgPckCdVO<br>
	 * <br>
	 * 
	 * @param List<ScgImdgPckCdVO> list
	 * @return String
	 * @throws DAOException
	 */
	public String sendDbIMDG0020001(List<ScgImdgPckCdVO> list) throws DAOException {

		String reString = "";
		TransferEAI eai = null;

		String sendUrl = "";
		String factory = "";
		String queue = "";

		try {
			// Request Start
			String dest = "IMDG002_0001";
			String instanceId = dest + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());

			sendUrl = SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL");
			factory = SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY");
			queue = SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE");

			IMDG0020001Document doc = IMDG0020001Document.Factory.newInstance();
			IMDG0020001 imdg0020001 = IMDG0020001.Factory.newInstance();

			EAIHeaderType headerType = imdg0020001.addNewEAIHeader();
			imdg0020001.setEAIHeader(headerType);
			IMDG0020001.DataArea dataArea = imdg0020001.addNewDataArea();

			PCKCDCollection collection = dataArea.addNewPCKCDCollection();
			int i = 0;
			for (ScgImdgPckCdVO vo : list) {
				IMDG0020001.DataArea.PCKCDCollection.PCKCD o = collection.addNewPCKCD();
				o.setCREDT(vo.getCreDt());
				o.setCREUSRID(vo.getCreUsrId());
				o.setDELTFLG(vo.getDeltFlg());
				o.setIMDGPCKCD(vo.getImdgPckCd());
				o.setIMDGPCKDESC(vo.getImdgPckDesc());
				o.setIMDGPCKTPCD(vo.getImdgPckTpCd());
				o.setPCKKNDCD(vo.getPckKndCd());
				o.setPCKMTRLTPCD(vo.getPckMtrlTpCd());
				o.setUPDDT(vo.getUpdDt());
				o.setUPDUSRID(vo.getUpdUsrId());
				collection.setPCKCDArray(i++, o);
			}

			dataArea.setPCKCDCollection(collection);
			imdg0020001.setDataArea(dataArea);
			headerType.setInstanceId(instanceId);
			imdg0020001.setEAIHeader(headerType);
			headerType.setInstanceId(instanceId);
			imdg0020001.setEAIHeader(headerType);
			doc.setIMDG0020001(imdg0020001);
			eai = new WeblogicSendQClient(sendUrl, this.getClass());
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setDestination(dest);
			// eai.setMessage(doc); // bind message It is using for string
			// message objects.
			eai.setObj(doc); // The Object convert a String by toString() method
								// in Connector Module.
			log.info("imdg0020001 indtance id ::: " + headerType.getInstanceId());
			reString = eai.commit(instanceId);
			reString = instanceId;
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("EAIException : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error("Exception : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			eai.close();
		}
		return reString;
	}

	/**
	 * JMS send ScgImdgSubsRskLblVO <br>
	 * <br>
	 * 
	 * @param List<ScgImdgSubsRskLblVO> list
	 * @return String
	 * @throws DAOException
	 */
	public String sendDbIMDG0030001(List<ScgImdgSubsRskLblVO> list) throws DAOException {

		String reString = "";
		TransferEAI eai = null;

		String sendUrl = "";
		String factory = "";
		String queue = "";

		try {
			// Request Start
			String dest = "IMDG003_0001";
			String instanceId = dest + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());

			sendUrl = SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL");
			factory = SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY");
			queue = SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE");

			IMDG0030001Document doc = IMDG0030001Document.Factory.newInstance();
			IMDG0030001 imdg0030001 = IMDG0030001.Factory.newInstance();

			EAIHeaderType headerType = imdg0030001.addNewEAIHeader();

			IMDG0030001.DataArea dataArea = imdg0030001.addNewDataArea();

			SUBSRSKLBLCollection collection = dataArea.addNewSUBSRSKLBLCollection();
			int i = 0;
			for (ScgImdgSubsRskLblVO vo : list) {
				IMDG0030001.DataArea.SUBSRSKLBLCollection.SUBRSKLBL o = collection.addNewSUBRSKLBL();
				o.setCREDT(vo.getCreDt());
				o.setCREUSRID(vo.getCreUsrId());
				o.setIMDGSUBSRSKLBLCD(vo.getImdgSubsRskLblCd());
				o.setIMDGUNNO(vo.getImdgUnNo());
				o.setIMDGUNNOSEQ(vo.getImdgUnNoSeq());
				o.setUPDDT(vo.getUpdDt());
				o.setUPDUSRID(vo.getUpdUsrId());
				o.setDELTFLG("D".equals(vo.getIbflag()) ? "Y" : null);
				collection.setSUBRSKLBLArray(i++, o);
			}

			dataArea.setSUBSRSKLBLCollection(collection);
			imdg0030001.setDataArea(dataArea);
			headerType.setInstanceId(instanceId);
			imdg0030001.setEAIHeader(headerType);
			doc.setIMDG0030001(imdg0030001);
			eai = new WeblogicSendQClient(sendUrl, this.getClass());
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setDestination(dest);
			// eai.setMessage(doc); // bind message It is using for string
			// message objects.
			eai.setObj(doc); // The Object convert a String by toString() method
								// in Connector Module.
			log.info("imdg0030001 indtance id ::: " + headerType.getInstanceId());
			reString = eai.commit(instanceId);
			reString = instanceId;
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("EAIException : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error("Exception : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			eai.close();
		}
		return reString;
	}

	/**
	 * JMS send ScgImdgClssCdVO <br>
	 * <br>
	 * 
	 * @param List<ScgImdgClssCdVO> list
	 * @return String
	 * @throws DAOException
	 */
	public String sendDbIMDG0040001(List<ScgImdgClssCdVO> list) throws DAOException {

		String reString = "";
		TransferEAI eai = null;

		String sendUrl = "";
		String factory = "";
		String queue = "";

		try {
			// Request Start
			String dest = "IMDG004_0001";
			String instanceId = dest + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());

			sendUrl = SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL");
			factory = SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY");
			queue = SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE");

			IMDG0040001Document doc = IMDG0040001Document.Factory.newInstance();
			IMDG0040001 imdg0040001 = IMDG0040001.Factory.newInstance();

			EAIHeaderType headerType = imdg0040001.addNewEAIHeader();

			IMDG0040001.DataArea dataArea = imdg0040001.addNewDataArea();

			CLSSSCDCollection collection = dataArea.addNewCLSSSCDCollection();
			int i = 0;
			for (ScgImdgClssCdVO vo : list) {
				IMDG0040001.DataArea.CLSSSCDCollection.CLSSCD o = collection.addNewCLSSCD();
				o.setCREDT(vo.getCreDt());
				o.setCREUSRID(vo.getCreUsrId());
				o.setDELTFLG(vo.getDeltFlg());
				o.setIMDGCLSSCD(vo.getImdgClssCd());
				o.setIMDGCLSSCDDESC(vo.getImdgClssCdDesc());
				o.setUPDDT(vo.getUpdDt());
				o.setUPDUSRID(vo.getUpdUsrId());
				collection.setCLSSCDArray(i++, o);
			}

			dataArea.setCLSSSCDCollection(collection);
			imdg0040001.setDataArea(dataArea);
			headerType.setInstanceId(instanceId);
			imdg0040001.setEAIHeader(headerType);
			doc.setIMDG0040001(imdg0040001);
			eai = new WeblogicSendQClient(sendUrl, this.getClass());
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setDestination(dest);
			// eai.setMessage(doc); // bind message It is using for string
			// message objects.
			eai.setObj(doc); // The Object convert a String by toString() method
								// in Connector Module.

			log.info("IMDG0040001 indtance id ::: " + headerType.getInstanceId());
			reString = eai.commit(instanceId);
			reString = instanceId;
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("EAIException : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error("Exception : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			eai.close();
		}
		return reString;
	}

	/**
	 * JMS SCG_PRNR_APRO_RQST return result value <br>
	 * <br>
	 * 
	 * @param String result
	 * @param String lifid
	 * @return String
	 * @throws DAOException
	 */
	public String sendDbIMDG005R001(String result, String lifid) throws DAOException {

		String reString = "";
		TransferEAI eai = null;

		String sendUrl = "";
		String factory = "";
		String queue = "";
		try {
			// Request Start
			String dest = "IMDG005_R001";
			String instanceId = dest + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date());

			sendUrl = SubSystemConfigFactory.get("COM.ALPSJ.JMS.SEND.URL");
			factory = SubSystemConfigFactory.get("COM.ALPSJ.JMS.FACTORY");
			queue = SubSystemConfigFactory.get("COM.ALPSJ.JMS.QUEUE");

			IMDG005R001Document doc = IMDG005R001Document.Factory.newInstance();
			IMDG005R001 imdg005R001 = IMDG005R001.Factory.newInstance();

			EAIHeaderType headerType = imdg005R001.addNewEAIHeader();

			IMDG005R001.DataArea dataArea = imdg005R001.addNewDataArea();

			ApprovalREQReplyCollection collection = dataArea.addNewApprovalREQReplyCollection();
			
			IMDG005R001.DataArea.ApprovalREQReplyCollection.ApprovREQReply o = collection.addNewApprovREQReply();
			o.setIFSCSFLG(result);
			o.setLIFID(lifid);
			collection.setApprovREQReply(o);

			dataArea.setApprovalREQReplyCollection(collection);
			imdg005R001.setDataArea(dataArea);
			headerType.setInstanceId(instanceId);
			imdg005R001.setEAIHeader(headerType);
			doc.setIMDG005R001(imdg005R001);
			eai = new WeblogicSendQClient(sendUrl, this.getClass());
			eai.setFactory(factory);
			eai.setQueue(queue);
			eai.setDestination(dest);
			// eai.setMessage(doc); // bind message It is using for string
			// message objects.
			eai.setObj(doc); // The Object convert a String by toString() method
								// in Connector Module.

			log.info("IMDG005R001 indtance id ::: " + headerType.getInstanceId());
			reString = eai.commit(instanceId);
			reString = instanceId;
		} catch (EAIException e) {
			eai.rollback(e);
			log.error("EAIException : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error("Exception : " + e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} finally {
			eai.close();
		}
		return reString;
	}

}
