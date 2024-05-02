/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IndiaManifestListDownloadBC.java
*@FileTitle : IndiaManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-IndiaManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface IndiaManifestListDownloadBC {

	/**
	 * Searching the Vessel Details Info<br>
	 *
	 * @param VesselArrivalCondVO vesselArrivalCondVO
	 * @return List<VesselArrivalDetailVO>
	 * @throws EventException
	 */
	public List<VesselArrivalDetailVO> searchVesselArrival(VesselArrivalCondVO vesselArrivalCondVO) throws EventException;

	/**
	 * Managing(Insert/Update/Delete) the Vessel Details Info<br>
	 *
	 * @param vesselArrivalVO
	 * @param account
	 * @throws EventException
	 */
	public void manageVesselArrival(VesselArrivalVO vesselArrivalVO, SignOnUserAccount account) throws EventException;

	/**
	 * Searching the Manifest list for INDIA Customs<br>
	 *
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * Managing(Save) the list for INDIA Customs Manifest<br>
	 *
	 * @param manifestModificationVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageManifest(ManifestModificationVO[] manifestModificationVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Searching whether the Office code exist<br>
	 *
	 * @param ofcCd
	 * @return int
	 * @throws EventException
	 */
	public int searchExistOrganization(String ofcCd) throws EventException;

	/**
	 * Searching the Info for setting the print-form of INDIA Customs<br>
	 *
	 * @param cstmsNtfyAddrCondVO
	 * @return List<CstmsNtfyAddrVO>
	 * @throws EventException
	 */
	public List<CstmsNtfyAddrVO> searchCstmsNtfyAddr(CstmsNtfyAddrCondVO cstmsNtfyAddrCondVO) throws EventException;

	/**
	 * Managing(save) the Info for setting the print-form of INDIA Customs<Br>
	 *
	 * @param cstmsNtfyAddrVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageCstmsNtfyAddr(CstmsNtfyAddrVO[] cstmsNtfyAddrVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Searching the Bond(warehouse) Info<Br>
	 *
	 * @param bondCondVO
	 * @return List<BondDetailListVO>
	 * @throws EventException
	 */
	public List<BondDetailListVO> searchBondList(BondCondVO bondCondVO) throws EventException;
}
