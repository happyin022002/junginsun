/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCalculationDBDAOSearchCalculationBookingContainerUcFlagBlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOSearchCalculationBookingContainerUcFlagBlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAOSearchCalculationBookingContainerUcFlagBlNoRSQL
	  * </pre>
	  */
	public ChargeCalculationDBDAOSearchCalculationBookingContainerUcFlagBlNoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOSearchCalculationBookingContainerUcFlagBlNoRSQL").append("\n"); 
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
		query.append("SELECT a.SYS_AREA_GRP_ID as svr_id" ).append("\n"); 
		query.append(", a.CNTR_NO" ).append("\n"); 
		query.append(", a.CNTR_CYC_NO" ).append("\n"); 
		query.append(", a.DMDT_TRF_CD" ).append("\n"); 
		query.append(", a.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(", a.CHG_SEQ" ).append("\n"); 
		query.append(", CASE WHEN NVL2(CIM.UC_CS_NO,'Y','N') != NVL(A.UCLM_FLG,'N') THEN NVL2(CIM.UC_CS_NO,'Y','N') ELSE ' ' END UCLM_FLG" ).append("\n"); 
		query.append(", ( SELECT HNDL_BRNC_CD FROM CIM_UC_CGO WHERE UC_CS_NO = @[uc_cs_no] AND ROWNUM = 1 )AS OFC_CD" ).append("\n"); 
		query.append(", ( SELECT HNDL_HDLR_USR_ID  FROM CIM_UC_CGO WHERE UC_CS_NO = @[uc_cs_no]AND ROWNUM = 1 ) AS USR_ID" ).append("\n"); 
		query.append("FROM CIM_UC_CGO_CNTR CIM, DMT_CHG_CALC A, DMT_CHG_BKG_CNTR B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CIM.CNTR_NO(+) = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = ( SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no] )" ).append("\n"); 
		query.append("AND SUBSTR(A.DMDT_TRF_CD,3,1) = 'I'" ).append("\n"); 
		query.append("AND CIM.UC_CS_NO(+) = @[uc_cs_no]" ).append("\n"); 
		query.append("AND CIM.BL_NO(+) = @[bl_no]" ).append("\n"); 
		query.append("AND CASE WHEN NVL2(CIM.UC_CS_NO,'Y','N') != NVL(A.UCLM_FLG,'N') THEN NVL2(CIM.UC_CS_NO,'Y','N') ELSE ' ' END != ' '" ).append("\n"); 

	}
}