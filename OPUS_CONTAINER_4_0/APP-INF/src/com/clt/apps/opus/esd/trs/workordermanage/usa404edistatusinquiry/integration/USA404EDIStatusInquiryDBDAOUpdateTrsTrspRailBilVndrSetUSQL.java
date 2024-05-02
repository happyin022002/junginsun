/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.07.14 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA RAIL BILLING Vendor Surcharge을 수정
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_rail_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_VNDR_SET A" ).append("\n"); 
		query.append("   SET (FUEL_SCG_AMT, OVR_WGT_SCG_AMT, HZD_MTRL_SCG_AMT, ETC_ADD_AMT, UPD_USR_ID, LOCL_UPD_DT) =" ).append("\n"); 
		query.append("   (SELECT B.FUEL_SCG_AMT, B.OVR_WGT_SCG_AMT, B.HZD_MTRL_SCG_AMT, B.ETC_ADD_AMT, @[sUsrId], GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sOfcCd])" ).append("\n"); 
		query.append("  FROM (SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, SUB_RAIL_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'FSG', SCG_APLY_AMT, 0)) FUEL_SCG_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'OWS', SCG_APLY_AMT, 0)) OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'HZS', SCG_APLY_AMT, 0)) HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'TTL', SCG_APLY_AMT, 0)) ETC_ADD_AMT" ).append("\n"); 
		query.append("          FROM TRS_RAIL_BIL_VNDR_SET_APLY" ).append("\n"); 
		query.append("         WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND TRSP_SO_SEQ		  = @[trsp_so_seq]" ).append("\n"); 
		query.append("           AND SUB_RAIL_SEQ		  = @[sub_rail_seq]" ).append("\n"); 
		query.append("         GROUP BY TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, SUB_RAIL_SEQ" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ		= B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND A.SUB_RAIL_SEQ		= B.SUB_RAIL_SEQ )" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("    SELECT 1" ).append("\n"); 
		query.append("      FROM (SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, SUB_RAIL_SEQ" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'FSG', SCG_APLY_AMT, 0)) FUEL_SCG_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'OWS', SCG_APLY_AMT, 0)) OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'HZS', SCG_APLY_AMT, 0)) HZD_MTRL_SCG_AMT" ).append("\n"); 
		query.append("              ,SUM(DECODE(TRSP_RAIL_SCG_CD, 'TTL', SCG_APLY_AMT, 0)) ETC_ADD_AMT" ).append("\n"); 
		query.append("          FROM TRS_RAIL_BIL_VNDR_SET_APLY" ).append("\n"); 
		query.append("         WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("           AND TRSP_SO_SEQ		  = @[trsp_so_seq]" ).append("\n"); 
		query.append("           AND SUB_RAIL_SEQ		  = @[sub_rail_seq]" ).append("\n"); 
		query.append("         GROUP BY TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ, SUB_RAIL_SEQ" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append(" WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND A.TRSP_SO_SEQ		= B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("   AND A.SUB_RAIL_SEQ		= B.SUB_RAIL_SEQ )" ).append("\n"); 

	}
}