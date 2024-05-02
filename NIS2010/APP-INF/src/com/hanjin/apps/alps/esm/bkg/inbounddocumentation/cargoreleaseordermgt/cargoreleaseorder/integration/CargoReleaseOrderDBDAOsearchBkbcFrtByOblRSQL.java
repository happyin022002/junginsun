/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchBkbcFrtByOblRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchBkbcFrtByOblRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchBkbcFrtByOblRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchBkbcFrtByOblRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(C.FRT_CLT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N')," ).append("\n"); 
		query.append("              NVL(OBL.FRT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N'),'N','Y') FRT_CHK, " ).append("\n"); 
		query.append("       COUNT(*) AS FRT_CHK_CNT ," ).append("\n"); 
		query.append("	   FRT_FLG AS FRT_CLT_FLG              " ).append("\n"); 
		query.append("  FROM BKG_BOOKING  A," ).append("\n"); 
		query.append("       BKG_BL_DOC   B," ).append("\n"); 
		query.append("       BKG_CGO_RLSE C," ).append("\n"); 
		query.append("       (SELECT NVL(DECODE(PCT,'N',DECODE(FRT,'N',OTS,'Y'),'Y'),'N') FRT_FLG" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("				SELECT CASE WHEN SUM(ORG + THR ) > 0 THEN 'N' ELSE 'Y' END AS PCT" ).append("\n"); 
		query.append("                  --  ,CASE WHEN SUM(THR) > 0 THEN 'Y' ELSE 'N' END AS THR" ).append("\n"); 
		query.append("                FROM (SELECT DECODE(CHG.N3PTY_RCV_OFC_CD, '', 1, 0) AS ORG" ).append("\n"); 
		query.append("                            ,DECODE(CHG.N3PTY_RCV_OFC_CD, '', 0, 1) AS THR" ).append("\n"); 
		query.append("                       FROM BKG_BOOKING BKGM," ).append("\n"); 
		query.append("                            BKG_CHG_RT CHG" ).append("\n"); 
		query.append("                      WHERE BKGM.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                        AND BKGM.BKG_NO = CHG.BKG_NO" ).append("\n"); 
		query.append("                        AND CHG.FRT_TERM_CD = 'C'           " ).append("\n"); 
		query.append("                        AND CHG.FRT_INCL_XCLD_DIV_CD = 'N') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               )," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               (SELECT DECODE(COUNT(*),0,'Y','N')  FRT" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING D," ).append("\n"); 
		query.append("                       BKG_RATE    E," ).append("\n"); 
		query.append("                       BKG_CHG_RT  F" ).append("\n"); 
		query.append("                 WHERE D.BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("                   AND D.BKG_NO       = E.BKG_NO" ).append("\n"); 
		query.append("                   AND D.BKG_NO       = F.BKG_NO" ).append("\n"); 
		query.append("                   AND F.FRT_TERM_CD  = 'C'" ).append("\n"); 
		query.append("                   AND F.FRT_INCL_XCLD_DIV_CD = 'N'" ).append("\n"); 
		query.append("                   AND F.CHG_CD NOT IN ('BRO','FAC','FRB')" ).append("\n"); 
		query.append("               )," ).append("\n"); 
		query.append("               (SELECT SUBSTR(MAX(TO_CHAR(NVL(LST_UPD_CHK_DT,TO_DATE('00010101010101','YYYYMMDDHH24MISS')),'YYYYMMDDHH24MISS')||" ).append("\n"); 
		query.append("                                             GREATEST(NVL(CR_FLG,'N'),NVL(OTS_STL_FLG,'N'))),-1) AS OTS" ).append("\n"); 
		query.append("                  FROM BKG_OUTSTANDING" ).append("\n"); 
		query.append("                 WHERE CLT_BL_NO     = @[bl_no]" ).append("\n"); 
		query.append("                   AND OTS_BND_TP_CD = 'I'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) OBL" ).append("\n"); 
		query.append(" WHERE A.BL_NO   = @[bl_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.BL_NO   = C.BL_NO" ).append("\n"); 
		query.append("GROUP BY DECODE(NVL(C.FRT_CLT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N')," ).append("\n"); 
		query.append("         NVL(OBL.FRT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N'),'N','Y')," ).append("\n"); 
		query.append("         FRT_FLG" ).append("\n"); 

	}
}