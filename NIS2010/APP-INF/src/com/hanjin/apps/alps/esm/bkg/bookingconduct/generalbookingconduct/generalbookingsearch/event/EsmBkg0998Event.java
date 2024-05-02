/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0998Event.java
*@FileTitle : Constraints
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.19 KimByungKyu
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0998 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0998HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0998HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0998Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBlNoVO bkgBlNoVO = null;
	private PrdConstraintVO prdConstraintVO = null;

	/** Table Value Object Multi Data 처리 */
	private PrdConstraintVO[] prdConstraintVOs = null;

	public EsmBkg0998Event(){}

	public void setPrdConstraintVO(PrdConstraintVO prdConstraintVO){
		this. prdConstraintVO = prdConstraintVO;
	}

	public void setPrdConstraintVOS(PrdConstraintVO[] prdConstraintVOs){
		this. prdConstraintVOs = prdConstraintVOs;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO){
		this. bkgBlNoVO = bkgBlNoVO;
	}

	public PrdConstraintVO getPrdConstraintVO(){
		return prdConstraintVO;
	}

	public PrdConstraintVO[] getPrdConstraintVOS(){
		return prdConstraintVOs;
	}

	public BkgBlNoVO getBkgBlNoVO(){
		return bkgBlNoVO;
	}
}