/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AssetBC.java
*@FileTitle : AssetBC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.asset.basic;
 
import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerSizeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerTypeSizeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerTypeVO;
import com.clt.apps.opus.bcm.ccd.commoncode.asset.vo.ContainerVesselVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Asset Business Logic Command Interface<br>
 * An interface to the business logic for Asset<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface AssetBC {

	/**
	 * Container Type retrieve<br>
	 * 
	 * @param String cntrTpCd
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public List<ContainerTypeVO> searchContainerType(String cntrTpCd) throws EventException;

	/**
	 * Container Type save (adding/changing)<br>
	 * 
	 * @param ContainerTypeVO[] containerTypeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerType(ContainerTypeVO[] containerTypeVOs, String usrId) throws EventException;
	
	/**
	 * Container Size retrieve<br>
	 * 
	 * @param String cntrSzCd
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public List<ContainerSizeVO> searchContainerSize(String cntrSzCd) throws EventException;
	
	/**
	 * Container Size save(adding/changing)<br>
	 * 
	 * @param ContainerSizeVO[] containerSizeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerSize(ContainerSizeVO[] containerSizeVOs, String usrId) throws EventException;
	
	/**
	 * Container Type Size retrieve<br>
	 * 
	 * @param String cntrTpSzCd
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public List<ContainerTypeSizeVO> searchContainerTypeSize(String cntrTpSzCd) throws EventException;
	
	/**
	 * Container Type Size save(adding/changing)<br>
	 * 
	 * @param ContainerTypeSizeVO[] containerTypeSizeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerTypeSize(ContainerTypeSizeVO[] containerTypeSizeVOs, String usrId) throws EventException;
	
	/**
	 * Container Vessel retrieve<br>
	 * 
	 * @param String vslCd
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public List<ContainerVesselVO> searchContainerVessel(String vslCd) throws EventException;
	
	/**
	 * Container Vessel retrieve<br>
	 * 
	 * @param String rqstNo
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public List<ContainerVesselVO> searchContainerVesselRqst(String rqstNo) throws EventException;
	
	/**
	 * Container Vessel save(adding/changing)<br>
	 * 
	 * @param ContainerVesselVO[] containerVesselVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerVessel(ContainerVesselVO[] containerVesselVOs, String usrId) throws EventException;
	
	/**
	 * Container Vessel save(adding/changing)<br>
	 * 
	 * @param ContainerVesselVO[] containerVesselVOs
	 * @param String usrId
	 * @param String rqstNo
	 * @exception EventException
	 */
	public void manageContainerVesselRqst(ContainerVesselVO[] containerVesselVOs, String usrId, String rqstNo) throws EventException;
}