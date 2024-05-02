/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchBkgEuPinNoHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.20 
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

public class CargoReleaseOrderDBDAOsearchBkgEuPinNoHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Bkg_eu_pin_no 테이블에서 히스토리를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchBkgEuPinNoHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchBkgEuPinNoHisRSQL").append("\n"); 
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
		query.append("SELECT   A.BKG_NO" ).append("\n"); 
		query.append("       , A.CNTR_NO" ).append("\n"); 
		query.append("       , A.RLSE_ORD_SEQ" ).append("\n"); 
		query.append("       , A.RLSE_ORD_SUB_SEQ" ).append("\n"); 
		query.append("       , A.PIN_NO" ).append("\n"); 
		query.append("       , A.SND_FLG" ).append("\n"); 
		query.append("       , A.UPD_USR_ID" ).append("\n"); 
		query.append("       , B.USR_NM AS UPD_USR_NM" ).append("\n"); 
		query.append("       , TO_CHAR(A.UPD_DT, 'YYYY-MM-DD HH24:MI:SS') AS UPD_DT" ).append("\n"); 
		query.append("--       , RANK() OVER(ORDER BY A.UPD_DT DESC) AS SEQ" ).append("\n"); 
		query.append("  FROM BKG_EU_PIN_NO A, COM_USER B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.UPD_USR_ID = B.USR_ID (+)" ).append("\n"); 
		query.append(" ORDER BY A.UPD_DT DESC" ).append("\n"); 

	}
}