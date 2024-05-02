/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOSearchDwellReasonByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOSearchDwellReasonByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dwell Reason 입력 내역을 조회한다.
	  * </pre>
	  */
	public DwellNotificationDBDAOSearchDwellReasonByVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOSearchDwellReasonByVVDRSQL").append("\n"); 
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
		query.append("R.DWLL_RSN_SEQ" ).append("\n"); 
		query.append(", V.SLAN_CD" ).append("\n"); 
		query.append(", V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", TO_CHAR(V.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS') ETA_DT" ).append("\n"); 
		query.append(", TO_CHAR(V.INIT_ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD_DT" ).append("\n"); 
		query.append(", R.DWLL_RSN" ).append("\n"); 
		query.append(", TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', R.UPD_DT, 'USNYC'), 'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append(", R.UPD_USR_ID" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER U WHERE U.USR_ID = R.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append(", R.UPD_OFC_CD" ).append("\n"); 
		query.append(", V.VPS_PORT_CD" ).append("\n"); 
		query.append(", '' UPD_USR_ID1" ).append("\n"); 
		query.append(", '' UPD_OFC_CD1" ).append("\n"); 
		query.append(", '' UPD_USR_NM1" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append(", SCE_DWLL_RSN R" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) = ((SUBSTR(@[vvd_cd], 1,4), SUBSTR(@[vvd_cd], 5,4), SUBSTR(@[vvd_cd], 9)))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fr_eta_dt} != '' && ${to_eta_dt} != '' )" ).append("\n"); 
		query.append("AND V.VPS_ETA_DT BETWEEN TO_DATE(@[fr_eta_dt] , 'YYYYMMDD') AND TO_DATE(@[to_eta_dt] , 'YYYYMMDD')+0.9999999999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X' FROM SCE_COP_DTL D WHERE 1=1" ).append("\n"); 
		query.append("AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) = ((D.VSL_CD,D.SKD_VOY_NO,D.SKD_DIR_CD))" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = D.VPS_PORT_CD" ).append("\n"); 
		query.append("AND V.CLPT_IND_SEQ = D.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND D.ACT_CD LIKE ('FU_MAD')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND (V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD) = ((R.VSL_CD(+),R.SKD_VOY_NO(+),R.SKD_DIR_CD(+)))" ).append("\n"); 
		query.append("ORDER BY V.VPS_ETA_DT" ).append("\n"); 

	}
}