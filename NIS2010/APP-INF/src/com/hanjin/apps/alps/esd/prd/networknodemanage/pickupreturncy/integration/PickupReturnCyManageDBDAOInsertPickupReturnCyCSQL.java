/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PickupReturnCyManageDBDAOInsertPickupReturnCyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickupReturnCyManageDBDAOInsertPickupReturnCyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InsertPickupReturnCy
	  * 2010.10.1 채창호 CHM-201006135-01 Pick Up & Return CY Export 화면 수정 요청
	  * </pre>
	  */
	public PickupReturnCyManageDBDAOInsertPickupReturnCyCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pickup_cy",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.integration").append("\n"); 
		query.append("FileName : PickupReturnCyManageDBDAOInsertPickupReturnCyCSQL").append("\n"); 
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
		query.append("INSERT INTO prd_pkup_rtn_yd" ).append("\n"); 
		query.append("(POR_DEL_CD, POL_POD_CD,VSL_SLAN_CD,IO_BND_CD ,SPCL_CGO_CD,MTY_PKUP_RTN_YD_CD ,DELT_FLG,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("VALUES(@[por_del], @[pol_pod], @[lane_code], @[bound_code], @[cargo_type], @[pickup_cy], 'N', @[user_id], SYSDATE, @[user_id], SYSDATE)" ).append("\n"); 

	}
}