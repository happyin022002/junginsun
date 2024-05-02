/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDAOremoveComponentCodeDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.26 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOremoveComponentCodeDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOremoveComponentCodeDataDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_num_iso_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",n";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM MNR_EQ_CMPO_CD A" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND  (" ).append("\n"); 
		query.append("A.EQ_CMPO_NUM_ISO_CD = @[eq_cmpo_num_iso_cd]" ).append("\n"); 
		query.append("AND   A.EQ_CMPO_CD = @[eq_cmpo_cd]" ).append("\n"); 
		query.append("AND   A.EQ_CMPO_GRP_TP_CD = @[eq_cmpo_grp_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eq_cmpo_grp_tp_cd} == '1')" ).append("\n"); 
		query.append("OR   (" ).append("\n"); 
		query.append("A.EQ_CMPO_GRP_TP_CD = '2'" ).append("\n"); 
		query.append("AND @[eq_cmpo_cd] = A.EQ_PRNT_CMPO_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR   (" ).append("\n"); 
		query.append("A.EQ_CMPO_GRP_TP_CD = '3'" ).append("\n"); 
		query.append("AND A.EQ_PRNT_CMPO_CD IN ( SELECT EQ_CMPO_CD" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD" ).append("\n"); 
		query.append("WHERE EQ_CMPO_GRP_TP_CD = '2'" ).append("\n"); 
		query.append("AND EQ_PRNT_CMPO_CD = @[eq_cmpo_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#elseif (${eq_cmpo_grp_tp_cd} == '2')" ).append("\n"); 
		query.append("OR   (" ).append("\n"); 
		query.append("A.EQ_CMPO_GRP_TP_CD = '3'" ).append("\n"); 
		query.append("AND @[eq_cmpo_cd] = A.EQ_PRNT_CMPO_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
	}
}