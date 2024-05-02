/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdateCmlTztmHrsUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdateCmlTztmHrsUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pdateCmlTztmHrs
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdateCmlTztmHrsUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdateCmlTztmHrsUSQL").append("\n"); 
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
		query.append("UPDATE    PRD_PROD_CTL_MST      X" ).append("\n"); 
		query.append("SET       X.CML_OCN_TZTM_HRS    = (" ).append("\n"); 
		query.append("                                    (SELECT  MAX(D.DEP_FSH_DT)" ).append("\n"); 
		query.append("                                     FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                     WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                     AND     D.PCTL_IO_BND_CD       = 'T'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                    -" ).append("\n"); 
		query.append("                                    (SELECT  MIN(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                     FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                     WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                     AND     D.PCTL_IO_BND_CD       = 'T'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                  )*24" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      ,   X.CML_INLND_TZTM_HRS  = (" ).append("\n"); 
		query.append("									-- ::O/B Transit Time:: --" ).append("\n"); 
		query.append("                                    (SELECT  MIN(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                     FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                     WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                     AND     D.PCTL_IO_BND_CD       = 'T'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                    -" ).append("\n"); 
		query.append("                                    CASE WHEN X.BKG_RCV_TERM_CD = 'Y' AND X.POR_CD = X.POL_CD THEN	/* ONLY FOR O/B PORT TRANSPORTATION :GAP:PCT&Terminal.Gate-In */" ).append("\n"); 
		query.append("                                        (SELECT  MIN(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                         FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                         WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                         AND     D.PCTL_IO_BND_CD       = 'O'" ).append("\n"); 
		query.append("                                         AND     D.MTY_YD_FLG           = 'N'" ).append("\n"); 
		query.append("                                         AND     D.PCTL_SEQ             > (SELECT   MIN(DD.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                           FROM     PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                                           WHERE    DD.PCTL_NO            = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                           AND      DD.PCTL_IO_BND_CD     = D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                                                           AND      DD.NOD_LNK_DIV_CD     = 'L'" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("										WHEN X.BKG_RCV_TERM_CD = 'Y' AND X.POR_CD <> X.POL_CD THEN	/* ONLY FOR Except O/B PORT TRANSPORTATION */" ).append("\n"); 
		query.append("                                        (SELECT  MIN(D.DEP_FSH_DT)" ).append("\n"); 
		query.append("                                         FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                         WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                         AND     D.PCTL_IO_BND_CD       = 'O'" ).append("\n"); 
		query.append("                                         AND     D.MTY_YD_FLG           = 'N'" ).append("\n"); 
		query.append("                                         AND     D.PCTL_SEQ             > (SELECT   MIN(DD.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                           FROM     PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                                           WHERE    DD.PCTL_NO            = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                           AND      DD.PCTL_IO_BND_CD     = D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                                                           AND      DD.NOD_LNK_DIV_CD     = 'L'" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                         WHEN X.BKG_RCV_TERM_CD = 'D' THEN" ).append("\n"); 
		query.append("                                        (SELECT  MIN(D.DEP_FSH_DT)" ).append("\n"); 
		query.append("                                         FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                         WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                         AND     D.PCTL_IO_BND_CD       = 'O'" ).append("\n"); 
		query.append("                                         AND     D.MTY_YD_FLG           = 'N'" ).append("\n"); 
		query.append("                                         AND     D.PCTL_SEQ             > (SELECT   MIN(DD.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                           FROM     PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                                           WHERE    DD.PCTL_NO            = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                           AND      DD.PCTL_IO_BND_CD     = D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                                                           AND      DD.NOD_LNK_DIV_CD     = 'L'" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                         WHEN X.BKG_RCV_TERM_CD = 'S' THEN" ).append("\n"); 
		query.append("                                        (SELECT  MIN(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                     	 FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                     	 WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                     	 AND     D.PCTL_IO_BND_CD       = 'T'" ).append("\n"); 
		query.append("                                    	) " ).append("\n"); 
		query.append("										ELSE" ).append("\n"); 
		query.append("                                        (SELECT  MIN(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                         FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                         WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                         AND     D.PCTL_IO_BND_CD       = 'O'" ).append("\n"); 
		query.append("                                         AND     D.MTY_YD_FLG           = 'N'" ).append("\n"); 
		query.append("                                         AND     D.PCTL_SEQ             > (SELECT   MIN(DD.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                           FROM     PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                                           WHERE    DD.PCTL_NO            = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                           AND      DD.PCTL_IO_BND_CD     = D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                                                           AND      DD.NOD_LNK_DIV_CD     = 'L'" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                        )                                         " ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("                                  )*24" ).append("\n"); 
		query.append("                                  +" ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("									-- ::I/B Transit Time:: --" ).append("\n"); 
		query.append("                                    CASE WHEN X.BKG_DE_TERM_CD = 'Y' THEN" ).append("\n"); 
		query.append("                                        (SELECT  MAX(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                         FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                         WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                         AND     D.PCTL_IO_BND_CD       = 'I'" ).append("\n"); 
		query.append("                                         AND     D.MTY_YD_FLG           = 'N'" ).append("\n"); 
		query.append("                                         AND     D.PCTL_SEQ             < (SELECT   MAX(DD.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                           FROM     PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                                           WHERE    DD.PCTL_NO            = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                           AND      DD.PCTL_IO_BND_CD     = D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                                                           AND      DD.NOD_LNK_DIV_CD     = 'L'" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                         WHEN X.BKG_DE_TERM_CD = 'D' THEN" ).append("\n"); 
		query.append("                                        (SELECT  MAX(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                         FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                         WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                         AND     D.PCTL_IO_BND_CD       = 'I'" ).append("\n"); 
		query.append("                                         AND     D.MTY_YD_FLG           = 'N'" ).append("\n"); 
		query.append("                                         AND     D.PCTL_SEQ             < (SELECT   MAX(DD.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                           FROM     PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                                           WHERE    DD.PCTL_NO            = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                           AND      DD.PCTL_IO_BND_CD     = D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                                                           AND      DD.NOD_LNK_DIV_CD     = 'L'" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                        )  " ).append("\n"); 
		query.append("                                         WHEN X.BKG_DE_TERM_CD = 'S' THEN" ).append("\n"); 
		query.append("                                    	(SELECT  MAX(D.DEP_FSH_DT)" ).append("\n"); 
		query.append("                                     	 FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                     	 WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                     	 AND     D.PCTL_IO_BND_CD       = 'T'" ).append("\n"); 
		query.append("                                    	)" ).append("\n"); 
		query.append("										ELSE" ).append("\n"); 
		query.append("                                        (SELECT  MAX(D.ARR_ST_DT)" ).append("\n"); 
		query.append("                                         FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                         WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                         AND     D.PCTL_IO_BND_CD       = 'I'" ).append("\n"); 
		query.append("                                         AND     D.MTY_YD_FLG           = 'N'" ).append("\n"); 
		query.append("                                         AND     D.PCTL_SEQ             < (SELECT   MAX(DD.PCTL_SEQ)" ).append("\n"); 
		query.append("                                                                           FROM     PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                                           WHERE    DD.PCTL_NO            = D.PCTL_NO" ).append("\n"); 
		query.append("                                                                           AND      DD.PCTL_IO_BND_CD     = D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                                                                           AND      DD.NOD_LNK_DIV_CD     = 'L'" ).append("\n"); 
		query.append("                                                                           )" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                                    END" ).append("\n"); 
		query.append("                                    -" ).append("\n"); 
		query.append("                                    (SELECT  MAX(D.DEP_FSH_DT)" ).append("\n"); 
		query.append("                                     FROM    PRD_PROD_CTL_ROUT_DTL  D" ).append("\n"); 
		query.append("                                     WHERE   D.PCTL_NO              = X.PCTL_NO" ).append("\n"); 
		query.append("                                     AND     D.PCTL_IO_BND_CD       = 'T'" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                                  )*24 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE     X.PCTL_NO             LIKE @[hd_pctl_no]||'%'     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----UPDATE PRD_PROD_CTL_MST X" ).append("\n"); 
		query.append("----   SET CML_OCN_TZTM_HRS   = NVL(((SELECT MAX(NVL(V.VPS_ETA_DT, D.DEP_FSH_DT))" ).append("\n"); 
		query.append("----                                    FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("----                                        ,VSK_VSL_PORT_SKD      V" ).append("\n"); 
		query.append("----                                   WHERE D.PCTL_NO = X.PCTL_NO" ).append("\n"); 
		query.append("----                                     AND D.PCTL_SEQ = (SELECT MAX(D2.PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2 WHERE D2.PCTL_NO = X.PCTL_NO AND D2.PCTL_IO_BND_CD = 'T')" ).append("\n"); 
		query.append("----                                     AND V.VSL_CD(+) = D.VSL_CD" ).append("\n"); 
		query.append("----                                     AND V.SKD_VOY_NO(+) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("----                                     AND V.SKD_DIR_CD(+) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("----                                     AND V.YD_CD(+) = D.DEST_NOD_CD" ).append("\n"); 
		query.append("----                                     AND V.CLPT_IND_SEQ(+) = D.DEST_CLPT_IND_SEQ" ).append("\n"); 
		query.append("----                                     AND V.SLAN_CD(+) = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("----                                     AND V.VPS_PORT_CD(+) = SUBSTR(D.DEST_NOD_CD, 1, 5)) -" ).append("\n"); 
		query.append("----                                (SELECT MIN(NVL(V.VPS_ETD_DT, D.ARR_ST_DT))" ).append("\n"); 
		query.append("----                                    FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("----                                        ,VSK_VSL_PORT_SKD      V" ).append("\n"); 
		query.append("----                                   WHERE D.PCTL_NO = X.PCTL_NO" ).append("\n"); 
		query.append("----                                     AND D.PCTL_SEQ = (SELECT MIN(D2.PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL D2 WHERE D2.PCTL_NO = X.PCTL_NO AND D2.PCTL_IO_BND_CD = 'T')" ).append("\n"); 
		query.append("----                                     AND V.VSL_CD(+) = D.VSL_CD" ).append("\n"); 
		query.append("----                                     AND V.SKD_VOY_NO(+) = D.SKD_VOY_NO" ).append("\n"); 
		query.append("----                                     AND V.SKD_DIR_CD(+) = D.SKD_DIR_CD" ).append("\n"); 
		query.append("----                                     AND V.YD_CD(+) = D.ORG_NOD_CD" ).append("\n"); 
		query.append("----                                     AND V.CLPT_IND_SEQ(+) = D.ORG_CLPT_IND_SEQ" ).append("\n"); 
		query.append("----                                     AND V.SLAN_CD(+) = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("----                                     AND V.VPS_PORT_CD(+) = SUBSTR(D.ORG_NOD_CD, 1, 5)))," ).append("\n"); 
		query.append("----                                0) * 24," ).append("\n"); 
		query.append("----       CML_INLND_TZTM_HRS =" ).append("\n"); 
		query.append("----       NVL((SELECT NVL(SUM(TZTM), 0) + 24" ).append("\n"); 
		query.append("----          FROM (SELECT A.PCTL_NO" ).append("\n"); 
		query.append("----                      ,NVL(CASE WHEN MAX(K.POR_CD) = MAX(K.POL_CD) THEN 0" ).append("\n"); 
		query.append("----                                ELSE SUM(NVL(TZ_DWLL_TM_HRS, 0)) + SUM(NVL(Y.DRY_AVG_DWLL_HRS, 0))" ).append("\n"); 
		query.append("----                           END, 0) TZTM" ).append("\n"); 
		query.append("----                  FROM PRD_PROD_CTL_ROUT_DTL A" ).append("\n"); 
		query.append("----                      ,MDM_YARD              Y" ).append("\n"); 
		query.append("----                      ,PRD_PROD_CTL_MST      K" ).append("\n"); 
		query.append("----                 WHERE A.PCTL_IO_BND_CD IN ('O')" ).append("\n"); 
		query.append("----                   AND A.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("----                   AND A.DEST_NOD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("----                   AND A.DEST_NOD_TP_CD <> 'Z'" ).append("\n"); 
		query.append("----                   AND A.PCTL_NO = K.PCTL_NO" ).append("\n"); 
		query.append("----                 GROUP BY A.PCTL_NO" ).append("\n"); 
		query.append("----                UNION ALL" ).append("\n"); 
		query.append("----                SELECT A.PCTL_NO" ).append("\n"); 
		query.append("----                      ,NVL(CASE WHEN MAX(K.POD_CD) = MAX(K.DEL_CD) THEN 0" ).append("\n"); 
		query.append("----                            	ELSE SUM(NVL(TZ_DWLL_TM_HRS, 0)) + SUM(NVL(Y.DRY_AVG_DWLL_HRS, 0))" ).append("\n"); 
		query.append("----                       	   END, 0) TZTM" ).append("\n"); 
		query.append("----                  FROM PRD_PROD_CTL_ROUT_DTL A" ).append("\n"); 
		query.append("----                      ,MDM_YARD              Y" ).append("\n"); 
		query.append("----                      ,PRD_PROD_CTL_MST      K" ).append("\n"); 
		query.append("----                 WHERE A.PCTL_IO_BND_CD IN ('I')" ).append("\n"); 
		query.append("----                   AND A.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("----                   AND A.DEST_NOD_CD = Y.YD_CD(+)" ).append("\n"); 
		query.append("----                   AND A.ORG_NOD_TP_CD <> 'Z'" ).append("\n"); 
		query.append("----				   AND A.PCTL_SEQ NOT IN (DECODE(K.BKG_RCV_TERM_CD, 'D', 2, 0), (SELECT MAX(PCTL_SEQ) - 1 FROM PRD_PROD_CTL_ROUT_DTL WHERE PCTL_NO = K.PCTL_NO))	" ).append("\n"); 
		query.append("----                   AND A.PCTL_NO = K.PCTL_NO" ).append("\n"); 
		query.append("----                 GROUP BY A.PCTL_NO) IO" ).append("\n"); 
		query.append("----         WHERE IO.PCTL_NO = X.PCTL_NO), 0)" ).append("\n"); 
		query.append("---- WHERE PCTL_NO LIKE [hd_pctl_no] || '%'" ).append("\n"); 

	}
}