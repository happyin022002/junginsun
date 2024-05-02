/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBsa0043Event.java
*@FileTitle : Target VVD (Yearly Plan)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.24
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.01.24 최성민
* 1.0 Creation
* 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event;

import com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo.ParamCoaMonVvdYryPlnVO;
import com.hanjin.apps.alps.esm.bsa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasMonVvdYryPlnVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;


/**
 * ESM_BSA_0043 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0043HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNGMIN
 * @see ESM_BSA_0043HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0043Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasMonVvdYryPlnVO masMonVvdYryPlnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasMonVvdYryPlnVO[] masMonVvdYryPlnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	

	public EsmBsa0043Event(){}
	
	public void setMasMonVvdYryPlnVO(MasMonVvdYryPlnVO masMonVvdYryPlnVO){
		this. masMonVvdYryPlnVO = masMonVvdYryPlnVO;
	}

	//Yongseup Kim - Secure Coding [CWE-496]
	public void setMasMonVvdYryPlnVOS(MasMonVvdYryPlnVO[] masMonVvdYryPlnVOs){
		this.masMonVvdYryPlnVOs = new MasMonVvdYryPlnVO[masMonVvdYryPlnVOs.length];
		for(int i=0; i< masMonVvdYryPlnVOs.length; ++i){
			this.masMonVvdYryPlnVOs[i] = masMonVvdYryPlnVOs[i];
		}
	}

	public MasMonVvdYryPlnVO getMasMonVvdYryPlnVO(){
		return masMonVvdYryPlnVO;
	}

	//Yongseup Kim - Secure Coding [CWE-495]
	public MasMonVvdYryPlnVO[] getMasMonVvdYryPlnVOS(){
		MasMonVvdYryPlnVO[] ret = null;
		if(this.masMonVvdYryPlnVOs != null){
			ret = new MasMonVvdYryPlnVO[masMonVvdYryPlnVOs.length];
			for(int i=0; i< masMonVvdYryPlnVOs.length; i++){
				ret[i] = this.masMonVvdYryPlnVOs[i];
			}
		}
		return ret;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	public ParamCoaMonVvdYryPlnVO getParamCoaMonVvdYryPlnVO() {
		return paramCoaMonVvdYryPlnVO;
	}

	public void setParamCoaMonVvdYryPlnVO(
			ParamCoaMonVvdYryPlnVO paramCoaMonVvdYryPlnVO) {
		this.paramCoaMonVvdYryPlnVO = paramCoaMonVvdYryPlnVO;
	}

	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}

	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}
	
	

}