/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob
*@FileTitle : Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.08.20 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;


/**
 * @author KIM Sang-Soo
 * @see ESM_BKG_1501 EventResponse, Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318313L;

	private CargoInfoHeaderVO cargoInfoHeaderVO;
	// Database Access Object
	private Jp24ManifestListDownloadDBDAO dbDao = new Jp24ManifestListDownloadDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 */
	public void setCargoInfoHeaderVO(CargoInfoHeaderVO cargoInfoHeaderVO) {
		this.cargoInfoHeaderVO = cargoInfoHeaderVO;
	}

	/**
	 * Back End Job Result
	 * @return List<CargoInfoDetailVO>
	 * @throws Exception
	 */
	public List<CargoInfoDetailVO> doStart() throws Exception {
		try {
			String searchDiv = this.cargoInfoHeaderVO.getSearchDiv();
			List<CargoInfoDetailVO> cargoInfoDetailVOList = null;
			if ("BL".equals(searchDiv)) {
				cargoInfoDetailVOList = dbDao.searchCargoInfoDetailBLData(this.cargoInfoHeaderVO);
			} else if ("DN".equals(searchDiv)) {
				cargoInfoDetailVOList = dbDao.searchCargoInfoDetailDownload(this.cargoInfoHeaderVO);
			}
			return cargoInfoDetailVOList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}