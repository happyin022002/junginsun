/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOcheckGenDoDischLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOcheckGenDoDischLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkGenDoDischLoc
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOcheckGenDoDischLocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOcheckGenDoDischLocRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SCNT.CONTI_CD='E'" ).append("\n"); 
		query.append("OR CNT.CNT_CD='KR'" ).append("\n"); 
		query.append("OR CNT.CNT_CD='JP'" ).append("\n"); 
		query.append("OR CNT.CNT_CD='US'" ).append("\n"); 
		query.append("OR CNT.CNT_CD='IN' THEN 'N'" ).append("\n"); 
		query.append("ELSE 'Y' END isDishLoc" ).append("\n"); 
		query.append("FROM MDM_COUNTRY CNT," ).append("\n"); 
		query.append("MDM_SUBCONTINENT SCNT" ).append("\n"); 
		query.append("WHERE CNT.CNT_CD    = @[cnt_cd]" ).append("\n"); 
		query.append("AND CNT.SCONTI_CD = SCNT.SCONTI_CD" ).append("\n"); 

	}
}