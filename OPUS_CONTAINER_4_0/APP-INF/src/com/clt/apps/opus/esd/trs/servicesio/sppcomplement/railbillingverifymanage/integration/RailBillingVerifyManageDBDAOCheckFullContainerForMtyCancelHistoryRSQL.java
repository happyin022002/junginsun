/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckFullContainerForMtyCancelHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.16
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.16 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckFullContainerForMtyCancelHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI CANCEL 후 사용 가능한 MTY CONTAINER 조회 SQL
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckFullContainerForMtyCancelHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckFullContainerForMtyCancelHistoryRSQL").append("\n"); 
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
		query.append("    COUNT(X.TRSP_SO_SEQ) MTY_CANCEL_CNT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    TRS_TRSP_RAIL_BIL_ORD X," ).append("\n"); 
		query.append("    TRS_TRSP_EDI_RAIL_ORD Y" ).append("\n"); 
		query.append("WHERE X.TRSP_SO_OFC_CTY_CD = Y.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   X.TRSP_SO_SEQ = Y.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   X.BIL_ISS_KNT = Y.BIL_ISS_KNT" ).append("\n"); 
		query.append("AND   X.EQ_NO = @[eqNo]" ).append("\n"); 
		query.append("AND   X.CGO_TP_CD = 'M'" ).append("\n"); 
		query.append("AND   ((Y.BIL_ISS_STS_CD = 'X'" ).append("\n"); 
		query.append("            AND Y.BIL_EDI_SNT_DT >= (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC('CHIBB') - 0.5/24) )" ).append("\n"); 
		query.append("        OR X.CXL_RQST_FLG = 'Y' )" ).append("\n"); 

	}
}