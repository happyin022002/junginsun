/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchVendorByYardAndCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchVendorByYardAndCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchVendorByYardAndCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uid",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchVendorByYardAndCostRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       B.VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.VNDR_LGL_ENG_NM    " ).append("\n"); 
		query.append("FROM   PSO_YD_CHG     A" ).append("\n"); 
		query.append("      ,MDM_VENDOR     B      " ).append("\n"); 
		query.append("      ,PSO_YD_CHG_XPR C" ).append("\n"); 
		query.append("      ,PSO_CHG_XPR    D  " ).append("\n"); 
		query.append("	  , TES_LGS_COST E" ).append("\n"); 
		query.append("      , MDM_ACCOUNT  F" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("#if(${acct_cd} == '' && ${lgs_cost_cd} != '')" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD = @[lgs_cost_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${year} != '')" ).append("\n"); 
		query.append("--AND    A.EFF_DT >= TO_DATE(LPAD(*year,   4, 0) || '0101', 'YYYYMMDD')" ).append("\n"); 
		query.append("--AND    A.EFF_DT <  TO_DATE(LPAD(*year+1, 4, 0) || '0101', 'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A.EFF_DT <= TO_DATE(LPAD(${year}, 4, 0) || '1231', 'YYYYMMDD')    -- end_dt" ).append("\n"); 
		query.append("AND    A.EXP_DT >= TO_DATE(LPAD(${year}, 4, 0) || '0101', 'YYYYMMDD')    -- start_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND    A.YD_CHG_NO = C.YD_CHG_NO" ).append("\n"); 
		query.append("AND    A.YD_CHG_VER_SEQ = C.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("AND    D.CHG_XPR_NO = C.CHG_XPR_NO" ).append("\n"); 
		query.append("AND    C.PSO_CHG_TP_CD = 'B'" ).append("\n"); 
		query.append("AND    D.UPD_MNU_NO = DECODE(@[uid], '0002', 1, '0004', 2) -- 0002화면이면 1, 0004이면 2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    E.ACCT_CD = F.ACCT_CD" ).append("\n"); 
		query.append("AND    E.LGS_COST_SUBJ_CD IN ('PT', 'CN')" ).append("\n"); 
		query.append("AND    E.LGS_COST_CD_CLSS_LVL = 'A'" ).append("\n"); 
		query.append("#if(${acct_cd} != '')" ).append("\n"); 
		query.append("AND    E.ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    A.LGS_COST_CD = E.LGS_COST_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY 2" ).append("\n"); 

	}
}