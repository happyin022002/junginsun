/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsWharfageDecMgtBackEndJob.java
 *@FileTitle : UsWharfageDecMgtBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.25 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration.UsWharfageDecMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendCondVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.syscommon.common.table.BkgUsaWhfBlVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfCntrVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndHisVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndQtyVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndVO;

/**
 * NIS2010-WharfageDecMgt Business Logic Basic Command implementation<br>
 * - NIS2010-WharfageDecMgt 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Min jeong
 * @see UsWharfageDecMgtDBDAO 참조
 * @since J2EE 1.4
 */
public class UsWharfageDecMgtBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private UsWhfBlListCondVO usWhfBlListCondVO;
	private UsWhfSendCondVO usWhfSendCondVO;
	// Database Access Object
	private transient UsWharfageDecMgtDBDAO dbDao = new UsWharfageDecMgtDBDAO();

	/**
	 * Wharfage B/L 정보가 없으면 Booking 정보 조회 후 등록
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		if (usWhfBlListCondVO != null)
		{
			// US Wharfage Set-Up
			setUsWhfInfo(usWhfBlListCondVO);
		}
		if (usWhfSendCondVO != null)
		{
			// US Wharfage Send
			usWhfBlListCondVO = new UsWhfBlListCondVO();
			usWhfBlListCondVO.setVvd(usWhfSendCondVO.getVvd());
			usWhfBlListCondVO.setPort(usWhfSendCondVO.getPort());
			usWhfBlListCondVO.setBound(usWhfSendCondVO.getBound());
			usWhfBlListCondVO.setCreUsrId(usWhfSendCondVO.getCreUsrId());
			setUsWhfInfo(usWhfBlListCondVO);
			// WhfSndQty Delete -> Insert
			List<BkgUsaWhfSndQtyVO> bkgUsaWhfSndQtyVOs = new ArrayList<BkgUsaWhfSndQtyVO>();
			BkgUsaWhfSndQtyVO bkgUsaWhfSndQtyVO = new BkgUsaWhfSndQtyVO();
			bkgUsaWhfSndQtyVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0,4));
			bkgUsaWhfSndQtyVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4,8));
			bkgUsaWhfSndQtyVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
			bkgUsaWhfSndQtyVO.setPortCd(usWhfBlListCondVO.getPort());
			bkgUsaWhfSndQtyVO.setIoBndCd(usWhfBlListCondVO.getBound());
			bkgUsaWhfSndQtyVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
			bkgUsaWhfSndQtyVO.setIbflag("INIT");
			bkgUsaWhfSndQtyVOs.add(bkgUsaWhfSndQtyVO);
			dbDao.removeBkgUsaWhfSndQty(bkgUsaWhfSndQtyVOs);
			dbDao.addBkgUsaWhfSndQty(bkgUsaWhfSndQtyVOs);
		}
		return null;
	}

	/**
	 * US Wharfage 테이블에 데이타가 없는 경우 Booking Creation에서 정보 조회 후 등록
	 * 
	 * @param usWhfBlListCondVO 조회조건
	 * @throws Exception
	 */
	private void setUsWhfInfo(UsWhfBlListCondVO usWhfBlListCondVO) throws Exception {
		if (!dbDao.checkUsWhfBl(usWhfBlListCondVO))
		{
			// WhfSnd Insert
			List<BkgUsaWhfSndVO> bkgUsaWhfSndVOs = new ArrayList<BkgUsaWhfSndVO>();
			BkgUsaWhfSndVO bkgUsaWhfSndVO = new BkgUsaWhfSndVO();
			bkgUsaWhfSndVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0,4));
			bkgUsaWhfSndVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4,8));
			bkgUsaWhfSndVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
			bkgUsaWhfSndVO.setPortCd(usWhfBlListCondVO.getPort());
			bkgUsaWhfSndVO.setIoBndCd(usWhfBlListCondVO.getBound());
			bkgUsaWhfSndVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
			bkgUsaWhfSndVO.setIbflag("INIT");
			bkgUsaWhfSndVOs.add(bkgUsaWhfSndVO);
			dbDao.addBkgUsaWhfSnd(bkgUsaWhfSndVOs);
			// WhfBl Insert
			List<BkgUsaWhfBlVO> bkgUsaWhfBlVOs = new ArrayList<BkgUsaWhfBlVO>();
			BkgUsaWhfBlVO bkgUsaWhfBlVO = new BkgUsaWhfBlVO();
			bkgUsaWhfBlVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0,4));
			bkgUsaWhfBlVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4,8));
			bkgUsaWhfBlVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
			bkgUsaWhfBlVO.setPortCd(usWhfBlListCondVO.getPort());
			bkgUsaWhfBlVO.setIoBndCd(usWhfBlListCondVO.getBound());
			bkgUsaWhfBlVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
			bkgUsaWhfBlVO.setIbflag("INIT");
			bkgUsaWhfBlVOs.add(bkgUsaWhfBlVO);
			dbDao.addBkgUsaWhfBl(bkgUsaWhfBlVOs);
			// WhfCntr Insert
			List<BkgUsaWhfCntrVO> bkgUsaWhfCntrVOs = new ArrayList<BkgUsaWhfCntrVO>();
			BkgUsaWhfCntrVO bkgUsaWhfCntrVO = new BkgUsaWhfCntrVO();
			bkgUsaWhfCntrVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0,4));
			bkgUsaWhfCntrVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4,8));
			bkgUsaWhfCntrVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
			bkgUsaWhfCntrVO.setPortCd(usWhfBlListCondVO.getPort());
			bkgUsaWhfCntrVO.setIoBndCd(usWhfBlListCondVO.getBound());
			bkgUsaWhfCntrVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
			bkgUsaWhfCntrVO.setIbflag("INIT");
			bkgUsaWhfCntrVOs.add(bkgUsaWhfCntrVO);
			dbDao.addBkgUsaWhfCntr(bkgUsaWhfCntrVOs);
			// 오클랜드의 경우 메일이 3개로 정해져 있기때문에 신규에 등록해둠
			if ("USOAK".equals(usWhfBlListCondVO.getPort()))
			{
				List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
				// 1번째 메일
				BkgUsaWhfSndHisVO bkgUsaWhfSndHisVO = new BkgUsaWhfSndHisVO();
				bkgUsaWhfSndHisVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0, 4));
				bkgUsaWhfSndHisVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4, 8));
				bkgUsaWhfSndHisVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
				bkgUsaWhfSndHisVO.setPortCd(usWhfBlListCondVO.getPort());
				bkgUsaWhfSndHisVO.setIoBndCd(usWhfBlListCondVO.getBound());
				bkgUsaWhfSndHisVO.setHisSeq("1");
				bkgUsaWhfSndHisVO.setNtcViaCd("M");
				bkgUsaWhfSndHisVO.setCntcEml("aatienza@portoakland.com");
				bkgUsaWhfSndHisVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVO.setUpdUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVO);
				// 2번째 메일
				bkgUsaWhfSndHisVO = new BkgUsaWhfSndHisVO();
				bkgUsaWhfSndHisVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0, 4));
				bkgUsaWhfSndHisVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4, 8));
				bkgUsaWhfSndHisVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
				bkgUsaWhfSndHisVO.setPortCd(usWhfBlListCondVO.getPort());
				bkgUsaWhfSndHisVO.setIoBndCd(usWhfBlListCondVO.getBound());
				bkgUsaWhfSndHisVO.setHisSeq("2");
				bkgUsaWhfSndHisVO.setNtcViaCd("M");
				bkgUsaWhfSndHisVO.setCntcEml("vanessa.garcia@tbct.itslb.com");
				bkgUsaWhfSndHisVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVO.setUpdUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVO);
				// 3번째 메일
				bkgUsaWhfSndHisVO = new BkgUsaWhfSndHisVO();
				bkgUsaWhfSndHisVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0, 4));
				bkgUsaWhfSndHisVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4, 8));
				bkgUsaWhfSndHisVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
				bkgUsaWhfSndHisVO.setPortCd(usWhfBlListCondVO.getPort());
				bkgUsaWhfSndHisVO.setIoBndCd(usWhfBlListCondVO.getBound());
				bkgUsaWhfSndHisVO.setHisSeq("3");
				bkgUsaWhfSndHisVO.setNtcViaCd("M");
				bkgUsaWhfSndHisVO.setCntcEml("Jason.Williams@itslb.com");
				bkgUsaWhfSndHisVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVO.setUpdUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVO);
				dbDao.addBkgUsaWhfSndHis(bkgUsaWhfSndHisVOs);
			}
			else
			{
				// 롱비치의 경우도 팩스와 메일이 정해져있음
				List<BkgUsaWhfSndHisVO> bkgUsaWhfSndHisVOs = new ArrayList<BkgUsaWhfSndHisVO>();
				// 1번째 메일
				BkgUsaWhfSndHisVO bkgUsaWhfSndHisVO = new BkgUsaWhfSndHisVO();
				bkgUsaWhfSndHisVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0, 4));
				bkgUsaWhfSndHisVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4, 8));
				bkgUsaWhfSndHisVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
				bkgUsaWhfSndHisVO.setPortCd(usWhfBlListCondVO.getPort());
				bkgUsaWhfSndHisVO.setIoBndCd(usWhfBlListCondVO.getBound());
				bkgUsaWhfSndHisVO.setHisSeq("1");
				bkgUsaWhfSndHisVO.setNtcViaCd("M");
				bkgUsaWhfSndHisVO.setCntcEml("vwong@polb.com");
				bkgUsaWhfSndHisVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVO.setUpdUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVO);
				// Fax
				bkgUsaWhfSndHisVO = new BkgUsaWhfSndHisVO();
				bkgUsaWhfSndHisVO.setVslCd(usWhfBlListCondVO.getVvd().substring(0, 4));
				bkgUsaWhfSndHisVO.setSkdVoyNo(usWhfBlListCondVO.getVvd().substring(4, 8));
				bkgUsaWhfSndHisVO.setSkdDirCd(usWhfBlListCondVO.getVvd().substring(8));
				bkgUsaWhfSndHisVO.setPortCd(usWhfBlListCondVO.getPort());
				bkgUsaWhfSndHisVO.setIoBndCd(usWhfBlListCondVO.getBound());
				bkgUsaWhfSndHisVO.setHisSeq("2");
				bkgUsaWhfSndHisVO.setNtcViaCd("F");
				bkgUsaWhfSndHisVO.setCntcFaxNo("562-901-1727");
				bkgUsaWhfSndHisVO.setCreUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVO.setUpdUsrId(usWhfBlListCondVO.getCreUsrId());
				bkgUsaWhfSndHisVOs.add(bkgUsaWhfSndHisVO);
				dbDao.addBkgUsaWhfSndHis(bkgUsaWhfSndHisVOs);
			}
		}
	}

	/**
	 * Parameter Set
	 * 
	 * @param usWhfBlListCondVO 
	 */
	public void setUsWhfBlListCondVO(UsWhfBlListCondVO usWhfBlListCondVO) {
		this.usWhfBlListCondVO = usWhfBlListCondVO;
	}

	/**
	 * Parameter Set
	 * 
	 * @param usWhfBlListCondVO
	 */
	public void setUsWhfSendCondVO(UsWhfSendCondVO usWhfSendCondVO) {
		this.usWhfSendCondVO = usWhfSendCondVO;
	}
}