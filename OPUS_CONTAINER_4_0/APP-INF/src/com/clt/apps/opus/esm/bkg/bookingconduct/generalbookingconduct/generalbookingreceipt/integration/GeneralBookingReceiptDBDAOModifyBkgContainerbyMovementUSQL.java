/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgContainerbyMovementUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyBkgContainerbyMovementUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Movement 정보를 Update한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgContainerbyMovementUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgContainerbyMovementUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER BC" ).append("\n"); 
		query.append("SET (BC.CNMV_YR, BC.CNMV_ID_NO, BC.CNMV_CYC_NO, BC.CNMV_STS_CD, BC.CNMV_EVNT_DT, BC.ORG_YD_CD)" ).append("\n"); 
		query.append("                = ( SELECT " ).append("\n"); 
		query.append("                                SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '0000'))||CM.CNMV_SPLIT_NO||CM.CNMV_YR), 10, 12) AS CNMV_YR" ).append("\n"); 
		query.append("                              , SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '0000'))||CM.CNMV_SPLIT_NO||CM.CNMV_ID_NO), 10, 12) AS CNMV_ID_NO" ).append("\n"); 
		query.append("                              , SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '0000'))||CM.CNMV_SPLIT_NO||CM.CNMV_CYC_NO), 10, 12) AS CNMV_CYC_NO" ).append("\n"); 
		query.append("                              , SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '0000'))||CM.CNMV_SPLIT_NO||CM.MVMT_STS_CD), 10, 12) AS MVMT_STS_CD" ).append("\n"); 
		query.append("                              , TO_DATE(SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '0000'))||CM.CNMV_SPLIT_NO||TRIM(TO_CHAR(CM.CNMV_EVNT_DT, 'YYYYMMDDHH24MISS'))), 10, 22), 'YYYYMMDDHH24MISS') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("                              , SUBSTR(MAX(CM.CNMV_YR||TRIM(TO_CHAR(CM.CNMV_SEQ, '0000'))||CM.CNMV_SPLIT_NO||CM.INP_YD_CD), 10, 12) AS INP_YD_CD" ).append("\n"); 
		query.append("                      FROM  CTM_MOVEMENT CM" ).append("\n"); 
		query.append("                     WHERE CM.BKG_NO   = BC.BKG_NO" ).append("\n"); 
		query.append("                     AND    CM.CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("                     GROUP BY CM.BKG_NO, CM.CNTR_NO)" ).append("\n"); 
		query.append("WHERE  BC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                      FROM  CTM_MOVEMENT CM" ).append("\n"); 
		query.append("                     WHERE   CM.BKG_NO   =  BC.BKG_NO" ).append("\n"); 
		query.append("                        AND   CM.CNTR_NO =  BC.CNTR_NO " ).append("\n"); 
		query.append("                        AND   ROWNUM = 1 )" ).append("\n"); 

	}
}