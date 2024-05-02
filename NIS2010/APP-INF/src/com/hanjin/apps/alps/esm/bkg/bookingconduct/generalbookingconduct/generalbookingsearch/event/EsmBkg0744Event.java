/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0744Event.java
*@FileTitle : Direct NVO AMS File No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.25
* 1.0 Creation KimByungKyu
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HblCountVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;


/**
 * ESM_BKG_0744 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0744HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0744HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0744Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private HblCountVO hblCountVO = null;
	private BkgUsaCstmsFileNoVO bkgUsaCstmsFileNoVO = null;

	/** Table Value Object Multi Data 처리 */
	private BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs = null;

	public EsmBkg0744Event(){}

	public void setBkgUsaCstmsFileNoVO(BkgUsaCstmsFileNoVO bkgUsaCstmsFileNoVO){
		this. bkgUsaCstmsFileNoVO = bkgUsaCstmsFileNoVO;
	}

	public void setBkgUsaCstmsFileNoVOs(BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs){
		this. bkgUsaCstmsFileNoVOs = bkgUsaCstmsFileNoVOs;
	}

	public BkgUsaCstmsFileNoVO getBkgUsaCstmsFileNoVO(){
		return bkgUsaCstmsFileNoVO;
	}

	public BkgUsaCstmsFileNoVO[] getBkgUsaCstmsFileNoVOs(){
		return bkgUsaCstmsFileNoVOs;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}
	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}

	public void setHblCountVO(HblCountVO hblCountVO){
		this. hblCountVO = hblCountVO;
	}
	public HblCountVO getHblCountVO(){
		return hblCountVO;
	}	
}