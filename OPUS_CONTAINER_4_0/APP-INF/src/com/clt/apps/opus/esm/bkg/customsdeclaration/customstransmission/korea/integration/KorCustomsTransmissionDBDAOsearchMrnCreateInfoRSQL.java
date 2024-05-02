/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchMrnCreateInfoRSQL").append("\n"); 
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
		query.append("#if(${mrn_yn} != 'N')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT NVL(MANI.MRN_NO, ' ') AS MRN_NO," ).append("\n"); 
		query.append("       NVL(MANI.MRN_CHK_NO, ' ') AS MRN_CHK_NO," ).append("\n"); 
		query.append("       NVL(MANI.PORT_CD, ' ') AS PORT_CD," ).append("\n"); 
		query.append("       NVL(MANI.IO_BND_CD, ' ') AS IO_BND_CD," ).append("\n"); 
		query.append("       NVL(MANI.VSL_CD, ' ') AS VSL_CD," ).append("\n"); 
		query.append("       NVL(MANI.SKD_VOY_NO, ' ') AS SKD_VOY_NO," ).append("\n"); 
		query.append("       NVL(MANI.SKD_DIR_CD, ' ') AS SKD_DIR_CD," ).append("\n"); 
		query.append("       NVL(VSL.SLAN_CD, ' ') AS LANE," ).append("\n"); 
		query.append("       NVL(MANI.VSL_CD, ' ') || NVL(MANI.SKD_VOY_NO, ' ') || NVL(MANI.SKD_DIR_CD, ' ') AS VVD," ).append("\n"); 
		query.append("       NVL(V.CALL_SGN_NO, ' ') AS CALL_SGN_NO," ).append("\n"); 
		query.append("       NVL(TO_CHAR(VSL.VPS_ETA_DT, 'YYYY-MM-DD'), ' ') AS VPS_ETA_DT," ).append("\n"); 
		query.append("       NVL(TO_CHAR(VSL.VPS_ETD_DT, 'YYYY-MM-DD'), ' ') AS VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_MF_REF_NO MANI," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD VSL," ).append("\n"); 
		query.append("       MDM_VSL_CNTR V" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE MANI.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("   AND MANI.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("   AND MANI.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND MANI.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VSL.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("   AND MANI.PORT_CD = VSL.VPS_PORT_CD" ).append("\n"); 
		query.append("   #if(${port_cd} != '')" ).append("\n"); 
		query.append("   AND MANI.PORT_CD LIKE @[port_cd]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${lane} != '')" ).append("\n"); 
		query.append("   AND VSL.SLAN_CD LIKE @[lane]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${io_bnd_cd} != '')" ).append("\n"); 
		query.append("   AND MANI.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${vvd} != '')" ).append("\n"); 
		query.append("   AND MANI.VSL_CD LIKE SUBSTR(@[vvd], 1, 4)||'%'" ).append("\n"); 
		query.append("   AND MANI.SKD_VOY_NO LIKE SUBSTR(@[vvd], 5, 4)||'%'" ).append("\n"); 
		query.append("   AND MANI.SKD_DIR_CD LIKE SUBSTR(@[vvd], 9, 1)||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${crr_cd} != 'H')" ).append("\n"); 
		query.append("   AND V.CRR_CD <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND V.CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${from_dt} != '')" ).append("\n"); 
		query.append("   AND VSL.VPS_ETA_DT > TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${to_dt} != '')" ).append("\n"); 
		query.append("   AND VSL.VPS_ETA_DT < TO_DATE(@[to_dt], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT '' AS MRN_NO," ).append("\n"); 
		query.append("       '' AS MRN_CHK_NO," ).append("\n"); 
		query.append("       @[port_cd] AS PORT_CD," ).append("\n"); 
		query.append("       @[io_bnd_cd] AS IO_BND_CD," ).append("\n"); 
		query.append("       VSL.VSL_CD," ).append("\n"); 
		query.append("       VSL.SKD_VOY_NO," ).append("\n"); 
		query.append("       VSL.SKD_DIR_CD," ).append("\n"); 
		query.append("       NVL(VSL.SLAN_CD, ' ') AS LANE," ).append("\n"); 
		query.append("       NVL(VSL.VSL_CD, ' ') || NVL(VSL.SKD_VOY_NO, ' ') || NVL(VSL.SKD_DIR_CD, ' ') AS VVD," ).append("\n"); 
		query.append("       NVL(V.CALL_SGN_NO, ' ') AS CALL_SGN_NO," ).append("\n"); 
		query.append("       NVL(TO_CHAR(VSL.VPS_ETA_DT, 'YYYY-MM-DD'), ' ') AS VPS_ETA_DT," ).append("\n"); 
		query.append("       NVL(TO_CHAR(VSL.VPS_ETD_DT, 'YYYY-MM-DD'), ' ') AS VPS_ETD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD VSL," ).append("\n"); 
		query.append("       MDM_VSL_CNTR V" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VSL.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("   AND V.VSL_CD =VSL.VSL_CD" ).append("\n"); 
		query.append("   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_KR_MF_REF_NO BCK" ).append("\n"); 
		query.append("                    WHERE BCK.VSL_CD = VSL.VSL_CD" ).append("\n"); 
		query.append("                      AND BCK.SKD_VOY_NO = VSL.SKD_VOY_NO" ).append("\n"); 
		query.append("                      AND BCK.SKD_DIR_CD = VSL.SKD_DIR_CD" ).append("\n"); 
		query.append("                      AND BCK.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                      AND BCK.IO_BND_CD = @[io_bnd_cd])" ).append("\n"); 
		query.append("   #if(${port_cd} != '')" ).append("\n"); 
		query.append("   AND VSL.VPS_PORT_CD LIKE @[port_cd]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${lane} != '')" ).append("\n"); 
		query.append("   AND VSL.SLAN_CD LIKE @[lane]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${crr_cd} != 'H')" ).append("\n"); 
		query.append("   AND V.CRR_CD <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("   #else" ).append("\n"); 
		query.append("   AND V.CRR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${vvd} != '')" ).append("\n"); 
		query.append("   AND VSL.VSL_CD LIKE SUBSTR(@[vvd], 1, 4)||'%'" ).append("\n"); 
		query.append("   AND VSL.SKD_VOY_NO LIKE SUBSTR(@[vvd], 5, 4)||'%'" ).append("\n"); 
		query.append("   AND VSL.SKD_DIR_CD LIKE SUBSTR(@[vvd], 9, 1)||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${from_dt} != '')" ).append("\n"); 
		query.append("   AND VSL.VPS_ETA_DT > TO_DATE(@[from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if(${to_dt} != '')" ).append("\n"); 
		query.append("   AND VSL.VPS_ETA_DT < TO_DATE(@[to_dt], 'YYYY-MM-DD')+0.99999" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}