/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOModifyFixedPlanVolumeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.09.15 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOModifyFixedPlanVolumeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Discharge 된 volume 을 fixed plan에서 감소시켜줌
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOModifyFixedPlanVolumeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration ").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOModifyFixedPlanVolumeUSQL").append("\n"); 
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
		query.append("UPDATE	EQR_VSL_LODG_DCHG_PLN_QTY SET" ).append("\n"); 
		query.append("CNTR_QTY			= @[cntr_qty]" ).append("\n"); 
		query.append(",	LODG_DCHG_COST_AMT	= ROUND((LODG_PORT_COST_AMT / DECODE(cntr_qty, 0, 1 ,CNTR_QTY)) * @[cntr_qty] )" ).append("\n"); 
		query.append("+ ROUND((LODG_PORT_COST_AMT / DECODE(CNTR_QTY, 0, 1 ,CNTR_QTY))) * @[cntr_qty]" ).append("\n"); 
		query.append(",	PLN_UC_AMT			= (LODG_PORT_COST_AMT / DECODE(CNTR_QTY, 0, 1 ,CNTR_QTY)) +  (DCHG_PORT_COST_AMT / DECODE(CNTR_QTY, 0, 1 ,CNTR_QTY))" ).append("\n"); 
		query.append(",	LODG_PORT_COST_AMT	= (LODG_PORT_COST_AMT / DECODE(CNTR_QTY, 0, 1 ,CNTR_QTY)) * DECODE(@[cntr_qty], 0, 1 ,@[cntr_qty])" ).append("\n"); 
		query.append(",	DCHG_PORT_COST_AMT	= (DCHG_PORT_COST_AMT / DECODE(CNTR_QTY, 0, 1 ,CNTR_QTY)) * DECODE(@[cntr_qty], 0, 1 ,@[cntr_qty])" ).append("\n"); 
		query.append(",	UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	REPO_PLN_ID	= @[repo_pln_id]" ).append("\n"); 
		query.append("AND	PLN_YRWK	= @[pln_yrwk]" ).append("\n"); 
		query.append("AND	PLN_SEQ		= @[pln_seq]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD= @[cntr_tpsz_cd]" ).append("\n"); 

	}
}