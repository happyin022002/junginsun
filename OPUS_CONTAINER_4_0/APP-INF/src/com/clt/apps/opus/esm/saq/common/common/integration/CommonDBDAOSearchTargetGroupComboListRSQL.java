/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchTargetGroupComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.02.28 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchTargetGroupComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTargetGroupComboList 목록 조회
	  * </pre>
	  */
	public CommonDBDAOSearchTargetGroupComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchTargetGroupComboListRSQL").append("\n"); 
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
		query.append("SELECT A.SAQ_TGT_GRP_CD GRP_CD, A.SAQ_TGT_GRP_DESC GRP_DESC" ).append("\n"); 
		query.append("FROM SAQ_TGT_GRP A " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.DELT_FLG IN ('N', @[del])" ).append("\n"); 
		query.append("#if (${ofc_cd} != '' )" ).append("\n"); 
		query.append("	    AND A.OFC_CD = @[ofc_cd] " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("ORDER BY A.SAQ_TGT_GRP_CD, A.SAQ_TGT_GRP_DESC" ).append("\n"); 

	}
}