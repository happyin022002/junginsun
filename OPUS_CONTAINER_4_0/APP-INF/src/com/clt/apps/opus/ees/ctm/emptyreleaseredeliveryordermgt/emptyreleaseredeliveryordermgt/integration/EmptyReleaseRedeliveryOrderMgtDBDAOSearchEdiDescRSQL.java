/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2014.12.02 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI에 필요한 각종 Description 정보를 조회한다
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiDescRSQL").append("\n"); 
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
		query.append("SELECT YD.YD_NM MTY_CY_DESC" ).append("\n"); 
		query.append("  	  ,VSL.CALL_SGN_NO VSL_CALL" ).append("\n"); 
		query.append("      ,VSL.VSL_ENG_NM VSL_NAME" ).append("\n"); 
		query.append("      ,POL.LOC_NM POL_DESC" ).append("\n"); 
		query.append("      ,POD.LOC_NM POD_DESC" ).append("\n"); 
		query.append("	  ,ETD.VPS_ETD_DT VVD_ETD" ).append("\n"); 
		query.append("      ,ETA.VPS_ETA_DT VVD_ETA" ).append("\n"); 
		query.append("      ,YD.LOC_CD EQREL_LOC" ).append("\n"); 
		query.append("      ,YD.LOC_NM EQREL_NAME" ).append("\n"); 
		query.append("      ,VSL.LLOYD_NO VSL_LOYD" ).append("\n"); 
		query.append("      ,ETD.CONSORT_VOY_O CONSORT_VOY_O" ).append("\n"); 
		query.append("      ,ETA.CONSORT_VOY_I CONSORT_VOY_I" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT Y.YD_NM, L.LOC_CD, L.LOC_NM" ).append("\n"); 
		query.append("         FROM MDM_YARD Y" ).append("\n"); 
		query.append("             ,MDM_LOCATION L" ).append("\n"); 
		query.append("        WHERE Y.YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("          AND Y.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("       ) YD" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("       SELECT CALL_SGN_NO" ).append("\n"); 
		query.append("             ,VSL_ENG_NM" ).append("\n"); 
		query.append("             ,LLOYD_NO" ).append("\n"); 
		query.append("         FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("       ) VSL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("       SELECT ' ' AS CALL_SGN_NO" ).append("\n"); 
		query.append("             ,' ' AS VSL_ENG_NM" ).append("\n"); 
		query.append("             ,' ' AS LLOYD_NO" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("       ) VSL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol} != '')" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("       SELECT LOC_NM" ).append("\n"); 
		query.append("         FROM MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE LOC_CD = @[pol]" ).append("\n"); 
		query.append("       ) POL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("       SELECT ' ' AS LOC_NM" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("       ) POL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod} != '')" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("       SELECT LOC_NM" ).append("\n"); 
		query.append("         FROM MDM_LOCATION" ).append("\n"); 
		query.append("        WHERE LOC_CD = @[pod]" ).append("\n"); 
		query.append("       ) POD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("       SELECT ' ' AS LOC_NM" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("       ) POD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '' && ${pol} != '')" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("       SELECT TO_CHAR(VPS_ETD_DT, 'YYYYMMDDHHMM') VPS_ETD_DT" ).append("\n"); 
		query.append("             ,OB_CSSM_VOY_NO CONSORT_VOY_O" ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND VPS_PORT_CD = @[pol]" ).append("\n"); 
		query.append("       ) ETD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("       SELECT ' ' AS VPS_ETD_DT" ).append("\n"); 
		query.append("             ,' ' AS CONSORT_VOY_O" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("       ) ETD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '' && ${pod} != '')" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("       SELECT TO_CHAR(VPS_ETA_DT, 'YYYYMMDDHHMM') VPS_ETA_DT" ).append("\n"); 
		query.append("             ,IB_CSSM_VOY_NO CONSORT_VOY_I" ).append("\n"); 
		query.append("         FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND VPS_PORT_CD = @[pod]" ).append("\n"); 
		query.append("       ) ETA" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  ,(" ).append("\n"); 
		query.append("       SELECT ' ' AS VPS_ETA_DT" ).append("\n"); 
		query.append("             ,' ' AS CONSORT_VOY_I" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("       ) ETA" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}