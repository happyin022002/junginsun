/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CimCommonDBODAOscarVesselInformationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.06.16 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CimCommonDBODAOscarVesselInformationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Information 리스트 정보
	  * </pre>
	  */
	public CimCommonDBODAOscarVesselInformationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration").append("\n"); 
		query.append("FileName : CimCommonDBODAOscarVesselInformationListRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("       COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD01233', BV.VSL_PRE_PST_CD)     AS VSL_PRE_PST_CD" ).append("\n"); 
		query.append("    , BV.SLAN_CD                                    AS VSL_SLAN_CD" ).append("\n"); 
		query.append("    , BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD         AS VSL_VVD" ).append("\n"); 
		query.append("    , BV.POL_YD_CD                                    AS VSL_POL_YD_CD" ).append("\n"); 
		query.append("    , (SELECT TO_CHAR(VPS.VPS_ETD_DT,'YYYY-MM-DD HH24:MI','NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("       WHERE BV.VSL_CD        = VPS.VSL_CD" ).append("\n"); 
		query.append("       AND    BV.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND    BV.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND    BV.POL_YD_CD    = VPS.YD_CD" ).append("\n"); 
		query.append("       AND    ROWNUM          = 1" ).append("\n"); 
		query.append("      )                                                  AS VSL_ETD" ).append("\n"); 
		query.append("    , BV.POD_YD_CD                                    AS VSL_POD_YD_CD" ).append("\n"); 
		query.append("    , (SELECT TO_CHAR(VPS.VPS_ETB_DT,'YYYY-MM-DD HH24:MI','NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("       WHERE BV.VSL_CD        = VPS.VSL_CD" ).append("\n"); 
		query.append("       AND    BV.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND    BV.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND    BV.POD_YD_CD    = VPS.YD_CD" ).append("\n"); 
		query.append("       AND    ROWNUM          = 1" ).append("\n"); 
		query.append("      )                                                    AS VSL_ETB" ).append("\n"); 
		query.append("    , TO_CHAR(BV.OSCA_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')  AS VSL_OSCA_CRE_DT" ).append("\n"); 
		query.append("    , TO_CHAR(BV.OSCA_UPD_DT, 'YYYY.MM.DD HH24:MI:SS')  AS VSL_OSCA_UPD_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("	CIM_BKG_VVD_V BV" ).append("\n"); 
		query.append("WHERE BV.BKG_NO = @[h_bkg_no]" ).append("\n"); 
		query.append("ORDER BY DECODE(BV.VSL_PRE_PST_CD, 'S', 1, 'T', 2, 'U', 3) , VSL_SEQ" ).append("\n"); 

	}
}