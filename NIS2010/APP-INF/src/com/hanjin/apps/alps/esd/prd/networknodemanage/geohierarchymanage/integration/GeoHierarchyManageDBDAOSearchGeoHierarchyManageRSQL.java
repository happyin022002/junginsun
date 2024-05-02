/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeoHierarchyManageDBDAOSearchGeoHierarchyManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.07.22 노승배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Noh Seung Bae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeoHierarchyManageDBDAOSearchGeoHierarchyManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchGeoHierarchyManage
	  * </pre>
	  */
	public GeoHierarchyManageDBDAOSearchGeoHierarchyManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subconti_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.integration").append("\n"); 
		query.append("FileName : GeoHierarchyManageDBDAOSearchGeoHierarchyManageRSQL").append("\n"); 
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
		query.append("SELECT  E.CONTI_CD, A.CONTI_NM, E.SCONTI_CD, B.SCONTI_NM," ).append("\n"); 
		query.append("E.CNT_CD, C.CNT_NM," ).append("\n"); 
		query.append("C.ZN_DIV_BSEL_CD," ).append("\n"); 
		query.append("E.RGN_CD, D.RGN_NM, E.LOC_CD, E.LOC_NM, '' REMARK," ).append("\n"); 
		query.append("E.STE_CD, F.STE_NM STE_NM," ).append("\n"); 
		query.append("E.UN_LOC_IND_CD, E.UN_LOC_CD, E.LOC_GRD_NO," ).append("\n"); 
		query.append("G.RCC_CD RCC_CD, G.LCC_CD LCC_CD, G.ECC_CD ECC_CD, E.SCC_CD SCC_CD," ).append("\n"); 
		query.append("E.LOC_CHR_CD, E.SLS_OFC_CD, E.EQ_CTRL_OFC_CD, E.FINC_CTRL_OFC_CD, E.SEN_EQ_OFC_CD," ).append("\n"); 
		query.append("E.BKG_BL_PFX_CD, E.CML_ZN_FLG COMERCIAL_ZONE, E.CSTMS_CD CUSTOMERS," ).append("\n"); 
		query.append("E.REP_ZN_CD," ).append("\n"); 
		query.append("E.EQ_RTN_YD_CD," ).append("\n"); 
		query.append("E.LOC_AMS_PORT_CD, E.GMT_HRS," ).append("\n"); 
		query.append("E.PORT_INLND_CD, E.CALL_PORT_FLG , E.MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("FROM MDM_CONTINENT A, MDM_SUBCONTINENT B, MDM_COUNTRY C, MDM_REGION D, MDM_LOCATION E, MDM_STATE F, MDM_EQ_ORZ_CHT G" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${conti_code} != '')" ).append("\n"); 
		query.append("AND   E.CONTI_CD LIKE   @[conti_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${subconti_code} != '')" ).append("\n"); 
		query.append("AND   E.SCONTI_CD LIKE  @[subconti_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${country_code} != '')" ).append("\n"); 
		query.append("AND   E.CNT_CD LIKE     @[country_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${region_code} != '')" ).append("\n"); 
		query.append("AND   E.RGN_CD LIKE     @[region_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${location_code} != '')" ).append("\n"); 
		query.append("AND   E.LOC_CD LIKE     @[location_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   E.CONTI_CD = A.CONTI_CD (+)" ).append("\n"); 
		query.append("AND   E.SCONTI_CD = B.SCONTI_CD (+)" ).append("\n"); 
		query.append("AND   E.CNT_CD = C.CNT_CD (+)" ).append("\n"); 
		query.append("AND   E.RGN_CD = D.RGN_CD (+)" ).append("\n"); 
		query.append("AND   E.STE_CD = F.STE_CD(+)" ).append("\n"); 
		query.append("AND   E.CNT_CD = F.CNT_CD(+)" ).append("\n"); 
		query.append("AND   E.SCC_CD = G.SCC_CD(+)" ).append("\n"); 
		query.append("AND   NVL(A.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   NVL(C.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   NVL(D.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   NVL(E.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   NVL(F.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND   NVL(G.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}