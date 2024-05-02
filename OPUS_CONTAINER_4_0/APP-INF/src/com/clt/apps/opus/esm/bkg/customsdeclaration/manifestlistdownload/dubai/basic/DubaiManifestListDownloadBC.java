/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DubaiManifestListDownloadBC.java
*@FileTitle : DubaiManifestListDownloadBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsCdConvCtntVO;


/**
 * OPUS-DubaiManifestListDownload Business Logic Command Interface<br>
 *
 * @author
 * @see Related BCImpl class
 * @since J2EE 1.6
 */
public interface DubaiManifestListDownloadBC {

	/**
	 *  B/L List for customs declaration Retrieve
	 *
	 * @param manifestListCondVO
	 * @return List<ManifestListDetailVO>
	 * @throws EventException
	 */
	public List<ManifestListDetailVO> searchManifestList(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 *  download List for customs declaration in customs table
	 *
	 * @param ManifestListDetailVO[] manifestListDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageManifest(ManifestListDetailVO[] manifestListDetailVOs, SignOnUserAccount account) throws EventException;


	/**
	 *  Package Unit Retrieve for country
	 *
	 * @param bkgCstmsCdConvCtntVO
	 * @return List<BkgCstmsCdConvCtntVO>
	 * @throws EventException
	 */
	public List<BkgCstmsCdConvCtntVO> searchPkgUnitList(BkgCstmsCdConvCtntVO bkgCstmsCdConvCtntVO) throws EventException ;

	/**
	 * BL detail Retrieve
	 *
	 * @param ManifestListCondVO manifestListCondVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestInfo(ManifestListCondVO manifestListCondVO) throws EventException;

	/**
	 * BL, Customer modifying
	 *
	 * @param cstmsBlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsBl(CstmsBlVO[] cstmsBlVOs, SignOnUserAccount account) throws EventException ;

	/**
	 * VVD Information for customs creating, modifying, deleting
	 * @param CstmsVvdInfoVO[] cstmsVvdInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCstmsVvdInfo(CstmsVvdInfoVO[] cstmsVvdInfoVOs, SignOnUserAccount account) throws EventException;
}
