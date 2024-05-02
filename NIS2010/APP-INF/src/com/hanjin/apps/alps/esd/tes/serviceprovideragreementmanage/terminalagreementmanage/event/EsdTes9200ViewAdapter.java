/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes9200ViewAdapter.java
*@FileTitle : Volume Accumulate Method
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.24 yOng hO lEE
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
public class EsdTes9200ViewAdapter extends ViewAdapter{
	
    /**
     * EsdTes9200ViewAdapter
     */
    public EsdTes9200ViewAdapter()
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
    	DBRowSet				rowSetList		= null;		//DB ResultSet
    	List<DBRowSet>			rsList			= null;

        StringBuilder			sbuXML			= new StringBuilder();

        String					strXML			= "";
        
    	boolean					isupload		= isUploadFile(request);
    	
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
					rsList		= eventResponse.getRsList();
					
					sbuXML.append("<SHEET>\n");

					if ( rsList.size() > 0 ) {
						sbuXML.append("	<ETC-DATA>\n");

						for( int i = 0; i < rsList.size(); i++ ) {
							rowSetList	= (DBRowSet)rsList.get(i);
							sbuXML.append("	<ETC KEY='sxml").append(i).append("'>\n");
							sbuXML.append("		<![CDATA[\n\n");
							sbuXML.append("			<SHEET>\n");
							sbuXML.append("				<DATA TOTAL='").append( rowSetList != null ? rowSetList.getRowCount() : 0).append("'>\n");
							
							// Volume Accumulate Method
							if ( i == 0 && rowSetList != null ) {

								while ( rowSetList.next() ) {
									sbuXML.append("				<TR>\n");
									sbuXML.append("					<TD>R</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("vndr_seq"))		).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("accm_seq"))		).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("ctrt_ofc_cd"))	).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("accm_fm_dt"))	).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("accm_to_dt"))	).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("tml_accm_ut_cd"))).append("</TD>\n");
									sbuXML.append("				</TR>\n");
								}
							} // Volume Accumulate CostCode
							else if ( i == 1 && rowSetList != null ) {
								while( rowSetList.next() ) {
									sbuXML.append("				<TR>\n");
									sbuXML.append("					<TD>R</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("vndr_seq"))).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("accm_seq"))).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("accm_cost_seq"))).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("lgs_cost_cd"))).append("</TD>\n");
									sbuXML.append("				</TR>\n");
								}
							}
							else if ( i == 2 && rowSetList != null ) {
								while( rowSetList.next() ) {
									sbuXML.append("				<TR>\n");
									sbuXML.append("					<TD></TD>\n");
									sbuXML.append("					<TD>R</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("accm_dtl_seq"))).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("yd_cd"))).append("</TD>\n");
									sbuXML.append("					<TD>").append(JSPUtil.getNull(rowSetList.getString("yd_nm"))).append("</TD>\n");
									sbuXML.append("				</TR>\n");
								}
							}

							sbuXML.append("				</DATA>\n");
							sbuXML.append("			</SHEET>\n\n");
							sbuXML.append("		]]>\n\n");
							sbuXML.append("	</ETC>\n");
						}
						sbuXML.append("	</ETC-DATA>\n");
					}
					else {
						// 삭제인 경우처리후 조회
						sbuXML.append("	<ETC-DATA>\n");
						for( int i = 0; i <= 2; i++ ) {
							sbuXML.append("	<ETC KEY='sxml").append(i).append("'>\n");
							sbuXML.append("		<![CDATA[\n\n");
							sbuXML.append("			<SHEET>\n");
							sbuXML.append("				<DATA TOTAL='0'>\n");
							sbuXML.append("				</DATA>\n");
							sbuXML.append("			</SHEET>\n\n");
							sbuXML.append("		]]>\n\n");
							sbuXML.append("	</ETC>\n");
						}
						sbuXML.append("	</ETC-DATA>\n");
						
					}
					
					sbuXML.append("</SHEET>\n");

				}
		       	strXML	= sbuXML.toString();
            }
        } catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
        }

        
		
        if(log.isDebugEnabled())
            log.debug((new StringBuilder("\n")).append(sbuXML.toString()).toString());
 
        return strXML;
    }

    /**
     * @param eventResponse
     * @param request
     * @return String <ETC-DATA>태그 부분의 XML문자열
     */
    @SuppressWarnings("unchecked")
    protected String getETCData(EventResponse eventResponse, HttpServletRequest request)
    {
        if(eventResponse == null)
            return "";
        StringBuilder	sb			= new StringBuilder();
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
    @SuppressWarnings("unchecked")
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
