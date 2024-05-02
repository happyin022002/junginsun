/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCstmsFileListVO.java
*@FileTitle : UsaCstmsFileListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.12 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김병규
 * @since J2EE 1.5
 * @see ..
 */
public class UsaCstmsFileListVO {

	List<HblCountVO> hblCount 	= new ArrayList<HblCountVO>();
	List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNo 	= new ArrayList<BkgUsaCstmsFileNoVO>();

	/** Table Value Object 조회 조건 및 단건 처리  */
	private HblCountVO hblCountVO = null;
	private BkgUsaCstmsFileNoVO bkgUsaCstmsFileNoVO = null;


	/** Table Value Object Multi Data 처리 */
	private HblCountVO[] hblCountVOs = null;
	private BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs = null;

	/* HblCountVO Start  */
	public void setHblCountVOs(HblCountVO[] hblCountVOs) {
		this.hblCountVOs = hblCountVOs;
	}

	public HblCountVO[] getHblCountVOs() {
		return hblCountVOs;
	}

	public void setHblCountVO(HblCountVO hblCountVO) {
		this.hblCountVO = hblCountVO;
	}

	public HblCountVO getHblCountVO() {
		return hblCountVO;
	}

	public List<HblCountVO> getHblCount() {
		return hblCount;
	}

	public void setHblCount(List<HblCountVO> hblCount) {
		this.hblCount = hblCount;
	}
	/* HblCountVO End  */

	/* BkgUsaCstmsFileNoVO Start  */
	public void setBkgUsaCstmsFileNoVOs(BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs) {
		this.bkgUsaCstmsFileNoVOs = bkgUsaCstmsFileNoVOs;
	}

	public BkgUsaCstmsFileNoVO[] getBkgUsaCstmsFileNoVOs() {
		return bkgUsaCstmsFileNoVOs;
	}

	public void setBkgUsaCstmsFileNoVO(BkgUsaCstmsFileNoVO bkgUsaCstmsFileNoVO) {
		this.bkgUsaCstmsFileNoVO = bkgUsaCstmsFileNoVO;
	}

	public BkgUsaCstmsFileNoVO getBkgUsaCstmsFileNoVO() {
		return bkgUsaCstmsFileNoVO;
	}

	public List<BkgUsaCstmsFileNoVO> getBkgUsaCstmsFileNo() {
		return bkgUsaCstmsFileNo;
	}
	public void setBkgUsaCstmsFileNo(List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNo) {
		this.bkgUsaCstmsFileNo = bkgUsaCstmsFileNo;
	}
	/* BkgUsaCstmsFileNoVO End  */
}
