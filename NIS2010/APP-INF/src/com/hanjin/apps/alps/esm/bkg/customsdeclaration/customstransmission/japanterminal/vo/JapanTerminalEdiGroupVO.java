package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

import java.util.List;


public class JapanTerminalEdiGroupVO {
	
	public JapanTerminalEdiGroupVO(){
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgTerminalEdiJapanAwkCgoVO bkgTerminalEdiJapanAwkCgoVO = null;
	//private BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO = null;
	private BkgTerminalEdiJapanCntrVO bkgTerminalEdiJapanCntrVO = null;
	private BkgTerminalEdiJapanDgCgoVO bkgTerminalEdiJapanDgCgoVO = null;
	private BkgTerminalEdiJapanRfCgoVO bkgTerminalEdiJapanRfCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private List<BkgTerminalEdiJapanAwkCgoVO> bkgTerminalEdiJapanAwkCgoVOs = null;
	//private List<BkgTerminalEdiJapanBlVO> bkgTerminalEdiJapanBlVOs = null;
	private List<BkgTerminalEdiJapanCntrVO> bkgTerminalEdiJapanCntrVOs = null;
	private List<BkgTerminalEdiJapanDgCgoVO> bkgTerminalEdiJapanDgCgoVOs = null;
	private List<BkgTerminalEdiJapanRfCgoVO> bkgTerminalEdiJapanRfCgoVOs = null;
	
/////////////////////////////////	
	public void setBkgTerminalEdiJapanAwkCgoVO(BkgTerminalEdiJapanAwkCgoVO bkgTerminalEdiJapanAwkCgoVO){
		this. bkgTerminalEdiJapanAwkCgoVO = bkgTerminalEdiJapanAwkCgoVO;
	}
	public BkgTerminalEdiJapanAwkCgoVO getBkgTerminalEdiJapanAwkCgoVO(){
		return bkgTerminalEdiJapanAwkCgoVO;
	}

/*	
	public void setBkgTerminalEdiJapanBlVO(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO){
		this. bkgTerminalEdiJapanBlVO = bkgTerminalEdiJapanBlVO;
	}
	public BkgTerminalEdiJapanBlVO getBkgTerminalEdiJapanBlVO(){
		return bkgTerminalEdiJapanBlVO;
	}
*/
	
	public void setBkgTerminalEdiJapanCntrVO(BkgTerminalEdiJapanCntrVO bkgTerminalEdiJapanCntrVO){
		this. bkgTerminalEdiJapanCntrVO = bkgTerminalEdiJapanCntrVO;
	}
	public BkgTerminalEdiJapanCntrVO getBkgTerminalEdiJapanCntrVO(){
		return bkgTerminalEdiJapanCntrVO;
	}	

	public void setBkgTerminalEdiJapanDgCgoVO(BkgTerminalEdiJapanDgCgoVO bkgTerminalEdiJapanDgCgoVO){
		this. bkgTerminalEdiJapanDgCgoVO = bkgTerminalEdiJapanDgCgoVO;
	}
	public BkgTerminalEdiJapanDgCgoVO getBkgTerminalEdiJapanDgCgoVO(){
		return bkgTerminalEdiJapanDgCgoVO;
	}

	public void setBkgTerminalEdiJapanRfCgoVO(BkgTerminalEdiJapanRfCgoVO bkgTerminalEdiJapanRfCgoVO){
		this. bkgTerminalEdiJapanRfCgoVO = bkgTerminalEdiJapanRfCgoVO;
	}
	public BkgTerminalEdiJapanRfCgoVO getBkgTerminalEdiJapanRfCgoVO(){
		return bkgTerminalEdiJapanRfCgoVO;
	}
	
	public List<BkgTerminalEdiJapanAwkCgoVO> getBkgTerminalEdiJapanAwkCgoVOs() {
		return bkgTerminalEdiJapanAwkCgoVOs;
	}
	public void setBkgTerminalEdiJapanAwkCgoVOs(List<BkgTerminalEdiJapanAwkCgoVO> bkgTerminalEdiJapanAwkCgoVOs) {
		this.bkgTerminalEdiJapanAwkCgoVOs = bkgTerminalEdiJapanAwkCgoVOs;
	}

/*	
	public List<BkgTerminalEdiJapanBlVO> getBkgTerminalEdiJapanBlVOs() {
		return bkgTerminalEdiJapanBlVOs;
	}
	public void setBkgTerminalEdiJapanBlVOs(List<BkgTerminalEdiJapanBlVO> bkgTerminalEdiJapanBlVOs) {
		this.bkgTerminalEdiJapanBlVOs = bkgTerminalEdiJapanBlVOs;
	}
*/	
	public List<BkgTerminalEdiJapanCntrVO> getBkgTerminalEdiJapanCntrVOs() {
		return bkgTerminalEdiJapanCntrVOs;
	}
	public void setBkgTerminalEdiJapanCntrVOs(List<BkgTerminalEdiJapanCntrVO> bkgTerminalEdiJapanCntrVOs) {
		this.bkgTerminalEdiJapanCntrVOs = bkgTerminalEdiJapanCntrVOs;
	}

	public List<BkgTerminalEdiJapanDgCgoVO> getBkgTerminalEdiJapanDgCgoVOs() {
		return bkgTerminalEdiJapanDgCgoVOs;
	}
	public void setBkgTerminalEdiJapanDgCgoVOs(List<BkgTerminalEdiJapanDgCgoVO> bkgTerminalEdiJapanDgCgoVOs) {
		this.bkgTerminalEdiJapanDgCgoVOs = bkgTerminalEdiJapanDgCgoVOs;
	}

	public List<BkgTerminalEdiJapanRfCgoVO> getBkgTerminalEdiJapanRfCgoVOs() {
		return bkgTerminalEdiJapanRfCgoVOs;
	}
	public void setBkgTerminalEdiJapanRfCgoVOs(List<BkgTerminalEdiJapanRfCgoVO> bkgTerminalEdiJapanRfCgoVOs) {
		this.bkgTerminalEdiJapanRfCgoVOs = bkgTerminalEdiJapanRfCgoVOs;
	}
}