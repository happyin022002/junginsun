/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooStlBssPortCreRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.02.16 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooStlBssPortCreRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력용
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooStlBssPortCreRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooStlBssPortCreRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("       'R' AS IBFLAG," ).append("\n"); 
		query.append("       A.JO_CRR_CD," ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.JO_STL_ITM_CD," ).append("\n"); 
		query.append("       A.SKD_DIR_CD," ).append("\n"); 
		query.append("       '1' SEQ," ).append("\n"); 
		query.append("       A.STL_TGT_VVD_BSS_CD," ).append("\n"); 
		query.append("       A.JO_STL_TGT_TP_CD," ).append("\n"); 
		query.append("       A.N1ST_STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       A.N2ND_STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       A.N3RD_STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       A.N1ST_STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       A.N2ND_STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       A.N3RD_STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("       A.AGMT_MON_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_PORT_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_PORT_TP_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_OP_TP_COND_CD," ).append("\n"); 
		query.append("       B.JO_STL_ITM_NM" ).append("\n"); 
		query.append("FROM   JOO_STL_BSS_PORT A," ).append("\n"); 
		query.append("       JOO_STL_ITM      B" ).append("\n"); 
		query.append("WHERE  A.JO_STL_ITM_CD = B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD      = @[rlane_cd]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       'I' AS IBFLAG," ).append("\n"); 
		query.append("       @[jo_crr_cd] AS JO_CRR_CD," ).append("\n"); 
		query.append("       @[trd_cd]    AS TRD_CD," ).append("\n"); 
		query.append("       @[rlane_cd]  AS RLANE_CD,       " ).append("\n"); 
		query.append("       A.JO_STL_ITM_CD," ).append("\n"); 
		query.append("       B.CODE AS SKD_DIR_CD," ).append("\n"); 
		query.append("       B.CODE," ).append("\n"); 
		query.append("       '' AS STL_TGT_VVD_BSS_CD," ).append("\n"); 
		query.append("       '' AS JO_STL_TGT_TP_CD," ).append("\n"); 
		query.append("       '' AS N1ST_STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       '' AS N2ND_STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       '' AS N3RD_STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       '' AS N1ST_STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       '' AS N2ND_STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       '' AS N3RD_STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       '' AS UC_BSS_PORT_CD," ).append("\n"); 
		query.append("       '' AS AGMT_MON_COND_CD," ).append("\n"); 
		query.append("       '' AS AGMT_PORT_COND_CD," ).append("\n"); 
		query.append("       '' AS AGMT_PORT_TP_COND_CD," ).append("\n"); 
		query.append("       '' AS AGMT_OP_TP_COND_CD," ).append("\n"); 
		query.append("       A.JO_STL_ITM_NM" ).append("\n"); 
		query.append("FROM   JOO_STL_ITM     A," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("       SELECT 'E' AS CODE," ).append("\n"); 
		query.append("              'East' AS NAME" ).append("\n"); 
		query.append("       FROM   DUAL" ).append("\n"); 
		query.append("--Bound, Cycle인 경우만 E-W, Round는 E만" ).append("\n"); 
		query.append("#if (${jo_stl_opt_cd}== 'B' || ${jo_stl_opt_cd}== 'C')" ).append("\n"); 
		query.append("       UNION  ALL" ).append("\n"); 
		query.append("       SELECT 'W' AS CODE," ).append("\n"); 
		query.append("              'West' AS NAME" ).append("\n"); 
		query.append("       FROM   DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE  A.JO_AUTO_CRE_FLG = 'Y'" ).append("\n"); 
		query.append("--2010.02.16 이미 존재하는 것은 제외하라" ).append("\n"); 
		query.append("AND    NOT EXISTS (" ).append("\n"); 
		query.append("          SELECT 1" ).append("\n"); 
		query.append("          FROM   JOO_STL_BSS_PORT X" ).append("\n"); 
		query.append("          WHERE  X.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("          AND    X.TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("          AND    X.RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("          AND    X.JO_STL_ITM_CD = A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("          AND    X.SKD_DIR_CD    = B.CODE" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("ORDER  BY 1 DESC, 6, 5" ).append("\n"); 

	}
}