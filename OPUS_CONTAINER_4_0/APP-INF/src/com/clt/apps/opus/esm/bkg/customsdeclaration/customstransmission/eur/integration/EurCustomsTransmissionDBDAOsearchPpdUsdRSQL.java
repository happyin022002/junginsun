/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchPpdUsdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.10
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.03.10 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchPpdUsdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchPpdUsdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchPpdUsdRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(ROUND(NVL(SUM(CHG_AMT * DECODE(INV_XCH_RT, 0, MON_RT, INV_XCH_RT)),0), 6), 'FM999999999999990.000000') AS TOTAL_PREPAID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.BKG_NO" ).append("\n"); 
		query.append("              ,A.CURR_CD" ).append("\n"); 
		query.append("              ,A.CHG_AMT" ).append("\n"); 
		query.append("              ,NVL(B.INV_XCH_RT, 0) AS INV_XCH_RT" ).append("\n"); 
		query.append("              ,(SELECT DECODE(AA.USD_LOCL_XCH_RT, 0, 0, ROUND(1/AA.USD_LOCL_XCH_RT, 6))" ).append("\n"); 
		query.append("                  FROM GL_MON_XCH_RT AA" ).append("\n"); 
		query.append("                      ,(SELECT TO_CHAR(C.VPS_ETD_DT, 'YYYYMM') AS VPS_ETD_DT" ).append("\n"); 
		query.append("                          FROM (SELECT V.BKG_NO" ).append("\n"); 
		query.append("                                      ,V.POL_CD AS PORT_CD" ).append("\n"); 
		query.append("                                      ,V.VSL_CD" ).append("\n"); 
		query.append("                                      ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("                                      ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER(ORDER BY V.VSL_PRE_PST_CD, VSL_SEQ) AS RNUM" ).append("\n"); 
		query.append("                                  FROM BKG_VVD    V" ).append("\n"); 
		query.append("                                      ,BKG_BOOKING B" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND B.BKG_NO     = V.BKG_NO" ).append("\n"); 
		query.append("                                   AND B.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                               ) B" ).append("\n"); 
		query.append("                              ,VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("                         WHERE B.RNUM = 1" ).append("\n"); 
		query.append("                           AND B.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("                           AND B.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND B.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND B.PORT_CD    = C.VPS_PORT_CD" ).append("\n"); 
		query.append("                           AND C.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("                           AND B.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                       ) BB" ).append("\n"); 
		query.append("                 WHERE AA.ACCT_XCH_RT_YRMON = BB.VPS_ETD_DT" ).append("\n"); 
		query.append("                   AND AA.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("               ) AS MON_RT" ).append("\n"); 
		query.append("          FROM (SELECT MIN(BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("                      ,CURR_CD" ).append("\n"); 
		query.append("                      ,SUM(CHG_AMT) AS CHG_AMT" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                 WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                   AND FRT_TERM_CD = 'P' " ).append("\n"); 
		query.append("                   AND FRT_INCL_XCLD_DIV_CD='N'" ).append("\n"); 
		query.append("                GROUP BY CURR_CD" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,(SELECT DISTINCT B.BKG_NO" ).append("\n"); 
		query.append("                      ,C.LOCL_CURR_CD" ).append("\n"); 
		query.append("                      ,DECODE(C.INV_XCH_RT, 0, 0, ROUND(1/C.INV_XCH_RT, 6)) AS INV_XCH_RT" ).append("\n"); 
		query.append("                  FROM (SELECT V.BKG_NO" ).append("\n"); 
		query.append("                              ,V.POL_CD AS PORT_CD" ).append("\n"); 
		query.append("                              ,V.VSL_CD" ).append("\n"); 
		query.append("                              ,V.SKD_VOY_NO" ).append("\n"); 
		query.append("                              ,V.SKD_DIR_CD" ).append("\n"); 
		query.append("                              ,D.AR_OFC_CD" ).append("\n"); 
		query.append("                              ,ROW_NUMBER() OVER(ORDER BY V.VSL_PRE_PST_CD, VSL_SEQ) AS RNUM" ).append("\n"); 
		query.append("                          FROM BKG_VVD    V" ).append("\n"); 
		query.append("                              ,MDM_ORGANIZATION D" ).append("\n"); 
		query.append("                              ,BKG_BOOKING B" ).append("\n"); 
		query.append("                         WHERE 1=1" ).append("\n"); 
		query.append("                           AND B.BKG_OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("                           AND B.BKG_NO     = V.BKG_NO" ).append("\n"); 
		query.append("                           AND B.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                      ,INV_VVD_XCH_RT C" ).append("\n"); 
		query.append("                 WHERE B.RNUM =  1" ).append("\n"); 
		query.append("                   AND B.VSL_CD     = C.VSL_CD(+)" ).append("\n"); 
		query.append("                   AND B.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                   AND B.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                   AND B.PORT_CD    = C.PORT_CD(+)" ).append("\n"); 
		query.append("                   AND B.AR_OFC_CD  = C.AR_OFC_CD(+)" ).append("\n"); 
		query.append("                   AND C.IO_BND_CD(+) = 'O'" ).append("\n"); 
		query.append("                   AND C.CHG_CURR_CD(+)  = 'USD'" ).append("\n"); 
		query.append("                   AND C.LOCL_CURR_CD(+) <> 'USD'" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT @[bkg_no]" ).append("\n"); 
		query.append("                      ,'USD'" ).append("\n"); 
		query.append("                      ,1" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("               ) B" ).append("\n"); 
		query.append("         WHERE A.BKG_NO  = B.BKG_NO(+)" ).append("\n"); 
		query.append("           AND A.CURR_CD = B.LOCL_CURR_CD(+)" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}