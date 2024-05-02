/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrSealNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15 
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

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderCntrSealNo
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrSealNoRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderCntrSealNoRSQL").append("\n"); 
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
		query.append("SELECT '{CNTR_SEAL_NO'                                               || CHR(10)" ).append("\n"); 
		query.append("           || 'SEAL_TP:'          || BCS.SEAL_PTY_TP_CD             || CHR(10)" ).append("\n"); 
		query.append("           || 'SEAL_NO:'  		   || BCS.CNTR_SEAL_NO               || CHR(10)" ).append("\n"); 
		query.append("           || '}CNTR_SEAL_NO'                  || CHR(10) " ).append("\n"); 
		query.append("FROM (SELECT SEAL_PTY_TP_CD, CNTR_SEAL_NO" ).append("\n"); 
		query.append("        FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("       WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("         AND CNTR_SEAL_SEQ = (SELECT MAX(CNTR_SEAL_SEQ)" ).append("\n"); 
		query.append("                                FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                 AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("     ) BCS" ).append("\n"); 

	}
}