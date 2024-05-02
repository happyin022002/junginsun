/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SetupDBDAOSearchFmsVslCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.20 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.setup.setup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOSearchFmsVslCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search FMS Vessel Info.
	  * </pre>
	  */
	public SetupDBDAOSearchFmsVslCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.setup.setup.integration ").append("\n"); 
		query.append("FileName : SetupDBDAOSearchFmsVslCntrRSQL").append("\n"); 
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
		query.append("SELECT T1.VSL_CD" ).append("\n"); 
		query.append("     ,NVL((SELECT A.OWNR_NM" ).append("\n"); 
		query.append("           FROM   FMS_OWNER A, MDM_VENDOR B" ).append("\n"); 
		query.append("           WHERE  A.OWNR_SEQ = B.FLET_MGMT_OWNR_VNDR_SEQ" ).append("\n"); 
		query.append("           AND    T1.VNDR_SEQ=B.VNDR_SEQ(+)), (SELECT A.OWNR_NM" ).append("\n"); 
		query.append("                                               FROM   FMS_OWNER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                               WHERE  A.OWNR_SEQ = B.FLET_MGMT_OWNR_CUST_SEQ" ).append("\n"); 
		query.append("                                               AND    T1.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("                                               AND    T1.CUST_SEQ = B.CUST_SEQ(+) )) OWNR_NM" ).append("\n"); 
		query.append("     ,TO_CHAR(TO_DATE(VSL_BLD_DT, 'YYYYMMDD'), 'YYYY-MM-DD') VSL_BLD_DT" ).append("\n"); 
		query.append("     ,VSL_DZND_CAPA" ).append("\n"); 
		query.append("     ,BSE_14TON_VSL_CAPA" ).append("\n"); 
		query.append("     ,TO_CHAR(EFF_DT, 'YYYY-MM-DD') FM_DT" ).append("\n"); 
		query.append("     ,TO_CHAR(EXP_DT, 'YYYY-MM-DD') TO_DT" ).append("\n"); 
		query.append("FROM   FMS_CONTRACT T1" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    T1.FLET_CTRT_TP_CD!='TO'" ).append("\n"); 
		query.append("AND    T1.EXP_DT > TO_DATE('2011-08-01', 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND    T1.VSL_CD=@[vsl_cd]" ).append("\n"); 

	}
}