/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchSceCopDetailVLScheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchSceCopDetailVLScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSceCopDetailVLSchedule
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchSceCopDetailVLScheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchSceCopDetailVLScheduleRSQL").append("\n"); 
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
		query.append("SELECT  TO_CHAR(MAX(CASE WHEN B.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("THEN SCE_COP_SKD_LGC_CAL_FNC(G.COP_FOML_CD,B.TZ_DWLL_TM_HRS,R.ROW_UP,R.ROW_DOWN,G.FOML_PCT_NO,G.FOML_TM_HRS)" ).append("\n"); 
		query.append("ELSE A.ESTM_DT" ).append("\n"); 
		query.append("END),'YYYY/MM/DD HH24:MI:SS')  vl_skd_dt" ).append("\n"); 
		query.append("FROM    SCE_COP_DTL A" ).append("\n"); 
		query.append(",PRD_PROD_CTL_ROUT_DTL B" ).append("\n"); 
		query.append(",MDM_ACTIVITY D" ).append("\n"); 
		query.append(",SCE_COP_SKD_LGC G" ).append("\n"); 
		query.append(",SCE_COP_HDR H" ).append("\n"); 
		query.append(",(SELECT S.ROW_UP, S.ROW_DOWN" ).append("\n"); 
		query.append("FROM  (SELECT D.COP_NO,D.COP_DTL_SEQ, D.ESTM_DT," ).append("\n"); 
		query.append("(CASE WHEN (D.COP_NO||D.COP_DTL_SEQ) = (@[cop_no]||@[cop_dtl_seq])" ).append("\n"); 
		query.append("THEN LAG(D.ESTM_DT, 1) OVER (ORDER BY D.COP_NO, D.COP_DTL_SEQ)" ).append("\n"); 
		query.append("END)  ROW_UP," ).append("\n"); 
		query.append("(CASE WHEN (D.COP_NO||D.COP_DTL_SEQ) = (@[cop_no]||@[cop_dtl_seq])" ).append("\n"); 
		query.append("THEN LEAD(D.ESTM_DT, 1) OVER (ORDER BY D.COP_NO, D.COP_DTL_SEQ)" ).append("\n"); 
		query.append("END)  ROW_DOWN" ).append("\n"); 
		query.append("FROM   SCE_COP_DTL D" ).append("\n"); 
		query.append("WHERE  D.COP_NO = @[cop_no] ) S," ).append("\n"); 
		query.append("SCE_COP_DTL A" ).append("\n"); 
		query.append("WHERE  A.COP_NO      = S.COP_NO" ).append("\n"); 
		query.append("AND    A.COP_DTL_SEQ = S.COP_DTL_SEQ" ).append("\n"); 
		query.append("AND    (A.COP_NO||A.COP_DTL_SEQ) = (@[cop_no]||@[cop_dtl_seq])) R" ).append("\n"); 
		query.append("WHERE   A.COP_NO            = @[cop_no]" ).append("\n"); 
		query.append("AND     A.COP_DTL_SEQ       = @[cop_dtl_seq]" ).append("\n"); 
		query.append("AND     D.ACT_CD            = A.ACT_CD" ).append("\n"); 
		query.append("AND     H.COP_NO            = A.COP_NO" ).append("\n"); 
		query.append("AND     B.PCTL_NO           = H.PCTL_NO" ).append("\n"); 
		query.append("AND     G.COP_SKD_LGC_NO(+) = D.COP_SKD_LGC_NO" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}