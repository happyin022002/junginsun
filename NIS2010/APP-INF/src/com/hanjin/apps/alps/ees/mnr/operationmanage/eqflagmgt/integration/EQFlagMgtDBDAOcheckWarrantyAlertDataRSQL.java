/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtDBDAOcheckWarrantyAlertDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.11.16 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungBuebKwon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOcheckWarrantyAlertDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkWarrantyAlertData
	  * </pre>
	  */
	public EQFlagMgtDBDAOcheckWarrantyAlertDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lot_eq_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOcheckWarrantyAlertDataRSQL").append("\n"); 
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
		query.append("SELECT A.FM_SER_NO FROM MNR_EQ_RNG_STS A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.LOT_EQ_PFX_CD = @[lot_eq_pfx_cd]" ).append("\n"); 
		query.append("AND SUBSTRB(A.FM_SER_NO,1,LENGTH(A.FM_SER_NO) -1) = @[fm_ser_no]" ).append("\n"); 
		query.append("AND SUBSTRB(A.TO_SER_NO,1,LENGTH(A.TO_SER_NO) -1) = @[to_ser_no]" ).append("\n"); 
		query.append("AND A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 

	}
}