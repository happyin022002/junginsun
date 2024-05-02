/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPC_INIT_ALOC_RTO 정보 INSERT
	  * </pre>
	  */
	public InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_aloc_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.basicdatamanage.initialspaceallocationratio.integration").append("\n"); 
		query.append("FileName : InitialSpaceAllocationRatioDBDAORatioInseInitAlogRtoCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_INIT_ALOC_RTO (" ).append("\n"); 
		query.append("    REP_TRD_CD   ," ).append("\n"); 
		query.append("    DIR_CD       ," ).append("\n"); 
		query.append("    BSE_MON      ," ).append("\n"); 
		query.append("    INIT_ALOC_RTO," ).append("\n"); 
		query.append("    CRE_USR_ID   ," ).append("\n"); 
		query.append("    CRE_DT       ," ).append("\n"); 
		query.append("    UPD_USR_ID   ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("    @[rep_trd_cd]   ," ).append("\n"); 
		query.append("    @[dir_cd]       ," ).append("\n"); 
		query.append("    @[bse_mon]      ," ).append("\n"); 
		query.append("    @[init_aloc_rto]," ).append("\n"); 
		query.append("    @[cre_usr_id]   ," ).append("\n"); 
		query.append("    TO_DATE(SYSDATE,'YYYY-MM-DD')," ).append("\n"); 
		query.append("    @[upd_usr_id]   ," ).append("\n"); 
		query.append("    TO_DATE(SYSDATE,'YYYY-MM-DD')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}