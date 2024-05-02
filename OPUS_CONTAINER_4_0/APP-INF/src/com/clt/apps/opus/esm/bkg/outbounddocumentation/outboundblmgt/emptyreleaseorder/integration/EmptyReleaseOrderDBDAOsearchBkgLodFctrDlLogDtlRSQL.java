/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.03.03 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogDtlRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ldf_dl_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogDtlRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(LDF_DL_DT, 'YYYY-MM-DD HH24:MI:SS') AS LDF_DL_DT" ).append("\n"); 
		query.append("     , BKG_OFC_CD" ).append("\n"); 
		query.append("     , BKG_NO" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append(" FROM BKG_LOD_FCTR_DL_LOG_DTL" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append(" #if (${ldf_dl_dt} != '')" ).append("\n"); 
		query.append("  AND LDF_DL_DT = TO_DATE(@[ldf_dl_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 

	}
}