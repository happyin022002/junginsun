/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationConsultationDBDAOCombinedVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOCombinedVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_JOO_0016 화면의 조회   
	  * </pre>
	  */
	public JointOperationConsultationDBDAOCombinedVORSQL(){
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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOCombinedVORSQL").append("\n"); 
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
		query.append("SELECT 'I' AS IBFLAG" ).append("\n"); 
		query.append("      ,A.ACCT_YRMON" ).append("\n"); 
		query.append("      ,A.JO_CRR_CD" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("      ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("      ,A.STL_SEQ" ).append("\n"); 
		query.append("      ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("      ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("      ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,A.CMB_CFM_FLG" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID     " ).append("\n"); 
		query.append("      ,A.R_VVD" ).append("\n"); 
		query.append("      ,DECODE(A.R_BSA_QTY, 0, NULL, A.R_BSA_QTY) AS R_BSA_QTY" ).append("\n"); 
		query.append("      ,DECODE(A.R_BSA_SLT_PRC, 0, NULL, A.R_BSA_SLT_PRC) AS R_BSA_SLT_PRC      " ).append("\n"); 
		query.append("      ,A.R_STL_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.E_VVD" ).append("\n"); 
		query.append("      ,DECODE(A.E_BSA_QTY, 0, NULL, A.E_BSA_QTY) AS E_BSA_QTY" ).append("\n"); 
		query.append("      ,DECODE(A.E_BSA_SLT_PRC, 0, NULL, A.E_BSA_SLT_PRC) AS E_BSA_SLT_PRC" ).append("\n"); 
		query.append("      ,A.E_STL_LOCL_AMT" ).append("\n"); 
		query.append("      ,A.STL_RMK" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("              'I' AS IBFLAG" ).append("\n"); 
		query.append("              ,A.ACCT_YRMON" ).append("\n"); 
		query.append("              ,A.JO_CRR_CD" ).append("\n"); 
		query.append("              ,A.RLANE_CD" ).append("\n"); 
		query.append("              ,A.RE_DIVR_CD" ).append("\n"); 
		query.append("              ,A.STL_VVD_SEQ" ).append("\n"); 
		query.append("              ,A.STL_SEQ" ).append("\n"); 
		query.append("              ,A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("              ,C.ORD_SEQ " ).append("\n"); 
		query.append("              ,A.JO_STL_JB_CD" ).append("\n"); 
		query.append("              ,A.LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,A.CMB_CFM_FLG" ).append("\n"); 
		query.append("              ,A.UPD_USR_ID     " ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'R',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS R_VVD" ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.USD_SLT_BSA_QTY ELSE A.BSA_QTY END)) AS R_BSA_QTY" ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.RF_SCG_PRC ELSE A.BSA_SLT_PRC END)) AS R_BSA_SLT_PRC" ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)) AS R_STL_LOCL_AMT" ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'E',A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD,'') AS E_VVD" ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_QTY,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.USD_SLT_BSA_QTY ELSE A.BSA_QTY END)) AS E_BSA_QTY" ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.BSA_SLT_PRC,CASE WHEN A.JO_STL_ITM_CD = 'R/F' AND A.JO_MNU_NM = 'R/F' THEN A.RF_SCG_PRC ELSE A.BSA_SLT_PRC END)) AS E_BSA_SLT_PRC" ).append("\n"); 
		query.append("              ,DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)) AS E_STL_LOCL_AMT" ).append("\n"); 
		query.append("              ,SUBSTR(DECODE(A.STL_RMK,NULL,NULL,','||A.STL_RMK)||DECODE(A.FM_PORT_CD,NULL,NULL,DECODE(A.JO_MNU_NM,'RDR',DECODE(A.TO_PORT_CD, NULL,',RDR Port:'||A.FM_PORT_CD,','||A.FM_PORT_CD||'-'||A.TO_PORT_CD), ','||A.FM_PORT_CD||DECODE(A.TO_PORT_CD,NULL,NULL,'-'||A.TO_PORT_CD))) || DECODE(A.SAIL_DYS,NULL,NULL,',Sail Days:'||A.SAIL_DYS), 2) AS STL_RMK" ).append("\n"); 
		query.append("        FROM   JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("               JOO_STL_DTL     B," ).append("\n"); 
		query.append("               JOO_STL_ITM     C" ).append("\n"); 
		query.append("        WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("        AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("        AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("        AND    A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("        AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("        --2010.01.05 stl_locl_amt가 0이어도 combined처리 되어야 함 ==> adjustment의 combined된 data 삭제불가 때문임..." ).append("\n"); 
		query.append("        --AND    DECODE(A.STL_ADJ_FLG,'Y',NVL(B.STL_LOCL_AMT,0),NVL(A.STL_LOCL_AMT,0)) != 0" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("		AND    A.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("		AND    A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND    NVL(A.CMB_CFM_FLG,'N') = 'N'" ).append("\n"); 
		query.append("		AND    A.RLANE_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${rlane_cd}) " ).append("\n"); 
		query.append("         #if($velocityCount < $rlane_cd.size()) " ).append("\n"); 
		query.append("          '$key', " ).append("\n"); 
		query.append("         #else " ).append("\n"); 
		query.append("          '$key' " ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       #end " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#if (${locl_curr_cd} != '')" ).append("\n"); 
		query.append("		AND    A.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND    A.JO_STL_ITM_CD = C.JO_STL_ITM_CD" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append("ORDER BY A.RLANE_CD, A.ORD_SEQ, A.JO_STL_JB_CD, A.STL_VVD_SEQ, A.STL_SEQ" ).append("\n"); 

	}
}