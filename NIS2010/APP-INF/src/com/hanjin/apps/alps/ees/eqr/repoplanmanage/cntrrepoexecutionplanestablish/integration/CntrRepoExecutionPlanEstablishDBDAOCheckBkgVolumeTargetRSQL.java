/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeTargetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.12.01 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeTargetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * fixed plan 수정이 필요한 경우 기본정보를 수집
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeTargetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOCheckBkgVolumeTargetRSQL").append("\n"); 
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
		query.append("SELECT	 PLN.REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN.PLN_YRWK" ).append("\n"); 
		query.append(",PLN.PLN_SEQ" ).append("\n"); 
		query.append(",PLN.REF_ID" ).append("\n"); 
		query.append(",PLN.TRSP_MOD_CD" ).append("\n"); 
		query.append(",PLN.FM_YD_CD" ).append("\n"); 
		query.append(",PLN.TO_YD_CD" ).append("\n"); 
		query.append(",PLN.VSL_CD" ).append("\n"); 
		query.append(",PLN.SKD_VOY_NO" ).append("\n"); 
		query.append(",PLN.SKD_DIR_CD" ).append("\n"); 
		query.append(",QTY.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",QTY.CNTR_QTY" ).append("\n"); 
		query.append("FROM	${qty_table_name} QTY" ).append("\n"); 
		query.append(",(SELECT	 REPO_PLN_ID" ).append("\n"); 
		query.append(",PLN_YRWK" ).append("\n"); 
		query.append(",PLN_SEQ" ).append("\n"); 
		query.append(",REF_ID" ).append("\n"); 
		query.append(",TRSP_MOD_CD" ).append("\n"); 
		query.append(",FM_YD_CD" ).append("\n"); 
		query.append(",TO_YD_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append("FROM	${table_name}" ).append("\n"); 
		query.append("WHERE	MTY_BKG_NO	= @[mty_bkg_no]) PLN" ).append("\n"); 
		query.append("WHERE	PLN.REPO_PLN_ID	= QTY.REPO_PLN_ID" ).append("\n"); 
		query.append("AND	PLN.PLN_YRWK	= QTY.PLN_YRWK" ).append("\n"); 
		query.append("AND	PLN.PLN_SEQ		= QTY.PLN_SEQ" ).append("\n"); 
		query.append("AND	PLN.REF_ID		= QTY.REF_ID" ).append("\n"); 
		query.append("AND	QTY.CNTR_TPSZ_CD= @[cntr_tpsz_cd]" ).append("\n"); 

	}
}