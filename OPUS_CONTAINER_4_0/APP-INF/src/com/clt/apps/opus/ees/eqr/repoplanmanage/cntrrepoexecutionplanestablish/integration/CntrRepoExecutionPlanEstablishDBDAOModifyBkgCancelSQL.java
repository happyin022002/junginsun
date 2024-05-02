/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.22
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2014.09.22 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_CTRL_MTY_BKG_EXE 테이블의 BKG_STS_CD 컬럼 = 'X'
	  * </pre>
	  */
	public CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelSQL(){
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
		query.append("FileName : CntrRepoExecutionPlanEstablishDBDAOModifyBkgCancelSQL").append("\n"); 
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
		query.append("UPDATE EQR_CTRL_MTY_BKG_EXE" ).append("\n"); 
		query.append("SET BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("   ,UPD_USR_ID = @[usr_id] " ).append("\n"); 
		query.append("   ,UPD_DT	   = SYSDATE " ).append("\n"); 
		query.append("WHERE MTY_BKG_NO = @[mty_bkg_no]" ).append("\n"); 

	}
}