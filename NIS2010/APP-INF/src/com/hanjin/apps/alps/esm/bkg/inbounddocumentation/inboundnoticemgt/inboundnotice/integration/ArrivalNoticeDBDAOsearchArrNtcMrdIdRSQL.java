/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ArrivalNoticeDBDAOsearchArrNtcMrdIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.03.12 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArrivalNoticeDBDAOsearchArrNtcMrdIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Arrival Notice 에서 MRD ID 구해오기
	  * </pre>
	  */
	public ArrivalNoticeDBDAOsearchArrNtcMrdIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : ArrivalNoticeDBDAOsearchArrNtcMrdIdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("	SELECT CTNT.ATTR_CTNT4          AS MRD_ID            -- MRD_ID      " ).append("\n"); 
		query.append("	      ,NTWD.LOCL_LANG_FLG       AS LOCL_LANG_FLG     -- LOCAL LANGUAGE FLAG" ).append("\n"); 
		query.append("	      ,NTWD.ECLZ_BL_CPY_FLG     AS ECLZ_BL_CPY_FLG   -- ORIGINAL B/L COPY 여부" ).append("\n"); 
		query.append("	      ,CTNT.ATTR_CTNT5 || CTNT.ATTR_CTNT6 AS COM_PARAM -- 공통적으로 붙는 파라미터" ).append("\n"); 
		query.append("          ,'' AS ARR_PRV_FOM_CD" ).append("\n"); 
		query.append("	FROM (  " ).append("\n"); 
		query.append("	SELECT  ANTC.BKG_NO" ).append("\n"); 
		query.append("	      , DECODE( SUBSTR(LOC.LOC_CD,1,2), 'KR','KR'" ).append("\n"); 
		query.append("	                        , 'JP','JP'" ).append("\n"); 
		query.append("	                        , 'CN','CN'" ).append("\n"); 
		query.append("	                        , 'TW','CN'" ).append("\n"); 
		query.append("	                        , 'US','US'" ).append("\n"); 
		query.append("							, 'CA','CA'" ).append("\n"); 
		query.append("							, 'AE','AE'" ).append("\n"); 
		query.append("	                        ,'*')        AS CNT_CD" ).append("\n"); 
		query.append("	      , CASE  WHEN MDM.CNT_CD ='KR' " ).append("\n"); 
		query.append("	                OR MDM.CNT_CD ='JP' " ).append("\n"); 
		query.append("	                OR MDM.CNT_CD ='CN'" ).append("\n"); 
		query.append("	                OR MDM.CNT_CD ='TW'" ).append("\n"); 
		query.append("	                OR MDM.CNT_CD ='US' " ).append("\n"); 
		query.append("					OR MDM.CNT_CD ='CA' " ).append("\n"); 
		query.append("                    OR MDM.CNT_CD ='AE' THEN  DECODE( MDM.SCONTI_CD,'AF','AF' " ).append("\n"); 
		query.append("	                                                               ,'MN','MN'" ).append("\n"); 
		query.append("	                                                               ,'EN','EN'" ).append("\n"); 
		query.append("																   ,'AM','AM'" ).append("\n"); 
		query.append("	                                                               ,'*' )      " ).append("\n"); 
		query.append("	             ELSE DECODE( MDM.SCONTI_CD,'EN','EN'" ).append("\n"); 
		query.append("                                           ,'EC','EC'" ).append("\n"); 
		query.append("                                           ,'EE','EE'" ).append("\n"); 
		query.append("                                           ,'ES','ES'" ).append("\n"); 
		query.append("                                               ,'*' ) END   AS CONTI_CD" ).append("\n"); 
		query.append("	     , NTWD.AN_TP_CD" ).append("\n"); 
		query.append("	     , NTWD.AN_SEQ" ).append("\n"); 
		query.append("	--     , NVL(ANTC.AN_FOM_CD,'GE') AS AN_FOM_CD  -- Fault (Remove By Park Mangeon 20100324)" ).append("\n"); 
		query.append("	     , LOCL_LANG_FLG" ).append("\n"); 
		query.append("	     , ECLZ_BL_CPY_FLG" ).append("\n"); 
		query.append("	     , NVL(NTWD.ARR_PRV_FOM_CD, 'GE') AS ARR_PRV_FOM_CD  -- User Office Form (Add By Park Mangeon 20100324)" ).append("\n"); 
		query.append("	     , ROW_NUMBER() OVER ( PARTITION BY NTWD.AN_TP_CD  " ).append("\n"); 
		query.append("	                           ORDER BY DECODE(NVL(ANTC.CHN_AGN_CD, '*'), NTWD.CHN_AGN_CD, 0, 1)  -- ANTC쪽 값이 Null일 수 있음(Add By Park Mangeon 20100324)" ).append("\n"); 
		query.append("	                                   ,DECODE(BKGM.POD_CD, NTWD.POD_CD, 0, 1)) ODR" ).append("\n"); 
		query.append("	FROM BKG_ARR_NTC     ANTC" ).append("\n"); 
		query.append("	    ,BKG_BOOKING      BKGM" ).append("\n"); 
		query.append("	    ,MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("	    ,MDM_LOCATION     LOC" ).append("\n"); 
		query.append("	    ,MDM_COUNTRY      MDM" ).append("\n"); 
		query.append("	    ,BKG_ARR_NTC_WD   NTWD" ).append("\n"); 
		query.append("	WHERE ANTC.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("	AND BKGM.BKG_NO     = ANTC.BKG_NO" ).append("\n"); 
		query.append("	AND ORG.OFC_CD      = @[ofc_cd]" ).append("\n"); 
		query.append("	AND LOC.LOC_CD      = ORG.LOC_CD   " ).append("\n"); 
		query.append("	AND MDM.CNT_CD      = LOC.CNT_CD   " ).append("\n"); 
		query.append("	AND NTWD.AN_TP_CD   = 'ARN' -- 고정값       " ).append("\n"); 
		query.append("	AND NTWD.OFC_CD     = ORG.OFC_CD" ).append("\n"); 
		query.append("	AND NTWD.POD_CD     IN ('*', BKGM.POD_CD)" ).append("\n"); 
		query.append("	AND NTWD.CHN_AGN_CD IN ('*', ANTC.CHN_AGN_CD)" ).append("\n"); 
		query.append("	) NTWD" ).append("\n"); 
		query.append("	 ,BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("	WHERE ODR = 1" ).append("\n"); 
		query.append("	  AND CTNT.HRD_CDG_ID = 'ARR_NTC_MRD_ID'  " ).append("\n"); 
		query.append("	  AND CTNT.ATTR_CTNT1 = NVL(NTWD.CONTI_CD,'*')       -- CONTINENT CODE" ).append("\n"); 
		query.append("	  AND CTNT.ATTR_CTNT2 = DECODE( NVL(NTWD.CONTI_CD,'*'),'*','*',CNT_CD)" ).append("\n"); 
		query.append("	  AND CTNT.ATTR_CTNT3 = NTWD.ARR_PRV_FOM_CD               -- User Office Form을 선택해야함 (20100324 Park Mangeon)" ).append("\n"); 
		query.append("#else 	" ).append("\n"); 
		query.append("	SELECT CTNT.ATTR_CTNT4                    AS MRD_ID" ).append("\n"); 
		query.append("	      ,CTNT.ATTR_CTNT5 || CTNT.ATTR_CTNT6 AS COM_PARAM" ).append("\n"); 
		query.append("	      ,CTNT.ATTR_CTNT3                    AS ARR_PRV_FOM_CD" ).append("\n"); 
		query.append("	      ,'' AS LOCL_LANG_FLG" ).append("\n"); 
		query.append("	      ,'' AS ECLZ_BL_CPY_FLG" ).append("\n"); 
		query.append("	  FROM (  " ).append("\n"); 
		query.append("	        SELECT DECODE( SUBSTR(LOC.LOC_CD,1,2), 'KR','KR'" ).append("\n"); 
		query.append("	                            , 'JP','JP'" ).append("\n"); 
		query.append("	                            , 'CN','CN'" ).append("\n"); 
		query.append("	                            , 'TW','CN'" ).append("\n"); 
		query.append("	                            , 'US','US'" ).append("\n"); 
		query.append("	                            , 'CA','CA'" ).append("\n"); 
		query.append("								, 'AE','AE'" ).append("\n"); 
		query.append("	                            ,'*')        AS CNT_CD" ).append("\n"); 
		query.append("	          , CASE  WHEN MDM.CNT_CD ='KR' " ).append("\n"); 
		query.append("	                    OR MDM.CNT_CD ='JP' " ).append("\n"); 
		query.append("	                    OR MDM.CNT_CD ='CN'" ).append("\n"); 
		query.append("	                    OR MDM.CNT_CD ='TW'" ).append("\n"); 
		query.append("	                    OR MDM.CNT_CD ='US'" ).append("\n"); 
		query.append("	                    OR MDM.CNT_CD ='CA' " ).append("\n"); 
		query.append("					    OR MDM.CNT_CD ='AE' THEN DECODE(MDM.SCONTI_CD,'AF','AF' " ).append("\n"); 
		query.append("	                                                                 ,'MN','MN'" ).append("\n"); 
		query.append("	                                                                 ,'EN','EN'" ).append("\n"); 
		query.append("																	 ,'AM','AM'" ).append("\n"); 
		query.append("	                                                                 ,'*' )      " ).append("\n"); 
		query.append("	                 ELSE DECODE( MDM.SCONTI_CD,'EN','EN'" ).append("\n"); 
		query.append("                                           ,'EC','EC'" ).append("\n"); 
		query.append("                                           ,'EE','EE'" ).append("\n"); 
		query.append("                                           ,'ES','ES'" ).append("\n"); 
		query.append("                                               ,'*' ) END   AS CONTI_CD" ).append("\n"); 
		query.append("	      " ).append("\n"); 
		query.append("	          FROM MDM_ORGANIZATION ORG" ).append("\n"); 
		query.append("	              ,MDM_LOCATION     LOC" ).append("\n"); 
		query.append("	              ,MDM_COUNTRY      MDM" ).append("\n"); 
		query.append("	         WHERE ORG.OFC_CD    = @[ofc_cd]" ).append("\n"); 
		query.append("	           AND LOC.LOC_CD      = ORG.LOC_CD   " ).append("\n"); 
		query.append("	           AND MDM.CNT_CD      = LOC.CNT_CD   " ).append("\n"); 
		query.append("	         ) SUBQ" ).append("\n"); 
		query.append("	         JOIN BKG_HRD_CDG_CTNT CTNT" ).append("\n"); 
		query.append("	    ON ( CTNT.HRD_CDG_ID = 'ARR_NTC_MRD_ID'  " ).append("\n"); 
		query.append("	         AND CTNT.ATTR_CTNT1 = NVL(SUBQ.CONTI_CD,'*')     " ).append("\n"); 
		query.append("	         AND CTNT.ATTR_CTNT2 = DECODE( NVL(SUBQ.CONTI_CD,'*'),'*','*',CNT_CD)" ).append("\n"); 
		query.append("	       ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}