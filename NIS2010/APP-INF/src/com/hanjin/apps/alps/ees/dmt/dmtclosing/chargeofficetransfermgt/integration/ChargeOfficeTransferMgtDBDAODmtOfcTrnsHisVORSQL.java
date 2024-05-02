/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeOfficeTransferMgtDBDAODmtOfcTrnsHisVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.08.12 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeOfficeTransferMgtDBDAODmtOfcTrnsHisVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeOfficeTransferMgtDBDAOOfficeTransferParmVORSQL.Query
	  * </pre>
	  */
	public ChargeOfficeTransferMgtDBDAODmtOfcTrnsHisVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration").append("\n"); 
		query.append("FileName : ChargeOfficeTransferMgtDBDAODmtOfcTrnsHisVORSQL").append("\n"); 
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
		query.append("SELECT	 --OT.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("		DCC.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("		,OT.CNTR_NO" ).append("\n"); 
		query.append("        ,OT.CNTR_CYC_NO" ).append("\n"); 
		query.append("        ,OT.DMDT_TRF_CD" ).append("\n"); 
		query.append("        ,OT.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        ,OT.CHG_SEQ" ).append("\n"); 
		query.append("        ,OT.FM_OFC_CD" ).append("\n"); 
		query.append("        ,OT.TO_OFC_CD" ).append("\n"); 
		query.append("        ,OT.TRNS_RSN" ).append("\n"); 
		query.append("        ,DCC.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        ,DECODE(OT.CHG_SEQ, 1, 'G', 'B') AS CHG_TYPE" ).append("\n"); 
		query.append("        ,DCB.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,DCB.BKG_NO" ).append("\n"); 
		query.append("        ,DCB.BL_NO" ).append("\n"); 
		query.append("        ,DCB.VSL_CD||DCB.SKD_VOY_NO||DCB.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("        ,DCB.POR_CD" ).append("\n"); 
		query.append("        ,DCB.POL_CD" ).append("\n"); 
		query.append("        ,DCB.POD_CD" ).append("\n"); 
		query.append("        ,DCB.DEL_CD" ).append("\n"); 
		query.append("        --,FS.SYS_AREA_GRP_ID AS FM_SVR_ID			/*	From Server ID	*/" ).append("\n"); 
		query.append("        --,TS.SYS_AREA_GRP_ID	AS TO_SVR_ID			/*	To Server ID	*/" ).append("\n"); 
		query.append("        ,TO_CHAR(OT.CRE_DT, 'YYYYMMDD') AS CRE_DT	/*	OFC Trans Date	*/" ).append("\n"); 
		query.append("        ,OT.CRE_OFC_CD" ).append("\n"); 
		query.append("        ,(SELECT CU.USR_NM" ).append("\n"); 
		query.append("         FROM COM_USER CU" ).append("\n"); 
		query.append("         WHERE CU.USR_ID = OT.CRE_USR_ID) AS USR_NM" ).append("\n"); 
		query.append("		,DCC.OFC_RHQ_CD" ).append("\n"); 
		query.append("		,DCC.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("		,DCC.BIL_AMT" ).append("\n"); 
		query.append("		,'' OFC_TRNS_SEQ" ).append("\n"); 
		query.append("		,'' CRE_USR_ID" ).append("\n"); 
		query.append("		,IM.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("		,'' ORG_CHG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM     DMT_OFC_TRNS_HIS    OT" ).append("\n"); 
		query.append("        ,MDM_ORGANIZATION    F" ).append("\n"); 
		query.append("        ,MDM_ORGANIZATION    T" ).append("\n"); 
		query.append("        ,COM_SYS_AREA_GRP_ID FS" ).append("\n"); 
		query.append("        ,COM_SYS_AREA_GRP_ID TS" ).append("\n"); 
		query.append("        ,DMT_CHG_CALC        DCC" ).append("\n"); 
		query.append("        ,DMT_CHG_BKG_CNTR    DCB" ).append("\n"); 
		query.append("		,DMT_INV_MN			 IM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'date')" ).append("\n"); 
		query.append("        AND OT.CRE_DT BETWEEN TO_DATE(REPLACE(@[fm_cre_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[to_cre_dt],'-',''), 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${fm_ofc_cd} == '' && ${to_ofc_cd} == '')" ).append("\n"); 
		query.append("		#if (${fm_rhq} == 'NYCRA')" ).append("\n"); 
		query.append("			AND (FS.SYS_AREA_GRP_ID = 'USA' OR TS.SYS_AREA_GRP_ID = 'USA')" ).append("\n"); 
		query.append("		#elseif (${fm_rhq} == 'HAMRU')" ).append("\n"); 
		query.append("			AND (FS.SYS_AREA_GRP_ID = 'EUR' OR TS.SYS_AREA_GRP_ID = 'EUR')" ).append("\n"); 
		query.append("		#elseif (${fm_rhq} == 'SHARC')" ).append("\n"); 
		query.append("			AND (FS.SYS_AREA_GRP_ID IN ('CHN', 'KOR') OR TS.SYS_AREA_GRP_ID IN ('CHN', 'KOR'))" ).append("\n"); 
		query.append("		#elseif (${fm_rhq} == 'SINRS')" ).append("\n"); 
		query.append("			AND (FS.SYS_AREA_GRP_ID = 'SWA' OR TS.SYS_AREA_GRP_ID = 'SWA')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${fm_ofc_cd} != '')" ).append("\n"); 
		query.append("			AND	OT.FM_OFC_CD = NVL(@[fm_ofc_cd], OT.FM_OFC_CD)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if (${to_ofc_cd} != '')" ).append("\n"); 
		query.append("			AND	OT.TO_OFC_CD = NVL(@[to_ofc_cd], OT.TO_OFC_CD)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("	AND		OT.DMDT_TRF_CD	IN (" ).append("\n"); 
		query.append("			#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     OT.FM_OFC_CD			= F.OFC_CD" ).append("\n"); 
		query.append("AND     FS.CNT_CD   			= SUBSTR(F.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("AND     FS.CO_IND_CD			= 'H'" ).append("\n"); 
		query.append("AND     OT.TO_OFC_CD			= T.OFC_CD" ).append("\n"); 
		query.append("AND     TS.CNT_CD   			= SUBSTR(T.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("AND     TS.CO_IND_CD			= 'H'" ).append("\n"); 
		query.append("AND     OT.SYS_AREA_GRP_ID   	= FS.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("--AND     OT.SYS_AREA_GRP_ID   	= DCC.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("AND	    OT.CNTR_NO	    		= DCC.CNTR_NO" ).append("\n"); 
		query.append("AND     OT.CNTR_CYC_NO			= DCC.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     OT.DMDT_TRF_CD			= DCC.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND     OT.DMDT_CHG_LOC_DIV_CD  = DCC.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND     OT.CHG_SEQ	    		= DCC.CHG_SEQ" ).append("\n"); 
		query.append("AND		DCC.DMDT_CHG_STS_CD		<> 'T'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     TS.SYS_AREA_GRP_ID	    = DCB.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     OT.CNTR_NO	    		= DCB.CNTR_NO" ).append("\n"); 
		query.append("AND     OT.CNTR_CYC_NO			= DCB.CNTR_CYC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND		DCC.DMDT_INV_NO			= IM.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'cntr')" ).append("\n"); 
		query.append("	#if (${bkg_no} != '')	" ).append("\n"); 
		query.append("	AND DCB.BKG_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bkg_no_list.size()) '$bkg_cd', #else '$bkg_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${bl_no} != '')" ).append("\n"); 
		query.append("	AND DCB.BL_NO IN (" ).append("\n"); 
		query.append("		#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $bl_no_list.size()) '$bl_cd', #else '$bl_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${cntr_no} != '')" ).append("\n"); 
		query.append("	AND DCB.CNTR_NO IN (" ).append("\n"); 
		query.append("		#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("			#if($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}