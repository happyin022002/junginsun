/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchFeederInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchFeederInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주위험물 - feeder 정보를 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchFeederInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_vsl_lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchFeederInfoListRSQL").append("\n"); 
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
		query.append("SELECT CSTMS_DIV_ID_SEQ SEQ_KEY" ).append("\n"); 
		query.append(", ATTR_CTNT1 FDR_VSL_LLOYD_NO" ).append("\n"); 
		query.append(", ATTR_CTNT2 FDR_VSL_NM" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD = 'BE'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = 'EUR_DG_ANR_BARGE'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID_SEQ > 0" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${fdr_vsl_lloyd_no} != '')" ).append("\n"); 
		query.append("AND ATTR_CTNT1 LIKE @[fdr_vsl_lloyd_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fdr_vsl_nm} != '')" ).append("\n"); 
		query.append("AND ATTR_CTNT2 LIKE @[fdr_vsl_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}