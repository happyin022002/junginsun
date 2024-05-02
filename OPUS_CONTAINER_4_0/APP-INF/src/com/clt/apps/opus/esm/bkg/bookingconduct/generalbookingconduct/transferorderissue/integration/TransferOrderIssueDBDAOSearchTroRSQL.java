/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchTroRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.04.25 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchTroRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0079_02a TRO-master
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchTroRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchTroRSQL").append("\n"); 
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
		query.append("SELECT TRO_SEQ" ).append("\n"); 
		query.append("        , BK.RCV_TERM_CD" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.RQST_DT, 'YYYY-MM-DD HH24:MI') RQST_DT " ).append("\n"); 
		query.append("        , TRO.ACT_SHPR_CNT_CD" ).append("\n"); 
		query.append("        , TRO.ACT_SHPR_SEQ" ).append("\n"); 
		query.append("        , TRO.ACT_SHPR_NM" ).append("\n"); 
		query.append("        , TRO.DOR_LOC_CD" ).append("\n"); 
		query.append("        , SUBSTR(TRO.ZN_CD, 6, 2) ZN_CD " ).append("\n"); 
		query.append("        , TRO.DOR_PST_NO" ).append("\n"); 
		query.append("        , TRO.CFM_FLG" ).append("\n"); 
		query.append("        , TRO.CFM_FLG CFM_FLG_OLD" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.CFM_DT, 'YYYY-MM-DD HH24:MI') CFM_DT " ).append("\n"); 
		query.append("        , TRO.ACT_SHPR_ADDR" ).append("\n"); 
		query.append("        , TRO.DIFF_RMK" ).append("\n"); 
		query.append("        , TRO.CNTC_PSON_NM" ).append("\n"); 
		query.append("        , TRO.ACT_SHPR_PHN_NO CNTC_PHN_NO" ).append("\n"); 
		query.append("        , TRO.CNTC_FAX_NO " ).append("\n"); 
		query.append("		, TRO.DRP_AND_PK_FLG" ).append("\n"); 
		query.append("		, TRO.TRI_AXL_REQ_FLG" ).append("\n"); 
		query.append("        , NVL(TRO.CXL_FLG, 'N') CXL_FLG" ).append("\n"); 
		query.append("        , NVL(TRO.CXL_FLG, 'N') CXL_FLG_OLD" ).append("\n"); 
		query.append("        , NVL(TRO.SO_FLG, 'N') SO_FLG" ).append("\n"); 
		query.append("        , NVL(TRO.OWNR_TRK_FLG, 'N') OWNR_TRK_FLG" ).append("\n"); 
		query.append("        , TRO.BIZ_RGST_NO " ).append("\n"); 
		query.append("		--, TRO.CNTC_MPHN_NO" ).append("\n"); 
		query.append("		, TRO.CNTC_MPHN_NO CNTC_MPHN_NO" ).append("\n"); 
		query.append("        , DECODE(TRO.CXL_FLG,'Y','Cancelled'," ).append("\n"); 
		query.append("		  (SELECT /*+ INDEX_DESC (BKG_TRO_XTER_IF XPKBKG_TRO_XTER_IF) */" ).append("\n"); 
		query.append("                  DECODE(TRO.CXL_FLG, 'Y', 'Cancelled', DECODE(XIF.ACK_STS_CD, 'A', 'Success', 'N', 'Error', " ).append("\n"); 
		query.append("                                         'S', 'Success', 'R', 'Error', XIF.ACK_STS_CD))" ).append("\n"); 
		query.append("             FROM BKG_TRO_XTER_IF XIF " ).append("\n"); 
		query.append("            WHERE XIF.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("              AND XIF.IO_BND_CD = TRO.IO_BND_CD" ).append("\n"); 
		query.append("              AND XIF.RTN_TRO_FLG = TRO.RTN_TRO_FLG" ).append("\n"); 
		query.append("              AND XIF.TRO_SEQ = TRO.TRO_SEQ" ).append("\n"); 
		query.append("              AND XIF.IF_SEQ = (SELECT MAX(IF_SEQ) " ).append("\n"); 
		query.append("                                  FROM BKG_TRO_XTER_IF A" ).append("\n"); 
		query.append("                                 WHERE A.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                                   AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                                   AND A.RTN_TRO_FLG = @[rtn_tro_flg]" ).append("\n"); 
		query.append("								   AND A.TRO_SEQ = TRO.TRO_SEQ)" ).append("\n"); 
		query.append("          )) ACK_STS_CD" ).append("\n"); 
		query.append("        , UPPER(TRO.UPD_USR_ID) UPD_USR_ID_OLD" ).append("\n"); 
		query.append("        , TO_CHAR(TRO.UPD_DT, 'YYYY/MM/DD HH24:MI:SS') UPD_DT_OLD" ).append("\n"); 
		query.append("  FROM BKG_TRO TRO, " ).append("\n"); 
		query.append("       BKG_BOOKING BK " ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = TRO.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("   AND TRO.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND TRO.RTN_TRO_FLG = @[rtn_tro_flg] " ).append("\n"); 
		query.append(" ORDER BY TRO.TRO_SEQ" ).append("\n"); 

	}
}