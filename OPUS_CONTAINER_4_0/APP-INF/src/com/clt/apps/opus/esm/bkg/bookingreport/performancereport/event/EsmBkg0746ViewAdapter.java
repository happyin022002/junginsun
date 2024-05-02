/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0632ViewAdapter.java
*@FileTitle : Sales Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.01 강동윤
* 1.0 Creation
*--------------------------------------------------------
* History
* 2010.09.01 김경섭 [000 ] [ESM-BKG] Vessel Utilization Status vs BSA by Lane 집계 쿼리 수정 및 RAW DATA SHEET 추가
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.GeneralEventResponse;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author Kang Dong Yun
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EsmBkg0746ViewAdapter extends ViewAdapter{
	
    private String getStartTag(boolean isFirstSheet, boolean isSave, GeneralEventResponse eventResponse)
    {
        StringBuilder sb = new StringBuilder();
        if(isFirstSheet)
        {
            if(isSave)
            {
                sb.append("<RESULT>\n");
                sb.append("<TR-ALL>OK</TR-ALL>\n");
            } else
            {
                sb.append("<SHEET>\n");
            }
            sb.append(getETCData(eventResponse));
            sb.append(getUserMessageXML(eventResponse));
        } else
        {
            sb.append("|$$|<SHEET>\n");
        }
        return sb.toString();
    }
    private String getEndTag(StringBuilder sb)
    {
        String endTag = "";
        String tmp = sb.toString();
        int sheetLoc = tmp.lastIndexOf("<SHEET>");
        int resultLoc = tmp.lastIndexOf("<RESULT>");
        if(sheetLoc > resultLoc)
            endTag = "</SHEET>\n";
        else
            endTag = "</RESULT>\n";
        return endTag;
    }	
	   @SuppressWarnings("unchecked")
	private String makeSuccessXML(boolean isUpload, HttpServletRequest request, GeneralEventResponse eventResponse)
	    {
	        Event event = (Event)request.getAttribute("Event");
	        boolean isSave = isSaveCommand(event);
	        StringBuilder sb = new StringBuilder();
	        List rsVoList = eventResponse.getRsVoList();
	        //int cnt = rsVoList.size();
	        //String preVOName = "";
	        boolean isFirstSheet = true;
	        //List voList = new ArrayList();
	        String prefixs[] = getPrefixFromHttp(request);
	        List dataCntList = eventResponse.getDataCntList();
	        if(isUpload)
	            sb.append("<pre>\n");
	        int setExeCnt = dataCntList.size();
	        Iterator it = rsVoList.iterator();
	        int curLoc = 0;
	        for(int i = 0; i < setExeCnt; i++)
	        {
	            int voCnt = ((Integer)dataCntList.get(i)).intValue();
	            if(voCnt == 0)
	            {
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append("\t<DATA  TOTAL='0'>\n");
	                sb.append("\t</DATA>\n");
	                sb.append(getEndTag(sb));
	                isFirstSheet = false;
	            } else
	            if(rsVoList.get(curLoc) instanceof DBRowSet)
	            {
	                sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag((DBRowSet)it.next(), prefixs[i]));
	                sb.append(getEndTag(sb));
	                curLoc++;
	                isFirstSheet = false;
	            } else
	            {
	                List tmpList = new ArrayList();
	                for(int j = 0; j < voCnt; j++)
	                {
	                    Object obj = it.next();
	                    tmpList.add(obj);
	                    curLoc++;
	                }

	               // sb.append(getStartTag(isFirstSheet, isSave, eventResponse));
	                sb.append(makeDataTag(tmpList, prefixs[i]));
	                //sb.append(getEndTag(sb));
	                removeListAllElements(tmpList);
	                isFirstSheet = false;
	            }
	        }

	        if(isUpload)
	            sb.append("</pre>\n");
	        return sb.toString();
	    }
	   
	   /**
		 * makeXML
		 * 
		 * @param HttpServletRequest request
		 * @param HttpServletResponse response
		 * @return String
		 */	
		 public String makeXML(HttpServletRequest request, HttpServletResponse response)
		    {
		        Event event = null;
		        GeneralEventResponse eventResponse = null;
		        Exception serverException = null;
		        String strXML = "";
		        boolean isupload = isUploadFile(request);
		        try
		        {
		            serverException = (Exception)request.getAttribute("com.clt.framework.core.comm.EXCEPTION_OBJECT");
		            if(serverException != null)
		            {
		                strXML = getErrorXML((new ErrorHandler(serverException)).loadPopupMessage(), isupload);
		            } else
		            {
		                boolean isUpload = isUploadFile(request);
		                event = (Event)request.getAttribute("Event");
		                eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		                //List rsVoList = null;
		                /* R4J 결함 복구 isSave 는 사용 하지 않아 주석 처리함 */
		                isSaveCommand(event);
//		                boolean isSave = isSaveCommand(event);
		                if(eventResponse != null)
		                {
		                    //rsVoList = eventResponse.getRsVoList();
		                    if(eventResponse.getRsVoList().size() == 0){
		                        //strXML = getNoSearchResultXML(isUpload, isSave, eventResponse);
		                        strXML = "<SHEET> <ETC-DATA> </ETC-DATA> 	<DATA  TOTAL='0'> 	</DATA> </SHEET>|$$|<SHEET> <ETC-DATA> </ETC-DATA> 	<DATA  TOTAL='0'> 	</DATA> </SHEET>";
		                    }else{
		                        strXML = makeSuccessXML(isUpload, request, eventResponse);
		                    }
		                }
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
		 
		 	private boolean isUploadFile(HttpServletRequest request)
		    {
		        boolean isUpload = false;
		        String contentType = request.getContentType();
		        if(contentType != null && contentType.startsWith("multipart/form-data"))
		            isUpload = true;
		        return isUpload;
		    }

	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception  
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sbufXML = new StringBuilder();
		StringBuilder sbufXML2 = new StringBuilder();
		
		int totCnt = vos.size();
		int realCnt = vos.size();

		AbstractValueObject vo = (AbstractValueObject)vos.get(0);
		String[] realColNms=getColHeader(vo);
		String[] changedColNms = getChangedColNms(realColNms, prefix);
		
		if(vo.getMaxRows()>0){
			totCnt = vo.getMaxRows();
		}
		
		
		sbufXML.append("<SHEET>\n");
		
		Map<String, String> tempColValues = vos.get(0).getColumnValues();			
		
		
		if(!tempColValues.get("f_cmd").equals("2")){
			sbufXML.append((new StringBuilder("<DATA COLORDER='")).append(JSPUtil.convertStringArrayToString(changedColNms, "|")).append("' COLSEPARATOR='").append("\u261C\u261E").append("' TOTAL='").append(totCnt).append("'>\n").toString());
	        for(int i = 0; i < realCnt; i++)
	        {
	            Map<String,String> colValues = ((AbstractValueObject)vos.get(i)).getColumnValues();
	            sbufXML.append("\t<TR><![CDATA[");
	            int colCnt = realColNms.length;
	            for(int j = 0; j < colCnt - 1; j++)
	                sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[j]))))).append("\u261C\u261E").toString());

	            sbufXML.append((new StringBuilder(String.valueOf(getNull((String)colValues.get(realColNms[colCnt - 1]))))).append("]]></TR>\n").toString());
	        }
	        
	        sbufXML.append("</DATA>\n");
	        sbufXML.append("</SHEET>\n");
	        return sbufXML.toString();
		}
		
	
		   int vvd_port_cnt = 0;//VVD별 PORT 개수
			String groupVvvdSeq = ""; //VVD별로 묶기위한 임시 변수
			String vvdSeq = ""; //현재 VVD SEQ
			StringBuffer  title = new StringBuffer();
			StringBuffer  sked = new StringBuffer();
			StringBuffer  local = new StringBuffer();
			StringBuffer  ts = new StringBuffer();
			StringBuffer  ipc = new StringBuffer();
			StringBuffer  tps = new StringBuffer();
			StringBuffer  eur = new StringBuffer();
			StringBuffer  mty = new StringBuffer();
			StringBuffer  ttl = new StringBuffer();
			StringBuffer  pfmc = new StringBuffer();
			
			StringBuffer  rawdata = new StringBuffer();
			
			
			sbufXML.append("\n<DATA TOTAL='"); sbufXML.append(totCnt); sbufXML.append("'>\n");
			Map<String, String> nowColValues = new HashMap<String, String>();
			for(int i = 0 ; i < realCnt ; i++){
				
				nowColValues = vos.get(i).getColumnValues();
				
				vvdSeq = JSPUtil.getNull(nowColValues.get("vvd_seq"));
				
				if(!vvdSeq.equals(groupVvvdSeq)){
					
					if(i > 0){
						sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n").append(title.append(makeTailData(vvd_port_cnt))).append(" </TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(sked.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(local.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(ts.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(ipc.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(tps.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(eur.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(mty.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(ttl.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(pfmc.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
						
						sbufXML2.append(" <TR MERGE=\"FALSE\">\n").append(rawdata.append(makeTailData2(vvd_port_cnt))).append(" \n</TR>\n");
						
					}
					
					title = new StringBuffer();
					sked = new StringBuffer();
					local = new StringBuffer();
					ts = new StringBuffer();
					ipc = new StringBuffer();
					tps = new StringBuffer();
					eur = new StringBuffer();
					mty = new StringBuffer();
					ttl = new StringBuffer();
					pfmc = new StringBuffer();
					
					rawdata = new StringBuffer();
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 1 Row  title<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					title.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(nowColValues.get("slan_cd"))).append("]]></TD>"); //td1
					title.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(JSPUtil.getNull(nowColValues.get("vvd"))).append("]]></TD>");     //td2
					
					title.append(makeEWData2(nowColValues.get("skd_dir_cd"), nowColValues.get("bsa"), "", "TRUE") );//td3,4 - BSA E,W
					title.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("util_e_pct"), nowColValues.get("util_w_pct"), "%", "TRUE",nowColValues.get("util_e_color"),nowColValues.get("util_w_color")) );//td 5,6 - UTIL E/W PCT
					title.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("ttl_e"), nowColValues.get("ttl_w"), "", "TRUE"));//td 7,8 - TTL E/W
					title.append("\n");
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 2 Row sked<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					sked.append("  <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD>");//td 1~4 -- TD merge 옵션이 없으 공백 1개 2개를 번갈아 가며 처리한다. 
					sked.append("  <TD BOLD=\"TRUE\"><![CDATA[VESSEL]]></TD>");//td5
					sked.append("  <TD Align=\"Left\" BOLD=\"TRUE\"><![CDATA[SKED]]></TD>");//td6
					sked.append("  <TD><![CDATA[]]></TD>  <TD><![CDATA[]]></TD>");
					sked.append("\n");

					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 3 Row local<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					local.append("  <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD>");//td 1~5
					local.append("  <TD Align=\"Left\" BOLD=\"TRUE\"><![CDATA[Local]]></TD>");//td 6
					local.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_local_e"), nowColValues.get("sub_tot_lod_local_w"), "", "TRUE") );//td 7~8
					local.append("\n");
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 4 Row ts<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					ts.append("  <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD>");//td 1~5
					ts.append("  <TD Align=\"Left\" BOLD=\"TRUE\"><![CDATA[T/S]]></TD>");//td 6
					ts.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_ts_e"), nowColValues.get("sub_tot_lod_ts_w"), "", "TRUE") );//td 7~8
					ts.append("\n");
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 5 Row ipc<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					ipc.append("  <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD>");//td 1~5
					ipc.append("  <TD><![CDATA[IPC]]></TD>");//td 6
					ipc.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_ipc_e"), nowColValues.get("sub_tot_lod_ipc_w"), "", "FALSE") );//td 7~8
					ipc.append("\n");
						
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 6 Row tps<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					tps.append("  <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD>");//td 1~5
					tps.append("  <TD><![CDATA[TPS]]></TD>");//td 6
					tps.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_tps_e"), nowColValues.get("sub_tot_lod_tps_w"), "", "FALSE") );//td 7~8
					tps.append("\n");
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 7 Row eur<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					eur.append("  <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD>");//td 1~5
					eur.append("  <TD><![CDATA[EUR]]></TD>");//td 6
					eur.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_eur_e"), nowColValues.get("sub_tot_lod_eur_w"), "", "FALSE") );//td 7~8
					eur.append("\n");
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 8 Row mty<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					mty.append("  <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD>");//td 1~5
					mty.append("  <TD Align=\"Left\" BOLD=\"TRUE\"><![CDATA[MTY]]></TD>");//td 6
					mty.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_mty_e"), nowColValues.get("sub_tot_lod_mty_w"), "", "TRUE") );//td 7~8 
					mty.append("\n");
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 9 Row ttl<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					ttl.append("  <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD>");//td 1~5
					ttl.append("  <TD Align=\"Left\" BOLD=\"TRUE\"><![CDATA[TTL]]></TD>");//td 6
					ttl.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("ttl_e"), nowColValues.get("ttl_w"), "", "TRUE") );//td 7~8
					ttl.append("\n");
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 10 Row pfmc<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					pfmc.append("  <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD> <TD><![CDATA[ ]]></TD> <TD><![CDATA[  ]]></TD>");//td 1~4
					pfmc.append("  <TD BOLD=\"TRUE\"><![CDATA[SECTOR]]></TD>");//td5
					pfmc.append("  <TD Align=\"Left\" BOLD=\"TRUE\"><![CDATA[PFMC]]></TD>");//td6
					pfmc.append("   <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>");//td 7~8
					pfmc.append("\n");
					
					
					
					
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 11 Row data<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					rawdata.append("  <TD><![CDATA[").append(JSPUtil.getNull(nowColValues.get("slan_cd"))).append("]]></TD>"); //td1
					rawdata.append("  <TD><![CDATA[").append(JSPUtil.getNull(nowColValues.get("vvd"))).append("]]></TD>");     //td2
					rawdata.append("\n");
					rawdata.append(makeEWData2(nowColValues.get("skd_dir_cd"), nowColValues.get("bsa"), "", "FALSE") );//td3,4 - BSA E,W
					rawdata.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("ttl_e"), nowColValues.get("ttl_w"), "", "FALSE"));//td 7,8 - TTL E/W
					rawdata.append("\n");

					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 3 Row local<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					rawdata.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_local_e"), nowColValues.get("sub_tot_lod_local_w"), "", "FALSE") );
					rawdata.append("\n");

					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 4 Row ts<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					rawdata.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_ts_e"), nowColValues.get("sub_tot_lod_ts_w"), "", "FALSE") );
					rawdata.append("\n");

					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 5 Row ipc<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					rawdata.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_ipc_e"), nowColValues.get("sub_tot_lod_ipc_w"), "", "FALSE") );
					rawdata.append("\n");

					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 6 Row tps<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					rawdata.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_tps_e"), nowColValues.get("sub_tot_lod_tps_w"), "", "FALSE") );
					rawdata.append("\n");

					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 7 Row eur<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					rawdata.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_eur_e"), nowColValues.get("sub_tot_lod_eur_w"), "", "FALSE") );
					rawdata.append("\n");

					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 8 Row mty<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<											
					rawdata.append(makeEWData(nowColValues.get("skd_dir_cd"), nowColValues.get("sub_tot_lod_mty_e"), nowColValues.get("sub_tot_lod_mty_w"), "", "FALSE") );
					rawdata.append("\n");
					
					
					groupVvvdSeq = vvdSeq; 
					
					
					vvd_port_cnt = 0;//초기화
				}
				
				title.append("  <TD BOLD=\"TRUE\" Align=\"Center\"><![CDATA[").append(nowColValues.get("vps_port_cd")).append("]]></TD>\n");
				title.append("  <TD BOLD=\"TRUE\" Align=\"Center\"><![CDATA[").append(nowColValues.get("vps_port_cd")).append("]]></TD>\n");
				title.append("  <TD BOLD=\"TRUE\" Align=\"Center\"><![CDATA[").append(nowColValues.get("vps_port_cd")).append("]]></TD>\n");
				
				sked.append("  <TD><![CDATA[").append(nowColValues.get("vps_eta_dt")).append("]]></TD>\n");
				sked.append("  <TD><![CDATA[]]></TD>\n");
				sked.append("  <TD><![CDATA[").append(nowColValues.get("vps_etd_dt")).append("]]></TD>\n");
				
				local.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("dis_local")).append("]]></TD>\n");
				local.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("lod_local")).append("]]></TD>\n");
				local.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("rob_local")).append("]]></TD>\n");
				
				ts.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("dis_ts")).append("]]></TD>\n");
				ts.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("lod_ts")).append("]]></TD>\n");
				ts.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("rob_ts")).append("]]></TD>\n");
				
				ipc.append("  <TD><![CDATA[").append(nowColValues.get("dis_ipc")).append("]]></TD>\n");
				ipc.append("  <TD><![CDATA[").append(nowColValues.get("lod_ipc")).append("]]></TD>\n");
				ipc.append("  <TD><![CDATA[").append(nowColValues.get("rob_ipc")).append("]]></TD>\n");
				
				tps.append("  <TD><![CDATA[").append(nowColValues.get("dis_tps")).append("]]></TD>\n");
				tps.append("  <TD><![CDATA[").append(nowColValues.get("lod_tps")).append("]]></TD>\n");
				tps.append("  <TD><![CDATA[").append(nowColValues.get("rob_tps")).append("]]></TD>\n");
				
				eur.append("  <TD><![CDATA[").append(nowColValues.get("dis_eur")).append("]]></TD>\n");
				eur.append("  <TD><![CDATA[").append(nowColValues.get("lod_eur")).append("]]></TD>\n");
				eur.append("  <TD><![CDATA[").append(nowColValues.get("rob_eur")).append("]]></TD>\n");
				
				mty.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("dis_mty")).append("]]></TD>\n");
				mty.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("lod_mty")).append("]]></TD>\n");
				mty.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("rob_mty")).append("]]></TD>\n");
				
				ttl.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("dis_ttl")).append("]]></TD>\n");
				ttl.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("lod_ttl")).append("]]></TD>\n");
				ttl.append("  <TD BOLD=\"TRUE\"><![CDATA[").append(nowColValues.get("rob_tot")).append("]]></TD>\n");
				
				pfmc.append("  <TD><![CDATA[]]></TD>\n");
				pfmc.append("  <TD><![CDATA[]]></TD>\n");
				pfmc.append("  <TD><![CDATA[(").append(nowColValues.get("port_lod_pct")).append(")]]></TD>\n");
				
				rawdata.append("  <TD Align=\"Center\"><![CDATA[").append(nowColValues.get("vps_port_cd")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("lod_ttl")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("dis_ttl")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("vps_eta_dt")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("vps_etd_dt")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("lod_local")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("dis_local")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("lod_ts")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("dis_ts")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("lod_ipc")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("dis_ipc")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("lod_tps")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("dis_tps")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("lod_eur")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("dis_eur")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("lod_mty")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("dis_mty")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("last_port_loading")).append("]]></TD>\n");
				//rawdata.append("  <TD><![CDATA[last]]></TD>\n");1
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("port_lod_pct")).append("]]></TD>\n");
				rawdata.append("  <TD><![CDATA[").append(nowColValues.get("util_indi")).append("]]></TD>\n");
				
				vvd_port_cnt++;
			}		
			
			if(realCnt > 0){
				sbufXML.append(" <TR MERGE=\"TRUE\" BGCOLOR=\"246, 225, 236\">\n").append(title.append(makeTailData(vvd_port_cnt))).append(" </TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(sked.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(local.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(ts.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(ipc.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(tps.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(eur.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(mty.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(ttl.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append(pfmc.append(makeTailData(vvd_port_cnt))).append(" \n</TR>\n");
				
				
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>").append(makeTailData(0)).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>").append(makeTailData(0)).append(" \n</TR>\n");
				sbufXML.append(" <TR MERGE=\"FALSE\">\n").append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>").append(makeTailData(0)).append(" \n</TR>\n");
				
				//############################## Tatal #################################
				sbufXML.append(" <TR MERGE=\"FALSE\">\n");
				sbufXML.append("  <TD><![CDATA[]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" BGCOLOR=\"246, 225, 236\"><![CDATA[LOCAL]]></TD>\n");				
				sbufXML.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_local_e")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_local_w")).append("]]></TD>\n");
				sbufXML.append(makeTailData(0));
				sbufXML.append(" </TR>\n");
				
				sbufXML.append(" <TR MERGE=\"FALSE\">\n");
				sbufXML.append("  <TD><![CDATA[]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" BGCOLOR=\"246, 225, 236\"><![CDATA[T/S]]></TD>\n");				
				sbufXML.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_ts_e")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_ts_w")).append("]]></TD>\n");
				sbufXML.append(makeTailData(0));
				sbufXML.append(" </TR>\n");
				
				sbufXML.append(" <TR MERGE=\"FALSE\">\n");
				sbufXML.append("  <TD><![CDATA[]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" BGCOLOR=\"246, 225, 236\"><![CDATA[IPC]]></TD>\n");				
				sbufXML.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>");
				sbufXML.append("  <TD  Align=\"Right\"><![CDATA[").append(nowColValues.get("tot_lod_ipc_e")).append("]]></TD>\n");
				sbufXML.append("  <TD  Align=\"Right\"><![CDATA[").append(nowColValues.get("tot_lod_ipc_w")).append("]]></TD>\n");
				sbufXML.append(makeTailData(0));
				sbufXML.append(" </TR>\n");
				
				sbufXML.append(" <TR MERGE=\"FALSE\">\n");
				sbufXML.append("  <TD><![CDATA[]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" BGCOLOR=\"246, 225, 236\"><![CDATA[TPS]]></TD>\n");				
				sbufXML.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>");
				sbufXML.append("  <TD  Align=\"Right\"><![CDATA[").append(nowColValues.get("tot_lod_tps_e")).append("]]></TD>\n");
				sbufXML.append("  <TD  Align=\"Right\"><![CDATA[").append(nowColValues.get("tot_lod_tps_w")).append("]]></TD>\n");
				sbufXML.append(makeTailData(0));
				sbufXML.append(" </TR>\n");
				
				sbufXML.append(" <TR MERGE=\"FALSE\">\n");
				sbufXML.append("  <TD><![CDATA[]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\" BGCOLOR=\"246, 225, 236\"><![CDATA[EUR]]></TD>\n");				
				sbufXML.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>");
				sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(nowColValues.get("tot_lod_eur_e")).append("]]></TD>\n");
				sbufXML.append("  <TD Align=\"Right\"><![CDATA[").append(nowColValues.get("tot_lod_eur_w")).append("]]></TD>\n");
				sbufXML.append(makeTailData(0));
				sbufXML.append(" </TR>\n");
					
				sbufXML.append(" <TR MERGE=\"FALSE\">\n");
				sbufXML.append("  <TD><![CDATA[]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" BGCOLOR=\"246, 225, 236\"><![CDATA[EMPTY]]></TD>\n");				
				sbufXML.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_mty_e")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_mty_w")).append("]]></TD>\n");
				sbufXML.append(makeTailData(0));
				sbufXML.append(" </TR>\n");
				
				sbufXML.append(" <TR MERGE=\"FALSE\">\n");
				sbufXML.append("  <TD><![CDATA[]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" BGCOLOR=\"246, 225, 236\"><![CDATA[TOTAL]]></TD>\n");				
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_bsa_e")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_bsa_w")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lift_e_pct")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lift_w_pct")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_e")).append("]]></TD>\n");
				sbufXML.append("  <TD BOLD=\"TRUE\" ><![CDATA[").append(nowColValues.get("tot_lod_w")).append("]]></TD>\n");
				sbufXML.append(makeTailData(0));
				sbufXML.append(" </TR>\n");
				
				sbufXML2.append(" <TR MERGE=\"FALSE\">\n").append(rawdata.append(makeTailData2(vvd_port_cnt))).append(" \n</TR>\n");
			}
			
			sbufXML.append("</DATA>\n");
			sbufXML.append("<ETC-DATA>");
			sbufXML.append("<ETC KEY='max_port_seq'><![CDATA[").append(vos.get(0).getColumnValues().get("max_port_seq")).append("]]></ETC>");
			sbufXML.append("</ETC-DATA>");
			sbufXML.append("</SHEET>\n");
			sbufXML.append("|$$|<SHEET><DATA>\n");
			sbufXML.append(sbufXML2.toString());
			sbufXML.append("</DATA></SHEET>\n");
			
		return sbufXML.toString();
	}

	/**
	 * Port별 DIS, LOAD 데이타를 생성하고 40개 중 나머지 포트를 빈값으로 생성한다.<br>
	 * @param cnt		int  '현재 VVD의 포트 개수' 
	 * @return String 	
	 * @exception 
	 */
	protected String makeTailData(int cnt) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0 ; j < 40-cnt ; j++){
				sb.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD> <TD><![CDATA[]]></TD>\n");
		}
		//sb.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[N]]></TD>");
		return sb.toString();
	}
	/**
	 * Raw Data용 sheet의 데이타를 생성하고 40개 중 나머지 포트를 빈값으로 생성한다.<br>
	 * @param cnt		int  '현재 VVD의 포트 개수' 
	 * @return String 	
	 * @exception 
	 */
	protected String makeTailData2(int cnt) {
		StringBuffer sb = new StringBuffer();
		for (int j = 0 ; j < 40-cnt ; j++){
			sb.append("  <TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD>\n");//10개
			sb.append("  <TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD>\n\n");//10개
		}
		//sb.append("  <TD><![CDATA[]]></TD> <TD><![CDATA[N]]></TD>");
		return sb.toString();
	}
	
	/**
	 * East, West에 따른 값을 생성한다.<br>
	 * 구분에 따라 매인값을 East,West에 할당하고, 부가적인 값이 있으면 값을 할당하고 아니면 ""을 할당한다.
	 * @param gb		String 'E,W,N,S' 
	 * @param e_val     String 'East value' 
	 * @param w_val     String 'West value'
	 * @param s_val     String '보조값'
	 * @param bold_yn   String Bold yn
	 * @return String 	
	 * @exception 
	 */
	protected String makeEWData(String gb, String e_val,String w_val,String s_val,String bold_yn) {
		return makeEWData(gb, e_val, w_val, s_val, bold_yn, "", "");
	}
	
	/**
	 * East, West에 따른 값을 생성한다.<br>
	 * 구분에 따라 매인값을 East,West에 할당하고, 부가적인 값이 있으면 값을 할당하고 아니면 ""을 할당한다.
	 * @param gb		String 'E,W,N,S' 
	 * @param e_val     String 'East value' 
	 * @param w_val     String 'West value'
	 * @param s_val     String '보조값'
	 * @param bold_yn   String Bold yn
	 * @return String 	
	 * @exception 
	 */
	protected String makeEWData(String gb, String e_val,String w_val,String s_val,String bold_yn, String e_color, String w_color) {
		String r_val ="";
		if(JSPUtil.getNull(gb).equals("E") || JSPUtil.getNull(gb).equals("S")){
			r_val = "  <TD BOLD=\""+bold_yn+"\" COLOR=\""+e_color+"\"><![CDATA["+e_val+"]]></TD>  <TD BOLD=\""+bold_yn+"\" COLOR=\""+w_color+"\"><![CDATA["+(s_val.equals("")?"":s_val)+"]]></TD>";
		}else{
			r_val = "  <TD BOLD=\""+bold_yn+"\" COLOR=\""+e_color+"\"><![CDATA["+(s_val.equals("")?"":s_val)+"]]></TD>	<TD BOLD=\""+bold_yn+"\"  COLOR=\""+w_color+"\"><![CDATA["+w_val+"]]></TD>";
		}
		return r_val;
	}
	
	/**
	 * East, West에 따른 값을 생성한다.<br>
	 * 구분에 따라 매인값을 East,West에 할당하고, 부가적인 값이 있으면 값을 할당하고 아니면 ""을 할당한다.
	 * 
	 * @param gb		String 'E,W,N,S' 
	 * @param m_val     String '메인값' 
	 * @param s_val     String '보조값'
	 * @param bold_yn   String Bold yn
	 * @return String 	
	 * @exception 
	 */
	protected String makeEWData2(String gb, String m_val,String s_val,String bold_yn) {
		String r_val ="";
		if(JSPUtil.getNull(gb).equals("E") || JSPUtil.getNull(gb).equals("S")){
			r_val = "  <TD BOLD=\""+bold_yn+"\"><![CDATA["+m_val+""+"]]></TD>  <TD BOLD=\""+bold_yn+"\"><![CDATA["+(s_val.equals("")?"":s_val)+"]]></TD>";
		}else{
			r_val = "  <TD BOLD=\""+bold_yn+"\"><![CDATA["+(s_val.equals("")?"":s_val)+"]]></TD>	<TD BOLD=\""+bold_yn+"\"><![CDATA["+m_val+""+"]]></TD>";
		}
		return r_val;
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
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		//Pivot Table인 경우 makePivotDataTag 실행하여  return한
		if(rs.isPivot()){
			sb.append(makePivotDataTag(rs));
			return sb.toString();
		}

		String[] realColNms = getColHeader(rs);

		try{
			String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			sb.append("<DATA COLORDER='" + JSPUtil.convertStringArrayToString(changedColNms, "|") + "' COLSEPARATOR='" + DELIMITER + "' TOTAL='" + getRowSetCnt(rs) + "'>\n");
			
			int colCount = realColNms.length;
			
			while (rs.next()) { 
				sb.append("	<TR><![CDATA[");
				for (int j = 1 ; j < colCount ; j++) {
					sb.append(getNull(rs.getObject(j)) + DELIMITER);
				}	
				sb.append(getNull(rs.getObject(colCount))  + "]]></TR>\n");
			}
			sb.append("</DATA>\n");
		}catch(Exception ex){
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
	
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
		try{
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}
}
