/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderMainDBDAOSearchTrsSvcOrdForScheduleApptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOSearchTrsSvcOrdForScheduleApptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOSearchTrsSvcOrdForScheduleAppt
	  * </pre>
	  */
	public WorkOrderMainDBDAOSearchTrsSvcOrdForScheduleApptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration ").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOSearchTrsSvcOrdForScheduleApptRSQL").append("\n"); 
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
		query.append("SELECT SO.BKG_NO" ).append("\n"); 
		query.append("      ,SO.TRO_SEQ" ).append("\n"); 
		query.append("      ,SO.TRO_SUB_SEQ" ).append("\n"); 
		query.append("      ,SO.TRSP_BND_CD" ).append("\n"); 
		query.append("      ,SO.COP_NO" ).append("\n"); 
		query.append("      ,HDR.PCTL_NO" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("      ,SCE_COP_HDR      HDR" ).append("\n"); 
		query.append(" WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND SO.COP_NO = HDR.COP_NO(+)" ).append("\n"); 

	}
}