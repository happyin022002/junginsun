/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchCllCntrSpclInstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchCllCntrSpclInstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [BKG] #8811 [1월 반영 추가] Special handling code - COPRAR by 진마리아
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchCllCntrSpclInstRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOsearchCllCntrSpclInstRSQL").append("\n"); 
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
		query.append("SELECT '{SPCL_INST'||CHR(10)||" ).append("\n"); 
		query.append("		'SPCL_CD:'||BHCC.ATTR_CTNT2||CHR(10)||" ).append("\n"); 
		query.append("		'SPCL_DESC:'||BHCC.ATTR_CTNT3||CHR(10)||" ).append("\n"); 
		query.append("	    '}SPCL_INST'||CHR(10) AS CNTR_SPCL_INST" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK, " ).append("\n"); 
		query.append("     BKG_CONTAINER BC, " ).append("\n"); 
		query.append("     BKG_HRD_CDG_CTNT BHCC " ).append("\n"); 
		query.append("WHERE BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND ((BK.AWK_CGO_FLG = 'Y' AND BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 = BC.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("  OR (BK.BB_CGO_FLG = 'Y' AND BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 = 'BK')" ).append("\n"); 
		query.append("  OR (BHCC.HRD_CDG_ID = 'VNDR301_INSTRUCT' AND BHCC.ATTR_CTNT1 IN (SELECT BSC.STWG_CD FROM BKG_STWG_CGO BSC WHERE BSC.BKG_NO = BK.BKG_NO)))" ).append("\n"); 

	}
}