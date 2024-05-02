/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RailSoManageDBDAOSearch08RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch08RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail Empty SO 대상 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOSearch08RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stoLocationCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrSize",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sctrlOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splanToDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("splanFromDate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfromLocationCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntrType",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch08RailSoManageRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL(A,  LOC) */" ).append("\n"); 
		query.append("        A.REPO_PLN_ID" ).append("\n"); 
		query.append("	   ,A.PLN_YRWK" ).append("\n"); 
		query.append("	   ,A.PLN_SEQ" ).append("\n"); 
		query.append("	   ,A.SO_IF_DIV_CD" ).append("\n"); 
		query.append("	   ,A.REF_ID" ).append("\n"); 
		query.append("	   ,A.SO_RQST_DT" ).append("\n"); 
		query.append("	   ,A.CNTR_TPSZ_CD EQ_TPSZ_CD" ).append("\n"); 
		query.append("	   ,COUNT(A.REF_ID)  ALLOCATED" ).append("\n"); 
		query.append("	   ,SUM( DECODE( SO.TRSP_SO_STS_CD ,'C',1,'R',1,0 )) CRET_QTY" ).append("\n"); 
		query.append("	   ,COUNT(SO.WO_ISS_DT ) EDI_QTY" ).append("\n"); 
		query.append("	   ,SUM( DECODE(SO.TRSP_SO_SEQ , NULL , 1, 0 )) REMAINING_QTY" ).append("\n"); 
		query.append("	   ,SUM( DECODE(SO.TRSP_SO_SEQ , NULL , 1, 0 )) NEEDED_QTY" ).append("\n"); 
		query.append("	   ,SUBSTR(A.FM_YD_CD,1,5) FM_LOC_CD" ).append("\n"); 
		query.append("	   ,SUBSTR(A.FM_YD_CD,6,2) FM_NOD_CD" ).append("\n"); 
		query.append("   	   ,A.FM_DT" ).append("\n"); 
		query.append("	   ,SUBSTR(A.TO_YD_CD,1,5) TO_LOC_CD" ).append("\n"); 
		query.append("	   ,SUBSTR(A.TO_YD_CD,6,2) TO_NOD_CD" ).append("\n"); 
		query.append("       ,A.TO_DT" ).append("\n"); 
		query.append(" 	   ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("	   ,A.VSL_LANE_CD SLAN_CD" ).append("\n"); 
		query.append("	   ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append("	   ,A.REPO_PURP_RMK" ).append("\n"); 
		query.append("	   ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC( 'PHXSA' ) ,'RRRRMMDD') CURR_DT " ).append("\n"); 
		query.append("	   ,A.TRSP_MOD_CD TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append("	   ,A.SO_IF_DIV_CD TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append("   FROM EQR_REPO_EXE_SO_IF A" ).append("\n"); 
		query.append("	   ,TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("       ,MDM_LOCATION LOC " ).append("\n"); 
		query.append("  WHERE A.REPO_PLN_ID = SO.REPO_PLN_ID(+)	" ).append("\n"); 
		query.append("    AND A.PLN_YRWK = SO.PLN_YRWK(+)" ).append("\n"); 
		query.append("    AND A.REF_ID = SO.REF_ID(+)" ).append("\n"); 
		query.append("    AND A.REF_SEQ = SO.REF_SEQ(+) " ).append("\n"); 
		query.append("    AND A.WO_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("    AND SUBSTR(A.FM_YD_CD, 1, 5) = LOC.LOC_CD " ).append("\n"); 
		query.append("    AND A.CO_CD = 'H'" ).append("\n"); 
		query.append("    AND A.SO_IF_DIV_CD ='R'" ).append("\n"); 
		query.append("    AND EXISTS (SELECT 1 FROM MDM_COUNTRY CNTY WHERE CNTY.CNT_CD != 'MX' AND LOC.CONTI_CD = 'M' AND A.TRSP_MOD_CD = 'R' AND LOC.CNT_CD = CNTY.CNT_CD)" ).append("\n"); 
		query.append("#if(${splanFromDate} != '' && ${splanToDate} != '')" ).append("\n"); 
		query.append("	AND A.SO_RQST_DT BETWEEN @[splanFromDate] AND @[splanToDate]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sfromLocationCd} != '')" ).append("\n"); 
		query.append("	AND A.FM_YD_CD LIKE @[sfromLocationCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${stoLocationCd} != '')" ).append("\n"); 
		query.append("	AND A.TO_YD_CD LIKE @[stoLocationCd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${selKind} == 'ER')" ).append("\n"); 
		query.append("	AND A.SO_IF_DIV_CD IN ('T', 'R', 'W')" ).append("\n"); 
		query.append("#elseif(${selKind} == 'CN')" ).append("\n"); 
		query.append("	AND A.SO_IF_DIV_CD = 'O'" ).append("\n"); 
		query.append("#elseif(${selKind} == 'CF')" ).append("\n"); 
		query.append("	AND A.SO_IF_DIV_CD = 'F'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($cntr.size() > 0)" ).append("\n"); 
		query.append("	AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cntrType} != 'ALL')" ).append("\n"); 
		query.append("	AND SUBSTR(A.CNTR_TPSZ_CD, 1, 1) = @[cntrType]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cntrSize} != 'ALL')" ).append("\n"); 
		query.append("	AND SUBSTR(A.CNTR_TPSZ_CD, 2, 1) = @[cntrSize]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if($refId.size() > 0)" ).append("\n"); 
		query.append("	AND A.REF_ID IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${refId})" ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND A.EQ_CTRL_OFC_CD = @[sctrlOfcCd] " ).append("\n"); 
		query.append("  GROUP BY A.REPO_PLN_ID" ).append("\n"); 
		query.append("		  ,A.PLN_YRWK" ).append("\n"); 
		query.append("	   	  ,A.PLN_SEQ" ).append("\n"); 
		query.append("		  ,A.SO_IF_DIV_CD" ).append("\n"); 
		query.append("	      ,A.REF_ID" ).append("\n"); 
		query.append("	      ,A.SO_RQST_DT" ).append("\n"); 
		query.append("	      ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		  ,A.FM_YD_CD" ).append("\n"); 
		query.append("		  ,A.FM_DT" ).append("\n"); 
		query.append("		  ,A.TO_YD_CD" ).append("\n"); 
		query.append("		  ,A.TO_DT" ).append("\n"); 
		query.append("		  ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("     	  ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("    	  ,A.VSL_LANE_CD" ).append("\n"); 
		query.append("    	  ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD" ).append("\n"); 
		query.append("    	  ,A.REPO_PURP_RMK" ).append("\n"); 
		query.append("		  ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC( 'PHXSA' ) ,'RRRRMMDD')" ).append("\n"); 
		query.append("  ORDER BY A.SO_IF_DIV_CD" ).append("\n"); 
		query.append("		  ,A.SO_RQST_DT" ).append("\n"); 
		query.append("		  ,A.REF_ID" ).append("\n"); 
		query.append("		  ,A.CNTR_TPSZ_CD" ).append("\n"); 

	}
}