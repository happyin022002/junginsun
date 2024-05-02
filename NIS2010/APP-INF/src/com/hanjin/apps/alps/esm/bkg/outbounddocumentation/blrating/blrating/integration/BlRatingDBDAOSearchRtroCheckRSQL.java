/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOSearchRtroCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchRtroCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOSearchRtroCheckRSQL
	  * </pre>
	  */
	public BlRatingDBDAOSearchRtroCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchRtroCheckRSQL").append("\n"); 
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
		query.append("SELECT COD.COD_CHK||PCT.PCT_CHK||RTRO.SO_KUP  RTRO_CHK" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT MIN(COD_CHK) COD_CHK -- COD 아니면 Y" ).append("\n"); 
		query.append("        FROM   (" ).append("\n"); 
		query.append("                SELECT 'N' COD_CHK FROM   BKG_COD WHERE  BKG_NO = @[bkg_no] AND COD_STS_CD = 'F' --BKG Confirm" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 'N' COD_CHK FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no] AND SPLIT_FLG = 'Y'                " ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT 'Y' COD_CHK FROM DUAL" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        ) COD," ).append("\n"); 
		query.append("       (       " ).append("\n"); 
		query.append("        SELECT  MAX(PCT_CHK) PCT_CHK -- SPLIT 아니고, PCT 지났으면 Y" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                    SELECT  'Y' PCT_CHK" ).append("\n"); 
		query.append("                    FROM    BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE   1=1" ).append("\n"); 
		query.append("                    AND     BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                    AND     RFA_NO IS NOT NULL" ).append("\n"); 
		query.append("                    --AND     SPLIT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND     TRUNC(PORT_CLZ_DT) + 1 < (SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', SYSDATE, (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[usr_id])) FROM DUAL)" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT  'N' PCT_CHK FROM DUAL" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        ) PCT," ).append("\n"); 
		query.append("       ( " ).append("\n"); 
		query.append("		SELECT  MAX(SO_KUP) SO_KUP" ).append("\n"); 
		query.append("		FROM   (       " ).append("\n"); 
		query.append("        		SELECT DECODE(SIGN(TRUNC((SELECT GLOBALDATE_PKG.TIME_CONV_OFC_FNC('SELSC', A.CRE_DT, (SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[usr_id]) ) FROM DUAL)) - TRUNC(A.EFF_DT)),1,'Y','N') SO_KUP " ).append("\n"); 
		query.append("        		FROM   PRI_RP_MN A" ).append("\n"); 
		query.append("        		WHERE  (PROP_NO, AMDT_SEQ) = (SELECT  RS.PROP_NO, RS.AMDT_SEQ " ).append("\n"); 
		query.append("                		                      FROM    BKG_BOOKING BK," ).append("\n"); 
		query.append("                        		                      PRI_RP_HDR  RH," ).append("\n"); 
		query.append("                               				          PRI_RP_MN   RM," ).append("\n"); 
		query.append("                               				          PRI_RP_SCP_MN RS" ).append("\n"); 
		query.append("                		                      WHERE   BK.RFA_NO = RH.RFA_NO" ).append("\n"); 
		query.append("                		                      AND     RM.PROP_NO      = RH.PROP_NO" ).append("\n"); 
		query.append("                		                      AND     RM.PROP_STS_CD  = 'A'" ).append("\n"); 
		query.append("                		                      AND     RS.PROP_NO      = RM.PROP_NO" ).append("\n"); 
		query.append("                		                      AND     RS.AMDT_SEQ     = RM.AMDT_SEQ" ).append("\n"); 
		query.append("                		                      AND     RS.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("                		                      AND     (SELECT TO_DATE(RT_APLY_DT) FROM BKG_RATE A WHERE A.BKG_NO = BK.BKG_NO ) BETWEEN RS.EFF_DT AND RS.EXP_DT" ).append("\n"); 
		query.append("                		                      AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("                		                      AND     ROWNUM =1" ).append("\n"); 
		query.append("                		                      )" ).append("\n"); 
		query.append("        		UNION ALL" ).append("\n"); 
		query.append("        		SELECT 'N'  SO_KUP FROM DUAL" ).append("\n"); 
		query.append("        	   )" ).append("\n"); 
		query.append("        ) RTRO" ).append("\n"); 

	}
}