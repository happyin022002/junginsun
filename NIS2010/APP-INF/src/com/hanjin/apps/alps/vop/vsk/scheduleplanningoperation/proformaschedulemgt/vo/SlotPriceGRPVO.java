package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.syscommon.common.table.VskSltPrcDtlVO;
import com.hanjin.syscommon.common.table.VskSltPrcPortDtlVO;


public class SlotPriceGRPVO {

	private PortExpenseVO portExpenseVO = null;
	private SlotPriceVO slotPriceVO = null;
	private VskSltPrcDtlVO vskSltPrcDtlVO = null;
	private VskSltPrcPortDtlVO vskSltPrcPortDtlVO = null;
	
	private List<PortExpenseVO> portExpenseVOs = null;
	private List<PfSkdVO> pfSkdVOs = null;
	private List<HireBaseVO> hireBaseVOs = null;
	private List<BunkerCostVO> bunkerCostVOs = null;
	private List<SlotPriceVO> slotPriceVOs = null;
	
	private List<SlotPriceVO[]> slotPriceVOList = null; 
	
	private HashMap<String,SlotPriceVO[]> hMap = new HashMap<String,SlotPriceVO[]>();
	
	public SlotPriceGRPVO(){
		portExpenseVO = new PortExpenseVO();
		slotPriceVO = new SlotPriceVO();
		vskSltPrcDtlVO = new VskSltPrcDtlVO();
		vskSltPrcPortDtlVO = new VskSltPrcPortDtlVO();
		portExpenseVOs = new ArrayList<PortExpenseVO>();
		pfSkdVOs = new ArrayList<PfSkdVO>();
		hireBaseVOs = new ArrayList<HireBaseVO>();
		bunkerCostVOs = new ArrayList<BunkerCostVO>();
		slotPriceVOs = new ArrayList<SlotPriceVO>();
		slotPriceVOList = new ArrayList<SlotPriceVO[]>();
	}
	
	public SlotPriceVO[] getSlotPriceVOListAll() {
		Object[] objs = this.slotPriceVOList.toArray();
		if(objs.length<=0) return null;
		int size = 0;
		for(int i=0;i<objs.length;i++){
			SlotPriceVO[] ps= (SlotPriceVO[]) objs[i];
			if(ps!=null) size += ps.length;
		}
		if(size <= 0) return null;
		SlotPriceVO[] slotPriceVOs = new SlotPriceVO[size];
		int z = 0;
		for(int i=0;i<objs.length;i++){
			SlotPriceVO[] ps= (SlotPriceVO[]) objs[i];
			if(ps!=null){
				for(int j=0;j<ps.length;j++)
					slotPriceVOs[z++] = ps[j];
			}
		}
		return slotPriceVOs;
	}
	
	public void addSlotPriceVOList(SlotPriceVO[] listSlotPriceVO) {
		this.slotPriceVOList.add(listSlotPriceVO);
	}
	
	public void setSlotPriceVOS(SlotPriceVO[] slotPriceVOs,String key){
		hMap.put(key, slotPriceVOs);
	}
	
	public Map<String, SlotPriceVO[]> getSlotPriceVOS() {
		// TODO Auto-generated method stub
		return this.hMap;
	}
	
	public SlotPriceVO[] getSlotPriceVOList(int idx) {
		return this.slotPriceVOList.get(idx);
	}
	
	public void setSlotPriceVO(List<SlotPriceVO[]> listSlotPriceVO) {
		this.slotPriceVOList = listSlotPriceVO;
	}
	
	public void setPortExpenseVO(PortExpenseVO portExpenseVO){
		this.portExpenseVO = portExpenseVO;
	}
	
	public void setSlotPriceVO(SlotPriceVO slotPriceVO){
		this.slotPriceVO = slotPriceVO;
	}
	
	public void setVskSltPrcDtlVO(VskSltPrcDtlVO vskSltPrcDtlVO){
		this.vskSltPrcDtlVO = vskSltPrcDtlVO;
	}
	
	public void setVskSltPrcPortDtlVO(VskSltPrcPortDtlVO vskSltPrcPortDtlVO){
		this.vskSltPrcPortDtlVO = vskSltPrcPortDtlVO;
	}
	
	public PortExpenseVO getPortExpenseVO(){
		return this.portExpenseVO;
	}
	
	public SlotPriceVO getSlotPriceVO(){
		return this.slotPriceVO;
	}
	
	public VskSltPrcDtlVO getVskSltPrcDtlVO(){
		return this.vskSltPrcDtlVO;
	}
	
	public VskSltPrcPortDtlVO getVskSltPrcPortDtlVO(){
		return this.vskSltPrcPortDtlVO;
	}
	
	public void setPortExpenseVOs(List<PortExpenseVO> portExpenseVOs){
		this.portExpenseVOs = portExpenseVOs;
	}
	
	public List<PortExpenseVO> getPortExpenseVOs(){
		return this.portExpenseVOs;
	}
	
	public void setPfSkdVOs(List<PfSkdVO> pfSkdVOs){
		this.pfSkdVOs = pfSkdVOs;
	}
	
	public List<PfSkdVO> getPfSkdVOs(){
		return this.pfSkdVOs;
	}
	
	public void setHireBaseVOs(List<HireBaseVO> hireBaseVOs){
		this.hireBaseVOs = hireBaseVOs;
	}
	
	public List<HireBaseVO> getHireBaseVOs(){
		return this.hireBaseVOs;
	}
	
	public void setBunkerCostVOs(List<BunkerCostVO> bunkerCostVOs){
		this.bunkerCostVOs = bunkerCostVOs;
	}
	
	public List<BunkerCostVO> getBunkerCostVOs(){
		return this.bunkerCostVOs;
	}
	
	public void setSlotPriceVOs(List<SlotPriceVO> slotPriceVOs){
		this.slotPriceVOs = slotPriceVOs;
	}
	
	public List<SlotPriceVO> getSlotPriceVOs(){
		return this.slotPriceVOs;
	}
}
