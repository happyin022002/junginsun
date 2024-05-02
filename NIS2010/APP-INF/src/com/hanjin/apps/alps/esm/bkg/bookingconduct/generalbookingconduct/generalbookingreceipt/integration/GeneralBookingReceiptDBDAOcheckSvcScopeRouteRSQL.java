/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcheckSvcScopeRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.27
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.11.27 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcheckSvcScopeRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * service scope과 route를 비교해서 맞는게 있는지 확인한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcheckSvcScopeRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcheckSvcScopeRouteRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN MULTI.CNT > 0 OR SINGLE.CNT > 0 THEN 1" ).append("\n"); 
		query.append("	   ELSE 0 END CNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("	   (SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("		  FROM MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("		     , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("		     , MDM_SVC_SCP_LANE LANE" ).append("\n"); 
		query.append("		     , MDM_LOCATION POR" ).append("\n"); 
		query.append("		     , MDM_LOCATION DEL" ).append("\n"); 
		query.append("		 WHERE POR.LOC_CD           = @[por_cd]" ).append("\n"); 
		query.append("		   AND DEL.LOC_CD           = @[del_cd]" ).append("\n"); 
		query.append("		   AND ORG.RGN_CD           = POR.RGN_CD" ).append("\n"); 
		query.append("		   AND ORG.ORG_DEST_CD      = 'O'" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_IND_FLG  = 'Y'" ).append("\n"); 
		query.append("		   AND ORG.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("		   AND DEST.RGN_CD          = DEL.RGN_CD" ).append("\n"); 
		query.append("		   AND DEST.ORG_DEST_CD     = 'D'" ).append("\n"); 
		query.append("		   AND DEST.SVC_SCP_IND_FLG = 'Y'" ).append("\n"); 
		query.append("		   AND DEST.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = LANE.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = LANE.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND DEST.SVC_SCP_CD      = LANE.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND LANE.VSL_SLAN_CD     = @[trnk_lane_cd]" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = @[svc_scp_cd]) MULTI" ).append("\n"); 
		query.append("     , (SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("		  FROM MDM_SVC_SCP_LMT ORG" ).append("\n"); 
		query.append("		     , MDM_SVC_SCP_LMT DEST" ).append("\n"); 
		query.append("		     , MDM_SVC_SCP_LANE LANE" ).append("\n"); 
		query.append("		     , MDM_LOCATION POR" ).append("\n"); 
		query.append("		     , MDM_LOCATION DEL" ).append("\n"); 
		query.append("		 WHERE POR.LOC_CD           = @[por_cd]" ).append("\n"); 
		query.append("		   AND DEL.LOC_CD           = @[del_cd]" ).append("\n"); 
		query.append("		   AND ORG.RGN_CD           = POR.RGN_CD" ).append("\n"); 
		query.append("		   AND ORG.ORG_DEST_CD      = 'O'" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_IND_FLG  = 'Y'" ).append("\n"); 
		query.append("		   AND ORG.DELT_FLG         = 'N'" ).append("\n"); 
		query.append("		   AND DEST.RGN_CD          = DEL.RGN_CD" ).append("\n"); 
		query.append("		   AND DEST.ORG_DEST_CD     = 'D'" ).append("\n"); 
		query.append("		   AND DEST.SVC_SCP_IND_FLG = 'Y'" ).append("\n"); 
		query.append("		   AND DEST.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = DEST.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = LANE.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = LANE.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND DEST.SVC_SCP_CD      = LANE.SVC_SCP_CD" ).append("\n"); 
		query.append("		   AND ORG.SVC_SCP_CD       = @[svc_scp_cd]) SINGLE" ).append("\n"); 

	}
}