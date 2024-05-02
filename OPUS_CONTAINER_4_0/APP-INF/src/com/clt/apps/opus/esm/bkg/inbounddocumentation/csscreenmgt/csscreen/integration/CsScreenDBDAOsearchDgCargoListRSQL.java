/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchDgCargoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchDgCargoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CsScreenDBDAOsearchDgCargoListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchDgCargoListRSQL").append("\n"); 
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
		query.append("SELECT LPAD(A.CNTR_CGO_SEQ, 3, '0') AS CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,A.IMDG_UN_NO                 AS IMDG_UN_NO" ).append("\n"); 
		query.append("      ,A.IMDG_CLSS_CD               AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,A.PRP_SHP_NM                 AS PRP_SHP_NM" ).append("\n"); 
		query.append("      ,A.HZD_DESC                   AS HZD_DESC" ).append("\n"); 
		query.append("      ,B.FILE_SAV_ID" ).append("\n"); 
		query.append("      ,B.FILE_NM                    AS FILE_NM" ).append("\n"); 
		query.append("      ,B.FILE_PATH_RMK              AS FILE_PATH_RMK" ).append("\n"); 
		query.append("FROM BKG_DG_CGO A" ).append("\n"); 
		query.append("	,BKG_IMG_STO B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND A.DCGO_SEQ = B.DCGO_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY LPAD(A.CNTR_CGO_SEQ, 3, '0')" ).append("\n"); 

	}
}