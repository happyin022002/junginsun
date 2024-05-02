/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlCntrMfDescRSQL.java
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

public class IsraelCustomsTransmissionDBDAOsearchBlCntrMfDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCntrMfDesc
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlCntrMfDescRSQL(){
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
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlCntrMfDescRSQL").append("\n"); 
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
		query.append("   MF.PCK_TP_CD AS D_PUNIT" ).append("\n"); 
		query.append(" , MF.PCK_QTY   AS D_PKG" ).append("\n"); 
		query.append(" , ''           AS D_WGT" ).append("\n"); 
		query.append(" , MF.MEAS_QTY  AS D_MEAS" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(MF.CNTR_MF_MK_DESC,'X') AS D_DESC" ).append("\n"); 
		query.append(" , ''           AS D_MARK" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" , BK.VSL_CD,   BK.SKD_VOY_NO,  BK.SKD_DIR_CD" ).append("\n"); 
		query.append(" , BK.BL_NO,    BK.POL_CD,      MF.CNTR_NO,     MF.CNTR_MF_SEQ" ).append("\n"); 
		query.append(" , MF.PCK_QTY,  MF.CNTR_MF_MK_DESC,     MF.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(" , MF.PCK_TP_CD,    MF.MEAS_QTY" ).append("\n"); 
		query.append(" , BK.CRE_USR_ID,   BK.CRE_DT,  BK.UPD_USR_ID,  BK.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   , BKG_CNTR_MF_DESC MF " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = MF.BKG_NO" ).append("\n"); 
		query.append("AND BK.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND MF.CNTR_NO    = @[cntr_no]" ).append("\n"); 

	}
}