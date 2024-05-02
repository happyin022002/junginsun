/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseInfoForCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.10
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.09.10 최도순
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchIdaDoRlseInfoForCopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI-BKG-0680 India Cargo Release - inquery india custms info
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchIdaDoRlseInfoForCopyRSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOsearchIdaDoRlseInfoForCopyRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC ( XX XPKBKG_DO ) */" ).append("\n"); 
		query.append("       BKG_NO" ).append("\n"); 
		query.append("     , DO_NO" ).append("\n"); 
		query.append("  , DO_NO_SPLIT" ).append("\n"); 
		query.append("  , 'N' AS CUST_PRN_FLG" ).append("\n"); 
		query.append("  , 'N' AS SELF_TRNS_FLG" ).append("\n"); 
		query.append("     , HBL_NO" ).append("\n"); 
		query.append("  , RCVR_CNEE_NM" ).append("\n"); 
		query.append("  , RCVR_CO_NM" ).append("\n"); 
		query.append("  , RCVR_PHN_NO" ).append("\n"); 
		query.append("  , PIC_NM" ).append("\n"); 
		query.append("  , RCVR_EML" ).append("\n"); 
		query.append("     , RCVR_FAX_NO" ).append("\n"); 
		query.append("     , DO_PRN_RMK" ).append("\n"); 
		query.append("FROM BKG_DO XX" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 

	}
}