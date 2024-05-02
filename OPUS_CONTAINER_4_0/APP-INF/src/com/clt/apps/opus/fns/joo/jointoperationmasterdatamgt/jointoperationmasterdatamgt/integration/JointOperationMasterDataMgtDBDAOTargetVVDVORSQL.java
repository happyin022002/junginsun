/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOTargetVVDVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOTargetVVDVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOTargetVVDVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOTargetVVDVORSQL").append("\n"); 
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
		query.append("       A.ACCT_YRMON," ).append("\n"); 
		query.append("       A.STL_VVD_SEQ," ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.JO_CRR_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.RE_DIVR_CD," ).append("\n"); 
		query.append("       A.JO_STL_ITM_CD," ).append("\n"); 
		query.append("       A.JO_MNU_NM," ).append("\n"); 
		query.append("       A.VSL_CD," ).append("\n"); 
		query.append("       A.SKD_VOY_NO," ).append("\n"); 
		query.append("       A.SKD_DIR_CD," ).append("\n"); 
		query.append("       A.REV_DIR_CD," ).append("\n"); 
		query.append("       A.STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.BZC_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS BZC_PORT_ETD_DT," ).append("\n"); 
		query.append("       A.STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.PAIR_PORT_ETA_DT,'YYYYMMDDHH24MISS') AS PAIR_PORT_ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.PAIR_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS PAIR_PORT_ETD_DT," ).append("\n"); 
		query.append("       A.STL_TGT_VVD_BSS_CD," ).append("\n"); 
		query.append("       A.JO_STL_CFM_CD," ).append("\n"); 
		query.append("       DECODE(A.PROC_JB_FLG,'Y','Y','N') AS PROC_JB_FLG," ).append("\n"); 
		query.append("       A.STL_RMK," ).append("\n"); 
		query.append("       CASE WHEN A.JO_MNU_NM = A.JO_STL_ITM_CD THEN '0'" ).append("\n"); 
		query.append("            ELSE " ).append("\n"); 
		query.append("                CASE WHEN A.JO_STL_ITM_CD = 'OUS' THEN" ).append("\n"); 
		query.append("                     CASE WHEN A.JO_MNU_NM IN ('RDR','TDR') THEN '0'" ).append("\n"); 
		query.append("                          WHEN A.JO_MNU_NM = 'M/S' THEN '1'" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("                     ELSE '1'                      " ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("       END AS JO_MNL_CRE_FLG," ).append("\n"); 
		query.append("       A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT," ).append("\n"); 
		query.append("       NVL((SELECT Y.INTG_CD_VAL_DP_DESC AS JO_MNU_NM" ).append("\n"); 
		query.append("            FROM   JOO_STL_BSS_PORT X," ).append("\n"); 
		query.append("                   COM_INTG_CD_DTL  Y" ).append("\n"); 
		query.append("            WHERE  X.JO_STL_TGT_TP_CD = Y.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("            AND    Y.INTG_CD_ID = 'CD01867'" ).append("\n"); 
		query.append("            AND    X.JO_CRR_CD  = A.JO_CRR_CD" ).append("\n"); 
		query.append("            AND    X.RLANE_CD   = A.RLANE_CD" ).append("\n"); 
		query.append("            AND    X.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND    X.JO_STL_ITM_CD = A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("       ),A.JO_MNU_NM) AS JO_MNU_NM1," ).append("\n"); 
		query.append("       A.AGMT_MON_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_PORT_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_PORT_TP_COND_CD," ).append("\n"); 
		query.append("       A.AGMT_OP_TP_COND_CD," ).append("\n"); 
		query.append("       '' AS REV_YRMON," ).append("\n"); 
		query.append("       --2010.03.29 정상CSR 끊긴 것과 REVERSE 된 것이 1:1이면 JO_STL_CFM_CD를 수정가능하게 한다." ).append("\n"); 
		query.append("       'N' AS RVS_FLG," ).append("\n"); 
		query.append("       'N' AS PENDING_FLG" ).append("\n"); 
		query.append("FROM   JOO_STL_VVD A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       --2010.03.29 REVERSE 된 SETTLEMENT를 우선 삭제한 다음에 PENDING을 수정하기로 함 (박효숙차장) " ).append("\n"); 
		query.append("       SELECT X.ACCT_YRMON, X.STL_VVD_SEQ" ).append("\n"); 
		query.append("       FROM   JOO_SETTLEMENT X," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT A.ACCT_YRMON, A.STL_VVD_SEQ, A.STL_SEQ" ).append("\n"); 
		query.append("              FROM   JOO_STL_CMB_DTL A," ).append("\n"); 
		query.append("                     JOO_STL_CMB     B" ).append("\n"); 
		query.append("              WHERE  A.ACCT_YRMON = B.ACCT_YRMON" ).append("\n"); 
		query.append("              AND    A.JO_CRR_CD  = B.JO_CRR_CD" ).append("\n"); 
		query.append("              AND    A.STL_CMB_SEQ= B.STL_CMB_SEQ" ).append("\n"); 
		query.append("              AND    A.RE_DIVR_CD = B.RE_DIVR_CD" ).append("\n"); 
		query.append("              GROUP  BY" ).append("\n"); 
		query.append("                     A.ACCT_YRMON, A.STL_VVD_SEQ, A.STL_SEQ" ).append("\n"); 
		query.append("              ) Y" ).append("\n"); 
		query.append("       WHERE  X.ACCT_YRMON  = Y.ACCT_YRMON (+)" ).append("\n"); 
		query.append("       AND    X.STL_VVD_SEQ = Y.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("       AND    X.STL_SEQ     = Y.STL_SEQ    (+)" ).append("\n"); 
		query.append("       GROUP  BY X.ACCT_YRMON, X.STL_VVD_SEQ" ).append("\n"); 
		query.append("       ) B        " ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("ORDER  BY A.SKD_DIR_CD, A.BZC_PORT_ETA_DT, A.VSL_CD, A.SKD_VOY_NO, A.JO_STL_ITM_CD, A.JO_MNU_NM" ).append("\n"); 

	}
}