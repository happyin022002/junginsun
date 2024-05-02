/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchEurTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchEurTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchEurTroDtlRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchEurTroDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchEurTroDtlRSQL").append("\n"); 
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
		query.append("SELECT  BKG_NO" ).append("\n"); 
		query.append("        , IO_BND_CD" ).append("\n"); 
		query.append("        , TRO_SEQ" ).append("\n"); 
		query.append("        , TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , DOR_ADDR_TP_CD" ).append("\n"); 
		query.append("		, CASE WHEN @[io_bnd_cd] = 'O' AND LOC_CD IS NULL THEN (SELECT POR_CD FROM BKG_BOOKING BK WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("		  ELSE LOC_CD " ).append("\n"); 
		query.append("		  END DOR_LOC_CD" ).append("\n"); 
		query.append("		, CASE WHEN @[io_bnd_cd] = 'O' AND ZN_CD IS NULL THEN (SELECT SUBSTR(REP_ZN_CD,6,2) FROM MDM_LOCATION MDM, BKG_BOOKING BK WHERE BK.BKG_NO  = @[bkg_no] AND BK.POR_CD = MDM.LOC_CD ) " ).append("\n"); 
		query.append("		  ELSE SUBSTR(ZN_CD, 6, 2)" ).append("\n"); 
		query.append("		  END ZN_CD" ).append("\n"); 
		query.append("        , LOD_REF_NO" ).append("\n"); 
		query.append("        , DOR_ZIP_ID DOR_PST_NO" ).append("\n"); 
		query.append("        , SUBSTR(DOR_ADDR,  1, 50) DOR_ADDR_1" ).append("\n"); 
		query.append("        , SUBSTR(DOR_ADDR, 51, 50) DOR_ADDR_2" ).append("\n"); 
		query.append("        , SUBSTR(DOR_ADDR, 101, 50) DOR_ADDR_3" ).append("\n"); 
		query.append("        , SUBSTR(DOR_ADDR, 151, 50) DOR_ADDR_4" ).append("\n"); 
		query.append("        , TO_CHAR(ARR_DT, 'YYYY-MM-DD') ARR_DT" ).append("\n"); 
		query.append("        , TO_CHAR(ARR_DT, 'HH24:MI') ARR_DT_HHMI" ).append("\n"); 
		query.append("        , CNTC_PSON_NM" ).append("\n"); 
		query.append("        , CNTC_PHN_NO" ).append("\n"); 
		query.append("        , CNTC_EML" ).append("\n"); 
		query.append("  FROM BKG_EUR_TRO_DTL" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 

	}
}