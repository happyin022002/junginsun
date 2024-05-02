/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : IsraelCustomsTransmissionDBDAOsearchBlCntrSealNoRSQL.java
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

public class IsraelCustomsTransmissionDBDAOsearchBlCntrSealNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlCntrSealNo
	  * </pre>
	  */
	public IsraelCustomsTransmissionDBDAOsearchBlCntrSealNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.integration").append("\n"); 
		query.append("FileName : IsraelCustomsTransmissionDBDAOsearchBlCntrSealNoRSQL").append("\n"); 
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
		query.append("   'SH'             AS SEAL_TYPE" ).append("\n"); 
		query.append(" , SN.CNTR_SEAL_NO  AS SEAL_NBR" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" , BK.VSL_CD,   BK.SKD_VOY_NO,     BK.SKD_DIR_CD,   BK.BL_NO,  BK.POL_CD" ).append("\n"); 
		query.append(" , BC.CNTR_NO,  SN.CNTR_SEAL_SEQ" ).append("\n"); 
		query.append(" , SN.CNTR_SEAL_NO,     SN.SEAL_PTY_TP_CD,  SN.SEAL_PTY_NM,     SN.SEAL_KND_CD" ).append("\n"); 
		query.append(" , BK.CRE_USR_ID,    BK.CRE_DT,     BK.UPD_USR_ID,      BK.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   , BKG_CONTAINER BC" ).append("\n"); 
		query.append("   , BKG_CNTR_SEAL_NO SN" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = SN.BKG_NO" ).append("\n"); 
		query.append("AND BC.CNTR_NO = SN.CNTR_NO" ).append("\n"); 
		query.append("AND BK.BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND BC.CNTR_NO    = @[cntr_no]" ).append("\n"); 

	}
}