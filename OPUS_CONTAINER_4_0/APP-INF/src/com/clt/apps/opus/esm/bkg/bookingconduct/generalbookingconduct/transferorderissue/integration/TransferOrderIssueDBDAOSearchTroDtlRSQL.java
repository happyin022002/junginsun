/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchTroDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.04.28 Maeda Atsushi
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

public class TransferOrderIssueDBDAOSearchTroDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_BKG_0079_02A TroDtl
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchTroDtlRSQL(){
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
		query.append("FileName : TransferOrderIssueDBDAOSearchTroDtlRSQL").append("\n"); 
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
		query.append("SELECT DTL.TRO_SEQ " ).append("\n"); 
		query.append("        , DTL.TRO_SUB_SEQ" ).append("\n"); 
		query.append("        , 'N' DEL " ).append("\n"); 
		query.append("        , NVL(DTL.CXL_FLG, 'N') CXL_FLG" ).append("\n"); 
		query.append("        , NVL(DTL.CXL_FLG, 'N') CXL_FLG_OLD" ).append("\n"); 
		query.append("        , DTL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , DECODE(DTL.TRO_QTY, '0', '', DTL.TRO_QTY) TRO_QTY" ).append("\n"); 
		query.append("        , DTL.CNTR_TPSZ_CD CNTR_TPSZ_CD_OLD " ).append("\n"); 
		query.append("        , DECODE(DTL.TRO_QTY, '0', '', DTL.TRO_QTY) TRO_QTY_OLD " ).append("\n"); 
		query.append("        , TO_CHAR(DTL.DOR_ARR_DT, 'YYYY-MM-DD') DOR_ARR_DT " ).append("\n"); 
		query.append("        , TO_CHAR(DTL.DOR_ARR_DT, 'HH24:MI') DOR_ARR_DT_HHMI " ).append("\n"); 
		query.append("        , TO_CHAR(DTL.PKUP_DT, 'YYYY-MM-DD') PKUP_DT " ).append("\n"); 
		query.append("        , TO_CHAR(DTL.PKUP_DT, 'HH24:MI') PKUP_DT_HHMI " ).append("\n"); 
		query.append("        , DTL.PKUP_LOC_CD" ).append("\n"); 
		query.append("        , SUBSTR(DTL.PKUP_YD_CD, 6, 2) PKUP_YD_CD " ).append("\n"); 
		query.append("        , DTL.RTN_LOC_CD" ).append("\n"); 
		query.append("        , SUBSTR(DTL.RTN_YD_CD, 6, 2) RTN_YD_CD " ).append("\n"); 
		query.append("        , DTL.CMDT_CD" ).append("\n"); 
		query.append("        , (SELECT CMD.CMDT_NM FROM MDM_COMMODITY CMD WHERE CMD.CMDT_CD = DTL.CMDT_CD) CMDT_NM " ).append("\n"); 
		query.append("        , DTL.CNTR_NO  " ).append("\n"); 
		query.append("		, SO.TRSP_SO_OFC_CTY_CD||SO.TRSP_SO_SEQ TRSP_SO_NO" ).append("\n"); 
		query.append("		, TO_CHAR(SO.CRE_DT, 'YYYY-MM-DD') SO_CRE_DT" ).append("\n"); 
		query.append("		, SO.CRE_USR_ID SO_CRE_USR_ID" ).append("\n"); 
		query.append("		, (SELECT USR_NM FROM COM_USER WHERE USR_ID = SO.CRE_USR_ID) SO_USR_NM" ).append("\n"); 
		query.append("		, DECODE(NVL(SO.TRSP_FRST_FLG, ' '), 'Y', 'Frustrate', 'N', '', '') FR_FLG" ).append("\n"); 
		query.append("        , DTL.SPLIT_RMK " ).append("\n"); 
		query.append("        , SO.TRSP_WO_OFC_CTY_CD||SO.TRSP_WO_SEQ AS TRSP_WO_NO" ).append("\n"); 
		query.append("        , SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("        , SO.TRSP_WO_SEQ " ).append("\n"); 
		query.append("        , UPPER(DTL.UPD_USR_ID) UPD_USR_ID_OLD" ).append("\n"); 
		query.append("        , TO_CHAR(DTL.UPD_DT, 'YYYY/MM/DD HH24:MI:SS') UPD_DT_OLD" ).append("\n"); 
		query.append("        , (SELECT MAP.COP_NO " ).append("\n"); 
		query.append("           FROM   SCE_TRO_MAPG MAP" ).append("\n"); 
		query.append("           WHERE  0=0" ).append("\n"); 
		query.append("           AND    MAP.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("           AND    MAP.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("           AND    MAP.TRO_SEQ = DTL.TRO_SEQ" ).append("\n"); 
		query.append("           AND    MAP.TRO_SUB_SEQ = DTL.TRO_SUB_SEQ" ).append("\n"); 
		query.append("           AND    ROWNUM = 1" ).append("\n"); 
		query.append("           ) COP_NO" ).append("\n"); 
		query.append("        , (SELECT RAIL.TRSP_SO_OFC_CTY_CD || RAIL.TRSP_SO_SEQ RAIL_SO" ).append("\n"); 
		query.append("           FROM   SCE_TRO_MAPG MAP ,TRS_TRSP_RAIL_BIL_ORD RAIL" ).append("\n"); 
		query.append("           WHERE  0=0" ).append("\n"); 
		query.append("           AND    MAP.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("           AND    MAP.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("           AND    MAP.TRO_SEQ = DTL.TRO_SEQ" ).append("\n"); 
		query.append("           AND    MAP.TRO_SUB_SEQ = DTL.TRO_SUB_SEQ" ).append("\n"); 
		query.append("           AND    RAIL.BKG_NO = MAP.BKG_NO" ).append("\n"); 
		query.append("           AND    RAIL.COP_NO = MAP.COP_NO" ).append("\n"); 
		query.append("           AND    RAIL.TRSP_BND_CD = MAP.IO_BND_CD" ).append("\n"); 
		query.append("           AND    RAIL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND    NVL(RAIL.TRSP_FRST_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("           AND    RAIL.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("           AND    ROWNUM = 1" ).append("\n"); 
		query.append("           ) RAIL_SO" ).append("\n"); 
		query.append("  FROM BKG_TRO_DTL DTL" ).append("\n"); 
		query.append("       , TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(" WHERE DTL.BKG_NO      = @[bkg_no] " ).append("\n"); 
		query.append("   AND DTL.IO_BND_CD   = @[io_bnd_cd]  " ).append("\n"); 
		query.append("   AND DTL.RTN_TRO_FLG = @[rtn_tro_flg]  " ).append("\n"); 
		query.append("   AND DTL.BKG_NO      = SO.BKG_NO(+)" ).append("\n"); 
		query.append("   AND DTL.IO_BND_CD   = SO.TRSP_BND_CD(+)" ).append("\n"); 
		query.append("   AND DTL.TRO_SEQ     = SO.TRO_SEQ(+)" ).append("\n"); 
		query.append("   AND DTL.TRO_SUB_SEQ = SO.TRO_SUB_SEQ(+)" ).append("\n"); 
		query.append("   AND 'N'             = SO.DELT_FLG(+)" ).append("\n"); 
		query.append("--   AND 'N'             = SO.TRSP_FRST_FLG(+)" ).append("\n"); 
		query.append("   AND 'DR'            = SO.TRSP_COST_DTL_MOD_CD(+)" ).append("\n"); 
		query.append(" ORDER BY DTL.TRO_SEQ, DTL.TRO_SUB_SEQ" ).append("\n"); 

	}
}