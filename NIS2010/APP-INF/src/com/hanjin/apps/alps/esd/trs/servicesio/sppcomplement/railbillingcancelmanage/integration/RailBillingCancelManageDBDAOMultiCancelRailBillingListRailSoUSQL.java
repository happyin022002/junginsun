/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.11.12 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rail So 정보 변경
	  * </pre>
	  */
	public RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxlRqstRsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trspSoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.integration").append("\n"); 
		query.append("FileName : RailBillingCancelManageDBDAOMultiCancelRailBillingListRailSoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("SET DELT_FLG = 'Y'," ).append("\n"); 
		query.append("UPD_USR_ID = 'SPP_IF'," ).append("\n"); 
		query.append("LOCL_UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofcCd])," ).append("\n"); 
		query.append("CXL_RQST_FLG = 'Y'," ).append("\n"); 
		query.append("CXL_RQST_RSN = @[cxlRqstRsn]," ).append("\n"); 
		query.append("CXL_RQST_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofcCd])" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trspSoOfcCtyCd]" ).append("\n"); 
		query.append("AND   TRSP_SO_SEQ = @[trspSoSeq]" ).append("\n"); 

	}
}