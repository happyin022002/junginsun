/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChargeCalculationDBDAOCheckEDOChargeFreeTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.11.28 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOCheckEDOChargeFreeTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 계산된 Charge정보중 Free Time date 정보를  BKG의  F/T Date 와 비교하여 변경 여부를 check 함.
	  * </pre>
	  */
	public ChargeCalculationDBDAOCheckEDOChargeFreeTimeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOCheckEDOChargeFreeTimeRSQL").append("\n"); 
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
		query.append("#if (${ft_end_dt} != '')	" ).append("\n"); 
		query.append("SELECT  NVL(MAX(DECODE(TO_CHAR(CRNT_DEM_FT_END_DT,'YYYYMMDD'), NVL(SUBSTR(REPLACE(@[ft_end_dt],'-', ''),1,8),TO_CHAR(CRNT_DEM_FT_END_DT,'YYYYMMDD')),'N','Y')),'Y')" ).append("\n"); 
		query.append("FROM   BKG_EDO_DEM_HIS" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    EDO_HIS_SEQ = (SELECT MAX(EDO_HIS_SEQ) " ).append("\n"); 
		query.append("                   FROM   BKG_EDO_DEM_HIS " ).append("\n"); 
		query.append("                   WHERE  BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("                   AND    CNTR_NO = @[cntr_no] ) " ).append("\n"); 
		query.append("AND    CNTR_NO =@[cntr_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 'N' FROM DUAL " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}