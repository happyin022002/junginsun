/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes0034ViewAdapter.java
*@FileTitle : EsdTes0034 관리
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
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author yOng hO lEE
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsdTes0034ViewAdapter extends ViewAdapter{
    /**
     * EsdTes0034ViewAdapter 
     */
    public EsdTes0034ViewAdapter()
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
        Event						event				= null;
        GeneralEventResponse	eventResponse	= null;
        Exception					serverException	= null;
    	DBRowSet				rowSet			= null;		//DB ResultSet

        StringBuilder		sbuXML					= new StringBuilder();

        String				strXML					= "";
        String				tml_agmt_ofc_cty_cd	= "";
        String				tml_agmt_ver_no		= "";
        String				yd_cd						= "";
        String				yd_nm						= "";
        String				vndr_seq					= "";
        String				vndr_lgl_eng_nm		= "";
        String				ctrt_ofc_cd				= "";
        String				eff_fm_dt					= "";
        String				eff_to_dt					= "";
        String				auto_xtd_flg				= "";
        String				tml_agmt_sts_cd			= "";
        String				agmt_rmk					= "";
        String				lgs_cost_cd				= "";
        String				auto_calc_flg				= "";
        String				tml_agmt_vol_ut_cd		= "";
        String				curr_cd					= "";
        String				thrp_cost_cd_flg			= "";
        String				tml_sto_agmt_tp_cd		= "";
        String				cmnc_hrmnt				= "";
        String				tml_agmt_tp_cd			= "";
        String				cre_ofc_cd				= "";
        String				agmt_apro_dt			= "";
        String				agmt_cfm_dt				= "";
        // AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : 양양선B 4347-08-27) 
        String				agmt_cfm_flg				= "";
        String				cre_usr_id				= "";

        // 비용지급 전표 결재 기능 - 3차 (4347-09-25) 
        String				agmt_doc_no			= "";
        String				agmt_doc_desc			= "";
        String				agmt_doc_eff_fm_dt		= "";
        String				agmt_doc_eff_to_dt		= "";
        
    	boolean			isupload					= isUploadFile(request);
    	
    	int					rowCount					= 0;
    	
    	try
        {
            serverException = (Exception)request.getAttribute("com.hanjin.framework.core.comm.EXCEPTION_OBJECT      ");
            if(serverException != null)
            {
                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
            } else
            {
                event = (Event)request.getAttribute("Event");
                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
                
        		if (eventResponse != null) {
        			rowSet		= eventResponse.getRs();
        			
        			if ( rowSet != null) { 
            			rowCount	= rowSet.getRowCount();
            			
            			if ( rowSet.next() ) {
	        				tml_agmt_ofc_cty_cd	= JSPUtil.getNull(rowSet.getString("tml_agmt_ofc_cty_cd"))+JSPUtil.getNull(rowSet.getString("tml_agmt_seq"));
	        				tml_agmt_ver_no  	= JSPUtil.getNull(rowSet.getString("tml_agmt_ver_no").trim());	// ver_no > tml_agmt_ver_no
	        				yd_cd 					= JSPUtil.getNull(rowSet.getString("yd_cd").trim());
	        				yd_nm 				= JSPUtil.getNull(rowSet.getString("yd_nm").trim());
	        				vndr_seq      		= JSPUtil.getNull(rowSet.getString("vndr_seq").trim());
	        				vndr_lgl_eng_nm 	= JSPUtil.getNull(rowSet.getString("vndr_lgl_eng_nm").trim());
	        				ctrt_ofc_cd     		= JSPUtil.getNull(rowSet.getString("ctrt_ofc_cd").trim());
	        				eff_fm_dt          	= JSPUtil.getNull(rowSet.getString("eff_fm_dt").trim());
	        				eff_to_dt         		= JSPUtil.getNull(rowSet.getString("eff_to_dt").trim());
	        				auto_xtd_flg       	= JSPUtil.getNull(rowSet.getString("auto_xtd_flg").trim());
	        				tml_agmt_sts_cd    	= JSPUtil.getNull(rowSet.getString("tml_agmt_sts_cd").trim());
	        				agmt_rmk          	= JSPUtil.getNull(rowSet.getString("agmt_rmk").trim());
	        				lgs_cost_cd        	= JSPUtil.getNull(rowSet.getString("lgs_cost_cd").trim());
	        				auto_calc_flg      	= JSPUtil.getNull(rowSet.getString("auto_calc_flg").trim());
	        				tml_agmt_vol_ut_cd	= JSPUtil.getNull(rowSet.getString("tml_agmt_vol_ut_cd").trim());
	        				curr_cd				= JSPUtil.getNull(rowSet.getString("curr_cd").trim());
	        				thrp_cost_cd_flg		= JSPUtil.getNull(rowSet.getString("thrp_cost_cd_flg").trim());
	        				tml_sto_agmt_tp_cd	= JSPUtil.getNull(rowSet.getString("tml_sto_agmt_tp_cd").trim());
	        				cmnc_hrmnt         	= JSPUtil.getNull(rowSet.getString("cmnc_hrmnt").trim());
	        				tml_agmt_tp_cd     	= JSPUtil.getNull(rowSet.getString("tml_agmt_tp_cd").trim());
	        				cre_ofc_cd         	= JSPUtil.getNull(rowSet.getString("cre_ofc_cd").trim());
	        				agmt_apro_dt        = JSPUtil.getNull(rowSet.getString("agmt_apro_dt").trim());
	        				agmt_cfm_dt			= JSPUtil.getNull(rowSet.getString("agmt_cfm_dt").trim());
	        				// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : 양양선B 4347-08-27) 
	        				agmt_cfm_flg			= JSPUtil.getNull(rowSet.getString("agmt_cfm_flg").trim());
	        				cre_usr_id         	= JSPUtil.getNull(rowSet.getString("cre_usr_id").trim());
	        		  
	        				// 비용지급 전표 결재 기능 - 3차 (4347-09-25) 
	        				agmt_doc_no			= JSPUtil.getNull(rowSet.getString("agmt_doc_no").trim());
	        				agmt_doc_desc			= JSPUtil.getNull(rowSet.getString("agmt_doc_desc").trim());
	        				agmt_doc_eff_fm_dt		= JSPUtil.getNull(rowSet.getString("agmt_doc_eff_fm_dt").trim());
	        				agmt_doc_eff_to_dt		= JSPUtil.getNull(rowSet.getString("agmt_doc_eff_to_dt").trim());
	        				
            			}
        			}
        		} // end if        
        	}
        }
    	catch(Exception ex)
        {
            log.error(ex.getMessage(), ex);
            strXML = getErrorXML((new ErrorHandler(ex)).loadPopupMessage(), isupload);
        }
    	
        
    	if (serverException == null) {
    		FormCommand formcommand = event.getFormCommand();
    		//화면에서 CUD가 발생하는 FormCommand인 경우에는 조회XML을 출력한다.
    		//FormCommand가 다를 경우 조건문에 추가한다.
    		//ServiceCommand에서는 재조회를 하지 않고 EventResponse만 return한다.
    		sbuXML.append("<SHEET>\n");
			
			sbuXML.append( getETCData(eventResponse, request) );
				
			sbuXML.append("	<DATA TOTAL='").append(rowCount).append("'>\n");
			
    		if( !(formcommand.isCommand(FormCommand.MULTI) ||
    			formcommand.isCommand(FormCommand.ADD) ||
    			formcommand.isCommand(FormCommand.MODIFY) ||
    			formcommand.isCommand(FormCommand.REMOVE) ||
    			formcommand.isCommand(FormCommand.REMOVELIST) ) ){	//저장XML인 경우
//    		}
//    		else {
	    		if ( rowSet != null ) {
	    			
	    			sbuXML.append("		<TR>\n");
	    			sbuXML.append("			<TD>I</TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(tml_agmt_ofc_cty_cd)	.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(tml_agmt_ver_no)		.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(yd_cd)						.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(yd_nm)					.append("]]></TD>\n");
	    			
	    			sbuXML.append("			<TD><![CDATA[").append(vndr_seq)					.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(vndr_lgl_eng_nm)		.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(eff_fm_dt)					.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(eff_to_dt)					.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(auto_xtd_flg)				.append("]]></TD>\n");
	
	    			sbuXML.append("			<TD><![CDATA[").append(ctrt_ofc_cd)				.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_rmk)				.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(tml_agmt_sts_cd)			.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(lgs_cost_cd)				.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(auto_calc_flg)				.append("]]></TD>\n");
	    			
	    			sbuXML.append("			<TD><![CDATA[").append(tml_agmt_vol_ut_cd)		.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(curr_cd)					.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(thrp_cost_cd_flg)			.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(tml_sto_agmt_tp_cd)		.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(cmnc_hrmnt)				.append("]]></TD>\n");
	    			
	    			sbuXML.append("			<TD><![CDATA[").append(tml_agmt_tp_cd)			.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(cre_ofc_cd)				.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_apro_dt)			.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_cfm_dt)				.append("]]></TD>\n");
	    			// AGMT Confirm Date ->AGMT Confirm (Date를 Flag 로 변경 : 양양선B 4347-08-27) 
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_cfm_flg)			.append("]]></TD>\n");
	    			
	    			sbuXML.append("			<TD><![CDATA[").append(cre_usr_id)				.append("]]></TD>\n");
    				// 비용지급 전표 결재 기능 - 3차 (4347-09-25) 
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_doc_no)			.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_doc_desc)			.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_doc_eff_fm_dt)	.append("]]></TD>\n");
	    			sbuXML.append("			<TD><![CDATA[").append(agmt_doc_eff_to_dt)		.append("]]></TD>\n");
	    			
	    			sbuXML.append("		</TR>\n");
	    		}
    		}
			sbuXML.append("	</DATA>\n");
			sbuXML.append("</SHEET>\n");
		
    		strXML	= sbuXML.toString();
    	}
    	
        if(log.isDebugEnabled()) {
            log.debug((new StringBuilder("\n")).append(strXML).toString());
        }

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
