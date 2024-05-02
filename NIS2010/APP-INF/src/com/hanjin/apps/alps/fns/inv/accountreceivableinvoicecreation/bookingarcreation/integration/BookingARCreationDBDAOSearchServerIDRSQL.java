/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchServerIDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchServerIDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchServerIDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchServerIDRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CONTI_CD, 'F', DECODE(AR_HD_QTR_OFC_CD, 'SINRS', 'SWA', SYS_AREA_GRP_ID), " ).append("\n"); 
		query.append("                             DECODE(SYS_AREA_GRP_ID, 'ENT', 'KOR', 'KOR', DECODE(SUBSTR(LOC_CD, 1, 2), 'JP', 'JPN', 'KOR'), SYS_AREA_GRP_ID)" ).append("\n"); 
		query.append("                            ) SVR_ID" ).append("\n"); 
		query.append("FROM (  " ).append("\n"); 
		query.append("       SELECT ML.CONTI_CD, MO.LOC_CD, MO.AR_OFC_CD, MO.AR_HD_QTR_OFC_CD, CS.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("       FROM   MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("              MDM_LOCATION ML," ).append("\n"); 
		query.append("              COM_SYS_AREA_GRP_ID CS" ).append("\n"); 
		query.append("       WHERE  MO.LOC_CD = ML.LOC_CD" ).append("\n"); 
		query.append("       AND    SUBSTR(MO.LOC_CD,1,2) = CS.CNT_CD" ).append("\n"); 
		query.append("       AND    CS.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("       AND    MO.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}