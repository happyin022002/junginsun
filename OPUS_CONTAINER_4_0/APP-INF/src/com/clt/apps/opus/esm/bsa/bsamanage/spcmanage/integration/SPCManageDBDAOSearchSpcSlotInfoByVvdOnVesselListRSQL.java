/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SPCManageDBDAOSearchSpcSlotInfoByVvdOnVesselListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCManageDBDAOSearchSpcSlotInfoByVvdOnVesselListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Solt Information By VVD For Vessels 조회 쿼리
	  * </pre>
	  */
	public SPCManageDBDAOSearchSpcSlotInfoByVvdOnVesselListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmmonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtdir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttomonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtskd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coblane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtyear",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txttoweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobdir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobioc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtfmweek",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cobtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("txtvsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bsa.bsamanage.spcmanage.integration").append("\n"); 
		query.append("FileName : SPCManageDBDAOSearchSpcSlotInfoByVvdOnVesselListRSQL").append("\n"); 
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
		query.append("SELECT   COST_YRWK" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,SLAN_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,VSL_LANE_TP_CD" ).append("\n"); 
		query.append("        ,VSL_CD" ).append("\n"); 
		query.append("        ,SKD_VOY_NO" ).append("\n"); 
		query.append("        ,SKD_DIR_CD" ).append("\n"); 
		query.append("        ,VOP_CD" ).append("\n"); 
		query.append("        ,BSA_CAPA" ).append("\n"); 
		query.append("        ,CRR_CD" ).append("\n"); 
		query.append("        ,MAX(BSA) BSA" ).append("\n"); 
		query.append("        ,MAX(WEIGHT_TEU) WEIGHT_TEU" ).append("\n"); 
		query.append("        ,MAX(WEIGHT_TTL) WEIGHT_TTL" ).append("\n"); 
		query.append("        ,MAX(RF) RF" ).append("\n"); 
		query.append("        ,MAX(D2) D2" ).append("\n"); 
		query.append("        ,MAX(D3) D3" ).append("\n"); 
		query.append("        ,MAX(D4) D4" ).append("\n"); 
		query.append("        ,MAX(D5) D5" ).append("\n"); 
		query.append("        ,MAX(D7) D7" ).append("\n"); 
		query.append("FROM (SELECT   			 " ).append("\n"); 
		query.append("		#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("			  SUBSTR(A.COST_YRMON,0,4) ||'-'|| A.COST_WK COST_YRWK 	" ).append("\n"); 
		query.append("		#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  			  SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK COST_YRWK   	" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("              ,C.TRD_CD" ).append("\n"); 
		query.append("              ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A.SLAN_CD" ).append("\n"); 
		query.append("              ,C.RLANE_CD" ).append("\n"); 
		query.append("              ,DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC') VSL_LANE_TP_CD" ).append("\n"); 
		query.append("              ,C.VSL_CD" ).append("\n"); 
		query.append("              ,C.SKD_VOY_NO" ).append("\n"); 
		query.append("              ,C.SKD_DIR_CD" ).append("\n"); 
		query.append("              ,C.VOP_CD" ).append("\n"); 
		query.append("              ,C.BSA_CAPA" ).append("\n"); 
		query.append("              ,D.CRR_CD" ).append("\n"); 
		query.append("              ,D.BSA_OP_JB_CD" ).append("\n"); 
		query.append("              ,D.CRR_BSA_CAPA BSA" ).append("\n"); 
		query.append("              ,0 WEIGHT_TEU" ).append("\n"); 
		query.append("              ,0 WEIGHT_TTL" ).append("\n"); 
		query.append("              ,0 RF" ).append("\n"); 
		query.append("              ,0 D2" ).append("\n"); 
		query.append("              ,0 D4" ).append("\n"); 
		query.append("              ,0 D5" ).append("\n"); 
		query.append("              ,0 D7" ).append("\n"); 
		query.append("              ,0 D3" ).append("\n"); 
		query.append("          FROM COA_MON_VVD A, " ).append("\n"); 
		query.append("               COA_LANE_RGST B, " ).append("\n"); 
		query.append("               BSA_VVD_MST C, " ).append("\n"); 
		query.append("               BSA_VVD_OTR_CRR D, " ).append("\n"); 
		query.append("               BSA_VVD_SWAP_INFO F" ).append("\n"); 
		query.append("         WHERE A.TRD_CD     = C.TRD_CD" ).append("\n"); 
		query.append("           AND A.RLANE_CD   = C.RLANE_CD" ).append("\n"); 
		query.append("           AND A.IOC_CD     = C.IOC_CD" ).append("\n"); 
		query.append("           AND A.VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A.DIR_CD     = C.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("           AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("           AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("           AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("           AND C.TRD_CD     = D.TRD_CD(+)" ).append("\n"); 
		query.append("           AND C.RLANE_CD   = D.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND C.VSL_CD     = D.VSL_CD(+)" ).append("\n"); 
		query.append("           AND C.SKD_VOY_NO = D.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND C.SKD_DIR_CD = D.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND D.TRD_CD     = F.TRD_CD(+)" ).append("\n"); 
		query.append("           AND D.RLANE_CD   = F.RLANE_CD(+)" ).append("\n"); 
		query.append("           AND D.VSL_CD     = F.VSL_CD(+)" ).append("\n"); 
		query.append("           AND D.SKD_VOY_NO = F.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND D.SKD_DIR_CD = F.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND D.CRR_CD     = F.CRR_CD(+)" ).append("\n"); 
		query.append("           AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("           AND D.BSA_OP_JB_CD(+) = '007'" ).append("\n"); 
		query.append("        #if (${chkprd} == 'M')" ).append("\n"); 
		query.append("           AND A.COST_YRMON BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
		query.append("        #elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("           AND A.SLS_YRMON LIKE @[txtyear] || '%'" ).append("\n"); 
		query.append("           AND A.COST_WK BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("        #end 	 " ).append("\n"); 
		query.append("        #if (${cobtrade} != '')" ).append("\n"); 
		query.append("           AND C.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${coblane} != '')" ).append("\n"); 
		query.append("           AND C.RLANE_CD = @[coblane] " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${cobdir} != '')" ).append("\n"); 
		query.append("           AND C.SKD_DIR_CD = @[cobdir] " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${cobioc} != '')" ).append("\n"); 
		query.append("           AND C.IOC_CD = @[cobioc] " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${txtvsl_cd} != '')" ).append("\n"); 
		query.append("           AND C.VSL_CD = @[txtvsl_cd] " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${txtskd_voy_no} != '')" ).append("\n"); 
		query.append("           AND C.SKD_VOY_NO = @[txtskd_voy_no] " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${txtdir_cd} != '')" ).append("\n"); 
		query.append("           AND C.SKD_DIR_CD = @[txtdir_cd] " ).append("\n"); 
		query.append("        #end      " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("       GROUP BY " ).append("\n"); 
		query.append("			#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("			    SUBSTR(A.COST_YRMON,0,4) ||'-'|| A.COST_WK	" ).append("\n"); 
		query.append("			#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  			    SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK	" ).append("\n"); 
		query.append("			#end				" ).append("\n"); 
		query.append("                ,C.TRD_CD" ).append("\n"); 
		query.append("                ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("                ,A.SLAN_CD" ).append("\n"); 
		query.append("                ,C.RLANE_CD" ).append("\n"); 
		query.append("                ,DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC')" ).append("\n"); 
		query.append("                ,C.VSL_CD" ).append("\n"); 
		query.append("                ,C.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,C.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,C.VOP_CD" ).append("\n"); 
		query.append("                ,C.BSA_CAPA" ).append("\n"); 
		query.append("                ,D.CRR_CD" ).append("\n"); 
		query.append("                ,D.BSA_OP_JB_CD" ).append("\n"); 
		query.append("                ,D.CRR_BSA_CAPA" ).append("\n"); 
		query.append("    #if (${isExcludZero} != '')	        	" ).append("\n"); 
		query.append("       HAVING NVL(CRR_BSA_CAPA, 0) > 0" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("			#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("			    SUBSTR(A.COST_YRMON,0,4) ||'-'|| A.COST_WK COST_YRWK 	" ).append("\n"); 
		query.append("			#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  			    SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK COST_YRWK   	" ).append("\n"); 
		query.append("			#end  				" ).append("\n"); 
		query.append("                ,C.TRD_CD" ).append("\n"); 
		query.append("                ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("                ,A.SLAN_CD" ).append("\n"); 
		query.append("                ,C.RLANE_CD" ).append("\n"); 
		query.append("                ,DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC') VSL_LANE_TP_CD" ).append("\n"); 
		query.append("                ,C.VSL_CD" ).append("\n"); 
		query.append("                ,C.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,C.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,C.VOP_CD" ).append("\n"); 
		query.append("                ,C.BSA_CAPA" ).append("\n"); 
		query.append("                ,D.CRR_CD" ).append("\n"); 
		query.append("                ,D.BSA_OP_JB_CD" ).append("\n"); 
		query.append("                ,0 BSA" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '008', D.CRR_BSA_CAPA, 0) WEIGHT_TEU" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '009', D.CRR_BSA_CAPA, 0) WEIGHT_TTL" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '010', D.CRR_BSA_CAPA, 0) RF" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '011', D.CRR_BSA_CAPA, 0) D2" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '012', D.CRR_BSA_CAPA, 0) D4" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '013', D.CRR_BSA_CAPA, 0) D5" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '014', D.CRR_BSA_CAPA, 0) D7" ).append("\n"); 
		query.append("                ,DECODE(D.BSA_OP_JB_CD, '022', D.CRR_BSA_CAPA, 0) D3" ).append("\n"); 
		query.append("            FROM COA_MON_VVD A, " ).append("\n"); 
		query.append("				 COA_LANE_RGST B, " ).append("\n"); 
		query.append("				 BSA_VVD_MST C, " ).append("\n"); 
		query.append("				 BSA_VVD_OTR_CRR D" ).append("\n"); 
		query.append("           WHERE A.TRD_CD 		= C.TRD_CD" ).append("\n"); 
		query.append("             AND A.RLANE_CD 	= C.RLANE_CD" ).append("\n"); 
		query.append("             AND A.IOC_CD 		= C.IOC_CD" ).append("\n"); 
		query.append("             AND A.VSL_CD 		= C.VSL_CD" ).append("\n"); 
		query.append("             AND A.SKD_VOY_NO 	= C.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND A.DIR_CD 		= C.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND A.TRD_CD 		= B.TRD_CD" ).append("\n"); 
		query.append("             AND A.RLANE_CD 	= B.RLANE_CD" ).append("\n"); 
		query.append("             AND A.DIR_CD 		= B.DIR_CD" ).append("\n"); 
		query.append("             AND A.IOC_CD 		= B.IOC_CD" ).append("\n"); 
		query.append("             AND C.TRD_CD 		= D.TRD_CD" ).append("\n"); 
		query.append("             AND C.RLANE_CD 	= D.RLANE_CD" ).append("\n"); 
		query.append("             AND C.VSL_CD 		= D.VSL_CD" ).append("\n"); 
		query.append("             AND C.SKD_VOY_NO 	= D.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND C.SKD_DIR_CD 	= D.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("             AND D.BSA_OP_JB_CD IN('008', '009', '010', '011', '012', '013', '014', '022')" ).append("\n"); 
		query.append("          #if (${chkprd} == 'M')" ).append("\n"); 
		query.append("             AND A.COST_YRMON BETWEEN @[txtyear]||@[txtfmmonth] AND @[txtyear]||@[txttomonth] " ).append("\n"); 
		query.append("          #elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("             AND A.SLS_YRMON LIKE @[txtyear] || '%'" ).append("\n"); 
		query.append("             AND A.COST_WK BETWEEN @[txtfmweek] AND @[txttoweek] " ).append("\n"); 
		query.append("          #end 	 " ).append("\n"); 
		query.append("          #if (${cobtrade} != '')" ).append("\n"); 
		query.append("             AND C.TRD_CD = @[cobtrade] " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${coblane} != '')" ).append("\n"); 
		query.append("             AND C.RLANE_CD = @[coblane] " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${cobdir} != '')" ).append("\n"); 
		query.append("             AND C.SKD_DIR_CD = @[cobdir] " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${cobioc} != '')" ).append("\n"); 
		query.append("             AND C.IOC_CD = @[cobioc] " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${txtvsl_cd} != '')" ).append("\n"); 
		query.append("             AND C.VSL_CD = @[txtvsl_cd] " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${txtskd_voy_no} != '')" ).append("\n"); 
		query.append("             AND C.SKD_VOY_NO = @[txtskd_voy_no] " ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("          #if (${txtdir_cd} != '')" ).append("\n"); 
		query.append("             AND C.SKD_DIR_CD = @[txtdir_cd] " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("          GROUP BY " ).append("\n"); 
		query.append("				#if (${chkprd} == 'M')" ).append("\n"); 
		query.append("			  	  SUBSTR(A.COST_YRMON,0,4) ||'-'|| A.COST_WK	" ).append("\n"); 
		query.append("				#elseif (${chkprd} == 'W')" ).append("\n"); 
		query.append("  			 	   SUBSTR(A.SLS_YRMON,0,4) ||'-'|| A.COST_WK	" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("                  ,C.TRD_CD" ).append("\n"); 
		query.append("                  ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("                  ,A.SLAN_CD" ).append("\n"); 
		query.append("                  ,C.RLANE_CD" ).append("\n"); 
		query.append("                  ,DECODE(C.BSA_OP_CD, 'J', 'JO', 'SC')" ).append("\n"); 
		query.append("                  ,C.VSL_CD" ).append("\n"); 
		query.append("                  ,C.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,C.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,C.VOP_CD" ).append("\n"); 
		query.append("                  ,C.BSA_CAPA" ).append("\n"); 
		query.append("                  ,D.CRR_CD" ).append("\n"); 
		query.append("                  ,D.CRR_BSA_CAPA" ).append("\n"); 
		query.append("                  ,D.BSA_OP_JB_CD " ).append("\n"); 
		query.append("    #if (${isExcludZero} != '')	        	" ).append("\n"); 
		query.append("         HAVING NVL(CRR_BSA_CAPA, 0) > 0" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("GROUP BY COST_YRWK, " ).append("\n"); 
		query.append("        TRD_CD, " ).append("\n"); 
		query.append("        SUB_TRD_CD, " ).append("\n"); 
		query.append("        SLAN_CD, " ).append("\n"); 
		query.append("        RLANE_CD, " ).append("\n"); 
		query.append("        VSL_LANE_TP_CD, " ).append("\n"); 
		query.append("        VSL_CD, " ).append("\n"); 
		query.append("        SKD_VOY_NO, " ).append("\n"); 
		query.append("        SKD_DIR_CD, " ).append("\n"); 
		query.append("        VOP_CD, " ).append("\n"); 
		query.append("        BSA_CAPA, " ).append("\n"); 
		query.append("        CRR_CD" ).append("\n"); 
		query.append("ORDER BY COST_YRWK, " ).append("\n"); 
		query.append("        TRD_CD, " ).append("\n"); 
		query.append("        SUB_TRD_CD, " ).append("\n"); 
		query.append("        SLAN_CD, " ).append("\n"); 
		query.append("        RLANE_CD, " ).append("\n"); 
		query.append("        VSL_LANE_TP_CD, " ).append("\n"); 
		query.append("        VSL_CD, " ).append("\n"); 
		query.append("        SKD_VOY_NO, " ).append("\n"); 
		query.append("        SKD_DIR_CD, " ).append("\n"); 
		query.append("        CRR_CD" ).append("\n"); 

	}
}