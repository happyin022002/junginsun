/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOSearchCHSOnHireReportbyMonthSummaryDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.30
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOSearchCHSOnHireReportbyMonthSummaryDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 월별 장비 임차내역  Summary 조회
	  * 2015 조직코드개편 Chang-Young Kim
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOSearchCHSOnHireReportbyMonthSummaryDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("term_change",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOSearchCHSOnHireReportbyMonthSummaryDataRSQL").append("\n"); 
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
		query.append("WITH PARAM " ).append("\n"); 
		query.append("AS (SELECT @[period_stdt] PERIOD_STDT ," ).append("\n"); 
		query.append("               @[period_eddt] PERIOD_EDDT ," ).append("\n"); 
		query.append("               @[loc_cd] LOC_CD ," ).append("\n"); 
		query.append("               @[loc_tp] LOC_TP ," ).append("\n"); 
		query.append("               @[term_change] TERM_CHANGE, " ).append("\n"); 
		query.append("               @[eq_knd_cd] EQ_KND_CD" ).append("\n"); 
		query.append("        FROM   DUAL ) ," ).append("\n"); 
		query.append("      XXX " ).append("\n"); 
		query.append("AS (SELECT #foreach($key IN ${arrTpsz}) SUM(DECODE(DD, '$key' , EE, 0)) $key ," ).append("\n"); 
		query.append("           #end CC" ).append("\n"); 
		query.append("        FROM   (SELECT TO_CHAR(C.STS_EVNT_DT , 'YYYY-MM') CC," ).append("\n"); 
		query.append("                       A.EQ_TPSZ_CD DD," ).append("\n"); 
		query.append("                       COUNT(A.EQ_NO) EE" ).append("\n"); 
		query.append("                FROM   CGM_EQUIPMENT A," ).append("\n"); 
		query.append("                       CGM_EQ_TP_SZ B," ).append("\n"); 
		query.append("                       CGM_EQ_STS_HIS C," ).append("\n"); 
		query.append("                       CGM_AGREEMENT D ," ).append("\n"); 
		query.append("                       MDM_LOCATION E," ).append("\n"); 
		query.append("                       MDM_EQ_ORZ_CHT F," ).append("\n"); 
		query.append("                       PARAM P" ).append("\n"); 
		query.append("                WHERE  A.EQ_TPSZ_CD = B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                AND    A.EQ_NO = C.EQ_NO" ).append("\n"); 
		query.append("                AND    C.STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                AND    C.AGMT_OFC_CTY_CD = D.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND    C.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("                AND    C.AGMT_VER_NO = D.AGMT_VER_NO" ).append("\n"); 
		query.append("                AND    E.SCC_CD = F.SCC_CD" ).append("\n"); 
		query.append("				AND    B.EQ_KND_CD = P.EQ_KND_CD" ).append("\n"); 
		query.append("                AND    A.CRNT_LOC_CD = E.LOC_CD" ).append("\n"); 
		query.append("                AND    SUBSTR(NVL(C.DIFF_RMK, ' '), 1, 6) <> ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                AND    C.AGMT_SEQ <> 999998" ).append("\n"); 
		query.append("                AND    P.TERM_CHANGE IS NULL " ).append("\n"); 
		query.append("          #if (${dii} != '' ) " ).append("\n"); 
		query.append("             #if (${dii} == 'N' )" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD IN ('LSI', 'OWN') " ).append("\n"); 
		query.append("             #elseif (${dii} == 'Y' )" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD = 'DII' " ).append("\n"); 
		query.append("             #end " ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD IN ('LSI', 'DII', 'OWN') " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${loc_cd} != '' )" ).append("\n"); 
		query.append("                AND    DECODE(P.loc_tp, 'R', F.RCC_CD, 'L', F.LCC_CD, 'S', F.SCC_CD ) = P.LOC_CD #end #if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("                AND    D.AGMT_LSTM_CD IN (#foreach($key IN ${lstm_cd}) " ).append("\n"); 
		query.append("                                             #if($velocityCount < $lstm_cd.size()) '$key'," ).append("\n"); 
		query.append("                                             #else '$key'#end " ).append("\n"); 
		query.append("                                         #end ) " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("		  #if (${np} == 'Y')" ).append("\n"); 
		query.append("                AND D.AGMT_LSTM_CD ='NP'" ).append("\n"); 
		query.append("          #elseif (${np} == 'N')" ).append("\n"); 
		query.append("			    AND D.AGMT_LSTM_CD NOT IN ('NP')" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("                GROUP BY TO_CHAR(C.STS_EVNT_DT ,'YYYY-MM'), A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                UNION ALL /* Term Change Excluding */" ).append("\n"); 
		query.append("                SELECT TO_CHAR(C.STS_EVNT_DT , 'YYYY-MM') CC," ).append("\n"); 
		query.append("                       A.EQ_TPSZ_CD DD," ).append("\n"); 
		query.append("                       COUNT(A.EQ_NO) EE" ).append("\n"); 
		query.append("                FROM   CGM_EQUIPMENT A," ).append("\n"); 
		query.append("                       CGM_EQ_TP_SZ B," ).append("\n"); 
		query.append("                       (SELECT A.*" ).append("\n"); 
		query.append("                        FROM   (SELECT A.*," ).append("\n"); 
		query.append("                                       (SELECT /*+ INDEX_ASC(T02 XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("                                          EQ_STS_SEQ" ).append("\n"); 
		query.append("                                        FROM   CGM_EQ_STS_HIS T02" ).append("\n"); 
		query.append("                                        WHERE  A.EQ_NO = T02.EQ_NO" ).append("\n"); 
		query.append("                                        AND    A.EQ_STS_SEQ < T02.EQ_STS_SEQ" ).append("\n"); 
		query.append("                                        AND    T02.EQ_ASET_STS_CD IN ('LSO', 'TLL', 'SLD', 'DON', 'SCR')" ).append("\n"); 
		query.append("                                        AND    T02.TERM_CNG_SEQ IS NULL" ).append("\n"); 
		query.append("                                        AND    ROWNUM = 1 ) AS LSO_STS_SEQ" ).append("\n"); 
		query.append("                                FROM   CGM_EQ_STS_HIS A," ).append("\n"); 
		query.append("                                       PARAM P" ).append("\n"); 
		query.append("                                WHERE  A.STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                                AND    A.AGMT_SEQ <> 999998" ).append("\n"); 
		query.append("                                AND    A.EQ_ASET_STS_CD IN ('LSI', 'DII',  'OWN')" ).append("\n"); 
		query.append("                                AND    A.TERM_CNG_SEQ IS NULL" ).append("\n"); 
		query.append("                                AND    SUBSTR(NVL(A.DIFF_RMK, ' '), 1, 6) <> ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' AND ROWNUM = 1 ) )A" ).append("\n"); 
		query.append("                        WHERE  LSO_STS_SEQ IS NULL )C," ).append("\n"); 
		query.append("                       CGM_AGREEMENT D ," ).append("\n"); 
		query.append("                       MDM_LOCATION E," ).append("\n"); 
		query.append("                       MDM_EQ_ORZ_CHT F," ).append("\n"); 
		query.append("                       PARAM P" ).append("\n"); 
		query.append("                WHERE  A.EQ_TPSZ_CD = B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                AND    A.EQ_NO = C.EQ_NO" ).append("\n"); 
		query.append("		        AND    B.EQ_KND_CD = P.EQ_KND_CD" ).append("\n"); 
		query.append("                AND    C.AGMT_OFC_CTY_CD = D.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND    C.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("                AND    C.AGMT_VER_NO = D.AGMT_VER_NO" ).append("\n"); 
		query.append("                AND    E.SCC_CD = F.SCC_CD" ).append("\n"); 
		query.append("                AND    A.CRNT_LOC_CD = E.LOC_CD" ).append("\n"); 
		query.append("                AND    P.TERM_CHANGE = 'N' " ).append("\n"); 
		query.append("          #if (${dii} != '' ) " ).append("\n"); 
		query.append("            #if (${dii} == 'N' )" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD IN ('LSI','OWN') " ).append("\n"); 
		query.append("            #elseif (${dii} == 'Y' )" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD = 'DII' " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD IN ('LSI', 'DII', 'OWN') " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${loc_cd} != '' )" ).append("\n"); 
		query.append("                AND    DECODE(P.loc_tp, 'R', F.RCC_CD, 'L', F.LCC_CD, 'S', F.SCC_CD ) = P.LOC_CD " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("                AND    D.AGMT_LSTM_CD IN ( #foreach($key IN ${lstm_cd}) " ).append("\n"); 
		query.append("                                             #if($velocityCount < $lstm_cd.size()) '$key'," ).append("\n"); 
		query.append("                                             #else '$key' #end " ).append("\n"); 
		query.append("                                           #end ) " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("		  #if (${np} == 'Y')" ).append("\n"); 
		query.append("                AND D.AGMT_LSTM_CD ='NP'" ).append("\n"); 
		query.append("          #elseif (${np} == 'N')" ).append("\n"); 
		query.append("			    AND D.AGMT_LSTM_CD NOT IN ('NP')" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("                GROUP BY TO_CHAR(C.STS_EVNT_DT ,'YYYY-MM'), A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                UNION ALL /* Term Change Only */" ).append("\n"); 
		query.append("                SELECT TO_CHAR(C.STS_EVNT_DT , 'YYYY-MM') CC," ).append("\n"); 
		query.append("                       A.EQ_TPSZ_CD DD," ).append("\n"); 
		query.append("                       COUNT(A.EQ_NO) EE" ).append("\n"); 
		query.append("                FROM   CGM_EQUIPMENT A," ).append("\n"); 
		query.append("                       CGM_EQ_TP_SZ B," ).append("\n"); 
		query.append("                       (SELECT A.*" ).append("\n"); 
		query.append("                        FROM   (SELECT A.*," ).append("\n"); 
		query.append("                                       (SELECT /*+ INDEX_ASC(T02 XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("                                          TERM_CNG_SEQ" ).append("\n"); 
		query.append("                                        FROM   CGM_EQ_STS_HIS T02" ).append("\n"); 
		query.append("                                        WHERE  A.EQ_NO = T02.EQ_NO" ).append("\n"); 
		query.append("                                        AND    A.EQ_STS_SEQ > T02.EQ_STS_SEQ" ).append("\n"); 
		query.append("                                        AND    T02.EQ_ASET_STS_CD IN ('LSO', 'TLL', 'SLD', 'DON', 'SCR')" ).append("\n"); 
		query.append("                                        AND    T02.TERM_CNG_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                        AND    ROWNUM = 1 ) AS LSO_STS_SEQ" ).append("\n"); 
		query.append("                                FROM   CGM_EQ_STS_HIS A," ).append("\n"); 
		query.append("                                       PARAM P" ).append("\n"); 
		query.append("                                WHERE  A.STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("                                AND    A.AGMT_SEQ <> 999998" ).append("\n"); 
		query.append("                                AND    A.EQ_ASET_STS_CD IN ('LSI', 'DII', 'OWN')" ).append("\n"); 
		query.append("                                AND    A.TERM_CNG_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                AND    SUBSTR(NVL(A.DIFF_RMK, ' '), 1, 6) <> ( SELECT MNR_CD_ID FROM MNR_GEN_CD WHERE PRNT_CD_ID = 'HOOFC' AND ROWNUM = 1 ) )A" ).append("\n"); 
		query.append("                        WHERE  LSO_STS_SEQ IS NOT NULL)C," ).append("\n"); 
		query.append("                       CGM_AGREEMENT D ," ).append("\n"); 
		query.append("                       MDM_LOCATION E," ).append("\n"); 
		query.append("                       MDM_EQ_ORZ_CHT F," ).append("\n"); 
		query.append("                       PARAM P" ).append("\n"); 
		query.append("                WHERE  A.EQ_TPSZ_CD = B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("                AND    A.EQ_NO = C.EQ_NO" ).append("\n"); 
		query.append("				AND    B.EQ_KND_CD = P.EQ_KND_CD" ).append("\n"); 
		query.append("                AND    C.AGMT_OFC_CTY_CD = D.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND    C.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("                AND    C.AGMT_VER_NO = D.AGMT_VER_NO" ).append("\n"); 
		query.append("                AND    E.SCC_CD = F.SCC_CD" ).append("\n"); 
		query.append("                AND    A.CRNT_LOC_CD = E.LOC_CD" ).append("\n"); 
		query.append("                AND    'Y' = NVL(P.TERM_CHANGE, 'N') " ).append("\n"); 
		query.append("          #if (${dii} != '' ) " ).append("\n"); 
		query.append("            #if (${dii} == 'N' )" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD IN ('LSI', 'OWN') " ).append("\n"); 
		query.append("            #elseif (${dii} == 'Y' )" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD = 'DII' " ).append("\n"); 
		query.append("            #end " ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("                AND    C.EQ_ASET_STS_CD IN ('LSI', 'DII', 'OWN') " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${loc_cd} != '' )" ).append("\n"); 
		query.append("                AND    DECODE(P.loc_tp, 'R', F.RCC_CD, 'L', F.LCC_CD, 'S', F.SCC_CD ) = P.LOC_CD " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("                AND    D.AGMT_LSTM_CD IN ( #foreach($key IN ${lstm_cd}) " ).append("\n"); 
		query.append("                                             #if($velocityCount < $lstm_cd.size()) '$key'," ).append("\n"); 
		query.append("                                             #else '$key' #end " ).append("\n"); 
		query.append("                                           #end ) " ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("		  #if (${np} == 'Y')" ).append("\n"); 
		query.append("                AND D.AGMT_LSTM_CD ='NP'" ).append("\n"); 
		query.append("          #elseif (${np} == 'N')" ).append("\n"); 
		query.append("			    AND D.AGMT_LSTM_CD NOT IN ('NP')" ).append("\n"); 
		query.append("		  #end" ).append("\n"); 
		query.append("                GROUP BY TO_CHAR(C.STS_EVNT_DT ,'YYYY-MM'), A.EQ_TPSZ_CD )" ).append("\n"); 
		query.append("        GROUP BY CC" ).append("\n"); 
		query.append("        ORDER BY CC )" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("SELECT #foreach($key IN ${arrTpsz}) " ).append("\n"); 
		query.append("       DECODE( AA.YM , 'Ratio' , TO_CHAR( AA.$key , '990.00') , TO_CHAR( AA.$key , '999,999,999,990' )) $key ," ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("       TO_CHAR( AA.DIV_TOTAL , '999,999,999,990' ) DIV_TOTAL ," ).append("\n"); 
		query.append("       TO_CHAR((AA.DIV_TOTAL / BB.DIV_TOTAL ) * 100 , '990.00' ) || '%' RATIO ," ).append("\n"); 
		query.append("       AA.YM" ).append("\n"); 
		query.append("FROM   (SELECT #foreach($key IN ${arrTpsz}) $key ," ).append("\n"); 
		query.append("               #end ( #foreach($key IN ${arrTpsz}) #if($velocityCount < $arrTpsz.size()) $key + #else $key #end #end ) DIV_TOTAL ," ).append("\n"); 
		query.append("               CC YM" ).append("\n"); 
		query.append("        FROM   XXX" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT #foreach($key IN ${arrTpsz}) SUM( $key ) $key," ).append("\n"); 
		query.append("               #end ( #foreach($key IN ${arrTpsz}) #if($velocityCount < $arrTpsz.size()) SUM($key) + #else SUM($key) #end #end ) DIV_TOTAL ," ).append("\n"); 
		query.append("               'G.TTL' YM" ).append("\n"); 
		query.append("        FROM   XXX" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT #foreach($key IN ${arrTpsz}) SUM( $key ) / ( #foreach($key IN ${arrTpsz}) " ).append("\n"); 
		query.append("               #if($velocityCount < $arrTpsz.size()) SUM($key) + #else SUM($key) #end #end ) * 100 $key ," ).append("\n"); 
		query.append("               #end 100 DIV_TOTAL ," ).append("\n"); 
		query.append("               'Ratio' YM" ).append("\n"); 
		query.append("        FROM   XXX ) AA ," ).append("\n"); 
		query.append("       (SELECT (#foreach($key IN ${arrTpsz}) " ).append("\n"); 
		query.append("                  #if($velocityCount < $arrTpsz.size()) SUM($key) + " ).append("\n"); 
		query.append("                  #else SUM($key) " ).append("\n"); 
		query.append("                  #end " ).append("\n"); 
		query.append("                #end ) DIV_TOTAL" ).append("\n"); 
		query.append("        FROM   XXX ) BB" ).append("\n"); 

	}
}