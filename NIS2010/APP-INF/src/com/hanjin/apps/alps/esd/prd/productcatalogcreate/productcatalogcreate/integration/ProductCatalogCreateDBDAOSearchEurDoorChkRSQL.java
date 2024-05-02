/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchEurDoorChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.05
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.12.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchEurDoorChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주지역 door 예외처리 있는지 확인
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchEurDoorChkRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchEurDoorChkRSQL").append("\n"); 
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
		query.append("MAX(CASE WHEN (SELECT CONTI_CD FROM MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(B.POR_NOD_CD,1,5) AND NVL(L.DELT_FLG,'N')='N') ='E'" ).append("\n"); 
		query.append("           AND (NVL((SELECT DOR_NOD_CD FROM TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("                      WHERE COP_NO =H.COP_NO " ).append("\n"); 
		query.append("                        AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("                        AND COST_ACT_GRP_CD LIKE 'OD%' " ).append("\n"); 
		query.append("                        AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("                        AND NVL(RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("                        AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                        AND NVL(DELT_FLG,'N') <> 'Y' ),B.POR_NOD_CD) <> B.POR_NOD_CD" ).append("\n"); 
		query.append("                OR H.OB_TRO_FLG ='Y' AND H.POR_NOD_CD <> B.POR_NOD_CD )" ).append("\n"); 
		query.append("      THEN 'Y'" ).append("\n"); 
		query.append("         WHEN (SELECT CONTI_CD FROM MDM_LOCATION L WHERE L.LOC_CD = SUBSTR(B.DEL_NOD_CD,1,5) AND NVL(L.DELT_FLG,'N')='N') ='E'" ).append("\n"); 
		query.append("           AND (NVL((SELECT DOR_NOD_CD FROM TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("                     WHERE COP_NO =H.COP_NO " ).append("\n"); 
		query.append("                        AND TRSP_BND_CD = 'I'" ).append("\n"); 
		query.append("                        AND COST_ACT_GRP_CD LIKE 'ID%' " ).append("\n"); 
		query.append("                       AND TRSP_SO_TP_CD <> 'S' " ).append("\n"); 
		query.append("                       AND NVL(RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("                       AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                       AND NVL(DELT_FLG,'N') <> 'Y' ),B.DEL_NOD_CD) <> B.DEL_NOD_CD" ).append("\n"); 
		query.append("                OR H.IB_TRO_FLG ='Y' AND H.DEL_NOD_CD <> B.DEL_NOD_CD )" ).append("\n"); 
		query.append("      THEN 'Y'" ).append("\n"); 
		query.append("      ELSE 'N'" ).append("\n"); 
		query.append("    END)  EUR_DR_CHK" ).append("\n"); 
		query.append("FROM BKG_BOOKING B,SCE_COP_HDR H" ).append("\n"); 
		query.append("WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("AND H.COP_STS_CD IN ('C','T','F')" ).append("\n"); 

	}
}