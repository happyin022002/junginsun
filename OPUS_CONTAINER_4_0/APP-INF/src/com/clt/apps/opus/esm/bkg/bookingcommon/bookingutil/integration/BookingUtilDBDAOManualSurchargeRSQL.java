/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingUtilDBDAOManualSurchargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOManualSurchargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.10.13 tariff surcharge 와 무관하게 대상에 잡히도록 한다.(note - PC)
	  * </pre>
	  */
	public BookingUtilDBDAOManualSurchargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOManualSurchargeRSQL").append("\n"); 
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
		query.append("	   DISTINCT BSE.CHG_CD, --적용해야될 charge" ).append("\n"); 
		query.append("	   PRF.CHG_CD PCHG_CD, -- 대상 charge" ).append("\n"); 
		query.append("       PRF.PCT_BSE_CD" ).append("\n"); 
		query.append("       FROM PRI_SCG_PRF PRF--,PRI_SCG_RT RT" ).append("\n"); 
		query.append("         ,  PRI_SCG_PCT_BSE_CHG BSE" ).append("\n"); 
		query.append("WHERE	1=1" ).append("\n"); 
		query.append("AND PRF.SVC_SCP_CD =  @[svc_scp_cd]						-- 부킹의 SVS SCOPE" ).append("\n"); 
		query.append("--AND PRF.SVC_SCP_CD = RT.SVC_SCP_CD" ).append("\n"); 
		query.append("--AND PRF.CHG_CD = RT.CHG_CD" ).append("\n"); 
		query.append("AND PRF.PCT_BSE_CD = BSE.PCT_BSE_CD" ).append("\n"); 
		query.append("--AND TO_DATE( REPLACE([application_date],'-','')  ,'YYYYMMDD') BETWEEN RT.EFF_DT AND RT.EXP_DT  -- Application DT 사용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tax_chgs} != '')" ).append("\n"); 
		query.append("--for tax recalculation" ).append("\n"); 
		query.append("AND PRF.CHG_CD IN ( NULL" ).append("\n"); 
		query.append("       #foreach($tax_chgs IN ${tax_chgs})" ).append("\n"); 
		query.append("           #if ($velocityCount < $tax_chgs.size()) " ).append("\n"); 
		query.append("           , '$tax_chgs'" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           , '$tax_chgs'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tax_cnt_cd} != '')" ).append("\n"); 
		query.append("AND PRF.CHG_CD IN (SELECT CHG_CD FROM MDM_CHARGE WHERE TAX_CNT_CD = @[tax_cnt_cd] and DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${chg_cds} != '')" ).append("\n"); 
		query.append("AND BSE.CHG_CD IN ( NULL" ).append("\n"); 
		query.append("       #foreach($chg_cds IN ${chg_cds})" ).append("\n"); 
		query.append("           #if ($velocityCount < $chg_cds.size()) " ).append("\n"); 
		query.append("           , '$chg_cds'" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           , '$chg_cds'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}