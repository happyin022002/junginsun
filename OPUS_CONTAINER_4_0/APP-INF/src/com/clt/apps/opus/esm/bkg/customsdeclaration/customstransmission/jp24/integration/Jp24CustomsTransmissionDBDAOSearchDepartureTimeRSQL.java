/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24CustomsTransmissionDBDAOSearchDepartureTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24CustomsTransmissionDBDAOSearchDepartureTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24CustomsTransmissionDBDAOSearchDepartureTimeRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.integration").append("\n"); 
		query.append("FileName : Jp24CustomsTransmissionDBDAOSearchDepartureTimeRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(V_SKD.VPS_ETD_DT, 'YYYY-MM-DD') AS ETD_DATE," ).append("\n"); 
		query.append("       TO_CHAR(V_SKD.VPS_ETD_DT, 'HH24:MI') AS ETD_TIME," ).append("\n"); 
		query.append("       DECODE(J_SKD.JO_CD1, 'Y', '1', '') AS RLX_DIV," ).append("\n"); 
		query.append("       DECODE(J_SKD.IB_CSSM_VOY_NO, '', V_SKD.IB_CSSM_VOY_NO, J_SKD.IB_CSSM_VOY_NO) AS IB_CSSM_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_VSL_SKD J_SKD," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD V_SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE J_SKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND J_SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND J_SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND J_SKD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   AND J_SKD.VSL_CD = V_SKD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND J_SKD.SKD_VOY_NO = V_SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND J_SKD.SKD_DIR_CD = V_SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND J_SKD.POL_CD = V_SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND V_SKD.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}