/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongRangeViewAdapter.java
*@FileTitle : LongRangeViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.20 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.List;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * Long Range SKD을 위한 View Adapter 클래스<br>
 *
 * @author Ryu Hyuk
 * @since J2EE 1.4
 * @see
 */
public class LongRangeMultipleViewAdapter extends ViewAdapter {

	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String arg1) {

		StringBuilder sbufXML = new StringBuilder();
		StringBuilder sbufXML2 = new StringBuilder();
		StringBuilder sbufXML3 = new StringBuilder();
		
		int rowpos = 0;
		
		boolean newVVD = true;
		boolean newVVD2 = true;
		boolean newVVD3 = true;
		LongRangeSkdVO vo = null;
		
		sbufXML.append("<DATA>");
		sbufXML2.append("##<SHEET><DATA>");
		sbufXML3.append("##<SHEET><DATA>");
		
		for(AbstractValueObject o : vos){
		
			vo = (LongRangeSkdVO)o;
			
			if("1".equals(vo.getSheetObjNo())){
				
				if(vo.getPortCd()==null){
//					if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					sbufXML.append("</TR>");
					newVVD = true;
					rowpos++;
					continue;
//					}
				}else if(newVVD){
//					if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					if(rowpos%4==0){
						sbufXML.append("<TR>");
					}else{
						sbufXML.append("<TR HIDDEN=\"TRUE\">");
					}					
					sbufXML.append("<TD><![CDATA[I]]></TD>");
					sbufXML.append(makeTDTag(vo.getVslCd()));
					sbufXML.append(makeTDTag(vo.getVoyNo()));
					sbufXML.append(makeTDTag(vo.getSkdDirCd()));
					sbufXML.append(makeTDTag(vo.getPfSvcTpCd()));
					newVVD = false;
//					}
				}
				
				if(vo.getEtbDyCd()==null){
					vo.setEtbDyCd("");
				}
				
				if(vo.getInitEtbDate()==null){
					vo.setInitEtbDate("");
				}
				
				if(vo.getEtdDyCd()==null){
					vo.setEtdDyCd("");
				}
				
				if(vo.getInitEtdDate()==null){
					vo.setInitEtdDate("");
				}

				if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					if(vo.compareEtbDay()){
						sbufXML.append(makeTDTag(vo.getInitEtbDate()));
					}else{
						sbufXML.append(makeTDTag(vo.getInitEtbDate()));
					}	
					if(vo.compareEtdDay()){
						sbufXML.append(makeTDTag(vo.getInitEtdDate()));
					}else{
						sbufXML.append(makeTDTag(vo.getInitEtdDate()));
					}
				}
				
			}else if("2".equals(vo.getSheetObjNo())){
				if(vo.getPortCd()==null){
//					if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					sbufXML2.append("</TR>");
					newVVD2 = true;
					rowpos++;
					continue;
//					}
				}else if(newVVD2){
//					if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					if(rowpos%4==0){
						sbufXML2.append("<TR>");
					}else{
						sbufXML2.append("<TR HIDDEN=\"TRUE\">");

					}
					sbufXML2.append("<TD><![CDATA[I]]></TD>");
					sbufXML2.append(makeTDTag(vo.getVslCd()));
					sbufXML2.append(makeTDTag(vo.getVoyNo()));
					sbufXML2.append(makeTDTag(vo.getSkdDirCd()));
					sbufXML2.append(makeTDTag(vo.getPfSvcTpCd()));
					newVVD2 = false;
//					}
				}
				
				if(vo.getEtbDyCd()==null){
					vo.setEtbDyCd("");
				}
				
				if(vo.getInitEtbDate()==null){
					vo.setInitEtbDate("");
				}
				
				if(vo.getEtdDyCd()==null){
					vo.setEtdDyCd("");
				}
				
				if(vo.getInitEtdDate()==null){
					vo.setInitEtdDate("");
				}

				if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					if(vo.compareEtbDay()){
						sbufXML2.append(makeTDTag(vo.getInitEtbDate()));
					}else{
						sbufXML2.append(makeTDTag(vo.getInitEtbDate()));
					}
								
					if(vo.compareEtdDay()){
						sbufXML2.append(makeTDTag(vo.getInitEtdDate()));
					}else{
						sbufXML2.append(makeTDTag(vo.getInitEtdDate()));
					}
				}				
			}else if("3".equals(vo.getSheetObjNo())){
				if(vo.getPortCd()==null){
//					if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					sbufXML3.append("</TR>");
					newVVD3 = true;
					rowpos++;
					continue;
//					}
				}else if(newVVD3){
//					if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					if(rowpos%4==0){
						sbufXML3.append("<TR>");
					}else{
						sbufXML3.append("<TR HIDDEN=\"TRUE\">");

					}						
					sbufXML3.append("<TD><![CDATA[I]]></TD>");
					sbufXML3.append(makeTDTag(vo.getVslCd()));
					sbufXML3.append(makeTDTag(vo.getVoyNo()));
					sbufXML3.append(makeTDTag(vo.getSkdDirCd()));
					sbufXML3.append(makeTDTag(vo.getPfSvcTpCd()));
					newVVD3 = false;
//					}
				}
				
				if(vo.getEtbDyCd()==null){
					vo.setEtbDyCd("");
				}
				
				if(vo.getInitEtbDate()==null){
					vo.setInitEtbDate("");
				}
				
				if(vo.getEtdDyCd()==null){
					vo.setEtdDyCd("");
				}
				
				if(vo.getInitEtdDate()==null){
					vo.setInitEtdDate("");
				}
				
				if(!"".equals(vo.getInitEtbDate()) || !"".equals(vo.getInitEtdDate()) ){
					if(vo.compareEtbDay()){
						sbufXML3.append(makeTDTag(vo.getInitEtbDate()));
					}else{
						sbufXML3.append(makeTDTag(vo.getInitEtbDate()));
					}

					if(vo.compareEtdDay()){
						sbufXML3.append(makeTDTag(vo.getInitEtdDate()));
					}else{
						sbufXML3.append(makeTDTag(vo.getInitEtdDate()));
					}

				}
			}else{
				
				if(vo.getPortCd()==null){
					sbufXML.append("</TR>");
					newVVD = true;
					rowpos++;
					continue;
				}else if(newVVD){
					if(rowpos%4==0){
						sbufXML.append("<TR>");
					}else{
						sbufXML.append("<TR HIDDEN=\"TRUE\">");
//						sbufXML.append("<TR>");
					}
					
					sbufXML.append("<TD><![CDATA[I]]></TD>");
					sbufXML.append(makeTDTag(vo.getVslCd()));
					sbufXML.append(makeTDTag(vo.getVoyNo()));
					sbufXML.append(makeTDTag(vo.getSkdDirCd()));
					sbufXML.append(makeTDTag(vo.getPfSvcTpCd()));
					newVVD = false;
				}
				
				if(vo.getEtbDyCd()==null){
					vo.setEtbDyCd("");
				}
				
				if(vo.getInitEtbDate()==null){
					vo.setInitEtbDate("");
				}
				
				if(vo.getEtdDyCd()==null){
					vo.setEtdDyCd("");
				}
				
				if(vo.getInitEtdDate()==null){
					vo.setInitEtdDate("");
				}
				
				if(vo.compareEtbDay()){
					sbufXML.append(makeTDTag(vo.getInitEtbDate()));
				}else{
					sbufXML.append(makeTDTag(vo.getInitEtbDate()));
				}
				
				if(vo.compareEtdDay()){
					sbufXML.append(makeTDTag(vo.getInitEtdDate()));
				}else{
					sbufXML.append(makeTDTag(vo.getInitEtdDate()));
				}
			
			}
		}
		
		sbufXML.append("</DATA></SHEET>");
		sbufXML2.append("</DATA></SHEET>");
		sbufXML3.append("</DATA></SHEET>");
		
		sbufXML.append(sbufXML2.toString());
		sbufXML.append(sbufXML3.toString());
		
		sbufXML.append("##<SHEET><DATA></DATA>");
		
		return sbufXML.toString();
		
	}

	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String makeTDTag(String tdValue){
		return makeTDTag(tdValue, null);			
	}
	
	private String makeTDTag(String tdValue, String color){
		
		StringBuilder sbufXML = new StringBuilder();
		if(color==null){
			sbufXML.append("<TD>");	
		}else{
			sbufXML.append("<TD BGCOLOR=\"").append(color).append("\">");
		}
		sbufXML.append("<![CDATA[");
		sbufXML.append(tdValue);
		sbufXML.append("]]>");
		sbufXML.append("</TD>");
		return sbufXML.toString();
		
	}

}
