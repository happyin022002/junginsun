/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIrgTimeInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.19 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchIrgTimeInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for searching time information
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIrgTimeInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_irg_rout_org",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_irg_rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_irg_rout_dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchIrgTimeInformationRSQL").append("\n"); 
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
		query.append("P.TRSP_MOD_CD                 \"MODE\"," ).append("\n"); 
		query.append("nvl(M.VNDR_ABBR_NM, ' ')       VENDOR," ).append("\n"); 
		query.append("SUBSTR(P.LNK_ORG_NOD_CD, 1, 5) FROM_LOC," ).append("\n"); 
		query.append("TO_CHAR((SELECT NVL(ACT_DT,ESTM_DT) FROM SCE_COP_DTL D WHERE D.COP_NO = @[e_cop_no] AND D.NOD_CD = P.LNK_ORG_NOD_CD  AND D.ACT_CD LIKE DECODE(SUBSTR(ACT_CD,2,1),'U','____B_','____A_') AND D.ACT_CD NOT LIKE 'M%' and rownum = 1),'YYYYMMDDHH24MI') FROM_ARV_DT," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(P.LNK_ORG_NOD_CD, 1, 5),(SELECT NVL(ACT_DT,ESTM_DT) FROM SCE_COP_DTL D WHERE D.COP_NO = @[e_cop_no] AND D.NOD_CD = P.LNK_ORG_NOD_CD  AND D.ACT_CD LIKE DECODE(SUBSTR(ACT_CD,2,1),'U','____B_','____A_') AND D.ACT_CD NOT LIKE 'M%'and rownum = 1), 'GMT'),'YYYYMMDDHH24MI') FROM_ARV_DT_GMT," ).append("\n"); 
		query.append("TO_CHAR((SELECT NVL(ACT_DT,ESTM_DT) FROM SCE_COP_DTL D WHERE D.COP_NO = @[e_cop_no] AND D.NOD_CD = P.LNK_ORG_NOD_CD  AND D.ACT_CD LIKE '____D_' AND D.ACT_CD NOT LIKE 'M%' and rownum = 1),'YYYYMMDDHH24MI')  FROM_DPT_DT," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(P.LNK_ORG_NOD_CD, 1, 5),(SELECT NVL(ACT_DT,ESTM_DT) FROM SCE_COP_DTL D WHERE D.COP_NO = @[e_cop_no] AND D.NOD_CD = P.LNK_ORG_NOD_CD  AND D.ACT_CD LIKE '____D_' AND D.ACT_CD NOT LIKE 'M%' and rownum = 1), 'GMT'),'YYYYMMDDHH24MI') FROM_DPT_DT_GMT," ).append("\n"); 
		query.append("SUBSTR(P.LNK_DEST_NOD_CD, 1, 5) TO_LOC," ).append("\n"); 
		query.append("TO_CHAR((SELECT NVL(ACT_DT,ESTM_DT) FROM SCE_COP_DTL D WHERE D.COP_NO = @[e_cop_no] AND D.NOD_CD = P.LNK_DEST_NOD_CD  AND D.ACT_CD LIKE '____A_' AND D.ACT_CD NOT LIKE 'M%' and rownum = 1),'YYYYMMDDHH24MI') TO_ARV_DT," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(P.LNK_DEST_NOD_CD, 1, 5),(SELECT NVL(ACT_DT,ESTM_DT) FROM SCE_COP_DTL D WHERE D.COP_NO = @[e_cop_no] AND D.NOD_CD = P.LNK_DEST_NOD_CD  AND D.ACT_CD LIKE '____A_' AND D.ACT_CD NOT LIKE 'M%' and rownum = 1), 'GMT'),'YYYYMMDDHH24MI') TO_ARV_DT_GMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_DTL P, MDM_VENDOR M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("and p.ROUT_ORG_NOD_CD     = @[e_irg_rout_org]" ).append("\n"); 
		query.append("AND P.ROUT_DEST_NOD_CD    = @[e_irg_rout_dest]" ).append("\n"); 
		query.append("AND P.ROUT_SEQ = @[e_irg_rout_seq]" ).append("\n"); 
		query.append("AND P.VNDR_SEQ = M.VNDR_SEQ" ).append("\n"); 
		query.append("ORDER BY ROUT_DTL_SEQ" ).append("\n"); 

	}
}