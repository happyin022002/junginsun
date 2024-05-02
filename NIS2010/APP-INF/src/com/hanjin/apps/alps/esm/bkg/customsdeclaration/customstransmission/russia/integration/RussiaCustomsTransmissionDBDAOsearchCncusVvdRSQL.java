/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOsearchCncusVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOsearchCncusVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCncusVvd
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOsearchCncusVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOsearchCncusVvdRSQL").append("\n"); 
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
		query.append("SELECT   VSL.VSL_ENG_NM                                         AS VSLFULLNAME         " ).append("\n"); 
		query.append("         ,VVD.VSL_CD VSLCD                   		           " ).append("\n"); 
		query.append("         ,VVD.SKD_VOY_NO VSLVOY                               " ).append("\n"); 
		query.append("         ,VVD.SKD_DIR_CD VSLDIR               " ).append("\n"); 
		query.append("        ,VSL.CALL_SGN_NO AS CALLSIGN            " ).append("\n"); 
		query.append("        ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, 'CNSHA'), 'YYYYMMDDHH24MISS') AS SENDDATE                     " ).append("\n"); 
		query.append("        ,'REP_PERSON'                          AS REP_PERSON    " ).append("\n"); 
		query.append("        ,LAST_POL.POL_CD                                       		AS POL                    " ).append("\n"); 
		query.append("        ,VVD.POD_CD             							AS POD" ).append("\n"); 
		query.append("        ,LAST_POL.LOC_NM                                          AS POLNAME                       " ).append("\n"); 
		query.append("        ,POD_LOC.LOC_NM          AS PODNAME" ).append("\n"); 
		query.append("        ,TO_CHAR(POL_SKD.VPS_ETD_DT, 'YYYYMMDDHH24MI')          AS POL_ETD " ).append("\n"); 
		query.append("        ,TO_CHAR(POD_SKD.VPS_ETD_DT, 'YYYYMMDDHH24MI')          AS POL_ETD " ).append("\n"); 
		query.append("        ,TO_CHAR(POL_SKD.VPS_ETA_DT, 'YYYYMMDD') AS POL_ETA         " ).append("\n"); 
		query.append("        ,TO_CHAR(POL_SKD.VPS_ETD_DT, 'YYYYMMDD') AS POL_ETD       " ).append("\n"); 
		query.append("        ,TO_CHAR(POD_SKD.VPS_ETA_DT, 'YYYYMMDD') AS POD_ETA      " ).append("\n"); 
		query.append("        ,TO_CHAR(POD_SKD.VPS_ETD_DT, 'YYYYMMDD') AS POD_ETD      " ).append("\n"); 
		query.append("        ,NVL(VSL.LLOYD_NO,'        ')         		AS IMO_NO                  " ).append("\n"); 
		query.append("        ,VVD.SLAN_CD                                AS LANE " ).append("\n"); 
		query.append("		,VSL_NEXT_PORT.VPS_PORT_CD				AS NPORT" ).append("\n"); 
		query.append("		,VSL_NEXT_PORT.NEXT_PORT_NM 			AS NPORT_NM" ).append("\n"); 
		query.append("        ,NVL((SELECT CRR_NM  FROM MDM_CARRIER X WHERE VSL.CRR_CD = X.CRR_CD),'') CRR_NM" ).append("\n"); 
		query.append("FROM   BKG_VVD VVD," ).append("\n"); 
		query.append("        MDM_VSL_CNTR VSL," ).append("\n"); 
		query.append("          MDM_LOCATION POL_LOC, " ).append("\n"); 
		query.append("          MDM_LOCATION POD_LOC," ).append("\n"); 
		query.append("          VSK_VSL_PORT_SKD POL_SKD," ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD POD_SKD," ).append("\n"); 
		query.append("        (		" ).append("\n"); 
		query.append("         		SELECT 	CUR_PORT.VSL_CD , CUR_PORT.SKD_VOY_NO , CUR_PORT.SKD_DIR_CD " ).append("\n"); 
		query.append("		       ,NEXT_PORT.VPS_PORT_CD" ).append("\n"); 
		query.append("		        ,NVL((SELECT LOC_NM FROM MDM_LOCATION X WHERE X.LOC_CD = NEXT_PORT.VPS_PORT_CD ),'') NEXT_PORT_NM" ).append("\n"); 
		query.append("		FROM VSK_VSL_PORT_SKD CUR_PORT" ).append("\n"); 
		query.append("		    ,VSK_VSL_PORT_SKD NEXT_PORT" ).append("\n"); 
		query.append("		WHERE CUR_PORT.VSL_CD = SUBSTR(@[vvd_cd],1,4)  " ).append("\n"); 
		query.append("		AND CUR_PORT.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("		AND CUR_PORT.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)  " ).append("\n"); 
		query.append("		#if ( ${mode_type} == 'I' ) " ).append("\n"); 
		query.append("		AND CUR_PORT.VPS_PORT_CD   =    @[pod_cd]" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND CUR_PORT.VPS_PORT_CD   =    @[pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND NVL(CUR_PORT.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND CUR_PORT.VSL_CD = NEXT_PORT.VSL_CD(+)   " ).append("\n"); 
		query.append("		AND CUR_PORT.SKD_VOY_NO = NEXT_PORT.SKD_VOY_NO(+)  " ).append("\n"); 
		query.append("		AND CUR_PORT.SKD_DIR_CD = NEXT_PORT.SKD_DIR_CD(+)    " ).append("\n"); 
		query.append("		AND NVL(NEXT_PORT.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("		AND NEXT_PORT.CLPT_SEQ(+) = CUR_PORT.CLPT_SEQ + 1" ).append("\n"); 
		query.append("		AND ROWNUM               =         1" ).append("\n"); 
		query.append("        ) VSL_NEXT_PORT" ).append("\n"); 
		query.append("	," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT VPS_PORT_CD POL_CD,V.VSL_CD, V.SKD_VOY_NO, V.SKD_DIR_CD, MDM.LOC_NM" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V, MDM_LOCATION MDM" ).append("\n"); 
		query.append("WHERE  V.VPS_PORT_CD = MDM.LOC_CD" ).append("\n"); 
		query.append("AND V.VSL_CD = SUBSTR(@[vvd_cd],1, 4)" ).append("\n"); 
		query.append("	AND V.SKD_VOY_NO = SUBSTR(@[vvd_cd],5, 4)" ).append("\n"); 
		query.append("	AND V.SKD_DIR_CD = SUBSTR(@[vvd_cd],9, 1)" ).append("\n"); 
		query.append("     AND NVL(V.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("	AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("    AND CLPT_SEQ  = (" ).append("\n"); 
		query.append("SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE   V.VSL_CD = SUBSTR(@[vvd_cd],1, 4)" ).append("\n"); 
		query.append("	AND V.SKD_VOY_NO = SUBSTR(@[vvd_cd],5, 4)" ).append("\n"); 
		query.append("	AND V.SKD_DIR_CD = SUBSTR(@[vvd_cd],9, 1)" ).append("\n"); 
		query.append("     AND NVL(V.SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("	AND V.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("	AND V.CLPT_SEQ < (" ).append("\n"); 
		query.append("                    SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                    FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("                    AND VSL_CD      = SUBSTR(@[vvd_cd],1, 4)" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO  = SUBSTR(@[vvd_cd],5, 4)" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD  = SUBSTR(@[vvd_cd],9, 1)" ).append("\n"); 
		query.append("                    AND NVL(SKD_CNG_STS_CD, 'X') != 'S'" ).append("\n"); 
		query.append("                    AND VPS_PORT_CD LIKE 'RU%'" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") LAST_POL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE  VVD.VSL_CD       =   VSL.VSL_CD" ).append("\n"); 
		query.append("AND     VVD.POL_CD      = POL_LOC.LOC_CD" ).append("\n"); 
		query.append("AND     VVD.POD_CD      = POD_LOC.LOC_CD" ).append("\n"); 
		query.append("AND     VVD.VSL_CD      = POL_SKD.VSL_CD" ).append("\n"); 
		query.append("AND     VVD.SKD_VOY_NO  = POL_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     VVD.SKD_DIR_CD  = POL_SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     VVD.POL_CD      = POL_SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     VVD.VSL_CD      = POD_SKD.VSL_CD" ).append("\n"); 
		query.append("AND     VVD.SKD_VOY_NO  = POD_SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     VVD.SKD_DIR_CD  = POD_SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     VVD.POD_CD      = POD_SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("AND     VVD.VSL_CD      = VSL_NEXT_PORT.VSL_CD" ).append("\n"); 
		query.append("AND     VVD.SKD_VOY_NO  = VSL_NEXT_PORT.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     VVD.SKD_DIR_CD  = VSL_NEXT_PORT.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	VVD.VSL_CD = LAST_POL.VSL_CD" ).append("\n"); 
		query.append("AND 	VVD.SKD_VOY_NO =LAST_POL.SKD_VOY_NO " ).append("\n"); 
		query.append("AND 	VVD.SKD_DIR_CD = LAST_POL.SKD_DIR_CD    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     VVD.VSL_CD                 =         SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND         VVD.SKD_VOY_NO     =         SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND         VVD.SKD_DIR_CD   = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${mode_type} == 'I' ) " ).append("\n"); 
		query.append("AND         VVD.POD_CD            =         @[pod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND         VVD.POL_CD            =         @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND         ROWNUM               =         1" ).append("\n"); 

	}
}