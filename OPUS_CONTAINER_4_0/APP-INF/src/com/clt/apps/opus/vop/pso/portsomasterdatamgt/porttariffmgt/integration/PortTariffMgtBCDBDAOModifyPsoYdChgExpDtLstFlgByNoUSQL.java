/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOModifyPsoYdChgExpDtLstFlgByNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.11.16 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOModifyPsoYdChgExpDtLstFlgByNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG Version_Up 시, LST_FLG 값 업데이트
	  * PSO_YD_CHG To_Date 변경시 동일 No 값 변경
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOModifyPsoYdChgExpDtLstFlgByNoUSQL(){
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
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOModifyPsoYdChgExpDtLstFlgByNoUSQL").append("\n"); 
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
		query.append("UPDATE PSO_YD_CHG" ).append("\n"); 
		query.append("SET    EXP_DT = NVL(TO_DATE(@[exp_dt], 'YYYYMMDD'), EXP_DT)" ).append("\n"); 
		query.append(",LST_FLG = (CASE WHEN YD_CHG_VER_SEQ = (SELECT MAX(YD_CHG_VER_SEQ)" ).append("\n"); 
		query.append("FROM PSO_YD_CHG" ).append("\n"); 
		query.append("WHERE YD_CHG_NO = @[yd_chg_no])" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE NULL" ).append("\n"); 
		query.append("END)" ).append("\n"); 
		query.append("WHERE  YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 

	}
}