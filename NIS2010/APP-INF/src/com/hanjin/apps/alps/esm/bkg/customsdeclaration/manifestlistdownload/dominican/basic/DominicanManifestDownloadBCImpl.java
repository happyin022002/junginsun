/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : DominicanManifestDownloadBCImpl.java
 *@FileTitle : DominicanManifestDownloadBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.07.04
 *@LastModifier : 경종윤
 *@LastVersion : 1.0
 * 2013.07.04 경종윤
 * 1.0 Creation
 *------------------------------------------------------
 * History
 * 
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.basic;

import java.io.StringWriter;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.integration.DominicanManifestDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanManifestBLVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanManifestContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo.DominicanVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.xmldocuments.XMLDocumentUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Gyoung Sub
 * @see 
 * @since J2EE 1.4
 */
public class DominicanManifestDownloadBCImpl extends ManifestListDownloadBCImpl {
	// Database Access Object
	private transient DominicanManifestDownloadDBDAO dbDao = null;

	/**
	 * DominicanManifestDownloadBCImpl 객체 생성<br>
	 */
	public DominicanManifestDownloadBCImpl(){
		dbDao = new DominicanManifestDownloadDBDAO();
	}
	
	/**
	 * 세관 신고 대상 B/L List를 조회한다.
	 * 
	 * @param manifestListCondVO 조건
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		try{
			return dbDao.searchDominicanManifestList(manifestListCondVO);
			
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param String usrId
	 * @param ManifestListCondVO manifestListCondVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(String usrId, ManifestListCondVO manifestListCondVO, String pgmNo) throws EventException {
		DominicanManifestBackEndJob dominicanManifestBackEndJob = new DominicanManifestBackEndJob(manifestListCondVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		String resultStr = "";
		
		try{
			resultStr = backEndJobManager.execute(dominicanManifestBackEndJob, usrId, "Domincan Search");
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
		
		return resultStr;
	}
	
	/**
	 * xml을 생성해서 로컬로 다운로드<br>
	 * 
	 * @param ManifestListCondVO manifestListCondVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(ManifestListCondVO manifestListCondVO) throws EventException {
		Document doc = null;
		
		Element rootElement;
		
		Element manifest;

		Attr attr = null;
		
		TransformerFactory tFactory = null;
		Transformer trans = null;
		
		StringWriter sw = new StringWriter();
		
		DominicanVslInfoVO dominicanVslInfoVO = null;
		List<DominicanManifestBLVO> dominicanManifestBLVOs = null;
		List<DominicanManifestContainerVO> dominicanManifestContainerVOs = null;
		
		
		try {
			
			/*
			 * vessel 정보 조회
			 */
			dominicanVslInfoVO = (DominicanVslInfoVO) dbDao.searchVslInfo(manifestListCondVO);			
			
			doc = XMLDocumentUtils.createDocument();
			
			rootElement = doc.createElement("ImportManifest");
			
			attr = doc.createAttribute("xmlns");
			attr.setValue("http://aduanas.gob.do/XSD/ImportCargo/ImportManifest.xsd");
			rootElement.setAttributeNode(attr);
			
			doc.appendChild(rootElement);
			
			manifest = doc.createElement("Manifest");

			attr = doc.createAttribute("xmlns");
			attr.setValue("");
			manifest.setAttributeNode(attr);
			
			rootElement.appendChild(manifest);
			
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "AreaCode" , ""));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "TransportType" , "IG1007-S"));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "BizCompanyCode" , "SHP1995005924"));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "VesselCode" , dominicanVslInfoVO.getVslCd()));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "VoyageNo" , dominicanVslInfoVO.getSkdVoyNo() + dominicanVslInfoVO.getSkdDirCd()));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "EmptyYN" , ""));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "LoadingLocationCode" , ""));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "UnloadingLocationCode" , dominicanVslInfoVO.getPort()));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "DepartureDate" , dominicanVslInfoVO.getEtd()));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "ArrivalDate" , dominicanVslInfoVO.getEta()));
			manifest.appendChild(XMLDocumentUtils.createElement(doc, "CountryCode" , dominicanVslInfoVO.getVslRgstCntCd()));
			
			
			/*
			 * bl 정보 조회
			 */
			dominicanManifestBLVOs = dbDao.searchManifestBL(manifestListCondVO);
			DominicanManifestBLVO dominicanManifestBLVO = null;
			int blListSize = 0;
			if(dominicanManifestBLVOs != null) {
				blListSize = dominicanManifestBLVOs.size();

				for(int i = 0; i < blListSize; i++) {
					dominicanManifestBLVO = dominicanManifestBLVOs.get(i);
					
					
//					rootElement.appendChild(manifestBL);	
					Element manifestBL = doc.createElement("ManifestBL");
					
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "BLNo"                 , dominicanManifestBLVO.getBlNo    			    ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "BLType"               , dominicanManifestBLVO.getBlType                 ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "TransitType"          , dominicanManifestBLVO.getTransitType            ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "LastPortCode"         , dominicanManifestBLVO.getLastPortCode           ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "LoadingPortCode"      , dominicanManifestBLVO.getLoadingPortCode        ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "GoodsName"            , dominicanManifestBLVO.getGoodsName              ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "PackageUnitCode"      , dominicanManifestBLVO.getPackageUnitCode        ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "PackageQty"           , dominicanManifestBLVO.getPackageQty             ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "GrossWeight"          , dominicanManifestBLVO.getGrossWeight            ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "Value"                , dominicanManifestBLVO.getValue                  ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "FlightCharge"         , dominicanManifestBLVO.getFlightCharge           ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "Volume"               , dominicanManifestBLVO.getVolume                 ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ExpressType"          , dominicanManifestBLVO.getExpressType            ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorType"        , dominicanManifestBLVO.getConsignorType          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorCode"        , dominicanManifestBLVO.getConsignorCode          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorTel"         , dominicanManifestBLVO.getConsignorTel           ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorCountryCode" , dominicanManifestBLVO.getConsignorCountryCode   ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorName"        , dominicanManifestBLVO.getConsignorName          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorDocumentType", dominicanManifestBLVO.getConsignorDocumentType  ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorDocumentNo"  , dominicanManifestBLVO.getConsignorDocumentNo    ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorEmail"       , dominicanManifestBLVO.getConsignorEmail         ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorZipCode"     , dominicanManifestBLVO.getConsignorZipCode       ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorStreet"      , dominicanManifestBLVO.getConsignorStreet        ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorZoneName"    , dominicanManifestBLVO.getConsignorZoneName      ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsignorCity"        , dominicanManifestBLVO.getConsignorCity          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeType"        , dominicanManifestBLVO.getConsigneeType          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeCode"        , dominicanManifestBLVO.getConsigneeCode          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeTel"         , dominicanManifestBLVO.getConsigneeTel           ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeCountryCode" , dominicanManifestBLVO.getConsigneeCountryCode   ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeName"        , dominicanManifestBLVO.getConsigneeName          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeDocumentType", dominicanManifestBLVO.getConsigneeDocumentType  ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeDocumentNo"  , dominicanManifestBLVO.getConsigneeDocumentNo    ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeEmail"       , dominicanManifestBLVO.getConsigneeEmail         ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeFax"         , dominicanManifestBLVO.getConsigneeFax           ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeZipCode"     , dominicanManifestBLVO.getConsigneeZipCode       ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeStreet"      , dominicanManifestBLVO.getConsigneeStreet        ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeZoneName"    , dominicanManifestBLVO.getConsigneeZoneName      ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "ConsigneeCity"        , dominicanManifestBLVO.getConsigneeCity          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyType"           , dominicanManifestBLVO.getNotifyType             ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyCode"           , dominicanManifestBLVO.getNotifyCode             ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyCountryCode"    , dominicanManifestBLVO.getNotifyCountryCode      ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyDocumentType"   , dominicanManifestBLVO.getNotifyDocumentType     ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyDocumentNo"     , dominicanManifestBLVO.getNotifyDocumentNo       ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyName"           , dominicanManifestBLVO.getNotifyName             ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyEmail"          , dominicanManifestBLVO.getNotifyEmail            ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyTel"            , dominicanManifestBLVO.getNotifyTel              ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyFax"            , dominicanManifestBLVO.getNotifyFax              ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyZipCode"        , dominicanManifestBLVO.getNotifyZipCode          ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyStreet"         , dominicanManifestBLVO.getNotifyStreet           ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyZoneName"       , dominicanManifestBLVO.getNotifyZoneName         ()));
					manifestBL.appendChild(XMLDocumentUtils.createElement(doc, "NotifyCity"			     , dominicanManifestBLVO.getNotifyCity          ()));					
					

					manifest.appendChild(manifestBL);
					
					
				} // end for(i)
				
				/*
				 * cntr 정보 조회
				 */
				dominicanManifestContainerVOs = dbDao.searchManifestContainer(manifestListCondVO);
				int cntrListSize = 0;
				DominicanManifestContainerVO dominicanManifestContainerVO = null;
				
				if(dominicanManifestContainerVOs != null) {
					cntrListSize = dominicanManifestContainerVOs.size();
					
					for(int i = 0; i < cntrListSize; i++) {
						
						dominicanManifestContainerVO = dominicanManifestContainerVOs.get(i);
						
						Element manifestContainer = doc.createElement("ManifestContainer");
						
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "ContainerNo", dominicanManifestContainerVO.getContainerNo()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "PlacaNo", dominicanManifestContainerVO.getPlacaNo()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "ContainerType", dominicanManifestContainerVO.getContainerType()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "PackageCode", dominicanManifestContainerVO.getPackageCode()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "Amount", dominicanManifestContainerVO.getAmount()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "GrossWeight", dominicanManifestContainerVO.getGrossWeight()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "NetWeight", dominicanManifestContainerVO.getNetWeight()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "SealNo1", dominicanManifestContainerVO.getSealNo1()));					
						manifestContainer.appendChild(XMLDocumentUtils.createElement(doc, "SealNo2", dominicanManifestContainerVO.getSealNo2()));					

						manifest.appendChild(manifestContainer);
						
					}
					
					String preBlNo = "";
					String currBlNo = "";
					Element containerBL = null;
					for(int i = 0; i < cntrListSize; i++) {
						
						dominicanManifestContainerVO = dominicanManifestContainerVOs.get(i);
						
						currBlNo = dominicanManifestContainerVO.getBlNo();
						
						if(!preBlNo.equals(currBlNo)) {
							containerBL = doc.createElement("ContainerBL");
							containerBL.appendChild(XMLDocumentUtils.createElement(doc, "BLNo", currBlNo));
						}
						containerBL.appendChild(XMLDocumentUtils.createElement(doc, "ContainerNo", dominicanManifestContainerVO.getContainerNo()));					

						preBlNo = currBlNo;
						
						manifest.appendChild(containerBL);
						
					}
					
				} // end dominicanManifestContainerVOs

				tFactory = TransformerFactory.newInstance();
				trans = tFactory.newTransformer();
				trans.setOutputProperty(OutputKeys.ENCODING, "utf-8");
				trans.setOutputProperty(OutputKeys.INDENT, "yes");
				trans.setOutputProperty(OutputKeys.METHOD, "xml");
				
				trans.transform(new DOMSource(doc), new StreamResult(sw));
				
			} // end dominicanManifestBLVOs
			
			
			
			
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
		
		return sw.toString();
	}
	

}