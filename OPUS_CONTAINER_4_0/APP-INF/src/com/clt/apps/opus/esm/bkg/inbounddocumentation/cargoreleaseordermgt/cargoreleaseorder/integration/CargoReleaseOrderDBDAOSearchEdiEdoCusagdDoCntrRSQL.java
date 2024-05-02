/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.22 
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

public class CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking Container 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdiEdoCusagdDoCntrRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_INFO'                                      || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTR_NO:'   || CNTR_NO                          || CHR(10)" ).append("\n"); 
		query.append("      ||'CNTRTS_CD:' || CNTR_TPSZ_CD                     || CHR(10)" ).append("\n"); 
		query.append("      ||'FT_END_DT:' || TO_CHAR(BKG_FREE_TIME_END_DT_FNC(BKG_NO),'YYYYMMDD') || CHR(10)" ).append("\n"); 
		query.append("      ||'}CNTR_INFO' || CHR(10)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER  " ).append("\n"); 
		query.append("WHERE BKG_NO=@[bkg_no]" ).append("\n"); 

	}
}