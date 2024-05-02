/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOSearchProcessingVvdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.16
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.16 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOSearchProcessingVvdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Processing VVD 정보를 조회한다.
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOSearchProcessingVvdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_estm_bc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrmon_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_estm_vvd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOSearchProcessingVvdListRSQL").append("\n"); 
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
		query.append("SELECT    SUBSTR(EXE_YRMON, 1, 4) || '-' || SUBSTR(EXE_YRMON, -2) AS EXE_YRMON" ).append("\n"); 
		query.append("        , SUBSTR(REV_YRMON, 1, 4) || '-' || SUBSTR(REV_YRMON, -2) AS REV_YRMON" ).append("\n"); 
		query.append("        , VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("        , ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        , ESTM_BC_DIV_CD" ).append("\n"); 
		query.append("        , RLANE_CD" ).append("\n"); 
		query.append("		, TO_CHAR(CRE_DT     , 'YYYY-MM-DD HH24:MI:SS') AS CRE_DT" ).append("\n"); 
		query.append("        , SUBSTR(VST_DT, 1, 4) || '-' || SUBSTR(VST_DT, 5, 2) || '-' || SUBSTR(VST_DT, -2) AS VST_DT" ).append("\n"); 
		query.append("        , SUBSTR(VED_DT, 1, 4) || '-' || SUBSTR(VED_DT, 5, 2) || '-' || SUBSTR(VED_DT, -2) AS VED_DT" ).append("\n"); 
		query.append("FROM    GL_ESTM_REV_VVD T" ).append("\n"); 
		query.append("WHERE   1 =1" ).append("\n"); 
		query.append("#if (${yrmon_fm} != '') " ).append("\n"); 
		query.append("AND     EXE_YRMON      >= @[yrmon_fm]         -- (입력파라메터 : Month FM)" ).append("\n"); 
		query.append("AND     EXE_YRMON      <= @[yrmon_to]          -- (입력파라메터 : Month TO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- B/C 가 입력될 경우" ).append("\n"); 
		query.append("## AND     ESTM_BC_DIV_CD  = DECODE(@[s_estm_bc_div_cd], 'ALL', ESTM_BC_DIV_CD, @[s_estm_bc_div_cd])    -- (입력파라메터 : B/C)      " ).append("\n"); 
		query.append("#if (${s_estm_bc_div_cd} != '')" ).append("\n"); 
		query.append("	AND ESTM_BC_DIV_CD IN (" ).append("\n"); 
		query.append("		#foreach( $estm_bc_div_no in ${s_estm_bc_div_cd_list}) " ).append("\n"); 
		query.append("			#if($velocityCount < $s_estm_bc_div_cd_list.size()) " ).append("\n"); 
		query.append("		           '$estm_bc_div_no', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		           '$estm_bc_div_no' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_vvd_cd} != '') " ).append("\n"); 
		query.append("-- VVD 정보가 입력될 경우" ).append("\n"); 
		query.append("AND		VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD LIKE @[s_vvd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("-- TYPE 정보가 입력될 경우" ).append("\n"); 
		query.append("AND     ESTM_VVD_TP_CD  = DECODE(@[s_estm_vvd_tp_cd], 'ALL', ESTM_VVD_TP_CD, @[s_estm_vvd_tp_cd])  -- (입력파라메터 : TYPE)" ).append("\n"); 
		query.append("#if (${s_rlane_cd} != '') " ).append("\n"); 
		query.append("-- S/LANE 정보가 입력될 경우" ).append("\n"); 
		query.append("AND     RLANE_CD        LIKE @[s_rlane_cd]||'%'              -- (입력파라메터 : R/LANE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}