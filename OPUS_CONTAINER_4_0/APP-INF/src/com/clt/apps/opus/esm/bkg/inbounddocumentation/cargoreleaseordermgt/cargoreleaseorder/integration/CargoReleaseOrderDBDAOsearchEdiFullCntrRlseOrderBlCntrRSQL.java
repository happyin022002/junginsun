/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.26 
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

public class CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiFullCntrRlseOrderBlCntr
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiFullCntrRlseOrderBlCntrRSQL").append("\n"); 
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
		query.append("SELECT '{BL_CNTR'                                 ||CHR(10)||" ).append("\n"); 
		query.append("       'HTYP:'    ||BCNTR.CNTR_TPSZ_CD            ||CHR(10)||" ).append("\n"); 
		query.append("       'ITYP:'    || TS.CNTR_TPSZ_ISO_CD          ||CHR(10)||" ).append("\n"); 
		query.append("       'TRAN:'    || NVL(@[dest_trns_mod_cd],'N') ||CHR(10)||      --  화면 입력값 ( T-Mode )" ).append("\n"); 
		query.append("       'CNTR_NO:' || BCNTR.CNTR_NO                ||CHR(10)||" ).append("\n"); 
		query.append("       '}BL_CNTR'                                 || CHR(10) " ).append("\n"); 
		query.append("  FROM BKG_CONTAINER BCNTR, MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append(" WHERE BCNTR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BCNTR.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND BCNTR.CNTR_TPSZ_CD = TS.CNTR_TPSZ_CD" ).append("\n"); 

	}
}