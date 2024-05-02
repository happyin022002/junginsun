/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseWeeklyReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.05.08 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchIdaDoRlseWeeklyReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 Weekly별로 조회한다.
	  * * History
	  * 2012.05.08 김보배 [CHM-201217621] [BKG] India Cargo Release Performance 기능 보완
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchIdaDoRlseWeeklyReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_ym",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt_fm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseWeeklyReportRSQL").append("\n"); 
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
		query.append("SELECT SUBS.DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("     , CDTL.INTG_CD_VAL_DP_DESC AS DMDT_PAY_TP_CD_DESC" ).append("\n"); 
		query.append("     , SUBS.FIRST_WK" ).append("\n"); 
		query.append("     , SUBS.SECOND_WK" ).append("\n"); 
		query.append("     , SUBS.THIRD_WK" ).append("\n"); 
		query.append("     , SUBS.FORTH_WK" ).append("\n"); 
		query.append("     , SUBS.FIFTH_WK" ).append("\n"); 
		query.append("     , NVL(SUBS.MONTHLY, 0) AS MONTHLY      -- IdaDoWeeklyReportVO" ).append("\n"); 
		query.append("  FROM (SELECT INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("             , INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("             , INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02209' ) CDTL -- D/O DEM/DET PAYMENT TYPE CODE" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("             SELECT SUBQ.DMDT_PAY_TP_CD AS DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("                      , SUM(SUBQ.FIRST_WK) FIRST_WK" ).append("\n"); 
		query.append("                      , SUM(SUBQ.SECOND_WK) SECOND_WK" ).append("\n"); 
		query.append("                      , SUM(SUBQ.THIRD_WK) THIRD_WK" ).append("\n"); 
		query.append("                      , SUM(SUBQ.FORTH_WK) FORTH_WK" ).append("\n"); 
		query.append("                      , SUM(SUBQ.FIFTH_WK) FIFTH_WK" ).append("\n"); 
		query.append("                      , COUNT(1) MONTHLY      -- IdaDoWeeklyReportVO" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                  SELECT BKDO.DO_NO||BKDO.DO_NO_SPLIT AS DO_NO" ).append("\n"); 
		query.append("                       , BKDO.IDA_DO_DMDT_PAY_TP_CD AS DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("                       , MAX(DECODE(WEEK_ODR, 1, 1, 0)) FIRST_WK" ).append("\n"); 
		query.append("                       , MAX(DECODE(WEEK_ODR, 2, 1, 0)) SECOND_WK" ).append("\n"); 
		query.append("                       , MAX(DECODE(WEEK_ODR, 3, 1, 0)) THIRD_WK" ).append("\n"); 
		query.append("                       , MAX(DECODE(WEEK_ODR, 4, 1, 0)) FORTH_WK" ).append("\n"); 
		query.append("                       , MAX(DECODE(WEEK_ODR, 5, 1, 6, 1, 0)) FIFTH_WK" ).append("\n"); 
		query.append("                 FROM (" ).append("\n"); 
		query.append("                        SELECT WEEK_START" ).append("\n"); 
		query.append("                            , LEAD(WEEK_START) OVER (ORDER BY WEEK_START) WEEK_END" ).append("\n"); 
		query.append("                                  , ROW_NUMBER() OVER (ORDER BY WEEK_START) WEEK_ODR" ).append("\n"); 
		query.append("                             FROM (" ).append("\n"); 
		query.append("                                   #if (${rd_flag} == 'F')" ).append("\n"); 
		query.append("                                       SELECT DECODE(ROWNUM, 1, TO_DATE(@[evnt_dt_fm], 'YYYYMMDD')  -- RLSE_DATE" ).append("\n"); 
		query.append("                                                           , 8, TO_DATE(@[evnt_dt_to], 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("                                                           , NEXT_DAY(TO_DATE(@[evnt_dt_fm], 'YYYYMMDD') -14 , to_char(to_date('20060101', 'YYYYMMDD'), 'day')) + (7 * ROWNUM) -- to_char(to_date('20060101', 'YYYYMMDD'), 'day') 는 항상 일요일이다." ).append("\n"); 
		query.append("                                                     ) WEEK_START" ).append("\n"); 
		query.append("                                       FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                       WHERE ROWNUM < 9" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                                   #if (${rd_flag} == 'S')" ).append("\n"); 
		query.append("                                       SELECT DECODE(ROWNUM, 1, TO_DATE(@[evnt_dt_ym], 'YYYYMM')  -- RELEASE DATE YM" ).append("\n"); 
		query.append("                                                           , 8, ADD_MONTHS(TO_DATE(@[evnt_dt_ym], 'YYYYMM') , 1)" ).append("\n"); 
		query.append("                                                           , NEXT_DAY(TO_DATE(@[evnt_dt_ym], 'YYYYMM') -14 , to_char(to_date('20060101', 'YYYYMMDD'), 'day')) + (7 * ROWNUM) " ).append("\n"); 
		query.append("                                                     ) WEEK_START" ).append("\n"); 
		query.append("                                       FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                       WHERE ROWNUM < 9" ).append("\n"); 
		query.append("                                   #end" ).append("\n"); 
		query.append("                            ) START_DAYS" ).append("\n"); 
		query.append("                     WHERE 1= 1 " ).append("\n"); 
		query.append("                 #if (${rd_flag} == 'F')" ).append("\n"); 
		query.append("                     AND WEEK_START >= TO_DATE(@[evnt_dt_fm], 'YYYYMMDD')" ).append("\n"); 
		query.append("                     AND WEEK_START <= TO_DATE (@[evnt_dt_to], 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${rd_flag} == 'S')" ).append("\n"); 
		query.append("                     AND WEEK_START >= TO_DATE(@[evnt_dt_ym], 'YYYYMM')" ).append("\n"); 
		query.append("                     AND WEEK_START <= ADD_MONTHS(TO_DATE (@[evnt_dt_ym], 'YYYYMM'), 1)" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                     GROUP BY WEEK_START" ).append("\n"); 
		query.append("                     ) WEKS" ).append("\n"); 
		query.append("                   , BKG_DO_DTL DOTL" ).append("\n"); 
		query.append("                   , BKG_DO BKDO" ).append("\n"); 
		query.append("                   , BKG_DO_CNTR DCNT" ).append("\n"); 
		query.append("                   , BKG_BOOKING BKGM" ).append("\n"); 
		query.append("                WHERE 1 = 1               " ).append("\n"); 
		query.append("                #if (${evnt_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND DOTL.EVNT_OFC_CD = @[evnt_ofc_cd] --- RELEASE OFFICE " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("                AND TRIM(DOTL.EVNT_DT) >= WEKS.WEEK_START" ).append("\n"); 
		query.append("                AND TRIM(DOTL.EVNT_DT) < WEKS.WEEK_END" ).append("\n"); 
		query.append("                AND BKDO.BKG_NO = DOTL.BKG_NO" ).append("\n"); 
		query.append("                AND BKDO.RLSE_SEQ = DOTL.RLSE_SEQ" ).append("\n"); 
		query.append("                AND BKDO.IDA_DO_DMDT_PAY_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("            #if (${dmdt_pay_tp_cd} != '')" ).append("\n"); 
		query.append("                AND 1 = 1 -- AND BKDO.IDA_DO_DMDT_PAY_TP_CD = [dmdt_pay_tp_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                AND DCNT.BKG_NO = BKDO.BKG_NO" ).append("\n"); 
		query.append("                AND DCNT.RLSE_SEQ = BKDO.RLSE_SEQ" ).append("\n"); 
		query.append("            #if (${cntr_no} != '')" ).append("\n"); 
		query.append("                AND DCNT.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                AND BKGM.BKG_NO = BKDO.BKG_NO" ).append("\n"); 
		query.append("            #if (${bl_no} != '')" ).append("\n"); 
		query.append("                AND BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                GROUP BY BKDO.DO_NO||BKDO.DO_NO_SPLIT,BKDO.IDA_DO_DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("           ) SUBQ" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("           GROUP BY SUBQ.DMDT_PAY_TP_CD" ).append("\n"); 
		query.append("       ) SUBS" ).append("\n"); 
		query.append(" WHERE SUBS.DMDT_PAY_TP_CD(+) = CDTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(" ORDER BY CDTL.INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}