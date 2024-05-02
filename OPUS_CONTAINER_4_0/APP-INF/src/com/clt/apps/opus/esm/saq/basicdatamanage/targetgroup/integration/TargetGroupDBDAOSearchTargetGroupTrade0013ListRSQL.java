/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TargetGroupDBDAOSearchTargetGroupTrade0013ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2010.03.09 김종호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Ho Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TargetGroupDBDAOSearchTargetGroupTrade0013ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target Group 과 Trade/Bound/Sub Trade 의 mapping 정보
	  * </pre>
	  */
	public TargetGroupDBDAOSearchTargetGroupTrade0013ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration").append("\n"); 
		query.append("FileName : TargetGroupDBDAOSearchTargetGroupTrade0013ListRSQL").append("\n"); 
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
		query.append("SELECT A.TRD_CD                    " ).append("\n"); 
		query.append("          , A.SUB_TRD_CD                " ).append("\n"); 
		query.append("          , A.DIR_CD                    " ).append("\n"); 
		query.append("          , A.SAQ_TGT_GRP_CD            " ).append("\n"); 
		query.append("     FROM SAQ_TGT_GRP_TRD A             " ).append("\n"); 
		query.append("    WHERE A.TRD_CD         LIKE @[trade]||'%'  " ).append("\n"); 
		query.append("      AND A.SUB_TRD_CD     LIKE @[sub_trade]||'%'  " ).append("\n"); 
		query.append("      AND A.SAQ_TGT_GRP_CD LIKE @[tgt_grp_cd]||'%'  " ).append("\n"); 
		query.append(" ORDER BY A.TRD_CD                    " ).append("\n"); 
		query.append("          , A.SUB_TRD_CD                " ).append("\n"); 
		query.append("          , A.DIR_CD                    " ).append("\n"); 
		query.append("          , A.SAQ_TGT_GRP_CD" ).append("\n"); 

	}
}