/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.12.02 이행지
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

public class CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * - BKG/DOC 에서 BKG CANCEL 한 데이터에 대해 수정
	  * - BKG_NO, BKG_NO_SPLIT, BKG_fLAG, BKG_SPLIT_FLAG 모두 CLEAR
	  * -수정자 정보는 BKG/DOC에서 추출, 수정일은 SYSDATE
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelUSQL(){
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration").append("\n"); 
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelUSQL").append("\n"); 
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
		query.append("UPDATE	${table_name} SET" ).append("\n"); 
		query.append("REPO_MTY_BKG_FLG	= ''" ).append("\n"); 
		query.append(",	MTY_BKG_NO			= ''" ).append("\n"); 
		query.append("#if (${gubun} == 'V')" ).append("\n"); 
		query.append(",	SPLIT_REPO_PLN_FLG	= 'N'" ).append("\n"); 
		query.append(",	OLD_BKG_GRP_NO		= ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID			= @[usr_id]" ).append("\n"); 
		query.append(",	UPD_DT				= SYSDATE" ).append("\n"); 
		query.append("WHERE	MTY_BKG_NO = @[mty_bkg_no]" ).append("\n"); 

	}
}