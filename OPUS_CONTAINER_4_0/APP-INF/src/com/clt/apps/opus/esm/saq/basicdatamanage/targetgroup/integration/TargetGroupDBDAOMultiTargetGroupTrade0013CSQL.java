/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TargetGroupDBDAOMultiTargetGroupTrade0013CSQL.java
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

public class TargetGroupDBDAOMultiTargetGroupTrade0013CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TargetGroupDBDAOMultiSAQ_TGT_GRP_TRDCSQL : SQL_TGT_GRP_TRD (Insert)
	  * </pre>
	  */
	public TargetGroupDBDAOMultiTargetGroupTrade0013CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("saq_tgt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.integration").append("\n"); 
		query.append("FileName : TargetGroupDBDAOMultiTargetGroupTrade0013CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_TGT_GRP_TRD (  " ).append("\n"); 
		query.append("            TRD_CD              " ).append("\n"); 
		query.append("          , SUB_TRD_CD          " ).append("\n"); 
		query.append("          , DIR_CD              " ).append("\n"); 
		query.append("          , SAQ_TGT_GRP_CD      " ).append("\n"); 
		query.append("          , CRE_USR_ID          " ).append("\n"); 
		query.append("          , CRE_DT              " ).append("\n"); 
		query.append("          , UPD_USR_ID          " ).append("\n"); 
		query.append("          , UPD_DT           )  " ).append("\n"); 
		query.append(" VALUES (                       " ).append("\n"); 
		query.append("            @[trd_cd]                   " ).append("\n"); 
		query.append("          , @[sub_trd_cd]                   " ).append("\n"); 
		query.append("          , @[dir_cd]                   " ).append("\n"); 
		query.append("          , @[saq_tgt_grp_cd]                   " ).append("\n"); 
		query.append("          , @[cre_usr_id]                   " ).append("\n"); 
		query.append("          , SYSDATE             " ).append("\n"); 
		query.append("          , @[cre_usr_id]                   " ).append("\n"); 
		query.append("          , SYSDATE )" ).append("\n"); 

	}
}