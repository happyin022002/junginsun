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
public class LongRangeViewAdapter extends ViewAdapter {

	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String arg1) {

		StringBuilder sbufXML = new StringBuilder();
		
		int rowpos = 0;
		
		boolean newVVD = true;
		LongRangeSkdVO vo = null;
		
		sbufXML.append("<DATA>");
		
		for(AbstractValueObject o : vos){
			
			vo = (LongRangeSkdVO)o;
			
			if(vo.getPortCd()==null && newVVD==false){
				
				sbufXML.append("</TR>");
				newVVD = true;
				rowpos++;
				continue;
				
			}else if(newVVD){
				
				if(rowpos%4==0 && vo.getVslCd() != null){
					sbufXML.append("<TR>");
				}else{
					sbufXML.append("<TR HIDDEN=\"TRUE\">");
//					sbufXML.append("<TR>");
				}
				if(vo.getVslCd() != null ){
					sbufXML.append("<TD><![CDATA[I]]></TD>");
				}else{
					sbufXML.append("<TD><![CDATA[R]]></TD>");
				}
				sbufXML.append(makeTDTag(vo.getVslCd()));
				sbufXML.append(makeTDTag(vo.getVoyNo()));
				sbufXML.append(makeTDTag(vo.getSkdDirCd()));
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
		
		sbufXML.append("</DATA>");
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
