/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmVslBlkDBDAO
 *@FileTitle : ENIS MDM Vessel Bulk Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-01-19
 *@LastModifier : Seyeong Yoon
 *@LastVersion : 1.0
 * 2010-01-19 Seyeong Yoon
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.common.mdmSync.jms.integration.ReceiveQueueMdmVslBlkDBDAO;
import com.hanjin.apps.alps.common.mdmSync.jms.vo.MdmVslBlkVO;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.irep.mdm.ActionCodeEnumerationType;
import com.hanjin.irep.mdm.ApplicationAreaType;
import com.hanjin.irep.mdm.MDM0230001Document;
import com.hanjin.irep.mdm.MDM0230001Document.MDM0230001;


/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 *  ENIS-MDM0230001에 대한 JMS Inbound 처리를 담당한다.<br>
 * 
 * @author Seyeong Yoon
 * @see ReceiveQueueBC,MDM0230001Document 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVslBlkBCImpl extends BasicCommandSupport implements ReceiveQueueBC {

	
	private transient ReceiveQueueMdmVslBlkDBDAO dbDao = null;
	private String msgCreDt = "";
	private String opCd = "";
	
	/** MsgCreDt getter 메서드.<br>
	 */
	public String getMsgCreDt() {
		return msgCreDt;
	}
	
	/** MsgCreDt setter 메서드.<br>
	 * @param msgCreDt String
	 */
	public void setMsgCreDt(String msgCreDt) {
		this.msgCreDt = msgCreDt;
	}

	/** opCd getter 메서드.<br>
	 */
	public String getOpCd() {
		return opCd;
	}

	/** opCd setter 메서드.<br>
	 * @param opCd String
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
		
	/** ReceiveQueueMDM_VslBlk_BCImpl 생성자<br>
	 * DBDAO Object를 생성
	 */
	public ReceiveQueueMdmVslBlkBCImpl() {
		dbDao = new ReceiveQueueMdmVslBlkDBDAO();
	}

	/** MDM으로 부터 받은 XML 데이타를 parsing 하여 VO에 저장  
	 * @param xmlObject XmlObject
	 * @throws 
	 */
	public Collection<MdmVslBlkVO> receiveMDMTB(XmlObject xmlObject) {
		
		MdmVslBlkVO mdmVslBlkVO = null;
		List<MdmVslBlkVO> mdmVslBlkVOs = new ArrayList<MdmVslBlkVO>();
		
		MDM0230001Document mdmDoc = (MDM0230001Document) xmlObject;
		MDM0230001 mdm = mdmDoc.getMDM0230001();

		ApplicationAreaType app = mdm.getApplicationArea();
		ActionCodeEnumerationType.Enum ace = app.getOpCd();
		
		log.info("\n //--->>> OPERATION CODE : " + ace.toString());
		setOpCd(ace.toString());

		log.info("\n //--->>> MESSAGE CREATION DATE : " + app.getMsgCreDt());
		setMsgCreDt(app.getMsgCreDt());

		// /===== Collect received data & Allocate them to Collection models// =====
		com.hanjin.irep.mdm.MDM0230001Document.MDM0230001.DataArea data = mdm.getDataArea();
		
		if (data != null) {
			mdmVslBlkVO = new MdmVslBlkVO();
			mdmVslBlkVO.setVslCd			 (data.getVslCd			    ());
			mdmVslBlkVO.setVslClssFlg        (data.getVslClssFlg        ());
			mdmVslBlkVO.setVslEngNm          (data.getVslEngNm          ());
			mdmVslBlkVO.setVslKrnNm          (data.getVslKrnNm          ());
			mdmVslBlkVO.setFoilCapa          (data.getFoilCapa          ());
			mdmVslBlkVO.setDoilCapa          (data.getDoilCapa          ());
			mdmVslBlkVO.setFrshWtrCapa       (data.getFrshWtrCapa       ());
			mdmVslBlkVO.setGrnTongCapa       (data.getGrnTongCapa       ());
			mdmVslBlkVO.setBailTongCapa      (data.getBailTongCapa      ());
			mdmVslBlkVO.setTnkTongCapa       (data.getTnkTongCapa       ());
			mdmVslBlkVO.setCallSgnNo         (data.getCallSgnNo         ());
			mdmVslBlkVO.setRgstPortCd        (data.getRgstPortCd        ());
			mdmVslBlkVO.setVslBldrNm         (data.getVslBldrNm         ());
			mdmVslBlkVO.setLoaLen            (data.getLoaLen            ());
			mdmVslBlkVO.setSmrDrftHgt        (data.getSmrDrftHgt        ());
			mdmVslBlkVO.setLgtShpTongWgt     (data.getLgtShpTongWgt     ());
			mdmVslBlkVO.setGrsRgstTongWgt    (data.getGrsRgstTongWgt    ());
			mdmVslBlkVO.setNetRgstTongWgt    (data.getNetRgstTongWgt    ());
			mdmVslBlkVO.setPnmGtWgt          (data.getPnmGtWgt          ());
			mdmVslBlkVO.setPnmNetTongWgt     (data.getPnmNetTongWgt     ());
			mdmVslBlkVO.setSuzGtWgt          (data.getSuzGtWgt          ());
			mdmVslBlkVO.setSuzNetTongWgt     (data.getSuzNetTongWgt     ());
			mdmVslBlkVO.setMnEngMkrNm        (data.getMnNznMkrNm        ());
			mdmVslBlkVO.setMnEngBhpPwr       (data.getMnNznBhpPwr       ());
			mdmVslBlkVO.setVslOwnIndCd       (data.getVslOwnIndCd       ());
			mdmVslBlkVO.setVslRgstCntCd      (data.getVslRgstCntCd      ());
			mdmVslBlkVO.setVslBldDt          (data.getVslBltDt          ());
			mdmVslBlkVO.setLoaUtCd           (data.getLoaUtCd           ());
			mdmVslBlkVO.setVslBmWdt          (data.getVslBmWdt          ());
			mdmVslBlkVO.setVslBmUtCd         (data.getVslBmUtCd         ());
			mdmVslBlkVO.setVslOwnCustCntCd   (data.getVslOwnCustCntCd   ());
			mdmVslBlkVO.setVslOwnCustSeq     (data.getVslOwnCustSeq     ());
			mdmVslBlkVO.setVslCgoGrNm        (data.getVslCgoGrNm        ());
			mdmVslBlkVO.setVslCapaUtCd       (data.getVslCapaUtCd       ());
			mdmVslBlkVO.setVslDwtUtCd        (data.getVslDwtUtCd        ());
			mdmVslBlkVO.setBlkCrrTpCd        (data.getBlkCarrTpCd       ());
			mdmVslBlkVO.setVslDrftUtCd       (data.getVslDrftUtCd       ());
			mdmVslBlkVO.setSmrTpcTonWgt      (data.getSmrTpcTonWgt      ());
			mdmVslBlkVO.setWntTpcTonWgt      (data.getWntTpcTonWgt      ());
			mdmVslBlkVO.setTropTpcTonWgt     (data.getTropiTpcTonWgt    ());
			mdmVslBlkVO.setBlstWgtSpd1       (data.getBlstWgtSpd1       ());
			mdmVslBlkVO.setLdnWgtSpd1        (data.getLdnWgtSpd1        ());
			mdmVslBlkVO.setBlstWgtSpd2       (data.getBlstWgtSpd2       ());
			mdmVslBlkVO.setLdnWgtSpd2        (data.getLdnWgtSpd2        ());
			mdmVslBlkVO.setFoilBlstCsm1      (data.getFoilBlstCsm1      ());
			mdmVslBlkVO.setFoilLdnCsm1       (data.getFoilLdnCsm1       ());
			mdmVslBlkVO.setFoilBlstCsm2      (data.getFoilBlstCsm2      ());
			mdmVslBlkVO.setFoilLdnCsm2       (data.getFoilLdnCsm2       ());
			mdmVslBlkVO.setPortFoilTonCsm    (data.getPortFoilTonCsm    ());
			mdmVslBlkVO.setSeaDoilTonCsm     (data.getSeaDoilTonCsm     ());
			mdmVslBlkVO.setPortIdleDoilTonCsm(data.getPortIdleDoilTonCsm());
			mdmVslBlkVO.setPortWrkDoilTonCsm (data.getPortWrkDoilTonCsm ());
			mdmVslBlkVO.setVslBunkUtCd       (data.getVslBunkUtCd       ());
			mdmVslBlkVO.setConsTonWgt        (data.getCstntTonWgt       ());
			mdmVslBlkVO.setEntTpCd           (data.getEntTpCd           ());
			mdmVslBlkVO.setWntDrftHgt        (data.getWntDrftHgt        ());
			mdmVslBlkVO.setTropDrftHgt       (data.getTropiDrftHgt      ());
			mdmVslBlkVO.setSmrDwtWgt         (data.getSmrDwtWgt         ());
			mdmVslBlkVO.setWntDwtWgt         (data.getWntDwtWgt         ());
			mdmVslBlkVO.setTropDwtWgt        (data.getTropiDwtWgt       ());
			mdmVslBlkVO.setVslHtchKnt        (data.getVslHtchKnt        ());
			mdmVslBlkVO.setVslHldKnt         (data.getVslHldKnt         ());
			mdmVslBlkVO.setBlkVslClssCd      (data.getBlkVslClssCd      ());
			mdmVslBlkVO.setHtFoilCsm         (data.getHtFoilCsm         ());
			mdmVslBlkVO.setPmpOilKndCd       (data.getPmpOilKndCd       ());
			mdmVslBlkVO.setPmpOilCsm         (data.getPmpOilCsm         ());
			mdmVslBlkVO.setClnOilKndCd       (data.getClnOilKndCd       ());
			mdmVslBlkVO.setClnOilCsm         (data.getClnOilCsm         ());
			mdmVslBlkVO.setLnchDt            (data.getLnchDt            ());
			mdmVslBlkVO.setRgstDt            (data.getRgstDt            ());
			mdmVslBlkVO.setImoNo             (data.getImoNo             ());
			mdmVslBlkVO.setVslRmk            (data.getVslRmk            ());
			mdmVslBlkVO.setBlkMnEngTpCd      (data.getBlkMnNznTpCd      ());
			mdmVslBlkVO.setCreUsrId          (data.getCreUsrId          ());
			mdmVslBlkVO.setCreDt             (data.getCreDt             ());
			mdmVslBlkVO.setUpdUsrId          (data.getUpdUsrId          ());
			mdmVslBlkVO.setUpdDt             (data.getUpdDt             ());
			mdmVslBlkVO.setDeltFlg           (data.getDeltFlg           ());
			mdmVslBlkVO.setVslOwnCustNm      (data.getVslOwnCustNm      ());
			mdmVslBlkVO.setBlkVslDeDt        (data.getBlkVslDeDt        ());

			mdmVslBlkVOs.add(mdmVslBlkVO);
		}
		return mdmVslBlkVOs;
	}

	/** Create or Remove  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean createMDMTB(Collection models) throws DAOException {
		boolean isSuccessful = false;
		
		try {
			MdmVslBlkVO model = null;
			
			Iterator<MdmVslBlkVO> itr = models.iterator();
			
			while (itr.hasNext()) {
				model = (MdmVslBlkVO)itr.next();
			}
			
			String vsl_cd = model.getVslCd();
			
			int insCnt = 0;
			boolean isNew = dbDao.searchMdmVslBlk(vsl_cd);
			
			if ( isNew ) insCnt = dbDao.addMdmVslBlk(model);
			else insCnt = dbDao.modifyMdmVslBlk(model);
			
			if( insCnt > 0 ) isSuccessful = true;
			
		}catch(DAOException de){
			log.error("err " + de.toString(), de);
			throw de;
		}
		
		return  isSuccessful;
	}

	/** DBDAO의 addMDM_CHKMAIL_ADDR메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public void ctrlMDMTB(Collection models) throws DAOException{
		
		String OpCd = getOpCd();
		
		if (OpCd.equals("C") || OpCd.equals("U"))
			OpCd = "U";
		
		boolean isSuccessFlag = false;
		
		switch (OpCd.charAt(0)) {
		case 'U':
			
			isSuccessFlag = createMDMTB(models);
			log.info(" (createMDM_VslBlk) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;

		case 'D':
			
			isSuccessFlag = removeMDMTB(models);
			log.info(" (removeMDM_VslBlk) isSucessFlag : "
					+ (isSuccessFlag ? "true" : "false"));
			break;
		}
	}

	/** DBDAO의 removeMDM_CHKMAIL_ADDR메소드 호출  
	 * @param models Collection
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMDMTB(Collection models) throws DAOException{
		boolean isSuccessful = false;
		int delCnt = 0;
		try {
			MdmVslBlkVO model = null;
			Iterator<MdmVslBlkVO> itr = models.iterator();
			while (itr.hasNext()) {
				model = (MdmVslBlkVO)itr.next();
			}
			
			delCnt = dbDao.removeMdmVslBlk(model);
			
			if( delCnt > 0 ) isSuccessful = true;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw de;
		}
		return isSuccessful;
	}
}
