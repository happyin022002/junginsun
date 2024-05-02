/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlDgCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsearchBlDgCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlDgCgo
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlDgCgoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlDgCgoRSQL").append("\n"); 
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
		query.append("   DG.IMDG_UN_NO    AS UNNBR" ).append("\n"); 
		query.append(" , DG.IMDG_CLSS_CD  AS CLASS_CD" ).append("\n"); 
		query.append(" , BC.PCK_QTY       AS D_PKG" ).append("\n"); 
		query.append(" , NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("             WHERE AA.CNT_CD = 'IL'" ).append("\n"); 
		query.append("               AND AA.PCK_TP_CD = BC.PCK_TP_CD" ).append("\n"); 
		query.append("           ),BC.PCK_TP_CD)     AS D_PKGUNIT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , DG.GRS_WGT       AS GWGT" ).append("\n"); 
		query.append(" , DG.WGT_UT_CD     AS GWGT_UNIT" ).append("\n"); 
		query.append(" , DG.MEAS_QTY      AS MEA" ).append("\n"); 
		query.append(" , DG.MEAS_UT_CD    AS MEA_UNIT" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" , BK.VSL_CD,       BK.SKD_VOY_NO,  BK.SKD_DIR_CD" ).append("\n"); 
		query.append(" , BK.BL_NO,        BK.POL_CD,      BC.CNTR_NO,     DG.DCGO_SEQ" ).append("\n"); 
		query.append(" , DG.IMDG_UN_NO,   DG.IMDG_UN_NO_SEQ,  DG.GRS_WGT, DG.IMDG_CLSS_CD" ).append("\n"); 
		query.append(" , BC.PCK_QTY,      BC.PCK_TP_CD" ).append("\n"); 
		query.append(" , BK.CRE_USR_ID,   BK.CRE_DT,      BK.UPD_USR_ID,  BK.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   , BKG_CONTAINER BC" ).append("\n"); 
		query.append("   , BKG_DG_CGO DG" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BC.BKG_NO = DG.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = DG.CNTR_NO" ).append("\n"); 
		query.append("AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND DG.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}