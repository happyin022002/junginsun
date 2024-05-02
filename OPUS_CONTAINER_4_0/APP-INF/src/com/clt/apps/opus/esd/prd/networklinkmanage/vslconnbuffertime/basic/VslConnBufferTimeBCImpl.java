/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VslConnBufferTimeBCImpl.java
 *@FileTitle : VslConnBufferTimeBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.integration.VslConnBufferTimeDBDAO;
import com.clt.apps.opus.esd.prd.networklinkmanage.vslconnbuffertime.vo.VslConnBufferTimeListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * VslConnBufferTimeBC<br>
 * 
 * @author
 * @see EventResponse
 * @since J2EE 1.6
 */
public class VslConnBufferTimeBCImpl implements VslConnBufferTimeBC {
	private transient VslConnBufferTimeDBDAO dbDao = null;

	/**
	 * creating VslConnBufferTimeBCImpl<br>
	 * creating VslConnBufferTimeDBDAO<br>
	 */
	public VslConnBufferTimeBCImpl() {
		dbDao = new VslConnBufferTimeDBDAO();
	}

	/**
	 * retrieving - Vessel Connection Buffer Time
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<VslConnBufferTimeListVO> searchVslConnBufferTimeList(VslConnBufferTimeListVO vo) throws EventException {
		try {
			return dbDao.searchVslConnBufferTimeList(vo);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * multi event - ESD_PRD_037
	 * 
	 * @param vslConnBufferTimeListVOs
	 * @param account
	 * @exception EventException
	 */
	public void multiVslConnBufferTime(VslConnBufferTimeListVO[] vslConnBufferTimeListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<VslConnBufferTimeListVO> muntiVos = new ArrayList<VslConnBufferTimeListVO>();
			List<VslConnBufferTimeListVO> deleteVos = new ArrayList<VslConnBufferTimeListVO>();
			for (VslConnBufferTimeListVO vo : vslConnBufferTimeListVOs) {
				if ("I".equals(vo.getIbflag()) || "U".equals(vo.getIbflag())) {
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					muntiVos.add(vo);
				} else if ("D".equals(vo.getIbflag())) {
					deleteVos.add(vo);
				}
			}
			if (deleteVos.size() > 0) {
				dbDao.deleteVslConnBufferTime(deleteVos);
			}
			if (muntiVos.size() > 0) {
				dbDao.multiVslConnBufferTime(muntiVos);
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
}
