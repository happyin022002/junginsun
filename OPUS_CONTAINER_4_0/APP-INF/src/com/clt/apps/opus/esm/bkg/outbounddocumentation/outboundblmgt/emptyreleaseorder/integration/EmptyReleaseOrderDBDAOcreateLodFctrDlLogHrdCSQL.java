/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOcreateLodFctrDlLogHrdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.21
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.09.21 이도형
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

public class EmptyReleaseOrderDBDAOcreateLodFctrDlLogHrdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyReleaseOrderDBDAOcreateLodFctrDlLogHrdCSQL
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOcreateLodFctrDlLogHrdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : EmptyReleaseOrderDBDAOcreateLodFctrDlLogHrdCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_LOD_FCTR_DL_LOG_HDR (" ).append("\n"); 
		query.append("            LDF_DL_DT" ).append("\n"); 
		query.append("          , BKG_OFC_CD" ).append("\n"); 
		query.append("          , FILE_DL_NM" ).append("\n"); 
		query.append("          , FILE_DL_FLG" ).append("\n"); 
		query.append("          , BKG_FM_DT" ).append("\n"); 
		query.append("          , BKG_TO_DT" ).append("\n"); 
		query.append("          , CRE_USR_ID" ).append("\n"); 
		query.append("          , CRE_DT" ).append("\n"); 
		query.append("          , UPD_USR_ID" ).append("\n"); 
		query.append("          , UPD_DT )" ).append("\n"); 
		query.append("     VALUES (" ).append("\n"); 
		query.append("            TO_DATE(@[ldf_dl_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("          , @[bkg_ofc_cd]" ).append("\n"); 
		query.append("          , @[file_dl_nm]" ).append("\n"); 
		query.append("          , @[file_dl_flg]" ).append("\n"); 
		query.append("          , TO_DATE(@[bkg_fm_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("          , TO_DATE(@[bkg_to_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("          , @[usr_id]" ).append("\n"); 
		query.append("          , SYSDATE" ).append("\n"); 
		query.append("          , @[usr_id]" ).append("\n"); 
		query.append("          , SYSDATE     " ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}