/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOCheckEuDoDischLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOCheckEuDoDischLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EU Cargo Release에서 Discharge Location을 검사한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOCheckEuDoDischLocRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOCheckEuDoDischLocRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[cnt_cd],'EG','Y',DECODE( COUNT(*),0,'N','Y')) as isDishLoc" ).append("\n"); 
		query.append("FROM MDM_COUNTRY CNT," ).append("\n"); 
		query.append("     MDM_SUBCONTINENT SCNT" ).append("\n"); 
		query.append("WHERE CNT.CNT_CD    = @[cnt_cd]" ).append("\n"); 
		query.append("  AND CNT.SCONTI_CD = SCNT.SCONTI_CD" ).append("\n"); 
		query.append("  AND SCNT.CONTI_CD = 'E' " ).append("\n"); 
		query.append("  AND ROWNUM =1" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}