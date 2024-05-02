/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaCncusVvdVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL(){
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusVvdRSQL").append("\n"); 
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
		query.append("SELECT SV.VSL_NM AS VSL_FULL_NAME," ).append("\n"); 
		query.append("#if (${trans_mode} == 'P')" ).append("\n"); 
		query.append("       NVL(CV.OB_VSL_NM, SUBSTR(@[vvd], 1, 4)) AS VSL_CD," ).append("\n"); 
		query.append("       NVL(CV.OB_SKD_VOY_NO, SUBSTR(@[vvd], 5, 4)) AS VSL_VOY," ).append("\n"); 
		query.append("       NVL(CV.OB_SKD_DIR_NM, SUBSTR(@[vvd], 9, 1)) AS VSL_DIR," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       NVL(CV.IB_VSL_NM, SUBSTR(@[vvd], 1, 4)) AS VSL_CD," ).append("\n"); 
		query.append("       NVL(CV.IB_SKD_VOY_NO, SUBSTR(@[vvd], 5, 4)) AS VSL_VOY," ).append("\n"); 
		query.append("       NVL(CV.IB_SKD_DIR_NM, SUBSTR(@[vvd], 9, 1)) AS VSL_DIR," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       SV.CALL_SGN_NO AS CALL_SIGN," ).append("\n"); 
		query.append("       TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'CNSHA'), 'YYYYMMDDHH24MISS') AS SEND_DATE," ).append("\n"); 
		query.append("       '530400000003' AS REP_PERSON," ).append("\n"); 
		query.append("       L3.LOC_CD AS ORG_PORT," ).append("\n"); 
		query.append("       L3.LOC_NM AS ORG_PORT_NAME," ).append("\n"); 
		query.append("       TO_CHAR(SV.ETD_DT, 'YYYYMMDDHH24MI') AS POL_ETD," ).append("\n"); 
		query.append("       SV.PRE_CLPT_CD AS P_PORT," ).append("\n"); 
		query.append("       L1.LOC_NM AS P_PORT_NAME," ).append("\n"); 
		query.append("       TRIM(SV.NXT_CLPT_CD) AS N_PORT," ).append("\n"); 
		query.append("       L2.LOC_NM AS N_PORT_NAME," ).append("\n"); 
		query.append("       TO_CHAR(SV.ETA_DT, 'YYYYMMDD') AS ETA," ).append("\n"); 
		query.append("       TO_CHAR(SV.ETD_DT, 'YYYYMMDD') AS ETD," ).append("\n"); 
		query.append("       NVL(SV.LLOYD_NO, '	') AS IMO_NO," ).append("\n"); 
		query.append("       SV.SLAN_CD AS LANE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CHN_VVD SV," ).append("\n"); 
		query.append("       MDM_LOCATION L1," ).append("\n"); 
		query.append("       MDM_LOCATION L2," ).append("\n"); 
		query.append("       MDM_LOCATION L3," ).append("\n"); 
		query.append("       BKG_CSTMS_CHN_CORR_VVD CV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE SV.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND SV.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SV.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("#if (${trans_mode} == 'D')" ).append("\n"); 
		query.append("   AND SV.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SV.PORT_CD = @[pol]   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND SV.VSL_CD = CV.VSL_CD(+)" ).append("\n"); 
		query.append("   AND SV.SKD_VOY_NO = CV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND SV.SKD_DIR_CD = CV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("#if (${trans_mode} == 'D')" ).append("\n"); 
		query.append("   AND SV.CHN_MF_SND_IND_CD = 'R'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SV.CHN_MF_SND_IND_CD = @[trans_mode]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("   AND L1.LOC_CD(+) = SV.PRE_CLPT_CD" ).append("\n"); 
		query.append("   AND L2.LOC_CD(+) = SV.NXT_CLPT_CD" ).append("\n"); 
		query.append("   AND L3.LOC_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}