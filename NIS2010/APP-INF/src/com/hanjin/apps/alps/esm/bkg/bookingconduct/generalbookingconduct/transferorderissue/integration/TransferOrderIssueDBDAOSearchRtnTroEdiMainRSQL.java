/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchRtnTroEdiMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchRtnTroEdiMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchRtnTroEdiMain
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchRtnTroEdiMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchRtnTroEdiMainRSQL").append("\n"); 
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
		query.append("SELECT --'BRAC:'      || DECODE(NVL(TRO.CXL_FLG,0),1,1,9) || CHR(10) ||" ).append("\n"); 
		query.append("       'BRAC:'      || DECODE(NVL(TRO.CXL_FLG,'N'),'Y','1','9') || CHR(10) ||" ).append("\n"); 
		query.append("       'BKG_NO:'    || RPAD(BK.BKG_NO, 13)              || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_CD:'    || BK.VSL_CD                        || CHR(10) ||" ).append("\n"); 
		query.append("       'VSL_NAME:'  || VSL.VSL_ENG_NM                   || CHR(10) ||" ).append("\n"); 
		query.append("       'VOY_NO:'    || BK.SKD_VOY_NO                    || CHR(10) ||" ).append("\n"); 
		query.append("       'VOY_DIR:'   || BK.SKD_DIR_CD                    || CHR(10) ||" ).append("\n"); 
		query.append("       'CALL_SIGN:' || VSL.CALL_SGN_NO                  || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_CD:'    || BK.POL_CD                        || CHR(10) ||" ).append("\n"); 
		query.append("       'POL_NM:'    || POL.LOC_NM                       || CHR(10) ||" ).append("\n"); 
		query.append("       'SHIPPER:'   || REPLACE(REPLACE(REPLACE(SH.CUST_NM,CHR(13)||CHR(10), ''),CHR(13),' '),CHR(10),' ') || CHR(10) ||" ).append("\n"); 
		query.append("       'SOC:'   	|| NVL(BK.SOC_FLG, 'N') || CHR(10) str_flatfile" ).append("\n"); 
		query.append("  FROM BKG_TRO_DTL TRO" ).append("\n"); 
		query.append("        , BKG_BOOKING BK" ).append("\n"); 
		query.append("        , MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("        , MDM_LOCATION POL" ).append("\n"); 
		query.append("        , BKG_CUSTOMER SH" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO        = TRO.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO        = SH.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'S'              = SH.BKG_CUST_TP_CD (+)     " ).append("\n"); 
		query.append("   AND BK.VSL_CD        = VSL.VSL_CD" ).append("\n"); 
		query.append("   AND BK.POL_CD        = POL.LOC_CD(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("   AND TRO.IO_BND_CD    = 'O'" ).append("\n"); 
		query.append("   AND TRO.RTN_TRO_FLG  = @[rtn_tro_flg]" ).append("\n"); 
		query.append("   AND TRO.TRO_SEQ      = @[tro_seq]" ).append("\n"); 

	}
}