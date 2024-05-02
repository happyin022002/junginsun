/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TotalLossMgtDBDAOcheckCNTRActualDtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOcheckCNTRActualDtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TotalLossMgtDBDAOcheckCNTRActualDtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flag_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration ").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOcheckCNTRActualDtDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    SIGN(TO_DATE(@[flag_dt],'YYYYMMDD') - MAX(NVL(TO_DATE(TO_CHAR(CNMV_EVNT_DT,'YYYYMMDD'),'YYYYMMDD'),TO_DATE(@[flag_dt],'YYYYMMDD')-1)))" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT CM" ).append("\n"); 
		query.append("WHERE CNTR_NO = @[eq_no]" ).append("\n"); 

	}
}