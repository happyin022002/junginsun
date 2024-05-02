/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchBkbcCaOblRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
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

public class CargoReleaseOrderDBDAOsearchBkbcCaOblRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CA Cargo Relase 대상 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchBkbcCaOblRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOsearchBkbcCaOblRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	FOB_CA_CHK," ).append("\n"); 
		query.append("	OBL_CHK," ).append("\n"); 
		query.append("	OBL_CHK_CNT," ).append("\n"); 
		query.append("	OBL_RDEM_FLG," ).append("\n"); 
		query.append("	BL_NO," ).append("\n"); 
		query.append("	CNT_CD," ).append("\n"); 
		query.append("	(SELECT SUBSTR(POD_CD,1,2) FROM BKG_BOOKING WHERE BKG_NO = @[bl_no]) POD_CA_CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT MAX(VSK_CNT) AS FOB_CA_CHK," ).append("\n"); 
		query.append("       MAX(OBL_CHK) AS OBL_CHK," ).append("\n"); 
		query.append("       MAX(OBL_CHK_CNT) AS OBL_CHK_CNT," ).append("\n"); 
		query.append("       MAX(OBL_REAL_FLG) AS OBL_RDEM_FLG," ).append("\n"); 
		query.append("       @[bl_no] AS  BL_NO," ).append("\n"); 
		query.append("       DECODE(MAX(VSK_CNT),'Y','CA',NULL) AS CNT_CD" ).append("\n"); 
		query.append("  FROM (       " ).append("\n"); 
		query.append("        SELECT DECODE(SUBSTR(CSTMS_PORT_CD,1,2),'CA','Y','N') US_CHK," ).append("\n"); 
		query.append("               '' OBL_CHK," ).append("\n"); 
		query.append("               0 OBL_CHK_CNT," ).append("\n"); 
		query.append("               '' OBL_REAL_FLG," ).append("\n"); 
		query.append("               SUBSTR(CSTMS_PORT_CD,1,2) CNT_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("         WHERE CNT_CD = 'CA'" ).append("\n"); 
		query.append("           AND BL_NO  = @[bl_no] " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Y'," ).append("\n"); 
		query.append("               DECODE(NVL(C.FRT_CLT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N')," ).append("\n"); 
		query.append("                      NVL(C.FRT_CLT_FLG,'N')||(CASE WHEN A.BL_TP_CD='W' OR D.OBL_SRND_FLG='Y' THEN 'Y' ELSE 'N' END)||NVL(C.CSTMS_CLR_CD,'N'),'N','Y') FOC_YN," ).append("\n"); 
		query.append("               COUNT(C.BL_NO)," ).append("\n"); 
		query.append("               CASE WHEN A.BL_TP_CD='W' OR D.OBL_SRND_FLG='Y' THEN 'Y' ELSE 'N' END," ).append("\n"); 
		query.append("               'CA'" ).append("\n"); 
		query.append("          FROM BKG_BOOKING  A," ).append("\n"); 
		query.append("               BKG_BL_DOC   B," ).append("\n"); 
		query.append("               BKG_CGO_RLSE C," ).append("\n"); 
		query.append("               BKG_BL_ISS   D" ).append("\n"); 
		query.append("         WHERE A.BL_NO   = @[bl_no]" ).append("\n"); 
		query.append("           AND A.BKG_NO  = B.BKG_NO(+)" ).append("\n"); 
		query.append("           AND A.BKG_NO  = D.BKG_NO(+)" ).append("\n"); 
		query.append("           AND A.BL_NO   = C.BL_NO(+)" ).append("\n"); 
		query.append("        GROUP BY DECODE(NVL(C.FRT_CLT_FLG,'N')||NVL(C.OBL_RDEM_FLG,'N')||NVL(C.CSTMS_CLR_CD,'N')," ).append("\n"); 
		query.append("                        NVL(C.FRT_CLT_FLG,'N')||(CASE WHEN A.BL_TP_CD='W' OR D.OBL_SRND_FLG='Y' THEN 'Y' ELSE 'N' END)||NVL(C.CSTMS_CLR_CD,'N'),'N','Y')   ," ).append("\n"); 
		query.append("                 CASE WHEN A.BL_TP_CD='W' OR D.OBL_SRND_FLG='Y' THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("       ) AA," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT DECODE(COUNT(*),0,'N','Y') VSK_CNT" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT C.BL_NO" ).append("\n"); 
		query.append("                  FROM BKG_VVD          A," ).append("\n"); 
		query.append("                       VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("                       BKG_BOOKING      C" ).append("\n"); 
		query.append("                 WHERE C.BL_NO      = @[bl_no] " ).append("\n"); 
		query.append("                   AND A.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                   AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B.VPS_PORT_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                   AND SUBSTR(C.POL_CD,1,2) <> 'CA' " ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT BL_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING" ).append("\n"); 
		query.append("                 WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   AND ( POD_CD LIKE 'CA%' OR DEL_CD LIKE 'CA%' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) BB" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}