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
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.basic;
  
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerSizeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeSizeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerTypeVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.asset.vo.ContainerVesselVO;
import com.hanjin.framework.core.layer.event.EventException;

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
	public ContainerTypeVO searchContainerType(String cntrTpCd) throws EventException;

	/**
	 * Container Type save (adding/changing)<br>
	 * 
	 * @param ContainerTypeVO[] containerTypeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerType(ContainerTypeVO containerTypeVO, String usrId) throws EventException;
	
	/**
	 * Container Type checking.<br>
	 * 
	 * @param String cntrTpCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCntrTpCode(String cntrTpCd) throws EventException;
	
	/**
	 * Container Size retrieve<br>
	 * 
	 * @param String cntrSzCd
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public ContainerSizeVO searchContainerSize(String cntrSzCd) throws EventException;
	
	/**
	 * Container Size save(adding/changing)<br>
	 * 
	 * @param ContainerSizeVO[] containerSizeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerSize(ContainerSizeVO containerSizeVO, String usrId) throws EventException;
	
	/**
	 * Container Size checking.<br>
	 * 
	 * @param String cntrSzCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCntrSzCode(String cntrSzCd) throws EventException;
	
	/**
	 * Container Type Size checking.<br>
	 * 
	 * @param String cntrTpszCd
	 * @return String
	 * @exception EventException
	 */
	public String checkCntrTpszCode(String cntrTpszCd) throws EventException;
	
	/**
	 * Container Type Size retrieve<br>
	 * 
	 * @param String cntrTpSzCd
	 * @return List<ContainerTypeVO>
	 * @exception EventException
	 */
	public ContainerTypeSizeVO searchContainerTypeSize(String cntrTpSzCd) throws EventException;
	
	/**
	 * Container Type Size save(adding/changing)<br>
	 * 
	 * @param ContainerTypeSizeVO[] containerTypeSizeVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageContainerTypeSize(ContainerTypeSizeVO containerTypeSizeVO, String usrId) throws EventException;
	
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