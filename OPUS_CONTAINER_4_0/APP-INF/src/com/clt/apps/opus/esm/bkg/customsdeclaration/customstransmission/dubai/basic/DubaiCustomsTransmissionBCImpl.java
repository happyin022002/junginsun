/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DubaiCustomsTransmissionBCImpl.java
 *@FileTitle : DubaiCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.02
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.integration.DubaiCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiCntrMfInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration business logic handling.<br>
 * 
 * @author Kyoung Jong Yun
 * @see ESM_BKG_1085EventResponse,BrcsCustomsTransmissionBC each DAO class reference
 * @since J2EE 1.6
 */
public class DubaiCustomsTransmissionBCImpl extends BasicCommandSupport implements DubaiCustomsTransmissionBC {

	// Database Access Object
	private transient DubaiCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CndCustomsTransmissionBCImpl object creation<br>
	 * CndCustomsTransmissionDBDAO creation.<br>
	 */
	public DubaiCustomsTransmissionBCImpl() {
		dbDao = new DubaiCustomsTransmissionDBDAO();
	}

	/**
	 * for customs declaration, FlatFile creation.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account)
			throws EventException {

		// BL LIST
		DubaiManifestTransmitVO[] dubaiManifestTransmitVOs = (DubaiManifestTransmitVO[]) manifestTransmitVOs;
		// FLATFILE
		StringBuffer flatFile = new StringBuffer();
		// vessel info
		DubaiVvdInfoVO dubaiVvdInfoVO = null;
		// BL info
		DubaiBlInfoVO dubaiBlInfoVO = null;
		// container info
		DubaiCntrInfoVO dubaiCntrInfoVO = null;
		// container info list
		List<DubaiCntrInfoVO> dubaiCntrInfoVOList = null;
		// container MFinfo
		DubaiCntrMfInfoVO dubaiCntrMfInfoVO = null;
		// container MFinfo list
		List<DubaiCntrMfInfoVO> dubaiCntrMfInfoVOList = null;
		int blCnt = 0;
		int cntrCnt = 0;
		try
		{
			for (int i = 0; i < dubaiManifestTransmitVOs.length; i++)
			{
				if (i == 0)
				{
					// (1) vessel info
					dubaiVvdInfoVO = dbDao.searchFlatFileVvdInfo(dubaiManifestTransmitVOs[i]);
					flatFile.append(setFlatFile("VOY", false));
					// 1. LINE CODE
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getDuLineId(), false));
					// 2. VPUAGE AGEMT CPDE
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getDuVoyAgnId(), false));
					// 3. VESSEL NAME
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getVslNm(), false));
					// 4. AGENT'S VOYAGE NUMBER
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getSkdVoyNo() + dubaiVvdInfoVO.getSkdDirCd(), false));
					// 5. PORT CODE OF DISCHARGE
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getPodCd(), false));
					// 6. EXPECTED TO ARRIVE DATE
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getEtaDt(), false));
					// 7. ROTATION NUMBER
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getDuRotnNo(), false));
					// 8. MESSAGE TYPE
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getDuMsgTpId(), false));
					// 9. NO OF INSTALMENT
//					flatFile.append(setFlatFile(dubaiVvdInfoVO.getDuInstlNo(), false));
					// 10. AGENT'S MANIFEST SEQUENCE NUMBER
					flatFile.append(setFlatFile(dubaiVvdInfoVO.getDuMfSeqNo(), true));
				}

				// (2) BLinfo
				dubaiBlInfoVO = dbDao.searchFlatFileBlInfo(dubaiManifestTransmitVOs[i]);
				if (dubaiBlInfoVO != null)
				{
					flatFile.append(setFlatFile("BOL", false));
					// 1. BILL OF LADING NO
					flatFile.append(setFlatFile(dubaiBlInfoVO.getBlNo(), false));
					// 2. BOX/PARTNERING LINE CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuLineId(), false));
					// 3. BOX/PARTERING AGENT CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuVoyAgnId(), false));
					// 4. PORT CODE OF ORIGIN
					flatFile.append(setFlatFile(dubaiBlInfoVO.getPorCd(), false));
					// 5. PORT CODE OF LOADING
					flatFile.append(setFlatFile(dubaiBlInfoVO.getPolCd(), false));
					// 6. PORT CODE OF DISCHARGE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getPodCd(), false));
					// 7. PORT CODE OF DESTINATION
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDelCd(), false));
					// 8. DATE OF LOADING
					flatFile.append(setFlatFile("", false));
					// 9. MANIFEST REGISTRATION NUMBER
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuMfNo(), false));
					// 10. TRADE CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuTrdCd(), false));
					// 11. TRANS-SHIPMENT MODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuTsModCd(), false));
					// 12. BILL OF LADING OWNER NAME
					flatFile.append(setFlatFile("", false));
					// 13.BILL OF LADING OWNER ADDRESS
					flatFile.append(setFlatFile("", false));
					// 14. CARGO CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuCgoCd(), false));
					// 15. CONSOLIDATED CARGO INDICATOR
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCnslCgoFlg(), false));
					// 16. STORAGE REQUEST CODE
					flatFile.append(setFlatFile("", false));
					// 17. CONTAINER SERVICE TYPE(Carriage Terms of the containers)
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuCntrSvcTpCd(), false));
					// 18. COUNTRY OF ORIGIN
					flatFile.append(setFlatFile(dubaiBlInfoVO.getOrgCntCd(), false));
					// 19. ORGINAL CONSIGNEE NAME
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCOrgCustNm(), false));
					// 20. ORGINAL CONSIGNEE ADDRESS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCOrgCustAddr(), false));
					// 21. ORGINAL VESSEL NAME
					flatFile.append(setFlatFile(dubaiBlInfoVO.getOrgVslNm(), false));
					// 22. ORGINAL VOYAGE NUMBER
					flatFile.append(setFlatFile(dubaiBlInfoVO.getOrgSkdVoyNo() + dubaiBlInfoVO.getOrgSkdDirCd(), false));
					// 23. ORGINAL BOL NUMBER
					flatFile.append(setFlatFile(dubaiBlInfoVO.getOrgBlNo(), false));
					// 24. ORGINAL SHIPPER NAME
					flatFile.append(setFlatFile(dubaiBlInfoVO.getSOrgCustNm(), false));
					// 25. ORGINAL SHIPPER ADDRESS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getSOrgCustAddr(), false));
					// 26. SHIPPER NAME
					flatFile.append(setFlatFile(dubaiBlInfoVO.getSCustNm(), false));
					// 27. SHIPPER ADDRESS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getSCustAddr(), false));
					// 28. SHIPPER COUNTRY CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getSCustCntCd(), false));
					// 29. CONSIGNEE CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCDuCustId(), false));
					// 30. CONSIGNEE NAME
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCCustNm(), false));
					// 31. CONSIGNEE ADDRESS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCCustAddr(), false));
					// 32. NOTIFY1 CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getNDuCustId(), false));
					// 33. NOTIFY1 NAME
					flatFile.append(setFlatFile(dubaiBlInfoVO.getNCustNm(), false));
					// 34. NOTIFY1 ADDRESS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getNCustAddr(), false));
					// 35. NOTIFY2 CODE
					flatFile.append(setFlatFile("", false));
					// 36. NOTIFY2 NAME
					flatFile.append(setFlatFile("", false));
					// 37. NOTIFY2 ADDRESS
					flatFile.append(setFlatFile("", false));
					// 38. NOTIFY3 CODE
					flatFile.append(setFlatFile("", false));
					// 39. NOTIFY3 NAME
					flatFile.append(setFlatFile("", false));
					// 40. NOTIFY3 ADDRESS
					flatFile.append(setFlatFile("", false));
					// 41. MARKS & NUMBERS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getMkNoCtnt(), false));
					// 42. COMMODITY CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuCmdtCd(), false));
					// 43. COMMODITY DESCRIPTION
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCmdtDesc(), false));
					// 44. PACKAGES
					flatFile.append(setFlatFile(dubaiBlInfoVO.getPckQty(), false));
					// 45. PACKAGE TYPE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuPckDesc(), false));
					// 46. PACKAGE TYPE CODE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuPckTpCd(), false));
					// 47. CONTAINER NUMBER
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCntrNo(), false));
					// 48. CHECK DIGIT
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCheckDigit(), false));
					// 49. NO OF CONTAINERS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCntrKnt(), false));
					// 50. NO. OF TEUS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getBkgTeuQty(), false));
					// 51. TOTAL TARE WEIGHT IN MT
					flatFile.append(setFlatFile(dubaiBlInfoVO.getTareWgt(), false));
					// 52. CARGO WEIGHT IN KG
					flatFile.append(setFlatFile(dubaiBlInfoVO.getCgoWgt(), false));
					// 53. GROSS WEIGHT IN KG
					flatFile.append(setFlatFile(dubaiBlInfoVO.getGrsWgt(), false));
					// 54. CARGO VOLUME IN CUBICMETRE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getMeasQty(), false));
					// 55. TOTAL QUANTITY
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuTtlQty(), false));
					// 56. FREIGHT DTONNE
					flatFile.append(setFlatFile(dubaiBlInfoVO.getDuFrtWgt(), false));
					// 57. NO OF PALLETS
					flatFile.append(setFlatFile(dubaiBlInfoVO.getPltQty(), false));
					// 58. SLAC INDICATOR
					flatFile.append(setFlatFile("", false));
					// 59. CONTRACT CARRIAGE CONDITION
					flatFile.append(setFlatFile("", false));
					// 60. REMARKS
					flatFile.append(setFlatFile("", true));
					blCnt++;
				}
				// (3) container info
				dubaiCntrInfoVOList = dbDao.searchFlatFileCntrList(dubaiManifestTransmitVOs[i]);
				for (int cntrIdx = 0; cntrIdx < dubaiCntrInfoVOList.size(); cntrIdx++)
				{
					dubaiCntrInfoVO = dubaiCntrInfoVOList.get(cntrIdx);
					flatFile.append(setFlatFile("CTR", false));
					// 1. CONTAINER NUMBER
					flatFile.append(setFlatFile(dubaiCntrInfoVO.getCntrNo(), false));
					// 2. CHECK DIGIT
					flatFile.append(setFlatFile(dubaiCntrInfoVO.getCheckDigit(), false));
					// 3. TARE WEIGHT IN MT
					flatFile.append(setFlatFile(dubaiCntrInfoVO.getCntrTareWgt(), false));
					// 4. SEAL NO
					flatFile.append(setFlatFile(dubaiCntrInfoVO.getCntrSealNo(), true));
					cntrCnt++;
				}
				// (4) container MFinfo
				dubaiCntrMfInfoVOList = dbDao.searchFlatFileCntrMfList(dubaiManifestTransmitVOs[i]);
				for (int cntrMfIdx = 0; cntrMfIdx < dubaiCntrMfInfoVOList.size(); cntrMfIdx++)
				{
					dubaiCntrMfInfoVO = dubaiCntrMfInfoVOList.get(cntrMfIdx);
					flatFile.append(setFlatFile("CON", false));
					// 1. SERIAL NUMBER
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getDuCntrSerNo(), false));
					// 2. MARKS && NUMBERS
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getCntrMfMkDesc(), false));
					// 3. CARGO DESCRIPTION
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getCntrMfGdsDesc(), false));
					// 4. USED OR NEW INDICATOR
					flatFile.append(setFlatFile("", false));
					// 5. COMMODITY CODE
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getCmdtHsCd(), false));
					// 6. CONSIGNMENT PACKAGES
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getPckQty(), false));
					// 7. PACKAGE TYPE
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getPckTpDesc(), false));
					// 8. PACKAGE TYPE CODE
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getDuPckTpCd(), false));
					// 9. NO OF PALLETS
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getPltQty(), false));
					// 10. CONSIGNMENT WEIGHT IN KG
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getCntrMfWgt(), false));
					// 11. CONSIGNMENT VOLUME IN CUBIC METRES
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getMeasQty(), false));
					// 12. DANGEROUS GOODS INDICATOR
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getDcgoFlg(), false));
					// 13. IMO CLASS NUMBER
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getImdgClssCd(), false));
					// 14. UN NUMBER OF DANGEROUS GOODS
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getImdgUnNo(), false));
					// 15. FLASH POINT
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getFlshPntCdoTemp(), false));
					// 16. UNIT OF TEMPERATURE
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getDcgoTempUtCd(), false));
					// 17. STORAGE REQUESTED FOR DANGEROUS GOODS
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getDgStoReqFlg(), false));
					// 18. REFRIGERATION REQUIRED
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getRfrtReqFlg(), false));
					// 19. MINIMUM TEMPERATURE OF PERFIGERATION
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getMinTemp(), false));
					// 20. MAXIMUM TEMPERATURE OF PERFIGERATION
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getMaxTemp(), false));
					// 21. UNIT OF TEMPERATURE
					flatFile.append(setFlatFile(dubaiCntrMfInfoVO.getCgoTempUtCd(), true));
				} // end for (MF)
			} // end for (BL)
			// (5) CNTR COUNT / BL COUNT info
			if (blCnt > 0)
			{
				flatFile.append(setFlatFile("END", false));
				flatFile.append(setFlatFile(""+cntrCnt, false));
				flatFile.append(setFlatFile(""+blCnt, true));
			}
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * Flat File String \" attach
	 * 
	 * @param str
	 * @return
	 */
	private String setFlatFile(String str, boolean end) {
		String doubleQuataionStr = "\"";
		String commaStr = ",";
		StringBuffer sb = new StringBuffer();
		sb.append(doubleQuataionStr);
		sb.append(str);
		sb.append(doubleQuataionStr);
		if (end)
			sb.append("\n");
		else
			sb.append(commaStr);
		return sb.toString();
	}
}