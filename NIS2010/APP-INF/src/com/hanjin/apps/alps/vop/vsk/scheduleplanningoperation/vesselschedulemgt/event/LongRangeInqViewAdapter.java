/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongRangeInqViewAdapter.java
*@FileTitle : LongRangeInqViewAdapter
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.20 유혁
* 1.0 Creation
*
* History
* 2010.12.27 CHM-201007036-01 진마리아 Down Excel Format 변경 요청건
* 2011.02.15 CHM-201108927-01 진마리아 Delay 표기 조건 변경. PF대비 날짜가 달라진 경우에만 표기.
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LongRangeSkdInqVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.DefaultViewAdapter;

/**
 * Long Range SKD을 위한 View Adapter 클래스<br>
 *
 * @author Ryu Hyuk
 * @since J2EE 1.4
 * @see
 */
public class LongRangeInqViewAdapter extends DefaultViewAdapter {
	
	private int remarkCount = 1;

	@Override
	protected String makeDataTag(List<AbstractValueObject> vos, String arg1) {
		
		StringBuilder 		sbufXML = new StringBuilder();
		LongRangeSkdInqVO 	vo 		= null;
		
		if(vos.size()>0){
			Object o = vos.get(0);
			if(!(o instanceof LongRangeSkdInqVO)){
				return super.makeDataTag(vos, arg1);
			}
		}
		
		sbufXML.append("<DATA>");
		
		// SKD Remark를 표시하기 위한 그리드인 경우
		if(vos.size()>0){
			vo = (LongRangeSkdInqVO)vos.get(0);
			if(vo.isRemarkFlag()){
				makeRemarkTag(vos, sbufXML);
			}else{
				makeSkdTag(vos, sbufXML);
			}
		}
		
		sbufXML.append("</DATA>");
		return sbufXML.toString();
	
	}
	
	/**
	 * Remark 그리드의 한 개의 Row에 매핑되는 XML을 만든다.
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param StringBuilder sbufXML
	 */
	private void makeRemarkTag(List<AbstractValueObject> vos, StringBuilder sbufXML){
		LongRangeSkdInqVO vo = null;
		
		for(int i=0; i<vos.size(); i++){
			vo = (LongRangeSkdInqVO)vos.get(i);
			sbufXML.append("<TR>");
			sbufXML.append(makeTDTag("R" + (i+1)));
			sbufXML.append(makeTDTag(vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd()));
			sbufXML.append(makeTDTag(vo.getVpsRmk()));

			sbufXML.append("</TR>");
		}
	}
	
	/**
	 * Skd 그리드의 한 개의 Row에 매핑되는 XML을 만든다.
	 * 
	 * @param List<AbstractValueObject> vos
	 * @param StringBuilder sbufXML
	 */
	private void makeSkdTag(List<AbstractValueObject> vos, StringBuilder sbufXML){
		LongRangeSkdInqVO vo = null;
		
		List<List<LongRangeSkdInqVO>> 	gridData 	= new ArrayList<List<LongRangeSkdInqVO>>();
		List<LongRangeSkdInqVO> 		rowData 	= new ArrayList<LongRangeSkdInqVO>();
		
		// 한줄 단위로 나누기
		for(int i=0; i<vos.size(); i++){
			vo = (LongRangeSkdInqVO)vos.get(i);
			if(vo != null){
				rowData.add(vo);
			}else{
				gridData.add(rowData);
				rowData = new ArrayList<LongRangeSkdInqVO>();
			}
			
			if(i == vos.size()-1){
				gridData.add(rowData);
			}
		}
		
		for(int i=0; i<gridData.size(); i++){
			rowData = gridData.get(i);
			makeSkdTagByDate	(rowData, sbufXML);
			makeSkdTagByClptSeq	(rowData, sbufXML);
			makeSkdTagByEst		(rowData, sbufXML);
		}
		
	}
	
	private void makeSkdTagByDate(List<LongRangeSkdInqVO> rowData, StringBuilder sbufXML){
		LongRangeSkdInqVO vo = null;
		
		sbufXML.append("<TR>");
		sbufXML.append("<TD><![CDATA[R]]></TD>");

		sbufXML.append(makeTDTag(getVslSlanCd	(rowData)));
		sbufXML.append(makeTDTag(getPfSkdTpCd	(rowData)));
		sbufXML.append(makeTDTag(getVslEngNm	(rowData))); //2015.07.01 추가됨

		sbufXML.append(makeTDTag(getVesselCode	(rowData)));
		sbufXML.append(makeTDTag(getVoyageNo	(rowData)));
		sbufXML.append(makeTDTag(getDirCode		(rowData)));		
		sbufXML.append(makeTDTag(getActCrrCode	(rowData)));
		
		
		for(int m=0; m<rowData.size(); m++){
			vo = rowData.get(m);
			makeETBDateTag(vo, sbufXML);
			makeETDDateTag(vo, sbufXML);
			// pseudo 컬럼추가
			sbufXML.append(makeTDTag(""));
		}
		
		remarkCount = getRemark(sbufXML, rowData, remarkCount);
		
		sbufXML.append(getCreUpdInfo(rowData));
		sbufXML.append("</TR>");

	}
	
	private void makeSkdTagByEst(List<LongRangeSkdInqVO> rowData, StringBuilder sbufXML){
		LongRangeSkdInqVO vo = null;
		
		sbufXML.append("<TR HIDDEN=\"TRUE\">");
//		sbufXML.append("<TR HIDDEN=\"FALSE\">");
		sbufXML.append("<TD><![CDATA[R]]></TD>");
		
		sbufXML.append(makeTDTag(getVslSlanCd	(rowData)));
		sbufXML.append(makeTDTag(getPfSkdTpCd	(rowData)));
		sbufXML.append(makeTDTag(getVslEngNm	(rowData))); //2015.07.01 추가됨

		sbufXML.append(makeTDTag(getVesselCode	(rowData)));
		sbufXML.append(makeTDTag(getVoyageNo	(rowData)));
		sbufXML.append(makeTDTag(getDirCode		(rowData)));
//		sbufXML.append(makeTDTag(getVslEngNm	(rowData))); //2015.07.01 추가됨

		sbufXML.append(makeTDTag(getActCrrCode	(rowData)));
		
		
		for(int m=0; m<rowData.size(); m++){
			vo = rowData.get(m);
			makeETBTag(vo, sbufXML);
			makeETDTag(vo, sbufXML);
			// pseudo 컬럼추가
			sbufXML.append(makeTDTag(""));
		}
		
		// Remark 셀 위치에 공백 입력
		sbufXML.append(makeTDTag(" "));
		
		sbufXML.append(getCreUpdInfo(rowData));
		sbufXML.append("</TR>");

	}
	
	private void makeSkdTagByClptSeq(List<LongRangeSkdInqVO> rowData, StringBuilder sbufXML){
		LongRangeSkdInqVO vo = null;
		
		sbufXML.append("<TR HIDDEN=\"TRUE\">");
//		sbufXML.append("<TR HIDDEN=\"FALSE\">");
		sbufXML.append("<TD><![CDATA[R]]></TD>");
		
		sbufXML.append(makeTDTag(getVslSlanCd	(rowData)));
		sbufXML.append(makeTDTag(getPfSkdTpCd	(rowData)));
		sbufXML.append(makeTDTag(getVslEngNm	(rowData)));
		sbufXML.append(makeTDTag(getVesselCode	(rowData)));
		sbufXML.append(makeTDTag(getVoyageNo	(rowData)));
		sbufXML.append(makeTDTag(getDirCode		(rowData)));
		sbufXML.append(makeTDTag(getActCrrCode	(rowData)));
		
		
		for(int m=0; m<rowData.size(); m++){
			vo = rowData.get(m);
			sbufXML.append(makeTDTag(vo.getClptSeq()));
			sbufXML.append(makeTDTag(vo.getClptSeq()));
			// pseudo 컬럼추가
			sbufXML.append(makeTDTag(""));
		}
		
		// Remark 셀 위치에 공백 입력
		sbufXML.append(makeTDTag(""));

		sbufXML.append(getCreUpdInfo(rowData));
		sbufXML.append("</TR>");

	}
	
	/**
	 * Skd 그리드 상의 하나의 Row 데이타에서 Lane Code를 구한다.
	 * 
	 * @param List<LongRangeSkdInqVO> rowData
	 * @return String
	 */
	private String getVslSlanCd(List<LongRangeSkdInqVO> rowData){
		//LongRangeSkdInqVO first = rowData.get(0);
		LongRangeSkdInqVO first = findFirstSkd(rowData);
		return first.getVslSlanCd()==null?"":first.getVslSlanCd();
	}
	
	/**
	 * Skd 그리드 상의 하나의 Row 데이타에서 PF SKD Type Code를 구한다.
	 * 
	 * @param List<LongRangeSkdInqVO> rowData
	 * @return String
	 */
	private String getPfSkdTpCd(List<LongRangeSkdInqVO> rowData){
		//LongRangeSkdInqVO first = rowData.get(0);
		LongRangeSkdInqVO first = findFirstSkd(rowData);
		return first.getPfSkdTpCd()==null?"":first.getPfSkdTpCd();
	}
	
	/**
	 * Skd 그리드 상의 하나의 Row 데이타에서 Vessel Code를 구한다.
	 * 
	 * @param List<LongRangeSkdInqVO> rowData
	 * @return String
	 */
	private String getVesselCode(List<LongRangeSkdInqVO> rowData){
		//LongRangeSkdInqVO first = rowData.get(0);
		LongRangeSkdInqVO first = findFirstSkd(rowData);
		return first.getVslCd();
	}
	
	/**
	 * Skd 그리드 상의 하나의 Row 데이타에서 Voyage No를 구한다.
	 * 두 개의 Voyage No가 존재하는 경우, 슬래쉬(/)로 구분하여 하나의 문자열로 만든다.
	 * 
	 * @param List<LongRangeSkdInqVO> rowData
	 * @return String
	 */
	private String getVoyageNo(List<LongRangeSkdInqVO> rowData){
		//LongRangeSkdInqVO first = rowData.get(0);
		//LongRangeSkdInqVO end = rowData.get(rowData.size()-1);
		LongRangeSkdInqVO first = findFirstSkd(rowData);
		LongRangeSkdInqVO last 	= findLastSkd(rowData);
		
		if(first.getSkdVoyNo().equals(last.getSkdVoyNo())){
			return first.getSkdVoyNo();
		}else{
			return first.getSkdVoyNo() + "/" + last.getSkdVoyNo();
		}
	}
	
	/**
	 * Skd 그리드 상의 하나의 Row 데이타에서 Direction Code를 구한다.
	 * 두 개의 Direction Code가 존재하는 경우, 슬래쉬(/)로 구분하여 하나의 문자열로 만든다.
	 * 
	 * @param List<LongRangeSkdInqVO> rowData
	 * @return String
	 */
	private String getDirCode(List<LongRangeSkdInqVO> rowData){
		//LongRangeSkdInqVO first = rowData.get(0);
		//LongRangeSkdInqVO end = rowData.get(rowData.size()-1);
		LongRangeSkdInqVO first = findFirstSkd(rowData);
		LongRangeSkdInqVO last 	= findLastSkd(rowData);
		
		if(first.getSkdDirCd().equals(last.getSkdDirCd())){
			return first.getSkdDirCd();
		}else{
			return first.getSkdDirCd() + "/" + last.getSkdDirCd();
		}
	}
	
	/**
	 * Skd 그리드 상의 하나의 Row 데이타에서 Direction Code를 구한다.
	 * 두 개의 Direction Code가 존재하는 경우, 슬래쉬(/)로 구분하여 하나의 문자열로 만든다.
	 * 
	 * @param List<LongRangeSkdInqVO> rowData
	 * @return String
	 */
	private String getActCrrCode(List<LongRangeSkdInqVO> rowData){
		//LongRangeSkdInqVO first = rowData.get(0);
		//LongRangeSkdInqVO end = rowData.get(rowData.size()-1);
		
		LongRangeSkdInqVO first = findFirstSkd(rowData);
		return first.getActCrrCd()==null?"":first.getActCrrCd();
	}	
	
	/**
	 * Skd 그리드 상의 하나의 Row 데이타에서 Vessel English Name을 구한다.
	 * 
	 * @param List<LongRangeSkdInqVO> rowData
	 * @return String
	 */
	private String getVslEngNm(List<LongRangeSkdInqVO> rowData){
		//LongRangeSkdInqVO first = rowData.get(0);
		//LongRangeSkdInqVO end = rowData.get(rowData.size()-1);
		
		LongRangeSkdInqVO first = findFirstSkd(rowData);
		return first.getVslEngNm()==null?"":first.getVslEngNm();
	}	
	
	/**
	 * Skd 그리드에 추가될 ETB Date Xml Tag를 만든다.
	 * 
	 * @param LongRangeSkdInqVO vo
	 * @param StringBuilder sbufXML
	 */
	private void makeETBDateTag(LongRangeSkdInqVO vo, StringBuilder sbufXML){
		// ETB 데이타가 없을때를 표시하던 nulll 스트링("")을 공백(" ")으로 바꾼다.
		// 왜냐하면 스케쥴이 엑셀에서 표시될때 잘 표시되도록 하기 위해서이다. 
		if(vo==null){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else if(vo.isEmptySkd()){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd");
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
			
			String vpsEtbDtStr = vo.getVpsEtbDt();
			String pfEtbDtStr = vo.getPfEtbDt();
			boolean delay = false;
			
			try {
				if(VSKGeneralUtil.getCheckNullToString(vpsEtbDtStr).length() > 0 && VSKGeneralUtil.getCheckNullToString(pfEtbDtStr).length() > 0){ 

//					CHM-201108927-01
//					Date vpsEtbDt = sdf1.parse(vpsEtbDtStr);
//					Date pfEtbDt = sdf1.parse(pfEtbDtStr);
					Date vpsEtbDt = sdf3.parse(vpsEtbDtStr);
					Date pfEtbDt = sdf3.parse(pfEtbDtStr);
					
					if(vpsEtbDt.after(pfEtbDt)){
						delay = true;
					}
				}
				
				if(vo.getVpsEtbDt()!=null){
					if("R".equals(vo.getSkdCngStsCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr)), "GRAY"));
					}else if("S".equals(vo.getSkdCngStsCd())){
						sbufXML.append(makeTDTag(" SKIP", "GREEN"));
					}else if(delay){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr)), "YELLOW"));
					}else if(vo.isReverse()){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr)), "GRAY"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "D".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr)), "0,255,255"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "R".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr)), "RED"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "I".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr)), "165,42,42"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "O".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr)), "255,165,0"));
					}else{
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr))));
					}
				}else{
					//sbufXML.append(makeTDTag(""));
					sbufXML.append(makeTDTag(" "));
				}	
			} catch (ParseException e) {
				log.error(e.getMessage());
				//sbufXML.append(makeTDTag(""));
				sbufXML.append(makeTDTag(" "));
			}
		}
	}
	
	/**
	 * Skd 그리드에 추가될 ETB Xml Tag를 만든다.
	 * 
	 * @param LongRangeSkdInqVO vo
	 * @param StringBuilder sbufXML
	 */
	private void makeETBTag(LongRangeSkdInqVO vo, StringBuilder sbufXML){
		// ETB 데이타가 없을때를 표시하던 nulll 스트링("")을 공백(" ")으로 바꾼다.
		// 왜냐하면 스케쥴이 엑셀에서 표시될때 잘 표시되도록 하기 위해서이다. 
		if(vo==null){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else if(vo.isEmptySkd()){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/ddyyyyHHmm");
			
			String vpsEtbDtStr = vo.getVpsEtbDt();
			
			try {
				if(vo.getVpsEtbDt()!=null){
					sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtbDtStr))));
				}else{
					sbufXML.append(makeTDTag(" "));
				}	
			} catch (ParseException e) {
				log.error(e.getMessage());
				sbufXML.append(makeTDTag(" "));
			}
		}
	}
	
	/**
	 * Skd 그리드에 추가될 ETD Date Xml Tag를 만든다.
	 * 
	 * @param LongRangeSkdInqVO vo
	 * @param StringBuilder sbufXML
	 */
	private void makeETDDateTag(LongRangeSkdInqVO vo, StringBuilder sbufXML){
		// ETD 데이타가 없을때를 표시하던 nulll 스트링("")을 공백(" ")으로 바꾼다.
		// 왜냐하면 스케쥴이 엑셀에서 표시될때 잘 표시되도록 하기 위해서이다. 
		if(vo==null){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else if(vo.isEmptySkd()){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd");
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
			
			String vpsEtdDtStr = vo.getVpsEtdDt();
			String pfEtdDtStr = vo.getPfEtdDt();
			boolean delay = false;
			
			try {
				
				if(VSKGeneralUtil.getCheckNullToString(vpsEtdDtStr).length() > 0 && VSKGeneralUtil.getCheckNullToString(pfEtdDtStr).length() > 0){
					
//					CHM-201108927-01
//					Date vpsEtdDt = sdf1.parse(vpsEtdDtStr);
//					Date pfEtdDt = sdf1.parse(pfEtdDtStr);
					Date vpsEtdDt = sdf3.parse(vpsEtdDtStr);
					Date pfEtdDt = sdf3.parse(pfEtdDtStr);
					
					if(vpsEtdDt.after(pfEtdDt)){
						delay = true;
					}
				}
				
				if(vo.getVpsEtdDt()!=null){
					if("R".equals(vo.getSkdCngStsCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr)), "GRAY"));	
					}else if("S".equals(vo.getSkdCngStsCd())){
						sbufXML.append(makeTDTag(" SKIP", "GREEN"));
					}else if(delay){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr)), "YELLOW"));
					}else if(vo.isReverse()){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr)), "GRAY"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "D".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr)), "0,255,255"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "R".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr)), "RED"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "I".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr)), "165,42,42"));
					}else if("O".equals(vo.getSkdCngStsCd()) && "O".equals(vo.getPhsIoRsnCd())){
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr)), "255,165,0"));
					}else{
						sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr))));
					}
				}else{
					//sbufXML.append(makeTDTag(""));
					sbufXML.append(makeTDTag(" "));
				}	
			} catch (ParseException e) {
				log.error(e.getMessage());
				//sbufXML.append(makeTDTag(""));
				sbufXML.append(makeTDTag(" "));
			}
		}
	}
	
	/**
	 * Skd 그리드에 추가될 ETD Xml Tag를 만든다.
	 * 
	 * @param LongRangeSkdInqVO vo
	 * @param StringBuilder sbufXML
	 */
	private void makeETDTag(LongRangeSkdInqVO vo, StringBuilder sbufXML){
		// ETD 데이타가 없을때를 표시하던 nulll 스트링("")을 공백(" ")으로 바꾼다.
		// 왜냐하면 스케쥴이 엑셀에서 표시될때 잘 표시되도록 하기 위해서이다. 
		if(vo==null){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else if(vo.isEmptySkd()){
			//sbufXML.append(makeTDTag(""));
			sbufXML.append(makeTDTag(" "));
		}else{
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/ddyyyyHHmm");
			
			String vpsEtdDtStr = vo.getVpsEtdDt();
			
			try {
				if(vo.getVpsEtdDt()!=null){
					sbufXML.append(makeTDTag(sdf2.format(sdf1.parse(vpsEtdDtStr))));
				}else{
					sbufXML.append(makeTDTag(" "));
				}	
			} catch (ParseException e) {
				log.error(e.getMessage());
				sbufXML.append(makeTDTag(" "));
			}
		}
	}
	
	/**
	 * Skd 그리드에 추가될 Remark 여부 Xml Tag를 만든다.
	 * 
	 * @param LongRangeSkdInqVO vo
	 * @param StringBuilder sbufXML
	 */
	private int getRemark(StringBuilder sbufXML, List<LongRangeSkdInqVO> rowData, int remarkCount){
		//LongRangeSkdInqVO first = rowData.get(0);
		//LongRangeSkdInqVO last = rowData.get(rowData.size()-1);
		
		LongRangeSkdInqVO 	first 	= findFirstSkd(rowData);
		LongRangeSkdInqVO 	last 	= findLastSkd(rowData);
		
		String 				remark1 = first.getVpsRmk();
		String 				remark2 = last.getVpsRmk();
		
		remark1 = remark1==null?"":remark1.trim();
		remark2 = remark2==null?"":remark2.trim();
		
		if(
			first.getVslCd().equals(last.getVslCd()) &&
			first.getSkdVoyNo().equals(last.getSkdVoyNo()) &&
			first.getSkdDirCd().equals(last.getSkdDirCd())
		){
			if(!"".equals(remark1)){
				remark1 = "R" + remarkCount++;
				remark2 = "";
			}	
		}else{
			if(!"".equals(remark1)){
				remark1 = "R" + remarkCount++;
			}
			
			if(!"".equals(remark2)){
				remark2 = "R" + remarkCount++;
			}			
		}
		
		if(remark1.length()>0 && remark2.length()>0){
			sbufXML.append(makeTDTag(remark1 + "/" + remark2));
		}else if(remark1.length()==0 && remark2.length()==0){
			// remark1, remark2가 모두 없는 경우 공백(" ")으로 생성. 엑셀에서 스케쥴이 잘 표시되도록 하기 위함.
			sbufXML.append(makeTDTag(" "));
		}else{
			sbufXML.append(makeTDTag(remark1 + remark2));
		}
		
		return remarkCount;
	}
	
	private String getCreUpdInfo(List<LongRangeSkdInqVO> rowData){
		LongRangeSkdInqVO first = findFirstSkd(rowData);// rowData.get(0);
		LongRangeSkdInqVO last = findLastSkd(rowData);// rowData.get(rowData.size()-1);

//		sbufXML.append(makeTDTag(first.getVslEngNm	())); //2015.07.01 추가됨

		
		if(
			first.getVslCd().equals(last.getVslCd()) &&
			first.getSkdVoyNo().equals(last.getSkdVoyNo()) &&
			first.getSkdDirCd().equals(last.getSkdDirCd())
		){
			log.debug("empty");
		}else{
			log.debug("empty");
		}
		
		StringBuilder sbufXML = new StringBuilder();
		sbufXML.append(makeTDTag(first.getCreDt		()));
		sbufXML.append(makeTDTag(first.getCreUsrId	()));
		sbufXML.append(makeTDTag(first.getUpdDt		()));
		sbufXML.append(makeTDTag(first.getUpdUsrId	()));
		
		return sbufXML.toString();
	}
	
	@Override
	protected String makeDataTag(DBRowSet arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Skd 그리들에 추가될 TD Tag를 만든다.
	 * 
	 * @param String tdValue
	 */
	private String makeTDTag(String tdValue){
		return makeTDTag(tdValue, null);			
	}
	
	/**
	 * Skd 그리들에 추가될 TD Tag를 만든다. color 값이 입력된 경우 TD Tag의 속성 값으로 표기한다.
	 * 
	 * @param String tdValue
	 * @param String color
	 */
	private String makeTDTag(String tdValue, String color){
		
		StringBuilder sbufXML = new StringBuilder();
		if(color == null){
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
	
	private LongRangeSkdInqVO findFirstSkd(List<LongRangeSkdInqVO> rowData){
		LongRangeSkdInqVO first = null;
		for(LongRangeSkdInqVO vo : rowData){
			if(vo.isEmptySkd()){
				continue;
			}else{
				first = vo;
				break;
			}
		}
		return first;
	}
	
	private LongRangeSkdInqVO findLastSkd(List<LongRangeSkdInqVO> rowData){
		LongRangeSkdInqVO last 	= null;
		LongRangeSkdInqVO vo 	= null;
		
		for(int i=rowData.size()-1; i>=0; i--){
			vo = rowData.get(i);
			if(vo.isEmptySkd()){
				continue;
			}else{
				last = vo;
				break;
			}
		}
		return last;
	}

}
