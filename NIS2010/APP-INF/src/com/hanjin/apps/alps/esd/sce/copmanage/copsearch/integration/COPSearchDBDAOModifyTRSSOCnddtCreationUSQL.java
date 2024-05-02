/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : COPSearchDBDAOModifyTRSSOCnddtCreationUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOModifyTRSSOCnddtCreationUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS S/O Candidate Creation (RQST By BKG에 의해 삭제된 S/O Candidate 복구 재생성)
	  * </pre>
	  */
	public COPSearchDBDAOModifyTRSSOCnddtCreationUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOModifyTRSSOCnddtCreationUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST " ).append("\n"); 
		query.append("SET TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("AND COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 
		query.append("AND @[trsp_so_sts_cd] IN ('D', 'N')" ).append("\n"); 

	}
}