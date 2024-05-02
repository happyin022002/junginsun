/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchVesselEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchVesselEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, transmitStowageManifest 내부 메서드.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchVesselEtaRSQL(){
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
		params.put("lastpol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchVesselEtaRSQL").append("\n"); 
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
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, 'USNYC'), 'YYMMDDHH24MI') CURRDATE," ).append("\n"); 
		query.append("  VPS.VSL_CD ," ).append("\n"); 
		query.append("  VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("  VPS.SKD_DIR_CD," ).append("\n"); 
		query.append("  V.CALL_SGN_NO," ).append("\n"); 
		query.append("  V.LLOYD_NO," ).append("\n"); 
		query.append("  V.VSL_ENG_NM," ).append("\n"); 
		query.append("  NVL( DECODE( VL1.UN_LOC_IND_CD, 'Y', VL1.LOC_CD, VL1.UN_LOC_CD) , VPS.VPS_PORT_CD ) VPS_PORT_CD," ).append("\n"); 
		query.append("  TO_CHAR(VPS.VPS_ETA_DT, 'YYMMDDHH24MI') VPS_ETA_DT," ).append("\n"); 
		query.append("  TO_CHAR(VPS.VPS_ETD_DT, 'YYMMDDHH24MI') VPS_ETD_DT," ).append("\n"); 
		query.append("  NVL( DECODE( VL2.UN_LOC_IND_CD, 'Y', VL2.LOC_CD, VL2.UN_LOC_CD) , VPS2.VPS_PORT_CD ) US_PORT_CD," ).append("\n"); 
		query.append("  TO_CHAR(VPS2.VPS_ETA_DT, 'YYMMDDHH24MI') US_ETA_DT" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD VPS, MDM_VSL_CNTR V, VSK_VSL_PORT_SKD VPS2, MDM_LOCATION VL1,MDM_LOCATION VL2" ).append("\n"); 
		query.append("WHERE VPS.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  AND VPS.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("  AND VPS.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("  AND VPS.VPS_PORT_CD = @[lastpol]" ).append("\n"); 
		query.append("  AND NVL(VPS.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("  AND VPS.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("  AND VPS.VSL_CD = VPS2.VSL_CD" ).append("\n"); 
		query.append("  AND VPS.SKD_VOY_NO = VPS2.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND VPS.SKD_DIR_CD = VPS2.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND VPS2.CLPT_SEQ > VPS.CLPT_SEQ" ).append("\n"); 
		query.append("  AND VPS2.CLPT_IND_SEQ > 0" ).append("\n"); 
		query.append("  AND VPS2.VPS_PORT_CD LIKE 'US%'" ).append("\n"); 
		query.append("  AND NVL(VPS2.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("  AND VPS.VPS_PORT_CD = VL1.LOC_CD(+)" ).append("\n"); 
		query.append("  AND VPS2.VPS_PORT_CD = VL2.LOC_CD(+)" ).append("\n"); 
		query.append("ORDER BY VPS2.VPS_ETA_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}