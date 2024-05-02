/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchPortTariffSurchargeDiscountExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchPortTariffSurchargeDiscountExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Port Tariff Surcharge or Discount 존재유무체크
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchPortTariffSurchargeDiscountExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchPortTariffSurchargeDiscountExistRSQL").append("\n"); 
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
		query.append("SELECT    X.YD_CHG_NO" ).append("\n"); 
		query.append("FROM      PSO_YD_CHG        X" ).append("\n"); 
		query.append("       ,  PSO_YD_CHG_XPR    Y" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       X.YD_CHG_NO       = Y.YD_CHG_NO" ).append("\n"); 
		query.append("AND       X.YD_CHG_VER_SEQ  = Y.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("AND       X.CPLS_FLG        = 'Y'" ).append("\n"); 
		query.append("AND       X.YD_CD           = @[yd_cd]	     -- :: Terminal Code :: --" ).append("\n"); 
		query.append("AND       Y.PSO_CHG_TP_CD   IN ('S','D')     -- :: 'S':SURCHARGE, 'D':DISCOUNT :: --" ).append("\n"); 
		query.append("AND       X.EFF_DT          <= SYSDATE" ).append("\n"); 
		query.append("AND       X.EXP_DT          >= SYSDATE" ).append("\n"); 
		query.append("AND       X.YD_CHG_VER_SEQ  = (SELECT   MAX(XX.YD_CHG_VER_SEQ)" ).append("\n"); 
		query.append("                               FROM     PSO_YD_CHG   XX" ).append("\n"); 
		query.append("                               WHERE    1 = 1" ).append("\n"); 
		query.append("                               AND      XX.YD_CHG_NO = X.YD_CHG_NO" ).append("\n"); 
		query.append("                               AND      XX.CPLS_FLG  = 'Y'" ).append("\n"); 
		query.append("                               AND      XX.EFF_DT    <= SYSDATE" ).append("\n"); 
		query.append("                               AND      XX.EXP_DT    >= SYSDATE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 

	}
}