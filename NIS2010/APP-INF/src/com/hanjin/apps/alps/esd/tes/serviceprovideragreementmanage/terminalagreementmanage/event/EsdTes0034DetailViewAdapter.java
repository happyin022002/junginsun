/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0034DetailViewAdapter.java
*@FileTitle : EsdTes0034Detail 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.13 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author yOng hO lEE
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsdTes0034DetailViewAdapter extends ViewAdapter{
	
    /**
     * EsdTes0034DetailViewAdapter 
     */
    public EsdTes0034DetailViewAdapter()
    {
    	log = Logger.getLogger(getClass().getName());
    }
    
    /**
     * @param HttpServletRequest request
     * @param HttpServletResponse response
     * @return String
     * @see com.hanjin.framework.core.controller.ViewAdapter#makeXML(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public String makeXML(HttpServletRequest request, HttpServletResponse response)
    {
        GeneralEventResponse	eventResponse	= null;
        Exception				serverException	= null;

        StringBuilder			sbuXML			= new StringBuilder();

        String					strXML			= "";

    	boolean		isupload		= isUploadFile(request);
    	
    	try
        {
            serverException = (Exception)request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");

            if(serverException != null)
            {
                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
            } else
            {
                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
                
				if (eventResponse != null) {
					List<DBRowSet>	rsList	= eventResponse.getRsList();
					DBRowSet		agmtCostRowSet				= null;
					DBRowSet		currCodeRowSet				= null;
					DBRowSet		laneCodeRowSet				= null;
					DBRowSet		typeRowSet					= null;
					DBRowSet		sizeRowSet					= null;
					DBRowSet		tpLgsCostRowSet				= null;
					
					// Agreement Cost Code List 
					StringBuilder	sbuLgsCostCDText			= new StringBuilder();		
					StringBuilder	sbuLgsCostCDSheet			= new StringBuilder();		
					StringBuilder	sbuTerminalLgsCostCDText	= new StringBuilder();		
					StringBuilder	sbuTerminalLgsCostCDSheet	= new StringBuilder();		
					StringBuilder	sbuTerminalLgsCostCDName	= new StringBuilder();		
					StringBuilder	sbuTerminalLgsCostCDAbbrName	= new StringBuilder();		
					StringBuilder	sbuStorageLgsCostCDText		= new StringBuilder();		
					StringBuilder	sbuStorageLgsCostCDSheet	= new StringBuilder();
					StringBuilder	sbuStorageLgsCostCDName	= new StringBuilder();
					StringBuilder	sbuStorageLgsCostCDAbbrName	= new StringBuilder();
					
					// Currency Code List
					StringBuilder	sbuCurrCDText				= new StringBuilder("--");		
					StringBuilder	sbuCurrCDTextTemp			= new StringBuilder();		
					StringBuilder	sbuCurrCDSheet				= new StringBuilder();		
					StringBuilder	sbuCurrCDTextDef			= new StringBuilder();
					
//					String			currCDTextString			= "";
					StringBuilder			sbuCurrCDTextString	= new StringBuilder();
					
					// Lane Code List
					StringBuilder	sbuLaneCDText				= new StringBuilder("--");		
					StringBuilder	sbuLaneCDSheet				= new StringBuilder();		
					// Container Type Code List
					StringBuilder	sbuCntrTpCDText				= new StringBuilder("--|All--All");
					// Container Size Code List
					StringBuilder	sbuCntrSzCDText				= new StringBuilder("--|All--All");
					// Container Size Code List
					StringBuilder	sbuTplgsCostCDText			= new StringBuilder();		

					// 이건 반드시 6개

					List	rsCnt	= eventResponse.getDataCntList();
					DBRowSet	[]	arrDBRowSet	= new DBRowSet[6];
					int		row		= 0;
					// DBRowSet 이 RowCount가 0이 아니면.
					if ( rsCnt.size() == rsList.size() ) {
						for ( int k = 0; k < rsList.size(); k++ ) {
							arrDBRowSet[k]	= (DBRowSet)rsList.get(k);
						}
					}
					else {
						for ( int i = 0; i < rsCnt.size(); i++ ) {
							if ( Integer.parseInt( String.valueOf(rsCnt.get(i)) ) > 0 ) {
								arrDBRowSet[i]	= (DBRowSet)rsList.get(row++);	
							}
							else {
								arrDBRowSet[i]	= new DBRowSet();
							}
						}
					}
					
					for ( int j = 0; j < rsCnt.size(); j++ ) {
						if ( j == 0 ) {
							agmtCostRowSet	= arrDBRowSet[0];	// Agreement Cost Code List
						}
						else if ( j == 1 ) {
							currCodeRowSet	= arrDBRowSet[1];	// Currency Code List
						}
						else if ( j == 2 ) {
							laneCodeRowSet	= arrDBRowSet[2];	// Lane Code List
						}
						else if ( j == 3 ) {
							typeRowSet		= arrDBRowSet[3];	// Container Type Code List
						}
						else if ( j == 4 ) {
							sizeRowSet		= arrDBRowSet[4];	// Container Size Code List
						}
						else if ( j == 5 ) {
							tpLgsCostRowSet	= arrDBRowSet[5];	// Cost Code List
						}
					}
					
//					for ( int i = 0; i < rsList.size(); i++ ) {
//						// Agreement Cost Code List
//						agmtCostRowSet	= (DBRowSet)rsList.get(0);	// Agreement Cost Code List
						
						if ( agmtCostRowSet != null ) {	// agmtCostRowSet.getRowCount() > 0  
							
							while ( agmtCostRowSet.next() ) {
								sbuLgsCostCDText.append( JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd") ) )
												.append("--")
												.append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")))
												.append("|");
								sbuLgsCostCDSheet.append( JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")) ).append("|");

								if ( "N".equals( agmtCostRowSet.getString("tml_agmt_div_flg") ) ) {
									sbuTerminalLgsCostCDText.append( JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")) )
															.append( "--")
															.append( JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")))
															.append( "|");
									sbuTerminalLgsCostCDSheet.append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")) ).append( "|");
									// CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
									sbuTerminalLgsCostCDName.append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd_nm"))).append("|");
									sbuTerminalLgsCostCDAbbrName.append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_abbr_nm"))).append("|");
								} else if ( "Y".equals( agmtCostRowSet.getString("tml_agmt_div_flg") ) ) {
									sbuStorageLgsCostCDText	.append( JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")) )
															.append( "--")
															.append( JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")) )
//															.append( JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd"))).append(" || ").append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_abbr_nm")))
															.append("|");
									sbuStorageLgsCostCDSheet.append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd")) ).append("|");
									// CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
									sbuStorageLgsCostCDName.append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_cd_nm"))).append("|");
									sbuStorageLgsCostCDAbbrName.append(JSPUtil.getNull(agmtCostRowSet.getString("lgs_cost_abbr_nm"))).append("|");
								}
							}
						}
						
						// Currency Code List
//						currCodeRowSet	= (DBRowSet)rsList.get(1);	// Currency Code List
						if ( currCodeRowSet != null ) {	// currCodeRowSet.getRowCount() > 0  
							
							// 소스품질 개선사항 반영 - 4347.07.02 yOng hO lEE
							while ( currCodeRowSet.next() ) {
//								currCDTextString  = sbuCurrCDTextTemp1.append("|")
//													 .append(JSPUtil.getNull(currCodeRowSet.getString("ar_curr_cd")))
//													 .append("--")
//													 .append(JSPUtil.getNull(currCodeRowSet.getString("ar_curr_cd"))).toString()
//													 + currCDTextString;
//								sbuCurrCDText.append( currCDTextString );
								sbuCurrCDTextTemp.append("|")
														.append(JSPUtil.getNull(currCodeRowSet.getString("ar_curr_cd")))
														.append("--")
														.append(JSPUtil.getNull(currCodeRowSet.getString("ar_curr_cd"))).toString();
								sbuCurrCDTextString.insert(0, sbuCurrCDTextTemp.toString());
								sbuCurrCDText.append( sbuCurrCDTextString.toString() );
								sbuCurrCDSheet.append("|").append(JSPUtil.getNull(currCodeRowSet.getString("ar_curr_cd")) );
								sbuCurrCDTextDef.append( JSPUtil.getNull(currCodeRowSet.getString("def")) );
								
							}
						}

						// Lane Code List
//						laneCodeRowSet	= (DBRowSet)rsList.get(2);
						if ( laneCodeRowSet != null ) {	
							while ( laneCodeRowSet.next() ) {
								sbuLaneCDText.append(JSPUtil.getNull(laneCodeRowSet.getString("slan_cd")))
											 .append("--")
											 .append(JSPUtil.getNull(laneCodeRowSet.getString("slan_cd")))
											 .append("|");
								sbuLaneCDSheet.append("|").append(JSPUtil.getNull(laneCodeRowSet.getString("slan_cd")) );
							}
						}
							
						// Container Type Code List
//						typeRowSet	= (DBRowSet)rsList.get(3);
						if ( typeRowSet != null ) {	// typeRowSet.getRowCount() > 0
							
							while ( typeRowSet.next() ) {
								sbuCntrTpCDText.append("|")
											   .append(JSPUtil.getNull(typeRowSet.getString("cntr_tp_cd")))
											   .append("--")
											   .append(JSPUtil.getNull(typeRowSet.getString("cntr_tp_cd")));
							}
						}

						// Container Size Code List
//						sizeRowSet	= (DBRowSet)rsList.get(4);
						if ( sizeRowSet != null ) {	// sizeRowSet.getRowCount() > 0
							
							while ( sizeRowSet.next() ) {
								sbuCntrSzCDText.append("|")
											   .append(JSPUtil.getNull(sizeRowSet.getString("cntr_sz_cd")))
											   .append("--")
											   .append(JSPUtil.getNull(sizeRowSet.getString("cntr_sz_cd")));
							}
						}

						// Cost Code List
//						tpLgsCostRowSet	= (DBRowSet)rsList.get(5);
						if ( tpLgsCostRowSet != null ) {	// tpLgsCostRowSet.getRowCount() > 0
							
							while ( tpLgsCostRowSet.next() ) {
								sbuTplgsCostCDText.append(JSPUtil.getNull(tpLgsCostRowSet.getString("lgs_cost_cd"))).append("|");
							}
						}
//					}
					
					sbuXML.append("<SHEET>");
					sbuXML.append( getETCData(eventResponse) );
					sbuXML.append("	<ETC-DATA>\n")
						  .append("		<ETC NAME='tplgsCostCDText'>")	.append(sbuTplgsCostCDText.toString())	.append("</ETC>\n")
						  .append("		<ETC NAME='lgsCostCDText'>")	.append(sbuLgsCostCDText.toString())	.append("</ETC>\n")
						  .append("		<ETC NAME='currCDText'>")		.append(sbuCurrCDSheet.toString())		.append("</ETC>\n")
						  .append("		<ETC NAME='currCDTextDef'>")	.append(sbuCurrCDTextDef.toString())	.append("</ETC>\n")
//						  .append("		<ETC NAME='currCode'>")			.append(strCurrCDCode)					.append("</ETC>\n")
						  .append("		<ETC NAME='laneCDText'>")		.append(sbuLaneCDText.toString())		.append("</ETC>\n") 
						  .append("		<ETC NAME='cntrTPText'>")		.append(sbuCntrTpCDText.toString())		.append("</ETC>\n")
						  .append("		<ETC NAME='cntrSZText'>")		.append(sbuCntrSzCDText.toString())		.append("</ETC>\n")
						  .append("		<ETC NAME='lgsCostCDSheet'>")	.append(sbuLgsCostCDSheet.toString())	.append("</ETC>\n")
						  .append("		<ETC NAME='currCDSheet'>")		.append(sbuCurrCDSheet.toString())		.append("</ETC>\n")
						  .append("		<ETC NAME='laneCDSheet'>")		.append(sbuLaneCDSheet.toString())		.append("</ETC>\n")
//						  .append("		<ETC NAME='regFlg'>")			.append(eventResponse.getETCData("regFlg"))						.append("</ETC>\n")
						  .append("		<ETC NAME='terminalLgsCostCDText'>")	.append(sbuTerminalLgsCostCDText.toString())	.append("</ETC>\n")
						  .append("		<ETC NAME='terminalLgsCostCDSheet'>")	.append(sbuTerminalLgsCostCDSheet.toString())	.append("</ETC>\n")	       	   
						  .append("		<ETC NAME='storageLgsCostCDText'>")		.append(sbuStorageLgsCostCDText.toString())		.append("</ETC>\n")
						  .append("		<ETC NAME='storageLgsCostCDSheet'>")	.append(sbuStorageLgsCostCDSheet.toString())	.append("</ETC>\n")
						  .append("		<ETC NAME='terminalLgsCostCDName'><![CDATA[")	.append(sbuTerminalLgsCostCDName.toString())	.append("]]></ETC>\n")	       	   
						  .append("		<ETC NAME='storageLgsCostCDName'><![CDATA[")	.append(sbuStorageLgsCostCDName.toString())	.append("]]></ETC>\n")
						  // CHM-201642291 Agreement/invoice에서 Cost Code Description 추가 (2016-07-20) 
						  .append("		<ETC NAME='terminalLgsCostCDAbbrName'><![CDATA[")	.append(sbuTerminalLgsCostCDAbbrName.toString())	.append("]]></ETC>\n")	       	   
						  .append("		<ETC NAME='storageLgsCostCDAbbrName'><![CDATA[")	.append(sbuStorageLgsCostCDAbbrName.toString())	.append("]]></ETC>\n")
						  .append("	</ETC-DATA>\n")
						  .append("</SHEET>");
					
        		} // end if        
        	strXML	= sbuXML.toString();
        	}
        }
    	catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
        }
        
        if(log.isDebugEnabled())
            log.debug((new StringBuilder("\n")).append(strXML).toString());
 
        return strXML;
    }

    
    /**
     * @param eventResponse
     * @param request
     * @return String <ETC-DATA>태그 부분의 XML문자열
     */
    protected String getETCData(EventResponse eventResponse, HttpServletRequest request)
    {
        if(eventResponse == null)
            return "";
        StringBuilder			sb			= new StringBuilder();
        HashMap<String, String>	etc_data	= (HashMap<String, String>)eventResponse.getETCData();

        sb.append("<ETC-DATA>\n");
        if(etc_data != null && etc_data.size() > 0)
        {
            String key;
            String val;
            for(Iterator it = etc_data.keySet().iterator(); it.hasNext(); sb.append((new StringBuilder("<ETC KEY='")).append(key).append("'><![CDATA[").append(val).append("]]></ETC>\n").toString()))
            {
                key = (String)it.next();
                val = (new StringBuilder()).append((String)etc_data.get(key)).toString();
            }//for..[]

        }
        sb.append(getPivotETCData(eventResponse));
        sb.append("</ETC-DATA>\n");
        
        return sb.toString();
    }
	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
    protected String makeDataTag(List vos, String prefix)
    {
        StringBuilder sbufXML = new StringBuilder();

        return sbufXML.toString();
    }

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
    protected String makeDataTag(DBRowSet rs, String prefix)
    {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
    
    /**
     * @param request
     * @return boolean
     */
    private boolean isUploadFile(HttpServletRequest request)
    {
        boolean isUpload = false;
        String contentType = request.getContentType();
        if(contentType != null && contentType.startsWith("multipart/form-data"))
            isUpload = true;
        return isUpload;
    }
}
