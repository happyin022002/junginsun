/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRIUtil.java
*@FileTitle : PRIUtil
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.17 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.common;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;

/**
 * OPUS-PRIUtil Common Utility - 공통 로직을 처리한다.
 *
 * @author Minseok Song
 * @see 
 * @since J2EE 1.6
 */
public class RASUtil {
	
    Logger log = Logger.getLogger(this.getClass().getName());
	
    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|'와 '\t'를 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * JSP LAYER에서의 사용 예)
     *  GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
     *  // Service Scope Combo Data 생성
     *  List<RsltCdListVO> comboData = (List<RsltCdListVO>)eventResponse.getCustomData("SvcScpCombo");
     *  svcScpCombo = PRIUtil.getValueObject2StringArray(comboData);
     *  
     *  <script language="javascript">
     *      var svcScpComboValue = "<%=svcScpCombo[0]%>";
     *      var svcScpComboText = "<%=svcScpCombo[1]%>";
     *  </script>
     *  
     * @param List<?> comboData
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData ) {
        return getValueObject2StringArray(comboData,true ,"|","\t","getCd","getNm"); 
    }

    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|' 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * 
     * JSP LAYER에서의 사용 예)
     *  GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
     *  // Service Scope Combo Data 생성
     *  List<RsltCdListVO> comboData = (List<RsltCdListVO>)eventResponse.getCustomData("SvcScpCombo");
     *  svcScpCombo = PRIUtil.getValueObject2StringArray(comboData,false);
     * 
     *  <script language="javascript">
     *      var svcScpComboValue = "<%=svcScpCombo[0]%>";
     *      var svcScpComboText = "<%=svcScpCombo[1]%>";
     *  </script>
     * 
     * @param List<?> comboData
     * @param boolean isIncludeCd false 일경우 Name에 Code를 같이 붙이지 않는다.
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData ,boolean isIncludeCd) {
        return getValueObject2StringArray(comboData,isIncludeCd ,"|","\t","getCd","getNm"); 
    }

    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|'와 '\t'를 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * @param List<?> comboData
     * @param boolean isIncludeCd false 일경우 Name에 Code를 같이 붙이지 않는다.
     * @param String rowSep 코드와 텍스트의 구분자
     * @param String colSep 텍스트에서 다중 컬럼을 구분하는 구분자
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData,boolean isIncludeCd,String rowSep,String colSep ) {
        return getValueObject2StringArray(comboData,isIncludeCd ,rowSep,colSep,"getCd","getNm"); 
    }

    /**
     * code와 name으로 구성된 VO를 파라메터로 받아 '|'와 '\t'를 구분자로 하여
     * multicombo에서 사용가능한 String 배열로 구성해 return한다.
     * 
     * @param List<?> comboData
     * @param boolean isIncludeCd false 일경우 Name에 Code를 같이 붙이지 않는다.
     * @param String rowSep 코드와 텍스트의 구분자
     * @param String colSep 텍스트에서 다중 컬럼을 구분하는 구분자
     * @param String methodNmOfCd Code값을 읽어올수 있는 method명
     * @param String methodNmOfNm Name값을 읽어올수 있는 method명
     * @return String[] 0번 idx에 code, 1번 idx에 text
     */
    public static String[] getValueObject2StringArray(List<?> comboData,boolean isIncludeCd,String rowSep,String colSep,String methodNmOfCd,String methodNmOfNm){
    	Logger locLog = Logger.getLogger("getValueObject2StringArray");
    	
        StringBuffer code = new StringBuffer();
        StringBuffer text = new StringBuffer();
        String[] rtnV = {"",""};
        try{
        
            if (comboData.size() > 0) {
                Class<?> tmp1 = null;
                Method mtd1 = null;
                Method mtd2 = null;
                String strNm = null;
                String strCd = null;
                int dataCount = comboData.size();
                for (int i = 0; i < dataCount; i++) {
                    tmp1 = comboData.get(i).getClass();
                    mtd1 = tmp1.getMethod(methodNmOfNm, new Class[0]);
                    strNm = (String)mtd1.invoke(comboData.get(i), new Object[0]);
                    mtd2 = tmp1.getMethod(methodNmOfCd, new Class[0]);
                    strCd = (String)mtd2.invoke(comboData.get(i), new Object[0]);
                    if( strNm == null ) strNm = "";
                    if( strCd == null ) strCd = "";
                    if (i != 0) {
                        text.append(rowSep);
                        code.append(rowSep);
                    }
                    if( isIncludeCd == true)
                        text.append(strCd).append(colSep).append(strNm);
                    else
                        text.append(strNm);
                    code.append(strCd);
                }
            }
            rtnV[0] = code.toString();
            rtnV[1] = text.toString();        
        }catch(Exception e){
        	locLog.error(e);	//2015.05.22 by kimtk. 소스 품질 I/O	Using a log within the catch block	catch절에서 예외를 throw 하지 않는다면 반드시 오류 메시지( log.error())를 기술하여야 한다
            return null;
        }
        return rtnV;
    }   
    
	/**
	 * String이 java의 null 일 경우 원하는 값으로 치환한다.
	 * 
	 * @param String str Original String
	 * @param String replaceStr str이 Null일 경우 반환 받고자 하는 값.
	 * @return String 변환된 값.
	 */
	public static String getNvl(String str, String replaceStr) {
		if (str == null || str.trim().length() == 0)
			return replaceStr;
		return str;
	}  
	
	/**
	 * Batch Job 실행후 jobid와 상태를 program no와 parameter로 조회한다.<br>
	 * ScheduleUtil.directExecuteJob(String pgmNo, String parameter) 을 실행할때와 동일한 파라메터
	 * 
	 * @param String programNo Batch Program No(EX : ESM-PRI-B001)
	 * @param String params Batch Job을 실행할때 입력한 파라메터
	 * @return ArrayList<String> 0번째 jobid, 1번째 상태
	 */
	public static ArrayList<String> getJobIdAndStatus(String programNo, String params) {
    	Logger locLog = Logger.getLogger("getJobIdAndStatus");
		String jobId = null;
		String status = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			/*	  
			status	0	<NULL>	알수없음 
			status	1	RUNNING	수행중 
			status	3	STARTING	시작(시스템)
			status	4	SUCCESS	성공 
			status	5	FAILURE  실패 	
			status	6	TERMINATED	강제종료 
			status	7	ON_ICE	 논리삭제
			status	8	INACTIVE	실행대기
			status	9	ACTIVATED	 활성화(시스템)
			status	10	RESTART	시작시에러
			status	11	ON_HOLD	일시정지
			status	12	QUE_WAIT	 로드밸런싱 대기
		*/
			if (programNo != null &&  programNo.trim().length() != 0){
				RsltCdListVO vo = new RsltCdListVO();
				vo.setEtc1(programNo);
				vo.setEtc2(params);
				PRICommonBC command = new PRICommonBCImpl();
				vo = command.searchBatchScheduleJobIdAndStatus(vo);
				jobId = vo.getCd();
				status = vo.getNm();
			}
		}catch(Exception e){
        	locLog.error(e);	//2015.05.22 by kimtk. 소스 품질 I/O	Using a log within the catch block	catch절에서 예외를 throw 하지 않는다면 반드시 오류 메시지( log.error())를 기술하여야 한다
		    return null;
		}
		list.add(jobId);
		list.add(status);
		
		return list;
	}  

}
