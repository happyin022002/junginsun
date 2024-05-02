/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchBkbcFrtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.29
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.08.29 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchBkbcFrtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchBkbcFrtRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchBkbcFrtRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    US_CHK," ).append("\n"); 
		query.append("    FRT_CHK," ).append("\n"); 
		query.append("    FRT_CHK_CNT," ).append("\n"); 
		query.append("    CNT_CD," ).append("\n"); 
		query.append("    (SELECT SUBSTR(POD_CD,1,2) FROM BKG_BOOKING WHERE BKG_NO = SUBSTR(@[bl_no],1,12)) CA_CHK" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT MAX(VSK_CNT) AS US_CHK," ).append("\n"); 
		query.append("       MAX(FRT_CHK) AS FRT_CHK," ).append("\n"); 
		query.append("       MAX(FRT_CHK_CNT) AS FRT_CHK_CNT," ).append("\n"); 
		query.append("       DECODE(MAX(VSK_CNT),'Y','US',NULL) AS CNT_CD" ).append("\n"); 
		query.append("  FROM (       " ).append("\n"); 
		query.append("        SELECT DECODE(SUBSTR(CSTMS_PORT_CD,1,2),'US','Y','N') US_CHK," ).append("\n"); 
		query.append("               '' FRT_CHK," ).append("\n"); 
		query.append("               0 FRT_CHK_CNT," ).append("\n"); 
		query.append("               SUBSTR(CSTMS_PORT_CD,1,2) CNT_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND BL_NO = SUBSTR(@[bl_no],1,12)" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Y'," ).append("\n"); 
		query.append("               DECODE(NVL(C.FRT_CLT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N')," ).append("\n"); 
		query.append("                              @[frt_clt_flg]||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N'),'N','Y') FOC_YN," ).append("\n"); 
		query.append("               COUNT(C.BL_NO)," ).append("\n"); 
		query.append("               'US'" ).append("\n"); 
		query.append("          FROM BKG_BOOKING  A," ).append("\n"); 
		query.append("               BKG_BL_DOC   B," ).append("\n"); 
		query.append("               BKG_CGO_RLSE C" ).append("\n"); 
		query.append("         WHERE A.BL_NO   = SUBSTR(@[bl_no],1,12)" ).append("\n"); 
		query.append("           AND A.BKG_NO  = B.BKG_NO(+)" ).append("\n"); 
		query.append("           AND A.BL_NO   = C.BL_NO(+)" ).append("\n"); 
		query.append("        GROUP BY DECODE(NVL(C.FRT_CLT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N')," ).append("\n"); 
		query.append("                                @[frt_clt_flg]||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N'),'N','Y')" ).append("\n"); 
		query.append("       ) AA," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT DECODE(COUNT(*),0,'N','Y') VSK_CNT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT C.BL_NO" ).append("\n"); 
		query.append("                  FROM BKG_VVD          A," ).append("\n"); 
		query.append("                       VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("                       BKG_BOOKING      C" ).append("\n"); 
		query.append("                 WHERE C.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("                   AND A.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                   AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("                   AND SUBSTR(C.POL_CD,1,2) <> 'US'" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT BL_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING" ).append("\n"); 
		query.append("                 WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND (" ).append("\n"); 
		query.append("                         POD_CD LIKE 'US%' OR " ).append("\n"); 
		query.append("						(POD_CD LIKE 'CA%') OR" ).append("\n"); 
		query.append("                        (POD_CD LIKE 'CA%' AND DEL_CD LIKE 'US%') OR" ).append("\n"); 
		query.append("                         DEL_CD LIKE 'MX%'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) BB" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}