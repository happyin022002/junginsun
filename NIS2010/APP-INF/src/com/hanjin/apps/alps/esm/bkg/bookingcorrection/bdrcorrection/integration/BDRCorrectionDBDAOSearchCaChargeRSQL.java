/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchCaChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2014.01.16 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchCaChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchCaChargeRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchCaChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchCaChargeRSQL").append("\n"); 
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
		query.append("with chg_rt as" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT OLD.CHG_CD OCHG_CD," ).append("\n"); 
		query.append("          OLD.RAT_UT_CD ORAT_UT_CD," ).append("\n"); 
		query.append("          OLD.RAT_AS_QTY ORAT_AS_QTY," ).append("\n"); 
		query.append("          OLD.CURR_CD OCURR_CD," ).append("\n"); 
		query.append("          OLD.CHG_UT_AMT OCHG_UT_AMT," ).append("\n"); 
		query.append("          OLD.CHG_AMT OCHG_AMT," ).append("\n"); 
		query.append("          OLD.FRT_TERM_CD OFRT_TERM_CD," ).append("\n"); 
		query.append("          OLD.N3PTY_RCV_OFC_CD ON3PTY_RCV_OFC_CD," ).append("\n"); 
		query.append("          NEW.CHG_CD NCHG_CD," ).append("\n"); 
		query.append("          NEW.RAT_UT_CD NRAT_UT_CD," ).append("\n"); 
		query.append("          NEW.RAT_AS_QTY NRAT_AS_QTY," ).append("\n"); 
		query.append("          NEW.CURR_CD NCURR_CD," ).append("\n"); 
		query.append("          NEW.CHG_UT_AMT NCHG_UT_AMT," ).append("\n"); 
		query.append("          NEW.CHG_AMT NCHG_AMT," ).append("\n"); 
		query.append("          NEW.FRT_TERM_CD NFRT_TERM_CD," ).append("\n"); 
		query.append("          NEW.N3PTY_RCV_OFC_CD NN3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("    from (" ).append("\n"); 
		query.append("        SELECT BKG_NO, CORR_NO, CHG_CD, RAT_UT_CD, RAT_AS_QTY, CURR_CD, SUM(CHG_UT_AMT) AS CHG_UT_AMT, SUM(CHG_AMT) AS CHG_AMT,FRT_TERM_CD, NVL(N3PTY_RCV_OFC_CD, 'X') N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT_HIS BCRH" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  		  AND FRT_INCL_XCLD_DIV_CD       = 'N'" ).append("\n"); 
		query.append("          and corr_no = ( SELECT CORR_NO FROM BKG_CORRECTION " ).append("\n"); 
		query.append("                            WHERE BKG_NO = BCRH.BKG_NO" ).append("\n"); 
		query.append("                              AND CORR_DT = ( SELECT MAX(CORR_DT) FROM BKG_CORRECTION" ).append("\n"); 
		query.append("                                               WHERE BKG_NO = BCRH.BKG_NO" ).append("\n"); 
		query.append("                                                 AND CORR_DT < ( select CORR_DT from bkg_correction " ).append("\n"); 
		query.append("                                                                    where BKG_NO = BCRH.BKG_NO" ).append("\n"); 
		query.append("                                                                    AND  corr_no = @[ca_no] )) )" ).append("\n"); 
		query.append("        GROUP BY BKG_NO, CORR_NO, CHG_CD, RAT_UT_CD, RAT_AS_QTY, CURR_CD, FRT_TERM_CD, NVL(N3PTY_RCV_OFC_CD, 'X')" ).append("\n"); 
		query.append("        ) old FULL OUTER JOIN (" ).append("\n"); 
		query.append("        SELECT BKG_NO, CORR_NO, CHG_CD, RAT_UT_CD, RAT_AS_QTY, CURR_CD, SUM(CHG_UT_AMT) AS CHG_UT_AMT, SUM(CHG_AMT) AS CHG_AMT,FRT_TERM_CD, NVL(N3PTY_RCV_OFC_CD, 'X') N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append("        FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          and corr_no = @[ca_no]		  " ).append("\n"); 
		query.append("  		  AND FRT_INCL_XCLD_DIV_CD       = 'N'" ).append("\n"); 
		query.append("        GROUP BY BKG_NO, CORR_NO, CHG_CD, RAT_UT_CD, RAT_AS_QTY, CURR_CD, FRT_TERM_CD, NVL(N3PTY_RCV_OFC_CD, 'X')) new " ).append("\n"); 
		query.append("       on old.bkg_no = new.bkg_no" ).append("\n"); 
		query.append("      AND OLD.CHG_CD = NEW.CHG_CD" ).append("\n"); 
		query.append("      AND OLD.RAT_UT_CD = NEW.RAT_UT_CD" ).append("\n"); 
		query.append("      AND OLD.CURR_CD = NEW.CURR_CD" ).append("\n"); 
		query.append("      AND OLD.FRT_TERM_CD = NEW.FRT_TERM_CD" ).append("\n"); 
		query.append("      AND OLD.RAT_AS_QTY = NEW.RAT_AS_QTY" ).append("\n"); 
		query.append("      AND OLD.N3PTY_RCV_OFC_CD = NEW .N3PTY_RCV_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT CORR_NAME, " ).append("\n"); 
		query.append("       CHG_CD, " ).append("\n"); 
		query.append("       RAT_UT_CD, " ).append("\n"); 
		query.append("       RAT_AS_QTY, " ).append("\n"); 
		query.append("       CURR_CD, " ).append("\n"); 
		query.append("       CHG_UT_AMT, " ).append("\n"); 
		query.append("       CHG_AMT, " ).append("\n"); 
		query.append("       FRT_TERM_CD," ).append("\n"); 
		query.append("       PREPAID, " ).append("\n"); 
		query.append("       COLLECT, " ).append("\n"); 
		query.append("       THIRD " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    select '1'                     as SEQ, " ).append("\n"); 
		query.append("       'PREVIOUS'                  as CORR_NAME," ).append("\n"); 
		query.append("       NVL(OCHG_CD,NCHG_CD)        as CHG_CD," ).append("\n"); 
		query.append("       NVL(ORAT_UT_CD,NRAT_UT_CD)  as RAT_UT_CD," ).append("\n"); 
		query.append("       TO_CHAR(NVL(ORAT_AS_QTY,0)) as RAT_AS_QTY," ).append("\n"); 
		query.append("       OCURR_CD                    as CURR_CD," ).append("\n"); 
		query.append("       NVL(OCHG_UT_AMT,0)          as CHG_UT_AMT," ).append("\n"); 
		query.append("       NVL(OCHG_AMT,0)             as CHG_AMT," ).append("\n"); 
		query.append("       OFRT_TERM_CD                as FRT_TERM_CD," ).append("\n"); 
		query.append("       TO_CHAR(DECODE(NVL(ON3PTY_RCV_OFC_CD,'N'),'N', DECODE(OFRT_TERM_CD ,'P', OCHG_AMT, '0'),'0')) as PREPAID," ).append("\n"); 
		query.append("       TO_CHAR(DECODE(NVL(ON3PTY_RCV_OFC_CD,'N'),'N', DECODE(OFRT_TERM_CD ,'C', OCHG_AMT, '0'),'0')) as COLLECT," ).append("\n"); 
		query.append("       TO_CHAR(DECODE(NVL(ON3PTY_RCV_OFC_CD,'N'),'N','0', OCHG_AMT)) as THIRD" ).append("\n"); 
		query.append("    FROM chg_rt" ).append("\n"); 
		query.append("    WHERE ( NVL(OCHG_CD,' ') <> NVL(NCHG_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(ORAT_UT_CD,' ') <> NVL(NRAT_UT_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(OCURR_CD,' ') <> NVL(NCURR_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(OFRT_TERM_CD,' ') <> NVL(NFRT_TERM_CD ,' ')" ).append("\n"); 
		query.append("    OR NVL(ORAT_AS_QTY,0) <> NVL(NRAT_AS_QTY,0)" ).append("\n"); 
		query.append("    OR NVL(OCHG_UT_AMT,0) <> NVL(NCHG_UT_AMT,0) )" ).append("\n"); 
		query.append("    AND NVL(OCHG_CD,' ') <> ' '" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    select '2'                     as SEQ," ).append("\n"); 
		query.append("       'CURRENT'                   as CORR_NAME," ).append("\n"); 
		query.append("       NVL(NCHG_CD,OCHG_CD)        as CHG_CD," ).append("\n"); 
		query.append("       NVL(NRAT_UT_CD,ORAT_UT_CD)  as RAT_UT_CD," ).append("\n"); 
		query.append("       TO_CHAR(NVL(NRAT_AS_QTY,0)) as RAT_AS_QTY," ).append("\n"); 
		query.append("       NCURR_CD                    as CURR_CD," ).append("\n"); 
		query.append("       NVL(NCHG_UT_AMT,0)          as CHG_UT_AMT," ).append("\n"); 
		query.append("       NVL(NCHG_AMT,0)             as CHG_AMT," ).append("\n"); 
		query.append("       NFRT_TERM_CD                as FRT_TERM_CD," ).append("\n"); 
		query.append("       TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,'N'),'N', DECODE(NFRT_TERM_CD ,'P', NCHG_AMT, '0'),'0')) as PREPAID," ).append("\n"); 
		query.append("       TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,'N'),'N', DECODE(NFRT_TERM_CD ,'C', NCHG_AMT, '0'),'0')) as COLLECT," ).append("\n"); 
		query.append("       TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,'N'),'N','0', NCHG_AMT)) as THIRD" ).append("\n"); 
		query.append("    FROM chg_rt" ).append("\n"); 
		query.append("    WHERE ( NVL(OCHG_CD,' ') <> NVL(NCHG_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(ORAT_UT_CD,' ') <> NVL(NRAT_UT_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(OCURR_CD,' ') <> NVL(NCURR_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(OFRT_TERM_CD,' ') <> NVL(NFRT_TERM_CD ,' ')" ).append("\n"); 
		query.append("    OR NVL(ORAT_AS_QTY,0) <> NVL(NRAT_AS_QTY,0)" ).append("\n"); 
		query.append("    OR NVL(OCHG_UT_AMT,0) <> NVL(NCHG_UT_AMT,0))" ).append("\n"); 
		query.append("    AND NVL(NCHG_CD,' ') <> ' '" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    select '3'                                              as SEQ, " ).append("\n"); 
		query.append("           'DIFFERENCE'                                     as CORR_NAME," ).append("\n"); 
		query.append("           NVL(NCHG_CD,OCHG_CD)                             as CHG_CD," ).append("\n"); 
		query.append("           NVL(NRAT_UT_CD,ORAT_UT_CD)                       as RAT_UT_CD," ).append("\n"); 
		query.append("           TO_CHAR(NVL(NRAT_AS_QTY,0) - NVL(ORAT_AS_QTY,0)) as RAT_AS_QTY," ).append("\n"); 
		query.append("           NVL(NCURR_CD,OCURR_CD)                           as CURR_CD," ).append("\n"); 
		query.append("           NVL(NCHG_UT_AMT,0) - NVL(OCHG_UT_AMT,0)          as CHG_UT_AMT," ).append("\n"); 
		query.append("           NVL(NCHG_AMT,0) - NVL(OCHG_AMT,0)                as CHG_AMT," ).append("\n"); 
		query.append("           NVL(NFRT_TERM_CD,OFRT_TERM_CD)                   as FRT_TERM_CD," ).append("\n"); 
		query.append("           DECODE(TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'P', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0')), " ).append("\n"); 
		query.append("                  0, '-', " ).append("\n"); 
		query.append("                  TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'P', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0')) )" ).append("\n"); 
		query.append("            as PREPAID," ).append("\n"); 
		query.append("           DECODE(TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'C', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0')), " ).append("\n"); 
		query.append("                  0, '-', " ).append("\n"); 
		query.append("                  TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N', DECODE(NVL(NFRT_TERM_CD,OFRT_TERM_CD) ,'C', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0), '0'),'0')) )" ).append("\n"); 
		query.append("            as COLLECT," ).append("\n"); 
		query.append("           DECODE(TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N','0', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0))), " ).append("\n"); 
		query.append("                  0, '-', " ).append("\n"); 
		query.append("                  TO_CHAR(DECODE(NVL(NN3PTY_RCV_OFC_CD,NVL(ON3PTY_RCV_OFC_CD,'N')),'N','0', NVL(NCHG_AMT, 0) - NVL(OCHG_AMT, 0))) )" ).append("\n"); 
		query.append("            as THIRD" ).append("\n"); 
		query.append("    FROM chg_rt" ).append("\n"); 
		query.append("    WHERE NVL(OCHG_CD,' ') <> NVL(NCHG_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(ORAT_UT_CD,' ') <> NVL(NRAT_UT_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(OCURR_CD,' ') <> NVL(NCURR_CD,' ')" ).append("\n"); 
		query.append("    OR NVL(OFRT_TERM_CD,' ') <> NVL(NFRT_TERM_CD ,' ')" ).append("\n"); 
		query.append("    OR NVL(ORAT_AS_QTY,0) <> NVL(NRAT_AS_QTY,0)" ).append("\n"); 
		query.append("    OR NVL(OCHG_UT_AMT,0) <> NVL(NCHG_UT_AMT,0) )" ).append("\n"); 
		query.append("ORDER BY SEQ, CHG_CD, RAT_UT_CD" ).append("\n"); 

	}
}