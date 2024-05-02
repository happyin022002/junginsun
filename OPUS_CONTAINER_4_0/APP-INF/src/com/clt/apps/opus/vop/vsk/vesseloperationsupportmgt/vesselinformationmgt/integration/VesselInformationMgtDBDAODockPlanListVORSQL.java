/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselInformationMgtDBDAODockPlanListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.01.18 장석현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAODockPlanListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public VesselInformationMgtDBDAODockPlanListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAODockPlanListVORSQL").append("\n"); 
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
		query.append("SELECT VSL_CD," ).append("\n"); 
		query.append("SCONTI_NM," ).append("\n"); 
		query.append("DCK_LOC_CD," ).append("\n"); 
		query.append("DCK_TGT_SKD," ).append("\n"); 
		query.append("DCK_FM_DT," ).append("\n"); 
		query.append("DCK_TO_DT," ).append("\n"); 
		query.append("FLET_DCK_SVEY_TP_CD," ).append("\n"); 
		query.append("FLET_DCK_STS_CD," ).append("\n"); 
		query.append("USR_ID as UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM   ( SELECT D.VSL_CD," ).append("\n"); 
		query.append("R.SCONTI_NM," ).append("\n"); 
		query.append("D.DCK_LOC_CD," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN MAX(TO_NUMBER(TO_CHAR(D.DCK_FM_DT,'MM'))) < 7" ).append("\n"); 
		query.append("THEN '1st Half Year'" ).append("\n"); 
		query.append("ELSE '2nd Half Year'" ).append("\n"); 
		query.append("END AS DCK_TGT_SKD," ).append("\n"); 
		query.append("MAX(TO_CHAR(D.DCK_FM_DT, 'YYYY-MM-DD')) DCK_FM_DT," ).append("\n"); 
		query.append("MAX(TO_CHAR(D.DCK_TO_DT, 'YYYY-MM-DD')) DCK_TO_DT," ).append("\n"); 
		query.append("CASE D.FLET_DCK_SVEY_TP_CD" ).append("\n"); 
		query.append("WHEN 'I' THEN 'Intermediate Class Survey'" ).append("\n"); 
		query.append("WHEN 'D' THEN 'Docking Survey'" ).append("\n"); 
		query.append("WHEN 'S' THEN 'Special Class Survey'" ).append("\n"); 
		query.append("WHEN 'P' THEN 'Propeller Shaft Survey'" ).append("\n"); 
		query.append("WHEN 'T' THEN 'Temporary Class Survey'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END AS FLET_DCK_SVEY_TP_CD," ).append("\n"); 
		query.append("CASE D.FLET_DCK_STS_CD" ).append("\n"); 
		query.append("WHEN 'C' THEN 'Completed'" ).append("\n"); 
		query.append("WHEN 'E' THEN 'Estimated'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END AS FLET_DCK_STS_CD," ).append("\n"); 
		query.append("MAX(D.UPD_USR_ID)                           USR_ID," ).append("\n"); 
		query.append("MAX(TO_CHAR(D.UPD_DT,'YYYY-MM-DD HH24:MI')) UPD_DT" ).append("\n"); 
		query.append("FROM   FMS_DCK_SKD D, MDM_LOCATION L, MDM_SUBCONTINENT R" ).append("\n"); 
		query.append("WHERE  TO_CHAR(D.DCK_FM_DT,'YYYY') = @[year]" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    D.VSL_CD                 LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    D.DCK_SEL_CD                = 'E'" ).append("\n"); 
		query.append("AND    D.DCK_LOC_CD                = L.LOC_CD(+)" ).append("\n"); 
		query.append("AND    L.SCONTI_CD                 = R.SCONTI_CD(+)" ).append("\n"); 
		query.append("GROUP BY D.VSL_CD, R.SCONTI_NM, D.DCK_LOC_CD, D.FLET_DCK_SVEY_TP_CD, D.FLET_DCK_STS_CD" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL(C.VSL_CD,NVL(E.VSL_CD,I.VSL_CD))                                        VSL_CD," ).append("\n"); 
		query.append("NVL(C.DCK_RGN,NVL(E.DCK_RGN,I.DCK_RGN))                                     SCONTI_NM," ).append("\n"); 
		query.append("NVL(C.DCK_PLC_DESC,NVL(E.DCK_PLC_DESC,I.DCK_PLC_DESC))                      DCK_LOC_CD," ).append("\n"); 
		query.append("NVL(C.DCK_TGT_SKD,NVL(E.DCK_TGT_SKD,I.DCK_TGT_SKD))                         DCK_TGT_SKD," ).append("\n"); 
		query.append("NVL(C.DCK_FM_DT,NVL(E.DCK_FM_DT,I.DCK_FM_DT))                               DCK_FM_DT," ).append("\n"); 
		query.append("NVL(C.DCK_TO_DT,NVL(E.DCK_TO_DT,I.DCK_TO_DT))                               DCK_TO_DT," ).append("\n"); 
		query.append("NVL(C.DCK_PLN_KND_DESC,NVL(E.DCK_PLN_KND_DESC,I.DCK_PLN_KND_DESC))          DCK_PLN_KND_DESC," ).append("\n"); 
		query.append("NVL(C.FLET_DCK_SVEY_TP_CD,NVL(E.FLET_DCK_SVEY_TP_CD,I.FLET_DCK_SVEY_TP_CD)) FLET_DCK_SVEY_TP_CD," ).append("\n"); 
		query.append("NVL(C.CRE_USR_ID,NVL(E.CRE_USR_ID,I.CRE_USR_ID))                            USR_ID," ).append("\n"); 
		query.append("NVL(C.UPD_DT,NVL(E.UPD_DT,I.UPD_DT))                                        UPD_DT" ).append("\n"); 
		query.append("FROM   ( SELECT VSL_CD," ).append("\n"); 
		query.append("NULL DCK_RGN," ).append("\n"); 
		query.append("DCK_PLC_DESC," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TO_NUMBER(TO_CHAR(DCK_FM_DT,'MM')) < 7" ).append("\n"); 
		query.append("THEN '1st Half Year'" ).append("\n"); 
		query.append("ELSE '2nd Half Year'" ).append("\n"); 
		query.append("END AS DCK_TGT_SKD," ).append("\n"); 
		query.append("TO_CHAR(DCK_FM_DT, 'YYYY-MM-DD') DCK_FM_DT," ).append("\n"); 
		query.append("TO_CHAR(DCK_TO_DT, 'YYYY-MM-DD') DCK_TO_DT," ).append("\n"); 
		query.append("DCK_PLN_KND_DESC," ).append("\n"); 
		query.append("'Initial Plan' FLET_DCK_SVEY_TP_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("FROM   VSK_DCK_PLN" ).append("\n"); 
		query.append("WHERE  TO_CHAR(DCK_FM_DT,'YYYY') = @[year]" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    VSL_CD                 LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    DCK_PLN_PROC_CD = 'I' ) I," ).append("\n"); 
		query.append("( SELECT VSL_CD," ).append("\n"); 
		query.append("NULL DCK_RGN," ).append("\n"); 
		query.append("DCK_PLC_DESC," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TO_NUMBER(TO_CHAR(DCK_FM_DT,'MM')) < 7" ).append("\n"); 
		query.append("THEN '1st Half Year'" ).append("\n"); 
		query.append("ELSE '2nd Half Year'" ).append("\n"); 
		query.append("END AS DCK_TGT_SKD," ).append("\n"); 
		query.append("TO_CHAR(DCK_FM_DT, 'YYYY-MM-DD') DCK_FM_DT," ).append("\n"); 
		query.append("TO_CHAR(DCK_TO_DT, 'YYYY-MM-DD') DCK_TO_DT," ).append("\n"); 
		query.append("DCK_PLN_KND_DESC," ).append("\n"); 
		query.append("'Execute Plan' FLET_DCK_SVEY_TP_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("FROM   VSK_DCK_PLN" ).append("\n"); 
		query.append("WHERE  TO_CHAR(DCK_FM_DT,'YYYY') = @[year]" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    VSL_CD                 LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    DCK_PLN_PROC_CD = 'E' ) E," ).append("\n"); 
		query.append("( SELECT VSL_CD," ).append("\n"); 
		query.append("NULL DCK_RGN," ).append("\n"); 
		query.append("DCK_PLC_DESC," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TO_NUMBER(TO_CHAR(DCK_FM_DT,'MM')) < 7" ).append("\n"); 
		query.append("THEN '1st Half Year'" ).append("\n"); 
		query.append("ELSE '2nd Half Year'" ).append("\n"); 
		query.append("END AS DCK_TGT_SKD," ).append("\n"); 
		query.append("TO_CHAR(DCK_FM_DT, 'YYYY-MM-DD') DCK_FM_DT," ).append("\n"); 
		query.append("TO_CHAR(DCK_TO_DT, 'YYYY-MM-DD') DCK_TO_DT," ).append("\n"); 
		query.append("DCK_PLN_KND_DESC," ).append("\n"); 
		query.append("'Completion' FLET_DCK_SVEY_TP_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("FROM   VSK_DCK_PLN" ).append("\n"); 
		query.append("WHERE  TO_CHAR(DCK_FM_DT,'YYYY') = @[year]" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND    VSL_CD                 LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    DCK_PLN_PROC_CD = 'C' ) C" ).append("\n"); 
		query.append("WHERE I.VSL_CD       = E.VSL_CD(+)" ).append("\n"); 
		query.append("AND   I.DCK_PLC_DESC = E.DCK_PLC_DESC(+)" ).append("\n"); 
		query.append("AND   I.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND   I.DCK_PLC_DESC = C.DCK_PLC_DESC(+) )" ).append("\n"); 
		query.append("ORDER BY VSL_CD, DCK_FM_DT, DCK_LOC_CD" ).append("\n"); 

	}
}