/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VslConnBufferTimeBC.JAVA
 *@FileTitle : VslConnBufferTimeBC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.vo.VslConnBufferTimeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * VslConnBufferTimeBC<br>
 * 
 * @author
 * @see EventResponse
 * @since J2EE 1.6
 */
public interface VslConnBufferTimeBC {
	/**
	 * retrieving - Vessel Connection Buffer Time
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<VslConnBufferTimeListVO> searchVslConnBufferTimeList(VslConnBufferTimeListVO vo) throws EventException;

	/**
	 * multi event - ESD_PRD_037
	 * 
	 * @param vslConnBufferTimeListVOs
	 * @param account
	 * @exception EventException
	 */
	public void multiVslConnBufferTime(VslConnBufferTimeListVO[] vslConnBufferTimeListVOs, SignOnUserAccount account) throws EventException;
}
