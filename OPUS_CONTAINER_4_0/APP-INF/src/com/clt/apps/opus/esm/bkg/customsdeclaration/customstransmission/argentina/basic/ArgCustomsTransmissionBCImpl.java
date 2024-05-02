/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ArgCustomsTransmissionBCImpl.java
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2014.12.31
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2014.12.31 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.integration.ArgCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgElInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgTransmitBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.ArgTransmitCmListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.argentina.vo.BkgCstmsArgSndLogVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0017EventResponse,PanamaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ArgCustomsTransmissionBCImpl extends BasicCommandSupport implements ArgCustomsTransmissionBC {

	// Database Access Object
	private transient ArgCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public ArgCustomsTransmissionBCImpl() {
		dbDao = new ArgCustomsTransmissionDBDAO();
	}
	
	/**
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param manifestTransmitVOs
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String transmitManifest(ArgManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException
	{
		StringBuffer flatFile = new StringBuffer();
		StringBuffer blFlatFile = new StringBuffer();
		StringBuffer vslFlatFile = new StringBuffer();

		try
		{
			BookingUtil utilBC = new BookingUtil();
			String strHeader = utilBC.searchCstmsEdiHeaderNew("AR_CUSTOMS") + "\n";
			List<BkgCstmsArgSndLogVO> addList = new ArrayList<BkgCstmsArgSndLogVO>();
			String befBlNo = "";
			
			for (int i=0; i< manifestTransmitVOs.length; i++)
			{
				if (befBlNo.equals(manifestTransmitVOs[i].getBlNo())) continue;
				ArgTransmitBlInfoVO blInfo = dbDao.searchTransmitBlInfo(manifestTransmitVOs[i]);
				befBlNo = manifestTransmitVOs[i].getBlNo();
				
				if (i == 0)
				{
					// VSL INFO
					vslFlatFile.append("VSL_CODE:").append(blInfo.getVslCode()).append("\n");
					vslFlatFile.append("VSL_NAME:").append(blInfo.getVslName()).append("\n");
					vslFlatFile.append("VSL_NATION_CD:").append(blInfo.getVslNationCd()).append("\n");
					vslFlatFile.append("EX_IND:").append(blInfo.getExInd()).append("\n");
					vslFlatFile.append("TERMINAL_CD:").append(blInfo.getTerminalCd()).append("\n");
					vslFlatFile.append("ETA:").append(blInfo.getEta()).append("\n");
					vslFlatFile.append("ETD:").append(blInfo.getEtd()).append("\n");
					vslFlatFile.append("FOREIGN_NATION_CD:").append(blInfo.getForeignNationCd()).append("\n");
				}
				blFlatFile = new StringBuffer();
				// BL INFO
				blFlatFile.append("{BL_INFO").append("\n");
				blFlatFile.append("BLNBR:").append(blInfo.getBlnbr()).append("\n");
				blFlatFile.append("BLPOL:").append(blInfo.getBlpol()).append("\n");
				blFlatFile.append("BLPOD:").append(blInfo.getBlpod()).append("\n");
				blFlatFile.append("VSPOL:").append(blInfo.getVspol()).append("\n");
				blFlatFile.append("VSPOD:").append(blInfo.getVspod()).append("\n");
				blFlatFile.append("RD_TERM:").append(blInfo.getRdTerm()).append("\n");
				blFlatFile.append("CONSOLIDATE_IND:").append(blInfo.getConsolidateInd()).append("\n");
				blFlatFile.append("TR_IND:").append(blInfo.getTrInd()).append("\n");
				blFlatFile.append("COMMODITY_CD:").append(blInfo.getCommodityCd()).append("\n");
				blFlatFile.append("BLPKG:").append(blInfo.getBlpkg()).append("\n");
				blFlatFile.append("BLWGT:").append(blInfo.getBlwgt()).append("\n");
				blFlatFile.append("BLWGT_UNIT:").append(blInfo.getBlwgtUnit()).append("\n");
				blFlatFile.append("DESC:").append(blInfo.getBDesc()).append("\n");
				blFlatFile.append("MARKNO:").append(blInfo.getMarkno()).append("\n");
				blFlatFile.append("SHIP_ID_IND:").append(blInfo.getShipIdInd()).append("\n");

				blFlatFile.append("{BL_PARTY_INFO").append("\n");
				blFlatFile.append("BL_PT_TYPE:").append(blInfo.getShpBlPtType()).append("\n");
				blFlatFile.append("BL_PT_NAME:").append(blInfo.getShpBlPtName()).append("\n");
				blFlatFile.append("BL_PT_ADDRESS:").append(blInfo.getShpBlPtAddress()).append("\n");
				blFlatFile.append("BL_PT_STREET:").append(blInfo.getShpBlPtStreet()).append("\n");
				blFlatFile.append("BL_PT_CITY:").append(blInfo.getShpBlPtCity()).append("\n");
				blFlatFile.append("BL_PT_POSTAL_CD:").append(blInfo.getShpBlPtPostalCd()).append("\n");
				blFlatFile.append("BL_PT_CNT_CD:").append(blInfo.getShpBlPtCntCd()).append("\n");
				blFlatFile.append("BL_PT_TAX_TYPE:").append(blInfo.getShpBlPtTaxType()).append("\n");
				blFlatFile.append("BL_PT_TAX_ID:").append(blInfo.getShpBlPtTaxId()).append("\n");
				blFlatFile.append("}BL_PARTY_INFO").append("\n");
				
				blFlatFile.append("{BL_PARTY_INFO").append("\n");
				blFlatFile.append("BL_PT_TYPE:").append(blInfo.getCneBlPtType()).append("\n");
				blFlatFile.append("BL_PT_NAME:").append(blInfo.getCneBlPtName()).append("\n");
				blFlatFile.append("BL_PT_ADDRESS:").append(blInfo.getCneBlPtAddress()).append("\n");
				blFlatFile.append("BL_PT_STREET:").append(blInfo.getCneBlPtStreet()).append("\n");
				blFlatFile.append("BL_PT_CITY:").append(blInfo.getCneBlPtCity()).append("\n");
				blFlatFile.append("BL_PT_POSTAL_CD:").append(blInfo.getCneBlPtPostalCd()).append("\n");
				blFlatFile.append("BL_PT_CNT_CD:").append(blInfo.getCneBlPtCntCd()).append("\n");
				blFlatFile.append("BL_PT_TAX_TYPE:").append(blInfo.getCneBlPtTaxType()).append("\n");
				blFlatFile.append("BL_PT_TAX_ID:").append(blInfo.getCneBlPtTaxId()).append("\n");
				blFlatFile.append("}BL_PARTY_INFO").append("\n");
				
				if (!"".equals(blInfo.getNfyBlPtName()))
				{
					blFlatFile.append("{BL_PARTY_INFO").append("\n");
					blFlatFile.append("BL_PT_TYPE:").append(blInfo.getNfyBlPtType()).append("\n");
					blFlatFile.append("BL_PT_NAME:").append(blInfo.getNfyBlPtName()).append("\n");
					blFlatFile.append("BL_PT_ADDRESS:").append(blInfo.getNfyBlPtAddress()).append("\n");
					blFlatFile.append("BL_PT_STREET:").append(blInfo.getNfyBlPtStreet()).append("\n");
					blFlatFile.append("BL_PT_CITY:").append(blInfo.getNfyBlPtCity()).append("\n");
					blFlatFile.append("BL_PT_POSTAL_CD:").append(blInfo.getNfyBlPtPostalCd()).append("\n");
					blFlatFile.append("BL_PT_CNT_CD:").append(blInfo.getNfyBlPtCntCd()).append("\n");
					blFlatFile.append("BL_PT_TAX_TYPE:").append(blInfo.getNfyBlPtTaxType()).append("\n");
					blFlatFile.append("BL_PT_TAX_ID:").append(blInfo.getNfyBlPtTaxId()).append("\n");
					blFlatFile.append("}BL_PARTY_INFO").append("\n");
				}
				// CM INFO
				List<ArgTransmitCmListVO> cmList = dbDao.searchTransmitCmList(manifestTransmitVOs[i]);
				for (int j = 0; j < cmList.size(); j++)
				{
					ArgTransmitCmListVO cmInfo = cmList.get(j);
					
					blFlatFile.append("{GOODS_INFO").append("\n");
					blFlatFile.append("CM_PKG:").append(cmInfo.getCmPkg()).append("\n");
					blFlatFile.append("CM_PKGU:").append(cmInfo.getCmPkgu()).append("\n");
					blFlatFile.append("CM_WGT:").append(cmInfo.getCmWgt()).append("\n");
					blFlatFile.append("CM_WGT_UNIT:").append(cmInfo.getCmWgtUnit()).append("\n");
					blFlatFile.append("CM_HSCODE:").append(cmInfo.getCmHscode()).append("\n");
					blFlatFile.append("CM_DESC:").append(cmInfo.getCmDesc()).append("\n");
					blFlatFile.append("CM_MARKNO:").append(cmInfo.getCmMarkno()).append("\n");
					blFlatFile.append("CM_CNTRNBR:").append(cmInfo.getCmCntrnbr()).append("\n");
					blFlatFile.append("CM_CNTRSIZE:").append(cmInfo.getCmCntrsize()).append("\n");
					blFlatFile.append("}GOODS_INFO").append("\n");
				}
				
				// ELNO
				List<ArgElInfoVO> elList = dbDao.searchElNoList(manifestTransmitVOs[i]);
				for (int j = 0; j < elList.size(); j++)
				{
					blFlatFile.append("{ELNO").append("\n");
					blFlatFile.append("ELNO:").append(elList.get(j).getElNo()).append("\n");
					blFlatFile.append("}ELNO").append("\n");
				}
				blFlatFile.append("}BL_INFO").append("\n");
				
				flatFile.append(blFlatFile.toString());
				
				// LOG 
				BkgCstmsArgSndLogVO log = new BkgCstmsArgSndLogVO();
				log.setBlNo(manifestTransmitVOs[i].getBlNo());
				log.setIoBndCd(manifestTransmitVOs[i].getModeType());
				log.setEdiSndMsgCtnt(strHeader + vslFlatFile.toString() + blFlatFile.toString());
				log.setUpdUsrId(account.getUsr_id());
				addList.add(log);
			}

			dbDao.addBkgCstmsArgSndLog(addList);
			flatFile.insert(0, strHeader + vslFlatFile.toString());
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}
	
	/**
	 * View Send Log File
	 * 
	 * @param bkgCstmsArgSndLogVO
	 * @return List<BkgCstmsArgSndLogVO>
	 * @throws EventException
	 */
	public List<BkgCstmsArgSndLogVO> searchCstmsArgSndLog(BkgCstmsArgSndLogVO bkgCstmsArgSndLogVO) throws EventException {

		List<BkgCstmsArgSndLogVO> list = new ArrayList<BkgCstmsArgSndLogVO>();
		
		try {
			BkgCstmsArgSndLogVO sndVo = dbDao.searchCstmsArgSndLog(bkgCstmsArgSndLogVO);
			if (sndVo != null)
			{
				StringTokenizer token = new StringTokenizer(sndVo.getEdiSndMsgCtnt(), "\n");
				while (token.hasMoreTokens())
				{
					BkgCstmsArgSndLogVO vo = new BkgCstmsArgSndLogVO();
					vo.setEdiSndMsgCtnt(token.nextToken());
					list.add(vo);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}
}