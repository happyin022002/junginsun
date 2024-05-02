/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOModifyPsoYdChgExpDtCplsFlgByNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.15
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2010.09.15 윤진영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon jin young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOModifyPsoYdChgExpDtCplsFlgByNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EXP_DT, CPLS_FLG 업데이트
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOModifyPsoYdChgExpDtCplsFlgByNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cpls_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOModifyPsoYdChgExpDtCplsFlgByNoUSQL").append("\n"); 
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
		query.append("UPDATE PSO_YD_CHG A" ).append("\n"); 
		query.append("SET    A.EXP_DT = NVL(TO_DATE(@[exp_dt], 'YYYYMMDD'), A.EXP_DT)" ).append("\n"); 
		query.append(",A.CPLS_FLG = NVL2(@[cpls_flg]" ).append("\n"); 
		query.append(",DECODE(A.YD_CHG_VER_SEQ, @[yd_chg_ver_seq]" ).append("\n"); 
		query.append(",CASE WHEN @[cpls_flg] IN ('Y','N') THEN @[cpls_flg]" ).append("\n"); 
		query.append("ELSE DECODE(@[cpls_flg], 0, 'N', 1, 'Y')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(",A.CPLS_FLG)" ).append("\n"); 
		query.append(",A.CPLS_FLG)" ).append("\n"); 
		query.append("WHERE  A.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("AND  A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 

	}
}