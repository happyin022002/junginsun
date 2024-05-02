/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOAddVVDExRateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOAddVVDExRateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOAddVVDExRateCSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOAddVVDExRateCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcl_curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOAddVVDExRateCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_VVD_XCH_RT(" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	CHG_CURR_CD " ).append("\n"); 
		query.append(",	AR_OFC_CD" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	IVS_XCH_RT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") (" ).append("\n"); 
		query.append("SELECT @[vsl]" ).append("\n"); 
		query.append("     , @[voy]" ).append("\n"); 
		query.append("     , @[dep]" ).append("\n"); 
		query.append("     , DECODE(SUBSTR(@[bnd],1,1), 'O', @[pol], @[pod])" ).append("\n"); 
		query.append("     , @[svc_scp]" ).append("\n"); 
		query.append("     , SUBSTR(@[bnd],1,1)" ).append("\n"); 
		query.append("     , @[lcl_curr]" ).append("\n"); 
		query.append("     , @[curr]" ).append("\n"); 
		query.append("     , @[ofc_cd]" ).append("\n"); 
		query.append("     , 0" ).append("\n"); 
		query.append("     , 0" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 
		query.append("WHERE NOT EXISTS ( SELECT 1 " ).append("\n"); 
		query.append("                     FROM INV_VVD_XCH_RT" ).append("\n"); 
		query.append("                    WHERE VSL_CD = @[vsl]" ).append("\n"); 
		query.append("                      AND SKD_VOY_NO = @[voy]" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD = @[dep]" ).append("\n"); 
		query.append("                      AND PORT_CD = DECODE(SUBSTR(@[bnd],1,1), 'O', @[pol], @[pod])" ).append("\n"); 
		query.append("                      AND LOCL_CURR_CD = @[lcl_curr]" ).append("\n"); 
		query.append("                      AND CHG_CURR_CD = @[curr]" ).append("\n"); 
		query.append("					  AND AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("                      AND SVC_SCP_CD  = @[svc_scp]" ).append("\n"); 
		query.append("                      AND IO_BND_CD = SUBSTR(@[bnd],1,1))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}