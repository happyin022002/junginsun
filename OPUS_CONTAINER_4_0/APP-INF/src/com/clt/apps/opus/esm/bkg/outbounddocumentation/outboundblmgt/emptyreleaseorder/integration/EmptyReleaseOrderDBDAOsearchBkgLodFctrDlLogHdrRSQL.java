/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.16
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.10.16 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogHdrRSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogHdrRSQL(){
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
		query.append("FileName : EmptyReleaseOrderDBDAOsearchBkgLodFctrDlLogHdrRSQL").append("\n"); 
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
		query.append("     , FILE_DL_NM" ).append("\n"); 
		query.append("     , FILE_DL_FLG" ).append("\n"); 
		query.append("     , TO_CHAR(BKG_FM_DT, 'YYYY-MM-DD HH24:MI:SS') AS BKG_FM_DT" ).append("\n"); 
		query.append("     , TO_CHAR(BKG_TO_DT, 'YYYY-MM-DD HH24:MI:SS') AS BKG_TO_DT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , EDW_UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_LOD_FCTR_DL_LOG_HDR" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append(" #if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${ldf_dl_dt} != '')" ).append("\n"); 
		query.append("   AND TO_CHAR(LDF_DL_DT, 'YYYY-MM-DD') = @[ldf_dl_dt]" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" ORDER BY LDF_DL_DT DESC" ).append("\n"); 

	}
}