/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOcheckScndOtsLstUptValidRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOcheckScndOtsLstUptValidRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOcheckScndOtsLstUptValidRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clt_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOcheckScndOtsLstUptValidRSQL").append("\n"); 
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
		query.append("SELECT MAX(US_BAT_CHK) AS US_BAT_CHK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DECODE(COUNT(*),0,'N','Y') US_BAT_CHK" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT C.BL_NO" ).append("\n"); 
		query.append("                  FROM BKG_VVD          A," ).append("\n"); 
		query.append("                       VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("                       BKG_BOOKING      C," ).append("\n"); 
		query.append("                       BKG_OUTSTANDING  D" ).append("\n"); 
		query.append("                 WHERE C.BL_NO      = @[clt_bl_no]" ).append("\n"); 
		query.append("                   AND A.BKG_NO     = C.BKG_NO" ).append("\n"); 
		query.append("                   AND A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND B.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("                   AND SUBSTR(C.POL_CD,1,2) <> 'US'" ).append("\n"); 
		query.append("                   AND C.BL_NO = D.CLT_BL_NO" ).append("\n"); 
		query.append("                   AND D.OFC_CD =@[ofc_cd]" ).append("\n"); 
		query.append("                   AND D.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                   AND CNG_IND_FLG ='Y' --SAR에서 미수금 관련건이 신규 OR 갱신되면 CNG_IND_FLG를 Y로 박아줌 Y 인 대상만 배치 돌게함" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT BL_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING A," ).append("\n"); 
		query.append("                       BKG_OUTSTANDING B" ).append("\n"); 
		query.append("                 WHERE BL_NO = @[clt_bl_no]" ).append("\n"); 
		query.append("                   AND (" ).append("\n"); 
		query.append("                         POD_CD LIKE 'US%' OR " ).append("\n"); 
		query.append("                         (POD_CD LIKE 'CA%') OR" ).append("\n"); 
		query.append("                        (POD_CD LIKE 'CA%' AND DEL_CD LIKE 'US%') OR" ).append("\n"); 
		query.append("                         DEL_CD LIKE 'MX%'" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                   AND A.BL_NO = B.CLT_BL_NO" ).append("\n"); 
		query.append("                   AND B.OFC_CD =@[ofc_cd]" ).append("\n"); 
		query.append("                   AND B.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("                   AND CNG_IND_FLG ='Y' --SAR에서 미수금 관련건이 신규 OR 갱신되면 CNG_IND_FLG를 Y로 박아줌 Y 인 대상만 배치 돌게함" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) US_CHK" ).append("\n"); 

	}
}