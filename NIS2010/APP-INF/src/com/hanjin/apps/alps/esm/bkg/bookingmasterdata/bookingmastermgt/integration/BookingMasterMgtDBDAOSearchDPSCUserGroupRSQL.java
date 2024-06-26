/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchDPSCUserGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.06
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.10.06 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchDPSCUserGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DPCS - S/R 업무처리 담당자 Group 정보를 Searchg한다
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchDPSCUserGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpcs_wrk_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchDPSCUserGroupRSQL").append("\n"); 
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
		query.append("	USR_ID" ).append("\n"); 
		query.append(",  (SELECT C.USR_NM FROM COM_USER C WHERE C.USR_ID = G.USR_ID) USR_NM" ).append("\n"); 
		query.append(",	DPCS_WRK_GRP_CD" ).append("\n"); 
		query.append(",	DPCS_PSN_CD" ).append("\n"); 
		query.append(",	DPCS_WRK_PRT_CD" ).append("\n"); 
		query.append(",	DPCS_WRK_SVR_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	to_char(CRE_DT,'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	to_char(UPD_DT,'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_DPCS_USR_GRP G" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND     DPCS_WRK_GRP_CD <> 'S'" ).append("\n"); 
		query.append("#if (${usr_id} != '')   " ).append("\n"); 
		query.append("AND ((USR_ID) LIKE @[usr_id] || '%')" ).append("\n"); 
		query.append("OR ((USR_ID) LIKE lower(@[usr_id]) || '%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dpcs_wrk_grp_cd} != '') " ).append("\n"); 
		query.append("AND	DPCS_WRK_GRP_CD = @[dpcs_wrk_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY USR_ID" ).append("\n"); 
		query.append(",	DPCS_WRK_GRP_CD" ).append("\n"); 

	}
}