/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOSearchBlRouteCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOSearchBlRouteCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL Route Country
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOSearchBlRouteCountryRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOSearchBlRouteCountryRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT ROUTE_CNT" ).append("\n"); 
		query.append("     , MAX(NO) AS CLPT_SEQ " ).append("\n"); 
		query.append("FROM (SELECT SUBSTR(A.VPS_PORT_CD, 1, 2) AS ROUTE_CNT" ).append("\n"); 
		query.append("           , ROWNUM NO" ).append("\n"); 
		query.append("        FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("           , ( SELECT SKD1.VSL_CD, SKD1.SKD_VOY_NO, SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                    , SKD1.VPS_PORT_CD AS POL_CD, SKD1.CLPT_SEQ AS POL_CLPT_SEQ" ).append("\n"); 
		query.append("                    , SKD2.VPS_PORT_CD AS POD_CD, SKD2.CLPT_SEQ AS POD_CLPT_SEQ" ).append("\n"); 
		query.append("                 FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                    , BKG_BOOKING BKG" ).append("\n"); 
		query.append("                    , BKG_BL_DOC BD" ).append("\n"); 
		query.append("                    , VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("                    , VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("                WHERE BKG.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("                  AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                  AND BKG.BKG_STS_CD IN ('F', 'W')" ).append("\n"); 
		query.append("                  AND BKG.BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  AND BKG.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                  AND VVD.VSL_CD         = SKD1.VSL_CD" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO     = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD     = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VVD.POL_CD         = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND VVD.POL_CLPT_IND_SEQ = SKD1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND NVL(SKD1.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                  AND VVD.VSL_CD         = SKD2.VSL_CD" ).append("\n"); 
		query.append("                  AND VVD.SKD_VOY_NO     = SKD2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND VVD.SKD_DIR_CD     = SKD2.SKD_DIR_CD" ).append("\n"); 
		query.append("                  AND VVD.POD_CD         = SKD2.VPS_PORT_CD" ).append("\n"); 
		query.append("                  AND VVD.POD_CLPT_IND_SEQ = SKD2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  AND NVL(SKD2.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                ORDER BY VVD.VSL_PRE_PST_CD, VVD.VSL_SEQ" ).append("\n"); 
		query.append("             ) B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO     = B.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD     = B.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND A.CLPT_SEQ >= B.POL_CLPT_SEQ" ).append("\n"); 
		query.append("        AND A.CLPT_SEQ <= B.POD_CLPT_SEQ" ).append("\n"); 
		query.append("        AND NVL(A.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("GROUP BY ROUTE_CNT" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 

	}
}