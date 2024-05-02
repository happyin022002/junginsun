/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeDBDAOMdmChgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.22 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.charge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeDBDAOMdmChgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChargeDBDAOMdmChgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rev_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.charge.integration").append("\n"); 
		query.append("FileName : ChargeDBDAOMdmChgVORSQL").append("\n"); 
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
		query.append("SELECT CHG_CD" ).append("\n"); 
		query.append("     , CHG_NM" ).append("\n"); 
		query.append("     , FRT_CHG_TP_CD" ).append("\n"); 
		query.append("     , REP_CHG_CD" ).append("\n"); 
		query.append("     , CHG_REV_TP_CD" ).append("\n"); 
		query.append("     , CHG_APLY_TP_CD" ).append("\n"); 
		query.append("     , DECODE(AUTO_RAT_FLG, 'Y', 'YES', 'N', 'NO') AS AUTO_RAT_FLG" ).append("\n"); 
		query.append("     , DECODE(DELT_FLG, 'Y', 'YES', 'N', 'NO') AS DELT_FLG" ).append("\n"); 
		query.append("	 , CO_CHG_ACCT_CD" ).append("\n"); 
		query.append("  FROM MDM_CHARGE" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${chg_cd} != '') " ).append("\n"); 
		query.append("   AND CHG_CD LIKE @[chg_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frt_chg_tp_cd} != '') " ).append("\n"); 
		query.append("   AND FRT_CHG_TP_CD = @[frt_chg_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rep_chg_cd} != '') " ).append("\n"); 
		query.append("   AND REP_CHG_CD = @[rep_chg_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${chg_rev_tp_cd} != '') " ).append("\n"); 
		query.append("   AND CHG_REV_TP_CD = @[chg_rev_tp_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${chg_aply_tp_cd} != '') " ).append("\n"); 
		query.append("   AND CHG_APLY_TP_CD = @[chg_aply_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}