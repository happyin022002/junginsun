/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : SPCUtil.java
 *@FileTitle : SPCUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-28
 *@LastModifier : 송민석
 *@LastVersion : 1.0
 * 2006-12-28 송민석
 * 1.0 최초 생성
* 2008-03-06 김원섭
* CSR : N200803110001   T/S booking 조회 화면 개발 요청 
*   - color 목록에 색상 추가
* 2011.05.19 최성민 [CHM-201110711-01] Inquiry by Trade 화면 보완
* - TAGLIB를 MULTICOMBO로 변경 작업
* - getValueObject2StringArray 추가
*  2011.06.27 Kim jong jun : 소스 품질검토 결과 적용
*  2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
 =========================================================*/

package com.hanjin.apps.alps.esm.spc.common;

import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;

/**
 * SAQ 업무 관련 UTIL성 업무를 처리한다.
 * 
 * @author 송민석
 * @see
 * @since J2EE 1.4
 */
public class SPCUtil {
	private static transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SPCUtil.class);
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-Common 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param str Original String
	 * @param replaceStr str이 Null일 경우 반환 받고자 하는 값.
	 * @return String 변환된 값.
	 */
	public static String getNvl(String str, String replaceStr) {
		if (str == null || str.trim().length() == 0)
			return replaceStr;
		return str;
	}
	
	/**
	 * 제수가 0일때 0을 return<br>
	 * 
	 * @param num 계산된값.
	 * @return 0 또는 num
	 */
	public static double getNaNToZero(double num ) {
		
		if (Double.isNaN(num))
			return 0.0;
		return num;
	}
	

	/**
	 * fnum 값을 체크하여 0 인 경우 "" 으로 리턴한다.
	 * 
	 * @param fnum
	 * @return
	 */
	public static String getZeroToNullString(float fnum) {
		return fnum == 0 ? "" : String.valueOf(fnum);
	}

	/**
	 * dnum 값을 체크하여 0 인 경우 "" 으로 리턴한다.
	 * 
	 * @param dnum
	 * @return
	 */
	public static String getZeroToNullString(double dnum) {
		return dnum == 0 ? "" : String.valueOf(dnum);
	}

	/**
	 * num 값을 체크하여 0 크거나 같으면 1 아니면 -1 에 num 값을 곱하여 리턴한다.
	 * 
	 * @param num
	 * @return
	 */
	public static double abs(double num) {
		return ((num >= 0) ? 1 : -1) * num;
	}

	/**
	 * num1/num2 를 (%)로 환산하여 소수점 1 자리까지 ROUND하여 리턴한다.
	 * 
	 * @param num1
	 * @param num2
	 * @param num3
	 * @return
	 */
	public static double getRatio(double num1, double num2) {
		if (num2 == 0)
			return 0;
		return JSPUtil.round((num1 / num2 * 100) - 100, -1);
	}
	/**
	 * 단계별 색상에 대한 색상표를 반환한다.
	 */
	public static String[] getColors() {
		String[] colors = { "225,244,226", "237,255,168", "235,240,255", "210,229,235"};
		return colors;
	}
	/**
	 * 단계별 색상에 대한 색상표를 반환한다.
	 */
	public static String[] getHighlightColors() {
		String[] colors = { "242,199,237", "146,232,226", "146,232,158"};
		return colors;
	}	
	/**
	 * 단계별 색상에 대한 색상표를 반환한다.
	 */
	public static String[] getColors(int i) {
		String[] colors = getColors();
		int size = colors.length;
		String[] cs = new String[i];
		for(int r = 0 ; r < i ; r++) {
			cs[r] = colors[r%size];
		}
		return cs;
	}

	/**
	 * 단계별 색상에 대한 색상표 중 하나의 색상을 반환한다.
	 */
	public static String getColor(int i) {
		String[] colors = getColors();
		int size = colors.length;
		int r = i;
		if (r < 0) {
			r = 0;
		}
		return colors[r%size];
	}
	
	/**
	 * 단계별 색상에 대한 색상표를 반환한다.
	 */
	public static String[] getHighlightColors(int i) {
		String[] colors = getHighlightColors();
		int size = colors.length;
		String[] cs = new String[i];
		for(int r = 0 ; r < i ; r++) {
			cs[r] = colors[r%size];
		}
		return cs;
	}

	/**
	 * 단계별 색상에 대한 색상표 중 하나의 색상을 반환한다.
	 */
	public static String getHighlightColor(int i) {
		String[] colors = getHighlightColors();
		int size = colors.length;
		int r = i;
		if (r < 0) {
			r = 0;
		}
		return colors[r%size];
	}	
	
	/**
	 * 문자를 숫자,콤마표시
	 * @return String  변환된 값.
	 */	
	 public static String getStringToCurr(String str) 
	{ 
		if(str.equals("") || str == null) {
			return "";
		} else {
			long l = Long.parseLong(str); 
			 
			Locale locale = new Locale("ko", "KOR"); 
			NumberFormat nf = NumberFormat.getInstance(locale); 
			return nf.format(l); 

		}
	} 
	/**
	 * 구분자를 넣은 문자열을 해쉬맵으로 생성한다.
	 * 예)
	 * Utils.createMap("key1:value1|key2:value2|key3:value3");
	 * 다음 데이터를 가진 해쉬맵으로 리턴한다.
	 * key1:value1
	 * key2:value2
	 * key3:value3
	 * 
	 * @param str
	 * @return
	 */
	public static HashMap createMap(String str) {
		HashMap hm = new HashMap();
		StringTokenizer st = new StringTokenizer(str, "|");
		String temp = "";
		while (st.hasMoreTokens()) {
			temp = st.nextToken();
			if(temp.split(":").length > 1) {
				hm.put(temp.split(":")[0], temp.split(":")[1]);
			}
		}
		return hm;
	}
	
	/**
	 * str 값을 체크하여 null 인 경우 def 를 아닐경우 str을 리턴한다.
	 * 
	 * @param str
	 * @param def
	 * @return
	 */
	public static String nvl(String str, String def) {
		return (str==null)?def:str;
	}
	
	
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
        return getValueObject2StringArray(comboData,true ,"|","\t","getCode","getName"); 
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
        return getValueObject2StringArray(comboData,isIncludeCd ,"|","\t","getCode","getName"); 
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
        return getValueObject2StringArray(comboData,isIncludeCd ,rowSep,colSep,"getCode","getName"); 
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
                    if( isIncludeCd == true) {
                        text.append(strCd).append(colSep).append(strNm);
                    } else {
                        text.append(strNm);
                    }
                    code.append(strCd);
                }
            }
            rtnV[0] = code.toString();
            rtnV[1] = text.toString();            
        }catch(Exception e){
        	log.error(e.getMessage());
            return null;
        }
        return rtnV;
    }   
    
	/**
	 * 공통코드를 조회하여 dataFlag 값에 해당하는 형식으로 값을 리턴한다.
	 * @param String comnCode String 조회할 공통코드
	 * @param String dataFlag String 리턴할 값의 형식
	 * @return String 조회한 코드
	 * @author jinwoo
	 */
	@SuppressWarnings("unchecked")
	public static String comnCodeList(String comnCode, String dataFlag){
		if(comnCode == null || "".equals(comnCode)){
			return "";
		}
		
		CodeUtil 			codeUtil 	= CodeUtil.getInstance();		
		ArrayList<CodeInfo> list 		= (ArrayList<CodeInfo>)codeUtil.getCodeSelect(comnCode, 1);
		StringBuilder 		sb 			= new StringBuilder();
		
		if(list != null && list.size() > 0){
			if("onlycode".equals(dataFlag)){
				sb.append(list.get(0).getCode());
				
				for (int i=1; i<list.size(); i++) {
					sb.append("|");
					sb.append(list.get(i).getCode());
				}
			}else if("onlyname".equals(dataFlag)){
				sb.append(list.get(0).getName());
				
				for (int i=1; i<list.size(); i++) {
					sb.append("|");
					sb.append(list.get(i).getName());
				}
			}else{
				sb.append(list.get(0).getCode());
				sb.append("\t");
				sb.append(list.get(0).getName());
				
				for (int i=1; i<list.size(); i++) {
					sb.append("|");
					sb.append(list.get(i).getCode());
					sb.append("\t");
					sb.append(list.get(i).getName());
				}
			}
		}
		
		return sb.toString();
	}
}
