/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOModifyMtyBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.20 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOModifyMtyBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mty Booking Creation 후 테이블에 Mty Booking No. 업데이트 해주기..
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOModifyMtyBkgNoUSQL(){
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
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOModifyMtyBkgNoUSQL").append("\n"); 
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
		query.append("UPDATE ${table_name}" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("MTY_BKG_NO			= @[mty_bkg_no]" ).append("\n"); 
		query.append("#if( ${gubun} == 'V')" ).append("\n"); 
		query.append(",OLD_BKG_GRP_NO		= @[mty_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",REPO_MTY_BKG_FLG	= 'Y'" ).append("\n"); 
		query.append(",UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	REPO_PLN_ID = @[repo_pln_id]" ).append("\n"); 
		query.append("AND	PLN_YRWK	= @[pln_yrwk]" ).append("\n"); 
		query.append("AND	PLN_SEQ		= @[pln_seq]" ).append("\n"); 
		query.append("AND	REF_ID		= @[ref_id]" ).append("\n"); 

	}
}