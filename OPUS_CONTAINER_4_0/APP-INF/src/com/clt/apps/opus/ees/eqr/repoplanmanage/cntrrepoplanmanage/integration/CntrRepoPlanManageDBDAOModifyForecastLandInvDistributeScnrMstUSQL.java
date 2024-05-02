/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAOModifyForecastLandInvDistributeScnrMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrRepoPlanManageDBDAOModifyForecastLandInvDistributeScnrMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * <EES_EQR_0045 컨테이너 이송 계획 목록 조회>
	  * EQR_SCNR_MST 테이블에 distribute = Y 로 수정
	  * 
	  * <Change History>
	  * 1	2009.08.20	Lee ByoungHun	최초작성
	  * </pre>
	  */
	public CntrRepoPlanManageDBDAOModifyForecastLandInvDistributeScnrMstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repoPlnId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("updUsrId",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration").append("\n"); 
		query.append("FileName : CntrRepoPlanManageDBDAOModifyForecastLandInvDistributeScnrMstUSQL").append("\n"); 
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
		query.append("UPDATE EQR_SCNR_MST" ).append("\n"); 
		query.append("SET  REPO_PLN_DTRB_FLG = 'Y'" ).append("\n"); 
		query.append(", UPD_USR_ID 		 = @[updUsrId]" ).append("\n"); 
		query.append(", UPD_DT 			 = SYSDATE" ).append("\n"); 
		query.append("WHERE SCNR_ID = (" ).append("\n"); 
		query.append("SELECT SCNR_ID FROM EQR_EQ_REPO_PLN" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = @[repoPlnId]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}