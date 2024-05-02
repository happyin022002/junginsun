/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DeliveryLocationDBDAOGroupPlaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DeliveryLocationDBDAOGroupPlaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lease Agreement Creation 화면에서 Place validation 체크
	  * </pre>
	  */
	public DeliveryLocationDBDAOGroupPlaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.integration").append("\n"); 
		query.append("FileName : DeliveryLocationDBDAOGroupPlaceRSQL").append("\n"); 
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
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE 'AL'           = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("AND   'ALL'          = @[loc_cd]" ).append("\n"); 
		query.append("AND    ROWNUM   = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM MDM_CONTINENT SUB" ).append("\n"); 
		query.append("WHERE 'CT'          = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("AND    SUB.CONTI_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND    SUB.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("AND    ROWNUM      = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM MDM_SUBCONTINENT SUB" ).append("\n"); 
		query.append("WHERE 'ST'         = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("AND    SUB.SCONTI_CD = @[loc_cd]" ).append("\n"); 
		query.append("AND    SUB.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("AND ROWNUM           = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM MDM_COUNTRY SUB" ).append("\n"); 
		query.append("WHERE 'CN'          = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("AND    SUB.CNT_CD     = @[loc_cd]" ).append("\n"); 
		query.append("AND    SUB.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("AND ROWNUM           = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM MDM_LOCATION SUB" ).append("\n"); 
		query.append("WHERE 'LO'          = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("AND    SUB.LOC_CD     = @[loc_cd]" ).append("\n"); 
		query.append("AND    SUB.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("AND ROWNUM           = 1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("SELECT 'Y'" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append("WHERE DECODE(@[eq_loc_tp_cd], 'RC', SUB.RCC_CD" ).append("\n"); 
		query.append("                            , 'LC', SUB.LCC_CD" ).append("\n"); 
		query.append("                            , 'EC', SUB.ECC_CD" ).append("\n"); 
		query.append("                            , 'SC', SUB.SCC_CD" ).append("\n"); 
		query.append("                            , 'XXXXX') = @[loc_cd]" ).append("\n"); 
		query.append("AND    SUB.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("AND ROWNUM   = 1" ).append("\n"); 

	}
}