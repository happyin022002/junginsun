/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.06.17 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelCustomsTransmissionDBDAOsearchBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCntr
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlCntrRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   BC.CNTR_NO   AS CNTRNBR" ).append("\n"); 
		query.append(" , ''           AS FM_IND" ).append("\n"); 
		query.append(" , BC.PCK_TP_CD     AS PUNIT" ).append("\n"); 
		query.append(" , BC.PCK_QTY       AS PKG" ).append("\n"); 
		query.append(" , BC.CNTR_WGT      AS CNTRWGT" ).append("\n"); 
		query.append(" , ''               AS CNTRGWGT" ).append("\n"); 
		query.append(" , BC.WGT_UT_CD     AS CNTR_WGT_UNIT" ).append("\n"); 
		query.append(" , BC.CNTR_TPSZ_CD  AS CNTRTYPE" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(BD.CNTR_CMDT_DESC,'X') AS CMDT_DESC" ).append("\n"); 
		query.append(" , ''           AS CMDTCD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" , BK.VSL_CD,   BK.SKD_VOY_NO,  BK.SKD_DIR_CD" ).append("\n"); 
		query.append(" , BK.BL_NO,    BC.CNTR_NO" ).append("\n"); 
		query.append(" , '' FULL_MTY_CD,  BC.PCK_QTY, BC.PCK_TP_CD" ).append("\n"); 
		query.append(" , BC.MEAS_QTY,     BC.MEAS_UT_CD" ).append("\n"); 
		query.append(" , BC.CNTR_WGT,     BC.WGT_UT_CD" ).append("\n"); 
		query.append(" , BC.CNTR_TPSZ_CD, BD.CNTR_CMDT_DESC" ).append("\n"); 
		query.append(" , BK.CRE_USR_ID,   BK.CRE_DT,  BK.UPD_USR_ID,  BK.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   , BKG_BL_DOC BD" ).append("\n"); 
		query.append("   , BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BL_NO  = @[bl_no]" ).append("\n"); 

	}
}