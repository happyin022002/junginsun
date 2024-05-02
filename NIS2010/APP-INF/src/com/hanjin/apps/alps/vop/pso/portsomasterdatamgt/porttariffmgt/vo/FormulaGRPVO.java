/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FormulaGRPVO.java
*@FileTitle : FormulaGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.08.13 김진일 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김진일
 * @since J2EE 1.6
 * @see 
 */
public class FormulaGRPVO {
	/** Formula 의 정볼를 저장하고 있는 VO 정보 */ 
	private FormulaVO[] formulaVOs = null;
	/** System이 인식할 수 있는 VO 정보 */
	private FormulaVO[] formulaSysVOs = null;
	
	/** Fomula 혹은 Contion의 ID */
	private String id = null;
	/** id의 getter*/
	public String getId() {
		return id;
	}
	/** Fomula/Condtion 구분자 1: Formula 2: Condtion */
	private String flag = null;
	/** user_id의 정보를 저장 */
	private String usrId = null;
	/**
	 * usrId 의 getter
	 * @return
	 */
	public String getUsrId() {
		return usrId;
	}
	/** flag의 getter */
	public String getFlag() {
		return flag;
	}
	/**
	 * formulaVOs의 setter 
	 * @param formulaVOs
	 */
	public void setFormulaVOs(FormulaVO[] formulaVOs) {
		this.formulaVOs = formulaVOs;
	}
	/**
	 * formulaVOs의 getter
	 * @return
	 */
	public FormulaVO[] getFormulaVOs() {
		return formulaVOs;
	}
	/**
	 * formulaSysVOs의 setter
	 * @param formulaSysVOs
	 */
	public void setFormulaSysVOs(FormulaVO[] formulaSysVOs) {
		this.formulaSysVOs = formulaSysVOs;
	}
	/**
	 * formulaSysVOs의 getter
	 * @return
	 */
	public FormulaVO[] getFormulaSysVOs() {
		return formulaSysVOs;
	}
	/**
	 * id의 setter
	 * @param id
	 */
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}
	/**
	 * flag 의 setter 
	 * @param flag
	 */
	public void setFlag(String flag) {
		// TODO Auto-generated method stub
		this.flag = flag;
	}
	/**
	 * usrId의 setter
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId  = usrId;
	}
}
