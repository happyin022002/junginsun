/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlCMinfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.06.17 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsearchBlCMinfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCMinfo
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlCMinfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlCMinfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("   ROW_NUMBER() OVER (ORDER BY MF.CNTR_NO, MF.CNTR_MF_SEQ)  AS GOODS_ITEM_NO" ).append("\n"); 
		query.append(" , 'A'  AS CM_FLAG" ).append("\n"); 
		query.append(" , ''   AS PIECE_COUNT" ).append("\n"); 
		query.append(" , MF.PCK_QTY       AS PKG_COUNT" ).append("\n"); 
		query.append(" , MF.PCK_TP_CD     AS PKG_TYPE" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(MF.CNTR_MF_GDS_DESC,'X') AS GOODS_DESC" ).append("\n"); 
		query.append(" , MF.CNTR_MF_WGT   AS ITEM_GROSS_WGT" ).append("\n"); 
		query.append(" , MF.CMDT_HS_CD    AS TARIFF_CD" ).append("\n"); 
		query.append(" , (SELECT IMDG_UN_NO" ).append("\n"); 
		query.append("      FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND DG.BKG_NO       = BK.BKG_NO        " ).append("\n"); 
		query.append("       AND DG.CNTR_NO      = MF.CNTR_NO" ).append("\n"); 
		query.append("       AND DG.DCGO_SEQ     = NVL(MF.DCGO_SEQ,DCGO_SEQ)" ).append("\n"); 
		query.append("       AND ROWNUM=1" ).append("\n"); 
		query.append("   ) AS UNDG_NO" ).append("\n"); 
		query.append("  , ''          AS HANDLE_CD" ).append("\n"); 
		query.append("  , ''          AS HANDLE_INFO" ).append("\n"); 
		query.append("  , MF.CNTR_NO  AS CM_CNTR_NO" ).append("\n"); 
		query.append("  , MF.PCK_QTY  AS CM_CNTR_PKG" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  , BKG_SPCLCHAR_CONV_FNC(MF.CNTR_MF_MK_DESC,'X') AS CM_SHIP_MARK" ).append("\n"); 
		query.append("  , BK.VSL_CD,      BK.SKD_VOY_NO,      BK.SKD_DIR_CD,      BK.BL_NO,  BK.POL_CD" ).append("\n"); 
		query.append("  , MF.CNTR_NO,     MF.CNTR_MF_SEQ" ).append("\n"); 
		query.append("  , MF.PCK_QTY,     MF.CNTR_MF_MK_DESC, MF.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("  , MF.PCK_TP_CD,   MF.MEAS_QTY" ).append("\n"); 
		query.append("  , MF.CNTR_MF_WGT, MF.WGT_UT_CD,   MF.MEAS_UT_CD,  MF.CMDT_HS_CD,  MF.DCGO_SEQ " ).append("\n"); 
		query.append("  , BK.CRE_USR_ID,  BK.CRE_DT,      BK.UPD_USR_ID,  BK.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   , BKG_CNTR_MF_DESC MF " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("AND BK.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X' FROM BKG_CONTAINER C" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("             AND C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("             AND C.CNTR_NO = MF.CNTR_NO)" ).append("\n"); 

	}
}